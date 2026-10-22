package com.obric.memorydata.personalcontext.storage;

import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.FileEntity;
import com.obric.memorydata.database.entity.RawMemoryEntity;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.obric.memorydata.memory.api.MemoryService;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u001a\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0005H\u0016J\u001a\u0010\u000b\u001a\u0004\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u0018\u0010\u000f\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u0010\u001a\u00020\u0005H\u0016J\u0018\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\rH\u0016J,\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\r0\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\r0\u00152\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\rH\u0016J&\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\r0\u00152\u0006\u0010\u000e\u001a\u00020\rH\u0016¨\u0006\u0019"}, d2 = {"Lcom/obric/memorydata/personalcontext/storage/MemoryEntityStorage;", "Lcom/obric/memorydata/personalcontext/storage/AbstractAppEntityStorage;", "<init>", "()V", "index", "", "appEntity", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "transformAppEntityToRawDbEntity", "Lcom/obric/memorydata/database/IAppEntityRawDbData;", "isLazyIndex", "getRawDbEntityFromEntityId", "entityId", "", ObricMemoryConstants.KEY_PACKAGE_NAME, "delete", "isSupportBulkDelete", "isEnableLazyIndex", "type", "", "bulkDelete", "", "entitiesIds", "getRawDbEntityFromEntityIdList", "Lcom/obric/memorydata/database/entity/AbstractRawDbEntity;", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class s extends a {
    public s() {
    }

    @Override // com.obric.memorydata.personalcontext.storage.a
    public com.obric.memorydata.database.a a(AppEntity r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "appEntity");
        return null;
    }

    @Override // com.obric.memorydata.personalcontext.storage.a
    public com.obric.memorydata.database.a a(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "entityId");
        Intrinsics.checkNotNullParameter(r2, ObricMemoryConstants.KEY_PACKAGE_NAME);
        return (com.obric.memorydata.database.a) ZeusTransformUtils.preCheckCast(CollectionsKt.firstOrNull(MemoryDbEngine.INSTANCE.getGlobalDbEngine().getRawMemoryEntityDao().queryByEntityId(r1, r2)), com.obric.memorydata.database.a.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.personalcontext.storage.a
    public List<String> a(List<String> r5, int r6, String r7) {
        List<String> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r8, "entitiesIds");
        Intrinsics.checkNotNullParameter(r7, ObricMemoryConstants.KEY_PACKAGE_NAME);
        List<com.obric.memorydata.database.entity.d> r0 = a(r8, r7);
        if (r0 == null) goto L13;
        Iterator<com.obric.memorydata.database.entity.d> r1 = r0.iterator();
    L6:
        if (r1.hasNext() == false) goto L13;
        com.obric.memorydata.database.entity.d r2 = (com.obric.memorydata.database.entity.d) ZeusTransformUtils.preCheckCast(r1.next(), com.obric.memorydata.database.entity.d.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r2, RawMemoryEntity.class) == false) goto L6;
        FileEntity r3 = com.obric.memorydata.personalcontext.util.f.c(((RawMemoryEntity) ZeusTransformUtils.preCheckCast(r2, RawMemoryEntity.class, "com.obric.memorydata.plugin")).getScreenshot());
        if (r3 == null) goto L6;
        MemoryService.INSTANCE.deleteMemoryImage(r3);
    L13:
        return super.a(r8, r6, r7);
    }

    @Override // com.obric.memorydata.personalcontext.storage.a
    public List<com.obric.memorydata.database.entity.d> a(List<String> r2, String r3) {
        List<String> r1 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "entitiesIds");
        Intrinsics.checkNotNullParameter(r3, ObricMemoryConstants.KEY_PACKAGE_NAME);
        return MemoryDbEngine.INSTANCE.getGlobalDbEngine().getRawMemoryEntityDao().queryByEntityIdListAndPackageName(r1, r3);
    }

    @Override // com.obric.memorydata.personalcontext.storage.a
    public boolean a() {
        return true;
    }

    @Override // com.obric.memorydata.personalcontext.storage.a
    public boolean a(int r1, String r2) {
        Intrinsics.checkNotNullParameter(r2, ObricMemoryConstants.KEY_PACKAGE_NAME);
        return false;
    }

    @Override // com.obric.memorydata.personalcontext.storage.a
    public boolean a(AppEntity r1) {
        Intrinsics.checkNotNullParameter(r1, "appEntity");
        return false;
    }

    @Override // com.obric.memorydata.personalcontext.storage.a
    public boolean delete(String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "entityId");
        Intrinsics.checkNotNullParameter(r4, ObricMemoryConstants.KEY_PACKAGE_NAME);
        com.obric.memorydata.database.a r2 = a(r3, r4);
        if (ZeusTransformUtils.instanceOf(r2, RawMemoryEntity.class) == false) goto L5;
        RawMemoryEntity r5 = (RawMemoryEntity) ZeusTransformUtils.preCheckCast(r2, RawMemoryEntity.class, "com.obric.memorydata.plugin");
    L6:
        if (r5 != null) goto L8;
        return true;
    L8:
        return MemoryService.INSTANCE.deleteMemoryDirectly(r5.getId());
    L5:
        r5 = null;
        goto L6
    }
}
