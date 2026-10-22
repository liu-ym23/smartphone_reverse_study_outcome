package com.obric.aikernel.request.track;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
final /* synthetic */ class ProcessRequestIntervalReporter$resetForTest$8 extends FunctionReferenceImpl implements Function1<Runnable, Unit> {
    ProcessRequestIntervalReporter$resetForTest$8(Object r10) {
        super(1, r10, ProcessRequestIntervalReporter.class, "defaultRunBackgroundTask", "defaultRunBackgroundTask(Ljava/lang/Runnable;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Runnable r10) {
        invoke2(r10);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Runnable r10) {
        Intrinsics.checkNotNullParameter(r10, "p0");
        ProcessRequestIntervalReporter.i((ProcessRequestIntervalReporter) this.receiver, r10);
    }
}
