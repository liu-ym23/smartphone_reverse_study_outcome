package com.ss.android.socialbase.downloader.impls;

import android.util.Pair;
import com.ss.android.socialbase.downloader.constants.ListenerType;
import com.ss.android.socialbase.downloader.db.SqlDownloadCache;
import com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventListener;
import com.ss.android.socialbase.downloader.depend.INotificationClickCallback;
import com.ss.android.socialbase.downloader.depend.ProcessCallback;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.DownloadProcessDispatcher;
import com.ss.android.socialbase.downloader.downloader.IDownloadCache;
import com.ss.android.socialbase.downloader.downloader.IDownloadProxy;
import com.ss.android.socialbase.downloader.downloader.IDownloadServiceHandler;
import com.ss.android.socialbase.downloader.downloader.ISqlDownloadCache;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public class ProcessDownloadHandler implements IDownloadProxy {
    private static final String TAG = "ProcessDownloadHandler";
    private final IDownloadCache downloadCache;
    private final AbsDownloadEngine downloadEngine;
    private final IDownloadServiceHandler downloadServiceHandler;
    private final boolean enableSingleThread;

    public ProcessDownloadHandler() {
        this(false);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void startService() {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void clearData() {
        this.downloadCache.clearData();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public List<DownloadInfo> getAllDownloadInfo() {
        IDownloadCache r0 = this.downloadCache;
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.getAllDownloadInfo();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public boolean isDownloadCacheSyncSuccess() {
        return this.downloadCache.isDownloadCacheSyncSuccess();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public boolean isServiceAlive() {
        IDownloadServiceHandler r0 = this.downloadServiceHandler;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.isServiceAlive() == false) goto L7;
        return true;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void pauseAll() {
        runInSingleThread(new 5(this));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public boolean isHttpServiceInit() {
        return DownloadComponentManager.isHttpServiceInit();
    }

    public ProcessDownloadHandler(boolean r2) {
        this.downloadEngine = DownloadComponentManager.getDownloadEngine();
        this.downloadCache = DownloadComponentManager.getDownloadCache();
        if (r2 == true) goto L5;
        this.downloadServiceHandler = DownloadComponentManager.getDownloadServiceHandler();
    L7:
        if (DownloadSetting.obtainGlobal().optInt("single_async_handle_operation") <= 0) goto L9;
        boolean r3 = true;
    L10:
        this.enableSingleThread = r3;
        return;
    L9:
        r3 = false;
        goto L10
    L5:
        this.downloadServiceHandler = DownloadComponentManager.getIndependentDownloadServiceHandler();
        goto L7
    }

    public static /* synthetic */ AbsDownloadEngine access$000(ProcessDownloadHandler r0) {
        return r0.downloadEngine;
    }

    public static /* synthetic */ IDownloadServiceHandler access$100(ProcessDownloadHandler r0) {
        return r0.downloadServiceHandler;
    }

    private void runInSingleThread(Runnable r2) {
        if (this.enableSingleThread == false) goto L5;
        DownloadComponentManager.submitSingleTask(r2);
        return;
    L5:
        r2.run();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void addProcessCallback(ProcessCallback r1) {
        DownloadComponentManager.addProcessCallback(r1);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public boolean canResume(int r2) {
        AbsDownloadEngine r0 = this.downloadEngine;
        if (r0 != null) goto L5;
        return false;
    L5:
        return r0.isInDownloadTaskPool(r2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public long getCurBytes(int r4) {
        IDownloadCache r0 = this.downloadCache;
        if (r0 != null) goto L5;
        return 0;
    L5:
        DownloadInfo r5 = r0.getDownloadInfo(r4);
        if (r5 != null) goto L9;
        return 0;
    L9:
        return r5.getCurBytes();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public IDownloadFileUriProvider getDownloadFileUriProvider(int r2) {
        return this.downloadEngine.getDownloadFileUriProvider(r2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public DownloadInfo getDownloadInfo(int r2) {
        return this.downloadEngine.getDownloadInfo(r2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public List<DownloadInfo> getDownloadInfoList(String r2) {
        return this.downloadEngine.getDownloadInfoList(r2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public List<DownloadInfo> getDownloadInfosByFileExtension(String r2) {
        return this.downloadCache.getDownloadInfosByFileExtension(r2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public List<DownloadInfo> getDownloadInfosByMonitorScene(List<String> r2) {
        return this.downloadCache.getDownloadInfosByMonitorScene(r2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public List<DownloadInfo> getDownloadInfosBySavePath(String r4) {
        IDownloadCache r0 = this.downloadCache;
        if (r0 != null) goto L5;
    L14:
        return null;
    L5:
        if ((r0 instanceof DefaultDownloadCache) == false) goto L14;
        ISqlDownloadCache r1 = ((DefaultDownloadCache) r0).getSqlDownloadCache();
        if (r1 == null) goto L14;
        if ((r1 instanceof SqlDownloadCache) == false) goto L14;
        return ((SqlDownloadCache) r1).getDownloadInfosBySavePath(r4);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public IDownloadNotificationEventListener getDownloadNotificationEventListener(int r2) {
        return this.downloadEngine.getDownloadNotificationEventListener(r2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public int getDownloadWithIndependentProcessStatus(int r2) {
        return DownloadProcessDispatcher.getInstance().getDownloadWithIndependentProcessStatus(r2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public List<DownloadInfo> getDownloadingDownloadInfosWithMimeType(String r2) {
        return this.downloadEngine.getDownloadingDownloadInfosWithMimeType(r2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public Map<String, Pair<Integer, Long>> getInstalledTimeStampBySavePath(String r4) {
        IDownloadCache r0 = this.downloadCache;
        if (r0 != null) goto L5;
    L14:
        return null;
    L5:
        if ((r0 instanceof DefaultDownloadCache) == false) goto L14;
        ISqlDownloadCache r1 = ((DefaultDownloadCache) r0).getSqlDownloadCache();
        if (r1 == null) goto L14;
        if ((r1 instanceof SqlDownloadCache) == false) goto L14;
        return ((SqlDownloadCache) r1).getInstalledTimeStampBySavePath(r4);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public INotificationClickCallback getNotificationClickCallback(int r2) {
        INotificationClickCallback r3 = this.downloadEngine.getNotificationClickCallback(r2);
        if (r3 == null) goto L5;
        return r3;
    L5:
        return DownloadComponentManager.getNotificationClickCallback();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public int getStatus(int r2) {
        DownloadInfo r3 = this.downloadEngine.getDownloadInfo(r2);
        if (r3 != null) goto L7;
        return 0;
    L7:
        return r3.getStatus();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public List<DownloadInfo> getSuccessedDownloadInfosWithMimeType(String r2) {
        return this.downloadCache.getSuccessedDownloadInfosWithMimeType(r2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public List<DownloadInfo> getUnCompletedDownloadInfosWithMimeType(String r2) {
        return this.downloadCache.getUnCompletedDownloadInfosWithMimeType(r2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public boolean isDownloadSuccessAndFileNotExist(DownloadInfo r4) {
        if (r4 != null) goto L5;
        return false;
    L5:
        boolean r0 = DownloadUtils.isDownloadSuccessAndFileNotExist(r4.getStatus(), r4.getSavePath(), r4.getName());
        if (r0 == false) goto L8;
        resetDownloadData(r4.getId(), true);
    L8:
        return r0;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public boolean isDownloading(int r2) {
        return this.downloadEngine.isDownloading(r2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public boolean removeDownloadInfo(int r2) {
        return this.downloadCache.removeDownloadInfo(r2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public boolean removeDownloadTaskData(int r2) {
        return this.downloadCache.removeDownloadTaskData(r2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void restart(int r2) {
        runInSingleThread(new 4(this, r2));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void restartAllFailedDownloadTasks(List<String> r2) {
        runInSingleThread(new 6(this, r2));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void restartAllPauseReserveOnWifiDownloadTasks(List<String> r2) {
        runInSingleThread(new 7(this, r2));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void resume(int r2) {
        runInSingleThread(new 3(this, r2));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void setLogLevel(int r1) {
        Logger.setLogLevel(r1);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void syncDownloadInfo(DownloadInfo r2) {
        this.downloadCache.syncDownloadInfo(r2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void syncDownloadInfoFromOtherCache(int r2) {
        this.downloadCache.syncDownloadInfoFromOtherCache(r2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void tryDownload(DownloadTask r2) {
        DownloadComponentManager.updateCurrentDownloadThreadInfo(r2, true);
        runInSingleThread(new 10(this, r2));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void tryDownloadWithEngine(DownloadTask r2) {
        DownloadComponentManager.updateCurrentDownloadThreadInfo(r2, true);
        runInSingleThread(new 11(this, r2));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public boolean updateDownloadInfo(DownloadInfo r2) {
        return this.downloadCache.updateDownloadInfo(r2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void cancel(int r2, boolean r3) {
        runInSingleThread(new 2(this, r2, r3));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void dispatchProcessCallback(int r3, int r4) {
        if (DownloadComponentManager.getProcessCallbacks() == null) goto L10;
        Iterator<ProcessCallback> r0 = DownloadComponentManager.getProcessCallbacks().iterator();
    L6:
        if (r0.hasNext() == false) goto L16;
        ProcessCallback r1 = r0.next();
        if (r1 == null) goto L6;
        r1.callback(r4, r3);
        goto L6
    L16:
        return;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public int getDownloadId(String r1, String r2) {
        return DownloadComponentManager.getDownloadId(r1, r2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public DownloadInfo getDownloadInfo(String r1, String r2) {
        return getDownloadInfo(DownloadComponentManager.getDownloadId(r1, r2));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public List<DownloadInfo> getDownloadInfosByFilters(String r2, String r3) {
        IDownloadCache r0 = this.downloadCache;
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.getDownloadInfosByFilters(r2, r3);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void pause(int r2, boolean r3) {
        1 r0 = new 1(this, r2);
        if (r3 == false) goto L5;
        r0.run();
        return;
    L5:
        runInSingleThread(r0);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void resetDownloadData(int r2, boolean r3) {
        runInSingleThread(new 9(this, r2, r3));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void setDownloadNotificationEventListener(int r2, IDownloadNotificationEventListener r3) {
        this.downloadEngine.setDownloadNotificationEventListener(r2, r3);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void setDownloadWithIndependentProcessStatus(int r2, boolean r3) {
        DownloadProcessDispatcher.getInstance().setDownloadWithIndependentProcessStatus(r2, r3);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void clearDownloadData(int r2, boolean r3, boolean r4) {
        runInSingleThread(new 8(this, r2, r3, r4));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void setThrottleNetSpeed(int r8, long r9, int r11) {
        runInSingleThread(new 12(this, r8, r9, r11));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void addDownloadListener(int r7, int r8, IDownloadListener r9, ListenerType r10, boolean r11) {
        this.downloadEngine.addDownloadListener(r7, r8, r9, r10, r11);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void removeDownloadListener(int r7, int r8, IDownloadListener r9, ListenerType r10, boolean r11) {
        this.downloadEngine.removeDownloadListener(r7, r8, r9, r10, r11);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void addDownloadListener(int r8, int r9, IDownloadListener r10, ListenerType r11, boolean r12, boolean r13) {
        this.downloadEngine.addDownloadListener(r8, r9, r10, r11, r12, r13);
    }
}
