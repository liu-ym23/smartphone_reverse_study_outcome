package com.larus.disk.impl;

import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class s<T> implements Comparator {
    public final /* synthetic */ Comparator a;

    public s(q r1) {
        this.a = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T r3, T r4) {
        int r0 = this.a.compare(r3, r4);
        if (r0 != 0) goto L15;
        long r5 = ((com.larus.disk.api.h) r4).d;
        if (r5 != null) goto L9;
        r5 = -1L;
    L9:
        long r6 = ((com.larus.disk.api.h) r3).d;
        if (r6 != null) goto L14;
        r6 = -1L;
    L14:
        return ComparisonsKt.compareValues(r5, r6);
    L15:
        return r0;
    }
}
