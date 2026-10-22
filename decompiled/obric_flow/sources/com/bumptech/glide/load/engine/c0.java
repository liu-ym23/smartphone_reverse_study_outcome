package com.bumptech.glide.load.engine;

/* JADX INFO: loaded from: classes.dex */
public final class c0 implements d0, r0.e {
    public static final r0.d e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.lynx.tasm.base.f f1476a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public d0 f1477b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f1478c;
    public boolean d;

    static {
        e = r0.g.a(20, new sj.e());
    }

    public c0() {
        this.f1476a = new com.lynx.tasm.base.f();
    }

    @Override // com.bumptech.glide.load.engine.d0
    public final int a() {
        return this.f1477b.a();
    }

    @Override // r0.e
    public final com.lynx.tasm.base.f b() {
        return this.f1476a;
    }

    @Override // com.bumptech.glide.load.engine.d0
    public final Class c() {
        return this.f1477b.c();
    }

    public final synchronized void d() {
        monitor-enter(this);
        this.f1476a.b();     // Catch: Throwable -> L9
        if (this.f1478c == false) goto L14;
        this.f1478c = false;     // Catch: Throwable -> L9
        if (this.d == false) goto L11;
        recycle();     // Catch: Throwable -> L9
    L11:
        monitor-exit(this);
        return;
    L14:
        throw new IllegalStateException("Already unlocked");     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    @Override // com.bumptech.glide.load.engine.d0
    public final Object get() {
        return this.f1477b.get();
    }

    @Override // com.bumptech.glide.load.engine.d0
    public final synchronized void recycle() {
        monitor-enter(this);
        this.f1476a.b();     // Catch: Throwable -> L7
        this.d = true;     // Catch: Throwable -> L7
        if (this.f1478c == true) goto L9;
        this.f1477b.recycle();     // Catch: Throwable -> L7
        this.f1477b = null;     // Catch: Throwable -> L7
        e.release(this);     // Catch: Throwable -> L7
    L9:
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
