package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
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
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import com.google.android.material.a.h;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.internal.k;
import com.google.android.material.shape.l;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
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
    private final CoordinatorLayout.Behavior<ExtendedFloatingActionButton> behavior;
    private final com.google.android.material.floatingactionbutton.a changeVisibilityTracker;
    private final int collapsedSize;
    private final com.google.android.material.floatingactionbutton.e extendStrategy;
    private int extendedPaddingEnd;
    private int extendedPaddingStart;
    private final com.google.android.material.floatingactionbutton.e hideStrategy;
    private boolean isExtended;
    private boolean isTransforming;
    protected ColorStateList originalTextCsl;
    private final com.google.android.material.floatingactionbutton.e showStrategy;
    private final com.google.android.material.floatingactionbutton.e shrinkStrategy;

    protected static class ExtendedFloatingActionButtonBehavior<T extends ExtendedFloatingActionButton> extends CoordinatorLayout.Behavior<T> {
        private static final boolean AUTO_HIDE_DEFAULT = false;
        private static final boolean AUTO_SHRINK_DEFAULT = true;
        private boolean autoHideEnabled;
        private boolean autoShrinkEnabled;
        private c internalAutoHideCallback;
        private c internalAutoShrinkCallback;
        private Rect tmpRect;

        public ExtendedFloatingActionButtonBehavior() {
            this.autoHideEnabled = false;
            this.autoShrinkEnabled = true;
        }

        public ExtendedFloatingActionButtonBehavior(Context r3, AttributeSet r4) {
            Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
            AttributeSet r6 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin");
            super(r5, r6);
            TypedArray r7 = r5.obtainStyledAttributes(r6, R.styleable.ExtendedFloatingActionButton_Behavior_Layout);
            this.autoHideEnabled = r7.getBoolean(ZeusTransformUtils.mapRes(R.styleable.ExtendedFloatingActionButton_Behavior_Layout_behavior_autoHide, "styleable", "ExtendedFloatingActionButton_Behavior_Layout_behavior_autoHide"), false);
            this.autoShrinkEnabled = r7.getBoolean(ZeusTransformUtils.mapRes(R.styleable.ExtendedFloatingActionButton_Behavior_Layout_behavior_autoShrink, "styleable", "ExtendedFloatingActionButton_Behavior_Layout_behavior_autoShrink"), true);
            r7.recycle();
        }

        private static boolean isBottomSheet(View r2) {
            ViewGroup.LayoutParams r3 = r2.getLayoutParams();
            if (ZeusTransformUtils.instanceOf(r3, CoordinatorLayout.LayoutParams.class) == true) goto L5;
            return false;
        L5:
            return ZeusTransformUtils.instanceOf(((CoordinatorLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r3, CoordinatorLayout.LayoutParams.class, "com.obric.memorydata.plugin")).getBehavior(), BottomSheetBehavior.class);
        }

        private boolean shouldUpdateVisibility(View r3, ExtendedFloatingActionButton r4) {
            CoordinatorLayout.LayoutParams r5 = (CoordinatorLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r4.getLayoutParams(), CoordinatorLayout.LayoutParams.class, "com.obric.memorydata.plugin");
            if (this.autoHideEnabled == true) goto L8;
            if (this.autoShrinkEnabled == true) goto L8;
            return false;
        L8:
            if (r5.getAnchorId() == r3.getId()) goto L10;
            return false;
        L10:
            return true;
        }

        private boolean updateFabVisibilityForAppBarLayout(CoordinatorLayout r2, AppBarLayout r3, ExtendedFloatingActionButton r4) {
            if (shouldUpdateVisibility(r3, r4) == true) goto L7;
            return false;
        L7:
            if (this.tmpRect != null) goto L9;
            this.tmpRect = new Rect();
        L9:
            Rect r0 = this.tmpRect;
            com.google.android.material.internal.d.b(r2, r3, r0);
            if (r0.bottom > r3.getMinimumHeightForVisibleOverlappingContent()) goto L12;
            shrinkOrHide(r4);
            return true;
        L12:
            extendOrShow(r4);
            return true;
        }

        private boolean updateFabVisibilityForBottomSheet(View r4, ExtendedFloatingActionButton r5) {
            if (shouldUpdateVisibility(r4, r5) == true) goto L6;
            return false;
        L6:
            CoordinatorLayout.LayoutParams r0 = (CoordinatorLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r5.getLayoutParams(), CoordinatorLayout.LayoutParams.class, "com.obric.memorydata.plugin");
            if (r4.getTop() >= ((r5.getHeight() / 2) + r0.topMargin)) goto L9;
            shrinkOrHide(r5);
            return true;
        L9:
            extendOrShow(r5);
            return true;
        }

        public void extendOrShow(ExtendedFloatingActionButton r2) {
            boolean r0 = this.autoShrinkEnabled;
            if (r0 == false) goto L5;
            c r1 = this.internalAutoShrinkCallback;
        L6:
            if (r0 == false) goto L8;
            com.google.android.material.floatingactionbutton.e r3 = ExtendedFloatingActionButton.access$500(r2);
        L9:
            ExtendedFloatingActionButton.access$400(r2, r3, r1);
            return;
        L8:
            r3 = ExtendedFloatingActionButton.access$600(r2);
            goto L9
        L5:
            r1 = this.internalAutoHideCallback;
            goto L6
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* synthetic */ boolean getInsetDodgeRect(CoordinatorLayout r3, View r4, Rect r5) {
            return getInsetDodgeRect(r3, (ExtendedFloatingActionButton) ZeusTransformUtils.preCheckCast(r4, ExtendedFloatingActionButton.class, "com.obric.memorydata.plugin"), r5);
        }

        public boolean getInsetDodgeRect(CoordinatorLayout r1, ExtendedFloatingActionButton r2, Rect r3) {
            return super.getInsetDodgeRect(r1, r2, r3);
        }

        public boolean isAutoHideEnabled() {
            return this.autoHideEnabled;
        }

        public boolean isAutoShrinkEnabled() {
            return this.autoShrinkEnabled;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public void onAttachedToLayoutParams(CoordinatorLayout.LayoutParams r1) {
            if (r1.dodgeInsetEdges != 0) goto L6;
            r1.dodgeInsetEdges = 80;
            return;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* synthetic */ boolean onDependentViewChanged(CoordinatorLayout r3, View r4, View r5) {
            return onDependentViewChanged(r3, (ExtendedFloatingActionButton) ZeusTransformUtils.preCheckCast(r4, ExtendedFloatingActionButton.class, "com.obric.memorydata.plugin"), r5);
        }

        public boolean onDependentViewChanged(CoordinatorLayout r3, ExtendedFloatingActionButton r4, View r5) {
            if (ZeusTransformUtils.instanceOf(r5, AppBarLayout.class) == false) goto L6;
            updateFabVisibilityForAppBarLayout(r3, (AppBarLayout) ZeusTransformUtils.preCheckCast(r5, AppBarLayout.class, "com.obric.memorydata.plugin"), r4);
            return false;
        L6:
            if (isBottomSheet(r5) == false) goto L11;
            updateFabVisibilityForBottomSheet(r5, r4);
            return false;
        L11:
            return false;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* synthetic */ boolean onLayoutChild(CoordinatorLayout r3, View r4, int r5) {
            return onLayoutChild(r3, (ExtendedFloatingActionButton) ZeusTransformUtils.preCheckCast(r4, ExtendedFloatingActionButton.class, "com.obric.memorydata.plugin"), r5);
        }

        public boolean onLayoutChild(CoordinatorLayout r7, ExtendedFloatingActionButton r8, int r9) {
            List<View> r0 = r7.getDependencies(r8);
            int r1 = r0.size();
            int r2 = 0;
        L3:
            if (r2 >= r1) goto L15;
            View r3 = (View) ZeusTransformUtils.preCheckCast(r0.get(r2), View.class, "com.obric.memorydata.plugin");
            if (ZeusTransformUtils.instanceOf(r3, AppBarLayout.class) == false) goto L10;
            if (updateFabVisibilityForAppBarLayout(r7, (AppBarLayout) ZeusTransformUtils.preCheckCast(r3, AppBarLayout.class, "com.obric.memorydata.plugin"), r8) == true) goto L15;
        L14:
            r2 = r2 + 1;
            goto L3
        L10:
            if (isBottomSheet(r3) == false) goto L14;
            if (updateFabVisibilityForBottomSheet(r3, r8) == false) goto L14;
        L15:
            r7.onLayoutChild(r8, r9);
            return true;
        }

        public void setAutoHideEnabled(boolean r1) {
            this.autoHideEnabled = r1;
        }

        public void setAutoShrinkEnabled(boolean r1) {
            this.autoShrinkEnabled = r1;
        }

        void setInternalAutoHideCallback(c r1) {
            this.internalAutoHideCallback = r1;
        }

        void setInternalAutoShrinkCallback(c r1) {
            this.internalAutoShrinkCallback = r1;
        }

        public void shrinkOrHide(ExtendedFloatingActionButton r2) {
            boolean r0 = this.autoShrinkEnabled;
            if (r0 == false) goto L5;
            c r1 = this.internalAutoShrinkCallback;
        L6:
            if (r0 == false) goto L8;
            com.google.android.material.floatingactionbutton.e r3 = ExtendedFloatingActionButton.access$200(r2);
        L9:
            ExtendedFloatingActionButton.access$400(r2, r3, r1);
            return;
        L8:
            r3 = ExtendedFloatingActionButton.access$300(r2);
            goto L9
        L5:
            r1 = this.internalAutoHideCallback;
            goto L6
        }
    }

    class a extends com.google.android.material.floatingactionbutton.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ExtendedFloatingActionButton f3908a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final e f3909b;
        private final boolean c;

        a(ExtendedFloatingActionButton r3, com.google.android.material.floatingactionbutton.a r4, e r5, boolean r6) {
            e r7 = (e) ZeusTransformUtils.wrapperContextForParams(r5, e.class, "com.obric.memorydata.plugin");
            this.f3908a = r3;
            super(r3, r4);
            this.f3909b = r7;
            this.c = r6;
        }

        @Override // com.google.android.material.floatingactionbutton.b, com.google.android.material.floatingactionbutton.e
        public void a(Animator r2) {
            super.a(r2);
            ExtendedFloatingActionButton.access$702(this.f3908a, this.c);
            ExtendedFloatingActionButton.access$802(this.f3908a, true);
            this.f3908a.setHorizontallyScrolling(true);
        }

        @Override // com.google.android.material.floatingactionbutton.e
        public void a(c r2) {
            if (r2 != null) goto L4;
            return;
        L4:
            boolean r0 = this.c;
            ExtendedFloatingActionButton r1 = this.f3908a;
            if (r0 == false) goto L7;
            r2.c(r1);
            return;
        L7:
            r2.d(r1);
        }

        @Override // com.google.android.material.floatingactionbutton.b, com.google.android.material.floatingactionbutton.e
        public void d() {
            super.d();
            ExtendedFloatingActionButton.access$802(this.f3908a, false);
            this.f3908a.setHorizontallyScrolling(false);
            ViewGroup.LayoutParams r0 = this.f3908a.getLayoutParams();
            if (r0 != null) goto L5;
            return;
        L5:
            r0.width = this.f3909b.e().width;
            r0.height = this.f3909b.e().height;
        }

        @Override // com.google.android.material.floatingactionbutton.b, com.google.android.material.floatingactionbutton.e
        public AnimatorSet f() {
            h r0 = a();
            if (r0.c("width") == false) goto L6;
            PropertyValuesHolder[] r2 = r0.d("width");
            r2[0].setFloatValues(new float[]{this.f3908a.getWidth(), this.f3909b.a()});
            r0.a("width", r2);
        L6:
            if (r0.c("height") == false) goto L9;
            PropertyValuesHolder[] r3 = r0.d("height");
            r3[0].setFloatValues(new float[]{this.f3908a.getHeight(), this.f3909b.b()});
            r0.a("height", r3);
        L9:
            if (r0.c("paddingStart") == false) goto L12;
            PropertyValuesHolder[] r4 = r0.d("paddingStart");
            r4[0].setFloatValues(new float[]{ViewCompat.getPaddingStart(this.f3908a), this.f3909b.c()});
            r0.a("paddingStart", r4);
        L12:
            if (r0.c("paddingEnd") == false) goto L15;
            PropertyValuesHolder[] r5 = r0.d("paddingEnd");
            r5[0].setFloatValues(new float[]{ViewCompat.getPaddingEnd(this.f3908a), this.f3909b.d()});
            r0.a("paddingEnd", r5);
        L15:
            if (r0.c("labelOpacity") == false) goto L24;
            PropertyValuesHolder[] r6 = r0.d("labelOpacity");
            boolean r7 = this.c;
            float r8 = 0.0f;
            if (r7 == false) goto L19;
            float r9 = 0.0f;
        L20:
            if (r7 == false) goto L22;
            r8 = 1.0f;
        L22:
            r6[0].setFloatValues(new float[]{r9, r8});
            r0.a("labelOpacity", r6);
            goto L24
        L19:
            r9 = 1.0f;
        L24:
            return super.b(r0);
        }

        @Override // com.google.android.material.floatingactionbutton.e
        public void g() {
            ExtendedFloatingActionButton.access$702(this.f3908a, this.c);
            ViewGroup.LayoutParams r0 = this.f3908a.getLayoutParams();
            if (r0 != null) goto L5;
            return;
        L5:
            r0.width = this.f3909b.e().width;
            r0.height = this.f3909b.e().height;
            ViewCompat.setPaddingRelative(this.f3908a, this.f3909b.c(), this.f3908a.getPaddingTop(), this.f3909b.d(), this.f3908a.getPaddingBottom());
            this.f3908a.requestLayout();
        }

        @Override // com.google.android.material.floatingactionbutton.e
        public int h() {
            if (this.c == false) goto L5;
            int r2 = R.animator.mtrl_extended_fab_change_size_expand_motion_spec;
            String r1 = "mtrl_extended_fab_change_size_expand_motion_spec";
        L7:
            return ZeusTransformUtils.mapRes(r2, "animator", r1);
        L5:
            r2 = R.animator.mtrl_extended_fab_change_size_collapse_motion_spec;
            r1 = "mtrl_extended_fab_change_size_collapse_motion_spec";
            goto L7
        }

        @Override // com.google.android.material.floatingactionbutton.e
        public boolean i() {
            if (this.c != ExtendedFloatingActionButton.access$700(this.f3908a)) goto L5;
        L10:
            return true;
        L5:
            if (this.f3908a.getIcon() == null) goto L10;
            if (TextUtils.isEmpty(this.f3908a.getText()) == true) goto L10;
            return false;
        }
    }

    class b extends com.google.android.material.floatingactionbutton.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ExtendedFloatingActionButton f3910a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f3911b;

        public b(ExtendedFloatingActionButton r1, com.google.android.material.floatingactionbutton.a r2) {
            this.f3910a = r1;
            super(r1, r2);
        }

        @Override // com.google.android.material.floatingactionbutton.b, com.google.android.material.floatingactionbutton.e
        public void a(Animator r2) {
            super.a(r2);
            this.f3911b = false;
            this.f3910a.setVisibility(0);
            ExtendedFloatingActionButton.access$902(this.f3910a, 1);
        }

        @Override // com.google.android.material.floatingactionbutton.e
        public void a(c r1) {
            if (r1 == null) goto L5;
            r1.b(this.f3910a);
            return;
        }

        @Override // com.google.android.material.floatingactionbutton.b, com.google.android.material.floatingactionbutton.e
        public void d() {
            super.d();
            ExtendedFloatingActionButton.access$902(this.f3910a, 0);
            if (this.f3911b == true) goto L6;
            this.f3910a.setVisibility(8);
            return;
        }

        @Override // com.google.android.material.floatingactionbutton.b, com.google.android.material.floatingactionbutton.e
        public void e() {
            super.e();
            this.f3911b = true;
        }

        @Override // com.google.android.material.floatingactionbutton.e
        public void g() {
            this.f3910a.setVisibility(8);
        }

        @Override // com.google.android.material.floatingactionbutton.e
        public int h() {
            return ZeusTransformUtils.mapRes(R.animator.mtrl_extended_fab_hide_motion_spec, "animator", "mtrl_extended_fab_hide_motion_spec");
        }

        @Override // com.google.android.material.floatingactionbutton.e
        public boolean i() {
            return ExtendedFloatingActionButton.access$1100(this.f3910a);
        }
    }

    public static abstract class c {
        public void a(ExtendedFloatingActionButton r1) {
        }

        public void b(ExtendedFloatingActionButton r1) {
        }

        public void c(ExtendedFloatingActionButton r1) {
        }

        public void d(ExtendedFloatingActionButton r1) {
        }
    }

    class d extends com.google.android.material.floatingactionbutton.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ExtendedFloatingActionButton f3912a;

        public d(ExtendedFloatingActionButton r1, com.google.android.material.floatingactionbutton.a r2) {
            this.f3912a = r1;
            super(r1, r2);
        }

        @Override // com.google.android.material.floatingactionbutton.b, com.google.android.material.floatingactionbutton.e
        public void a(Animator r2) {
            super.a(r2);
            this.f3912a.setVisibility(0);
            ExtendedFloatingActionButton.access$902(this.f3912a, 2);
        }

        @Override // com.google.android.material.floatingactionbutton.e
        public void a(c r1) {
            if (r1 == null) goto L5;
            r1.a(this.f3912a);
            return;
        }

        @Override // com.google.android.material.floatingactionbutton.b, com.google.android.material.floatingactionbutton.e
        public void d() {
            super.d();
            ExtendedFloatingActionButton.access$902(this.f3912a, 0);
        }

        @Override // com.google.android.material.floatingactionbutton.e
        public void g() {
            this.f3912a.setVisibility(0);
            this.f3912a.setAlpha(1.0f);
            this.f3912a.setScaleY(1.0f);
            this.f3912a.setScaleX(1.0f);
        }

        @Override // com.google.android.material.floatingactionbutton.e
        public int h() {
            return ZeusTransformUtils.mapRes(R.animator.mtrl_extended_fab_show_motion_spec, "animator", "mtrl_extended_fab_show_motion_spec");
        }

        @Override // com.google.android.material.floatingactionbutton.e
        public boolean i() {
            return ExtendedFloatingActionButton.access$1000(this.f3912a);
        }
    }

    interface e {
        int a();

        int b();

        int c();

        int d();

        ViewGroup.LayoutParams e();
    }

    static {
        DEF_STYLE_RES = ZeusTransformUtils.mapRes(R.style.Widget_MaterialComponents_ExtendedFloatingActionButton_Icon, "style", "Widget_MaterialComponents_ExtendedFloatingActionButton_Icon");
        final Class<Float> r1 = Float.class;
        final String r2 = "width";
        WIDTH = new AnonymousClass4(r1, r2);
        final Class<Float> r3 = Float.class;
        final String r4 = "height";
        HEIGHT = new AnonymousClass5(r3, r4);
        final Class<Float> r5 = Float.class;
        final String r6 = "paddingStart";
        PADDING_START = new AnonymousClass6(r5, r6);
        final Class<Float> r7 = Float.class;
        final String r8 = "paddingEnd";
        PADDING_END = new AnonymousClass7(r7, r8);
    }

    public ExtendedFloatingActionButton(Context r3) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), null);
    }

    public ExtendedFloatingActionButton(Context r4, AttributeSet r5) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r5, AttributeSet.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.attr.extendedFloatingActionButtonStyle, "attr", "extendedFloatingActionButtonStyle"));
    }

    public ExtendedFloatingActionButton(Context r17, AttributeSet r18, int r19) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r17, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r18, AttributeSet.class, "com.obric.memorydata.plugin");
        int r9 = DEF_STYLE_RES;
        super((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.google.android.material.theme.a.a.a(r1, r8, r19, r9), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r8, r19);
        this.animState = 0;
        com.google.android.material.floatingactionbutton.a r2 = new com.google.android.material.floatingactionbutton.a();
        this.changeVisibilityTracker = r2;
        d r11 = new d(this, r2);
        this.showStrategy = r11;
        b r12 = new b(this, r2);
        this.hideStrategy = r12;
        this.isExtended = true;
        this.isTransforming = false;
        this.animateShowBeforeLayout = false;
        Context r14 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        this.behavior = new ExtendedFloatingActionButtonBehavior(r14, r8);
        TypedArray r3 = k.a(r14, r8, R.styleable.ExtendedFloatingActionButton, r19, r9, new int[0]);
        h r4 = h.a(r14, r3, ZeusTransformUtils.mapRes(R.styleable.ExtendedFloatingActionButton_showMotionSpec, "styleable", "ExtendedFloatingActionButton_showMotionSpec"));
        h r5 = h.a(r14, r3, ZeusTransformUtils.mapRes(R.styleable.ExtendedFloatingActionButton_hideMotionSpec, "styleable", "ExtendedFloatingActionButton_hideMotionSpec"));
        h r6 = h.a(r14, r3, ZeusTransformUtils.mapRes(R.styleable.ExtendedFloatingActionButton_extendMotionSpec, "styleable", "ExtendedFloatingActionButton_extendMotionSpec"));
        h r7 = h.a(r14, r3, ZeusTransformUtils.mapRes(R.styleable.ExtendedFloatingActionButton_shrinkMotionSpec, "styleable", "ExtendedFloatingActionButton_shrinkMotionSpec"));
        this.collapsedSize = r3.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.ExtendedFloatingActionButton_collapsedSize, "styleable", "ExtendedFloatingActionButton_collapsedSize"), -1);
        this.extendedPaddingStart = ViewCompat.getPaddingStart(this);
        this.extendedPaddingEnd = ViewCompat.getPaddingEnd(this);
        com.google.android.material.floatingactionbutton.a r10 = new com.google.android.material.floatingactionbutton.a();
        a r13 = new a(this, r10, new AnonymousClass1(this), true);
        this.extendStrategy = r13;
        a r15 = new a(this, r10, new AnonymousClass2(this), false);
        this.shrinkStrategy = r15;
        r11.a(r4);
        r12.a(r5);
        r13.a(r6);
        r15.a(r7);
        r3.recycle();
        setShapeAppearanceModel(l.a(r14, r8, r19, r9, l.f4049a).a());
        saveOriginalTextCsl();
    }

    static /* synthetic */ int access$000(ExtendedFloatingActionButton r0) {
        return r0.extendedPaddingStart;
    }

    static /* synthetic */ int access$100(ExtendedFloatingActionButton r0) {
        return r0.extendedPaddingEnd;
    }

    static /* synthetic */ boolean access$1000(ExtendedFloatingActionButton r0) {
        return r0.isOrWillBeShown();
    }

    static /* synthetic */ boolean access$1100(ExtendedFloatingActionButton r0) {
        return r0.isOrWillBeHidden();
    }

    static /* synthetic */ com.google.android.material.floatingactionbutton.e access$200(ExtendedFloatingActionButton r0) {
        return r0.shrinkStrategy;
    }

    static /* synthetic */ com.google.android.material.floatingactionbutton.e access$300(ExtendedFloatingActionButton r0) {
        return r0.hideStrategy;
    }

    static /* synthetic */ void access$400(ExtendedFloatingActionButton r2, com.google.android.material.floatingactionbutton.e r3, c r4) {
        r2.performMotion((com.google.android.material.floatingactionbutton.e) ZeusTransformUtils.wrapperContextForParams(r3, com.google.android.material.floatingactionbutton.e.class, "com.obric.memorydata.plugin"), r4);
    }

    static /* synthetic */ com.google.android.material.floatingactionbutton.e access$500(ExtendedFloatingActionButton r0) {
        return r0.extendStrategy;
    }

    static /* synthetic */ com.google.android.material.floatingactionbutton.e access$600(ExtendedFloatingActionButton r0) {
        return r0.showStrategy;
    }

    static /* synthetic */ boolean access$700(ExtendedFloatingActionButton r0) {
        return r0.isExtended;
    }

    static /* synthetic */ boolean access$702(ExtendedFloatingActionButton r0, boolean r1) {
        r0.isExtended = r1;
        return r1;
    }

    static /* synthetic */ boolean access$802(ExtendedFloatingActionButton r0, boolean r1) {
        r0.isTransforming = r1;
        return r1;
    }

    static /* synthetic */ int access$902(ExtendedFloatingActionButton r0, int r1) {
        r0.animState = r1;
        return r1;
    }

    private boolean isOrWillBeHidden() {
        int r0 = getVisibility();
        int r3 = this.animState;
        if (r0 != 0) goto L8;
        if (r3 == 1) goto L6;
        return false;
    L6:
        return true;
    L8:
        if (r3 != 2) goto L10;
        return false;
    L10:
        return true;
    }

    private boolean isOrWillBeShown() {
        int r0 = getVisibility();
        int r3 = this.animState;
        if (r0 != 0) goto L5;
        if (r3 != 1) goto L10;
        return false;
    L10:
        return true;
    L5:
        if (r3 == 2) goto L7;
        return false;
    L7:
        return true;
    }

    private void performMotion(com.google.android.material.floatingactionbutton.e r4, final c r5) {
        final com.google.android.material.floatingactionbutton.e r6 = (com.google.android.material.floatingactionbutton.e) ZeusTransformUtils.wrapperContextForParams(r4, com.google.android.material.floatingactionbutton.e.class, "com.obric.memorydata.plugin");
        if (r6.i() == false) goto L6;
        return;
    L6:
        if (shouldAnimateVisibilityChange() == true) goto L9;
        r6.g();
        r6.a(r5);
        return;
    L9:
        measure(0, 0);
        AnimatorSet r0 = r6.f();
        r0.addListener(new AnonymousClass3(this, r6, r5));
        Iterator<Animator.AnimatorListener> r3 = r6.b().iterator();
    L11:
        if (r3.hasNext() == false) goto L13;
        r0.addListener((Animator.AnimatorListener) ZeusTransformUtils.preCheckCast(r3.next(), Animator.AnimatorListener.class, "com.obric.memorydata.plugin"));
        goto L11
    L13:
        r0.start();
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

    public void addOnExtendAnimationListener(Animator.AnimatorListener r3) {
        Animator.AnimatorListener r4 = (Animator.AnimatorListener) ZeusTransformUtils.wrapperContextForParams(r3, Animator.AnimatorListener.class, "com.obric.memorydata.plugin");
        this.extendStrategy.a(r4);
    }

    public void addOnHideAnimationListener(Animator.AnimatorListener r3) {
        Animator.AnimatorListener r4 = (Animator.AnimatorListener) ZeusTransformUtils.wrapperContextForParams(r3, Animator.AnimatorListener.class, "com.obric.memorydata.plugin");
        this.hideStrategy.a(r4);
    }

    public void addOnShowAnimationListener(Animator.AnimatorListener r3) {
        Animator.AnimatorListener r4 = (Animator.AnimatorListener) ZeusTransformUtils.wrapperContextForParams(r3, Animator.AnimatorListener.class, "com.obric.memorydata.plugin");
        this.showStrategy.a(r4);
    }

    public void addOnShrinkAnimationListener(Animator.AnimatorListener r3) {
        Animator.AnimatorListener r4 = (Animator.AnimatorListener) ZeusTransformUtils.wrapperContextForParams(r3, Animator.AnimatorListener.class, "com.obric.memorydata.plugin");
        this.shrinkStrategy.a(r4);
    }

    public void extend() {
        performMotion(this.extendStrategy, null);
    }

    public void extend(c r2) {
        performMotion(this.extendStrategy, r2);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.AttachedBehavior
    public CoordinatorLayout.Behavior<ExtendedFloatingActionButton> getBehavior() {
        return this.behavior;
    }

    int getCollapsedPadding() {
        return (getCollapsedSize() - getIconSize()) / 2;
    }

    int getCollapsedSize() {
        int r0 = this.collapsedSize;
        if (r0 < 0) goto L5;
        return r0;
    L5:
        return (Math.min(ViewCompat.getPaddingStart(this), ViewCompat.getPaddingEnd(this)) * 2) + getIconSize();
    }

    public h getExtendMotionSpec() {
        return this.extendStrategy.c();
    }

    public h getHideMotionSpec() {
        return this.hideStrategy.c();
    }

    public h getShowMotionSpec() {
        return this.showStrategy.c();
    }

    public h getShrinkMotionSpec() {
        return this.shrinkStrategy.c();
    }

    public void hide() {
        performMotion(this.hideStrategy, null);
    }

    public void hide(c r2) {
        performMotion(this.hideStrategy, r2);
    }

    public final boolean isExtended() {
        return this.isExtended;
    }

    @Override // com.google.android.material.button.MaterialButton, android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.isExtended == true) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(getText()) == true) goto L7;
        return;
    L7:
        if (getIcon() == null) goto L12;
        this.isExtended = false;
        this.shrinkStrategy.g();
        return;
    }

    public void removeOnExtendAnimationListener(Animator.AnimatorListener r3) {
        Animator.AnimatorListener r4 = (Animator.AnimatorListener) ZeusTransformUtils.wrapperContextForParams(r3, Animator.AnimatorListener.class, "com.obric.memorydata.plugin");
        this.extendStrategy.b(r4);
    }

    public void removeOnHideAnimationListener(Animator.AnimatorListener r3) {
        Animator.AnimatorListener r4 = (Animator.AnimatorListener) ZeusTransformUtils.wrapperContextForParams(r3, Animator.AnimatorListener.class, "com.obric.memorydata.plugin");
        this.hideStrategy.b(r4);
    }

    public void removeOnShowAnimationListener(Animator.AnimatorListener r3) {
        Animator.AnimatorListener r4 = (Animator.AnimatorListener) ZeusTransformUtils.wrapperContextForParams(r3, Animator.AnimatorListener.class, "com.obric.memorydata.plugin");
        this.showStrategy.b(r4);
    }

    public void removeOnShrinkAnimationListener(Animator.AnimatorListener r3) {
        Animator.AnimatorListener r4 = (Animator.AnimatorListener) ZeusTransformUtils.wrapperContextForParams(r3, Animator.AnimatorListener.class, "com.obric.memorydata.plugin");
        this.shrinkStrategy.b(r4);
    }

    public void setAnimateShowBeforeLayout(boolean r1) {
        this.animateShowBeforeLayout = r1;
    }

    public void setExtendMotionSpec(h r1) {
        this.extendStrategy.a(r1);
    }

    public void setExtendMotionSpecResource(int r4) {
        setExtendMotionSpec(h.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r4));
    }

    public void setExtended(boolean r2) {
        if (this.isExtended != r2) goto L5;
        return;
    L5:
        if (r2 == false) goto L7;
        com.google.android.material.floatingactionbutton.e r1 = this.extendStrategy;
    L9:
        if (r1.i() == false) goto L11;
        return;
    L11:
        r1.g();
        return;
    L7:
        r1 = this.shrinkStrategy;
        goto L9
    }

    public void setHideMotionSpec(h r1) {
        this.hideStrategy.a(r1);
    }

    public void setHideMotionSpecResource(int r4) {
        setHideMotionSpec(h.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r4));
    }

    @Override // android.widget.TextView, android.view.View
    public void setPadding(int r1, int r2, int r3, int r4) {
        super.setPadding(r1, r2, r3, r4);
        if (this.isExtended == true) goto L5;
        return;
    L5:
        if (this.isTransforming == true) goto L9;
        this.extendedPaddingStart = ViewCompat.getPaddingStart(this);
        this.extendedPaddingEnd = ViewCompat.getPaddingEnd(this);
        return;
    }

    @Override // android.widget.TextView, android.view.View
    public void setPaddingRelative(int r1, int r2, int r3, int r4) {
        super.setPaddingRelative(r1, r2, r3, r4);
        if (this.isExtended == true) goto L5;
        return;
    L5:
        if (this.isTransforming == true) goto L9;
        this.extendedPaddingStart = r1;
        this.extendedPaddingEnd = r3;
        return;
    }

    public void setShowMotionSpec(h r1) {
        this.showStrategy.a(r1);
    }

    public void setShowMotionSpecResource(int r4) {
        setShowMotionSpec(h.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r4));
    }

    public void setShrinkMotionSpec(h r1) {
        this.shrinkStrategy.a(r1);
    }

    public void setShrinkMotionSpecResource(int r4) {
        setShrinkMotionSpec(h.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r4));
    }

    @Override // android.widget.TextView
    public void setTextColor(int r1) {
        super.setTextColor(r1);
        saveOriginalTextCsl();
    }

    @Override // android.widget.TextView
    public void setTextColor(ColorStateList r1) {
        super.setTextColor(r1);
        saveOriginalTextCsl();
    }

    public void show() {
        performMotion(this.showStrategy, null);
    }

    public void show(c r2) {
        performMotion(this.showStrategy, r2);
    }

    public void shrink() {
        performMotion(this.shrinkStrategy, null);
    }

    public void shrink(c r2) {
        performMotion(this.shrinkStrategy, r2);
    }

    public void silentlyUpdateTextColor(ColorStateList r1) {
        super.setTextColor(r1);
    }
}
