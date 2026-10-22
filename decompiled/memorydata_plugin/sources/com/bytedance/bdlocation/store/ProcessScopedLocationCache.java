package com.bytedance.bdlocation.store;

import android.content.Context;
import android.content.SharedPreferences;
import com.bytedance.bdlocation.log.Logger;
import com.bytedance.bdlocation.utils.BDLocationProcessUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public final enum ProcessScopedLocationCache extends Enum<ProcessScopedLocationCache> {
    private static final /* synthetic */ ProcessScopedLocationCache[] $VALUES = null;
    public static final ProcessScopedLocationCache LAST_INFO_REQUEST_KEY_PARAMS_JSON_STR = null;
    private static volatile SharedPreferences SHARED_PREFERENCES = null;
    private static final String SP_NAME_PREFIX = "PROCESS_SCOPED_LOCATION_CACHE_";
    private final String mKey;

    static {
        ProcessScopedLocationCache r0 = new ProcessScopedLocationCache("LAST_INFO_REQUEST_KEY_PARAMS_JSON_STR", 0, "last_info_request_key_params_json_str");
        LAST_INFO_REQUEST_KEY_PARAMS_JSON_STR = r0;
        $VALUES = new ProcessScopedLocationCache[]{r0};
        SHARED_PREFERENCES = null;
    }

    private ProcessScopedLocationCache(String r1, int r2, String r3) {
        super(r1, r2);
        this.mKey = r3;
    }

    private static SharedPreferences getSharedPreferencesOfCurrentProcess(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
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
        if (r5 != null) goto L12;
        monitor-exit(ProcessScopedLocationCache.class);     // Catch: Throwable -> L19
        return null;
    L12:
        String r2 = BDLocationProcessUtils.getCurrentProcessName(r5);     // Catch: Throwable -> L19
        if (r2 != null) goto L16;
        monitor-exit(ProcessScopedLocationCache.class);     // Catch: Throwable -> L19
        return null;
    L16:
        SHARED_PREFERENCES = r5.getSharedPreferences(SP_NAME_PREFIX + r2, 0);     // Catch: Throwable -> L19
        Logger.i("Successfully created SharedPreferences: PROCESS_SCOPED_LOCATION_CACHE_" + r2);     // Catch: Throwable -> L19
    L23:
        return SHARED_PREFERENCES;
    }

    public static ProcessScopedLocationCache valueOf(String r2) {
        return (ProcessScopedLocationCache) ZeusTransformUtils.preCheckCast(Enum.valueOf(ProcessScopedLocationCache.class, r2), ProcessScopedLocationCache.class, "com.obric.memorydata.plugin");
    }

    public static ProcessScopedLocationCache[] values() {
        return (ProcessScopedLocationCache[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), ProcessScopedLocationCache[].class, "com.obric.memorydata.plugin");
    }

    public void applyString(Context r3, String r4) {
        SharedPreferences r5 = getSharedPreferencesOfCurrentProcess((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"));
        if (r5 != null) goto L5;
        return;
    L5:
        r5.edit().putString(this.mKey, r4).apply();
    }

    public String getString(Context r3, String r4) {
        SharedPreferences r5 = getSharedPreferencesOfCurrentProcess((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"));
        if (r5 != null) goto L6;
        return r4;
    L6:
        return r5.getString(this.mKey, r4);
    }
}
