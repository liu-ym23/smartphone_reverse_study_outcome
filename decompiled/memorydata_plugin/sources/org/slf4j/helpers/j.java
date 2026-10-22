package org.slf4j.helpers;

/* JADX INFO: loaded from: classes8.dex */
public class j implements org.slf4j.a.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final i f20274a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final org.slf4j.b f20275b;
    private final org.slf4j.a.a c;

    public j() {
        this.f20274a = new i();
        this.f20275b = new b();
        this.c = new a();
    }

    @Override // org.slf4j.a.b
    public org.slf4j.a a() {
        return this.f20274a;
    }

    @Override // org.slf4j.a.b
    public String b() {
        throw new UnsupportedOperationException();
    }

    @Override // org.slf4j.a.b
    public void c() {
    }

    public i d() {
        return this.f20274a;
    }
}
