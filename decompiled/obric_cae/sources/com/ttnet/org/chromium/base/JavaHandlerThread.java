package com.ttnet.org.chromium.base;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.ttnet.org.chromium.base.annotations.CalledByNative;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import com.ttnet.org.chromium.base.annotations.MainDex;

/* JADX INFO: loaded from: classes2.dex */
@JNINamespace("base::android")
@MainDex
public class JavaHandlerThread {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final HandlerThread mThread;
    private Throwable mUnhandledException;

    public JavaHandlerThread(String r8, int r10) {
        this.mThread = new HandlerThread(r8, r10);
    }

    public static /* synthetic */ void access$000(JavaHandlerThread r8, long r10, long r11) {
        r8.nativeInitializeThread(r10, r11);
    }

    public static /* synthetic */ HandlerThread access$100(JavaHandlerThread r8) {
        return r8.mThread;
    }

    public static /* synthetic */ void access$200(JavaHandlerThread r8, long r10) {
        r8.nativeOnLooperStopped(r10);
    }

    public static /* synthetic */ Throwable access$302(JavaHandlerThread r8, Throwable r10) {
        r8.mUnhandledException = r10;
        return r10;
    }

    @CalledByNative
    private static JavaHandlerThread create(String r8, int r10) {
        return new JavaHandlerThread(r8, r10);
    }

    @CalledByNative
    private Throwable getUncaughtExceptionIfAny() {
        return this.mUnhandledException;
    }

    private boolean hasStarted() {
        if (this.mThread.getState() == Thread.State.NEW) goto L5;
        return true;
    L5:
        return false;
    }

    @CalledByNative
    private boolean isAlive() {
        return this.mThread.isAlive();
    }

    @CalledByNative
    private void joinThread() {
        boolean r8 = false;
    L3:
        if (r8 == true) goto L6;
        this.mThread.join();     // Catch: InterruptedException -> L7
        r8 = true;
        goto L3
    }

    @CalledByNative
    private void listenForUncaughtExceptionsForTesting() {
        this.mThread.setUncaughtExceptionHandler(new AnonymousClass3(this));
    }

    private native void nativeInitializeThread(long r8, long r10);

    private native void nativeOnLooperStopped(long r8);

    @CalledByNative
    private void quitThreadSafely(final long r8) {
        new Handler(this.mThread.getLooper()).post(new AnonymousClass2(this, r8));
        this.mThread.getLooper().quitSafely();
    }

    @CalledByNative
    private void startAndInitialize(final long r10, final long r11) {
        maybeStart();
        new Handler(this.mThread.getLooper()).post(new AnonymousClass1(this, r10, r11));
    }

    public Looper getLooper() {
        return this.mThread.getLooper();
    }

    public void maybeStart() {
        if (hasStarted() == false) goto L5;
        return;
    L5:
        this.mThread.start();
    }
}
