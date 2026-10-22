package com.obric.aikernel.phx.compat;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(c = "com.obric.aikernel.phx.compat.ParamsCompat", f = "ParamsCompat.kt", i = {}, l = {25}, m = "onStartCompat", n = {}, s = {})
final class ParamsCompat$onStartCompat$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ParamsCompat this$0;

    ParamsCompat$onStartCompat$1(ParamsCompat r10, Continuation<? super ParamsCompat$onStartCompat$1> r11) {
        this.this$0 = r10;
        super(r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        this.result = r10;
        this.label |= Integer.MIN_VALUE;
        return ParamsCompat.b(this.this$0, null, this);
    }
}
