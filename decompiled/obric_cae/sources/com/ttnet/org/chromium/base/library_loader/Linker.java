package com.ttnet.org.chromium.base.library_loader;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.ttnet.org.chromium.base.ContextUtils;
import com.ttnet.org.chromium.base.Log;
import com.ttnet.org.chromium.base.StreamUtil;
import com.ttnet.org.chromium.base.SysUtils;
import com.ttnet.org.chromium.base.annotations.AccessedByNative;
import defpackage.b;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class Linker {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int ADDRESS_SPACE_RESERVATION = 201326592;
    public static final int BROWSER_SHARED_RELRO_CONFIG = 1;
    public static final int BROWSER_SHARED_RELRO_CONFIG_ALWAYS = 2;
    public static final int BROWSER_SHARED_RELRO_CONFIG_LOW_RAM_ONLY = 1;
    public static final int BROWSER_SHARED_RELRO_CONFIG_NEVER = 0;
    protected static final boolean DEBUG = false;
    public static final String EXTRA_LINKER_SHARED_RELROS = "org.chromium.base.android.linker.shared_relros";
    private static final String LINKER_JNI_LIBRARY = "chromium_android_linker";
    public static final int MEMORY_DEVICE_CONFIG_INIT = 0;
    public static final int MEMORY_DEVICE_CONFIG_LOW = 1;
    public static final int MEMORY_DEVICE_CONFIG_NORMAL = 2;
    private static final String TAG = "LibraryLoader";
    private static final Linker sSingleton = null;
    private long mBaseLoadAddress;
    private boolean mBrowserUsesSharedRelro;
    private long mCurrentLoadAddress;
    private boolean mInBrowserProcess;
    private boolean mInitialized;
    private HashMap<String, LibInfo> mLoadedLibraries;
    protected final Object mLock;
    private int mMemoryDeviceConfig;
    private boolean mPrepareLibraryLoadCalled;
    private Bundle mSharedRelros;
    private String mTestRunnerClassName;
    private boolean mWaitForSharedRelros;

    public static class LibInfo implements Parcelable {
        public static final Parcelable.Creator<LibInfo> CREATOR = null;

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

        public LibInfo() {
            this.mRelroFd = -1;
        }

        public void close() {
            int r8 = this.mRelroFd;
            if (r8 < 0) goto L6;
            StreamUtil.closeQuietly(ParcelFileDescriptor.adoptFd(r8));
            this.mRelroFd = -1;
            return;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 1;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel r8, int r10) {
            if (this.mRelroFd < 0) goto L12;
            r8.writeLong(this.mLoadAddress);
            r8.writeLong(this.mLoadSize);
            r8.writeLong(this.mRelroStart);
            r8.writeLong(this.mRelroSize);
            ParcelFileDescriptor r11 = ParcelFileDescriptor.fromFd(this.mRelroFd);     // Catch: IOException -> L7
            r11.writeToParcel(r8, 0);     // Catch: IOException -> L7
            r11.close();     // Catch: IOException -> L7
            return;
        L7:
            e = move-exception;
            Log.e(Linker.TAG, "Can't write LibInfo file descriptor to parcel", new Object[]{e});
            return;
        }

        public LibInfo(Parcel r8) {
            this.mRelroFd = -1;
            this.mLoadAddress = r8.readLong();
            this.mLoadSize = r8.readLong();
            this.mRelroStart = r8.readLong();
            this.mRelroSize = r8.readLong();
            ParcelFileDescriptor r10 = (ParcelFileDescriptor) ParcelFileDescriptor.CREATOR.createFromParcel(r8);
            if (r10 == null) goto L6;
            this.mRelroFd = r10.detachFd();
            return;
        }
    }

    public interface TestRunner {
        boolean runChecks(int r8, boolean r10);
    }

    static {
        sSingleton = new Linker();
    }

    private Linker() {
        this.mMemoryDeviceConfig = 0;
        this.mLock = new Object();
        this.mInBrowserProcess = true;
        this.mBaseLoadAddress = -1;
        this.mCurrentLoadAddress = -1;
    }

    public static boolean areTestsEnabled() {
        return NativeLibraries.sEnableLinkerTests;
    }

    private static void assertLinkerTestsAreEnabled() {
    }

    private void closeLibInfoMap(HashMap<String, LibInfo> r8) {
        Iterator<Map.Entry<String, LibInfo>> r10 = r8.entrySet().iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        r10.next().getValue().close();
        goto L4
    }

    private Bundle createBundleFromLibInfoMap(HashMap<String, LibInfo> r8) {
        Bundle r10 = new Bundle(r8.size());
        Iterator<Map.Entry<String, LibInfo>> r11 = r8.entrySet().iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        Map.Entry<String, LibInfo> r12 = r11.next();
        r10.putParcelable(r12.getKey(), r12.getValue());
        goto L4
    L6:
        return r10;
    }

    private HashMap<String, LibInfo> createLibInfoMapFromBundle(Bundle r8) {
        HashMap<String, LibInfo> r10 = new HashMap();
        Iterator<String> r11 = r8.keySet().iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        String r12 = r11.next();
        r10.put(r12, (LibInfo) r8.getParcelable(r12));
        goto L4
    L6:
        return r10;
    }

    private void dumpBundle(Bundle r8) {
    }

    private void ensureInitializedLocked() {
        if (this.mInitialized == false) goto L5;
        return;
    L5:
        loadLinkerJniLibrary();
        if (this.mMemoryDeviceConfig != 0) goto L12;
        if (SysUtils.isLowEndDevice() == false) goto L10;
        this.mMemoryDeviceConfig = 1;
        goto L12
    L10:
        this.mMemoryDeviceConfig = 2;
    L12:
        if (this.mMemoryDeviceConfig != 1) goto L14;
        this.mBrowserUsesSharedRelro = true;
        Log.w(TAG, "Low-memory device: shared RELROs used in all processes", new Object[0]);
    L15:
        this.mInitialized = true;
        return;
    L14:
        this.mBrowserUsesSharedRelro = false;
        goto L15
    }

    public static Linker getInstance() {
        return sSingleton;
    }

    private long getRandomBaseLoadAddress() {
        return nativeGetRandomBaseLoadAddress();
    }

    @SuppressLint({"UnsafeDynamicallyLoadedCode"})
    private static void loadLinkerJniLibrary() {
        LibraryLoader.setEnvForNative();
        System.loadLibrary(LINKER_JNI_LIBRARY);     // Catch: UnsatisfiedLinkError -> L5
        LibraryLoader.incrementRelinkerCountNotHitHistogram();     // Catch: UnsatisfiedLinkError -> L5
        return;
    L6:
        if (LibraryLoader.PLATFORM_REQUIRES_NATIVE_FALLBACK_EXTRACTION == false) goto L11;
        System.load(LibraryLoader.getExtractedLibraryPath(ContextUtils.getApplicationContext().getApplicationInfo(), LINKER_JNI_LIBRARY));
        LibraryLoader.incrementRelinkerCountHitHistogram();
        return;
    }

    private static native boolean nativeAddZipArchivePath(String r8);

    private static native boolean nativeCreateSharedRelro(String r8, long r10, LibInfo r11);

    private static native long nativeGetRandomBaseLoadAddress();

    private static native boolean nativeLoadLibrary(String r8, long r10, LibInfo r11);

    private static native boolean nativeUseSharedRelro(String r8, LibInfo r10);

    private final void runTestRunnerClassForTesting(int r8, boolean r10) {
        assertLinkerTestsAreEnabled();
        Object r11 = this.mLock;
        monitor-enter(r11);
    L17:
        th = move-exception;
        throw th;
    L5:
        if (this.mTestRunnerClassName != null) goto L22;
        Log.wtf(TAG, "Linker runtime tests not set up for this process", new Object[0]);     // Catch: Throwable -> L17
    L22:
        TestRunner r12 = (TestRunner) Class.forName(this.mTestRunnerClassName).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);     // Catch: Exception -> L9 Throwable -> L17
    L12:
        if (r12.runChecks(r8, r10) == true) goto L14;
        Log.wtf(TAG, "Linker runtime tests failed in this process", new Object[0]);     // Catch: Throwable -> L17
    L14:
        Log.i(TAG, "All linker tests passed", new Object[0]);     // Catch: Throwable -> L17
        monitor-exit(r11);     // Catch: Throwable -> L17
        return;
    L9:
        e = move-exception;
        Log.wtf(TAG, "Could not instantiate test runner class by name", new Object[]{e});     // Catch: Throwable -> L17
        r12 = null;
        goto L12
    }

    private void setupBaseLoadAddressLocked() {
        if (this.mBaseLoadAddress != (-1)) goto L8;
        long r8 = getRandomBaseLoadAddress();
        this.mBaseLoadAddress = r8;
        this.mCurrentLoadAddress = r8;
        if (r8 != 0) goto L9;
        Log.w(TAG, "Disabling shared RELROs due address space pressure", new Object[0]);
        this.mBrowserUsesSharedRelro = false;
        this.mWaitForSharedRelros = false;
        return;
    L9:
        return;
    }

    public static final void setupForTesting(String r8) {
        assertLinkerTestsAreEnabled();
        Linker r10 = sSingleton;
        monitor-enter(r10);
        r10.mTestRunnerClassName = r8;     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void useSharedRelrosLocked(Bundle r8) {
        if (r8 != null) goto L5;
        return;
    L5:
        if (this.mLoadedLibraries != null) goto L7;
        return;
    L7:
        HashMap<String, LibInfo> r10 = createLibInfoMapFromBundle(r8);
        Iterator<Map.Entry<String, LibInfo>> r11 = r10.entrySet().iterator();
    L9:
        if (r11.hasNext() == false) goto L14;
        Map.Entry<String, LibInfo> r12 = r11.next();
        String r13 = r12.getKey();
        if (nativeUseSharedRelro(r13, r12.getValue()) == true) goto L9;
        Log.w(TAG, b.c("Could not use shared RELRO section for ", r13), new Object[0]);
        goto L9
    L14:
        if (this.mInBrowserProcess == true) goto L22;
        closeLibInfoMap(r10);
        return;
    }

    public void disableSharedRelros() {
        Object r8 = this.mLock;
        monitor-enter(r8);
        ensureInitializedLocked();     // Catch: Throwable -> L7
        this.mInBrowserProcess = false;     // Catch: Throwable -> L7
        this.mWaitForSharedRelros = false;     // Catch: Throwable -> L7
        this.mBrowserUsesSharedRelro = false;     // Catch: Throwable -> L7
        monitor-exit(r8);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void finishLibraryLoad() {
        Object r8 = this.mLock;
        monitor-enter(r8);
        ensureInitializedLocked();     // Catch: Throwable -> L25
        HashMap<String, LibInfo> r10 = this.mLoadedLibraries;     // Catch: Throwable -> L25
        if (r10 != null) goto L8;
    L21:
        if (NativeLibraries.sEnableLinkerTests == false) goto L23;
        runTestRunnerClassForTesting(this.mMemoryDeviceConfig, this.mInBrowserProcess);     // Catch: Throwable -> L25
    L23:
        monitor-exit(r8);     // Catch: Throwable -> L25
        return;
    L8:
        if (this.mInBrowserProcess == false) goto L13;
        Bundle r11 = createBundleFromLibInfoMap(r10);     // Catch: Throwable -> L25
        this.mSharedRelros = r11;     // Catch: Throwable -> L25
        if (this.mBrowserUsesSharedRelro == false) goto L13;
        useSharedRelrosLocked(r11);     // Catch: Throwable -> L25
    L13:
        if (this.mWaitForSharedRelros == false) goto L21;
    L14:
        Bundle r12 = this.mSharedRelros;     // Catch: Throwable -> L25
        if (r12 != null) goto L19;
        this.mLock.wait();     // Catch: InterruptedException -> L18 Throwable -> L25
    L18:
        Thread.currentThread().interrupt();     // Catch: Throwable -> L25
        goto L14
    L19:
        useSharedRelrosLocked(r12);     // Catch: Throwable -> L25
        this.mSharedRelros.clear();     // Catch: Throwable -> L25
        this.mSharedRelros = null;     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        throw th;
    }

    public long getBaseLoadAddress() {
        Object r8 = this.mLock;
        monitor-enter(r8);
        ensureInitializedLocked();     // Catch: Throwable -> L13
        if (this.mInBrowserProcess == true) goto L10;
        Log.w(TAG, "Shared RELRO sections are disabled in this process!", new Object[0]);     // Catch: Throwable -> L13
        monitor-exit(r8);     // Catch: Throwable -> L13
        return 0;
    L10:
        setupBaseLoadAddressLocked();     // Catch: Throwable -> L13
        long r10 = this.mBaseLoadAddress;     // Catch: Throwable -> L13
        monitor-exit(r8);     // Catch: Throwable -> L13
        return r10;
    L13:
        th = move-exception;
        throw th;
    }

    public Bundle getSharedRelros() {
        Object r8 = this.mLock;
        monitor-enter(r8);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (this.mInBrowserProcess == true) goto L9;
        monitor-exit(r8);     // Catch: Throwable -> L12
        return null;
    L9:
        Bundle r10 = this.mSharedRelros;     // Catch: Throwable -> L12
        monitor-exit(r8);     // Catch: Throwable -> L12
        return r10;
    }

    public final String getTestRunnerClassNameForTesting() {
        assertLinkerTestsAreEnabled();
        Object r8 = this.mLock;
        monitor-enter(r8);
        String r10 = this.mTestRunnerClassName;     // Catch: Throwable -> L7
        monitor-exit(r8);     // Catch: Throwable -> L7
        return r10;
    L7:
        th = move-exception;
        throw th;
    }

    public void initServiceProcess(long r8) {
        Object r10 = this.mLock;
        monitor-enter(r10);
        ensureInitializedLocked();     // Catch: Throwable -> L7
        this.mInBrowserProcess = false;     // Catch: Throwable -> L7
        this.mBrowserUsesSharedRelro = false;     // Catch: Throwable -> L7
        this.mWaitForSharedRelros = true;     // Catch: Throwable -> L7
        this.mBaseLoadAddress = r8;     // Catch: Throwable -> L7
        this.mCurrentLoadAddress = r8;     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public boolean isChromiumLinkerLibrary(String r8) {
        return r8.equals(LINKER_JNI_LIBRARY);
    }

    public boolean isUsingBrowserSharedRelros() {
        Object r8 = this.mLock;
        monitor-enter(r8);
        ensureInitializedLocked();     // Catch: Throwable -> L12
        if (this.mInBrowserProcess == true) goto L7;
    L9:
        boolean r10 = false;
    L10:
        monitor-exit(r8);     // Catch: Throwable -> L12
        return r10;
    L7:
        if (this.mBrowserUsesSharedRelro == false) goto L9;
        r10 = true;
    L12:
        th = move-exception;
        throw th;
    }

    public void loadLibrary(String r8) {
        loadLibraryImpl(r8, true);
    }

    public void loadLibraryImpl(String r17, boolean r18) {
        Object r8 = this.mLock;
        monitor-enter(r8);
        ensureInitializedLocked();     // Catch: Throwable -> L49
        if (this.mLoadedLibraries != null) goto L8;
        this.mLoadedLibraries = new HashMap();     // Catch: Throwable -> L49
    L8:
        if (this.mLoadedLibraries.containsKey(r17) == false) goto L11;
        monitor-exit(r8);     // Catch: Throwable -> L49
        return;
    L11:
        LibInfo r10 = new LibInfo();     // Catch: Throwable -> L49
        if (r18 == true) goto L14;
    L24:
        long r11 = 0;
    L26:
        if (nativeLoadLibrary(r17, r11, r10) == true) goto L28;
        String r12 = "Unable to load library: " + r17;     // Catch: Throwable -> L49
        Log.e(TAG, r12, new Object[0]);     // Catch: Throwable -> L49
        throw new UnsatisfiedLinkError(r12);     // Catch: Throwable -> L49
    L28:
        if (NativeLibraries.sEnableLinkerTests == false) goto L35;
        if (this.mInBrowserProcess == false) goto L32;
        String r13 = "BROWSER_LIBRARY_ADDRESS";
    L33:
        Log.i(TAG, String.format(Locale.US, "%s: %s %x", new Object[]{r13, r17, Long.valueOf(r10.mLoadAddress)}), new Object[0]);     // Catch: Throwable -> L49
        goto L35
    L32:
        r13 = "RENDERER_LIBRARY_ADDRESS";
    L35:
        if (this.mInBrowserProcess == false) goto L40;
        if (nativeCreateSharedRelro(r17, this.mCurrentLoadAddress, r10) == true) goto L40;
        Log.w(TAG, String.format(Locale.US, "Could not create shared RELRO for %s at %x", new Object[]{r17, Long.valueOf(this.mCurrentLoadAddress)}), new Object[0]);     // Catch: Throwable -> L49
    L40:
        if (r11 != 0) goto L42;
    L44:
        this.mLoadedLibraries.put(r17, r10);     // Catch: Throwable -> L49
        monitor-exit(r8);     // Catch: Throwable -> L49
        return;
    L42:
        if (this.mCurrentLoadAddress == 0) goto L44;
        this.mCurrentLoadAddress = r10.mLoadAddress + r10.mLoadSize;     // Catch: Throwable -> L49
        goto L44
    L14:
        if (this.mInBrowserProcess == false) goto L18;
        if (this.mBrowserUsesSharedRelro == false) goto L18;
    L19:
        r11 = this.mCurrentLoadAddress;     // Catch: Throwable -> L49
        if (r11 <= (this.mBaseLoadAddress + 201326592)) goto L26;
        String r14 = "Load address outside reservation, for: " + r17;     // Catch: Throwable -> L49
        Log.e(TAG, r14, new Object[0]);     // Catch: Throwable -> L49
        throw new UnsatisfiedLinkError(r14);     // Catch: Throwable -> L49
    L18:
        if (this.mWaitForSharedRelros == false) goto L24;
    L49:
        th = move-exception;
        throw th;
    }

    public void loadLibraryNoFixedAddress(String r8) {
        loadLibraryImpl(r8, false);
    }

    public void prepareLibraryLoad(String r8) {
        Object r10 = this.mLock;
        monitor-enter(r10);
        ensureInitializedLocked();     // Catch: Throwable -> L12
        if (r8 == null) goto L7;
        nativeAddZipArchivePath(r8);     // Catch: Throwable -> L12
    L7:
        this.mPrepareLibraryLoadCalled = true;     // Catch: Throwable -> L12
        if (this.mInBrowserProcess == false) goto L10;
        setupBaseLoadAddressLocked();     // Catch: Throwable -> L12
    L10:
        monitor-exit(r10);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public final void setMemoryDeviceConfigForTesting(int r8) {
        assertLinkerTestsAreEnabled();
        Object r10 = this.mLock;
        monitor-enter(r10);
        this.mMemoryDeviceConfig = r8;     // Catch: Throwable -> L9
        monitor-exit(r10);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public void useSharedRelros(Bundle r8) {
        if (r8 == null) goto L4;
        r8.setClassLoader(LibInfo.class.getClassLoader());
        Bundle r10 = new Bundle(LibInfo.class.getClassLoader());
        Parcel r11 = Parcel.obtain();
        r8.writeToParcel(r11, 0);
        r11.setDataPosition(0);
        r10.readFromParcel(r11);
        r11.recycle();
    L5:
        Object r12 = this.mLock;
        monitor-enter(r12);
        this.mSharedRelros = r10;     // Catch: Throwable -> L10
        this.mLock.notifyAll();     // Catch: Throwable -> L10
        monitor-exit(r12);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    L4:
        r10 = null;
        goto L5
    }
}
