package com.google.android.material.tabs;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.text.Layout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.BoolRes;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.Dimension;
import androidx.annotation.DrawableRes;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.TooltipCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.util.Pools;
import androidx.core.view.GravityCompat;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.PointerIconCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.widget.TextViewCompat;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.shape.MaterialShapeDrawable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import q5.j;
import q5.k;
import q5.l;

/* JADX INFO: loaded from: classes.dex */
@ViewPager.DecorView
public class TabLayout extends HorizontalScrollView {
    private static final int W = 0;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    private static final Pools.Pool<f> f3816a0 = null;
    private int A;
    int B;
    int C;
    int D;
    int E;
    boolean F;
    boolean G;
    int H;
    int I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    boolean f3817J;
    private com.google.android.material.tabs.c K;

    @Nullable
    private b L;
    private final ArrayList<b> M;

    @Nullable
    private b N;
    private ValueAnimator O;

    @Nullable
    ViewPager P;

    @Nullable
    private PagerAdapter Q;
    private DataSetObserver R;
    private TabLayoutOnPageChangeListener S;
    private AdapterChangeListener T;
    private boolean U;
    private final Pools.Pool<g> V;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ArrayList<f> f3818c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    private f f3819g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NonNull
    final e f3820h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    int f3821i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    int f3822j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    int f3823k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    int f3824l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    int f3825m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    ColorStateList f3826n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    ColorStateList f3827o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    ColorStateList f3828p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @NonNull
    Drawable f3829q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int f3830r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    PorterDuff.Mode f3831s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    float f3832t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    float f3833u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    final int f3834v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    int f3835w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final int f3836x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private final int f3837y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private final int f3838z;

    private class AdapterChangeListener implements ViewPager.OnAdapterChangeListener {
        private boolean autoRefresh;
        final /* synthetic */ TabLayout this$0;

        AdapterChangeListener(TabLayout r10) {
            this.this$0 = r10;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnAdapterChangeListener
        public void onAdapterChanged(@NonNull ViewPager r10, @Nullable PagerAdapter r11, @Nullable PagerAdapter r12) {
            TabLayout r13 = this.this$0;
            if (r13.P != r10) goto L6;
            r13.H(r12, this.autoRefresh);
            return;
        }

        void setAutoRefresh(boolean r10) {
            this.autoRefresh = r10;
        }
    }

    public static class TabLayoutOnPageChangeListener implements ViewPager.OnPageChangeListener {
        private int previousScrollState;
        private int scrollState;

        @NonNull
        private final WeakReference<TabLayout> tabLayoutRef;

        public TabLayoutOnPageChangeListener(TabLayout r10) {
            this.tabLayoutRef = new WeakReference(r10);
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int r10) {
            this.previousScrollState = this.scrollState;
            this.scrollState = r10;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int r10, float r11, int r12) {
            TabLayout r13 = this.tabLayoutRef.get();
            if (r13 == null) goto L17;
            int r14 = this.scrollState;
            boolean r15 = false;
            if (r14 == 2) goto L7;
        L10:
            boolean r16 = true;
        L11:
            if (r14 == 2) goto L13;
        L14:
            r15 = true;
        L15:
            r13.J(r10, r11, r16, r15);
            return;
        L13:
            if (this.previousScrollState == 0) goto L15;
        L7:
            if (this.previousScrollState == 1) goto L10;
            r16 = false;
            goto L11
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int r10) {
            TabLayout r11 = this.tabLayoutRef.get();
            if (r11 != null) goto L5;
            return;
        L5:
            if (r11.getSelectedTabPosition() != r10) goto L7;
            return;
        L7:
            if (r10 >= r11.getTabCount()) goto L21;
            int r12 = this.scrollState;
            if (r12 != 0) goto L11;
        L16:
            boolean r13 = true;
        L17:
            r11.G(r11.w(r10), r13);
            return;
        L11:
            if (r12 == 2) goto L13;
        L15:
            r13 = false;
            goto L17
        L13:
            if (this.previousScrollState != 0) goto L15;
        }

        void reset() {
            this.scrollState = 0;
            this.previousScrollState = 0;
        }
    }

    class a implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ TabLayout f3839c;

        a(TabLayout r10) {
            this.f3839c = r10;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(@NonNull ValueAnimator r10) {
            this.f3839c.scrollTo(((Integer) r10.getAnimatedValue()).intValue(), 0);
        }
    }

    @Deprecated
    public interface b<T extends f> {
        void a(T r10);

        void b(T r10);

        void c(T r10);
    }

    public interface c extends b<f> {
    }

    private class d extends DataSetObserver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ TabLayout f3840a;

        d(TabLayout r10) {
            this.f3840a = r10;
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            this.f3840a.A();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            this.f3840a.A();
        }
    }

    class e extends LinearLayout {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        ValueAnimator f3841c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        int f3842g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        float f3843h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private int f3844i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ TabLayout f3845j;

        class a implements ValueAnimator.AnimatorUpdateListener {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ View f3846c;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ View f3847g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            final /* synthetic */ e f3848h;

            a(e r10, View r11, View r12) {
                this.f3848h = r10;
                this.f3846c = r11;
                this.f3847g = r12;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(@NonNull ValueAnimator r10) {
                e.b(this.f3848h, this.f3846c, this.f3847g, r10.getAnimatedFraction());
            }
        }

        class b extends AnimatorListenerAdapter {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ int f3849c;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ e f3850g;

            b(e r10, int r11) {
                this.f3850g = r10;
                this.f3849c = r11;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator r10) {
                e r11 = this.f3850g;
                r11.f3842g = this.f3849c;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator r10) {
                e r11 = this.f3850g;
                r11.f3842g = this.f3849c;
            }
        }

        e(TabLayout r10, Context r11) {
            this.f3845j = r10;
            super(r11);
            this.f3842g = -1;
            this.f3844i = -1;
            setWillNotDraw(false);
        }

        static /* synthetic */ void a(e r10) {
            r10.e();
        }

        static /* synthetic */ void b(e r10, View r11, View r12, float r13) {
            r10.h(r11, r12, r13);
        }

        private void e() {
            View r10 = getChildAt(this.f3842g);
            com.google.android.material.tabs.c r11 = TabLayout.a(this.f3845j);
            TabLayout r12 = this.f3845j;
            r11.c(r12, r10, r12.f3829q);
        }

        private void h(View r10, View r11, float r12) {
            if (r10 != null) goto L4;
        L6:
            boolean r13 = false;
        L7:
            if (r13 == false) goto L9;
            com.google.android.material.tabs.c r14 = TabLayout.a(this.f3845j);
            TabLayout r15 = this.f3845j;
            r14.d(r15, r10, r11, r12, r15.f3829q);
        L10:
            ViewCompat.postInvalidateOnAnimation(this);
            return;
        L9:
            Drawable r16 = this.f3845j.f3829q;
            r16.setBounds(-1, r16.getBounds().top, -1, this.f3845j.f3829q.getBounds().bottom);
            goto L10
        L4:
            if (r10.getWidth() <= 0) goto L6;
            r13 = true;
            goto L7
        }

        private void i(boolean r10, int r11, int r12) {
            View r13 = getChildAt(this.f3842g);
            View r14 = getChildAt(r11);
            if (r14 != null) goto L6;
            e();
            return;
        L6:
            a r15 = new a(this, r13, r14);
            if (r10 == false) goto L9;
            ValueAnimator r16 = new ValueAnimator();
            this.f3841c = r16;
            r16.setInterpolator(r5.a.f12674b);
            r16.setDuration(r12);
            r16.setFloatValues(new float[]{0.0f, 1.0f});
            r16.addUpdateListener(r15);
            r16.addListener(new b(this, r11));
            r16.start();
            return;
        L9:
            this.f3841c.removeAllUpdateListeners();
            this.f3841c.addUpdateListener(r15);
        }

        void c(int r10, int r11) {
            ValueAnimator r12 = this.f3841c;
            if (r12 != null) goto L5;
        L7:
            i(true, r10, r11);
            return;
        L5:
            if (r12.isRunning() == false) goto L7;
            this.f3841c.cancel();
            goto L7
        }

        boolean d() {
            int r10 = getChildCount();
            int r11 = 0;
        L3:
            if (r11 >= r10) goto L9;
            if (getChildAt(r11).getWidth() <= 0) goto L6;
            r11 = r11 + 1;
            goto L3
        L6:
            return true;
        L9:
            return false;
        }

