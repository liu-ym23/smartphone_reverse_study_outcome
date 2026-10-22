package com.larus.drive.sdk.impl.service;

import java.util.Comparator;
import java.util.Map;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class l<T> implements Comparator {
    public final /* synthetic */ k a;

    public l(k r1) {
        this.a = r1;
    }

    @Override // java.util.Comparator
    public final int compare(T r2, T r3) {
        return ComparisonsKt.compareValues(Integer.valueOf(k.g(this.a, (String) ((Map.Entry) r2).getKey())), Integer.valueOf(k.g(this.a, (String) ((Map.Entry) r3).getKey())));
    }
}
