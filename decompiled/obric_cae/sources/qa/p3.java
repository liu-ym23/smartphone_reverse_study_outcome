package qa;

import android.content.Context;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class p3 extends i0 {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Map<String, String> f10893n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f10894o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f10895p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public String f10896q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public byte[] f10897r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public byte[] f10898s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f10899t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public String f10900u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public Map<String, String> f10901v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f10902w;

    public p3(Context r8, s4 r10) {
        super(r8, r10);
        this.f10893n = null;
        this.f10894o = "";
        this.f10895p = "";
        this.f10896q = "";
        this.f10897r = null;
        this.f10898s = null;
        this.f10899t = false;
        this.f10900u = null;
        this.f10901v = null;
        this.f10902w = false;
    }

    @Override // qa.m0
    public final Map<String, String> a() {
        return this.f10893n;
    }

    @Override // qa.m0
    public final String c() {
        return this.f10895p;
    }

    @Override // qa.n4, qa.m0
    public final String e() {
        return this.f10896q;
    }

    @Override // qa.i0, qa.m0
    public final Map<String, String> h() {
        return this.f10901v;
    }

    @Override // qa.m0
    public final String j() {
        return this.f10894o;
    }

    @Override // qa.m0
    public final String k() {
        return "loc";
    }

    @Override // qa.i0
    public final byte[] p() {
        return this.f10897r;
    }

    @Override // qa.i0
    public final byte[] q() {
        return this.f10898s;
    }

    @Override // qa.i0
    public final boolean s() {
        return this.f10899t;
    }

    @Override // qa.i0
    public final String t() {
        return this.f10900u;
    }

    @Override // qa.i0
    public final boolean u() {
        return this.f10902w;
    }

    public final void v(byte[] r8) {
        ByteArrayOutputStream r10 = null;
        ByteArrayOutputStream r11 = new ByteArrayOutputStream();     // Catch: Throwable -> L14
        if (r8 != null) goto L29;
    L6:
        this.f10898s = r11.toByteArray();     // Catch: Throwable -> L12
        r11.close();     // Catch: IOException -> L9
        return;
    L9:
        e = move-exception;
        e.printStackTrace();
        return;
    L12:
        th = th;
        r10 = r11;
    L31:
        th.printStackTrace();     // Catch: Throwable -> L22
        if (r10 == null) goto L41;
        r10.close();     // Catch: IOException -> L19
        return;
    L19:
        e = move-exception;
        e.printStackTrace();
        return;
    L41:
        return;
    L22:
        th = move-exception;
        if (r10 != null) goto L39;
    L28:
        throw th;
    L39:
        r10.close();     // Catch: IOException -> L26
    L26:
        e = move-exception;
        e.printStackTrace();
        goto L28
    L29:
        r11.write(t4.h(r8.length));     // Catch: Throwable -> L12
        r11.write(r8);     // Catch: Throwable -> L12
    L14:
        th = th;
        goto L31
    }
}
