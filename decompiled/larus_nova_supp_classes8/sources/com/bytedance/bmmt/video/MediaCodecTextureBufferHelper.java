package com.bytedance.bmmt.video;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class MediaCodecTextureBufferHelper {
    private ReleaseOutPutBuffer mReleaseFunc;
    private SurfaceTextureHelper mSurfaceTextureHelper;
    private boolean render;

    @FunctionalInterface
    public interface ReleaseOutPutBuffer {
        int release(boolean r1);
    }

    public float[] getMatrix() {
        SurfaceTextureHelper r0 = this.mSurfaceTextureHelper;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getTexMatrix();
    }

    public boolean isAvaliable() {
        SurfaceTextureHelper r0 = this.mSurfaceTextureHelper;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.isAvaliable();
    }

    public boolean updateTextureImage() {
        SurfaceTextureHelper r0 = this.mSurfaceTextureHelper;
        if (r0 != null) goto L6;
        return false;
    L6:
        r0.updateTexImage();
        return true;
    }

    public MediaCodecTextureBufferHelper(ReleaseOutPutBuffer r2) {
        this.render = false;
        this.mSurfaceTextureHelper = null;
        this.mReleaseFunc = r2;
    }

    public void releaseOutputBuffer(boolean r1) {
        runTask(r1);
    }

    public int runTask(boolean r2) {
        return this.mReleaseFunc.release(r2);
    }

    public void setRender(boolean r1) {
        this.render = r1;
    }

    public void setSurfaceTextureHelper(SurfaceTextureHelper r1) {
        this.mSurfaceTextureHelper = r1;
    }

    public boolean updateTextureImageAndWait(int r2) {
        SurfaceTextureHelper r0 = this.mSurfaceTextureHelper;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.updateTexImageAndWait(r2);
    }
}
