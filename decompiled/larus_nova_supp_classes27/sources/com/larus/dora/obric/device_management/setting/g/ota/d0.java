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
public final class d0<T> implements FlowCollector {
    public final /* synthetic */ DoraObricGOTAFragment a;

    public d0(DoraObricGOTAFragment r1) {
        this.a = r1;
    }

    public final Object emit(Object r4, Continuation r5) {
        com.larus.dora.impl.ota.g.w r6 = (com.larus.dora.impl.ota.g.w) r4;
        if (Intrinsics.areEqual(r6, com.larus.dora.impl.ota.g.w.a.a) == false) goto L12;
        final DoraObricGOTAFragment r7 = this.a;
        int r8 = DoraObricGOTAFragment.N;
        final Context r9 = r7.getContext();
        if (r9 == null) goto L15;
        com.obric.oui.dialog.v2.alert.c r0 = r7.J;
        if (r0 == null) goto L10;
        DoraObricGOTAFragment.W90(r0);
    L10:
        com.obric.oui.dialog.v2.alert.g r1 = new com.obric.oui.dialog.v2.alert.g(r9);
        ((com.obric.oui.dialog.base.i) r1).c = true;
        r1.w = false;
        String r2 = r7.getString(2131903825);
        r1.j = false;
        r1.h = r2;
        r1.i = r7.getString(2131903824);
        com.obric.oui.dialog.v2.alert.g.c(r1);
        r1.e(r7.getString(2131902465), new b());
        r1.h(r7.getString(2131902341), new c(r9, r7));
        com.obric.oui.dialog.v2.alert.c r10 = r1.a();
        r7.J = r10;
        DoraObricGOTAFragment.X90(r10);
    L15:
        return Unit.INSTANCE;
    L12:
        if (Intrinsics.areEqual(r6, com.larus.dora.impl.ota.g.w.b.a) == false) goto L17;
        WeakReference<com.obric.oui.toast.f> r11 = DoraObricToastUtils.a;
        DoraObricToastUtils.a(this.a.requireContext(), 2131904037);
        goto L15
    L17:
        throw new NoWhenBranchMatchedException();
    }
}
