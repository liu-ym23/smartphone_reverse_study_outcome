package com.obric.memorydata.personalcontext.api;

import android.content.Context;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.news.common.service.manager.ext.ServiceManagerExtKt;
import com.obric.capabilitykit.EntitySupplier;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.sync.EntitySyncDataSupplier;
import com.obric.memorydata.middleware.api.IAgentServiceProvider;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0096\u0001J\u000f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0096\u0001J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0096\u0001J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0096\u0001J%\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00052\u0006\u0010\r\u001a\u00020\u000eH\u0096\u0001J\u000f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0005H\u0096\u0001J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0096\u0001J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0096\u0001J\u000f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\f0\u0005H\u0096\u0001J\u0013\u0010\u0015\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000eH\u0096\u0001J\t\u0010\u0016\u001a\u00020\u0017H\u0096\u0001J\u0011\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\fH\u0096\u0001J\u0019\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0017H\u0096\u0001J\u0019\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u0018\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020\u0017H\u0097\u0001J\u0011\u0010 \u001a\u00020\u001a2\u0006\u0010!\u001a\u00020\"H\u0096\u0001J\t\u0010#\u001a\u00020\u001aH\u0096\u0001J\t\u0010$\u001a\u00020\u001aH\u0096\u0001J\t\u0010%\u001a\u00020\u001aH\u0096\u0001¨\u0006&"}, d2 = {"Lcom/obric/memorydata/personalcontext/api/EntityCollectorService;", "Lcom/obric/memorydata/personalcontext/api/IEntityCollectorService;", "<init>", "()V", "getAllCallHistoryData", "", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "getAllContactAndCallHistoryData", "getAllContactAndSmsData", "getAllSmsData", "getDataAndTriggerIndex", "noPcIds", "", "entityType", "", "getDonateEntityTypeList", "getEntitySupplier", "Lcom/obric/capabilitykit/EntitySupplier;", "getEntitySyncDataSupplier", "Lcom/obric/capabilitykit/sync/EntitySyncDataSupplier;", "getNeedRequestPermissions", "getPackageNameByEntityType", "hasPermission", "", "dataTag", "initDataCollector", "", "context", "Landroid/content/Context;", "syncDataDelay", "reIndexData", "noNeedDelete", "registerIAgentServiceProvider", "agentServiceProvider", "Lcom/obric/memorydata/middleware/api/IAgentServiceProvider;", CommonConsts.APM_INNER_EVENT_COST_START, "stop", "syncData", "personal_context_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class EntityCollectorService implements IEntityCollectorService {
    public static final EntityCollectorService INSTANCE = null;
    private final /* synthetic */ IEntityCollectorService $$delegate_0;

    static {
        INSTANCE = new EntityCollectorService();
    }

    private EntityCollectorService() {
        IEntityCollectorService r0 = (IEntityCollectorService) ZeusTransformUtils.preCheckCast(ServiceManagerExtKt.impl(Reflection.getOrCreateKotlinClass(IEntityCollectorService.class)), IEntityCollectorService.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L5;
        r0 = (IEntityCollectorService) ZeusTransformUtils.preCheckCast(DefaultEntityCollectorService.INSTANCE, IEntityCollectorService.class, "com.obric.memorydata.plugin");
    L5:
        this.$$delegate_0 = r0;
    }

    @Override // com.obric.memorydata.personalcontext.api.IEntityCollectorService
    public List<AppEntity> getAllCallHistoryData() {
        return this.$$delegate_0.getAllCallHistoryData();
    }

    @Override // com.obric.memorydata.personalcontext.api.IEntityCollectorService
    public List<AppEntity> getAllContactAndCallHistoryData() {
        return this.$$delegate_0.getAllContactAndCallHistoryData();
    }

    @Override // com.obric.memorydata.personalcontext.api.IEntityCollectorService
    public List<AppEntity> getAllContactAndSmsData() {
        return this.$$delegate_0.getAllContactAndSmsData();
    }

    @Override // com.obric.memorydata.personalcontext.api.IEntityCollectorService
    public List<AppEntity> getAllSmsData() {
        return this.$$delegate_0.getAllSmsData();
    }

    @Override // com.obric.memorydata.personalcontext.api.IEntityCollectorService
    public List<AppEntity> getDataAndTriggerIndex(List<String> r3, int r4) {
        List<String> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "noPcIds");
        return this.$$delegate_0.getDataAndTriggerIndex(r5, r4);
    }

    @Override // com.obric.memorydata.personalcontext.api.IEntityCollectorService
    public List<Integer> getDonateEntityTypeList() {
        return this.$$delegate_0.getDonateEntityTypeList();
    }

    @Override // com.obric.memorydata.personalcontext.api.IEntityCollectorService
    public EntitySupplier getEntitySupplier() {
        return this.$$delegate_0.getEntitySupplier();
    }

    @Override // com.obric.memorydata.personalcontext.api.IEntityCollectorService
    public EntitySyncDataSupplier getEntitySyncDataSupplier() {
        return this.$$delegate_0.getEntitySyncDataSupplier();
    }

    @Override // com.obric.memorydata.personalcontext.api.IEntityCollectorService
    public List<String> getNeedRequestPermissions() {
        return this.$$delegate_0.getNeedRequestPermissions();
    }

    @Override // com.obric.memorydata.personalcontext.api.IEntityCollectorService
    public String getPackageNameByEntityType(int r1) {
        return this.$$delegate_0.getPackageNameByEntityType(r1);
    }

    @Override // com.obric.memorydata.personalcontext.api.IEntityCollectorService
    public boolean hasPermission() {
        return this.$$delegate_0.hasPermission();
    }

    @Override // com.obric.memorydata.personalcontext.api.IEntityCollectorService
    public boolean hasPermission(String r2) {
        Intrinsics.checkNotNullParameter(r2, "dataTag");
        return this.$$delegate_0.hasPermission(r2);
    }

    @Override // com.obric.memorydata.personalcontext.api.IEntityCollectorService
    public void initDataCollector(Context r3, boolean r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "context");
        this.$$delegate_0.initDataCollector(r5, r4);
    }

    @Override // com.obric.memorydata.personalcontext.api.IEntityCollectorService
    public void reIndexData(String r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "dataTag");
        this.$$delegate_0.reIndexData(r2, r3);
    }

    @Override // com.obric.memorydata.personalcontext.api.IEntityCollectorService
    public void registerIAgentServiceProvider(IAgentServiceProvider r3) {
        IAgentServiceProvider r4 = (IAgentServiceProvider) ZeusTransformUtils.wrapperContextForParams(r3, IAgentServiceProvider.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "agentServiceProvider");
        this.$$delegate_0.registerIAgentServiceProvider(r4);
    }

    @Override // com.obric.memorydata.personalcontext.api.IEntityCollectorService
    public void start() {
        this.$$delegate_0.start();
    }

    @Override // com.obric.memorydata.personalcontext.api.IEntityCollectorService
    public void stop() {
        this.$$delegate_0.stop();
    }

    @Override // com.obric.memorydata.personalcontext.api.IEntityCollectorService
    public void syncData() {
        this.$$delegate_0.syncData();
    }
}
