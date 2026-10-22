package androidx.appcompat.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import android.widget.OverScroller;
import androidx.appcompat.app.AppCompatDelegateImpl;
import com.obric.cae.R;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"UnknownNullness"})
public class ActionBarOverlayLayout extends ViewGroup implements b0, j0.n, j0.o {
    public static final int[] L = null;
    public j0.m0 A;
    public j0.m0 B;
    public j0.m0 C;
    public j0.m0 D;
    public d E;
    public OverScroller F;
    public ViewPropertyAnimator G;
    public final a H;
    public final b I;
    public final c J;
    public final j0.p K;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f919a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f920b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public ContentFrameLayout f921m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public ActionBarContainer f922n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public c0 f923o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Drawable f924p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f925q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f926r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f927s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f928t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f929u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f930v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f931w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Rect f932x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final Rect f933y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final Rect f934z;

    public class a extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ActionBarOverlayLayout f935a;

        public a(ActionBarOverlayLayout r8) {
            this.f935a = r8;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r8) {
            ActionBarOverlayLayout r10 = this.f935a;
            r10.G = null;
            r10.f929u = false;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r8) {
            ActionBarOverlayLayout r10 = this.f935a;
            r10.G = null;
            r10.f929u = false;
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ActionBarOverlayLayout f936a;

        public b(ActionBarOverlayLayout r8) {
            this.f936a = r8;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ActionBarOverlayLayout r8 = this.f936a;
            r8.q();
            r8.G = r8.f922n.animate().translationY(0.0f).setListener(r8.H);
        }
    }

    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ActionBarOverlayLayout f937a;

