package com.obric.aikernel.service.res;

import com.bytedance.crash.tracker.ActivityLifecycle;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(c = "com.obric.aikernel.service.res.PythonRuntimeService", f = "PythonRuntimeService.kt", i = {0, 0, 0, 0}, l = {463, 463}, m = "updatePackage", n = {ActivityLifecycle.NAME, "caller", "loraType", "force"}, s = {"L$0", "L$1", "L$2", "Z$0"})
final class PythonRuntimeService$updatePackage$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PythonRuntimeService this$0;

    PythonRuntimeService$updatePackage$1(PythonRuntimeService r10, Continuation<? super PythonRuntimeService$updatePackage$1> r11) {
        this.this$0 = r10;
        super(r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        this.result = r10;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.R(null, null, false, null, this);
    }
}
