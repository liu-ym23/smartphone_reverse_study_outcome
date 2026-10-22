package com.larus.project;

import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class f<T> implements Comparator {
    public f() {
    }

    @Override // java.util.Comparator
    public final int compare(T r1, T r2) {
        return ComparisonsKt.compareValues(Integer.valueOf(((com.larus.bmhome.taskskill.service.h) r2).a.displayOrder), Integer.valueOf(((com.larus.bmhome.taskskill.service.h) r1).a.displayOrder));
    }
}
