package com.larus.dora.impl;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.DoraObricServiceImpl", f = "DoraObricServiceImpl.kt", i = {0}, l = {28, 31, 34}, m = "checkBindAndConnectIfNecessary", n = {"device"}, s = {"L$0"})
public final class DoraObricServiceImpl$checkBindAndConnectIfNecessary$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DoraObricServiceImpl this$0;

    public DoraObricServiceImpl$checkBindAndConnectIfNecessary$1(DoraObricServiceImpl r1, Continuation<? super DoraObricServiceImpl$checkBindAndConnectIfNecessary$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(null, this);
    }
}
