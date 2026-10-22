package com.larus.feedback.impl.service;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.feedback.impl.service.RecentFeedbackMessageCollector", f = "RecentFeedbackMessageCollector.kt", i = {0, 0, 1, 1, 1}, l = {35, 42}, m = "collect", n = {"startTime", "recentMessageStartTime", "conversations", "startTime", "recentMessageStartTime"}, s = {"J$0", "J$1", "L$0", "J$0", "J$1"})
public final class RecentFeedbackMessageCollector$collect$1 extends ContinuationImpl {
    long J$0;
    long J$1;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ RecentFeedbackMessageCollector this$0;

    public RecentFeedbackMessageCollector$collect$1(RecentFeedbackMessageCollector r1, Continuation<? super RecentFeedbackMessageCollector$collect$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(this);
    }
}
