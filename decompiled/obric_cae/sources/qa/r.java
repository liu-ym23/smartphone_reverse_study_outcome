package qa;

import android.content.Context;
import android.os.Build;

/* JADX INFO: loaded from: classes.dex */
public final class r extends m1 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f10957b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final /* synthetic */ String f10958m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final /* synthetic */ i1 f10959n;

    public r(Context r8, i1 r10, String r11) {
        this.f10957b = r8;
        this.f10958m = r11;
        this.f10959n = r10;
    }

    @Override // qa.m1
    public final void a() {
        monitor-enter(s.class);     // Catch: Throwable -> L13
        p0 r8 = v0.a();     // Catch: Throwable -> L10
        v0.b(this.f10957b, r8, this.f10958m, 1000, 4096000, "1");     // Catch: Throwable -> L10
        r8.f10889f = this.f10959n;     // Catch: Throwable -> L10
        if (r8.f10890g != null) goto L7;
        Context r10 = this.f10957b;     // Catch: Throwable -> L10
        r8.f10890g = new z0(new y0(new d1(), new c0(new a0(new b0())), "QImtleSI6IiVzIiwicGxhdGZvcm0iOiJhbmRyb2lkIiwiZGl1IjoiJXMiLCJhZGl1IjoiJXMiLCJwa2ciOiIlcyIsIm1vZGVsIjoiJXMiLCJhcHBuYW1lIjoiJXMiLCJhcHB2ZXJzaW9uIjoiJXMiLCJzeXN2ZXJzaW9uIjoiJXMi", new Object[]{h4.g(r10), "", k4.q(this.f10957b), h4.d(this.f10957b), Build.MODEL, h4.b(this.f10957b), h4.e(this.f10957b), Build.VERSION.RELEASE}));     // Catch: Throwable -> L10
    L7:
        r8.f10891h = 3600000;     // Catch: Throwable -> L10
        q0.b(r8);     // Catch: Throwable -> L10
        monitor-exit(s.class);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        q.f("lg", "pul", th);
    }
}
