package com.bytedance.crypto;

import com.bytedance.crypto.bridge.IEventBridge;
import com.bytedance.crypto.bridge.ILogBridge;
import com.bytedance.crypto.utils.EventUtils;
import com.bytedance.crypto.utils.LogUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public class CryptoSdk {
    public CryptoSdk() {
    }

    public static void initEventReporter(IEventBridge r2) {
        EventUtils.init((IEventBridge) ZeusTransformUtils.wrapperContextForParams(r2, IEventBridge.class, "com.obric.memorydata.plugin"));
    }

    public static void initLogger(ILogBridge r2) {
        LogUtils.init((ILogBridge) ZeusTransformUtils.wrapperContextForParams(r2, ILogBridge.class, "com.obric.memorydata.plugin"));
    }
}
