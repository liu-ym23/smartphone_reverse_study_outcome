package com.bytedance.retrofit2.mime;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
public final class MultipartTypedOutput implements TypedOutput {
    public static final String DEFAULT_TRANSFER_ENCODING = "binary";
    private final String boundary;
    private final byte[] footer;
    private long length;
    private final List<MimePart> mimeParts;

    public static final class MimePart {
        private final TypedOutput body;
        private final String boundary;
        private boolean isBuilt;
        private final boolean isFirst;
        private final String name;
        private byte[] partBoundary;
        private byte[] partHeader;
        private final String transferEncoding;

        public MimePart(String r8, String r10, TypedOutput r11, String r12, boolean r13) {
            this.name = r8;
            this.transferEncoding = r10;
            this.body = r11;
            this.isFirst = r13;
            this.boundary = r12;
        }

        private void build() {
            if (this.isBuilt == false) goto L5;
            return;
        L5:
            this.partBoundary = MultipartTypedOutput.access$000(this.boundary, this.isFirst, false);
            this.partHeader = MultipartTypedOutput.access$100(this.name, this.transferEncoding, this.body);
            this.isBuilt = true;
        }

        public long size() {
            build();
            if (this.body.length() > (-1)) goto L5;
            return -1;
        L5:
            return (this.body.length() + ((long) this.partBoundary.length)) + ((long) this.partHeader.length);
        }

        public void writeTo(OutputStream r8) {
            build();
            r8.write(this.partBoundary);
            r8.write(this.partHeader);
            this.body.writeTo(r8);
        }
    }

    public MultipartTypedOutput() {
        this(UUID.randomUUID().toString());
    }

    public static /* synthetic */ byte[] access$000(String r8, boolean r10, boolean r11) {
        return buildBoundary(r8, r10, r11);
    }

    public static /* synthetic */ byte[] access$100(String r8, String r10, TypedOutput r11) {
        return buildHeader(r8, r10, r11);
    }

    private static byte[] buildBoundary(String r8, boolean r10, boolean r11) {
        StringBuilder r12 = new StringBuilder(r8.length() + 8);     // Catch: IOException -> L12
        if (r10 == true) goto L7;
        r12.append("\r\n");     // Catch: IOException -> L12
    L7:
        r12.append("--");     // Catch: IOException -> L12
        r12.append(r8);     // Catch: IOException -> L12
        if (r11 == false) goto L10;
        r12.append("--");     // Catch: IOException -> L12
    L10:
        r12.append("\r\n");     // Catch: IOException -> L12
        return r12.toString().getBytes("UTF-8");
    L12:
        e = move-exception;
        throw new RuntimeException("Unable to write multipart boundary", e);
    }

    private static byte[] buildHeader(String r8, String r10, TypedOutput r11) {
        StringBuilder r12 = new StringBuilder(128);     // Catch: IOException -> L10
        r12.append("Content-Disposition: form-data; name=\"");     // Catch: IOException -> L10
        r12.append(r8);     // Catch: IOException -> L10
        String r13 = r11.fileName();     // Catch: IOException -> L10
        if (r13 == null) goto L5;
        r12.append("\"; filename=\"");     // Catch: IOException -> L10
        r12.append(r13);     // Catch: IOException -> L10
    L5:
        r12.append("\"\r\nContent-Type: ");     // Catch: IOException -> L10
        r12.append(r11.mimeType());     // Catch: IOException -> L10
        long r14 = r11.length();     // Catch: IOException -> L10
        if (r14 == (-1)) goto L8;
        r12.append("\r\nContent-Length: ");     // Catch: IOException -> L10
        r12.append(r14);     // Catch: IOException -> L10
    L8:
        r12.append("\r\nContent-Transfer-Encoding: ");     // Catch: IOException -> L10
        r12.append(r10);     // Catch: IOException -> L10
        r12.append("\r\n\r\n");     // Catch: IOException -> L10
        return r12.toString().getBytes("UTF-8");
    L10:
        e = move-exception;
        throw new RuntimeException("Unable to write multipart header", e);
    }

    public void addPart(String r8, TypedOutput r10) {
        addPart(r8, DEFAULT_TRANSFER_ENCODING, r10);
    }

    @Override // com.bytedance.retrofit2.mime.TypedOutput
    public String fileName() {
        return null;
    }

    public int getPartCount() {
        return this.mimeParts.size();
    }

    public List<byte[]> getParts() {
        ArrayList r8 = new ArrayList(this.mimeParts.size());
        Iterator<MimePart> r10 = this.mimeParts.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        MimePart r11 = r10.next();
        ByteArrayOutputStream r12 = new ByteArrayOutputStream();
        r11.writeTo(r12);
        r8.add(r12.toByteArray());
        goto L4
    L6:
        return r8;
    }

    @Override // com.bytedance.retrofit2.mime.TypedOutput
    public long length() {
        return this.length;
    }

    @Override // com.bytedance.retrofit2.mime.TypedOutput
    public String md5Stub() {
        if (this.length != (-1)) goto L31;
        return null;
    L31:
        ByteArrayOutputStream r8 = new ByteArrayOutputStream();     // Catch: Throwable -> L12
        writeTo(r8);     // Catch: Throwable -> L11
        ByteArrayInputStream r10 = new ByteArrayInputStream(r8.toByteArray());     // Catch: Throwable -> L11
        String r11 = DigestUtil.md5Hex(r10);     // Catch: Throwable -> L20
        r8.close();     // Catch: Throwable -> L18
    L27:
        r10.close();     // Catch: Throwable -> L19
    L10:
        return r11;
    L13:
        if (r8 != null) goto L35;
    L15:
        if (r10 != null) goto L25;
    L17:
        return null;
    L25:
        r10.close();     // Catch: Throwable -> L22
        goto L17
    L35:
        r8.close();     // Catch: Throwable -> L21
    L11:
        r10 = null;
    L12:
        r10 = null;
        r8 = null;
        goto L13
    }

    @Override // com.bytedance.retrofit2.mime.TypedOutput
    public String mimeType() {
        return "multipart/form-data; boundary=" + this.boundary;
    }

    @Override // com.bytedance.retrofit2.mime.TypedOutput
    public void writeTo(OutputStream r8) {
        Iterator<MimePart> r10 = this.mimeParts.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        r10.next().writeTo(r8);
        goto L4
    L6:
        r8.write(this.footer);
    }

    public MultipartTypedOutput(String r8) {
        this.mimeParts = new LinkedList();
        this.boundary = r8;
        byte[] r10 = buildBoundary(r8, false, true);
        this.footer = r10;
        this.length = r10.length;
    }

    public void addPart(String r8, String r10, TypedOutput r11) {
        if (r8 == null) goto L17;
        if (r10 == null) goto L15;
        if (r11 == null) goto L13;
        MimePart r12 = new MimePart(r8, r10, r11, this.boundary, this.mimeParts.isEmpty());
        this.mimeParts.add(r12);
        long r13 = r12.size();
        if (r13 != (-1)) goto L8;
        this.length = -1;
        return;
    L8:
        long r14 = this.length;
        if (r14 == (-1)) goto L19;
        this.length = r14 + r13;
        return;
    L19:
        return;
    L13:
        throw new NullPointerException("Part body must not be null.");
    L15:
        throw new NullPointerException("Transfer encoding must not be null.");
    L17:
        throw new NullPointerException("Part name must not be null.");
    }
}
