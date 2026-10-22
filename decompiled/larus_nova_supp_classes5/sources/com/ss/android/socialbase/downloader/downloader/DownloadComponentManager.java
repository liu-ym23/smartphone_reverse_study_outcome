package com.ss.android.socialbase.downloader.downloader;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.LinkProperties;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.RouteInfo;
import android.os.Build;
import android.text.TextUtils;
import android.util.Patterns;
import androidx.core.content.ContextCompat;
import com.bytedance.crash.Npth;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.ss.android.socialbase.downloader.common.AppStatusManager;
import com.ss.android.socialbase.downloader.constants.DownloadCacheSyncStatus;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.android.socialbase.downloader.depend.GlobalListenerAdaptor;
import com.ss.android.socialbase.downloader.depend.IDownloadCacheSyncStatusListener;
import com.ss.android.socialbase.downloader.depend.IDownloadCompleteHandler;
import com.ss.android.socialbase.downloader.depend.IDownloadDBListener;
import com.ss.android.socialbase.downloader.depend.IDownloadInterceptor;
import com.ss.android.socialbase.downloader.depend.IDownloadNetworkHandler;
import com.ss.android.socialbase.downloader.depend.IDownloadSettings;
import com.ss.android.socialbase.downloader.depend.IDownloadStatusListener;
import com.ss.android.socialbase.downloader.depend.IDownloadTaskExecuteListener;
import com.ss.android.socialbase.downloader.depend.IDownloadThreadCheckListener;
import com.ss.android.socialbase.downloader.depend.INotificationClickCallback;
import com.ss.android.socialbase.downloader.depend.ProcessCallback;
import com.ss.android.socialbase.downloader.impls.AbsDownloadEngine;
import com.ss.android.socialbase.downloader.impls.DefaultDownloadCache;
import com.ss.android.socialbase.downloader.impls.DefaultDownloadEngine;
import com.ss.android.socialbase.downloader.impls.DefaultDownloadHttpService;
import com.ss.android.socialbase.downloader.impls.DefaultDownloadServiceHandler;
import com.ss.android.socialbase.downloader.impls.DownloadHandleService;
import com.ss.android.socialbase.downloader.impls.DownloadProxy;
import com.ss.android.socialbase.downloader.impls.NewDownloadEngine;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.socialbase.downloader.model.DownloadThreadInfo;
import com.ss.android.socialbase.downloader.model.HttpHeader;
import com.ss.android.socialbase.downloader.monitor.IDownloadMonitorListener;
import com.ss.android.socialbase.downloader.monitor.InnerEventListener;
import com.ss.android.socialbase.downloader.network.IDownloadDns;
import com.ss.android.socialbase.downloader.network.IDownloadHeadHttpConnection;
import com.ss.android.socialbase.downloader.network.IDownloadHttpConnection;
import com.ss.android.socialbase.downloader.network.IDownloadHttpService;
import com.ss.android.socialbase.downloader.service.DownloadServiceManager;
import com.ss.android.socialbase.downloader.service.IDownloadIdGeneratorService;
import com.ss.android.socialbase.downloader.service.IDownloadMultiProcService;
import com.ss.android.socialbase.downloader.service.IDownloadNetworkService;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.thread.DefaultThreadFactory;
import com.ss.android.socialbase.downloader.utils.DownloadDirUtils;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadPoolExecutor;
import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadScheduledThreadPoolExecutor;
import java.net.InetAddress;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;
import me.ele.lancet.base.annotations.Skip;
import okhttp3.ConnectionPool;
import okhttp3.Dispatcher;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public class DownloadComponentManager {
    public static final int NET_LIB_DEFAULT = 0;
    public static final int NET_LIB_HOST = 1;
    public static final int NET_LIB_NO_BACKUP = 2;
    public static final String SINGLE_THREAD_NAME = "DTP-Single";
    private static final String TAG = "DownloadComponentManager";
    private static volatile ExecutorService apkInstallThreadExecutor;
    private static volatile Context appContext;
    private static volatile ExecutorService chunkDownloadExecutor;
    private static volatile ExecutorService cpuThreadExecutor;
    private static volatile ExecutorService customThreadExecutor;
    private static volatile ExecutorService dbThreadExecutor;
    private static volatile IDownloadDns defaultDownloadDns;
    private static volatile IDownloadHttpService defaultHttpService;
    private static volatile IDownloadCache downloadCache;
    private static final List<IDownloadCacheSyncStatusListener> downloadCacheSyncStatusListeners = null;
    private static final List<IDownloadCompleteHandler> downloadCompleteHandlers = null;
    private static volatile IDownloadDBListener downloadDBListener;
    private static volatile IDownloadDns downloadDns;
    private static volatile AbsDownloadEngine downloadEngine;
    private static InnerEventListener downloadEventListener;
    private static volatile boolean downloadInMultiProcess;
    private static volatile IDownloadInterceptor downloadInterceptor;
    private static volatile IDownloadLaunchHandler downloadLaunchHandler;
    private static volatile IDownloadMemoryInfoListener downloadMemoryInfoListener;
    private static volatile IDownloadMonitorListener downloadMonitorListener;
    private static volatile IDownloadNetworkHandler downloadNetworkHandler;
    private static volatile DownloadReceiver downloadReceiver;
    private static volatile IDownloadServiceHandler downloadServiceHandler;
    private static volatile IDownloadSettings downloadSettings;
    private static volatile IDownloadStatusListener downloadStatusListener;
    private static final List<IDownloadTaskExecuteListener> downloadTaskExecuteListeners = null;
    private static volatile ExecutorService fastThreadExecutor;
    private static final int fixedCPUPoolSize = 0;
    private static final int fixedDBPoolSize = 0;
    private static final int fixedIOPoolSize = 0;
    private static final int fixedMIXPoolSize = 0;
    private static volatile ExecutorService globalThrottleDownloadExecutor;
    private static volatile boolean hasInit;
    private static volatile IDownloadHttpService httpService;
    private static boolean httpServiceInit;
    private static volatile ITTNetHandler iTTNetHandler;
    private static volatile IDownloadServiceHandler independentDownloadServiceHandler;
    private static volatile IndependentHolderCreator independentHolderCreator;
    private static volatile ExecutorService ioThreadExecutor;
    private static boolean isReceiverRegistered;
    private static volatile IndependentHolderCreator mNormalDBIndependentHolderCreator;
    private static volatile ExecutorService mixApkDownloadExecutor;
    private static volatile ExecutorService mixDefaultDownloadExecutor;
    private static volatile ExecutorService mixFrequentDownloadExecutor;
    private static volatile IMonitorConfig monitorConfig;
    private static boolean needAutoRefreshUnSuccessTask;
    private static volatile INotificationClickCallback notificationClickCallback;
    private static volatile ExecutorService okHttpDispatcherExecutor;
    private static volatile List<ProcessCallback> processCallbacks;
    private static IReserveWifiStatusListener reserveWifiStatusListener;
    private static volatile OkHttpClient sOkHttpClient;
    private static volatile ScheduledExecutorService scheduledExecutor;
    private static volatile ExecutorService segmentThreadExecutor;
    private static volatile ExecutorService singleThreadExecutor;
    private static volatile IDownloadThreadCheckListener threadCheckListener;
    private static int writeBufferSize;

    public interface IndependentHolderCreator {
        ISqlDownloadCache createCache(OnMainProcessRebindErrorListener r1);

        IDownloadProxy createProxy();

        IDownloadServiceHandler createServiceHandler();
    }

    public static void enableLruCache() {
        DownloadUtils.setEnableLruCache(true);
        if (Logger.debug() == false) goto L6;
        Logger.globalDebug(TAG, "enableLruCache", "Run");
        return;
    }

    public static void setNotAutoRebootService(boolean r0) {
    }

    static {
        processCallbacks = new CopyOnWriteArrayList();
        downloadInMultiProcess = false;
        sOkHttpClient = null;
        downloadCompleteHandlers = new ArrayList();
        isReceiverRegistered = false;
        int r1 = Runtime.getRuntime().availableProcessors() + 1;
        fixedCPUPoolSize = r1;
        fixedIOPoolSize = (Runtime.getRuntime().availableProcessors() * 2) + 1;
        fixedMIXPoolSize = r1;
        fixedDBPoolSize = r1;
        writeBufferSize = DownloadConstants.TTNET_DEFAULT_BUFFER_SIZE;
        downloadCacheSyncStatusListeners = new ArrayList();
        downloadTaskExecuteListeners = new ArrayList();
        needAutoRefreshUnSuccessTask = true;
        hasInit = false;
        IDownloadMultiProcService r0 = (IDownloadMultiProcService) DownloadServiceManager.getService(IDownloadMultiProcService.class);
        if (r0 == null) goto L6;
        r0.registerIndependentServiceCreator();
        return;
    }

    public static OkHttpClient.Builder createDownloadClientBuilder() {
        OkHttpClient.Builder r0 = new OkHttpClient.Builder();
        int r1 = DownloadSetting.getGlobalSettings().optInt("connect_timeout", 30000);
        int r2 = DownloadSetting.getGlobalSettings().optInt("io_timeout", 30000);
        long r3 = r1;
        TimeUnit r4 = TimeUnit.MILLISECONDS;
        long r5 = r2;
        r0.connectTimeout(r3, r4).readTimeout(r5, r4).writeTimeout(r5, r4).retryOnConnectionFailure(true).followRedirects(true).protocols(Collections.singletonList(Protocol.HTTP_1_1));
        if (okHttpDispatcherExecutor == null) goto L5;
        r0.dispatcher(new Dispatcher(okHttpDispatcherExecutor));
    L5:
        return r0;
    }

    public static void ensureOPPO() {
        if (TextUtils.isEmpty(DownloadConstants.LOWER_OPPO) == false) goto L6;
        DownloadConstants.LOWER_OPPO = "oppo";
        DownloadConstants.UPPER_OPPO = DownloadConstants.LOWER_OPPO.toUpperCase();
        return;
    }

    public static ExecutorService getApkInstallThreadExecutor() {
        if (apkInstallThreadExecutor != null) goto L24;
        monitor-enter(DownloadComponentManager.class);
    L20:
        th = move-exception;
        throw th;
    L7:
        if (apkInstallThreadExecutor == null) goto L9;
    L18:
        monitor-exit(DownloadComponentManager.class);     // Catch: Throwable -> L20
        goto L24
    L9:
        if (isGlobalThreadPoolOptEnabled() == false) goto L11;
        long r5 = 15;
    L12:
        PThreadPoolExecutor r1 = new PThreadPoolExecutor(2, 2, r5, TimeUnit.SECONDS, new LinkedBlockingQueue(), new DefaultThreadFactory("DownloadThreadPool-apk-install", true));     // Catch: Throwable -> L20
        r1.allowCoreThreadTimeOut(true);     // Catch: Throwable -> L15
    L17:
        apkInstallThreadExecutor = r1;     // Catch: Throwable -> L20
        goto L18
    L15:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L20
        goto L17
    L11:
        r5 = 60;
    L24:
        return apkInstallThreadExecutor;
    }

    public static synchronized Context getAppContext() {
        monitor-enter(DownloadComponentManager.class);
        Context r1 = appContext;     // Catch: Throwable -> L7
        monitor-exit(DownloadComponentManager.class);
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public static ExecutorService getCPUThreadExecutor() {
        if (cpuThreadExecutor != null) goto L24;
        monitor-enter(DownloadComponentManager.class);
    L20:
        th = move-exception;
        throw th;
    L7:
        if (cpuThreadExecutor != null) goto L18;
        int r4 = fixedCPUPoolSize;     // Catch: Throwable -> L20
        if (isGlobalThreadPoolOptEnabled() == false) goto L11;
        long r5 = 8;
        int r3 = r4 / 2;     // Catch: Throwable -> L20
    L12:
        PThreadPoolExecutor r1 = new PThreadPoolExecutor(r3, r4, r5, TimeUnit.SECONDS, new LinkedBlockingQueue(), new DefaultThreadFactory("DownloadThreadPool-cpu-fixed", true));     // Catch: Throwable -> L20
        r1.allowCoreThreadTimeOut(true);     // Catch: Throwable -> L15
    L17:
        cpuThreadExecutor = r1;     // Catch: Throwable -> L20
        goto L18
    L15:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L20
        goto L17
    L11:
        r5 = 15;
        r3 = r4;
    L18:
        monitor-exit(DownloadComponentManager.class);     // Catch: Throwable -> L20
    L24:
        return cpuThreadExecutor;
    }

    public static ExecutorService getChunkDownloadThreadExecutorService() {
        if (chunkDownloadExecutor != null) goto L24;
        monitor-enter(DownloadComponentManager.class);
    L20:
        th = move-exception;
        throw th;
    L7:
        if (chunkDownloadExecutor != null) goto L18;
        int r4 = fixedIOPoolSize;     // Catch: Throwable -> L20
        if (isGlobalThreadPoolOptEnabled() == false) goto L11;
        long r5 = 8;
        int r3 = r4 / 2;     // Catch: Throwable -> L20
    L12:
        PThreadPoolExecutor r1 = new PThreadPoolExecutor(r3, r4, r5, TimeUnit.SECONDS, new LinkedBlockingQueue(), new DefaultThreadFactory("DownloadThreadPool-chunk-fixed", true));     // Catch: Throwable -> L20
        r1.allowCoreThreadTimeOut(true);     // Catch: Throwable -> L15
    L17:
        chunkDownloadExecutor = r1;     // Catch: Throwable -> L20
        goto L18
    L15:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L20
        goto L17
    L11:
        r5 = 15;
        r3 = r4;
    L18:
        monitor-exit(DownloadComponentManager.class);     // Catch: Throwable -> L20
    L24:
        return chunkDownloadExecutor;
    }

    public static ExecutorService getDBThreadExecutorService() {
        if (dbThreadExecutor != null) goto L24;
        monitor-enter(DownloadComponentManager.class);
    L20:
        th = move-exception;
        throw th;
    L7:
        if (dbThreadExecutor != null) goto L18;
        int r4 = fixedDBPoolSize;     // Catch: Throwable -> L20
        if (isGlobalThreadPoolOptEnabled() == false) goto L11;
        long r5 = 8;
        int r3 = r4 / 2;     // Catch: Throwable -> L20
    L12:
        PThreadPoolExecutor r1 = new PThreadPoolExecutor(r3, r4, r5, TimeUnit.SECONDS, new LinkedBlockingQueue(), new DefaultThreadFactory("DownloadThreadPool-db-fixed", true));     // Catch: Throwable -> L20
        r1.allowCoreThreadTimeOut(true);     // Catch: Throwable -> L15
    L17:
        dbThreadExecutor = r1;     // Catch: Throwable -> L20
        goto L18
    L15:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L20
        goto L17
    L11:
        r5 = 15;
        r3 = r4;
    L18:
        monitor-exit(DownloadComponentManager.class);     // Catch: Throwable -> L20
    L24:
        return dbThreadExecutor;
    }

    public static IDownloadDns getDefaultDownloadDns() {
        if (defaultDownloadDns != null) goto L15;
        monitor-enter(DownloadComponentManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (defaultDownloadDns != null) goto L9;
        defaultDownloadDns = new 4();     // Catch: Throwable -> L11
    L9:
        monitor-exit(DownloadComponentManager.class);     // Catch: Throwable -> L11
    L15:
        return defaultDownloadDns;
    }

    public static IDownloadHttpService getDefaultHttpService() {
        if (defaultHttpService != null) goto L15;
        monitor-enter(DownloadComponentManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (defaultHttpService != null) goto L9;
        defaultHttpService = new DefaultDownloadHttpService();     // Catch: Throwable -> L11
    L9:
        monitor-exit(DownloadComponentManager.class);     // Catch: Throwable -> L11
    L15:
        return defaultHttpService;
    }

    public static IDownloadCache getDownloadCache() {
        if (downloadCache != null) goto L15;
        monitor-enter(DownloadComponentManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (downloadCache != null) goto L9;
        downloadCache = new DefaultDownloadCache();     // Catch: Throwable -> L11
    L9:
        monitor-exit(DownloadComponentManager.class);     // Catch: Throwable -> L11
    L15:
        return downloadCache;
    }

    public static AbsDownloadEngine getDownloadEngine() {
        if (downloadEngine != null) goto L15;
        monitor-enter(DownloadComponentManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (downloadEngine != null) goto L9;
        setDownloadEngine();     // Catch: Throwable -> L11
    L9:
        monitor-exit(DownloadComponentManager.class);     // Catch: Throwable -> L11
    L15:
        return downloadEngine;
    }

    public static synchronized IDownloadLaunchHandler getDownloadLaunchHandler() {
        monitor-enter(DownloadComponentManager.class);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (DownloadUtils.ENABLE_APP_DOWNLOADER == true) goto L9;
        monitor-exit(DownloadComponentManager.class);
        return null;
    L9:
        IDownloadLaunchHandler r1 = downloadLaunchHandler;     // Catch: Throwable -> L12
        monitor-exit(DownloadComponentManager.class);
        return r1;
    }

    public static IDownloadServiceHandler getDownloadServiceHandler() {
        if (downloadServiceHandler != null) goto L15;
        monitor-enter(DownloadComponentManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (downloadServiceHandler != null) goto L9;
        downloadServiceHandler = new DefaultDownloadServiceHandler();     // Catch: Throwable -> L11
    L9:
        monitor-exit(DownloadComponentManager.class);     // Catch: Throwable -> L11
    L15:
        return downloadServiceHandler;
    }

    public static JSONObject getDownloadSetting() {
        if (downloadSettings == null) goto L5;
        JSONObject r0 = downloadSettings.get();
    L6:
        if (r0 == null) goto L8;
        return r0;
    L8:
        return DownloadConstants.EMPTY_JSON;
    L5:
        r0 = null;
        goto L6
    }

    public static InnerEventListener getEventListener() {
        if (downloadEventListener != null) goto L6;
        downloadEventListener = new 5();
    L6:
        return downloadEventListener;
    }

    public static ExecutorService getFastThreadExecutor() {
        if (fastThreadExecutor != null) goto L23;
        monitor-enter(DownloadComponentManager.class);
    L19:
        th = move-exception;
        throw th;
    L7:
        if (fastThreadExecutor != null) goto L17;
        int r1 = DownloadSetting.getGlobalSettings().optInt("fast_download_thread_pool_size_limit");     // Catch: Throwable -> L19
        if (r1 > 0) goto L11;
        int r4 = 20;
    L13:
        if (isGlobalThreadPoolOptEnabled() == false) goto L15;
        long r5 = 15;
    L16:
        fastThreadExecutor = new PThreadPoolExecutor(0, r4, r5, TimeUnit.SECONDS, new SynchronousQueue(), new DefaultThreadFactory("DownloadThreadPool-Fast", true));     // Catch: Throwable -> L19
        goto L17
    L15:
        r5 = 60;
        goto L16
    L11:
        r4 = r1;
    L17:
        monitor-exit(DownloadComponentManager.class);     // Catch: Throwable -> L19
    L23:
        return fastThreadExecutor;
    }

    public static ExecutorService getGlobalThrottleThreadExecutor() {
        if (globalThrottleDownloadExecutor != null) goto L25;
        monitor-enter(DownloadComponentManager.class);
    L21:
        th = move-exception;
        throw th;
    L7:
        if (globalThrottleDownloadExecutor != null) goto L19;
        int r1 = fixedMIXPoolSize;     // Catch: Throwable -> L21
        int r2 = r1 * 2;     // Catch: Throwable -> L21
        if (isThrottleThreadPoolOptEnabled() == false) goto L11;
        int r6 = r1;
        long r8 = 8;
    L12:
        PThreadPoolExecutor r3 = new PThreadPoolExecutor(r6, r1 * 2, r8, TimeUnit.SECONDS, new LinkedBlockingQueue(), new DefaultThreadFactory("DownloadThreadPool-global-throttle", true));     // Catch: Throwable -> L21
        if (isThrottleThreadPoolOptEnabled() == true) goto L28;
    L18:
        globalThrottleDownloadExecutor = r3;     // Catch: Throwable -> L21
        goto L19
    L28:
        r3.allowCoreThreadTimeOut(true);     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L21
        goto L18
    L11:
        r6 = r2;
        r8 = 15;
    L19:
        monitor-exit(DownloadComponentManager.class);     // Catch: Throwable -> L21
    L25:
        return globalThrottleDownloadExecutor;
    }

    public static ExecutorService getIOThreadExecutor() {
        if (ioThreadExecutor == null) goto L6;
        return ioThreadExecutor;
    L6:
        return getCPUThreadExecutor();
    }

    public static IDownloadServiceHandler getIndependentDownloadServiceHandler() {
        if (independentDownloadServiceHandler != null) goto L20;
        monitor-enter(DownloadComponentManager.class);
    L16:
        th = move-exception;
        throw th;
    L7:
        if (independentDownloadServiceHandler == null) goto L9;
    L14:
        monitor-exit(DownloadComponentManager.class);     // Catch: Throwable -> L16
        goto L20
    L9:
        if (independentHolderCreator == null) goto L11;
        independentDownloadServiceHandler = independentHolderCreator.createServiceHandler();     // Catch: Throwable -> L16
        goto L14
    L11:
        IDownloadServiceHandler r1 = getDownloadServiceHandler();     // Catch: Throwable -> L16
        monitor-exit(DownloadComponentManager.class);     // Catch: Throwable -> L16
        return r1;
    L20:
        return independentDownloadServiceHandler;
    }

    public static ExecutorService getMixApkThreadExecutor() {
        if (mixApkDownloadExecutor == null) goto L6;
        return mixApkDownloadExecutor;
    L6:
        return getMixDefaultThreadExecutor();
    }

    public static ExecutorService getMixDefaultThreadExecutor() {
        if (mixDefaultDownloadExecutor != null) goto L24;
        monitor-enter(DownloadComponentManager.class);
    L20:
        th = move-exception;
        throw th;
    L7:
        if (mixDefaultDownloadExecutor != null) goto L18;
        int r4 = fixedMIXPoolSize;     // Catch: Throwable -> L20
        if (isGlobalThreadPoolOptEnabled() == false) goto L11;
        long r5 = 8;
        int r3 = r4 / 2;     // Catch: Throwable -> L20
    L12:
        PThreadPoolExecutor r1 = new PThreadPoolExecutor(r3, r4, r5, TimeUnit.SECONDS, new LinkedBlockingQueue(), new DefaultThreadFactory("DownloadThreadPool-mix-fixed", true));     // Catch: Throwable -> L20
        r1.allowCoreThreadTimeOut(true);     // Catch: Throwable -> L15
    L17:
        mixDefaultDownloadExecutor = r1;     // Catch: Throwable -> L20
        goto L18
    L15:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L20
        goto L17
    L11:
        r5 = 15;
        r3 = r4;
    L18:
        monitor-exit(DownloadComponentManager.class);     // Catch: Throwable -> L20
    L24:
        return mixDefaultDownloadExecutor;
    }

    public static ExecutorService getMixFrequentThreadExecutor() {
        if (mixFrequentDownloadExecutor == null) goto L6;
        return mixFrequentDownloadExecutor;
    L6:
        return getMixDefaultThreadExecutor();
    }

    public static synchronized IMonitorConfig getMonitorConfig() {
        monitor-enter(DownloadComponentManager.class);
        IMonitorConfig r1 = monitorConfig;     // Catch: Throwable -> L7
        monitor-exit(DownloadComponentManager.class);
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public static ScheduledExecutorService getScheduledExecutorService() {
        if (scheduledExecutor != null) goto L15;
        monitor-enter(DownloadComponentManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (scheduledExecutor != null) goto L9;
        scheduledExecutor = new PThreadScheduledThreadPoolExecutor(4, new DefaultThreadFactory("DownloadThreadPool-Schedule", true));     // Catch: Throwable -> L11
    L9:
        monitor-exit(DownloadComponentManager.class);     // Catch: Throwable -> L11
    L15:
        return scheduledExecutor;
    }

    public static ExecutorService getSegmentDownloadThreadExecutorService() {
        if (segmentThreadExecutor != null) goto L20;
        monitor-enter(DownloadComponentManager.class);
    L16:
        th = move-exception;
        throw th;
    L7:
        if (segmentThreadExecutor != null) goto L14;
        PThreadPoolExecutor r1 = new PThreadPoolExecutor(1, 1, 15, TimeUnit.SECONDS, new LinkedBlockingQueue(), new DefaultThreadFactory("DownloadThreadPool-segment-fixed", true));     // Catch: Throwable -> L16
        r1.allowCoreThreadTimeOut(true);     // Catch: Throwable -> L11
    L13:
        segmentThreadExecutor = r1;     // Catch: Throwable -> L16
        goto L14
    L11:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L16
    L14:
        monitor-exit(DownloadComponentManager.class);     // Catch: Throwable -> L16
    L20:
        return segmentThreadExecutor;
    }

    public static ExecutorService getSingleThreadExecutorService() {
        if (singleThreadExecutor != null) goto L25;
        monitor-enter(DownloadComponentManager.class);
    L21:
        th = move-exception;
        throw th;
    L7:
        if (singleThreadExecutor == null) goto L9;
    L19:
        monitor-exit(DownloadComponentManager.class);     // Catch: Throwable -> L21
        goto L25
    L9:
        if (isGlobalThreadPoolOptEnabled() == false) goto L11;
        long r5 = 30;
    L12:
        PThreadPoolExecutor r1 = new PThreadPoolExecutor(1, 1, r5, TimeUnit.SECONDS, new LinkedBlockingQueue(), new DefaultThreadFactory(SINGLE_THREAD_NAME, true));     // Catch: Throwable -> L21
        if (isGlobalThreadPoolOptEnabled() == true) goto L26;
    L18:
        singleThreadExecutor = r1;     // Catch: Throwable -> L21
        goto L19
    L26:
        r1.allowCoreThreadTimeOut(true);     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L21
        goto L18
    L11:
        r5 = 60;
    L25:
        return singleThreadExecutor;
    }

    public static ITTNetHandler getTTNetHandler() {
        if (iTTNetHandler != null) goto L15;
        monitor-enter(DownloadComponentManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (iTTNetHandler != null) goto L9;
        iTTNetHandler = new ITTNetHandler.DefaultTTNetHandler();     // Catch: Throwable -> L11
    L9:
        monitor-exit(DownloadComponentManager.class);     // Catch: Throwable -> L11
    L15:
        return iTTNetHandler;
    }

    public static synchronized boolean isDownloadInMultiProcess() {
        monitor-enter(DownloadComponentManager.class);
        boolean r1 = downloadInMultiProcess;     // Catch: Throwable -> L7
        monitor-exit(DownloadComponentManager.class);
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public static synchronized boolean isHttpServiceInit() {
        monitor-enter(DownloadComponentManager.class);
        boolean r1 = httpServiceInit;     // Catch: Throwable -> L7
        monitor-exit(DownloadComponentManager.class);
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    private static synchronized void registerDownloadReceiver() {
        monitor-enter(DownloadComponentManager.class);
    L17:
        th = move-exception;
        throw th;
    L5:
        if (downloadReceiver != null) goto L8;
        downloadReceiver = new DownloadReceiver();     // Catch: Throwable -> L17
    L8:
        if (isReceiverRegistered == false) goto L20;
        monitor-exit(DownloadComponentManager.class);
        return;
    L20:
        IntentFilter r1 = new IntentFilter();     // Catch: Throwable -> L13
        r1.addAction("android.net.conn.CONNECTIVITY_CHANGE");     // Catch: Throwable -> L13
        r1.addAction("android.intent.action.MEDIA_MOUNTED");     // Catch: Throwable -> L13
        r1.addAction("android.intent.action.MEDIA_UNMOUNTED");     // Catch: Throwable -> L13
        r1.addAction("android.intent.action.MEDIA_REMOVED");     // Catch: Throwable -> L13
        r1.addAction("android.intent.action.MEDIA_BAD_REMOVAL");     // Catch: Throwable -> L13
        r1.addAction("android.intent.action.MEDIA_EJECT");     // Catch: Throwable -> L13
        INVOKEVIRTUAL_com_ss_android_socialbase_downloader_downloader_DownloadComponentManager_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(appContext, downloadReceiver, r1);     // Catch: Throwable -> L13
        isReceiverRegistered = true;     // Catch: Throwable -> L13
    L15:
        monitor-exit(DownloadComponentManager.class);
        return;
    L13:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L17
        goto L15
    }

    public static synchronized void setDownloadInMultiProcess() {
        monitor-enter(DownloadComponentManager.class);
    L20:
        th = move-exception;
        throw th;
    L5:
        if (downloadInMultiProcess == false) goto L7;
    L18:
        monitor-exit(DownloadComponentManager.class);
        return;
    L7:
        if (supportMultiProc() == false) goto L18;
        Intent r1 = new Intent(getAppContext(), DownloadHandleService.class);     // Catch: Throwable -> L14
        r1.setAction(DownloadConstants.ACTION_DOWNLOAD_MULTI_PROCESS_NOTIFY);     // Catch: Throwable -> L14
        getAppContext().startService(r1);     // Catch: Throwable -> L14
        if (DownloadHelper.isDownloaderProcess() == true) goto L12;
        submitIOTask(new 2());     // Catch: Throwable -> L14
    L12:
        downloadInMultiProcess = true;     // Catch: Throwable -> L14
    L16:
        monitor-exit(DownloadComponentManager.class);
        return;
    L14:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L20
        goto L16
    }

    public static boolean supportMultiProc() {
        if (independentHolderCreator == null) goto L5;
        return true;
    L5:
        return false;
    }

    public static synchronized void unRegisterDownloadReceiver() {
        /*  JADX ERROR: Simple mode code generation failed
            java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
            	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:100)
            	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:106)
            	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:302)
            	at java.base/java.util.Objects.checkIndex(Objects.java:365)
            	at java.base/java.util.ArrayList.get(ArrayList.java:428)
            	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:354)
            	at jadx.core.codegen.MethodGen.addSimpleMethodCode(MethodGen.java:316)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:279)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
            */
        /*
            java.lang.Class<com.ss.android.socialbase.downloader.downloader.DownloadComponentManager> r0 = com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.class
            monitor-enter(r0)
            boolean r1 = com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.isReceiverRegistered     // Catch: java.lang.Throwable -> L1a java.lang.Exception -> L1c
            if (r1 == 0) goto L20
            com.ss.android.socialbase.downloader.downloader.DownloadReceiver r1 = com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.downloadReceiver     // Catch: java.lang.Throwable -> L1a java.lang.Exception -> L1c
            if (r1 == 0) goto L20
            android.content.Context r1 = com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.appContext     // Catch: java.lang.Throwable -> L1a java.lang.Exception -> L1c
            if (r1 == 0) goto L20
            android.content.Context r1 = com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.appContext     // Catch: java.lang.Throwable -> L1a java.lang.Exception -> L1c
            com.ss.android.socialbase.downloader.downloader.DownloadReceiver r2 = com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.downloadReceiver     // Catch: java.lang.Throwable -> L1a java.lang.Exception -> L1c
            INVOKEVIRTUAL_com_ss_android_socialbase_downloader_downloader_DownloadComponentManager_com_bytedance_sysoptimizer_ReceiverRegisterLancet_unregisterReceiver(r1, r2)     // Catch: java.lang.Throwable -> L1a java.lang.Exception -> L1c
            r1 = 0
            com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.isReceiverRegistered = r1     // Catch: java.lang.Throwable -> L1a java.lang.Exception -> L1c
            goto L20
        L1a:
            r1 = move-exception
            goto L22
        L1c:
            r1 = move-exception
            r1.printStackTrace()     // Catch: java.lang.Throwable -> L1a
        L20:
            monitor-exit(r0)
            return
        L22:
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.unRegisterDownloadReceiver():void");
    }

    public static void initDownloadCacheImmediately() {
        getDownloadCache().initImmediately();
    }

    public static boolean isEnableLruCache() {
        return DownloadUtils.isEnableLruCache();
    }

    public static boolean isGlobalThreadPoolOptEnabled() {
        if (DownloadSetting.getGlobalSettings().optInt("global_thread_pool_opt", 0) <= 0) goto L6;
        return true;
    L6:
        return false;
    }

    public static boolean isThrottleThreadPoolOptEnabled() {
        if (DownloadSetting.getGlobalSettings().optInt("throttle_thread_pool_opt", 0) <= 0) goto L6;
        return true;
    L6:
        return false;
    }

    private static void setDownloadEngine() {
        if (DownloadHelper.getCacheSettingInt("optimize_download_cache") <= 0) goto L5;
        downloadEngine = new NewDownloadEngine();
        return;
    L5:
        downloadEngine = new DefaultDownloadEngine();
    }

    private static void setLoggerReport() {
        JSONObject r3 = getDownloadSetting();     // Catch: Throwable -> L37
        int r4 = r3.optInt("downloader_alog_level");     // Catch: Throwable -> L37
        if (Logger.debug() == false) goto L6;
        Logger.globalDebug(TAG, "setLoggerReport", "ALogLevel:" + r4);     // Catch: Throwable -> L37
    L6:
        if (r4 > 0) goto L8;
        return;
    L8:
        ArrayList r2 = new ArrayList();     // Catch: Throwable -> L37
        JSONArray r5 = r3.optJSONArray("downloader_alog_task_scene_list");     // Catch: Throwable -> L37
        int r6 = 0;
        if (r5 != null) goto L11;
    L19:
        ArrayList r7 = new ArrayList();     // Catch: Throwable -> L37
        if (r3.optInt("downloader_logger_global_report") <= 0) goto L22;
        boolean r8 = true;
    L23:
        JSONArray r9 = r3.optJSONArray("downloader_logger_task_report_scene_list");     // Catch: Throwable -> L37
        if (r9 != null) goto L26;
    L33:
        Logger.setLogReportParams(r4, r8, r7, r2);     // Catch: Throwable -> L37
        if (Logger.alog() == false) goto L48;
        Logger.globalDebug(TAG, "setLoggerReport", "Setting: " + getDownloadSetting());     // Catch: Throwable -> L37
        return;
    L48:
        return;
    L26:
        if (r9.length() <= 0) goto L33;
    L28:
        if (r6 >= r9.length()) goto L33;
        String r10 = r9.optString(r6);     // Catch: Throwable -> L37
        if (TextUtils.isEmpty(r10) == true) goto L32;
        r7.add(r10);     // Catch: Throwable -> L37
    L32:
        r6 = r6 + 1;     // Catch: Throwable -> L37
        goto L28
    L22:
        r8 = false;
        goto L23
    L11:
        if (r5.length() <= 0) goto L19;
        int r11 = 0;
    L14:
        if (r11 >= r5.length()) goto L19;
        String r12 = r5.optString(r11);     // Catch: Throwable -> L37
        if (TextUtils.isEmpty(r12) == true) goto L18;
        r2.add(r12);     // Catch: Throwable -> L37
    L18:
        r11 = r11 + 1;     // Catch: Throwable -> L37
    L37:
        th = move-exception;
        Logger.globalError(TAG, "setLoggerReport", "Error:" + th);
    }

    private DownloadComponentManager() {
    }

    public static /* synthetic */ void access$100() {
        registerDownloadReceiver();
    }

    public static ExecutorService getCustomThreadExecutor() {
        return customThreadExecutor;
    }

    public static List<IDownloadCompleteHandler> getDownloadCompleteHandlers() {
        return downloadCompleteHandlers;
    }

    public static IDownloadDBListener getDownloadDBListener() {
        return downloadDBListener;
    }

    public static IDownloadDns getDownloadDns() {
        return downloadDns;
    }

    public static IDownloadInterceptor getDownloadInterceptor() {
        return downloadInterceptor;
    }

    public static IDownloadMemoryInfoListener getDownloadMemoryInfoListener() {
        return downloadMemoryInfoListener;
    }

    public static IDownloadMonitorListener getDownloadMonitorListener() {
        return downloadMonitorListener;
    }

    public static IDownloadStatusListener getDownloadStatusListener() {
        return downloadStatusListener;
    }

    public static IDownloadThreadCheckListener getDownloadThreadCheckListener() {
        return threadCheckListener;
    }

    public static IDownloadHttpService getHttpService() {
        return httpService;
    }

    public static IndependentHolderCreator getIndependentHolderCreator() {
        return independentHolderCreator;
    }

    public static IndependentHolderCreator getNormalDBIndependentHolderCreator() {
        return mNormalDBIndependentHolderCreator;
    }

    public static INotificationClickCallback getNotificationClickCallback() {
        return notificationClickCallback;
    }

    public static List<ProcessCallback> getProcessCallbacks() {
        return processCallbacks;
    }

    public static IReserveWifiStatusListener getReserveWifiStatusListener() {
        return reserveWifiStatusListener;
    }

    public static int getWriteBufferSize() {
        return writeBufferSize;
    }

    public static boolean isInit() {
        return hasInit;
    }

    public static boolean needAutoRefreshUnSuccessTask() {
        return needAutoRefreshUnSuccessTask;
    }

    public static /* synthetic */ void access$000(boolean r0) {
        registerIndependentService(r0);
    }

    public static void addDownloadCompleteHandler(IDownloadCompleteHandler r2) {
        List<IDownloadCompleteHandler> r0 = downloadCompleteHandlers;
        monitor-enter(r0);
        if (r2 != null) goto L16;
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L13
        return;
    L16:
    L13:
        th = move-exception;
        throw th;
    L6:
        if (r0.contains(r2) == true) goto L11;
        r0.add(r2);     // Catch: Throwable -> L13
        monitor-exit(r0);     // Catch: Throwable -> L13
    }

    public static void addProcessCallback(ProcessCallback r1) {
        if (r1 != null) goto L4;
        return;
    L4:
        processCallbacks.add(r1);
    }

    private static OkHttpClient buildBoundClient(Network r7) {
        if (r7 != null) goto L10;
        return null;
    L10:
        return createDownloadClientBuilder().connectionPool(new ConnectionPool(0, 1, TimeUnit.MILLISECONDS)).socketFactory(r7.getSocketFactory()).dns(new 3(r7)).build();
    L7:
        th = move-exception;
        Logger.e("buildBoundClient failed: " + th);
        return null;
    }

    public static synchronized void coverComponent(DownloaderBuilder r1) {
        monitor-enter(DownloadComponentManager.class);
        setDownloadBuilder(r1);     // Catch: Throwable -> L7
        monitor-exit(DownloadComponentManager.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private static Network getActiveWifiNetwork(ConnectivityManager r3) {
        Network r1 = r3.getActiveNetwork();     // Catch: Throwable -> L10
        if (r1 == null) goto L15;
        NetworkCapabilities r4 = r3.getNetworkCapabilities(r1);     // Catch: Throwable -> L10
        if (r4 == null) goto L16;
        if (r4.hasTransport(1) == true) goto L18;
        return null;
    L18:
        return r1;
    L16:
        return null;
    L15:
        return null;
    L10:
        th = move-exception;
        Logger.e(TAG, "forceWifi get active wifi network error", th);
        return null;
    }

    public static int getDownloadId(DownloadInfo r1) {
        return ((IDownloadIdGeneratorService) DownloadServiceManager.getService(IDownloadIdGeneratorService.class)).generate(r1);
    }

    private static OkHttpClient getWifiBoundClient(String r10) {
    L33:
        th = move-exception;
        Logger.e("error: " + th);
    L35:
        return null;
    L4:
        if (Build.VERSION.SDK_INT >= 23) goto L6;
    L32:
        return null;
    L6:
        if (getAppContext() == null) goto L32;
        ConnectivityManager r1 = (ConnectivityManager) getAppContext().getSystemService("connectivity");     // Catch: Throwable -> L33
        if (r1 != null) goto L11;
        return null;
    L11:
        TargetInfo r11 = parseTargetInfo(r10);     // Catch: Throwable -> L33
        Network[] r2 = r1.getAllNetworks();     // Catch: Throwable -> L33
        Network r3 = getActiveWifiNetwork(r1);     // Catch: Throwable -> L33
        if (r2 == null) goto L24;
        int r4 = r2.length;     // Catch: Throwable -> L33
        int r5 = 0;
        Network r6 = null;
    L14:
        if (r5 >= r4) goto L25;
        Network r7 = r2[r5];     // Catch: Throwable -> L33
        NetworkCapabilities r8 = r1.getNetworkCapabilities(r7);     // Catch: Throwable -> L33
        LinkProperties r9 = r1.getLinkProperties(r7);     // Catch: Throwable -> L33
        if (isWifiCandidate(r8, r9) == false) goto L23;
        if (r6 != null) goto L20;
        r6 = r7;
    L20:
        OkHttpClient r12 = selectWifiByRoute(r11.target, r7, r9);     // Catch: Throwable -> L33
        if (r12 == null) goto L23;
        return r12;
    L23:
        r5 = r5 + 1;     // Catch: Throwable -> L33
    L25:
        if (r3 == null) goto L29;
        OkHttpClient r13 = buildBoundClient(r3);     // Catch: Throwable -> L33
        if (r13 == null) goto L29;
        return r13;
    L29:
        if (r6 == null) goto L35;
        return buildBoundClient(r6);
    L24:
        r6 = null;
        goto L25
    }

    public static synchronized void initComponent(DownloaderBuilder r3) {
        monitor-enter(DownloadComponentManager.class);
    L33:
        th = move-exception;
        throw th;
    L5:
        if (hasInit == false) goto L9;
        Logger.globalError(TAG, "initComponent", "Component has init");     // Catch: Throwable -> L33
        monitor-exit(DownloadComponentManager.class);
        return;
    L9:
        boolean r1 = downloadInMultiProcess;     // Catch: Throwable -> L33
        setDownloadBuilder(r3);     // Catch: Throwable -> L33
        setLoggerReport();     // Catch: Throwable -> L33
        if (downloadCache != null) goto L13;
        downloadCache = new DefaultDownloadCache();     // Catch: Throwable -> L33
    L13:
        if (downloadServiceHandler != null) goto L16;
        downloadServiceHandler = new DefaultDownloadServiceHandler();     // Catch: Throwable -> L33
    L16:
        if (independentDownloadServiceHandler != null) goto L21;
        if (independentHolderCreator == null) goto L21;
        independentDownloadServiceHandler = independentHolderCreator.createServiceHandler();     // Catch: Throwable -> L33
    L21:
        if (downloadEngine != null) goto L24;
        setDownloadEngine();     // Catch: Throwable -> L33
    L24:
        if (downloadInMultiProcess == false) goto L29;
        if (r1 == true) goto L29;
        if (DownloadHelper.isDownloaderProcess() == true) goto L29;
        boolean r4 = true;
    L30:
        registerAsync(r4);     // Catch: Throwable -> L33
        ensureOPPO();     // Catch: Throwable -> L33
        hasInit = true;     // Catch: Throwable -> L33
        monitor-exit(DownloadComponentManager.class);
        return;
    L29:
        r4 = false;
        goto L30
    }

    public static boolean isCommonOkhttpClient(OkHttpClient r2) {
        if (r2 != null) goto L5;
        return false;
    L5:
        OkHttpClient r1 = sOkHttpClient;
        if (r1 != null) goto L8;
        return false;
    L8:
        if (r2 != r1) goto L11;
        return true;
    L11:
        return false;
    }

    private static void needAutoRefreshUnSuccessTask(boolean r0) {
        needAutoRefreshUnSuccessTask = r0;
    }

    public static void onDownloadCacheSyncCallback(DownloadCacheSyncStatus r4) {
        List<IDownloadCacheSyncStatusListener> r0 = downloadCacheSyncStatusListeners;
        monitor-enter(r0);
        Iterator<IDownloadCacheSyncStatusListener> r1 = r0.iterator();     // Catch: Throwable -> L20
    L6:
        if (r1.hasNext() == false) goto L16;
        IDownloadCacheSyncStatusListener r2 = r1.next();     // Catch: Throwable -> L20
        if (r2 == null) goto L6;
        if (r4 == DownloadCacheSyncStatus.SYNC_START) goto L11;
        if (r4 != DownloadCacheSyncStatus.SYNC_SUCCESS) goto L6;
        r2.onSuccess();     // Catch: Throwable -> L20
        goto L6
    L11:
        r2.onStart();     // Catch: Throwable -> L20
        goto L6
    L16:
        if (r4 != DownloadCacheSyncStatus.SYNC_SUCCESS) goto L18;
        downloadCacheSyncStatusListeners.clear();     // Catch: Throwable -> L20
    L18:
        monitor-exit(r0);     // Catch: Throwable -> L20
        return;
    L20:
        th = move-exception;
        throw th;
    }

    private static TargetInfo parseTargetInfo(String r4) {
        InetAddress r0 = null;
        String r5 = URI.create(r4).getHost();     // Catch: Throwable -> L21
        if (r5 == null) goto L25;
    L19:
        th = th;
    L23:
        Logger.e(TAG, "forceWifi parse url error", th);
        goto L25
    L6:
        if (r5.isEmpty() == true) goto L25;
        if (r5.startsWith("[") == true) goto L10;
    L14:
        String r1 = r5;
    L16:
        if (Patterns.IP_ADDRESS.matcher(r1).matches() == false) goto L25;
        r0 = InetAddress.getByName(r1);     // Catch: Throwable -> L19
        r5 = r1;
        goto L25
    L10:
        if (r5.endsWith("]") == false) goto L14;
        if (r5.length() <= 2) goto L14;
        r1 = r5.substring(1, r5.length() - 1);     // Catch: Throwable -> L19
    L25:
        return new TargetInfo(r0, r5);
    L21:
        th = th;
        r5 = null;
        goto L23
    }

    private static void registerAsync(boolean r1) {
        submitIOTask(new 1(r1));
    }

    public static void registerDownloadCacheSyncListener(IDownloadCacheSyncStatusListener r2) {
        List<IDownloadCacheSyncStatusListener> r0 = downloadCacheSyncStatusListeners;
        monitor-enter(r0);
        if (r2 != null) goto L16;
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L13
        return;
    L16:
    L13:
        th = move-exception;
        throw th;
    L6:
        if (r0.contains(r2) == true) goto L11;
        r0.add(r2);     // Catch: Throwable -> L13
        monitor-exit(r0);     // Catch: Throwable -> L13
    }

    public static void registerDownloadTaskExecuteListener(IDownloadTaskExecuteListener r2) {
        List<IDownloadTaskExecuteListener> r0 = downloadTaskExecuteListeners;
        monitor-enter(r0);
        if (r2 != null) goto L16;
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L13
        return;
    L16:
    L13:
        th = move-exception;
        throw th;
    L6:
        if (r0.contains(r2) == true) goto L11;
        r0.add(r2);     // Catch: Throwable -> L13
        monitor-exit(r0);     // Catch: Throwable -> L13
    }

    private static void registerIndependentService(boolean r0) {
        if (r0 == true) goto L4;
        return;
    L4:
        if (DownloadUtils.optimizeMultiProcess() == true) goto L8;
        DownloadProxy.get(true).startService();
        return;
    }

    public static void releaseOkHttpClient(OkHttpClient r2) {
        if (r2 != null) goto L11;
        return;
    L11:
        r2.dispatcher().cancelAll();     // Catch: Throwable -> L8
        r2.connectionPool().evictAll();     // Catch: Throwable -> L8
        if (okHttpDispatcherExecutor != null) goto L13;
        r2.dispatcher().executorService().shutdown();     // Catch: Throwable -> L8
        return;
    L13:
        return;
    L8:
        th = move-exception;
        Logger.e(TAG, "releaseOkHttpClient error", th);
    }

    public static void removeDownloadCompleteHandler(IDownloadCompleteHandler r2) {
        List<IDownloadCompleteHandler> r0 = downloadCompleteHandlers;
        monitor-enter(r0);
        if (r2 != null) goto L16;
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L13
        return;
    L16:
    L13:
        th = move-exception;
        throw th;
    L6:
        if (r0.contains(r2) == false) goto L11;
        r0.remove(r2);     // Catch: Throwable -> L13
        monitor-exit(r0);     // Catch: Throwable -> L13
    }

    public static synchronized void setAppContext(Context r5) {
        monitor-enter(DownloadComponentManager.class);
        if (r5 != null) goto L16;
    L14:
        monitor-exit(DownloadComponentManager.class);
        return;
    L16:
    L11:
        th = move-exception;
        throw th;
    L6:
        if (appContext != null) goto L14;
        appContext = r5.getApplicationContext();     // Catch: Throwable -> L11
        AppStatusManager.getInstance().init(appContext);     // Catch: Throwable -> L11
        if (Logger.debug() == false) goto L14;
        Logger.globalDebug(TAG, "setAppContext", "Context:" + r5);     // Catch: Throwable -> L11
        goto L14
    }

    private static void setCPUThreadExecutor(ExecutorService r0) {
        if (r0 == null) goto L5;
        cpuThreadExecutor = r0;
        return;
    }

    public static void setChunkDownloadExecutor(ExecutorService r0) {
        if (r0 == null) goto L5;
        chunkDownloadExecutor = r0;
        return;
    }

    public static void setCustomThreadExecutor(ExecutorService r0) {
        if (r0 == null) goto L5;
        customThreadExecutor = r0;
        return;
    }

    private static void setDBThreadExecutor(ExecutorService r0) {
        if (r0 == null) goto L5;
        dbThreadExecutor = r0;
        return;
    }

    private static void setDownloadBuilder(DownloaderBuilder r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        if (r2.getContext() == null) goto L7;
        setAppContext(r2.getContext());
    L7:
        if (r2.getIdGenerator() == null) goto L10;
        setIdGenerator(r2.getIdGenerator());
    L10:
        if (r2.getNotificationClickCallback() == null) goto L13;
        setNotificationClickCallback(r2.getNotificationClickCallback());
    L13:
        if (r2.getHttpService() == null) goto L16;
        setHttpService(r2.getHttpService());
    L16:
        if (r2.getDownloadLaunchHandler() == null) goto L19;
        setDownloadLaunchHandler(r2.getDownloadLaunchHandler());
    L19:
        if (r2.getCPUThreadExecutor() == null) goto L22;
        setCPUThreadExecutor(r2.getCPUThreadExecutor());
    L22:
        if (r2.getIOThreadExecutor() == null) goto L25;
        setIOThreadExecutor(r2.getIOThreadExecutor());
    L25:
        if (r2.getMixDefaultDownloadExecutor() == null) goto L28;
        setMixDefaultDownloadExecutor(r2.getMixDefaultDownloadExecutor());
    L28:
        if (r2.getMixFrequentDownloadExecutor() == null) goto L31;
        setMixFrequentDownloadExecutor(r2.getMixFrequentDownloadExecutor());
    L31:
        if (r2.getMixApkDownloadExecutor() == null) goto L34;
        setMixApkDownloadExecutor(r2.getMixApkDownloadExecutor());
    L34:
        if (r2.getDBThreadExecutor() == null) goto L37;
        setDBThreadExecutor(r2.getDBThreadExecutor());
    L37:
        if (r2.getChunkThreadExecutor() == null) goto L40;
        setChunkDownloadExecutor(r2.getChunkThreadExecutor());
    L40:
        if (r2.getOkHttpDispatcherExecutor() == null) goto L43;
        setOkHttpDispatcherExecutor(r2.getOkHttpDispatcherExecutor());
    L43:
        if (r2.getCustomThreadExecutor() == null) goto L46;
        setCustomThreadExecutor(r2.getCustomThreadExecutor());
    L46:
        if (r2.getDownloadCompleteHandlers().isEmpty() == true) goto L49;
        setDownloadCompleteHandlers(r2.getDownloadCompleteHandlers());
    L49:
        if (r2.getMonitorConfig() == null) goto L52;
        monitorConfig = r2.getMonitorConfig();
    L52:
        if (r2.getWriteBufferSize() <= 1024) goto L55;
        writeBufferSize = r2.getWriteBufferSize();
    L55:
        if (r2.isDownloadInMultiProcess() == false) goto L58;
        downloadInMultiProcess = true;
    L58:
        if (r2.getTTNetHandler() == null) goto L64;
        iTTNetHandler = r2.getTTNetHandler();
        if (iTTNetHandler.isTTNetEnable() == false) goto L62;
        setHttpService(iTTNetHandler.getTTNetDownloadHttpService());
        goto L64
    L62:
        setHttpService(getDefaultHttpService());
    L64:
        if (r2.getDownloadSetting() == null) goto L67;
        setDownloadSetting(r2.getDownloadSetting());
    L67:
        if (r2.getDownloadDns() == null) goto L70;
        downloadDns = r2.getDownloadDns();
    L70:
        if (r2.getDownloadInterceptor() == null) goto L72;
        setDownloadInterceptor(r2.getDownloadInterceptor());
    L72:
        needAutoRefreshUnSuccessTask(r2.needAutoRefreshUnSuccessTask());
        if (r2.getDownloadMonitorListener() == null) goto L77;
        setDownloadMonitorListener(r2.getDownloadMonitorListener());
        return;
    }

    private static void setDownloadCompleteHandlers(List<IDownloadCompleteHandler> r2) {
        List<IDownloadCompleteHandler> r0 = downloadCompleteHandlers;
        if (r0.isEmpty() == false) goto L11;
        monitor-enter(r0);
        r0.addAll(r2);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public static void setDownloadDBListener(IDownloadDBListener r0) {
        downloadDBListener = r0;
    }

    public static void setDownloadEventListener(InnerEventListener r0) {
        downloadEventListener = GlobalListenerAdaptor.addListener(r0);
    }

    public static void setDownloadInterceptor(IDownloadInterceptor r0) {
        if (r0 == null) goto L5;
        downloadInterceptor = GlobalListenerAdaptor.addListener(r0);
        return;
    }

    public static synchronized void setDownloadLaunchHandler(IDownloadLaunchHandler r1) {
        monitor-enter(DownloadComponentManager.class);
        if (r1 != null) goto L14;
    L12:
        monitor-exit(DownloadComponentManager.class);
        return;
    L14:
        downloadLaunchHandler = r1;     // Catch: Throwable -> L9
        if ((downloadCache instanceof DefaultDownloadCache) == false) goto L12;
        ((DefaultDownloadCache) downloadCache).resumeUnCompleteTaskMayDelayed();     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    public static void setDownloadMemoryInfoListener(IDownloadMemoryInfoListener r0) {
        downloadMemoryInfoListener = r0;
    }

    public static void setDownloadMonitorListener(IDownloadMonitorListener r0) {
        if (r0 == null) goto L5;
        downloadMonitorListener = r0;
        return;
    }

    public static void setDownloadNetworkHandler(IDownloadNetworkHandler r0) {
        downloadNetworkHandler = r0;
    }

    public static void setDownloadSetting(IDownloadSettings r1) {
        downloadSettings = r1;
        DownloadSetting.init();
        Logger.alogE(TAG, "Run setDownloadSetting");
    }

    public static void setDownloadStatusListener(IDownloadStatusListener r0) {
        downloadStatusListener = r0;
    }

    public static void setDownloadThreadCheckListener(IDownloadThreadCheckListener r0) {
        if (r0 == null) goto L5;
        threadCheckListener = r0;
        return;
    }

    public static void setHttpService(IDownloadHttpService r0) {
        if (r0 == null) goto L5;
        httpService = r0;
    L5:
        if (httpService == null) goto L7;
        boolean r1 = true;
    L8:
        httpServiceInit = r1;
        return;
    L7:
        r1 = false;
        goto L8
    }

    private static void setIOThreadExecutor(ExecutorService r0) {
        if (r0 == null) goto L5;
        ioThreadExecutor = r0;
        return;
    }

    private static void setIdGenerator(IDownloadIdGenerator r1) {
        if (r1 == null) goto L5;
        ((IDownloadIdGeneratorService) DownloadServiceManager.getService(IDownloadIdGeneratorService.class)).setDownloadIdGenerator(r1);
        return;
    }

    public static void setIndependentServiceCreator(IndependentHolderCreator r3) {
        if (DownloadUtils.optimizeMultiProcess() == false) goto L9;
        if (DownloadUtils.isMultiProcessNormalDBMode() == false) goto L13;
        mNormalDBIndependentHolderCreator = r3;
        return;
    L13:
        return;
    L9:
        if (Logger.debug() == false) goto L11;
        Logger.globalDebug(TAG, "setIndependentServiceCreator", "Creator: " + r3);
    L11:
        independentHolderCreator = r3;
    }

    private static void setMixApkDownloadExecutor(ExecutorService r0) {
        if (r0 == null) goto L5;
        mixApkDownloadExecutor = r0;
        return;
    }

    private static void setMixDefaultDownloadExecutor(ExecutorService r0) {
        if (r0 == null) goto L5;
        mixDefaultDownloadExecutor = r0;
        return;
    }

    private static void setMixFrequentDownloadExecutor(ExecutorService r0) {
        if (r0 == null) goto L5;
        mixFrequentDownloadExecutor = r0;
        return;
    }

    public static void setNotificationClickCallback(INotificationClickCallback r0) {
        if (r0 == null) goto L5;
        notificationClickCallback = GlobalListenerAdaptor.addListener(r0);
        return;
    }

    public static void setOkHttpDispatcherExecutor(ExecutorService r0) {
        if (r0 == null) goto L5;
        okHttpDispatcherExecutor = r0;
        return;
    }

    public static void setReserveWifiStatusListener(IReserveWifiStatusListener r0) {
        reserveWifiStatusListener = GlobalListenerAdaptor.addListener(r0);
    }

    public static void submitCPUTask(Runnable r1) {
        submitCPUTask(r1, false);
    }

    public static void submitDBTask(Runnable r1) {
        if (r1 != null) goto L5;
        return;
    L5:
        if (DownloadUtils.isMainThread() == true) goto L7;
        r1.run();
        return;
    L7:
        getDBThreadExecutorService().execute(r1);
    }

    public static void submitIOTask(Runnable r1) {
        submitIOTask(r1, false);
    }

    public static void submitSingleTask(Runnable r1) {
        if (r1 != null) goto L4;
        return;
    L4:
        getSingleThreadExecutorService().execute(r1);
    }

    public static void unRegisterDownloadCacheSyncListener(IDownloadCacheSyncStatusListener r2) {
        List<IDownloadCacheSyncStatusListener> r0 = downloadCacheSyncStatusListeners;
        monitor-enter(r0);
        if (r2 != null) goto L16;
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L13
        return;
    L16:
    L13:
        th = move-exception;
        throw th;
    L6:
        if (r0.contains(r2) == false) goto L11;
        r0.remove(r2);     // Catch: Throwable -> L13
        monitor-exit(r0);     // Catch: Throwable -> L13
    }

    public static void unRegisterDownloadTaskExecuteListener(IDownloadTaskExecuteListener r2) {
        List<IDownloadTaskExecuteListener> r0 = downloadTaskExecuteListeners;
        monitor-enter(r0);
        if (r2 != null) goto L16;
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L13
        return;
    L16:
    L13:
        th = move-exception;
        throw th;
    L6:
        if (r0.contains(r2) == false) goto L11;
        r0.remove(r2);     // Catch: Throwable -> L13
        monitor-exit(r0);     // Catch: Throwable -> L13
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static void INVOKEVIRTUAL_com_ss_android_socialbase_downloader_downloader_DownloadComponentManager_com_bytedance_sysoptimizer_ReceiverRegisterLancet_unregisterReceiver(Context r1, BroadcastReceiver r2) {
        ReceiverRegisterLancet.loge(r2, false);
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == true) goto L14;
        r1.unregisterReceiver(r2);
        return;
    L14:
    L8:
        e = move-exception;
        if (r2 == null) goto L11;
        Npth.addTag("unregisterReceiver", r2.toString());
    L11:
        e.printStackTrace();
        return;
    L5:
        if (ReceiverRegisterAnrOptimizer.unregisterReceiverHasNonScreenFilter(r2, r1) == false) goto L16;
        r1.unregisterReceiver(r2);     // Catch: Exception -> L8
        return;
    }

    public static long clearAllDownloadCache(boolean r13, Set<String> r14) {
        long r3 = 0;
        IDownloadCache r5 = getDownloadCache();     // Catch: Throwable -> L34
        boolean r6 = r5.ensureDownloadCacheSyncSuccess();     // Catch: Throwable -> L34
        if (Logger.debug() == false) goto L6;
        Logger.globalDebug(TAG, "clearAllDownloadCache", "DownloadCache sync:" + r6);     // Catch: Throwable -> L34
    L6:
        List<DownloadInfo> r2 = r5.getAllDownloadInfo();     // Catch: Throwable -> L34
        if (r2 == null) goto L9;
        AbsDownloadEngine r7 = getDownloadEngine();     // Catch: Throwable -> L34
        Iterator<DownloadInfo> r4 = r2.iterator();     // Catch: Throwable -> L34
        long r8 = 0;
    L44:
        if (r4.hasNext() == false) goto L40;
        DownloadInfo r9 = r4.next();     // Catch: Throwable -> L32
        if (r7.isDownloading(r9.getId()) == true) goto L44;
        if (DownloadDirUtils.isSavePathSecurity(r9.getSavePath()) == false) goto L44;
        if (r14 == null) goto L27;
        if (TextUtils.isEmpty(r9.getMonitorScene()) == true) goto L27;
        if (r14.contains(r9.getMonitorScene()) == true) goto L44;
    L27:
        if (r9.getCurBytes() <= 0) goto L29;
        r8 = r8 + r9.getCurBytes();     // Catch: Throwable -> L32
    L29:
        if (r13 == false) goto L44;
        r5.removeDownloadTaskData(r9.getId());     // Catch: Throwable -> L32
        DownloadUtils.clearDownloadFile(r9.getSavePath(), r9.getTempPath(), r9.getName());     // Catch: Throwable -> L32
    L40:
        if (Logger.debug() == false) goto L42;
        Logger.globalDebug(TAG, "clearAllDownloadCache", "ClearSize:" + r8 + " clear:" + r13);
    L42:
        return r8;
    L32:
        th = th;
        r3 = r8;
    L35:
        th.printStackTrace();
        if (Logger.debug() == false) goto L38;
        Logger.globalDebug(TAG, "clearAllDownloadCache", "Error:" + th);
    L38:
        r8 = r3;
        goto L40
    L9:
        if (Logger.debug() == false) goto L11;
        Logger.globalDebug(TAG, "clearAllDownloadCache", "DownloadInfos is null");     // Catch: Throwable -> L34
    L11:
        return 0;
    L34:
        th = th;
        goto L35
    }

    public static IDownloadHeadHttpConnection downloadWithHeadConnection(String r3, List<HttpHeader> r4) throws Exception {
        return ((IDownloadNetworkService) DownloadServiceManager.getService(IDownloadNetworkService.class)).downloadWithConnection(true, 0, r3, r4);
    }

    public static OkHttpClient getDownloadClient(boolean r0, String r1) {
        if (r0 == false) goto L7;
        OkHttpClient r2 = getWifiBoundClient(r1);
        if (r2 == null) goto L7;
        return r2;
    L7:
        if (sOkHttpClient != null) goto L19;
        monitor-enter(DownloadComponentManager.class);
    L15:
        th = move-exception;
        throw th;
    L11:
        if (sOkHttpClient != null) goto L13;
        sOkHttpClient = createDownloadClientBuilder().build();     // Catch: Throwable -> L15
    L13:
        monitor-exit(DownloadComponentManager.class);     // Catch: Throwable -> L15
    L19:
        return sOkHttpClient;
    }

    public static int getDownloadId(String r1, String r2) {
        return ((IDownloadIdGeneratorService) DownloadServiceManager.getService(IDownloadIdGeneratorService.class)).generate(r1, r2);
    }

    private static String handleConnection(String r1, List<HttpHeader> r2) {
        if (downloadNetworkHandler != null) goto L5;
        return r1;
    L5:
        String r3 = downloadNetworkHandler.handle(r1, r2);
        if (TextUtils.isEmpty(r3) == true) goto L8;
        return r3;
    L8:
        return r1;
    }

    private static boolean isWifiCandidate(NetworkCapabilities r1, LinkProperties r2) {
        if (r1 != null) goto L4;
    L11:
        return false;
    L4:
        if (r1.hasTransport(1) == false) goto L11;
        if (r2 == null) goto L11;
        if (r2.getLinkAddresses() == null) goto L11;
        if (r2.getLinkAddresses().isEmpty() == true) goto L11;
        return true;
    }

    public static void onDownloadTaskFinish(DownloadTask r3, int r4) {
        List<IDownloadTaskExecuteListener> r0 = downloadTaskExecuteListeners;
        monitor-enter(r0);
        Iterator<IDownloadTaskExecuteListener> r1 = r0.iterator();     // Catch: Throwable -> L12
    L6:
        if (r1.hasNext() == false) goto L10;
        IDownloadTaskExecuteListener r2 = r1.next();     // Catch: Throwable -> L12
        if (r2 == null) goto L6;
        r2.onFinish(r3, r4);     // Catch: Throwable -> L12
        goto L6
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public static void onDownloadTaskStart(DownloadTask r3, int r4) {
        List<IDownloadTaskExecuteListener> r0 = downloadTaskExecuteListeners;
        monitor-enter(r0);
        Iterator<IDownloadTaskExecuteListener> r1 = r0.iterator();     // Catch: Throwable -> L12
    L6:
        if (r1.hasNext() == false) goto L10;
        IDownloadTaskExecuteListener r2 = r1.next();     // Catch: Throwable -> L12
        if (r2 == null) goto L6;
        r2.onStart(r3, r4);     // Catch: Throwable -> L12
        goto L6
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public static void submitCPUTask(Runnable r0, boolean r1) {
        if (r0 != null) goto L4;
        return;
    L4:
        if (r1 == true) goto L6;
    L8:
        getCPUThreadExecutor().execute(r0);
        return;
    L6:
        if (DownloadUtils.isMainThread() == true) goto L8;
        r0.run();
    }

    public static void submitIOTask(Runnable r0, boolean r1) {
        if (r0 != null) goto L4;
        return;
    L4:
        if (r1 == true) goto L6;
    L8:
        getIOThreadExecutor().execute(r0);
        return;
    L6:
        if (DownloadUtils.isMainThread() == true) goto L8;
        r0.run();
    }

    public static void updateCurrentDownloadThreadInfo(DownloadTask r1, boolean r2) {
        if (r1 != null) goto L4;
        return;
    L4:
        if (r1.getDownloadInfo().isFastDownload() == true) goto L15;
        if (r2 == false) goto L8;
        Map r3 = r1.getThreadInfo().beforeDownloadThreadExecutors;
    L10:
        if (r3.isEmpty() == true) goto L12;
        return;
    L12:
        r3.put("cpu", DownloadThreadInfo.parse(cpuThreadExecutor));
        r3.put("io", DownloadThreadInfo.parse(ioThreadExecutor));
        r3.put("mixDefault", DownloadThreadInfo.parse(mixDefaultDownloadExecutor));
        r3.put("mixApk", DownloadThreadInfo.parse(mixApkDownloadExecutor));
        r3.put("db", DownloadThreadInfo.parse(dbThreadExecutor));
        r3.put("chunk", DownloadThreadInfo.parse(chunkDownloadExecutor));
        r3.put("segment", DownloadThreadInfo.parse(segmentThreadExecutor));
        r3.put("okHttp", DownloadThreadInfo.parse(okHttpDispatcherExecutor));
        r3.put("schedule", DownloadThreadInfo.parse(scheduledExecutor));
        r3.put("single", DownloadThreadInfo.parse(singleThreadExecutor));
        r3.put("custom", DownloadThreadInfo.parse(customThreadExecutor));
        return;
    L8:
        r3 = r1.getThreadInfo().afterDownloadThreadExecutors;
        goto L10
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static Intent INVOKEVIRTUAL_com_ss_android_socialbase_downloader_downloader_DownloadComponentManager_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(Context r8, BroadcastReceiver r9, IntentFilter r10) {
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L42;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L42:
    L36:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == true) goto L40;
        throw e;
    L40:
        return ReceiverRegisterCrashOptimizer.registerReceiver(r9, r10);
    L6:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L25;
        if (r10 == null) goto L25;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r10) == false) goto L25;
        ReceiverRegisterAnrOptimizer.ResultWrapper r0 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r9, r10, 0, null, null, 2, r8);     // Catch: Exception -> L36
        int r1 = r0.result;     // Catch: Exception -> L36
        if (r1 == 1) goto L23;
        if (r1 == 2) goto L21;
        if (r1 == 3) goto L19;
        return r8.registerReceiver(r9, r10);
    L19:
        return r0.intent;
    L21:
        return new Intent();
    L23:
        return r8.registerReceiver(r9, r10);
    L25:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L29;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L36
        return r8.registerReceiver(r9, r10, null, ReceiverRegisterLancet.sReceiverHandler);
    L29:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() == null) goto L35;
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r10) == false) goto L35;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L36
        return ContextCompat.registerReceiver(r8, r9, r10, null, ReceiverRegisterLancet.sProxyHandler, 2);
    L35:
        return r8.registerReceiver(r9, r10);
    }

    private static OkHttpClient selectWifiByRoute(InetAddress r4, Network r5, LinkProperties r6) {
        if (r4 == null) goto L21;
        if (r6 == null) goto L21;
        Iterator<RouteInfo> r7 = r6.getRoutes().iterator();
    L8:
        if (r7.hasNext() == false) goto L21;
        RouteInfo r1 = r7.next();
        if (r1 == null) goto L8;
    L19:
        th = move-exception;
        Logger.e(TAG, "forceWifi select wifi network error", th);
        goto L8
    L12:
        if (r1.matches(r4) == false) goto L8;
        if (r1.getDestination() == null) goto L8;
        if (r1.getDestination().getPrefixLength() <= 0) goto L8;
        return buildBoundClient(r5);
    L21:
        return null;
    }

    public static Future submitScheduleTask(Runnable r1, long r2, TimeUnit r4) {
        if (r1 != null) goto L6;
        return null;
    L6:
        return getScheduledExecutorService().schedule(r1, r2, r4);
    }

    public static IDownloadHttpConnection downloadWithConnection(boolean r1, int r2, String r3, List<HttpHeader> r4) throws Exception {
        return ((IDownloadNetworkService) DownloadServiceManager.getService(IDownloadNetworkService.class)).downloadWithConnection(r1, r2, handleConnection(r3, r4), r4);
    }

    public static IDownloadHttpConnection downloadWithConnection(boolean r10, int r11, String r12, String r13, List<HttpHeader> r14, int r15, boolean r16, DownloadInfo r17) throws Exception {
        return ((IDownloadNetworkService) DownloadServiceManager.getService(IDownloadNetworkService.class)).downloadWithConnection(r10, r11, handleConnection(r12, r14), r13, r14, r15, r16, r17);
    }
}
