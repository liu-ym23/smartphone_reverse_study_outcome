package com.bytedance.retrofit2.mime;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public class TypedFile implements TypedInput, TypedOutput {
    private static final int BUFFER_SIZE = 4096;
    private final File file;
    private final String mimeType;

    public TypedFile(String r2, File r3) {
        if (r2 != null) goto L5;
        r2 = "application/octet-stream";
    L5:
        Objects.requireNonNull(r3, "file");
        this.mimeType = r2;
        this.file = r3;
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L7;
        return true;
    L7:
        if (ZeusTransformUtils.instanceOf(r3, TypedFile.class) == false) goto L10;
        TypedFile r4 = (TypedFile) ZeusTransformUtils.preCheckCast(r3, TypedFile.class, "com.obric.memorydata.plugin");
        return this.file.equals(r4.file);
    L10:
        return false;
    }

    public File file() {
        return this.file;
    }

    @Override // com.bytedance.retrofit2.mime.TypedOutput
    public String fileName() {
        return this.file.getName();
    }

    public int hashCode() {
        return this.file.hashCode();
    }

    @Override // com.bytedance.retrofit2.mime.TypedInput
    public InputStream in() {
        return new FileInputStream(this.file);
    }

    @Override // com.bytedance.retrofit2.mime.TypedInput
    public long length() {
        return this.file.length();
    }

    @Override // com.bytedance.retrofit2.mime.TypedOutput
    public String md5Stub() {
        return null;
    }

    @Override // com.bytedance.retrofit2.mime.TypedInput
    public String mimeType() {
        return this.mimeType;
    }

    public void moveTo(TypedFile r3) {
        if (mimeType().equals(r3.mimeType()) == false) goto L10;
        if (this.file.renameTo(r3.file()) == false) goto L8;
        return;
    L8:
        throw new IOException("Rename failed!");
    L10:
        throw new IOException("Type mismatch.");
    }

    public String toString() {
        return this.file.getAbsolutePath() + " (" + mimeType() + ")";
    }

    @Override // com.bytedance.retrofit2.mime.TypedOutput
    public void writeTo(OutputStream r4) {
        byte[] r0 = new byte[4096];
        FileInputStream r1 = new FileInputStream(this.file);
    L12:
        int r3 = r1.read(r0);     // Catch: Throwable -> L9
        if (r3 == (-1)) goto L7;
        r4.write(r0, 0, r3);     // Catch: Throwable -> L9
        goto L12
    L7:
        r1.close();
        return;
    L9:
        th = move-exception;
        r1.close();
        throw th;
    }
}
