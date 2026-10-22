package com.bytedance.android.anniex.engine;

import android.util.LruCache;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f3211a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f3212b = null;

    static {
        f3211a = new a();
        f3212b = LazyKt.lazy(AnnieXLynxEngineManager$engineCacheMap$2.f3210a);
    }

    public final synchronized void a() {
        monitor-enter(this);
        Iterator r5 = ((ConcurrentHashMap) f3212b.getValue()).entrySet().iterator();     // Catch: Throwable -> L11
    L5:
        if (r5.hasNext() == false) goto L13;
        Iterator r10 = ((LruCache) ((Map.Entry) r5.next()).getValue()).snapshot().entrySet().iterator();     // Catch: Throwable -> L11
        if (r10.hasNext() == false) goto L5;
        Map.Entry r11 = (Map.Entry) r10.next();     // Catch: Throwable -> L11
        String r12 = (String) r11.getKey();     // Catch: Throwable -> L11
        r11.getValue().getClass();     // Catch: Throwable -> L11
        throw new ClassCastException();     // Catch: Throwable -> L11
    L13:
        monitor-exit(this);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public final synchronized void b(String r5, String r10) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r5, "bid");     // Catch: Throwable -> L10
        Intrinsics.checkNotNullParameter(r10, "sessionId");     // Catch: Throwable -> L10
        a();     // Catch: Throwable -> L10
        LruCache r11 = (LruCache) ((ConcurrentHashMap) f3212b.getValue()).get(r5);     // Catch: Throwable -> L10
        if (r11 != null) goto L6;
    L12:
        monitor-exit(this);
        return;
    L6:
        if (r11.get(r10) == null) goto L12;
        throw new ClassCastException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }
}
