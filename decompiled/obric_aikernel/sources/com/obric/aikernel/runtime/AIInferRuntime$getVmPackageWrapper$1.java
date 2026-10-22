package com.obric.aikernel.runtime;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.NotificationCompat;
import com.bytedance.crash.tracker.ActivityLifecycle;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(c = "com.obric.aikernel.runtime.AIInferRuntime", f = "AIInferRuntime.kt", i = {0, 0, 0, 0}, l = {TypedValues.Custom.TYPE_COLOR}, m = "getVmPackageWrapper", n = {ActivityLifecycle.NAME, "loraType", NotificationCompat.CATEGORY_EVENT, "$this$getVmPackageWrapper_u24lambda_u2450"}, s = {"L$0", "L$1", "L$2", "L$3"})
final class AIInferRuntime$getVmPackageWrapper$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AIInferRuntime this$0;

    AIInferRuntime$getVmPackageWrapper$1(AIInferRuntime r10, Continuation<? super AIInferRuntime$getVmPackageWrapper$1> r11) {
        this.this$0 = r10;
        super(r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        this.result = r10;
        this.label |= Integer.MIN_VALUE;
        return AIInferRuntime.u(this.this$0, null, null, null, this);
    }
}
