package com.byted.cast.sdk.gl;

import android.opengl.GLES20;
import com.bytedance.ai.bridge.method.calendar.remote.exception.CalDavException;
import java.nio.FloatBuffer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public class Texture2DProgram {
    private static final String FRAGMENT_SHADER_EXT = "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nvoid main() {\n    gl_FragColor = texture2D(sTexture, vTextureCoord);\n}\n";
    private static final String VERTEX_SHADER = "uniform mat4 uMVPMatrix;\nuniform mat4 uTexMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uTexMatrix * aTextureCoord).xy;\n}\n";
    private int aPositionLoc;
    private int aTextureCoordLoc;
    private int programHandle;
    private int uMVPMatrixLoc;
    private int uTexMatrixLoc;

    public int createTextureObject() {
        int[] r1 = new int[1];
        GLES20.glGenTextures(1, r1, 0);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(36197, r1[0]);
        GlUtils.checkGlError("glBindTexture mTextureID");
        GLES20.glTexParameterf(36197, 10241, 9729.0f);
        GLES20.glTexParameterf(36197, CalDavException.MAX_EXCERPT_SIZE, 9729.0f);
        GLES20.glTexParameteri(36197, 10242, 33071);
        GLES20.glTexParameteri(36197, 10243, 33071);
        GlUtils.checkGlError("glTexParameter");
        return r1[0];
    }

    public void release() {
        GLES20.glDeleteProgram(this.programHandle);
    }

    public Texture2DProgram() throws Exception {
        int r0 = createProgram(VERTEX_SHADER, FRAGMENT_SHADER_EXT);
        this.programHandle = r0;
        if (r0 == 0) goto L7;
        int r1 = GLES20.glGetAttribLocation(r0, "aPosition");
        this.aPositionLoc = r1;
        checkLocation(r1, "aPosition");
        int r10 = GLES20.glGetAttribLocation(this.programHandle, "aTextureCoord");
        this.aTextureCoordLoc = r10;
        checkLocation(r10, "aTextureCoord");
        int r11 = GLES20.glGetUniformLocation(this.programHandle, "uMVPMatrix");
        this.uMVPMatrixLoc = r11;
        checkLocation(r11, "uMVPMatrix");
        int r12 = GLES20.glGetUniformLocation(this.programHandle, "uTexMatrix");
        this.uTexMatrixLoc = r12;
        checkLocation(r12, "uTexMatrix");
        return;
    L7:
        throw new RuntimeException("Unable to create program");
    }

    private void checkLocation(int r10, String r11) {
        if (r10 < 0) goto L5;
        return;
    L5:
        throw new RuntimeException("Unable to locate '" + r11 + "' in program");
    }

    private int createProgram(String r10, String r11) throws Exception {
        int r12 = loadShader(35633, r10);
        if (r12 != 0) goto L5;
        return 0;
    L5:
        int r13 = loadShader(35632, r11);
        if (r13 != 0) goto L8;
        return 0;
    L8:
        int r1 = GLES20.glCreateProgram();
        GlUtils.checkGlError("glCreateProgram");
        if (r1 == 0) goto L16;
        GLES20.glAttachShader(r1, r12);
        GlUtils.checkGlError("glAttachShader");
        GLES20.glAttachShader(r1, r13);
        GlUtils.checkGlError("glAttachShader");
        GLES20.glLinkProgram(r1);
        int[] r14 = new int[1];
        GLES20.glGetProgramiv(r1, 35714, r14, 0);
        if (r14[0] != 1) goto L13;
        return r1;
    L13:
        String r15 = GLES20.glGetProgramInfoLog(r1);
        GLES20.glDeleteProgram(r1);
        throw new Exception("Could not link program: " + r15);
    L16:
        throw new Exception("Could not create program");
    }

    private int loadShader(int r10, String r11) throws Exception {
        int r0 = GLES20.glCreateShader(r10);
        GlUtils.checkGlError("glCreateShader type=" + r10);
        GLES20.glShaderSource(r0, r11);
        GLES20.glCompileShader(r0);
        int[] r12 = new int[1];
        GLES20.glGetShaderiv(r0, 35713, r12, 0);
        if (r12[0] == 0) goto L5;
        return r0;
    L5:
        String r13 = GLES20.glGetShaderInfoLog(r0);
        GLES20.glDeleteShader(r0);
        throw new Exception("Could not compile shader " + r10 + ": " + r13);
    }

    public void draw(float[] r13, FloatBuffer r14, int r15, int r16, int r17, int r18, float[] r19, FloatBuffer r20, int r21, int r22) {
        GlUtils.checkGlError("draw start");
        GLES20.glUseProgram(this.programHandle);
        GlUtils.checkGlError("glUseProgram");
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(36197, r21);
        GLES20.glUniformMatrix4fv(this.uMVPMatrixLoc, 1, false, r13, 0);
        GlUtils.checkGlError("glUniformMatrix4fv");
        GLES20.glUniformMatrix4fv(this.uTexMatrixLoc, 1, false, r19, 0);
        GlUtils.checkGlError("glUniformMatrix4fv");
        GLES20.glEnableVertexAttribArray(this.aPositionLoc);
        GlUtils.checkGlError("glEnableVertexAttribArray");
        GLES20.glVertexAttribPointer(this.aPositionLoc, r17, 5126, false, r18, r14);
        GlUtils.checkGlError("glVertexAttribPointer");
        GLES20.glEnableVertexAttribArray(this.aTextureCoordLoc);
        GlUtils.checkGlError("glEnableVertexAttribArray");
        GLES20.glVertexAttribPointer(this.aTextureCoordLoc, 2, 5126, false, r22, r20);
        GlUtils.checkGlError("glVertexAttribPointer");
        GLES20.glDrawArrays(5, r15, r16);
        GlUtils.checkGlError("glDrawArrays");
        GLES20.glDisableVertexAttribArray(this.aPositionLoc);
        GLES20.glDisableVertexAttribArray(this.aTextureCoordLoc);
        GLES20.glBindTexture(36197, 0);
        GLES20.glUseProgram(0);
    }
}
