package com.larus.bmhome.resource.access;

import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class b1<T> implements Comparator {
    public final /* synthetic */ Comparator a;

    public b1(a1 r1) {
        this.a = r1;
    }

    @Override // java.util.Comparator
    public final int compare(T r2, T r3) {
        int r0 = this.a.compare(r2, r3);
        if (r0 == 0) goto L6;
        return r0;
    L6:
        return ComparisonsKt.compareValues(((ResourceUploadSceneResolver) r2).getKey(), ((ResourceUploadSceneResolver) r3).getKey());
    }
}
