package com.bytedance.ai.applet.services;

import java.util.Comparator;
import kotlin.Pair;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a<T> implements Comparator {
    public a() {
    }

    @Override // java.util.Comparator
    public final int compare(T r1, T r10) {
        return ComparisonsKt.compareValues((Long) ((Pair) r1).getSecond(), (Long) ((Pair) r10).getSecond());
    }
}
