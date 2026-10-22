package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.AnimatorRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.button.MaterialButton;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ExtendedFloatingActionButton extends MaterialButton implements CoordinatorLayout.AttachedBehavior {
    private static final int ANIM_STATE_HIDING = 1;
    private static final int ANIM_STATE_NONE = 0;
    private static final int ANIM_STATE_SHOWING = 2;
    private static final int DEF_STYLE_RES = 0;
    static final Property<View, Float> HEIGHT = null;
    static final Property<View, Float> PADDING_END = null;
    static final Property<View, Float> PADDING_START = null;
    static final Property<View, Float> WIDTH = null;
    private int animState;
    private boolean animateShowBeforeLayout;

    @NonNull
    private final CoordinatorLayout.Behavior<ExtendedFloatingActionButton> behavior;
    private final com.google.android.material.floatingactionbutton.a changeVisibilityTracker;
    private final int collapsedSize;

    @NonNull
    private final com.google.android.material.floatingactionbutton.e extendStrategy;
    private int extendedPaddingEnd;
    private int extendedPaddingStart;
    private final com.google.android.material.floatingactionbutton.e hideStrategy;
    private boolean isExtended;
    private boolean isTransforming;

    @NonNull
    protected ColorStateList originalTextCsl;
    private final com.google.android.material.floatingactionbutton.e showStrategy;

    @NonNull
    private final com.google.android.material.floatingactionbutton.e shrinkStrategy;

    protected static class ExtendedFloatingActionButtonBehavior<T extends ExtendedFloatingActionButton> extends CoordinatorLayout.Behavior<T> {
        private static final boolean AUTO_HIDE_DEFAULT = false;
        private static final boolean AUTO_SHRINK_DEFAULT = true;
        private boolean autoHideEnabled;
        private boolean autoShrinkEnabled;

        @Nullable
        private j internalAutoHideCallback;

        @Nullable
        private j internalAutoShrinkCallback;
        private Rect tmpRect;

        public ExtendedFloatingActionButtonBehavior() {
            this.autoHideEnabled = false;
            this.autoShrinkEnabled = true;
        }

        public ExtendedFloatingActionButtonBehavior(@NonNull Context r10, @Nullable AttributeSet r11) {
            super(r10, r11);
            TypedArray r12 = r10.obtainStyledAttributes(r11, q5.l.ExtendedFloatingActionButton_Behavior_Layout);
            this.autoHideEnabled = r12.getBoolean(q5.l.ExtendedFloatingActionButton_Behavior_Layout_behavior_autoHide, false);
            this.autoShrinkEnabled = r12.getBoolean(q5.l.ExtendedFloatingActionButton_Behavior_Layout_behavior_autoShrink, true);
            r12.recycle();
        }

        private static boolean isBottomSheet(@NonNull View r10) {
            ViewGroup.LayoutParams r11 = r10.getLayoutParams();
            if ((r11 instanceof CoordinatorLayout.LayoutParams) == true) goto L5;
            return false;
        L5:
            return ((CoordinatorLayout.LayoutParams) r11).getBehavior() instanceof BottomSheetBehavior;
        }

        private boolean shouldUpdateVisibility(@NonNull View r10, @NonNull ExtendedFloatingActionButton r11) {
            CoordinatorLayout.LayoutParams r12 = (CoordinatorLayout.LayoutParams) r11.getLayoutParams();
            if (this.autoHideEnabled == true) goto L8;
            if (this.autoShrinkEnabled == true) goto L8;
            return false;
        L8:
            if (r12.getAnchorId() == r10.getId()) goto L10;
            return false;
        L10:
            return true;
        }

        private boolean updateFabVisibilityForAppBarLayout(CoordinatorLayout r10, @NonNull AppBarLayout r11, @NonNull ExtendedFloatingActionButton r12) {
            if (shouldUpdateVisibility(r11, r12) == true) goto L7;
            return false;
        L7:
            if (this.tmpRect != null) goto L9;
            this.tmpRect = new Rect();
        L9:
            Rect r13 = this.tmpRect;
            com.google.android.material.internal.d.a(r10, r11, r13);
            if (r13.bottom > r11.getMinimumHeightForVisibleOverlappingContent()) goto L12;
            shrinkOrHide(r12);
            return true;
        L12:
            extendOrShow(r12);
            return true;
        }

        private boolean updateFabVisibilityForBottomSheet(@NonNull View r10, @NonNull ExtendedFloatingActionButton r11) {
            if (shouldUpdateVisibility(r10, r11) == true) goto L6;
            return false;
        L6:
            CoordinatorLayout.LayoutParams r12 = (CoordinatorLayout.LayoutParams) r11.getLayoutParams();
            if (r10.getTop() >= ((r11.getHeight() / 2) + ((ViewGroup.MarginLayoutParams) r12).topMargin)) goto L9;
            shrinkOrHide(r11);
            return true;
        L9:
            extendOrShow(r11);
            return true;
        }

        protected void extendOrShow(@NonNull ExtendedFloatingActionButton r10) {
            boolean r11 = this.autoShrinkEnabled;
            if (r11 == false) goto L5;
            j r12 = this.internalAutoShrinkCallback;
        L6:
            if (r11 == false) goto L8;
            com.google.android.material.floatingactionbutton.e r13 = ExtendedFloatingActionButton.access$500(r10);
        L9:
            ExtendedFloatingActionButton.access$400(r10, r13, r12);
            return;
        L8:
            r13 = ExtendedFloatingActionButton.access$600(r10);
            goto L9
        L5:
            r12 = this.internalAutoHideCallback;
            goto L6
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ boolean getInsetDodgeRect(@NonNull CoordinatorLayout r10, @NonNull View r11, @NonNull Rect r12) {
            return getInsetDodgeRect(r10, (ExtendedFloatingActionButton) r11, r12);
        }

        public boolean getInsetDodgeRect(@NonNull CoordinatorLayout r10, @NonNull ExtendedFloatingActionButton r11, @NonNull Rect r12) {
            return super.getInsetDodgeRect(r10, r11, r12);
        }

        public boolean isAutoHideEnabled() {
            return this.autoHideEnabled;
        }

        public boolean isAutoShrinkEnabled() {
            return this.autoShrinkEnabled;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public void onAttachedToLayoutParams(@NonNull CoordinatorLayout.LayoutParams r10) {
            if (r10.dodgeInsetEdges != 0) goto L6;
            r10.dodgeInsetEdges = 80;
            return;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ boolean onDependentViewChanged(CoordinatorLayout r10, @NonNull View r11, View r12) {
            return onDependentViewChanged(r10, (ExtendedFloatingActionButton) r11, r12);
        }

        public boolean onDependentViewChanged(CoordinatorLayout r10, @NonNull ExtendedFloatingActionButton r11, View r12) {
            if ((r12 instanceof AppBarLayout) == false) goto L6;
            updateFabVisibilityForAppBarLayout(r10, (AppBarLayout) r12, r11);
            return false;
        L6:
            if (isBottomSheet(r12) == false) goto L11;
            updateFabVisibilityForBottomSheet(r12, r11);
            return false;
        L11:
            return false;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ boolean onLayoutChild(@NonNull CoordinatorLayout r10, @NonNull View r11, int r12) {
            return onLayoutChild(r10, (ExtendedFloatingActionButton) r11, r12);
        }

        public boolean onLayoutChild(@NonNull CoordinatorLayout r10, @NonNull ExtendedFloatingActionButton r11, int r12) {
            List<View> r13 = r10.getDependencies(r11);
            int r14 = r13.size();
            int r15 = 0;
        L3:
            if (r15 >= r14) goto L15;
            View r16 = r13.get(r15);
            if ((r16 instanceof AppBarLayout) == false) goto L10;
            if (updateFabVisibilityForAppBarLayout(r10, (AppBarLayout) r16, r11) == true) goto L15;
        L14:
            r15 = r15 + 1;
            goto L3
        L10:
            if (isBottomSheet(r16) == false) goto L14;
            if (updateFabVisibilityForBottomSheet(r16, r11) == false) goto L14;
        L15:
            r10.onLayoutChild(r11, r12);
            return true;
        }

        public void setAutoHideEnabled(boolean r10) {
            this.autoHideEnabled = r10;
        }

        public void setAutoShrinkEnabled(boolean r10) {
            this.autoShrinkEnabled = r10;
        }

        @VisibleForTesting
        void setInternalAutoHideCallback(@Nullable j r10) {
        }

        @VisibleForTesting
        void setInternalAutoShrinkCallback(@Nullable j r10) {
        }

        protected void shrinkOrHide(@NonNull ExtendedFloatingActionButton r10) {
            boolean r11 = this.autoShrinkEnabled;
            if (r11 == false) goto L5;
            j r12 = this.internalAutoShrinkCallback;
        L6:
            if (r11 == false) goto L8;
            com.google.android.material.floatingactionbutton.e r13 = ExtendedFloatingActionButton.access$200(r10);
        L9:
            ExtendedFloatingActionButton.access$400(r10, r13, r12);
            return;
        L8:
            r13 = ExtendedFloatingActionButton.access$300(r10);
            goto L9
        L5:
            r12 = this.internalAutoHideCallback;
            goto L6
        }
    }

    class a implements l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ExtendedFloatingActionButton f3239a;

        a(ExtendedFloatingActionButton r10) {
            this.f3239a = r10;
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.l
        public int a() {
            return ExtendedFloatingActionButton.access$100(this.f3239a);
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.l
        public int b() {
            return ((this.f3239a.getMeasuredWidth() - (this.f3239a.getCollapsedPadding() * 2)) + ExtendedFloatingActionButton.access$000(this.f3239a)) + ExtendedFloatingActionButton.access$100(this.f3239a);
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.l
        public ViewGroup.LayoutParams c() {
            return new ViewGroup.LayoutParams(-2, -2);
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.l
        public int d() {
            return ExtendedFloatingActionButton.access$000(this.f3239a);
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.l
        public int getHeight() {
            return this.f3239a.getMeasuredHeight();
        }
    }

    class b implements l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ExtendedFloatingActionButton f3240a;

        b(ExtendedFloatingActionButton r10) {
            this.f3240a = r10;
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.l
        public int a() {
            return this.f3240a.getCollapsedPadding();
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.l
        public int b() {
            return this.f3240a.getCollapsedSize();
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.l
        public ViewGroup.LayoutParams c() {
            return new ViewGroup.LayoutParams(b(), getHeight());
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.l
        public int d() {
            return this.f3240a.getCollapsedPadding();
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.l
        public int getHeight() {
            return this.f3240a.getCollapsedSize();
        }
    }

    class c extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f3241c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ com.google.android.material.floatingactionbutton.e f3242g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ j f3243h;

        c(ExtendedFloatingActionButton r10, com.google.android.material.floatingactionbutton.e r11, j r12) {
            this.f3242g = r11;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator r10) {
            this.f3241c = true;
            this.f3242g.a();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator r10) {
            this.f3242g.h();
            if (this.f3241c == true) goto L6;
            this.f3242g.l(this.f3243h);
            return;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator r10) {
            this.f3242g.onAnimationStart(r10);
            this.f3241c = false;
        }
    }

    class d extends Property<View, Float> {
        d(Class r10, String r11) {
            super(r10, r11);
        }

        @NonNull
        public Float a(@NonNull View r10) {
            return Float.valueOf(r10.getLayoutParams().width);
        }

        public void b(@NonNull View r10, @NonNull Float r11) {
            ViewGroup.LayoutParams r12 = r10.getLayoutParams();
            r12.width = r11.intValue();
            r10.requestLayout();
        }

        @Override // android.util.Property
        @NonNull
        public /* bridge */ /* synthetic */ Float get(@NonNull View r10) {
            return a(r10);
        }

        @Override // android.util.Property
        public /* bridge */ /* synthetic */ void set(@NonNull View r10, @NonNull Float r11) {
            b(r10, r11);
        }
    }

    class e extends Property<View, Float> {
        e(Class r10, String r11) {
            super(r10, r11);
        }

        @NonNull
        public Float a(@NonNull View r10) {
            return Float.valueOf(r10.getLayoutParams().height);
        }

        public void b(@NonNull View r10, @NonNull Float r11) {
            ViewGroup.LayoutParams r12 = r10.getLayoutParams();
            r12.height = r11.intValue();
            r10.requestLayout();
        }

        @Override // android.util.Property
        @NonNull
        public /* bridge */ /* synthetic */ Float get(@NonNull View r10) {
            return a(r10);
        }

        @Override // android.util.Property
        public /* bridge */ /* synthetic */ void set(@NonNull View r10, @NonNull Float r11) {
            b(r10, r11);
        }
    }

    class f extends Property<View, Float> {
        f(Class r10, String r11) {
            super(r10, r11);
        }

        @NonNull
        public Float a(@NonNull View r10) {
            return Float.valueOf(ViewCompat.getPaddingStart(r10));
        }

        public void b(@NonNull View r10, @NonNull Float r11) {
            ViewCompat.setPaddingRelative(r10, r11.intValue(), r10.getPaddingTop(), ViewCompat.getPaddingEnd(r10), r10.getPaddingBottom());
        }

        @Override // android.util.Property
        @NonNull
        public /* bridge */ /* synthetic */ Float get(@NonNull View r10) {
            return a(r10);
        }

        @Override // android.util.Property
        public /* bridge */ /* synthetic */ void set(@NonNull View r10, @NonNull Float r11) {
            b(r10, r11);
        }
    }

    class g extends Property<View, Float> {
        g(Class r10, String r11) {
            super(r10, r11);
        }

        @NonNull
        public Float a(@NonNull View r10) {
            return Float.valueOf(ViewCompat.getPaddingEnd(r10));
        }

        public void b(@NonNull View r10, @NonNull Float r11) {
            ViewCompat.setPaddingRelative(r10, ViewCompat.getPaddingStart(r10), r10.getPaddingTop(), r11.intValue(), r10.getPaddingBottom());
        }

        @Override // android.util.Property
        @NonNull
        public /* bridge */ /* synthetic */ Float get(@NonNull View r10) {
            return a(r10);
        }

        @Override // android.util.Property
        public /* bridge */ /* synthetic */ void set(@NonNull View r10, @NonNull Float r11) {
            b(r10, r11);
        }
    }

    class h extends com.google.android.material.floatingactionbutton.b {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final l f3244g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final boolean f3245h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ ExtendedFloatingActionButton f3246i;

        h(ExtendedFloatingActionButton r10, com.google.android.material.floatingactionbutton.a r11, l r12, boolean r13) {
            this.f3246i = r10;
            super(r10, r11);
            this.f3244g = r12;
            this.f3245h = r13;
        }

        @Override // com.google.android.material.floatingactionbutton.e
        public int b() {
            if (this.f3245h == false) goto L6;
            return q5.a.mtrl_extended_fab_change_size_expand_motion_spec;
        L6:
            return q5.a.mtrl_extended_fab_change_size_collapse_motion_spec;
        }

        @Override // com.google.android.material.floatingactionbutton.e
        public void c() {
            ExtendedFloatingActionButton.access$702(this.f3246i, this.f3245h);
            ViewGroup.LayoutParams r10 = this.f3246i.getLayoutParams();
            if (r10 != null) goto L5;
            return;
        L5:
            r10.width = this.f3244g.c().width;
            r10.height = this.f3244g.c().height;
            ViewCompat.setPaddingRelative(this.f3246i, this.f3244g.d(), this.f3246i.getPaddingTop(), this.f3244g.a(), this.f3246i.getPaddingBottom());
            this.f3246i.requestLayout();
        }

        @Override // com.google.android.material.floatingactionbutton.e
        public boolean e() {
            if (this.f3245h != ExtendedFloatingActionButton.access$700(this.f3246i)) goto L5;
        L10:
            return true;
        L5:
            if (this.f3246i.getIcon() == null) goto L10;
            if (TextUtils.isEmpty(this.f3246i.getText()) == true) goto L10;
            return false;
        }

        @Override // com.google.android.material.floatingactionbutton.b, com.google.android.material.floatingactionbutton.e
        public void h() {
            super.h();
            ExtendedFloatingActionButton.access$802(this.f3246i, false);
            this.f3246i.setHorizontallyScrolling(false);
            ViewGroup.LayoutParams r10 = this.f3246i.getLayoutParams();
            if (r10 != null) goto L5;
            return;
        L5:
            r10.width = this.f3244g.c().width;
            r10.height = this.f3244g.c().height;
        }

        @Override // com.google.android.material.floatingactionbutton.b, com.google.android.material.floatingactionbutton.e
        @NonNull
        public AnimatorSet j() {
            r5.h r10 = o();
            if (r10.j("width") == false) goto L6;
            PropertyValuesHolder[] r11 = r10.g("width");
            r11[0].setFloatValues(new float[]{this.f3246i.getWidth(), this.f3244g.b()});
            r10.l("width", r11);
        L6:
            if (r10.j("height") == false) goto L9;
            PropertyValuesHolder[] r12 = r10.g("height");
            r12[0].setFloatValues(new float[]{this.f3246i.getHeight(), this.f3244g.getHeight()});
            r10.l("height", r12);
        L9:
            if (r10.j("paddingStart") == false) goto L12;
            PropertyValuesHolder[] r13 = r10.g("paddingStart");
            r13[0].setFloatValues(new float[]{ViewCompat.getPaddingStart(this.f3246i), this.f3244g.d()});
            r10.l("paddingStart", r13);
        L12:
            if (r10.j("paddingEnd") == false) goto L15;
            PropertyValuesHolder[] r14 = r10.g("paddingEnd");
            r14[0].setFloatValues(new float[]{ViewCompat.getPaddingEnd(this.f3246i), this.f3244g.a()});
            r10.l("paddingEnd", r14);
        L15:
            if (r10.j("labelOpacity") == false) goto L24;
            PropertyValuesHolder[] r15 = r10.g("labelOpacity");
            boolean r16 = this.f3245h;
            float r17 = 0.0f;
            if (r16 == false) goto L19;
            float r18 = 0.0f;
        L20:
            if (r16 == false) goto L22;
            r17 = 1.0f;
        L22:
            r15[0].setFloatValues(new float[]{r18, r17});
            r10.l("labelOpacity", r15);
            goto L24
        L19:
            r18 = 1.0f;
        L24:
            return super.n(r10);
        }

        @Override // com.google.android.material.floatingactionbutton.e
        public void l(@Nullable j r10) {
        }

        @Override // com.google.android.material.floatingactionbutton.b, com.google.android.material.floatingactionbutton.e
        public void onAnimationStart(Animator r10) {
            super.onAnimationStart(r10);
            ExtendedFloatingActionButton.access$702(this.f3246i, this.f3245h);
            ExtendedFloatingActionButton.access$802(this.f3246i, true);
            this.f3246i.setHorizontallyScrolling(true);
        }
    }

    class i extends com.google.android.material.floatingactionbutton.b {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private boolean f3247g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ ExtendedFloatingActionButton f3248h;

        public i(ExtendedFloatingActionButton r10, com.google.android.material.floatingactionbutton.a r11) {
            this.f3248h = r10;
            super(r10, r11);
        }

        @Override // com.google.android.material.floatingactionbutton.b, com.google.android.material.floatingactionbutton.e
        public void a() {
            super.a();
            this.f3247g = true;
        }

        @Override // com.google.android.material.floatingactionbutton.e
        public int b() {
            return q5.a.mtrl_extended_fab_hide_motion_spec;
        }

        @Override // com.google.android.material.floatingactionbutton.e
        public void c() {
            this.f3248h.setVisibility(8);
        }

        @Override // com.google.android.material.floatingactionbutton.e
        public boolean e() {
            return ExtendedFloatingActionButton.access$1100(this.f3248h);
        }

        @Override // com.google.android.material.floatingactionbutton.b, com.google.android.material.floatingactionbutton.e
        public void h() {
            super.h();
            ExtendedFloatingActionButton.access$902(this.f3248h, 0);
            if (this.f3247g == true) goto L6;
            this.f3248h.setVisibility(8);
            return;
        }

        @Override // com.google.android.material.floatingactionbutton.e
        public void l(@Nullable j r10) {
        }

        @Override // com.google.android.material.floatingactionbutton.b, com.google.android.material.floatingactionbutton.e
        public void onAnimationStart(Animator r10) {
            super.onAnimationStart(r10);
            this.f3247g = false;
            this.f3248h.setVisibility(0);
            ExtendedFloatingActionButton.access$902(this.f3248h, 1);
        }
    }

    public static abstract class j {
    }

    class k extends com.google.android.material.floatingactionbutton.b {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ ExtendedFloatingActionButton f3249g;

        public k(ExtendedFloatingActionButton r10, com.google.android.material.floatingactionbutton.a r11) {
            this.f3249g = r10;
            super(r10, r11);
        }

        @Override // com.google.android.material.floatingactionbutton.e
        public int b() {
            return q5.a.mtrl_extended_fab_show_motion_spec;
        }

        @Override // com.google.android.material.floatingactionbutton.e
        public void c() {
            this.f3249g.setVisibility(0);
            this.f3249g.setAlpha(1.0f);
            this.f3249g.setScaleY(1.0f);
            this.f3249g.setScaleX(1.0f);
        }

        @Override // com.google.android.material.floatingactionbutton.e
        public boolean e() {
            return ExtendedFloatingActionButton.access$1000(this.f3249g);
        }

        @Override // com.google.android.material.floatingactionbutton.b, com.google.android.material.floatingactionbutton.e
        public void h() {
            super.h();
            ExtendedFloatingActionButton.access$902(this.f3249g, 0);
        }

        @Override // com.google.android.material.floatingactionbutton.e
        public void l(@Nullable j r10) {
        }

        @Override // com.google.android.material.floatingactionbutton.b, com.google.android.material.floatingactionbutton.e
        public void onAnimationStart(Animator r10) {
            super.onAnimationStart(r10);
            this.f3249g.setVisibility(0);
            ExtendedFloatingActionButton.access$902(this.f3249g, 2);
        }
    }

    interface l {
        int a();

        int b();

        ViewGroup.LayoutParams c();

        int d();

        int getHeight();
    }

    static {
        DEF_STYLE_RES = q5.k.Widget_MaterialComponents_ExtendedFloatingActionButton_Icon;
        WIDTH = new d(Float.class, "width");
        HEIGHT = new e(Float.class, "height");
        PADDING_START = new f(Float.class, "paddingStart");
        PADDING_END = new g(Float.class, "paddingEnd");
    }

    public ExtendedFloatingActionButton(@NonNull Context r10) {
        this(r10, null);
    }

    public ExtendedFloatingActionButton(@NonNull Context r10, @Nullable AttributeSet r11) {
        this(r10, r11, q5.b.extendedFloatingActionButtonStyle);
    }

    public ExtendedFloatingActionButton(@NonNull Context r17, @Nullable AttributeSet r18, int r19) {
        int r10 = DEF_STYLE_RES;
        super(b6.a.c(r17, r18, r19, r10), r18, r19);
        this.animState = 0;
        com.google.android.material.floatingactionbutton.a r11 = new com.google.android.material.floatingactionbutton.a();
        this.changeVisibilityTracker = r11;
        k r12 = new k(this, r11);
        this.showStrategy = r12;
        i r13 = new i(this, r11);
        this.hideStrategy = r13;
        this.isExtended = true;
        this.isTransforming = false;
        this.animateShowBeforeLayout = false;
        Context r14 = getContext();
        this.behavior = new ExtendedFloatingActionButtonBehavior(r14, r18);
        TypedArray r15 = com.google.android.material.internal.k.h(r14, r18, q5.l.ExtendedFloatingActionButton, r19, r10, new int[0]);
        r5.h r16 = r5.h.c(r14, r15, q5.l.ExtendedFloatingActionButton_showMotionSpec);
        r5.h r20 = r5.h.c(r14, r15, q5.l.ExtendedFloatingActionButton_hideMotionSpec);
        r5.h r21 = r5.h.c(r14, r15, q5.l.ExtendedFloatingActionButton_extendMotionSpec);
        r5.h r22 = r5.h.c(r14, r15, q5.l.ExtendedFloatingActionButton_shrinkMotionSpec);
        this.collapsedSize = r15.getDimensionPixelSize(q5.l.ExtendedFloatingActionButton_collapsedSize, -1);
        this.extendedPaddingStart = ViewCompat.getPaddingStart(this);
        this.extendedPaddingEnd = ViewCompat.getPaddingEnd(this);
        com.google.android.material.floatingactionbutton.a r23 = new com.google.android.material.floatingactionbutton.a();
        h r110 = new h(this, r23, new a(this), true);
        this.extendStrategy = r110;
        h r111 = new h(this, r23, new b(this), false);
        this.shrinkStrategy = r111;
        r12.i(r16);
        r13.i(r20);
        r110.i(r21);
        r111.i(r22);
        r15.recycle();
        setShapeAppearanceModel(com.google.android.material.shape.l.g(r14, r18, r19, r10, com.google.android.material.shape.l.f3644m).m());
        saveOriginalTextCsl();
    }

    static /* synthetic */ int access$000(ExtendedFloatingActionButton r10) {
        return r10.extendedPaddingStart;
    }

    static /* synthetic */ int access$100(ExtendedFloatingActionButton r10) {
        return r10.extendedPaddingEnd;
    }

    static /* synthetic */ boolean access$1000(ExtendedFloatingActionButton r10) {
        return r10.isOrWillBeShown();
    }

    static /* synthetic */ boolean access$1100(ExtendedFloatingActionButton r10) {
        return r10.isOrWillBeHidden();
    }

    static /* synthetic */ com.google.android.material.floatingactionbutton.e access$200(ExtendedFloatingActionButton r10) {
        return r10.shrinkStrategy;
    }

    static /* synthetic */ com.google.android.material.floatingactionbutton.e access$300(ExtendedFloatingActionButton r10) {
        return r10.hideStrategy;
    }

    static /* synthetic */ void access$400(ExtendedFloatingActionButton r10, com.google.android.material.floatingactionbutton.e r11, j r12) {
        r10.performMotion(r11, r12);
    }

    static /* synthetic */ com.google.android.material.floatingactionbutton.e access$500(ExtendedFloatingActionButton r10) {
        return r10.extendStrategy;
    }

    static /* synthetic */ com.google.android.material.floatingactionbutton.e access$600(ExtendedFloatingActionButton r10) {
        return r10.showStrategy;
    }

    static /* synthetic */ boolean access$700(ExtendedFloatingActionButton r10) {
        return r10.isExtended;
    }

    static /* synthetic */ boolean access$702(ExtendedFloatingActionButton r10, boolean r11) {
        r10.isExtended = r11;
        return r11;
    }

    static /* synthetic */ boolean access$802(ExtendedFloatingActionButton r10, boolean r11) {
        r10.isTransforming = r11;
        return r11;
    }

    static /* synthetic */ int access$902(ExtendedFloatingActionButton r10, int r11) {
        r10.animState = r11;
        return r11;
    }

    private boolean isOrWillBeHidden() {
        int r10 = getVisibility();
        int r11 = this.animState;
        if (r10 != 0) goto L8;
        if (r11 == 1) goto L6;
        return false;
    L6:
        return true;
    L8:
        if (r11 != 2) goto L10;
        return false;
    L10:
        return true;
    }

    private boolean isOrWillBeShown() {
        int r10 = getVisibility();
        int r11 = this.animState;
        if (r10 != 0) goto L5;
        if (r11 != 1) goto L10;
        return false;
    L10:
        return true;
    L5:
        if (r11 == 2) goto L7;
        return false;
    L7:
        return true;
    }

    private void performMotion(@NonNull com.google.android.material.floatingactionbutton.e r10, @Nullable j r11) {
        if (r10.e() == false) goto L6;
        return;
    L6:
        if (shouldAnimateVisibilityChange() == true) goto L9;
        r10.c();
        r10.l(r11);
        return;
    L9:
        measure(0, 0);
        AnimatorSet r12 = r10.j();
        r12.addListener(new c(this, r10, r11));
        Iterator<Animator.AnimatorListener> r13 = r10.k().iterator();
    L11:
        if (r13.hasNext() == false) goto L13;
        r12.addListener(r13.next());
        goto L11
    L13:
        r12.start();
    }

    private void saveOriginalTextCsl() {
        this.originalTextCsl = getTextColors();
    }

    private boolean shouldAnimateVisibilityChange() {
        if (ViewCompat.isLaidOut(this) == true) goto L9;
        if (isOrWillBeShown() == false) goto L7;
    L11:
        return false;
    L7:
        if (this.animateShowBeforeLayout == false) goto L11;
    L9:
        if (isInEditMode() == true) goto L11;
        return true;
    }

    public void addOnExtendAnimationListener(@NonNull Animator.AnimatorListener r10) {
        this.extendStrategy.g(r10);
    }

    public void addOnHideAnimationListener(@NonNull Animator.AnimatorListener r10) {
        this.hideStrategy.g(r10);
    }

    public void addOnShowAnimationListener(@NonNull Animator.AnimatorListener r10) {
        this.showStrategy.g(r10);
    }

    public void addOnShrinkAnimationListener(@NonNull Animator.AnimatorListener r10) {
        this.shrinkStrategy.g(r10);
    }

    public void extend() {
        performMotion(this.extendStrategy, null);
    }

    public void extend(@NonNull j r10) {
        performMotion(this.extendStrategy, r10);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.AttachedBehavior
    @NonNull
    public CoordinatorLayout.Behavior<ExtendedFloatingActionButton> getBehavior() {
        return this.behavior;
    }

    int getCollapsedPadding() {
        return (getCollapsedSize() - getIconSize()) / 2;
    }

    @VisibleForTesting
    int getCollapsedSize() {
        int r10 = this.collapsedSize;
        if (r10 < 0) goto L5;
        return r10;
    L5:
        return (Math.min(ViewCompat.getPaddingStart(this), ViewCompat.getPaddingEnd(this)) * 2) + getIconSize();
    }

    @Nullable
    public r5.h getExtendMotionSpec() {
        return this.extendStrategy.d();
    }

    @Nullable
    public r5.h getHideMotionSpec() {
        return this.hideStrategy.d();
    }

    @Nullable
    public r5.h getShowMotionSpec() {
        return this.showStrategy.d();
    }

    @Nullable
    public r5.h getShrinkMotionSpec() {
        return this.shrinkStrategy.d();
    }

    public void hide() {
        performMotion(this.hideStrategy, null);
    }

    public void hide(@NonNull j r10) {
        performMotion(this.hideStrategy, r10);
    }

    public final boolean isExtended() {
        return this.isExtended;
    }

    @Override // com.google.android.material.button.MaterialButton, android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.isExtended == true) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(getText()) == true) goto L7;
        return;
    L7:
        if (getIcon() == null) goto L12;
        this.isExtended = false;
        this.shrinkStrategy.c();
        return;
    }

    public void removeOnExtendAnimationListener(@NonNull Animator.AnimatorListener r10) {
        this.extendStrategy.f(r10);
    }

    public void removeOnHideAnimationListener(@NonNull Animator.AnimatorListener r10) {
        this.hideStrategy.f(r10);
    }

    public void removeOnShowAnimationListener(@NonNull Animator.AnimatorListener r10) {
        this.showStrategy.f(r10);
    }

    public void removeOnShrinkAnimationListener(@NonNull Animator.AnimatorListener r10) {
        this.shrinkStrategy.f(r10);
    }

    public void setAnimateShowBeforeLayout(boolean r10) {
        this.animateShowBeforeLayout = r10;
    }

    public void setExtendMotionSpec(@Nullable r5.h r10) {
        this.extendStrategy.i(r10);
    }

    public void setExtendMotionSpecResource(@AnimatorRes int r10) {
        setExtendMotionSpec(r5.h.d(getContext(), r10));
    }

    public void setExtended(boolean r10) {
        if (this.isExtended != r10) goto L5;
        return;
    L5:
        if (r10 == false) goto L7;
        com.google.android.material.floatingactionbutton.e r11 = this.extendStrategy;
    L9:
        if (r11.e() == false) goto L11;
        return;
    L11:
        r11.c();
        return;
    L7:
        r11 = this.shrinkStrategy;
        goto L9
    }

    public void setHideMotionSpec(@Nullable r5.h r10) {
        this.hideStrategy.i(r10);
    }

    public void setHideMotionSpecResource(@AnimatorRes int r10) {
        setHideMotionSpec(r5.h.d(getContext(), r10));
    }

    @Override // android.widget.TextView, android.view.View
    public void setPadding(int r10, int r11, int r12, int r13) {
        super.setPadding(r10, r11, r12, r13);
        if (this.isExtended == true) goto L5;
        return;
    L5:
        if (this.isTransforming == true) goto L9;
        this.extendedPaddingStart = ViewCompat.getPaddingStart(this);
        this.extendedPaddingEnd = ViewCompat.getPaddingEnd(this);
        return;
    }

    @Override // android.widget.TextView, android.view.View
    public void setPaddingRelative(int r10, int r11, int r12, int r13) {
        super.setPaddingRelative(r10, r11, r12, r13);
        if (this.isExtended == true) goto L5;
        return;
    L5:
        if (this.isTransforming == true) goto L9;
        this.extendedPaddingStart = r10;
        this.extendedPaddingEnd = r12;
        return;
    }

    public void setShowMotionSpec(@Nullable r5.h r10) {
        this.showStrategy.i(r10);
    }

    public void setShowMotionSpecResource(@AnimatorRes int r10) {
        setShowMotionSpec(r5.h.d(getContext(), r10));
    }

    public void setShrinkMotionSpec(@Nullable r5.h r10) {
        this.shrinkStrategy.i(r10);
    }

    public void setShrinkMotionSpecResource(@AnimatorRes int r10) {
        setShrinkMotionSpec(r5.h.d(getContext(), r10));
    }

    @Override // android.widget.TextView
    public void setTextColor(int r10) {
        super.setTextColor(r10);
        saveOriginalTextCsl();
    }

    @Override // android.widget.TextView
    public void setTextColor(@NonNull ColorStateList r10) {
        super.setTextColor(r10);
        saveOriginalTextCsl();
    }

    public void show() {
        performMotion(this.showStrategy, null);
    }

    public void show(@NonNull j r10) {
        performMotion(this.showStrategy, r10);
    }

    public void shrink() {
        performMotion(this.shrinkStrategy, null);
    }

    public void shrink(@NonNull j r10) {
        performMotion(this.shrinkStrategy, r10);
    }

    protected void silentlyUpdateTextColor(@NonNull ColorStateList r10) {
        super.setTextColor(r10);
    }
}
