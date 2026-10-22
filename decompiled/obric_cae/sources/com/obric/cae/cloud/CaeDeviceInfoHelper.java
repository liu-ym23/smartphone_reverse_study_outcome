package com.obric.cae.cloud;

import android.os.Build;

/* JADX INFO: loaded from: classes.dex */
public class CaeDeviceInfoHelper {
    private static String CAE_RELEASE_VERSION = "2.0";
    private static final String TAG = "CaeDeviceInfoHelper";

    public CaeDeviceInfoHelper() {
    }

    public static String getAppVersion() {
        return CAE_RELEASE_VERSION;
    }

    public static String getDeviceId() {
        return Build.ID;
    }

    public static String getDeviceOSVersion() {
        return Build.VERSION.RELEASE;
    }

    public static String getDeviceSerialNumber() {
        return null;
    }
}
