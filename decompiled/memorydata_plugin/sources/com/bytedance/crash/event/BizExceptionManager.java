package com.bytedance.crash.event;

import android.os.Process;
import android.text.TextUtils;
import com.bytedance.bdlocation.exception.BDLocationException;
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
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
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

        public CacheException(String r3, Throwable r4, String r5, String r6, Map<String, String> r7, Map<String, String> r8) {
            Map<String, String> r9 = (Map) ZeusTransformUtils.wrapperContextForParams(r7, Map.class, "com.obric.memorydata.plugin");
            Map<String, String> r10 = (Map) ZeusTransformUtils.wrapperContextForParams(r8, Map.class, "com.obric.memorydata.plugin");
            this.logType = r3;
            this.throwable = r4;
            this.message = r5;
            this.filters = r9;
            this.threadName = r6;
            this.timeStamp = System.currentTimeMillis();
            this.customData = r10;
        }

        static /* synthetic */ String access$000(CacheException r0) {
            return r0.logType;
        }

        static /* synthetic */ String access$100(CacheException r0) {
            return r0.message;
        }

        JSONObject toJSONObject(Header r9) {
            JSONObject r3 = new JSONObject();
            String r4 = Stack.getExceptionStack(this.throwable);
            r3.put(Constants.EVENT_TYPE, "biz_exception");     // Catch: Exception -> L41
            r3.put("crash_time", this.timeStamp);     // Catch: Exception -> L41
            r3.put("biz_exception_type", this.logType);     // Catch: Exception -> L41
            r3.put("app_start_time", Global.getAppStartTime());     // Catch: Exception -> L41
            r3.put("timestamp", this.timeStamp);     // Catch: Exception -> L41
            r3.put("crash_md5", Digest.getMD5(r4));     // Catch: Exception -> L41
            r3.put("message", this.message);     // Catch: Exception -> L41
            r3.put(CrashBody.CRASH_THREAD_NAME, this.threadName);     // Catch: Exception -> L41
            r3.put("process_name", App.getCurProcessName());     // Catch: Exception -> L41
            r3.put(ApiPerfDetails.exceptionType, 1);     // Catch: Exception -> L41
            r3.put("process_name", App.getProcessName());     // Catch: Exception -> L41
            r3.put("app_start_time", Global.getAppStartTime());     // Catch: Exception -> L41
            r3.put(CrashBody.PID, Process.myPid());     // Catch: Exception -> L41
            StackTraceElement r1 = this.throwable.getStackTrace()[0];     // Catch: Exception -> L41
            r3.put(EnsureReportData.CLASS_REF, r1.getClassName());     // Catch: Exception -> L41
            r3.put("method", r1.getMethodName());     // Catch: Exception -> L41
            r3.put(EnsureReportData.LINE_NUM, r1.getLineNumber());     // Catch: Exception -> L41
            r3.put("stack", r4);     // Catch: Exception -> L41
            ActivityLifecycle.loadActivityTrace(r3);     // Catch: Exception -> L41
            ActivityLifecycle.loadActivityTrack(r3);     // Catch: Exception -> L41
            r3.put("is_background", ActivityLifecycle.isBackground());     // Catch: Exception -> L41
            SdkInfo.pushTo(r3);     // Catch: Exception -> L41
            JSONObject r2 = new JSONObject();     // Catch: Exception -> L41
            r3.put("filters", r2);     // Catch: Exception -> L41
            Iterator<Map.Entry<String, String>> r5 = this.filters.entrySet().iterator();     // Catch: Exception -> L41
        L6:
            if (r5.hasNext() == false) goto L13;
            Map.Entry r6 = (Map.Entry) ZeusTransformUtils.preCheckCast(r5.next(), Map.Entry.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L41
            if (r6.getKey() == null) goto L6;
            if (r6.getValue() == null) goto L6;
            r2.put((String) ZeusTransformUtils.preCheckCast(r6.getKey(), String.class, "com.obric.memorydata.plugin"), r6.getValue());     // Catch: Exception -> L41
            goto L6
        L13:
            if (NativeBridge.is64BitRuntime() == false) goto L15;
            String r7 = "true";
        L16:
            JSONUtils.put(r2, "is_64_runtime", r7);     // Catch: Exception -> L41
            String r10 = r9.getJson().optString("cpu_abi");     // Catch: Exception -> L41
            if (TextUtils.isEmpty(r10) == true) goto L19;
            boolean r8 = r10.contains(BDLocationException.ERROR_RESTRICTED_MODE_ON);     // Catch: Exception -> L41
            JSONUtils.put(r2, "is_x86_devices", Boolean.valueOf(r10.contains(BDLocationException.ERROR_DEVICE_LOCATION_DISABLE)));     // Catch: Exception -> L41
            JSONUtils.put(r2, Constants.IS_64_DEVICES, Boolean.valueOf(r8));     // Catch: Exception -> L41
        L19:
            JSONObject r11 = r3.optJSONObject("custom");     // Catch: Exception -> L41
            if (r11 != null) goto L22;
            r11 = new JSONObject();     // Catch: Exception -> L41
            r3.put("custom", r11);     // Catch: Exception -> L41
        L22:
            Map<String, String> r12 = this.customData;     // Catch: Exception -> L41
            if (r12 == null) goto L33;
            Iterator<Map.Entry<String, String>> r13 = r12.entrySet().iterator();     // Catch: Exception -> L41
        L26:
            if (r13.hasNext() == false) goto L33;
            Map.Entry r0 = (Map.Entry) ZeusTransformUtils.preCheckCast(r13.next(), Map.Entry.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L41
            if (r0.getKey() == null) goto L26;
            if (r0.getValue() == null) goto L26;
            r11.put((String) ZeusTransformUtils.preCheckCast(r0.getKey(), String.class, "com.obric.memorydata.plugin"), r0.getValue());     // Catch: Exception -> L41
        L33:
            if (MonitorManager.getAppMonitor() == null) goto L43;
            Map<String, String> r14 = MonitorManager.getAppMonitor().getUserDataCenter().getAttachUserDataToMap(CrashType.ENSURE);     // Catch: Exception -> L41
            if (r14 == null) goto L43;
            Iterator<Map.Entry<String, String>> r15 = r14.entrySet().iterator();     // Catch: Exception -> L41
        L37:
            if (r15.hasNext() == false) goto L43;
            Map.Entry r16 = (Map.Entry) ZeusTransformUtils.preCheckCast(r15.next(), Map.Entry.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L41
            r11.put((String) ZeusTransformUtils.preCheckCast(r16.getKey(), String.class, "com.obric.memorydata.plugin"), r16.getValue());     // Catch: Exception -> L41
        L43:
            return r3;
        L15:
            r7 = "false";
        L41:
            e = move-exception;
            NpthLog.e(BizExceptionManager.access$200(), e);
            goto L43
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

    public static boolean isSample(String r2) {
        BizExceptionConfig r0 = sInstance.mConfig;
        if (r0 != null) goto L5;
    L11:
        return false;
    L5:
        if (r0.isEnable() == false) goto L11;
        if (sInstance.mConfig.isSampled(r2) == false) goto L11;
        return true;
    }

    private void processCache() {
        if (this.mConfig.isEnable() == true) goto L19;
        LinkedList<CacheException> r0 = this.mCacheExceptions;
        monitor-enter(r0);
        this.mCacheExceptions.clear();     // Catch: Throwable -> L16
        monitor-exit(r0);     // Catch: Throwable -> L16
        LinkedList<CacheException> r1 = this.mReportException;
        monitor-enter(r1);
        this.mReportException.clear();     // Catch: Throwable -> L13
        monitor-exit(r1);     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        throw th;
    L16:
        th = move-exception;
        throw th;
    L19:
        ArrayList r2 = null;
        LinkedList<CacheException> r3 = this.mCacheExceptions;
        monitor-enter(r3);
    L50:
        th = move-exception;
        throw th;
    L22:
        if (this.mCacheExceptions.size() <= 0) goto L36;
        r2 = new ArrayList();     // Catch: Throwable -> L50
        Iterator<CacheException> r4 = this.mCacheExceptions.iterator();     // Catch: Throwable -> L50
    L25:
        if (r4.hasNext() == false) goto L35;
        CacheException r5 = (CacheException) ZeusTransformUtils.preCheckCast(r4.next(), CacheException.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L50
        if (this.mConfig.isSampled(CacheException.access$000(r5)) == true) goto L29;
        if (RuntimeConfig.isDebugMode() == false) goto L25;
        NpthLog.d(TAG, CacheException.access$000(r5) + " message:" + CacheException.access$100(r5) + " is not sample");     // Catch: Throwable -> L50
        goto L25
    L29:
        if (RuntimeConfig.isDebugMode() == false) goto L31;
        NpthLog.d(TAG, CacheException.access$000(r5) + " message:" + CacheException.access$100(r5) + " is sample");     // Catch: Throwable -> L50
    L31:
        r2.add(r5);     // Catch: Throwable -> L50
        goto L25
    L35:
        this.mCacheExceptions.clear();     // Catch: Throwable -> L50
    L36:
        monitor-exit(r3);     // Catch: Throwable -> L50
        if (r2 == null) goto L47;
        LinkedList<CacheException> r6 = this.mReportException;
        monitor-enter(r6);
        this.mReportException.addAll(r2);     // Catch: Throwable -> L43
        monitor-exit(r6);     // Catch: Throwable -> L43
    L43:
        th = move-exception;
        throw th;
    L47:
        if (RuntimeConfig.isDebugMode() == false) goto L69;
        NpthLog.d(TAG, "report exception size:" + this.mReportException.size());
        return;
    }

    public void reportException(String r8, Throwable r9, String r10, Map<String, String> r11, Map<String, String> r12, boolean r13) {
        Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r11, Map.class, "com.obric.memorydata.plugin");
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r12, Map.class, "com.obric.memorydata.plugin");
        if (r13 == true) goto L11;
        Integer r14 = (Integer) ZeusTransformUtils.preCheckCast(this.mAlreadyUploadCounts.get(r8), Integer.class, "com.obric.memorydata.plugin");
        if (r14 != null) goto L8;
        this.mAlreadyUploadCounts.put(r8, 1);
        goto L11
    L8:
        if (r14.intValue() <= 10) goto L10;
        return;
    L10:
        this.mAlreadyUploadCounts.put(r8, Integer.valueOf(r14.intValue() + 1));
    L11:
        BizExceptionConfig r15 = this.mConfig;
        if (r15 != null) goto L28;
        LinkedList<CacheException> r16 = this.mCacheExceptions;
        monitor-enter(r16);
    L24:
        th = move-exception;
        throw th;
    L16:
        if (this.mCacheExceptions.size() < 90) goto L18;
        this.mCacheExceptions.removeFirst();     // Catch: Throwable -> L24
    L18:
        this.mCacheExceptions.add(new CacheException(r8, r9, r10, Thread.currentThread().getName(), r5, r6));     // Catch: Throwable -> L24
        monitor-exit(r16);     // Catch: Throwable -> L24
        if (RuntimeConfig.isDebugMode() == false) goto L65;
        NpthLog.d(TAG, "config is not fetch:logType:" + r8 + " message:" + r10);
        return;
    L65:
        return;
    L28:
        if (r15.isEnable() == true) goto L34;
        if (RuntimeConfig.isDebugMode() == false) goto L66;
        NpthLog.d(TAG, "enable_upload is not enable:" + r8 + " message:" + r10);
        return;
    L66:
        return;
    L34:
        if (this.mConfig.isSampled(r8) == true) goto L40;
        if (RuntimeConfig.isDebugMode() == false) goto L67;
        NpthLog.d(TAG, r8 + " message:" + r10 + " is not sample");
        return;
    L67:
        return;
    L40:
        if (RuntimeConfig.isDebugMode() == false) goto L42;
        NpthLog.d(TAG, r8 + " message:" + r10 + " is sample");
    L42:
        processCache();
        LinkedList<CacheException> r17 = this.mReportException;
        monitor-enter(r17);
        this.mReportException.add(new CacheException(r8, r9, r10, Thread.currentThread().getName(), r5, r6));     // Catch: Throwable -> L56
        monitor-exit(r17);     // Catch: Throwable -> L56
        LinkedList<CacheException> r18 = this.mReportException;
        monitor-enter(r18);
    L53:
        th = move-exception;
        throw th;
    L49:
        if (this.mReportException.size() < 30) goto L51;
        DefaultWorkThread.post(new AnonymousClass1(this));     // Catch: Throwable -> L53
    L51:
        monitor-exit(r18);     // Catch: Throwable -> L53
        return;
    L56:
        th = move-exception;
        throw th;
    }

    @Override // java.lang.Runnable
    public void run() {
        processCache();
        upload();
        DefaultWorkThread.postDelayed(this, 30000);
    }

    public void setConfig(BizExceptionConfig r4) {
        if (RuntimeConfig.isDebugMode() == false) goto L5;
        NpthLog.i(TAG, "setConfig:" + r4);
    L5:
        if (r4 != null) goto L14;
        LinkedList<CacheException> r0 = this.mCacheExceptions;
        monitor-enter(r0);
        this.mCacheExceptions.clear();     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    L14:
        this.configTimeStamp = System.currentTimeMillis();
        sInstance.mConfig = r4;
        if (this.mConfig.isEnable() == true) goto L32;
        LinkedList<CacheException> r5 = this.mCacheExceptions;
        monitor-enter(r5);
        this.mCacheExceptions.clear();     // Catch: Throwable -> L29
        monitor-exit(r5);     // Catch: Throwable -> L29
        LinkedList<CacheException> r1 = this.mReportException;
        monitor-enter(r1);
        this.mReportException.clear();     // Catch: Throwable -> L26
        monitor-exit(r1);     // Catch: Throwable -> L26
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
        DefaultWorkThread.postDelayed(this, 30000);
        processCache();
        upload();
    }

    public void upload() {
        if (RuntimeConfig.isDebugMode() == false) goto L5;
        NpthLog.d(TAG, "upload");
    L5:
        LinkedList<CacheException> r0 = this.mReportException;
        monitor-enter(r0);
    L40:
        th = move-exception;
        throw th;
    L8:
        if (this.mReportException.isEmpty() == false) goto L11;
        monitor-exit(r0);     // Catch: Throwable -> L40
        return;
    L11:
        ArrayList r1 = new ArrayList();     // Catch: Throwable -> L40
        int r3 = 0;
    L13:
        if (this.mReportException.isEmpty() == true) goto L18;
        if (r3 > 30) goto L18;
        r3 = r3 + 1;     // Catch: Throwable -> L40
        r1.add(this.mReportException.remove(0));     // Catch: Throwable -> L40
    L18:
        monitor-exit(r0);     // Catch: Throwable -> L40
        if (r1.size() != 0) goto L22;
        return;
    L22:
        int r6 = Process.myPid();
        Header r7 = Header.createEventHeader(MonitorManager.getAppMonitor(), System.currentTimeMillis(), CrashType.ENSURE, r6);
        HashSet r2 = null;
        if (RuntimeConfig.isDebugMode() == false) goto L26;
        r2 = new HashSet();     // Catch: Throwable -> L43
    L26:
        JSONArray r4 = new JSONArray();     // Catch: Throwable -> L43
        Iterator r5 = r1.iterator();     // Catch: Throwable -> L43
    L28:
        if (r5.hasNext() == false) goto L33;
        CacheException r8 = (CacheException) ZeusTransformUtils.preCheckCast(r5.next(), CacheException.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L43
        JSONObject r9 = r8.toJSONObject(r7);     // Catch: Throwable -> L43
        if (r2 == null) goto L32;
        r2.add(CacheException.access$000(r8));     // Catch: Throwable -> L43
    L32:
        r4.put(r9);     // Catch: Throwable -> L43
        goto L28
    L33:
        JSONObject r10 = new JSONObject();     // Catch: Throwable -> L43
        r10.put("data", r4);     // Catch: Throwable -> L43
        JSONObject r11 = r7.getJson();     // Catch: Throwable -> L43
        r10.put("header", r11);     // Catch: Throwable -> L43
        if (RuntimeConfig.isDebugMode() == false) goto L36;
        NpthLog.d(TAG, "start upload:" + r2);     // Catch: Throwable -> L43
    L36:
        String r12 = UploaderUrl.appendUrlParamsByHeader(NetConfig.getBizExceptionUploadUrl(), r11);     // Catch: Throwable -> L43
        boolean r13 = CrashUploader.uploadEvent(r12, r10);     // Catch: Throwable -> L43
        if (RuntimeConfig.isDebugMode() == false) goto L52;
        NpthLog.d(TAG, "end upload:" + r12 + " " + r13);     // Catch: Throwable -> L43
        return;
    L52:
        return;
    }
}
