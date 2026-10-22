package com.larus.showcase.service;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.showcase.service.CaseServiceImpl", f = "CaseServiceImpl.kt", i = {0}, l = {28}, m = "preFetchMessageListByRemote", n = {"isFromRecommend"}, s = {"Z$0"})
final class CaseServiceImpl$preFetchMessageListByRemote$1 extends ContinuationImpl {
    Object L$0;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CaseServiceImpl this$0;

    public CaseServiceImpl$preFetchMessageListByRemote$1(CaseServiceImpl r1, Continuation<? super CaseServiceImpl$preFetchMessageListByRemote$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.h(null, this);
    }
}
