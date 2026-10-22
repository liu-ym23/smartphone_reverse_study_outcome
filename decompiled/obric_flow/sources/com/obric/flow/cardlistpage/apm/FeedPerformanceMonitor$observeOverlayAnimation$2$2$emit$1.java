package com.obric.flow.cardlistpage.apm;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.obric.flow.cardlistpage.apm.FeedPerformanceMonitor$observeOverlayAnimation$2$2", f = "FeedPerformanceMonitor.kt", i = {0}, l = {60}, m = "emit", n = {"this"}, s = {"L$0"})
final class FeedPerformanceMonitor$observeOverlayAnimation$2$2$emit$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ b this$0;

    public FeedPerformanceMonitor$observeOverlayAnimation$2$2$emit$1(b r5, Continuation<? super FeedPerformanceMonitor$observeOverlayAnimation$2$2$emit$1> r10) {
        this.this$0 = r5;
        super(r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r5) {
        this.result = r5;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.b(false, this);
    }
}
