package com.ttnet.org.chromium.base.library_loader;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.ttnet.org.chromium.base.Log;
import com.ttnet.org.chromium.base.StreamUtil;
import com.ttnet.org.chromium.base.TimeUtils;
import com.ttnet.org.chromium.base.annotations.AccessedByNative;
import com.ttnet.org.chromium.base.metrics.RecordHistogram;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes2.dex */
abstract class Linker {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String BASE_LOAD_ADDRESS = "com.ttnet.org.chromium.base.android.linker.base_load_address";
    protected static final boolean DEBUG = false;
    protected static final String LINKER_JNI_LIBRARY = "chromium_android_linker";

    @VisibleForTesting(otherwise = 2)
    static final String SHARED_RELROS = "com.ttnet.org.chromium.base.android.linker.shared_relros";
    private static final String TAG = "Linker";
    private static Linker sLinkerForAssert;
    private static Natives sNativesInstance;
    private boolean mLinkerWasWaitingSynchronously;
    protected LibInfo mLocalLibInfo;
    protected final Object mLock;

    @VisibleForTesting(otherwise = 2)
    boolean mRelroProducer;
    protected LibInfo mRemoteLibInfo;
    protected int mState;

    @VisibleForTesting(otherwise = 2)
    WebViewReservationSearchResult mWebviewReservationSearchResult;

    @VisibleForTesting(otherwise = 4)
    static class LibInfo implements Parcelable {
        public static final Parcelable.Creator<LibInfo> CREATOR = null;
        private static final String EXTRA_LINKER_LIB_INFO = "libinfo";
        public String mLibFilePath;

        @AccessedByNative
        public long mLoadAddress;

        @AccessedByNative
        public long mLoadSize;

        @AccessedByNative
        public int mRelroFd;

        @AccessedByNative
        public long mRelroSize;

        @AccessedByNative
        public long mRelroStart;

        static {
            CREATOR = new AnonymousClass1();
        }

        LibInfo() {
            this.mRelroFd = -1;
        }

        LibInfo(Parcel r10) {
            this.mRelroFd = -1;
            this.mLibFilePath = r10.readString();
            this.mLoadAddress = r10.readLong();
            this.mLoadSize = r10.readLong();
            this.mRelroStart = r10.readLong();
            this.mRelroSize = r10.readLong();
            if (r10.readInt() == 0) goto L5;
            boolean r11 = true;
        L6:
            if (r11 == false) goto L10;
            ParcelFileDescriptor r12 = (ParcelFileDescriptor) ParcelFileDescriptor.CREATOR.createFromParcel(r10);
            if (r12 == null) goto L12;
            this.mRelroFd = r12.detachFd();
            return;
        L12:
            return;
        L10:
            this.mRelroFd = -1;
            return;
        L5:
            r11 = false;
            goto L6
        }

        public static LibInfo fromBundle(Bundle r10) {
            r10.setClassLoader(Linker.class.getClassLoader());
            return (LibInfo) r10.getParcelable(EXTRA_LINKER_LIB_INFO);
        }

        public void close() {
            int r10 = this.mRelroFd;
            if (r10 < 0) goto L6;
            StreamUtil.closeQuietly(ParcelFileDescriptor.adoptFd(r10));
            this.mRelroFd = -1;
            return;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 1;
        }

        public Bundle toBundle() {
            Bundle r10 = new Bundle();
            r10.putParcelable(EXTRA_LINKER_LIB_INFO, this);
            return r10;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel r10, int r11) {
            r10.writeString(this.mLibFilePath);
            r10.writeLong(this.mLoadAddress);
            r10.writeLong(this.mLoadSize);
            r10.writeLong(this.mRelroStart);
            r10.writeLong(this.mRelroSize);
            if (this.mRelroFd < 0) goto L5;
            int r12 = 1;
        L6:
            r10.writeInt(r12);
            int r13 = this.mRelroFd;
            if (r13 < 0) goto L15;
            ParcelFileDescriptor r14 = ParcelFileDescriptor.fromFd(r13);     // Catch: IOException -> L10
            r14.writeToParcel(r10, 0);     // Catch: IOException -> L10
            r14.close();     // Catch: IOException -> L10
            return;
        L10:
            e = move-exception;
            Log.e(Linker.TAG, "Can't write LibInfo file descriptor to parcel", new Object[]{e});
            return;
        L15:
            return;
        L5:
            r12 = 0;
            goto L6
        }
    }

