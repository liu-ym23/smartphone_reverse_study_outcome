package com.larus.video.impl.sdk.prefetch;

import java.util.Comparator;
import java.util.Map;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class f1<T> implements Comparator {
    public f1() {
    }

    @Override // java.util.Comparator
    public final int compare(T r3, T r4) {
        return ComparisonsKt.compareValues(Long.valueOf(((c) ((Map.Entry) r4).getValue()).a), Long.valueOf(((c) ((Map.Entry) r3).getValue()).a));
    }
}
