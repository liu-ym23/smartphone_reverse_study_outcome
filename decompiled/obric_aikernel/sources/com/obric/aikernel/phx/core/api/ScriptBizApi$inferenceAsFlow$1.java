package com.obric.aikernel.phx.core.api;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(c = "com.obric.aikernel.phx.core.api.ScriptBizApi", f = "ScriptBizApi.kt", i = {0, 0}, l = {62}, m = "inferenceAsFlow", n = {"this", "params"}, s = {"L$0", "L$1"})
final class ScriptBizApi$inferenceAsFlow$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ScriptBizApi this$0;

    ScriptBizApi$inferenceAsFlow$1(ScriptBizApi r10, Continuation<? super ScriptBizApi$inferenceAsFlow$1> r11) {
        this.this$0 = r10;
        super(r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        this.result = r10;
        this.label |= Integer.MIN_VALUE;
        return ScriptBizApi.p(this.this$0, null, this);
    }
}
