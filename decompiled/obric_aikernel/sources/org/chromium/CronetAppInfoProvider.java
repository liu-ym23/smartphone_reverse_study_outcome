package org.chromium;

import android.content.Context;
import android.text.TextUtils;
import c3.b;
import com.bytedance.apm6.util.constant.NetConst;
import com.bytedance.apm6.util.constant.ReportConsts;
import com.bytedance.frameworks.baselib.network.http.util.i;
import com.bytedance.ttnet.TTNetInit;
import com.ttnet.org.chromium.net.TTAppInfoProvider;
import java.net.CookieHandler;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class CronetAppInfoProvider extends TTAppInfoProvider {
    private static final String COOKIE_HEADER_KEY = "Cookie";
    private static final int MAX_ABSDK_VERSION_LENGTH = 5;
    private static CronetAppInfoProvider sInstance;
    private TTAppInfoProvider.AppInfo mAppInfo;
    private Context mContext;

    private CronetAppInfoProvider(Context r10) {
        this.mContext = r10.getApplicationContext();
    }

    private String getCookieHeaderForTncRequest(String r10) {
        CookieHandler r11 = CookieHandler.getDefault();
        if (TextUtils.isEmpty(r10) == true) goto L26;
        if (r11 == null) goto L26;
        Map<String, List<String>> r12 = r11.get(i.a(ReportConsts.HTTPS + r10), null);     // Catch: Throwable -> L27
        if (r12 == null) goto L26;
        if (r12.size() <= 0) goto L26;
        Iterator<Map.Entry<String, List<String>>> r13 = r12.entrySet().iterator();     // Catch: Throwable -> L27
    L12:
        if (r13.hasNext() == false) goto L26;
        Map.Entry<String, List<String>> r14 = r13.next();     // Catch: Throwable -> L27
        if (COOKIE_HEADER_KEY.equalsIgnoreCase(r14.getKey()) == false) goto L12;
        if (r14.getValue().isEmpty() == true) goto L12;
        StringBuilder r15 = new StringBuilder();     // Catch: Throwable -> L27
        int r16 = 0;
        Iterator<String> r17 = r14.getValue().iterator();     // Catch: Throwable -> L27
    L19:
        if (r17.hasNext() == false) goto L24;
        String r18 = r17.next();     // Catch: Throwable -> L27
        if (r16 <= 0) goto L23;
        r15.append("; ");     // Catch: Throwable -> L27
    L23:
        r15.append(r18);     // Catch: Throwable -> L27
        r16 = r16 + 1;     // Catch: Throwable -> L27
        goto L19
    L24:
        return r15.toString();
    L26:
        return null;
    }

    public static CronetAppInfoProvider inst(Context r10) {
        if (sInstance != null) goto L15;
        monitor-enter(CronetAppInfoProvider.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new CronetAppInfoProvider(r10);     // Catch: Throwable -> L11
    L9:
        monitor-exit(CronetAppInfoProvider.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    private static String toLowerCase(String r10) {
        if (TextUtils.isEmpty(r10) == false) goto L6;
        return r10;
    L6:
        return r10.toLowerCase();
    }

    @Override // com.ttnet.org.chromium.net.TTAppInfoProvider
    public TTAppInfoProvider.AppInfo getAppInfo() {
        monitor-enter(CronetAppInfoProvider.class);     // Catch: Throwable -> L64
    L61:
        th = move-exception;
        throw th;     // Catch: Throwable -> L64
    L5:
        if (this.mAppInfo != null) goto L7;
        this.mAppInfo = new TTAppInfoProvider.AppInfo();     // Catch: Throwable -> L61
    L7:
        monitor-exit(CronetAppInfoProvider.class);     // Catch: Throwable -> L61
        this.mAppInfo.setAppId(CronetAppProviderManager.inst().getAppId());     // Catch: Throwable -> L64
        this.mAppInfo.setAppName(CronetAppProviderManager.inst().getAppName());     // Catch: Throwable -> L64
        this.mAppInfo.setSdkAppID(CronetAppProviderManager.inst().getSdkAppId());     // Catch: Throwable -> L64
        this.mAppInfo.setSdkVersion(CronetAppProviderManager.inst().getSdkVersion());     // Catch: Throwable -> L64
        this.mAppInfo.setChannel(CronetAppProviderManager.inst().getChannel());     // Catch: Throwable -> L64
        this.mAppInfo.setDeviceId(CronetAppProviderManager.inst().getDeviceId());     // Catch: Throwable -> L64
        this.mAppInfo.setIsDropFirstTnc(CronetAppProviderManager.inst().getIsDropFirstTnc());     // Catch: Throwable -> L64
        this.mAppInfo.setAbi(CronetAppProviderManager.inst().getAbi());     // Catch: Throwable -> L64
        this.mAppInfo.setDevicePlatform(CronetAppProviderManager.inst().getDevicePlatform());     // Catch: Throwable -> L64
        this.mAppInfo.setDeviceType(CronetAppProviderManager.inst().getDeviceType());     // Catch: Throwable -> L64
        this.mAppInfo.setDeviceBrand(CronetAppProviderManager.inst().getDeviceBrand());     // Catch: Throwable -> L64
        this.mAppInfo.setDeviceModel(CronetAppProviderManager.inst().getDeviceModel());     // Catch: Throwable -> L64
        this.mAppInfo.setNetAccessType(CronetAppProviderManager.inst().getNetAccessType());     // Catch: Throwable -> L64
        this.mAppInfo.setOSApi(CronetAppProviderManager.inst().getOSApi());     // Catch: Throwable -> L64
        this.mAppInfo.setOSVersion(CronetAppProviderManager.inst().getOSVersion());     // Catch: Throwable -> L64
        this.mAppInfo.setUserId(CronetAppProviderManager.inst().getUserId());     // Catch: Throwable -> L64
        this.mAppInfo.setVersionCode(CronetAppProviderManager.inst().getVersionCode());     // Catch: Throwable -> L64
        this.mAppInfo.setVersionName(CronetAppProviderManager.inst().getVersionName());     // Catch: Throwable -> L64
        this.mAppInfo.setUpdateVersionCode(CronetAppProviderManager.inst().getUpdateVersionCode());     // Catch: Throwable -> L64
        this.mAppInfo.setManifestVersionCode(CronetAppProviderManager.inst().getManifestVersionCode());     // Catch: Throwable -> L64
        this.mAppInfo.setStoreIdc(CronetAppProviderManager.inst().getStoreIdc());     // Catch: Throwable -> L64
        this.mAppInfo.setRegion(toLowerCase(CronetAppProviderManager.inst().getRegion()));     // Catch: Throwable -> L64
        this.mAppInfo.setSysRegion(toLowerCase(CronetAppProviderManager.inst().getSysRegion()));     // Catch: Throwable -> L64
        this.mAppInfo.setCarrierRegion(toLowerCase(CronetAppProviderManager.inst().getCarrierRegion()));     // Catch: Throwable -> L64
        this.mAppInfo.setInitRegion(CronetAppProviderManager.inst().getInitRegion());     // Catch: Throwable -> L64
        this.mAppInfo.setTNCRequestFlags(CronetAppProviderManager.inst().getTNCRequestFlags());     // Catch: Throwable -> L64
        this.mAppInfo.setHttpDnsRequestFlags(CronetAppProviderManager.inst().getHttpDnsRequestFlags());     // Catch: Throwable -> L64
        TTAppInfoProvider.AppInfo r10 = this.mAppInfo;     // Catch: Throwable -> L64
        if (b.n() == false) goto L11;
        String r11 = NetConst.ENCRYPT_VERISON_CODE;
    L12:
        r10.setIsDomestic(r11);     // Catch: Throwable -> L64
        Map<String, String> r12 = CronetAppProviderManager.inst().getGetDomainDependHostMap();     // Catch: Throwable -> L64
        if (r12 != null) goto L15;
    L17:
        Map<String, String> r13 = CronetAppProviderManager.inst().getTNCRequestHeader();     // Catch: Throwable -> L64
        String r14 = "";
        if (r13 != null) goto L20;
    L25:
        String r15 = "";
        if (r12 == null) goto L31;
        if (r12.isEmpty() == true) goto L31;
        r15 = getCookieHeaderForTncRequest(r12.get("first"));     // Catch: Throwable -> L64
    L31:
        if (TextUtils.isEmpty(r15) == true) goto L33;
        r14 = "Cookie:" + r15 + "\r\n" + r14;     // Catch: Throwable -> L64
    L33:
        this.mAppInfo.setTNCRequestHeader(r14);     // Catch: Throwable -> L64
        Map<String, String> r16 = CronetAppProviderManager.inst().getTNCRequestQuery();     // Catch: Throwable -> L64
        String r17 = "";
        if (r16 != null) goto L36;
    L41:
        this.mAppInfo.setTNCRequestQuery(r17);     // Catch: Throwable -> L64
        List<String> r18 = CronetAppProviderManager.inst().getAbSdkVersion();     // Catch: Throwable -> L64
        String r19 = "";
        if (r18 != null) goto L44;
    L57:
        this.mAppInfo.setAbSdkVersion(r19);     // Catch: Throwable -> L64
        if (CronetDependManager.inst().loggerDebug() == false) goto L67;
        String r20 = "AppInfo{, mUserId='" + this.mAppInfo.getUserId() + "', mAppId='" + this.mAppInfo.getAppId() + "', mOSApi='" + this.mAppInfo.getOSApi() + "', mDeviceId='" + this.mAppInfo.getDeviceId() + "', mNetAccessType='" + this.mAppInfo.getNetAccessType() + "', mVersionCode='" + this.mAppInfo.getVersionCode() + "', mDeviceType='" + this.mAppInfo.getDeviceType() + "', mAppName='" + this.mAppInfo.getAppName() + "', mSdkAppID='" + this.mAppInfo.getSdkAppID() + "', mSdkVersion='" + this.mAppInfo.getSdkVersion() + "', mChannel='" + this.mAppInfo.getChannel() + "', mOSVersion='" + this.mAppInfo.getOSVersion() + "', mAbi='" + this.mAppInfo.getAbi() + "', mDevicePlatform='" + this.mAppInfo.getDevicePlatform() + "', mDeviceBrand='" + this.mAppInfo.getDeviceBrand() + "', mDeviceModel='" + this.mAppInfo.getDeviceModel() + "', mVersionName='" + this.mAppInfo.getVersionName() + "', mUpdateVersionCode='" + this.mAppInfo.getUpdateVersionCode() + "', mManifestVersionCode='" + this.mAppInfo.getManifestVersionCode() + "'}";     // Catch: Throwable -> L64
        CronetDependManager.inst().loggerD("CronetAppInfoProvider", "get appinfo = " + r20);     // Catch: Throwable -> L64
    L67:
        return this.mAppInfo;
    L44:
        if (r18.size() > 5) goto L46;
    L48:
        int r21 = 0;
        Iterator<String> r22 = r18.iterator();     // Catch: Throwable -> L64
    L50:
        if (r22.hasNext() == false) goto L57;
        String r23 = r22.next();     // Catch: Throwable -> L64
        r21 = r21 + 1;     // Catch: Throwable -> L64
        if (r21 > 5) goto L57;
        if (TextUtils.isEmpty(r23) == true) goto L50;
        r19 = r19 + r23 + ",";     // Catch: Throwable -> L64
        goto L50
    L46:
        if (CronetDependManager.inst().loggerDebug() == false) goto L48;
        CronetDependManager.inst().loggerD("CronetAppInfoProvider", "ab sdk version count must less than 5");     // Catch: Throwable -> L64
        goto L48
    L36:
        if (r16.isEmpty() == true) goto L41;
        Iterator<Map.Entry<String, String>> r24 = r16.entrySet().iterator();     // Catch: Throwable -> L64
    L39:
        if (r24.hasNext() == false) goto L41;
        Map.Entry<String, String> r25 = r24.next();     // Catch: Throwable -> L64
        r17 = r25.getKey() + ":" + r25.getValue() + "\r\n" + r17;     // Catch: Throwable -> L64
        goto L39
    L20:
        if (r13.isEmpty() == true) goto L25;
        Iterator<Map.Entry<String, String>> r26 = r13.entrySet().iterator();     // Catch: Throwable -> L64
    L23:
        if (r26.hasNext() == false) goto L25;
        Map.Entry<String, String> r27 = r26.next();     // Catch: Throwable -> L64
        r14 = r27.getKey() + ":" + r27.getValue() + "\r\n" + r14;     // Catch: Throwable -> L64
        goto L23
    L15:
        if (r12.isEmpty() == true) goto L17;
        this.mAppInfo.setHostFirst(r12.get("first"));     // Catch: Throwable -> L64
        this.mAppInfo.setHostSecond(r12.get("second"));     // Catch: Throwable -> L64
        this.mAppInfo.setHostThird(r12.get("third"));     // Catch: Throwable -> L64
        this.mAppInfo.setDomainHttpDns(r12.get("httpdns"));     // Catch: Throwable -> L64
        this.mAppInfo.setDomainBoe(r12.get(TTNetInit.DOMAIN_BOE_KEY));     // Catch: Throwable -> L64
        this.mAppInfo.setDomainBoeHttps(r12.get(TTNetInit.DOMAIN_BOE_HTTPS_KEY));     // Catch: Throwable -> L64
        goto L17
    L11:
        r11 = NetConst.NOT_ENCRYPT_VERISON_CODE;
        goto L12
    L64:
        th = move-exception;
        th.printStackTrace();
        goto L67
    }
}
