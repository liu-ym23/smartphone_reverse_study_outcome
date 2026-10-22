package com.bytedance.crash.config;

import com.bytedance.crash.dumper.BytestConfig;
import com.bytedance.crash.event.EnsureConfig;
import com.bytedance.crash.monitor.AppMonitorConfigService;
import com.bytedance.crash.monitor.CrashListener;
import com.bytedance.crash.util.NpthDiskMonitor;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class InnerAppMonitorConfigService extends AppMonitorConfigService {
    public InnerAppMonitorConfigService(CrashListener r1) {
        super(r1);
    }

    @Override // com.bytedance.crash.monitor.EventConfigService
    public ConfigManager createConfigManager() {
        return new InnerConfigManager(this.monitor);
    }

    @Override // com.bytedance.crash.monitor.EventConfigService
    public void parseEnsureConfig(JSONObject r2) {
        if (BytestConfig.isEnsureNoLimit() == false) goto L5;
        this.ensureConfig = new EnsureConfig(true);
        return;
    L5:
        super.parseEnsureConfig(r2);
    }

    @Override // com.bytedance.crash.monitor.EventConfigService
    public void parseEventConfig(JSONObject r1) {
        super.parseEventConfig(r1);
        if (this.eventConfig == null) goto L6;
        NpthDiskMonitor.getInstance().setConfig(this.eventConfig);
        return;
    }

    @Override // com.bytedance.crash.monitor.AppMonitorConfigService
    public void parseUploadLimits(JSONObject r1) {
        super.parseUploadLimits(r1);
    }
}
