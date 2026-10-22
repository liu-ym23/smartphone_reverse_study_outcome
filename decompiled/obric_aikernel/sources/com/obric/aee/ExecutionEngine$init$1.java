package com.obric.aee;

import com.bytedance.apm6.util.constant.CommonConsts;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(c = "com.obric.aee.ExecutionEngine", f = "ExecutionEngine.kt", i = {0, 0, 0}, l = {93}, m = CommonConsts.APM_INNER_EVENT_COST_INIT, n = {"this", "cfg", "myHome"}, s = {"L$0", "L$1", "L$2"})
final class ExecutionEngine$init$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ExecutionEngine this$0;

    ExecutionEngine$init$1(ExecutionEngine r10, Continuation<? super ExecutionEngine$init$1> r11) {
        this.this$0 = r10;
        super(r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        this.result = r10;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.d(null, this);
    }
}
