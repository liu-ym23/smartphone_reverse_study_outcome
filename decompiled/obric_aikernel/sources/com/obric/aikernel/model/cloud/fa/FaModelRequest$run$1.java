package com.obric.aikernel.model.cloud.fa;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(c = "com.obric.aikernel.model.cloud.fa.FaModelRequest", f = "FaModelRequest.kt", i = {0}, l = {40}, m = "run", n = {"this"}, s = {"L$0"})
final class FaModelRequest$run$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FaModelRequest this$0;

    FaModelRequest$run$1(FaModelRequest r10, Continuation<? super FaModelRequest$run$1> r11) {
        this.this$0 = r10;
        super(r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        this.result = r10;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.e(this);
    }
}
