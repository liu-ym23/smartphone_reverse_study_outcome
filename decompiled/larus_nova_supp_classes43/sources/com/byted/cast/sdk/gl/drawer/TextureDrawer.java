package com.byted.cast.sdk.gl.drawer;

import android.opengl.GLES20;
import android.opengl.GLES30;
import android.opengl.Matrix;
import com.byted.cast.sdk.gl.utils.GLUtils;
import com.byted.cast.sdk.log.Logger;
import com.byted.cast.sdk.log.LoggerManager;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public class TextureDrawer {
    private static final String TAG = "TextureDrawer";
    private float[] mCustomMVP;
    private int mDrawX;
    private int mDrawY;
    private int mHeight;
    private boolean mIsSetup;
    private Logger mLogger;
    private int mMVPMatrixLoc;
    private String mMirrorId;
    private int mProgram;
    private float mRotation;
    private int mTexCoordsLoc;
    private int mTexTransMatrixLoc;
    private float[] mTextureCoordinate;
    private int mVao;
    private int mVboTexCoords;
    private int mVboVertices;
    private float[] mVertexPosition;
    private int mVerticesLoc;
    private int mWidth;

    private void afterDraw() {
    }

    private void beforeDraw() {
    }

    public int getTextureTarget() {
        return 3553;
    }

    private boolean setupLocations() {
        this.mVerticesLoc = GLES20.glGetAttribLocation(this.mProgram, "a_pos");
        this.mTexCoordsLoc = GLES20.glGetAttribLocation(this.mProgram, "a_tex");
        this.mMVPMatrixLoc = GLES20.glGetUniformLocation(this.mProgram, "u_mvp");
        this.mTexTransMatrixLoc = GLES20.glGetUniformLocation(this.mProgram, "u_tex_trans");
        return GLUtils.checkGlError("TextureDrawer glBindAttribLocation", this.mMirrorId);
    }

    private void setupVBO() {
        GLES20.glBindBuffer(34962, this.mVboVertices);
        GLES20.glEnableVertexAttribArray(this.mVerticesLoc);
        GLES20.glVertexAttribPointer(this.mVerticesLoc, 2, 5126, false, 0, 0);
        GLES20.glBindBuffer(34962, this.mVboTexCoords);
        GLES20.glEnableVertexAttribArray(this.mTexCoordsLoc);
        GLES20.glVertexAttribPointer(this.mTexCoordsLoc, 2, 5126, false, 0, 0);
    }

    public String[] getShaderSources() {
        return new String[]{GLUtils.TEXTURE_VS, GLUtils.TEXTURE_2D_FS};
    }

    public void release() {
        int r0 = this.mProgram;
        if (r0 == 0) goto L5;
        GLES20.glDeleteProgram(r0);
        this.mProgram = 0;
    L5:
        int r1 = this.mVboVertices;
        if (r1 == 0) goto L8;
        GLES20.glDeleteBuffers(1, new int[]{r1}, 0);
        this.mVboVertices = 0;
    L8:
        int r10 = this.mVboTexCoords;
        if (r10 == 0) goto L11;
        GLES20.glDeleteBuffers(1, new int[]{r10}, 0);
        this.mVboTexCoords = 0;
    L11:
        int r11 = this.mVao;
        if (r11 == 0) goto L15;
        GLES30.glDeleteVertexArrays(1, new int[]{r11}, 0);
        this.mVao = 0;
        return;
    }

    private boolean setupBuffers() {
        float[] r0 = getVertexPosition();
        ByteBuffer r1 = ByteBuffer.allocateDirect(r0.length * 4);
        r1.order(ByteOrder.nativeOrder());
        FloatBuffer r10 = r1.asFloatBuffer();
        r10.put(r0);
        r10.rewind();
        float[] r11 = getTextureCoordinate();
        ByteBuffer r12 = ByteBuffer.allocateDirect(r11.length * 4);
        r12.order(ByteOrder.nativeOrder());
        FloatBuffer r13 = r12.asFloatBuffer();
        r13.put(r11);
        r13.rewind();
        int[] r14 = new int[2];
        GLES20.glGenBuffers(2, r14, 0);
        int r15 = r14[0];
        this.mVboVertices = r15;
        this.mVboTexCoords = r14[1];
        GLES20.glBindBuffer(34962, r15);
        GLES20.glBufferData(34962, 32, r10, 35044);
        GLES20.glBindBuffer(34962, this.mVboTexCoords);
        GLES20.glBufferData(34962, 32, r13, 35044);
        GLES20.glBindBuffer(34962, 0);
        if (GLUtils.isGL3() == false) goto L5;
        int r16 = GLUtils.createVAO();
        this.mVao = r16;
        GLES30.glBindVertexArray(r16);
    L5:
        setupVBO();
        if (GLUtils.isGL3() == false) goto L8;
        GLES30.glBindVertexArray(0);
    L8:
        GLES20.glBindBuffer(34962, 0);
        return GLUtils.checkGlError("TextureDrawer setup VAO, VBOs.", this.mMirrorId);
    }

    private boolean setupShaders() {
        String[] r0 = getShaderSources();
        int r1 = GLUtils.createProgram(r0[0], r0[1], this.mMirrorId);
        this.mProgram = r1;
        if (r1 == 0) goto L6;
        return true;
    L6:
        return false;
    }

    public boolean setup() {
        if (setupShaders() == true) goto L6;
        return false;
    L6:
        if (setupLocations() == true) goto L9;
        return false;
    L9:
        if (setupBuffers() == true) goto L11;
        return false;
    L11:
        this.mIsSetup = true;
        return true;
    }

    private float[] getTextureCoordinate() {
        return this.mTextureCoordinate;
    }

    private float[] getVertexPosition() {
        return this.mVertexPosition;
    }

    public int getDrawX() {
        return this.mDrawX;
    }

    public int getDrawY() {
        return this.mDrawY;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public boolean isSetup() {
        return this.mIsSetup;
    }

    public TextureDrawer(String r10) {
        this.mVertexPosition = GLUtils.VERTEX_POSITION;
        this.mTextureCoordinate = GLUtils.TEXTURE_COORDINATE;
        this.mMirrorId = r10;
        this.mLogger = LoggerManager.getLogger(r10);
    }

    public void draw(int r10) {
        draw(r10, null);
    }

    public void setRotation(float r10) {
        if (this.mCustomMVP != null) goto L5;
        this.mCustomMVP = new float[16];
    L5:
        this.mRotation = r10;
        Matrix.setIdentityM(this.mCustomMVP, 0);
        Matrix.rotateM(this.mCustomMVP, 0, r10, 0.0f, 0.0f, -1.0f);
    }

    public void setTextureCoordinate(float[] r1) {
        this.mTextureCoordinate = r1;
    }

    private void generateFitConfig(int r10, int r11) {
        this.mTextureCoordinate = GLUtils.TEXTURE_COORDINATE;
        int r0 = this.mWidth;
        float r12 = 1.0f;
        int r13 = this.mHeight;
        float r14 = (r10 * 1.0f) / r11;
        float r15 = 0.0f;
        if (r14 >= ((r0 * 1.0f) / r13)) goto L5;
        float r1 = r13 * r14;
        float r16 = 0.5f - ((r1 / r0) / 2.0f);
        this.mDrawX = (int) (r0 * r16);
        r15 = r16;
        r12 = ((r1 / r0) / 2.0f) + 0.5f;
        float r17 = 0.0f;
        float r18 = 1.0f;
    L6:
        ortho(r15, r12, r17, r18);
        return;
    L5:
        float r19 = r0 / r14;
        r17 = 0.5f - ((r19 / r13) / 2.0f);
        r18 = ((r19 / r13) / 2.0f) + 0.5f;
        this.mDrawY = (int) (r13 * r17);
        goto L6
    }

    private void generateFullConfig(int r18, int r19) {
        this.mVertexPosition = GLUtils.VERTEX_POSITION;
        float r1 = (this.mWidth * 1.0f) / this.mHeight;
        float r10 = r18;
        float r11 = r19;
        if (((r10 * 1.0f) / r11) >= r1) goto L5;
        float r12 = ((r11 - (r10 / r1)) / 2.0f) / r11;
        float r13 = 1.0f - r12;
        this.mTextureCoordinate = new float[]{0.0f, r12, 0.0f, r13, 1.0f, r12, 1.0f, r13};
        return;
    L5:
        float r14 = ((r10 - (r11 * r1)) / 2.0f) / r10;
        float r15 = 1.0f - r14;
        this.mTextureCoordinate = new float[]{r14, 0.0f, r14, 1.0f, r15, 0.0f, r15, 1.0f};
    }

    public void draw(int r10, float[] r11) {
        GLES20.glUseProgram(this.mProgram);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(getTextureTarget(), r10);
        if (GLUtils.isGL3() == false) goto L5;
        GLES30.glBindVertexArray(this.mVao);
    L6:
        int r12 = this.mMVPMatrixLoc;
        float[] r0 = this.mCustomMVP;
        if (r0 != null) goto L10;
        r0 = GLUtils.IDENTITY_MATRIX;
    L10:
        GLES20.glUniformMatrix4fv(r12, 1, false, r0, 0);
        if (r11 != null) goto L13;
        r11 = GLUtils.IDENTITY_MATRIX;
    L13:
        GLES20.glUniformMatrix4fv(this.mTexTransMatrixLoc, 1, false, r11, 0);
        GLES20.glViewport(0, 0, this.mWidth, this.mHeight);
        beforeDraw();
        GLES20.glDrawArrays(5, 0, 4);
        afterDraw();
        if (GLUtils.isGL3() == false) goto L16;
        GLES30.glBindVertexArray(0);
    L16:
        GLES20.glBindBuffer(34962, 0);
        GLES20.glBindTexture(getTextureTarget(), 0);
        return;
    L5:
        setupVBO();
        goto L6
    }

    public boolean setViewportSize(int r1, int r10) {
        this.mWidth = r1;
        this.mHeight = r10;
        return true;
    }

    public boolean setup(int r10, int r11, GLUtils.DISPLAY_MODE r12) {
        if (r12 != GLUtils.DISPLAY_MODE.FULL) goto L6;
        generateFullConfig(r10, r11);
    L9:
        return setup();
    L6:
        if (r12 != GLUtils.DISPLAY_MODE.FIT) goto L9;
        generateFitConfig(r10, r11);
        goto L9
    }

    private void ortho(float r21, float r22, float r23, float r24) {
        float r10 = (this.mWidth * 1.0f) / this.mHeight;
        float r11 = r10 * 2.0f;
        float r12 = (r21 * r11) - r10;
        float r13 = (r11 * r22) - r10;
        float r14 = ((r23 * 2.0f) - 1.0f) * (-1.0f);
        float r1 = ((2.0f * r24) - 1.0f) * (-1.0f);
        float[] r15 = new float[16];
        this.mCustomMVP = r15;
        Matrix.orthoM(r15, 0, -r10, r10, -1.0f, 1.0f, -1.0f, 1.0f);
        Matrix.rotateM(this.mCustomMVP, 0, this.mRotation, 0.0f, 0.0f, -1.0f);
        this.mVertexPosition = new float[]{r12, r1, r12, r14, r13, r1, r13, r14};
    }
}
