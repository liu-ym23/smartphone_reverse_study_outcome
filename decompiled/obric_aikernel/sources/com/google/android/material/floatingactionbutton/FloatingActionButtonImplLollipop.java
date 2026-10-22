package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;
import androidx.core.util.Preconditions;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.l;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(21)
class FloatingActionButtonImplLollipop extends d {

    static class AlwaysStatefulMaterialShapeDrawable extends MaterialShapeDrawable {
        AlwaysStatefulMaterialShapeDrawable(l r10) {
            super(r10);
        }

        @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
        public boolean isStateful() {
            return true;
        }
    }

    FloatingActionButtonImplLollipop(FloatingActionButton r10, a6.b r11) {
        super(r10, r11);
    }

    @NonNull
    private Animator m0(float r10, float r11) {
        AnimatorSet r12 = new AnimatorSet();
        r12.play(ObjectAnimator.ofFloat(this.f3303w, "elevation", new float[]{r10}).setDuration(0)).with(ObjectAnimator.ofFloat(this.f3303w, View.TRANSLATION_Z, new float[]{r11}).setDuration(100));
        r12.setInterpolator(d.D);
        return r12;
    }

    @Override // com.google.android.material.floatingactionbutton.d
    void A() {
    }

    @Override // com.google.android.material.floatingactionbutton.d
    void C() {
        i0();
    }

    @Override // com.google.android.material.floatingactionbutton.d
    void E(int[] r10) {
        if (Build.VERSION.SDK_INT == 21) goto L5;
        return;
    L5:
        if (this.f3303w.isEnabled() == false) goto L15;
        this.f3303w.setElevation(this.f3288h);
        if (this.f3303w.isPressed() == false) goto L11;
        FloatingActionButton r11 = this.f3303w;
        float r12 = this.f3290j;
    L9:
        r11.setTranslationZ(r12);
        return;
    L11:
        if (this.f3303w.isFocused() == false) goto L13;
    L14:
        r11 = this.f3303w;
        r12 = this.f3289i;
        goto L9
    L13:
        if (this.f3303w.isHovered() == true) goto L14;
    L16:
        this.f3303w.setTranslationZ(0.0f);
        return;
    L15:
        this.f3303w.setElevation(0.0f);
        goto L16
    }

    @Override // com.google.android.material.floatingactionbutton.d
    void F(float r10, float r11, float r12) {
        int r13 = Build.VERSION.SDK_INT;
        if (r13 != 21) goto L5;
        this.f3303w.refreshDrawableState();
    L12:
        if (c0() == false) goto L15;
        i0();
        return;
    L15:
        return;
    L5:
        StateListAnimator r14 = new StateListAnimator();
        r14.addState(d.E, m0(r10, r12));
        r14.addState(d.F, m0(r10, r11));
        r14.addState(d.G, m0(r10, r11));
        r14.addState(d.H, m0(r10, r11));
        AnimatorSet r15 = new AnimatorSet();
        ArrayList r16 = new ArrayList();
        r16.add(ObjectAnimator.ofFloat(this.f3303w, "elevation", new float[]{r10}).setDuration(0));
        if (r13 >= 22) goto L8;
    L10:
        r16.add(ObjectAnimator.ofFloat(this.f3303w, View.TRANSLATION_Z, new float[]{0.0f}).setDuration(100));
        r15.playSequentially((Animator[]) r16.toArray(new Animator[0]));
        r15.setInterpolator(d.D);
        r14.addState(d.I, r15);
        r14.addState(d.f3280J, m0(0.0f, 0.0f));
        this.f3303w.setStateListAnimator(r14);
        goto L12
    L8:
        if (r13 > 24) goto L10;
        FloatingActionButton r17 = this.f3303w;
        r16.add(ObjectAnimator.ofFloat(r17, View.TRANSLATION_Z, new float[]{r17.getTranslationZ()}).setDuration(100));
        goto L10
    }

    @Override // com.google.android.material.floatingactionbutton.d
    boolean N() {
        return false;
    }

    @Override // com.google.android.material.floatingactionbutton.d
    void Y(@Nullable ColorStateList r10) {
        Drawable r11 = this.f3283c;
        if ((r11 instanceof RippleDrawable) == false) goto L5;
        ((RippleDrawable) r11).setColor(com.google.android.material.ripple.a.d(r10));
        return;
    L5:
        super.Y(r10);
    }

    @Override // com.google.android.material.floatingactionbutton.d
    boolean c0() {
        if (this.f3304x.a() == false) goto L5;
    L8:
        return true;
    L5:
        if (e0() == false) goto L8;
        return false;
    }

    @Override // com.google.android.material.floatingactionbutton.d
    void g0() {
    }

    @Override // com.google.android.material.floatingactionbutton.d
    @NonNull
    MaterialShapeDrawable l() {
        return new AlwaysStatefulMaterialShapeDrawable((l) Preconditions.checkNotNull(this.f3281a));
    }

    @NonNull
    c l0(int r10, ColorStateList r11) {
        Context r12 = this.f3303w.getContext();
        c r13 = new c((l) Preconditions.checkNotNull(this.f3281a));
        r13.e(ContextCompat.getColor(r12, q5.c.design_fab_stroke_top_outer_color), ContextCompat.getColor(r12, q5.c.design_fab_stroke_top_inner_color), ContextCompat.getColor(r12, q5.c.design_fab_stroke_end_inner_color), ContextCompat.getColor(r12, q5.c.design_fab_stroke_end_outer_color));
        r13.d(r10);
        r13.c(r11);
        return r13;
    }

    @Override // com.google.android.material.floatingactionbutton.d
    public float n() {
        return this.f3303w.getElevation();
    }

    @Override // com.google.android.material.floatingactionbutton.d
    void s(@NonNull Rect r10) {
        if (this.f3304x.a() == false) goto L6;
        super.s(r10);
        return;
    L6:
        if (e0() == true) goto L8;
        int r11 = (this.f3291k - this.f3303w.getSizeDimension()) / 2;
        r10.set(r11, r11, r11, r11);
        return;
    L8:
        r10.set(0, 0, 0, 0);
    }

    @Override // com.google.android.material.floatingactionbutton.d
    void x(ColorStateList r10, @Nullable PorterDuff.Mode r11, ColorStateList r12, int r13) {
        MaterialShapeDrawable r14 = l();
        this.f3282b = r14;
        r14.setTintList(r10);
        if (r11 == null) goto L5;
        this.f3282b.setTintMode(r11);
    L5:
        this.f3282b.initializeElevationOverlay(this.f3303w.getContext());
        if (r13 <= 0) goto L8;
        this.f3284d = l0(r13, r10);
        Drawable r15 = new LayerDrawable(new Drawable[]{(Drawable) Preconditions.checkNotNull(this.f3284d), (Drawable) Preconditions.checkNotNull(this.f3282b)});
    L9:
        RippleDrawable r16 = new RippleDrawable(com.google.android.material.ripple.a.d(r12), r15, null);
        this.f3283c = r16;
        this.f3285e = r16;
        return;
    L8:
        this.f3284d = null;
        r15 = this.f3282b;
        goto L9
    }
}
