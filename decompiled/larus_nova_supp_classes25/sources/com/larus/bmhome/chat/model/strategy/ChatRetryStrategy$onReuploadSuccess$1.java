package com.larus.bmhome.chat.model.strategy;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
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
@DebugMetadata(c = "com.larus.bmhome.chat.model.strategy.ChatRetryStrategy$onReuploadSuccess$1", f = "ChatRetryStrategy.kt", i = {}, l = {881}, m = "invokeSuspend", n = {}, s = {})
final class ChatRetryStrategy$onReuploadSuccess$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ wc9.e $conversation;
    final /* synthetic */ ic8.w $strategy;
    int label;
    final /* synthetic */ ChatRetryStrategy this$0;

    public ChatRetryStrategy$onReuploadSuccess$1(ChatRetryStrategy r1, wc9.e r2, ic8.w r3, Continuation<? super ChatRetryStrategy$onReuploadSuccess$1> r4) {
        this.this$0 = r1;
        this.$conversation = r2;
        this.$strategy = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new ChatRetryStrategy$onReuploadSuccess$1(this.this$0, this.$conversation, this.$strategy, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r8);
    L11:
        g0.a.d((g0) r8, this.$conversation, this.$strategy, null, false, "onReuploadSuccess", 12);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r8);
        ChatRetryStrategy r9 = this.this$0;
        wc9.e r2 = this.$conversation;
        this.label = 1;
        int r3 = ChatRetryStrategy.e;
        r8 = r9.h(r2, this);
        if (r8 != r0) goto L11;
        return r0;
    }
}
