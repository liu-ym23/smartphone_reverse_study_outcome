package com.larus.bmhome.resource.access;

import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a1<T> implements Comparator {
    public a1() {
    }

    @Override // java.util.Comparator
    public final int compare(T r1, T r2) {
        ((ResourceUploadSceneResolver) r1).getPriority();
        ((ResourceUploadSceneResolver) r2).getPriority();
        return ComparisonsKt.compareValues(0, 0);
    }
}
