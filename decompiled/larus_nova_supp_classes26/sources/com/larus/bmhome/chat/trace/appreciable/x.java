package com.larus.bmhome.chat.trace.appreciable;

import java.util.Comparator;
import kotlin.Pair;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class x<T> implements Comparator {
    public x() {
    }

    @Override // java.util.Comparator
    public final int compare(T r2, T r3) {
        Object r4 = ((Pair) r2).getSecond();
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type kotlin.Long");
        Object r5 = ((Pair) r3).getSecond();
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type kotlin.Long");
        return ComparisonsKt.compareValues((Long) r4, (Long) r5);
    }
}
