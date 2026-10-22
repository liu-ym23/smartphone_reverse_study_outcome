package com.bytedance.crypto;

import com.bytedance.crypto.bridge.IEventBridge;
import com.bytedance.crypto.bridge.ILogBridge;
import com.bytedance.crypto.utils.EventUtils;
import com.bytedance.crypto.utils.LogUtils;

/* JADX INFO: loaded from: classes.dex */
public class CryptoSdk {
    public CryptoSdk() {
    }

    public static void initEventReporter(IEventBridge r10) {
        EventUtils.init(r10);
    }

    public static void initLogger(ILogBridge r10) {
        LogUtils.init(r10);
    }
}
