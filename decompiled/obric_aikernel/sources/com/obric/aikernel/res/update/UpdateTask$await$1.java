package com.obric.aikernel.res.update;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(c = "com.obric.aikernel.res.update.UpdateTask", f = "UpdateTask.kt", i = {0}, l = {465}, m = "await", n = {"this"}, s = {"L$0"})
final class UpdateTask$await$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ UpdateTask this$0;

    UpdateTask$await$1(UpdateTask r10, Continuation<? super UpdateTask$await$1> r11) {
        this.this$0 = r10;
        super(r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        this.result = r10;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.o(this);
    }
}