        @Override // android.view.View
        public void draw(@NonNull Canvas r10) {
            int r11 = this.f3845j.f3829q.getBounds().height();
            if (r11 >= 0) goto L5;
            r11 = this.f3845j.f3829q.getIntrinsicHeight();
        L5:
            int r12 = this.f3845j.D;
            int r13 = 0;
            if (r12 != 0) goto L8;
            r13 = getHeight() - r11;
        L15:
            r11 = getHeight();
        L17:
            if (this.f3845j.f3829q.getBounds().width() <= 0) goto L29;
            Rect r14 = this.f3845j.f3829q.getBounds();
            this.f3845j.f3829q.setBounds(r14.left, r13, r14.right, r11);
            TabLayout r15 = this.f3845j;
            Drawable r16 = r15.f3829q;
            if (TabLayout.b(r15) == 0) goto L25;
            r16 = DrawableCompat.wrap(r16);
            if (Build.VERSION.SDK_INT != 21) goto L23;
            r16.setColorFilter(TabLayout.b(this.f3845j), PorterDuff.Mode.SRC_IN);
        L28:
            r16.draw(r10);
            goto L29
        L23:
            DrawableCompat.setTint(r16, TabLayout.b(this.f3845j));
            goto L28
        L25:
            if (Build.VERSION.SDK_INT != 21) goto L27;
            r16.setColorFilter(null);
            goto L28
        L27:
            DrawableCompat.setTintList(r16, null);
        L29:
            super.draw(r10);
            return;
        L8:
            if (r12 == 1) goto L13;
            if (r12 == 2) goto L17;
            if (r12 == 3) goto L15;
            r11 = 0;
            goto L17
        L13:
            r13 = (getHeight() - r11) / 2;
            r11 = (getHeight() + r11) / 2;
            goto L17
        }

        void f(int r10, float r11) {
            ValueAnimator r12 = this.f3841c;
            if (r12 != null) goto L5;
        L7:
            this.f3842g = r10;
            this.f3843h = r11;
            h(getChildAt(r10), getChildAt(this.f3842g + 1), this.f3843h);
            return;
        L5:
            if (r12.isRunning() == false) goto L7;
            this.f3841c.cancel();
            goto L7
        }

        void g(int r10) {
            Rect r11 = this.f3845j.f3829q.getBounds();
            this.f3845j.f3829q.setBounds(r11.left, 0, r11.right, r10);
            requestLayout();
        }

        @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
        protected void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
            super.onLayout(r10, r11, r12, r13, r14);
            ValueAnimator r15 = this.f3841c;
            if (r15 != null) goto L5;
        L7:
            e();
            return;
        L5:
            if (r15.isRunning() == false) goto L7;
            i(false, this.f3842g, -1);
        }

        @Override // android.widget.LinearLayout, android.view.View
        protected void onMeasure(int r10, int r11) {
            super.onMeasure(r10, r11);
            if (View.MeasureSpec.getMode(r10) == 1073741824) goto L5;
            return;
        L5:
            TabLayout r12 = this.f3845j;
            boolean r13 = true;
            if (r12.B != 1) goto L8;
        L9:
            int r14 = getChildCount();
            int r15 = 0;
            int r16 = 0;
            int r17 = 0;
        L10:
            if (r16 >= r14) goto L15;
            View r18 = getChildAt(r16);
            if (r18.getVisibility() != 0) goto L14;
            r17 = Math.max(r17, r18.getMeasuredWidth());
        L14:
            r16 = r16 + 1;
            goto L10
        L15:
            if (r17 > 0) goto L18;
            return;
        L18:
            if ((r17 * r14) > (getMeasuredWidth() - (((int) ViewUtils.c(getContext(), 16)) * 2))) goto L28;
            boolean r19 = false;
        L20:
            if (r15 >= r14) goto L27;
            LinearLayout.LayoutParams r20 = (LinearLayout.LayoutParams) getChildAt(r15).getLayoutParams();
            if (r20.width == r17) goto L24;
        L25:
            r20.width = r17;
            r20.weight = 0.0f;
            r19 = true;
        L26:
            r15 = r15 + 1;
            goto L20
        L24:
            if (r20.weight == 0.0f) goto L26;
        L27:
            r13 = r19;
        L29:
            if (r13 == false) goto L39;
            super.onMeasure(r10, r11);
            return;
        L39:
            return;
        L28:
            TabLayout r21 = this.f3845j;
            r21.B = 0;
            r21.O(false);
            goto L29
        L8:
            if (r12.E == 2) goto L9;
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onRtlPropertiesChanged(int r10) {
            super.onRtlPropertiesChanged(r10);
            if (Build.VERSION.SDK_INT < 23) goto L5;
            return;
        L5:
            if (this.f3844i == r10) goto L9;
            requestLayout();
            this.f3844i = r10;
            return;
        }
    }

    public static class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        private Drawable f3851a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        private CharSequence f3852b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @Nullable
        private CharSequence f3853c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f3854d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @Nullable
        private View f3855e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f3856f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @Nullable
        public TabLayout f3857g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        @NonNull
        public g f3858h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private int f3859i;

        public f() {
            this.f3854d = -1;
            this.f3856f = 1;
            this.f3859i = -1;
        }

        static /* synthetic */ int a(f r10) {
            return r10.f3859i;
        }

        static /* synthetic */ int b(f r10) {
            return r10.f3856f;
        }

        static /* synthetic */ CharSequence c(f r10) {
            return r10.f3853c;
        }

        static /* synthetic */ CharSequence d(f r10) {
            return r10.f3852b;
        }

        @Nullable
        public View e() {
            return this.f3855e;
        }

        @Nullable
        public Drawable f() {
            return this.f3851a;
        }

        public int g() {
            return this.f3854d;
        }

        public int h() {
            return this.f3856f;
        }

        @Nullable
        public CharSequence i() {
            return this.f3852b;
        }

        public boolean j() {
            TabLayout r10 = this.f3857g;
            if (r10 == null) goto L12;
            int r11 = r10.getSelectedTabPosition();
            if (r11 != (-1)) goto L7;
        L9:
            return false;
        L7:
            if (r11 != this.f3854d) goto L9;
            return true;
        L12:
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }

        void k() {
            this.f3857g = null;
            this.f3858h = null;
            this.f3851a = null;
            this.f3859i = -1;
            this.f3852b = null;
            this.f3853c = null;
            this.f3854d = -1;
            this.f3855e = null;
        }

        public void l() {
            TabLayout r10 = this.f3857g;
            if (r10 == null) goto L7;
            r10.F(this);
            return;
        L7:
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }

        @NonNull
        public f m(@Nullable CharSequence r10) {
            this.f3853c = r10;
            s();
            return this;
        }

        @NonNull
        public f n(@LayoutRes int r10) {
            return o(LayoutInflater.from(this.f3858h.getContext()).inflate(r10, this.f3858h, false));
        }

        @NonNull
        public f o(@Nullable View r10) {
            this.f3855e = r10;
            s();
            return this;
        }

        @NonNull
        public f p(@Nullable Drawable r10) {
            this.f3851a = r10;
            TabLayout r11 = this.f3857g;
            if (r11.B != 1) goto L5;
        L6:
            r11.O(true);
        L7:
            s();
            if (com.google.android.material.badge.b.f3015a == true) goto L10;
        L14:
            return this;
        L10:
            if (g.d(this.f3858h) == false) goto L14;
            if (g.e(this.f3858h).isVisible() == false) goto L14;
            this.f3858h.invalidate();
            goto L14
        L5:
            if (r11.E != 2) goto L7;
            goto L6
        }

        void q(int r10) {
            this.f3854d = r10;
        }

        @NonNull
        public f r(@Nullable CharSequence r10) {
            if (TextUtils.isEmpty(this.f3853c) == true) goto L5;
        L7:
            this.f3852b = r10;
            s();
            return this;
        L5:
            if (TextUtils.isEmpty(r10) == true) goto L7;
            this.f3858h.setContentDescription(r10);
            goto L7
        }

        void s() {
            g r10 = this.f3858h;
            if (r10 == null) goto L6;
            r10.t();
            return;
        }
    }

    public final class g extends LinearLayout {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private f f3860c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private TextView f3861g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private ImageView f3862h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        @Nullable
        private View f3863i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        @Nullable
        private com.google.android.material.badge.a f3864j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        @Nullable
        private View f3865k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        @Nullable
        private TextView f3866l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        @Nullable
        private ImageView f3867m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        @Nullable
        private Drawable f3868n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private int f3869o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        final /* synthetic */ TabLayout f3870p;

        class a implements View.OnLayoutChangeListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ View f3871a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ g f3872b;

            a(g r10, View r11) {
                this.f3872b = r10;
                this.f3871a = r11;
            }

            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(View r10, int r11, int r12, int r13, int r14, int r15, int r16, int r17, int r18) {
                if (this.f3871a.getVisibility() != 0) goto L6;
                g.a(this.f3872b, this.f3871a);
                return;
            }
        }

