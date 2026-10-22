package com.google.android.material.appbar;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.math.MathUtils;
import androidx.core.util.ObjectsCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.internal.d;
import com.google.android.material.internal.k;
import com.google.android.material.resources.c;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public class CollapsingToolbarLayout extends FrameLayout {
    private static final int f = 0;
    private int A;
    private boolean B;
    private int C;
    private boolean D;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final com.google.android.material.internal.b f3764a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final com.google.android.material.elevation.a f3765b;
    Drawable c;
    int d;
    WindowInsetsCompat e;
    private boolean g;
    private int h;
    private ViewGroup i;
    private View j;
    private View k;
    private int l;
    private int m;
    private int n;
    private int o;
    private final Rect p;
    private boolean q;
    private boolean r;
    private Drawable s;
    private int t;
    private boolean u;
    private ValueAnimator v;
    private long w;
    private int x;
    private AppBarLayout.e y;
    private int z;

    public static class LayoutParams extends FrameLayout.LayoutParams {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f3767a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        float f3768b;

        public LayoutParams(int r1, int r2) {
            super(r1, r2);
            this.f3767a = 0;
            this.f3768b = 0.5f;
        }

        public LayoutParams(Context r5, AttributeSet r6) {
            Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
            AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r6, AttributeSet.class, "com.obric.memorydata.plugin");
            super(r7, r8);
            this.f3767a = 0;
            this.f3768b = 0.5f;
            TypedArray r9 = r7.obtainStyledAttributes(r8, R.styleable.CollapsingToolbarLayout_Layout);
            this.f3767a = r9.getInt(ZeusTransformUtils.mapRes(R.styleable.CollapsingToolbarLayout_Layout_layout_collapseMode, "styleable", "CollapsingToolbarLayout_Layout_layout_collapseMode"), 0);
            a(r9.getFloat(ZeusTransformUtils.mapRes(R.styleable.CollapsingToolbarLayout_Layout_layout_collapseParallaxMultiplier, "styleable", "CollapsingToolbarLayout_Layout_layout_collapseParallaxMultiplier"), 0.5f));
            r9.recycle();
        }

        public LayoutParams(ViewGroup.LayoutParams r1) {
            super(r1);
            this.f3767a = 0;
            this.f3768b = 0.5f;
        }

        public void a(float r1) {
            this.f3768b = r1;
        }
    }

    private class a implements AppBarLayout.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ CollapsingToolbarLayout f3769a;

        a(CollapsingToolbarLayout r1) {
            this.f3769a = r1;
        }

        @Override // com.google.android.material.appbar.AppBarLayout.a
        public void onOffsetChanged(AppBarLayout r9, int r10) {
            this.f3769a.d = r10;
            if (this.f3769a.e == null) goto L5;
            int r11 = this.f3769a.e.getSystemWindowInsetTop();
        L6:
            int r1 = this.f3769a.getChildCount();
            int r2 = 0;
        L7:
            if (r2 >= r1) goto L17;
            View r3 = this.f3769a.getChildAt(r2);
            LayoutParams r4 = (LayoutParams) ZeusTransformUtils.preCheckCast(r3.getLayoutParams(), LayoutParams.class, "com.obric.memorydata.plugin");
            com.google.android.material.appbar.a r5 = CollapsingToolbarLayout.a(r3);
            int r6 = r4.f3767a;
            if (r6 != 1) goto L11;
            int r7 = MathUtils.clamp(-r10, 0, this.f3769a.b(r3));
        L15:
            r5.a(r7);
        L16:
            r2 = r2 + 1;
            goto L7
        L11:
            if (r6 != 2) goto L16;
            r7 = Math.round((-r10) * r4.f3768b);
            goto L15
        L17:
            this.f3769a.b();
            if (this.f3769a.c == null) goto L21;
            if (r11 <= 0) goto L21;
            ViewCompat.postInvalidateOnAnimation(this.f3769a);
        L21:
            int r0 = this.f3769a.getHeight();
            int r8 = (r0 - ViewCompat.getMinimumHeight(this.f3769a)) - r11;
            float r12 = r8;
            this.f3769a.f3764a.c(Math.min(1.0f, (r0 - this.f3769a.getScrimVisibleHeightTrigger()) / r12));
            this.f3769a.f3764a.a(this.f3769a.d + r8);
            this.f3769a.f3764a.d(Math.abs(r10) / r12);
            return;
        L5:
            r11 = 0;
            goto L6
        }
    }

    static {
        f = ZeusTransformUtils.mapRes(R.style.Widget_Design_CollapsingToolbar, "style", "Widget_Design_CollapsingToolbar");
    }

    public CollapsingToolbarLayout(Context r3) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), null);
    }

    public CollapsingToolbarLayout(Context r4, AttributeSet r5) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r5, AttributeSet.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.attr.collapsingToolbarLayoutStyle, "attr", "collapsingToolbarLayoutStyle"));
    }

    public CollapsingToolbarLayout(Context r10, AttributeSet r11, int r12) {
        Context r13 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r3 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r11, AttributeSet.class, "com.obric.memorydata.plugin");
        int r6 = f;
        super((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.google.android.material.theme.a.a.a(r13, r3, r12, r6), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r3, r12);
        this.g = true;
        this.p = new Rect();
        this.x = -1;
        this.A = 0;
        this.C = 0;
        Context r1 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        com.google.android.material.internal.b r8 = new com.google.android.material.internal.b(this);
        this.f3764a = r8;
        r8.a(com.google.android.material.a.a.e);
        r8.b(false);
        this.f3765b = new com.google.android.material.elevation.a(r1);
        TypedArray r14 = k.a(r1, r3, R.styleable.CollapsingToolbarLayout, r12, r6, new int[0]);
        r8.b(r14.getInt(ZeusTransformUtils.mapRes(R.styleable.CollapsingToolbarLayout_expandedTitleGravity, "styleable", "CollapsingToolbarLayout_expandedTitleGravity"), MaterialCardView.CHECKED_ICON_GRAVITY_BOTTOM_START));
        r8.c(r14.getInt(ZeusTransformUtils.mapRes(R.styleable.CollapsingToolbarLayout_collapsedTitleGravity, "styleable", "CollapsingToolbarLayout_collapsedTitleGravity"), 8388627));
        int r2 = r14.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.CollapsingToolbarLayout_expandedTitleMargin, "styleable", "CollapsingToolbarLayout_expandedTitleMargin"), 0);
        this.o = r2;
        this.n = r2;
        this.m = r2;
        this.l = r2;
        if (r14.hasValue(ZeusTransformUtils.mapRes(R.styleable.CollapsingToolbarLayout_expandedTitleMarginStart, "styleable", "CollapsingToolbarLayout_expandedTitleMarginStart")) == false) goto L6;
        this.l = r14.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.CollapsingToolbarLayout_expandedTitleMarginStart, "styleable", "CollapsingToolbarLayout_expandedTitleMarginStart"), 0);
    L6:
        if (r14.hasValue(ZeusTransformUtils.mapRes(R.styleable.CollapsingToolbarLayout_expandedTitleMarginEnd, "styleable", "CollapsingToolbarLayout_expandedTitleMarginEnd")) == false) goto L9;
        this.n = r14.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.CollapsingToolbarLayout_expandedTitleMarginEnd, "styleable", "CollapsingToolbarLayout_expandedTitleMarginEnd"), 0);
    L9:
        if (r14.hasValue(ZeusTransformUtils.mapRes(R.styleable.CollapsingToolbarLayout_expandedTitleMarginTop, "styleable", "CollapsingToolbarLayout_expandedTitleMarginTop")) == false) goto L12;
        this.m = r14.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.CollapsingToolbarLayout_expandedTitleMarginTop, "styleable", "CollapsingToolbarLayout_expandedTitleMarginTop"), 0);
    L12:
        if (r14.hasValue(ZeusTransformUtils.mapRes(R.styleable.CollapsingToolbarLayout_expandedTitleMarginBottom, "styleable", "CollapsingToolbarLayout_expandedTitleMarginBottom")) == false) goto L14;
        this.o = r14.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.CollapsingToolbarLayout_expandedTitleMarginBottom, "styleable", "CollapsingToolbarLayout_expandedTitleMarginBottom"), 0);
    L14:
        this.q = r14.getBoolean(ZeusTransformUtils.mapRes(R.styleable.CollapsingToolbarLayout_titleEnabled, "styleable", "CollapsingToolbarLayout_titleEnabled"), true);
        setTitle(r14.getText(ZeusTransformUtils.mapRes(R.styleable.CollapsingToolbarLayout_title, "styleable", "CollapsingToolbarLayout_title")));
        r8.e(ZeusTransformUtils.mapRes(R.style.TextAppearance_Design_CollapsingToolbar_Expanded, "style", "TextAppearance_Design_CollapsingToolbar_Expanded"));
        r8.d(ZeusTransformUtils.mapRes(R.style.TextAppearance_AppCompat_Widget_ActionBar_Title, "style", "TextAppearance_AppCompat_Widget_ActionBar_Title"));
        if (r14.hasValue(ZeusTransformUtils.mapRes(R.styleable.CollapsingToolbarLayout_expandedTitleTextAppearance, "styleable", "CollapsingToolbarLayout_expandedTitleTextAppearance")) == false) goto L18;
        r8.e(r14.getResourceId(ZeusTransformUtils.mapRes(R.styleable.CollapsingToolbarLayout_expandedTitleTextAppearance, "styleable", "CollapsingToolbarLayout_expandedTitleTextAppearance"), 0));
    L18:
        if (r14.hasValue(ZeusTransformUtils.mapRes(R.styleable.CollapsingToolbarLayout_collapsedTitleTextAppearance, "styleable", "CollapsingToolbarLayout_collapsedTitleTextAppearance")) == false) goto L21;
        r8.d(r14.getResourceId(ZeusTransformUtils.mapRes(R.styleable.CollapsingToolbarLayout_collapsedTitleTextAppearance, "styleable", "CollapsingToolbarLayout_collapsedTitleTextAppearance"), 0));
    L21:
        if (r14.hasValue(ZeusTransformUtils.mapRes(R.styleable.CollapsingToolbarLayout_expandedTitleTextColor, "styleable", "CollapsingToolbarLayout_expandedTitleTextColor")) == false) goto L24;
        r8.b(c.a(r1, r14, ZeusTransformUtils.mapRes(R.styleable.CollapsingToolbarLayout_expandedTitleTextColor, "styleable", "CollapsingToolbarLayout_expandedTitleTextColor")));
    L24:
        if (r14.hasValue(ZeusTransformUtils.mapRes(R.styleable.CollapsingToolbarLayout_collapsedTitleTextColor, "styleable", "CollapsingToolbarLayout_collapsedTitleTextColor")) == false) goto L26;
        r8.a(c.a(r1, r14, ZeusTransformUtils.mapRes(R.styleable.CollapsingToolbarLayout_collapsedTitleTextColor, "styleable", "CollapsingToolbarLayout_collapsedTitleTextColor")));
    L26:
        this.x = r14.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.CollapsingToolbarLayout_scrimVisibleHeightTrigger, "styleable", "CollapsingToolbarLayout_scrimVisibleHeightTrigger"), -1);
        if (r14.hasValue(ZeusTransformUtils.mapRes(R.styleable.CollapsingToolbarLayout_maxLines, "styleable", "CollapsingToolbarLayout_maxLines")) == false) goto L30;
        r8.f(r14.getInt(ZeusTransformUtils.mapRes(R.styleable.CollapsingToolbarLayout_maxLines, "styleable", "CollapsingToolbarLayout_maxLines"), 1));
    L30:
        if (r14.hasValue(ZeusTransformUtils.mapRes(R.styleable.CollapsingToolbarLayout_titlePositionInterpolator, "styleable", "CollapsingToolbarLayout_titlePositionInterpolator")) == false) goto L32;
        r8.b(AnimationUtils.loadInterpolator(r1, r14.getResourceId(ZeusTransformUtils.mapRes(R.styleable.CollapsingToolbarLayout_titlePositionInterpolator, "styleable", "CollapsingToolbarLayout_titlePositionInterpolator"), 0)));
    L32:
        this.w = r14.getInt(ZeusTransformUtils.mapRes(R.styleable.CollapsingToolbarLayout_scrimAnimationDuration, "styleable", "CollapsingToolbarLayout_scrimAnimationDuration"), 600);
        setContentScrim(r14.getDrawable(ZeusTransformUtils.mapRes(R.styleable.CollapsingToolbarLayout_contentScrim, "styleable", "CollapsingToolbarLayout_contentScrim")));
        setStatusBarScrim(r14.getDrawable(ZeusTransformUtils.mapRes(R.styleable.CollapsingToolbarLayout_statusBarScrim, "styleable", "CollapsingToolbarLayout_statusBarScrim")));
        setTitleCollapseMode(r14.getInt(ZeusTransformUtils.mapRes(R.styleable.CollapsingToolbarLayout_titleCollapseMode, "styleable", "CollapsingToolbarLayout_titleCollapseMode"), 0));
        this.h = r14.getResourceId(ZeusTransformUtils.mapRes(R.styleable.CollapsingToolbarLayout_toolbarId, "styleable", "CollapsingToolbarLayout_toolbarId"), -1);
        this.B = r14.getBoolean(ZeusTransformUtils.mapRes(R.styleable.CollapsingToolbarLayout_forceApplySystemWindowInsetTop, "styleable", "CollapsingToolbarLayout_forceApplySystemWindowInsetTop"), false);
        this.D = r14.getBoolean(ZeusTransformUtils.mapRes(R.styleable.CollapsingToolbarLayout_extraMultilineHeightEnabled, "styleable", "CollapsingToolbarLayout_extraMultilineHeightEnabled"), false);
        r14.recycle();
        setWillNotDraw(false);
        ViewCompat.setOnApplyWindowInsetsListener(this, new AnonymousClass1(this));
    }

    static com.google.android.material.appbar.a a(View r5) {
        com.google.android.material.appbar.a r0 = (com.google.android.material.appbar.a) ZeusTransformUtils.preCheckCast(r5.getTag(ZeusTransformUtils.mapRes(R.id.view_offset_helper, OaidModel.KEY_ID, "view_offset_helper")), com.google.android.material.appbar.a.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L6;
        com.google.android.material.appbar.a r1 = new com.google.android.material.appbar.a(r5);
        r5.setTag(ZeusTransformUtils.mapRes(R.id.view_offset_helper, OaidModel.KEY_ID, "view_offset_helper"), r1);
        return r1;
    L6:
        return r0;
    }

    private void a(int r5) {
        d();
        ValueAnimator r0 = this.v;
        if (r0 != null) goto L10;
        ValueAnimator r1 = new ValueAnimator();
        this.v = r1;
        if (r5 <= this.t) goto L7;
        TimeInterpolator r2 = com.google.android.material.a.a.c;
    L8:
        r1.setInterpolator(r2);
        this.v.addUpdateListener(new AnonymousClass2(this));
    L12:
        this.v.setDuration(this.w);
        this.v.setIntValues(new int[]{this.t, r5});
        this.v.start();
        return;
    L7:
        r2 = com.google.android.material.a.a.d;
        goto L8
    L10:
        if (r0.isRunning() == false) goto L12;
        this.v.cancel();
        goto L12
    }

    private void a(int r6, int r7, int r8, int r9, boolean r10) {
        if (this.q == false) goto L28;
        View r0 = this.k;
        if (r0 == null) goto L29;
        boolean r1 = false;
        if (ViewCompat.isAttachedToWindow(r0) == true) goto L9;
    L11:
        boolean r2 = false;
    L12:
        this.r = r2;
        if (r2 == true) goto L16;
        if (r10 == true) goto L16;
        return;
    L16:
        if (ViewCompat.getLayoutDirection(this) != 1) goto L18;
        r1 = true;
    L18:
        a(r1);
        com.google.android.material.internal.b r3 = this.f3764a;
        if (r1 == false) goto L21;
        int r4 = this.n;
    L22:
        int r5 = this.p.top + this.m;
        int r11 = r8 - r6;
        if (r1 == false) goto L25;
        int r12 = this.l;
    L26:
        r3.a(r4, r5, r11 - r12, (r9 - r7) - this.o);
        this.f3764a.c(r10);
        return;
    L25:
        r12 = this.n;
        goto L26
    L21:
        r4 = this.l;
        goto L22
    L9:
        if (this.k.getVisibility() != 0) goto L11;
        r2 = true;
        goto L12
    L29:
        return;
    }

    private void a(Drawable r2, int r3, int r4) {
        a(r2, this.i, r3, r4);
    }

    private void a(Drawable r2, View r3, int r4, int r5) {
        if (c() == false) goto L8;
        if (r3 == null) goto L8;
        if (this.q == false) goto L8;
        r5 = r3.getBottom();
    L8:
        r2.setBounds(0, 0, r4, r5);
    }

    private void a(AppBarLayout r1) {
        if (c() == false) goto L6;
        r1.setLiftOnScroll(false);
        return;
    }

    private void a(boolean r9) {
        View r0 = this.j;
        if (r0 != null) goto L6;
        r0 = this.i;
    L6:
        int r1 = b(r0);
        d.b(this, this.k, this.p);
        int r3 = 0;
        if (ZeusTransformUtils.instanceOf(this.i, Toolbar.class) == false) goto L10;
        Toolbar r2 = (Toolbar) ZeusTransformUtils.preCheckCast(this.i, Toolbar.class, "com.obric.memorydata.plugin");
        r3 = r2.getTitleMarginStart();
        int r4 = r2.getTitleMarginEnd();
        int r5 = r2.getTitleMarginTop();
        int r6 = r2.getTitleMarginBottom();
    L15:
        com.google.android.material.internal.b r7 = this.f3764a;
        int r8 = this.p.left;
        if (r9 == false) goto L18;
        int r10 = r4;
    L19:
        int r11 = r8 + r10;
        int r12 = (this.p.top + r1) + r5;
        int r13 = this.p.right;
        if (r9 == true) goto L23;
        r3 = r4;
    L23:
        r7.b(r11, r12, r13 - r3, (this.p.bottom + r1) - r6);
        return;
    L18:
        r10 = r3;
        goto L19
    L10:
        if (Build.VERSION.SDK_INT >= 24) goto L12;
    L14:
        r6 = 0;
        r4 = 0;
        r5 = 0;
        goto L15
    L12:
        if (ZeusTransformUtils.instanceOf(this.i, android.widget.Toolbar.class) == false) goto L14;
        android.widget.Toolbar r14 = (android.widget.Toolbar) ZeusTransformUtils.preCheckCast(this.i, android.widget.Toolbar.class, "com.obric.memorydata.plugin");
        r3 = r14.getTitleMarginStart();
        r4 = r14.getTitleMarginEnd();
        r5 = r14.getTitleMarginTop();
        r6 = r14.getTitleMarginBottom();
        goto L15
    }

    private boolean c() {
        if (this.z == 1) goto L7;
        return false;
    L7:
        return true;
    }

    private static boolean c(View r2) {
        if (ZeusTransformUtils.instanceOf(r2, Toolbar.class) == false) goto L5;
    L10:
        return true;
    L5:
        if (Build.VERSION.SDK_INT >= 21) goto L7;
    L9:
        return false;
    L7:
        if (ZeusTransformUtils.instanceOf(r2, android.widget.Toolbar.class) == false) goto L9;
        goto L9
    }

    private void d() {
        if (this.g == true) goto L5;
        return;
    L5:
        ViewGroup r0 = null;
        this.i = null;
        this.j = null;
        int r1 = this.h;
        if (r1 == (-1)) goto L11;
        ViewGroup r2 = (ViewGroup) ZeusTransformUtils.preCheckCast(findViewById(r1), ViewGroup.class, "com.obric.memorydata.plugin");
        this.i = r2;
        if (r2 == null) goto L11;
        this.j = e(r2);
    L11:
        if (this.i != null) goto L19;
        int r3 = getChildCount();
        int r4 = 0;
    L13:
        if (r4 >= r3) goto L18;
        View r5 = getChildAt(r4);
        if (c(r5) == true) goto L16;
        r4 = r4 + 1;
        goto L13
    L16:
        r0 = (ViewGroup) ZeusTransformUtils.preCheckCast(r5, ViewGroup.class, "com.obric.memorydata.plugin");
    L18:
        this.i = r0;
    L19:
        e();
        this.g = false;
    }

    private boolean d(View r4) {
        View r0 = this.j;
        if (r0 == null) goto L9;
        if (r0 == this) goto L9;
        if (r4 != r0) goto L12;
        return true;
    L12:
        return false;
    L9:
        if (r4 != this.i) goto L12;
        return true;
    }

    private View e(View r3) {
        ViewParent r0 = r3.getParent();
    L3:
        if (r0 == this) goto L9;
        if (r0 == null) goto L9;
        if (ZeusTransformUtils.instanceOf(r0, View.class) == false) goto L8;
        r3 = (View) ZeusTransformUtils.preCheckCast(r0, View.class, "com.obric.memorydata.plugin");
    L8:
        r0 = r0.getParent();
    L9:
        return r3;
    }

    private void e() {
        if (this.q == true) goto L10;
        View r0 = this.k;
        if (r0 == null) goto L10;
        ViewParent r1 = r0.getParent();
        if (ZeusTransformUtils.instanceOf(r1, ViewGroup.class) == false) goto L10;
        ((ViewGroup) ZeusTransformUtils.preCheckCast(r1, ViewGroup.class, "com.obric.memorydata.plugin")).removeView(this.k);
    L10:
        if (this.q == true) goto L12;
        return;
    L12:
        if (this.i != null) goto L14;
        return;
    L14:
        if (this.k != null) goto L17;
        this.k = new View((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
    L17:
        if (this.k.getParent() != null) goto L22;
        this.i.addView(this.k, -1, -1);
        return;
    }

    private static CharSequence f(View r3) {
        if (ZeusTransformUtils.instanceOf(r3, Toolbar.class) == false) goto L7;
        return ((Toolbar) ZeusTransformUtils.preCheckCast(r3, Toolbar.class, "com.obric.memorydata.plugin")).getTitle();
    L7:
        if (Build.VERSION.SDK_INT >= 21) goto L9;
        return null;
    L9:
        if (ZeusTransformUtils.instanceOf(r3, android.widget.Toolbar.class) == true) goto L11;
        return null;
    L11:
        return ((android.widget.Toolbar) ZeusTransformUtils.preCheckCast(r3, android.widget.Toolbar.class, "com.obric.memorydata.plugin")).getTitle();
    }

    private void f() {
        if (this.i != null) goto L5;
        return;
    L5:
        if (this.q == true) goto L7;
        return;
    L7:
        if (TextUtils.isEmpty(this.f3764a.o()) == false) goto L12;
        setTitle(f(this.i));
        return;
    }

    private static int g(View r3) {
        ViewGroup.LayoutParams r0 = r3.getLayoutParams();
        if (ZeusTransformUtils.instanceOf(r0, ViewGroup.MarginLayoutParams.class) == false) goto L7;
        ViewGroup.MarginLayoutParams r1 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r0, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin");
        return (r3.getMeasuredHeight() + r1.topMargin) + r1.bottomMargin;
    L7:
        return r3.getMeasuredHeight();
    }

    private void g() {
        setContentDescription(getTitle());
    }

    public FrameLayout.LayoutParams a(ViewGroup.LayoutParams r1) {
        return new LayoutParams(r1);
    }

    WindowInsetsCompat a(WindowInsetsCompat r3) {
        if (ViewCompat.getFitsSystemWindows(this) == false) goto L5;
        WindowInsetsCompat r0 = r3;
    L7:
        if (ObjectsCompat.equals(this.e, r0) == true) goto L10;
        this.e = r0;
        requestLayout();
    L10:
        return r3.consumeSystemWindowInsets();
    L5:
        r0 = null;
        goto L7
    }

    public LayoutParams a() {
        return new LayoutParams(-1, -1);
    }

    public void a(boolean r3, boolean r4) {
        if (this.u == r3) goto L16;
        int r0 = 255;
        if (r4 == false) goto L10;
        if (r3 == true) goto L9;
        r0 = 0;
    L9:
        a(r0);
    L14:
        this.u = r3;
        return;
    L10:
        if (r3 == true) goto L13;
        r0 = 0;
    L13:
        setScrimAlpha(r0);
        goto L14
    }

    final int b(View r5) {
        com.google.android.material.appbar.a r0 = a(r5);
        LayoutParams r1 = (LayoutParams) ZeusTransformUtils.preCheckCast(r5.getLayoutParams(), LayoutParams.class, "com.obric.memorydata.plugin");
        return ((getHeight() - r0.e()) - r5.getHeight()) - r1.bottomMargin;
    }

    final void b() {
        if (this.s != null) goto L7;
        if (this.c != null) goto L7;
        return;
    L7:
        if ((getHeight() + this.d) >= getScrimVisibleHeightTrigger()) goto L9;
        boolean r0 = true;
    L10:
        setScrimsShown(r0);
        return;
    L9:
        r0 = false;
        goto L10
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams r1) {
        return ZeusTransformUtils.instanceOf(r1, LayoutParams.class);
    }

    @Override // android.view.View
    public void draw(Canvas r7) {
        super.draw(r7);
        d();
        if (this.i != null) goto L10;
        Drawable r0 = this.s;
        if (r0 == null) goto L10;
        if (this.t <= 0) goto L10;
        r0.mutate().setAlpha(this.t);
        this.s.draw(r7);
    L10:
        if (this.q == false) goto L26;
        if (this.r == false) goto L26;
        if (this.i != null) goto L16;
    L24:
        this.f3764a.a(r7);
        goto L26
    L16:
        if (this.s == null) goto L24;
        if (this.t <= 0) goto L24;
        if (c() == false) goto L24;
        if (this.f3764a.l() >= this.f3764a.k()) goto L24;
        int r1 = r7.save();
        r7.clipRect(this.s.getBounds(), Region.Op.DIFFERENCE);
        this.f3764a.a(r7);
        r7.restoreToCount(r1);
    L26:
        if (this.c != null) goto L28;
        return;
    L28:
        if (this.t <= 0) goto L37;
        WindowInsetsCompat r2 = this.e;
        if (r2 == null) goto L32;
        int r3 = r2.getSystemWindowInsetTop();
    L33:
        if (r3 <= 0) goto L38;
        this.c.setBounds(0, -this.d, getWidth(), r3 - this.d);
        this.c.mutate().setAlpha(this.t);
        this.c.draw(r7);
        return;
    L38:
        return;
    L32:
        r3 = 0;
        goto L33
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas r6, View r7, long r8) {
        if (this.s != null) goto L5;
    L9:
        boolean r0 = false;
    L11:
        if (super.drawChild(r6, r7, r8) == true) goto L16;
        if (r0 == false) goto L15;
        return true;
    L15:
        return false;
    L16:
        return true;
    L5:
        if (this.t <= 0) goto L9;
        if (d(r7) == false) goto L9;
        a(this.s, r7, getWidth(), getHeight());
        this.s.mutate().setAlpha(this.t);
        this.s.draw(r6);
        r0 = true;
        goto L11
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        int[] r0 = getDrawableState();
        Drawable r1 = this.c;
        boolean r2 = false;
        if (r1 != null) goto L5;
    L7:
        Drawable r3 = this.s;
        if (r3 != null) goto L10;
    L12:
        com.google.android.material.internal.b r4 = this.f3764a;
        if (r4 == null) goto L15;
        r2 = r2 | r4.a(r0);
    L15:
        if (r2 == false) goto L18;
        invalidate();
        return;
    L18:
        return;
    L10:
        if (r3.isStateful() == false) goto L12;
        r2 = r2 | r3.setState(r0);
        goto L12
    L5:
        if (r1.isStateful() == false) goto L7;
        r2 = false | r1.setState(r0);
        goto L7
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return a();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public /* synthetic */ FrameLayout.LayoutParams generateDefaultLayoutParams() {
        return a();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet r3) {
        return generateLayoutParams((AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.memorydata.plugin"));
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r1) {
        return a(r1);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet r4) {
        AttributeSet r5 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin");
        return new LayoutParams((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r5);
    }

    public int getCollapsedTitleGravity() {
        return this.f3764a.g();
    }

    public Typeface getCollapsedTitleTypeface() {
        return this.f3764a.h();
    }

    public Drawable getContentScrim() {
        return this.s;
    }

    public int getExpandedTitleGravity() {
        return this.f3764a.f();
    }

    public int getExpandedTitleMarginBottom() {
        return this.o;
    }

    public int getExpandedTitleMarginEnd() {
        return this.n;
    }

    public int getExpandedTitleMarginStart() {
        return this.l;
    }

    public int getExpandedTitleMarginTop() {
        return this.m;
    }

    public Typeface getExpandedTitleTypeface() {
        return this.f3764a.i();
    }

    public int getHyphenationFrequency() {
        return this.f3764a.u();
    }

    public int getLineCount() {
        return this.f3764a.q();
    }

    public float getLineSpacingAdd() {
        return this.f3764a.s();
    }

    public float getLineSpacingMultiplier() {
        return this.f3764a.t();
    }

    public int getMaxLines() {
        return this.f3764a.p();
    }

    int getScrimAlpha() {
        return this.t;
    }

    public long getScrimAnimationDuration() {
        return this.w;
    }

    public int getScrimVisibleHeightTrigger() {
        int r0 = this.x;
        if (r0 >= 0) goto L5;
        WindowInsetsCompat r1 = this.e;
        if (r1 == null) goto L9;
        int r2 = r1.getSystemWindowInsetTop();
    L10:
        int r3 = ViewCompat.getMinimumHeight(this);
        if (r3 <= 0) goto L15;
        return Math.min((r3 * 2) + r2, getHeight());
    L15:
        return getHeight() / 3;
    L9:
        r2 = 0;
        goto L10
    L5:
        return (r0 + this.A) + this.C;
    }

    public Drawable getStatusBarScrim() {
        return this.c;
    }

    public CharSequence getTitle() {
        if (this.q == true) goto L7;
        return null;
    L7:
        return this.f3764a.o();
    }

    public int getTitleCollapseMode() {
        return this.z;
    }

    public TimeInterpolator getTitlePositionInterpolator() {
        return this.f3764a.a();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewParent r0 = getParent();
        if (ZeusTransformUtils.instanceOf(r0, AppBarLayout.class) == false) goto L9;
        AppBarLayout r1 = (AppBarLayout) ZeusTransformUtils.preCheckCast(r0, AppBarLayout.class, "com.obric.memorydata.plugin");
        a(r1);
        ViewCompat.setFitsSystemWindows(this, ViewCompat.getFitsSystemWindows(r1));
        if (this.y != null) goto L7;
        this.y = new a(this);
    L7:
        r1.addOnOffsetChangedListener(this.y);
        ViewCompat.requestApplyInsets(this);
        return;
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration r1) {
        super.onConfigurationChanged(r1);
        this.f3764a.a(r1);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        ViewParent r0 = getParent();
        if (this.y != null) goto L5;
    L7:
        super.onDetachedFromWindow();
        return;
    L5:
        if (ZeusTransformUtils.instanceOf(r0, AppBarLayout.class) == false) goto L7;
        ((AppBarLayout) ZeusTransformUtils.preCheckCast(r0, AppBarLayout.class, "com.obric.memorydata.plugin")).removeOnOffsetChangedListener(this.y);
        goto L7
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean r9, int r10, int r11, int r12, int r13) {
        super.onLayout(r9, r10, r11, r12, r13);
        WindowInsetsCompat r14 = this.e;
        int r0 = 0;
        if (r14 == null) goto L12;
        int r15 = r14.getSystemWindowInsetTop();
        int r1 = getChildCount();
        int r2 = 0;
    L5:
        if (r2 >= r1) goto L12;
        View r3 = getChildAt(r2);
        if (ViewCompat.getFitsSystemWindows(r3) == true) goto L11;
        if (r3.getTop() >= r15) goto L11;
        ViewCompat.offsetTopAndBottom(r3, r15);
    L11:
        r2 = r2 + 1;
    L12:
        int r16 = getChildCount();
        int r4 = 0;
    L13:
        if (r4 >= r16) goto L15;
        a(getChildAt(r4)).a();
        r4 = r4 + 1;
        goto L13
    L15:
        a(r10, r11, r12, r13, false);
        f();
        b();
        int r17 = getChildCount();
    L16:
        if (r0 >= r17) goto L18;
        a(getChildAt(r0)).b();
        r0 = r0 + 1;
        goto L16
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int r9, int r10) {
        d();
        super.onMeasure(r9, r10);
        int r11 = View.MeasureSpec.getMode(r10);
        WindowInsetsCompat r0 = this.e;
        if (r0 == null) goto L5;
        int r1 = r0.getSystemWindowInsetTop();
    L7:
        if (r11 != 0) goto L9;
    L10:
        if (r1 <= 0) goto L13;
        this.A = r1;
        super.onMeasure(r9, View.MeasureSpec.makeMeasureSpec(getMeasuredHeight() + r1, 1073741824));
    L13:
        if (this.D == true) goto L15;
    L19:
        ViewGroup r12 = this.i;
        if (r12 == null) goto L29;
        View r13 = this.j;
        if (r13 == null) goto L26;
        if (r13 == this) goto L26;
        int r14 = g(r13);
    L27:
        setMinimumHeight(r14);
        return;
    L26:
        r14 = g(r12);
        goto L27
    L29:
        return;
    L15:
        if (this.f3764a.p() <= 1) goto L19;
        f();
        a(0, 0, getMeasuredWidth(), getMeasuredHeight(), true);
        int r15 = this.f3764a.r();
        if (r15 <= 1) goto L19;
        this.C = Math.round(this.f3764a.c()) * (r15 - 1);
        super.onMeasure(r9, View.MeasureSpec.makeMeasureSpec(getMeasuredHeight() + this.C, 1073741824));
        goto L19
    L9:
        if (this.B == false) goto L13;
    L5:
        r1 = 0;
        goto L7
    }

    @Override // android.view.View
    public void onSizeChanged(int r1, int r2, int r3, int r4) {
        super.onSizeChanged(r1, r2, r3, r4);
        Drawable r5 = this.s;
        if (r5 == null) goto L6;
        a(r5, r1, r2);
        return;
    }

    public void setCollapsedTitleGravity(int r1) {
        this.f3764a.c(r1);
    }

    public void setCollapsedTitleTextAppearance(int r1) {
        this.f3764a.d(r1);
    }

    public void setCollapsedTitleTextColor(int r1) {
        setCollapsedTitleTextColor(ColorStateList.valueOf(r1));
    }

    public void setCollapsedTitleTextColor(ColorStateList r1) {
        this.f3764a.a(r1);
    }

    public void setCollapsedTitleTypeface(Typeface r1) {
        this.f3764a.a(r1);
    }

    public void setContentScrim(Drawable r3) {
        Drawable r0 = this.s;
        if (r0 == r3) goto L14;
        Drawable r1 = null;
        if (r0 == null) goto L7;
        r0.setCallback(null);
    L7:
        if (r3 == null) goto L9;
        r1 = r3.mutate();
    L9:
        this.s = r1;
        if (r1 == null) goto L12;
        a(r1, getWidth(), getHeight());
        this.s.setCallback(this);
        this.s.setAlpha(this.t);
    L12:
        ViewCompat.postInvalidateOnAnimation(this);
        return;
    }

    public void setContentScrimColor(int r2) {
        setContentScrim(new ColorDrawable(r2));
    }

    public void setContentScrimResource(int r4) {
        setContentScrim(ContextCompat.getDrawable((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r4));
    }

    public void setExpandedTitleColor(int r1) {
        setExpandedTitleTextColor(ColorStateList.valueOf(r1));
    }

    public void setExpandedTitleGravity(int r1) {
        this.f3764a.b(r1);
    }

    public void setExpandedTitleMarginBottom(int r1) {
        this.o = r1;
        requestLayout();
    }

    public void setExpandedTitleMarginEnd(int r1) {
        this.n = r1;
        requestLayout();
    }

    public void setExpandedTitleMarginStart(int r1) {
        this.l = r1;
        requestLayout();
    }

    public void setExpandedTitleMarginTop(int r1) {
        this.m = r1;
        requestLayout();
    }

    public void setExpandedTitleTextAppearance(int r1) {
        this.f3764a.e(r1);
    }

    public void setExpandedTitleTextColor(ColorStateList r1) {
        this.f3764a.b(r1);
    }

    public void setExpandedTitleTypeface(Typeface r1) {
        this.f3764a.b(r1);
    }

    public void setExtraMultilineHeightEnabled(boolean r1) {
        this.D = r1;
    }

    public void setForceApplySystemWindowInsetTop(boolean r1) {
        this.B = r1;
    }

    public void setHyphenationFrequency(int r1) {
        this.f3764a.g(r1);
    }

    public void setLineSpacingAdd(float r1) {
        this.f3764a.e(r1);
    }

    public void setLineSpacingMultiplier(float r1) {
        this.f3764a.f(r1);
    }

    public void setMaxLines(int r1) {
        this.f3764a.f(r1);
    }

    public void setRtlTextDirectionHeuristicsEnabled(boolean r1) {
        this.f3764a.b(r1);
    }

    void setScrimAlpha(int r2) {
        if (r2 != this.t) goto L5;
        return;
    L5:
        if (this.s == null) goto L9;
        ViewGroup r0 = this.i;
        if (r0 == null) goto L9;
        ViewCompat.postInvalidateOnAnimation(r0);
    L9:
        this.t = r2;
        ViewCompat.postInvalidateOnAnimation(this);
    }

    public void setScrimAnimationDuration(long r1) {
        this.w = r1;
    }

    public void setScrimVisibleHeightTrigger(int r2) {
        if (this.x == r2) goto L6;
        this.x = r2;
        b();
        return;
    }

    public void setScrimsShown(boolean r2) {
        if (ViewCompat.isLaidOut(this) == true) goto L5;
    L7:
        boolean r0 = false;
    L8:
        a(r2, r0);
        return;
    L5:
        if (isInEditMode() == true) goto L7;
        r0 = true;
        goto L8
    }

    public void setStatusBarScrim(Drawable r3) {
        Drawable r0 = this.c;
        if (r0 == r3) goto L21;
        Drawable r1 = null;
        if (r0 == null) goto L7;
        r0.setCallback(null);
    L7:
        if (r3 == null) goto L9;
        r1 = r3.mutate();
    L9:
        this.c = r1;
        if (r1 != null) goto L12;
    L19:
        ViewCompat.postInvalidateOnAnimation(this);
        return;
    L12:
        if (r1.isStateful() == false) goto L14;
        this.c.setState(getDrawableState());
    L14:
        DrawableCompat.setLayoutDirection(this.c, ViewCompat.getLayoutDirection(this));
        Drawable r4 = this.c;
        if (getVisibility() != 0) goto L17;
        boolean r2 = true;
    L18:
        r4.setVisible(r2, false);
        this.c.setCallback(this);
        this.c.setAlpha(this.t);
        goto L19
    L17:
        r2 = false;
        goto L18
    }

    public void setStatusBarScrimColor(int r2) {
        setStatusBarScrim(new ColorDrawable(r2));
    }

    public void setStatusBarScrimResource(int r4) {
        setStatusBarScrim(ContextCompat.getDrawable((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r4));
    }

    public void setTitle(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        this.f3764a.a(r4);
        g();
    }

    public void setTitleCollapseMode(int r4) {
        this.z = r4;
        boolean r5 = c();
        this.f3764a.a(r5);
        ViewParent r0 = getParent();
        if (ZeusTransformUtils.instanceOf(r0, AppBarLayout.class) == false) goto L5;
        a((AppBarLayout) ZeusTransformUtils.preCheckCast(r0, AppBarLayout.class, "com.obric.memorydata.plugin"));
    L5:
        if (r5 == true) goto L7;
        return;
    L7:
        if (this.s != null) goto L11;
        float r6 = ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getDimension(ZeusTransformUtils.mapRes(R.dimen.design_appbar_elevation, "dimen", "design_appbar_elevation"));
        setContentScrimColor(this.f3765b.a(r6));
        return;
    }

    public void setTitleEnabled(boolean r2) {
        if (r2 == this.q) goto L6;
        this.q = r2;
        g();
        e();
        requestLayout();
        return;
    }

    public void setTitlePositionInterpolator(TimeInterpolator r3) {
        TimeInterpolator r4 = (TimeInterpolator) ZeusTransformUtils.wrapperContextForParams(r3, TimeInterpolator.class, "com.obric.memorydata.plugin");
        this.f3764a.b(r4);
    }

    @Override // android.view.View
    public void setVisibility(int r3) {
        super.setVisibility(r3);
        if (r3 != 0) goto L5;
        boolean r4 = true;
    L6:
        Drawable r1 = this.c;
        if (r1 != null) goto L9;
    L11:
        Drawable r2 = this.s;
        if (r2 != null) goto L14;
        return;
    L14:
        if (r2.isVisible() == r4) goto L18;
        this.s.setVisible(r4, false);
        return;
    L18:
        return;
    L9:
        if (r1.isVisible() == r4) goto L11;
        this.c.setVisible(r4, false);
        goto L11
    L5:
        r4 = false;
        goto L6
    }

    @Override // android.view.View
    public boolean verifyDrawable(Drawable r2) {
        if (super.verifyDrawable(r2) == false) goto L5;
    L10:
        return true;
    L5:
        if (r2 == this.s) goto L10;
        if (r2 == this.c) goto L10;
        return false;
    }
}
