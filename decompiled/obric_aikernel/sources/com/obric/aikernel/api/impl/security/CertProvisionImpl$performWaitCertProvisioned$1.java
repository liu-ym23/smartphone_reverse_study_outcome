package com.obric.aikernel.api.impl.security;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(c = "com.obric.aikernel.api.impl.security.CertProvisionImpl", f = "CertProvisionImpl.kt", i = {0, 0, 0}, l = {98}, m = "performWaitCertProvisioned", n = {"this", "caller", "invocationId"}, s = {"L$0", "L$1", "J$0"})
final class CertProvisionImpl$performWaitCertProvisioned$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CertProvisionImpl this$0;

    CertProvisionImpl$performWaitCertProvisioned$1(CertProvisionImpl r10, Continuation<? super CertProvisionImpl$performWaitCertProvisioned$1> r11) {
        this.this$0 = r10;
        super(r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        this.result = r10;
        this.label |= Integer.MIN_VALUE;
        return CertProvisionImpl.h(this.this$0, this);
    }
}
