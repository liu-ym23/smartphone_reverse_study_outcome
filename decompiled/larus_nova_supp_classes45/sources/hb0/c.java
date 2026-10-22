package hb0;

import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class c {
    public final d.h a;
    public final d.i b;
    public final d.j c;
    public EGLDisplay d;
    public EGLConfig e;
    public EGLContext f;
    public EGLSurface g;

    public final void b() {
        EGLSurface r0 = this.g;
        if (r0 == null) goto L8;
        EGLSurface r1 = EGL14.EGL_NO_SURFACE;
        if (r0 == r1) goto L9;
        EGL14.eglMakeCurrent(this.d, r1, r1, EGL14.EGL_NO_CONTEXT);
        d.j r2 = this.c;
        EGLDisplay r3 = this.d;
        EGLSurface r4 = this.g;
        ((d.g) r2).getClass();
        EGL14.eglDestroySurface(r3, r4);
        this.g = null;
        return;
    L9:
        return;
    }

    public final boolean a(Object r7) {
        if (this.d == null) goto L24;
        if (this.e == null) goto L22;
        b();
        d.j r0 = this.c;
        EGLDisplay r1 = this.d;
        EGLConfig r2 = this.e;
        ((d.g) r0).getClass();
        EGLSurface r8 = EGL14.eglCreateWindowSurface(r1, r2, r7, new int[]{12344}, 0);     // Catch: IllegalArgumentException -> L9
    L10:
        this.g = r8;
        if (r8 != null) goto L13;
    L20:
        return false;
    L13:
        if (r8 == EGL14.EGL_NO_SURFACE) goto L20;
        if (EGL14.eglMakeCurrent(this.d, r8, r8, this.f) == true) goto L19;
        EGL14.eglGetError();
        return false;
    L19:
        return true;
    L9:
        r8 = null;
        goto L10
    L22:
        throw new RuntimeException("mEglConfig not initialized");
    L24:
        throw new RuntimeException("eglDisplay not initialized");
    }

    public final a c(a r15) {
        EGLDisplay r1 = EGL14.eglGetDisplay(0);
        this.d = r1;
        if (r1 == EGL14.EGL_NO_DISPLAY) goto L25;
        int[] r3 = new int[2];
        if (EGL14.eglInitialize(r1, r3, 0, r3, 1) == false) goto L22;
        d.h r2 = this.a;
        EGLDisplay r5 = this.d;
        if (((d.a) r2).a < 3) goto L9;
        int r4 = 68;
    L10:
        int[] r7 = {12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, r4, 12344, 0, 12344};
        EGLConfig[] r6 = new EGLConfig[1];
        if (EGL14.eglChooseConfig(r5, r7, 0, r6, 0, 1, new int[1], 0) == true) goto L13;
        EGLConfig r8 = null;
    L14:
        this.e = r8;
        d.i r9 = this.b;
        EGLDisplay r11 = this.d;
        EGLContext r16 = r15.a;
        ((d.f) r9).getClass();
        EGLContext r17 = EGL14.eglCreateContext(r11, r8, r16, new int[]{12440, 2, 12344}, 0);
        this.f = r17;
        if (r17 != null) goto L17;
    L20:
        this.f = null;
        throw new RuntimeException(b.a("; createContext", EGL14.eglGetError()));
    L17:
        if (r17 == EGL14.EGL_NO_CONTEXT) goto L20;
        this.g = null;
        a r18 = new a();
        r18.a = this.f;
        return r18;
    L13:
        r8 = r6[0];
        goto L14
    L9:
        r4 = 4;
        goto L10
    L22:
        this.d = null;
        throw new RuntimeException("eglInitialize failed");
    L25:
        throw new RuntimeException("eglGetDisplay failed");
    }

    public c(d.h r1, d.i r2, d.j r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
