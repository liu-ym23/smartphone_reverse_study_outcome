package com.bytedance.android.live.liveinteract.plantform.performance;

import io.reactivex.functions.Function;
import java.util.LinkedHashMap;
import kotlin.Pair;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d<T, R> implements Function {
    public static final d a = null;

    static {
        a = new d();
    }

    public d() {
    }

    public final Object apply(Object r6) {
        Object[] r7 = (Object[]) r6;
        Intrinsics.checkNotNullParameter(r7, "results");
        LinkedHashMap r1 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(r7.length), 16));
        int r0 = r7.length;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L9;
        Object r3 = r7[r2];
        if (r3 == null) goto L8;
        Pair r4 = (Pair) r3;
        r1.put(r4.getFirst(), r4.getSecond());
        r2 = r2 + 1;
        goto L3
    L8:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Pair<kotlin.String, com.bytedance.android.live.liveinteract.plantform.performance.PerfAbilitySource>");
    L9:
        return r1;
    }
}
