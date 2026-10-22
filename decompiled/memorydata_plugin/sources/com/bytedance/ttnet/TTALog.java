package com.bytedance.ttnet;

import android.content.Context;
import android.util.Log;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public class TTALog {
    private static final String TAG = "TTNET_ALog";
    private static volatile long sALogFuncAddr;

    public TTALog() {
    }

    private static void ensureALogInitialized() {
        sALogFuncAddr = com.ss.android.agilelogger.a.e();
        Log.i(TAG, "ALog function address is " + sALogFuncAddr);
        if (sALogFuncAddr != 0) goto L6;
        com.ss.android.agilelogger.a.a($$Lambda$TTALog$VuU2YSPkKkOq6JW9li3Qg1L_A.INSTANCE);
        return;
    }

    public static long getALogFuncAddr() {
        return sALogFuncAddr;
    }

    private static com.bytedance.frameworks.baselib.network.http.cronet.impl.h getCronetHttpClient() {
        if (c.b() == true) goto L5;
        return null;
    L5:
        return com.bytedance.frameworks.baselib.network.http.cronet.impl.h.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(TTNetInit.getTTNetDepend().getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
    }

    public static void init() {
        ensureALogInitialized();
    }

    static /* synthetic */ void lambda$ensureALogInitialized$0(long r4) {
        if (sALogFuncAddr == 0) goto L7;
        Log.i(TAG, "ALog function address has initialized.");
        return;
    L7:
        if (r4 != 0) goto L10;
        Log.w(TAG, "Cannot get ALog function address in init callback.");
        return;
    L10:
        sALogFuncAddr = r4;
        Log.i(TAG, "ALog function address is " + sALogFuncAddr + " from callback.");
        com.bytedance.frameworks.baselib.network.http.cronet.impl.h r5 = getCronetHttpClient();     // Catch: Exception -> L15
        if (r5 == null) goto L20;
        r5.a(sALogFuncAddr);     // Catch: Exception -> L15
        return;
    L20:
        return;
    L15:
        e = move-exception;
        e.printStackTrace();
    }
}