        public g(@NonNull TabLayout r10, Context r11) {
            this.f3870p = r10;
            super(r11);
            this.f3869o = 2;
            u(r11);
            ViewCompat.setPaddingRelative(this, r10.f3821i, r10.f3822j, r10.f3823k, r10.f3824l);
            setGravity(17);
            setOrientation(!r10.F ? 1 : 0);
            setClickable(true);
            ViewCompat.setPointerIcon(this, PointerIconCompat.getSystemIcon(getContext(), PointerIconCompat.TYPE_HAND));
        }

        static /* synthetic */ void a(g r10, View r11) {
            r10.s(r11);
        }

        static /* synthetic */ void b(g r10, Context r11) {
            r10.u(r11);
        }

        static /* synthetic */ void c(g r10, Canvas r11) {
            r10.j(r11);
        }

        static /* synthetic */ boolean d(g r10) {
            return r10.l();
        }

        static /* synthetic */ com.google.android.material.badge.a e(g r10) {
            return r10.f3864j;
        }

        private void f(@Nullable View r10) {
            if (r10 != null) goto L4;
            return;
        L4:
            r10.addOnLayoutChangeListener(new a(this, r10));
        }

        private float g(@NonNull Layout r10, int r11, float r12) {
            return r10.getLineWidth(r11) * (r12 / r10.getPaint().getTextSize());
        }

        @Nullable
        private com.google.android.material.badge.a getBadge() {
            return this.f3864j;
        }

        @NonNull
        private com.google.android.material.badge.a getOrCreateBadge() {
            if (this.f3864j != null) goto L5;
            this.f3864j = com.google.android.material.badge.a.b(getContext());
        L5:
            r();
            com.google.android.material.badge.a r10 = this.f3864j;
            if (r10 == null) goto L9;
            return r10;
        L9:
            throw new IllegalStateException("Unable to create badge");
        }

        private void h(boolean r10) {
            setClipChildren(r10);
            setClipToPadding(r10);
            ViewGroup r11 = (ViewGroup) getParent();
            if (r11 == null) goto L6;
            r11.setClipChildren(r10);
            r11.setClipToPadding(r10);
            return;
        }

        @NonNull
        private FrameLayout i() {
            FrameLayout r10 = new FrameLayout(getContext());
            r10.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
            return r10;
        }

        private void j(@NonNull Canvas r10) {
            Drawable r11 = this.f3868n;
            if (r11 == null) goto L6;
            r11.setBounds(getLeft(), getTop(), getRight(), getBottom());
            this.f3868n.draw(r10);
            return;
        }

        @Nullable
        private FrameLayout k(@NonNull View r10) {
            if (r10 == this.f3862h) goto L8;
            if (r10 == this.f3861g) goto L8;
            return null;
        L8:
            if (com.google.android.material.badge.b.f3015a == true) goto L10;
            return null;
        L10:
            return (FrameLayout) r10.getParent();
        }

        private boolean l() {
            if (this.f3864j == null) goto L5;
            return true;
        L5:
            return false;
        }

        private void m() {
            if (com.google.android.material.badge.b.f3015a == false) goto L5;
            FrameLayout r10 = i();
            addView(r10, 0);
            ViewGroup r11 = r10;
        L6:
            ImageView r12 = (ImageView) LayoutInflater.from(getContext()).inflate(q5.h.design_layout_tab_icon, r11, false);
            this.f3862h = r12;
            r11.addView(r12, 0);
            return;
        L5:
            r11 = this;
            goto L6
        }

        private void n() {
            if (com.google.android.material.badge.b.f3015a == false) goto L5;
            FrameLayout r10 = i();
            addView(r10);
            ViewGroup r11 = r10;
        L6:
            TextView r12 = (TextView) LayoutInflater.from(getContext()).inflate(q5.h.design_layout_tab_text, r11, false);
            this.f3861g = r12;
            r11.addView(r12);
            return;
        L5:
            r11 = this;
            goto L6
        }

        private void p(@Nullable View r10) {
            if (l() == true) goto L5;
            return;
        L5:
            if (r10 == null) goto L8;
            h(false);
            com.google.android.material.badge.b.a(this.f3864j, r10, k(r10));
            this.f3863i = r10;
            return;
        }

        private void q() {
            if (l() == true) goto L5;
            return;
        L5:
            h(true);
            View r10 = this.f3863i;
            if (r10 == null) goto L9;
            com.google.android.material.badge.b.d(this.f3864j, r10);
            this.f3863i = null;
            return;
        }

        private void r() {
            if (l() == true) goto L6;
            return;
        L6:
            if (this.f3865k == null) goto L9;
        L7:
            q();
            return;
        L9:
            if (this.f3862h == null) goto L20;
            f r10 = this.f3860c;
            if (r10 == null) goto L20;
            if (r10.f() == null) goto L20;
            View r11 = this.f3863i;
            View r12 = this.f3862h;
            if (r11 == r12) goto L18;
            q();
            View r13 = this.f3862h;
        L17:
            p(r13);
            return;
        L18:
            s(r12);
            return;
        L20:
            if (this.f3861g == null) goto L7;
            f r14 = this.f3860c;
            if (r14 == null) goto L7;
            if (r14.h() != 1) goto L7;
            View r15 = this.f3863i;
            r12 = this.f3861g;
            if (r15 == r12) goto L18;
            q();
            r13 = this.f3861g;
            goto L17
        }

        private void s(@NonNull View r10) {
            if (l() == true) goto L5;
            return;
        L5:
            if (r10 != this.f3863i) goto L9;
            com.google.android.material.badge.b.e(this.f3864j, r10, k(r10));
            return;
        }

        private void u(Context r10) {
            int r11 = this.f3870p.f3834v;
            GradientDrawable r12 = null;
            if (r11 == 0) goto L9;
            Drawable r13 = AppCompatResources.getDrawable(r10, r11);
            this.f3868n = r13;
            if (r13 != null) goto L7;
        L10:
            GradientDrawable r14 = new GradientDrawable();
            r14.setColor(0);
            Drawable r15 = r14;
            if (this.f3870p.f3828p == null) goto L22;
            GradientDrawable r16 = new GradientDrawable();
            r16.setCornerRadius(1.0E-5f);
            r16.setColor(-1);
            ColorStateList r17 = com.google.android.material.ripple.a.a(this.f3870p.f3828p);
            if (Build.VERSION.SDK_INT < 21) goto L21;
            boolean r18 = this.f3870p.f3817J;
            GradientDrawable r19 = r14;
            if (r18 == false) goto L17;
            r19 = null;
        L17:
            if (r18 == true) goto L20;
            r12 = r16;
        L20:
            r15 = new RippleDrawable(r17, r19, r12);
            goto L22
        L21:
            Drawable r20 = DrawableCompat.wrap(r16);
            DrawableCompat.setTintList(r20, r17);
            r15 = new LayerDrawable(new Drawable[]{r14, r20});
        L22:
            ViewCompat.setBackground(this, r15);
            this.f3870p.invalidate();
            return;
        L7:
            if (r13.isStateful() == false) goto L10;
            this.f3868n.setState(getDrawableState());
            goto L10
        L9:
            this.f3868n = null;
            goto L10
        }

