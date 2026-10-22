package com.larus.disk.impl;

import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class e0<T> implements Comparator {
    public final /* synthetic */ Comparator a;

    public e0(c0 r1) {
        this.a = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T r3, T r4) {
        int r0 = this.a.compare(r3, r4);
        if (r0 == 0) goto L6;
        return r0;
    L6:
        return ComparisonsKt.compareValues(Long.valueOf(((p0) r4).d), Long.valueOf(((p0) r3).d));
    }
}
