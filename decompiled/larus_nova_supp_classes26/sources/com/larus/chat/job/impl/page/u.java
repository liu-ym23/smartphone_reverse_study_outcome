package com.larus.chat.job.impl.page;

import com.larus.im.bean.job.AIJob;
import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class u<T> implements Comparator {
    public u() {
    }

    @Override // java.util.Comparator
    public final int compare(T r3, T r4) {
        return ComparisonsKt.compareValues(Long.valueOf(((AIJob) r4).getCreateTime()), Long.valueOf(((AIJob) r3).getCreateTime()));
    }
}
