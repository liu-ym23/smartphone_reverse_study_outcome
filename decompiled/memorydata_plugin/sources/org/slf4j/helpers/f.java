package org.slf4j.helpers;

/* JADX INFO: loaded from: classes8.dex */
public class f implements org.slf4j.a.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f20268a = "2.0.99";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final org.slf4j.a f20269b;
    private final org.slf4j.b c;
    private final org.slf4j.a.a d;

    static {
    }

    public f() {
        this.f20269b = new d();
        this.c = new b();
        this.d = new e();
    }

    @Override // org.slf4j.a.b
    public org.slf4j.a a() {
        return this.f20269b;
    }

    @Override // org.slf4j.a.b
    public String b() {
        return f20268a;
    }

    @Override // org.slf4j.a.b
    public void c() {
    }
}
