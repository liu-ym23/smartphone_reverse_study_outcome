package com.google.android.material.tabs;

import android.animation.Animator;
import android.animation.ValueAnimator;
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
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.TooltipCompat;
import androidx.constraintlayout.core.motion.utils.TypedValues;
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
import com.google.android.material.internal.k;
import com.google.android.material.internal.r;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.h;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
@ViewPager.DecorView
public class TabLayout extends HorizontalScrollView {
    private static final Pools.Pool<e> A = null;
    private static final int z = 0;
    private final ArrayList<e> B;
    private e C;
    private int D;
    private final int E;
    private final int F;
    private final int G;
    private int H;
    private com.google.android.material.tabs.c I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private a f4110J;
    private final ArrayList<a> K;
    private a L;
    private ValueAnimator M;
    private PagerAdapter N;
    private DataSetObserver O;
    private TabLayoutOnPageChangeListener P;
    private AdapterChangeListener Q;
    private boolean R;
    private final Pools.Pool<f> S;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final d f4111a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f4112b;
    int c;
    int d;
    int e;
    int f;
    ColorStateList g;
    ColorStateList h;
    ColorStateList i;
    Drawable j;
    PorterDuff.Mode k;
    float l;
    float m;
    final int n;
    int o;
    int p;
    int q;
    int r;
    int s;
    boolean t;
    boolean u;
    int v;
    int w;
    boolean x;
    ViewPager y;

    private class AdapterChangeListener implements ViewPager.OnAdapterChangeListener {
        private boolean autoRefresh;
        final /* synthetic */ TabLayout this$0;

        AdapterChangeListener(TabLayout r1) {
            this.this$0 = r1;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnAdapterChangeListener
        public void onAdapterChanged(ViewPager r1, PagerAdapter r2, PagerAdapter r3) {
            if (this.this$0.y != r1) goto L6;
            this.this$0.a(r3, this.autoRefresh);
            return;
        }

        void setAutoRefresh(boolean r1) {
            this.autoRefresh = r1;
        }
    }

    public static class TabLayoutOnPageChangeListener implements ViewPager.OnPageChangeListener {
        private int previousScrollState;
        private int scrollState;
        private final WeakReference<TabLayout> tabLayoutRef;

        public TabLayoutOnPageChangeListener(TabLayout r2) {
            this.tabLayoutRef = new WeakReference(r2);
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int r2) {
            this.previousScrollState = this.scrollState;
            this.scrollState = r2;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int r6, float r7, int r8) {
            TabLayout r9 = (TabLayout) ZeusTransformUtils.preCheckCast(this.tabLayoutRef.get(), TabLayout.class, "com.obric.memorydata.plugin");
            if (r9 == null) goto L17;
            int r0 = this.scrollState;
            boolean r1 = false;
            if (r0 == 2) goto L7;
        L10:
            boolean r4 = true;
        L11:
            if (r0 == 2) goto L13;
        L14:
            r1 = true;
        L15:
            r9.a(r6, r7, r4, r1);
            return;
        L13:
            if (this.previousScrollState == 0) goto L15;
        L7:
            if (this.previousScrollState == 1) goto L10;
            r4 = false;
            goto L11
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int r4) {
            TabLayout r0 = (TabLayout) ZeusTransformUtils.preCheckCast(this.tabLayoutRef.get(), TabLayout.class, "com.obric.memorydata.plugin");
            if (r0 != null) goto L5;
            return;
        L5:
            if (r0.getSelectedTabPosition() != r4) goto L7;
            return;
        L7:
            if (r4 >= r0.getTabCount()) goto L21;
            int r1 = this.scrollState;
            if (r1 != 0) goto L11;
        L16:
            boolean r3 = true;
        L17:
            r0.b(r0.a(r4), r3);
            return;
        L11:
            if (r1 == 2) goto L13;
        L15:
            r3 = false;
            goto L17
        L13:
            if (this.previousScrollState != 0) goto L15;
        }

        void reset() {
            this.scrollState = 0;
            this.previousScrollState = 0;
        }
    }

    @Deprecated
    public interface a<T extends e> {
        void a(T r1);

        void b(T r1);

        void c(T r1);
    }

    public interface b extends a<e> {
    }

    private class c extends DataSetObserver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ TabLayout f4114a;

        c(TabLayout r1) {
            this.f4114a = r1;
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            this.f4114a.e();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            this.f4114a.e();
        }
    }

    class d extends LinearLayout {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        ValueAnimator f4115a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f4116b;
        float c;
        final /* synthetic */ TabLayout d;
        private int e;

        d(TabLayout r3, Context r4) {
            Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
            this.d = r3;
            super(r5);
            this.f4116b = -1;
            this.e = -1;
            setWillNotDraw(false);
        }

        private void a(View r8, View r9, float r10) {
            if (r8 != null) goto L4;
        L6:
            boolean r0 = false;
        L7:
            if (r0 == false) goto L9;
            com.google.android.material.tabs.c r1 = TabLayout.a(this.d);
            TabLayout r2 = this.d;
            r1.a(r2, r8, r9, r10, r2.j);
        L10:
            ViewCompat.postInvalidateOnAnimation(this);
            return;
        L9:
            this.d.j.setBounds(-1, this.d.j.getBounds().top, -1, this.d.j.getBounds().bottom);
            goto L10
        L4:
            if (r8.getWidth() <= 0) goto L6;
            r0 = true;
            goto L7
        }

        static /* synthetic */ void a(d r0) {
            r0.b();
        }

        static /* synthetic */ void a(d r0, View r1, View r2, float r3) {
            r0.a(r1, r2, r3);
        }

        private void a(boolean r4, final int r5, int r6) {
            final View r0 = getChildAt(this.f4116b);
            final View r1 = getChildAt(r5);
            if (r1 != null) goto L6;
            b();
            return;
        L6:
            ValueAnimator.AnimatorUpdateListener r2 = new AnonymousClass1(this, r0, r1);
            if (r4 == false) goto L9;
            ValueAnimator r7 = new ValueAnimator();
            this.f4115a = r7;
            r7.setInterpolator(com.google.android.material.a.a.f3742b);
            r7.setDuration(r6);
            r7.setFloatValues(new float[]{0.0f, 1.0f});
            r7.addUpdateListener(r2);
            r7.addListener(new AnonymousClass2(this, r5));
            r7.start();
            return;
        L9:
            this.f4115a.removeAllUpdateListeners();
            this.f4115a.addUpdateListener(r2);
        }

        private void b() {
            View r0 = getChildAt(this.f4116b);
            com.google.android.material.tabs.c r1 = TabLayout.a(this.d);
            TabLayout r3 = this.d;
            r1.a(r3, r0, r3.j);
        }

        void a(int r5) {
            Rect r0 = this.d.j.getBounds();
            this.d.j.setBounds(r0.left, 0, r0.right, r5);
            requestLayout();
        }

        void a(int r2, float r3) {
            ValueAnimator r0 = this.f4115a;
            if (r0 != null) goto L5;
        L7:
            this.f4116b = r2;
            this.c = r3;
            a(getChildAt(r2), getChildAt(this.f4116b + 1), this.c);
            return;
        L5:
            if (r0.isRunning() == false) goto L7;
            this.f4115a.cancel();
            goto L7
        }

        void a(int r2, int r3) {
            ValueAnimator r0 = this.f4115a;
            if (r0 != null) goto L5;
        L7:
            a(true, r2, r3);
            return;
        L5:
            if (r0.isRunning() == false) goto L7;
            this.f4115a.cancel();
            goto L7
        }

        boolean a() {
            int r0 = getChildCount();
            int r2 = 0;
        L3:
            if (r2 >= r0) goto L9;
            if (getChildAt(r2).getWidth() <= 0) goto L6;
            r2 = r2 + 1;
            goto L3
        L6:
            return true;
        L9:
            return false;
        }

        @Override // android.view.View
        public void draw(Canvas r6) {
            int r0 = this.d.j.getBounds().height();
            if (r0 >= 0) goto L5;
            r0 = this.d.j.getIntrinsicHeight();
        L5:
            int r1 = this.d.r;
            int r2 = 0;
            if (r1 != 0) goto L8;
            r2 = getHeight() - r0;
        L15:
            r0 = getHeight();
        L17:
            if (this.d.j.getBounds().width() <= 0) goto L29;
            Rect r3 = this.d.j.getBounds();
            this.d.j.setBounds(r3.left, r2, r3.right, r0);
            Drawable r4 = this.d.j;
            if (TabLayout.b(this.d) == 0) goto L25;
            r4 = DrawableCompat.wrap(r4);
            if (Build.VERSION.SDK_INT != 21) goto L23;
            r4.setColorFilter(TabLayout.b(this.d), PorterDuff.Mode.SRC_IN);
        L28:
            r4.draw(r6);
            goto L29
        L23:
            DrawableCompat.setTint(r4, TabLayout.b(this.d));
            goto L28
        L25:
            if (Build.VERSION.SDK_INT != 21) goto L27;
            r4.setColorFilter(null);
            goto L28
        L27:
            DrawableCompat.setTintList(r4, null);
        L29:
            super.draw(r6);
            return;
        L8:
            if (r1 == 1) goto L13;
            if (r1 == 2) goto L17;
            if (r1 == 3) goto L15;
            r0 = 0;
            goto L17
        L13:
            r2 = (getHeight() - r0) / 2;
            r0 = (getHeight() + r0) / 2;
            goto L17
        }

