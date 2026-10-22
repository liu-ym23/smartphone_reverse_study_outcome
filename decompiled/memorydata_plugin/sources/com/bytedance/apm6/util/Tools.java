package com.bytedance.apm6.util;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.rpc.internal.RpcUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public final class Tools {
    private static Handler sHandler;

    static {
        sHandler = new Handler(Looper.getMainLooper());
    }

    public Tools() {
    }

    public static void runOnUiThread(Runnable r2) {
        Runnable r3 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r2, Runnable.class, "com.obric.memorydata.plugin");
        sHandler.post(r3);
    }

    public static byte[] safeGetBytes(String r1) {
        if (r1 != null) goto L10;
    L8:
        return null;
    L10:
        if (r1.length() <= 0) goto L8;
        return r1.getBytes(RpcUtils.CHARSET_UTF8);
    L12:
        return r1.getBytes();
    }
}
