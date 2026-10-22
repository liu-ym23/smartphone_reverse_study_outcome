package com.obric.aikernel.res.update;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(c = "com.obric.aikernel.res.update.MetadataRequest", f = "MetadataRequest.kt", i = {0, 0, 0, 0, 1, 1, 1, 2}, l = {92, 93, 97, 115}, m = "requestInner", n = {"this", "bizMap", "adapter", "updateAll", "this", "adapter", "url", "this"}, s = {"L$0", "L$1", "L$2", "Z$0", "L$0", "L$1", "L$2", "L$0"})
final class MetadataRequest$requestInner$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MetadataRequest this$0;

    MetadataRequest$requestInner$1(MetadataRequest r10, Continuation<? super MetadataRequest$requestInner$1> r11) {
        this.this$0 = r10;
        super(r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        this.result = r10;
        this.label |= Integer.MIN_VALUE;
        return MetadataRequest.g(this.this$0, false, null, null, this);
    }
}
