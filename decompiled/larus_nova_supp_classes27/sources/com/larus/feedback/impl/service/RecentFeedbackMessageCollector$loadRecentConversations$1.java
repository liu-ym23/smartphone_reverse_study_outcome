package com.larus.feedback.impl.service;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.feedback.impl.service.RecentFeedbackMessageCollector", f = "RecentFeedbackMessageCollector.kt", i = {}, l = {97}, m = "loadRecentConversations", n = {}, s = {})
public final class RecentFeedbackMessageCollector$loadRecentConversations$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ RecentFeedbackMessageCollector this$0;

    public RecentFeedbackMessageCollector$loadRecentConversations$1(RecentFeedbackMessageCollector r1, Continuation<? super RecentFeedbackMessageCollector$loadRecentConversations$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        RecentFeedbackMessageCollector r3 = this.this$0;
        RecentFeedbackMessageCollector r0 = RecentFeedbackMessageCollector.a;
        return r3.b(this);
    }
}
