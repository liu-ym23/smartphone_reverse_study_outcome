package org.chromium;

import android.os.Process;
import com.bytedance.frameworks.baselib.network.TTNetInitMetrics;
import com.bytedance.frameworks.baselib.network.http.NativeRequestInterceptor;
import com.bytedance.retrofit2.mime.TTRequestCompressManager;
import com.ttnet.org.chromium.net.TTEventListener;
import com.ttnet.org.chromium.net.impl.TTCronetInitTimingInfo;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;
import r1.a;

/* JADX INFO: loaded from: classes3.dex */
public class CronetEventListener extends TTEventListener {
    private static volatile CronetEventListener sInstance;
    private boolean enableOptInit;
    private boolean isMainProcess;

    private CronetEventListener() {
        this.isMainProcess = false;
        this.enableOptInit = false;
    }

    public static CronetEventListener inst() {
        if (sInstance != null) goto L15;
        monitor-enter(CronetEventListener.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new CronetEventListener();     // Catch: Throwable -> L11
    L9:
        monitor-exit(CronetEventListener.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    public void enableOptInit(boolean r10) {
        this.enableOptInit = r10;
    }

    @Override // com.ttnet.org.chromium.net.TTEventListener
    public void handleApiResult(boolean r38, String r39, String r40, String r41, long r42, long r44, long r46, long r48, long r50, long r52, long r54, long r56, long r58, long r60, boolean r62, long r63, long r65, String r67, String r68, String r69, int r70, int r71, String r72) {
        if (this.isMainProcess == false) goto L6;
        CronetAppProviderManager.inst().handleApiResult(r38, r39, r40, r41, r42, r44, r46, r48, r50, r52, r54, r56, r58, r60, r62, r63, r65, r67, r68, r69, r70, r71, r72);
        return;
    }

    @Override // com.ttnet.org.chromium.net.TTEventListener
    public boolean handleApiSample(String r10, String r11) {
        return CronetAppProviderManager.inst().handleApiSample(r10, r11);
    }

    @Override // com.ttnet.org.chromium.net.TTEventListener
    public Map<String, String> onCallToAddSecurityFactor(String r10, Map<String, String> r11) {
        return CronetAppProviderManager.inst().onCallToAddSecurityFactor(r10, r11);
    }

    @Override // com.ttnet.org.chromium.net.TTEventListener
    public void onClientIPChanged(String r10) {
        if (this.isMainProcess == false) goto L6;
        CronetAppProviderManager.inst().onClientIPChanged(r10);
        return;
    }

    @Override // com.ttnet.org.chromium.net.TTEventListener
    public void onColdStartFinish() {
        if (this.isMainProcess == false) goto L6;
        CronetAppProviderManager.inst().onColdStartFinish();
        return;
    }

    @Override // com.ttnet.org.chromium.net.TTEventListener
    public void onContextInitCompleted(long r10, long r11, long r12, long r14, long r16, long r18, long r20, long r22, long r24, long r26, long r28, long r30, long r32, long r34, long r36, long r38) {
        if (this.enableOptInit == false) goto L5;
        TTNetInitMetrics.o(true);
    L5:
        TTNetInitMetrics r13 = TTNetInitMetrics.k();
        r13.f1526c = Process.getThreadPriority(0);
        r13.B = TTCronetInitTimingInfo.sInitThreadStart;
        r13.C = TTCronetInitTimingInfo.sInitThreadEnd;
        r13.D = TTCronetInitTimingInfo.sLoadCronetSoStart;
        r13.E = TTCronetInitTimingInfo.sLoadCronetSoEnd;
        r13.F = TTCronetInitTimingInfo.sNativeInitTimingJson;
        r13.H = TTCronetInitTimingInfo.sABTest;
        r13.G = System.nanoTime();
        r13.f1523J = r10;
        r13.K = r11;
        r13.L = r12;
        r13.I = r14;
        r13.M = r16;
        r13.N = r18;
        r13.O = r20;
        r13.P = r22;
        r13.Q = r24;
        r13.R = r26;
        r13.S = r28;
        r13.T = r30;
        r13.U = r32;
        r13.V = r34;
        r13.W = r36;
        r13.X = r38;
        final long r15 = CronetAppProviderManager.inst().getAppStartTime();
        if (TTNetInitMetrics.k().b() == true) goto L11;
        a.b().schedule(new AnonymousClass1(this, r15), 5, TimeUnit.SECONDS);
        if (this.enableOptInit == true) goto L16;
        TTNetInitMetrics.o(true);
        return;
    L16:
        return;
    L11:
        JSONObject r17 = TTNetInitMetrics.k().c();
        JSONObject r19 = TTNetInitMetrics.k().d(r15);
        if (this.enableOptInit == true) goto L14;
        TTNetInitMetrics.o(true);
    L14:
        CronetAppProviderManager.inst().sendAppMonitorEvent(r17.toString(), "ttnet_init");
        CronetAppProviderManager.inst().sendAppMonitorEvent(r19.toString(), "ttnet_init_v2");
    }

    @Override // com.ttnet.org.chromium.net.TTEventListener
    public void onCronetBootSucceed() {
        if (this.isMainProcess == false) goto L6;
        CronetAppProviderManager.inst().onCronetBootSucceed();
        return;
    }

    @Override // com.ttnet.org.chromium.net.TTEventListener
    public void onDropReasonChanged(boolean r10, List<Integer> r11) {
        if (this.isMainProcess == false) goto L6;
        CronetAppProviderManager.inst().onDropReasonChanged(r10, r11);
        return;
    }

    @Override // com.ttnet.org.chromium.net.TTEventListener
    public void onEffectiveConnectionTypeChanged(int r10) {
        CronetAppProviderManager.inst().onEffectiveConnectionTypeChanged(r10);
    }

    public void onMappingRequestStatus(String r10, int r11) {
        if (this.isMainProcess == false) goto L6;
        CronetAppProviderManager.inst().onMappingRequestStatus(r10, r11);
        return;
    }

    @Override // com.ttnet.org.chromium.net.TTEventListener
    public void onMultiNetStateChanged(int r10, int r11) {
        CronetAppProviderManager.inst().onMultiNetStateChanged(r10, r11);
    }

    @Override // com.ttnet.org.chromium.net.TTEventListener
    public void onMultiNetworkStateChanged(int r10, int r11) {
        CronetAppProviderManager.inst().onMultiNetworkStateChanged(r10, r11);
    }

    @Override // com.ttnet.org.chromium.net.TTEventListener
    public void onNetworkQualityLevelChanged(int r10) {
        CronetAppProviderManager.inst().onNetworkQualityLevelChanged(r10);
    }

    @Override // com.ttnet.org.chromium.net.TTEventListener
    public void onNetworkQualityRttAndThroughputNotified(int r10, int r11, int r12) {
        CronetAppProviderManager.inst().onNetworkQualityRttAndThroughputNotified(r10, r11, r12);
    }

    @Override // com.ttnet.org.chromium.net.TTEventListener
    public void onNetworkQualityTypeChangedV3(int r10) {
        CronetAppProviderManager.inst().onNetworkQualityTypeChangedV3(r10);
    }

    @Override // com.ttnet.org.chromium.net.TTEventListener
    public void onPacketLossComputed(int r11, double r12, double r14, double r16, double r18) {
        CronetAppProviderManager.inst().onPacketLossComputed(r11, r12, r14, r16, r18);
    }

    @Override // com.ttnet.org.chromium.net.TTEventListener
    public void onPublicIPsChanged(List<String> r10, List<String> r11) {
        if (this.isMainProcess == false) goto L6;
        CronetAppProviderManager.inst().onPublicIPsChanged(r10, r11);
        return;
    }

    @Override // com.ttnet.org.chromium.net.TTEventListener
    public void onRTTOrThroughputEstimatesComputed(int r10, int r11, int r12) {
        CronetAppProviderManager.inst().onRTTOrThroughputEstimatesComputed(r10, r11, r12);
    }

    @Override // com.ttnet.org.chromium.net.TTEventListener
    public String onRequestInterceptorToStart(String r10, Map<String, String> r11, List<String> r12) {
        return NativeRequestInterceptor.a(r10, r11, r12);
    }

    @Override // com.ttnet.org.chromium.net.TTEventListener
    public String onResponseInterceptorToStart(String r10, Map<String, List<String>> r11, int r12) {
        return NativeRequestInterceptor.b(r10, r11, r12);
    }

    @Override // com.ttnet.org.chromium.net.TTEventListener
    public void onServerConfigUpdated(String r10, String r11, String r12) {
        if (this.isMainProcess == false) goto L6;
        CronetAppProviderManager.inst().onServerConfigUpdated(r10, r11, r12);
        return;
    }

    @Override // com.ttnet.org.chromium.net.TTEventListener
    public void onStoreIdcChanged(String r10, String r11, String r12, String r13, String r14, String r15) {
        if (this.isMainProcess == false) goto L6;
        CronetAppProviderManager.inst().onStoreIdcChanged(r10, r11, r12, r13, r14, r15);
        return;
    }

    @Override // com.ttnet.org.chromium.net.TTEventListener
    public void onTLBDecompressFail() {
        TTRequestCompressManager.q();
    }

    @Override // com.ttnet.org.chromium.net.TTEventListener
    public void onTNCUpdateFailed(String[] r10, String r11) {
        if (this.isMainProcess == false) goto L6;
        CronetAppProviderManager.inst().onTNCUpdateFailed(r10, r11);
        return;
    }

    @Override // com.ttnet.org.chromium.net.TTEventListener
    public void onTTDnsResolveResult(String r10, String r11, int r12, int r13, int r14, List<String> r15, String r16) {
        CronetAppProviderManager.inst().onTTDnsResolveResult(r10, r11, r12, r13, r14, r15, r16);
    }

    @Override // com.ttnet.org.chromium.net.TTEventListener
    public void onTTNetDetectInfoChanged(String r10) {
        if (this.isMainProcess == false) goto L6;
        CronetAppProviderManager.inst().onTTNetDetectInfoChanged(r10);
        return;
    }

    @Override // com.ttnet.org.chromium.net.TTEventListener
    public void onUserSpecifiedNetworkEnabled(boolean r10) {
        CronetAppProviderManager.inst().onUserSpecifiedNetworkEnabled(r10);
    }

    public void setIsMainProcess(boolean r10) {
        this.isMainProcess = r10;
    }
}
