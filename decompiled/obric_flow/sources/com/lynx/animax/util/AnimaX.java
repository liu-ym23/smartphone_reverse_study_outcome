package com.lynx.animax.util;

import android.content.Context;
import com.lynx.tasm.h;
import com.lynx.tasm.utils.e;
import com.ss.android.agilelogger.ALog;
import java.util.concurrent.CountDownLatch;
import jm.a;
import jm.c;
import xs.b;
import ym.d;

/* JADX INFO: loaded from: classes2.dex */
public class AnimaX {
    public static volatile AnimaX f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile boolean f9710a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public d f9711b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Context f9712c;
    public volatile boolean d;
    public final CountDownLatch e;

    public AnimaX() {
        this.f9710a = false;
        this.d = false;
        this.e = new CountDownLatch(1);
    }

    public static AnimaX a() {
        if (f != null) goto L16;
        monitor-enter(AnimaX.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (f != null) goto L11;
        f = new AnimaX();     // Catch: Throwable -> L9
    L11:
        monitor-exit(AnimaX.class);     // Catch: Throwable -> L9
    L16:
        return f;
    }

    private native void nativeMarkMainThread();

    private native void nativeRegisterLogger(long r5);

    public final void b(d r5) {
        if (this.f9710a == true) goto L31;
        monitor-enter(this);
    L14:
        th = move-exception;
        throw th;
    L6:
        if (this.f9710a == false) goto L9;
        monitor-exit(this);
        goto L31
    L9:
        this.f9711b = r5;     // Catch: Throwable -> L14
        if (c("lynxbase") == true) goto L17;
        AnimaXLog.a(AnimaXLog.LogLevel.f9715c, "AnimaX", "AnimaX failed to load liblynxbase.so");     // Catch: Throwable -> L14
        monitor-exit(this);     // Catch: Throwable -> L14
        goto L31
    L17:
        if (c("animax") == true) goto L43;
        AnimaXLog.a(AnimaXLog.LogLevel.f9715c, "AnimaX", "AnimaX failed to load libanimax.so");     // Catch: Throwable -> L14
        monitor-exit(this);     // Catch: Throwable -> L14
        goto L31
    L43:
        b r10 = ALog.sConfig;     // Catch: Throwable -> L14 Exception -> L23
        long r11 = ((Long) ALog.class.getMethod("getALogSimpleWriteFuncAddr", null).invoke(null, null)).longValue();     // Catch: Throwable -> L14 Exception -> L23
    L25:
        nativeRegisterLogger(r11);     // Catch: Throwable -> L14
        this.f9710a = true;     // Catch: Throwable -> L14
        monitor-exit(this);     // Catch: Throwable -> L14
        goto L31
    L23:
        e = move-exception;
        AnimaXLog.a(AnimaXLog.LogLevel.f9715c, "AnimaX", "No ALog found in the host [ " + e.getMessage() + " ]");     // Catch: Throwable -> L14
        r11 = 0;
    L31:
        if (this.d == false) goto L33;
        return;
    L33:
        if (this.f9710a == true) goto L35;
        return;
    L35:
        if (this.d == false) goto L38;
        return;
    L38:
        if (c.i() == false) goto L40;
        d();
        return;
    L40:
        AnimaXLog.a(AnimaXLog.LogLevel.f9713a, "AnimaX", "Posting mark main thread runnable to main thread.");
        c.a().postAtFrontOfQueue(new a(this, 0));
    }

    public final boolean c(String r5) {
        d r10 = this.f9711b;     // Catch: UnsatisfiedLinkError -> L6
        if (r10 == null) goto L8;
        ((h) r10.f23297a).a(r5);     // Catch: UnsatisfiedLinkError -> L6
        AnimaXLog.a(AnimaXLog.LogLevel.f9713a, "AnimaX", "Native library load " + r5 + " success with native library loader");     // Catch: UnsatisfiedLinkError -> L6
        return true;
    L8:
        System.loadLibrary(r5);     // Catch: UnsatisfiedLinkError -> L6
        AnimaXLog.a(AnimaXLog.LogLevel.f9713a, "AnimaX", "Native library load " + r5 + " success with System.loadLibrary");     // Catch: UnsatisfiedLinkError -> L6
        return true;
    L6:
        e = move-exception;
        if (this.f9711b != null) goto L14;
        StringBuilder r11 = e.b("Native library load ", r5, " from system with error message ");
        r11.append(e.getMessage());
        AnimaXLog.a(AnimaXLog.LogLevel.f9715c, "AnimaX", r11.toString());
        return false;
    L14:
        AnimaXLog.a(AnimaXLog.LogLevel.f9715c, "AnimaX", "Native Library load from " + this.f9711b.getClass().getName() + " with error message " + e.getMessage());
        return false;
    }

    public final void d() {
        if (this.d == false) goto L5;
        return;
    L5:
        nativeMarkMainThread();
        this.d = true;
        this.e.countDown();
        AnimaXLog.a(AnimaXLog.LogLevel.f9713a, "AnimaX", "Main thread marked.");
    }
}
