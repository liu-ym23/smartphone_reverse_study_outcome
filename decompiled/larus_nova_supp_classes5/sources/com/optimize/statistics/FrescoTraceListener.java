package com.optimize.statistics;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.frameworks.baselib.network.http.BaseHttpRequestInfo;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.CronetIOException;
import com.bytedance.frameworks.baselib.network.http.exception.HttpResponseException;
import com.bytedance.frameworks.baselib.network.http.util.UrlBuilder;
import com.bytedance.frameworks.baselib.network.http.util.UrlUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.mime.TypedInput;
import com.bytedance.ttnet.HttpClient;
import com.bytedance.ttnet.TTNetInit;
import com.bytedance.ttnet.http.HttpRequestInfo;
import com.facebook.common.logging.FLog;
import com.facebook.imagepipeline.SizeDeterminer;
import com.facebook.imagepipeline.common.SimplayerImageStrategy;
import com.facebook.imagepipeline.core.FrescoCacheMonitorUtil;
import com.facebook.imagepipeline.exception.IBDException;
import com.facebook.imagepipeline.listener.BaseRequestListener;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import com.facebook.net.FrescoTTNetFetcher;
import com.facebook.net.ImageNetworkCallback;
import com.facebook.net.NetUtils;
import com.facebook.net.ResponseWrap;
import com.facebook.net.RetryInterceptManager;
import com.optimize.statistics.sampling.IFrescoMonitorSamplingDecider;
import com.ss.alog.middleware.ALogService;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public class FrescoTraceListener extends BaseRequestListener {
    public static final String ALOGTAG = "Fresco";
    private static final String CLIENT_CRONET = "CronetClient";
    public static final String CLIENT_MDL = "MDLClient";
    private static final String CLIENT_TT_OK3 = "TTOkhttp3Client";
    public static final String IMAGE_MONITOR_DATA = "image_monitor_data";
    private static final String NW_SESSION_TRACE = "Nw-Session-Trace";
    private static final String REMOTEIP = "x-net-info.remoteaddr";
    public static final String TAG = "FrescoTraceListener";
    private static ExecutorService sExecutor;
    private ImageNetworkCallback mImageCallBack;
    private ConcurrentHashMap<String, RequestInfo> mRequestInfoMap;

    public void onProducerEvent(String r1, String r2, String r3) {
    }

    public void onProducerFinishWithCancellation(String r1, String r2, Map<String, String> r3) {
    }

    static {
        sExecutor = PThreadExecutorsUtils.newFixedThreadPool(1, new AnonymousClass1());
    }

    public FrescoTraceListener() {
        this.mImageCallBack = new AnonymousClass2(this);
        this.mRequestInfoMap = new ConcurrentHashMap();
        FrescoTTNetFetcher.setImageCallBack(this.mImageCallBack);
    }

    private long getTime() {
        return System.currentTimeMillis();
    }

    public ImageNetworkCallback getImageNetworkCallback() {
        return this.mImageCallBack;
    }

    public static /* synthetic */ ConcurrentHashMap access$000(FrescoTraceListener r0) {
        return r0.mRequestInfoMap;
    }

    private long calAppliedImagePxCount(JSONObject r3) {
        String r4 = r3.optString("applied_image_size");
        if (r4 != null) goto L5;
        return 0;
    L5:
        Pair<Integer, Integer> r5 = segmentAndCheckSize(r4);
        if (r5 != null) goto L9;
        return 0;
    L9:
        return ((Integer) r5.first).intValue() * ((Integer) r5.second).intValue();
    }

    private long calIntendedImagePxCount(JSONObject r3) {
        String r4 = r3.optString("intended_image_size");
        if (r4 != null) goto L5;
        return 0;
    L5:
        Pair<Integer, Integer> r5 = segmentAndCheckSize(r4);
        if (r5 != null) goto L9;
        return 0;
    L9:
        return ((Integer) r5.first).intValue() * ((Integer) r5.second).intValue();
    }

    private String calViewImageSize(ImageRequest r3) {
        SizeDeterminer r4 = r3.getSizeDeterminer();
        if (r4 != null) goto L5;
        return "";
    L5:
        Pair r5 = r4.getSize();
        if (r5 != null) goto L9;
        return "";
    L9:
        return r5.first + "*" + r5.second;
    }

    private long calViewNeedImagePxCount(ImageRequest r3) {
        SizeDeterminer r4 = r3.getSizeDeterminer();
        if (r4 != null) goto L5;
        return 0;
    L5:
        Pair r5 = r4.getSize();
        if (r5 != null) goto L9;
        return 0;
    L9:
        return ((Integer) r5.first).intValue() * ((Integer) r5.second).intValue();
    }

    private String encodeUrl(String r7) {
        if (StringUtils.isEmpty(r7) == false) goto L33;
        return r7;
    L33:
        LinkedHashMap r0 = new LinkedHashMap();     // Catch: Throwable -> L30
        Pair r1 = UrlUtils.parseUrlWithValueList(r7, r0);     // Catch: Throwable -> L30
        if (r1 != null) goto L8;
        return r7;
    L8:
        UrlBuilder r2 = new UrlBuilder(((String) r1.first) + ((String) r1.second));     // Catch: Throwable -> L30
        if (r0.isEmpty() == true) goto L28;
        Iterator r3 = r0.entrySet().iterator();     // Catch: Throwable -> L30
    L12:
        if (r3.hasNext() == false) goto L28;
        Map.Entry r4 = (Map.Entry) r3.next();     // Catch: Throwable -> L30
        if (r4 == null) goto L12;
        if (r4.getKey() == null) goto L12;
        List r5 = (List) r4.getValue();     // Catch: Throwable -> L30
        if (r5 == null) goto L12;
        if (r5.isEmpty() == true) goto L12;
        Iterator r6 = r5.iterator();     // Catch: Throwable -> L30
    L26:
        if (r6.hasNext() == false) goto L12;
        r2.addParam((String) r4.getKey(), (String) r6.next());     // Catch: Throwable -> L30
    L28:
        return r2.build();
    L30:
        th = move-exception;
        th.printStackTrace();
        return r7;
    }

    private static int getErrCodeFromThrowable(Throwable r1) {
        if (r1 != null) goto L5;
        return 200;
    L5:
        if ((r1 instanceof IBDException) == false) goto L9;
        return ((IBDException) r1).getErrorCode();
    L9:
        return NetUtils.checkHttpRequestException(r1);
    }

    private static String getErrMsg(Throwable r2) {
        if ((r2 instanceof IBDException) == false) goto L5;
        String r0 = ((IBDException) r2).getErrorMessage();
    L7:
        if ((r2 instanceof CronetIOException) == true) goto L11;
        if ((r2 instanceof HttpResponseException) == true) goto L11;
        return r0;
    L11:
        return r2.getMessage();
    L5:
        r0 = null;
        goto L7
    }

    private JSONObject getExtra(JSONObject r3) {
        JSONObject r1 = r3.optJSONObject(DBDefinition.EXTRA);     // Catch: JSONException -> L7
        if (r1 != null) goto L12;
        JSONObject r2 = new JSONObject();     // Catch: JSONException -> L7
        r3.put(DBDefinition.EXTRA, r2);     // Catch: JSONException -> L7
        return r2;
    L12:
        return r1;
    L7:
        e = move-exception;
        FLog.e(TAG, "construct extra error", new Object[]{e.getMessage()});
        return null;
    }

    private JSONObject getHeaders(JSONObject r3) {
        JSONObject r1 = r3.optJSONObject("headers");     // Catch: JSONException -> L7
        if (r1 != null) goto L12;
        JSONObject r2 = new JSONObject();     // Catch: JSONException -> L7
        r3.put("headers", r2);     // Catch: JSONException -> L7
        return r2;
    L12:
        return r1;
    L7:
        e = move-exception;
        FLog.e(TAG, "construct headers error", new Object[]{e.getMessage()});
        return null;
    }

    public static Map<String, String> handleDemotion(SsResponse<TypedInput> r6) {
        HashMap r0 = new HashMap();
        String r1 = getHeaderForName(r6.headers(), "ImageX-Demotion");
        if (r1 != null) goto L5;
        r1 = "undefined";
    L5:
        String r7 = getHeaderForName(r6.headers(), "ImageX-Fmt");
        if (r7 != null) goto L8;
        String[] r8 = null;
    L9:
        if (r8 != null) goto L11;
    L16:
        String r9 = "undefined";
        String r3 = r9;
    L18:
        if ("undefined".equals(r3) == false) goto L20;
    L25:
        String r2 = "-1";
    L26:
        r0.put("imagex_demotion", r1);
        r0.put("imagex_want_fmt", r3);
        r0.put("imagex_true_fmt", r9);
        r0.put("imagex_consistency", r2);
        return r0;
    L20:
        if ("undefined".equals(r9) == true) goto L25;
        if (r3.equalsIgnoreCase(r9) == false) goto L24;
        r2 = "1";
        goto L26
    L24:
        r2 = "0";
        goto L26
    L11:
        if (r8.length <= 0) goto L16;
        r3 = r8[0];
        if (r8.length <= 1) goto L15;
        r9 = r8[1];
        goto L18
    L15:
        r9 = "undefined";
        goto L18
    L8:
        r8 = r7.split("2");
        goto L9
    }

    private static boolean isCanceledInfo(String r2) {
        if (TextUtils.isEmpty(r2) == false) goto L6;
        return false;
    L6:
        if (r2.contains("Canceled") == false) goto L8;
    L9:
        return true;
    L8:
        if (r2.contains("canceled") == true) goto L9;
        return false;
    }

    private Pair<Integer, Integer> segmentAndCheckSize(String r4) {
        if (TextUtils.isEmpty(r4) == false) goto L5;
        return null;
    L5:
        String[] r5 = r4.split("x");
        if (r5.length == 2) goto L13;
        return null;
    L13:
        int r0 = CastIntegerProtector.parseInt(r5[0]);     // Catch: NumberFormatException -> L12
        int r6 = CastIntegerProtector.parseInt(r5[1]);     // Catch: NumberFormatException -> L12
        return new Pair(Integer.valueOf(r0), Integer.valueOf(r6));
    L15:
        return null;
    }

    private JSONObject shallowCopy(JSONObject r5) {
        JSONObject r0 = new JSONObject();
        Iterator<String> r1 = r5.keys();
    L4:
        if (r1.hasNext() == false) goto L9;
        String r2 = r1.next();
        r0.put(r2, r5.opt(r2));     // Catch: JSONException -> L8
        goto L4
    L9:
        return r0;
    }

    private JSONObject uriQueryParamToExtra(JSONObject r9) {
        String r4 = r9.optString("uri", null);     // Catch: JSONException -> L26
        String r5 = r9.optString("biz_tag", null);     // Catch: JSONException -> L26
        if (TextUtils.isEmpty(r4) == true) goto L28;
        Uri r6 = UriProtector.parse(r4);     // Catch: JSONException -> L26
        if (r5 != null) goto L20;
        String r7 = UriProtector.getQueryParameter(r6, "biz_tag");     // Catch: JSONException -> L26
        if (TextUtils.isEmpty(r7) == false) goto L11;
        r7 = UriProtector.getQueryParameter(r6, "from");     // Catch: JSONException -> L26
    L11:
        if (TextUtils.isEmpty(r7) == false) goto L18;
        String r8 = r6.getPath();     // Catch: JSONException -> L26
        if (r8 == null) goto L15;
        int r10 = r8.lastIndexOf(47);     // Catch: JSONException -> L26
    L16:
        if (r10 <= 0) goto L18;
        r7 = r8.substring(0, r10);     // Catch: JSONException -> L26
        goto L18
    L15:
        r10 = -1;
    L18:
        if (r7 == null) goto L20;
        r9.put("biz_tag", r7);     // Catch: JSONException -> L26
    L20:
        String r2 = UriProtector.getQueryParameter(r6, "imagex_flight_id");     // Catch: JSONException -> L26
        String r11 = UriProtector.getQueryParameter(r6, "imagex_vid");     // Catch: JSONException -> L26
        if (TextUtils.isEmpty(r2) == true) goto L23;
    L24:
        JSONObject r12 = getExtra(r9);     // Catch: JSONException -> L26
        r12.put("imagex_flight_id", r2);     // Catch: JSONException -> L26
        r12.put("imagex_vid", r11);     // Catch: JSONException -> L26
        goto L28
    L23:
        if (TextUtils.isEmpty(r11) == false) goto L24;
    L28:
        return r9;
    L26:
        e = move-exception;
        FLog.e(TAG, "uriQueryParamToExtra error", new Object[]{e.getMessage()});
        goto L28
    }

    public void onRequestCancellation(String r5) {
        long r0 = getTime();
        sExecutor.submit(new 5(this, r5, r0));
    }

    public boolean requiresExtraMap(String r4) {
        if (FrescoCacheMonitorUtil.isOptMonitorSample() == true) goto L5;
        return true;
    L5:
        RequestInfo r5 = this.mRequestInfoMap.get(r4);
        if (r5 != null) goto L9;
        return false;
    L9:
        if (r5.reportV2Enabled == false) goto L11;
        return true;
    L11:
        if (r5.reportExceedLimitEnabled == true) goto L16;
        return false;
    L16:
        return true;
    }

    public static /* synthetic */ void access$100(ResponseWrap r0, JSONObject r1) {
        packageResponseHeader(r0, r1);
    }

    private static String formatString(String r1, Object... r2) {
        return String.format(null, r1, r2);
    }

    private long getCurrentTime(Long r3, long r4) {
        if (r3 != null) goto L4;
        return -1;
    L4:
        return r4 - r3.longValue();
    }

    private static String getHeaderForName(List<Header> r3, String r4) {
        String r0 = null;
        if (r3 != null) goto L5;
    L12:
        return r0;
    L5:
        if (r3.size() <= 0) goto L12;
        Iterator<Header> r5 = r3.iterator();
    L8:
        if (r5.hasNext() == false) goto L12;
        Header r1 = r5.next();
        if (r4.equalsIgnoreCase(r1.getName()) == false) goto L8;
        r0 = r1.getValue();
        goto L8
    }

    private boolean isNeedReport(ImageRequest r4, JSONObject r5) {
        if (FrescoMonitor.isNeedReportAllSourceUriType() == false) goto L6;
        return true;
    L6:
        if (FrescoMonitor.isReportHitCacheEnabled() == false) goto L13;
        if (r4.getSourceUriType() == 0) goto L14;
        return false;
    L14:
        return true;
    L13:
        return r5.optBoolean("is_request_network", false);
    }

    private void onRequestCancellationInternal(String r11, long r12) {
        RequestInfo r2 = this.mRequestInfoMap.remove(r11);
        if (r2 != null) goto L5;
        return;
    L5:
        int r5 = 1;
        if (FrescoMonitor.isEnableMonitorLog() == false) goto L8;
        ALogService.dSafely(ALOGTAG, formatString("time %d: onRequestCancellation: {requestId: %s, elapsedTime: %d ms}", new Object[]{Long.valueOf(r12), r11, Long.valueOf(getCurrentTime(Long.valueOf(r2.requestStartTime), r12))}));
    L8:
        JSONObject r9 = r2.extra;
        r9.put("load_status", "cancel");     // Catch: JSONException -> L15
        r9.put("duration", getCurrentTime(Long.valueOf(r2.requestStartTime), r12));     // Catch: JSONException -> L15
        r9.put("timestamp", Long.valueOf(r2.requestStartTime));     // Catch: JSONException -> L15
        if (RetryInterceptManager.inst().isOpen() == true) goto L13;
        r5 = 0;
    L13:
        r9.put("retry_open", r5);     // Catch: JSONException -> L15
    L17:
        hookMonitor(null, r11, r2.callerContext, r9, false, r9.optBoolean("is_request_network", false), true);
        uriQueryParamToExtra(r9);
        return;
    L15:
        e = move-exception;
        FLog.e(TAG, e, "", new Object[0]);
        goto L17
    }

    public static void packageRequestParameters(HttpRequestInfo r4, JSONObject r5) {
        if (r4 == null) goto L25;
        if (r5 == null) goto L27;
        JSONObject r0 = new JSONObject();
        r0.put("requestStart", ((BaseHttpRequestInfo) r4).requestStart);     // Catch: JSONException -> L18
        r0.put("responseBack", ((BaseHttpRequestInfo) r4).responseBack);     // Catch: JSONException -> L18
        r0.put("completeReadResponse", ((BaseHttpRequestInfo) r4).completeReadResponse);     // Catch: JSONException -> L18
        r0.put("requestEnd", ((BaseHttpRequestInfo) r4).requestEnd);     // Catch: JSONException -> L18
        r0.put("recycleCount", ((BaseHttpRequestInfo) r4).recycleCount);     // Catch: JSONException -> L18
        if (((BaseHttpRequestInfo) r4).httpClientType != 0) goto L9;
        r0.put("timing_dns", ((BaseHttpRequestInfo) r4).dnsTime);     // Catch: JSONException -> L18
        r0.put("timing_connect", ((BaseHttpRequestInfo) r4).connectTime);     // Catch: JSONException -> L18
        r0.put("timing_ssl", ((BaseHttpRequestInfo) r4).sslTime);     // Catch: JSONException -> L18
        r0.put("timing_send", ((BaseHttpRequestInfo) r4).sendTime);     // Catch: JSONException -> L18
        r0.put("timing_wait", ((BaseHttpRequestInfo) r4).ttfbMs);     // Catch: JSONException -> L18
        r0.put("timing_receive", ((BaseHttpRequestInfo) r4).receiveTime);     // Catch: JSONException -> L18
        r0.put("timing_total", ((BaseHttpRequestInfo) r4).totalTime);     // Catch: JSONException -> L18
        r0.put("timing_isSocketReused", ((BaseHttpRequestInfo) r4).isSocketReused);     // Catch: JSONException -> L18
        r0.put("timing_totalSendBytes", ((BaseHttpRequestInfo) r4).sentByteCount);     // Catch: JSONException -> L18
        r0.put("timing_totalReceivedBytes", ((BaseHttpRequestInfo) r4).receivedByteCount);     // Catch: JSONException -> L18
        r0.put("timing_remoteIP", ((BaseHttpRequestInfo) r4).remoteIp);     // Catch: JSONException -> L18
        r0.put("request_log", ((BaseHttpRequestInfo) r4).requestLog);     // Catch: JSONException -> L18
    L9:
        JSONObject r1 = ((BaseHttpRequestInfo) r4).extraInfo;     // Catch: JSONException -> L18
        if (r1 == null) goto L12;
        r0.put("req_info", r1);     // Catch: JSONException -> L18
    L12:
        r0.put("download", ((BaseHttpRequestInfo) r4).downloadFile);     // Catch: JSONException -> L18
        r5.put("net_timing_detail", r0);     // Catch: JSONException -> L18
        if (HttpClient.isCronetClientEnable() == false) goto L16;
        r5.put("netClientType", CLIENT_CRONET);     // Catch: JSONException -> L18
        return;
    L16:
        r5.put("netClientType", CLIENT_TT_OK3);     // Catch: JSONException -> L18
        return;
    L18:
        e = move-exception;
        if (StatLogUtils.IsDebug() == false) goto L22;
        StatLogUtils.e("packageRequestParameters " + Log.getStackTraceString(e));
    L22:
        e.printStackTrace();
        return;
    L27:
        return;
    }

    private static void packageResponseHeader(ResponseWrap r5, JSONObject r6) {
        SsResponse r1 = r5.ssResponse;     // Catch: Exception -> L29
        String r3 = "";
        if (r1 == null) goto L12;
        Header r2 = r1.raw().getFirstHeader(NW_SESSION_TRACE);     // Catch: Exception -> L29
        Header r4 = r5.ssResponse.raw().getFirstHeader(REMOTEIP);     // Catch: Exception -> L29
        if (r2 == null) goto L9;
        String r7 = r5.ssResponse.raw().getFirstHeader(NW_SESSION_TRACE).getValue();     // Catch: Exception -> L29
    L10:
        if (r4 == null) goto L18;
        String r8 = r5.ssResponse.raw().getFirstHeader(REMOTEIP).getValue();     // Catch: Exception -> L29
    L21:
        if (r7 != null) goto L24;
        r7 = "";
    L24:
        r6.put("nw-session-trace", r7);     // Catch: Exception -> L29
        if (r8 == null) goto L27;
        r3 = r8;
    L27:
        r6.put("server_ip", r3);     // Catch: Exception -> L29
        return;
    L18:
        r8 = "";
        goto L21
    L9:
        r7 = "";
        goto L10
    L12:
        Response r0 = r5.response;     // Catch: Exception -> L29
        if (r0 == null) goto L15;
        r7 = r0.header(NW_SESSION_TRACE);     // Catch: Exception -> L29
        r8 = r5.response.header("x-snssdk.remoteaddr");     // Catch: Exception -> L29
        goto L21
    L15:
        Map r9 = r5.headers;     // Catch: Exception -> L29
        if (r9 == null) goto L19;
        r7 = (String) r9.get(NW_SESSION_TRACE);     // Catch: Exception -> L29
        goto L18
    L19:
        r8 = "";
        r7 = r8;
    L29:
        e = move-exception;
        if (StatLogUtils.IsDebug() == false) goto L33;
        StatLogUtils.e("packageResponseHeader " + Log.getStackTraceString(e));
    L33:
        e.printStackTrace();
    }

    public void onProducerStart(String r5, String r6) {
        long r0 = getTime();
        RequestInfo r2 = this.mRequestInfoMap.get(r5);
        if (r2 != null) goto L6;
        return;
    L6:
        if (r2.reportV2Enabled == false) goto L8;
    L10:
        StringBuilder r3 = new StringBuilder(r5);
        Map r7 = r2.producerStartTimeMap;
        r3.append(r6);
        r7.put(r3.toString(), Long.valueOf(r0));
        JSONObject r8 = r2.extra;
        if (r8 == null) goto L21;
        JSONObject r9 = r8.optJSONObject(IMAGE_MONITOR_DATA);     // Catch: JSONException -> L16
        if (r9 == null) goto L22;
        r9.put(r6, new JSONObject());     // Catch: JSONException -> L16
        return;
    L22:
        return;
    L16:
        e = move-exception;
        e.printStackTrace();
        return;
    L21:
        return;
    L8:
        if (r2.reportExceedLimitEnabled == true) goto L10;
    }

    public static /* synthetic */ void access$400(FrescoTraceListener r0, String r1, long r2) {
        r0.onRequestCancellationInternal(r1, r2);
    }

    private void onRequestSuccessInternal(ImageRequest r30, String r31, long r32) {
        String r14 = r31;
        long r12 = r32;
        if (FrescoSystrace.isTracing() == false) goto L5;
        FrescoSystrace.beginSection("FrescoMonitor#onImageLoaded");
    L5:
        RequestInfo r7 = this.mRequestInfoMap.remove(r14);
        if (r7 != null) goto L12;
        if (FrescoSystrace.isTracing() == false) goto L142;
        FrescoSystrace.endSection();
        return;
    L142:
        return;
    L12:
        if (r7.reportV2Enabled == true) goto L20;
        if (r7.reportExceedLimitEnabled == true) goto L20;
        if (FrescoSystrace.isTracing() == false) goto L143;
        FrescoSystrace.endSection();
        return;
    L143:
        return;
    L20:
        if (r30 != null) goto L22;
    L24:
        String r1 = "";
    L25:
        IFrescoMonitorSamplingDecider r0 = FrescoMonitor.getSamplingDecider();
        if (r0 != null) goto L134;
    L31:
        boolean r2 = true;
    L33:
        if (FrescoMonitor.isEnableMonitorLog() == false) goto L39;
        Object[] r3 = new Object[3];
        if (r2 == false) goto L37;
        String r18 = "hit";
    L38:
        r3[0] = r18;
        r3[1] = r1;
        r3[2] = r14;
        ALogService.dSafely(ALOGTAG, formatString("sampling %s onRequestSuccess: {url: %s, requestId: %s}", r3));
        goto L39
    L37:
        r18 = "miss";
    L39:
        if (r2 == false) goto L41;
        JSONObject r4 = r7.extra;
        if (FrescoMonitor.isReportHitCacheEnabled() == true) goto L47;
        boolean r5 = false;
        boolean r19 = r4.optBoolean("is_request_network", false);
    L53:
        if (r4.optBoolean("is_request_network", r5) == true) goto L55;
    L57:
        String r6 = ALOGTAG;
    L140:
        Object r8 = r7.callerContext;     // Catch: JSONException -> L82
        if ((r8 instanceof String) == false) goto L61;
        r4.put("scene_tag", r8);     // Catch: JSONException -> L82
    L65:
        SizeDeterminer r9 = r30.getSizeDeterminer();     // Catch: JSONException -> L82
        if (r9 == null) goto L73;
        if (r9.getView() == null) goto L73;
        Context r10 = r9.getView().getContext();     // Catch: JSONException -> L82
        if ((r10 instanceof Activity) == false) goto L73;
        r4.put("page_tag", ((Activity) r10).getClass().getSimpleName());     // Catch: JSONException -> L82
    L73:
        String r21 = r6;
        r4.put("duration", getCurrentTime(Long.valueOf(r7.requestStartTime), r12));     // Catch: JSONException -> L80
        r4.put("load_status", "success");     // Catch: JSONException -> L80
        r4.put("timestamp", Long.valueOf(r7.requestStartTime));     // Catch: JSONException -> L80
        r4.put("log_type", "image_monitor_v2");     // Catch: JSONException -> L80
        r4.put("log_version", 1);     // Catch: JSONException -> L80
        r4.put("uri", r30.getSourceUri().toString());     // Catch: JSONException -> L80
        r4.put("image_sdk_version", "1.41.6");     // Catch: JSONException -> L80
        if (RetryInterceptManager.inst().isOpen() == false) goto L77;
        int r11 = 1;
    L78:
        r4.put("retry_open", r11);     // Catch: JSONException -> L80
        r4.put("source_uri_type", r30.getSourceUriType());     // Catch: JSONException -> L80
        r4.put("network_quality", TTNetInit.getEffectiveConnectionType());     // Catch: JSONException -> L80
    L85:
        String r110 = r21;
        String r15 = "scene_tag";
        if (hookMonitor(r30, r31, r7.callerContext, r4, true, r19, false) == true) goto L88;
        return;
    L88:
        uriQueryParamToExtra(r4);
        if (r19 == true) goto L136;
        r12 = r12;
        r14 = r14;
        r15 = r15;
        RequestInfo r13 = r7;
    L124:
        char r16 = 1;
    L126:
        if (r4.optBoolean("is_request_network", false) == false) goto L131;
        if (FrescoMonitor.isEnableMonitorLog() == false) goto L131;
        Object[] r17 = new Object[5];
        r17[0] = Long.valueOf(r32);
        r17[r16] = r30.getSourceUri().toString();
        r17[2] = r14;
        r17[3] = Long.valueOf(getCurrentTime(Long.valueOf(r13.requestStartTime), r12));
        r17[4] = r4.optString(r15);
        ALogService.dSafely(r110, formatString("time %d: onRequestSuccess: {url: %s, requestId: %s, elapsedTime: %d ms, scene_tag: %s}", r17));
    L131:
        if (FrescoSystrace.isTracing() == false) goto L145;
        FrescoSystrace.endSection();
        return;
    L145:
        return;
    L136:
        JSONObject r20 = r4.optJSONObject(IMAGE_MONITOR_DATA);     // Catch: JSONException -> L112
        if (r20 == null) goto L97;
        r20.put("image_status", 0);     // Catch: JSONException -> L112
        if (r20.opt("image_origin") != null) goto L95;
        r20.put("image_origin", 7);     // Catch: JSONException -> L112
    L95:
        r20.put("disk_cache_type", ImageMonitorUtils.mapCacheChoiceToDiskCacheType(r30.getCacheChoice()));     // Catch: JSONException -> L112
        r4.put("image_origin_source", r20.opt("image_origin"));     // Catch: JSONException -> L112
    L97:
        r4.put("applied_image_px_count", calAppliedImagePxCount(r4));     // Catch: JSONException -> L112
        r4.put("intended_image_px_count", calIntendedImagePxCount(r4));     // Catch: JSONException -> L112
        r4.put("view_needed_image_px_count", calViewNeedImagePxCount(r30));     // Catch: JSONException -> L112
        r4.put("view_size", calViewImageSize(r30));     // Catch: JSONException -> L112
        if (r20 == null) goto L114;
        JSONObject r22 = r20.optJSONObject("BitmapMemoryCacheProducer");     // Catch: JSONException -> L112
        long r23 = 0;
        if (r22 == null) goto L104;
        r23 = 0 + ((long) (JSONObjectProtectorUtils.getInt(r22, "producer_end") - JSONObjectProtectorUtils.getInt(r22, "producer_start")));     // Catch: JSONException -> L112
    L104:
        JSONObject r24 = r20.optJSONObject("EncodedMemoryCacheProducer");     // Catch: JSONException -> L112
        if (r24 == null) goto L107;
        r23 = r23 + ((long) (JSONObjectProtectorUtils.getInt(r24, "producer_end") - JSONObjectProtectorUtils.getInt(r24, "producer_start")));     // Catch: JSONException -> L112
    L107:
        JSONObject r25 = r20.optJSONObject("DiskCacheProducer");     // Catch: JSONException -> L112
        if (r25 == null) goto L110;
        r23 = r23 + ((long) (JSONObjectProtectorUtils.getInt(r25, "producer_end") - JSONObjectProtectorUtils.getInt(r25, r4)));     // Catch: JSONException -> L112
    L110:
        r4.put("cache_seek_duration", r23);     // Catch: JSONException -> L112
    L114:
        r13 = r7;
        if (r13.reportExceedLimitEnabled == false) goto L121;
        if (ExceedTheLimitBitmapMonitor.isExceedTheLimitBitmapMonitorEnabled() == false) goto L121;
        ExceedTheLimitBitmapMonitor.checkAndReport(r30, r4.optString("image_type"), r4.optInt("image_count"), r4.optString("biz_tag"), r4.optString(r15), r4.optString("page_tag"), r4.optString("applied_image_size"), r4.optLong("file_size"), r4.optString("image_ram_size"));
    L121:
        if (r13.reportV2Enabled == false) goto L124;
        r16 = 1;
        FrescoMonitor.onImageLoaded(true, r14, r4, r13.traceListenerSampled);
    L112:
        e = move-exception;
        FLog.e(TAG, e, "", new Object[0]);
        goto L114
    L77:
        r11 = 0;
    L80:
        e = e;
    L84:
        FLog.e(TAG, e, "", new Object[0]);
        goto L85
    L61:
        if (r8 == null) goto L65;
        if (TextUtils.isEmpty(r8.toString()) == true) goto L65;
        r4.put("scene_tag", r7.callerContext.toString());     // Catch: JSONException -> L82
    L82:
        e = e;
        r21 = r6;
        goto L84
    L55:
        if (FrescoMonitor.isEnableMonitorLog() == false) goto L57;
        String r26 = formatString("time %d: onRequestSuccess: {url: %s, requestId: %s, elapsedTime: %d ms}", new Object[]{Long.valueOf(r32), r30.getSourceUri().toString(), r14, Long.valueOf(getCurrentTime(Long.valueOf(r7.requestStartTime), r12))});
        r6 = ALOGTAG;
        ALogService.dSafely(r6, r26);
        goto L140
    L47:
        if (r30.getSourceUriType() != 0) goto L49;
        boolean r27 = true;
    L50:
        r19 = r27;
        r5 = false;
        goto L53
    L49:
        r27 = false;
        goto L50
    L41:
        if (FrescoSystrace.isTracing() == false) goto L144;
        FrescoSystrace.endSection();
        return;
    L144:
        return;
    L134:
        r2 = r0.shouldSampleRequestSuccess(r30, r14, r7);     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        FLog.w(TAG, th, "sampling decider error in onRequestSuccessInternal, fallback to sample", new Object[0]);
        goto L31
    L22:
        if (r30.getSourceUri() == null) goto L24;
        r1 = r30.getSourceUri().toString();
        goto L25
    }

    public void onProducerFinishWithSuccess(String r31, String r32, Map<String, String> r33) {
        RequestInfo r8 = this.mRequestInfoMap.get(r31);
        if (r8 != null) goto L6;
        return;
    L6:
        if (r8.reportV2Enabled == false) goto L8;
    L10:
        long r9 = getTime();
        Map r11 = r8.producerStartTimeMap;
        if (r11.isEmpty() == false) goto L13;
        return;
    L13:
        Long r2 = (Long) r11.remove(r31 + r32);
        JSONObject r12 = r8.extra;
        if (r12 != null) goto L16;
        return;
    L16:
        JSONObject r13 = null;
        r13 = r12.optJSONObject(IMAGE_MONITOR_DATA);     // Catch: JSONException -> L28
        if (r13 == null) goto L27;
        JSONObject r14 = r13.optJSONObject(r32);     // Catch: JSONException -> L28
        if (r14 == null) goto L27;
        Long r34 = r2;
        r14.put("producer_start", r2.longValue() - Long.valueOf(r8.requestStartTime).longValue());     // Catch: JSONException -> L25
        r14.put("producer_end", r9 - r8.requestStartTime);     // Catch: JSONException -> L25
    L31:
        if (r33 != null) goto L33;
        return;
    L33:
        JSONObject r17 = r13;
        if (r8.reportV2Enabled == false) goto L207;
        Object r3 = "1";
        if ("NetworkFetchProducer".equals(r32) == false) goto L94;
        String r1 = r33.get("content_length");     // Catch: NumberFormatException -> L87 JSONException -> L90
        String r4 = r33.get("image_size");     // Catch: NumberFormatException -> L87 JSONException -> L90
        if (TextUtils.isEmpty(r1) == true) goto L67;
        long r7 = CastLongProtector.parseLong(r1);     // Catch: NumberFormatException -> L87 JSONException -> L90
    L69:
        if (TextUtils.isEmpty(r4) == true) goto L71;
        long r10 = CastLongProtector.parseLong(r4);     // Catch: NumberFormatException -> L87 JSONException -> L90
    L72:
        r12.put("file_size", r10);     // Catch: NumberFormatException -> L87 JSONException -> L90
        r12.put("content_length", r7);     // Catch: NumberFormatException -> L87 JSONException -> L90
        if (r7 == r10) goto L76;
        r3 = "0";
    L76:
        r12.put("file_consistent", r3);     // Catch: NumberFormatException -> L87 JSONException -> L90
        r12.put("hit_cdn_cache", r33.get("hit_cdn_cache"));     // Catch: NumberFormatException -> L87 JSONException -> L90
        r12.put("x_response_cache", r33.get("x_response_cache"));     // Catch: NumberFormatException -> L87 JSONException -> L90
        r12.put("imagex_demotion", r33.get("imagex_demotion"));     // Catch: NumberFormatException -> L87 JSONException -> L90
        r12.put("imagex_want_fmt", r33.get("imagex_want_fmt"));     // Catch: NumberFormatException -> L87 JSONException -> L90
        r12.put("imagex_true_fmt", r33.get("imagex_true_fmt"));     // Catch: NumberFormatException -> L87 JSONException -> L90
        r12.put("imagex_consistency", r33.get("imagex_consistency"));     // Catch: NumberFormatException -> L87 JSONException -> L90
        r12.put("is_prefetch_image", r33.get("is_prefetch_image"));     // Catch: NumberFormatException -> L87 JSONException -> L90
    L203:
        getHeaders(r12).put("x-response-cache", r33.get("x_response_cache"));     // Catch: NumberFormatException -> L83 JSONException -> L85
        if (TextUtils.isEmpty(r33.get("x-imagex-extra")) == true) goto L81;
        getHeaders(r12).put("x-imagex-extra", r33.get("x-imagex-extra"));     // Catch: NumberFormatException -> L83 JSONException -> L85
    L81:
        r12.put("customParam", r33.get("customParam"));     // Catch: NumberFormatException -> L83 JSONException -> L85
    L172:
        if (SimplayerImageStrategy.isUploadLog() == false) goto L215;
        String r5 = r33.get("strategy_center");
        if (r5 != null) goto L176;
        return;
    L176:
        if (r5.isEmpty() == true) goto L217;
        r12.put("strategy_center", r5);     // Catch: JSONException -> L179
    L182:
        if (SimplayerImageStrategy.isOpenLog() == true) goto L184;
        return;
    L184:
        return;
    L179:
        e = move-exception;
        e.printStackTrace();
        goto L182
    L217:
        return;
    L215:
        return;
    L83:
        e = e;
    L89:
        e.printStackTrace();
    L85:
        e = e;
    L92:
        e.printStackTrace();
        goto L172
    L71:
        r10 = -1;
        goto L72
    L67:
        r7 = -1;
    L87:
        e = e;
    L90:
        e = e;
        goto L92
    L94:
        if ("BlurhashProducer".equals(r32) == false) goto L100;
        r12.put("blurhash_decode_duration", r33.get("blurhash_decode_duration"));     // Catch: JSONException -> L97
        r12.put("blurhash_duration", r9 - r8.requestStartTime);     // Catch: JSONException -> L97
    L97:
        e = move-exception;
        e.printStackTrace();
        goto L172
    L100:
        if ("DiskCacheWriteProducer".equals(r32) == false) goto L111;
        r12.put("image_type", (String) r33.get("imageType"));     // Catch: JSONException -> L108
        Object r6 = (String) r33.get("encodedImageSize");     // Catch: JSONException -> L108
        if ("-1x-1".equals(r6) == false) goto L104;
    L105:
        r6 = (String) r33.get("bitmapSize");     // Catch: JSONException -> L108
    L106:
        r12.put("applied_image_size", r6);     // Catch: JSONException -> L108
        goto L172
    L104:
        if ("unknown".equals(r6) == false) goto L106;
    L108:
        e = move-exception;
        e.printStackTrace();
        goto L172
    L111:
        if ("DecodeProducer".equals(r32) == false) goto L153;
        Object r15 = (String) r33.get("requestedImageSize");     // Catch: NumberFormatException -> L148 JSONException -> L150
        if ("unknown".equals(r15) == false) goto L115;
        r15 = "0x0";
    L115:
        r12.put("intended_image_size", r15);     // Catch: NumberFormatException -> L148 JSONException -> L150
        Object r16 = (String) r33.get("encodedImageSize");     // Catch: NumberFormatException -> L148 JSONException -> L150
        if ("-1x-1".equals(r16) == false) goto L118;
    L119:
        r16 = (String) r33.get("bitmapSize");     // Catch: NumberFormatException -> L148 JSONException -> L150
    L120:
        r12.put("isCrop", r33.get("isCrop"));     // Catch: NumberFormatException -> L148 JSONException -> L150
        r12.put("regionToDecode", r33.get("regionToDecode"));     // Catch: NumberFormatException -> L148 JSONException -> L150
        r12.put("sampleSize", r33.get("sampleSize"));     // Catch: NumberFormatException -> L148 JSONException -> L150
        r12.put("applied_image_size", r16);     // Catch: NumberFormatException -> L148 JSONException -> L150
        r12.put("decode_duration", r9 - r34.longValue());     // Catch: NumberFormatException -> L148 JSONException -> L150
        r12.put("image_type", r33.get("imageFormat"));     // Catch: NumberFormatException -> L148 JSONException -> L150
        r12.put("image_ram_size", r33.get("bitmapRamSize"));     // Catch: NumberFormatException -> L148 JSONException -> L150
        r12.put("image_count", CastIntegerProtector.parseInt(r33.get("imageCount")));     // Catch: NumberFormatException -> L148 JSONException -> L150
        Object r18 = (String) r33.get("hdr_type");     // Catch: NumberFormatException -> L148 JSONException -> L150
        if ("-1".equals(r18) == true) goto L123;
        r12.put("hdr_type", r18);     // Catch: NumberFormatException -> L148 JSONException -> L150
        r12.put("use_ttheif_rgba102", FrescoCacheMonitorUtil.isUseHeicHdrRgba102());     // Catch: NumberFormatException -> L148 JSONException -> L150
    L123:
        r12.put("extra_bitmap_config", r33.get("extra_bitmap_config"));     // Catch: NumberFormatException -> L148 JSONException -> L150
        if (r17 == null) goto L126;
        r17.put("decode_queue_duration", CastLongProtector.parseLong(r33.get("queueTime")));     // Catch: NumberFormatException -> L148 JSONException -> L150
    L126:
        r12.put("image_quality", r33.get("imageQuality"));     // Catch: NumberFormatException -> L148 JSONException -> L150
        r12.put("heic_sys_first", r33.get("heic_sys_first"));     // Catch: NumberFormatException -> L148 JSONException -> L150
        r12.put("size_abnormal", r33.get("size_abnormal"));     // Catch: NumberFormatException -> L148 JSONException -> L150
        r12.put("heic_custom_decoder", r33.get("heic_custom_decoder"));     // Catch: NumberFormatException -> L148 JSONException -> L150
        String r19 = r33.get("heic_decode_error");     // Catch: Exception -> L131
        if (r19 == null) goto L135;
        r12.put("err_code", CastIntegerProtector.parseInt(r19));     // Catch: Exception -> L131
    L135:
        if (r33.get("thumb_decode_duration") == null) goto L138;
        r12.put("thumb_file_size", r33.get("thumb_file_size"));     // Catch: NumberFormatException -> L148 JSONException -> L150
        r12.put("thumb_decode_duration", r33.get("thumb_decode_duration"));     // Catch: NumberFormatException -> L148 JSONException -> L150
        r12.put("thumb_download_duration", System.currentTimeMillis() - r8.requestStartTime);     // Catch: NumberFormatException -> L148 JSONException -> L150
    L138:
        if (r33.get("preview_used") == null) goto L143;
        if ("1".equals(r33.get("preview_used")) == false) goto L143;
        r12.put("preview_used", r33.get("preview_used"));     // Catch: NumberFormatException -> L148 JSONException -> L150
        r12.put("preview_algo", r33.get("preview_algo"));     // Catch: NumberFormatException -> L148 JSONException -> L150
        r12.put("preview_duration", r33.get("preview_duration"));     // Catch: NumberFormatException -> L148 JSONException -> L150
        r12.put("preview_error", r33.get("preview_error"));     // Catch: NumberFormatException -> L148 JSONException -> L150
        r12.put("preview_hash_decode_duration", r33.get("preview_hash_decode_duration"));     // Catch: NumberFormatException -> L148 JSONException -> L150
    L143:
        if ("1".equalsIgnoreCase(r33.get("sr_heic_opt")) == false) goto L172;
        String r20 = r33.get("sr_duration");     // Catch: NumberFormatException -> L148 JSONException -> L150
        r12.put("sr_heic_opt", r33.get("sr_heic_opt"));     // Catch: NumberFormatException -> L148 JSONException -> L150
        r12.put("sr_type", r33.get("sr_type"));     // Catch: NumberFormatException -> L148 JSONException -> L150
        r12.put("sr_status", r33.get("sr_status"));     // Catch: NumberFormatException -> L148 JSONException -> L150
        r12.put("sr_duration", r20);     // Catch: NumberFormatException -> L148 JSONException -> L150
        r12.put("sr_width", r33.get("sr_width"));     // Catch: NumberFormatException -> L148 JSONException -> L150
        r12.put("sr_height", r33.get("sr_height"));     // Catch: NumberFormatException -> L148 JSONException -> L150
        r12.put("sr_stretch", r33.get("sr_stretch"));     // Catch: NumberFormatException -> L148 JSONException -> L150
        r12.put("scale_type", r33.get("scale_type"));     // Catch: NumberFormatException -> L148 JSONException -> L150
        r12.put("enable_all", r33.get("enable_all"));     // Catch: NumberFormatException -> L148 JSONException -> L150
        r12.put("sr_max_width", r33.get("sr_max_width"));     // Catch: NumberFormatException -> L148 JSONException -> L150
        r12.put("sr_max_height", r33.get("sr_max_height"));     // Catch: NumberFormatException -> L148 JSONException -> L150
        r12.put("sr_err", r33.get("sr_err"));     // Catch: NumberFormatException -> L148 JSONException -> L150
        if (TextUtils.isEmpty(r20) == true) goto L172;
        r12.put("decode_duration", (r9 - r34.longValue()) - ((long) CastIntegerProtector.parseInt(r20)));     // Catch: NumberFormatException -> L148 JSONException -> L150
    L131:
        e = move-exception;
        e.printStackTrace();     // Catch: NumberFormatException -> L148 JSONException -> L150
        goto L135
    L118:
        if ("unknown".equals(r16) == false) goto L120;
    L148:
        e = move-exception;
        e.printStackTrace();
    L150:
        e = move-exception;
        e.printStackTrace();
        goto L172
    L153:
        if ("BackgroundThreadHandoffProducer".equals(r32) == false) goto L160;
        if (r17 == null) goto L172;
        r17.put("pause_time", r33.get("pendingTime"));     // Catch: JSONException -> L157
    L157:
        e = move-exception;
        e.printStackTrace();
        goto L172
    L160:
        if ("PostprocessorProducer".equals(r32) == false) goto L172;
    L165:
        e = move-exception;
        e.printStackTrace();
    L191:
        r12.put("sharp_type", r33.get("sharp_type"));     // Catch: JSONException -> L169
        r12.put("sharp_status", r33.get("sharp_status"));     // Catch: JSONException -> L169
        r12.put("sharp_duration", r33.get("sharp_duration"));     // Catch: JSONException -> L169
        r12.put("sharp_error", r33.get("sharp_error"));     // Catch: JSONException -> L169
        r12.put("sharp_wt", r33.get("sharp_wt"));     // Catch: JSONException -> L169
        r12.put("sharp_thr", r33.get("sharp_thr"));     // Catch: JSONException -> L169
        r12.put("sharp_ovrt", r33.get("sharp_ovrt"));     // Catch: JSONException -> L169
        r12.put("sharp_adaptive", r33.get("sharp_adaptive"));     // Catch: JSONException -> L169
        r12.put("sharp_g0", r33.get("sharp_g0"));     // Catch: JSONException -> L169
        r12.put("sharp_lc_wt_thr", r33.get("sharp_lc_wt_thr"));     // Catch: JSONException -> L169
    L169:
        e = move-exception;
        e.printStackTrace();
        goto L172
    L162:
        if ("1".equalsIgnoreCase(r33.get("sr_heic_opt")) == true) goto L191;
        r12.put("sr_heic_opt", r33.get("sr_heic_opt"));     // Catch: JSONException -> L165
        r12.put("sr_type", r33.get("sr_type"));     // Catch: JSONException -> L165
        r12.put("sr_status", r33.get("sr_status"));     // Catch: JSONException -> L165
        r12.put("sr_duration", r33.get("sr_duration"));     // Catch: JSONException -> L165
        r12.put("sr_width", r33.get("sr_width"));     // Catch: JSONException -> L165
        r12.put("sr_height", r33.get("sr_height"));     // Catch: JSONException -> L165
        r12.put("sr_stretch", r33.get("sr_stretch"));     // Catch: JSONException -> L165
        r12.put("scale_type", r33.get("scale_type"));     // Catch: JSONException -> L165
        r12.put("enable_all", r33.get("enable_all"));     // Catch: JSONException -> L165
        r12.put("sr_max_width", r33.get("sr_max_width"));     // Catch: JSONException -> L165
        r12.put("sr_max_height", r33.get("sr_max_height"));     // Catch: JSONException -> L165
        r12.put("sr_err", r33.get("sr_err"));     // Catch: JSONException -> L165
        goto L191
    L207:
    L57:
        e = move-exception;
        e.printStackTrace();
        return;
    L36:
        if ("NetworkFetchProducer".equals(r32) == false) goto L41;
        String r21 = r33.get("image_size");     // Catch: Throwable -> L57 JSONException -> L59
        if (TextUtils.isEmpty(r21) == true) goto L210;
        r12.put("file_size", CastLongProtector.parseLong(r21));     // Catch: Throwable -> L57 JSONException -> L59
        return;
    L210:
        return;
    L41:
        if ("DiskCacheWriteProducer".equals(r32) == false) goto L49;
        r12.put("image_type", r33.get("imageType"));     // Catch: Throwable -> L57 JSONException -> L59
        Object r22 = (String) r33.get("encodedImageSize");     // Catch: Throwable -> L57 JSONException -> L59
        if ("-1x-1".equals(r22) == false) goto L45;
    L46:
        r22 = (String) r33.get("bitmapSize");     // Catch: Throwable -> L57 JSONException -> L59
    L47:
        r12.put("applied_image_size", r22);     // Catch: Throwable -> L57 JSONException -> L59
        return;
    L45:
        if ("unknown".equals(r22) == false) goto L47;
    L49:
        if ("DecodeProducer".equals(r32) == false) goto L213;
        Object r23 = (String) r33.get("encodedImageSize");     // Catch: Throwable -> L57 JSONException -> L59
        if ("-1x-1".equals(r23) == false) goto L53;
    L54:
        r23 = (String) r33.get("bitmapSize");     // Catch: Throwable -> L57 JSONException -> L59
    L55:
        r12.put("applied_image_size", r23);     // Catch: Throwable -> L57 JSONException -> L59
        r12.put("image_type", r33.get("imageFormat"));     // Catch: Throwable -> L57 JSONException -> L59
        r12.put("image_ram_size", r33.get("bitmapRamSize"));     // Catch: Throwable -> L57 JSONException -> L59
        r12.put("image_count", CastIntegerProtector.parseInt(r33.get("imageCount")));     // Catch: Throwable -> L57 JSONException -> L59
        return;
    L53:
        if ("unknown".equals(r23) == false) goto L55;
    L213:
        return;
    L25:
        e = e;
    L30:
        e.printStackTrace();
    L27:
        r34 = r2;
    L28:
        e = e;
        r34 = r2;
        goto L30
    L8:
        if (r8.reportExceedLimitEnabled == true) goto L10;
    }

    public void onRequestIntermediateResult(ImageRequest r10, String r11, boolean r12) {
        long r5 = getTime();
        sExecutor.submit(new 6(this, r10, r11, r12, r5));
    }

    public void onRequestSuccess(ImageRequest r8, String r9, boolean r10) {
        long r4 = getTime();
        sExecutor.submit(new 3(this, r8, r9, r4));
    }

    public void onUltimateProducerReached(String r1, String r2, boolean r3) {
        RequestInfo r4 = this.mRequestInfoMap.get(r1);
        if (r4 != null) goto L6;
        return;
    L6:
        if (r4.reportV2Enabled == true) goto L8;
        return;
    L8:
        JSONObject r5 = r4.extra;
        if (r5 != null) goto L18;
        return;
    L18:
        JSONObject r6 = r5.optJSONObject(IMAGE_MONITOR_DATA);     // Catch: JSONException -> L15
        if (r6 == null) goto L20;
        r6.put("image_origin", ImageMonitorUtils.mapProducerNameToImageMonitorOrigin(r2));     // Catch: JSONException -> L15
        return;
    L20:
        return;
    L15:
        e = move-exception;
        e.printStackTrace();
    }

    public static /* synthetic */ void access$200(FrescoTraceListener r0, ImageRequest r1, String r2, long r3) {
        r0.onRequestSuccessInternal(r1, r2, r3);
    }

    private void onRequestFailureInternal(ImageRequest r27, String r28, long r29, Throwable r31) {
        if (FrescoSystrace.isTracing() == false) goto L5;
        FrescoSystrace.beginSection("FrescoMonitor#onRequestFailure");
    L5:
        RequestInfo r15 = this.mRequestInfoMap.remove(r28);
        if (r15 != null) goto L9;
        return;
    L9:
        if (r15.reportV2Enabled == false) goto L11;
        JSONObject r8 = r15.extra;
        if (FrescoMonitor.isEnableMonitorLog() == false) goto L22;
        if (r31 == null) goto L18;
        String r0 = r31.toString();
    L19:
        String r19 = "";
        String r1 = formatString("time %d: onRequestFailure: {url: %s, requestId: %s, elapsedTime: %d ms, throwable: %s}", new Object[]{Long.valueOf(r29), r27.getSourceUri().toString(), r28, Long.valueOf(getCurrentTime(Long.valueOf(r15.requestStartTime), r29)), r0});
        if (isCanceledInfo(r0) == true) goto L24;
        ALogService.eSafely(ALOGTAG, r1, r31);
    L24:
        if (FrescoMonitor.isReportHitCacheEnabled() == true) goto L26;
        boolean r2 = r8.optBoolean("is_request_network", false);
    L30:
        boolean r21 = r2;
        if (r31 != null) goto L33;
        int r5 = 200;
    L91:
        Object r3 = r15.callerContext;     // Catch: JSONException -> L54
        if ((r3 instanceof String) == false) goto L37;
        r8.put("scene_tag", r3);     // Catch: JSONException -> L54
    L41:
        r8.put("load_status", "fail");     // Catch: JSONException -> L54
        r8.put("duration", getCurrentTime(Long.valueOf(r15.requestStartTime), r29));     // Catch: JSONException -> L54
        r8.put("err_code", r5);     // Catch: JSONException -> L54
        String r4 = getErrMsg(r31);     // Catch: JSONException -> L54
        if (TextUtils.isEmpty(r4) == false) goto L44;
        r4 = Log.getStackTraceString(r31);     // Catch: JSONException -> L54
    L44:
        r8.put("err_desc", r4);     // Catch: JSONException -> L54
        r8.put("timestamp", Long.valueOf(r15.requestStartTime));     // Catch: JSONException -> L54
        r8.put("log_type", "image_monitor_v2");     // Catch: JSONException -> L54
        r8.put("log_version", 1);     // Catch: JSONException -> L52
        r8.put("uri", r27.getSourceUri().toString());     // Catch: JSONException -> L52
        r8.put("image_sdk_version", "1.41.6");     // Catch: JSONException -> L52
        if (RetryInterceptManager.inst().isOpen() == false) goto L49;
        int r6 = 1;
    L50:
        r8.put("retry_open", r6);     // Catch: JSONException -> L52
        r8.put("source_uri_type", r27.getSourceUriType());     // Catch: JSONException -> L52
        r8.put("network_quality", TTNetInit.getEffectiveConnectionType());     // Catch: JSONException -> L52
        String r7 = r19;
    L57:
        String r23 = r7;
        int r9 = r5;
        hookMonitor(r27, r28, r15.callerContext, r8, false, r21, false);
        uriQueryParamToExtra(r8);
        if (r21 == false) goto L76;
        int r10 = ImageMonitorUtils.getImageMonitorDataStatus(r31);
        JSONObject r11 = r8.optJSONObject(IMAGE_MONITOR_DATA);     // Catch: JSONException -> L72
        if (r11 == null) goto L71;
        r11.put("image_status", r10);     // Catch: JSONException -> L72
        char r12 = 1;
        if (r9 == 1) goto L66;
        boolean r13 = true;
    L93:
        r11.put("image_load_error_code", ImageMonitorUtils.getImageLoadErrorCode(r31, r13));     // Catch: JSONException -> L69
        r11.put("disk_cache_type", ImageMonitorUtils.mapCacheChoiceToDiskCacheType(r27.getCacheChoice()));     // Catch: JSONException -> L69
    L75:
        char r14 = 0;
        FrescoMonitor.onImageLoaded(false, r28, r8, r15.traceListenerSampled);
    L78:
        if (FrescoMonitor.isEnableMonitorLog() == false) goto L86;
        if (r31 == null) goto L81;
        String r16 = r31.toString();
    L82:
        Object[] r17 = new Object[6];
        r17[r14] = Long.valueOf(r29);
        r17[r12] = r27.getSourceUri().toString();
        r17[2] = r28;
        r17[3] = Long.valueOf(getCurrentTime(Long.valueOf(r15.requestStartTime), r29));
        r17[4] = r16;
        r17[5] = r8.optString("scene_tag");
        String r18 = formatString("time %d: onRequestFailure: {url: %s, requestId: %s, elapsedTime: %d ms, throwable: %s, scene_tag: %s}", r17);
        if (isCanceledInfo(r16) == true) goto L86;
        ALogService.eSafely(ALOGTAG, r18, r31);
        goto L86
    L81:
        r16 = r23;
    L86:
        if (FrescoSystrace.isTracing() == false) goto L98;
        FrescoSystrace.endSection();
        return;
    L98:
        return;
    L69:
        e = e;
    L74:
        e.printStackTrace();
        goto L75
    L66:
        r13 = false;
        goto L93
    L71:
        r12 = 1;
    L72:
        e = e;
        r12 = 1;
        goto L74
    L76:
        r14 = 0;
        r12 = 1;
        goto L78
    L49:
        r6 = 0;
    L52:
        e = e;
    L56:
        r7 = r19;
        FLog.e(TAG, e, r7, new Object[0]);
        goto L57
    L37:
        if (r3 == null) goto L41;
        if (TextUtils.isEmpty(r3.toString()) == true) goto L41;
        r8.put("scene_tag", r15.callerContext.toString());     // Catch: JSONException -> L54
    L54:
        e = e;
        goto L56
    L33:
        r5 = NetUtils.checkHttpRequestException(r31, null);
        goto L91
    L26:
        if (r27.getSourceUriType() != 0) goto L28;
        r2 = true;
        goto L30
    L28:
        r2 = false;
        goto L30
    L18:
        r0 = "";
        goto L19
    L22:
        r19 = "";
        goto L24
    L11:
        if (FrescoSystrace.isTracing() == false) goto L97;
        FrescoSystrace.endSection();
        return;
    }

    private void onRequestIntermediateResultInternal(ImageRequest r3, String r4, boolean r5, long r6) {
        RequestInfo r7 = this.mRequestInfoMap.get(r4);
        if (r7 != null) goto L6;
        return;
    L6:
        if (r7.reportV2Enabled == true) goto L9;
        return;
    L9:
        if (r7.isFirstIntermediateResult == false) goto L18;
        r7.isFirstIntermediateResult = false;
        JSONObject r8 = r7.extra;
        if (r8 != null) goto L16;
        return;
    L16:
        r8.put("first_intermediate_result", getCurrentTime(Long.valueOf(r7.requestStartTime), r6));     // Catch: JSONException -> L15
        return;
    L19:
        return;
    }

    public void onProducerFinishWithFailure(String r19, String r20, Throwable r21, Map<String, String> r22) {
        long r8 = getTime();
        RequestInfo r10 = this.mRequestInfoMap.get(r19);
        if (r10 != null) goto L6;
        return;
    L6:
        if (r10.reportV2Enabled == true) goto L8;
        return;
    L8:
        JSONObject r11 = r10.extra;
        if (r11 != null) goto L12;
        return;
    L12:
        if (r22 != null) goto L14;
        HashMap r15 = new HashMap();
        r15.put("image_size", "-1");
        r15.put("queue_time", "-1");
        r15.put("fetch_time", "-1");
        Map r16 = r15;
    L15:
        JSONObject r4 = r11.optJSONObject(IMAGE_MONITOR_DATA);
        if ("NetworkFetchProducer".equals(r20) == false) goto L35;
        r11.put("fail_phase", "download");     // Catch: NumberFormatException -> L30 JSONException -> L32
        r11.put("download_duration", -1);     // Catch: NumberFormatException -> L30 JSONException -> L32
        String r0 = (String) r16.get("content_length");     // Catch: NumberFormatException -> L30 JSONException -> L32
        String r1 = (String) r16.get("image_size");     // Catch: NumberFormatException -> L30 JSONException -> L32
        String r5 = (String) r16.get("queue_time");     // Catch: NumberFormatException -> L30 JSONException -> L32
        long r9 = -1;
        if (TextUtils.isEmpty(r0) == true) goto L20;
        long r12 = CastLongProtector.parseLong(r0);     // Catch: NumberFormatException -> L30 JSONException -> L32
    L22:
        if (TextUtils.isEmpty(r1) == true) goto L24;
        long r2 = CastLongProtector.parseLong(r1);     // Catch: NumberFormatException -> L30 JSONException -> L32
    L26:
        if (TextUtils.isEmpty(r5) == true) goto L28;
        r9 = CastLongProtector.parseLong(r5);     // Catch: NumberFormatException -> L30 JSONException -> L32
    L28:
        r11.put("file_size", r2);     // Catch: NumberFormatException -> L30 JSONException -> L32
        r11.put("content_length", r12);     // Catch: NumberFormatException -> L30 JSONException -> L32
        r11.put("queue_duration", r9);     // Catch: NumberFormatException -> L30 JSONException -> L32
    L45:
        StringBuilder r3 = new StringBuilder(r19);
        Map r6 = r10.producerStartTimeMap;
        if (r6.isEmpty() == false) goto L48;
        return;
    L48:
        r3.append(r20);
        Long r7 = (Long) r6.remove(r3.toString());
        if (FrescoMonitor.isEnableMonitorLog() == false) goto L55;
        String r13 = r21.toString();
        long r14 = r8;
        String r17 = formatString("time %d: onProducerFinishWithFailure: {requestId: %s, stage: %s, elapsedTime: %d ms, extraMap: %s, throwable: %s}", new Object[]{Long.valueOf(r8), r19, r20, Long.valueOf(getCurrentTime(r7, r14)), r16, r13});
        if (isCanceledInfo(r13) == false) goto L53;
        ALogService.eSafely(ALOGTAG, r17);
        Throwable r18 = r21;
    L54:
        FLog.e(ALOGTAG, r17, r18);
    L56:
        if (r4 == null) goto L70;
        JSONObject r23 = r4.optJSONObject(r20);     // Catch: JSONException -> L61
        if (r23 == null) goto L71;
        r23.put("producer_start", r7.longValue() - Long.valueOf(r10.requestStartTime).longValue());     // Catch: JSONException -> L61
        r23.put("producer_end", r14 - r10.requestStartTime);     // Catch: JSONException -> L61
        return;
    L71:
        return;
    L61:
        e = move-exception;
        e.printStackTrace();
        return;
    L70:
        return;
    L53:
        r18 = r21;
        ALogService.eSafely(ALOGTAG, r17, r18);
        goto L54
    L55:
        r14 = r8;
        goto L56
    L24:
        r2 = -1;
        goto L26
    L20:
        r12 = -1;
    L30:
        e = move-exception;
        e.printStackTrace();
    L32:
        e = move-exception;
        e.printStackTrace();
        goto L45
    L35:
        if ("DecodeProducer".equals(r20) == false) goto L45;
        r11.put("fail_phase", "decode");     // Catch: NumberFormatException -> L41 JSONException -> L43
        r11.put("download_duration", r16.get("fetch_time"));     // Catch: NumberFormatException -> L41 JSONException -> L43
        if (r4 == null) goto L39;
        r4.put("decode_queue_duration", CastLongProtector.parseLong((String) r16.get("queueTime")));     // Catch: NumberFormatException -> L41 JSONException -> L43
    L39:
        r11.put("heic_sys_first", r16.get("heic_sys_first"));     // Catch: NumberFormatException -> L41 JSONException -> L43
        r11.put("size_abnormal", r16.get("size_abnormal"));     // Catch: NumberFormatException -> L41 JSONException -> L43
        r11.put("heic_custom_decoder", r16.get("heic_custom_decoder"));     // Catch: NumberFormatException -> L41 JSONException -> L43
    L41:
        e = move-exception;
        e.printStackTrace();
    L43:
        e = move-exception;
        e.printStackTrace();
        goto L45
    L14:
        r16 = r22;
        goto L15
    }

    public void onRequestFailure(ImageRequest r9, String r10, Throwable r11, boolean r12) {
        long r4 = getTime();
        sExecutor.submit(new 4(this, r9, r10, r4, r11));
    }

    public void onRequestStart(ImageRequest r3, Object r4, String r5, boolean r6) {
        long r0 = getTime();
        if (FrescoSystrace.isTracing() == false) goto L5;
        FrescoSystrace.beginSection("FrescoMonitor#onRequestStart");
    L5:
        RequestInfo r7 = new RequestInfo(this);
        r7.requestId = r5;
        r7.requestStartTime = r0;
        r7.callerContext = r4;
        if (FrescoCacheMonitorUtil.isOptMonitorSample() == false) goto L15;
        boolean r1 = FrescoMonitor.getLogTypeSwitch("image_monitor_v2");
        r7.reportExceedLimitEnabled = FrescoMonitor.getLogTypeSwitch("image_monitor_exceed_limit_v2");
        boolean[] r8 = FrescoMonitor.sampleImageTraceListeners(r3, r4, r5, r1);
        r7.traceListenerSampled = r8;
        if (r1 == true) goto L12;
        if (r8 != null) goto L12;
        boolean r9 = false;
    L13:
        r7.reportV2Enabled = r9;
    L12:
        r9 = true;
    L15:
        if (TextUtils.isEmpty(r5) == true) goto L33;
        JSONObject r10 = new JSONObject();
        if (r7.reportV2Enabled == false) goto L24;
        if (FrescoMonitor.isReportImageMonitorDataEnabled() == false) goto L24;
        r10.put(IMAGE_MONITOR_DATA, new JSONObject());     // Catch: JSONException -> L22
    L24:
        if (r7.reportV2Enabled == false) goto L26;
    L27:
        String r11 = FrescoMonitor.getCurrentScene();
        String r2 = FrescoMonitor.getCurrentActivity();
        if (r11 != null) goto L40;
    L30:
        if (r2 == null) goto L32;
        r10.put("page_tag", r2);     // Catch: JSONException -> L37
    L32:
        r7.extra = r10;
        goto L33
    L40:
        r10.put("scene_tag", r11);     // Catch: JSONException -> L37
        goto L30
    L26:
        if (r7.reportExceedLimitEnabled == false) goto L32;
    L33:
        this.mRequestInfoMap.put(r5, r7);
        if (FrescoSystrace.isTracing() == false) goto L42;
        FrescoSystrace.endSection();
        return;
    }

    public static /* synthetic */ void access$300(FrescoTraceListener r0, ImageRequest r1, String r2, long r3, Throwable r5) {
        r0.onRequestFailureInternal(r1, r2, r3, r5);
    }

    public static /* synthetic */ void access$500(FrescoTraceListener r0, ImageRequest r1, String r2, boolean r3, long r4) {
        r0.onRequestIntermediateResultInternal(r1, r2, r3, r4);
    }

    private boolean hookMonitor(ImageRequest r14, String r15, Object r16, JSONObject r17, boolean r18, boolean r19, boolean r20) {
        JSONObject r9 = shallowCopy(r17);
        IMonitorHook r2 = FrescoMonitor.getMonitorHook();
        if (r2 != null) goto L64;
    L17:
        boolean r3 = r19;
    L19:
        if (FrescoCacheMonitorUtil.isOptListenerAnr() == false) goto L35;
        Iterator<IMonitorHookV2> r10 = FrescoMonitor.sNewMonitorHookV2s.iterator();
        boolean r11 = r3;
    L22:
        if (r10.hasNext() == false) goto L85;
        Pair<Boolean, Map<String, Object>> r4 = r10.next().onMonitorCompleted(r14, r16, r15, r9, r18, r20);
        if (r4 == null) goto L22;
        if (r11 == true) goto L27;
        r11 = ((Boolean) r4.first).booleanValue();
    L27:
        Map r5 = (Map) r4.second;
        if (r5 == null) goto L22;
        Iterator r6 = r5.keySet().iterator();     // Catch: JSONException -> L34
    L31:
        if (r6.hasNext() == false) goto L22;
        String r7 = (String) r6.next();     // Catch: JSONException -> L34
        r17.put(r7, r5.get(r7));     // Catch: JSONException -> L34
    L85:
        return r11;
    L35:
        List<IMonitorHookV2> r12 = FrescoMonitor.sMonitorHookV2s;
        monitor-enter(r12);
        Iterator<IMonitorHookV2> r13 = r12.iterator();     // Catch: Throwable -> L54
        boolean r110 = r3;
    L39:
        if (r13.hasNext() == false) goto L51;
        Pair<Boolean, Map<String, Object>> r8 = r13.next().onMonitorCompleted(r14, r16, r15, r9, r18, r20);     // Catch: Throwable -> L54
        if (r8 == null) goto L39;
        if (r110 == true) goto L44;
        r110 = ((Boolean) r8.first).booleanValue();     // Catch: Throwable -> L54
    L44:
        Map r21 = (Map) r8.second;     // Catch: Throwable -> L54
        if (r21 == null) goto L39;
        Iterator r22 = r21.keySet().iterator();     // Catch: JSONException -> L57 Throwable -> L54
    L48:
        if (r22.hasNext() == false) goto L39;
        String r23 = (String) r22.next();     // Catch: JSONException -> L57 Throwable -> L54
        r17.put(r23, r21.get(r23));     // Catch: JSONException -> L57 Throwable -> L54
    L51:
        monitor-exit(r12);     // Catch: Throwable -> L54
        return r110;
    L54:
        th = move-exception;
        throw th;
    L64:
        Pair r24 = r2.onMonitorCompleted(r14, r16, r15, r9, r18);     // Catch: Exception -> L7
    L8:
        if (r24 == null) goto L17;
        r3 = ((Boolean) r24.first).booleanValue();
        Map r25 = (Map) r24.second;
        if (r25 == null) goto L19;
        Iterator r26 = r25.keySet().iterator();     // Catch: JSONException -> L16
    L13:
        if (r26.hasNext() == false) goto L19;
        String r27 = (String) r26.next();     // Catch: JSONException -> L16
        r17.put(r27, r25.get(r27));     // Catch: JSONException -> L16
    L7:
        r24 = null;
        goto L8
    }
}
