package com.bytedance.ies.web.jsbridge2;

import androidx.annotation.Keep;

/* JADX INFO: loaded from: classes2.dex */
@Keep
public interface IJsBridge2Config {
    e getConfigurator();

    g getGlobalBridgeInterceptor();

    h getGlobalCallListener();

    n getSwitchConfig();
}
