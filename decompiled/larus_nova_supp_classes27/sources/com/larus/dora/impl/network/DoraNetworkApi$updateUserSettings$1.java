package com.larus.dora.impl.network;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.network.DoraNetworkApi", f = "DoraNetworkApi.kt", i = {0}, l = {196}, m = "updateUserSettings-hUnOzRk", n = {"bodyJson"}, s = {"L$0"})
public final class DoraNetworkApi$updateUserSettings$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DoraNetworkApi this$0;

    public DoraNetworkApi$updateUserSettings$1(DoraNetworkApi r1, Continuation<? super DoraNetworkApi$updateUserSettings$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r8) {
        this.result = r8;
        this.label |= Integer.MIN_VALUE;
        Object r9 = this.this$0.H(null, null, null, null, null, this);
        if (r9 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r9;
    L6:
        return Result.box-impl(r9);
    }
}
