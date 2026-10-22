package com.obric.aikernel.runtime;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(c = "com.obric.aikernel.runtime.AIInferRuntime", f = "AIInferRuntime.kt", i = {0, 1, 1}, l = {857, 858, 879}, m = "preInitApp", n = {"this", "this", "wrapper"}, s = {"L$0", "L$0", "L$1"})
final class AIInferRuntime$preInitApp$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AIInferRuntime this$0;

    AIInferRuntime$preInitApp$1(AIInferRuntime r10, Continuation<? super AIInferRuntime$preInitApp$1> r11) {
        this.this$0 = r10;
        super(r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        this.result = r10;
        this.label |= Integer.MIN_VALUE;
        return AIInferRuntime.v(this.this$0, this);
    }
}
