package com.bytedance.android.live.saas.middleware.utils;

import android.content.Context;
import com.bytedance.common.utility.Logger;
import com.bytedance.librarian.a;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.utils.logger.FLogger;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\n"}, d2 = {"Lcom/bytedance/android/live/saas/middleware/utils/CornetPlugin;", "", "()V", "getCornetSoPath", "", "context", "Landroid/content/Context;", "isCornetSoExists", "", "isCornetSoInstalled", "middleware_release"}, k = 1, mv = {1, 4, 3})
public final class CornetPlugin {
    public static final CornetPlugin INSTANCE = null;

    private CornetPlugin() {
    }

    public static /* synthetic */ void access$000(String r0) {
        System.loadLibrary(r0);
    }

    static {
        INSTANCE = new CornetPlugin();
    }

    @JvmStatic
    public static void INVOKESTATIC_com_bytedance_android_live_saas_middleware_utils_CornetPlugin_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(String r4) {
        Intrinsics.checkNotNullParameter(r4, "libName");
        FLogger r0 = FLogger.a;
        r0.i("Librarian_loadLib", "loadLibrary start libName -> " + r4);
        a.c(r4);
        r0.i("Librarian_loadLib", "loadLibrary success by librarian -> " + r4);
    }

    private final boolean isCornetSoExists(Context r5) {
        PolarisFileWrapper r0 = new PolarisFileWrapper(r5.getCacheDir().getAbsolutePath() + File.separator + "libsscronet.so");
        Logger.i("CornetPlugin", "cronet.so " + r0 + " exits:" + r0.exists());
        if (r0.exists() == false) goto L6;
        return true;
    L6:
        return StringsKt.contains$default(r0.getAbsolutePath(), "h_", false, 2, null);
    }

    public final String getCornetSoPath(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        return r2.getCacheDir().getAbsolutePath();
    }

    public final boolean isCornetSoInstalled(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        INVOKESTATIC_com_bytedance_android_live_saas_middleware_utils_CornetPlugin_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary("sscronet");     // Catch: Throwable -> L5
        return true;
    L5:
        return false;
    }
}
