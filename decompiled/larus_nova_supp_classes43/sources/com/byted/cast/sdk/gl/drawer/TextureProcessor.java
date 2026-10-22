package com.byted.cast.sdk.gl.drawer;

import android.opengl.GLES20;
import com.byted.cast.sdk.gl.utils.GLUtils;
import com.byted.cast.sdk.log.Logger;
import com.byted.cast.sdk.log.LoggerManager;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public class TextureProcessor extends TextureDrawer {
    private int mFbo;
    private Logger mLogger;
    private String mMirrorId;
    private int mOutTex;

    private void releaseOutTex() {
        int r0 = this.mOutTex;
        if (r0 == 0) goto L6;
        GLES20.glDeleteTextures(1, new int[]{r0}, 0);
        this.mOutTex = 0;
        return;
    }

    private void setupFBO() {
        this.mFbo = GLUtils.createFBO();
    }

    @Override // com.byted.cast.sdk.gl.drawer.TextureDrawer
    public void release() {
        super.release();
        int r0 = this.mFbo;
        if (r0 == 0) goto L5;
        GLES20.glDeleteFramebuffers(1, new int[]{r0}, 0);
        this.mFbo = 0;
    L5:
        releaseOutTex();
    }

    @Override // com.byted.cast.sdk.gl.drawer.TextureDrawer
    public boolean setup() {
        setupFBO();
        return super.setup();
    }

    public TextureProcessor(String r1) {
        super(r1);
        this.mMirrorId = r1;
        this.mLogger = LoggerManager.getLogger(r1);
    }

    public int process(int r10) {
        return process(r10, null);
    }

    private boolean setupTexture(int r10, int r11) {
        this.mOutTex = GLUtils.createImageTexture(null, r10, r11, 6408, this.mMirrorId);
        return true;
    }

    public int process(int r10, float[] r11) {
        return process(r10, r11, this.mOutTex);
    }

    @Override // com.byted.cast.sdk.gl.drawer.TextureDrawer
    public boolean setViewportSize(int r1, int r10) {
        super.setViewportSize(r1, r10);
        releaseOutTex();
        return setupTexture(r1, r10);
    }

    public int process(int r10, float[] r11, int r12) {
        GLES20.glBindFramebuffer(36160, this.mFbo);
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, r12, 0);
        GLES20.glClear(16384);
        draw(r10, r11);
        GLES20.glBindFramebuffer(36160, 0);
        return r12;
    }
}
