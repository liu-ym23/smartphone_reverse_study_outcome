package com.larus.bmhome.chat.component.list;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.model.repo.ChatRepo;
import com.larus.bmhome.chat.model.repo.RepoDispatcher;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.MessageStatus;
import com.larus.im.d;
import com.larus.im.service.IMessageService;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.list.ChatListComponentViewModel$hideMessage$1", f = "ChatListComponentViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ChatListComponentViewModel$hideMessage$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Message $message;
    int label;

    public ChatListComponentViewModel$hideMessage$1(Message r1, Continuation<? super ChatListComponentViewModel$hideMessage$1> r2) {
        this.$message = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new ChatListComponentViewModel$hideMessage$1(this.$message, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r9) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L15;
        ResultKt.throwOnFailure(r9);
        RepoDispatcher.a.getClass();
        ChatRepo r10 = RepoDispatcher.d;
        String r0 = this.$message.getMessageId();
        if (r0 != null) goto L7;
        String r3 = "";
    L8:
        MessageStatus r4 = MessageStatus.MessageStatus_INVISIBLE;
        String r1 = this.$message.getConversationId();
        if (r1 != null) goto L11;
        String r5 = "";
    L12:
        r10.getClass();
        Intrinsics.checkNotNullParameter(r3, "messageId");
        Intrinsics.checkNotNullParameter(r4, "status");
        Intrinsics.checkNotNullParameter(r5, "conversationId");
        IMessageService.a.c(d.e(), r3, r4, r5, null, 48);
        return Unit.INSTANCE;
    L11:
        r5 = r1;
        goto L12
    L7:
        r3 = r0;
        goto L8
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
