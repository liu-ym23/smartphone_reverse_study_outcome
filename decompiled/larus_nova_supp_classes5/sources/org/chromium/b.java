package org.chromium;

import com.bytedance.frameworks.baselib.network.http.BaseHttpRequestInfo;
import com.bytedance.frameworks.baselib.network.http.NetworkParams;
import com.bytedance.retrofit2.RetrofitLayerMetrics;
import com.bytedance.retrofit2.RetrofitMetrics;
import com.ttnet.org.chromium.net.TTMonitorProvider;
import com.ttnet.org.chromium.net.impl.NetworkExceptionImpl;
import java.net.ConnectException;
import java.net.NoRouteToHostException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import org.apache.http.conn.ConnectTimeoutException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class b extends TTMonitorProvider {
    public static b a;

    @Override // com.ttnet.org.chromium.net.TTMonitorProvider
    public final boolean handleApiSample(String r1, String r2) {
        return true;
    }

    public static b a() {
        if (a != null) goto L15;
        monitor-enter(b.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (a != null) goto L9;
        a = new b();     // Catch: Throwable -> L11
    L9:
        monitor-exit(b.class);     // Catch: Throwable -> L11
    L15:
        return a;
    }

    public b() {
    }

    @Override // com.ttnet.org.chromium.net.TTMonitorProvider
    public final void sendAppMonitorEvent(String r2, String r3) {
        c.h().k(r2, r3);
    }

    @Override // com.ttnet.org.chromium.net.TTMonitorProvider
    public final void handleApiResult(boolean r12, String r13, String r14, String r15, long r16, long r18, long r20, long r22, long r24, long r26, long r28, long r30, long r32, long r34, boolean r36, long r37, long r39, long r41, String r43, String r44, String r45, int r46, int r47, String r48, String r49) {
        BaseHttpRequestInfo r8 = BaseHttpRequestInfo.createHttpRequestInfo();
        r8.traceCode = r14;
        r8.remoteIp = r15;
        r8.appLevelRequestStart = r16;
        r8.beforeAllInterceptors = r16;
        r8.requestStart = r18;
        RetrofitMetrics r1 = r8.metrics;
        RetrofitLayerMetrics.EventTimestamp r2 = r1.retrofit.eventTs;
        r2.ssHttpCallApiStartTime = r18;
        r8.requestEnd = r24;
        r2.requestEndTime = r24;
        r1.setKernelDns(r26);
        r8.metrics.setKernelTCPConnect(r28);
        r8.metrics.setKernelTls(r30);
        r8.metrics.setKernelSend(r32);
        r8.metrics.setKernelTTFB(r37);
        r8.metrics.setKernelReceiveBody(r34);
        r8.metrics.setKernelTotal(r24 - r18);
        r8.metrics.setNetworkKernelRawRequestLog(r43);
        r8.responseBack = r20;
        r8.completeReadResponse = r22;
        r8.isSocketReused = r36;
        r8.receivedByteCount = r39;
        r8.sentByteCount = r41;
        r8.requestHeaders = r44;
        r8.responseHeaders = r45;
        r8.httpClientType = 0;
        r8.bizExtraLog = r49;
        if (r12 == false) goto L5;
        NetworkParams.monitorApiOk(r13, r8);
        return;
    L5:
        switch(r46) {
            case 1: goto L19;
            case 2: goto L18;
            case 3: goto L17;
            case 4: goto L16;
            case 5: goto L15;
            case 6: goto L14;
            case 7: goto L13;
            case 8: goto L12;
            case 9: goto L11;
            case 10: goto L10;
            case 11: goto L9;
            default: goto L7;
        };
    L9:
        int r3 = 11;
    L21:
        NetworkExceptionImpl r4 = new NetworkExceptionImpl("Exception in CronetUrlRequest: " + r48, r3, r47);
        int r5 = r4.getErrorCode();
        Throwable r6 = r4;
        switch(r5) {
            case 1: goto L30;
            case 2: goto L29;
            case 3: goto L29;
            case 4: goto L28;
            case 5: goto L27;
            case 6: goto L26;
            case 7: goto L27;
            case 8: goto L25;
            case 9: goto L24;
            default: goto L32;
        };
    L24:
        Throwable r7 = new NoRouteToHostException(r4.getMessage());
    L31:
        r6 = r7;
        goto L32
    L25:
        r7 = new SocketException("reset by peer " + r4.getMessage());
        goto L31
    L26:
        r7 = new ConnectTimeoutException(r4.getMessage());
        goto L31
    L27:
        r7 = new ConnectException(r4.getMessage());
        goto L31
    L28:
        r7 = new SocketTimeoutException(r4.getMessage());
        goto L31
    L29:
        r7 = new ConnectException(r4.getMessage());
        goto L31
    L30:
        r7 = new UnknownHostException(r4.getMessage());
    L32:
        NetworkParams.monitorApiError(r13, r8, r6);
        return;
    L10:
        r3 = 10;
        goto L21
    L11:
        r3 = 9;
        goto L21
    L12:
        r3 = 8;
        goto L21
    L13:
        r3 = 7;
        goto L21
    L14:
        r3 = 6;
        goto L21
    L15:
        r3 = 5;
        goto L21
    L16:
        r3 = 4;
        goto L21
    L17:
        r3 = 3;
        goto L21
    L18:
        r3 = 2;
        goto L21
    L19:
        r3 = 1;
        goto L21
    L7:
        if (d.a().loggerDebug() == false) goto L20;
        d.a().loggerD("monitor", "Unknown error code: " + r46);
    L20:
        r3 = r46;
        goto L21
    }
}
