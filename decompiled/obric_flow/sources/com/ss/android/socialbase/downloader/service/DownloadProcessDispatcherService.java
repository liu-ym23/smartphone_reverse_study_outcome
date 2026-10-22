package com.ss.android.socialbase.downloader.service;

import android.content.Context;
import com.ss.android.socialbase.downloader.cleaner.Cleaner;
import com.ss.android.socialbase.downloader.constants.ListenerType;
import com.ss.android.socialbase.downloader.db.SqlDownloadCache;
import com.ss.android.socialbase.downloader.depend.AbsDownloadListener;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.DownloadProcessDispatcher;
import com.ss.android.socialbase.downloader.downloader.IDownloadCache;
import com.ss.android.socialbase.downloader.downloader.IDownloadProxy;
import com.ss.android.socialbase.downloader.downloader.ISqlDownloadCache;
import com.ss.android.socialbase.downloader.impls.DefaultDownloadCache;
import com.ss.android.socialbase.downloader.impls.DownloadProxy;
import com.ss.android.socialbase.downloader.impls.ProcessDownloadHandler;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class DownloadProcessDispatcherService implements IDownloadProcessDispatcherService {
    public DownloadProcessDispatcherService() {
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
    public final void a(DownloadTask r10) {
        if (Logger.a() == false) goto L7;
        DownloadInfo r11 = r10.f15878a;
        if (r11 == null) goto L7;
        Logger.a("DownloadProcessDispatcherService", r11.l(), r11.P, "tryDownload", "DownloadInfo{id=" + r11.f15805a + ", name='" + r11.f15808b + "', title='" + r11.f15810c + "', url='" + r11.d + "', savePath='" + r11.e + "', tempPath='" + r11.f + "', onlyWifi=" + r11.g + ", extra='" + r11.f15816h + "', extraHeaders=" + r11.f15818i + ", maxBytes=" + r11.f15819j + ", outIp=" + Arrays.toString(r11.f15821k) + ", outSize=" + Arrays.toString(r11.f15823l) + ", retryCount=" + r11.f15824m + ", backUpUrlRetryCount=" + r11.f15826n + ", force=" + r11.f15828o + ", needPostProgress=" + r11.f15830p + ", maxProgressCount=" + r11.f15832q + ", minProgressTimeMsInterval=" + r11.f15834r + ", backUpUrls=" + r11.s + ", showNotification=" + r11.f15837t + ", mimeType='" + r11.f15839u + "', needHttpsToHttpRetry=" + r11.f15841v + ", cacheLifeTimeMax=" + r11.f15843w + ", pcdnUrls=" + r11.f15845x + ", cdnUrls=" + r11.f15847y + ", pcdnUrlsStr='" + r11.f15849z + "', cdnUrlsStr='" + r11.A + "', packageName='" + r11.B + "', filePackageName='null', md5='" + r11.C + "', allConnectTime=" + r11.D + ", needDefaultHttpServiceBackUp=" + r11.E + ", eTag='" + r11.F + "', curRetryTime=" + r11.G + ", asyncHandleStatus=" + r11.H + ", ignoreDataVerify=" + r11.I + ", needIndependentProcess=" + r11.J + ", needCurrentProcess=" + r11.K + ", supportPartial=" + r11.L + ", iconUrl='" + r11.M + "', curNetworkRetryCount=" + r11.N + ", needSDKMonitor=" + r11.O + ", monitorScene='" + r11.P + "', extraMonitorStatus=" + Arrays.toString(r11.Q) + ", expiredRedownload=" + r11.R + ", expiredHttpCheck=" + r11.S + ", deleteCacheIfCheckFailed=" + r11.T + ", successByCache=" + r11.U + ", ignoreInterceptor=" + r11.V + ", interceptFlag=" + r11.W + ", downloadStartTimeStamp=" + r11.X + ", downloadFinishTimeStamp=" + r11.Y + ", installedTimeStamp=" + r11.Z + ", hasDoInstallation=" + r11.f15806a0 + ", networkQuality='" + r11.f15809b0 + "', curBackUpUrlIndex=" + r11.f15811c0 + ", notificationVisibility=" + r11.f15813d0 + ", chunkCount=" + r11.f15814e0 + ", curBytes=" + r11.f15815f0 + ", totalBytes=" + r11.f15817h0 + ", xTotalBytes=" + r11.i0 + ", status=" + r11.f15820j0 + ", isFirstDownload=" + r11.f15822k0 + ", isFirstSuccess=" + r11.l0 + ", downloadTime=" + r11.f15825m0 + ", realDownloadTime=" + r11.f15827n0 + ", backUpUrlUsed=" + r11.f15831p0 + ", httpsToHttpRetryUsed=" + r11.f15833q0 + ", startDownloadTime=" + r11.f15835r0 + ", realStartDownloadTime=" + r11.f15836s0 + ", bindValueCount=" + r11.f15838t0 + ", autoResumed=" + r11.f15840u0 + ", showNotificationForAutoResumed=" + r11.f15842v0 + ", showNotificationForNetworkResumed=" + r11.f15844w0 + ", forbiddenBackupUrls=" + r11.f15846x0 + ", byteInvalidRetryStatus=" + r11.f15848y0 + ", enqueueType=" + r11.f15850z0 + ", httpStatusCode=" + r11.A0 + ", httpStatusMessage='" + r11.B0 + "', lastNotifyProgressTime=" + r11.F0 + ", isForbiddenRetryed=" + r11.G0 + ", appVersionCode=" + r11.H0 + ", throttleNetSpeed=" + r11.I0 + ", throttleSmoothness=" + r11.J0 + ", openLimitSpeed=false, isCacheExistsInDownloading=" + r11.M0 + ", contentEncoding='" + r11.N0 + "', addListenerToSameTask=" + r11.O0 + ", backUpUrlsStr='" + r11.P0 + "', failedException=" + r11.Q0 + ", pcdnStats=" + r11.R0 + ", spData=" + r11.S0 + ", dbJsonData=" + r11.T0 + ", dbJsonDataString='" + r11.U0 + "', tempCacheData=null, statusAtDbInit=" + r11.V0 + ", mDownloadFromReserveWifi=" + r11.W0 + ", packageInfoRef=null, ttnetProtectTimeout=" + r11.X0 + ", addTTNetCommonParam=" + r11.Y0 + ", accessHttpHeaderKeys=" + r11.Z0 + ", httpHeaders=" + r11.f15807a1 + ", isAutoInstallWithoutNotification=" + r11.d1 + '}', true);
        Logger.a("DownloadProcessDispatcherService", r11.l(), r11.P, "tryDownload", "Setting:" + DownloadSetting.a(r11.l(), null), true);
    L7:
        DownloadProcessDispatcher.a().a(r10);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
    public final void b(int r5) {
        IDownloadProxy r10 = DownloadProcessDispatcher.a().a(r5);
        if (r10 != null) goto L5;
        return;
    L5:
        r10.b(r5, false);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
    public final void e(int r5) {
        DownloadProcessDispatcher r10 = DownloadProcessDispatcher.a();
        r10.getClass();
        if (DownloadHelper.b() == false) goto L14;
        IDownloadProxy r11 = DownloadProxy.a(true);
        if (r11 == null) goto L8;
        r11.e(r5);
    L8:
        if (DownloadUtils.b() == true) goto L20;
        IDownloadProxy r12 = DownloadProxy.a();
        if (r12 == null) goto L19;
        ((ProcessDownloadHandler) r12).e(r5);
        return;
    L19:
        return;
    L20:
        return;
    L14:
        IDownloadProxy r13 = r10.a(r5);
        if (r13 == null) goto L17;
        r13.e(r5);
    L17:
        DownloadProxy.a(true).b(2, r5);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
    public final boolean f(int r5) {
        DownloadHelper.a("isDownloading");
        IDownloadProxy r10 = DownloadProcessDispatcher.a().a(r5);
        if (r10 != null) goto L7;
        return false;
    L7:
        return r10.f(r5);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
    public final void g(int r5) {
        IDownloadProxy r10 = DownloadProcessDispatcher.a().a(r5);
        if (r10 != null) goto L5;
        return;
    L5:
        r10.g(r5);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
    public final void b() {
        DownloadProcessDispatcher.a().getClass();
        IDownloadProxy r5 = DownloadProxy.a();
        if (r5 == null) goto L6;
        ((ProcessDownloadHandler) r5).b();
    L6:
        if (DownloadUtils.b() == true) goto L13;
        IDownloadProxy r10 = DownloadProxy.a(true);
        if (r10 == null) goto L12;
        r10.b();
        return;
    L12:
        return;
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
    public final void b(ArrayList r5) {
        DownloadProcessDispatcher.a().getClass();
        IDownloadProxy r10 = DownloadProxy.a();
        if (r10 == null) goto L6;
        ((ProcessDownloadHandler) r10).b(r5);
    L6:
        if (DownloadUtils.b() == true) goto L13;
        IDownloadProxy r11 = DownloadProxy.a(true);
        if (r11 == null) goto L12;
        r11.b(r5);
        return;
    L12:
        return;
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
    public final List b(String r5) {
        DownloadProcessDispatcher.a().getClass();
        IDownloadProxy r10 = DownloadProxy.a();
        if (r10 != null) goto L5;
        return null;
    L5:
        IDownloadCache r11 = ((ProcessDownloadHandler) r10).f15742b;
        if (r11 != null) goto L8;
    L17:
        return null;
    L8:
        if ((r11 instanceof DefaultDownloadCache) == false) goto L17;
        ISqlDownloadCache r12 = ((DefaultDownloadCache) r11).f15675b;
        if (r12 == null) goto L17;
        if ((r12 instanceof SqlDownloadCache) == false) goto L17;
        return ((SqlDownloadCache) r12).f(r5);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
    public final void a(ArrayList r5) {
        DownloadProcessDispatcher.a().getClass();
        IDownloadProxy r10 = DownloadProxy.a();
        if (r10 == null) goto L6;
        ((ProcessDownloadHandler) r10).a(r5);
    L6:
        if (DownloadUtils.b() == true) goto L13;
        IDownloadProxy r11 = DownloadProxy.a(true);
        if (r11 == null) goto L12;
        r11.a(r5);
        return;
    L12:
        return;
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
    public final DownloadInfo a(int r5) {
        DownloadHelper.a("getDownloadInfo");
        IDownloadProxy r10 = DownloadProcessDispatcher.a().a(r5);
        if (r10 != null) goto L5;
        return null;
    L5:
        Cleaner r11 = Cleaner.a();
        if (r5 != 0) goto L8;
        r11.getClass();
        boolean r12 = false;
    L9:
        if (r12 == false) goto L12;
        return null;
    L12:
        return r10.a(r5);
    L8:
        r12 = r11.f15223a.a(r5);
        goto L9
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
    public final DownloadInfo a(String r5, String r10) {
        DownloadHelper.a("getDownloadInfo");
        DownloadProcessDispatcher r11 = DownloadProcessDispatcher.a();
        r11.getClass();
        Context r12 = DownloadComponentManager.f15515a;
        int r13 = ((IDownloadIdGeneratorService) DownloadServiceManager.a(IDownloadIdGeneratorService.class)).a(r5, r10);
        Cleaner r14 = Cleaner.a();
        if (r13 != 0) goto L5;
        r14.getClass();
        boolean r15 = false;
    L7:
        if (r15 == false) goto L9;
        return null;
    L9:
        IDownloadProxy r16 = r11.a(r13);
        if (r16 != null) goto L13;
        return null;
    L13:
        return r16.a(r13);
    L5:
        r15 = r14.f15223a.a(r13);
        goto L7
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
    public final void a(int r5, AbsDownloadListener r10, ListenerType r11) {
        DownloadHelper.a("removeDownloadListener");
        IDownloadProxy r12 = DownloadProcessDispatcher.a().a(r5);
        if (r12 != null) goto L5;
        return;
    L5:
        r12.a(r5, r10.hashCode(), r10, r11);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
    public final void a(int r5, IDownloadListener r10, ListenerType r11) {
        DownloadHelper.a("addDownloadListener");
        IDownloadProxy r12 = DownloadProcessDispatcher.a().a(r5);
        if (r12 != null) goto L5;
        return;
    L5:
        r12.a(r5, r10.hashCode(), r10, r11);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
    public final Map a(String r5) {
        DownloadProcessDispatcher.a().getClass();
        IDownloadProxy r10 = DownloadProxy.a();
        if (r10 != null) goto L5;
        return null;
    L5:
        IDownloadCache r11 = ((ProcessDownloadHandler) r10).f15742b;
        if (r11 != null) goto L8;
    L17:
        return null;
    L8:
        if ((r11 instanceof DefaultDownloadCache) == false) goto L17;
        ISqlDownloadCache r12 = ((DefaultDownloadCache) r11).f15675b;
        if (r12 == null) goto L17;
        if ((r12 instanceof SqlDownloadCache) == false) goto L17;
        return ((SqlDownloadCache) r12).g(r5);
    }
}
