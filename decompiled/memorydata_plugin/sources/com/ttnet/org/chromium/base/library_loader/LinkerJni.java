package com.ttnet.org.chromium.base.library_loader;

/* JADX INFO: loaded from: classes6.dex */
class LinkerJni implements Linker.Natives {
    LinkerJni() {
    }

    private static native void nativeFindMemoryRegionAtRandomAddress(Linker.LibInfo r0, boolean r1);

    private static native boolean nativeFindRegionReservedByWebViewZygote(Linker.LibInfo r0);

    private static native void nativeReserveMemoryForLibrary(Linker.LibInfo r0);

    @Override // com.ttnet.org.chromium.base.library_loader.Linker.Natives
    public void findMemoryRegionAtRandomAddress(Linker.LibInfo r1, boolean r2) {
        nativeFindMemoryRegionAtRandomAddress(r1, r2);
    }

    @Override // com.ttnet.org.chromium.base.library_loader.Linker.Natives
    public boolean findRegionReservedByWebViewZygote(Linker.LibInfo r1) {
        return nativeFindRegionReservedByWebViewZygote(r1);
    }

    @Override // com.ttnet.org.chromium.base.library_loader.Linker.Natives
    public void reserveMemoryForLibrary(Linker.LibInfo r1) {
        nativeReserveMemoryForLibrary(r1);
    }
}
