package com.larus.bmhome.social.userchat.model;

import android.os.SystemClock;
import com.larus.bmhome.social.page.datasource.event.RefreshTraceSource;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.MessageStatus;
import com.larus.tts.TtsScene;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Iterator;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.social.userchat.model.ChatMessageReceiverModel$messageObserver$1$onUpdateMessage$1", f = "ChatMessageReceiverModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ChatMessageReceiverModel$messageObserver$1$onUpdateMessage$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Message $msg;
    final /* synthetic */ String $updateTraceId;
    int label;
    final /* synthetic */ ChatMessageReceiverModel this$0;

    public ChatMessageReceiverModel$messageObserver$1$onUpdateMessage$1(ChatMessageReceiverModel r1, Message r2, String r3, Continuation<? super ChatMessageReceiverModel$messageObserver$1$onUpdateMessage$1> r4) {
        this.this$0 = r1;
        this.$msg = r2;
        this.$updateTraceId = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new ChatMessageReceiverModel$messageObserver$1$onUpdateMessage$1(this.this$0, this.$msg, this.$updateTraceId, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L94;
        ResultKt.throwOnFailure(r10);
        ChatMessageReceiverModel r11 = this.this$0;
        Message r0 = this.$msg;
        if (((Boolean) r11.F.getValue()).booleanValue() == false) goto L82;
        if (com.larus.bmhome.chat.bean.d.G0(r0) == false) goto L82;
        if (b0.i(r0) == false) goto L82;
        String r1 = r0.getMessageId();
        if (r1 == null) goto L82;
        if (r1.length() <= 0) goto L17;
        boolean r2 = true;
    L18:
        if (r2 == true) goto L21;
        r1 = null;
    L21:
        if (r1 == null) goto L82;
        CopyOnWriteArrayList<Message> r3 = r11.n;
        ArrayList r4 = new ArrayList();
        Iterator<Message> r5 = r3.iterator();
    L25:
        if (r5.hasNext() == false) goto L66;
        Message r6 = r5.next();
        Message r7 = r6;
        Intrinsics.checkNotNull(r7);
        if (com.larus.bmhome.chat.bean.d.G0(r7) == false) goto L29;
    L62:
        boolean r8 = false;
    L63:
        if (r8 == false) goto L25;
        r4.add(r6);
        goto L25
    L29:
        if (com.larus.bmhome.chat.bean.d.i0(r7) == false) goto L34;
        if (com.larus.bmhome.chat.bean.d.w(r7) == true) goto L34;
    L53:
        boolean r9 = false;
    L54:
        if (r9 == false) goto L62;
        if (Intrinsics.areEqual(r7.getReplyId(), r1) == false) goto L62;
        if (r7.getContentType() == 6) goto L62;
        if (com.larus.im.bean.message.a.E(r7) == true) goto L62;
        r8 = true;
    L34:
        if (com.larus.bmhome.chat.bean.d.T(r7) == true) goto L53;
        if (com.larus.bmhome.chat.bean.d.p0(r7) == true) goto L53;
        if (com.larus.bmhome.chat.bean.d.C0(r7) == true) goto L41;
    L43:
        MessageStatus r12 = r7.getMessageStatus();
        if (r12 != null) goto L46;
    L48:
        boolean r13 = false;
    L49:
        if (r13 == false) goto L51;
    L52:
        r9 = true;
        goto L54
    L51:
        if (b0.f(r7) == false) goto L53;
    L46:
        if (r12.isVisible() != true) goto L48;
        r13 = true;
        goto L49
    L41:
        if (r7.getRegenVisible() == true) goto L43;
    L66:
        if (r4.isEmpty() == true) goto L82;
        final long r14 = SystemClock.elapsedRealtime();
        CollectionsKt.removeAll(r11.E.entrySet(), new m(r14));
        ArrayList r15 = new ArrayList();
        Iterator r16 = r4.iterator();
    L70:
        if (r16.hasNext() == false) goto L72;
        CollectionsKt.addAll(r15, ChatMessageReceiverModel.y((Message) r16.next()));
        goto L70
    L72:
        Iterator r17 = r15.iterator();
    L74:
        if (r17.hasNext() == false) goto L76;
        String r18 = (String) r17.next();
        r11.E.put(r18, Long.valueOf(5000 + r14));
        goto L74
    L76:
        FLogger r19 = FLogger.a;
        String r20 = r11.k;
        StringBuilder r21 = new StringBuilder("suppressCurrentReplyForRegen ids=");
        ArrayList r22 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r4, 10));
        Iterator r23 = r4.iterator();
    L78:
        if (r23.hasNext() == false) goto L80;
        r22.add(((Message) r23.next()).getMessageId());
        goto L78
    L80:
        r21.append(r22);
        r19.i(r20, r21.toString());
        r11.B(r4, RefreshTraceSource.REMOVE, "");
        goto L82
    L17:
        r2 = false;
    L82:
        if (this.this$0.p(this.$msg) == false) goto L86;
        return Unit.INSTANCE;
    L86:
        if (this.this$0.n.isEmpty() == true) goto L88;
    L91:
        ChatMessageReceiverModel.f(this.this$0, this.$msg, "onUpdateMessage", RefreshTraceSource.UPDATE, this.$updateTraceId);
        ChatMessageReceiverModel r110 = this.this$0;
        r110.u.a(r110.r, r110.n, this.$msg, TtsScene.Auto_UpdateMessage);
        return Unit.INSTANCE;
    L88:
        if (this.$msg.getServerIndex() <= 1) goto L91;
        FLogger r111 = FLogger.a;
        StringBuilder r24 = new StringBuilder("refreshTrace end=dropped rt=");
        r24.append(this.$updateTraceId);
        r24.append(" source=onUpdateMessage reason=empty_list cost=");
        ChatMessageReceiverModel r25 = this.this$0;
        String r26 = this.$updateTraceId;
        r25.getClass();
        r24.append(ChatMessageReceiverModel.x(r26));
        r111.w("MsgRefreshFlow_ChatMessageReceiverModel", r24.toString());
        return Unit.INSTANCE;
    L94:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
