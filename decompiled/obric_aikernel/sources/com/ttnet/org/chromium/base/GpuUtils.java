package com.ttnet.org.chromium.base;

import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.os.Build;

/* JADX INFO: loaded from: classes2.dex */
public class GpuUtils {
    private static String TAG = "GpuUtils";
    private static String sGlRenderer = "unknown";
    private static String sGlVendor = "unknown";
    private static final Object sGpuInfoLock = null;
    private static boolean sInitialized;

    static {
        sGpuInfoLock = new Object();
    }

    public GpuUtils() {
    }

    public static String getGPUModel() {
        Object r10 = sGpuInfoLock;
        monitor-enter(r10);
        String r11 = sGlRenderer;     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return r11;
    L7:
        th = move-exception;
        throw th;
    }

    public static String getGPUVendor() {
        Object r10 = sGpuInfoLock;
        monitor-enter(r10);
        String r11 = sGlVendor;     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return r11;
    L7:
        th = move-exception;
        throw th;
    }

    public static boolean initialize() {
        if (sInitialized == false) goto L5;
        return true;
    L5:
        boolean r10 = false;
        if (Build.VERSION.SDK_INT >= 20) goto L8;
        return false;
    L8:
        EGLDisplay r11 = null;
        EGLContext r12 = EGL14.eglGetCurrentContext();     // Catch: Throwable -> L93 Exception -> L95
        if (r12 != null) goto L144;
    L21:
        boolean r13 = true;
    L22:
        if (r13 == true) goto L149;
        r12 = r12;
        EGLSurface r14 = null;
    L133:
        Object r15 = sGpuInfoLock;     // Catch: Exception -> L91 Throwable -> L113
        monitor-enter(r15);     // Catch: Exception -> L91 Throwable -> L113
        sGlVendor = GLES20.glGetString(7936);     // Catch: Throwable -> L88
        sGlRenderer = GLES20.glGetString(7937);     // Catch: Throwable -> L88
        monitor-exit(r15);     // Catch: Throwable -> L88
        if (r13 == true) goto L137;
    L86:
        sInitialized = true;
        return true;
    L137:
        EGLSurface r16 = EGL14.EGL_NO_SURFACE;     // Catch: Exception -> L130
        EGL14.eglMakeCurrent(r11, r16, r16, EGL14.EGL_NO_CONTEXT);     // Catch: Exception -> L130
        if (r14 != null) goto L76;
    L78:
        if (r12 != null) goto L80;
    L82:
        if (r11 == null) goto L86;
        if (r11.equals(EGL14.EGL_NO_DISPLAY) == true) goto L86;
        EGL14.eglTerminate(r11);     // Catch: Exception -> L130
        goto L86
    L80:
        if (r12.equals(EGL14.EGL_NO_CONTEXT) == true) goto L82;
        EGL14.eglDestroyContext(r11, r12);     // Catch: Exception -> L130
        goto L82
    L76:
        if (r14.equals(EGL14.EGL_NO_SURFACE) == true) goto L78;
        EGL14.eglDestroySurface(r11, r14);     // Catch: Exception -> L130
    L88:
        th = move-exception;
        throw th;     // Catch: Exception -> L91 Throwable -> L113
    L91:
        e = e;
    L97:
        e.printStackTrace();     // Catch: Throwable -> L113
        if (r13 == true) goto L135;
    L112:
        return false;
    L135:
        EGLSurface r17 = EGL14.EGL_NO_SURFACE;     // Catch: Exception -> L131
        EGL14.eglMakeCurrent(r11, r17, r17, EGL14.EGL_NO_CONTEXT);     // Catch: Exception -> L131
        if (r14 != null) goto L102;
    L104:
        if (r12 != null) goto L106;
    L108:
        if (r11 == null) goto L112;
        if (r11.equals(EGL14.EGL_NO_DISPLAY) == true) goto L112;
        EGL14.eglTerminate(r11);     // Catch: Exception -> L131
        goto L112
    L106:
        if (r12.equals(EGL14.EGL_NO_CONTEXT) == true) goto L108;
        EGL14.eglDestroyContext(r11, r12);     // Catch: Exception -> L131
        goto L108
    L102:
        if (r14.equals(EGL14.EGL_NO_SURFACE) == true) goto L104;
        EGL14.eglDestroySurface(r11, r14);     // Catch: Exception -> L131
    L113:
        th = th;
        r10 = r13;
    L115:
        if (r10 == true) goto L142;
    L129:
        throw th;
    L142:
        EGLSurface r18 = EGL14.EGL_NO_SURFACE;     // Catch: Exception -> L132
        EGL14.eglMakeCurrent(r11, r18, r18, EGL14.EGL_NO_CONTEXT);     // Catch: Exception -> L132
        if (r14 != null) goto L119;
    L121:
        if (r12 != null) goto L123;
    L125:
        if (r11 == null) goto L129;
        if (r11.equals(EGL14.EGL_NO_DISPLAY) == true) goto L129;
        EGL14.eglTerminate(r11);     // Catch: Exception -> L132
        goto L129
    L123:
        if (r12.equals(EGL14.EGL_NO_CONTEXT) == true) goto L125;
        EGL14.eglDestroyContext(r11, r12);     // Catch: Exception -> L132
        goto L125
    L119:
        if (r14.equals(EGL14.EGL_NO_SURFACE) == true) goto L121;
        EGL14.eglDestroySurface(r11, r14);     // Catch: Exception -> L132
        goto L121
    L149:
        EGLDisplay r19 = EGL14.eglGetDisplay(0);     // Catch: Throwable -> L62 Exception -> L64
        if (r19 == null) goto L57;
    L60:
        e = e;
        r12 = r12;
        r14 = null;
        r11 = r19;
    L58:
        th = th;
        r12 = r12;
        r10 = r13;
        r14 = null;
        r11 = r19;
        goto L115
    L26:
        if (r19.equals(EGL14.EGL_NO_DISPLAY) == true) goto L57;
        int[] r20 = new int[2];     // Catch: Throwable -> L58 Exception -> L60
        if (EGL14.eglInitialize(r19, r20, 0, r20, 1) == false) goto L55;
        int[] r110 = new int[1];     // Catch: Throwable -> L58 Exception -> L60
        EGLConfig[] r111 = new EGLConfig[1];     // Catch: Throwable -> L58 Exception -> L60
        if (EGL14.eglChooseConfig(r19, new int[]{12344}, 0, r111, 0, 1, r110, 0) == false) goto L53;
        if (r110[0] <= 0) goto L51;
        EGLConfig r21 = r111[0];     // Catch: Throwable -> L58 Exception -> L60
        EGLContext r22 = EGL14.eglCreateContext(r19, r21, EGL14.EGL_NO_CONTEXT, new int[]{12344}, 0);     // Catch: Throwable -> L58 Exception -> L60
        if (r22 == null) goto L49;
        if (r22.equals(EGL14.EGL_NO_CONTEXT) == true) goto L49;
        EGLSurface r23 = EGL14.eglCreatePbufferSurface(r19, r21, new int[]{12344}, 0);     // Catch: Throwable -> L58 Exception -> L60
        if (r23 == null) goto L47;
        if (r23.equals(EGL14.EGL_NO_SURFACE) == true) goto L47;
        if (EGL14.eglMakeCurrent(r19, r23, r23, r22) == false) goto L45;
        r12 = r22;
        r14 = r23;
        r11 = r19;
        goto L133
    L45:
        throw new Exception("eglMakeCurrent error");     // Catch: Throwable -> L58 Exception -> L60
    L47:
        throw new Exception("eglCreatePbufferSurface error");     // Catch: Throwable -> L58 Exception -> L60
    L49:
        throw new Exception("eglCreateContext error");     // Catch: Throwable -> L58 Exception -> L60
    L51:
        throw new Exception("no egl config chosen");     // Catch: Throwable -> L58 Exception -> L60
    L53:
        throw new Exception("eglChooseConfig error");     // Catch: Throwable -> L58 Exception -> L60
    L55:
        throw new Exception("eglInitialize error");     // Catch: Throwable -> L58 Exception -> L60
    L57:
        throw new Exception("eglGetDisplay error");     // Catch: Throwable -> L58 Exception -> L60
    L64:
        e = e;
    L20:
        r12 = r12;
        r14 = null;
    L62:
        th = th;
        r10 = r13;
    L17:
        r14 = null;
        goto L115
    L144:
        if (r12.equals(EGL14.EGL_NO_CONTEXT) == true) goto L21;
        r13 = false;
        goto L22
    L18:
        e = e;
        r13 = false;
    L15:
        th = th;
        goto L17
    L95:
        e = e;
        r14 = null;
        r12 = null;
        r13 = false;
    L93:
        th = th;
        r14 = null;
        r12 = null;
        goto L115
    }
}
