package com.ss.android.lark.keyboard.plugin.tool.aa.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TimeInterpolator;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import androidx.transition.Transition;
import androidx.transition.TransitionValues;
import androidx.transition.Visibility;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 !2\u00020\u0001:\u0002!\"B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J2\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J2\u0010\u0011\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000fH\u0016J\u0010\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000fH\u0016J\u0010\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000fH\u0002JB\u0010\u0017\u001a\u0004\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0006\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/ss/android/lark/keyboard/plugin/tool/aa/widget/KeyboardTransitionSlice;", "Landroidx/transition/Visibility;", "animationMode", "", "<init>", "(I)V", "interpolator", "Landroid/view/animation/DecelerateInterpolator;", "onAppear", "Landroid/animation/Animator;", "sceneRoot", "Landroid/view/ViewGroup;", "view", "Landroid/view/View;", "startValues", "Landroidx/transition/TransitionValues;", "endValues", "onDisappear", "captureStartValues", "", "transitionValues", "captureEndValues", "captureValues", "createAnimation", "values", "viewPos", "", "startY", "", "endY", "Landroid/animation/TimeInterpolator;", "transition", "Landroidx/transition/Transition;", "Companion", "TransitionPositionListener", "keyboard-biz-aa_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class KeyboardTransitionSlice extends Visibility {
    public final int a;
    public final DecelerateInterpolator b;

    public static final class a {
    }

    public static final class b extends AnimatorListenerAdapter implements Transition.TransitionListener {
        public final View a;
        public final View b;
        public final float c;
        public final int d;
        public int[] e;
        public float f;

        public final void onTransitionCancel(Transition r2) {
            Intrinsics.checkNotNullParameter(r2, "transition");
        }

        public final void onTransitionPause(Transition r2) {
            Intrinsics.checkNotNullParameter(r2, "transition");
        }

        public final void onTransitionResume(Transition r2) {
            Intrinsics.checkNotNullParameter(r2, "transition");
        }

        public final void onTransitionStart(Transition r2) {
            Intrinsics.checkNotNullParameter(r2, "transition");
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r3) {
            Intrinsics.checkNotNullParameter(r3, "animation");
            if (this.e != null) goto L5;
            this.e = new int[2];
        L5:
            int[] r4 = this.e;
            Intrinsics.checkNotNull(r4);
            r4[1] = MathKt.roundToInt(this.d + this.a.getTranslationY());
            this.b.setTag(2131389331, this.e);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
        public final void onAnimationPause(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animator");
            this.f = this.a.getTranslationY();
            this.a.setTranslationY(this.c);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
        public final void onAnimationResume(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animator");
            this.a.setTranslationY(this.f);
        }

        public final void onTransitionEnd(Transition r3) {
            Intrinsics.checkNotNullParameter(r3, "transition");
            this.a.setTranslationY(this.c);
            r3.removeListener(this);
        }

        public b(View r2, View r3, int r4, float r5) {
            Intrinsics.checkNotNullParameter(r2, "movingView");
            Intrinsics.checkNotNullParameter(r3, "viewInHierarchy");
            this.a = r2;
            this.b = r3;
            this.c = r5;
            this.d = r4 - MathKt.roundToInt(r2.getTranslationY());
            int[] r6 = (int[]) r3.getTag(2131389331);
            this.e = r6;
            if (r6 == null) goto L6;
            r3.setTag(2131389331, null);
            return;
        }
    }

    static {
    }

    public KeyboardTransitionSlice() {
        this.a = 1;
        this.b = new DecelerateInterpolator();
        setDuration(300);
    }

    public static void a(TransitionValues r2) {
        int[] r1 = new int[2];
        r2.view.getLocationOnScreen(r1);
        r2.values.put("keyboard_slide_screenPosition", r1);
    }

    public final void captureEndValues(TransitionValues r2) {
        Intrinsics.checkNotNullParameter(r2, "transitionValues");
        super.captureEndValues(r2);
        a(r2);
    }

    public final void captureStartValues(TransitionValues r2) {
        Intrinsics.checkNotNullParameter(r2, "transitionValues");
        super.captureStartValues(r2);
        a(r2);
    }

    public final Animator onAppear(ViewGroup r8, View r9, TransitionValues r10, TransitionValues r11) {
        if (r8 == null) goto L15;
        if (r9 == null) goto L17;
        if (r11 == null) goto L18;
        r9.setTranslationY(0.0f);
        float r4 = r9.getTranslationY();
        if (this.a != 1) goto L9;
        float r12 = r8.getHeight() + r4;
    L10:
        float r3 = r12;
        int[] r13 = (int[]) r11.values.get("keyboard_slide_screenPosition");
        if (r13 != null) goto L14;
        r13 = new int[2];
    L14:
        return b(r9, r11, r13, r3, r4, this.b, this);
    L9:
        r12 = r4 - r8.getHeight();
        goto L10
    L18:
        return null;
    L17:
        return null;
    L15:
        return null;
    }

    public final Animator onDisappear(ViewGroup r8, View r9, TransitionValues r10, TransitionValues r11) {
        if (r8 == null) goto L15;
        if (r9 == null) goto L17;
        if (r11 == null) goto L18;
        r9.setTranslationY(0.0f);
        float r3 = r9.getTranslationY();
        if (this.a != 1) goto L9;
        float r12 = r3 - r8.getHeight();
    L10:
        float r4 = r12;
        int[] r13 = (int[]) r11.values.get("keyboard_slide_screenPosition");
        if (r13 != null) goto L14;
        r13 = new int[2];
    L14:
        return b(r9, r11, r13, r3, r4, this.b, this);
    L9:
        r12 = r8.getHeight() + r3;
        goto L10
    L18:
        return null;
    L17:
        return null;
    L15:
        return null;
    }

    public static Animator b(View r6, TransitionValues r7, int[] r8, float r9, float r10, TimeInterpolator r11, Transition r12) {
        float r0 = r6.getTranslationY();
        int r13 = r8[1];
        int[] r2 = (int[]) r7.view.getTag(2131389331);
        if (r2 == null) goto L5;
        r9 = (r2[1] - r13) + r0;
    L5:
        int r14 = r13 + MathKt.roundToInt(r9 - r0);
        r6.setTranslationY(r9);
        if (r9 != r10) goto L8;
        boolean r3 = true;
    L9:
        if (r3 == false) goto L12;
        return null;
    L12:
        ObjectAnimator r15 = ObjectAnimator.ofPropertyValuesHolder(r6, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, new float[]{r9, r10})});
        b r16 = new b(r6, r7.view, r14, r0);
        r12.addListener(r16);
        r15.addListener(r16);
        r15.addPauseListener(r16);
        r15.setInterpolator(r11);
        return r15;
    L8:
        r3 = false;
        goto L9
    }
}
