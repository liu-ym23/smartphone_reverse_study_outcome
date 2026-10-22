package com.ss.android.socialbase.downloader.downloader;

import android.content.Intent;
import android.util.Pair;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.cleaner.Cleaner;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.android.socialbase.downloader.constants.ListenerType;
import com.ss.android.socialbase.downloader.depend.IDownloadCacheSyncStatusListener;
import com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.depend.IDownloadMonitorDepend;
import com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventListener;
import com.ss.android.socialbase.downloader.depend.IDownloaderProcessConnectedListener;
import com.ss.android.socialbase.downloader.depend.INotificationClickCallback;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.impls.DownloadHandleService;
import com.ss.android.socialbase.downloader.impls.DownloadProxy;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.socialbase.downloader.monitor.DownloadMonitorHelper;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public class DownloadProcessDispatcher {
    private static volatile DownloadProcessDispatcher instance;
    private volatile SparseArray<Boolean> independentMap;
    private volatile List<IDownloaderProcessConnectedListener> processConnectedListeners;

    public List<DownloadInfo> getAllDownloadInfo() {
        IDownloadProxy r0 = DownloadProxy.get(false);
        List<DownloadInfo> r1 = null;
        if (r0 == null) goto L5;
        List<DownloadInfo> r2 = r0.getAllDownloadInfo();
    L7:
        if (DownloadUtils.optimizeMultiProcess() == true) goto L12;
        IDownloadProxy r3 = DownloadProxy.get(true);
        if (r3 == null) goto L12;
        r1 = r3.getAllDownloadInfo();
    L12:
        return handleDownloadInfos(r2, r1);
    L5:
        r2 = null;
        goto L7
    }

    public boolean isDownloadCacheSyncSuccess() {
        IDownloadProxy r1 = DownloadProxy.get(false);
        if (r1 != null) goto L5;
        return false;
    L5:
        return r1.isDownloadCacheSyncSuccess();
    }

    public void pauseAll() {
        IDownloadProxy r0 = DownloadProxy.get(false);
        if (r0 == null) goto L6;
        r0.pauseAll();
    L6:
        if (DownloadUtils.optimizeMultiProcess() == false) goto L8;
        return;
    L8:
        IDownloadProxy r1 = DownloadProxy.get(true);
        if (r1 == null) goto L12;
        r1.pauseAll();
        return;
    }

    public static DownloadProcessDispatcher getInstance() {
        if (instance != null) goto L13;
        monitor-enter(DownloadProcessDispatcher.class);
        instance = new DownloadProcessDispatcher();     // Catch: Throwable -> L9
        monitor-exit(DownloadProcessDispatcher.class);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    L13:
        return instance;
    }

    public void dispatchDownloaderProcessConnectedEvent() {
        List<IDownloaderProcessConnectedListener> r0 = this.processConnectedListeners;
        monitor-enter(r0);
        Iterator<IDownloaderProcessConnectedListener> r1 = this.processConnectedListeners.iterator();     // Catch: Throwable -> L12
    L6:
        if (r1.hasNext() == false) goto L10;
        IDownloaderProcessConnectedListener r2 = r1.next();     // Catch: Throwable -> L12
        if (r2 == null) goto L6;
        r2.onConnected();     // Catch: Throwable -> L12
        goto L6
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public DownloadProcessDispatcher() {
        this.independentMap = new SparseArray();
        this.processConnectedListeners = new ArrayList();
    }

    public boolean isHttpServiceInit() {
        return DownloadComponentManager.isHttpServiceInit();
    }

    private IDownloadProxy getDownloadHandler(DownloadTask r6) {
        if (r6 != null) goto L5;
        return null;
    L5:
        DownloadInfo r1 = r6.getDownloadInfo();
        if (r1 != null) goto L8;
        return null;
    L8:
        boolean r2 = false;
        if (r1.isFastDownload() == true) goto L45;
        if (r1.isNeedCurrentProcess() == true) goto L45;
        if (DownloadUtils.optimizeMultiProcess() == true) goto L45;
        boolean r0 = r1.isNeedIndependentProcess();
        if (DownloadHelper.isDownloaderProcess() == false) goto L18;
    L19:
        r0 = true;
    L20:
        int r3 = getDownloadWithIndependentProcessStatus(r1.getId());
        if (r3 < 0) goto L35;
        if (r3 == r0) goto L35;
        if (r3 != 1) goto L30;
        if (DownloadHelper.isMainProcess() == false) goto L46;
        DownloadProxy.get(true).pause(r1.getId(), true);     // Catch: Throwable -> L34
        DownloadInfo r7 = DownloadProxy.get(true).getDownloadInfo(r1.getId());     // Catch: Throwable -> L34
        if (r7 == null) goto L46;
        DownloadProxy.get(false).syncDownloadInfo(r7);     // Catch: Throwable -> L34
    L46:
        goto L35
    L30:
        if (DownloadHelper.isMainProcess() == false) goto L32;
        DownloadProxy.get(false).pause(r1.getId(), true);     // Catch: Throwable -> L34
        goto L46
    L32:
        r6.setNeedDelayForCacheSync(true);     // Catch: Throwable -> L34
        DownloadProxy.get(true).dispatchProcessCallback(1, r1.getId());     // Catch: Throwable -> L34
    L35:
        int r8 = r1.getId();
        if (r0 != true) goto L38;
        boolean r4 = true;
    L39:
        setDownloadWithIndependentProcessStatus(r8, r4);
        if (r0 != true) goto L43;
        r2 = true;
    L43:
        return DownloadProxy.get(r2);
    L38:
        r4 = false;
        goto L39
    L18:
        if (DownloadHelper.isMainProcess() == true) goto L20;
    L45:
        return DownloadProxy.get(false);
    }

    public boolean canResume(int r2) {
        IDownloadProxy r0 = getDownloadHandler(r2);
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.canResume(r2);
    }

    public long getCurBytes(int r3) {
        IDownloadProxy r0 = getDownloadHandler(r3);
        if (r0 != null) goto L5;
        return 0;
    L5:
        if (Cleaner.getInstance().isExistInCleanSet(r3) == false) goto L8;
        return 0;
    L8:
        return r0.getCurBytes(r3);
    }

    public IDownloadFileUriProvider getDownloadFileUriProvider(int r2) {
        IDownloadProxy r0 = getDownloadHandler(r2);
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getDownloadFileUriProvider(r2);
    }

    public DownloadInfo getDownloadInfo(int r4) {
        IDownloadProxy r0 = getDownloadHandler(r4);
        if (r0 != null) goto L6;
        return null;
    L6:
        if (Cleaner.getInstance().isExistInCleanSet(r4) == false) goto L9;
        return null;
    L9:
        return r0.getDownloadInfo(r4);
    }

    public List<DownloadInfo> getDownloadInfoList(String r5) {
        List<DownloadInfo> r0 = DownloadProxy.get(false).getDownloadInfoList(r5);
        if (DownloadUtils.optimizeMultiProcess() == true) goto L5;
        List<DownloadInfo> r6 = DownloadProxy.get(true).getDownloadInfoList(r5);
    L6:
        if (r0 != null) goto L9;
        if (r6 != null) goto L9;
        return null;
    L9:
        if (r0 == null) goto L16;
        Iterator<DownloadInfo> r1 = r0.iterator();
    L12:
        if (r1.hasNext() == false) goto L16;
        if (Cleaner.getInstance().isExistInCleanSet(r1.next().getId()) == false) goto L12;
        r1.remove();
    L16:
        if (r6 == null) goto L24;
        Iterator<DownloadInfo> r2 = r6.iterator();
    L19:
        if (r2.hasNext() == false) goto L24;
        if (Cleaner.getInstance().isExistInCleanSet(r2.next().getId()) == false) goto L19;
        r2.remove();
    L24:
        return handleDownloadInfos(r0, r6);
    L5:
        r6 = null;
        goto L6
    }

    public List<DownloadInfo> getDownloadInfosByFileExtension(String r4) {
        IDownloadProxy r0 = DownloadProxy.get(false);
        List<DownloadInfo> r1 = null;
        if (r0 == null) goto L5;
        List<DownloadInfo> r2 = r0.getDownloadInfosByFileExtension(r4);
    L7:
        if (DownloadUtils.optimizeMultiProcess() == true) goto L12;
        IDownloadProxy r3 = DownloadProxy.get(true);
        if (r3 == null) goto L12;
        r1 = r3.getDownloadInfosByFileExtension(r4);
    L12:
        return handleDownloadInfos(r2, r1);
    L5:
        r2 = null;
        goto L7
    }

    public List<DownloadInfo> getDownloadInfosByMonitorScene(List<String> r4) {
        IDownloadProxy r0 = DownloadProxy.get(false);
        List<DownloadInfo> r1 = null;
        if (r0 == null) goto L5;
        List<DownloadInfo> r2 = r0.getDownloadInfosByMonitorScene(r4);
    L7:
        if (DownloadUtils.optimizeMultiProcess() == true) goto L12;
        IDownloadProxy r3 = DownloadProxy.get(true);
        if (r3 == null) goto L12;
        r1 = r3.getDownloadInfosByMonitorScene(r4);
    L12:
        return handleDownloadInfos(r2, r1);
    L5:
        r2 = null;
        goto L7
    }

    public List<DownloadInfo> getDownloadInfosBySavePath(String r2) {
        IDownloadProxy r0 = DownloadProxy.get(false);
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getDownloadInfosBySavePath(r2);
    }

    public IDownloadNotificationEventListener getDownloadNotificationEventListener(int r2) {
        IDownloadProxy r0 = getDownloadHandler(r2);
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getDownloadNotificationEventListener(r2);
    }

    public int getDownloadWithIndependentProcessStatus(int r3) {
        if (DownloadComponentManager.supportMultiProc() == true) goto L5;
        return -1;
    L5:
        if (DownloadUtils.optimizeMultiProcess() == false) goto L8;
        return -1;
    L8:
        if (DownloadHelper.isDownloaderProcess() == true) goto L14;
        if (DownloadProxy.get(true).isServiceAlive() == false) goto L14;
        return DownloadProxy.get(true).getDownloadWithIndependentProcessStatus(r3);
    L14:
        return getDownloadWithIndependentProcessStatusInner(r3);
    }

    public synchronized int getDownloadWithIndependentProcessStatusInner(int r2) {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.independentMap.get(r2) != null) goto L8;
        monitor-exit(this);
        return -1;
    L8:
        boolean r3 = this.independentMap.get(r2).booleanValue();     // Catch: Throwable -> L11
        monitor-exit(this);
        return r3 ? 1 : 0;
    }

    public List<DownloadInfo> getDownloadingDownloadInfosWithMimeType(String r4) {
        IDownloadProxy r0 = DownloadProxy.get(false);
        List<DownloadInfo> r1 = null;
        if (r0 == null) goto L5;
        List<DownloadInfo> r2 = r0.getDownloadingDownloadInfosWithMimeType(r4);
    L7:
        if (DownloadUtils.optimizeMultiProcess() == true) goto L12;
        IDownloadProxy r3 = DownloadProxy.get(true);
        if (r3 == null) goto L12;
        r1 = r3.getDownloadingDownloadInfosWithMimeType(r4);
    L12:
        return handleDownloadInfos(r2, r1);
    L5:
        r2 = null;
        goto L7
    }

    public Map<String, Pair<Integer, Long>> getInstalledTimeStampBySavePath(String r2) {
        IDownloadProxy r0 = DownloadProxy.get(false);
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getInstalledTimeStampBySavePath(r2);
    }

    public INotificationClickCallback getNotificationClickCallback(int r2) {
        IDownloadProxy r0 = getDownloadHandler(r2);
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getNotificationClickCallback(r2);
    }

    public int getStatus(int r2) {
        IDownloadProxy r0 = getDownloadHandler(r2);
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.getStatus(r2);
    }

    public List<DownloadInfo> getSuccessedDownloadInfosWithMimeType(String r4) {
        IDownloadProxy r0 = DownloadProxy.get(false);
        List<DownloadInfo> r1 = null;
        if (r0 == null) goto L5;
        List<DownloadInfo> r2 = r0.getSuccessedDownloadInfosWithMimeType(r4);
    L7:
        if (DownloadUtils.optimizeMultiProcess() == true) goto L12;
        IDownloadProxy r3 = DownloadProxy.get(true);
        if (r3 == null) goto L12;
        r1 = r3.getSuccessedDownloadInfosWithMimeType(r4);
    L12:
        return handleDownloadInfos(r2, r1);
    L5:
        r2 = null;
        goto L7
    }

    public List<DownloadInfo> getUnCompletedDownloadInfosWithMimeType(String r4) {
        IDownloadProxy r0 = DownloadProxy.get(false);
        List<DownloadInfo> r1 = null;
        if (r0 == null) goto L5;
        List<DownloadInfo> r2 = r0.getUnCompletedDownloadInfosWithMimeType(r4);
    L7:
        if (DownloadUtils.optimizeMultiProcess() == true) goto L12;
        IDownloadProxy r3 = DownloadProxy.get(true);
        if (r3 == null) goto L12;
        r1 = r3.getUnCompletedDownloadInfosWithMimeType(r4);
    L12:
        return handleDownloadInfos(r2, r1);
    L5:
        r2 = null;
        goto L7
    }

    public boolean isDownloadSuccessAndFileNotExist(DownloadInfo r3) {
        if (r3 != null) goto L5;
        return false;
    L5:
        IDownloadProxy r1 = getDownloadHandler(r3.getId());
        if (r1 != null) goto L9;
        return false;
    L9:
        return r1.isDownloadSuccessAndFileNotExist(r3);
    }

    public boolean isDownloading(int r2) {
        IDownloadProxy r0 = getDownloadHandler(r2);
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.isDownloading(r2);
    }

    public void pause(int r3) {
        IDownloadProxy r0 = getDownloadHandler(r3);
        if (r0 != null) goto L5;
        return;
    L5:
        r0.pause(r3, false);
    }

    public void recordTaskProcessIndependent(int r2) {
        if (r2 != 0) goto L4;
        return;
    L4:
        setDownloadIndependentProcessStatus(r2, true);
        IDownloadProxy r3 = DownloadProxy.get(true);
        if (r3 != null) goto L7;
        return;
    L7:
        r3.startService();
    }

    public void registerDownloadCacheSyncListener(IDownloadCacheSyncStatusListener r1) {
        DownloadComponentManager.registerDownloadCacheSyncListener(r1);
    }

    public void registerDownloaderProcessConnectedListener(IDownloaderProcessConnectedListener r3) {
        if (r3 != null) goto L5;
        return;
    L5:
        if (DownloadHelper.isDownloaderProcess() == false) goto L9;
        r3.onConnected();
        return;
    L9:
        if (DownloadProxy.get(true).isServiceAlive() == false) goto L11;
        r3.onConnected();
    L11:
        List<IDownloaderProcessConnectedListener> r0 = this.processConnectedListeners;
        monitor-enter(r0);
    L18:
        th = move-exception;
        throw th;
    L14:
        if (this.processConnectedListeners.contains(r3) == true) goto L16;
        this.processConnectedListeners.add(r3);     // Catch: Throwable -> L18
    L16:
        monitor-exit(r0);     // Catch: Throwable -> L18
    }

    public void restart(int r2) {
        IDownloadProxy r0 = getDownloadHandler(r2);
        if (r0 != null) goto L5;
        return;
    L5:
        r0.restart(r2);
    }

    public void restartAllFailedDownloadTasks(List<String> r2) {
        IDownloadProxy r0 = DownloadProxy.get(false);
        if (r0 == null) goto L6;
        r0.restartAllFailedDownloadTasks(r2);
    L6:
        if (DownloadUtils.optimizeMultiProcess() == false) goto L8;
        return;
    L8:
        IDownloadProxy r1 = DownloadProxy.get(true);
        if (r1 == null) goto L12;
        r1.restartAllFailedDownloadTasks(r2);
        return;
    }

    public void restartAllPauseReserveOnWifiDownloadTasks(List<String> r2) {
        IDownloadProxy r0 = DownloadProxy.get(false);
        if (r0 == null) goto L6;
        r0.restartAllPauseReserveOnWifiDownloadTasks(r2);
    L6:
        if (DownloadUtils.optimizeMultiProcess() == false) goto L8;
        return;
    L8:
        IDownloadProxy r1 = DownloadProxy.get(true);
        if (r1 == null) goto L12;
        r1.restartAllPauseReserveOnWifiDownloadTasks(r2);
        return;
    }

    public void resume(int r2) {
        IDownloadProxy r0 = getDownloadHandler(r2);
        if (r0 != null) goto L5;
        return;
    L5:
        r0.resume(r2);
    }

    public void setLogLevel(int r2) {
        IDownloadProxy r0 = DownloadProxy.get(false);
        if (r0 == null) goto L6;
        r0.setLogLevel(r2);
    L6:
        if (DownloadUtils.optimizeMultiProcess() == false) goto L8;
        return;
    L8:
        IDownloadProxy r1 = DownloadProxy.get(true);
        if (r1 == null) goto L12;
        r1.setLogLevel(r2);
        return;
    }

    public void tryDownload(DownloadTask r6) {
        IDownloadProxy r0 = getDownloadHandler(r6);
        if (r0 != null) goto L11;
        if (r6 == null) goto L16;
        IDownloadMonitorDepend r1 = r6.getMonitorDepend();
        DownloadInfo r2 = r6.getDownloadInfo();
        BaseException r3 = new BaseException(1003, "tryDownload but getDownloadHandler failed");
        if (r6.getDownloadInfo() == null) goto L8;
        int r7 = r6.getDownloadInfo().getStatus();
    L9:
        DownloadMonitorHelper.monitorSendWithTaskMonitor(r1, r2, r3, r7);
        return;
    L8:
        r7 = 0;
        goto L9
    L16:
        return;
    L11:
        Cleaner.getInstance().removeFromCleanSet(r6.getDownloadId());
        if (r6.isNeedDelayForCacheSync() == false) goto L14;
        DownloadComponentManager.submitScheduleTask(new 1(this, r0, r6), 500, TimeUnit.MILLISECONDS);
        return;
    L14:
        r0.tryDownload(r6);
    }

    public void unRegisterDownloadCacheSyncListener(IDownloadCacheSyncStatusListener r1) {
        DownloadComponentManager.unRegisterDownloadCacheSyncListener(r1);
    }

    public void unRegisterDownloaderProcessConnectedListener(IDownloaderProcessConnectedListener r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        List<IDownloaderProcessConnectedListener> r0 = this.processConnectedListeners;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (this.processConnectedListeners.contains(r3) == false) goto L9;
        this.processConnectedListeners.remove(r3);     // Catch: Throwable -> L11
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L11
    }

    public IDownloadProxy getDownloadHandler(int r2) {
        boolean r0 = true;
        if (getDownloadWithIndependentProcessStatus(r2) == 1) goto L5;
    L7:
        r0 = false;
    L9:
        return DownloadProxy.get(r0);
    L5:
        if (DownloadHelper.isDownloaderProcess() == true) goto L7;
        goto L7
    }

    private List<DownloadInfo> handleDownloadInfos(List<DownloadInfo> r5, List<DownloadInfo> r6) {
        SparseArray r0 = new SparseArray();
        ArrayList r1 = new ArrayList();
        if (r5 == null) goto L12;
        Iterator<DownloadInfo> r7 = r5.iterator();
    L6:
        if (r7.hasNext() == false) goto L12;
        DownloadInfo r2 = r7.next();
        if (r2 == null) goto L6;
        if (r0.get(r2.getId()) != null) goto L6;
        r0.put(r2.getId(), r2);
    L12:
        if (r6 == null) goto L21;
        Iterator<DownloadInfo> r8 = r6.iterator();
    L15:
        if (r8.hasNext() == false) goto L21;
        DownloadInfo r9 = r8.next();
        if (r9 == null) goto L15;
        if (r0.get(r9.getId()) != null) goto L15;
        r0.put(r9.getId(), r9);
    L21:
        int r10 = 0;
    L23:
        if (r10 >= r0.size()) goto L28;
        DownloadInfo r11 = (DownloadInfo) r0.get(r0.keyAt(r10));
        if (Cleaner.getInstance().isExistInCleanSet(r11.getId()) == true) goto L27;
        r1.add(r11);
    L27:
        r10 = r10 + 1;
        goto L23
    L28:
        return r1;
    }

    public void cancel(int r3, boolean r4) {
        if (DownloadHelper.isMainProcess() == true) goto L5;
        IDownloadProxy r0 = getDownloadHandler(r3);
        if (r0 == null) goto L15;
        r0.cancel(r3, r4);
    L15:
        DownloadProxy.get(true).dispatchProcessCallback(2, r3);
        return;
    L5:
        if (DownloadUtils.optimizeMultiProcess() == true) goto L9;
        IDownloadProxy r1 = DownloadProxy.get(true);
        if (r1 == null) goto L9;
        r1.cancel(r3, r4);
    L9:
        IDownloadProxy r2 = DownloadProxy.get(false);
        if (r2 == null) goto L17;
        r2.cancel(r3, r4);
        return;
    }

    public void clearDownloadData(int r3, boolean r4) {
        IDownloadProxy r0 = getDownloadHandler(r3);
        if (r0 != null) goto L5;
        return;
    L5:
        r0.clearDownloadData(r3, r4, true);
    }

    public int getDownloadId(String r1, String r2) {
        return DownloadComponentManager.getDownloadId(r1, r2);
    }

    public DownloadInfo getDownloadInfo(String r2, String r3) {
        int r4 = getDownloadId(r2, r3);
        if (Cleaner.getInstance().isExistInCleanSet(r4) == false) goto L5;
        return null;
    L5:
        IDownloadProxy r5 = getDownloadHandler(r4);
        if (r5 != null) goto L9;
        return null;
    L9:
        return r5.getDownloadInfo(r4);
    }

    public List<DownloadInfo> getDownloadInfosByFilters(String r4, String r5) {
        IDownloadProxy r0 = DownloadProxy.get(false);
        List<DownloadInfo> r1 = null;
        if (r0 == null) goto L5;
        List<DownloadInfo> r2 = r0.getDownloadInfosByFilters(r4, r5);
    L7:
        if (DownloadUtils.optimizeMultiProcess() == true) goto L12;
        IDownloadProxy r3 = DownloadProxy.get(true);
        if (r3 == null) goto L12;
        r1 = r3.getDownloadInfosByFilters(r4, r5);
    L12:
        return handleDownloadInfos(r2, r1);
    L5:
        r2 = null;
        goto L7
    }

    public synchronized void setDownloadIndependentProcessStatus(int r2, boolean r3) {
        monitor-enter(this);
        SparseArray<Boolean> r0 = this.independentMap;     // Catch: Throwable -> L10
        if (r3 == false) goto L6;
        Boolean r4 = Boolean.TRUE;     // Catch: Throwable -> L10
    L7:
        r0.put(r2, r4);     // Catch: Throwable -> L10
        monitor-exit(this);
        return;
    L6:
        r4 = Boolean.FALSE;     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public void setDownloadNotificationEventListener(int r2, IDownloadNotificationEventListener r3) {
        IDownloadProxy r0 = getDownloadHandler(r2);
        if (r0 != null) goto L5;
        return;
    L5:
        r0.setDownloadNotificationEventListener(r2, r3);
    }

    public void setDownloadWithIndependentProcessStatus(int r3, boolean r4) {
        if (DownloadUtils.optimizeMultiProcess() == false) goto L5;
        return;
    L5:
        setDownloadIndependentProcessStatus(r3, r4);
        if (DownloadComponentManager.supportMultiProc() == false) goto L13;
        if (DownloadHelper.isDownloaderProcess() == true) goto L13;
        if (DownloadProxy.get(true).isServiceAlive() == false) goto L13;
        DownloadProxy.get(true).setDownloadWithIndependentProcessStatus(r3, r4);
    L13:
        if (DownloadComponentManager.isDownloadInMultiProcess() == false) goto L15;
        return;
    L15:
        if (DownloadHelper.isDownloaderProcess() == false) goto L17;
        return;
    L17:
        if (DownloadHelper.isMainProcess() == true) goto L27;
        Intent r5 = new Intent(DownloadComponentManager.getAppContext(), DownloadHandleService.class);     // Catch: Throwable -> L20
        r5.setAction(DownloadConstants.ACTION_DOWNLOAD_PROCESS_NOTIFY);     // Catch: Throwable -> L20
        r5.putExtra("extra_download_id", r3);     // Catch: Throwable -> L20
        DownloadComponentManager.getAppContext().startService(r5);     // Catch: Throwable -> L20
        return;
    L20:
        th = move-exception;
        th.printStackTrace();
        return;
    }

    public void setThrottleNetSpeed(int r2, long r3, int r5) {
        IDownloadProxy r0 = getDownloadHandler(r2);
        if (r0 != null) goto L5;
        return;
    L5:
        r0.setThrottleNetSpeed(r2, r3, r5);
    }

    public void addDownloadListener(int r7, IDownloadListener r8, ListenerType r9, boolean r10) {
        IDownloadProxy r0 = getDownloadHandler(r7);
        if (r0 != null) goto L5;
        return;
    L5:
        r0.addDownloadListener(r7, r8.hashCode(), r8, r9, r10);
    }

    public void removeDownloadListener(int r7, IDownloadListener r8, ListenerType r9, boolean r10) {
        IDownloadProxy r0 = getDownloadHandler(r7);
        if (r0 != null) goto L5;
        return;
    L5:
        if (r8 != null) goto L7;
        int r2 = 0;
    L8:
        r0.removeDownloadListener(r7, r2, r8, r9, r10);
        return;
    L7:
        r2 = r8.hashCode();
        goto L8
    }

    public void addDownloadListener(int r8, IDownloadListener r9, ListenerType r10, boolean r11, boolean r12) {
        IDownloadProxy r0 = getDownloadHandler(r8);
        if (r0 != null) goto L5;
        return;
    L5:
        r0.addDownloadListener(r8, r9.hashCode(), r9, r10, r11, r12);
    }
}
