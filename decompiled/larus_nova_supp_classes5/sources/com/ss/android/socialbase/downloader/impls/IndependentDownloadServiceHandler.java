package com.ss.android.socialbase.downloader.impls;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.downloader.AbsDownloadServiceHandler;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.DownloadProcessDispatcher;
import com.ss.android.socialbase.downloader.downloader.IDownloadAidlService;
import com.ss.android.socialbase.downloader.downloader.IDownloadServiceConnectionListener;
import com.ss.android.socialbase.downloader.downloader.IndependentProcessDownloadService;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.socialbase.downloader.utils.IPCUtils;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public class IndependentDownloadServiceHandler extends AbsDownloadServiceHandler implements ServiceConnection {
    private static final String TAG = null;
    private IDownloadAidlService aidlService;
    private IDownloadServiceConnectionListener connectionListener;
    private int logLevel;

    static {
        TAG = "IndependentDownloadServiceHandler";
    }

    private void resumePendingTaskForIndependent() {
        SparseArray<List<DownloadTask>> r0 = this.pendingTasks;     // Catch: Throwable -> L29
        monitor-enter(r0);     // Catch: Throwable -> L29
        SparseArray<List<DownloadTask>> r1 = this.pendingTasks.clone();     // Catch: Throwable -> L26
        this.pendingTasks.clear();     // Catch: Throwable -> L26
        monitor-exit(r0);     // Catch: Throwable -> L26
        if (r1 != null) goto L8;
        return;
    L8:
        if (r1.size() > 0) goto L10;
        return;
    L10:
        if (DownloadComponentManager.getDownloadEngine() == null) goto L45;
        int r2 = 0;
    L13:
        if (r2 >= r1.size()) goto L46;
        List<DownloadTask> r3 = r1.get(r1.keyAt(r2));     // Catch: Throwable -> L29
        if (r3 == null) goto L25;
        Iterator<DownloadTask> r4 = r3.iterator();     // Catch: Throwable -> L29
    L18:
        if (r4.hasNext() == false) goto L25;
        this.aidlService.tryDownload(IPCUtils.convertDownloadTaskToAidl(r4.next()));     // Catch: RemoteException -> L22 Throwable -> L29
    L22:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L29
    L25:
        r2 = r2 + 1;
        goto L13
    L46:
        return;
    L45:
        return;
    L26:
        th = move-exception;
        throw th;     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        Logger.globalError(TAG, "resumePendingTaskForIndependent", "Exception:" + th);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.AbsDownloadServiceHandler, com.ss.android.socialbase.downloader.downloader.IDownloadServiceHandler
    public void startService() {
        if (this.aidlService != null) goto L6;
        startService(DownloadComponentManager.getAppContext(), this);
        return;
    }

    public IndependentDownloadServiceHandler() {
        this.logLevel = -1;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.AbsDownloadServiceHandler, com.ss.android.socialbase.downloader.downloader.IDownloadServiceHandler
    public IBinder onBind(Intent r3) {
        if (Logger.debug() == false) goto L6;
        Logger.globalDebug(TAG, "onBind", "IndependentDownloadBinder");
    L6:
        return new IndependentDownloadBinder();
    }

    @Override // android.content.ServiceConnection
    public void onBindingDied(ComponentName r1) {
        this.aidlService = null;
        IDownloadServiceConnectionListener r2 = this.connectionListener;
        if (r2 == null) goto L6;
        r2.onServiceDisConnection();
        return;
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName r3) {
        if (Logger.debug() == false) goto L5;
        Logger.globalDebug(TAG, "onServiceDisconnected", "Run");
    L5:
        this.aidlService = null;
        this.isServiceAlive = false;
        IDownloadServiceConnectionListener r4 = this.connectionListener;
        if (r4 == null) goto L9;
        r4.onServiceDisConnection();
        return;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.AbsDownloadServiceHandler, com.ss.android.socialbase.downloader.downloader.IDownloadServiceHandler
    public void setLogLevel(int r2) {
        IDownloadAidlService r0 = this.aidlService;
        if (r0 != null) goto L10;
        this.logLevel = r2;
        return;
    L10:
        r0.setLogLevel(r2);     // Catch: RemoteException -> L7
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.AbsDownloadServiceHandler, com.ss.android.socialbase.downloader.downloader.IDownloadServiceHandler
    public void setServiceConnectionListener(IDownloadServiceConnectionListener r1) {
        this.connectionListener = r1;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.AbsDownloadServiceHandler, com.ss.android.socialbase.downloader.downloader.IDownloadServiceHandler
    public void tryDownload(DownloadTask r5) {
        if (r5 != null) goto L5;
        return;
    L5:
        if (Logger.debug() == false) goto L12;
        String r0 = TAG;
        int r1 = r5.getDownloadId();
        StringBuilder r2 = new StringBuilder("AidlService == null:");
        if (this.aidlService != null) goto L9;
        boolean r3 = true;
    L10:
        r2.append(r3);
        Logger.taskDebug(r0, r1, "tryDownload", r2.toString());
        goto L12
    L9:
        r3 = false;
    L12:
        if (this.aidlService != null) goto L14;
        pendDownloadTask(r5);
        startService(DownloadComponentManager.getAppContext(), this);
        return;
    L14:
        resumePendingTaskForIndependent();
        this.aidlService.tryDownload(IPCUtils.convertDownloadTaskToAidl(r5));     // Catch: RemoteException -> L17
        return;
    L17:
        e = move-exception;
        e.printStackTrace();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.AbsDownloadServiceHandler, com.ss.android.socialbase.downloader.downloader.IDownloadServiceHandler
    public void tryDownloadWithEngine(DownloadTask r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        DownloadProcessDispatcher.getInstance().setDownloadWithIndependentProcessStatus(r4.getDownloadId(), true);
        AbsDownloadEngine r0 = DownloadComponentManager.getDownloadEngine();
        if (r0 == null) goto L8;
        r0.tryDownload(r4);
        return;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName r5, IBinder r6) {
        if (Logger.debug() == false) goto L5;
        Logger.globalDebug(TAG, "onServiceConnected", "Run");
    L5:
        this.aidlService = IDownloadAidlService.Stub.asInterface(r6);
        IDownloadServiceConnectionListener r7 = this.connectionListener;
        if (r7 == null) goto L9;
        r7.onServiceConnection(r6);
    L9:
        if (Logger.debug() == false) goto L16;
        String r8 = TAG;
        StringBuilder r2 = new StringBuilder("AidlService!=null");
        if (this.aidlService == null) goto L13;
        boolean r3 = true;
    L14:
        r2.append(r3);
        r2.append(" pendingTasks.size:");
        r2.append(this.pendingTasks.size());
        Logger.globalDebug(r8, "onServiceConnected", r2.toString());
        goto L16
    L13:
        r3 = false;
    L16:
        if (this.aidlService == null) goto L29;
        DownloadProcessDispatcher.getInstance().dispatchDownloaderProcessConnectedEvent();
        this.isServiceAlive = true;
        this.isInvokeStartService.set(false);
        int r9 = this.logLevel;
        if (r9 == (-1)) goto L24;
        this.aidlService.setLogLevel(r9);     // Catch: RemoteException -> L21
    L21:
        e = move-exception;
        e.printStackTrace();
    L24:
        if (this.aidlService == null) goto L30;
        resumePendingTaskForIndependent();
        return;
    L30:
        return;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.AbsDownloadServiceHandler
    public void startService(Context r4, ServiceConnection r5) {
    L10:
        th = move-exception;
        th.printStackTrace();
        return;
    L3:
        if (Logger.debug() == false) goto L5;
        Logger.globalDebug(TAG, "startService", "BindService");     // Catch: Throwable -> L10
    L5:
        Intent r0 = new Intent(r4, IndependentProcessDownloadService.class);     // Catch: Throwable -> L10
        if (r5 == null) goto L8;
        r4.bindService(r0, r5, 1);     // Catch: Throwable -> L10
    L8:
        r4.startService(r0);     // Catch: Throwable -> L10
    }

    @Override // com.ss.android.socialbase.downloader.downloader.AbsDownloadServiceHandler
    public void stopService(Context r4, ServiceConnection r5) {
        if (Logger.debug() == false) goto L5;
        Logger.globalDebug(TAG, "stopService", "Run");
    L5:
        this.isServiceAlive = false;
        Intent r0 = new Intent(r4, IndependentProcessDownloadService.class);
        if (r5 == null) goto L8;
        r4.unbindService(r5);
    L8:
        r4.stopService(r0);
    }
}
