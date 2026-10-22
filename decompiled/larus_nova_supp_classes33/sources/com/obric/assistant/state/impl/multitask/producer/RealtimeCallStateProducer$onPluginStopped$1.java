package com.obric.assistant.state.impl.multitask.producer;

import aha.a0;
import aha.y;
import com.obric.assistant.state.multitask.ext.TaskFlowDslKt;
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
@DebugMetadata(c = "com.obric.assistant.state.impl.multitask.producer.RealtimeCallStateProducer$onPluginStopped$1", f = "RealtimeCallStateProducer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class RealtimeCallStateProducer$onPluginStopped$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $callId;
    final /* synthetic */ String $conversationId;
    int label;
    final /* synthetic */ RealtimeCallStateProducer this$0;

    public RealtimeCallStateProducer$onPluginStopped$1(RealtimeCallStateProducer r1, String r2, String r3, Continuation<? super RealtimeCallStateProducer$onPluginStopped$1> r4) {
        this.this$0 = r1;
        this.$conversationId = r2;
        this.$callId = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new RealtimeCallStateProducer$onPluginStopped$1(this.this$0, this.$conversationId, this.$callId, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L15;
        ResultKt.throwOnFailure(r10);
        this.this$0.d.remove(this.$conversationId, this.$callId);
        RealtimeCallStateProducer.a r11 = this.this$0.l(this.$callId, this.$conversationId);
        if (r11 == null) goto L12;
        jha.l<a0> r0 = r11.f;
        if (r0 == null) goto L9;
        TaskFlowDslKt.f(r0, new a0.a(this.$callId, this.$conversationId, -1, null, r11.d, 24));
    L9:
        jha.l<y> r1 = r11.g;
        if (r1 == null) goto L12;
        TaskFlowDslKt.f(r1, new y.a(this.$callId, this.$conversationId, -1, r11.d));
    L12:
        this.this$0.e.remove(this.$callId);
        this.this$0.f.remove(this.$callId);
        return Unit.INSTANCE;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
