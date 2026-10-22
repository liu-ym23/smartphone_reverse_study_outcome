package com.bytedance.crash.event;

import android.os.Process;
import android.text.TextUtils;
import androidx.work.WorkRequest;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.Global;
import com.bytedance.crash.config.NetConfig;
import com.bytedance.crash.config.RuntimeConfig;
import com.bytedance.crash.constants.Constants;
import com.bytedance.crash.dumper.SdkInfo;
import com.bytedance.crash.entity.CrashBody;
import com.bytedance.crash.entity.Header;
import com.bytedance.crash.jni.NativeBridge;
import com.bytedance.crash.monitor.MonitorManager;
import com.bytedance.crash.runtime.DefaultWorkThread;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.bytedance.crash.upload.CrashUploader;
import com.bytedance.crash.upload.UploaderUrl;
import com.bytedance.crash.util.App;
import com.bytedance.crash.util.Digest;
import com.bytedance.crash.util.JSONUtils;
import com.bytedance.crash.util.NpthLog;
import com.bytedance.crash.util.Stack;
import com.obric.aikernel.request.track.ApiPerfDetails;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class BizExceptionManager implements Runnable {
    private static final int DELAY_CHECK = 30000;
    private static final int MAX_COUNT = 90;
    private static final int SINGLE_LOG_TYPE_MAX_COUNT = 10;
    private static String TAG = "BizExceptionManager";
    private static final int TRIGGER_UPLOAD_COUNT = 30;
    private static BizExceptionManager sInstance;
    private long configTimeStamp;
    private ConcurrentHashMap<String, Integer> mAlreadyUploadCounts;
    private final LinkedList<CacheException> mCacheExceptions;
    private BizExceptionConfig mConfig;
    private LinkedList<CacheException> mReportException;

    private static class CacheException {
        private Map<String, String> customData;
        private Map<String, String> filters;
        private String logType;
        private String message;
        private String threadName;
        private Throwable throwable;
        private long timeStamp;

        public CacheException(String r10, Throwable r11, String r12, String r13, Map<String, String> r14, Map<String, String> r15) {
            this.logType = r10;
            this.throwable = r11;
            this.message = r12;
            this.filters = r14;
            this.threadName = r13;
            this.timeStamp = System.currentTimeMillis();
            this.customData = r15;
        }

        static /* synthetic */ String access$000(CacheException r10) {
            return r10.logType;
        }

        static /* synthetic */ String access$100(CacheException r10) {
            return r10.message;
        }

        JSONObject toJSONObject(Header r10) {
            JSONObject r11 = new JSONObject();
            String r12 = Stack.getExceptionStack(this.throwable);
            r11.put(Constants.EVENT_TYPE, "biz_exception");     // Catch: Exception -> L40
            r11.put("crash_time", this.timeStamp);     // Catch: Exception -> L40
            r11.put("biz_exception_type", this.logType);     // Catch: Exception -> L40
            r11.put("app_start_time", Global.getAppStartTime());     // Catch: Exception -> L40
            r11.put("timestamp", this.timeStamp);     // Catch: Exception -> L40
            r11.put("crash_md5", Digest.getMD5(r12));     // Catch: Exception -> L40
            r11.put("message", this.message);     // Catch: Exception -> L40
            r11.put(CrashBody.CRASH_THREAD_NAME, this.threadName);     // Catch: Exception -> L40
            r11.put("process_name", App.getCurProcessName());     // Catch: Exception -> L40
            r11.put(ApiPerfDetails.exceptionType, 1);     // Catch: Exception -> L40
            r11.put("process_name", App.getProcessName());     // Catch: Exception -> L40
            r11.put("app_start_time", Global.getAppStartTime());     // Catch: Exception -> L40
            r11.put("pid", Process.myPid());     // Catch: Exception -> L40
            StackTraceElement r13 = this.throwable.getStackTrace()[0];     // Catch: Exception -> L40
            r11.put(EnsureReportData.CLASS_REF, r13.getClassName());     // Catch: Exception -> L40
            r11.put(EnsureReportData.METHOD, r13.getMethodName());     // Catch: Exception -> L40
            r11.put(EnsureReportData.LINE_NUM, r13.getLineNumber());     // Catch: Exception -> L40
            r11.put("stack", r12);     // Catch: Exception -> L40
            ActivityLifecycle.loadActivityTrace(r11);     // Catch: Exception -> L40
            ActivityLifecycle.loadActivityTrack(r11);     // Catch: Exception -> L40
            r11.put(Constants.IS_BACKGROUND, ActivityLifecycle.isBackground());     // Catch: Exception -> L40
            SdkInfo.pushTo(r11);     // Catch: Exception -> L40
            JSONObject r14 = new JSONObject();     // Catch: Exception -> L40
            r11.put("filters", r14);     // Catch: Exception -> L40
            Iterator<Map.Entry<String, String>> r15 = this.filters.entrySet().iterator();     // Catch: Exception -> L40
        L5:
            if (r15.hasNext() == false) goto L12;
            Map.Entry<String, String> r16 = r15.next();     // Catch: Exception -> L40
            if (r16.getKey() == null) goto L5;
            if (r16.getValue() == null) goto L5;
            r14.put(r16.getKey(), r16.getValue());     // Catch: Exception -> L40
            goto L5
        L12:
            if (NativeBridge.is64BitRuntime() == false) goto L14;
            String r17 = "true";
        L15:
            JSONUtils.put(r14, "is_64_runtime", r17);     // Catch: Exception -> L40
            String r18 = r10.getJson().optString("cpu_abi");     // Catch: Exception -> L40
            if (TextUtils.isEmpty(r18) == true) goto L18;
            boolean r19 = r18.contains("64");     // Catch: Exception -> L40
            JSONUtils.put(r14, "is_x86_devices", Boolean.valueOf(r18.contains("86")));     // Catch: Exception -> L40
            JSONUtils.put(r14, Constants.IS_64_DEVICES, Boolean.valueOf(r19));     // Catch: Exception -> L40
        L18:
            JSONObject r20 = r11.optJSONObject("custom");     // Catch: Exception -> L40
            if (r20 != null) goto L21;
            r20 = new JSONObject();     // Catch: Exception -> L40
            r11.put("custom", r20);     // Catch: Exception -> L40
        L21:
            Map<String, String> r21 = this.customData;     // Catch: Exception -> L40
            if (r21 == null) goto L32;
            Iterator<Map.Entry<String, String>> r22 = r21.entrySet().iterator();     // Catch: Exception -> L40
        L25:
            if (r22.hasNext() == false) goto L32;
            Map.Entry<String, String> r23 = r22.next();     // Catch: Exception -> L40
            if (r23.getKey() == null) goto L25;
            if (r23.getValue() == null) goto L25;
            r20.put(r23.getKey(), r23.getValue());     // Catch: Exception -> L40
        L32:
            if (MonitorManager.getAppMonitor() == null) goto L42;
            Map<String, String> r24 = MonitorManager.getAppMonitor().getUserDataCenter().getAttachUserDataToMap(CrashType.ENSURE);     // Catch: Exception -> L40
            if (r24 == null) goto L42;
            Iterator<Map.Entry<String, String>> r25 = r24.entrySet().iterator();     // Catch: Exception -> L40
        L36:
            if (r25.hasNext() == false) goto L42;
            Map.Entry<String, String> r26 = r25.next();     // Catch: Exception -> L40
            r20.put(r26.getKey(), r26.getValue());     // Catch: Exception -> L40
        L42:
            return r11;
        L14:
            r17 = "false";
        L40:
            e = move-exception;
            NpthLog.e(BizExceptionManager.access$200(), e);
            goto L42
        }
    }

    static {
        sInstance = new BizExceptionManager();
    }

    public BizExceptionManager() {
        this.mCacheExceptions = new LinkedList();
        this.mReportException = new LinkedList();
        this.mAlreadyUploadCounts = new ConcurrentHashMap();
    }

    static /* synthetic */ String access$200() {
        return TAG;
    }

    public static BizExceptionManager getInstance() {
        return sInstance;
    }

    public static boolean isConfigValid() {
        if (sInstance.mConfig != null) goto L6;
        return false;
    L6:
        return true;
    }

    public static boolean isSample(String r10) {
        BizExceptionConfig r11 = sInstance.mConfig;
        if (r11 != null) goto L5;
    L11:
        return false;
    L5:
        if (r11.isEnable() == false) goto L11;
        if (sInstance.mConfig.isSampled(r10) == false) goto L11;
        return true;
    }

    private void processCache() {
        if (this.mConfig.isEnable() == true) goto L19;
        LinkedList<CacheException> r10 = this.mCacheExceptions;
        monitor-enter(r10);
        this.mCacheExceptions.clear();     // Catch: Throwable -> L16
        monitor-exit(r10);     // Catch: Throwable -> L16
        LinkedList<CacheException> r11 = this.mReportException;
        monitor-enter(r11);
        this.mReportException.clear();     // Catch: Throwable -> L13
        monitor-exit(r11);     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        throw th;
    L16:
        th = move-exception;
        throw th;
    L19:
        ArrayList r12 = null;
        LinkedList<CacheException> r13 = this.mCacheExceptions;
        monitor-enter(r13);
    L50:
        th = move-exception;
        throw th;
    L22:
        if (this.mCacheExceptions.size() <= 0) goto L36;
        r12 = new ArrayList();     // Catch: Throwable -> L50
        Iterator<CacheException> r14 = this.mCacheExceptions.iterator();     // Catch: Throwable -> L50
    L25:
        if (r14.hasNext() == false) goto L35;
        CacheException r15 = r14.next();     // Catch: Throwable -> L50
        if (this.mConfig.isSampled(CacheException.access$000(r15)) == true) goto L29;
        if (RuntimeConfig.isDebugMode() == false) goto L25;
        NpthLog.d(TAG, CacheException.access$000(r15) + " message:" + CacheException.access$100(r15) + " is not sample");     // Catch: Throwable -> L50
        goto L25
    L29:
        if (RuntimeConfig.isDebugMode() == false) goto L31;
        NpthLog.d(TAG, CacheException.access$000(r15) + " message:" + CacheException.access$100(r15) + " is sample");     // Catch: Throwable -> L50
    L31:
        r12.add(r15);     // Catch: Throwable -> L50
        goto L25
    L35:
        this.mCacheExceptions.clear();     // Catch: Throwable -> L50
    L36:
        monitor-exit(r13);     // Catch: Throwable -> L50
        if (r12 == null) goto L47;
        LinkedList<CacheException> r16 = this.mReportException;
        monitor-enter(r16);
        this.mReportException.addAll(r12);     // Catch: Throwable -> L43
        monitor-exit(r16);     // Catch: Throwable -> L43
    L43:
        th = move-exception;
        throw th;
    L47:
        if (RuntimeConfig.isDebugMode() == false) goto L69;
        NpthLog.d(TAG, "report exception size:" + this.mReportException.size());
        return;
    }

    public void reportException(String r10, Throwable r11, String r12, Map<String, String> r13, Map<String, String> r14, boolean r15) {
        if (r15 == true) goto L10;
        Integer r16 = this.mAlreadyUploadCounts.get(r10);
        if (r16 != null) goto L7;
        this.mAlreadyUploadCounts.put(r10, 1);
        goto L10
    L7:
        if (r16.intValue() <= 10) goto L9;
        return;
    L9:
        this.mAlreadyUploadCounts.put(r10, Integer.valueOf(r16.intValue() + 1));
    L10:
        BizExceptionConfig r17 = this.mConfig;
        if (r17 != null) goto L27;
        LinkedList<CacheException> r18 = this.mCacheExceptions;
        monitor-enter(r18);
    L23:
        th = move-exception;
        throw th;
    L15:
        if (this.mCacheExceptions.size() < 90) goto L17;
        this.mCacheExceptions.removeFirst();     // Catch: Throwable -> L23
    L17:
        this.mCacheExceptions.add(new CacheException(r10, r11, r12, Thread.currentThread().getName(), r13, r14));     // Catch: Throwable -> L23
        monitor-exit(r18);     // Catch: Throwable -> L23
        if (RuntimeConfig.isDebugMode() == false) goto L64;
        NpthLog.d(TAG, "config is not fetch:logType:" + r10 + " message:" + r12);
        return;
    L64:
        return;
    L27:
        if (r17.isEnable() == true) goto L33;
        if (RuntimeConfig.isDebugMode() == false) goto L65;
        NpthLog.d(TAG, "enable_upload is not enable:" + r10 + " message:" + r12);
        return;
    L65:
        return;
    L33:
        if (this.mConfig.isSampled(r10) == true) goto L39;
        if (RuntimeConfig.isDebugMode() == false) goto L66;
        NpthLog.d(TAG, r10 + " message:" + r12 + " is not sample");
        return;
    L66:
        return;
    L39:
        if (RuntimeConfig.isDebugMode() == false) goto L41;
        NpthLog.d(TAG, r10 + " message:" + r12 + " is sample");
    L41:
        processCache();
        LinkedList<CacheException> r19 = this.mReportException;
        monitor-enter(r19);
        this.mReportException.add(new CacheException(r10, r11, r12, Thread.currentThread().getName(), r13, r14));     // Catch: Throwable -> L55
        monitor-exit(r19);     // Catch: Throwable -> L55
        LinkedList<CacheException> r110 = this.mReportException;
        monitor-enter(r110);
    L52:
        th = move-exception;
        throw th;
    L48:
        if (this.mReportException.size() < 30) goto L50;
        DefaultWorkThread.post(new AnonymousClass1(this));     // Catch: Throwable -> L52
    L50:
        monitor-exit(r110);     // Catch: Throwable -> L52
        return;
    L55:
        th = move-exception;
        throw th;
    }

    @Override // java.lang.Runnable
    public void run() {
        processCache();
        upload();
        DefaultWorkThread.postDelayed(this, WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS);
    }

    public void setConfig(BizExceptionConfig r10) {
        if (RuntimeConfig.isDebugMode() == false) goto L5;
        NpthLog.i(TAG, "setConfig:" + r10);
    L5:
        if (r10 != null) goto L14;
        LinkedList<CacheException> r11 = this.mCacheExceptions;
        monitor-enter(r11);
        this.mCacheExceptions.clear();     // Catch: Throwable -> L11
        monitor-exit(r11);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    L14:
        this.configTimeStamp = System.currentTimeMillis();
        sInstance.mConfig = r10;
        if (this.mConfig.isEnable() == true) goto L32;
        LinkedList<CacheException> r12 = this.mCacheExceptions;
        monitor-enter(r12);
        this.mCacheExceptions.clear();     // Catch: Throwable -> L29
        monitor-exit(r12);     // Catch: Throwable -> L29
        LinkedList<CacheException> r13 = this.mReportException;
        monitor-enter(r13);
        this.mReportException.clear();     // Catch: Throwable -> L26
        monitor-exit(r13);     // Catch: Throwable -> L26
        DefaultWorkThread.removeCallbacks(this);
        return;
    L26:
        th = move-exception;
        throw th;
    L29:
        th = move-exception;
        throw th;
    L32:
        DefaultWorkThread.removeCallbacks(this);
        DefaultWorkThread.postDelayed(this, WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS);
        processCache();
        upload();
    }

    public void upload() {
        if (RuntimeConfig.isDebugMode() == false) goto L5;
        NpthLog.d(TAG, "upload");
    L5:
        LinkedList<CacheException> r10 = this.mReportException;
        monitor-enter(r10);
    L40:
        th = move-exception;
        throw th;
    L8:
        if (this.mReportException.isEmpty() == false) goto L11;
        monitor-exit(r10);     // Catch: Throwable -> L40
        return;
    L11:
        ArrayList r11 = new ArrayList();     // Catch: Throwable -> L40
        int r12 = 0;
    L13:
        if (this.mReportException.isEmpty() == true) goto L18;
        if (r12 > 30) goto L18;
        r12 = r12 + 1;     // Catch: Throwable -> L40
        r11.add(this.mReportException.remove(0));     // Catch: Throwable -> L40
    L18:
        monitor-exit(r10);     // Catch: Throwable -> L40
        if (r11.size() != 0) goto L22;
        return;
    L22:
        int r13 = Process.myPid();
        Header r14 = Header.createEventHeader(MonitorManager.getAppMonitor(), System.currentTimeMillis(), CrashType.ENSURE, r13);
        HashSet r15 = null;
        if (RuntimeConfig.isDebugMode() == false) goto L26;
        r15 = new HashSet();     // Catch: Throwable -> L43
    L26:
        JSONArray r16 = new JSONArray();     // Catch: Throwable -> L43
        Iterator r17 = r11.iterator();     // Catch: Throwable -> L43
    L28:
        if (r17.hasNext() == false) goto L33;
        CacheException r18 = (CacheException) r17.next();     // Catch: Throwable -> L43
        JSONObject r19 = r18.toJSONObject(r14);     // Catch: Throwable -> L43
        if (r15 == null) goto L32;
        r15.add(CacheException.access$000(r18));     // Catch: Throwable -> L43
    L32:
        r16.put(r19);     // Catch: Throwable -> L43
        goto L28
    L33:
        JSONObject r20 = new JSONObject();     // Catch: Throwable -> L43
        r20.put("data", r16);     // Catch: Throwable -> L43
        JSONObject r21 = r14.getJson();     // Catch: Throwable -> L43
        r20.put("header", r21);     // Catch: Throwable -> L43
        if (RuntimeConfig.isDebugMode() == false) goto L36;
        NpthLog.d(TAG, "start upload:" + r15);     // Catch: Throwable -> L43
    L36:
        String r22 = UploaderUrl.appendUrlParamsByHeader(NetConfig.getBizExceptionUploadUrl(), r21);     // Catch: Throwable -> L43
        boolean r23 = CrashUploader.uploadEvent(r22, r20);     // Catch: Throwable -> L43
        if (RuntimeConfig.isDebugMode() == false) goto L52;
        NpthLog.d(TAG, "end upload:" + r22 + " " + r23);     // Catch: Throwable -> L43
        return;
    L52:
        return;
    }
}
