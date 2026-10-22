package com.obric.aikernel;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(c = "com.obric.aikernel.InferEntry", f = "InferEntry.kt", i = {0, 0, 0}, l = {271, 276}, m = "inferRequestImpl", n = {"this", "params", "callback"}, s = {"L$0", "L$1", "L$2"})
final class InferEntry$inferRequestImpl$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ InferEntry this$0;

    InferEntry$inferRequestImpl$1(InferEntry r10, Continuation<? super InferEntry$inferRequestImpl$1> r11) {
        this.this$0 = r10;
        super(r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        this.result = r10;
        this.label |= Integer.MIN_VALUE;
        return InferEntry.g(this.this$0, null, null, this);
    }
}
