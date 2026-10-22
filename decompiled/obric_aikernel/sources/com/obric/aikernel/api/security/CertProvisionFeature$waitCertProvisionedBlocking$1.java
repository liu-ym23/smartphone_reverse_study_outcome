package com.obric.aikernel.api.security;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.l0;

/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(c = "com.obric.aikernel.api.security.CertProvisionFeature$waitCertProvisionedBlocking$1", f = "CertProvisionFeature.kt", i = {}, l = {10}, m = "invokeSuspend", n = {}, s = {})
final class CertProvisionFeature$waitCertProvisionedBlocking$1 extends SuspendLambda implements Function2<l0, Continuation<? super Boolean>, Object> {
    int label;
    final /* synthetic */ CertProvisionFeature this$0;

    CertProvisionFeature$waitCertProvisionedBlocking$1(CertProvisionFeature r10, Continuation<? super CertProvisionFeature$waitCertProvisionedBlocking$1> r11) {
        this.this$0 = r10;
        super(2, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new CertProvisionFeature$waitCertProvisionedBlocking$1(this.this$0, r11);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(l0 r10, Continuation<? super Boolean> r11) {
        return invoke2(r10, r11);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(l0 r10, Continuation<? super Boolean> r11) {
        return ((CertProvisionFeature$waitCertProvisionedBlocking$1) create(r10, r11)).invokeSuspend(Unit.INSTANCE);
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
        CertProvisionFeature r13 = this.this$0;
        this.label = 1;
        r10 = r13.c(this);
        if (r10 != r11) goto L11;
        return r11;
    }
}
