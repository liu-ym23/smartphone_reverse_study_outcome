package com.obric.aikernel.runtime;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(c = "com.obric.aikernel.runtime.AIInferRuntime", f = "AIInferRuntime.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5, 6, 6, 6, 6, 6, 7, 7, 7, 7, 8, 8, 8, 8, 9}, l = {747, 751, 753, 754, 756, 757, 758, 764, 764, 771}, m = "prepareSubProcessPackageInfo", n = {"this", "proc", "throwGetPackageFailure", "initParams$delegate", "this", "proc", "throwGetPackageFailure", "initParams$delegate", "lastProxy", "this", "proc", "throwGetPackageFailure", "initParams$delegate", "this", "proc", "throwGetPackageFailure", "initParams$delegate", "lastProxy", "this", "proc", "throwGetPackageFailure", "initParams$delegate", "this", "proc", "throwGetPackageFailure", "initParams$delegate", "this", "proc", "throwGetPackageFailure", "initParams$delegate", "lastProxy", "this", "proc", "lastProxy", "final", "this", "proc", "lastProxy", "final", "final"}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$0"})
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

    AIInferRuntime$prepareSubProcessPackageInfo$1(AIInferRuntime r10, Continuation<? super AIInferRuntime$prepareSubProcessPackageInfo$1> r11) {
        this.this$0 = r10;
        super(r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        this.result = r10;
        this.label |= Integer.MIN_VALUE;
        return AIInferRuntime.w(this.this$0, null, null, null, false, this);
    }
}
