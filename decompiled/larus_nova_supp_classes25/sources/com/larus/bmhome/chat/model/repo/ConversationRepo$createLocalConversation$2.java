package com.larus.bmhome.chat.model.repo;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.model.repo.ConversationRepo", f = "ConversationRepo.kt", i = {0, 0, 0}, l = {915}, m = "createLocalConversation", n = {"extraData", "projectId", "newBotModel"}, s = {"L$0", "L$1", "L$2"})
public final class ConversationRepo$createLocalConversation$2 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ConversationRepo this$0;

    public ConversationRepo$createLocalConversation$2(ConversationRepo r1, Continuation<? super ConversationRepo$createLocalConversation$2> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.k(null, null, null, this);
    }
}
