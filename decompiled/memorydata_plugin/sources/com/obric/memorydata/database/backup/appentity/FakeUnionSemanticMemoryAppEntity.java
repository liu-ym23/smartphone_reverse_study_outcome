package com.obric.memorydata.database.backup.appentity;

import com.obric.memorydata.database.entity.ip;
import com.ttnet.org.chromium.net.NetError;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/obric/memorydata/database/backup/appentity/FakeUnionSemanticMemoryAppEntity;", "Lcom/obric/memorydata/database/backup/appentity/AbstractFakeAppEntity;", "rawDbEntity", "Lcom/obric/memorydata/database/entity/UnionSemanticMemoryEntity;", "<init>", "(Lcom/obric/memorydata/database/entity/UnionSemanticMemoryEntity;)V", "getRawDbEntity", "()Lcom/obric/memorydata/database/entity/UnionSemanticMemoryEntity;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class FakeUnionSemanticMemoryAppEntity extends AbstractFakeAppEntity {
    private final ip rawDbEntity;

    public FakeUnionSemanticMemoryAppEntity(ip r10) {
        Intrinsics.checkNotNullParameter(r10, "rawDbEntity");
        super(r10.getEntityId(), r10.getCreateTime(), r10.getModifyTime(), NetError.ERR_CACHE_READ_FAILURE, r10.getPackageName());
        this.rawDbEntity = r10;
    }

    public static /* synthetic */ FakeUnionSemanticMemoryAppEntity copy$default(FakeUnionSemanticMemoryAppEntity r0, ip r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = r0.rawDbEntity;
    L6:
        return r0.copy(r1);
    }

    public final ip component1() {
        return this.rawDbEntity;
    }

    public final FakeUnionSemanticMemoryAppEntity copy(ip r1) {
        Intrinsics.checkNotNullParameter(r1, "rawDbEntity");
        return new FakeUnionSemanticMemoryAppEntity(r1);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, FakeUnionSemanticMemoryAppEntity.class) == true) goto L8;
        return false;
    L8:
        FakeUnionSemanticMemoryAppEntity r6 = (FakeUnionSemanticMemoryAppEntity) ZeusTransformUtils.preCheckCast(r5, FakeUnionSemanticMemoryAppEntity.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.rawDbEntity, r6.rawDbEntity) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final ip getRawDbEntity() {
        return this.rawDbEntity;
    }

    @Override // com.obric.capabilitykit.entity.app.AppEntity
    public int hashCode() {
        return this.rawDbEntity.hashCode();
    }

    @Override // com.obric.capabilitykit.entity.app.AppEntity
    public String toString() {
        return "FakeUnionSemanticMemoryAppEntity(rawDbEntity=" + this.rawDbEntity + ')';
    }
}
