package com.bumptech.glide.load.resource.gif;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import java.nio.ByteBuffer;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class GifDrawable extends Drawable implements f, Animatable, Animatable2Compat {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final GifState f1643a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f1644b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f1645c;
    public boolean d;
    public boolean e;
    public int f;
    public final int g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f1646h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Paint f1647i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Rect f1648j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ArrayList f1649k;

    public static final class GifState extends Drawable.ConstantState {

        @VisibleForTesting
        final GifFrameLoader frameLoader;

        public GifState(GifFrameLoader r5) {
            this.frameLoader = r5;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @NonNull
        public Drawable newDrawable(Resources r5) {
            return newDrawable();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @NonNull
        public Drawable newDrawable() {
            return new GifDrawable(this);
        }
    }

    public GifDrawable(GifState r5) {
        this.e = true;
        this.g = -1;
        io.reactivex.internal.observers.h.h(r5, "Argument must not be null");
        this.f1643a = r5;
    }

    public final ByteBuffer a() {
        return this.f1643a.frameLoader.getBuffer();
    }

    public final Bitmap b() {
        return this.f1643a.frameLoader.getFirstFrame();
    }

    public final void c() {
        io.reactivex.internal.observers.h.f("You cannot start a recycled Drawable. Ensure thatyou clear any references to the Drawable when clearing the corresponding request.", !this.d);
        GifState r5 = this.f1643a;
        if (r5.frameLoader.getFrameCount() != 1) goto L6;
        invalidateSelf();
        return;
    L6:
        if (this.f1644b == true) goto L10;
        this.f1644b = true;
        r5.frameLoader.subscribe(this);
        invalidateSelf();
        return;
    }

    @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public final void clearAnimationCallbacks() {
        ArrayList r5 = this.f1649k;
        if (r5 == null) goto L6;
        r5.clear();
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas r10) {
        if (this.d == false) goto L6;
        return;
    L6:
        if (this.f1646h == false) goto L11;
        int r5 = getIntrinsicWidth();
        int r11 = getIntrinsicHeight();
        Rect r12 = getBounds();
        if (this.f1648j != null) goto L10;
        this.f1648j = new Rect();
    L10:
        Gravity.apply(119, r5, r11, r12, this.f1648j);
        this.f1646h = false;
    L11:
        Bitmap r13 = this.f1643a.frameLoader.getCurrentFrame();
        if (this.f1648j != null) goto L14;
        this.f1648j = new Rect();
    L14:
        Rect r14 = this.f1648j;
        if (this.f1647i != null) goto L17;
        this.f1647i = new Paint(2);
    L17:
        r10.drawBitmap(r13, null, r14, this.f1647i);
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable.ConstantState getConstantState() {
        return this.f1643a;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return this.f1643a.frameLoader.getHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        return this.f1643a.frameLoader.getWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -2;
    }

    @Override // android.graphics.drawable.Animatable
    public final boolean isRunning() {
        return this.f1644b;
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect r5) {
        super.onBoundsChange(r5);
        this.f1646h = true;
    }

    @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public final void registerAnimationCallback(Animatable2Compat.AnimationCallback r5) {
        if (r5 != null) goto L5;
        return;
    L5:
        if (this.f1649k != null) goto L7;
        this.f1649k = new ArrayList();
    L7:
        this.f1649k.add(r5);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int r5) {
        if (this.f1647i != null) goto L5;
        this.f1647i = new Paint(2);
    L5:
        this.f1647i.setAlpha(r5);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter r5) {
        if (this.f1647i != null) goto L5;
        this.f1647i = new Paint(2);
    L5:
        this.f1647i.setColorFilter(r5);
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean setVisible(boolean r5, boolean r10) {
        io.reactivex.internal.observers.h.f("Cannot change the visibility of a recycled resource. Ensure that you unset the Drawable from your View before changing the View's visibility.", !this.d);
        this.e = r5;
        if (r5 == true) goto L6;
        this.f1644b = false;
        this.f1643a.frameLoader.unsubscribe(this);
    L9:
        return super.setVisible(r5, r10);
    L6:
        if (this.f1645c == false) goto L9;
        c();
        goto L9
    }

    @Override // android.graphics.drawable.Animatable
    public final void start() {
        this.f1645c = true;
        this.f = 0;
        if (this.e == false) goto L6;
        c();
        return;
    }

    @Override // android.graphics.drawable.Animatable
    public final void stop() {
        this.f1645c = false;
        this.f1644b = false;
        this.f1643a.frameLoader.unsubscribe(this);
    }

    @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public final boolean unregisterAnimationCallback(Animatable2Compat.AnimationCallback r5) {
        ArrayList r10 = this.f1649k;
        if (r10 == null) goto L8;
        if (r5 != null) goto L7;
        return false;
    L7:
        return r10.remove(r5);
    L8:
        return false;
    }
}
