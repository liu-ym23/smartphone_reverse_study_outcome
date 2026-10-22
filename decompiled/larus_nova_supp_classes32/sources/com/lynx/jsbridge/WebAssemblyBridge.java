package com.lynx.jsbridge;

import com.lynx.tasm.base.LLog;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class WebAssemblyBridge {
    public WebAssemblyBridge() {
    }

    private static native void nativeInitWasm(long r0);

    public static void a() {
        long r2 = ((Long) h.a().getMethod("registerWebAssembly", new Class[0]).invoke(null, new Object[0])).longValue();     // Catch: Exception -> L5
    L8:
        if (r2 == 0) goto L13;
        nativeInitWasm(r2);
        return;
    L13:
        return;
    L5:
        e = move-exception;
        LLog.e("lynx", "No webassembly found in the host [ " + e.getMessage() + ", " + e.getCause() + " ]");
        r2 = 0;
        goto L8
    }
}
