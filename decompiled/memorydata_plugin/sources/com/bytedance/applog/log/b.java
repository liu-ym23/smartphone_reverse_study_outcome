package com.bytedance.applog.log;

/* JADX INFO: loaded from: classes.dex */
public abstract class b<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile T f1625a;

    public b() {
    }

    public abstract T b(Object... r1);

    public final T c(Object... r2) {
        if (this.f1625a != null) goto L14;
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L6:
        if (this.f1625a != null) goto L8;
        this.f1625a = b(r2);     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);     // Catch: Throwable -> L10
    L14:
        return this.f1625a;
    }
}
