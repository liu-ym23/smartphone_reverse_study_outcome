package com.google.android.material.transformation;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.animation.AnimatorSetCompat;
import com.google.android.material.animation.MotionTiming;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public class FabTransformationScrimBehavior extends ExpandableTransformationBehavior {
    public static final long COLLAPSE_DELAY = 0;
    public static final long COLLAPSE_DURATION = 150;
    public static final long EXPAND_DELAY = 75;
    public static final long EXPAND_DURATION = 150;
    private final MotionTiming collapseTiming;
    private final MotionTiming expandTiming;

    public FabTransformationScrimBehavior() {
        this.expandTiming = new MotionTiming(75, 150);
        this.collapseTiming = new MotionTiming(0, 150);
    }

    private void createScrimAnimation(@NonNull View r5, boolean r10, boolean r11, @NonNull List<Animator> r12, List<Animator.AnimatorListener> r13) {
        if (r10 == false) goto L5;
        MotionTiming r14 = this.expandTiming;
    L7:
        if (r10 == false) goto L11;
        if (r11 == true) goto L10;
        r5.setAlpha(0.0f);
    L10:
        ObjectAnimator r15 = ObjectAnimator.ofFloat(r5, View.ALPHA, new float[]{1.0f});
    L12:
        r14.apply(r15);
        r12.add(r15);
        return;
    L11:
        r15 = ObjectAnimator.ofFloat(r5, View.ALPHA, new float[]{0.0f});
        goto L12
    L5:
        r14 = this.collapseTiming;
        goto L7
    }

    @Override // com.google.android.material.transformation.ExpandableBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean layoutDependsOn(CoordinatorLayout r5, View r10, View r11) {
        return r11 instanceof FloatingActionButton;
    }

    @Override // com.google.android.material.transformation.ExpandableTransformationBehavior
    @NonNull
    public AnimatorSet onCreateExpandedStateChangeAnimation(@NonNull View r10, @NonNull final View r11, final boolean r12, boolean r13) {
        ArrayList r14 = new ArrayList();
        createScrimAnimation(r11, r12, r13, r14, new ArrayList());
        AnimatorSet r15 = new AnimatorSet();
        AnimatorSetCompat.playTogether(r15, r14);
        r15.addListener(new AnonymousClass1(this, r12, r11));
        return r15;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onTouchEvent(@NonNull CoordinatorLayout r5, @NonNull View r10, @NonNull MotionEvent r11) {
        return super.onTouchEvent(r5, r10, r11);
    }

    public FabTransformationScrimBehavior(Context r5, AttributeSet r10) {
        super(r5, r10);
        this.expandTiming = new MotionTiming(75, 150);
        this.collapseTiming = new MotionTiming(0, 150);
    }
}
