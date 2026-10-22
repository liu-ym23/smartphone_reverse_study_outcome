package com.bytedance.android.livesdk.gift.platform.core;

import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class v<T> implements Comparator<T> {
    public v() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T r1, T r2) {
        return ComparisonsKt.compareValues(Integer.valueOf(((j) r1).c), Integer.valueOf(((j) r2).c));
    }
}
