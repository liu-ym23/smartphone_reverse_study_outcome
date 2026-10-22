package com.bytedance.bdinstall.util;

/* JADX INFO: loaded from: classes.dex */
public abstract class InstanceHolder<T> {
    private volatile T mInstance;

    public InstanceHolder() {
    }

    protected abstract T create(Object... r10);

    public final T get(Object... r10) {
        if (this.mInstance != null) goto L14;
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L6:
        if (this.mInstance != null) goto L8;
        this.mInstance = create(r10);     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);     // Catch: Throwable -> L10
    L14:
        return this.mInstance;
    }
}
