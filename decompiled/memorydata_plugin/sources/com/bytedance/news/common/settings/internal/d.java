package com.bytedance.news.common.settings.internal;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ConcurrentHashMap<Class, Object> f2955a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ConcurrentHashMap<Class, Object> f2956b = null;

    static {
        f2955a = new ConcurrentHashMap();
        f2956b = new ConcurrentHashMap();
    }

    public static <T> T a(Class<T> r4, e r5) {
        e r6 = (e) ZeusTransformUtils.wrapperContextForParams(r5, e.class, "com.obric.memorydata.plugin");
        ConcurrentHashMap<Class, Object> r0 = f2955a;
        T r1 = (T) r0.get(r4);
        if (r1 != null) goto L27;
        Object r2 = null;
        ConcurrentHashMap<Class, Object> r3 = f2956b;
        monitor-enter(r3);
    L24:
        th = move-exception;
        throw th;
    L7:
        if (r3.containsKey(r4) == false) goto L9;
        r2 = r3.get(r4);     // Catch: Throwable -> L24
    L9:
        if (r2 != null) goto L11;
        r2 = new Object();     // Catch: Throwable -> L24
        r3.put(r4, r2);     // Catch: Throwable -> L24
    L11:
        monitor-exit(r3);     // Catch: Throwable -> L24
        monitor-enter(r2);
        Object r7 = r0.get(r4);     // Catch: Throwable -> L21
        if (r7 != null) goto L18;
        Object r8 = r6.a(r4);     // Catch: Throwable -> L21
        if (r8 == null) goto L19;
        r0.put(r4, r8);     // Catch: Throwable -> L21
    L19:
        monitor-exit(r2);     // Catch: Throwable -> L21
        return (T) r8;
    L18:
        r8 = r7;
    L21:
        th = move-exception;
        throw th;
    L27:
        ConcurrentHashMap<Class, Object> r9 = f2956b;
        if (r9.containsKey(r4) == false) goto L36;
        r9.remove(r4);
        return r1;
    L36:
        return r1;
    }
}
