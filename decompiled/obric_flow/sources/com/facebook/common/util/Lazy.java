package com.facebook.common.util;

/* JADX INFO: loaded from: classes2.dex */
public abstract class Lazy<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile boolean f7694a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile Object f7695b;

    public Lazy() {
        this.f7694a = false;
    }

    public final Object a() {
        if (this.f7695b == null) goto L7;
        return this.f7695b;
    L7:
        if (this.f7694a == true) goto L9;
        monitor-enter(this);
    L16:
        th = move-exception;
        throw th;
    L12:
        if (this.f7694a == false) goto L18;
        Object r5 = this.f7695b;     // Catch: Throwable -> L16
        monitor-exit(this);     // Catch: Throwable -> L16
        return r5;
    L18:
        this.f7695b = b();     // Catch: Throwable -> L16
        this.f7694a = true;     // Catch: Throwable -> L16
        Object r10 = this.f7695b;     // Catch: Throwable -> L16
        monitor-exit(this);     // Catch: Throwable -> L16
        return r10;
    L9:
        return this.f7695b;
    }

    public abstract Object b();
}
