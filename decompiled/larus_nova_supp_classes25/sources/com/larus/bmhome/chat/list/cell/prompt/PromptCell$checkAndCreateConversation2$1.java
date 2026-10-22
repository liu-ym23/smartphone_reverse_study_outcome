package com.larus.bmhome.chat.list.cell.prompt;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.list.cell.prompt.PromptCell", f = "PromptCell.kt", i = {0, 1}, l = {1411, 1414}, m = "checkAndCreateConversation2", n = {"data", "conversationId"}, s = {"L$0", "L$0"})
final class PromptCell$checkAndCreateConversation2$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PromptCell this$0;

    public PromptCell$checkAndCreateConversation2$1(PromptCell r1, Continuation<? super PromptCell$checkAndCreateConversation2$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return PromptCell.o(this.this$0, null, this);
    }
}
