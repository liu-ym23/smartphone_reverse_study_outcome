package com.ttnet.org.chromium.base;

import com.ttnet.org.chromium.build.BuildConfig;

/* JADX INFO: loaded from: classes2.dex */
public class NativeLibraryLoadedStatus {
    private static NativeLibraryLoadedStatusProvider sProvider;

    public interface NativeLibraryLoadedStatusProvider {
        boolean areMainDexNativeMethodsReady();

        boolean areNativeMethodsReady();
    }

    public NativeLibraryLoadedStatus() {
    }

    public static void checkLoaded(boolean r10) {
        if (BuildConfig.ENABLE_ASSERTS == true) goto L5;
        return;
    L5:
        NativeLibraryLoadedStatusProvider r11 = sProvider;
        if (r11 != null) goto L8;
        return;
    L8:
        if (r10 == false) goto L10;
        boolean r12 = r11.areMainDexNativeMethodsReady();
    L11:
        if (r12 == false) goto L14;
        return;
    L14:
        throw new JniException("Native method called before the native library was ready.");
    L10:
        r12 = r11.areNativeMethodsReady();
        goto L11
    }

    public static NativeLibraryLoadedStatusProvider getProviderForTesting() {
        return sProvider;
    }

    public static void setProvider(NativeLibraryLoadedStatusProvider r10) {
        sProvider = r10;
    }
}
