package com.obric.aikernel.runtime;

import com.bytedance.common.wschannel.WsConstants;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(c = "com.obric.aikernel.runtime.AIInferRuntime", f = "AIInferRuntime.kt", i = {0, 0, 0, 0, 0}, l = {1332}, m = "buildPackageInfo", n = {"this", "$this$buildPackageInfo", "destination$iv$iv", "subRes", WsConstants.KEY_EXTRA}, s = {"L$0", "L$1", "L$2", "L$4", "L$5"})
final class AIInferRuntime$buildPackageInfo$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AIInferRuntime this$0;

    AIInferRuntime$buildPackageInfo$1(AIInferRuntime r10, Continuation<? super AIInferRuntime$buildPackageInfo$1> r11) {
        this.this$0 = r10;
        super(r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        this.result = r10;
        this.label |= Integer.MIN_VALUE;
        return AIInferRuntime.d(this.this$0, null, this);
    }
}
