package com.bytedance.android.live.broadcast.api.monitor;

import android.os.SystemClock;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class OpenLiveCostMonitor {
    public static Map<OpenLiveAction, Long> a;
    public static final Lazy b = null;

    static {
        b = LazyKt.lazy(OpenLiveCostMonitor$enable$2.INSTANCE);
    }

    public static void b(OpenLiveAction r3) {
        Intrinsics.checkNotNullParameter(r3, "action");
        if (((Boolean) b.getValue()).booleanValue() == true) goto L6;
        return;
    L6:
        if (a != null) goto L8;
        a = new LinkedHashMap();
    L8:
        Map<OpenLiveAction, Long> r0 = a;
        if (r0 == null) goto L12;
        Long r4 = r0.put(r3, Long.valueOf(SystemClock.elapsedRealtime()));
        return;
    }

    public static Pair a(OpenLiveAction r6, OpenLiveAction r7) {
        String r0 = "from_" + r6.getValue() + "_to_" + r7.getValue();
        Map<OpenLiveAction, Long> r1 = a;
        if (r1 == null) goto L7;
        Long r8 = (Long) ((LinkedHashMap) r1).get(r7);
        if (r8 == null) goto L7;
        long r4 = r8.longValue();
    L8:
        Map<OpenLiveAction, Long> r9 = a;
        if (r9 == null) goto L13;
        Long r11 = (Long) ((LinkedHashMap) r9).get(r6);
        if (r11 == null) goto L13;
        long r12 = r11.longValue();
    L15:
        return TuplesKt.to(r0, String.valueOf(RangesKt.coerceAtLeast(r4 - r12, 0)));
    L13:
        r12 = 0;
    L7:
        r4 = 0;
        goto L8
    }
}
