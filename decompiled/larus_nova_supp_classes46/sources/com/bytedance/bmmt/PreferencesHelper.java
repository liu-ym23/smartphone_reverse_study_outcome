package com.bytedance.bmmt;

import android.content.Context;
import android.content.SharedPreferences;
import com.bytedance.bmmt.base.ContextUtils;
import com.bytedance.bmmt.base.Logging;
import java.io.UnsupportedEncodingException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public class PreferencesHelper {
    private static final String BMMT_PREFERENCE = "bmmt_preference";
    public static final String ONER_RTC_PREFERENCE = "oner_rtc_preference";
    public static final String PREF_CONFIGURE = "pref_configure";
    public static final String PREF_FEEDBACK = "pref_rtc_feedback_data";
    public static final String PREF_HOST_RTT_HISTORY = "pref_host_rtt_history";
    private static final String TAG = "PreferencesHelper";
    private static volatile PreferencesHelper sInstance;
    private final SharedPreferences mSharedPreferences;

    private void clearCache() {
        this.mSharedPreferences.edit().clear().commit();
    }

    private static PreferencesHelper getInstance() {
        return instance(ContextUtils.getApplicationContext());
    }

    private PreferencesHelper(Context r3) {
        this.mSharedPreferences = r3.getSharedPreferences(BMMT_PREFERENCE, 0);
    }

    public static PreferencesHelper instance(Context r2) {
    L20:
        return null;
    L3:
        if (sInstance != null) goto L19;
        monitor-enter(PreferencesHelper.class);     // Catch: OutOfMemoryError -> L20
        if (r2 == null) goto L15;
        if (sInstance != null) goto L10;
        sInstance = new PreferencesHelper(r2);     // Catch: Throwable -> L12
    L10:
        monitor-exit(PreferencesHelper.class);     // Catch: Throwable -> L12
        goto L19
    L15:
        throw new RuntimeException("unable to init RtcPreferences without context");     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;     // Catch: OutOfMemoryError -> L20
    L19:
        return sInstance;
    }

    public void remove(String r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        SharedPreferences.Editor r0 = this.mSharedPreferences.edit();
        r0.remove(r2);
        r0.apply();
    }

    public int getInt(String r2, int r3) {
        return this.mSharedPreferences.getInt(r2, r3);
    }

    public String getString(String r2, String r3) {
        String r4 = this.mSharedPreferences.getString(r2, r3);
        r4.getBytes("utf-8");     // Catch: UnsupportedEncodingException -> L5
        return r4;
    L5:
        e = move-exception;
        Logging.e(TAG, "Unable to get bytes use utf-8", e);
        return "";
    }

    public void putInt(String r2, int r3) {
        SharedPreferences.Editor r0 = this.mSharedPreferences.edit();
        r0.putInt(r2, r3);
        r0.apply();
    }

    public void putString(String r2, String r3) {
        SharedPreferences.Editor r0 = this.mSharedPreferences.edit();
        r0.putString(r2, r3);
        r0.apply();
    }
}
