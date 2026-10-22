package com.larus.chat.job.impl.page;

import java.util.Comparator;
import java.util.Map;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class s<T> implements Comparator {
    public s() {
    }

    @Override // java.util.Comparator
    public final int compare(T r1, T r2) {
        return ComparisonsKt.compareValues((Integer) ((Map.Entry) r1).getKey(), (Integer) ((Map.Entry) r2).getKey());
    }
}
