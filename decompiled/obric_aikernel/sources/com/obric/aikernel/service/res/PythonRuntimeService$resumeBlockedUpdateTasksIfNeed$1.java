package com.obric.aikernel.service.res;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(c = "com.obric.aikernel.service.res.PythonRuntimeService", f = "PythonRuntimeService.kt", i = {0, 1}, l = {492, 492}, m = "resumeBlockedUpdateTasksIfNeed", n = {"trigger", "trigger"}, s = {"L$0", "L$0"})
final class PythonRuntimeService$resumeBlockedUpdateTasksIfNeed$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PythonRuntimeService this$0;

    PythonRuntimeService$resumeBlockedUpdateTasksIfNeed$1(PythonRuntimeService r10, Continuation<? super PythonRuntimeService$resumeBlockedUpdateTasksIfNeed$1> r11) {
        this.this$0 = r10;
        super(r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        this.result = r10;
        this.label |= Integer.MIN_VALUE;
        return PythonRuntimeService.q(this.this$0, null, this);
    }
}
