package com.bytedance.news.common.settings.internal;

import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ConcurrentHashMap<Class, Object> f2403a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ConcurrentHashMap<Class, Object> f2404b = null;

    static {
        f2403a = new ConcurrentHashMap();
        f2404b = new ConcurrentHashMap();
    }

    public static <T> T a(Class<T> r10, e r11) {
        ConcurrentHashMap<Class, Object> r12 = f2403a;
        T r13 = (T) r12.get(r10);
        if (r13 != null) goto L27;
        Object r14 = null;
        ConcurrentHashMap<Class, Object> r15 = f2404b;
        monitor-enter(r15);
    L24:
        th = move-exception;
        throw th;
    L7:
        if (r15.containsKey(r10) == false) goto L9;
        r14 = r15.get(r10);     // Catch: Throwable -> L24
    L9:
        if (r14 != null) goto L11;
        r14 = new Object();     // Catch: Throwable -> L24
        r15.put(r10, r14);     // Catch: Throwable -> L24
    L11:
        monitor-exit(r15);     // Catch: Throwable -> L24
        monitor-enter(r14);
        Object r16 = r12.get(r10);     // Catch: Throwable -> L21
        if (r16 != null) goto L18;
        Object r17 = r11.create(r10);     // Catch: Throwable -> L21
        if (r17 == null) goto L19;
        r12.put(r10, r17);     // Catch: Throwable -> L21
    L19:
        monitor-exit(r14);     // Catch: Throwable -> L21
        return (T) r17;
    L18:
        r17 = r16;
    L21:
        th = move-exception;
        throw th;
    L27:
        ConcurrentHashMap<Class, Object> r18 = f2404b;
        if (r18.containsKey(r10) == false) goto L36;
        r18.remove(r10);
        return r13;
    L36:
        return r13;
    }
}
