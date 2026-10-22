package com.obric.oui.tab;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ArgbEvaluator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
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
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.TooltipCompat;
import androidx.core.content.ContextCompat;
import androidx.core.util.Pools;
import androidx.core.view.GravityCompat;
import androidx.core.view.PointerIconCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TextViewCompat;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.obric.oui.layout.OUILinearLayout;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import o9.q;
import u8.l;

/* JADX INFO: loaded from: classes2.dex */
@ViewPager.DecorView
public class OTabLayoutBase extends HorizontalScrollView implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    private static final Interpolator f7513p0 = null;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    private static final Pools.Pool<i> f7514q0 = null;
    private int A;
    int B;
    int C;
    int D;
    boolean E;
    private e F;
    private final ArrayList<e> G;
    private e H;
    private ValueAnimator I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    ViewPager f7515J;
    private PagerAdapter K;
    private DataSetObserver L;
    TabLayoutOnPageChangeListener M;
    private AdapterChangeListener N;
    private boolean O;
    private boolean P;
    private int Q;
    private int R;
    private float S;
    private float T;
    private float U;
    private final Paint V;
    private final Paint W;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    private final RectF f7516a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    private int f7517b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ArrayList<i> f7518c;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    private boolean f7519c0;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    private boolean f7520d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    private boolean f7521e0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    private final Rect f7522f0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private i f7523g;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    private final Paint f7524g0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private i f7525h;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    private final ValueAnimator f7526h0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final h f7527i;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    private final PathInterpolator f7528i0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f7529j;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    private final c f7530j0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f7531k;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    private final c f7532k0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f7533l;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    private int f7534l0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    int f7535m;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    private d f7536m0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    int f7537n;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    private final Pools.Pool<j> f7538n0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    int f7539o;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    private int f7540o0;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    int f7541p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @Deprecated
    int f7542q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    ColorStateList f7543r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    float f7544s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    float f7545t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    int f7546u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    int f7547v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    int f7548w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private int f7549x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private int f7550y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private final int f7551z;

    private class AdapterChangeListener implements ViewPager.OnAdapterChangeListener {
        private boolean mAutoRefresh;
        final /* synthetic */ OTabLayoutBase this$0;

        AdapterChangeListener(OTabLayoutBase r10) {
            this.this$0 = r10;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnAdapterChangeListener
        public void onAdapterChanged(@NonNull ViewPager r10, @Nullable PagerAdapter r11, @Nullable PagerAdapter r12) {
            OTabLayoutBase r13 = this.this$0;
            if (r13.f7515J != r10) goto L6;
            r13.P(r12, this.mAutoRefresh);
            return;
        }

        void setAutoRefresh(boolean r10) {
            this.mAutoRefresh = r10;
        }
    }

    public static class TabLayoutOnPageChangeListener implements ViewPager.OnPageChangeListener {
        private int mEndColor;
        private DecelerateInterpolator mEndInterpolator;
        private ArgbEvaluator mEvaluator;
        private int mPreviousScrollState;
        private int mScrollState;
        private int mStartColor;
        private AccelerateInterpolator mStartInterpolator;
        private final WeakReference<OTabLayoutBase> mTabLayoutRef;

        public TabLayoutOnPageChangeListener(OTabLayoutBase r10) {
            this.mEvaluator = new ArgbEvaluator();
            this.mStartInterpolator = new AccelerateInterpolator();
            this.mEndInterpolator = new DecelerateInterpolator(1.6f);
            this.mTabLayoutRef = new WeakReference(r10);
            this.mStartColor = r10.getTabTextColors().getColorForState(OTabLayoutBase.i(), 0);
            this.mEndColor = r10.getTabTextColors().getDefaultColor();
        }

        private void changeTabColor(@Nullable ImageView r10, @Nullable TextView r11, @ColorInt int r12) {
            if (r10 == null) goto L7;
            if (r11 == null) goto L8;
            r11.setTextColor(r12);
            r10.setImageAlpha(Color.alpha(r12));
            return;
        L8:
            return;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int r10) {
            this.mPreviousScrollState = this.mScrollState;
            this.mScrollState = r10;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int r11, float r12, int r13) {
            OTabLayoutBase r14 = this.mTabLayoutRef.get();
            if (r14 == null) goto L34;
            int r10 = this.mScrollState;
            if (r10 == 2) goto L7;
        L10:
            boolean r15 = true;
        L11:
            if (r10 == 2) goto L13;
        L16:
            boolean r16 = true;
        L17:
            r14.R(r11, r12, r15, r16);
            if (this.mScrollState == 2) goto L20;
        L22:
            OTabLayoutBase.g(r14).f7574w = true;
            View r17 = OTabLayoutBase.g(r14).getChildAt(OTabLayoutBase.g(r14).f7565n);
            View r18 = OTabLayoutBase.g(r14).getChildAt(OTabLayoutBase.g(r14).f7565n + 1);
            if (r17 == null) goto L30;
            if (r18 == null) goto L30;
            int r19 = u8.f.layout_tab_indicator;
            View r20 = r17.findViewById(r19);
            View r21 = r18.findViewById(r19);
            if (r20 == null) goto L32;
            if (r21 == null) goto L32;
            float r110 = r17.getLeft() + ((r17.getWidth() - r20.getWidth()) / 2);
            float r22 = r20.getWidth() + r110;
            float r23 = r18.getLeft() + ((r18.getWidth() - r21.getWidth()) / 2);
            float r24 = r21.getWidth() + r23;
            int r25 = u8.f.tab_item_img;
            ImageView r26 = (ImageView) r20.findViewById(r25);
            int r27 = u8.f.tab_item_text;
            TextView r28 = (TextView) r20.findViewById(r27);
            ImageView r29 = (ImageView) r21.findViewById(r25);
            TextView r30 = (TextView) r21.findViewById(r27);
            changeTabColor(r26, r28, ((Integer) this.mEvaluator.evaluate(r12, Integer.valueOf(this.mStartColor), Integer.valueOf(this.mEndColor))).intValue());
            changeTabColor(r29, r30, ((Integer) this.mEvaluator.evaluate(r12, Integer.valueOf(this.mEndColor), Integer.valueOf(this.mStartColor))).intValue());
            h.b(OTabLayoutBase.g(r14), r110 + ((r23 - r110) * this.mStartInterpolator.getInterpolation(r12)));
            h.c(OTabLayoutBase.g(r14), r22 + ((r24 - r22) * this.mStartInterpolator.getInterpolation(r12)));
        L32:
            ViewCompat.postInvalidateOnAnimation(OTabLayoutBase.g(r14));
            return;
        L30:
            if (OTabLayoutBase.c(r14) == false) goto L32;
        L21:
            OTabLayoutBase.g(r14).f7574w = false;
            goto L32
        L20:
            if (this.mPreviousScrollState != 0) goto L22;
        L13:
            if (this.mPreviousScrollState != 0) goto L16;
            r16 = false;
            goto L17
        L7:
            if (this.mPreviousScrollState == 1) goto L10;
            r15 = false;
            goto L11
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int r10) {
            OTabLayoutBase r11 = this.mTabLayoutRef.get();
            if (r11 != null) goto L5;
            return;
        L5:
            if (r11.getSelectedTabPosition() != r10) goto L7;
            return;
        L7:
            if (r10 >= r11.getTabCount()) goto L21;
            int r12 = this.mScrollState;
            if (r12 != 0) goto L11;
        L16:
            boolean r13 = true;
        L17:
            r11.O(r11.G(r10), r13);
            return;
        L11:
            if (r12 == 2) goto L13;
        L15:
            r13 = false;
            goto L17
        L13:
            if (this.mPreviousScrollState != 0) goto L15;
        }

        void reset() {
            this.mPreviousScrollState = 0;
            this.mScrollState = 0;
        }
    }

    public static class TabLayoutOnPageChangeListenerIndependent implements ViewPager.OnPageChangeListener {
        final boolean isRtl;
        private int lastPosition;
        private int mPreviousScrollState;
        private int mScrollState;
        private final WeakReference<OTabLayoutBase> mTabLayoutRef;

        class a implements Animator.AnimatorListener {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ OTabLayoutBase f7552c;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ int f7553g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            final /* synthetic */ boolean f7554h;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            final /* synthetic */ boolean f7555i;

            a(TabLayoutOnPageChangeListenerIndependent r10, OTabLayoutBase r11, int r12, boolean r13, boolean r14) {
                this.f7552c = r11;
                this.f7553g = r12;
                this.f7554h = r13;
                this.f7555i = r14;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator r10) {
                this.f7552c.R(this.f7553g, 0.0f, this.f7554h, this.f7555i);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator r10) {
                this.f7552c.R(this.f7553g, 0.0f, this.f7554h, this.f7555i);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator r10) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator r10) {
            }
        }

        public TabLayoutOnPageChangeListenerIndependent(OTabLayoutBase r10) {
            boolean r11 = false;
            this.lastPosition = 0;
            this.mTabLayoutRef = new WeakReference(r10);
            if (ViewCompat.getLayoutDirection(r10) != 1) goto L5;
            r11 = true;
        L5:
            this.isRtl = r11;
        }

        public static /* synthetic */ void a(TabLayoutOnPageChangeListenerIndependent r10, int r11, int r12, OTabLayoutBase r13, boolean r14, boolean r15, ValueAnimator r16) {
            r10.lambda$onPageScrolled$0(r11, r12, r13, r14, r15, r16);
        }

        private /* synthetic */ void lambda$onPageScrolled$0(int r10, int r11, OTabLayoutBase r12, boolean r13, boolean r14, ValueAnimator r15) {
            float r16 = ((Float) r15.getAnimatedValue()).floatValue();
            if (r10 < r11) goto L5;
        L7:
            r16 = 1.0f - r16;
        L8:
            r12.R(r11, r16, r13, r14);
            return;
        L5:
            if (this.isRtl == true) goto L7;
            r11 = r11 - 1;
            goto L8
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int r10) {
            this.mPreviousScrollState = this.mScrollState;
            this.mScrollState = r10;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(final int r11, float r12, int r13) {
            final OTabLayoutBase r14 = this.mTabLayoutRef.get();
            if (this.lastPosition != r11) goto L5;
            return;
        L5:
            if (r14 == null) goto L21;
            int r15 = this.mScrollState;
            if (r15 == 2) goto L9;
        L12:
            boolean r10 = true;
        L13:
            if (r15 == 2) goto L15;
        L18:
            boolean r16 = true;
        L19:
            ValueAnimator r17 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f}).setDuration(200);
            final int r18 = this.lastPosition;
            final boolean r19 = r10;
            final boolean r20 = r16;
            r17.addUpdateListener(new com.obric.oui.tab.a(this, r18, r11, r14, r19, r20));
            this.lastPosition = r11;
            r17.addListener(new a(this, r14, r11, r10, r16));
            r17.start();
            return;
        L15:
            if (this.mPreviousScrollState != 0) goto L18;
            r16 = false;
            goto L19
        L9:
            if (this.mPreviousScrollState == 1) goto L12;
            r10 = false;
            goto L13
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int r10) {
            OTabLayoutBase r11 = this.mTabLayoutRef.get();
            if (r11 != null) goto L5;
            return;
        L5:
            if (r11.getSelectedTabPosition() != r10) goto L7;
            return;
        L7:
            if (r10 >= r11.getTabCount()) goto L21;
            int r12 = this.mScrollState;
            if (r12 != 0) goto L11;
        L16:
            boolean r13 = true;
        L17:
            r11.O(r11.G(r10), r13);
            return;
        L11:
            if (r12 == 2) goto L13;
        L15:
            r13 = false;
            goto L17
        L13:
            if (this.mPreviousScrollState != 0) goto L15;
        }

        void reset() {
            this.mPreviousScrollState = 0;
            this.mScrollState = 0;
        }
    }

    class a implements View.OnTouchListener {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f7556c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ OTabLayoutBase f7557g;

        a(OTabLayoutBase r10, int r11) {
            this.f7557g = r10;
            this.f7556c = r11;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View r10, MotionEvent r11) {
            int r12 = r11.getAction();
            if (r12 != 0) goto L5;
            OTabLayoutBase r13 = this.f7557g;
            int r14 = this.f7556c;
        L11:
            OTabLayoutBase.a(r13, r14);
            this.f7557g.postInvalidate();
            return false;
        L5:
            if (r12 != 1) goto L7;
        L9:
            r13 = this.f7557g;
            r14 = -1;
            goto L11
        L7:
            if (r12 == 3) goto L9;
            return false;
        }
    }

    class b implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ OTabLayoutBase f7558c;

        b(OTabLayoutBase r10) {
            this.f7558c = r10;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator r10) {
            this.f7558c.scrollTo(((Integer) r10.getAnimatedValue()).intValue(), 0);
        }
    }

    public class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f7559a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f7560b;

        public c(OTabLayoutBase r10) {
            this.f7559a = 0.0f;
            this.f7560b = 0.0f;
        }

        public String toString() {
            return "(left = " + this.f7559a + ", right = " + this.f7560b + ")";
        }
    }

    public interface d {
        void a(i r10);
    }

    public interface e {
        void a(i r10);

        void b(i r10);

        void c(i r10);
    }

    private class f extends DataSetObserver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OTabLayoutBase f7561a;

        f(OTabLayoutBase r10) {
            this.f7561a = r10;
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            this.f7561a.J();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            this.f7561a.J();
        }
    }

    public class g implements TypeEvaluator<c> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OTabLayoutBase f7562a;

        public g(OTabLayoutBase r10) {
            this.f7562a = r10;
        }

        public c a(float r10, c r11, c r12) {
            float r13 = r11.f7559a;
            float r14 = r13 + ((r12.f7559a - r13) * r10);
            float r15 = r11.f7560b;
            float r16 = r15 + (r10 * (r12.f7560b - r15));
            c r17 = new c(this.f7562a);
            r17.f7559a = r14;
            r17.f7560b = r16;
            return r17;
        }

        @Override // android.animation.TypeEvaluator
        public /* bridge */ /* synthetic */ c evaluate(float r10, c r11, c r12) {
            return a(r10, r11, r12);
        }
    }

    private class h extends OUILinearLayout {
        private Paint A;
        private Paint B;
        private final float C;
        private boolean D;
        final /* synthetic */ OTabLayoutBase E;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private int f7563l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private final Paint f7564m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        int f7565n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        float f7566o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private int f7567p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        private int f7568q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        private int f7569r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        private ValueAnimator f7570s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        private int f7571t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        private float f7572u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        private float f7573v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public boolean f7574w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        private boolean f7575x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        private boolean f7576y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        private boolean f7577z;

        class a implements ValueAnimator.AnimatorUpdateListener {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ int f7578c;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ int f7579g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            final /* synthetic */ int f7580h;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            final /* synthetic */ int f7581i;

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            final /* synthetic */ h f7582j;

            a(h r10, int r11, int r12, int r13, int r14) {
                this.f7582j = r10;
                this.f7578c = r11;
                this.f7579g = r12;
                this.f7580h = r13;
                this.f7581i = r14;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator r10) {
                float r11 = r10.getAnimatedFraction();
                h r12 = this.f7582j;
                r12.h(r12.g(this.f7578c, this.f7579g, r11), this.f7582j.g(this.f7580h, this.f7581i, r11));
            }
        }

        class b extends AnimatorListenerAdapter {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ int f7583c;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ h f7584g;

            b(h r10, int r11) {
                this.f7584g = r10;
                this.f7583c = r11;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator r10) {
                h r11 = this.f7584g;
                r11.f7565n = this.f7583c;
                r11.f7566o = 0.0f;
            }
        }

        h(OTabLayoutBase r10, Context r11) {
            this.E = r10;
            super(r11);
            this.f7565n = -1;
            this.f7567p = -1;
            this.f7568q = -1;
            this.f7569r = -1;
            r10.D(27);
            this.f7571t = Integer.MAX_VALUE;
            setWillNotDraw(false);
            this.f7564m = new Paint();
            this.C = r10.E(0.6f);
        }

        static /* synthetic */ float b(h r10, float r11) {
            r10.f7572u = r11;
            return r11;
        }

        static /* synthetic */ float c(h r10, float r11) {
            r10.f7573v = r11;
            return r11;
        }

        private void q() {
            View r10 = getChildAt(this.f7565n);
            int r11 = -1;
            if (r10 != null) goto L5;
        L11:
            int r12 = -1;
        L12:
            h(r11, r12);
            return;
        L5:
            if (r10.getWidth() <= 0) goto L11;
            r11 = r10.getLeft();
            r12 = r10.getRight();
            if (this.f7566o <= 0.0f) goto L12;
            if (this.f7565n >= (getChildCount() - 1)) goto L12;
            View r13 = getChildAt(this.f7565n + 1);
            float r14 = this.f7566o * r13.getLeft();
            float r15 = this.f7566o;
            r11 = (int) (r14 + ((1.0f - r15) * r11));
            r12 = (int) ((r15 * r13.getRight()) + ((1.0f - this.f7566o) * r12));
            goto L12
        }

        void d(int r10, int r11) {
            ValueAnimator r12 = this.f7570s;
            if (r12 == null) goto L8;
            if (r12.isRunning() == false) goto L8;
            this.f7570s.cancel();
        L8:
            if (ViewCompat.getLayoutDirection(this) != 1) goto L10;
            boolean r13 = true;
        L11:
            View r14 = getChildAt(r10);
            if (r14 != null) goto L15;
            q();
            return;
        L15:
            int r15 = r14.getLeft();
            int r16 = r14.getRight();
            if (Math.abs(r10 - this.f7565n) > 1) goto L18;
            int r17 = this.f7568q;
            int r18 = this.f7569r;
        L26:
            if (r17 != r15) goto L28;
            if (r18 != r16) goto L28;
            return;
        L28:
            ValueAnimator r19 = new ValueAnimator();
            this.f7570s = r19;
            r19.setInterpolator(OTabLayoutBase.h());
            r19.setDuration(r11);
            r19.setFloatValues(new float[]{0.0f, 1.0f});
            r19.addUpdateListener(new a(this, r17, r15, r18, r16));
            r19.addListener(new b(this, r10));
            r19.start();
            return;
        L18:
            int r20 = this.E.D(24);
            if (r10 >= this.f7565n) goto L22;
            if (r13 == true) goto L24;
        L23:
            r17 = r20 + r16;
        L25:
            r18 = r17;
        L24:
            r17 = r15 - r20;
            goto L25
        L22:
            if (r13 == false) goto L24;
        L10:
            r13 = false;
            goto L11
        }

        @Override // com.obric.oui.layout.OUILinearLayout, android.view.View
        public void draw(Canvas r18) {
            super.draw(r18);
            if (this.f7575x == false) goto L6;
            r18.drawLine(getLeft(), getBottom() - this.E.E(0.6f), getRight() * 2, getBottom(), this.A);
        L6:
            if (this.f7576y == false) goto L8;
            r18.drawLine(getLeft(), this.C + getTop(), getRight() * 2, this.C + getTop(), this.B);
        L8:
            int r10 = this.f7568q;
            if (r10 >= 0) goto L11;
            return;
        L11:
            if (this.f7569r > r10) goto L13;
            return;
        L13:
            if (this.f7577z == false) goto L35;
            View r11 = getChildAt(this.E.getSelectedTabPosition());
            if (r11 == null) goto L26;
            View r13 = r11.findViewById(u8.f.layout_tab_indicator);
            if (r13 == null) goto L26;
            if (this.E.f7515J != null) goto L21;
        L22:
            int r12 = this.f7568q;
            float r14 = r12 + (((this.f7569r - r12) - r13.getWidth()) / 2);
            this.f7572u = r14;
            this.f7573v = r14 + r13.getWidth();
        L23:
            Path r15 = new Path();
            r15.addRoundRect(new RectF(((this.f7572u + this.f7573v) / 2.0f) - this.E.D(3), (getHeight() - getPaddingBottom()) - this.E.D(4), ((this.f7572u + this.f7573v) / 2.0f) + this.E.D(3), getHeight() - getPaddingBottom()), new float[]{this.E.D(3), this.E.D(3), this.E.D(3), this.E.D(3), this.E.D(1), this.E.D(1), this.E.D(1), this.E.D(1)}, Path.Direction.CCW);
            r18.drawPath(r15, this.f7564m);
            return;
        L21:
            if (this.f7574w == true) goto L23;
        L26:
            if (this.D == false) goto L28;
        L30:
            float r16 = this.f7568q;
            float r17 = this.f7569r;
        L31:
            Path r19 = new Path();
            float r110 = (r16 + r17) / 2.0f;
            r19.addRoundRect(new RectF(r110 - this.E.D(3), (getHeight() - getPaddingBottom()) - this.E.D(4), r110 + this.E.D(3), getHeight() - getPaddingBottom()), new float[]{this.E.D(3), this.E.D(3), this.E.D(3), this.E.D(3), this.E.D(1), this.E.D(1), this.E.D(1), this.E.D(1)}, Path.Direction.CCW);
            r18.drawPath(r19, this.f7564m);
            return;
        L28:
            if ((r11 instanceof j) == false) goto L30;
            float r20 = (this.f7568q + this.f7569r) * 0.5f;
            j r21 = (j) r11;
            r16 = r20 - (r21.getContentWidth() * 0.5f);
            r17 = r20 + (r21.getContentWidth() * 0.5f);
            goto L31
        }

        boolean e() {
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

        float f() {
            return this.f7565n + this.f7566o;
        }

        int g(int r10, int r11, float r12) {
            return r10 + Math.round(r12 * (r11 - r10));
        }

        void h(int r10, int r11) {
            if (r10 == this.f7568q) goto L5;
        L6:
            this.f7568q = r10;
            this.f7569r = r11;
            ViewCompat.postInvalidateOnAnimation(this);
            return;
        L5:
            if (r11 != this.f7569r) goto L6;
        }

        void i(int r10, float r11) {
            ValueAnimator r12 = this.f7570s;
            if (r12 != null) goto L5;
        L7:
            this.f7565n = r10;
            this.f7566o = r11;
            q();
            return;
        L5:
            if (r12.isRunning() == false) goto L7;
            this.f7570s.cancel();
            goto L7
        }

        void j(int r10) {
            if (this.f7564m.getColor() == r10) goto L6;
            this.f7564m.setColor(r10);
            ViewCompat.postInvalidateOnAnimation(this);
            return;
        }

        void k(boolean r10) {
            if (this.D == r10) goto L6;
            this.D = r10;
            ViewCompat.postInvalidateOnAnimation(this);
            return;
        }

        void l(int r10) {
            if (this.f7563l == r10) goto L6;
            this.f7563l = r10;
            ViewCompat.postInvalidateOnAnimation(this);
            return;
        }

        public void m(int r10) {
        }

        void n(boolean r10) {
            this.f7575x = r10;
            if (r10 == false) goto L6;
            Paint r11 = new Paint();
            this.A = r11;
            r11.setColor(ContextCompat.getColor(getContext(), u8.c.oui_line_2));
            this.A.setStyle(Paint.Style.FILL);
            return;
        }

        void o(boolean r10) {
            this.f7577z = r10;
        }

        @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
        protected void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
            super.onLayout(r10, r11, r12, r13, r14);
            ValueAnimator r15 = this.f7570s;
            if (r15 != null) goto L5;
        L7:
            q();
            return;
        L5:
            if (r15.isRunning() == false) goto L7;
            this.f7570s.cancel();
            d(this.f7565n, Math.round((1.0f - this.f7570s.getAnimatedFraction()) * this.f7570s.getDuration()));
        }

        @Override // com.obric.oui.layout.OUILinearLayout, android.widget.LinearLayout, android.view.View
        protected void onMeasure(int r10, int r11) {
            super.onMeasure(r10, r11);
            if (View.MeasureSpec.getMode(r10) == 1073741824) goto L5;
            return;
        L5:
            Log.d("wjh", "onMeasure " + View.MeasureSpec.getMode(r10));
            int r12 = getChildCount();
            int r13 = 0;
            int r14 = 0;
            int r15 = 0;
        L6:
            if (r14 >= r12) goto L11;
            View r16 = getChildAt(r14);
            if (r16.getVisibility() != 0) goto L10;
            r15 = Math.max(r15, r16.getMeasuredWidth());
            this.f7571t = Math.min(this.f7571t, r16.getMeasuredWidth());
        L10:
            r14 = r14 + 1;
            goto L6
        L11:
            OTabLayoutBase r17 = this.E;
            int r18 = r17.C;
            boolean r19 = true;
            if (r18 == 1) goto L14;
        L31:
            if (r18 == 0) goto L33;
            return;
        L33:
            if (r17.E == true) goto L35;
            return;
        L35:
            if (OTabLayoutBase.f(r17) == getResources().getConfiguration().orientation) goto L37;
            return;
        L37:
            if (r15 > 0) goto L39;
            return;
        L39:
            int r20 = 0;
            int r21 = 0;
        L41:
            if (r20 >= r12) goto L46;
            View r22 = getChildAt(r20);
            if (r22.getVisibility() == 8) goto L45;
            r21 = r21 + r22.getMeasuredWidth();
        L45:
            r20 = r20 + 1;
            goto L41
        L46:
            if (r21 > 0) goto L48;
            return;
        L48:
            int r23 = (this.E.getMeasuredWidth() - OTabLayoutBase.g(this.E).getPaddingLeft()) - OTabLayoutBase.g(this.E).getPaddingRight();
            if (r21 < r23) goto L51;
        L67:
            if (r13 == 0) goto L88;
        L68:
            super.onMeasure(r10, r11);
            return;
        L88:
            return;
        L51:
            if ((r15 * r12) >= r23) goto L60;
            int r24 = 0;
            int r25 = 0;
        L53:
            if (r24 >= r12) goto L66;
            LinearLayout.LayoutParams r26 = (LinearLayout.LayoutParams) getChildAt(r24).getLayoutParams();
            if (r26.width == 0) goto L57;
        L58:
            r26.width = 0;
            r26.weight = 1.0f;
            r25 = 1;
        L59:
            r24 = r24 + 1;
            goto L53
        L57:
            if (r26.weight == 1.0f) goto L59;
        L66:
            r13 = r25;
            goto L67
        L60:
            int r27 = (r23 - r21) / (r12 * 2);
            r25 = 0;
        L61:
            if (r13 >= r12) goto L66;
            if (getChildAt(r13).getVisibility() == 8) goto L65;
            LinearLayout.LayoutParams r28 = (LinearLayout.LayoutParams) getChildAt(r13).getLayoutParams();
            r28.leftMargin = r27;
            r28.rightMargin = r27;
            r25 = 1;
        L65:
            r13 = r13 + 1;
            goto L61
        L14:
            if (r17.B != 1) goto L31;
            if (r15 > 0) goto L18;
            return;
        L18:
            if ((r15 * r12) > (getMeasuredWidth() - (r17.D(16) * 2))) goto L28;
            boolean r29 = false;
        L20:
            if (r13 >= r12) goto L27;
            LinearLayout.LayoutParams r30 = (LinearLayout.LayoutParams) getChildAt(r13).getLayoutParams();
            if (r30.width == r15) goto L24;
        L25:
            r30.width = r15;
            r30.weight = 0.0f;
            r29 = true;
        L26:
            r13 = r13 + 1;
            goto L20
        L24:
            if (r30.weight == 0.0f) goto L26;
        L27:
            r19 = r29;
        L29:
            if (r19 == true) goto L68;
            return;
        L28:
            OTabLayoutBase r31 = this.E;
            r31.B = 0;
            r31.Y(false);
            goto L29
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onRtlPropertiesChanged(int r10) {
            super.onRtlPropertiesChanged(r10);
            if (Build.VERSION.SDK_INT < 23) goto L5;
            return;
        L5:
            if (this.f7567p == r10) goto L9;
            requestLayout();
            this.f7567p = r10;
            return;
        }

        void p(boolean r10) {
            this.f7576y = r10;
            if (r10 == false) goto L6;
            Paint r11 = new Paint();
            this.B = r11;
            r11.setColor(ContextCompat.getColor(getContext(), u8.c.oui_line_2));
            this.B.setStyle(Paint.Style.FILL);
            this.B.setStrokeWidth(this.C);
            return;
        }
    }

    public static final class i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Drawable f7585a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private CharSequence f7586b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private CharSequence f7587c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f7588d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private View f7589e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        OTabLayoutBase f7590f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        j f7591g;

        i() {
            this.f7588d = -1;
        }

        @Nullable
        public CharSequence a() {
            return this.f7587c;
        }

        @Nullable
        public View b() {
            return this.f7589e;
        }

        @Nullable
        public Drawable c() {
            return this.f7585a;
        }

        public int d() {
            return this.f7588d;
        }

        @Nullable
        public CharSequence e() {
            return this.f7586b;
        }

        public j f() {
            return this.f7591g;
        }

        public boolean g() {
            OTabLayoutBase r10 = this.f7590f;
            if (r10 == null) goto L10;
            if (r10.getSelectedTabPosition() != this.f7588d) goto L7;
            return true;
        L7:
            return false;
        L10:
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }

        void h() {
            this.f7590f = null;
            this.f7591g = null;
            this.f7585a = null;
            this.f7586b = null;
            this.f7587c = null;
            this.f7588d = -1;
            this.f7589e = null;
        }

        public void i() {
            OTabLayoutBase r10 = this.f7590f;
            if (r10 == null) goto L7;
            r10.N(this);
            return;
        L7:
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }

        @NonNull
        public i j(@Nullable CharSequence r10) {
            this.f7587c = r10;
            p();
            return this;
        }

        @NonNull
        public i k(@LayoutRes int r10) {
            return l(LayoutInflater.from(this.f7591g.getContext()).inflate(r10, this.f7591g, false));
        }

        @NonNull
        public i l(@Nullable View r10) {
            this.f7589e = r10;
            p();
            return this;
        }

        @NonNull
        public i m(@Nullable Drawable r10) {
            this.f7585a = r10;
            p();
            return this;
        }

        void n(int r10) {
            this.f7588d = r10;
        }

        @NonNull
        public i o(@Nullable CharSequence r10) {
            this.f7586b = r10;
            p();
            return this;
        }

        void p() {
            j r10 = this.f7591g;
            if (r10 == null) goto L6;
            r10.d();
            return;
        }
    }

    public class j extends LinearLayout {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private i f7592c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private TextView f7593g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private ImageView f7594h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private View f7595i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private TextView f7596j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private ImageView f7597k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private int f7598l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        final /* synthetic */ OTabLayoutBase f7599m;

        public j(OTabLayoutBase r10, Context r11) {
            this.f7599m = r10;
            super(r11);
            this.f7598l = 2;
            int r12 = r10.f7547v;
            if (r12 == 0) goto L5;
            ViewCompat.setBackground(this, AppCompatResources.getDrawable(r11, r12));
        L5:
            ViewCompat.setPaddingRelative(this, r10.f7535m, r10.f7537n, r10.f7539o, r10.f7541p);
            setGravity(17);
            setOrientation(1);
            setClickable(true);
            ViewCompat.setPointerIcon(this, PointerIconCompat.getSystemIcon(getContext(), PointerIconCompat.TYPE_HAND));
        }

        private float a(Layout r10, int r11, float r12) {
            return r10.getLineWidth(r11) * (r12 / r10.getPaint().getTextSize());
        }

        private void e(@Nullable TextView r10, @Nullable ImageView r11) {
            i r12 = this.f7592c;
            CharSequence r13 = null;
            if (r12 == null) goto L5;
            Drawable r14 = r12.c();
        L6:
            i r15 = this.f7592c;
            if (r15 == null) goto L9;
            CharSequence r16 = r15.e();
        L10:
            i r17 = this.f7592c;
            if (r17 == null) goto L13;
            CharSequence r18 = r17.a();
        L14:
            int r19 = 0;
            if (r11 == null) goto L20;
            if (r14 == null) goto L18;
            r11.setImageDrawable(r14);
            r11.setVisibility(0);
            setVisibility(0);
        L19:
            r11.setContentDescription(r18);
            goto L20
        L18:
            r11.setVisibility(8);
            r11.setImageDrawable(null);
        L20:
            boolean r20 = !TextUtils.isEmpty(r16);
            if (r10 == null) goto L26;
            if (r20 == false) goto L24;
            r10.setText(r16);
            r10.setVisibility(0);
            setVisibility(0);
        L25:
            r10.setContentDescription(r18);
            goto L26
        L24:
            r10.setVisibility(8);
            r10.setText(null);
        L26:
            if (r11 == null) goto L35;
            ViewGroup.MarginLayoutParams r21 = (ViewGroup.MarginLayoutParams) r11.getLayoutParams();
            if (r20 == false) goto L33;
            if (r11.getVisibility() != 0) goto L33;
            r19 = this.f7599m.D(8);
        L33:
            if (r19 == r21.bottomMargin) goto L35;
            r21.bottomMargin = r19;
            r11.requestLayout();
        L35:
            if (r20 == true) goto L38;
            r13 = r18;
        L38:
            TooltipCompat.setTooltipText(this, r13);
            return;
        L13:
            r18 = null;
            goto L14
        L9:
            r16 = null;
            goto L10
        L5:
            r14 = null;
            goto L6
        }

        void b() {
            setTab(null);
            setSelected(false);
        }

        void c(@Nullable i r10, boolean r11) {
            if (r10 == this.f7592c) goto L8;
            this.f7592c = r10;
            if (r11 == false) goto L9;
            d();
            return;
        L9:
            return;
        }

        final void d() {
            i r10 = this.f7592c;
            ImageView r11 = null;
            if (r10 == null) goto L5;
            View r12 = r10.b();
        L6:
            if (r12 == null) goto L22;
            ViewParent r13 = r12.getParent();
            if (r13 == this) goto L12;
            if (r13 == null) goto L11;
            ((ViewGroup) r13).removeView(r12);
        L11:
            addView(r12);
        L12:
            this.f7595i = r12;
            TextView r14 = this.f7593g;
            if (r14 == null) goto L15;
            r14.setVisibility(8);
        L15:
            ImageView r15 = this.f7594h;
            if (r15 == null) goto L18;
            r15.setVisibility(8);
            this.f7594h.setImageDrawable(null);
        L18:
            TextView r16 = (TextView) r12.findViewById(u8.f.title);
            this.f7596j = r16;
            if (r16 == null) goto L21;
            this.f7598l = TextViewCompat.getMaxLines(r16);
        L21:
            r11 = (ImageView) r12.findViewById(R.id.icon);
        L26:
            this.f7597k = r11;
            boolean r17 = false;
            if (this.f7595i == null) goto L29;
            TextView r18 = this.f7596j;
            if (r18 == null) goto L41;
        L42:
            ImageView r19 = this.f7597k;
        L43:
            e(r18, r19);
        L44:
            if (r10 != null) goto L46;
        L48:
            setSelected(r17);
            return;
        L46:
            if (r10.g() == false) goto L48;
            r17 = true;
            goto L48
        L41:
            if (this.f7597k == null) goto L44;
        L29:
            if (this.f7594h != null) goto L32;
            ImageView r20 = (ImageView) LayoutInflater.from(getContext()).inflate(u8.h.design_layout_tab_icon, this, false);
            addView(r20, 0);
            this.f7594h = r20;
        L32:
            if (this.f7593g != null) goto L34;
            TextView r21 = (TextView) LayoutInflater.from(getContext()).inflate(u8.h.design_layout_tab_text, this, false);
            addView(r21, new LinearLayout.LayoutParams(-1, -2));
            this.f7593g = r21;
            this.f7598l = TextViewCompat.getMaxLines(r21);
        L34:
            TextViewCompat.setTextAppearance(this.f7593g, this.f7599m.f7542q);
            this.f7593g.setAllCaps(false);
            ColorStateList r22 = this.f7599m.f7543r;
            if (r22 == null) goto L37;
            this.f7593g.setTextColor(r22);
        L37:
            r18 = this.f7593g;
            r19 = this.f7594h;
            goto L43
        L22:
            View r23 = this.f7595i;
            if (r23 == null) goto L25;
            removeView(r23);
            this.f7595i = null;
        L25:
            this.f7596j = null;
            goto L26
        L5:
            r12 = null;
            goto L6
        }

        public int getContentWidth() {
            TextView r10 = this.f7593g;
            boolean r11 = true;
            boolean r12 = false;
            if (r10 != null) goto L5;
        L7:
            int r13 = 0;
            int r14 = 0;
        L8:
            ImageView r15 = this.f7594h;
            if (r15 != null) goto L11;
        L19:
            r11 = r12;
        L20:
            View r16 = this.f7595i;
            if (r16 == null) goto L32;
            if (r16.getVisibility() != 0) goto L32;
            if (r11 == false) goto L26;
            r13 = Math.min(r13, this.f7595i.getLeft());
        L27:
            int r17 = this.f7595i.getRight();
            if (r11 == false) goto L30;
            r17 = Math.max(r14, r17);
        L30:
            r14 = r17;
            goto L32
        L26:
            r13 = this.f7595i.getLeft();
        L32:
            return r14 - r13;
        L11:
            if (r15.getVisibility() != 0) goto L19;
            if (r12 == false) goto L14;
            r13 = Math.min(r13, this.f7594h.getLeft());
        L15:
            if (r12 == false) goto L17;
            int r18 = Math.max(r14, this.f7594h.getRight());
        L18:
            r14 = r18;
            goto L20
        L17:
            r18 = this.f7594h.getRight();
            goto L18
        L14:
            r13 = this.f7594h.getLeft();
            goto L15
        L5:
            if (r10.getVisibility() != 0) goto L7;
            int r19 = this.f7593g.getLeft();
            r14 = this.f7593g.getRight();
            r13 = r19;
            r12 = true;
            goto L8
        }

        public i getTab() {
            return this.f7592c;
        }

        public TextView getTextView() {
            return this.f7593g;
        }

        @Override // android.view.View
        public void onInitializeAccessibilityEvent(AccessibilityEvent r10) {
            super.onInitializeAccessibilityEvent(r10);
            r10.setClassName(ActionBar.Tab.class.getName());
        }

        @Override // android.view.View
        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo r10) {
            super.onInitializeAccessibilityNodeInfo(r10);
            r10.setClassName(ActionBar.Tab.class.getName());
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onMeasure(int r11, int r12) {
            int r10 = View.MeasureSpec.getSize(r11);
            int r13 = View.MeasureSpec.getMode(r11);
            int r14 = this.f7599m.getTabMaxWidth();
            LinearLayout.LayoutParams r15 = (LinearLayout.LayoutParams) this.f7593g.getLayoutParams();
            if (r14 <= 0) goto L7;
            if (r13 == 0) goto L6;
            if (r10 <= r14) goto L7;
        L6:
            r11 = View.MeasureSpec.makeMeasureSpec(this.f7599m.f7548w, Integer.MIN_VALUE);
        L7:
            super.onMeasure(r11, r12);
            if (this.f7593g == null) goto L42;
            getResources();
            OTabLayoutBase r16 = this.f7599m;
            float r17 = r16.f7544s;
            int r18 = this.f7598l;
            int r19 = OTabLayoutBase.d(r16);
            int r20 = OTabLayoutBase.e(this.f7599m);
            ImageView r21 = this.f7594h;
            boolean r22 = true;
            if (r21 != null) goto L12;
        L14:
            TextView r23 = this.f7593g;
            if (r23 != null) goto L17;
        L20:
            if (this.f7593g != null) goto L22;
        L26:
            float r24 = this.f7593g.getTextSize();
            int r25 = this.f7593g.getLineCount();
            int r26 = TextViewCompat.getMaxLines(this.f7593g);
            if (r17 != r24) goto L31;
            if (r26 < 0) goto L43;
            if (r18 != r26) goto L31;
            return;
        L43:
            return;
        L31:
            if (this.f7599m.C != 1) goto L39;
            if (r17 <= r24) goto L39;
            if (r25 != 1) goto L39;
            Layout r27 = this.f7593g.getLayout();
            if (r27 != null) goto L37;
        L38:
            r22 = false;
            goto L39
        L37:
            if (a(r27, 0, r17) > ((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight())) goto L38;
        L39:
            if (r22 == false) goto L45;
            this.f7593g.setTextSize(0, r17);
            this.f7593g.setMaxLines(r18);
            r15.topMargin = r19;
            r15.leftMargin = r20;
            r15.rightMargin = r20;
            this.f7593g.setLayoutParams(r15);
            super.onMeasure(r11, r12);
            return;
        L45:
            return;
        L22:
            if (isSelected() == false) goto L26;
            int r28 = this.f7599m.f7546u;
            if (r28 <= 0) goto L26;
            r17 = r28;
            r19 = 0;
            r20 = 0;
            goto L26
        L17:
            if (r23.getLineCount() <= 1) goto L20;
            r17 = this.f7599m.f7545t;
            goto L20
        L12:
            if (r21.getVisibility() != 0) goto L14;
            r18 = 1;
            goto L20
        }

        @Override // android.view.View
        public boolean performClick() {
            boolean r10 = super.performClick();
            if (this.f7592c == null) goto L12;
            if (r10 == true) goto L7;
            playSoundEffect(0);
        L7:
            if (OTabLayoutBase.b(this.f7599m) == null) goto L9;
            OTabLayoutBase.b(this.f7599m).a(this.f7592c);
        L10:
            q9.a.b(getContext(), 1);
            return true;
        L9:
            this.f7592c.i();
            goto L10
        L12:
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
            TextView r12 = this.f7593g;
            if (r12 == null) goto L20;
            r12.setSelected(r10);
            this.f7593g.setTypeface(Typeface.DEFAULT_BOLD);
            if (r10 == false) goto L19;
            int r13 = this.f7599m.f7546u;
            if (r13 <= 0) goto L19;
            this.f7593g.setTextSize(r13);
        L19:
            this.f7593g.setTextSize(this.f7599m.f7544s);
        L20:
            ImageView r14 = this.f7594h;
            if (r14 == null) goto L23;
            r14.setSelected(r10);
        L23:
            View r15 = this.f7595i;
            if (r15 == null) goto L27;
            r15.setSelected(r10);
            return;
        L27:
            return;
        L5:
            r11 = false;
            goto L6
        }

        void setTab(@Nullable i r10) {
            if (r10 == this.f7592c) goto L6;
            this.f7592c = r10;
            d();
            return;
        }
    }

    public static class k implements e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ViewPager f7600a;

        public k(ViewPager r10) {
            this.f7600a = r10;
        }

        @Override // com.obric.oui.tab.OTabLayoutBase.e
        public void a(i r10) {
            this.f7600a.setCurrentItem(r10.d());
        }

        @Override // com.obric.oui.tab.OTabLayoutBase.e
        public void b(i r10) {
        }

        @Override // com.obric.oui.tab.OTabLayoutBase.e
        public void c(i r10) {
        }
    }

    static {
        f7513p0 = new FastOutSlowInInterpolator();
        f7514q0 = new Pools.SynchronizedPool(16);
    }

    public OTabLayoutBase(Context r10) {
        this(r10, null);
    }

    public OTabLayoutBase(Context r10, AttributeSet r11) {
        this(r10, r11, 0);
    }

    public OTabLayoutBase(Context r17, AttributeSet r18, int r19) {
        super(r17, r18, r19);
        this.f7518c = new ArrayList();
        this.f7531k = 0;
        this.f7533l = 0;
        this.f7548w = Integer.MAX_VALUE;
        this.G = new ArrayList();
        this.P = false;
        this.R = 0;
        this.S = 0.0f;
        this.T = 0.0f;
        this.U = 0.0f;
        this.V = new Paint(1);
        new Paint(1);
        this.W = new Paint(1);
        this.f7516a0 = new RectF();
        new RectF();
        this.f7519c0 = true;
        this.f7520d0 = false;
        this.f7521e0 = true;
        this.f7522f0 = new Rect();
        new Rect();
        this.f7524g0 = new Paint();
        this.f7528i0 = new PathInterpolator(0.34f, 0.69f, 0.1f, 1.0f);
        c r10 = new c(this);
        this.f7530j0 = r10;
        c r11 = new c(this);
        this.f7532k0 = r11;
        this.f7538n0 = new Pools.SimplePool(12);
        setHorizontalScrollBarEnabled(false);
        h r12 = new h(this, r17);
        this.f7527i = r12;
        setClipChildren(false);
        setClipToPadding(false);
        super.addView(r12, 0, new FrameLayout.LayoutParams(-2, -1));
        TypedArray r13 = r17.obtainStyledAttributes(r18, l.TabLayout, r19, u8.k.OTabText);
        r12.l(r13.getDimensionPixelSize(l.TabLayout_tabIndicatorHeight, 0));
        r12.j(r13.getColor(l.TabLayout_tabIndicatorColor, ContextCompat.getColor(getContext(), u8.c.oui_accent_7)));
        int r14 = r13.getDimensionPixelSize(l.TabLayout_tabPadding, 0);
        this.f7535m = r14;
        this.f7537n = r14;
        this.f7539o = r14;
        this.f7541p = r14;
        this.f7535m = r13.getDimensionPixelSize(l.TabLayout_tabPaddingStart, r14);
        this.f7537n = r13.getDimensionPixelSize(l.TabLayout_tabPaddingTop, this.f7537n);
        this.f7539o = r13.getDimensionPixelSize(l.TabLayout_tabPaddingEnd, this.f7539o);
        this.f7541p = r13.getDimensionPixelSize(l.TabLayout_tabPaddingBottom, this.f7541p);
        int r15 = r13.getResourceId(l.TabLayout_tabTextAppearance, u8.k.TextAppearance_Design_Tab);
        this.f7542q = r15;
        TypedArray r16 = r17.obtainStyledAttributes(r15, l.TextAppearance);
        this.f7544s = r16.getDimensionPixelSize(l.TextAppearance_android_textSize, 0);     // Catch: Throwable -> L31
        this.f7543r = r16.getColorStateList(l.TextAppearance_android_textColor);     // Catch: Throwable -> L31
        r16.recycle();
        int r110 = l.TabLayout_tabTextColor;
        if (r13.hasValue(r110) == false) goto L7;
        this.f7543r = r13.getColorStateList(r110);
    L7:
        int r111 = l.TabLayout_tabSelectedTextColor;
        if (r13.hasValue(r111) == false) goto L10;
        this.f7543r = x(this.f7543r.getDefaultColor(), r13.getColor(r111, 0));
    L10:
        this.f7549x = r13.getDimensionPixelSize(l.TabLayout_tabMinWidth, -1);
        this.f7550y = r13.getDimensionPixelSize(l.TabLayout_tabMaxWidth, -1);
        this.f7547v = r13.getResourceId(l.TabLayout_tabBackground, 0);
        this.A = r13.getDimensionPixelSize(l.TabLayout_tabContentStart, 0);
        this.C = r13.getInt(l.TabLayout_tabMode, 1);
        this.B = r13.getInt(l.TabLayout_tabGravity, 0);
        TypedArray r112 = r17.obtainStyledAttributes(r18, l.OTabLayoutSupple);
        r12.k(r112.getBoolean(l.OTabLayoutSupple_oui_tabIndicatorFullWidth, true));     // Catch: Throwable -> L28
        r12.n(r112.getBoolean(l.OTabLayoutSupple_oui_showBottomLine, false));     // Catch: Throwable -> L28
        r12.p(r112.getBoolean(l.OTabLayoutSupple_oui_showTopLine, false));     // Catch: Throwable -> L28
        r12.o(r112.getBoolean(l.OTabLayoutSupple_oui_showSelectedIndicator, true));     // Catch: Throwable -> L28
        this.f7546u = r112.getDimensionPixelSize(l.OTabLayoutSupple_oui_tabSelectedTextSize, 0);     // Catch: Throwable -> L28
        this.f7544s = r112.getDimensionPixelSize(l.OTabLayoutSupple_oui_tabTextSize, (int) this.f7544s);     // Catch: Throwable -> L28
        int r113 = r112.getInt(l.OTabLayoutSupple_oui_tab_spec, -1);     // Catch: Throwable -> L28
        if (r113 == 0) goto L17;
        if (r113 == 1) goto L17;
        if (r113 == 2) goto L16;
        T(D(16), D(4), D(16), D(12));     // Catch: Throwable -> L28
    L18:
        r112.recycle();
        Resources r20 = getResources();
        this.f7545t = r20.getDimensionPixelSize(u8.d.design_tab_text_size_2line);
        this.f7551z = r20.getDimensionPixelSize(u8.d.design_tab_scrollable_min_width);
        com.obric.oui.common.util.f.a(1.5f);
        com.obric.oui.common.util.f.a(1.5f);
        this.f7540o0 = getResources().getConfiguration().orientation;
        r13.recycle();
        TypedArray r21 = r17.obtainStyledAttributes(r18, l.OTabLayout);
        this.Q = r21.getColor(l.OTabLayout_indicator_color, 0);     // Catch: Throwable -> L25
        this.R = r21.getColor(l.OTabLayout_indicator_unselected_color, 0);     // Catch: Throwable -> L25
        this.S = r21.getDimension(l.OTabLayout_indicator_height, -1.0f);     // Catch: Throwable -> L25
        this.U = r21.getDimension(l.OTabLayout_indicator_corner_radius, -1.0f);     // Catch: Throwable -> L25
        this.T = r21.getDimension(l.OTabLayout_indicator_spacing, D(4));     // Catch: Throwable -> L25
        this.f7517b0 = r21.getColor(l.OTabLayout_bar_color, 0);     // Catch: Throwable -> L25
        this.f7519c0 = r21.getBoolean(l.OTabLayout_indicator_anim_enable, false);     // Catch: Throwable -> L25
        this.f7520d0 = r21.getBoolean(l.OTabLayout_indicator_bounce_enable, true);     // Catch: Throwable -> L25
        r21.recycle();
        ValueAnimator r22 = ValueAnimator.ofObject(new g(this), new Object[]{r11, r10});
        this.f7526h0 = r22;
        r22.addUpdateListener(this);
        this.V.setStyle(Paint.Style.FILL);
        this.W.setStyle(Paint.Style.STROKE);
        if (this.U <= 0.0f) goto L23;
        r12.setShadowStyle(u8.k.OUIShadow_2_1);
        r12.setShadowCornerRadius((int) this.U);
    L23:
        s();
        return;
    L25:
        th = move-exception;
        r21.recycle();
        throw th;
    L16:
        T(D(12), D(6), D(12), D(6));     // Catch: Throwable -> L28
    L17:
        T(D(12), D(3), D(12), D(3));     // Catch: Throwable -> L28
        D(4);     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        r112.recycle();
        throw th;
    L31:
        th = move-exception;
        r16.recycle();
        throw th;
    }

    private void A(@NonNull i r10) {
        int r11 = this.G.size() - 1;
    L3:
        if (r11 < 0) goto L5;
        this.G.get(r11).c(r10);
        r11 = r11 - 1;
        goto L3
    }

    private void B(@NonNull i r10) {
        int r11 = this.G.size() - 1;
    L3:
        if (r11 < 0) goto L5;
        this.G.get(r11).a(r10);
        r11 = r11 - 1;
        goto L3
    }

    private void C(@NonNull i r10) {
        int r11 = this.G.size() - 1;
    L3:
        if (r11 < 0) goto L5;
        this.G.get(r11).b(r10);
        r11 = r11 - 1;
        goto L3
    }

    private void F() {
        if (this.I != null) goto L6;
        ValueAnimator r10 = new ValueAnimator();
        this.I = r10;
        r10.setInterpolator(f7513p0);
        this.I.setDuration(200);
        this.I.addUpdateListener(new b(this));
        return;
    }

    private void M(int r10) {
        j r11 = (j) this.f7527i.getChildAt(r10);
        this.f7527i.removeViewAt(r10);
        if (r11 == null) goto L5;
        r11.b();
        this.f7538n0.release(r11);
    L5:
        requestLayout();
    }

    private void V(@Nullable ViewPager r10, boolean r11, boolean r12) {
        ViewPager r13 = this.f7515J;
        if (r13 == null) goto L10;
        TabLayoutOnPageChangeListener r14 = this.M;
        if (r14 == null) goto L7;
        r13.removeOnPageChangeListener(r14);
    L7:
        AdapterChangeListener r15 = this.N;
        if (r15 == null) goto L10;
        this.f7515J.removeOnAdapterChangeListener(r15);
    L10:
        e r16 = this.H;
        if (r16 == null) goto L13;
        L(r16);
        this.H = null;
    L13:
        if (r10 == null) goto L24;
        this.f7515J = r10;
        if (this.M != null) goto L17;
        this.M = new TabLayoutOnPageChangeListener(this);
    L17:
        this.M.reset();
        r10.addOnPageChangeListener(this.M);
        k r17 = new k(r10);
        this.H = r17;
        j(r17);
        PagerAdapter r18 = r10.getAdapter();
        if (r18 == null) goto L21;
        P(r18, r11);
    L21:
        if (this.N != null) goto L23;
        this.N = new AdapterChangeListener(this);
    L23:
        this.N.setAutoRefresh(r11);
        r10.addOnAdapterChangeListener(this.N);
        Q(r10.getCurrentItem(), 0.0f, true);
    L25:
        this.O = r12;
        return;
    L24:
        this.f7515J = null;
        P(null, false);
        goto L25
    }

    private void W() {
        int r10 = this.f7518c.size();
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L5;
        this.f7518c.get(r11).p();
        r11 = r11 + 1;
        goto L3
    }

    private void X(LinearLayout.LayoutParams r10) {
        if (this.C == 1) goto L5;
    L7:
        r10.width = -2;
        float r11 = 0.0f;
    L8:
        r10.weight = r11;
        int r12 = this.f7529j;
        if (r12 == 0) goto L12;
        r10.leftMargin = r12;
        r10.rightMargin = r12;
        return;
    L12:
        return;
    L5:
        if (this.B != 0) goto L7;
        r10.width = 0;
        r11 = 1.0f;
        goto L8
    }

    static /* synthetic */ int a(OTabLayoutBase r10, int r11) {
        r10.f7534l0 = r11;
        return r11;
    }

    static /* synthetic */ d b(OTabLayoutBase r10) {
        return r10.f7536m0;
    }

    static /* synthetic */ boolean c(OTabLayoutBase r10) {
        return r10.P;
    }

    static /* synthetic */ int d(OTabLayoutBase r10) {
        return r10.f7533l;
    }

    static /* synthetic */ int e(OTabLayoutBase r10) {
        return r10.f7531k;
    }

    static /* synthetic */ int f(OTabLayoutBase r10) {
        return r10.f7540o0;
    }

    static /* synthetic */ h g(OTabLayoutBase r10) {
        return r10.f7527i;
    }

    private int getDefaultHeight() {
        int r10 = this.f7518c.size();
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L14;
        i r12 = this.f7518c.get(r11);
        if (r12 == null) goto L13;
        if (r12.c() == null) goto L11;
        if (TextUtils.isEmpty(r12.e()) == true) goto L11;
        return 56;
    L11:
        if (r12.b() == null) goto L13;
        return 56;
    L13:
        r11 = r11 + 1;
        goto L3
    L14:
        return 56;
    }

    private float getScrollPosition() {
        return this.f7527i.f();
    }

    private int getTabMinWidth() {
        int r10 = this.f7549x;
        if (r10 == (-1)) goto L6;
        return r10;
    L6:
        if (this.C == 0) goto L10;
        return 0;
    L10:
        return this.f7551z;
    }

    private int getTabScrollRange() {
        return Math.max(0, ((this.f7527i.getWidth() - getWidth()) - getPaddingLeft()) - getPaddingRight());
    }

    static /* synthetic */ Interpolator h() {
        return f7513p0;
    }

    static /* synthetic */ int[] i() {
        return HorizontalScrollView.SELECTED_STATE_SET;
    }

    private void n(@NonNull OBottomTabItem r10) {
        OBottomTabItemCustomView r11 = new OBottomTabItemCustomView(getContext());
        i r12 = I(0);
        if (r10.getText() == null) goto L6;
        r11.getTitle().setText(r10.getText());
        r12.o(r10.getText());
    L6:
        if (r10.getIcon() == null) goto L8;
        r11.getIcon().setImageDrawable(r10.getIcon());
    L8:
        r11.setTextColor(this.f7543r);
        r11.setSelectedBgColor(Integer.valueOf(ContextCompat.getColor(getContext(), u8.c.oui_accent_bg_light)));
        r12.l(r11);
        k(r12);
    }

    private void o(@NonNull OTabItem r10) {
        i r11 = I(0);
        CharSequence r12 = r10.f7510c;
        if (r12 == null) goto L5;
        r11.o(r12);
    L5:
        Drawable r13 = r10.f7511g;
        if (r13 == null) goto L8;
        r11.m(r13);
    L8:
        int r14 = r10.f7512h;
        if (r14 == 0) goto L12;
        r11.k(r14);
    L12:
        if (TextUtils.isEmpty(r10.getContentDescription()) == true) goto L14;
        r11.j(r10.getContentDescription());
    L14:
        k(r11);
    }

    private void p(i r10) {
        j r11 = r10.f7591g;
        this.f7527i.addView(r11, r10.d(), y());
    }

    private void q(View r10) {
        if ((r10 instanceof OTabItem) == false) goto L6;
        o((OTabItem) r10);
        return;
    L6:
        if ((r10 instanceof h) == false) goto L11;
        if (indexOfChild(r10) != (-1)) goto L15;
        super.addView(r10, 0, new FrameLayout.LayoutParams(-2, -1));
        return;
    L15:
        return;
    L11:
        if ((r10 instanceof OBottomTabItem) == false) goto L17;
        n((OBottomTabItem) r10);
        return;
    }

    private void r(int r10) {
        if (r10 != (-1)) goto L6;
        return;
    L6:
        if (getWindowToken() != null) goto L8;
    L17:
        Q(r10, 0.0f, true);
        return;
    L8:
        if (ViewCompat.isLaidOut(this) == false) goto L17;
        if (this.f7527i.e() == true) goto L17;
        int r11 = getScrollX();
        int r12 = v(r10, 0.0f);
        if (r11 == r12) goto L15;
        F();
        this.I.setIntValues(new int[]{r11, r12});
        this.I.start();
    L15:
        this.f7527i.d(r10, 200);
    }

    private void s() {
        if (this.C != 0) goto L5;
        int r10 = Math.max(0, this.A - this.f7535m);
    L6:
        ViewCompat.setPaddingRelative(this.f7527i, r10, 0, 0, 0);
        int r11 = this.C;
        if (r11 == 0) goto L11;
        if (r11 != 1) goto L12;
        this.f7527i.setGravity(1);
    L12:
        Y(true);
        return;
    L11:
        this.f7527i.setGravity(GravityCompat.START);
        goto L12
    L5:
        r10 = 0;
        goto L6
    }

    private void setSelectedTabView(int r10) {
        int r11 = this.f7527i.getChildCount();
        if (r10 >= r11) goto L11;
        int r12 = 0;
    L5:
        if (r12 >= r11) goto L15;
        View r13 = this.f7527i.getChildAt(r12);
        if (r12 != r10) goto L9;
        boolean r14 = true;
    L10:
        r13.setSelected(r14);
        r12 = r12 + 1;
        goto L5
    L9:
        r14 = false;
        goto L10
    L15:
        return;
    }

    private void t() {
        View r10 = H(getSelectedTabPosition());
        if (r10 == null) goto L6;
        Rect r11 = this.f7522f0;
        r11.left = r10.getLeft();
        Rect r12 = this.f7522f0;
        r12.right = r10.getRight();
        return;
    }

    private void u() {
        View r10 = H(getSelectedTabPosition());
        if (r10 != null) goto L5;
        return;
    L5:
        this.f7530j0.f7559a = r10.getLeft();
        this.f7530j0.f7560b = r10.getRight();
        j r11 = this.f7525h.f();
        this.f7532k0.f7559a = r11.getLeft();
        this.f7532k0.f7560b = r11.getRight();
        c r12 = this.f7532k0;
        float r13 = r12.f7559a;
        c r14 = this.f7530j0;
        if (r13 == r14.f7559a) goto L8;
    L10:
        this.f7526h0.setObjectValues(new Object[]{r12, r14});
        if (this.f7520d0 == false) goto L13;
        this.f7526h0.setInterpolator(this.f7528i0);
    L13:
        this.f7526h0.setDuration(350);
        this.f7526h0.start();
        return;
    L8:
        if (r12.f7560b != r14.f7560b) goto L10;
        invalidate();
    }

    private int v(int r10, float r11) {
        int r12 = 0;
        if (this.C != 0) goto L21;
        View r13 = this.f7527i.getChildAt(r10);
        int r14 = r10 + 1;
        if (r14 >= this.f7527i.getChildCount()) goto L7;
        View r15 = this.f7527i.getChildAt(r14);
    L8:
        if (r13 == null) goto L10;
        int r16 = r13.getWidth();
    L11:
        if (r15 == null) goto L13;
        int r17 = r15.getWidth();
    L14:
        if (r13 == null) goto L16;
        r12 = r13.getLeft();
    L16:
        int r18 = (r12 + (r16 / 2)) - (getWidth() / 2);
        int r19 = (int) ((((r16 + r17) + (this.f7529j * 4)) * 0.5f) * r11);
        if (ViewCompat.getLayoutDirection(this) != 0) goto L20;
        return r18 + r19;
    L20:
        return r18 - r19;
    L13:
        r17 = 0;
        goto L14
    L10:
        r16 = 0;
        goto L11
    L7:
        r15 = null;
        goto L8
    L21:
        return 0;
    }

    private void w(i r10, int r11) {
        r10.n(r11);
        this.f7518c.add(r11, r10);
        int r12 = this.f7518c.size();
    L3:
        r11 = r11 + 1;
        if (r11 >= r12) goto L6;
        this.f7518c.get(r11).n(r11);
        goto L3
    }

    private static ColorStateList x(int r10, int r11) {
        return new ColorStateList(new int[][]{HorizontalScrollView.SELECTED_STATE_SET, HorizontalScrollView.EMPTY_STATE_SET}, new int[]{r11, r10});
    }

    private LinearLayout.LayoutParams y() {
        LinearLayout.LayoutParams r10 = new LinearLayout.LayoutParams(-2, -1);
        X(r10);
        return r10;
    }

    private j z() {
        Pools.Pool<j> r10 = this.f7538n0;
        if (r10 == null) goto L5;
        j r11 = r10.acquire();
    L6:
        if (r11 != null) goto L8;
        r11 = new j(this, getContext());
    L8:
        r11.setFocusable(true);
        return r11;
    L5:
        r11 = null;
        goto L6
    }

    int D(int r10) {
        return Math.round(getResources().getDisplayMetrics().density * r10);
    }

    float E(float r10) {
        return Math.round(getResources().getDisplayMetrics().density * r10);
    }

    @Nullable
    public i G(int r10) {
        if (r10 >= 0) goto L4;
    L7:
        return null;
    L4:
        if (r10 >= getTabCount()) goto L7;
        return this.f7518c.get(r10);
    }

    public View H(int r10) {
        return this.f7527i.getChildAt(r10);
    }

    @NonNull
    public i I(int r10) {
        i r11 = f7514q0.acquire();
        if (r11 != null) goto L5;
        r11 = new i();
    L5:
        r11.f7590f = this;
        j r12 = z();
        r11.f7591g = r12;
        if (r10 <= 0) goto L8;
        r12.c(r11, false);
        r11.k(r10);
    L9:
        return r11;
    L8:
        r12.setTab(r11);
        goto L9
    }

    void J() {
        K();
        PagerAdapter r10 = this.K;
        if (r10 == null) goto L17;
        int r11 = r10.getCount();
        int r12 = 0;
    L5:
        if (r12 >= r11) goto L7;
        m(I(this.D).o(this.K.getPageTitle(r12)), false);
        r12 = r12 + 1;
        goto L5
    L7:
        ViewPager r13 = this.f7515J;
        if (r13 == null) goto L18;
        if (r11 <= 0) goto L19;
        int r14 = r13.getCurrentItem();
        if (r14 != getSelectedTabPosition()) goto L13;
        return;
    L13:
        if (r14 >= getTabCount()) goto L21;
        N(G(r14));
        return;
    L21:
        return;
    L19:
        return;
    L18:
        return;
    }

    public void K() {
        int r10 = this.f7527i.getChildCount() - 1;
    L3:
        if (r10 < 0) goto L5;
        M(r10);
        r10 = r10 - 1;
        goto L3
    L5:
        Iterator<i> r11 = this.f7518c.iterator();
    L7:
        if (r11.hasNext() == false) goto L9;
        i r12 = r11.next();
        r11.remove();
        r12.h();
        f7514q0.release(r12);
        goto L7
    L9:
        this.f7523g = null;
    }

    public void L(@NonNull e r10) {
        this.G.remove(r10);
    }

    void N(i r10) {
        O(r10, true);
    }

    void O(i r10, boolean r11) {
        i r12 = this.f7523g;
        if (r12 != r10) goto L7;
        if (r12 == null) goto L30;
        A(r10);
        r(r10.d());
        return;
    L30:
        return;
    L7:
        if (r10 == null) goto L9;
        int r13 = r10.d();
    L10:
        if (r11 == false) goto L19;
        if (r12 != null) goto L13;
    L14:
        if (r13 == (-1)) goto L16;
        Q(r13, 0.0f, true);
    L17:
        if (r13 == (-1)) goto L19;
        setSelectedTabView(r13);
    L16:
        r(r13);
        goto L17
    L13:
        if (r12.d() != (-1)) goto L16;
    L19:
        if (r12 == null) goto L21;
        C(r12);
    L21:
        i r14 = this.f7523g;
        if (r14 != null) goto L24;
        r14 = r10;
    L24:
        this.f7525h = r14;
        this.f7523g = r10;
        if (this.f7519c0 == false) goto L27;
        u();
    L27:
        if (r10 == null) goto L32;
        B(r10);
        return;
    L32:
        return;
    L9:
        r13 = -1;
        goto L10
    }

    void P(@Nullable PagerAdapter r10, boolean r11) {
        PagerAdapter r12 = this.K;
        if (r12 == null) goto L7;
        DataSetObserver r13 = this.L;
        if (r13 == null) goto L7;
        r12.unregisterDataSetObserver(r13);
    L7:
        this.K = r10;
        if (r11 == false) goto L14;
        if (r10 == null) goto L14;
        if (this.L != null) goto L13;
        this.L = new f(this);
    L13:
        r10.registerDataSetObserver(this.L);
    L14:
        J();
    }

    public void Q(int r10, float r11, boolean r12) {
        R(r10, r11, r12, true);
    }

    void R(int r10, float r11, boolean r12, boolean r13) {
        int r14 = Math.round(r10 + r11);
        if (r14 >= 0) goto L5;
        return;
    L5:
        if (r14 >= this.f7527i.getChildCount()) goto L20;
        if (r13 == false) goto L9;
        this.f7527i.i(r10, r11);
    L9:
        ValueAnimator r15 = this.I;
        if (r15 != null) goto L12;
    L14:
        scrollTo(v(r10, r11), 0);
        if (r12 == false) goto L19;
        setSelectedTabView(r14);
        return;
    L19:
        return;
    L12:
        if (r15.isRunning() == false) goto L14;
        this.I.cancel();
        goto L14
    }

    public void S(int r10, int r11) {
        this.f7531k = D(r10);
        if (this.f7546u <= D(20)) goto L6;
        this.f7533l = D(r11);
        return;
    }

    public void T(int r10, int r11, int r12, int r13) {
        this.f7527i.setPadding(r10, r11, r12, r13);
    }

    public void U(@Nullable ViewPager r10, boolean r11) {
        V(r10, r11, false);
    }

    void Y(boolean r10) {
        int r11 = 0;
    L4:
        if (r11 >= this.f7527i.getChildCount()) goto L9;
        View r12 = this.f7527i.getChildAt(r11);
        X((LinearLayout.LayoutParams) r12.getLayoutParams());
        if (r10 == false) goto L8;
        r12.requestLayout();
    L8:
        r11 = r11 + 1;
        goto L4
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View r10) {
        q(r10);
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View r10, int r11) {
        q(r10);
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View r10, int r11, ViewGroup.LayoutParams r12) {
        q(r10);
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup, android.view.ViewManager
    public void addView(View r10, ViewGroup.LayoutParams r11) {
        q(r10);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet r10) {
        return generateLayoutParams(r10);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet r10) {
        return generateDefaultLayoutParams();
    }

    public float getIndicatorCornerRadius() {
        return this.U;
    }

    public int getSelectedTabPosition() {
        i r10 = this.f7523g;
        if (r10 != null) goto L7;
        return -1;
    L7:
        return r10.d();
    }

    public int getTabCount() {
        return this.f7518c.size();
    }

    public int getTabGravity() {
        return this.B;
    }

    int getTabMaxWidth() {
        return this.f7548w;
    }

    public int getTabMode() {
        return this.C;
    }

    public int getTabStripLeftPadding() {
        return this.f7527i.getPaddingLeft();
    }

    public int getTabStripRightPadding() {
        return this.f7527i.getPaddingRight();
    }

    @Nullable
    public ColorStateList getTabTextColors() {
        return this.f7543r;
    }

    public void j(@NonNull e r10) {
        if (this.G.contains(r10) == true) goto L6;
        this.G.add(r10);
        return;
    }

    public void k(@NonNull i r10) {
        m(r10, this.f7518c.isEmpty());
    }

    public void l(@NonNull i r10, int r11, boolean r12) {
        if (r10.f7590f != this) goto L9;
        w(r10, r11);
        p(r10);
        r10.f().setOnTouchListener(new a(this, r11));
        if (r12 == false) goto L10;
        r10.i();
        return;
    L10:
        return;
    L9:
        throw new IllegalArgumentException("Tab belongs to a different TabLayout.");
    }

    public void m(@NonNull i r10, boolean r11) {
        l(r10, this.f7518c.size(), r11);
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(@NonNull ValueAnimator r10) {
        c r11 = (c) r10.getAnimatedValue();
        Rect r12 = this.f7522f0;
        r12.left = (int) r11.f7559a;
        r12.right = (int) r11.f7560b;
        invalidate();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f7515J != null) goto L8;
        ViewParent r10 = getParent();
        if ((r10 instanceof ViewPager) == false) goto L9;
        V((ViewPager) r10, true, true);
        return;
    L9:
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.O == false) goto L6;
        setupWithViewPager(null);
        this.O = false;
        return;
    }

    @Override // android.view.View
    protected void onDraw(Canvas r14) {
        super.onDraw(r14);
        if (isInEditMode() == false) goto L5;
        return;
    L5:
        if (getTabCount() <= 0) goto L43;
        int r10 = getHeight();
        int r11 = getPaddingLeft();
        getPaddingRight();
        int r12 = getPaddingTop();
        int r13 = getPaddingBottom();
        if (this.S >= 0.0f) goto L10;
        this.S = r10 - (this.T * 2.0f);
    L10:
        float r15 = this.U;
        if (r15 >= 0.0f) goto L13;
    L14:
        this.U = this.S;
    L15:
        float r16 = this.U + (this.T / 2.0f);
        int r17 = this.f7517b0;
        if (r17 == 0) goto L18;
        this.V.setColor(r17);
        this.f7516a0.set(0.0f, r12, getWidth(), r10 - r13);
        q.i(r14, this.f7516a0, r16, this.V);
    L18:
        int r18 = 0;
        if (this.f7519c0 == true) goto L21;
    L23:
        t();
    L24:
        float r19 = this.T;
        int r20 = this.Q;
        if (r20 == 0) goto L28;
        this.f7524g0.setColor(r20);
        Rect r21 = this.f7522f0;
        float r22 = (r11 + r19) + r21.left;
        float r23 = this.T;
        q.h(r14, r22, r23, (r21.right + r11) - r19, r23 + this.S, this.U, this.f7524g0);
    L28:
        if (this.R != 0) goto L30;
        return;
    L30:
        if (this.f7517b0 == 0) goto L32;
        return;
    L32:
        if (r18 >= getTabCount()) goto L44;
        if (r18 == getSelectedTabPosition()) goto L36;
        this.f7524g0.setColor(this.R);
        View r24 = H(r18);
        int r25 = r24.getLeft();
        int r26 = r24.getRight();
        float r27 = this.T;
        q.h(r14, (r11 + r19) + r25, r27, (r26 + r11) - r19, r27 + this.S, this.U, this.f7524g0);
    L36:
        r18 = r18 + 1;
        goto L32
    L44:
        return;
    L21:
        if (this.f7521e0 == false) goto L24;
        this.f7521e0 = false;
        goto L23
    L13:
        if (r15 <= (this.S / 2.0f)) goto L15;
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int r10, int r11) {
        int r12 = (D(getDefaultHeight()) + getPaddingTop()) + getPaddingBottom();
        int r13 = View.MeasureSpec.getMode(r11);
        if (r13 == Integer.MIN_VALUE) goto L7;
        if (r13 != 0) goto L8;
        r11 = View.MeasureSpec.makeMeasureSpec(r12, 1073741824);
    L8:
        int r14 = View.MeasureSpec.getSize(r10);
        if (View.MeasureSpec.getMode(r10) == 0) goto L15;
        int r15 = this.f7550y;
        if (r15 > 0) goto L14;
        r15 = r14 - D(56);
    L14:
        this.f7548w = r15;
    L15:
        super.onMeasure(r10, r11);
        boolean r16 = true;
        if (getChildCount() != 1) goto L32;
        boolean r17 = false;
        View r18 = getChildAt(0);
        int r19 = this.C;
        if (r19 == 0) goto L25;
        if (r19 == 1) goto L22;
    L29:
        if (r17 == false) goto L33;
        r18.measure(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), HorizontalScrollView.getChildMeasureSpec(r11, getPaddingTop() + getPaddingBottom(), r18.getLayoutParams().height));
        return;
    L33:
        return;
    L22:
        if (r18.getMeasuredWidth() != getMeasuredWidth()) goto L28;
    L27:
        r16 = false;
    L28:
        r17 = r16;
        goto L29
    L25:
        if (r18.getMeasuredWidth() >= getMeasuredWidth()) goto L27;
    L32:
        return;
    L7:
        r11 = View.MeasureSpec.makeMeasureSpec(Math.min(r12, View.MeasureSpec.getSize(r11)), 1073741824);
        goto L8
    }

    @Override // android.view.View
    protected boolean overScrollBy(int r11, int r12, int r13, int r14, int r15, int r16, int r17, int r18, boolean r19) {
        return super.overScrollBy(r11, r12, r13, r14, r15, r16, 80, r18, r19);
    }

    public void setAutoFillWhenScrollable(boolean r10) {
        this.E = r10;
    }

    public void setContentInsetStart(int r10) {
        this.A = r10;
    }

    public void setCustomTabViewResId(int r10) {
        this.D = r10;
    }

    public void setIndicatorAnimEnable(boolean r10) {
        this.f7519c0 = r10;
        invalidate();
    }

    public void setIndicatorBounceEnable(boolean r10) {
        this.f7520d0 = r10;
    }

    public void setIndicatorCornerRadius(float r10) {
        this.U = r10;
        invalidate();
    }

    public void setOnTabClickListener(d r10) {
        this.f7536m0 = r10;
    }

    @Deprecated
    public void setOnTabSelectedListener(@Nullable e r10) {
        e r11 = this.F;
        if (r11 == null) goto L5;
        L(r11);
    L5:
        this.F = r10;
        if (r10 == null) goto L9;
        j(r10);
        return;
    }

    void setScrollAnimatorListener(Animator.AnimatorListener r10) {
        F();
        this.I.addListener(r10);
    }

    public void setSelectedTabHorizontalPadding(int r10) {
        this.f7527i.m(r10);
    }

    public void setSelectedTabIndicatorColor(@ColorInt int r10) {
        this.f7527i.j(r10);
    }

    public void setSelectedTabIndicatorHeight(int r10) {
        this.f7527i.l(r10);
    }

    public void setShowSelectedIndicator(Boolean r10) {
        this.f7527i.o(r10.booleanValue());
    }

    public void setShowTopLine(Boolean r10) {
        this.f7527i.p(r10.booleanValue());
    }

    public void setTabBackgroundResId(int r10) {
        this.f7547v = r10;
    }

    public void setTabGravity(int r10) {
        if (this.B == r10) goto L6;
        this.B = r10;
        s();
        return;
    }

    public void setTabMargin(int r10) {
        this.f7529j = D(r10);
        int r11 = 0;
    L4:
        if (r11 >= getTabCount()) goto L6;
        View r12 = this.f7527i.getChildAt(r11);
        ViewGroup.MarginLayoutParams r13 = (ViewGroup.MarginLayoutParams) r12.getLayoutParams();
        r13.leftMargin = D(r10);
        r13.rightMargin = D(r10);
        r12.setLayoutParams(r13);
        r11 = r11 + 1;
        goto L4
    }

    public void setTabMaxWidth(int r10) {
        this.f7550y = r10;
    }

    public void setTabMinWidth(int r10) {
        this.f7549x = r10;
    }

    public void setTabMode(int r10) {
        if (r10 == this.C) goto L6;
        this.C = r10;
        s();
        return;
    }

    public void setTabMode(String r10) {
        r10.hashCode();
        if (r10.equals("scrollable") == true) goto L12;
        if (r10.equals("fixed") == true) goto L8;
        return;
    L8:
        if (this.C == 1) goto L14;
        this.C = 1;
    L10:
        s();
        return;
    L14:
        return;
    L12:
        if (this.C == 0) goto L16;
        this.C = 0;
        goto L10
    }

    public void setTabPaddingBottom(int r10) {
        this.f7541p = r10;
    }

    public void setTabPaddingEnd(int r10) {
        this.f7539o = r10;
    }

    public void setTabPaddingStart(int r10) {
        this.f7535m = r10;
    }

    public void setTabPaddingTop(int r10) {
        this.f7537n = r10;
    }

    @Deprecated
    public void setTabTextAppearance(int r10) {
        this.f7542q = r10;
    }

    public void setTabTextColors(@Nullable ColorStateList r10) {
        if (this.f7543r == r10) goto L6;
        this.f7543r = r10;
        W();
        return;
    }

    public void setTabTextSize(float r10) {
        if (this.f7544s == r10) goto L6;
        this.f7544s = r10;
        W();
        return;
    }

    @Deprecated
    public void setTabsFromPagerAdapter(@Nullable PagerAdapter r10) {
        P(r10, false);
    }

    public void setupWithViewPager(@Nullable ViewPager r10) {
        U(r10, true);
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        if (getTabScrollRange() <= 0) goto L5;
        return true;
    L5:
        return false;
    }
}
