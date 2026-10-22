package com.larus.dora.impl.network;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.network.DoraNetworkApi", f = "DoraNetworkApi.kt", i = {}, l = {1105}, m = "uploadImuRealTimeData-bMdYcbs", n = {}, s = {})
public final class DoraNetworkApi$uploadImuRealTimeData$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DoraNetworkApi this$0;

    public DoraNetworkApi$uploadImuRealTimeData$1(DoraNetworkApi r1, Continuation<? super DoraNetworkApi$uploadImuRealTimeData$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r11) {
        this.result = r11;
        this.label |= Integer.MIN_VALUE;
        Object r12 = this.this$0.L(null, null, null, null, 0, 0, this);
        if (r12 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r12;
    L6:
        return Result.box-impl(r12);
    }
}
