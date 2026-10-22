package com.larus.bmhome.chat.model.repo;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.model.repo.ChatSender$streamAudioText$1", f = "ChatSender.kt", i = {}, l = {747, 748}, m = "invokeSuspend", n = {}, s = {})
public final class ChatSender$streamAudioText$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Message $msg;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ChatSender this$0;

    public ChatSender$streamAudioText$1(Message r1, ChatSender r2, Continuation<? super ChatSender$streamAudioText$1> r3) {
        this.$msg = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        ChatSender$streamAudioText$1 r0 = new ChatSender$streamAudioText$1(this.$msg, this.this$0, r5);
        r0.L$0 = r4;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        Message r2 = (Message) this.L$0;
        ResultKt.throwOnFailure(r5);
    L23:
        ((com.larus.bmhome.chat.model.strategy.g0) r5).streamAudioText(r2);
    L25:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r5);
    L17:
        wc9.e r6 = (wc9.e) r5;
        if (r6 == null) goto L25;
        ChatSender r3 = this.this$0;
        Message r4 = this.$msg;
        this.L$0 = r4;
        this.label = 2;
        int r7 = ChatSender.j;
        r5 = r3.C(r6, this);
        if (r5 != r0) goto L22;
        return r0;
    L22:
        r2 = r4;
        goto L23
    L10:
        ResultKt.throwOnFailure(r5);
        CoroutineScope r8 = (CoroutineScope) this.L$0;
        String r9 = this.$msg.getConversationId();
        if (r9 != null) goto L14;
        FLogger.a.e("ChatSender", "streamAudioText conversationId is null. Abort");
        return Unit.INSTANCE;
    L14:
        ChatSender r10 = this.this$0;
        this.label = 1;
        r5 = ChatSender.y(r10, r9, this);
        if (r5 != r0) goto L17;
        return r0;
    }
}
