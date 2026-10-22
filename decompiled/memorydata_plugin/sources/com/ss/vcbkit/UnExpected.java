package com.ss.vcbkit;

import com.bytedance.crash.Ensure;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public class UnExpected {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f15815a = false;

    static {
    }

    public UnExpected() {
    }

    static void a() {
        if (f15815a == false) goto L9;
        return;
    L9:
        Ensure.getInstance();     // Catch: Throwable -> L7
        f15815a = true;     // Catch: Throwable -> L7
        return;
    L7:
        f15815a = false;
    }

    private static void notReachHereNative(String r2, String r3, Map<String, String> r4) {
        Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
        if (f15815a == false) goto L6;
        Ensure.ensureNativeStack(r2, "", Thread.currentThread().getName(), r3, r5);
        return;
    }
}
