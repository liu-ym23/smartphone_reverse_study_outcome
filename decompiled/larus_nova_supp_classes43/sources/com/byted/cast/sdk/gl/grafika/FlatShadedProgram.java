package com.byted.cast.sdk.gl.grafika;

import android.opengl.GLES20;
import java.nio.FloatBuffer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public class FlatShadedProgram {
    private static final String FRAGMENT_SHADER = "precision mediump float;uniform vec4 uColor;void main() {    gl_FragColor = uColor;}";
    private static final String TAG = "Grafika";
    private static final String VERTEX_SHADER = "uniform mat4 uMVPMatrix;attribute vec4 aPosition;void main() {    gl_Position = uMVPMatrix * aPosition;}";
    private int mProgramHandle;
    private int maPositionLoc;
    private int muColorLoc;
    private int muMVPMatrixLoc;

    public void release() {
        GLES20.glDeleteProgram(this.mProgramHandle);
        this.mProgramHandle = -1;
    }

    public FlatShadedProgram() {
        this.mProgramHandle = -1;
        this.muColorLoc = -1;
        this.muMVPMatrixLoc = -1;
        this.maPositionLoc = -1;
        int r0 = GlUtil.createProgram(VERTEX_SHADER, FRAGMENT_SHADER);
        this.mProgramHandle = r0;
        if (r0 == 0) goto L7;
        int r1 = GLES20.glGetAttribLocation(r0, "aPosition");
        this.maPositionLoc = r1;
        GlUtil.checkLocation(r1, "aPosition");
        int r10 = GLES20.glGetUniformLocation(this.mProgramHandle, "uMVPMatrix");
        this.muMVPMatrixLoc = r10;
        GlUtil.checkLocation(r10, "uMVPMatrix");
        int r11 = GLES20.glGetUniformLocation(this.mProgramHandle, "uColor");
        this.muColorLoc = r11;
        GlUtil.checkLocation(r11, "uColor");
        return;
    L7:
        throw new RuntimeException("Unable to create program");
    }

    public void draw(float[] r11, float[] r12, FloatBuffer r13, int r14, int r15, int r16, int r17) {
        GlUtil.checkGlError("draw start");
        GLES20.glUseProgram(this.mProgramHandle);
        GlUtil.checkGlError("glUseProgram");
        GLES20.glUniformMatrix4fv(this.muMVPMatrixLoc, 1, false, r11, 0);
        GlUtil.checkGlError("glUniformMatrix4fv");
        GLES20.glUniform4fv(this.muColorLoc, 1, r12, 0);
        GlUtil.checkGlError("glUniform4fv ");
        GLES20.glEnableVertexAttribArray(this.maPositionLoc);
        GlUtil.checkGlError("glEnableVertexAttribArray");
        GLES20.glVertexAttribPointer(this.maPositionLoc, r16, 5126, false, r17, r13);
        GlUtil.checkGlError("glVertexAttribPointer");
        GLES20.glDrawArrays(5, r14, r15);
        GlUtil.checkGlError("glDrawArrays");
        GLES20.glDisableVertexAttribArray(this.maPositionLoc);
        GLES20.glUseProgram(0);
    }
}
