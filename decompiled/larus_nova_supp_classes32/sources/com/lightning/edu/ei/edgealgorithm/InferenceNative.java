package com.lightning.edu.ei.edgealgorithm;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import com.bytedance.librarian.a;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class InferenceNative {
    public static String TAG = "InferenceNative";

    public InferenceNative() {
    }

    public static native String GetVersion();

    public static native long InitByAssetManger(AssetManager r0, int r1, int r2, int r3, int r4, int r5, int r6, int r7, String r8, String r9, String r10, String r11, String r12, String r13);

    public static native Result PredictBitmap(long r0, Bitmap r2, int r3, Params r4);

    public static native Result PredictIntArray(long r0, int[] r2, int r3, int r4, int r5, Params r6);

    public static native void Release(long r0);

    public static native String Version(long r0);

    public static /* synthetic */ void access$000(String r0) {
        System.loadLibrary(r0);
    }

    static {
        INVOKESTATIC_com_lightning_edu_ei_edgealgorithm_InferenceNative_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary("edge-algorithm");
        loadByteNN("bytenn");
    }

    @JvmStatic
    public static void INVOKESTATIC_com_lightning_edu_ei_edgealgorithm_InferenceNative_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(String r4) {
        Intrinsics.checkNotNullParameter(r4, "libName");
        FLogger r0 = FLogger.a;
        r0.i("Librarian_loadLib", "loadLibrary start libName -> " + r4);
        a.c(r4);
        r0.i("Librarian_loadLib", "loadLibrary success by librarian -> " + r4);
    }

    public static void loadByteNN(String r0) {
        INVOKESTATIC_com_lightning_edu_ei_edgealgorithm_InferenceNative_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(r0);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }
}
