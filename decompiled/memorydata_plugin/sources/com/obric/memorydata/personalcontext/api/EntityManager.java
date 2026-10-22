package com.obric.memorydata.personalcontext.api;

import com.bytedance.news.common.service.manager.IService;
import com.bytedance.news.common.service.manager.ext.ServiceManagerExtKt;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J<\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0097\u0001¢\u0006\u0002\u0010\rJ\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u0005H\u0096\u0001J\u0011\u0010\u0011\u001a\u00020\u00122\u0006\u0010\n\u001a\u00020\u0006H\u0097\u0001J\u0011\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\tH\u0096\u0001J\u0019\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0006H\u0096\u0001J!\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0096\u0001J'\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0096\u0001J\t\u0010\u0019\u001a\u00020\tH\u0096\u0001J#\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u0014\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0096\u0001J\u0011\u0010\u001c\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\u0010H\u0096\u0001J\t\u0010\u001e\u001a\u00020\u0012H\u0096\u0001J\t\u0010\u001f\u001a\u00020\fH\u0096\u0001J\u0019\u0010 \u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0006H\u0096\u0001J\t\u0010!\u001a\u00020\u0012H\u0096\u0001J\u0017\u0010\"\u001a\u00020\u00122\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0096\u0001J\u0019\u0010$\u001a\u00020\u00122\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\fH\u0096\u0001J\u0019\u0010(\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\t2\u0006\u0010)\u001a\u00020*H\u0096\u0001J!\u0010+\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010)\u001a\u00020*H\u0096\u0001¨\u0006,"}, d2 = {"Lcom/obric/memorydata/personalcontext/api/EntityManager;", "Lcom/obric/memorydata/personalcontext/api/IEntityManager;", "<init>", "()V", "bulkDelete", "", "", "entityIds", "entityType", "", ObricMemoryConstants.KEY_PACKAGE_NAME, "isBackUp", "", "(Ljava/util/List;ILjava/lang/String;Ljava/lang/Boolean;)Ljava/util/List;", "bulkIndex", "entities", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "deleteAll", "", "deleteAllByEntityType", "type", "deleteByTypeAndPackageName", "deleteLazyIndexHistoryEntity", "entityId", "deleteLazyIndexHistoryEntityList", "getEntityDonatedVersion", "getLazyIndexHistoryEntity", "", "index", "appEntity", "indexAllContactCallSmsEntity", "isAllEntityDonated", "isLazyIndexEntity", "launchIndexTask", "reIndexCertainApps", "packageList", "reindexAllData", "finishRunnable", "Ljava/lang/Runnable;", "noNeedDelete", "removeLazyIndexHistoryEntity", "dbId", "", "resumeLazyIndexPendingTask", "personal_context_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class EntityManager implements IEntityManager {
    public static final EntityManager INSTANCE = null;
    private final /* synthetic */ IEntityManager $$delegate_0;

    static {
        INSTANCE = new EntityManager();
    }

    private EntityManager() {
        IService r0 = ServiceManagerExtKt.impl(Reflection.getOrCreateKotlinClass(IEntityManager.class));
        Intrinsics.checkNotNull(r0);
        this.$$delegate_0 = (IEntityManager) ZeusTransformUtils.preCheckCast(r0, IEntityManager.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.personalcontext.api.IEntityManager
    public List<String> bulkDelete(List<String> r3, int r4, String r5, Boolean r6) {
        List<String> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "entityIds");
        Intrinsics.checkNotNullParameter(r5, ObricMemoryConstants.KEY_PACKAGE_NAME);
        return this.$$delegate_0.bulkDelete(r7, r4, r5, r6);
    }

    @Override // com.obric.memorydata.personalcontext.api.IEntityManager
    public List<String> bulkIndex(List<? extends AppEntity> r3) {
        List<? extends AppEntity> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "entities");
        return this.$$delegate_0.bulkIndex(r4);
    }

    @Override // com.obric.memorydata.personalcontext.api.IEntityManager
    public void deleteAll(String r2) {
        Intrinsics.checkNotNullParameter(r2, ObricMemoryConstants.KEY_PACKAGE_NAME);
        this.$$delegate_0.deleteAll(r2);
    }

    @Override // com.obric.memorydata.personalcontext.api.IEntityManager
    public boolean deleteAllByEntityType(int r1) {
        return this.$$delegate_0.deleteAllByEntityType(r1);
    }

    @Override // com.obric.memorydata.personalcontext.api.IEntityManager
    public void deleteByTypeAndPackageName(int r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, ObricMemoryConstants.KEY_PACKAGE_NAME);
        this.$$delegate_0.deleteByTypeAndPackageName(r2, r3);
    }

    @Override // com.obric.memorydata.personalcontext.api.IEntityManager
    public void deleteLazyIndexHistoryEntity(int r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, ObricMemoryConstants.KEY_PACKAGE_NAME);
        Intrinsics.checkNotNullParameter(r4, "entityId");
        this.$$delegate_0.deleteLazyIndexHistoryEntity(r2, r3, r4);
    }

    @Override // com.obric.memorydata.personalcontext.api.IEntityManager
    public void deleteLazyIndexHistoryEntityList(int r3, String r4, List<String> r5) {
        List<String> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, ObricMemoryConstants.KEY_PACKAGE_NAME);
        Intrinsics.checkNotNullParameter(r6, "entityIds");
        this.$$delegate_0.deleteLazyIndexHistoryEntityList(r3, r4, r6);
    }

    @Override // com.obric.memorydata.personalcontext.api.IEntityManager
    public int getEntityDonatedVersion() {
        return this.$$delegate_0.getEntityDonatedVersion();
    }

    @Override // com.obric.memorydata.personalcontext.api.IEntityManager
    public Object getLazyIndexHistoryEntity(int r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, ObricMemoryConstants.KEY_PACKAGE_NAME);
        Intrinsics.checkNotNullParameter(r4, "entityId");
        return this.$$delegate_0.getLazyIndexHistoryEntity(r2, r3, r4);
    }

    @Override // com.obric.memorydata.personalcontext.api.IEntityManager
    public boolean index(AppEntity r2) {
        Intrinsics.checkNotNullParameter(r2, "appEntity");
        return this.$$delegate_0.index(r2);
    }

    @Override // com.obric.memorydata.personalcontext.api.IEntityManager
    public void indexAllContactCallSmsEntity() {
        this.$$delegate_0.indexAllContactCallSmsEntity();
    }

    @Override // com.obric.memorydata.personalcontext.api.IEntityManager
    public boolean isAllEntityDonated() {
        return this.$$delegate_0.isAllEntityDonated();
    }

    @Override // com.obric.memorydata.personalcontext.api.IEntityManager
    public boolean isLazyIndexEntity(int r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, ObricMemoryConstants.KEY_PACKAGE_NAME);
        return this.$$delegate_0.isLazyIndexEntity(r2, r3);
    }

    @Override // com.obric.memorydata.personalcontext.api.IEntityManager
    public void launchIndexTask() {
        this.$$delegate_0.launchIndexTask();
    }

    @Override // com.obric.memorydata.personalcontext.api.IEntityManager
    public void reIndexCertainApps(List<String> r3) {
        List<String> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "packageList");
        this.$$delegate_0.reIndexCertainApps(r4);
    }

    @Override // com.obric.memorydata.personalcontext.api.IEntityManager
    public void reindexAllData(Runnable r3, boolean r4) {
        Runnable r5 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "finishRunnable");
        this.$$delegate_0.reindexAllData(r5, r4);
    }

    @Override // com.obric.memorydata.personalcontext.api.IEntityManager
    public void removeLazyIndexHistoryEntity(int r1, long r2) {
        this.$$delegate_0.removeLazyIndexHistoryEntity(r1, r2);
    }

    @Override // com.obric.memorydata.personalcontext.api.IEntityManager
    public void resumeLazyIndexPendingTask(int r2, String r3, long r4) {
        Intrinsics.checkNotNullParameter(r3, ObricMemoryConstants.KEY_PACKAGE_NAME);
        this.$$delegate_0.resumeLazyIndexPendingTask(r2, r3, r4);
    }
}
