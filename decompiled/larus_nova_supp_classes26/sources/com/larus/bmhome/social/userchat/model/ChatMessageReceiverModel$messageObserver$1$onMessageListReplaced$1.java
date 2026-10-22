package com.larus.bmhome.social.userchat.model;

import com.larus.bmhome.social.page.datasource.event.RefreshTraceSource;
import com.larus.im.bean.message.Message;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.social.userchat.model.ChatMessageReceiverModel$messageObserver$1$onMessageListReplaced$1", f = "ChatMessageReceiverModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ChatMessageReceiverModel$messageObserver$1$onMessageListReplaced$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<Message> $newMsgList;
    final /* synthetic */ List<Message> $oldMsgList;
    final /* synthetic */ String $replaceTraceId;
    int label;
    final /* synthetic */ ChatMessageReceiverModel this$0;

    public ChatMessageReceiverModel$messageObserver$1$onMessageListReplaced$1(ChatMessageReceiverModel r1, List<Message> r2, List<Message> r3, String r4, Continuation<? super ChatMessageReceiverModel$messageObserver$1$onMessageListReplaced$1> r5) {
        this.this$0 = r1;
        this.$oldMsgList = r2;
        this.$newMsgList = r3;
        this.$replaceTraceId = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new ChatMessageReceiverModel$messageObserver$1$onMessageListReplaced$1(this.this$0, this.$oldMsgList, this.$newMsgList, this.$replaceTraceId, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r12) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L22;
        ResultKt.throwOnFailure(r12);
        ChatMessageReceiverModel r13 = this.this$0;
        List<Message> r0 = this.$oldMsgList;
        int r1 = ChatMessageReceiverModel.P;
        r13.r("onMessageListReplaced oldMsgList  ", r0);
        this.this$0.r("onMessageListReplaced newMsgList  ", this.$newMsgList);
        ChatMessageReceiverModel r14 = this.this$0;
        List<Message> r2 = this.$newMsgList;
        if (r14.E.isEmpty() == true) goto L15;
        ArrayList r3 = new ArrayList();
        Iterator<T> r4 = r2.iterator();
    L9:
        if (r4.hasNext() == false) goto L11;
        CollectionsKt.addAll(r3, ChatMessageReceiverModel.y((Message) r4.next()));
        goto L9
    L11:
        Iterator r5 = r3.iterator();
    L13:
        if (r5.hasNext() == false) goto L15;
        String r6 = (String) r5.next();
        r14.E.remove(r6);
    L15:
        this.this$0.k(this.$oldMsgList);
        List<Message> r15 = this.$oldMsgList;
        ChatMessageReceiverModel r7 = this.this$0;
        Iterator<T> r16 = r15.iterator();
    L17:
        if (r16.hasNext() == false) goto L19;
        Message r8 = (Message) r16.next();
        HashMap<String, Message> r9 = r7.o;
        String r10 = r8.getLocalMessageId();
        TypeIntrinsics.asMutableMap(r9).remove(r10);
        goto L17
    L19:
        RefreshTraceSource r11 = RefreshTraceSource.LIST_REPLACE;
        ChatMessageReceiverModel.j(this.this$0, 1, this.$newMsgList, false, null, this.$replaceTraceId, r11, 12);
        return Unit.INSTANCE;
    L22:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