    interface Natives {
        void findMemoryRegionAtRandomAddress(@NonNull LibInfo r10, boolean r11);

        boolean findRegionReservedByWebViewZygote(@NonNull LibInfo r10);

        void reserveMemoryForLibrary(@NonNull LibInfo r10);
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface PreferAddress {
        public static final int FIND_RESERVED = 0;
        public static final int RESERVE_HINT = 1;
        public static final int RESERVE_RANDOM = 2;
    }

    @Retention(RetentionPolicy.SOURCE)
    protected @interface RelroSharingMode {
        public static final int CONSUME = 2;
        public static final int NO_SHARING = 0;
        public static final int PRODUCE = 1;
    }

    @Retention(RetentionPolicy.SOURCE)
    protected @interface State {
        public static final int DONE = 3;
        public static final int DONE_PROVIDE_RELRO = 2;
        public static final int INITIALIZED = 1;
        public static final int UNINITIALIZED = 0;
    }

    private static class WebViewReservationSearchResult {
        private final long mDurationMs;
        private final boolean mSuccess;

        WebViewReservationSearchResult(boolean r10, long r11) {
            this.mSuccess = r10;
            this.mDurationMs = r11;
        }

        static /* synthetic */ void access$000(WebViewReservationSearchResult r10, String r11) {
            r10.recordHistograms(r11);
        }

        private void recordHistograms(String r10) {
            if (this.mSuccess == false) goto L5;
            String r11 = "Found";
        L6:
            RecordHistogram.recordTimesHistogram("ChromiumAndroidLinker.TimeToFindWebViewReservation." + r11 + "." + r10, this.mDurationMs);
            return;
        L5:
            r11 = "NotFound";
            goto L6
        }
    }

    static {
    }

    protected Linker() {
        this.mLock = new Object();
        this.mRelroProducer = true;
        this.mState = 0;
        sLinkerForAssert = this;
    }

    private void attemptLoadLibraryLocked(String r10, int r11) {
        loadLibraryImplLocked(r10, r11);     // Catch: Throwable -> L8
        if (shouldAtomicallyReplaceRelroAfterLoad() == false) goto L6;
        atomicReplaceRelroLocked(true);     // Catch: Throwable -> L8
    L6:
        this.mLinkerWasWaitingSynchronously = false;
        return;
    L8:
        th = move-exception;
        this.mLinkerWasWaitingSynchronously = false;
        throw th;
    }

    private void chooseAndReserveMemoryRange(boolean r10, int r11, long r12) {
        this.mLocalLibInfo = new LibInfo();
        this.mRelroProducer = r10;
        loadLinkerJniLibraryLocked();
        boolean r13 = keepMemoryReservationUntilLoad();
        if (r11 != 0) goto L5;
        TimeUtils.UptimeMillisTimer r14 = new TimeUtils.UptimeMillisTimer();
        boolean r15 = getLinkerJni().findRegionReservedByWebViewZygote(this.mLocalLibInfo);
        saveWebviewReservationSearchStats(r15, r14.getElapsedMillis());
        if (r15 == true) goto L12;
    L16:
        this.mLocalLibInfo.mLoadAddress = r12;
        if (r12 == 0) goto L23;
        if (r13 == true) goto L20;
        return;
    L20:
        getLinkerJni().reserveMemoryForLibrary(this.mLocalLibInfo);
        if (this.mLocalLibInfo.mLoadAddress == 0) goto L23;
        return;
    L23:
        getLinkerJni().findMemoryRegionAtRandomAddress(this.mLocalLibInfo, r13);
        return;
    L12:
        if (r12 != 0) goto L14;
        return;
    L14:
        if (r12 != this.mLocalLibInfo.mLoadAddress) goto L16;
        return;
    L5:
        if (r11 == 1) goto L16;
        if (r11 == 2) goto L23;
    }

