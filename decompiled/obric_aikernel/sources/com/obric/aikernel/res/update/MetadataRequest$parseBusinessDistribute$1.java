package com.obric.aikernel.res.update;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(c = "com.obric.aikernel.res.update.MetadataRequest", f = "MetadataRequest.kt", i = {0}, l = {174}, m = "parseBusinessDistribute", n = {"dists"}, s = {"L$0"})
final class MetadataRequest$parseBusinessDistribute$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MetadataRequest this$0;

    MetadataRequest$parseBusinessDistribute$1(MetadataRequest r10, Continuation<? super MetadataRequest$parseBusinessDistribute$1> r11) {
        this.this$0 = r10;
        super(r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        this.result = r10;
        this.label |= Integer.MIN_VALUE;
        return MetadataRequest.d(this.this$0, null, this);
    }
}
