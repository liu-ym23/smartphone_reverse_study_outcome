package com.larus.bmhome.chat.model.strategy;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.model.repo.ChatSender;
import com.larus.im.callback.IIMError;
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
@DebugMetadata(c = "com.larus.bmhome.chat.model.strategy.ChatSendStrategy$batchSendMessage$1$5$onFailure$2", f = "ChatSendStrategy.kt", i = {}, l = {476}, m = "invokeSuspend", n = {}, s = {})
public final class ChatSendStrategy$batchSendMessage$1$5$onFailure$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ IIMError $error;
    int label;
    final /* synthetic */ ChatSendStrategy this$0;

    public ChatSendStrategy$batchSendMessage$1$5$onFailure$2(ChatSendStrategy r1, IIMError r2, Continuation<? super ChatSendStrategy$batchSendMessage$1$5$onFailure$2> r3) {
        this.this$0 = r1;
        this.$error = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new ChatSendStrategy$batchSendMessage$1$5$onFailure$2(this.this$0, this.$error, r4);
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
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r4);
        ChatSender r5 = this.this$0.a.e;
        IIMError r2 = this.$error;
        this.label = 1;
        if (r5.N(r2, this) != r0) goto L12;
        return r0;
    }
}
