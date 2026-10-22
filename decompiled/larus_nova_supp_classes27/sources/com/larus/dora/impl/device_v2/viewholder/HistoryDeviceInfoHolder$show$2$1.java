package com.larus.dora.impl.device_v2.viewholder;

import com.bytedance.dora.device.DoraDevice;
import com.larus.dora.impl.core.DoraAdapterExtKt;
import com.larus.dora.impl.network.DoraNetworkApi;
import g49.d;
import kj4.a;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.device_v2.viewholder.HistoryDeviceInfoHolder$show$2$1", f = "HistoryDeviceInfoHolder.kt", i = {}, l = {51}, m = "invokeSuspend", n = {}, s = {})
final class HistoryDeviceInfoHolder$show$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $bannerType;
    int label;

    public HistoryDeviceInfoHolder$show$2$1(int r1, Continuation<? super HistoryDeviceInfoHolder$show$2$1> r2) {
        this.$bannerType = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new HistoryDeviceInfoHolder$show$2$1(this.$bannerType, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r5);
        Object r6 = ((Result) r5).unbox-impl();
    L22:
        Result.box-impl(r6);
    L25:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        DoraDevice r7 = DoraAdapterExtKt.h(a.g());
        if (r7 == null) goto L12;
        String r8 = r7.getSerialNumber();
        if (r8 == null) goto L12;
    L14:
        if (r8.length() != 0) goto L16;
        boolean r2 = true;
    L18:
        if (r2 == true) goto L23;
        d.d("doraSodaBanner", "close the doraSodaBanner");
        DoraNetworkApi r3 = DoraNetworkApi.a;
        int r4 = this.$bannerType;
        this.label = 1;
        r6 = r3.z(r4, r8, this);
        if (r6 != r0) goto L22;
        return r0;
    L23:
        d.d("doraSodaBanner", "the sn is empty");
        goto L25
    L16:
        r2 = false;
    L12:
        r8 = "";
        goto L14
    }
}
