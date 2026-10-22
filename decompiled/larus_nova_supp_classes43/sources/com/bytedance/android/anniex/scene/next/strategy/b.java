package com.bytedance.android.anniex.scene.next.strategy;

import java.util.Comparator;
import kotlin.Pair;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b<T> implements Comparator<T> {
    public b() {
    }

    @Override // java.util.Comparator
    public final int compare(T r1, T r10) {
        return ComparisonsKt.compareValues((Double) ((Pair) r10).getSecond(), (Double) ((Pair) r1).getSecond());
    }
}
