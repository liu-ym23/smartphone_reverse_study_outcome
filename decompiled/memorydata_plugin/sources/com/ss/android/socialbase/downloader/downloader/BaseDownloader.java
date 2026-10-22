package com.ss.android.socialbase.downloader.downloader;

import android.content.Context;
import android.text.TextUtils;
import com.ss.android.socialbase.downloader.constants.ListenerType;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.depend.aa;
import com.ss.android.socialbase.downloader.depend.ac;
import com.ss.android.socialbase.downloader.depend.ae;
import com.ss.android.socialbase.downloader.depend.af;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
class BaseDownloader {
    private static com.ss.android.socialbase.downloader.service.m globalThrottleService;
    private com.ss.android.socialbase.downloader.service.l componentService;
    private com.ss.android.socialbase.downloader.service.t dispatcherService;
    private String globalDefaultSavePath;
    private String globalDefaultSaveTempPath;

    static {
        globalThrottleService = (com.ss.android.socialbase.downloader.service.m) ZeusTransformUtils.preCheckCast(com.ss.android.socialbase.downloader.service.k.a(com.ss.android.socialbase.downloader.service.m.class), com.ss.android.socialbase.downloader.service.m.class, "com.obric.memorydata.plugin");
    }

    BaseDownloader() {
        this.dispatcherService = (com.ss.android.socialbase.downloader.service.t) ZeusTransformUtils.preCheckCast(com.ss.android.socialbase.downloader.service.k.a(com.ss.android.socialbase.downloader.service.t.class), com.ss.android.socialbase.downloader.service.t.class, "com.obric.memorydata.plugin");
        this.componentService = (com.ss.android.socialbase.downloader.service.l) ZeusTransformUtils.preCheckCast(com.ss.android.socialbase.downloader.service.k.a(com.ss.android.socialbase.downloader.service.l.class), com.ss.android.socialbase.downloader.service.l.class, "com.obric.memorydata.plugin");
    }

    private File getGlobalSaveDir(String r2) {
        if (TextUtils.isEmpty(r2) == false) goto L5;
        return null;
    L5:
        File r1 = new File(r2);
        if (com.ss.android.socialbase.downloader.utils.a.b(r1) == false) goto L8;
        return r1;
    L8:
        return null;
    }

    public static void setGlobalThrottleSpeed(Context r2, int r3, int r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        globalThrottleService.a(r3, r4);
    }

