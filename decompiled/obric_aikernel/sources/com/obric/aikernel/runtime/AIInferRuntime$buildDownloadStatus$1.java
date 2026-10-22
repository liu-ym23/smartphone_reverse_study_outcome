package com.obric.aikernel.runtime;

import com.bytedance.crash.tracker.ActivityLifecycle;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(c = "com.obric.aikernel.runtime.AIInferRuntime", f = "AIInferRuntime.kt", i = {0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4}, l = {574, 581, 583, 586, 587}, m = "buildDownloadStatus", n = {"this", ActivityLifecycle.NAME, "loraType", "this", ActivityLifecycle.NAME, "loraType", "status", "this", ActivityLifecycle.NAME, "loraType", "status", "this", ActivityLifecycle.NAME, "loraType", "status", "pkg", "updateKey", "this", ActivityLifecycle.NAME, "loraType", "status", "pkg", "updateInfo"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5"})
final class AIInferRuntime$buildDownloadStatus$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AIInferRuntime this$0;

    AIInferRuntime$buildDownloadStatus$1(AIInferRuntime r10, Continuation<? super AIInferRuntime$buildDownloadStatus$1> r11) {
        this.this$0 = r10;
        super(r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        this.result = r10;
        this.label |= Integer.MIN_VALUE;
        return AIInferRuntime.c(this.this$0, null, null, this);
    }
}
