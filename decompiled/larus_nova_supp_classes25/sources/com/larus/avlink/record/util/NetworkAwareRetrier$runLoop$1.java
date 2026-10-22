package com.larus.avlink.record.util;

import com.larus.avlink.model.DoraCallStateCode;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.avlink.record.util.NetworkAwareRetrier", f = "NetworkAwareRetrier.kt", i = {0, 0, 1, 1, 1}, l = {157, DoraCallStateCode.ENV_OBSERVE_END}, m = "runLoop", n = {"$this$runLoop", "index", "$this$runLoop", "index", "delayMs"}, s = {"L$0", "I$0", "L$0", "I$0", "J$0"})
final class NetworkAwareRetrier$runLoop$1 extends ContinuationImpl {
    int I$0;
    long J$0;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ NetworkAwareRetrier this$0;

    public NetworkAwareRetrier$runLoop$1(NetworkAwareRetrier r1, Continuation<? super NetworkAwareRetrier$runLoop$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return NetworkAwareRetrier.a(this.this$0, null, this);
    }
}
