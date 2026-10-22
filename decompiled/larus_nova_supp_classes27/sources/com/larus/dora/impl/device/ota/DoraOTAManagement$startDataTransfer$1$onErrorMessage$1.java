package com.larus.dora.impl.device.ota;

import com.bytedance.dora.device.DoraDevice;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.device.ota.DoraOTAManagement$startDataTransfer$1$onErrorMessage$1", f = "DoraOTAManagement.kt", i = {}, l = {1319}, m = "invokeSuspend", n = {}, s = {})
public final class DoraOTAManagement$startDataTransfer$1$onErrorMessage$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ DoraDevice $device;
    final /* synthetic */ int $packageTypeRetryCount;
    int label;

    public DoraOTAManagement$startDataTransfer$1$onErrorMessage$1(DoraDevice r1, int r2, Continuation<? super DoraOTAManagement$startDataTransfer$1$onErrorMessage$1> r3) {
        this.$device = r1;
        this.$packageTypeRetryCount = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new DoraOTAManagement$startDataTransfer$1$onErrorMessage$1(this.$device, this.$packageTypeRetryCount, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r8);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r8);
        DoraOTAManagement r2 = DoraOTAManagement.a;
        final DoraDevice r9 = this.$device;
        Function1 r4 = new f0(r9);
        final int r5 = this.$packageTypeRetryCount;
        Function1 r6 = new g0(r5);
        this.label = 1;
        if (r2.C(r9, "1", r4, r6, this) != r0) goto L12;
        return r0;
    }
}
