package com.bytedance.android.live.core.tetris.layer.core.layout;

import java.util.Comparator;
import kotlin.Pair;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class c<T> implements Comparator<T> {
    public c() {
    }

    @Override // java.util.Comparator
    public final int compare(T r1, T r2) {
        return ComparisonsKt.compareValues((Integer) ((Pair) r1).getSecond(), (Integer) ((Pair) r2).getSecond());
    }
}
