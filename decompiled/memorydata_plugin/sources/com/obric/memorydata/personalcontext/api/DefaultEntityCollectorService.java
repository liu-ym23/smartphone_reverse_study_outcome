package com.obric.memorydata.personalcontext.api;

import android.content.Context;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.obric.capabilitykit.EntitySupplier;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.sync.EntitySyncDataSupplier;
import com.obric.memorydata.middleware.api.IAgentServiceProvider;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u000e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0016J\u000e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0016J\u000e\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0016J\u000e\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0016J\u0018\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\tH\u0016J\n\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\n\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u000e\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u000eH\u0016J\u0010\u0010\u001b\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u001aH\u0016J\u000e\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\f0\u000eH\u0016J\b\u0010\u001e\u001a\u00020\u0005H\u0016J\b\u0010\u001f\u001a\u00020\u0005H\u0016J\b\u0010 \u001a\u00020\u0005H\u0016J\u0010\u0010!\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020#H\u0016J$\u0010$\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\f0\u000e2\u0006\u0010\u001c\u001a\u00020\u001aH\u0016¨\u0006&"}, d2 = {"Lcom/obric/memorydata/personalcontext/api/DefaultEntityCollectorService;", "Lcom/obric/memorydata/personalcontext/api/IEntityCollectorService;", "<init>", "()V", "initDataCollector", "", "context", "Landroid/content/Context;", "syncDataDelay", "", "hasPermission", "dataTag", "", "getAllContactAndSmsData", "", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "getAllContactAndCallHistoryData", "getAllCallHistoryData", "getAllSmsData", "reIndexData", "noNeedDelete", "getEntitySupplier", "Lcom/obric/capabilitykit/EntitySupplier;", "getEntitySyncDataSupplier", "Lcom/obric/capabilitykit/sync/EntitySyncDataSupplier;", "getDonateEntityTypeList", "", "getPackageNameByEntityType", "entityType", "getNeedRequestPermissions", CommonConsts.APM_INNER_EVENT_COST_START, "stop", "syncData", "registerIAgentServiceProvider", "agentServiceProvider", "Lcom/obric/memorydata/middleware/api/IAgentServiceProvider;", "getDataAndTriggerIndex", "noPcIds", "personal_context_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class DefaultEntityCollectorService implements IEntityCollectorService {
    public static final DefaultEntityCollectorService INSTANCE = null;

    static {
        INSTANCE = new DefaultEntityCollectorService();
    }

    private DefaultEntityCollectorService() {
    }

    @Override // com.obric.memorydata.personalcontext.api.IEntityCollectorService
    public List<AppEntity> getAllCallHistoryData() {
        return CollectionsKt.emptyList();
    }

    @Override // com.obric.memorydata.personalcontext.api.IEntityCollectorService
    public List<AppEntity> getAllContactAndCallHistoryData() {
        return CollectionsKt.emptyList();
    }

    @Override // com.obric.memorydata.personalcontext.api.IEntityCollectorService
    public List<AppEntity> getAllContactAndSmsData() {
        return CollectionsKt.emptyList();
    }

    @Override // com.obric.memorydata.personalcontext.api.IEntityCollectorService
    public List<AppEntity> getAllSmsData() {
        return CollectionsKt.emptyList();
    }

    @Override // com.obric.memorydata.personalcontext.api.IEntityCollectorService
    public List<AppEntity> getDataAndTriggerIndex(List<String> r1, int r2) {
        Intrinsics.checkNotNullParameter((List) ZeusTransformUtils.wrapperContextForParams(r1, List.class, "com.obric.memorydata.plugin"), "noPcIds");
        return CollectionsKt.emptyList();
    }

    @Override // com.obric.memorydata.personalcontext.api.IEntityCollectorService
    public List<Integer> getDonateEntityTypeList() {
        return CollectionsKt.emptyList();
    }

    @Override // com.obric.memorydata.personalcontext.api.IEntityCollectorService
    public EntitySupplier getEntitySupplier() {
        return null;
    }

    @Override // com.obric.memorydata.personalcontext.api.IEntityCollectorService
    public EntitySyncDataSupplier getEntitySyncDataSupplier() {
        return null;
    }

    @Override // com.obric.memorydata.personalcontext.api.IEntityCollectorService
    public List<String> getNeedRequestPermissions() {
        return CollectionsKt.emptyList();
    }

    @Override // com.obric.memorydata.personalcontext.api.IEntityCollectorService
    public String getPackageNameByEntityType(int r1) {
        return "";
    }

    @Override // com.obric.memorydata.personalcontext.api.IEntityCollectorService
    public boolean hasPermission() {
        return false;
    }

    @Override // com.obric.memorydata.personalcontext.api.IEntityCollectorService
    public boolean hasPermission(String r1) {
        Intrinsics.checkNotNullParameter(r1, "dataTag");
        return false;
    }

    @Override // com.obric.memorydata.personalcontext.api.IEntityCollectorService
    public void initDataCollector(Context r1, boolean r2) {
        Intrinsics.checkNotNullParameter((Context) ZeusTransformUtils.wrapperContextForParams(r1, Context.class, "com.obric.memorydata.plugin"), "context");
    }

    @Override // com.obric.memorydata.personalcontext.api.IEntityCollectorService
    public void reIndexData(String r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "dataTag");
    }

    @Override // com.obric.memorydata.personalcontext.api.IEntityCollectorService
    public void registerIAgentServiceProvider(IAgentServiceProvider r2) {
        Intrinsics.checkNotNullParameter((IAgentServiceProvider) ZeusTransformUtils.wrapperContextForParams(r2, IAgentServiceProvider.class, "com.obric.memorydata.plugin"), "agentServiceProvider");
    }

    @Override // com.obric.memorydata.personalcontext.api.IEntityCollectorService
    public void start() {
    }

    @Override // com.obric.memorydata.personalcontext.api.IEntityCollectorService
    public void stop() {
    }

    @Override // com.obric.memorydata.personalcontext.api.IEntityCollectorService
    public void syncData() {
    }
}
