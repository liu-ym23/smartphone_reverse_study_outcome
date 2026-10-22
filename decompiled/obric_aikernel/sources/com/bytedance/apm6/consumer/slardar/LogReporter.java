package com.bytedance.apm6.consumer.slardar;

import androidx.work.WorkRequest;
import com.bytedance.apm6.consumer.slardar.persistent.LogFile;
import com.bytedance.apm6.consumer.slardar.persistent.PersistentBuffer;
import com.bytedance.apm6.consumer.slardar.send.LogSender;
import com.bytedance.apm6.consumer.slardar.weedout.WeedOutStrategy;
import com.bytedance.apm6.foundation.context.ApmContext;
import com.bytedance.apm6.util.ApmBaseContext;
import com.bytedance.apm6.util.FileUtils;
import com.bytedance.apm6.util.IOUtils;
import com.bytedance.apm6.util.cache.LimitedQueue;
import com.bytedance.apm6.util.log.Logger;
import com.bytedance.apm6.util.timetask.AsyncTask;
import com.bytedance.apm6.util.timetask.AsyncTaskManager;
import com.bytedance.apm6.util.timetask.AsyncTaskManagerType;
import java.io.File;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import s1.a;

/* JADX INFO: loaded from: classes.dex */
public class LogReporter implements WeedOutStrategy {
    private static final long LOOP_INTERVAL = 60000;
    private static final long MAX_BODY_BYTES = 1048576;
    private static final String TYPE_WEED_OUT = "first_log_dir";
    private volatile AsyncTask asyncTask;
    private volatile long interval;
    private volatile boolean isPaused;
    private LimitedQueue<LogFile> limitedQueue;
    private volatile long onceReportMaxSizeBytes;
    private volatile PersistentBuffer persistentBuffer;

    private static class InnerHolder {
        private static final LogReporter instance = null;

        static {
            instance = new LogReporter();
        }

        private InnerHolder() {
        }

        static /* synthetic */ LogReporter access$000() {
            return instance;
        }
    }

    public LogReporter() {
        this.interval = 60000;
        this.onceReportMaxSizeBytes = 1048576;
        this.limitedQueue = new LimitedQueue(10);
        this.isPaused = false;
    }

    static /* synthetic */ void access$100(LogReporter r10) {
        r10.report();
    }

    static /* synthetic */ void access$200(LogReporter r10) {
        r10.moveInactiveSubProcessData();
    }

    static /* synthetic */ PersistentBuffer access$300(LogReporter r10) {
        return r10.persistentBuffer;
    }

    private void flushBuffer() {
    L6:
        th = move-exception;
        Logger.e(Constants.TAG, "flushBuffer", th);
        return;
    L3:
        if (this.persistentBuffer == null) goto L11;
        this.persistentBuffer.flush();     // Catch: Throwable -> L6
        return;
    }

    private long getCreateTime(File r10) {
        String r11 = r10.getName();
        int r12 = r11.indexOf("_");
        if (r12 != (-1)) goto L9;
        return -1;
    L9:
        return Long.parseLong(r11.substring(0, r12));
    L8:
        return -1;
    }

    public static LogReporter getInstance() {
        return InnerHolder.access$000();
    }

    private void moveInactiveSubProcessData() {
        File r13 = DiskEnvironmentHelper.getSubProcessPersistentDirectory();
        if (r13.exists() == true) goto L5;
        return;
    L5:
        File[] r14 = r13.listFiles();
        if (r14 != null) goto L8;
        return;
    L8:
        int r10 = r14.length;
        int r11 = 0;
    L9:
        if (r11 >= r10) goto L42;
        File r12 = r14[r11];
        if (r12 == null) goto L41;
        if (r12.exists() == false) goto L41;
        if (r12.length() <= 0) goto L41;
        if (Long.parseLong(r12.getName().split("_")[0]) >= ApmContext.getInitTimeStamp()) goto L41;
        FileChannel r15 = null;
        r15 = new RandomAccessFile(r12, "rw").getChannel();     // Catch: Throwable -> L33
        FileLock r16 = r15.tryLock(0, Long.MAX_VALUE, false);     // Catch: Throwable -> L33
        if (r16 == null) goto L30;
        if (r16.isValid() == false) goto L30;
        File r17 = new File(DiskEnvironmentHelper.getFlushDirectory(), DiskEnvironmentHelper.generateFlushFileName());     // Catch: Throwable -> L33
        boolean r18 = a.c(r12.getAbsolutePath(), r17.getAbsolutePath());     // Catch: Throwable -> L33
        if (ApmBaseContext.isDebugMode() == false) goto L28;
        Logger.d(Constants.TAG, "moveInactiveSubProcessData: src:" + r12.getAbsolutePath() + " dst:" + r17.getAbsolutePath() + " isSuccess:" + r18);     // Catch: Throwable -> L33
    L28:
        r16.release();     // Catch: Throwable -> L33
    L37:
        IOUtils.closeQuietly(r15);
    L30:
        if (ApmBaseContext.isDebugMode() == false) goto L37;
        Logger.d(Constants.TAG, "moveInactiveSubProcessData isValid is not true ");     // Catch: Throwable -> L33
    L33:
        th = move-exception;
    L38:
        th = move-exception;
        IOUtils.closeQuietly(r15);
        throw th;
    L35:
        if (ApmBaseContext.isDebugMode() == false) goto L37;
        Logger.w(Constants.TAG, "moveInactiveSubProcessData failed.", th);     // Catch: Throwable -> L38
    L41:
        r11 = r11 + 1;
        goto L9
    }

