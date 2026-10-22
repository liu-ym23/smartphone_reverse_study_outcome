package com.bytedance.apm6.consumer.slardar.send;

import a0.a;
import androidx.work.WorkRequest;
import com.bytedance.apm6.consumer.slardar.Constants;
import com.bytedance.apm6.consumer.slardar.persistent.LogFile;
import com.bytedance.apm6.consumer.slardar.weedout.WeedOutStrategy;
import com.bytedance.apm6.foundation.context.ApmContext;
import com.bytedance.apm6.util.ApmBaseContext;
import com.bytedance.apm6.util.FileUtils;
import com.bytedance.apm6.util.log.Logger;
import com.bytedance.apm6.util.timetask.AsyncTask;
import com.bytedance.apm6.util.timetask.AsyncTaskManager;
import com.bytedance.apm6.util.timetask.AsyncTaskManagerType;
import com.bytedance.common.utility.NetworkUtils;
import java.io.File;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: loaded from: classes.dex */
public class LogSender implements WeedOutStrategy {
    private static final int DEFAULT_SEND_LOG_INTERVAL = 30000;
    private static final int MAX_COUNT = 10;
    private static final long MAX_SEND_LOG_INTERVAL = 120000;
    private static final String TYPE_WEED_OUT = "second_log_dir";
    private AsyncTask asyncTask;
    private LinkedHashMap<UploadLogInfo, ConcurrentLinkedQueue<LogModel>> cacheLog;
    private volatile boolean isPaused;
    private long lastSendTime;
    private long retryCount;
    private long retryPollingInterval;

    private static class InnerHolder {
        private static final LogSender instance = null;

        static {
            instance = new LogSender(null);
        }

        private InnerHolder() {
        }

        static /* synthetic */ LogSender access$000() {
            return instance;
        }
    }

    private static final class LogModel {
        byte[] bytes;
        long nextSendTime;
        int retryCount;

        LogModel(byte[] r10, int r11, long r12) {
            this.bytes = r10;
            this.retryCount = r11;
            this.nextSendTime = r12;
        }
    }

    private LogSender() {
        this.cacheLog = new LinkedHashMap();
        this.retryPollingInterval = WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS;
        this.lastSendTime = 0;
        this.retryCount = 1;
        this.isPaused = false;
    }

    /* synthetic */ LogSender(AnonymousClass1 r10) {
        this();
    }

    static /* synthetic */ long access$100(LogSender r10) {
        return r10.lastSendTime;
    }

    static /* synthetic */ long access$102(LogSender r10, long r11) {
        r10.lastSendTime = r11;
        return r11;
    }

    static /* synthetic */ long access$200(LogSender r10) {
        return r10.retryPollingInterval;
    }

    static /* synthetic */ boolean access$300(LogSender r10) {
        return r10.isPaused;
    }

    static /* synthetic */ void access$400(LogSender r10) {
        r10.send();
    }

    private void deleteFiles(List<LogFile> r10) {
        Iterator<LogFile> r11 = r10.iterator();
    L4:
        if (r11.hasNext() == false) goto L11;
        LogFile r12 = r11.next();
    L10:
        Logger.w(Constants.TAG, "delete LogFile's source File failed. logFile=" + r12.getSource());
        goto L4
    L7:
        if (r12.getSource() == null) goto L4;
        FileUtils.deleteFile(r12.getSource());     // Catch: Exception -> L10
        goto L4
    }

    public static LogSender getInstance() {
        return InnerHolder.access$000();
    }

    private void reset() {
        this.retryCount = 1;
        this.retryPollingInterval = WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS;
    }

