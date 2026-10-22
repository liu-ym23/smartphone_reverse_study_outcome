package com.obric.aikernel.phx.sdk.api;

import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(c = "com.obric.aikernel.phx.sdk.api.AIKernelApi", f = "AIKernelApi.kt", i = {}, l = {261}, m = "updatePackage-0E7RQCE", n = {}, s = {})
final class AIKernelApi$updatePackage$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AIKernelApi this$0;

    AIKernelApi$updatePackage$1(AIKernelApi r10, Continuation<? super AIKernelApi$updatePackage$1> r11) {
        this.this$0 = r10;
        super(r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        this.result = r10;
        this.label |= Integer.MIN_VALUE;
        Object r11 = this.this$0.mo24updatePackage0E7RQCE(null, null, this);
        if (r11 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r11;
    L6:
        return Result.m31boximpl(r11);
    }
}
