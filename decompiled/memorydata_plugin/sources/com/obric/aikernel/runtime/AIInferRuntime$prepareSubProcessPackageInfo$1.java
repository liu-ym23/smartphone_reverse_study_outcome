package com.obric.aikernel.runtime;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.obric.aikernel.runtime.AIInferRuntime", f = "AIInferRuntime.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5, 6, 6, 6, 6, 6, 7, 7, 7, 7, 8, 8, 8, 8, 9}, l = {773, 777, 779, 780, 782, 783, 784, 790, 790, 797}, m = "prepareSubProcessPackageInfo", n = {"this", "proc", "throwGetPackageFailure", "initParams$delegate", "this", "proc", "throwGetPackageFailure", "initParams$delegate", "lastProxy", "this", "proc", "throwGetPackageFailure", "initParams$delegate", "this", "proc", "throwGetPackageFailure", "initParams$delegate", "lastProxy", "this", "proc", "throwGetPackageFailure", "initParams$delegate", "this", "proc", "throwGetPackageFailure", "initParams$delegate", "this", "proc", "throwGetPackageFailure", "initParams$delegate", "lastProxy", "this", "proc", "lastProxy", "final", "this", "proc", "lastProxy", "final", "final"}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$0"})
final class AIInferRuntime$prepareSubProcessPackageInfo$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AIInferRuntime this$0;

    AIInferRuntime$prepareSubProcessPackageInfo$1(AIInferRuntime r3, Continuation<? super AIInferRuntime$prepareSubProcessPackageInfo$1> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        this.this$0 = r3;
        super(r5);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r7) {
        this.result = r7;
        this.label |= Integer.MIN_VALUE;
        return AIInferRuntime.a(this.this$0, null, null, null, false, (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin"));
    }
}
