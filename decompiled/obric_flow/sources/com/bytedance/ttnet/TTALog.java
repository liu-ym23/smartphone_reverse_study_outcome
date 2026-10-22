package com.bytedance.ttnet;

import android.util.Log;
import com.bytedance.ai.resource.core.net.a;
import com.bytedance.common.utility.reflect.Reflect;
import com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient;
import com.lynx.tasm.utils.e;
import com.ss.android.agilelogger.ALog;
import u9.l;

/* JADX INFO: loaded from: classes2.dex */
public class TTALog {
    private static final String TAG = "TTNET_ALog";
    private static volatile long sALogFuncAddr;

    public TTALog() {
    }

    private static void ensureALogInitialized() {
        sALogFuncAddr = ALog.getALogWriteFuncAddr();
        Log.i(TAG, "ALog function address is " + sALogFuncAddr);
        if (sALogFuncAddr != 0) goto L6;
        ALog.addNativeFuncAddrCallback(new a(18));
        return;
    }

    public static long getALogFuncAddr() {
        return sALogFuncAddr;
    }

    private static l getCronetHttpClient() throws Exception {
        e.h();
        return null;
    }

    public static void init() {
        ensureALogInitialized();
    }

    private static void lambda$ensureALogInitialized$0(long r5) {
        if (sALogFuncAddr == 0) goto L7;
        Log.i(TAG, "ALog function address has initialized.");
        return;
    L7:
        if (r5 != 0) goto L10;
        Log.w(TAG, "Cannot get ALog function address in init callback.");
        return;
    L10:
        sALogFuncAddr = r5;
        Log.i(TAG, "ALog function address is " + sALogFuncAddr + " from callback.");
    L18:
        e = move-exception;
        e.printStackTrace();
        return;
    L12:
        if (getCronetHttpClient() == null) goto L22;
        long r10 = sALogFuncAddr;     // Catch: Exception -> L18
        ICronetClient r11 = l.f22316b;     // Catch: Exception -> L18
        if (r11 == null) goto L17;
        Reflect.on(r11).call("setAlogFuncAddr", new Class[]{Long.TYPE}, new Object[]{Long.valueOf(r10)});     // Catch: Exception -> L18
        return;
    L17:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");     // Catch: Exception -> L18
    }
}
