package com.bumptech.glide.load.engine;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
class n<Z> implements s<Z> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f803a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f804b;
    private final s<Z> c;
    private final a d;
    private final com.bumptech.glide.load.c e;
    private int f;
    private boolean g;

    interface a {
        void a(com.bumptech.glide.load.c r1, n<?> r2);
    }

    n(s<Z> r3, boolean r4, boolean r5, com.bumptech.glide.load.c r6, a r7) {
        s r8 = (s) ZeusTransformUtils.wrapperContextForParams(r3, s.class, "com.obric.memorydata.plugin");
        com.bumptech.glide.load.c r9 = (com.bumptech.glide.load.c) ZeusTransformUtils.wrapperContextForParams(r6, com.bumptech.glide.load.c.class, "com.obric.memorydata.plugin");
        a r10 = (a) ZeusTransformUtils.wrapperContextForParams(r7, a.class, "com.obric.memorydata.plugin");
        this.c = (s) ZeusTransformUtils.preCheckCast(com.bumptech.glide.util.j.a(r8), s.class, "com.obric.memorydata.plugin");
        this.f803a = r4;
        this.f804b = r5;
        this.e = r9;
        this.d = (a) ZeusTransformUtils.preCheckCast(com.bumptech.glide.util.j.a(r10), a.class, "com.obric.memorydata.plugin");
    }

    s<Z> a() {
        return this.c;
    }

    boolean b() {
        return this.f803a;
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
    L16:
        th = move-exception;
        throw th;
    L4:
        if (this.f > 0) goto L15;
        if (this.g == true) goto L13;
        this.g = true;     // Catch: Throwable -> L16
        if (this.f804b == false) goto L10;
        this.c.f();     // Catch: Throwable -> L16
    L10:
        monitor-exit(this);
        return;
    L13:
        throw new IllegalStateException("Cannot recycle a resource that has already been recycled");     // Catch: Throwable -> L16
    L15:
        throw new IllegalStateException("Cannot recycle a resource while it is still acquired");     // Catch: Throwable -> L16
    }

    synchronized void g() {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (this.g == true) goto L9;
        this.f++;     // Catch: Throwable -> L10
        monitor-exit(this);
        return;
    L9:
        throw new IllegalStateException("Cannot acquire a recycled resource");     // Catch: Throwable -> L10
    }

    void h() {
        monitor-enter(this);
        int r0 = this.f;     // Catch: Throwable -> L15
        if (r0 <= 0) goto L14;
        boolean r1 = true;
        int r2 = r0 - 1;     // Catch: Throwable -> L15
        this.f = r2;     // Catch: Throwable -> L15
        if (r2 == 0) goto L9;
        r1 = false;
    L9:
        monitor-exit(this);     // Catch: Throwable -> L15
        if (r1 == false) goto L19;
        this.d.a(this.e, this);
        return;
    L19:
        return;
    L14:
        throw new IllegalStateException("Cannot release a recycled or not yet acquired resource");     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;
    }

    public synchronized String toString() {
        monitor-enter(this);
        String r0 = "EngineResource{isMemoryCacheable=" + this.f803a + ", listener=" + this.d + ", key=" + this.e + ", acquired=" + this.f + ", isRecycled=" + this.g + ", resource=" + this.c + '}';     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }
}
