package com.google.android.material.transformation;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
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
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.animation.AnimatorSetCompat;
import com.google.android.material.animation.ArgbEvaluatorCompat;
import com.google.android.material.animation.ChildrenAlphaProperty;
import com.google.android.material.animation.DrawableAlphaProperty;
import com.google.android.material.animation.MotionSpec;
import com.google.android.material.animation.MotionTiming;
import com.google.android.material.animation.Positioning;
import com.google.android.material.circularreveal.CircularRevealCompat;
import com.google.android.material.circularreveal.CircularRevealHelper;
import com.google.android.material.circularreveal.CircularRevealWidget;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.math.MathUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public abstract class FabTransformationBehavior extends ExpandableTransformationBehavior {
    private float dependencyOriginalTranslationX;
    private float dependencyOriginalTranslationY;
    private final int[] tmpArray;
    private final Rect tmpRect;
    private final RectF tmpRectF1;
    private final RectF tmpRectF2;

    public static class FabTransformationSpec {
        public Positioning positioning;

        @Nullable
        public MotionSpec timings;

        public FabTransformationSpec() {
        }
    }

    public FabTransformationBehavior() {
        this.tmpRect = new Rect();
        this.tmpRectF1 = new RectF();
        this.tmpRectF2 = new RectF();
        this.tmpArray = new int[2];
    }

    @Nullable
    private ViewGroup calculateChildContentContainer(@NonNull View r5) {
        View r10 = r5.findViewById(R.id.mtrl_child_content_container);
        if (r10 == null) goto L7;
        return toViewGroupOrNull(r10);
    L7:
        if ((r5 instanceof TransformationChildLayout) == true) goto L14;
        if ((r5 instanceof TransformationChildCard) == true) goto L14;
        return toViewGroupOrNull(r5);
    L14:
        return toViewGroupOrNull(((ViewGroup) r5).getChildAt(0));
    }

    private void calculateChildVisibleBoundsAtEndOfExpansion(@NonNull View r5, @NonNull FabTransformationSpec r10, @NonNull MotionTiming r11, @NonNull MotionTiming r12, float r13, float r14, float r15, float r16, @NonNull RectF r17) {
        float r18 = calculateValueOfAnimationAtEndOfExpansion(r10, r11, r13, r15);
        float r19 = calculateValueOfAnimationAtEndOfExpansion(r10, r12, r14, r16);
        Rect r20 = this.tmpRect;
        r5.getWindowVisibleDisplayFrame(r20);
        RectF r21 = this.tmpRectF1;
        r21.set(r20);
        RectF r22 = this.tmpRectF2;
        calculateWindowBounds(r5, r22);
        r22.offset(r18, r19);
        r22.intersect(r21);
        r17.set(r22);
    }

    private void calculateDependencyWindowBounds(@NonNull View r5, @NonNull RectF r10) {
        calculateWindowBounds(r5, r10);
        r10.offset(this.dependencyOriginalTranslationX, this.dependencyOriginalTranslationY);
    }

    @NonNull
    private Pair<MotionTiming, MotionTiming> calculateMotionTiming(float r5, float r10, boolean r11, @NonNull FabTransformationSpec r12) {
        if (r5 != 0.0f) goto L5;
    L14:
        MotionTiming r13 = r12.timings.getTiming("translationXLinear");
        MotionTiming r14 = r12.timings.getTiming("translationYLinear");
    L16:
        return new Pair(r13, r14);
    L5:
        if (r10 == 0.0f) goto L14;
        if (r11 == true) goto L9;
    L10:
        if (r11 == true) goto L13;
        if (r10 <= 0.0f) goto L13;
    L12:
        r13 = r12.timings.getTiming("translationXCurveUpwards");
        r14 = r12.timings.getTiming("translationYCurveUpwards");
    L13:
        r13 = r12.timings.getTiming("translationXCurveDownwards");
        r14 = r12.timings.getTiming("translationYCurveDownwards");
        goto L16
    L9:
        if (r10 < 0.0f) goto L12;
        goto L10
    }

    private float calculateRevealCenterX(@NonNull View r5, @NonNull View r10, @NonNull Positioning r11) {
        RectF r12 = this.tmpRectF1;
        RectF r13 = this.tmpRectF2;
        calculateDependencyWindowBounds(r5, r12);
        calculateWindowBounds(r10, r13);
        r13.offset(-calculateTranslationX(r5, r10, r11), 0.0f);
        return r12.centerX() - r13.left;
    }

    private float calculateRevealCenterY(@NonNull View r5, @NonNull View r10, @NonNull Positioning r11) {
        RectF r12 = this.tmpRectF1;
        RectF r13 = this.tmpRectF2;
        calculateDependencyWindowBounds(r5, r12);
        calculateWindowBounds(r10, r13);
        r13.offset(0.0f, -calculateTranslationY(r5, r10, r11));
        return r12.centerY() - r13.top;
    }

    private float calculateTranslationX(@NonNull View r5, @NonNull View r10, @NonNull Positioning r11) {
        RectF r12 = this.tmpRectF1;
        RectF r13 = this.tmpRectF2;
        calculateDependencyWindowBounds(r5, r12);
        calculateWindowBounds(r10, r13);
        int r14 = r11.gravity & 7;
        if (r14 != 1) goto L5;
        float r15 = r13.centerX();
        float r16 = r12.centerX();
    L10:
        float r17 = r15 - r16;
    L14:
        return r17 + r11.xAdjustment;
    L5:
        if (r14 != 3) goto L7;
        r15 = r13.left;
        r16 = r12.left;
        goto L10
    L7:
        if (r14 == 5) goto L9;
        r17 = 0.0f;
        goto L14
    L9:
        r15 = r13.right;
        r16 = r12.right;
        goto L10
    }

    private float calculateTranslationY(@NonNull View r5, @NonNull View r10, @NonNull Positioning r11) {
        RectF r12 = this.tmpRectF1;
        RectF r13 = this.tmpRectF2;
        calculateDependencyWindowBounds(r5, r12);
        calculateWindowBounds(r10, r13);
        int r14 = r11.gravity & 112;
        if (r14 != 16) goto L5;
        float r15 = r13.centerY();
        float r16 = r12.centerY();
    L10:
        float r17 = r15 - r16;
    L14:
        return r17 + r11.yAdjustment;
    L5:
        if (r14 != 48) goto L7;
        r15 = r13.top;
        r16 = r12.top;
        goto L10
    L7:
        if (r14 == 80) goto L9;
        r17 = 0.0f;
        goto L14
    L9:
        r15 = r13.bottom;
        r16 = r12.bottom;
        goto L10
    }

    private float calculateValueOfAnimationAtEndOfExpansion(@NonNull FabTransformationSpec r10, @NonNull MotionTiming r11, float r12, float r13) {
        long r5 = r11.getDelay();
        long r14 = r11.getDuration();
        MotionTiming r15 = r10.timings.getTiming("expansion");
        return AnimationUtils.lerp(r12, r13, r11.getInterpolator().getInterpolation((((r15.getDuration() + r15.getDelay()) + 17) - r5) / r14));
    }

    private void calculateWindowBounds(@NonNull View r5, RectF r10) {
        r10.set(0.0f, 0.0f, r5.getWidth(), r5.getHeight());
        int[] r11 = this.tmpArray;
        r5.getLocationInWindow(r11);
        r10.offsetTo(r11[0], r11[1]);
        r10.offset((int) (-r5.getTranslationX()), (int) (-r5.getTranslationY()));
    }

    private void createChildrenFadeAnimation(View r5, View r10, boolean r11, boolean r12, @NonNull FabTransformationSpec r13, @NonNull List<Animator> r14, List<Animator.AnimatorListener> r15) {
        if ((r10 instanceof ViewGroup) == true) goto L6;
        return;
    L6:
        if ((r10 instanceof CircularRevealWidget) == true) goto L8;
    L10:
        ViewGroup r16 = calculateChildContentContainer(r10);
        if (r16 != null) goto L14;
        return;
    L14:
        if (r11 == false) goto L18;
        if (r12 == true) goto L17;
        ChildrenAlphaProperty.CHILDREN_ALPHA.set(r16, Float.valueOf(0.0f));
    L17:
        ObjectAnimator r17 = ObjectAnimator.ofFloat(r16, ChildrenAlphaProperty.CHILDREN_ALPHA, new float[]{1.0f});
    L19:
        r13.timings.getTiming("contentFade").apply(r17);
        r14.add(r17);
        return;
    L18:
        r17 = ObjectAnimator.ofFloat(r16, ChildrenAlphaProperty.CHILDREN_ALPHA, new float[]{0.0f});
        goto L19
    L8:
        if (CircularRevealHelper.STRATEGY != 0) goto L10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void createColorAnimation(@NonNull View r5, View r10, boolean r11, boolean r12, @NonNull FabTransformationSpec r13, @NonNull List<Animator> r14, List<Animator.AnimatorListener> r15) {
        if ((r10 instanceof CircularRevealWidget) == true) goto L5;
        return;
    L5:
        CircularRevealWidget r16 = (CircularRevealWidget) r10;
        int r17 = getBackgroundTint(r5);
        int r18 = 16777215 & r17;
        if (r11 == false) goto L10;
        if (r12 == true) goto L9;
        r16.setCircularRevealScrimColor(r17);
    L9:
        ObjectAnimator r19 = ObjectAnimator.ofInt(r16, CircularRevealWidget.CircularRevealScrimColorProperty.CIRCULAR_REVEAL_SCRIM_COLOR, new int[]{r18});
    L11:
        r19.setEvaluator(ArgbEvaluatorCompat.getInstance());
        r13.timings.getTiming("color").apply(r19);
        r14.add(r19);
        return;
    L10:
        r19 = ObjectAnimator.ofInt(r16, CircularRevealWidget.CircularRevealScrimColorProperty.CIRCULAR_REVEAL_SCRIM_COLOR, new int[]{r17});
        goto L11
    }

    private void createDependencyTranslationAnimation(@NonNull View r10, @NonNull View r11, boolean r12, @NonNull FabTransformationSpec r13, @NonNull List<Animator> r14) {
        float r5 = calculateTranslationX(r10, r11, r13.positioning);
        float r15 = calculateTranslationY(r10, r11, r13.positioning);
        Pair<MotionTiming, MotionTiming> r16 = calculateMotionTiming(r5, r15, r12, r13);
        MotionTiming r17 = (MotionTiming) r16.first;
        MotionTiming r18 = (MotionTiming) r16.second;
        Property r19 = View.TRANSLATION_X;
        if (r12 == true) goto L6;
        r5 = this.dependencyOriginalTranslationX;
    L6:
        ObjectAnimator r20 = ObjectAnimator.ofFloat(r10, r19, new float[]{r5});
        Property r21 = View.TRANSLATION_Y;
        if (r12 == true) goto L10;
        r15 = this.dependencyOriginalTranslationY;
    L10:
        ObjectAnimator r22 = ObjectAnimator.ofFloat(r10, r21, new float[]{r15});
        r17.apply(r20);
        r18.apply(r22);
        r14.add(r20);
        r14.add(r22);
    }

    @TargetApi(21)
    private void createElevationAnimation(View r5, @NonNull View r10, boolean r11, boolean r12, @NonNull FabTransformationSpec r13, @NonNull List<Animator> r14, List<Animator.AnimatorListener> r15) {
        float r16 = ViewCompat.getElevation(r10) - ViewCompat.getElevation(r5);
        if (r11 == false) goto L7;
        if (r12 == true) goto L6;
        r10.setTranslationZ(-r16);
    L6:
        ObjectAnimator r17 = ObjectAnimator.ofFloat(r10, View.TRANSLATION_Z, new float[]{0.0f});
    L8:
        r13.timings.getTiming("elevation").apply(r17);
        r14.add(r17);
        return;
    L7:
        r17 = ObjectAnimator.ofFloat(r10, View.TRANSLATION_Z, new float[]{-r16});
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void createExpansionAnimation(@NonNull View r18, View r19, boolean r20, boolean r21, @NonNull FabTransformationSpec r22, float r23, float r24, @NonNull List<Animator> r25, @NonNull List<Animator.AnimatorListener> r26) {
        if ((r19 instanceof CircularRevealWidget) == true) goto L5;
        return;
    L5:
        final CircularRevealWidget r12 = (CircularRevealWidget) r19;
        float r5 = calculateRevealCenterX(r18, r19, r22.positioning);
        float r11 = calculateRevealCenterY(r18, r19, r22.positioning);
        ((FloatingActionButton) r18).getContentRect(this.tmpRect);
        float r13 = this.tmpRect.width() / 2.0f;
        MotionTiming r14 = r22.timings.getTiming("expansion");
        if (r20 == false) goto L12;
        if (r21 == true) goto L9;
        r12.setRevealInfo(new CircularRevealWidget.RevealInfo(r5, r11, r13));
    L9:
        if (r21 == false) goto L11;
        r13 = r12.getRevealInfo().radius;
    L11:
        Animator r10 = CircularRevealCompat.createCircularReveal(r12, r5, r11, MathUtils.distanceToFurthestCorner(r5, r11, 0.0f, 0.0f, r23, r24));
        r10.addListener(new AnonymousClass4(this, r12));
        createPreFillRadialExpansion(r19, r14.getDelay(), (int) r5, (int) r11, r13, r25);
    L13:
        r14.apply(r10);
        r25.add(r10);
        r26.add(CircularRevealCompat.createCircularRevealListener(r12));
        return;
    L12:
        float r15 = r12.getRevealInfo().radius;
        Animator r16 = CircularRevealCompat.createCircularReveal(r12, r5, r11, r13);
        int r17 = (int) r5;
        int r110 = (int) r11;
        createPreFillRadialExpansion(r19, r14.getDelay(), r17, r110, r15, r25);
        createPostFillRadialExpansion(r19, r14.getDelay(), r14.getDuration(), r22.timings.getTotalDuration(), r17, r110, r13, r25);
        r10 = r16;
        goto L13
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void createIconFadeAnimation(View r5, final View r10, boolean r11, boolean r12, @NonNull FabTransformationSpec r13, @NonNull List<Animator> r14, @NonNull List<Animator.AnimatorListener> r15) {
        if ((r10 instanceof CircularRevealWidget) == true) goto L5;
        return;
    L5:
        if ((r5 instanceof ImageView) == false) goto L19;
        final CircularRevealWidget r16 = (CircularRevealWidget) r10;
        final Drawable r17 = ((ImageView) r5).getDrawable();
        if (r17 != null) goto L10;
        return;
    L10:
        r17.mutate();
        if (r11 == false) goto L15;
        if (r12 == true) goto L14;
        r17.setAlpha(255);
    L14:
        ObjectAnimator r18 = ObjectAnimator.ofInt(r17, DrawableAlphaProperty.DRAWABLE_ALPHA_COMPAT, new int[]{0});
    L16:
        r18.addUpdateListener(new AnonymousClass2(this, r10));
        r13.timings.getTiming("iconFade").apply(r18);
        r14.add(r18);
        r15.add(new AnonymousClass3(this, r16, r17));
        return;
    L15:
        r18 = ObjectAnimator.ofInt(r17, DrawableAlphaProperty.DRAWABLE_ALPHA_COMPAT, new int[]{255});
        goto L16
    }

    private void createPostFillRadialExpansion(View r5, long r10, long r11, long r12, int r13, int r14, float r15, @NonNull List<Animator> r16) {
        long r17 = r10 + r11;
        if (r17 >= r12) goto L6;
        Animator r18 = ViewAnimationUtils.createCircularReveal(r5, r13, r14, r15, r15);
        r18.setStartDelay(r17);
        r18.setDuration(r12 - r17);
        r16.add(r18);
        return;
    }

    private void createPreFillRadialExpansion(View r5, long r10, int r11, int r12, float r13, @NonNull List<Animator> r14) {
        if (r10 <= 0) goto L6;
        Animator r15 = ViewAnimationUtils.createCircularReveal(r5, r11, r12, r13, r13);
        r15.setStartDelay(0);
        r15.setDuration(r10);
        r14.add(r15);
        return;
    }

    private void createTranslationAnimation(@NonNull View r16, @NonNull View r17, boolean r18, boolean r19, @NonNull FabTransformationSpec r20, @NonNull List<Animator> r21, List<Animator.AnimatorListener> r22, @NonNull RectF r23) {
        float r10 = calculateTranslationX(r16, r17, r20.positioning);
        float r5 = calculateTranslationY(r16, r17, r20.positioning);
        Pair<MotionTiming, MotionTiming> r11 = calculateMotionTiming(r10, r5, r18, r20);
        MotionTiming r12 = (MotionTiming) r11.first;
        MotionTiming r13 = (MotionTiming) r11.second;
        if (r18 == false) goto L7;
        if (r19 == true) goto L6;
        r17.setTranslationX(-r10);
        r17.setTranslationY(-r5);
    L6:
        ObjectAnimator r14 = ObjectAnimator.ofFloat(r17, View.TRANSLATION_X, new float[]{0.0f});
        ObjectAnimator r15 = ObjectAnimator.ofFloat(r17, View.TRANSLATION_Y, new float[]{0.0f});
        calculateChildVisibleBoundsAtEndOfExpansion(r17, r20, r12, r13, -r10, -r5, 0.0f, 0.0f, r23);
    L8:
        r12.apply(r14);
        r13.apply(r15);
        r21.add(r14);
        r21.add(r15);
        return;
    L7:
        r14 = ObjectAnimator.ofFloat(r17, View.TRANSLATION_X, new float[]{-r10});
        r15 = ObjectAnimator.ofFloat(r17, View.TRANSLATION_Y, new float[]{-r5});
        goto L8
    }

    private int getBackgroundTint(@NonNull View r5) {
        ColorStateList r10 = ViewCompat.getBackgroundTintList(r5);
        if (r10 != null) goto L5;
        return 0;
    L5:
        return r10.getColorForState(r5.getDrawableState(), r10.getDefaultColor());
    }

    @Nullable
    private ViewGroup toViewGroupOrNull(View r5) {
        if ((r5 instanceof ViewGroup) == true) goto L5;
        return null;
    L5:
        return (ViewGroup) r5;
    }

    @Override // com.google.android.material.transformation.ExpandableBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    @CallSuper
    public boolean layoutDependsOn(@NonNull CoordinatorLayout r5, @NonNull View r10, @NonNull View r11) {
        if (r10.getVisibility() == 8) goto L13;
        if ((r11 instanceof FloatingActionButton) == false) goto L14;
        int r12 = ((FloatingActionButton) r11).getExpandedComponentIdHint();
        if (r12 != 0) goto L9;
    L10:
        return true;
    L9:
        if (r12 == r10.getId()) goto L10;
        return false;
    L14:
        return false;
    L13:
        throw new IllegalStateException("This behavior cannot be attached to a GONE view. Set the view to INVISIBLE instead.");
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    @CallSuper
    public void onAttachedToLayoutParams(@NonNull CoordinatorLayout.LayoutParams r5) {
        if (r5.dodgeInsetEdges != 0) goto L6;
        r5.dodgeInsetEdges = 80;
        return;
    }

    @Override // com.google.android.material.transformation.ExpandableTransformationBehavior
    @NonNull
    public AnimatorSet onCreateExpandedStateChangeAnimation(@NonNull final View r16, @NonNull final View r17, final boolean r18, boolean r19) {
        FabTransformationSpec r12 = onCreateMotionSpec(r17.getContext(), r18);
        if (r18 == false) goto L5;
        this.dependencyOriginalTranslationX = r16.getTranslationX();
        this.dependencyOriginalTranslationY = r16.getTranslationY();
    L5:
        List<Animator> r13 = new ArrayList();
        ArrayList r14 = new ArrayList();
        createElevationAnimation(r16, r17, r18, r19, r12, r13, r14);
        RectF r10 = this.tmpRectF1;
        createTranslationAnimation(r16, r17, r18, r19, r12, r13, r14, r10);
        float r11 = r10.width();
        float r15 = r10.height();
        createDependencyTranslationAnimation(r16, r17, r18, r12, r13);
        createIconFadeAnimation(r16, r17, r18, r19, r12, r13, r14);
        createExpansionAnimation(r16, r17, r18, r19, r12, r11, r15, r13, r14);
        createColorAnimation(r16, r17, r18, r19, r12, r13, r14);
        createChildrenFadeAnimation(r16, r17, r18, r19, r12, r13, r14);
        AnimatorSet r5 = new AnimatorSet();
        AnimatorSetCompat.playTogether(r5, r13);
        r5.addListener(new AnonymousClass1(this, r18, r17, r16));
        int r20 = r14.size();
        int r21 = 0;
    L6:
        if (r21 >= r20) goto L8;
        r5.addListener((Animator.AnimatorListener) r14.get(r21));
        r21 = r21 + 1;
        goto L6
    L8:
        return r5;
    }

    public abstract FabTransformationSpec onCreateMotionSpec(Context r5, boolean r10);

    public FabTransformationBehavior(Context r5, AttributeSet r10) {
        super(r5, r10);
        this.tmpRect = new Rect();
        this.tmpRectF1 = new RectF();
        this.tmpRectF2 = new RectF();
        this.tmpArray = new int[2];
    }
}
