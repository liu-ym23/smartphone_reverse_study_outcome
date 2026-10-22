package com.obric.memorydata.database.backup.appentity;

import com.obric.memorydata.database.entity.AutoMemoryProEntity;
import com.ttnet.org.chromium.net.NetError;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/obric/memorydata/database/backup/appentity/FakeAutoMemoryProEntity;", "Lcom/obric/memorydata/database/backup/appentity/AbstractFakeAppEntity;", "rawDbEntity", "Lcom/obric/memorydata/database/entity/AutoMemoryProEntity;", "<init>", "(Lcom/obric/memorydata/database/entity/AutoMemoryProEntity;)V", "getRawDbEntity", "()Lcom/obric/memorydata/database/entity/AutoMemoryProEntity;", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class FakeAutoMemoryProEntity extends AbstractFakeAppEntity {
    private final AutoMemoryProEntity rawDbEntity;

    public FakeAutoMemoryProEntity(AutoMemoryProEntity r10) {
        Intrinsics.checkNotNullParameter(r10, "rawDbEntity");
        super(r10.getEntityId(), r10.getCreateTime(), r10.getModifyTime(), NetError.ERR_CACHE_OPERATION_NOT_SUPPORTED, r10.getPackageName());
        this.rawDbEntity = r10;
    }

    public final AutoMemoryProEntity getRawDbEntity() {
        return this.rawDbEntity;
    }
}
