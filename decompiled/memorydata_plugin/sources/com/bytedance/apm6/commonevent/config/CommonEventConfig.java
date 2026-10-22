package com.bytedance.apm6.commonevent.config;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class CommonEventConfig {
    private Set<String> sampledLogType;
    private Set<String> sampledService;

    public CommonEventConfig(Set<String> r3, Set<String> r4) {
        Set<String> r5 = (Set) ZeusTransformUtils.wrapperContextForParams(r3, Set.class, "com.obric.memorydata.plugin");
        Set<String> r6 = (Set) ZeusTransformUtils.wrapperContextForParams(r4, Set.class, "com.obric.memorydata.plugin");
        this.sampledService = r5;
        this.sampledLogType = r6;
    }

    public boolean isSampledLogType(String r1) {
        Set<String> r0 = this.sampledLogType;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.contains(r1) == false) goto L7;
        return true;
    }

    public boolean isSampledService(String r1) {
        Set<String> r0 = this.sampledService;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.contains(r1) == false) goto L7;
        return true;
    }

    public String toString() {
        return "CommonEventConfig{sampledService=" + this.sampledService + ", sampledLogType=" + this.sampledLogType + '}';
    }
}
