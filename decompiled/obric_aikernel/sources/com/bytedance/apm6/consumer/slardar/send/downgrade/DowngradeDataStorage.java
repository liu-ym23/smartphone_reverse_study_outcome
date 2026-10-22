package com.bytedance.apm6.consumer.slardar.send.downgrade;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.Nullable;
import com.bytedance.apm6.util.ApmBaseContext;
import com.bytedance.apm6.util.log.Logger;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
class DowngradeDataStorage {
    private static final String KEY_RULE = "rule";
    private static final String PREFS_MONITOR_DOWNGRADE = "monitor_downgrade";
    public static final String TAG = "APM-Downgrade";
    private SharedPreferences mPrefs;

    public DowngradeDataStorage(Context r10) {
        if (this.mPrefs != null) goto L13;
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L6:
        if (this.mPrefs != null) goto L8;
        this.mPrefs = r10.getSharedPreferences(PREFS_MONITOR_DOWNGRADE, 0);     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);     // Catch: Throwable -> L10
        return;
    }

    @Nullable
    public DowngradeInfo loadFromSp() {
        String r10 = this.mPrefs.getString(KEY_RULE, null);
        if (r10 != null) goto L14;
    L13:
        return null;
    L14:
    L11:
        e = move-exception;
        e.printStackTrace();
        goto L13
    L5:
        if (ApmBaseContext.isDebugMode() == false) goto L7;
        Logger.i(TAG, "DowngradeData-load-" + r10);     // Catch: JSONException -> L11
    L7:
        DowngradeInfo r11 = DowngradeInfo.parse(new JSONObject(r10));     // Catch: JSONException -> L11
        if (System.currentTimeMillis() >= r11.expireTime) goto L13;
        return r11;
    }

    public void save(DowngradeInfo r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (this.mPrefs == null) goto L13;
        JSONObject r11 = r10.toJson();
        if (r11 == null) goto L14;
        String r12 = r11.toString();
        if (ApmBaseContext.isDebugMode() == false) goto L10;
        Logger.i(TAG, "DowngradeData-save-" + r12);
    L10:
        this.mPrefs.edit().putString(KEY_RULE, r11.toString()).apply();
        return;
    L14:
        return;
    }
}
