package com.obric.oui.titlebar;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.OverScroller;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.obric.cae.userAware.datacollection.AwareStateListener;
import com.obric.oui.titlebar.behavior.BaseBehavior;
import com.obric.oui.titlebar.behavior.HeaderBehavior;
import he.i;
import j0.h0;
import j0.w;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes2.dex */
public final class OUnitedTitleBar extends FrameLayout implements CoordinatorLayout.b {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final int f6632x = 0;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final int f6633y = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ViewGroup f6634a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ViewGroup f6635b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public TextView f6636m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public TextView f6637n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public View f6638o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f6639p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Drawable f6640q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Drawable f6641r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public View f6642s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f6643t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f6644u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f6645v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f6646w;

    public static final class Behavior extends HeaderBehavior<OUnitedTitleBar> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public ValueAnimator f6647j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public boolean f6648k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public WeakReference<View> f6649l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public boolean f6650m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public boolean f6651n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public int f6652o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public int f6653p;

        public Behavior() {
        }

        public Behavior(Context r8, AttributeSet r10) {
            super(r8, r10);
        }

        @Override // com.obric.oui.titlebar.behavior.HeaderBehavior
        public final boolean C(View r8) {
            OUnitedTitleBar r10 = (OUnitedTitleBar) r8;
            WeakReference<View> r11 = this.f6649l;
            if (r11 == null) goto L14;
            View r12 = r11.get();
            if (r12 != null) goto L7;
        L13:
            return false;
        L7:
            if (r12.isShown() == false) goto L13;
            WeakHashMap<View, h0> r13 = w.f8437a;
            if (r12.canScrollVertically(-1) == true) goto L13;
            if (y() <= (-OUnitedTitleBar.a(r10))) goto L13;
        L14:
            return true;
        }

        @Override // com.obric.oui.titlebar.behavior.HeaderBehavior
        public final /* bridge */ /* synthetic */ boolean D(CoordinatorLayout r8, View r10, int r11, int r12, float r13) {
            return L(r8, (OUnitedTitleBar) r10, r11, r13);
        }

        @Override // com.obric.oui.titlebar.behavior.HeaderBehavior
        public final int E(View r8) {
            OUnitedTitleBar r10 = (OUnitedTitleBar) r8;
            i.f(r10, "view");
            return -OUnitedTitleBar.a(r10);
        }

        @Override // com.obric.oui.titlebar.behavior.HeaderBehavior
        public final int F(View r8) {
            OUnitedTitleBar r10 = (OUnitedTitleBar) r8;
            i.f(r10, "view");
            return OUnitedTitleBar.a(r10);
        }

        @Override // com.obric.oui.titlebar.behavior.HeaderBehavior
        public final void G(View r8, CoordinatorLayout r10) {
            this.f6651n = false;
            K(r10, (OUnitedTitleBar) r8);
        }

        @Override // com.obric.oui.titlebar.behavior.HeaderBehavior
        public final int I(CoordinatorLayout r8, View r10, int r11, int r12, int r13) {
            OUnitedTitleBar r14 = (OUnitedTitleBar) r10;
            y();
            if (this.f6651n == false) goto L5;
            r12 = Math.max(this.f6652o, r12);
            r13 = Math.min(this.f6653p, r13);
        L5:
            int r15 = super.I(r8, r14, r11, r12, r13);
            if (r14 == null) goto L9;
            y();
        L9:
            if (this.f6651n == false) goto L13;
            if (r14 == null) goto L13;
            r14.getMOnHeaderFlingUnConsumedListener();
        L13:
            return r15 + 0;
        }

        public final void K(CoordinatorLayout r8, OUnitedTitleBar r10) {
            int r11 = y();
            i.c(r10);
            int r12 = -OUnitedTitleBar.b(r10);
            if (r11 <= r12) goto L24;
            if (r11 < 0) goto L6;
            return;
        L6:
            if (r11 < ((r12 + 0) / 2)) goto L9;
            r12 = 0;
        L9:
            int r13 = Math.abs(y() - r12);
            float r14 = Math.abs(0.0f);
            if (r14 <= 0) goto L12;
            int r15 = Math.round((r13 / r14) * 1000);
        L13:
            int r16 = y();
            if (r16 != r12) goto L18;
            ValueAnimator r17 = this.f6647j;
            if (r17 == null) goto L18;
            r17.cancel();
        L18:
            ValueAnimator r18 = this.f6647j;
            if (r18 != null) goto L21;
            ValueAnimator r19 = new ValueAnimator();
            this.f6647j = r19;
            r19.setInterpolator(new AccelerateDecelerateInterpolator());
            ValueAnimator r20 = this.f6647j;
            i.c(r20);
            r20.addUpdateListener(new com.obric.oui.titlebar.a(this, r8, r10));
        L22:
            ValueAnimator r21 = this.f6647j;
            i.c(r21);
            r21.setDuration(r15);
            ValueAnimator r22 = this.f6647j;
            i.c(r22);
            r22.setIntValues(new int[]{r16, r12});
            ValueAnimator r23 = this.f6647j;
            i.c(r23);
            r23.start();
            return;
        L21:
            r18.cancel();
            goto L22
        L12:
            r15 = (int) (((r13 / r10.getHeight()) + 1) * AwareStateListener.DEFAULT_POI_WALK_STEP_THRESHOLD);
            goto L13
        }

