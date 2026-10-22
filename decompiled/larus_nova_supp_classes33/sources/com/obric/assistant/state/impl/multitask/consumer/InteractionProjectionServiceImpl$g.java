package com.obric.assistant.state.impl.multitask.consumer;

import aha.l;
import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class InteractionProjectionServiceImpl$g<T> implements Comparator {
    public final /* synthetic */ Comparator a;

    public InteractionProjectionServiceImpl$g(InteractionProjectionServiceImpl$f r1) {
        this.a = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T r2, T r3) {
        int r0 = this.a.compare(r2, r3);
        if (r0 == 0) goto L6;
        return r0;
    L6:
        return ComparisonsKt.compareValues(((l) r2).f(), ((l) r3).f());
    }
}
