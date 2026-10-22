package com.bytedance.crash.npth_repair;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import com.bytedance.crash.npth_repair.utils.RepairLog;
import com.bytedance.librarian.a;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public class NpthRepair {
    private static final String TAG = "NpthRepair";
    public static Context applicationContext = null;
    private static int initErrno = -1;
    private static boolean inited = false;
    private static boolean soLoaded = false;

    static {
    }

    public NpthRepair() {
    }

    public static boolean getDebuggable() {
        if (soLoaded == true) goto L5;
        return false;
    L5:
        return nGetDebuggable();
    }

    public static synchronized int init(Context r3, boolean r4) {
        monitor-enter(NpthRepair.class);
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L21
        if (inited == false) goto L11;
        if (r4 == false) goto L8;
        Log.d(TAG, "already do init");     // Catch: Throwable -> L21
    L8:
        int r6 = initErrno;     // Catch: Throwable -> L21
        monitor-exit(NpthRepair.class);
        return r6;
    L11:
        RepairLog.setDebuggable(r4);     // Catch: Throwable -> L21
        inited = true;     // Catch: Throwable -> L21
        applicationContext = r5;     // Catch: Throwable -> L21
        if (loadLibrary() == true) goto L25;
        initErrno = -5;     // Catch: Throwable -> L21
    L18:
        int r7 = initErrno;     // Catch: Throwable -> L21
        monitor-exit(NpthRepair.class);
        return r7;
    L25:
        setDebuggable(r4);     // Catch: Throwable -> L15
        initErrno = nInit(Build.VERSION.SDK_INT, r4);     // Catch: Throwable -> L15
    L16:
        initErrno = -3;     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        throw th;
    }

    public static boolean isInited() {
        if (initErrno != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean loadLibrary() {
        if (soLoaded == true) goto L8;
        a.a("npth_repair", applicationContext);     // Catch: Throwable -> L6
        soLoaded = true;     // Catch: Throwable -> L6
    L6:
        Log.d(TAG, "load so fail");
    L8:
        return soLoaded;
    }

    private static native boolean nGetDebuggable();

    private static native int nInit(int r0, boolean r1);

    private static native void nSetDebuggable(boolean r0);

    public static void setDebuggable(boolean r1) {
        RepairLog.setDebuggable(r1);
        if (soLoaded == false) goto L6;
        nSetDebuggable(r1);
        return;
    }
}
