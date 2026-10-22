package com.larus.account.base.impl;

import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class MultiAccountServiceImpl$b<T> implements Comparator {
    public MultiAccountServiceImpl$b() {
    }

    @Override // java.util.Comparator
    public final int compare(T r3, T r4) {
        return ComparisonsKt.compareValues(Long.valueOf(((q38.b) r3).e()), Long.valueOf(((q38.b) r4).e()));
    }
}
