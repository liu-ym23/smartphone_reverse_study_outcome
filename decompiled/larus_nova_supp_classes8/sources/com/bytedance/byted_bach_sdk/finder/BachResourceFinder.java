package com.bytedance.byted_bach_sdk.finder;

import com.bytedance.librarian.a;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public abstract class BachResourceFinder {
    public boolean isDestroyed;
    public long m_nativePtr;

    public static /* synthetic */ void access$000(String r0) {
        System.loadLibrary(r0);
    }

    public abstract void destroy();

    static {
        INVOKESTATIC_com_bytedance_byted_bach_sdk_finder_BachResourceFinder_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary("bach-sdk-jni");
    }

    public BachResourceFinder() {
        this.m_nativePtr = 0;
        this.isDestroyed = false;
    }

    @JvmStatic
    public static void INVOKESTATIC_com_bytedance_byted_bach_sdk_finder_BachResourceFinder_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(String r4) {
        Intrinsics.checkNotNullParameter(r4, "libName");
        FLogger r0 = FLogger.a;
        r0.i("Librarian_loadLib", "loadLibrary start libName -> " + r4);
        a.c(r4);
        r0.i("Librarian_loadLib", "loadLibrary success by librarian -> " + r4);
    }
}
