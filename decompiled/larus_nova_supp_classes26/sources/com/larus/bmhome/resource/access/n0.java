package com.larus.bmhome.resource.access;

import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class n0<T> implements Comparator {
    public n0() {
    }

    @Override // java.util.Comparator
    public final int compare(T r1, T r2) {
        return ComparisonsKt.compareValues(Integer.valueOf(((l0) r1).d().getOrder()), Integer.valueOf(((l0) r2).d().getOrder()));
    }
}
