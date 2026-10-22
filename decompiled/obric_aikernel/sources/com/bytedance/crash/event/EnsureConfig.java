package com.bytedance.crash.event;

import java.util.Set;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class EnsureConfig {
    private static boolean isStopped;
    private JSONObject exceptionMessage;
    private boolean isAllEnable;
    private boolean isUploadEnable;
    private Set<String> sampledLogType;

    public EnsureConfig(Set<String> r10, JSONObject r11, boolean r12) {
        this.sampledLogType = r10;
        this.isUploadEnable = r12;
        if (r11 == null) goto L5;
        this.exceptionMessage = r11;
        return;
    L5:
        this.exceptionMessage = new JSONObject();
    }

    public EnsureConfig(boolean r10) {
        this.isAllEnable = r10;
    }

    public static void setStopEnable(boolean r10) {
        isStopped = r10;
    }

    public boolean isMessageSample(String r10) {
        if (this.isAllEnable == false) goto L5;
        return true;
    L5:
        JSONObject r11 = this.exceptionMessage;
        if (r11 == null) goto L12;
        double r12 = r11.optDouble(r10, 1.0d);
        if (Math.random() <= r12) goto L13;
        return false;
    L13:
        return true;
    L12:
        return true;
    }

    public boolean isSample(String r10) {
        if (isStopped == false) goto L6;
        return false;
    L6:
        if (this.isAllEnable == false) goto L9;
        return true;
    L9:
        if ("core_exception_monitor".equals(r10) == true) goto L11;
        Set<String> r11 = this.sampledLogType;
        if (r11 != null) goto L15;
        return false;
    L15:
        if (r11.contains(r10) == true) goto L17;
        return false;
    L17:
        return true;
    L11:
        return this.isUploadEnable;
    }

    public boolean isSample(String r10, String r11) {
        if (isStopped == false) goto L6;
        return false;
    L6:
        if (isSample(r10) == true) goto L9;
        return false;
    L9:
        return isMessageSample(r11);
    }

    public boolean isUploadEnable() {
        if (this.isAllEnable == false) goto L5;
    L8:
        return true;
    L5:
        if (this.isUploadEnable == true) goto L8;
        return false;
    }

    public String toString() {
        return "EnsureConfig{sampledLogType=" + this.sampledLogType + ", isCoreExceptionEnable=" + this.isUploadEnable + ", exceptionMessage=" + this.exceptionMessage + ", isAllEnable=" + this.isAllEnable + '}';
    }
}
