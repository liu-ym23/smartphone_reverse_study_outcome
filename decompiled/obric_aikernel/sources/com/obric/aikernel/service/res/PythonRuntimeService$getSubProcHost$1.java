package com.obric.aikernel.service.res;

import com.obric.aikernel.runtime.AIInferRuntime;
import com.obric.aikernel.runtime.subproc.SubProcHost;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.r0;

/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(c = "com.obric.aikernel.service.res.PythonRuntimeService$getSubProcHost$1", f = "PythonRuntimeService.kt", i = {}, l = {483}, m = "invokeSuspend", n = {}, s = {})
final class PythonRuntimeService$getSubProcHost$1 extends SuspendLambda implements Function2<l0, Continuation<? super SubProcHost>, Object> {
    int label;
    final /* synthetic */ PythonRuntimeService this$0;

    PythonRuntimeService$getSubProcHost$1(PythonRuntimeService r10, Continuation<? super PythonRuntimeService$getSubProcHost$1> r11) {
        this.this$0 = r10;
        super(2, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new PythonRuntimeService$getSubProcHost$1(this.this$0, r11);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(l0 r10, Continuation<? super SubProcHost> r11) {
        return invoke2(r10, r11);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(l0 r10, Continuation<? super SubProcHost> r11) {
        return ((PythonRuntimeService$getSubProcHost$1) create(r10, r11)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r12 = this.label;
        if (r12 == 0) goto L8;
        if (r12 != 1) goto L7;
        ResultKt.throwOnFailure(r10);
    L11:
        SubProcHost r13 = ((AIInferRuntime) r10).b0();
        Intrinsics.checkNotNull(r13);
        return r13;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        r0 r14 = PythonRuntimeService.j(this.this$0);
        this.label = 1;
        r10 = r14.r(this);
        if (r10 != r11) goto L11;
        return r11;
    }
}
