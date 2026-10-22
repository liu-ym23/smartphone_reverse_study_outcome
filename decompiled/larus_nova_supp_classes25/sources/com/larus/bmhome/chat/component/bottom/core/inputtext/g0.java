package com.larus.bmhome.chat.component.bottom.core.inputtext;

import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class g0<T> implements Comparator {
    public g0() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T r1, T r2) {
        return ComparisonsKt.compareValues(Integer.valueOf(((f0.a) r1).a.getFirst()), Integer.valueOf(((f0.a) r2).a.getFirst()));
    }
}
