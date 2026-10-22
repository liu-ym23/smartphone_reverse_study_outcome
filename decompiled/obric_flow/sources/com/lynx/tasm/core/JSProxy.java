package com.lynx.tasm.core;

import com.lynx.jsbridge.RuntimeLifecycleListenerDelegate;
import com.lynx.jsbridge.s;
import com.lynx.react.bridge.JavaOnlyArray;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.tasm.LynxBackgroundRuntime;
import com.lynx.tasm.LynxError;
import com.lynx.tasm.base.CalledByNative;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.utils.g;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: loaded from: classes2.dex */
public class JSProxy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f10825a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final WeakReference f10826b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f10827c;
    public final ReentrantReadWriteLock d;
    public long e;
    public final HashMap f;
    public boolean g;

    public JSProxy(long r5, WeakReference r10, String r11) {
        this.d = new ReentrantReadWriteLock();
        this.e = 0;
        this.f = new HashMap();
        this.g = false;
        this.f10826b = r10;
        this.f10827c = r11;
        this.f10825a = nativeCreate(r5, r11);
    }

    @CalledByNative
    private Object getArgs(long r5) {
        ReentrantReadWriteLock r10 = this.d;
        r10.writeLock().lock();
        Object r11 = this.f.remove(Long.valueOf(r5));     // Catch: Throwable -> L6
        r10.writeLock().unlock();
        return r11;
    L6:
        th = move-exception;
        r10.writeLock().unlock();
        throw th;
    }

    private native void nativeAddLifecycleListener(long r5, RuntimeLifecycleListenerDelegate r10);

    private native void nativeCallIntersectionObserver(long r5, int r10, int r11, long r12);

    private native void nativeCallJSApiCallbackWithValue(long r5, int r10, long r11);

    private native void nativeCallJSFunction(long r5, String r10, String r11, long r12);

    private native long nativeCreate(long r5, String r10);

    private native long nativeCreateWithRuntimeActor(long r5, String r10);

    private native void nativeDestroy(long r5, String r10);

    private static native void nativeEvaluateScript(long r5, String r10, byte[] r11, int r12);

    private static native void nativeRejectDynamicComponentLoad(long r5, String r10, int r11, int r12, String r13);

    private static native void nativeRunOnJSThread(long r5, Runnable r10);

    @CalledByNative
    private void setRuntimeId(long r5) {
    }

    public final void a() {
        ReentrantReadWriteLock r5 = this.d;
        r5.writeLock().lock();
        long r10 = this.f10825a;
        if (r10 == 0) goto L5;
        nativeDestroy(r10, this.f10827c);
        this.f10825a = 0;
    L5:
        this.f.clear();
        r5.writeLock().unlock();
    }

    public final void b(int r11, int r12, JavaOnlyMap r13) {
        ReentrantReadWriteLock r5 = this.d;
        r5.writeLock().lock();
        long r10 = this.f10825a;
        HashMap r14 = this.f;
        if (r10 == 0) goto L5;
        long r15 = this.e + 1;
        this.e = r15;
        r14.put(Long.valueOf(r15), r13);
        nativeCallIntersectionObserver(r10, r11, r12, this.e);
    L5:
        int r16 = r14.size();
        r5.writeLock().unlock();
        d(r16, "callIntersectionObserver");
    }

    public final void c(int r10, JavaOnlyMap r11) {
        ReentrantReadWriteLock r5 = this.d;
        r5.writeLock().lock();
        long r12 = this.f10825a;
        HashMap r13 = this.f;
        if (r12 == 0) goto L5;
        long r14 = this.e + 1;
        this.e = r14;
        r13.put(Long.valueOf(r14), r11);
        nativeCallJSApiCallbackWithValue(r12, r10, this.e);
    L5:
        int r15 = r13.size();
        r5.writeLock().unlock();
        d(r15, "callJSApiCallbackWithValue");
    }

    public final void d(int r5, String r10) {
        if (this.g == false) goto L5;
        return;
    L5:
        if (r5 <= 200) goto L13;
        WeakReference r11 = this.f10826b;
        if (r11 == null) goto L14;
        this.g = true;
        LynxContext r12 = (LynxContext) r11.get();
        if (r12 == null) goto L15;
        r12.b(new LynxError(20201, g.d("Calling [", r10, "] too frequently.This may cause OOM issues."), "", "error"));
        return;
    L15:
        return;
    L14:
        return;
    }

    public final void e(s r10) {
        RuntimeLifecycleListenerDelegate r5 = new RuntimeLifecycleListenerDelegate(this.f10826b, r10);
        ReentrantReadWriteLock r11 = this.d;
        r11.readLock().lock();
        long r12 = this.f10825a;
        if (r12 == 0) goto L5;
        nativeAddLifecycleListener(r12, r5);
    L5:
        r11.readLock().unlock();
    }

    public final void f(String r11, JavaOnlyArray r12) {
        ReentrantReadWriteLock r5 = this.d;
        r5.writeLock().lock();
        long r10 = this.f10825a;
        HashMap r13 = this.f;
        if (r10 == 0) goto L5;
        long r14 = this.e + 1;
        this.e = r14;
        r13.put(Long.valueOf(r14), r12);
        nativeCallJSFunction(r10, r11, "emit", this.e);
    L5:
        int r15 = r13.size();
        r5.writeLock().unlock();
        d(r15, "callFunction:" + r11 + ".emit");
    }

    public JSProxy(LynxBackgroundRuntime r5, String r10) {
        this.d = new ReentrantReadWriteLock();
        this.e = 0;
        this.f = new HashMap();
        this.g = false;
        this.f10826b = new WeakReference(null);
        this.f10827c = r10;
        this.f10825a = nativeCreateWithRuntimeActor(r5.e, r10);
    }
}
