package com.unicom.xiaowo.inner.ipflow.tools;

import android.util.Log;

/* JADX INFO: loaded from: classes2.dex */
public class WoProxyUtils {
    static {
        System.loadLibrary("WoProxy");     // Catch: Throwable -> L5 UnsatisfiedLinkError -> L7
        Log.i("WoProxyUtils", "Nativie library  libWoProxy.so load success!");     // Catch: Throwable -> L5 UnsatisfiedLinkError -> L7
    L12:
        return;
    L7:
        Log.e("WoProxyUtils", "Nativie library not found! Please copy libWoProxy.so into your project");
        return;
    L5:
        th = move-exception;
        Log.d("WoProxyUtils", "Failed to load library WoProxy: " + th.getMessage());
    }

    public WoProxyUtils() {
    }

    public native int close();

    public native int setConnInfo(String r8, int r10, String r11, String r12, String r13, String r14, String r15, String r16, String r17);

    public native int setDebugMode(int r8);

    public native int start();
}
