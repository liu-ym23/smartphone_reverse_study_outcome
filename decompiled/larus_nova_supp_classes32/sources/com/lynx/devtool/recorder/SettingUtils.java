package com.lynx.devtool.recorder;

import android.content.Context;
import android.content.SharedPreferences;
import com.lynx.tasm.base.LLog;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class SettingUtils {
    private static final String ENABLE_LYNX_SERVICE_KEY = "lynx_service_enabled";
    private static final String SP_SETTINGS_KEY = "lynx_example_sp";
    private static final String TAG = "SettingUtils";
    private static volatile SettingUtils sInstance;
    private boolean lynxServiceEnabled;
    private SharedPreferences mSP;

    public boolean isLynxServiceEnabled() {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.mSP != null) goto L6;
        LLog.e(TAG, "please call initSettings first");     // Catch: Throwable -> L9
    L6:
        boolean r0 = this.lynxServiceEnabled;     // Catch: Throwable -> L9
        monitor-exit(this);     // Catch: Throwable -> L9
        return r0;
    }

    public static SettingUtils inst() {
        if (sInstance != null) goto L15;
        monitor-enter(SettingUtils.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new SettingUtils();     // Catch: Throwable -> L11
    L9:
        monitor-exit(SettingUtils.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    public SettingUtils() {
        this.mSP = null;
        this.lynxServiceEnabled = false;
    }

    private SharedPreferences initIfNot(Context r3) {
        monitor-enter(this);
        SharedPreferences r0 = this.mSP;     // Catch: Throwable -> L9
        if (r0 != null) goto L7;
        r0 = r3.getSharedPreferences(SP_SETTINGS_KEY, 0);     // Catch: Throwable -> L9
    L7:
        monitor-exit(this);     // Catch: Throwable -> L9
        return r0;
    L9:
        th = move-exception;
        throw th;
    }

    public void initSettings(Context r3) {
        monitor-enter(this);
        if (r3 != null) goto L10;
    L5:
        monitor-exit(this);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    L10:
        SharedPreferences r4 = initIfNot(r3);     // Catch: Throwable -> L7
        this.mSP = r4;     // Catch: Throwable -> L7
        this.lynxServiceEnabled = r4.getBoolean(ENABLE_LYNX_SERVICE_KEY, false);     // Catch: Throwable -> L7
        goto L5
    }

    public void setLynxServiceEnabled(boolean r3) {
        monitor-enter(this);
        SharedPreferences r0 = this.mSP;     // Catch: Throwable -> L8
        if (r0 == null) goto L6;
        r0.edit().putBoolean(ENABLE_LYNX_SERVICE_KEY, r3).commit();     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }
}
