package com.obric.assistant.state.impl.multitask.producer;

import com.larus.im.bean.message.Message;
import com.larus.utils.logger.FLogger;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.state.impl.multitask.producer.MessageStateProducer$streamObserver$1$onStreamEnd$1", f = "MessageStateProducer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class MessageStateProducer$streamObserver$1$onStreamEnd$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Message $message;
    int label;
    final /* synthetic */ MessageStateProducer this$0;

    public MessageStateProducer$streamObserver$1$onStreamEnd$1(Message r1, MessageStateProducer r2, Continuation<? super MessageStateProducer$streamObserver$1$onStreamEnd$1> r3) {
        this.$message = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new MessageStateProducer$streamObserver$1$onStreamEnd$1(this.$message, this.this$0, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L24;
        ResultKt.throwOnFailure(r5);
        String r6 = this.$message.getConversationId();
        if (r6 == null) goto L7;
        String r0 = this.$message.getReplyId();
        if (r0 != null) goto L11;
    L13:
        r0 = null;
    L14:
        MessageStateProducer r1 = this.this$0;
        Set r2 = MessageStateProducer.w;
        String r3 = r1.s(r6, r0);
        if (r3 == null) goto L17;
        this.this$0.getClass();
        if (this.this$0.c.containsKey(new h(r6, r3)) == false) goto L22;
        FLogger.a.i("MessageStateProducer", "onStreamEnd: reset timeout for task " + r3 + ", waiting for final state");
        this.this$0.t(r6, r3, this.$message);
    L22:
        return Unit.INSTANCE;
    L17:
        return Unit.INSTANCE;
    L11:
        if ((!Intrinsics.areEqual(r0, "0")) == false) goto L13;
    L7:
        return Unit.INSTANCE;
    L24:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
