package org.chromium;

import android.text.TextUtils;
import com.bytedance.frameworks.baselib.network.http.BaseHttpRequestInfo;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.CronetRequestExtraInfo;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.SsCronetHttpClient;
import com.bytedance.retrofit2.RetrofitMetrics;
import com.ttnet.org.chromium.net.RequestFinishedInfo;
import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class h extends RequestFinishedInfo.Listener {
    public final BaseHttpRequestInfo a;

    public static long a(long r3, long r5) {
        if (r5 != (-1)) goto L5;
    L11:
        return -1;
    L5:
        if (r3 == (-1)) goto L11;
        if (r5 > r3) goto L11;
        return r3 - r5;
    }

    static {
    }

    public h(BaseHttpRequestInfo r2) {
        super(new g());
        this.a = r2;
    }

    public static long b(Date r2) {
        if (r2 != null) goto L6;
        return -1;
    L6:
        return r2.getTime();
    }

    public static long c(Long r2) {
        if (r2 != null) goto L6;
        return -1;
    L6:
        return r2.longValue();
    }

    @Override // com.ttnet.org.chromium.net.RequestFinishedInfo.Listener
    public final void onRequestFinished(RequestFinishedInfo r13) {
        if (this.a == null) goto L37;
        if (r13 == null) goto L38;
        RequestFinishedInfo.Metrics r14 = r13.getMetrics();
        if (r14 != null) goto L9;
        return;
    L9:
        this.a.nativeRequestStartTime = b(r14.getRequestStart());
        this.a.metrics.setKernelDns(a(b(r14.getDnsEnd()), b(r14.getDnsStart())));
        this.a.metrics.setKernelTCPConnect(a(b(r14.getConnectEnd()), b(r14.getConnectStart())));
        this.a.metrics.setKernelTls(a(b(r14.getSslEnd()), b(r14.getSslStart())));
        this.a.metrics.setKernelSend(a(b(r14.getSendingEnd()), b(r14.getSendingStart())));
        this.a.metrics.setKernelPush(a(b(r14.getPushEnd()), b(r14.getPushStart())));
        this.a.metrics.setKernelTTFB(c(r14.getTtfbMs()));
        this.a.metrics.setKernelReceiveBody(a(b(r14.getRequestEnd()), b(r14.getResponseStart())));
        this.a.metrics.setKernelTotal(c(r14.getTotalTimeMs()));
        this.a.metrics.setUpperAddCookieDurationUs(c(r14.getAddCookieCostUs()));
        this.a.metrics.setUpperSaveCookieDurationUs(c(r14.getSaveCookieCostUs()));
        RetrofitMetrics r0 = this.a.metrics;
        Integer r1 = r14.getRequestCookieSource();
        if (r1 != null) goto L12;
        int r2 = -1;
    L13:
        r0.setRequestCookieSourceType(r2);
        this.a.metrics.setCronetReadResponseBodyMetrics(r14.getResponseBodyReadTimes(), r14.getFirstReadResponseBodyStart(), r14.getLastReadResponseBodyEnd(), r14.getReadResponseBodyDuration(), r14.getBizReadResponseBodyInterval());
        this.a.metrics.setNetworkKernelRawRequestLog(r14.getRequestLog());
        CronetRequestExtraInfo r3 = new CronetRequestExtraInfo();
        r3.urlDispatchDropReason = r14.getURLDispatchDropReason();
        this.a.metrics.setRequestExtraInfo(r3);
        this.a.remoteIp = r14.getPeerAddr() + ":" + r14.getPeerPort();
        this.a.isSocketReused = r14.getSocketReused();
        this.a.sentByteCount = c(r14.getSentByteCount());
        this.a.receivedByteCount = c(r14.getReceivedByteCount());
        this.a.retryAttempts = c(r14.getRetryAttempts());
        this.a.requestHeaders = r14.getRequestHeaders();
        this.a.responseHeaders = r14.getResponseHeaders();
        this.a.hasSampled = r14.getPreSamplingReportable();
        this.a.bypassApiReport = r14.getBypassApiReport();
        this.a.metrics.setRequestCookieRelMetric(r14.getCookieRelMetric());
        if (TextUtils.isEmpty(this.a.requestLog) == false) goto L35;
        JSONObject r15 = this.a.extraInfo;
        if (r15 == null) goto L35;
        if (SsCronetHttpClient.getCronetTncInfoGet() == null) goto L21;
        JSONObject r4 = SsCronetHttpClient.getCronetTncInfoGet().getABTest();
    L22:
        if (r4 == null) goto L35;
        r15.put("ab_test", r4);     // Catch: JSONException -> L25
    L25:
        e = move-exception;
        e.printStackTrace();
        goto L35
    L21:
        r4 = null;
    L35:
        BaseHttpRequestInfo r16 = this.a;     // Catch: Throwable -> L29
        r16.metrics.extra.put("sentByteCount", Long.valueOf(r16.sentByteCount));     // Catch: Throwable -> L29
        BaseHttpRequestInfo r17 = this.a;     // Catch: Throwable -> L29
        r17.metrics.extra.put("receivedByteCount", Long.valueOf(r17.receivedByteCount));     // Catch: Throwable -> L29
        BaseHttpRequestInfo r18 = this.a;     // Catch: Throwable -> L29
        r18.extraInfo.put("retrofit", r18.metrics.getRetrofitLog());     // Catch: Throwable -> L29
    L31:
        this.a.metrics.markNetworkKernelLogCollected();
        return;
    L29:
        th = move-exception;
        th.printStackTrace();
        goto L31
    L12:
        r2 = r1.intValue();
        goto L13
    L38:
        return;
    }
}
