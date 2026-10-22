package com.obric.memorydata.database.index;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* synthetic */ class IndexPendingExecutionCoordinator$1 extends FunctionReferenceImpl implements Function2<ai.i, IndexExecutionOutcome, Unit> {
    IndexPendingExecutionCoordinator$1(Object r8) {
        super(2, r8, ah.class, "report", "report(Lcom/obric/memorydata/database/index/IndexDashboardLatencyTracker$SettledSamples;Lcom/obric/memorydata/database/index/IndexExecutionOutcome;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Unit invoke(ai.i r3, IndexExecutionOutcome r4) {
        invoke2((ai.i) ZeusTransformUtils.preCheckCast(r3, ai.i.class, "com.obric.memorydata.plugin"), (IndexExecutionOutcome) ZeusTransformUtils.preCheckCast(r4, IndexExecutionOutcome.class, "com.obric.memorydata.plugin"));
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(ai.i r3, IndexExecutionOutcome r4) {
        Intrinsics.checkNotNullParameter(r4, "p1");
        ((ah) ZeusTransformUtils.preCheckCast(this.receiver, ah.class, "com.obric.memorydata.plugin")).a(r3, r4);
    }
}
