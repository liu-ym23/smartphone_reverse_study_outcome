package com.obric.aikernel.model.cloud.coze;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(c = "com.obric.aikernel.model.cloud.coze.CozeModelRequest", f = "CozeModelRequest.kt", i = {0, 0}, l = {38}, m = "run", n = {"this", "bizName"}, s = {"L$0", "L$1"})
final class CozeModelRequest$run$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CozeModelRequest this$0;

    CozeModelRequest$run$1(CozeModelRequest r10, Continuation<? super CozeModelRequest$run$1> r11) {
        this.this$0 = r10;
        super(r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        this.result = r10;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.e(this);
    }
}
