package com.bytedance.bmmt.video;

import android.opengl.EGL14;
import android.opengl.EGLContext;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class EglBaseUtils {
    public EglBaseUtils() {
    }

    public static EGLContext getCurrentContext() {
        return EGL14.eglGetCurrentContext();
    }

    public static int getPreferredEglVersion() {
        return EglBase.EglVersion.getPreferredEglVersion();
    }

    public static EglBase createEGLBase(EGLContext r2) {
        if (r2 == EGL14.EGL_NO_CONTEXT) goto L9;
        if (r2 == null) goto L9;
        return EglBase.CC.createEgl14(r2, EglBase.CC.getEGLConfig(getPreferredEglVersion(), EglBase.Config.CONFIG_PLAIN));
    L9:
        return EglBase.CC.createEgl14(EglBase.CC.getEGLConfig(getPreferredEglVersion(), EglBase.Config.CONFIG_PLAIN));
    }

    public static EglBase.Context getEGLBaseContext(EglBase r0) {
        if (r0 != null) goto L4;
        return null;
    L4:
        return r0.getEglBaseContext();
    }

    public static long getNativeContextFromEGLBaseContext(EglBase.Context r2) {
        if (r2 != null) goto L4;
        return 0;
    L4:
        return r2.getNativeEglContext();
    }

    public static long getNativeEGLContext(EGLContext r2) {
        if (r2 != null) goto L6;
        return 0;
    L6:
        return r2.getNativeHandle();
    }

    public static void releaseEGLBase(EglBase r0) {
        if (r0 == null) goto L5;
        r0.release();
        return;
    }

    public static void setPreferredEglVersion(int r0) {
        EglBase.EglVersion.setPreferredEglVersion(r0);
    }
}
