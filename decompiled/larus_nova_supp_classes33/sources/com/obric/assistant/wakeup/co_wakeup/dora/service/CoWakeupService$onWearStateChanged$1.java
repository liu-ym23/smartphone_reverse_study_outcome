package com.obric.assistant.wakeup.co_wakeup.dora.service;

import com.obric.assistant.wakeup.co_wakeup.dora.model.DoraWearState;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.wakeup.co_wakeup.dora.service.CoWakeupService$onWearStateChanged$1", f = "CoWakeupService.kt", i = {}, l = {445, 446}, m = "invokeSuspend", n = {}, s = {})
public final class CoWakeupService$onWearStateChanged$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $leftOn;
    final /* synthetic */ boolean $rightOn;
    int label;
    final /* synthetic */ CoWakeupService this$0;

    public CoWakeupService$onWearStateChanged$1(CoWakeupService r1, boolean r2, boolean r3, Continuation<? super CoWakeupService$onWearStateChanged$1> r4) {
        this.this$0 = r1;
        this.$leftOn = r2;
        this.$rightOn = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new CoWakeupService$onWearStateChanged$1(this.this$0, this.$leftOn, this.$rightOn, r5);
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
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r5);
    L24:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r5);
    L20:
        CoWakeupService r6 = this.this$0;
        this.label = 2;
        if (CoWakeupService.i(r6, true, this) != r0) goto L24;
        return r0;
    L10:
        ResultKt.throwOnFailure(r5);
        StateFlowImpl r7 = this.this$0.d;
        if (this.$leftOn == false) goto L13;
    L16:
        DoraWearState r2 = DoraWearState.ON;
    L17:
        this.label = 1;
        r7.setValue(r2);
        if (Unit.INSTANCE != r0) goto L20;
        return r0;
    L13:
        if (this.$rightOn == true) goto L16;
        r2 = DoraWearState.OFF;
        goto L17
    }
}
