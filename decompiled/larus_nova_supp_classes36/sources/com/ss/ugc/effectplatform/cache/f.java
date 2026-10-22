package com.ss.ugc.effectplatform.cache;

import java.util.Comparator;
import java.util.Map;
import kotlin.Pair;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class f<T> implements Comparator<T> {
    public final /* synthetic */ Map a;

    public f(Map r1) {
        this.a = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T r3, T r4) {
        Pair r5 = (Pair) this.a.get((String) r4);
        Long r0 = null;
        if (r5 == null) goto L5;
        Long r6 = (Long) r5.getSecond();
    L6:
        Pair r7 = (Pair) this.a.get((String) r3);
        if (r7 == null) goto L10;
        r0 = (Long) r7.getSecond();
    L10:
        return ComparisonsKt.compareValues(r6, r0);
    L5:
        r6 = null;
        goto L6
    }
}
