package com.obric.aikernel.phx.sdk.api;

import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(c = "com.obric.aikernel.phx.sdk.api.AIKernelApi$Companion", f = "AIKernelApi.kt", i = {0, 0, 0, 0, 1, 1, 1, 1}, l = {522, 601}, m = "updatePackages-BWLJW6A", n = {"binder", "bizs", "ctx", "monitorTask", "binder", "ctx", "monitorTask", "args"}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3"})
final class AIKernelApi$Companion$updatePackages$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AIKernelApi.Companion this$0;

    AIKernelApi$Companion$updatePackages$1(AIKernelApi.Companion r10, Continuation<? super AIKernelApi$Companion$updatePackages$1> r11) {
        this.this$0 = r10;
        super(r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        this.result = r10;
        this.label |= Integer.MIN_VALUE;
        Object r11 = this.this$0.c(null, null, null, this);
        if (r11 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r11;
    L6:
        return Result.m31boximpl(r11);
    }
}
