package com.google.android.material.ripple;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import androidx.core.graphics.drawable.TintAwareDrawable;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.l;
import com.google.android.material.shape.p;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public class RippleDrawableCompat extends Drawable implements TintAwareDrawable, p {
    private a drawableState;

    /* JADX INFO: renamed from: com.google.android.material.ripple.RippleDrawableCompat$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    static final class a extends Drawable.ConstantState {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        MaterialShapeDrawable f4031a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        boolean f4032b;

        public a(a r4) {
            this.f4031a = (MaterialShapeDrawable) ZeusTransformUtils.preCheckCast(r4.f4031a.getConstantState().newDrawable(), MaterialShapeDrawable.class, "com.obric.memorydata.plugin");
            this.f4032b = r4.f4032b;
        }

        public a(MaterialShapeDrawable r1) {
            this.f4031a = r1;
            this.f4032b = false;
        }

        public RippleDrawableCompat a() {
            return new RippleDrawableCompat(new a(this), null);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public /* synthetic */ Drawable newDrawable() {
            return a();
        }
    }

    private RippleDrawableCompat(a r1) {
        this.drawableState = r1;
    }

    /* synthetic */ RippleDrawableCompat(a r1, AnonymousClass1 r2) {
        this(r1);
    }

    public RippleDrawableCompat(l r3) {
        this(new a(new MaterialShapeDrawable(r3)));
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas r2) {
        if (this.drawableState.f4032b == false) goto L6;
        this.drawableState.f4031a.draw(r2);
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.drawableState;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.drawableState.f4031a.getOpacity();
    }

    @Override // com.google.android.material.shape.p
    public l getShapeAppearanceModel() {
        return this.drawableState.f4031a.getShapeAppearanceModel();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ Drawable mutate() {
        return mutate();
    }

    @Override // android.graphics.drawable.Drawable
    public RippleDrawableCompat mutate() {
        this.drawableState = new a(this.drawableState);
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect r1) {
        super.onBoundsChange(r1);
        this.drawableState.f4031a.setBounds(r1);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] r4) {
        boolean r0 = super.onStateChange(r4);
        if (this.drawableState.f4031a.setState(r4) == false) goto L5;
        r0 = true;
    L5:
        boolean r5 = com.google.android.material.ripple.a.a(r4);
        if (this.drawableState.f4032b == r5) goto L9;
        this.drawableState.f4032b = r5;
        return true;
    L9:
        return r0;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int r1) {
        this.drawableState.f4031a.setAlpha(r1);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter r1) {
        this.drawableState.f4031a.setColorFilter(r1);
    }

    @Override // com.google.android.material.shape.p
    public void setShapeAppearanceModel(l r1) {
        this.drawableState.f4031a.setShapeAppearanceModel(r1);
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTint(int r1) {
        this.drawableState.f4031a.setTint(r1);
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTintList(ColorStateList r1) {
        this.drawableState.f4031a.setTintList(r1);
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTintMode(PorterDuff.Mode r1) {
        this.drawableState.f4031a.setTintMode(r1);
    }
}