    static long extractLoadAddressFromBundle(Bundle r10) {
        return r10.getLong(BASE_LOAD_ADDRESS, 0);
    }

    @VisibleForTesting(otherwise = 2)
    static Natives getLinkerJni() {
        Natives r10 = sNativesInstance;
        if (r10 == null) goto L6;
        return r10;
    L6:
        return new LinkerJni();
    }

    private String preferAddressToString(int r10) {
        if (r10 != 0) goto L4;
        return "FIND_RESERVED";
    L4:
        if (r10 != 1) goto L6;
        return "RESERVE_HINT";
    L6:
        if (r10 != 2) goto L8;
        return "RESERVE_RANDOM";
    L8:
        return String.valueOf(r10);
    }

    private void saveWebviewReservationSearchStats(boolean r10, long r11) {
        this.mWebviewReservationSearchResult = new WebViewReservationSearchResult(r10, r11);
    }

    static void setNativesForTesting(Natives r10) {
        sNativesInstance = r10;
        sLinkerForAssert = null;
    }

    private boolean shouldAtomicallyReplaceRelroAfterLoad() {
        if (this.mLinkerWasWaitingSynchronously == false) goto L6;
        return false;
    L6:
        if (this.mRemoteLibInfo != null) goto L8;
        return false;
    L8:
        if (this.mState == 3) goto L10;
        return false;
    L10:
        if (this.mLocalLibInfo.mLoadAddress == 0) goto L15;
        return true;
    L15:
        return false;
    }

    protected void atomicReplaceRelroLocked(boolean r10) {
    }

    final void ensureInitialized(boolean r10, int r11, long r12) {
        Object r13 = this.mLock;
        monitor-enter(r13);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.mState == 0) goto L8;
        monitor-exit(r13);     // Catch: Throwable -> L11
        return;
    L8:
        chooseAndReserveMemoryRange(r10, r11, r12);     // Catch: Throwable -> L11
        this.mState = 1;     // Catch: Throwable -> L11
        monitor-exit(r13);     // Catch: Throwable -> L11
    }

    protected final void ensureInitializedImplicitlyAsLastResort() {
        ensureInitialized(true, 2, 0);
    }

    @VisibleForTesting(otherwise = 2)
    boolean isNonZeroLoadAddress(LibInfo r10) {
        if (r10 != null) goto L4;
    L6:
        return false;
    L4:
        if (r10.mLoadAddress == 0) goto L6;
        return true;
    }

    protected abstract boolean keepMemoryReservationUntilLoad();

    final void loadLibrary(String r10) {
        Object r11 = this.mLock;
        monitor-enter(r11);
        ensureInitializedImplicitlyAsLastResort();     // Catch: Throwable -> L10 UnsatisfiedLinkError -> L12
        if (this.mRelroProducer == false) goto L7;
        int r12 = 1;
    L8:
        attemptLoadLibraryLocked(r10, r12);     // Catch: Throwable -> L10 UnsatisfiedLinkError -> L12
    L14:
        monitor-exit(r11);     // Catch: Throwable -> L10
        return;
    L7:
        r12 = 2;
    L10:
        th = move-exception;
        throw th;
    L12:
        Log.w(TAG, "Failed to load native library with shared RELRO, retrying without", new Object[0]);     // Catch: Throwable -> L10
        this.mLocalLibInfo.mLoadAddress = 0;     // Catch: Throwable -> L10 UnsatisfiedLinkError -> L16
        attemptLoadLibraryLocked(r10, 0);     // Catch: Throwable -> L10 UnsatisfiedLinkError -> L16
    L16:
        e = move-exception;
        Log.w(TAG, "Failed to load native library without RELRO sharing", new Object[0]);     // Catch: Throwable -> L10
        throw e;     // Catch: Throwable -> L10
    }

