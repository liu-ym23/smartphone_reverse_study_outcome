package com.ss.android.socialbase.downloader.db;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager$IndependentHolderCreator$OnMainProcessRebindErrorListener;
import com.ss.android.socialbase.downloader.downloader.ISqlDownloadCache;
import com.ss.android.socialbase.downloader.downloader.SqlDownloadCacheService;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.segment.Segment;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Future;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class SqlDownloadCacheAidlWrapper implements ISqlDownloadCache, ServiceConnection {
    private static final int BIND_MAIN_PROCESS_MAX_TIME = 5;
    private static final int BIND_MAIN_PROCESS_MIN_INTERVAL = 15000;
    private static final int MAIN_PROCESS_BIND_DELAY = 1000;
    private static final String TAG = "SqlDownloadCacheAidlWra";
    private static int sBindMainProcessTimes;
    private static boolean sIsMainProcessAlive;
    private static long sLastBindMainProcessTimeMills;
    private Runnable mCheckAliveRunnable;
    private Handler mHandler;
    private ISqlDownloadCacheAidl mISqlDownloadCache;
    private CountDownLatch mInitLock;
    private ISqlCacheLoadCompleteCallbackAidl mPengingCallback;
    private DownloadComponentManager$IndependentHolderCreator$OnMainProcessRebindErrorListener mRebindErrorListener;
    private Future<?> mSetInitCallbackFuture;

    public void clearMemoryCacheData(double r1) {
    }

    public Map<Long, Segment> getSegmentMap(int r1) {
        return null;
    }

    public ArrayList<Segment> getSegments(int r1) {
        return null;
    }

    public void initImmediately() {
    }

    public void removeSegments(int r1) {
    }

    public boolean updateSegments(int r1, Map<Long, Segment> r2) {
        return false;
    }

    private boolean bindMainProcessDelayed() {
        if (Build.VERSION.SDK_INT < 26) goto L6;
        return false;
    L6:
        if (sIsMainProcessAlive == false) goto L9;
        return false;
    L9:
        if (sBindMainProcessTimes > 5) goto L11;
        long r0 = System.currentTimeMillis();
        if ((r0 - sLastBindMainProcessTimeMills) < 15000) goto L17;
        sBindMainProcessTimes++;
        sLastBindMainProcessTimeMills = r0;
        this.mHandler.postDelayed(new 3(this), 1000);
        return true;
    L17:
        if (Logger.debug() == false) goto L19;
        Logger.globalDebug(TAG, "bindMainProcessDelayed", "Time too short since last bin");
    L19:
        return false;
    L11:
        if (Logger.debug() == false) goto L13;
        Logger.globalDebug(TAG, "bindMainProcessDelayed", "Bind too many times");
    L13:
        return false;
    }

    public void clearData() {
        ISqlDownloadCacheAidl r0 = this.mISqlDownloadCache;     // Catch: RemoteException -> L6
        if (r0 == null) goto L11;
        r0.clearData();     // Catch: RemoteException -> L6
        return;
    L11:
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
    }

    public boolean ensureDownloadCacheSyncSuccess() {
        ISqlDownloadCacheAidl r0 = this.mISqlDownloadCache;     // Catch: RemoteException -> L6
        if (r0 == null) goto L12;
        return r0.ensureDownloadCacheSyncSuccess();
    L12:
        return false;
    L6:
        e = move-exception;
        e.printStackTrace();
        return false;
    }

    public List<DownloadInfo> getAllDownloadInfo() {
        ISqlDownloadCacheAidl r0 = this.mISqlDownloadCache;     // Catch: RemoteException -> L6
        if (r0 == null) goto L12;
        return r0.getAllDownloadInfo();
    L12:
        return null;
    L6:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public boolean isDownloadCacheSyncSuccess() {
        ISqlDownloadCacheAidl r0 = this.mISqlDownloadCache;     // Catch: RemoteException -> L6
        if (r0 == null) goto L12;
        return r0.isDownloadCacheSyncSuccess();
    L12:
        return false;
    L6:
        e = move-exception;
        e.printStackTrace();
        return false;
    }

    public SqlDownloadCacheAidlWrapper() {
        this.mHandler = new Handler(Looper.getMainLooper());
        this.mPengingCallback = null;
        this.mCheckAliveRunnable = new AnonymousClass1(this);
        this.mInitLock = new CountDownLatch(1);
        SqlDownloadCacheService.startServiceAndBind(DownloadComponentManager.getAppContext(), this);
    }

    public static /* synthetic */ boolean access$000() {
        return sIsMainProcessAlive;
    }

    public static /* synthetic */ boolean access$002(boolean r0) {
        sIsMainProcessAlive = r0;
        return r0;
    }

    public static /* synthetic */ DownloadComponentManager$IndependentHolderCreator$OnMainProcessRebindErrorListener access$100(SqlDownloadCacheAidlWrapper r0) {
        return r0.mRebindErrorListener;
    }

    public static /* synthetic */ ISqlCacheLoadCompleteCallbackAidl access$200(SqlDownloadCacheAidlWrapper r0) {
        return r0.mPengingCallback;
    }

    public static /* synthetic */ ISqlDownloadCacheAidl access$300(SqlDownloadCacheAidlWrapper r0) {
        return r0.mISqlDownloadCache;
    }

    public static /* synthetic */ CountDownLatch access$400(SqlDownloadCacheAidlWrapper r0) {
        return r0.mInitLock;
    }

    public static /* synthetic */ boolean access$500(SqlDownloadCacheAidlWrapper r0) {
        return r0.bindMainProcessDelayed();
    }

    public static /* synthetic */ Runnable access$600(SqlDownloadCacheAidlWrapper r0) {
        return r0.mCheckAliveRunnable;
    }

    public static /* synthetic */ Handler access$700(SqlDownloadCacheAidlWrapper r0) {
        return r0.mHandler;
    }

    public static /* synthetic */ Future access$800(SqlDownloadCacheAidlWrapper r0) {
        return r0.mSetInitCallbackFuture;
    }

    public DownloadInfo OnDownloadTaskIntercept(int r2) {
        ISqlDownloadCacheAidl r0 = this.mISqlDownloadCache;     // Catch: RemoteException -> L6
        if (r0 == null) goto L12;
        return r0.OnDownloadTaskIntercept(r2);
    L12:
        return null;
    L6:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public DownloadInfo OnDownloadTaskPrepare(int r2) {
        ISqlDownloadCacheAidl r0 = this.mISqlDownloadCache;     // Catch: RemoteException -> L6
        if (r0 == null) goto L12;
        return r0.OnDownloadTaskPrepare(r2);
    L12:
        return null;
    L6:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public DownloadInfo OnDownloadTaskRetry(int r2) {
        ISqlDownloadCacheAidl r0 = this.mISqlDownloadCache;     // Catch: RemoteException -> L6
        if (r0 == null) goto L12;
        return r0.OnDownloadTaskRetry(r2);
    L12:
        return null;
    L6:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public boolean cacheExist(int r2) {
        ISqlDownloadCacheAidl r0 = this.mISqlDownloadCache;     // Catch: RemoteException -> L6
        if (r0 == null) goto L12;
        return r0.cacheExist(r2);
    L12:
        return false;
    L6:
        e = move-exception;
        e.printStackTrace();
        return false;
    }

    public DownloadInfo getDownloadInfo(int r2) {
        ISqlDownloadCacheAidl r0 = this.mISqlDownloadCache;     // Catch: RemoteException -> L6
        if (r0 == null) goto L12;
        return r0.getDownloadInfo(r2);
    L12:
        return null;
    L6:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public List<DownloadInfo> getDownloadInfoList(String r2) {
        ISqlDownloadCacheAidl r0 = this.mISqlDownloadCache;     // Catch: RemoteException -> L6
        if (r0 == null) goto L12;
        return r0.getDownloadInfoList(r2);
    L12:
        return null;
    L6:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public List<DownloadInfo> getDownloadInfosByFileExtension(String r2) {
        ISqlDownloadCacheAidl r0 = this.mISqlDownloadCache;     // Catch: RemoteException -> L6
        if (r0 == null) goto L12;
        return r0.getDownloadInfosByFileExtension(r2);
    L12:
        return null;
    L6:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public List<DownloadInfo> getDownloadInfosByMonitorScene(List<String> r2) {
        ISqlDownloadCacheAidl r0 = this.mISqlDownloadCache;     // Catch: RemoteException -> L6
        if (r0 == null) goto L12;
        return r0.getDownloadInfosByMonitorScene(r2);
    L12:
        return null;
    L6:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    /* JADX INFO: renamed from: getSegments, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ List m20getSegments(int r1) {
        return getSegments(r1);
    }

    public List<DownloadInfo> getSuccessedDownloadInfosWithMimeType(String r2) {
        ISqlDownloadCacheAidl r0 = this.mISqlDownloadCache;     // Catch: RemoteException -> L6
        if (r0 == null) goto L12;
        return r0.getSuccessedDownloadInfosWithMimeType(r2);
    L12:
        return null;
    L6:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public List<DownloadInfo> getUnCompletedDownloadInfosWithMimeType(String r2) {
        ISqlDownloadCacheAidl r0 = this.mISqlDownloadCache;     // Catch: RemoteException -> L6
        if (r0 == null) goto L12;
        return r0.getUnCompletedDownloadInfosWithMimeType(r2);
    L12:
        return null;
    L6:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public void init(boolean r2) {
        ISqlDownloadCacheAidl r0 = this.mISqlDownloadCache;     // Catch: RemoteException -> L6
        if (r0 == null) goto L11;
        r0.init(r2);     // Catch: RemoteException -> L6
        return;
    L11:
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
    }

    public DownloadInfo onDownloadTaskStart(int r2) {
        ISqlDownloadCacheAidl r0 = this.mISqlDownloadCache;     // Catch: RemoteException -> L6
        if (r0 == null) goto L12;
        return r0.onDownloadTaskStart(r2);
    L12:
        return null;
    L6:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName r1) {
        this.mISqlDownloadCache = null;
        sIsMainProcessAlive = false;
    }

    public boolean removeDownloadInfo(int r2) {
        ISqlDownloadCacheAidl r0 = this.mISqlDownloadCache;     // Catch: RemoteException -> L6
        if (r0 == null) goto L12;
        return r0.removeDownloadInfo(r2);
    L12:
        return false;
    L6:
        e = move-exception;
        e.printStackTrace();
        return false;
    }

    public boolean removeDownloadTaskData(int r2) {
        ISqlDownloadCacheAidl r0 = this.mISqlDownloadCache;     // Catch: RemoteException -> L6
        if (r0 == null) goto L12;
        return r0.removeDownloadTaskData(r2);
    L12:
        return false;
    L6:
        e = move-exception;
        e.printStackTrace();
        return false;
    }

    public void setInitCallback(ISqlCacheLoadCompleteCallbackAidl r2) {
        monitor-enter(this);
        ISqlDownloadCacheAidl r0 = this.mISqlDownloadCache;     // Catch: Throwable -> L12
        if (r0 != null) goto L17;
        this.mPengingCallback = r2;     // Catch: Throwable -> L12
    L10:
        monitor-exit(this);     // Catch: Throwable -> L12
        return;
    L17:
        r0.setInitCallback(r2);     // Catch: RemoteException -> L7 Throwable -> L12
    L7:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;
    }

    public void setOnMainProcessRebindErrorCallback(DownloadComponentManager$IndependentHolderCreator$OnMainProcessRebindErrorListener r1) {
        this.mRebindErrorListener = r1;
    }

    public void syncDownloadInfo(DownloadInfo r2) {
        ISqlDownloadCacheAidl r0 = this.mISqlDownloadCache;     // Catch: RemoteException -> L6
        if (r0 == null) goto L11;
        r0.syncDownloadInfo(r2);     // Catch: RemoteException -> L6
        return;
    L11:
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
    }

    public void syncDownloadInfoFromOtherCache(int r2) {
        ISqlDownloadCacheAidl r0 = this.mISqlDownloadCache;     // Catch: RemoteException -> L6
        if (r0 == null) goto L11;
        r0.syncDownloadInfoFromOtherCache(r2);     // Catch: RemoteException -> L6
        return;
    L11:
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
    }

    public boolean updateDownloadInfo(DownloadInfo r2) {
        ISqlDownloadCacheAidl r0 = this.mISqlDownloadCache;     // Catch: RemoteException -> L6
        if (r0 == null) goto L12;
        return r0.updateDownloadInfo(r2);
    L12:
        return false;
    L6:
        e = move-exception;
        e.printStackTrace();
        return false;
    }

    public DownloadInfo OnDownloadTaskCancel(int r2, long r3) {
        ISqlDownloadCacheAidl r0 = this.mISqlDownloadCache;     // Catch: RemoteException -> L6
        if (r0 == null) goto L12;
        return r0.OnDownloadTaskCancel(r2, r3);
    L12:
        return null;
    L6:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public DownloadInfo OnDownloadTaskCompleted(int r2, long r3) {
        ISqlDownloadCacheAidl r0 = this.mISqlDownloadCache;     // Catch: RemoteException -> L6
        if (r0 == null) goto L12;
        return r0.OnDownloadTaskCompleted(r2, r3);
    L12:
        return null;
    L6:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public DownloadInfo OnDownloadTaskError(int r2, long r3) {
        ISqlDownloadCacheAidl r0 = this.mISqlDownloadCache;     // Catch: RemoteException -> L6
        if (r0 == null) goto L12;
        return r0.OnDownloadTaskError(r2, r3);
    L12:
        return null;
    L6:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public DownloadInfo OnDownloadTaskPause(int r2, long r3) {
        ISqlDownloadCacheAidl r0 = this.mISqlDownloadCache;     // Catch: RemoteException -> L6
        if (r0 == null) goto L12;
        return r0.OnDownloadTaskPause(r2, r3);
    L12:
        return null;
    L6:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public DownloadInfo OnDownloadTaskProgress(int r2, long r3) {
        ISqlDownloadCacheAidl r0 = this.mISqlDownloadCache;     // Catch: RemoteException -> L6
        if (r0 == null) goto L12;
        return r0.OnDownloadTaskProgress(r2, r3);
    L12:
        return null;
    L6:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public List<DownloadInfo> getDownloadInfosByFilters(String r2, String r3) {
        ISqlDownloadCacheAidl r0 = this.mISqlDownloadCache;     // Catch: RemoteException -> L6
        if (r0 == null) goto L12;
        return r0.getDownloadInfosByFilters(r2, r3);
    L12:
        return null;
    L6:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName r2, final IBinder r3) {
        sIsMainProcessAlive = true;
        this.mHandler.removeCallbacks(this.mCheckAliveRunnable);
        this.mISqlDownloadCache = ISqlDownloadCacheAidl.Stub.asInterface(r3);     // Catch: Throwable -> L5
    L7:
        this.mSetInitCallbackFuture = DownloadComponentManager.getCPUThreadExecutor().submit(new AnonymousClass2(this, r3));
        return;
    L5:
        th = move-exception;
        th.printStackTrace();
        goto L7
    }

    public DownloadInfo OnDownloadTaskConnected(int r7, long r8, String r10, String r11) {
        ISqlDownloadCacheAidl r0 = this.mISqlDownloadCache;     // Catch: RemoteException -> L6
        if (r0 == null) goto L12;
        return r0.OnDownloadTaskConnected(r7, r8, r10, r11);
    L12:
        return null;
    L6:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public void init(final SparseArray<DownloadInfo> r8, final Set<Integer> r9, final List<DownloadInfo> r10, List<String> r11, final SqlCacheLoadCompleteCallback r12) {
        DownloadComponentManager.getCPUThreadExecutor().submit(new AnonymousClass4(this, r8, r9, r10, r12));
    }
}
