package com.obric.aikernel;

import com.bytedance.crash.tracker.ActivityLifecycle;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(c = "com.obric.aikernel.InferEntry$requestHandleImpl$1", f = "InferEntry.kt", i = {0, 0, 0}, l = {115}, m = "updatePackage", n = {ActivityLifecycle.NAME, "loraType", "params"}, s = {"L$0", "L$1", "L$2"})
final class InferEntry$requestHandleImpl$1$updatePackage$3 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ InferEntry$requestHandleImpl$1 this$0;

    InferEntry$requestHandleImpl$1$updatePackage$3(InferEntry$requestHandleImpl$1 r10, Continuation<? super InferEntry$requestHandleImpl$1$updatePackage$3> r11) {
        this.this$0 = r10;
        super(r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        this.result = r10;
        this.label |= Integer.MIN_VALUE;
        return InferEntry$requestHandleImpl$1.j(this.this$0, null, null, null, false, null, this);
    }
}
