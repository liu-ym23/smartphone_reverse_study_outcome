package com.obric.aikernel.phx.sdk.api;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(c = "com.obric.aikernel.phx.sdk.api.AIKernelApi$Companion", f = "AIKernelApi.kt", i = {0, 0, 0, 0, 1, 1, 1, 1}, l = {557, 598}, m = "loadPackage$sdk_release", n = {"binder", "biz", "ctx", "monitorTask", "binder", "ctx", "monitorTask", "args"}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3"})
final class AIKernelApi$Companion$loadPackage$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AIKernelApi.Companion this$0;

    AIKernelApi$Companion$loadPackage$1(AIKernelApi.Companion r10, Continuation<? super AIKernelApi$Companion$loadPackage$1> r11) {
        this.this$0 = r10;
        super(r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        this.result = r10;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.b(null, null, null, this);
    }
}
