package com.obric.aikernel.qnn;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(c = "com.obric.aikernel.qnn.QnnEnvInitHelper", f = "QnnEnvInitHelper.kt", i = {}, l = {88}, m = "waitInit", n = {}, s = {})
final class QnnEnvInitHelper$waitInit$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ QnnEnvInitHelper this$0;

    QnnEnvInitHelper$waitInit$1(QnnEnvInitHelper r10, Continuation<? super QnnEnvInitHelper$waitInit$1> r11) {
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
