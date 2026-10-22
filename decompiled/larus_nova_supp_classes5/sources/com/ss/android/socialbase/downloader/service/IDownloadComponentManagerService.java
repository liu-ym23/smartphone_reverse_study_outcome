package com.ss.android.socialbase.downloader.service;

import android.content.Context;
import com.ss.android.socialbase.downloader.depend.IDirectoryCleanerListener;
import com.ss.android.socialbase.downloader.depend.IDownloadDBListener;
import com.ss.android.socialbase.downloader.depend.IDownloadInterceptor;
import com.ss.android.socialbase.downloader.depend.IDownloadMonitorTeaListener;
import com.ss.android.socialbase.downloader.depend.IDownloadNetworkHandler;
import com.ss.android.socialbase.downloader.depend.IDownloadPluginDegradeListener;
import com.ss.android.socialbase.downloader.depend.IDownloadStatusListener;
import com.ss.android.socialbase.downloader.depend.IDownloadThreadCheckListener;
import com.ss.android.socialbase.downloader.depend.IMainThreadMonitor;
import com.ss.android.socialbase.downloader.depend.IMemoryListener;
import com.ss.android.socialbase.downloader.depend.INotificationClickCallback;
import com.ss.android.socialbase.downloader.downloader.DownloaderBuilder;
import com.ss.android.socialbase.downloader.downloader.IDownloadMemoryInfoListener;
import com.ss.android.socialbase.downloader.downloader.IReserveWifiStatusListener;
import com.ss.android.socialbase.downloader.downloader.ITTNetHandler;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.monitor.IDownloadMonitorListener;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public interface IDownloadComponentManagerService {
    long clearAllDownloadCache(boolean r1, Set<String> r2);

    void clearDBSuccessedDownloadInfo(String r1, String r2);

    void clearDirectory(IDirectoryCleanerListener r1);

    void clearMemoryCacheData(double r1);

    void coverComponent(DownloaderBuilder r1);

    void enableLruCache();

    Context getAppContext();

    IDownloadInterceptor getDownloadInterceptor();

    JSONObject getDownloadSetting();

    IReserveWifiStatusListener getReserveWifiStatusListener();

    ITTNetHandler getTTNetHandler();

    void initComponent(DownloaderBuilder r1);

    void initDownloadCacheImmediately();

    boolean isInit();

    void pauseAllEnqueueTask(List<String> r1);

    void resetSleepDownloadingTaskState();

    void resumeAllEnqueueTask();

    void setAppContext(Context r1);

    void setAppInfo(String r1, String r2);

    void setDownloadDBListener(IDownloadDBListener r1);

    void setDownloadInMultiProcess();

    void setDownloadMemoryInfoListener(IDownloadMemoryInfoListener r1);

    void setDownloadMemoryListener(IMemoryListener r1);

    void setDownloadMonitorListener(IDownloadMonitorListener r1);

    void setDownloadMonitorTeaListener(IDownloadMonitorTeaListener r1);

    void setDownloadNetworkHandler(IDownloadNetworkHandler r1);

    void setDownloadPluginDegradeListener(IDownloadPluginDegradeListener r1);

    void setDownloadStatusListener(IDownloadStatusListener r1);

    void setDownloadThreadCheckListener(IDownloadThreadCheckListener r1);

    void setMainThreadMonitor(IMainThreadMonitor r1);

    void setNotificationClickCallback(INotificationClickCallback r1);

    void setReserveWifiStatusListener(IReserveWifiStatusListener r1);

    void sleepDownloadingTask();

    void startThrottle(String[] r1, long r2);

    void stopThrottle(String[] r1);

    void submitIOTask(Runnable r1);

    void submitScheduleTask(Runnable r1, long r2, TimeUnit r4);

    void submitSingleTask(Runnable r1);

    void unRegisterDownloadReceiver();

    void updateDownloadInfo(DownloadInfo r1);

    void updateDownloadSpInfo();
}
