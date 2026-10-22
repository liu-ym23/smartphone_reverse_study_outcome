package com.obric.assistant.util;

import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class u1<T> implements Comparator {
    public u1() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T r2, T r3) {
        ObricMentionHighlightHelper.b r4 = (ObricMentionHighlightHelper.b) r3;
        ObricMentionHighlightHelper.b r5 = (ObricMentionHighlightHelper.b) r2;
        return ComparisonsKt.compareValues(Integer.valueOf(r4.b - r4.a), Integer.valueOf(r5.b - r5.a));
    }
}