        @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
        public void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
            super.onLayout(r1, r2, r3, r4, r5);
            ValueAnimator r6 = this.f4115a;
            if (r6 != null) goto L5;
        L7:
            b();
            return;
        L5:
            if (r6.isRunning() == false) goto L7;
            a(false, this.f4116b, -1);
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onMeasure(int r10, int r11) {
            super.onMeasure(r10, r11);
            if (View.MeasureSpec.getMode(r10) == 1073741824) goto L5;
            return;
        L5:
            boolean r2 = true;
            if (this.d.p != 1) goto L8;
        L9:
            int r0 = getChildCount();
            int r3 = 0;
            int r4 = 0;
            int r5 = 0;
        L10:
            if (r4 >= r0) goto L15;
            View r6 = getChildAt(r4);
            if (r6.getVisibility() != 0) goto L14;
            r5 = Math.max(r5, r6.getMeasuredWidth());
        L14:
            r4 = r4 + 1;
            goto L10
        L15:
            if (r5 > 0) goto L18;
            return;
        L18:
            if ((r5 * r0) > (getMeasuredWidth() - (((int) r.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), 16)) * 2))) goto L28;
            boolean r1 = false;
        L20:
            if (r3 >= r0) goto L27;
            LinearLayout.LayoutParams r7 = (LinearLayout.LayoutParams) ZeusTransformUtils.preCheckCast(getChildAt(r3).getLayoutParams(), LinearLayout.LayoutParams.class, "com.obric.memorydata.plugin");
            if (r7.width == r5) goto L24;
        L25:
            r7.width = r5;
            r7.weight = 0.0f;
            r1 = true;
        L26:
            r3 = r3 + 1;
            goto L20
        L24:
            if (r7.weight == 0.0f) goto L26;
        L27:
            r2 = r1;
        L29:
            if (r2 == false) goto L39;
            super.onMeasure(r10, r11);
            return;
        L39:
            return;
        L28:
            this.d.p = 0;
            this.d.a(false);
            goto L29
        L8:
            if (this.d.s == 2) goto L9;
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onRtlPropertiesChanged(int r3) {
            super.onRtlPropertiesChanged(r3);
            if (Build.VERSION.SDK_INT < 23) goto L5;
            return;
        L5:
            if (this.e == r3) goto L9;
            requestLayout();
            this.e = r3;
            return;
        }
    }

    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public TabLayout f4121a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public f f4122b;
        private Object c;
        private Drawable d;
        private CharSequence e;
        private CharSequence f;
        private int g;
        private View h;
        private int i;
        private int j;

        public e() {
            this.g = -1;
            this.i = 1;
            this.j = -1;
        }

        static /* synthetic */ int a(e r0) {
            return r0.j;
        }

        static /* synthetic */ CharSequence b(e r0) {
            return r0.f;
        }

        static /* synthetic */ CharSequence c(e r0) {
            return r0.e;
        }

        static /* synthetic */ int d(e r0) {
            return r0.i;
        }

        public View a() {
            return this.h;
        }

        public e a(int r5) {
            return a(ZeusTransformUtils.inflate(LayoutInflater.from((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f4122b.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")), r5, this.f4122b, false, "com.obric.memorydata.plugin"));
        }

        public e a(Drawable r3) {
            this.d = r3;
            if (this.f4121a.p != 1) goto L5;
        L6:
            this.f4121a.a(true);
        L7:
            h();
            if (com.google.android.material.badge.b.f3781a == true) goto L10;
        L14:
            return this;
        L10:
            if (f.a(this.f4122b) == false) goto L14;
            if (f.b(this.f4122b).isVisible() == false) goto L14;
            this.f4122b.invalidate();
            goto L14
        L5:
            if (this.f4121a.s != 2) goto L7;
            goto L6
        }

        public e a(View r1) {
            this.h = r1;
            h();
            return this;
        }

        public e a(CharSequence r3) {
            CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
            if (TextUtils.isEmpty(this.f) == true) goto L5;
        L7:
            this.e = r4;
            h();
            return this;
        L5:
            if (TextUtils.isEmpty(r4) == true) goto L7;
            this.f4122b.setContentDescription(r4);
            goto L7
        }

        public Drawable b() {
            return this.d;
        }

        public e b(CharSequence r3) {
            this.f = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
            h();
            return this;
        }

        void b(int r1) {
            this.g = r1;
        }

        public int c() {
            return this.g;
        }

        public CharSequence d() {
            return this.e;
        }

        public int e() {
            return this.i;
        }

        public void f() {
            TabLayout r0 = this.f4121a;
            if (r0 == null) goto L7;
            r0.c(this);
            return;
        L7:
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }

        public boolean g() {
            TabLayout r0 = this.f4121a;
            if (r0 == null) goto L12;
            int r1 = r0.getSelectedTabPosition();
            if (r1 != (-1)) goto L7;
        L9:
            return false;
        L7:
            if (r1 != this.g) goto L9;
            return true;
        L12:
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }

        void h() {
            f r0 = this.f4122b;
            if (r0 == null) goto L6;
            r0.update();
            return;
        }

        void i() {
            this.f4121a = null;
            this.f4122b = null;
            this.c = null;
            this.d = null;
            this.j = -1;
            this.e = null;
            this.f = null;
            this.g = -1;
            this.h = null;
        }
    }

    public final class f extends LinearLayout {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ TabLayout f4123a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private e f4124b;
        private TextView c;
        private ImageView d;
        private View e;
        private com.google.android.material.badge.a f;
        private View g;
        private TextView h;
        private ImageView i;
        private Drawable j;
        private int k;

        public f(TabLayout r5, Context r6) {
            Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.memorydata.plugin");
            this.f4123a = r5;
            super(r7);
            this.k = 2;
            a(r7);
            ViewCompat.setPaddingRelative(this, r5.f4112b, r5.c, r5.d, r5.e);
            setGravity(17);
            setOrientation(!r5.t ? 1 : 0);
            setClickable(true);
            ViewCompat.setPointerIcon(this, PointerIconCompat.getSystemIcon((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), 1002));
        }

        private float a(Layout r1, int r2, float r3) {
            return r1.getLineWidth(r2) * (r3 / r1.getPaint().getTextSize());
        }

        private void a(Context r7) {
            Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
            GradientDrawable r2 = null;
            if (this.f4123a.n == 0) goto L9;
            Drawable r9 = AppCompatResources.getDrawable(r8, this.f4123a.n);
            this.j = r9;
            if (r9 != null) goto L7;
        L10:
            Drawable r10 = new GradientDrawable();
            ((GradientDrawable) ZeusTransformUtils.preCheckCast(r10, GradientDrawable.class, "com.obric.memorydata.plugin")).setColor(0);
            if (this.f4123a.i == null) goto L23;
            GradientDrawable r0 = new GradientDrawable();
            r0.setCornerRadius(1.0E-5f);
            r0.setColor(-1);
            ColorStateList r3 = com.google.android.material.ripple.a.a(this.f4123a.i);
            if (Build.VERSION.SDK_INT >= 21) goto L15;
            Drawable r1 = DrawableCompat.wrap(r0);
            DrawableCompat.setTintList(r1, r3);
            r10 = new LayerDrawable(new Drawable[]{r10, r1});
            goto L23
        L15:
            if (this.f4123a.x == false) goto L18;
            r10 = null;
        L18:
            if (this.f4123a.x == true) goto L21;
            r2 = r0;
        L21:
            r10 = new RippleDrawable(r3, r10, r2);
        L23:
            ViewCompat.setBackground(this, r10);
            this.f4123a.invalidate();
            return;
        L7:
            if (r9.isStateful() == false) goto L10;
            this.j.setState(getDrawableState());
            goto L10
        L9:
            this.j = null;
            goto L10
        }

        private void a(Canvas r6) {
            Drawable r0 = this.j;
            if (r0 == null) goto L6;
            r0.setBounds(getLeft(), getTop(), getRight(), getBottom());
            this.j.draw(r6);
            return;
        }

        private void a(final View r2) {
            if (r2 != null) goto L4;
            return;
        L4:
            r2.addOnLayoutChangeListener(new AnonymousClass1(this, r2));
        }

        private void a(TextView r9, ImageView r10) {
            e r0 = this.f4124b;
            CharSequence r1 = null;
            if (r0 != null) goto L5;
        L7:
            Drawable r2 = null;
        L8:
            if (r2 == null) goto L12;
            DrawableCompat.setTintList(r2, this.f4123a.h);
            if (this.f4123a.k == null) goto L12;
            DrawableCompat.setTintMode(r2, this.f4123a.k);
        L12:
            e r3 = this.f4124b;
            if (r3 == null) goto L15;
            CharSequence r4 = r3.d();
        L17:
            if (r10 == null) goto L21;
            if (r2 == null) goto L20;
            r10.setImageDrawable(r2);
            r10.setVisibility(0);
            setVisibility(0);
            goto L21
        L20:
            r10.setVisibility(8);
            r10.setImageDrawable(null);
        L21:
            boolean r5 = !TextUtils.isEmpty(r4);
            if (r9 == null) goto L30;
            if (r5 == false) goto L29;
            r9.setText(r4);
            if (e.d(this.f4124b) != 1) goto L27;
            r9.setVisibility(0);
        L28:
            setVisibility(0);
            goto L30
        L27:
            r9.setVisibility(8);
            goto L28
        L29:
            r9.setVisibility(8);
            r9.setText(null);
        L30:
            if (r10 == null) goto L46;
            ViewGroup.MarginLayoutParams r11 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r10.getLayoutParams(), ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin");
            if (r5 == true) goto L34;
        L36:
            int r6 = 0;
        L38:
            if (this.f4123a.t == false) goto L43;
            if (r6 == MarginLayoutParamsCompat.getMarginEnd(r11)) goto L46;
            MarginLayoutParamsCompat.setMarginEnd(r11, r6);
            r11.bottomMargin = 0;
        L45:
            r10.setLayoutParams(r11);
            r10.requestLayout();
            goto L46
        L43:
            if (r6 == r11.bottomMargin) goto L46;
            r11.bottomMargin = r6;
            MarginLayoutParamsCompat.setMarginEnd(r11, 0);
            goto L45
        L34:
            if (r10.getVisibility() != 0) goto L36;
            r6 = (int) r.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), 8);
        L46:
            e r12 = this.f4124b;
            if (r12 == null) goto L50;
            r1 = e.b(r12);
        L50:
            if (Build.VERSION.SDK_INT >= 21) goto L52;
        L53:
            if (r5 == true) goto L56;
            r4 = r1;
        L56:
            TooltipCompat.setTooltipText(this, r4);
            return;
        L52:
            if (Build.VERSION.SDK_INT > 23) goto L53;
            return;
        L15:
            r4 = null;
            goto L17
        L5:
            if (r0.b() == null) goto L7;
            r2 = DrawableCompat.wrap(this.f4124b.b()).mutate();
            goto L8
        }

        static /* synthetic */ void a(f r2, Context r3) {
            r2.a((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"));
        }

        static /* synthetic */ void a(f r0, Canvas r1) {
            r0.a(r1);
        }

        static /* synthetic */ void a(f r0, View r1) {
            r0.c(r1);
        }

        private void a(boolean r3) {
            setClipChildren(r3);
            setClipToPadding(r3);
            ViewGroup r2 = (ViewGroup) ZeusTransformUtils.preCheckCast(getParent(), ViewGroup.class, "com.obric.memorydata.plugin");
            if (r2 == null) goto L6;
            r2.setClipChildren(r3);
            r2.setClipToPadding(r3);
            return;
        }

        static /* synthetic */ boolean a(f r0) {
            return r0.h();
        }

        static /* synthetic */ com.google.android.material.badge.a b(f r0) {
            return r0.f;
        }

        private void b(View r3) {
            if (h() == true) goto L5;
            return;
        L5:
            if (r3 == null) goto L8;
            a(false);
            com.google.android.material.badge.b.a(this.f, r3, d(r3));
            this.e = r3;
            return;
        }

        private void c() {
            if (com.google.android.material.badge.b.f3781a == false) goto L5;
            FrameLayout r0 = e();
            addView(r0, 0);
            ViewGroup r1 = r0;
        L6:
            ImageView r2 = (ImageView) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.inflate(LayoutInflater.from((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")), ZeusTransformUtils.mapRes(R.layout.design_layout_tab_icon, "layout", "design_layout_tab_icon"), r1, false, "com.obric.memorydata.plugin"), ImageView.class, "com.obric.memorydata.plugin");
            this.d = r2;
            r1.addView(r2, 0);
            return;
        L5:
            r1 = this;
            goto L6
        }

        private void c(View r2) {
            if (h() == true) goto L5;
            return;
        L5:
            if (r2 != this.e) goto L9;
            com.google.android.material.badge.b.b(this.f, r2, d(r2));
            return;
        }

        private FrameLayout d(View r3) {
            if (r3 == this.d) goto L8;
            if (r3 == this.c) goto L8;
            return null;
        L8:
            if (com.google.android.material.badge.b.f3781a == true) goto L10;
            return null;
        L10:
            return (FrameLayout) ZeusTransformUtils.preCheckCast(r3.getParent(), FrameLayout.class, "com.obric.memorydata.plugin");
        }

        private void d() {
            if (com.google.android.material.badge.b.f3781a == false) goto L5;
            FrameLayout r0 = e();
            addView(r0);
            ViewGroup r1 = r0;
        L6:
            TextView r2 = (TextView) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.inflate(LayoutInflater.from((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")), ZeusTransformUtils.mapRes(R.layout.design_layout_tab_text, "layout", "design_layout_tab_text"), r1, false, "com.obric.memorydata.plugin"), TextView.class, "com.obric.memorydata.plugin");
            this.c = r2;
            r1.addView(r2);
            return;
        L5:
            r1 = this;
            goto L6
        }

        private FrameLayout e() {
            FrameLayout r0 = new FrameLayout((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
            r0.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
            return r0;
        }

        private void f() {
            if (h() == true) goto L6;
            return;
        L6:
            if (this.g == null) goto L9;
        L7:
            g();
            return;
        L9:
            if (this.d == null) goto L20;
            e r0 = this.f4124b;
            if (r0 == null) goto L20;
            if (r0.b() == null) goto L20;
            View r1 = this.e;
            View r2 = this.d;
            if (r1 == r2) goto L18;
            g();
            View r3 = this.d;
        L17:
            b(r3);
            return;
        L18:
            c(r2);
            return;
        L20:
            if (this.c == null) goto L7;
            e r4 = this.f4124b;
            if (r4 == null) goto L7;
            if (r4.e() != 1) goto L7;
            View r5 = this.e;
            r2 = this.c;
            if (r5 == r2) goto L18;
            g();
            r3 = this.c;
            goto L17
        }

        private void g() {
            if (h() == true) goto L5;
            return;
        L5:
            a(true);
            View r0 = this.e;
            if (r0 == null) goto L9;
            com.google.android.material.badge.b.a(this.f, r0);
            this.e = null;
            return;
        }

        private com.google.android.material.badge.a getBadge() {
            return this.f;
        }

        private com.google.android.material.badge.a getOrCreateBadge() {
            if (this.f != null) goto L5;
            this.f = com.google.android.material.badge.a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
        L5:
            f();
            com.google.android.material.badge.a r3 = this.f;
            if (r3 == null) goto L9;
            return r3;
        L9:
            throw new IllegalStateException("Unable to create badge");
        }

        private boolean h() {
            if (this.f == null) goto L5;
            return true;
        L5:
            return false;
        }

        void a() {
            setTab(null);
            setSelected(false);
        }

        final void b() {
            setOrientation(!this.f4123a.t ? 1 : 0);
            TextView r0 = this.h;
            if (r0 == null) goto L5;
        L8:
            ImageView r1 = this.i;
        L9:
            a(r0, r1);
            return;
        L5:
            if (this.i != null) goto L8;
            r0 = this.c;
            r1 = this.d;
            goto L9
        }

        @Override // android.view.ViewGroup, android.view.View
        public void drawableStateChanged() {
            super.drawableStateChanged();
            int[] r0 = getDrawableState();
            Drawable r1 = this.j;
            boolean r2 = false;
            if (r1 != null) goto L5;
        L7:
            if (r2 == false) goto L10;
            invalidate();
            this.f4123a.invalidate();
            return;
        L10:
            return;
        L5:
            if (r1.isStateful() == false) goto L7;
            r2 = false | this.j.setState(r0);
            goto L7
        }

        int getContentHeight() {
            int r3 = 0;
            View[] r1 = {this.c, this.d, this.g};
            int r8 = 0;
            int r2 = 0;
            boolean r5 = false;
        L3:
            if (r3 >= 3) goto L17;
            View r6 = r1[r3];
            if (r6 == null) goto L15;
            if (r6.getVisibility() != 0) goto L15;
            if (r5 == false) goto L10;
            r2 = Math.min(r2, r6.getTop());
        L11:
            if (r5 == false) goto L13;
            r8 = Math.max(r8, r6.getBottom());
        L14:
            r5 = true;
            goto L15
        L13:
            r8 = r6.getBottom();
            goto L14
        L10:
            r2 = r6.getTop();
        L15:
            r3 = r3 + 1;
            goto L3
        L17:
            return r8 - r2;
        }

        int getContentWidth() {
            int r3 = 0;
            View[] r1 = {this.c, this.d, this.g};
            int r8 = 0;
            int r2 = 0;
            boolean r5 = false;
        L3:
            if (r3 >= 3) goto L17;
            View r6 = r1[r3];
            if (r6 == null) goto L15;
            if (r6.getVisibility() != 0) goto L15;
            if (r5 == false) goto L10;
            r2 = Math.min(r2, r6.getLeft());
        L11:
            if (r5 == false) goto L13;
            r8 = Math.max(r8, r6.getRight());
        L14:
            r5 = true;
            goto L15
        L13:
            r8 = r6.getRight();
            goto L14
        L10:
            r2 = r6.getLeft();
        L15:
            r3 = r3 + 1;
            goto L3
        L17:
            return r8 - r2;
        }

        public e getTab() {
            return this.f4124b;
        }

        @Override // android.view.View
        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo r7) {
            super.onInitializeAccessibilityNodeInfo(r7);
            com.google.android.material.badge.a r0 = this.f;
            if (r0 != null) goto L5;
        L7:
            AccessibilityNodeInfoCompat r8 = AccessibilityNodeInfoCompat.wrap(r7);
            r8.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(0, 1, this.f4124b.c(), 1, false, isSelected()));
            if (isSelected() == false) goto L10;
            r8.setClickable(false);
            r8.removeAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_CLICK);
        L10:
            r8.setRoleDescription(ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getString(ZeusTransformUtils.mapRes(R.string.item_view_role_description, TypedValues.Custom.S_STRING, "item_view_role_description")));
            return;
        L5:
            if (r0.isVisible() == false) goto L7;
            r7.setContentDescription(getContentDescription() + ", " + this.f.f());
            goto L7
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onMeasure(int r8, int r9) {
            int r0 = View.MeasureSpec.getSize(r8);
            int r1 = View.MeasureSpec.getMode(r8);
            int r2 = this.f4123a.getTabMaxWidth();
            if (r2 <= 0) goto L7;
            if (r1 == 0) goto L6;
            if (r0 <= r2) goto L7;
        L6:
            r8 = View.MeasureSpec.makeMeasureSpec(this.f4123a.o, Integer.MIN_VALUE);
        L7:
            super.onMeasure(r8, r9);
            if (this.c == null) goto L35;
            float r3 = this.f4123a.l;
            int r4 = this.k;
            ImageView r5 = this.d;
            boolean r6 = true;
            if (r5 != null) goto L12;
        L14:
            TextView r7 = this.c;
            if (r7 != null) goto L17;
        L19:
            float r10 = this.c.getTextSize();
            int r11 = this.c.getLineCount();
            int r12 = TextViewCompat.getMaxLines(this.c);
            if (r3 != r10) goto L24;
            if (r12 < 0) goto L36;
            if (r4 != r12) goto L24;
            return;
        L36:
            return;
        L24:
            if (this.f4123a.s != 1) goto L32;
            if (r3 <= r10) goto L32;
            if (r11 != 1) goto L32;
            Layout r13 = this.c.getLayout();
            if (r13 != null) goto L30;
        L31:
            r6 = false;
            goto L32
        L30:
            if (a(r13, 0, r3) > ((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight())) goto L31;
        L32:
            if (r6 == false) goto L38;
            this.c.setTextSize(0, r3);
            this.c.setMaxLines(r4);
            super.onMeasure(r8, r9);
            return;
        L38:
            return;
        L17:
            if (r7.getLineCount() <= 1) goto L19;
            r3 = this.f4123a.m;
            goto L19
        L12:
            if (r5.getVisibility() != 0) goto L14;
            r4 = 1;
            goto L19
        }

        @Override // android.view.View
        public boolean performClick() {
            boolean r0 = super.performClick();
            if (this.f4124b == null) goto L8;
            if (r0 == true) goto L6;
            playSoundEffect(0);
        L6:
            this.f4124b.f();
            return true;
        L8:
            return r0;
        }

        @Override // android.view.View
        public void setSelected(boolean r3) {
            if (isSelected() == r3) goto L5;
            boolean r0 = true;
        L6:
            super.setSelected(r3);
            if (r0 == false) goto L12;
            if (r3 == false) goto L12;
            if (Build.VERSION.SDK_INT >= 16) goto L12;
            sendAccessibilityEvent(4);
        L12:
            TextView r1 = this.c;
            if (r1 == null) goto L15;
            r1.setSelected(r3);
        L15:
            ImageView r2 = this.d;
            if (r2 == null) goto L18;
            r2.setSelected(r3);
        L18:
            View r4 = this.g;
            if (r4 == null) goto L22;
            r4.setSelected(r3);
            return;
        L22:
            return;
        L5:
            r0 = false;
            goto L6
        }

        void setTab(e r2) {
            if (r2 == this.f4124b) goto L6;
            this.f4124b = r2;
            update();
            return;
        }

        final void update() {
            e r0 = this.f4124b;
            ImageView r1 = null;
            if (r0 == null) goto L5;
            View r2 = r0.a();
        L6:
            if (r2 == null) goto L22;
            ViewParent r3 = r2.getParent();
            if (r3 == this) goto L12;
            if (r3 == null) goto L11;
            ((ViewGroup) ZeusTransformUtils.preCheckCast(r3, ViewGroup.class, "com.obric.memorydata.plugin")).removeView(r2);
        L11:
            addView(r2);
        L12:
            this.g = r2;
            TextView r4 = this.c;
            if (r4 == null) goto L15;
            r4.setVisibility(8);
        L15:
            ImageView r5 = this.d;
            if (r5 == null) goto L18;
            r5.setVisibility(8);
            this.d.setImageDrawable(null);
        L18:
            TextView r6 = (TextView) ZeusTransformUtils.preCheckCast(r2.findViewById(android.R.id.text1), TextView.class, "com.obric.memorydata.plugin");
            this.h = r6;
            if (r6 == null) goto L21;
            this.k = TextViewCompat.getMaxLines(r6);
        L21:
            r1 = (ImageView) ZeusTransformUtils.preCheckCast(r2.findViewById(android.R.id.icon), ImageView.class, "com.obric.memorydata.plugin");
        L26:
            this.i = r1;
            if (this.g == null) goto L29;
            TextView r7 = this.h;
            if (r7 == null) goto L41;
        L42:
            a(r7, this.i);
        L43:
            if (r0 != null) goto L45;
        L47:
            if (r0 != null) goto L49;
        L51:
            boolean r8 = false;
        L52:
            setSelected(r8);
            return;
        L49:
            if (r0.g() == false) goto L51;
            r8 = true;
            goto L52
        L45:
            if (TextUtils.isEmpty(e.b(r0)) == true) goto L47;
            setContentDescription(e.b(r0));
            goto L47
        L41:
            if (this.i == null) goto L43;
        L29:
            if (this.d != null) goto L32;
            c();
        L32:
            if (this.c != null) goto L34;
            d();
            this.k = TextViewCompat.getMaxLines(this.c);
        L34:
            TextViewCompat.setTextAppearance(this.c, this.f4123a.f);
            if (this.f4123a.g == null) goto L37;
            this.c.setTextColor(this.f4123a.g);
        L37:
            a(this.c, this.d);
            f();
            a(this.d);
            a(this.c);
            goto L43
        L22:
            View r9 = this.g;
            if (r9 == null) goto L25;
            removeView(r9);
            this.g = null;
        L25:
            this.h = null;
            goto L26
        L5:
            r2 = null;
            goto L6
        }
    }

    public static class g implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ViewPager f4127a;

        public g(ViewPager r1) {
            this.f4127a = r1;
        }

        @Override // com.google.android.material.tabs.TabLayout.a
        public void a(e r1) {
            this.f4127a.setCurrentItem(r1.c());
        }

        @Override // com.google.android.material.tabs.TabLayout.a
        public void b(e r1) {
        }

        @Override // com.google.android.material.tabs.TabLayout.a
        public void c(e r1) {
        }
    }

    static {
        z = ZeusTransformUtils.mapRes(R.style.Widget_Design_TabLayout, "style", "Widget_Design_TabLayout");
        A = new Pools.SynchronizedPool(16);
    }

    public TabLayout(Context r3) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), null);
    }

    public TabLayout(Context r4, AttributeSet r5) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r5, AttributeSet.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.attr.tabStyle, "attr", "tabStyle"));
    }

    public TabLayout(Context r13, AttributeSet r14, int r15) {
        Context r16 = (Context) ZeusTransformUtils.wrapperContextForParams(r13, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r3 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r14, AttributeSet.class, "com.obric.memorydata.plugin");
        int r6 = z;
        super((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.google.android.material.theme.a.a.a(r16, r3, r15, r6), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r3, r15);
        this.B = new ArrayList();
        this.j = new GradientDrawable();
        this.D = 0;
        this.o = Integer.MAX_VALUE;
        this.v = -1;
        this.K = new ArrayList();
        this.S = new Pools.SimplePool(12);
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        setHorizontalScrollBarEnabled(false);
        d r8 = new d(this, r0);
        this.f4111a = r8;
        super.addView(r8, 0, new FrameLayout.LayoutParams(-2, -1));
        TypedArray r17 = k.a(r0, r3, R.styleable.TabLayout, r15, r6, new int[]{ZeusTransformUtils.mapRes(R.styleable.TabLayout_tabTextAppearance, "styleable", "TabLayout_tabTextAppearance")});
        if (ZeusTransformUtils.instanceOf(getBackground(), ColorDrawable.class) == false) goto L5;
        ColorDrawable r2 = (ColorDrawable) ZeusTransformUtils.preCheckCast(getBackground(), ColorDrawable.class, "com.obric.memorydata.plugin");
        MaterialShapeDrawable r4 = new MaterialShapeDrawable();
        r4.setFillColor(ColorStateList.valueOf(r2.getColor()));
        r4.initializeElevationOverlay(r0);
        r4.setElevation(ViewCompat.getElevation(this));
        ViewCompat.setBackground(this, r4);
    L5:
        setSelectedTabIndicator(com.google.android.material.resources.c.b(r0, r17, ZeusTransformUtils.mapRes(R.styleable.TabLayout_tabIndicator, "styleable", "TabLayout_tabIndicator")));
        setSelectedTabIndicatorColor(r17.getColor(ZeusTransformUtils.mapRes(R.styleable.TabLayout_tabIndicatorColor, "styleable", "TabLayout_tabIndicatorColor"), 0));
        r8.a(r17.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.TabLayout_tabIndicatorHeight, "styleable", "TabLayout_tabIndicatorHeight"), -1));
        setSelectedTabIndicatorGravity(r17.getInt(ZeusTransformUtils.mapRes(R.styleable.TabLayout_tabIndicatorGravity, "styleable", "TabLayout_tabIndicatorGravity"), 0));
        setTabIndicatorAnimationMode(r17.getInt(ZeusTransformUtils.mapRes(R.styleable.TabLayout_tabIndicatorAnimationMode, "styleable", "TabLayout_tabIndicatorAnimationMode"), 0));
        setTabIndicatorFullWidth(r17.getBoolean(ZeusTransformUtils.mapRes(R.styleable.TabLayout_tabIndicatorFullWidth, "styleable", "TabLayout_tabIndicatorFullWidth"), true));
        int r5 = r17.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.TabLayout_tabPadding, "styleable", "TabLayout_tabPadding"), 0);
        this.e = r5;
        this.d = r5;
        this.c = r5;
        this.f4112b = r5;
        this.f4112b = r17.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.TabLayout_tabPaddingStart, "styleable", "TabLayout_tabPaddingStart"), this.f4112b);
        this.c = r17.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.TabLayout_tabPaddingTop, "styleable", "TabLayout_tabPaddingTop"), this.c);
        this.d = r17.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.TabLayout_tabPaddingEnd, "styleable", "TabLayout_tabPaddingEnd"), this.d);
        this.e = r17.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.TabLayout_tabPaddingBottom, "styleable", "TabLayout_tabPaddingBottom"), this.e);
        int r7 = r17.getResourceId(ZeusTransformUtils.mapRes(R.styleable.TabLayout_tabTextAppearance, "styleable", "TabLayout_tabTextAppearance"), ZeusTransformUtils.mapRes(R.style.TextAppearance_Design_Tab, "style", "TextAppearance_Design_Tab"));
        this.f = r7;
        TypedArray r9 = r0.obtainStyledAttributes(r7, R.styleable.TextAppearance);
        this.l = r9.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.TextAppearance_android_textSize, "styleable", "TextAppearance_android_textSize"), 0);     // Catch: Throwable -> L15
        this.g = com.google.android.material.resources.c.a(r0, r9, ZeusTransformUtils.mapRes(R.styleable.TextAppearance_android_textColor, "styleable", "TextAppearance_android_textColor"));     // Catch: Throwable -> L15
        r9.recycle();
        if (r17.hasValue(ZeusTransformUtils.mapRes(R.styleable.TabLayout_tabTextColor, "styleable", "TabLayout_tabTextColor")) == false) goto L11;
        this.g = com.google.android.material.resources.c.a(r0, r17, ZeusTransformUtils.mapRes(R.styleable.TabLayout_tabTextColor, "styleable", "TabLayout_tabTextColor"));
    L11:
        if (r17.hasValue(ZeusTransformUtils.mapRes(R.styleable.TabLayout_tabSelectedTextColor, "styleable", "TabLayout_tabSelectedTextColor")) == false) goto L13;
        this.g = a(this.g.getDefaultColor(), r17.getColor(ZeusTransformUtils.mapRes(R.styleable.TabLayout_tabSelectedTextColor, "styleable", "TabLayout_tabSelectedTextColor"), 0));
    L13:
        this.h = com.google.android.material.resources.c.a(r0, r17, ZeusTransformUtils.mapRes(R.styleable.TabLayout_tabIconTint, "styleable", "TabLayout_tabIconTint"));
        this.k = r.a(r17.getInt(ZeusTransformUtils.mapRes(R.styleable.TabLayout_tabIconTintMode, "styleable", "TabLayout_tabIconTintMode"), -1), null);
        this.i = com.google.android.material.resources.c.a(r0, r17, ZeusTransformUtils.mapRes(R.styleable.TabLayout_tabRippleColor, "styleable", "TabLayout_tabRippleColor"));
        this.q = r17.getInt(ZeusTransformUtils.mapRes(R.styleable.TabLayout_tabIndicatorAnimationDuration, "styleable", "TabLayout_tabIndicatorAnimationDuration"), 300);
        this.E = r17.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.TabLayout_tabMinWidth, "styleable", "TabLayout_tabMinWidth"), -1);
        this.F = r17.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.TabLayout_tabMaxWidth, "styleable", "TabLayout_tabMaxWidth"), -1);
        this.n = r17.getResourceId(ZeusTransformUtils.mapRes(R.styleable.TabLayout_tabBackground, "styleable", "TabLayout_tabBackground"), 0);
        this.H = r17.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.TabLayout_tabContentStart, "styleable", "TabLayout_tabContentStart"), 0);
        this.s = r17.getInt(ZeusTransformUtils.mapRes(R.styleable.TabLayout_tabMode, "styleable", "TabLayout_tabMode"), 1);
        this.p = r17.getInt(ZeusTransformUtils.mapRes(R.styleable.TabLayout_tabGravity, "styleable", "TabLayout_tabGravity"), 0);
        this.t = r17.getBoolean(ZeusTransformUtils.mapRes(R.styleable.TabLayout_tabInlineLabel, "styleable", "TabLayout_tabInlineLabel"), false);
        this.x = r17.getBoolean(ZeusTransformUtils.mapRes(R.styleable.TabLayout_tabUnboundedRipple, "styleable", "TabLayout_tabUnboundedRipple"), false);
        r17.recycle();
        Resources r18 = ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin");
        this.m = r18.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.dimen.design_tab_text_size_2line, "dimen", "design_tab_text_size_2line"));
        this.G = r18.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.dimen.design_tab_scrollable_min_width, "dimen", "design_tab_scrollable_min_width"));
        j();
        return;
    L15:
        th = move-exception;
        r9.recycle();
        throw th;
    }

    private int a(int r5, float r6) {
        int r0 = this.s;
        int r1 = 0;
        if (r0 == 0) goto L7;
        if (r0 == 2) goto L7;
        return 0;
    L7:
        View r2 = this.f4111a.getChildAt(r5);
        if (r2 != null) goto L10;
        return 0;
    L10:
        int r7 = r5 + 1;
        if (r7 >= this.f4111a.getChildCount()) goto L13;
        View r8 = this.f4111a.getChildAt(r7);
    L14:
        int r3 = r2.getWidth();
        if (r8 == null) goto L17;
        r1 = r8.getWidth();
    L17:
        int r9 = (r2.getLeft() + (r3 / 2)) - (getWidth() / 2);
        int r10 = (int) (((r3 + r1) * 0.5f) * r6);
        if (ViewCompat.getLayoutDirection(this) != 0) goto L21;
        return r9 + r10;
    L21:
        return r9 - r10;
    L13:
        r8 = null;
        goto L14
    }

    private static ColorStateList a(int r4, int r5) {
        return new ColorStateList(new int[][]{SELECTED_STATE_SET, EMPTY_STATE_SET}, new int[]{r5, r4});
    }

    static /* synthetic */ com.google.android.material.tabs.c a(TabLayout r0) {
        return r0.I;
    }

    private void a(View r3) {
        if (ZeusTransformUtils.instanceOf(r3, TabItem.class) == false) goto L7;
        a((TabItem) ZeusTransformUtils.preCheckCast(r3, TabItem.class, "com.obric.memorydata.plugin"));
        return;
    L7:
        throw new IllegalArgumentException("Only TabItem instances can be added to TabLayout");
    }

    private void a(LinearLayout.LayoutParams r3) {
        if (this.s == 1) goto L5;
    L7:
        r3.width = -2;
        float r2 = 0.0f;
    L8:
        r3.weight = r2;
        return;
    L5:
        if (this.p != 0) goto L7;
        r3.width = 0;
        r2 = 1.0f;
        goto L8
    }

    private void a(ViewPager r3, boolean r4, boolean r5) {
        ViewPager r0 = this.y;
        if (r0 == null) goto L10;
        TabLayoutOnPageChangeListener r1 = this.P;
        if (r1 == null) goto L7;
        r0.removeOnPageChangeListener(r1);
    L7:
        AdapterChangeListener r2 = this.Q;
        if (r2 == null) goto L10;
        this.y.removeOnAdapterChangeListener(r2);
    L10:
        a r6 = this.L;
        if (r6 == null) goto L13;
        b(r6);
        this.L = null;
    L13:
        if (r3 == null) goto L24;
        this.y = r3;
        if (this.P != null) goto L17;
        this.P = new TabLayoutOnPageChangeListener(this);
    L17:
        this.P.reset();
        r3.addOnPageChangeListener(this.P);
        g r7 = new g(r3);
        this.L = r7;
        a(r7);
        PagerAdapter r8 = r3.getAdapter();
        if (r8 == null) goto L21;
        a(r8, r4);
    L21:
        if (this.Q != null) goto L23;
        this.Q = new AdapterChangeListener(this);
    L23:
        this.Q.setAutoRefresh(r4);
        r3.addOnAdapterChangeListener(this.Q);
        a(r3.getCurrentItem(), 0.0f, true);
    L25:
        this.R = r5;
        return;
    L24:
        this.y = null;
        a(null, false);
        goto L25
    }

    private void a(TabItem r3) {
        e r0 = a();
        if (r3.f4108a == null) goto L6;
        r0.a(r3.f4108a);
    L6:
        if (r3.f4109b == null) goto L9;
        r0.a(r3.f4109b);
    L9:
        if (r3.c == 0) goto L12;
        r0.a(r3.c);
    L12:
        if (TextUtils.isEmpty(r3.getContentDescription()) == true) goto L14;
        r0.b(r3.getContentDescription());
    L14:
        a(r0);
    }

    private void a(e r4, int r5) {
        r4.b(r5);
        this.B.add(r5, r4);
        int r6 = this.B.size();
    L3:
        r5 = r5 + 1;
        if (r5 >= r6) goto L6;
        ((e) ZeusTransformUtils.preCheckCast(this.B.get(r5), e.class, "com.obric.memorydata.plugin")).b(r5);
        goto L3
    }

    static /* synthetic */ int b(TabLayout r0) {
        return r0.D;
    }

    private void b(int r4) {
        f r0 = (f) ZeusTransformUtils.preCheckCast(this.f4111a.getChildAt(r4), f.class, "com.obric.memorydata.plugin");
        this.f4111a.removeViewAt(r4);
        if (r0 == null) goto L5;
        r0.a();
        this.S.release(r0);
    L5:
        requestLayout();
    }

    private void c(int r7) {
        if (r7 != (-1)) goto L6;
        return;
    L6:
        if (getWindowToken() != null) goto L8;
    L17:
        a(r7, 0.0f, true);
        return;
    L8:
        if (ViewCompat.isLaidOut(this) == false) goto L17;
        if (this.f4111a.a() == true) goto L17;
        int r0 = getScrollX();
        int r2 = a(r7, 0.0f);
        if (r0 == r2) goto L15;
        i();
        this.M.setIntValues(new int[]{r0, r2});
        this.M.start();
    L15:
        this.f4111a.a(r7, this.q);
    }

    private f d(e r5) {
        Pools.Pool<f> r0 = this.S;
        if (r0 == null) goto L5;
        f r1 = (f) ZeusTransformUtils.preCheckCast(r0.acquire(), f.class, "com.obric.memorydata.plugin");
    L6:
        if (r1 != null) goto L8;
        r1 = new f(this, (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
    L8:
        r1.setTab(r5);
        r1.setFocusable(true);
        r1.setMinimumWidth(getTabMinWidth());
        if (TextUtils.isEmpty(e.b(r5)) == false) goto L11;
        CharSequence r4 = e.c(r5);
    L12:
        r1.setContentDescription(r4);
        return r1;
    L11:
        r4 = e.b(r5);
        goto L12
    L5:
        r1 = null;
        goto L6
    }

    private void d(int r2) {
        if (r2 != 0) goto L4;
        Log.w("TabLayout", "MODE_SCROLLABLE + GRAVITY_FILL is not supported, GRAVITY_START will be used instead");
    L10:
        this.f4111a.setGravity(GravityCompat.START);
        return;
    L4:
        if (r2 != 1) goto L6;
        this.f4111a.setGravity(1);
        return;
    L6:
        if (r2 == 2) goto L10;
    }

    private void e(e r3) {
        f r0 = r3.f4122b;
        r0.setSelected(false);
        r0.setActivated(false);
        this.f4111a.addView(r0, r3.c(), h());
    }

    private void f(e r5) {
        int r0 = this.K.size() - 1;
    L3:
        if (r0 < 0) goto L5;
        ((a) ZeusTransformUtils.preCheckCast(this.K.get(r0), a.class, "com.obric.memorydata.plugin")).a(r5);
        r0 = r0 - 1;
        goto L3
    }

    private boolean f() {
        if (getTabMode() != 0) goto L5;
    L8:
        return true;
    L5:
        if (getTabMode() == 2) goto L8;
        return false;
    }

    private void g() {
        int r0 = this.B.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        ((e) ZeusTransformUtils.preCheckCast(this.B.get(r1), e.class, "com.obric.memorydata.plugin")).h();
        r1 = r1 + 1;
        goto L3
    }

    private void g(e r5) {
        int r0 = this.K.size() - 1;
    L3:
        if (r0 < 0) goto L5;
        ((a) ZeusTransformUtils.preCheckCast(this.K.get(r0), a.class, "com.obric.memorydata.plugin")).b(r5);
        r0 = r0 - 1;
        goto L3
    }

    private int getDefaultHeight() {
        int r0 = this.B.size();
        boolean r1 = false;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L12;
        e r3 = (e) ZeusTransformUtils.preCheckCast(this.B.get(r2), e.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L11;
        if (r3.b() == null) goto L11;
        if (TextUtils.isEmpty(r3.d()) == true) goto L11;
        r1 = true;
    L11:
        r2 = r2 + 1;
    L12:
        if (r1 == true) goto L14;
    L16:
        return 48;
    L14:
        if (this.t == true) goto L16;
        return 72;
    }

    private int getTabMinWidth() {
        int r0 = this.E;
        if (r0 == (-1)) goto L5;
        return r0;
    L5:
        int r1 = this.s;
        if (r1 == 0) goto L12;
        if (r1 == 2) goto L12;
        return 0;
    L12:
        return this.G;
    }

    private int getTabScrollRange() {
        return Math.max(0, ((this.f4111a.getWidth() - getWidth()) - getPaddingLeft()) - getPaddingRight());
    }

    private LinearLayout.LayoutParams h() {
        LinearLayout.LayoutParams r0 = new LinearLayout.LayoutParams(-2, -1);
        a(r0);
        return r0;
    }

    private void h(e r5) {
        int r0 = this.K.size() - 1;
    L3:
        if (r0 < 0) goto L5;
        ((a) ZeusTransformUtils.preCheckCast(this.K.get(r0), a.class, "com.obric.memorydata.plugin")).c(r5);
        r0 = r0 - 1;
        goto L3
    }

    private void i() {
        if (this.M != null) goto L6;
        ValueAnimator r0 = new ValueAnimator();
        this.M = r0;
        r0.setInterpolator(com.google.android.material.a.a.f3742b);
        this.M.setDuration(this.q);
        this.M.addUpdateListener(new AnonymousClass1(this));
        return;
    }

    private void j() {
        int r0 = this.s;
        if (r0 == 0) goto L7;
        if (r0 == 2) goto L7;
        int r1 = 0;
    L8:
        ViewCompat.setPaddingRelative(this.f4111a, r1, 0, 0, 0);
        int r2 = this.s;
        if (r2 == 0) goto L17;
        if (r2 == 1) goto L14;
        if (r2 == 2) goto L14;
    L18:
        a(true);
        return;
    L14:
        if (this.p != 2) goto L16;
        Log.w("TabLayout", "GRAVITY_START is not supported with the current tab mode, GRAVITY_CENTER will be used instead");
    L16:
        this.f4111a.setGravity(1);
        goto L18
    L17:
        d(this.p);
    L7:
        r1 = Math.max(0, this.H - this.f4112b);
        goto L8
    }

    private void setSelectedTabView(int r7) {
        int r0 = this.f4111a.getChildCount();
        if (r7 >= r0) goto L15;
        int r2 = 0;
    L5:
        if (r2 >= r0) goto L19;
        View r3 = this.f4111a.getChildAt(r2);
        boolean r4 = true;
        if (r2 != r7) goto L9;
        boolean r5 = true;
    L10:
        r3.setSelected(r5);
        if (r2 == r7) goto L14;
        r4 = false;
    L14:
        r3.setActivated(r4);
        r2 = r2 + 1;
        goto L5
    L9:
        r5 = false;
        goto L10
    L19:
        return;
    }

    public e a() {
        e r0 = b();
        r0.f4121a = this;
        r0.f4122b = d(r0);
        if (e.a(r0) == (-1)) goto L5;
        r0.f4122b.setId(e.a(r0));
    L5:
        return r0;
    }

    public e a(int r2) {
        if (r2 >= 0) goto L4;
    L7:
        return null;
    L4:
        if (r2 >= getTabCount()) goto L7;
        return (e) ZeusTransformUtils.preCheckCast(this.B.get(r2), e.class, "com.obric.memorydata.plugin");
    }

    public void a(int r2, float r3, boolean r4) {
        a(r2, r3, r4, true);
    }

    public void a(int r3, float r4, boolean r5, boolean r6) {
        int r0 = Math.round(r3 + r4);
        if (r0 >= 0) goto L5;
        return;
    L5:
        if (r0 >= this.f4111a.getChildCount()) goto L24;
        if (r6 == false) goto L9;
        this.f4111a.a(r3, r4);
    L9:
        ValueAnimator r7 = this.M;
        if (r7 == null) goto L15;
        if (r7.isRunning() == false) goto L15;
        this.M.cancel();
    L15:
        if (r3 >= 0) goto L17;
        int r8 = 0;
    L18:
        scrollTo(r8, 0);
        if (r5 == false) goto L23;
        setSelectedTabView(r0);
        return;
    L23:
        return;
    L17:
        r8 = a(r3, r4);
        goto L18
    }

    void a(PagerAdapter r3, boolean r4) {
        PagerAdapter r0 = this.N;
        if (r0 == null) goto L7;
        DataSetObserver r1 = this.O;
        if (r1 == null) goto L7;
        r0.unregisterDataSetObserver(r1);
    L7:
        this.N = r3;
        if (r4 == false) goto L14;
        if (r3 == null) goto L14;
        if (this.O != null) goto L13;
        this.O = new c(this);
    L13:
        r3.registerDataSetObserver(this.O);
    L14:
        e();
    }

    public void a(ViewPager r2, boolean r3) {
        a(r2, r3, false);
    }

    @Deprecated
    public void a(a r3) {
        a r4 = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.memorydata.plugin");
        if (this.K.contains(r4) == true) goto L6;
        this.K.add(r4);
        return;
    }

    public void a(b r3) {
        a((b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.memorydata.plugin"));
    }

    public void a(e r2) {
        a(r2, this.B.isEmpty());
    }

    public void a(e r2, int r3, boolean r4) {
        if (r2.f4121a != this) goto L9;
        a(r2, r3);
        e(r2);
        if (r4 == false) goto L10;
        r2.f();
        return;
    L10:
        return;
    L9:
        throw new IllegalArgumentException("Tab belongs to a different TabLayout.");
    }

    public void a(e r2, boolean r3) {
        a(r2, this.B.size(), r3);
    }

    void a(boolean r6) {
        int r0 = 0;
    L4:
        if (r0 >= this.f4111a.getChildCount()) goto L9;
        View r1 = this.f4111a.getChildAt(r0);
        r1.setMinimumWidth(getTabMinWidth());
        a((LinearLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r1.getLayoutParams(), LinearLayout.LayoutParams.class, "com.obric.memorydata.plugin"));
        if (r6 == false) goto L8;
        r1.requestLayout();
    L8:
        r0 = r0 + 1;
        goto L4
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View r1) {
        a(r1);
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View r1, int r2) {
        a(r1);
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View r1, int r2, ViewGroup.LayoutParams r3) {
        a(r1);
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup, android.view.ViewManager
    public void addView(View r1, ViewGroup.LayoutParams r2) {
        a(r1);
    }

    public e b() {
        e r2 = (e) ZeusTransformUtils.preCheckCast(A.acquire(), e.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L5;
        return r2;
    L5:
        return new e();
    }

    @Deprecated
    public void b(a r3) {
        a r4 = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.memorydata.plugin");
        this.K.remove(r4);
    }

    public void b(e r5, boolean r6) {
        e r0 = this.C;
        if (r0 != r5) goto L7;
        if (r0 == null) goto L25;
        h(r5);
        c(r5.c());
        return;
    L25:
        return;
    L7:
        if (r5 == null) goto L9;
        int r2 = r5.c();
    L10:
        if (r6 == false) goto L19;
        if (r0 != null) goto L13;
    L14:
        if (r2 == (-1)) goto L16;
        a(r2, 0.0f, true);
    L17:
        if (r2 == (-1)) goto L19;
        setSelectedTabView(r2);
    L16:
        c(r2);
        goto L17
    L13:
        if (r0.c() != (-1)) goto L16;
    L19:
        this.C = r5;
        if (r0 == null) goto L22;
        g(r0);
    L22:
        if (r5 == null) goto L27;
        f(r5);
        return;
    L27:
        return;
    L9:
        r2 = -1;
        goto L10
    }

    public boolean b(e r1) {
        return A.release(r1);
    }

    public void c() {
        int r0 = this.f4111a.getChildCount() - 1;
    L3:
        if (r0 < 0) goto L5;
        b(r0);
        r0 = r0 - 1;
        goto L3
    L5:
        Iterator<e> r1 = this.B.iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        e r2 = (e) ZeusTransformUtils.preCheckCast(r1.next(), e.class, "com.obric.memorydata.plugin");
        r1.remove();
        r2.i();
        b(r2);
        goto L7
    L9:
        this.C = null;
    }

    public void c(e r2) {
        b(r2, true);
    }

    public boolean d() {
        return this.u;
    }

    void e() {
        c();
        PagerAdapter r0 = this.N;
        if (r0 == null) goto L17;
        int r1 = r0.getCount();
        int r2 = 0;
    L5:
        if (r2 >= r1) goto L7;
        a(a().a(this.N.getPageTitle(r2)), false);
        r2 = r2 + 1;
        goto L5
    L7:
        ViewPager r3 = this.y;
        if (r3 == null) goto L18;
        if (r1 <= 0) goto L19;
        int r4 = r3.getCurrentItem();
        if (r4 != getSelectedTabPosition()) goto L13;
        return;
    L13:
        if (r4 >= getTabCount()) goto L21;
        c(a(r4));
        return;
    L21:
        return;
    L19:
        return;
    L18:
        return;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet r3) {
        return generateLayoutParams((AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.memorydata.plugin"));
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet r3) {
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.memorydata.plugin");
        return generateDefaultLayoutParams();
    }

    public int getSelectedTabPosition() {
        e r0 = this.C;
        if (r0 != null) goto L7;
        return -1;
    L7:
        return r0.c();
    }

    public int getTabCount() {
        return this.B.size();
    }

    public int getTabGravity() {
        return this.p;
    }

    public ColorStateList getTabIconTint() {
        return this.h;
    }

    public int getTabIndicatorAnimationMode() {
        return this.w;
    }

    public int getTabIndicatorGravity() {
        return this.r;
    }

    int getTabMaxWidth() {
        return this.o;
    }

    public int getTabMode() {
        return this.s;
    }

    public ColorStateList getTabRippleColor() {
        return this.i;
    }

    public Drawable getTabSelectedIndicator() {
        return this.j;
    }

    public ColorStateList getTabTextColors() {
        return this.g;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        h.a(this);
        if (this.y != null) goto L8;
        ViewParent r0 = getParent();
        if (ZeusTransformUtils.instanceOf(r0, ViewPager.class) == false) goto L9;
        a((ViewPager) ZeusTransformUtils.preCheckCast(r0, ViewPager.class, "com.obric.memorydata.plugin"), true, true);
        return;
    L9:
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.R == false) goto L6;
        setupWithViewPager(null);
        this.R = false;
        return;
    }

    @Override // android.view.View
    public void onDraw(Canvas r5) {
        int r0 = 0;
    L4:
        if (r0 >= this.f4111a.getChildCount()) goto L9;
        View r1 = this.f4111a.getChildAt(r0);
        if (ZeusTransformUtils.instanceOf(r1, f.class) == false) goto L8;
        f.a((f) ZeusTransformUtils.preCheckCast(r1, f.class, "com.obric.memorydata.plugin"), r5);
    L8:
        r0 = r0 + 1;
        goto L4
    L9:
        super.onDraw(r5);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo r3) {
        super.onInitializeAccessibilityNodeInfo(r3);
        AccessibilityNodeInfoCompat.wrap(r3).setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(1, getTabCount(), false, 1));
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent r2) {
        if (f() == true) goto L5;
    L7:
        return false;
    L5:
        if (super.onInterceptTouchEvent(r2) == false) goto L7;
        return true;
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    public void onMeasure(int r8, int r9) {
        int r0 = Math.round(r.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), getDefaultHeight()));
        int r2 = View.MeasureSpec.getMode(r9);
        boolean r5 = false;
        if (r2 == Integer.MIN_VALUE) goto L8;
        if (r2 != 0) goto L12;
        r9 = View.MeasureSpec.makeMeasureSpec((r0 + getPaddingTop()) + getPaddingBottom(), 1073741824);
    L12:
        int r1 = View.MeasureSpec.getSize(r8);
        if (View.MeasureSpec.getMode(r8) == 0) goto L19;
        int r3 = this.F;
        if (r3 > 0) goto L18;
        r3 = (int) (r1 - r.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), 56));
    L18:
        this.o = r3;
    L19:
        super.onMeasure(r8, r9);
        if (getChildCount() != 1) goto L36;
        View r10 = getChildAt(0);
        int r4 = this.s;
        if (r4 == 0) goto L31;
        if (r4 == 1) goto L28;
        if (r4 == 2) goto L31;
    L33:
        if (r5 == false) goto L37;
        r10.measure(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), getChildMeasureSpec(r9, getPaddingTop() + getPaddingBottom(), r10.getLayoutParams().height));
        return;
    L37:
        return;
    L28:
        if (r10.getMeasuredWidth() == getMeasuredWidth()) goto L33;
    L29:
        r5 = true;
    L31:
        if (r10.getMeasuredWidth() >= getMeasuredWidth()) goto L33;
    L36:
        return;
    L8:
        if (getChildCount() != 1) goto L12;
        if (View.MeasureSpec.getSize(r9) < r0) goto L12;
        getChildAt(0).setMinimumHeight(r0);
        goto L12
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent r3) {
        if (r3.getActionMasked() != 8) goto L9;
        if (f() == true) goto L9;
        return false;
    L9:
        return super.onTouchEvent(r3);
    }

    @Override // android.view.View
    public void setElevation(float r1) {
        super.setElevation(r1);
        h.a(this, r1);
    }

    public void setInlineLabel(boolean r4) {
        if (this.t == r4) goto L16;
        this.t = r4;
        int r5 = 0;
    L6:
        if (r5 >= this.f4111a.getChildCount()) goto L11;
        View r0 = this.f4111a.getChildAt(r5);
        if (ZeusTransformUtils.instanceOf(r0, f.class) == false) goto L10;
        ((f) ZeusTransformUtils.preCheckCast(r0, f.class, "com.obric.memorydata.plugin")).b();
    L10:
        r5 = r5 + 1;
        goto L6
    L11:
        j();
        return;
    }

    public void setInlineLabelResource(int r2) {
        setInlineLabel(ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getBoolean(r2));
    }

    @Deprecated
    public void setOnTabSelectedListener(a r3) {
        a r4 = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.memorydata.plugin");
        a r0 = this.f4110J;
        if (r0 == null) goto L5;
        b(r0);
    L5:
        this.f4110J = r4;
        if (r4 == null) goto L9;
        a(r4);
        return;
    }

    @Deprecated
    public void setOnTabSelectedListener(b r3) {
        setOnTabSelectedListener((b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.memorydata.plugin"));
    }

    void setScrollAnimatorListener(Animator.AnimatorListener r3) {
        Animator.AnimatorListener r4 = (Animator.AnimatorListener) ZeusTransformUtils.wrapperContextForParams(r3, Animator.AnimatorListener.class, "com.obric.memorydata.plugin");
        i();
        this.M.addListener(r4);
    }

    public void setSelectedTabIndicator(int r4) {
        if (r4 == 0) goto L4;
        Drawable r5 = AppCompatResources.getDrawable((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r4);
    L5:
        setSelectedTabIndicator(r5);
        return;
    L4:
        r5 = null;
        goto L5
    }

    public void setSelectedTabIndicator(Drawable r3) {
        if (this.j == r3) goto L13;
        if (r3 != null) goto L7;
        r3 = new GradientDrawable();
    L7:
        this.j = r3;
        int r0 = this.v;
        if (r0 != (-1)) goto L11;
        r0 = r3.getIntrinsicHeight();
    L11:
        this.f4111a.a(r0);
        return;
    }

    public void setSelectedTabIndicatorColor(int r1) {
        this.D = r1;
        a(false);
    }

    public void setSelectedTabIndicatorGravity(int r2) {
        if (this.r == r2) goto L6;
        this.r = r2;
        ViewCompat.postInvalidateOnAnimation(this.f4111a);
        return;
    }

    @Deprecated
    public void setSelectedTabIndicatorHeight(int r1) {
        this.v = r1;
        this.f4111a.a(r1);
    }

    public void setTabGravity(int r2) {
        if (this.p == r2) goto L6;
        this.p = r2;
        j();
        return;
    }

    public void setTabIconTint(ColorStateList r2) {
        if (this.h == r2) goto L6;
        this.h = r2;
        g();
        return;
    }

    public void setTabIconTintResource(int r4) {
        setTabIconTint(AppCompatResources.getColorStateList((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r4));
    }

    public void setTabIndicatorAnimationMode(int r2) {
        this.w = r2;
        if (r2 != 0) goto L5;
        com.google.android.material.tabs.c r3 = new com.google.android.material.tabs.c();
    L13:
        this.I = r3;
        return;
    L5:
        if (r2 != 1) goto L7;
        r3 = new com.google.android.material.tabs.a();
        goto L13
    L7:
        if (r2 != 2) goto L10;
        r3 = new com.google.android.material.tabs.b();
        goto L13
    L10:
        throw new IllegalArgumentException(r2 + " is not a valid TabIndicatorAnimationMode");
    }

    public void setTabIndicatorFullWidth(boolean r1) {
        this.u = r1;
        d.a(this.f4111a);
        ViewCompat.postInvalidateOnAnimation(this.f4111a);
    }

    public void setTabMode(int r2) {
        if (r2 == this.s) goto L6;
        this.s = r2;
        j();
        return;
    }

    public void setTabRippleColor(ColorStateList r5) {
        if (this.i == r5) goto L11;
        this.i = r5;
        int r6 = 0;
    L6:
        if (r6 >= this.f4111a.getChildCount()) goto L15;
        View r0 = this.f4111a.getChildAt(r6);
        if (ZeusTransformUtils.instanceOf(r0, f.class) == false) goto L10;
        f.a((f) ZeusTransformUtils.preCheckCast(r0, f.class, "com.obric.memorydata.plugin"), (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
    L10:
        r6 = r6 + 1;
        goto L6
    L15:
        return;
    }

    public void setTabRippleColorResource(int r4) {
        setTabRippleColor(AppCompatResources.getColorStateList((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r4));
    }

    public void setTabTextColors(ColorStateList r2) {
        if (this.g == r2) goto L6;
        this.g = r2;
        g();
        return;
    }

    @Deprecated
    public void setTabsFromPagerAdapter(PagerAdapter r2) {
        a(r2, false);
    }

    public void setUnboundedRipple(boolean r5) {
        if (this.x == r5) goto L11;
        this.x = r5;
        int r6 = 0;
    L6:
        if (r6 >= this.f4111a.getChildCount()) goto L15;
        View r0 = this.f4111a.getChildAt(r6);
        if (ZeusTransformUtils.instanceOf(r0, f.class) == false) goto L10;
        f.a((f) ZeusTransformUtils.preCheckCast(r0, f.class, "com.obric.memorydata.plugin"), (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
    L10:
        r6 = r6 + 1;
        goto L6
    L15:
        return;
    }

    public void setUnboundedRippleResource(int r2) {
        setUnboundedRipple(ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getBoolean(r2));
    }

    public void setupWithViewPager(ViewPager r2) {
        a(r2, true);
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        if (getTabScrollRange() <= 0) goto L5;
        return true;
    L5:
        return false;
    }
}
