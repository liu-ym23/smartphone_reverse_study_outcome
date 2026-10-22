package com.bytedance.apm6.consumer.slardar.send;

import android.app.Application;
import com.bytedance.apm.doctor.a;
import com.bytedance.apm6.consumer.slardar.Constants;
import com.bytedance.apm6.consumer.slardar.persistent.LogFile;
import com.bytedance.apm6.consumer.slardar.weedout.WeedOutStrategy;
import com.bytedance.apm6.foundation.context.ApmContext;
import com.bytedance.apm6.util.FileUtils;
import com.bytedance.apm6.util.log.Logger;
import com.bytedance.apm6.util.timetask.AsyncTask;
import com.bytedance.apm6.util.timetask.AsyncTaskManager;
import com.bytedance.apm6.util.timetask.AsyncTaskManagerType;
import com.bytedance.common.utility.NetworkUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
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

        LogModel(byte[] r1, int r2, long r3) {
            this.bytes = r1;
            this.retryCount = r2;
            this.nextSendTime = r3;
        }
    }

    private LogSender() {
        this.cacheLog = new LinkedHashMap();
        this.retryPollingInterval = 30000;
        this.lastSendTime = 0;
        this.retryCount = 1;
        this.isPaused = false;
    }

    /* synthetic */ LogSender(AnonymousClass1 r1) {
        this();
    }

    static /* synthetic */ long access$100(LogSender r2) {
        return r2.lastSendTime;
    }

    static /* synthetic */ long access$102(LogSender r0, long r1) {
        r0.lastSendTime = r1;
        return r1;
    }

    static /* synthetic */ long access$200(LogSender r2) {
        return r2.retryPollingInterval;
    }

    static /* synthetic */ boolean access$300(LogSender r0) {
        return r0.isPaused;
    }

    static /* synthetic */ void access$400(LogSender r0) {
        r0.send();
    }

    private void deleteFiles(List<LogFile> r5) {
        Iterator r4 = ((List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r4.hasNext() == false) goto L11;
        LogFile r6 = (LogFile) ZeusTransformUtils.preCheckCast(r4.next(), LogFile.class, "com.obric.memorydata.plugin");
    L10:
        Logger.w(Constants.TAG, "delete LogFile's source File failed. logFile=" + r6.getSource());
        goto L4
    L7:
        if (r6.getSource() == null) goto L4;
        FileUtils.deleteFile(r6.getSource());     // Catch: Exception -> L10
        goto L4
    }

    public static LogSender getInstance() {
        return InnerHolder.access$000();
    }

    private void reset() {
        this.retryCount = 1;
        this.retryPollingInterval = 30000;
    }

    private void send() {
        if (NetworkUtils.b((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(ApmContext.getContext(), "com.obric.memorydata.plugin"), Application.class, "com.obric.memorydata.plugin")) == true) goto L5;
        return;
    L5:
        if (LogReportController.getInstance().isReportLogEnable() == false) goto L21;
        if (ApmContext.isDebugMode() == false) goto L9;
        Logger.d(Constants.TAG, "trigger send.");
    L9:
        boolean r0 = sendMemory();
        if (ApmContext.isMainProcess() == false) goto L12;
        r0 = sendFile();
    L12:
        if (r0 == false) goto L15;
        reset();
        goto L21
    L15:
        if (this.retryPollingInterval >= 120000) goto L18;
        long r4 = this.retryCount;
        this.retryPollingInterval = (r4 + 1) * 30000;
        this.retryCount = r4 + 1;
    L18:
        if (this.retryPollingInterval <= 120000) goto L21;
        this.retryPollingInterval = 120000;
    L21:
        if (ApmContext.isDebugMode() == true) goto L23;
        return;
    L23:
        if (LogReportController.getInstance().isReportLogEnable() == true) goto L28;
        Logger.d(Constants.TAG, "report log disable");
        return;
    }

    private boolean sendFile() {
        Iterator<UploadLogInfo> r9 = UploadLogManager.getUploadType().iterator();
        boolean r1 = true;
    L4:
        if (r9.hasNext() == false) goto L24;
        UploadLogInfo r2 = (UploadLogInfo) ZeusTransformUtils.preCheckCast(r9.next(), UploadLogInfo.class, "com.obric.memorydata.plugin");
        File r3 = DiskFileHelper.getInstance().getSendFile(r2.getName());
        if (r3 == null) goto L4;
        if (r3.exists() == false) goto L4;
        if (NetworkSender.getInstance(r2).sendLog(FileUtils.readFileToByteArray(r3)) == true) goto L13;
        DiskFileHelper.RetryMessage r4 = DiskFileHelper.getInstance().getReportMessage(r3);
        if (r4 == null) goto L19;
        int r5 = r4.getRetryCount() + 1;
    L20:
        long r6 = LogReportController.getInstance().getRetryInterval(r5) + System.currentTimeMillis();
        DiskFileHelper.getInstance().updateRetryMessage(r3, r5, r6);
        if (ApmContext.isDebugMode() == false) goto L23;
        Logger.d(Constants.TAG, "sendfile error retry count:" + r3.getName() + "  " + r5 + " nextRetryTime:" + r6);
    L23:
        r1 = false;
        goto L4
    L19:
        r5 = 0;
        goto L20
    L13:
        if (ApmContext.isDebugMode() == false) goto L15;
        Logger.d(Constants.TAG, "sendFile: success");
    L15:
        DiskFileHelper.getInstance().deleteLog(r3);
        goto L4
    L24:
        return r1;
    }

    private boolean sendMemory() {
        if (this.cacheLog.isEmpty() == false) goto L5;
        return true;
    L5:
        Iterator<UploadLogInfo> r1 = this.cacheLog.keySet().iterator();
        boolean r3 = true;
    L7:
        if (r1.hasNext() == false) goto L35;
        UploadLogInfo r4 = (UploadLogInfo) ZeusTransformUtils.preCheckCast(r1.next(), UploadLogInfo.class, "com.obric.memorydata.plugin");
        ConcurrentLinkedQueue r5 = (ConcurrentLinkedQueue) ZeusTransformUtils.preCheckCast(this.cacheLog.get(r4), ConcurrentLinkedQueue.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L7;
        LogModel[] r8 = (LogModel[]) ZeusTransformUtils.preCheckCast(r5.toArray(new LogModel[0]), LogModel[].class, "com.obric.memorydata.plugin");
        LogModel r9 = null;
        int r10 = r8.length;
        int r11 = 0;
    L12:
        if (r11 >= r10) goto L20;
        LogModel r12 = r8[r11];
        if (r12.retryCount <= 0) goto L19;
        LogModel[] r15 = r8;
        if ((System.currentTimeMillis() - r12.nextSendTime) > 0) goto L19;
        r11 = r11 + 1;
        r8 = r15;
    L19:
        r9 = r12;
    L20:
        if (r9 == null) goto L22;
    L24:
        if (r9 == null) goto L7;
        if (ApmContext.isDebugMode() == false) goto L29;
        Logger.d(Constants.TAG, "sendMemory");
    L29:
        boolean r6 = NetworkSender.getInstance(r4).sendLog(r9.bytes);
        if (r6 == false) goto L32;
        r5.remove(r9);
    L33:
        if (r6 == true) goto L7;
        r3 = false;
        goto L7
    L32:
        r9.retryCount++;
        r9.nextSendTime = LogReportController.getInstance().getRetryInterval(r9.retryCount) + System.currentTimeMillis();
        goto L33
    L22:
        if (r5.size() <= 0) goto L24;
        r9 = (LogModel) ZeusTransformUtils.preCheckCast(r5.peek(), LogModel.class, "com.obric.memorydata.plugin");
        goto L24
    L35:
        return r3;
    }

    @Override // com.bytedance.apm6.consumer.slardar.weedout.WeedOutStrategy
    public void doWeedOut(long r6) {
        File[] r5 = DiskFileHelper.getInstance().listFiles();
        if (r5 != null) goto L5;
        return;
    L5:
        int r0 = r5.length;
        int r1 = 0;
    L6:
        if (r1 >= r0) goto L11;
        File r2 = r5[r1];
        if (DiskFileHelper.getCreateTime(r2) > r6) goto L10;
        FileUtils.deleteFile(r2);
    L10:
        r1 = r1 + 1;
        goto L6
    }

    @Override // com.bytedance.apm6.consumer.slardar.weedout.WeedOutStrategy
    public void doWeedOutSize(long r10) {
        File[] r0 = DiskFileHelper.getInstance().listFiles();
        if (r0 != null) goto L5;
        return;
    L5:
        Arrays.sort(r0, new AnonymousClass2(this));
        int r9 = r0.length;
        int r1 = 0;
        long r2 = 0;
        int r4 = 0;
        long r5 = 0;
    L6:
        if (r4 >= r9) goto L13;
        File r7 = r0[r4];
        if (r7.exists() == false) goto L12;
        if (r7.isFile() == false) goto L12;
        r5 = r5 + r7.length();
    L12:
        r4 = r4 + 1;
        goto L6
    L13:
        int r11 = r0.length;
    L14:
        if (r1 >= r11) goto L36;
        File r6 = r0[r1];
        if ((r5 - r2) <= r10) goto L25;
        if (r6.exists() == false) goto L24;
        if (r6.isFile() == false) goto L24;
        long r8 = r6.length();
        if (FileUtils.deleteFileWithResult(r6) == false) goto L24;
        r2 = r2 + r8;
    L24:
        r1 = r1 + 1;
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
        File[] r6 = DiskFileHelper.getInstance().listFiles();
        long r0 = 0;
        if (r6 != null) goto L5;
        return 0;
    L5:
        int r2 = r6.length;
        int r3 = 0;
    L6:
        if (r3 >= r2) goto L8;
        r0 = r0 + r6[r3].length();
        r3 = r3 + 1;
        goto L6
    L8:
        return r0;
    }

    public void init() {
        final long r2 = 0;
        final long r4 = 30000;
        this.asyncTask = new AnonymousClass1(this, r2, r4);
        AsyncTaskManager.getInstance(AsyncTaskManagerType.IO).sendTask(this.asyncTask);
    }

    public void pause() {
        this.isPaused = true;
    }

    public void resume() {
        this.isPaused = false;
    }

    public void sendLog(List<LogFile> r20, int r21) {
        List<LogFile> r1 = (List) ZeusTransformUtils.wrapperContextForParams(r20, List.class, "com.obric.memorydata.plugin");
    L62:
        th = move-exception;
        Logger.e(Constants.TAG, "sendLog", th);
        return;
    L4:
        if (LogReportController.getInstance().isStopCollect() == true) goto L6;
        Map<UploadLogInfo, byte[]> r3 = UploadLogManager.serialize(r1, r21);     // Catch: Throwable -> L62
        if (r3 != null) goto L18;
        deleteFiles(r1);     // Catch: Throwable -> L62
        return;
    L18:
        boolean r4 = NetworkUtils.b((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(ApmContext.getContext(), "com.obric.memorydata.plugin"), Application.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L62
        Iterator<UploadLogInfo> r5 = r3.keySet().iterator();     // Catch: Throwable -> L62
        boolean r7 = false;
    L20:
        if (r5.hasNext() == false) goto L58;
        UploadLogInfo r8 = (UploadLogInfo) ZeusTransformUtils.preCheckCast(r5.next(), UploadLogInfo.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L62
        byte[] r9 = (byte[]) ZeusTransformUtils.preCheckCast(r3.get(r8), byte[].class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L62
        if (r9 == null) goto L20;
        if (LogReportController.getInstance().isReportLogEnable() == false) goto L36;
        if (r4 == false) goto L36;
        if (ApmContext.isDebugMode() == false) goto L30;
        a.a(r9);     // Catch: Throwable -> L62
    L30:
        boolean r10 = NetworkSender.getInstance(r8).sendLog(r9);     // Catch: Throwable -> L62
        if (ApmContext.isDebugMode() == false) goto L35;
        if (r10 == false) goto L34;
        a.b(r9);     // Catch: Throwable -> L62
        goto L35
    L34:
        a.c(r9);     // Catch: Throwable -> L62
    L35:
        this.lastSendTime = System.currentTimeMillis();     // Catch: Throwable -> L62
        r7 = r7 | r10;     // Catch: Throwable -> L62
        int r14 = 1;
    L38:
        if (ApmContext.isDebugMode() == false) goto L40;
        Logger.d(Constants.TAG, "sendDirect:isReportLogEnable " + LogReportController.getInstance().isReportLogEnable() + " :sendResult " + r10);     // Catch: Throwable -> L62
    L40:
        if (r10 == true) goto L56;
        long r12 = LogReportController.getInstance().getRetryInterval(r14);     // Catch: Throwable -> L62
        boolean r22 = r7;
        long r6 = System.currentTimeMillis() + r12;     // Catch: Throwable -> L62
        if (ApmContext.isMainProcess() == false) goto L46;
        r10 = DiskFileHelper.getInstance().saveFile(r9, r8.getName(), r14, r6);     // Catch: Throwable -> L62
    L46:
        if (ApmContext.isDebugMode() == false) goto L48;
        Logger.d(Constants.TAG, "saveFile:Result:" + r10 + ":isMaiProcess:" + ApmContext.isMainProcess() + " :" + r14 + " " + r12);     // Catch: Throwable -> L62
    L48:
        if (r10 == false) goto L50;
    L57:
        r7 = r22;
        r3 = r3;
        r4 = r4;
        r5 = r5;
        goto L20
    L50:
        if (this.cacheLog.containsKey(r8) == false) goto L52;
        ConcurrentLinkedQueue r11 = (ConcurrentLinkedQueue) ZeusTransformUtils.preCheckCast(this.cacheLog.get(r8), ConcurrentLinkedQueue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L62
    L54:
        if (r11.size() <= 10) goto L57;
        r11.poll();     // Catch: Throwable -> L62
        goto L57
    L52:
        r11 = new ConcurrentLinkedQueue();     // Catch: Throwable -> L62
        r11.add(new LogModel(r9, r14, r6));     // Catch: Throwable -> L62
        goto L54
    L56:
        r3 = r3;
        r4 = r4;
        r5 = r5;
        r22 = r7;
    L36:
        r10 = false;
        r14 = 0;
        goto L38
    L58:
        if (r7 == false) goto L60;
        reset();     // Catch: Throwable -> L62
    L60:
        deleteFiles(r1);     // Catch: Throwable -> L62
        return;
    L6:
        if (ApmContext.isDebugMode() == false) goto L8;
        Logger.d(Constants.TAG, "stop collect log");     // Catch: Throwable -> L62
    L8:
        Iterator<LogFile> r13 = r1.iterator();     // Catch: Throwable -> L62
        long r15 = 0;
        long r16 = 0;
    L10:
        if (r13.hasNext() == false) goto L12;
        LogFile r17 = (LogFile) ZeusTransformUtils.preCheckCast(r13.next(), LogFile.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L62
        r15 = r15 + ((long) r17.getTotalCount());     // Catch: Throwable -> L62
        r16 = r16 + ((long) r17.getTotalBytes());     // Catch: Throwable -> L62
        goto L10
    L12:
        DropDataMonitor.getInstance().monitorDropLog(r15, r16, System.currentTimeMillis(), DropDataMonitor.Reason.SERVER_DROP);     // Catch: Throwable -> L62
        deleteFiles(r1);     // Catch: Throwable -> L62
    }
}
