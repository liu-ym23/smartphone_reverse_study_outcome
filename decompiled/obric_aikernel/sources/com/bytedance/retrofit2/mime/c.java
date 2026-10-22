package com.bytedance.retrofit2.mime;

import android.text.TextUtils;
import com.bytedance.frameworks.encryptor.EncryptorUtil;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.Objects;
import r4.e;

/* JADX INFO: loaded from: classes.dex */
public class c extends a implements e {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f2558d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private byte[] f2559e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f2560f;

    public c(String r10, byte[] r11, String... r12) {
        if (r12 != null) goto L5;
    L7:
        String r13 = null;
    L8:
        if (r10 == null) goto L10;
    L13:
        Objects.requireNonNull(r11, "bytes null");
        this.f2558d = r10;
        this.f2559e = r11;
        this.f2560f = r13;
        return;
    L10:
        if (TextUtils.isEmpty(r13) == false) goto L12;
        r10 = "application/unknown";
        goto L13
    L12:
        r10 = "application/octet-stream";
        goto L13
    L5:
        if (r12.length <= 0) goto L7;
        r13 = r12[0];
        goto L8
    }

    @Override // com.bytedance.retrofit2.mime.a, r4.f
    public String a() {
        return this.f2558d;
    }

    @Override // com.bytedance.retrofit2.mime.a, r4.f
    public String b() {
        if (TextUtils.isEmpty(this.f2560f) == false) goto L7;
        return null;
    L7:
        return this.f2560f;
    }

    @Override // r4.e
    public InputStream c() {
        return new ByteArrayInputStream(this.f2559e);
    }

    @Override // com.bytedance.retrofit2.mime.a, r4.f
    public String d() {
        byte[] r10 = this.f2559e;
        if (r10 != null) goto L6;
        return null;
    L6:
        this.f2554c = r4.a.c(r10);
        return this.f2554c;
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if (r10 != null) goto L8;
    L17:
        return false;
    L8:
        if (getClass() != r10.getClass()) goto L17;
        c r11 = (c) r10;
        if (Arrays.equals(this.f2559e, r11.f2559e) == true) goto L14;
        return false;
    L14:
        if (this.f2558d.equals(r11.f2558d) == true) goto L16;
        return false;
    L16:
        return true;
    }

    @Override // com.bytedance.retrofit2.mime.a
    public TTRequestCompressManager.b f(String r10, String r11, boolean r12) {
        byte[] r13 = this.f2559e;
        if (r13 != null) goto L6;
        return null;
    L6:
        TTRequestCompressManager.b r14 = TTRequestCompressManager.d(r13, r13.length, r10, r11, r12);
        if (r14 != null) goto L9;
    L12:
        return r14;
    L9:
        if (r14.f2548a == null) goto L12;
        int r15 = this.f2559e.length;
        this.f2559e = r14.f2548a;
        this.f2553b = r14.f2549b;
        goto L12
    }

    @Override // com.bytedance.retrofit2.mime.a
    public boolean h() {
        byte[] r10 = this.f2559e;
        if (r10 != null) goto L5;
    L12:
        return false;
    L5:
        if (r10.length > 102400) goto L12;
        byte[] r11 = EncryptorUtil.a(r10, r10.length);
        if (r11 != null) goto L10;
        return false;
    L10:
        this.f2559e = r11;
        this.f2552a = true;
        return true;
    }

    public int hashCode() {
        return (this.f2558d.hashCode() * 31) + Arrays.hashCode(this.f2559e);
    }

    public byte[] j() {
        return this.f2559e;
    }

    @Override // com.bytedance.retrofit2.mime.a, r4.f
    public long length() {
        return this.f2559e.length;
    }

    public String toString() {
        return "TypedByteArray[length=" + length() + "]";
    }

    @Override // com.bytedance.retrofit2.mime.a, r4.f
    public void writeTo(OutputStream r10) {
        r10.write(this.f2559e);
    }
}
