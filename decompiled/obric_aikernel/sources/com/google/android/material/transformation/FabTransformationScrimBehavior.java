package com.google.android.material.transformation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;
import java.util.List;
import r5.b;
import r5.i;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public class FabTransformationScrimBehavior extends ExpandableTransformationBehavior {
    public static final long COLLAPSE_DELAY = 0;
    public static final long COLLAPSE_DURATION = 150;
    public static final long EXPAND_DELAY = 75;
    public static final long EXPAND_DURATION = 150;
    private final i collapseTiming;
    private final i expandTiming;

    class a extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f4095c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ View f4096g;

        a(FabTransformationScrimBehavior r10, boolean r11, View r12) {
            this.f4095c = r11;
            this.f4096g = r12;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator r10) {
            if (this.f4095c == true) goto L6;
            this.f4096g.setVisibility(4);
            return;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator r10) {
            if (this.f4095c == false) goto L6;
            this.f4096g.setVisibility(0);
            return;
        }
    }

    public FabTransformationScrimBehavior() {
        this.expandTiming = new i(75, 150);
        this.collapseTiming = new i(0, 150);
    }

    public FabTransformationScrimBehavior(Context r10, AttributeSet r11) {
        super(r10, r11);
        this.expandTiming = new i(75, 150);
        this.collapseTiming = new i(0, 150);
    }

    private void createScrimAnimation(@NonNull View r10, boolean r11, boolean r12, @NonNull List<Animator> r13, List<Animator.AnimatorListener> r14) {
        if (r11 == false) goto L4;
        i r15 = this.expandTiming;
    L6:
        if (r11 == false) goto L10;
        if (r12 == true) goto L9;
        r10.setAlpha(0.0f);
    L9:
        ObjectAnimator r16 = ObjectAnimator.ofFloat(r10, View.ALPHA, new float[]{1.0f});
    L11:
        r15.a(r16);
        r13.add(r16);
        return;
    L10:
        r16 = ObjectAnimator.ofFloat(r10, View.ALPHA, new float[]{0.0f});
        goto L11
    L4:
        r15 = this.collapseTiming;
        goto L6
    }

    @Override // com.google.android.material.transformation.ExpandableBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean layoutDependsOn(CoordinatorLayout r10, View r11, View r12) {
        return r12 instanceof FloatingActionButton;
    }

    @Override // com.google.android.material.transformation.ExpandableTransformationBehavior
    @NonNull
    protected AnimatorSet onCreateExpandedStateChangeAnimation(@NonNull View r10, @NonNull View r11, boolean r12, boolean r13) {
        ArrayList r14 = new ArrayList();
        createScrimAnimation(r11, r12, r13, r14, new ArrayList());
        AnimatorSet r15 = new AnimatorSet();
        b.a(r15, r14);
        r15.addListener(new a(this, r12, r11));
        return r15;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onTouchEvent(@NonNull CoordinatorLayout r10, @NonNull View r11, @NonNull MotionEvent r12) {
        return super.onTouchEvent(r10, r11, r12);
    }
}
