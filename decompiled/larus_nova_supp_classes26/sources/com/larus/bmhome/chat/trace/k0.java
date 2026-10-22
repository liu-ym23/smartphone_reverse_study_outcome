package com.larus.bmhome.chat.trace;

import com.larus.utils.logger.FLogger;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class k0 {
    public static final ConcurrentHashMap<Object, Long> a = null;

    static {
        a = new ConcurrentHashMap();
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [com.larus.bmhome.chat.trace.j0] */
    public static void a(final Object r6, final Runnable r7) {
        Intrinsics.checkNotNullParameter(r6, "key");
        Intrinsics.checkNotNullParameter(r7, "task");
        ConcurrentHashMap<Object, Long> r0 = a;
        if (r0.size() <= 300) goto L5;
        r0.clear();
    L5:
        final long r1 = System.currentTimeMillis();
        ?? r3 = new j0(r6, r1, r7);
        Long r8 = r0.get(r6);
        if (r8 != null) goto L8;
        r3.invoke();
        return;
    L8:
        if ((r1 - r8.longValue()) <= 500) goto L10;
        r3.invoke();
        return;
    L10:
        FLogger.a.i("DistinctTaskManager", "discard task key:" + r6);
    }
}
