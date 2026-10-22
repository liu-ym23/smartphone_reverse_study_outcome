package com.larus.uaigc.creation.detail.image;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.creation.detail.image.BigImageDetailFragment", f = "BigImageDetailFragment.kt", i = {}, l = {395}, m = "getPublisherCreation", n = {}, s = {})
public final class BigImageDetailFragment$getPublisherCreation$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ BigImageDetailFragment this$0;

    public BigImageDetailFragment$getPublisherCreation$1(BigImageDetailFragment r1, Continuation<? super BigImageDetailFragment$getPublisherCreation$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        BigImageDetailFragment r3 = this.this$0;
        int r0 = BigImageDetailFragment.I;
        return r3.fa0(this);
    }
}
