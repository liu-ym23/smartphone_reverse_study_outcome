package com.obric.audio.enroll.ui.fragment;

import com.larus.utils.logger.FLogger;
import com.obric.audio.enroll.vm.EnrollViewModel;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class z implements Function1 {
    public final /* synthetic */ EnrollingFragment a;

    public /* synthetic */ z(EnrollingFragment r1) {
        this.a = r1;
    }

    public final Object invoke(Object r6) {
        EnrollingFragment r0 = this.a;
        int r7 = ((Integer) r6).intValue();
        EnrollingFragment.b r1 = EnrollingFragment.b.a;
        if (r7 != 2) goto L5;
        boolean r2 = true;
    L6:
        FLogger r3 = FLogger.a;
        r3.i("EnrollingFragment", "doraLinkState state=" + r7 + " connected=" + r2);
        if (r2 == true) goto L13;
        r3.i("EnrollingFragment", "doraLinkState not connected, report BluetoothScoConnectFailed");
        EnrollViewModel r8 = r0.f;
        if (r8 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r8 = null;
    L11:
        r8.reportEvent(qia.c.a);
    L13:
        return Unit.INSTANCE;
    L5:
        r2 = false;
        goto L6
    }
}
