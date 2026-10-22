package com.lynx.base;

import com.bytedance.librarian.a;
import com.larus.utils.logger.FLogger;
import com.lynx.base.log.LynxLog;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class LynxBaseEnv {
    private static LynxBaseEnv sInstance;
    private volatile boolean mIsNativeLibraryLoaded;

    public static /* synthetic */ void access$000(String r0) {
        System.loadLibrary(r0);
    }

    public static LynxBaseEnv inst() {
        if (sInstance != null) goto L15;
        monitor-enter(LynxBaseEnv.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new LynxBaseEnv();     // Catch: Throwable -> L11
    L9:
        monitor-exit(LynxBaseEnv.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    private LynxBaseEnv() {
        this.mIsNativeLibraryLoaded = false;
    }

    public boolean isNativeLibraryLoaded() {
        return this.mIsNativeLibraryLoaded;
    }

    @JvmStatic
    public static void INVOKESTATIC_com_lynx_base_LynxBaseEnv_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(String r4) {
        Intrinsics.checkNotNullParameter(r4, "libName");
        FLogger r0 = FLogger.a;
        r0.i("Librarian_loadLib", "loadLibrary start libName -> " + r4);
        a.c(r4);
        r0.i("Librarian_loadLib", "loadLibrary success by librarian -> " + r4);
    }

    public synchronized boolean loadNativeTraceLibrary(IBaseNativeLibraryLoader r2) {
        monitor-enter(this);
    L17:
        th = move-exception;
        throw th;
    L4:
        if (this.mIsNativeLibraryLoaded == false) goto L20;
        boolean r3 = this.mIsNativeLibraryLoaded;     // Catch: Throwable -> L17
        monitor-exit(this);
        return r3;
    L20:
        if (r2 == null) goto L10;
        r2.loadLibrary("lynxbase");     // Catch: Exception -> L14 Throwable -> L17
    L11:
        monitor-exit(this);
        return true;
    L10:
        INVOKESTATIC_com_lynx_base_LynxBaseEnv_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary("lynxbase");     // Catch: Exception -> L14 Throwable -> L17
    L15:
        return false;
    }

    public boolean init(IBaseNativeLibraryLoader r2, boolean r3) {
        if (this.mIsNativeLibraryLoaded == true) goto L5;
        this.mIsNativeLibraryLoaded = loadNativeTraceLibrary(r2);
    L5:
        LynxLog.initLynxLog(r3);
        LynxBaseTrace.init();
        return true;
    }
}
