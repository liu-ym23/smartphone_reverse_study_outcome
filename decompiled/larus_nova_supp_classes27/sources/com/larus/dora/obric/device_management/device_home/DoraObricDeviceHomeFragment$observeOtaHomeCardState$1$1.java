package com.larus.dora.obric.device_management.device_home;

import com.bytedance.dora.device.DoraDevice;
import com.larus.dora.impl.ota.g2.b5;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n"}, d2 = {"<anonymous>", "Lcom/larus/dora/impl/ota/g2/G2OtaHomeCardState;", "homeState", "Lcom/larus/dora/obric/device_management/device_home/DoraObricDeviceHomeViewModel$UiState;", "otaState", "Lcom/larus/dora/impl/ota/g2/OtaEngineState;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeFragment$observeOtaHomeCardState$1$1", f = "DoraObricDeviceHomeFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class DoraObricDeviceHomeFragment$observeOtaHomeCardState$1$1 extends SuspendLambda implements Function3<DoraObricDeviceHomeViewModel.c, b5, Continuation<? super com.larus.dora.impl.ota.g2.h0>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    public DoraObricDeviceHomeFragment$observeOtaHomeCardState$1$1(Continuation<? super DoraObricDeviceHomeFragment$observeOtaHomeCardState$1$1> r2) {
        super(3, r2);
    }

    public final Object invoke(DoraObricDeviceHomeViewModel.c r2, b5 r3, Continuation<? super com.larus.dora.impl.ota.g2.h0> r4) {
        DoraObricDeviceHomeFragment$observeOtaHomeCardState$1$1 r0 = new DoraObricDeviceHomeFragment$observeOtaHomeCardState$1$1(r4);
        r0.L$0 = r2;
        r0.L$1 = r3;
        return r0.invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2, Object r3) {
        return invoke((DoraObricDeviceHomeViewModel.c) r1, (b5) r2, (Continuation) r3);
    }

    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L14;
        ResultKt.throwOnFailure(r4);
        DoraObricDeviceHomeViewModel.c r5 = (DoraObricDeviceHomeViewModel.c) this.L$0;
        b5 r0 = (b5) this.L$1;
        DoraDevice r6 = r5.b;
        if (r6 != null) goto L8;
        return null;
    L8:
        String r2 = r6.sn;
        if (r2 != null) goto L12;
        r2 = "";
    L12:
        return com.larus.dora.impl.ota.g2.g0.a(r0, new com.larus.dora.impl.ota.g2.e(r2, r6.productId));
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
