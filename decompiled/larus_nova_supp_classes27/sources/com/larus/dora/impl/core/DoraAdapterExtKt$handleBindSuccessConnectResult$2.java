package com.larus.dora.impl.core;

import com.bytedance.dora.device.DoraDevice;
import kotlin.Metadata;
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
@DebugMetadata(c = "com.larus.dora.impl.core.DoraAdapterExtKt$handleBindSuccessConnectResult$2", f = "DoraAdapterExt.kt", i = {}, l = {174}, m = "invokeSuspend", n = {}, s = {})
public final class DoraAdapterExtKt$handleBindSuccessConnectResult$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ DoraDevice $device;
    final /* synthetic */ kj4.a $this_handleBindSuccessConnectResult;
    final /* synthetic */ String $userId;
    int label;

    public DoraAdapterExtKt$handleBindSuccessConnectResult$2(kj4.a r1, DoraDevice r2, String r3, Continuation<? super DoraAdapterExtKt$handleBindSuccessConnectResult$2> r4) {
        this.$this_handleBindSuccessConnectResult = r1;
        this.$device = r2;
        this.$userId = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new DoraAdapterExtKt$handleBindSuccessConnectResult$2(this.$this_handleBindSuccessConnectResult, this.$device, this.$userId, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r4);
    L11:
        boolean r5 = ((Boolean) r4).booleanValue();
        g49.d.d("DoraAdapterExt", "bindAndConnect: " + o59.a.h(this.$device) + "，bindBudsResult=" + r5);
        if (r5 == false) goto L15;
        com.larus.dora.impl.util.b0 r6 = com.larus.dora.impl.util.b0.a;
        String r2 = this.$userId;
        String r3 = this.$device.mac;
        r6.getClass();
        com.larus.dora.impl.util.b0.B(r2, r3);
    L15:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r4);
        kj4.a r7 = this.$this_handleBindSuccessConnectResult;
        this.label = 1;
        r4 = DoraAdapterExtKt.c(r7, true, this);
        if (r4 != r0) goto L11;
        return r0;
    }
}
