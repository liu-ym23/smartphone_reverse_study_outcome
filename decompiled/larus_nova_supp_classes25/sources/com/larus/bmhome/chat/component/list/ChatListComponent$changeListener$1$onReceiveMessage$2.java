package com.larus.bmhome.chat.component.list;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.trace.ChatControlTrace;
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
@DebugMetadata(c = "com.larus.bmhome.chat.component.list.ChatListComponent$changeListener$1$onReceiveMessage$2", f = "ChatListComponent.kt", i = {}, l = {1185}, m = "invokeSuspend", n = {}, s = {})
public final class ChatListComponent$changeListener$1$onReceiveMessage$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Message $msg;
    int label;
    final /* synthetic */ ChatListComponent this$0;

    public ChatListComponent$changeListener$1$onReceiveMessage$2(ChatListComponent r1, Message r2, Continuation<? super ChatListComponent$changeListener$1$onReceiveMessage$2> r3) {
        this.this$0 = r1;
        this.$msg = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new ChatListComponent$changeListener$1$onReceiveMessage$2(this.this$0, this.$msg, r4);
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
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r12);
    L22:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r12);
        ChatControlTrace r2 = ChatControlTrace.b;
        ChatListComponent r13 = this.this$0;
        int r3 = ChatListComponent.W3;
        com.larus.bmhome.chat.component.cvs.y r14 = r13.u0();
        if (r14 == null) goto L11;
        wc9.e r15 = r14.h();
    L12:
        String r4 = this.$msg.getMessageId();
        if (r4 != null) goto L15;
        r4 = "";
    L15:
        Message r5 = this.$msg;
        String r6 = r5.getSenderId();
        if (r6 != null) goto L18;
        r6 = "";
    L18:
        Integer r7 = this.this$0.j4();
        this.label = 1;
        if (r2.Aa(r15, r4, r5, null, r6, r7, 0, this) != r0) goto L22;
        return r0;
    L11:
        r15 = null;
        goto L12
    }
}
