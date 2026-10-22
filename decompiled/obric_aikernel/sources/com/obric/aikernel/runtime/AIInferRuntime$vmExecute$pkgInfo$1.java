package com.obric.aikernel.runtime;

import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(c = "com.obric.aikernel.runtime.AIInferRuntime$vmExecute$pkgInfo$1", f = "AIInferRuntime.kt", i = {}, l = {249}, m = "invokeSuspend", n = {}, s = {})
final class AIInferRuntime$vmExecute$pkgInfo$1 extends SuspendLambda implements Function1<Continuation<? super Pair<? extends Integer, ? extends y6.b>>, Object> {
    final /* synthetic */ AIInferRuntime.PackageWrapper $pkgWrapper;
    int label;

    AIInferRuntime$vmExecute$pkgInfo$1(AIInferRuntime.PackageWrapper r10, Continuation<? super AIInferRuntime$vmExecute$pkgInfo$1> r11) {
        this.$pkgWrapper = r10;
        super(1, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> r10) {
        return new AIInferRuntime$vmExecute$pkgInfo$1(this.$pkgWrapper, r10);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Continuation<? super Pair<? extends Integer, ? extends y6.b>> r10) {
        return invoke2(r10);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(Continuation<? super Pair<Integer, y6.b>> r10) {
        return ((AIInferRuntime$vmExecute$pkgInfo$1) create(r10)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r12 = this.label;
        if (r12 == 0) goto L8;
        if (r12 != 1) goto L7;
        ResultKt.throwOnFailure(r10);
    L16:
        return (Pair) r10;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        AIInferRuntime.PackageWrapper r13 = this.$pkgWrapper;
        if (r13 == null) goto L14;
        this.label = 1;
        r10 = r13.h(this);
        if (r10 != r11) goto L16;
        return r11;
    L14:
        return null;
    }
}
