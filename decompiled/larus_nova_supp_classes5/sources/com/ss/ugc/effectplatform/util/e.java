package com.ss.ugc.effectplatform.util;

import android.os.Build;
import bytekn.foundation.logger.Logger;
import javax.microedition.khronos.egl.EGL;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import javax.microedition.khronos.opengles.GL;
import javax.microedition.khronos.opengles.GL10;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class e {
    public EGL10 a;
    public EGLDisplay b;
    public EGLConfig c;
    public EGLSurface d;
    public EGLContext e;
    public GL10 f;
    public final EGLContext g;
    public final boolean h;

    public static final class a {
    }

    static {
    }

    public final void b() {
        EGL10 r0 = this.a;
        if (r0 != null) goto L5;
        return;
    L5:
        if (this.h == true) goto L8;
        EGLDisplay r1 = this.b;
        EGLSurface r2 = EGL10.EGL_NO_SURFACE;
        r0.eglMakeCurrent(r1, r2, r2, EGL10.EGL_NO_CONTEXT);
        r0.eglDestroySurface(this.b, this.d);
        r0.eglDestroyContext(this.b, this.e);
        r0.eglTerminate(this.b);
        return;
    L8:
        EGLDisplay r3 = this.b;
        if (r3 == EGL10.EGL_NO_DISPLAY) goto L23;
        EGLSurface r4 = this.d;
        if (r4 == null) goto L15;
        EGLSurface r5 = EGL10.EGL_NO_SURFACE;
        if (r4 == r5) goto L15;
        r0.eglMakeCurrent(r3, r5, r5, EGL10.EGL_NO_CONTEXT);
        r0.eglDestroySurface(this.b, this.d);
        this.d = null;
    L15:
        EGLContext r6 = this.e;
        if (r6 == null) goto L18;
        r0.eglDestroyContext(this.b, r6);
        this.e = null;
    L18:
        EGLDisplay r7 = this.b;
        if (r7 == null) goto L24;
        r0.eglTerminate(r7);
        this.b = null;
        return;
    L24:
        return;
    }

    public final void c() {
        int[] r0 = {12352, 4, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 0, 12326, 0, 12344};
        EGL r1 = EGLContext.getEGL();
        GL r7 = null;
        if ((r1 instanceof EGL10) == true) goto L5;
        r1 = null;
    L5:
        EGL10 r8 = (EGL10) r1;
        if (r8 == null) goto L43;
        EGLDisplay r2 = r8.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
        this.b = r2;
        if (r2 != EGL10.EGL_NO_DISPLAY) goto L10;
        d("unable to get EGL10 display");
    L10:
        a(r8);
        if (r8.eglInitialize(this.b, new int[2]) == true) goto L13;
        d("unable to initialize EGL10");
    L13:
        a(r8);
        int[] r9 = new int[1];
        if (r8.eglChooseConfig(this.b, r0, null, 0, r9) == true) goto L16;
        d("eglChooseConfig failed");
    L16:
        a(r8);
        int r5 = r9[0];
        EGLConfig[] r11 = new EGLConfig[r5];
        if (r8.eglChooseConfig(this.b, r0, r11, r5, r9) == true) goto L19;
        d("eglChooseConfig#2 failed");
    L19:
        a(r8);
        EGLConfig r3 = r11[0];
        this.c = r3;
        if (r3 != null) goto L22;
        d("Unable to find a suitable EGLConfig");
    L22:
        EGLSurface r4 = r8.eglCreatePbufferSurface(this.b, this.c, new int[]{12375, 16, 12374, 16, 12344});
        this.d = r4;
        if (r4 == EGL10.EGL_NO_SURFACE) goto L25;
        if (r4 == null) goto L25;
    L26:
        a(r8);
        EGLContext r6 = r8.eglCreateContext(this.b, this.c, this.g, new int[]{12440, 2, 12344});
        this.e = r6;
        if (r6 == EGL10.EGL_NO_CONTEXT) goto L29;
        if (r6 == null) goto L29;
    L30:
        a(r8);
        EGLDisplay r10 = this.b;
        EGLSurface r12 = this.d;
        if (r8.eglMakeCurrent(r10, r12, r12, this.e) == true) goto L33;
        d("eglMakeCurrent failed");
    L33:
        a(r8);
        EGLContext r13 = this.e;
        if (r13 == null) goto L36;
        GL r14 = r13.getGL();
    L38:
        if ((r14 instanceof GL10) == false) goto L41;
        r7 = r14;
    L41:
        this.f = (GL10) r7;
        this.a = r8;
        return;
    L36:
        r14 = null;
    L29:
        d("context was null");
    L25:
        d("surface was null");
        goto L26
    }

    public e() {
        this.g = EGL10.EGL_NO_CONTEXT;
        String r0 = Build.MODEL;
        if (r0 == null) goto L5;
        String r1 = r0.toLowerCase();
    L6:
        this.h = Intrinsics.areEqual("mi play", r1);
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final void a(EGL10 r3) {
        int r4 = r3.eglGetError();
        if (r4 == 12288) goto L6;
        d("EGL error: 0x" + Integer.toHexString(r4));
        return;
    }

    public final void d(String r8) {
        if (this.h == true) goto L7;
        Logger.e$default(Logger.INSTANCE, "EGLUtils", "get gpu info error:" + r8, null, 4, null);
        return;
    L7:
        throw new RuntimeException(r8);
    }
}
