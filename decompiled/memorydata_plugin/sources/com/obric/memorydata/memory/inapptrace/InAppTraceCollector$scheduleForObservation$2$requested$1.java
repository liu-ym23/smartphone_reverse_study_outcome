package com.obric.memorydata.memory.inapptrace;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* synthetic */ class InAppTraceCollector$scheduleForObservation$2$requested$1 extends FunctionReferenceImpl implements Function1<com.obric.memorydata.memory.j, Unit> {
    InAppTraceCollector$scheduleForObservation$2$requested$1(Object r8) {
        super(1, r8, d.class, "onFrameworkFlushCompleted", "onFrameworkFlushCompleted(Lcom/obric/memorydata/memory/InAppSignalFlushCompletion;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* synthetic */ Unit invoke(com.obric.memorydata.memory.j r3) {
        invoke2((com.obric.memorydata.memory.j) ZeusTransformUtils.preCheckCast(r3, com.obric.memorydata.memory.j.class, "com.obric.memorydata.plugin"));
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(com.obric.memorydata.memory.j r3) {
        Intrinsics.checkNotNullParameter(r3, "p0");
        d.a((d) ZeusTransformUtils.preCheckCast(this.receiver, d.class, "com.obric.memorydata.plugin"), r3);
    }
}