    protected abstract void loadLibraryImplLocked(String r10, int r11);

    @SuppressLint({"UnsafeDynamicallyLoadedCode"})
    @VisibleForTesting(otherwise = 2)
    void loadLinkerJniLibraryLocked() {
        LibraryLoader.setEnvForNative();
        System.loadLibrary(LINKER_JNI_LIBRARY);
    }

    void pretendLibraryIsLoadedForTesting() {
        Object r10 = this.mLock;
        monitor-enter(r10);
        this.mState = 3;     // Catch: Throwable -> L8
        monitor-exit(r10);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    void putLoadAddressToBundle(Bundle r10) {
        Object r11 = this.mLock;
        monitor-enter(r11);
        LibInfo r12 = this.mLocalLibInfo;     // Catch: Throwable -> L13
        if (r12 == null) goto L9;
        long r13 = r12.mLoadAddress;     // Catch: Throwable -> L13
        if (r13 == 0) goto L9;
        r10.putLong(BASE_LOAD_ADDRESS, r13);     // Catch: Throwable -> L13
    L9:
        monitor-exit(r11);     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        throw th;
    }

    void putSharedRelrosToBundle(Bundle r10) {
        Object r11 = this.mLock;
        monitor-enter(r11);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.mState != 2) goto L7;
        Bundle r12 = this.mLocalLibInfo.toBundle();     // Catch: Throwable -> L11
    L8:
        r10.putBundle(SHARED_RELROS, r12);     // Catch: Throwable -> L11
        monitor-exit(r11);     // Catch: Throwable -> L11
        return;
    L7:
        r12 = null;
        goto L8
    }

    void recordHistograms(String r10) {
        Object r11 = this.mLock;
        monitor-enter(r11);
        WebViewReservationSearchResult r12 = this.mWebviewReservationSearchResult;     // Catch: Throwable -> L11
        if (r12 != null) goto L8;
        monitor-exit(r11);     // Catch: Throwable -> L11
        return;
    L8:
        WebViewReservationSearchResult.access$000(r12, r10);     // Catch: Throwable -> L11
        monitor-exit(r11);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    }

    void setApkFilePath(String r10) {
    }

    void takeSharedRelrosFromBundle(Bundle r10) {
        Bundle r11 = r10.getBundle(SHARED_RELROS);
        if (r11 != null) goto L5;
        return;
    L5:
        LibInfo r12 = LibInfo.fromBundle(r11);
        if (r12 != null) goto L8;
        return;
    L8:
        Object r13 = this.mLock;
        monitor-enter(r13);
        LibInfo r14 = this.mRemoteLibInfo;     // Catch: Throwable -> L24
        if (r14 != null) goto L13;
    L16:
        this.mRemoteLibInfo = r12;     // Catch: Throwable -> L24
        int r15 = this.mState;     // Catch: Throwable -> L24
        if (r15 != 3) goto L20;
        atomicReplaceRelroLocked(false);     // Catch: Throwable -> L24
    L22:
        monitor-exit(r13);     // Catch: Throwable -> L24
        return;
    L20:
        if (r15 == 2) goto L22;
        this.mLock.notifyAll();     // Catch: Throwable -> L24
        goto L22
    L13:
        if (r14.mRelroFd == (-1)) goto L16;
        monitor-exit(r13);     // Catch: Throwable -> L24
        return;
    L24:
        th = move-exception;
        throw th;
    }

    protected final void waitForSharedRelrosLocked() {
        this.mLinkerWasWaitingSynchronously = true;
    L4:
        if (this.mRemoteLibInfo != null) goto L7;
        this.mLock.wait();     // Catch: InterruptedException -> L8
        goto L4
    }
}
