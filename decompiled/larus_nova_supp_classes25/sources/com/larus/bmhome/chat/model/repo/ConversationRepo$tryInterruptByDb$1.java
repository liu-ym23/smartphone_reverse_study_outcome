package com.larus.bmhome.chat.model.repo;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.model.repo.ConversationRepo", f = "ConversationRepo.kt", i = {0, 0, 0, 0, 0, 0}, l = {255}, m = "tryInterruptByDb", n = {"conversationId", "breakReason", "msgList", "serverInterrupt", "forceInterrupt", "conversationType"}, s = {"L$0", "L$1", "L$2", "Z$0", "Z$1", "I$0"})
public final class ConversationRepo$tryInterruptByDb$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    boolean Z$0;
    boolean Z$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ConversationRepo this$0;

    public ConversationRepo$tryInterruptByDb$1(ConversationRepo r1, Continuation<? super ConversationRepo$tryInterruptByDb$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r7) {
        this.result = r7;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.B(null, false, false, null, this);
    }
}
