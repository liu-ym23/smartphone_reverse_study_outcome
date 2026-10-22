package com.larus.dora.impl;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.DoraObricServiceImpl", f = "DoraObricServiceImpl.kt", i = {}, l = {62}, m = "checkBindStatus-gIAlu-s", n = {}, s = {})
public final class DoraObricServiceImpl$checkBindStatus$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DoraObricServiceImpl this$0;

    public DoraObricServiceImpl$checkBindStatus$1(DoraObricServiceImpl r1, Continuation<? super DoraObricServiceImpl$checkBindStatus$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        DoraObricServiceImpl r3 = this.this$0;
        int r0 = DoraObricServiceImpl.a;
        Object r4 = r3.b(null, this);
        if (r4 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r4;
    L6:
        return Result.box-impl(r4);
    }
}
