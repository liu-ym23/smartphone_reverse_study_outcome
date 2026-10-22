package com.bytedance.ttnet;

import a7.i;
import android.util.Log;
import com.bytedance.android.alog.Alog;
import com.bytedance.common.utility.reflect.Reflect;
import com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient;
import defpackage.c;
import fd.a;
import w8.b;
import w8.d;

/* JADX INFO: loaded from: classes.dex */
public class TTALog {
    private static final String TAG = "TTNET_ALog";
    private static volatile long sALogFuncAddr;

    public TTALog() {
    }

    public static /* synthetic */ void a(long r8) {
        lambda$ensureALogInitialized$0(r8);
    }

    private static void ensureALogInitialized() {
        int r8 = a.f7380a;
        Alog r10 = c.f3213r;
        if (r10 == null) goto L5;
        long r11 = r10.b();
    L6:
        sALogFuncAddr = r11;
        Log.i(TAG, "ALog function address is " + sALogFuncAddr);
        if (sALogFuncAddr != 0) goto L10;
        a.f7383d.add(new d());
        return;
    L10:
        return;
    L5:
        r11 = 0;
        goto L6
    }

    public static long getALogFuncAddr() {
        return sALogFuncAddr;
    }

    private static i getCronetHttpClient() {
        if (b.b() == true) goto L5;
        return null;
    L5:
        return i.m(TTNetInit.getTTNetDepend().getContext());
    }

    public static void init() {
        ensureALogInitialized();
    }

    private static void lambda$ensureALogInitialized$0(long r8) {
        if (sALogFuncAddr == 0) goto L7;
        Log.i(TAG, "ALog function address has initialized.");
        return;
    L7:
        if (r8 != 0) goto L10;
        Log.w(TAG, "Cannot get ALog function address in init callback.");
        return;
    L10:
        sALogFuncAddr = r8;
        Log.i(TAG, "ALog function address is " + sALogFuncAddr + " from callback.");
    L18:
        e = move-exception;
        e.printStackTrace();
        return;
    L12:
        if (getCronetHttpClient() == null) goto L22;
        long r10 = sALogFuncAddr;     // Catch: Exception -> L18
        ICronetClient r11 = i.f111b;     // Catch: Exception -> L18
        if (r11 == null) goto L17;
        Reflect.on(r11).call("setAlogFuncAddr", new Class[]{Long.TYPE}, new Object[]{Long.valueOf(r10)});     // Catch: Exception -> L18
        return;
    L17:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");     // Catch: Exception -> L18
    }
}
