package com.google.android.material.transformation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import h9.h;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class FabTransformationScrimBehavior extends ExpandableTransformationBehavior {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final h f5176c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final h f5177d;

    public class a extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f5178a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f5179b;

        public a(boolean r8, View r10) {
            this.f5178a = r8;
            this.f5179b = r10;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r8) {
            if (this.f5178a == true) goto L6;
            this.f5179b.setVisibility(4);
            return;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r8) {
            if (this.f5178a == false) goto L6;
            this.f5179b.setVisibility(0);
            return;
        }
    }

    public FabTransformationScrimBehavior() {
        this.f5176c = new h(75);
        this.f5177d = new h(0);
    }

    @Override // com.google.android.material.transformation.ExpandableBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public final boolean b(CoordinatorLayout r8, View r10, View r11) {
        return r11 instanceof FloatingActionButton;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public final boolean x(CoordinatorLayout r8, View r10, MotionEvent r11) {
        return false;
    }

    @Override // com.google.android.material.transformation.ExpandableTransformationBehavior
    public final AnimatorSet z(View r8, View r10, boolean r11, boolean r12) {
        ArrayList r13 = new ArrayList();
        new ArrayList();
        if (r11 == false) goto L5;
        h r14 = this.f5176c;
    L7:
        if (r11 == false) goto L11;
        if (r12 == true) goto L10;
        r10.setAlpha(0.0f);
    L10:
        ObjectAnimator r15 = ObjectAnimator.ofFloat(r10, View.ALPHA, new float[]{1.0f});
    L12:
        r14.a(r15);
        r13.add(r15);
        AnimatorSet r16 = new AnimatorSet();
        t2.b.R(r16, r13);
        r16.addListener(new a(r11, r10));
        return r16;
    L11:
        r15 = ObjectAnimator.ofFloat(r10, View.ALPHA, new float[]{0.0f});
        goto L12
    L5:
        r14 = this.f5177d;
        goto L7
    }

    public FabTransformationScrimBehavior(Context r8, AttributeSet r10) {
        super(r8, r10);
        this.f5176c = new h(75);
        this.f5177d = new h(0);
    }
}
