package com.bytedance.frameworks.baselib.network.http.cronet;

/* JADX INFO: loaded from: classes.dex */
public interface ICronetDepend {
    String getSsCookieKey();

    void loggerD(String r8, String r10);

    boolean loggerDebug();

    void setAdapter(ICronetDepend r8);
}
