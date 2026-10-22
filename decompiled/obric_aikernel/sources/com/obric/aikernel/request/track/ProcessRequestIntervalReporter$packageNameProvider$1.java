package com.obric.aikernel.request.track;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes2.dex */
/* synthetic */ class ProcessRequestIntervalReporter$packageNameProvider$1 extends FunctionReferenceImpl implements Function0<String> {
    ProcessRequestIntervalReporter$packageNameProvider$1(Object r10) {
        super(0, r10, ProcessRequestIntervalReporter.class, "defaultPackageName", "defaultPackageName()Ljava/lang/String;", 0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ String invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final String invoke2() {
        return ProcessRequestIntervalReporter.g((ProcessRequestIntervalReporter) this.receiver);
    }
}
