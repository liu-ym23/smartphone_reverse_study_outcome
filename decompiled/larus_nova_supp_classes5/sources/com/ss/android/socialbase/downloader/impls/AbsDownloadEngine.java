package com.ss.android.socialbase.downloader.impls;

import android.database.sqlite.SQLiteException;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.constants.AsyncHandleStatus;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.android.socialbase.downloader.constants.DownloadStatus;
import com.ss.android.socialbase.downloader.constants.EnqueueType;
import com.ss.android.socialbase.downloader.constants.ListenerType;
import com.ss.android.socialbase.downloader.core.DownloadRunnable;
import com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventListener;
import com.ss.android.socialbase.downloader.depend.INotificationClickCallback;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.DownloadStatusHandler;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.downloader.IDownloadCache;
import com.ss.android.socialbase.downloader.downloader.IReserveWifiStatusListener;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.file.DownloadFile;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.socialbase.downloader.monitor.DownloadMonitorHelper;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.thread.WeakDownloadHandler;
import com.ss.android.socialbase.downloader.utils.DownloadListenerUtils;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import com.ss.android.socialbase.downloader.utils.LruCache;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingDeque;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public abstract class AbsDownloadEngine implements WeakDownloadHandler.IHandler, IDownloadEngine {
    private static final String TAG = "AbsDownloadEngine";
    private final IDownloadCache downloadCache;
    private final SparseArray<DownloadTask> downloadTaskMap;
    private final SparseArray<SparseArray<DownloadTask>> downloadTaskWithListenerMap;
    private final SparseArray<DownloadTask> failedDownloadTaskMap;
    private boolean fixAnrIsolateEngineAndCache;
    private boolean mFixCancelAnr;
    protected List<String> mIgnorePauseNames;
    protected volatile boolean mPauseAllEnqueueTask;
    protected List<DownloadTask> mWaitingTasks;
    protected final WeakDownloadHandler mainHandler;
    private final LinkedBlockingDeque<DownloadTask> orderedTaskQueue;
    private final LruCache<Integer, DownloadTask> pengingTaskCache;
    private final SparseArray<DownloadTask> successDownloadTaskMap;
    private final SparseArray<DownloadTask> waitingAsyncDownloadTaskMap;

    public abstract DownloadRunnable doCancel(int r1);

    @Override // com.ss.android.socialbase.downloader.impls.IDownloadEngine
    public abstract Future doDownload(DownloadTask r1);

    public abstract Future doDownload(DownloadTask r1, boolean r2);

    @Override // com.ss.android.socialbase.downloader.impls.IDownloadEngine
    public abstract void doPause(int r1, boolean r2);

    public abstract void doSetThrottleNetSpeed(int r1, long r2, int r4);

    public abstract List<Integer> getAllAliveDownloadIds();

    @Override // com.ss.android.socialbase.downloader.impls.IDownloadEngine
    public abstract boolean isDownloading(int r1);

    @Override // com.ss.android.socialbase.downloader.impls.IDownloadEngine
    public abstract void removeDownloadRunnable(DownloadRunnable r1);

    public void resumeAllEnqueueTask() {
        if (this.mPauseAllEnqueueTask == false) goto L5;
        this.mPauseAllEnqueueTask = false;
        PluginDownloadEngine.resumeAllDownloadTask();
        monitor-enter(this);
    L41:
        th = move-exception;
        throw th;
    L11:
        if (Logger.debug() == false) goto L13;
        Logger.globalDebug(TAG, "resumeAllEnqueueTask", "Before Run size:" + this.orderedTaskQueue.size());     // Catch: Throwable -> L41
    L13:
        this.mIgnorePauseNames.clear();     // Catch: Throwable -> L41
        if (this.orderedTaskQueue.isEmpty() == false) goto L23;
        if (this.mWaitingTasks.isEmpty() == false) goto L23;
        if (Logger.debug() == false) goto L20;
        Logger.globalDebug(TAG, "resumeAllEnqueueTask", "Empty");     // Catch: Throwable -> L41
    L20:
        monitor-exit(this);     // Catch: Throwable -> L41
        return;
    L23:
        boolean r0 = !this.orderedTaskQueue.isEmpty();
        Iterator<DownloadTask> r1 = this.mWaitingTasks.iterator();     // Catch: Exception -> L29 Throwable -> L41
    L26:
        if (r1.hasNext() == false) goto L32;
        this.orderedTaskQueue.put(r1.next());     // Catch: Exception -> L29 Throwable -> L41
    L32:
        if (Logger.debug() == false) goto L34;
        Logger.globalDebug(TAG, "resumeAllEnqueueTask", "After Run size:" + this.orderedTaskQueue.size());     // Catch: Throwable -> L41
    L34:
        this.mWaitingTasks.clear();     // Catch: Throwable -> L41
        if (r0 == false) goto L37;
    L39:
        monitor-exit(this);     // Catch: Throwable -> L41
        return;
    L37:
        if (this.orderedTaskQueue.isEmpty() == true) goto L39;
        tryDownloadImpl(this.orderedTaskQueue.getFirst());     // Catch: Throwable -> L41
    L29:
        e = move-exception;
        Logger.globalError(TAG, "resumeAllEnqueueTask", "Error:" + e);     // Catch: Throwable -> L41
        goto L32
    L5:
        if (Logger.debug() == false) goto L49;
        Logger.globalDebug(TAG, "resumeAllEnqueueTask", "PauseAllEnqueueTask");
        return;
    }

    public AbsDownloadEngine() {
        this.downloadTaskMap = new SparseArray();
        this.successDownloadTaskMap = new SparseArray();
        this.failedDownloadTaskMap = new SparseArray();
        this.waitingAsyncDownloadTaskMap = new SparseArray();
        this.downloadTaskWithListenerMap = new SparseArray();
        this.pengingTaskCache = new LruCache();
        this.orderedTaskQueue = new LinkedBlockingDeque();
        boolean r0 = false;
        this.mPauseAllEnqueueTask = false;
        this.mWaitingTasks = new CopyOnWriteArrayList();
        this.mIgnorePauseNames = new CopyOnWriteArrayList();
        this.mainHandler = new WeakDownloadHandler(Looper.getMainLooper(), this);
        this.downloadCache = DownloadComponentManager.getDownloadCache();
        if (DownloadSetting.obtainGlobal().optInt("fix_anr_isolate_engine_and_cache") <= 0) goto L5;
        r0 = true;
    L5:
        this.fixAnrIsolateEngineAndCache = r0;
        this.mFixCancelAnr = DownloadSetting.obtainGlobal().optBugFix("fix_callback_deadlock");
    }

    @Override // com.ss.android.socialbase.downloader.impls.IDownloadEngine
    public void shutDown() {
        List<Integer> r0 = getAllAliveDownloadIds();
        if (r0 != null) goto L5;
        return;
    L5:
        Iterator<Integer> r1 = r0.iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        pause(r1.next().intValue());
        goto L7
    }

    public static /* synthetic */ boolean access$000(AbsDownloadEngine r0) {
        return r0.mFixCancelAnr;
    }

    private void enqueue(DownloadTask r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        DownloadInfo r0 = r4.getDownloadInfo();
        if (r0 != null) goto L8;
        return;
    L8:
        if (PluginDownloadEngine.isEnabledDownloadPluginOpt(r0) == false) goto L46;
        PluginDownloadEngine.getInstance().download(r4);
        return;
    L46:
        if (this.mPauseAllEnqueueTask == false) goto L18;
        if (matchIgnorePauseName(r0.getName()) == true) goto L18;
        this.mWaitingTasks.add(r4);     // Catch: InterruptedException -> L45
        return;
    L18:
        if (this.orderedTaskQueue.isEmpty() == false) goto L21;
        tryDownloadImpl(r4);     // Catch: InterruptedException -> L45
        this.orderedTaskQueue.put(r4);     // Catch: InterruptedException -> L45
        return;
    L21:
        if (r0.getEnqueueType() == EnqueueType.ENQUEUE_TAIL) goto L23;
        DownloadTask r1 = this.orderedTaskQueue.getFirst();     // Catch: InterruptedException -> L45
        if (r1.getDownloadId() == r4.getDownloadId()) goto L39;
    L41:
        pause(r1.getDownloadId());     // Catch: InterruptedException -> L45
        tryDownloadImpl(r4);     // Catch: InterruptedException -> L45
        if (r1.getDownloadId() == r4.getDownloadId()) goto L55;
        this.orderedTaskQueue.putFirst(r4);     // Catch: InterruptedException -> L45
        return;
    L55:
        return;
    L39:
        if (isDownloading(r4.getDownloadId()) == false) goto L41;
        return;
    L23:
        if (this.orderedTaskQueue.getFirst().getDownloadId() == r4.getDownloadId()) goto L25;
    L27:
        Iterator<DownloadTask> r2 = this.orderedTaskQueue.iterator();     // Catch: InterruptedException -> L45
    L29:
        if (r2.hasNext() == false) goto L35;
        DownloadTask r3 = r2.next();     // Catch: InterruptedException -> L45
        if (r3 == null) goto L29;
        if (r3.getDownloadId() != r4.getDownloadId()) goto L29;
        r2.remove();     // Catch: InterruptedException -> L45
    L35:
        this.orderedTaskQueue.put(r4);     // Catch: InterruptedException -> L45
        return;
    L25:
        if (isDownloading(r4.getDownloadId()) == false) goto L27;
        return;
    }

    private synchronized DownloadInfo getDownloadInfoImpl(int r3) {
        monitor-enter(this);
        DownloadInfo r0 = this.downloadCache.getDownloadInfo(r3);     // Catch: Throwable -> L10
        if (r0 != null) goto L8;
        DownloadTask r4 = this.downloadTaskMap.get(r3);     // Catch: Throwable -> L10
        if (r4 == null) goto L8;
        r0 = r4.getDownloadInfo();     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);
        return r0;
    L10:
        th = move-exception;
        throw th;
    }

    private synchronized List<DownloadInfo> getDownloadInfoListImpl(String r6) {
        monitor-enter(this);
    L27:
        th = move-exception;
        throw th;
    L4:
        if (TextUtils.isEmpty(r6) == false) goto L8;
        monitor-exit(this);
        return null;
    L8:
        List<DownloadInfo> r0 = this.downloadCache.getDownloadInfoList(r6);     // Catch: Throwable -> L27
        if (r0 != null) goto L11;
    L15:
        ArrayList r1 = new ArrayList();     // Catch: Throwable -> L27
        int r2 = this.downloadTaskMap.size();     // Catch: Throwable -> L27
        int r3 = 0;
    L16:
        if (r3 >= r2) goto L25;
        DownloadTask r4 = this.downloadTaskMap.valueAt(r3);     // Catch: Throwable -> L27
        if (r4 == null) goto L24;
        if (r4.getDownloadInfo() == null) goto L24;
        if (r6.equals(r4.getDownloadInfo().getUrl()) == false) goto L24;
        r1.add(r4.getDownloadInfo());     // Catch: Throwable -> L27
    L24:
        r3 = r3 + 1;
        goto L16
    L25:
        monitor-exit(this);
        return r1;
    L11:
        if (r0.isEmpty() == true) goto L15;
        monitor-exit(this);
        return r0;
    }

    private DownloadTask getDownloadTask(int r2) {
        if (this.fixAnrIsolateEngineAndCache == false) goto L5;
        monitor-enter(this);
        DownloadTask r0 = this.downloadTaskMap.get(r2);     // Catch: Throwable -> L16
        if (r0 != null) goto L14;
        r0 = this.failedDownloadTaskMap.get(r2);     // Catch: Throwable -> L16
        if (r0 != null) goto L14;
        r0 = this.successDownloadTaskMap.get(r2);     // Catch: Throwable -> L16
        if (r0 != null) goto L14;
        r0 = this.waitingAsyncDownloadTaskMap.get(r2);     // Catch: Throwable -> L16
    L14:
        monitor-exit(this);     // Catch: Throwable -> L16
        return r0;
    L16:
        th = move-exception;
        throw th;
    L5:
        return getDownloadTaskImpl(r2);
    }

    private DownloadTask getDownloadTaskImpl(int r2) {
        DownloadTask r0 = this.downloadTaskMap.get(r2);
        if (r0 != null) goto L10;
        DownloadTask r1 = this.failedDownloadTaskMap.get(r2);
        if (r1 != null) goto L11;
        DownloadTask r3 = this.successDownloadTaskMap.get(r2);
        if (r3 == null) goto L9;
        return r3;
    L9:
        return this.waitingAsyncDownloadTaskMap.get(r2);
    L11:
        return r1;
    L10:
        return r0;
    }

    private boolean isPauseReserveOnWifi(DownloadInfo r3) {
        if (r3 != null) goto L6;
        return false;
    L6:
        if (r3.statusInPause() == true) goto L8;
        return false;
    L8:
        return r3.isPauseReserveOnWifi();
    }

    private synchronized boolean pauseImpl(int r5) {
        monitor-enter(this);
    L42:
        th = move-exception;
        throw th;
    L5:
        if (Logger.debug() == false) goto L7;
        Logger.taskDebug(TAG, r5, "pause", "Trace:" + Log.getStackTraceString(new Throwable()));     // Catch: Throwable -> L42
    L7:
        DownloadInfo r0 = this.downloadCache.getDownloadInfo(r5);     // Catch: Throwable -> L42
        if (r0 != null) goto L11;
    L14:
        SparseArray<DownloadTask> r2 = this.downloadTaskMap;     // Catch: Throwable -> L42
        monitor-enter(r2);     // Catch: Throwable -> L42
        doPause(r5, true);     // Catch: Throwable -> L39
        monitor-exit(r2);     // Catch: Throwable -> L39
        if (r0 != null) goto L26;
        DownloadTask r6 = this.downloadTaskMap.get(r5);     // Catch: Throwable -> L42
        if (r6 == null) goto L37;
        new DownloadStatusHandler(r6, this.mainHandler).onPause();     // Catch: Throwable -> L42
        monitor-exit(this);
        return true;
    L37:
        monitor-exit(this);
        return false;
    L26:
        if (r0.getStatus() != 1) goto L33;
        DownloadTask r7 = this.downloadTaskMap.get(r5);     // Catch: Throwable -> L42
        if (r7 == null) goto L37;
        new DownloadStatusHandler(r7, this.mainHandler).onPause();     // Catch: Throwable -> L42
        monitor-exit(this);
        return true;
    L33:
        if (DownloadStatus.isDownloading(r0.getStatus()) == false) goto L37;
        r0.setStatus(-2);     // Catch: Throwable -> L42
        monitor-exit(this);
        return true;
    L39:
        th = move-exception;
        throw th;     // Catch: Throwable -> L42
    L11:
        if (r0.getStatus() != 11) goto L14;
        monitor-exit(this);
        return false;
    }

    private void tryCacheSameTaskWithListenerHashCode(DownloadTask r7) {
        int r0 = r7.getHashCodeForSameTask();
        if (r0 == 0) goto L5;
    L7:
        if (r0 != 0) goto L9;
        return;
    L9:
        SparseArray<DownloadTask> r1 = this.downloadTaskWithListenerMap.get(r7.getDownloadId());
        if (r1 != null) goto L13;
        r1 = new SparseArray();
        this.downloadTaskWithListenerMap.put(r7.getDownloadId(), r1);
    L13:
        if (Logger.debugScene(r7.getDownloadInfo()) == false) goto L15;
        Logger.taskDebug(TAG, r7.getDownloadInfo(), "tryCacheSameTaskWithListenerHashCode", "Listener hashCode:" + r0);
    L15:
        r1.put(r0, r7);
        return;
    L5:
        if (r7.isAutoSetHashCodeForSameTask() == false) goto L7;
        r0 = r7.autoCalAndGetHashCodeForSameTask();
        goto L7
    }

    private void tryDownloadImpl(DownloadTask r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        DownloadInfo r0 = r10.getDownloadInfo();
        if (r0 != null) goto L8;
        return;
    L8:
        if (r0.isEntityInvalid() == false) goto L11;
        Logger.taskError(TAG, r0.getId(), "tryDownload", "entity invalid");
        DownloadMonitorHelper.monitorSendWithTaskMonitor(r10.getMonitorDepend(), r0, new BaseException(1003, "downloadInfo is Invalid, url is " + r0.getUrl() + " name is " + r0.getName() + " savePath is " + r0.getSavePath()), r0.getStatus());
        return;
    L11:
        r10.getTimingInfo().tryDownloadTime = System.currentTimeMillis();
        boolean r1 = true;
        DownloadComponentManager.updateCurrentDownloadThreadInfo(r10, true);
        int r7 = 0;
        if (DownloadSetting.obtain(r0.getId()).optInt("no_net_opt", 0) == 1) goto L14;
    L21:
        int r5 = r0.getId();
        if (Logger.debugScene(r0) == false) goto L25;
        Logger.taskDebug(TAG, r0, "tryDownload", "Url: " + r0.getUrl() + " savePath: " + r0.getSavePath() + " saveName: " + r0.getName());
    L25:
        if (this.failedDownloadTaskMap.get(r5) == null) goto L28;
        this.failedDownloadTaskMap.remove(r5);
    L28:
        if (this.successDownloadTaskMap.get(r5) == null) goto L31;
        this.successDownloadTaskMap.remove(r5);
    L31:
        if (this.waitingAsyncDownloadTaskMap.get(r5) == null) goto L34;
        this.waitingAsyncDownloadTaskMap.remove(r5);
    L34:
        if (isDownloading(r5) == false) goto L43;
        if (r0.canReStartAsyncTask() == true) goto L43;
        if (Logger.debugScene(r0) == false) goto L40;
        Logger.taskDebug(TAG, r0, "tryDownload", "Another task with same id is downloading when tryDownload");
    L40:
        r10.addListenerToDownloadingSameTask();
        DownloadMonitorHelper.monitorSendWithTaskMonitor(r10.getMonitorDepend(), r0, new BaseException(1003, "downloadInfo is isDownloading and addListenerToSameTask is false"), r0.getStatus());
        return;
    L43:
        if (Logger.debugScene(r0) == false) goto L46;
        Logger.taskDebug(TAG, r0, "tryDownload", "No downloading task");
    L46:
        if (r0.canReStartAsyncTask() == false) goto L48;
        r0.setAsyncHandleStatus(AsyncHandleStatus.ASYNC_HANDLE_RESTART);
    L48:
        DownloadTask r2 = this.pengingTaskCache.remove(Integer.valueOf(r5));
        if (r2 == null) goto L52;
        r10.copyListenerFromPendingTask(r2);
    L52:
        if (DownloadConstants.MIME_PLG.equals(r0.getMimeType()) == false) goto L54;
        r10.getDownloadInfo().safePutToDBJsonData("executor_group", 3);
    L54:
        DownloadTask r3 = this.downloadTaskMap.get(r5);
        if (r3 == null) goto L61;
        DownloadInfo r4 = r3.getDownloadInfo();
        if (r4 == null) goto L61;
        int r6 = r4.getStatus();
        r7 = r6;
        if (DownloadStatus.isDownloading(r6) == false) goto L61;
    L63:
        if (Logger.debugScene(r0) == false) goto L65;
        Logger.taskDebug(TAG, r0, "tryDownload", "Can add listener " + r1 + " , oldTaskStatus is :" + r7);
    L65:
        if (r1 == false) goto L67;
        r10.addListenerToDownloadingSameTask();
        return;
    L67:
        tryCacheSameTaskWithListenerHashCode(r10);
        this.downloadTaskMap.put(r5, r10);
        doDownload(r10);
        return;
    L61:
        r1 = false;
        goto L63
    L14:
        if (DownloadUtils.isNetworkConnected(DownloadComponentManager.getAppContext()) == true) goto L21;
        if (r0.isFirstDownload() == true) goto L21;
        if (DownloadSetting.getGlobalSettings().optBoolean("disable_check_no_network") == true) goto L21;
        new DownloadStatusHandler(r10, this.mainHandler).onError(new BaseException(1049, "network_not_available"));
    }

    private void tryDownloadNextTaskInQueue(int r2) {
        if (this.orderedTaskQueue.isEmpty() == false) goto L5;
        return;
    L5:
        DownloadTask r0 = this.orderedTaskQueue.getFirst();
        if (r0 == null) goto L11;
        if (r0.getDownloadId() != r2) goto L11;
        this.orderedTaskQueue.poll();
    L11:
        if (this.orderedTaskQueue.isEmpty() == false) goto L13;
        return;
    L13:
        DownloadTask r3 = this.orderedTaskQueue.getFirst();
        if (r3 == null) goto L17;
        tryDownloadImpl(r3);
        return;
    }

    @Override // com.ss.android.socialbase.downloader.impls.IDownloadEngine
    public synchronized IDownloadFileUriProvider getDownloadFileUriProvider(int r2) {
        monitor-enter(this);
        DownloadTask r0 = this.downloadTaskMap.get(r2);     // Catch: Throwable -> L26
        if (r0 == null) goto L8;
        IDownloadFileUriProvider r3 = r0.getFileUriProvider();     // Catch: Throwable -> L26
        monitor-exit(this);
        return r3;
    L8:
        DownloadTask r1 = this.successDownloadTaskMap.get(r2);     // Catch: Throwable -> L26
        if (r1 == null) goto L13;
        IDownloadFileUriProvider r4 = r1.getFileUriProvider();     // Catch: Throwable -> L26
        monitor-exit(this);
        return r4;
    L13:
        DownloadTask r5 = this.failedDownloadTaskMap.get(r2);     // Catch: Throwable -> L26
        if (r5 == null) goto L18;
        IDownloadFileUriProvider r6 = r5.getFileUriProvider();     // Catch: Throwable -> L26
        monitor-exit(this);
        return r6;
    L18:
        DownloadTask r7 = this.waitingAsyncDownloadTaskMap.get(r2);     // Catch: Throwable -> L26
        if (r7 == null) goto L23;
        IDownloadFileUriProvider r8 = r7.getFileUriProvider();     // Catch: Throwable -> L26
        monitor-exit(this);
        return r8;
    L23:
        monitor-exit(this);
        return null;
    L26:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.android.socialbase.downloader.impls.IDownloadEngine
    public DownloadInfo getDownloadInfo(int r3) {
        if (this.fixAnrIsolateEngineAndCache == false) goto L5;
        DownloadInfo r0 = this.downloadCache.getDownloadInfo(r3);
        if (r0 != null) goto L17;
        monitor-enter(this);
        DownloadTask r4 = this.downloadTaskMap.get(r3);     // Catch: Throwable -> L14
        if (r4 == null) goto L12;
        r0 = r4.getDownloadInfo();     // Catch: Throwable -> L14
    L12:
        monitor-exit(this);     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;
    L17:
        return r0;
    L5:
        return getDownloadInfoImpl(r3);
    }

    @Override // com.ss.android.socialbase.downloader.impls.IDownloadEngine
    public List<DownloadInfo> getDownloadInfoList(String r6) {
        if (this.fixAnrIsolateEngineAndCache == true) goto L7;
        return getDownloadInfoListImpl(r6);
    L7:
        if (TextUtils.isEmpty(r6) == false) goto L10;
        return null;
    L10:
        List<DownloadInfo> r0 = this.downloadCache.getDownloadInfoList(r6);
        if (r0 != null) goto L13;
    L16:
        monitor-enter(this);
        ArrayList r1 = new ArrayList();     // Catch: Throwable -> L29
        int r2 = this.downloadTaskMap.size();     // Catch: Throwable -> L29
        int r3 = 0;
    L18:
        if (r3 >= r2) goto L27;
        DownloadTask r4 = this.downloadTaskMap.valueAt(r3);     // Catch: Throwable -> L29
        if (r4 == null) goto L26;
        if (r4.getDownloadInfo() == null) goto L26;
        if (r6.equals(r4.getDownloadInfo().getUrl()) == false) goto L26;
        r1.add(r4.getDownloadInfo());     // Catch: Throwable -> L29
    L26:
        r3 = r3 + 1;     // Catch: Throwable -> L29
        goto L18
    L27:
        monitor-exit(this);     // Catch: Throwable -> L29
        return r1;
    L29:
        th = move-exception;
        throw th;
    L13:
        if (r0.isEmpty() == true) goto L16;
        return r0;
    }

    @Override // com.ss.android.socialbase.downloader.impls.IDownloadEngine
    public synchronized IDownloadNotificationEventListener getDownloadNotificationEventListener(int r2) {
        monitor-enter(this);
        DownloadTask r0 = this.downloadTaskMap.get(r2);     // Catch: Throwable -> L26
        if (r0 == null) goto L8;
        IDownloadNotificationEventListener r3 = r0.getNotificationEventListener();     // Catch: Throwable -> L26
        monitor-exit(this);
        return r3;
    L8:
        DownloadTask r1 = this.successDownloadTaskMap.get(r2);     // Catch: Throwable -> L26
        if (r1 == null) goto L13;
        IDownloadNotificationEventListener r4 = r1.getNotificationEventListener();     // Catch: Throwable -> L26
        monitor-exit(this);
        return r4;
    L13:
        DownloadTask r5 = this.failedDownloadTaskMap.get(r2);     // Catch: Throwable -> L26
        if (r5 == null) goto L18;
        IDownloadNotificationEventListener r6 = r5.getNotificationEventListener();     // Catch: Throwable -> L26
        monitor-exit(this);
        return r6;
    L18:
        DownloadTask r7 = this.waitingAsyncDownloadTaskMap.get(r2);     // Catch: Throwable -> L26
        if (r7 == null) goto L23;
        IDownloadNotificationEventListener r8 = r7.getNotificationEventListener();     // Catch: Throwable -> L26
        monitor-exit(this);
        return r8;
    L23:
        monitor-exit(this);
        return null;
    L26:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.android.socialbase.downloader.impls.IDownloadEngine
    public List<DownloadInfo> getDownloadingDownloadInfosWithMimeType(String r5) {
        if (TextUtils.isEmpty(r5) == false) goto L6;
        return null;
    L6:
        Iterator<Integer> r0 = getAllAliveDownloadIds().iterator();
        ArrayList r1 = new ArrayList();
    L8:
        if (r0.hasNext() == false) goto L14;
        DownloadInfo r2 = getDownloadInfo(r0.next().intValue());
        if (r2 == null) goto L8;
        if (r5.equals(r2.getMimeType()) == false) goto L8;
        r1.add(r2);
        goto L8
    L14:
        return r1;
    }

    @Override // com.ss.android.socialbase.downloader.impls.IDownloadEngine
    public synchronized INotificationClickCallback getNotificationClickCallback(int r2) {
        monitor-enter(this);
        DownloadTask r0 = this.downloadTaskMap.get(r2);     // Catch: Throwable -> L26
        if (r0 == null) goto L8;
        INotificationClickCallback r3 = r0.getNotificationClickCallback();     // Catch: Throwable -> L26
        monitor-exit(this);
        return r3;
    L8:
        DownloadTask r1 = this.successDownloadTaskMap.get(r2);     // Catch: Throwable -> L26
        if (r1 == null) goto L13;
        INotificationClickCallback r4 = r1.getNotificationClickCallback();     // Catch: Throwable -> L26
        monitor-exit(this);
        return r4;
    L13:
        DownloadTask r5 = this.failedDownloadTaskMap.get(r2);     // Catch: Throwable -> L26
        if (r5 == null) goto L18;
        INotificationClickCallback r6 = r5.getNotificationClickCallback();     // Catch: Throwable -> L26
        monitor-exit(this);
        return r6;
    L18:
        DownloadTask r7 = this.waitingAsyncDownloadTaskMap.get(r2);     // Catch: Throwable -> L26
        if (r7 == null) goto L23;
        INotificationClickCallback r8 = r7.getNotificationClickCallback();     // Catch: Throwable -> L26
        monitor-exit(this);
        return r8;
    L23:
        monitor-exit(this);
        return null;
    L26:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.android.socialbase.downloader.thread.WeakDownloadHandler.IHandler
    public void handleMsg(Message r7) {
        int r0 = r7.arg1;
        int r1 = r7.arg2;
        if (Logger.debug() == false) goto L5;
        Logger.taskDebug(TAG, r0, "handleMsg", "Listener hashCode: " + r1);
    L5:
        Object r2 = r7.obj;
        DownloadTask r4 = null;
        if ((r2 instanceof Exception) == false) goto L8;
        BaseException r3 = (BaseException) r2;
    L9:
        monitor-enter(this);
        if (r1 != 0) goto L12;
        r4 = this.downloadTaskMap.get(r0);     // Catch: Throwable -> L21
    L15:
        if (r4 != null) goto L18;
        monitor-exit(this);     // Catch: Throwable -> L21
        return;
    L18:
        notifyDownloadTaskStatus(r7.what, r3, r4);     // Catch: Throwable -> L21
        refreshDownloadTaskMap(r0, r1, r7.what);     // Catch: Throwable -> L21
        monitor-exit(this);     // Catch: Throwable -> L21
        return;
    L12:
        SparseArray<DownloadTask> r5 = this.downloadTaskWithListenerMap.get(r0);     // Catch: Throwable -> L21
        if (r5 == null) goto L15;
        r4 = r5.get(r1);     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        throw th;
    L8:
        r3 = null;
        goto L9
    }

    @Override // com.ss.android.socialbase.downloader.impls.IDownloadEngine
    public synchronized boolean isInDownloadTaskPool(int r2) {
        monitor-enter(this);
        if (r2 != 0) goto L15;
    L12:
        boolean r3 = false;
    L13:
        monitor-exit(this);
        return r3;
    L15:
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.downloadTaskMap.get(r2) != null) goto L8;
        if (this.failedDownloadTaskMap.get(r2) == null) goto L12;
    L8:
        r3 = true;
        goto L13
    }

    public boolean matchIgnorePauseName(String r4) {
        if (this.mIgnorePauseNames.isEmpty() == false) goto L5;
        return false;
    L5:
        Iterator<String> r0 = this.mIgnorePauseNames.iterator();
    L7:
        if (r0.hasNext() == false) goto L12;
        if (r4.contains(r0.next()) == false) goto L7;
        return true;
    L12:
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.impls.IDownloadEngine
    public boolean pause(int r5) {
        if (this.fixAnrIsolateEngineAndCache == true) goto L7;
        return pauseImpl(r5);
    L7:
        if (Logger.debug() == false) goto L9;
        Logger.taskDebug(TAG, r5, "pause", "Trace:" + Log.getStackTraceString(new Throwable()));
    L9:
        DownloadInfo r0 = this.downloadCache.getDownloadInfo(r5);
        if (r0 != null) goto L12;
    L14:
        doPause(r5, true);
        monitor-enter(this);
        if (r0 != null) goto L23;
        DownloadTask r6 = this.downloadTaskMap.get(r5);     // Catch: Throwable -> L36
        if (r6 == null) goto L34;
        new DownloadStatusHandler(r6, this.mainHandler).onPause();     // Catch: Throwable -> L36
        monitor-exit(this);     // Catch: Throwable -> L36
        return true;
    L34:
        monitor-exit(this);     // Catch: Throwable -> L36
        return false;
    L23:
        if (r0.getStatus() != 1) goto L30;
        DownloadTask r7 = this.downloadTaskMap.get(r5);     // Catch: Throwable -> L36
        if (r7 == null) goto L34;
        new DownloadStatusHandler(r7, this.mainHandler).onPause();     // Catch: Throwable -> L36
        monitor-exit(this);     // Catch: Throwable -> L36
        return true;
    L30:
        if (DownloadStatus.isDownloading(r0.getStatus()) == false) goto L34;
        r0.setStatus(-2);     // Catch: Throwable -> L36
        monitor-exit(this);     // Catch: Throwable -> L36
        return true;
    L36:
        th = move-exception;
        throw th;
    L12:
        if (r0.getStatus() != 11) goto L14;
        return false;
    }

    public void pauseAllEnqueueTask(List<String> r7) {
        if (Logger.debug() == false) goto L6;
        Logger.globalDebug(TAG, "pauseAllEnqueueTask", "Run");
    L6:
        if (this.mPauseAllEnqueueTask == true) goto L8;
        boolean r2 = true;
        this.mPauseAllEnqueueTask = true;
        PluginDownloadEngine.pauseAllDownloadTask(r7);
        monitor-enter(this);
    L47:
        th = move-exception;
        throw th;
    L14:
        if (Logger.debug() == false) goto L16;
        Logger.globalDebug(TAG, "pauseAllEnqueueTask", "RunImpl");     // Catch: Throwable -> L47
    L16:
        if (r7 == null) goto L19;
        this.mIgnorePauseNames.addAll(r7);     // Catch: Throwable -> L47
    L19:
        if (Logger.debug() == false) goto L22;
        Logger.globalDebug(TAG, "pauseAllEnqueueTask", "Before Run size:" + this.orderedTaskQueue.size());     // Catch: Throwable -> L47
    L22:
        if (this.orderedTaskQueue.isEmpty() == false) goto L25;
        monitor-exit(this);     // Catch: Throwable -> L47
        return;
    L25:
        DownloadTask r8 = this.orderedTaskQueue.getFirst();     // Catch: Throwable -> L47
        if (isDownloading(r8.getDownloadId()) == true) goto L28;
    L32:
        r2 = false;
    L33:
        Iterator<DownloadTask> r9 = this.orderedTaskQueue.iterator();     // Catch: Throwable -> L47
    L35:
        if (r9.hasNext() == false) goto L41;
        DownloadTask r0 = r9.next();     // Catch: Throwable -> L47
        if (matchIgnorePauseName(r0.getDownloadInfo().getName()) == true) goto L35;
        r9.remove();     // Catch: Throwable -> L47
        this.mWaitingTasks.add(r0);     // Catch: Throwable -> L47
        goto L35
    L41:
        if (Logger.debug() == false) goto L43;
        Logger.globalDebug(TAG, "pauseAllEnqueueTask", "After Run size: " + this.orderedTaskQueue.size() + " WaitingTasks Size: " + this.mWaitingTasks.size());     // Catch: Throwable -> L47
    L43:
        if (r2 == false) goto L45;
        tryDownloadNextTaskInQueue(0);     // Catch: Throwable -> L47
    L45:
        monitor-exit(this);     // Catch: Throwable -> L47
        return;
    L28:
        if (matchIgnorePauseName(r8.getDownloadInfo().getName()) == true) goto L32;
        pause(r8.getDownloadId());     // Catch: Throwable -> L47
        if (Logger.debug() == false) goto L33;
        Logger.globalDebug(TAG, "pauseAllEnqueueTask", "Pause:" + r8);     // Catch: Throwable -> L47
        goto L33
    L8:
        if (Logger.debug() == false) goto L57;
        Logger.globalDebug(TAG, "pauseAllEnqueueTask", "PauseAllEnqueueTask");
        return;
    }

    @Override // com.ss.android.socialbase.downloader.impls.IDownloadEngine
    public synchronized boolean restart(int r5) {
        monitor-enter(this);
    L18:
        th = move-exception;
        throw th;
    L5:
        if (Logger.debug() == false) goto L7;
        Logger.taskDebug(TAG, r5, "restart", "Trace:" + Log.getStackTraceString(new Throwable()));     // Catch: Throwable -> L18
    L7:
        DownloadTask r6 = this.failedDownloadTaskMap.get(r5);     // Catch: Throwable -> L18
        if (r6 == null) goto L16;
        DownloadInfo r1 = r6.getDownloadInfo();     // Catch: Throwable -> L18
        if (r1 == null) goto L12;
        r1.setDownloadFromReserveWifi(false);     // Catch: Throwable -> L18
    L12:
        tryDownload(r6);     // Catch: Throwable -> L18
        monitor-exit(this);
        return true;
    L16:
        monitor-exit(this);
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.impls.IDownloadEngine
    public synchronized void restartAllFailedDownloadTasks(List<String> r8) {
        monitor-enter(this);
        boolean r0 = DownloadUtils.isWifi(DownloadComponentManager.getAppContext());     // Catch: Throwable -> L27 Exception -> L29
        int r2 = 0;
    L4:
        if (r2 >= this.failedDownloadTaskMap.size()) goto L31;
        int r3 = this.failedDownloadTaskMap.keyAt(r2);     // Catch: Throwable -> L27 Exception -> L29
        DownloadTask r4 = this.failedDownloadTaskMap.get(r3);     // Catch: Throwable -> L27 Exception -> L29
        if (r4 == null) goto L26;
        DownloadInfo r5 = r4.getDownloadInfo();     // Catch: Throwable -> L27 Exception -> L29
        if (r5 == null) goto L26;
        if (r5.isOnlyWifi() == false) goto L16;
        if (r0 == false) goto L26;
    L16:
        if (DownloadSetting.obtain(r5.getId()).optInt("auto_resume", 0) != 1) goto L18;
        boolean r6 = true;
    L19:
        if (r6 == false) goto L21;
    L25:
        r5.setAutoResumed(true);     // Catch: Throwable -> L27 Exception -> L29
        r5.setShowNotificationForNetworkResumed(true);     // Catch: Throwable -> L27 Exception -> L29
        tryDownload(r4);     // Catch: Throwable -> L27 Exception -> L29
        goto L26
    L21:
        if (r5.getMimeType() == null) goto L26;
        if (r8.contains(r5.getMimeType()) == true) goto L25;
    L18:
        r6 = false;
    L26:
        r2 = r2 + 1;
    L31:
        monitor-exit(this);
        return;
    L27:
        th = move-exception;
        throw th;
    L29:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L27
        goto L31
    }

    @Override // com.ss.android.socialbase.downloader.impls.IDownloadEngine
    public synchronized void restartAllPauseReserveOnWifiDownloadTasks(List<String> r6) {
        monitor-enter(this);
    L28:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L26
    L30:
        monitor-exit(this);
        return;
    L26:
        th = move-exception;
        throw th;
    L4:
        if (DownloadUtils.isWifi(DownloadComponentManager.getAppContext()) == true) goto L7;
        monitor-exit(this);
        return;
    L7:
        int r0 = 0;
    L9:
        if (r0 >= this.downloadTaskMap.size()) goto L30;
        int r1 = this.downloadTaskMap.keyAt(r0);     // Catch: Throwable -> L26 Exception -> L28
        DownloadTask r2 = this.downloadTaskMap.get(r1);     // Catch: Throwable -> L26 Exception -> L28
        if (r2 == null) goto L25;
        DownloadInfo r3 = r2.getDownloadInfo();     // Catch: Throwable -> L26 Exception -> L28
        if (r3 == null) goto L25;
        if (r3.getMimeType() == null) goto L25;
        if (r6.contains(r3.getMimeType()) == false) goto L25;
        if (isPauseReserveOnWifi(r3) == false) goto L25;
        r3.setAutoResumed(true);     // Catch: Throwable -> L26 Exception -> L28
        r3.setShowNotificationForNetworkResumed(true);     // Catch: Throwable -> L26 Exception -> L28
        tryDownload(r2);     // Catch: Throwable -> L26 Exception -> L28
        r3.setDownloadFromReserveWifi(true);     // Catch: Throwable -> L26 Exception -> L28
        IReserveWifiStatusListener r4 = Downloader.getInstance(DownloadComponentManager.getAppContext()).getReserveWifiStatusListener();     // Catch: Throwable -> L26 Exception -> L28
        if (r4 == null) goto L25;
        r4.onStatusChanged(r3, 5, 2);     // Catch: Throwable -> L26 Exception -> L28
    L25:
        r0 = r0 + 1;
        goto L9
    }

    @Override // com.ss.android.socialbase.downloader.impls.IDownloadEngine
    public synchronized boolean restartAsyncWaitingTask(int r2) {
        monitor-enter(this);
        DownloadTask r3 = this.waitingAsyncDownloadTaskMap.get(r2);     // Catch: Throwable -> L16
        if (r3 == null) goto L13;
        DownloadInfo r0 = r3.getDownloadInfo();     // Catch: Throwable -> L16
        if (r0 == null) goto L13;
        if (r0.canReStartAsyncTask() == false) goto L10;
        tryDownload(r3);     // Catch: Throwable -> L16
    L10:
        monitor-exit(this);
        return true;
    L13:
        monitor-exit(this);
        return false;
    L16:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.android.socialbase.downloader.impls.IDownloadEngine
    public synchronized boolean resume(int r5) {
        monitor-enter(this);
    L17:
        th = move-exception;
        throw th;
    L5:
        if (Logger.debug() == false) goto L7;
        Logger.taskDebug(TAG, r5, "resume", "Trace:" + Log.getStackTraceString(new Throwable()));     // Catch: Throwable -> L17
    L7:
        DownloadTask r0 = this.downloadTaskMap.get(r5);     // Catch: Throwable -> L17
        if (r0 == null) goto L13;
        DownloadInfo r6 = r0.getDownloadInfo();     // Catch: Throwable -> L17
        if (r6 == null) goto L12;
        r6.setDownloadFromReserveWifi(false);     // Catch: Throwable -> L17
    L12:
        tryDownload(r0);     // Catch: Throwable -> L17
    L14:
        monitor-exit(this);
        return true;
    L13:
        restart(r5);     // Catch: Throwable -> L17
        goto L14
    }

    @Override // com.ss.android.socialbase.downloader.impls.IDownloadEngine
    public synchronized void tryDownload(DownloadTask r3) {
        monitor-enter(this);
        if (r3 != null) goto L20;
        monitor-exit(this);
        return;
    L20:
        DownloadInfo r0 = r3.getDownloadInfo();     // Catch: Throwable -> L17
        if (r0 != null) goto L11;
        monitor-exit(this);
        return;
    L11:
        r0.setDownloadFromReserveWifi(false);     // Catch: Throwable -> L17
        if (r0.getEnqueueType() == EnqueueType.ENQUEUE_NONE) goto L14;
        enqueue(r3);     // Catch: Throwable -> L17
    L15:
        monitor-exit(this);
        return;
    L14:
        tryDownloadImpl(r3);     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        throw th;
    }

    public static /* synthetic */ DownloadTask access$100(AbsDownloadEngine r0, int r1) {
        return r0.getDownloadTask(r1);
    }

    private synchronized boolean cancelImpl(int r9, boolean r10) {
        monitor-enter(this);
    L17:
        th = move-exception;
        throw th;
    L5:
        if (Logger.debug() == false) goto L7;
        Logger.taskDebug(TAG, r9, "cancel", "Trace:" + Log.getStackTraceString(new Throwable()));     // Catch: Throwable -> L17
    L7:
        DownloadTask r3 = getDownloadTask(r9);     // Catch: Throwable -> L17
        if (r3 == null) goto L10;
        DownloadInfo r4 = r3.getDownloadInfo();     // Catch: Throwable -> L17
        this.mainHandler.post(new 2(this, r3.getDownloadListeners(ListenerType.MAIN), r3, r4, r3.getDownloadListeners(ListenerType.NOTIFICATION)));     // Catch: Throwable -> L17
    L10:
        DownloadInfo r0 = this.downloadCache.getDownloadInfo(r9);     // Catch: Throwable -> L17
        if (r0 == null) goto L13;
        r0.setStatus(-4);     // Catch: Throwable -> L17
    L13:
        clearDownloadData(r9, r10, false);     // Catch: Throwable -> L17
        monitor-exit(this);
        return true;
    }

    private void removeTask(int r5, int r6) {
        if (Logger.debug() == false) goto L5;
        Logger.taskDebug(TAG, r5, "removeTask", "Listener hashCode: " + r6);
    L5:
        if (r6 != 0) goto L7;
        this.downloadTaskMap.remove(r5);
        this.downloadTaskWithListenerMap.remove(r5);
        return;
    L7:
        SparseArray<DownloadTask> r0 = this.downloadTaskWithListenerMap.get(r5);
        if (r0 == null) goto L15;
        r0.remove(r6);
        if (Logger.debug() == false) goto L13;
        Logger.taskDebug(TAG, r5, "removeTask", "After downloadTaskWithListenerMap removeTask taskArray.size: " + r0.size());
    L13:
        if (r0.size() != 0) goto L18;
        this.downloadTaskMap.remove(r5);
        this.downloadTaskWithListenerMap.remove(r5);
        return;
    L18:
        return;
    L15:
        this.downloadTaskMap.remove(r5);
    }

    private void resetDownloadDataInSubThread(int r2, boolean r3) {
        if (this.fixAnrIsolateEngineAndCache == true) goto L33;
        resetDownloadDataInSubThreadImpl(r2, r3);
        return;
    L33:
        DownloadInfo r0 = this.downloadCache.getDownloadInfo(r2);     // Catch: Throwable -> L26
        if (r0 == null) goto L31;
        DownloadUtils.deleteAllDownloadFiles(r0, r3);     // Catch: Throwable -> L26
        r0.erase();     // Catch: Throwable -> L26
    L31:
        this.downloadCache.updateDownloadInfo(r0);     // Catch: SQLiteException -> L11 Throwable -> L26
    L13:
        monitor-enter(this);     // Catch: Throwable -> L26
    L23:
        th = move-exception;
        throw th;     // Catch: Throwable -> L26
    L15:
        if (this.failedDownloadTaskMap.get(r2) == null) goto L18;
        this.failedDownloadTaskMap.remove(r2);     // Catch: Throwable -> L23
    L18:
        if (this.successDownloadTaskMap.get(r2) == null) goto L20;
        this.successDownloadTaskMap.remove(r2);     // Catch: Throwable -> L23
    L20:
        this.pengingTaskCache.remove(Integer.valueOf(r2));     // Catch: Throwable -> L23
        DownloadSetting.removeTaskDownloadSetting(r2);     // Catch: Throwable -> L23
        monitor-exit(this);     // Catch: Throwable -> L23
    L35:
        return;
    L11:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        th.printStackTrace();
    }

    private void resetDownloadDataInSubThreadImpl(int r2, boolean r3) {
        DownloadInfo r0 = this.downloadCache.getDownloadInfo(r2);     // Catch: Throwable -> L17
        if (r0 == null) goto L20;
        DownloadUtils.deleteAllDownloadFiles(r0, r3);     // Catch: Throwable -> L17
        r0.erase();     // Catch: Throwable -> L17
    L20:
        this.downloadCache.updateDownloadInfo(r0);     // Catch: SQLiteException -> L7 Throwable -> L17
    L10:
        if (this.failedDownloadTaskMap.get(r2) == null) goto L13;
        this.failedDownloadTaskMap.remove(r2);     // Catch: Throwable -> L17
    L13:
        if (this.successDownloadTaskMap.get(r2) == null) goto L15;
        this.successDownloadTaskMap.remove(r2);     // Catch: Throwable -> L17
    L15:
        this.pengingTaskCache.remove(Integer.valueOf(r2));     // Catch: Throwable -> L17
        DownloadSetting.removeTaskDownloadSetting(r2);     // Catch: Throwable -> L17
        return;
    L7:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        th.printStackTrace();
    }

    @Override // com.ss.android.socialbase.downloader.impls.IDownloadEngine
    public boolean cancel(int r10, boolean r11) {
        if (this.fixAnrIsolateEngineAndCache == true) goto L7;
        return cancelImpl(r10, r11);
    L7:
        if (Logger.debug() == false) goto L9;
        Logger.taskDebug(TAG, r10, "cancel", "Trace:" + Log.getStackTraceString(new Throwable()));
    L9:
        DownloadTask r6 = getDownloadTask(r10);
        if (r6 == null) goto L15;
        DownloadInfo r7 = r6.getDownloadInfo();
        if (r7 == null) goto L14;
        r7.setStatus(-4);
    L14:
        this.mainHandler.post(new 1(this, r6.getDownloadListeners(ListenerType.MAIN), r6, r7, r6.getDownloadListeners(ListenerType.NOTIFICATION)));
    L15:
        DownloadInfo r1 = this.downloadCache.getDownloadInfo(r10);
        if (r1 == null) goto L18;
        r1.setStatus(-4);
    L18:
        clearDownloadData(r10, r11, false);
        return true;
    }

    @Override // com.ss.android.socialbase.downloader.impls.IDownloadEngine
    public DownloadTask getDownloadTask(int r2, int r3) {
        monitor-enter(this);
        if (r3 != 0) goto L5;
        DownloadTask r4 = this.downloadTaskMap.get(r2);     // Catch: Throwable -> L11
    L9:
        monitor-exit(this);     // Catch: Throwable -> L11
        return r4;
    L5:
        SparseArray<DownloadTask> r5 = this.downloadTaskWithListenerMap.get(r2);     // Catch: Throwable -> L11
        if (r5 == null) goto L8;
        r4 = r5.get(r3);     // Catch: Throwable -> L11
        goto L9
    L8:
        r4 = null;
    L11:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.android.socialbase.downloader.impls.IDownloadEngine
    public void resetDownloadData(int r4, boolean r5) {
        if (Logger.debug() == false) goto L5;
        Logger.taskDebug(TAG, r4, "resetDownloadData", "DeleteFile:" + r5 + "Trace:" + Log.getStackTraceString(new Throwable()));
    L5:
        this.mainHandler.post(new 5(this, r4));
        DownloadComponentManager.submitCPUTask(new 6(this, r4, r5), false);
    }

    @Override // com.ss.android.socialbase.downloader.impls.IDownloadEngine
    public synchronized void setDownloadNotificationEventListener(int r2, IDownloadNotificationEventListener r3) {
        monitor-enter(this);
        DownloadTask r4 = this.downloadTaskMap.get(r2);     // Catch: Throwable -> L8
        if (r4 == null) goto L6;
        r4.setNotificationEventListener(r3);     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public static /* synthetic */ void access$200(AbsDownloadEngine r0, int r1, boolean r2) {
        r0.resetDownloadDataInSubThread(r1, r2);
    }

    private synchronized void clearDownloadDataInSubThreadImpl(int r5, boolean r6, boolean r7) {
        monitor-enter(this);
    L31:
        th = move-exception;
        throw th;
    L5:
        if (Logger.debug() == false) goto L36;
        Logger.taskDebug(TAG, r5, "clearDownloadDataInSubThread", "DeleteFile:" + r6 + " deleteFileIgnoreSecurity:" + r7);     // Catch: Throwable -> L31
    L36:
        DownloadInfo r0 = this.downloadCache.getDownloadInfo(r5);     // Catch: Throwable -> L27
        if (r0 == null) goto L34;
        if (r6 == false) goto L13;
        if (r7 == false) goto L12;
        new DownloadFile(r0.getSavePath(), r0.getName(), false, false).delete();     // Catch: Throwable -> L27
    L12:
        DownloadUtils.deleteAllDownloadFiles(r0, r6);     // Catch: Throwable -> L27
    L14:
        r0.erase();     // Catch: Throwable -> L27
        goto L34
    L13:
        DownloadUtils.deleteFile(r0.getTempPath(), r0.getTempName());     // Catch: Throwable -> L27
    L34:
        this.downloadCache.removeDownloadTaskData(r5);     // Catch: SQLiteException -> L17 Throwable -> L27
    L19:
        refreshDownloadTaskMap(r5, 0, -4);     // Catch: Throwable -> L27
        if (this.failedDownloadTaskMap.get(r5) == null) goto L23;
        this.failedDownloadTaskMap.remove(r5);     // Catch: Throwable -> L27
    L23:
        if (this.successDownloadTaskMap.get(r5) == null) goto L25;
        this.successDownloadTaskMap.remove(r5);     // Catch: Throwable -> L27
    L25:
        this.pengingTaskCache.remove(Integer.valueOf(r5));     // Catch: Throwable -> L27
        DownloadSetting.removeTaskDownloadSetting(r5);     // Catch: Throwable -> L27
    L29:
        monitor-exit(this);
        return;
    L17:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L31
        goto L29
    }

    private void notifyDownloadTaskStatus(int r12, BaseException r13, DownloadTask r14) {
        if (r14 == null) goto L16;
        DownloadInfo r7 = r14.getDownloadInfo();
        if (r7 != null) goto L7;
        Logger.globalError(TAG, "notifyDownloadTaskStatus", "DownloadInfo is null\"");
        return;
    L7:
        ListenerType r5 = ListenerType.MAIN;
        Map r1 = r14.getDownloadListeners(r5);
        ListenerType r8 = ListenerType.NOTIFICATION;
        Map r9 = r14.getDownloadListeners(r8);
        if (r14.canShowNotification() == false) goto L10;
    L13:
        boolean r10 = true;
    L14:
        DownloadListenerUtils.notifyListener(r12, r1, true, r7, r13, r5, r14);
        DownloadListenerUtils.notifyListener(r12, r9, r10, r7, r13, r8, r14);
        return;
    L10:
        if (r7.isAutoInstallWithoutNotification() == true) goto L13;
        r10 = false;
        goto L14
    }

    @Override // com.ss.android.socialbase.downloader.impls.IDownloadEngine
    public void clearDownloadData(int r4, boolean r5, boolean r6) {
        if (Logger.debug() == false) goto L5;
        Logger.taskDebug(TAG, r4, "clearDownloadData", "DeleteFile:" + r5 + " deleteFileIgnoreSecurity:" + r6 + "Trace:" + Log.getStackTraceString(new Throwable()));
    L5:
        this.mainHandler.post(new 3(this, r4));
        DownloadComponentManager.submitCPUTask(new 4(this, r4, r5, r6), false);
    }

    public void clearDownloadDataInSubThread(int r5, boolean r6, boolean r7) {
        if (this.fixAnrIsolateEngineAndCache == true) goto L7;
        clearDownloadDataInSubThreadImpl(r5, r6, r7);
        return;
    L7:
        if (Logger.debug() == false) goto L40;
        Logger.taskDebug(TAG, r5, "clearDownloadDataInSubThread", "DeleteFile:" + r6 + " deleteFileIgnoreSecurity:" + r7);
    L40:
        DownloadInfo r0 = this.downloadCache.getDownloadInfo(r5);     // Catch: Throwable -> L35
        if (r0 == null) goto L42;
        if (r6 == false) goto L15;
        if (r7 == false) goto L14;
        new DownloadFile(r0.getSavePath(), r0.getName(), false, false).delete();     // Catch: Throwable -> L35
    L14:
        DownloadUtils.deleteAllDownloadFiles(r0, r6);     // Catch: Throwable -> L35
    L16:
        r0.erase();     // Catch: Throwable -> L35
        goto L42
    L15:
        DownloadUtils.deleteFile(r0.getTempPath(), r0.getTempName());     // Catch: Throwable -> L35
    L42:
        this.downloadCache.removeDownloadTaskData(r5);     // Catch: SQLiteException -> L19 Throwable -> L35
    L21:
        monitor-enter(this);     // Catch: Throwable -> L35
        refreshDownloadTaskMap(r5, 0, -4);     // Catch: Throwable -> L32
        if (this.failedDownloadTaskMap.get(r5) == null) goto L27;
        this.failedDownloadTaskMap.remove(r5);     // Catch: Throwable -> L32
    L27:
        if (this.successDownloadTaskMap.get(r5) == null) goto L29;
        this.successDownloadTaskMap.remove(r5);     // Catch: Throwable -> L32
    L29:
        this.pengingTaskCache.remove(Integer.valueOf(r5));     // Catch: Throwable -> L32
        DownloadSetting.removeTaskDownloadSetting(r5);     // Catch: Throwable -> L32
        monitor-exit(this);     // Catch: Throwable -> L32
    L44:
        return;
    L32:
        th = move-exception;
        throw th;     // Catch: Throwable -> L35
    L19:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L35
    L35:
        th = move-exception;
        th.printStackTrace();
    }

    @Override // com.ss.android.socialbase.downloader.impls.IDownloadEngine
    public void refreshDownloadTaskMap(int r2, int r3, int r4) {
        if (r4 != (-7)) goto L5;
    L48:
        monitor-enter(this);
        DownloadTask r5 = this.downloadTaskMap.get(r2);     // Catch: Throwable -> L58
        if (r5 != null) goto L52;
    L55:
        tryDownloadNextTaskInQueue(r2);     // Catch: Throwable -> L58
        monitor-exit(this);     // Catch: Throwable -> L58
        return;
    L52:
        if (this.failedDownloadTaskMap.get(r2) != null) goto L54;
        this.failedDownloadTaskMap.put(r2, r5);     // Catch: Throwable -> L58
    L54:
        removeTask(r2, r3);     // Catch: Throwable -> L58
    L58:
        th = move-exception;
        throw th;
    L5:
        if (r4 != (-6)) goto L7;
        monitor-enter(this);
        DownloadTask r6 = this.downloadTaskMap.get(r2);     // Catch: Throwable -> L45
        this.successDownloadTaskMap.put(r2, r6);     // Catch: Throwable -> L45
        removeTask(r2, r3);     // Catch: Throwable -> L45
        monitor-exit(this);     // Catch: Throwable -> L45
        return;
    L45:
        th = move-exception;
        throw th;
    L7:
        if (r4 != (-4)) goto L9;
        monitor-enter(this);
        removeTask(r2, r3);     // Catch: Throwable -> L38
        tryDownloadNextTaskInQueue(r2);     // Catch: Throwable -> L38
        monitor-exit(this);     // Catch: Throwable -> L38
        return;
    L38:
        th = move-exception;
        throw th;
    L9:
        if (r4 != (-3)) goto L11;
        monitor-enter(this);
        DownloadTask r7 = this.downloadTaskMap.get(r2);     // Catch: Throwable -> L31
        this.successDownloadTaskMap.put(r2, r7);     // Catch: Throwable -> L31
        removeTask(r2, r3);     // Catch: Throwable -> L31
        tryDownloadNextTaskInQueue(r2);     // Catch: Throwable -> L31
        monitor-exit(this);     // Catch: Throwable -> L31
        return;
    L31:
        th = move-exception;
        throw th;
    L11:
        if (r4 == (-1)) goto L48;
        if (r4 != 8) goto L75;
        monitor-enter(this);
        DownloadTask r8 = this.downloadTaskMap.get(r2);     // Catch: Throwable -> L24
        if (r8 != null) goto L19;
    L21:
        tryDownloadNextTaskInQueue(r2);     // Catch: Throwable -> L24
        monitor-exit(this);     // Catch: Throwable -> L24
        return;
    L19:
        if (this.waitingAsyncDownloadTaskMap.get(r2) != null) goto L21;
        this.waitingAsyncDownloadTaskMap.put(r2, r8);     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.android.socialbase.downloader.impls.IDownloadEngine
    public void setThrottleNetSpeed(int r2, long r3, int r5) {
        DownloadInfo r0 = this.downloadCache.getDownloadInfo(r2);
        if (r0 == null) goto L5;
        r0.setThrottleNetSpeed(r3, r5);
    L5:
        doSetThrottleNetSpeed(r2, r3, r5);
    }

    @Override // com.ss.android.socialbase.downloader.impls.IDownloadEngine
    public void addDownloadListener(int r8, int r9, IDownloadListener r10, ListenerType r11, boolean r12) {
        addDownloadListener(r8, r9, r10, r11, r12, true);
    }

    @Override // com.ss.android.socialbase.downloader.impls.IDownloadEngine
    public synchronized void removeDownloadListener(int r2, int r3, IDownloadListener r4, ListenerType r5, boolean r6) {
        monitor-enter(this);
        DownloadTask r0 = getDownloadTask(r2);     // Catch: Throwable -> L10
        if (r0 != null) goto L6;
        r0 = this.pengingTaskCache.get(Integer.valueOf(r2));     // Catch: Throwable -> L10
    L6:
        if (r0 == null) goto L8;
        r0.removeDownloadListener(r3, r4, r5, r6);     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    private synchronized void addDownloadListenerImpl(int r7, int r8, IDownloadListener r9, ListenerType r10, boolean r11, boolean r12) {
        monitor-enter(this);
        DownloadTask r4 = getDownloadTask(r7);     // Catch: Throwable -> L32
        if (r4 == null) goto L22;
        r4.addDownloadListener(r8, r9, r10, r11);     // Catch: Throwable -> L32
        DownloadInfo r3 = r4.getDownloadInfo();     // Catch: Throwable -> L32
        if (r12 == false) goto L30;
        if (r3 == null) goto L30;
        if (isDownloading(r7) == true) goto L30;
        if (r10 == ListenerType.MAIN) goto L15;
        if (r10 != ListenerType.NOTIFICATION) goto L30;
    L15:
        if (r10 == ListenerType.NOTIFICATION) goto L17;
    L19:
        boolean r13 = true;
    L20:
        if (r13 == false) goto L30;
        this.mainHandler.post(new 8(this, r9, r3, r4, r10));     // Catch: Throwable -> L32
        goto L30
    L17:
        if (r3.canShowNotification() == true) goto L19;
        r13 = false;
    L30:
        monitor-exit(this);
        return;
    L22:
        DownloadInfo r14 = this.downloadCache.getDownloadInfo(r7);     // Catch: Throwable -> L32
        if (r14 == null) goto L30;
        if (r14.getStatus() == (-3)) goto L30;
        DownloadTask r0 = this.pengingTaskCache.get(Integer.valueOf(r7));     // Catch: Throwable -> L32
        if (r0 != null) goto L29;
        r0 = new DownloadTask(r14);     // Catch: Throwable -> L32
        this.pengingTaskCache.put(Integer.valueOf(r7), r0);     // Catch: Throwable -> L32
    L29:
        r0.addDownloadListener(r8, r9, r10, r11);     // Catch: Throwable -> L32
    L32:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.android.socialbase.downloader.impls.IDownloadEngine
    public void addDownloadListener(int r9, int r10, IDownloadListener r11, ListenerType r12, boolean r13, boolean r14) {
        if (this.fixAnrIsolateEngineAndCache == true) goto L6;
        addDownloadListenerImpl(r9, r10, r11, r12, r13, r14);
        return;
    L6:
        monitor-enter(this);
        DownloadTask r6 = getDownloadTask(r9);     // Catch: Throwable -> L43
        if (r6 == null) goto L28;
        r6.addDownloadListener(r10, r11, r12, r13);     // Catch: Throwable -> L43
        DownloadInfo r5 = r6.getDownloadInfo();     // Catch: Throwable -> L43
        if (r14 == false) goto L26;
        if (r5 == null) goto L26;
        if (isDownloading(r9) == true) goto L26;
        if (r12 == ListenerType.MAIN) goto L19;
        if (r12 != ListenerType.NOTIFICATION) goto L26;
    L19:
        if (r12 == ListenerType.NOTIFICATION) goto L21;
    L23:
        boolean r15 = true;
    L24:
        if (r15 == false) goto L26;
        int r4 = r5.getStatus();     // Catch: Throwable -> L43
        this.mainHandler.post(new 7(this, r11, r4, r5, r6, r12));     // Catch: Throwable -> L43
        goto L26
    L21:
        if (r5.canShowNotification() == true) goto L23;
        r15 = false;
    L26:
        monitor-exit(this);     // Catch: Throwable -> L43
        return;
    L28:
        monitor-exit(this);     // Catch: Throwable -> L43
        DownloadInfo r16 = this.downloadCache.getDownloadInfo(r9);
        monitor-enter(this);
        if (r16 != null) goto L47;
    L38:
        monitor-exit(this);     // Catch: Throwable -> L40
        return;
    L40:
        th = move-exception;
        throw th;
    L47:
        if (r16.getStatus() == (-3)) goto L38;
        DownloadTask r0 = this.pengingTaskCache.get(Integer.valueOf(r9));     // Catch: Throwable -> L40
        if (r0 != null) goto L37;
        r0 = new DownloadTask(r16);     // Catch: Throwable -> L40
        this.pengingTaskCache.put(Integer.valueOf(r9), r0);     // Catch: Throwable -> L40
    L37:
        r0.addDownloadListener(r10, r11, r12, r13);     // Catch: Throwable -> L40
    L43:
        th = move-exception;
        throw th;
    }
}
