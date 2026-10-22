package com.bytedance.android.live.core;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class InnerSDKCore {
    private static IInnerSDKCore sInnerSDKCore;

    public InnerSDKCore() {
    }

    public static void setLiveSDKCore(IInnerSDKCore r0) {
        sInnerSDKCore = r0;
    }
}
