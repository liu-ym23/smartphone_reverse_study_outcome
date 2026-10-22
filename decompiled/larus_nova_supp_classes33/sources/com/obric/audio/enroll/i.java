package com.obric.audio.enroll;

import java.util.Comparator;
import kotlin.Pair;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class i<T> implements Comparator {
    public i() {
    }

    @Override // java.util.Comparator
    public final int compare(T r1, T r2) {
        return ComparisonsKt.compareValues((String) ((Pair) r1).getFirst(), (String) ((Pair) r2).getFirst());
    }
}