        public final boolean L(CoordinatorLayout r8, OUnitedTitleBar r10, int r11, float r12) {
            i.f(r10, "layout");
            int r13 = 0;
            if (r12 >= 0) goto L6;
            this.f6651n = true;
            this.f6652o = r11;
            this.f6653p = 0;
            r11 = Integer.MIN_VALUE;
            r13 = Integer.MAX_VALUE;
        L6:
            return super.D(r8, r10, r11, r13, r12);
        }

        @Override // vc.d, androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public final boolean h(CoordinatorLayout r8, View r10, int r11) {
            OUnitedTitleBar r12 = (OUnitedTitleBar) r10;
            i.f(r8, "parent");
            super.h(r8, r12, r11);
            int r13 = r12.f6644u;
            if (r13 != 0) goto L5;
        L11:
            y();
            return true;
        L5:
            if ((r13 & 1) == 0) goto L8;
            int r14 = -OUnitedTitleBar.a(r12);
        L10:
            J(r8, r12, r14);
            goto L11
        L8:
            if ((r13 & 16) == 0) goto L11;
            r14 = 0;
            goto L10
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public final void j(CoordinatorLayout r8, View r10, View r11) {
            OUnitedTitleBar r12 = (OUnitedTitleBar) r10;
            i.f(r8, "coordinatorLayout");
            i.f(r11, "target");
            this.f6650m = true;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public final boolean k(CoordinatorLayout r8, View r10, View r11, float r12) {
            OUnitedTitleBar r13 = (OUnitedTitleBar) r10;
            i.f(r8, "coordinatorLayout");
            i.f(r11, "target");
            if (r12 > 0) goto L5;
            return false;
        L5:
            if (y() <= (-OUnitedTitleBar.a(r13))) goto L9;
            L(r8, r13, -OUnitedTitleBar.a(r13), -r12);
            this.f6650m = true;
            return true;
        L9:
            return false;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public final void m(CoordinatorLayout r8, View r10, View r11, int r12, int[] r13) {
            OUnitedTitleBar r14 = (OUnitedTitleBar) r10;
            i.f(r8, "coordinatorLayout");
            i.f(r11, "target");
            i.f(r13, "consumed");
            if (r12 > 0) goto L5;
            return;
        L5:
            if (this.f6648k == true) goto L9;
            r13[1] = H(r8, r14, r12, -OUnitedTitleBar.a(r14), 0);
            return;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public final void n(CoordinatorLayout r8, View r10, View r11, int r12) {
            OUnitedTitleBar r13 = (OUnitedTitleBar) r10;
            i.f(r8, "coordinatorLayout");
            i.f(r11, "target");
            if (r12 >= 0) goto L5;
            H(r8, r13, r12, -OUnitedTitleBar.a(r13), 0);
            boolean r14 = true;
        L6:
            this.f6648k = r14;
            return;
        L5:
            r14 = false;
            goto L6
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public final boolean t(CoordinatorLayout r8, View r10, View r11, View r12, int r13) {
            OUnitedTitleBar r14 = (OUnitedTitleBar) r10;
            i.f(r8, "coordinatorLayout");
            i.f(r11, "directTargetChild");
            i.f(r12, "target");
            if ((r13 & 2) > 0) goto L5;
        L9:
            boolean r15 = false;
        L10:
            if (r15 == false) goto L14;
            ValueAnimator r16 = this.f6647j;
            if (r16 == null) goto L14;
            r16.cancel();
        L14:
            this.f6649l = null;
            this.f6650m = false;
            this.f6651n = false;
            OverScroller r17 = this.f6671d;
            if (r17 == null) goto L17;
            r17.abortAnimation();
        L17:
            return r15;
        L5:
            if (OUnitedTitleBar.a(r14) <= 0) goto L9;
            if ((r8.getHeight() - r11.getHeight()) > r14.getHeight()) goto L9;
            r15 = true;
            goto L10
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public final void v(CoordinatorLayout r8, View r10, View r11) {
            OUnitedTitleBar r12 = (OUnitedTitleBar) r10;
            i.f(r8, "coordinatorLayout");
            i.f(r11, "target");
            if (this.f6650m == true) goto L5;
            K(r8, r12);
        L5:
            this.f6648k = false;
            this.f6649l = new WeakReference(r11);
        }
    }

    public interface a {
    }

    static {
        f6632x = android.aimedia.a.a("Resources.getSystem()", 1, 56);
        f6633y = android.aimedia.a.a("Resources.getSystem()", 1, 240);
        Resources r8 = Resources.getSystem();
        i.e(r8, "Resources.getSystem()");
        l6.a.I0(TypedValue.applyDimension(1, 12, r8.getDisplayMetrics()));
        Resources r10 = Resources.getSystem();
        i.e(r10, "Resources.getSystem()");
        l6.a.I0(TypedValue.applyDimension(1, 92, r10.getDisplayMetrics()));
        Resources r11 = Resources.getSystem();
        i.e(r11, "Resources.getSystem()");
        l6.a.I0(TypedValue.applyDimension(1, 17, r11.getDisplayMetrics()));
        Resources r12 = Resources.getSystem();
        i.e(r12, "Resources.getSystem()");
        l6.a.I0(TypedValue.applyDimension(1, 14, r12.getDisplayMetrics()));
    }

    public static final /* synthetic */ int a(OUnitedTitleBar r8) {
        return r8.getScrollRange();
    }

    public static final /* synthetic */ int b(OUnitedTitleBar r8) {
        return r8.getSnapRange();
    }

    private final int getScrollRange() {
        return f6633y - f6632x;
    }

    private final int getSnapRange() {
        return android.aimedia.a.a("Resources.getSystem()", 1, 56);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet r8) {
        return new BaseBehavior.d(getContext(), r8);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public CoordinatorLayout.c<?> getBehavior() {
        return new BaseBehavior.Behavior();
    }

    public final View getBottomAction() {
        return this.f6638o;
    }

    public final View getDivider() {
        return this.f6642s;
    }

    public final int getDownNestedPreScrollRange() {
        return 0;
    }

    public final int getDownNestedScrollRange() {
        return getTotalScrollRange();
    }

    public final int getINVALID_SCROLL_RANGE() {
        return 0;
    }

    public final boolean getInDebug() {
        return this.f6645v;
    }

    public final ViewGroup getLeftAction() {
        return this.f6634a;
    }

    public final Drawable getLeftActionSrc() {
        return this.f6640q;
    }

    public final int getMCollapsePosition() {
        return this.f6643t;
    }

    public final a getMOnHeaderFlingUnConsumedListener() {
        return null;
    }

    public final TextView getMTvSubTitle() {
        return this.f6637n;
    }

    public final TextView getMTvTitle() {
        return this.f6636m;
    }

    public final int getPendingAction() {
        return this.f6644u;
    }

    public final ViewGroup getRightAction() {
        return this.f6635b;
    }

    public final Drawable getRightActionSrc() {
        return this.f6641r;
    }

    public final int getTextInitPos() {
        return this.f6646w;
    }

    public final String getTitleText() {
        return this.f6639p;
    }

    public final int getTopInset() {
        return 0;
    }

    public final int getTotalScrollRange() {
        return f6633y - f6632x;
    }

    public final int getUpNestedPreScrollRange() {
        return getTotalScrollRange();
    }

    public final void setBottomAction(View r8) {
        this.f6638o = r8;
    }

    public final void setDivider(View r8) {
        this.f6642s = r8;
    }

    public final void setExpanded(boolean r8) {
        if (r8 == false) goto L4;
        int r10 = 16;
    L5:
        this.f6644u = r10;
        requestLayout();
        return;
    L4:
        r10 = 1;
        goto L5
    }

    public final void setInDebug(boolean r8) {
        this.f6645v = r8;
    }

    public final void setLeftAction(View r8) {
        i.f(r8, "view");
        ViewGroup r10 = this.f6634a;
        if (r10 == null) goto L5;
        r10.removeAllViews();
    L5:
        ViewGroup r11 = this.f6634a;
        if (r11 == null) goto L9;
        r11.addView(r8);
        return;
    }

    public final void setLeftActionSrc(Drawable r8) {
        this.f6640q = r8;
    }

    public final void setMCollapsePosition(int r8) {
        this.f6643t = r8;
    }

    public final void setMOnHeaderFlingUnConsumedListener(a r8) {
    }

    public final void setMTvSubTitle(TextView r8) {
        this.f6637n = r8;
    }

    public final void setMTvTitle(TextView r8) {
        this.f6636m = r8;
    }

    public final void setOnHeaderFlingUnConsumedListener(a r8) {
        i.f(r8, "onHeaderFlingUnConsumedListener");
    }

    public final void setRightAction(View r8) {
        i.f(r8, "view");
        ViewGroup r10 = this.f6635b;
        if (r10 == null) goto L5;
        r10.removeAllViews();
    L5:
        ViewGroup r11 = this.f6635b;
        if (r11 == null) goto L9;
        r11.addView(r8);
        return;
    }

    public final void setRightActionSrc(Drawable r8) {
        this.f6641r = r8;
    }

    public final void setTextInitPos(int r8) {
        this.f6646w = r8;
    }

    public final void setTitleText(String r8) {
        this.f6639p = r8;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r8) {
        return new BaseBehavior.d(r8);
    }

    public final void setLeftAction(ViewGroup r8) {
        this.f6634a = r8;
    }

    public final void setRightAction(ViewGroup r8) {
        this.f6635b = r8;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public final FrameLayout.LayoutParams generateLayoutParams(AttributeSet r8) {
        return new BaseBehavior.d(getContext(), r8);
    }
}
