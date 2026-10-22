package org.chromium;

import android.util.Pair;
import com.ttnet.org.chromium.base.Reflect;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class CronetAppProviderManager {
    private static final String ADAPTER_CLASS_NAME = "com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider";
    private static volatile CronetAppProviderManager sCronetAppProviderManager;
    private Object mCronetAppProviderAdapter;

    private CronetAppProviderManager() {
    }

    private String getStringAttribute(String r10) {
        Object r11 = this.mCronetAppProviderAdapter;     // Catch: Throwable -> L8
        if (r11 != null) goto L6;
        return "";
    L6:
        return (String) Reflect.on(r11).call(r10).get();
    L8:
        th = move-exception;
        th.printStackTrace();
        return "";
    }

    public static CronetAppProviderManager inst() {
        if (sCronetAppProviderManager != null) goto L15;
        monitor-enter(CronetAppProviderManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sCronetAppProviderManager != null) goto L9;
        sCronetAppProviderManager = new CronetAppProviderManager();     // Catch: Throwable -> L11
    L9:
        monitor-exit(CronetAppProviderManager.class);     // Catch: Throwable -> L11
    L15:
        return sCronetAppProviderManager;
    }

    public void doLoadLibrary(String r10) {
        Object r11 = this.mCronetAppProviderAdapter;     // Catch: Throwable -> L7
        if (r11 != null) goto L5;
        return;
    L5:
        Reflect.on(r11).call("doLoadLibrary", new Class[]{String.class}, new Object[]{r10});     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        th.printStackTrace();
    }

    public List<String> getAbSdkVersion() {
        Object r10 = this.mCronetAppProviderAdapter;     // Catch: Throwable -> L8
        if (r10 != null) goto L6;
        return null;
    L6:
        return (List) Reflect.on(r10).call("getAbSdkVersion").get();
    L8:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    public String getAbi() {
        return getStringAttribute("getAbi");
    }

    public String getAppId() {
        return getStringAttribute("getAppId");
    }

    public String getAppName() {
        return getStringAttribute("getAppName");
    }

    public long getAppStartTime() {
        Object r10 = this.mCronetAppProviderAdapter;     // Catch: Throwable -> L8
        if (r10 != null) goto L6;
        return -1;
    L6:
        return ((Long) Reflect.on(r10).call("getAppStartTime").get()).longValue();
    L8:
        th = move-exception;
        th.printStackTrace();
        return -1;
    }

    public String getBypassBOEJSON() {
        Object r10 = this.mCronetAppProviderAdapter;     // Catch: Throwable -> L8
        if (r10 != null) goto L6;
        return null;
    L6:
        return (String) Reflect.on(r10).call("getBypassBOEJSON").get();
    L8:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    public String getCarrierRegion() {
        return getStringAttribute("getCarrierRegion");
    }

    public String getChannel() {
        return getStringAttribute("getChannel");
    }

    public Map<String[], Pair<byte[], byte[]>> getClientOpaqueData() {
        Object r10 = this.mCronetAppProviderAdapter;     // Catch: Throwable -> L8
        if (r10 != null) goto L6;
        return null;
    L6:
        return (Map) Reflect.on(r10).call("getClientOpaqueData").get();
    L8:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    public String getCronetSoPath() {
        Object r10 = this.mCronetAppProviderAdapter;     // Catch: Throwable -> L8
        if (r10 != null) goto L6;
        return null;
    L6:
        return (String) Reflect.on(r10).call("getCronetSoPath").get();
    L8:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    public String getDeviceBrand() {
        return getStringAttribute("getDeviceBrand");
    }

    public String getDeviceId() {
        return getStringAttribute("getDeviceId");
    }

    public String getDeviceModel() {
        return getStringAttribute("getDeviceModel");
    }

    public String getDevicePlatform() {
        return getStringAttribute("getDevicePlatform");
    }

    public String getDeviceType() {
        return getStringAttribute("getDeviceType");
    }

    public String getGetDomainDefaultJSON() {
        Object r10 = this.mCronetAppProviderAdapter;     // Catch: Throwable -> L8
        if (r10 != null) goto L6;
        return null;
    L6:
        return (String) Reflect.on(r10).call("getGetDomainDefaultJSON").get();
    L8:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    public Map<String, String> getGetDomainDependHostMap() {
        Object r10 = this.mCronetAppProviderAdapter;     // Catch: Throwable -> L8
        if (r10 != null) goto L7;
        return Collections.emptyMap();
    L7:
        return (Map) Reflect.on(r10).call("getGetDomainDependHostMap").get();
    L8:
        th = move-exception;
        th.printStackTrace();
        return Collections.emptyMap();
    }

    public String getHttpDnsRequestFlags() {
        return getStringAttribute("getHttpDnsRequestFlags");
    }

    public String getInitRegion() {
        return getStringAttribute("getAppInitialRegionInfo");
    }

    public String getIsDropFirstTnc() {
        Object r10 = this.mCronetAppProviderAdapter;     // Catch: Throwable -> L8
        if (r10 != null) goto L6;
        return null;
    L6:
        return (String) Reflect.on(r10).call("getIsDropFirstTnc").get();
    L8:
        th = move-exception;
        th.printStackTrace();
        return "";
    }

    public String getManifestVersionCode() {
        return getStringAttribute("getManifestVersionCode");
    }

    public String getNetAccessType() {
        return getStringAttribute("getNetAccessType");
    }

    public String getNetworkOperator() {
        Object r10 = this.mCronetAppProviderAdapter;     // Catch: Throwable -> L8
        if (r10 != null) goto L6;
        return "";
    L6:
        return (String) Reflect.on(r10).call("getNetworkOperator").get();
    L8:
        th = move-exception;
        th.printStackTrace();
        return "";
    }

    public String getOSApi() {
        return getStringAttribute("getOSApi");
    }

    public String getOSVersion() {
        return getStringAttribute("getOSVersion");
    }

    public ArrayList<byte[]> getOpaqueData() {
        Object r10 = this.mCronetAppProviderAdapter;     // Catch: Throwable -> L8
        if (r10 != null) goto L6;
        return null;
    L6:
        return (ArrayList) Reflect.on(r10).call("getOpaqueData").get();
    L8:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    public boolean getOptInit() {
        Object r10 = this.mCronetAppProviderAdapter;     // Catch: Throwable -> L8
        if (r10 != null) goto L6;
        return false;
    L6:
        return ((Boolean) Reflect.on(r10).call("getOptInit").get()).booleanValue();
    L8:
        th = move-exception;
        th.printStackTrace();
        return false;
    }

    public int getProcessFlag() {
        Object r10 = this.mCronetAppProviderAdapter;     // Catch: Throwable -> L8
        if (r10 != null) goto L6;
        return 0;
    L6:
        return ((Integer) Reflect.on(r10).call("getProcessFlag").get()).intValue();
    L8:
        th = move-exception;
        th.printStackTrace();
        return 0;
    }

    public Map<String, Pair<Integer, Integer>> getQuicHint() {
        Object r10 = this.mCronetAppProviderAdapter;     // Catch: Throwable -> L8
        if (r10 != null) goto L6;
        return null;
    L6:
        return (Map) Reflect.on(r10).call("getQuicHint").get();
    L8:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    public String getRegion() {
        return getStringAttribute("getRegion");
    }

    public String getSdkAppId() {
        return getStringAttribute("getSdkAppId");
    }

    public String getSdkVersion() {
        return getStringAttribute("getSdkVersion");
    }

    public String getSimOperator() {
        Object r10 = this.mCronetAppProviderAdapter;     // Catch: Throwable -> L8
        if (r10 != null) goto L6;
        return "";
    L6:
        return (String) Reflect.on(r10).call("getSimOperator").get();
    L8:
        th = move-exception;
        th.printStackTrace();
        return "";
    }

    public String getStoreIdc() {
        return getStringAttribute("getStoreIdc");
    }

    public String getStoreIdcRuleJSON() {
        Object r10 = this.mCronetAppProviderAdapter;     // Catch: Throwable -> L8
        if (r10 != null) goto L6;
        return null;
    L6:
        return (String) Reflect.on(r10).call("getStoreIdcRuleJSON").get();
    L8:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    public String getSysRegion() {
        return getStringAttribute("getSysRegion");
    }

    public String getTNCRequestFlags() {
        return getStringAttribute("getTNCRequestFlags");
    }

    public Map<String, String> getTNCRequestHeader() {
        Object r10 = this.mCronetAppProviderAdapter;     // Catch: Throwable -> L8
        if (r10 != null) goto L6;
        return null;
    L6:
        return (Map) Reflect.on(r10).call("getTNCRequestHeader").get();
    L8:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    public Map<String, String> getTNCRequestQuery() {
        Object r10 = this.mCronetAppProviderAdapter;     // Catch: Throwable -> L8
        if (r10 != null) goto L6;
        return null;
    L6:
        return (Map) Reflect.on(r10).call("getTNCRequestQuery").get();
    L8:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    public String getUpdateVersionCode() {
        return getStringAttribute("getUpdateVersionCode");
    }

    public String getUserId() {
        return getStringAttribute("getUserId");
    }

    public String getVersionCode() {
        return getStringAttribute("getVersionCode");
    }

    public String getVersionName() {
        return getStringAttribute("getVersionName");
    }

    public int getWifiFrequency() {
        Object r10 = this.mCronetAppProviderAdapter;     // Catch: Throwable -> L8
        if (r10 != null) goto L6;
        return 0;
    L6:
        return ((Integer) Reflect.on(r10).call("getWifiFrequency").get()).intValue();
    L8:
        th = move-exception;
        th.printStackTrace();
        return 0;
    }

    public int getWifiRssi() {
        Object r10 = this.mCronetAppProviderAdapter;     // Catch: Throwable -> L8
        if (r10 != null) goto L6;
        return 0;
    L6:
        return ((Integer) Reflect.on(r10).call("getWifiRssi").get()).intValue();
    L8:
        th = move-exception;
        th.printStackTrace();
        return 0;
    }

    public void handleApiResult(boolean r28, String r29, String r30, String r31, long r32, long r34, long r36, long r38, long r40, long r42, long r44, long r46, long r48, long r50, boolean r52, long r53, long r55, String r57, String r58, String r59, int r60, int r61, String r62) {
        if (CronetDependManager.inst().loggerDebug() == false) goto L16;
        CronetDependManager.inst().loggerD("CronetAppProviderManager", "handleApiResult ");
    L16:
    L13:
        th = move-exception;
        th.printStackTrace();
        return;
    L6:
        if (this.mCronetAppProviderAdapter != null) goto L8;
        return;
    L8:
        IOException r10 = null;
        if (r28 == true) goto L11;
        r10 = Utils.tryConvertCronetException(Utils.createCronetException(r60, r61, r62));     // Catch: Throwable -> L13
    L11:
        Reflect r11 = Reflect.on(this.mCronetAppProviderAdapter);     // Catch: Throwable -> L13
        Class<?> r12 = Boolean.TYPE;     // Catch: Throwable -> L13
        Class<?> r13 = Long.TYPE;     // Catch: Throwable -> L13
        r11.call("handleApiResult", new Class[]{r12, String.class, String.class, String.class, r13, r13, r13, r13, r13, r13, r13, r13, r13, r13, r12, r13, r13, String.class, String.class, String.class, Exception.class}, new Object[]{Boolean.valueOf(r28), r29, r30, r31, Long.valueOf(r32), Long.valueOf(r34), Long.valueOf(r36), Long.valueOf(r38), Long.valueOf(r40), Long.valueOf(r42), Long.valueOf(r44), Long.valueOf(r46), Long.valueOf(r48), Long.valueOf(r50), Boolean.valueOf(r52), Long.valueOf(r53), Long.valueOf(r55), r57, r58, r59, r10});     // Catch: Throwable -> L13
    }

    public boolean handleApiSample(String r10, String r11) {
        if (CronetDependManager.inst().loggerDebug() == false) goto L14;
        CronetDependManager.inst().loggerD("CronetAppProviderManager", "handleApiSample");
    L14:
        Object r12 = this.mCronetAppProviderAdapter;     // Catch: Throwable -> L11
        if (r12 != null) goto L9;
        return false;
    L9:
        return ((Boolean) Reflect.on(r12).call("handleApiSample", new Class[]{String.class, String.class}, new Object[]{r10, r11}).get()).booleanValue();
    L11:
        th = move-exception;
        th.printStackTrace();
        return false;
    }

    public boolean isBOEProxyEnabled() {
        Object r10 = this.mCronetAppProviderAdapter;     // Catch: Throwable -> L8
        if (r10 != null) goto L6;
        return false;
    L6:
        return ((Boolean) Reflect.on(r10).call("isBOEProxyEnabled").get()).booleanValue();
    L8:
        th = move-exception;
        th.printStackTrace();
        return false;
    }

    public boolean isEnableBrotli() {
        Object r10 = this.mCronetAppProviderAdapter;     // Catch: Throwable -> L8
        if (r10 != null) goto L6;
        return false;
    L6:
        return ((Boolean) Reflect.on(r10).call("isEnableBrotli").get()).booleanValue();
    L8:
        th = move-exception;
        th.printStackTrace();
        return false;
    }

    public boolean isEnableHttp2() {
        Object r10 = this.mCronetAppProviderAdapter;     // Catch: Throwable -> L8
        if (r10 != null) goto L6;
        return false;
    L6:
        return ((Boolean) Reflect.on(r10).call("isEnableHttp2").get()).booleanValue();
    L8:
        th = move-exception;
        th.printStackTrace();
        return false;
    }

    public boolean isEnableQuic() {
        Object r10 = this.mCronetAppProviderAdapter;     // Catch: Throwable -> L8
        if (r10 != null) goto L6;
        return false;
    L6:
        return ((Boolean) Reflect.on(r10).call("isEnableQuic").get()).booleanValue();
    L8:
        th = move-exception;
        th.printStackTrace();
        return false;
    }

    public boolean needCustomLoadLibrary() {
        Object r10 = this.mCronetAppProviderAdapter;     // Catch: Throwable -> L8
        if (r10 != null) goto L6;
        return false;
    L6:
        return ((Boolean) Reflect.on(r10).call("needCustomLoadLibrary").get()).booleanValue();
    L8:
        th = move-exception;
        th.printStackTrace();
        return false;
    }

    public Map<String, String> onCallToAddSecurityFactor(String r10, Map<String, String> r11) {
        if (CronetDependManager.inst().loggerDebug() == false) goto L14;
        CronetDependManager.inst().loggerD("CronetAppProviderManager", "onCallToAddSecurityFactor info url = " + r10);
    L14:
        Object r12 = this.mCronetAppProviderAdapter;     // Catch: Throwable -> L11
        if (r12 != null) goto L9;
        return null;
    L9:
        return (Map) Reflect.on(r12).call("onCallToAddSecurityFactor", new Class[]{String.class, Map.class}, new Object[]{r10, r11}).get();
    L11:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    public void onClientIPChanged(String r10) {
        if (CronetDependManager.inst().loggerDebug() == false) goto L13;
        CronetDependManager.inst().loggerD("CronetAppProviderManager", "onClientIPChanged ");
    L13:
        Object r11 = this.mCronetAppProviderAdapter;     // Catch: Throwable -> L10
        if (r11 != null) goto L8;
        return;
    L8:
        Reflect.on(r11).call("onClientIPChanged", new Class[]{String.class}, new Object[]{r10});     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        th.printStackTrace();
    }

    public void onColdStartFinish() {
        if (CronetDependManager.inst().loggerDebug() == false) goto L13;
        CronetDependManager.inst().loggerD("CronetAppProviderManager", "onColdStartFinish ");
    L13:
        Object r10 = this.mCronetAppProviderAdapter;     // Catch: Throwable -> L10
        if (r10 != null) goto L8;
        return;
    L8:
        Reflect.on(r10).call("onColdStartFinish");     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        th.printStackTrace();
    }

    public void onCronetBootSucceed() {
        if (CronetDependManager.inst().loggerDebug() == false) goto L13;
        CronetDependManager.inst().loggerD("CronetAppProviderManager", "onCronetBootSucceed ");
    L13:
        Object r10 = this.mCronetAppProviderAdapter;     // Catch: Throwable -> L10
        if (r10 != null) goto L8;
        return;
    L8:
        Reflect.on(r10).call("onCronetBootSucceed");     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        th.printStackTrace();
    }

    public void onDropReasonChanged(boolean r10, List<Integer> r11) {
        if (CronetDependManager.inst().loggerDebug() == false) goto L13;
        CronetDependManager.inst().loggerD("CronetAppProviderManager", "onDropReasonChanged " + r10 + ", Drop Reason List " + r11);
    L13:
        Object r12 = this.mCronetAppProviderAdapter;     // Catch: Throwable -> L10
        if (r12 != null) goto L8;
        return;
    L8:
        Reflect.on(r12).call("onDropReasonChanged", new Class[]{Boolean.TYPE, List.class}, new Object[]{Boolean.valueOf(r10), r11});     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        th.printStackTrace();
    }

    public void onEffectiveConnectionTypeChanged(int r10) {
        if (CronetDependManager.inst().loggerDebug() == false) goto L13;
        CronetDependManager.inst().loggerD("CronetAppProviderManager", "onEffectiveConnectionTypeChanged type = " + r10);
    L13:
        Object r11 = this.mCronetAppProviderAdapter;     // Catch: Throwable -> L10
        if (r11 != null) goto L8;
        return;
    L8:
        Reflect.on(r11).call("onEffectiveConnectionTypeChangedOnIOThread", new Class[]{Integer.TYPE}, new Object[]{Integer.valueOf(r10)});     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        th.printStackTrace();
    }

    public void onMappingRequestStatus(String r10, int r11) {
        if (CronetDependManager.inst().loggerDebug() == false) goto L13;
        CronetDependManager.inst().loggerD("CronetAppProviderManager", "onMappingRequestStatus key = " + r10 + " status = " + r11);
    L13:
        Object r12 = this.mCronetAppProviderAdapter;     // Catch: Throwable -> L10
        if (r12 != null) goto L8;
        return;
    L8:
        Reflect.on(r12).call("onMappingRequestStatus", new Class[]{String.class, Integer.TYPE}, new Object[]{r10, Integer.valueOf(r11)});     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        th.printStackTrace();
    }

    public void onMultiNetStateChanged(int r10, int r11) {
        if (CronetDependManager.inst().loggerDebug() == false) goto L13;
        CronetDependManager.inst().loggerD("CronetAppProviderManager", "onMultiNetStateChanged, prev state = " + r10 + ", curr state = " + r11);
    L13:
        Object r12 = this.mCronetAppProviderAdapter;     // Catch: Throwable -> L10
        if (r12 != null) goto L8;
        return;
    L8:
        Reflect r13 = Reflect.on(r12);     // Catch: Throwable -> L10
        Class<?> r14 = Integer.TYPE;     // Catch: Throwable -> L10
        r13.call("onMultiNetStateChanged", new Class[]{r14, r14}, new Object[]{Integer.valueOf(r10), Integer.valueOf(r11)}).get();     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        th.printStackTrace();
    }

    public void onMultiNetworkStateChanged(int r10, int r11) {
        if (CronetDependManager.inst().loggerDebug() == false) goto L13;
        CronetDependManager.inst().loggerD("CronetAppProviderManager", "onMultiNetworkStateChanged, prev state = " + r10 + ", curr state = " + r11);
    L13:
        Object r12 = this.mCronetAppProviderAdapter;     // Catch: Throwable -> L10
        if (r12 != null) goto L8;
        return;
    L8:
        Reflect r13 = Reflect.on(r12);     // Catch: Throwable -> L10
        Class<?> r14 = Integer.TYPE;     // Catch: Throwable -> L10
        r13.call("onWiFiToCellStateChangedOnIOThread", new Class[]{r14, r14}, new Object[]{Integer.valueOf(r10), Integer.valueOf(r11)}).get();     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        th.printStackTrace();
    }

    public void onNetworkQualityLevelChanged(int r10) {
        if (CronetDependManager.inst().loggerDebug() == false) goto L13;
        CronetDependManager.inst().loggerD("CronetAppProviderManager", "onNetworkQualityLevelChanged, nql: " + r10);
    L13:
        Object r11 = this.mCronetAppProviderAdapter;     // Catch: Throwable -> L10
        if (r11 != null) goto L8;
        return;
    L8:
        Reflect.on(r11).call("onNetworkQualityLevelChangedOnIOThread", new Class[]{Integer.TYPE}, new Object[]{Integer.valueOf(r10)}).get();     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        th.printStackTrace();
    }

    public void onNetworkQualityRttAndThroughputNotified(int r10, int r11, int r12) {
        if (CronetDependManager.inst().loggerDebug() == false) goto L13;
        CronetDependManager.inst().loggerD("CronetAppProviderManager", "onNetworkQualityRttAndThroughputNotified, effectiveHrttMs: " + r10 + ", effectiveTrttMs: " + r11 + ", effectiveRxThroughputKbps: " + r12);
    L13:
        Object r13 = this.mCronetAppProviderAdapter;     // Catch: Throwable -> L10
        if (r13 != null) goto L8;
        return;
    L8:
        Reflect r14 = Reflect.on(r13);     // Catch: Throwable -> L10
        Class<?> r15 = Integer.TYPE;     // Catch: Throwable -> L10
        r14.call("onNetworkQualityRttAndThroughputNotifiedOnIOThread", new Class[]{r15, r15, r15}, new Object[]{Integer.valueOf(r10), Integer.valueOf(r11), Integer.valueOf(r12)}).get();     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        th.printStackTrace();
    }

    public void onNetworkQualityTypeChangedV3(int r10) {
        if (CronetDependManager.inst().loggerDebug() == false) goto L13;
        CronetDependManager.inst().loggerD("CronetAppProviderManager", "onNetworkQualityTypeChangedV3, network_quality_type = " + r10);
    L13:
        Object r11 = this.mCronetAppProviderAdapter;     // Catch: Throwable -> L10
        if (r11 != null) goto L8;
        return;
    L8:
        Reflect r12 = Reflect.on(r11);     // Catch: Throwable -> L10
        Class<?> r13 = Integer.TYPE;     // Catch: Throwable -> L10
        r12.call("onEffectiveConnectionTypeChangedOnIOThread", new Class[]{r13}, new Object[]{Integer.valueOf(r10)});     // Catch: Throwable -> L10
        Reflect.on("com.bytedance.ttnet.NQEManager").call("notifyNQTChanged", new Class[]{r13}, new Object[]{Integer.valueOf(r10)});     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        th.printStackTrace();
    }

    public void onPacketLossComputed(int r20, double r21, double r23, double r25, double r27) {
        if (CronetDependManager.inst().loggerDebug() == false) goto L15;
        CronetDependManager.inst().loggerD("CronetAppProviderManager", "onPacketLossComputed protocol = " + r20 + ", upstreamLossRate = " + r21 + ", upstreamLossRateVariance = " + r23 + ", downstreamLossRate = " + r25 + ", downstreamLossRateVariance = " + r27);
    L15:
        Object r10 = this.mCronetAppProviderAdapter;     // Catch: Throwable -> L12
        if (r10 != null) goto L10;
        return;
    L10:
        Reflect r11 = Reflect.on(r10);     // Catch: Throwable -> L12
        Class<?> r13 = Double.TYPE;     // Catch: Throwable -> L12
        r11.call("onPacketLossComputedOnIOThread", new Class[]{Integer.TYPE, r13, r13, r13, r13}, new Object[]{Integer.valueOf(r20), Double.valueOf(r21), Double.valueOf(r23), Double.valueOf(r25), Double.valueOf(r27)});     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        th.printStackTrace();
    }

    public void onPublicIPsChanged(List<String> r10, List<String> r11) {
        if (CronetDependManager.inst().loggerDebug() == false) goto L13;
        CronetDependManager.inst().loggerD("CronetAppProviderManager", "onPublicIPsChanged ");
    L13:
        Object r12 = this.mCronetAppProviderAdapter;     // Catch: Throwable -> L10
        if (r12 != null) goto L8;
        return;
    L8:
        Reflect.on(r12).call("onPublicIPsChanged", new Class[]{List.class, List.class}, new Object[]{r10, r11});     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        th.printStackTrace();
    }

    public void onRTTOrThroughputEstimatesComputed(int r10, int r11, int r12) {
        if (CronetDependManager.inst().loggerDebug() == false) goto L13;
        CronetDependManager.inst().loggerD("CronetAppProviderManager", "onRTTOrThroughputEstimatesComputed httpRtt = " + r10 + ", transportRttMs = " + r11 + ",downstreamThroughputKbps = " + r12);
    L13:
        Object r13 = this.mCronetAppProviderAdapter;     // Catch: Throwable -> L10
        if (r13 != null) goto L8;
        return;
    L8:
        Reflect r14 = Reflect.on(r13);     // Catch: Throwable -> L10
        Class<?> r15 = Integer.TYPE;     // Catch: Throwable -> L10
        r14.call("onRTTOrThroughputEstimatesComputedOnIOThread", new Class[]{r15, r15, r15}, new Object[]{Integer.valueOf(r10), Integer.valueOf(r11), Integer.valueOf(r12)});     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        th.printStackTrace();
    }

    public void onServerConfigUpdated(String r10, String r11, String r12) {
        if (CronetDependManager.inst().loggerDebug() == false) goto L13;
        CronetDependManager.inst().loggerD("CronetAppProviderManager", "onServerConfigUpdated json = " + r10);
    L13:
        Object r13 = this.mCronetAppProviderAdapter;     // Catch: Throwable -> L10
        if (r13 != null) goto L8;
        return;
    L8:
        Reflect.on(r13).call("onServerConfigEtagChanged", new Class[]{String.class}, new Object[]{r11});     // Catch: Throwable -> L10
        Reflect.on(this.mCronetAppProviderAdapter).call("onServerConfigABTestChanged", new Class[]{String.class}, new Object[]{r12});     // Catch: Throwable -> L10
        Reflect.on(this.mCronetAppProviderAdapter).call("onServerConfigUpdated", new Class[]{String.class}, new Object[]{r10});     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        th.printStackTrace();
    }

    public void onStoreIdcChanged(String r12, String r13, String r14, String r15, String r16, String r17) {
        if (CronetDependManager.inst().loggerDebug() == false) goto L14;
        CronetDependManager.inst().loggerD("CronetAppProviderManager", "onStoreIdcChanged ");
    L14:
        Object r10 = this.mCronetAppProviderAdapter;     // Catch: Throwable -> L11
        if (r10 != null) goto L9;
        return;
    L9:
        Reflect.on(r10).call("onStoreIdcChanged", new Class[]{String.class, String.class, String.class, String.class, String.class, String.class}, new Object[]{r12, r13, r14, r15, r16, r17});     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        th.printStackTrace();
    }

    public void onTNCUpdateFailed(String[] r10, String r11) {
        if (CronetDependManager.inst().loggerDebug() == false) goto L20;
        CronetDependManager.inst().loggerD("CronetAppProviderManager", "onTNCUpdateFailed ");
    L20:
    L17:
        th = move-exception;
        th.printStackTrace();
        return;
    L6:
        if (this.mCronetAppProviderAdapter == null) goto L16;
        if (r10 != null) goto L9;
        return;
    L9:
        if (r10.length <= 0) goto L24;
        ArrayList r12 = new ArrayList();     // Catch: Throwable -> L17
        int r13 = r10.length;     // Catch: Throwable -> L17
        int r14 = 0;
    L12:
        if (r14 >= r13) goto L14;
        r12.add(r10[r14]);     // Catch: Throwable -> L17
        r14 = r14 + 1;     // Catch: Throwable -> L17
        goto L12
    L14:
        Reflect.on(this.mCronetAppProviderAdapter).call("onTNCUpdateFailed", new Class[]{ArrayList.class, String.class}, new Object[]{r12, r11});     // Catch: Throwable -> L17
        return;
    L24:
        return;
    }

    public void onTTDnsResolveResult(String r15, String r16, int r17, int r18, int r19, List<String> r20, String r21) {
        if (CronetDependManager.inst().loggerDebug() == false) goto L14;
        CronetDependManager.inst().loggerD("CronetAppProviderManager", "onTTDnsResolveResult info uuid = " + r15 + " host: " + r16);
    L14:
        Object r10 = this.mCronetAppProviderAdapter;     // Catch: Throwable -> L11
        if (r10 != null) goto L9;
        return;
    L9:
        Reflect r11 = Reflect.on(r10);     // Catch: Throwable -> L11
        Class<?> r12 = Integer.TYPE;     // Catch: Throwable -> L11
        r11.call("onTTDnsResolveResult", new Class[]{String.class, String.class, r12, r12, r12, List.class, String.class}, new Object[]{r15, r16, Integer.valueOf(r17), Integer.valueOf(r18), Integer.valueOf(r19), r20, r21});     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        th.printStackTrace();
    }

    public void onTTNetDetectInfoChanged(String r10) {
        if (CronetDependManager.inst().loggerDebug() == false) goto L13;
        CronetDependManager.inst().loggerD("CronetAppProviderManager", "onTTNetDetectInfoChanged info str = " + r10);
    L13:
        Object r11 = this.mCronetAppProviderAdapter;     // Catch: Throwable -> L10
        if (r11 != null) goto L8;
        return;
    L8:
        Reflect.on(r11).call("onTTNetDetectInfoChanged", new Class[]{String.class}, new Object[]{r10});     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        th.printStackTrace();
    }

    public void onUserSpecifiedNetworkEnabled(boolean r10) {
        if (CronetDependManager.inst().loggerDebug() == false) goto L13;
        CronetDependManager.inst().loggerD("CronetAppProviderManager", "onUserSpecifiedNetworkEnabled, enable = " + r10);
    L13:
        Object r11 = this.mCronetAppProviderAdapter;     // Catch: Throwable -> L10
        if (r11 != null) goto L8;
        return;
    L8:
        Reflect.on(r11).call("onUserSpecifiedNetworkEnabled", new Class[]{Boolean.TYPE}, new Object[]{Boolean.valueOf(r10)});     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        th.printStackTrace();
    }

    public void sendAppMonitorEvent(String r10, String r11) {
        if (CronetDependManager.inst().loggerDebug() == false) goto L13;
        CronetDependManager.inst().loggerD("CronetAppProviderManager", "Send monitor json = " + r10 + ", log type =" + r11);
    L13:
        Object r12 = this.mCronetAppProviderAdapter;     // Catch: Throwable -> L10
        if (r12 != null) goto L8;
        return;
    L8:
        Reflect.on(r12).call("sendAppMonitorEvent", new Class[]{String.class, String.class}, new Object[]{r10, r11});     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        th.printStackTrace();
    }

    public void setAdapter(Object r10) {
        if (r10 == null) goto L28;
        List r11 = Utils.getAllInterfaces(r10.getClass());     // Catch: Throwable -> L19
        if (r11 != null) goto L6;
        return;
    L6:
        if (r11.isEmpty() == true) goto L27;
        Iterator r12 = r11.iterator();     // Catch: Throwable -> L19
    L10:
        if (r12.hasNext() == false) goto L30;
        if (ADAPTER_CLASS_NAME.equals(((Class) r12.next()).getName()) == false) goto L10;
        if (CronetDependManager.inst().loggerDebug() == false) goto L16;
        CronetDependManager.inst().loggerD("CronetAppProviderManager", "inject CronetAppProviderManager success");     // Catch: Throwable -> L19
    L16:
        this.mCronetAppProviderAdapter = r10;     // Catch: Throwable -> L19
        return;
    L30:
        return;
    L27:
        return;
    L19:
        th = move-exception;
        th.printStackTrace();
        return;
    }
}
