package com.obric.aikernel.model.cloud.common;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(c = "com.obric.aikernel.model.cloud.common.CloudModelRequest", f = "CloudModelRequest.kt", i = {0, 0}, l = {37}, m = "safeRun", n = {"this", "ret"}, s = {"L$0", "L$1"})
final class CloudModelRequest$safeRun$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CloudModelRequest this$0;

    CloudModelRequest$safeRun$1(CloudModelRequest r10, Continuation<? super CloudModelRequest$safeRun$1> r11) {
        this.this$0 = r10;
        super(r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        this.result = r10;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.f(this);
    }
}
