package com.ss.android.socialbase.downloader.core.module;

import android.os.SystemClock;
import com.ss.android.socialbase.downloader.core.AbsDownloadModule;
import com.ss.android.socialbase.downloader.core.DownloadModuleChain;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.network.DeviceBandwidthSampler;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public class DownloadBandwidthSamplerModule extends AbsDownloadModule {
    public DownloadBandwidthSamplerModule() {
    }

    @Override // com.ss.android.socialbase.downloader.core.AbsDownloadModule
    public final AbsDownloadModule a(DownloadCommonParams r5) {
        if (r5.f15310c.b1 == false) goto L7;
        return null;
    L7:
        return super.a(r5);
    }

    @Override // com.ss.android.socialbase.downloader.core.IDownloadModule
    public final void a(DownloadModuleChain r10) {
        if (Logger.a(this.f15290c) == false) goto L5;
        Logger.a("DownloadBandwidthSamplerModule", this.f15290c, "proceed", "Run");
    L5:
        ArrayList r5 = DownloadComponentManager.E;
        monitor-enter(r5);
        Iterator r11 = r5.iterator();     // Catch: Throwable -> L15
    L9:
        if (r11.hasNext() == false) goto L17;
        if (r11.next() == null) goto L9;
        throw new ClassCastException();     // Catch: Throwable -> L15
    L17:
        monitor-exit(r5);     // Catch: Throwable -> L15
        DeviceBandwidthSampler r12 = DeviceBandwidthSampler.b();
        r12.getClass();
        if (Logger.b() == false) goto L23;
        Logger.b("DeviceBandwidthSampler", "startSampling", "SamplingCounter = " + r12.f15947c);     // Catch: Throwable -> L36
    L23:
        if (r12.f15947c.getAndIncrement() != 0) goto L25;
        r12.d.sendEmptyMessage(1);     // Catch: Throwable -> L36
        r12.e = SystemClock.uptimeMillis();     // Catch: Throwable -> L36
        System.currentTimeMillis();     // Catch: Throwable -> L36
    L25:
        r10.c();
        DeviceBandwidthSampler r13 = DeviceBandwidthSampler.b();
        r13.getClass();
        if (Logger.b() == false) goto L30;
        Logger.b("DeviceBandwidthSampler", "stopSampling", "SamplingCounter = " + r13.f15947c);     // Catch: Throwable -> L37
    L30:
        if (r13.f15947c.decrementAndGet() != 0) goto L32;
        r13.d.removeMessages(1);     // Catch: Throwable -> L37
        r13.a();     // Catch: Throwable -> L37
        DeviceBandwidthSampler.g = -1;     // Catch: Throwable -> L37
    L32:
        DownloadComponentManager.u();
        return;
    L15:
        th = move-exception;
        throw th;
    }
}
