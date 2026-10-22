package com.bytedance.crypto;

import com.bytedance.crypto.bridge.IEventBridge;
import com.bytedance.crypto.bridge.ILogBridge;
import com.bytedance.crypto.utils.EventUtils;
import com.bytedance.crypto.utils.LogUtils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class CryptoSdk {
    public CryptoSdk() {
    }

    public static void initEventReporter(IEventBridge r0) {
        EventUtils.init(r0);
    }

    public static void initLogger(ILogBridge r0) {
        LogUtils.init(r0);
    }
}
