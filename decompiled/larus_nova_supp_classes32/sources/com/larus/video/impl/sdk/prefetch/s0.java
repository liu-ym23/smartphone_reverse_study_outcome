package com.larus.video.impl.sdk.prefetch;

import java.util.Comparator;
import java.util.Map;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class s0<T> implements Comparator {
    public s0() {
    }

    @Override // java.util.Comparator
    public final int compare(T r3, T r4) {
        return ComparisonsKt.compareValues(Long.valueOf(((g) ((Map.Entry) r4).getValue()).d), Long.valueOf(((g) ((Map.Entry) r3).getValue()).d));
    }
}
