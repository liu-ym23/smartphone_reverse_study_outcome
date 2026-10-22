package com.obric.assistant.cocreationreview.modules.proactive;

import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class p<T> implements Comparator {
    public final /* synthetic */ Comparator a;

    public p(o r1) {
        this.a = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T r3, T r4) {
        int r0 = this.a.compare(r3, r4);
        if (r0 == 0) goto L6;
        return r0;
    L6:
        return ComparisonsKt.compareValues(Double.valueOf(((q) r4).x), Double.valueOf(((q) r3).x));
    }
}
