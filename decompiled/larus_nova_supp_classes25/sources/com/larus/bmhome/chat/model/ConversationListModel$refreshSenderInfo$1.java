package com.larus.bmhome.chat.model;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.model.ConversationListModel", f = "ConversationListModel.kt", i = {0, 0, 0, 0, 0, 1, 1, 1}, l = {1230, 1237}, m = "refreshSenderInfo", n = {"request", "extra", "tempLocalConversationList", "updateAgainConvId", "it", "extra", "tempLocalConversationList", "updateAgainConvId"}, s = {"L$0", "L$1", "L$2", "L$3", "L$5", "L$0", "L$1", "L$2"})
public final class ConversationListModel$refreshSenderInfo$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ConversationListModel this$0;

    public ConversationListModel$refreshSenderInfo$1(ConversationListModel r1, Continuation<? super ConversationListModel$refreshSenderInfo$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        ConversationListModel r3 = this.this$0;
        ConversationListModel r0 = ConversationListModel.a;
        return r3.C(null, null, null, this);
    }
}
