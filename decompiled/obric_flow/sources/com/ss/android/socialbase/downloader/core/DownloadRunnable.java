package com.ss.android.socialbase.downloader.core;

import android.os.Handler;
import android.os.Process;
import com.ss.android.socialbase.downloader.core.module.DownloadBandwidthSamplerModule;
import com.ss.android.socialbase.downloader.core.module.DownloadCheckFileExistModule;
import com.ss.android.socialbase.downloader.core.module.DownloadCheckHasAnotherSameTaskModule;
import com.ss.android.socialbase.downloader.core.module.DownloadCheckPathModule;
import com.ss.android.socialbase.downloader.core.module.DownloadCheckTaskCanResumedModule;
import com.ss.android.socialbase.downloader.core.module.DownloadCheckTaskRepetitionModule;
import com.ss.android.socialbase.downloader.core.module.DownloadCheckWifiTaskValidModule;
import com.ss.android.socialbase.downloader.core.module.DownloadCommonParams;
import com.ss.android.socialbase.downloader.core.module.DownloadCompleteModule;
import com.ss.android.socialbase.downloader.core.module.DownloadLoadCacheModule;
import com.ss.android.socialbase.downloader.core.module.DownloadMimeTypeInterceptModule;
import com.ss.android.socialbase.downloader.core.module.DownloadPrepareModule;
import com.ss.android.socialbase.downloader.core.module.DownloadRetryModule;
import com.ss.android.socialbase.downloader.core.module.DownloadStartModule;
import com.ss.android.socialbase.downloader.core.module.DownloadTaskInterceptModule;
import com.ss.android.socialbase.downloader.core.module.DownloadUrlInterceptModule;
import com.ss.android.socialbase.downloader.core.module.fast.DownloadFastModule;
import com.ss.android.socialbase.downloader.core.module.multi.DownloadMultiSegmentModule;
import com.ss.android.socialbase.downloader.core.module.normal.DownloadSingleSegmentModule;
import com.ss.android.socialbase.downloader.core.module.pcdn.DownloadPCDNSegmentModule;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.DownloadStatusHandler;
import com.ss.android.socialbase.downloader.downloader.NetworkFailoverStrategy;
import com.ss.android.socialbase.downloader.downloader.NetworkRetryStrategy;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.socialbase.downloader.model.DownloadThreadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTimingInfo;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.util.concurrent.Future;

/* JADX INFO: loaded from: classes3.dex */
public class DownloadRunnable implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DownloadCommonParams f15294a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final DownloadModuleChain f15295b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Future f15296c;

    public DownloadRunnable(DownloadTask r5, Handler r10) {
        DownloadCommonParams r11 = new DownloadCommonParams();
        this.f15294a = r11;
        this.f15295b = new DownloadModuleChain(r11);
        r11.f15309b = r5;
        r11.f15310c = r5.f15878a;
        r11.e = new DownloadStatusHandler(r5, r10);
        r11.d = DownloadSetting.a(r11.f15310c.l(), null);
        r11.f15308a = DownloadComponentManager.h();
        r11.f15316m = new NetworkRetryStrategy(r11.f15310c);
        r11.f15317n = new NetworkFailoverStrategy(r11.f15310c);
    }

    public final void a() {
        DownloadTask r5 = this.f15294a.f15309b;
        DownloadTimingInfo r10 = r5.s;
        r10.f15902a = 0;
        r10.f15903b = 0;
        r10.f15904c = 0;
        r10.d = 0;
        r10.e = 0;
        r10.f = 0;
        r10.g = 0;
        r10.f15905h = 0;
        r10.f15906i = 0;
        r10.f15907j = 0;
        r10.f15908k = 0;
        DownloadThreadInfo r11 = r5.f15892t;
        r11.f15897a.clear();
        r11.f15898b.clear();
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f15294a.f15309b.s.f = System.currentTimeMillis();
        if (Logger.a(this.f15294a.f15310c) == false) goto L5;
        Logger.a("DownloadRunnable", this.f15294a.f15310c, "run", "Run");
    L5:
        Process.setThreadPriority(10);
        DownloadModuleChain r5 = new DownloadModuleChain(this.f15294a);
        r5.f15291a.add(new DownloadCheckPathModule().a(r5.f15293c));
        AbsDownloadModule r10 = new DownloadCheckHasAnotherSameTaskModule().a(r5.f15293c);
        if (r10 == null) goto L9;
        r5.f15291a.add(r10);
    L9:
        AbsDownloadModule r11 = new DownloadCheckWifiTaskValidModule().a(r5.f15293c);
        if (r11 == null) goto L13;
        r5.f15291a.add(r11);
    L13:
        AbsDownloadModule r12 = new DownloadCheckTaskCanResumedModule().a(r5.f15293c);
        if (r12 == null) goto L17;
        r5.f15291a.add(r12);
    L17:
        AbsDownloadModule r13 = new DownloadFastModule().a(r5.f15293c);
        if (r13 == null) goto L21;
        r5.f15291a.add(r13);
    L21:
        r5.f15291a.add(new DownloadMultiSegmentModule().a(r5.f15293c));
        AbsDownloadModule r14 = new DownloadPCDNSegmentModule().a(r5.f15293c);
        if (r14 == null) goto L25;
        r5.f15291a.add(r14);
    L25:
        r5.f15291a.add(new DownloadSingleSegmentModule().a(r5.f15293c));
        r5.f15291a.add(new DownloadCompleteModule().a(r5.f15293c));
        DownloadModuleChain r15 = this.f15295b;
        AbsDownloadModule r16 = new DownloadCheckTaskRepetitionModule().a(r15.f15293c);
        if (r16 == null) goto L29;
        r15.f15291a.add(r16);
    L29:
        AbsDownloadModule r17 = new DownloadBandwidthSamplerModule().a(r15.f15293c);
        if (r17 == null) goto L33;
        r15.f15291a.add(r17);
    L33:
        r15.f15291a.add(new DownloadPrepareModule().a(r15.f15293c));
        AbsDownloadModule r18 = new DownloadUrlInterceptModule().a(r15.f15293c);
        if (r18 == null) goto L37;
        r15.f15291a.add(r18);
    L37:
        AbsDownloadModule r19 = new DownloadTaskInterceptModule().a(r15.f15293c);
        if (r19 == null) goto L41;
        r15.f15291a.add(r19);
    L41:
        AbsDownloadModule r20 = new DownloadLoadCacheModule().a(r15.f15293c);
        if (r20 == null) goto L45;
        r15.f15291a.add(r20);
    L45:
        r15.f15291a.add(new DownloadStartModule().a(r15.f15293c));
        new DownloadMimeTypeInterceptModule().a(r15.f15293c);
        AbsDownloadModule r21 = new DownloadCheckFileExistModule().a(r15.f15293c);
        if (r21 == null) goto L49;
        r15.f15291a.add(r21);
    L49:
        r15.f15291a.add(new DownloadRetryModule(r5).a(r15.f15293c));
        this.f15295b.c();     // Catch: Throwable -> L52
    L54:
        a();
        if (Logger.a(this.f15294a.f15310c) == false) goto L64;
        Logger.a("DownloadRunnable", this.f15294a.f15310c, "run", "Run Time:" + (System.currentTimeMillis() - this.f15294a.f15309b.s.f));
    L64:
        DownloadComponentManager.j().a(this);     // Catch: Throwable -> L59
        return;
    L59:
        th = move-exception;
        th.printStackTrace();
        return;
    L52:
        th = move-exception;
        th.printStackTrace();
        this.f15294a.e.a(new BaseException(1045, DownloadUtils.a(th)));
        goto L54
    }
}
