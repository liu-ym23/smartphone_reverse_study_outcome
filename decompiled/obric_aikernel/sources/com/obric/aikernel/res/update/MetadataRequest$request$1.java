package com.obric.aikernel.res.update;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(c = "com.obric.aikernel.res.update.MetadataRequest", f = "MetadataRequest.kt", i = {}, l = {42}, m = "request", n = {}, s = {})
final class MetadataRequest$request$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MetadataRequest this$0;

    MetadataRequest$request$1(MetadataRequest r10, Continuation<? super MetadataRequest$request$1> r11) {
        this.this$0 = r10;
        super(r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        this.result = r10;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.r(false, null, null, this);
    }
}
