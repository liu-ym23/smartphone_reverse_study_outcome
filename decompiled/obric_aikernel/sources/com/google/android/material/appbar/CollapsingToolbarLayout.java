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
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.appcompat.R;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.math.MathUtils;
import androidx.core.util.ObjectsCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.internal.d;
import com.google.android.material.resources.c;
import q5.f;
import q5.k;
import q5.l;

/* JADX INFO: loaded from: classes.dex */
public class CollapsingToolbarLayout extends FrameLayout {
    private static final int I = 0;
    private AppBarLayout.f A;
    int B;
    private int C;

    @Nullable
    WindowInsetsCompat D;
    private int E;
    private boolean F;
    private int G;
    private boolean H;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f2956c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f2957g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Nullable
    private ViewGroup f2958h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    private View f2959i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private View f2960j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f2961k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f2962l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f2963m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f2964n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final Rect f2965o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @NonNull
    final com.google.android.material.internal.b f2966p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @NonNull
    final w5.a f2967q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private boolean f2968r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private boolean f2969s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    @Nullable
    private Drawable f2970t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    @Nullable
    Drawable f2971u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private int f2972v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private boolean f2973w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private ValueAnimator f2974x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private long f2975y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private int f2976z;

    public static class LayoutParams extends FrameLayout.LayoutParams {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f2977a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        float f2978b;

        public LayoutParams(int r10, int r11) {
            super(r10, r11);
            this.f2977a = 0;
            this.f2978b = 0.5f;
        }

        public LayoutParams(Context r10, AttributeSet r11) {
            super(r10, r11);
            this.f2977a = 0;
            this.f2978b = 0.5f;
            TypedArray r12 = r10.obtainStyledAttributes(r11, l.CollapsingToolbarLayout_Layout);
            this.f2977a = r12.getInt(l.CollapsingToolbarLayout_Layout_layout_collapseMode, 0);
            a(r12.getFloat(l.CollapsingToolbarLayout_Layout_layout_collapseParallaxMultiplier, 0.5f));
            r12.recycle();
        }

        public LayoutParams(@NonNull ViewGroup.LayoutParams r10) {
            super(r10);
            this.f2977a = 0;
            this.f2978b = 0.5f;
        }

        public void a(float r10) {
            this.f2978b = r10;
        }
    }

    class a implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ CollapsingToolbarLayout f2979c;

        a(CollapsingToolbarLayout r10) {
            this.f2979c = r10;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(@NonNull ValueAnimator r10) {
            this.f2979c.setScrimAlpha(((Integer) r10.getAnimatedValue()).intValue());
        }
    }

    private class b implements AppBarLayout.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ CollapsingToolbarLayout f2980a;

        b(CollapsingToolbarLayout r10) {
            this.f2980a = r10;
        }

