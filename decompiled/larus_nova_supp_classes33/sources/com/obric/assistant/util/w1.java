package com.obric.assistant.util;

import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class w1<T> implements Comparator {
    public final /* synthetic */ Comparator a;

    public w1(u1 r1) {
        this.a = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T r2, T r3) {
        int r0 = this.a.compare(r2, r3);
        if (r0 == 0) goto L6;
        return r0;
    L6:
        return ComparisonsKt.compareValues(Integer.valueOf(((ObricMentionHighlightHelper.b) r2).a), Integer.valueOf(((ObricMentionHighlightHelper.b) r3).a));
    }
}
