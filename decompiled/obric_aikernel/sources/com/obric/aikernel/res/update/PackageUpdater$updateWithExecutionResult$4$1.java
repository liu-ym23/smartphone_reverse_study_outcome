package com.obric.aikernel.res.update;

import com.obric.aikernel.res.PackageResourceManager;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.l0;

/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(c = "com.obric.aikernel.res.update.PackageUpdater$updateWithExecutionResult$4$1", f = "PackageUpdater.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class PackageUpdater$updateWithExecutionResult$4$1 extends SuspendLambda implements Function2<l0, Continuation<? super Unit>, Object> {
    final /* synthetic */ StringBuilder $bizRequestStatus;
    final /* synthetic */ PackageUpdater.b $constriction;
    final /* synthetic */ PackageResourceManager.PresmConfig.e $it;
    final /* synthetic */ String $updateType;
    int label;

    PackageUpdater$updateWithExecutionResult$4$1(PackageResourceManager.PresmConfig.e r10, PackageUpdater.b r11, StringBuilder r12, String r13, Continuation<? super PackageUpdater$updateWithExecutionResult$4$1> r14) {
        this.$it = r10;
        this.$constriction = r11;
        this.$bizRequestStatus = r12;
        this.$updateType = r13;
        super(2, r14);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new PackageUpdater$updateWithExecutionResult$4$1(this.$it, this.$constriction, this.$bizRequestStatus, this.$updateType, r11);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(l0 r10, Continuation<? super Unit> r11) {
        return invoke2(r10, r11);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(l0 r10, Continuation<? super Unit> r11) {
        return ((PackageUpdater$updateWithExecutionResult$4$1) create(r10, r11)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r10);
        PackageResourceManager.PresmConfig.e r11 = this.$it;
        PackageUpdater.b r12 = this.$constriction;
        String r13 = this.$bizRequestStatus.toString();
        Intrinsics.checkNotNullExpressionValue(r13, "bizRequestStatus.toString()");
        r11.c(r12, r13, this.$updateType);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
