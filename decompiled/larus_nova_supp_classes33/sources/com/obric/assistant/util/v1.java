package com.obric.assistant.util;

import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class v1<T> implements Comparator {
    public v1() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T r1, T r2) {
        return ComparisonsKt.compareValues(Integer.valueOf(((ObricMentionHighlightHelper.b) r1).a), Integer.valueOf(((ObricMentionHighlightHelper.b) r2).a));
    }
}
