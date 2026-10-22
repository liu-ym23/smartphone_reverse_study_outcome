package org.chromium;

import android.util.Pair;
import com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider;
import com.bytedance.frameworks.baselib.network.http.cronet.ICronetDepend;
import com.bytedance.frameworks.baselib.network.http.f;
import com.bytedance.frameworks.baselib.network.utils.a;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes7.dex */
public class CronetAppProviderManager {
    private static final String ADAPTER_CLASS_NAME = "com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider";
    private static volatile CronetAppProviderManager sCronetAppProviderManager;
    private ICronetAppProvider mCronetAppProvider;
    private Object mCronetAppProviderAdapter;
    private ICronetDepend mCronetDepend;

    private CronetAppProviderManager() {
    }

    private String getStringAttribute(String r3) {
        Object r2 = this.mCronetAppProviderAdapter;     // Catch: Throwable -> L8
        if (r2 != null) goto L6;
        return "";
    L6:
        return (String) ZeusTransformUtils.preCheckCast(a.a(r2).call(r3).a(), String.class, "com.obric.memorydata.plugin");
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

    public void doLoadLibrary(String r6) {
    L13:
        th = move-exception;
        th.printStackTrace();
        return;
    L3:
        if (f.d() == false) goto L8;
        ICronetAppProvider r5 = this.mCronetAppProvider;     // Catch: Throwable -> L13
        if (r5 != null) goto L7;
        return;
    L7:
        r5.doLoadLibrary(r6);     // Catch: Throwable -> L13
    L16:
        return;
    L8:
        Object r7 = this.mCronetAppProviderAdapter;     // Catch: Throwable -> L13
        if (r7 != null) goto L11;
        return;
    L11:
        a.a(r7).call("doLoadLibrary", new Class[]{String.class}, new Object[]{r6});     // Catch: Throwable -> L13
        goto L16
    }

    public List<String> getAbSdkVersion() {
    L15:
        th = move-exception;
        th.printStackTrace();
        return null;
    L4:
        if (f.d() == false) goto L10;
        ICronetAppProvider r3 = this.mCronetAppProvider;     // Catch: Throwable -> L15
        if (r3 != null) goto L9;
        return null;
    L9:
        return r3.getAbSdkVersion();
    L10:
        Object r4 = this.mCronetAppProviderAdapter;     // Catch: Throwable -> L15
        if (r4 != null) goto L14;
        return null;
    L14:
        return (List) ZeusTransformUtils.preCheckCast(a.a(r4).call("getAbSdkVersion").a(), List.class, "com.obric.memorydata.plugin");
    }

    public String getAbi() {
        if (f.d() == false) goto L11;
        ICronetAppProvider r1 = this.mCronetAppProvider;
        if (r1 != null) goto L9;
        return "";
    L9:
        return r1.getAbi();
    L11:
        return getStringAttribute("getAbi");
    }

    public String getAppId() {
        if (f.d() == false) goto L11;
        ICronetAppProvider r1 = this.mCronetAppProvider;
        if (r1 != null) goto L9;
        return "";
    L9:
        return r1.getAppId();
    L11:
        return getStringAttribute("getAppId");
    }

    public String getAppName() {
        if (f.d() == false) goto L11;
        ICronetAppProvider r1 = this.mCronetAppProvider;
        if (r1 != null) goto L9;
        return "";
    L9:
        return r1.getAppName();
    L11:
        return getStringAttribute("getAppName");
    }

    public long getAppStartTime() {
    L15:
        th = move-exception;
        th.printStackTrace();
        return -1;
    L4:
        if (f.d() == false) goto L10;
        ICronetAppProvider r4 = this.mCronetAppProvider;     // Catch: Throwable -> L15
        if (r4 != null) goto L9;
        return -1;
    L9:
        return r4.getAppStartTime();
    L10:
        Object r5 = this.mCronetAppProviderAdapter;     // Catch: Throwable -> L15
        if (r5 != null) goto L14;
        return -1;
    L14:
        return ((Long) ZeusTransformUtils.preCheckCast(a.a(r5).call("getAppStartTime").a(), Long.class, "com.obric.memorydata.plugin")).longValue();
    }

    public String getBypassBOEJSON() {
    L15:
        th = move-exception;
        th.printStackTrace();
        return null;
    L4:
        if (f.d() == false) goto L10;
        ICronetAppProvider r3 = this.mCronetAppProvider;     // Catch: Throwable -> L15
        if (r3 != null) goto L9;
        return null;
    L9:
        return r3.getBypassBOEJSON();
    L10:
        Object r4 = this.mCronetAppProviderAdapter;     // Catch: Throwable -> L15
        if (r4 != null) goto L14;
        return null;
    L14:
        return (String) ZeusTransformUtils.preCheckCast(a.a(r4).call("getBypassBOEJSON").a(), String.class, "com.obric.memorydata.plugin");
    }

    public String getCarrierRegion() {
        if (f.d() == false) goto L11;
        ICronetAppProvider r1 = this.mCronetAppProvider;
        if (r1 != null) goto L9;
        return "";
    L9:
        return r1.getCarrierRegion();
    L11:
        return getStringAttribute("getCarrierRegion");
    }

    public String getChannel() {
        if (f.d() == false) goto L11;
        ICronetAppProvider r1 = this.mCronetAppProvider;
        if (r1 != null) goto L9;
        return "";
    L9:
        return r1.getChannel();
    L11:
        return getStringAttribute("getChannel");
    }

    public Map<String[], Pair<byte[], byte[]>> getClientOpaqueData() {
    L15:
        th = move-exception;
        th.printStackTrace();
        return null;
    L4:
        if (f.d() == false) goto L10;
        ICronetAppProvider r3 = this.mCronetAppProvider;     // Catch: Throwable -> L15
        if (r3 != null) goto L9;
        return null;
    L9:
        return r3.getClientOpaqueData();
    L10:
        Object r4 = this.mCronetAppProviderAdapter;     // Catch: Throwable -> L15
        if (r4 != null) goto L14;
        return null;
    L14:
        return (Map) ZeusTransformUtils.preCheckCast(a.a(r4).call("getClientOpaqueData").a(), Map.class, "com.obric.memorydata.plugin");
    }

    public String getCronetSoPath() {
    L15:
        th = move-exception;
        th.printStackTrace();
        return null;
    L4:
        if (f.d() == false) goto L10;
        ICronetAppProvider r3 = this.mCronetAppProvider;     // Catch: Throwable -> L15
        if (r3 != null) goto L9;
        return null;
    L9:
        return r3.getCronetSoPath();
    L10:
        Object r4 = this.mCronetAppProviderAdapter;     // Catch: Throwable -> L15
        if (r4 != null) goto L14;
        return null;
    L14:
        return (String) ZeusTransformUtils.preCheckCast(a.a(r4).call("getCronetSoPath").a(), String.class, "com.obric.memorydata.plugin");
    }

    public String getDeviceBrand() {
        if (f.d() == false) goto L11;
        ICronetAppProvider r1 = this.mCronetAppProvider;
        if (r1 != null) goto L9;
        return "";
    L9:
        return r1.getDeviceBrand();
    L11:
        return getStringAttribute("getDeviceBrand");
    }

    public String getDeviceId() {
        if (f.d() == false) goto L11;
        ICronetAppProvider r1 = this.mCronetAppProvider;
        if (r1 != null) goto L9;
        return "";
    L9:
        return r1.getDeviceId();
    L11:
        return getStringAttribute("getDeviceId");
    }

    public String getDeviceModel() {
        if (f.d() == false) goto L11;
        ICronetAppProvider r1 = this.mCronetAppProvider;
        if (r1 != null) goto L9;
        return "";
    L9:
        return r1.getDeviceModel();
    L11:
        return getStringAttribute("getDeviceModel");
    }

    public String getDevicePlatform() {
        if (f.d() == false) goto L11;
        ICronetAppProvider r1 = this.mCronetAppProvider;
        if (r1 != null) goto L9;
        return "";
    L9:
        return r1.getDevicePlatform();
    L11:
        return getStringAttribute("getDevicePlatform");
    }

    public String getDeviceType() {
        if (f.d() == false) goto L11;
        ICronetAppProvider r1 = this.mCronetAppProvider;
        if (r1 != null) goto L9;
        return "";
    L9:
        return r1.getDeviceType();
    L11:
        return getStringAttribute("getDeviceType");
    }

    public String getGetDomainDefaultJSON() {
    L15:
        th = move-exception;
        th.printStackTrace();
        return null;
    L4:
        if (f.d() == false) goto L10;
        ICronetAppProvider r3 = this.mCronetAppProvider;     // Catch: Throwable -> L15
        if (r3 != null) goto L9;
        return null;
    L9:
        return r3.getGetDomainDefaultJSON();
    L10:
        Object r4 = this.mCronetAppProviderAdapter;     // Catch: Throwable -> L15
        if (r4 != null) goto L14;
        return null;
    L14:
        return (String) ZeusTransformUtils.preCheckCast(a.a(r4).call("getGetDomainDefaultJSON").a(), String.class, "com.obric.memorydata.plugin");
    }

    public Map<String, String> getGetDomainDependHostMap() {
    L16:
        th = move-exception;
        th.printStackTrace();
        return Collections.emptyMap();
    L3:
        if (f.d() == false) goto L10;
        ICronetAppProvider r2 = this.mCronetAppProvider;     // Catch: Throwable -> L16
        if (r2 != null) goto L9;
        return Collections.emptyMap();
    L9:
        return r2.getGetDomainDependHostMap();
    L10:
        Object r3 = this.mCronetAppProviderAdapter;     // Catch: Throwable -> L16
        if (r3 != null) goto L15;
        return Collections.emptyMap();
    L15:
        return (Map) ZeusTransformUtils.preCheckCast(a.a(r3).call("getGetDomainDependHostMap").a(), Map.class, "com.obric.memorydata.plugin");
    }

    public String getHttpDnsRequestFlags() {
        if (f.d() == false) goto L11;
        ICronetAppProvider r1 = this.mCronetAppProvider;
        if (r1 != null) goto L9;
        return "";
    L9:
        return r1.getHttpDnsRequestFlags();
    L11:
        return getStringAttribute("getHttpDnsRequestFlags");
    }

    public String getInitRegion() {
        if (f.d() == false) goto L11;
        ICronetAppProvider r1 = this.mCronetAppProvider;
        if (r1 != null) goto L9;
        return "";
    L9:
        return r1.getAppInitialRegionInfo();
    L11:
        return getStringAttribute("getAppInitialRegionInfo");
    }

    public String getIsDropFirstTnc() {
    L14:
        th = move-exception;
        th.printStackTrace();
        return "";
    L3:
        if (f.d() == false) goto L9;
        ICronetAppProvider r2 = this.mCronetAppProvider;     // Catch: Throwable -> L14
        if (r2 != null) goto L8;
        return null;
    L8:
        return r2.getIsDropFirstTnc();
    L9:
        Object r3 = this.mCronetAppProviderAdapter;     // Catch: Throwable -> L14
        if (r3 != null) goto L13;
        return null;
    L13:
        return (String) ZeusTransformUtils.preCheckCast(a.a(r3).call("getIsDropFirstTnc").a(), String.class, "com.obric.memorydata.plugin");
    }

    public String getManifestVersionCode() {
        if (f.d() == false) goto L11;
        ICronetAppProvider r1 = this.mCronetAppProvider;
        if (r1 != null) goto L9;
        return "";
    L9:
        return r1.getManifestVersionCode();
    L11:
        return getStringAttribute("getManifestVersionCode");
    }

    public String getNetAccessType() {
        if (f.d() == false) goto L11;
        ICronetAppProvider r1 = this.mCronetAppProvider;
        if (r1 != null) goto L9;
        return "";
    L9:
        return r1.getNetAccessType();
    L11:
        return getStringAttribute("getNetAccessType");
    }

    public String getNetworkOperator() {
    L15:
        th = move-exception;
        th.printStackTrace();
        return "";
    L4:
        if (f.d() == false) goto L10;
        ICronetAppProvider r3 = this.mCronetAppProvider;     // Catch: Throwable -> L15
        if (r3 != null) goto L9;
        return "";
    L9:
        return r3.getNetworkOperator();
    L10:
        Object r4 = this.mCronetAppProviderAdapter;     // Catch: Throwable -> L15
        if (r4 != null) goto L14;
        return "";
    L14:
        return (String) ZeusTransformUtils.preCheckCast(a.a(r4).call("getNetworkOperator").a(), String.class, "com.obric.memorydata.plugin");
    }

    public String getOSApi() {
        if (f.d() == false) goto L11;
        ICronetAppProvider r1 = this.mCronetAppProvider;
        if (r1 != null) goto L9;
        return "";
    L9:
        return r1.getOSApi();
    L11:
        return getStringAttribute("getOSApi");
    }

    public String getOSVersion() {
        if (f.d() == false) goto L11;
        ICronetAppProvider r1 = this.mCronetAppProvider;
        if (r1 != null) goto L9;
        return "";
    L9:
        return r1.getOSVersion();
    L11:
        return getStringAttribute("getOSVersion");
    }

    public ArrayList<byte[]> getOpaqueData() {
    L15:
        th = move-exception;
        th.printStackTrace();
        return null;
    L4:
        if (f.d() == false) goto L10;
        ICronetAppProvider r3 = this.mCronetAppProvider;     // Catch: Throwable -> L15
        if (r3 != null) goto L9;
        return null;
    L9:
        return r3.getOpaqueData();
    L10:
        Object r4 = this.mCronetAppProviderAdapter;     // Catch: Throwable -> L15
        if (r4 != null) goto L14;
        return null;
    L14:
        return (ArrayList) ZeusTransformUtils.preCheckCast(a.a(r4).call("getOpaqueData").a(), ArrayList.class, "com.obric.memorydata.plugin");
    }

    public boolean getOptInit() {
    L15:
        th = move-exception;
        th.printStackTrace();
        return false;
    L4:
        if (f.d() == false) goto L10;
        ICronetAppProvider r3 = this.mCronetAppProvider;     // Catch: Throwable -> L15
        if (r3 != null) goto L9;
        return false;
    L9:
        return r3.getOptInit();
    L10:
        Object r4 = this.mCronetAppProviderAdapter;     // Catch: Throwable -> L15
        if (r4 != null) goto L14;
        return false;
    L14:
        return ((Boolean) ZeusTransformUtils.preCheckCast(a.a(r4).call("getOptInit").a(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    }

    public int getProcessFlag() {
    L15:
        th = move-exception;
        th.printStackTrace();
        return 0;
    L4:
        if (f.d() == false) goto L10;
        ICronetAppProvider r3 = this.mCronetAppProvider;     // Catch: Throwable -> L15
        if (r3 != null) goto L9;
        return 0;
    L9:
        return r3.getProcessFlag();
    L10:
        Object r4 = this.mCronetAppProviderAdapter;     // Catch: Throwable -> L15
        if (r4 != null) goto L14;
        return 0;
    L14:
        return ((Integer) ZeusTransformUtils.preCheckCast(a.a(r4).call("getProcessFlag").a(), Integer.class, "com.obric.memorydata.plugin")).intValue();
    }

    public Map<String, Pair<Integer, Integer>> getQuicHint() {
    L15:
        th = move-exception;
        th.printStackTrace();
        return null;
    L4:
        if (f.d() == false) goto L10;
        ICronetAppProvider r3 = this.mCronetAppProvider;     // Catch: Throwable -> L15
        if (r3 != null) goto L9;
        return null;
    L9:
        return r3.getQuicHint();
    L10:
        Object r4 = this.mCronetAppProviderAdapter;     // Catch: Throwable -> L15
        if (r4 != null) goto L14;
        return null;
    L14:
        return (Map) ZeusTransformUtils.preCheckCast(a.a(r4).call("getQuicHint").a(), Map.class, "com.obric.memorydata.plugin");
    }

    public String getRegion() {
        if (f.d() == false) goto L11;
        ICronetAppProvider r1 = this.mCronetAppProvider;
        if (r1 != null) goto L9;
        return "";
    L9:
        return r1.getRegion();
    L11:
        return getStringAttribute("getRegion");
    }

    public String getSdkAppId() {
        if (f.d() == false) goto L11;
        ICronetAppProvider r1 = this.mCronetAppProvider;
        if (r1 != null) goto L9;
        return "";
    L9:
        return r1.getSdkAppId();
    L11:
        return getStringAttribute("getSdkAppId");
    }

    public String getSdkVersion() {
        if (f.d() == false) goto L11;
        ICronetAppProvider r1 = this.mCronetAppProvider;
        if (r1 != null) goto L9;
        return "";
    L9:
        return r1.getSdkVersion();
    L11:
        return getStringAttribute("getSdkVersion");
    }

    public String getSimOperator() {
    L15:
        th = move-exception;
        th.printStackTrace();
        return "";
    L4:
        if (f.d() == false) goto L10;
        ICronetAppProvider r3 = this.mCronetAppProvider;     // Catch: Throwable -> L15
        if (r3 != null) goto L9;
        return "";
    L9:
        return r3.getSimOperator();
    L10:
        Object r4 = this.mCronetAppProviderAdapter;     // Catch: Throwable -> L15
        if (r4 != null) goto L14;
        return "";
    L14:
        return (String) ZeusTransformUtils.preCheckCast(a.a(r4).call("getSimOperator").a(), String.class, "com.obric.memorydata.plugin");
    }

    public String getStoreIdc() {
        if (f.d() == false) goto L11;
        ICronetAppProvider r1 = this.mCronetAppProvider;
        if (r1 != null) goto L9;
        return "";
    L9:
        return r1.getStoreIdc();
    L11:
        return getStringAttribute("getStoreIdc");
    }

    public String getStoreIdcRuleJSON() {
    L15:
        th = move-exception;
        th.printStackTrace();
        return null;
    L4:
        if (f.d() == false) goto L10;
        ICronetAppProvider r3 = this.mCronetAppProvider;     // Catch: Throwable -> L15
        if (r3 != null) goto L9;
        return null;
    L9:
        return r3.getStoreIdcRuleJSON();
    L10:
        Object r4 = this.mCronetAppProviderAdapter;     // Catch: Throwable -> L15
        if (r4 != null) goto L14;
        return null;
    L14:
        return (String) ZeusTransformUtils.preCheckCast(a.a(r4).call("getStoreIdcRuleJSON").a(), String.class, "com.obric.memorydata.plugin");
    }

    public String getSysRegion() {
        if (f.d() == false) goto L11;
        ICronetAppProvider r1 = this.mCronetAppProvider;
        if (r1 != null) goto L9;
        return "";
    L9:
        return r1.getSysRegion();
    L11:
        return getStringAttribute("getSysRegion");
    }

    public String getTNCRequestFlags() {
        if (f.d() == false) goto L11;
        ICronetAppProvider r1 = this.mCronetAppProvider;
        if (r1 != null) goto L9;
        return "";
    L9:
        return r1.getTNCRequestFlags();
    L11:
        return getStringAttribute("getTNCRequestFlags");
    }

    public Map<String, String> getTNCRequestHeader() {
    L15:
        th = move-exception;
        th.printStackTrace();
        return null;
    L4:
        if (f.d() == false) goto L10;
        ICronetAppProvider r3 = this.mCronetAppProvider;     // Catch: Throwable -> L15
        if (r3 != null) goto L9;
        return null;
    L9:
        return r3.getTNCRequestHeader();
    L10:
        Object r4 = this.mCronetAppProviderAdapter;     // Catch: Throwable -> L15
        if (r4 != null) goto L14;
        return null;
    L14:
        return (Map) ZeusTransformUtils.preCheckCast(a.a(r4).call("getTNCRequestHeader").a(), Map.class, "com.obric.memorydata.plugin");
    }

    public Map<String, String> getTNCRequestQuery() {
    L15:
        th = move-exception;
        th.printStackTrace();
        return null;
    L4:
        if (f.d() == false) goto L10;
        ICronetAppProvider r3 = this.mCronetAppProvider;     // Catch: Throwable -> L15
        if (r3 != null) goto L9;
        return null;
    L9:
        return r3.getTNCRequestQuery();
    L10:
        Object r4 = this.mCronetAppProviderAdapter;     // Catch: Throwable -> L15
        if (r4 != null) goto L14;
        return null;
    L14:
        return (Map) ZeusTransformUtils.preCheckCast(a.a(r4).call("getTNCRequestQuery").a(), Map.class, "com.obric.memorydata.plugin");
    }

    public String getUpdateVersionCode() {
        if (f.d() == false) goto L11;
        ICronetAppProvider r1 = this.mCronetAppProvider;
        if (r1 != null) goto L9;
        return "";
    L9:
        return r1.getUpdateVersionCode();
    L11:
        return getStringAttribute("getUpdateVersionCode");
    }

    public String getUserId() {
        if (f.d() == false) goto L11;
        ICronetAppProvider r1 = this.mCronetAppProvider;
        if (r1 != null) goto L9;
        return "";
    L9:
        return r1.getUserId();
    L11:
        return getStringAttribute("getUserId");
    }

    public String getVersionCode() {
        if (f.d() == false) goto L11;
        ICronetAppProvider r1 = this.mCronetAppProvider;
        if (r1 != null) goto L9;
        return "";
    L9:
        return r1.getVersionCode();
    L11:
        return getStringAttribute("getVersionCode");
    }

    public String getVersionName() {
        if (f.d() == false) goto L11;
        ICronetAppProvider r1 = this.mCronetAppProvider;
        if (r1 != null) goto L9;
        return "";
    L9:
        return r1.getVersionName();
    L11:
        return getStringAttribute("getVersionName");
    }

    public int getWifiFrequency() {
    L15:
        th = move-exception;
        th.printStackTrace();
        return 0;
    L4:
        if (f.d() == false) goto L10;
        ICronetAppProvider r3 = this.mCronetAppProvider;     // Catch: Throwable -> L15
        if (r3 != null) goto L9;
        return 0;
    L9:
        return r3.getWifiFrequency();
    L10:
        Object r4 = this.mCronetAppProviderAdapter;     // Catch: Throwable -> L15
        if (r4 != null) goto L14;
        return 0;
    L14:
        return ((Integer) ZeusTransformUtils.preCheckCast(a.a(r4).call("getWifiFrequency").a(), Integer.class, "com.obric.memorydata.plugin")).intValue();
    }

    public int getWifiRssi() {
    L15:
        th = move-exception;
        th.printStackTrace();
        return 0;
    L4:
        if (f.d() == false) goto L10;
        ICronetAppProvider r3 = this.mCronetAppProvider;     // Catch: Throwable -> L15
        if (r3 != null) goto L9;
        return 0;
    L9:
        return r3.getWifiRssi();
    L10:
        Object r4 = this.mCronetAppProviderAdapter;     // Catch: Throwable -> L15
        if (r4 != null) goto L14;
        return 0;
    L14:
        return ((Integer) ZeusTransformUtils.preCheckCast(a.a(r4).call("getWifiRssi").a(), Integer.class, "com.obric.memorydata.plugin")).intValue();
    }

    public boolean isBOEProxyEnabled() {
    L15:
        th = move-exception;
        th.printStackTrace();
        return false;
    L4:
        if (f.d() == false) goto L10;
        ICronetAppProvider r3 = this.mCronetAppProvider;     // Catch: Throwable -> L15
        if (r3 != null) goto L9;
        return false;
    L9:
        return r3.isBOEProxyEnabled();
    L10:
        Object r4 = this.mCronetAppProviderAdapter;     // Catch: Throwable -> L15
        if (r4 != null) goto L14;
        return false;
    L14:
        return ((Boolean) ZeusTransformUtils.preCheckCast(a.a(r4).call("isBOEProxyEnabled").a(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    }

    public boolean isEnableBrotli() {
    L15:
        th = move-exception;
        th.printStackTrace();
        return false;
    L4:
        if (f.d() == false) goto L10;
        ICronetAppProvider r3 = this.mCronetAppProvider;     // Catch: Throwable -> L15
        if (r3 != null) goto L9;
        return false;
    L9:
        return r3.isEnableBrotli();
    L10:
        Object r4 = this.mCronetAppProviderAdapter;     // Catch: Throwable -> L15
        if (r4 != null) goto L14;
        return false;
    L14:
        return ((Boolean) ZeusTransformUtils.preCheckCast(a.a(r4).call("isEnableBrotli").a(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    }

    public boolean isEnableHttp2() {
    L15:
        th = move-exception;
        th.printStackTrace();
        return false;
    L4:
        if (f.d() == false) goto L10;
        ICronetAppProvider r3 = this.mCronetAppProvider;     // Catch: Throwable -> L15
        if (r3 != null) goto L9;
        return false;
    L9:
        return r3.isEnableHttp2();
    L10:
        Object r4 = this.mCronetAppProviderAdapter;     // Catch: Throwable -> L15
        if (r4 != null) goto L14;
        return false;
    L14:
        return ((Boolean) ZeusTransformUtils.preCheckCast(a.a(r4).call("isEnableHttp2").a(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    }

    public boolean isEnableQuic() {
    L15:
        th = move-exception;
        th.printStackTrace();
        return false;
    L4:
        if (f.d() == false) goto L10;
        ICronetAppProvider r3 = this.mCronetAppProvider;     // Catch: Throwable -> L15
        if (r3 != null) goto L9;
        return false;
    L9:
        return r3.isEnableQuic();
    L10:
        Object r4 = this.mCronetAppProviderAdapter;     // Catch: Throwable -> L15
        if (r4 != null) goto L14;
        return false;
    L14:
        return ((Boolean) ZeusTransformUtils.preCheckCast(a.a(r4).call("isEnableQuic").a(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    }

    public boolean needCustomLoadLibrary() {
    L15:
        th = move-exception;
        th.printStackTrace();
        return false;
    L4:
        if (f.d() == false) goto L10;
        ICronetAppProvider r3 = this.mCronetAppProvider;     // Catch: Throwable -> L15
        if (r3 != null) goto L9;
        return false;
    L9:
        return r3.needCustomLoadLibrary();
    L10:
        Object r4 = this.mCronetAppProviderAdapter;     // Catch: Throwable -> L15
        if (r4 != null) goto L14;
        return false;
    L14:
        return ((Boolean) ZeusTransformUtils.preCheckCast(a.a(r4).call("needCustomLoadLibrary").a(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    }

    public Map<String, String> onCallToAddSecurityFactor(String r9, Map<String, String> r10) {
        Map<String, String> r11 = (Map) ZeusTransformUtils.wrapperContextForParams(r10, Map.class, "com.obric.memorydata.plugin");
        if (CronetDependManager.inst().loggerDebug() == false) goto L21;
        CronetDependManager.inst().loggerD("CronetAppProviderManager", "onCallToAddSecurityFactor info url = " + r9);
    L21:
    L18:
        th = move-exception;
        th.printStackTrace();
        return null;
    L7:
        if (f.d() == false) goto L13;
        ICronetAppProvider r8 = this.mCronetAppProvider;     // Catch: Throwable -> L18
        if (r8 != null) goto L12;
        return null;
    L12:
        return r8.onCallToAddSecurityFactor(r9, r11);
    L13:
        Object r12 = this.mCronetAppProviderAdapter;     // Catch: Throwable -> L18
        if (r12 != null) goto L17;
        return null;
    L17:
        return (Map) ZeusTransformUtils.preCheckCast(a.a(r12).call("onCallToAddSecurityFactor", new Class[]{String.class, Map.class}, new Object[]{r9, r11}).a(), Map.class, "com.obric.memorydata.plugin");
    }

    public void onClientIPChanged(String r6) {
        if (CronetDependManager.inst().loggerDebug() == false) goto L19;
        CronetDependManager.inst().loggerD("CronetAppProviderManager", "onClientIPChanged ");
    L19:
    L16:
        th = move-exception;
        th.printStackTrace();
        return;
    L6:
        if (f.d() == false) goto L11;
        ICronetAppProvider r5 = this.mCronetAppProvider;     // Catch: Throwable -> L16
        if (r5 != null) goto L10;
        return;
    L10:
        r5.onClientIPChanged(r6);     // Catch: Throwable -> L16
        return;
    L11:
        Object r7 = this.mCronetAppProviderAdapter;     // Catch: Throwable -> L16
        if (r7 != null) goto L14;
        return;
    L14:
        a.a(r7).call("onClientIPChanged", new Class[]{String.class}, new Object[]{r6});     // Catch: Throwable -> L16
    }

    public void onColdStartFinish() {
        if (CronetDependManager.inst().loggerDebug() == false) goto L19;
        CronetDependManager.inst().loggerD("CronetAppProviderManager", "onColdStartFinish ");
    L19:
    L16:
        th = move-exception;
        th.printStackTrace();
        return;
    L6:
        if (f.d() == false) goto L11;
        ICronetAppProvider r3 = this.mCronetAppProvider;     // Catch: Throwable -> L16
        if (r3 != null) goto L10;
        return;
    L10:
        r3.onColdStartFinish();     // Catch: Throwable -> L16
        return;
    L11:
        Object r4 = this.mCronetAppProviderAdapter;     // Catch: Throwable -> L16
        if (r4 != null) goto L14;
        return;
    L14:
        a.a(r4).call("onColdStartFinish");     // Catch: Throwable -> L16
    }

    public void onCronetBootSucceed() {
        if (CronetDependManager.inst().loggerDebug() == false) goto L19;
        CronetDependManager.inst().loggerD("CronetAppProviderManager", "onCronetBootSucceed ");
    L19:
    L16:
        th = move-exception;
        th.printStackTrace();
        return;
    L6:
        if (f.d() == false) goto L11;
        ICronetAppProvider r3 = this.mCronetAppProvider;     // Catch: Throwable -> L16
        if (r3 != null) goto L10;
        return;
    L10:
        r3.onCronetBootSucceed();     // Catch: Throwable -> L16
        return;
    L11:
        Object r4 = this.mCronetAppProviderAdapter;     // Catch: Throwable -> L16
        if (r4 != null) goto L14;
        return;
    L14:
        a.a(r4).call("onCronetBootSucceed");     // Catch: Throwable -> L16
    }

    public void onDropReasonChanged(boolean r7, List<Integer> r8) {
        List<Integer> r9 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin");
        if (CronetDependManager.inst().loggerDebug() == false) goto L19;
        CronetDependManager.inst().loggerD("CronetAppProviderManager", "onDropReasonChanged " + r7 + ", Drop Reason List " + r9);
    L19:
    L16:
        th = move-exception;
        th.printStackTrace();
        return;
    L6:
        if (f.d() == false) goto L11;
        ICronetAppProvider r6 = this.mCronetAppProvider;     // Catch: Throwable -> L16
        if (r6 != null) goto L10;
        return;
    L10:
        r6.onDropReasonChanged(r7, r9);     // Catch: Throwable -> L16
        return;
    L11:
        Object r10 = this.mCronetAppProviderAdapter;     // Catch: Throwable -> L16
        if (r10 != null) goto L14;
        return;
    L14:
        a.a(r10).call("onDropReasonChanged", new Class[]{Boolean.TYPE, List.class}, new Object[]{Boolean.valueOf(r7), r9});     // Catch: Throwable -> L16
    }

    public void onEffectiveConnectionTypeChanged(int r6) {
        if (CronetDependManager.inst().loggerDebug() == false) goto L19;
        CronetDependManager.inst().loggerD("CronetAppProviderManager", "onEffectiveConnectionTypeChanged type = " + r6);
    L19:
    L16:
        th = move-exception;
        th.printStackTrace();
        return;
    L6:
        if (f.d() == false) goto L11;
        ICronetAppProvider r5 = this.mCronetAppProvider;     // Catch: Throwable -> L16
        if (r5 != null) goto L10;
        return;
    L10:
        r5.onEffectiveConnectionTypeChangedOnIOThread(r6);     // Catch: Throwable -> L16
        return;
    L11:
        Object r7 = this.mCronetAppProviderAdapter;     // Catch: Throwable -> L16
        if (r7 != null) goto L14;
        return;
    L14:
        a.a(r7).call("onEffectiveConnectionTypeChangedOnIOThread", new Class[]{Integer.TYPE}, new Object[]{Integer.valueOf(r6)});     // Catch: Throwable -> L16
    }

    public void onMappingRequestStatus(String r7, int r8) {
        if (CronetDependManager.inst().loggerDebug() == false) goto L19;
        CronetDependManager.inst().loggerD("CronetAppProviderManager", "onMappingRequestStatus key = " + r7 + " status = " + r8);
    L19:
    L16:
        th = move-exception;
        th.printStackTrace();
        return;
    L6:
        if (f.d() == false) goto L11;
        ICronetAppProvider r6 = this.mCronetAppProvider;     // Catch: Throwable -> L16
        if (r6 != null) goto L10;
        return;
    L10:
        r6.onMappingRequestStatus(r7, r8);     // Catch: Throwable -> L16
        return;
    L11:
        Object r9 = this.mCronetAppProviderAdapter;     // Catch: Throwable -> L16
        if (r9 != null) goto L14;
        return;
    L14:
        a.a(r9).call("onMappingRequestStatus", new Class[]{String.class, Integer.TYPE}, new Object[]{r7, Integer.valueOf(r8)});     // Catch: Throwable -> L16
    }

    public void onMultiNetworkStateChanged(int r7, int r8) {
        if (CronetDependManager.inst().loggerDebug() == false) goto L19;
        CronetDependManager.inst().loggerD("CronetAppProviderManager", "onMultiNetworkStateChanged, prev state = " + r7 + ", curr state = " + r8);
    L19:
    L16:
        th = move-exception;
        th.printStackTrace();
        return;
    L6:
        if (f.d() == false) goto L11;
        ICronetAppProvider r6 = this.mCronetAppProvider;     // Catch: Throwable -> L16
        if (r6 != null) goto L10;
        return;
    L10:
        r6.onMultiNetworkStateChanged(r7, r8);     // Catch: Throwable -> L16
        return;
    L11:
        Object r9 = this.mCronetAppProviderAdapter;     // Catch: Throwable -> L16
        if (r9 != null) goto L14;
        return;
    L14:
        a.a(r9).call("onMultiNetworkStateChanged", new Class[]{Integer.TYPE, Integer.TYPE}, new Object[]{Integer.valueOf(r7), Integer.valueOf(r8)}).a();     // Catch: Throwable -> L16
    }

    public void onNetworkQualityLevelChanged(int r6) {
        if (CronetDependManager.inst().loggerDebug() == false) goto L19;
        CronetDependManager.inst().loggerD("CronetAppProviderManager", "onNetworkQualityLevelChanged, nql: " + r6);
    L19:
    L16:
        th = move-exception;
        th.printStackTrace();
        return;
    L6:
        if (f.d() == false) goto L11;
        ICronetAppProvider r5 = this.mCronetAppProvider;     // Catch: Throwable -> L16
        if (r5 != null) goto L10;
        return;
    L10:
        r5.onNetworkQualityLevelChangedOnIOThread(r6);     // Catch: Throwable -> L16
        return;
    L11:
        Object r7 = this.mCronetAppProviderAdapter;     // Catch: Throwable -> L16
        if (r7 != null) goto L14;
        return;
    L14:
        a.a(r7).call("onNetworkQualityLevelChangedOnIOThread", new Class[]{Integer.TYPE}, new Object[]{Integer.valueOf(r6)}).a();     // Catch: Throwable -> L16
    }

    public void onNetworkQualityRttAndThroughputNotified(int r8, int r9, int r10) {
        if (CronetDependManager.inst().loggerDebug() == false) goto L19;
        CronetDependManager.inst().loggerD("CronetAppProviderManager", "onNetworkQualityRttAndThroughputNotified, effectiveHrttMs: " + r8 + ", effectiveTrttMs: " + r9 + ", effectiveRxThroughputKbps: " + r10);
    L19:
    L16:
        th = move-exception;
        th.printStackTrace();
        return;
    L6:
        if (f.d() == false) goto L11;
        ICronetAppProvider r7 = this.mCronetAppProvider;     // Catch: Throwable -> L16
        if (r7 != null) goto L10;
        return;
    L10:
        r7.onNetworkQualityRttAndThroughputNotifiedOnIOThread(r8, r9, r10);     // Catch: Throwable -> L16
        return;
    L11:
        Object r11 = this.mCronetAppProviderAdapter;     // Catch: Throwable -> L16
        if (r11 != null) goto L14;
        return;
    L14:
        a.a(r11).call("onNetworkQualityRttAndThroughputNotifiedOnIOThread", new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE}, new Object[]{Integer.valueOf(r8), Integer.valueOf(r9), Integer.valueOf(r10)}).a();     // Catch: Throwable -> L16
    }

    public void onNetworkQualityTypeChangedV3(int r9) {
        if (CronetDependManager.inst().loggerDebug() == false) goto L20;
        CronetDependManager.inst().loggerD("CronetAppProviderManager", "onNetworkQualityTypeChangedV3, network_quality_type = " + r9);
    L20:
    L17:
        th = move-exception;
        th.printStackTrace();
        return;
    L7:
        if (f.d() == false) goto L12;
        ICronetAppProvider r8 = this.mCronetAppProvider;     // Catch: Throwable -> L17
        if (r8 != null) goto L11;
        return;
    L11:
        r8.onEffectiveConnectionTypeChangedOnIOThread(r9);     // Catch: Throwable -> L17
        a.a("com.bytedance.ttnet.NQEManager", null).call("notifyNQTChanged", new Class[]{Integer.TYPE}, new Object[]{Integer.valueOf(r9)});     // Catch: Throwable -> L17
        return;
    L12:
        Object r10 = this.mCronetAppProviderAdapter;     // Catch: Throwable -> L17
        if (r10 != null) goto L15;
        return;
    L15:
        a.a(r10).call("onEffectiveConnectionTypeChangedOnIOThread", new Class[]{Integer.TYPE}, new Object[]{Integer.valueOf(r9)});     // Catch: Throwable -> L17
        a.a("com.bytedance.ttnet.NQEManager").call("notifyNQTChanged", new Class[]{Integer.TYPE}, new Object[]{Integer.valueOf(r9)});     // Catch: Throwable -> L17
    }

    public void onPacketLossComputed(int r20, double r21, double r23, double r25, double r27) {
        if (CronetDependManager.inst().loggerDebug() == false) goto L20;
        CronetDependManager.inst().loggerD("CronetAppProviderManager", "onPacketLossComputed protocol = " + r20 + ", upstreamLossRate = " + r21 + ", upstreamLossRateVariance = " + r23 + ", downstreamLossRate = " + r25 + ", downstreamLossRateVariance = " + r27);
    L20:
    L17:
        th = move-exception;
        th.printStackTrace();
        return;
    L7:
        if (f.d() == false) goto L12;
        ICronetAppProvider r3 = this.mCronetAppProvider;     // Catch: Throwable -> L17
        if (r3 != null) goto L11;
        return;
    L11:
        r3.onPacketLossComputedOnIOThread(r20, r21, r23, r25, r27);     // Catch: Throwable -> L17
        return;
    L12:
        Object r0 = this.mCronetAppProviderAdapter;     // Catch: Throwable -> L17
        if (r0 != null) goto L15;
        return;
    L15:
        a.a(r0).call("onPacketLossComputedOnIOThread", new Class[]{Integer.TYPE, Double.TYPE, Double.TYPE, Double.TYPE, Double.TYPE}, new Object[]{Integer.valueOf(r20), Double.valueOf(r21), Double.valueOf(r23), Double.valueOf(r25), Double.valueOf(r27)});     // Catch: Throwable -> L17
    }

    public void onPublicIPsChanged(List<String> r7, List<String> r8) {
        List<String> r9 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
        List<String> r10 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin");
        if (CronetDependManager.inst().loggerDebug() == false) goto L19;
        CronetDependManager.inst().loggerD("CronetAppProviderManager", "onPublicIPsChanged ");
    L19:
    L16:
        th = move-exception;
        th.printStackTrace();
        return;
    L6:
        if (f.d() == false) goto L11;
        ICronetAppProvider r6 = this.mCronetAppProvider;     // Catch: Throwable -> L16
        if (r6 != null) goto L10;
        return;
    L10:
        r6.onPublicIPsChanged(r9, r10);     // Catch: Throwable -> L16
        return;
    L11:
        Object r11 = this.mCronetAppProviderAdapter;     // Catch: Throwable -> L16
        if (r11 != null) goto L14;
        return;
    L14:
        a.a(r11).call("onPublicIPsChanged", new Class[]{List.class, List.class}, new Object[]{r9, r10});     // Catch: Throwable -> L16
    }

    public void onRTTOrThroughputEstimatesComputed(int r8, int r9, int r10) {
        if (CronetDependManager.inst().loggerDebug() == false) goto L19;
        CronetDependManager.inst().loggerD("CronetAppProviderManager", "onRTTOrThroughputEstimatesComputed httpRtt = " + r8 + ", transportRttMs = " + r9 + ",downstreamThroughputKbps = " + r10);
    L19:
    L16:
        th = move-exception;
        th.printStackTrace();
        return;
    L6:
        if (f.d() == false) goto L11;
        ICronetAppProvider r7 = this.mCronetAppProvider;     // Catch: Throwable -> L16
        if (r7 != null) goto L10;
        return;
    L10:
        r7.onRTTOrThroughputEstimatesComputedOnIOThread(r8, r9, r10);     // Catch: Throwable -> L16
        return;
    L11:
        Object r11 = this.mCronetAppProviderAdapter;     // Catch: Throwable -> L16
        if (r11 != null) goto L14;
        return;
    L14:
        a.a(r11).call("onRTTOrThroughputEstimatesComputedOnIOThread", new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE}, new Object[]{Integer.valueOf(r8), Integer.valueOf(r9), Integer.valueOf(r10)});     // Catch: Throwable -> L16
    }

    public void onServerConfigUpdated(String r7, String r8, String r9) {
        if (CronetDependManager.inst().loggerDebug() == false) goto L19;
        CronetDependManager.inst().loggerD("CronetAppProviderManager", "onServerConfigUpdated json = " + r7);
    L19:
    L16:
        th = move-exception;
        th.printStackTrace();
        return;
    L6:
        if (f.d() == false) goto L11;
        ICronetAppProvider r0 = this.mCronetAppProvider;     // Catch: Throwable -> L16
        if (r0 != null) goto L10;
        return;
    L10:
        r0.onServerConfigEtagChanged(r8);     // Catch: Throwable -> L16
        this.mCronetAppProvider.onServerConfigABTestChanged(r9);     // Catch: Throwable -> L16
        this.mCronetAppProvider.onServerConfigUpdated(r7);     // Catch: Throwable -> L16
        return;
    L11:
        Object r1 = this.mCronetAppProviderAdapter;     // Catch: Throwable -> L16
        if (r1 != null) goto L14;
        return;
    L14:
        a.a(r1).call("onServerConfigEtagChanged", new Class[]{String.class}, new Object[]{r8});     // Catch: Throwable -> L16
        a.a(this.mCronetAppProviderAdapter).call("onServerConfigABTestChanged", new Class[]{String.class}, new Object[]{r9});     // Catch: Throwable -> L16
        a.a(this.mCronetAppProviderAdapter).call("onServerConfigUpdated", new Class[]{String.class}, new Object[]{r7});     // Catch: Throwable -> L16
    }

    public void onStoreIdcChanged(String r12, String r13, String r14, String r15, String r16, String r17) {
        if (CronetDependManager.inst().loggerDebug() == false) goto L19;
        CronetDependManager.inst().loggerD("CronetAppProviderManager", "onStoreIdcChanged ");
    L19:
    L16:
        th = move-exception;
        th.printStackTrace();
        return;
    L6:
        if (f.d() == false) goto L11;
        ICronetAppProvider r2 = this.mCronetAppProvider;     // Catch: Throwable -> L16
        if (r2 != null) goto L10;
        return;
    L10:
        r2.onStoreIdcChanged(r12, r13, r14, r15, r16, r17);     // Catch: Throwable -> L16
        return;
    L11:
        Object r0 = this.mCronetAppProviderAdapter;     // Catch: Throwable -> L16
        if (r0 != null) goto L14;
        return;
    L14:
        a.a(r0).call("onStoreIdcChanged", new Class[]{String.class, String.class, String.class, String.class, String.class, String.class}, new Object[]{r12, r13, r14, r15, r16, r17});     // Catch: Throwable -> L16
    }

    public void onTNCUpdateFailed(String[] r7, String r8) {
        if (CronetDependManager.inst().loggerDebug() == false) goto L5;
        CronetDependManager.inst().loggerD("CronetAppProviderManager", "onTNCUpdateFailed ");
    L5:
        if (r7 == null) goto L27;
    L20:
        th = move-exception;
        th.printStackTrace();
        return;
    L7:
        if (r7.length <= 0) goto L23;
        ArrayList<String> r0 = new ArrayList();     // Catch: Throwable -> L20
        Collections.addAll(r0, r7);     // Catch: Throwable -> L20
        if (f.d() == false) goto L15;
        ICronetAppProvider r6 = this.mCronetAppProvider;     // Catch: Throwable -> L20
        if (r6 != null) goto L14;
        return;
    L14:
        r6.onTNCUpdateFailed(r0, r8);     // Catch: Throwable -> L20
        goto L23
    L15:
        Object r9 = this.mCronetAppProviderAdapter;     // Catch: Throwable -> L20
        if (r9 != null) goto L18;
        return;
    L18:
        a.a(r9).call("onTNCUpdateFailed", new Class[]{ArrayList.class, String.class}, new Object[]{r0, r8});     // Catch: Throwable -> L20
    L23:
        return;
    }

    public void onTTDnsResolveResult(String r16, String r17, int r18, int r19, int r20, List<String> r21, String r22) {
        List<String> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r21, List.class, "com.obric.memorydata.plugin");
        if (CronetDependManager.inst().loggerDebug() == false) goto L19;
        CronetDependManager.inst().loggerD("CronetAppProviderManager", "onTTDnsResolveResult info uuid = " + r16 + " host: " + r17);
    L19:
    L16:
        th = move-exception;
        th.printStackTrace();
        return;
    L6:
        if (f.d() == false) goto L11;
        ICronetAppProvider r0 = this.mCronetAppProvider;     // Catch: Throwable -> L16
        if (r0 != null) goto L10;
        return;
    L10:
        r0.onTTDnsResolveResult(r16, r17, r18, r19, r20, r6, r22);     // Catch: Throwable -> L16
        return;
    L11:
        Object r1 = this.mCronetAppProviderAdapter;     // Catch: Throwable -> L16
        if (r1 != null) goto L14;
        return;
    L14:
        a.a(r1).call("onTTDnsResolveResult", new Class[]{String.class, String.class, Integer.TYPE, Integer.TYPE, Integer.TYPE, List.class, String.class}, new Object[]{r16, r17, Integer.valueOf(r18), Integer.valueOf(r19), Integer.valueOf(r20), r6, r22});     // Catch: Throwable -> L16
    }

    public void onTTNetDetectInfoChanged(String r6) {
        if (CronetDependManager.inst().loggerDebug() == false) goto L19;
        CronetDependManager.inst().loggerD("CronetAppProviderManager", "onTTNetDetectInfoChanged info str = " + r6);
    L19:
    L16:
        th = move-exception;
        th.printStackTrace();
        return;
    L6:
        if (f.d() == false) goto L11;
        ICronetAppProvider r5 = this.mCronetAppProvider;     // Catch: Throwable -> L16
        if (r5 != null) goto L10;
        return;
    L10:
        r5.onTTNetDetectInfoChanged(r6);     // Catch: Throwable -> L16
        return;
    L11:
        Object r7 = this.mCronetAppProviderAdapter;     // Catch: Throwable -> L16
        if (r7 != null) goto L14;
        return;
    L14:
        a.a(r7).call("onTTNetDetectInfoChanged", new Class[]{String.class}, new Object[]{r6});     // Catch: Throwable -> L16
    }

    public void onTncRequestSucceeded(boolean r8, boolean r9, int r10) {
    L13:
        th = move-exception;
        th.printStackTrace();
        return;
    L3:
        if (f.d() == false) goto L8;
        ICronetAppProvider r7 = this.mCronetAppProvider;     // Catch: Throwable -> L13
        if (r7 != null) goto L7;
        return;
    L7:
        r7.onTncRequestSucceeded(r8, r9, r10);     // Catch: Throwable -> L13
    L16:
        return;
    L8:
        Object r11 = this.mCronetAppProviderAdapter;     // Catch: Throwable -> L13
        if (r11 != null) goto L11;
        return;
    L11:
        a.a(r11).call("onTncRequestSucceeded", new Class[]{Boolean.TYPE, Boolean.TYPE, Integer.TYPE}, new Object[]{Boolean.valueOf(r8), Boolean.valueOf(r9), Integer.valueOf(r10)}).a();     // Catch: Throwable -> L13
        goto L16
    }

    public void onUserSpecifiedNetworkEnabled(boolean r6) {
        if (CronetDependManager.inst().loggerDebug() == false) goto L19;
        CronetDependManager.inst().loggerD("CronetAppProviderManager", "onUserSpecifiedNetworkEnabled, enable = " + r6);
    L19:
    L16:
        th = move-exception;
        th.printStackTrace();
        return;
    L6:
        if (f.d() == false) goto L11;
        ICronetAppProvider r5 = this.mCronetAppProvider;     // Catch: Throwable -> L16
        if (r5 != null) goto L10;
        return;
    L10:
        r5.onUserSpecifiedNetworkEnabled(r6);     // Catch: Throwable -> L16
        return;
    L11:
        Object r7 = this.mCronetAppProviderAdapter;     // Catch: Throwable -> L16
        if (r7 != null) goto L14;
        return;
    L14:
        a.a(r7).call("onUserSpecifiedNetworkEnabled", new Class[]{Boolean.TYPE}, new Object[]{Boolean.valueOf(r6)});     // Catch: Throwable -> L16
    }

    public void onWiFiToCellStateChanged(int r7, int r8) {
        if (CronetDependManager.inst().loggerDebug() == false) goto L19;
        CronetDependManager.inst().loggerD("CronetAppProviderManager", "onWiFiToCellStateChanged, prev state = " + r7 + ", curr state = " + r8);
    L19:
    L16:
        th = move-exception;
        th.printStackTrace();
        return;
    L6:
        if (f.d() == false) goto L11;
        ICronetAppProvider r6 = this.mCronetAppProvider;     // Catch: Throwable -> L16
        if (r6 != null) goto L10;
        return;
    L10:
        r6.onWiFiToCellStateChanged(r7, r8);     // Catch: Throwable -> L16
        return;
    L11:
        Object r9 = this.mCronetAppProviderAdapter;     // Catch: Throwable -> L16
        if (r9 != null) goto L14;
        return;
    L14:
        a.a(r9).call("onWiFiToCellStateChanged", new Class[]{Integer.TYPE, Integer.TYPE}, new Object[]{Integer.valueOf(r7), Integer.valueOf(r8)}).a();     // Catch: Throwable -> L16
    }

    public void sendAppMonitorEvent(String r7, String r8) {
        if (CronetDependManager.inst().loggerDebug() == false) goto L19;
        CronetDependManager.inst().loggerD("CronetAppProviderManager", "Send monitor json = " + r7 + ", log type =" + r8);
    L19:
    L16:
        th = move-exception;
        th.printStackTrace();
        return;
    L6:
        if (f.d() == false) goto L11;
        ICronetAppProvider r6 = this.mCronetAppProvider;     // Catch: Throwable -> L16
        if (r6 != null) goto L10;
        return;
    L10:
        r6.sendAppMonitorEvent(r7, r8);     // Catch: Throwable -> L16
        return;
    L11:
        Object r9 = this.mCronetAppProviderAdapter;     // Catch: Throwable -> L16
        if (r9 != null) goto L14;
        return;
    L14:
        a.a(r9).call("sendAppMonitorEvent", new Class[]{String.class, String.class}, new Object[]{r7, r8});     // Catch: Throwable -> L16
    }

    public void setAdapter(Object r5) {
        if (r5 == null) goto L23;
        Class<?> r1 = r5.getClass();     // Catch: Throwable -> L29
        if (r1 != null) goto L7;
        return;
    L7:
        List r2 = Utils.getAllInterfaces(r1);     // Catch: Throwable -> L29
        if (r2 != null) goto L10;
        return;
    L10:
        if (r2.isEmpty() == true) goto L37;
        Iterator r3 = r2.iterator();     // Catch: Throwable -> L29
    L14:
        if (r3.hasNext() == false) goto L23;
        if (ADAPTER_CLASS_NAME.equals(((Class) ZeusTransformUtils.preCheckCast(r3.next(), Class.class, "com.obric.memorydata.plugin")).getName()) == false) goto L14;
        if (CronetDependManager.inst().loggerDebug() == false) goto L20;
        CronetDependManager.inst().loggerD("CronetAppProviderManager", "inject CronetAppProviderManager success");     // Catch: Throwable -> L29
    L20:
        this.mCronetAppProviderAdapter = r5;     // Catch: Throwable -> L29
        goto L23
    L37:
        return;
    L29:
        th = move-exception;
        th.printStackTrace();
        return;
    L23:
        if (ZeusTransformUtils.instanceOf(r5, ICronetAppProvider.class) == false) goto L26;
        this.mCronetAppProvider = (ICronetAppProvider) ZeusTransformUtils.preCheckCast(r5, ICronetAppProvider.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L29
    L26:
        if (ZeusTransformUtils.instanceOf(r5, ICronetDepend.class) == false) goto L38;
        this.mCronetDepend = (ICronetDepend) ZeusTransformUtils.preCheckCast(r5, ICronetDepend.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L29
        return;
    }
}
