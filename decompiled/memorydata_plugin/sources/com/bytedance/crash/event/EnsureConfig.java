package com.bytedance.crash.event;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Set;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class EnsureConfig {
    private static boolean isStopped;
    private JSONObject exceptionMessage;
    private boolean isAllEnable;
    private boolean isUploadEnable;
    private Set<String> sampledLogType;

    public EnsureConfig(Set<String> r3, JSONObject r4, boolean r5) {
        this.sampledLogType = (Set) ZeusTransformUtils.wrapperContextForParams(r3, Set.class, "com.obric.memorydata.plugin");
        this.isUploadEnable = r5;
        if (r4 == null) goto L5;
        this.exceptionMessage = r4;
        return;
    L5:
        this.exceptionMessage = new JSONObject();
    }

    public EnsureConfig(boolean r1) {
        this.isAllEnable = r1;
    }

    public static void setStopEnable(boolean r0) {
        isStopped = r0;
    }

    public boolean isMessageSample(String r5) {
        if (this.isAllEnable == false) goto L5;
        return true;
    L5:
        JSONObject r4 = this.exceptionMessage;
        if (r4 == null) goto L12;
        double r6 = r4.optDouble(r5, 1.0d);
        if (Math.random() <= r6) goto L13;
        return false;
    L13:
        return true;
    L12:
        return true;
    }

    public boolean isSample(String r4) {
        if (isStopped == false) goto L6;
        return false;
    L6:
        if (this.isAllEnable == false) goto L9;
        return true;
    L9:
        if ("core_exception_monitor".equals(r4) == true) goto L11;
        Set<String> r3 = this.sampledLogType;
        if (r3 != null) goto L15;
        return false;
    L15:
        if (r3.contains(r4) == true) goto L17;
        return false;
    L17:
        return true;
    L11:
        return this.isUploadEnable;
    }

    public boolean isSample(String r3, String r4) {
        if (isStopped == false) goto L6;
        return false;
    L6:
        if (isSample(r3) == true) goto L9;
        return false;
    L9:
        return isMessageSample(r4);
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
