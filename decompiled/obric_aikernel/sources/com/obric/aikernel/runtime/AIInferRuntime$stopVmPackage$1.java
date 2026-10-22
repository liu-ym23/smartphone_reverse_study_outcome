package com.obric.aikernel.runtime;

import com.bytedance.crash.tracker.ActivityLifecycle;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(c = "com.obric.aikernel.runtime.AIInferRuntime", f = "AIInferRuntime.kt", i = {0, 0, 1, 1}, l = {545, 547}, m = "stopVmPackage", n = {"this", ActivityLifecycle.NAME, "this", ActivityLifecycle.NAME}, s = {"L$0", "L$1", "L$0", "L$1"})
final class AIInferRuntime$stopVmPackage$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AIInferRuntime this$0;

    AIInferRuntime$stopVmPackage$1(AIInferRuntime r10, Continuation<? super AIInferRuntime$stopVmPackage$1> r11) {
        this.this$0 = r10;
        super(r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        this.result = r10;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.w0(null, this);
    }
}
