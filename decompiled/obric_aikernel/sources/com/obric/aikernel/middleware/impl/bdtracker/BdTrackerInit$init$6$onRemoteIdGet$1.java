package com.obric.aikernel.middleware.impl.bdtracker;

import com.obric.aikernel.middleware.api.commonmonitor.CommonMonitorInit;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.l0;

/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(c = "com.obric.aikernel.middleware.impl.bdtracker.BdTrackerInit$init$6$onRemoteIdGet$1", f = "BdTrackerInit.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class BdTrackerInit$init$6$onRemoteIdGet$1 extends SuspendLambda implements Function2<l0, Continuation<? super Unit>, Object> {
    int label;

    BdTrackerInit$init$6$onRemoteIdGet$1(Continuation<? super BdTrackerInit$init$6$onRemoteIdGet$1> r10) {
        super(2, r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new BdTrackerInit$init$6$onRemoteIdGet$1(r11);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(l0 r10, Continuation<? super Unit> r11) {
        return invoke2(r10, r11);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(l0 r10, Continuation<? super Unit> r11) {
        return ((BdTrackerInit$init$6$onRemoteIdGet$1) create(r10, r11)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r10);
        new CommonMonitorInit().initApm();
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
