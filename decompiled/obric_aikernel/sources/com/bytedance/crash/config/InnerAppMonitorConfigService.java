package com.bytedance.crash.config;

import androidx.annotation.NonNull;
import com.bytedance.crash.dumper.BytestConfig;
import com.bytedance.crash.event.EnsureConfig;
import com.bytedance.crash.monitor.AppMonitorConfigService;
import com.bytedance.crash.monitor.CrashListener;
import com.bytedance.crash.util.NpthDiskMonitor;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class InnerAppMonitorConfigService extends AppMonitorConfigService {
    public InnerAppMonitorConfigService(CrashListener r10) {
        super(r10);
    }

    @Override // com.bytedance.crash.monitor.EventConfigService
    @NonNull
    protected ConfigManager createConfigManager() {
        return new InnerConfigManager(this.monitor);
    }

    @Override // com.bytedance.crash.monitor.EventConfigService
    protected void parseEnsureConfig(JSONObject r10) {
        if (BytestConfig.isEnsureNoLimit() == false) goto L5;
        this.ensureConfig = new EnsureConfig(true);
        return;
    L5:
        super.parseEnsureConfig(r10);
    }

    @Override // com.bytedance.crash.monitor.EventConfigService
    protected void parseEventConfig(JSONObject r10) {
        super.parseEventConfig(r10);
        if (this.eventConfig == null) goto L6;
        NpthDiskMonitor.getInstance().setConfig(this.eventConfig);
        return;
    }

    @Override // com.bytedance.crash.monitor.AppMonitorConfigService
    protected void parseUploadLimits(JSONObject r10) {
        super.parseUploadLimits(r10);
    }
}
