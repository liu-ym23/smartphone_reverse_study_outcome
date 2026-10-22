package com.bytedance.android.anniex.engine;

import android.util.LruCache;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class AnnieXLynxEngineManager {
    public static final AnnieXLynxEngineManager a = null;
    public static final Lazy b = null;

    public AnnieXLynxEngineManager() {
    }

    public final synchronized void c() {
        monitor-enter(this);
        Iterator r0 = b().entrySet().iterator();     // Catch: Throwable -> L20
    L4:
        if (r0.hasNext() == false) goto L18;
        LruCache r1 = (LruCache) ((Map.Entry) r0.next()).getValue();     // Catch: Throwable -> L20
        Iterator r10 = r1.snapshot().entrySet().iterator();     // Catch: Throwable -> L20
    L8:
        if (r10.hasNext() == false) goto L4;
        Map.Entry r11 = (Map.Entry) r10.next();     // Catch: Throwable -> L20
        String r12 = (String) r11.getKey();     // Catch: Throwable -> L20
        AnnieXLynxEngine r13 = (AnnieXLynxEngine) r11.getValue();     // Catch: Throwable -> L20
        boolean r14 = false;
        if (r13.h > 0) goto L13;
    L15:
        if (r14 == false) goto L8;
        r1.remove(r12);     // Catch: Throwable -> L20
        goto L8
    L13:
        if ((System.currentTimeMillis() - r13.f) <= r13.h) goto L15;
        r14 = true;
        goto L15
    L18:
        monitor-exit(this);
        return;
    L20:
        th = move-exception;
        throw th;
    }

    static {
        a = new AnnieXLynxEngineManager();
        b = LazyKt.lazy(AnnieXLynxEngineManager$engineCacheMap$2.INSTANCE);
    }

    public static ConcurrentHashMap b() {
        return (ConcurrentHashMap) b.getValue();
    }

    public final synchronized AnnieXLynxEngine a(String r11, String r12) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r11, "bid");     // Catch: Throwable -> L22
        Intrinsics.checkNotNullParameter(r12, "sessionId");     // Catch: Throwable -> L22
        c();     // Catch: Throwable -> L22
        LruCache r1 = (LruCache) b().get(r11);     // Catch: Throwable -> L22
        AnnieXLynxEngine r10 = null;
        if (r1 == null) goto L20;
        AnnieXLynxEngine r13 = (AnnieXLynxEngine) r1.get(r12);     // Catch: Throwable -> L22
        if (r13 == null) goto L20;
        boolean r14 = false;
        if (r13.h > 0) goto L12;
    L14:
        if (r14 == false) goto L16;
        r1.remove(r12);     // Catch: Throwable -> L22
        HybridLogger r15 = HybridLogger.a;     // Catch: Throwable -> L22
        HybridLogger.i("AnnieXLynxEngineManager", "AnnieXLynxEngine expired, bid: " + r11 + ", sessionId: " + r12, null, 12);     // Catch: Throwable -> L22
    L18:
        monitor-exit(this);
        return r10;
    L16:
        r1.remove(r12);     // Catch: Throwable -> L22
        r10 = r13;
        goto L18
    L12:
        if ((System.currentTimeMillis() - r13.f) <= r13.h) goto L14;
        r14 = true;
    L20:
        monitor-exit(this);
        return null;
    L22:
        th = move-exception;
        throw th;
    }

    public final synchronized void d(String r10, String r11, AnnieXLynxEngine r12) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r10, "bid");     // Catch: Throwable -> L21
        Intrinsics.checkNotNullParameter(r11, "sessionId");     // Catch: Throwable -> L21
        Intrinsics.checkNotNullParameter(r12, "annieXLynxEngine");     // Catch: Throwable -> L21
        if (b().containsKey(r10) == false) goto L14;
        LruCache r1 = (LruCache) b().get(r10);     // Catch: Throwable -> L21
        if (r1 == null) goto L9;
        AnnieXLynxEngine r13 = (AnnieXLynxEngine) r1.put(r11, r12);     // Catch: Throwable -> L21
    L9:
        HybridLogger r14 = HybridLogger.a;     // Catch: Throwable -> L21
        StringBuilder r15 = new StringBuilder("AnnieXLynxEngine Count, bid: ");     // Catch: Throwable -> L21
        r15.append(r10);     // Catch: Throwable -> L21
        r15.append(", count: ");     // Catch: Throwable -> L21
        LruCache r16 = (LruCache) b().get(r10);     // Catch: Throwable -> L21
        if (r16 == null) goto L12;
        Integer r17 = Integer.valueOf(r16.size());     // Catch: Throwable -> L21
    L13:
        r15.append(r17);     // Catch: Throwable -> L21
        HybridLogger.m("AnnieXLynxEngineManager", r15.toString(), null, null, 12);     // Catch: Throwable -> L21
    L19:
        monitor-exit(this);
        return;
    L12:
        r17 = null;
        goto L13
    L14:
        LruCache r0 = new LruCache(r12.g);     // Catch: Throwable -> L21
        r0.put(r11, r12);     // Catch: Throwable -> L21
        HybridLogger r18 = HybridLogger.a;     // Catch: Throwable -> L21
        StringBuilder r19 = new StringBuilder("AnnieXLynxEngine Count, bid: ");     // Catch: Throwable -> L21
        r19.append(r10);     // Catch: Throwable -> L21
        r19.append(", count: ");     // Catch: Throwable -> L21
        LruCache r20 = (LruCache) b().get(r10);     // Catch: Throwable -> L21
        if (r20 == null) goto L17;
        Integer r21 = Integer.valueOf(r20.size());     // Catch: Throwable -> L21
    L18:
        r19.append(r21);     // Catch: Throwable -> L21
        HybridLogger.m("AnnieXLynxEngineManager", r19.toString(), null, null, 12);     // Catch: Throwable -> L21
        b().put(r10, r0);     // Catch: Throwable -> L21
        goto L19
    L17:
        r21 = null;
    L21:
        th = move-exception;
        throw th;
    }
}
