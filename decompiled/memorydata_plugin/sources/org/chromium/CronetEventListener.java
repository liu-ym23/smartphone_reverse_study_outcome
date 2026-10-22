package org.chromium;

import android.os.Process;
import com.bytedance.common.utility.a.a;
import com.bytedance.frameworks.baselib.network.TTNetInitMetrics;
import com.bytedance.frameworks.baselib.network.http.NativeRequestInterceptor;
import com.bytedance.retrofit2.mime.TTRequestCompressManager;
import com.ttnet.org.chromium.net.TTEventListener;
import com.ttnet.org.chromium.net.impl.TTCronetInitTimingInfo;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
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

    public void enableOptInit(boolean r1) {
        this.enableOptInit = r1;
    }

    @Override // com.ttnet.org.chromium.net.TTEventListener
    public Map<String, String> onCallToAddSecurityFactor(String r2, Map<String, String> r3) {
        Map<String, String> r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        return CronetAppProviderManager.inst().onCallToAddSecurityFactor(r2, r1);
    }

    @Override // com.ttnet.org.chromium.net.TTEventListener
    public void onClientIPChanged(String r1) {
        if (this.isMainProcess == false) goto L6;
        CronetAppProviderManager.inst().onClientIPChanged(r1);
        return;
    }

    @Override // com.ttnet.org.chromium.net.TTEventListener
    public void onColdStartFinish() {
        if (this.isMainProcess == false) goto L6;
        CronetAppProviderManager.inst().onColdStartFinish();
        return;
    }

    @Override // com.ttnet.org.chromium.net.TTEventListener
    public void onContextInitCompleted(long r8, long r10, long r12, long r14, long r16, long r18, long r20, long r22, long r24, long r26, long r28, long r30, long r32, long r34, long r36, long r38) {
        if (this.enableOptInit == false) goto L5;
        TTNetInitMetrics.a(true);
    L5:
        TTNetInitMetrics r1 = TTNetInitMetrics.c();
        r1.d = Process.getThreadPriority(0);
        r1.G = TTCronetInitTimingInfo.sInitThreadStart;
        r1.H = TTCronetInitTimingInfo.sInitThreadEnd;
        r1.I = TTCronetInitTimingInfo.sLoadCronetSoStart;
        r1.f2271J = TTCronetInitTimingInfo.sLoadCronetSoEnd;
        r1.K = TTCronetInitTimingInfo.sNativeInitTimingJson;
        r1.M = TTCronetInitTimingInfo.sABTest;
        r1.L = System.nanoTime();
        r1.O = r8;
        r1.P = r10;
        r1.Q = r12;
        r1.N = r14;
        r1.R = r16;
        r1.S = r18;
        r1.T = r20;
        r1.U = r22;
        r1.V = r24;
        r1.W = r26;
        r1.X = r28;
        r1.Y = r30;
        r1.Z = r32;
        r1.aa = r34;
        r1.ab = r36;
        r1.ac = r38;
        final long r3 = CronetAppProviderManager.inst().getAppStartTime();
        if (TTNetInitMetrics.c().e() == true) goto L11;
        a.b().schedule(new AnonymousClass1(this, r3), 5, TimeUnit.SECONDS);
        if (this.enableOptInit == true) goto L16;
        TTNetInitMetrics.a(true);
        return;
    L16:
        return;
    L11:
        JSONObject r2 = TTNetInitMetrics.c().d();
        JSONObject r4 = TTNetInitMetrics.c().a(r3);
        if (this.enableOptInit == true) goto L14;
        TTNetInitMetrics.a(true);
    L14:
        CronetAppProviderManager.inst().sendAppMonitorEvent(r2.toString(), "ttnet_init");
        CronetAppProviderManager.inst().sendAppMonitorEvent(r4.toString(), "ttnet_init_v2");
    }

    @Override // com.ttnet.org.chromium.net.TTEventListener
    public void onCronetBootSucceed() {
        if (this.isMainProcess == false) goto L6;
        CronetAppProviderManager.inst().onCronetBootSucceed();
        return;
    }

    @Override // com.ttnet.org.chromium.net.TTEventListener
    public void onDropReasonChanged(boolean r3, List<Integer> r4) {
        List<Integer> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        if (this.isMainProcess == false) goto L6;
        CronetAppProviderManager.inst().onDropReasonChanged(r3, r5);
        return;
    }

    @Override // com.ttnet.org.chromium.net.TTEventListener
    public void onEffectiveConnectionTypeChanged(int r1) {
        CronetAppProviderManager.inst().onEffectiveConnectionTypeChanged(r1);
    }

    public void onMappingRequestStatus(String r1, int r2) {
        if (this.isMainProcess == false) goto L6;
        CronetAppProviderManager.inst().onMappingRequestStatus(r1, r2);
        return;
    }

    @Override // com.ttnet.org.chromium.net.TTEventListener
    public void onMultiNetworkStateChanged(int r1, int r2) {
        CronetAppProviderManager.inst().onMultiNetworkStateChanged(r1, r2);
    }

    @Override // com.ttnet.org.chromium.net.TTEventListener
    public void onNetworkQualityLevelChanged(int r1) {
        CronetAppProviderManager.inst().onNetworkQualityLevelChanged(r1);
    }

    @Override // com.ttnet.org.chromium.net.TTEventListener
    public void onNetworkQualityRttAndThroughputNotified(int r1, int r2, int r3) {
        CronetAppProviderManager.inst().onNetworkQualityRttAndThroughputNotified(r1, r2, r3);
    }

    @Override // com.ttnet.org.chromium.net.TTEventListener
    public void onNetworkQualityTypeChangedV3(int r1) {
        CronetAppProviderManager.inst().onNetworkQualityTypeChangedV3(r1);
    }

    @Override // com.ttnet.org.chromium.net.TTEventListener
    public void onPacketLossComputed(int r11, double r12, double r14, double r16, double r18) {
        CronetAppProviderManager.inst().onPacketLossComputed(r11, r12, r14, r16, r18);
    }

    @Override // com.ttnet.org.chromium.net.TTEventListener
    public void onPublicIPsChanged(List<String> r3, List<String> r4) {
        List<String> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        List<String> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        if (this.isMainProcess == false) goto L6;
        CronetAppProviderManager.inst().onPublicIPsChanged(r5, r6);
        return;
    }

    @Override // com.ttnet.org.chromium.net.TTEventListener
    public void onRTTOrThroughputEstimatesComputed(int r1, int r2, int r3) {
        CronetAppProviderManager.inst().onRTTOrThroughputEstimatesComputed(r1, r2, r3);
    }

    @Override // com.ttnet.org.chromium.net.TTEventListener
    public String onRequestInterceptorJava(String r2, Map<String, String> r3) {
        return com.bytedance.frameworks.baselib.network.http.cronet.a.a(r2, (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.ttnet.org.chromium.net.TTEventListener
    public String onRequestInterceptorToStart(String r2, Map<String, String> r3, List<String> r4) {
        return NativeRequestInterceptor.a(r2, (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin"), (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.ttnet.org.chromium.net.TTEventListener
    public String onResponseInterceptorToStart(String r2, Map<String, List<String>> r3, int r4) {
        return NativeRequestInterceptor.a(r2, (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin"), r4);
    }

    @Override // com.ttnet.org.chromium.net.TTEventListener
    public void onServerConfigUpdated(String r1, String r2, String r3) {
        if (this.isMainProcess == false) goto L6;
        CronetAppProviderManager.inst().onServerConfigUpdated(r1, r2, r3);
        return;
    }

    @Override // com.ttnet.org.chromium.net.TTEventListener
    public void onStoreIdcChanged(String r8, String r9, String r10, String r11, String r12, String r13) {
        if (this.isMainProcess == false) goto L6;
        CronetAppProviderManager.inst().onStoreIdcChanged(r8, r9, r10, r11, r12, r13);
        return;
    }

    @Override // com.ttnet.org.chromium.net.TTEventListener
    public void onTLBDecompressFail() {
        TTRequestCompressManager.setGlobalForbidenCompress();
    }

    @Override // com.ttnet.org.chromium.net.TTEventListener
    public void onTNCUpdateFailed(String[] r1, String r2) {
        if (this.isMainProcess == false) goto L6;
        CronetAppProviderManager.inst().onTNCUpdateFailed(r1, r2);
        return;
    }

    @Override // com.ttnet.org.chromium.net.TTEventListener
    public void onTTDnsResolveResult(String r9, String r10, int r11, int r12, int r13, List<String> r14, String r15) {
        List<String> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r14, List.class, "com.obric.memorydata.plugin");
        CronetAppProviderManager.inst().onTTDnsResolveResult(r9, r10, r11, r12, r13, r6, r15);
    }

    @Override // com.ttnet.org.chromium.net.TTEventListener
    public void onTTNetDetectInfoChanged(String r1) {
        if (this.isMainProcess == false) goto L6;
        CronetAppProviderManager.inst().onTTNetDetectInfoChanged(r1);
        return;
    }

    @Override // com.ttnet.org.chromium.net.TTEventListener
    public void onTncRequestSucceeded(boolean r1, boolean r2, int r3) {
        CronetAppProviderManager.inst().onTncRequestSucceeded(r1, r2, r3);
    }

    @Override // com.ttnet.org.chromium.net.TTEventListener
    public void onUserSpecifiedNetworkEnabled(boolean r1) {
        CronetAppProviderManager.inst().onUserSpecifiedNetworkEnabled(r1);
    }

    @Override // com.ttnet.org.chromium.net.TTEventListener
    public void onWiFiToCellStateChanged(int r1, int r2) {
        CronetAppProviderManager.inst().onWiFiToCellStateChanged(r1, r2);
    }

    public void setIsMainProcess(boolean r1) {
        this.isMainProcess = r1;
    }
}
