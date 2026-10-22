package com.ss.android.socialbase.downloader.thread;

import com.ss.android.socialbase.downloader.core.DownloadRunnable;
import com.ss.android.socialbase.downloader.depend.IDownloadMonitorDepend;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.impls.PluginDownloadEngine;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.socialbase.downloader.monitor.DownloadMonitorHelper;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public class DownloadThreadPool {
    private static String TAG = "DownloadThreadPool";
    private AtomicInteger clearTimes;
    private Map<Integer, DownloadRunnable> downloadRunnablePool;

    private void clearRunnableNotAlive() {
        Iterator<Map.Entry<Integer, DownloadRunnable>> r0 = this.downloadRunnablePool.entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        if (r0.next().getValue().isAlive() == true) goto L4;
        r0.remove();
        goto L4
    }

    public DownloadThreadPool() {
        this.downloadRunnablePool = new ConcurrentHashMap();
        this.clearTimes = new AtomicInteger(0);
    }

    public List<Integer> getAllAliveDownloadIds() {
        clearRunnableNotAlive();
        return new ArrayList(this.downloadRunnablePool.keySet());
    }

    private ExecutorService getDownloadExecutorService(DownloadRunnable r5) {
        ExecutorService r0 = null;
        DownloadInfo r1 = r5.getDownloadTask().getDownloadInfo();     // Catch: Throwable -> L30 Exception -> L32
        if (r5.isPluginThreadPool() == false) goto L9;
        ExecutorService r6 = PluginDownloadEngine.getInstance().getPluginExecutor(r1.getEnqueueType());     // Catch: Throwable -> L30 Exception -> L32
        DownloadComponentManager.getMixDefaultThreadExecutor();
        return r6;
    L9:
        if (r1.isFastDownload() == true) goto L11;
    L13:
        if (r0 != null) goto L24;
        int r2 = r1.getExecutorGroup();     // Catch: Throwable -> L30 Exception -> L32
        if (r2 != 3) goto L17;
        r0 = DownloadComponentManager.getMixFrequentThreadExecutor();     // Catch: Throwable -> L30 Exception -> L32
        goto L24
    L17:
        if (r2 != 4) goto L19;
        r0 = DownloadComponentManager.getMixApkThreadExecutor();     // Catch: Throwable -> L30 Exception -> L32
        goto L24
    L19:
        if (r2 != 7) goto L24;
        r0 = DownloadComponentManager.getCustomThreadExecutor();     // Catch: Throwable -> L30 Exception -> L32
    L24:
        if (r0 == null) goto L26;
    L28:
        if (r0 == null) goto L36;
        return r0;
    L36:
        return DownloadComponentManager.getMixDefaultThreadExecutor();
    L26:
        if (canUseSegmentThreadPool(r1, r5) == false) goto L28;
        r0 = DownloadComponentManager.getSegmentDownloadThreadExecutorService();     // Catch: Throwable -> L30 Exception -> L32
        goto L28
    L11:
        if (r1.isFastDownloadCommonThreadPool() == true) goto L13;
        r0 = DownloadComponentManager.getFastThreadExecutor();     // Catch: Throwable -> L30 Exception -> L32
    L32:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L30
        if (0 == 0) goto L36;
        return null;
    L30:
        th = move-exception;
        if (0 != 0) goto L39;
        DownloadComponentManager.getMixDefaultThreadExecutor();
    L39:
        throw th;
    }

    private void removeFromThreadPool(DownloadRunnable r3) {
        if (r3 != null) goto L13;
        return;
    L13:
        ExecutorService r0 = getDownloadExecutorService(r3);     // Catch: Exception -> L10
        if ((r0 instanceof ThreadPoolExecutor) == false) goto L15;
        ((ThreadPoolExecutor) r0).remove(r3);     // Catch: Exception -> L10
        Future r4 = r3.getFuture();     // Catch: Exception -> L10
        if (r4 == null) goto L16;
        r4.cancel(true);     // Catch: Exception -> L10
        return;
    L16:
        return;
    L15:
        return;
    L10:
        e = move-exception;
        e.printStackTrace();
    }

    public DownloadRunnable cancel(int r2) {
        clearRunnableNotAlive();
        DownloadRunnable r3 = this.downloadRunnablePool.remove(Integer.valueOf(r2));
        if (r3 == null) goto L5;
        r3.cancel();
        removeFromThreadPool(r3);
    L5:
        return r3;
    }

    public boolean containsTask(int r2) {
        DownloadRunnable r3 = this.downloadRunnablePool.get(Integer.valueOf(r2));
        if (r3 != null) goto L5;
    L7:
        return false;
    L5:
        if (r3.isAlive() == false) goto L7;
        return true;
    }

    public void removeUnAliveDownloadRunnable(DownloadRunnable r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        Iterator<Map.Entry<Integer, DownloadRunnable>> r0 = this.downloadRunnablePool.entrySet().iterator();
    L6:
        if (r0.hasNext() == false) goto L14;
        if (r0.next().getValue() != r3) goto L6;
        r0.remove();
        return;
    }

    private boolean canUseSegmentThreadPool(DownloadInfo r7, DownloadRunnable r8) {
        long r3 = 0;
        if (r7.getExpectFileLength() > 0) goto L5;
        return false;
    L5:
        JSONObject r0 = DownloadSetting.obtain(r7.getId()).optJSONObject("segment_config");
        if (r0 == null) goto L9;
        r3 = r0.optLong("expect_min_download_size");
    L9:
        if (r3 >= 104857600) goto L12;
        return false;
    L12:
        if (r7.getExpectFileLength() <= r3) goto L15;
        return true;
    L15:
        r8.setEnableSegmentDownload(false);
        return false;
    }

    public Future execute(DownloadRunnable r8, boolean r9) {
        r8.prepareDownload();
        r8.setIsPluginThreadPool(r9);
        int r3 = 0;
        if (this.clearTimes.compareAndSet(500, 0) == false) goto L5;
        clearRunnableNotAlive();
    L5:
        this.clearTimes.incrementAndGet();
        this.downloadRunnablePool.put(Integer.valueOf(r8.getDownloadId()), r8);
        DownloadTask r10 = r8.getDownloadTask();
        r10.getTimingInfo().beforeThreadExecuteTime = System.currentTimeMillis();     // Catch: Exception -> L11
        ExecutorService r2 = getDownloadExecutorService(r8);     // Catch: Exception -> L11
        if (Logger.debugScene(r8.getDownloadInfo()) == false) goto L9;
        Logger.taskDebug(TAG, r8.getDownloadInfo(), "execute", "Executor:" + r2);     // Catch: Exception -> L11
    L9:
        Future<?> r1 = r2.submit(r8);     // Catch: Exception -> L11
        r8.setFuture(r1);     // Catch: Exception -> L11
        return r1;
    L11:
        e = move-exception;
        Logger.taskError(TAG, r8.getDownloadId(), "execute", "Error:" + e);
        if (r10 == null) goto L18;
        IDownloadMonitorDepend r11 = r10.getMonitorDepend();
        DownloadInfo r0 = r10.getDownloadInfo();
        BaseException r4 = new BaseException(1003, DownloadUtils.getErrorMsgWithTagPrefix(e, "DownloadThreadPoolExecute"));
        if (r10.getDownloadInfo() == null) goto L17;
        r3 = r10.getDownloadInfo().getStatus();
    L17:
        DownloadMonitorHelper.monitorSendWithTaskMonitor(r11, r0, r4, r3);
    L18:
        e.printStackTrace();
        return null;
    }

    public void pause(int r2, boolean r3) {
        clearRunnableNotAlive();
        DownloadRunnable r4 = this.downloadRunnablePool.remove(Integer.valueOf(r2));
        if (r4 == null) goto L8;
        r4.pause();
        if (r3 == false) goto L9;
        removeFromThreadPool(r4);
        return;
    L9:
        return;
    }

    public void setThrottleNetSpeed(int r2, long r3, int r5) {
        DownloadRunnable r4 = this.downloadRunnablePool.get(Integer.valueOf(r2));
        if (r4 == null) goto L6;
        r4.setThrottleNetSpeed(r3, r5);
        return;
    }
}
