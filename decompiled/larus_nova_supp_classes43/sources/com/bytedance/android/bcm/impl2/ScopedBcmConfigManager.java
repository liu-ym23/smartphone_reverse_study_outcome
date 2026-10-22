package com.bytedance.android.bcm.impl2;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import pc.f;
import pc.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class ScopedBcmConfigManager {
    public static final Lazy a = null;
    public static final Lazy b = null;
    public static final Lazy c = null;

    static {
        a = LazyKt.lazy(ScopedBcmConfigManager$scopeConfigMap$2.INSTANCE);
        b = LazyKt.lazy(ScopedBcmConfigManager$eventConfigMap$2.INSTANCE);
        c = LazyKt.lazy(ScopedBcmConfigManager$cache$2.INSTANCE);
    }

    public static void a(final String r10, final f r11) {
        ((ConcurrentHashMap) a.getValue()).put(r10, r11);
        Lazy r0 = b;
        ConcurrentHashMap r1 = (ConcurrentHashMap) r0.getValue();
        monitor-enter(r1);
        Iterator r12 = ((ConcurrentHashMap) r0.getValue()).entrySet().iterator();     // Catch: Throwable -> L21
    L6:
        if (r12.hasNext() == false) goto L8;
        final CopyOnWriteArraySet r13 = (CopyOnWriteArraySet) ((Map.Entry) r12.next()).getValue();     // Catch: Throwable -> L21
        new ScopedBcmConfigManager$setScopeConfig$$inlined$synchronized$lambda$1(r13, r10, r11);     // Catch: Throwable -> L21
        goto L6
    L8:
        Iterator<T> r14 = r11.b().iterator();     // Catch: Throwable -> L21
    L10:
        if (r14.hasNext() == false) goto L18;
        pc.b r15 = (pc.b) r14.next();     // Catch: Throwable -> L21
        ConcurrentHashMap r16 = (ConcurrentHashMap) b.getValue();     // Catch: Throwable -> L21
        String r17 = r15.e();     // Catch: Throwable -> L21
        Object r18 = r16.get(r17);     // Catch: Throwable -> L21
        if (r18 != null) goto L17;
        r18 = new CopyOnWriteArraySet();     // Catch: Throwable -> L21
        Object r19 = r16.putIfAbsent(r17, r18);     // Catch: Throwable -> L21
        if (r19 == null) goto L17;
        r18 = r19;
    L17:
        ((CopyOnWriteArraySet) r18).add(new g(r10, r15));     // Catch: Throwable -> L21
        goto L10
    L18:
        Unit r20 = Unit.INSTANCE;     // Catch: Throwable -> L21
        monitor-exit(r1);
        return;
    L21:
        th = move-exception;
        throw th;
    }
}
