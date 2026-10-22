package com.byted.cast.sdk.gl;

import android.opengl.GLES20;
import android.opengl.Matrix;
import android.util.Size;
import com.byted.cast.common.Logger;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public class FullFrameRect {
    private static final float[] FULL_RECTANGLE_COORDS = null;
    private static final float[] FULL_RECTANGLE_TEX_COORDS = null;
    private static final String TAG = "FullFrameRect";
    private FloatBuffer FULL_RECTANGLE_BUF;
    private FloatBuffer FULL_RECTANGLE_TEX_BUF;
    private float[] mvpMatrix;
    private Texture2DProgram program;
    private boolean useCamera;

    static {
        FULL_RECTANGLE_COORDS = new float[]{-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};
        FULL_RECTANGLE_TEX_COORDS = new float[]{0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f};
    }

    public int createTextureObject() {
        return this.program.createTextureObject();
    }

    public FullFrameRect(Texture2DProgram r10) {
        this.mvpMatrix = new float[16];
        this.useCamera = true;
        this.FULL_RECTANGLE_BUF = createFloatBuffer(FULL_RECTANGLE_COORDS);
        this.FULL_RECTANGLE_TEX_BUF = createFloatBuffer(FULL_RECTANGLE_TEX_COORDS);
        this.program = r10;
    }

    private static FloatBuffer createFloatBuffer(float[] r10) {
        ByteBuffer r0 = ByteBuffer.allocateDirect(r10.length * 4);
        r0.order(ByteOrder.nativeOrder());
        FloatBuffer r1 = r0.asFloatBuffer();
        r1.put(r10);
        r1.position(0);
        return r1;
    }

    public void changeProgram(Texture2DProgram r10) {
        this.program.release();
        this.program = r10;
    }

    public void release(boolean r1) {
        if (r1 == false) goto L5;
        this.program.release();
        return;
    }

    public void setUseCamera(boolean r10) {
        this.useCamera = r10;
        Logger.i(TAG, "setUseCamera:" + r10);
    }

    public void drawFrame(int r12, float[] r13) {
        this.program.draw(this.mvpMatrix, this.FULL_RECTANGLE_BUF, 0, 4, 2, 8, r13, this.FULL_RECTANGLE_TEX_BUF, r12, 8);
    }

    public void setMVPMatrixAndViewPort(float r13, Size r14) {
        Matrix.setIdentityM(this.mvpMatrix, 0);
        if (this.useCamera == false) goto L13;
        StringBuilder r0 = new StringBuilder("setMVPMatrixAndViewPort, rotateM:");
        if (r13 != 0.0f) goto L7;
        float r10 = 270.0f;
    L8:
        r0.append(r10);
        Logger.i(TAG, r0.toString());
        float[] r11 = this.mvpMatrix;
        if (r13 != 0.0f) goto L11;
        float r12 = 270.0f;
    L12:
        Matrix.rotateM(r11, 0, r12, 0.0f, 0.0f, -1.0f);
    L14:
        GLES20.glViewport(0, 0, r14.getWidth(), r14.getHeight());
        return;
    L11:
        r12 = r13 - 90.0f;
        goto L12
    L7:
        r10 = r13 - 90.0f;
        goto L8
    L13:
        Logger.i(TAG, "setMVPMatrixAndViewPort, rotateM: 0");
        Matrix.rotateM(this.mvpMatrix, 0, 0.0f, 0.0f, 0.0f, -1.0f);
        goto L14
    }
}
