package com.larus.bmhome.video;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.video.RecommendVideoApi", f = "RecommendVideoApi.kt", i = {0, 0}, l = {80}, m = "prefetchData", n = {"sortScene", "i"}, s = {"L$0", "I$0"})
public final class RecommendVideoApi$prefetchData$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ RecommendVideoApi this$0;

    public RecommendVideoApi$prefetchData$1(RecommendVideoApi r1, Continuation<? super RecommendVideoApi$prefetchData$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.c(null, this);
    }
}
