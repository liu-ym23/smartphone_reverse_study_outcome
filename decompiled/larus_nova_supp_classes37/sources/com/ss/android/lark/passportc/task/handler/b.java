package com.ss.android.lark.passportc.task.handler;

import java.util.Comparator;
import k0c.d;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class b<T> implements Comparator {
    public b() {
    }

    @Override // java.util.Comparator
    public final int compare(T r1, T r2) {
        return ComparisonsKt.compareValues(Integer.valueOf(((d) r1).getOrder()), Integer.valueOf(((d) r2).getOrder()));
    }
}
