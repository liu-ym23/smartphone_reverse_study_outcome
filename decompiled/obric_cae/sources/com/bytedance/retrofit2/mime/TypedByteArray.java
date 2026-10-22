package com.bytedance.retrofit2.mime;

import android.text.TextUtils;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class TypedByteArray implements TypedInput, TypedOutput {
    private final byte[] bytes;
    private final String fakeFileName;
    private final String mimeType;

    public TypedByteArray(String r8, byte[] r10, String... r11) {
        if (r11 != null) goto L5;
    L7:
        String r12 = null;
    L8:
        if (r8 == null) goto L10;
    L13:
        if (r10 == null) goto L17;
        this.mimeType = r8;
        this.bytes = r10;
        this.fakeFileName = r12;
        return;
    L17:
        throw new NullPointerException("bytes");
    L10:
        if (TextUtils.isEmpty(r12) == false) goto L12;
        r8 = "application/unknown";
        goto L13
    L12:
        r8 = "application/octet-stream";
        goto L13
    L5:
        if (r11.length <= 0) goto L7;
        r12 = r11[0];
        goto L8
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if (r8 != null) goto L8;
    L17:
        return false;
    L8:
        if (getClass() != r8.getClass()) goto L17;
        TypedByteArray r10 = (TypedByteArray) r8;
        if (Arrays.equals(this.bytes, r10.bytes) == true) goto L14;
        return false;
    L14:
        if (this.mimeType.equals(r10.mimeType) == true) goto L16;
        return false;
    L16:
        return true;
    }

    @Override // com.bytedance.retrofit2.mime.TypedOutput
    public String fileName() {
        if (TextUtils.isEmpty(this.fakeFileName) == false) goto L7;
        return null;
    L7:
        return this.fakeFileName;
    }

    public byte[] getBytes() {
        return this.bytes;
    }

    public int hashCode() {
        int r8 = this.mimeType.hashCode() * 31;
        return Arrays.hashCode(this.bytes) + r8;
    }

    @Override // com.bytedance.retrofit2.mime.TypedInput
    public InputStream in() {
        return new ByteArrayInputStream(this.bytes);
    }

    @Override // com.bytedance.retrofit2.mime.TypedInput
    public long length() {
        return this.bytes.length;
    }

    @Override // com.bytedance.retrofit2.mime.TypedOutput
    public String md5Stub() {
        byte[] r8 = this.bytes;
        if (r8 != null) goto L7;
        return null;
    L7:
        return DigestUtil.md5Hex(r8);
    }

    @Override // com.bytedance.retrofit2.mime.TypedInput
    public String mimeType() {
        return this.mimeType;
    }

    public String toString() {
        return "TypedByteArray[length=" + length() + "]";
    }

    @Override // com.bytedance.retrofit2.mime.TypedOutput
    public void writeTo(OutputStream r8) {
        r8.write(this.bytes);
    }
}
