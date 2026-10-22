package com.obric.assistant.state.impl.multitask.consumer;

import aha.l;
import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class InteractionProjectionServiceImpl$f<T> implements Comparator {
    public final /* synthetic */ InteractionProjectionServiceImpl a;

    public InteractionProjectionServiceImpl$f(InteractionProjectionServiceImpl r1) {
        this.a = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T r2, T r3) {
        return ComparisonsKt.compareValues(Integer.valueOf(InteractionProjectionServiceImpl.d(this.a, ((l) r2).e())), Integer.valueOf(InteractionProjectionServiceImpl.d(this.a, ((l) r3).e())));
    }
}
