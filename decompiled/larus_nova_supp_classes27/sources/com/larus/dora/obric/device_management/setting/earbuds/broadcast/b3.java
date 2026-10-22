package com.larus.dora.obric.device_management.setting.earbuds.broadcast;

import com.obric.oui.lisitem.OCardListItem;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class b3<T> implements FlowCollector {
    public final /* synthetic */ DoraObricEarbudsSocialMessageFragment a;

    public b3(DoraObricEarbudsSocialMessageFragment r1) {
        this.a = r1;
    }

    public final Object emit(Object r6, Continuation r7) {
        q59.a r8 = (q59.a) r6;
        DoraObricEarbudsSocialMessageFragment r9 = this.a;
        r9.m = r8.c;
        r9.n = r8.d;
        OCardListItem r0 = r9.h;
        if (r0 == null) goto L5;
        String r10 = r9.Z90().resolveSingleMessageSummary(r8.c);
        int r2 = OCardListItem.I;
        r0.k(r10, -1);
    L5:
        DoraObricEarbudsSocialMessageFragment r11 = this.a;
        OCardListItem r1 = r11.i;
        if (r1 == null) goto L8;
        String r12 = r11.Z90().resolveGroupMessageSummary(r8.d);
        int r3 = OCardListItem.I;
        r1.k(r12, -1);
    L8:
        DoraObricEarbudsSocialMessageFragment r13 = this.a;
        OCardListItem r4 = r13.j;
        if (r4 == null) goto L18;
        String r14 = r13.Z90().resolveSpecialMessageSummary(r8.e, r8.f);
        DoraObricEarbudsSocialMessageFragment r15 = this.a;
        if (r14.length() != 0) goto L13;
        boolean r5 = true;
    L14:
        if (r5 == false) goto L16;
        r14 = r15.getString(2131902303, new Object[]{Boxing.boxInt(0)});
    L16:
        int r16 = OCardListItem.I;
        r4.k(r14, -1);
        goto L18
    L13:
        r5 = false;
    L18:
        return Unit.INSTANCE;
    }
}
