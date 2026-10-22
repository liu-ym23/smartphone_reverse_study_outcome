package com.larus.collection.impl;

import com.larus.bmhome.chat.tips.GuidePriority;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.collection.impl.CollectImpl", f = "CollectImpl.kt", i = {0}, l = {GuidePriority.DEEP_RESEARCH_PRIORITY}, m = "cancelCollect", n = {"collectionId"}, s = {"L$0"})
public final class CollectImpl$cancelCollect$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CollectImpl this$0;

    public CollectImpl$cancelCollect$1(CollectImpl r1, Continuation<? super CollectImpl$cancelCollect$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.e(null, this);
    }
}
