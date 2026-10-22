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
@DebugMetadata(c = "com.obric.aikernel.api.impl.security.CertProvisionImpl$conn$1$onServiceConnected$1", f = "CertProvisionImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class CertProvisionImpl$conn$1$onServiceConnected$1 extends SuspendLambda implements Function2<l0, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ CertProvisionImpl this$0;

    CertProvisionImpl$conn$1$onServiceConnected$1(CertProvisionImpl r10, Continuation<? super CertProvisionImpl$conn$1$onServiceConnected$1> r11) {
        this.this$0 = r10;
        super(2, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new CertProvisionImpl$conn$1$onServiceConnected$1(this.this$0, r11);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(l0 r10, Continuation<? super Unit> r11) {
        return invoke2(r10, r11);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(l0 r10, Continuation<? super Unit> r11) {
        return ((CertProvisionImpl$conn$1$onServiceConnected$1) create(r10, r11)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L10;
        ResultKt.throwOnFailure(r10);
        CertProvisionImpl r11 = this.this$0;
        if (CertProvisionImpl.f(r11, CertProvisionImpl.n(r11, null, 1, null)) == true) goto L8;
        CertProvisionImpl.q(this.this$0, null, 1, null);
    L8:
        return Unit.INSTANCE;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
