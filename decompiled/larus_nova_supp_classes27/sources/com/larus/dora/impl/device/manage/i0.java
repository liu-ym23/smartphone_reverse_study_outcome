package com.larus.dora.impl.device.manage;

import com.bytedance.dora.device.DoraDevice;
import com.larus.dora.impl.device.manage.viewmodel.DoraGDeviceManagementViewModel;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class i0<T> implements FlowCollector {
    public final /* synthetic */ DoraGDeviceManagementFragment a;

    public i0(DoraGDeviceManagementFragment r1) {
        this.a = r1;
    }

    public final Object emit(Object r6, Continuation r7) {
        Map r8 = (Map) r6;
        DoraGDeviceManagementFragment r0 = this.a;
        int r1 = DoraGDeviceManagementFragment.q;
        DoraDevice r2 = ((DoraGDeviceManagementViewModel.c) r0.Y90().getUiState().getValue()).b;
        if (r2 == null) goto L5;
        String r3 = r2.sn;
    L6:
        if (r3 != null) goto L9;
        r3 = "";
    L9:
        if (r3.length() <= 0) goto L11;
        boolean r4 = true;
    L12:
        if (r4 == false) goto L14;
        d49.a r9 = (d49.a) r8.get(r3);
    L16:
        if ((r9 instanceof d49.a.n) == false) goto L22;
        g49.d.d("DoraGDeviceManagementFragment", "setupDoraOtaFinishObserver ota success");
        Object r10 = DoraGDeviceManagementViewModel.updateOnlyFirmwareUpdateCard$default(this.a.Y90(), false, r7, 1, null);
        if (r10 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L23;
        return r10;
    L23:
        return Unit.INSTANCE;
    L22:
        return Unit.INSTANCE;
    L14:
        r9 = (d49.a) CollectionsKt.firstOrNull(r8.values());
        goto L16
    L11:
        r4 = false;
        goto L12
    L5:
        r3 = null;
        goto L6
    }
}
