package com.obric.aikernel.phx.compat;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(c = "com.obric.aikernel.phx.compat.ParamsCompat", f = "ParamsCompat.kt", i = {0}, l = {16}, m = "startCompat", n = {"$this$startCompat"}, s = {"L$0"})
final class ParamsCompat$startCompat$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ParamsCompat this$0;

    ParamsCompat$startCompat$1(ParamsCompat r10, Continuation<? super ParamsCompat$startCompat$1> r11) {
        this.this$0 = r10;
        super(r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        this.result = r10;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.f(null, this);
    }
}
