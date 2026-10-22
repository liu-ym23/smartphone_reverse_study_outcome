package com.larus.bmhome.chat.adapter;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.adapter.MessageAdapter", f = "MessageAdapter.kt", i = {0, 0, 1}, l = {232, 234}, m = "submitEvent$suspendImpl", n = {"$this", "event", "event"}, s = {"L$0", "L$1", "L$0"})
public final class MessageAdapter$submitEvent$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MessageAdapter this$0;

    public MessageAdapter$submitEvent$1(MessageAdapter r1, Continuation<? super MessageAdapter$submitEvent$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return MessageAdapter.L2(this.this$0, null, this);
    }
}
