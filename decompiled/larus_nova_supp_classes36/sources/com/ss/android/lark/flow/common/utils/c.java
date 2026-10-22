package com.ss.android.lark.flow.common.utils;

import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c<T> implements Comparator {
    public final /* synthetic */ Comparator a;

    public c(b r1) {
        this.a = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T r2, T r3) {
        int r0 = this.a.compare(r2, r3);
        if (r0 == 0) goto L6;
        return r0;
    L6:
        return ComparisonsKt.compareValues(Integer.valueOf(((a) r2).b), Integer.valueOf(((a) r3).b));
    }
}
