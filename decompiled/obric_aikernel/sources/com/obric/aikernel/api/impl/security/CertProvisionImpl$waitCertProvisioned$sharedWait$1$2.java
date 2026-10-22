package com.obric.aikernel.api.impl.security;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.l0;

/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(c = "com.obric.aikernel.api.impl.security.CertProvisionImpl$waitCertProvisioned$sharedWait$1$2", f = "CertProvisionImpl.kt", i = {}, l = {71}, m = "invokeSuspend", n = {}, s = {})
final class CertProvisionImpl$waitCertProvisioned$sharedWait$1$2 extends SuspendLambda implements Function2<l0, Continuation<? super Boolean>, Object> {
    int label;
    final /* synthetic */ CertProvisionImpl this$0;

    CertProvisionImpl$waitCertProvisioned$sharedWait$1$2(CertProvisionImpl r10, Continuation<? super CertProvisionImpl$waitCertProvisioned$sharedWait$1$2> r11) {
        this.this$0 = r10;
        super(2, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new CertProvisionImpl$waitCertProvisioned$sharedWait$1$2(this.this$0, r11);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(l0 r10, Continuation<? super Boolean> r11) {
        return invoke2(r10, r11);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(l0 r10, Continuation<? super Boolean> r11) {
        return ((CertProvisionImpl$waitCertProvisioned$sharedWait$1$2) create(r10, r11)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r12 = this.label;
        if (r12 == 0) goto L8;
        if (r12 != 1) goto L7;
        ResultKt.throwOnFailure(r10);
    L11:
        return r10;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        CertProvisionImpl r13 = this.this$0;
        this.label = 1;
        r10 = CertProvisionImpl.h(r13, this);
        if (r10 != r11) goto L11;
        return r11;
    }
}
