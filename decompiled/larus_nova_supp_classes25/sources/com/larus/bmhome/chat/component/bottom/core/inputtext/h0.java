package com.larus.bmhome.chat.component.bottom.core.inputtext;

import java.util.Comparator;
import kotlin.Triple;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class h0<T> implements Comparator {
    public h0() {
    }

    @Override // java.util.Comparator
    public final int compare(T r1, T r2) {
        return ComparisonsKt.compareValues((Integer) ((Triple) r2).getFirst(), (Integer) ((Triple) r1).getFirst());
    }
}
