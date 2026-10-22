package com.obric.aikernel.obric_os_feature.impl;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.l0;

/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(c = "com.obric.aikernel.obric_os_feature.impl.ModelPowerPerfManagerImpl$powerLevelObserver$1$onChange$1", f = "ModelPowerPerfManagerImpl.kt", i = {}, l = {98}, m = "invokeSuspend", n = {}, s = {})
final class ModelPowerPerfManagerImpl$powerLevelObserver$1$onChange$1 extends SuspendLambda implements Function2<l0, Continuation<? super Unit>, Object> {
    int label;

    ModelPowerPerfManagerImpl$powerLevelObserver$1$onChange$1(Continuation<? super ModelPowerPerfManagerImpl$powerLevelObserver$1$onChange$1> r10) {
        super(2, r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new ModelPowerPerfManagerImpl$powerLevelObserver$1$onChange$1(r11);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(l0 r10, Continuation<? super Unit> r11) {
        return invoke2(r10, r11);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(l0 r10, Continuation<? super Unit> r11) {
        return ((ModelPowerPerfManagerImpl$powerLevelObserver$1$onChange$1) create(r10, r11)).invokeSuspend(Unit.INSTANCE);
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
        ModelPowerPerfManagerImpl r13 = ModelPowerPerfManagerImpl.INSTANCE;
        this.label = 1;
        if (r13.queryAndClearStats(this) != r11) goto L12;
        return r11;
    }
}
