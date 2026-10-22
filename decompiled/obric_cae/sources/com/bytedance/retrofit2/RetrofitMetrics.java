package com.bytedance.retrofit2;

import android.os.Build;
import android.text.TextUtils;
import com.qualcomm.qti.qesdk.QesdkUtils;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class RetrofitMetrics {
    public long addClientKeyDuration;
    public long addCommonParamDuration;
    public long appCreateRetrofitStart;
    public long appLevelRequestStart;
    public long beforeAllInterceptors;
    public long callExecuteStartTime;
    public long callServerInterceptorTime;
    public long checkReqTicketDuration;
    public long commandListenerDuration;
    public List<JSONObject> connectionAttempts;
    public long createSsHttpCallTime;
    public long dispatchDelayTime;
    public JSONArray dispatchQueryActionInfo;
    public long encryptRequestDuration;
    public long enqueueTime;
    public long executeCallEndTime;
    public long executeCallStartTime;
    public long executeTime;
    public Map<String, Long> extra;
    public String fallbackMessage;
    public int fallbackReason;
    public long filterDupQueryDuration;
    public long filterUrlDuration;
    public long genReqTicketDuration;
    public Map<String, Long> interceptorNameAndTime;
    public boolean isConcurrent;
    public long postCdnCacheVerifyDuration;
    public long preCdnCacheVerifyDuration;
    public long queryFilterDuration;
    public Map<String, Long> requestInterceptDuration;
    public long requestVerifyDuration;
    public long responseChainTime;
    public Map<String, Long> responseInterceptDuration;
    public long retrofitLogReportTime;
    public long retrofitMethodInvokeTime;
    public long toRequestEndTime;
    public long toRequestStartTime;
    public long toResponseEndTime;
    public long toResponseStartTime;
    public String transactionId;
    public String ttnetVersion;
    public long updateClientKeyDuration;

    public interface ExtraKeys {
        public static final String RECEIVED_BYTE_COUNT = "receivedByteCount";
        public static final String SENT_BYTE_COUNT = "sentByteCount";
        public static final String STREAM_READ_BYTE_COUNT = "streamReadByteCount";
        public static final String STREAM_READ_TIME = "streamReadTime";
    }

    public RetrofitMetrics() {
        this.fallbackReason = -1;
        this.fallbackMessage = "";
        this.requestInterceptDuration = new HashMap();
        this.responseInterceptDuration = new HashMap();
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
        this.extra = new HashMap();
        this.ttnetVersion = "";
        this.interceptorNameAndTime = new ConcurrentHashMap();
    }

    private JSONObject getBaseTimingInfo() {
        JSONObject r8 = new JSONObject();
        r8.put("fallback", this.fallbackReason);     // Catch: JSONException -> L10
        if (TextUtils.isEmpty(this.fallbackMessage) == true) goto L6;
        r8.put("fallbackMessage", this.fallbackMessage);     // Catch: JSONException -> L10
    L6:
        r8.put("createRetrofitTime", this.appCreateRetrofitStart);     // Catch: JSONException -> L10
        r8.put("appRequestStartTime", this.appLevelRequestStart);     // Catch: JSONException -> L10
        r8.put("beforeAllInterceptTime", this.beforeAllInterceptors);     // Catch: JSONException -> L10
        r8.put("callServerInterceptTime", this.callServerInterceptorTime);     // Catch: JSONException -> L10
        r8.put("callExecuteStartTime", this.callExecuteStartTime);     // Catch: JSONException -> L10
        r8.put("reportTime", this.retrofitLogReportTime);     // Catch: JSONException -> L10
        r8.put("delayWait", this.dispatchDelayTime);     // Catch: JSONException -> L10
        r8.put("injectInterceptorTime", getInjectInterceptorTimingInfo());     // Catch: JSONException -> L10
        if (TextUtils.isEmpty(this.transactionId) == true) goto L12;
        r8.put("transactionId", this.transactionId);     // Catch: JSONException -> L10
    L12:
        boolean r10 = validateAndSetTimingValue(r8, "loadServiceMethod", this.retrofitMethodInvokeTime, this.createSsHttpCallTime, true);
        long r11 = this.enqueueTime;
        if (r11 <= 0) goto L15;
        String r12 = "enqueueWait";
    L16:
        boolean r13 = validateAndSetTimingValue(r8, r12, r11, this.responseChainTime, r10);
        boolean r14 = validateAndSetTimingValue(r8, "executeCall", this.executeCallStartTime, this.executeCallEndTime, r13);
        boolean r15 = validateAndSetTimingValue(r8, "requestParse", this.toRequestStartTime, this.toRequestEndTime, r14);
        validateAndSetTimingValue(r8, "responseParse", this.toResponseStartTime, this.toResponseEndTime, r15);
        return r8;
    L15:
        r12 = "executeWait";
        r11 = this.executeTime;
    L10:
        e = move-exception;
        e.printStackTrace();
        goto L12
    }

    private JSONObject getCallbackTimingInfo() {
        JSONObject r8 = new JSONObject();
        r8.put("filterUrl", this.filterUrlDuration);     // Catch: JSONException -> L5
        r8.put("addCommonParam", this.addCommonParamDuration);     // Catch: JSONException -> L5
        r8.put("requestVerify", this.requestVerifyDuration);     // Catch: JSONException -> L5
        r8.put("encryptRequest", this.encryptRequestDuration);     // Catch: JSONException -> L5
        r8.put("genReqTicket", this.genReqTicketDuration);     // Catch: JSONException -> L5
        r8.put("checkReqTicket", this.checkReqTicketDuration);     // Catch: JSONException -> L5
        r8.put("preCdnVerify", this.preCdnCacheVerifyDuration);     // Catch: JSONException -> L5
        r8.put("postCdnVerify", this.postCdnCacheVerifyDuration);     // Catch: JSONException -> L5
        r8.put("addClientKey", this.addClientKeyDuration);     // Catch: JSONException -> L5
        r8.put("updateClientKey", this.updateClientKeyDuration);     // Catch: JSONException -> L5
        r8.put("commandListener", this.commandListenerDuration);     // Catch: JSONException -> L5
        r8.put("filterDupQuery", this.filterDupQueryDuration);     // Catch: JSONException -> L5
        r8.put("queryFilter", this.queryFilterDuration);     // Catch: JSONException -> L5
    L7:
        return r8;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    private JSONObject getInjectInterceptorTimingInfo() {
        JSONObject r8 = new JSONObject();
        Iterator<Map.Entry<String, Long>> r10 = this.interceptorNameAndTime.entrySet().iterator();     // Catch: JSONException -> L8
    L5:
        if (r10.hasNext() == false) goto L10;
        Map.Entry<String, Long> r11 = r10.next();     // Catch: JSONException -> L8
        r8.put(r11.getKey(), r11.getValue());     // Catch: JSONException -> L8
    L10:
        return r8;
    L8:
        e = move-exception;
        e.printStackTrace();
        goto L10
    }

    private JSONObject getInterceptorTimingInfo() {
        JSONObject r8 = new JSONObject();
    L18:
        e = move-exception;
        e.printStackTrace();
    L20:
        return r8;
    L4:
        if (this.requestInterceptDuration.isEmpty() == true) goto L11;
        JSONObject r10 = new JSONObject();     // Catch: JSONException -> L18
        Iterator<Map.Entry<String, Long>> r11 = this.requestInterceptDuration.entrySet().iterator();     // Catch: JSONException -> L18
    L7:
        if (r11.hasNext() == false) goto L9;
        Map.Entry<String, Long> r12 = r11.next();     // Catch: JSONException -> L18
        r10.put(r12.getKey(), r12.getValue());     // Catch: JSONException -> L18
        goto L7
    L9:
        r8.put("request", r10);     // Catch: JSONException -> L18
    L11:
        if (this.responseInterceptDuration.isEmpty() == true) goto L20;
        JSONObject r13 = new JSONObject();     // Catch: JSONException -> L18
        Iterator<Map.Entry<String, Long>> r14 = this.responseInterceptDuration.entrySet().iterator();     // Catch: JSONException -> L18
    L14:
        if (r14.hasNext() == false) goto L16;
        Map.Entry<String, Long> r15 = r14.next();     // Catch: JSONException -> L18
        r13.put(r15.getKey(), r15.getValue());     // Catch: JSONException -> L18
        goto L14
    L16:
        r8.put("response", r13);     // Catch: JSONException -> L18
        goto L20
    }

    private JSONObject getModelInfoWhenFallback() {
        JSONObject r8 = new JSONObject();
        r8.put("model", Build.MODEL);     // Catch: JSONException -> L10
        String r10 = "";
        String[] r11 = Build.SUPPORTED_ABIS;     // Catch: JSONException -> L10
        if (r11 != null) goto L6;
    L8:
        r8.put("abis", r10);     // Catch: JSONException -> L10
    L12:
        return r8;
    L6:
        if (r11.length <= 0) goto L8;
        r10 = Arrays.asList(r11).toString();     // Catch: JSONException -> L10
    L10:
        e = move-exception;
        e.printStackTrace();
        goto L12
    }

    private boolean validateAndSetTimingValue(JSONObject r8, String r10, long r11, long r12, boolean r13) {
        if (r13 == true) goto L5;
    L10:
        r8.put(r10, -1);     // Catch: JSONException -> L12
        return false;
    L5:
        if (r11 > r12) goto L10;
        r8.put(r10, r12 - r11);     // Catch: JSONException -> L12
        return true;
    L12:
        e = move-exception;
        e.printStackTrace();
        return false;
    }

    public String getRetrofitLog() {
        JSONObject r8 = new JSONObject();
    L19:
        e = move-exception;
        e.printStackTrace();
    L22:
        return r8.toString();
    L4:
        if (this.fallbackReason == (-1)) goto L6;
        r8.put("model", getModelInfoWhenFallback());     // Catch: JSONException -> L19
    L6:
        List<JSONObject> r10 = this.connectionAttempts;     // Catch: JSONException -> L19
        if (r10 != null) goto L9;
    L15:
        r8.put("concurrent", this.isConcurrent);     // Catch: JSONException -> L19
        r8.put("base", getBaseTimingInfo());     // Catch: JSONException -> L19
        r8.put(QesdkUtils.TAGS.JSON_TAG_CALLBACK, getCallbackTimingInfo());     // Catch: JSONException -> L19
        r8.put("interceptor", getInterceptorTimingInfo());     // Catch: JSONException -> L19
        r8.put("ttnetVersion", this.ttnetVersion);     // Catch: JSONException -> L19
        JSONArray r11 = this.dispatchQueryActionInfo;     // Catch: JSONException -> L19
        if (r11 == null) goto L22;
        r8.put("actionInfo", r11);     // Catch: JSONException -> L19
        goto L22
    L9:
        if (r10.isEmpty() == true) goto L15;
        JSONArray r12 = new JSONArray();     // Catch: JSONException -> L19
        Iterator<JSONObject> r13 = this.connectionAttempts.iterator();     // Catch: JSONException -> L19
    L12:
        if (r13.hasNext() == false) goto L14;
        r12.put(r13.next());     // Catch: JSONException -> L19
        goto L12
    L14:
        r8.put("connectionAttempts", r12);     // Catch: JSONException -> L19
        goto L15
    }

    public RetrofitMetrics(long r8, long r10) {
        this.fallbackReason = -1;
        this.fallbackMessage = "";
        this.requestInterceptDuration = new HashMap();
        this.responseInterceptDuration = new HashMap();
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
        this.extra = new HashMap();
        this.ttnetVersion = "";
        this.interceptorNameAndTime = new ConcurrentHashMap();
        this.appLevelRequestStart = r8;
        this.beforeAllInterceptors = r10;
    }
}
