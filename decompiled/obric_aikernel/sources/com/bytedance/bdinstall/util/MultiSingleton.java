package com.bytedance.bdinstall.util;

import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public abstract class MultiSingleton<T> {
    private volatile ConcurrentHashMap<String, T> instanceMap;

    public MultiSingleton() {
    }

    protected abstract T create(String r10, Object... r11);

    public final T get(String r10, Object... r11) {
        T r12 = null;
        if (this.instanceMap != null) goto L5;
        T r13 = null;
    L6:
        if (r13 != null) goto L26;
        monitor-enter(this);
    L23:
        th = move-exception;
        throw th;
    L9:
        if (this.instanceMap == null) goto L12;
        r12 = this.instanceMap.get(r10);     // Catch: Throwable -> L23
    L12:
        if (r12 != null) goto L20;
        T r14 = create(r10, r11);     // Catch: Throwable -> L23
        if (r14 != null) goto L16;
    L19:
        r13 = r14;
    L21:
        monitor-exit(this);     // Catch: Throwable -> L23
        goto L26
    L16:
        if (this.instanceMap != null) goto L18;
        this.instanceMap = new ConcurrentHashMap(4);     // Catch: Throwable -> L23
    L18:
        this.instanceMap.put(r10, r14);     // Catch: Throwable -> L23
        goto L19
    L20:
        r13 = r12;
    L26:
        return r13;
    L5:
        r13 = this.instanceMap.get(r10);
        goto L6
    }
}
