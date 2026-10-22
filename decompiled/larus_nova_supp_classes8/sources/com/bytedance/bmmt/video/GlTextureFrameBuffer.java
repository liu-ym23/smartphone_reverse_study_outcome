package com.bytedance.bmmt.video;

import android.opengl.GLES20;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class GlTextureFrameBuffer {
    private int frameBufferId;
    private int height;
    private final int pixelFormat;
    private int textureId;
    private int width;

    public void release() {
        GLES20.glDeleteTextures(1, new int[]{this.textureId}, 0);
        this.textureId = 0;
        GLES20.glDeleteFramebuffers(1, new int[]{this.frameBufferId}, 0);
        this.frameBufferId = 0;
        this.width = 0;
        this.height = 0;
    }

    public int getFrameBufferId() {
        return this.frameBufferId;
    }

    public int getHeight() {
        return this.height;
    }

    public int getTextureId() {
        return this.textureId;
    }

    public int getWidth() {
        return this.width;
    }

    public GlTextureFrameBuffer(int r4) {
        switch(r4) {
            case 6407: goto L6;
            case 6408: goto L6;
            case 6409: goto L6;
            default: goto L5;
        };
    L6:
        this.pixelFormat = r4;
        this.width = 0;
        this.height = 0;
        return;
    L5:
        throw new IllegalArgumentException("Invalid pixel format: " + r4);
    }

    public void setSize(int r13, int r14) {
        if (r13 <= 0) goto L22;
        if (r14 <= 0) goto L22;
        if (r13 == this.width) goto L7;
    L9:
        this.width = r13;
        this.height = r14;
        if (this.textureId != 0) goto L13;
        this.textureId = GlUtil.generateTexture(3553);
    L13:
        if (this.frameBufferId != 0) goto L15;
        int[] r3 = new int[1];
        GLES20.glGenFramebuffers(1, r3, 0);
        this.frameBufferId = r3[0];
    L15:
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, this.textureId);
        int r9 = this.pixelFormat;
        GLES20.glTexImage2D(3553, 0, r9, r13, r14, 0, r9, 5121, null);
        GLES20.glBindTexture(3553, 0);
        GlUtil.checkNoGLES2Error("GlTextureFrameBuffer setSize");
        GLES20.glBindFramebuffer(36160, this.frameBufferId);
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.textureId, 0);
        int r15 = GLES20.glCheckFramebufferStatus(36160);
        if (r15 != 36053) goto L20;
        GLES20.glBindFramebuffer(36160, 0);
        return;
    L20:
        throw new IllegalStateException("Framebuffer not complete, status: " + r15);
    L7:
        if (r14 != this.height) goto L9;
        return;
    L22:
        throw new IllegalArgumentException("Invalid size: " + r13 + "x" + r14);
    }
}
