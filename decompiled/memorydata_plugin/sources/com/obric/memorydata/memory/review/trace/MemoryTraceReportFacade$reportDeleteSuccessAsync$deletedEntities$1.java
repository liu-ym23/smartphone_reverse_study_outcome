package com.obric.memorydata.memory.review.trace;

import com.obric.capabilitykit.entity.app.AppEntity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* synthetic */ class MemoryTraceReportFacade$reportDeleteSuccessAsync$deletedEntities$1 extends FunctionReferenceImpl implements Function1<AppEntity, g.a> {
    MemoryTraceReportFacade$reportDeleteSuccessAsync$deletedEntities$1(Object r8) {
        super(1, r8, g.class, "toDeleteTraceEntity", "toDeleteTraceEntity(Lcom/obric/capabilitykit/entity/app/AppEntity;)Lcom/obric/memorydata/memory/review/trace/MemoryTraceReportFacade$DeletedMemoryTraceEntity;", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final g.a invoke2(AppEntity r3) {
        Intrinsics.checkNotNullParameter(r3, "p0");
        return g.a((g) ZeusTransformUtils.preCheckCast(this.receiver, g.class, "com.obric.memorydata.plugin"), r3);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* synthetic */ g.a invoke(AppEntity r3) {
        return invoke2((AppEntity) ZeusTransformUtils.preCheckCast(r3, AppEntity.class, "com.obric.memorydata.plugin"));
    }
}