    private void send() {
        if (NetworkUtils.g(ApmBaseContext.getContext()) == true) goto L5;
        return;
    L5:
        if (LogReportController.getInstance().isReportLogEnable() == false) goto L21;
        if (ApmBaseContext.isDebugMode() == false) goto L9;
        Logger.d(Constants.TAG, "trigger send.");
    L9:
        boolean r10 = sendMemory();
        if (ApmContext.isMainProcess() == false) goto L12;
        r10 = sendFile();
    L12:
        if (r10 == false) goto L15;
        reset();
        goto L21
    L15:
        if (this.retryPollingInterval >= 120000) goto L18;
        long r11 = this.retryCount;
        this.retryPollingInterval = (r11 + 1) * WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS;
        this.retryCount = r11 + 1;
    L18:
        if (this.retryPollingInterval <= 120000) goto L21;
        this.retryPollingInterval = 120000;
    L21:
        if (ApmBaseContext.isDebugMode() == true) goto L23;
        return;
    L23:
        if (LogReportController.getInstance().isReportLogEnable() == true) goto L28;
        Logger.d(Constants.TAG, "report log disable");
        return;
    }

    private boolean sendFile() {
        Iterator<UploadLogInfo> r10 = UploadLogManager.getUploadType().iterator();
        boolean r11 = true;
    L4:
        if (r10.hasNext() == false) goto L24;
        UploadLogInfo r12 = r10.next();
        File r13 = DiskFileHelper.getInstance().getSendFile(r12.getName());
        if (r13 == null) goto L4;
        if (r13.exists() == false) goto L4;
        if (NetworkSender.getInstance(r12).sendLog(FileUtils.readFileToByteArray(r13)) == true) goto L13;
        DiskFileHelper.RetryMessage r14 = DiskFileHelper.getInstance().getReportMessage(r13);
        if (r14 == null) goto L19;
        int r15 = r14.getRetryCount() + 1;
    L20:
        long r16 = LogReportController.getInstance().getRetryInterval(r15) + System.currentTimeMillis();
        DiskFileHelper.getInstance().updateRetryMessage(r13, r15, r16);
        if (ApmBaseContext.isDebugMode() == false) goto L23;
        Logger.d(Constants.TAG, "sendfile error retry count:" + r13.getName() + "  " + r15 + " nextRetryTime:" + r16);
    L23:
        r11 = false;
        goto L4
    L19:
        r15 = 0;
        goto L20
    L13:
        if (ApmBaseContext.isDebugMode() == false) goto L15;
        Logger.d(Constants.TAG, "sendFile: success");
    L15:
        DiskFileHelper.getInstance().deleteLog(r13);
        goto L4
    L24:
        return r11;
    }

    private boolean sendMemory() {
        if (this.cacheLog.isEmpty() == false) goto L5;
        return true;
    L5:
        Iterator<UploadLogInfo> r10 = this.cacheLog.keySet().iterator();
        boolean r11 = true;
    L7:
        if (r10.hasNext() == false) goto L35;
        UploadLogInfo r12 = r10.next();
        ConcurrentLinkedQueue<LogModel> r13 = this.cacheLog.get(r12);
        if (r13 == null) goto L7;
        LogModel[] r14 = (LogModel[]) r13.toArray(new LogModel[0]);
        LogModel r15 = null;
        int r16 = r14.length;
        int r17 = 0;
    L12:
        if (r17 >= r16) goto L20;
        LogModel r18 = r14[r17];
        if (r18.retryCount <= 0) goto L19;
        if ((System.currentTimeMillis() - r18.nextSendTime) > 0) goto L19;
        r17 = r17 + 1;
    L19:
        r15 = r18;
    L20:
        if (r15 == null) goto L22;
    L24:
        if (r15 == null) goto L7;
        if (ApmBaseContext.isDebugMode() == false) goto L29;
        Logger.d(Constants.TAG, "sendMemory");
    L29:
        boolean r19 = NetworkSender.getInstance(r12).sendLog(r15.bytes);
        if (r19 == false) goto L32;
        r13.remove(r15);
    L33:
        if (r19 == true) goto L7;
        r11 = false;
        goto L7
    L32:
        r15.retryCount++;
        r15.nextSendTime = LogReportController.getInstance().getRetryInterval(r15.retryCount) + System.currentTimeMillis();
        goto L33
    L22:
        if (r13.size() <= 0) goto L24;
        r15 = r13.peek();
        goto L24
    L35:
        return r11;
    }

