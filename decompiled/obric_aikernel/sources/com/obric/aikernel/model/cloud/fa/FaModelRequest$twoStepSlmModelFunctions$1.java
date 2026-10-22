package com.obric.aikernel.model.cloud.fa;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(c = "com.obric.aikernel.model.cloud.fa.FaModelRequest", f = "FaModelRequest.kt", i = {0, 0, 0, 0, 0}, l = {120}, m = "twoStepSlmModelFunctions", n = {"this", "ret", "fileUploadResultTaskId", "taskInterval", "i"}, s = {"L$0", "L$1", "L$2", "I$0", "I$1"})
final class FaModelRequest$twoStepSlmModelFunctions$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    int I$2;
    int I$3;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FaModelRequest this$0;

    FaModelRequest$twoStepSlmModelFunctions$1(FaModelRequest r10, Continuation<? super FaModelRequest$twoStepSlmModelFunctions$1> r11) {
        this.this$0 = r10;
        super(r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        this.result = r10;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.g(null, this);
    }
}
