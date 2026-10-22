package com.obric.memorydata.personalcontext.task;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* synthetic */ class EntityConsistencyCheckTask$Companion$recoveryState$2$1 extends FunctionReferenceImpl implements Function0<a> {
    EntityConsistencyCheckTask$Companion$recoveryState$2$1(Object r8) {
        super(0, r8, EntityConsistencyCheckTask.Companion.class, "readRecoveryDemandFromStore", "readRecoveryDemandFromStore()Lcom/obric/memorydata/personalcontext/task/EntityConsistencyRecoveryDemand;", 0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final a invoke() {
        return EntityConsistencyCheckTask.Companion.access$readRecoveryDemandFromStore((EntityConsistencyCheckTask.Companion) ZeusTransformUtils.preCheckCast(this.receiver, EntityConsistencyCheckTask.Companion.class, "com.obric.memorydata.plugin"));
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ a invoke() {
        return invoke();
    }
}
