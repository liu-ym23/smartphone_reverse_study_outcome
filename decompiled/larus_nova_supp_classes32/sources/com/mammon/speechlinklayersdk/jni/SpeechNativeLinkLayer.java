package com.mammon.speechlinklayersdk.jni;

import com.bytedance.librarian.a;
import com.larus.utils.logger.FLogger;
import com.mammon.audiosdk.BuildConfig;
import com.mammon.audiosdk.SAMICore;
import com.mammon.speechaudiosdk.jni.structures.SpeechNativeBlock;
import com.mammon.speechaudiosdk.jni.structures.SpeechNativeProperty;
import com.mammon.speechlinklayersdk.jni.callback.SpeechNativeLinkLayerCallback;
import com.mammon.speechlinklayersdk.param.SpeechLinkLayerUplinkCallbackParam;
import java.util.Objects;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class SpeechNativeLinkLayer {
    public static final String TAG = "mammon SpeechNativeLinkLayer";
    private boolean enableSyncInterface;
    private long nativeHandle;
    private SpeechNativeLinkLayerCallback nativeLinkLayerCallback;
    private final ReentrantReadWriteLock readWriteLock;
    private final SAMICore samiCore;

    private native long Native_SpeechCreateHandle(int r1, Object r2, int[] r3);

    private native int Native_SpeechDestroyHandle(long r1);

    private native int Native_SpeechGetProperty(long r1, int r3, SpeechNativeProperty r4);

    private native int Native_SpeechProcess(long r1, SpeechNativeBlock r3, SpeechNativeBlock r4);

    private native int Native_SpeechSetProperty(long r1, SpeechNativeProperty r3);

    public static /* synthetic */ void access$000(String r0) {
        System.loadLibrary(r0);
    }

    static {
        INVOKESTATIC_com_mammon_speechlinklayersdk_jni_SpeechNativeLinkLayer_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(BuildConfig.LIBNAME);     // Catch: UnsatisfiedLinkError -> L4
        return;
    L4:
        e = move-exception;
        Objects.requireNonNull(e.getLocalizedMessage());
    }

    public void destroyHandle() {
        if (this.nativeHandle != 0) goto L6;
        return;
    L6:
        if (this.enableSyncInterface == false) goto L20;
        this.readWriteLock.writeLock().lock();
    L20:
        long r0 = this.nativeHandle;     // Catch: Throwable -> L15
        if (r0 == 0) goto L12;
        Native_SpeechDestroyHandle(r0);     // Catch: Throwable -> L15
        this.nativeHandle = 0;     // Catch: Throwable -> L15
    L12:
        if (this.enableSyncInterface == false) goto L22;
        this.readWriteLock.writeLock().unlock();
        return;
    L22:
        return;
    L15:
        th = move-exception;
        if (this.enableSyncInterface == false) goto L19;
        this.readWriteLock.writeLock().unlock();
    L19:
        throw th;
    }

    public SpeechNativeLinkLayer() {
        this.samiCore = new SAMICore();
        this.enableSyncInterface = false;
        this.readWriteLock = new ReentrantReadWriteLock();
        this.nativeHandle = 0;
    }

    public long getNativeHandle() {
        return this.nativeHandle;
    }

    @JvmStatic
    public static void INVOKESTATIC_com_mammon_speechlinklayersdk_jni_SpeechNativeLinkLayer_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(String r4) {
        Intrinsics.checkNotNullParameter(r4, "libName");
        FLogger r0 = FLogger.a;
        r0.i("Librarian_loadLib", "loadLibrary start libName -> " + r4);
        a.c(r4);
        r0.i("Librarian_loadLib", "loadLibrary success by librarian -> " + r4);
    }

    public void onUplinkCallback(SpeechLinkLayerUplinkCallbackParam r2) {
        this.nativeLinkLayerCallback.onUplinkCallback(r2);
    }

    public void setEnableSyncInterface(boolean r1) {
        this.enableSyncInterface = r1;
    }

    public void setNativeLinkLayerCallback(SpeechNativeLinkLayerCallback r1) {
        this.nativeLinkLayerCallback = r1;
    }

    public int setProperty(SpeechNativeProperty r7) {
        int r2 = 100010;
        if (this.nativeHandle != 0) goto L6;
        return 100010;
    L6:
        if (this.enableSyncInterface == false) goto L20;
        this.readWriteLock.readLock().lock();
    L20:
        long r0 = this.nativeHandle;     // Catch: Throwable -> L15
        if (r0 == 0) goto L12;
        r2 = Native_SpeechSetProperty(r0, r7);     // Catch: Throwable -> L15
    L12:
        if (this.enableSyncInterface == false) goto L14;
        this.readWriteLock.readLock().unlock();
    L14:
        return r2;
    L15:
        th = move-exception;
        if (this.enableSyncInterface == false) goto L19;
        this.readWriteLock.readLock().unlock();
    L19:
        throw th;
    }

    public int createHandle(int r3, Object r4) {
        if (this.enableSyncInterface == false) goto L5;
        this.readWriteLock.readLock().lock();
    L5:
        int[] r0 = {0};
        this.nativeHandle = Native_SpeechCreateHandle(r3, r4, r0);     // Catch: Throwable -> L12
        if (this.enableSyncInterface == false) goto L11;
        this.readWriteLock.readLock().unlock();
    L11:
        return r0[0];
    L12:
        th = move-exception;
        if (this.enableSyncInterface == false) goto L16;
        this.readWriteLock.readLock().unlock();
    L16:
        throw th;
    }

    public int process(SpeechNativeBlock r6, SpeechNativeBlock r7) {
        if (this.nativeHandle != 0) goto L7;
        return 100010;
    L7:
        if (this.enableSyncInterface == false) goto L23;
        this.readWriteLock.readLock().lock();
    L23:
        long r0 = this.nativeHandle;     // Catch: Throwable -> L18
        if (r0 == 0) goto L13;
        int r8 = Native_SpeechProcess(r0, r6, r7);     // Catch: Throwable -> L18
    L15:
        if (this.enableSyncInterface == false) goto L17;
        this.readWriteLock.readLock().unlock();
    L17:
        return r8;
    L13:
        r8 = 0;
    L18:
        th = move-exception;
        if (this.enableSyncInterface == false) goto L22;
        this.readWriteLock.readLock().unlock();
    L22:
        throw th;
    }
}
