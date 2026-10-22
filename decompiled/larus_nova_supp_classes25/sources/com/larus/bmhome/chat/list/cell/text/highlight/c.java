package com.larus.bmhome.chat.list.cell.text.highlight;

import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;
import kotlin.ranges.IntRange;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class c<T> implements Comparator {
    public c() {
    }

    @Override // java.util.Comparator
    public final int compare(T r1, T r2) {
        return ComparisonsKt.compareValues(Integer.valueOf(((IntRange) r1).getFirst()), Integer.valueOf(((IntRange) r2).getFirst()));
    }
}
