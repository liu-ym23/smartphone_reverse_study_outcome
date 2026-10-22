package com.larus.bmhome.chat.model.strategy;

import com.larus.avlink.model.DoraCallStateCode;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.model.strategy.ChatRetryStrategy", f = "ChatRetryStrategy.kt", i = {}, l = {DoraCallStateCode.DOUBAO_NETWORK_ERROR_INVALID}, m = "getRealSender", n = {}, s = {})
public final class ChatRetryStrategy$getRealSender$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ChatRetryStrategy this$0;

    public ChatRetryStrategy$getRealSender$1(ChatRetryStrategy r1, Continuation<? super ChatRetryStrategy$getRealSender$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        ChatRetryStrategy r3 = this.this$0;
        int r0 = ChatRetryStrategy.e;
        return r3.h(null, this);
    }
}
