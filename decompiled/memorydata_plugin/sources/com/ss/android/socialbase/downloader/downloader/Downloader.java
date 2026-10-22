package com.ss.android.socialbase.downloader.downloader;

import android.content.Context;
import android.util.Log;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.depend.aa;
import com.ss.android.socialbase.downloader.depend.ac;
import com.ss.android.socialbase.downloader.depend.ae;
import com.ss.android.socialbase.downloader.depend.af;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class Downloader extends BaseDownloader {
    private static final String TAG = "Downloader";
    private static volatile Downloader instance = null;
    private static volatile boolean mSetContext = false;

    static {
    }

    private Downloader() {
    }

    Downloader(f r3) {
        ((com.ss.android.socialbase.downloader.service.l) ZeusTransformUtils.preCheckCast(com.ss.android.socialbase.downloader.service.k.a(com.ss.android.socialbase.downloader.service.l.class), com.ss.android.socialbase.downloader.service.l.class, "com.obric.memorydata.plugin")).a(r3);
    }

    private static void checkContext(Context r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
        if (mSetContext == false) goto L6;
        return;
    L6:
        monitor-enter(Downloader.class);
    L21:
        th = move-exception;
        throw th;
    L8:
        if (mSetContext == false) goto L25;
        monitor-exit(Downloader.class);     // Catch: Throwable -> L21
        return;
    L25:
        if (r6 == null) goto L14;
        ((com.ss.android.socialbase.downloader.service.l) ZeusTransformUtils.preCheckCast(com.ss.android.socialbase.downloader.service.k.a(com.ss.android.socialbase.downloader.service.l.class), com.ss.android.socialbase.downloader.service.l.class, "com.obric.memorydata.plugin")).a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r6.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L17
        mSetContext = true;     // Catch: Throwable -> L17
    L24:
    L19:
        monitor-exit(Downloader.class);     // Catch: Throwable -> L21
        return;
    L14:
        if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L24;
        com.ss.android.socialbase.downloader.e.a.a(TAG, "checkContext", "Context is null " + Log.getStackTraceString(new Throwable("context_empty")));     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L21
        com.ss.android.socialbase.downloader.e.a.b(TAG, "checkContext", "Error:" + th);     // Catch: Throwable -> L21
        goto L19
    }

    public static Downloader getInstance(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        if (instance == null) goto L5;
    L14:
        checkContext(r5);
        return instance;
    L5:
        monitor-enter(Downloader.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (instance != null) goto L9;
        ((com.ss.android.socialbase.downloader.service.l) ZeusTransformUtils.preCheckCast(com.ss.android.socialbase.downloader.service.k.a(com.ss.android.socialbase.downloader.service.l.class), com.ss.android.socialbase.downloader.service.l.class, "com.obric.memorydata.plugin")).a(r5);     // Catch: Throwable -> L11
        instance = new Downloader();     // Catch: Throwable -> L11
    L9:
        monitor-exit(Downloader.class);     // Catch: Throwable -> L11
        goto L14
    }

    public static void init(f r1) {
        initOrCover(r1, false);
    }

    public static synchronized void initOrCover(f r4, boolean r5) {
        monitor-enter(Downloader.class);
        if (r4 != null) goto L22;
        monitor-exit(Downloader.class);
        return;
    L22:
    L19:
        th = move-exception;
        throw th;
    L8:
        if (instance != null) goto L12;
        instance = r4.x();     // Catch: Throwable -> L19
        monitor-exit(Downloader.class);
        return;
    L12:
        com.ss.android.socialbase.downloader.service.l r1 = (com.ss.android.socialbase.downloader.service.l) ZeusTransformUtils.preCheckCast(com.ss.android.socialbase.downloader.service.k.a(com.ss.android.socialbase.downloader.service.l.class), com.ss.android.socialbase.downloader.service.l.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L19
        if (r1.d() == true) goto L15;
        r1.a(r4);     // Catch: Throwable -> L19
    L17:
        monitor-exit(Downloader.class);
        return;
    L15:
        if (r5 == false) goto L17;
        r1.b(r4);     // Catch: Throwable -> L19
        goto L17
    }

    public static void loadService(o r2) {
        com.ss.android.socialbase.downloader.service.k.a((o) ZeusTransformUtils.wrapperContextForParams(r2, o.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* synthetic */ void addMainThreadListener(int r3, IDownloadListener r4) {
        super.addMainThreadListener(r3, (IDownloadListener) ZeusTransformUtils.wrapperContextForParams(r4, IDownloadListener.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* synthetic */ void addNotificationListener(int r3, IDownloadListener r4) {
        super.addNotificationListener(r3, (IDownloadListener) ZeusTransformUtils.wrapperContextForParams(r4, IDownloadListener.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* synthetic */ void addSubThreadListener(int r3, IDownloadListener r4) {
        super.addSubThreadListener(r3, (IDownloadListener) ZeusTransformUtils.wrapperContextForParams(r4, IDownloadListener.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ boolean canResume(int r1) {
        return super.canResume(r1);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void cancel(int r1) {
        super.cancel(r1);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void cancel(int r1, boolean r2) {
        super.cancel(r1, r2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ long clearAllDownloadCache(boolean r1) {
        return super.clearAllDownloadCache(r1);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void clearDownloadData(int r1) {
        super.clearDownloadData(r1);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void clearDownloadData(int r1, boolean r2) {
        super.clearDownloadData(r1, r2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void clearMemoryCacheData(double r1) {
        super.clearMemoryCacheData(r1);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void destoryDownloader() {
        super.destoryDownloader();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void enableLruCache() {
        super.enableLruCache();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    @Deprecated
    public /* bridge */ /* synthetic */ List getAllDownloadInfo() {
        return super.getAllDownloadInfo();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ long getCurBytes(int r1) {
        return super.getCurBytes(r1);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ com.ss.android.socialbase.downloader.depend.t getDownloadFileUriProvider(int r1) {
        return super.getDownloadFileUriProvider(r1);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ int getDownloadId(String r1, String r2) {
        return super.getDownloadId(r1, r2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ DownloadInfo getDownloadInfo(int r1) {
        return super.getDownloadInfo(r1);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ DownloadInfo getDownloadInfo(String r1, String r2) {
        return super.getDownloadInfo(r1, r2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ List getDownloadInfoList(String r1) {
        return super.getDownloadInfoList(r1);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ List getDownloadInfosByFileExtension(String r1) {
        return super.getDownloadInfosByFileExtension(r1);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ aa getDownloadNotificationEventListener(int r1) {
        return super.getDownloadNotificationEventListener(r1);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ List getDownloadingDownloadInfosWithMimeType(String r1) {
        return super.getDownloadingDownloadInfosWithMimeType(r1);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ File getGlobalSaveDir() {
        return super.getGlobalSaveDir();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ File getGlobalSaveTempDir() {
        return super.getGlobalSaveTempDir();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ q getReserveWifiStatusListener() {
        return super.getReserveWifiStatusListener();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ int getStatus(int r1) {
        return super.getStatus(r1);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ List getSuccessedDownloadInfosWithMimeType(String r1) {
        return super.getSuccessedDownloadInfosWithMimeType(r1);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ List getUnCompletedDownloadInfosWithMimeType(String r1) {
        return super.getUnCompletedDownloadInfosWithMimeType(r1);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void initDownloadCacheImmediately() {
        super.initDownloadCacheImmediately();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ boolean isDownloadCacheSyncSuccess() {
        return super.isDownloadCacheSyncSuccess();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ boolean isDownloadSuccessAndFileNotExist(DownloadInfo r1) {
        return super.isDownloadSuccessAndFileNotExist(r1);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ boolean isDownloading(int r1) {
        return super.isDownloading(r1);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ boolean isHttpServiceInit() {
        return super.isHttpServiceInit();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void pause(int r1) {
        super.pause(r1);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void pauseAll() {
        super.pauseAll();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* synthetic */ void registerDownloadCacheSyncListener(com.ss.android.socialbase.downloader.depend.i r3) {
        super.registerDownloadCacheSyncListener((com.ss.android.socialbase.downloader.depend.i) ZeusTransformUtils.wrapperContextForParams(r3, com.ss.android.socialbase.downloader.depend.i.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* synthetic */ void registerDownloaderProcessConnectedListener(af r3) {
        super.registerDownloaderProcessConnectedListener((af) ZeusTransformUtils.wrapperContextForParams(r3, af.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* synthetic */ void removeMainThreadListener(int r3, IDownloadListener r4) {
        super.removeMainThreadListener(r3, (IDownloadListener) ZeusTransformUtils.wrapperContextForParams(r4, IDownloadListener.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* synthetic */ void removeNotificationListener(int r3, IDownloadListener r4) {
        super.removeNotificationListener(r3, (IDownloadListener) ZeusTransformUtils.wrapperContextForParams(r4, IDownloadListener.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* synthetic */ void removeSubThreadListener(int r3, IDownloadListener r4) {
        super.removeSubThreadListener(r3, (IDownloadListener) ZeusTransformUtils.wrapperContextForParams(r4, IDownloadListener.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    @Deprecated
    public /* bridge */ /* synthetic */ void removeTaskMainListener(int r1) {
        super.removeTaskMainListener(r1);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    @Deprecated
    public /* bridge */ /* synthetic */ void removeTaskNotificationListener(int r1) {
        super.removeTaskNotificationListener(r1);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    @Deprecated
    public /* bridge */ /* synthetic */ void removeTaskSubListener(int r1) {
        super.removeTaskSubListener(r1);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void restart(int r1) {
        super.restart(r1);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* synthetic */ void restartAllFailedDownloadTasks(List r3) {
        super.restartAllFailedDownloadTasks((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* synthetic */ void restartAllPauseReserveOnWifiDownloadTasks(List r3) {
        super.restartAllPauseReserveOnWifiDownloadTasks((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void resume(int r1) {
        super.resume(r1);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void setDefaultSavePath(String r1) {
        super.setDefaultSavePath(r1);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void setDefaultSaveTempPath(String r1) {
        super.setDefaultSaveTempPath(r1);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* synthetic */ void setDownloadDBListener(com.ss.android.socialbase.downloader.depend.m r3) {
        super.setDownloadDBListener((com.ss.android.socialbase.downloader.depend.m) ZeusTransformUtils.wrapperContextForParams(r3, com.ss.android.socialbase.downloader.depend.m.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void setDownloadInMultiProcess() {
        super.setDownloadInMultiProcess();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* synthetic */ void setDownloadMemoryInfoListener(k r3) {
        super.setDownloadMemoryInfoListener((k) ZeusTransformUtils.wrapperContextForParams(r3, k.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* synthetic */ void setDownloadNotificationEventListener(int r3, aa r4) {
        super.setDownloadNotificationEventListener(r3, (aa) ZeusTransformUtils.wrapperContextForParams(r4, aa.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* synthetic */ void setDownloadStatusListener(ac r3) {
        super.setDownloadStatusListener((ac) ZeusTransformUtils.wrapperContextForParams(r3, ac.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* synthetic */ void setDownloadThreadCheckListener(ae r3) {
        super.setDownloadThreadCheckListener((ae) ZeusTransformUtils.wrapperContextForParams(r3, ae.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void setLogLevel(int r1) {
        super.setLogLevel(r1);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    @Deprecated
    public /* synthetic */ void setMainThreadListener(int r3, IDownloadListener r4) {
        super.setMainThreadListener(r3, (IDownloadListener) ZeusTransformUtils.wrapperContextForParams(r4, IDownloadListener.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    @Deprecated
    public /* synthetic */ void setMainThreadListener(int r3, IDownloadListener r4, boolean r5) {
        super.setMainThreadListener(r3, (IDownloadListener) ZeusTransformUtils.wrapperContextForParams(r4, IDownloadListener.class, "com.obric.memorydata.plugin"), r5);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    @Deprecated
    public /* synthetic */ void setNotificationListener(int r3, IDownloadListener r4) {
        super.setNotificationListener(r3, (IDownloadListener) ZeusTransformUtils.wrapperContextForParams(r4, IDownloadListener.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* synthetic */ void setReserveWifiStatusListener(q r3) {
        super.setReserveWifiStatusListener((q) ZeusTransformUtils.wrapperContextForParams(r3, q.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    @Deprecated
    public /* synthetic */ void setSubThreadListener(int r3, IDownloadListener r4) {
        super.setSubThreadListener(r3, (IDownloadListener) ZeusTransformUtils.wrapperContextForParams(r4, IDownloadListener.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void setThrottleNetSpeed(int r1, long r2) {
        super.setThrottleNetSpeed(r1, r2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void setThrottleNetSpeed(int r1, long r2, int r4) {
        super.setThrottleNetSpeed(r1, r2, r4);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void startThrottle(String[] r1, long r2) {
        super.startThrottle(r1, r2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void stopThrottle(String[] r1) {
        super.stopThrottle(r1);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* synthetic */ void unRegisterDownloadCacheSyncListener(com.ss.android.socialbase.downloader.depend.i r3) {
        super.unRegisterDownloadCacheSyncListener((com.ss.android.socialbase.downloader.depend.i) ZeusTransformUtils.wrapperContextForParams(r3, com.ss.android.socialbase.downloader.depend.i.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* synthetic */ void unRegisterDownloaderProcessConnectedListener(af r3) {
        super.unRegisterDownloaderProcessConnectedListener((af) ZeusTransformUtils.wrapperContextForParams(r3, af.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void updateDownloadInfo(DownloadInfo r1) {
        super.updateDownloadInfo(r1);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void updateDownloadSpInfo() {
        super.updateDownloadSpInfo();
    }
}
