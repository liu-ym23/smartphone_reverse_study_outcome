package com.obric.aikernel.request.track;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes2.dex */
final /* synthetic */ class ProcessRequestIntervalReporter$resetForTest$5 extends FunctionReferenceImpl implements Function0<Long> {
    ProcessRequestIntervalReporter$resetForTest$5(Object r10) {
        super(0, r10, ProcessRequestIntervalReporter.class, "defaultAppStartTime", "defaultAppStartTime()J", 0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final Long invoke() {
        return Long.valueOf(ProcessRequestIntervalReporter.c((ProcessRequestIntervalReporter) this.receiver));
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Long invoke() {
        return invoke();
    }
}
