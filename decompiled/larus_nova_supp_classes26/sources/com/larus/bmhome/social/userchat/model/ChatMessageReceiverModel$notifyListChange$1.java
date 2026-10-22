package com.larus.bmhome.social.userchat.model;

import com.larus.bmhome.chat.api.WidgetRenderDelegate;
import com.larus.im.bean.message.Message;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
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
import tx9.x3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.social.userchat.model.ChatMessageReceiverModel$notifyListChange$1", f = "ChatMessageReceiverModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ChatMessageReceiverModel$notifyListChange$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Runnable $extraAction;
    final /* synthetic */ boolean $first;
    final /* synthetic */ String $source;
    final /* synthetic */ String $traceId;
    int label;
    final /* synthetic */ ChatMessageReceiverModel this$0;

    public ChatMessageReceiverModel$notifyListChange$1(String r1, ChatMessageReceiverModel r2, String r3, boolean r4, Runnable r5, Continuation<? super ChatMessageReceiverModel$notifyListChange$1> r6) {
        this.$traceId = r1;
        this.this$0 = r2;
        this.$source = r3;
        this.$first = r4;
        this.$extraAction = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new ChatMessageReceiverModel$notifyListChange$1(this.$traceId, this.this$0, this.$source, this.$first, this.$extraAction, r9);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L28;
        ResultKt.throwOnFailure(r10);
        FLogger r11 = FLogger.a;
        r11.i("MsgRefreshFlow_ChatMessageReceiverModel", "notifyMsgListChange rt=" + this.$traceId + " cid=" + this.this$0.b + " source=" + this.$source + " first=" + this.$first + " size=" + this.this$0.n.size());
        ChatMessageReceiverModel r0 = this.this$0;
        if (r0.c == 3) goto L7;
        x3.a("message_list", "legacy_social_notify_list_change", "conversation_type=" + this.this$0.c);
    L26:
        return Unit.INSTANCE;
    L7:
        if (r0.o.size() == r0.n.size()) goto L21;
        String r1 = r0.k;
        StringBuilder r2 = new StringBuilder("messageset ");
        HashMap<String, Message> r3 = r0.o;
        ArrayList r4 = new ArrayList(r3.size());
        Iterator<Map.Entry<String, Message>> r5 = r3.entrySet().iterator();
    L10:
        if (r5.hasNext() == false) goto L12;
        r4.add(r5.next().getKey());
        goto L10
    L12:
        r2.append(r4);
        r11.i(r1, r2.toString());
        FLogger r12 = FLogger.a;
        String r6 = r0.k;
        StringBuilder r7 = new StringBuilder("messageList ");
        CopyOnWriteArrayList<Message> r8 = r0.n;
        ArrayList r9 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r8, 10));
        Iterator<Message> r13 = r8.iterator();
    L14:
        if (r13.hasNext() == false) goto L16;
        r9.add(r13.next().getLocalMessageId());
        goto L14
    L16:
        r7.append(r9);
        r12.i(r6, r7.toString());
        FLogger r14 = FLogger.a;
        String r15 = r0.k;
        StringBuilder r16 = new StringBuilder("messageList index ");
        CopyOnWriteArrayList<Message> r17 = r0.n;
        ArrayList r18 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r17, 10));
        Iterator<Message> r19 = r17.iterator();
    L18:
        if (r19.hasNext() == false) goto L20;
        r18.add(Long.valueOf(r19.next().getLocalIndex()));
        goto L18
    L20:
        r16.append(r18);
        r14.i(r15, r16.toString());
        String r110 = r0.k;
        String r20 = "messageSet and messageList is not the same size messageMap.size: " + r0.o.size() + "  messageList.size: " + r0.n.size() + ' ';
        Intrinsics.checkNotNullParameter(r110, "<this>");
        Intrinsics.checkNotNullParameter(r20, "errorMsg");
        FLogger.a.e(r110, r20);
    L21:
        WidgetRenderDelegate.a.c(this.this$0.n);
        ChatMessageReceiverModel r111 = this.this$0;
        ChatMessageReceiverModel.c r21 = r111.q;
        if (r21 == null) goto L26;
        r21.a(this.$first, r111.n, r111.e, r111.D, this.$extraAction, this.$source, this.$traceId);
        goto L26
    L28:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
