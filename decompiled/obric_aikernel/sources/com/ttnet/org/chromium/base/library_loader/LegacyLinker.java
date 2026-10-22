package com.ttnet.org.chromium.base.library_loader;

import androidx.annotation.NonNull;
import com.ttnet.org.chromium.base.Log;

/* JADX INFO: loaded from: classes2.dex */
class LegacyLinker extends Linker {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String TAG = "LegacyLinker";

    static {
    }

    LegacyLinker() {
    }

    private static native boolean nativeAddZipArchivePath(String r10);

    private static native boolean nativeCreateSharedRelro(String r10, long r11, Linker.LibInfo r12);

    private static native boolean nativeLoadLibrary(String r10, long r11, @NonNull Linker.LibInfo r12);

    private static native boolean nativeUseSharedRelro(String r10, Linker.LibInfo r11);

    private static void useSharedRelrosLocked(Linker.LibInfo r10) {
        String r11 = r10.mLibFilePath;
        if (nativeUseSharedRelro(r11, r10) == true) goto L6;
        Log.w(TAG, "Could not use shared RELRO section for %s", new Object[]{r11});
        return;
    }

    @Override // com.ttnet.org.chromium.base.library_loader.Linker
    protected boolean keepMemoryReservationUntilLoad() {
        return false;
    }

    @Override // com.ttnet.org.chromium.base.library_loader.Linker
    protected void loadLibraryImplLocked(String r10, int r11) {
        String r12 = System.mapLibraryName(r10);
        Linker.LibInfo r13 = this.mLocalLibInfo;
        if (nativeLoadLibrary(r12, r13.mLoadAddress, r13) == false) goto L14;
        Linker.LibInfo r14 = this.mLocalLibInfo;
        r14.mLibFilePath = r12;
        if (r11 == 1) goto L10;
        if (r11 == 0) goto L10;
        waitForSharedRelrosLocked();
        useSharedRelrosLocked(this.mRemoteLibInfo);
        this.mRemoteLibInfo.close();
        this.mRemoteLibInfo = null;
        this.mState = 3;
        return;
    L10:
        if (nativeCreateSharedRelro(r12, r14.mLoadAddress, r14) == true) goto L12;
        Log.w(TAG, "Could not create shared RELRO for %s at %x", new Object[]{r12, Long.valueOf(this.mLocalLibInfo.mLoadAddress)});
        this.mLocalLibInfo.mRelroFd = -1;
    L12:
        useSharedRelrosLocked(this.mLocalLibInfo);
        this.mState = 2;
        return;
    L14:
        String r15 = "Unable to load library: " + r12;
        Log.e(TAG, r15, new Object[0]);
        throw new UnsatisfiedLinkError(r15);
    }

    @Override // com.ttnet.org.chromium.base.library_loader.Linker
    void setApkFilePath(String r10) {
        ensureInitializedImplicitlyAsLastResort();
        Object r11 = this.mLock;
        monitor-enter(r11);
        nativeAddZipArchivePath(r10);     // Catch: Throwable -> L7
        monitor-exit(r11);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
