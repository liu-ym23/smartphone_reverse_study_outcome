package com.larus.dora.impl.serviceimpl;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.serviceimpl.NetworkService", f = "Network.kt", i = {}, l = {55}, m = "fetchDiaryBetaLatestCard-gIAlu-s", n = {}, s = {})
public final class NetworkService$fetchDiaryBetaLatestCard$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ NetworkService this$0;

    public NetworkService$fetchDiaryBetaLatestCard$1(NetworkService r1, Continuation<? super NetworkService$fetchDiaryBetaLatestCard$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        Object r3 = this.this$0.a(null, this);
        if (r3 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r3;
    L6:
        return Result.box-impl(r3);
    }
}
