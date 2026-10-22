package com.larus.bmhome.double_post.fragment;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.double_post.fragment.RecommendVideoApiRepo", f = "RecommendVideoApiRepo.kt", i = {0, 0, 0, 0, 1, 1, 1}, l = {148, 162}, m = "requestWithRetry", n = {"action", "retryTimes", "delayTime", "attempt", "action", "retryTimes", "delayTime"}, s = {"L$0", "I$0", "J$0", "I$2", "L$0", "I$0", "J$0"})
public final class RecommendVideoApiRepo$requestWithRetry$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    int I$2;
    long J$0;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ RecommendVideoApiRepo this$0;

    public RecommendVideoApiRepo$requestWithRetry$1(RecommendVideoApiRepo r1, Continuation<? super RecommendVideoApiRepo$requestWithRetry$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r7) {
        this.result = r7;
        this.label |= Integer.MIN_VALUE;
        RecommendVideoApiRepo r0 = this.this$0;
        int r8 = RecommendVideoApiRepo.b;
        return r0.e(0, 0, null, this);
    }
}
