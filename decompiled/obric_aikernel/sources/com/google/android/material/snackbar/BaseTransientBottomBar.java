package com.google.android.material.snackbar;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
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
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityManager;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.behavior.SwipeDismissBehavior;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class BaseTransientBottomBar<B extends BaseTransientBottomBar<B>> {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @NonNull
    static final Handler f3755p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final boolean f3756q = false;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final String f3757r = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    private final ViewGroup f3758a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    protected final o f3759b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    private final com.google.android.material.snackbar.a f3760c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f3761d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @RequiresApi(29)
    private final Runnable f3762e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f3763f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f3764g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f3765h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f3766i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f3767j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f3768k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private List<m<B>> f3769l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private Behavior f3770m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @Nullable
    private final AccessibilityManager f3771n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @NonNull
    com.google.android.material.snackbar.b.InterfaceC0085b f3772o;

    /* JADX INFO: renamed from: com.google.android.material.snackbar.BaseTransientBottomBar$3, reason: invalid class name */
    class AnonymousClass3 implements OnApplyWindowInsetsListener {
        final /* synthetic */ BaseTransientBottomBar this$0;

        AnonymousClass3(BaseTransientBottomBar r10) {
            this.this$0 = r10;
        }

        @Override // androidx.core.view.OnApplyWindowInsetsListener
        @NonNull
        public WindowInsetsCompat onApplyWindowInsets(View r10, @NonNull WindowInsetsCompat r11) {
            BaseTransientBottomBar.e(this.this$0, r11.getSystemWindowInsetBottom());
            BaseTransientBottomBar.f(this.this$0, r11.getSystemWindowInsetLeft());
            BaseTransientBottomBar.g(this.this$0, r11.getSystemWindowInsetRight());
            BaseTransientBottomBar.h(this.this$0);
            return r11;
        }
    }

    /* JADX INFO: renamed from: com.google.android.material.snackbar.BaseTransientBottomBar$4, reason: invalid class name */
    class AnonymousClass4 extends AccessibilityDelegateCompat {
        final /* synthetic */ BaseTransientBottomBar this$0;

        AnonymousClass4(BaseTransientBottomBar r10) {
            this.this$0 = r10;
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View r10, @NonNull AccessibilityNodeInfoCompat r11) {
            super.onInitializeAccessibilityNodeInfo(r10, r11);
            r11.addAction(1048576);
            r11.setDismissable(true);
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public boolean performAccessibilityAction(View r10, int r11, Bundle r12) {
            if (r11 != 1048576) goto L7;
            this.this$0.l();
            return true;
        L7:
            return super.performAccessibilityAction(r10, r11, r12);
        }
    }

    public static class Behavior extends SwipeDismissBehavior<View> {

        @NonNull
        private final n delegate;

        public Behavior() {
            this.delegate = new n(this);
        }

        static /* synthetic */ void access$1100(Behavior r10, BaseTransientBottomBar r11) {
            r10.setBaseTransientBottomBar(r11);
        }

        private void setBaseTransientBottomBar(@NonNull BaseTransientBottomBar<?> r10) {
            this.delegate.c(r10);
        }

        @Override // com.google.android.material.behavior.SwipeDismissBehavior
        public boolean canSwipeDismissView(View r10) {
            return this.delegate.a(r10);
        }

        @Override // com.google.android.material.behavior.SwipeDismissBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean onInterceptTouchEvent(@NonNull CoordinatorLayout r10, @NonNull View r11, @NonNull MotionEvent r12) {
            this.delegate.b(r10, r11, r12);
            return super.onInterceptTouchEvent(r10, r11, r12);
        }
    }

    class a extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f3773c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ BaseTransientBottomBar f3774g;

        a(BaseTransientBottomBar r10, int r11) {
            this.f3774g = r10;
            this.f3773c = r11;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator r10) {
            this.f3774g.y(this.f3773c);
        }
    }

    class b implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ BaseTransientBottomBar f3775c;

        b(BaseTransientBottomBar r10) {
            this.f3775c = r10;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(@NonNull ValueAnimator r10) {
            this.f3775c.f3759b.setAlpha(((Float) r10.getAnimatedValue()).floatValue());
        }
    }

    class c implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ BaseTransientBottomBar f3776c;

        c(BaseTransientBottomBar r10) {
            this.f3776c = r10;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(@NonNull ValueAnimator r10) {
            float r11 = ((Float) r10.getAnimatedValue()).floatValue();
            this.f3776c.f3759b.setScaleX(r11);
            this.f3776c.f3759b.setScaleY(r11);
        }
    }

    class d extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ BaseTransientBottomBar f3777c;

        d(BaseTransientBottomBar r10) {
            this.f3777c = r10;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator r10) {
            this.f3777c.z();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator r10) {
            BaseTransientBottomBar.c(this.f3777c).a(70, 180);
        }
    }

    class e implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f3778c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ int f3779g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ BaseTransientBottomBar f3780h;

        e(BaseTransientBottomBar r10, int r11) {
            this.f3780h = r10;
            this.f3779g = r11;
            this.f3778c = r11;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(@NonNull ValueAnimator r10) {
            int r11 = ((Integer) r10.getAnimatedValue()).intValue();
            if (BaseTransientBottomBar.d() == false) goto L5;
            ViewCompat.offsetTopAndBottom(this.f3780h.f3759b, r11 - this.f3778c);
        L6:
            this.f3778c = r11;
            return;
        L5:
            this.f3780h.f3759b.setTranslationY(r11);
            goto L6
        }
    }

    class f extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f3781c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ BaseTransientBottomBar f3782g;

        f(BaseTransientBottomBar r10, int r11) {
            this.f3782g = r10;
            this.f3781c = r11;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator r10) {
            this.f3782g.y(this.f3781c);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator r10) {
            BaseTransientBottomBar.c(this.f3782g).b(0, 180);
        }
    }

    class g implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f3783c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ BaseTransientBottomBar f3784g;

        g(BaseTransientBottomBar r10) {
            this.f3784g = r10;
            this.f3783c = 0;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(@NonNull ValueAnimator r10) {
            int r11 = ((Integer) r10.getAnimatedValue()).intValue();
            if (BaseTransientBottomBar.d() == false) goto L5;
            ViewCompat.offsetTopAndBottom(this.f3784g.f3759b, r11 - this.f3783c);
        L6:
            this.f3783c = r11;
            return;
        L5:
            this.f3784g.f3759b.setTranslationY(r11);
            goto L6
        }
    }

    class h implements Handler.Callback {
        h() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(@NonNull Message r10) {
            int r11 = r10.what;
            if (r11 == 0) goto L9;
            if (r11 == 1) goto L7;
            return false;
        L7:
            ((BaseTransientBottomBar) r10.obj).s(r10.arg1);
            return true;
        L9:
            ((BaseTransientBottomBar) r10.obj).E();
            return true;
        }
    }

    class i implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ BaseTransientBottomBar f3785c;

        i(BaseTransientBottomBar r10) {
            this.f3785c = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f3785c.y(3);
        }
    }

    class j implements SwipeDismissBehavior.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ BaseTransientBottomBar f3786a;

        j(BaseTransientBottomBar r10) {
            this.f3786a = r10;
        }

        @Override // com.google.android.material.behavior.SwipeDismissBehavior.a
        public void a(@NonNull View r10) {
            if (r10.getParent() == null) goto L5;
            r10.setVisibility(8);
        L5:
            this.f3786a.m(0);
        }

        @Override // com.google.android.material.behavior.SwipeDismissBehavior.a
        public void b(int r10) {
            if (r10 != 0) goto L4;
            com.google.android.material.snackbar.b.c().k(this.f3786a.f3772o);
            return;
        L4:
            if (r10 != 1) goto L6;
        L8:
            com.google.android.material.snackbar.b.c().j(this.f3786a.f3772o);
            return;
        L6:
            if (r10 == 2) goto L8;
        }
    }

    class k implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ BaseTransientBottomBar f3787c;

        k(BaseTransientBottomBar r10) {
            this.f3787c = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            o r10 = this.f3787c.f3759b;
            if (r10 != null) goto L6;
            return;
        L6:
            if (r10.getParent() == null) goto L8;
            this.f3787c.f3759b.setVisibility(0);
        L8:
            int r11 = this.f3787c.f3759b.getAnimationMode();
            BaseTransientBottomBar r12 = this.f3787c;
            if (r11 != 1) goto L11;
            BaseTransientBottomBar.a(r12);
            return;
        L11:
            BaseTransientBottomBar.b(r12);
        }
    }

    class l extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ BaseTransientBottomBar f3788c;

        l(BaseTransientBottomBar r10) {
            this.f3788c = r10;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator r10) {
            this.f3788c.z();
        }
    }

    public static abstract class m<B> {
        public m() {
        }

        public void a(B r10, int r11) {
        }

        public void b(B r10) {
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static class n {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private com.google.android.material.snackbar.b.InterfaceC0085b f3789a;

        public n(@NonNull SwipeDismissBehavior<?> r10) {
            r10.setStartAlphaSwipeDistance(0.1f);
            r10.setEndAlphaSwipeDistance(0.6f);
            r10.setSwipeDirection(0);
        }

        public boolean a(View r10) {
            return r10 instanceof o;
        }

        public void b(@NonNull CoordinatorLayout r10, @NonNull View r11, @NonNull MotionEvent r12) {
            int r13 = r12.getActionMasked();
            if (r13 == 0) goto L11;
            if (r13 != 1) goto L7;
        L9:
            com.google.android.material.snackbar.b.c().k(this.f3789a);
            return;
        L7:
            if (r13 == 3) goto L9;
            return;
        L11:
            if (r10.isPointInChildBounds(r11, (int) r12.getX(), (int) r12.getY()) == false) goto L15;
            com.google.android.material.snackbar.b.c().j(this.f3789a);
            return;
        }

        public void c(@NonNull BaseTransientBottomBar<?> r10) {
            this.f3789a = r10.f3772o;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected static class o extends FrameLayout {

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private static final View.OnTouchListener f3790p = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @Nullable
        private BaseTransientBottomBar<?> f3791c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f3792g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final float f3793h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private final float f3794i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private final int f3795j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private final int f3796k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private ColorStateList f3797l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private PorterDuff.Mode f3798m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        @Nullable
        private Rect f3799n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private boolean f3800o;

        class a implements View.OnTouchListener {
            a() {
            }

            @Override // android.view.View.OnTouchListener
            @SuppressLint({"ClickableViewAccessibility"})
            public boolean onTouch(View r10, MotionEvent r11) {
                return true;
            }
        }

        static {
            f3790p = new a();
        }

        protected o(@NonNull Context r10) {
            this(r10, null);
        }

        protected o(@NonNull Context r10, AttributeSet r11) {
            super(b6.a.c(r10, r11, 0, 0), r11);
            Context r12 = getContext();
            TypedArray r13 = r12.obtainStyledAttributes(r11, q5.l.SnackbarLayout);
            int r14 = q5.l.SnackbarLayout_elevation;
            if (r13.hasValue(r14) == false) goto L5;
            ViewCompat.setElevation(this, r13.getDimensionPixelSize(r14, 0));
        L5:
            this.f3792g = r13.getInt(q5.l.SnackbarLayout_animationMode, 0);
            this.f3793h = r13.getFloat(q5.l.SnackbarLayout_backgroundOverlayColorAlpha, 1.0f);
            setBackgroundTintList(com.google.android.material.resources.c.a(r12, r13, q5.l.SnackbarLayout_backgroundTint));
            setBackgroundTintMode(ViewUtils.j(r13.getInt(q5.l.SnackbarLayout_backgroundTintMode, -1), PorterDuff.Mode.SRC_IN));
            this.f3794i = r13.getFloat(q5.l.SnackbarLayout_actionTextColorAlpha, 1.0f);
            this.f3795j = r13.getDimensionPixelSize(q5.l.SnackbarLayout_android_maxWidth, -1);
            this.f3796k = r13.getDimensionPixelSize(q5.l.SnackbarLayout_maxActionInlineWidth, -1);
            r13.recycle();
            setOnTouchListener(f3790p);
            setFocusable(true);
            if (getBackground() != null) goto L9;
            ViewCompat.setBackground(this, c());
            return;
        }

        static /* synthetic */ Rect a(o r10) {
            return r10.f3799n;
        }

        @NonNull
        private Drawable c() {
            float r10 = getResources().getDimension(q5.d.mtrl_snackbar_background_corner_radius);
            GradientDrawable r11 = new GradientDrawable();
            r11.setShape(0);
            r11.setCornerRadius(r10);
            r11.setColor(t5.a.i(this, q5.b.colorSurface, q5.b.colorOnSurface, getBackgroundOverlayColorAlpha()));
            if (this.f3797l == null) goto L7;
            Drawable r12 = DrawableCompat.wrap(r11);
            DrawableCompat.setTintList(r12, this.f3797l);
            return r12;
        L7:
            return DrawableCompat.wrap(r11);
        }

        private void d(ViewGroup.MarginLayoutParams r10) {
            this.f3799n = new Rect(r10.leftMargin, r10.topMargin, r10.rightMargin, r10.bottomMargin);
        }

        private void setBaseTransientBottomBar(BaseTransientBottomBar<?> r10) {
            this.f3791c = r10;
        }

        void b(ViewGroup r10) {
            this.f3800o = true;
            r10.addView(this);
            this.f3800o = false;
        }

        float getActionTextColorAlpha() {
            return this.f3794i;
        }

        int getAnimationMode() {
            return this.f3792g;
        }

        float getBackgroundOverlayColorAlpha() {
            return this.f3793h;
        }

        int getMaxInlineActionWidth() {
            return this.f3796k;
        }

        int getMaxWidth() {
            return this.f3795j;
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onAttachedToWindow() {
            super.onAttachedToWindow();
            BaseTransientBottomBar<?> r10 = this.f3791c;
            if (r10 == null) goto L5;
            r10.v();
        L5:
            ViewCompat.requestApplyInsets(this);
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onDetachedFromWindow() {
            super.onDetachedFromWindow();
            BaseTransientBottomBar<?> r10 = this.f3791c;
            if (r10 == null) goto L6;
            r10.w();
            return;
        }

        @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
        protected void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
            super.onLayout(r10, r11, r12, r13, r14);
            BaseTransientBottomBar<?> r15 = this.f3791c;
            if (r15 == null) goto L6;
            r15.x();
            return;
        }

        @Override // android.widget.FrameLayout, android.view.View
        protected void onMeasure(int r10, int r11) {
            super.onMeasure(r10, r11);
            if (this.f3795j <= 0) goto L8;
            int r12 = getMeasuredWidth();
            int r13 = this.f3795j;
            if (r12 <= r13) goto L9;
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(r13, 1073741824), r11);
            return;
        L9:
            return;
        }

        void setAnimationMode(int r10) {
            this.f3792g = r10;
        }

        @Override // android.view.View
        public void setBackground(@Nullable Drawable r10) {
            setBackgroundDrawable(r10);
        }

        @Override // android.view.View
        public void setBackgroundDrawable(@Nullable Drawable r10) {
            if (r10 != null) goto L4;
        L6:
            super.setBackgroundDrawable(r10);
            return;
        L4:
            if (this.f3797l == null) goto L6;
            r10 = DrawableCompat.wrap(r10.mutate());
            DrawableCompat.setTintList(r10, this.f3797l);
            DrawableCompat.setTintMode(r10, this.f3798m);
            goto L6
        }

        @Override // android.view.View
        public void setBackgroundTintList(@Nullable ColorStateList r10) {
            this.f3797l = r10;
            if (getBackground() == null) goto L8;
            Drawable r11 = DrawableCompat.wrap(getBackground().mutate());
            DrawableCompat.setTintList(r11, r10);
            DrawableCompat.setTintMode(r11, this.f3798m);
            if (r11 == getBackground()) goto L9;
            super.setBackgroundDrawable(r11);
            return;
        L9:
            return;
        }

        @Override // android.view.View
        public void setBackgroundTintMode(@Nullable PorterDuff.Mode r10) {
            this.f3798m = r10;
            if (getBackground() == null) goto L8;
            Drawable r11 = DrawableCompat.wrap(getBackground().mutate());
            DrawableCompat.setTintMode(r11, r10);
            if (r11 == getBackground()) goto L9;
            super.setBackgroundDrawable(r11);
            return;
        L9:
            return;
        }

        @Override // android.view.View
        public void setLayoutParams(ViewGroup.LayoutParams r10) {
            super.setLayoutParams(r10);
            if (this.f3800o == false) goto L5;
            return;
        L5:
            if ((r10 instanceof ViewGroup.MarginLayoutParams) == false) goto L11;
            d((ViewGroup.MarginLayoutParams) r10);
            BaseTransientBottomBar<?> r11 = this.f3791c;
            if (r11 == null) goto L12;
            BaseTransientBottomBar.h(r11);
            return;
        L12:
            return;
        }

        @Override // android.view.View
        public void setOnClickListener(@Nullable View.OnClickListener r10) {
            if (r10 == null) goto L4;
            View.OnTouchListener r11 = null;
        L5:
            setOnTouchListener(r11);
            super.setOnClickListener(r10);
            return;
        L4:
            r11 = f3790p;
            goto L5
        }
    }

    static {
        int r10 = Build.VERSION.SDK_INT;
        if (r10 >= 16) goto L5;
    L7:
        boolean r11 = false;
    L8:
        f3756q = r11;
        f3757r = BaseTransientBottomBar.class.getSimpleName();
        f3755p = new Handler(Looper.getMainLooper(), new h());
        return;
    L5:
        if (r10 > 19) goto L7;
        r11 = true;
        goto L8
    }

    private void A() {
        this.f3767j = k();
        K();
    }

    private void B(CoordinatorLayout.LayoutParams r10) {
        SwipeDismissBehavior<? extends View> r11 = this.f3770m;
        if (r11 != null) goto L6;
        r11 = p();
    L6:
        if ((r11 instanceof Behavior) == false) goto L8;
        Behavior.access$1100((Behavior) r11, this);
    L8:
        r11.setListener(new j(this));
        r10.setBehavior(r11);
        if (o() != null) goto L12;
        r10.insetEdge = 80;
        return;
    }

    private boolean D() {
        if (this.f3766i > 0) goto L5;
    L9:
        return false;
    L5:
        if (this.f3761d == true) goto L9;
        if (u() == false) goto L9;
        return true;
    }

    private void F() {
        if (C() == false) goto L6;
        i();
        return;
    L6:
        if (this.f3759b.getParent() == null) goto L8;
        this.f3759b.setVisibility(0);
    L8:
        z();
    }

    private void G() {
        ValueAnimator r10 = n(new float[]{0.0f, 1.0f});
        ValueAnimator r11 = q(new float[]{0.8f, 1.0f});
        AnimatorSet r12 = new AnimatorSet();
        r12.playTogether(new Animator[]{r10, r11});
        r12.setDuration(150);
        r12.addListener(new l(this));
        r12.start();
    }

    private void H(int r10) {
        ValueAnimator r11 = n(new float[]{1.0f, 0.0f});
        r11.setDuration(75);
        r11.addListener(new a(this, r10));
        r11.start();
    }

    private void I() {
        int r10 = r();
        if (f3756q == false) goto L5;
        ViewCompat.offsetTopAndBottom(this.f3759b, r10);
    L6:
        ValueAnimator r11 = new ValueAnimator();
        r11.setIntValues(new int[]{r10, 0});
        r11.setInterpolator(r5.a.f12674b);
        r11.setDuration(250);
        r11.addListener(new d(this));
        r11.addUpdateListener(new e(this, r10));
        r11.start();
        return;
    L5:
        this.f3759b.setTranslationY(r10);
        goto L6
    }

    private void J(int r10) {
        ValueAnimator r11 = new ValueAnimator();
        r11.setIntValues(new int[]{0, r()});
        r11.setInterpolator(r5.a.f12674b);
        r11.setDuration(250);
        r11.addListener(new f(this, r10));
        r11.addUpdateListener(new g(this));
        r11.start();
    }

    private void K() {
        ViewGroup.LayoutParams r10 = this.f3759b.getLayoutParams();
        if ((r10 instanceof ViewGroup.MarginLayoutParams) == true) goto L5;
    L20:
        Log.w(f3757r, "Unable to update margins because layout params are not MarginLayoutParams");
        return;
    L5:
        if (o.a(this.f3759b) == null) goto L20;
        if (this.f3759b.getParent() != null) goto L11;
        return;
    L11:
        if (o() == null) goto L13;
        int r11 = this.f3767j;
    L14:
        ViewGroup.MarginLayoutParams r12 = (ViewGroup.MarginLayoutParams) r10;
        r12.bottomMargin = o.a(this.f3759b).bottom + r11;
        r12.leftMargin = o.a(this.f3759b).left + this.f3764g;
        r12.rightMargin = o.a(this.f3759b).right + this.f3765h;
        r12.topMargin = o.a(this.f3759b).top;
        this.f3759b.requestLayout();
        if (Build.VERSION.SDK_INT >= 29) goto L17;
        return;
    L17:
        if (D() == false) goto L23;
        this.f3759b.removeCallbacks(this.f3762e);
        this.f3759b.post(this.f3762e);
        return;
    L23:
        return;
    L13:
        r11 = this.f3763f;
        goto L14
    }

    static /* synthetic */ void a(BaseTransientBottomBar r10) {
        r10.G();
    }

    static /* synthetic */ void b(BaseTransientBottomBar r10) {
        r10.I();
    }

    static /* synthetic */ com.google.android.material.snackbar.a c(BaseTransientBottomBar r10) {
        return r10.f3760c;
    }

    static /* synthetic */ boolean d() {
        return f3756q;
    }

    static /* synthetic */ int e(BaseTransientBottomBar r10, int r11) {
        r10.f3763f = r11;
        return r11;
    }

    static /* synthetic */ int f(BaseTransientBottomBar r10, int r11) {
        r10.f3764g = r11;
        return r11;
    }

    static /* synthetic */ int g(BaseTransientBottomBar r10, int r11) {
        r10.f3765h = r11;
        return r11;
    }

    static /* synthetic */ void h(BaseTransientBottomBar r10) {
        r10.K();
    }

    private void j(int r10) {
        if (this.f3759b.getAnimationMode() != 1) goto L5;
        H(r10);
        return;
    L5:
        J(r10);
    }

    private int k() {
        if (o() != null) goto L6;
        return 0;
    L6:
        int[] r10 = new int[2];
        o().getLocationOnScreen(r10);
        int r11 = r10[1];
        int[] r12 = new int[2];
        this.f3758a.getLocationOnScreen(r12);
        return (r12[1] + this.f3758a.getHeight()) - r11;
    }

    private ValueAnimator n(float... r10) {
        ValueAnimator r11 = ValueAnimator.ofFloat(r10);
        r11.setInterpolator(r5.a.f12673a);
        r11.addUpdateListener(new b(this));
        return r11;
    }

    private ValueAnimator q(float... r10) {
        ValueAnimator r11 = ValueAnimator.ofFloat(r10);
        r11.setInterpolator(r5.a.f12676d);
        r11.addUpdateListener(new c(this));
        return r11;
    }

    private int r() {
        int r10 = this.f3759b.getHeight();
        ViewGroup.LayoutParams r11 = this.f3759b.getLayoutParams();
        if ((r11 instanceof ViewGroup.MarginLayoutParams) == true) goto L5;
        return r10;
    L5:
        return r10 + ((ViewGroup.MarginLayoutParams) r11).bottomMargin;
    }

    private boolean u() {
        ViewGroup.LayoutParams r10 = this.f3759b.getLayoutParams();
        if ((r10 instanceof CoordinatorLayout.LayoutParams) == true) goto L5;
    L7:
        return false;
    L5:
        if ((((CoordinatorLayout.LayoutParams) r10).getBehavior() instanceof SwipeDismissBehavior) == false) goto L7;
        return true;
    }

    boolean C() {
        AccessibilityManager r10 = this.f3771n;
        if (r10 != null) goto L5;
        return true;
    L5:
        List<AccessibilityServiceInfo> r11 = r10.getEnabledAccessibilityServiceList(1);
        if (r11 != null) goto L8;
    L10:
        return false;
    L8:
        if (r11.isEmpty() == false) goto L10;
        return true;
    }

    final void E() {
        if (this.f3759b.getParent() != null) goto L9;
        ViewGroup.LayoutParams r10 = this.f3759b.getLayoutParams();
        if ((r10 instanceof CoordinatorLayout.LayoutParams) == false) goto L7;
        B((CoordinatorLayout.LayoutParams) r10);
    L7:
        this.f3759b.b(this.f3758a);
        A();
        this.f3759b.setVisibility(4);
    L9:
        if (ViewCompat.isLaidOut(this.f3759b) == false) goto L12;
        F();
        return;
    L12:
        this.f3768k = true;
    }

    void i() {
        this.f3759b.post(new k(this));
    }

    public void l() {
        m(3);
    }

    protected void m(int r10) {
        com.google.android.material.snackbar.b.c().b(this.f3772o, r10);
    }

    @Nullable
    public View o() {
        return null;
    }

    @NonNull
    protected SwipeDismissBehavior<? extends View> p() {
        return new Behavior();
    }

    final void s(int r10) {
        if (C() == true) goto L5;
    L7:
        y(r10);
        return;
    L5:
        if (this.f3759b.getVisibility() != 0) goto L7;
        j(r10);
    }

    public boolean t() {
        return com.google.android.material.snackbar.b.c().e(this.f3772o);
    }

    void v() {
        if (Build.VERSION.SDK_INT < 29) goto L8;
        WindowInsets r10 = this.f3759b.getRootWindowInsets();
        if (r10 == null) goto L9;
        this.f3766i = r10.getMandatorySystemGestureInsets().bottom;
        K();
        return;
    L9:
        return;
    }

    void w() {
        if (t() == false) goto L6;
        f3755p.post(new i(this));
        return;
    }

    void x() {
        if (this.f3768k == false) goto L6;
        F();
        this.f3768k = false;
        return;
    }

    void y(int r10) {
        com.google.android.material.snackbar.b.c().h(this.f3772o);
        List<m<B>> r11 = this.f3769l;
        if (r11 == null) goto L7;
        int r12 = r11.size() - 1;
    L5:
        if (r12 < 0) goto L7;
        this.f3769l.get(r12).a(this, r10);
        r12 = r12 - 1;
    L7:
        ViewParent r13 = this.f3759b.getParent();
        if ((r13 instanceof ViewGroup) == false) goto L12;
        ((ViewGroup) r13).removeView(this.f3759b);
        return;
    }

    void z() {
        com.google.android.material.snackbar.b.c().i(this.f3772o);
        List<m<B>> r10 = this.f3769l;
        if (r10 == null) goto L7;
        int r11 = r10.size() - 1;
    L5:
        if (r11 < 0) goto L9;
        this.f3769l.get(r11).b(this);
        r11 = r11 - 1;
        goto L5
    L9:
        return;
    }
}
