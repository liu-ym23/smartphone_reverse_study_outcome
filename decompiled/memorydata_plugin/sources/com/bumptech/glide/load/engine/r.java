package com.bumptech.glide.load.engine;

import androidx.core.util.Pools;
import com.bumptech.glide.util.pool.FactoryPools;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
final class r<Z> implements s<Z>, FactoryPools.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Pools.Pool<r<?>> f809a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.bumptech.glide.util.pool.b f810b;
    private s<Z> c;
    private boolean d;
    private boolean e;

    static {
        f809a = FactoryPools.a(20, new AnonymousClass1());
    }

    r() {
        this.f810b = com.bumptech.glide.util.pool.b.a();
    }

    static <Z> r<Z> a(s<Z> r3) {
        s<Z> r4 = (s) ZeusTransformUtils.wrapperContextForParams(r3, s.class, "com.obric.memorydata.plugin");
        r<Z> r0 = (r) ZeusTransformUtils.preCheckCast(com.bumptech.glide.util.j.a((r) ZeusTransformUtils.preCheckCast(f809a.acquire(), r.class, "com.obric.memorydata.plugin")), r.class, "com.obric.memorydata.plugin");
        r0.b(r4);
        return r0;
    }

    private void b() {
        this.c = null;
        f809a.release(this);
    }

    private void b(s<Z> r3) {
        s<Z> r4 = (s) ZeusTransformUtils.wrapperContextForParams(r3, s.class, "com.obric.memorydata.plugin");
        this.e = false;
        this.d = true;
        this.c = r4;
    }

    synchronized void a() {
        monitor-enter(this);
        this.f810b.b();     // Catch: Throwable -> L12
        if (this.d == false) goto L11;
        this.d = false;     // Catch: Throwable -> L12
        if (this.e == false) goto L8;
        f();     // Catch: Throwable -> L12
    L8:
        monitor-exit(this);
        return;
    L11:
        throw new IllegalStateException("Already unlocked");     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;
    }

    @Override // com.bumptech.glide.util.pool.FactoryPools.b
    public com.bumptech.glide.util.pool.b a_() {
        return this.f810b;
    }

    @Override // com.bumptech.glide.load.engine.s
    public Class<Z> c() {
        return this.c.c();
    }

    @Override // com.bumptech.glide.load.engine.s
    public Z d() {
        return this.c.d();
    }

    @Override // com.bumptech.glide.load.engine.s
    public int e() {
        return this.c.e();
    }

    @Override // com.bumptech.glide.load.engine.s
    public synchronized void f() {
        monitor-enter(this);
        this.f810b.b();     // Catch: Throwable -> L8
        this.e = true;     // Catch: Throwable -> L8
        if (this.d == true) goto L6;
        this.c.f();     // Catch: Throwable -> L8
        b();     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }
}
