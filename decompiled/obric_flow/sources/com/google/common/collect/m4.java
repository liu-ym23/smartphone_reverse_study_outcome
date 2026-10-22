package com.google.common.collect;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/* JADX INFO: loaded from: classes2.dex */
public final class m4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f9072a;

    public m4() {
        this.f9072a = new ArrayList();
    }

    public final ImmutableRangeSet a() {
        ArrayList r10 = this.f9072a;
        Object[] r5 = new Object[r10.size()];
        Collections.sort(r10, Range.rangeLexOrdering());
        j5 r11 = p7.b0(r10.iterator());
        int r12 = 0;
    L4:
        if (r11.hasNext() == false) goto L15;
        Range r13 = (Range) r11.next();
    L7:
        if (r11.hasNext() == false) goto L11;
        Range r14 = (Range) r11.a();
        if (r13.isConnected(r14) == false) goto L11;
        com.google.common.base.b0.k(r13.intersection(r14).isEmpty(), "Overlapping ranges not permitted but found %s overlapping %s", r13, r14);
        r13 = r13.span((Range) r11.next());
    L11:
        r13.getClass();
        int r15 = r12 + 1;
        if (r5.length >= r15) goto L14;
        r5 = Arrays.copyOf(r5, p7.B(r5.length, r15));
    L14:
        r5[r12] = r13;
        r12 = r15;
        goto L4
    L15:
        ImmutableList r16 = ImmutableList.asImmutableList(r5, r12);
        if (r16.isEmpty() == false) goto L20;
        return ImmutableRangeSet.of();
    L20:
        if (r16.size() != 1) goto L26;
        if (((Range) p7.H(r16)).equals(Range.all()) == false) goto L26;
        return ImmutableRangeSet.all();
    L26:
        return new ImmutableRangeSet(r16);
    }
}
