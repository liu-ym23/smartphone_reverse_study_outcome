package com.obric.memorydata.personalcontext.task;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* synthetic */ class EntityConsistencyCheckTask$Companion$recoveryState$2$2 extends FunctionReferenceImpl implements Function1<a, Unit> {
    EntityConsistencyCheckTask$Companion$recoveryState$2$2(Object r8) {
        super(1, r8, EntityConsistencyCheckTask.Companion.class, "persistRecoveryDemand", "persistRecoveryDemand(Lcom/obric/memorydata/personalcontext/task/EntityConsistencyRecoveryDemand;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* synthetic */ Unit invoke(a r3) {
        invoke2((a) ZeusTransformUtils.preCheckCast(r3, a.class, "com.obric.memorydata.plugin"));
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(a r3) {
        Intrinsics.checkNotNullParameter(r3, "p0");
        EntityConsistencyCheckTask.Companion.access$persistRecoveryDemand((EntityConsistencyCheckTask.Companion) ZeusTransformUtils.preCheckCast(this.receiver, EntityConsistencyCheckTask.Companion.class, "com.obric.memorydata.plugin"), r3);
    }
}
