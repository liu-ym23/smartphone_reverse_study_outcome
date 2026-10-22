package com.ss.android.socialbase.downloader.cleaner;

import com.bytedance.apm6.util.constant.CommonConsts;
import java.io.File;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class d {

    static class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (lb.a.a() == false) goto L10;
            lb.a.b("FastDownloadCleaner", "run", "Run");
        L10:
            com.ss.android.socialbase.downloader.utils.c.l(new File(com.ss.android.socialbase.downloader.utils.a.d()).getParent(), String.valueOf(com.ss.android.socialbase.downloader.utils.a.f8317a));     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            th.printStackTrace();
            lb.a.c("FastDownloadCleaner", "run", "Exception: " + th);
        }
    }

    public static void a() {
        int r10 = rb.a.j().o("fast_download_clean_temp_path_delay_time_S", 0);
        if (lb.a.a() == false) goto L5;
        lb.a.b("FastDownloadCleaner", CommonConsts.APM_INNER_EVENT_COST_START, "DelayTime: " + r10);
    L5:
        if (r10 > 0) goto L7;
        return;
    L7:
        com.ss.android.socialbase.downloader.downloader.a.L0(new a(), r10, TimeUnit.SECONDS);
    }
}