    private void report() {
        long r10 = System.currentTimeMillis();
        flushBuffer();
        reportMemory();
        if (ApmContext.isMainProcess() == false) goto L8;
        if (this.isPaused == true) goto L8;
        reportFile();
    L8:
        if (ApmBaseContext.isDebugMode() == false) goto L11;
        Logger.d(Constants.TAG, "LogReporter One Loop Cost:" + (System.currentTimeMillis() - r10));
        return;
    }

    private void reportFile() {
        if (this.persistentBuffer == null) goto L5;
        String[] r10 = this.persistentBuffer.list();
    L6:
        if (r10 != null) goto L8;
        return;
    L8:
        if (r10.length == 0) goto L48;
        List r11 = Arrays.asList(r10);
        Collections.sort(r11, new AnonymousClass6(this));
        if (ApmBaseContext.isDebugMode() == false) goto L13;
        Logger.d(Constants.TAG, "reportFile: parsing " + r11.size() + " files. fileNameList" + r11);
    L13:
        ArrayList r12 = new ArrayList();
        int r13 = 0;
        int r14 = 0;
    L15:
        if (r13 >= r11.size()) goto L38;
        File r15 = new File(DiskEnvironmentHelper.getFlushDirectory(), (String) r11.get(r13));
        if (r15.exists() == false) goto L36;
        LogFile r16 = LogFile.fromFile(r15);
        if (r16 == null) goto L22;
        int r17 = r16.getTotalBytes();
        if (r14 != 0) goto L28;
    L35:
        r14 = r14 + r17;
        r12.add(r16);
        goto L36
    L28:
        if ((r14 + r17) < this.onceReportMaxSizeBytes) goto L35;
        if (e0.a.c() == null) goto L33;
        e0.a.c().d(Constants.TAG, "sendList:" + r11.toString());
    L33:
        LogSender.getInstance().sendLog(r12, r11.size() - r12.size());
        return;
    L22:
        if (ApmBaseContext.isDebugMode() == false) goto L24;
        Logger.d(Constants.TAG, "logFile invalid. delete now.");
    L24:
        r15.delete();
    L36:
        r13 = r13 + 1;
        goto L15
    L38:
        if (e0.a.c() == null) goto L40;
        e0.a.c().d(Constants.TAG, "sendList:" + r11.toString());
    L40:
        LogSender.getInstance().sendLog(r12, 0);
        return;
    L48:
        return;
    L5:
        Logger.e(Constants.TAG, "persistentBuffer is null");
        r10 = null;
        goto L6
    }

    private void reportMemory() {
        if (this.limitedQueue.isEmpty() == false) goto L5;
        return;
    L5:
        ArrayList r10 = new ArrayList();
        int r11 = 0;
    L7:
        if (this.limitedQueue.isEmpty() == true) goto L18;
        r10.add(this.limitedQueue.pop());
        LogFile r12 = this.limitedQueue.pop();
        if (r12 == null) goto L7;
        int r13 = r12.getTotalBytes();
        if (r11 == 0) goto L17;
        if ((r11 + r13) < this.onceReportMaxSizeBytes) goto L17;
        LogSender.getInstance().sendLog(r10, 0);
        r10.clear();
        r10.add(r12);
        r11 = r13;
    L17:
        r11 = r11 + r13;
        r10.add(r12);
        goto L7
    L18:
        LogSender.getInstance().sendLog(r10, 0);
    }

    @Override // com.bytedance.apm6.consumer.slardar.weedout.WeedOutStrategy
    public void doWeedOut(long r10) {
        if (this.persistentBuffer != null) goto L5;
        return;
    L5:
        String[] r11 = this.persistentBuffer.list();
        if (r11 != null) goto L8;
        return;
    L8:
        if (r11.length == 0) goto L23;
        int r12 = r11.length;
        int r13 = 0;
    L11:
        if (r13 >= r12) goto L24;
        String r14 = r11[r13];
        File r15 = new File(DiskEnvironmentHelper.getFlushDirectory(), r14);
        long r16 = getCreateTime(r15);
        if (r16 != (-1)) goto L16;
    L14:
        FileUtils.deleteFile(r15);
    L18:
        r13 = r13 + 1;
        goto L11
    L16:
        if (r16 > r10) goto L18;
    L24:
        return;
    }

