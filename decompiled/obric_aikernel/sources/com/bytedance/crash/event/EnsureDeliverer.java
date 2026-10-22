package com.bytedance.crash.event;

import android.os.Process;
import android.text.TextUtils;
import androidx.work.WorkRequest;
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
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
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

    public EnsureDeliverer(EventMonitor r10) {
        this.queue = new ConcurrentLinkedQueue();
        this.cache = new ConcurrentLinkedQueue();
        this.monitor = r10;
        sEnsureList.add(this);
    }

    static /* synthetic */ void access$000(EnsureDeliverer r10) {
        r10.processCache();
    }

    static /* synthetic */ ConcurrentLinkedQueue access$100(EnsureDeliverer r10) {
        return r10.queue;
    }

    public static void addWhiteLogType(String r10) {
        list.add(r10);
    }

    private void cacheToQueue() {
    L3:
        if (this.cache.isEmpty() == true) goto L7;
        EnsureReportData r10 = this.cache.poll();
        if (isCanReport(r10) == false) goto L3;
        this.queue.add(r10);
        goto L3
    }

    public static void clean() {
        Iterator<EnsureDeliverer> r10 = sEnsureList.iterator();     // Catch: Throwable -> L8
    L4:
        if (r10.hasNext() == false) goto L13;
        EnsureDeliverer r11 = r10.next();     // Catch: Throwable -> L8
        r11.queue.clear();     // Catch: Throwable -> L8
        r11.cache.clear();     // Catch: Throwable -> L8
    L13:
        return;
    }

    private boolean isDropException(String r10, String r11) {
        if (isStopUpload(r10) == false) goto L8;
        StringBuilder r12 = new StringBuilder();
        r12.append("isStopUpload：the logType = ");
        r12.append(r10);
        r12.append(" message:");
        r12.append(r11);
    L5:
        NpthLog.i(TAG, r12.toString());
        return true;
    L8:
        if (this.config != null) goto L14;
        if (this.cache.size() < maxCacheCount) goto L14;
        r12 = new StringBuilder();
    L12:
        r12.append("the logType = ");
        r12.append(r10);
        r12.append("is discarded the cache exceed 100");
    L14:
        if (maxQueueLimitSize > 0) goto L17;
        return true;
    L17:
        if (UploadLimits.isInited() == false) goto L22;
        if (UploadLimits.get().checkEnsureAllLimit() == false) goto L22;
        r12 = new StringBuilder();
        r12.append("the logType = ");
        r12.append(r10);
        r12.append("is discarded beacuse the report is exceed 100");
    L22:
        if (this.config != null) goto L27;
        if (this.cache.size() < maxCacheCount) goto L27;
        r12 = new StringBuilder();
    L27:
        if (this.config != null) goto L30;
        return false;
    L30:
        NpthLog.i(TAG, "the logType = " + r10 + "message = " + r11 + " isSample = " + this.config.isSample(r10, r11));
        return !this.config.isSample(r10, r11);
    }

    public static boolean isStopUpload(String r10) {
        if (sIsStopUpload == true) goto L5;
        return false;
    L5:
        return !list.contains(r10);
    }

    private void processCache() {
        cacheToQueue();
        if (this.queue.size() < maxQueueLimitSize) goto L6;
        upload();
        return;
    }

    private void reportReportData(final EnsureReportData r10) {
        if (this.config == null) goto L5;
        DefaultWorkThread.post(new AnonymousClass2(this, r10));
        return;
    L5:
        if (this.cache.size() < maxCacheCount) goto L7;
        return;
    L7:
        NpthLog.e(TAG, "cache:" + r10);
        this.cache.add(r10);
    }

    public static void setDropData(boolean r10) {
        sIsDropData = r10;
    }

    public static void setMaxCacheCount(int r10) {
        if (r10 <= 0) goto L5;
        maxCacheCount = r10;
        return;
    }

    public static void setQueueLimitSize(int r10) {
        if (r10 > 0) goto L4;
        sIsStopUpload = true;
        return;
    L4:
        maxQueueLimitSize = r10;
    }

    private void upload() {
        if (this.queue.isEmpty() == false) goto L22;
        return;
    L22:
        JSONObject r10 = new JSONObject();     // Catch: Exception -> L21
        JSONArray r11 = new JSONArray();     // Catch: Exception -> L21
        int r12 = 0;
        Map<String, String> r13 = null;
        if (UserDataCenter.isIgnoreExceptionTag() == true) goto L12;
        r13 = this.monitor.getUserDataCenter().getCustomTags();     // Catch: Exception -> L21
        Map<String, String> r14 = TagService.getImportTagMap();     // Catch: Exception -> L21
        if (r14 == null) goto L12;
        HashMap r15 = new HashMap();     // Catch: Exception -> L21
        r15.putAll(r13);     // Catch: Exception -> L21
        r15.putAll(r14);     // Catch: Exception -> L21
        r13 = r15;
    L12:
        if (this.queue.isEmpty() == true) goto L16;
        if (r12 > maxQueueLimitSize) goto L16;
        EnsureReportData r16 = this.queue.poll();     // Catch: Exception -> L21
        NpthLog.i(TAG, "upload:message:" + r16.getMessage() + " log_type:" + r16.getLogType());     // Catch: Exception -> L21
        r11.put(r16.toJsonObject(this.monitor, r13));     // Catch: Exception -> L21
        r12 = r12 + 1;     // Catch: Exception -> L21
    L16:
        r10.put("data", r11);     // Catch: Exception -> L21
        int r17 = Process.myPid();     // Catch: Exception -> L21
        JSONObject r18 = Header.createEventHeader(this.monitor, System.currentTimeMillis(), CrashType.ENSURE, r17).getJson();     // Catch: Exception -> L21
        r10.put("header", r18);     // Catch: Exception -> L21
        if (sIsDropData == false) goto L19;
        return;
    L19:
        String r19 = UploaderUrl.appendUrlParamsByHeader(NetConfig.getExceptionUploadUrl(), r18);     // Catch: Exception -> L21
        NpthLog.i(TAG, "isSuccess:" + CrashUploader.uploadEvent(r19, r10) + "  upload:" + r19);     // Catch: Exception -> L21
        UploadLimits.get().writeUploadTimesFile();     // Catch: Exception -> L21
        return;
    }

    public boolean isCanReport(EnsureReportData r10) {
        if (this.config != null) goto L9;
        StringBuilder r11 = new StringBuilder();
        r11.append("isCanReport:config = null and event type");
        String r12 = r10.getLogType();
    L5:
        r11.append(r12);
        String r13 = r11.toString();
    L6:
        NpthLog.i(TAG, r13);
        return false;
    L9:
        if (isStopUpload(r10.getLogType()) == false) goto L12;
        r11 = new StringBuilder();
        r11.append("the log_type = ");
        r11.append(r10.getLogType());
        r11.append(" and message = ");
        r11.append(r10.getMessage());
        r12 = "is discard because the stop upload";
        goto L5
    L12:
        if (this.config.isSample(r10.getLogType(), r10.getMessage()) == true) goto L15;
        r13 = "the log_type = " + r10.getLogType() + " and message = " + r10.getMessage() + "is discard because the config" + this.config.isSample(r10.getLogType()) + " " + this.config.isMessageSample(r10.getMessage());
        goto L6
    L15:
        if (TextUtils.isEmpty(r10.getMessage()) == false) goto L17;
        String r14 = null;
    L18:
        String r15 = r10.getStackMD5();
        boolean r16 = UploadLimits.get().checkEnsureLimit(r14, r15);
        NpthLog.i(TAG, "the message " + r10.getMessage() + "  is exceed limit:" + r16);
        if (r16 == true) goto L22;
        UploadLimits.get().updateEnsureUploadTimes(r15, r14);
        return true;
    L22:
        return false;
    L17:
        r14 = Digest.getMD5(r10.getMessage());
        goto L18
    }

    public boolean isEnsureEnable() {
        EnsureConfig r10 = this.config;
        if (r10 != null) goto L7;
        return false;
    L7:
        return r10.isUploadEnable();
    }

    public void reportJavaEnsure(Throwable r14, StackTraceElement[] r15, String r16, Map<String, String> r17, String r18, String r19, String r20, boolean r21) {
        if (TextUtils.isEmpty(r20) == false) goto L5;
        String r10 = "core_exception_monitor";
    L6:
        NpthLog.d(TAG, "reportJavaEnsure:message:" + r16 + " " + App.getProcessName());
        if (isDropException(r10, r16) == false) goto L10;
        NpthLog.i(TAG, "reportJavaEnsure：isDrop:" + r10 + " " + r16);
        return;
    L10:
        reportReportData(new EnsureReportData(r14, r15, 0, r16, r21, r17, r18, r19, r10, CommonConsts.LOG_REPORT_TYPE_EXCEPTION));
        return;
    L5:
        r10 = r20;
        goto L6
    }

    public void reportJavaEnsure(JSONObject r10, String r11, String r12) {
        String r13 = r10.optString("message");
        if (TextUtils.isEmpty(r12) == false) goto L5;
        r12 = "core_exception_monitor";
    L5:
        String r14 = r12;
        if (isDropException(r14, r13) == false) goto L9;
        NpthLog.i(TAG, "reportJavaEnsure：isDrop:" + r14 + " " + r13);
        return;
    L9:
        reportReportData(new EnsureReportData(r14, r11, null, r10, CommonConsts.LOG_REPORT_TYPE_EXCEPTION));
    }

    public void reportMessage(int r14) {
        if (isDropException("core_exception_monitor", null) == false) goto L5;
        return;
    L5:
        Thread r10 = Thread.currentThread();
        reportReportData(new EnsureReportData(null, r10.getStackTrace(), r14, null, true, null, r10.getName(), ENSURE_NOT_REACH_HERE, "core_exception_monitor", CommonConsts.LOG_REPORT_TYPE_EXCEPTION));
    }

    public void reportMessage(String r14, int r15) {
        if (isDropException("core_exception_monitor", r14) == false) goto L6;
        NpthLog.i(TAG, "reportMessage：isDrop:" + r14);
        return;
    L6:
        Thread r10 = Thread.currentThread();
        reportReportData(new EnsureReportData(null, r10.getStackTrace(), r15, r14, true, null, r10.getName(), ENSURE_NOT_REACH_HERE, "core_exception_monitor", CommonConsts.LOG_REPORT_TYPE_EXCEPTION));
    }

    public void reportMessage(String r14, Map<String, String> r15, int r16) {
        if (isDropException("core_exception_monitor", r14) == false) goto L6;
        NpthLog.i(TAG, "reportMessage：isDrop:" + r14);
        return;
    L6:
        Thread r10 = Thread.currentThread();
        reportReportData(new EnsureReportData(null, r10.getStackTrace(), r16, r14, true, r15, r10.getName(), ENSURE_NOT_REACH_HERE, "core_exception_monitor", CommonConsts.LOG_REPORT_TYPE_EXCEPTION));
    }

    public void reportNativeEnsure(String r10, String r11, String r12, String r13, Map<String, String> r14, String r15) {
        if (TextUtils.isEmpty(r15) == false) goto L5;
        r15 = "core_exception_monitor";
    L5:
        String r16 = r15;
        if (isDropException(r16, r13) == false) goto L9;
        NpthLog.i(TAG, "reportNativeEnsure：isDrop:" + r16 + " " + r13);
        return;
    L9:
        reportReportData(new EnsureReportData(r11, r10, r13, r14, r12, r16, "native_exception", Process.myPid()));
    }

    public void reportNativeEnsure(JSONObject r10, String r11, String r12, String r13) {
        if (TextUtils.isEmpty(r13) == false) goto L5;
        r13 = "core_exception_monitor";
    L5:
        String r14 = r13;
        String r15 = r10.optString("message");
        if (isDropException(r14, r15) == false) goto L9;
        NpthLog.i(TAG, "reportNativeEnsure：isDrop:" + r14 + " " + r15);
        return;
    L9:
        reportReportData(new EnsureReportData(r14, r12, r11, r10, "native_exception"));
    }

    public void reportThrowable(String r11, Map<String, String> r12, Throwable r13, String r14) {
        reportJavaEnsure(r13, null, r11, r12, Thread.currentThread().getName(), ENSURE_NOT_REACH_HERE, r14, true);
    }

    public void reportThrowable(Throwable r10) {
        if (isDropException("core_exception_monitor", null) == false) goto L6;
        NpthLog.i(TAG, "reportThrowable：isDrop:");
        return;
    L6:
        reportThrowable(null, null, r10, "core_exception_monitor");
    }

    public void reportThrowable(Throwable r10, String r11) {
        reportThrowable(r11, null, r10, "core_exception_monitor");
    }

    public void reportThrowable(Throwable r10, String r11, String r12) {
        reportThrowable(r11, null, r10, r12);
    }

    public void reportThrowable(Throwable r10, String r11, Map<String, String> r12) {
        reportThrowable(r11, r12, r10, "core_exception_monitor");
    }

    public void reportThrowable(Throwable r11, String r12, boolean r13) {
        reportJavaEnsure(r11, null, r12, null, Thread.currentThread().getName(), ENSURE_NOT_REACH_HERE, "core_exception_monitor", r13);
    }

    @Override // java.lang.Runnable
    public void run() {
        NpthLog.d(TAG, "run:" + App.getCurProcessName(Global.getContext()) + " " + this.monitor.getAppId());
        cacheToQueue();
        upload();
        DefaultWorkThread.postDelayed(this, WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS);
    }

    public void setMonitor(EventMonitor r10) {
        this.monitor = r10;
    }

    public void updateConfig(EnsureConfig r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        NpthLog.i(TAG, "updateConfig :" + this.monitor.getAppId() + " :" + r10);
        this.config = r10;
        DefaultWorkThread.removeCallbacks(this);
        DefaultWorkThread.post(new AnonymousClass1(this));
        DefaultWorkThread.postDelayed(this, WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS);
    }
}
