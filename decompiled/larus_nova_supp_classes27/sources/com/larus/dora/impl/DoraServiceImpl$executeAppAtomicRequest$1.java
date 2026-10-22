package com.larus.dora.impl;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.DoraServiceImpl", f = "DoraServiceImpl.kt", i = {0, 0, 0, 0, 1, 1, 1, 2, 2, 2}, l = {641, 653, 664}, m = "executeAppAtomicRequest", n = {"device", "id", "method", "enable", "id", "method", "enable", "id", "method", "enable"}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2"})
final class DoraServiceImpl$executeAppAtomicRequest$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DoraServiceImpl this$0;

    public DoraServiceImpl$executeAppAtomicRequest$1(DoraServiceImpl r1, Continuation<? super DoraServiceImpl$executeAppAtomicRequest$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return DoraServiceImpl.n1(this.this$0, null, null, this);
    }
}
