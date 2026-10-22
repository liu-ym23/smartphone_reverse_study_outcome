package com.larus.dora.impl.device.manage;

import com.larus.dora.impl.device.manage.viewmodel.DoraGDeviceManagementViewModel;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class j0<T> implements FlowCollector {
    public final /* synthetic */ DoraGDeviceManagementFragment a;

    public j0(DoraGDeviceManagementFragment r1) {
        this.a = r1;
    }

    public final Object emit(Object r4, Continuation r5) {
        Unit r6 = (Unit) r4;
        g49.d.d("DoraGDeviceManagementFragment", "setupDoraRedDotObserver ota version changed");
        DoraGDeviceManagementFragment r7 = this.a;
        int r0 = DoraGDeviceManagementFragment.q;
        r7.ea0(((DoraGDeviceManagementViewModel.c) r7.Y90().getUiState().getValue()).k);
        Object r8 = DoraGDeviceManagementViewModel.updateOnlyFirmwareUpdateCard$default(this.a.Y90(), false, r5, 1, null);
        if (r8 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r8;
    L6:
        return Unit.INSTANCE;
    }
}
