package com.obric.assistant.state.impl.multitask.producer;

import aha.u;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.state.api.multitask.IObricInteractionModeService$a;
import com.obric.assistant.state.api.multitask.ObricInteractionModeServiceDelegate;
import com.obric.assistant.state.api.multitask.state.ObricInteractionType;
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
@DebugMetadata(c = "com.obric.assistant.state.impl.multitask.producer.RealtimeCallStateProducer$onCallEntered$1", f = "RealtimeCallStateProducer.kt", i = {}, l = {94}, m = "invokeSuspend", n = {}, s = {})
public final class RealtimeCallStateProducer$onCallEntered$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $botId;
    final /* synthetic */ String $conversationId;
    int label;
    final /* synthetic */ RealtimeCallStateProducer this$0;

    public RealtimeCallStateProducer$onCallEntered$1(RealtimeCallStateProducer r1, String r2, String r3, Continuation<? super RealtimeCallStateProducer$onCallEntered$1> r4) {
        this.this$0 = r1;
        this.$conversationId = r2;
        this.$botId = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new RealtimeCallStateProducer$onCallEntered$1(this.this$0, this.$conversationId, this.$botId, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r10);
    L18:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        if (this.this$0.b.containsKey(this.$conversationId) == false) goto L12;
        FLogger.a.i("RealtimeCallStateProducer", "ignore duplicate call enter, conversationId=" + this.$conversationId);
        return Unit.INSTANCE;
    L12:
        ObricInteractionModeServiceDelegate r3 = ObricInteractionModeServiceDelegate.b;
        String r4 = this.$botId;
        String r5 = this.$conversationId;
        ObricInteractionType r11 = ObricInteractionType.RealtimeCallMode;
        String r2 = IObricInteractionModeService$a.b(r3, r4, r5, r11, null, 24);
        String r6 = this.$botId;
        String r7 = this.$conversationId;
        RealtimeCallStateProducer.a r8 = new RealtimeCallStateProducer.a(r6, r7, r2, new u(r6, r7, r11, r2));
        this.this$0.b.put(this.$conversationId, r8);
        String r12 = this.this$0.d.remove(this.$conversationId);
        if (r12 == null) goto L18;
        RealtimeCallStateProducer r9 = this.this$0;
        this.label = 1;
        if (r9.j(r8, r12, this) != r0) goto L18;
        return r0;
    }
}
