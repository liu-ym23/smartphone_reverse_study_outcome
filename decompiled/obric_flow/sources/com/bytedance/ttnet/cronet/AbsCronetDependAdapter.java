package com.bytedance.ttnet.cronet;

import ai.j0;
import android.os.Build;
import android.util.Pair;
import androidx.constraintlayout.motion.widget.a;
import com.bytedance.common.utility.Logger;
import com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider;
import com.bytedance.frameworks.baselib.network.http.cronet.ICronetDepend;
import com.bytedance.frameworks.baselib.network.http.util.b;
import com.bytedance.ttnet.TTNetInit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import s9.h;
import sj.d;
import tj.c;
import tj.e;
import tj.f;
import tj.g;
import tj.i;
import tj.j;
import tj.k;
import tj.l;
import tj.m;
import tj.n;
import tj.o;

/* JADX INFO: loaded from: classes2.dex */
public abstract class AbsCronetDependAdapter implements ICronetDepend, ICronetAppProvider {
    public AbsCronetDependAdapter() {
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public void doLoadLibrary(String r5) {
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getAbClient() {
        return "";
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getAbFeature() {
        return "";
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getAbFlag() {
        return "-1";
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getAbVersion() {
        return "";
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getAbi() {
        return Build.SUPPORTED_ABIS[0];
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getAppId() {
        return "-1";
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getAppName() {
        return "";
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getBypassBOEJSON() {
        return null;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getCarrierRegion() {
        return "";
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getChannel() {
        return "";
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getCityName() {
        return "";
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public Map<String[], Pair<byte[], byte[]>> getClientOpaqueData() {
        return null;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getCronetSoPath() {
        TTNetInit.getTTNetDepend();
        throw null;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getDPI() {
        TTNetInit.getTTNetDepend();
        throw null;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getDeviceBrand() {
        return Build.BRAND;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getDeviceId() {
        return "";
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getDeviceModel() {
        return Build.MODEL;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getDevicePlatform() {
        return "android";
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getDeviceType() {
        return Build.MODEL;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getGetDomainDefaultJSON() {
        return null;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public Map<String, String> getGetDomainDependHostMap() {
        new LinkedHashMap();
        TTNetInit.getTTNetDepend();
        throw null;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getHttpDnsRequestFlags() {
        return "0";
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getIId() {
        return "";
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getLanguage() {
        return "";
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getManifestVersionCode() {
        return "-1";
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getNetAccessType() {
        TTNetInit.getTTNetDepend();
        throw null;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getOSApi() {
        return String.valueOf(Build.VERSION.SDK_INT);
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getOSVersion() {
        String r5 = Build.VERSION.RELEASE;     // Catch: Exception -> L8
        if (r5 != null) goto L5;
        return r5;
    L5:
        if (r5.length() <= 10) goto L13;
        return r5.substring(0, 10);
    L13:
        return r5;
    L8:
        return "";
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public ArrayList<byte[]> getOpaqueData() {
        return null;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getOpenUdid() {
        return "";
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public final int getProcessFlag() {
        return b.f4692a.get();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public Map<String, Pair<Integer, Integer>> getQuicHint() {
        return null;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getRegion() {
        return "";
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getResolution() {
        TTNetInit.getTTNetDepend();
        throw null;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getRticket() {
        return String.valueOf(System.currentTimeMillis());
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getSdkAppId() {
        return "";
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getSdkVersion() {
        return "";
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetDepend
    public String getSsCookieKey() {
        return "X-SS-Cookie";
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getSsmix() {
        return "a";
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getStoreIdc() {
        return "";
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getStoreIdcRuleJSON() {
        return null;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getSysRegion() {
        return "";
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getTNCRequestFlags() {
        return "0";
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public Map<String, String> getTNCRequestHeader() {
        return null;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public Map<String, String> getTNCRequestQuery() {
        TTNetInit.getTTNetDepend();
        return null;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getUUID() {
        return "";
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getUpdateVersionCode() {
        return "-1";
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getUserId() {
        return "";
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getVersionCode() {
        return "-1";
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getVersionName() {
        return "";
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public void handleApiResult(boolean r10, String r11, String r12, String r13, long r14, long r15, long r16, long r17, long r19, long r21, long r23, long r25, long r27, long r29, boolean r31, long r32, long r34, String r36, String r37, String r38, Exception r39) {
        if (Logger.debug() == false) goto L5;
        StringBuilder r5 = new StringBuilder("handleApiResult, succ: ");
        r5.append(r10);
        r5.append(" url: ");
        r5.append(r11);
        r5.append("tracecode: ");
        a.C(r5, r12, " remoteIp: ", r13, " appStart: ");
        r5.append(r14);
        Logger.d("CronetDependAdapter", r5.toString());
    L5:
        s9.b r18 = s9.b.f21857y.mo98create();
        r18.f21858a = r13;
        r18.f21860c = r21;
        r18.d = r23;
        r18.e = r25;
        r18.f = r27;
        r18.g = r29;
        r18.f21861h = r31;
        r18.f21862i = r32;
        r18.f21863j = r19 - r15;
        r18.f21865l = r34;
        r18.f21868o = r36;
        r18.f21871r = r37;
        r18.s = r38;
        r18.f21866m = 0;
        if (r10 == false) goto L8;
        d r20 = h.f21879a;
        return;
    L8:
        d r22 = h.f21879a;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public boolean isBOEProxyEnabled() {
        return false;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public boolean isEnableBrotli() {
        return false;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public boolean isEnableHttp2() {
        return true;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public boolean isEnableQuic() {
        return false;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetDepend
    public void loggerD(String r5, String r10) {
        Logger.d(r5, r10);
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetDepend
    public boolean loggerDebug() {
        return Logger.debug();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public boolean needCustomLoadLibrary() {
        return false;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public Map<String, String> onCallToAddSecurityFactor(String r5, Map<String, String> r10) {
        HashMap r11 = new HashMap();
        Iterator<Map.Entry<String, String>> r12 = r10.entrySet().iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        Map.Entry<String, String> r13 = r12.next();
        ArrayList r14 = new ArrayList();
        r14.add(r13.getValue());
        r11.put(r13.getKey(), r14);
        goto L4
    L6:
        d r15 = h.f21879a;
        return null;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public final void onClientIPChanged(String r5) {
        if (Logger.debug() == false) goto L5;
        Logger.d("CronetDependAdapter", "onClientIPChanged");
    L5:
        new tj.b(r5).a();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public final void onColdStartFinish() {
        if (Logger.debug() == false) goto L5;
        Logger.d("CronetDependAdapter", "onColdStartFinish");
    L5:
        new tj.a().a();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public void onCronetBootSucceed() {
        if (Logger.debug() == false) goto L5;
        Logger.d("CronetDependAdapter", "onCronetBootSucceed... ");
    L5:
        new f().a();
    }

    public void onCronetMappingRequestStatus(String r5, int r10) {
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public void onEffectiveConnectionTypeChanged(int r5) {
        if (Logger.debug() == false) goto L5;
        Logger.d("CronetDependAdapter", "onEffectiveConnectionTypeChanged state = " + r5);
    L5:
        new m(this, r5).a();
    }

    public final void onMappingRequestStatus(String r5, int r10) {
        if (Logger.debug() == false) goto L5;
        Logger.d("CronetDependAdapter", "onMappingRequestStatus key = " + r5 + " status: " + r10);
    L5:
        new l(this, r5, r10).a();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public void onMultiNetworkStateChanged(int r5, int r10) {
        if (Logger.debug() == false) goto L6;
        Logger.d("CronetDependAdapter", "onMultiNetworkStateChanged prev state = " + r5 + ", curr state = " + r10);
        return;
    }

    public void onNQEEffectiveConnectionTypeChanged(int r5) {
    }

    public void onNQEPacketLossComputed(int r5, double r10, double r11, double r12, double r13) {
    }

    public void onNQERTTOrThroughputComputed(int r5, int r10, int r11) {
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public void onNetworkQualityLevelChanged(int r5) {
        if (Logger.debug() == false) goto L6;
        Logger.d("CronetDependAdapter", "onNetworkQualityLevelChanged nql: " + r5);
        return;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public void onNetworkQualityRttAndThroughputNotified(int r5, int r10, int r11) {
        if (Logger.debug() == false) goto L6;
        StringBuilder r12 = j0.v("onNetworkQualityLevelChanged, effectiveHrttMs: ", r5, r10, ", effectiveTrttMs: ", ", effectiveRxThroughputKbps: ");
        r12.append(r11);
        Logger.d("CronetDependAdapter", r12.toString());
        return;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public void onPacketLossComputed(int r14, double r15, double r17, double r19, double r21) {
        if (Logger.debug() == false) goto L6;
        Logger.d("CronetDependAdapter", "onPacketLossComputed protocol = " + r14 + ", upstreamLossRate = " + r15 + ", upstreamLossRateVariance = " + r17 + ", downstreamLossRate = " + r19 + ", downstreamLossRateVariance = " + r21);
    L6:
        new o(this, r14, r15, r17, r19, r21).a();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public void onPublicIPsChanged(List<String> r5, List<String> r10) {
        if (Logger.debug() == false) goto L5;
        Logger.d("CronetDependAdapter", "onPublicIPsChanged");
    L5:
        new c(r5, r10).a();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public void onRTTOrThroughputEstimatesComputed(int r5, int r10, int r11) {
        if (Logger.debug() == false) goto L5;
        StringBuilder r12 = j0.v("onRTTOrThroughputEstimatesComputed httpRtt = ", r5, r10, ", transportRttMs = ", ",downstreamThroughputKbps = ");
        r12.append(r11);
        Logger.d("CronetDependAdapter", r12.toString());
    L5:
        new n(this, r5, r10, r11).a();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public void onServerConfigABTestChanged(String r5) {
        new tj.h().a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public void onServerConfigEtagChanged(String r5) {
        new g().a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public void onServerConfigUpdated(String r5) {
    L6:
        th = move-exception;
        th.printStackTrace();
        return;
    L4:
        if (Logger.debug() == false) goto L8;
        Logger.d("CronetDependAdapter", "config = " + r5);     // Catch: Throwable -> L6
    L8:
        new i().a();     // Catch: Throwable -> L6
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public final void onStoreIdcChanged(String r5, String r10, String r11) {
        if (Logger.debug() == false) goto L5;
        Logger.d("CronetDependAdapter", "onStoreIdcChanged");
    L5:
        new tj.d(r5, r10, r11).a();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public final void onTNCUpdateFailed(ArrayList<String> r5, String r10) {
        if (Logger.debug() == false) goto L5;
        Logger.d("CronetDependAdapter", "onTNCUpdateFailed");
    L5:
        new e(r10, r5).a();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public final void onTTDnsResolveResult(String r11, String r12, int r13, int r14, int r15, List<String> r16, String r17) {
        if (Logger.debug() == false) goto L6;
        Logger.d("CronetDependAdapter", "onTTDnsResolveResult uuid = " + r11 + " host = " + r12);
    L6:
        new j(r11, r12, r13, r14, r15, r16, r17).a();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public final void onTTNetDetectInfoChanged(String r5) {
        if (Logger.debug() == false) goto L5;
        kotlin.collections.a.n("onTTNetDetectInfoChanged result = ", r5, "CronetDependAdapter");
    L5:
        new k(this, r5).a();
    }

    public void onTTNetDetectResult(String r5) {
    }

    public void onTTNetworkStateChanged(int r5) {
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public void sendAppMonitorEvent(String r5, String r10) {
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetDepend
    public void setAdapter(ICronetDepend r5) {
    }

    public final void tryStartTTNetDetect(List<String> r5, int r10, int r11) {
    }
}
