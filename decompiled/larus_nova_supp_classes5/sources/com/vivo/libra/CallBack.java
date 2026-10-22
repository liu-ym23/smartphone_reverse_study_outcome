package com.vivo.libra;

import android.os.Bundle;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public interface CallBack {
    public static final String EVENT_APP_DEVICE_POWER = "ADP";
    public static final String EVENT_POWER_MODE = "PM";
    public static final String EVENT_SHELL_TEMP = "ST";
    public static final String EVENT_SLEEP_MODE = "SM";
    public static final String EVENT_THERMAL_RISK_LEVEL = "TRL";
    public static final String EVENT_THREAD_ABNORMAL = "TA";

    void onCallBack(String r1, int r2, Bundle r3);
}
