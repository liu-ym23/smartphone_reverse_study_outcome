package com.larus.asr.view;

import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class a0<T> implements Comparator {
    public a0() {
    }

    @Override // java.util.Comparator
    public final int compare(T r1, T r2) {
        return ComparisonsKt.compareValues(Integer.valueOf(((y48.i) r2).c), Integer.valueOf(((y48.i) r1).c));
    }
}
