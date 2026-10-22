package com.larus.bmhome.chat.model.strategy;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.model.strategy.ChatRetryStrategy", f = "ChatRetryStrategy.kt", i = {0, 0}, l = {248}, m = "resendMessage", n = {"conversation", "strategy"}, s = {"L$0", "L$1"})
public final class ChatRetryStrategy$resendMessage$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ChatRetryStrategy this$0;

    public ChatRetryStrategy$resendMessage$1(ChatRetryStrategy r1, Continuation<? super ChatRetryStrategy$resendMessage$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r7) {
        this.result = r7;
        this.label |= Integer.MIN_VALUE;
        ChatRetryStrategy r0 = this.this$0;
        int r8 = ChatRetryStrategy.e;
        return r0.o(null, null, false, null, this);
    }
}
