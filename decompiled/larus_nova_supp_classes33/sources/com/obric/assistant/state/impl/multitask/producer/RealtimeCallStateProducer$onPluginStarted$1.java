package com.obric.assistant.state.impl.multitask.producer;

import com.obric.cae.libs.useraware.ApWakeEvent;
import java.util.LinkedHashMap;
import java.util.Map;
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
@DebugMetadata(c = "com.obric.assistant.state.impl.multitask.producer.RealtimeCallStateProducer$onPluginStarted$1", f = "RealtimeCallStateProducer.kt", i = {}, l = {ApWakeEvent.ACCELERATING_START}, m = "invokeSuspend", n = {}, s = {})
public final class RealtimeCallStateProducer$onPluginStarted$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $callId;
    final /* synthetic */ String $conversationId;
    int label;
    final /* synthetic */ RealtimeCallStateProducer this$0;

    public RealtimeCallStateProducer$onPluginStarted$1(RealtimeCallStateProducer r1, String r2, String r3, Continuation<? super RealtimeCallStateProducer$onPluginStarted$1> r4) {
        this.this$0 = r1;
        this.$callId = r2;
        this.$conversationId = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new RealtimeCallStateProducer$onPluginStarted$1(this.this$0, this.$callId, this.$conversationId, r5);
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
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r5);
    L20:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        if (this.this$0.g.contains(this.$callId) == true) goto L11;
        Map<String, RealtimeCallStateProducer.a> r6 = this.this$0.b;
        LinkedHashMap r7 = (LinkedHashMap) r6;
        RealtimeCallStateProducer.a r8 = (RealtimeCallStateProducer.a) r7.get(this.$conversationId);
        if (r8 != null) goto L16;
        this.this$0.d.put(this.$conversationId, this.$callId);
        return Unit.INSTANCE;
    L16:
        RealtimeCallStateProducer r2 = this.this$0;
        String r3 = this.$callId;
        this.label = 1;
        if (r2.j(r8, r3, this) != r0) goto L20;
        return r0;
    L11:
        return Unit.INSTANCE;
    }
}
