package com.obric.memorydata.database.index;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* synthetic */ class IndexPendingExecutionCoordinator$4 extends FunctionReferenceImpl implements Function1<ai.c, Unit> {
    IndexPendingExecutionCoordinator$4(Object r8) {
        super(1, r8, ai.class, "discardEntityRound", "discardEntityRound$database_obricRelease(Lcom/obric/memorydata/database/index/IndexDashboardLatencyTracker$EntityRoundIdentity;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* synthetic */ Unit invoke(ai.c r3) {
        invoke2((ai.c) ZeusTransformUtils.preCheckCast(r3, ai.c.class, "com.obric.memorydata.plugin"));
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(ai.c r3) {
        Intrinsics.checkNotNullParameter(r3, "p0");
        ((ai) ZeusTransformUtils.preCheckCast(this.receiver, ai.class, "com.obric.memorydata.plugin")).a(r3);
    }
}
