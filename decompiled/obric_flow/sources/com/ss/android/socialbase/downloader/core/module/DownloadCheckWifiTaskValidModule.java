package com.ss.android.socialbase.downloader.core.module;

import com.ss.android.socialbase.downloader.core.AbsDownloadModule;
import com.ss.android.socialbase.downloader.core.DownloadModuleChain;
import com.ss.android.socialbase.downloader.exception.DownloadOnlyWifiException;
import com.ss.android.socialbase.downloader.exception.DownloadPauseReserveWifiException;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.network.DeviceBandwidthSampler;

/* JADX INFO: loaded from: classes3.dex */
public class DownloadCheckWifiTaskValidModule extends AbsDownloadModule {
    public DownloadCheckWifiTaskValidModule() {
    }

    @Override // com.ss.android.socialbase.downloader.core.AbsDownloadModule
    public final AbsDownloadModule a(DownloadCommonParams r5) {
        if (r5.f15310c.b1 == false) goto L7;
        return null;
    L7:
        return super.a(r5);
    }

    @Override // com.ss.android.socialbase.downloader.core.IDownloadModule
    public final void a(DownloadModuleChain r5) {
        if (Logger.a(this.f15290c) == false) goto L5;
        Logger.a("DownloadCheckWifiTaskValidModule", this.f15290c, "proceed", "Run");
    L5:
        a(this.f15290c);
        r5.c();
    }

    public static void a(DownloadInfo r5) {
        if (r5.b1 == false) goto L5;
        return;
    L5:
        if (DeviceBandwidthSampler.f != 1) goto L8;
        return;
    L8:
        if (r5.g == false) goto L15;
        DeviceBandwidthSampler.c();
        if (DeviceBandwidthSampler.f != 2) goto L15;
        throw new DownloadOnlyWifiException();
    L15:
        if (r5.W0 == true) goto L17;
        return;
    L17:
        if (r5.x() == false) goto L25;
        DeviceBandwidthSampler.c();
        if (DeviceBandwidthSampler.f == 2) goto L22;
        return;
    L22:
        throw new DownloadPauseReserveWifiException();
    }
}
