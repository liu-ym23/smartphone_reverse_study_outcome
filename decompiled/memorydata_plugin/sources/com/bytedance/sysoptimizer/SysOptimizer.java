package com.bytedance.sysoptimizer;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import com.bytedance.librarian.a;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.nio.channels.OverlappingFileLockException;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class SysOptimizer {
    private static final String TAG = "SYSOPTIMIZER";
    private static boolean mHookRefreshed = false;
    private static ArrayList<UnsatisfiedLinkError> mLoadError = null;
    private static volatile boolean mOptimzerLibLoaded = false;

    static {
        mLoadError = new ArrayList();
        mHookRefreshed = false;
    }

    public SysOptimizer() {
    }

    public static ArrayList<UnsatisfiedLinkError> getLoadLibraryError() {
        return mLoadError;
    }

    public static synchronized void hookOptimizerEnable() {
        monitor-enter(SysOptimizer.class);
    L16:
        th = move-exception;
        throw th;
    L5:
        if (mOptimzerLibLoaded == true) goto L7;
    L14:
        monitor-exit(SysOptimizer.class);
        return;
    L7:
        if (mHookRefreshed == true) goto L14;
        refreshHook();     // Catch: UnsatisfiedLinkError -> L11 Throwable -> L16
        mHookRefreshed = true;     // Catch: UnsatisfiedLinkError -> L11 Throwable -> L16
    L12:
        monitor-exit(SysOptimizer.class);
        return;
    L11:
        Log.e(TAG, "refresh xhook failed.");     // Catch: Throwable -> L16
        goto L12
    }

    public static boolean loadOptimizerLibrary(Context r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
        if (mOptimzerLibLoaded == false) goto L6;
        return true;
    L6:
        monitor-enter(SysOptimizer.class);
    L32:
        th = move-exception;
        throw th;
    L8:
        if (mOptimzerLibLoaded == false) goto L36;
        monitor-exit(SysOptimizer.class);     // Catch: Throwable -> L32
        return true;
    L36:
        if (r6 != null) goto L18;
        if (Build.VERSION.SDK_INT > 17) goto L16;
        System.loadLibrary("npth_dl");     // Catch: OverlappingFileLockException -> L24 UnsatisfiedLinkError -> L28 Throwable -> L32
    L16:
        System.loadLibrary("sysoptimizer");     // Catch: OverlappingFileLockException -> L24 UnsatisfiedLinkError -> L28 Throwable -> L32
    L21:
        Log.d(TAG, "load SYSOPTIMIZER success");     // Catch: OverlappingFileLockException -> L24 UnsatisfiedLinkError -> L28 Throwable -> L32
        mOptimzerLibLoaded = true;     // Catch: OverlappingFileLockException -> L24 UnsatisfiedLinkError -> L28 Throwable -> L32
        monitor-exit(SysOptimizer.class);     // Catch: Throwable -> L32
        return true;
    L18:
        if (Build.VERSION.SDK_INT > 17) goto L20;
        a.a("npth_dl", r6);     // Catch: OverlappingFileLockException -> L24 UnsatisfiedLinkError -> L28 Throwable -> L32
    L20:
        a.a("sysoptimizer", r6);     // Catch: OverlappingFileLockException -> L24 UnsatisfiedLinkError -> L28 Throwable -> L32
    L28:
        e = move-exception;
        Log.e(TAG, "failed to load SYSOPTIMIZER");     // Catch: Throwable -> L32
        Log.e(TAG, "", e);     // Catch: Throwable -> L32
        mLoadError.add(e);     // Catch: Throwable -> L32
        return false;
    L24:
        e = move-exception;
        Log.e(TAG, "failed to load so caused by OverlappingFileLockException:", e);     // Catch: Throwable -> L32
        return false;
    }

    private static native void refreshHook();
}
