package com.ss.android.socialbase.downloader.downloader;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.impls.AbsDownloadEngine;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.socialbase.downloader.service.DownloadServiceManager;
import com.ss.android.socialbase.downloader.service.IDownloadGlobalThrottleService;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public abstract class AbsDownloadServiceHandler implements IDownloadServiceHandler {
    private static final String TAG = null;
    private Runnable debounceStartServiceRunnable;
    private WeakReference<Service> downloadService;
    private Handler handler;
    protected AtomicBoolean isInvokeStartService;
    protected volatile boolean isServiceAlive;
    protected final SparseArray<List<DownloadTask>> pendingTasks;

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadServiceHandler
    public void onDestroy() {
        this.isServiceAlive = false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadServiceHandler
    public void onStartCommand(Intent r1, int r2, int r3) {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadServiceHandler
    public void onStartCommandOnMainThread() {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadServiceHandler
    public void setServiceConnectionListener(IDownloadServiceConnectionListener r1) {
    }

    public void startFakeService() {
    }

    public void startService(Context r1, ServiceConnection r2) {
    }

    public void stopService(Context r1, ServiceConnection r2) {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadServiceHandler
    public void tryDownloadWithEngine(DownloadTask r1) {
    }

    static {
        TAG = "AbsDownloadServiceHandler";
    }

    public void resumePendingTask() {
        SparseArray<List<DownloadTask>> r0 = this.pendingTasks;
        monitor-enter(r0);
        SparseArray<List<DownloadTask>> r1 = this.pendingTasks.clone();     // Catch: Throwable -> L22
        this.pendingTasks.clear();     // Catch: Throwable -> L22
        monitor-exit(r0);     // Catch: Throwable -> L22
        AbsDownloadEngine r2 = DownloadComponentManager.getDownloadEngine();
        if (r2 == null) goto L21;
        int r3 = 0;
    L10:
        if (r3 >= r1.size()) goto L32;
        List<DownloadTask> r4 = r1.get(r1.keyAt(r3));
        if (r4 == null) goto L20;
        Iterator<DownloadTask> r5 = r4.iterator();
    L15:
        if (r5.hasNext() == false) goto L20;
        DownloadTask r6 = r5.next();
        if (Logger.debugScene(r6.getDownloadInfo()) == false) goto L19;
        Logger.taskDebug(TAG, r6.getDownloadInfo(), "resumePendingTask", "Resume Task");
    L19:
        r2.tryDownload(r6);
    L20:
        r3 = r3 + 1;
        goto L10
    L32:
        return;
    L21:
        return;
    L22:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadServiceHandler
    public void startService() {
        if (this.isServiceAlive == false) goto L5;
        return;
    L5:
        if (Logger.debug() == false) goto L7;
        Logger.globalDebug(TAG, "startService", "Run StartService");
    L7:
        startService(DownloadComponentManager.getAppContext(), null);
    }

    public AbsDownloadServiceHandler() {
        this.pendingTasks = new SparseArray();
        this.isServiceAlive = false;
        this.isInvokeStartService = new AtomicBoolean(false);
        this.handler = new Handler(Looper.getMainLooper());
        this.debounceStartServiceRunnable = new AnonymousClass2(this);
    }

    static /* synthetic */ String access$000() {
        return TAG;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadServiceHandler
    public boolean isServiceAlive() {
        return this.isServiceAlive;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadServiceHandler
    public IBinder onBind(Intent r3) {
        if (Logger.debug() == false) goto L6;
        Logger.globalDebug(TAG, "onBind", "OnBind Abs");
    L6:
        return new Binder();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadServiceHandler
    public void pendDownloadTask(DownloadTask r10) {
        if (r10 != null) goto L5;
        return;
    L5:
        int r3 = r10.getDownloadId();
        DownloadInfo r4 = r10.getDownloadInfo();
        SparseArray<List<DownloadTask>> r5 = this.pendingTasks;
        monitor-enter(r5);
    L21:
        th = move-exception;
        throw th;
    L8:
        if (Logger.debugScene(r4) == false) goto L10;
        Logger.taskDebug(TAG, r4, "pendDownloadTask", "PendingTasks.size:" + this.pendingTasks.size());     // Catch: Throwable -> L21
    L10:
        List<DownloadTask> r2 = this.pendingTasks.get(r3);     // Catch: Throwable -> L21
        if (r2 != null) goto L14;
        r2 = new ArrayList();     // Catch: Throwable -> L21
        this.pendingTasks.put(r3, r2);     // Catch: Throwable -> L21
    L14:
        if (Logger.debugScene(r4) == false) goto L16;
        Logger.taskDebug(TAG, r4, "pendDownloadTask", "Before taskArray.size:" + r2.size());     // Catch: Throwable -> L21
    L16:
        r2.add(r10);     // Catch: Throwable -> L21
        if (Logger.debugScene(r4) == false) goto L19;
        Logger.taskDebug(TAG, r4, "pendDownloadTask", "After pendingTasks.size:" + this.pendingTasks.size());     // Catch: Throwable -> L21
    L19:
        monitor-exit(r5);     // Catch: Throwable -> L21
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadServiceHandler
    public void setDownloadService(WeakReference r1) {
        this.downloadService = r1;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadServiceHandler
    public void setLogLevel(int r1) {
        Logger.setLogLevel(r1);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadServiceHandler
    public void tryDownload(DownloadTask r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        DownloadInfo r0 = r5.getDownloadInfo();
        if (r0 != null) goto L7;
        return;
    L7:
        ((IDownloadGlobalThrottleService) DownloadServiceManager.getService(IDownloadGlobalThrottleService.class)).start(r5);
        if (this.isServiceAlive == true) goto L28;
        if (Logger.debugScene(r0) == false) goto L13;
        Logger.taskDebug(TAG, r0, "tryDownload", "Service is not alive");
    L13:
        if (this.isInvokeStartService.compareAndSet(false, true) == true) goto L15;
        this.handler.removeCallbacks(this.debounceStartServiceRunnable);
        this.handler.postDelayed(this.debounceStartServiceRunnable, 10);
        goto L28
    L15:
        if (Logger.debugScene(r0) == false) goto L18;
        Logger.taskDebug(TAG, r0, "tryDownload", "Do StartService");
    L18:
        if (r5.getDownloadInfo().isNeedCurrentProcess() == false) goto L20;
    L23:
        startFakeService();
        if (Logger.debugScene(r0) == false) goto L28;
        Logger.taskDebug(TAG, r0, "tryDownload", "NeedCurrentProcess");
        goto L28
    L20:
        if (DownloadUtils.optimizeMultiProcess() == true) goto L23;
        DownloadComponentManager.submitCPUTask(new 1(this));
    L28:
        if (this.pendingTasks.get(r5.getDownloadId()) == null) goto L39;
        SparseArray<List<DownloadTask>> r1 = this.pendingTasks;
        monitor-enter(r1);
    L36:
        th = move-exception;
        throw th;
    L32:
        if (this.pendingTasks.get(r5.getDownloadId()) == null) goto L34;
        this.pendingTasks.remove(r5.getDownloadId());     // Catch: Throwable -> L36
    L34:
        monitor-exit(r1);     // Catch: Throwable -> L36
    L39:
        AbsDownloadEngine r2 = DownloadComponentManager.getDownloadEngine();
        if (r2 == null) goto L42;
        r2.tryDownload(r5);
    L42:
        resumePendingTask();
    }
}
