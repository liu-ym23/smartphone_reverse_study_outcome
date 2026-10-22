package com.bytedance.android.common.sonic;

import com.bytedance.librarian.a;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public class SonicJsonParser {
    public SonicJsonParser() {
    }

    public static /* synthetic */ void access$000(String r0) {
        System.loadLibrary(r0);
    }

    public static native boolean isNeonSupported();

    public static native Object[] processTokens(String r0, boolean r1);

    static {
        INVOKESTATIC_com_bytedance_android_common_sonic_SonicJsonParser_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary("sonicjson");
    }

    @JvmStatic
    public static void INVOKESTATIC_com_bytedance_android_common_sonic_SonicJsonParser_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(String r10) {
        Intrinsics.checkNotNullParameter(r10, "libName");
        FLogger r0 = FLogger.a;
        r0.i("Librarian_loadLib", "loadLibrary start libName -> " + r10);
        a.c(r10);
        r0.i("Librarian_loadLib", "loadLibrary success by librarian -> " + r10);
    }

    public static <T> T parseJson(String r1, Class<T> r10) {
        if (r1 != null) goto L5;
        return null;
    L5:
        kd.a r0 = new kd.a(r1);
        return (T) GsonProtectorUtils.fromJson(new Gson(), r0, r10);
    }

    public static <T> T parseJson(Gson r1, String r10, Class<T> r11) {
        if (r10 != null) goto L6;
        return null;
    L6:
        return (T) GsonProtectorUtils.fromJson(r1, new kd.a(r10), r11);
    }
}
