package com.larus.business.markdown.impl.markwon;

import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class MarkwonContent$readText$2$a<T> implements Comparator<T> {
    public MarkwonContent$readText$2$a() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T r1, T r2) {
        return ComparisonsKt.compareValues(Integer.valueOf(((k) r1).b), Integer.valueOf(((k) r2).b));
    }
}
