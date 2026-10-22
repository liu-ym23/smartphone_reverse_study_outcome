package com.larus.bmhome.chat.deepsearch;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.deepsearch.DeepSearchUtil", f = "DeepSearchUtil.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1, 1}, l = {MessageCellStateTransformerType.EXPERT_CARD, MessageCellStateTransformerType.CIPHER}, m = "sendDeepSearchMessageFrom", n = {"fromMsgId", "cvsId", "chatPageContext", "callback", "fromMsgId", "cvsId", "chatPageContext", "callback", "questionMsgID", "traceId"}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5"})
final class DeepSearchUtil$sendDeepSearchMessageFrom$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ m this$0;

    public DeepSearchUtil$sendDeepSearchMessageFrom$1(m r1, Continuation<? super DeepSearchUtil$sendDeepSearchMessageFrom$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r7) {
        this.result = r7;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(null, null, null, null, this);
    }
}