        private void w(@Nullable TextView r10, @Nullable ImageView r11) {
            f r12 = this.f3860c;
            CharSequence r13 = null;
            if (r12 != null) goto L5;
        L7:
            Drawable r14 = null;
        L8:
            if (r14 == null) goto L12;
            DrawableCompat.setTintList(r14, this.f3870p.f3827o);
            PorterDuff.Mode r15 = this.f3870p.f3831s;
            if (r15 == null) goto L12;
            DrawableCompat.setTintMode(r14, r15);
        L12:
            f r16 = this.f3860c;
            if (r16 == null) goto L15;
            CharSequence r17 = r16.i();
        L17:
            if (r11 == null) goto L21;
            if (r14 == null) goto L20;
            r11.setImageDrawable(r14);
            r11.setVisibility(0);
            setVisibility(0);
            goto L21
        L20:
            r11.setVisibility(8);
            r11.setImageDrawable(null);
        L21:
            boolean r18 = !TextUtils.isEmpty(r17);
            if (r10 == null) goto L30;
            if (r18 == false) goto L29;
            r10.setText(r17);
            if (f.b(this.f3860c) != 1) goto L27;
            r10.setVisibility(0);
        L28:
            setVisibility(0);
            goto L30
        L27:
            r10.setVisibility(8);
            goto L28
        L29:
            r10.setVisibility(8);
            r10.setText(null);
        L30:
            if (r11 == null) goto L46;
            ViewGroup.MarginLayoutParams r19 = (ViewGroup.MarginLayoutParams) r11.getLayoutParams();
            if (r18 == true) goto L34;
        L36:
            int r20 = 0;
        L38:
            if (this.f3870p.F == false) goto L43;
            if (r20 == MarginLayoutParamsCompat.getMarginEnd(r19)) goto L46;
            MarginLayoutParamsCompat.setMarginEnd(r19, r20);
            r19.bottomMargin = 0;
        L45:
            r11.setLayoutParams(r19);
            r11.requestLayout();
            goto L46
        L43:
            if (r20 == r19.bottomMargin) goto L46;
            r19.bottomMargin = r20;
            MarginLayoutParamsCompat.setMarginEnd(r19, 0);
            goto L45
        L34:
            if (r11.getVisibility() != 0) goto L36;
            r20 = (int) ViewUtils.c(getContext(), 8);
        L46:
            f r21 = this.f3860c;
            if (r21 == null) goto L49;
            r13 = f.c(r21);
        L49:
            int r22 = Build.VERSION.SDK_INT;
            if (r22 >= 21) goto L52;
        L53:
            if (r18 == true) goto L56;
            r17 = r13;
        L56:
            TooltipCompat.setTooltipText(this, r17);
            return;
        L52:
            if (r22 > 23) goto L53;
            return;
        L15:
            r17 = null;
            goto L17
        L5:
            if (r12.f() == null) goto L7;
            r14 = DrawableCompat.wrap(this.f3860c.f()).mutate();
            goto L8
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void drawableStateChanged() {
            super.drawableStateChanged();
            int[] r10 = getDrawableState();
            Drawable r11 = this.f3868n;
            boolean r12 = false;
            if (r11 != null) goto L5;
        L7:
            if (r12 == false) goto L10;
            invalidate();
            this.f3870p.invalidate();
            return;
        L10:
            return;
        L5:
            if (r11.isStateful() == false) goto L7;
            r12 = false | this.f3868n.setState(r10);
            goto L7
        }

        int getContentHeight() {
            int r10 = 0;
            View[] r11 = {this.f3861g, this.f3862h, this.f3865k};
            int r12 = 0;
            int r13 = 0;
            boolean r14 = false;
        L3:
            if (r10 >= 3) goto L17;
            View r15 = r11[r10];
            if (r15 == null) goto L15;
            if (r15.getVisibility() != 0) goto L15;
            if (r14 == false) goto L10;
            r13 = Math.min(r13, r15.getTop());
        L11:
            if (r14 == false) goto L13;
            r12 = Math.max(r12, r15.getBottom());
        L14:
            r14 = true;
            goto L15
        L13:
            r12 = r15.getBottom();
            goto L14
        L10:
            r13 = r15.getTop();
        L15:
            r10 = r10 + 1;
            goto L3
        L17:
            return r12 - r13;
        }

        int getContentWidth() {
            int r10 = 0;
            View[] r11 = {this.f3861g, this.f3862h, this.f3865k};
            int r12 = 0;
            int r13 = 0;
            boolean r14 = false;
        L3:
            if (r10 >= 3) goto L17;
            View r15 = r11[r10];
            if (r15 == null) goto L15;
            if (r15.getVisibility() != 0) goto L15;
            if (r14 == false) goto L10;
            r13 = Math.min(r13, r15.getLeft());
        L11:
            if (r14 == false) goto L13;
            r12 = Math.max(r12, r15.getRight());
        L14:
            r14 = true;
            goto L15
        L13:
            r12 = r15.getRight();
            goto L14
        L10:
            r13 = r15.getLeft();
        L15:
            r10 = r10 + 1;
            goto L3
        L17:
            return r12 - r13;
        }

        @Nullable
        public f getTab() {
            return this.f3860c;
        }

        void o() {
            setTab(null);
            setSelected(false);
        }

        @Override // android.view.View
        public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo r10) {
            super.onInitializeAccessibilityNodeInfo(r10);
            com.google.android.material.badge.a r11 = this.f3864j;
            if (r11 != null) goto L5;
        L7:
            AccessibilityNodeInfoCompat r12 = AccessibilityNodeInfoCompat.wrap(r10);
            r12.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(0, 1, this.f3860c.g(), 1, false, isSelected()));
            if (isSelected() == false) goto L10;
            r12.setClickable(false);
            r12.removeAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_CLICK);
        L10:
            r12.setRoleDescription(getResources().getString(j.item_view_role_description));
            return;
        L5:
            if (r11.isVisible() == false) goto L7;
            r10.setContentDescription(getContentDescription() + ", " + this.f3864j.f());
            goto L7
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onMeasure(int r10, int r11) {
            int r12 = View.MeasureSpec.getSize(r10);
            int r13 = View.MeasureSpec.getMode(r10);
            int r14 = this.f3870p.getTabMaxWidth();
            if (r14 <= 0) goto L7;
            if (r13 == 0) goto L6;
            if (r12 <= r14) goto L7;
        L6:
            r10 = View.MeasureSpec.makeMeasureSpec(this.f3870p.f3835w, Integer.MIN_VALUE);
        L7:
            super.onMeasure(r10, r11);
            if (this.f3861g == null) goto L35;
            float r15 = this.f3870p.f3832t;
            int r16 = this.f3869o;
            ImageView r17 = this.f3862h;
            boolean r18 = true;
            if (r17 != null) goto L12;
        L14:
            TextView r19 = this.f3861g;
            if (r19 != null) goto L17;
        L19:
            float r20 = this.f3861g.getTextSize();
            int r21 = this.f3861g.getLineCount();
            int r22 = TextViewCompat.getMaxLines(this.f3861g);
            if (r15 != r20) goto L24;
            if (r22 < 0) goto L36;
            if (r16 != r22) goto L24;
            return;
        L36:
            return;
        L24:
            if (this.f3870p.E != 1) goto L32;
            if (r15 <= r20) goto L32;
            if (r21 != 1) goto L32;
            Layout r23 = this.f3861g.getLayout();
            if (r23 != null) goto L30;
        L31:
            r18 = false;
            goto L32
        L30:
            if (g(r23, 0, r15) > ((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight())) goto L31;
        L32:
            if (r18 == false) goto L38;
            this.f3861g.setTextSize(0, r15);
            this.f3861g.setMaxLines(r16);
            super.onMeasure(r10, r11);
            return;
        L38:
            return;
        L17:
            if (r19.getLineCount() <= 1) goto L19;
            r15 = this.f3870p.f3833u;
            goto L19
        L12:
            if (r17.getVisibility() != 0) goto L14;
            r16 = 1;
            goto L19
        }

        @Override // android.view.View
        public boolean performClick() {
            boolean r10 = super.performClick();
            if (this.f3860c == null) goto L8;
            if (r10 == true) goto L6;
            playSoundEffect(0);
        L6:
            this.f3860c.l();
            return true;
        L8:
            return r10;
        }

        @Override // android.view.View
        public void setSelected(boolean r10) {
            if (isSelected() == r10) goto L5;
            boolean r11 = true;
        L6:
            super.setSelected(r10);
            if (r11 == false) goto L12;
            if (r10 == false) goto L12;
            if (Build.VERSION.SDK_INT >= 16) goto L12;
            sendAccessibilityEvent(4);
        L12:
            TextView r12 = this.f3861g;
            if (r12 == null) goto L15;
            r12.setSelected(r10);
        L15:
            ImageView r13 = this.f3862h;
            if (r13 == null) goto L18;
            r13.setSelected(r10);
        L18:
            View r14 = this.f3865k;
            if (r14 == null) goto L22;
            r14.setSelected(r10);
            return;
        L22:
            return;
        L5:
            r11 = false;
            goto L6
        }

        void setTab(@Nullable f r10) {
            if (r10 == this.f3860c) goto L6;
            this.f3860c = r10;
            t();
            return;
        }

        final void t() {
            f r10 = this.f3860c;
            ImageView r11 = null;
            if (r10 == null) goto L5;
            View r12 = r10.e();
        L6:
            if (r12 == null) goto L22;
            ViewParent r13 = r12.getParent();
            if (r13 == this) goto L12;
            if (r13 == null) goto L11;
            ((ViewGroup) r13).removeView(r12);
        L11:
            addView(r12);
        L12:
            this.f3865k = r12;
            TextView r14 = this.f3861g;
            if (r14 == null) goto L15;
            r14.setVisibility(8);
        L15:
            ImageView r15 = this.f3862h;
            if (r15 == null) goto L18;
            r15.setVisibility(8);
            this.f3862h.setImageDrawable(null);
        L18:
            TextView r16 = (TextView) r12.findViewById(R.id.text1);
            this.f3866l = r16;
            if (r16 == null) goto L21;
            this.f3869o = TextViewCompat.getMaxLines(r16);
        L21:
            r11 = (ImageView) r12.findViewById(R.id.icon);
        L26:
            this.f3867m = r11;
            if (this.f3865k == null) goto L29;
            TextView r17 = this.f3866l;
            if (r17 == null) goto L41;
        L42:
            w(r17, this.f3867m);
        L43:
            if (r10 != null) goto L45;
        L47:
            if (r10 != null) goto L49;
        L51:
            boolean r18 = false;
        L52:
            setSelected(r18);
            return;
        L49:
            if (r10.j() == false) goto L51;
            r18 = true;
            goto L52
        L45:
            if (TextUtils.isEmpty(f.c(r10)) == true) goto L47;
            setContentDescription(f.c(r10));
            goto L47
        L41:
            if (this.f3867m == null) goto L43;
        L29:
            if (this.f3862h != null) goto L32;
            m();
        L32:
            if (this.f3861g != null) goto L34;
            n();
            this.f3869o = TextViewCompat.getMaxLines(this.f3861g);
        L34:
            TextViewCompat.setTextAppearance(this.f3861g, this.f3870p.f3825m);
            ColorStateList r19 = this.f3870p.f3826n;
            if (r19 == null) goto L37;
            this.f3861g.setTextColor(r19);
        L37:
            w(this.f3861g, this.f3862h);
            r();
            f(this.f3862h);
            f(this.f3861g);
            goto L43
        L22:
            View r20 = this.f3865k;
            if (r20 == null) goto L25;
            removeView(r20);
            this.f3865k = null;
        L25:
            this.f3866l = null;
            goto L26
        L5:
            r12 = null;
            goto L6
        }

        final void v() {
            setOrientation(!this.f3870p.F ? 1 : 0);
            TextView r10 = this.f3866l;
            if (r10 == null) goto L5;
        L8:
            ImageView r11 = this.f3867m;
        L9:
            w(r10, r11);
            return;
        L5:
            if (this.f3867m != null) goto L8;
            r10 = this.f3861g;
            r11 = this.f3862h;
            goto L9
        }
    }

    public static class h implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ViewPager f3873a;

        public h(ViewPager r10) {
            this.f3873a = r10;
        }

        @Override // com.google.android.material.tabs.TabLayout.b
        public void a(f r10) {
        }

        @Override // com.google.android.material.tabs.TabLayout.b
        public void b(@NonNull f r10) {
            this.f3873a.setCurrentItem(r10.g());
        }

        @Override // com.google.android.material.tabs.TabLayout.b
        public void c(f r10) {
        }
    }

    static {
        W = k.Widget_Design_TabLayout;
        f3816a0 = new Pools.SynchronizedPool(16);
    }

    public TabLayout(@NonNull Context r10) {
        this(r10, null);
    }

    public TabLayout(@NonNull Context r10, @Nullable AttributeSet r11) {
        this(r10, r11, q5.b.tabStyle);
    }

    public TabLayout(@NonNull Context r12, @Nullable AttributeSet r13, int r14) {
        int r10 = W;
        super(b6.a.c(r12, r13, r14, r10), r13, r14);
        this.f3818c = new ArrayList();
        this.f3829q = new GradientDrawable();
        this.f3830r = 0;
        this.f3835w = Integer.MAX_VALUE;
        this.H = -1;
        this.M = new ArrayList();
        this.V = new Pools.SimplePool(12);
        Context r11 = getContext();
        setHorizontalScrollBarEnabled(false);
        e r15 = new e(this, r11);
        this.f3820h = r15;
        super.addView(r15, 0, new FrameLayout.LayoutParams(-2, -1));
        int[] r16 = l.TabLayout;
        int r17 = l.TabLayout_tabTextAppearance;
        TypedArray r18 = com.google.android.material.internal.k.h(r11, r13, r16, r14, r10, new int[]{r17});
        if ((getBackground() instanceof ColorDrawable) == false) goto L5;
        ColorDrawable r19 = (ColorDrawable) getBackground();
        MaterialShapeDrawable r20 = new MaterialShapeDrawable();
        r20.setFillColor(ColorStateList.valueOf(r19.getColor()));
        r20.initializeElevationOverlay(r11);
        r20.setElevation(ViewCompat.getElevation(this));
        ViewCompat.setBackground(this, r20);
    L5:
        setSelectedTabIndicator(com.google.android.material.resources.c.e(r11, r18, l.TabLayout_tabIndicator));
        setSelectedTabIndicatorColor(r18.getColor(l.TabLayout_tabIndicatorColor, 0));
        r15.g(r18.getDimensionPixelSize(l.TabLayout_tabIndicatorHeight, -1));
        setSelectedTabIndicatorGravity(r18.getInt(l.TabLayout_tabIndicatorGravity, 0));
        setTabIndicatorAnimationMode(r18.getInt(l.TabLayout_tabIndicatorAnimationMode, 0));
        setTabIndicatorFullWidth(r18.getBoolean(l.TabLayout_tabIndicatorFullWidth, true));
        int r110 = r18.getDimensionPixelSize(l.TabLayout_tabPadding, 0);
        this.f3824l = r110;
        this.f3823k = r110;
        this.f3822j = r110;
        this.f3821i = r110;
        this.f3821i = r18.getDimensionPixelSize(l.TabLayout_tabPaddingStart, r110);
        this.f3822j = r18.getDimensionPixelSize(l.TabLayout_tabPaddingTop, this.f3822j);
        this.f3823k = r18.getDimensionPixelSize(l.TabLayout_tabPaddingEnd, this.f3823k);
        this.f3824l = r18.getDimensionPixelSize(l.TabLayout_tabPaddingBottom, this.f3824l);
        int r111 = r18.getResourceId(r17, k.TextAppearance_Design_Tab);
        this.f3825m = r111;
        TypedArray r112 = r11.obtainStyledAttributes(r111, androidx.appcompat.R.styleable.TextAppearance);
        this.f3832t = r112.getDimensionPixelSize(androidx.appcompat.R.styleable.TextAppearance_android_textSize, 0);     // Catch: Throwable -> L15
        this.f3826n = com.google.android.material.resources.c.a(r11, r112, androidx.appcompat.R.styleable.TextAppearance_android_textColor);     // Catch: Throwable -> L15
        r112.recycle();
        int r113 = l.TabLayout_tabTextColor;
        if (r18.hasValue(r113) == false) goto L10;
        this.f3826n = com.google.android.material.resources.c.a(r11, r18, r113);
    L10:
        int r114 = l.TabLayout_tabSelectedTextColor;
        if (r18.hasValue(r114) == false) goto L13;
        this.f3826n = o(this.f3826n.getDefaultColor(), r18.getColor(r114, 0));
    L13:
        this.f3827o = com.google.android.material.resources.c.a(r11, r18, l.TabLayout_tabIconTint);
        this.f3831s = ViewUtils.j(r18.getInt(l.TabLayout_tabIconTintMode, -1), null);
        this.f3828p = com.google.android.material.resources.c.a(r11, r18, l.TabLayout_tabRippleColor);
        this.C = r18.getInt(l.TabLayout_tabIndicatorAnimationDuration, 300);
        this.f3836x = r18.getDimensionPixelSize(l.TabLayout_tabMinWidth, -1);
        this.f3837y = r18.getDimensionPixelSize(l.TabLayout_tabMaxWidth, -1);
        this.f3834v = r18.getResourceId(l.TabLayout_tabBackground, 0);
        this.A = r18.getDimensionPixelSize(l.TabLayout_tabContentStart, 0);
        this.E = r18.getInt(l.TabLayout_tabMode, 1);
        this.B = r18.getInt(l.TabLayout_tabGravity, 0);
        this.F = r18.getBoolean(l.TabLayout_tabInlineLabel, false);
        this.f3817J = r18.getBoolean(l.TabLayout_tabUnboundedRipple, false);
        r18.recycle();
        Resources r115 = getResources();
        this.f3833u = r115.getDimensionPixelSize(q5.d.design_tab_text_size_2line);
        this.f3838z = r115.getDimensionPixelSize(q5.d.design_tab_scrollable_min_width);
        l();
        return;
    L15:
        th = move-exception;
        r112.recycle();
        throw th;
    }

    private void E(int r10) {
        g r11 = (g) this.f3820h.getChildAt(r10);
        this.f3820h.removeViewAt(r10);
        if (r11 == null) goto L5;
        r11.o();
        this.V.release(r11);
    L5:
        requestLayout();
    }

    private void L(@Nullable ViewPager r10, boolean r11, boolean r12) {
        ViewPager r13 = this.P;
        if (r13 == null) goto L10;
        TabLayoutOnPageChangeListener r14 = this.S;
        if (r14 == null) goto L7;
        r13.removeOnPageChangeListener(r14);
    L7:
        AdapterChangeListener r15 = this.T;
        if (r15 == null) goto L10;
        this.P.removeOnAdapterChangeListener(r15);
    L10:
        b r16 = this.N;
        if (r16 == null) goto L13;
        D(r16);
        this.N = null;
    L13:
        if (r10 == null) goto L24;
        this.P = r10;
        if (this.S != null) goto L17;
        this.S = new TabLayoutOnPageChangeListener(this);
    L17:
        this.S.reset();
        r10.addOnPageChangeListener(this.S);
        h r17 = new h(r10);
        this.N = r17;
        c(r17);
        PagerAdapter r18 = r10.getAdapter();
        if (r18 == null) goto L21;
        H(r18, r11);
    L21:
        if (this.T != null) goto L23;
        this.T = new AdapterChangeListener(this);
    L23:
        this.T.setAutoRefresh(r11);
        r10.addOnAdapterChangeListener(this.T);
        I(r10.getCurrentItem(), 0.0f, true);
    L25:
        this.U = r12;
        return;
    L24:
        this.P = null;
        H(null, false);
        goto L25
    }

    private void M() {
        int r10 = this.f3818c.size();
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L5;
        this.f3818c.get(r11).s();
        r11 = r11 + 1;
        goto L3
    }

    private void N(@NonNull LinearLayout.LayoutParams r10) {
        if (this.E == 1) goto L5;
    L7:
        r10.width = -2;
        float r11 = 0.0f;
    L8:
        r10.weight = r11;
        return;
    L5:
        if (this.B != 0) goto L7;
        r10.width = 0;
        r11 = 1.0f;
        goto L8
    }

    static /* synthetic */ com.google.android.material.tabs.c a(TabLayout r10) {
        return r10.K;
    }

    static /* synthetic */ int b(TabLayout r10) {
        return r10.f3830r;
    }

    private void g(@NonNull TabItem r10) {
        f r11 = z();
        CharSequence r12 = r10.f3813c;
        if (r12 == null) goto L5;
        r11.r(r12);
    L5:
        Drawable r13 = r10.f3814g;
        if (r13 == null) goto L8;
        r11.p(r13);
    L8:
        int r14 = r10.f3815h;
        if (r14 == 0) goto L12;
        r11.n(r14);
    L12:
        if (TextUtils.isEmpty(r10.getContentDescription()) == true) goto L14;
        r11.m(r10.getContentDescription());
    L14:
        d(r11);
    }

    @Dimension(unit = 0)
    private int getDefaultHeight() {
        int r10 = this.f3818c.size();
        boolean r11 = false;
        int r12 = 0;
    L3:
        if (r12 >= r10) goto L12;
        f r13 = this.f3818c.get(r12);
        if (r13 == null) goto L11;
        if (r13.f() == null) goto L11;
        if (TextUtils.isEmpty(r13.i()) == true) goto L11;
        r11 = true;
    L11:
        r12 = r12 + 1;
    L12:
        if (r11 == true) goto L14;
    L16:
        return 48;
    L14:
        if (this.F == true) goto L16;
        return 72;
    }

    private int getTabMinWidth() {
        int r10 = this.f3836x;
        if (r10 == (-1)) goto L5;
        return r10;
    L5:
        int r11 = this.E;
        if (r11 == 0) goto L12;
        if (r11 == 2) goto L12;
        return 0;
    L12:
        return this.f3838z;
    }

    private int getTabScrollRange() {
        return Math.max(0, ((this.f3820h.getWidth() - getWidth()) - getPaddingLeft()) - getPaddingRight());
    }

    private void h(@NonNull f r10) {
        g r11 = r10.f3858h;
        r11.setSelected(false);
        r11.setActivated(false);
        this.f3820h.addView(r11, r10.g(), p());
    }

    private void i(View r10) {
        if ((r10 instanceof TabItem) == false) goto L7;
        g((TabItem) r10);
        return;
    L7:
        throw new IllegalArgumentException("Only TabItem instances can be added to TabLayout");
    }

    private void j(int r10) {
        if (r10 != (-1)) goto L6;
        return;
    L6:
        if (getWindowToken() != null) goto L8;
    L17:
        I(r10, 0.0f, true);
        return;
    L8:
        if (ViewCompat.isLaidOut(this) == false) goto L17;
        if (this.f3820h.d() == true) goto L17;
        int r11 = getScrollX();
        int r12 = m(r10, 0.0f);
        if (r11 == r12) goto L15;
        v();
        this.O.setIntValues(new int[]{r11, r12});
        this.O.start();
    L15:
        this.f3820h.c(r10, this.C);
    }

    private void k(int r10) {
        if (r10 != 0) goto L4;
        Log.w("TabLayout", "MODE_SCROLLABLE + GRAVITY_FILL is not supported, GRAVITY_START will be used instead");
    L10:
        this.f3820h.setGravity(GravityCompat.START);
        return;
    L4:
        if (r10 != 1) goto L6;
        this.f3820h.setGravity(1);
        return;
    L6:
        if (r10 == 2) goto L10;
    }

    private void l() {
        int r10 = this.E;
        if (r10 == 0) goto L7;
        if (r10 == 2) goto L7;
        int r11 = 0;
    L8:
        ViewCompat.setPaddingRelative(this.f3820h, r11, 0, 0, 0);
        int r12 = this.E;
        if (r12 == 0) goto L17;
        if (r12 == 1) goto L14;
        if (r12 == 2) goto L14;
    L18:
        O(true);
        return;
    L14:
        if (this.B != 2) goto L16;
        Log.w("TabLayout", "GRAVITY_START is not supported with the current tab mode, GRAVITY_CENTER will be used instead");
    L16:
        this.f3820h.setGravity(1);
        goto L18
    L17:
        k(this.B);
    L7:
        r11 = Math.max(0, this.A - this.f3821i);
        goto L8
    }

    private int m(int r10, float r11) {
        int r12 = this.E;
        int r13 = 0;
        if (r12 == 0) goto L7;
        if (r12 == 2) goto L7;
        return 0;
    L7:
        View r14 = this.f3820h.getChildAt(r10);
        if (r14 != null) goto L10;
        return 0;
    L10:
        int r15 = r10 + 1;
        if (r15 >= this.f3820h.getChildCount()) goto L13;
        View r16 = this.f3820h.getChildAt(r15);
    L14:
        int r17 = r14.getWidth();
        if (r16 == null) goto L17;
        r13 = r16.getWidth();
    L17:
        int r18 = (r14.getLeft() + (r17 / 2)) - (getWidth() / 2);
        int r19 = (int) (((r17 + r13) * 0.5f) * r11);
        if (ViewCompat.getLayoutDirection(this) != 0) goto L21;
        return r18 + r19;
    L21:
        return r18 - r19;
    L13:
        r16 = null;
        goto L14
    }

    private void n(@NonNull f r10, int r11) {
        r10.q(r11);
        this.f3818c.add(r11, r10);
        int r12 = this.f3818c.size();
    L3:
        r11 = r11 + 1;
        if (r11 >= r12) goto L6;
        this.f3818c.get(r11).q(r11);
        goto L3
    }

    @NonNull
    private static ColorStateList o(int r10, int r11) {
        return new ColorStateList(new int[][]{HorizontalScrollView.SELECTED_STATE_SET, HorizontalScrollView.EMPTY_STATE_SET}, new int[]{r11, r10});
    }

    @NonNull
    private LinearLayout.LayoutParams p() {
        LinearLayout.LayoutParams r10 = new LinearLayout.LayoutParams(-2, -1);
        N(r10);
        return r10;
    }

    @NonNull
    private g r(@NonNull f r10) {
        Pools.Pool<g> r11 = this.V;
        if (r11 == null) goto L5;
        g r12 = r11.acquire();
    L6:
        if (r12 != null) goto L8;
        r12 = new g(this, getContext());
    L8:
        r12.setTab(r10);
        r12.setFocusable(true);
        r12.setMinimumWidth(getTabMinWidth());
        if (TextUtils.isEmpty(f.c(r10)) == false) goto L11;
        CharSequence r13 = f.d(r10);
    L12:
        r12.setContentDescription(r13);
        return r12;
    L11:
        r13 = f.c(r10);
        goto L12
    L5:
        r12 = null;
        goto L6
    }

    private void s(@NonNull f r10) {
        int r11 = this.M.size() - 1;
    L3:
        if (r11 < 0) goto L5;
        this.M.get(r11).a(r10);
        r11 = r11 - 1;
        goto L3
    }

    private void setSelectedTabView(int r10) {
        int r11 = this.f3820h.getChildCount();
        if (r10 >= r11) goto L15;
        int r12 = 0;
    L5:
        if (r12 >= r11) goto L19;
        View r13 = this.f3820h.getChildAt(r12);
        boolean r14 = true;
        if (r12 != r10) goto L9;
        boolean r15 = true;
    L10:
        r13.setSelected(r15);
        if (r12 == r10) goto L14;
        r14 = false;
    L14:
        r13.setActivated(r14);
        r12 = r12 + 1;
        goto L5
    L9:
        r15 = false;
        goto L10
    L19:
        return;
    }

    private void t(@NonNull f r10) {
        int r11 = this.M.size() - 1;
    L3:
        if (r11 < 0) goto L5;
        this.M.get(r11).b(r10);
        r11 = r11 - 1;
        goto L3
    }

    private void u(@NonNull f r10) {
        int r11 = this.M.size() - 1;
    L3:
        if (r11 < 0) goto L5;
        this.M.get(r11).c(r10);
        r11 = r11 - 1;
        goto L3
    }

    private void v() {
        if (this.O != null) goto L6;
        ValueAnimator r10 = new ValueAnimator();
        this.O = r10;
        r10.setInterpolator(r5.a.f12674b);
        this.O.setDuration(this.C);
        this.O.addUpdateListener(new a(this));
        return;
    }

    private boolean x() {
        if (getTabMode() != 0) goto L5;
    L8:
        return true;
    L5:
        if (getTabMode() == 2) goto L8;
        return false;
    }

    void A() {
        C();
        PagerAdapter r10 = this.Q;
        if (r10 == null) goto L17;
        int r11 = r10.getCount();
        int r12 = 0;
    L5:
        if (r12 >= r11) goto L7;
        f(z().r(this.Q.getPageTitle(r12)), false);
        r12 = r12 + 1;
        goto L5
    L7:
        ViewPager r13 = this.P;
        if (r13 == null) goto L18;
        if (r11 <= 0) goto L19;
        int r14 = r13.getCurrentItem();
        if (r14 != getSelectedTabPosition()) goto L13;
        return;
    L13:
        if (r14 >= getTabCount()) goto L21;
        F(w(r14));
        return;
    L21:
        return;
    L19:
        return;
    L18:
        return;
    }

    protected boolean B(f r10) {
        return f3816a0.release(r10);
    }

    public void C() {
        int r10 = this.f3820h.getChildCount() - 1;
    L3:
        if (r10 < 0) goto L5;
        E(r10);
        r10 = r10 - 1;
        goto L3
    L5:
        Iterator<f> r11 = this.f3818c.iterator();
    L7:
        if (r11.hasNext() == false) goto L9;
        f r12 = r11.next();
        r11.remove();
        r12.k();
        B(r12);
        goto L7
    L9:
        this.f3819g = null;
    }

    @Deprecated
    public void D(@Nullable b r10) {
        this.M.remove(r10);
    }

    public void F(@Nullable f r10) {
        G(r10, true);
    }

    public void G(@Nullable f r10, boolean r11) {
        f r12 = this.f3819g;
        if (r12 != r10) goto L7;
        if (r12 == null) goto L25;
        s(r10);
        j(r10.g());
        return;
    L25:
        return;
    L7:
        if (r10 == null) goto L9;
        int r13 = r10.g();
    L10:
        if (r11 == false) goto L19;
        if (r12 != null) goto L13;
    L14:
        if (r13 == (-1)) goto L16;
        I(r13, 0.0f, true);
    L17:
        if (r13 == (-1)) goto L19;
        setSelectedTabView(r13);
    L16:
        j(r13);
        goto L17
    L13:
        if (r12.g() != (-1)) goto L16;
    L19:
        this.f3819g = r10;
        if (r12 == null) goto L22;
        u(r12);
    L22:
        if (r10 == null) goto L27;
        t(r10);
        return;
    L27:
        return;
    L9:
        r13 = -1;
        goto L10
    }

    void H(@Nullable PagerAdapter r10, boolean r11) {
        PagerAdapter r12 = this.Q;
        if (r12 == null) goto L7;
        DataSetObserver r13 = this.R;
        if (r13 == null) goto L7;
        r12.unregisterDataSetObserver(r13);
    L7:
        this.Q = r10;
        if (r11 == false) goto L14;
        if (r10 == null) goto L14;
        if (this.R != null) goto L13;
        this.R = new d(this);
    L13:
        r10.registerDataSetObserver(this.R);
    L14:
        A();
    }

    public void I(int r10, float r11, boolean r12) {
        J(r10, r11, r12, true);
    }

    public void J(int r10, float r11, boolean r12, boolean r13) {
        int r14 = Math.round(r10 + r11);
        if (r14 >= 0) goto L5;
        return;
    L5:
        if (r14 >= this.f3820h.getChildCount()) goto L24;
        if (r13 == false) goto L9;
        this.f3820h.f(r10, r11);
    L9:
        ValueAnimator r15 = this.O;
        if (r15 == null) goto L15;
        if (r15.isRunning() == false) goto L15;
        this.O.cancel();
    L15:
        if (r10 >= 0) goto L17;
        int r16 = 0;
    L18:
        scrollTo(r16, 0);
        if (r12 == false) goto L23;
        setSelectedTabView(r14);
        return;
    L23:
        return;
    L17:
        r16 = m(r10, r11);
        goto L18
    }

    public void K(@Nullable ViewPager r10, boolean r11) {
        L(r10, r11, false);
    }

    void O(boolean r10) {
        int r11 = 0;
    L4:
        if (r11 >= this.f3820h.getChildCount()) goto L9;
        View r12 = this.f3820h.getChildAt(r11);
        r12.setMinimumWidth(getTabMinWidth());
        N((LinearLayout.LayoutParams) r12.getLayoutParams());
        if (r10 == false) goto L8;
        r12.requestLayout();
    L8:
        r11 = r11 + 1;
        goto L4
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View r10) {
        i(r10);
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View r10, int r11) {
        i(r10);
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View r10, int r11, ViewGroup.LayoutParams r12) {
        i(r10);
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup, android.view.ViewManager
    public void addView(View r10, ViewGroup.LayoutParams r11) {
        i(r10);
    }

    @Deprecated
    public void c(@Nullable b r10) {
        if (this.M.contains(r10) == true) goto L6;
        this.M.add(r10);
        return;
    }

    public void d(@NonNull f r10) {
        f(r10, this.f3818c.isEmpty());
    }

    public void e(@NonNull f r10, int r11, boolean r12) {
        if (r10.f3857g != this) goto L9;
        n(r10, r11);
        h(r10);
        if (r12 == false) goto L10;
        r10.l();
        return;
    L10:
        return;
    L9:
        throw new IllegalArgumentException("Tab belongs to a different TabLayout.");
    }

    public void f(@NonNull f r10, boolean r11) {
        e(r10, this.f3818c.size(), r11);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet r10) {
        return generateLayoutParams(r10);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet r10) {
        return generateDefaultLayoutParams();
    }

    public int getSelectedTabPosition() {
        f r10 = this.f3819g;
        if (r10 != null) goto L7;
        return -1;
    L7:
        return r10.g();
    }

    public int getTabCount() {
        return this.f3818c.size();
    }

    public int getTabGravity() {
        return this.B;
    }

    @Nullable
    public ColorStateList getTabIconTint() {
        return this.f3827o;
    }

    public int getTabIndicatorAnimationMode() {
        return this.I;
    }

    public int getTabIndicatorGravity() {
        return this.D;
    }

    int getTabMaxWidth() {
        return this.f3835w;
    }

    public int getTabMode() {
        return this.E;
    }

    @Nullable
    public ColorStateList getTabRippleColor() {
        return this.f3828p;
    }

    @NonNull
    public Drawable getTabSelectedIndicator() {
        return this.f3829q;
    }

    @Nullable
    public ColorStateList getTabTextColors() {
        return this.f3826n;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.google.android.material.shape.h.e(this);
        if (this.P != null) goto L8;
        ViewParent r10 = getParent();
        if ((r10 instanceof ViewPager) == false) goto L9;
        L((ViewPager) r10, true, true);
        return;
    L9:
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.U == false) goto L6;
        setupWithViewPager(null);
        this.U = false;
        return;
    }

    @Override // android.view.View
    protected void onDraw(@NonNull Canvas r10) {
        int r11 = 0;
    L4:
        if (r11 >= this.f3820h.getChildCount()) goto L9;
        View r12 = this.f3820h.getChildAt(r11);
        if ((r12 instanceof g) == false) goto L8;
        g.c((g) r12, r10);
    L8:
        r11 = r11 + 1;
        goto L4
    L9:
        super.onDraw(r10);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo r10) {
        super.onInitializeAccessibilityNodeInfo(r10);
        AccessibilityNodeInfoCompat.wrap(r10).setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(1, getTabCount(), false, 1));
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent r10) {
        if (x() == true) goto L5;
    L7:
        return false;
    L5:
        if (super.onInterceptTouchEvent(r10) == false) goto L7;
        return true;
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int r10, int r11) {
        int r12 = Math.round(ViewUtils.c(getContext(), getDefaultHeight()));
        int r13 = View.MeasureSpec.getMode(r11);
        boolean r14 = false;
        if (r13 == Integer.MIN_VALUE) goto L8;
        if (r13 != 0) goto L12;
        r11 = View.MeasureSpec.makeMeasureSpec((r12 + getPaddingTop()) + getPaddingBottom(), 1073741824);
    L12:
        int r15 = View.MeasureSpec.getSize(r10);
        if (View.MeasureSpec.getMode(r10) == 0) goto L19;
        int r16 = this.f3837y;
        if (r16 > 0) goto L18;
        r16 = (int) (r15 - ViewUtils.c(getContext(), 56));
    L18:
        this.f3835w = r16;
    L19:
        super.onMeasure(r10, r11);
        if (getChildCount() != 1) goto L36;
        View r17 = getChildAt(0);
        int r18 = this.E;
        if (r18 == 0) goto L31;
        if (r18 == 1) goto L28;
        if (r18 == 2) goto L31;
    L33:
        if (r14 == false) goto L37;
        r17.measure(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), HorizontalScrollView.getChildMeasureSpec(r11, getPaddingTop() + getPaddingBottom(), r17.getLayoutParams().height));
        return;
    L37:
        return;
    L28:
        if (r17.getMeasuredWidth() == getMeasuredWidth()) goto L33;
    L29:
        r14 = true;
    L31:
        if (r17.getMeasuredWidth() >= getMeasuredWidth()) goto L33;
    L36:
        return;
    L8:
        if (getChildCount() != 1) goto L12;
        if (View.MeasureSpec.getSize(r11) < r12) goto L12;
        getChildAt(0).setMinimumHeight(r12);
        goto L12
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent r10) {
        if (r10.getActionMasked() != 8) goto L9;
        if (x() == true) goto L9;
        return false;
    L9:
        return super.onTouchEvent(r10);
    }

    protected f q() {
        f r10 = f3816a0.acquire();
        if (r10 == null) goto L5;
        return r10;
    L5:
        return new f();
    }

    @Override // android.view.View
    @RequiresApi(21)
    public void setElevation(float r10) {
        super.setElevation(r10);
        com.google.android.material.shape.h.d(this, r10);
    }

    public void setInlineLabel(boolean r10) {
        if (this.F == r10) goto L16;
        this.F = r10;
        int r11 = 0;
    L6:
        if (r11 >= this.f3820h.getChildCount()) goto L11;
        View r12 = this.f3820h.getChildAt(r11);
        if ((r12 instanceof g) == false) goto L10;
        ((g) r12).v();
    L10:
        r11 = r11 + 1;
        goto L6
    L11:
        l();
        return;
    }

    public void setInlineLabelResource(@BoolRes int r10) {
        setInlineLabel(getResources().getBoolean(r10));
    }

    @Deprecated
    public void setOnTabSelectedListener(@Nullable b r10) {
        b r11 = this.L;
        if (r11 == null) goto L5;
        D(r11);
    L5:
        this.L = r10;
        if (r10 == null) goto L9;
        c(r10);
        return;
    }

    @Deprecated
    public void setOnTabSelectedListener(@Nullable c r10) {
        setOnTabSelectedListener(r10);
    }

    void setScrollAnimatorListener(Animator.AnimatorListener r10) {
        v();
        this.O.addListener(r10);
    }

    public void setSelectedTabIndicator(@DrawableRes int r10) {
        if (r10 == 0) goto L4;
        Drawable r11 = AppCompatResources.getDrawable(getContext(), r10);
    L5:
        setSelectedTabIndicator(r11);
        return;
    L4:
        r11 = null;
        goto L5
    }

    public void setSelectedTabIndicator(@Nullable Drawable r10) {
        if (this.f3829q == r10) goto L13;
        if (r10 != null) goto L7;
        r10 = new GradientDrawable();
    L7:
        this.f3829q = r10;
        int r11 = this.H;
        if (r11 != (-1)) goto L11;
        r11 = r10.getIntrinsicHeight();
    L11:
        this.f3820h.g(r11);
        return;
    }

    public void setSelectedTabIndicatorColor(@ColorInt int r10) {
        this.f3830r = r10;
        O(false);
    }

    public void setSelectedTabIndicatorGravity(int r10) {
        if (this.D == r10) goto L6;
        this.D = r10;
        ViewCompat.postInvalidateOnAnimation(this.f3820h);
        return;
    }

    @Deprecated
    public void setSelectedTabIndicatorHeight(int r10) {
        this.H = r10;
        this.f3820h.g(r10);
    }

    public void setTabGravity(int r10) {
        if (this.B == r10) goto L6;
        this.B = r10;
        l();
        return;
    }

    public void setTabIconTint(@Nullable ColorStateList r10) {
        if (this.f3827o == r10) goto L6;
        this.f3827o = r10;
        M();
        return;
    }

    public void setTabIconTintResource(@ColorRes int r10) {
        setTabIconTint(AppCompatResources.getColorStateList(getContext(), r10));
    }

    public void setTabIndicatorAnimationMode(int r10) {
        this.I = r10;
        if (r10 != 0) goto L5;
        com.google.android.material.tabs.c r11 = new com.google.android.material.tabs.c();
    L13:
        this.K = r11;
        return;
    L5:
        if (r10 != 1) goto L7;
        r11 = new com.google.android.material.tabs.a();
        goto L13
    L7:
        if (r10 != 2) goto L10;
        r11 = new com.google.android.material.tabs.b();
        goto L13
    L10:
        throw new IllegalArgumentException(r10 + " is not a valid TabIndicatorAnimationMode");
    }

    public void setTabIndicatorFullWidth(boolean r10) {
        this.G = r10;
        e.a(this.f3820h);
        ViewCompat.postInvalidateOnAnimation(this.f3820h);
    }

    public void setTabMode(int r10) {
        if (r10 == this.E) goto L6;
        this.E = r10;
        l();
        return;
    }

    public void setTabRippleColor(@Nullable ColorStateList r10) {
        if (this.f3828p == r10) goto L11;
        this.f3828p = r10;
        int r11 = 0;
    L6:
        if (r11 >= this.f3820h.getChildCount()) goto L15;
        View r12 = this.f3820h.getChildAt(r11);
        if ((r12 instanceof g) == false) goto L10;
        g.b((g) r12, getContext());
    L10:
        r11 = r11 + 1;
        goto L6
    L15:
        return;
    }

    public void setTabRippleColorResource(@ColorRes int r10) {
        setTabRippleColor(AppCompatResources.getColorStateList(getContext(), r10));
    }

    public void setTabTextColors(@Nullable ColorStateList r10) {
        if (this.f3826n == r10) goto L6;
        this.f3826n = r10;
        M();
        return;
    }

    @Deprecated
    public void setTabsFromPagerAdapter(@Nullable PagerAdapter r10) {
        H(r10, false);
    }

    public void setUnboundedRipple(boolean r10) {
        if (this.f3817J == r10) goto L11;
        this.f3817J = r10;
        int r11 = 0;
    L6:
        if (r11 >= this.f3820h.getChildCount()) goto L15;
        View r12 = this.f3820h.getChildAt(r11);
        if ((r12 instanceof g) == false) goto L10;
        g.b((g) r12, getContext());
    L10:
        r11 = r11 + 1;
        goto L6
    L15:
        return;
    }

    public void setUnboundedRippleResource(@BoolRes int r10) {
        setUnboundedRipple(getResources().getBoolean(r10));
    }

    public void setupWithViewPager(@Nullable ViewPager r10) {
        K(r10, true);
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        if (getTabScrollRange() <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Nullable
    public f w(int r10) {
        if (r10 >= 0) goto L4;
    L7:
        return null;
    L4:
        if (r10 >= getTabCount()) goto L7;
        return this.f3818c.get(r10);
    }

    public boolean y() {
        return this.G;
    }

    @NonNull
    public f z() {
        f r10 = q();
        r10.f3857g = this;
        r10.f3858h = r(r10);
        if (f.a(r10) == (-1)) goto L5;
        r10.f3858h.setId(f.a(r10));
    L5:
        return r10;
    }
}
