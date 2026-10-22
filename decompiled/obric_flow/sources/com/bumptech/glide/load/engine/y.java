package com.bumptech.glide.load.engine;

/* JADX INFO: loaded from: classes.dex */
public final class y implements d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f1590a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f1591b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d0 f1592c;
    public final s d;
    public final x e;
    public int f;
    public boolean g;

    public y(d0 r5, boolean r10, boolean r11, x r12, s r13) {
        io.reactivex.internal.observers.h.h(r5, "Argument must not be null");
        this.f1592c = r5;
        this.f1590a = r10;
        this.f1591b = r11;
        this.e = r12;
        io.reactivex.internal.observers.h.h(r13, "Argument must not be null");
        this.d = r13;
    }

    @Override // com.bumptech.glide.load.engine.d0
    public final int a() {
        return this.f1592c.a();
    }

    public final synchronized void b() {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (this.g == true) goto L11;
        this.f++;     // Catch: Throwable -> L8
        monitor-exit(this);
        return;
    L11:
        throw new IllegalStateException("Cannot acquire a recycled resource");     // Catch: Throwable -> L8
    }

    @Override // com.bumptech.glide.load.engine.d0
    public final Class c() {
        return this.f1592c.c();
    }

    public final void d() {
        monitor-enter(this);
        int r5 = this.f;     // Catch: Throwable -> L13
        if (r5 <= 0) goto L16;
        boolean r10 = true;
        int r11 = r5 - 1;     // Catch: Throwable -> L13
        this.f = r11;     // Catch: Throwable -> L13
        if (r11 == 0) goto L9;
        r10 = false;
    L9:
        monitor-exit(this);     // Catch: Throwable -> L13
        if (r10 == false) goto L20;
        this.d.e(this.e, this);
        return;
    L20:
        return;
    L16:
        throw new IllegalStateException("Cannot release a recycled or not yet acquired resource");     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    }

    @Override // com.bumptech.glide.load.engine.d0
    public final Object get() {
        return this.f1592c.get();
    }

    @Override // com.bumptech.glide.load.engine.d0
    public final synchronized void recycle() {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.f > 0) goto L18;
        if (this.g == true) goto L16;
        this.g = true;     // Catch: Throwable -> L11
        if (this.f1591b == false) goto L13;
        this.f1592c.recycle();     // Catch: Throwable -> L11
    L13:
        monitor-exit(this);
        return;
    L16:
        throw new IllegalStateException("Cannot recycle a resource that has already been recycled");     // Catch: Throwable -> L11
    L18:
        throw new IllegalStateException("Cannot recycle a resource while it is still acquired");     // Catch: Throwable -> L11
    }

    public final synchronized String toString() {
        monitor-enter(this);
        String r5 = "EngineResource{isMemoryCacheable=" + this.f1590a + ", listener=" + this.d + ", key=" + this.e + ", acquired=" + this.f + ", isRecycled=" + this.g + ", resource=" + this.f1592c + '}';     // Catch: Throwable -> L7
        monitor-exit(this);
        return r5;
    L7:
        th = move-exception;
        throw th;
    }
}
