package com.larus.bmhome.chat.outerinput;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.outerinput.OuterChatInput", f = "OuterChatInput.kt", i = {0}, l = {153}, m = "setup", n = {"info"}, s = {"L$0"})
public final class OuterChatInput$setup$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ OuterChatInput this$0;

    public OuterChatInput$setup$1(OuterChatInput r1, Continuation<? super OuterChatInput$setup$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.Z5(null, null, null, this);
    }
}
