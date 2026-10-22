package com.larus.search.impl;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.search.impl.KmpSearchMixedFeedServiceImpl", f = "KmpSearchMixedFeedServiceImpl.kt", i = {0}, l = {43}, m = "requestMixedFeed", n = {"$this$requestMixedFeed_u24lambda_u243"}, s = {"L$0"})
public final class KmpSearchMixedFeedServiceImpl$requestMixedFeed$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ KmpSearchMixedFeedServiceImpl this$0;

    public KmpSearchMixedFeedServiceImpl$requestMixedFeed$1(KmpSearchMixedFeedServiceImpl r1, Continuation<? super KmpSearchMixedFeedServiceImpl$requestMixedFeed$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r3) {
        this.result = r3;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.r2(null, 0, this);
    }
}
