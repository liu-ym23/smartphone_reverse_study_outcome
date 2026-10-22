package com.obric.assistant.state.impl.multitask.producer;

import com.larus.im.bean.message.Message;
import com.larus.utils.logger.FLogger;
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
@DebugMetadata(c = "com.obric.assistant.state.impl.multitask.producer.MessageStateProducer$messageObserver$1$onSendMessage$1", f = "MessageStateProducer.kt", i = {}, l = {293}, m = "invokeSuspend", n = {}, s = {})
public final class MessageStateProducer$messageObserver$1$onSendMessage$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $cid;
    final /* synthetic */ Message $msg;
    int label;
    final /* synthetic */ MessageStateProducer this$0;

    public MessageStateProducer$messageObserver$1$onSendMessage$1(String r1, Message r2, MessageStateProducer r3, Continuation<? super MessageStateProducer$messageObserver$1$onSendMessage$1> r4) {
        this.$cid = r1;
        this.$msg = r2;
        this.this$0 = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new MessageStateProducer$messageObserver$1$onSendMessage$1(this.$cid, this.$msg, this.this$0, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r11) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r11);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r11);
        FLogger.a.i("MessageStateProducer", "onSendMessage, cid=" + this.$cid + ",messageId=" + this.$msg.getMessageId() + ",replyId=" + this.$msg.getReplyId() + ",localMessageId=" + this.$msg.getLocalMessageId() + ",status=" + this.$msg.getMessageStatusLocal());
        MessageStateProducer r4 = this.this$0;
        String r5 = this.$cid;
        Message r6 = this.$msg;
        this.label = 1;
        if (MessageStateProducer.b(r4, r5, r6, true, true, this) != r0) goto L12;
        return r0;
    }
}
