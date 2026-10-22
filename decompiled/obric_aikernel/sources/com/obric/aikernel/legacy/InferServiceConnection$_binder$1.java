package com.obric.aikernel.legacy;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.o;

/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(c = "com.obric.aikernel.legacy.InferServiceConnection$_binder$1", f = "InferServiceConnection.kt", i = {}, l = {77}, m = "invokeSuspend", n = {}, s = {})
final class InferServiceConnection$_binder$1 extends SuspendLambda implements Function2<l0, Continuation<? super com.obric.aikernel.a>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ InferServiceConnection this$0;

    InferServiceConnection$_binder$1(InferServiceConnection r10, Continuation<? super InferServiceConnection$_binder$1> r11) {
        this.this$0 = r10;
        super(2, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new InferServiceConnection$_binder$1(this.this$0, r11);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(l0 r10, Continuation<? super com.obric.aikernel.a> r11) {
        return invoke2(r10, r11);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(l0 r10, Continuation<? super com.obric.aikernel.a> r11) {
        return ((InferServiceConnection$_binder$1) create(r10, r11)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r12 = this.label;
        if (r12 == 0) goto L8;
        if (r12 != 1) goto L7;
        InferServiceConnection r13 = (InferServiceConnection) this.L$0;
        ResultKt.throwOnFailure(r10);
    L13:
        return r10;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        InferServiceConnection r14 = this.this$0;
        this.L$0 = r14;
        this.label = 1;
        o r15 = new o(IntrinsicsKt.intercepted(this), 1);
        r15.F();
        InferServiceConnection.c(r14).invoke(r15);
        r10 = r15.B();
        if (r10 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L11;
        DebugProbesKt.probeCoroutineSuspended(this);
    L11:
        if (r10 != r11) goto L13;
        return r11;
    }
}