    @Override // com.bytedance.apm6.consumer.slardar.weedout.WeedOutStrategy
    public void doWeedOut(long r10) {
        File[] r11 = DiskFileHelper.getInstance().listFiles();
        if (r11 != null) goto L5;
        return;
    L5:
        int r12 = r11.length;
        int r13 = 0;
    L6:
        if (r13 >= r12) goto L11;
        File r14 = r11[r13];
        if (DiskFileHelper.getCreateTime(r14) > r10) goto L10;
        FileUtils.deleteFile(r14);
    L10:
        r13 = r13 + 1;
        goto L6
    }

    @Override // com.bytedance.apm6.consumer.slardar.weedout.WeedOutStrategy
    public void doWeedOutSize(long r10) {
        File[] r11 = DiskFileHelper.getInstance().listFiles();
        if (r11 != null) goto L5;
        return;
    L5:
        Arrays.sort(r11, new AnonymousClass2(this));
        int r12 = r11.length;
        int r13 = 0;
        long r14 = 0;
        int r15 = 0;
        long r16 = 0;
    L6:
        if (r15 >= r12) goto L13;
        File r17 = r11[r15];
        if (r17.exists() == false) goto L12;
        if (r17.isFile() == false) goto L12;
        r16 = r16 + r17.length();
    L12:
        r15 = r15 + 1;
        goto L6
    L13:
        int r18 = r11.length;
    L14:
        if (r13 >= r18) goto L36;
        File r19 = r11[r13];
        if ((r16 - r14) <= r10) goto L25;
        if (r19.exists() == false) goto L24;
        if (r19.isFile() == false) goto L24;
        long r20 = r19.length();
        if (FileUtils.deleteFileWithResult(r19) == false) goto L24;
        r14 = r14 + r20;
    L24:
        r13 = r13 + 1;
        goto L14
    L25:
        return;
    }

    @Override // com.bytedance.apm6.consumer.slardar.weedout.WeedOutStrategy
    public String getName() {
        return TYPE_WEED_OUT;
    }

    @Override // com.bytedance.apm6.consumer.slardar.weedout.WeedOutStrategy
    public long getSize() {
        File[] r10 = DiskFileHelper.getInstance().listFiles();
        long r11 = 0;
        if (r10 != null) goto L5;
        return 0;
    L5:
        int r12 = r10.length;
        int r13 = 0;
    L6:
        if (r13 >= r12) goto L8;
        r11 = r11 + r10[r13].length();
        r13 = r13 + 1;
        goto L6
    L8:
        return r11;
    }

    public void init() {
        final long r10 = 0;
        final long r11 = WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS;
        this.asyncTask = new AnonymousClass1(this, r10, r11);
        AsyncTaskManager.getInstance(AsyncTaskManagerType.IO).sendTask(this.asyncTask);
    }

    public void pause() {
        this.isPaused = true;
    }

    public void resume() {
        this.isPaused = false;
    }

