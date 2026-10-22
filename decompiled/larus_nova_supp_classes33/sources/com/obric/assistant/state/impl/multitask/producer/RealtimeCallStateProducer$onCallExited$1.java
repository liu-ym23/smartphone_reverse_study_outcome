package com.obric.assistant.state.impl.multitask.producer;

import com.obric.assistant.state.api.multitask.ObricInteractionModeServiceDelegate;
import com.obric.assistant.state.api.multitask.state.ModeEndReason;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.state.impl.multitask.producer.RealtimeCallStateProducer$onCallExited$1", f = "RealtimeCallStateProducer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class RealtimeCallStateProducer$onCallExited$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $conversationId;
    int label;
    final /* synthetic */ RealtimeCallStateProducer this$0;

    public RealtimeCallStateProducer$onCallExited$1(RealtimeCallStateProducer r1, String r2, Continuation<? super RealtimeCallStateProducer$onCallExited$1> r3) {
        this.this$0 = r1;
        this.$conversationId = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new RealtimeCallStateProducer$onCallExited$1(this.this$0, this.$conversationId, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L19;
        ResultKt.throwOnFailure(r5);
        RealtimeCallStateProducer.a r6 = this.this$0.b.remove(this.$conversationId);
        if (r6 == null) goto L7;
        this.this$0.getClass();
        RealtimeCallStateProducer.k(r6);
        String r0 = r6.e;
        if (r0 == null) goto L16;
        RealtimeCallStateProducer r1 = this.this$0;
        r1.c.remove(r0);
        r1.e.remove(r0);
        r1.f.remove(r0);
        if (r1.g.add(r0) == false) goto L16;
        r1.h.addLast(r0);
        if (r1.h.size() <= 32) goto L16;
        r1.g.remove(r1.h.removeFirst());
    L16:
        this.this$0.d.remove(this.$conversationId);
        ObricInteractionModeServiceDelegate.b.b(r6.c, ModeEndReason.NORMAL, MapsKt.mapOf(TuplesKt.to("call_exit", Boxing.boxBoolean(true))));
        return Unit.INSTANCE;
    L7:
        return Unit.INSTANCE;
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
