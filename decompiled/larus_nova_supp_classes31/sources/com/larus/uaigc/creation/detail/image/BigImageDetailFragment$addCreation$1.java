package com.larus.uaigc.creation.detail.image;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.creation.detail.image.BigImageDetailFragment", f = "BigImageDetailFragment.kt", i = {1, 1, 1, 2, 2, 3, 3}, l = {744, 761, 768, 784}, m = "addCreation", n = {"publisherCreation", "privateStatus", "buttonStatus", "privateStatus", "buttonStatus", "result", "privateStatus"}, s = {"L$0", "I$0", "I$1", "I$0", "I$1", "L$0", "I$0"})
final class BigImageDetailFragment$addCreation$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ BigImageDetailFragment this$0;

    public BigImageDetailFragment$addCreation$1(BigImageDetailFragment r1, Continuation<? super BigImageDetailFragment$addCreation$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return BigImageDetailFragment.U90(this.this$0, this);
    }
}
