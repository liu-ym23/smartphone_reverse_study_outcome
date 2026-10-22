package com.byted.cast.sdk.gl.grafika;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public class FullFrameRect {
    private Texture2dProgram mProgram;
    private final Drawable2d mRectDrawable;

    public int createTextureObject() {
        return this.mProgram.createTextureObject();
    }

    public Texture2dProgram getProgram() {
        return this.mProgram;
    }

    public FullFrameRect(Texture2dProgram r10) {
        this.mRectDrawable = new Drawable2d(Drawable2d.Prefab.FULL_RECTANGLE);
        this.mProgram = r10;
    }

    public void changeProgram(Texture2dProgram r10) {
        this.mProgram.release();
        this.mProgram = r10;
    }

    public void release(boolean r10) {
        Texture2dProgram r0 = this.mProgram;
        if (r0 == null) goto L8;
        if (r10 == false) goto L6;
        r0.release();
    L6:
        this.mProgram = null;
        return;
    }

    public void drawFrame(int r12, float[] r13) {
        this.mProgram.draw(GlUtil.IDENTITY_MATRIX, this.mRectDrawable.getVertexArray(), 0, this.mRectDrawable.getVertexCount(), this.mRectDrawable.getCoordsPerVertex(), this.mRectDrawable.getVertexStride(), r13, this.mRectDrawable.getTexCoordArray(), r12, this.mRectDrawable.getTexCoordStride());
    }
}
