package com.ss.android.socialbase.downloader.cleaner;

import com.bytedance.apm6.util.constant.CommonConsts;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes6.dex */
public class d {
    public static void a() {
        int r0 = com.ss.android.socialbase.downloader.g.a.c().a("fast_download_clean_temp_path_delay_time_S", 0);
        if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L5;
        com.ss.android.socialbase.downloader.e.a.a("FastDownloadCleaner", CommonConsts.APM_INNER_EVENT_COST_START, "DelayTime: " + r0);
    L5:
        if (r0 > 0) goto L7;
        return;
    L7:
        com.ss.android.socialbase.downloader.downloader.b.a(new AnonymousClass1(), r0, TimeUnit.SECONDS);
    }
}
