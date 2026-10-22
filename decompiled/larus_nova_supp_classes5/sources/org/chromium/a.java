package org.chromium;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.frameworks.baselib.network.http.NetworkParams;
import com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider;
import com.bytedance.frameworks.baselib.network.http.util.l;
import com.ttnet.org.chromium.net.TTAppInfoProvider;
import java.net.CookieHandler;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class a extends TTAppInfoProvider {
    public static a b;
    public TTAppInfoProvider.AppInfo a;

    public final TTAppInfoProvider.AppInfo getAppInfo() {
        monitor-enter(a.class);     // Catch: Throwable -> L285
    L282:
        th = move-exception;
        throw th;     // Catch: Throwable -> L285
    L5:
        if (this.a != null) goto L7;
        this.a = new TTAppInfoProvider.AppInfo();     // Catch: Throwable -> L282
    L7:
        monitor-exit(a.class);     // Catch: Throwable -> L282
        TTAppInfoProvider.AppInfo r0 = this.a;     // Catch: Throwable -> L285
        c r1 = c.h();     // Catch: Throwable -> L285
        r1.getClass();     // Catch: Throwable -> L285
        if (NetworkParams.getOptReflection() == false) goto L14;
        ICronetAppProvider r2 = r1.b;     // Catch: Throwable -> L285
        if (r2 != null) goto L13;
        String r3 = "";
    L15:
        r0.setAppId(r3);     // Catch: Throwable -> L285
        TTAppInfoProvider.AppInfo r4 = this.a;     // Catch: Throwable -> L285
        c r5 = c.h();     // Catch: Throwable -> L285
        r5.getClass();     // Catch: Throwable -> L285
        if (NetworkParams.getOptReflection() == false) goto L21;
        ICronetAppProvider r6 = r5.b;     // Catch: Throwable -> L285
        if (r6 != null) goto L20;
        String r7 = "";
    L22:
        r4.setAppName(r7);     // Catch: Throwable -> L285
        TTAppInfoProvider.AppInfo r8 = this.a;     // Catch: Throwable -> L285
        c r9 = c.h();     // Catch: Throwable -> L285
        r9.getClass();     // Catch: Throwable -> L285
        if (NetworkParams.getOptReflection() == false) goto L28;
        ICronetAppProvider r10 = r9.b;     // Catch: Throwable -> L285
        if (r10 != null) goto L27;
        String r11 = "";
    L29:
        r8.setSdkAppID(r11);     // Catch: Throwable -> L285
        TTAppInfoProvider.AppInfo r12 = this.a;     // Catch: Throwable -> L285
        c r13 = c.h();     // Catch: Throwable -> L285
        r13.getClass();     // Catch: Throwable -> L285
        if (NetworkParams.getOptReflection() == false) goto L35;
        ICronetAppProvider r14 = r13.b;     // Catch: Throwable -> L285
        if (r14 != null) goto L34;
        String r15 = "";
    L36:
        r12.setSdkVersion(r15);     // Catch: Throwable -> L285
        TTAppInfoProvider.AppInfo r16 = this.a;     // Catch: Throwable -> L285
        c r17 = c.h();     // Catch: Throwable -> L285
        r17.getClass();     // Catch: Throwable -> L285
        if (NetworkParams.getOptReflection() == false) goto L42;
        ICronetAppProvider r18 = r17.b;     // Catch: Throwable -> L285
        if (r18 != null) goto L41;
        String r19 = "";
    L43:
        r16.setChannel(r19);     // Catch: Throwable -> L285
        TTAppInfoProvider.AppInfo r20 = this.a;     // Catch: Throwable -> L285
        c r21 = c.h();     // Catch: Throwable -> L285
        r21.getClass();     // Catch: Throwable -> L285
        if (NetworkParams.getOptReflection() == false) goto L49;
        ICronetAppProvider r22 = r21.b;     // Catch: Throwable -> L285
        if (r22 != null) goto L48;
        String r23 = "";
    L50:
        r20.setDeviceId(r23);     // Catch: Throwable -> L285
        TTAppInfoProvider.AppInfo r24 = this.a;     // Catch: Throwable -> L285
        c r25 = c.h();     // Catch: Throwable -> L285
        r25.getClass();     // Catch: Throwable -> L285
    L62:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L285
        String r26 = "";
    L64:
        r24.setIsDropFirstTnc(r26);     // Catch: Throwable -> L285
        TTAppInfoProvider.AppInfo r27 = this.a;     // Catch: Throwable -> L285
        c r28 = c.h();     // Catch: Throwable -> L285
        r28.getClass();     // Catch: Throwable -> L285
        if (NetworkParams.getOptReflection() == false) goto L70;
        ICronetAppProvider r29 = r28.b;     // Catch: Throwable -> L285
        if (r29 != null) goto L69;
        String r30 = "";
    L71:
        r27.setAbi(r30);     // Catch: Throwable -> L285
        TTAppInfoProvider.AppInfo r31 = this.a;     // Catch: Throwable -> L285
        c r32 = c.h();     // Catch: Throwable -> L285
        r32.getClass();     // Catch: Throwable -> L285
        if (NetworkParams.getOptReflection() == false) goto L77;
        ICronetAppProvider r33 = r32.b;     // Catch: Throwable -> L285
        if (r33 != null) goto L76;
        String r34 = "";
    L78:
        r31.setDevicePlatform(r34);     // Catch: Throwable -> L285
        TTAppInfoProvider.AppInfo r35 = this.a;     // Catch: Throwable -> L285
        c r36 = c.h();     // Catch: Throwable -> L285
        r36.getClass();     // Catch: Throwable -> L285
        if (NetworkParams.getOptReflection() == false) goto L84;
        ICronetAppProvider r37 = r36.b;     // Catch: Throwable -> L285
        if (r37 != null) goto L83;
        String r38 = "";
    L85:
        r35.setDeviceType(r38);     // Catch: Throwable -> L285
        TTAppInfoProvider.AppInfo r39 = this.a;     // Catch: Throwable -> L285
        c r40 = c.h();     // Catch: Throwable -> L285
        r40.getClass();     // Catch: Throwable -> L285
        if (NetworkParams.getOptReflection() == false) goto L91;
        ICronetAppProvider r41 = r40.b;     // Catch: Throwable -> L285
        if (r41 != null) goto L90;
        String r42 = "";
    L92:
        r39.setDeviceBrand(r42);     // Catch: Throwable -> L285
        TTAppInfoProvider.AppInfo r43 = this.a;     // Catch: Throwable -> L285
        c r44 = c.h();     // Catch: Throwable -> L285
        r44.getClass();     // Catch: Throwable -> L285
        if (NetworkParams.getOptReflection() == false) goto L98;
        ICronetAppProvider r45 = r44.b;     // Catch: Throwable -> L285
        if (r45 != null) goto L97;
        String r46 = "";
    L99:
        r43.setDeviceModel(r46);     // Catch: Throwable -> L285
        TTAppInfoProvider.AppInfo r47 = this.a;     // Catch: Throwable -> L285
        c r48 = c.h();     // Catch: Throwable -> L285
        r48.getClass();     // Catch: Throwable -> L285
        if (NetworkParams.getOptReflection() == false) goto L105;
        ICronetAppProvider r49 = r48.b;     // Catch: Throwable -> L285
        if (r49 != null) goto L104;
        String r50 = "";
    L106:
        r47.setNetAccessType(r50);     // Catch: Throwable -> L285
        TTAppInfoProvider.AppInfo r51 = this.a;     // Catch: Throwable -> L285
        c r52 = c.h();     // Catch: Throwable -> L285
        r52.getClass();     // Catch: Throwable -> L285
        if (NetworkParams.getOptReflection() == false) goto L112;
        ICronetAppProvider r53 = r52.b;     // Catch: Throwable -> L285
        if (r53 != null) goto L111;
        String r54 = "";
    L113:
        r51.setOSApi(r54);     // Catch: Throwable -> L285
        TTAppInfoProvider.AppInfo r55 = this.a;     // Catch: Throwable -> L285
        c r56 = c.h();     // Catch: Throwable -> L285
        r56.getClass();     // Catch: Throwable -> L285
        if (NetworkParams.getOptReflection() == false) goto L119;
        ICronetAppProvider r57 = r56.b;     // Catch: Throwable -> L285
        if (r57 != null) goto L118;
        String r58 = "";
    L120:
        r55.setOSVersion(r58);     // Catch: Throwable -> L285
        TTAppInfoProvider.AppInfo r59 = this.a;     // Catch: Throwable -> L285
        c r60 = c.h();     // Catch: Throwable -> L285
        r60.getClass();     // Catch: Throwable -> L285
        if (NetworkParams.getOptReflection() == false) goto L126;
        ICronetAppProvider r61 = r60.b;     // Catch: Throwable -> L285
        if (r61 != null) goto L125;
        String r62 = "";
    L127:
        r59.setUserId(r62);     // Catch: Throwable -> L285
        TTAppInfoProvider.AppInfo r63 = this.a;     // Catch: Throwable -> L285
        c r64 = c.h();     // Catch: Throwable -> L285
        r64.getClass();     // Catch: Throwable -> L285
        if (NetworkParams.getOptReflection() == false) goto L133;
        ICronetAppProvider r65 = r64.b;     // Catch: Throwable -> L285
        if (r65 != null) goto L132;
        String r66 = "";
    L134:
        r63.setVersionCode(r66);     // Catch: Throwable -> L285
        TTAppInfoProvider.AppInfo r67 = this.a;     // Catch: Throwable -> L285
        c r68 = c.h();     // Catch: Throwable -> L285
        r68.getClass();     // Catch: Throwable -> L285
        if (NetworkParams.getOptReflection() == false) goto L140;
        ICronetAppProvider r69 = r68.b;     // Catch: Throwable -> L285
        if (r69 != null) goto L139;
        String r70 = "";
    L141:
        r67.setVersionName(r70);     // Catch: Throwable -> L285
        TTAppInfoProvider.AppInfo r71 = this.a;     // Catch: Throwable -> L285
        c r72 = c.h();     // Catch: Throwable -> L285
        r72.getClass();     // Catch: Throwable -> L285
        if (NetworkParams.getOptReflection() == false) goto L147;
        ICronetAppProvider r73 = r72.b;     // Catch: Throwable -> L285
        if (r73 != null) goto L146;
        String r74 = "";
    L148:
        r71.setUpdateVersionCode(r74);     // Catch: Throwable -> L285
        TTAppInfoProvider.AppInfo r75 = this.a;     // Catch: Throwable -> L285
        c r76 = c.h();     // Catch: Throwable -> L285
        r76.getClass();     // Catch: Throwable -> L285
        if (NetworkParams.getOptReflection() == false) goto L154;
        ICronetAppProvider r77 = r76.b;     // Catch: Throwable -> L285
        if (r77 != null) goto L153;
        String r78 = "";
    L155:
        r75.setManifestVersionCode(r78);     // Catch: Throwable -> L285
        TTAppInfoProvider.AppInfo r79 = this.a;     // Catch: Throwable -> L285
        c r80 = c.h();     // Catch: Throwable -> L285
        r80.getClass();     // Catch: Throwable -> L285
        if (NetworkParams.getOptReflection() == false) goto L161;
        ICronetAppProvider r81 = r80.b;     // Catch: Throwable -> L285
        if (r81 != null) goto L160;
        String r82 = "";
    L162:
        r79.setStoreIdc(r82);     // Catch: Throwable -> L285
        TTAppInfoProvider.AppInfo r83 = this.a;     // Catch: Throwable -> L285
        c r84 = c.h();     // Catch: Throwable -> L285
        r84.getClass();     // Catch: Throwable -> L285
        if (NetworkParams.getOptReflection() == false) goto L168;
        ICronetAppProvider r85 = r84.b;     // Catch: Throwable -> L285
        if (r85 != null) goto L167;
        String r86 = "";
    L170:
        if (TextUtils.isEmpty(r86) == true) goto L173;
        r86 = r86.toLowerCase();     // Catch: Throwable -> L285
    L173:
        r83.setRegion(r86);     // Catch: Throwable -> L285
        TTAppInfoProvider.AppInfo r87 = this.a;     // Catch: Throwable -> L285
        c r88 = c.h();     // Catch: Throwable -> L285
        r88.getClass();     // Catch: Throwable -> L285
        if (NetworkParams.getOptReflection() == false) goto L179;
        ICronetAppProvider r89 = r88.b;     // Catch: Throwable -> L285
        if (r89 != null) goto L178;
        String r90 = "";
    L181:
        if (TextUtils.isEmpty(r90) == true) goto L184;
        r90 = r90.toLowerCase();     // Catch: Throwable -> L285
    L184:
        r87.setSysRegion(r90);     // Catch: Throwable -> L285
        TTAppInfoProvider.AppInfo r91 = this.a;     // Catch: Throwable -> L285
        c r92 = c.h();     // Catch: Throwable -> L285
        r92.getClass();     // Catch: Throwable -> L285
        if (NetworkParams.getOptReflection() == false) goto L190;
        ICronetAppProvider r93 = r92.b;     // Catch: Throwable -> L285
        if (r93 != null) goto L189;
        String r94 = "";
    L192:
        if (TextUtils.isEmpty(r94) == true) goto L195;
        r94 = r94.toLowerCase();     // Catch: Throwable -> L285
    L195:
        r91.setCarrierRegion(r94);     // Catch: Throwable -> L285
        TTAppInfoProvider.AppInfo r95 = this.a;     // Catch: Throwable -> L285
        c r96 = c.h();     // Catch: Throwable -> L285
        r96.getClass();     // Catch: Throwable -> L285
        if (NetworkParams.getOptReflection() == false) goto L201;
        ICronetAppProvider r97 = r96.b;     // Catch: Throwable -> L285
        if (r97 != null) goto L200;
        String r98 = "";
    L202:
        r95.setInitRegion(r98);     // Catch: Throwable -> L285
        TTAppInfoProvider.AppInfo r99 = this.a;     // Catch: Throwable -> L285
        c r100 = c.h();     // Catch: Throwable -> L285
        r100.getClass();     // Catch: Throwable -> L285
        if (NetworkParams.getOptReflection() == false) goto L208;
        ICronetAppProvider r101 = r100.b;     // Catch: Throwable -> L285
        if (r101 != null) goto L207;
        String r102 = "";
    L209:
        r99.setTNCRequestFlags(r102);     // Catch: Throwable -> L285
        TTAppInfoProvider.AppInfo r103 = this.a;     // Catch: Throwable -> L285
        c r104 = c.h();     // Catch: Throwable -> L285
        r104.getClass();     // Catch: Throwable -> L285
        if (NetworkParams.getOptReflection() == false) goto L215;
        ICronetAppProvider r105 = r104.b;     // Catch: Throwable -> L285
        if (r105 != null) goto L214;
        String r106 = "";
    L216:
        r103.setHttpDnsRequestFlags(r106);     // Catch: Throwable -> L285
        TTAppInfoProvider.AppInfo r107 = this.a;     // Catch: Throwable -> L285
        if (sx5.b.o == false) goto L219;
        String r108 = "1";
    L220:
        r107.setIsDomestic(r108);     // Catch: Throwable -> L285
        c r109 = c.h();     // Catch: Throwable -> L285
        r109.getClass();     // Catch: Throwable -> L285
    L232:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L285
        Map r110 = Collections.emptyMap();     // Catch: Throwable -> L285
    L234:
        if (r110 != null) goto L236;
    L238:
        Map<String, String> r111 = c.h().f();     // Catch: Throwable -> L285
        String r112 = "";
        if (r111 != null) goto L241;
    L246:
        String r113 = "";
        if (r110 == null) goto L252;
        if (r110.isEmpty() == true) goto L252;
        r113 = a((String) r110.get("first"));     // Catch: Throwable -> L285
    L252:
        if (TextUtils.isEmpty(r113) == true) goto L254;
        r112 = "Cookie:" + r113 + "\r\n" + r112;     // Catch: Throwable -> L285
    L254:
        this.a.setTNCRequestHeader(r112);     // Catch: Throwable -> L285
        Map<String, String> r114 = c.h().g();     // Catch: Throwable -> L285
        String r115 = "";
        if (r114 != null) goto L257;
    L262:
        this.a.setTNCRequestQuery(r115);     // Catch: Throwable -> L285
        List<String> r116 = c.h().a();     // Catch: Throwable -> L285
        String r117 = "";
        if (r116 != null) goto L265;
    L278:
        this.a.setAbSdkVersion(r117);     // Catch: Throwable -> L285
        if (d.a().loggerDebug() == false) goto L288;
        String r118 = "AppInfo{, mUserId='" + this.a.getUserId() + "', mAppId='" + this.a.getAppId() + "', mOSApi='" + this.a.getOSApi() + "', mDeviceId='" + this.a.getDeviceId() + "', mNetAccessType='" + this.a.getNetAccessType() + "', mVersionCode='" + this.a.getVersionCode() + "', mDeviceType='" + this.a.getDeviceType() + "', mAppName='" + this.a.getAppName() + "', mSdkAppID='" + this.a.getSdkAppID() + "', mSdkVersion='" + this.a.getSdkVersion() + "', mChannel='" + this.a.getChannel() + "', mOSVersion='" + this.a.getOSVersion() + "', mAbi='" + this.a.getAbi() + "', mDevicePlatform='" + this.a.getDevicePlatform() + "', mDeviceBrand='" + this.a.getDeviceBrand() + "', mDeviceModel='" + this.a.getDeviceModel() + "', mVersionName='" + this.a.getVersionName() + "', mUpdateVersionCode='" + this.a.getUpdateVersionCode() + "', mManifestVersionCode='" + this.a.getManifestVersionCode() + "'}";     // Catch: Throwable -> L285
        d.a().loggerD("CronetAppInfoProvider", "get appinfo = " + r118);     // Catch: Throwable -> L285
    L288:
        return this.a;
    L265:
        if (r116.size() > 5) goto L267;
    L269:
        Iterator<String> r119 = r116.iterator();     // Catch: Throwable -> L285
        int r120 = 0;
    L271:
        if (r119.hasNext() == false) goto L278;
        String r121 = r119.next();     // Catch: Throwable -> L285
        r120 = r120 + 1;     // Catch: Throwable -> L285
        if (r120 > 5) goto L278;
        if (TextUtils.isEmpty(r121) == true) goto L271;
        r117 = r117 + r121 + ",";     // Catch: Throwable -> L285
        goto L271
    L267:
        if (d.a().loggerDebug() == false) goto L269;
        d.a().loggerD("CronetAppInfoProvider", "ab sdk version count must less than 5");     // Catch: Throwable -> L285
        goto L269
    L257:
        if (r114.isEmpty() == true) goto L262;
        Iterator<Map.Entry<String, String>> r122 = r114.entrySet().iterator();     // Catch: Throwable -> L285
    L260:
        if (r122.hasNext() == false) goto L262;
        Map.Entry<String, String> r123 = r122.next();     // Catch: Throwable -> L285
        r115 = r123.getKey() + ":" + r123.getValue() + "\r\n" + r115;     // Catch: Throwable -> L285
        goto L260
    L241:
        if (r111.isEmpty() == true) goto L246;
        Iterator<Map.Entry<String, String>> r124 = r111.entrySet().iterator();     // Catch: Throwable -> L285
    L244:
        if (r124.hasNext() == false) goto L246;
        Map.Entry<String, String> r125 = r124.next();     // Catch: Throwable -> L285
        r112 = r125.getKey() + ":" + r125.getValue() + "\r\n" + r112;     // Catch: Throwable -> L285
        goto L244
    L236:
        if (r110.isEmpty() == true) goto L238;
        this.a.setHostFirst((String) r110.get("first"));     // Catch: Throwable -> L285
        this.a.setHostSecond((String) r110.get("second"));     // Catch: Throwable -> L285
        this.a.setHostThird((String) r110.get("third"));     // Catch: Throwable -> L285
        this.a.setDomainHttpDns((String) r110.get("httpdns"));     // Catch: Throwable -> L285
        this.a.setDomainBoe((String) r110.get("boe"));     // Catch: Throwable -> L285
        this.a.setDomainBoeHttps((String) r110.get("boe_https"));     // Catch: Throwable -> L285
        goto L238
    L222:
        if (NetworkParams.getOptReflection() == false) goto L227;
        ICronetAppProvider r126 = r109.b;     // Catch: Throwable -> L232
        if (r126 != null) goto L226;
        r110 = Collections.emptyMap();     // Catch: Throwable -> L232
    L289:
    L226:
        r110 = r126.getGetDomainDependHostMap();     // Catch: Throwable -> L232
        goto L289
    L227:
        Object r127 = r109.a;     // Catch: Throwable -> L232
        if (r127 != null) goto L230;
        r110 = Collections.emptyMap();     // Catch: Throwable -> L232
        goto L289
    L230:
        r110 = (Map) yx5.a.b(r127).call("getGetDomainDependHostMap").get();     // Catch: Throwable -> L232
        goto L289
    L219:
        r108 = "0";
        goto L220
    L214:
        r106 = r105.getHttpDnsRequestFlags();     // Catch: Throwable -> L285
        goto L216
    L215:
        r106 = r104.e("getHttpDnsRequestFlags");     // Catch: Throwable -> L285
        goto L216
    L207:
        r102 = r101.getTNCRequestFlags();     // Catch: Throwable -> L285
        goto L209
    L208:
        r102 = r100.e("getTNCRequestFlags");     // Catch: Throwable -> L285
        goto L209
    L200:
        r98 = r97.getAppInitialRegionInfo();     // Catch: Throwable -> L285
        goto L202
    L201:
        r98 = r96.e("getAppInitialRegionInfo");     // Catch: Throwable -> L285
        goto L202
    L189:
        r94 = r93.getCarrierRegion();     // Catch: Throwable -> L285
        goto L192
    L190:
        r94 = r92.e("getCarrierRegion");     // Catch: Throwable -> L285
        goto L192
    L178:
        r90 = r89.getSysRegion();     // Catch: Throwable -> L285
        goto L181
    L179:
        r90 = r88.e("getSysRegion");     // Catch: Throwable -> L285
        goto L181
    L167:
        r86 = r85.getRegion();     // Catch: Throwable -> L285
        goto L170
    L168:
        r86 = r84.e("getRegion");     // Catch: Throwable -> L285
        goto L170
    L160:
        r82 = r81.getStoreIdc();     // Catch: Throwable -> L285
        goto L162
    L161:
        r82 = r80.e("getStoreIdc");     // Catch: Throwable -> L285
        goto L162
    L153:
        r78 = r77.getManifestVersionCode();     // Catch: Throwable -> L285
        goto L155
    L154:
        r78 = r76.e("getManifestVersionCode");     // Catch: Throwable -> L285
        goto L155
    L146:
        r74 = r73.getUpdateVersionCode();     // Catch: Throwable -> L285
        goto L148
    L147:
        r74 = r72.e("getUpdateVersionCode");     // Catch: Throwable -> L285
        goto L148
    L139:
        r70 = r69.getVersionName();     // Catch: Throwable -> L285
        goto L141
    L140:
        r70 = r68.e("getVersionName");     // Catch: Throwable -> L285
        goto L141
    L132:
        r66 = r65.getVersionCode();     // Catch: Throwable -> L285
        goto L134
    L133:
        r66 = r64.e("getVersionCode");     // Catch: Throwable -> L285
        goto L134
    L125:
        r62 = r61.getUserId();     // Catch: Throwable -> L285
        goto L127
    L126:
        r62 = r60.e("getUserId");     // Catch: Throwable -> L285
        goto L127
    L118:
        r58 = r57.getOSVersion();     // Catch: Throwable -> L285
        goto L120
    L119:
        r58 = r56.e("getOSVersion");     // Catch: Throwable -> L285
        goto L120
    L111:
        r54 = r53.getOSApi();     // Catch: Throwable -> L285
        goto L113
    L112:
        r54 = r52.e("getOSApi");     // Catch: Throwable -> L285
        goto L113
    L104:
        r50 = r49.getNetAccessType();     // Catch: Throwable -> L285
        goto L106
    L105:
        r50 = r48.e("getNetAccessType");     // Catch: Throwable -> L285
        goto L106
    L97:
        r46 = r45.getDeviceModel();     // Catch: Throwable -> L285
        goto L99
    L98:
        r46 = r44.e("getDeviceModel");     // Catch: Throwable -> L285
        goto L99
    L90:
        r42 = r41.getDeviceBrand();     // Catch: Throwable -> L285
        goto L92
    L91:
        r42 = r40.e("getDeviceBrand");     // Catch: Throwable -> L285
        goto L92
    L83:
        r38 = r37.getDeviceType();     // Catch: Throwable -> L285
        goto L85
    L84:
        r38 = r36.e("getDeviceType");     // Catch: Throwable -> L285
        goto L85
    L76:
        r34 = r33.getDevicePlatform();     // Catch: Throwable -> L285
        goto L78
    L77:
        r34 = r32.e("getDevicePlatform");     // Catch: Throwable -> L285
        goto L78
    L69:
        r30 = r29.getAbi();     // Catch: Throwable -> L285
        goto L71
    L70:
        r30 = r28.e("getAbi");     // Catch: Throwable -> L285
        goto L71
    L52:
        if (NetworkParams.getOptReflection() == false) goto L57;
        ICronetAppProvider r128 = r25.b;     // Catch: Throwable -> L62
        if (r128 == null) goto L59;
        r26 = r128.getIsDropFirstTnc();     // Catch: Throwable -> L62
    L294:
    L59:
        r26 = null;
        goto L294
    L57:
        Object r129 = r25.a;     // Catch: Throwable -> L62
        if (r129 == null) goto L59;
        r26 = (String) yx5.a.b(r129).call("getIsDropFirstTnc").get();     // Catch: Throwable -> L62
        goto L294
    L48:
        r23 = r22.getDeviceId();     // Catch: Throwable -> L285
        goto L50
    L49:
        r23 = r21.e("getDeviceId");     // Catch: Throwable -> L285
        goto L50
    L41:
        r19 = r18.getChannel();     // Catch: Throwable -> L285
        goto L43
    L42:
        r19 = r17.e("getChannel");     // Catch: Throwable -> L285
        goto L43
    L34:
        r15 = r14.getSdkVersion();     // Catch: Throwable -> L285
        goto L36
    L35:
        r15 = r13.e("getSdkVersion");     // Catch: Throwable -> L285
        goto L36
    L27:
        r11 = r10.getSdkAppId();     // Catch: Throwable -> L285
        goto L29
    L28:
        r11 = r9.e("getSdkAppId");     // Catch: Throwable -> L285
        goto L29
    L20:
        r7 = r6.getAppName();     // Catch: Throwable -> L285
        goto L22
    L21:
        r7 = r5.e("getAppName");     // Catch: Throwable -> L285
        goto L22
    L13:
        r3 = r2.getAppId();     // Catch: Throwable -> L285
        goto L15
    L14:
        r3 = r1.e("getAppId");     // Catch: Throwable -> L285
        goto L15
    L285:
        th = move-exception;
        th.printStackTrace();
        goto L288
    }

    public a(Context r1) {
        r1.getApplicationContext();
    }

    public static String a(String r5) {
        CookieHandler r1 = CookieHandler.getDefault();
        if (TextUtils.isEmpty(r5) == true) goto L26;
        if (r1 == null) goto L26;
        Map<String, List<String>> r6 = r1.get(l.a("https://" + r5), null);     // Catch: Throwable -> L27
        if (r6 == null) goto L26;
        if (r6.size() <= 0) goto L26;
        Iterator<Map.Entry<String, List<String>>> r7 = r6.entrySet().iterator();     // Catch: Throwable -> L27
    L12:
        if (r7.hasNext() == false) goto L26;
        Map.Entry<String, List<String>> r0 = r7.next();     // Catch: Throwable -> L27
        if ("Cookie".equalsIgnoreCase(r0.getKey()) == false) goto L12;
        if (r0.getValue().isEmpty() == true) goto L12;
        StringBuilder r8 = new StringBuilder();     // Catch: Throwable -> L27
        Iterator<String> r2 = r0.getValue().iterator();     // Catch: Throwable -> L27
        int r3 = 0;
    L19:
        if (r2.hasNext() == false) goto L24;
        String r4 = r2.next();     // Catch: Throwable -> L27
        if (r3 <= 0) goto L23;
        r8.append("; ");     // Catch: Throwable -> L27
    L23:
        r8.append(r4);     // Catch: Throwable -> L27
        r3 = r3 + 1;     // Catch: Throwable -> L27
        goto L19
    L24:
        return r8.toString();
    L26:
        return null;
    }

    public static a b(Context r2) {
        if (b != null) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (b != null) goto L9;
        b = new a(r2);     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L15:
        return b;
    }
}
