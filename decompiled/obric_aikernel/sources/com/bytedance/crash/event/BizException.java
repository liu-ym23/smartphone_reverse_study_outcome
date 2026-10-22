package com.bytedance.crash.event;

import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class BizException {
    private Map<String, String> customData;
    private Map<String, String> filters;
    private String message;
    private Throwable throwable;

    public BizException(Throwable r10, String r11, Map<String, String> r12, Map<String, String> r13) {
        this.throwable = r10;
        this.message = r11;
        this.filters = r12;
        this.customData = r13;
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
