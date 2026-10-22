package com.lynx.tasm.behavior.ui.krypton;

import androidx.annotation.RestrictTo;
import com.lynx.base.log.LynxLog;
import com.lynx.tasm.base.CalledByNative;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.behavior.LynxContext;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class CanvasRuntimeMediator {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Class f10492c;
    public static Constructor d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap f10493a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile boolean f10494b;

    public CanvasRuntimeMediator(LynxContext r5) {
        this.f10493a = new ConcurrentHashMap();
        new ReentrantReadWriteLock(true);
        new ReentrantReadWriteLock(true);
        this.f10494b = false;
        new WeakReference(r5);
    }

    private native long nativeCreate();

    private native void nativeNotifyCanvasInitializeSuccess(long r5);

    private native void nativeReleaseRuntimeMediatorWeakPtr(long r5);

    private native long nativeResetToWeakPtr(long r5);

    @CalledByNative
    private void onAppEnterBackground() {
    }

    @CalledByNative
    private void onAppEnterForeground() {
    }

    @CalledByNative
    private void onRuntimeAttach(long r5) {
    }

    @CalledByNative
    private void onRuntimeCreate(long r5) {
    }

    @CalledByNative
    private void onRuntimeDetach() {
    }

    @CalledByNative
    private void onRuntimeInit(long r5) {
    }

    @CalledByNative
    private void onRuntimeMediatorDestroy() {
    }

    @CalledByNative
    private void setTaskRunner(long r5) {
    }

    @CalledByNative
    private void setupCanvasFromJS() {
        LynxLog.b(2, "KryptonCanvasRuntimeMediator", "[Krypton] setupCanvasFromJS");
        c();
    }

    public final long a() {
        return nativeCreate();
    }

    public final void b(long r5) {
        nativeResetToWeakPtr(r5);
    }

    public final synchronized void c() {
        monitor-enter(this);
        TraceEvent.c("CanvasRuntimeMediator.setupCanvas");     // Catch: Throwable -> L11
        if (this.f10494b == true) goto L22;
        LynxLog.b(2, "KryptonCanvasRuntimeMediator", "[Krypton] Create and init canvas manager");     // Catch: Throwable -> L11
    L13:
        e = move-exception;
        LynxLog.b(4, "KryptonCanvasRuntimeMediator", "[Krypton]  create canvasManager error" + e.toString());     // Catch: Throwable -> L11
    L21:
        LynxLog.b(2, "KryptonCanvasRuntimeMediator", "[Krypton] Init CanvasManager, load so and create KryptonApp");     // Catch: Throwable -> L11
        this.f10494b = true;     // Catch: Throwable -> L11
        TraceEvent.a(0, "CanvasRuntimeMediator.setupCanvas");     // Catch: Throwable -> L11
        goto L22
    L9:
        if (f10492c != null) goto L16;
        f10492c = Class.forName("com.lynx.canvas.CanvasManager");     // Catch: Throwable -> L11 Exception -> L13
    L16:
        if (d != null) goto L18;
        d = f10492c.getConstructor(null);     // Catch: Throwable -> L11 Exception -> L13
    L18:
        d.newInstance(null);     // Catch: Throwable -> L11 Exception -> L13
        LynxLog.b(4, "KryptonCanvasRuntimeMediator", "[Krypton]  create canvasManager error");     // Catch: Throwable -> L11 Exception -> L13
    L22:
        monitor-exit(this);
        return;
    L11:
        th = move-exception;
        throw th;
    }
}
