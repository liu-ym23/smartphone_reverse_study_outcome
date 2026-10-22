package com.bytedance.applog.e;

import android.content.Context;
import com.bytedance.applog.monitor.v3.StatsCountKeys;
import com.bytedance.common.utility.NetworkUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {
    public static volatile boolean c = false;
    public static volatile long d = 5000;
    static final long[] e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final c f1568a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    volatile boolean f1569b;
    private int f;
    private long g;
    private boolean h;

    static {
        e = new long[]{180000, 180000, 360000, 360000, 540000, 540000, 720000, 720000};
    }

    public a(c r1) {
        this.f1568a = r1;
    }

    public a(c r1, long r2) {
        this(r1);
        this.g = r2;
    }

    private synchronized long c(int r6) {
        monitor-enter(this);
        boolean r7 = b(r6);     // Catch: Throwable -> L13
        this.g = System.currentTimeMillis();     // Catch: Throwable -> L11
        if (r7 == false) goto L8;
        this.f = 0;     // Catch: Throwable -> L11
    L9:
        b().aA().c(g() + " worked: {}", new Object[]{Boolean.valueOf(r7)});     // Catch: Throwable -> L11
    L16:
        long r0 = i();     // Catch: Throwable -> L11
        monitor-exit(this);
        return r0;
    L8:
        this.f++;     // Catch: Throwable -> L11
        goto L9
    L11:
        th = move-exception;
        throw th;
    L13:
        th = move-exception;
        b().aA().a("work failed", th, new Object[0]);     // Catch: Throwable -> L19
        this.g = System.currentTimeMillis();     // Catch: Throwable -> L11
        this.f++;     // Catch: Throwable -> L11
        b().aA().c(g() + " worked: {}", new Object[]{false});     // Catch: Throwable -> L11
        goto L16
    L19:
        th = move-exception;
        this.g = System.currentTimeMillis();     // Catch: Throwable -> L11
        this.f++;     // Catch: Throwable -> L11
        b().aA().c(g() + " worked: {}", new Object[]{false});     // Catch: Throwable -> L11
        throw th;     // Catch: Throwable -> L11
    }

    private long d(int r2) {
        long[] r1 = f();
        return r1[r2 % r1.length];
    }

    private long i() {
        long r0 = e();
        if (d() == false) goto L10;
        if (NetworkUtils.d((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f1568a.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")) == true) goto L10;
        b().aA().d("checkWorkTime {} network not available, will try again next interval!", new Object[]{g()});
        this.f1568a.a().ab().a(StatsCountKeys.NO_NETWORK_COUNT);
        if (c == false) goto L16;
        this.g = Math.max(this.g, (System.currentTimeMillis() - r0) + d);
    L16:
        return this.g + r0;
    L10:
        if (this.f1569b == false) goto L12;
        this.g = 0;
        this.f1569b = false;
        r0 = 0;
        goto L16
    L12:
        int r2 = this.f;
        if (r2 <= 0) goto L16;
        r0 = d(r2 - 1);
        goto L16
    }

    final long a(int r5) {
        long r0 = i();
        if (r0 <= System.currentTimeMillis()) goto L5;
        return r0;
    L5:
        return c(r5);
    }

    public void a(long r1) {
        this.g = r1;
    }

    boolean a() {
        if (b().e() == true) goto L5;
    L8:
        return true;
    L5:
        if (this.h == true) goto L8;
        return false;
    }

    public com.bytedance.applog.b b() {
        return this.f1568a.a();
    }

    public abstract boolean b(int r1);

    final long c() {
        return this.g;
    }

    public abstract boolean d();

    public abstract long e();

    public abstract long[] f();

    public abstract String g();

    /* JADX WARN: Multi-variable type inference failed */
    <T extends a> T h() {
        this.f1569b = true;
        return this;
    }
}
