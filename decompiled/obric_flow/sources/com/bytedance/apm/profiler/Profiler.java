package com.bytedance.apm.profiler;

import android.util.Log;
import androidx.annotation.Keep;
import com.bytedance.shadowhook.ShadowHook;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
public class Profiler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile boolean f3896a = false;

    static {
        new AtomicReference(null);
    }

    @Keep
    private static native boolean nAttachThread(int r5);

    @Keep
    private static native boolean nCheck();

    @Keep
    private static native void nClear();

    @Keep
    private static native boolean nDetachThread(int r5);

    @Keep
    private static native String nDump(long r5, long r10);

    @Keep
    private static native String nGetStack(int r5);

    @Keep
    private static native boolean nInit();

    @Keep
    private static native void nSetAlog(long r5);

    @Keep
    private static native boolean nStart(int r5);

    @Keep
    private static native boolean nStop();

    public final synchronized void a() {
        monitor-enter(this);
    L12:
        th = move-exception;
        throw th;
    L4:
        if (f3896a == false) goto L20;
    L14:
        monitor-exit(this);
        return;
    L20:
        ShadowHook.a();     // Catch: Throwable -> L7
        System.loadLibrary("profiler");     // Catch: Throwable -> L7
        f3896a = nInit();     // Catch: Throwable -> L7
    L10:
        Log.e("unwind", "init profiler status " + f3896a);     // Catch: Throwable -> L12
        goto L14
    L7:
        th = move-exception;
        f3896a = false;     // Catch: Throwable -> L12
        th.printStackTrace();     // Catch: Throwable -> L12
        goto L10
    }
}
