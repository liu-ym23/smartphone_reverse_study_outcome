package com.larus.video.impl.sdk.prefetch;

import com.larus.platform.api.w4;
import java.util.Comparator;
import java.util.Map;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class g1<T> implements Comparator {
    public g1() {
    }

    @Override // java.util.Comparator
    public final int compare(T r3, T r4) {
        return ComparisonsKt.compareValues(Long.valueOf(((w4) ((Map.Entry) r4).getValue()).b), Long.valueOf(((w4) ((Map.Entry) r3).getValue()).b));
    }
}
