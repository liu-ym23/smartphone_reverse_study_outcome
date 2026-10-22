package com.bytedance.crash.event;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class BizException {
    private Map<String, String> customData;
    private Map<String, String> filters;
    private String message;
    private Throwable throwable;

    public BizException(Throwable r3, String r4, Map<String, String> r5, Map<String, String> r6) {
        Map<String, String> r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.memorydata.plugin");
        Map<String, String> r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.memorydata.plugin");
        this.throwable = r3;
        this.message = r4;
        this.filters = r7;
        this.customData = r8;
    }

    public Map<String, String> getCustomData() {
        return this.customData;
    }

    public Map<String, String> getFilters() {
        return this.filters;
    }

    public String getMessage() {
        return this.message;
    }

    public Throwable getThrowable() {
        return this.throwable;
    }
}
