package com.bytedance.android.anniex.scene.next.strategy;

import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class e<T> implements Comparator<T> {
    public e() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T r10, T r11) {
        return ComparisonsKt.compareValues(Double.valueOf(((xa.c) r11).b), Double.valueOf(((xa.c) r10).b));
    }
}
