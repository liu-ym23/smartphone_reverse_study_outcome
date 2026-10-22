package com.obric.aikernel.api.impl.security;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(c = "com.obric.aikernel.api.impl.security.CertProvisionImpl", f = "CertProvisionImpl.kt", i = {0}, l = {215}, m = "ensureConnected", n = {"this"}, s = {"L$0"})
final class CertProvisionImpl$ensureConnected$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CertProvisionImpl this$0;

    CertProvisionImpl$ensureConnected$1(CertProvisionImpl r10, Continuation<? super CertProvisionImpl$ensureConnected$1> r11) {
        this.this$0 = r10;
        super(r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        this.result = r10;
        this.label |= Integer.MIN_VALUE;
        return CertProvisionImpl.g(this.this$0, this);
    }
}
