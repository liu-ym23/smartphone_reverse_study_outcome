package com.obric.aikernel.service.res;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
/* synthetic */ class PythonRuntimeService$inferRuntime$1$4$1 extends FunctionReferenceImpl implements Function1<com.obric.aikernel.res.update.a, Unit> {
    PythonRuntimeService$inferRuntime$1$4$1(Object r10) {
        super(1, r10, PythonRuntimeService.class, "onAutoUpdateAttempt", "onAutoUpdateAttempt(Lcom/obric/aikernel/res/update/AutoUpdateAttemptResult;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(com.obric.aikernel.res.update.a r10) {
        invoke2(r10);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(com.obric.aikernel.res.update.a r10) {
        Intrinsics.checkNotNullParameter(r10, "p0");
        PythonRuntimeService.n((PythonRuntimeService) this.receiver, r10);
    }
}
