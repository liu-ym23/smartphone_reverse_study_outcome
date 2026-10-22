package com.larus.dora.obric.device_management.setting.earbuds.broadcast;

import com.obric.oui.lisitem.OCardListItem;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class g1<T> implements FlowCollector {
    public final /* synthetic */ DoraObricEarbudsBroadcastSettingFragment a;

    public g1(DoraObricEarbudsBroadcastSettingFragment r1) {
        this.a = r1;
    }

    public final Object emit(Object r8, Continuation r9) {
        com.larus.dora.impl.noti_v3.overview.viewmodel.b r10 = (com.larus.dora.impl.noti_v3.overview.viewmodel.b) r8;
        DoraObricEarbudsBroadcastSettingFragment r11 = this.a;
        OCardListItem r0 = r11.p;
        String r1 = "";
        if (r0 == null) goto L5;
        r0.k("", r11.da0(140));
    L5:
        DoraObricEarbudsBroadcastSettingFragment r12 = this.a;
        OCardListItem r2 = r12.q;
        if (r2 == null) goto L12;
        int r5 = r10.d;
        if (r5 <= 0) goto L10;
        String r13 = r12.getString(2131902284, new Object[]{Boxing.boxInt(r5)});
    L11:
        r2.k(r13, this.a.da0(140));
        goto L12
    L10:
        r13 = "";
    L12:
        DoraObricEarbudsBroadcastSettingFragment r14 = this.a;
        OCardListItem r3 = r14.s;
        if (r3 == null) goto L19;
        int r6 = r10.e;
        if (r6 <= 0) goto L17;
        String r15 = r14.getString(2131902268, new Object[]{Boxing.boxInt(r6)});
    L18:
        r3.k(r15, this.a.da0(140));
        goto L19
    L17:
        r15 = "";
    L19:
        DoraObricEarbudsBroadcastSettingFragment r16 = this.a;
        OCardListItem r4 = r16.t;
        if (r4 == null) goto L25;
        int r7 = r10.f;
        if (r7 <= 0) goto L24;
        r1 = r16.getString(2131902303, new Object[]{Boxing.boxInt(r7)});
    L24:
        r4.k(r1, this.a.da0(140));
    L25:
        Integer r17 = r10.b;
        if (r17 == null) goto L30;
        DoraObricEarbudsBroadcastSettingFragment r18 = this.a;
        int r20 = r17.intValue();
        OCardListItem r21 = r18.w;
        if (r21 == null) goto L30;
        r21.k(r18.getString(r20), r18.da0(140));
    L30:
        Integer r22 = r10.a;
        if (r22 == null) goto L36;
        DoraObricEarbudsBroadcastSettingFragment r23 = this.a;
        int r24 = r22.intValue();
        OCardListItem r25 = r23.x;
        if (r25 == null) goto L36;
        r25.k(r23.getString(r24), r23.da0(140));
    L36:
        return Unit.INSTANCE;
    }
}
