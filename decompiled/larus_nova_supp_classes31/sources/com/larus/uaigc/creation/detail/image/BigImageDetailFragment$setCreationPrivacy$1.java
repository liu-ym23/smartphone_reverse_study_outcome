package com.larus.uaigc.creation.detail.image;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.creation.detail.image.BigImageDetailFragment", f = "BigImageDetailFragment.kt", i = {1, 1, 1, 1, 2, 2, 2}, l = {528, 545, 569, 573}, m = "setCreationPrivacy", n = {"private", "previousStatus", "privateStatus", "buttonStatus", "previousStatus", "privateStatus", "buttonStatus"}, s = {"Z$0", "I$0", "I$1", "I$2", "I$0", "I$1", "I$2"})
final class BigImageDetailFragment$setCreationPrivacy$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    int I$2;
    Object L$0;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ BigImageDetailFragment this$0;

    public BigImageDetailFragment$setCreationPrivacy$1(BigImageDetailFragment r1, Continuation<? super BigImageDetailFragment$setCreationPrivacy$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return BigImageDetailFragment.W90(this.this$0, false, this);
    }
}
