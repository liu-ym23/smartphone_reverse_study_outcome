package com.larus.uaigc.chat;

import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class q<T> implements Comparator {
    public final /* synthetic */ Comparator a;

    public q(p r1) {
        this.a = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T r2, T r3) {
        int r0 = this.a.compare(r2, r3);
        if (r0 == 0) goto L6;
        return r0;
    L6:
        return ComparisonsKt.compareValues(((CreationVideoManagerViewModel.b) r2).a, ((CreationVideoManagerViewModel.b) r3).a);
    }
}
