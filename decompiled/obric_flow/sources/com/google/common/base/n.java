package com.google.common.base;

import java.lang.ref.WeakReference;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes2.dex */
public abstract class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final WeakHashMap f8666a = null;

    static {
        f8666a = new WeakHashMap();
    }

    public static Optional a(Class r10) {
        com.bytedance.sdk.xbridge.cn.auth.g r5 = y.f8677a;
        WeakHashMap r11 = f8666a;
        monitor-enter(r11);
        Map r12 = (Map) r11.get(r10);     // Catch: Throwable -> L17
        Map r13 = r12;
        if (r12 != null) goto L11;
        HashMap r14 = new HashMap();     // Catch: Throwable -> L17
        Iterator r15 = EnumSet.allOf(r10).iterator();     // Catch: Throwable -> L17
    L8:
        if (r15.hasNext() == false) goto L10;
        Enum r16 = (Enum) r15.next();     // Catch: Throwable -> L17
        r14.put(r16.name(), new WeakReference(r16));     // Catch: Throwable -> L17
        goto L8
    L10:
        f8666a.put(r10, r14);     // Catch: Throwable -> L17
        r13 = r14;
    L11:
        monitor-exit(r11);     // Catch: Throwable -> L17
        WeakReference r17 = (WeakReference) r13.get("MODULE");
        if (r17 != null) goto L16;
        return Optional.absent();
    L16:
        return Optional.of((Enum) r10.cast(r17.get()));
    L17:
        th = move-exception;
        throw th;
    }
}
