package com.obric.assistant.cocreationreview.modules.proactive;

import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class o<T> implements Comparator {
    public o() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T r3, T r4) {
        return ComparisonsKt.compareValues(Long.valueOf(((q) r4).f), Long.valueOf(((q) r3).f));
    }
}
