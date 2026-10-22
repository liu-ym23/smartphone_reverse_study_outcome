package com.obric.oui.tab;

import android.animation.Animator;
import android.animation.ArgbEvaluator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
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
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.text.Layout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.TooltipCompat;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.ColorUtils;
import androidx.core.util.Pools;
import androidx.core.view.GravityCompat;
import androidx.core.view.PointerIconCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TextViewCompat;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.plugin.R;
import com.obric.oui.bouncelayout.OHorizontalScrollView;
import com.obric.oui.common.style.k;
import com.obric.oui.common.style.l;
import com.obric.oui.layout.OUILinearLayout;
import com.obric.oui.material.MaterialToken;
import com.obric.oui.material.OMaterialHelper;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
@ViewPager.DecorView
public class OTabLayoutBase extends OHorizontalScrollView implements ValueAnimator.AnimatorUpdateListener, com.obric.oui.material.h {
    private static final Pools.Pool<g> A = null;
    private static final int[] aN = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Interpolator f14526b = null;
    private final ArrayList<g> B;
    private g C;
    private g D;
    private final f E;
    private float F;
    private int G;
    private int H;
    private int I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private int f14527J;
    private int K;
    private final int L;
    private int M;
    private c N;
    private final ArrayList<c> O;
    private c P;
    private ValueAnimator Q;
    private PagerAdapter R;
    private DataSetObserver S;
    private AdapterChangeListener T;
    private boolean U;
    private float V;
    private float W;
    private final Rect aA;
    private final Rect aB;
    private final Paint aC;
    private final com.obric.oui.tab.a aD;
    private final ValueAnimator aE;
    private final PathInterpolator aF;
    private final float[] aG;
    private final a aH;
    private final a aI;
    private int aJ;
    private boolean aK;
    private b aL;
    private final Pools.Pool<h> aM;
    private int aO;
    private Typeface aP;
    private Typeface aQ;
    private boolean aa;
    private int ab;
    private int ac;
    private Drawable ad;
    private float ae;
    private float af;
    private float ag;
    private final Paint ah;
    private final Paint ai;
    private final Paint aj;
    private final RectF ak;
    private final RectF al;
    private final RectF am;
    private final RectF an;
    private int ao;
    private boolean ap;
    private boolean aq;
    private int ar;
    private int as;
    private boolean at;
    private String au;
    private com.obric.oui.material.c[] av;
    private String aw;
    private com.obric.oui.material.c[] ax;
    private List<k> ay;
    private boolean az;
    protected boolean c;
    protected boolean d;
    protected WeakReference<View> e;
    protected int f;
    int g;
    int h;
    int i;
    int j;
    int k;
    int l;

    @Deprecated
    int m;
    ColorStateList n;
    int o;
    float p;
    float q;
    int r;
    int s;
    int t;
    int u;
    int v;
    int w;
    boolean x;
    ViewPager y;
    TabLayoutOnPageChangeListener z;

    private class AdapterChangeListener implements ViewPager.OnAdapterChangeListener {
        private boolean mAutoRefresh;
        final /* synthetic */ OTabLayoutBase this$0;

        AdapterChangeListener(OTabLayoutBase r1) {
            this.this$0 = r1;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnAdapterChangeListener
        public void onAdapterChanged(ViewPager r1, PagerAdapter r2, PagerAdapter r3) {
            if (this.this$0.y != r1) goto L6;
            this.this$0.a(r3, this.mAutoRefresh);
            return;
        }

        void setAutoRefresh(boolean r1) {
            this.mAutoRefresh = r1;
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

        public TabLayoutOnPageChangeListener(OTabLayoutBase r4) {
            this.mEvaluator = new ArgbEvaluator();
            this.mStartInterpolator = new AccelerateInterpolator();
            this.mEndInterpolator = new DecelerateInterpolator(1.6f);
            this.mTabLayoutRef = new WeakReference(r4);
            this.mStartColor = r4.getTabTextColors().getColorForState(OTabLayoutBase.g(), 0);
            this.mEndColor = r4.getTabTextColors().getDefaultColor();
        }

        private void changeTabColor(ImageView r1, TextView r2, int r3) {
            if (r1 == null) goto L7;
            if (r2 == null) goto L8;
            r2.setTextColor(r3);
            r1.setImageAlpha(Color.alpha(r3));
            return;
        L8:
            return;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int r2) {
            this.mPreviousScrollState = this.mScrollState;
            this.mScrollState = r2;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int r12, float r13, int r14) {
            OTabLayoutBase r15 = (OTabLayoutBase) ZeusTransformUtils.preCheckCast(this.mTabLayoutRef.get(), OTabLayoutBase.class, "com.obric.memorydata.plugin");
            if (r15 == null) goto L34;
            int r0 = this.mScrollState;
            if (r0 == 2) goto L7;
        L10:
            boolean r5 = true;
        L11:
            if (r0 == 2) goto L13;
        L16:
            boolean r1 = true;
        L17:
            r15.a(r12, r13, r5, r1);
            if (this.mScrollState == 2) goto L20;
        L22:
            OTabLayoutBase.h(r15).c = true;
            View r16 = OTabLayoutBase.h(r15).getChildAt(OTabLayoutBase.h(r15).f14537a);
            View r2 = OTabLayoutBase.h(r15).getChildAt(OTabLayoutBase.h(r15).f14537a + 1);
            if (r16 == null) goto L30;
            if (r2 == null) goto L30;
            View r3 = r16.findViewById(ZeusTransformUtils.mapRes(R.id.layout_tab_indicator, OaidModel.KEY_ID, "layout_tab_indicator"));
            View r6 = r2.findViewById(ZeusTransformUtils.mapRes(R.id.layout_tab_indicator, OaidModel.KEY_ID, "layout_tab_indicator"));
            if (r3 == null) goto L32;
            if (r6 == null) goto L32;
            float r17 = r16.getLeft() + ((r16.getWidth() - r3.getWidth()) / 2);
            float r7 = r3.getWidth() + r17;
            float r4 = r2.getLeft() + ((r2.getWidth() - r6.getWidth()) / 2);
            float r8 = r6.getWidth() + r4;
            ImageView r9 = (ImageView) ZeusTransformUtils.preCheckCast(r3.findViewById(ZeusTransformUtils.mapRes(R.id.tab_item_img, OaidModel.KEY_ID, "tab_item_img")), ImageView.class, "com.obric.memorydata.plugin");
            TextView r10 = (TextView) ZeusTransformUtils.preCheckCast(r3.findViewById(ZeusTransformUtils.mapRes(R.id.tab_item_text, OaidModel.KEY_ID, "tab_item_text")), TextView.class, "com.obric.memorydata.plugin");
            ImageView r11 = (ImageView) ZeusTransformUtils.preCheckCast(r6.findViewById(ZeusTransformUtils.mapRes(R.id.tab_item_img, OaidModel.KEY_ID, "tab_item_img")), ImageView.class, "com.obric.memorydata.plugin");
            TextView r18 = (TextView) ZeusTransformUtils.preCheckCast(r6.findViewById(ZeusTransformUtils.mapRes(R.id.tab_item_text, OaidModel.KEY_ID, "tab_item_text")), TextView.class, "com.obric.memorydata.plugin");
            changeTabColor(r9, r10, ((Integer) ZeusTransformUtils.preCheckCast(this.mEvaluator.evaluate(r13, Integer.valueOf(this.mStartColor), Integer.valueOf(this.mEndColor)), Integer.class, "com.obric.memorydata.plugin")).intValue());
            changeTabColor(r11, r18, ((Integer) ZeusTransformUtils.preCheckCast(this.mEvaluator.evaluate(r13, Integer.valueOf(this.mEndColor), Integer.valueOf(this.mStartColor)), Integer.class, "com.obric.memorydata.plugin")).intValue());
            f.a(OTabLayoutBase.h(r15), r17 + ((r4 - r17) * this.mStartInterpolator.getInterpolation(r13)));
            f.b(OTabLayoutBase.h(r15), r7 + ((r8 - r7) * this.mStartInterpolator.getInterpolation(r13)));
        L32:
            ViewCompat.postInvalidateOnAnimation(OTabLayoutBase.h(r15));
            return;
        L30:
            if (OTabLayoutBase.j(r15) == false) goto L32;
        L21:
            OTabLayoutBase.h(r15).c = false;
            goto L32
        L20:
            if (this.mPreviousScrollState != 0) goto L22;
        L13:
            if (this.mPreviousScrollState != 0) goto L16;
            r1 = false;
            goto L17
        L7:
            if (this.mPreviousScrollState == 1) goto L10;
            r5 = false;
            goto L11
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int r4) {
            OTabLayoutBase r0 = (OTabLayoutBase) ZeusTransformUtils.preCheckCast(this.mTabLayoutRef.get(), OTabLayoutBase.class, "com.obric.memorydata.plugin");
            if (r0 != null) goto L5;
            return;
        L5:
            if (r0.getSelectedTabPosition() != r4) goto L7;
            return;
        L7:
            if (r4 >= r0.getTabCount()) goto L21;
            int r1 = this.mScrollState;
            if (r1 != 0) goto L11;
        L16:
            boolean r3 = true;
        L17:
            r0.b(r0.c(r4), r3);
            return;
        L11:
            if (r1 == 2) goto L13;
        L15:
            r3 = false;
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

        public TabLayoutOnPageChangeListenerIndependent(OTabLayoutBase r3) {
            boolean r0 = false;
            this.lastPosition = 0;
            this.mTabLayoutRef = new WeakReference(r3);
            if (ViewCompat.getLayoutDirection(r3) != 1) goto L5;
            r0 = true;
        L5:
            this.isRtl = r0;
        }

        public /* synthetic */ void lambda$onPageScrolled$0$OTabLayoutBase$TabLayoutOnPageChangeListenerIndependent(int r3, int r4, OTabLayoutBase r5, boolean r6, boolean r7, ValueAnimator r8) {
            float r9 = ((Float) ZeusTransformUtils.preCheckCast(r8.getAnimatedValue(), Float.class, "com.obric.memorydata.plugin")).floatValue();
            if (r3 < r4) goto L5;
        L7:
            r9 = 1.0f - r9;
        L8:
            r5.a(r4, r9, r6, r7);
            return;
        L5:
            if (this.isRtl == true) goto L7;
            r4 = r4 - 1;
            goto L8
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int r2) {
            this.mPreviousScrollState = this.mScrollState;
            this.mScrollState = r2;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(final int r11, float r12, int r13) {
            final OTabLayoutBase r14 = (OTabLayoutBase) ZeusTransformUtils.preCheckCast(this.mTabLayoutRef.get(), OTabLayoutBase.class, "com.obric.memorydata.plugin");
            if (this.lastPosition != r11) goto L5;
            return;
        L5:
            if (r14 == null) goto L21;
            int r15 = this.mScrollState;
            if (r15 == 2) goto L9;
        L12:
            boolean r7 = true;
        L13:
            if (r15 == 2) goto L15;
        L18:
            boolean r16 = true;
        L19:
            ValueAnimator r8 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f}).setDuration(200);
            final int r2 = this.lastPosition;
            final boolean r5 = r7;
            final boolean r6 = r16;
            r8.addUpdateListener(new $$Lambda$OTabLayoutBase$TabLayoutOnPageChangeListenerIndependent$DGgYjf1s_M3tpjwgWOD5P9Kzhmw(this, r2, r11, r14, r5, r6));
            this.lastPosition = r11;
            final boolean r4 = r7;
            final boolean r9 = r16;
            r8.addListener(new AnonymousClass1(this, r14, r11, r4, r9));
            r8.start();
            return;
        L15:
            if (this.mPreviousScrollState != 0) goto L18;
            r16 = false;
            goto L19
        L9:
            if (this.mPreviousScrollState == 1) goto L12;
            r7 = false;
            goto L13
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int r4) {
            OTabLayoutBase r0 = (OTabLayoutBase) ZeusTransformUtils.preCheckCast(this.mTabLayoutRef.get(), OTabLayoutBase.class, "com.obric.memorydata.plugin");
            if (r0 != null) goto L5;
            return;
        L5:
            if (r0.getSelectedTabPosition() != r4) goto L7;
            return;
        L7:
            if (r4 >= r0.getTabCount()) goto L21;
            int r1 = this.mScrollState;
            if (r1 != 0) goto L11;
        L16:
            boolean r3 = true;
        L17:
            r0.b(r0.c(r4), r3);
            return;
        L11:
            if (r1 == 2) goto L13;
        L15:
            r3 = false;
            goto L17
        L13:
            if (this.mPreviousScrollState != 0) goto L15;
        }

        void reset() {
            this.mPreviousScrollState = 0;
            this.mScrollState = 0;
        }
    }

    public class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f14533a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f14534b;
        final /* synthetic */ OTabLayoutBase c;

        public a(OTabLayoutBase r1) {
            this.c = r1;
            this.f14533a = 0.0f;
            this.f14534b = 0.0f;
        }

        public String toString() {
            return "(left = " + this.f14533a + ", right = " + this.f14534b + ")";
        }
    }

    public interface b {
        void a(g r1);
    }

    public interface c {
        void a(g r1);

        void b(g r1);

        void c(g r1);
    }

    private class d extends DataSetObserver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OTabLayoutBase f14535a;

        d(OTabLayoutBase r1) {
            this.f14535a = r1;
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            this.f14535a.e();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            this.f14535a.e();
        }
    }

    public class e implements TypeEvaluator<a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OTabLayoutBase f14536a;

        public e(OTabLayoutBase r1) {
            this.f14536a = r1;
        }

        public a a(float r4, a r5, a r6) {
            float r0 = r5.f14533a + ((r6.f14533a - r5.f14533a) * r4);
            float r1 = r5.f14534b + (r4 * (r6.f14534b - r5.f14534b));
            a r7 = new a(this.f14536a);
            r7.f14533a = r0;
            r7.f14534b = r1;
            return r7;
        }

