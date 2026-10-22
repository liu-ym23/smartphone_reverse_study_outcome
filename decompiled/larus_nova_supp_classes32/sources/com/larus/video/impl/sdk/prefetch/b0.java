package com.larus.video.impl.sdk.prefetch;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class b0 {
    public static final <T> List<T> a(List<? extends T> r1, int r2, int r3) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        int r4 = RangesKt.coerceAtLeast(r2, 0);     // Catch: Exception -> L8
        int r5 = RangesKt.coerceAtMost(r3, r1.size());     // Catch: Exception -> L8
        if (r4 < r5) goto L7;
        return CollectionsKt.emptyList();
    L7:
        return r1.subList(r4, r5);
    L9:
        return CollectionsKt.emptyList();
    }
}
