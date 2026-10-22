package com.ss.android.socialbase.downloader.cleaner;

import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public class FastDownloadCleaner {
    private static final String TAG = "FastDownloadCleaner";

    public FastDownloadCleaner() {
    }

    public static void start() {
        int r0 = DownloadSetting.obtainGlobal().optInt("fast_download_clean_temp_path_delay_time_S", 0);
        if (Logger.debug() == false) goto L5;
        Logger.globalDebug(TAG, "start", "DelayTime: " + r0);
    L5:
        if (r0 > 0) goto L7;
        return;
    L7:
        DownloadComponentManager.submitScheduleTask(new 1(), r0, TimeUnit.SECONDS);
    }
}
