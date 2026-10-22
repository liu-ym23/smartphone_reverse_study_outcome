package com.larus.business.markdown.impl.widget;

import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class c<T> implements Comparator<T> {
    public c() {
    }

    @Override // java.util.Comparator
    public final int compare(T r1, T r2) {
        return ComparisonsKt.compareValues(Integer.valueOf(((pw8.b) r1).priority()), Integer.valueOf(((pw8.b) r2).priority()));
    }
}
