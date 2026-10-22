package com.larus.collection.impl;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.collection.impl.CollectImpl", f = "CollectImpl.kt", i = {}, l = {75}, m = "collectMessage", n = {}, s = {})
public final class CollectImpl$collectMessage$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CollectImpl this$0;

    public CollectImpl$collectMessage$1(CollectImpl r1, Continuation<? super CollectImpl$collectMessage$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r3) {
        this.result = r3;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.f(0, null, this);
    }
}
