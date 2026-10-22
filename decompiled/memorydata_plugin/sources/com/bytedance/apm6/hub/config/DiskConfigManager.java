package com.bytedance.apm6.hub.config;

import com.bytedance.apm.util.n;
import com.bytedance.apm6.disk.Constants;
import com.bytedance.apm6.disk.DiskCollector;
import com.bytedance.apm6.disk.config.DiskConfig;
import com.bytedance.apm6.disk.config.DiskConfigService;
import com.bytedance.apm6.foundation.context.ApmContext;
import com.bytedance.apm6.hub.config.internal.ConfigManager;
import com.bytedance.apm6.hub.config.internal.SlardarSettingsConstants;
import com.bytedance.apm6.util.log.Logger;
import com.obric.cae.userAware.WifiScanStateMachine;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class DiskConfigManager implements DiskConfigService {
    private static final int DEFAULT_EXCEPTION_DIR_COUNT = 50;
    private static final int DEFAULT_FILE_SIZE = 100;
    private static final int DEFAULT_OUTDATED_COUNT = 50;
    private static final int DEFAULT_TOP_FILE_COUNT = 20;
    private DiskConfig config;

    public DiskConfigManager() {
        ConfigManager.getInstance().init();
        ConfigManager.getInstance().registerConfigListener(new AnonymousClass1(this));
    }

    static /* synthetic */ void access$000(DiskConfigManager r0, JSONObject r1, boolean r2) {
        r0.parseConfig(r1, r2);
    }

    private void parseConfig(JSONObject r7, boolean r8) {
        JSONObject r9 = r7.optJSONObject(SlardarSettingsConstants.SETTING_PERFORMANCE_MODULES);
        if (r9 != null) goto L5;
        return;
    L5:
        JSONObject r10 = r9.optJSONObject(SlardarSettingsConstants.PERF_KEY_DISK);
        if (r10 != null) goto L9;
        return;
    L9:
        if (ApmContext.isDebugMode() == false) goto L11;
        Logger.d(Constants.TAG, "parseConfig:" + r10);
    L11:
        DiskConfig r11 = new DiskConfig();
        boolean r3 = false;
        if (r10.optInt(SlardarSettingsConstants.PERF_KEY_ENABLE_UPLOAD, 0) != 1) goto L14;
        r3 = true;
    L14:
        r11.setSample(r3);
        if (r10.optInt(SlardarSettingsConstants.PERF_DISK_KEY_DUMP_THRESHOLD) <= 0) goto L18;
        r11.setDiskThresholdBytes((((long) r10.optInt(SlardarSettingsConstants.PERF_DISK_KEY_DUMP_THRESHOLD)) * 1024) * 1024);
    L18:
        if (r10.optInt(SlardarSettingsConstants.PERF_DISK_KEY_ABNORMAL_FOLDER_SIZE) <= 0) goto L20;
        r11.setFolderThresholdBytes((((long) r10.optInt(SlardarSettingsConstants.PERF_DISK_KEY_ABNORMAL_FOLDER_SIZE)) * 1024) * 1024);
    L20:
        r11.setFileThresholdBytes(((long) r10.optInt(SlardarSettingsConstants.PERF_DISK_KEY_ABNORMAL_FILE_SIZE, 100)) * 1024);
        if (r10.optInt(SlardarSettingsConstants.PERF_DISK_KEY_DUMP_TOP_COUNT) <= 0) goto L23;
        r11.setReportMaxCount(r10.optInt(SlardarSettingsConstants.PERF_DISK_KEY_DUMP_TOP_COUNT));
    L23:
        r11.setReportMaxOutdatedCount(r10.optInt(SlardarSettingsConstants.PERF_DISK_KEY_DUMP_OUTDATED_COUNT, 50));
        r11.setReportMaxTopCount(r10.optInt(SlardarSettingsConstants.PERF_DISK_KEY_DUMP_TOP_FILE_COUNT, 20));
        r11.setReportExceptionDirMaxCount(r10.optInt(SlardarSettingsConstants.PERF_DISK_KEY_DUMP_TOP_EXCEPTION_DIR_COUNT, 50));
        if (r10.optInt(SlardarSettingsConstants.PERF_DISK_KEY_OUTDATED_DAYS) <= 0) goto L26;
        r11.setOutdatedIntervalMs(((long) r10.optInt(SlardarSettingsConstants.PERF_DISK_KEY_OUTDATED_DAYS)) * WifiScanStateMachine.WAKE_LOCK_TIMEOUT_1_DATE_MS);
    L26:
        r11.setCustomRelativePaths(n.c(r10, SlardarSettingsConstants.PERF_DISK_KEY_DISK_CUSTOMED_PATHS));
        r11.setIgnoredRelativePaths(n.b(r10, SlardarSettingsConstants.PERF_DISK_KEY_IGNORED_RELATIVE_PATHS));
        r11.setComplianceRelativePaths(n.b(r10, SlardarSettingsConstants.PERF_DISK_KEY_COMPLIANCE_RELATIVE_PATHS));
        this.config = r11;
        if (ApmContext.isDebugMode() == false) goto L29;
        Logger.d(Constants.TAG, "parseConfig:" + r10);
    L29:
        DiskCollector.getInstance().updateConfig(getConfig());
    }

    @Override // com.bytedance.apm6.disk.config.DiskConfigService
    public DiskConfig getConfig() {
        return this.config;
    }
}
