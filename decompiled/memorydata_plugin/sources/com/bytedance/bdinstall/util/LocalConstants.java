package com.bytedance.bdinstall.util;

import com.bytedance.bdinstall.BuildConfig;

/* JADX INFO: loaded from: classes.dex */
public class LocalConstants extends Constants {
    public LocalConstants() {
    }

    public static String getOldSpName() {
        return StringEncryptUtils.base64DecodeToString("Y29tLnNzLmFuZHJvaWQuZGV2aWNlcmVnaXN0ZXIudXRpbHMuQ2RpZA==");
    }

    public static int getVersionCode() {
        return BuildConfig.BDINSTALL_VERSION_CODE;
    }
}
