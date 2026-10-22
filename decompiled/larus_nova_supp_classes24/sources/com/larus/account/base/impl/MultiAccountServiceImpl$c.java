package com.larus.account.base.impl;

import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class MultiAccountServiceImpl$c<T> implements Comparator {
    public final /* synthetic */ Comparator a;

    public MultiAccountServiceImpl$c(MultiAccountServiceImpl$b r1) {
        this.a = r1;
    }

    @Override // java.util.Comparator
    public final int compare(T r2, T r3) {
        int r0 = this.a.compare(r2, r3);
        if (r0 != 0) goto L14;
        String r4 = ((q38.b) r2).j();
        String r1 = "";
        if (r4 != null) goto L8;
        r4 = "";
    L8:
        String r5 = ((q38.b) r3).j();
        if (r5 == null) goto L13;
        r1 = r5;
    L13:
        return ComparisonsKt.compareValues(r4, r1);
    L14:
        return r0;
    }
}
