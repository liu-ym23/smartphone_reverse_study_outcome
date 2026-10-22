package com.bytedance.crash.event;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class EventConfig {
    private static boolean isStopped;
    private boolean isAllSample;
    private Set<String> sampledService;

    public EventConfig(Set<String> r3) {
        this.sampledService = (Set) ZeusTransformUtils.wrapperContextForParams(r3, Set.class, "com.obric.memorydata.plugin");
    }

    public EventConfig(boolean r1) {
        this.isAllSample = r1;
    }

    public static void setStopEnable(boolean r0) {
        isStopped = r0;
    }

    public boolean isSampled(String r4) {
        if (isStopped == false) goto L6;
        return false;
    L6:
        if (this.isAllSample == false) goto L8;
        return true;
    L8:
        Set<String> r3 = this.sampledService;
        if (r3 != null) goto L11;
        return false;
    L11:
        if (r3.contains(r4) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public String toString() {
        return "EventConfig{sampledService=" + this.sampledService + ", isAllSample=" + this.isAllSample + '}';
    }
}
