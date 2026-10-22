package com.bytedance.crash.event;

import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class EventConfig {
    private static boolean isStopped;
    private boolean isAllSample;
    private Set<String> sampledService;

    public EventConfig(Set<String> r10) {
        this.sampledService = r10;
    }

    public EventConfig(boolean r10) {
        this.isAllSample = r10;
    }

    public static void setStopEnable(boolean r10) {
        isStopped = r10;
    }

    public boolean isSampled(String r10) {
        if (isStopped == false) goto L6;
        return false;
    L6:
        if (this.isAllSample == false) goto L8;
        return true;
    L8:
        Set<String> r11 = this.sampledService;
        if (r11 != null) goto L11;
        return false;
    L11:
        if (r11.contains(r10) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public String toString() {
        return "EventConfig{sampledService=" + this.sampledService + ", isAllSample=" + this.isAllSample + '}';
    }
}
