package com.bytedance.crash.npth_repair;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import com.bytedance.crash.npth_repair.utils.RepairLog;
import com.bytedance.librarian.a;

/* JADX INFO: loaded from: classes.dex */
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

    public static synchronized int init(@NonNull Context r10, boolean r11) {
        monitor-enter(NpthRepair.class);
    L21:
        th = move-exception;
        throw th;
    L5:
        if (inited == false) goto L11;
        if (r11 == false) goto L8;
        Log.d(TAG, "already do init");     // Catch: Throwable -> L21
    L8:
        int r12 = initErrno;     // Catch: Throwable -> L21
        monitor-exit(NpthRepair.class);
        return r12;
    L11:
        RepairLog.setDebuggable(r11);     // Catch: Throwable -> L21
        inited = true;     // Catch: Throwable -> L21
        applicationContext = r10;     // Catch: Throwable -> L21
        if (loadLibrary() == true) goto L25;
        initErrno = -5;     // Catch: Throwable -> L21
    L18:
        int r13 = initErrno;     // Catch: Throwable -> L21
        monitor-exit(NpthRepair.class);
        return r13;
    L25:
        setDebuggable(r11);     // Catch: Throwable -> L15
        initErrno = nInit(Build.VERSION.SDK_INT, r11);     // Catch: Throwable -> L15
    L16:
        initErrno = -3;     // Catch: Throwable -> L21
        goto L18
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

    @Keep
    private static native boolean nGetDebuggable();

    @Keep
    private static native int nInit(int r10, boolean r11);

    @Keep
    private static native void nSetDebuggable(boolean r10);

    public static void setDebuggable(boolean r10) {
        RepairLog.setDebuggable(r10);
        if (soLoaded == false) goto L6;
        nSetDebuggable(r10);
        return;
    }
}
