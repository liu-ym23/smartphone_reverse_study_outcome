package com.bytedance.retrofit2;

import android.text.TextUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class NetworkLibLayerMetrics {
    public static int BIZ_SPAN_MASK = 64;
    public static int EVENT_TIMESTAMP_MASK = 32;
    public static int IMPORTANT_INNER_SPAN_MASK = 128;
    public static int MISC_MASK = 256;
    private static volatile int reportDetail = -1;
    public BizSpan bizSpan;
    public EventTimestamp eventTs;
    public ImportantInnerSpan innerSpan;
    public ImportantKernelSpan kernelSpan;
    public Misc misc;
    public String networkKernelRawRequestLog;

    public static class BizSpan {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        public long accountRetryDuration;
        public long bdTuringDuration;
        private long bizCallbackStart;
        public long bodyEncrypt;
        public long inputStreamProcessDuration;
        public long onTryInit;
        public long readResponseBodyInterval;
        public long requestAuditDuration;
        public long rotationRetryAccumulatedDuration;
        public long tryInitCookieManager;
        public long waitReadResponseBody;

        static {
        }

        public BizSpan() {
            this.bizCallbackStart = -1;
            this.bodyEncrypt = -1;
            this.onTryInit = -1;
            this.tryInitCookieManager = -1;
            this.bdTuringDuration = -1;
            this.accountRetryDuration = -1;
            this.rotationRetryAccumulatedDuration = -1;
            this.requestAuditDuration = -1;
            this.waitReadResponseBody = -1;
            this.readResponseBodyInterval = -1;
            this.inputStreamProcessDuration = -1;
        }

        public long computeDurationNs() {
            long r0 = System.nanoTime() - this.bizCallbackStart;
            this.bizCallbackStart = -1;
            return r0;
        }

        public BizSpan deepCopy() {
            BizSpan r0 = new BizSpan();
            r0.bizCallbackStart = this.bizCallbackStart;
            r0.bodyEncrypt = this.bodyEncrypt;
            r0.onTryInit = this.onTryInit;
            r0.tryInitCookieManager = this.tryInitCookieManager;
            r0.bdTuringDuration = this.bdTuringDuration;
            r0.accountRetryDuration = this.accountRetryDuration;
            r0.rotationRetryAccumulatedDuration = this.rotationRetryAccumulatedDuration;
            r0.requestAuditDuration = this.requestAuditDuration;
            r0.waitReadResponseBody = this.waitReadResponseBody;
            r0.readResponseBodyInterval = this.readResponseBodyInterval;
            r0.inputStreamProcessDuration = this.inputStreamProcessDuration;
            return r0;
        }

        public void recordCallbackStart() {
            this.bizCallbackStart = System.nanoTime();
        }

        public JSONObject toJson() {
            if ((NetworkLibLayerMetrics.access$000() & NetworkLibLayerMetrics.BIZ_SPAN_MASK) != 0) goto L6;
            return null;
        L6:
            JSONObject r0 = new JSONObject();
            r0.put("bdy_encrypt", String.valueOf(TTMetricsUtil.nanoSecondsToMicroSeconds(this.bodyEncrypt)));
            r0.put("on_try_init", String.valueOf(TTMetricsUtil.nanoSecondsToMicroSeconds(this.onTryInit)));
            r0.put("init_cookie", String.valueOf(TTMetricsUtil.nanoSecondsToMicroSeconds(this.tryInitCookieManager)));
            r0.put("bd_turing", String.valueOf(TTMetricsUtil.nanoSecondsToMicroSeconds(this.bdTuringDuration)));
            r0.put("acnt_rty", String.valueOf(TTMetricsUtil.nanoSecondsToMicroSeconds(this.accountRetryDuration)));
            r0.put("rot_rty", String.valueOf(TTMetricsUtil.nanoSecondsToMicroSeconds(this.rotationRetryAccumulatedDuration)));
            r0.put("wait_rd_rsp_bdy", String.valueOf(TTMetricsUtil.nanoSecondsToMicroSeconds(this.waitReadResponseBody)));
            r0.put("rd_rsp_bdy_intvl", String.valueOf(TTMetricsUtil.nanoSecondsToMicroSeconds(this.readResponseBodyInterval)));
            r0.put("input_stream_prc", String.valueOf(TTMetricsUtil.nanoSecondsToMicroSeconds(this.inputStreamProcessDuration)));
            long r1 = this.requestAuditDuration;
            if (r1 <= 0) goto L9;
            r0.put("req_audit", String.valueOf(TTMetricsUtil.nanoSecondsToMicroSeconds(r1)));
        L9:
            return r0;
        }
    }

    public static class EventTimestamp {
        public long executeConnectionEnd;
        public long executeConnectionStart;
        public long firstReadResponseBodyStart;
        public long latestReadResponseBodyEnd;
        public long prepareConnectionEnd;
        public long prepareConnectionStart;
        public long processResponseBodyEnd;
        public long processResponseBodyStart;

        public EventTimestamp() {
            this.prepareConnectionStart = -1;
            this.prepareConnectionEnd = -1;
            this.executeConnectionStart = -1;
            this.executeConnectionEnd = -1;
            this.processResponseBodyStart = -1;
            this.processResponseBodyEnd = -1;
            this.firstReadResponseBodyStart = -1;
            this.latestReadResponseBodyEnd = -1;
        }

        public EventTimestamp deepCopy() {
            EventTimestamp r0 = new EventTimestamp();
            r0.prepareConnectionStart = this.prepareConnectionStart;
            r0.prepareConnectionEnd = this.prepareConnectionEnd;
            r0.executeConnectionStart = this.executeConnectionStart;
            r0.executeConnectionEnd = this.executeConnectionEnd;
            r0.processResponseBodyStart = this.processResponseBodyStart;
            r0.processResponseBodyEnd = this.processResponseBodyEnd;
            r0.firstReadResponseBodyStart = this.firstReadResponseBodyStart;
            r0.latestReadResponseBodyEnd = this.latestReadResponseBodyEnd;
            return r0;
        }

        public JSONObject toJson() {
            if ((NetworkLibLayerMetrics.access$000() & NetworkLibLayerMetrics.EVENT_TIMESTAMP_MASK) != 0) goto L6;
            return null;
        L6:
            JSONObject r0 = new JSONObject();
            r0.put("prp_conn_s", String.valueOf(TTMetricsUtil.nanoSecondsToMicroSeconds(this.prepareConnectionStart)));
            r0.put("prp_conn_e", String.valueOf(TTMetricsUtil.nanoSecondsToMicroSeconds(this.prepareConnectionEnd)));
            r0.put("exe_conn_s", String.valueOf(TTMetricsUtil.nanoSecondsToMicroSeconds(this.executeConnectionStart)));
            r0.put("exe_conn_e", String.valueOf(TTMetricsUtil.nanoSecondsToMicroSeconds(this.executeConnectionEnd)));
            r0.put("prc_rsp_bdy_s", String.valueOf(TTMetricsUtil.nanoSecondsToMicroSeconds(this.processResponseBodyStart)));
            r0.put("prc_rsp_bdy_e", String.valueOf(TTMetricsUtil.nanoSecondsToMicroSeconds(this.processResponseBodyEnd)));
            r0.put("frs_rd_rsp_bdy_s", String.valueOf(TTMetricsUtil.nanoSecondsToMicroSeconds(this.firstReadResponseBodyStart)));
            r0.put("lst_rd_rsp_bdy_e", String.valueOf(TTMetricsUtil.nanoSecondsToMicroSeconds(this.latestReadResponseBodyEnd)));
            return r0;
        }
    }

    public static class ImportantInnerSpan {
        public long configureConnection;
        public long constructConfigureAndRetryConnection;
        public long constructConnection;
        public long executeConnection;
        private Deque<Long> innerSpanStart;
        public long postProcessBody;
        public long processResponseBody;
        public long queryFilter;
        public long readResponseBody;
        public long reflection;

        public ImportantInnerSpan() {
            this.innerSpanStart = new ArrayDeque();
            this.queryFilter = -1;
            this.constructConnection = -1;
            this.configureConnection = -1;
            this.reflection = -1;
            this.executeConnection = -1;
            this.constructConfigureAndRetryConnection = -1;
            this.processResponseBody = -1;
            this.postProcessBody = -1;
            this.readResponseBody = -1;
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
            r0.queryFilter = this.queryFilter;
            r0.constructConnection = this.constructConnection;
            r0.configureConnection = this.configureConnection;
            r0.executeConnection = this.executeConnection;
            r0.constructConfigureAndRetryConnection = this.constructConfigureAndRetryConnection;
            r0.processResponseBody = this.processResponseBody;
            r0.postProcessBody = this.postProcessBody;
            r0.readResponseBody = this.readResponseBody;
            r0.reflection = this.reflection;
            if (this.innerSpanStart.isEmpty() == true) goto L8;
            r0.innerSpanStart = new ArrayDeque();
            Iterator<Long> r4 = this.innerSpanStart.iterator();
        L6:
            if (r4.hasNext() == false) goto L8;
            Long r1 = (Long) ZeusTransformUtils.preCheckCast(r4.next(), Long.class, "com.obric.memorydata.plugin");
            r0.innerSpanStart.push(r1);
        L8:
            return r0;
        }

        public void recordInnerSpanStart() {
            this.innerSpanStart.push(Long.valueOf(System.nanoTime()));
        }

        public JSONObject toJson() {
            if ((NetworkLibLayerMetrics.access$000() & NetworkLibLayerMetrics.IMPORTANT_INNER_SPAN_MASK) != 0) goto L6;
            return null;
        L6:
            JSONObject r0 = new JSONObject();
            r0.put("qry_flt", String.valueOf(TTMetricsUtil.nanoSecondsToMicroSeconds(this.queryFilter)));
            r0.put("last_cons_conn", String.valueOf(TTMetricsUtil.nanoSecondsToMicroSeconds(this.constructConnection)));
            r0.put("last_conf_conn", String.valueOf(TTMetricsUtil.nanoSecondsToMicroSeconds(this.configureConnection)));
            r0.put("last_exe_conn", String.valueOf(TTMetricsUtil.nanoSecondsToMicroSeconds(this.executeConnection)));
            r0.put("cons_conf_n_rty_conn", String.valueOf(TTMetricsUtil.nanoSecondsToMicroSeconds(this.constructConfigureAndRetryConnection)));
            r0.put("prc_rsp_bdy", String.valueOf(TTMetricsUtil.nanoSecondsToMicroSeconds(this.processResponseBody)));
            r0.put("post_prc_rsp_bdy", String.valueOf(TTMetricsUtil.nanoSecondsToMicroSeconds(this.postProcessBody)));
            r0.put("total_rd_rsp_bdy", String.valueOf(TTMetricsUtil.nanoSecondsToMicroSeconds(this.readResponseBody)));
            r0.put("reflect", String.valueOf(TTMetricsUtil.nanoSecondsToMicroSeconds(this.reflection)));
            return r0;
        }
    }

    public static class ImportantKernelSpan {
        public long dns;
        public long push;
        public long receiveBody;
        public long send;
        public long tcpConnect;
        public long tls;
        public long total;
        public long ttfb;
        public long upperAddCookieDurationUs;
        public long upperSaveCookieDurationUs;

        public ImportantKernelSpan() {
            this.dns = -1;
            this.tcpConnect = -1;
            this.tls = -1;
            this.send = -1;
            this.push = -1;
            this.ttfb = -1;
            this.receiveBody = -1;
            this.total = -1;
            this.upperAddCookieDurationUs = -1;
            this.upperSaveCookieDurationUs = -1;
        }

        public ImportantKernelSpan deepCopy() {
            ImportantKernelSpan r0 = new ImportantKernelSpan();
            r0.dns = this.dns;
            r0.tcpConnect = this.tcpConnect;
            r0.tls = this.tls;
            r0.send = this.send;
            r0.push = this.push;
            r0.ttfb = this.ttfb;
            r0.receiveBody = this.receiveBody;
            r0.total = this.total;
            r0.upperAddCookieDurationUs = this.upperAddCookieDurationUs;
            r0.upperSaveCookieDurationUs = this.upperSaveCookieDurationUs;
            return r0;
        }

        public JSONObject toJson() {
            if ((NetworkLibLayerMetrics.access$000() & NetworkLibLayerMetrics.IMPORTANT_INNER_SPAN_MASK) != 0) goto L6;
            return null;
        L6:
            JSONObject r0 = new JSONObject();
            r0.put("add_cookie", String.valueOf(this.upperAddCookieDurationUs));
            r0.put("save_cookie", String.valueOf(this.upperSaveCookieDurationUs));
            return r0;
        }
    }

    public static class Misc {
        public boolean isConcurrentRequest;
        public boolean readResponseBodyInternal;
        public JSONObject requestAuditLog;
        public String requestCookieRelMetric;
        public int requestCookieSourceType;
        public Object requestExtraInfo;
        public long responseBodyReadTimes;
        public JSONObject rotationHostRetryInfo;

        public Misc() {
            this.isConcurrentRequest = false;
            this.requestCookieSourceType = -1;
            this.requestCookieRelMetric = null;
            this.rotationHostRetryInfo = null;
            this.responseBodyReadTimes = -1;
            this.readResponseBodyInternal = false;
            this.requestExtraInfo = null;
            this.requestAuditLog = null;
        }

        public Misc deepCopy() {
            Misc r0 = new Misc();
            r0.isConcurrentRequest = this.isConcurrentRequest;
            r0.requestCookieSourceType = this.requestCookieSourceType;
            r0.requestCookieRelMetric = this.requestCookieRelMetric;
            r0.responseBodyReadTimes = this.responseBodyReadTimes;
            r0.readResponseBodyInternal = this.readResponseBodyInternal;
            r0.requestExtraInfo = this.requestExtraInfo;
            if (this.rotationHostRetryInfo == null) goto L7;
            r0.rotationHostRetryInfo = new JSONObject(this.rotationHostRetryInfo.toString());     // Catch: JSONException -> L10
        L7:
            if (this.requestAuditLog == null) goto L9;
            r0.requestAuditLog = new JSONObject(this.requestAuditLog.toString());     // Catch: JSONException -> L10
        L9:
            return r0;
        }

        public JSONObject toJson() {
            if ((NetworkLibLayerMetrics.access$000() & NetworkLibLayerMetrics.MISC_MASK) != 0) goto L6;
            return null;
        L6:
            JSONObject r0 = new JSONObject();
            JSONObject r1 = this.requestAuditLog;
            if (r1 == null) goto L10;
            r0.put("req_audit", r1);
        L10:
            if (TextUtils.isEmpty(this.requestCookieRelMetric) == false) goto L14;
        L12:
            return r0;
        L14:
            r0.put("cookie_rel", new JSONObject(this.requestCookieRelMetric));     // Catch: Throwable -> L13
            goto L12
        }
    }

    static {
    }

    public NetworkLibLayerMetrics() {
        this.eventTs = new EventTimestamp();
        this.bizSpan = new BizSpan();
        this.innerSpan = new ImportantInnerSpan();
        this.kernelSpan = new ImportantKernelSpan();
        this.misc = new Misc();
        this.networkKernelRawRequestLog = "";
    }

    static /* synthetic */ int access$000() {
        return reportDetail;
    }

    public static void setReportDetail(int r0) {
        reportDetail = r0;
    }

    public NetworkLibLayerMetrics deepCopy() {
        NetworkLibLayerMetrics r0 = new NetworkLibLayerMetrics();
        r0.eventTs = this.eventTs.deepCopy();
        r0.bizSpan = this.bizSpan.deepCopy();
        r0.innerSpan = this.innerSpan.deepCopy();
        r0.kernelSpan = this.kernelSpan.deepCopy();
        r0.misc = this.misc.deepCopy();
        r0.networkKernelRawRequestLog = this.networkKernelRawRequestLog;
        return r0;
    }

    public JSONObject toJson() {
        JSONObject r0 = new JSONObject();
        r0.put("event_ts", this.eventTs.toJson());
        r0.put("biz_span", this.bizSpan.toJson());
        r0.put("inner_span", this.innerSpan.toJson());
        r0.put("misc", this.misc.toJson());
        return r0;
    }
}
