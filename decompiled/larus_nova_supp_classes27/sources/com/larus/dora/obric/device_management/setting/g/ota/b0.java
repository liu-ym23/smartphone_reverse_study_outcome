package com.larus.dora.obric.device_management.setting.g.ota;

import com.larus.dora.obric.utils.DoraObricToastUtils;
import java.lang.ref.WeakReference;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class b0<T> implements FlowCollector {
    public final /* synthetic */ DoraObricGOTAFragment a;

    public b0(DoraObricGOTAFragment r1) {
        this.a = r1;
    }

    public final Object emit(Object r2, Continuation r3) {
        com.larus.dora.impl.ota.connector.a r4 = (com.larus.dora.impl.ota.connector.a) r2;
        if (Intrinsics.areEqual(r4, com.larus.dora.impl.ota.connector.a.C0091a.a) == false) goto L6;
        DoraObricGOTAFragment.Z90(this.a, 2131902862);
    L23:
        return Unit.INSTANCE;
    L6:
        if (Intrinsics.areEqual(r4, com.larus.dora.impl.ota.connector.a.b.a) == false) goto L9;
        DoraObricGOTAFragment.Z90(this.a, 2131902863);
        goto L23
    L9:
        if ((r4 instanceof com.larus.dora.impl.ota.connector.a.e) == false) goto L12;
        WeakReference<com.obric.oui.toast.f> r5 = DoraObricToastUtils.a;
        DoraObricToastUtils.a(this.a.requireContext(), 2131902876);
        goto L23
    L12:
        if (Intrinsics.areEqual(r4, com.larus.dora.impl.ota.connector.a.f.a) == false) goto L15;
        DoraObricGOTAFragment.Z90(this.a, 2131902865);
        goto L23
    L15:
        if (Intrinsics.areEqual(r4, com.larus.dora.impl.ota.connector.a.d.a) == false) goto L17;
    L21:
        WeakReference<com.obric.oui.toast.f> r6 = DoraObricToastUtils.a;
        DoraObricToastUtils.a(this.a.requireContext(), 2131902876);
        goto L23
    L17:
        if (Intrinsics.areEqual(r4, com.larus.dora.impl.ota.connector.a.c.a) == true) goto L21;
        throw new NoWhenBranchMatchedException();
    }
}
