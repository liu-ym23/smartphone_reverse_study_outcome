package com.larus.bmhome.chat.model.strategy;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.model.strategy.RealtimeFirstMetStrategy", f = "RealtimeFirstMetStrategy.kt", i = {}, l = {142}, m = "requireLocalOnBoardingMsg", n = {}, s = {})
final class RealtimeFirstMetStrategy$requireLocalOnBoardingMsg$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ RealtimeFirstMetStrategy this$0;

    public RealtimeFirstMetStrategy$requireLocalOnBoardingMsg$1(RealtimeFirstMetStrategy r1, Continuation<? super RealtimeFirstMetStrategy$requireLocalOnBoardingMsg$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return RealtimeFirstMetStrategy.a(this.this$0, null, this);
    }
}
