package com.lynx.config;

import com.lynx.BuildConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class LynxLiteConfigs {
    public LynxLiteConfigs() {
    }

    public static boolean enableNewFresco() {
        return !BuildConfig.enable_lite.booleanValue();
    }

    public static boolean enableNewGesture() {
        return !BuildConfig.enable_lite.booleanValue();
    }

    public static boolean enablePrimJSTrail() {
        return !BuildConfig.enable_lite.booleanValue();
    }

    public static boolean requireQuickSharedLibrary() {
        return !BuildConfig.enable_lite.booleanValue();
    }

    public static boolean supportCustomEmojiInInput() {
        return !BuildConfig.enable_lite.booleanValue();
    }

    public static boolean supportCustomEmojiInText() {
        return !BuildConfig.enable_lite.booleanValue();
    }
}
