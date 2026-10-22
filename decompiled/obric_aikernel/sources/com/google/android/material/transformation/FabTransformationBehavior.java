package com.google.android.material.transformation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Pair;
import android.util.Property;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;
import java.util.List;
import q5.f;
import r5.h;
import r5.i;
import r5.j;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public abstract class FabTransformationBehavior extends ExpandableTransformationBehavior {
    private float dependencyOriginalTranslationX;
    private float dependencyOriginalTranslationY;
    private final int[] tmpArray;
    private final Rect tmpRect;
    private final RectF tmpRectF1;
    private final RectF tmpRectF2;

    class a extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f4086c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ View f4087g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ View f4088h;

        a(FabTransformationBehavior r10, boolean r11, View r12, View r13) {
            this.f4086c = r11;
            this.f4087g = r12;
            this.f4088h = r13;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator r10) {
            if (this.f4086c == true) goto L6;
            this.f4087g.setVisibility(4);
            this.f4088h.setAlpha(1.0f);
            this.f4088h.setVisibility(0);
            return;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator r10) {
            if (this.f4086c == false) goto L6;
            this.f4087g.setVisibility(0);
            this.f4088h.setAlpha(0.0f);
            this.f4088h.setVisibility(4);
            return;
        }
    }

    class b implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ View f4089c;

        b(FabTransformationBehavior r10, View r11) {
            this.f4089c = r11;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator r10) {
            this.f4089c.invalidate();
        }
    }

    class c extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.google.android.material.circularreveal.c f4090c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ Drawable f4091g;

        c(FabTransformationBehavior r10, com.google.android.material.circularreveal.c r11, Drawable r12) {
            this.f4090c = r11;
            this.f4091g = r12;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator r10) {
            this.f4090c.setCircularRevealOverlayDrawable(null);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator r10) {
            this.f4090c.setCircularRevealOverlayDrawable(this.f4091g);
        }
    }

    class d extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.google.android.material.circularreveal.c f4092c;

        d(FabTransformationBehavior r10, com.google.android.material.circularreveal.c r11) {
            this.f4092c = r11;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator r10) {
            com.google.android.material.circularreveal.c.e r11 = this.f4092c.getRevealInfo();
            r11.f3159c = Float.MAX_VALUE;
            this.f4092c.setRevealInfo(r11);
        }
    }

    protected static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        public h f4093a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public j f4094b;

        protected e() {
        }
    }

    public FabTransformationBehavior() {
        this.tmpRect = new Rect();
        this.tmpRectF1 = new RectF();
        this.tmpRectF2 = new RectF();
        this.tmpArray = new int[2];
    }

    public FabTransformationBehavior(Context r10, AttributeSet r11) {
        super(r10, r11);
        this.tmpRect = new Rect();
        this.tmpRectF1 = new RectF();
        this.tmpRectF2 = new RectF();
        this.tmpArray = new int[2];
    }

    @Nullable
    private ViewGroup calculateChildContentContainer(@NonNull View r10) {
        View r11 = r10.findViewById(f.mtrl_child_content_container);
        if (r11 == null) goto L7;
        return toViewGroupOrNull(r11);
    L7:
        if ((r10 instanceof TransformationChildLayout) == true) goto L14;
        if ((r10 instanceof TransformationChildCard) == true) goto L14;
        return toViewGroupOrNull(r10);
    L14:
        return toViewGroupOrNull(((ViewGroup) r10).getChildAt(0));
    }

    private void calculateChildVisibleBoundsAtEndOfExpansion(@NonNull View r10, @NonNull e r11, @NonNull i r12, @NonNull i r13, float r14, float r15, float r16, float r17, @NonNull RectF r18) {
        float r19 = calculateValueOfAnimationAtEndOfExpansion(r11, r12, r14, r16);
        float r20 = calculateValueOfAnimationAtEndOfExpansion(r11, r13, r15, r17);
        Rect r21 = this.tmpRect;
        r10.getWindowVisibleDisplayFrame(r21);
        RectF r22 = this.tmpRectF1;
        r22.set(r21);
        RectF r23 = this.tmpRectF2;
        calculateWindowBounds(r10, r23);
        r23.offset(r19, r20);
        r23.intersect(r22);
        r18.set(r23);
    }

    private void calculateDependencyWindowBounds(@NonNull View r10, @NonNull RectF r11) {
        calculateWindowBounds(r10, r11);
        r11.offset(this.dependencyOriginalTranslationX, this.dependencyOriginalTranslationY);
    }

    @NonNull
    private Pair<i, i> calculateMotionTiming(float r10, float r11, boolean r12, @NonNull e r13) {
        if (r10 != 0.0f) goto L5;
    L14:
        i r14 = r13.f4093a.h("translationXLinear");
        h r15 = r13.f4093a;
        String r16 = "translationYLinear";
    L16:
        return new Pair(r14, r15.h(r16));
    L5:
        if (r11 == 0.0f) goto L14;
        if (r12 == true) goto L9;
    L10:
        if (r12 == true) goto L13;
        if (r11 <= 0.0f) goto L13;
    L12:
        r14 = r13.f4093a.h("translationXCurveUpwards");
        r15 = r13.f4093a;
        r16 = "translationYCurveUpwards";
    L13:
        r14 = r13.f4093a.h("translationXCurveDownwards");
        r15 = r13.f4093a;
        r16 = "translationYCurveDownwards";
        goto L16
    L9:
        if (r11 < 0.0f) goto L12;
        goto L10
    }

    private float calculateRevealCenterX(@NonNull View r10, @NonNull View r11, @NonNull j r12) {
        RectF r13 = this.tmpRectF1;
        RectF r14 = this.tmpRectF2;
        calculateDependencyWindowBounds(r10, r13);
        calculateWindowBounds(r11, r14);
        r14.offset(-calculateTranslationX(r10, r11, r12), 0.0f);
        return r13.centerX() - r14.left;
    }

    private float calculateRevealCenterY(@NonNull View r10, @NonNull View r11, @NonNull j r12) {
        RectF r13 = this.tmpRectF1;
        RectF r14 = this.tmpRectF2;
        calculateDependencyWindowBounds(r10, r13);
        calculateWindowBounds(r11, r14);
        r14.offset(0.0f, -calculateTranslationY(r10, r11, r12));
        return r13.centerY() - r14.top;
    }

    private float calculateTranslationX(@NonNull View r10, @NonNull View r11, @NonNull j r12) {
        RectF r13 = this.tmpRectF1;
        RectF r14 = this.tmpRectF2;
        calculateDependencyWindowBounds(r10, r13);
        calculateWindowBounds(r11, r14);
        int r15 = r12.f12693a & 7;
        if (r15 != 1) goto L5;
        float r16 = r14.centerX();
        float r17 = r13.centerX();
    L12:
        float r18 = r16 - r17;
    L14:
        return r18 + r12.f12694b;
    L5:
        if (r15 != 3) goto L7;
        r16 = r14.left;
        r17 = r13.left;
        goto L12
    L7:
        if (r15 == 5) goto L9;
        r18 = 0.0f;
        goto L14
    L9:
        r16 = r14.right;
        r17 = r13.right;
        goto L12
    }

    private float calculateTranslationY(@NonNull View r10, @NonNull View r11, @NonNull j r12) {
        RectF r13 = this.tmpRectF1;
        RectF r14 = this.tmpRectF2;
        calculateDependencyWindowBounds(r10, r13);
        calculateWindowBounds(r11, r14);
        int r15 = r12.f12693a & 112;
        if (r15 != 16) goto L5;
        float r16 = r14.centerY();
        float r17 = r13.centerY();
    L12:
        float r18 = r16 - r17;
    L14:
        return r18 + r12.f12695c;
    L5:
        if (r15 != 48) goto L7;
        r16 = r14.top;
        r17 = r13.top;
        goto L12
    L7:
        if (r15 == 80) goto L9;
        r18 = 0.0f;
        goto L14
    L9:
        r16 = r14.bottom;
        r17 = r13.bottom;
        goto L12
    }

    private float calculateValueOfAnimationAtEndOfExpansion(@NonNull e r10, @NonNull i r11, float r12, float r13) {
        long r14 = r11.c();
        long r15 = r11.d();
        i r16 = r10.f4093a.h("expansion");
        return r5.a.a(r12, r13, r11.e().getInterpolation((((r16.c() + r16.d()) + 17) - r14) / r15));
    }

    private void calculateWindowBounds(@NonNull View r10, RectF r11) {
        r11.set(0.0f, 0.0f, r10.getWidth(), r10.getHeight());
        int[] r12 = this.tmpArray;
        r10.getLocationInWindow(r12);
        r11.offsetTo(r12[0], r12[1]);
        r11.offset((int) (-r10.getTranslationX()), (int) (-r10.getTranslationY()));
    }

    private void createChildrenFadeAnimation(View r10, View r11, boolean r12, boolean r13, @NonNull e r14, @NonNull List<Animator> r15, List<Animator.AnimatorListener> r16) {
        if ((r11 instanceof ViewGroup) == true) goto L6;
        return;
    L6:
        if ((r11 instanceof com.google.android.material.circularreveal.c) == true) goto L8;
    L10:
        ViewGroup r17 = calculateChildContentContainer(r11);
        if (r17 != null) goto L14;
        return;
    L14:
        if (r12 == false) goto L18;
        if (r13 == true) goto L17;
        r5.d.f12679a.set(r17, Float.valueOf(0.0f));
    L17:
        ObjectAnimator r18 = ObjectAnimator.ofFloat(r17, r5.d.f12679a, new float[]{1.0f});
    L19:
        r14.f4093a.h("contentFade").a(r18);
        r15.add(r18);
        return;
    L18:
        r18 = ObjectAnimator.ofFloat(r17, r5.d.f12679a, new float[]{0.0f});
        goto L19
    L8:
        if (com.google.android.material.circularreveal.b.f3143j != 0) goto L10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void createColorAnimation(@NonNull View r10, View r11, boolean r12, boolean r13, @NonNull e r14, @NonNull List<Animator> r15, List<Animator.AnimatorListener> r16) {
        if ((r11 instanceof com.google.android.material.circularreveal.c) == true) goto L5;
        return;
    L5:
        com.google.android.material.circularreveal.c r17 = (com.google.android.material.circularreveal.c) r11;
        int r18 = getBackgroundTint(r10);
        int r19 = 16777215 & r18;
        if (r12 == false) goto L10;
        if (r13 == true) goto L9;
        r17.setCircularRevealScrimColor(r18);
    L9:
        ObjectAnimator r20 = ObjectAnimator.ofInt(r17, com.google.android.material.circularreveal.c.d.f3156a, new int[]{r19});
    L11:
        r20.setEvaluator(r5.c.b());
        r14.f4093a.h(TypedValues.Custom.S_COLOR).a(r20);
        r15.add(r20);
        return;
    L10:
        r20 = ObjectAnimator.ofInt(r17, com.google.android.material.circularreveal.c.d.f3156a, new int[]{r18});
        goto L11
    }

    private void createDependencyTranslationAnimation(@NonNull View r10, @NonNull View r11, boolean r12, @NonNull e r13, @NonNull List<Animator> r14) {
        float r15 = calculateTranslationX(r10, r11, r13.f4094b);
        float r16 = calculateTranslationY(r10, r11, r13.f4094b);
        Pair<i, i> r17 = calculateMotionTiming(r15, r16, r12, r13);
        i r18 = (i) r17.first;
        i r19 = (i) r17.second;
        Property r20 = View.TRANSLATION_X;
        float[] r21 = new float[1];
        if (r12 == true) goto L6;
        r15 = this.dependencyOriginalTranslationX;
    L6:
        r21[0] = r15;
        ObjectAnimator r22 = ObjectAnimator.ofFloat(r10, r20, r21);
        Property r23 = View.TRANSLATION_Y;
        float[] r24 = new float[1];
        if (r12 == true) goto L10;
        r16 = this.dependencyOriginalTranslationY;
    L10:
        r24[0] = r16;
        ObjectAnimator r25 = ObjectAnimator.ofFloat(r10, r23, r24);
        r18.a(r22);
        r19.a(r25);
        r14.add(r22);
        r14.add(r25);
    }

    @TargetApi(21)
    private void createElevationAnimation(View r10, @NonNull View r11, boolean r12, boolean r13, @NonNull e r14, @NonNull List<Animator> r15, List<Animator.AnimatorListener> r16) {
        float r17 = ViewCompat.getElevation(r11) - ViewCompat.getElevation(r10);
        if (r12 == false) goto L7;
        if (r13 == true) goto L6;
        r11.setTranslationZ(-r17);
    L6:
        ObjectAnimator r18 = ObjectAnimator.ofFloat(r11, View.TRANSLATION_Z, new float[]{0.0f});
    L8:
        r14.f4093a.h("elevation").a(r18);
        r15.add(r18);
        return;
    L7:
        r18 = ObjectAnimator.ofFloat(r11, View.TRANSLATION_Z, new float[]{-r17});
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void createExpansionAnimation(@NonNull View r18, View r19, boolean r20, boolean r21, @NonNull e r22, float r23, float r24, @NonNull List<Animator> r25, @NonNull List<Animator.AnimatorListener> r26) {
        if ((r19 instanceof com.google.android.material.circularreveal.c) == true) goto L5;
        return;
    L5:
        com.google.android.material.circularreveal.c r12 = (com.google.android.material.circularreveal.c) r19;
        float r10 = calculateRevealCenterX(r18, r19, r22.f4094b);
        float r11 = calculateRevealCenterY(r18, r19, r22.f4094b);
        ((FloatingActionButton) r18).getContentRect(this.tmpRect);
        float r13 = this.tmpRect.width() / 2.0f;
        i r14 = r22.f4093a.h("expansion");
        if (r20 == false) goto L12;
        if (r21 == true) goto L9;
        r12.setRevealInfo(new com.google.android.material.circularreveal.c.e(r10, r11, r13));
    L9:
        if (r21 == false) goto L11;
        r13 = r12.getRevealInfo().f3159c;
    L11:
        Animator r15 = com.google.android.material.circularreveal.a.a(r12, r10, r11, y5.a.b(r10, r11, 0.0f, 0.0f, r23, r24));
        r15.addListener(new d(this, r12));
        createPreFillRadialExpansion(r19, r14.c(), (int) r10, (int) r11, r13, r25);
    L13:
        r14.a(r15);
        r25.add(r15);
        r26.add(com.google.android.material.circularreveal.a.b(r12));
        return;
    L12:
        float r16 = r12.getRevealInfo().f3159c;
        Animator r17 = com.google.android.material.circularreveal.a.a(r12, r10, r11, r13);
        int r27 = (int) r10;
        int r110 = (int) r11;
        createPreFillRadialExpansion(r19, r14.c(), r27, r110, r16, r25);
        createPostFillRadialExpansion(r19, r14.c(), r14.d(), r22.f4093a.i(), r27, r110, r13, r25);
        r15 = r17;
        goto L13
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void createIconFadeAnimation(View r10, View r11, boolean r12, boolean r13, @NonNull e r14, @NonNull List<Animator> r15, @NonNull List<Animator.AnimatorListener> r16) {
        if ((r11 instanceof com.google.android.material.circularreveal.c) == true) goto L5;
        return;
    L5:
        if ((r10 instanceof ImageView) == false) goto L19;
        com.google.android.material.circularreveal.c r17 = (com.google.android.material.circularreveal.c) r11;
        Drawable r18 = ((ImageView) r10).getDrawable();
        if (r18 != null) goto L10;
        return;
    L10:
        r18.mutate();
        if (r12 == false) goto L15;
        if (r13 == true) goto L14;
        r18.setAlpha(255);
    L14:
        ObjectAnimator r19 = ObjectAnimator.ofInt(r18, r5.e.f12680b, new int[]{0});
    L16:
        r19.addUpdateListener(new b(this, r11));
        r14.f4093a.h("iconFade").a(r19);
        r15.add(r19);
        r16.add(new c(this, r17, r18));
        return;
    L15:
        r19 = ObjectAnimator.ofInt(r18, r5.e.f12680b, new int[]{255});
        goto L16
    }

    private void createPostFillRadialExpansion(View r10, long r11, long r12, long r13, int r14, int r15, float r16, @NonNull List<Animator> r17) {
        if (Build.VERSION.SDK_INT < 21) goto L8;
        long r18 = r11 + r12;
        if (r18 >= r13) goto L9;
        Animator r19 = ViewAnimationUtils.createCircularReveal(r10, r14, r15, r16, r16);
        r19.setStartDelay(r18);
        r19.setDuration(r13 - r18);
        r17.add(r19);
        return;
    L9:
        return;
    }

    private void createPreFillRadialExpansion(View r10, long r11, int r12, int r13, float r14, @NonNull List<Animator> r15) {
        if (Build.VERSION.SDK_INT >= 21) goto L5;
        return;
    L5:
        if (r11 <= 0) goto L9;
        Animator r16 = ViewAnimationUtils.createCircularReveal(r10, r12, r13, r14, r14);
        r16.setStartDelay(0);
        r16.setDuration(r11);
        r15.add(r16);
        return;
    }

    private void createTranslationAnimation(@NonNull View r16, @NonNull View r17, boolean r18, boolean r19, @NonNull e r20, @NonNull List<Animator> r21, List<Animator.AnimatorListener> r22, @NonNull RectF r23) {
        float r10 = calculateTranslationX(r16, r17, r20.f4094b);
        float r11 = calculateTranslationY(r16, r17, r20.f4094b);
        Pair<i, i> r12 = calculateMotionTiming(r10, r11, r18, r20);
        i r13 = (i) r12.first;
        i r14 = (i) r12.second;
        if (r18 == false) goto L7;
        if (r19 == true) goto L6;
        r17.setTranslationX(-r10);
        r17.setTranslationY(-r11);
    L6:
        ObjectAnimator r15 = ObjectAnimator.ofFloat(r17, View.TRANSLATION_X, new float[]{0.0f});
        ObjectAnimator r110 = ObjectAnimator.ofFloat(r17, View.TRANSLATION_Y, new float[]{0.0f});
        calculateChildVisibleBoundsAtEndOfExpansion(r17, r20, r13, r14, -r10, -r11, 0.0f, 0.0f, r23);
    L8:
        r13.a(r15);
        r14.a(r110);
        r21.add(r15);
        r21.add(r110);
        return;
    L7:
        r15 = ObjectAnimator.ofFloat(r17, View.TRANSLATION_X, new float[]{-r10});
        r110 = ObjectAnimator.ofFloat(r17, View.TRANSLATION_Y, new float[]{-r11});
        goto L8
    }

    private int getBackgroundTint(@NonNull View r10) {
        ColorStateList r11 = ViewCompat.getBackgroundTintList(r10);
        if (r11 != null) goto L5;
        return 0;
    L5:
        return r11.getColorForState(r10.getDrawableState(), r11.getDefaultColor());
    }

    @Nullable
    private ViewGroup toViewGroupOrNull(View r10) {
        if ((r10 instanceof ViewGroup) == true) goto L5;
        return null;
    L5:
        return (ViewGroup) r10;
    }

    @Override // com.google.android.material.transformation.ExpandableBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    @CallSuper
    public boolean layoutDependsOn(@NonNull CoordinatorLayout r10, @NonNull View r11, @NonNull View r12) {
        if (r11.getVisibility() == 8) goto L13;
        if ((r12 instanceof FloatingActionButton) == false) goto L14;
        int r13 = ((FloatingActionButton) r12).getExpandedComponentIdHint();
        if (r13 != 0) goto L9;
    L10:
        return true;
    L9:
        if (r13 == r11.getId()) goto L10;
        return false;
    L14:
        return false;
    L13:
        throw new IllegalStateException("This behavior cannot be attached to a GONE view. Set the view to INVISIBLE instead.");
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    @CallSuper
    public void onAttachedToLayoutParams(@NonNull CoordinatorLayout.LayoutParams r10) {
        if (r10.dodgeInsetEdges != 0) goto L6;
        r10.dodgeInsetEdges = 80;
        return;
    }

    @Override // com.google.android.material.transformation.ExpandableTransformationBehavior
    @NonNull
    protected AnimatorSet onCreateExpandedStateChangeAnimation(@NonNull View r16, @NonNull View r17, boolean r18, boolean r19) {
        e r12 = onCreateMotionSpec(r17.getContext(), r18);
        if (r18 == false) goto L5;
        this.dependencyOriginalTranslationX = r16.getTranslationX();
        this.dependencyOriginalTranslationY = r16.getTranslationY();
    L5:
        ArrayList r13 = new ArrayList();
        ArrayList r14 = new ArrayList();
        if (Build.VERSION.SDK_INT < 21) goto L8;
        createElevationAnimation(r16, r17, r18, r19, r12, r13, r14);
    L8:
        RectF r10 = this.tmpRectF1;
        createTranslationAnimation(r16, r17, r18, r19, r12, r13, r14, r10);
        float r11 = r10.width();
        float r15 = r10.height();
        createDependencyTranslationAnimation(r16, r17, r18, r12, r13);
        createIconFadeAnimation(r16, r17, r18, r19, r12, r13, r14);
        createExpansionAnimation(r16, r17, r18, r19, r12, r11, r15, r13, r14);
        createColorAnimation(r16, r17, r18, r19, r12, r13, r14);
        createChildrenFadeAnimation(r16, r17, r18, r19, r12, r13, r14);
        AnimatorSet r20 = new AnimatorSet();
        r5.b.a(r20, r13);
        r20.addListener(new a(this, r18, r17, r16));
        int r21 = 0;
        int r22 = r14.size();
    L9:
        if (r21 >= r22) goto L11;
        r20.addListener(r14.get(r21));
        r21 = r21 + 1;
        goto L9
    L11:
        return r20;
    }

    protected abstract e onCreateMotionSpec(Context r10, boolean r11);
}
