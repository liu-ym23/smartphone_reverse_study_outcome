package com.google.android.material.transformation;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
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
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.google.android.material.a.d;
import com.google.android.material.a.e;
import com.google.android.material.a.h;
import com.google.android.material.a.i;
import com.google.android.material.a.j;
import com.google.android.material.circularreveal.b;
import com.google.android.material.circularreveal.c;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
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

    protected static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public h f4225a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public j f4226b;

        public a() {
        }
    }

    public FabTransformationBehavior() {
        this.tmpRect = new Rect();
        this.tmpRectF1 = new RectF();
        this.tmpRectF2 = new RectF();
        this.tmpArray = new int[2];
    }

    public FabTransformationBehavior(Context r3, AttributeSet r4) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin"));
        this.tmpRect = new Rect();
        this.tmpRectF1 = new RectF();
        this.tmpRectF2 = new RectF();
        this.tmpArray = new int[2];
    }

    private ViewGroup calculateChildContentContainer(View r4) {
        View r0 = r4.findViewById(ZeusTransformUtils.mapRes(R.id.mtrl_child_content_container, OaidModel.KEY_ID, "mtrl_child_content_container"));
        if (r0 == null) goto L7;
        return toViewGroupOrNull(r0);
    L7:
        if (ZeusTransformUtils.instanceOf(r4, TransformationChildLayout.class) == true) goto L14;
        if (ZeusTransformUtils.instanceOf(r4, TransformationChildCard.class) == true) goto L14;
        return toViewGroupOrNull(r4);
    L14:
        return toViewGroupOrNull(((ViewGroup) ZeusTransformUtils.preCheckCast(r4, ViewGroup.class, "com.obric.memorydata.plugin")).getChildAt(0));
    }

    private void calculateChildVisibleBoundsAtEndOfExpansion(View r1, a r2, i r3, i r4, float r5, float r6, float r7, float r8, RectF r9) {
        float r10 = calculateValueOfAnimationAtEndOfExpansion(r2, r3, r5, r7);
        float r11 = calculateValueOfAnimationAtEndOfExpansion(r2, r4, r6, r8);
        Rect r12 = this.tmpRect;
        r1.getWindowVisibleDisplayFrame(r12);
        RectF r13 = this.tmpRectF1;
        r13.set(r12);
        RectF r14 = this.tmpRectF2;
        calculateWindowBounds(r1, r14);
        r14.offset(r10, r11);
        r14.intersect(r13);
        r9.set(r14);
    }

    private void calculateDependencyWindowBounds(View r1, RectF r2) {
        calculateWindowBounds(r1, r2);
        r2.offset(this.dependencyOriginalTranslationX, this.dependencyOriginalTranslationY);
    }

    private Pair<i, i> calculateMotionTiming(float r1, float r2, boolean r3, a r4) {
        if (r1 != 0.0f) goto L5;
    L14:
        i r0 = r4.f4225a.b("translationXLinear");
        h r5 = r4.f4225a;
        String r6 = "translationYLinear";
    L16:
        return new Pair(r0, r5.b(r6));
    L5:
        if (r2 == 0.0f) goto L14;
        if (r3 == true) goto L9;
    L10:
        if (r3 == true) goto L13;
        if (r2 <= 0.0f) goto L13;
    L12:
        r0 = r4.f4225a.b("translationXCurveUpwards");
        r5 = r4.f4225a;
        r6 = "translationYCurveUpwards";
    L13:
        r0 = r4.f4225a.b("translationXCurveDownwards");
        r5 = r4.f4225a;
        r6 = "translationYCurveDownwards";
        goto L16
    L9:
        if (r2 < 0.0f) goto L12;
        goto L10
    }

    private float calculateRevealCenterX(View r3, View r4, j r5) {
        RectF r0 = this.tmpRectF1;
        RectF r1 = this.tmpRectF2;
        calculateDependencyWindowBounds(r3, r0);
        calculateWindowBounds(r4, r1);
        r1.offset(-calculateTranslationX(r3, r4, r5), 0.0f);
        return r0.centerX() - r1.left;
    }

    private float calculateRevealCenterY(View r3, View r4, j r5) {
        RectF r0 = this.tmpRectF1;
        RectF r1 = this.tmpRectF2;
        calculateDependencyWindowBounds(r3, r0);
        calculateWindowBounds(r4, r1);
        r1.offset(0.0f, -calculateTranslationY(r3, r4, r5));
        return r0.centerY() - r1.top;
    }

    private float calculateTranslationX(View r3, View r4, j r5) {
        RectF r0 = this.tmpRectF1;
        RectF r1 = this.tmpRectF2;
        calculateDependencyWindowBounds(r3, r0);
        calculateWindowBounds(r4, r1);
        int r2 = r5.f3754a & 7;
        if (r2 != 1) goto L5;
        float r6 = r1.centerX();
        float r7 = r0.centerX();
    L12:
        float r8 = r6 - r7;
    L14:
        return r8 + r5.f3755b;
    L5:
        if (r2 != 3) goto L7;
        r6 = r1.left;
        r7 = r0.left;
        goto L12
    L7:
        if (r2 == 5) goto L9;
        r8 = 0.0f;
        goto L14
    L9:
        r6 = r1.right;
        r7 = r0.right;
        goto L12
    }

    private float calculateTranslationY(View r3, View r4, j r5) {
        RectF r0 = this.tmpRectF1;
        RectF r1 = this.tmpRectF2;
        calculateDependencyWindowBounds(r3, r0);
        calculateWindowBounds(r4, r1);
        int r2 = r5.f3754a & 112;
        if (r2 != 16) goto L5;
        float r6 = r1.centerY();
        float r7 = r0.centerY();
    L12:
        float r8 = r6 - r7;
    L14:
        return r8 + r5.c;
    L5:
        if (r2 != 48) goto L7;
        r6 = r1.top;
        r7 = r0.top;
        goto L12
    L7:
        if (r2 == 80) goto L9;
        r8 = 0.0f;
        goto L14
    L9:
        r6 = r1.bottom;
        r7 = r0.bottom;
        goto L12
    }

    private float calculateValueOfAnimationAtEndOfExpansion(a r7, i r8, float r9, float r10) {
        long r0 = r8.a();
        long r2 = r8.b();
        i r6 = r7.f4225a.b("expansion");
        return com.google.android.material.a.a.a(r9, r10, r8.c().getInterpolation((((r6.a() + r6.b()) + 17) - r0) / r2));
    }

    private void calculateWindowBounds(View r4, RectF r5) {
        r5.set(0.0f, 0.0f, r4.getWidth(), r4.getHeight());
        int[] r3 = this.tmpArray;
        r4.getLocationInWindow(r3);
        r5.offsetTo(r3[0], r3[1]);
        r5.offset((int) (-r4.getTranslationX()), (int) (-r4.getTranslationY()));
    }

    private void createChildrenFadeAnimation(View r2, View r3, boolean r4, boolean r5, a r6, List<Animator> r7, List<Animator.AnimatorListener> r8) {
        List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
        List r10 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r3, ViewGroup.class) == true) goto L6;
        return;
    L6:
        if (ZeusTransformUtils.instanceOf(r3, c.class) == true) goto L8;
    L10:
        ViewGroup r1 = calculateChildContentContainer(r3);
        if (r1 != null) goto L14;
        return;
    L14:
        if (r4 == false) goto L18;
        if (r5 == true) goto L17;
        d.f3744a.set(r1, Float.valueOf(0.0f));
    L17:
        ObjectAnimator r11 = ObjectAnimator.ofFloat(r1, d.f3744a, new float[]{1.0f});
    L19:
        r6.f4225a.b("contentFade").a(r11);
        r9.add(r11);
        return;
    L18:
        r11 = ObjectAnimator.ofFloat(r1, d.f3744a, new float[]{0.0f});
        goto L19
    L8:
        if (b.f3842a != 0) goto L10;
    }

    private void createColorAnimation(View r3, View r4, boolean r5, boolean r6, a r7, List<Animator> r8, List<Animator.AnimatorListener> r9) {
        List r10 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin");
        List r11 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r4, c.class) == true) goto L5;
        return;
    L5:
        c r12 = (c) ZeusTransformUtils.preCheckCast(r4, c.class, "com.obric.memorydata.plugin");
        int r2 = getBackgroundTint(r3);
        int r13 = 16777215 & r2;
        if (r5 == false) goto L10;
        if (r6 == true) goto L9;
        r12.setCircularRevealScrimColor(r2);
    L9:
        ObjectAnimator r14 = ObjectAnimator.ofInt(r12, c.C0183c.f3847a, new int[]{r13});
    L11:
        r14.setEvaluator(com.google.android.material.a.c.a());
        r7.f4225a.b(TypedValues.Custom.S_COLOR).a(r14);
        r10.add(r14);
        return;
    L10:
        r14 = ObjectAnimator.ofInt(r12, c.C0183c.f3847a, new int[]{r2});
        goto L11
    }

    private void createDependencyTranslationAnimation(View r7, View r8, boolean r9, a r10, List<Animator> r11) {
        List r12 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.memorydata.plugin");
        float r0 = calculateTranslationX(r7, r8, r10.f4226b);
        float r13 = calculateTranslationY(r7, r8, r10.f4226b);
        Pair<i, i> r14 = calculateMotionTiming(r0, r13, r9, r10);
        i r2 = (i) ZeusTransformUtils.preCheckCast(r14.first, i.class, "com.obric.memorydata.plugin");
        i r15 = (i) ZeusTransformUtils.preCheckCast(r14.second, i.class, "com.obric.memorydata.plugin");
        Property r1 = View.TRANSLATION_X;
        float[] r4 = new float[1];
        if (r9 == true) goto L6;
        r0 = this.dependencyOriginalTranslationX;
    L6:
        r4[0] = r0;
        ObjectAnimator r3 = ObjectAnimator.ofFloat(r7, r1, r4);
        Property r5 = View.TRANSLATION_Y;
        float[] r6 = new float[1];
        if (r9 == true) goto L10;
        r13 = this.dependencyOriginalTranslationY;
    L10:
        r6[0] = r13;
        ObjectAnimator r16 = ObjectAnimator.ofFloat(r7, r5, r6);
        r2.a(r3);
        r15.a(r16);
        r12.add(r3);
        r12.add(r16);
    }

    private void createElevationAnimation(View r2, View r3, boolean r4, boolean r5, a r6, List<Animator> r7, List<Animator.AnimatorListener> r8) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
        List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin");
        float r10 = ViewCompat.getElevation(r3) - ViewCompat.getElevation(r2);
        if (r4 == false) goto L7;
        if (r5 == true) goto L6;
        r3.setTranslationZ(-r10);
    L6:
        ObjectAnimator r11 = ObjectAnimator.ofFloat(r3, View.TRANSLATION_Z, new float[]{0.0f});
    L8:
        r6.f4225a.b("elevation").a(r11);
        r1.add(r11);
        return;
    L7:
        r11 = ObjectAnimator.ofFloat(r3, View.TRANSLATION_Z, new float[]{-r10});
        goto L8
    }

    private void createExpansionAnimation(View r22, View r23, boolean r24, boolean r25, a r26, float r27, float r28, List<Animator> r29, List<Animator.AnimatorListener> r30) {
        List<Animator> r12 = (List) ZeusTransformUtils.wrapperContextForParams(r29, List.class, "com.obric.memorydata.plugin");
        List r13 = (List) ZeusTransformUtils.wrapperContextForParams(r30, List.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r23, c.class) == true) goto L5;
        return;
    L5:
        final c r14 = (c) ZeusTransformUtils.preCheckCast(r23, c.class, "com.obric.memorydata.plugin");
        float r1 = calculateRevealCenterX(r22, r23, r26.f4226b);
        float r3 = calculateRevealCenterY(r22, r23, r26.f4226b);
        ((FloatingActionButton) ZeusTransformUtils.preCheckCast(r22, FloatingActionButton.class, "com.obric.memorydata.plugin")).getContentRect(this.tmpRect);
        float r11 = this.tmpRect.width() / 2.0f;
        i r7 = r26.f4225a.b("expansion");
        if (r24 == false) goto L13;
        if (r25 == true) goto L9;
        r14.setRevealInfo(new c.d(r1, r3, r11));
    L9:
        if (r25 == false) goto L11;
        float r6 = r14.getRevealInfo().c;
    L12:
        Animator r10 = com.google.android.material.circularreveal.a.a(r14, r1, r3, com.google.android.material.f.a.a(r1, r3, 0.0f, 0.0f, r27, r28));
        r10.addListener(new AnonymousClass4(this, r14));
        i r15 = r7;
        createPreFillRadialExpansion(r23, r7.a(), (int) r1, (int) r3, r6, r12);
    L14:
        r15.a(r10);
        r12.add(r10);
        r13.add(com.google.android.material.circularreveal.a.a(r14));
        return;
    L11:
        r6 = r11;
        goto L12
    L13:
        r15 = r7;
        float r8 = r14.getRevealInfo().c;
        Animator r16 = com.google.android.material.circularreveal.a.a(r14, r1, r3, r11);
        int r9 = (int) r1;
        int r2 = (int) r3;
        createPreFillRadialExpansion(r23, r15.a(), r9, r2, r8, r12);
        createPostFillRadialExpansion(r23, r15.a(), r15.b(), r26.f4225a.a(), r9, r2, r11, r12);
        r10 = r16;
        goto L14
    }

    private void createIconFadeAnimation(View r5, final View r6, boolean r7, boolean r8, a r9, List<Animator> r10, List<Animator.AnimatorListener> r11) {
        List r12 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.memorydata.plugin");
        List r13 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r6, c.class) == true) goto L5;
        return;
    L5:
        if (ZeusTransformUtils.instanceOf(r5, ImageView.class) == false) goto L19;
        final c r0 = (c) ZeusTransformUtils.preCheckCast(r6, c.class, "com.obric.memorydata.plugin");
        final Drawable r14 = ((ImageView) ZeusTransformUtils.preCheckCast(r5, ImageView.class, "com.obric.memorydata.plugin")).getDrawable();
        if (r14 != null) goto L10;
        return;
    L10:
        r14.mutate();
        if (r7 == false) goto L15;
        if (r8 == true) goto L14;
        r14.setAlpha(255);
    L14:
        ObjectAnimator r15 = ObjectAnimator.ofInt(r14, e.f3745a, new int[]{0});
    L16:
        r15.addUpdateListener(new AnonymousClass2(this, r6));
        r9.f4225a.b("iconFade").a(r15);
        r12.add(r15);
        r13.add(new AnonymousClass3(this, r0, r14));
        return;
    L15:
        r15 = ObjectAnimator.ofInt(r14, e.f3745a, new int[]{255});
        goto L16
    }

    private void createPostFillRadialExpansion(View r2, long r3, long r5, long r7, int r9, int r10, float r11, List<Animator> r12) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT < 21) goto L8;
        long r4 = r3 + r5;
        if (r4 >= r7) goto L9;
        Animator r6 = ViewAnimationUtils.createCircularReveal(r2, r9, r10, r11, r11);
        r6.setStartDelay(r4);
        r6.setDuration(r7 - r4);
        r1.add(r6);
        return;
    L9:
        return;
    }

    private void createPreFillRadialExpansion(View r3, long r4, int r6, int r7, float r8, List<Animator> r9) {
        List r2 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT >= 21) goto L5;
        return;
    L5:
        if (r4 <= 0) goto L9;
        Animator r5 = ViewAnimationUtils.createCircularReveal(r3, r6, r7, r8, r8);
        r5.setStartDelay(0);
        r5.setDuration(r4);
        r2.add(r5);
        return;
    }

    private void createTranslationAnimation(View r16, View r17, boolean r18, boolean r19, a r20, List<Animator> r21, List<Animator.AnimatorListener> r22, RectF r23) {
        List r10 = (List) ZeusTransformUtils.wrapperContextForParams(r21, List.class, "com.obric.memorydata.plugin");
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r22, List.class, "com.obric.memorydata.plugin");
        float r6 = calculateTranslationX(r16, r17, r20.f4226b);
        float r1 = calculateTranslationY(r16, r17, r20.f4226b);
        Pair<i, i> r7 = calculateMotionTiming(r6, r1, r18, r20);
        i r11 = (i) ZeusTransformUtils.preCheckCast(r7.first, i.class, "com.obric.memorydata.plugin");
        i r12 = (i) ZeusTransformUtils.preCheckCast(r7.second, i.class, "com.obric.memorydata.plugin");
        if (r18 == false) goto L7;
        if (r19 == true) goto L6;
        r17.setTranslationX(-r6);
        r17.setTranslationY(-r1);
    L6:
        ObjectAnimator r13 = ObjectAnimator.ofFloat(r17, View.TRANSLATION_X, new float[]{0.0f});
        ObjectAnimator r14 = ObjectAnimator.ofFloat(r17, View.TRANSLATION_Y, new float[]{0.0f});
        calculateChildVisibleBoundsAtEndOfExpansion(r17, r20, r11, r12, -r6, -r1, 0.0f, 0.0f, r23);
    L8:
        r11.a(r13);
        r12.a(r14);
        r10.add(r13);
        r10.add(r14);
        return;
    L7:
        r13 = ObjectAnimator.ofFloat(r17, View.TRANSLATION_X, new float[]{-r6});
        r14 = ObjectAnimator.ofFloat(r17, View.TRANSLATION_Y, new float[]{-r1});
        goto L8
    }

    private int getBackgroundTint(View r2) {
        ColorStateList r1 = ViewCompat.getBackgroundTintList(r2);
        if (r1 != null) goto L5;
        return 0;
    L5:
        return r1.getColorForState(r2.getDrawableState(), r1.getDefaultColor());
    }

    private ViewGroup toViewGroupOrNull(View r2) {
        if (ZeusTransformUtils.instanceOf(r2, ViewGroup.class) == true) goto L5;
        return null;
    L5:
        return (ViewGroup) ZeusTransformUtils.preCheckCast(r2, ViewGroup.class, "com.obric.memorydata.plugin");
    }

    @Override // com.google.android.material.transformation.ExpandableBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean layoutDependsOn(CoordinatorLayout r2, View r3, View r4) {
        if (r3.getVisibility() == 8) goto L13;
        if (ZeusTransformUtils.instanceOf(r4, FloatingActionButton.class) == false) goto L14;
        int r1 = ((FloatingActionButton) ZeusTransformUtils.preCheckCast(r4, FloatingActionButton.class, "com.obric.memorydata.plugin")).getExpandedComponentIdHint();
        if (r1 != 0) goto L9;
    L10:
        return true;
    L9:
        if (r1 == r3.getId()) goto L10;
        return false;
    L14:
        return false;
    L13:
        throw new IllegalStateException("This behavior cannot be attached to a GONE view. Set the view to INVISIBLE instead.");
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onAttachedToLayoutParams(CoordinatorLayout.LayoutParams r1) {
        if (r1.dodgeInsetEdges != 0) goto L6;
        r1.dodgeInsetEdges = 80;
        return;
    }

    @Override // com.google.android.material.transformation.ExpandableTransformationBehavior
    public AnimatorSet onCreateExpandedStateChangeAnimation(final View r17, final View r18, final boolean r19, boolean r20) {
        a r13 = onCreateMotionSpec((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r18.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r19);
        if (r19 == false) goto L5;
        this.dependencyOriginalTranslationX = r17.getTranslationX();
        this.dependencyOriginalTranslationY = r17.getTranslationY();
    L5:
        ArrayList r14 = new ArrayList();
        ArrayList r15 = new ArrayList();
        if (Build.VERSION.SDK_INT < 21) goto L8;
        createElevationAnimation(r17, r18, r19, r20, r13, r14, r15);
    L8:
        RectF r9 = this.tmpRectF1;
        createTranslationAnimation(r17, r18, r19, r20, r13, r14, r15, r9);
        float r8 = r9.width();
        float r10 = r9.height();
        createDependencyTranslationAnimation(r17, r18, r19, r13, r14);
        createIconFadeAnimation(r17, r18, r19, r20, r13, r14, r15);
        createExpansionAnimation(r17, r18, r19, r20, r13, r8, r10, r14, r15);
        createColorAnimation(r17, r18, r19, r20, r13, r14, r15);
        createChildrenFadeAnimation(r17, r18, r19, r20, r13, r14, r15);
        AnimatorSet r0 = new AnimatorSet();
        com.google.android.material.a.b.a(r0, r14);
        r0.addListener(new AnonymousClass1(this, r19, r18, r17));
        int r1 = 0;
        int r2 = r15.size();
    L9:
        if (r1 >= r2) goto L11;
        r0.addListener((Animator.AnimatorListener) ZeusTransformUtils.preCheckCast(r15.get(r1), Animator.AnimatorListener.class, "com.obric.memorydata.plugin"));
        r1 = r1 + 1;
        goto L9
    L11:
        return r0;
    }

    public abstract a onCreateMotionSpec(Context r1, boolean r2);
}
