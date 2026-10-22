package com.google.common.collect;

import java.util.Iterator;
import java.util.function.BinaryOperator;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class e1 implements BinaryOperator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8952a;

    public /* synthetic */ e1(int r5) {
        this.f8952a = r5;
    }

    @Override // java.util.function.BiFunction
    public final Object apply(Object r5, Object r10) {
        int r11 = 0;
        switch(this.f8952a) {
            case 0: goto L38;
            case 1: goto L33;
            case 2: goto L31;
            case 3: goto L30;
            case 4: goto L27;
            case 5: goto L25;
            case 6: goto L24;
            case 7: goto L16;
            case 8: goto L14;
            case 9: goto L12;
            case 10: goto L10;
            case 11: goto L8;
            case 12: goto L6;
            default: goto L4;
        };
    L4:
        z4 r12 = (z4) r5;
        r12.f9244a.addAll(((z4) r10).f9244a);
        return r12;
    L6:
        z7 r13 = (z7) r5;
        int r14 = ImmutableSortedMultiset.e;
        r13.addAll((z7) r10);
        return r13;
    L8:
        v4 r15 = (v4) r5;
        r15.k((v4) r10);
        return r15;
    L10:
        q7 r16 = (q7) r5;
        r16.putAll((q7) r10);
        return r16;
    L12:
        s4 r17 = (s4) r5;
        r17.a((s4) r10);
        return r17;
    L14:
        v3 r18 = (v3) r5;
        r18.a((v3) r10);
        return r18;
    L16:
        y4 r19 = (y4) r5;
        y4 r20 = (y4) r10;
        if (r19.f9088c == false) goto L20;
        r19.E0();
        r19.f9088c = false;
    L20:
        if (r11 >= r20.f) goto L22;
        r19.F0(r20.e[r11]);
        r11 = r11 + 1;
        goto L20
    L22:
        return r19;
    L25:
        z7 r21 = (z7) r5;
        r21.addAll((z7) r10);
        return r21;
    L27:
        j4 r22 = (j4) r5;
        r22.f9036a.addAll(((j4) r10).f9036a);
        return r22;
    L31:
        u3 r23 = (u3) r5;
        u3 r24 = (u3) r10;
        r23.getClass();
        r24.getClass();
        Object[] r25 = r24.f9179b;
        int r26 = r24.f9180c;
        r23.E0(r23.f9180c + r26);
        System.arraycopy(r25, 0, r23.f9179b, r23.f9180c, r26);
        r23.f9180c += r26;
        return r23;
    L33:
        m4 r27 = (m4) r5;
        r27.getClass();
        Iterator r28 = ((m4) r10).f9072a.iterator();
    L35:
        if (r28.hasNext() == false) goto L37;
        Range r29 = (Range) r28.next();
        com.google.common.base.b0.h("range must not be empty, but was %s", !r29.isEmpty(), r29);
        r27.f9072a.add(r29);
        goto L35
    L37:
        return r27;
    L38:
        p3 r30 = (p3) r5;
        r30.k((p3) r10);
        return r30;
    L24:
        return ((x3) r5).e((x3) r10);
    L30:
        return ((n4) r5).D0((n4) r10);
    }
}
