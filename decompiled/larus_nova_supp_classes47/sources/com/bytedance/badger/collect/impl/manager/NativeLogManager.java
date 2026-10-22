package com.bytedance.badger.collect.impl.manager;

import com.bytedance.librarian.a;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public class NativeLogManager {
    private static final Object LOAD_LOCK = null;
    private static volatile boolean isLoaded;
    private static volatile boolean loadAttempted;

    public NativeLogManager() {
    }

    public static /* synthetic */ void access$000(String r0) {
        System.loadLibrary(r0);
    }

    private static native String nativeGetDA0Result(String r0);

    private static native int[] nativeGetDI0Result(String[] r0);

    static {
        LOAD_LOCK = new Object();
        loadAttempted = false;
        isLoaded = false;
    }

    private static boolean ensureLoaded() {
        if (isLoaded == false) goto L5;
        return true;
    L5:
        Object r0 = LOAD_LOCK;
        monitor-enter(r0);
    L22:
        th = move-exception;
        throw th;
    L8:
        if (isLoaded == false) goto L12;
        monitor-exit(r0);     // Catch: Throwable -> L22
        return true;
    L12:
        if (loadAttempted == false) goto L15;
        monitor-exit(r0);     // Catch: Throwable -> L22
        return false;
    L15:
        loadAttempted = true;     // Catch: Throwable -> L22
        INVOKESTATIC_com_bytedance_badger_collect_impl_manager_NativeLogManager_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary("native_badger_log");     // Catch: Throwable -> L18
        isLoaded = true;     // Catch: Throwable -> L18
    L19:
        boolean r1 = isLoaded;     // Catch: Throwable -> L22
        monitor-exit(r0);     // Catch: Throwable -> L22
        return r1;
    L18:
        isLoaded = false;     // Catch: Throwable -> L22
        goto L19
    }

    @JvmStatic
    public static void INVOKESTATIC_com_bytedance_badger_collect_impl_manager_NativeLogManager_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(String r4) {
        Intrinsics.checkNotNullParameter(r4, "libName");
        FLogger r0 = FLogger.a;
        r0.i("Librarian_loadLib", "loadLibrary start libName -> " + r4);
        a.c(r4);
        r0.i("Librarian_loadLib", "loadLibrary success by librarian -> " + r4);
    }

    public static String getDA0Result(String r2) {
        if (ensureLoaded() == true) goto L8;
        return "";
    L8:
        return nativeGetDA0Result(r2);
    L7:
        return "";
    }

    public static int[] getDI0Result(String[] r2) {
        if (ensureLoaded() == false) goto L5;
        return nativeGetDI0Result(r2);
    L9:
        return new int[0];
    L5:
        return new int[0];
    }
}
