package com.bytedance.crash.event;

import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class BizExceptionConfig {
    private boolean isEnableUpload;
    private Set<String> sampledLogTypes;

    public BizExceptionConfig(boolean r10, Set<String> r11) {
        this.isEnableUpload = r10;
        this.sampledLogTypes = r11;
    }

    public String getSampleType() {
        Set<String> r10 = this.sampledLogTypes;
        if (r10 != null) goto L7;
        return "null";
    L7:
        return r10.toString();
    }

    public boolean isEnable() {
        return this.isEnableUpload;
    }

    public boolean isSampled(String r10) {
        Set<String> r11 = this.sampledLogTypes;
        if (r11 != null) goto L7;
        return false;
    L7:
        return r11.contains(r10);
    }

    public String toString() {
        return "BizExceptionConfig{isEnableUpload=" + this.isEnableUpload + ", sampledLogTypes=" + this.sampledLogTypes + '}';
    }
}
