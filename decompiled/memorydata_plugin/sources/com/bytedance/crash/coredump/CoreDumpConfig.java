package com.bytedance.crash.coredump;

import com.bytedance.crash.config.RuntimeConfig;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes2.dex */
public class CoreDumpConfig {
    private String configStr;
    private boolean isAsyncEnable;
    private boolean isEnable;
    private boolean isUploadEnable;
    private JSONArray nativeCrashFeature;

    public CoreDumpConfig(JSONArray r4, boolean r5, boolean r6, boolean r7) {
        this.configStr = null;
        int r1 = 0;
        if (r5 == false) goto L6;
        if (r6 == false) goto L6;
        boolean r8 = true;
    L7:
        this.isEnable = r8;
        if (r4 != null) goto L10;
    L11:
        this.isEnable = false;
    L13:
        if (this.isEnable == false) goto L20;
        StringBuffer r9 = new StringBuffer("");
        boolean r10 = "1".equals(r4.optString(0));
    L16:
        if (r1 >= r4.length()) goto L18;
        r9.append(r4.optString(r1) + "#");
        r1 = r1 + 1;
        goto L16
    L18:
        this.isEnable = r10;
        String r11 = r9.toString();
    L22:
        this.configStr = r11;
    L23:
        this.isAsyncEnable = r7;
        return;
    L20:
        if (RuntimeConfig.isLocalTest() == false) goto L23;
        this.isEnable = true;
        r11 = "1#all#all#null#lib#SIG#0#0#7#";
        goto L22
    L10:
        if (r4.length() < 10) goto L13;
    L6:
        r8 = false;
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
