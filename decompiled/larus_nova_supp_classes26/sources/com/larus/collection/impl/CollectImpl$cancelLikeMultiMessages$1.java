package com.larus.collection.impl;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.collection.impl.CollectImpl", f = "CollectImpl.kt", i = {0, 0, 0, 1, 1}, l = {126, 130}, m = "cancelLikeMultiMessages", n = {"allSuccess", "message", "conversationId", "allSuccess", "message"}, s = {"L$0", "L$2", "L$3", "L$0", "L$2"})
public final class CollectImpl$cancelLikeMultiMessages$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CollectImpl this$0;

    public CollectImpl$cancelLikeMultiMessages$1(CollectImpl r1, Continuation<? super CollectImpl$cancelLikeMultiMessages$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.i(null, this);
    }
}
