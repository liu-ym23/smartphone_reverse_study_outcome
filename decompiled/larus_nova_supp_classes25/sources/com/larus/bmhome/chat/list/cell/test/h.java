package com.larus.bmhome.chat.list.cell.test;

import android.content.Context;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class h implements Function1 {
    public final /* synthetic */ CrowdTestSelectionCell a;
    public final /* synthetic */ Function0 b;
    public final /* synthetic */ TextView c;

    public /* synthetic */ h(CrowdTestSelectionCell r1, i r2, TextView r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final Object invoke(Object r6) {
        CrowdTestSelectionCell r0 = this.a;
        Function0 r1 = this.b;
        TextView r2 = this.c;
        TextView r7 = (TextView) r6;
        int r3 = CrowdTestSelectionCell.k;
        Intrinsics.checkNotNullParameter(r7, "it");
        Iterator r4 = ((ArrayList) r0.i).iterator();
    L4:
        if (r4.hasNext() == false) goto L9;
        TextView r5 = (TextView) r4.next();
        if (r5 == null) goto L4;
        CrowdTestSelectionCell.r(r5, false);
        goto L4
    L9:
        CrowdTestSelectionCell.r(r7, true);
        r1.invoke();
        t19.s r8 = t19.s.a;
        Context r9 = r2.getContext();
        String r10 = r2.getContext().getString(2131910475);
        r8.getClass();
        t19.s.p(r9, r10);
        return Unit.INSTANCE;
    }
}
