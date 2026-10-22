package com.bytedance.android.live.network.api;

import am3.c;
import android.view.View;
import com.bytedance.android.livehostapi.foundation.IHostNetwork;
import java.util.Map;
import py.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public interface INetworkService extends IHostNetwork, IMiddlewareNetworkService {
    void ensureFeedProtoInjected(Runnable r1);

    @Override // com.bytedance.android.live.network.api.IMiddlewareNetworkService
    void injectProtoDecoders(Map<Class, c> r1);

    @Override // com.bytedance.android.live.network.api.IMiddlewareNetworkService
    void loadNinePatchDrawable(k r1, View r2, boolean r3, Runnable r4);

    void putCommonParams(Map<String, String> r1);

    void setEnsureProtoDecodersInjected(Runnable r1);
}
