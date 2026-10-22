package com.obric.aikernel.service.res;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(c = "com.obric.aikernel.service.res.FirstStartUpdatePolicy", f = "FirstStartUpdatePolicy.kt", i = {0}, l = {30, 32}, m = "doUpdate", n = {"$this$doUpdate_u24lambda_u240"}, s = {"L$0"})
final class FirstStartUpdatePolicy$doUpdate$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FirstStartUpdatePolicy this$0;

    FirstStartUpdatePolicy$doUpdate$1(FirstStartUpdatePolicy r10, Continuation<? super FirstStartUpdatePolicy$doUpdate$1> r11) {
        this.this$0 = r10;
        super(r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        this.result = r10;
        this.label |= Integer.MIN_VALUE;
        return FirstStartUpdatePolicy.a(this.this$0, this);
    }
}
