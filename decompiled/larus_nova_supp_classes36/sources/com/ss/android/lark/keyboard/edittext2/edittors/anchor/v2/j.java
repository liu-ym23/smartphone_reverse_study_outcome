package com.ss.android.lark.keyboard.edittext2.edittors.anchor.v2;

import java.util.Comparator;
import kotlin.Triple;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class j<T> implements Comparator {
    public j() {
    }

    @Override // java.util.Comparator
    public final int compare(T r1, T r2) {
        return ComparisonsKt.compareValues((Integer) ((Triple) r1).getSecond(), (Integer) ((Triple) r2).getSecond());
    }
}
