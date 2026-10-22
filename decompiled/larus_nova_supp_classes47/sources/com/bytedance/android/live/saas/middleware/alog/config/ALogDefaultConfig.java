package com.bytedance.android.live.saas.middleware.alog.config;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.android.live.saas.middleware.BDLiveSdk;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public class ALogDefaultConfig {
    public static final int ALOG_MAX_CACHE_SIZE = 20971520;
    public static final int ALOG_ZONE_SIZE = 2097152;
    public static final int DEVICE_MAX_LOG_SPACE_SIZE = 52428800;
    private static String SUFFIX_LOGS = "/logs";
    private static String sAppLogPath = "";

    public ALogDefaultConfig() {
    }

    public static String getALogFile(Context r2) {
        if (TextUtils.isEmpty(sAppLogPath) == false) goto L5;
        File r0 = BDLiveSdk.fileUtils().getExternalFilesDir(r2);
        if (r0 != null) goto L9;
        r0 = BDLiveSdk.fileUtils().getExternalCacheDir(r2);
    L9:
        if (r0 != null) goto L11;
        r0 = r2.getFilesDir();
    L11:
        String r3 = new PolarisFileWrapper(r0, SUFFIX_LOGS).getAbsolutePath();
        sAppLogPath = r3;
        return r3;
    L5:
        return sAppLogPath;
    }

    public static int getDefaultLogSize(Context r4) {
        long r0 = new PolarisFileWrapper(getALogFile(r4)).getFreeSpace() / 10;
        if (r0 <= 52428800) goto L7;
        return DEVICE_MAX_LOG_SPACE_SIZE;
    L7:
        if (r0 < 20971520) goto L9;
        return ALOG_MAX_CACHE_SIZE;
    L9:
        return (int) r0;
    }

    public static void setsAppLogPath(String r0) {
        sAppLogPath = r0;
    }
}
