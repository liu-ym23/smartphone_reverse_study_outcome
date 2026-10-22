package com.obric.aikernel.phx.core.api;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(c = "com.obric.aikernel.phx.core.api.ScriptBizApi", f = "ScriptBizApi.kt", i = {0, 0, 1, 1, 1, 2}, l = {49, 52, 52}, m = "inferenceTo", n = {"this", "params", "this", "params", "lifecycleHandle", "lifecycleHandle"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$0"})
final class ScriptBizApi$inferenceTo$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ScriptBizApi this$0;

    ScriptBizApi$inferenceTo$1(ScriptBizApi r10, Continuation<? super ScriptBizApi$inferenceTo$1> r11) {
        this.this$0 = r10;
        super(r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        this.result = r10;
        this.label |= Integer.MIN_VALUE;
        return ScriptBizApi.r(this.this$0, null, this);
    }
}
