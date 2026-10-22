package com.larus.drive.sdk.impl.service;

import java.util.Comparator;
import java.util.Map;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class m<T> implements Comparator {
    public final /* synthetic */ Comparator a;

    public m(l r1) {
        this.a = r1;
    }

    @Override // java.util.Comparator
    public final int compare(T r2, T r3) {
        int r0 = this.a.compare(r2, r3);
        if (r0 == 0) goto L6;
        return r0;
    L6:
        return ComparisonsKt.compareValues(Integer.valueOf(((String) ((Map.Entry) r2).getKey()).length()), Integer.valueOf(((String) ((Map.Entry) r3).getKey()).length()));
    }
}
