package com.larus.bmhome.video;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.video.RecommendVideoApi", f = "RecommendVideoApi.kt", i = {0, 0, 0, 0, 0, 0, 0}, l = {169}, m = "requestRecommendVideo", n = {"scene", "type", "messageId", "recommendType", "page", "isInnerStreamPreload", "startTime"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0", "Z$0", "J$0"})
public final class RecommendVideoApi$requestRecommendVideo$1 extends ContinuationImpl {
    int I$0;
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ RecommendVideoApi this$0;

    public RecommendVideoApi$requestRecommendVideo$1(RecommendVideoApi r1, Continuation<? super RecommendVideoApi$requestRecommendVideo$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r14) {
        this.result = r14;
        this.label |= Integer.MIN_VALUE;
        RecommendVideoApi r0 = this.this$0;
        RecommendVideoApi r15 = RecommendVideoApi.a;
        return r0.e(null, null, 0, 0, false, false, null, null, null, null, null, this);
    }
}
