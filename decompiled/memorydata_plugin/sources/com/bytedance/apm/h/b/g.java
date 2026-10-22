package com.bytedance.apm.h.b;

import android.os.Build;

/* JADX INFO: loaded from: classes.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private b f1350a;

    /* JADX INFO: renamed from: com.bytedance.apm.h.b.g$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static g f1351a;

        static {
            f1351a = new g(null);
        }

        static /* synthetic */ g a() {
            return f1351a;
        }
    }

    private g() {
        if (Build.VERSION.SDK_INT < 28) goto L5;
        b r0 = new d();
    L6:
        this.f1350a = r0;
        this.f1350a.a();
        return;
    L5:
        r0 = new e();
        goto L6
    }

    /* synthetic */ g(AnonymousClass1 r1) {
        this();
    }

    public static g a() {
        return a.a();
    }

    void a(boolean r1) {
        this.f1350a.a(r1);
    }

    public long b() {
        return this.f1350a.b();
    }

    public long c() {
        return this.f1350a.c();
    }

    public long d() {
        return this.f1350a.d();
    }

    public long e() {
        return this.f1350a.e();
    }

    public long f() {
        return this.f1350a.f();
    }

    public long g() {
        return this.f1350a.g();
    }

    public long h() {
        return this.f1350a.h();
    }

    public long i() {
        return this.f1350a.i();
    }

    public long j() {
        return this.f1350a.j();
    }

    public long k() {
        return this.f1350a.k();
    }

    public long l() {
        return this.f1350a.l();
    }
}
