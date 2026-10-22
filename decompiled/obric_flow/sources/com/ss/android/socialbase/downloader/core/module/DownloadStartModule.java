package com.ss.android.socialbase.downloader.core.module;

import android.os.SystemClock;
import com.ss.android.socialbase.downloader.constants.AsyncHandleStatus;
import com.ss.android.socialbase.downloader.constants.ByteInvalidRetryStatus;
import com.ss.android.socialbase.downloader.core.AbsDownloadModule;
import com.ss.android.socialbase.downloader.core.DownloadModuleChain;
import com.ss.android.socialbase.downloader.downloader.DownloadStatusHandler;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTimingInfo;

/* JADX INFO: loaded from: classes3.dex */
public class DownloadStartModule extends AbsDownloadModule {
    public DownloadStartModule() {
    }

    @Override // com.ss.android.socialbase.downloader.core.IDownloadModule
    public final void a(DownloadModuleChain r10) {
        DownloadInfo r5 = this.f15290c;
        r5.getClass();
        r5.f15835r0 = SystemClock.uptimeMillis();
        if (r5.b1 == true) goto L6;
        r5.a("dbjson_last_start_download_time", Long.valueOf(System.currentTimeMillis()));
    L6:
        DownloadInfo r11 = this.f15290c;
        r11.f15836s0 = 0;
        r11.M0 = false;
        DownloadStatusHandler r12 = this.e;
        DownloadTimingInfo r13 = r12.f.s;
        r13.f15906i = System.currentTimeMillis();
        if (r12.f15551c.c() == false) goto L18;
        DownloadInfo r14 = r12.f15551c;
        if (r14.o() == 8) goto L14;
        AsyncHandleStatus r15 = r14.H;
        if (r15 == AsyncHandleStatus.f15264b) goto L14;
        if (r15 == AsyncHandleStatus.f15265c) goto L14;
    L16:
        if (r14.f15848y0 != ByteInvalidRetryStatus.f15267b) goto L25;
        r14.f15848y0 = ByteInvalidRetryStatus.f15268c;
    L25:
        DownloadTimingInfo r16 = r12.f.s;
        r16.f15907j = System.currentTimeMillis();
        r10.c();
        return;
    L14:
        r14.H = AsyncHandleStatus.d;
        goto L16
    L18:
        DownloadInfo r17 = r12.f15551c;
        if (r17.X > 0) goto L21;
        r17.X = System.currentTimeMillis();
    L21:
        r12.d.h(r12.f15551c.l());
        if (r12.f15551c.w() == false) goto L24;
        r12.a(6, null);
    L24:
        r12.a(2, null);
        goto L25
    }
}
