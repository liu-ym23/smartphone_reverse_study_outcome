package com.obric.aikernel.runtime;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(c = "com.obric.aikernel.runtime.AIInferRuntime", f = "AIInferRuntime.kt", i = {}, l = {TypedValues.PositionType.TYPE_PERCENT_X}, m = "getPackageUpdateProgress", n = {}, s = {})
final class AIInferRuntime$getPackageUpdateProgress$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AIInferRuntime this$0;

    AIInferRuntime$getPackageUpdateProgress$1(AIInferRuntime r10, Continuation<? super AIInferRuntime$getPackageUpdateProgress$1> r11) {
        this.this$0 = r10;
        super(r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        this.result = r10;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.Z(null, this);
    }
}
