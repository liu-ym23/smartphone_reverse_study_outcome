package org.chromium;

import android.text.TextUtils;
import com.bytedance.frameworks.baselib.network.http.b;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.c;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.h;
import com.bytedance.retrofit2.RetrofitMetrics;
import com.ttnet.org.chromium.net.RequestFinishedInfo;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Date;
import org.apache.logging.log4j.message.ParameterizedMessage;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public class TTCronetRequestFinishedInfoListener extends RequestFinishedInfo.Listener {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private b requestInfo;

    static {
    }

    public TTCronetRequestFinishedInfoListener(b r2) {
        super($$Lambda$TTCronetRequestFinishedInfoListener$JYwvBxO7E9h5dryxbVHLyCV6wAc.INSTANCE);
        this.requestInfo = r2;
    }

    private static void addABTestInfo(JSONObject r2) {
        if (r2 != null) goto L5;
        return;
    L5:
        if (h.a() == null) goto L7;
        JSONObject r0 = h.a().getABTest();
    L8:
        if (r0 == null) goto L16;
        r2.put("ab_test", r0);     // Catch: JSONException -> L11
        return;
    L11:
        e = move-exception;
        e.printStackTrace();
        return;
    L16:
        return;
    L7:
        r0 = null;
        goto L8
    }

    private static long getCostTime(long r3, long r5) {
        if (r5 != (-1)) goto L5;
    L11:
        return -1;
    L5:
        if (r3 == (-1)) goto L11;
        if (r5 > r3) goto L11;
        return r3 - r5;
    }

    private static long getTime(Date r2) {
        if (r2 != null) goto L6;
        return -1;
    L6:
        return r2.getTime();
    }

    private static int getValue(Integer r0) {
        if (r0 != null) goto L6;
        return -1;
    L6:
        return r0.intValue();
    }

    private static long getValue(Long r2) {
        if (r2 != null) goto L6;
        return -1;
    L6:
        return r2.longValue();
    }

    static /* synthetic */ void lambda$new$0(Runnable r2) {
        Runnable r3 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r2, Runnable.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L6;
        r3.run();
        return;
    }

    @Override // com.ttnet.org.chromium.net.RequestFinishedInfo.Listener
    public void onRequestFinished(RequestFinishedInfo r13) {
        if (this.requestInfo == null) goto L20;
        if (r13 == null) goto L21;
        RequestFinishedInfo.Metrics r14 = r13.getMetrics();
        if (r14 != null) goto L9;
        return;
    L9:
        this.requestInfo.l = getTime(r14.getRequestStart());
        this.requestInfo.d.setKernelDns(getCostTime(getTime(r14.getDnsEnd()), getTime(r14.getDnsStart())));
        this.requestInfo.d.setKernelTCPConnect(getCostTime(getTime(r14.getConnectEnd()), getTime(r14.getConnectStart())));
        this.requestInfo.d.setKernelTls(getCostTime(getTime(r14.getSslEnd()), getTime(r14.getSslStart())));
        this.requestInfo.d.setKernelSend(getCostTime(getTime(r14.getSendingEnd()), getTime(r14.getSendingStart())));
        this.requestInfo.d.setKernelPush(getCostTime(getTime(r14.getPushEnd()), getTime(r14.getPushStart())));
        this.requestInfo.d.setKernelTTFB(getValue(r14.getTtfbMs()));
        this.requestInfo.d.setKernelReceiveBody(getCostTime(getTime(r14.getRequestEnd()), getTime(r14.getResponseStart())));
        this.requestInfo.d.setKernelTotal(getValue(r14.getTotalTimeMs()));
        this.requestInfo.d.setUpperAddCookieDurationUs(getValue(r14.getAddCookieCostUs()));
        this.requestInfo.d.setUpperSaveCookieDurationUs(getValue(r14.getSaveCookieCostUs()));
        this.requestInfo.d.setRequestCookieSourceType(getValue(r14.getRequestCookieSource()));
        this.requestInfo.d.setCronetReadResponseBodyMetrics(r14.getResponseBodyReadTimes(), r14.getFirstReadResponseBodyStart(), r14.getLastReadResponseBodyEnd(), r14.getReadResponseBodyDuration(), r14.getBizReadResponseBodyInterval());
        this.requestInfo.d.setNetworkKernelRawRequestLog(r14.getRequestLog());
        c r0 = new c();
        r0.f2413a = r14.getURLDispatchDropReason();
        this.requestInfo.d.setRequestExtraInfo(r0);
        this.requestInfo.w = r14.getPeerAddr() + ParameterizedMessage.ERROR_MSG_SEPARATOR + r14.getPeerPort();
        this.requestInfo.D = r14.getSocketReused();
        this.requestInfo.x = getValue(r14.getSentByteCount());
        this.requestInfo.y = getValue(r14.getReceivedByteCount());
        this.requestInfo.E = getValue(r14.getRetryAttempts());
        this.requestInfo.M = r14.getRequestHeaders();
        this.requestInfo.N = r14.getResponseHeaders();
        this.requestInfo.Q = r14.getPreSamplingReportable();
        this.requestInfo.R = r14.getBypassApiReport();
        this.requestInfo.d.setRequestCookieRelMetric(r14.getCookieRelMetric());
        if (TextUtils.isEmpty(this.requestInfo.f2361J) == false) goto L18;
        addABTestInfo(this.requestInfo.K);
    L18:
        this.requestInfo.d.extra.put(RetrofitMetrics.ExtraKeys.SENT_BYTE_COUNT, Long.valueOf(this.requestInfo.x));     // Catch: Throwable -> L14
        this.requestInfo.d.extra.put(RetrofitMetrics.ExtraKeys.RECEIVED_BYTE_COUNT, Long.valueOf(this.requestInfo.y));     // Catch: Throwable -> L14
        this.requestInfo.K.put("retrofit", this.requestInfo.d.getRetrofitLog());     // Catch: Throwable -> L14
    L16:
        this.requestInfo.d.markNetworkKernelLogCollected();
        return;
    L14:
        th = move-exception;
        th.printStackTrace();
        goto L16
    L21:
        return;
    }
}
