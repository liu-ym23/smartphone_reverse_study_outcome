package com.bytedance.bdlocation.store;

import android.content.Context;
import android.content.SharedPreferences;
import com.bytedance.bdlocation.log.Logger;
import com.bytedance.bdlocation.utils.BDLocationProcessUtils;

/* JADX INFO: loaded from: classes.dex */
public final enum ProcessScopedLocationCache extends Enum<ProcessScopedLocationCache> {
    private static final /* synthetic */ ProcessScopedLocationCache[] $VALUES = null;
    public static final ProcessScopedLocationCache LAST_INFO_REQUEST_KEY_PARAMS_JSON_STR = null;
    private static volatile SharedPreferences SHARED_PREFERENCES = null;
    private static final String SP_NAME_PREFIX = "PROCESS_SCOPED_LOCATION_CACHE_";
    private final String mKey;

    static {
        ProcessScopedLocationCache r8 = new ProcessScopedLocationCache("LAST_INFO_REQUEST_KEY_PARAMS_JSON_STR", 0, "last_info_request_key_params_json_str");
        LAST_INFO_REQUEST_KEY_PARAMS_JSON_STR = r8;
        $VALUES = new ProcessScopedLocationCache[]{r8};
        SHARED_PREFERENCES = null;
    }

    private ProcessScopedLocationCache(String r8, int r10, String r11) {
        super(r8, r10);
        this.mKey = r11;
    }

    private static SharedPreferences getSharedPreferencesOfCurrentProcess(Context r8) {
        if (SHARED_PREFERENCES != null) goto L23;
        monitor-enter(ProcessScopedLocationCache.class);
    L19:
        th = move-exception;
        throw th;
    L7:
        if (SHARED_PREFERENCES == null) goto L9;
    L17:
        monitor-exit(ProcessScopedLocationCache.class);     // Catch: Throwable -> L19
        goto L23
    L9:
        if (r8 != null) goto L12;
        monitor-exit(ProcessScopedLocationCache.class);     // Catch: Throwable -> L19
        return null;
    L12:
        String r10 = BDLocationProcessUtils.getCurrentProcessName(r8);     // Catch: Throwable -> L19
        if (r10 != null) goto L16;
        monitor-exit(ProcessScopedLocationCache.class);     // Catch: Throwable -> L19
        return null;
    L16:
        SHARED_PREFERENCES = r8.getSharedPreferences(SP_NAME_PREFIX.concat(r10), 0);     // Catch: Throwable -> L19
        Logger.i("Successfully created SharedPreferences: PROCESS_SCOPED_LOCATION_CACHE_".concat(r10));     // Catch: Throwable -> L19
    L23:
        return SHARED_PREFERENCES;
    }

    public static ProcessScopedLocationCache valueOf(String r8) {
        return (ProcessScopedLocationCache) Enum.valueOf(ProcessScopedLocationCache.class, r8);
    }

    public static ProcessScopedLocationCache[] values() {
        return (ProcessScopedLocationCache[]) $VALUES.clone();
    }

    public void applyString(Context r8, String r10) {
        SharedPreferences r11 = getSharedPreferencesOfCurrentProcess(r8);
        if (r11 != null) goto L5;
        return;
    L5:
        r11.edit().putString(this.mKey, r10).apply();
    }

    public String getString(Context r8, String r10) {
        SharedPreferences r11 = getSharedPreferencesOfCurrentProcess(r8);
        if (r11 != null) goto L6;
        return r10;
    L6:
        return r11.getString(this.mKey, r10);
    }
}
