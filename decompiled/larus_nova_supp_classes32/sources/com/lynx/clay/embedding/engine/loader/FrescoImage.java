package com.lynx.clay.embedding.engine.loader;

import android.graphics.Bitmap;
import android.graphics.BlendMode;
import android.graphics.Canvas;
import com.facebook.common.references.CloseableReference;
import com.facebook.fresco.animation.backend.AnimationBackend;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.imagepipeline.core.ImagePipelineFactory;
import com.facebook.imagepipeline.image.CloseableAnimatedImage;
import com.facebook.imagepipeline.image.CloseableBitmap;
import com.facebook.imagepipeline.image.CloseableImage;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class FrescoImage {
    private CloseableReference<CloseableImage> imageSource;
    private AnimatedDrawable2 mAnimatedDrawable;
    private boolean mAutoPlay;
    private Canvas mCanvas;
    private int mCurrentFrame;
    private int mDuration;
    private Bitmap mFrameBitmap;
    private int mLoopCount;

    public void destroy() {
        AnimatedDrawable2 r0 = this.mAnimatedDrawable;
        if (r0 == null) goto L9;
        r0.stop();
        this.mAnimatedDrawable = null;
        Bitmap r1 = this.mFrameBitmap;
        if (r1 == null) goto L9;
        if (r1.isRecycled() == true) goto L9;
        this.mFrameBitmap.recycle();
        this.mFrameBitmap = null;
    L9:
        CloseableReference<CloseableImage> r2 = this.imageSource;
        if (r2 == null) goto L13;
        CloseableReference.closeSafely(r2);
        return;
    }

    public boolean drawFrame() {
        AnimatedDrawable2 r0 = this.mAnimatedDrawable;
        if (r0 != null) goto L6;
        return false;
    L6:
        if (r0.isRunning() == true) goto L8;
        return false;
    L8:
        drawFrameInternal();
        if (this.mCurrentFrame < this.mAnimatedDrawable.getFrameCount()) goto L16;
        int r1 = this.mLoopCount;
        if (r1 <= 0) goto L15;
        int r2 = r1 - 1;
        this.mLoopCount = r2;
        if (r2 > 0) goto L15;
        stopAnimation();
    L15:
        this.mCurrentFrame = 0;
    L16:
        return true;
    }

    public void drawFrameInternal() {
        this.mCanvas.drawColor(0, BlendMode.CLEAR);
        AnimationBackend r0 = this.mAnimatedDrawable.getAnimationBackend();
        this.mDuration = r0.getFrameDurationMs(this.mCurrentFrame);
        AnimatedDrawable2 r1 = this.mAnimatedDrawable;
        Canvas r2 = this.mCanvas;
        int r3 = this.mCurrentFrame;
        this.mCurrentFrame = r3 + 1;
        r0.drawFrame(r1, r2, r3);
    }

    public int getHeight() {
        return ((CloseableImage) this.imageSource.get()).getHeight();
    }

    public int getWidth() {
        return ((CloseableImage) this.imageSource.get()).getWidth();
    }

    public boolean isAnimated() {
        if (this.mAnimatedDrawable == null) goto L5;
        return true;
    L5:
        return false;
    }

    public void pauseAnimation() {
        AnimatedDrawable2 r0 = this.mAnimatedDrawable;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isPaused() == true) goto L9;
        this.mAnimatedDrawable.pause();
        return;
    }

    public void resumeAnimation() {
        AnimatedDrawable2 r0 = this.mAnimatedDrawable;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isPaused() == false) goto L9;
        this.mAnimatedDrawable.start();
        return;
    }

    public void startAnimation() {
        AnimatedDrawable2 r0 = this.mAnimatedDrawable;
        if (r0 == null) goto L6;
        r0.start();
        this.mLoopCount = this.mAnimatedDrawable.getLoopCount();
        this.mCurrentFrame = 0;
        drawFrameInternal();
        return;
    }

    public void stopAnimation() {
        AnimatedDrawable2 r0 = this.mAnimatedDrawable;
        if (r0 == null) goto L6;
        r0.stop();
        return;
    }

    public int getDuration() {
        return this.mDuration;
    }

    public Bitmap toBitmap() {
        return this.mFrameBitmap;
    }

    public FrescoImage(CloseableReference<CloseableImage> r3) {
        this.mAutoPlay = true;
        this.mDuration = 0;
        this.mLoopCount = 0;
        this.mCurrentFrame = 0;
        this.imageSource = r3;
        if ((r3.get() instanceof CloseableBitmap) == false) goto L6;
        this.mFrameBitmap = ((CloseableBitmap) r3.get()).getUnderlyingBitmap();
        return;
    L6:
        if ((r3.get() instanceof CloseableAnimatedImage) == false) goto L12;
        CloseableAnimatedImage r4 = (CloseableAnimatedImage) r3.get();
        AnimatedDrawable2 r5 = ImagePipelineFactory.getInstance().getAnimatedFactory().getAnimatedDrawableFactory(ImageLoader.getInstance().getContext()).createDrawable((CloseableImage) this.imageSource.get());
        this.mAnimatedDrawable = r5;
        if (r5.getFrameCount() <= 0) goto L13;
        this.mFrameBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
        this.mCanvas = new Canvas(this.mFrameBitmap);
        return;
    L13:
        return;
    }

    public static FrescoImage create(CloseableReference<CloseableImage> r1) {
        return new FrescoImage(r1);
    }

    public void setAutoPlay(boolean r1) {
        this.mAutoPlay = r1;
        if (r1 == false) goto L5;
        startAnimation();
        return;
    L5:
        stopAnimation();
    }

    public void setLoopCount(int r2) {
        AnimatedDrawable2 r0 = this.mAnimatedDrawable;
        if (r0 == null) goto L6;
        r0.setLoopCount(r2);
        this.mLoopCount = this.mAnimatedDrawable.getLoopCount();
        return;
    }
}
