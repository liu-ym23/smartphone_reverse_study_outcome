package com.bytedance.crypto.nativelib;

import android.content.Context;
import com.bytedance.librarian.a;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class CryptoManager {
    private static volatile CryptoManager cryptoManager;
    private Context mContext;

    public CryptoManager() {
    }

    public static /* synthetic */ void access$000(String r0) {
        System.loadLibrary(r0);
    }

    private static native void nativeInit(Context r0);

    public String chacha20BytesXcrypt(int r1, String r2, String r3) {
        return null;
    }

    static {
        INVOKESTATIC_com_bytedance_crypto_nativelib_CryptoManager_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary("cryptolib");
    }

    public static CryptoManager getInstance() {
        if (cryptoManager != null) goto L15;
        monitor-enter(CryptoManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (cryptoManager != null) goto L9;
        cryptoManager = new CryptoManager();     // Catch: Throwable -> L11
    L9:
        monitor-exit(CryptoManager.class);     // Catch: Throwable -> L11
    L15:
        return cryptoManager;
    }

    @JvmStatic
    public static void INVOKESTATIC_com_bytedance_crypto_nativelib_CryptoManager_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(String r4) {
        Intrinsics.checkNotNullParameter(r4, "libName");
        FLogger r0 = FLogger.a;
        r0.i("Librarian_loadLib", "loadLibrary start libName -> " + r4);
        a.c(r4);
        r0.i("Librarian_loadLib", "loadLibrary success by librarian -> " + r4);
    }

    public void init(Context r1) {
        if (r1 == null) goto L5;
        nativeInit(r1.getApplicationContext());
        return;
    }
}
