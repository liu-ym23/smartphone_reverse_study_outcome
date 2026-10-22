package com.ss.android.lark.officesdk.minutes.ui.record.recording.subtitle.ui;

import java.util.Comparator;
import kotlin.collections.IndexedValue;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class l<T> implements Comparator {
    public final /* synthetic */ Comparator a;

    public l(i r1) {
        this.a = r1;
    }

    @Override // java.util.Comparator
    public final int compare(T r2, T r3) {
        int r0 = this.a.compare(r2, r3);
        if (r0 == 0) goto L6;
        return r0;
    L6:
        return ComparisonsKt.compareValues(Integer.valueOf(((IndexedValue) r2).getIndex()), Integer.valueOf(((IndexedValue) r3).getIndex()));
    }
}
