package com.google.android.material.snackbar;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityManager;
import android.widget.FrameLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.behavior.SwipeDismissBehavior;
import com.google.android.material.internal.r;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class BaseTransientBottomBar<B extends BaseTransientBottomBar<B>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final Handler f4079a = null;
    private static final boolean d = false;
    private static final int[] e = null;
    private static final String f = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final SnackbarBaseLayout f4080b;
    com.google.android.material.snackbar.b.a c;
    private final ViewGroup g;
    private final Context h;
    private final com.google.android.material.snackbar.a i;
    private boolean j;
    private a k;
    private boolean l;
    private final Runnable m;
    private int n;
    private int o;
    private int p;
    private int q;
    private int r;
    private boolean s;
    private List<b<B>> t;
    private Behavior u;
    private final AccessibilityManager v;

    /* JADX INFO: renamed from: com.google.android.material.snackbar.BaseTransientBottomBar$3, reason: invalid class name */
    class AnonymousClass3 implements OnApplyWindowInsetsListener {
        final /* synthetic */ BaseTransientBottomBar this$0;

        AnonymousClass3(BaseTransientBottomBar r1) {
            this.this$0 = r1;
        }

        @Override // androidx.core.view.OnApplyWindowInsetsListener
        public WindowInsetsCompat onApplyWindowInsets(View r2, WindowInsetsCompat r3) {
            BaseTransientBottomBar.a(this.this$0, r3.getSystemWindowInsetBottom());
            BaseTransientBottomBar.b(this.this$0, r3.getSystemWindowInsetLeft());
            BaseTransientBottomBar.c(this.this$0, r3.getSystemWindowInsetRight());
            BaseTransientBottomBar.a(this.this$0);
            return r3;
        }
    }

    /* JADX INFO: renamed from: com.google.android.material.snackbar.BaseTransientBottomBar$4, reason: invalid class name */
    class AnonymousClass4 extends AccessibilityDelegateCompat {
        final /* synthetic */ BaseTransientBottomBar this$0;

        AnonymousClass4(BaseTransientBottomBar r1) {
            this.this$0 = r1;
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View r1, AccessibilityNodeInfoCompat r2) {
            super.onInitializeAccessibilityNodeInfo(r1, r2);
            r2.addAction(1048576);
            r2.setDismissable(true);
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public boolean performAccessibilityAction(View r2, int r3, Bundle r4) {
            if (r3 != 1048576) goto L7;
            this.this$0.b();
            return true;
        L7:
            return super.performAccessibilityAction(r2, r3, r4);
        }
    }

    public static class Behavior extends SwipeDismissBehavior<View> {
        private final c delegate;

        public Behavior() {
            this.delegate = new c(this);
        }

        static /* synthetic */ void access$1100(Behavior r0, BaseTransientBottomBar r1) {
            r0.setBaseTransientBottomBar(r1);
        }

        private void setBaseTransientBottomBar(BaseTransientBottomBar<?> r1) {
            this.delegate.a(r1);
        }

        @Override // com.google.android.material.behavior.SwipeDismissBehavior
        public boolean canSwipeDismissView(View r1) {
            return this.delegate.a(r1);
        }

        @Override // com.google.android.material.behavior.SwipeDismissBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean onInterceptTouchEvent(CoordinatorLayout r2, View r3, MotionEvent r4) {
            this.delegate.a(r2, r3, r4);
            return super.onInterceptTouchEvent(r2, r3, r4);
        }
    }

    protected static class SnackbarBaseLayout extends FrameLayout {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final View.OnTouchListener f4096a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private BaseTransientBottomBar<?> f4097b;
        private int c;
        private final float d;
        private final float e;
        private final int f;
        private final int g;
        private ColorStateList h;
        private PorterDuff.Mode i;
        private Rect j;
        private boolean k;

        static {
            f4096a = new AnonymousClass1();
        }

        public SnackbarBaseLayout(Context r3) {
            this((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), null);
        }

        public SnackbarBaseLayout(Context r5, AttributeSet r6) {
            Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
            AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r6, AttributeSet.class, "com.obric.memorydata.plugin");
            super((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.google.android.material.theme.a.a.a(r7, r8, 0, 0), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r8);
            Context r9 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
            TypedArray r10 = r9.obtainStyledAttributes(r8, R.styleable.SnackbarLayout);
            if (r10.hasValue(ZeusTransformUtils.mapRes(R.styleable.SnackbarLayout_elevation, "styleable", "SnackbarLayout_elevation")) == false) goto L5;
            ViewCompat.setElevation(this, r10.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.SnackbarLayout_elevation, "styleable", "SnackbarLayout_elevation"), 0));
        L5:
            this.c = r10.getInt(ZeusTransformUtils.mapRes(R.styleable.SnackbarLayout_animationMode, "styleable", "SnackbarLayout_animationMode"), 0);
            this.d = r10.getFloat(ZeusTransformUtils.mapRes(R.styleable.SnackbarLayout_backgroundOverlayColorAlpha, "styleable", "SnackbarLayout_backgroundOverlayColorAlpha"), 1.0f);
            setBackgroundTintList(com.google.android.material.resources.c.a(r9, r10, ZeusTransformUtils.mapRes(R.styleable.SnackbarLayout_backgroundTint, "styleable", "SnackbarLayout_backgroundTint")));
            setBackgroundTintMode(r.a(r10.getInt(ZeusTransformUtils.mapRes(R.styleable.SnackbarLayout_backgroundTintMode, "styleable", "SnackbarLayout_backgroundTintMode"), -1), PorterDuff.Mode.SRC_IN));
            this.e = r10.getFloat(ZeusTransformUtils.mapRes(R.styleable.SnackbarLayout_actionTextColorAlpha, "styleable", "SnackbarLayout_actionTextColorAlpha"), 1.0f);
            this.f = r10.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.SnackbarLayout_android_maxWidth, "styleable", "SnackbarLayout_android_maxWidth"), -1);
            this.g = r10.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.SnackbarLayout_maxActionInlineWidth, "styleable", "SnackbarLayout_maxActionInlineWidth"), -1);
            r10.recycle();
            setOnTouchListener(f4096a);
            setFocusable(true);
            if (getBackground() != null) goto L9;
            ViewCompat.setBackground(this, a());
            return;
        }

        static /* synthetic */ Rect a(SnackbarBaseLayout r0) {
            return r0.j;
        }

        private Drawable a() {
            float r0 = ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getDimension(ZeusTransformUtils.mapRes(R.dimen.mtrl_snackbar_background_corner_radius, "dimen", "mtrl_snackbar_background_corner_radius"));
            GradientDrawable r1 = new GradientDrawable();
            r1.setShape(0);
            r1.setCornerRadius(r0);
            r1.setColor(com.google.android.material.c.a.a(this, ZeusTransformUtils.mapRes(R.attr.colorSurface, "attr", "colorSurface"), ZeusTransformUtils.mapRes(R.attr.colorOnSurface, "attr", "colorOnSurface"), getBackgroundOverlayColorAlpha()));
            if (this.h == null) goto L7;
            Drawable r2 = DrawableCompat.wrap(r1);
            DrawableCompat.setTintList(r2, this.h);
            return r2;
        L7:
            return DrawableCompat.wrap(r1);
        }

        private void a(ViewGroup.MarginLayoutParams r5) {
            this.j = new Rect(r5.leftMargin, r5.topMargin, r5.rightMargin, r5.bottomMargin);
        }

        private void setBaseTransientBottomBar(BaseTransientBottomBar<?> r1) {
            this.f4097b = r1;
        }

        void a(ViewGroup r2) {
            this.k = true;
            r2.addView(this);
            this.k = false;
        }

        float getActionTextColorAlpha() {
            return this.e;
        }

        int getAnimationMode() {
            return this.c;
        }

        float getBackgroundOverlayColorAlpha() {
            return this.d;
        }

        int getMaxInlineActionWidth() {
            return this.g;
        }

        int getMaxWidth() {
            return this.f;
        }

        @Override // android.view.ViewGroup, android.view.View
        public void onAttachedToWindow() {
            super.onAttachedToWindow();
            BaseTransientBottomBar<?> r0 = this.f4097b;
            if (r0 == null) goto L5;
            r0.f();
        L5:
            ViewCompat.requestApplyInsets(this);
        }

        @Override // android.view.ViewGroup, android.view.View
        public void onDetachedFromWindow() {
            super.onDetachedFromWindow();
            BaseTransientBottomBar<?> r0 = this.f4097b;
            if (r0 == null) goto L6;
            r0.g();
            return;
        }

        @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
        public void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
            super.onLayout(r1, r2, r3, r4, r5);
            BaseTransientBottomBar<?> r0 = this.f4097b;
            if (r0 == null) goto L6;
            r0.h();
            return;
        }

        @Override // android.widget.FrameLayout, android.view.View
        public void onMeasure(int r2, int r3) {
            super.onMeasure(r2, r3);
            if (this.f <= 0) goto L8;
            int r4 = getMeasuredWidth();
            int r0 = this.f;
            if (r4 <= r0) goto L9;
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(r0, 1073741824), r3);
            return;
        L9:
            return;
        }

        void setAnimationMode(int r1) {
            this.c = r1;
        }

        @Override // android.view.View
        public void setBackground(Drawable r1) {
            setBackgroundDrawable(r1);
        }

        @Override // android.view.View
        public void setBackgroundDrawable(Drawable r2) {
            if (r2 != null) goto L4;
        L6:
            super.setBackgroundDrawable(r2);
            return;
        L4:
            if (this.h == null) goto L6;
            r2 = DrawableCompat.wrap(r2.mutate());
            DrawableCompat.setTintList(r2, this.h);
            DrawableCompat.setTintMode(r2, this.i);
            goto L6
        }

        @Override // android.view.View
        public void setBackgroundTintList(ColorStateList r2) {
            this.h = r2;
            if (getBackground() == null) goto L8;
            Drawable r0 = DrawableCompat.wrap(getBackground().mutate());
            DrawableCompat.setTintList(r0, r2);
            DrawableCompat.setTintMode(r0, this.i);
            if (r0 == getBackground()) goto L9;
            super.setBackgroundDrawable(r0);
            return;
        L9:
            return;
        }

        @Override // android.view.View
        public void setBackgroundTintMode(PorterDuff.Mode r2) {
            this.i = r2;
            if (getBackground() == null) goto L8;
            Drawable r0 = DrawableCompat.wrap(getBackground().mutate());
            DrawableCompat.setTintMode(r0, r2);
            if (r0 == getBackground()) goto L9;
            super.setBackgroundDrawable(r0);
            return;
        L9:
            return;
        }

        @Override // android.view.View
        public void setLayoutParams(ViewGroup.LayoutParams r3) {
            super.setLayoutParams(r3);
            if (this.k == false) goto L5;
            return;
        L5:
            if (ZeusTransformUtils.instanceOf(r3, ViewGroup.MarginLayoutParams.class) == false) goto L11;
            a((ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r3, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin"));
            BaseTransientBottomBar<?> r2 = this.f4097b;
            if (r2 == null) goto L12;
            BaseTransientBottomBar.a(r2);
            return;
        L12:
            return;
        }

        @Override // android.view.View
        public void setOnClickListener(View.OnClickListener r3) {
            View.OnClickListener r4 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r3, View.OnClickListener.class, "com.obric.memorydata.plugin");
            if (r4 == null) goto L5;
            View.OnTouchListener r0 = null;
        L6:
            setOnTouchListener(r0);
            super.setOnClickListener(r4);
            return;
        L5:
            r0 = f4096a;
            goto L6
        }
    }

    static class a implements View.OnAttachStateChangeListener, ViewTreeObserver.OnGlobalLayoutListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final WeakReference<BaseTransientBottomBar> f4098a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final WeakReference<View> f4099b;

        private boolean c() {
            if (this.f4098a.get() != null) goto L6;
            b();
            return true;
        L6:
            return false;
        }

        View a() {
            return (View) ZeusTransformUtils.preCheckCast(this.f4099b.get(), View.class, "com.obric.memorydata.plugin");
        }

        void b() {
            if (this.f4099b.get() == null) goto L5;
            ((View) ZeusTransformUtils.preCheckCast(this.f4099b.get(), View.class, "com.obric.memorydata.plugin")).removeOnAttachStateChangeListener(this);
            r.b((View) ZeusTransformUtils.preCheckCast(this.f4099b.get(), View.class, "com.obric.memorydata.plugin"), this);
        L5:
            this.f4099b.clear();
            this.f4098a.clear();
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (c() == false) goto L5;
            return;
        L5:
            if (BaseTransientBottomBar.e((BaseTransientBottomBar) ZeusTransformUtils.preCheckCast(this.f4098a.get(), BaseTransientBottomBar.class, "com.obric.memorydata.plugin")) == false) goto L10;
            BaseTransientBottomBar.f((BaseTransientBottomBar) ZeusTransformUtils.preCheckCast(this.f4098a.get(), BaseTransientBottomBar.class, "com.obric.memorydata.plugin"));
            return;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View r2) {
            if (c() == false) goto L5;
            return;
        L5:
            r.a(r2, this);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View r2) {
            if (c() == false) goto L5;
            return;
        L5:
            r.b(r2, this);
        }
    }

    public static abstract class b<B> {
        public b() {
        }

        public void a(B r1) {
        }

        public void a(B r1, int r2) {
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private com.google.android.material.snackbar.b.a f4100a;

        public c(SwipeDismissBehavior<?> r1) {
            r1.setStartAlphaSwipeDistance(0.1f);
            r1.setEndAlphaSwipeDistance(0.6f);
            r1.setSwipeDirection(0);
        }

        public void a(CoordinatorLayout r2, View r3, MotionEvent r4) {
            int r0 = r4.getActionMasked();
            if (r0 == 0) goto L11;
            if (r0 != 1) goto L7;
        L9:
            com.google.android.material.snackbar.b.a().d(this.f4100a);
            return;
        L7:
            if (r0 == 3) goto L9;
            return;
        L11:
            if (r2.isPointInChildBounds(r3, (int) r4.getX(), (int) r4.getY()) == false) goto L15;
            com.google.android.material.snackbar.b.a().c(this.f4100a);
            return;
        }

        public void a(BaseTransientBottomBar<?> r1) {
            this.f4100a = r1.c;
        }

        public boolean a(View r1) {
            return ZeusTransformUtils.instanceOf(r1, SnackbarBaseLayout.class);
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 16) goto L5;
    L7:
        boolean r0 = false;
    L8:
        d = r0;
        e = new int[]{ZeusTransformUtils.mapRes(R.attr.snackbarStyle, "attr", "snackbarStyle")};
        f = BaseTransientBottomBar.class.getSimpleName();
        f4079a = new Handler(Looper.getMainLooper(), new AnonymousClass1());
        return;
    L5:
        if (Build.VERSION.SDK_INT > 19) goto L7;
        r0 = true;
        goto L8
    }

    static /* synthetic */ int a(BaseTransientBottomBar r0, int r1) {
        r0.n = r1;
        return r1;
    }

    private ValueAnimator a(float... r2) {
        ValueAnimator r3 = ValueAnimator.ofFloat(r2);
        r3.setInterpolator(com.google.android.material.a.a.f3741a);
        r3.addUpdateListener(new AnonymousClass5(this));
        return r3;
    }

    private void a(CoordinatorLayout.LayoutParams r4) {
        SwipeDismissBehavior<? extends View> r0 = this.u;
        if (r0 != null) goto L6;
        r0 = d();
    L6:
        if (ZeusTransformUtils.instanceOf(r0, Behavior.class) == false) goto L8;
        Behavior.access$1100((Behavior) ZeusTransformUtils.preCheckCast(r0, Behavior.class, "com.obric.memorydata.plugin"), this);
    L8:
        r0.setListener(new AnonymousClass12(this));
        r4.setBehavior(r0);
        if (a() != null) goto L12;
        r4.insetEdge = 80;
        return;
    }

    static /* synthetic */ void a(BaseTransientBottomBar r0) {
        r0.m();
    }

    static /* synthetic */ int b(BaseTransientBottomBar r0, int r1) {
        r0.o = r1;
        return r1;
    }

    private ValueAnimator b(float... r2) {
        ValueAnimator r3 = ValueAnimator.ofFloat(r2);
        r3.setInterpolator(com.google.android.material.a.a.d);
        r3.addUpdateListener(new AnonymousClass6(this));
        return r3;
    }

    static /* synthetic */ void b(BaseTransientBottomBar r0) {
        r0.s();
    }

    static /* synthetic */ int c(BaseTransientBottomBar r0, int r1) {
        r0.p = r1;
        return r1;
    }

    static /* synthetic */ void c(BaseTransientBottomBar r0) {
        r0.t();
    }

    static /* synthetic */ com.google.android.material.snackbar.a d(BaseTransientBottomBar r0) {
        return r0.i;
    }

    private void d(int r3) {
        if (this.f4080b.getAnimationMode() != 1) goto L5;
        e(r3);
        return;
    L5:
        f(r3);
    }

    private void e(final int r4) {
        ValueAnimator r0 = a(new float[]{1.0f, 0.0f});
        r0.setDuration(75);
        r0.addListener(new AnonymousClass2(this, r4));
        r0.start();
    }

    static /* synthetic */ boolean e(BaseTransientBottomBar r0) {
        return r0.l;
    }

    private void f(final int r5) {
        ValueAnimator r0 = new ValueAnimator();
        r0.setIntValues(new int[]{0, u()});
        r0.setInterpolator(com.google.android.material.a.a.f3742b);
        r0.setDuration(250);
        r0.addListener(new AnonymousClass9(this, r5));
        r0.addUpdateListener(new AnonymousClass10(this));
        r0.start();
    }

    static /* synthetic */ void f(BaseTransientBottomBar r0) {
        r0.q();
    }

    static /* synthetic */ boolean l() {
        return d;
    }

    private void m() {
        ViewGroup.LayoutParams r0 = this.f4080b.getLayoutParams();
        if (ZeusTransformUtils.instanceOf(r0, ViewGroup.MarginLayoutParams.class) == true) goto L5;
    L20:
        Log.w(f, "Unable to update margins because layout params are not MarginLayoutParams");
        return;
    L5:
        if (SnackbarBaseLayout.a(this.f4080b) == null) goto L20;
        if (this.f4080b.getParent() != null) goto L11;
        return;
    L11:
        if (a() == null) goto L13;
        int r1 = this.r;
    L14:
        ViewGroup.MarginLayoutParams r2 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r0, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin");
        r2.bottomMargin = SnackbarBaseLayout.a(this.f4080b).bottom + r1;
        r2.leftMargin = SnackbarBaseLayout.a(this.f4080b).left + this.o;
        r2.rightMargin = SnackbarBaseLayout.a(this.f4080b).right + this.p;
        r2.topMargin = SnackbarBaseLayout.a(this.f4080b).top;
        this.f4080b.requestLayout();
        if (Build.VERSION.SDK_INT >= 29) goto L17;
        return;
    L17:
        if (n() == false) goto L23;
        this.f4080b.removeCallbacks(this.m);
        this.f4080b.post(this.m);
        return;
    L23:
        return;
    L13:
        r1 = this.n;
        goto L14
    }

    private boolean n() {
        if (this.q > 0) goto L5;
    L9:
        return false;
    L5:
        if (this.j == true) goto L9;
        if (o() == false) goto L9;
        return true;
    }

    private boolean o() {
        ViewGroup.LayoutParams r2 = this.f4080b.getLayoutParams();
        if (ZeusTransformUtils.instanceOf(r2, CoordinatorLayout.LayoutParams.class) == true) goto L5;
    L7:
        return false;
    L5:
        if (ZeusTransformUtils.instanceOf(((CoordinatorLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r2, CoordinatorLayout.LayoutParams.class, "com.obric.memorydata.plugin")).getBehavior(), SwipeDismissBehavior.class) == false) goto L7;
        return true;
    }

    private void p() {
        if (k() == false) goto L6;
        i();
        return;
    L6:
        if (this.f4080b.getParent() == null) goto L8;
        this.f4080b.setVisibility(0);
    L8:
        j();
    }

    private void q() {
        this.r = r();
        m();
    }

    private int r() {
        if (a() != null) goto L6;
        return 0;
    L6:
        int[] r1 = new int[2];
        a().getLocationOnScreen(r1);
        int r2 = r1[1];
        int[] r0 = new int[2];
        this.g.getLocationOnScreen(r0);
        return (r0[1] + this.g.getHeight()) - r2;
    }

    private void s() {
        ValueAnimator r1 = a(new float[]{0.0f, 1.0f});
        ValueAnimator r2 = b(new float[]{0.8f, 1.0f});
        AnimatorSet r3 = new AnimatorSet();
        r3.playTogether(new Animator[]{r1, r2});
        r3.setDuration(150);
        r3.addListener(new AnonymousClass14(this));
        r3.start();
    }

    private void t() {
        final int r0 = u();
        if (d == false) goto L5;
        ViewCompat.offsetTopAndBottom(this.f4080b, r0);
    L6:
        ValueAnimator r1 = new ValueAnimator();
        r1.setIntValues(new int[]{r0, 0});
        r1.setInterpolator(com.google.android.material.a.a.f3742b);
        r1.setDuration(250);
        r1.addListener(new AnonymousClass7(this));
        r1.addUpdateListener(new AnonymousClass8(this, r0));
        r1.start();
        return;
    L5:
        this.f4080b.setTranslationY(r0);
        goto L6
    }

    private int u() {
        int r0 = this.f4080b.getHeight();
        ViewGroup.LayoutParams r3 = this.f4080b.getLayoutParams();
        if (ZeusTransformUtils.instanceOf(r3, ViewGroup.MarginLayoutParams.class) == true) goto L5;
        return r0;
    L5:
        return r0 + ((ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r3, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin")).bottomMargin;
    }

    public View a() {
        a r0 = this.k;
        if (r0 != null) goto L6;
        return null;
    L6:
        return r0.a();
    }

    public void a(int r2) {
        com.google.android.material.snackbar.b.a().a(this.c, r2);
    }

    public void b() {
        a(3);
    }

    final void b(int r2) {
        if (k() == true) goto L5;
    L7:
        c(r2);
        return;
    L5:
        if (this.f4080b.getVisibility() != 0) goto L7;
        d(r2);
    }

    void c(int r5) {
        com.google.android.material.snackbar.b.a().a(this.c);
        List<b<B>> r0 = this.t;
        if (r0 == null) goto L7;
        int r1 = r0.size() - 1;
    L5:
        if (r1 < 0) goto L7;
        ((b) ZeusTransformUtils.preCheckCast(this.t.get(r1), b.class, "com.obric.memorydata.plugin")).a(this, r5);
        r1 = r1 - 1;
    L7:
        ViewParent r6 = this.f4080b.getParent();
        if (ZeusTransformUtils.instanceOf(r6, ViewGroup.class) == false) goto L12;
        ((ViewGroup) ZeusTransformUtils.preCheckCast(r6, ViewGroup.class, "com.obric.memorydata.plugin")).removeView(this.f4080b);
        return;
    }

    public boolean c() {
        return com.google.android.material.snackbar.b.a().e(this.c);
    }

    public SwipeDismissBehavior<? extends View> d() {
        return new Behavior();
    }

    final void e() {
        if (this.f4080b.getParent() != null) goto L9;
        ViewGroup.LayoutParams r0 = this.f4080b.getLayoutParams();
        if (ZeusTransformUtils.instanceOf(r0, CoordinatorLayout.LayoutParams.class) == false) goto L7;
        a((CoordinatorLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r0, CoordinatorLayout.LayoutParams.class, "com.obric.memorydata.plugin"));
    L7:
        this.f4080b.a(this.g);
        q();
        this.f4080b.setVisibility(4);
    L9:
        if (ViewCompat.isLaidOut(this.f4080b) == false) goto L12;
        p();
        return;
    L12:
        this.s = true;
    }

    void f() {
        if (Build.VERSION.SDK_INT < 29) goto L8;
        WindowInsets r0 = this.f4080b.getRootWindowInsets();
        if (r0 == null) goto L9;
        this.q = r0.getMandatorySystemGestureInsets().bottom;
        m();
        return;
    L9:
        return;
    }

    void g() {
        if (c() == false) goto L6;
        f4079a.post(new AnonymousClass11(this));
        return;
    }

    public Context getContext() {
        return this.h;
    }

    void h() {
        if (this.s == false) goto L6;
        p();
        this.s = false;
        return;
    }

    void i() {
        this.f4080b.post(new AnonymousClass13(this));
    }

    void j() {
        com.google.android.material.snackbar.b.a().b(this.c);
        List<b<B>> r0 = this.t;
        if (r0 == null) goto L7;
        int r1 = r0.size() - 1;
    L5:
        if (r1 < 0) goto L9;
        ((b) ZeusTransformUtils.preCheckCast(this.t.get(r1), b.class, "com.obric.memorydata.plugin")).a(this);
        r1 = r1 - 1;
        goto L5
    L9:
        return;
    }

    boolean k() {
        AccessibilityManager r1 = this.v;
        if (r1 != null) goto L5;
        return true;
    L5:
        List<AccessibilityServiceInfo> r2 = r1.getEnabledAccessibilityServiceList(1);
        if (r2 != null) goto L8;
    L10:
        return false;
    L8:
        if (r2.isEmpty() == false) goto L10;
        return true;
    }
}
