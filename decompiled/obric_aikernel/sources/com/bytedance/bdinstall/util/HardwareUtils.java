package com.bytedance.bdinstall.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.provider.Settings;

/* JADX INFO: loaded from: classes.dex */
public class HardwareUtils {
    public HardwareUtils() {
    }

    @SuppressLint({"HardwareIds"})
    public static String getSecureAndroidId(Context r10) {
        return Settings.Secure.getString(r10.getContentResolver(), "android_id");
    L4:
        e = move-exception;
        e.printStackTrace();
        return null;
    }
}
