package com.ss.android.socialbase.downloader.impls;

import android.os.IBinder;
import android.os.RemoteException;
import android.util.Pair;
import com.ss.android.socialbase.downloader.constants.ListenerType;
import com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventListener;
import com.ss.android.socialbase.downloader.depend.INotificationClickCallback;
import com.ss.android.socialbase.downloader.depend.ProcessCallback;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.DownloadProcessDispatcher;
import com.ss.android.socialbase.downloader.downloader.IDownloadAidlService;
import com.ss.android.socialbase.downloader.downloader.IDownloadProxy;
import com.ss.android.socialbase.downloader.downloader.IDownloadServiceConnectionListener;
import com.ss.android.socialbase.downloader.downloader.IDownloadServiceHandler;
import com.ss.android.socialbase.downloader.downloader.IndependentProcessDownloadService;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import com.ss.android.socialbase.downloader.utils.IPCUtils;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public class IndependentProcessDownloadHandler implements IDownloadProxy, IDownloadServiceConnectionListener {
    private static final String TAG = null;
    private volatile IDownloadAidlService aidlService;
    private IDownloadProxy downloadProxy;
    private IDownloadServiceHandler<IndependentProcessDownloadService> downloadServiceHandler;

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public List<DownloadInfo> getDownloadInfosBySavePath(String r1) {
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public Map<String, Pair<Integer, Long>> getInstalledTimeStampBySavePath(String r1) {
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadServiceConnectionListener
    public void onServiceDisConnection() {
        this.aidlService = null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void syncDownloadInfo(DownloadInfo r1) {
    }

    static {
        TAG = "IndependentProcessDownloadHandler";
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void clearData() {
        if (this.aidlService != null) goto L10;
        this.downloadProxy.clearData();
        return;
    L10:
        this.aidlService.clearData();     // Catch: RemoteException -> L7
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public List<DownloadInfo> getAllDownloadInfo() {
        if (this.aidlService == null) goto L5;
        return this.aidlService.getAllDownloadInfo();
    L8:
        e = move-exception;
        e.printStackTrace();
        return null;
    L5:
        return this.downloadProxy.getAllDownloadInfo();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public boolean isDownloadCacheSyncSuccess() {
        if (this.aidlService == null) goto L5;
        return this.aidlService.isDownloadCacheSyncSuccess();
    L8:
        e = move-exception;
        e.printStackTrace();
        return false;
    L5:
        return this.downloadProxy.isDownloadCacheSyncSuccess();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public boolean isServiceAlive() {
        if (this.aidlService == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void pauseAll() {
        if (this.aidlService != null) goto L10;
        return;
    L10:
        this.aidlService.pauseAll();     // Catch: RemoteException -> L7
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void startService() {
        IDownloadServiceHandler<IndependentProcessDownloadService> r0 = this.downloadServiceHandler;
        if (r0 == null) goto L6;
        r0.startService();
        return;
    }

    public IndependentProcessDownloadHandler() {
        this.downloadProxy = new ProcessDownloadHandler();
        IDownloadServiceHandler<IndependentProcessDownloadService> r0 = DownloadComponentManager.getIndependentDownloadServiceHandler();
        this.downloadServiceHandler = r0;
        r0.setServiceConnectionListener(this);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public boolean isHttpServiceInit() {
        return DownloadComponentManager.isHttpServiceInit();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void addProcessCallback(ProcessCallback r2) {
        if (this.aidlService == null) goto L11;
        this.aidlService.addProcessCallback(IPCUtils.convertProcessCallbackToAidl(r2));     // Catch: RemoteException -> L6
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public boolean canResume(int r3) {
        if (this.aidlService != null) goto L10;
        return false;
    L10:
        return this.aidlService.canResume(r3);
    L7:
        e = move-exception;
        e.printStackTrace();
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public long getCurBytes(int r4) {
        if (this.aidlService != null) goto L10;
        return 0;
    L10:
        return this.aidlService.getCurBytes(r4);
    L7:
        e = move-exception;
        e.printStackTrace();
        return 0;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public IDownloadFileUriProvider getDownloadFileUriProvider(int r2) {
        if (this.aidlService == null) goto L12;
        return IPCUtils.convertFileProviderFromAidl(this.aidlService.getDownloadFileUriProvider(r2));
    L6:
        e = move-exception;
        e.printStackTrace();
        return null;
    L12:
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public DownloadInfo getDownloadInfo(int r2) {
        if (this.aidlService == null) goto L5;
        return this.aidlService.getDownloadInfo(r2);
    L8:
        e = move-exception;
        e.printStackTrace();
        return null;
    L5:
        return this.downloadProxy.getDownloadInfo(r2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public List<DownloadInfo> getDownloadInfoList(String r2) {
        if (this.aidlService == null) goto L5;
        return this.aidlService.getDownloadInfoList(r2);
    L8:
        e = move-exception;
        e.printStackTrace();
        return null;
    L5:
        return this.downloadProxy.getDownloadInfoList(r2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public List<DownloadInfo> getDownloadInfosByFileExtension(String r2) {
        if (this.aidlService == null) goto L5;
        return this.aidlService.getDownloadInfosByFileExtension(r2);
    L8:
        e = move-exception;
        e.printStackTrace();
        return null;
    L5:
        return this.downloadProxy.getDownloadInfosByFileExtension(r2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public List<DownloadInfo> getDownloadInfosByMonitorScene(List<String> r2) {
        if (this.aidlService == null) goto L5;
        return this.aidlService.getDownloadInfosByMonitorScene(r2);
    L8:
        e = move-exception;
        e.printStackTrace();
        return null;
    L5:
        return this.downloadProxy.getDownloadInfosByMonitorScene(r2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public IDownloadNotificationEventListener getDownloadNotificationEventListener(int r2) {
        if (this.aidlService == null) goto L12;
        return IPCUtils.convertDownloadNotificationEventListenerFromAidl(this.aidlService.getDownloadNotificationEventListener(r2));
    L6:
        e = move-exception;
        e.printStackTrace();
        return null;
    L12:
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public int getDownloadWithIndependentProcessStatus(int r2) {
        if (this.aidlService == null) goto L5;
        return this.aidlService.getDownloadWithIndependentProcessStatus(r2);
    L8:
        e = move-exception;
        e.printStackTrace();
        return -1;
    L5:
        return DownloadProcessDispatcher.getInstance().getDownloadWithIndependentProcessStatusInner(r2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public List<DownloadInfo> getDownloadingDownloadInfosWithMimeType(String r2) {
        if (this.aidlService == null) goto L12;
        return this.aidlService.getDownloadingDownloadInfosWithMimeType(r2);
    L6:
        e = move-exception;
        e.printStackTrace();
        return null;
    L12:
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public INotificationClickCallback getNotificationClickCallback(int r2) {
        if (this.aidlService == null) goto L12;
        return IPCUtils.convertNotificationClickCallbackFromAidl(this.aidlService.getNotificationClickCallback(r2));
    L6:
        e = move-exception;
        e.printStackTrace();
        return null;
    L12:
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public int getStatus(int r3) {
        if (this.aidlService != null) goto L10;
        return 0;
    L10:
        return this.aidlService.getStatus(r3);
    L7:
        e = move-exception;
        e.printStackTrace();
        return 0;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public List<DownloadInfo> getSuccessedDownloadInfosWithMimeType(String r2) {
        if (this.aidlService == null) goto L5;
        return this.aidlService.getSuccessedDownloadInfosWithMimeType(r2);
    L8:
        e = move-exception;
        e.printStackTrace();
        return null;
    L5:
        return this.downloadProxy.getSuccessedDownloadInfosWithMimeType(r2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public List<DownloadInfo> getUnCompletedDownloadInfosWithMimeType(String r2) {
        if (this.aidlService == null) goto L5;
        return this.aidlService.getUnCompletedDownloadInfosWithMimeType(r2);
    L8:
        e = move-exception;
        e.printStackTrace();
        return null;
    L5:
        return this.downloadProxy.getUnCompletedDownloadInfosWithMimeType(r2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public boolean isDownloadSuccessAndFileNotExist(DownloadInfo r2) {
        if (this.aidlService == null) goto L5;
        return this.aidlService.isDownloadSuccessAndFileNotExist(r2);
    L8:
        e = move-exception;
        e.printStackTrace();
        return false;
    L5:
        return this.downloadProxy.isDownloadSuccessAndFileNotExist(r2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public boolean isDownloading(int r3) {
        if (this.aidlService != null) goto L10;
        return false;
    L10:
        return this.aidlService.isDownloading(r3);
    L7:
        e = move-exception;
        e.printStackTrace();
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadServiceConnectionListener
    public void onServiceConnection(IBinder r1) {
        this.aidlService = IDownloadAidlService.Stub.asInterface(r1);
        if (DownloadHelper.isMainProcess() == false) goto L6;
        addProcessCallback(new AnonymousClass1(this));
        return;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public boolean removeDownloadInfo(int r2) {
        if (this.aidlService == null) goto L5;
        return this.aidlService.removeDownloadInfo(r2);
    L8:
        e = move-exception;
        e.printStackTrace();
        return false;
    L5:
        return this.downloadProxy.removeDownloadInfo(r2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public boolean removeDownloadTaskData(int r2) {
        if (this.aidlService == null) goto L5;
        return this.aidlService.removeDownloadTaskData(r2);
    L8:
        e = move-exception;
        e.printStackTrace();
        return false;
    L5:
        return this.downloadProxy.removeDownloadTaskData(r2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void restart(int r2) {
        if (this.aidlService != null) goto L10;
        return;
    L10:
        this.aidlService.restart(r2);     // Catch: RemoteException -> L7
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void restartAllFailedDownloadTasks(List<String> r2) {
        if (this.aidlService != null) goto L10;
        this.downloadProxy.restartAllFailedDownloadTasks(r2);
        return;
    L10:
        this.aidlService.restartAllFailedDownloadTasks(r2);     // Catch: RemoteException -> L7
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void restartAllPauseReserveOnWifiDownloadTasks(List<String> r2) {
        if (this.aidlService != null) goto L10;
        this.downloadProxy.restartAllPauseReserveOnWifiDownloadTasks(r2);
        return;
    L10:
        this.aidlService.restartAllPauseReserveOnWifiDownloadTasks(r2);     // Catch: RemoteException -> L7
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void resume(int r2) {
        if (this.aidlService != null) goto L10;
        return;
    L10:
        this.aidlService.resume(r2);     // Catch: RemoteException -> L7
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void setLogLevel(int r2) {
        IDownloadServiceHandler<IndependentProcessDownloadService> r0 = this.downloadServiceHandler;
        if (r0 == null) goto L6;
        r0.setLogLevel(r2);
        return;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void syncDownloadInfoFromOtherCache(int r2) {
        if (this.aidlService != null) goto L10;
        this.downloadProxy.syncDownloadInfoFromOtherCache(r2);
        return;
    L10:
        this.aidlService.syncDownloadInfoFromOtherCache(r2);     // Catch: RemoteException -> L7
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void tryDownload(DownloadTask r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        IDownloadServiceHandler<IndependentProcessDownloadService> r0 = this.downloadServiceHandler;
        if (r0 == null) goto L8;
        r0.tryDownload(r2);
        return;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void tryDownloadWithEngine(DownloadTask r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        IDownloadServiceHandler<IndependentProcessDownloadService> r0 = this.downloadServiceHandler;
        if (r0 == null) goto L8;
        r0.tryDownloadWithEngine(r2);
        return;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public boolean updateDownloadInfo(DownloadInfo r2) {
        if (this.aidlService == null) goto L5;
        return this.aidlService.updateDownloadInfo(r2);
    L8:
        e = move-exception;
        e.printStackTrace();
        return false;
    L5:
        return this.downloadProxy.updateDownloadInfo(r2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void cancel(int r2, boolean r3) {
        if (this.aidlService != null) goto L10;
        return;
    L10:
        this.aidlService.cancel(r2, r3);     // Catch: RemoteException -> L7
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void dispatchProcessCallback(int r2, int r3) {
        if (this.aidlService == null) goto L11;
        this.aidlService.dispatchProcessCallback(r2, r3);     // Catch: RemoteException -> L6
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public int getDownloadId(String r1, String r2) {
        return DownloadComponentManager.getDownloadId(r1, r2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public DownloadInfo getDownloadInfo(String r1, String r2) {
        return getDownloadInfo(getDownloadId(r1, r2));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public List<DownloadInfo> getDownloadInfosByFilters(String r2, String r3) {
        if (this.aidlService == null) goto L5;
        return this.aidlService.getDownloadInfosByFilters(r2, r3);
    L8:
        e = move-exception;
        e.printStackTrace();
        return null;
    L5:
        return this.downloadProxy.getDownloadInfosByFilters(r2, r3);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void pause(int r2, boolean r3) {
        if (this.aidlService != null) goto L10;
        return;
    L10:
        this.aidlService.pause(r2, r3);     // Catch: RemoteException -> L7
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void resetDownloadData(int r2, boolean r3) {
        if (this.aidlService != null) goto L10;
        this.downloadProxy.resetDownloadData(r2, r3);
        return;
    L10:
        this.aidlService.resetDownloadData(r2, r3);     // Catch: RemoteException -> L7
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void setDownloadNotificationEventListener(int r2, IDownloadNotificationEventListener r3) {
        if (this.aidlService == null) goto L11;
        this.aidlService.setDownloadNotificationEventListener(r2, IPCUtils.convertDownloadNotificationEventListenerToAidl(r3));     // Catch: RemoteException -> L6
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void setDownloadWithIndependentProcessStatus(int r2, boolean r3) {
        if (this.aidlService != null) goto L10;
        return;
    L10:
        this.aidlService.setDownloadWithIndependentProcessStatus(r2, r3);     // Catch: RemoteException -> L7
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void clearDownloadData(int r2, boolean r3, boolean r4) {
        if (this.aidlService != null) goto L10;
        this.downloadProxy.clearDownloadData(r2, r3, r4);
        return;
    L10:
        this.aidlService.clearDownloadData(r2, r3, r4);     // Catch: RemoteException -> L7
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void setThrottleNetSpeed(int r2, long r3, int r5) {
        if (this.aidlService != null) goto L10;
        return;
    L10:
        this.aidlService.setThrottleNetSpeed(r2, r3, r5);     // Catch: RemoteException -> L7
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void addDownloadListener(int r8, int r9, IDownloadListener r10, ListenerType r11, boolean r12) {
        if (this.aidlService != null) goto L14;
        return;
    L14:
        IDownloadAidlService r1 = this.aidlService;     // Catch: RemoteException -> L11
        if (r11 != ListenerType.SUB) goto L8;
        boolean r0 = false;
    L9:
        r1.addDownloadListener(r8, r9, IPCUtils.convertListenerToAidl(r10, r0), r11.ordinal(), r12);     // Catch: RemoteException -> L11
        return;
    L8:
        r0 = true;
    L11:
        e = move-exception;
        e.printStackTrace();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void removeDownloadListener(int r8, int r9, IDownloadListener r10, ListenerType r11, boolean r12) {
        if (this.aidlService != null) goto L14;
        return;
    L14:
        IDownloadAidlService r1 = this.aidlService;     // Catch: RemoteException -> L11
        if (r11 != ListenerType.SUB) goto L8;
        boolean r0 = false;
    L9:
        r1.removeDownloadListener(r8, r9, IPCUtils.convertListenerToAidl(r10, r0), r11.ordinal(), r12);     // Catch: RemoteException -> L11
        return;
    L8:
        r0 = true;
    L11:
        e = move-exception;
        e.printStackTrace();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void addDownloadListener(int r9, int r10, IDownloadListener r11, ListenerType r12, boolean r13, boolean r14) {
        if (this.aidlService != null) goto L14;
        return;
    L14:
        IDownloadAidlService r1 = this.aidlService;     // Catch: RemoteException -> L11
        if (r12 != ListenerType.SUB) goto L8;
        boolean r0 = false;
    L9:
        r1.addDownloadListener1(r9, r10, IPCUtils.convertListenerToAidl(r11, r0), r12.ordinal(), r13, r14);     // Catch: RemoteException -> L11
        return;
    L8:
        r0 = true;
    L11:
        e = move-exception;
        e.printStackTrace();
    }
}
