package com.bytedance.retrofit2.mime;

import com.obric.cae.BWDL.BwdlDrop.BwdlDropConstant;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes.dex */
public class TypedFile implements TypedInput, TypedOutput {
    private static final int BUFFER_SIZE = 4096;
    private final File file;
    private final String mimeType;

    public TypedFile(String r8, File r10) {
        if (r8 != null) goto L5;
        r8 = "application/octet-stream";
    L5:
        if (r10 == null) goto L9;
        this.mimeType = r8;
        this.file = r10;
        return;
    L9:
        throw new NullPointerException(BwdlDropConstant.FILE);
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof TypedFile) == true) goto L8;
        return false;
    L8:
        return this.file.equals(((TypedFile) r8).file);
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

    public void moveTo(TypedFile r8) {
        if (mimeType().equals(r8.mimeType()) == false) goto L10;
        if (this.file.renameTo(r8.file()) == false) goto L8;
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
    public void writeTo(OutputStream r8) {
        byte[] r10 = new byte[4096];
        FileInputStream r11 = new FileInputStream(this.file);
    L12:
        int r12 = r11.read(r10);     // Catch: Throwable -> L9
        if (r12 == (-1)) goto L7;
        r8.write(r10, 0, r12);     // Catch: Throwable -> L9
        goto L12
    L7:
        r11.close();
        return;
    L9:
        th = move-exception;
        r11.close();
        throw th;
    }
}
