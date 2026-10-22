package com.larus.bmhome.chat.model;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.model.ConversationListModel", f = "ConversationListModel.kt", i = {0, 0, 0}, l = {290}, m = "parseBotList", n = {"willReplacedCvs", "conversationList", "recommendBotType"}, s = {"L$0", "L$1", "I$0"})
public final class ConversationListModel$parseBotList$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ConversationListModel this$0;

    public ConversationListModel$parseBotList$1(ConversationListModel r1, Continuation<? super ConversationListModel$parseBotList$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r7) {
        this.result = r7;
        this.label |= Integer.MIN_VALUE;
        ConversationListModel r0 = this.this$0;
        ConversationListModel r8 = ConversationListModel.a;
        return r0.y(null, null, 0, null, this);
    }
}
