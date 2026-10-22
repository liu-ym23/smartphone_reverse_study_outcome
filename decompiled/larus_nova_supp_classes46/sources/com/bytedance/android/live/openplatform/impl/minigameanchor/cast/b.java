package com.bytedance.android.live.openplatform.impl.minigameanchor.cast;

import android.os.Handler;
import android.os.Looper;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b implements Runnable {
    public final /* synthetic */ a a;

    public b(a r1) {
        this.a = r1;
    }

    public final void a() {
        a r0 = this.a;     // Catch: Exception -> L15
        EGL10 r1 = r0.e;     // Catch: Exception -> L15
        if (r1 == null) goto L5;
        EGLDisplay r2 = r0.f;     // Catch: Exception -> L15
        EGLSurface r3 = EGL10.EGL_NO_SURFACE;     // Catch: Exception -> L15
        r1.eglMakeCurrent(r2, r3, r3, EGL10.EGL_NO_CONTEXT);     // Catch: Exception -> L15
    L5:
        a r4 = this.a;     // Catch: Exception -> L15
        EGL10 r5 = r4.e;     // Catch: Exception -> L15
        if (r5 == null) goto L8;
        r5.eglDestroySurface(r4.f, r4.h);     // Catch: Exception -> L15
    L8:
        a r6 = this.a;     // Catch: Exception -> L15
        EGL10 r7 = r6.e;     // Catch: Exception -> L15
        if (r7 == null) goto L11;
        r7.eglDestroyContext(r6.f, r6.g);     // Catch: Exception -> L15
    L11:
        a r8 = this.a;     // Catch: Exception -> L15
        EGL10 r9 = r8.e;     // Catch: Exception -> L15
        if (r9 == null) goto L17;
        r9.eglTerminate(r8.f);     // Catch: Exception -> L15
    L17:
        a r10 = this.a;
        r10.g = EGL10.EGL_NO_CONTEXT;
        r10.h = EGL10.EGL_NO_SURFACE;
        r10.f = EGL10.EGL_NO_DISPLAY;
        r10.e = null;
        r10.getClass();
        Handler r11 = this.a.b;
        if (r11 == null) goto L22;
        Looper r12 = r11.getLooper();
        if (r12 == null) goto L22;
        ThreadMethodProxy.quitSafely(r12);
    L22:
        this.a.b = null;
        return;
    L15:
        e = move-exception;
        int r13 = qo0.a.a;
        qo0.a.b(this.a.a, "stopRender exception", e);
        goto L17
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
}
