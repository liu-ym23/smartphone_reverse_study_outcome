package com.obric.aikernel.runtime;

import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.aikernel.sdk.ext.Params;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.obric.aikernel.runtime.AIInferRuntime", f = "AIInferRuntime.kt", i = {0, 0, 0, 0}, l = {928}, m = "getVmPackageWrapper", n = {ActivityLifecycle.NAME, Params.LORA_TYPE, "event", "$this$getVmPackageWrapper_u24lambda_u2450"}, s = {"L$0", "L$1", "L$2", "L$3"})
final class AIInferRuntime$getVmPackageWrapper$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AIInferRuntime this$0;

    AIInferRuntime$getVmPackageWrapper$1(AIInferRuntime r3, Continuation<? super AIInferRuntime$getVmPackageWrapper$1> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        this.this$0 = r3;
        super(r5);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r3) {
        this.result = r3;
        this.label |= Integer.MIN_VALUE;
        return AIInferRuntime.a(this.this$0, null, null, null, (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin"));
    }
}
