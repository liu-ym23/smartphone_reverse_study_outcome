package com.obric.assistant.state.impl.multitask.producer;

import java.util.ArrayDeque;
import java.util.LinkedHashMap;
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
@DebugMetadata(c = "com.obric.assistant.state.impl.multitask.producer.RealtimeCallStateProducer$onMajorStateChanged$1", f = "RealtimeCallStateProducer.kt", i = {}, l = {147}, m = "invokeSuspend", n = {}, s = {})
public final class RealtimeCallStateProducer$onMajorStateChanged$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $callId;
    final /* synthetic */ String $conversationId;
    final /* synthetic */ int $currentState;
    final /* synthetic */ int $prevState;
    int label;
    final /* synthetic */ RealtimeCallStateProducer this$0;

    public RealtimeCallStateProducer$onMajorStateChanged$1(RealtimeCallStateProducer r1, String r2, String r3, int r4, int r5, Continuation<? super RealtimeCallStateProducer$onMajorStateChanged$1> r6) {
        this.this$0 = r1;
        this.$callId = r2;
        this.$conversationId = r3;
        this.$prevState = r4;
        this.$currentState = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new RealtimeCallStateProducer$onMajorStateChanged$1(this.this$0, this.$callId, this.$conversationId, this.$prevState, this.$currentState, r9);
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
    L15:
        RealtimeCallStateProducer.a r6 = (RealtimeCallStateProducer.a) r5;
        if (r6 != null) goto L25;
        RealtimeCallStateProducer r7 = this.this$0;
        String r2 = this.$callId;
        int r3 = this.$prevState;
        int r4 = this.$currentState;
        LinkedHashMap r8 = (LinkedHashMap) r7.e;
        Object r9 = r8.get(r2);
        if (r9 != null) goto L20;
        r9 = new ArrayDeque();
        r8.put(r2, r9);
    L20:
        ArrayDeque r10 = (ArrayDeque) r9;
        if (r10.size() != 16) goto L23;
        r10.removeFirst();
    L23:
        r10.addLast(new RealtimeCallStateProducer.c(r3, r4));
        return Unit.INSTANCE;
    L25:
        RealtimeCallStateProducer r11 = this.this$0;
        int r12 = this.$prevState;
        int r13 = this.$currentState;
        int r14 = RealtimeCallStateProducer.j;
        r11.i(r6, r12, r13);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        if (this.this$0.g.contains(this.$callId) == true) goto L11;
        RealtimeCallStateProducer r15 = this.this$0;
        String r16 = this.$callId;
        String r17 = this.$conversationId;
        this.label = 1;
        r5 = RealtimeCallStateProducer.h(r15, r16, r17, this);
        if (r5 != r0) goto L15;
        return r0;
    L11:
        return Unit.INSTANCE;
    }
}
