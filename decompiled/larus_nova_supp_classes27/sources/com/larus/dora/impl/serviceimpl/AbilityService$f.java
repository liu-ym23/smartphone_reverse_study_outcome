package com.larus.dora.impl.serviceimpl;

import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class AbilityService$f<T> implements Comparator {
    public final /* synthetic */ Comparator a;

    public AbilityService$f(AbilityService$e r1) {
        this.a = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T r2, T r3) {
        int r0 = this.a.compare(r2, r3);
        if (r0 == 0) goto L6;
        return r0;
    L6:
        return ComparisonsKt.compareValues(Integer.valueOf(((AbilityService$b) r2).b), Integer.valueOf(((AbilityService$b) r3).b));
    }
}
