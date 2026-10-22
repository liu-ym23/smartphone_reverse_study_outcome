package com.obric.assistant.state.impl.multitask.producer;

import com.larus.im.bean.message.Message;
import com.larus.im.observer.MessageListState;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.state.impl.multitask.producer.MessageStateProducer$messageObserver$1$onMessageListChanged$1", f = "MessageStateProducer.kt", i = {}, l = {251}, m = "invokeSuspend", n = {}, s = {})
public final class MessageStateProducer$messageObserver$1$onMessageListChanged$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $cid;
    final /* synthetic */ List<Message> $msgList;
    final /* synthetic */ MessageListState $state;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ MessageStateProducer this$0;

    public MessageStateProducer$messageObserver$1$onMessageListChanged$1(String r1, MessageListState r2, MessageStateProducer r3, List<Message> r4, Continuation<? super MessageStateProducer$messageObserver$1$onMessageListChanged$1> r5) {
        this.$cid = r1;
        this.$state = r2;
        this.this$0 = r3;
        this.$msgList = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new MessageStateProducer$messageObserver$1$onMessageListChanged$1(this.$cid, this.$state, this.this$0, this.$msgList, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r13) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        Iterator r2 = (Iterator) this.L$2;
        String r4 = (String) this.L$1;
        MessageStateProducer r5 = (MessageStateProducer) this.L$0;
        ResultKt.throwOnFailure(r13);
        String r14 = r4;
        MessageStateProducer r10 = r5;
    L40:
        if (r2.hasNext() == false) goto L45;
        Message r6 = (Message) r2.next();
        FLogger.a.i("MessageStateProducer", "onMessageListChanged messageId=" + r6.getMessageId() + ",replyId=" + r6.getReplyId() + ",localMessageId=" + r6.getLocalMessageId() + ',' + r6.getMessageStatus());
        this.L$0 = r10;
        this.L$1 = r14;
        this.L$2 = r2;
        this.label = 1;
        if (MessageStateProducer.b(r10, r14, r6, false, false, this) != r0) goto L40;
        return r0;
    L45:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r13);
        FLogger.a.i("MessageStateProducer", "onMessageListChanged, " + this.$cid);
        if (this.$state != MessageListState.UPDATE) goto L45;
        MessageStateProducer r15 = this.this$0;
        List<Message> r3 = this.$msgList;
        Set r7 = MessageStateProducer.w;
        r15.getClass();
        List<Message> r8 = r3;
        ArrayList r9 = new ArrayList();
        Iterator<T> r11 = r8.iterator();
    L12:
        if (r11.hasNext() == false) goto L21;
        String r12 = ((Message) r11.next()).getReplyId();
        if (r12 != null) goto L16;
    L18:
        r12 = null;
    L19:
        if (r12 == null) goto L12;
        r9.add(r12);
        goto L12
    L16:
        if ((!Intrinsics.areEqual(r12, "0")) == false) goto L18;
    L21:
        Set r16 = CollectionsKt.toSet(r9);
        ArrayList r17 = new ArrayList();
        Iterator<T> r18 = r8.iterator();
    L23:
        if (r18.hasNext() == false) goto L38;
        Object r19 = r18.next();
        Message r20 = (Message) r19;
        if (com.larus.bmhome.chat.bean.d.G0(r20) == true) goto L27;
    L35:
        boolean r21 = false;
    L36:
        if (r21 == false) goto L23;
        r17.add(r19);
        goto L23
    L27:
        if (r15.b.contains(Integer.valueOf(r20.getMessageStatusLocal())) == false) goto L35;
        if (Intrinsics.areEqual(r20.getReplyId(), "0") == false) goto L35;
        Set r22 = r16;
        if (CollectionsKt.contains(r22, r20.getMessageId()) == true) goto L35;
        if (CollectionsKt.contains(r22, r20.getLocalMessageId()) == true) goto L35;
        r21 = true;
        goto L36
    L38:
        MessageStateProducer r110 = this.this$0;
        r10 = r110;
        r14 = this.$cid;
        r2 = r17.iterator();
        goto L40
    }
}
