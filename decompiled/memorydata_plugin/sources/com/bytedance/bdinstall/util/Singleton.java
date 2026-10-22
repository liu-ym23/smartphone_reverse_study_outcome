package com.bytedance.bdinstall.util;

import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public abstract class Singleton<T> {
    private final AtomicBoolean isInit;
    private volatile T mInstance;

    public Singleton() {
        this.isInit = new AtomicBoolean(false);
    }

    public abstract T create(Object... r1);

    public final T get(Object... r2) {
        if (this.isInit.get() == true) goto L18;
        if (this.mInstance != null) goto L18;
        monitor-enter(this);
    L14:
        th = move-exception;
        throw th;
    L8:
        if (this.isInit.get() == false) goto L10;
    L12:
        monitor-exit(this);     // Catch: Throwable -> L14
        goto L18
    L10:
        if (this.mInstance != null) goto L12;
        this.mInstance = create(r2);     // Catch: Throwable -> L14
        this.isInit.set(true);     // Catch: Throwable -> L14
    L18:
        return this.mInstance;
    }
}
