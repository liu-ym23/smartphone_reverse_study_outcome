package com.obric.assistant.interaction.impl.service;

import com.larus.utils.logger.FLogger;
import com.obric.assistant.audio.service.ObricRealtimeCallStateServiceDelegate;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.interaction.impl.service.InteractionStateServiceImpl$muteMic$1", f = "InteractionStateServiceImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class InteractionStateServiceImpl$muteMic$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;

    public InteractionStateServiceImpl$muteMic$1(Continuation<? super InteractionStateServiceImpl$muteMic$1> r2) {
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
        return new InteractionStateServiceImpl$muteMic$1(r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r3) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L10;
        ResultKt.throwOnFailure(r3);
        ObricRealtimeCallStateServiceDelegate r4 = InteractionStateServiceImpl.access$getObricRealtimeCallStateService$p();
        if (r4 == null) goto L7;
        r4.mute();
    L7:
        FLogger.a.d("InteractionStateServiceImpl", "muteMic() called, obricRealtimeCallStateService:" + InteractionStateServiceImpl.access$getObricRealtimeCallStateService$p());
        return Unit.INSTANCE;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
