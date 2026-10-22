package com.ttnet.org.chromium.base;

import com.ttnet.org.chromium.build.BuildConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public class NativeLibraryLoadedStatus {
    private static NativeLibraryLoadedStatusProvider sProvider;

    public NativeLibraryLoadedStatus() {
    }

    public static NativeLibraryLoadedStatusProvider getProviderForTesting() {
        return sProvider;
    }

    public static void checkLoaded(boolean r1) {
        if (BuildConfig.ENABLE_ASSERTS == true) goto L5;
        return;
    L5:
        NativeLibraryLoadedStatusProvider r0 = sProvider;
        if (r0 != null) goto L8;
        return;
    L8:
        if (r1 == false) goto L10;
        boolean r2 = r0.areMainDexNativeMethodsReady();
    L11:
        if (r2 == false) goto L14;
        return;
    L14:
        throw new JniException("Native method called before the native library was ready.");
    L10:
        r2 = r0.areNativeMethodsReady();
        goto L11
    }

    public static void setProvider(NativeLibraryLoadedStatusProvider r0) {
        sProvider = r0;
    }
}
