package com.obric.memorydata.database.index;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* synthetic */ class IndexPendingExecutionCoordinator$2 extends FunctionReferenceImpl implements Function3<ai.h, q, x, ai.i> {
    IndexPendingExecutionCoordinator$2(Object r8) {
        super(3, r8, ai.class, "settlePendingExecution", "settlePendingExecution-z7xEqvE$database_obricRelease(Lcom/obric/memorydata/database/index/IndexDashboardLatencyTracker$PendingExecutionToken;Lcom/obric/memorydata/database/index/DurationMs;Lcom/obric/memorydata/database/index/FirstCompletionWaitMs;)Lcom/obric/memorydata/database/index/IndexDashboardLatencyTracker$SettledSamples;", 0);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* synthetic */ ai.i invoke(ai.h r3, q r4, x r5) {
        return m557invokez7xEqvE((ai.h) ZeusTransformUtils.preCheckCast(r3, ai.h.class, "com.obric.memorydata.plugin"), (q) ZeusTransformUtils.preCheckCast(r4, q.class, "com.obric.memorydata.plugin"), (x) ZeusTransformUtils.preCheckCast(r5, x.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke-z7xEqvE, reason: not valid java name */
    public final ai.i m557invokez7xEqvE(ai.h r3, q r4, x r5) {
        Intrinsics.checkNotNullParameter(r3, "p0");
        return ((ai) ZeusTransformUtils.preCheckCast(this.receiver, ai.class, "com.obric.memorydata.plugin")).a(r3, r4, r5);
    }
}
