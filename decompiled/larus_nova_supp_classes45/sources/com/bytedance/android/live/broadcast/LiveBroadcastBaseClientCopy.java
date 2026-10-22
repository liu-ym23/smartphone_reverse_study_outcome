package com.bytedance.android.live.broadcast;

import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class LiveBroadcastBaseClientCopy {
    public static final Lazy a = null;

    static {
        a = LazyKt.lazy(LiveBroadcastBaseClientCopy$services$2.INSTANCE);
    }

    @JvmStatic
    public static final <T> T a(Class<T> r3) {
        Intrinsics.checkNotNullParameter(r3, "cls");
        Lazy r0 = a;
        if (((ConcurrentHashMap) r0.getValue()).contains(r3) == true) goto L6;
        ConcurrentHashMap r1 = (ConcurrentHashMap) r0.getValue();
        Object r2 = com.bytedance.android.live.network.c.b().e(r3);
        Intrinsics.checkNotNull(r2);
        r1.putIfAbsent(r3, r2);
    L6:
        return (T) ((ConcurrentHashMap) r0.getValue()).get(r3);
    }
}
