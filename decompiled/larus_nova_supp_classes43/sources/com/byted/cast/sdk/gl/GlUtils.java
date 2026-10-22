package com.byted.cast.sdk.gl;

import android.opengl.EGL14;
import android.opengl.GLES20;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
class GlUtils {
    public GlUtils() {
    }

    public static void checkEglError(String r10) {
        int r0 = EGL14.eglGetError();
        if (r0 != 12288) goto L6;
        return;
    L6:
        throw new RuntimeException(r10 + ": EGL error: 0x" + Integer.toHexString(r0));
    }

    public static void checkGlError(String r10) {
        int r0 = GLES20.glGetError();
        if (r0 == 1285) goto L11;
        if (r0 == 0) goto L9;
        if (r0 != 1285) goto L8;
        return;
    L8:
        throw new RuntimeException(r10 + ": glError 0x" + Integer.toHexString(r0));
    L9:
        return;
    L11:
        throw new RuntimeException(r10 + " error: GL_OUT_OF_MEMORY");
    }
}
