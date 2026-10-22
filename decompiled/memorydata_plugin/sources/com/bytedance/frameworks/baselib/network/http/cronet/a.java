package com.bytedance.frameworks.baselib.network.http.cronet;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile IJavaInterceptorCallback f2403a;

    public static String a(String r2, Map<String, String> r3) {
        Map<String, String> r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        IJavaInterceptorCallback r0 = f2403a;
        if (r0 != null) goto L7;
        return "";
    L7:
        return r0.onRequestInterceptorJava(r2, r4);
    }

    public static void a(IJavaInterceptorCallback r2) {
        f2403a = (IJavaInterceptorCallback) ZeusTransformUtils.wrapperContextForParams(r2, IJavaInterceptorCallback.class, "com.obric.memorydata.plugin");
    }
}
