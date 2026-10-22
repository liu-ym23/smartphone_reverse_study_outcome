package ms.bd.c;

import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class v0 {
    public EGLDisplay a;
    public EGLContext b;

    public final void b() {
        EGLDisplay r0 = this.a;
        if (r0 == EGL14.EGL_NO_DISPLAY) goto L5;
        EGL14.eglDestroyContext(r0, this.b);
        EGL14.eglReleaseThread();
        EGL14.eglTerminate(this.a);
    L5:
        this.a = EGL14.EGL_NO_DISPLAY;
        this.b = EGL14.EGL_NO_CONTEXT;
    }

    public final void finalize() {
    L7:
        th = move-exception;
        super.finalize();
        throw th;
    L3:
        if (this.a == EGL14.EGL_NO_DISPLAY) goto L5;
        b();     // Catch: Throwable -> L7
    L5:
        super.finalize();
    }

    public v0() {
        EGLDisplay r0 = EGL14.EGL_NO_DISPLAY;
        this.a = r0;
        this.b = EGL14.EGL_NO_CONTEXT;
        if (r0 != EGL14.EGL_NO_DISPLAY) goto L31;
        EGLContext r1 = EGL14.EGL_NO_CONTEXT;
        EGLDisplay r2 = EGL14.eglGetDisplay(0);
        this.a = r2;
        if (r2 == EGL14.EGL_NO_DISPLAY) goto L29;
        int[] r4 = new int[2];
        if (EGL14.eglInitialize(r2, r4, 0, r4, 1) == false) goto L26;
        EGLConfig r5 = a(3);
        if (r5 == null) goto L14;
        EGLContext r6 = EGL14.eglCreateContext(this.a, r5, r1, new int[]{12440, 3, 12344}, 0);
        if (EGL14.eglGetError() != 12288) goto L14;
        this.b = r6;
    L14:
        if (this.b != EGL14.EGL_NO_CONTEXT) goto L24;
        EGLConfig r3 = a(2);
        if (r3 == null) goto L23;
        EGLContext r7 = EGL14.eglCreateContext(this.a, r3, r1, new int[]{12440, 2, 12344}, 0);
        String r8 = (String) p2.a(16777217, 0, 0, "2aa14c", new byte[]{38, 100, 30, 102, 25, 113, 48, 84, 53, 66, 44, 109, 6, 64, 19, 96});
        int r9 = EGL14.eglGetError();
        if (r9 != 12288) goto L21;
        this.b = r7;
        goto L24
    L21:
        throw new RuntimeException(r8 + ((String) p2.a(16777217, 0, 0, "ea2690", new byte[]{46, 35, 100, 101, 42, 103, 99, 82, 113, 105, 102, 57, 1, 18, 30})) + Integer.toHexString(r9));
    L23:
        throw new RuntimeException((String) p2.a(16777217, 0, 0, "532263", new byte[]{17, 63, 64, 68, 5, 33, 118, 6, 108, 34, 34, 56, 79, 66, 73, 37, 118, 1, 118, 107, 48, 48, 67, 74, 12, 100, 19, 53, 79, 65, 43, 63, 71, 79, 14}));
    L24:
        EGL14.eglQueryContext(this.a, this.b, 12440, new int[1], 0);
        return;
    L26:
        this.a = null;
        throw new RuntimeException((String) p2.a(16777217, 0, 0, "1a01ef", new byte[]{53, 109, 66, 71, 86, 116, 114, 84, 110, 33, 41, 109, 74, 81, 83, 112, 62, 73, 123, 100, 96, 70, 100, 105, 11, 37}));
    L29:
        throw new RuntimeException((String) p2.a(16777217, 0, 0, "a86f90", new byte[]{101, 52, 68, 16, 10, 34, 34, 13, 104, 118, 119, 63, 81, 82, 35, 0, 78, 72, 51, 118, 116, 51, 86, 2, 10, 38, 123}));
    L31:
        throw new RuntimeException((String) p2.a(16777217, 0, 0, "cdf379", new byte[]{87, 65, 57, 7, 9, 34, 114, 64, 54, 103, 107, 38, 6, 66, 28, 110, 117, 85}));
    }

    public final EGLConfig a(int r13) {
        if (r13 < 3) goto L5;
        int r14 = 68;
    L6:
        int[] r4 = {12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, r14, 12344, 0, 12344};
        EGLConfig[] r15 = new EGLConfig[1];
        if (EGL14.eglChooseConfig(this.a, r4, 0, r15, 0, 1, new int[1], 0) == true) goto L11;
        return null;
    L11:
        return r15[0];
    L5:
        r14 = 4;
        goto L6
    }

    public final void c(EGLSurface r8) {
        if (EGL14.eglMakeCurrent(this.a, r8, r8, this.b) == false) goto L6;
        return;
    L6:
        throw new RuntimeException((String) p2.a(16777217, 0, 0, "5bafab", new byte[]{33, 103, 30, 63, 95, 126, 51, 96, 37, 36, 54, 101, 28, 6, 30, 115, 55, 74, 60, 51, 32}));
    }
}
