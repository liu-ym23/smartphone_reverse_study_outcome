package com.larus.av_call.service;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larus.audio.call.arch.LLMCallController;
import com.larus.audio.call.mgr.f;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
@DebugMetadata(c = "com.larus.av_call.service.DefaultRealtimeCallService$start$2", f = "DefaultRealtimeCallService.kt", i = {}, l = {112}, m = "invokeSuspend", n = {}, s = {})
public final class DefaultRealtimeCallService$start$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ DefaultRealtimeCallService this$0;

    public DefaultRealtimeCallService$start$2(DefaultRealtimeCallService r1, Continuation<? super DefaultRealtimeCallService$start$2> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new DefaultRealtimeCallService$start$2(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r3) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        if (r0 != 0) goto L5;
        ResultKt.throwOnFailure(r3);
        DefaultRealtimeCallService r4 = this.this$0;
        int r1 = DefaultRealtimeCallService.s;
        r4.getClass();
        LLMCallController.w(null, Reflection.getOrCreateKotlinClass(f.class));
        throw null;
    L5:
        if (r0 != 1) goto L7;
        ResultKt.throwOnFailure(r3);
        throw new KotlinNothingValueException();
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
