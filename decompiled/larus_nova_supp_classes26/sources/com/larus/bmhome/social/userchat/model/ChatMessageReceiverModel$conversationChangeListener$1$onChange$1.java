package com.larus.bmhome.social.userchat.model;

import com.larus.bmhome.social.page.datasource.event.RefreshTraceSource;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.social.userchat.model.ChatMessageReceiverModel$conversationChangeListener$1$onChange$1", f = "ChatMessageReceiverModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class ChatMessageReceiverModel$conversationChangeListener$1$onChange$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $conversationChangeTraceId;
    int label;
    final /* synthetic */ ChatMessageReceiverModel this$0;

    public ChatMessageReceiverModel$conversationChangeListener$1$onChange$1(ChatMessageReceiverModel r1, String r2, Continuation<? super ChatMessageReceiverModel$conversationChangeListener$1$onChange$1> r3) {
        this.this$0 = r1;
        this.$conversationChangeTraceId = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new ChatMessageReceiverModel$conversationChangeListener$1$onChange$1(this.this$0, this.$conversationChangeTraceId, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r8);
        RefreshTraceSource r5 = RefreshTraceSource.CONVERSATION_CHANGE;
        ChatMessageReceiverModel.u(this.this$0, null, "conversationChange", this.$conversationChangeTraceId, r5, 3);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
