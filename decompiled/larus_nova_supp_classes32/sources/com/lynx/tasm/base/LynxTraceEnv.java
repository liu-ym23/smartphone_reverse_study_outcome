package com.lynx.tasm.base;

import com.larus.utils.logger.FLogger;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class LynxTraceEnv {
    private static LynxTraceEnv sInstance;
    private volatile boolean mIsNativeLibraryLoaded;

    public static /* synthetic */ void access$000(String r0) {
        System.loadLibrary(r0);
    }

    public static LynxTraceEnv inst() {
        if (sInstance != null) goto L15;
        monitor-enter(LynxTraceEnv.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new LynxTraceEnv();     // Catch: Throwable -> L11
    L9:
        monitor-exit(LynxTraceEnv.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    public boolean init() {
        if (this.mIsNativeLibraryLoaded == true) goto L5;
        this.mIsNativeLibraryLoaded = loadNativeTraceLibrary();
        TraceEvent.markTraceEnvInited(this.mIsNativeLibraryLoaded);
        return this.mIsNativeLibraryLoaded;
    L5:
        return this.mIsNativeLibraryLoaded;
    }

    public boolean loadNativeTraceLibrary() {
        if (this.mIsNativeLibraryLoaded == true) goto L5;
        INVOKESTATIC_com_lynx_tasm_base_LynxTraceEnv_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary("lynxtrace");     // Catch: Exception -> L9
        return true;
    L9:
        return false;
    L5:
        return this.mIsNativeLibraryLoaded;
    }

    private LynxTraceEnv() {
        this.mIsNativeLibraryLoaded = false;
    }

    public boolean isNativeLibraryLoaded() {
        return this.mIsNativeLibraryLoaded;
    }

    @JvmStatic
    public static void INVOKESTATIC_com_lynx_tasm_base_LynxTraceEnv_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(String r4) {
        Intrinsics.checkNotNullParameter(r4, "libName");
        FLogger r0 = FLogger.a;
        r0.i("Librarian_loadLib", "loadLibrary start libName -> " + r4);
        com.bytedance.librarian.a.c(r4);
        r0.i("Librarian_loadLib", "loadLibrary success by librarian -> " + r4);
    }

    public void markNativeLibraryLoaded(boolean r1) {
        this.mIsNativeLibraryLoaded = r1;
        TraceEvent.markTraceEnvInited(r1);
    }
}
