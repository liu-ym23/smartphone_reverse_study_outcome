package com.obric.aikernel.res.update;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(c = "com.obric.aikernel.res.update.PackageUpdater$updateWithExecutionResult$result$2$2", f = "PackageUpdater.kt", i = {}, l = {656}, m = "invokeSuspend", n = {}, s = {})
final class PackageUpdater$updateWithExecutionResult$result$2$2 extends SuspendLambda implements Function1<Continuation<? super UpdateResult>, Object> {
    final /* synthetic */ PackageUpdater.b $constriction;
    final /* synthetic */ UpdateResult $ret;
    final /* synthetic */ UpdateTask $task;
    int label;

    PackageUpdater$updateWithExecutionResult$result$2$2(UpdateTask r10, UpdateResult r11, PackageUpdater.b r12, Continuation<? super PackageUpdater$updateWithExecutionResult$result$2$2> r13) {
        this.$task = r10;
        this.$ret = r11;
        this.$constriction = r12;
        super(1, r13);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> r10) {
        return new PackageUpdater$updateWithExecutionResult$result$2$2(this.$task, this.$ret, this.$constriction, r10);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Continuation<? super UpdateResult> r10) {
        return invoke2(r10);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(Continuation<? super UpdateResult> r10) {
        return ((PackageUpdater$updateWithExecutionResult$result$2$2) create(r10)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r19) {
        Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r11 = this.label;
        if (r11 == 0) goto L8;
        if (r11 != 1) goto L7;
        ResultKt.throwOnFailure(r19);
        Object r12 = r19;
    L13:
        UpdateResult r13 = (UpdateResult) r12;
        if (r13 == null) goto L16;
        return r13;
    L16:
        return new UpdateResult(this.$ret.getBiz(), false, 0, null, false, 0, 0, this.$constriction.b(), 0, false, 894, null);
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r19);
        UpdateTask r14 = this.$task;
        if (r14 == null) goto L16;
        this.label = 1;
        r12 = r14.o(this);
        if (r12 != r10) goto L13;
        return r10;
    }
}
