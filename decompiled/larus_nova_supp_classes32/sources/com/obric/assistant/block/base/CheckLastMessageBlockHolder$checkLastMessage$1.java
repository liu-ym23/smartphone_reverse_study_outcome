package com.obric.assistant.block.base;

import com.larus.im.bean.message.Message;
import com.larus.utils.logger.FLogger;
import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.block.base.CheckLastMessageBlockHolder$checkLastMessage$1", f = "CheckLastMessageBlockHolder.kt", i = {}, l = {132}, m = "invokeSuspend", n = {}, s = {})
public final class CheckLastMessageBlockHolder$checkLastMessage$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Message $blockMessage;
    int label;
    final /* synthetic */ CheckLastMessageBlockHolder<T> this$0;

    public CheckLastMessageBlockHolder$checkLastMessage$1(CheckLastMessageBlockHolder<T> r1, Message r2, Continuation<? super CheckLastMessageBlockHolder$checkLastMessage$1> r3) {
        this.this$0 = r1;
        this.$blockMessage = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new CheckLastMessageBlockHolder$checkLastMessage$1(this.this$0, this.$blockMessage, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r5);
    L14:
        Message r6 = (Message) r5;
        if (r6 == null) goto L17;
        boolean r7 = Intrinsics.areEqual(r6.getMessageId(), this.$blockMessage.getMessageId());
        FLogger.a.i("CheckLastMessageBlockHolder", "checkLastMessage: isLastMessage = " + r7);
        this.this$0.h.setValue(Boxing.boxBoolean(r7));
    L19:
        return Unit.INSTANCE;
    L17:
        FLogger.a.w("CheckLastMessageBlockHolder", "getLastMessage: cvsId = " + this.$blockMessage.getConversationId() + ", not found");
        goto L19
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        CheckLastMessageBlockHolder<T> r8 = this.this$0;
        String r2 = this.$blockMessage.getConversationId();
        if (r2 != null) goto L11;
        r2 = NameKeys.UnloadStrategy_No_Strategy;
    L11:
        this.label = 1;
        r5 = CheckLastMessageBlockHolder.j(r8, r2, this);
        if (r5 != r0) goto L14;
        return r0;
    }
}
