package com.bytedance.retrofit2;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class RetrofitLayerMetrics {
    public static int BIZ_SPAN_MASK = 2;
    public static int EVENT_TIMESTAMP_MASK = 1;
    public static int IMPORTANT_INNER_SPAN_MASK = 4;
    public static int INTERCEPTOR_MASK = 8;
    public static int MISC_MASK = 16;
    private static volatile int reportDetail = -1;
    public BizSpan bizSpan;
    public EventTimestamp eventTs;
    public ImportantInnerSpan innerSpan;
    InterceptorRecorder interceptorRecorder;
    public Misc misc;

    public static class BizSpan {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        public long addCommonParam;
        private long bizCallbackStart;
        public long bizRequestInterceptor;
        public long bizResponseInterceptor;
        public long checkReqTicket;
        public long commandListener;
        public long encryptRequest;
        public long enqueueCallback;
        public long filterUrl;
        public long monitorApiHttpAfterFilter;
        public long monitorApiHttpBeforeFilter;
        public long postCdnCacheVerify;
        public long requestVerify;
        public long waitSsHttpCallApiExecute;

        static {
        }

        public BizSpan() {
            this.bizCallbackStart = -1;
            this.waitSsHttpCallApiExecute = -1;
            this.monitorApiHttpBeforeFilter = -1;
            this.filterUrl = -1;
            this.monitorApiHttpAfterFilter = -1;
            this.addCommonParam = -1;
            this.encryptRequest = -1;
            this.requestVerify = -1;
            this.commandListener = -1;
            this.checkReqTicket = -1;
            this.postCdnCacheVerify = -1;
            this.bizRequestInterceptor = -1;
            this.bizResponseInterceptor = -1;
            this.enqueueCallback = -1;
        }

        public long computeDurationNs() {
            long r0 = System.nanoTime() - this.bizCallbackStart;
            this.bizCallbackStart = -1;
            return r0;
        }

        public BizSpan deepCopy() {
            BizSpan r0 = new BizSpan();
            r0.bizCallbackStart = this.bizCallbackStart;
            r0.waitSsHttpCallApiExecute = this.waitSsHttpCallApiExecute;
            r0.monitorApiHttpBeforeFilter = this.monitorApiHttpBeforeFilter;
            r0.filterUrl = this.filterUrl;
            r0.monitorApiHttpAfterFilter = this.monitorApiHttpAfterFilter;
            r0.addCommonParam = this.addCommonParam;
            r0.encryptRequest = this.encryptRequest;
            r0.requestVerify = this.requestVerify;
            r0.commandListener = this.commandListener;
            r0.checkReqTicket = this.checkReqTicket;
            r0.postCdnCacheVerify = this.postCdnCacheVerify;
            r0.bizRequestInterceptor = this.bizRequestInterceptor;
            r0.bizResponseInterceptor = this.bizResponseInterceptor;
            r0.enqueueCallback = this.enqueueCallback;
            return r0;
        }

        public void recordCallbackStart() {
            this.bizCallbackStart = System.nanoTime();
        }

        public JSONObject toJson() {
            if ((RetrofitLayerMetrics.access$000() & RetrofitLayerMetrics.BIZ_SPAN_MASK) != 0) goto L6;
            return null;
        L6:
            JSONObject r0 = new JSONObject();
            r0.put("wait_hcall_exe", String.valueOf(TTMetricsUtil.nanoSecondsToMicroSeconds(this.waitSsHttpCallApiExecute)));
            r0.put("mon_http_bfr_flt", String.valueOf(TTMetricsUtil.nanoSecondsToMicroSeconds(this.monitorApiHttpBeforeFilter)));
            r0.put("flt_url", String.valueOf(TTMetricsUtil.nanoSecondsToMicroSeconds(this.filterUrl)));
            r0.put("mon_http_aft_flt", String.valueOf(TTMetricsUtil.nanoSecondsToMicroSeconds(this.monitorApiHttpAfterFilter)));
            r0.put("add_com_prm", String.valueOf(TTMetricsUtil.nanoSecondsToMicroSeconds(this.addCommonParam)));
            r0.put("encrypt_req", String.valueOf(TTMetricsUtil.nanoSecondsToMicroSeconds(this.encryptRequest)));
            r0.put("req_vfy", String.valueOf(TTMetricsUtil.nanoSecondsToMicroSeconds(this.requestVerify)));
            r0.put("cmd_lst", String.valueOf(TTMetricsUtil.nanoSecondsToMicroSeconds(this.commandListener)));
            r0.put("chk_req_tkt", String.valueOf(TTMetricsUtil.nanoSecondsToMicroSeconds(this.checkReqTicket)));
            r0.put("post_cdn_cache_vfy", String.valueOf(TTMetricsUtil.nanoSecondsToMicroSeconds(this.postCdnCacheVerify)));
            r0.put("biz_req_itcpt", String.valueOf(TTMetricsUtil.nanoSecondsToMicroSeconds(this.bizRequestInterceptor)));
            r0.put("biz_rsp_itcpt", String.valueOf(TTMetricsUtil.nanoSecondsToMicroSeconds(this.bizResponseInterceptor)));
            r0.put("hcall_async_cb", String.valueOf(TTMetricsUtil.nanoSecondsToMicroSeconds(this.enqueueCallback)));
            return r0;
        }
    }

    public static class EventTimestamp {
        public long appStart;
        public long appStartTime;
        public long bizInvokeRetrofitRequestInterfaceEnd;
        public long bizInvokeRetrofitRequestInterfaceStart;
        public long bizInvokeRetrofitRequestInterfaceStartTime;
        public long bizReceiveResponseHeader;
        public long bizReceiveResponseHeaderTime;
        public long cronetInitEnd;
        public long cronetInitStart;
        public long executeSsCallEnd;
        public long executeSsCallStart;
        public long logReport;
        public long requestEnd;
        public long requestEndTime;
        public long requestInterceptorEnd;
        public long requestInterceptorStart;
        public long requestRealStart;
        public long responseInterceptorEnd;
        public long responseInterceptorStart;
        public long ssHttpCallApiEnd;
        public long ssHttpCallApiStart;
        public long ssHttpCallApiStartTime;
        public long toRequestEnd;
        public long toRequestStart;

        public EventTimestamp() {
            this.appStart = -1;
            this.appStartTime = -1;
            this.cronetInitStart = -1;
            this.cronetInitEnd = -1;
            this.bizInvokeRetrofitRequestInterfaceStartTime = -1;
            this.bizInvokeRetrofitRequestInterfaceStart = -1;
            this.bizInvokeRetrofitRequestInterfaceEnd = -1;
            this.toRequestStart = -1;
            this.toRequestEnd = -1;
            this.requestRealStart = -1;
            this.ssHttpCallApiStart = -1;
            this.ssHttpCallApiStartTime = -1;
            this.ssHttpCallApiEnd = -1;
            this.requestInterceptorStart = -1;
            this.requestInterceptorEnd = -1;
            this.executeSsCallStart = -1;
            this.executeSsCallEnd = -1;
            this.responseInterceptorStart = -1;
            this.responseInterceptorEnd = -1;
            this.bizReceiveResponseHeader = -1;
            this.bizReceiveResponseHeaderTime = -1;
            this.requestEnd = -1;
            this.requestEndTime = -1;
            this.logReport = -1;
        }

        public EventTimestamp deepCopy() {
            EventTimestamp r0 = new EventTimestamp();
            r0.appStart = this.appStart;
            r0.appStartTime = this.appStartTime;
            r0.cronetInitStart = this.cronetInitStart;
            r0.cronetInitEnd = this.cronetInitEnd;
            r0.bizInvokeRetrofitRequestInterfaceStartTime = this.bizInvokeRetrofitRequestInterfaceStartTime;
            r0.bizInvokeRetrofitRequestInterfaceStart = this.bizInvokeRetrofitRequestInterfaceStart;
            r0.bizInvokeRetrofitRequestInterfaceEnd = this.bizInvokeRetrofitRequestInterfaceEnd;
            r0.ssHttpCallApiStartTime = this.ssHttpCallApiStartTime;
            r0.requestRealStart = this.requestRealStart;
            r0.ssHttpCallApiStart = this.ssHttpCallApiStart;
            r0.ssHttpCallApiEnd = this.ssHttpCallApiEnd;
            r0.requestInterceptorStart = this.requestInterceptorStart;
            r0.requestInterceptorEnd = this.requestInterceptorEnd;
            r0.executeSsCallStart = this.executeSsCallStart;
            r0.executeSsCallEnd = this.executeSsCallEnd;
            r0.responseInterceptorStart = this.responseInterceptorStart;
            r0.responseInterceptorEnd = this.responseInterceptorEnd;
            r0.bizReceiveResponseHeader = this.bizReceiveResponseHeader;
            r0.bizReceiveResponseHeaderTime = this.bizReceiveResponseHeaderTime;
            r0.requestEnd = this.requestEnd;
            r0.requestEndTime = this.requestEndTime;
            r0.logReport = this.logReport;
            return r0;
        }

        public JSONObject toJson() {
            if ((RetrofitLayerMetrics.access$000() & RetrofitLayerMetrics.EVENT_TIMESTAMP_MASK) != 0) goto L6;
            return null;
        L6:
            JSONObject r0 = new JSONObject();
            r0.put("app_start", String.valueOf(TTMetricsUtil.nanoSecondsToMicroSeconds(this.appStart)));
            r0.put("app_start_wc", String.valueOf(this.appStartTime));
            r0.put("cronet_init_s", String.valueOf(TTMetricsUtil.nanoSecondsToMicroSeconds(this.cronetInitStart)));
            r0.put("cronet_init_e", String.valueOf(TTMetricsUtil.nanoSecondsToMicroSeconds(this.cronetInitEnd)));
            r0.put("create_hcall_s_wc", String.valueOf(this.bizInvokeRetrofitRequestInterfaceStartTime));
            r0.put("create_hcall_s", String.valueOf(TTMetricsUtil.nanoSecondsToMicroSeconds(this.bizInvokeRetrofitRequestInterfaceStart)));
            r0.put("create_hcall_e", String.valueOf(TTMetricsUtil.nanoSecondsToMicroSeconds(this.bizInvokeRetrofitRequestInterfaceEnd)));
            r0.put("hcall_api_s", String.valueOf(TTMetricsUtil.nanoSecondsToMicroSeconds(this.ssHttpCallApiStart)));
            r0.put("hcall_api_s_ws", String.valueOf(this.ssHttpCallApiStartTime));
            r0.put("hcall_api_e", String.valueOf(TTMetricsUtil.nanoSecondsToMicroSeconds(this.ssHttpCallApiEnd)));
            r0.put("req_real_s", String.valueOf(TTMetricsUtil.nanoSecondsToMicroSeconds(this.requestRealStart)));
            r0.put("req_itcpt_s", String.valueOf(TTMetricsUtil.nanoSecondsToMicroSeconds(this.requestInterceptorStart)));
            r0.put("req_itcpt_e", String.valueOf(TTMetricsUtil.nanoSecondsToMicroSeconds(this.requestInterceptorEnd)));
            r0.put("sscall_s", String.valueOf(TTMetricsUtil.nanoSecondsToMicroSeconds(this.executeSsCallStart)));
            r0.put("sscall_e", String.valueOf(TTMetricsUtil.nanoSecondsToMicroSeconds(this.executeSsCallEnd)));
            r0.put("rsp_itcpt_s", String.valueOf(TTMetricsUtil.nanoSecondsToMicroSeconds(this.responseInterceptorStart)));
            r0.put("rsp_itcpt_e", String.valueOf(TTMetricsUtil.nanoSecondsToMicroSeconds(this.responseInterceptorEnd)));
            r0.put("biz_rcv_rsp_hdr_wc", String.valueOf(this.bizReceiveResponseHeaderTime));
            r0.put("biz_rcv_rsp_hdr", String.valueOf(TTMetricsUtil.nanoSecondsToMicroSeconds(this.bizReceiveResponseHeader)));
            r0.put("req_e_wc", String.valueOf(this.requestEndTime));
            r0.put("req_e", String.valueOf(TTMetricsUtil.nanoSecondsToMicroSeconds(this.requestEnd)));
            r0.put("log_rpt", String.valueOf(TTMetricsUtil.nanoSecondsToMicroSeconds(this.logReport)));
            return r0;
        }
    }

    public static class ImportantInnerSpan {
        public long addClientKey;
        public long createHttpServiceMethod;
        public long createRequestFactory;
        public long filterDupQuery;
        public long genReqTicket;
        private Deque<Long> innerSpanStart;
        public long preCdnCacheVerify;
        public long reqDelay;
        public long toRequest;
        public long toSsResponse;
        public long updateClientKey;

        public ImportantInnerSpan() {
            this.innerSpanStart = new ArrayDeque();
            this.createRequestFactory = -1;
            this.createHttpServiceMethod = -1;
            this.toRequest = -1;
            this.reqDelay = -1;
            this.filterDupQuery = -1;
            this.genReqTicket = -1;
            this.preCdnCacheVerify = -1;
            this.addClientKey = -1;
            this.toSsResponse = -1;
            this.updateClientKey = -1;
        }

        public long computeDurationNs() {
            Long r4 = (Long) ZeusTransformUtils.preCheckCast(this.innerSpanStart.pop(), Long.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L4
            return System.nanoTime() - r4.longValue();
        L4:
            e = move-exception;
            e.printStackTrace();
            return -1;
        }

        public ImportantInnerSpan deepCopy() {
            ImportantInnerSpan r0 = new ImportantInnerSpan();
            if (this.innerSpanStart.isEmpty() == true) goto L8;
            r0.innerSpanStart = new ArrayDeque();
            Iterator<Long> r1 = this.innerSpanStart.iterator();
        L6:
            if (r1.hasNext() == false) goto L8;
            Long r2 = (Long) ZeusTransformUtils.preCheckCast(r1.next(), Long.class, "com.obric.memorydata.plugin");
            r0.innerSpanStart.push(r2);
        L8:
            r0.createRequestFactory = this.createRequestFactory;
            r0.createHttpServiceMethod = this.createHttpServiceMethod;
            r0.toRequest = this.toRequest;
            r0.filterDupQuery = this.filterDupQuery;
            r0.genReqTicket = this.genReqTicket;
            r0.preCdnCacheVerify = this.preCdnCacheVerify;
            r0.addClientKey = this.addClientKey;
            r0.toSsResponse = this.toSsResponse;
            r0.updateClientKey = this.updateClientKey;
            return r0;
        }

        public void recordInnerSpanStart() {
            this.innerSpanStart.push(Long.valueOf(System.nanoTime()));
        }

        public JSONObject toJson() {
            if ((RetrofitLayerMetrics.access$000() & RetrofitLayerMetrics.IMPORTANT_INNER_SPAN_MASK) != 0) goto L6;
            return null;
        L6:
            JSONObject r0 = new JSONObject();
            r0.put("crt_req_fact", String.valueOf(TTMetricsUtil.nanoSecondsToMicroSeconds(this.createRequestFactory)));
            r0.put("crt_http_svc_meth", String.valueOf(TTMetricsUtil.nanoSecondsToMicroSeconds(this.createHttpServiceMethod)));
            r0.put("to_retrofit_req", String.valueOf(TTMetricsUtil.nanoSecondsToMicroSeconds(this.toRequest)));
            r0.put("req_delay", String.valueOf(TTMetricsUtil.nanoSecondsToMicroSeconds(this.reqDelay)));
            r0.put("flt_dup_qry", String.valueOf(TTMetricsUtil.nanoSecondsToMicroSeconds(this.filterDupQuery)));
            r0.put("gen_req_tkt", String.valueOf(TTMetricsUtil.nanoSecondsToMicroSeconds(this.genReqTicket)));
            r0.put("pre_cdn_cache_vrf", String.valueOf(TTMetricsUtil.nanoSecondsToMicroSeconds(this.preCdnCacheVerify)));
            r0.put("add_cli_key", String.valueOf(TTMetricsUtil.nanoSecondsToMicroSeconds(this.addClientKey)));
            r0.put("to_ss_rsp", String.valueOf(TTMetricsUtil.nanoSecondsToMicroSeconds(this.toSsResponse)));
            r0.put("upd_cli_key", String.valueOf(TTMetricsUtil.nanoSecondsToMicroSeconds(this.updateClientKey)));
            return r0;
        }
    }

    public static class Misc {
        public int blockingQueueSize;
        public int callServerExecutedTimes;
        public boolean executeSsCallSuccess;
        public transient Throwable interceptorResponseThrowable;
        public long requestEndAppResumeState;
        public transient WeakReference<Throwable> requestException;
        public long requestStartAppResumeState;

        public Misc() {
            this.executeSsCallSuccess = false;
            this.callServerExecutedTimes = 0;
            this.interceptorResponseThrowable = null;
            this.blockingQueueSize = 0;
            this.requestException = null;
            this.requestStartAppResumeState = -1;
            this.requestEndAppResumeState = -1;
        }

        public Misc deepCopy() {
            Misc r0 = new Misc();
            r0.executeSsCallSuccess = this.executeSsCallSuccess;
            r0.callServerExecutedTimes = this.callServerExecutedTimes;
            r0.blockingQueueSize = this.blockingQueueSize;
            r0.requestStartAppResumeState = this.requestStartAppResumeState;
            r0.requestEndAppResumeState = this.requestEndAppResumeState;
            if (this.interceptorResponseThrowable == null) goto L5;
            Throwable r1 = new Throwable(this.interceptorResponseThrowable.getMessage());
            r0.interceptorResponseThrowable = r1;
            r1.setStackTrace(this.interceptorResponseThrowable.getStackTrace());
        L5:
            WeakReference<Throwable> r2 = this.requestException;
            if (r2 != null) goto L8;
        L10:
            return r0;
        L8:
            if (r2.get() == null) goto L10;
            WeakReference<Throwable> r3 = new WeakReference(new Throwable(((Throwable) ZeusTransformUtils.preCheckCast(this.requestException.get(), Throwable.class, "com.obric.memorydata.plugin")).getMessage()));
            r0.requestException = r3;
            ((Throwable) ZeusTransformUtils.preCheckCast(r3.get(), Throwable.class, "com.obric.memorydata.plugin")).setStackTrace(((Throwable) ZeusTransformUtils.preCheckCast(this.requestException.get(), Throwable.class, "com.obric.memorydata.plugin")).getStackTrace());
            goto L10
        }

        public JSONObject toJson() {
            if ((RetrofitLayerMetrics.access$000() & RetrofitLayerMetrics.MISC_MASK) != 0) goto L6;
            return null;
        L6:
            JSONObject r0 = new JSONObject();
            r0.put("call_svr_times", this.callServerExecutedTimes);
            r0.put("app_rsm_ssp_req_s", this.requestStartAppResumeState);
            r0.put("app_rsm_ssp_req_e", this.requestEndAppResumeState);
            return r0;
        }
    }

    static {
    }

    public RetrofitLayerMetrics() {
        this.eventTs = new EventTimestamp();
        this.bizSpan = new BizSpan();
        this.innerSpan = new ImportantInnerSpan();
        this.interceptorRecorder = new InterceptorRecorder();
        this.misc = new Misc();
        if (RetrofitMetrics.sAppStartTimeProvider == null) goto L6;
        EventTimestamp r0 = this.eventTs;
        r0.appStart = RetrofitMetrics.sAppStartTimeProvider.getAppStartCPUTimeStamp();
        EventTimestamp r3 = this.eventTs;
        r3.appStartTime = RetrofitMetrics.sAppStartTimeProvider.getAppStartWallClockTimeStamp();
        return;
    }

    static /* synthetic */ int access$000() {
        return reportDetail;
    }

    public static void setReportDetail(int r0) {
        reportDetail = r0;
    }

    public RetrofitLayerMetrics deepCopy() {
        RetrofitLayerMetrics r0 = new RetrofitLayerMetrics();
        r0.eventTs = this.eventTs.deepCopy();
        r0.bizSpan = this.bizSpan.deepCopy();
        r0.innerSpan = this.innerSpan.deepCopy();
        r0.interceptorRecorder = this.interceptorRecorder.deepCopy();
        r0.misc = this.misc.deepCopy();
        return r0;
    }

    public long getRequestDurationMs() {
        return this.eventTs.requestEndTime - this.eventTs.ssHttpCallApiStartTime;
    }

    public JSONObject toJson() {
        JSONObject r0 = new JSONObject();
        r0.put("event_ts", this.eventTs.toJson());
        r0.put("biz_span", this.bizSpan.toJson());
        r0.put("inner_span", this.innerSpan.toJson());
        if ((reportDetail & INTERCEPTOR_MASK) == 0) goto L5;
        r0.put("intcptr", this.interceptorRecorder.toJson());
    L5:
        r0.put("misc", this.misc.toJson());
        return r0;
    }
}
