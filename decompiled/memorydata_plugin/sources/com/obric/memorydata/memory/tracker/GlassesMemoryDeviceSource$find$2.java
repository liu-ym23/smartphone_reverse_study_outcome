package com.obric.memorydata.memory.tracker;

import com.obric.memorydata.database.entity.RawObservationEntity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* synthetic */ class GlassesMemoryDeviceSource$find$2 extends FunctionReferenceImpl implements Function1<MemoryEventTracker.BaseMemoryParams, List<? extends RawObservationEntity>> {
    GlassesMemoryDeviceSource$find$2(Object r8) {
        super(1, r8, a.class, "readRawObservations", "readRawObservations(Lcom/obric/memorydata/memory/tracker/MemoryEventTracker$BaseMemoryParams;)Ljava/util/List;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* synthetic */ List<? extends RawObservationEntity> invoke(MemoryEventTracker.BaseMemoryParams r3) {
        return invoke2((MemoryEventTracker.BaseMemoryParams) ZeusTransformUtils.preCheckCast(r3, MemoryEventTracker.BaseMemoryParams.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final List<RawObservationEntity> invoke2(MemoryEventTracker.BaseMemoryParams r3) {
        Intrinsics.checkNotNullParameter(r3, "p0");
        return a.a((a) ZeusTransformUtils.preCheckCast(this.receiver, a.class, "com.obric.memorydata.plugin"), r3);
    }
}
