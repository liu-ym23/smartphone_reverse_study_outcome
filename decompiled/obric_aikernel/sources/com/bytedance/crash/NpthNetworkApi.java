package com.bytedance.crash;

import com.bytedance.crash.service.IHttpService;
import com.bytedance.crash.service.INetworkCallback;
import com.bytedance.crash.service.IRequestHeaderProvider;

/* JADX INFO: loaded from: classes.dex */
public class NpthNetworkApi {
    private static IRequestHeaderProvider headerProvider;
    private static IHttpService httpService;
    private static INetworkCallback networkCallback;

    public NpthNetworkApi() {
    }

    public static IHttpService getHttpService() {
        return httpService;
    }

    public static INetworkCallback getNetworkCallback() {
        return networkCallback;
    }

    public static IRequestHeaderProvider getRequestHeaderProvider() {
        return headerProvider;
    }

    public static void setHttpService(IHttpService r10) {
        httpService = r10;
    }

    public static void setNetworkCallback(INetworkCallback r10) {
        networkCallback = r10;
    }

    public static void setRequestHeaderProvider(IRequestHeaderProvider r10) {
        headerProvider = r10;
    }
}
