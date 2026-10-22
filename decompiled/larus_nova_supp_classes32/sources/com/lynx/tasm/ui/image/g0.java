package com.lynx.tasm.ui.image;

import android.content.Context;
import android.os.Looper;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.imagepipeline.request.ImageRequest;
import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.tasm.core.LynxThreadPool;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class g0 implements Runnable {
    public final /* synthetic */ ImageRequest a;
    public final /* synthetic */ ImageRequest b;
    public final /* synthetic */ String c;
    public final /* synthetic */ e0 d;

    /* JADX WARN: Type inference failed for: r0v3, types: [REQUEST, com.facebook.imagepipeline.request.ImageRequest] */
    /* JADX WARN: Type inference failed for: r2v6, types: [REQUEST, com.facebook.imagepipeline.request.ImageRequest] */
    public final void a() {
        e0 r0 = this.d;
        v r1 = r0.Q;
        r1.g = r0.I;
        r1.c = r0.e;
        r1.f = r0.d;
        if (this.a == null) goto L5;
        boolean r2 = true;
    L6:
        r1.h = r2;
        r1.d = this.b;
        r1.i = r0.M.d;
        if (r0.c0 == true) goto L9;
    L11:
        boolean r3 = false;
    L12:
        r1.b = r3;
        r1.e = this.a;
        e0 r4 = this.d;
        Context r5 = r4.b;
        v r6 = r4.Q;
        if (r6.d != 0) goto L17;
        REQUEST r7 = r6.e;
        if (r7 == 0) goto L17;
        r6.d = r7;
        r6.e = null;
    L17:
        u r8 = r6.b();
        r8.f = r6.h;
        ControllerListener<? super INFO> r9 = r6.f;
        if (r9 == 0) goto L21;
        r8.a(r9);
    L21:
        if (r6.g == false) goto L23;
        r8.a(LynxAbstractDraweeControllerBuilder.j);
    L23:
        e0 r10 = this.d;
        r8.m = r10.i0;
        r8.n = this.c;
        y<GenericDraweeHierarchy> r11 = r10.M;
        boolean r12 = r11.a;
        if (r12 == true) goto L26;
    L32:
        q r13 = r11.d;
        if (r13 != null) goto L35;
    L37:
        boolean r14 = false;
    L38:
        if (r14 == false) goto L40;
        r13.n(null);
    L40:
        r11.d = r8;
        r8.n(r11.c);
        if (r12 == true) goto L43;
    L49:
        v r15 = this.d.Q;
        r15.getClass();
        r15.c = null;
        r15.d = null;
        r15.e = null;
        r15.f = null;
        r15.g = false;
        r15.i = null;
        return;
    L43:
        if (r11.a == true) goto L49;
        r11.a = true;
        w r16 = new w(r11);
        if (ThreadMethodProxy.getLooperThread(Looper.getMainLooper()) == ThreadMethodProxy.currentThread()) goto L48;
        r16.run();
        goto L49
    L48:
        LynxThreadPool.d().execute(r16);
        goto L49
    L35:
        if (r13.l != r11.c) goto L37;
        r14 = true;
        goto L38
    L26:
        if (r11.a == false) goto L32;
        r11.a = false;
        x r17 = new x(r11);
        if (ThreadMethodProxy.getLooperThread(Looper.getMainLooper()) == ThreadMethodProxy.currentThread()) goto L31;
        r17.run();
        goto L32
    L31:
        LynxThreadPool.d().execute(r17);
        goto L32
    L9:
        if (r0.z == true) goto L11;
        r3 = true;
        goto L12
    L5:
        r2 = false;
        goto L6
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public g0(e0 r1, l8a.d r2, l8a.d r3, String r4) {
        this.d = r1;
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
