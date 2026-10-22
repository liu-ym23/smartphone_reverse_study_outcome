package com.ttnet.org.chromium.base.library_loader;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes2.dex */
class LinkerJni implements Linker.Natives {
    LinkerJni() {
    }

    private static native void nativeFindMemoryRegionAtRandomAddress(@NonNull Linker.LibInfo r10, boolean r11);

    private static native boolean nativeFindRegionReservedByWebViewZygote(@NonNull Linker.LibInfo r10);

    private static native void nativeReserveMemoryForLibrary(@NonNull Linker.LibInfo r10);

    @Override // com.ttnet.org.chromium.base.library_loader.Linker.Natives
    public void findMemoryRegionAtRandomAddress(@NonNull Linker.LibInfo r10, boolean r11) {
        nativeFindMemoryRegionAtRandomAddress(r10, r11);
    }

    @Override // com.ttnet.org.chromium.base.library_loader.Linker.Natives
    public boolean findRegionReservedByWebViewZygote(@NonNull Linker.LibInfo r10) {
        return nativeFindRegionReservedByWebViewZygote(r10);
    }

    @Override // com.ttnet.org.chromium.base.library_loader.Linker.Natives
    public void reserveMemoryForLibrary(@NonNull Linker.LibInfo r10) {
        nativeReserveMemoryForLibrary(r10);
    }
}
