package com.larus.showcase.service;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.showcase.service.CaseRepo", f = "CaseRepo.kt", i = {1, 2, 3, 3, 4}, l = {275, 278, 286, 294, 296}, m = "fetchRecommendCaseList", n = {"cacheList", "cacheList", "cacheList", "caseList", "caseList"}, s = {"L$0", "L$0", "L$0", "L$1", "L$0"})
public final class CaseRepo$fetchRecommendCaseList$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CaseRepo this$0;

    public CaseRepo$fetchRecommendCaseList$1(CaseRepo r1, Continuation<? super CaseRepo$fetchRecommendCaseList$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.c(this);
    }
}
