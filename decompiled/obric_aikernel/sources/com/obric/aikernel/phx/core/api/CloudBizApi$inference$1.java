package com.obric.aikernel.phx.core.api;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(c = "com.obric.aikernel.phx.core.api.CloudBizApi", f = "CloudBizApi.kt", i = {0, 0}, l = {33, 37}, m = "inference", n = {"this", "args"}, s = {"L$0", "L$1"})
final class CloudBizApi$inference$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CloudBizApi this$0;

    CloudBizApi$inference$1(CloudBizApi r10, Continuation<? super CloudBizApi$inference$1> r11) {
        this.this$0 = r10;
        super(r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        this.result = r10;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.l(null, this);
    }
}
