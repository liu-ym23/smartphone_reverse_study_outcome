package com.larus.bmhome.chat.model;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.model.ConversationListModel", f = "ConversationListModel.kt", i = {0, 0, 0, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3}, l = {969, 970, 974, 975}, m = "batchFetchBotAndBrief", n = {"conversationList", "messageBodyList", "source", "conversationList", "messageBodyList", "source", "convSize", "firstLoadSize", "conversationList", "messageBodyList", "source", "convSize", "firstLoadSize"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "I$0", "I$1", "L$0", "L$1", "L$2", "I$0", "I$1"})
public final class ConversationListModel$batchFetchBotAndBrief$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ConversationListModel this$0;

    public ConversationListModel$batchFetchBotAndBrief$1(ConversationListModel r1, Continuation<? super ConversationListModel$batchFetchBotAndBrief$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r7) {
        this.result = r7;
        this.label |= Integer.MIN_VALUE;
        ConversationListModel r0 = this.this$0;
        ConversationListModel r8 = ConversationListModel.a;
        return r0.n(null, null, false, null, this);
    }
}
