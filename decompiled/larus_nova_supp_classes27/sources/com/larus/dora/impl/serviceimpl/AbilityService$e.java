package com.larus.dora.impl.serviceimpl;

import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class AbilityService$e<T> implements Comparator {
    public AbilityService$e() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T r1, T r2) {
        return ComparisonsKt.compareValues(Integer.valueOf(((AbilityService$b) r1).a), Integer.valueOf(((AbilityService$b) r2).a));
    }
}
