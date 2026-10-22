package com.bytedance.badger.z;

import java.util.Comparator;
import kotlin.Pair;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class o0 implements Comparator {
    public o0() {
    }

    @Override // java.util.Comparator
    public final int compare(Object r1, Object r2) {
        return ComparisonsKt.compareValues((String) ((Pair) r1).component1(), (String) ((Pair) r2).component1());
    }
}
