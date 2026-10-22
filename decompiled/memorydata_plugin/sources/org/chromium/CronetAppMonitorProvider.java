package org.chromium;

import com.bytedance.frameworks.baselib.network.http.b;
import com.bytedance.frameworks.baselib.network.http.f;
import com.ttnet.org.chromium.net.TTMonitorProvider;

/* JADX INFO: loaded from: classes7.dex */
public class CronetAppMonitorProvider extends TTMonitorProvider {
    private static CronetAppMonitorProvider sInstance;

    private CronetAppMonitorProvider() {
    }

    public static CronetAppMonitorProvider inst() {
        if (sInstance != null) goto L15;
        monitor-enter(CronetAppMonitorProvider.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new CronetAppMonitorProvider();     // Catch: Throwable -> L11
    L9:
        monitor-exit(CronetAppMonitorProvider.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    @Override // com.ttnet.org.chromium.net.TTMonitorProvider
    public void handleApiResult(boolean r11, String r12, String r13, String r14, long r15, long r17, long r19, long r21, long r23, long r25, long r27, long r29, long r31, long r33, boolean r35, long r36, long r38, String r40, String r41, String r42, int r43, int r44, String r45) {
        b r7 = b.a();
        r7.P = r13;
        r7.w = r14;
        r7.e = r15;
        r7.f = r15;
        r7.g = r17;
        r7.d.retrofit.eventTs.ssHttpCallApiStartTime = r17;
        r7.j = r23;
        r7.d.retrofit.eventTs.requestEndTime = r23;
        r7.d.setKernelDns(r25);
        r7.d.setKernelTCPConnect(r27);
        r7.d.setKernelTls(r29);
        r7.d.setKernelSend(r31);
        r7.d.setKernelTTFB(r36);
        r7.d.setKernelReceiveBody(r33);
        r7.d.setKernelTotal(r23 - r17);
        r7.d.setNetworkKernelRawRequestLog(r40);
        r7.h = r19;
        r7.i = r21;
        r7.D = r35;
        r7.y = r38;
        r7.M = r41;
        r7.N = r42;
        r7.G = 0;
        if (r11 == false) goto L5;
        f.a(r12, r7);
        return;
    L5:
        f.a(r12, r7, Utils.tryConvertCronetException(Utils.createCronetException(r43, r44, r45)));
    }

    @Override // com.ttnet.org.chromium.net.TTMonitorProvider
    @Deprecated
    public boolean handleApiSample(String r1, String r2) {
        return true;
    }

    @Override // com.ttnet.org.chromium.net.TTMonitorProvider
    public void sendAppMonitorEvent(String r1, String r2) {
        CronetAppProviderManager.inst().sendAppMonitorEvent(r1, r2);
    }
}
