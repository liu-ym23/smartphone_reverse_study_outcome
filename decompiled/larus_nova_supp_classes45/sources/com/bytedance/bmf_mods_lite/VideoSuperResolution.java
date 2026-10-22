package com.bytedance.bmf_mods_lite;

import android.graphics.Bitmap;
import com.bytedance.librarian.a;
import com.larus.utils.logger.FLogger;
import com.ss.android.agilelogger.ALog;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class VideoSuperResolution {
    private native long nativeCreateSuperResolution();

    private native int nativeInitSuperResolution(long r1, int r3, int r4, int r5, int r6, int r7, int r8, String r9, String r11, String r12);

    private native void nativeReleaseSuperResolution(long r1);

    private native int nativeSuperResolutionGetResultTexture(long r1);

    private native int nativeSuperResolutionOesProcess(long r1, int r3, float[] r4, int r5, int r6, int r7, int r8, int r9, int r11, int r12, long r13);

    private native int nativeSuperResolutionOesProcessMultiScale(long r1, int r3, float[] r4, int r5, int r6, int r7, int r8, int r9, int r11, int r12, long r13, int r14, int r15);

    private native int nativeSuperResolutionProcess(long r1, int r3, int r4, int r5, int r6, int r7, int r8, int r9, int r11, long r12);

    private native int nativeSuperResolutionProcessBitmap(long r1, Bitmap r3, Bitmap r4);

    private native int nativeSuperResolutionProcessMultiScale(long r1, int r3, int r4, int r5, int r6, int r7, int r8, int r9, int r11, long r12, int r13, int r14);

    private native int nativeSuperResolutionProcessYuv(long r1, long r3, long r5, long r7, int r9, int r11, int r12, int r13);

    static {
        a();     // Catch: Throwable -> L5
        ALog.i("bmf VideoSuperResolution", "VideoSuperResolution is initialized");     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        ALog.i("bmf VideoSuperResolution", "VideoSuperResolution initialize occurs error, the msg = " + th.getMessage());
    }

    @JvmStatic
    public static void a() {
        Intrinsics.checkNotNullParameter("bmf_hydra_lite", "libName");
        FLogger r0 = FLogger.a;
        r0.i("Librarian_loadLib", "loadLibrary start libName -> bmf_hydra_lite");
        a.c("bmf_hydra_lite");
        r0.i("Librarian_loadLib", "loadLibrary success by librarian -> bmf_hydra_lite");
    }

    public VideoSuperResolution() {
        ALog.i("bmf VideoSuperResolution", "New VideoSuperResolution");
    }
}
