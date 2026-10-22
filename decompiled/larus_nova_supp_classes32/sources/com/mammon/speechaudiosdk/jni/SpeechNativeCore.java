package com.mammon.speechaudiosdk.jni;

import com.bytedance.librarian.a;
import com.larus.utils.logger.FLogger;
import com.mammon.audiosdk.BuildConfig;
import com.mammon.audiosdk.SAMICore;
import com.mammon.speechaudiosdk.jni.callback.SpeechNativeCallback;
import com.mammon.speechaudiosdk.jni.callback.SpeechNativeRecorderAudioConsumerCallback;
import com.mammon.speechaudiosdk.jni.structures.SpeechNativeBlock;
import com.mammon.speechaudiosdk.jni.structures.SpeechNativeProperty;
import com.mammon.speechaudiosdk.jni.structures.SpeechNativeRecorderAudioConsumerCallbackData;
import com.mammon.speechaudiosdk.session.callback.SpeechSessionEventCallback;
import com.mammon.speechaudiosdk.session.param.SpeechHostInjectionDownlinkCallbackParam;
import java.util.Objects;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class SpeechNativeCore {
    private boolean enableSyncInterface;
    private int identify;
    private SpeechNativeCallback nativeCallback;
    private long nativeHandle;
    private final ReentrantReadWriteLock readWriteLock;
    private SpeechNativeRecorderAudioConsumerCallback recorderConsumerCallback;
    private SAMICore samiCore;
    private SpeechSessionEventCallback sessionEventCallback;

    private native long Native_SpeechCreateHandle(int r1, Object r2, int[] r3);

    private native int Native_SpeechDestroyHandle(long r1);

    private native int Native_SpeechGetProperty(long r1, int r3, SpeechNativeProperty r4);

    private native int Native_SpeechProcess(long r1, int r3, SpeechNativeBlock r4, SpeechNativeBlock r5);

    private native int Native_SpeechSetProperty(long r1, SpeechNativeProperty r3);

    public static /* synthetic */ void access$000(String r0) {
        System.loadLibrary(r0);
    }

    static {
        INVOKESTATIC_com_mammon_speechaudiosdk_jni_SpeechNativeCore_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(BuildConfig.LIBNAME);     // Catch: UnsatisfiedLinkError -> L4
        return;
    L4:
        e = move-exception;
        Objects.requireNonNull(e.getLocalizedMessage());
    }

    public void destroyHandle() {
        if (this.enableSyncInterface == false) goto L17;
        this.readWriteLock.writeLock().lock();
    L17:
        long r0 = this.nativeHandle;     // Catch: Throwable -> L12
        if (r0 == 0) goto L9;
        Native_SpeechDestroyHandle(r0);     // Catch: Throwable -> L12
        this.nativeHandle = 0;     // Catch: Throwable -> L12
    L9:
        if (this.enableSyncInterface == false) goto L19;
        this.readWriteLock.writeLock().unlock();
        return;
    L19:
        return;
    L12:
        th = move-exception;
        if (this.enableSyncInterface == false) goto L16;
        this.readWriteLock.writeLock().unlock();
    L16:
        throw th;
    }

    public SpeechNativeCore() {
        this.samiCore = new SAMICore();
        this.enableSyncInterface = false;
        this.readWriteLock = new ReentrantReadWriteLock();
        this.nativeHandle = 0;
    }

    public long getNativeHandle() {
        return this.nativeHandle;
    }

    @JvmStatic
    public static void INVOKESTATIC_com_mammon_speechaudiosdk_jni_SpeechNativeCore_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(String r4) {
        Intrinsics.checkNotNullParameter(r4, "libName");
        FLogger r0 = FLogger.a;
        r0.i("Librarian_loadLib", "loadLibrary start libName -> " + r4);
        a.c(r4);
        r0.i("Librarian_loadLib", "loadLibrary success by librarian -> " + r4);
    }

    public void onDownlinkCallback(SpeechHostInjectionDownlinkCallbackParam r2) {
        SpeechNativeCallback r0 = this.nativeCallback;
        if (r0 == null) goto L6;
        r0.onDownlinkCallback(r2);
        return;
    }

    public void setEnableSyncInterface(boolean r1) {
        this.enableSyncInterface = r1;
    }

    public int setProperty(SpeechNativeProperty r6) {
        if (this.enableSyncInterface == false) goto L19;
        this.readWriteLock.readLock().lock();
    L19:
        long r0 = this.nativeHandle;     // Catch: Throwable -> L14
        if (r0 == 0) goto L9;
        int r7 = Native_SpeechSetProperty(r0, r6);     // Catch: Throwable -> L14
    L11:
        if (this.enableSyncInterface == false) goto L13;
        this.readWriteLock.readLock().unlock();
    L13:
        return r7;
    L9:
        r7 = 100010;
    L14:
        th = move-exception;
        if (this.enableSyncInterface == false) goto L18;
        this.readWriteLock.readLock().unlock();
    L18:
        throw th;
    }

    public void setRecorderAudioConsumerCallback(SpeechNativeRecorderAudioConsumerCallback r1) {
        this.recorderConsumerCallback = r1;
    }

    public void setSessionEventCallback(SpeechSessionEventCallback r1) {
        this.sessionEventCallback = r1;
    }

    public void setSpeechNativeCallback(SpeechNativeCallback r1) {
        this.nativeCallback = r1;
    }

    public int createHandle(int r3, Object r4) {
        if (this.enableSyncInterface == false) goto L5;
        this.readWriteLock.readLock().lock();
    L5:
        this.identify = r3;
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

    public int getProperty(int r3, SpeechNativeProperty r4) {
        return Native_SpeechGetProperty(this.nativeHandle, r3, r4);
    }

    public void onEvent(int r2, String r3) {
        SpeechSessionEventCallback r0 = this.sessionEventCallback;
        if (r0 == null) goto L6;
        r0.onEvent(r2, r3);
        return;
    }

    public int process(SpeechNativeBlock r8, SpeechNativeBlock r9) {
        if (this.enableSyncInterface == false) goto L19;
        this.readWriteLock.readLock().lock();
    L19:
        long r2 = this.nativeHandle;     // Catch: Throwable -> L14
        if (r2 == 0) goto L9;
        int r10 = Native_SpeechProcess(r2, this.identify, r8, r9);     // Catch: Throwable -> L14
    L11:
        if (this.enableSyncInterface == false) goto L13;
        this.readWriteLock.readLock().unlock();
    L13:
        return r10;
    L9:
        r10 = 0;
    L14:
        th = move-exception;
        if (this.enableSyncInterface == false) goto L18;
        this.readWriteLock.readLock().unlock();
    L18:
        throw th;
    }

    public void onRecorderAudioConsumerCallback(int r2, String r3, SpeechNativeRecorderAudioConsumerCallbackData r4) {
        SpeechNativeRecorderAudioConsumerCallback r0 = this.recorderConsumerCallback;
        if (r0 == null) goto L6;
        r0.onCallback(r2, r3, r4);
        return;
    }
}
