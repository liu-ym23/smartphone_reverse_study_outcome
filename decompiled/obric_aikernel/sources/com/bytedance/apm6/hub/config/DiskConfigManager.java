package com.bytedance.apm6.hub.config;

import com.bytedance.apm.util.p;
import com.bytedance.apm6.disk.Constants;
import com.bytedance.apm6.disk.DiskCollector;
import com.bytedance.apm6.disk.config.DiskConfig;
import com.bytedance.apm6.disk.config.DiskConfigService;
import com.bytedance.apm6.hub.config.internal.ConfigManager;
import com.bytedance.apm6.hub.config.internal.SlardarSettingsConstants;
import com.bytedance.apm6.util.ApmBaseContext;
import com.bytedance.apm6.util.log.Logger;
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

    static /* synthetic */ void access$000(DiskConfigManager r10, JSONObject r11, boolean r12) {
        r10.parseConfig(r11, r12);
    }

    private void parseConfig(JSONObject r10, boolean r11) {
        JSONObject r12 = r10.optJSONObject(SlardarSettingsConstants.SETTING_PERFORMANCE_MODULES);
        if (r12 != null) goto L5;
        return;
    L5:
        JSONObject r13 = r12.optJSONObject(SlardarSettingsConstants.PERF_KEY_DISK);
        if (r13 != null) goto L9;
        return;
    L9:
        if (ApmBaseContext.isDebugMode() == false) goto L11;
        Logger.d(Constants.TAG, "parseConfig:" + r13);
    L11:
        DiskConfig r14 = new DiskConfig();
        boolean r15 = false;
        if (r13.optInt(SlardarSettingsConstants.PERF_KEY_ENABLE_UPLOAD, 0) != 1) goto L14;
        r15 = true;
    L14:
        r14.setSample(r15);
        if (r13.optInt(SlardarSettingsConstants.PERF_DISK_KEY_DUMP_THRESHOLD) <= 0) goto L18;
        r14.setDiskThresholdBytes((((long) r13.optInt(SlardarSettingsConstants.PERF_DISK_KEY_DUMP_THRESHOLD)) * 1024) * 1024);
    L18:
        if (r13.optInt(SlardarSettingsConstants.PERF_DISK_KEY_ABNORMAL_FOLDER_SIZE) <= 0) goto L20;
        r14.setFolderThresholdBytes((((long) r13.optInt(SlardarSettingsConstants.PERF_DISK_KEY_ABNORMAL_FOLDER_SIZE)) * 1024) * 1024);
    L20:
        r14.setFileThresholdBytes(((long) r13.optInt(SlardarSettingsConstants.PERF_DISK_KEY_ABNORMAL_FILE_SIZE, 100)) * 1024);
        if (r13.optInt(SlardarSettingsConstants.PERF_DISK_KEY_DUMP_TOP_COUNT) <= 0) goto L23;
        r14.setReportMaxCount(r13.optInt(SlardarSettingsConstants.PERF_DISK_KEY_DUMP_TOP_COUNT));
    L23:
        r14.setReportMaxOutdatedCount(r13.optInt(SlardarSettingsConstants.PERF_DISK_KEY_DUMP_OUTDATED_COUNT, 50));
        r14.setReportMaxTopCount(r13.optInt(SlardarSettingsConstants.PERF_DISK_KEY_DUMP_TOP_FILE_COUNT, 20));
        r14.setReportExceptionDirMaxCount(r13.optInt(SlardarSettingsConstants.PERF_DISK_KEY_DUMP_TOP_EXCEPTION_DIR_COUNT, 50));
        if (r13.optInt(SlardarSettingsConstants.PERF_DISK_KEY_OUTDATED_DAYS) <= 0) goto L26;
        r14.setOutdatedIntervalMs(((long) r13.optInt(SlardarSettingsConstants.PERF_DISK_KEY_OUTDATED_DAYS)) * 86400000);
    L26:
        r14.setCustomRelativePaths(p.e(r13, SlardarSettingsConstants.PERF_DISK_KEY_DISK_CUSTOMED_PATHS));
        r14.setIgnoredRelativePaths(p.d(r13, SlardarSettingsConstants.PERF_DISK_KEY_IGNORED_RELATIVE_PATHS));
        r14.setComplianceRelativePaths(p.d(r13, SlardarSettingsConstants.PERF_DISK_KEY_COMPLIANCE_RELATIVE_PATHS));
        this.config = r14;
        if (ApmBaseContext.isDebugMode() == false) goto L29;
        Logger.d(Constants.TAG, "parseConfig:" + r13);
    L29:
        DiskCollector.getInstance().updateConfig(getConfig());
    }

    @Override // com.bytedance.apm6.disk.config.DiskConfigService
    public DiskConfig getConfig() {
        return this.config;
    }
}
