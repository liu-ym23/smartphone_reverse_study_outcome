package com.bumptech.glide.load.resource.gif;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import com.bumptech.glide.util.j;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class GifDrawable extends Drawable implements Animatable, Animatable2Compat, f.b {
    private static final int GRAVITY = 119;
    public static final int LOOP_FOREVER = -1;
    public static final int LOOP_INTRINSIC = 0;
    private List<Animatable2Compat.AnimationCallback> animationCallbacks;
    private boolean applyGravity;
    private Rect destRect;
    private boolean isRecycled;
    private boolean isRunning;
    private boolean isStarted;
    private boolean isVisible;
    private int loopCount;
    private int maxLoopCount;
    private Paint paint;
    private final a state;

    static final class a extends Drawable.ConstantState {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final f f897a;

        a(f r1) {
            this.f897a = r1;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new GifDrawable(this);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources r1) {
            return newDrawable();
        }
    }

    @Deprecated
    public GifDrawable(Context r10, com.bumptech.glide.b.a r11, com.bumptech.glide.load.engine.bitmap_recycle.e r12, com.bumptech.glide.load.h<Bitmap> r13, int r14, int r15, Bitmap r16) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.memorydata.plugin");
        com.bumptech.glide.b.a r4 = (com.bumptech.glide.b.a) ZeusTransformUtils.wrapperContextForParams(r11, com.bumptech.glide.b.a.class, "com.obric.memorydata.plugin");
        com.bumptech.glide.load.engine.bitmap_recycle.e r0 = (com.bumptech.glide.load.engine.bitmap_recycle.e) ZeusTransformUtils.wrapperContextForParams(r12, com.bumptech.glide.load.engine.bitmap_recycle.e.class, "com.obric.memorydata.plugin");
        this(r3, r4, (com.bumptech.glide.load.h) ZeusTransformUtils.wrapperContextForParams(r13, com.bumptech.glide.load.h.class, "com.obric.memorydata.plugin"), r14, r15, r16);
    }

    public GifDrawable(Context r10, com.bumptech.glide.b.a r11, com.bumptech.glide.load.h<Bitmap> r12, int r13, int r14, Bitmap r15) {
        Context r16 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.memorydata.plugin");
        com.bumptech.glide.b.a r4 = (com.bumptech.glide.b.a) ZeusTransformUtils.wrapperContextForParams(r11, com.bumptech.glide.b.a.class, "com.obric.memorydata.plugin");
        com.bumptech.glide.load.h r7 = (com.bumptech.glide.load.h) ZeusTransformUtils.wrapperContextForParams(r12, com.bumptech.glide.load.h.class, "com.obric.memorydata.plugin");
        this(new a(new f(com.bumptech.glide.c.a(r16), r4, r13, r14, r7, r15)));
    }

    GifDrawable(a r3) {
        this.isVisible = true;
        this.maxLoopCount = -1;
        this.state = (a) ZeusTransformUtils.preCheckCast(j.a(r3), a.class, "com.obric.memorydata.plugin");
    }

    GifDrawable(f r2, Paint r3) {
        this(new a(r2));
        this.paint = r3;
    }

    private Drawable.Callback findCallback() {
        Drawable.Callback r2 = getCallback();
    L4:
        if (ZeusTransformUtils.instanceOf(r2, Drawable.class) == false) goto L6;
        r2 = ((Drawable) ZeusTransformUtils.preCheckCast(r2, Drawable.class, "com.obric.memorydata.plugin")).getCallback();
        goto L4
    L6:
        return r2;
    }

    private Rect getDestRect() {
        if (this.destRect != null) goto L6;
        this.destRect = new Rect();
    L6:
        return this.destRect;
    }

    private Paint getPaint() {
        if (this.paint != null) goto L6;
        this.paint = new Paint(2);
    L6:
        return this.paint;
    }

    private void notifyAnimationEndToListeners() {
        List<Animatable2Compat.AnimationCallback> r0 = this.animationCallbacks;
        if (r0 == null) goto L7;
        int r1 = 0;
        int r2 = r0.size();
    L5:
        if (r1 >= r2) goto L9;
        ((Animatable2Compat.AnimationCallback) ZeusTransformUtils.preCheckCast(this.animationCallbacks.get(r1), Animatable2Compat.AnimationCallback.class, "com.obric.memorydata.plugin")).onAnimationEnd(this);
        r1 = r1 + 1;
        goto L5
    L9:
        return;
    }

    private void resetLoopCount() {
        this.loopCount = 0;
    }

    private void startRunning() {
        j.a(!this.isRecycled, "You cannot start a recycled Drawable. Ensure thatyou clear any references to the Drawable when clearing the corresponding request.");
        if (this.state.f897a.h() != 1) goto L6;
    L4:
        invalidateSelf();
        return;
    L6:
        if (this.isRunning == true) goto L9;
        this.isRunning = true;
        this.state.f897a.a(this);
        goto L4
    }

    private void stopRunning() {
        this.isRunning = false;
        this.state.f897a.b(this);
    }

    @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public void clearAnimationCallbacks() {
        List<Animatable2Compat.AnimationCallback> r0 = this.animationCallbacks;
        if (r0 == null) goto L6;
        r0.clear();
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas r6) {
        if (this.isRecycled == false) goto L6;
        return;
    L6:
        if (this.applyGravity == false) goto L8;
        Gravity.apply(119, getIntrinsicWidth(), getIntrinsicHeight(), getBounds(), getDestRect());
        this.applyGravity = false;
    L8:
        r6.drawBitmap(this.state.f897a.k(), null, getDestRect(), getPaint());
    }

    public ByteBuffer getBuffer() {
        return this.state.f897a.g();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.state;
    }

    public Bitmap getFirstFrame() {
        return this.state.f897a.b();
    }

    public int getFrameCount() {
        return this.state.f897a.h();
    }

    public int getFrameIndex() {
        return this.state.f897a.f();
    }

    public com.bumptech.glide.load.h<Bitmap> getFrameTransformation() {
        return this.state.f897a.a();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.state.f897a.d();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.state.f897a.c();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -2;
    }

    public int getSize() {
        return this.state.f897a.e();
    }

    boolean isRecycled() {
        return this.isRecycled;
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.isRunning;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect r1) {
        super.onBoundsChange(r1);
        this.applyGravity = true;
    }

    @Override // com.bumptech.glide.load.resource.gif.f.b
    public void onFrameReady() {
        if (findCallback() != null) goto L6;
        stop();
        invalidateSelf();
        return;
    L6:
        invalidateSelf();
        if (getFrameIndex() != (getFrameCount() - 1)) goto L9;
        this.loopCount++;
    L9:
        int r0 = this.maxLoopCount;
        if (r0 != (-1)) goto L12;
        return;
    L12:
        if (this.loopCount < r0) goto L16;
        notifyAnimationEndToListeners();
        stop();
        return;
    }

    public void recycle() {
        this.isRecycled = true;
        this.state.f897a.j();
    }

    @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public void registerAnimationCallback(Animatable2Compat.AnimationCallback r2) {
        if (r2 != null) goto L5;
        return;
    L5:
        if (this.animationCallbacks != null) goto L7;
        this.animationCallbacks = new ArrayList();
    L7:
        this.animationCallbacks.add(r2);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int r1) {
        getPaint().setAlpha(r1);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter r1) {
        getPaint().setColorFilter(r1);
    }

    public void setFrameTransformation(com.bumptech.glide.load.h<Bitmap> r3, Bitmap r4) {
        com.bumptech.glide.load.h<Bitmap> r5 = (com.bumptech.glide.load.h) ZeusTransformUtils.wrapperContextForParams(r3, com.bumptech.glide.load.h.class, "com.obric.memorydata.plugin");
        this.state.f897a.a(r5, r4);
    }

    void setIsRunning(boolean r1) {
        this.isRunning = r1;
    }

    public void setLoopCount(int r2) {
        int r0 = -1;
        if (r2 > 0) goto L9;
        if (r2 == (-1)) goto L9;
        if (r2 == 0) goto L9;
        throw new IllegalArgumentException("Loop count must be greater than 0, or equal to GlideDrawable.LOOP_FOREVER, or equal to GlideDrawable.LOOP_INTRINSIC");
    L9:
        if (r2 != 0) goto L15;
        int r3 = this.state.f897a.i();
        if (r3 == 0) goto L14;
        r0 = r3;
    L14:
        this.maxLoopCount = r0;
        return;
    L15:
        this.maxLoopCount = r2;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean r3, boolean r4) {
        j.a(!this.isRecycled, "Cannot change the visibility of a recycled resource. Ensure that you unset the Drawable from your View before changing the View's visibility.");
        this.isVisible = r3;
        if (r3 == true) goto L6;
        stopRunning();
    L9:
        return super.setVisible(r3, r4);
    L6:
        if (this.isStarted == false) goto L9;
        startRunning();
        goto L9
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        this.isStarted = true;
        resetLoopCount();
        if (this.isVisible == false) goto L6;
        startRunning();
        return;
    }

    public void startFromFirstFrame() {
        j.a(!this.isRunning, "You cannot restart a currently running animation.");
        this.state.f897a.l();
        start();
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        this.isStarted = false;
        stopRunning();
    }

    @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public boolean unregisterAnimationCallback(Animatable2Compat.AnimationCallback r1) {
        List<Animatable2Compat.AnimationCallback> r0 = this.animationCallbacks;
        if (r0 == null) goto L8;
        if (r1 != null) goto L7;
        return false;
    L7:
        return r0.remove(r1);
    L8:
        return false;
    }
}
