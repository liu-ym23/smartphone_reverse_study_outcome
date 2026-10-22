package com.bytedance.bdlocation.network.request;

import android.util.Pair;
import com.bytedance.bdlocation.client.BDLocationConfig;
import com.bytedance.retrofit2.client.Header;
import com.obric.cae.userAware.datacollection.NetworkClient;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import wd.b;

/* JADX INFO: loaded from: classes.dex */
public class RequestUtil {
    public RequestUtil() {
    }

    public static List<Header> headerList(List<Header> r8, final int r10) {
        if (r8 != null) goto L5;
        r8 = new ArrayList();
    L5:
        if (BDLocationConfig.isDebug() == true) goto L7;
    L14:
        b.c().a(new AnonymousClass1(r10));     // Catch: Throwable -> L13
    L12:
        return r8;
    L7:
        if (BDLocationConfig.isOnline() == true) goto L14;
        Pair r11 = BDLocationConfig.getEnv();
        if (r11 == null) goto L14;
        r8.add(new Header((String) r11.first, "1"));
        r8.add(new Header("x-tt-env", (String) r11.second));
        goto L14
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Map<String, String> headerMap(Map<String, String> r8, final int r10) {
        if (r8 != null) goto L5;
        Map<String, String> r11 = new HashMap();
    L5:
        if (BDLocationConfig.isDebug() == true) goto L7;
    L14:
        b.c().a(new AnonymousClass2(r10));     // Catch: Throwable -> L13
    L12:
        return r11;
    L7:
        if (BDLocationConfig.isOnline() == true) goto L14;
        Pair r12 = BDLocationConfig.getEnv();
        if (r12 == null) goto L14;
        r11.put(r12.first, "1");
        r11.put("x-tt-env", r12.second);
        goto L14
    }

    public static List<Header> overseaHeaderList(List<Header> r8) {
        if (r8 != null) goto L4;
        r8 = new ArrayList();
    L4:
        r8.add(new Header("Content-Type", NetworkClient.UPLOAD_FILE_TYPE_JSON));
        return r8;
    }
}
