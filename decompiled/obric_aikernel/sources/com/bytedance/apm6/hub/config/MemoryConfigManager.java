package com.bytedance.apm6.hub.config;

import com.bytedance.apm6.hub.config.internal.ConfigConstants;
import com.bytedance.apm6.hub.config.internal.ConfigManager;
import com.bytedance.apm6.hub.config.internal.SlardarSettingsConstants;
import com.bytedance.apm6.memory.MemoryCollector;
import com.bytedance.apm6.memory.config.MemoryConfig;
import com.bytedance.apm6.memory.config.MemoryConfigService;
import com.bytedance.apm6.util.ApmBaseContext;
import com.bytedance.apm6.util.log.Logger;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class MemoryConfigManager implements MemoryConfigService {
    private static final String PERF_KEY_COLLECT_INTERVAL = "collect_interval";
    private static final String PERF_MEMORY_REACHTOP_RATE = "reach_top_memory_rate";
    private MemoryConfig config;

    public MemoryConfigManager() {
        ConfigManager.getInstance().init();
        ConfigManager.getInstance().registerConfigListener(new AnonymousClass1(this));
    }

    static /* synthetic */ void access$000(MemoryConfigManager r10, JSONObject r11, boolean r12) {
        r10.parseConfig(r11, r12);
    }

    private void parseConfig(JSONObject r11, boolean r12) {
        JSONObject r13 = r11.optJSONObject(SlardarSettingsConstants.SETTING_PERFORMANCE_MODULES);
        if (r13 != null) goto L5;
        return;
    L5:
        JSONObject r14 = r13.optJSONObject(SlardarSettingsConstants.PERF_KEY_MEMORY);
        if (r14 != null) goto L8;
        return;
    L8:
        long r10 = r14.optLong("collect_interval", 120);
        double r15 = r14.optDouble(PERF_MEMORY_REACHTOP_RATE, 0.8d);
        boolean r16 = true;
        if (r14.optInt(SlardarSettingsConstants.PERF_KEY_ENABLE_UPLOAD, 0) != 1) goto L11;
        boolean r17 = true;
    L13:
        if (r14.optInt(SlardarSettingsConstants.PERF_MEMORY_CLOSE_COLLECT) != 1) goto L16;
        r16 = false;
    L16:
        this.config = new MemoryConfig(r10, r15, false, false, r17, r16);
        if (ApmBaseContext.isDebugMode() == false) goto L19;
        Logger.d(ConfigConstants.LOG_TAG, "parsed MemoryConfig=" + this.config);
    L19:
        MemoryCollector.getInstance().updateConfig(getConfig());
        return;
    L11:
        r17 = false;
        goto L13
    }

    @Override // com.bytedance.apm6.memory.config.MemoryConfigService
    public MemoryConfig getConfig() {
        return this.config;
    }
}
