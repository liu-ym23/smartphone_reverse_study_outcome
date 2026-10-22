package com.obric.miniapp.intent;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.miniapp.intent.LatestConversationSentMessageResolver", f = "LatestConversationSentMessageResolver.kt", i = {0, 0, 0, 0, 0}, l = {34}, m = "isReplyToLatest", n = {"conversationId", "replyId", "currentUserIds", "loadPage", "maxIndex"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4"})
public final class LatestConversationSentMessageResolver$isReplyToLatest$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ LatestConversationSentMessageResolver this$0;

    public LatestConversationSentMessageResolver$isReplyToLatest$1(LatestConversationSentMessageResolver r1, Continuation<? super LatestConversationSentMessageResolver$isReplyToLatest$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r7) {
        this.result = r7;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(null, null, null, null, this);
    }
}
