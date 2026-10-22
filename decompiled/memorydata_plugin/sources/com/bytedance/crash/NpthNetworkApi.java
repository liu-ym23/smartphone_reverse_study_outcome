package com.bytedance.crash;

import com.bytedance.crash.service.IHttpService;
import com.bytedance.crash.service.INetworkCallback;
import com.bytedance.crash.service.IRequestHeaderProvider;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
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

    public static void setHttpService(IHttpService r2) {
        httpService = (IHttpService) ZeusTransformUtils.wrapperContextForParams(r2, IHttpService.class, "com.obric.memorydata.plugin");
    }

    public static void setNetworkCallback(INetworkCallback r2) {
        networkCallback = (INetworkCallback) ZeusTransformUtils.wrapperContextForParams(r2, INetworkCallback.class, "com.obric.memorydata.plugin");
    }

    public static void setRequestHeaderProvider(IRequestHeaderProvider r2) {
        headerProvider = (IRequestHeaderProvider) ZeusTransformUtils.wrapperContextForParams(r2, IRequestHeaderProvider.class, "com.obric.memorydata.plugin");
    }
}
