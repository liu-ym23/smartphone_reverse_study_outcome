package com.obric.aikernel.service.res;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(c = "com.obric.aikernel.service.res.PythonRuntimeService", f = "PythonRuntimeService.kt", i = {}, l = {469, 469}, m = "getDownloadingSummary", n = {}, s = {})
final class PythonRuntimeService$getDownloadingSummary$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PythonRuntimeService this$0;

    PythonRuntimeService$getDownloadingSummary$1(PythonRuntimeService r10, Continuation<? super PythonRuntimeService$getDownloadingSummary$1> r11) {
        this.this$0 = r10;
        super(r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        this.result = r10;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.x(this);
    }
}
