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
import com.google.android.material.shape.l;
import com.google.android.material.shape.p;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class RippleDrawableCompat extends Drawable implements p, TintAwareDrawable {
    private b drawableState;

    static /* synthetic */ class a {
    }

    static final class b extends Drawable.ConstantState {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NonNull
        MaterialShapeDrawable f3597a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        boolean f3598b;

        public b(@NonNull b r10) {
            this.f3597a = (MaterialShapeDrawable) r10.f3597a.getConstantState().newDrawable();
            this.f3598b = r10.f3598b;
        }

        public b(MaterialShapeDrawable r10) {
            this.f3597a = r10;
            this.f3598b = false;
        }

        @NonNull
        public RippleDrawableCompat a() {
            return new RippleDrawableCompat(new b(this), null);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @NonNull
        public /* bridge */ /* synthetic */ Drawable newDrawable() {
            return a();
        }
    }

    private RippleDrawableCompat(b r10) {
        this.drawableState = r10;
    }

    /* synthetic */ RippleDrawableCompat(b r10, a r11) {
        this(r10);
    }

    public RippleDrawableCompat(l r10) {
        this(new b(new MaterialShapeDrawable(r10)));
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas r10) {
        b r11 = this.drawableState;
        if (r11.f3598b == false) goto L6;
        r11.f3597a.draw(r10);
        return;
    }

    @Override // android.graphics.drawable.Drawable
    @Nullable
    public Drawable.ConstantState getConstantState() {
        return this.drawableState;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.drawableState.f3597a.getOpacity();
    }

    @Override // com.google.android.material.shape.p
    @NonNull
    public l getShapeAppearanceModel() {
        return this.drawableState.f3597a.getShapeAppearanceModel();
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
    @NonNull
    public RippleDrawableCompat mutate() {
        this.drawableState = new b(this.drawableState);
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(@NonNull Rect r10) {
        super.onBoundsChange(r10);
        this.drawableState.f3597a.setBounds(r10);
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(@NonNull int[] r10) {
        boolean r11 = super.onStateChange(r10);
        if (this.drawableState.f3597a.setState(r10) == false) goto L5;
        r11 = true;
    L5:
        boolean r12 = com.google.android.material.ripple.a.e(r10);
        b r13 = this.drawableState;
        if (r13.f3598b == r12) goto L9;
        r13.f3598b = r12;
        return true;
    L9:
        return r11;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int r10) {
        this.drawableState.f3597a.setAlpha(r10);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter r10) {
        this.drawableState.f3597a.setColorFilter(r10);
    }

    @Override // com.google.android.material.shape.p
    public void setShapeAppearanceModel(@NonNull l r10) {
        this.drawableState.f3597a.setShapeAppearanceModel(r10);
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTint(@ColorInt int r10) {
        this.drawableState.f3597a.setTint(r10);
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTintList(@Nullable ColorStateList r10) {
        this.drawableState.f3597a.setTintList(r10);
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTintMode(@Nullable PorterDuff.Mode r10) {
        this.drawableState.f3597a.setTintMode(r10);
    }
}
