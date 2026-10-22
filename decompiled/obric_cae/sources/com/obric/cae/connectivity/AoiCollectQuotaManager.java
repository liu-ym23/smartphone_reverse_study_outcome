package com.obric.cae.connectivity;

import android.content.Context;
import android.content.SharedPreferences;
import defpackage.b;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class AoiCollectQuotaManager {
    private static final String KEY_DAILY_ENTERED_AOI_COUNT = "daily_entered_aoi_count";
    private static final String KEY_DAILY_TOTAL_COUNT = "daily_total_count";
    private static final String KEY_LAST_DATE = "last_date";
    private static final String PREFIX_AOI_COUNT = "aoi_count_";
    private static final String PREFIX_AOI_ENTER_COUNT = "aoi_enter_count_";
    private static final String PREF_NAME = "aoi_collect_quota_prefs";
    private static AoiCollectQuotaManager sInstance;
    private SharedPreferences mPrefs;

    private AoiCollectQuotaManager(Context r8) {
        this.mPrefs = r8.getSharedPreferences(PREF_NAME, 0);
        checkAndResetDailyQuota();
    }

    private void checkAndResetDailyQuota() {
        String r8 = getTodayDateString();
        if (r8.equals(this.mPrefs.getString(KEY_LAST_DATE, "")) == true) goto L6;
        this.mPrefs.edit().clear().putString(KEY_LAST_DATE, r8).apply();
        return;
    }

    public static synchronized AoiCollectQuotaManager getInstance(Context r8) {
        monitor-enter(AoiCollectQuotaManager.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (sInstance != null) goto L7;
        sInstance = new AoiCollectQuotaManager(r8.getApplicationContext());     // Catch: Throwable -> L10
    L7:
        AoiCollectQuotaManager r10 = sInstance;     // Catch: Throwable -> L10
        monitor-exit(AoiCollectQuotaManager.class);
        return r10;
    }

    private String getTodayDateString() {
        return new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());
    }

    public int getAoiCount(String r8) {
        checkAndResetDailyQuota();
        return this.mPrefs.getInt(PREFIX_AOI_COUNT + r8, 0);
    }

    public int getAoiEnterCount(String r8) {
        checkAndResetDailyQuota();
        return this.mPrefs.getInt(PREFIX_AOI_ENTER_COUNT + r8, 0);
    }

    public int getDailyEnteredAoiCount() {
        checkAndResetDailyQuota();
        return this.mPrefs.getInt(KEY_DAILY_ENTERED_AOI_COUNT, 0);
    }

    public int getDailyTotalCount() {
        checkAndResetDailyQuota();
        return this.mPrefs.getInt(KEY_DAILY_TOTAL_COUNT, 0);
    }

    public void incrementAoiEnterCount(String r8) {
        checkAndResetDailyQuota();
        int r10 = this.mPrefs.getInt(PREFIX_AOI_ENTER_COUNT + r8, 0);
        SharedPreferences.Editor r11 = this.mPrefs.edit();
        if (r10 != 0) goto L5;
        r11.putInt(KEY_DAILY_ENTERED_AOI_COUNT, this.mPrefs.getInt(KEY_DAILY_ENTERED_AOI_COUNT, 0) + 1);
    L5:
        r11.putInt(b.c(PREFIX_AOI_ENTER_COUNT, r8), r10 + 1).apply();
    }

    public void incrementCount(String r8) {
        checkAndResetDailyQuota();
        this.mPrefs.edit().putInt(KEY_DAILY_TOTAL_COUNT, this.mPrefs.getInt(KEY_DAILY_TOTAL_COUNT, 0) + 1).putInt(b.c(PREFIX_AOI_COUNT, r8), this.mPrefs.getInt(PREFIX_AOI_COUNT + r8, 0) + 1).apply();
    }
}
