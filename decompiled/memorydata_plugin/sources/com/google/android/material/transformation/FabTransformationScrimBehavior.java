package com.google.android.material.transformation;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.a.b;
import com.google.android.material.a.i;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public class FabTransformationScrimBehavior extends ExpandableTransformationBehavior {
    public static final long COLLAPSE_DELAY = 0;
    public static final long COLLAPSE_DURATION = 150;
    public static final long EXPAND_DELAY = 75;
    public static final long EXPAND_DURATION = 150;
    private final i collapseTiming;
    private final i expandTiming;

    public FabTransformationScrimBehavior() {
        this.expandTiming = new i(75, 150);
        this.collapseTiming = new i(0, 150);
    }

    public FabTransformationScrimBehavior(Context r5, AttributeSet r6) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r6, AttributeSet.class, "com.obric.memorydata.plugin"));
        this.expandTiming = new i(75, 150);
        this.collapseTiming = new i(0, 150);
    }

    private void createScrimAnimation(View r3, boolean r4, boolean r5, List<Animator> r6, List<Animator.AnimatorListener> r7) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
        if (r4 == false) goto L5;
        i r2 = this.expandTiming;
    L7:
        if (r4 == false) goto L11;
        if (r5 == true) goto L10;
        r3.setAlpha(0.0f);
    L10:
        ObjectAnimator r10 = ObjectAnimator.ofFloat(r3, View.ALPHA, new float[]{1.0f});
    L12:
        r2.a(r10);
        r8.add(r10);
        return;
    L11:
        r10 = ObjectAnimator.ofFloat(r3, View.ALPHA, new float[]{0.0f});
        goto L12
    L5:
        r2 = this.collapseTiming;
        goto L7
    }

    @Override // com.google.android.material.transformation.ExpandableBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean layoutDependsOn(CoordinatorLayout r1, View r2, View r3) {
        return ZeusTransformUtils.instanceOf(r3, FloatingActionButton.class);
    }

    @Override // com.google.android.material.transformation.ExpandableTransformationBehavior
    public AnimatorSet onCreateExpandedStateChangeAnimation(View r7, final View r8, final boolean r9, boolean r10) {
        ArrayList r11 = new ArrayList();
        createScrimAnimation(r8, r9, r10, r11, new ArrayList());
        AnimatorSet r12 = new AnimatorSet();
        b.a(r12, r11);
        r12.addListener(new AnonymousClass1(this, r9, r8));
        return r12;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onTouchEvent(CoordinatorLayout r1, View r2, MotionEvent r3) {
        return super.onTouchEvent(r1, r2, r3);
    }
}
