package com.bytedance.android.live.network.api;

import am3.c;
import android.view.View;
import com.bytedance.android.live.base.IService;
import com.bytedance.android.livehostapi.foundation.IMiddlewareHostNetwork;
import com.google.gson.Gson;
import java.util.Map;
import py.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public interface IMiddlewareNetworkService extends IService, IMiddlewareHostNetwork {
    Map<String, String> getCommonParams();

    <T> c<T> getProtoDecoder(Class<T> r1);

    void injectProtoDecoders(Map<Class, c> r1);

    void interceptResponseBody(String r1, Object r2, String r3, String r4, String r5) throws Exception;

    void loadNinePatchDrawable(k r1, View r2, boolean r3, Runnable r4);

    Gson provideNetworkGson();

    Gson provideUploadLinkGson();
}
