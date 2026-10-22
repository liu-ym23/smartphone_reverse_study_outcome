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

    interface Natives {
        void initializeThread(long r10, long r11);

        void onLooperStopped(long r10);
    }

    static {
    }

    public JavaHandlerThread(String r10, int r11) {
        this.mThread = new HandlerThread(r10, r11);
    }

    static /* synthetic */ HandlerThread access$000(JavaHandlerThread r10) {
        return r10.mThread;
    }

    static /* synthetic */ Throwable access$102(JavaHandlerThread r10, Throwable r11) {
        r10.mUnhandledException = r11;
        return r11;
    }

    @CalledByNative
    private static JavaHandlerThread create(String r10, int r11) {
        return new JavaHandlerThread(r10, r11);
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
        boolean r10 = false;
    L3:
        if (r10 == true) goto L6;
        this.mThread.join();     // Catch: InterruptedException -> L7
        r10 = true;
        goto L3
    }

    @CalledByNative
    private void listenForUncaughtExceptionsForTesting() {
        this.mThread.setUncaughtExceptionHandler(new AnonymousClass3(this));
    }

    @CalledByNative
    private void quitThreadSafely(final long r10) {
        new Handler(this.mThread.getLooper()).post(new AnonymousClass2(this, r10));
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
