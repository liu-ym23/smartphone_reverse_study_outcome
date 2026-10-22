package com.obric.aikernel.runtime;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(c = "com.obric.aikernel.runtime.AIInferRuntime$PackageWrapper", f = "AIInferRuntime.kt", i = {0}, l = {1471}, m = "getVmPackageInfo", n = {"this"}, s = {"L$0"})
final class AIInferRuntime$PackageWrapper$getVmPackageInfo$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AIInferRuntime.PackageWrapper this$0;

    AIInferRuntime$PackageWrapper$getVmPackageInfo$1(AIInferRuntime.PackageWrapper r10, Continuation<? super AIInferRuntime$PackageWrapper$getVmPackageInfo$1> r11) {
        this.this$0 = r10;
        super(r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        this.result = r10;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.h(this);
    }
}
