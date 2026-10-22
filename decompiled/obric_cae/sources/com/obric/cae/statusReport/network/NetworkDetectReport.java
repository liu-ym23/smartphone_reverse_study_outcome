package com.obric.cae.statusReport.network;

import com.obric.cae.log.CaeLog;
import com.obric.cae.network.CaeNetworkHandoverData;
import com.obric.cae.network.CaeNetworkHandoverProto;
import com.obric.cae.network.NetworkDetectData;
import com.obric.cae.smartNetwork.networkMonitor.HttpConnectionProbe;
import com.obric.cae.utils.CaeUtil;
import com.obric.cae.utils.CaeWifiUtil;
import defpackage.b;

/* JADX INFO: loaded from: classes2.dex */
public class NetworkDetectReport {
    private static final String TAG = "NetworkDetectReport";

    public NetworkDetectReport() {
    }

    private static CaeNetworkHandoverProto buildHandoverData(NetworkDetectData r8) {
        CaeNetworkHandoverData.Builder r10 = CaeNetworkHandoverData.newBuilder();
        r10.setNetworkDetectEvent(r8);
        return CaeNetworkHandoverProto.newBuilder().addNetworkHandoverEvent(r10).build();
    }

    public static void reportFailedResult(int r8, int r10, int r11, int r12) {
        reportFailedResult(r8, r10, r11, r12, 0, null, null);
    }

    public static void reportPortalResult(int r8, int r10, int r11, String r12) {
        reportPortalResult(r8, r10, r11, r12, 0, null, null);
    }

    public static void reportSuccessResult(int r8, int r10, int r11, int r12) {
        reportSuccessResult(r8, r10, r11, r12, null, null);
    }

    private static void setNetworkDetailInfo(NetworkDetectData.Builder r8, NetworkInfoCollect.NetworkDetailInfo r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        r8.setWifiRssi(r10.getWifiRssi()).setWifiFreq(r10.getWifiFreq()).setCellType(r10.getCellType()).setCellRsrp(r10.getCellRsrp()).setCellSinr(r10.getCellSinr());
        if (r10.getWifiSsid() == null) goto L8;
        r8.setWifiSsid(CaeWifiUtil.ssidHide(r10.getWifiSsid()));
        return;
    }

    private static void setTiming(NetworkDetectData.Builder r8, HttpConnectionProbe.HttpProbeTiming r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        r8.setDnsTimeMs(r10.getDnsTimeMs()).setConnectTimeMs(r10.getConnectTimeMs()).setTlsTimeMs(r10.getTlsTimeMs()).setTtfbDurationMs(r10.getTtfbDurationMs()).setTotalTimeMs(r10.getTotalTimeMs());
    }

    public static void reportFailedResult(int r8, int r10, int r11, int r12, int r13, HttpConnectionProbe.HttpProbeTiming r14, NetworkInfoCollect.NetworkDetailInfo r15) {
        NetworkDetectData.Builder r16 = NetworkDetectData.newBuilder();
        r16.setTimestamp(System.currentTimeMillis()).setDetectScene(r8).setNetworkType(r10).setDetectResult(2).setDetectRtt(r13).setErrorCode(r12).setResponseCode(r11);
        setTiming(r16, r14);
        setNetworkDetailInfo(r16, r15);
        CaeNetworkHandoverProto r17 = buildHandoverData(r16.build());
        StringBuilder r18 = defpackage.a.g("reportDetectFailedResult: detectScene = ", r8, ", networkType = ", r10, ", detectRtt = ");
        b.q(r18, r13, ", errorCode = ", r12, ", timing = ");
        r18.append(r14);
        r18.append(", networkDetailInfo = ");
        r18.append(r15);
        r18.append(", responseCode = ");
        r18.append(r11);
        CaeLog.i(TAG, r18.toString());
        CaeUtil.writePbEventSafely(System.currentTimeMillis(), 95, r17.toByteArray());
    }

    public static void reportPortalResult(int r8, int r10, int r11, String r12, int r13, HttpConnectionProbe.HttpProbeTiming r14, NetworkInfoCollect.NetworkDetailInfo r15) {
        NetworkDetectData.Builder r16 = NetworkDetectData.newBuilder();
        r16.setTimestamp(System.currentTimeMillis()).setDetectScene(r8).setNetworkType(r10).setDetectResult(3).setDetectRtt(r13).setRedirectUrl(r12).setResponseCode(r11);
        setTiming(r16, r14);
        setNetworkDetailInfo(r16, r15);
        CaeNetworkHandoverProto r17 = buildHandoverData(r16.build());
        StringBuilder r18 = defpackage.a.g("reportDetectPortalResult: detectScene = ", r8, ", networkType = ", r10, ", detectRtt = ");
        r18.append(r13);
        r18.append(", redirectUrl = ");
        r18.append(r12);
        r18.append(", timing = ");
        r18.append(r14);
        r18.append(", networkDetailInfo = ");
        r18.append(r15);
        r18.append(", responseCode = ");
        r18.append(r11);
        CaeLog.i(TAG, r18.toString());
        CaeUtil.writePbEventSafely(System.currentTimeMillis(), 95, r17.toByteArray());
    }

    public static void reportSuccessResult(int r8, int r10, int r11, int r12, HttpConnectionProbe.HttpProbeTiming r13, NetworkInfoCollect.NetworkDetailInfo r14) {
        NetworkDetectData.Builder r15 = NetworkDetectData.newBuilder();
        r15.setTimestamp(System.currentTimeMillis()).setDetectScene(r8).setNetworkType(r10).setDetectResult(1).setDetectRtt(r12).setResponseCode(r11);
        setTiming(r15, r13);
        setNetworkDetailInfo(r15, r14);
        CaeNetworkHandoverProto r16 = buildHandoverData(r15.build());
        StringBuilder r17 = defpackage.a.g("reportDetectSuccessResult: detectScene = ", r8, ", networkType = ", r10, ", detectRtt = ");
        r17.append(r12);
        r17.append(", timing = ");
        r17.append(r13);
        r17.append(", networkDetailInfo = ");
        r17.append(r14);
        r17.append(", responseCode = ");
        r17.append(r11);
        CaeLog.i(TAG, r17.toString());
        CaeUtil.writePbEventSafely(System.currentTimeMillis(), 95, r16.toByteArray());
    }
}
