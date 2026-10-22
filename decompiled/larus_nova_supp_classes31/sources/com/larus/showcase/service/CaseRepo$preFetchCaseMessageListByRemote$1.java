package com.larus.showcase.service;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.showcase.service.CaseRepo", f = "CaseRepo.kt", i = {0, 0}, l = {130}, m = "preFetchCaseMessageListByRemote", n = {"caseId", "isFromRecommend"}, s = {"L$0", "Z$0"})
public final class CaseRepo$preFetchCaseMessageListByRemote$1 extends ContinuationImpl {
    Object L$0;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CaseRepo this$0;

    public CaseRepo$preFetchCaseMessageListByRemote$1(CaseRepo r1, Continuation<? super CaseRepo$preFetchCaseMessageListByRemote$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r3) {
        this.result = r3;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.i(null, false, this);
    }
}