        @Override // com.google.android.material.appbar.AppBarLayout.b
        public void a(AppBarLayout r10, int r11) {
            CollapsingToolbarLayout r12 = this.f2980a;
            r12.B = r11;
            WindowInsetsCompat r13 = r12.D;
            if (r13 == null) goto L5;
            int r14 = r13.getSystemWindowInsetTop();
        L6:
            int r15 = this.f2980a.getChildCount();
            int r16 = 0;
        L7:
            if (r16 >= r15) goto L17;
            View r17 = this.f2980a.getChildAt(r16);
            LayoutParams r18 = (LayoutParams) r17.getLayoutParams();
            com.google.android.material.appbar.a r19 = CollapsingToolbarLayout.j(r17);
            int r20 = r18.f2977a;
            if (r20 != 1) goto L11;
            int r21 = MathUtils.clamp(-r11, 0, this.f2980a.h(r17));
        L15:
            r19.j(r21);
        L16:
            r16 = r16 + 1;
            goto L7
        L11:
            if (r20 != 2) goto L16;
            r21 = Math.round((-r11) * r18.f2978b);
            goto L15
        L17:
            this.f2980a.u();
            CollapsingToolbarLayout r22 = this.f2980a;
            if (r22.f2971u == null) goto L21;
            if (r14 <= 0) goto L21;
            ViewCompat.postInvalidateOnAnimation(r22);
        L21:
            int r23 = this.f2980a.getHeight();
            int r24 = (r23 - ViewCompat.getMinimumHeight(this.f2980a)) - r14;
            float r25 = r24;
            this.f2980a.f2966p.w0(Math.min(1.0f, (r23 - this.f2980a.getScrimVisibleHeightTrigger()) / r25));
            CollapsingToolbarLayout r26 = this.f2980a;
            r26.f2966p.j0(r26.B + r24);
            this.f2980a.f2966p.u0(Math.abs(r11) / r25);
            return;
        L5:
            r14 = 0;
            goto L6
        }
    }

    static {
        I = k.Widget_Design_CollapsingToolbar;
    }

    public CollapsingToolbarLayout(@NonNull Context r10) {
        this(r10, null);
    }

    public CollapsingToolbarLayout(@NonNull Context r10, @Nullable AttributeSet r11) {
        this(r10, r11, q5.b.collapsingToolbarLayoutStyle);
    }

    public CollapsingToolbarLayout(@NonNull Context r11, @Nullable AttributeSet r12, int r13) {
        int r10 = I;
        super(b6.a.c(r11, r12, r13, r10), r12, r13);
        this.f2956c = true;
        this.f2965o = new Rect();
        this.f2976z = -1;
        this.E = 0;
        this.G = 0;
        Context r14 = getContext();
        com.google.android.material.internal.b r15 = new com.google.android.material.internal.b(this);
        this.f2966p = r15;
        r15.G0(r5.a.f12677e);
        r15.D0(false);
        this.f2967q = new w5.a(r14);
        TypedArray r16 = com.google.android.material.internal.k.h(r14, r12, l.CollapsingToolbarLayout, r13, r10, new int[0]);
        r15.q0(r16.getInt(l.CollapsingToolbarLayout_expandedTitleGravity, MaterialCardView.CHECKED_ICON_GRAVITY_BOTTOM_START));
        r15.g0(r16.getInt(l.CollapsingToolbarLayout_collapsedTitleGravity, 8388627));
        int r17 = r16.getDimensionPixelSize(l.CollapsingToolbarLayout_expandedTitleMargin, 0);
        this.f2964n = r17;
        this.f2963m = r17;
        this.f2962l = r17;
        this.f2961k = r17;
        int r18 = l.CollapsingToolbarLayout_expandedTitleMarginStart;
        if (r16.hasValue(r18) == false) goto L5;
        this.f2961k = r16.getDimensionPixelSize(r18, 0);
    L5:
        int r19 = l.CollapsingToolbarLayout_expandedTitleMarginEnd;
        if (r16.hasValue(r19) == false) goto L8;
        this.f2963m = r16.getDimensionPixelSize(r19, 0);
    L8:
        int r110 = l.CollapsingToolbarLayout_expandedTitleMarginTop;
        if (r16.hasValue(r110) == false) goto L11;
        this.f2962l = r16.getDimensionPixelSize(r110, 0);
    L11:
        int r111 = l.CollapsingToolbarLayout_expandedTitleMarginBottom;
        if (r16.hasValue(r111) == false) goto L14;
        this.f2964n = r16.getDimensionPixelSize(r111, 0);
    L14:
        this.f2968r = r16.getBoolean(l.CollapsingToolbarLayout_titleEnabled, true);
        setTitle(r16.getText(l.CollapsingToolbarLayout_title));
        r15.n0(k.TextAppearance_Design_CollapsingToolbar_Expanded);
        r15.d0(R.style.TextAppearance_AppCompat_Widget_ActionBar_Title);
        int r112 = l.CollapsingToolbarLayout_expandedTitleTextAppearance;
        if (r16.hasValue(r112) == false) goto L17;
        r15.n0(r16.getResourceId(r112, 0));
    L17:
        int r113 = l.CollapsingToolbarLayout_collapsedTitleTextAppearance;
        if (r16.hasValue(r113) == false) goto L20;
        r15.d0(r16.getResourceId(r113, 0));
    L20:
        int r114 = l.CollapsingToolbarLayout_expandedTitleTextColor;
        if (r16.hasValue(r114) == false) goto L23;
        r15.p0(c.a(r14, r16, r114));
    L23:
        int r115 = l.CollapsingToolbarLayout_collapsedTitleTextColor;
        if (r16.hasValue(r115) == false) goto L26;
        r15.f0(c.a(r14, r16, r115));
    L26:
        this.f2976z = r16.getDimensionPixelSize(l.CollapsingToolbarLayout_scrimVisibleHeightTrigger, -1);
        int r116 = l.CollapsingToolbarLayout_maxLines;
        if (r16.hasValue(r116) == false) goto L29;
        r15.B0(r16.getInt(r116, 1));
    L29:
        int r117 = l.CollapsingToolbarLayout_titlePositionInterpolator;
        if (r16.hasValue(r117) == false) goto L32;
        r15.C0(AnimationUtils.loadInterpolator(r14, r16.getResourceId(r117, 0)));
    L32:
        this.f2975y = r16.getInt(l.CollapsingToolbarLayout_scrimAnimationDuration, 600);
        setContentScrim(r16.getDrawable(l.CollapsingToolbarLayout_contentScrim));
        setStatusBarScrim(r16.getDrawable(l.CollapsingToolbarLayout_statusBarScrim));
        setTitleCollapseMode(r16.getInt(l.CollapsingToolbarLayout_titleCollapseMode, 0));
        this.f2957g = r16.getResourceId(l.CollapsingToolbarLayout_toolbarId, -1);
        this.F = r16.getBoolean(l.CollapsingToolbarLayout_forceApplySystemWindowInsetTop, false);
        this.H = r16.getBoolean(l.CollapsingToolbarLayout_extraMultilineHeightEnabled, false);
        r16.recycle();
        setWillNotDraw(false);
        ViewCompat.setOnApplyWindowInsetsListener(this, new AnonymousClass1(this));
    }

    private void a(int r10) {
        c();
        ValueAnimator r11 = this.f2974x;
        if (r11 != null) goto L10;
        ValueAnimator r12 = new ValueAnimator();
        this.f2974x = r12;
        if (r10 <= this.f2972v) goto L7;
        TimeInterpolator r13 = r5.a.f12675c;
    L8:
        r12.setInterpolator(r13);
        this.f2974x.addUpdateListener(new a(this));
    L12:
        this.f2974x.setDuration(this.f2975y);
        this.f2974x.setIntValues(new int[]{this.f2972v, r10});
        this.f2974x.start();
        return;
    L7:
        r13 = r5.a.f12676d;
        goto L8
    L10:
        if (r11.isRunning() == false) goto L12;
        this.f2974x.cancel();
        goto L12
    }

    private void b(AppBarLayout r10) {
        if (k() == false) goto L6;
        r10.setLiftOnScroll(false);
        return;
    }

    private void c() {
        if (this.f2956c == true) goto L5;
        return;
    L5:
        ViewGroup r10 = null;
        this.f2958h = null;
        this.f2959i = null;
        int r11 = this.f2957g;
        if (r11 == (-1)) goto L11;
        ViewGroup r12 = (ViewGroup) findViewById(r11);
        this.f2958h = r12;
        if (r12 == null) goto L11;
        this.f2959i = d(r12);
    L11:
        if (this.f2958h != null) goto L19;
        int r13 = getChildCount();
        int r14 = 0;
    L13:
        if (r14 >= r13) goto L18;
        View r15 = getChildAt(r14);
        if (l(r15) == true) goto L16;
        r14 = r14 + 1;
        goto L13
    L16:
        r10 = (ViewGroup) r15;
    L18:
        this.f2958h = r10;
    L19:
        t();
        this.f2956c = false;
    }

    @NonNull
    private View d(@NonNull View r10) {
        ViewParent r11 = r10.getParent();
    L3:
        if (r11 == this) goto L9;
        if (r11 == null) goto L9;
        if ((r11 instanceof View) == false) goto L8;
        r10 = r11;
    L8:
        r11 = r11.getParent();
    L9:
        return r10;
    }

    private static int g(@NonNull View r10) {
        ViewGroup.LayoutParams r11 = r10.getLayoutParams();
        if ((r11 instanceof ViewGroup.MarginLayoutParams) == false) goto L7;
        ViewGroup.MarginLayoutParams r12 = (ViewGroup.MarginLayoutParams) r11;
        return (r10.getMeasuredHeight() + r12.topMargin) + r12.bottomMargin;
    L7:
        return r10.getMeasuredHeight();
    }

    private static CharSequence i(View r10) {
        if ((r10 instanceof Toolbar) == false) goto L7;
        return ((Toolbar) r10).getTitle();
    L7:
        if (Build.VERSION.SDK_INT >= 21) goto L9;
        return null;
    L9:
        if ((r10 instanceof android.widget.Toolbar) == true) goto L11;
        return null;
    L11:
        return ((android.widget.Toolbar) r10).getTitle();
    }

    @NonNull
    static com.google.android.material.appbar.a j(@NonNull View r10) {
        int r11 = f.view_offset_helper;
        com.google.android.material.appbar.a r12 = (com.google.android.material.appbar.a) r10.getTag(r11);
        if (r12 != null) goto L6;
        com.google.android.material.appbar.a r13 = new com.google.android.material.appbar.a(r10);
        r10.setTag(r11, r13);
        return r13;
    L6:
        return r12;
    }

    private boolean k() {
        if (this.C == 1) goto L7;
        return false;
    L7:
        return true;
    }

    private static boolean l(View r10) {
        if ((r10 instanceof Toolbar) == false) goto L5;
    L10:
        return true;
    L5:
        if (Build.VERSION.SDK_INT >= 21) goto L7;
    L9:
        return false;
    L7:
        if ((r10 instanceof android.widget.Toolbar) == false) goto L9;
        goto L9
    }

    private boolean m(View r10) {
        View r11 = this.f2959i;
        if (r11 == null) goto L9;
        if (r11 == this) goto L9;
        if (r10 != r11) goto L12;
        return true;
    L12:
        return false;
    L9:
        if (r10 != this.f2958h) goto L12;
        return true;
    }

    private void p(boolean r10) {
        View r11 = this.f2959i;
        if (r11 != null) goto L6;
        r11 = this.f2958h;
    L6:
        int r12 = h(r11);
        d.a(this, this.f2960j, this.f2965o);
        ViewGroup r13 = this.f2958h;
        int r14 = 0;
        if ((r13 instanceof Toolbar) == false) goto L10;
        Toolbar r15 = (Toolbar) r13;
        r14 = r15.getTitleMarginStart();
        int r16 = r15.getTitleMarginEnd();
        int r17 = r15.getTitleMarginTop();
        int r18 = r15.getTitleMarginBottom();
    L15:
        com.google.android.material.internal.b r19 = this.f2966p;
        Rect r20 = this.f2965o;
        int r21 = r20.left;
        if (r10 == false) goto L18;
        int r22 = r16;
    L19:
        int r23 = r21 + r22;
        int r24 = (r20.top + r12) + r17;
        int r25 = r20.right;
        if (r10 == true) goto L23;
        r14 = r16;
    L23:
        r19.b0(r23, r24, r25 - r14, (r20.bottom + r12) - r18);
        return;
    L18:
        r22 = r14;
        goto L19
    L10:
        if (Build.VERSION.SDK_INT >= 24) goto L12;
    L14:
        r18 = 0;
        r16 = 0;
        r17 = 0;
        goto L15
    L12:
        if ((r13 instanceof android.widget.Toolbar) == false) goto L14;
        android.widget.Toolbar r26 = (android.widget.Toolbar) r13;
        r14 = r26.getTitleMarginStart();
        r16 = r26.getTitleMarginEnd();
        r17 = r26.getTitleMarginTop();
        r18 = r26.getTitleMarginBottom();
        goto L15
    }

    private void q() {
        setContentDescription(getTitle());
    }

    private void r(@NonNull Drawable r10, int r11, int r12) {
        s(r10, this.f2958h, r11, r12);
    }

    private void s(@NonNull Drawable r10, @Nullable View r11, int r12, int r13) {
        if (k() == false) goto L8;
        if (r11 == null) goto L8;
        if (this.f2968r == false) goto L8;
        r13 = r11.getBottom();
    L8:
        r10.setBounds(0, 0, r12, r13);
    }

    private void t() {
        if (this.f2968r == true) goto L10;
        View r10 = this.f2960j;
        if (r10 == null) goto L10;
        ViewParent r11 = r10.getParent();
        if ((r11 instanceof ViewGroup) == false) goto L10;
        ((ViewGroup) r11).removeView(this.f2960j);
    L10:
        if (this.f2968r == true) goto L12;
        return;
    L12:
        if (this.f2958h != null) goto L14;
        return;
    L14:
        if (this.f2960j != null) goto L17;
        this.f2960j = new View(getContext());
    L17:
        if (this.f2960j.getParent() != null) goto L22;
        this.f2958h.addView(this.f2960j, -1, -1);
        return;
    }

    private void v(int r10, int r11, int r12, int r13, boolean r14) {
        if (this.f2968r == false) goto L28;
        View r15 = this.f2960j;
        if (r15 == null) goto L29;
        boolean r16 = false;
        if (ViewCompat.isAttachedToWindow(r15) == true) goto L9;
    L11:
        boolean r17 = false;
    L12:
        this.f2969s = r17;
        if (r17 == true) goto L16;
        if (r14 == true) goto L16;
        return;
    L16:
        if (ViewCompat.getLayoutDirection(this) != 1) goto L18;
        r16 = true;
    L18:
        p(r16);
        com.google.android.material.internal.b r18 = this.f2966p;
        if (r16 == false) goto L21;
        int r19 = this.f2963m;
    L22:
        int r20 = this.f2965o.top + this.f2962l;
        int r21 = r12 - r10;
        if (r16 == false) goto L25;
        int r22 = this.f2961k;
    L26:
        r18.k0(r19, r20, r21 - r22, (r13 - r11) - this.f2964n);
        this.f2966p.Z(r14);
        return;
    L25:
        r22 = this.f2963m;
        goto L26
    L21:
        r19 = this.f2961k;
        goto L22
    L9:
        if (this.f2960j.getVisibility() != 0) goto L11;
        r17 = true;
        goto L12
    L29:
        return;
    }

    private void w() {
        if (this.f2958h != null) goto L5;
        return;
    L5:
        if (this.f2968r == true) goto L7;
        return;
    L7:
        if (TextUtils.isEmpty(this.f2966p.M()) == false) goto L12;
        setTitle(i(this.f2958h));
        return;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams r10) {
        return r10 instanceof LayoutParams;
    }

    @Override // android.view.View
    public void draw(@NonNull Canvas r10) {
        super.draw(r10);
        c();
        if (this.f2958h != null) goto L10;
        Drawable r11 = this.f2970t;
        if (r11 == null) goto L10;
        if (this.f2972v <= 0) goto L10;
        r11.mutate().setAlpha(this.f2972v);
        this.f2970t.draw(r10);
    L10:
        if (this.f2968r == false) goto L26;
        if (this.f2969s == false) goto L26;
        if (this.f2958h != null) goto L16;
    L24:
        this.f2966p.l(r10);
        goto L26
    L16:
        if (this.f2970t == null) goto L24;
        if (this.f2972v <= 0) goto L24;
        if (k() == false) goto L24;
        if (this.f2966p.D() >= this.f2966p.E()) goto L24;
        int r12 = r10.save();
        r10.clipRect(this.f2970t.getBounds(), Region.Op.DIFFERENCE);
        this.f2966p.l(r10);
        r10.restoreToCount(r12);
    L26:
        if (this.f2971u != null) goto L28;
        return;
    L28:
        if (this.f2972v <= 0) goto L37;
        WindowInsetsCompat r13 = this.D;
        if (r13 == null) goto L32;
        int r14 = r13.getSystemWindowInsetTop();
    L33:
        if (r14 <= 0) goto L38;
        this.f2971u.setBounds(0, -this.B, getWidth(), r14 - this.B);
        this.f2971u.mutate().setAlpha(this.f2972v);
        this.f2971u.draw(r10);
        return;
    L38:
        return;
    L32:
        r14 = 0;
        goto L33
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas r10, View r11, long r12) {
        if (this.f2970t != null) goto L5;
    L9:
        boolean r13 = false;
    L11:
        if (super.drawChild(r10, r11, r12) == true) goto L16;
        if (r13 == false) goto L15;
        return true;
    L15:
        return false;
    L16:
        return true;
    L5:
        if (this.f2972v <= 0) goto L9;
        if (m(r11) == false) goto L9;
        s(this.f2970t, r11, getWidth(), getHeight());
        this.f2970t.mutate().setAlpha(this.f2972v);
        this.f2970t.draw(r10);
        r13 = true;
        goto L11
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        int[] r10 = getDrawableState();
        Drawable r11 = this.f2971u;
        boolean r12 = false;
        if (r11 != null) goto L5;
    L7:
        Drawable r13 = this.f2970t;
        if (r13 != null) goto L10;
    L12:
        com.google.android.material.internal.b r14 = this.f2966p;
        if (r14 == null) goto L15;
        r12 = r12 | r14.E0(r10);
    L15:
        if (r12 == false) goto L18;
        invalidate();
        return;
    L18:
        return;
    L10:
        if (r13.isStateful() == false) goto L12;
        r12 = r12 | r13.setState(r10);
        goto L12
    L5:
        if (r11.isStateful() == false) goto L7;
        r12 = false | r11.setState(r10);
        goto L7
    }

    protected LayoutParams e() {
        return new LayoutParams(-1, -1);
    }

    protected FrameLayout.LayoutParams f(ViewGroup.LayoutParams r10) {
        return new LayoutParams(r10);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    protected /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return e();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    protected /* bridge */ /* synthetic */ FrameLayout.LayoutParams generateDefaultLayoutParams() {
        return e();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet r10) {
        return generateLayoutParams(r10);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    protected /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r10) {
        return f(r10);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet r10) {
        return new LayoutParams(getContext(), r10);
    }

    public int getCollapsedTitleGravity() {
        return this.f2966p.q();
    }

    @NonNull
    public Typeface getCollapsedTitleTypeface() {
        return this.f2966p.u();
    }

    @Nullable
    public Drawable getContentScrim() {
        return this.f2970t;
    }

    public int getExpandedTitleGravity() {
        return this.f2966p.A();
    }

    public int getExpandedTitleMarginBottom() {
        return this.f2964n;
    }

    public int getExpandedTitleMarginEnd() {
        return this.f2963m;
    }

    public int getExpandedTitleMarginStart() {
        return this.f2961k;
    }

    public int getExpandedTitleMarginTop() {
        return this.f2962l;
    }

    @NonNull
    public Typeface getExpandedTitleTypeface() {
        return this.f2966p.C();
    }

    @RequiresApi(23)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int getHyphenationFrequency() {
        return this.f2966p.F();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int getLineCount() {
        return this.f2966p.G();
    }

    @RequiresApi(23)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public float getLineSpacingAdd() {
        return this.f2966p.H();
    }

    @RequiresApi(23)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public float getLineSpacingMultiplier() {
        return this.f2966p.I();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int getMaxLines() {
        return this.f2966p.J();
    }

    int getScrimAlpha() {
        return this.f2972v;
    }

    public long getScrimAnimationDuration() {
        return this.f2975y;
    }

    public int getScrimVisibleHeightTrigger() {
        int r10 = this.f2976z;
        if (r10 >= 0) goto L5;
        WindowInsetsCompat r11 = this.D;
        if (r11 == null) goto L9;
        int r12 = r11.getSystemWindowInsetTop();
    L10:
        int r13 = ViewCompat.getMinimumHeight(this);
        if (r13 <= 0) goto L15;
        return Math.min((r13 * 2) + r12, getHeight());
    L15:
        return getHeight() / 3;
    L9:
        r12 = 0;
        goto L10
    L5:
        return (r10 + this.E) + this.G;
    }

    @Nullable
    public Drawable getStatusBarScrim() {
        return this.f2971u;
    }

    @Nullable
    public CharSequence getTitle() {
        if (this.f2968r == true) goto L7;
        return null;
    L7:
        return this.f2966p.M();
    }

    public int getTitleCollapseMode() {
        return this.C;
    }

    @Nullable
    public TimeInterpolator getTitlePositionInterpolator() {
        return this.f2966p.L();
    }

    final int h(@NonNull View r10) {
        com.google.android.material.appbar.a r11 = j(r10);
        LayoutParams r12 = (LayoutParams) r10.getLayoutParams();
        return ((getHeight() - r11.b()) - r10.getHeight()) - ((FrameLayout.LayoutParams) r12).bottomMargin;
    }

    WindowInsetsCompat n(@NonNull WindowInsetsCompat r10) {
        if (ViewCompat.getFitsSystemWindows(this) == false) goto L5;
        WindowInsetsCompat r11 = r10;
    L7:
        if (ObjectsCompat.equals(this.D, r11) == true) goto L10;
        this.D = r11;
        requestLayout();
    L10:
        return r10.consumeSystemWindowInsets();
    L5:
        r11 = null;
        goto L7
    }

    public void o(boolean r10, boolean r11) {
        if (this.f2973w == r10) goto L16;
        int r12 = 255;
        if (r11 == false) goto L10;
        if (r10 == true) goto L9;
        r12 = 0;
    L9:
        a(r12);
    L14:
        this.f2973w = r10;
        return;
    L10:
        if (r10 == true) goto L13;
        r12 = 0;
    L13:
        setScrimAlpha(r12);
        goto L14
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewParent r10 = getParent();
        if ((r10 instanceof AppBarLayout) == false) goto L9;
        AppBarLayout r11 = (AppBarLayout) r10;
        b(r11);
        ViewCompat.setFitsSystemWindows(this, ViewCompat.getFitsSystemWindows(r11));
        if (this.A != null) goto L7;
        this.A = new b(this);
    L7:
        r11.addOnOffsetChangedListener(this.A);
        ViewCompat.requestApplyInsets(this);
        return;
    }

    @Override // android.view.View
    protected void onConfigurationChanged(@NonNull Configuration r10) {
        super.onConfigurationChanged(r10);
        this.f2966p.V(r10);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        ViewParent r10 = getParent();
        AppBarLayout.f r11 = this.A;
        if (r11 != null) goto L5;
    L7:
        super.onDetachedFromWindow();
        return;
    L5:
        if ((r10 instanceof AppBarLayout) == false) goto L7;
        ((AppBarLayout) r10).removeOnOffsetChangedListener(r11);
        goto L7
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
        super.onLayout(r10, r11, r12, r13, r14);
        WindowInsetsCompat r15 = this.D;
        int r16 = 0;
        if (r15 == null) goto L12;
        int r17 = r15.getSystemWindowInsetTop();
        int r18 = getChildCount();
        int r19 = 0;
    L5:
        if (r19 >= r18) goto L12;
        View r20 = getChildAt(r19);
        if (ViewCompat.getFitsSystemWindows(r20) == true) goto L11;
        if (r20.getTop() >= r17) goto L11;
        ViewCompat.offsetTopAndBottom(r20, r17);
    L11:
        r19 = r19 + 1;
    L12:
        int r21 = getChildCount();
        int r22 = 0;
    L13:
        if (r22 >= r21) goto L15;
        j(getChildAt(r22)).g();
        r22 = r22 + 1;
        goto L13
    L15:
        v(r11, r12, r13, r14, false);
        w();
        u();
        int r23 = getChildCount();
    L16:
        if (r16 >= r23) goto L18;
        j(getChildAt(r16)).a();
        r16 = r16 + 1;
        goto L16
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int r10, int r11) {
        c();
        super.onMeasure(r10, r11);
        int r12 = View.MeasureSpec.getMode(r11);
        WindowInsetsCompat r13 = this.D;
        if (r13 == null) goto L5;
        int r14 = r13.getSystemWindowInsetTop();
    L7:
        if (r12 != 0) goto L9;
    L10:
        if (r14 <= 0) goto L13;
        this.E = r14;
        super.onMeasure(r10, View.MeasureSpec.makeMeasureSpec(getMeasuredHeight() + r14, 1073741824));
    L13:
        if (this.H == true) goto L15;
    L19:
        ViewGroup r15 = this.f2958h;
        if (r15 == null) goto L29;
        View r16 = this.f2959i;
        if (r16 == null) goto L26;
        if (r16 == this) goto L26;
        int r17 = g(r16);
    L27:
        setMinimumHeight(r17);
        return;
    L26:
        r17 = g(r15);
        goto L27
    L29:
        return;
    L15:
        if (this.f2966p.J() <= 1) goto L19;
        w();
        v(0, 0, getMeasuredWidth(), getMeasuredHeight(), true);
        int r18 = this.f2966p.y();
        if (r18 <= 1) goto L19;
        this.G = Math.round(this.f2966p.z()) * (r18 - 1);
        super.onMeasure(r10, View.MeasureSpec.makeMeasureSpec(getMeasuredHeight() + this.G, 1073741824));
        goto L19
    L9:
        if (this.F == false) goto L13;
    L5:
        r14 = 0;
        goto L7
    }

    @Override // android.view.View
    protected void onSizeChanged(int r10, int r11, int r12, int r13) {
        super.onSizeChanged(r10, r11, r12, r13);
        Drawable r14 = this.f2970t;
        if (r14 == null) goto L6;
        r(r14, r10, r11);
        return;
    }

    public void setCollapsedTitleGravity(int r10) {
        this.f2966p.g0(r10);
    }

    public void setCollapsedTitleTextAppearance(@StyleRes int r10) {
        this.f2966p.d0(r10);
    }

    public void setCollapsedTitleTextColor(@ColorInt int r10) {
        setCollapsedTitleTextColor(ColorStateList.valueOf(r10));
    }

    public void setCollapsedTitleTextColor(@NonNull ColorStateList r10) {
        this.f2966p.f0(r10);
    }

    public void setCollapsedTitleTypeface(@Nullable Typeface r10) {
        this.f2966p.h0(r10);
    }

    public void setContentScrim(@Nullable Drawable r10) {
        Drawable r11 = this.f2970t;
        if (r11 == r10) goto L14;
        Drawable r12 = null;
        if (r11 == null) goto L7;
        r11.setCallback(null);
    L7:
        if (r10 == null) goto L9;
        r12 = r10.mutate();
    L9:
        this.f2970t = r12;
        if (r12 == null) goto L12;
        r(r12, getWidth(), getHeight());
        this.f2970t.setCallback(this);
        this.f2970t.setAlpha(this.f2972v);
    L12:
        ViewCompat.postInvalidateOnAnimation(this);
        return;
    }

    public void setContentScrimColor(@ColorInt int r10) {
        setContentScrim(new ColorDrawable(r10));
    }

    public void setContentScrimResource(@DrawableRes int r10) {
        setContentScrim(ContextCompat.getDrawable(getContext(), r10));
    }

    public void setExpandedTitleColor(@ColorInt int r10) {
        setExpandedTitleTextColor(ColorStateList.valueOf(r10));
    }

    public void setExpandedTitleGravity(int r10) {
        this.f2966p.q0(r10);
    }

    public void setExpandedTitleMarginBottom(int r10) {
        this.f2964n = r10;
        requestLayout();
    }

    public void setExpandedTitleMarginEnd(int r10) {
        this.f2963m = r10;
        requestLayout();
    }

    public void setExpandedTitleMarginStart(int r10) {
        this.f2961k = r10;
        requestLayout();
    }

    public void setExpandedTitleMarginTop(int r10) {
        this.f2962l = r10;
        requestLayout();
    }

    public void setExpandedTitleTextAppearance(@StyleRes int r10) {
        this.f2966p.n0(r10);
    }

    public void setExpandedTitleTextColor(@NonNull ColorStateList r10) {
        this.f2966p.p0(r10);
    }

    public void setExpandedTitleTypeface(@Nullable Typeface r10) {
        this.f2966p.s0(r10);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setExtraMultilineHeightEnabled(boolean r10) {
        this.H = r10;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setForceApplySystemWindowInsetTop(boolean r10) {
        this.F = r10;
    }

    @RequiresApi(23)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setHyphenationFrequency(int r10) {
        this.f2966p.x0(r10);
    }

    @RequiresApi(23)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setLineSpacingAdd(float r10) {
        this.f2966p.z0(r10);
    }

    @RequiresApi(23)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setLineSpacingMultiplier(@FloatRange(from = 0.0d) float r10) {
        this.f2966p.A0(r10);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setMaxLines(int r10) {
        this.f2966p.B0(r10);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setRtlTextDirectionHeuristicsEnabled(boolean r10) {
        this.f2966p.D0(r10);
    }

    void setScrimAlpha(int r10) {
        if (r10 != this.f2972v) goto L5;
        return;
    L5:
        if (this.f2970t == null) goto L9;
        ViewGroup r11 = this.f2958h;
        if (r11 == null) goto L9;
        ViewCompat.postInvalidateOnAnimation(r11);
    L9:
        this.f2972v = r10;
        ViewCompat.postInvalidateOnAnimation(this);
    }

    public void setScrimAnimationDuration(@IntRange(from = 0) long r10) {
        this.f2975y = r10;
    }

    public void setScrimVisibleHeightTrigger(@IntRange(from = 0) int r10) {
        if (this.f2976z == r10) goto L6;
        this.f2976z = r10;
        u();
        return;
    }

    public void setScrimsShown(boolean r10) {
        if (ViewCompat.isLaidOut(this) == true) goto L5;
    L7:
        boolean r11 = false;
    L8:
        o(r10, r11);
        return;
    L5:
        if (isInEditMode() == true) goto L7;
        r11 = true;
        goto L8
    }

    public void setStatusBarScrim(@Nullable Drawable r10) {
        Drawable r11 = this.f2971u;
        if (r11 == r10) goto L21;
        Drawable r12 = null;
        if (r11 == null) goto L7;
        r11.setCallback(null);
    L7:
        if (r10 == null) goto L9;
        r12 = r10.mutate();
    L9:
        this.f2971u = r12;
        if (r12 != null) goto L12;
    L19:
        ViewCompat.postInvalidateOnAnimation(this);
        return;
    L12:
        if (r12.isStateful() == false) goto L14;
        this.f2971u.setState(getDrawableState());
    L14:
        DrawableCompat.setLayoutDirection(this.f2971u, ViewCompat.getLayoutDirection(this));
        Drawable r13 = this.f2971u;
        if (getVisibility() != 0) goto L17;
        boolean r14 = true;
    L18:
        r13.setVisible(r14, false);
        this.f2971u.setCallback(this);
        this.f2971u.setAlpha(this.f2972v);
        goto L19
    L17:
        r14 = false;
        goto L18
    }

    public void setStatusBarScrimColor(@ColorInt int r10) {
        setStatusBarScrim(new ColorDrawable(r10));
    }

    public void setStatusBarScrimResource(@DrawableRes int r10) {
        setStatusBarScrim(ContextCompat.getDrawable(getContext(), r10));
    }

    public void setTitle(@Nullable CharSequence r10) {
        this.f2966p.F0(r10);
        q();
    }

    public void setTitleCollapseMode(int r10) {
        this.C = r10;
        boolean r11 = k();
        this.f2966p.v0(r11);
        ViewParent r12 = getParent();
        if ((r12 instanceof AppBarLayout) == false) goto L5;
        b((AppBarLayout) r12);
    L5:
        if (r11 == true) goto L7;
        return;
    L7:
        if (this.f2970t != null) goto L11;
        float r13 = getResources().getDimension(q5.d.design_appbar_elevation);
        setContentScrimColor(this.f2967q.d(r13));
        return;
    }

    public void setTitleEnabled(boolean r10) {
        if (r10 == this.f2968r) goto L6;
        this.f2968r = r10;
        q();
        t();
        requestLayout();
        return;
    }

    public void setTitlePositionInterpolator(@Nullable TimeInterpolator r10) {
        this.f2966p.C0(r10);
    }

    @Override // android.view.View
    public void setVisibility(int r10) {
        super.setVisibility(r10);
        if (r10 != 0) goto L5;
        boolean r11 = true;
    L6:
        Drawable r12 = this.f2971u;
        if (r12 != null) goto L9;
    L11:
        Drawable r13 = this.f2970t;
        if (r13 != null) goto L14;
        return;
    L14:
        if (r13.isVisible() == r11) goto L18;
        this.f2970t.setVisible(r11, false);
        return;
    L18:
        return;
    L9:
        if (r12.isVisible() == r11) goto L11;
        this.f2971u.setVisible(r11, false);
        goto L11
    L5:
        r11 = false;
        goto L6
    }

    final void u() {
        if (this.f2970t != null) goto L7;
        if (this.f2971u != null) goto L7;
        return;
    L7:
        if ((getHeight() + this.B) >= getScrimVisibleHeightTrigger()) goto L9;
        boolean r10 = true;
    L10:
        setScrimsShown(r10);
        return;
    L9:
        r10 = false;
        goto L10
    }

    @Override // android.view.View
    protected boolean verifyDrawable(@NonNull Drawable r10) {
        if (super.verifyDrawable(r10) == false) goto L5;
    L10:
        return true;
    L5:
        if (r10 == this.f2970t) goto L10;
        if (r10 == this.f2971u) goto L10;
        return false;
    }
}
