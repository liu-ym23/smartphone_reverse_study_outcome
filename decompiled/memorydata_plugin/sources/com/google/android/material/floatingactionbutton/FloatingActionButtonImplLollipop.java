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
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.content.ContextCompat;
import androidx.core.util.Preconditions;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.l;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
class FloatingActionButtonImplLollipop extends d {

    static class AlwaysStatefulMaterialShapeDrawable extends MaterialShapeDrawable {
        AlwaysStatefulMaterialShapeDrawable(l r1) {
            super(r1);
        }

        @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
        public boolean isStateful() {
            return true;
        }
    }

    FloatingActionButtonImplLollipop(FloatingActionButton r3, com.google.android.material.h.b r4) {
        super(r3, (com.google.android.material.h.b) ZeusTransformUtils.wrapperContextForParams(r4, com.google.android.material.h.b.class, "com.obric.memorydata.plugin"));
    }

    private Animator a(float r8, float r9) {
        AnimatorSet r0 = new AnimatorSet();
        r0.play(ObjectAnimator.ofFloat(this.s, "elevation", new float[]{r8}).setDuration(0)).with(ObjectAnimator.ofFloat(this.s, View.TRANSLATION_Z, new float[]{r9}).setDuration(100));
        r0.setInterpolator(f3925a);
        return r0;
    }

    @Override // com.google.android.material.floatingactionbutton.d
    public float a() {
        return this.s.getElevation();
    }

    c a(int r8, ColorStateList r9) {
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.s.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        c r2 = new c((l) ZeusTransformUtils.preCheckCast(Preconditions.checkNotNull(this.f3927b), l.class, "com.obric.memorydata.plugin"));
        r2.a(ContextCompat.getColor(r0, ZeusTransformUtils.mapRes(R.color.design_fab_stroke_top_outer_color, TypedValues.Custom.S_COLOR, "design_fab_stroke_top_outer_color")), ContextCompat.getColor(r0, ZeusTransformUtils.mapRes(R.color.design_fab_stroke_top_inner_color, TypedValues.Custom.S_COLOR, "design_fab_stroke_top_inner_color")), ContextCompat.getColor(r0, ZeusTransformUtils.mapRes(R.color.design_fab_stroke_end_inner_color, TypedValues.Custom.S_COLOR, "design_fab_stroke_end_inner_color")), ContextCompat.getColor(r0, ZeusTransformUtils.mapRes(R.color.design_fab_stroke_end_outer_color, TypedValues.Custom.S_COLOR, "design_fab_stroke_end_outer_color")));
        r2.a(r8);
        r2.a(r9);
        return r2;
    }

    @Override // com.google.android.material.floatingactionbutton.d
    void a(float r9, float r10, float r11) {
        if (Build.VERSION.SDK_INT != 21) goto L5;
        this.s.refreshDrawableState();
    L12:
        if (p() == false) goto L15;
        o();
        return;
    L15:
        return;
    L5:
        StateListAnimator r0 = new StateListAnimator();
        r0.addState(m, a(r9, r11));
        r0.addState(n, a(r9, r10));
        r0.addState(o, a(r9, r10));
        r0.addState(p, a(r9, r10));
        AnimatorSet r12 = new AnimatorSet();
        ArrayList r13 = new ArrayList();
        r13.add(ObjectAnimator.ofFloat(this.s, "elevation", new float[]{r9}).setDuration(0));
        if (Build.VERSION.SDK_INT >= 22) goto L8;
    L10:
        r13.add(ObjectAnimator.ofFloat(this.s, View.TRANSLATION_Z, new float[]{0.0f}).setDuration(100));
        r12.playSequentially((Animator[]) ZeusTransformUtils.preCheckCast(r13.toArray(new Animator[0]), Animator[].class, "com.obric.memorydata.plugin"));
        r12.setInterpolator(f3925a);
        r0.addState(q, r12);
        r0.addState(r, a(0.0f, 0.0f));
        this.s.setStateListAnimator(r0);
        goto L12
    L8:
        if (Build.VERSION.SDK_INT > 24) goto L10;
        r13.add(ObjectAnimator.ofFloat(this.s, View.TRANSLATION_Z, new float[]{this.s.getTranslationZ()}).setDuration(100));
        goto L10
    }

