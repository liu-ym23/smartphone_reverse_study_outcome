package fi;

import com.bytedance.frameworks.encryptor.EncryptorUtil;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ByteArrayOutputStream f16901a;

    public c() {
        this.f16901a = new ByteArrayOutputStream();
    }

    @Override // fi.j
    public final String a() {
        return "application/x-www-form-urlencoded; charset=UTF-8";
    }

    @Override // fi.j
    public final String b() {
        return null;
    }

    @Override // fi.j
    public final String d() {
        return b.b(this.f16901a.toByteArray());
    }

    @Override // fi.a
    public final boolean e() {
        byte[] r5 = this.f16901a.toByteArray();
        if (r5 != null) goto L5;
    L12:
        return false;
    L5:
        if (r5.length > 102400) goto L12;
        byte[] r10 = EncryptorUtil.a(r5.length, r5);
        if (r10 != null) goto L10;
        return false;
    L10:
        ByteArrayOutputStream r11 = new ByteArrayOutputStream(r10.length);
        this.f16901a = r11;
        r11.write(r10, 0, r10.length);
        return true;
    }

    public final void f(String r5, String r10, boolean r11, boolean r12) {
        if (r5 == null) goto L21;
        if (r10 == null) goto L19;
        if (this.f16901a.size() <= 0) goto L8;
        this.f16901a.write(38);
    L8:
        if (r11 == true) goto L22;
    L12:
        if (r12 == false) goto L14;
        r10 = URLEncoder.encode(r10, "UTF-8");     // Catch: IOException -> L10
    L14:
        this.f16901a.write(r5.getBytes("UTF-8"));     // Catch: IOException -> L10
        this.f16901a.write(61);     // Catch: IOException -> L10
        this.f16901a.write(r10.getBytes("UTF-8"));     // Catch: IOException -> L10
        return;
    L10:
        e = move-exception;
        throw new RuntimeException(e);
    L22:
        r5 = URLEncoder.encode(r5, "UTF-8");     // Catch: IOException -> L10
        goto L12
    L19:
        throw new NullPointerException("value");
    L21:
        throw new NullPointerException("name");
    }

    @Override // fi.j
    public final long length() {
        return this.f16901a.size();
    }

    @Override // fi.j
    public final void writeTo(OutputStream r5) {
        r5.write(this.f16901a.toByteArray());
    }
}
