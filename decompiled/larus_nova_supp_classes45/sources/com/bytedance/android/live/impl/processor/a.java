package com.bytedance.android.live.impl.processor;

import com.bytedance.android.live.strategy.api.CombineInfo;
import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a<T> implements Comparator<T> {
    public a() {
    }

    @Override // java.util.Comparator
    public final int compare(T r1, T r2) {
        return ComparisonsKt.compareValues(((CombineInfo) r2).getPriority(), ((CombineInfo) r1).getPriority());
    }
}
