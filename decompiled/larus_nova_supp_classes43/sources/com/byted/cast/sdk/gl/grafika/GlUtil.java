package com.byted.cast.sdk.gl.grafika;

import android.opengl.GLES20;
import android.opengl.Matrix;
import com.bytedance.ai.bridge.method.calendar.remote.exception.CalDavException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public class GlUtil {
    public static final float[] IDENTITY_MATRIX = null;
    private static final int SIZEOF_FLOAT = 4;
    public static final String TAG = "Grafika";

    private GlUtil() {
    }

    static {
        float[] r0 = new float[16];
        IDENTITY_MATRIX = r0;
        Matrix.setIdentityM(r0, 0);
    }

    public static void logVersionInfo() {
        GLES20.glGetString(7936);
        GLES20.glGetString(7937);
        GLES20.glGetString(7938);
    }

    public static void checkGlError(String r10) {
        int r0 = GLES20.glGetError();
        if (r0 != 0) goto L6;
        return;
    L6:
        throw new RuntimeException(r10 + ": glError 0x" + Integer.toHexString(r0));
    }

    public static FloatBuffer createFloatBuffer(float[] r10) {
        ByteBuffer r0 = ByteBuffer.allocateDirect(r10.length * 4);
        r0.order(ByteOrder.nativeOrder());
        FloatBuffer r1 = r0.asFloatBuffer();
        r1.put(r10);
        r1.position(0);
        return r1;
    }

    public static void checkLocation(int r10, String r11) {
        if (r10 < 0) goto L5;
        return;
    L5:
        throw new RuntimeException("Unable to locate '" + r11 + "' in program");
    }

    public static int createProgram(String r10, String r11) {
        int r12 = loadShader(35633, r10);
        if (r12 != 0) goto L5;
        return 0;
    L5:
        int r13 = loadShader(35632, r11);
        if (r13 != 0) goto L8;
        return 0;
    L8:
        int r1 = GLES20.glCreateProgram();
        checkGlError("glCreateProgram");
        GLES20.glAttachShader(r1, r12);
        checkGlError("glAttachShader");
        GLES20.glAttachShader(r1, r13);
        checkGlError("glAttachShader");
        GLES20.glLinkProgram(r1);
        int[] r14 = new int[1];
        GLES20.glGetProgramiv(r1, 35714, r14, 0);
        if (r14[0] == 1) goto L12;
        GLES20.glGetProgramInfoLog(r1);
        GLES20.glDeleteProgram(r1);
        return 0;
    L12:
        return r1;
    }

    public static int loadShader(int r10, String r11) {
        int r0 = GLES20.glCreateShader(r10);
        checkGlError("glCreateShader type=" + r10);
        GLES20.glShaderSource(r0, r11);
        GLES20.glCompileShader(r0);
        int[] r12 = new int[1];
        GLES20.glGetShaderiv(r0, 35713, r12, 0);
        if (r12[0] != 0) goto L6;
        GLES20.glGetShaderInfoLog(r0);
        GLES20.glDeleteShader(r0);
        return 0;
    L6:
        return r0;
    }

    public static int createImageTexture(ByteBuffer r11, int r12, int r13, int r14) {
        int[] r1 = new int[1];
        GLES20.glGenTextures(1, r1, 0);
        int r0 = r1[0];
        checkGlError("glGenTextures");
        GLES20.glBindTexture(3553, r0);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexParameteri(3553, CalDavException.MAX_EXCERPT_SIZE, 9729);
        checkGlError("loadImageTexture");
        GLES20.glTexImage2D(3553, 0, r14, r12, r13, 0, r14, 5121, r11);
        checkGlError("loadImageTexture");
        return r0;
    }
}
