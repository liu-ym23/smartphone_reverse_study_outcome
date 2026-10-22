package com.larus.bmhome.chat.model.repo;

import com.larus.bmhome.chat.bean.ChatPageContext;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.model.strategy.ChatRetryStrategy;
import com.larus.im.bean.message.Message;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.model.repo.ChatSender$retryNew$retryAction$1$1", f = "ChatSender.kt", i = {}, l = {221, 222}, m = "invokeSuspend", n = {}, s = {})
public final class ChatSender$retryNew$retryAction$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ChatPageContext $chatPageContext;
    final /* synthetic */ Message $msg;
    int label;
    final /* synthetic */ ChatSender this$0;

    public ChatSender$retryNew$retryAction$1$1(ChatSender r1, Message r2, ChatPageContext r3, Continuation<? super ChatSender$retryNew$retryAction$1$1> r4) {
        this.this$0 = r1;
        this.$msg = r2;
        this.$chatPageContext = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new ChatSender$retryNew$retryAction$1$1(this.this$0, this.$msg, this.$chatPageContext, r5);
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
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r11);
    L30:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r11);
    L16:
        wc9.e r12 = (wc9.e) r11;
        if (r12 == null) goto L19;
        ChatRetryStrategy r2 = this.this$0.c;
        Message r3 = this.$msg;
        ChatPageContext r4 = this.$chatPageContext;
        if (r4 != null) goto L23;
    L25:
        r4 = null;
    L26:
        this.label = 2;
        if (r2.q(r3, r12, r4, this) != r0) goto L30;
        return r0;
    L23:
        if (r4.isNotEmpty() == false) goto L25;
    L19:
        return Unit.INSTANCE;
    L10:
        ResultKt.throwOnFailure(r11);
        this.this$0.a.d.d.i6("retryNew", false);
        RepoDispatcher.a.getClass();
        ConversationRepo r5 = RepoDispatcher.f;
        String r13 = this.$msg.getConversationId();
        if (r13 != null) goto L13;
        r13 = "";
    L13:
        this.label = 1;
        r11 = IConversationRepoService$a.c(r5, r13, false, null, this, 6);
        if (r11 != r0) goto L16;
        return r0;
    }
}
