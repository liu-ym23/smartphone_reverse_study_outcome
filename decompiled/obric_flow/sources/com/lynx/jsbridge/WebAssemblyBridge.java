package com.lynx.jsbridge;

import com.lynx.base.log.LynxLog;

/* JADX INFO: loaded from: classes2.dex */
public class WebAssemblyBridge {
    public static void a() {
        long r5 = ((Long) Class.forName("com.bytedance.vmsdk.wasm.RegisterWebAssembly").getMethod("registerWebAssembly", null).invoke(null, null)).longValue();     // Catch: Exception -> L5
    L8:
        if (r5 == 0) goto L13;
        nativeInitWasm(r5);
        return;
    L13:
        return;
    L5:
        e = move-exception;
        LynxLog.b(4, "lynx", "No webassembly found in the host [ " + e.getMessage() + ", " + e.getCause() + " ]");
        r5 = 0;
        goto L8
    }

    private static native void nativeInitWasm(long r5);
}
