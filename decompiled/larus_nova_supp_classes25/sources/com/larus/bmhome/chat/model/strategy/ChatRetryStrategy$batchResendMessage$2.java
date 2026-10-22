package com.larus.bmhome.chat.model.strategy;

import com.larus.bmhome.chat.bean.ChatPageContext;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.model.repo.ChatRepo;
import com.larus.im.bean.message.Message;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.model.strategy.ChatRetryStrategy$batchResendMessage$2", f = "ChatRetryStrategy.kt", i = {2}, l = {259, 261, 271}, m = "invokeSuspend", n = {"messageStrategies"}, s = {"L$0"})
public final class ChatRetryStrategy$batchResendMessage$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ChatPageContext $chatPageContext;
    final /* synthetic */ wc9.e $conversation;
    final /* synthetic */ Message $message;
    final /* synthetic */ Function1<Continuation<? super Unit>, Object> $originalCall;
    Object L$0;
    int label;
    final /* synthetic */ ChatRetryStrategy this$0;

    public ChatRetryStrategy$batchResendMessage$2(ChatRetryStrategy r1, Message r2, Function1<? super Continuation<? super Unit>, ? extends Object> r3, wc9.e r4, ChatPageContext r5, Continuation<? super ChatRetryStrategy$batchResendMessage$2> r6) {
        this.this$0 = r1;
        this.$message = r2;
        this.$originalCall = r3;
        this.$conversation = r4;
        this.$chatPageContext = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new ChatRetryStrategy$batchResendMessage$2(this.this$0, this.$message, this.$originalCall, this.$conversation, this.$chatPageContext, r9);
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
        if (r1 == 0) goto L12;
        if (r1 == 1) goto L11;
        if (r1 == 2) goto L10;
        if (r1 != 3) goto L9;
        List r2 = (List) this.L$0;
        ResultKt.throwOnFailure(r8);
        List r3 = r2;
    L34:
        g0.a.a((g0) r8, this.$conversation, r3, "retryNestedFileMessage", false, 20);
        return Unit.INSTANCE;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        ResultKt.throwOnFailure(r8);
    L23:
        return Unit.INSTANCE;
    L11:
        ResultKt.throwOnFailure(r8);
    L15:
        List r9 = (List) r8;
        if (r9.isEmpty() == false) goto L24;
        Function1<Continuation<? super Unit>, Object> r10 = this.$originalCall;
        if (r10 == null) goto L23;
        this.label = 2;
        if (r10.invoke(this) != r0) goto L23;
        return r0;
    L24:
        ChatRetryStrategy r4 = this.this$0;
        ChatPageContext r5 = this.$chatPageContext;
        ArrayList r6 = new ArrayList();
        Iterator r11 = r9.iterator();
    L26:
        if (r11.hasNext() == false) goto L30;
        Message r7 = (Message) r11.next();
        com.larus.bmhome.chat.trace.appreciable.y.b(r7);
        Lazy r12 = com.larus.bmhome.chat.trace.appreciable.b0.a;
        com.larus.bmhome.chat.trace.appreciable.b0.c(r7.getLocalMessageId());
        int r13 = ChatRetryStrategy.e;
        r4.getClass();
        ic8.w r14 = ChatRetryStrategy.r(r7, false, r5);
        if (r14 == null) goto L26;
        r6.add(r14);
        goto L26
    L30:
        ChatRetryStrategy r15 = this.this$0;
        wc9.e r16 = this.$conversation;
        this.L$0 = r6;
        this.label = 3;
        int r17 = ChatRetryStrategy.e;
        r8 = r15.h(r16, this);
        if (r8 != r0) goto L33;
        return r0;
    L33:
        r3 = r6;
        goto L34
    L12:
        ResultKt.throwOnFailure(r8);
        ChatRepo r18 = this.this$0.a;
        Message r19 = this.$message;
        this.label = 1;
        r8 = r18.s1(r19, this);
        if (r8 != r0) goto L15;
        return r0;
    }
}
