package com.bytedance.bdlocation.network;

import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.bdlocation.LocationUtil;
import com.bytedance.bdlocation.client.BDLocationConfig;
import com.bytedance.bdlocation.log.Logger;
import com.bytedance.bdlocation.monitor.LocationMonitor;
import com.bytedance.bdlocation.network.request.RequestUtil;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.mime.TypedString;
import com.bytedance.ttnet.INetworkApi;
import e9.d;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class NetworkRequestManager {
    public NetworkRequestManager() {
    }

    public static String get(String r8, Map<String, String> r10, int r11) {
    L10:
        e = move-exception;
        Logger.e("NetworkRequestManager get exception:" + e.getMessage());
        return "";
    L4:
        if (BDLocationConfig.getNetworkSignatureMode().isEmpty() == true) goto L8;
        if (r10 != null) goto L7;
        r10 = new LinkedHashMap();     // Catch: Exception -> L10
    L7:
        r10.put("loc_aqua_ab", BDLocationConfig.getNetworkSignatureMode());     // Catch: Exception -> L10
    L8:
        Logger.i("NetworkRequest get Path:" + r8);     // Catch: Exception -> L10
        String r12 = ((INetworkApiInner) d.c(INetworkApiInner.class, getBaseUrl())).doGet(true, -1, r8, r10, RequestUtil.headerList(null, r11), null).execute().body();     // Catch: Exception -> L10
        Logger.i("NetworkRequestManager post networkResponse:" + r12);     // Catch: Exception -> L10
        return r12;
    }

    private static String getBaseUrl() {
        String r8 = BDLocationConfig.getBaseUrl();
        if (TextUtils.isEmpty(r8) == true) goto L5;
        return r8;
    L5:
        Logger.e("需要初始化时设置业务自身域名:BDLocationConfig.setBaseUrl(\"xxxx\")");
        return "";
    }

    public static String post(String r15, Map<String, String> r16, Map<String, String> r17, int r18) {
        if (BDLocationConfig.isPrivacyConfirmed() == true) goto L24;
        Logger.i("The upload of data is allowed after user confirmed the privacy!");
        return "";
    L24:
    L21:
        e = move-exception;
        Logger.e("NetworkRequestManager post exception:" + e.getMessage());
        return "";
    L7:
        if (BDLocationConfig.getNetworkSignatureMode().isEmpty() == true) goto L12;
        if (r17 != null) goto L10;
        Map<String, String> r8 = new LinkedHashMap();     // Catch: Exception -> L21
    L11:
        r8.put("loc_aqua_ab", BDLocationConfig.getNetworkSignatureMode());     // Catch: Exception -> L21
        Map<String, String> r10 = r8;
    L13:
        long r11 = System.currentTimeMillis();     // Catch: Exception -> L21
        Logger.i("NetworkRequest post Path:" + r15);     // Catch: Exception -> L21
        ICustomNetworkApi r12 = BDLocationConfig.getNetworkApi();     // Catch: Exception -> L21
        if (r12 == null) goto L16;
        SsResponse<String> r13 = r12.doPost(getBaseUrl(), r15, r10, r16, RequestUtil.headerList(null, r18), true);     // Catch: Exception -> L21
    L17:
        if (r13 != null) goto L19;
        return "";
    L19:
        String r14 = r13.body();     // Catch: Exception -> L21
        Logger.i("NetworkRequestManager post intervalTime:" + (System.currentTimeMillis() - r11) + "--networkResponse:" + r14);     // Catch: Exception -> L21
        return r14;
    L16:
        r13 = ((INetworkApiInner) d.c(INetworkApiInner.class, getBaseUrl())).doPost(-1, r15, r10, r16, RequestUtil.headerList(null, r18), null, true).execute();     // Catch: Exception -> L21
        goto L17
    L10:
        r8 = r17;
        goto L11
    L12:
        r10 = r17;
        goto L13
    }

    public static String postJson(String r13, TypedString r14, Map<String, String> r15) {
        if (BDLocationConfig.isPrivacyConfirmed() == true) goto L15;
        Logger.i("The upload of data is allowed after user confirmed the privacy!");
        return "";
    L15:
        long r8 = System.currentTimeMillis();     // Catch: Exception -> L12
        Logger.i("NetworkRequest post Path:" + r13);     // Catch: Exception -> L12
        ICustomNetworkApi r10 = BDLocationConfig.getNetworkApi();     // Catch: Exception -> L12
        if (r10 == null) goto L9;
        String r16 = r10.doPostJson(getBaseUrl(), r13, r15, r14, RequestUtil.overseaHeaderList(null), true);     // Catch: Exception -> L12
    L10:
        Logger.i("NetworkRequestManager post intervalTime:" + (System.currentTimeMillis() - r8) + "--networkResponse:" + r16);     // Catch: Exception -> L12
        return r16;
    L9:
        r16 = ((INetworkApi) d.c(INetworkApi.class, getBaseUrl())).postBody(-1, r13, r15, r14, RequestUtil.overseaHeaderList(null)).execute().body();     // Catch: Exception -> L12
    L12:
        e = move-exception;
        Logger.e("NetworkRequestManager post exception:" + e.getMessage());
        return "";
    }

    public static SsResponse<String> submitPost(String r20, Map<String, String> r21, Map<String, String> r22, int r23, String r24) {
        if (BDLocationConfig.isPrivacyConfirmed() == true) goto L25;
        Logger.i("The upload of data is allowed after user confirmed the privacy!");
        return null;
    L25:
        boolean r10 = LocationUtil.isBackground();     // Catch: Exception -> L22
        long r8 = SystemClock.elapsedRealtime();     // Catch: Exception -> L22
        if (BDLocationConfig.getNetworkSignatureMode().isEmpty() == true) goto L12;
        if (r22 != null) goto L10;
        Map<String, String> r11 = new LinkedHashMap();     // Catch: Exception -> L22
    L11:
        r11.put("loc_aqua_ab", BDLocationConfig.getNetworkSignatureMode());     // Catch: Exception -> L22
        Map<String, String> r13 = r11;
    L13:
        long r18 = System.currentTimeMillis();     // Catch: Exception -> L22
        Logger.i("NetworkRequest post Path:" + r20);     // Catch: Exception -> L22
        ICustomNetworkApi r12 = BDLocationConfig.getNetworkApi();     // Catch: Exception -> L22
        if (r12 == null) goto L16;
        SsResponse<String> r14 = r12.doPost(getBaseUrl(), r20, r13, r21, RequestUtil.headerList(null, r23), true);     // Catch: Exception -> L22
    L17:
        if (r14 != null) goto L20;
        LocationMonitor.doSubmitSource(SystemClock.elapsedRealtime() - r8, -2, "response is null", r10, r24);     // Catch: Exception -> L22
        return null;
    L20:
        LocationMonitor.doSubmitSource(SystemClock.elapsedRealtime() - r8, 0, "response is not null", r10, r24);     // Catch: Exception -> L22
        Logger.i("NetworkRequestManager post intervalTime:" + (System.currentTimeMillis() - r18));     // Catch: Exception -> L22
        return r14;
    L16:
        r14 = ((INetworkApiInner) d.c(INetworkApiInner.class, getBaseUrl())).doPost(-1, r20, r13, r21, RequestUtil.headerList(null, r23), null, true).execute();     // Catch: Exception -> L22
        goto L17
    L10:
        r11 = r22;
        goto L11
    L12:
        r13 = r22;
    L22:
        e = move-exception;
        Logger.e("NetworkRequestManager post exception:" + e.getMessage());
        return null;
    }
}
