package com.larus.reach.runtime;

import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class o<T> implements Comparator {
    public o() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T r3, T r4) {
        return ComparisonsKt.compareValues(Long.valueOf(((ReachBannerRuntime.c) r3).c), Long.valueOf(((ReachBannerRuntime.c) r4).c));
    }
}
