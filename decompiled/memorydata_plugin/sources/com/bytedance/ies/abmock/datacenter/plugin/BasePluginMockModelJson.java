package com.bytedance.ies.abmock.datacenter.plugin;

import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes2.dex */
public abstract class BasePluginMockModelJson {
    protected StringBuilder mockModelJsonBuilder;

    public BasePluginMockModelJson() {
    }

    public String getMockModelJson() {
        StringBuilder r0 = this.mockModelJsonBuilder;
        if (r0 != null) goto L6;
        return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
    L6:
        return r0.toString();
    }
}
