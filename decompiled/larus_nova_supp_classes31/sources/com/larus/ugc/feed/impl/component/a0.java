package com.larus.ugc.feed.impl.component;

import java.util.Comparator;
import kotlin.Pair;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class a0<T> implements Comparator {
    public a0() {
    }

    @Override // java.util.Comparator
    public final int compare(T r1, T r2) {
        return ComparisonsKt.compareValues((Integer) ((Pair) r1).getFirst(), (Integer) ((Pair) r2).getFirst());
    }
}
