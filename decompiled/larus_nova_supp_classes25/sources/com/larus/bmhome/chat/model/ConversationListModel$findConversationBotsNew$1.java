package com.larus.bmhome.chat.model;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.model.ConversationListModel", f = "ConversationListModel.kt", i = {0, 0, 0, 1, 1, 1}, l = {1284, 1288}, m = "findConversationBotsNew", n = {"source", "convIdList", "conversationId", "source", "conversationId", "mainBotResult"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2"})
public final class ConversationListModel$findConversationBotsNew$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ConversationListModel this$0;

    public ConversationListModel$findConversationBotsNew$1(ConversationListModel r1, Continuation<? super ConversationListModel$findConversationBotsNew$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        ConversationListModel r3 = this.this$0;
        ConversationListModel r0 = ConversationListModel.a;
        return r3.p(null, null, this);
    }
}
