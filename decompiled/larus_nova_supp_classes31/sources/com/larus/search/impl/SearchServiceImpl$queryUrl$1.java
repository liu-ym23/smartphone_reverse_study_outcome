package com.larus.search.impl;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.search.impl.SearchServiceImpl", f = "SearchServiceImpl.kt", i = {0}, l = {123}, m = "queryUrl", n = {"text"}, s = {"L$0"})
public final class SearchServiceImpl$queryUrl$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SearchServiceImpl this$0;

    public SearchServiceImpl$queryUrl$1(SearchServiceImpl r1, Continuation<? super SearchServiceImpl$queryUrl$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.o(null, this);
    }
}
