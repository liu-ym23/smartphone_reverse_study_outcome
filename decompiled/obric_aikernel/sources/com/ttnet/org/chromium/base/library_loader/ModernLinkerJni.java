package com.ttnet.org.chromium.base.library_loader;

import com.ttnet.org.chromium.base.annotations.CalledByNative;

/* JADX INFO: loaded from: classes2.dex */
class ModernLinkerJni implements ModernLinker.Natives {
    private static final String TAG = "ModernLinkerJni";

    ModernLinkerJni() {
    }

    private static native int nativeGetRelroSharingResult();

    private static native boolean nativeLoadLibrary(String r10, Linker.LibInfo r11, boolean r12);

    private static native boolean nativeUseRelros(long r10, Linker.LibInfo r11);

    @CalledByNative
    public static void reportDlopenExtTime(long r10) {
        ModernLinker.reportDlopenExtTime(r10);
    }

    @CalledByNative
    public static void reportIteratePhdrTime(long r10) {
        ModernLinker.reportIteratePhdrTime(r10);
    }

    @Override // com.ttnet.org.chromium.base.library_loader.ModernLinker.Natives
    public int getRelroSharingResult() {
        return nativeGetRelroSharingResult();
    }

    @Override // com.ttnet.org.chromium.base.library_loader.ModernLinker.Natives
    public boolean loadLibrary(String r10, Linker.LibInfo r11, boolean r12) {
        return nativeLoadLibrary(r10, r11, r12);
    }

    @Override // com.ttnet.org.chromium.base.library_loader.ModernLinker.Natives
    public boolean useRelros(long r10, Linker.LibInfo r11) {
        return nativeUseRelros(r10, r11);
    }
}
