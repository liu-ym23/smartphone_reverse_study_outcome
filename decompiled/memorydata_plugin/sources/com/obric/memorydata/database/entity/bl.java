package com.obric.memorydata.database.entity;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\nH\u0016¨\u0006\u0010"}, d2 = {"Lcom/obric/memorydata/database/entity/EpisodicMemoryIndexExtend;", "Lcom/obric/memorydata/database/index/DecoratedEntityIndex;", "delegate", "Lcom/obric/memorydata/database/index/BaseEntityIndex;", "<init>", "(Lcom/obric/memorydata/database/index/BaseEntityIndex;)V", "generateIndexPendingTask", "", "Lcom/obric/memorydata/database/entity/IndexPendingEntity;", "columnName", "", "entity", "Lcom/obric/memorydata/database/entity/AbstractRawDbEntity;", "executeIndexPendingTask", "", "updateField", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class bl extends com.obric.memorydata.database.index.p {
    public bl(com.obric.memorydata.database.index.e r3) {
        com.obric.memorydata.database.index.e r4 = (com.obric.memorydata.database.index.e) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.memorydata.database.index.e.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "delegate");
        super(r4);
    }

    @Override // com.obric.memorydata.database.index.p, com.obric.memorydata.database.index.e
    public boolean executeIndexPendingTask(d r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "entity");
        Intrinsics.checkNotNullParameter(r5, "updateField");
        if (ZeusTransformUtils.instanceOf(r4, EpisodicMemoryEntity.class) == false) goto L11;
        if (bm.f8933a.a(((EpisodicMemoryEntity) ZeusTransformUtils.preCheckCast(r4, EpisodicMemoryEntity.class, "com.obric.memorydata.plugin")).getProductType(), r5) == true) goto L9;
        return true;
    L9:
        return super.executeIndexPendingTask(r4, r5);
    L11:
        throw new IllegalStateException("Check failed.".toString());
    }

    @Override // com.obric.memorydata.database.index.p, com.obric.memorydata.database.index.e
    public List<cd> generateIndexPendingTask(String r4, d r5) {
        Intrinsics.checkNotNullParameter(r4, "columnName");
        Intrinsics.checkNotNullParameter(r5, "entity");
        if (ZeusTransformUtils.instanceOf(r5, EpisodicMemoryEntity.class) == false) goto L11;
        if (bm.f8933a.a(((EpisodicMemoryEntity) ZeusTransformUtils.preCheckCast(r5, EpisodicMemoryEntity.class, "com.obric.memorydata.plugin")).getProductType(), r4) == true) goto L9;
        return CollectionsKt.emptyList();
    L9:
        return super.generateIndexPendingTask(r4, r5);
    L11:
        throw new IllegalStateException("Check failed.".toString());
    }
}
