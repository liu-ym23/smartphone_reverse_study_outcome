package com.obric.aikernel.phx.core.api;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(c = "com.obric.aikernel.phx.core.api.AbsApi", f = "AbsApi.kt", i = {0, 0, 0, 0, 0}, l = {122}, m = "callModelAsResponse", n = {"binder", "args", "block", "ctx", "monitorTask"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4"})
final class AbsApi$callModelAsResponse$1<T> extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AbsApi this$0;

    AbsApi$callModelAsResponse$1(AbsApi r10, Continuation<? super AbsApi$callModelAsResponse$1> r11) {
        this.this$0 = r10;
        super(r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        this.result = r10;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.f(null, null, null, this);
    }
}
