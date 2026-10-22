package com.larus.dora.obric.device_management.setting.g.ota;

import android.content.Context;
import android.os.Bundle;
import com.larus.dora.obric.utils.DoraObricToastUtils;
import java.lang.ref.WeakReference;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class c0<T> implements FlowCollector {
    public final /* synthetic */ DoraObricGOTAFragment a;

    public c0(DoraObricGOTAFragment r1) {
        this.a = r1;
    }

    /* JADX WARN: Type inference failed for: r5v0, types: [com.larus.dora.obric.device_management.setting.g.ota.x] */
    public final Object emit(Object r8, Continuation r9) {
        com.larus.dora.impl.ota.g.u r10 = (com.larus.dora.impl.ota.g.u) r8;
        if (Intrinsics.areEqual(r10, com.larus.dora.impl.ota.g.u.c.a) == false) goto L19;
        DoraObricGOTAFragment r11 = this.a;
        int r12 = DoraObricGOTAFragment.N;
        Context r1 = r11.getContext();
        if (r1 == null) goto L47;
        com.obric.oui.dialog.v2.alert.c r13 = r11.D;
        if (r13 == null) goto L10;
        DoraObricGOTAFragment.W90(r13);
    L10:
        String r2 = r1.getString(2131902846);
        Bundle r14 = r11.getArguments();
        int r0 = -1;
        if (r14 == null) goto L14;
        r0 = r14.getInt("route_param_product_id", -1);
    L14:
        if (o59.a.m(Integer.valueOf(r0)) == false) goto L16;
        int r15 = 2131902586;
    L17:
        com.obric.oui.dialog.v2.alert.c r16 = DoraObricGOTAFragment.fa0(r11, r1, r2, r1.getString(r15), null, 24);
        r11.D = r16;
        DoraObricGOTAFragment.X90(r16);
        goto L47
    L16:
        r15 = 2131902845;
    L47:
        return Unit.INSTANCE;
    L19:
        if (Intrinsics.areEqual(r10, com.larus.dora.impl.ota.g.u.f.a) == false) goto L28;
        final DoraObricGOTAFragment r17 = this.a;
        int r18 = DoraObricGOTAFragment.N;
        final Context r20 = r17.getContext();
        if (r20 == null) goto L47;
        com.obric.oui.dialog.v2.alert.c r3 = r17.G;
        if (r3 == null) goto L26;
        DoraObricGOTAFragment.W90(r3);
    L26:
        com.obric.oui.dialog.v2.alert.g r4 = new com.obric.oui.dialog.v2.alert.g(r20);
        ((com.obric.oui.dialog.base.i) r4).c = true;
        r4.w = false;
        String r5 = r20.getString(2131902844);
        r4.j = false;
        r4.h = r5;
        r4.i = r20.getString(2131902843);
        com.obric.oui.dialog.v2.alert.g.c(r4);
        r4.e(r20.getString(2131902465), new u());
        r4.h(r20.getString(2131902854), new v(r20, r17));
        com.obric.oui.dialog.v2.alert.c r21 = r4.a();
        r17.G = r21;
        DoraObricGOTAFragment.X90(r21);
        goto L47
    L28:
        if ((r10 instanceof com.larus.dora.impl.ota.g.u.a) == true) goto L47;
        if ((r10 instanceof com.larus.dora.impl.ota.g.u.e) == true) goto L47;
        if ((r10 instanceof com.larus.dora.impl.ota.g.u.b) == false) goto L36;
        WeakReference<com.obric.oui.toast.f> r22 = DoraObricToastUtils.a;
        DoraObricToastUtils.a(this.a.requireContext(), 2131902879);
        goto L47
    L36:
        if (Intrinsics.areEqual(r10, com.larus.dora.impl.ota.g.u.d.a) == false) goto L45;
        final DoraObricGOTAFragment r23 = this.a;
        int r24 = DoraObricGOTAFragment.N;
        Context r6 = r23.getContext();
        if (r6 == null) goto L47;
        com.obric.oui.dialog.v2.alert.c r25 = r23.E;
        if (r25 == null) goto L43;
        DoraObricGOTAFragment.W90(r25);
    L43:
        com.obric.oui.dialog.v2.alert.c r26 = DoraObricGOTAFragment.fa0(r23, r6, r6.getString(2131902879), null, new x(r23), 4);
        r23.E = r26;
        DoraObricGOTAFragment.X90(r26);
        goto L47
    L45:
        throw new NoWhenBranchMatchedException();
    }
}
