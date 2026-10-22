package com.bytedance.bmmt.video;

import android.opengl.GLES20;
import com.bytedance.bmmt.base.Logging;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class GlUtil {
    private GlUtil() {
    }

    public static void checkNoGLES2Error(String r3) {
        int r0 = GLES20.glGetError();
        if (r0 == 0) goto L9;
        Logging.e("checkNoGLES2Error", r3 + "error: " + r0);
        if (r0 != 1285) goto L8;
        return;
    L8:
        throw new RuntimeException(r3 + ": GLES20 error: " + r0);
    }

    public static void clearGLES2Error(String r2) {
        int r0 = GLES20.glGetError();
        if (r0 == 0) goto L6;
        Logging.w("clearGLES2Error", r2 + "clear opengl error: " + r0);
        return;
    }

    public static FloatBuffer createFloatBuffer(float[] r2) {
        ByteBuffer r0 = ByteBuffer.allocateDirect(r2.length * 4);
        r0.order(ByteOrder.nativeOrder());
        FloatBuffer r1 = r0.asFloatBuffer();
        r1.put(r2);
        r1.position(0);
        return r1;
    }

    public static int generateTexture(int r3) {
        int[] r1 = new int[1];
        GLES20.glGenTextures(1, r1, 0);
        int r0 = r1[0];
        GLES20.glBindTexture(r3, r0);
        GLES20.glTexParameterf(r3, 10241, 9729.0f);
        GLES20.glTexParameterf(r3, 10240, 9729.0f);
        GLES20.glTexParameterf(r3, 10242, 33071.0f);
        GLES20.glTexParameterf(r3, 10243, 33071.0f);
        checkNoGLES2Error("generateTexture");
        return r0;
    }
}