    @Override // com.bytedance.apm6.consumer.slardar.weedout.WeedOutStrategy
    public void doWeedOutSize(long r11) {
        if (this.persistentBuffer != null) goto L5;
        return;
    L5:
        String[] r10 = this.persistentBuffer.list();
        if (r10 != null) goto L8;
        return;
    L8:
        if (r10.length == 0) goto L41;
        Arrays.sort(r10);
        int r12 = r10.length;
        int r13 = 0;
        long r14 = 0;
        int r15 = 0;
        long r16 = 0;
    L11:
        if (r15 >= r12) goto L18;
        File r17 = new File(DiskEnvironmentHelper.getFlushDirectory(), r10[r15]);
        if (r17.exists() == false) goto L17;
        if (r17.isFile() == false) goto L17;
        r16 = r16 + r17.length();
    L17:
        r15 = r15 + 1;
        goto L11
    L18:
        int r18 = r10.length;
    L19:
        if (r13 >= r18) goto L42;
        String r19 = r10[r13];
        if ((r16 - r14) <= r11) goto L43;
        File r20 = new File(DiskEnvironmentHelper.getFlushDirectory(), r19);
        if (r20.exists() == false) goto L29;
        if (r20.isFile() == false) goto L29;
        long r21 = r20.length();
        if (FileUtils.deleteFileWithResult(r20) == false) goto L29;
        r14 = r14 + r21;
    L29:
        r13 = r13 + 1;
        goto L19
    L43:
        return;
    L42:
        return;
    }

    @Override // com.bytedance.apm6.consumer.slardar.weedout.WeedOutStrategy
    public String getName() {
        return TYPE_WEED_OUT;
    }

    @Override // com.bytedance.apm6.consumer.slardar.weedout.WeedOutStrategy
    public long getSize() {
        String[] r10 = this.persistentBuffer.list();
        long r11 = 0;
        if (r10 != null) goto L5;
    L10:
        return r11;
    L5:
        if (r10.length == 0) goto L10;
        int r12 = r10.length;
        int r13 = 0;
    L8:
        if (r13 >= r12) goto L10;
        String r14 = r10[r13];
        r11 = r11 + new File(DiskEnvironmentHelper.getFlushDirectory(), r14).length();
        r13 = r13 + 1;
        goto L8
    }

    public synchronized void init() {
        monitor-enter(this);
        final long r10 = 0;
        final long r11 = this.interval;     // Catch: Throwable -> L8
        this.asyncTask = new AnonymousClass2(this, r10, r11);     // Catch: Throwable -> L8
        AsyncTaskManagerType r12 = AsyncTaskManagerType.IO;     // Catch: Throwable -> L8
        AsyncTaskManager.getInstance(r12).sendTask(this.asyncTask);     // Catch: Throwable -> L8
        if (ApmContext.isMainProcess() == false) goto L6;
        AsyncTaskManager r13 = AsyncTaskManager.getInstance(r12);     // Catch: Throwable -> L8
        final long r14 = WorkRequest.MIN_BACKOFF_MILLIS;
        r13.sendTask(new AnonymousClass3(this, r14));     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public synchronized void pause() {
        monitor-enter(this);
        this.isPaused = true;     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public synchronized void restart() {
        monitor-enter(this);
        AsyncTaskManager.getInstance(AsyncTaskManagerType.IO).sendTask(new AnonymousClass4(this));     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void resume() {
        monitor-enter(this);
        this.isPaused = false;     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void saveLogFileInMemory(LogFile r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        this.limitedQueue.push(r10);
    }

    public synchronized void setLoopInterval(long r10) {
        monitor-enter(this);
    L20:
        th = move-exception;
        throw th;
    L4:
        if (ApmBaseContext.isDebugMode() == false) goto L7;
        Logger.d(Constants.TAG, "setLoopInterval:" + this.interval);     // Catch: Throwable -> L20
    L7:
        if (r10 > 0) goto L9;
    L18:
        monitor-exit(this);
        return;
    L9:
        if (this.interval == r10) goto L18;
        this.interval = r10;     // Catch: Throwable -> L20
        if (this.asyncTask != null) goto L15;
        monitor-exit(this);
        return;
    L15:
        AsyncTaskManagerType r11 = AsyncTaskManagerType.IO;     // Catch: Throwable -> L20
        AsyncTaskManager.getInstance(r11).removeTask(this.asyncTask);     // Catch: Throwable -> L20
        final long r12 = this.interval;     // Catch: Throwable -> L20
        final long r13 = this.interval;     // Catch: Throwable -> L20
        this.asyncTask = new AnonymousClass1(this, r12, r13);     // Catch: Throwable -> L20
        AsyncTaskManager.getInstance(r11).sendTask(this.asyncTask);     // Catch: Throwable -> L20
        monitor-exit(this);
    }

    public void setOnceReportMaxSizeBytes(long r10) {
        if (r10 > 0) goto L5;
        return;
    L5:
        this.onceReportMaxSizeBytes = r10;
    }

    public void setPersistentBuffer(PersistentBuffer r10) {
        this.persistentBuffer = r10;
    }

    public void uploadRemainLogs() {
        if (ApmContext.isMainProcess() == true) goto L5;
        return;
    L5:
        AsyncTaskManager.getInstance(AsyncTaskManagerType.IO).sendTask(new AnonymousClass5(this));
    }
}
