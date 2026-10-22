package com.bytedance.badger.collect.impl.abs;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public abstract class Singleton<T> {
    private volatile T mInstance;

    public Singleton() {
    }

    public abstract T create(Object... r1);

    public final T get(Object... r2) {
        if (this.mInstance != null) goto L14;
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L6:
        if (this.mInstance != null) goto L8;
        this.mInstance = create(r2);     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);     // Catch: Throwable -> L10
    L14:
        return this.mInstance;
    }
}
