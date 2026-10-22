package com.bytedance.frameworks.baselib.network.http.cronet;

import android.util.Pair;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public interface ICronetAppProvider {
    void doLoadLibrary(String r5);

    String getAbClient();

    String getAbFeature();

    String getAbFlag();

    String getAbVersion();

    String getAbi();

    String getAppId();

    String getAppName();

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

    String getLanguage();

    String getManifestVersionCode();

    String getNetAccessType();

    String getOSApi();

    String getOSVersion();

    ArrayList<byte[]> getOpaqueData();

    String getOpenUdid();

    int getProcessFlag();

    Map<String, Pair<Integer, Integer>> getQuicHint();

    String getRegion();

    String getResolution();

    String getRticket();

    String getSdkAppId();

    String getSdkVersion();

    String getSsmix();

    String getStoreIdc();

    String getStoreIdcRuleJSON();

    String getSysRegion();

    String getTNCRequestFlags();

    Map<String, String> getTNCRequestHeader();

    Map<String, String> getTNCRequestQuery();

    String getUUID();

    String getUpdateVersionCode();

    String getUserId();

    String getVersionCode();

    String getVersionName();

    void handleApiResult(boolean r5, String r10, String r11, String r12, long r13, long r14, long r15, long r16, long r17, long r18, long r19, long r110, long r21, long r23, boolean r25, long r26, long r28, String r30, String r31, String r32, Exception r33);

    boolean isBOEProxyEnabled();

    boolean isEnableBrotli();

    boolean isEnableHttp2();

    boolean isEnableQuic();

    boolean needCustomLoadLibrary();

    Map<String, String> onCallToAddSecurityFactor(String r5, Map<String, String> r10);

    void onClientIPChanged(String r5);

    void onColdStartFinish();

    void onCronetBootSucceed();

    void onEffectiveConnectionTypeChanged(int r5);

    void onMultiNetworkStateChanged(int r5, int r10);

    void onNetworkQualityLevelChanged(int r5);

    void onNetworkQualityRttAndThroughputNotified(int r5, int r10, int r11);

    void onPacketLossComputed(int r5, double r10, double r11, double r12, double r13);

    void onPublicIPsChanged(List<String> r5, List<String> r10);

    void onRTTOrThroughputEstimatesComputed(int r5, int r10, int r11);

    void onServerConfigABTestChanged(String r5);

    void onServerConfigEtagChanged(String r5);

    void onServerConfigUpdated(String r5);

    void onStoreIdcChanged(String r5, String r10, String r11);

    void onTNCUpdateFailed(ArrayList<String> r5, String r10);

    void onTTDnsResolveResult(String r5, String r10, int r11, int r12, int r13, List<String> r14, String r15);

    void onTTNetDetectInfoChanged(String r5);

    void sendAppMonitorEvent(String r5, String r10);
}
