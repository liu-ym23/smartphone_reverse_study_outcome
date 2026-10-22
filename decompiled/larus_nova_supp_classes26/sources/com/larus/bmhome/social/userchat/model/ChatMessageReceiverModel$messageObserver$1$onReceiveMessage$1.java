package com.larus.bmhome.social.userchat.model;

import com.larus.bmhome.social.page.datasource.event.RefreshTraceSource;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.MessageStatus;
import com.larus.platform.spi.IAIChatService;
import com.larus.tts.TtsScene;
import com.larus.utils.logger.FLogger;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.social.userchat.model.ChatMessageReceiverModel$messageObserver$1$onReceiveMessage$1", f = "ChatMessageReceiverModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ChatMessageReceiverModel$messageObserver$1$onReceiveMessage$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Message $msg;
    final /* synthetic */ String $receiveTraceId;
    int label;
    final /* synthetic */ ChatMessageReceiverModel this$0;

    public ChatMessageReceiverModel$messageObserver$1$onReceiveMessage$1(ChatMessageReceiverModel r1, Message r2, String r3, Continuation<? super ChatMessageReceiverModel$messageObserver$1$onReceiveMessage$1> r4) {
        this.this$0 = r1;
        this.$msg = r2;
        this.$receiveTraceId = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new ChatMessageReceiverModel$messageObserver$1$onReceiveMessage$1(this.this$0, this.$msg, this.$receiveTraceId, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L63;
        ResultKt.throwOnFailure(r10);
        ChatMessageReceiverModel r11 = this.this$0;
        Message r0 = this.$msg;
        int r1 = ChatMessageReceiverModel.P;
        if (r11.p(r0) == true) goto L7;
        ChatMessageReceiverModel r12 = this.this$0;
        int r2 = 0;
        r12.D = false;
        Iterator<Message> r13 = r12.n.iterator();
    L10:
        if (r13.hasNext() == false) goto L44;
        Message r3 = r13.next();
        Message r4 = r3;
        Intrinsics.checkNotNull(r4);
        if (com.larus.bmhome.chat.bean.d.i0(r4) == false) goto L17;
        if (com.larus.bmhome.chat.bean.d.w(r4) == true) goto L17;
    L36:
        boolean r5 = false;
    L37:
        if (r5 == true) goto L39;
    L41:
        boolean r6 = false;
    L42:
        if (r6 == false) goto L10;
    L45:
        Message r7 = r3;
        if (r7 == null) goto L57;
        Message r14 = this.$msg;
        if (Intrinsics.areEqual(r14.getReplyId(), r7.getMessageId()) == false) goto L57;
        if (r14.getLocalIndex() >= r7.getLocalIndex()) goto L52;
    L53:
        com.larus.platform.service.o r8 = com.larus.platform.service.o.a;
        Pair[] r9 = new Pair[5];
        r9[0] = TuplesKt.to("receive_message_id", r14.getMessageId());
        if (r14.getLocalIndex() >= r7.getLocalIndex()) goto L56;
        r2 = 1;
    L56:
        r9[1] = TuplesKt.to("is_local_index_error", Boxing.boxInt(r2));
        r9[2] = TuplesKt.to("reply_message_id", r14.getReplyId());
        r9[3] = TuplesKt.to("index_local", Boxing.boxLong(r14.getLocalIndex()));
        r9[4] = TuplesKt.to("index_server", Boxing.boxLong(r14.getServerIndex()));
        r8.b("receive_answer_error", com.larus.utils.f.c(r9));
        goto L57
    L52:
        if (r14.getServerIndex() < r7.getServerIndex()) goto L53;
    L57:
        ChatMessageReceiverModel.f(this.this$0, this.$msg, "onReceiveMessage", RefreshTraceSource.RECEIVE, this.$receiveTraceId);
        ChatMessageReceiverModel r15 = this.this$0;
        Message r16 = this.$msg;
        r15.getClass();
        if ((!com.larus.im.bean.message.a.C0(r16)) == false) goto L60;
        FLogger.a.i("onReceiveMessage", "receive msg play :msgId = " + this.$msg.getMessageId());
        ChatMessageReceiverModel r17 = this.this$0;
        r17.u.a(r17.r, r17.n, this.$msg, TtsScene.Auto_ReceiveMessage);
    L60:
        IAIChatService.a.f(this.$msg);
        return Unit.INSTANCE;
    L39:
        if (b0.f(r4) == true) goto L41;
        r6 = true;
    L17:
        if (com.larus.bmhome.chat.bean.d.T(r4) == true) goto L36;
        if (com.larus.bmhome.chat.bean.d.p0(r4) == true) goto L36;
        if (com.larus.bmhome.chat.bean.d.C0(r4) == true) goto L24;
    L26:
        MessageStatus r18 = r4.getMessageStatus();
        if (r18 != null) goto L29;
    L31:
        boolean r19 = false;
    L32:
        if (r19 == false) goto L34;
    L35:
        r5 = true;
        goto L37
    L34:
        if (b0.f(r4) == false) goto L36;
    L29:
        if (r18.isVisible() != true) goto L31;
        r19 = true;
        goto L32
    L24:
        if (r4.getRegenVisible() == true) goto L26;
    L44:
        r3 = null;
        goto L45
    L7:
        return Unit.INSTANCE;
    L63:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
