package com.google.android.material.floatingactionbutton;

import aa.j;
import aa.n;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomappbar.f;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.internal.r;
import com.google.android.material.stateful.ExtendableSavedState;
import com.obric.cae.R;
import h9.g;
import j0.h0;
import j0.w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class FloatingActionButton extends r implements t9.a, n, CoordinatorLayout.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ColorStateList f4752b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public PorterDuff.Mode f4753m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public ColorStateList f4754n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public PorterDuff.Mode f4755o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public ColorStateList f4756p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f4757q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f4758r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f4759s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f4760t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public u9.b f4761u;

    public static class BaseBehavior<T extends FloatingActionButton> extends CoordinatorLayout.c<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Rect f4762a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f4763b;

        public BaseBehavior() {
            this.f4763b = true;
        }

        public final boolean A(View r8, FloatingActionButton r10) {
            if (y(r8, r10) == true) goto L5;
            return false;
        L5:
            CoordinatorLayout.f r11 = (CoordinatorLayout.f) r10.getLayoutParams();
            if (r8.getTop() >= ((r10.getHeight() / 2) + ((ViewGroup.MarginLayoutParams) r11).topMargin)) goto L8;
            r10.g(null, false);
            return true;
        L8:
            r10.k(null, false);
            return true;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public final boolean a(View r8) {
            ((FloatingActionButton) r8).getLeft();
            throw null;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public final void c(CoordinatorLayout.f r8) {
            if (r8.f1570h != 0) goto L6;
            r8.f1570h = 80;
            return;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public final boolean d(CoordinatorLayout r8, View r10, View r11) {
            FloatingActionButton r12 = (FloatingActionButton) r10;
            if ((r11 instanceof AppBarLayout) == false) goto L5;
            z(r8, (AppBarLayout) r11, r12);
        L11:
            return false;
        L5:
            ViewGroup.LayoutParams r13 = r11.getLayoutParams();
            if ((r13 instanceof CoordinatorLayout.f) == false) goto L8;
            boolean r14 = ((CoordinatorLayout.f) r13).f1563a instanceof BottomSheetBehavior;
        L9:
            if (r14 == false) goto L11;
            A(r11, r12);
            goto L11
        L8:
            r14 = false;
            goto L9
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public final boolean h(CoordinatorLayout r8, View r10, int r11) {
            FloatingActionButton r12 = (FloatingActionButton) r10;
            ArrayList r13 = r8.e(r12);
            int r14 = r13.size();
            int r15 = 0;
        L3:
            if (r15 >= r14) goto L18;
            View r16 = (View) r13.get(r15);
            if ((r16 instanceof AppBarLayout) == true) goto L7;
            ViewGroup.LayoutParams r17 = r16.getLayoutParams();
            if ((r17 instanceof CoordinatorLayout.f) == false) goto L12;
            boolean r18 = ((CoordinatorLayout.f) r17).f1563a instanceof BottomSheetBehavior;
        L13:
            if (r18 == false) goto L17;
            if (A(r16, r12) == true) goto L18;
        L17:
            r15 = r15 + 1;
            goto L3
        L12:
            r18 = false;
            goto L13
        L7:
            if (z(r8, (AppBarLayout) r16, r12) == false) goto L17;
        L18:
            r8.q(r12, r11);
            return true;
        }

        public final boolean y(View r8, FloatingActionButton r10) {
            CoordinatorLayout.f r11 = (CoordinatorLayout.f) r10.getLayoutParams();
            if (this.f4763b == true) goto L6;
            return false;
        L6:
            if (r11.f1568f == r8.getId()) goto L9;
            return false;
        L9:
            if (r10.getUserSetVisibility() == 0) goto L11;
            return false;
        L11:
            return true;
        }

        public final boolean z(CoordinatorLayout r8, AppBarLayout r10, FloatingActionButton r11) {
            if (y(r10, r11) == true) goto L6;
            return false;
        L6:
            if (this.f4762a != null) goto L8;
            this.f4762a = new Rect();
        L8:
            Rect r12 = this.f4762a;
            com.google.android.material.internal.d.a(r8, r10, r12);
            if (r12.bottom > r10.getMinimumHeightForVisibleOverlappingContent()) goto L11;
            r11.g(null, false);
            return true;
        L11:
            r11.k(null, false);
            return true;
        }

        public BaseBehavior(Context r8, AttributeSet r10) {
            super(r8, r10);
            TypedArray r11 = r8.obtainStyledAttributes(r10, g9.a.f7767h);
            this.f4763b = r11.getBoolean(0, true);
            r11.recycle();
        }
    }

    public static class Behavior extends BaseBehavior<FloatingActionButton> {
        public Behavior() {
        }

        public Behavior(Context r8, AttributeSet r10) {
            super(r8, r10);
        }
    }

    public static abstract class a {
        public void a(FloatingActionButton r8) {
        }

        public void b() {
        }
    }

    public class b implements z9.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FloatingActionButton f4764a;

        public b(FloatingActionButton r8) {
            this.f4764a = r8;
        }
    }

    public class c<T extends FloatingActionButton> implements d.f {
        public c(FloatingActionButton r8) {
        }

        @Override // com.google.android.material.floatingactionbutton.d.f
        public final void a() {
            throw null;
        }

        @Override // com.google.android.material.floatingactionbutton.d.f
        public final void b() {
            throw null;
        }

        public final boolean equals(Object r8) {
            if ((r8 instanceof c) == true) goto L6;
            return false;
        L6:
            ((c) r8).getClass();
            throw null;
        }

        public final int hashCode() {
            throw null;
        }
    }

    private d getImpl() {
        if (this.f4761u != null) goto L6;
        this.f4761u = new u9.b(this, new b(this));
    L6:
        return this.f4761u;
    }

    @Override // t9.a
    public final boolean a() {
        throw null;
    }

    public final void c() {
        d r8 = getImpl();
        if (r8.f4791o != null) goto L5;
        r8.f4791o = new ArrayList();
    L5:
        r8.f4791o.add(null);
    }

    public final void d(f r8) {
        d r10 = getImpl();
        if (r10.f4790n != null) goto L5;
        r10.f4790n = new ArrayList();
    L5:
        r10.f4790n.add(r8);
    }

    @Override // android.widget.ImageView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        getImpl().i(getDrawableState());
    }

    public final void e() {
        d r8 = getImpl();
        c r10 = new c(this);
        if (r8.f4792p != null) goto L5;
        r8.f4792p = new ArrayList();
    L5:
        r8.f4792p.add(r10);
    }

    public final int f(int r8) {
        int r10 = this.f4758r;
        if (r10 == 0) goto L5;
        return r10;
    L5:
        Resources r11 = getResources();
        if (r8 == (-1)) goto L13;
        if (r8 == 1) goto L11;
        int r12 = R.dimen.design_fab_size_normal;
    L10:
        return r11.getDimensionPixelSize(r12);
    L11:
        r12 = R.dimen.design_fab_size_mini;
        goto L10
    L13:
        if (Math.max(r11.getConfiguration().screenWidthDp, r11.getConfiguration().screenHeightDp) >= 470) goto L16;
        return f(1);
    L16:
        return f(0);
    }

    public final void g(com.google.android.material.bottomappbar.c r8, boolean r10) {
        d r11 = getImpl();
        if (r8 != null) goto L5;
        com.google.android.material.floatingactionbutton.a r12 = null;
    L6:
        int r13 = r11.f4793q.getVisibility();
        int r14 = r11.f4789m;
        boolean r15 = true;
        if (r13 != 0) goto L12;
        if (r14 != 1) goto L10;
    L9:
        boolean r16 = true;
    L14:
        if (r16 == true) goto L47;
        Animator r17 = r11.f4783g;
        if (r17 == null) goto L19;
        r17.cancel();
    L19:
        WeakHashMap<View, h0> r18 = w.f8437a;
        FloatingActionButton r19 = r11.f4793q;
        if (w.g.c(r19) == true) goto L22;
    L24:
        r15 = false;
    L25:
        if (r15 == false) goto L37;
        g r20 = r11.f4785i;
        if (r20 == null) goto L29;
        AnimatorSet r21 = r11.b(r20, 0.0f, 0.0f, 0.0f);
    L30:
        r21.addListener(new com.google.android.material.floatingactionbutton.b(r11, r10, r12));
        ArrayList<Animator.AnimatorListener> r22 = r11.f4791o;
        if (r22 == null) goto L36;
        Iterator<Animator.AnimatorListener> r23 = r22.iterator();
    L34:
        if (r23.hasNext() == false) goto L36;
        r21.addListener(r23.next());
    L36:
        r21.start();
        return;
    L29:
        r21 = r11.c(0.0f, 0.4f, 0.4f, d.A, d.B);
        goto L30
    L37:
        if (r10 == false) goto L39;
        int r24 = 8;
    L40:
        r19.b(r24, r10);
        if (r12 == null) goto L46;
        r12.f4765a.a(r12.f4766b);
        return;
    L46:
        return;
    L39:
        r24 = 4;
        goto L40
    L22:
        if (r19.isInEditMode() == true) goto L24;
    L47:
        return;
    L10:
        r16 = false;
        goto L14
    L12:
        if (r14 == 2) goto L10;
    L5:
        r12 = new com.google.android.material.floatingactionbutton.a(this, r8);
        goto L6
    }

    @Override // android.view.View
    public ColorStateList getBackgroundTintList() {
        return this.f4752b;
    }

    @Override // android.view.View
    public PorterDuff.Mode getBackgroundTintMode() {
        return this.f4753m;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public CoordinatorLayout.c<FloatingActionButton> getBehavior() {
        return new Behavior();
    }

    public float getCompatElevation() {
        return getImpl().e();
    }

    public float getCompatHoveredFocusedTranslationZ() {
        return getImpl().f4781e;
    }

    public float getCompatPressedTranslationZ() {
        return getImpl().f4782f;
    }

    public Drawable getContentBackground() {
        getImpl().getClass();
        return null;
    }

    public int getCustomSize() {
        return this.f4758r;
    }

    public int getExpandedComponentIdHint() {
        throw null;
    }

    public g getHideMotionSpec() {
        return getImpl().f4785i;
    }

    @Deprecated
    public int getRippleColor() {
        ColorStateList r8 = this.f4756p;
        if (r8 != null) goto L7;
        return 0;
    L7:
        return r8.getDefaultColor();
    }

    public ColorStateList getRippleColorStateList() {
        return this.f4756p;
    }

    public j getShapeAppearanceModel() {
        j r8 = getImpl().f4777a;
        r8.getClass();
        return r8;
    }

    public g getShowMotionSpec() {
        return getImpl().f4784h;
    }

    public int getSize() {
        return this.f4757q;
    }

    public int getSizeDimension() {
        return f(this.f4757q);
    }

    public ColorStateList getSupportBackgroundTintList() {
        return getBackgroundTintList();
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        return getBackgroundTintMode();
    }

    public ColorStateList getSupportImageTintList() {
        return this.f4754n;
    }

    public PorterDuff.Mode getSupportImageTintMode() {
        return this.f4755o;
    }

    public boolean getUseCompatPadding() {
        return this.f4760t;
    }

    public final boolean h() {
        d r8 = getImpl();
        int r10 = r8.f4793q.getVisibility();
        int r11 = r8.f4789m;
        if (r10 != 0) goto L7;
        if (r11 == 1) goto L10;
        return false;
    L10:
        return true;
    L7:
        if (r11 != 2) goto L10;
        return false;
    }

    public final boolean i() {
        d r8 = getImpl();
        int r10 = r8.f4793q.getVisibility();
        int r11 = r8.f4789m;
        if (r10 != 0) goto L5;
        if (r11 != 1) goto L10;
        return false;
    L10:
        return true;
    L5:
        if (r11 == 2) goto L10;
        return false;
    }

    public final void j() {
        Drawable r8 = getDrawable();
        if (r8 != null) goto L5;
        return;
    L5:
        ColorStateList r10 = this.f4754n;
        if (r10 != null) goto L9;
        r8.clearColorFilter();
        return;
    L9:
        int r11 = r10.getColorForState(getDrawableState(), 0);
        PorterDuff.Mode r12 = this.f4755o;
        if (r12 != null) goto L12;
        r12 = PorterDuff.Mode.SRC_IN;
    L12:
        r8.mutate().setColorFilter(androidx.appcompat.widget.j.c(r11, r12));
    }

    @Override // android.widget.ImageView, android.view.View
    public final void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        getImpl().g();
    }

    public final void k(com.google.android.material.bottomappbar.c.a r8, boolean r10) {
        d r11 = getImpl();
        if (r8 != null) goto L5;
        com.google.android.material.floatingactionbutton.a r12 = null;
    L6:
        int r13 = r11.f4793q.getVisibility();
        int r14 = r11.f4789m;
        boolean r15 = true;
        if (r13 != 0) goto L9;
        if (r14 != 1) goto L10;
    L11:
        boolean r16 = false;
    L14:
        if (r16 == true) goto L63;
        Animator r17 = r11.f4783g;
        if (r17 == null) goto L20;
        r17.cancel();
    L20:
        if (r11.f4784h != null) goto L22;
        boolean r18 = true;
    L23:
        WeakHashMap<View, h0> r19 = w.f8437a;
        FloatingActionButton r20 = r11.f4793q;
        if (w.g.c(r20) == true) goto L26;
    L28:
        r15 = false;
    L29:
        Matrix r21 = r11.f4798v;
        if (r15 == true) goto L32;
        r20.b(0, r10);
        r20.setAlpha(1.0f);
        r20.setScaleY(1.0f);
        r20.setScaleX(1.0f);
        r11.f4787k = 1.0f;
        r11.a(1.0f, r21);
        r20.setImageMatrix(r21);
        if (r12 == null) goto L62;
        r12.f4765a.b();
        return;
    L62:
        return;
    L32:
        if (r20.getVisibility() == 0) goto L45;
        float r22 = 0.0f;
        r20.setAlpha(0.0f);
        if (r18 == false) goto L36;
        float r23 = 0.4f;
    L37:
        r20.setScaleY(r23);
        if (r18 == false) goto L40;
        float r24 = 0.4f;
    L41:
        r20.setScaleX(r24);
        if (r18 == false) goto L44;
        r22 = 0.4f;
    L44:
        r11.f4787k = r22;
        r11.a(r22, r21);
        r20.setImageMatrix(r21);
        goto L45
    L40:
        r24 = 0.0f;
        goto L41
    L36:
        r23 = 0.0f;
    L45:
        g r25 = r11.f4784h;
        if (r25 == null) goto L48;
        AnimatorSet r26 = r11.b(r25, 1.0f, 1.0f, 1.0f);
    L49:
        r26.addListener(new com.google.android.material.floatingactionbutton.c(r11, r10, r12));
        ArrayList<Animator.AnimatorListener> r27 = r11.f4790n;
        if (r27 == null) goto L55;
        Iterator<Animator.AnimatorListener> r28 = r27.iterator();
    L53:
        if (r28.hasNext() == false) goto L55;
        r26.addListener(r28.next());
    L55:
        r26.start();
        return;
    L48:
        r26 = r11.c(1.0f, 1.0f, 1.0f, d.f4775y, d.f4776z);
        goto L49
    L26:
        if (r20.isInEditMode() == true) goto L28;
    L22:
        r18 = false;
        goto L23
    L63:
        return;
    L10:
        r16 = true;
        goto L14
    L9:
        if (r14 != 2) goto L11;
    L5:
        r12 = new com.google.android.material.floatingactionbutton.a(this, r8);
        goto L6
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        d r8 = getImpl();
        r8.getClass();
        if ((!(r8 instanceof u9.b)) == false) goto L9;
        ViewTreeObserver r10 = r8.f4793q.getViewTreeObserver();
        if (r8.f4799w != null) goto L7;
        r8.f4799w = new u9.a(r8);
    L7:
        r10.addOnPreDrawListener(r8.f4799w);
        return;
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        d r8 = getImpl();
        ViewTreeObserver r10 = r8.f4793q.getViewTreeObserver();
        u9.a r11 = r8.f4799w;
        if (r11 == null) goto L6;
        r10.removeOnPreDrawListener(r11);
        r8.f4799w = null;
        return;
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onMeasure(int r8, int r10) {
        int r11 = (getSizeDimension() - this.f4759s) / 2;
        getImpl().n();
        throw null;
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable r8) {
        if ((r8 instanceof ExtendableSavedState) == true) goto L6;
        super.onRestoreInstanceState(r8);
        return;
    L6:
        ExtendableSavedState r10 = (ExtendableSavedState) r8;
        super.onRestoreInstanceState(r10.f1731a);
        r10.f4966m.getOrDefault("expandableWidgetHelper", null).getClass();
        throw null;
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        Parcelable r8 = super.onSaveInstanceState();
        if (r8 != null) goto L5;
        r8 = new Bundle();
    L5:
        new ExtendableSavedState(r8);
        throw null;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r8) {
        if (r8.getAction() != 0) goto L5;
        getMeasuredWidth();
        getMeasuredHeight();
        throw null;
    L5:
        return super.onTouchEvent(r8);
    }

    @Override // android.view.View
    public void setBackgroundColor(int r8) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable r8) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    @Override // android.view.View
    public void setBackgroundResource(int r8) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    @Override // android.view.View
    public void setBackgroundTintList(ColorStateList r8) {
        if (this.f4752b == r8) goto L6;
        this.f4752b = r8;
        getImpl().getClass();
        return;
    }

    @Override // android.view.View
    public void setBackgroundTintMode(PorterDuff.Mode r8) {
        if (this.f4753m == r8) goto L6;
        this.f4753m = r8;
        getImpl().getClass();
        return;
    }

    public void setCompatElevation(float r8) {
        d r10 = getImpl();
        if (r10.f4780d == r8) goto L6;
        r10.f4780d = r8;
        r10.j(r8, r10.f4781e, r10.f4782f);
        return;
    }

    public void setCompatElevationResource(int r8) {
        setCompatElevation(getResources().getDimension(r8));
    }

    public void setCompatHoveredFocusedTranslationZ(float r8) {
        d r10 = getImpl();
        if (r10.f4781e == r8) goto L6;
        r10.f4781e = r8;
        r10.j(r10.f4780d, r8, r10.f4782f);
        return;
    }

    public void setCompatHoveredFocusedTranslationZResource(int r8) {
        setCompatHoveredFocusedTranslationZ(getResources().getDimension(r8));
    }

    public void setCompatPressedTranslationZ(float r8) {
        d r10 = getImpl();
        if (r10.f4782f == r8) goto L6;
        r10.f4782f = r8;
        r10.j(r10.f4780d, r10.f4781e, r8);
        return;
    }

    public void setCompatPressedTranslationZResource(int r8) {
        setCompatPressedTranslationZ(getResources().getDimension(r8));
    }

    public void setCustomSize(int r8) {
        if (r8 < 0) goto L8;
        if (r8 == this.f4758r) goto L9;
        this.f4758r = r8;
        requestLayout();
        return;
    L9:
        return;
    L8:
        throw new IllegalArgumentException("Custom size must be non-negative");
    }

    @Override // android.view.View
    public void setElevation(float r8) {
        super.setElevation(r8);
        getImpl().getClass();
    }

    public void setEnsureMinTouchTargetSize(boolean r8) {
        if (r8 == getImpl().f4778b) goto L6;
        getImpl().f4778b = r8;
        requestLayout();
        return;
    }

    public void setExpandedComponentIdHint(int r8) {
        throw null;
    }

    public void setHideMotionSpec(g r8) {
        getImpl().f4785i = r8;
    }

    public void setHideMotionSpecResource(int r8) {
        setHideMotionSpec(g.a(getContext(), r8));
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable r8) {
        if (getDrawable() == r8) goto L8;
        super.setImageDrawable(r8);
        d r10 = getImpl();
        float r11 = r10.f4787k;
        r10.f4787k = r11;
        Matrix r12 = r10.f4798v;
        r10.a(r11, r12);
        r10.f4793q.setImageMatrix(r12);
        if (this.f4754n == null) goto L9;
        j();
        return;
    L9:
        return;
    }

    @Override // android.widget.ImageView
    public void setImageResource(int r8) {
        throw null;
    }

    public void setMaxImageSize(int r8) {
        this.f4759s = r8;
        d r10 = getImpl();
        if (r10.f4788l == r8) goto L6;
        r10.f4788l = r8;
        float r11 = r10.f4787k;
        r10.f4787k = r11;
        Matrix r12 = r10.f4798v;
        r10.a(r11, r12);
        r10.f4793q.setImageMatrix(r12);
        return;
    }

    public void setRippleColor(int r8) {
        setRippleColor(ColorStateList.valueOf(r8));
    }

    @Override // android.view.View
    public void setScaleX(float r8) {
        super.setScaleX(r8);
        ArrayList<d.f> r10 = getImpl().f4792p;
        if (r10 == null) goto L8;
        Iterator<d.f> r11 = r10.iterator();
    L6:
        if (r11.hasNext() == false) goto L10;
        r11.next().b();
        goto L6
    L10:
        return;
    }

    @Override // android.view.View
    public void setScaleY(float r8) {
        super.setScaleY(r8);
        ArrayList<d.f> r10 = getImpl().f4792p;
        if (r10 == null) goto L8;
        Iterator<d.f> r11 = r10.iterator();
    L6:
        if (r11.hasNext() == false) goto L10;
        r11.next().b();
        goto L6
    L10:
        return;
    }

    public void setShadowPaddingEnabled(boolean r8) {
        d r10 = getImpl();
        r10.f4779c = r8;
        r10.n();
        throw null;
    }

    @Override // aa.n
    public void setShapeAppearanceModel(j r8) {
        getImpl().f4777a = r8;
    }

    public void setShowMotionSpec(g r8) {
        getImpl().f4784h = r8;
    }

    public void setShowMotionSpecResource(int r8) {
        setShowMotionSpec(g.a(getContext(), r8));
    }

    public void setSize(int r8) {
        this.f4758r = 0;
        if (r8 == this.f4757q) goto L6;
        this.f4757q = r8;
        requestLayout();
        return;
    }

    public void setSupportBackgroundTintList(ColorStateList r8) {
        setBackgroundTintList(r8);
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode r8) {
        setBackgroundTintMode(r8);
    }

    public void setSupportImageTintList(ColorStateList r8) {
        if (this.f4754n == r8) goto L6;
        this.f4754n = r8;
        j();
        return;
    }

    public void setSupportImageTintMode(PorterDuff.Mode r8) {
        if (this.f4755o == r8) goto L6;
        this.f4755o = r8;
        j();
        return;
    }

    @Override // android.view.View
    public void setTranslationX(float r8) {
        super.setTranslationX(r8);
        getImpl().k();
    }

    @Override // android.view.View
    public void setTranslationY(float r8) {
        super.setTranslationY(r8);
        getImpl().k();
    }

    @Override // android.view.View
    public void setTranslationZ(float r8) {
        super.setTranslationZ(r8);
        getImpl().k();
    }

    public void setUseCompatPadding(boolean r8) {
        if (this.f4760t == r8) goto L6;
        this.f4760t = r8;
        getImpl().h();
        return;
    }

    @Override // com.google.android.material.internal.r, android.widget.ImageView, android.view.View
    public void setVisibility(int r8) {
        super.setVisibility(r8);
    }

    public void setRippleColor(ColorStateList r8) {
        if (this.f4756p == r8) goto L6;
        this.f4756p = r8;
        getImpl().l();
        return;
    }
}
