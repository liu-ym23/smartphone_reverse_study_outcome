package com.obric.aikernel;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(c = "com.obric.aikernel.InferEntry$requestHandleImpl$1", f = "InferEntry.kt", i = {}, l = {127}, m = "preparePackage", n = {}, s = {})
final class InferEntry$requestHandleImpl$1$preparePackage$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ InferEntry$requestHandleImpl$1 this$0;

    InferEntry$requestHandleImpl$1$preparePackage$1(InferEntry$requestHandleImpl$1 r10, Continuation<? super InferEntry$requestHandleImpl$1$preparePackage$1> r11) {
        this.this$0 = r10;
        super(r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        this.result = r10;
        this.label |= Integer.MIN_VALUE;
        return InferEntry$requestHandleImpl$1.i(this.this$0, null, null, null, this);
    }
}
