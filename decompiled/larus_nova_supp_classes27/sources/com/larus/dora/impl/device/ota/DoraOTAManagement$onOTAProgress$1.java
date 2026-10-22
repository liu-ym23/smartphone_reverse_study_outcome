package com.larus.dora.impl.device.ota;

import d49.c$e;
import d49.c$f;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.StateFlowImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.device.ota.DoraOTAManagement$onOTAProgress$1", f = "DoraOTAManagement.kt", i = {}, l = {1590, 1593}, m = "invokeSuspend", n = {}, s = {})
final class DoraOTAManagement$onOTAProgress$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $otaTaskId;
    final /* synthetic */ int $progress;
    final /* synthetic */ z39.a $response;
    int label;

    public DoraOTAManagement$onOTAProgress$1(int r1, int r2, z39.a r3, Continuation<? super DoraOTAManagement$onOTAProgress$1> r4) {
        this.$progress = r1;
        this.$otaTaskId = r2;
        this.$response = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new DoraOTAManagement$onOTAProgress$1(this.$progress, this.$otaTaskId, this.$response, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 == 2) goto L9;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r7);
    L25:
        return Unit.INSTANCE;
    L10:
        ResultKt.throwOnFailure(r7);
        StateFlowImpl r8 = DoraOTAManagement.e;
        d49.c r2 = (d49.c) r8.getValue();
        int r4 = DoraOTAManagement.R;
        int r5 = this.$progress;
        if (r4 > r5) goto L15;
        r4 = r5;
    L15:
        if ((r2 instanceof c$e) == false) goto L21;
        int r3 = ((c$e) r2).a;
        int r6 = this.$otaTaskId;
        if (r3 == r6) goto L25;
        c$f r9 = new c$f(r6, this.$response, r4);
        this.label = 1;
        r8.setValue(r9);
        if (Unit.INSTANCE != r0) goto L25;
        return r0;
    L21:
        c$f r10 = new c$f(this.$otaTaskId, this.$response, r4);
        this.label = 2;
        r8.setValue(r10);
        if (Unit.INSTANCE != r0) goto L25;
        return r0;
    }
}
