package com.bytedance.retrofit2.mime;

import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class TypedFile implements TypedInput, TypedOutput {
    private static final int BUFFER_SIZE = 4096;
    private final File file;
    private final String mimeType;

    public String md5Stub() {
        return null;
    }

    public String fileName() {
        return this.file.getName();
    }

    public int hashCode() {
        return this.file.hashCode();
    }

    public InputStream in() throws IOException {
        return new PolarisFileInputStreamWrapper(this.file);
    }

    public long length() {
        return this.file.length();
    }

    public String toString() {
        return this.file.getAbsolutePath() + " (" + mimeType() + ")";
    }

    public File file() {
        return this.file;
    }

    public String mimeType() {
        return this.mimeType;
    }

    public boolean equals(Object r2) {
        if (this != r2) goto L6;
        return true;
    L6:
        if ((r2 instanceof TypedFile) == true) goto L8;
        return false;
    L8:
        return this.file.equals(((TypedFile) r2).file);
    }

    public void moveTo(TypedFile r3) throws IOException {
        if (mimeType().equals(r3.mimeType()) == false) goto L10;
        if (this.file.renameTo(r3.file()) == false) goto L8;
        return;
    L8:
        throw new IOException("Rename failed!");
    L10:
        throw new IOException("Type mismatch.");
    }

    public void writeTo(OutputStream r5) throws IOException {
        byte[] r0 = new byte[BUFFER_SIZE];
        PolarisFileInputStreamWrapper r1 = new PolarisFileInputStreamWrapper(this.file);
    L12:
        int r2 = r1.read(r0);     // Catch: Throwable -> L9
        if (r2 == (-1)) goto L7;
        r5.write(r0, 0, r2);     // Catch: Throwable -> L9
        goto L12
    L7:
        r1.close();
        return;
    L9:
        th = move-exception;
        r1.close();
        throw th;
    }

    public TypedFile(String r1, File r2) {
        if (r1 != null) goto L5;
        r1 = "application/octet-stream";
    L5:
        if (r2 == null) goto L9;
        this.mimeType = r1;
        this.file = r2;
        return;
    L9:
        throw new NullPointerException("file");
    }
}
