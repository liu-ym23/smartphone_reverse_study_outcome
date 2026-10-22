package com.bytedance.byted_bach_sdk.buffer;

import android.graphics.Bitmap;
import com.bytedance.librarian.a;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class BachBitmapHandle {
    private long m_nativeHandle;

    public BachBitmapHandle() {
    }

    public static /* synthetic */ void access$000(String r0) {
        System.loadLibrary(r0);
    }

    private native Bitmap nativeGet(long r1);

    static {
        INVOKESTATIC_com_bytedance_byted_bach_sdk_buffer_BachBitmapHandle_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary("bach-sdk-jni");
    }

    public Bitmap get() {
        return nativeGet(this.m_nativeHandle);
    }

    @JvmStatic
    public static void INVOKESTATIC_com_bytedance_byted_bach_sdk_buffer_BachBitmapHandle_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(String r4) {
        Intrinsics.checkNotNullParameter(r4, "libName");
        FLogger r0 = FLogger.a;
        r0.i("Librarian_loadLib", "loadLibrary start libName -> " + r4);
        a.c(r4);
        r0.i("Librarian_loadLib", "loadLibrary success by librarian -> " + r4);
    }
}
