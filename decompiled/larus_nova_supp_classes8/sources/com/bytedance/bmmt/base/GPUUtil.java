package com.bytedance.bmmt.base;

import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.os.Build;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class GPUUtil {
    private static String glRenderer = "unknown";
    private static String glVendor = "unknown";
    private static boolean initialized;

    public GPUUtil() {
    }

    private static void Initialize() {
        initialized = true;
        boolean r1 = false;
        EGLContext r4 = EGL14.eglGetCurrentContext();     // Catch: Throwable -> L88 Exception -> L90
        if (r4 != null) goto L126;
    L15:
        r1 = true;
    L16:
        if (r1 == true) goto L131;
        EGLSurface r2 = null;
        EGLDisplay r3 = null;
    L133:
    L86:
        e = e;
        EGLContext r21 = r4;
        EGLSurface r5 = r2;
        r1 = r1;
        r4 = r21;
    L124:
        e.toString();     // Catch: Throwable -> L108
        if (r1 == false) goto L139;
        EGLSurface r0 = EGL14.EGL_NO_SURFACE;
        EGL14.eglMakeCurrent(r3, r0, r0, EGL14.EGL_NO_CONTEXT);
        if (r5 != null) goto L97;
    L99:
        if (r4 != null) goto L101;
    L103:
        if (r3 != null) goto L105;
        return;
    L105:
        if (r3 == EGL14.EGL_NO_DISPLAY) goto L141;
    L106:
        EGL14.eglTerminate(r3);
        return;
    L141:
        return;
    L101:
        if (r4 == EGL14.EGL_NO_CONTEXT) goto L103;
        EGL14.eglDestroyContext(r3, r4);
        goto L103
    L97:
        if (r5 == EGL14.EGL_NO_SURFACE) goto L99;
        EGL14.eglDestroySurface(r3, r5);
        goto L99
    L139:
        return;
    L108:
        th = th;
    L109:
        if (r1 == false) goto L123;
        EGLSurface r6 = EGL14.EGL_NO_SURFACE;
        EGL14.eglMakeCurrent(r3, r6, r6, EGL14.EGL_NO_CONTEXT);
        if (r5 != null) goto L113;
    L115:
        if (r4 != null) goto L117;
    L119:
        if (r3 == null) goto L123;
        if (r3 == EGL14.EGL_NO_DISPLAY) goto L123;
        EGL14.eglTerminate(r3);
        goto L123
    L117:
        if (r4 == EGL14.EGL_NO_CONTEXT) goto L119;
        EGL14.eglDestroyContext(r3, r4);
        goto L119
    L113:
        if (r5 == EGL14.EGL_NO_SURFACE) goto L115;
        EGL14.eglDestroySurface(r3, r5);
    L123:
        throw th;
    L84:
        th = th;
        EGLContext r22 = r4;
        r5 = r2;
        r1 = r1;
        r4 = r22;
        goto L109
    L68:
        if (Build.VERSION.SDK_INT <= 22) goto L70;
        glVendor = GLES20.glGetString(7936);     // Catch: Throwable -> L84 Exception -> L86
        glRenderer = GLES20.glGetString(7937);     // Catch: Throwable -> L84 Exception -> L86
    L70:
        if (r1 == false) goto L136;
        EGLSurface r7 = EGL14.EGL_NO_SURFACE;
        EGL14.eglMakeCurrent(r3, r7, r7, EGL14.EGL_NO_CONTEXT);
        if (r2 != null) goto L74;
    L76:
        if (r4 != null) goto L78;
    L80:
        if (r3 != null) goto L82;
        return;
    L82:
        if (r3 != EGL14.EGL_NO_DISPLAY) goto L106;
        return;
    L78:
        if (r4 == EGL14.EGL_NO_CONTEXT) goto L80;
        EGL14.eglDestroyContext(r3, r4);
        goto L80
    L74:
        if (r2 == EGL14.EGL_NO_SURFACE) goto L76;
        EGL14.eglDestroySurface(r3, r2);
        goto L76
    L136:
        return;
    L131:
        EGLDisplay r13 = EGL14.eglGetDisplay(0);     // Catch: Throwable -> L60 Exception -> L63
        if (r13 == null) goto L55;
    L58:
        e = e;
        r3 = r13;
    L14:
        r5 = null;
    L56:
        th = th;
        r3 = r13;
    L11:
        r5 = null;
        goto L109
    L20:
        if (r13 == EGL14.EGL_NO_DISPLAY) goto L55;
        int[] r8 = new int[2];     // Catch: Throwable -> L56 Exception -> L58
        if (EGL14.eglInitialize(r13, r8, 0, r8, 1) == false) goto L53;
        int[] r11 = new int[1];     // Catch: Throwable -> L56 Exception -> L58
        EGLConfig[] r10 = new EGLConfig[1];     // Catch: Throwable -> L56 Exception -> L58
        if (EGL14.eglChooseConfig(r13, new int[]{12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, 4, 12339, 1, 12344}, 0, r10, 0, 1, r11, 0) == false) goto L51;
        if (r11[0] <= 0) goto L49;
        EGLConfig r9 = r10[0];     // Catch: Throwable -> L56 Exception -> L58
        r4 = EGL14.eglCreateContext(r13, r9, EGL14.EGL_NO_CONTEXT, new int[]{12440, 2, 12344}, 0);     // Catch: Throwable -> L56 Exception -> L58
        if (r4 == null) goto L47;
        if (r4 == EGL14.EGL_NO_CONTEXT) goto L47;
        EGLSurface r12 = EGL14.eglCreatePbufferSurface(r13, r9, new int[]{12375, 1, 12374, 1, 12344}, 0);     // Catch: Throwable -> L56 Exception -> L58
        if (r12 == null) goto L41;
    L44:
        e = e;
        r1 = r1;
        r4 = r4;
        r5 = r12;
        r3 = r13;
    L42:
        th = th;
        r1 = r1;
        r4 = r4;
        r5 = r12;
        r3 = r13;
        goto L109
    L34:
        if (r12 == EGL14.EGL_NO_SURFACE) goto L41;
        if (EGL14.eglMakeCurrent(r13, r12, r12, r4) == false) goto L39;
        r2 = r12;
        r3 = r13;
        goto L133
    L39:
        throw new Exception("eglMakeCurrent error");     // Catch: Throwable -> L42 Exception -> L44
    L41:
        throw new Exception("eglCreatePbufferSurface error");     // Catch: Throwable -> L42 Exception -> L44
    L47:
        throw new Exception("eglCreateContext error");     // Catch: Throwable -> L56 Exception -> L58
    L49:
        throw new Exception("no egl config chosen");     // Catch: Throwable -> L56 Exception -> L58
    L51:
        throw new Exception("eglChooseConfig error");     // Catch: Throwable -> L56 Exception -> L58
    L53:
        throw new Exception("eglInitialize error");     // Catch: Throwable -> L56 Exception -> L58
    L55:
        throw new Exception("eglGetDisplay error");     // Catch: Throwable -> L56 Exception -> L58
    L63:
        e = e;
        r3 = null;
    L60:
        th = th;
        r3 = null;
        goto L11
    L126:
        if (r4 == EGL14.EGL_NO_CONTEXT) goto L15;
        r1 = false;
        goto L16
    L12:
        e = e;
        r3 = null;
    L9:
        th = th;
        r3 = null;
        goto L11
    L90:
        e = e;
        r3 = null;
        r5 = null;
        r4 = null;
    L88:
        th = th;
        r3 = null;
        r5 = null;
        r4 = null;
        goto L109
    }

    public static String getGPURenderer() {
        if (initialized == true) goto L6;
        Initialize();
    L6:
        return glRenderer;
    }

    public static String getGPURendererFallback() {
        return glRenderer;
    }
}
