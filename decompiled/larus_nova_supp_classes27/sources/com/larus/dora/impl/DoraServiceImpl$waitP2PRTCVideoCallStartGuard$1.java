package com.larus.dora.impl;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.DoraServiceImpl", f = "DoraServiceImpl.kt", i = {0}, l = {2290}, m = "waitP2PRTCVideoCallStartGuard", n = {"waitedMs"}, s = {"J$0"})
final class DoraServiceImpl$waitP2PRTCVideoCallStartGuard$1 extends ContinuationImpl {
    long J$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DoraServiceImpl this$0;

    public DoraServiceImpl$waitP2PRTCVideoCallStartGuard$1(DoraServiceImpl r1, Continuation<? super DoraServiceImpl$waitP2PRTCVideoCallStartGuard$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return DoraServiceImpl.r1(this.this$0, this);
    }
}
