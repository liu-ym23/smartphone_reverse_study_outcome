package com.lynx.tasm.core;

import com.lynx.jsbridge.RuntimeLifecycleListenerDelegate;
import com.lynx.react.bridge.JavaOnlyArray;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.tasm.LynxBackgroundRuntime;
import com.lynx.tasm.LynxError;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.LynxContext;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class JSProxy {
    public long a;
    public long b;
    public final WeakReference<LynxContext> c;
    public final String d;
    public final ReadWriteLock e;
    public long f;
    public final HashMap<Long, Object> g;
    public boolean h;

    private native void nativeAddLifecycleListener(long r1, RuntimeLifecycleListenerDelegate r3);

    private native void nativeCallIntersectionObserver(long r1, int r3, int r4, long r5);

    private native void nativeCallJSApiCallbackWithValue(long r1, int r3, long r4);

    private native void nativeCallJSFunction(long r1, String r3, String r4, long r5);

    private native long nativeCreate(long r1, String r3);

    private native long nativeCreateWithRuntimeActor(long r1, String r3);

    private native void nativeDestroy(long r1, String r3);

    private static native void nativeEvaluateScript(long r0, String r2, byte[] r3, int r4);

    private static native void nativeRejectDynamicComponentLoad(long r0, String r2, int r3, int r4, String r5);

    private static native void nativeRunOnJSThread(long r0, Runnable r2);

    public final void f() {
        this.e.writeLock().lock();
        long r0 = this.a;
        if (r0 == 0) goto L5;
        nativeDestroy(r0, this.d);
        this.a = 0;
    L5:
        this.g.clear();
        this.e.writeLock().unlock();
    }

    private Object getArgs(long r2) {
        this.e.writeLock().lock();
        Object r3 = this.g.remove(Long.valueOf(r2));     // Catch: Throwable -> L6
        this.e.writeLock().unlock();
        return r3;
    L6:
        th = move-exception;
        this.e.writeLock().unlock();
        throw th;
    }

    private void setRuntimeId(long r1) {
        this.b = r1;
    }

    public final void a(com.lynx.jsbridge.g r6) {
        if (r6 != null) goto L5;
        LLog.w("JSProxy", "add a null lifecycle listener.");
        return;
    L5:
        RuntimeLifecycleListenerDelegate r0 = new RuntimeLifecycleListenerDelegate(this.c, r6);
        this.e.readLock().lock();
        long r1 = this.a;
        if (r1 == 0) goto L8;
        nativeAddLifecycleListener(r1, r0);
    L8:
        this.e.readLock().unlock();
    }

    public final long g(Object r6) {
        HashMap<Long, Object> r0 = this.g;
        long r1 = this.f + 1;
        this.f = r1;
        r0.put(Long.valueOf(r1), r6);
        return this.f;
    }

    public final void h(Runnable r6) {
        this.e.readLock().lock();
        long r0 = this.a;
        if (r0 == 0) goto L5;
        nativeRunOnJSThread(r0, r6);
    L5:
        this.e.readLock().unlock();
    }

    public JSProxy(LynxBackgroundRuntime r3, String r4) {
        this.e = new ReentrantReadWriteLock();
        this.f = 0;
        this.g = new HashMap();
        this.h = false;
        this.c = new WeakReference(null);
        this.d = r4;
        this.a = nativeCreateWithRuntimeActor(r3.f, r4);
    }

    public final void d(int r8, JavaOnlyMap r9) {
        ((ReentrantReadWriteLock) this.e).writeLock().lock();
        long r2 = this.a;
        if (r2 == 0) goto L5;
        nativeCallJSApiCallbackWithValue(r2, r8, g(r9));
    L5:
        int r10 = this.g.size();
        ((ReentrantReadWriteLock) this.e).writeLock().unlock();
        e(r10, "callJSApiCallbackWithValue");
    }

    public final void e(int r4, String r5) {
        if (this.h == false) goto L5;
        return;
    L5:
        if (r4 <= 200) goto L13;
        WeakReference<LynxContext> r6 = this.c;
        if (r6 == null) goto L14;
        this.h = true;
        LynxContext r7 = r6.get();
        if (r7 == null) goto L15;
        r7.handleLynxError(new LynxError(20201, "Calling [" + r5 + "] too frequently.This may cause OOM issues."));
        return;
    L15:
        return;
    L14:
        return;
    }

    public JSProxy(long r3, WeakReference<LynxContext> r5, String r6) {
        this.e = new ReentrantReadWriteLock();
        this.f = 0;
        this.g = new HashMap();
        this.h = false;
        this.c = r5;
        this.d = r6;
        this.a = nativeCreate(r3, r6);
    }

    public final void b(String r9, String r10, JavaOnlyArray r11) {
        ((ReentrantReadWriteLock) this.e).writeLock().lock();
        long r2 = this.a;
        if (r2 == 0) goto L5;
        nativeCallJSFunction(r2, r9, r10, g(r11));
    L5:
        int r12 = this.g.size();
        ((ReentrantReadWriteLock) this.e).writeLock().unlock();
        e(r12, "callFunction:" + r9 + "." + r10);
    }

    public final void c(int r9, int r10, JavaOnlyMap r11) {
        ((ReentrantReadWriteLock) this.e).writeLock().lock();
        long r2 = this.a;
        if (r2 == 0) goto L5;
        nativeCallIntersectionObserver(r2, r9, r10, g(r11));
    L5:
        int r12 = this.g.size();
        ((ReentrantReadWriteLock) this.e).writeLock().unlock();
        e(r12, "callIntersectionObserver");
    }
}
