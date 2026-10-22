package com.larus.bmhome.chat.model.repo;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.model.repo.ChatSender", f = "ChatSender.kt", i = {0, 0, 1, 1}, l = {1031, 1035}, m = "conversationOf", n = {"id", "botId", "id", "botId"}, s = {"L$0", "L$1", "L$0", "L$1"})
public final class ChatSender$conversationOf$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ChatSender this$0;

    public ChatSender$conversationOf$1(ChatSender r1, Continuation<? super ChatSender$conversationOf$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        ChatSender r3 = this.this$0;
        int r0 = ChatSender.j;
        return r3.x(null, null, this);
    }
}
