package com.loc;

/* JADX INFO: loaded from: classes3.dex */
public final class dn {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String[] f5452a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f5453b;
    private String c;
    private boolean d;
    private boolean e;

    public dn() {
        this.d = false;
        this.e = false;
    }

    public final void a(String r1) {
        this.f5453b = r1;
    }

    public final void a(boolean r1) {
        this.d = r1;
    }

    public final void a(String[] r1) {
        this.f5452a = r1;
    }

    public final String[] a() {
        return this.f5452a;
    }

    public final String b() {
        return this.f5453b;
    }

    public final void b(String r1) {
        this.c = r1;
    }

    public final void b(boolean r1) {
        this.e = r1;
    }

    public final String c() {
        return this.c;
    }

    public final boolean d() {
        return this.d;
    }

    public final boolean e() {
        return this.e;
    }
}
