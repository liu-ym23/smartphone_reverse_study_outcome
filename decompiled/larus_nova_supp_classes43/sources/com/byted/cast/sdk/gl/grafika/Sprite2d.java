package com.byted.cast.sdk.gl.grafika;

import android.opengl.Matrix;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public class Sprite2d {
    private static final String TAG = "Grafika";
    private float mAngle;
    private float[] mColor;
    private Drawable2d mDrawable;
    private boolean mMatrixReady;
    private float[] mModelViewMatrix;
    private float mPosX;
    private float mPosY;
    private float mScaleX;
    private float mScaleY;
    private float[] mScratchMatrix;
    private int mTextureId;

    private void recomputeMatrix() {
        float[] r10 = this.mModelViewMatrix;
        Matrix.setIdentityM(r10, 0);
        Matrix.translateM(r10, 0, this.mPosX, this.mPosY, 0.0f);
        float r11 = this.mAngle;
        if (r11 == 0.0f) goto L5;
        Matrix.rotateM(r10, 0, r11, 0.0f, 0.0f, 1.0f);
    L5:
        Matrix.scaleM(r10, 0, this.mScaleX, this.mScaleY, 1.0f);
        this.mMatrixReady = true;
    }

    public float[] getModelViewMatrix() {
        if (this.mMatrixReady == true) goto L6;
        recomputeMatrix();
    L6:
        return this.mModelViewMatrix;
    }

    public String toString() {
        return "[Sprite2d pos=" + this.mPosX + "," + this.mPosY + " scale=" + this.mScaleX + "," + this.mScaleY + " angle=" + this.mAngle + " color={" + this.mColor[0] + "," + this.mColor[1] + "," + this.mColor[2] + "} drawable=" + this.mDrawable + "]";
    }

    public float[] getColor() {
        return this.mColor;
    }

    public float getPositionX() {
        return this.mPosX;
    }

    public float getPositionY() {
        return this.mPosY;
    }

    public float getRotation() {
        return this.mAngle;
    }

    public float getScaleX() {
        return this.mScaleX;
    }

    public float getScaleY() {
        return this.mScaleY;
    }

    public Sprite2d(Drawable2d r10) {
        this.mScratchMatrix = new float[16];
        this.mDrawable = r10;
        float[] r11 = new float[4];
        this.mColor = r11;
        r11[3] = 1.0f;
        this.mTextureId = -1;
        this.mModelViewMatrix = new float[16];
        this.mMatrixReady = false;
    }

    public void setRotation(float r10) {
    L3:
        if (r10 < 360.0f) goto L6;
        r10 = r10 - 360.0f;
    L6:
        if (r10 > (-360.0f)) goto L8;
        r10 = r10 + 360.0f;
        goto L6
    L8:
        this.mAngle = r10;
        this.mMatrixReady = false;
    }

    public void setTexture(int r1) {
        this.mTextureId = r1;
    }

    public void draw(Texture2dProgram r19, float[] r20) {
        Matrix.multiplyMM(this.mScratchMatrix, 0, r20, 0, getModelViewMatrix(), 0);
        r19.draw(this.mScratchMatrix, this.mDrawable.getVertexArray(), 0, this.mDrawable.getVertexCount(), this.mDrawable.getCoordsPerVertex(), this.mDrawable.getVertexStride(), GlUtil.IDENTITY_MATRIX, this.mDrawable.getTexCoordArray(), this.mTextureId, this.mDrawable.getTexCoordStride());
    }

    public void setPosition(float r1, float r10) {
        this.mPosX = r1;
        this.mPosY = r10;
        this.mMatrixReady = false;
    }

    public void setScale(float r1, float r10) {
        this.mScaleX = r1;
        this.mScaleY = r10;
        this.mMatrixReady = false;
    }

    public void draw(FlatShadedProgram r16, float[] r17) {
        Matrix.multiplyMM(this.mScratchMatrix, 0, r17, 0, getModelViewMatrix(), 0);
        r16.draw(this.mScratchMatrix, this.mColor, this.mDrawable.getVertexArray(), 0, this.mDrawable.getVertexCount(), this.mDrawable.getCoordsPerVertex(), this.mDrawable.getVertexStride());
    }

    public void setColor(float r10, float r11, float r12) {
        float[] r0 = this.mColor;
        r0[0] = r10;
        r0[1] = r11;
        r0[2] = r12;
    }
}
