package com.obric.aikernel.runtime;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(c = "com.obric.aikernel.runtime.VmEngine", f = "VmEngine.kt", i = {0}, l = {53, 83}, m = "vmExecuteEntry", n = {"retryTask"}, s = {"L$0"})
final class VmEngine$vmExecuteEntry$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ VmEngine this$0;

    VmEngine$vmExecuteEntry$1(VmEngine r10, Continuation<? super VmEngine$vmExecuteEntry$1> r11) {
        this.this$0 = r10;
        super(r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        this.result = r10;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.m(null, null, null, null, null, this);
    }
}
