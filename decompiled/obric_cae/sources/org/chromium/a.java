package org.chromium;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.ttnet.TTNetInit;
import com.obric.cae.smartBluetooth.deviceIdentification.bdim.BdimCategoryConstants;
import com.ttnet.org.chromium.base.Reflect;
import com.ttnet.org.chromium.net.TTAppInfoProvider;
import java.net.CookieHandler;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends TTAppInfoProvider {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static a f9791c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TTAppInfoProvider.AppInfo f9792a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f9793b;

    public a(Context r8) {
        this.f9793b = r8.getApplicationContext();
    }

    public static String a(String r8) {
        CookieHandler r10 = CookieHandler.getDefault();
        if (TextUtils.isEmpty(r8) == true) goto L26;
        if (r10 == null) goto L26;
        Map<String, List<String>> r11 = r10.get(t2.b.s("https://" + r8), null);     // Catch: Throwable -> L27
        if (r11 == null) goto L26;
        if (r11.size() <= 0) goto L26;
        Iterator<Map.Entry<String, List<String>>> r12 = r11.entrySet().iterator();     // Catch: Throwable -> L27
    L12:
        if (r12.hasNext() == false) goto L26;
        Map.Entry<String, List<String>> r13 = r12.next();     // Catch: Throwable -> L27
        if ("Cookie".equalsIgnoreCase(r13.getKey()) == false) goto L12;
        if (r13.getValue().isEmpty() == true) goto L12;
        StringBuilder r14 = new StringBuilder();     // Catch: Throwable -> L27
        Iterator<String> r15 = r13.getValue().iterator();     // Catch: Throwable -> L27
        int r16 = 0;
    L19:
        if (r15.hasNext() == false) goto L24;
        String r17 = r15.next();     // Catch: Throwable -> L27
        if (r16 <= 0) goto L23;
        r14.append("; ");     // Catch: Throwable -> L27
    L23:
        r14.append(r17);     // Catch: Throwable -> L27
        r16 = r16 + 1;     // Catch: Throwable -> L27
        goto L19
    L24:
        return r14.toString();
    L26:
        return null;
    }

    @Override // com.ttnet.org.chromium.net.TTAppInfoProvider
    public final TTAppInfoProvider.AppInfo getAppInfo() {
        monitor-enter(a.class);     // Catch: Throwable -> L68
    L65:
        th = move-exception;
        throw th;     // Catch: Throwable -> L68
    L5:
        if (this.f9792a != null) goto L7;
        this.f9792a = new TTAppInfoProvider.AppInfo();     // Catch: Throwable -> L65
    L7:
        monitor-exit(a.class);     // Catch: Throwable -> L65
        this.f9792a.setAppId(c.c().a("getAppId"));     // Catch: Throwable -> L68
        this.f9792a.setAppName(c.c().a("getAppName"));     // Catch: Throwable -> L68
        this.f9792a.setSdkAppID(c.c().a("getSdkAppId"));     // Catch: Throwable -> L68
        this.f9792a.setSdkVersion(c.c().a("getSdkVersion"));     // Catch: Throwable -> L68
        this.f9792a.setChannel(c.c().a("getChannel"));     // Catch: Throwable -> L68
        this.f9792a.setDeviceId(c.c().a("getDeviceId"));     // Catch: Throwable -> L68
        if (f.c(this.f9793b) == false) goto L11;
        TTAppInfoProvider.AppInfo r8 = this.f9792a;     // Catch: Throwable -> L68
        String r10 = "1";
    L12:
        r8.setIsMainProcess(r10);     // Catch: Throwable -> L68
        this.f9792a.setAbi(c.c().a("getAbi"));     // Catch: Throwable -> L68
        this.f9792a.setDevicePlatform(c.c().a("getDevicePlatform"));     // Catch: Throwable -> L68
        this.f9792a.setDeviceType(c.c().a("getDeviceType"));     // Catch: Throwable -> L68
        this.f9792a.setDeviceBrand(c.c().a("getDeviceBrand"));     // Catch: Throwable -> L68
        this.f9792a.setDeviceModel(c.c().a("getDeviceModel"));     // Catch: Throwable -> L68
        this.f9792a.setNetAccessType(c.c().a("getNetAccessType"));     // Catch: Throwable -> L68
        this.f9792a.setOSApi(c.c().a("getOSApi"));     // Catch: Throwable -> L68
        this.f9792a.setOSVersion(c.c().a("getOSVersion"));     // Catch: Throwable -> L68
        this.f9792a.setUserId(c.c().a("getUserId"));     // Catch: Throwable -> L68
        this.f9792a.setVersionCode(c.c().a("getVersionCode"));     // Catch: Throwable -> L68
        this.f9792a.setVersionName(c.c().a("getVersionName"));     // Catch: Throwable -> L68
        this.f9792a.setUpdateVersionCode(c.c().a("getUpdateVersionCode"));     // Catch: Throwable -> L68
        this.f9792a.setManifestVersionCode(c.c().a("getManifestVersionCode"));     // Catch: Throwable -> L68
        this.f9792a.setStoreIdc(c.c().a("getStoreIdc"));     // Catch: Throwable -> L68
        this.f9792a.setRegion(c.c().a("getRegion"));     // Catch: Throwable -> L68
        this.f9792a.setSysRegion(c.c().a("getSysRegion"));     // Catch: Throwable -> L68
        this.f9792a.setCarrierRegion(c.c().a("getCarrierRegion"));     // Catch: Throwable -> L68
        this.f9792a.setTNCRequestFlags(c.c().a("getTNCRequestFlags"));     // Catch: Throwable -> L68
        this.f9792a.setHttpDnsRequestFlags(c.c().a("getHttpDnsRequestFlags"));     // Catch: Throwable -> L68
        c r11 = c.c();     // Catch: Throwable -> L68
        r11.getClass();     // Catch: Throwable -> L68
        Object r12 = r11.f9796a;     // Catch: Throwable -> L18
        if (r12 != null) goto L16;
        Map r13 = Collections.emptyMap();     // Catch: Throwable -> L18
    L74:
    L20:
        if (r13 != null) goto L22;
    L24:
        c r14 = c.c();     // Catch: Throwable -> L68
        r14.getClass();     // Catch: Throwable -> L68
        Map r15 = null;
        Object r16 = r14.f9796a;     // Catch: Throwable -> L31
        if (r16 == null) goto L33;
        Map r17 = (Map) Reflect.on(r16).call("getTNCRequestHeader").get();     // Catch: Throwable -> L31
    L34:
        String r18 = "";
        if (r17 != null) goto L37;
    L42:
        String r19 = a((String) r13.get("first"));     // Catch: Throwable -> L68
        if (TextUtils.isEmpty(r19) == true) goto L45;
        r18 = "Cookie:" + r19 + "\r\n" + r18;     // Catch: Throwable -> L68
    L45:
        this.f9792a.setTNCRequestHeader(r18);     // Catch: Throwable -> L68
        c r20 = c.c();     // Catch: Throwable -> L68
        r20.getClass();     // Catch: Throwable -> L68
        Object r21 = r20.f9796a;     // Catch: Throwable -> L51
        if (r21 == null) goto L53;
        r15 = (Map) Reflect.on(r21).call("getTNCRequestQuery").get();     // Catch: Throwable -> L51
        goto L53
    L53:
        String r22 = "";
        if (r15 != null) goto L56;
    L61:
        this.f9792a.setTNCRequestQuery(r22);     // Catch: Throwable -> L68
        if (d.a().loggerDebug() == false) goto L71;
        String r23 = "AppInfo{, mUserId='" + this.f9792a.getUserId() + "', mAppId='" + this.f9792a.getAppId() + "', mOSApi='" + this.f9792a.getOSApi() + "', mDeviceId='" + this.f9792a.getDeviceId() + "', mNetAccessType='" + this.f9792a.getNetAccessType() + "', mVersionCode='" + this.f9792a.getVersionCode() + "', mDeviceType='" + this.f9792a.getDeviceType() + "', mAppName='" + this.f9792a.getAppName() + "', mSdkAppID='" + this.f9792a.getSdkAppID() + "', mSdkVersion='" + this.f9792a.getSdkVersion() + "', mChannel='" + this.f9792a.getChannel() + "', mOSVersion='" + this.f9792a.getOSVersion() + "', mAbi='" + this.f9792a.getAbi() + "', mDevicePlatform='" + this.f9792a.getDevicePlatform() + "', mDeviceBrand='" + this.f9792a.getDeviceBrand() + "', mDeviceModel='" + this.f9792a.getDeviceModel() + "', mVersionName='" + this.f9792a.getVersionName() + "', mUpdateVersionCode='" + this.f9792a.getUpdateVersionCode() + "', mManifestVersionCode='" + this.f9792a.getManifestVersionCode() + "', mHostFirst='" + this.f9792a.getHostFirst() + "', mHostSecond='" + this.f9792a.getHostSecond() + "', mHostThird='" + this.f9792a.getHostThird() + "', mDomainHttpDns='" + this.f9792a.getDomainHttpDns() + "', mDomainNetlog='" + this.f9792a.getDomainNetlog() + "', mDomainBoe='" + this.f9792a.getDomainBoe() + "'}";     // Catch: Throwable -> L68
        d.a().loggerD("CronetAppInfoProvider", "get appinfo = " + r23);     // Catch: Throwable -> L68
    L71:
        return this.f9792a;
    L56:
        if (r15.isEmpty() == true) goto L61;
        Iterator r24 = r15.entrySet().iterator();     // Catch: Throwable -> L68
    L59:
        if (r24.hasNext() == false) goto L61;
        Map.Entry r25 = (Map.Entry) r24.next();     // Catch: Throwable -> L68
        r22 = ((String) r25.getKey()) + BdimCategoryConstants.SEPARATOR_COLON + ((String) r25.getValue()) + "\r\n" + r22;     // Catch: Throwable -> L68
    L51:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L68
        goto L53
    L37:
        if (r17.isEmpty() == true) goto L42;
        Iterator r26 = r17.entrySet().iterator();     // Catch: Throwable -> L68
    L40:
        if (r26.hasNext() == false) goto L42;
        Map.Entry r27 = (Map.Entry) r26.next();     // Catch: Throwable -> L68
        r18 = ((String) r27.getKey()) + BdimCategoryConstants.SEPARATOR_COLON + ((String) r27.getValue()) + "\r\n" + r18;     // Catch: Throwable -> L68
        goto L40
    L33:
        r17 = null;
    L31:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L68
        goto L33
    L22:
        if (r13.isEmpty() == true) goto L24;
        this.f9792a.setHostFirst((String) r13.get("first"));     // Catch: Throwable -> L68
        this.f9792a.setHostSecond((String) r13.get("second"));     // Catch: Throwable -> L68
        this.f9792a.setHostThird((String) r13.get("third"));     // Catch: Throwable -> L68
        this.f9792a.setDomainHttpDns((String) r13.get("httpdns"));     // Catch: Throwable -> L68
        this.f9792a.setDomainNetlog((String) r13.get(TTNetInit.DOMAIN_NETLOG_KEY));     // Catch: Throwable -> L68
        this.f9792a.setDomainBoe((String) r13.get(TTNetInit.DOMAIN_BOE_KEY));     // Catch: Throwable -> L68
        this.f9792a.setDomainBoeHttps((String) r13.get(TTNetInit.DOMAIN_BOE_HTTPS_KEY));     // Catch: Throwable -> L68
        goto L24
    L16:
        r13 = (Map) Reflect.on(r12).call("getGetDomainDependHostMap").get();     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L68
        r13 = Collections.emptyMap();     // Catch: Throwable -> L68
        goto L20
    L11:
        r8 = this.f9792a;     // Catch: Throwable -> L68
        r10 = "0";
        goto L12
    L68:
        th = move-exception;
        th.printStackTrace();
        goto L71
    }
}
