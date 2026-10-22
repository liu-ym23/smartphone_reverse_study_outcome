package com.ss.android.socialbase.downloader.impls;

import android.content.Context;
import android.database.sqlite.SQLiteException;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.constants.DownloadCacheSyncStatus;
import com.ss.android.socialbase.downloader.db.EmptySqlDownloadCache;
import com.ss.android.socialbase.downloader.db.SqlDownloadCache;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.IDownloadCache;
import com.ss.android.socialbase.downloader.downloader.IDownloadLaunchHandler;
import com.ss.android.socialbase.downloader.downloader.IDownloadProxy;
import com.ss.android.socialbase.downloader.downloader.ISqlDownloadCache;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.monitor.DownloadMonitorHelper;
import com.ss.android.socialbase.downloader.segment.Segment;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.thread.WeakDownloadHandler;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public class DefaultDownloadCache implements IDownloadCache {
    private static final int MSG_RESUME = 1;
    private static final String TAG = "DefaultDownloadCache";
    private static AtomicBoolean isInitFinish;
    private static AtomicBoolean isRunInit;
    private WeakDownloadHandler.IHandler IHandler;
    private int bizCloseDBBatchInit;
    private final DownloadCache downloadCache;
    private volatile boolean hasInitSqlDownloadCache;
    private int loadDBWaitTime;
    private ThreadLocal<Boolean> mThreadDownloadCacheLoaded;
    private boolean mThreadLoadDownloadCacheOnlyOnce;
    private volatile ISqlDownloadCache sqlDownloadCache;
    private volatile boolean unCompleteTaskResumed;
    private WeakDownloadHandler weakHandler;

    static {
        isRunInit = new AtomicBoolean(false);
        isInitFinish = new AtomicBoolean(false);
    }

    private void initFinish() {
        if (isInitFinish.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        onDownloadCacheSyncSuccess();
        resumeUnCompleteTaskMayDelayed();
        DownloadComponentManager.onDownloadCacheSyncCallback(DownloadCacheSyncStatus.SYNC_SUCCESS);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public void clearData() {
        this.downloadCache.clearData();     // Catch: SQLiteException -> L4
    L7:
        if (DownloadHelper.needNotifyDownloaderProcess() == true) goto L9;
    L14:
        this.sqlDownloadCache.clearData();
        return;
    L9:
        if (DownloadUtils.optimizeMultiProcess() == true) goto L14;
        IDownloadProxy r0 = DownloadProxy.get(true);
        if (r0 == null) goto L13;
        r0.clearData();
        return;
    L13:
        this.sqlDownloadCache.clearData();
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public boolean ensureDownloadCacheSyncSuccess() {
        if (this.hasInitSqlDownloadCache == false) goto L7;
        return true;
    L7:
        if (this.downloadCache.isActiveLoadDownloadCache() == false) goto L10;
        newEnsureDownloadCacheSyncSuccess();
        return this.hasInitSqlDownloadCache;
    L10:
        monitor-enter(this);
    L29:
        th = move-exception;
        throw th;
    L12:
        if (this.hasInitSqlDownloadCache == false) goto L14;
    L26:
        monitor-exit(this);     // Catch: Throwable -> L29
        return this.hasInitSqlDownloadCache;
    L14:
        if (Logger.debug() == false) goto L17;
        Logger.globalDebug(TAG, "ensureDownloadCacheSyncSuccess", "Waiting start:" + this.loadDBWaitTime);     // Catch: Throwable -> L29
    L17:
        if (this.bizCloseDBBatchInit > 0) goto L19;
    L23:
        waitDBLoad(this);     // Catch: Throwable -> L29
        if (Logger.debug() == false) goto L26;
        Logger.globalDebug(TAG, "ensureDownloadCacheSyncSuccess", "Waiting end");     // Catch: Throwable -> L29
        goto L26
    L19:
        if (this.sqlDownloadCache == null) goto L23;
        if ((this.sqlDownloadCache instanceof SqlDownloadCache) == false) goto L23;
        ((SqlDownloadCache) this.sqlDownloadCache).resetNewBatchInit();     // Catch: Throwable -> L29
        goto L23
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public List<DownloadInfo> getAllDownloadInfo() {
        return this.downloadCache.getAllDownloadInfo();
    }

    public void resumeUnCompleteTask() {
        if (this.hasInitSqlDownloadCache == true) goto L6;
        return;
    L6:
        if (this.unCompleteTaskResumed == true) goto L8;
        this.unCompleteTaskResumed = true;
        if (DownloadHelper.isMainProcess() == true) goto L14;
        return;
    L14:
        IDownloadLaunchHandler r1 = DownloadComponentManager.getDownloadLaunchHandler();
        List<DownloadInfo> r2 = this.downloadCache.getAutoResumeList();
        if (r1 == null) goto L22;
        if (r2 != null) goto L18;
        return;
    L18:
        if (r2.isEmpty() == true) goto L24;
        r1.onLaunchResume(r2, 1);
        return;
    L24:
        return;
    L22:
        return;
    L8:
        if (Logger.debug() == false) goto L21;
        Logger.globalDebug(TAG, "resumeUnCompleteTask", "Has resumed, return");
        return;
    }

    public void resumeUnCompleteTaskMayDelayed() {
        Message r0 = this.weakHandler.obtainMessage(1);
        this.weakHandler.sendMessageDelayed(r0, 4000);
    }

    public void updateDownloadSpInfo() {
        if (this.hasInitSqlDownloadCache == true) goto L5;
        return;
    L5:
        Context r0 = DownloadComponentManager.getAppContext();
        if (r0 != null) goto L8;
        return;
    L8:
        DownloadComponentManager.submitIOTask(new 7(this, r0));
    }

    public DefaultDownloadCache() {
        boolean r0 = false;
        this.mThreadLoadDownloadCacheOnlyOnce = false;
        this.mThreadDownloadCacheLoaded = new ThreadLocal();
        this.IHandler = new AnonymousClass1(this);
        this.weakHandler = null;
        boolean r1 = DownloadHelper.isMainProcess();
        if (DownloadUtils.isMultiProcessNoDBMode() == false) goto L7;
        if (r1 == true) goto L7;
        this.sqlDownloadCache = new EmptySqlDownloadCache();
    L22:
        this.hasInitSqlDownloadCache = false;
        this.weakHandler = new WeakDownloadHandler(Looper.getMainLooper(), this.IHandler);
        if (DownloadSetting.getGlobalSettings().optInt("lru_download_info_cache_enable", 0) <= 0) goto L25;
    L28:
        boolean r2 = true;
    L30:
        if (r2 == false) goto L32;
        Logger.alogE(TAG, "Construct enableLru");
    L33:
        if (r2 == true) goto L37;
        if (DownloadComponentManager.isEnableLruCache() == true) goto L37;
    L39:
        this.downloadCache = new DownloadCache(this.sqlDownloadCache);
    L40:
        DownloadMonitorHelper.monitorLru(this.downloadCache instanceof LruDownloadCache);
        this.loadDBWaitTime = DownloadSetting.getGlobalSettings().optInt("load_db_wait_time_ms", 5000);
        this.bizCloseDBBatchInit = DownloadSetting.getGlobalSettings().optInt("biz_close_db_batch_init", 0);
        if (DownloadSetting.getGlobalSettings().optInt("thread_load_download_cache_only_once") <= 0) goto L43;
        r0 = true;
    L43:
        this.mThreadLoadDownloadCacheOnlyOnce = r0;
        Runnable r3 = new AnonymousClass4(this);
        long r4 = DownloadSetting.obtainGlobal().optLong("delay_init_download_cache_ms");
        if (r4 <= 0) goto L46;
        DownloadComponentManager.submitScheduleTask(r3, r4, TimeUnit.MILLISECONDS);
        return;
    L46:
        r3.run();
        return;
    L37:
        if ((this.sqlDownloadCache instanceof EmptySqlDownloadCache) == true) goto L39;
        this.downloadCache = new LruDownloadCache(this.sqlDownloadCache);
        goto L40
    L32:
        Logger.alogE(TAG, "Construct disableLru:" + Log.getStackTraceString(new Throwable("LruConstruct")));
        goto L33
    L25:
        if (DownloadHelper.getCacheSettingInt("lru_download_info_cache_enable") > 0) goto L28;
        r2 = false;
    L7:
        if (DownloadUtils.isMultiProcessNormalDBMode() == false) goto L13;
        if (r1 == true) goto L13;
        DownloadComponentManager.IndependentHolderCreator r5 = DownloadComponentManager.getNormalDBIndependentHolderCreator();
        if (r5 == null) goto L12;
        this.sqlDownloadCache = r5.createCache(new 2(this));
        goto L22
    L12:
        this.sqlDownloadCache = new SqlDownloadCache();
    L13:
        if (r1 == false) goto L15;
    L21:
        this.sqlDownloadCache = new SqlDownloadCache();
        goto L22
    L15:
        if (DownloadComponentManager.supportMultiProc() == false) goto L21;
        DownloadComponentManager.IndependentHolderCreator r6 = DownloadComponentManager.getIndependentHolderCreator();
        if (r6 == null) goto L20;
        this.sqlDownloadCache = r6.createCache(new 3(this));
        goto L22
    L20:
        this.sqlDownloadCache = new SqlDownloadCache();
        goto L22
    }

    private void newEnsureDownloadCacheSyncSuccess() {
        AbsDownloadEngine r0 = DownloadComponentManager.getDownloadEngine();
        monitor-enter(r0);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (this.hasInitSqlDownloadCache == false) goto L7;
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L14
        return;
    L7:
        if (Logger.debug() == false) goto L9;
        Logger.globalDebug(TAG, "newEnsureDownloadCacheSyncSuccess", "Waiting start");     // Catch: Throwable -> L14
    L9:
        initImmediately();     // Catch: Throwable -> L14
        waitDBLoad(r0);     // Catch: Throwable -> L14
        if (Logger.debug() == false) goto L12;
        Logger.globalDebug(TAG, "newEnsureDownloadCacheSyncSuccess", "Waiting end");     // Catch: Throwable -> L14
        goto L12
    }

    private void newOnDownloadCacheSyncSuccess() {
        AbsDownloadEngine r0 = DownloadComponentManager.getDownloadEngine();
        monitor-enter(r0);
        this.hasInitSqlDownloadCache = true;     // Catch: Throwable -> L8
        r0.notifyAll();     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private void onDownloadCacheSyncSuccess() {
        if (Logger.debug() == false) goto L6;
        Logger.globalDebug(TAG, "onDownloadCacheSyncSuccess", "Run");
    L6:
        if (this.downloadCache.isActiveLoadDownloadCache() == false) goto L9;
        newOnDownloadCacheSyncSuccess();
        return;
    L9:
        monitor-enter(this);
        this.hasInitSqlDownloadCache = true;     // Catch: Throwable -> L14
        notifyAll();     // Catch: Throwable -> L14
        monitor-exit(this);     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public void initImmediately() {
        if (Logger.debug() == false) goto L5;
        Logger.globalDebug(TAG, "initImmediately", "Run isRunInit:" + isRunInit.get());
    L5:
        init(this.downloadCache instanceof LruDownloadCache);
    }

    public DownloadCache getDownloadCache() {
        return this.downloadCache;
    }

    public ISqlDownloadCache getSqlDownloadCache() {
        return this.sqlDownloadCache;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public boolean isDownloadCacheSyncSuccess() {
        return this.hasInitSqlDownloadCache;
    }

    public static /* synthetic */ DownloadCache access$100(DefaultDownloadCache r0) {
        return r0.downloadCache;
    }

    public static /* synthetic */ void access$200(DefaultDownloadCache r0) {
        r0.initFinish();
    }

    private void updateDownloadInfoInDB(DownloadInfo r2) {
        updateDownloadInfoInDB(r2, true);
    }

    private void waitDBLoad(Object r6) {
        if (this.mThreadLoadDownloadCacheOnlyOnce == false) goto L9;
        if (this.mThreadDownloadCacheLoaded.get() == null) goto L7;
        return;
    L7:
        this.mThreadDownloadCacheLoaded.set(Boolean.TRUE);
    L9:
        if (Logger.debug() == false) goto L18;
        Logger.globalDebug(TAG, "waitDBLoad", "Run loadDBWaitTime:" + this.loadDBWaitTime);
    L18:
        int r0 = this.loadDBWaitTime;     // Catch: Throwable -> L15
        if (r0 <= 0) goto L20;
        r6.wait(r0);     // Catch: Throwable -> L15
        return;
    L20:
        return;
    L15:
        th = move-exception;
        th.printStackTrace();
        Logger.globalError(TAG, "waitDBLoad", "Error:" + th);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo OnDownloadTaskIntercept(int r2) {
        DownloadInfo r3 = this.downloadCache.OnDownloadTaskIntercept(r2);
        updateDownloadInfoInDB(r3);
        return r3;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo OnDownloadTaskPrepare(int r2) {
        DownloadInfo r3 = this.downloadCache.OnDownloadTaskPrepare(r2);
        updateDownloadInfoInDB(r3);
        return r3;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo OnDownloadTaskRetry(int r2) {
        DownloadInfo r3 = this.downloadCache.OnDownloadTaskRetry(r2);
        updateDownloadInfoInDB(r3);
        return r3;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public boolean cacheExist(int r1) {
        if (getDownloadInfo(r1) == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public void clearMemoryCacheData(double r2) {
        this.downloadCache.clearMemoryCacheData(r2);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo getDownloadInfo(int r2) {
        return this.downloadCache.getDownloadInfo(r2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public List<DownloadInfo> getDownloadInfoList(String r2) {
        return this.downloadCache.getDownloadInfoList(r2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public List<DownloadInfo> getDownloadInfosByFileExtension(String r2) {
        return this.downloadCache.getDownloadInfosByFileExtension(r2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public List<DownloadInfo> getDownloadInfosByMonitorScene(List<String> r2) {
        return this.downloadCache.getDownloadInfosByMonitorScene(r2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public Map<Long, Segment> getSegmentMap(int r3) {
        Map<Long, Segment> r0 = this.downloadCache.getSegmentMap(r3);
        if (r0 != null) goto L5;
    L6:
        Map<Long, Segment> r1 = this.sqlDownloadCache.getSegmentMap(r3);
        this.downloadCache.updateSegments(r3, r1);
        return r1;
    L5:
        if (r0.isEmpty() == true) goto L6;
        return r0;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public List<Segment> getSegments(int r3) {
        List<Segment> r0 = this.downloadCache.getSegments(r3);
        if (r0 == null) goto L7;
        if (r0.size() == 0) goto L7;
        return r0;
    L7:
        return this.sqlDownloadCache.getSegments(r3);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public List<DownloadInfo> getSuccessedDownloadInfosWithMimeType(String r2) {
        return this.downloadCache.getSuccessedDownloadInfosWithMimeType(r2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public List<DownloadInfo> getUnCompletedDownloadInfosWithMimeType(String r2) {
        return this.downloadCache.getUnCompletedDownloadInfosWithMimeType(r2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public void init(boolean r9) {
        if (isRunInit.compareAndSet(false, true) == true) goto L6;
        return;
    L6:
        if (Logger.debug() == false) goto L8;
        Logger.globalDebug(TAG, "init", "Run");
    L8:
        DownloadComponentManager.onDownloadCacheSyncCallback(DownloadCacheSyncStatus.SYNC_START);
        final SparseArray<DownloadInfo> r3 = new SparseArray();
        this.downloadCache.copyDownloadInfoMap(r3);
        this.sqlDownloadCache.init(r3, this.downloadCache.getUnreadDBSet(), this.downloadCache.getAutoResumeList(), this.downloadCache.getMimeTypes(), new AnonymousClass5(this, r3));
        int r10 = DownloadSetting.getGlobalSettings().optInt("init_download_cache_timeout_ms");
        if (Logger.debug() == false) goto L11;
        Logger.globalDebug(TAG, "init", "InitTimeout:" + r10);
    L11:
        if (r10 > 0) goto L13;
        return;
    L13:
        DownloadComponentManager.submitScheduleTask(new 6(this), r10, TimeUnit.MILLISECONDS);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo onDownloadTaskStart(int r2) {
        DownloadInfo r3 = this.downloadCache.onDownloadTaskStart(r2);
        updateDownloadInfoInDB(r3);
        return r3;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public boolean removeDownloadInfo(int r2) {
    L12:
        e = move-exception;
        e.printStackTrace();
    L15:
        return this.downloadCache.removeDownloadInfo(r2);
    L3:
        if (DownloadHelper.needNotifyDownloaderProcess() == true) goto L5;
    L10:
        this.sqlDownloadCache.removeDownloadInfo(r2);     // Catch: SQLiteException -> L12
    L16:
        goto L15
    L5:
        if (DownloadUtils.optimizeMultiProcess() == true) goto L10;
        IDownloadProxy r0 = DownloadProxy.get(true);     // Catch: SQLiteException -> L12
        if (r0 == null) goto L9;
        r0.removeDownloadInfo(r2);     // Catch: SQLiteException -> L12
        goto L16
    L9:
        this.sqlDownloadCache.removeDownloadInfo(r2);     // Catch: SQLiteException -> L12
        goto L16
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public boolean removeDownloadTaskData(int r2) {
        if (DownloadHelper.needNotifyDownloaderProcess() == true) goto L5;
    L10:
        this.sqlDownloadCache.removeDownloadTaskData(r2);
    L12:
        return this.downloadCache.removeDownloadTaskData(r2);
    L5:
        if (DownloadUtils.optimizeMultiProcess() == true) goto L10;
        IDownloadProxy r0 = DownloadProxy.get(true);
        if (r0 == null) goto L9;
        r0.removeDownloadTaskData(r2);
        goto L12
    L9:
        this.sqlDownloadCache.removeDownloadTaskData(r2);
        goto L12
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public void removeSegments(int r2) {
        this.downloadCache.removeSegments(r2);
        this.sqlDownloadCache.removeSegments(r2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public void syncDownloadInfo(DownloadInfo r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        this.downloadCache.updateDownloadInfo(r2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public void syncDownloadInfoFromOtherCache(int r2) {
        updateDownloadInfo(this.downloadCache.getDownloadInfo(r2));     // Catch: Exception -> L12
        if (DownloadHelper.needNotifyDownloaderProcess() == true) goto L5;
    L10:
        this.sqlDownloadCache.syncDownloadInfoFromOtherCache(r2);     // Catch: Exception -> L12
    L15:
        return;
    L5:
        if (DownloadUtils.optimizeMultiProcess() == true) goto L10;
        IDownloadProxy r0 = DownloadProxy.get(true);     // Catch: Exception -> L12
        if (r0 == null) goto L9;
        r0.syncDownloadInfoFromOtherCache(r2);     // Catch: Exception -> L12
        goto L15
    L9:
        this.sqlDownloadCache.syncDownloadInfoFromOtherCache(r2);     // Catch: Exception -> L12
    L12:
        e = move-exception;
        e.printStackTrace();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public boolean updateDownloadInfo(DownloadInfo r2) {
        if (r2 != null) goto L5;
        return false;
    L5:
        boolean r0 = this.downloadCache.updateDownloadInfo(r2);
        updateDownloadInfoInDB(r2);
        return r0;
    }

    public static /* synthetic */ ISqlDownloadCache access$002(DefaultDownloadCache r0, ISqlDownloadCache r1) {
        r0.sqlDownloadCache = r1;
        return r1;
    }

    private void updateDownloadInfoInDB(DownloadInfo r2, boolean r3) {
        if (r2 != null) goto L5;
        return;
    L5:
        if (DownloadHelper.needNotifyDownloaderProcess() == true) goto L7;
    L13:
        this.sqlDownloadCache.updateDownloadInfo(r2);
        return;
    L7:
        if (DownloadUtils.optimizeMultiProcess() == true) goto L13;
        if (r3 == false) goto L15;
        IDownloadProxy r4 = DownloadProxy.get(true);
        if (r4 == null) goto L12;
        r4.updateDownloadInfo(r2);
        return;
    L12:
        this.sqlDownloadCache.updateDownloadInfo(r2);
        return;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo OnDownloadTaskCancel(int r2, long r3) {
        DownloadInfo r4 = this.downloadCache.OnDownloadTaskCancel(r2, r3);
        syncDownloadInfoFromOtherCache(r2);
        return r4;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo OnDownloadTaskCompleted(int r2, long r3) {
        DownloadInfo r4 = this.downloadCache.OnDownloadTaskCompleted(r2, r3);
        syncDownloadInfoFromOtherCache(r2);
        return r4;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo OnDownloadTaskError(int r2, long r3) {
        DownloadInfo r4 = this.downloadCache.OnDownloadTaskError(r2, r3);
        syncDownloadInfoFromOtherCache(r2);
        return r4;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo OnDownloadTaskPause(int r2, long r3) {
        DownloadInfo r4 = this.downloadCache.OnDownloadTaskPause(r2, r3);
        syncDownloadInfoFromOtherCache(r2);
        return r4;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo OnDownloadTaskProgress(int r2, long r3) {
        DownloadInfo r4 = this.downloadCache.OnDownloadTaskProgress(r2, r3);
        updateDownloadInfoInDB(r4, false);
        return r4;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public List<DownloadInfo> getDownloadInfosByFilters(String r2, String r3) {
        return this.downloadCache.getDownloadInfosByFilters(r2, r3);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public boolean updateSegments(int r2, Map<Long, Segment> r3) {
        this.downloadCache.updateSegments(r2, r3);
        this.sqlDownloadCache.updateSegments(r2, r3);
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo OnDownloadTaskConnected(int r7, long r8, String r10, String r11) {
        DownloadInfo r9 = this.downloadCache.OnDownloadTaskConnected(r7, r8, r10, r11);
        updateDownloadInfoInDB(r9);
        return r9;
    }
}
