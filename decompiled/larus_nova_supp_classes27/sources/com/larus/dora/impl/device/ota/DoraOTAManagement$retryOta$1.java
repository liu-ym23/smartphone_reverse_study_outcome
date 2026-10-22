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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.device.ota.DoraOTAManagement$retryOta$1", f = "DoraOTAManagement.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class DoraOTAManagement$retryOta$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ DoraDevice $device;
    final /* synthetic */ String $filePath;
    final /* synthetic */ z39.a $response;
    int label;

    public DoraOTAManagement$retryOta$1(DoraDevice r1, String r2, z39.a r3, Continuation<? super DoraOTAManagement$retryOta$1> r4) {
        this.$device = r1;
        this.$filePath = r2;
        this.$response = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new DoraOTAManagement$retryOta$1(this.$device, this.$filePath, this.$response, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L11;
        ResultKt.throwOnFailure(r5);
        DoraOTAManagement r6 = DoraOTAManagement.a;
        if (DoraOTAManagement.H == false) goto L7;
        r6.G(this.$device, this.$filePath, this.$response);
    L9:
        return Unit.INSTANCE;
    L7:
        r6.l(this.$device, this.$filePath, this.$response, true);
        goto L9
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
