package com.larus.bmhome.social.userchat.model;

import com.larus.bmhome.chat.model.repo.IBotRepoService;
import com.larus.bmhome.chat.model.repo.RepoDispatcherDelegate;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.platform.spi.IAIChatControlTraceService;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.social.userchat.model.ChatMessageReceiverModel$messageObserver$1$onReceiveMessage$2", f = "ChatMessageReceiverModel.kt", i = {}, l = {372, 373}, m = "invokeSuspend", n = {}, s = {})
public final class ChatMessageReceiverModel$messageObserver$1$onReceiveMessage$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Message $msg;
    int label;
    final /* synthetic */ ChatMessageReceiverModel this$0;

    public ChatMessageReceiverModel$messageObserver$1$onReceiveMessage$2(Message r1, ChatMessageReceiverModel r2, Continuation<? super ChatMessageReceiverModel$messageObserver$1$onReceiveMessage$2> r3) {
        this.$msg = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new ChatMessageReceiverModel$messageObserver$1$onReceiveMessage$2(this.$msg, this.this$0, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r12) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r12);
    L35:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r12);
    L16:
        BotModel r13 = (BotModel) r12;
        wc9.e r2 = null;
        if (r13 == null) goto L19;
        String r8 = r13.getBotId();
    L20:
        IAIChatControlTraceService.Companion r4 = IAIChatControlTraceService.a;
        String r14 = this.$msg.getReplyId();
        if (r14 != null) goto L23;
        String r5 = "";
    L25:
        if (this.$msg.getMessageStatusLocal() != 22) goto L27;
        String r7 = "answer_error";
    L28:
        Function0<wc9.e> r15 = this.this$0.f;
        if (r15 == null) goto L31;
        r2 = (wc9.e) r15.invoke();
    L31:
        Message r6 = this.$msg;
        this.label = 2;
        if (r4.Vb(r5, r6, r7, r8, r2, this) != r0) goto L35;
        return r0;
    L27:
        r7 = null;
        goto L28
    L23:
        r5 = r14;
        goto L25
    L19:
        r8 = null;
        goto L20
    L10:
        ResultKt.throwOnFailure(r12);
        IBotRepoService r16 = RepoDispatcherDelegate.b.b();
        String r3 = this.$msg.getConversationId();
        if (r3 != null) goto L13;
        r3 = "";
    L13:
        this.label = 1;
        r12 = r16.j1(r3, false, this);
        if (r12 != r0) goto L16;
        return r0;
    }
}
