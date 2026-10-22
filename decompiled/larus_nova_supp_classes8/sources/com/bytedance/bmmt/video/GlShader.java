package com.bytedance.bmmt.video;

import android.opengl.GLES20;
import java.nio.FloatBuffer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class GlShader {
    private static final String TAG = "GlShader";
    private int program;

    public void release() {
        int r0 = this.program;
        if (r0 == (-1)) goto L6;
        GLES20.glDeleteProgram(r0);
        this.program = -1;
        return;
    }

    public void useProgram() {
        int r0 = this.program;
        if (r0 == (-1)) goto L7;
        GLES20.glUseProgram(r0);
        GlUtil.checkNoGLES2Error("glUseProgram");
        return;
    L7:
        throw new RuntimeException("The program has been released");
    }

    public int getAttribLocation(String r4) {
        int r0 = this.program;
        if (r0 == (-1)) goto L10;
        int r1 = GLES20.glGetAttribLocation(r0, r4);
        if (r1 < 0) goto L8;
        return r1;
    L8:
        throw new RuntimeException("Could not locate '" + r4 + "' in program");
    L10:
        throw new RuntimeException("The program has been released");
    }

    public int getUniformLocation(String r4) {
        int r0 = this.program;
        if (r0 == (-1)) goto L10;
        int r1 = GLES20.glGetUniformLocation(r0, r4);
        if (r1 < 0) goto L8;
        return r1;
    L8:
        throw new RuntimeException("Could not locate uniform '" + r4 + "' in program");
    L10:
        throw new RuntimeException("The program has been released");
    }

    public GlShader(String r6, String r7) {
        int r8 = compileShader(35633, r6);
        int r9 = compileShader(35632, r7);
        int r0 = GLES20.glCreateProgram();
        this.program = r0;
        if (r0 == 0) goto L11;
        GLES20.glAttachShader(r0, r8);
        GLES20.glAttachShader(this.program, r9);
        GLES20.glLinkProgram(this.program);
        int[] r1 = {0};
        GLES20.glGetProgramiv(this.program, 35714, r1, 0);
        if (r1[0] != 1) goto L8;
        GLES20.glDeleteShader(r8);
        GLES20.glDeleteShader(r9);
        GlUtil.checkNoGLES2Error("Creating GlShader");
        return;
    L8:
        GLES20.glGetProgramInfoLog(this.program);
        throw new RuntimeException(GLES20.glGetProgramInfoLog(this.program));
    L11:
        throw new RuntimeException("glCreateProgram() failed. GLES20 error: " + GLES20.glGetError());
    }

    private static int compileShader(int r3, String r4) {
        int r5 = GLES20.glCreateShader(r3);
        if (r5 == 0) goto L11;
        GLES20.glShaderSource(r5, r4);
        GLES20.glCompileShader(r5);
        int[] r0 = {0};
        GLES20.glGetShaderiv(r5, 35713, r0, 0);
        if (r0[0] != 1) goto L8;
        GlUtil.checkNoGLES2Error("compileShader");
        return r5;
    L8:
        GLES20.glGetShaderInfoLog(r5);
        throw new RuntimeException(GLES20.glGetShaderInfoLog(r5));
    L11:
        throw new RuntimeException("glCreateShader() failed. GLES20 error: " + GLES20.glGetError());
    }

    public void setVertexAttribArray(String r2, int r3, FloatBuffer r4) {
        setVertexAttribArray(r2, r3, 0, r4);
    }

    public void setVertexAttribArray(String r9, int r10, int r11, FloatBuffer r12) {
        if (this.program == (-1)) goto L7;
        int r2 = getAttribLocation(r9);
        GLES20.glEnableVertexAttribArray(r2);
        GLES20.glVertexAttribPointer(r2, r10, 5126, false, r11, r12);
        GlUtil.checkNoGLES2Error("setVertexAttribArray");
        return;
    L7:
        throw new RuntimeException("The program has been released");
    }
}
