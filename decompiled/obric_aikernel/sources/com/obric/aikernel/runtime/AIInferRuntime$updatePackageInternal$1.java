package com.obric.aikernel.runtime;

import com.bytedance.crash.tracker.ActivityLifecycle;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(c = "com.obric.aikernel.runtime.AIInferRuntime", f = "AIInferRuntime.kt", i = {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 2, 2, 2}, l = {489, 490, 495, 498}, m = "updatePackageInternal", n = {"this", ActivityLifecycle.NAME, "caller", "loraType", "it", "force", "background", "this", ActivityLifecycle.NAME, "caller", "loraType", "force", "background", "this", ActivityLifecycle.NAME, "loraType"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "Z$0", "Z$1", "L$0", "L$1", "L$2", "L$3", "Z$0", "Z$1", "L$0", "L$1", "L$2"})
final class AIInferRuntime$updatePackageInternal$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    boolean Z$0;
    boolean Z$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AIInferRuntime this$0;

    AIInferRuntime$updatePackageInternal$1(AIInferRuntime r10, Continuation<? super AIInferRuntime$updatePackageInternal$1> r11) {
        this.this$0 = r10;
        super(r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        this.result = r10;
        this.label |= Integer.MIN_VALUE;
        return AIInferRuntime.D(this.this$0, null, null, false, null, false, this);
    }
}
