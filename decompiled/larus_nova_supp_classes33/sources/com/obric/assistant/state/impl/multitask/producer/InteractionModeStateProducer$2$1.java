package com.obric.assistant.state.impl.multitask.producer;

import com.obric.assistant.state.api.multitask.state.ModeEndReason;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.state.impl.multitask.producer.InteractionModeStateProducer$2$1", f = "InteractionModeStateProducer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class InteractionModeStateProducer$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $sessionId;
    int label;
    final /* synthetic */ InteractionModeStateProducer this$0;

    public InteractionModeStateProducer$2$1(InteractionModeStateProducer r1, String r2, Continuation<? super InteractionModeStateProducer$2$1> r3) {
        this.this$0 = r1;
        this.$sessionId = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new InteractionModeStateProducer$2$1(this.this$0, this.$sessionId, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r5);
        InteractionModeStateProducer r6 = this.this$0;
        String r0 = this.$sessionId;
        ModeEndReason r1 = ModeEndReason.NORMAL;
        Map r2 = MapsKt.mapOf(TuplesKt.to("completion_source", "final_reply"));
        int r3 = InteractionModeStateProducer.g;
        r6.f(r0, r1, r2);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
