package com.google.android.material.behavior;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.obric.cae.R;
import java.util.Iterator;
import java.util.LinkedHashSet;
import v9.d;

/* JADX INFO: loaded from: classes.dex */
public class HideBottomViewOnScrollBehavior<V extends View> extends CoordinatorLayout.c<V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedHashSet<b> f4342a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f4343b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f4344c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TimeInterpolator f4345d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public TimeInterpolator f4346e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f4347f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f4348g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f4349h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ViewPropertyAnimator f4350i;

    public class a extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ HideBottomViewOnScrollBehavior f4351a;

        public a(HideBottomViewOnScrollBehavior r8) {
            this.f4351a = r8;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r8) {
            this.f4351a.f4350i = null;
        }
    }

    public interface b {
        void a();
    }

    public HideBottomViewOnScrollBehavior() {
        this.f4342a = new LinkedHashSet();
        this.f4347f = 0;
        this.f4348g = 2;
        this.f4349h = 0;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean h(CoordinatorLayout r8, V r10, int r11) {
        ViewGroup.MarginLayoutParams r12 = (ViewGroup.MarginLayoutParams) r10.getLayoutParams();
        this.f4347f = r10.getMeasuredHeight() + r12.bottomMargin;
        this.f4343b = d.c(r10.getContext(), R.attr.motionDurationLong2, 225);
        this.f4344c = d.c(r10.getContext(), R.attr.motionDurationMedium4, 175);
        this.f4345d = d.d(r10.getContext(), R.attr.motionEasingEmphasizedInterpolator, h9.a.f7946d);
        this.f4346e = d.d(r10.getContext(), R.attr.motionEasingEmphasizedInterpolator, h9.a.f7945c);
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public final void p(CoordinatorLayout r8, V r10, View r11, int r12, int r13, int r14, int r15, int r16, int[] r17) {
        LinkedHashSet<b> r18 = this.f4342a;
        boolean r19 = false;
        if (r13 > 0) goto L5;
        if (r13 < 0) goto L19;
        return;
    L19:
        if (this.f4348g != 2) goto L21;
        r19 = true;
    L21:
        if (r19 == true) goto L37;
        ViewPropertyAnimator r20 = this.f4350i;
        if (r20 == null) goto L26;
        r20.cancel();
        r10.clearAnimation();
    L26:
        this.f4348g = 2;
        Iterator<b> r21 = r18.iterator();
    L28:
        if (r21.hasNext() == false) goto L30;
        r21.next().a();
        goto L28
    L30:
        y(r10, 0, this.f4343b, this.f4345d);
        return;
    L37:
        return;
    L5:
        if (this.f4348g != 1) goto L7;
        r19 = true;
    L7:
        if (r19 == true) goto L36;
        ViewPropertyAnimator r22 = this.f4350i;
        if (r22 == null) goto L12;
        r22.cancel();
        r10.clearAnimation();
    L12:
        this.f4348g = 1;
        Iterator<b> r23 = r18.iterator();
    L14:
        if (r23.hasNext() == false) goto L16;
        r23.next().a();
        goto L14
    L16:
        y(r10, this.f4347f + this.f4349h, this.f4344c, this.f4346e);
        return;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean u(CoordinatorLayout r8, V r10, View r11, View r12, int r13, int r14) {
        if (r13 != 2) goto L5;
        return true;
    L5:
        return false;
    }

    public final void y(V r8, int r10, long r11, TimeInterpolator r12) {
        this.f4350i = r8.animate().translationY(r10).setInterpolator(r12).setDuration(r11).setListener(new a(this));
    }

    public HideBottomViewOnScrollBehavior(Context r8, AttributeSet r10) {
        super(r8, r10);
        this.f4342a = new LinkedHashSet();
        this.f4347f = 0;
        this.f4348g = 2;
        this.f4349h = 0;
    }
}
