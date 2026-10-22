package com.larus.bmhome.chat.model.repo;

import com.larus.avlink.model.DoraCallStateCode;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.model.repo.ChatRepo", f = "ChatRepo.kt", i = {1}, l = {DoraCallStateCode.ENV_OBSERVE_END, 745}, m = "findBotByMessageId", n = {"message"}, s = {"L$0"})
public final class ChatRepo$findBotByMessageId$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ChatRepo this$0;

    public ChatRepo$findBotByMessageId$1(ChatRepo r1, Continuation<? super ChatRepo$findBotByMessageId$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.F1(null, this);
    }
}
