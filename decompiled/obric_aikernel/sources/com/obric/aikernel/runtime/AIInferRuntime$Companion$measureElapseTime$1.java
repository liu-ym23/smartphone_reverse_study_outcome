package com.obric.aikernel.runtime;

import com.bytedance.apm6.util.constant.CommonConsts;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(c = "com.obric.aikernel.runtime.AIInferRuntime$Companion", f = "AIInferRuntime.kt", i = {0, 0}, l = {1817}, m = "measureElapseTime", n = {"accept", CommonConsts.APM_INNER_EVENT_COST_START}, s = {"L$0", "J$0"})
final class AIInferRuntime$Companion$measureElapseTime$1<T> extends ContinuationImpl {
    long J$0;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AIInferRuntime.Companion this$0;

    AIInferRuntime$Companion$measureElapseTime$1(AIInferRuntime.Companion r10, Continuation<? super AIInferRuntime$Companion$measureElapseTime$1> r11) {
        this.this$0 = r10;
        super(r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        this.result = r10;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.c(null, null, this);
    }
}
