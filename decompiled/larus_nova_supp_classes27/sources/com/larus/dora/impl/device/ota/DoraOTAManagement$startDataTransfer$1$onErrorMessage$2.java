package com.larus.dora.impl.device.ota;

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
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.device.ota.DoraOTAManagement$startDataTransfer$1$onErrorMessage$2", f = "DoraOTAManagement.kt", i = {}, l = {1343}, m = "invokeSuspend", n = {}, s = {})
public final class DoraOTAManagement$startDataTransfer$1$onErrorMessage$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ DoraDevice $device;
    final /* synthetic */ String $errorMsg;
    final /* synthetic */ String $newErrorMessage;
    final /* synthetic */ z39.a $response;
    int label;

    public DoraOTAManagement$startDataTransfer$1$onErrorMessage$2(z39.a r1, String r2, String r3, DoraDevice r4, Continuation<? super DoraOTAManagement$startDataTransfer$1$onErrorMessage$2> r5) {
        this.$response = r1;
        this.$errorMsg = r2;
        this.$newErrorMessage = r3;
        this.$device = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new DoraOTAManagement$startDataTransfer$1$onErrorMessage$2(this.$response, this.$errorMsg, this.$newErrorMessage, this.$device, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r12) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r12);
    L11:
        DoraOTAManagement r13 = DoraOTAManagement.a;
        DoraDevice r14 = this.$device;
        DoraOTAManagement.f(r14, DoraOTAManagement.q(r14), this.$response);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r12);
        DoraOTAManagement.A(DoraOTAManagement.a, DoraOTAManagement.c, this.$response, this.$errorMsg, this.$newErrorMessage, this.$device, true, 32);
        this.label = 1;
        if (DelayKt.delay(1000, this) != r0) goto L11;
        return r0;
    }
}
