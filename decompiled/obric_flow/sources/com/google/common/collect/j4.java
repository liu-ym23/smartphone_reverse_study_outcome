package com.google.common.collect;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class j4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f9036a;

    public j4() {
        this.f9036a = new ArrayList();
    }

    public final ImmutableRangeMap a() {
        ArrayList r10 = this.f9036a;
        Collections.sort(r10, Range.rangeLexOrdering().onKeys());
        Object[] r5 = new Object[r10.size()];
        Object[] r11 = new Object[r10.size()];
        int r12 = 0;
        int r13 = 0;
        int r14 = 0;
    L4:
        if (r12 >= r10.size()) goto L22;
        Range r15 = (Range) ((Map.Entry) r10.get(r12)).getKey();
        if (r12 <= 0) goto L14;
        Range r16 = (Range) ((Map.Entry) r10.get(r12 - 1)).getKey();
        if (r15.isConnected(r16) == false) goto L14;
        if (r15.intersection(r16).isEmpty() == true) goto L14;
        String r17 = String.valueOf(r16);
        String r18 = String.valueOf(r15);
        StringBuilder r19 = new StringBuilder(r18.length() + (r17.length() + 47));
        r19.append("Overlapping ranges: range ");
        r19.append(r17);
        r19.append(" overlaps with entry ");
        r19.append(r18);
        throw new IllegalArgumentException(r19.toString());
    L14:
        r15.getClass();
        int r20 = r13 + 1;
        if (r5.length >= r20) goto L17;
        r5 = Arrays.copyOf(r5, p7.B(r5.length, r20));
    L17:
        r5[r13] = r15;
        Object r21 = ((Map.Entry) r10.get(r12)).getValue();
        r21.getClass();
        int r22 = r14 + 1;
        if (r11.length >= r22) goto L20;
        r11 = Arrays.copyOf(r11, p7.B(r11.length, r22));
    L20:
        r11[r14] = r21;
        r12 = r12 + 1;
        r14 = r22;
        r13 = r20;
        goto L4
    L22:
        return new ImmutableRangeMap(ImmutableList.asImmutableList(r5, r13), ImmutableList.asImmutableList(r11, r14));
    }

    public final void b(Range r5, Object r10) {
        r5.getClass();
        r10.getClass();
        com.google.common.base.b0.h("Range must not be empty, but was %s", !r5.isEmpty(), r5);
        this.f9036a.add(new ImmutableEntry(r5, r10));
    }
}