    @Override // com.google.android.material.floatingactionbutton.d
    void a(ColorStateList r5, PorterDuff.Mode r6, ColorStateList r7, int r8) {
        this.c = u();
        this.c.setTintList(r5);
        if (r6 == null) goto L5;
        this.c.setTintMode(r6);
    L5:
        this.c.initializeElevationOverlay((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.s.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
        if (r8 <= 0) goto L8;
        this.e = a(r8, r5);
        Drawable r9 = new LayerDrawable(new Drawable[]{(Drawable) ZeusTransformUtils.preCheckCast(Preconditions.checkNotNull(this.e), Drawable.class, "com.obric.memorydata.plugin"), (Drawable) ZeusTransformUtils.preCheckCast(Preconditions.checkNotNull(this.c), Drawable.class, "com.obric.memorydata.plugin")});
    L9:
        this.d = new RippleDrawable(com.google.android.material.ripple.a.b(r7), r9, null);
        this.f = this.d;
        return;
    L8:
        this.e = null;
        r9 = this.c;
        goto L9
    }

    @Override // com.google.android.material.floatingactionbutton.d
    void a(Rect r2) {
        if (this.t.a() == false) goto L6;
        super.a(r2);
        return;
    L6:
        if (h() == true) goto L8;
        int r0 = (this.l - this.s.getSizeDimension()) / 2;
        r2.set(r0, r0, r0, r0);
        return;
    L8:
        r2.set(0, 0, 0, 0);
    }

    @Override // com.google.android.material.floatingactionbutton.d
    void a(int[] r3) {
        if (Build.VERSION.SDK_INT == 21) goto L5;
        return;
    L5:
        if (this.s.isEnabled() == false) goto L15;
        this.s.setElevation(this.i);
        if (this.s.isPressed() == false) goto L11;
        FloatingActionButton r4 = this.s;
        float r2 = this.k;
    L9:
        r4.setTranslationZ(r2);
        return;
    L11:
        if (this.s.isFocused() == false) goto L13;
    L14:
        r4 = this.s;
        r2 = this.j;
        goto L9
    L13:
        if (this.s.isHovered() == true) goto L14;
    L16:
        this.s.setTranslationZ(0.0f);
        return;
    L15:
        this.s.setElevation(0.0f);
        goto L16
    }

    @Override // com.google.android.material.floatingactionbutton.d
    void b(ColorStateList r3) {
        if (ZeusTransformUtils.instanceOf(this.d, RippleDrawable.class) == false) goto L5;
        ((RippleDrawable) ZeusTransformUtils.preCheckCast(this.d, RippleDrawable.class, "com.obric.memorydata.plugin")).setColor(com.google.android.material.ripple.a.b(r3));
        return;
    L5:
        super.b(r3);
    }

    @Override // com.google.android.material.floatingactionbutton.d
    void j() {
    }

    @Override // com.google.android.material.floatingactionbutton.d
    void n() {
        o();
    }

    @Override // com.google.android.material.floatingactionbutton.d
    boolean p() {
        if (this.t.a() == false) goto L5;
    L8:
        return true;
    L5:
        if (h() == false) goto L8;
        return false;
    }

    @Override // com.google.android.material.floatingactionbutton.d
    boolean s() {
        return false;
    }

    @Override // com.google.android.material.floatingactionbutton.d
    MaterialShapeDrawable u() {
        return new AlwaysStatefulMaterialShapeDrawable((l) ZeusTransformUtils.preCheckCast(Preconditions.checkNotNull(this.f3927b), l.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.google.android.material.floatingactionbutton.d
    void x() {
    }
}
