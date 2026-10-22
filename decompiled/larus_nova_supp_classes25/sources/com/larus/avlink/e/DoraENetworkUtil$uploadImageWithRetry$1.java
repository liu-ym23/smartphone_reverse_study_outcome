package com.larus.avlink.e;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.avlink.e.DoraENetworkUtil", f = "DoraENetworkUtil.kt", i = {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1}, l = {117, 149}, m = "uploadImageWithRetry", n = {"images", "onEnd", "request", "mode", "imageId", "success", "currentRetry", "images", "onEnd", "request", "mode", "imageId", "success", "currentRetry"}, s = {"L$0", "L$1", "L$2", "I$0", "I$1", "I$2", "I$3", "L$0", "L$1", "L$2", "I$0", "I$1", "I$2", "I$3"})
final class DoraENetworkUtil$uploadImageWithRetry$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    int I$2;
    int I$3;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ m this$0;

    public DoraENetworkUtil$uploadImageWithRetry$1(m r1, Continuation<? super DoraENetworkUtil$uploadImageWithRetry$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r13) {
        this.result = r13;
        this.label |= Integer.MIN_VALUE;
        m r0 = this.this$0;
        m r14 = m.a;
        return r0.a(null, 0, null, null, null, 0, null, 0, null, null, this);
    }
}
