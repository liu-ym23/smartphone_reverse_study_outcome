package com.ss.android.lark.officesdk.launcher;

import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class f<T> implements Comparator {
    public f() {
    }

    @Override // java.util.Comparator
    public final int compare(T r1, T r2) {
        return ComparisonsKt.compareValues(Integer.valueOf(((mm4.a) r1).getPriority()), Integer.valueOf(((mm4.a) r2).getPriority()));
    }
}
