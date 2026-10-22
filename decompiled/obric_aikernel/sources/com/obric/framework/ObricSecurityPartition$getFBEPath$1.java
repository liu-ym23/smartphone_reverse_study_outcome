package com.obric.framework;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(c = "com.obric.framework.ObricSecurityPartition", f = "ObricSecurityPartition.kt", i = {0}, l = {60}, m = "getFBEPath", n = {"this"}, s = {"L$0"})
final class ObricSecurityPartition$getFBEPath$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ObricSecurityPartition this$0;

    ObricSecurityPartition$getFBEPath$1(ObricSecurityPartition r10, Continuation<? super ObricSecurityPartition$getFBEPath$1> r11) {
        this.this$0 = r10;
        super(r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        this.result = r10;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.d(this);
    }
}
