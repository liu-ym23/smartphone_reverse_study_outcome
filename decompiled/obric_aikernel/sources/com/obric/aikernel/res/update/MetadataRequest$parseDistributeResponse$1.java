package com.obric.aikernel.res.update;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(c = "com.obric.aikernel.res.update.MetadataRequest", f = "MetadataRequest.kt", i = {0, 1}, l = {119, 149}, m = "parseDistributeResponse", n = {"this", "dists"}, s = {"L$0", "L$0"})
final class MetadataRequest$parseDistributeResponse$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MetadataRequest this$0;

    MetadataRequest$parseDistributeResponse$1(MetadataRequest r10, Continuation<? super MetadataRequest$parseDistributeResponse$1> r11) {
        this.this$0 = r10;
        super(r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        this.result = r10;
        this.label |= Integer.MIN_VALUE;
        return MetadataRequest.e(this.this$0, null, this);
    }
}
