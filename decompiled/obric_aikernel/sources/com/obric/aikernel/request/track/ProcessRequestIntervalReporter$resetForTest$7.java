package com.obric.aikernel.request.track;

import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
final /* synthetic */ class ProcessRequestIntervalReporter$resetForTest$7 extends FunctionReferenceImpl implements Function2<String, Map<String, ? extends Object>, Unit> {
    ProcessRequestIntervalReporter$resetForTest$7(Object r10) {
        super(2, r10, ProcessRequestIntervalReporter.class, "defaultEventReporter", "defaultEventReporter(Ljava/lang/String;Ljava/util/Map;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(String r10, Map<String, ? extends Object> r11) {
        invoke2(r10, r11);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(String r10, Map<String, ? extends Object> r11) {
        Intrinsics.checkNotNullParameter(r10, "p0");
        Intrinsics.checkNotNullParameter(r11, "p1");
        ProcessRequestIntervalReporter.e((ProcessRequestIntervalReporter) this.receiver, r10, r11);
    }
}
