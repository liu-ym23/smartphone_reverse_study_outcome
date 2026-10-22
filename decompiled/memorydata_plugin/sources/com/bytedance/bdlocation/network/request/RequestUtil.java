package com.bytedance.bdlocation.network.request;

import android.util.Pair;
import com.bytedance.apm6.util.constant.NetConst;
import com.bytedance.bdlocation.client.BDLocationConfig;
import com.bytedance.retrofit2.client.Header;
import com.ss.android.ugc.quota.BDNetworkTagManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class RequestUtil {
    public RequestUtil() {
    }

    public static List<Header> headerList(List<Header> r5, final int r6) {
        List<Header> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        if (r7 != null) goto L6;
        r7 = new ArrayList();
    L6:
        if (BDLocationConfig.isDebug() == true) goto L8;
    L17:
        Pair<String, String> r8 = BDNetworkTagManager.getInstance().buildBDNetworkTag(new AnonymousClass1(r6));     // Catch: Throwable -> L16
        if (r8 == null) goto L15;
        r7.add(new Header((String) ZeusTransformUtils.preCheckCast(r8.first, String.class, "com.obric.memorydata.plugin"), (String) ZeusTransformUtils.preCheckCast(r8.second, String.class, "com.obric.memorydata.plugin")));     // Catch: Throwable -> L16
    L15:
        return r7;
    L8:
        if (BDLocationConfig.isOnline() == true) goto L17;
        Pair r0 = BDLocationConfig.getEnv();
        if (r0 == null) goto L17;
        r7.add(new Header((String) ZeusTransformUtils.preCheckCast(r0.first, String.class, "com.obric.memorydata.plugin"), "1"));
        r7.add(new Header("x-tt-env", (String) ZeusTransformUtils.preCheckCast(r0.second, String.class, "com.obric.memorydata.plugin")));
        goto L17
    }

    public static Map<String, String> headerMap(Map<String, String> r3, final int r4) {
        Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L6;
        r5 = new HashMap();
    L6:
        if (BDLocationConfig.isDebug() == true) goto L8;
    L17:
        Pair<String, String> r6 = BDNetworkTagManager.getInstance().buildBDNetworkTag(new AnonymousClass2(r4));     // Catch: Throwable -> L16
        if (r6 == null) goto L15;
        r5.put(r6.first, r6.second);     // Catch: Throwable -> L16
    L15:
        return r5;
    L8:
        if (BDLocationConfig.isOnline() == true) goto L17;
        Pair r0 = BDLocationConfig.getEnv();
        if (r0 == null) goto L17;
        r5.put(r0.first, "1");
        r5.put("x-tt-env", r0.second);
        goto L17
    }

    public static List<Header> overseaHeaderList(List<Header> r3) {
        List<Header> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L5;
        r4 = new ArrayList();
    L5:
        r4.add(new Header(NetConst.KEY_CONTENT_TYPE, "application/json"));
        return r4;
    }
}
