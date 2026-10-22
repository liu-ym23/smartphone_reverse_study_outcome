package com.larus.bmhome.chat.model.repo;

import com.larus.avlink.model.DoraCallStateCode;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.model.repo.BotRepo", f = "BotRepo.kt", i = {0, 0, 1}, l = {DoraCallStateCode.DOUBAO_STOP_SI_BY_TIMEOUT, DoraCallStateCode.DOUBAO_RAPID_FLASHING_END}, m = "findBotByConversationId", n = {"conversationId", "forceNew", "conversationId"}, s = {"L$0", "Z$0", "L$0"})
public final class BotRepo$findBotByConversationId$1 extends ContinuationImpl {
    Object L$0;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ BotRepo this$0;

    public BotRepo$findBotByConversationId$1(BotRepo r1, Continuation<? super BotRepo$findBotByConversationId$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r3) {
        this.result = r3;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.j1(null, false, this);
    }
}
