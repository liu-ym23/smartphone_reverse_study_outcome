package com.larus.bmhome.chat.component.cvs;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.im.bean.bot.BotModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lcom/larus/bmhome/chat/component/cvs/ChatConversationVMState;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.cvs.ChatConversationComponent$addBotChangeListener$2", f = "ChatConversationComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ChatConversationComponent$addBotChangeListener$2 extends SuspendLambda implements Function2<ChatConversationVMState, Continuation<? super Unit>, Object> {
    final /* synthetic */ y.a<BotModel> $listener;
    /* synthetic */ Object L$0;
    int label;

    public ChatConversationComponent$addBotChangeListener$2(y.a<BotModel> r1, Continuation<? super ChatConversationComponent$addBotChangeListener$2> r2) {
        this.$listener = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        ChatConversationComponent$addBotChangeListener$2 r0 = new ChatConversationComponent$addBotChangeListener$2(this.$listener, r4);
        r0.L$0 = r3;
        return r0;
    }

    public final Object invoke(ChatConversationVMState r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((ChatConversationVMState) r1, (Continuation) r2);
    }

    public final Object invokeSuspend(Object r2) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L10;
        ResultKt.throwOnFailure(r2);
        BotModel r3 = ((ChatConversationVMState) this.L$0).getBot();
        if (r3 == null) goto L8;
        this.$listener.c(r3);
    L8:
        return Unit.INSTANCE;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
