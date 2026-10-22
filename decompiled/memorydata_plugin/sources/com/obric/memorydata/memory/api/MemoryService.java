package com.obric.memorydata.memory.api;

import android.graphics.drawable.Drawable;
import com.bytedance.news.common.service.manager.IService;
import com.bytedance.news.common.service.manager.ext.ServiceManagerExtKt;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.aikernel.sdk.ext.Params;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.FileEntity;
import com.obric.memorydata.memory.lab.AILabCheckPermissionTask;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.flow.ar;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\t\u0010\u0004\u001a\u00020\u0005H\u0096\u0001J9\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\fH\u0096\u0001J\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\u0011H\u0096\u0001J\t\u0010\u0012\u001a\u00020\u0007H\u0096\u0001J\u0019\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\fH\u0096\u0001J\u0011\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\tH\u0096\u0001J\u0011\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\tH\u0096\u0001J\u0011\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u001cH\u0096\u0001J\u000f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00050\u0011H\u0096\u0001J\u0013\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010\u000b\u001a\u00020\fH\u0096\u0001J\u0011\u0010 \u001a\u00020\u00072\u0006\u0010!\u001a\u00020\"H\u0096\u0001J\t\u0010#\u001a\u00020\u0005H\u0096\u0001J\t\u0010$\u001a\u00020\u0007H\u0096\u0001J\u0017\u0010%\u001a\u00020\u00072\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\t0'H\u0096\u0001J\t\u0010(\u001a\u00020\u0007H\u0096\u0001J\u0017\u0010)\u001a\u00020\u00052\f\u0010*\u001a\b\u0012\u0004\u0012\u00020+0'H\u0096\u0001J!\u0010,\u001a\u00020\u00052\u0006\u0010-\u001a\u00020\f2\u0006\u0010.\u001a\u00020\f2\u0006\u0010/\u001a\u00020\fH\u0096\u0001J\t\u00100\u001a\u00020\u0007H\u0096\u0001J\u0011\u00101\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\tH\u0096\u0001J!\u00102\u001a\u00020\f2\u0006\u00103\u001a\u00020\f2\u0006\u00104\u001a\u00020\f2\u0006\u00105\u001a\u00020\fH\u0096\u0001J\t\u00106\u001a\u00020\u0007H\u0096\u0001J\u0019\u00107\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\fH\u0096\u0001J\u0017\u00108\u001a\u00020\u00072\f\u00109\u001a\b\u0012\u0004\u0012\u00020\f0'H\u0096\u0001¨\u0006:"}, d2 = {"Lcom/obric/memorydata/memory/api/MemoryService;", "Lcom/obric/memorydata/memory/api/MemoryServiceApi;", "<init>", "()V", "assistantSmartMemoryEnabled", "", "associateInAppTraceWithScreenshot", "", "observationId", "", "screenshotTimestamp", ObricMemoryConstants.KEY_PACKAGE_NAME, "", "screenshotPath", "viewTreePath", "flushRequestId", "autoMemoryEffectiveEnabled", "Lkotlinx/coroutines/flow/StateFlow;", "clearAppIconCache", "createAutoMemoryRule", "title", Params.CONTENT, "deleteCollectionRule", "ruleId", "deleteMemoryDirectly", "memoryRawDbId", "deleteMemoryImage", "fileEntity", "Lcom/obric/capabilitykit/entity/app/FileEntity;", "experienceState", "getAppIcon", "Landroid/graphics/drawable/Drawable;", "indexMemory", "appEntity", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "isAILabScreenMemoryEnabled", "markContextAwarenessConfigured", "onSemanticMemoryDeleted", "deletedItemIds", "", "onSemanticMigrationUnblocked", "reportInAppTrace", "items", "Lcom/obric/memorydata/memory/api/InAppTraceReportItem;", "reportMemoryTraceOps", "logId", AILabCheckPermissionTask.KEY_SOURCE, "memoryOpsJson", "requestInAppRuleSync", "requestInAppSignalFlush", "resolveAutoMemoryIconKey", "semanticKey", "oldIconKey", "stableSeed", "runAfterRawMemoryTranslateTask", "updateCollectionRule", "updateInAppSignalCollectionPackages", "packageNames", "memory_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class MemoryService implements MemoryServiceApi {
    public static final MemoryService INSTANCE = null;
    private final /* synthetic */ MemoryServiceApi $$delegate_0;

    static {
        INSTANCE = new MemoryService();
    }

    private MemoryService() {
        IService r0 = ServiceManagerExtKt.impl(Reflection.getOrCreateKotlinClass(MemoryServiceApi.class));
        Intrinsics.checkNotNull(r0);
        this.$$delegate_0 = (MemoryServiceApi) ZeusTransformUtils.preCheckCast(r0, MemoryServiceApi.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.memory.api.MemoryServiceApi
    public boolean assistantSmartMemoryEnabled() {
        return this.$$delegate_0.assistantSmartMemoryEnabled();
    }

    @Override // com.obric.memorydata.memory.api.MemoryServiceApi
    public void associateInAppTraceWithScreenshot(long r11, long r13, String r15, String r16, String r17, String r18) {
        Intrinsics.checkNotNullParameter(r15, ObricMemoryConstants.KEY_PACKAGE_NAME);
        Intrinsics.checkNotNullParameter(r16, "screenshotPath");
        Intrinsics.checkNotNullParameter(r17, "viewTreePath");
        Intrinsics.checkNotNullParameter(r18, "flushRequestId");
        this.$$delegate_0.associateInAppTraceWithScreenshot(r11, r13, r15, r16, r17, r18);
    }

    @Override // com.obric.memorydata.memory.api.MemoryServiceApi
    public ar<Boolean> autoMemoryEffectiveEnabled() {
        return this.$$delegate_0.autoMemoryEffectiveEnabled();
    }

    @Override // com.obric.memorydata.memory.api.MemoryServiceApi
    public void clearAppIconCache() {
        this.$$delegate_0.clearAppIconCache();
    }

    @Override // com.obric.memorydata.memory.api.MemoryServiceApi
    public long createAutoMemoryRule(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "title");
        Intrinsics.checkNotNullParameter(r3, Params.CONTENT);
        return this.$$delegate_0.createAutoMemoryRule(r2, r3);
    }

    @Override // com.obric.memorydata.memory.api.MemoryServiceApi
    public boolean deleteCollectionRule(long r1) {
        return this.$$delegate_0.deleteCollectionRule(r1);
    }

    @Override // com.obric.memorydata.memory.api.MemoryServiceApi
    public boolean deleteMemoryDirectly(long r1) {
        return this.$$delegate_0.deleteMemoryDirectly(r1);
    }

    @Override // com.obric.memorydata.memory.api.MemoryServiceApi
    public void deleteMemoryImage(FileEntity r2) {
        Intrinsics.checkNotNullParameter(r2, "fileEntity");
        this.$$delegate_0.deleteMemoryImage(r2);
    }

    @Override // com.obric.memorydata.memory.api.MemoryServiceApi
    public ar<Boolean> experienceState() {
        return this.$$delegate_0.experienceState();
    }

    @Override // com.obric.memorydata.memory.api.MemoryServiceApi
    public Drawable getAppIcon(String r2) {
        Intrinsics.checkNotNullParameter(r2, ObricMemoryConstants.KEY_PACKAGE_NAME);
        return this.$$delegate_0.getAppIcon(r2);
    }

    @Override // com.obric.memorydata.memory.api.MemoryServiceApi
    public void indexMemory(AppEntity r2) {
        Intrinsics.checkNotNullParameter(r2, "appEntity");
        this.$$delegate_0.indexMemory(r2);
    }

    @Override // com.obric.memorydata.memory.api.MemoryServiceApi
    public boolean isAILabScreenMemoryEnabled() {
        return this.$$delegate_0.isAILabScreenMemoryEnabled();
    }

    @Override // com.obric.memorydata.memory.api.MemoryServiceApi
    public void markContextAwarenessConfigured() {
        this.$$delegate_0.markContextAwarenessConfigured();
    }

    @Override // com.obric.memorydata.memory.api.MemoryServiceApi
    public void onSemanticMemoryDeleted(List<Long> r3) {
        List<Long> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "deletedItemIds");
        this.$$delegate_0.onSemanticMemoryDeleted(r4);
    }

    @Override // com.obric.memorydata.memory.api.MemoryServiceApi
    public void onSemanticMigrationUnblocked() {
        this.$$delegate_0.onSemanticMigrationUnblocked();
    }

    @Override // com.obric.memorydata.memory.api.MemoryServiceApi
    public boolean reportInAppTrace(List<b> r3) {
        List<b> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "items");
        return this.$$delegate_0.reportInAppTrace(r4);
    }

    @Override // com.obric.memorydata.memory.api.MemoryServiceApi
    public boolean reportMemoryTraceOps(String r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "logId");
        Intrinsics.checkNotNullParameter(r3, AILabCheckPermissionTask.KEY_SOURCE);
        Intrinsics.checkNotNullParameter(r4, "memoryOpsJson");
        return this.$$delegate_0.reportMemoryTraceOps(r2, r3, r4);
    }

    @Override // com.obric.memorydata.memory.api.MemoryServiceApi
    public void requestInAppRuleSync() {
        this.$$delegate_0.requestInAppRuleSync();
    }

    @Override // com.obric.memorydata.memory.api.MemoryServiceApi
    public String requestInAppSignalFlush(long r1) {
        return this.$$delegate_0.requestInAppSignalFlush(r1);
    }

    @Override // com.obric.memorydata.memory.api.MemoryServiceApi
    public String resolveAutoMemoryIconKey(String r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "semanticKey");
        Intrinsics.checkNotNullParameter(r3, "oldIconKey");
        Intrinsics.checkNotNullParameter(r4, "stableSeed");
        return this.$$delegate_0.resolveAutoMemoryIconKey(r2, r3, r4);
    }

    @Override // com.obric.memorydata.memory.api.MemoryServiceApi
    public void runAfterRawMemoryTranslateTask() {
        this.$$delegate_0.runAfterRawMemoryTranslateTask();
    }

    @Override // com.obric.memorydata.memory.api.MemoryServiceApi
    public boolean updateCollectionRule(long r2, String r4) {
        Intrinsics.checkNotNullParameter(r4, Params.CONTENT);
        return this.$$delegate_0.updateCollectionRule(r2, r4);
    }

    @Override // com.obric.memorydata.memory.api.MemoryServiceApi
    public void updateInAppSignalCollectionPackages(List<String> r3) {
        List<String> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "packageNames");
        this.$$delegate_0.updateInAppSignalCollectionPackages(r4);
    }
}