        @Override // android.animation.TypeEvaluator
        public /* synthetic */ a evaluate(float r3, a r4, a r5) {
            return a(r3, (a) ZeusTransformUtils.preCheckCast(r4, a.class, "com.obric.memorydata.plugin"), (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.memorydata.plugin"));
        }
    }

    private class f extends OUILinearLayout {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f14537a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        float f14538b;
        public boolean c;
        final /* synthetic */ OTabLayoutBase d;
        private int e;
        private final Paint f;
        private int g;
        private int h;
        private int i;
        private ValueAnimator j;
        private int k;
        private int l;
        private float m;
        private float n;
        private int o;
        private boolean p;
        private boolean q;
        private boolean r;
        private Paint s;
        private Paint t;
        private final float u;
        private boolean v;

        f(OTabLayoutBase r3, Context r4) {
            Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
            this.d = r3;
            super(r5);
            this.f14537a = -1;
            this.g = -1;
            this.h = -1;
            this.i = -1;
            this.k = r3.d(27);
            this.l = Integer.MAX_VALUE;
            setChangeAlphaWhenPress(false);
            setClipChildren(false);
            setClipToPadding(false);
            setWillNotDraw(false);
            this.f = new Paint();
            this.u = r3.a(0.6f);
            setChangeAlphaWhenDisable(false);
        }

        static /* synthetic */ float a(f r0, float r1) {
            r0.m = r1;
            return r1;
        }

        static /* synthetic */ float b(f r0, float r1) {
            r0.n = r1;
            return r1;
        }

        private void c() {
            View r0 = getChildAt(this.f14537a);
            int r1 = -1;
            if (r0 != null) goto L5;
        L11:
            int r2 = -1;
        L12:
            a(r1, r2);
            return;
        L5:
            if (r0.getWidth() <= 0) goto L11;
            r1 = r0.getLeft();
            r2 = r0.getRight();
            if (this.f14538b <= 0.0f) goto L12;
            if (this.f14537a >= (getChildCount() - 1)) goto L12;
            View r3 = getChildAt(this.f14537a + 1);
            float r4 = this.f14538b * r3.getLeft();
            float r5 = this.f14538b;
            r1 = (int) (r4 + ((1.0f - r5) * r1));
            r2 = (int) ((r5 * r3.getRight()) + ((1.0f - this.f14538b) * r2));
            goto L12
        }

        int a(int r1, int r2, float r3) {
            return r1 + Math.round(r3 * (r2 - r1));
        }

        void a(int r2) {
            if (this.f.getColor() == r2) goto L6;
            this.f.setColor(r2);
            ViewCompat.postInvalidateOnAnimation(this);
            return;
        }

        void a(int r2, float r3) {
            ValueAnimator r0 = this.j;
            if (r0 != null) goto L5;
        L7:
            this.f14537a = r2;
            this.f14538b = r3;
            c();
            return;
        L5:
            if (r0.isRunning() == false) goto L7;
            this.j.cancel();
            goto L7
        }

        void a(int r2, int r3) {
            if (r2 == this.h) goto L5;
        L6:
            this.h = r2;
            this.i = r3;
            ViewCompat.postInvalidateOnAnimation(this);
            return;
        L5:
            if (r3 != this.i) goto L6;
        }

        void a(boolean r5) {
            this.p = r5;
            if (r5 == false) goto L6;
            Paint r6 = new Paint();
            this.s = r6;
            r6.setColor(ContextCompat.getColor((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.color.oui_line_2, TypedValues.Custom.S_COLOR, "oui_line_2")));
            this.s.setStyle(Paint.Style.FILL);
            return;
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

        float b() {
            return this.f14537a + this.f14538b;
        }

        void b(int r2) {
            if (this.e == r2) goto L6;
            this.e = r2;
            ViewCompat.postInvalidateOnAnimation(this);
            return;
        }

        void b(final int r10, int r11) {
            ValueAnimator r0 = this.j;
            if (r0 == null) goto L8;
            if (r0.isRunning() == false) goto L8;
            this.j.cancel();
        L8:
            if (ViewCompat.getLayoutDirection(this) != 1) goto L10;
            boolean r1 = true;
        L11:
            View r2 = getChildAt(r10);
            if (r2 != null) goto L15;
            c();
            return;
        L15:
            final int r6 = r2.getLeft();
            final int r8 = r2.getRight();
            if (Math.abs(r10 - this.f14537a) > 1) goto L18;
            final int r5 = this.h;
            final int r7 = this.i;
        L26:
            if (r5 != r6) goto L28;
            if (r7 != r8) goto L28;
            return;
        L28:
            ValueAnimator r3 = new ValueAnimator();
            this.j = r3;
            r3.setInterpolator(OTabLayoutBase.f());
            r3.setDuration(r11);
            r3.setFloatValues(new float[]{0.0f, 1.0f});
            r3.addUpdateListener(new AnonymousClass1(this, r5, r6, r7, r8));
            r3.addListener(new AnonymousClass2(this, r10));
            r3.start();
            return;
        L18:
            int r4 = this.d.d(24);
            if (r10 >= this.f14537a) goto L22;
            if (r1 == true) goto L24;
        L23:
            r5 = r4 + r8;
        L25:
            r7 = r5;
        L24:
            r5 = r6 - r4;
            goto L25
        L22:
            if (r1 == false) goto L24;
        L10:
            r1 = false;
            goto L11
        }

        void b(boolean r5) {
            this.q = r5;
            if (r5 == false) goto L6;
            Paint r6 = new Paint();
            this.t = r6;
            r6.setColor(ContextCompat.getColor((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.color.oui_line_2, TypedValues.Custom.S_COLOR, "oui_line_2")));
            this.t.setStyle(Paint.Style.FILL);
            this.t.setStrokeWidth(this.u);
            return;
        }

        public void c(int r1) {
            this.o = r1;
        }

        void c(boolean r1) {
            this.r = r1;
        }

        void d(boolean r2) {
            if (this.v == r2) goto L6;
            this.v = r2;
            ViewCompat.postInvalidateOnAnimation(this);
            return;
        }

        @Override // com.obric.oui.layout.OUILinearLayout, android.view.View
        public void draw(Canvas r18) {
            super.draw(r18);
            if (this.p == false) goto L6;
            r18.drawLine(getLeft(), getBottom() - this.d.a(0.6f), getRight() * 2, getBottom(), this.s);
        L6:
            if (this.q == false) goto L8;
            r18.drawLine(getLeft(), this.u + getTop(), getRight() * 2, this.u + getTop(), this.t);
        L8:
            int r1 = this.h;
            if (r1 >= 0) goto L11;
            return;
        L11:
            if (this.i > r1) goto L13;
            return;
        L13:
            if (this.r == false) goto L35;
            View r2 = getChildAt(this.d.getSelectedTabPosition());
            if (r2 == null) goto L26;
            View r13 = r2.findViewById(ZeusTransformUtils.mapRes(R.id.layout_tab_indicator, OaidModel.KEY_ID, "layout_tab_indicator"));
            if (r13 == null) goto L26;
            if (this.d.y != null) goto L21;
        L22:
            int r3 = this.h;
            float r4 = r3 + (((this.i - r3) - r13.getWidth()) / 2);
            this.m = r4;
            this.n = r4 + r13.getWidth();
        L23:
            Path r5 = new Path();
            r5.addRoundRect(new RectF(((this.m + this.n) / 2.0f) - this.d.d(3), (getHeight() - getPaddingBottom()) - this.d.d(4), ((this.m + this.n) / 2.0f) + this.d.d(3), getHeight() - getPaddingBottom()), new float[]{this.d.d(3), this.d.d(3), this.d.d(3), this.d.d(3), this.d.d(1), this.d.d(1), this.d.d(1), this.d.d(1)}, Path.Direction.CCW);
            r18.drawPath(r5, this.f);
            return;
        L21:
            if (this.c == true) goto L23;
        L26:
            if (this.v == false) goto L28;
        L30:
            float r14 = this.h;
            float r6 = this.i;
        L31:
            Path r7 = new Path();
            float r15 = (r14 + r6) / 2.0f;
            r7.addRoundRect(new RectF(r15 - this.d.d(3), (getHeight() - getPaddingBottom()) - this.d.d(4), r15 + this.d.d(3), getHeight() - getPaddingBottom()), new float[]{this.d.d(3), this.d.d(3), this.d.d(3), this.d.d(3), this.d.d(1), this.d.d(1), this.d.d(1), this.d.d(1)}, Path.Direction.CCW);
            r18.drawPath(r7, this.f);
            return;
        L28:
            if (ZeusTransformUtils.instanceOf(r2, h.class) == false) goto L30;
            float r8 = (this.h + this.i) * 0.5f;
            r14 = r8 - (((h) ZeusTransformUtils.preCheckCast(r2, h.class, "com.obric.memorydata.plugin")).getContentWidth() * 0.5f);
            r6 = r8 + (((h) ZeusTransformUtils.preCheckCast(r2, h.class, "com.obric.memorydata.plugin")).getContentWidth() * 0.5f);
            goto L31
        }

        @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
        public void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
            super.onLayout(r1, r2, r3, r4, r5);
            ValueAnimator r6 = this.j;
            if (r6 != null) goto L5;
        L7:
            c();
            return;
        L5:
            if (r6.isRunning() == false) goto L7;
            this.j.cancel();
            b(this.f14537a, Math.round((1.0f - this.j.getAnimatedFraction()) * this.j.getDuration()));
        }

        @Override // com.obric.oui.layout.OUILinearLayout, android.widget.LinearLayout, android.view.View
        public void onMeasure(int r12, int r13) {
            super.onMeasure(r12, r13);
            int r0 = getChildCount();
            boolean r4 = true;
            int r5 = 0;
            if (View.MeasureSpec.getMode(r12) != 1073741824) goto L5;
            Drawable r1 = getDividerDrawable();
            if (r1 == null) goto L28;
            int r2 = r1.getIntrinsicWidth();
        L29:
            int r6 = 0;
            int r7 = 0;
        L30:
            if (r6 >= r0) goto L35;
            View r8 = getChildAt(r6);
            if (r8.getVisibility() != 0) goto L34;
            r7 = Math.max(r7, r8.getMeasuredWidth());
            this.l = Math.min(this.l, r8.getMeasuredWidth());
        L34:
            r6 = r6 + 1;
            goto L30
        L35:
            int r9 = (getPaddingLeft() + getPaddingRight()) + (r2 * (r0 - 1));
            if (this.d.v != 1) goto L56;
            if (this.d.u != 1) goto L56;
            if (r7 > 0) goto L42;
            return;
        L42:
            if ((r7 * r0) > (getMeasuredWidth() - r9)) goto L52;
            boolean r3 = false;
        L44:
            if (r5 >= r0) goto L51;
            LinearLayout.LayoutParams r10 = (LinearLayout.LayoutParams) ZeusTransformUtils.preCheckCast(getChildAt(r5).getLayoutParams(), LinearLayout.LayoutParams.class, "com.obric.memorydata.plugin");
            if (r10.width == r7) goto L48;
        L49:
            r10.width = r7;
            r10.weight = 0.0f;
            r3 = true;
        L50:
            r5 = r5 + 1;
            goto L44
        L48:
            if (r10.weight == 0.0f) goto L50;
        L51:
            r4 = r3;
        L53:
            if (r4 == false) goto L119;
        L93:
            super.onMeasure(r12, r13);
            return;
        L119:
            return;
        L52:
            this.d.u = 0;
            this.d.c(false);
        L56:
            if (this.d.v == 0) goto L58;
            return;
        L58:
            if (this.d.x == true) goto L60;
            return;
        L60:
            if (OTabLayoutBase.i(this.d) == ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getConfiguration().orientation) goto L62;
            return;
        L62:
            if (r7 > 0) goto L64;
            return;
        L64:
            int r11 = 0;
            int r14 = 0;
        L66:
            if (r11 >= r0) goto L71;
            View r15 = getChildAt(r11);
            if (r15.getVisibility() == 8) goto L70;
            r14 = r14 + r15.getMeasuredWidth();
        L70:
            r11 = r11 + 1;
            goto L66
        L71:
            if (r14 > 0) goto L73;
            return;
        L73:
            int r16 = getMeasuredWidth() - r9;
            if (r14 < r16) goto L76;
        L92:
            if (r5 != 0) goto L93;
            return;
        L76:
            if ((r7 * r0) >= r16) goto L85;
            int r17 = 0;
            int r18 = 0;
        L78:
            if (r17 >= r0) goto L91;
            LinearLayout.LayoutParams r19 = (LinearLayout.LayoutParams) ZeusTransformUtils.preCheckCast(getChildAt(r17).getLayoutParams(), LinearLayout.LayoutParams.class, "com.obric.memorydata.plugin");
            if (r19.width == 0) goto L82;
        L83:
            r19.width = 0;
            r19.weight = 1.0f;
            r18 = 1;
        L84:
            r17 = r17 + 1;
            goto L78
        L82:
            if (r19.weight == 1.0f) goto L84;
        L91:
            r5 = r18;
            goto L92
        L85:
            int r20 = (r16 - r14) / (r0 * 2);
            r18 = 0;
        L86:
            if (r5 >= r0) goto L91;
            if (getChildAt(r5).getVisibility() == 8) goto L90;
            LinearLayout.LayoutParams r21 = (LinearLayout.LayoutParams) ZeusTransformUtils.preCheckCast(getChildAt(r5).getLayoutParams(), LinearLayout.LayoutParams.class, "com.obric.memorydata.plugin");
            r21.leftMargin = r20;
            r21.rightMargin = r20;
            r18 = 1;
        L90:
            r5 = r5 + 1;
            goto L86
        L28:
            r2 = 0;
            goto L29
        L5:
            if (this.d.v == 1) goto L7;
            return;
        L7:
            if (this.d.u != 1) goto L117;
            int r22 = 0;
            int r23 = 0;
        L9:
            if (r22 >= r0) goto L14;
            View r24 = getChildAt(r22);
            if (r24.getVisibility() != 0) goto L13;
            r23 = Math.max(r23, r24.getMeasuredWidth());
            this.l = Math.min(this.l, r24.getMeasuredWidth());
        L13:
            r22 = r22 + 1;
            goto L9
        L14:
            int r25 = Math.min(this.d.t, r23);
            boolean r26 = false;
        L15:
            if (r5 >= r0) goto L22;
            LinearLayout.LayoutParams r27 = (LinearLayout.LayoutParams) ZeusTransformUtils.preCheckCast(getChildAt(r5).getLayoutParams(), LinearLayout.LayoutParams.class, "com.obric.memorydata.plugin");
            if (r27.width == r25) goto L19;
        L20:
            r27.width = r25;
            r27.weight = 0.0f;
            r26 = true;
        L21:
            r5 = r5 + 1;
            goto L15
        L19:
            if (r27.weight == 0.0f) goto L21;
        L22:
            if (r26 == false) goto L118;
            super.onMeasure(r12, r13);
            return;
        L118:
            return;
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onRtlPropertiesChanged(int r3) {
            super.onRtlPropertiesChanged(r3);
            if (Build.VERSION.SDK_INT < 23) goto L5;
            return;
        L5:
            if (this.g == r3) goto L9;
            requestLayout();
            this.g = r3;
            return;
        }

        @Override // com.obric.oui.layout.OUILinearLayout, android.view.View
        public void setEnabled(boolean r4) {
            super.setEnabled(r4);
            int r0 = getChildCount();
            int r1 = 0;
        L3:
            if (r1 >= r0) goto L5;
            this.d.f(r1).setEnabled(r4);
            r1 = r1 + 1;
            goto L3
        }
    }

    public static final class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        OTabLayoutBase f14543a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        h f14544b;
        private Object c;
        private Drawable d;
        private CharSequence e;
        private CharSequence f;
        private int g;
        private View h;

        g() {
            this.g = -1;
        }

        public View a() {
            return this.h;
        }

        public g a(int r5) {
            return a(ZeusTransformUtils.inflate(LayoutInflater.from((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f14544b.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")), r5, this.f14544b, false, "com.obric.memorydata.plugin"));
        }

        public g a(Drawable r1) {
            this.d = r1;
            i();
            return this;
        }

        public g a(View r1) {
            this.h = r1;
            i();
            return this;
        }

        public g a(CharSequence r3) {
            this.e = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
            i();
            return this;
        }

        public Drawable b() {
            return this.d;
        }

        public g b(CharSequence r3) {
            this.f = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
            i();
            return this;
        }

        void b(int r1) {
            this.g = r1;
        }

        void b(View r1) {
            this.f14544b.setBackdropTarget(r1);
        }

        public int c() {
            return this.g;
        }

        public g c(int r3) {
            OTabLayoutBase r0 = this.f14543a;
            if (r0 == null) goto L7;
            return a(ZeusTransformUtils.getResources(r0, "com.obric.memorydata.plugin").getText(r3));
        L7:
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }

        public CharSequence d() {
            return this.e;
        }

        void d(int r1) {
            this.f14544b.b(r1);
        }

        public void e() {
            OTabLayoutBase r0 = this.f14543a;
            if (r0 == null) goto L7;
            r0.b(this);
            return;
        L7:
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }

        public boolean f() {
            OTabLayoutBase r0 = this.f14543a;
            if (r0 == null) goto L10;
            if (r0.getSelectedTabPosition() != this.g) goto L7;
            return true;
        L7:
            return false;
        L10:
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }

        public CharSequence g() {
            return this.f;
        }

        public h h() {
            return this.f14544b;
        }

        void i() {
            h r0 = this.f14544b;
            if (r0 == null) goto L6;
            r0.update();
            return;
        }

        void j() {
            this.f14543a = null;
            this.f14544b = null;
            this.c = null;
            this.d = null;
            this.e = null;
            this.f = null;
            this.g = -1;
            this.h = null;
        }
    }

    public class h extends OUILinearLayout implements com.obric.oui.material.h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OTabLayoutBase f14545a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private g f14546b;
        private TextView c;
        private ImageView d;
        private View e;
        private TextView f;
        private ImageView g;
        private int h;
        private boolean i;
        private com.obric.oui.material.c[] j;
        private com.obric.oui.material.c[] k;
        private com.obric.oui.material.c[] l;
        private boolean m;
        private com.obric.common.oea.foundation.animation.d.d n;
        private com.obric.common.oea.foundation.animation.d.d o;

        public h(OTabLayoutBase r5, Context r6, boolean r7, com.obric.oui.material.c[] r8, com.obric.oui.material.c[] r9) {
            Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.memorydata.plugin");
            this.f14545a = r5;
            super(r10);
            this.h = 1;
            this.m = true;
            setEnableShadowWidthRadius(true);
            setRadius((int) OTabLayoutBase.a(r5));
            setShadowCornerRadius((int) OTabLayoutBase.a(r5));
            ((com.obric.oui.common.style.c) ZeusTransformUtils.preCheckCast(getAlphaHelper(), com.obric.oui.common.style.c.class, "com.obric.memorydata.plugin")).a((int) OTabLayoutBase.a(r5));
            this.i = r7;
            a(r8, r9);
            if (OTabLayoutBase.b(r5) == null) goto L6;
            setOverridePressColor(ContextCompat.getColor(r10, ZeusTransformUtils.mapRes(R.color.oui_basic_fill_element_2, TypedValues.Custom.S_COLOR, "oui_basic_fill_element_2")));
            refreshColors("OTabLayoutBase");
        L6:
            if (r5.r == 0) goto L9;
            ViewCompat.setBackground(this, AppCompatResources.getDrawable(r10, r5.r));
        L9:
            if (OTabLayoutBase.b(r5) == null) goto L11;
            boolean r11 = true;
        L12:
            setChangeAlphaWhenPress(r11);
            setChangeAlphaWhenDisable(false);
            setChangeAlphaWhenSelected(false);
            ViewCompat.setPaddingRelative(this, r5.h, r5.i, r5.j, r5.k);
            setMinimumWidth(r5.g);
            setGravity(17);
            setOrientation(1);
            setClickable(true);
            ViewCompat.setPointerIcon(this, PointerIconCompat.getSystemIcon((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), 1002));
            if (this.i == false) goto L16;
            c(isSelected());
            return;
        L16:
            return;
        L11:
            r11 = false;
            goto L12
        }

        private float a(Layout r1, int r2, float r3) {
            return r1.getLineWidth(r2) * (r3 / r1.getPaint().getTextSize());
        }

        private void a(float r2) {
            setChangeAlphaWhenDisable(false);
            setChangeAlphaWhenSelected(false);
            TextView r0 = this.c;
            if (r0 == null) goto L5;
            r0.setAlpha(r2);
        L5:
            ImageView r1 = this.d;
            if (r1 == null) goto L8;
            r1.setAlpha(r2);
        L8:
            TextView r3 = this.f;
            if (r3 == null) goto L11;
            r3.setAlpha(r2);
        L11:
            ImageView r4 = this.g;
            if (r4 == null) goto L14;
            r4.setAlpha(r2);
        L14:
            View r5 = this.e;
            if (r5 == null) goto L18;
            r5.setAlpha(r2);
            return;
        }

        private void a(TextView r8, ImageView r9) {
            g r0 = this.f14546b;
            CharSequence r1 = null;
            if (r0 == null) goto L5;
            Drawable r2 = r0.b();
        L6:
            g r3 = this.f14546b;
            if (r3 == null) goto L9;
            CharSequence r4 = r3.d();
        L10:
            g r5 = this.f14546b;
            if (r5 == null) goto L13;
            CharSequence r6 = r5.g();
        L14:
            int r7 = 0;
            if (r9 == null) goto L20;
            if (r2 == null) goto L18;
            r9.setImageDrawable(r2);
            r9.setVisibility(0);
            setVisibility(0);
        L19:
            r9.setContentDescription(r6);
            goto L20
        L18:
            r9.setVisibility(8);
            r9.setImageDrawable(null);
        L20:
            boolean r10 = !TextUtils.isEmpty(r4);
            if (r8 == null) goto L29;
            boolean r11 = !TextUtils.equals(r8.getText(), r4);
            if (r10 == false) goto L25;
            r8.setText(r4);
            r8.setVisibility(0);
            setVisibility(0);
        L26:
            r8.setContentDescription(r6);
            if (r11 == false) goto L29;
            r8.requestLayout();
            requestLayout();
            OTabLayoutBase.h(this.f14545a).requestLayout();
            goto L29
        L25:
            r8.setVisibility(8);
            r8.setText(null);
        L29:
            if (r9 == null) goto L38;
            ViewGroup.MarginLayoutParams r12 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r9.getLayoutParams(), ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin");
            if (r10 == false) goto L36;
            if (r9.getVisibility() != 0) goto L36;
            r7 = this.f14545a.d(8);
        L36:
            if (r7 == r12.bottomMargin) goto L38;
            r12.bottomMargin = r7;
            r9.requestLayout();
        L38:
            if (r10 == true) goto L41;
            r1 = r6;
        L41:
            TooltipCompat.setTooltipText(this, r1);
            return;
        L13:
            r6 = null;
            goto L14
        L9:
            r4 = null;
            goto L10
        L5:
            r2 = null;
            goto L6
        }

        static /* synthetic */ void a(h r0, float r1) {
            r0.a(r1);
        }

        private void a(boolean r3, List<k> r4) {
            List<k> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
            if (isEnabled() == true) goto L5;
            return;
        L5:
            if (OTabLayoutBase.b(this.f14545a) == null) goto L22;
            com.obric.common.oea.foundation.animation.d.d r0 = this.n;
            if (r0 == null) goto L10;
            r0.a(false);
        L10:
            com.obric.common.oea.foundation.animation.d.d r1 = this.o;
            if (r1 == null) goto L13;
            r1.a(false);
        L13:
            if (r3 == false) goto L15;
            List<k> r6 = getCurrentShadows();
            this.n = l.a(this, getScaleX(), 0.98f, r6, OTabLayoutBase.b(this.f14545a));
            return;
        L15:
            if (r5 != null) goto L18;
            r5 = getCurrentShadows();
        L18:
            this.o = l.a(this, getScaleX(), 1.0f, OTabLayoutBase.b(this.f14545a), r5);
            return;
        }

        private void b() {
            if (this.j != null) goto L5;
            return;
        L5:
            int r0 = (int) com.obric.oui.common.util.h.a(99.0f, (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
            setShadowCornerRadius(r0);
            setRadius(r0);
            if (OTabLayoutBase.b(this.f14545a) == null) goto L8;
            ((com.obric.oui.common.style.c) ZeusTransformUtils.preCheckCast(getAlphaHelper(), com.obric.oui.common.style.c.class, "com.obric.memorydata.plugin")).a(r0);
        L8:
            boolean r1 = this.m;
            if (r1 == false) goto L11;
            int r3 = 2;
        L13:
            if (r1 == false) goto L15;
            com.obric.oui.material.l.a(this, this.j, false, r3, null);
        L17:
            if (c() == true) goto L19;
            d();
        L19:
            GradientDrawable r2 = new GradientDrawable();
            r2.setShape(0);
            r2.setCornerRadius(com.obric.oui.common.util.h.a(99.0f, (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")));
            r2.setColor(0);
            setBackground(r2);
            setOutlineProvider(ViewOutlineProvider.BACKGROUND);
            return;
        L15:
            com.obric.oui.material.l.a(this, this.j, false, null);
            goto L17
        L11:
            r3 = 3;
            goto L13
        }

        private void c(boolean r6) {
            k r1 = null;
            if (this.i == true) goto L15;
            e();
            if (r6 == true) goto L7;
        L12:
            d();
        L13:
            b(false);
            return;
        L7:
            if (OTabLayoutBase.b(this.f14545a) == null) goto L12;
            k r7 = (k) ZeusTransformUtils.preCheckCast(OTabLayoutBase.b(this.f14545a).get(0), k.class, "com.obric.memorydata.plugin");
            if (OTabLayoutBase.b(this.f14545a).size() <= 1) goto L11;
            r1 = (k) ZeusTransformUtils.preCheckCast(OTabLayoutBase.b(this.f14545a).get(1), k.class, "com.obric.memorydata.plugin");
        L11:
            a(r7, r1);
            goto L13
        L15:
            if (r6 == false) goto L19;
            com.obric.oui.material.c[] r0 = this.l;
            if (r0 == null) goto L19;
        L20:
            this.j = r0;
            if (r0 == null) goto L30;
            b();
            b(true);
            if (r6 == true) goto L25;
            return;
        L25:
            if (OTabLayoutBase.b(this.f14545a) == null) goto L33;
            k r8 = (k) ZeusTransformUtils.preCheckCast(OTabLayoutBase.b(this.f14545a).get(0), k.class, "com.obric.memorydata.plugin");
            if (OTabLayoutBase.b(this.f14545a).size() <= 1) goto L29;
            r1 = (k) ZeusTransformUtils.preCheckCast(OTabLayoutBase.b(this.f14545a).get(1), k.class, "com.obric.memorydata.plugin");
        L29:
            a(r8, r1);
            return;
        L33:
            return;
        L30:
            e();
            d();
            b(false);
            return;
        L19:
            r0 = this.k;
            goto L20
        }

        private boolean c() {
            com.obric.oui.material.c[] r0 = this.j;
            if (r0 != null) goto L5;
            return false;
        L5:
            if (r0.length == 0) goto L19;
            int r1 = OMaterialHelper.b((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
            int r2 = Math.max(0, Math.min(this.j.length - 1, r1 - 1));
            com.obric.oui.material.c r4 = this.j[r2];
            if (r4 != null) goto L10;
            return false;
        L10:
            if (r4.i() != null) goto L12;
            return false;
        L12:
            if (r4.i().length > 0) goto L14;
            return false;
        L14:
            return true;
        L19:
            return false;
        }

        private void d() {
            a(k.f13496b.j(), k.f13496b.j());
        }

        private void e() {
            if (this.f14545a.r == 0) goto L5;
            ViewCompat.setBackground(this, AppCompatResources.getDrawable((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), this.f14545a.r));
        L6:
            setOutlineProvider(null);
            return;
        L5:
            setBackground(null);
            goto L6
        }

        private void f() {
            com.obric.common.oea.foundation.animation.d.d r0 = this.n;
            if (r0 == null) goto L5;
            r0.a(false);
        L5:
            com.obric.common.oea.foundation.animation.d.d r1 = this.o;
            if (r1 == null) goto L8;
            r1.a(false);
        L8:
            setScaleX(1.0f);
            setScaleY(1.0f);
            c(isSelected());
        }

        void a() {
            setTab(null);
            setSelected(false);
        }

        void a(g r2, boolean r3) {
            if (r2 == this.f14546b) goto L8;
            this.f14546b = r2;
            if (r3 == false) goto L9;
            update();
            return;
        L9:
            return;
        }

        public void a(boolean r1) {
            this.i = r1;
            if (r1 == false) goto L5;
            c(isSelected());
            return;
        L5:
            e();
            d();
            b(false);
        }

        public void a(com.obric.oui.material.c[] r1, com.obric.oui.material.c[] r2) {
            this.k = r1;
            this.l = r2;
            this.j = r1;
        }

        @Override // com.obric.oui.material.h
        public void b(int r2) {
            if (this.i == true) goto L5;
            return;
        L5:
            OMaterialHelper.b(this, r2);
        }

        public void b(boolean r4) {
            boolean r1 = true;
            if (this.m == false) goto L11;
            if (this.i == false) goto L8;
            if (r4 == false) goto L8;
        L9:
            OMaterialHelper.a(this, r1);
            return;
        L8:
            r1 = false;
            goto L9
        L11:
            if (this.i == false) goto L14;
            if (r4 == false) goto L14;
        L15:
            OMaterialHelper.b(this, r1);
            return;
        L14:
            r1 = false;
            goto L15
        }

        @Override // com.obric.oui.layout.OUILinearLayout, android.view.ViewGroup, android.view.View
        public boolean dispatchTouchEvent(MotionEvent r4) {
            boolean r0 = super.dispatchTouchEvent(r4);
            int r5 = r4.getActionMasked();
            if (r5 != 0) goto L5;
            a(true, getCurrentShadows());
        L14:
            return r0;
        L5:
            if (r5 != 1) goto L7;
        L12:
            a(false, getCurrentShadows());
            goto L14
        L7:
            if (r5 != 3) goto L14;
            if (this.i == false) goto L12;
            f();
            goto L14
        }

        public int getContentWidth() {
            TextView r0 = this.c;
            boolean r1 = true;
            boolean r2 = false;
            if (r0 != null) goto L5;
        L7:
            int r3 = 0;
            int r4 = 0;
        L8:
            ImageView r5 = this.d;
            if (r5 != null) goto L11;
        L19:
            r1 = r2;
        L20:
            View r6 = this.e;
            if (r6 == null) goto L32;
            if (r6.getVisibility() != 0) goto L32;
            if (r1 == false) goto L26;
            r3 = Math.min(r3, this.e.getLeft());
        L27:
            int r7 = this.e.getRight();
            if (r1 == false) goto L30;
            r7 = Math.max(r4, r7);
        L30:
            r4 = r7;
            goto L32
        L26:
            r3 = this.e.getLeft();
        L32:
            return r4 - r3;
        L11:
            if (r5.getVisibility() != 0) goto L19;
            if (r2 == false) goto L14;
            r3 = Math.min(r3, this.d.getLeft());
        L15:
            if (r2 == false) goto L17;
            int r8 = Math.max(r4, this.d.getRight());
        L18:
            r4 = r8;
            goto L20
        L17:
            r8 = this.d.getRight();
            goto L18
        L14:
            r3 = this.d.getLeft();
            goto L15
        L5:
            if (r0.getVisibility() != 0) goto L7;
            int r9 = this.c.getLeft();
            r4 = this.c.getRight();
            r3 = r9;
            r2 = true;
            goto L8
        }

        public g getTab() {
            return this.f14546b;
        }

        public TextView getTextView() {
            return this.c;
        }

        @Override // android.view.View
        public void onInitializeAccessibilityEvent(AccessibilityEvent r1) {
            super.onInitializeAccessibilityEvent(r1);
            r1.setClassName(ActionBar.Tab.class.getName());
        }

        @Override // android.view.View
        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo r1) {
            super.onInitializeAccessibilityNodeInfo(r1);
            r1.setClassName(ActionBar.Tab.class.getName());
        }

        @Override // com.obric.oui.layout.OUILinearLayout, android.widget.LinearLayout, android.view.View
        public void onMeasure(int r11, int r12) {
            int r0 = View.MeasureSpec.getSize(r11);
            int r1 = View.MeasureSpec.getMode(r11);
            int r2 = this.f14545a.getTabMaxWidth();
            LinearLayout.LayoutParams r3 = (LinearLayout.LayoutParams) ZeusTransformUtils.preCheckCast(this.c.getLayoutParams(), LinearLayout.LayoutParams.class, "com.obric.memorydata.plugin");
            if (r2 <= 0) goto L7;
            if (r1 == 0) goto L6;
            if (r0 <= r2) goto L7;
        L6:
            r11 = View.MeasureSpec.makeMeasureSpec(this.f14545a.s, Integer.MIN_VALUE);
        L7:
            super.onMeasure(r11, r12);
            if (this.c == null) goto L37;
            ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin");
            float r4 = this.f14545a.p;
            int r5 = this.h;
            int r6 = OTabLayoutBase.e(this.f14545a);
            int r7 = OTabLayoutBase.f(this.f14545a);
            ImageView r8 = this.d;
            boolean r9 = true;
            if (r8 == null) goto L15;
            if (r8.getVisibility() != 0) goto L15;
            r5 = 1;
        L15:
            if (this.c != null) goto L17;
        L21:
            float r10 = this.c.getTextSize();
            int r13 = this.c.getLineCount();
            int r14 = TextViewCompat.getMaxLines(this.c);
            if (r4 != r10) goto L26;
            if (r14 < 0) goto L38;
            if (r5 != r14) goto L26;
            return;
        L38:
            return;
        L26:
            if (this.f14545a.v != 1) goto L34;
            if (r4 <= r10) goto L34;
            if (r13 != 1) goto L34;
            Layout r15 = this.c.getLayout();
            if (r15 != null) goto L32;
        L33:
            r9 = false;
            goto L34
        L32:
            if (a(r15, 0, r4) > ((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight())) goto L33;
        L34:
            if (r9 == false) goto L40;
            this.c.setTextSize(0, r4);
            this.c.setMaxLines(r5);
            r3.topMargin = r6;
            r3.leftMargin = r7;
            r3.rightMargin = r7;
            this.c.setLayoutParams(r3);
            super.onMeasure(r11, r12);
            return;
        L40:
            return;
        L17:
            if (isSelected() == false) goto L21;
            if (this.f14545a.q <= 0.0f) goto L21;
            r4 = this.f14545a.q;
            r6 = 0;
            r7 = 0;
            goto L21
        }

        @Override // android.view.View
        public boolean performClick() {
            boolean r0 = super.performClick();
            if (this.f14546b == null) goto L12;
            if (r0 == true) goto L7;
            playSoundEffect(0);
        L7:
            if (OTabLayoutBase.c(this.f14545a) == null) goto L9;
            OTabLayoutBase.c(this.f14545a).a(this.f14546b);
        L10:
            com.obric.oui.a.a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), 1);
            return true;
        L9:
            this.f14546b.e();
            goto L10
        L12:
            return r0;
        }

        @Override // com.obric.oui.material.h
        public void setBackdropTarget(View r2) {
            if (this.i == true) goto L5;
            return;
        L5:
            OMaterialHelper.a(this, r2);
        }

        @Override // com.obric.oui.layout.OUILinearLayout, android.view.View
        public void setEnabled(boolean r1) {
            super.setEnabled(r1);
            if (r1 == false) goto L5;
            float r2 = 1.0f;
        L6:
            a(r2);
            return;
        L5:
            r2 = OTabLayoutBase.g(this.f14545a);
            goto L6
        }

        @Override // com.obric.oui.layout.OUILinearLayout, android.view.View
        public void setSelected(boolean r4) {
            if (isSelected() == r4) goto L5;
            boolean r0 = true;
        L6:
            super.setSelected(r4);
            c(r4);
            if (r0 == false) goto L12;
            if (r4 == false) goto L12;
            if (Build.VERSION.SDK_INT >= 16) goto L12;
            sendAccessibilityEvent(4);
        L12:
            if (r4 == true) goto L17;
            if (OTabLayoutBase.b(this.f14545a) == null) goto L17;
            f();
        L17:
            if (this.c == null) goto L29;
            if (r4 == true) goto L20;
        L22:
            TextView r1 = this.c;
            float r2 = this.f14545a.p;
        L23:
            r1.setTextSize(0, r2);
            TextView r3 = this.c;
            OTabLayoutBase r5 = this.f14545a;
            if (r4 == false) goto L26;
            Typeface r6 = OTabLayoutBase.a(r5, OTabLayoutBase.d(r5), 500);
        L27:
            r3.setTypeface(r6);
            return;
        L26:
            r6 = OTabLayoutBase.d(r5);
            goto L27
        L20:
            if (this.f14545a.q <= 0.0f) goto L22;
            r1 = this.c;
            r2 = this.f14545a.q;
            goto L23
        L29:
            return;
        L5:
            r0 = false;
            goto L6
        }

        void setTab(g r2) {
            if (r2 == this.f14546b) goto L6;
            this.f14546b = r2;
            update();
            return;
        }

        final void update() {
            g r0 = this.f14546b;
            if (r0 == null) goto L5;
            View r2 = r0.a();
        L6:
            boolean r3 = true;
            if (r2 == null) goto L29;
            ViewParent r5 = r2.getParent();
            if (r5 == this) goto L13;
            if (r5 == null) goto L12;
            ((ViewGroup) ZeusTransformUtils.preCheckCast(r5, ViewGroup.class, "com.obric.memorydata.plugin")).removeView(r2);
        L12:
            addView(r2);
        L13:
            this.e = r2;
            TextView r6 = this.c;
            if (r6 == null) goto L16;
            r6.setVisibility(8);
        L16:
            ImageView r7 = this.d;
            if (r7 == null) goto L19;
            r7.setVisibility(8);
            this.d.setImageDrawable(null);
        L19:
            TextView r1 = (TextView) ZeusTransformUtils.preCheckCast(r2.findViewById(ZeusTransformUtils.mapRes(R.id.title, OaidModel.KEY_ID, "title")), TextView.class, "com.obric.memorydata.plugin");
            this.f = r1;
            if (r1 == null) goto L26;
            r1.setDuplicateParentStateEnabled(true);
            this.h = TextViewCompat.getMaxLines(this.f);
            if (OTabLayoutBase.d(this.f14545a) != null) goto L26;
            if (this.c == null) goto L26;
            OTabLayoutBase.a(this.f14545a, this.f.getTypeface());
        L26:
            ImageView r4 = (ImageView) ZeusTransformUtils.preCheckCast(r2.findViewById(android.R.id.icon), ImageView.class, "com.obric.memorydata.plugin");
            this.g = r4;
            if (r4 == null) goto L34;
            r4.setDuplicateParentStateEnabled(true);
        L34:
            if (this.e == null) goto L36;
            TextView r8 = this.f;
            if (r8 == null) goto L52;
        L53:
            ImageView r9 = this.g;
        L54:
            a(r8, r9);
        L55:
            if (r0 != null) goto L57;
        L59:
            r3 = false;
        L60:
            setSelected(r3);
            if (isEnabled() == false) goto L63;
            float r10 = 1.0f;
        L64:
            a(r10);
            return;
        L63:
            r10 = OTabLayoutBase.g(this.f14545a);
            goto L64
        L57:
            if (r0.f() == false) goto L59;
        L52:
            if (this.g == null) goto L55;
        L36:
            if (this.d != null) goto L39;
            ImageView r11 = (ImageView) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.inflate(LayoutInflater.from((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")), ZeusTransformUtils.mapRes(R.layout.design_layout_tab_icon, "layout", "design_layout_tab_icon"), this, false, "com.obric.memorydata.plugin"), ImageView.class, "com.obric.memorydata.plugin");
            addView(r11, 0);
            this.d = r11;
            r11.setDuplicateParentStateEnabled(true);
        L39:
            if (this.c != null) goto L45;
            TextView r12 = (TextView) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.inflate(LayoutInflater.from((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")), ZeusTransformUtils.mapRes(R.layout.design_layout_tab_text, "layout", "design_layout_tab_text"), this, false, "com.obric.memorydata.plugin"), TextView.class, "com.obric.memorydata.plugin");
            addView(r12, new LinearLayout.LayoutParams(-1, -2));
            this.c = r12;
            r12.setMaxLines(1);
            this.c.setDuplicateParentStateEnabled(true);
            this.h = TextViewCompat.getMaxLines(this.c);
            if (OTabLayoutBase.d(this.f14545a) != null) goto L45;
            TextView r13 = this.c;
            if (r13 == null) goto L45;
            OTabLayoutBase.a(this.f14545a, r13.getTypeface());
        L45:
            this.c.setAllCaps(false);
            if (this.f14545a.n == null) goto L48;
            this.c.setTextColor(this.f14545a.n);
        L48:
            r8 = this.c;
            r9 = this.d;
            goto L54
        L29:
            View r14 = this.e;
            if (r14 == null) goto L32;
            removeView(r14);
            this.e = null;
        L32:
            this.f = null;
            this.g = null;
            goto L34
        L5:
            r2 = null;
            goto L6
        }
    }

    public static class i implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ViewPager f14547a;

        public i(ViewPager r1) {
            this.f14547a = r1;
        }

        @Override // com.obric.oui.tab.OTabLayoutBase.c
        public void a(g r1) {
            this.f14547a.setCurrentItem(r1.c());
        }

        @Override // com.obric.oui.tab.OTabLayoutBase.c
        public void b(g r1) {
        }

        @Override // com.obric.oui.tab.OTabLayoutBase.c
        public void c(g r1) {
        }
    }

    static {
        f14526b = new FastOutSlowInInterpolator();
        A = new Pools.SynchronizedPool(16);
        aN = new int[]{ZeusTransformUtils.mapRes(R.attr.colorPrimary, "attr", "colorPrimary")};
    }

    public OTabLayoutBase(Context r3) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), null);
    }

    public OTabLayoutBase(Context r3, AttributeSet r4) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin"), 0);
    }

    public OTabLayoutBase(Context r21, AttributeSet r22, int r23) {
        Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r21, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r22, AttributeSet.class, "com.obric.memorydata.plugin");
        super(r2, r4, r23);
        this.B = new ArrayList();
        this.d = false;
        this.e = null;
        this.F = 0.3f;
        this.H = 0;
        this.I = 0;
        this.l = 0;
        this.o = 0;
        this.s = Integer.MAX_VALUE;
        this.t = Integer.MAX_VALUE;
        this.O = new ArrayList();
        this.aa = false;
        this.ac = 0;
        this.ad = null;
        this.ae = 0.0f;
        this.af = 0.0f;
        this.ag = 0.0f;
        Paint r7 = new Paint(1);
        this.ah = r7;
        this.ai = new Paint(1);
        Paint r9 = new Paint(1);
        this.aj = r9;
        this.ak = new RectF();
        this.al = new RectF();
        this.am = new RectF();
        this.an = new RectF();
        this.ap = true;
        this.aq = false;
        this.at = false;
        this.au = null;
        this.av = null;
        this.aw = null;
        this.ax = null;
        this.ay = null;
        this.az = true;
        this.aA = new Rect();
        this.aB = new Rect();
        this.aC = new Paint();
        com.obric.oui.tab.a r10 = new com.obric.oui.tab.a();
        this.aD = r10;
        this.aF = new PathInterpolator(0.34f, 0.69f, 0.1f, 1.0f);
        this.aG = new float[8];
        a r11 = new a(this);
        this.aH = r11;
        a r12 = new a(this);
        this.aI = r12;
        this.aJ = -1;
        this.aK = false;
        this.aM = new Pools.SimplePool(12);
        this.aP = null;
        this.aQ = null;
        this.aK = com.obric.oui.c.h.a(ZeusTransformUtils.getResources(r2, "com.obric.memorydata.plugin").getConfiguration().fontScale);
        if (OMaterialHelper.a(r2) == true) goto L5;
    L7:
        boolean r6 = false;
    L8:
        this.d = r6;
        this.c = r6;
        setHorizontalScrollBarEnabled(false);
        f r8 = new f(this, r2);
        this.E = r8;
        r8.setDuplicateParentStateEnabled(true);
        setClipChildren(false);
        setClipToPadding(false);
        super.addView(r8, 0, new FrameLayout.LayoutParams(-2, -1));
        TypedArray r13 = r2.obtainStyledAttributes(r4, R.styleable.TabLayout, r23, ZeusTransformUtils.mapRes(R.style.OTabText, "style", "OTabText"));
        r8.b(r13.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.TabLayout_tabIndicatorHeight, "styleable", "TabLayout_tabIndicatorHeight"), 0));
        r8.a(r13.getColor(ZeusTransformUtils.mapRes(R.styleable.TabLayout_tabIndicatorColor, "styleable", "TabLayout_tabIndicatorColor"), ContextCompat.getColor((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.color.oui_accent_7, TypedValues.Custom.S_COLOR, "oui_accent_7"))));
        this.g = r13.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.TabLayout_tabMinWidth, "styleable", "TabLayout_tabMinWidth"), d(56));
        int r5 = r13.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.TabLayout_tabPadding, "styleable", "TabLayout_tabPadding"), 0);
        this.h = r5;
        this.i = r5;
        this.j = r5;
        this.k = r5;
        this.h = r13.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.TabLayout_tabPaddingStart, "styleable", "TabLayout_tabPaddingStart"), this.h);
        this.i = r13.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.TabLayout_tabPaddingTop, "styleable", "TabLayout_tabPaddingTop"), this.i);
        this.j = r13.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.TabLayout_tabPaddingEnd, "styleable", "TabLayout_tabPaddingEnd"), this.j);
        this.k = r13.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.TabLayout_tabPaddingBottom, "styleable", "TabLayout_tabPaddingBottom"), this.k);
        int r14 = r13.getResourceId(ZeusTransformUtils.mapRes(R.styleable.TabLayout_tabTextAppearance, "styleable", "TabLayout_tabTextAppearance"), ZeusTransformUtils.mapRes(R.style.TextAppearance_Design_Tab, "style", "TextAppearance_Design_Tab"));
        this.m = r14;
        int r15 = this.h;
        if (r15 > 0) goto L11;
    L13:
        int r16 = this.j;
        if (r16 > 0) goto L16;
    L18:
        TypedArray r17 = r2.obtainStyledAttributes(r14, R.styleable.TextAppearance);
        this.p = r17.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.TextAppearance_android_textSize, "styleable", "TextAppearance_android_textSize"), 0);     // Catch: Throwable -> L110
        this.n = r17.getColorStateList(ZeusTransformUtils.mapRes(R.styleable.TextAppearance_android_textColor, "styleable", "TextAppearance_android_textColor"));     // Catch: Throwable -> L110
        r17.recycle();
        if (r13.hasValue(ZeusTransformUtils.mapRes(R.styleable.TabLayout_tabTextColor, "styleable", "TabLayout_tabTextColor")) == false) goto L23;
        this.n = r13.getColorStateList(ZeusTransformUtils.mapRes(R.styleable.TabLayout_tabTextColor, "styleable", "TabLayout_tabTextColor"));
    L23:
        boolean r18 = r13.hasValue(ZeusTransformUtils.mapRes(R.styleable.TabLayout_tabSelectedTextColor, "styleable", "TabLayout_tabSelectedTextColor"));
        if (r18 == false) goto L26;
        int r19 = r13.getColor(ZeusTransformUtils.mapRes(R.styleable.TabLayout_tabSelectedTextColor, "styleable", "TabLayout_tabSelectedTextColor"), 0);
    L27:
        this.f14527J = r13.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.TabLayout_tabMinWidth, "styleable", "TabLayout_tabMinWidth"), -1);
        int r20 = r13.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.TabLayout_tabMaxWidth, "styleable", "TabLayout_tabMaxWidth"), -1);
        this.K = r20;
        if (r20 <= 0) goto L30;
        this.t = r20;
    L30:
        this.r = r13.getResourceId(ZeusTransformUtils.mapRes(R.styleable.TabLayout_tabBackground, "styleable", "TabLayout_tabBackground"), 0);
        this.M = r13.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.TabLayout_tabContentStart, "styleable", "TabLayout_tabContentStart"), 0);
        this.v = r13.getInt(ZeusTransformUtils.mapRes(R.styleable.TabLayout_tabMode, "styleable", "TabLayout_tabMode"), 1);
        this.u = r13.getInt(ZeusTransformUtils.mapRes(R.styleable.TabLayout_tabGravity, "styleable", "TabLayout_tabGravity"), 1);
        TypedArray r1 = r2.obtainStyledAttributes(r4, new int[]{android.R.attr.minHeight}, r23, 0);
        int r24 = r1.getDimensionPixelSize(0, 0);
        if (r24 <= 0) goto L33;
        setMinimumHeight(r24);
    L33:
        r1.recycle();
        TypedArray r3 = r2.obtainStyledAttributes(r4, R.styleable.OTabLayoutSupple);
        r8.d(r3.getBoolean(ZeusTransformUtils.mapRes(R.styleable.OTabLayoutSupple_oui_tabIndicatorFullWidth, "styleable", "OTabLayoutSupple_oui_tabIndicatorFullWidth"), true));     // Catch: Throwable -> L107
        r8.a(r3.getBoolean(ZeusTransformUtils.mapRes(R.styleable.OTabLayoutSupple_oui_showBottomLine, "styleable", "OTabLayoutSupple_oui_showBottomLine"), false));     // Catch: Throwable -> L107
        r8.b(r3.getBoolean(ZeusTransformUtils.mapRes(R.styleable.OTabLayoutSupple_oui_showTopLine, "styleable", "OTabLayoutSupple_oui_showTopLine"), false));     // Catch: Throwable -> L107
        r8.c(r3.getBoolean(ZeusTransformUtils.mapRes(R.styleable.OTabLayoutSupple_oui_showSelectedIndicator, "styleable", "OTabLayoutSupple_oui_showSelectedIndicator"), true));     // Catch: Throwable -> L107
        this.q = r3.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.OTabLayoutSupple_oui_tabSelectedTextSize, "styleable", "OTabLayoutSupple_oui_tabSelectedTextSize"), 0);     // Catch: Throwable -> L107
        this.p = r3.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.OTabLayoutSupple_oui_tabTextSize, "styleable", "OTabLayoutSupple_oui_tabTextSize"), (int) this.p);     // Catch: Throwable -> L107
        this.f = r3.getResourceId(ZeusTransformUtils.mapRes(R.styleable.OTabLayoutSupple_oui_widgetShadow, "styleable", "OTabLayoutSupple_oui_widgetShadow"), ZeusTransformUtils.mapRes(R.style.OUIShadow_Oui_Shadow_Regular, "style", "OUIShadow_Oui_Shadow_Regular"));     // Catch: Throwable -> L107
        if (this.c == false) goto L37;
        this.c = r3.getBoolean(ZeusTransformUtils.mapRes(R.styleable.OTabLayoutSupple_oui_widgetEnableMaterial, "styleable", "OTabLayoutSupple_oui_widgetEnableMaterial"), true);     // Catch: Throwable -> L107
    L37:
        int r25 = r3.getInt(ZeusTransformUtils.mapRes(R.styleable.OTabLayoutSupple_oui_tab_spec, "styleable", "OTabLayoutSupple_oui_tab_spec"), -1);     // Catch: Throwable -> L107
        if (r25 != 0) goto L40;
    L45:
        int r26 = d(4);     // Catch: Throwable -> L107
        a(r26, r26, r26, r26);     // Catch: Throwable -> L107
        this.l = d(4);     // Catch: Throwable -> L107
    L46:
        String r27 = r3.getString(ZeusTransformUtils.mapRes(R.styleable.OTabLayoutSupple_oui_widgetMaterial, "styleable", "OTabLayoutSupple_oui_widgetMaterial"));     // Catch: Throwable -> L107
        if (r27 != null) goto L50;
        r27 = r2.getString(ZeusTransformUtils.mapRes(R.string.oui_material_bg_floating, TypedValues.Custom.S_STRING, "oui_material_bg_floating"));     // Catch: Throwable -> L107
    L50:
        r3.recycle();
        String r110 = r27;
        this.L = ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getDimensionPixelSize(ZeusTransformUtils.mapRes(R.dimen.design_tab_scrollable_min_width, "dimen", "design_tab_scrollable_min_width"));
        this.V = com.obric.oui.common.util.h.a(1.5f, r2);
        this.W = com.obric.oui.common.util.h.a(1.5f, r2);
        this.aO = ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getConfiguration().orientation;
        r13.recycle();
        TypedArray r28 = r2.obtainStyledAttributes(r4, R.styleable.OTabLayout);
        Drawable r29 = r28.getDrawable(ZeusTransformUtils.mapRes(R.styleable.OTabLayout_tab_divider, "styleable", "OTabLayout_tab_divider"));     // Catch: Throwable -> L104
        if (r29 == null) goto L54;
        r8.setDividerDrawable(r29);     // Catch: Throwable -> L104
        r8.setShowDividers(2);     // Catch: Throwable -> L104
    L54:
        this.ab = r28.getColor(ZeusTransformUtils.mapRes(R.styleable.OTabLayout_indicator_color, "styleable", "OTabLayout_indicator_color"), 0);     // Catch: Throwable -> L104
        this.ac = r28.getColor(ZeusTransformUtils.mapRes(R.styleable.OTabLayout_indicator_unselected_color, "styleable", "OTabLayout_indicator_unselected_color"), 0);     // Catch: Throwable -> L104
        this.ad = r28.getDrawable(ZeusTransformUtils.mapRes(R.styleable.OTabLayout_indicator_background, "styleable", "OTabLayout_indicator_background"));     // Catch: Throwable -> L104
        this.ae = r28.getDimension(ZeusTransformUtils.mapRes(R.styleable.OTabLayout_indicator_height, "styleable", "OTabLayout_indicator_height"), -1.0f);     // Catch: Throwable -> L104
        this.ag = r28.getDimension(ZeusTransformUtils.mapRes(R.styleable.OTabLayout_indicator_corner_radius, "styleable", "OTabLayout_indicator_corner_radius"), -1.0f);     // Catch: Throwable -> L104
        if (ZeusTransformUtils.instanceOf(this.ad, GradientDrawable.class) == false) goto L57;
        ((GradientDrawable) ZeusTransformUtils.preCheckCast(this.ad, GradientDrawable.class, "com.obric.memorydata.plugin")).setCornerRadius(this.ag);     // Catch: Throwable -> L104
    L57:
        this.af = r28.getDimension(ZeusTransformUtils.mapRes(R.styleable.OTabLayout_indicator_spacing, "styleable", "OTabLayout_indicator_spacing"), d(4));     // Catch: Throwable -> L104
        int r30 = r28.getColor(ZeusTransformUtils.mapRes(R.styleable.OTabLayout_bar_color, "styleable", "OTabLayout_bar_color"), 0);     // Catch: Throwable -> L104
        this.ao = r30;     // Catch: Throwable -> L104
        if (r30 != 0) goto L60;
        a(0, 0, 0, 0);     // Catch: Throwable -> L104
    L60:
        this.ap = r28.getBoolean(ZeusTransformUtils.mapRes(R.styleable.OTabLayout_indicator_anim_enable, "styleable", "OTabLayout_indicator_anim_enable"), false);     // Catch: Throwable -> L104
        this.aq = r28.getBoolean(ZeusTransformUtils.mapRes(R.styleable.OTabLayout_indicator_bounce_enable, "styleable", "OTabLayout_indicator_bounce_enable"), true);     // Catch: Throwable -> L104
        r10.a(r28.getBoolean(ZeusTransformUtils.mapRes(R.styleable.OTabLayout_tab_edgeFadeEnabled, "styleable", "OTabLayout_tab_edgeFadeEnabled"), false));     // Catch: Throwable -> L104
        r10.a(r28.getDimension(ZeusTransformUtils.mapRes(R.styleable.OTabLayout_tab_edgeFadeLength, "styleable", "OTabLayout_tab_edgeFadeLength"), a(20.0f)));     // Catch: Throwable -> L104
        this.F = b(r28.getFloat(ZeusTransformUtils.mapRes(R.styleable.OTabLayout_oui_alpha_disabled, "styleable", "OTabLayout_oui_alpha_disabled"), this.F));     // Catch: Throwable -> L104
        this.ar = r28.getResourceId(ZeusTransformUtils.mapRes(R.styleable.OTabLayout_tab_textSelectedStyle, "styleable", "OTabLayout_tab_textSelectedStyle"), 0);     // Catch: Throwable -> L104
        this.as = r28.getResourceId(ZeusTransformUtils.mapRes(R.styleable.OTabLayout_tab_textStyle, "styleable", "OTabLayout_tab_textStyle"), 0);     // Catch: Throwable -> L104
        this.o = r28.getColor(ZeusTransformUtils.mapRes(R.styleable.OTabLayout_tab_textPressedColor, "styleable", "OTabLayout_tab_textPressedColor"), 0);     // Catch: Throwable -> L104
        if (this.d == false) goto L64;
        this.at = r28.getBoolean(ZeusTransformUtils.mapRes(R.styleable.OTabLayout_tab_enableMaterial, "styleable", "OTabLayout_tab_enableMaterial"), false);     // Catch: Throwable -> L104
    L64:
        if (this.at == false) goto L79;
        this.au = r28.getString(ZeusTransformUtils.mapRes(R.styleable.OTabLayout_tab_material, "styleable", "OTabLayout_tab_material"));     // Catch: Throwable -> L104
        this.aw = r28.getString(ZeusTransformUtils.mapRes(R.styleable.OTabLayout_tab_material_selected, "styleable", "OTabLayout_tab_material_selected"));     // Catch: Throwable -> L104
        if (TextUtils.isEmpty(this.au) == false) goto L68;
        this.au = r2.getString(ZeusTransformUtils.mapRes(R.string.oui_material_bg_floating, TypedValues.Custom.S_STRING, "oui_material_bg_floating"));     // Catch: Throwable -> L104
    L68:
        String r31 = this.au;     // Catch: Throwable -> L104
        if (a() == true) goto L71;
        boolean r32 = true;
    L72:
        this.av = MaterialToken.parseSet(r31, r32);     // Catch: Throwable -> L104
        if (TextUtils.isEmpty(this.aw) == true) goto L79;
        String r33 = this.aw;     // Catch: Throwable -> L104
        if (a() == true) goto L77;
        boolean r34 = true;
    L78:
        this.ax = MaterialToken.parseSet(r33, r34);     // Catch: Throwable -> L104
        goto L79
    L77:
        r34 = false;
        goto L78
    L71:
        r32 = false;
    L79:
        int r35 = r28.getResourceId(ZeusTransformUtils.mapRes(R.styleable.OTabLayout_shadow_pressed, "styleable", "OTabLayout_shadow_pressed"), 0);     // Catch: Throwable -> L104
        if (r35 == 0) goto L82;
        List<k> r36 = com.obric.oui.common.style.f.a(r2, r35);     // Catch: Throwable -> L104
        ArrayList r37 = new ArrayList(2);     // Catch: Throwable -> L104
        this.ay = r37;     // Catch: Throwable -> L104
        r37.add((k) ZeusTransformUtils.preCheckCast(r36.get(0), k.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L104
        this.ay.add((k) ZeusTransformUtils.preCheckCast(r36.get(1), k.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L104
    L82:
        r28.recycle();
        if (r18 == true) goto L85;
    L89:
        ValueAnimator r38 = ValueAnimator.ofObject(new e(this), new Object[]{r12, r11});
        this.aE = r38;
        r38.addUpdateListener(this);
        r7.setStyle(Paint.Style.FILL);
        r9.setStyle(Paint.Style.STROKE);
        r9.setColor(0);
        float r39 = this.ag + (this.af / 2.0f);
        if (this.c == false) goto L102;
        this.e = new WeakReference(this);
        com.obric.oui.material.c[] r40 = MaterialToken.parseSet(r110, !a());
        if (r40 == null) goto L102;
        OMaterialHelper.a(this, 2, r40, ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getDisplayMetrics().density);
        GradientDrawable r41 = new GradientDrawable();
        r41.setShape(0);
        r41.setCornerRadius(r39);
        r41.setColor(0);
        setBackground(r41);
        setOutlineProvider(ViewOutlineProvider.BACKGROUND);
        if (ZeusTransformUtils.instanceOf(this.ad, GradientDrawable.class) == false) goto L96;
        char r42 = 0;
        ((GradientDrawable) ZeusTransformUtils.preCheckCast(this.ad, GradientDrawable.class, "com.obric.memorydata.plugin")).setColor(0);
    L98:
        if (OMaterialHelper.b(r2) != 1) goto L102;
        com.obric.oui.material.c r43 = r40[r42];
        if (r43.e() == null) goto L102;
        r9.setColor(r43.e().b());
        r9.setStrokeWidth(d((int) r43.e().a()));
        goto L102
    L96:
        r42 = 0;
    L102:
        h();
        o();
        return;
    L85:
        if (this.o == 0) goto L87;
        ColorStateList r44 = a(this.n.getDefaultColor(), r19, this.o);
    L88:
        this.n = r44;
        goto L89
    L87:
        r44 = b(this.n.getDefaultColor(), r19);
    L104:
        th = move-exception;
        r28.recycle();
        throw th;
    L40:
        if (r25 == 1) goto L45;
        if (r25 == 2) goto L44;
        a(d(16), d(4), d(16), d(12));     // Catch: Throwable -> L107
        goto L46
    L44:
        a(d(12), d(6), d(12), d(6));     // Catch: Throwable -> L107
    L107:
        th = move-exception;
        r3.recycle();
        throw th;
    L26:
        r19 = 0;
    L110:
        th = move-exception;
        r17.recycle();
        throw th;
    L16:
        if (this.aK == false) goto L18;
        this.j = (r16 * 2) / 3;
        goto L18
    L11:
        if (this.aK == false) goto L13;
        this.h = (r15 * 2) / 3;
        goto L13
    L5:
        if (OMaterialHelper.d() == false) goto L7;
        r6 = true;
        goto L8
    }

    static /* synthetic */ float a(OTabLayoutBase r0) {
        return r0.ag;
    }

    private int a(int r4, float r5) {
        int r1 = 0;
        if (this.v != 0) goto L21;
        View r0 = this.E.getChildAt(r4);
        int r6 = r4 + 1;
        if (r6 >= this.E.getChildCount()) goto L7;
        View r7 = this.E.getChildAt(r6);
    L8:
        if (r0 == null) goto L10;
        int r2 = r0.getWidth();
    L11:
        if (r7 == null) goto L13;
        int r8 = r7.getWidth();
    L14:
        if (r0 == null) goto L16;
        r1 = r0.getLeft();
    L16:
        int r3 = (r1 + (r2 / 2)) - (getWidth() / 2);
        int r9 = (int) ((((r2 + r8) + (this.G * 4)) * 0.5f) * r5);
        if (ViewCompat.getLayoutDirection(this) != 0) goto L20;
        return r3 + r9;
    L20:
        return r3 - r9;
    L13:
        r8 = 0;
        goto L14
    L10:
        r2 = 0;
        goto L11
    L7:
        r7 = null;
        goto L8
    L21:
        return 0;
    }

    static /* synthetic */ int a(OTabLayoutBase r0, int r1) {
        r0.aJ = r1;
        return r1;
    }

    private static ColorStateList a(int r7, int r8, int r9) {
        return new ColorStateList(new int[][]{new int[]{android.R.attr.state_pressed, android.R.attr.state_selected}, new int[]{android.R.attr.state_pressed}, SELECTED_STATE_SET, EMPTY_STATE_SET}, new int[]{ColorUtils.compositeColors(r9, r8), ColorUtils.compositeColors(r9, r7), r8, r7});
    }

    private Typeface a(Typeface r3, int r4) {
        if (this.aQ != null) goto L8;
        if (Build.VERSION.SDK_INT < 28) goto L8;
        this.aQ = Typeface.create(r3, r4, false);
    L8:
        return this.aQ;
    }

    static /* synthetic */ Typeface a(OTabLayoutBase r0, Typeface r1) {
        r0.aP = r1;
        return r1;
    }

    static /* synthetic */ Typeface a(OTabLayoutBase r0, Typeface r1, int r2) {
        return r0.a(r1, r2);
    }

    private void a(Canvas r2) {
        if (isInEditMode() == false) goto L5;
    L7:
        super.dispatchDraw(r2);
        return;
    L5:
        if (getTabCount() <= 0) goto L7;
        a(r2, getBounceTranslation());
        goto L7
    }

    private void a(Canvas r13, float r14) {
        int r0 = getHeight();
        int r1 = getPaddingLeft();
        int r2 = getPaddingTop();
        int r3 = getPaddingBottom();
        if (this.ae >= 0.0f) goto L5;
        this.ae = r0 - (this.af * 2.0f);
    L5:
        float r4 = this.ag;
        if (r4 >= 0.0f) goto L8;
    L9:
        this.ag = this.ae;
    L10:
        float r5 = this.ag + (this.af / 2.0f);
        float r6 = getWidth() + r14;
        if (this.c == true) goto L16;
        int r7 = this.ao;
        if (r7 == 0) goto L16;
        this.ah.setColor(r7);
        this.ak.set(r14, r2, r6, r0 - r3);
        r13.drawRoundRect(this.ak, r5, r5, this.ah);
    L16:
        if (this.aj.getColor() == 0) goto L18;
        this.ak.set(r14, r2, r6, r0 - r3);
        r13.drawRoundRect(this.ak, r5, r5, this.aj);
    L18:
        int r8 = 0;
        if (this.ap == true) goto L21;
    L23:
        l();
    L25:
        if (this.at == true) goto L39;
        int r9 = this.ab;
        if (r9 == 0) goto L30;
        this.aC.setColor(r9);
        float r10 = (this.aA.left + r1) + r14;
        float r11 = this.af;
        float r12 = (this.aA.right + r1) + r14;
        float r15 = this.af + this.ae;
        float r16 = this.ag;
        r13.drawRoundRect(r10, r11, r12, r15, r16, r16, this.aC);
    L30:
        if (this.ac != 0) goto L32;
        return;
    L32:
        if (this.ao == 0) goto L34;
        return;
    L34:
        if (r8 >= getTabCount()) goto L45;
        if (r8 == getSelectedTabPosition()) goto L38;
        View r17 = f(r8);
        this.aC.setColor(this.ac);
        float r18 = (r17.getLeft() + r1) + r14;
        float r19 = this.af;
        float r20 = (r17.getRight() + r1) + r14;
        float r21 = this.af + this.ae;
        float r110 = this.ag;
        r13.drawRoundRect(r18, r19, r20, r21, r110, r110, this.aC);
    L38:
        r8 = r8 + 1;
        goto L34
    L45:
        return;
    L39:
        return;
    L21:
        if (this.az == false) goto L25;
        this.az = false;
        goto L23
    L8:
        if (r4 <= (this.ae / 2.0f)) goto L10;
        goto L9
    }

    private void a(View r5) {
        if (ZeusTransformUtils.instanceOf(r5, OTabItem.class) == false) goto L6;
        a((OTabItem) ZeusTransformUtils.preCheckCast(r5, OTabItem.class, "com.obric.memorydata.plugin"));
        return;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, f.class) == false) goto L11;
        if (indexOfChild(r5) != (-1)) goto L15;
        super.addView(r5, 0, new FrameLayout.LayoutParams(-2, -1));
        return;
    L15:
        return;
    L11:
        if (ZeusTransformUtils.instanceOf(r5, OBottomTabItem.class) == false) goto L17;
        a((OBottomTabItem) ZeusTransformUtils.preCheckCast(r5, OBottomTabItem.class, "com.obric.memorydata.plugin"));
        return;
    }

    private void a(LinearLayout.LayoutParams r3) {
        if (this.v == 1) goto L5;
    L7:
        r3.width = -2;
        float r0 = 0.0f;
    L8:
        r3.weight = r0;
        int r1 = this.G;
        if (r1 == 0) goto L12;
        r3.leftMargin = r1;
        r3.rightMargin = this.G;
        return;
    L12:
        return;
    L5:
        if (this.u != 0) goto L7;
        r3.width = 0;
        r0 = 1.0f;
        goto L8
    }

    private void a(ViewPager r3, boolean r4, boolean r5) {
        ViewPager r0 = this.y;
        if (r0 == null) goto L10;
        TabLayoutOnPageChangeListener r1 = this.z;
        if (r1 == null) goto L7;
        r0.removeOnPageChangeListener(r1);
    L7:
        AdapterChangeListener r2 = this.T;
        if (r2 == null) goto L10;
        this.y.removeOnAdapterChangeListener(r2);
    L10:
        c r6 = this.P;
        if (r6 == null) goto L13;
        b(r6);
        this.P = null;
    L13:
        if (r3 == null) goto L24;
        this.y = r3;
        if (this.z != null) goto L17;
        this.z = new TabLayoutOnPageChangeListener(this);
    L17:
        this.z.reset();
        r3.addOnPageChangeListener(this.z);
        i r7 = new i(r3);
        this.P = r7;
        a(r7);
        PagerAdapter r8 = r3.getAdapter();
        if (r8 == null) goto L21;
        a(r8, r4);
    L21:
        if (this.T != null) goto L23;
        this.T = new AdapterChangeListener(this);
    L23:
        this.T.setAutoRefresh(r4);
        r3.addOnAdapterChangeListener(this.T);
        a(r3.getCurrentItem(), 0.0f, true);
    L25:
        this.U = r5;
        return;
    L24:
        this.y = null;
        a(null, false);
        goto L25
    }

    private void a(OBottomTabItem r6) {
        OBottomTabItemCustomView r0 = new OBottomTabItemCustomView((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
        g r1 = a(0);
        if (r6.getText() == null) goto L6;
        r0.getTitle().setText(r6.getText());
        r1.a(r6.getText());
    L6:
        if (r6.getIcon() == null) goto L8;
        r0.getIcon().setImageDrawable(r6.getIcon());
    L8:
        r0.setTextColor(this.n);
        r0.setSelectedBgColor(Integer.valueOf(ContextCompat.getColor((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.color.oui_accent_bg_light, TypedValues.Custom.S_COLOR, "oui_accent_bg_light"))));
        r1.a(r0);
        a(r1);
    }

    private void a(OTabItem r3) {
        g r0 = a(0);
        if (r3.f14524a == null) goto L6;
        r0.a(r3.f14524a);
    L6:
        if (r3.f14525b == null) goto L9;
        r0.a(r3.f14525b);
    L9:
        if (r3.c == 0) goto L12;
        r0.a(r3.c);
    L12:
        if (TextUtils.isEmpty(r3.getContentDescription()) == true) goto L14;
        r0.b(r3.getContentDescription());
    L14:
        a(r0);
    }

    private void a(g r4, int r5) {
        r4.b(r5);
        this.B.add(r5, r4);
        int r6 = this.B.size();
    L3:
        r5 = r5 + 1;
        if (r5 >= r6) goto L6;
        ((g) ZeusTransformUtils.preCheckCast(this.B.get(r5), g.class, "com.obric.memorydata.plugin")).b(r5);
        goto L3
    }

    private boolean a() {
        int r0 = this.n.getDefaultColor();
        if (r0 != 0) goto L7;
        return b();
    L7:
        return !com.obric.oui.color.d.a(r0);
    }

    private float b(float r1) {
        return Math.max(0.0f, Math.min(1.0f, r1));
    }

    private static ColorStateList b(int r4, int r5) {
        return new ColorStateList(new int[][]{SELECTED_STATE_SET, EMPTY_STATE_SET}, new int[]{r5, r4});
    }

    static /* synthetic */ List b(OTabLayoutBase r0) {
        return r0.ay;
    }

    private boolean b() {
        if ((ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getConfiguration().uiMode & 48) != 32) goto L5;
        return true;
    L5:
        return false;
    }

    static /* synthetic */ b c(OTabLayoutBase r0) {
        return r0.aL;
    }

    private void c(g r3) {
        h r0 = r3.f14544b;
        this.E.addView(r0, r3.c(), k());
    }

    static /* synthetic */ Typeface d(OTabLayoutBase r0) {
        return r0.aP;
    }

    private void d(g r5) {
        int r0 = this.O.size() - 1;
    L3:
        if (r0 < 0) goto L5;
        ((c) ZeusTransformUtils.preCheckCast(this.O.get(r0), c.class, "com.obric.memorydata.plugin")).a(r5);
        r0 = r0 - 1;
        goto L3
    }

    static /* synthetic */ int e(OTabLayoutBase r0) {
        return r0.I;
    }

    private void e(g r5) {
        int r0 = this.O.size() - 1;
    L3:
        if (r0 < 0) goto L5;
        ((c) ZeusTransformUtils.preCheckCast(this.O.get(r0), c.class, "com.obric.memorydata.plugin")).b(r5);
        r0 = r0 - 1;
        goto L3
    }

    static /* synthetic */ int f(OTabLayoutBase r0) {
        return r0.H;
    }

    static /* synthetic */ Interpolator f() {
        return f14526b;
    }

    private void f(g r5) {
        int r0 = this.O.size() - 1;
    L3:
        if (r0 < 0) goto L5;
        ((c) ZeusTransformUtils.preCheckCast(this.O.get(r0), c.class, "com.obric.memorydata.plugin")).c(r5);
        r0 = r0 - 1;
        goto L3
    }

    static /* synthetic */ float g(OTabLayoutBase r0) {
        return r0.F;
    }

    private void g(int r4) {
        h r0 = (h) ZeusTransformUtils.preCheckCast(this.E.getChildAt(r4), h.class, "com.obric.memorydata.plugin");
        this.E.removeViewAt(r4);
        if (r0 == null) goto L5;
        r0.a();
        this.aM.release(r0);
    L5:
        requestLayout();
    }

    static /* synthetic */ int[] g() {
        return SELECTED_STATE_SET;
    }

    private int getDefaultHeight() {
        int r0 = this.B.size();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L21;
        g r3 = (g) ZeusTransformUtils.preCheckCast(this.B.get(r2), g.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L13;
        if (r3.b() == null) goto L11;
        if (TextUtils.isEmpty(r3.d()) == true) goto L11;
    L14:
        return 56;
    L11:
        if (r3.a() != null) goto L14;
    L13:
        r2 = r2 + 1;
        goto L3
    L21:
        return 56;
    }

    private float getScrollPosition() {
        return this.E.b();
    }

    private int getTabMinWidth() {
        int r0 = this.f14527J;
        if (r0 == (-1)) goto L6;
        return r0;
    L6:
        if (this.v == 0) goto L10;
        return 0;
    L10:
        return this.L;
    }

    private int getTabScrollRange() {
        return Math.max(0, ((this.E.getWidth() - getWidth()) - getPaddingLeft()) - getPaddingRight());
    }

    static /* synthetic */ f h(OTabLayoutBase r0) {
        return r0.E;
    }

    private void h() {
        if (this.ap == false) goto L5;
        this.E.setShadowStyle(this.f);
        this.E.setShadowCornerRadius((int) this.ag);
        return;
    L5:
        this.E.setShadowStyle(ZeusTransformUtils.mapRes(R.style.OUIShadow_None, "style", "OUIShadow_None"));
    }

    private void h(int r7) {
        if (r7 != (-1)) goto L6;
        return;
    L6:
        if (getWindowToken() != null) goto L8;
    L17:
        a(r7, 0.0f, true);
        return;
    L8:
        if (ViewCompat.isLaidOut(this) == false) goto L17;
        if (this.E.a() == true) goto L17;
        int r0 = getScrollX();
        int r2 = a(r7, 0.0f);
        if (r0 == r2) goto L15;
        m();
        this.Q.setIntValues(new int[]{r0, r2});
        this.Q.start();
    L15:
        this.E.b(r7, 200);
    }

    static /* synthetic */ int i(OTabLayoutBase r0) {
        return r0.aO;
    }

    private void i() {
        int r0 = this.B.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        ((g) ZeusTransformUtils.preCheckCast(this.B.get(r1), g.class, "com.obric.memorydata.plugin")).i();
        r1 = r1 + 1;
        goto L3
    }

    private h j() {
        Pools.Pool<h> r0 = this.aM;
        if (r0 == null) goto L5;
        h r1 = (h) ZeusTransformUtils.preCheckCast(r0.acquire(), h.class, "com.obric.memorydata.plugin");
    L6:
        if (r1 != null) goto L17;
        r1 = new h(this, (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), this.at, this.av, this.ax);
        WeakReference<View> r2 = this.e;
        if (r2 != null) goto L10;
    L12:
        Drawable r3 = this.ad;
        if (r3 == null) goto L19;
        if (this.at == true) goto L19;
        r1.setBackground(r3.mutate());
        r1.setOutlineProvider(ViewOutlineProvider.BACKGROUND);
    L19:
        if (isEnabled() == false) goto L21;
        float r8 = 1.0f;
    L22:
        h.a(r1, r8);
        r1.setFocusable(true);
        return r1;
    L21:
        r8 = this.F;
        goto L22
    L10:
        if (r2.get() == null) goto L12;
        r1.setBackdropTarget((View) ZeusTransformUtils.preCheckCast(this.e.get(), View.class, "com.obric.memorydata.plugin"));
        goto L12
    L17:
        r1.a(this.at);
        r1.a(this.av, this.ax);
        goto L19
    L5:
        r1 = null;
        goto L6
    }

    static /* synthetic */ boolean j(OTabLayoutBase r0) {
        return r0.aa;
    }

    private LinearLayout.LayoutParams k() {
        LinearLayout.LayoutParams r0 = new LinearLayout.LayoutParams(-2, -1);
        a(r0);
        return r0;
    }

    private void l() {
        View r0 = f(getSelectedTabPosition());
        if (r0 == null) goto L6;
        Rect r1 = this.aA;
        r1.left = r0.getLeft();
        Rect r3 = this.aA;
        r3.right = r0.getRight();
        return;
    }

    private void m() {
        if (this.Q != null) goto L6;
        ValueAnimator r0 = new ValueAnimator();
        this.Q = r0;
        r0.setInterpolator(f14526b);
        this.Q.setDuration(200);
        this.Q.addUpdateListener(new AnonymousClass2(this));
        return;
    }

    private void n() {
        View r0 = f(getSelectedTabPosition());
        if (r0 != null) goto L5;
        return;
    L5:
        this.aH.f14533a = r0.getLeft();
        this.aH.f14534b = r0.getRight();
        h r1 = this.D.h();
        this.aI.f14533a = r1.getLeft();
        this.aI.f14534b = r1.getRight();
        if (this.aI.f14533a == this.aH.f14533a) goto L8;
    L10:
        this.aE.setObjectValues(new Object[]{this.aI, this.aH});
        if (this.aq == false) goto L13;
        this.aE.setInterpolator(this.aF);
    L13:
        this.aE.setDuration(350);
        this.aE.start();
        return;
    L8:
        if (this.aI.f14534b != this.aH.f14534b) goto L10;
        invalidate();
    }

    private void o() {
        int r0 = this.v;
        if (r0 == 0) goto L7;
        if (r0 != 1) goto L9;
        this.E.setGravity(1);
        int r1 = 2;
    L8:
        setOverScrollMode(r1);
    L9:
        c(true);
        return;
    L7:
        this.E.setGravity(GravityCompat.START);
        r1 = 0;
        goto L8
    }

    private void setSelectedTabView(int r6) {
        int r0 = this.E.getChildCount();
        if (r6 >= r0) goto L11;
        int r2 = 0;
    L5:
        if (r2 >= r0) goto L15;
        View r3 = this.E.getChildAt(r2);
        if (r2 != r6) goto L9;
        boolean r4 = true;
    L10:
        r3.setSelected(r4);
        r2 = r2 + 1;
        goto L5
    L9:
        r4 = false;
        goto L10
    L15:
        return;
    }

    float a(float r2) {
        return (ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getDisplayMetrics().density * r2) + 0.5f;
    }

    public g a(int r4) {
        g r0 = (g) ZeusTransformUtils.preCheckCast(A.acquire(), g.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L5;
        r0 = new g();
    L5:
        r0.f14543a = this;
        r0.f14544b = j();
        h r3 = r0.f14544b;
        if (r4 <= 0) goto L8;
        r3.a(r0, false);
        r0.a(r4);
    L9:
        return r0;
    L8:
        r3.setTab(r0);
        goto L9
    }

    public void a(int r2, float r3, boolean r4) {
        a(r2, r3, r4, true);
    }

    void a(int r3, float r4, boolean r5, boolean r6) {
        int r0 = Math.round(r3 + r4);
        if (r0 >= 0) goto L5;
        return;
    L5:
        if (r0 >= this.E.getChildCount()) goto L20;
        if (r6 == false) goto L9;
        this.E.a(r3, r4);
    L9:
        ValueAnimator r7 = this.Q;
        if (r7 != null) goto L12;
    L14:
        scrollTo(a(r3, r4), 0);
        if (r5 == false) goto L19;
        setSelectedTabView(r0);
        return;
    L19:
        return;
    L12:
        if (r7.isRunning() == false) goto L14;
        this.Q.cancel();
        goto L14
    }

    public void a(int r2, int r3) {
        this.H = d(r2);
        if (this.q <= d(20)) goto L6;
        this.I = d(r3);
        return;
    }

    public void a(int r1, int r2, int r3, int r4) {
        this.E.setPadding(r1, r2, r3, r4);
    }

    void a(PagerAdapter r3, boolean r4) {
        PagerAdapter r0 = this.R;
        if (r0 == null) goto L7;
        DataSetObserver r1 = this.S;
        if (r1 == null) goto L7;
        r0.unregisterDataSetObserver(r1);
    L7:
        this.R = r3;
        if (r4 == false) goto L14;
        if (r3 == null) goto L14;
        if (this.S != null) goto L13;
        this.S = new d(this);
    L13:
        r3.registerDataSetObserver(this.S);
    L14:
        e();
    }

    public void a(ViewPager r2, boolean r3) {
        a(r2, r3, false);
    }

    public void a(c r3) {
        c r4 = (c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.memorydata.plugin");
        if (this.O.contains(r4) == true) goto L6;
        this.O.add(r4);
        return;
    }

    public void a(g r2) {
        a(r2, this.B.isEmpty());
    }

    public void a(g r3, final int r4, boolean r5) {
        if (r3.f14543a != this) goto L9;
        a(r3, r4);
        c(r3);
        r3.h().setOnTouchListener(new AnonymousClass1(this, r4));
        if (r5 == false) goto L10;
        r3.e();
        return;
    L10:
        return;
    L9:
        throw new IllegalArgumentException("Tab belongs to a different TabLayout.");
    }

    public void a(g r2, boolean r3) {
        a(r2, this.B.size(), r3);
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

    @Override // com.obric.oui.material.h
    public void b(int r6) {
        if (this.at == false) goto L7;
        int r0 = 0;
        int r1 = this.B.size();
    L5:
        if (r0 >= r1) goto L9;
        ((g) ZeusTransformUtils.preCheckCast(this.B.get(r0), g.class, "com.obric.memorydata.plugin")).d(r6);
        r0 = r0 + 1;
        goto L5
    L9:
        return;
    }

    public void b(c r3) {
        c r4 = (c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.memorydata.plugin");
        this.O.remove(r4);
    }

    void b(g r2) {
        b(r2, true);
    }

    void b(g r5, boolean r6) {
        g r0 = this.C;
        if (r0 != r5) goto L7;
        if (r0 == null) goto L30;
        f(r5);
        h(r5.c());
        return;
    L30:
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
        h(r2);
        goto L17
    L13:
        if (r0.c() != (-1)) goto L16;
    L19:
        if (r0 == null) goto L21;
        e(r0);
    L21:
        g r7 = this.C;
        if (r7 != null) goto L24;
        r7 = r5;
    L24:
        this.D = r7;
        this.C = r5;
        if (this.ap == false) goto L27;
        n();
    L27:
        if (r5 == null) goto L32;
        d(r5);
        return;
    L32:
        return;
    L9:
        r2 = -1;
        goto L10
    }

    public g c(int r2) {
        if (r2 >= 0) goto L4;
    L7:
        return null;
    L4:
        if (r2 >= getTabCount()) goto L7;
        return (g) ZeusTransformUtils.preCheckCast(this.B.get(r2), g.class, "com.obric.memorydata.plugin");
    }

    public void c() {
        this.O.clear();
    }

    void c(boolean r6) {
        int r0 = 0;
    L4:
        if (r0 >= this.E.getChildCount()) goto L9;
        View r1 = this.E.getChildAt(r0);
        a((LinearLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r1.getLayoutParams(), LinearLayout.LayoutParams.class, "com.obric.memorydata.plugin"));
        if (r6 == false) goto L8;
        r1.requestLayout();
    L8:
        r0 = r0 + 1;
        goto L4
    }

    int d(int r2) {
        return (int) ((ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getDisplayMetrics().density * r2) + 0.5f);
    }

    public void d() {
        int r0 = this.E.getChildCount() - 1;
    L3:
        if (r0 < 0) goto L5;
        g(r0);
        r0 = r0 - 1;
        goto L3
    L5:
        Iterator<g> r1 = this.B.iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        g r2 = (g) ZeusTransformUtils.preCheckCast(r1.next(), g.class, "com.obric.memorydata.plugin");
        r1.remove();
        r2.j();
        A.release(r2);
        goto L7
    L9:
        this.C = null;
    }

    @Override // com.obric.oui.bouncelayout.OHorizontalScrollView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas r14) {
        float r0 = getBounceTranslation();
        float r1 = com.obric.oui.common.util.h.a(0.5f, (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
        boolean r3 = false;
        if (r0 >= (-r1)) goto L5;
        boolean r2 = true;
    L7:
        if (r0 <= r1) goto L9;
        boolean r4 = true;
    L11:
        if (canScrollHorizontally(-1) == true) goto L15;
        if (r2 == true) goto L15;
        boolean r5 = false;
    L17:
        if (canScrollHorizontally(1) == true) goto L19;
        if (r4 == true) goto L19;
    L20:
        this.aD.a(r5, r3, this);
        boolean r6 = this.aD.a();
        boolean r9 = this.aD.b();
        if (this.aD.a(getWidth(), getHeight()) == false) goto L32;
        float r7 = getScrollX();
        float r10 = getTabStripLeftPadding();
        float r11 = getTabStripRightPadding();
        com.obric.oui.tab.b.a(this.E, r7, getWidth(), getHeight(), r6, r9, this.am, this.an);
        int r12 = r14.saveLayer(this.am.left, this.am.top, this.am.right, this.am.bottom, null);
        a(r14);
        com.obric.oui.tab.a r8 = this.aD;
        float r13 = this.an.left;
        if (r6 == true) goto L26;
        r10 = 0.0f;
    L26:
        float r15 = r13 + r10;
        float r16 = this.an.top;
        float r17 = this.an.right;
        if (r9 == true) goto L30;
        r11 = 0.0f;
    L30:
        r8.a(r14, r15, r16, r17 - r11, this.an.bottom, r6, r9);
        r14.restoreToCount(r12);
        return;
    L32:
        a(r14);
        return;
    L19:
        r3 = true;
    L15:
        r5 = true;
        goto L17
    L9:
        r4 = false;
        goto L11
    L5:
        r2 = false;
        goto L7
    }

    void e() {
        d();
        PagerAdapter r0 = this.R;
        if (r0 == null) goto L17;
        int r1 = r0.getCount();
        int r2 = 0;
    L5:
        if (r2 >= r1) goto L7;
        a(a(this.w).a(this.R.getPageTitle(r2)), false);
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
        b(c(r4));
        return;
    L21:
        return;
    L19:
        return;
    L18:
        return;
    }

    public void e(int r3) {
        if (r3 < this.B.size()) goto L5;
        return;
    L5:
        if (this.B.isEmpty() == true) goto L13;
        g r4 = (g) ZeusTransformUtils.preCheckCast(this.B.get(r3), g.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L12;
        b(r4);
        return;
    L12:
        return;
    }

    public View f(int r1) {
        return this.E.getChildAt(r1);
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

    public float getEdgeFadeLength() {
        return this.aD.c();
    }

    public float getIndicatorCornerRadius() {
        return this.ag;
    }

    public int getSelectedTabPosition() {
        g r0 = this.C;
        if (r0 != null) goto L7;
        return -1;
    L7:
        return r0.c();
    }

    public ViewGroup getTabContainer() {
        return this.E;
    }

    public int getTabCount() {
        return this.B.size();
    }

    public float getTabDisabledAlpha() {
        return this.F;
    }

    public int getTabGravity() {
        return this.u;
    }

    int getTabMaxWidth() {
        return this.s;
    }

    public int getTabMode() {
        return this.v;
    }

    public int getTabStripLeftPadding() {
        return this.E.getPaddingLeft();
    }

    public int getTabStripRightPadding() {
        return this.E.getPaddingRight();
    }

    public ColorStateList getTabTextColors() {
        return this.n;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator r3) {
        a r4 = (a) ZeusTransformUtils.preCheckCast(r3.getAnimatedValue(), a.class, "com.obric.memorydata.plugin");
        Rect r0 = this.aA;
        r0.left = (int) r4.f14533a;
        Rect r1 = this.aA;
        r1.right = (int) r4.f14534b;
        invalidate();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.y != null) goto L8;
        ViewParent r0 = getParent();
        if (ZeusTransformUtils.instanceOf(r0, ViewPager.class) == false) goto L9;
        a((ViewPager) ZeusTransformUtils.preCheckCast(r0, ViewPager.class, "com.obric.memorydata.plugin"), true, true);
        return;
    L9:
        return;
    }

    @Override // com.obric.oui.bouncelayout.OHorizontalScrollView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.U == false) goto L6;
        setupWithViewPager(null);
        this.U = false;
        return;
    }

    @Override // android.view.View
    public void onDraw(Canvas r1) {
        super.onDraw(r1);
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    public void onMeasure(int r6, int r7) {
        int r0 = (d(getDefaultHeight()) + getPaddingTop()) + getPaddingBottom();
        int r1 = getMinimumHeight();
        if (r1 <= 0) goto L5;
        r0 = r1;
    L5:
        int r2 = View.MeasureSpec.getMode(r7);
        if (r2 == Integer.MIN_VALUE) goto L10;
        if (r2 == 0) goto L9;
        int r8 = Math.max(r0, View.MeasureSpec.getSize(r7));
    L11:
        int r9 = View.MeasureSpec.makeMeasureSpec(r8, 1073741824);
    L12:
        int r3 = View.MeasureSpec.getSize(r6);
        if (View.MeasureSpec.getMode(r6) == 0) goto L19;
        int r4 = this.K;
        if (r4 > 0) goto L18;
        r4 = r3 - d(56);
    L18:
        this.s = r4;
    L19:
        super.onMeasure(r6, r9);
        boolean r5 = true;
        if (getChildCount() != 1) goto L36;
        boolean r10 = false;
        View r11 = getChildAt(0);
        int r12 = this.v;
        if (r12 == 0) goto L29;
        if (r12 == 1) goto L26;
    L33:
        if (r10 == false) goto L37;
        r11.measure(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), getChildMeasureSpec(r9, getPaddingTop() + getPaddingBottom(), r11.getLayoutParams().height));
        return;
    L37:
        return;
    L26:
        if (r11.getMeasuredWidth() != getMeasuredWidth()) goto L32;
    L31:
        r5 = false;
    L32:
        r10 = r5;
        goto L33
    L29:
        if (r11.getMeasuredWidth() >= getMeasuredWidth()) goto L31;
    L36:
        return;
    L9:
        r9 = View.MeasureSpec.makeMeasureSpec(r0, 1073741824);
        goto L12
    L10:
        r8 = Math.min(r0, View.MeasureSpec.getSize(r7));
        goto L11
    }

    public void setAutoFillWhenScrollable(boolean r1) {
        this.x = r1;
    }

    @Override // com.obric.oui.material.h
    public void setBackdropTarget(View r6) {
        if (r6 != null) goto L5;
        WeakReference<View> r0 = new WeakReference(this);
    L6:
        this.e = r0;
        View r1 = (View) ZeusTransformUtils.preCheckCast(this.e.get(), View.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L16;
        if (r6 != null) goto L10;
        OMaterialHelper.a(this, null);
    L12:
        if (this.at == false) goto L18;
        int r7 = 0;
        int r2 = this.B.size();
    L14:
        if (r7 >= r2) goto L19;
        ((g) ZeusTransformUtils.preCheckCast(this.B.get(r7), g.class, "com.obric.memorydata.plugin")).b(r1);
        r7 = r7 + 1;
        goto L14
    L19:
        return;
    L18:
        return;
    L10:
        OMaterialHelper.a(this, r1);
        goto L12
    L16:
        return;
    L5:
        r0 = new WeakReference(r6);
        goto L6
    }

    public void setContentInsetStart(int r1) {
        this.M = r1;
    }

    public void setCustomTabViewResId(int r1) {
        this.w = r1;
    }

    public void setEdgeFadeEnabled(boolean r2) {
        if (this.aD.a(r2) == false) goto L6;
        invalidate();
        return;
    }

    public void setEdgeFadeLength(float r2) {
        if (this.aD.a(r2) == false) goto L6;
        invalidate();
        return;
    }

    @Override // android.view.View
    public void setEnabled(boolean r1) {
        super.setEnabled(r1);
        this.E.setEnabled(r1);
    }

    public void setIndicatorAnimEnable(boolean r1) {
        this.ap = r1;
        invalidate();
    }

    public void setIndicatorBounceEnable(boolean r1) {
        this.aq = r1;
    }

    public void setIndicatorCornerRadius(float r1) {
        this.ag = r1;
        invalidate();
    }

    public void setOnTabClickListener(b r3) {
        this.aL = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.memorydata.plugin");
    }

    @Deprecated
    public void setOnTabSelectedListener(c r3) {
        c r4 = (c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.memorydata.plugin");
        c r0 = this.N;
        if (r0 == null) goto L5;
        b(r0);
    L5:
        this.N = r4;
        if (r4 == null) goto L9;
        a(r4);
        return;
    }

    void setScrollAnimatorListener(Animator.AnimatorListener r3) {
        Animator.AnimatorListener r4 = (Animator.AnimatorListener) ZeusTransformUtils.wrapperContextForParams(r3, Animator.AnimatorListener.class, "com.obric.memorydata.plugin");
        m();
        this.Q.addListener(r4);
    }

    public void setSelectedTabHorizontalPadding(int r1) {
        this.E.c(r1);
    }

    public void setSelectedTabIndicatorColor(int r1) {
        this.E.a(r1);
    }

    public void setSelectedTabIndicatorHeight(int r1) {
        this.E.b(r1);
    }

    public void setShowSelectedIndicator(Boolean r1) {
        this.E.c(r1.booleanValue());
    }

    public void setShowTopLine(Boolean r1) {
        this.E.b(r1.booleanValue());
    }

    public void setTabBackgroundResId(int r1) {
        this.r = r1;
    }

    public void setTabDisabledAlpha(float r1) {
        this.F = b(r1);
    }

    public void setTabGravity(int r2) {
        if (this.u == r2) goto L6;
        this.u = r2;
        o();
        return;
    }

    public void setTabMargin(int r6) {
        this.G = d(r6);
        int r0 = 0;
    L4:
        if (r0 >= getTabCount()) goto L6;
        View r1 = this.E.getChildAt(r0);
        ViewGroup.MarginLayoutParams r2 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r1.getLayoutParams(), ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin");
        r2.leftMargin = d(r6);
        r2.rightMargin = d(r6);
        r1.setLayoutParams(r2);
        r0 = r0 + 1;
        goto L4
    }

    public void setTabMaxWidth(int r1) {
        this.K = r1;
        this.t = r1;
    }

    public void setTabMinWidth(int r1) {
        this.f14527J = r1;
    }

    public void setTabMode(int r2) {
        if (r2 == this.v) goto L6;
        this.v = r2;
        o();
        return;
    }

    public void setTabMode(String r2) {
        r2.hashCode();
        if (r2.equals("scrollable") == true) goto L12;
        if (r2.equals("fixed") == true) goto L8;
        return;
    L8:
        if (this.v == 1) goto L14;
        this.v = 1;
    L10:
        o();
        return;
    L14:
        return;
    L12:
        if (this.v == 0) goto L16;
        this.v = 0;
        goto L10
    }

    public void setTabPaddingBottom(int r1) {
        this.k = r1;
    }

    public void setTabPaddingEnd(int r1) {
        this.j = r1;
    }

    public void setTabPaddingStart(int r1) {
        this.h = r1;
    }

    public void setTabPaddingTop(int r1) {
        this.i = r1;
    }

    @Deprecated
    public void setTabTextAppearance(int r1) {
        this.m = r1;
    }

    public void setTabTextColors(ColorStateList r2) {
        if (this.n == r2) goto L6;
        this.n = r2;
        i();
        return;
    }

    public void setTabTextSize(float r2) {
        if (this.p == r2) goto L6;
        this.p = r2;
        i();
        return;
    }

    @Deprecated
    public void setTabsFromPagerAdapter(PagerAdapter r2) {
        a(r2, false);
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
