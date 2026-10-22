package com.ss.android.lark.flow.common.utils;

import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b<T> implements Comparator {
    public b() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T r1, T r2) {
        return ComparisonsKt.compareValues(Integer.valueOf(((a) r1).getType().getOrder()), Integer.valueOf(((a) r2).getType().getOrder()));
    }
}
