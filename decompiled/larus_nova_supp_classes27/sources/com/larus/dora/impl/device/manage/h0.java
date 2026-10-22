package com.larus.dora.impl.device.manage;

import androidx.lifecycle.LifecycleOwnerKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class h0<T> implements FlowCollector {
    public final /* synthetic */ DoraGDeviceManagementFragment a;

    public h0(DoraGDeviceManagementFragment r1) {
        this.a = r1;
    }

    public final Object emit(Object r7, Continuation r8) {
        g49.d.d("DoraGDeviceManagementFragment", "sodaBannerSharedFlow: status=" + ((com.larus.dora.impl.network.a) r7).a());
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this.a), null, null, new DoraGDeviceManagementFragment$setupCollect$3$1$1(this.a, null), 3, null);
        return Unit.INSTANCE;
    }
}
