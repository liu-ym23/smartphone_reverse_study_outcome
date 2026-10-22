package com.ss.android.lark.chat.message.menu;

import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;
import kotlin.ranges.IntRange;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class e<T> implements Comparator {
    public e() {
    }

    @Override // java.util.Comparator
    public final int compare(T r1, T r2) {
        return ComparisonsKt.compareValues(Integer.valueOf(((IntRange) r1).getFirst()), Integer.valueOf(((IntRange) r2).getFirst()));
    }
}