    public static DownloadTask with(Context r2) {
        Downloader.getInstance((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"));
        return new DownloadTask();
    }

    public void addMainThreadListener(int r3, IDownloadListener r4) {
        IDownloadListener r5 = (IDownloadListener) ZeusTransformUtils.wrapperContextForParams(r4, IDownloadListener.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L5;
        return;
    L5:
        this.dispatcherService.b(r3, r5, ListenerType.MAIN, false);
    }

    public void addNotificationListener(int r3, IDownloadListener r4) {
        IDownloadListener r5 = (IDownloadListener) ZeusTransformUtils.wrapperContextForParams(r4, IDownloadListener.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L5;
        return;
    L5:
        this.dispatcherService.b(r3, r5, ListenerType.NOTIFICATION, false);
    }

    public void addSubThreadListener(int r3, IDownloadListener r4) {
        IDownloadListener r5 = (IDownloadListener) ZeusTransformUtils.wrapperContextForParams(r4, IDownloadListener.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L5;
        return;
    L5:
        this.dispatcherService.b(r3, r5, ListenerType.SUB, false);
    }

    public boolean canResume(int r1) {
        return this.dispatcherService.c(r1);
    }

    public void cancel(int r2) {
        cancel(r2, true);
    }

    public void cancel(int r1, boolean r2) {
        this.dispatcherService.a(r1, r2);
    }

    public long clearAllDownloadCache(boolean r1) {
        return this.componentService.a(r1);
    }

    public void clearDownloadData(int r2) {
        this.dispatcherService.b(r2, true);
    }

    public void clearDownloadData(int r1, boolean r2) {
        this.dispatcherService.b(r1, r2);
    }

    public void clearMemoryCacheData(double r1) {
        this.componentService.a(r1);
    }

    public void destoryDownloader() {
        this.componentService.e();
    }

    public void enableLruCache() {
        this.componentService.j();
    }

    @Deprecated
    public List<DownloadInfo> getAllDownloadInfo() {
        return this.dispatcherService.c();
    }

    public long getCurBytes(int r1) {
        return this.dispatcherService.e(r1);
    }

    public com.ss.android.socialbase.downloader.depend.t getDownloadFileUriProvider(int r1) {
        return this.dispatcherService.k(r1);
    }

    public int getDownloadId(String r1, String r2) {
        return this.dispatcherService.a(r1, r2);
    }

    public DownloadInfo getDownloadInfo(int r1) {
        return this.dispatcherService.h(r1);
    }

    public DownloadInfo getDownloadInfo(String r1, String r2) {
        return this.dispatcherService.b(r1, r2);
    }

    public List<DownloadInfo> getDownloadInfoList(String r1) {
        return this.dispatcherService.a(r1);
    }

    public List<DownloadInfo> getDownloadInfosByFileExtension(String r1) {
        return this.dispatcherService.e(r1);
    }

    public aa getDownloadNotificationEventListener(int r1) {
        return this.dispatcherService.i(r1);
    }

    public List<DownloadInfo> getDownloadingDownloadInfosWithMimeType(String r1) {
        return this.dispatcherService.d(r1);
    }

    public File getGlobalSaveDir() {
        return getGlobalSaveDir(this.globalDefaultSavePath);
    }

    public File getGlobalSaveTempDir() {
        return getGlobalSaveDir(this.globalDefaultSaveTempPath);
    }

    public q getReserveWifiStatusListener() {
        return this.componentService.g();
    }

    public int getStatus(int r1) {
        return this.dispatcherService.f(r1);
    }

    public List<DownloadInfo> getSuccessedDownloadInfosWithMimeType(String r1) {
        return this.dispatcherService.b(r1);
    }

    public List<DownloadInfo> getUnCompletedDownloadInfosWithMimeType(String r1) {
        return this.dispatcherService.c(r1);
    }

    public void initDownloadCacheImmediately() {
        this.componentService.i();
    }

    public boolean isDownloadCacheSyncSuccess() {
        return this.dispatcherService.d();
    }

    public boolean isDownloadSuccessAndFileNotExist(DownloadInfo r1) {
        return this.dispatcherService.a(r1);
    }

    public boolean isDownloading(int r1) {
        return this.dispatcherService.g(r1);
    }

    public boolean isHttpServiceInit() {
        return this.dispatcherService.b();
    }

    public void pause(int r1) {
        this.dispatcherService.a(r1);
    }

    public void pauseAll() {
        this.dispatcherService.a();
    }

    public void registerDownloadCacheSyncListener(com.ss.android.socialbase.downloader.depend.i r3) {
        com.ss.android.socialbase.downloader.depend.i r4 = (com.ss.android.socialbase.downloader.depend.i) ZeusTransformUtils.wrapperContextForParams(r3, com.ss.android.socialbase.downloader.depend.i.class, "com.obric.memorydata.plugin");
        this.dispatcherService.a(r4);
    }

    public void registerDownloaderProcessConnectedListener(af r3) {
        af r4 = (af) ZeusTransformUtils.wrapperContextForParams(r3, af.class, "com.obric.memorydata.plugin");
        this.dispatcherService.a(r4);
    }

    public void removeMainThreadListener(int r3, IDownloadListener r4) {
        IDownloadListener r5 = (IDownloadListener) ZeusTransformUtils.wrapperContextForParams(r4, IDownloadListener.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L5;
        return;
    L5:
        this.dispatcherService.a(r3, r5, ListenerType.MAIN, false);
    }

    public void removeNotificationListener(int r3, IDownloadListener r4) {
        IDownloadListener r5 = (IDownloadListener) ZeusTransformUtils.wrapperContextForParams(r4, IDownloadListener.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L5;
        return;
    L5:
        this.dispatcherService.a(r3, r5, ListenerType.NOTIFICATION, false);
    }

    public void removeSubThreadListener(int r3, IDownloadListener r4) {
        IDownloadListener r5 = (IDownloadListener) ZeusTransformUtils.wrapperContextForParams(r4, IDownloadListener.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L5;
        return;
    L5:
        this.dispatcherService.a(r3, r5, ListenerType.SUB, false);
    }

    @Deprecated
    public void removeTaskMainListener(int r4) {
        this.dispatcherService.a(r4, null, ListenerType.MAIN, true);
    }

    @Deprecated
    public void removeTaskNotificationListener(int r4) {
        this.dispatcherService.a(r4, null, ListenerType.NOTIFICATION, true);
    }

    @Deprecated
    public void removeTaskSubListener(int r4) {
        this.dispatcherService.a(r4, null, ListenerType.SUB, true);
    }

    public void restart(int r1) {
        this.dispatcherService.d(r1);
    }

    public void restartAllFailedDownloadTasks(List<String> r3) {
        List<String> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.dispatcherService.a(r4);
    }

    public void restartAllPauseReserveOnWifiDownloadTasks(List<String> r3) {
        List<String> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.dispatcherService.b(r4);
    }

    public void resume(int r1) {
        this.dispatcherService.b(r1);
    }

    public void setDefaultSavePath(String r2) {
        if (TextUtils.isEmpty(r2) == true) goto L6;
        this.globalDefaultSavePath = r2;
        return;
    }

    public void setDefaultSaveTempPath(String r2) {
        if (TextUtils.isEmpty(r2) == true) goto L6;
        this.globalDefaultSaveTempPath = r2;
        return;
    }

    public void setDownloadDBListener(com.ss.android.socialbase.downloader.depend.m r3) {
        com.ss.android.socialbase.downloader.depend.m r4 = (com.ss.android.socialbase.downloader.depend.m) ZeusTransformUtils.wrapperContextForParams(r3, com.ss.android.socialbase.downloader.depend.m.class, "com.obric.memorydata.plugin");
        this.componentService.a(r4);
    }

    public void setDownloadInMultiProcess() {
        this.componentService.f();
    }

    public void setDownloadMemoryInfoListener(k r3) {
        k r4 = (k) ZeusTransformUtils.wrapperContextForParams(r3, k.class, "com.obric.memorydata.plugin");
        this.componentService.a(r4);
    }

    public void setDownloadNotificationEventListener(int r3, aa r4) {
        aa r5 = (aa) ZeusTransformUtils.wrapperContextForParams(r4, aa.class, "com.obric.memorydata.plugin");
        this.dispatcherService.a(r3, r5);
    }

    public void setDownloadStatusListener(ac r3) {
        ac r4 = (ac) ZeusTransformUtils.wrapperContextForParams(r3, ac.class, "com.obric.memorydata.plugin");
        this.componentService.a(r4);
    }

    public void setDownloadThreadCheckListener(ae r3) {
        ae r4 = (ae) ZeusTransformUtils.wrapperContextForParams(r3, ae.class, "com.obric.memorydata.plugin");
        this.componentService.a(r4);
    }

    public void setLogLevel(int r1) {
        this.dispatcherService.j(r1);
    }

    @Deprecated
    public void setMainThreadListener(int r3, IDownloadListener r4) {
        IDownloadListener r5 = (IDownloadListener) ZeusTransformUtils.wrapperContextForParams(r4, IDownloadListener.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L5;
        return;
    L5:
        this.dispatcherService.b(r3, r5, ListenerType.MAIN, true);
    }

    @Deprecated
    public void setMainThreadListener(int r7, IDownloadListener r8, boolean r9) {
        IDownloadListener r2 = (IDownloadListener) ZeusTransformUtils.wrapperContextForParams(r8, IDownloadListener.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L5;
        return;
    L5:
        this.dispatcherService.a(r7, r2, ListenerType.MAIN, true, r9);
    }

    @Deprecated
    public void setNotificationListener(int r3, IDownloadListener r4) {
        IDownloadListener r5 = (IDownloadListener) ZeusTransformUtils.wrapperContextForParams(r4, IDownloadListener.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L5;
        return;
    L5:
        this.dispatcherService.b(r3, r5, ListenerType.NOTIFICATION, true);
    }

    public void setReserveWifiStatusListener(q r3) {
        q r4 = (q) ZeusTransformUtils.wrapperContextForParams(r3, q.class, "com.obric.memorydata.plugin");
        this.componentService.a(r4);
    }

    @Deprecated
    public void setSubThreadListener(int r3, IDownloadListener r4) {
        IDownloadListener r5 = (IDownloadListener) ZeusTransformUtils.wrapperContextForParams(r4, IDownloadListener.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L5;
        return;
    L5:
        this.dispatcherService.b(r3, r5, ListenerType.SUB, true);
    }

    public void setThrottleNetSpeed(int r2, long r3) {
        setThrottleNetSpeed(r2, r3, 0);
    }

    public void setThrottleNetSpeed(int r1, long r2, int r4) {
        this.dispatcherService.a(r1, r2, r4);
    }

    public void startThrottle(String[] r1, long r2) {
        this.componentService.a(r1, r2);
    }

    public void stopThrottle(String[] r1) {
        this.componentService.a(r1);
    }

    public void unRegisterDownloadCacheSyncListener(com.ss.android.socialbase.downloader.depend.i r3) {
        com.ss.android.socialbase.downloader.depend.i r4 = (com.ss.android.socialbase.downloader.depend.i) ZeusTransformUtils.wrapperContextForParams(r3, com.ss.android.socialbase.downloader.depend.i.class, "com.obric.memorydata.plugin");
        this.dispatcherService.b(r4);
    }

    public void unRegisterDownloaderProcessConnectedListener(af r3) {
        af r4 = (af) ZeusTransformUtils.wrapperContextForParams(r3, af.class, "com.obric.memorydata.plugin");
        this.dispatcherService.b(r4);
    }

    public void updateDownloadInfo(DownloadInfo r1) {
        this.componentService.a(r1);
    }

    public void updateDownloadSpInfo() {
        this.componentService.k();
    }
}