    public void sendLog(List<LogFile> r19, int r20) {
    L62:
        th = move-exception;
        Logger.e(Constants.TAG, "sendLog", th);
        return;
    L4:
        if (LogReportController.getInstance().isStopCollect() == true) goto L6;
        Map<UploadLogInfo, byte[]> r10 = UploadLogManager.serialize(r19, r20);     // Catch: Throwable -> L62
        if (r10 != null) goto L18;
        deleteFiles(r19);     // Catch: Throwable -> L62
        return;
    L18:
        boolean r11 = NetworkUtils.g(ApmBaseContext.getContext());     // Catch: Throwable -> L62
        Iterator<UploadLogInfo> r12 = r10.keySet().iterator();     // Catch: Throwable -> L62
        boolean r13 = false;
    L20:
        if (r12.hasNext() == false) goto L58;
        UploadLogInfo r14 = r12.next();     // Catch: Throwable -> L62
        byte[] r15 = r10.get(r14);     // Catch: Throwable -> L62
        if (r15 == null) goto L20;
        if (LogReportController.getInstance().isReportLogEnable() == false) goto L36;
        if (r11 == false) goto L36;
        if (ApmBaseContext.isDebugMode() == false) goto L30;
        a.d(r15);     // Catch: Throwable -> L62
    L30:
        boolean r16 = NetworkSender.getInstance(r14).sendLog(r15);     // Catch: Throwable -> L62
        if (ApmBaseContext.isDebugMode() == false) goto L35;
        if (r16 == false) goto L34;
        a.h(r15);     // Catch: Throwable -> L62
        goto L35
    L34:
        a.f(r15);     // Catch: Throwable -> L62
    L35:
        this.lastSendTime = System.currentTimeMillis();     // Catch: Throwable -> L62
        r13 = r13 | r16;     // Catch: Throwable -> L62
        int r17 = 1;
    L38:
        if (ApmBaseContext.isDebugMode() == false) goto L40;
        Logger.d(Constants.TAG, "sendDirect:isReportLogEnable " + LogReportController.getInstance().isReportLogEnable() + " :sendResult " + r16);     // Catch: Throwable -> L62
    L40:
        if (r16 == true) goto L56;
        long r18 = LogReportController.getInstance().getRetryInterval(r17);     // Catch: Throwable -> L62
        long r110 = System.currentTimeMillis() + r18;     // Catch: Throwable -> L62
        if (ApmContext.isMainProcess() == false) goto L44;
        long r111 = r110;
        r16 = DiskFileHelper.getInstance().saveFile(r15, r14.getName(), r17, r111);     // Catch: Throwable -> L62
    L46:
        if (ApmBaseContext.isDebugMode() == false) goto L48;
        Logger.d(Constants.TAG, "saveFile:Result:" + r16 + ":isMaiProcess:" + ApmContext.isMainProcess() + " :" + r17 + " " + r18);     // Catch: Throwable -> L62
    L48:
        if (r16 == false) goto L50;
    L57:
        r13 = r13;
        goto L20
    L50:
        if (this.cacheLog.containsKey(r14) == false) goto L52;
        ConcurrentLinkedQueue<LogModel> r21 = this.cacheLog.get(r14);     // Catch: Throwable -> L62
    L54:
        if (r21.size() <= 10) goto L57;
        r21.poll();     // Catch: Throwable -> L62
        goto L57
    L52:
        r21 = new ConcurrentLinkedQueue();     // Catch: Throwable -> L62
        r21.add(new LogModel(r15, r17, r111));     // Catch: Throwable -> L62
        goto L54
    L44:
        r111 = r110;
        goto L46
    L56:
        r13 = r13;
    L36:
        r16 = false;
        r17 = 0;
        goto L38
    L58:
        if (r13 == false) goto L60;
        reset();     // Catch: Throwable -> L62
    L60:
        deleteFiles(r19);     // Catch: Throwable -> L62
        return;
    L6:
        if (ApmBaseContext.isDebugMode() == false) goto L8;
        Logger.d(Constants.TAG, "stop collect log");     // Catch: Throwable -> L62
    L8:
        Iterator<LogFile> r22 = r19.iterator();     // Catch: Throwable -> L62
        long r23 = 0;
        long r24 = 0;
    L10:
        if (r22.hasNext() == false) goto L12;
        LogFile r25 = r22.next();     // Catch: Throwable -> L62
        r23 = r23 + ((long) r25.getTotalCount());     // Catch: Throwable -> L62
        r24 = r24 + ((long) r25.getTotalBytes());     // Catch: Throwable -> L62
        goto L10
    L12:
        DropDataMonitor.getInstance().monitorDropLog(r23, r24, System.currentTimeMillis(), DropDataMonitor.Reason.SERVER_DROP);     // Catch: Throwable -> L62
        deleteFiles(r19);     // Catch: Throwable -> L62
    }
}
