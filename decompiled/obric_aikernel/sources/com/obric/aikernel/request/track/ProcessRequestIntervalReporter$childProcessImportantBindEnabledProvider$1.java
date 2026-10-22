package com.obric.aikernel.request.track;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes2.dex */
/* synthetic */ class ProcessRequestIntervalReporter$childProcessImportantBindEnabledProvider$1 extends FunctionReferenceImpl implements Function0<Boolean> {
    ProcessRequestIntervalReporter$childProcessImportantBindEnabledProvider$1(Object r10) {
        super(0, r10, ProcessRequestIntervalReporter.class, "defaultChildProcessImportantBindEnabled", "defaultChildProcessImportantBindEnabled()Z", 0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final Boolean invoke() {
        return Boolean.valueOf(ProcessRequestIntervalReporter.d((ProcessRequestIntervalReporter) this.receiver));
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Boolean invoke() {
        return invoke();
    }
}
