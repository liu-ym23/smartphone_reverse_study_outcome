package com.obric.aikernel.phx.sdk.api;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.r0;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(c = "com.obric.aikernel.phx.sdk.api.AIKernelApi$wrapApiCall$3$1", f = "AIKernelApi.kt", i = {}, l = {430}, m = "invokeSuspend", n = {}, s = {})
final class AIKernelApi$wrapApiCall$3$1<T> extends SuspendLambda implements Function2<l0, Continuation<? super T>, Object> {
    final /* synthetic */ r0<T> $ipcJob;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    AIKernelApi$wrapApiCall$3$1(r0<? extends T> r10, Continuation<? super AIKernelApi$wrapApiCall$3$1> r11) {
        this.$ipcJob = r10;
        super(2, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new AIKernelApi$wrapApiCall$3$1(this.$ipcJob, r11);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(l0 r10, Object r11) {
        return invoke(r10, (Continuation) r11);
    }

    public final Object invoke(l0 r10, Continuation<? super T> r11) {
        return ((AIKernelApi$wrapApiCall$3$1) create(r10, r11)).invokeSuspend(Unit.INSTANCE);
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
        r0<T> r13 = this.$ipcJob;
        this.label = 1;
        r10 = r13.r(this);
        if (r10 != r11) goto L11;
        return r11;
    }
}
