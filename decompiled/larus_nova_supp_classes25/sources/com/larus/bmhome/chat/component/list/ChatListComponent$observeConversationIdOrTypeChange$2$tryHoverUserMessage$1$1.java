package com.larus.bmhome.chat.component.list;

import com.larus.bmhome.chat.bean.d;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.im.bean.message.Message;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import sd8.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.list.ChatListComponent$observeConversationIdOrTypeChange$2$tryHoverUserMessage$1$1", f = "ChatListComponent.kt", i = {}, l = {5559}, m = "invokeSuspend", n = {}, s = {})
final class ChatListComponent$observeConversationIdOrTypeChange$2$tryHoverUserMessage$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ wc9.e $conversation;
    int label;
    final /* synthetic */ ChatListComponent this$0;

    public ChatListComponent$observeConversationIdOrTypeChange$2$tryHoverUserMessage$1$1(ChatListComponent r1, wc9.e r2, Continuation<? super ChatListComponent$observeConversationIdOrTypeChange$2$tryHoverUserMessage$1$1> r3) {
        this.this$0 = r1;
        this.$conversation = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new ChatListComponent$observeConversationIdOrTypeChange$2$tryHoverUserMessage$1$1(this.this$0, this.$conversation, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r4);
    L11:
        Message r5 = (Message) r4;
        if (r5 != null) goto L14;
    L16:
        boolean r6 = false;
    L17:
        if (r6 == false) goto L26;
        ConcurrentHashMap r7 = com.larus.bmhome.utils.v3.a;
        wc9.e r8 = this.$conversation;
        ChatListComponent r2 = this.this$0;
        int r3 = ChatListComponent.W3;
        a r9 = r2.p4();
        if (r9 == null) goto L23;
        qy8.a r10 = r9.yu();
        if (r10 == null) goto L23;
        Boolean r11 = r10.h;
    L24:
        com.larus.bmhome.utils.v3.a(r8, r11, this.this$0.R5());
        this.this$0.G = true;
    L23:
        r11 = null;
    L26:
        return Unit.INSTANCE;
    L14:
        if (d.Q0(r5) != true) goto L16;
        r6 = true;
        goto L17
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r4);
        ChatListComponent r12 = this.this$0;
        int r13 = ChatListComponent.W3;
        ChatListComponentViewModel r14 = r12.U5();
        String r15 = this.$conversation.a;
        this.label = 1;
        r4 = r14.findLatestMessage(r15, this);
        if (r4 != r0) goto L11;
        return r0;
    }
}
