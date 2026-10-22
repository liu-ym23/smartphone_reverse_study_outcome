package com.google.android.material.bottomappbar;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.internal.q;
import com.obric.cae.R;
import j0.h0;
import j0.w;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class BottomAppBar extends Toolbar implements CoordinatorLayout.b {

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public static final /* synthetic */ int f4365q0 = 0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public Integer f4366e0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public Animator f4367f0;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public Animator f4368g0;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public int f4369h0;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public int f4370i0;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public int f4371j0;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public int f4372k0;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    public int f4373l0;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public boolean f4374m0;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public int f4375n0;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    public boolean f4376o0;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public Behavior f4377p0;

    public static class Behavior extends HideBottomViewOnScrollBehavior<BottomAppBar> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final Rect f4378j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public WeakReference<BottomAppBar> f4379k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public int f4380l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final a f4381m;

        public class a implements View.OnLayoutChangeListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Behavior f4382a;

            public a(Behavior r8) {
                this.f4382a = r8;
            }

            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View r8, int r10, int r11, int r12, int r13, int r14, int r15, int r16, int r17) {
                Behavior r18 = this.f4382a;
                BottomAppBar r19 = r18.f4379k.get();
                if (r19 != null) goto L5;
            L24:
                r8.removeOnLayoutChangeListener(this);
                return;
            L5:
                if ((r8 instanceof FloatingActionButton) == false) goto L7;
            L9:
                int r20 = r8.getHeight();
                if ((r8 instanceof FloatingActionButton) == true) goto L22;
                CoordinatorLayout.f r21 = (CoordinatorLayout.f) r8.getLayoutParams();
                if (r18.f4380l == 0) goto L14;
            L20:
                int r22 = BottomAppBar.f4365q0;
                r19.A();
                throw null;
            L14:
                if (r19.f4371j0 != 1) goto L16;
                ((ViewGroup.MarginLayoutParams) r21).bottomMargin = BottomAppBar.t(r19) + (r19.getResources().getDimensionPixelOffset(R.dimen.mtrl_bottomappbar_fab_bottom_margin) - ((r8.getMeasuredHeight() - r20) / 2));
            L16:
                ((ViewGroup.MarginLayoutParams) r21).leftMargin = BottomAppBar.u(r19);
                ((ViewGroup.MarginLayoutParams) r21).rightMargin = BottomAppBar.v(r19);
                if (q.a(r8) == false) goto L19;
                ((ViewGroup.MarginLayoutParams) r21).leftMargin += 0;
                goto L20
            L19:
                ((ViewGroup.MarginLayoutParams) r21).rightMargin += 0;
                goto L20
            L22:
                FloatingActionButton r23 = (FloatingActionButton) r8;
                r18.f4378j.set(0, 0, r23.getMeasuredWidth(), r23.getMeasuredHeight());
                throw null;
            L7:
                if ((r8 instanceof ExtendedFloatingActionButton) == true) goto L9;
                goto L9
            }
        }

        public Behavior() {
            this.f4381m = new a(this);
            this.f4378j = new Rect();
        }

        @Override // com.google.android.material.behavior.HideBottomViewOnScrollBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public final boolean h(CoordinatorLayout r8, View r10, int r11) {
            BottomAppBar r12 = (BottomAppBar) r10;
            this.f4379k = new WeakReference(r12);
            int r13 = BottomAppBar.f4365q0;
            View r14 = r12.w();
            if (r14 == null) goto L22;
            WeakHashMap<View, h0> r15 = w.f8437a;
            if (w.g.c(r14) == true) goto L22;
            CoordinatorLayout.f r16 = (CoordinatorLayout.f) r14.getLayoutParams();
            r16.f1566d = 17;
            int r17 = r12.f4371j0;
            if (r17 != 1) goto L9;
            r16.f1566d = 49;
        L9:
            if (r17 != 0) goto L11;
            r16.f1566d |= 80;
        L11:
            this.f4380l = ((ViewGroup.MarginLayoutParams) ((CoordinatorLayout.f) r14.getLayoutParams())).bottomMargin;
            if ((r14 instanceof FloatingActionButton) == false) goto L20;
            FloatingActionButton r18 = (FloatingActionButton) r14;
            if (r18.getShowMotionSpec() != null) goto L17;
            r18.setShowMotionSpecResource(R.animator.mtrl_fab_show_motion_spec);
        L17:
            if (r18.getHideMotionSpec() != null) goto L19;
            r18.setHideMotionSpecResource(R.animator.mtrl_fab_hide_motion_spec);
        L19:
            r18.c();
            r18.d(new f(r12));
            r18.e();
        L20:
            r14.addOnLayoutChangeListener(this.f4381m);
            r12.A();
            throw null;
        L22:
            r8.q(r12, r11);
            super.h(r8, r12, r11);
            return false;
        }

        @Override // com.google.android.material.behavior.HideBottomViewOnScrollBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public final boolean u(CoordinatorLayout r8, View r10, View r11, View r12, int r13, int r14) {
            BottomAppBar r15 = (BottomAppBar) r10;
            if (r15.getHideOnScroll() == true) goto L5;
        L7:
            return false;
        L5:
            if (super.u(r8, r15, r11, r12, r13, r14) == false) goto L7;
            return true;
        }

        public Behavior(Context r8, AttributeSet r10) {
            super(r8, r10);
            this.f4381m = new a(this);
            this.f4378j = new Rect();
        }
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f4383m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public boolean f4384n;

        public class a implements Parcelable.ClassLoaderCreator<SavedState> {
            @Override // android.os.Parcelable.Creator
            public final Object createFromParcel(Parcel r8) {
                return new SavedState(r8, null);
            }

            @Override // android.os.Parcelable.Creator
            public final Object[] newArray(int r8) {
                return new SavedState[r8];
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            public final SavedState createFromParcel(Parcel r8, ClassLoader r10) {
                return new SavedState(r8, r10);
            }
        }

        static {
            CREATOR = new a();
        }

        public SavedState(Parcel r8, ClassLoader r10) {
            super(r8, r10);
            this.f4383m = r8.readInt();
            if (r8.readInt() == 0) goto L5;
            boolean r11 = true;
        L6:
            this.f4384n = r11;
            return;
        L5:
            r11 = false;
            goto L6
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel r8, int r10) {
            r8.writeParcelable(this.f1731a, r10);
            r8.writeInt(this.f4383m);
            r8.writeInt(this.f4384n ? 1 : 0);
        }

        public SavedState(Toolbar.SavedState r8) {
            super(r8);
        }
    }

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ActionMenuView f4385a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f4386b;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final /* synthetic */ boolean f4387m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final /* synthetic */ BottomAppBar f4388n;

        public a(BottomAppBar r8, ActionMenuView r10, int r11, boolean r12) {
            this.f4388n = r8;
            this.f4385a = r10;
            this.f4386b = r11;
            this.f4387m = r12;
        }

        @Override // java.lang.Runnable
        public final void run() {
            int r8 = this.f4386b;
            boolean r10 = this.f4387m;
            BottomAppBar r11 = this.f4388n;
            ActionMenuView r12 = this.f4385a;
            r12.setTranslationX(r11.x(r12, r8, r10));
        }
    }

    private ActionMenuView getActionMenuView() {
        int r8 = 0;
    L4:
        if (r8 >= getChildCount()) goto L10;
        View r10 = getChildAt(r8);
        if ((r10 instanceof ActionMenuView) == true) goto L8;
        r8 = r8 + 1;
        goto L4
    L8:
        return (ActionMenuView) r10;
    L10:
        return null;
    }

    private int getBottomInset() {
        return 0;
    }

    private int getFabAlignmentAnimationDuration() {
        return v9.d.c(getContext(), R.attr.motionDurationLong2, 300);
    }

    private float getFabTranslationX() {
        return y(this.f4369h0);
    }

    private float getFabTranslationY() {
        if (this.f4371j0 == 1) goto L5;
        View r8 = w();
        if (r8 == null) goto L9;
        int r10 = (-((getMeasuredHeight() + getBottomInset()) - r8.getMeasuredHeight())) / 2;
    L11:
        return r10;
    L9:
        r10 = 0;
        goto L11
    L5:
        return -getTopEdgeTreatment().f4403m;
    }

    private int getLeftInset() {
        return 0;
    }

    private int getRightInset() {
        return 0;
    }

    private g getTopEdgeTreatment() {
        throw null;
    }

    public static /* synthetic */ int t(BottomAppBar r8) {
        return r8.getBottomInset();
    }

    public static /* synthetic */ int u(BottomAppBar r8) {
        return r8.getLeftInset();
    }

    public static /* synthetic */ int v(BottomAppBar r8) {
        return r8.getRightInset();
    }

    public final void A() {
        g r8 = getTopEdgeTreatment();
        getFabTranslationX();
        r8.getClass();
        if (this.f4376o0 == false) goto L6;
        z();
    L6:
        throw null;
    }

    public final void B(ActionMenuView r8, int r10, boolean r11, boolean r12) {
        a r13 = new a(this, r8, r10, r11);
        if (r12 == false) goto L5;
        r8.post(r13);
        return;
    L5:
        r13.run();
    }

    public ColorStateList getBackgroundTint() {
        throw null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public /* bridge */ /* synthetic */ CoordinatorLayout.c getBehavior() {
        return getBehavior();
    }

    public float getCradleVerticalOffset() {
        return getTopEdgeTreatment().f4403m;
    }

    public int getFabAlignmentMode() {
        return this.f4369h0;
    }

    public int getFabAlignmentModeEndMargin() {
        return this.f4372k0;
    }

    public int getFabAnchorMode() {
        return this.f4371j0;
    }

    public int getFabAnimationMode() {
        return this.f4370i0;
    }

    public float getFabCradleMargin() {
        return getTopEdgeTreatment().f4402b;
    }

    public float getFabCradleRoundedCornerRadius() {
        return getTopEdgeTreatment().f4401a;
    }

    public boolean getHideOnScroll() {
        return this.f4374m0;
    }

    public int getMenuAlignmentMode() {
        return this.f4373l0;
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        defpackage.c.i0(this, null);
        throw null;
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r8, int r10, int r11, int r12, int r13) {
        super.onLayout(r8, r10, r11, r12, r13);
        if (r8 == false) goto L12;
        Animator r14 = this.f4368g0;
        if (r14 == null) goto L7;
        r14.cancel();
    L7:
        Animator r15 = this.f4367f0;
        if (r15 == null) goto L10;
        r15.cancel();
    L10:
        A();
        throw null;
    L12:
        ActionMenuView r16 = getActionMenuView();
        if (r16 != null) goto L15;
        return;
    L15:
        if (this.f4368g0 != null) goto L22;
        r16.setAlpha(1.0f);
        if (z() == true) goto L19;
        B(r16, 0, false, false);
        return;
    L19:
        B(r16, this.f4369h0, this.f4376o0, false);
        return;
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.View
    public final void onRestoreInstanceState(Parcelable r8) {
        if ((r8 instanceof SavedState) == true) goto L6;
        super.onRestoreInstanceState(r8);
        return;
    L6:
        SavedState r10 = (SavedState) r8;
        super.onRestoreInstanceState(r10.f1731a);
        this.f4369h0 = r10.f4383m;
        this.f4376o0 = r10.f4384n;
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.View
    public final Parcelable onSaveInstanceState() {
        SavedState r8 = new SavedState((Toolbar.SavedState) super.onSaveInstanceState());
        r8.f4383m = this.f4369h0;
        r8.f4384n = this.f4376o0;
        return r8;
    }

    public void setBackgroundTint(ColorStateList r8) {
        b0.a.b.h(null, r8);
    }

    public void setCradleVerticalOffset(float r8) {
        if (r8 == getCradleVerticalOffset()) goto L10;
        g r10 = getTopEdgeTreatment();
        if (r8 < 0.0f) goto L8;
        r10.f4403m = r8;
        throw null;
    L8:
        r10.getClass();
        throw new IllegalArgumentException("cradleVerticalOffset must be positive.");
    }

    @Override // android.view.View
    public void setElevation(float r8) {
        throw null;
    }

    public void setFabAlignmentMode(int r13) {
        this.f4375n0 = 0;
        boolean r8 = this.f4376o0;
        WeakHashMap<View, h0> r10 = w.f8437a;
        if (w.g.c(this) == true) goto L7;
        int r11 = this.f4375n0;
        if (r11 == 0) goto L25;
        this.f4375n0 = 0;
        getMenu().clear();
        k(r11);
    L25:
        if (this.f4369h0 != r13) goto L27;
    L47:
        this.f4369h0 = r13;
        return;
    L27:
        if (w.g.c(this) == false) goto L47;
        Animator r12 = this.f4367f0;
        if (r12 == null) goto L32;
        r12.cancel();
    L32:
        ArrayList r14 = new ArrayList();
        FloatingActionButton r15 = null;
        if (this.f4370i0 != 1) goto L38;
        View r16 = w();
        if ((r16 instanceof FloatingActionButton) == false) goto L37;
        r15 = (FloatingActionButton) r16;
    L37:
        ObjectAnimator r17 = ObjectAnimator.ofFloat(r15, "translationX", new float[]{y(r13)});
        r17.setDuration(getFabAlignmentAnimationDuration());
        r14.add(r17);
    L46:
        AnimatorSet r18 = new AnimatorSet();
        r18.playTogether(r14);
        r18.setInterpolator(v9.d.d(getContext(), R.attr.motionEasingEmphasizedInterpolator, h9.a.f7943a));
        this.f4367f0 = r18;
        r18.addListener(new b(this));
        this.f4367f0.start();
        goto L47
    L38:
        View r19 = w();
        if ((r19 instanceof FloatingActionButton) == false) goto L41;
        r15 = (FloatingActionButton) r19;
    L41:
        if (r15 == null) goto L46;
        if (r15.h() == true) goto L46;
        r15.g(new c(this, r13), true);
        goto L46
    L7:
        Animator r20 = this.f4368g0;
        if (r20 == null) goto L10;
        r20.cancel();
    L10:
        ArrayList r21 = new ArrayList();
        if (z() == true) goto L13;
        r8 = false;
        int r22 = 0;
    L14:
        ActionMenuView r23 = getActionMenuView();
        if (r23 == null) goto L23;
        float r24 = getFabAlignmentAnimationDuration();
        ObjectAnimator r25 = ObjectAnimator.ofFloat(r23, "alpha", new float[]{1.0f});
        r25.setDuration((long) (0.8f * r24));
        if (Math.abs(r23.getTranslationX() - x(r23, r22, r8)) <= 1.0f) goto L21;
        ObjectAnimator r26 = ObjectAnimator.ofFloat(r23, "alpha", new float[]{0.0f});
        r26.setDuration((long) (r24 * 0.2f));
        r26.addListener(new e(this, r23, r22, r8));
        AnimatorSet r27 = new AnimatorSet();
        r27.playSequentially(new Animator[]{r26, r25});
        r21.add(r27);
        goto L23
    L21:
        if (r23.getAlpha() >= 1.0f) goto L23;
        r21.add(r25);
    L23:
        AnimatorSet r28 = new AnimatorSet();
        r28.playTogether(r21);
        this.f4368g0 = r28;
        r28.addListener(new d(this));
        this.f4368g0.start();
        goto L25
    L13:
        r22 = r13;
        goto L14
    }

    public void setFabAlignmentModeEndMargin(int r8) {
        if (this.f4372k0 != r8) goto L5;
        return;
    L5:
        this.f4372k0 = r8;
        A();
        throw null;
    }

    public void setFabAnchorMode(int r8) {
        this.f4371j0 = r8;
        A();
        throw null;
    }

    public void setFabAnimationMode(int r8) {
        this.f4370i0 = r8;
    }

    public void setFabCornerSize(float r8) {
        if (r8 != getTopEdgeTreatment().f4404n) goto L5;
        return;
    L5:
        getTopEdgeTreatment().f4404n = r8;
        throw null;
    }

    public void setFabCradleMargin(float r8) {
        if (r8 != getFabCradleMargin()) goto L5;
        return;
    L5:
        getTopEdgeTreatment().f4402b = r8;
        throw null;
    }

    public void setFabCradleRoundedCornerRadius(float r8) {
        if (r8 != getFabCradleRoundedCornerRadius()) goto L5;
        return;
    L5:
        getTopEdgeTreatment().f4401a = r8;
        throw null;
    }

    public void setHideOnScroll(boolean r8) {
        this.f4374m0 = r8;
    }

    public void setMenuAlignmentMode(int r8) {
        if (this.f4373l0 == r8) goto L8;
        this.f4373l0 = r8;
        ActionMenuView r10 = getActionMenuView();
        if (r10 == null) goto L9;
        B(r10, this.f4369h0, z(), false);
        return;
    L9:
        return;
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setNavigationIcon(Drawable r8) {
        if (r8 != null) goto L4;
    L6:
        super.setNavigationIcon(r8);
        return;
    L4:
        if (this.f4366e0 == null) goto L6;
        r8 = r8.mutate();
        b0.a.b.g(r8, this.f4366e0.intValue());
        goto L6
    }

    public void setNavigationIconTint(int r8) {
        this.f4366e0 = Integer.valueOf(r8);
        Drawable r10 = getNavigationIcon();
        if (r10 == null) goto L6;
        setNavigationIcon(r10);
        return;
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setSubtitle(CharSequence r8) {
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setTitle(CharSequence r8) {
    }

    public final View w() {
        if ((getParent() instanceof CoordinatorLayout) == true) goto L5;
        return null;
    L5:
        CoordinatorLayout r8 = (CoordinatorLayout) getParent();
        ArrayList<View> r10 = r8.f1545b.f13359b.getOrDefault(this, null);
        ArrayList r11 = r8.f1547n;
        r11.clear();
        if (r10 == null) goto L8;
        r11.addAll(r10);
    L8:
        Iterator r12 = r11.iterator();
    L10:
        if (r12.hasNext() == false) goto L16;
        View r13 = (View) r12.next();
        if ((r13 instanceof FloatingActionButton) == true) goto L15;
        if ((r13 instanceof ExtendedFloatingActionButton) == false) goto L10;
    L15:
        return r13;
    L16:
        return null;
    }

    public final int x(ActionMenuView r8, int r10, boolean r11) {
        if (this.f4373l0 == 1) goto L7;
        if (r10 != 1) goto L6;
        if (r11 == true) goto L7;
    L6:
        return 0;
    L7:
        boolean r12 = q.a(this);
        if (r12 == false) goto L10;
        int r13 = getMeasuredWidth();
    L11:
        int r14 = 0;
    L13:
        if (r14 >= getChildCount()) goto L25;
        View r15 = getChildAt(r14);
        if ((r15.getLayoutParams() instanceof Toolbar.g) == true) goto L17;
    L19:
        boolean r16 = false;
    L20:
        if (r16 == false) goto L24;
        if (r12 == false) goto L23;
        r13 = Math.min(r13, r15.getLeft());
        goto L24
    L23:
        r13 = Math.max(r13, r15.getRight());
    L24:
        r14 = r14 + 1;
        goto L13
    L17:
        if ((((Toolbar.g) r15.getLayoutParams()).f638a & 8388615) != 8388611) goto L19;
        r16 = true;
        goto L20
    L25:
        if (r12 == false) goto L27;
        int r17 = r8.getRight();
    L29:
        if (getNavigationIcon() != null) goto L34;
        int r18 = getResources().getDimensionPixelOffset(R.dimen.m3_bottomappbar_horizontal_padding);
        if (r12 == true) goto L36;
        r18 = -r18;
    L36:
        return r13 - ((r17 + 0) + r18);
    L34:
        r18 = 0;
        goto L36
    L27:
        r17 = r8.getLeft();
        goto L29
    L10:
        r13 = 0;
        goto L11
    }

    public final float y(int r8) {
        boolean r10 = q.a(this);
        int r11 = 1;
        if (r8 != 1) goto L13;
        View r12 = w();
        int r13 = 0;
        if (this.f4372k0 == (-1)) goto L8;
        if (r12 == null) goto L8;
        r13 = 0 + ((r12.getMeasuredWidth() / 2) + this.f4372k0);
    L8:
        int r14 = (getMeasuredWidth() / 2) - r13;
        if (r10 == false) goto L12;
        r11 = -1;
    L12:
        return r14 * r11;
    L13:
        return 0.0f;
    }

    public final boolean z() {
        View r8 = w();
        if ((r8 instanceof FloatingActionButton) == false) goto L5;
        FloatingActionButton r10 = (FloatingActionButton) r8;
    L6:
        if (r10 != null) goto L8;
    L10:
        return false;
    L8:
        if (r10.i() == false) goto L10;
        return true;
    L5:
        r10 = null;
        goto L6
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public Behavior getBehavior() {
        if (this.f4377p0 != null) goto L6;
        this.f4377p0 = new Behavior();
    L6:
        return this.f4377p0;
    }
}
