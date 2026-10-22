package com.google.android.material.ripple;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.graphics.drawable.TintAwareDrawable;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.Shapeable;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class RippleDrawableCompat extends Drawable implements Shapeable, TintAwareDrawable {
    private RippleDrawableCompatState drawableState;

    /* JADX INFO: renamed from: com.google.android.material.ripple.RippleDrawableCompat$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static final class RippleDrawableCompatState extends Drawable.ConstantState {

        @NonNull
        MaterialShapeDrawable delegate;
        boolean shouldDrawDelegate;

        public RippleDrawableCompatState(MaterialShapeDrawable r5) {
            this.delegate = r5;
            this.shouldDrawDelegate = false;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @NonNull
        public /* bridge */ /* synthetic */ Drawable newDrawable() {
            return newDrawable();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @NonNull
        public RippleDrawableCompat newDrawable() {
            return new RippleDrawableCompat(new RippleDrawableCompatState(this), null);
        }

        public RippleDrawableCompatState(@NonNull RippleDrawableCompatState r5) {
            this.delegate = (MaterialShapeDrawable) r5.delegate.getConstantState().newDrawable();
            this.shouldDrawDelegate = r5.shouldDrawDelegate;
        }
    }

    public /* synthetic */ RippleDrawableCompat(RippleDrawableCompatState r5, AnonymousClass1 r10) {
        this(r5);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas r5) {
        RippleDrawableCompatState r10 = this.drawableState;
        if (r10.shouldDrawDelegate == false) goto L6;
        r10.delegate.draw(r5);
        return;
    }

    @Override // android.graphics.drawable.Drawable
    @Nullable
    public Drawable.ConstantState getConstantState() {
        return this.drawableState;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.drawableState.delegate.getOpacity();
    }

    @Override // com.google.android.material.shape.Shapeable
    @NonNull
    public ShapeAppearanceModel getShapeAppearanceModel() {
        return this.drawableState.delegate.getShapeAppearanceModel();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    @NonNull
    public /* bridge */ /* synthetic */ Drawable mutate() {
        return mutate();
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(@NonNull Rect r5) {
        super.onBoundsChange(r5);
        this.drawableState.delegate.setBounds(r5);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(@NonNull int[] r5) {
        boolean r10 = super.onStateChange(r5);
        if (this.drawableState.delegate.setState(r5) == false) goto L5;
        r10 = true;
    L5:
        boolean r11 = RippleUtils.shouldDrawRippleCompat(r5);
        RippleDrawableCompatState r12 = this.drawableState;
        if (r12.shouldDrawDelegate == r11) goto L9;
        r12.shouldDrawDelegate = r11;
        return true;
    L9:
        return r10;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int r5) {
        this.drawableState.delegate.setAlpha(r5);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter r5) {
        this.drawableState.delegate.setColorFilter(r5);
    }

    @Override // com.google.android.material.shape.Shapeable
    public void setShapeAppearanceModel(@NonNull ShapeAppearanceModel r5) {
        this.drawableState.delegate.setShapeAppearanceModel(r5);
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTint(@ColorInt int r5) {
        this.drawableState.delegate.setTint(r5);
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTintList(@Nullable ColorStateList r5) {
        this.drawableState.delegate.setTintList(r5);
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTintMode(@Nullable PorterDuff.Mode r5) {
        this.drawableState.delegate.setTintMode(r5);
    }

    public RippleDrawableCompat(ShapeAppearanceModel r5) {
        this(new RippleDrawableCompatState(new MaterialShapeDrawable(r5)));
    }

    @Override // android.graphics.drawable.Drawable
    @NonNull
    public RippleDrawableCompat mutate() {
        this.drawableState = new RippleDrawableCompatState(this.drawableState);
        return this;
    }

    private RippleDrawableCompat(RippleDrawableCompatState r5) {
        this.drawableState = r5;
    }
}
