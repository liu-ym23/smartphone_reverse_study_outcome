package com.larus.disk.impl;

import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class q<T> implements Comparator {
    public q() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T r3, T r4) {
        boolean r0 = true;
        if (((com.larus.disk.api.h) r3).d != null) goto L5;
        boolean r5 = true;
    L6:
        Boolean r6 = Boolean.valueOf(r5);
        if (((com.larus.disk.api.h) r4).d == null) goto L11;
        r0 = false;
    L11:
        return ComparisonsKt.compareValues(r6, Boolean.valueOf(r0));
    L5:
        r5 = false;
        goto L6
    }
}
