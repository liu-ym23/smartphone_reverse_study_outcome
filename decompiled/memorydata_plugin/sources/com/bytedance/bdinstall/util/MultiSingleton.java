package com.bytedance.bdinstall.util;

import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public abstract class MultiSingleton<T> {
    private volatile ConcurrentHashMap<String, T> instanceMap;

    public MultiSingleton() {
    }

    public abstract T create(String r1, Object... r2);

    public final T get(String r3, Object... r4) {
        T r1 = null;
        if (this.instanceMap != null) goto L5;
        T r0 = null;
    L6:
        if (r0 != null) goto L26;
        monitor-enter(this);
    L23:
        th = move-exception;
        throw th;
    L9:
        if (this.instanceMap == null) goto L12;
        r1 = this.instanceMap.get(r3);     // Catch: Throwable -> L23
    L12:
        if (r1 != null) goto L20;
        T r5 = create(r3, r4);     // Catch: Throwable -> L23
        if (r5 != null) goto L16;
    L19:
        r0 = r5;
    L21:
        monitor-exit(this);     // Catch: Throwable -> L23
        goto L26
    L16:
        if (this.instanceMap != null) goto L18;
        this.instanceMap = new ConcurrentHashMap(4);     // Catch: Throwable -> L23
    L18:
        this.instanceMap.put(r3, r5);     // Catch: Throwable -> L23
        goto L19
    L20:
        r0 = r1;
    L26:
        return r0;
    L5:
        r0 = this.instanceMap.get(r3);
        goto L6
    }
}
