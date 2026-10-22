package com.bytedance.retrofit2.mime;

import com.bytedance.rpc.internal.RpcUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

/* JADX INFO: loaded from: classes2.dex */
public final class MultipartTypedOutput implements TypedOutput {
    public static final String DEFAULT_TRANSFER_ENCODING = "binary";
    private final String boundary;
    private final byte[] footer;
    private long length;
    private final List<MimePart> mimeParts;

    private static final class MimePart {
        private final TypedOutput body;
        private final String boundary;
        private boolean isBuilt;
        private final boolean isFirst;
        private final String name;
        private byte[] partBoundary;
        private byte[] partHeader;
        private final String transferEncoding;

        public MimePart(String r3, String r4, TypedOutput r5, String r6, boolean r7) {
            TypedOutput r8 = (TypedOutput) ZeusTransformUtils.wrapperContextForParams(r5, TypedOutput.class, "com.obric.memorydata.plugin");
            this.name = r3;
            this.transferEncoding = r4;
            this.body = r8;
            this.isFirst = r7;
            this.boundary = r6;
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

        public void writeTo(OutputStream r2) {
            build();
            r2.write(this.partBoundary);
            r2.write(this.partHeader);
            this.body.writeTo(r2);
        }
    }

    public MultipartTypedOutput() {
        this(UUID.randomUUID().toString());
    }

    MultipartTypedOutput(String r3) {
        this.mimeParts = new LinkedList();
        this.boundary = r3;
        byte[] r4 = buildBoundary(r3, false, true);
        this.footer = r4;
        this.length = r4.length;
    }

    static /* synthetic */ byte[] access$000(String r0, boolean r1, boolean r2) {
        return buildBoundary(r0, r1, r2);
    }

    static /* synthetic */ byte[] access$100(String r2, String r3, TypedOutput r4) {
        return buildHeader(r2, r3, (TypedOutput) ZeusTransformUtils.wrapperContextForParams(r4, TypedOutput.class, "com.obric.memorydata.plugin"));
    }

    private static byte[] buildBoundary(String r3, boolean r4, boolean r5) {
        StringBuilder r1 = new StringBuilder(r3.length() + 8);     // Catch: IOException -> L12
        if (r4 == true) goto L7;
        r1.append("\r\n");     // Catch: IOException -> L12
    L7:
        r1.append("--");     // Catch: IOException -> L12
        r1.append(r3);     // Catch: IOException -> L12
        if (r5 == false) goto L10;
        r1.append("--");     // Catch: IOException -> L12
    L10:
        r1.append("\r\n");     // Catch: IOException -> L12
        return r1.toString().getBytes(RpcUtils.CHARSET_UTF8);
    L12:
        e = move-exception;
        throw new RuntimeException("Unable to write multipart boundary", e);
    }

    private static byte[] buildHeader(String r5, String r6, TypedOutput r7) {
        TypedOutput r8 = (TypedOutput) ZeusTransformUtils.wrapperContextForParams(r7, TypedOutput.class, "com.obric.memorydata.plugin");
        StringBuilder r0 = new StringBuilder(128);     // Catch: IOException -> L11
        r0.append("Content-Disposition: form-data; name=\"");     // Catch: IOException -> L11
        r0.append(r5);     // Catch: IOException -> L11
        String r9 = r8.fileName();     // Catch: IOException -> L11
        if (r9 == null) goto L6;
        r0.append("\"; filename=\"");     // Catch: IOException -> L11
        r0.append(r9);     // Catch: IOException -> L11
    L6:
        r0.append("\"\r\nContent-Type: ");     // Catch: IOException -> L11
        r0.append(r8.mimeType());     // Catch: IOException -> L11
        long r1 = r8.length();     // Catch: IOException -> L11
        if (r1 == (-1)) goto L9;
        r0.append("\r\nContent-Length: ").append(r1);     // Catch: IOException -> L11
    L9:
        r0.append("\r\nContent-Transfer-Encoding: ");     // Catch: IOException -> L11
        r0.append(r6);     // Catch: IOException -> L11
        r0.append("\r\n\r\n");     // Catch: IOException -> L11
        return r0.toString().getBytes(RpcUtils.CHARSET_UTF8);
    L11:
        e = move-exception;
        throw new RuntimeException("Unable to write multipart header", e);
    }

    public void addPart(String r3, TypedOutput r4) {
        addPart(r3, DEFAULT_TRANSFER_ENCODING, (TypedOutput) ZeusTransformUtils.wrapperContextForParams(r4, TypedOutput.class, "com.obric.memorydata.plugin"));
    }

    public void addPart(String r7, String r8, TypedOutput r9) {
        TypedOutput r3 = (TypedOutput) ZeusTransformUtils.wrapperContextForParams(r9, TypedOutput.class, "com.obric.memorydata.plugin");
        Objects.requireNonNull(r7, "Part name must not be null.");
        Objects.requireNonNull(r8, "Transfer encoding must not be null.");
        Objects.requireNonNull(r3, "Part body must not be null.");
        MimePart r10 = new MimePart(r7, r8, r3, this.boundary, this.mimeParts.isEmpty());
        this.mimeParts.add(r10);
        long r11 = r10.size();
        if (r11 != (-1)) goto L5;
        this.length = -1;
        return;
    L5:
        long r2 = this.length;
        if (r2 == (-1)) goto L10;
        this.length = r2 + r11;
        return;
    }

    @Override // com.bytedance.retrofit2.mime.TypedOutput
    public String fileName() {
        return null;
    }

    public int getPartCount() {
        return this.mimeParts.size();
    }

    List<byte[]> getParts() {
        ArrayList r0 = new ArrayList(this.mimeParts.size());
        Iterator<MimePart> r4 = this.mimeParts.iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        MimePart r1 = (MimePart) ZeusTransformUtils.preCheckCast(r4.next(), MimePart.class, "com.obric.memorydata.plugin");
        ByteArrayOutputStream r2 = new ByteArrayOutputStream();
        r1.writeTo(r2);
        r0.add(r2.toByteArray());
        goto L4
    L6:
        return r0;
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
        ByteArrayOutputStream r0 = new ByteArrayOutputStream();     // Catch: Throwable -> L12
        writeTo(r0);     // Catch: Throwable -> L11
        ByteArrayInputStream r4 = new ByteArrayInputStream(r0.toByteArray());     // Catch: Throwable -> L11
        String r1 = DigestUtil.md5Hex(r4);     // Catch: Throwable -> L20
        r0.close();     // Catch: Throwable -> L18
    L27:
        r4.close();     // Catch: Throwable -> L19
    L10:
        return r1;
    L13:
        if (r0 != null) goto L35;
    L15:
        if (r4 != null) goto L25;
    L17:
        return null;
    L25:
        r4.close();     // Catch: Throwable -> L22
        goto L17
    L35:
        r0.close();     // Catch: Throwable -> L21
    L11:
        r4 = null;
    L12:
        r4 = null;
        r0 = null;
        goto L13
    }

    @Override // com.bytedance.retrofit2.mime.TypedOutput
    public String mimeType() {
        return "multipart/form-data; boundary=" + this.boundary;
    }

    @Override // com.bytedance.retrofit2.mime.TypedOutput
    public void writeTo(OutputStream r5) {
        Iterator<MimePart> r0 = this.mimeParts.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((MimePart) ZeusTransformUtils.preCheckCast(r0.next(), MimePart.class, "com.obric.memorydata.plugin")).writeTo(r5);
        goto L4
    L6:
        r5.write(this.footer);
    }
}
