package com.larus.bmhome.chat.outerinput;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lcom/larus/im/bean/conversation/Conversation;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.outerinput.OuterChatInputController$getMainBotConversationInfo$cvs$2", f = "OuterChatInputController.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class OuterChatInputController$getMainBotConversationInfo$cvs$2 extends SuspendLambda implements Function2<wc9.e, Continuation<? super Boolean>, Object> {
    /* synthetic */ Object L$0;
    int label;

    public OuterChatInputController$getMainBotConversationInfo$cvs$2(Continuation<? super OuterChatInputController$getMainBotConversationInfo$cvs$2> r2) {
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        OuterChatInputController$getMainBotConversationInfo$cvs$2 r0 = new OuterChatInputController$getMainBotConversationInfo$cvs$2(r3);
        r0.L$0 = r2;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((wc9.e) r1, (Continuation) r2);
    }

    public final Object invoke(wc9.e r1, Continuation<? super Boolean> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L11;
        ResultKt.throwOnFailure(r4);
        wc9.e r5 = (wc9.e) this.L$0;
        FLogger.a.i("OuterChatInputController", "use requestedConversationInfo");
        if (r5 == null) goto L7;
        boolean r6 = true;
    L9:
        return Boxing.boxBoolean(r6);
    L7:
        r6 = false;
        goto L9
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
