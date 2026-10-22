package com.tom_roush.pdfbox.a;

/* JADX INFO: loaded from: classes6.dex */
public class l extends b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private b f16063a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f16064b;
    private int c;
    private boolean d;

    public l(b r2) {
        this.d = false;
        a(r2);
    }

    public b a() {
        return this.f16063a;
    }

    public void a(int r1) {
        this.c = r1;
    }

    public void a(long r1) {
        this.f16064b = r1;
    }

    public final void a(b r1) {
        this.f16063a = r1;
    }

    public boolean b() {
        return this.d;
    }

    public void c() {
        this.d = true;
    }

    public void d() {
        this.d = false;
    }

    public long f() {
        return this.f16064b;
    }

    public int g() {
        return this.c;
    }

    public String toString() {
        return "COSObject{" + this.f16064b + ", " + this.c + "}";
    }
}
