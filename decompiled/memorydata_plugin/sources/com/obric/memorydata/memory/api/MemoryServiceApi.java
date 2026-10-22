package com.obric.memorydata.memory.api;

import android.graphics.drawable.Drawable;
import com.bytedance.news.common.service.manager.IService;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.aikernel.sdk.ext.Params;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.FileEntity;
import com.obric.memorydata.memory.lab.AILabCheckPermissionTask;
import java.util.List;
import kotlin.Metadata;
import kotlinx.coroutines.flow.ar;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH&J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fH&J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000fH&J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u0013H&J\b\u0010\u0014\u001a\u00020\u0003H&J\b\u0010\u0015\u001a\u00020\u0006H&J\b\u0010\u0016\u001a\u00020\u0006H&J\b\u0010\u0017\u001a\u00020\u0003H&J\u000e\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&J\u0018\u0010\u0019\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u0013H&J\u0010\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\fH&J\u0018\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u0013H&J \u0010\u001f\u001a\u00020\u00132\u0006\u0010 \u001a\u00020\u00132\u0006\u0010!\u001a\u00020\u00132\u0006\u0010\"\u001a\u00020\u0013H&J\u0016\u0010#\u001a\u00020\u00032\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\f0%H&J\b\u0010&\u001a\u00020\u0003H&J \u0010'\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\u00132\u0006\u0010)\u001a\u00020\u00132\u0006\u0010*\u001a\u00020\u0013H&J\u0016\u0010+\u001a\u00020\u00062\f\u0010,\u001a\b\u0012\u0004\u0012\u00020-0%H&J\u0016\u0010.\u001a\u00020\u00032\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00130%H&J\u0010\u00100\u001a\u00020\u00132\u0006\u00101\u001a\u00020\fH&J8\u00102\u001a\u00020\u00032\u0006\u00103\u001a\u00020\f2\u0006\u00101\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u00104\u001a\u00020\u00132\u0006\u00105\u001a\u00020\u00132\u0006\u00106\u001a\u00020\u0013H&J\b\u00107\u001a\u00020\u0003H&¨\u00068"}, d2 = {"Lcom/obric/memorydata/memory/api/MemoryServiceApi;", "Lcom/bytedance/news/common/service/manager/IService;", "requestInAppRuleSync", "", "experienceState", "Lkotlinx/coroutines/flow/StateFlow;", "", "indexMemory", "appEntity", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "deleteMemoryDirectly", "memoryRawDbId", "", "deleteMemoryImage", "fileEntity", "Lcom/obric/capabilitykit/entity/app/FileEntity;", "getAppIcon", "Landroid/graphics/drawable/Drawable;", ObricMemoryConstants.KEY_PACKAGE_NAME, "", "clearAppIconCache", "assistantSmartMemoryEnabled", "isAILabScreenMemoryEnabled", "markContextAwarenessConfigured", "autoMemoryEffectiveEnabled", "createAutoMemoryRule", "title", Params.CONTENT, "deleteCollectionRule", "ruleId", "updateCollectionRule", "resolveAutoMemoryIconKey", "semanticKey", "oldIconKey", "stableSeed", "onSemanticMemoryDeleted", "deletedItemIds", "", "runAfterRawMemoryTranslateTask", "reportMemoryTraceOps", "logId", AILabCheckPermissionTask.KEY_SOURCE, "memoryOpsJson", "reportInAppTrace", "items", "Lcom/obric/memorydata/memory/api/InAppTraceReportItem;", "updateInAppSignalCollectionPackages", "packageNames", "requestInAppSignalFlush", "screenshotTimestamp", "associateInAppTraceWithScreenshot", "observationId", "screenshotPath", "viewTreePath", "flushRequestId", "onSemanticMigrationUnblocked", "memory_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface MemoryServiceApi extends IService {
    boolean assistantSmartMemoryEnabled();

    void associateInAppTraceWithScreenshot(long r1, long r3, String r5, String r6, String r7, String r8);

    ar<Boolean> autoMemoryEffectiveEnabled();

    void clearAppIconCache();

    long createAutoMemoryRule(String r1, String r2);

    boolean deleteCollectionRule(long r1);

    boolean deleteMemoryDirectly(long r1);

    void deleteMemoryImage(FileEntity r1);

    ar<Boolean> experienceState();

    Drawable getAppIcon(String r1);

    void indexMemory(AppEntity r1);

    boolean isAILabScreenMemoryEnabled();

    void markContextAwarenessConfigured();

    void onSemanticMemoryDeleted(List<Long> r1);

    void onSemanticMigrationUnblocked();

    boolean reportInAppTrace(List<b> r1);

    boolean reportMemoryTraceOps(String r1, String r2, String r3);

    void requestInAppRuleSync();

    String requestInAppSignalFlush(long r1);

    String resolveAutoMemoryIconKey(String r1, String r2, String r3);

    void runAfterRawMemoryTranslateTask();

    boolean updateCollectionRule(long r1, String r3);

    void updateInAppSignalCollectionPackages(List<String> r1);
}
