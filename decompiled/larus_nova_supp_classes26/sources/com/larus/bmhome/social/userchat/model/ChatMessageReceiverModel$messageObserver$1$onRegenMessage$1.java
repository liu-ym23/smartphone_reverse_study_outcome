package com.larus.bmhome.social.userchat.model;

import com.larus.bmhome.social.page.datasource.event.RefreshTraceSource;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.social.userchat.model.ChatMessageReceiverModel$messageObserver$1$onRegenMessage$1", f = "ChatMessageReceiverModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ChatMessageReceiverModel$messageObserver$1$onRegenMessage$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Message $msg;
    final /* synthetic */ String $regenTraceId;
    int label;
    final /* synthetic */ ChatMessageReceiverModel this$0;

    public ChatMessageReceiverModel$messageObserver$1$onRegenMessage$1(ChatMessageReceiverModel r1, Message r2, String r3, Continuation<? super ChatMessageReceiverModel$messageObserver$1$onRegenMessage$1> r4) {
        this.this$0 = r1;
        this.$msg = r2;
        this.$regenTraceId = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new ChatMessageReceiverModel$messageObserver$1$onRegenMessage$1(this.this$0, this.$msg, this.$regenTraceId, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r9) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r9);
        ChatMessageReceiverModel r10 = this.this$0;
        Message r0 = this.$msg;
        int r1 = ChatMessageReceiverModel.P;
        r10.q("onRegenMessage cid  ", r0);
        ChatMessageReceiverModel r2 = this.this$0;
        r2.D = true;
        RefreshTraceSource r6 = RefreshTraceSource.REGEN;
        ChatMessageReceiverModel.u(r2, null, "onRegenMessage", this.$regenTraceId, r6, 3);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
