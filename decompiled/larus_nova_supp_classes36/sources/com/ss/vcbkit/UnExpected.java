package com.ss.vcbkit;

import com.bytedance.crash.d;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class UnExpected {
    public static boolean a;

    public UnExpected() {
    }

    private static void notReachHereNative(String r2, String r3, Map<String, String> r4) {
        if (a == false) goto L6;
        d.a(r2, "", ThreadMethodProxy.currentThread().getName(), r3, r4);
        return;
    }
}
