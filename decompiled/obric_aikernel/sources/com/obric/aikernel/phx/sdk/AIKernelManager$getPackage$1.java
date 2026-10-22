package com.obric.aikernel.phx.sdk;

import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(c = "com.obric.aikernel.phx.sdk.AIKernelManager", f = "AIKernelManager.kt", i = {}, l = {50}, m = "getPackage-0E7RQCE", n = {}, s = {})
final class AIKernelManager$getPackage$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AIKernelManager this$0;

    AIKernelManager$getPackage$1(AIKernelManager r10, Continuation<? super AIKernelManager$getPackage$1> r11) {
        this.this$0 = r10;
        super(r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        this.result = r10;
        this.label |= Integer.MIN_VALUE;
        Object r11 = this.this$0.mo23getPackage0E7RQCE(null, null, this);
        if (r11 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r11;
    L6:
        return Result.m31boximpl(r11);
    }
}