        public c(ActionBarOverlayLayout r8) {
            this.f937a = r8;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ActionBarOverlayLayout r8 = this.f937a;
            r8.q();
            r8.G = r8.f922n.animate().translationY(-r8.f922n.getHeight()).setListener(r8.H);
        }
    }

    public interface d {
    }

    public static class e extends ViewGroup.MarginLayoutParams {
        public e() {
            super(-1, -1);
        }
    }

    static {
        L = new int[]{R.attr.actionBarSize, android.R.attr.windowContentOverlay};
    }

    public ActionBarOverlayLayout(Context r8, AttributeSet r10) {
        super(r8, r10);
        this.f920b = 0;
        this.f932x = new Rect();
        this.f933y = new Rect();
        this.f934z = new Rect();
        new Rect();
        new Rect();
        new Rect();
        new Rect();
        j0.m0 r11 = j0.m0.f8408b;
        this.A = r11;
        this.B = r11;
        this.C = r11;
        this.D = r11;
        this.H = new a(this);
        this.I = new b(this);
        this.J = new c(this);
        r(r8);
        this.K = new j0.p();
    }

    public static boolean p(FrameLayout r8, Rect r10, boolean r11) {
        e r12 = (e) r8.getLayoutParams();
        int r13 = ((ViewGroup.MarginLayoutParams) r12).leftMargin;
        int r14 = r10.left;
        if (r13 == r14) goto L5;
        ((ViewGroup.MarginLayoutParams) r12).leftMargin = r14;
        boolean r15 = true;
    L6:
        int r16 = ((ViewGroup.MarginLayoutParams) r12).topMargin;
        int r17 = r10.top;
        if (r16 == r17) goto L9;
        ((ViewGroup.MarginLayoutParams) r12).topMargin = r17;
        r15 = true;
    L9:
        int r18 = ((ViewGroup.MarginLayoutParams) r12).rightMargin;
        int r19 = r10.right;
        if (r18 == r19) goto L12;
        ((ViewGroup.MarginLayoutParams) r12).rightMargin = r19;
        r15 = true;
    L12:
        if (r11 == false) goto L17;
        int r20 = ((ViewGroup.MarginLayoutParams) r12).bottomMargin;
        int r21 = r10.bottom;
        if (r20 == r21) goto L17;
        ((ViewGroup.MarginLayoutParams) r12).bottomMargin = r21;
        return true;
    L17:
        return r15;
    L5:
        r15 = false;
        goto L6
    }

    @Override // androidx.appcompat.widget.b0
    public final boolean a() {
        s();
        return this.f923o.a();
    }

    @Override // androidx.appcompat.widget.b0
    public final void b(androidx.appcompat.view.menu.f r8, AppCompatDelegateImpl.d r10) {
        s();
        this.f923o.b(r8, r10);
    }

    @Override // androidx.appcompat.widget.b0
    public final boolean c() {
        s();
        return this.f923o.c();
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams r8) {
        return r8 instanceof e;
    }

    @Override // androidx.appcompat.widget.b0
    public final boolean d() {
        s();
        return this.f923o.d();
    }

    @Override // android.view.View
    public final void draw(Canvas r8) {
        super.draw(r8);
        if (this.f924p != null) goto L5;
        return;
    L5:
        if (this.f925q == false) goto L7;
        return;
    L7:
        if (this.f922n.getVisibility() != 0) goto L9;
        int r10 = (int) ((this.f922n.getTranslationY() + this.f922n.getBottom()) + 0.5f);
    L10:
        this.f924p.setBounds(0, r10, getWidth(), this.f924p.getIntrinsicHeight() + r10);
        this.f924p.draw(r8);
        return;
    L9:
        r10 = 0;
        goto L10
    }

    @Override // androidx.appcompat.widget.b0
    public final boolean e() {
        s();
        return this.f923o.e();
    }

    @Override // androidx.appcompat.widget.b0
    public final void f() {
        s();
        this.f923o.f();
    }

    @Override // android.view.View
    public final boolean fitSystemWindows(Rect r8) {
        return super.fitSystemWindows(r8);
    }

    @Override // androidx.appcompat.widget.b0
    public final boolean g() {
        s();
        return this.f923o.g();
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new e();
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet r8) {
        return new e(getContext(), r8);
    }

    public int getActionBarHideOffset() {
        ActionBarContainer r8 = this.f922n;
        if (r8 != null) goto L7;
        return 0;
    L7:
        return -((int) r8.getTranslationY());
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        j0.p r8 = this.K;
        int r10 = r8.f8432a;
        return r8.f8433b | r10;
    }

    public CharSequence getTitle() {
        s();
        return this.f923o.getTitle();
    }

    @Override // androidx.appcompat.widget.b0
    public final void h(int r8) {
        s();
        if (r8 != 2) goto L5;
        this.f923o.l();
        return;
    L5:
        if (r8 != 5) goto L7;
        this.f923o.t();
        return;
    L7:
        if (r8 != 109) goto L15;
        setOverlayMode(true);
        return;
    }

    @Override // j0.n
    public final void i(View r8, View r10, int r11, int r12) {
        if (r12 != 0) goto L5;
        onNestedScrollAccepted(r8, r10, r11);
        return;
    }

    @Override // j0.n
    public final void j(View r8, int r10) {
        if (r10 != 0) goto L5;
        onStopNestedScroll(r8);
        return;
    }

    @Override // j0.n
    public final void k(View r8, int r10, int r11, int[] r12, int r13) {
        if (r13 != 0) goto L5;
        onNestedPreScroll(r8, r10, r11, r12);
        return;
    }

    @Override // androidx.appcompat.widget.b0
    public final void l() {
        s();
        this.f923o.n();
    }

    @Override // j0.o
    public final void m(View r8, int r10, int r11, int r12, int r13, int r14, int[] r15) {
        n(r8, r10, r11, r12, r13, r14);
    }

    @Override // j0.n
    public final void n(View r8, int r10, int r11, int r12, int r13, int r14) {
        if (r14 != 0) goto L5;
        onNestedScroll(r8, r10, r11, r12, r13);
        return;
    }

    @Override // j0.n
    public final boolean o(View r8, View r10, int r11, int r12) {
        if (r12 == 0) goto L4;
    L6:
        return false;
    L4:
        if (onStartNestedScroll(r8, r10, r11) == false) goto L6;
        return true;
    }

    @Override // android.view.View
    public final WindowInsets onApplyWindowInsets(WindowInsets r8) {
        s();
        j0.m0 r10 = j0.m0.h(this, r8);
        boolean r11 = p(this.f922n, new Rect(r10.c(), r10.e(), r10.d(), r10.b()), false);
        WeakHashMap<View, j0.h0> r12 = j0.w.f8437a;
        Rect r13 = this.f932x;
        j0.w.i.b(this, r10, r13);
        int r14 = r13.left;
        int r15 = r13.top;
        int r16 = r13.right;
        int r17 = r13.bottom;
        j0.m0.k r18 = r10.f8409a;
        j0.m0 r19 = r18.l(r14, r15, r16, r17);
        this.A = r19;
        boolean r20 = true;
        if (this.B.equals(r19) == true) goto L5;
        this.B = this.A;
        r11 = true;
    L5:
        Rect r21 = this.f933y;
        if (r21.equals(r13) == true) goto L8;
        r21.set(r13);
    L9:
        if (r20 == false) goto L12;
        requestLayout();
    L12:
        return r18.a().f8409a.c().f8409a.b().g();
    L8:
        r20 = r11;
        goto L9
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration r8) {
        super.onConfigurationChanged(r8);
        r(getContext());
        WeakHashMap<View, j0.h0> r10 = j0.w.f8437a;
        j0.w.h.c(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        q();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r8, int r10, int r11, int r12, int r13) {
        int r14 = getChildCount();
        int r15 = getPaddingLeft();
        int r16 = getPaddingTop();
        int r17 = 0;
    L3:
        if (r17 >= r14) goto L8;
        View r18 = getChildAt(r17);
        if (r18.getVisibility() == 8) goto L7;
        e r19 = (e) r18.getLayoutParams();
        int r20 = r18.getMeasuredWidth();
        int r21 = r18.getMeasuredHeight();
        int r22 = ((ViewGroup.MarginLayoutParams) r19).leftMargin + r15;
        int r23 = ((ViewGroup.MarginLayoutParams) r19).topMargin + r16;
        r18.layout(r22, r23, r20 + r22, r21 + r23);
    L7:
        r17 = r17 + 1;
        goto L3
    }

    @Override // android.view.View
    public final void onMeasure(int r12, int r13) {
        s();
        measureChildWithMargins(this.f922n, r12, 0, r13, 0);
        e r8 = (e) this.f922n.getLayoutParams();
        int r10 = Math.max(0, (this.f922n.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) r8).leftMargin) + ((ViewGroup.MarginLayoutParams) r8).rightMargin);
        int r11 = Math.max(0, (this.f922n.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) r8).topMargin) + ((ViewGroup.MarginLayoutParams) r8).bottomMargin);
        int r14 = View.combineMeasuredStates(0, this.f922n.getMeasuredState());
        WeakHashMap<View, j0.h0> r15 = j0.w.f8437a;
        if ((j0.w.d.g(this) & 256) == 0) goto L5;
        boolean r16 = true;
    L6:
        if (r16 == false) goto L13;
        int r17 = this.f919a;
        if (this.f927s == true) goto L10;
    L16:
        Rect r18 = this.f932x;
        Rect r19 = this.f934z;
        r19.set(r18);
        j0.m0 r20 = this.A;
        this.C = r20;
        if (this.f926r == true) goto L20;
        if (r16 == true) goto L20;
        r19.top += r17;
        r19.bottom += 0;
        j0.m0 r21 = r20.f8409a.l(0, r17, 0, 0);
    L21:
        this.C = r21;
        p(this.f921m, r19, true);
        if (this.D.equals(this.C) == true) goto L24;
        j0.m0 r22 = this.C;
        this.D = r22;
        j0.w.b(this.f921m, r22);
    L24:
        measureChildWithMargins(this.f921m, r12, 0, r13, 0);
        e r23 = (e) this.f921m.getLayoutParams();
        int r24 = Math.max(r10, (this.f921m.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) r23).leftMargin) + ((ViewGroup.MarginLayoutParams) r23).rightMargin);
        int r25 = Math.max(r11, (this.f921m.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) r23).topMargin) + ((ViewGroup.MarginLayoutParams) r23).bottomMargin);
        int r26 = View.combineMeasuredStates(r14, this.f921m.getMeasuredState());
        setMeasuredDimension(View.resolveSizeAndState(Math.max((getPaddingRight() + getPaddingLeft()) + r24, getSuggestedMinimumWidth()), r12, r26), View.resolveSizeAndState(Math.max((getPaddingBottom() + getPaddingTop()) + r25, getSuggestedMinimumHeight()), r13, r26 << 16));
        return;
    L20:
        a0.b r27 = a0.b.b(r20.c(), this.C.e() + r17, this.C.d(), this.C.b() + 0);
        j0.m0.b r28 = new j0.m0.b(this.C);
        r28.f8414a.d(r27);
        r21 = r28.a();
        goto L21
    L10:
        if (this.f922n.getTabContainer() == null) goto L16;
        r17 = r17 + this.f919a;
        goto L16
    L13:
        if (this.f922n.getVisibility() == 8) goto L15;
        r17 = this.f922n.getMeasuredHeight();
        goto L16
    L15:
        r17 = 0;
        goto L16
    L5:
        r16 = false;
        goto L6
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedFling(View r10, float r11, float r12, boolean r13) {
        boolean r14 = false;
        if (this.f928t == false) goto L14;
        if (r13 == false) goto L14;
        this.F.fling(0, 0, 0, (int) r12, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        if (this.F.getFinalY() <= this.f922n.getHeight()) goto L9;
        r14 = true;
    L9:
        if (r14 == false) goto L11;
        q();
        this.J.run();
    L12:
        this.f929u = true;
        return true;
    L11:
        q();
        this.I.run();
    L14:
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedPreFling(View r8, float r10, float r11) {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedPreScroll(View r8, int r10, int r11, int[] r12) {
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedScroll(View r8, int r10, int r11, int r12, int r13) {
        int r14 = this.f930v + r11;
        this.f930v = r14;
        setActionBarHideOffset(r14);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedScrollAccepted(View r8, View r10, int r11) {
        this.K.f8432a = r11;
        this.f930v = getActionBarHideOffset();
        q();
        d r12 = this.E;
        if (r12 == null) goto L8;
        androidx.appcompat.app.w r13 = (androidx.appcompat.app.w) r12;
        g.h r14 = r13.f726t;
        if (r14 == null) goto L9;
        r14.a();
        r13.f726t = null;
        return;
    L9:
        return;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onStartNestedScroll(View r8, View r10, int r11) {
        if ((r11 & 2) != 0) goto L5;
        return false;
    L5:
        if (this.f922n.getVisibility() == 0) goto L8;
        return false;
    L8:
        return this.f928t;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onStopNestedScroll(View r8) {
        if (this.f928t == true) goto L5;
        return;
    L5:
        if (this.f929u == false) goto L7;
        return;
    L7:
        if (this.f930v > this.f922n.getHeight()) goto L9;
        q();
        postDelayed(this.I, 600);
        return;
    L9:
        q();
        postDelayed(this.J, 600);
    }

    @Override // android.view.View
    @Deprecated
    public final void onWindowSystemUiVisibilityChanged(int r8) {
        super.onWindowSystemUiVisibilityChanged(r8);
        s();
        int r10 = this.f931w ^ r8;
        this.f931w = r8;
        if ((r8 & 4) != 0) goto L5;
        boolean r11 = true;
    L7:
        if ((r8 & 256) == 0) goto L9;
        boolean r12 = true;
    L10:
        d r13 = this.E;
        if (r13 == null) goto L23;
        ((androidx.appcompat.app.w) r13).f722p = !r12;
        if (r11 == true) goto L19;
        if (r12 == false) goto L19;
        androidx.appcompat.app.w r14 = (androidx.appcompat.app.w) r13;
        if (r14.f723q == true) goto L23;
        r14.f723q = true;
        r14.s(true);
    L19:
        androidx.appcompat.app.w r15 = (androidx.appcompat.app.w) r13;
        if (r15.f723q == false) goto L23;
        r15.f723q = false;
        r15.s(true);
    L23:
        if ((r10 & 256) != 0) goto L25;
        return;
    L25:
        if (this.E == null) goto L29;
        WeakHashMap<View, j0.h0> r16 = j0.w.f8437a;
        j0.w.h.c(this);
        return;
    L29:
        return;
    L9:
        r12 = false;
        goto L10
    L5:
        r11 = false;
        goto L7
    }

    @Override // android.view.View
    public final void onWindowVisibilityChanged(int r8) {
        super.onWindowVisibilityChanged(r8);
        this.f920b = r8;
        d r10 = this.E;
        if (r10 == null) goto L6;
        ((androidx.appcompat.app.w) r10).f721o = r8;
        return;
    }

    public final void q() {
        removeCallbacks(this.I);
        removeCallbacks(this.J);
        ViewPropertyAnimator r8 = this.G;
        if (r8 == null) goto L6;
        r8.cancel();
        return;
    }

    public final void r(Context r8) {
        TypedArray r10 = getContext().getTheme().obtainStyledAttributes(L);
        boolean r11 = false;
        this.f919a = r10.getDimensionPixelSize(0, 0);
        Drawable r12 = r10.getDrawable(1);
        this.f924p = r12;
        if (r12 != null) goto L5;
        boolean r13 = true;
    L6:
        setWillNotDraw(r13);
        r10.recycle();
        if (r8.getApplicationInfo().targetSdkVersion >= 19) goto L9;
        r11 = true;
    L9:
        this.f925q = r11;
        this.F = new OverScroller(r8);
        return;
    L5:
        r13 = false;
        goto L6
    }

    public final void s() {
        if (this.f921m != null) goto L13;
        this.f921m = (ContentFrameLayout) findViewById(R.id.action_bar_activity_content);
        this.f922n = (ActionBarContainer) findViewById(R.id.action_bar_container);
        KeyEvent.Callback r8 = findViewById(R.id.action_bar);
        if ((r8 instanceof c0) == false) goto L8;
        c0 r10 = (c0) r8;
    L10:
        this.f923o = r10;
        return;
    L8:
        if ((r8 instanceof Toolbar) == false) goto L12;
        r10 = ((Toolbar) r8).getWrapper();
        goto L10
    L12:
        throw new IllegalStateException("Can't make a decor toolbar out of ".concat(r8.getClass().getSimpleName()));
    }

    public void setActionBarHideOffset(int r8) {
        q();
        this.f922n.setTranslationY(-Math.max(0, Math.min(r8, this.f922n.getHeight())));
    }

    public void setActionBarVisibilityCallback(d r8) {
        this.E = r8;
        if (getWindowToken() == null) goto L8;
        d r10 = this.E;
        ((androidx.appcompat.app.w) r10).f721o = this.f920b;
        int r11 = this.f931w;
        if (r11 == 0) goto L9;
        onWindowSystemUiVisibilityChanged(r11);
        WeakHashMap<View, j0.h0> r12 = j0.w.f8437a;
        j0.w.h.c(this);
        return;
    L9:
        return;
    }

    public void setHasNonEmbeddedTabs(boolean r8) {
        this.f927s = r8;
    }

    public void setHideOnContentScrollEnabled(boolean r8) {
        if (r8 == this.f928t) goto L8;
        this.f928t = r8;
        if (r8 == true) goto L9;
        q();
        setActionBarHideOffset(0);
        return;
    L9:
        return;
    }

    public void setIcon(int r8) {
        s();
        this.f923o.setIcon(r8);
    }

    public void setLogo(int r8) {
        s();
        this.f923o.q(r8);
    }

    public void setOverlayMode(boolean r8) {
        this.f926r = r8;
        if (r8 == true) goto L5;
    L7:
        boolean r10 = false;
    L8:
        this.f925q = r10;
        return;
    L5:
        if (getContext().getApplicationInfo().targetSdkVersion >= 19) goto L7;
        r10 = true;
        goto L8
    }

    public void setShowingForActionMode(boolean r8) {
    }

    public void setUiOptions(int r8) {
    }

    @Override // androidx.appcompat.widget.b0
    public void setWindowCallback(Window.Callback r8) {
        s();
        this.f923o.setWindowCallback(r8);
    }

    @Override // androidx.appcompat.widget.b0
    public void setWindowTitle(CharSequence r8) {
        s();
        this.f923o.setWindowTitle(r8);
    }

    @Override // android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return false;
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r8) {
        return new e(r8);
    }

    public void setIcon(Drawable r8) {
        s();
        this.f923o.setIcon(r8);
    }
}
