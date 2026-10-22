package com.bytedance.apm6.util;

import android.os.Handler;
import android.os.Looper;

/* JADX INFO: loaded from: classes.dex */
public final class Tools {
    private static Handler sHandler;

    static {
        sHandler = new Handler(Looper.getMainLooper());
    }

    public Tools() {
    }

    public static void runOnUiThread(Runnable r10) {
        sHandler.post(r10);
    }

    public static byte[] safeGetBytes(String r10) {
        if (r10 != null) goto L10;
    L8:
        return null;
    L10:
        if (r10.length() <= 0) goto L8;
        return r10.getBytes("UTF-8");
    L12:
        return r10.getBytes();
    }
}
