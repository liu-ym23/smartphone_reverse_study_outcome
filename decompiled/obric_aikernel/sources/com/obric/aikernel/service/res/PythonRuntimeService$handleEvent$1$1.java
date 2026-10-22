package com.obric.aikernel.service.res;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.l0;

/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(c = "com.obric.aikernel.service.res.PythonRuntimeService$handleEvent$1$1", f = "PythonRuntimeService.kt", i = {}, l = {394}, m = "invokeSuspend", n = {}, s = {})
final class PythonRuntimeService$handleEvent$1$1 extends SuspendLambda implements Function2<l0, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $trigger;
    int label;
    final /* synthetic */ PythonRuntimeService this$0;

    PythonRuntimeService$handleEvent$1$1(PythonRuntimeService r10, String r11, Continuation<? super PythonRuntimeService$handleEvent$1$1> r12) {
        this.this$0 = r10;
        this.$trigger = r11;
        super(2, r12);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new PythonRuntimeService$handleEvent$1$1(this.this$0, this.$trigger, r11);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(l0 r10, Continuation<? super Unit> r11) {
        return invoke2(r10, r11);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(l0 r10, Continuation<? super Unit> r11) {
        return ((PythonRuntimeService$handleEvent$1$1) create(r10, r11)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r12 = this.label;
        if (r12 == 0) goto L8;
        if (r12 != 1) goto L7;
        ResultKt.throwOnFailure(r10);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        PythonRuntimeService r13 = this.this$0;
        String r14 = this.$trigger;
        this.label = 1;
        if (PythonRuntimeService.q(r13, r14, this) != r11) goto L12;
        return r11;
    }
}
