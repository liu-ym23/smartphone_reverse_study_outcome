package com.larus.uaigc.chat;

import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class o<T> implements Comparator {
    public final /* synthetic */ Function1 a;

    public o(Function1 r1) {
        this.a = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T r2, T r3) {
        Function1 r0 = this.a;
        Comparable r4 = (Comparable) r0.invoke((CreationVideoManagerViewModel.b) r2);
        Function1 r1 = this.a;
        return ComparisonsKt.compareValues(r4, (Comparable) r1.invoke((CreationVideoManagerViewModel.b) r3));
    }
}
