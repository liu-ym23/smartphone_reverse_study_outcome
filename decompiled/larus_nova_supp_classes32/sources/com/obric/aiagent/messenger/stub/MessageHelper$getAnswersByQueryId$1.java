package com.obric.aiagent.messenger.stub;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.aiagent.messenger.stub.MessageHelper", f = "MessageHelper.kt", i = {0, 0}, l = {143}, m = "getAnswersByQueryId", n = {"conversationId", "queryId"}, s = {"L$0", "L$1"})
public final class MessageHelper$getAnswersByQueryId$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MessageHelper this$0;

    public MessageHelper$getAnswersByQueryId$1(MessageHelper r1, Continuation<? super MessageHelper$getAnswersByQueryId$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.b(null, null, this);
    }
}
