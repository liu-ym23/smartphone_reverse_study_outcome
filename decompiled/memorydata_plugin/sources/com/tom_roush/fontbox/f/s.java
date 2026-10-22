package com.tom_roush.fontbox.f;

/* JADX INFO: loaded from: classes6.dex */
public class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f16017a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f16018b;
    private int c;
    private int d;
    private int e;
    private int f;
    private String g;

    public s() {
    }

    public int a() {
        return this.e;
    }

    void a(ah r1, ad r2) {
        this.f16017a = r2.d();
        this.f16018b = r2.d();
        this.c = r2.d();
        this.d = r2.d();
        this.e = r2.d();
        this.f = r2.d();
    }

    public void a(String r1) {
        this.g = r1;
    }

    public int b() {
        return this.f;
    }

    public int c() {
        return this.c;
    }

    public int d() {
        return this.d;
    }

    public int e() {
        return this.f16018b;
    }

    public int f() {
        return this.f16017a;
    }

    public String g() {
        return this.g;
    }

    public String toString() {
        return "platform=" + this.f16017a + " pEncoding=" + this.f16018b + " language=" + this.c + " name=" + this.d + " " + this.g;
    }
}
