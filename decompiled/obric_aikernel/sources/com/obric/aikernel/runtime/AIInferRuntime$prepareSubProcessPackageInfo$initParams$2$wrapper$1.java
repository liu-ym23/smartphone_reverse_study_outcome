package com.obric.aikernel.runtime;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.l0;

/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(c = "com.obric.aikernel.runtime.AIInferRuntime$prepareSubProcessPackageInfo$initParams$2$wrapper$1", f = "AIInferRuntime.kt", i = {}, l = {714}, m = "invokeSuspend", n = {}, s = {})
final class AIInferRuntime$prepareSubProcessPackageInfo$initParams$2$wrapper$1 extends SuspendLambda implements Function2<l0, Continuation<? super AIInferRuntime.PackageWrapper>, Object> {
    final /* synthetic */ Function1<Continuation<? super AIInferRuntime.PackageWrapper>, Object> $getWrapper;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    AIInferRuntime$prepareSubProcessPackageInfo$initParams$2$wrapper$1(Function1<? super Continuation<? super AIInferRuntime.PackageWrapper>, ? extends Object> r10, Continuation<? super AIInferRuntime$prepareSubProcessPackageInfo$initParams$2$wrapper$1> r11) {
        this.$getWrapper = r10;
        super(2, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new AIInferRuntime$prepareSubProcessPackageInfo$initParams$2$wrapper$1(this.$getWrapper, r11);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(l0 r10, Continuation<? super AIInferRuntime.PackageWrapper> r11) {
        return invoke2(r10, r11);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(l0 r10, Continuation<? super AIInferRuntime.PackageWrapper> r11) {
        return ((AIInferRuntime$prepareSubProcessPackageInfo$initParams$2$wrapper$1) create(r10, r11)).invokeSuspend(Unit.INSTANCE);
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
        Function1<Continuation<? super AIInferRuntime.PackageWrapper>, Object> r13 = this.$getWrapper;
        this.label = 1;
        r10 = r13.invoke(this);
        if (r10 != r11) goto L11;
        return r11;
    }
}
