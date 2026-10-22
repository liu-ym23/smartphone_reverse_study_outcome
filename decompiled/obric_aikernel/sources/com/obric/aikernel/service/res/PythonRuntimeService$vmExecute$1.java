package com.obric.aikernel.service.res;

import androidx.core.app.NotificationCompat;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(c = "com.obric.aikernel.service.res.PythonRuntimeService", f = "PythonRuntimeService.kt", i = {0, 0, 0, 0}, l = {472, 472}, m = "vmExecute", n = {"biz", "params", NotificationCompat.CATEGORY_EVENT, "callback"}, s = {"L$0", "L$1", "L$2", "L$3"})
final class PythonRuntimeService$vmExecute$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PythonRuntimeService this$0;

    PythonRuntimeService$vmExecute$1(PythonRuntimeService r10, Continuation<? super PythonRuntimeService$vmExecute$1> r11) {
        this.this$0 = r10;
        super(r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        this.result = r10;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.U(null, null, null, null, this);
    }
}
