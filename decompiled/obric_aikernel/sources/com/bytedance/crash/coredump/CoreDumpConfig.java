package com.bytedance.crash.coredump;

import com.bytedance.apm6.util.constant.NetConst;
import com.bytedance.crash.config.RuntimeConfig;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes.dex */
public class CoreDumpConfig {
    private String configStr;
    private boolean isAsyncEnable;
    private boolean isEnable;
    private boolean isUploadEnable;
    private JSONArray nativeCrashFeature;

    public CoreDumpConfig(JSONArray r10, boolean r11, boolean r12, boolean r13) {
        this.configStr = null;
        int r14 = 0;
        if (r11 == false) goto L6;
        if (r12 == false) goto L6;
        boolean r15 = true;
    L7:
        this.isEnable = r15;
        if (r10 != null) goto L10;
    L11:
        this.isEnable = false;
    L13:
        if (this.isEnable == false) goto L20;
        StringBuffer r16 = new StringBuffer("");
        boolean r17 = NetConst.ENCRYPT_VERISON_CODE.equals(r10.optString(0));
    L16:
        if (r14 >= r10.length()) goto L18;
        r16.append(r10.optString(r14) + "#");
        r14 = r14 + 1;
        goto L16
    L18:
        this.isEnable = r17;
        String r18 = r16.toString();
    L22:
        this.configStr = r18;
    L23:
        this.isAsyncEnable = r13;
        return;
    L20:
        if (RuntimeConfig.isLocalTest() == false) goto L23;
        this.isEnable = true;
        r18 = "1#all#all#null#lib#SIG#0#0#7#";
        goto L22
    L10:
        if (r10.length() < 10) goto L13;
    L6:
        r15 = false;
        goto L7
    }

    public String getCoreDumpConfig() {
        return this.configStr;
    }

    public JSONArray getNativeCrashFeature() {
        return this.nativeCrashFeature;
    }

    public boolean isEnable() {
        return this.isEnable;
    }

    public boolean isUploadEnable() {
        return this.isUploadEnable;
    }

    public String toString() {
        return "CoreDumpConfig{isEnable=" + this.isEnable + ", nativeCrashFeature=" + this.nativeCrashFeature + '}';
    }
}
