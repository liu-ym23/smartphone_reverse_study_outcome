package com.larus.dora.impl.network;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.network.DoraNetworkApi", f = "DoraNetworkApi.kt", i = {0, 0}, l = {1192}, m = "atomicFuncCallback-yxL6bBk", n = {"productId", "wDid"}, s = {"L$0", "L$1"})
public final class DoraNetworkApi$atomicFuncCallback$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DoraNetworkApi this$0;

    public DoraNetworkApi$atomicFuncCallback$1(DoraNetworkApi r1, Continuation<? super DoraNetworkApi$atomicFuncCallback$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r7) {
        this.result = r7;
        this.label |= Integer.MIN_VALUE;
        Object r8 = this.this$0.c(null, null, null, null, this);
        if (r8 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r8;
    L6:
        return Result.box-impl(r8);
    }
}
