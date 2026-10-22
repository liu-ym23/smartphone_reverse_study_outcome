package com.ss.android.socialbase.downloader.service;

import com.ss.android.socialbase.downloader.logger.Logger;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes3.dex */
public abstract class DownloadServiceManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap f16100a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f16101b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile boolean f16102c;

    static {
        f16100a = new ConcurrentHashMap();
        f16101b = null;
        f16102c = false;
    }

    public static boolean a() {
        DownloadServiceLoader.class.getMethod("load", null).invoke(DownloadServiceLoader.class.newInstance(), null);     // Catch: Throwable -> L7
        if (Logger.b() == false) goto L9;
        Logger.b("DownloadServiceManager", "runLoad", "Run load :com.ss.android.socialbase.downloader.service.DownloadServiceLoader success");     // Catch: Throwable -> L7
        return true;
    L9:
        return true;
    L7:
        th = move-exception;
        f16101b = th.toString();
        Logger.c("DownloadServiceManager", "runLoad", "Run load :com.ss.android.socialbase.downloader.service.DownloadServiceLoaderfail, " + th.toString());
        th.printStackTrace();
        return false;
    }

    public static Object a(Class r5) {
        if (f16102c == true) goto L23;
        monitor-enter(DownloadServiceManager.class);
    L10:
        th = move-exception;
        throw th;
    L7:
        if (f16102c == false) goto L13;
        monitor-exit(DownloadServiceManager.class);     // Catch: Throwable -> L10
    L24:
        goto L23
    L13:
        if (a() == false) goto L17;
        f16102c = true;     // Catch: Throwable -> L10
        monitor-exit(DownloadServiceManager.class);     // Catch: Throwable -> L10
        goto L24
    L17:
        IDownloadMonitorHelperService.DefaultDownloadMonitorHelperService r10 = new IDownloadMonitorHelperService.DefaultDownloadMonitorHelperService();     // Catch: Throwable -> L10
        ConcurrentHashMap r11 = f16100a;     // Catch: Throwable -> L10
        r11.put(IDownloadMonitorHelperService.class, r10);     // Catch: Throwable -> L10
        r11.put(IDownloadIdGeneratorService.class, new IDownloadIdGeneratorService.DefaultDownloadIdGeneratorService());     // Catch: Throwable -> L10
        r11.put(IDownloadComponentManagerService.class, new IDownloadComponentManagerService.DefaultDownloadComponentManagerService());     // Catch: Throwable -> L10
        r11.put(IDownloadProcessDispatcherService.class, new IDownloadProcessDispatcherService.DefaultDownloadProcessDispatcherService());     // Catch: Throwable -> L10
        r11.put(IDownloadNetTrafficManagerService.class, new IDownloadNetTrafficManagerService.DefaultDownloadNetTrafficManagerService());     // Catch: Throwable -> L10
        r11.put(IDownloadNotificationManagerService.class, new IDownloadNotificationManagerService.DefaultDownloadNotificationManagerService());     // Catch: Throwable -> L10
        r11.put(IDownloadNetworkService.class, new IDownloadNetworkService.DefaultDownloadNetworkService());     // Catch: Throwable -> L10
        r11.put(IDownloadRetrySchedulerService.class, new IDownloadRetrySchedulerService.DefaultDownloadRetrySchedulerService());     // Catch: Throwable -> L10
        r11.put(IDownloadMultiProcService.class, new IDownloadMultiProcService.DefaultDownloadMultiProcService());     // Catch: Throwable -> L10
        r11.put(IDownloadGlobalThrottleService.class, new IDownloadGlobalThrottleService.DefaultDownloadGlobalThrottleService());     // Catch: Throwable -> L10
        Logger.c("DownloadServiceManager", "loadDefaultService", "Run");     // Catch: Throwable -> L10
        f16102c = true;     // Catch: Throwable -> L10
        monitor-exit(DownloadServiceManager.class);     // Catch: Throwable -> L10
    L23:
        return f16100a.get(r5);
    }
}
