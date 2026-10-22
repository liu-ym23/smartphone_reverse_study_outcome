package com.bytedance.android.ec.core.utils;

import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class o1<T> implements Comparator<T> {
    public o1() {
    }

    @Override // java.util.Comparator
    public final int compare(T r10, T r11) {
        boolean r0 = r10 instanceof m1;
        Integer r1 = null;
        Object r12 = r10;
        if (r0 == true) goto L5;
        r12 = (T) null;
    L5:
        m1 r13 = (m1) r12;
        if (r13 == null) goto L8;
        Integer r14 = Integer.valueOf(r13.a);
    L9:
        boolean r15 = r11 instanceof m1;
        Object r16 = r11;
        if (r15 == true) goto L12;
        r16 = (T) null;
    L12:
        m1 r17 = (m1) r16;
        if (r17 == null) goto L16;
        r1 = Integer.valueOf(r17.a);
    L16:
        return ComparisonsKt.compareValues(r14, r1);
    L8:
        r14 = null;
        goto L9
    }
}
