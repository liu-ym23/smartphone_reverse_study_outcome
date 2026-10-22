package com.obric.assistant.state.impl.multitask.producer;

import aha.y;
import com.obric.assistant.state.multitask.ext.TaskFlowDslKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.state.impl.multitask.producer.RealtimeCallStateProducer$onMuteStateChanged$1", f = "RealtimeCallStateProducer.kt", i = {}, l = {168}, m = "invokeSuspend", n = {}, s = {})
public final class RealtimeCallStateProducer$onMuteStateChanged$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $callId;
    final /* synthetic */ String $conversationId;
    final /* synthetic */ int $state;
    int label;
    final /* synthetic */ RealtimeCallStateProducer this$0;

    public RealtimeCallStateProducer$onMuteStateChanged$1(RealtimeCallStateProducer r1, String r2, String r3, int r4, Continuation<? super RealtimeCallStateProducer$onMuteStateChanged$1> r5) {
        this.this$0 = r1;
        this.$callId = r2;
        this.$conversationId = r3;
        this.$state = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new RealtimeCallStateProducer$onMuteStateChanged$1(this.this$0, this.$callId, this.$conversationId, this.$state, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r6);
    L15:
        RealtimeCallStateProducer.a r7 = (RealtimeCallStateProducer.a) r6;
        if (r7 != null) goto L19;
        this.this$0.f.put(this.$callId, Boxing.boxInt(this.$state));
        return Unit.INSTANCE;
    L19:
        jha.l<y> r2 = r7.g;
        if (r2 == null) goto L23;
        TaskFlowDslKt.f(r2, new y.a(this.$callId, this.$conversationId, this.$state, r7.d));
    L23:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        if (this.this$0.g.contains(this.$callId) == true) goto L11;
        RealtimeCallStateProducer r8 = this.this$0;
        String r3 = this.$callId;
        String r4 = this.$conversationId;
        this.label = 1;
        r6 = RealtimeCallStateProducer.h(r8, r3, r4, this);
        if (r6 != r0) goto L15;
        return r0;
    L11:
        return Unit.INSTANCE;
    }
}
