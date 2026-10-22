package com.bytedance.apm6;

import com.bytedance.apm.d;
import com.bytedance.apm6.hub.config.MemoryConfigManager;
import com.bytedance.apm6.memory.config.MemoryConfig;

/* JADX INFO: loaded from: classes.dex */
class DefaultMemoryConfigService extends MemoryConfigManager {
    DefaultMemoryConfigService() {
    }

    @Override // com.bytedance.apm6.hub.config.MemoryConfigManager, com.bytedance.apm6.memory.config.MemoryConfigService
    public MemoryConfig getConfig() {
        MemoryConfig r10 = super.getConfig();
        if (r10 == null) goto L5;
        r10.setRealTimeMemEnable(d.E());
        r10.setStopWhenBackground(d.L());
    L5:
        return r10;
    }
}
