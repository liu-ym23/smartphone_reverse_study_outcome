package com.bytedance.ai.applet.moa;

import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class l<T> implements Comparator {
    public l() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T r1, T r10) {
        return ComparisonsKt.compareValues(Integer.valueOf(((u2.f) r1).d()), Integer.valueOf(((u2.f) r10).d()));
    }
}
