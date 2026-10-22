package com.bytedance.android.annie.debug.ui;

import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class h<T> implements Comparator<T> {
    public h() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T r1, T r10) {
        return ComparisonsKt.compareValues(((g) r1).c, ((g) r10).c);
    }
}
