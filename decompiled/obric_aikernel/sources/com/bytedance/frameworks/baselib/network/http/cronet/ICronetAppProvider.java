package com.bytedance.frameworks.baselib.network.http.cronet;

import android.util.Pair;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public interface ICronetAppProvider {
    void doLoadLibrary(String r10);

    String getAbClient();

    String getAbFeature();

    String getAbFlag();

    List<String> getAbSdkVersion();

    String getAbVersion();

    String getAbi();

    String getAppId();

    a getAppInfoSubset();

    String getAppInitialRegionInfo();

    String getAppName();

    long getAppStartTime();

    String getBypassBOEJSON();

    String getCarrierRegion();

    String getChannel();

    String getCityName();

    Map<String[], Pair<byte[], byte[]>> getClientOpaqueData();

    String getCronetSoPath();

    String getDPI();

    String getDeviceBrand();

    String getDeviceId();

    String getDeviceModel();

    String getDevicePlatform();

    String getDeviceType();

    String getGetDomainDefaultJSON();

    Map<String, String> getGetDomainDependHostMap();

    String getHttpDnsRequestFlags();

    String getIId();

    String getIsDropFirstTnc();

    String getLanguage();

    boolean getLazyInitCronetIPC();

    String getManifestVersionCode();

    String getNetAccessType();

    String getNetworkOperator();

    String getOSApi();

    String getOSVersion();

    ArrayList<byte[]> getOpaqueData();

    String getOpenUdid();

    boolean getOptInit();

    boolean getOptNqeDefault();

    boolean getOptNqePersist();

    int getProcessFlag();

    Map<String, Pair<Integer, Integer>> getQuicHint();

    String getRegion();

    String getResolution();

    String getRticket();

    String getSdkAppId();

    String getSdkVersion();

    String getSimOperator();

    String getSsmix();

    String getStoreIdc();

    String getStoreIdcRuleJSON();

    String getSysRegion();

    String getTNCRequestFlags();

    Map<String, String> getTNCRequestHeader();

    Map<String, String> getTNCRequestQuery();

    @Deprecated
    String getUUID();

    String getUpdateVersionCode();

    String getUserId();

    String getVersionCode();

    String getVersionName();

    int getWifiFrequency();

    int getWifiRssi();

    void handleApiResult(boolean r10, String r11, String r12, String r13, long r14, long r15, long r16, long r17, long r18, long r19, long r110, long r111, long r21, long r23, boolean r25, long r26, long r28, String r30, String r31, String r32, Exception r33);

    boolean handleApiSample(String r10, String r11);

    boolean isBOEProxyEnabled();

    boolean isEnableBrotli();

    boolean isEnableHttp2();

    boolean isEnableQuic();

    boolean needCustomLoadLibrary();

    Map<String, String> onCallToAddSecurityFactor(String r10, Map<String, String> r11);

    void onClientIPChanged(String r10);

    void onColdStartFinish();

    void onCronetBootSucceed();

    void onDropReasonChanged(boolean r10, List<Integer> r11);

    void onEffectiveConnectionTypeChanged(int r10);

    void onEffectiveConnectionTypeChangedOnIOThread(int r10);

    void onMultiNetStateChanged(int r10, int r11);

    void onMultiNetworkStateChanged(int r10, int r11);

    void onNetworkQualityLevelChanged(int r10);

    void onNetworkQualityLevelChangedOnIOThread(int r10);

    void onNetworkQualityRttAndThroughputNotified(int r10, int r11, int r12);

    void onNetworkQualityRttAndThroughputNotifiedOnIOThread(int r10, int r11, int r12);

    void onPacketLossComputed(int r10, double r11, double r12, double r13, double r14);

    void onPacketLossComputedOnIOThread(int r10, double r11, double r12, double r13, double r14);

    void onPublicIPsChanged(List<String> r10, List<String> r11);

    void onRTTOrThroughputEstimatesComputed(int r10, int r11, int r12);

    void onRTTOrThroughputEstimatesComputedOnIOThread(int r10, int r11, int r12);

    void onServerConfigABTestChanged(String r10);

    void onServerConfigEtagChanged(String r10);

    void onServerConfigUpdated(String r10);

    void onStoreIdcChanged(String r10, String r11, String r12, String r13, String r14, String r15);

    void onTNCUpdateFailed(ArrayList<String> r10, String r11);

    void onTTDnsResolveResult(String r10, String r11, int r12, int r13, int r14, List<String> r15, String r16);

    void onTTNetDetectInfoChanged(String r10);

    void onUserSpecifiedNetworkEnabled(boolean r10);

    void onWiFiToCellStateChangedOnIOThread(int r10, int r11);

    void sendAppMonitorEvent(String r10, String r11);
}
