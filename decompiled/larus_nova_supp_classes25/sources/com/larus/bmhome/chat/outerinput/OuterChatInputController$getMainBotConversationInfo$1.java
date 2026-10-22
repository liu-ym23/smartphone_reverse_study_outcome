package com.larus.bmhome.chat.outerinput;

import com.larus.avlink.model.DoraCallStateCode;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.outerinput.OuterChatInputController", f = "OuterChatInputController.kt", i = {0, 1}, l = {126, DoraCallStateCode.DOUBAO_VUI_ERROR, 135}, m = "getMainBotConversationInfo", n = {"callback", "callback"}, s = {"L$0", "L$0"})
final class OuterChatInputController$getMainBotConversationInfo$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ OuterChatInputController this$0;

    public OuterChatInputController$getMainBotConversationInfo$1(OuterChatInputController r1, Continuation<? super OuterChatInputController$getMainBotConversationInfo$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return OuterChatInputController.d(this.this$0, null, this);
    }
}
