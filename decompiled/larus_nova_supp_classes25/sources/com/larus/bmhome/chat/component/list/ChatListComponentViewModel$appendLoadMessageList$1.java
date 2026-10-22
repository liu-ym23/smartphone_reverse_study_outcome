package com.larus.bmhome.chat.component.list;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
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
import vr8.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.list.ChatListComponentViewModel$appendLoadMessageList$1", f = "ChatListComponentViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ChatListComponentViewModel$appendLoadMessageList$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ b $callback;
    final /* synthetic */ Integer $messageLimit;
    int label;
    final /* synthetic */ ChatListComponentViewModel this$0;

    public ChatListComponentViewModel$appendLoadMessageList$1(ChatListComponentViewModel r1, b r2, Integer r3, Continuation<? super ChatListComponentViewModel$appendLoadMessageList$1> r4) {
        this.this$0 = r1;
        this.$callback = r2;
        this.$messageLimit = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new ChatListComponentViewModel$appendLoadMessageList$1(this.this$0, this.$callback, this.$messageLimit, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L19;
        ResultKt.throwOnFailure(r5);
    L14:
        e = move-exception;
        FLogger.a.e("ChatListComponentViewModel", "appendLoadMessageList failed: " + e.getMessage());
        this.$callback.b(com.larus.bmhome.social.page.datasource.event.e.a.a.a);
    L17:
        return Unit.INSTANCE;
    L6:
        if (ChatListComponentViewModel.access$getChatMessageReceiverRepo$p(this.this$0) != null) goto L9;
        FLogger.a.e("ChatListComponentViewModel", "chatMessageReceiverRepo is null, abort appendLoadMessageList");     // Catch: Exception -> L14
        this.$callback.b(com.larus.bmhome.social.page.datasource.event.e.a.a.a);     // Catch: Exception -> L14
        return Unit.INSTANCE;
    L9:
        com.larus.bmhome.social.userchat.model.c0 r6 = ChatListComponentViewModel.access$getChatMessageReceiverRepo$p(this.this$0);     // Catch: Exception -> L14
        if (r6 == null) goto L12;
        r6.b(this.$callback, this.$messageLimit);     // Catch: Exception -> L14
    L12:
        FLogger.a.i("ChatListComponentViewModel", "appendLoad invoke success");     // Catch: Exception -> L14
        goto L17
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
