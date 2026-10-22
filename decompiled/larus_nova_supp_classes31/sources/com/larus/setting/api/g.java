package com.larus.setting.api;

import java.util.Comparator;
import java.util.Map;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class g<T> implements Comparator {
    public final /* synthetic */ Map a;

    public g(Map r1) {
        this.a = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T r3, T r4) {
        Integer r5 = (Integer) this.a.get(((zs9.b) r3).a);
        int r0 = Integer.MAX_VALUE;
        if (r5 == null) goto L5;
        int r6 = r5.intValue();
    L6:
        Integer r7 = Integer.valueOf(r6);
        Integer r8 = (Integer) this.a.get(((zs9.b) r4).a);
        if (r8 == null) goto L10;
        r0 = r8.intValue();
    L10:
        return ComparisonsKt.compareValues(r7, Integer.valueOf(r0));
    L5:
        r6 = Integer.MAX_VALUE;
        goto L6
    }
}
