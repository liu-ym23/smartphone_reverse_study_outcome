package com.bytedance.crash.event;

import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.Global;
import com.bytedance.crash.TagService;
import com.bytedance.crash.UserDataCenter;
import com.bytedance.crash.config.NetConfig;
import com.bytedance.crash.entity.Header;
import com.bytedance.crash.monitor.EventMonitor;
import com.bytedance.crash.runtime.DefaultWorkThread;
import com.bytedance.crash.upload.CrashUploader;
import com.bytedance.crash.upload.UploadLimits;
import com.bytedance.crash.upload.UploaderUrl;
import com.bytedance.crash.util.App;
import com.bytedance.crash.util.Digest;
import com.bytedance.crash.util.NpthLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class EnsureDeliverer implements Runnable {
    private static final int DELAY_CHECK = 30000;
    public static final String ENSURE_NOT_REACH_HERE = "EnsureNotReachHere";
    private static final String TAG = "CustomException";
    private static HashSet<String> list = null;
    private static int maxCacheCount = 100;
    private static int maxQueueLimitSize = 30;
    private static CopyOnWriteArrayList<EnsureDeliverer> sEnsureList = null;
    private static boolean sIsDropData = false;
    private static boolean sIsStopUpload = false;
    private final ConcurrentLinkedQueue<EnsureReportData> cache;
    private EnsureConfig config;
    private EventMonitor monitor;
    private final ConcurrentLinkedQueue<EnsureReportData> queue;

    static {
        sEnsureList = new CopyOnWriteArrayList();
        list = new HashSet();
    }

    public EnsureDeliverer(EventMonitor r2) {
        this.queue = new ConcurrentLinkedQueue();
        this.cache = new ConcurrentLinkedQueue();
        this.monitor = r2;
        sEnsureList.add(this);
    }

    static /* synthetic */ void access$000(EnsureDeliverer r0) {
        r0.processCache();
    }

    static /* synthetic */ ConcurrentLinkedQueue access$100(EnsureDeliverer r0) {
        return r0.queue;
    }

    public static void addWhiteLogType(String r1) {
        list.add(r1);
    }

    private void cacheToQueue() {
    L3:
        if (this.cache.isEmpty() == true) goto L7;
        EnsureReportData r0 = (EnsureReportData) ZeusTransformUtils.preCheckCast(this.cache.poll(), EnsureReportData.class, "com.obric.memorydata.plugin");
        if (isCanReport(r0) == false) goto L3;
        this.queue.add(r0);
        goto L3
    }

    public static void clean() {
        Iterator<EnsureDeliverer> r0 = sEnsureList.iterator();     // Catch: Throwable -> L8
    L4:
        if (r0.hasNext() == false) goto L13;
        EnsureDeliverer r1 = (EnsureDeliverer) ZeusTransformUtils.preCheckCast(r0.next(), EnsureDeliverer.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L8
        r1.queue.clear();     // Catch: Throwable -> L8
        r1.cache.clear();     // Catch: Throwable -> L8
    L13:
        return;
    }

    private boolean isDropException(String r7, String r8) {
        if (isStopUpload(r7) == false) goto L8;
        StringBuilder r6 = new StringBuilder().append("isStopUpload：the logType = ").append(r7).append(" message:").append(r8);
    L5:
        NpthLog.i(TAG, r6.toString());
        return true;
    L8:
        if (this.config != null) goto L14;
        if (this.cache.size() < maxCacheCount) goto L14;
        StringBuilder r9 = new StringBuilder();
    L12:
        r6 = r9.append("the logType = ").append(r7).append("is discarded the cache exceed 100");
    L14:
        if (maxQueueLimitSize > 0) goto L17;
        return true;
    L17:
        if (UploadLimits.isInited() == false) goto L22;
        if (UploadLimits.get().checkEnsureAllLimit() == false) goto L22;
        r6 = new StringBuilder().append("the logType = ").append(r7).append("is discarded beacuse the report is exceed 100");
    L22:
        if (this.config != null) goto L27;
        if (this.cache.size() < maxCacheCount) goto L27;
        r9 = new StringBuilder();
    L27:
        if (this.config != null) goto L30;
        return false;
    L30:
        NpthLog.i(TAG, "the logType = " + r7 + "message = " + r8 + " isSample = " + this.config.isSample(r7, r8));
        return !this.config.isSample(r7, r8);
    }

    public static boolean isStopUpload(String r1) {
        if (sIsStopUpload == true) goto L5;
        return false;
    L5:
        return !list.contains(r1);
    }

    private void processCache() {
        cacheToQueue();
        if (this.queue.size() < maxQueueLimitSize) goto L6;
        upload();
        return;
    }

    private void reportReportData(final EnsureReportData r3) {
        if (this.config == null) goto L5;
        DefaultWorkThread.post(new AnonymousClass2(this, r3));
        return;
    L5:
        if (this.cache.size() < maxCacheCount) goto L7;
        return;
    L7:
        NpthLog.e(TAG, "cache:" + r3);
        this.cache.add(r3);
    }

    public static void setDropData(boolean r0) {
        sIsDropData = r0;
    }

    public static void setMaxCacheCount(int r0) {
        if (r0 <= 0) goto L5;
        maxCacheCount = r0;
        return;
    }

    public static void setQueueLimitSize(int r0) {
        if (r0 > 0) goto L4;
        sIsStopUpload = true;
        return;
    L4:
        maxQueueLimitSize = r0;
    }

    private void upload() {
        if (this.queue.isEmpty() == false) goto L22;
        return;
    L22:
        JSONObject r0 = new JSONObject();     // Catch: Exception -> L21
        JSONArray r1 = new JSONArray();     // Catch: Exception -> L21
        int r2 = 0;
        Map<String, String> r3 = null;
        if (UserDataCenter.isIgnoreExceptionTag() == true) goto L12;
        r3 = this.monitor.getUserDataCenter().getCustomTags();     // Catch: Exception -> L21
        Map<String, String> r4 = TagService.getImportTagMap();     // Catch: Exception -> L21
        if (r4 == null) goto L12;
        HashMap r5 = new HashMap();     // Catch: Exception -> L21
        r5.putAll(r3);     // Catch: Exception -> L21
        r5.putAll(r4);     // Catch: Exception -> L21
        r3 = r5;
    L12:
        if (this.queue.isEmpty() == true) goto L16;
        if (r2 > maxQueueLimitSize) goto L16;
        EnsureReportData r6 = (EnsureReportData) ZeusTransformUtils.preCheckCast(this.queue.poll(), EnsureReportData.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L21
        NpthLog.i(TAG, "upload:message:" + r6.getMessage() + " log_type:" + r6.getLogType());     // Catch: Exception -> L21
        r1.put(r6.toJsonObject(this.monitor, r3));     // Catch: Exception -> L21
        r2 = r2 + 1;     // Catch: Exception -> L21
    L16:
        r0.put("data", r1);     // Catch: Exception -> L21
        int r7 = Process.myPid();     // Catch: Exception -> L21
        JSONObject r8 = Header.createEventHeader(this.monitor, System.currentTimeMillis(), CrashType.ENSURE, r7).getJson();     // Catch: Exception -> L21
        r0.put("header", r8);     // Catch: Exception -> L21
        if (sIsDropData == false) goto L19;
        return;
    L19:
        String r9 = UploaderUrl.appendUrlParamsByHeader(NetConfig.getExceptionUploadUrl(), r8);     // Catch: Exception -> L21
        NpthLog.i(TAG, "isSuccess:" + CrashUploader.uploadEvent(r9, r0) + "  upload:" + r9);     // Catch: Exception -> L21
        UploadLimits.get().writeUploadTimesFile();     // Catch: Exception -> L21
        return;
    }

    public boolean isCanReport(EnsureReportData r8) {
        if (this.config != null) goto L9;
        StringBuilder r7 = new StringBuilder().append("isCanReport:config = null and event type");
        String r9 = r8.getLogType();
    L5:
        StringBuilder r10 = r7.append(r9);
    L6:
        NpthLog.i(TAG, r10.toString());
        return false;
    L9:
        if (isStopUpload(r8.getLogType()) == false) goto L12;
        r7 = new StringBuilder().append("the log_type = ").append(r8.getLogType()).append(" and message = ").append(r8.getMessage());
        r9 = "is discard because the stop upload";
        goto L5
    L12:
        if (this.config.isSample(r8.getLogType(), r8.getMessage()) == true) goto L15;
        r10 = new StringBuilder().append("the log_type = ").append(r8.getLogType()).append(" and message = ").append(r8.getMessage()).append("is discard because the config").append(this.config.isSample(r8.getLogType())).append(" ").append(this.config.isMessageSample(r8.getMessage()));
        goto L6
    L15:
        if (TextUtils.isEmpty(r8.getMessage()) == false) goto L17;
        String r11 = null;
    L18:
        String r0 = r8.getStackMD5();
        boolean r3 = UploadLimits.get().checkEnsureLimit(r11, r0);
        NpthLog.i(TAG, "the message " + r8.getMessage() + "  is exceed limit:" + r3);
        if (r3 == true) goto L22;
        UploadLimits.get().updateEnsureUploadTimes(r0, r11);
        return true;
    L22:
        return false;
    L17:
        r11 = Digest.getMD5(r8.getMessage());
        goto L18
    }

    public boolean isEnsureEnable() {
        EnsureConfig r0 = this.config;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.isUploadEnable();
    }

    public void reportJavaEnsure(Throwable r14, StackTraceElement[] r15, String r16, Map<String, String> r17, String r18, String r19, String r20, boolean r21) {
        Map r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r17, Map.class, "com.obric.memorydata.plugin");
        if (TextUtils.isEmpty(r20) == false) goto L5;
        String r10 = "core_exception_monitor";
    L6:
        NpthLog.d(TAG, "reportJavaEnsure:message:" + r16 + " " + App.getProcessName());
        if (isDropException(r10, r16) == false) goto L10;
        NpthLog.i(TAG, "reportJavaEnsure：isDrop:" + r10 + " " + r16);
        return;
    L10:
        reportReportData(new EnsureReportData(r14, r15, 0, r16, r21, r7, r18, r19, r10, CommonConsts.LOG_REPORT_TYPE_EXCEPTION));
        return;
    L5:
        r10 = r20;
        goto L6
    }

    public void reportJavaEnsure(JSONObject r8, String r9, String r10) {
        String r0 = r8.optString("message");
        if (TextUtils.isEmpty(r10) == false) goto L5;
        r10 = "core_exception_monitor";
    L5:
        String r2 = r10;
        if (isDropException(r2, r0) == false) goto L9;
        NpthLog.i(TAG, "reportJavaEnsure：isDrop:" + r2 + " " + r0);
        return;
    L9:
        reportReportData(new EnsureReportData(r2, r9, null, r8, CommonConsts.LOG_REPORT_TYPE_EXCEPTION));
    }

    public void reportMessage(int r14) {
        if (isDropException("core_exception_monitor", null) == false) goto L5;
        return;
    L5:
        Thread r0 = Thread.currentThread();
        reportReportData(new EnsureReportData(null, r0.getStackTrace(), r14, null, true, null, r0.getName(), ENSURE_NOT_REACH_HERE, "core_exception_monitor", CommonConsts.LOG_REPORT_TYPE_EXCEPTION));
    }

    public void reportMessage(String r14, int r15) {
        if (isDropException("core_exception_monitor", r14) == false) goto L6;
        NpthLog.i(TAG, "reportMessage：isDrop:" + r14);
        return;
    L6:
        Thread r0 = Thread.currentThread();
        reportReportData(new EnsureReportData(null, r0.getStackTrace(), r15, r14, true, null, r0.getName(), ENSURE_NOT_REACH_HERE, "core_exception_monitor", CommonConsts.LOG_REPORT_TYPE_EXCEPTION));
    }

    public void reportMessage(String r13, Map<String, String> r14, int r15) {
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r14, Map.class, "com.obric.memorydata.plugin");
        if (isDropException("core_exception_monitor", r13) == false) goto L6;
        NpthLog.i(TAG, "reportMessage：isDrop:" + r13);
        return;
    L6:
        Thread r16 = Thread.currentThread();
        reportReportData(new EnsureReportData(null, r16.getStackTrace(), r15, r13, true, r6, r16.getName(), ENSURE_NOT_REACH_HERE, "core_exception_monitor", CommonConsts.LOG_REPORT_TYPE_EXCEPTION));
    }

    public void reportNativeEnsure(String r10, String r11, String r12, String r13, Map<String, String> r14, String r15) {
        Map r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r14, Map.class, "com.obric.memorydata.plugin");
        if (TextUtils.isEmpty(r15) == false) goto L5;
        r15 = "core_exception_monitor";
    L5:
        String r6 = r15;
        if (isDropException(r6, r13) == false) goto L9;
        NpthLog.i(TAG, "reportNativeEnsure：isDrop:" + r6 + " " + r13);
        return;
    L9:
        reportReportData(new EnsureReportData(r11, r10, r13, r4, r12, r6, "native_exception", Process.myPid()));
    }

    public void reportNativeEnsure(JSONObject r7, String r8, String r9, String r10) {
        if (TextUtils.isEmpty(r10) == false) goto L5;
        r10 = "core_exception_monitor";
    L5:
        String r1 = r10;
        String r11 = r7.optString("message");
        if (isDropException(r1, r11) == false) goto L9;
        NpthLog.i(TAG, "reportNativeEnsure：isDrop:" + r1 + " " + r11);
        return;
    L9:
        reportReportData(new EnsureReportData(r1, r9, r8, r7, "native_exception"));
    }

    public void reportThrowable(String r10, Map<String, String> r11, Throwable r12, String r13) {
        reportJavaEnsure(r12, null, r10, (Map) ZeusTransformUtils.wrapperContextForParams(r11, Map.class, "com.obric.memorydata.plugin"), Thread.currentThread().getName(), ENSURE_NOT_REACH_HERE, r13, true);
    }

    public void reportThrowable(Throwable r4) {
        if (isDropException("core_exception_monitor", null) == false) goto L6;
        NpthLog.i(TAG, "reportThrowable：isDrop:");
        return;
    L6:
        reportThrowable(null, null, r4, "core_exception_monitor");
    }

    public void reportThrowable(Throwable r3, String r4) {
        reportThrowable(r4, null, r3, "core_exception_monitor");
    }

    public void reportThrowable(Throwable r2, String r3, String r4) {
        reportThrowable(r3, null, r2, r4);
    }

    public void reportThrowable(Throwable r3, String r4, Map<String, String> r5) {
        reportThrowable(r4, (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.memorydata.plugin"), r3, "core_exception_monitor");
    }

    public void reportThrowable(Throwable r11, String r12, boolean r13) {
        reportJavaEnsure(r11, null, r12, null, Thread.currentThread().getName(), ENSURE_NOT_REACH_HERE, "core_exception_monitor", r13);
    }

    @Override // java.lang.Runnable
    public void run() {
        NpthLog.d(TAG, "run:" + App.getCurProcessName((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(Global.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")) + " " + this.monitor.getAppId());
        cacheToQueue();
        upload();
        DefaultWorkThread.postDelayed(this, 30000);
    }

    public void setMonitor(EventMonitor r1) {
        this.monitor = r1;
    }

    public void updateConfig(EnsureConfig r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        NpthLog.i(TAG, "updateConfig :" + this.monitor.getAppId() + " :" + r3);
        this.config = r3;
        DefaultWorkThread.removeCallbacks(this);
        DefaultWorkThread.post(new AnonymousClass1(this));
        DefaultWorkThread.postDelayed(this, 30000);
    }
}
