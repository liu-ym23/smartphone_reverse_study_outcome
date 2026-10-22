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
import com.bytedance.ttnet.utils.RetrofitUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class NetworkRequestManager {
    public NetworkRequestManager() {
    }

    public static String get(String r9, Map<String, String> r10, int r11) {
        Map<String, String> r12 = (Map) ZeusTransformUtils.wrapperContextForParams(r10, Map.class, "com.obric.memorydata.plugin");
    L10:
        e = move-exception;
        Logger.e("NetworkRequestManager get exception:" + e.getMessage());
        return "";
    L4:
        if (BDLocationConfig.getNetworkSignatureMode().isEmpty() == true) goto L8;
        if (r12 != null) goto L7;
        r12 = new LinkedHashMap();     // Catch: Exception -> L10
    L7:
        r12.put("loc_aqua_ab", BDLocationConfig.getNetworkSignatureMode());     // Catch: Exception -> L10
    L8:
        Logger.i("NetworkRequest get Path:" + r9);     // Catch: Exception -> L10
        String r13 = (String) ZeusTransformUtils.preCheckCast(((INetworkApiInner) ZeusTransformUtils.preCheckCast(RetrofitUtils.a(getBaseUrl(), INetworkApiInner.class), INetworkApiInner.class, "com.obric.memorydata.plugin")).doGet(true, -1, r9, r12, RequestUtil.headerList(null, r11), null).execute().body(), String.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L10
        Logger.i("NetworkRequestManager post networkResponse:" + r13);     // Catch: Exception -> L10
        return r13;
    }

    private static String getBaseUrl() {
        String r0 = BDLocationConfig.getBaseUrl();
        if (TextUtils.isEmpty(r0) == true) goto L5;
        return r0;
    L5:
        Logger.e("需要初始化时设置业务自身域名:BDLocationConfig.setBaseUrl(\"xxxx\")");
        return "";
    }

    public static String post(String r10, Map<String, String> r11, Map<String, String> r12, int r13) {
        Map<String, String> r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r11, Map.class, "com.obric.memorydata.plugin");
        Map<String, String> r14 = (Map) ZeusTransformUtils.wrapperContextForParams(r12, Map.class, "com.obric.memorydata.plugin");
        if (BDLocationConfig.isPrivacyConfirmed() == true) goto L22;
        Logger.i("The upload of data is allowed after user confirmed the privacy!");
        return "";
    L22:
    L19:
        e = move-exception;
        Logger.e("NetworkRequestManager post exception:" + e.getMessage());
        return "";
    L7:
        if (BDLocationConfig.getNetworkSignatureMode().isEmpty() == true) goto L11;
        if (r14 != null) goto L10;
        r14 = new LinkedHashMap();     // Catch: Exception -> L19
    L10:
        r14.put("loc_aqua_ab", BDLocationConfig.getNetworkSignatureMode());     // Catch: Exception -> L19
    L11:
        Map<String, String> r5 = r14;
        long r15 = System.currentTimeMillis();     // Catch: Exception -> L19
        Logger.i("NetworkRequest post Path:" + r10);     // Catch: Exception -> L19
        ICustomNetworkApi r2 = BDLocationConfig.getNetworkApi();     // Catch: Exception -> L19
        if (r2 == null) goto L14;
        SsResponse<String> r16 = r2.doPost(getBaseUrl(), r10, r5, r6, RequestUtil.headerList(null, r13), true);     // Catch: Exception -> L19
    L15:
        if (r16 != null) goto L17;
        return "";
    L17:
        String r17 = (String) ZeusTransformUtils.preCheckCast(r16.body(), String.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L19
        Logger.i("NetworkRequestManager post intervalTime:" + (System.currentTimeMillis() - r15) + "--networkResponse:" + r17);     // Catch: Exception -> L19
        return r17;
    L14:
        r16 = ((INetworkApiInner) ZeusTransformUtils.preCheckCast(RetrofitUtils.a(getBaseUrl(), INetworkApiInner.class), INetworkApiInner.class, "com.obric.memorydata.plugin")).doPost(-1, r10, r5, r6, RequestUtil.headerList(null, r13), null, true).execute();     // Catch: Exception -> L19
        goto L15
    }

    public static String postJson(String r11, TypedString r12, Map<String, String> r13) {
        Map<String, String> r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r13, Map.class, "com.obric.memorydata.plugin");
        if (BDLocationConfig.isPrivacyConfirmed() == true) goto L15;
        Logger.i("The upload of data is allowed after user confirmed the privacy!");
        return "";
    L15:
        long r9 = System.currentTimeMillis();     // Catch: Exception -> L12
        Logger.i("NetworkRequest post Path:" + r11);     // Catch: Exception -> L12
        ICustomNetworkApi r2 = BDLocationConfig.getNetworkApi();     // Catch: Exception -> L12
        if (r2 == null) goto L9;
        String r14 = r2.doPostJson(getBaseUrl(), r11, r5, r12, RequestUtil.overseaHeaderList(null), true);     // Catch: Exception -> L12
    L10:
        Logger.i("NetworkRequestManager post intervalTime:" + (System.currentTimeMillis() - r9) + "--networkResponse:" + r14);     // Catch: Exception -> L12
        return r14;
    L9:
        r14 = (String) ZeusTransformUtils.preCheckCast(((INetworkApi) ZeusTransformUtils.preCheckCast(RetrofitUtils.a(getBaseUrl(), INetworkApi.class), INetworkApi.class, "com.obric.memorydata.plugin")).postBody(-1, r11, r5, r12, RequestUtil.overseaHeaderList(null)).execute().body(), String.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L12
    L12:
        e = move-exception;
        Logger.e("NetworkRequestManager post exception:" + e.getMessage());
        return "";
    }

    public static SsResponse<String> submitPost(String r17, Map<String, String> r18, Map<String, String> r19, int r20, String r21) {
        Map<String, String> r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r18, Map.class, "com.obric.memorydata.plugin");
        Map<String, String> r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r19, Map.class, "com.obric.memorydata.plugin");
        if (BDLocationConfig.isPrivacyConfirmed() == true) goto L23;
        Logger.i("The upload of data is allowed after user confirmed the privacy!");
        return null;
    L23:
        boolean r12 = LocationUtil.isBackground();     // Catch: Exception -> L20
        long r13 = SystemClock.elapsedRealtime();     // Catch: Exception -> L20
        if (BDLocationConfig.getNetworkSignatureMode().isEmpty() == true) goto L11;
        if (r1 != null) goto L10;
        r1 = new LinkedHashMap();     // Catch: Exception -> L20
    L10:
        r1.put("loc_aqua_ab", BDLocationConfig.getNetworkSignatureMode());     // Catch: Exception -> L20
    L11:
        Map<String, String> r6 = r1;
        long r15 = System.currentTimeMillis();     // Catch: Exception -> L20
        Logger.i("NetworkRequest post Path:" + r17);     // Catch: Exception -> L20
        ICustomNetworkApi r3 = BDLocationConfig.getNetworkApi();     // Catch: Exception -> L20
        if (r3 == null) goto L14;
        SsResponse<String> r0 = r3.doPost(getBaseUrl(), r17, r6, r7, RequestUtil.headerList(null, r20), true);     // Catch: Exception -> L20
    L15:
        if (r0 != null) goto L18;
        LocationMonitor.doSubmitSource(SystemClock.elapsedRealtime() - r13, -2, "response is null", r12, r21);     // Catch: Exception -> L20
        return null;
    L18:
        LocationMonitor.doSubmitSource(SystemClock.elapsedRealtime() - r13, 0, "response is not null", r12, r21);     // Catch: Exception -> L20
        Logger.i("NetworkRequestManager post intervalTime:" + (System.currentTimeMillis() - r15));     // Catch: Exception -> L20
        return r0;
    L14:
        r0 = ((INetworkApiInner) ZeusTransformUtils.preCheckCast(RetrofitUtils.a(getBaseUrl(), INetworkApiInner.class), INetworkApiInner.class, "com.obric.memorydata.plugin")).doPost(-1, r17, r6, r7, RequestUtil.headerList(null, r20), null, true).execute();     // Catch: Exception -> L20
    L20:
        e = move-exception;
        Logger.e("NetworkRequestManager post exception:" + e.getMessage());
        return null;
    }
}
