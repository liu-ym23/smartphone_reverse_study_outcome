package com.bytedance.apm6.commonevent.config;

import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class CommonEventConfig {
    private Set<String> sampledLogType;
    private Set<String> sampledService;

    public CommonEventConfig(Set<String> r10, Set<String> r11) {
        this.sampledService = r10;
        this.sampledLogType = r11;
    }

    public boolean isSampledLogType(String r10) {
        Set<String> r11 = this.sampledLogType;
        if (r11 != null) goto L5;
    L7:
        return false;
    L5:
        if (r11.contains(r10) == false) goto L7;
        return true;
    }

    public boolean isSampledService(String r10) {
        Set<String> r11 = this.sampledService;
        if (r11 != null) goto L5;
    L7:
        return false;
    L5:
        if (r11.contains(r10) == false) goto L7;
        return true;
    }

    public String toString() {
        return "CommonEventConfig{sampledService=" + this.sampledService + ", sampledLogType=" + this.sampledLogType + '}';
    }
}
