package com.bytedance.apm6.hub.config;

import com.bytedance.apm6.fd.Constants;
import com.bytedance.apm6.fd.FdCollector;
import com.bytedance.apm6.fd.config.FdConfig;
import com.bytedance.apm6.fd.config.IFdConfigService;
import com.bytedance.apm6.hub.config.internal.ConfigManager;
import com.bytedance.apm6.hub.config.internal.SlardarSettingsConstants;
import com.bytedance.apm6.util.ApmBaseContext;
import com.bytedance.apm6.util.log.Logger;
import com.bytedance.crash.resource.vmmonitor.VmMonitorConfig;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class FdConfigManager implements IFdConfigService {
    private static final String PERF_FD_KEY_COUNT_THRESHOLD = "fd_count_threshold";
    private static final String PERF_KEY_FD = "fd";
    private FdConfig config;

    public FdConfigManager() {
        if (ApmBaseContext.isDebugMode() == false) goto L5;
        Logger.d(Constants.TAG, "FdConfigManager:");
    L5:
        ConfigManager.getInstance().init();
        ConfigManager.getInstance().registerConfigListener(new AnonymousClass1(this));
    }

    static /* synthetic */ void access$000(FdConfigManager r10, JSONObject r11, boolean r12) {
        r10.parseConfig(r11, r12);
    }

    private void parseConfig(JSONObject r11, boolean r12) {
        JSONObject r13 = r11.optJSONObject(SlardarSettingsConstants.SETTING_PERFORMANCE_MODULES);
        if (ApmBaseContext.isDebugMode() == false) goto L5;
        Logger.d(Constants.TAG, "parseConfig:" + r13);
    L5:
        if (r13 != null) goto L7;
        return;
    L7:
        JSONObject r14 = r13.optJSONObject(PERF_KEY_FD);
        if (r14 != null) goto L11;
        return;
    L11:
        if (ApmBaseContext.isDebugMode() == false) goto L14;
        Logger.d(Constants.TAG, "parseConfig:" + r14);
    L14:
        if (r14.optInt(SlardarSettingsConstants.PERF_KEY_ENABLE_UPLOAD, 0) != 1) goto L16;
        boolean r10 = true;
    L17:
        long r15 = r14.optInt(PERF_FD_KEY_COUNT_THRESHOLD, FdConfig.DEFAULT_FD_COUNT_THRESHOLD);
        long r16 = r14.optLong(SlardarSettingsConstants.PERF_KEY_COLLECT_INTERVAL, 10) * VmMonitorConfig.SLEEP_TIME_BEFORE_RECOVER;
        if (r16 >= 10) goto L20;
        r16 = 600000;
    L20:
        FdConfig r17 = new FdConfig(r15, r16, r10);
        if (ApmBaseContext.isDebugMode() == false) goto L23;
        Logger.d(Constants.TAG, "parseConfig:" + r17);
    L23:
        this.config = r17;
        FdCollector.getInstance().updateConfig(r17);
        return;
    L16:
        r10 = false;
        goto L17
    }

    @Override // com.bytedance.apm6.fd.config.IFdConfigService
    public FdConfig getConfig() {
        return this.config;
    }
}
