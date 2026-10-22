package com.bytedance.crash.event;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class BizExceptionConfig {
    private boolean isEnableUpload;
    private Set<String> sampledLogTypes;

    public BizExceptionConfig(boolean r3, Set<String> r4) {
        Set<String> r5 = (Set) ZeusTransformUtils.wrapperContextForParams(r4, Set.class, "com.obric.memorydata.plugin");
        this.isEnableUpload = r3;
        this.sampledLogTypes = r5;
    }

    public String getSampleType() {
        Set<String> r0 = this.sampledLogTypes;
        if (r0 != null) goto L7;
        return "null";
    L7:
        return r0.toString();
    }

    public boolean isEnable() {
        return this.isEnableUpload;
    }

    public boolean isSampled(String r1) {
        Set<String> r0 = this.sampledLogTypes;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.contains(r1);
    }

    public String toString() {
        return "BizExceptionConfig{isEnableUpload=" + this.isEnableUpload + ", sampledLogTypes=" + this.sampledLogTypes + '}';
    }
}
