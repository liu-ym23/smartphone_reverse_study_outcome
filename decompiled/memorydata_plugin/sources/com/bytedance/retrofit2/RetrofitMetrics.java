package com.bytedance.retrofit2;

import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.bdlocation.monitor.LBSLightLocationTraceLogger;
import com.bytedance.crash.service.INetworkCallback;
import com.bytedance.retrofit2.intercept.Interceptor;
import com.bytedance.retrofit2.ttnet.TTInternalInterceptor;
import com.bytedance.retrofit2.ttnet.TTNetExceptionStorage;
import com.obric.capabilitykit.common.Ext;
import com.obric.memorydata.database.entity.ChatMessage;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class RetrofitMetrics {
    private static volatile Handler HANDLER = null;
    private static HandlerThread HANDLER_THREAD = null;
    public static final int REPORT_ALL_DETAILS = -1;
    private static volatile AsyncLogReporter logReporter = null;
    public static AppLaunchTimeStampProvider sAppStartTimeProvider = null;
    private static volatile boolean sReportNewMetrics = false;
    private static IRequestLogReporterBridge sRequestLogReporterBridge = null;
    private static volatile boolean sSyncReport = false;

    @Deprecated
    public long addClientKeyDuration;

    @Deprecated
    public long addCommonParamDuration;

    @Deprecated
    public long appCreateRetrofitStart;

    @Deprecated
    public long appCreateRetrofitStartUpTime;

    @Deprecated
    public long appLevelRequestStart;
    public long asyncDelayCount;

    @Deprecated
    public long beforeAllInterceptors;
    public Map<String, Object> bizExtraInfo;

    @Deprecated
    public int blockingQueueSize;

    @Deprecated
    public long bodyEncryptDuration;

    @Deprecated
    public long callExecuteStartTime;

    @Deprecated
    public long callServerInterceptorTime;

    @Deprecated
    public long checkReqTicketDuration;

    @Deprecated
    public long commandListenerDuration;
    public JSONObject concurrentRequest;

    @Deprecated
    public long createSsHttpCallTime;
    public long delayStartTimeStamp;
    public int delayState;
    public String delayStateName;
    public boolean delayedWithState;
    public JSONArray dispatchQueryActionInfo;

    @Deprecated
    public long encryptRequestDuration;

    @Deprecated
    public long enqueueCallbackEndTime;

    @Deprecated
    public long enqueueCallbackStartTime;

    @Deprecated
    public long enqueueTime;

    @Deprecated
    public long executeCallEndTime;

    @Deprecated
    public long executeCallStartTime;

    @Deprecated
    public long executeEndTime;

    @Deprecated
    public long executeTime;

    @Deprecated
    public Map<String, Long> extra;
    public String fallbackMessage;
    public int fallbackReason;

    @Deprecated
    public long filterDupQueryDuration;

    @Deprecated
    public long filterUrlDuration;

    @Deprecated
    public long genReqTicketDuration;
    private boolean hasNetworkKernelLog;
    private boolean hasRetrofitLog;

    @Deprecated
    public List<InterceptorInfo> interceptorRequestInfos;

    @Deprecated
    public List<InterceptorInfo> interceptorResponseInfos;

    @Deprecated
    public transient Throwable interceptorResponseThrowable;
    public boolean isConcurrent;
    public boolean isResponseStreaming;
    public NetworkLibLayerMetrics networklib;

    @Deprecated
    public long openConnectionDuration;
    public int postBodyBufferSize;

    @Deprecated
    public long postCdnCacheVerifyDuration;

    @Deprecated
    public long preCdnCacheVerifyDuration;

    @Deprecated
    public long prepareRequestDuration;
    public int priorityLevel;

    @Deprecated
    public long queryFilterDuration;
    public long randomSendTime;
    private boolean readingResponseBody;
    public JSONObject requestCompressInfo;
    public String requestCompressType;

    @Deprecated
    public int requestCookieSourceType;
    private EncryptType requestEncryptType;
    public String requestFallbackMessage;
    public int requestFallbackReason;
    public transient WeakReference<LegacyLogRecorder> requestInfo;

    @Deprecated
    public Map<String, Long> requestInterceptDuration;
    public int requestPriorityLevel;

    @Deprecated
    public long requestVerifyDuration;

    @Deprecated
    public long responseChainTime;
    public String responseCompressType;
    public boolean responseConvertSuccess;

    @Deprecated
    public Map<String, Long> responseInterceptDuration;
    public int responseReadType;
    public RetrofitLayerMetrics retrofit;

    @Deprecated
    public long retrofitLogReportTime;

    @Deprecated
    public long retrofitMethodInvokeTime;

    @Deprecated
    public JSONObject rotationHostRetryInfo;

    @Deprecated
    public long setThrottleNetSpeedDuration;
    public long stateDelayTime;
    public int streamParserCopyCount;
    public long syncDelayCount;

    @Deprecated
    public long toRequestEndTime;

    @Deprecated
    public long toRequestStartTime;

    @Deprecated
    public long toResponseEndTime;

    @Deprecated
    public long toResponseStartTime;
    public String traceCode;
    public String transactionId;

    @Deprecated
    public long tryNecessaryInitDuration;
    public String ttnetVersion;

    @Deprecated
    public long updateClientKeyDuration;

    @Deprecated
    public long upperAddCookieDurationUs;

    @Deprecated
    public long upperSaveCookieDurationUs;
    public URL url;

    public static final enum EncryptType extends Enum<EncryptType> {
        private static final /* synthetic */ EncryptType[] $VALUES = null;
        public static final EncryptType ENCRYPT_BODY = null;
        public static final EncryptType ENCRYPT_BOTH_QUERY_AND_BODY = null;
        public static final EncryptType ENCRYPT_NONE = null;
        public static final EncryptType ENCRYPT_QUERY = null;
        final int type;

        static {
            EncryptType r0 = new EncryptType("ENCRYPT_NONE", 0, 0);
            ENCRYPT_NONE = r0;
            EncryptType r1 = new EncryptType("ENCRYPT_QUERY", 1, 1);
            ENCRYPT_QUERY = r1;
            EncryptType r3 = new EncryptType("ENCRYPT_BODY", 2, 2);
            ENCRYPT_BODY = r3;
            EncryptType r5 = new EncryptType("ENCRYPT_BOTH_QUERY_AND_BODY", 3, 3);
            ENCRYPT_BOTH_QUERY_AND_BODY = r5;
            $VALUES = new EncryptType[]{r0, r1, r3, r5};
        }

        private EncryptType(String r1, int r2, int r3) {
            super(r1, r2);
            this.type = r3;
        }

        public static EncryptType valueOf(String r2) {
            return (EncryptType) ZeusTransformUtils.preCheckCast(Enum.valueOf(EncryptType.class, r2), EncryptType.class, "com.obric.memorydata.plugin");
        }

        public static EncryptType[] values() {
            return (EncryptType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), EncryptType[].class, "com.obric.memorydata.plugin");
        }

        public int getValue() {
            return this.type;
        }
    }

    @Deprecated
    public interface ExtraKeys {
        public static final String RECEIVED_BYTE_COUNT = "receivedByteCount";
        public static final String SENT_BYTE_COUNT = "sentByteCount";
        public static final String STREAM_READ_BYTE_COUNT = "streamReadByteCount";
        public static final String STREAM_READ_TIME = "streamReadTime";
    }

    public interface IRequestLogReporterBridge {
        boolean isAllErrorReport();

        void monitorApiError(String r1, Object r2, Throwable r3);

        void monitorApiOk(String r1, Object r2);
    }

    @Deprecated
    public class InterceptorInfo {
        public long end;
        public String exception_name;
        public String name;
        public long start;
        final /* synthetic */ RetrofitMetrics this$0;

        public InterceptorInfo(RetrofitMetrics r1, String r2, long r3) {
            this.this$0 = r1;
            this.exception_name = null;
            this.name = r2;
            this.start = r3;
            this.end = r3;
        }
    }

    static {
    }

    public RetrofitMetrics() {
        this.url = null;
        this.requestInfo = null;
        this.streamParserCopyCount = -1;
        this.responseReadType = -1;
        this.requestEncryptType = EncryptType.ENCRYPT_NONE;
        this.fallbackReason = -1;
        this.fallbackMessage = "";
        this.requestFallbackReason = -1;
        this.requestFallbackMessage = "";
        this.transactionId = "";
        this.isConcurrent = false;
        this.delayState = -1;
        this.delayStateName = null;
        this.stateDelayTime = -1;
        this.syncDelayCount = -1;
        this.asyncDelayCount = -1;
        this.delayStartTimeStamp = -1;
        this.randomSendTime = -1;
        this.interceptorResponseThrowable = null;
        this.requestInterceptDuration = new ConcurrentHashMap();
        this.responseInterceptDuration = new ConcurrentHashMap();
        this.filterUrlDuration = -1;
        this.addCommonParamDuration = -1;
        this.requestVerifyDuration = -1;
        this.filterDupQueryDuration = -1;
        this.encryptRequestDuration = -1;
        this.genReqTicketDuration = -1;
        this.checkReqTicketDuration = -1;
        this.preCdnCacheVerifyDuration = -1;
        this.addClientKeyDuration = -1;
        this.updateClientKeyDuration = -1;
        this.postCdnCacheVerifyDuration = -1;
        this.commandListenerDuration = -1;
        this.queryFilterDuration = -1;
        this.bodyEncryptDuration = -1;
        this.extra = new HashMap();
        this.ttnetVersion = "";
        this.traceCode = "";
        this.responseConvertSuccess = true;
        this.priorityLevel = PriorityLevel.INVALID;
        this.requestPriorityLevel = -1;
        this.responseCompressType = "";
        this.requestCompressType = "";
        this.setThrottleNetSpeedDuration = -1;
        this.tryNecessaryInitDuration = -1;
        this.openConnectionDuration = -1;
        this.prepareRequestDuration = -1;
        this.upperAddCookieDurationUs = -1;
        this.upperSaveCookieDurationUs = -1;
        this.requestCookieSourceType = -1;
        this.bizExtraInfo = new HashMap();
        this.rotationHostRetryInfo = null;
        this.blockingQueueSize = 0;
        this.interceptorRequestInfos = new ArrayList();
        this.interceptorResponseInfos = new ArrayList();
        this.retrofit = new RetrofitLayerMetrics();
        this.networklib = new NetworkLibLayerMetrics();
        this.readingResponseBody = false;
        this.hasNetworkKernelLog = false;
        this.hasRetrofitLog = false;
        new RetrofitMetrics(null);
    }

    public RetrofitMetrics(long r8, long r10) {
        this.url = null;
        this.requestInfo = null;
        this.streamParserCopyCount = -1;
        this.responseReadType = -1;
        this.requestEncryptType = EncryptType.ENCRYPT_NONE;
        this.fallbackReason = -1;
        this.fallbackMessage = "";
        this.requestFallbackReason = -1;
        this.requestFallbackMessage = "";
        this.transactionId = "";
        this.isConcurrent = false;
        this.delayState = -1;
        this.delayStateName = null;
        this.stateDelayTime = -1;
        this.syncDelayCount = -1;
        this.asyncDelayCount = -1;
        this.delayStartTimeStamp = -1;
        this.randomSendTime = -1;
        this.interceptorResponseThrowable = null;
        this.requestInterceptDuration = new ConcurrentHashMap();
        this.responseInterceptDuration = new ConcurrentHashMap();
        this.filterUrlDuration = -1;
        this.addCommonParamDuration = -1;
        this.requestVerifyDuration = -1;
        this.filterDupQueryDuration = -1;
        this.encryptRequestDuration = -1;
        this.genReqTicketDuration = -1;
        this.checkReqTicketDuration = -1;
        this.preCdnCacheVerifyDuration = -1;
        this.addClientKeyDuration = -1;
        this.updateClientKeyDuration = -1;
        this.postCdnCacheVerifyDuration = -1;
        this.commandListenerDuration = -1;
        this.queryFilterDuration = -1;
        this.bodyEncryptDuration = -1;
        this.extra = new HashMap();
        this.ttnetVersion = "";
        this.traceCode = "";
        this.responseConvertSuccess = true;
        this.priorityLevel = PriorityLevel.INVALID;
        this.requestPriorityLevel = -1;
        this.responseCompressType = "";
        this.requestCompressType = "";
        this.setThrottleNetSpeedDuration = -1;
        this.tryNecessaryInitDuration = -1;
        this.openConnectionDuration = -1;
        this.prepareRequestDuration = -1;
        this.upperAddCookieDurationUs = -1;
        this.upperSaveCookieDurationUs = -1;
        this.requestCookieSourceType = -1;
        this.bizExtraInfo = new HashMap();
        this.rotationHostRetryInfo = null;
        this.blockingQueueSize = 0;
        this.interceptorRequestInfos = new ArrayList();
        this.interceptorResponseInfos = new ArrayList();
        this.retrofit = new RetrofitLayerMetrics();
        this.networklib = new NetworkLibLayerMetrics();
        this.readingResponseBody = false;
        this.hasNetworkKernelLog = false;
        this.hasRetrofitLog = false;
        this.appLevelRequestStart = r8;
        this.beforeAllInterceptors = r10;
    }

    public RetrofitMetrics(LegacyLogRecorder r8) {
        LegacyLogRecorder r9 = (LegacyLogRecorder) ZeusTransformUtils.wrapperContextForParams(r8, LegacyLogRecorder.class, "com.obric.memorydata.plugin");
        this.url = null;
        this.requestInfo = null;
        this.streamParserCopyCount = -1;
        this.responseReadType = -1;
        this.requestEncryptType = EncryptType.ENCRYPT_NONE;
        this.fallbackReason = -1;
        this.fallbackMessage = "";
        this.requestFallbackReason = -1;
        this.requestFallbackMessage = "";
        this.transactionId = "";
        this.isConcurrent = false;
        this.delayState = -1;
        this.delayStateName = null;
        this.stateDelayTime = -1;
        this.syncDelayCount = -1;
        this.asyncDelayCount = -1;
        this.delayStartTimeStamp = -1;
        this.randomSendTime = -1;
        this.interceptorResponseThrowable = null;
        this.requestInterceptDuration = new ConcurrentHashMap();
        this.responseInterceptDuration = new ConcurrentHashMap();
        this.filterUrlDuration = -1;
        this.addCommonParamDuration = -1;
        this.requestVerifyDuration = -1;
        this.filterDupQueryDuration = -1;
        this.encryptRequestDuration = -1;
        this.genReqTicketDuration = -1;
        this.checkReqTicketDuration = -1;
        this.preCdnCacheVerifyDuration = -1;
        this.addClientKeyDuration = -1;
        this.updateClientKeyDuration = -1;
        this.postCdnCacheVerifyDuration = -1;
        this.commandListenerDuration = -1;
        this.queryFilterDuration = -1;
        this.bodyEncryptDuration = -1;
        this.extra = new HashMap();
        this.ttnetVersion = "";
        this.traceCode = "";
        this.responseConvertSuccess = true;
        this.priorityLevel = PriorityLevel.INVALID;
        this.requestPriorityLevel = -1;
        this.responseCompressType = "";
        this.requestCompressType = "";
        this.setThrottleNetSpeedDuration = -1;
        this.tryNecessaryInitDuration = -1;
        this.openConnectionDuration = -1;
        this.prepareRequestDuration = -1;
        this.upperAddCookieDurationUs = -1;
        this.upperSaveCookieDurationUs = -1;
        this.requestCookieSourceType = -1;
        this.bizExtraInfo = new HashMap();
        this.rotationHostRetryInfo = null;
        this.blockingQueueSize = 0;
        this.interceptorRequestInfos = new ArrayList();
        this.interceptorResponseInfos = new ArrayList();
        this.retrofit = new RetrofitLayerMetrics();
        this.networklib = new NetworkLibLayerMetrics();
        this.readingResponseBody = false;
        this.hasNetworkKernelLog = false;
        this.hasRetrofitLog = false;
        this.requestInfo = new WeakReference(r9);
    }

    static /* synthetic */ void access$000(RetrofitMetrics r0, Object r1, Throwable r2) {
        r0.doReportRequestLog(r1, r2);
    }

    private void doReportRequestLog(Object r3, Throwable r4) {
        URL r0 = this.url;
        if (r0 == null) goto L5;
        String r1 = r0.toString();
    L6:
        if (r4 != null) goto L9;
    L7:
        sRequestLogReporterBridge.monitorApiOk(r1, r3);
        return;
    L9:
        if (ZeusTransformUtils.instanceOf(r4, TTNetExceptionStorage.class) == false) goto L17;
        TTNetExceptionStorage r2 = (TTNetExceptionStorage) ZeusTransformUtils.preCheckCast(r4, TTNetExceptionStorage.class, "com.obric.memorydata.plugin");
        if (r2.reportMonitorOk == false) goto L14;
        sRequestLogReporterBridge.monitorApiOk(r1, r3);
    L14:
        if (r2.reportMonitorError == false) goto L24;
    L21:
        sRequestLogReporterBridge.monitorApiError(r1, r3, r4);
        return;
    L24:
        return;
    L17:
        if (this.retrofit.misc.executeSsCallSuccess == false) goto L20;
        setInterceptorResponseThrowable(r4);
        goto L7
    L20:
        if (sRequestLogReporterBridge.isAllErrorReport() == true) goto L21;
        return;
    L5:
        r1 = "";
        goto L6
    }

    private void generateTTNetLog(JSONObject r4) {
        JSONObject r0 = new JSONObject();
        r0.put("retrofit", this.retrofit.toJson());
        r0.put("networklib", this.networklib.toJson());
        r4.put(INetworkCallback.TYPE_TTNET, r0);
    }

    @Deprecated
    private JSONObject getBaseTimingInfo() {
        JSONObject r8 = new JSONObject();
        r8.put("fallback", this.fallbackReason);     // Catch: JSONException -> L23
        if (TextUtils.isEmpty(this.fallbackMessage) == true) goto L6;
        r8.put("fallbackMessage", this.fallbackMessage);     // Catch: JSONException -> L23
    L6:
        r8.put("reqFallback", this.requestFallbackReason);     // Catch: JSONException -> L23
        if (TextUtils.isEmpty(this.requestFallbackMessage) == true) goto L9;
        r8.put("reqFallbackMsg", this.requestFallbackMessage);     // Catch: JSONException -> L23
    L9:
        r8.put("createRetrofitTime", this.appCreateRetrofitStart);     // Catch: JSONException -> L23
        r8.put("appRequestStartTime", this.appLevelRequestStart);     // Catch: JSONException -> L23
        r8.put("beforeAllInterceptTime", this.beforeAllInterceptors);     // Catch: JSONException -> L23
        r8.put("callServerInterceptTime", this.callServerInterceptorTime);     // Catch: JSONException -> L23
        r8.put("callExecuteStartTime", this.callExecuteStartTime);     // Catch: JSONException -> L23
        r8.put("reportTime", this.retrofitLogReportTime);     // Catch: JSONException -> L23
        if (this.requestEncryptType == EncryptType.ENCRYPT_NONE) goto L13;
        r8.put(LBSLightLocationTraceLogger.ENCRYPT, this.requestEncryptType.getValue());     // Catch: JSONException -> L23
    L13:
        if (TextUtils.isEmpty(this.transactionId) == true) goto L15;
        r8.put("transactionId", this.transactionId);     // Catch: JSONException -> L23
    L15:
        long r0 = this.upperAddCookieDurationUs;     // Catch: JSONException -> L23
        if (r0 < 0) goto L18;
        r8.put("upper_add_cookie_us", r0);     // Catch: JSONException -> L23
    L18:
        long r1 = this.upperSaveCookieDurationUs;     // Catch: JSONException -> L23
        if (r1 < 0) goto L21;
        r8.put("upper_save_cookie_us", r1);     // Catch: JSONException -> L23
    L21:
        r8.put("request_cookie_source", this.requestCookieSourceType);     // Catch: JSONException -> L23
    L25:
        boolean r7 = validateAndSetTimingValue(r8, "loadServiceMethod", this.retrofitMethodInvokeTime, this.createSsHttpCallTime, true);
        long r3 = this.enqueueTime;
        if (r3 <= 0) goto L28;
        long r5 = this.responseChainTime;
        String r2 = "enqueueWait";
    L29:
        boolean r4 = validateAndSetTimingValue(r8, r2, r3, r5, r7);
        validateAndSetTimingValue(r8, "biz_start_after_cronet_start", this.retrofit.eventTs.cronetInitStart / 1000, this.retrofit.eventTs.ssHttpCallApiStart / 1000, true);
        validateAndSetTimingValue(r8, "biz_start_before_cronet_end", this.retrofit.eventTs.ssHttpCallApiEnd / 1000, this.retrofit.eventTs.cronetInitEnd / 1000, true);
        boolean r9 = validateAndSetTimingValue(r8, "executeCall", this.executeCallStartTime, this.executeCallEndTime, r4);
        boolean r10 = validateAndSetTimingValue(r8, "requestParse", this.toRequestStartTime, this.toRequestEndTime, r9);
        validateAndSetTimingValue(r8, "responseParse", this.toResponseStartTime, this.toResponseEndTime, r10);
        return r8;
    L28:
        r3 = this.executeTime;
        r5 = this.responseChainTime;
        r2 = "executeWait";
    L23:
        e = move-exception;
        e.printStackTrace();
        goto L25
    }

    @Deprecated
    private JSONObject getCallbackTimingInfo() {
        JSONObject r0 = new JSONObject();
        r0.put("filterUrl", this.filterUrlDuration);     // Catch: JSONException -> L8
        r0.put("addCommonParam", this.addCommonParamDuration);     // Catch: JSONException -> L8
        r0.put("requestVerify", this.requestVerifyDuration);     // Catch: JSONException -> L8
        r0.put("encryptRequest", this.encryptRequestDuration);     // Catch: JSONException -> L8
        r0.put("genReqTicket", this.genReqTicketDuration);     // Catch: JSONException -> L8
        r0.put("checkReqTicket", this.checkReqTicketDuration);     // Catch: JSONException -> L8
        r0.put("preCdnVerify", this.preCdnCacheVerifyDuration);     // Catch: JSONException -> L8
        r0.put("postCdnVerify", this.postCdnCacheVerifyDuration);     // Catch: JSONException -> L8
        r0.put("addClientKey", this.addClientKeyDuration);     // Catch: JSONException -> L8
        r0.put("updateClientKey", this.updateClientKeyDuration);     // Catch: JSONException -> L8
        r0.put("commandListener", this.commandListenerDuration);     // Catch: JSONException -> L8
        r0.put("filterDupQuery", this.filterDupQueryDuration);     // Catch: JSONException -> L8
        r0.put("queryFilter", this.queryFilterDuration);     // Catch: JSONException -> L8
        long r1 = this.bodyEncryptDuration;     // Catch: JSONException -> L8
        if (r1 < 0) goto L6;
        r0.put("bodyEncrypt", r1);     // Catch: JSONException -> L8
    L6:
        r0.put("setSpeed", this.setThrottleNetSpeedDuration);     // Catch: JSONException -> L8
        r0.put("tryInit", this.tryNecessaryInitDuration);     // Catch: JSONException -> L8
        r0.put("openConn", this.openConnectionDuration);     // Catch: JSONException -> L8
        r0.put("prepareReq", this.prepareRequestDuration);     // Catch: JSONException -> L8
    L10:
        return r0;
    L8:
        e = move-exception;
        e.printStackTrace();
        goto L10
    }

    @Deprecated
    private JSONObject getInterceptorTimingInfo() {
        JSONObject r0 = new JSONObject();
    L19:
        e = move-exception;
        e.printStackTrace();
    L21:
        return r0;
    L5:
        if (this.requestInterceptDuration.isEmpty() == true) goto L12;
        JSONObject r1 = new JSONObject();     // Catch: JSONException -> L19
        Iterator<Map.Entry<String, Long>> r3 = this.requestInterceptDuration.entrySet().iterator();     // Catch: JSONException -> L19
    L8:
        if (r3.hasNext() == false) goto L10;
        Map.Entry r4 = (Map.Entry) ZeusTransformUtils.preCheckCast(r3.next(), Map.Entry.class, "com.obric.memorydata.plugin");     // Catch: JSONException -> L19
        r1.put((String) ZeusTransformUtils.preCheckCast(r4.getKey(), String.class, "com.obric.memorydata.plugin"), r4.getValue());     // Catch: JSONException -> L19
        goto L8
    L10:
        r0.put(Ext.KEY_REQUEST, r1);     // Catch: JSONException -> L19
    L12:
        if (this.responseInterceptDuration.isEmpty() == true) goto L21;
        JSONObject r2 = new JSONObject();     // Catch: JSONException -> L19
        Iterator<Map.Entry<String, Long>> r7 = this.responseInterceptDuration.entrySet().iterator();     // Catch: JSONException -> L19
    L15:
        if (r7.hasNext() == false) goto L17;
        Map.Entry r5 = (Map.Entry) ZeusTransformUtils.preCheckCast(r7.next(), Map.Entry.class, "com.obric.memorydata.plugin");     // Catch: JSONException -> L19
        r2.put((String) ZeusTransformUtils.preCheckCast(r5.getKey(), String.class, "com.obric.memorydata.plugin"), r5.getValue());     // Catch: JSONException -> L19
        goto L15
    L17:
        r0.put(ChatMessage.TYPE_RESPONSE, r2);     // Catch: JSONException -> L19
        goto L21
    }

    private JSONObject getModelInfoWhenFallback() {
        JSONObject r3 = new JSONObject();
        r3.put("model", Build.MODEL);     // Catch: JSONException -> L13
        String r0 = "";
        if (Build.VERSION.SDK_INT >= 21) goto L6;
        r0 = Build.CPU_ABI;     // Catch: JSONException -> L13
    L11:
        r3.put("abis", r0);     // Catch: JSONException -> L13
    L15:
        return r3;
    L6:
        String[] r1 = Build.SUPPORTED_ABIS;     // Catch: JSONException -> L13
        if (r1 == null) goto L11;
        if (r1.length <= 0) goto L11;
        r0 = Arrays.asList(r1).toString();     // Catch: JSONException -> L13
    L13:
        e = move-exception;
        e.printStackTrace();
        goto L15
    }

    public static boolean getReportNewMetrics() {
        return sReportNewMetrics;
    }

    private boolean isRetrofitRequestEnd() {
        if (this.retrofit.eventTs.requestEnd == (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    private void maybeReportRequestLog() {
        if (this.hasRetrofitLog == true) goto L5;
        return;
    L5:
        if (this.hasNetworkKernelLog == false) goto L48;
        requestEnd();
        if (this.readingResponseBody == false) goto L10;
        return;
    L10:
        setRequestEndAppResumeState(AppActivityResumeSuspendRecorder.GetAppActivityResumeState());
        if (sRequestLogReporterBridge == null) goto L44;
        WeakReference<LegacyLogRecorder> r0 = this.requestInfo;
        if (r0 != null) goto L15;
        return;
    L15:
        if (r0.get() == null) goto L49;
        final LegacyLogRecorder r1 = this.requestInfo.get();
        if (this.retrofit.misc.requestException == null) goto L20;
        final Throwable r2 = (Throwable) ZeusTransformUtils.preCheckCast(this.retrofit.misc.requestException.get(), Throwable.class, "com.obric.memorydata.plugin");
    L22:
        if (sSyncReport == false) goto L25;
        doReportRequestLog(r1, r2);
        return;
    L25:
        if (logReporter == null) goto L28;
        logReporter.postDelayed(new AnonymousClass1(this, r1, r2), 100);
        return;
    L28:
        if (HANDLER == null) goto L30;
    L39:
        HANDLER.postDelayed(new AnonymousClass2(this, r1, r2), 100);
        return;
    L30:
        monitor-enter(RetrofitMetrics.class);
    L36:
        th = move-exception;
        throw th;
    L32:
        if (HANDLER != null) goto L34;
        HandlerThread r5 = new HandlerThread("TTNet-Log-Report");     // Catch: Throwable -> L36
        HANDLER_THREAD = r5;     // Catch: Throwable -> L36
        r5.start();     // Catch: Throwable -> L36
        HANDLER = new Handler(HANDLER_THREAD.getLooper());     // Catch: Throwable -> L36
    L34:
        monitor-exit(RetrofitMetrics.class);     // Catch: Throwable -> L36
        goto L39
    L20:
        r2 = null;
        goto L22
    L49:
        return;
    L44:
        return;
    }

    public static void setLogReporter(AsyncLogReporter r2) {
        logReporter = (AsyncLogReporter) ZeusTransformUtils.wrapperContextForParams(r2, AsyncLogReporter.class, "com.obric.memorydata.plugin");
    }

    public static void setReportDetail(int r0) {
        RetrofitLayerMetrics.setReportDetail(r0);
        NetworkLibLayerMetrics.setReportDetail(r0);
    }

    public static void setReportNewMetrics(boolean r0) {
        sReportNewMetrics = r0;
    }

    public static void setRequestLogReporterBridge(IRequestLogReporterBridge r2) {
        sRequestLogReporterBridge = (IRequestLogReporterBridge) ZeusTransformUtils.wrapperContextForParams(r2, IRequestLogReporterBridge.class, "com.obric.memorydata.plugin");
    }

    public static void setSyncReport(boolean r0) {
        sSyncReport = r0;
    }

    private boolean validateAndSetTimingValue(JSONObject r1, String r2, long r3, long r5, boolean r7) {
        if (r7 == true) goto L5;
    L10:
        r1.put(r2, -1);     // Catch: JSONException -> L12
        return false;
    L5:
        if (r3 > r5) goto L10;
        r1.put(r2, r5 - r3);     // Catch: JSONException -> L12
        return true;
    L12:
        e = move-exception;
        e.printStackTrace();
        return false;
    }

    public long ConvertToWallClockTimeMs(long r8) {
        return TTMetricsUtil.calculateWallClockTimeMs(this.retrofit.eventTs.bizInvokeRetrofitRequestInterfaceStartTime, this.retrofit.eventTs.bizInvokeRetrofitRequestInterfaceStart, r8);
    }

    public void ResetNetworkLibMetrics() {
        this.networklib = new NetworkLibLayerMetrics();
    }

    public void accountRetryEnd() {
        NetworkLibLayerMetrics.BizSpan r0 = this.networklib.bizSpan;
        r0.accountRetryDuration = this.networklib.bizSpan.computeDurationNs();
        WeakReference<LegacyLogRecorder> r1 = this.requestInfo;
        if (r1 == null) goto L6;
        ((LegacyLogRecorder) ZeusTransformUtils.preCheckCast(r1.get(), LegacyLogRecorder.class, "com.obric.memorydata.plugin")).setAccountRetryCallbackDuration(TTMetricsUtil.nanoSecondsToMilliSeconds(this.networklib.bizSpan.accountRetryDuration));
        return;
    }

    public void accountRetryStart() {
        this.networklib.bizSpan.recordCallbackStart();
    }

    public void addClientKeyEnd() {
        RetrofitLayerMetrics.ImportantInnerSpan r0 = this.retrofit.innerSpan;
        r0.addClientKey = this.retrofit.innerSpan.computeDurationNs();
        this.addClientKeyDuration = TTMetricsUtil.nanoSecondsToMilliSeconds(this.retrofit.innerSpan.addClientKey);
    }

    public void addClientKeyStart() {
        this.retrofit.innerSpan.recordInnerSpanStart();
    }

    public void addCommonParamEnd() {
        RetrofitLayerMetrics.BizSpan r0 = this.retrofit.bizSpan;
        r0.addCommonParam = this.retrofit.bizSpan.computeDurationNs();
        this.addCommonParamDuration = TTMetricsUtil.nanoSecondsToMilliSeconds(this.retrofit.bizSpan.addCommonParam);
    }

    public void addCommonParamStart() {
        this.retrofit.bizSpan.recordCallbackStart();
    }

    public void afterInterceptorExecute(Throwable r11) {
        long r0 = System.nanoTime();
        InterceptorRecorder.LogEntry r2 = this.retrofit.interceptorRecorder.pop();
        if (r2 != null) goto L5;
    L24:
        InterceptorRecorder.LogEntry r3 = this.retrofit.interceptorRecorder.peek();
        if (r3 != null) goto L27;
        this.retrofit.eventTs.responseInterceptorEnd = r0;
        return;
    L27:
        if (r11 != null) goto L31;
        r3.rspStartNs = r0;
        return;
    L31:
        return;
    L5:
        if (r2.reqEndNs != (-1)) goto L10;
        r2.reqEndNs = r0;
        if (r11 == null) goto L15;
    L8:
        r2.exception_name = r11.getClass().getSimpleName();
    L15:
        if (r2.isInternalInterceptor == true) goto L24;
        if (r2.rspStartNs == (-1)) goto L24;
        if (r2.rspEndNs == (-1)) goto L24;
        if (this.retrofit.bizSpan.bizResponseInterceptor != (-1)) goto L23;
        this.retrofit.bizSpan.bizResponseInterceptor = 0;
    L23:
        this.retrofit.bizSpan.bizResponseInterceptor += r2.rspEndNs - r2.rspStartNs;
        goto L24
    L10:
        if (r2.rspStartNs == (-1)) goto L15;
        r2.rspEndNs = r0;
        if (r11 == null) goto L15;
        goto L8
    }

    public void bdTuringEnd() {
        NetworkLibLayerMetrics.BizSpan r0 = this.networklib.bizSpan;
        r0.bdTuringDuration = this.networklib.bizSpan.computeDurationNs();
        WeakReference<LegacyLogRecorder> r1 = this.requestInfo;
        if (r1 == null) goto L6;
        ((LegacyLogRecorder) ZeusTransformUtils.preCheckCast(r1.get(), LegacyLogRecorder.class, "com.obric.memorydata.plugin")).setBdTuringCallbackDuration(TTMetricsUtil.nanoSecondsToMilliSeconds(this.networklib.bizSpan.bdTuringDuration));
        return;
    }

    public void bdTuringStart() {
        this.networklib.bizSpan.recordCallbackStart();
    }

    public void beforeInterceptorExecute(Interceptor r12) {
        Interceptor r13 = (Interceptor) ZeusTransformUtils.wrapperContextForParams(r12, Interceptor.class, "com.obric.memorydata.plugin");
        String r0 = r13.getClass().getName();
        if (TextUtils.isEmpty(r0) == true) goto L18;
        long r1 = System.nanoTime();
        InterceptorRecorder.LogEntry r3 = this.retrofit.interceptorRecorder.peek();
        if (r3 != null) goto L7;
        this.retrofit.eventTs.requestInterceptorStart = r1;
        this.responseChainTime = TTMetricsUtil.nanoSecondsToMilliSeconds(r1);
        this.beforeAllInterceptors = ConvertToWallClockTimeMs(r1);
    L16:
        this.retrofit.interceptorRecorder.push(new InterceptorRecorder.LogEntry(r0.substring(r0.lastIndexOf(46) + 1), ZeusTransformUtils.instanceOf(r13, TTInternalInterceptor.class), r1));
        return;
    L7:
        if (r3.reqEndNs != (-1)) goto L10;
        r3.reqEndNs = r1;
    L10:
        if (r3.isInternalInterceptor == true) goto L16;
        if (this.retrofit.bizSpan.bizRequestInterceptor != (-1)) goto L14;
        this.retrofit.bizSpan.bizRequestInterceptor = 0;
    L14:
        this.retrofit.bizSpan.bizRequestInterceptor += r3.reqEndNs - r3.reqStartNs;
        goto L16
    }

    public void bizInvokeRetrofitRequestInterfaceEnd() {
        RetrofitLayerMetrics.EventTimestamp r2 = this.retrofit.eventTs;
        r2.bizInvokeRetrofitRequestInterfaceEnd = System.nanoTime();
    }

    public void bizInvokeRetrofitRequestInterfaceStart(boolean r4) {
        RetrofitLayerMetrics.EventTimestamp r0 = this.retrofit.eventTs;
        long r1 = System.currentTimeMillis();
        r0.bizInvokeRetrofitRequestInterfaceStartTime = r1;
        this.appCreateRetrofitStart = r1;
        RetrofitLayerMetrics.EventTimestamp r2 = this.retrofit.eventTs;
        r2.bizInvokeRetrofitRequestInterfaceStart = System.nanoTime();
        long r3 = TTMetricsUtil.nanoSecondsToMilliSeconds(this.retrofit.eventTs.bizInvokeRetrofitRequestInterfaceStart);
        this.appCreateRetrofitStartUpTime = r3;
        if (r4 == false) goto L6;
        this.createSsHttpCallTime = r3;
        this.retrofitMethodInvokeTime = r3;
        return;
    }

    public void bizReceiveResponseHeader() {
        RetrofitLayerMetrics.EventTimestamp r0 = this.retrofit.eventTs;
        r0.bizReceiveResponseHeaderTime = System.currentTimeMillis();
        RetrofitLayerMetrics.EventTimestamp r3 = this.retrofit.eventTs;
        r3.bizReceiveResponseHeader = System.nanoTime();
    }

    public void bodyEncryptEnd() {
        NetworkLibLayerMetrics.BizSpan r0 = this.networklib.bizSpan;
        r0.bodyEncrypt = this.networklib.bizSpan.computeDurationNs();
        this.bodyEncryptDuration = TTMetricsUtil.nanoSecondsToMilliSeconds(this.networklib.bizSpan.bodyEncrypt);
    }

    public void bodyEncryptStart() {
        this.networklib.bizSpan.recordCallbackStart();
    }

    public void callServerInterceptorStart() {
        this.retrofit.misc.callServerExecutedTimes++;
        this.callServerInterceptorTime = SystemClock.uptimeMillis();
    }

    public void checkReqTicketEnd() {
        RetrofitLayerMetrics.BizSpan r0 = this.retrofit.bizSpan;
        r0.checkReqTicket = this.retrofit.bizSpan.computeDurationNs();
        this.checkReqTicketDuration = TTMetricsUtil.nanoSecondsToMilliSeconds(this.retrofit.bizSpan.checkReqTicket);
    }

    public void checkReqTicketStart() {
        this.retrofit.bizSpan.recordCallbackStart();
    }

    public RetrofitMetrics cloneMetrics() {
        RetrofitMetrics r0 = new RetrofitMetrics();
        r0.appCreateRetrofitStartUpTime = this.appCreateRetrofitStartUpTime;
        r0.appCreateRetrofitStart = this.appLevelRequestStart;
        r0.retrofitMethodInvokeTime = this.retrofitMethodInvokeTime;
        r0.createSsHttpCallTime = this.createSsHttpCallTime;
        r0.isResponseStreaming = this.isResponseStreaming;
        RetrofitLayerMetrics.EventTimestamp r1 = r0.retrofit.eventTs;
        r1.bizInvokeRetrofitRequestInterfaceStartTime = this.retrofit.eventTs.bizInvokeRetrofitRequestInterfaceStartTime;
        RetrofitLayerMetrics.EventTimestamp r2 = r0.retrofit.eventTs;
        r2.bizInvokeRetrofitRequestInterfaceStart = this.retrofit.eventTs.bizInvokeRetrofitRequestInterfaceStart;
        RetrofitLayerMetrics.EventTimestamp r3 = r0.retrofit.eventTs;
        r3.bizInvokeRetrofitRequestInterfaceEnd = this.retrofit.eventTs.bizInvokeRetrofitRequestInterfaceEnd;
        RetrofitLayerMetrics.ImportantInnerSpan r4 = r0.retrofit.innerSpan;
        r4.createRequestFactory = this.retrofit.innerSpan.createRequestFactory;
        RetrofitLayerMetrics.ImportantInnerSpan r5 = r0.retrofit.innerSpan;
        r5.createHttpServiceMethod = this.retrofit.innerSpan.createHttpServiceMethod;
        return r0;
    }

    public void commandListenerEnd() {
        RetrofitLayerMetrics.BizSpan r0 = this.retrofit.bizSpan;
        r0.commandListener = this.retrofit.bizSpan.computeDurationNs();
        this.commandListenerDuration = TTMetricsUtil.nanoSecondsToMilliSeconds(this.retrofit.bizSpan.commandListener);
    }

    public void commandListenerStart() {
        this.retrofit.bizSpan.recordCallbackStart();
    }

    public void configureConnectionEnd(long r4) {
        NetworkLibLayerMetrics.ImportantInnerSpan r0 = this.networklib.innerSpan;
        r0.configureConnection = System.nanoTime() - r4;
        this.prepareRequestDuration = TTMetricsUtil.nanoSecondsToMilliSeconds(this.networklib.innerSpan.configureConnection);
    }

    public long configureConnectionStart() {
        return System.nanoTime();
    }

    public void constructConnectionEnd(long r4) {
        NetworkLibLayerMetrics.ImportantInnerSpan r0 = this.networklib.innerSpan;
        r0.constructConnection = System.nanoTime() - r4;
        this.openConnectionDuration = TTMetricsUtil.nanoSecondsToMilliSeconds(this.networklib.innerSpan.constructConnection);
    }

    public long constructConnectionStart() {
        return System.nanoTime();
    }

    public void copyTo(RetrofitMetrics r8) {
        if (r8 != null) goto L79;
        return;
    L79:
        if (this.url == null) goto L7;
        r8.url = new URL(this.url.toString());     // Catch: Exception -> L68
    L7:
        r8.isResponseStreaming = this.isResponseStreaming;
        r8.streamParserCopyCount = this.streamParserCopyCount;
        r8.responseReadType = this.responseReadType;
        r8.requestEncryptType = this.requestEncryptType;
        r8.fallbackReason = this.fallbackReason;
        r8.fallbackMessage = this.fallbackMessage;
        r8.requestFallbackReason = this.requestFallbackReason;
        r8.requestFallbackMessage = this.requestFallbackMessage;
        JSONObject r0 = null;
        if (this.concurrentRequest == null) goto L11;
        JSONObject r1 = new JSONObject(this.concurrentRequest.toString());     // Catch: JSONException -> L69
    L12:
        r8.concurrentRequest = r1;     // Catch: JSONException -> L69
        goto L13
    L11:
        r1 = null;
    L13:
        r8.transactionId = this.transactionId;
        r8.isConcurrent = this.isConcurrent;
        r8.appCreateRetrofitStart = this.appCreateRetrofitStart;
        r8.appLevelRequestStart = this.appLevelRequestStart;
        r8.beforeAllInterceptors = this.beforeAllInterceptors;
        r8.callServerInterceptorTime = this.callServerInterceptorTime;
        r8.callExecuteStartTime = this.callExecuteStartTime;
        r8.retrofitLogReportTime = this.retrofitLogReportTime;
        r8.retrofitMethodInvokeTime = this.retrofitMethodInvokeTime;
        r8.createSsHttpCallTime = this.createSsHttpCallTime;
        r8.appCreateRetrofitStartUpTime = this.appCreateRetrofitStartUpTime;
        r8.enqueueTime = this.enqueueTime;
        r8.executeTime = this.executeTime;
        r8.delayState = this.delayState;
        r8.delayStateName = this.delayStateName;
        r8.delayedWithState = this.delayedWithState;
        r8.stateDelayTime = this.stateDelayTime;
        r8.syncDelayCount = this.syncDelayCount;
        r8.asyncDelayCount = this.asyncDelayCount;
        r8.delayStartTimeStamp = this.delayStartTimeStamp;
        r8.randomSendTime = this.randomSendTime;
        r8.responseChainTime = this.responseChainTime;
        r8.toRequestStartTime = this.toRequestStartTime;
        r8.toRequestEndTime = this.toRequestEndTime;
        r8.executeCallStartTime = this.executeCallStartTime;
        r8.executeCallEndTime = this.executeCallEndTime;
        r8.toResponseStartTime = this.toResponseStartTime;
        r8.toResponseEndTime = this.toResponseEndTime;
        if (this.interceptorResponseThrowable == null) goto L17;
        Throwable r2 = new Throwable(this.interceptorResponseThrowable.getMessage());
        r2.setStackTrace(this.interceptorResponseThrowable.getStackTrace());
        r8.interceptorResponseThrowable = r2;
    L17:
        if (this.requestInterceptDuration == null) goto L23;
        r8.requestInterceptDuration = new ConcurrentHashMap();
        Iterator<Map.Entry<String, Long>> r3 = this.requestInterceptDuration.entrySet().iterator();
    L20:
        if (r3.hasNext() == false) goto L23;
        Map.Entry r4 = (Map.Entry) ZeusTransformUtils.preCheckCast(r3.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        r8.requestInterceptDuration.put((String) ZeusTransformUtils.preCheckCast(r4.getKey(), String.class, "com.obric.memorydata.plugin"), (Long) ZeusTransformUtils.preCheckCast(r4.getValue(), Long.class, "com.obric.memorydata.plugin"));
    L23:
        if (this.responseInterceptDuration == null) goto L28;
        r8.responseInterceptDuration = new ConcurrentHashMap();
        Iterator<Map.Entry<String, Long>> r5 = this.responseInterceptDuration.entrySet().iterator();
    L26:
        if (r5.hasNext() == false) goto L28;
        Map.Entry r6 = (Map.Entry) ZeusTransformUtils.preCheckCast(r5.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        r8.responseInterceptDuration.put((String) ZeusTransformUtils.preCheckCast(r6.getKey(), String.class, "com.obric.memorydata.plugin"), (Long) ZeusTransformUtils.preCheckCast(r6.getValue(), Long.class, "com.obric.memorydata.plugin"));
    L28:
        r8.filterUrlDuration = this.filterUrlDuration;
        r8.addCommonParamDuration = this.addCommonParamDuration;
        r8.requestVerifyDuration = this.requestVerifyDuration;
        r8.filterDupQueryDuration = this.filterDupQueryDuration;
        r8.encryptRequestDuration = this.encryptRequestDuration;
        r8.genReqTicketDuration = this.genReqTicketDuration;
        r8.checkReqTicketDuration = this.checkReqTicketDuration;
        r8.preCdnCacheVerifyDuration = this.preCdnCacheVerifyDuration;
        r8.addClientKeyDuration = this.addClientKeyDuration;
        r8.updateClientKeyDuration = this.updateClientKeyDuration;
        r8.postCdnCacheVerifyDuration = this.postCdnCacheVerifyDuration;
        r8.commandListenerDuration = this.commandListenerDuration;
        r8.queryFilterDuration = this.queryFilterDuration;
        r8.bodyEncryptDuration = this.bodyEncryptDuration;
        if (this.extra == null) goto L34;
        r8.extra = new ConcurrentHashMap();
        Iterator<Map.Entry<String, Long>> r7 = this.extra.entrySet().iterator();
    L32:
        if (r7.hasNext() == false) goto L34;
        Map.Entry r9 = (Map.Entry) ZeusTransformUtils.preCheckCast(r7.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        r8.extra.put((String) ZeusTransformUtils.preCheckCast(r9.getKey(), String.class, "com.obric.memorydata.plugin"), (Long) ZeusTransformUtils.preCheckCast(r9.getValue(), Long.class, "com.obric.memorydata.plugin"));
    L34:
        r8.ttnetVersion = this.ttnetVersion;
        if (this.dispatchQueryActionInfo == null) goto L38;
        r8.dispatchQueryActionInfo = new JSONArray(this.dispatchQueryActionInfo.toString());     // Catch: JSONException -> L70
    L38:
        r8.traceCode = this.traceCode;
        r8.responseConvertSuccess = this.responseConvertSuccess;
        r8.enqueueCallbackStartTime = this.enqueueCallbackStartTime;
        r8.enqueueCallbackEndTime = this.enqueueCallbackEndTime;
        r8.executeEndTime = this.executeEndTime;
        r8.priorityLevel = this.priorityLevel;
        r8.requestPriorityLevel = this.requestPriorityLevel;
        r8.responseCompressType = this.responseCompressType;
        r8.requestCompressType = this.requestCompressType;
        if (this.requestCompressInfo == null) goto L42;
        JSONObject r10 = new JSONObject(this.requestCompressInfo.toString());     // Catch: JSONException -> L71
    L43:
        r8.requestCompressInfo = r10;     // Catch: JSONException -> L71
        goto L44
    L42:
        r10 = null;
    L44:
        r8.postBodyBufferSize = this.postBodyBufferSize;
        r8.setThrottleNetSpeedDuration = this.setThrottleNetSpeedDuration;
        r8.tryNecessaryInitDuration = this.tryNecessaryInitDuration;
        r8.openConnectionDuration = this.openConnectionDuration;
        r8.prepareRequestDuration = this.prepareRequestDuration;
        r8.upperAddCookieDurationUs = this.upperAddCookieDurationUs;
        r8.upperSaveCookieDurationUs = this.upperSaveCookieDurationUs;
        r8.requestCookieSourceType = this.requestCookieSourceType;
        if (this.bizExtraInfo == null) goto L73;
        r8.bizExtraInfo = new HashMap();
        Iterator<Map.Entry<String, Object>> r11 = this.bizExtraInfo.entrySet().iterator();
    L48:
        if (r11.hasNext() == false) goto L73;
        Map.Entry r12 = (Map.Entry) ZeusTransformUtils.preCheckCast(r11.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        r8.bizExtraInfo.put((String) ZeusTransformUtils.preCheckCast(r12.getKey(), String.class, "com.obric.memorydata.plugin"), r12.getValue());
    L73:
        if (this.rotationHostRetryInfo == null) goto L53;
        r0 = new JSONObject(this.rotationHostRetryInfo.toString());     // Catch: JSONException -> L72
    L53:
        r8.rotationHostRetryInfo = r0;     // Catch: JSONException -> L72
    L54:
        r8.blockingQueueSize = this.blockingQueueSize;
        List<InterceptorInfo> r13 = this.interceptorRequestInfos;
        if (r13 == null) goto L60;
        Iterator<InterceptorInfo> r14 = r13.iterator();
    L58:
        if (r14.hasNext() == false) goto L60;
        InterceptorInfo r15 = (InterceptorInfo) ZeusTransformUtils.preCheckCast(r14.next(), InterceptorInfo.class, "com.obric.memorydata.plugin");
        InterceptorInfo r16 = new InterceptorInfo(this, r15.name, r15.start);
        r16.end = r15.end;
        r16.exception_name = r15.exception_name;
        r8.interceptorRequestInfos.add(r16);
    L60:
        List<InterceptorInfo> r17 = this.interceptorResponseInfos;
        if (r17 == null) goto L66;
        Iterator<InterceptorInfo> r18 = r17.iterator();
    L64:
        if (r18.hasNext() == false) goto L66;
        InterceptorInfo r19 = (InterceptorInfo) ZeusTransformUtils.preCheckCast(r18.next(), InterceptorInfo.class, "com.obric.memorydata.plugin");
        InterceptorInfo r20 = new InterceptorInfo(this, r19.name, r19.start);
        r20.end = r19.end;
        r20.exception_name = r19.exception_name;
        r8.interceptorResponseInfos.add(r20);
    L66:
        r8.hasNetworkKernelLog = this.hasNetworkKernelLog;
        r8.hasRetrofitLog = this.hasRetrofitLog;
        r8.requestInfo = this.requestInfo;
        r8.retrofit = this.retrofit.deepCopy();
        r8.networklib = this.networklib.deepCopy();
    }

    public void createHttpServiceMethodEnd() {
        RetrofitLayerMetrics.ImportantInnerSpan r0 = this.retrofit.innerSpan;
        r0.createHttpServiceMethod = this.retrofit.innerSpan.computeDurationNs();
    }

    public void createHttpServiceMethodStart() {
        this.retrofit.innerSpan.recordInnerSpanStart();
        this.createSsHttpCallTime = SystemClock.uptimeMillis();
    }

    public void createRequestFactoryEnd() {
        RetrofitLayerMetrics.ImportantInnerSpan r0 = this.retrofit.innerSpan;
        r0.createRequestFactory = this.retrofit.innerSpan.computeDurationNs();
    }

    public void createRequestFactoryStart() {
        this.retrofit.innerSpan.recordInnerSpanStart();
        this.retrofitMethodInvokeTime = SystemClock.uptimeMillis();
    }

    public RetrofitMetrics deepCopy() {
        RetrofitMetrics r0 = new RetrofitMetrics();
        copyTo(r0);
        return r0;
    }

    public void encryptRequestEnd() {
        RetrofitLayerMetrics.BizSpan r0 = this.retrofit.bizSpan;
        r0.encryptRequest = this.retrofit.bizSpan.computeDurationNs();
        this.encryptRequestDuration = TTMetricsUtil.nanoSecondsToMilliSeconds(this.retrofit.bizSpan.encryptRequest);
    }

    public void encryptRequestStart() {
        this.retrofit.bizSpan.recordCallbackStart();
    }

    public void enqueueCallbackEnd() {
        RetrofitLayerMetrics.BizSpan r0 = this.retrofit.bizSpan;
        r0.enqueueCallback = this.retrofit.bizSpan.computeDurationNs();
        this.enqueueCallbackEndTime = SystemClock.uptimeMillis();
    }

    public void enqueueCallbackStart() {
        this.retrofit.bizSpan.recordCallbackStart();
        this.enqueueCallbackStartTime = SystemClock.uptimeMillis();
    }

    public void executeConnectionEnd(long r4) {
        long r0 = System.nanoTime();
        this.networklib.eventTs.executeConnectionEnd = r0;
        long r1 = r0 - r4;
        this.networklib.innerSpan.executeConnection = r1;
    }

    public long executeConnectionStart() {
        long r0 = System.nanoTime();
        this.networklib.eventTs.executeConnectionStart = r0;
        return r0;
    }

    public void executeSsCallEnd() {
        RetrofitLayerMetrics.EventTimestamp r0 = this.retrofit.eventTs;
        r0.executeSsCallEnd = System.nanoTime();
        this.executeCallEndTime = TTMetricsUtil.nanoSecondsToMilliSeconds(this.retrofit.eventTs.executeSsCallEnd);
    }

    public void executeSsCallStart() {
        RetrofitLayerMetrics.EventTimestamp r0 = this.retrofit.eventTs;
        r0.executeSsCallStart = System.nanoTime();
        this.executeCallStartTime = TTMetricsUtil.nanoSecondsToMilliSeconds(this.retrofit.eventTs.executeSsCallStart);
        this.callExecuteStartTime = ConvertToWallClockTimeMs(this.retrofit.eventTs.executeSsCallStart);
    }

    public void filterDupQueryEnd() {
        RetrofitLayerMetrics.ImportantInnerSpan r0 = this.retrofit.innerSpan;
        r0.filterDupQuery = this.retrofit.innerSpan.computeDurationNs();
        this.filterDupQueryDuration = TTMetricsUtil.nanoSecondsToMilliSeconds(this.retrofit.innerSpan.filterDupQuery);
    }

    public void filterDupQueryStart() {
        this.retrofit.innerSpan.recordInnerSpanStart();
    }

    public void filterUrlEnd() {
        RetrofitLayerMetrics.BizSpan r0 = this.retrofit.bizSpan;
        r0.filterUrl = this.retrofit.bizSpan.computeDurationNs();
        this.filterUrlDuration = TTMetricsUtil.nanoSecondsToMilliSeconds(this.retrofit.bizSpan.filterUrl);
    }

    public void filterUrlStart() {
        this.retrofit.bizSpan.recordCallbackStart();
    }

    public void genReqTicketEnd() {
        RetrofitLayerMetrics.ImportantInnerSpan r0 = this.retrofit.innerSpan;
        r0.genReqTicket = this.retrofit.innerSpan.computeDurationNs();
        this.genReqTicketDuration = TTMetricsUtil.nanoSecondsToMilliSeconds(this.retrofit.innerSpan.genReqTicket);
    }

    public void genReqTicketStart() {
        this.retrofit.innerSpan.recordInnerSpanStart();
    }

    public EncryptType getEncryptType() {
        return this.requestEncryptType;
    }

    @Deprecated
    public JSONObject getRealChainInterceptorTimingInfo() {
        JSONObject r0 = new JSONObject();
        JSONObject r1 = new JSONObject();
        JSONObject r2 = new JSONObject();
        Iterator<InterceptorInfo> r3 = this.interceptorRequestInfos.iterator();     // Catch: JSONException -> L14
    L6:
        if (r3.hasNext() == false) goto L8;
        InterceptorInfo r4 = (InterceptorInfo) ZeusTransformUtils.preCheckCast(r3.next(), InterceptorInfo.class, "com.obric.memorydata.plugin");     // Catch: JSONException -> L14
        r0.put(r4.name, r4.end - r4.start);     // Catch: JSONException -> L14
        goto L6
    L8:
        Iterator<InterceptorInfo> r10 = this.interceptorResponseInfos.iterator();     // Catch: JSONException -> L14
    L10:
        if (r10.hasNext() == false) goto L12;
        InterceptorInfo r5 = (InterceptorInfo) ZeusTransformUtils.preCheckCast(r10.next(), InterceptorInfo.class, "com.obric.memorydata.plugin");     // Catch: JSONException -> L14
        r1.put(r5.name, r5.end - r5.start);     // Catch: JSONException -> L14
        goto L10
    L12:
        r2.put("interceptorRequestInfo", r0);     // Catch: JSONException -> L14
        r2.put("interceptorResponseInfo", r1);     // Catch: JSONException -> L14
    L16:
        return r2;
    L14:
        e = move-exception;
        e.printStackTrace();
        goto L16
    }

    @Deprecated
    public String getRetrofitLog() {
        JSONObject r0 = new JSONObject();
    L39:
        e = move-exception;
        e.printStackTrace();
    L42:
        return r0.toString();
    L4:
        if (this.fallbackReason == (-1)) goto L6;
        r0.put("model", getModelInfoWhenFallback());     // Catch: JSONException -> L39
    L6:
        JSONObject r1 = this.concurrentRequest;     // Catch: JSONException -> L39
        if (r1 == null) goto L9;
        r0.put("concurrentRequest", r1);     // Catch: JSONException -> L39
    L9:
        r0.put("concurrent", this.isConcurrent);     // Catch: JSONException -> L39
        r0.put("base", getBaseTimingInfo());     // Catch: JSONException -> L39
        r0.put("callback", getCallbackTimingInfo());     // Catch: JSONException -> L39
        r0.put("interceptor", getInterceptorTimingInfo());     // Catch: JSONException -> L39
        r0.put("ttnetVersion", this.ttnetVersion);     // Catch: JSONException -> L39
        JSONArray r2 = this.dispatchQueryActionInfo;     // Catch: JSONException -> L39
        if (r2 != null) goto L12;
    L14:
        JSONObject r3 = this.requestCompressInfo;     // Catch: JSONException -> L39
        if (r3 == null) goto L17;
        r0.put("compress", r3);     // Catch: JSONException -> L39
    L17:
        int r4 = this.postBodyBufferSize;     // Catch: JSONException -> L39
        if (r4 <= 0) goto L20;
        r0.put("postBufferSize", r4);     // Catch: JSONException -> L39
    L20:
        int r5 = this.blockingQueueSize;     // Catch: JSONException -> L39
        if (r5 <= 0) goto L24;
        r0.put("blockingQueueSize", r5);     // Catch: JSONException -> L39
    L24:
        if (this.networklib.misc.responseBodyReadTimes <= 0) goto L26;
        r0.put("apiStreamReadCount", this.networklib.misc.responseBodyReadTimes);     // Catch: JSONException -> L39
    L26:
        r0.put("stateDelayed", this.delayedWithState);     // Catch: JSONException -> L39
        r0.put("stateDelayTime", this.stateDelayTime);     // Catch: JSONException -> L39
        r0.put("syncCount", this.syncDelayCount);     // Catch: JSONException -> L39
        r0.put("asyncCount", this.asyncDelayCount);     // Catch: JSONException -> L39
        r0.put("delayState", this.delayState);     // Catch: JSONException -> L39
        r0.put("random", this.randomSendTime);     // Catch: JSONException -> L39
        if (TextUtils.isEmpty(this.delayStateName) == true) goto L30;
        r0.put("stateName", this.delayStateName);     // Catch: JSONException -> L39
    L30:
        if (this.addClientKeyDuration < 0) goto L32;
        r0.put("cli_key", true);     // Catch: JSONException -> L39
    L32:
        int r6 = this.streamParserCopyCount;     // Catch: JSONException -> L39
        if (r6 < 0) goto L35;
        r0.put("cp_cnt", r6);     // Catch: JSONException -> L39
    L35:
        int r7 = this.responseReadType;     // Catch: JSONException -> L39
        if (r7 < 0) goto L42;
        r0.put("read_type", r7);     // Catch: JSONException -> L39
        goto L42
    L12:
        if (r2.length() <= 0) goto L14;
        r0.put("actionInfo", this.dispatchQueryActionInfo);     // Catch: JSONException -> L39
        goto L14
    }

    public void inputStreamProcessEnd() {
        NetworkLibLayerMetrics.BizSpan r0 = this.networklib.bizSpan;
        r0.inputStreamProcessDuration = this.networklib.bizSpan.computeDurationNs();
    }

    public void inputStreamProcessStart() {
        this.networklib.bizSpan.recordCallbackStart();
    }

    public void logReport() {
        RetrofitLayerMetrics.EventTimestamp r0 = this.retrofit.eventTs;
        r0.logReport = System.nanoTime();
        this.retrofitLogReportTime = ConvertToWallClockTimeMs(this.retrofit.eventTs.logReport);
    }

    public void lowestInterceptorRequestEnd() {
        long r0 = System.nanoTime();
        this.retrofit.eventTs.requestInterceptorEnd = r0;
        InterceptorRecorder.LogEntry r3 = this.retrofit.interceptorRecorder.peek();
        if (r3 == null) goto L6;
        r3.reqEndNs = r0;
        return;
    }

    public void lowestInterceptorResponseStart() {
        long r0 = System.nanoTime();
        this.retrofit.eventTs.responseInterceptorStart = r0;
        InterceptorRecorder.LogEntry r3 = this.retrofit.interceptorRecorder.peek();
        if (r3 == null) goto L6;
        r3.rspStartNs = r0;
        return;
    }

    public void markNetworkKernelLogCollected() {
        this.hasNetworkKernelLog = true;
        maybeReportRequestLog();
    }

    public void markReadResponseBodyInternal() {
        this.networklib.misc.readResponseBodyInternal = true;
    }

    public void markRetrofitLayerLogCollected() {
        this.hasRetrofitLog = true;
        maybeReportRequestLog();
    }

    public void monitorApiHttpAfterFilterEnd() {
        RetrofitLayerMetrics.BizSpan r0 = this.retrofit.bizSpan;
        r0.monitorApiHttpAfterFilter = this.retrofit.bizSpan.computeDurationNs();
    }

    public void monitorApiHttpAfterFilterStart() {
        this.retrofit.bizSpan.recordCallbackStart();
    }

    public void monitorApiHttpBeforeFilterEnd() {
        RetrofitLayerMetrics.BizSpan r0 = this.retrofit.bizSpan;
        r0.monitorApiHttpBeforeFilter = this.retrofit.bizSpan.computeDurationNs();
    }

    public void monitorApiHttpBeforeFilterStart() {
        this.retrofit.bizSpan.recordCallbackStart();
    }

    public void onTryInitEnd() {
        this.networklib.bizSpan.onTryInit = this.networklib.bizSpan.computeDurationNs();
        if (this.tryNecessaryInitDuration != (-1)) goto L5;
        this.tryNecessaryInitDuration = 0;
    L5:
        this.tryNecessaryInitDuration += TTMetricsUtil.nanoSecondsToMilliSeconds(this.networklib.bizSpan.onTryInit);
    }

    public void onTryInitStart() {
        this.networklib.bizSpan.recordCallbackStart();
    }

    public void postCdnCacheVerifyEnd() {
        RetrofitLayerMetrics.BizSpan r0 = this.retrofit.bizSpan;
        r0.postCdnCacheVerify = this.retrofit.bizSpan.computeDurationNs();
        this.postCdnCacheVerifyDuration = TTMetricsUtil.nanoSecondsToMilliSeconds(this.retrofit.bizSpan.postCdnCacheVerify);
    }

    public void postCdnCacheVerifyStart() {
        this.retrofit.bizSpan.recordCallbackStart();
    }

    public void postProcessBodyEnd() {
        NetworkLibLayerMetrics.ImportantInnerSpan r0 = this.networklib.innerSpan;
        r0.postProcessBody = this.networklib.innerSpan.computeDurationNs();
    }

    public void postProcessBodyStart() {
        this.networklib.innerSpan.recordInnerSpanStart();
    }

    public void preCdnCacheVerifyEnd() {
        RetrofitLayerMetrics.ImportantInnerSpan r0 = this.retrofit.innerSpan;
        r0.preCdnCacheVerify = this.retrofit.innerSpan.computeDurationNs();
        this.preCdnCacheVerifyDuration = TTMetricsUtil.nanoSecondsToMilliSeconds(this.retrofit.innerSpan.preCdnCacheVerify);
    }

    public void preCdnCacheVerifyStart() {
        this.retrofit.innerSpan.recordInnerSpanStart();
    }

    public void prepareConnectionEnd() {
        NetworkLibLayerMetrics.EventTimestamp r2 = this.networklib.eventTs;
        r2.prepareConnectionEnd = System.nanoTime();
    }

    public void prepareConnectionStart() {
        NetworkLibLayerMetrics.EventTimestamp r2 = this.networklib.eventTs;
        r2.prepareConnectionStart = System.nanoTime();
    }

    public void processResponseBodyEnd() {
        NetworkLibLayerMetrics.EventTimestamp r0 = this.networklib.eventTs;
        r0.processResponseBodyEnd = System.nanoTime();
        NetworkLibLayerMetrics.ImportantInnerSpan r1 = this.networklib.innerSpan;
        r1.processResponseBody = this.networklib.innerSpan.computeDurationNs();
    }

    public void processResponseBodyStart() {
        NetworkLibLayerMetrics.EventTimestamp r0 = this.networklib.eventTs;
        r0.processResponseBodyStart = System.nanoTime();
        this.networklib.innerSpan.recordInnerSpanStart();
    }

    public void queryFilterEnd() {
        NetworkLibLayerMetrics.ImportantInnerSpan r0 = this.networklib.innerSpan;
        r0.queryFilter = this.networklib.innerSpan.computeDurationNs();
        this.queryFilterDuration = TTMetricsUtil.nanoSecondsToMilliSeconds(this.networklib.innerSpan.queryFilter);
    }

    public void queryFilterStart() {
        this.networklib.innerSpan.recordInnerSpanStart();
    }

    public void readResponseBodyEnd() {
        this.readingResponseBody = false;
        this.networklib.eventTs.latestReadResponseBodyEnd = System.nanoTime();
        if (this.networklib.misc.readResponseBodyInternal == false) goto L6;
        return;
    L6:
        if (this.networklib.innerSpan.readResponseBody != (-1)) goto L8;
        this.networklib.innerSpan.readResponseBody = 0;
    L8:
        this.networklib.innerSpan.readResponseBody += this.networklib.innerSpan.computeDurationNs();
        if (isRetrofitRequestEnd() == false) goto L12;
        maybeReportRequestLog();
        return;
    }

    public void readResponseBodyStart() {
        this.readingResponseBody = true;
        if (this.networklib.misc.responseBodyReadTimes != (-1)) goto L5;
        this.networklib.misc.responseBodyReadTimes = 0;
    L5:
        this.networklib.misc.responseBodyReadTimes++;
        if (this.networklib.eventTs.firstReadResponseBodyStart != (-1)) goto L9;
        this.networklib.eventTs.firstReadResponseBodyStart = System.nanoTime();
    L9:
        if (this.networklib.misc.readResponseBodyInternal == false) goto L12;
        return;
    L12:
        if (this.networklib.bizSpan.waitReadResponseBody != (-1)) goto L19;
        if (this.retrofit.eventTs.bizReceiveResponseHeader == (-1)) goto L19;
        if (this.networklib.eventTs.firstReadResponseBodyStart <= this.retrofit.eventTs.bizReceiveResponseHeader) goto L19;
        this.networklib.bizSpan.waitReadResponseBody = this.networklib.eventTs.firstReadResponseBodyStart - this.retrofit.eventTs.bizReceiveResponseHeader;
    L19:
        if (this.networklib.eventTs.latestReadResponseBodyEnd != (-1)) goto L21;
    L24:
        this.networklib.innerSpan.recordInnerSpanStart();
        return;
    L21:
        if (this.networklib.bizSpan.readResponseBodyInterval != (-1)) goto L23;
        this.networklib.bizSpan.readResponseBodyInterval = 0;
    L23:
        this.networklib.bizSpan.readResponseBodyInterval += System.nanoTime() - this.networklib.eventTs.latestReadResponseBodyEnd;
        goto L24
    }

    @Deprecated
    public void recordInterceptorRequestEnd() {
        if (this.interceptorRequestInfos.size() > 0) goto L5;
        return;
    L5:
        List<InterceptorInfo> r2 = this.interceptorRequestInfos;
        ((InterceptorInfo) ZeusTransformUtils.preCheckCast(r2.get(r2.size() - 1), InterceptorInfo.class, "com.obric.memorydata.plugin")).end = SystemClock.uptimeMillis();
    }

    @Deprecated
    public void recordInterceptorRequestStart(Interceptor r5) {
        String r6 = ((Interceptor) ZeusTransformUtils.wrapperContextForParams(r5, Interceptor.class, "com.obric.memorydata.plugin")).getClass().getName();
        if (TextUtils.isEmpty(r6) == true) goto L6;
        String r7 = r6.substring(r6.lastIndexOf(46) + 1);
        this.interceptorRequestInfos.add(new InterceptorInfo(this, r7, SystemClock.uptimeMillis()));
        return;
    }

    @Deprecated
    public void recordInterceptorResponseEnd(Exception r6) {
        if (this.interceptorResponseInfos.size() > 0) goto L5;
        return;
    L5:
        List<InterceptorInfo> r0 = this.interceptorResponseInfos;
        ((InterceptorInfo) ZeusTransformUtils.preCheckCast(r0.get(r0.size() - 1), InterceptorInfo.class, "com.obric.memorydata.plugin")).end = SystemClock.uptimeMillis();
        if (r6 == null) goto L9;
        List<InterceptorInfo> r5 = this.interceptorResponseInfos;
        ((InterceptorInfo) ZeusTransformUtils.preCheckCast(r5.get(r5.size() - 1), InterceptorInfo.class, "com.obric.memorydata.plugin")).exception_name = r6.getClass().getSimpleName();
        return;
    }

    @Deprecated
    public void recordInterceptorResponseStart(Interceptor r5) {
        String r6 = ((Interceptor) ZeusTransformUtils.wrapperContextForParams(r5, Interceptor.class, "com.obric.memorydata.plugin")).getClass().getName();
        if (TextUtils.isEmpty(r6) == true) goto L6;
        String r7 = r6.substring(r6.lastIndexOf(46) + 1);
        this.interceptorResponseInfos.add(new InterceptorInfo(this, r7, SystemClock.uptimeMillis()));
        return;
    }

    public void requestAuditEnd() {
        NetworkLibLayerMetrics.BizSpan r0 = this.networklib.bizSpan;
        r0.requestAuditDuration = this.networklib.bizSpan.computeDurationNs();
    }

    public void requestAuditStart() {
        this.networklib.bizSpan.recordCallbackStart();
    }

    public void requestEnd() {
        RetrofitLayerMetrics.EventTimestamp r0 = this.retrofit.eventTs;
        r0.requestEnd = System.nanoTime();
        RetrofitLayerMetrics.EventTimestamp r1 = this.retrofit.eventTs;
        r1.requestEndTime = System.currentTimeMillis();
        WeakReference<LegacyLogRecorder> r2 = this.requestInfo;
        if (r2 == null) goto L6;
        ((LegacyLogRecorder) ZeusTransformUtils.preCheckCast(r2.get(), LegacyLogRecorder.class, "com.obric.memorydata.plugin")).setRequestEnd(this.retrofit.eventTs.requestEndTime);
        return;
    }

    public void requestRealStart() {
        long r0 = System.nanoTime();
        this.retrofit.eventTs.requestRealStart = r0;
        this.retrofit.innerSpan.reqDelay = r0 - this.retrofit.eventTs.ssHttpCallApiStart;
        if (this.retrofit.eventTs.toRequestStart > this.retrofit.eventTs.ssHttpCallApiStart) goto L5;
        return;
    L5:
        if (this.retrofit.innerSpan.toRequest == (-1)) goto L9;
        this.retrofit.innerSpan.reqDelay -= this.retrofit.innerSpan.toRequest;
        return;
    }

    public void requestVerifyEnd() {
        RetrofitLayerMetrics.BizSpan r0 = this.retrofit.bizSpan;
        r0.requestVerify = this.retrofit.bizSpan.computeDurationNs();
        this.requestVerifyDuration = TTMetricsUtil.nanoSecondsToMilliSeconds(this.retrofit.bizSpan.requestVerify);
    }

    public void requestVerifyStart() {
        this.retrofit.bizSpan.recordCallbackStart();
    }

    public void rotationRetryEnd() {
        if (this.networklib.bizSpan.rotationRetryAccumulatedDuration != (-1)) goto L5;
        this.networklib.bizSpan.rotationRetryAccumulatedDuration = 0;
    L5:
        this.networklib.bizSpan.rotationRetryAccumulatedDuration += this.networklib.bizSpan.computeDurationNs();
    }

    public void rotationRetryStart() {
        this.networklib.bizSpan.recordCallbackStart();
    }

    public void setBlockingQueueSize(int r2) {
        this.retrofit.misc.blockingQueueSize = r2;
        this.blockingQueueSize = r2;
    }

    @Deprecated
    public void setConstructConfigureAndRetryConnection(long r3) {
        NetworkLibLayerMetrics.ImportantInnerSpan r2 = this.networklib.innerSpan;
        r2.constructConfigureAndRetryConnection = System.nanoTime() - r3;
    }

    public void setCronetReadResponseBodyMetrics(long r2, long r4, long r6, long r8, long r10) {
        this.networklib.eventTs.firstReadResponseBodyStart = r4;
        this.networklib.eventTs.latestReadResponseBodyEnd = r6;
        this.networklib.misc.responseBodyReadTimes = r2;
        if (this.networklib.misc.readResponseBodyInternal == false) goto L5;
        return;
    L5:
        if (this.networklib.bizSpan.waitReadResponseBody == (-1)) goto L7;
    L11:
        this.networklib.bizSpan.readResponseBodyInterval = r10;
        this.networklib.innerSpan.readResponseBody = r8;
        return;
    L7:
        if (this.retrofit.eventTs.bizReceiveResponseHeader == (-1)) goto L11;
        if (this.networklib.eventTs.firstReadResponseBodyStart <= this.retrofit.eventTs.bizReceiveResponseHeader) goto L11;
        NetworkLibLayerMetrics.BizSpan r3 = this.networklib.bizSpan;
        r3.waitReadResponseBody = this.networklib.eventTs.firstReadResponseBodyStart - this.retrofit.eventTs.bizReceiveResponseHeader;
        goto L11
    }

    public void setEncryptType(EncryptType r1) {
        this.requestEncryptType = r1;
    }

    public void setInterceptorResponseThrowable(Throwable r2) {
        this.retrofit.misc.interceptorResponseThrowable = r2;
        this.interceptorResponseThrowable = r2;
    }

    public void setKernelDns(long r3) {
        this.networklib.kernelSpan.dns = r3;
        WeakReference<LegacyLogRecorder> r2 = this.requestInfo;
        if (r2 == null) goto L6;
        ((LegacyLogRecorder) ZeusTransformUtils.preCheckCast(r2.get(), LegacyLogRecorder.class, "com.obric.memorydata.plugin")).setKernelDns(r3);
        return;
    }

    public void setKernelPush(long r3) {
        this.networklib.kernelSpan.push = r3;
        WeakReference<LegacyLogRecorder> r2 = this.requestInfo;
        if (r2 == null) goto L6;
        ((LegacyLogRecorder) ZeusTransformUtils.preCheckCast(r2.get(), LegacyLogRecorder.class, "com.obric.memorydata.plugin")).setKernelPush(r3);
        return;
    }

    public void setKernelReceiveBody(long r3) {
        this.networklib.kernelSpan.receiveBody = r3;
        WeakReference<LegacyLogRecorder> r2 = this.requestInfo;
        if (r2 == null) goto L6;
        ((LegacyLogRecorder) ZeusTransformUtils.preCheckCast(r2.get(), LegacyLogRecorder.class, "com.obric.memorydata.plugin")).setKernelReceiveBody(r3);
        return;
    }

    public void setKernelSend(long r3) {
        this.networklib.kernelSpan.send = r3;
        WeakReference<LegacyLogRecorder> r2 = this.requestInfo;
        if (r2 == null) goto L6;
        ((LegacyLogRecorder) ZeusTransformUtils.preCheckCast(r2.get(), LegacyLogRecorder.class, "com.obric.memorydata.plugin")).setKernelSend(r3);
        return;
    }

    public void setKernelTCPConnect(long r3) {
        this.networklib.kernelSpan.tcpConnect = r3;
        WeakReference<LegacyLogRecorder> r2 = this.requestInfo;
        if (r2 == null) goto L6;
        ((LegacyLogRecorder) ZeusTransformUtils.preCheckCast(r2.get(), LegacyLogRecorder.class, "com.obric.memorydata.plugin")).setKernelTCPConnect(r3);
        return;
    }

    public void setKernelTTFB(long r3) {
        this.networklib.kernelSpan.ttfb = r3;
        WeakReference<LegacyLogRecorder> r2 = this.requestInfo;
        if (r2 == null) goto L6;
        ((LegacyLogRecorder) ZeusTransformUtils.preCheckCast(r2.get(), LegacyLogRecorder.class, "com.obric.memorydata.plugin")).setKernelTTFB(r3);
        return;
    }

    public void setKernelTls(long r3) {
        this.networklib.kernelSpan.tls = r3;
        WeakReference<LegacyLogRecorder> r2 = this.requestInfo;
        if (r2 == null) goto L6;
        ((LegacyLogRecorder) ZeusTransformUtils.preCheckCast(r2.get(), LegacyLogRecorder.class, "com.obric.memorydata.plugin")).setKernelTls(r3);
        return;
    }

    public void setKernelTotal(long r3) {
        this.networklib.kernelSpan.total = r3;
        WeakReference<LegacyLogRecorder> r2 = this.requestInfo;
        if (r2 == null) goto L6;
        ((LegacyLogRecorder) ZeusTransformUtils.preCheckCast(r2.get(), LegacyLogRecorder.class, "com.obric.memorydata.plugin")).setKernelTotal(r3);
        return;
    }

    public void setNetworkKernelRawRequestLog(String r3) {
        this.networklib.networkKernelRawRequestLog = r3;
        WeakReference<LegacyLogRecorder> r2 = this.requestInfo;
        if (r2 == null) goto L6;
        ((LegacyLogRecorder) ZeusTransformUtils.preCheckCast(r2.get(), LegacyLogRecorder.class, "com.obric.memorydata.plugin")).setNetworkKernelRawRequestLog(r3);
        return;
    }

    public void setPriorityLevel(int r3) {
        if (this.priorityLevel != (-999)) goto L6;
        this.priorityLevel = r3;
        return;
    }

    public void setRequestAuditLog(JSONObject r1) {
        this.networklib.misc.requestAuditLog = r1;
    }

    public void setRequestCookieRelMetric(String r1) {
        this.networklib.misc.requestCookieRelMetric = r1;
    }

    public void setRequestCookieSourceType(int r2) {
        this.networklib.misc.requestCookieSourceType = r2;
        this.requestCookieSourceType = r2;
    }

    public void setRequestEndAppResumeState(long r3) {
        this.retrofit.misc.requestEndAppResumeState = r3;
        WeakReference<LegacyLogRecorder> r2 = this.requestInfo;
        if (r2 == null) goto L6;
        ((LegacyLogRecorder) ZeusTransformUtils.preCheckCast(r2.get(), LegacyLogRecorder.class, "com.obric.memorydata.plugin")).setRequestEndAppResumeState(r3);
        return;
    }

    public void setRequestExtraInfo(Object r1) {
        this.networklib.misc.requestExtraInfo = r1;
    }

    public void setRotationHostRetryInfo(JSONObject r2) {
        this.networklib.misc.rotationHostRetryInfo = r2;
        this.rotationHostRetryInfo = r2;
    }

    public void setUpperAddCookieDurationUs(long r2) {
        this.networklib.kernelSpan.upperAddCookieDurationUs = r2;
        this.upperAddCookieDurationUs = r2;
    }

    public void setUpperSaveCookieDurationUs(long r2) {
        this.networklib.kernelSpan.upperSaveCookieDurationUs = r2;
        this.upperSaveCookieDurationUs = r2;
    }

    public void ssHttpCallApiEnd() {
        RetrofitLayerMetrics.EventTimestamp r0 = this.retrofit.eventTs;
        r0.ssHttpCallApiEnd = System.nanoTime();
        this.executeEndTime = TTMetricsUtil.nanoSecondsToMilliSeconds(this.retrofit.eventTs.ssHttpCallApiEnd);
    }

    public void ssHttpCallApiStart(boolean r7) {
        RetrofitLayerMetrics.EventTimestamp r0 = this.retrofit.eventTs;
        long r1 = System.currentTimeMillis();
        r0.ssHttpCallApiStartTime = r1;
        this.appLevelRequestStart = r1;
        this.retrofit.eventTs.ssHttpCallApiStart = System.nanoTime();
        if (r7 == false) goto L5;
        this.enqueueTime = TTMetricsUtil.nanoSecondsToMilliSeconds(this.retrofit.eventTs.ssHttpCallApiStart);
    L6:
        this.retrofit.misc.requestStartAppResumeState = AppActivityResumeSuspendRecorder.GetAppActivityResumeState();
        this.retrofit.bizSpan.waitSsHttpCallApiExecute = this.retrofit.eventTs.ssHttpCallApiStart - this.retrofit.eventTs.bizInvokeRetrofitRequestInterfaceEnd;
        if (this.retrofit.eventTs.toRequestEnd != (-1)) goto L9;
        return;
    L9:
        if (this.retrofit.eventTs.toRequestEnd < this.retrofit.eventTs.ssHttpCallApiStart) goto L11;
        return;
    L11:
        if (this.retrofit.innerSpan.toRequest == (-1)) goto L16;
        this.retrofit.bizSpan.waitSsHttpCallApiExecute -= this.retrofit.innerSpan.toRequest;
        return;
    L16:
        return;
    L5:
        this.executeTime = TTMetricsUtil.nanoSecondsToMilliSeconds(this.retrofit.eventTs.ssHttpCallApiStart);
        goto L6
    }

    public void toJson(JSONObject r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        WeakReference<LegacyLogRecorder> r0 = this.requestInfo;
        if (r0 == null) goto L8;
        ((LegacyLogRecorder) ZeusTransformUtils.preCheckCast(r0.get(), LegacyLogRecorder.class, "com.obric.memorydata.plugin")).generateOldFormatLog(r4);
    L8:
        if (sReportNewMetrics == false) goto L11;
        generateTTNetLog(r4);
        return;
    }

    public void toRequestEnd() {
        RetrofitLayerMetrics.ImportantInnerSpan r0 = this.retrofit.innerSpan;
        r0.toRequest = this.retrofit.innerSpan.computeDurationNs();
        RetrofitLayerMetrics.EventTimestamp r1 = this.retrofit.eventTs;
        r1.toRequestEnd = System.nanoTime();
        this.toRequestEndTime = TTMetricsUtil.nanoSecondsToMilliSeconds(this.retrofit.eventTs.toRequestEnd);
    }

    public void toRequestStart() {
        this.retrofit.innerSpan.recordInnerSpanStart();
        RetrofitLayerMetrics.EventTimestamp r0 = this.retrofit.eventTs;
        r0.toRequestStart = System.nanoTime();
        this.toRequestStartTime = TTMetricsUtil.nanoSecondsToMilliSeconds(this.retrofit.eventTs.toRequestStart);
    }

    public void toSsResponseEnd() {
        RetrofitLayerMetrics.ImportantInnerSpan r0 = this.retrofit.innerSpan;
        r0.toSsResponse = this.retrofit.innerSpan.computeDurationNs();
        this.toResponseEndTime = SystemClock.uptimeMillis();
    }

    public void toSsResponseStart() {
        this.retrofit.innerSpan.recordInnerSpanStart();
        this.toResponseStartTime = SystemClock.uptimeMillis();
    }

    public void tryInitCookieManagerEnd() {
        this.networklib.bizSpan.tryInitCookieManager = this.networklib.bizSpan.computeDurationNs();
        if (this.tryNecessaryInitDuration != (-1)) goto L5;
        this.tryNecessaryInitDuration = 0;
    L5:
        this.tryNecessaryInitDuration += TTMetricsUtil.nanoSecondsToMilliSeconds(this.networklib.bizSpan.tryInitCookieManager);
    }

    public void tryInitCookieManagerStart() {
        this.networklib.bizSpan.recordCallbackStart();
    }

    public void updateClientKeyEnd() {
        RetrofitLayerMetrics.ImportantInnerSpan r0 = this.retrofit.innerSpan;
        r0.updateClientKey = this.retrofit.innerSpan.computeDurationNs();
        this.updateClientKeyDuration = TTMetricsUtil.nanoSecondsToMilliSeconds(this.retrofit.innerSpan.updateClientKey);
    }

    public void updateClientKeyStart() {
        this.retrofit.innerSpan.recordInnerSpanStart();
    }
}
