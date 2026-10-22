package com.obric.assistant.wakeup.co_wakeup.dora.service;

import com.obric.assistant.wakeup.co_wakeup.dora.model.DoraSwitchState;
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
@DebugMetadata(c = "com.obric.assistant.wakeup.co_wakeup.dora.service.CoWakeupService$onVoiceWakeupStateChanged$1", f = "CoWakeupService.kt", i = {}, l = {435}, m = "invokeSuspend", n = {}, s = {})
public final class CoWakeupService$onVoiceWakeupStateChanged$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $enabled;
    int label;
    final /* synthetic */ CoWakeupService this$0;

    public CoWakeupService$onVoiceWakeupStateChanged$1(CoWakeupService r1, boolean r2, Continuation<? super CoWakeupService$onVoiceWakeupStateChanged$1> r3) {
        this.this$0 = r1;
        this.$enabled = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new CoWakeupService$onVoiceWakeupStateChanged$1(this.this$0, this.$enabled, r4);
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
    L16:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r4);
        StateFlowImpl r5 = this.this$0.c;
        if (this.$enabled == false) goto L11;
        DoraSwitchState r2 = DoraSwitchState.ON;
    L12:
        this.label = 1;
        r5.setValue(r2);
        if (Unit.INSTANCE != r0) goto L16;
        return r0;
    L11:
        r2 = DoraSwitchState.OFF;
        goto L12
    }
}
