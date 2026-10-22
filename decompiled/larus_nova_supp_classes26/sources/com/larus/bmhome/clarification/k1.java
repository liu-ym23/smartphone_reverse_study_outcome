package com.larus.bmhome.clarification;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final /* synthetic */ class k1 implements Function1 {
    public final /* synthetic */ ClarificationComponent a;

    public /* synthetic */ k1(ClarificationComponent r1) {
        this.a = r1;
    }

    public final Object invoke(Object r4) {
        ClarificationComponent r0 = this.a;
        int r5 = ((Integer) r4).intValue();
        d2 r1 = r0.n.a;
        if (r1 != null) goto L6;
        return null;
    L6:
        if (r5 >= CollectionsKt.getLastIndex(r1.h)) goto L19;
        View r6 = r0.A;
        if (r6 == null) goto L11;
        Context r7 = r6.getContext();
        if (r7 == null) goto L11;
    L18:
        return Integer.valueOf(v19.c.b(2130971843, r7, 2131242022));
    L11:
        ViewGroup r8 = r0.z;
        if (r8 == null) goto L14;
        r7 = r8.getContext();
    L15:
        if (r7 != null) goto L18;
        return null;
    L14:
        r7 = null;
        goto L15
    L19:
        return null;
    }
}
