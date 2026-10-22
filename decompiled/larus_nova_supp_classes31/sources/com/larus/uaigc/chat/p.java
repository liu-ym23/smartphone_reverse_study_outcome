package com.larus.uaigc.chat;

import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class p<T> implements Comparator {
    public final /* synthetic */ Comparator a;
    public final /* synthetic */ String b;

    public p(o r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T r4, T r5) {
        int r0 = this.a.compare(r4, r5);
        if (r0 == 0) goto L6;
        return r0;
    L6:
        if (Intrinsics.areEqual(((CreationVideoManagerViewModel.b) r4).a, this.b) == false) goto L8;
        int r6 = 0;
    L10:
        if (Intrinsics.areEqual(((CreationVideoManagerViewModel.b) r5).a, this.b) == false) goto L12;
        int r7 = 0;
    L14:
        return ComparisonsKt.compareValues(r6, r7);
    L12:
        r7 = 1;
        goto L14
    L8:
        r6 = 1;
        goto L10
    }
}
