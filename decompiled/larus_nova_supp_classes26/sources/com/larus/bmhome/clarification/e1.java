package com.larus.bmhome.clarification;

import android.view.View;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final /* synthetic */ class e1 implements Function1 {
    public final /* synthetic */ ClarificationComponent a;

    public /* synthetic */ e1(ClarificationComponent r1) {
        this.a = r1;
    }

    public final Object invoke(Object r7) {
        ClarificationComponent r0 = this.a;
        int r8 = ((Integer) r7).intValue();
        d2 r1 = r0.n.a;
        if (r1 == null) goto L5;
        int r2 = r1.j;
    L6:
        if (r1 == null) goto L8;
        r0.X3(r1, r2);
    L8:
        r0.n.c(r8);
        Boolean r3 = null;
        if (r8 != r2) goto L11;
        r0.N = null;
    L17:
        String r4 = null;
    L19:
        if (r4 == null) goto L26;
        d2 r5 = r0.n.a;
        if (r5 == null) goto L26;
        if (r8 >= r2) goto L24;
        String r6 = "back";
    L25:
        r0.W3(r5, r8, r6, r4);
        goto L26
    L24:
        r6 = "next";
    L26:
        if (r8 == r2) goto L30;
        d2 r9 = r0.n.a;
        if (r9 == null) goto L30;
        r0.V3(r9, r8);
    L30:
        d2 r10 = r0.n.a;
        if (r10 == null) goto L38;
        List<z1> r11 = r10.l;
        if (r11 == null) goto L38;
        z1 r12 = (z1) CollectionsKt.getOrNull(r11, r8);
        if (r12 == null) goto L38;
        r3 = Boolean.valueOf(y1.a(r12, null).d);
    L38:
        if (Intrinsics.areEqual(r3, Boolean.FALSE) == false) goto L42;
        View r13 = r0.A;
        if (r13 == null) goto L42;
        r13.postOnAnimation(new b1(r0, r8));
    L42:
        d2 r14 = r0.n.a;
        if (r14 == null) goto L47;
        ze8.b r15 = r14.k;
        if (r15 == null) goto L47;
        r15.e(r8);
    L47:
        ICoreInputAbility r16 = r0.H3();
        if (r16 == null) goto L50;
        r16.qp(false);
    L50:
        r0.l4();
        return Unit.INSTANCE;
    L11:
        Integer r17 = r0.N;
        if (r17 != null) goto L15;
    L18:
        r4 = "gesture";
        goto L19
    L15:
        if (r17.intValue() != r8) goto L18;
        r0.N = null;
        goto L17
    L5:
        r2 = -1;
        goto L6
    }
}
