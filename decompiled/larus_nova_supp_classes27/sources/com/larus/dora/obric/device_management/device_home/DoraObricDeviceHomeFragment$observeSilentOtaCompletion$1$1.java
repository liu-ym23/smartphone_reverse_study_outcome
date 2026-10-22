package com.larus.dora.obric.device_management.device_home;

import com.bytedance.dora.device.DoraDevice;
import com.larus.dora.impl.ota.g2.b5;
import com.larus.dora.impl.ota.g2.k5;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\n"}, d2 = {"<anonymous>", "Lkotlin/Pair;", "Lcom/bytedance/dora/device/DoraDevice;", "Lcom/larus/dora/impl/ota/g2/SilentOtaCompletionNotice;", "homeState", "Lcom/larus/dora/obric/device_management/device_home/DoraObricDeviceHomeViewModel$UiState;", "otaState", "Lcom/larus/dora/impl/ota/g2/OtaEngineState;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeFragment$observeSilentOtaCompletion$1$1", f = "DoraObricDeviceHomeFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class DoraObricDeviceHomeFragment$observeSilentOtaCompletion$1$1 extends SuspendLambda implements Function3<DoraObricDeviceHomeViewModel.c, b5, Continuation<? super Pair<? extends DoraDevice, ? extends k5>>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    public DoraObricDeviceHomeFragment$observeSilentOtaCompletion$1$1(Continuation<? super DoraObricDeviceHomeFragment$observeSilentOtaCompletion$1$1> r2) {
        super(3, r2);
    }

    public final Object invoke(DoraObricDeviceHomeViewModel.c r2, b5 r3, Continuation<? super Pair<? extends DoraDevice, k5>> r4) {
        DoraObricDeviceHomeFragment$observeSilentOtaCompletion$1$1 r0 = new DoraObricDeviceHomeFragment$observeSilentOtaCompletion$1$1(r4);
        r0.L$0 = r2;
        r0.L$1 = r3;
        return r0.invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2, Object r3) {
        return invoke((DoraObricDeviceHomeViewModel.c) r1, (b5) r2, (Continuation) r3);
    }

    public final Object invokeSuspend(Object r6) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L30;
        ResultKt.throwOnFailure(r6);
        DoraObricDeviceHomeViewModel.c r7 = (DoraObricDeviceHomeViewModel.c) this.L$0;
        b5 r0 = (b5) this.L$1;
        DoraDevice r8 = r7.b;
        if (r8 != null) goto L7;
        return null;
    L7:
        String r3 = r8.sn;
        if (r3 != null) goto L10;
        r3 = "";
    L10:
        com.larus.dora.impl.ota.g2.e r2 = new com.larus.dora.impl.ota.g2.e(r3, r8.productId);
        Intrinsics.checkNotNullParameter(r0, "state");
        Intrinsics.checkNotNullParameter(r2, "key");
        if (com.larus.dora.impl.ota.g2.j0.b(r2) == true) goto L13;
    L24:
        k5 r1 = null;
    L25:
        if (r1 != null) goto L28;
        return null;
    L28:
        return TuplesKt.to(r8, r1);
    L13:
        if (o59.a.m(Integer.valueOf(r2.a())) == false) goto L24;
        com.larus.dora.impl.ota.g2.f r4 = (com.larus.dora.impl.ota.g2.f) r0.c().get(r2);
        if (r4 == null) goto L24;
        if (r4.b().a() == true) goto L21;
        r4 = null;
    L21:
        if (r4 == null) goto L24;
        r1 = r4.n();
        goto L25
    L30:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
