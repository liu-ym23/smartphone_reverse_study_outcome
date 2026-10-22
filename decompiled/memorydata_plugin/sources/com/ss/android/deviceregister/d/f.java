package com.ss.android.deviceregister.d;

/* JADX INFO: loaded from: classes6.dex */
public abstract class f<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile T f15213a;

    public f() {
    }

    public abstract T b(Object... r1);

    public final T c(Object... r2) {
        if (this.f15213a != null) goto L14;
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L6:
        if (this.f15213a != null) goto L8;
        this.f15213a = b(r2);     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);     // Catch: Throwable -> L10
    L14:
        return this.f15213a;
    }
}
