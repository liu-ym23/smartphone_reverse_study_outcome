package com.larus.dora.obric.device_management.setting.g.ota;

import android.content.Context;
import com.larus.dora.obric.utils.DoraObricToastUtils;
import java.lang.ref.WeakReference;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class a0<T> implements FlowCollector {
    public final /* synthetic */ DoraObricGOTAFragment a;

    public a0(DoraObricGOTAFragment r1) {
        this.a = r1;
    }

    public final Object emit(Object r7, Continuation r8) {
        com.larus.dora.impl.ota.a r9 = (com.larus.dora.impl.ota.a) r7;
        if (Intrinsics.areEqual(r9, com.larus.dora.impl.ota.a.f.a) == false) goto L12;
        DoraObricGOTAFragment r10 = this.a;
        int r11 = DoraObricGOTAFragment.N;
        Context r1 = r10.getContext();
        if (r1 == null) goto L44;
        com.obric.oui.dialog.v2.alert.c r12 = r10.H;
        if (r12 == null) goto L10;
        DoraObricGOTAFragment.W90(r12);
    L10:
        com.obric.oui.dialog.v2.alert.c r13 = DoraObricGOTAFragment.fa0(r10, r1, r1.getString(2131902850), r1.getString(2131902849), null, 24);
        r10.H = r13;
        DoraObricGOTAFragment.X90(r13);
    L44:
        return Unit.INSTANCE;
    L12:
        if (Intrinsics.areEqual(r9, com.larus.dora.impl.ota.a.c.a) == false) goto L15;
        WeakReference<com.obric.oui.toast.f> r14 = DoraObricToastUtils.a;
        DoraObricToastUtils.a(this.a.requireContext(), 2131902866);
        goto L44
    L15:
        if (Intrinsics.areEqual(r9, com.larus.dora.impl.ota.a.C0090a.a) == false) goto L17;
    L42:
        WeakReference<com.obric.oui.toast.f> r15 = DoraObricToastUtils.a;
        DoraObricToastUtils.a(this.a.requireContext(), 2131902879);
        goto L44
    L17:
        if (Intrinsics.areEqual(r9, com.larus.dora.impl.ota.a.e.a) == true) goto L42;
        if ((r9 instanceof com.larus.dora.impl.ota.a.d) == false) goto L23;
        DoraObricGOTAFragment r16 = this.a;
        e49.a r17 = ((com.larus.dora.impl.ota.a.d) r9).a;
        int r0 = DoraObricGOTAFragment.N;
        r16.pa0(r17);
        goto L44
    L23:
        if ((r9 instanceof com.larus.dora.impl.ota.a.b) == false) goto L32;
        DoraObricGOTAFragment r18 = this.a;
        int r20 = DoraObricGOTAFragment.N;
        Context r2 = r18.getContext();
        if (r2 == null) goto L44;
        com.obric.oui.dialog.v2.alert.c r21 = r18.F;
        if (r21 == null) goto L30;
        DoraObricGOTAFragment.W90(r21);
    L30:
        com.obric.oui.dialog.v2.alert.c r22 = DoraObricGOTAFragment.fa0(r18, r2, r2.getString(2131902855), null, null, 28);
        r18.F = r22;
        DoraObricGOTAFragment.X90(r22);
        goto L44
    L32:
        if ((r9 instanceof com.larus.dora.impl.ota.a.g) == false) goto L41;
        DoraObricGOTAFragment r23 = this.a;
        int r24 = DoraObricGOTAFragment.N;
        Context r3 = r23.getContext();
        if (r3 == null) goto L44;
        com.obric.oui.dialog.v2.alert.c r25 = r23.C;
        if (r25 == null) goto L39;
        DoraObricGOTAFragment.W90(r25);
    L39:
        com.obric.oui.dialog.v2.alert.c r26 = DoraObricGOTAFragment.fa0(r23, r3, r3.getString(2131902875), null, null, 28);
        r23.C = r26;
        DoraObricGOTAFragment.X90(r26);
        goto L44
    L41:
        throw new NoWhenBranchMatchedException();
    }
}
