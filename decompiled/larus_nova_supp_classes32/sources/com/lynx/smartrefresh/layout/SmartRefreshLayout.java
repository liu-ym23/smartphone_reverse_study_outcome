package com.lynx.smartrefresh.layout;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.webkit.WebView;
import android.widget.AbsListView;
import android.widget.ScrollView;
import android.widget.Scroller;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.NestedScrollingParent;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.smartrefresh.layout.constant.RefreshState;
import com.lynx.smartrefresh.layout.footer.BallPulseFooter;
import com.lynx.smartrefresh.layout.header.BezierRadarHeader;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class SmartRefreshLayout extends ViewGroup implements m6a.i, NestedScrollingParent {
    public static final ViewGroup.MarginLayoutParams J2 = null;
    public boolean A;
    public boolean B;
    public final boolean C;
    public final boolean D;
    public final boolean E;
    public boolean E2;
    public final boolean F;
    public boolean F2;
    public final boolean G;
    public final float G1;
    public MotionEvent G2;
    public final boolean H;
    public boolean H0;
    public final float H1;
    public Runnable H2;
    public final boolean I;
    public ValueAnimator I2;
    public final boolean J;
    public boolean K;
    public final boolean L;
    public final int[] L0;
    public m6a.f L1;
    public final boolean M;
    public m6a.e M1;
    public final boolean N;
    public final boolean O;
    public boolean P;
    public final NestedScrollingChildHelper P0;
    public o6a.a P1;
    public final boolean Q;
    public Paint Q1;
    public final boolean R;
    public boolean S;
    public final Handler S1;
    public boolean T;
    public final i T1;
    public boolean U;
    public q6a.d V;
    public final NestedScrollingParentHelper V0;
    public RefreshState V1;
    public q6a.b W;
    public final int a;
    public int b;
    public int b1;
    public RefreshState b2;
    public int c;
    public int d;
    public int e;
    public final int f;
    public final int g;
    public n6a.a g1;
    public long g2;
    public float h;
    public int h1;
    public int h2;
    public float i;
    public float j;
    public float k;
    public q6a.c k0;
    public n6a.a k1;
    public final float l;
    public char m;
    public boolean n;
    public boolean o;
    public final int p;
    public int p0;
    public final int p1;
    public int p2;
    public final int q;
    public final int r;
    public final int s;
    public final int t;
    public final int u;
    public int v;
    public final int v1;
    public boolean v2;
    public final Scroller w;
    public final VelocityTracker x;
    public float x1;
    public boolean x2;
    public final r6a.b y;
    public final float y1;
    public boolean y2;
    public final int[] z;

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public final int a;
        public final n6a.b b;

        public LayoutParams(int r2) {
            super(-1, r2);
            this.a = 0;
            this.b = null;
        }

        public LayoutParams(Context r4, AttributeSet r5) {
            super(r4, r5);
            this.a = 0;
            this.b = null;
            TypedArray r6 = r4.obtainStyledAttributes(r5, new int[]{2130972478, 2130972479});
            this.a = r6.getColor(0, 0);
            if (r6.hasValue(1) == false) goto L5;
            n6a.b[] r1 = n6a.b.h;
            n6a.b r2 = n6a.b.d;
            this.b = r1[r6.getInt(1, 0)];
        L5:
            r6.recycle();
        }
    }

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[RefreshState.values().length];
            a = r0;
            r0[RefreshState.None.ordinal()] = 1;     // Catch: NoSuchFieldError -> L21
        L60:
            a[RefreshState.PullDownToRefresh.ordinal()] = 2;     // Catch: NoSuchFieldError -> L22
        L44:
            a[RefreshState.PullUpToLoad.ordinal()] = 3;     // Catch: NoSuchFieldError -> L23
        L56:
            a[RefreshState.PullDownCanceled.ordinal()] = 4;     // Catch: NoSuchFieldError -> L24
        L62:
            a[RefreshState.PullUpCanceled.ordinal()] = 5;     // Catch: NoSuchFieldError -> L25
        L46:
            a[RefreshState.ReleaseToRefresh.ordinal()] = 6;     // Catch: NoSuchFieldError -> L26
        L50:
            a[RefreshState.ReleaseToLoad.ordinal()] = 7;     // Catch: NoSuchFieldError -> L27
        L70:
            a[RefreshState.ReleaseToTwoLevel.ordinal()] = 8;     // Catch: NoSuchFieldError -> L28
        L40:
            a[RefreshState.RefreshReleased.ordinal()] = 9;     // Catch: NoSuchFieldError -> L29
        L64:
            a[RefreshState.LoadReleased.ordinal()] = 10;     // Catch: NoSuchFieldError -> L30
        L66:
            a[RefreshState.Refreshing.ordinal()] = 11;     // Catch: NoSuchFieldError -> L31
        L52:
            a[RefreshState.Loading.ordinal()] = 12;     // Catch: NoSuchFieldError -> L32
        L58:
            a[RefreshState.RefreshFinish.ordinal()] = 13;     // Catch: NoSuchFieldError -> L33
        L42:
            a[RefreshState.LoadFinish.ordinal()] = 14;     // Catch: NoSuchFieldError -> L34
        L48:
            a[RefreshState.TwoLevelReleased.ordinal()] = 15;     // Catch: NoSuchFieldError -> L35
        L68:
            a[RefreshState.TwoLevelFinish.ordinal()] = 16;     // Catch: NoSuchFieldError -> L36
        L38:
            a[RefreshState.TwoLevel.ordinal()] = 17;     // Catch: NoSuchFieldError -> L37
            return;
        }
    }

    public class b extends AnimatorListenerAdapter {
        public final /* synthetic */ boolean a;
        public final /* synthetic */ SmartRefreshLayout b;

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r2) {
            this.b.setStateDirectLoading(this.a);
        }

        public b(SmartRefreshLayout r1, boolean r2) {
            this.b = r1;
            this.a = r2;
        }
    }

    public class c extends AnimatorListenerAdapter {
        public final /* synthetic */ boolean a;
        public final /* synthetic */ SmartRefreshLayout b;

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r5) {
            this.b.g2 = System.currentTimeMillis();
            this.b.n(RefreshState.Refreshing);
            SmartRefreshLayout r6 = this.b;
            q6a.d r0 = r6.V;
            if (r0 == null) goto L8;
            if (this.a == false) goto L10;
            r0.l(r6);
        L10:
            SmartRefreshLayout r7 = this.b;
            m6a.f r1 = r7.L1;
            if (r1 == null) goto L13;
            int r2 = r7.b1;
            r1.n(r7, r2, (int) (r7.x1 * r2));
        L13:
            SmartRefreshLayout r8 = this.b;
            q6a.c r3 = r8.k0;
            if (r3 != null) goto L16;
            return;
        L16:
            if ((r8.L1 instanceof m6a.f) == true) goto L18;
            return;
        L18:
            if (this.a == false) goto L20;
            r3.l(r8);
        L20:
            this.b.k0.o();
            return;
        L8:
            if (r6.k0 != null) goto L10;
            r6.i(3000, true, Boolean.FALSE);
            goto L10
        }

        public c(SmartRefreshLayout r1, boolean r2) {
            this.b = r1;
            this.a = r2;
        }
    }

    public class d extends AnimatorListenerAdapter {
        public final /* synthetic */ SmartRefreshLayout a;

        public d(SmartRefreshLayout r1) {
            this.a = r1;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r4) {
            SmartRefreshLayout r5 = this.a;
            r5.I2 = null;
            if (r5.b != 0) goto L11;
            RefreshState r0 = r5.V1;
            RefreshState r1 = RefreshState.None;
            if (r0 == r1) goto L11;
            if (r0.isOpening == true) goto L11;
            if (r0.isDragging == true) goto L11;
            r5.n(r1);
            return;
        L11:
            RefreshState r2 = r5.V1;
            if (r2 == r5.b2) goto L16;
            r5.setViceState(r2);
            return;
        }
    }

    public class e implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ SmartRefreshLayout a;

        public e(SmartRefreshLayout r1) {
            this.a = r1;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r3) {
            this.a.T1.b(((Integer) r3.getAnimatedValue()).intValue(), false);
        }
    }

    public class f implements Runnable {
        public final /* synthetic */ SmartRefreshLayout a;

        @Override // java.lang.Runnable
        public final void run() {
            SmartRefreshLayout r0 = this.a;     // Catch: Throwable -> L12
            q6a.b r1 = r0.W;     // Catch: Throwable -> L12
            if (r1 == null) goto L6;
            r1.g(r0);     // Catch: Throwable -> L12
        L8:
            SmartRefreshLayout r2 = this.a;     // Catch: Throwable -> L12
            q6a.c r3 = r2.k0;     // Catch: Throwable -> L12
            if (r3 == null) goto L15;
            r3.g(r2);     // Catch: Throwable -> L12
            return;
        L15:
            return;
        L6:
            if (r0.k0 != null) goto L8;
            r0.h(2000, false);     // Catch: Throwable -> L12
        L12:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L19;
            throw th;
        }

        public f(SmartRefreshLayout r1) {
            this.a = r1;
        }
    }

    public class g implements Runnable {
        public int a;
        public final int b;
        public long c;
        public float d;
        public float e;
        public final /* synthetic */ SmartRefreshLayout f;

        public final void a() {
            SmartRefreshLayout r0 = this.f;
            if (r0.H2 == this) goto L5;
            return;
        L5:
            if (r0.V1.isFinishing == false) goto L7;
            return;
        L7:
            if (Math.abs(r0.b) >= Math.abs(this.b)) goto L9;
            double r1 = this.e;
            int r2 = this.a + 1;
            this.a = r2;
            this.e = (float) (r1 * Math.pow(0.949999988079071d, r2 * 2));
        L13:
            long r3 = AnimationUtils.currentAnimationTimeMillis();
            float r4 = this.e * (((r3 - this.c) * 1.0f) / 1000.0f);
            if (Math.abs(r4) < 1.0f) goto L16;
            this.c = r3;
            float r5 = this.d + r4;
            this.d = r5;
            this.f.m(r5);
            this.f.S1.postDelayed(this, 10);
            return;
        L16:
            SmartRefreshLayout r6 = this.f;
            RefreshState r7 = r6.b2;
            boolean r8 = r7.isDragging;
            if (r8 == true) goto L19;
        L21:
            if (r8 == true) goto L23;
        L25:
            SmartRefreshLayout r9 = this.f;
            r9.H2 = null;
            if (Math.abs(r9.b) < Math.abs(this.b)) goto L32;
            int r10 = Math.min(Math.max((int) (Math.abs(this.f.b - this.b) / r6a.b.b), 30), 100) * 10;
            SmartRefreshLayout r11 = this.f;
            r11.g(this.b, 0, r11.y, r10);
            return;
        L32:
            return;
        L23:
            if (r7.isFooter == false) goto L25;
            r6.T1.d(RefreshState.PullUpCanceled);
            goto L25
        L19:
            if (r7.isHeader == false) goto L21;
            r6.T1.d(RefreshState.PullDownCanceled);
            goto L25
        L9:
            if (this.b == 0) goto L11;
            double r12 = this.e;
            int r13 = this.a + 1;
            this.a = r13;
            this.e = (float) (r12 * Math.pow(0.44999998807907104d, r13 * 2));
            goto L13
        L11:
            double r14 = this.e;
            int r15 = this.a + 1;
            this.a = r15;
            this.e = (float) (r14 * Math.pow(0.8500000238418579d, r15 * 2));
            goto L13
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public g(SmartRefreshLayout r4, float r5, int r6) {
            this.f = r4;
            this.a = 0;
            this.d = 0.0f;
            this.e = r5;
            this.b = r6;
            this.c = AnimationUtils.currentAnimationTimeMillis();
            r4.S1.postDelayed(this, 10);
            if (r5 <= 0.0f) goto L5;
            r4.T1.d(RefreshState.PullDownToRefresh);
            return;
        L5:
            r4.T1.d(RefreshState.PullUpToLoad);
        }
    }

    public class h implements Runnable {
        public int a;
        public float b;
        public long c;
        public long d;
        public final /* synthetic */ SmartRefreshLayout e;

        public final void a() {
            SmartRefreshLayout r0 = this.e;
            if (r0.H2 == this) goto L5;
            return;
        L5:
            if (r0.V1.isFinishing == true) goto L34;
            long r1 = AnimationUtils.currentAnimationTimeMillis();
            long r2 = r1 - this.d;
            float r4 = (float) (((double) this.b) * Math.pow(0.98f, (r1 - this.c) / (1000.0f / 10)));
            this.b = r4;
            float r5 = r4 * ((r2 * 1.0f) / 1000.0f);
            if (Math.abs(r5) <= 1.0f) goto L31;
            this.d = r1;
            int r3 = (int) (this.a + r5);
            this.a = r3;
            SmartRefreshLayout r6 = this.e;
            if ((r6.b * r3) <= 0) goto L11;
            r6.T1.b(r3, true);
            this.e.S1.postDelayed(this, 10);
            return;
        L11:
            r6.H2 = null;
            r6.T1.b(0, true);
            NestedScrollView r7 = this.e.P1.c;
            int r8 = (int) (-this.b);
            float r9 = r6a.b.b;
            if ((r7 instanceof ScrollView) == false) goto L15;
            ((ScrollView) r7).fling(r8);
        L26:
            SmartRefreshLayout r10 = this.e;
            if (r10.E2 == true) goto L29;
            return;
        L29:
            if (r5 <= 0.0f) goto L37;
            r10.E2 = false;
            return;
        L37:
            return;
        L15:
            if ((r7 instanceof AbsListView) == false) goto L18;
            ((AbsListView) r7).fling(r8);
            goto L26
        L18:
            if ((r7 instanceof WebView) == false) goto L21;
            ((WebView) r7).flingScroll(0, r8);
            goto L26
        L21:
            if ((r7 instanceof NestedScrollView) == false) goto L24;
            r7.fling(r8);
            goto L26
        L24:
            if ((r7 instanceof RecyclerView) == false) goto L26;
            ((RecyclerView) r7).fling(0, r8);
            goto L26
        L31:
            this.e.H2 = null;
            return;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public h(SmartRefreshLayout r3, float r4) {
            this.e = r3;
            this.c = 0;
            this.d = AnimationUtils.currentAnimationTimeMillis();
            this.b = r4;
            this.a = r3.b;
        }
    }

    public class i implements m6a.h {
        public final /* synthetic */ SmartRefreshLayout a;

        public i(SmartRefreshLayout r1) {
            this.a = r1;
        }

        public final ValueAnimator a(int r5) {
            SmartRefreshLayout r0 = this.a;
            return r0.g(r5, 0, r0.y, r0.f);
        }

        public final void d(RefreshState r3) {
            switch(a.a[r3.ordinal()]) {
                case 1: goto L92;
                case 2: goto L86;
                case 3: goto L72;
                case 4: goto L66;
                case 5: goto L54;
                case 6: goto L48;
                case 7: goto L34;
                case 8: goto L28;
                case 9: goto L22;
                case 10: goto L16;
                case 11: goto L15;
                case 12: goto L14;
                case 13: goto L11;
                case 14: goto L8;
                case 15: goto L7;
                case 16: goto L6;
                case 17: goto L5;
                default: goto L130;
            };
        L5:
            this.a.n(RefreshState.TwoLevel);
            return;
        L6:
            this.a.n(RefreshState.TwoLevelFinish);
            return;
        L7:
            this.a.n(RefreshState.TwoLevelReleased);
            return;
        L8:
            SmartRefreshLayout r4 = this.a;
            if (r4.V1 != RefreshState.Loading) goto L104;
            r4.n(RefreshState.LoadFinish);
            return;
        L104:
            return;
        L11:
            SmartRefreshLayout r5 = this.a;
            if (r5.V1 != RefreshState.Refreshing) goto L106;
            r5.n(RefreshState.RefreshFinish);
            return;
        L106:
            return;
        L14:
            this.a.setStateLoading(true);
            return;
        L15:
            this.a.setStateRefreshing(true);
            return;
        L16:
            SmartRefreshLayout r6 = this.a;
            if (r6.V1.isOpening == false) goto L19;
        L21:
            this.a.setViceState(RefreshState.LoadReleased);
            return;
        L19:
            if (r6.k(r6.B) == false) goto L21;
            this.a.n(RefreshState.LoadReleased);
            return;
        L22:
            SmartRefreshLayout r7 = this.a;
            if (r7.V1.isOpening == false) goto L25;
        L27:
            this.a.setViceState(RefreshState.RefreshReleased);
            return;
        L25:
            if (r7.k(r7.A) == false) goto L27;
            this.a.n(RefreshState.RefreshReleased);
            return;
        L28:
            SmartRefreshLayout r8 = this.a;
            if (r8.V1.isOpening == false) goto L31;
        L33:
            this.a.setViceState(RefreshState.ReleaseToTwoLevel);
            return;
        L31:
            if (r8.k(r8.A) == false) goto L33;
            this.a.n(RefreshState.ReleaseToTwoLevel);
            return;
        L34:
            SmartRefreshLayout r9 = this.a;
            if (r9.k(r9.B) == false) goto L47;
            SmartRefreshLayout r10 = this.a;
            RefreshState r0 = r10.V1;
            if (r0.isOpening == true) goto L47;
            if (r0.isFinishing == true) goto L47;
            if (r10.S == true) goto L43;
        L46:
            r10.n(RefreshState.ReleaseToLoad);
            return;
        L43:
            if (r10.G == false) goto L46;
            if (r10.T == false) goto L46;
        L47:
            this.a.setViceState(RefreshState.ReleaseToLoad);
            return;
        L48:
            SmartRefreshLayout r11 = this.a;
            if (r11.V1.isOpening == false) goto L51;
        L53:
            this.a.setViceState(RefreshState.ReleaseToRefresh);
            return;
        L51:
            if (r11.k(r11.A) == false) goto L53;
            this.a.n(RefreshState.ReleaseToRefresh);
            return;
        L54:
            SmartRefreshLayout r12 = this.a;
            if (r12.k(r12.B) == false) goto L65;
            SmartRefreshLayout r13 = this.a;
            if (r13.V1.isOpening == true) goto L65;
            if (r13.S == true) goto L61;
        L64:
            r13.n(RefreshState.PullUpCanceled);
            d(RefreshState.None);
            return;
        L61:
            if (r13.G == false) goto L64;
            if (r13.T == false) goto L64;
        L65:
            this.a.setViceState(RefreshState.PullUpCanceled);
            return;
        L66:
            SmartRefreshLayout r14 = this.a;
            if (r14.V1.isOpening == false) goto L69;
        L71:
            this.a.setViceState(RefreshState.PullDownCanceled);
            return;
        L69:
            if (r14.k(r14.A) == false) goto L71;
            this.a.n(RefreshState.PullDownCanceled);
            d(RefreshState.None);
            return;
        L72:
            SmartRefreshLayout r15 = this.a;
            if (r15.k(r15.B) == false) goto L85;
            SmartRefreshLayout r16 = this.a;
            RefreshState r1 = r16.V1;
            if (r1.isOpening == true) goto L85;
            if (r1.isFinishing == true) goto L85;
            if (r16.S == true) goto L81;
        L84:
            r16.n(RefreshState.PullUpToLoad);
            return;
        L81:
            if (r16.G == false) goto L84;
            if (r16.T == false) goto L84;
        L85:
            this.a.setViceState(RefreshState.PullUpToLoad);
            return;
        L86:
            SmartRefreshLayout r17 = this.a;
            if (r17.V1.isOpening == false) goto L89;
        L91:
            this.a.setViceState(RefreshState.PullDownToRefresh);
            return;
        L89:
            if (r17.k(r17.A) == false) goto L91;
            this.a.n(RefreshState.PullDownToRefresh);
            return;
        L92:
            SmartRefreshLayout r18 = this.a;
            RefreshState r2 = r18.V1;
            RefreshState r19 = RefreshState.None;
            if (r2 == r19) goto L98;
            if (r18.b != 0) goto L98;
            r18.n(r19);
            return;
        L98:
            if (r18.b == 0) goto L129;
            a(0);
            return;
        L129:
            return;
        }

        public final i b(int r17, boolean r18) {
            SmartRefreshLayout r2 = this.a;
            if (r2.b != r17) goto L13;
            m6a.f r3 = r2.L1;
            if (r3 != null) goto L7;
        L8:
            m6a.e r4 = this.a.M1;
            if (r4 != null) goto L11;
        L12:
            return this;
        L11:
            if (r4.a() == true) goto L13;
        L7:
            if (r3.a() == false) goto L8;
        L13:
            SmartRefreshLayout r9 = this.a;
            int r10 = r9.b;
            r9.b = r17;
            if (r18 == false) goto L35;
            RefreshState r5 = r9.b2;
            if (r5.isDragging == true) goto L20;
            if (r5.isOpening == false) goto L35;
        L20:
            if (r17 <= (r9.b1 * r9.G1)) goto L25;
            if (r9.V1 == RefreshState.ReleaseToTwoLevel) goto L35;
            r9.T1.d(RefreshState.ReleaseToRefresh);
            goto L35
        L25:
            if ((-r17) > (r9.h1 * r9.H1)) goto L27;
        L29:
            if (r17 < 0) goto L31;
        L33:
            if (r17 <= 0) goto L35;
            r9.T1.d(RefreshState.PullDownToRefresh);
            goto L35
        L31:
            if (r9.S == true) goto L33;
            r9.T1.d(RefreshState.PullUpToLoad);
            goto L35
        L27:
            if (r9.S == true) goto L29;
            r9.T1.d(RefreshState.ReleaseToLoad);
        L35:
            SmartRefreshLayout r6 = this.a;
            if (r6.P1 == null) goto L106;
            if (r17 < 0) goto L46;
            m6a.f r7 = r6.L1;
            if (r7 == null) goto L46;
            if (r6.l(r6.E, r7) == false) goto L43;
            int r8 = r17;
        L45:
            boolean r11 = true;
        L47:
            if (r17 > 0) goto L56;
            SmartRefreshLayout r12 = this.a;
            m6a.e r13 = r12.M1;
            if (r13 == null) goto L56;
            if (r12.l(r12.F, r13) == false) goto L53;
            r8 = r17;
        L55:
            r11 = true;
            goto L56
        L53:
            if (r10 <= 0) goto L56;
            r8 = 0;
        L56:
            if (r11 == false) goto L106;
            SmartRefreshLayout r14 = this.a;
            r14.P1.d(r8, r14.r, r14.s);
            SmartRefreshLayout r15 = this.a;
            if (r15.S == true) goto L60;
        L70:
            SmartRefreshLayout r16 = this.a;
            if (r16.C == false) goto L77;
            m6a.f r19 = r16.L1;
            if (r19 == null) goto L77;
            if (r19.getSpinnerStyle() != n6a.b.e) goto L77;
            boolean r20 = true;
        L78:
            if (r20 == false) goto L80;
        L83:
            boolean r21 = true;
        L84:
            SmartRefreshLayout r22 = this.a;
            if (r22.D == false) goto L91;
            m6a.e r23 = r22.M1;
            if (r23 == null) goto L91;
            if (r23.getSpinnerStyle() != n6a.b.e) goto L91;
            boolean r24 = true;
        L92:
            if (r24 == false) goto L94;
        L97:
            boolean r25 = true;
        L98:
            if (r21 == false) goto L101;
            if (r8 >= 0) goto L104;
            if (r10 <= 0) goto L101;
        L104:
            r9.invalidate();
        L101:
            if (r25 == false) goto L106;
            if (r8 <= 0) goto L104;
            if (r10 >= 0) goto L106;
        L94:
            if (this.a.p2 != 0) goto L97;
            r25 = false;
        L91:
            r24 = false;
            goto L92
        L80:
            if (this.a.h2 != 0) goto L83;
            r21 = false;
        L77:
            r20 = false;
            goto L78
        L60:
            if (r15.T == false) goto L70;
            if (r15.G == false) goto L70;
            m6a.e r26 = r15.M1;
            if ((r26 instanceof m6a.e) == false) goto L70;
            if (r26.getSpinnerStyle() != n6a.b.d) goto L70;
            SmartRefreshLayout r27 = this.a;
            if (r27.k(r27.B) == false) goto L70;
            this.a.M1.getView().setTranslationY(Math.max(0, r8));
            goto L70
        L43:
            if (r10 >= 0) goto L46;
            r8 = 0;
        L46:
            r8 = 0;
            r11 = false;
        L106:
            if (r17 >= 0) goto L109;
            if (r10 > 0) goto L109;
        L153:
            if (r17 <= 0) goto L156;
            if (r10 < 0) goto L156;
        L200:
            return this;
        L156:
            if (this.a.M1 == null) goto L200;
            int r28 = -Math.min(r17, 0);
            SmartRefreshLayout r1 = this.a;
            int r29 = r1.h1;
            int r30 = (int) (r29 * r1.y1);
            float r31 = r28 * 1.0f;
            if (r29 != 0) goto L160;
            int r32 = 1;
        L161:
            float r33 = r31 / r32;
            if (r1.k(r1.B) == false) goto L164;
        L166:
            SmartRefreshLayout r34 = this.a;
            if (r10 != r34.b) goto L169;
        L185:
            if (r18 == true) goto L187;
        L193:
            SmartRefreshLayout r35 = this.a;
            if (r10 == r35.b) goto L200;
            q6a.c r36 = r35.k0;
            if (r36 == null) goto L200;
            if ((r35.M1 instanceof m6a.e) == false) goto L200;
            r36.m(r18, r33);
            goto L200
        L187:
            if (this.a.M1.a() == false) goto L193;
            int r37 = (int) this.a.j;
            int r38 = r9.getWidth();
            SmartRefreshLayout r39 = this.a;
            float r40 = r39.j;
            if (r38 != 0) goto L191;
            int r110 = 1;
        L192:
            r39.M1.d(r40 / r110, r37, r38);
            goto L193
        L191:
            r110 = r38;
            goto L192
        L169:
            if (r34.M1.getSpinnerStyle() != n6a.b.d) goto L178;
            this.a.M1.getView().setTranslationY(this.a.b);
            SmartRefreshLayout r41 = this.a;
            if (r41.p2 != 0) goto L173;
        L184:
            this.a.M1.b(r18, r33, r28, r29, r30);
            goto L185
        L173:
            if (r41.Q1 == null) goto L184;
            if (r41.l(r41.F, r41.M1) == true) goto L184;
            r9.invalidate();
            goto L184
        L178:
            if (this.a.M1.getSpinnerStyle().c == false) goto L184;
            View r42 = this.a.M1.getView();
            ViewGroup.LayoutParams r43 = r42.getLayoutParams();
            if ((r43 instanceof ViewGroup.MarginLayoutParams) == false) goto L182;
            ViewGroup.MarginLayoutParams r44 = (ViewGroup.MarginLayoutParams) r43;
        L183:
            r42.measure(View.MeasureSpec.makeMeasureSpec(r42.getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(Math.max(((-this.a.b) - r44.bottomMargin) - r44.topMargin, 0), 1073741824));
            int r45 = r44.leftMargin;
            int r46 = (r44.topMargin + r9.getMeasuredHeight()) - this.a.v1;
            r42.layout(r45, r46 - r42.getMeasuredHeight(), r42.getMeasuredWidth() + r45, r46);
            goto L184
        L182:
            r44 = SmartRefreshLayout.J2;
            goto L183
        L164:
            if (this.a.V1 != RefreshState.LoadFinish) goto L193;
            if (r18 == true) goto L193;
        L160:
            r32 = r29;
        L109:
            if (this.a.L1 == null) goto L153;
            int r47 = Math.max(r17, 0);
            SmartRefreshLayout r48 = this.a;
            int r49 = r48.b1;
            int r50 = (int) (r49 * r48.x1);
            float r51 = r47 * 1.0f;
            if (r49 != 0) goto L113;
            int r52 = 1;
        L114:
            float r111 = r51 / r52;
            if (r48.k(r48.A) == false) goto L117;
        L119:
            SmartRefreshLayout r53 = this.a;
            if (r10 != r53.b) goto L122;
        L138:
            if (r18 == true) goto L140;
        L146:
            SmartRefreshLayout r54 = this.a;
            if (r10 == r54.b) goto L153;
            q6a.c r55 = r54.k0;
            if (r55 == null) goto L153;
            if ((r54.L1 instanceof m6a.f) == false) goto L153;
            r55.f(r18, r111);
            goto L153
        L140:
            if (this.a.L1.a() == false) goto L146;
            int r56 = (int) this.a.j;
            int r57 = r9.getWidth();
            SmartRefreshLayout r58 = this.a;
            float r59 = r58.j;
            if (r57 != 0) goto L144;
            int r60 = 1;
        L145:
            r58.L1.d(r59 / r60, r56, r57);
            goto L146
        L144:
            r60 = r57;
            goto L145
        L122:
            if (r53.L1.getSpinnerStyle() != n6a.b.d) goto L131;
            this.a.L1.getView().setTranslationY(this.a.b);
            SmartRefreshLayout r61 = this.a;
            if (r61.h2 != 0) goto L126;
        L137:
            this.a.L1.b(r18, r111, r47, r49, r50);
            goto L138
        L126:
            if (r61.Q1 == null) goto L137;
            if (r61.l(r61.E, r61.L1) == true) goto L137;
            r9.invalidate();
            goto L137
        L131:
            if (this.a.L1.getSpinnerStyle().c == false) goto L137;
            View r62 = this.a.L1.getView();
            ViewGroup.LayoutParams r63 = r62.getLayoutParams();
            if ((r63 instanceof ViewGroup.MarginLayoutParams) == false) goto L135;
            ViewGroup.MarginLayoutParams r64 = (ViewGroup.MarginLayoutParams) r63;
        L136:
            r62.measure(View.MeasureSpec.makeMeasureSpec(r62.getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(Math.max((this.a.b - r64.bottomMargin) - r64.topMargin, 0), 1073741824));
            int r65 = r64.leftMargin;
            int r66 = r64.topMargin + this.a.p1;
            r62.layout(r65, r66, r62.getMeasuredWidth() + r65, r62.getMeasuredHeight() + r66);
            goto L137
        L135:
            r64 = SmartRefreshLayout.J2;
            goto L136
        L117:
            if (this.a.V1 != RefreshState.RefreshFinish) goto L146;
            if (r18 == true) goto L146;
        L113:
            r52 = r49;
            goto L114
        }

        public final i c(m6a.g r3, int r4) {
            SmartRefreshLayout r0 = this.a;
            if (r0.Q1 != null) goto L7;
            if (r4 == 0) goto L7;
            r0.Q1 = new Paint();
        L7:
            if (r3.equals(this.a.L1) == false) goto L10;
            this.a.h2 = r4;
        L12:
            return this;
        L10:
            if (r3.equals(this.a.M1) == false) goto L12;
            this.a.p2 = r4;
            goto L12
        }
    }

    public static void setDefaultRefreshFooterCreator(m6a.a r0) {
    }

    public static void setDefaultRefreshHeaderCreator(m6a.b r0) {
    }

    public static void setDefaultRefreshInitializer(m6a.c r0) {
    }

    @Override // m6a.i
    public ViewGroup getLayout() {
        return this;
    }

    static {
        J2 = new ViewGroup.MarginLayoutParams(-1, -1);
    }

    @Override // android.view.View
    public void computeScroll() {
        this.w.getCurrY();
        if (this.w.computeScrollOffset() == false) goto L62;
        int r0 = this.w.getFinalY();
        if (r0 < 0) goto L7;
    L12:
        if (r0 > 0) goto L14;
    L60:
        this.F2 = true;
        invalidate();
        return;
    L14:
        if (this.B == true) goto L18;
        if (this.J == false) goto L60;
    L18:
        if (this.P1.canLoadMore() == false) goto L60;
    L20:
        if (this.F2 == false) goto L59;
        if (r0 <= 0) goto L23;
        float r1 = -this.w.getCurrVelocity();
    L25:
        if (this.I2 != null) goto L59;
        if (r1 <= 0.0f) goto L34;
        RefreshState r3 = this.V1;
        if (r3 != RefreshState.Refreshing) goto L31;
    L32:
        this.H2 = new g(this, r1, this.b1);
        goto L59
    L31:
        if (r3 == RefreshState.TwoLevel) goto L32;
    L34:
        if (r1 >= 0.0f) goto L55;
        if (this.V1 != RefreshState.Loading) goto L38;
    L53:
        this.H2 = new g(this, r1, -this.h1);
        goto L59
    L38:
        if (this.G == false) goto L46;
        if (this.S == false) goto L46;
        if (this.T == false) goto L46;
        if (k(this.B) == true) goto L53;
    L46:
        if (this.K == false) goto L55;
        if (this.S == true) goto L55;
        if (k(this.B) == false) goto L55;
        if (this.V1 != RefreshState.Refreshing) goto L53;
    L55:
        if (this.b != 0) goto L59;
        if (this.I == false) goto L59;
        this.H2 = new g(this, r1, 0);
        goto L59
    L23:
        r1 = this.w.getCurrVelocity();
    L59:
        this.w.forceFinished(true);
        return;
    L7:
        if (this.A == true) goto L11;
        if (this.J == false) goto L12;
    L11:
        if (this.P1.b() == true) goto L20;
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return this.V0.getNestedScrollAxes();
    }

    public m6a.e getRefreshFooter() {
        m6a.e r0 = this.M1;
        if ((r0 instanceof m6a.e) == true) goto L7;
        return null;
    L7:
        return r0;
    }

    public m6a.f getRefreshHeader() {
        m6a.f r0 = this.L1;
        if ((r0 instanceof m6a.f) == true) goto L7;
        return null;
    L7:
        return r0;
    }

    @Override // android.view.View
    public final boolean isNestedScrollingEnabled() {
        if (this.P == true) goto L5;
    L11:
        return false;
    L5:
        if (this.J == false) goto L7;
    L10:
        return true;
    L7:
        if (this.A == true) goto L10;
        if (this.B == false) goto L11;
        goto L10
    }

    public final void o() {
        RefreshState r0 = this.V1;
        RefreshState r1 = RefreshState.TwoLevel;
        if (r0 == r1) goto L5;
        RefreshState r2 = RefreshState.Loading;
        if (r0 != r2) goto L22;
    L67:
        int r3 = this.b;
        int r4 = -this.h1;
        if (r3 >= r4) goto L70;
        this.T1.a(r4);
        return;
    L70:
        if (r3 <= 0) goto L94;
        this.T1.a(0);
        return;
    L94:
        return;
    L22:
        if (this.G == true) goto L24;
    L32:
        RefreshState r5 = this.V1;
        RefreshState r6 = RefreshState.Refreshing;
        if (r5 != r6) goto L40;
        int r7 = this.b;
        int r8 = this.b1;
        if (r7 <= r8) goto L37;
        this.T1.a(r8);
        return;
    L37:
        if (r7 >= 0) goto L80;
        this.T1.a(0);
        return;
    L80:
        return;
    L40:
        if (r5 != RefreshState.PullDownToRefresh) goto L43;
        this.T1.d(RefreshState.PullDownCanceled);
        return;
    L43:
        if (r5 != RefreshState.PullUpToLoad) goto L46;
        this.T1.d(RefreshState.PullUpCanceled);
        return;
    L46:
        if (r5 != RefreshState.ReleaseToRefresh) goto L49;
        this.T1.d(r6);
        return;
    L49:
        if (r5 != RefreshState.ReleaseToLoad) goto L52;
        this.T1.d(r2);
        return;
    L52:
        if (r5 != RefreshState.ReleaseToTwoLevel) goto L55;
        this.T1.d(RefreshState.TwoLevelReleased);
        return;
    L55:
        if (r5 != RefreshState.RefreshReleased) goto L60;
        if (this.I2 != null) goto L87;
        this.T1.a(this.b1);
        return;
    L87:
        return;
    L60:
        if (r5 != RefreshState.LoadReleased) goto L65;
        if (this.I2 != null) goto L89;
        this.T1.a(-this.h1);
        return;
    L89:
        return;
    L65:
        if (this.b == 0) goto L91;
        this.T1.a(0);
        return;
    L91:
        return;
    L24:
        if (this.S == false) goto L32;
        if (this.T == false) goto L32;
        if (this.b >= 0) goto L32;
        if (k(this.B) == false) goto L32;
    L5:
        if (this.v <= (-1000)) goto L12;
        if (this.b <= (getMeasuredHeight() / 2)) goto L12;
        ValueAnimator r9 = this.T1.a(getMeasuredHeight());
        if (r9 == null) goto L73;
        r9.setDuration(this.e);
        return;
    L73:
        return;
    L12:
        if (this.n == false) goto L75;
        i r10 = this.T1;
        SmartRefreshLayout r11 = r10.a;
        if (r11.V1 != r1) goto L76;
        r11.T1.d(RefreshState.TwoLevelFinish);
        if (r10.a.b != 0) goto L18;
        r10.b(0, false);
        r10.a.n(RefreshState.None);
        return;
    L18:
        r10.a(0).setDuration(r10.a.e);
        return;
    L76:
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        boolean r0 = true;
        this.y2 = true;
        if (isInEditMode() == false) goto L5;
    L37:
        int[] r1 = this.z;
        if (r1 == null) goto L45;
        m6a.f r2 = this.L1;
        if (r2 == null) goto L42;
        r2.setPrimaryColors(r1);
    L42:
        m6a.e r3 = this.M1;
        if (r3 == null) goto L45;
        r3.setPrimaryColors(this.z);
    L45:
        o6a.a r4 = this.P1;
        if (r4 == null) goto L48;
        super.bringChildToFront(r4.a);
    L48:
        m6a.f r5 = this.L1;
        if (r5 != null) goto L51;
    L53:
        m6a.e r6 = this.M1;
        if (r6 != null) goto L56;
        return;
    L56:
        if (r6.getSpinnerStyle().b == false) goto L64;
        super.bringChildToFront(this.M1.getView());
        return;
    L64:
        return;
    L51:
        if (r5.getSpinnerStyle().b == false) goto L53;
        super.bringChildToFront(this.L1.getView());
        goto L53
    L5:
        if (this.L1 != null) goto L8;
        s(new BezierRadarHeader(getContext()));
    L8:
        if (this.M1 != null) goto L11;
        boolean r7 = this.B;
        r(new BallPulseFooter(getContext()));
        this.B = r7;
    L18:
        if (this.P1 != null) goto L32;
        int r8 = getChildCount();
        int r9 = 0;
    L20:
        if (r9 >= r8) goto L32;
        View r10 = getChildAt(r9);
        m6a.f r11 = this.L1;
        if (r11 != null) goto L24;
    L25:
        m6a.e r12 = this.M1;
        if (r12 != null) goto L28;
    L29:
        this.P1 = new o6a.a(r10);
    L30:
        r9 = r9 + 1;
        goto L20
    L28:
        if (r10 == r12.getView()) goto L30;
    L24:
        if (r10 == r11.getView()) goto L30;
    L32:
        if (this.P1 != null) goto L34;
        int r13 = r6a.b.c(20.0f);
        View r14 = new View(getContext());
        super.addView(r14, 0, new LayoutParams(-1));
        o6a.a r15 = new o6a.a(r14);
        this.P1 = r15;
        r15.a.setPadding(r13, r13, r13, r13);
    L34:
        View r16 = findViewById(this.p);
        View r17 = findViewById(this.q);
        this.P1.f();
        o6a.a r18 = this.P1;
        r18.i.c = this.O;
        r18.g(this.T1, r16, r17);
        if (this.b == 0) goto L37;
        n(RefreshState.None);
        o6a.a r19 = this.P1;
        this.b = 0;
        r19.d(0, this.r, this.s);
        goto L37
    L11:
        if (this.B == false) goto L13;
    L16:
        this.B = r0;
        goto L18
    L13:
        if (this.U == false) goto L16;
        r0 = false;
        goto L16
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.y2 = false;
        this.T1.b(0, true);
        n(RefreshState.None);
        Handler r1 = this.S1;
        if (r1 == null) goto L5;
        r1.removeCallbacksAndMessages(null);
    L5:
        this.U = true;
        this.H2 = null;
        ValueAnimator r2 = this.I2;
        if (r2 == null) goto L8;
        r2.removeAllListeners();
        this.I2.removeAllUpdateListeners();
        this.I2.cancel();
        this.I2 = null;
    L8:
        this.E2 = false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        int r0 = super.getChildCount();
        if (r0 > 3) goto L65;
        int r4 = 0;
        int r5 = -1;
        char r6 = 0;
    L5:
        int r7 = 2;
        if (r4 >= r0) goto L20;
        View r9 = super.getChildAt(r4);
        if (r6a.b.d(r9) == false) goto L13;
        if (r6 < 2) goto L11;
        if (r4 != 1) goto L13;
    L11:
        r5 = r4;
        r6 = 2;
    L19:
        r4 = r4 + 1;
    L13:
        if ((r9 instanceof m6a.g) == true) goto L19;
        if (r6 >= 1) goto L19;
        if (r4 <= 0) goto L17;
        r6 = 1;
    L18:
        r5 = r4;
        goto L19
    L17:
        r6 = 0;
        goto L18
    L20:
        if (r5 < 0) goto L28;
        this.P1 = new o6a.a(super.getChildAt(r5));
        if (r5 != 1) goto L26;
        if (r0 != 3) goto L25;
        int r1 = 0;
    L30:
        int r8 = 0;
    L31:
        if (r8 >= r0) goto L63;
        View r10 = super.getChildAt(r8);
        if (r8 == r1) goto L58;
        if (r8 == r7) goto L41;
        if (r1 != (-1)) goto L41;
        if (this.L1 != null) goto L41;
        if ((r10 instanceof m6a.f) == true) goto L58;
    L41:
        if (r8 == r7) goto L46;
        if (r7 != (-1)) goto L62;
        if ((r10 instanceof m6a.e) == true) goto L46;
    L62:
        r8 = r8 + 1;
    L46:
        if (this.B == false) goto L48;
    L51:
        boolean r11 = true;
    L52:
        this.B = r11;
        if ((r10 instanceof m6a.e) == false) goto L55;
        m6a.e r12 = (m6a.e) r10;
    L56:
        this.M1 = r12;
        goto L62
    L55:
        r12 = new o6a.b(r10);
        goto L56
    L48:
        if (this.U == false) goto L51;
        r11 = false;
    L58:
        if ((r10 instanceof m6a.f) == false) goto L60;
        m6a.f r13 = (m6a.f) r10;
    L61:
        this.L1 = r13;
        goto L62
    L60:
        r13 = new o6a.c(r10);
        goto L61
    L63:
        return;
    L25:
        r1 = 0;
    L29:
        r7 = -1;
        goto L30
    L26:
        if (r0 != 2) goto L28;
        r1 = -1;
        r7 = 1;
    L28:
        r1 = -1;
        goto L29
    L65:
        throw new RuntimeException("Most only support three sub view");
    }

    public RefreshState getState() {
        return this.V1;
    }

    public SmartRefreshLayout(Context r2) {
        this(r2, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r23) {
        int r6 = r23.getActionMasked();
        int r10 = 0;
        int r11 = 1;
        if (r6 != 6) goto L5;
        boolean r3 = true;
    L6:
        if (r3 == false) goto L8;
        int r4 = r23.getActionIndex();
    L9:
        int r5 = r23.getPointerCount();
        int r8 = 0;
        float r9 = 0.0f;
        float r12 = 0.0f;
    L10:
        if (r8 >= r5) goto L15;
        if (r4 == r8) goto L14;
        r9 = r9 + r23.getX(r8);
        r12 = r12 + r23.getY(r8);
    L14:
        r8 = r8 + 1;
        goto L10
    L15:
        if (r3 == false) goto L17;
        r5 = r5 - 1;
    L17:
        float r7 = r5;
        float r13 = r9 / r7;
        float r14 = r12 / r7;
        if (r6 == 6) goto L21;
        if (r6 == 5) goto L21;
    L23:
        this.j = r13;
        this.k = r14;
        if (this.H0 == false) goto L53;
        int r2 = this.p0;
        boolean r1 = super.dispatchTouchEvent(r23);
        if (r6 == 2) goto L28;
    L51:
        return r1;
    L28:
        if (r2 != this.p0) goto L51;
        int r15 = (int) this.j;
        int r16 = getWidth();
        float r17 = this.j;
        if (r16 == 0) goto L33;
        r11 = r16;
    L33:
        float r18 = r17 / r11;
        if (k(this.A) == false) goto L43;
        if (this.b <= 0) goto L43;
        m6a.f r19 = this.L1;
        if (r19 == null) goto L43;
        if (r19.a() == false) goto L43;
        this.L1.d(r18, r15, r16);
    L43:
        if (k(this.B) == false) goto L51;
        if (this.b >= 0) goto L51;
        m6a.e r20 = this.M1;
        if (r20 == null) goto L51;
        if (r20.a() == false) goto L51;
        this.M1.d(r18, r15, r16);
        goto L51
    L53:
        if (isEnabled() == false) goto L244;
        if (this.A == true) goto L61;
        if (this.B == true) goto L61;
        if (this.J == false) goto L244;
    L61:
        if (this.v2 == false) goto L69;
        RefreshState r21 = this.V1;
        if (r21.isOpening == true) goto L67;
        if (r21.isFinishing == false) goto L69;
    L67:
        if (r21.isHeader == true) goto L244;
    L69:
        if (this.x2 == false) goto L78;
        RefreshState r22 = this.V1;
        if (r22.isOpening == true) goto L75;
        if (r22.isFinishing == false) goto L78;
    L75:
        if (r22.isFooter == true) goto L244;
    L78:
        if (j(r6) == true) goto L242;
        RefreshState r24 = this.V1;
        if (r24.isFinishing == true) goto L242;
        RefreshState r110 = RefreshState.Loading;
        if (r24 != r110) goto L86;
        if (this.R == true) goto L242;
    L86:
        if (r24 != RefreshState.Refreshing) goto L91;
        if (this.Q == true) goto L242;
    L91:
        if (r6 != 0) goto L93;
        this.v = 0;
        this.x.addMovement(r23);
        this.w.forceFinished(true);
        this.h = r13;
        this.i = r14;
        this.c = 0;
        this.d = this.b;
        this.n = false;
        this.o = super.dispatchTouchEvent(r23);
        if (this.V1 == RefreshState.TwoLevel) goto L235;
    L238:
        o6a.a r25 = this.P1;
        if (r25 == null) goto L241;
        r25.a(r23);
    L241:
        return true;
    L235:
        if (this.i >= ((getMeasuredHeight() * 5) / 6)) goto L238;
        this.m = 'h';
        return this.o;
    L93:
        if (r6 != 1) goto L95;
        this.x.addMovement(r23);
        this.x.computeCurrentVelocity(1000, this.u);
        this.v = (int) this.x.getYVelocity();
        t(0.0f);
    L223:
        this.x.clear();
        this.m = 'n';
        MotionEvent r26 = this.G2;
        if (r26 == null) goto L226;
        r26.recycle();
        this.G2 = null;
        long r27 = r23.getEventTime();
        MotionEvent r28 = MotionEvent.obtain(r27, r27, r6, this.h, r14, 0);
        super.dispatchTouchEvent(r28);
        r28.recycle();
    L226:
        o();
        if (this.n == false) goto L231;
        this.n = false;
        return true;
    L231:
        return super.dispatchTouchEvent(r23);
    L95:
        if (r6 == 2) goto L98;
        if (r6 == 3) goto L223;
    L98:
        float r29 = r13 - this.h;
        float r30 = r14 - this.i;
        this.x.addMovement(r23);
        if (this.n == true) goto L161;
        char r31 = this.m;
        if (r31 == 'h') goto L161;
        if (this.P1 == null) goto L161;
        if (r31 != 'v') goto L107;
    L118:
        this.m = 'v';
        if (r30 <= 0.0f) goto L130;
        if (this.b >= 0) goto L123;
    L128:
        this.n = true;
        this.i = r14 - this.a;
    L145:
        if (this.n == false) goto L161;
        r30 = r14 - this.i;
        if (this.o == false) goto L149;
        r23.setAction(3);
        super.dispatchTouchEvent(r23);
    L149:
        i r32 = this.T1;
        int r33 = this.b;
        if (r33 > 0) goto L156;
        if (r33 == 0) goto L153;
    L155:
        RefreshState r34 = RefreshState.PullUpToLoad;
    L157:
        r32.d(r34);
        ViewParent r35 = getParent();
        if ((r35 instanceof ViewGroup) == false) goto L161;
        ((ViewGroup) r35).requestDisallowInterceptTouchEvent(true);
        goto L161
    L153:
        if (r30 <= 0.0f) goto L155;
    L156:
        r34 = RefreshState.PullDownToRefresh;
        goto L157
    L123:
        if (this.J == true) goto L127;
        if (this.A == false) goto L130;
    L127:
        if (this.P1.b() == true) goto L128;
    L130:
        if (r30 >= 0.0f) goto L145;
        if (this.b <= 0) goto L134;
    L143:
        this.n = true;
        this.i = this.a + r14;
        goto L145
    L134:
        if (this.J == true) goto L138;
        if (this.B == false) goto L145;
    L138:
        if (this.V1 != r110) goto L142;
        if (this.E2 == true) goto L143;
    L142:
        if (this.P1.canLoadMore() == false) goto L145;
    L107:
        if (Math.abs(r30) < this.a) goto L112;
        if (Math.abs(r29) < Math.abs(r30)) goto L118;
    L112:
        if (Math.abs(r29) < this.a) goto L161;
        if (Math.abs(r29) <= Math.abs(r30)) goto L161;
        if (this.m == 'v') goto L161;
        this.m = 'h';
    L161:
        if (this.n == false) goto L216;
        int r36 = ((int) r30) + this.d;
        RefreshState r37 = this.b2;
        if (r37.isHeader == false) goto L168;
        if (r36 >= 0) goto L166;
    L172:
        this.c = r36;
        long r210 = r23.getEventTime();
        if (this.G2 != null) goto L175;
        MotionEvent r38 = MotionEvent.obtain(r210, r210, 0, this.h + r29, this.i, 0);
        this.G2 = r38;
        super.dispatchTouchEvent(r38);
    L175:
        MotionEvent r39 = MotionEvent.obtain(r210, r210, 2, this.h + r29, this.i + r36, 0);
        super.dispatchTouchEvent(r39);
        if (this.E2 == true) goto L178;
    L182:
        if (r36 > 0) goto L184;
    L190:
        if (r36 < 0) goto L192;
    L198:
        r10 = r36;
    L199:
        RefreshState r40 = this.b2;
        if (r40.isHeader == false) goto L203;
        if (r10 >= 0) goto L203;
    L206:
        if (this.b == 0) goto L208;
        m(0.0f);
    L208:
        return true;
    L203:
        if (r40.isFooter == false) goto L210;
        if (r10 > 0) goto L206;
    L210:
        if (this.G2 == null) goto L212;
        this.G2 = null;
        r39.setAction(3);
        super.dispatchTouchEvent(r39);
    L212:
        r39.recycle();
        r36 = r10;
    L213:
        m(r36);
        return true;
    L192:
        if (this.J == true) goto L196;
        if (this.B == false) goto L198;
    L196:
        if (this.P1.canLoadMore() == false) goto L198;
        this.k = r14;
        this.i = r14;
        this.d = 0;
        this.T1.d(RefreshState.PullUpToLoad);
        goto L199
    L184:
        if (this.J == true) goto L188;
        if (this.A == false) goto L190;
    L188:
        if (this.P1.b() == false) goto L190;
        this.k = r14;
        this.i = r14;
        this.d = 0;
        this.T1.d(RefreshState.PullDownToRefresh);
        goto L199
    L178:
        if (r30 <= this.a) goto L182;
        if (this.b >= 0) goto L182;
        this.E2 = false;
        goto L182
    L166:
        if (this.c < 0) goto L172;
    L168:
        if (r37.isFooter == false) goto L213;
        if (r36 > 0) goto L172;
        if (this.c <= 0) goto L213;
    L216:
        if (this.E2 == false) goto L231;
        if (r30 <= this.a) goto L231;
        if (this.b >= 0) goto L231;
        this.E2 = false;
    L242:
        return false;
    L244:
        return super.dispatchTouchEvent(r23);
    L21:
        if (this.n == false) goto L23;
        this.i += r14 - this.k;
        goto L23
    L8:
        r4 = -1;
        goto L9
    L5:
        r3 = false;
        goto L6
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet r3) {
        return new LayoutParams(getContext(), r3);
    }

    public final boolean j(int r4) {
        if (r4 != 0) goto L21;
        if (this.I2 == null) goto L19;
        RefreshState r5 = this.V1;
        if (r5.isFinishing == false) goto L9;
    L18:
        return true;
    L9:
        if (r5 == RefreshState.TwoLevelReleased) goto L18;
        if (r5 != RefreshState.PullDownCanceled) goto L15;
        this.T1.d(RefreshState.PullDownToRefresh);
    L17:
        this.I2.cancel();
        this.I2 = null;
        goto L19
    L15:
        if (r5 != RefreshState.PullUpCanceled) goto L17;
        this.T1.d(RefreshState.PullUpToLoad);
    L19:
        this.H2 = null;
    L21:
        if (this.I2 != null) goto L25;
        return false;
    L25:
        return true;
    }

    public final boolean k(boolean r1) {
        if (r1 == true) goto L4;
    L6:
        return false;
    L4:
        if (this.L == true) goto L6;
        return true;
    }

    public final void m(float r19) {
        if (this.H0 == true) goto L5;
    L11:
        float r1 = r19;
    L12:
        RefreshState r3 = this.V1;
        if (r3 != RefreshState.TwoLevel) goto L18;
        if (r1 <= 0.0f) goto L18;
        this.T1.b(Math.min((int) r1, getMeasuredHeight()), true);
    L64:
        if (this.K == true) goto L66;
        return;
    L66:
        if (this.S == false) goto L68;
        return;
    L68:
        if (k(this.B) == true) goto L70;
        return;
    L70:
        if (r1 >= 0.0f) goto L85;
        RefreshState r2 = this.V1;
        if (r2 != RefreshState.Refreshing) goto L74;
        return;
    L74:
        if (r2 != RefreshState.Loading) goto L76;
        return;
    L76:
        if (r2 != RefreshState.LoadFinish) goto L78;
        return;
    L78:
        if (this.R == false) goto L80;
        this.H2 = null;
        this.T1.a(-this.h1);
    L80:
        setStateDirectLoading(false);
        this.S1.postDelayed(new f(this), this.f);
        return;
    L85:
        return;
    L18:
        if (r3 != RefreshState.Refreshing) goto L29;
        if (r1 < 0.0f) goto L29;
        float r4 = this.b1;
        if (r1 >= r4) goto L24;
        this.T1.b((int) r1, true);
        goto L64
    L24:
        double r5 = (this.x1 - 1.0f) * r4;
        int r8 = Math.max((this.g * 4) / 3, getHeight());
        int r13 = this.b1;
        double r14 = r8 - r13;
        double r6 = Math.max(0.0f, (r1 - r13) * this.l);
        double r7 = -r6;
        if (r14 != 0.0d) goto L27;
        r14 = 1.0d;
    L27:
        this.T1.b(((int) Math.min(r5 * (1.0d - Math.pow(100.0d, r7 / r14)), r6)) + this.b1, true);
    L29:
        if (r1 >= 0.0f) goto L54;
        if (r3 != RefreshState.Loading) goto L33;
    L46:
        int r9 = this.h1;
        if (r1 <= (-r9)) goto L49;
        this.T1.b((int) r1, true);
        goto L64
    L49:
        double r10 = (this.y1 - 1.0f) * r9;
        int r11 = Math.max((this.g * 4) / 3, getHeight());
        int r12 = this.h1;
        double r15 = r11 - r12;
        double r16 = -Math.min(0.0f, (r12 + r1) * this.l);
        double r17 = -r16;
        if (r15 != 0.0d) goto L52;
        r15 = 1.0d;
    L52:
        this.T1.b(((int) (-Math.min(r10 * (1.0d - Math.pow(100.0d, r17 / r15)), r16))) - this.h1, true);
        goto L64
    L33:
        if (this.G == false) goto L41;
        if (this.S == false) goto L41;
        if (this.T == false) goto L41;
        if (k(this.B) == true) goto L46;
    L41:
        if (this.K == false) goto L54;
        if (this.S == true) goto L54;
        if (k(this.B) == true) goto L46;
    L54:
        if (r1 < 0.0f) goto L59;
        double r18 = this.x1 * this.b1;
        double r20 = Math.max(this.g / 2, getHeight());
        double r21 = Math.max(0.0f, this.l * r1);
        double r110 = -r21;
        if (r20 != 0.0d) goto L58;
        r20 = 1.0d;
    L58:
        this.T1.b((int) Math.min(r18 * (1.0d - Math.pow(100.0d, r110 / r20)), r21), true);
        goto L64
    L59:
        double r22 = this.y1 * this.h1;
        double r23 = Math.max(this.g / 2, getHeight());
        double r24 = -Math.min(0.0f, this.l * r1);
        double r111 = -r24;
        if (r23 != 0.0d) goto L62;
        r23 = 1.0d;
    L62:
        this.T1.b((int) (-Math.min(r22 * (1.0d - Math.pow(100.0d, r111 / r23)), r24)), true);
        goto L64
    L5:
        if (this.O == true) goto L11;
        if (r19 >= 0.0f) goto L11;
        if (this.P1.canLoadMore() == true) goto L11;
        r1 = 0.0f;
        goto L12
    }

    public final void n(RefreshState r5) {
        RefreshState r0 = this.V1;
        if (r0 == r5) goto L15;
        this.V1 = r5;
        this.b2 = r5;
        m6a.f r1 = this.L1;
        m6a.e r2 = this.M1;
        q6a.c r3 = this.k0;
        if (r1 == null) goto L7;
        r1.i(this, r0, r5);
    L7:
        if (r2 == null) goto L9;
        r2.i(this, r0, r5);
    L9:
        if (r3 == null) goto L12;
        r3.i(this, r0, r5);
    L12:
        if (r5 != RefreshState.LoadFinish) goto L18;
        this.E2 = false;
        return;
    L18:
        return;
    L15:
        if (this.b2 == r0) goto L20;
        this.b2 = r0;
        return;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onStopNestedScroll(View r2) {
        this.V0.onStopNestedScroll(r2);
        this.H0 = false;
        this.p0 = 0;
        o();
        this.P0.stopNestedScroll();
    }

    public final void p(boolean r8) {
        RefreshState r0 = this.V1;
        if (r0 != RefreshState.Refreshing) goto L7;
        if (r8 == false) goto L7;
        i(Math.min(Math.max(0, 300 - ((int) (System.currentTimeMillis() - this.g2))), 300) << 16, true, Boolean.TRUE);
        return;
    L7:
        if (r0 != RefreshState.Loading) goto L11;
        if (r8 == false) goto L11;
        h(Math.min(Math.max(0, 300 - ((int) (System.currentTimeMillis() - this.g2))), 300) << 16, true);
        return;
    L11:
        if (this.S == r8) goto L33;
        this.S = r8;
        m6a.e r1 = this.M1;
        if ((r1 instanceof m6a.e) == true) goto L15;
        return;
    L15:
        if (r1.c(r8) == false) goto L29;
        this.T = true;
        if (this.S == true) goto L19;
        return;
    L19:
        if (this.G == true) goto L21;
        return;
    L21:
        if (this.b > 0) goto L23;
        return;
    L23:
        if (this.M1.getSpinnerStyle() == n6a.b.d) goto L25;
        return;
    L25:
        if (k(this.B) == true) goto L27;
        return;
    L27:
        if (l(this.A, this.L1) == false) goto L40;
        this.M1.getView().setTranslationY(this.b);
        return;
    L40:
        return;
    L29:
        this.T = false;
        new RuntimeException("Footer:" + this.M1 + " NoMoreData is not supported").printStackTrace();
        return;
    }

    public m6a.i q(View r5) {
        o6a.a r0 = this.P1;
        if (r0 == null) goto L5;
        super.removeView(r0.a);
    L5:
        this.P1 = new o6a.a(r5);
        super.addView(r5, getChildCount(), new LayoutParams(-1));
        if (this.y2 == false) goto L8;
        View r6 = findViewById(this.p);
        View r1 = findViewById(this.q);
        this.P1.f();
        o6a.a r2 = this.P1;
        r2.i.c = this.O;
        r2.g(this.T1, r6, r1);
    L8:
        m6a.f r7 = this.L1;
        if (r7 != null) goto L11;
    L13:
        m6a.e r8 = this.M1;
        if (r8 != null) goto L16;
    L18:
        return this;
    L16:
        if (r8.getSpinnerStyle().b == false) goto L18;
        super.bringChildToFront(this.M1.getView());
        goto L18
    L11:
        if (r7.getSpinnerStyle().b == false) goto L13;
        super.bringChildToFront(this.L1.getView());
        goto L13
    }

    public final void r(m6a.e r4) {
        m6a.e r0 = this.M1;
        if (r0 == null) goto L5;
        super.removeView(r0.getView());
    L5:
        this.M1 = r4;
        this.E2 = false;
        this.p2 = 0;
        this.T = false;
        this.x2 = false;
        this.k1 = this.k1.b();
        if (this.U == true) goto L8;
    L11:
        boolean r1 = true;
    L12:
        this.B = r1;
        if (this.M1.getSpinnerStyle().b == false) goto L15;
        super.addView(this.M1.getView(), getChildCount(), new LayoutParams(-2));
    L16:
        int[] r5 = this.z;
        if (r5 == null) goto L22;
        m6a.e r2 = this.M1;
        if (r2 == null) goto L23;
        r2.setPrimaryColors(r5);
        return;
    L23:
        return;
    L22:
        return;
    L15:
        super.addView(this.M1.getView(), 0, new LayoutParams(-2));
        goto L16
    L8:
        if (this.B == true) goto L11;
        r1 = false;
        goto L12
    }

    public final void s(m6a.f r4) {
        m6a.f r0 = this.L1;
        if (r0 == null) goto L5;
        super.removeView(r0.getView());
    L5:
        this.L1 = r4;
        this.h2 = 0;
        this.v2 = false;
        this.g1 = this.g1.b();
        if (this.L1.getSpinnerStyle().b == false) goto L8;
        super.addView(this.L1.getView(), getChildCount(), new LayoutParams(-2));
    L9:
        int[] r5 = this.z;
        if (r5 == null) goto L15;
        m6a.f r1 = this.L1;
        if (r1 == null) goto L16;
        r1.setPrimaryColors(r5);
        return;
    L16:
        return;
    L15:
        return;
    L8:
        super.addView(this.L1.getView(), 0, new LayoutParams(-2));
        goto L9
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean r2) {
        this.P = r2;
        this.P0.setNestedScrollingEnabled(r2);
    }

    public void setStateDirectLoading(boolean r5) {
        RefreshState r0 = this.V1;
        RefreshState r1 = RefreshState.Loading;
        if (r0 == r1) goto L22;
        this.g2 = System.currentTimeMillis();
        this.E2 = true;
        n(r1);
        q6a.b r2 = this.W;
        if (r2 == null) goto L9;
        if (r5 == false) goto L11;
        r2.g(this);
    L11:
        m6a.e r3 = this.M1;
        if (r3 == null) goto L14;
        int r4 = this.h1;
        r3.n(this, r4, (int) (this.y1 * r4));
    L14:
        q6a.c r6 = this.k0;
        if (r6 != null) goto L17;
        return;
    L17:
        if ((this.M1 instanceof m6a.e) == false) goto L24;
        if (r5 == false) goto L20;
        r6.g(this);
    L20:
        this.k0.s();
        return;
    L24:
        return;
    L9:
        if (this.k0 != null) goto L11;
        h(2000, false);
        goto L11
    }

    public void setStateLoading(boolean r6) {
        b r0 = new b(this, r6);
        n(RefreshState.LoadReleased);
        ValueAnimator r7 = this.T1.a(-this.h1);
        if (r7 == null) goto L5;
        r7.addListener(r0);
    L5:
        m6a.e r1 = this.M1;
        if (r1 == null) goto L8;
        int r2 = this.h1;
        r1.k(this, r2, (int) (this.y1 * r2));
    L8:
        q6a.c r3 = this.k0;
        if (r3 != null) goto L11;
    L13:
        if (r7 != null) goto L16;
        r0.onAnimationEnd(null);
        return;
    L16:
        return;
    L11:
        if ((this.M1 instanceof m6a.e) == false) goto L13;
        r3.w();
        goto L13
    }

    public void setStateRefreshing(boolean r6) {
        c r0 = new c(this, r6);
        n(RefreshState.RefreshReleased);
        ValueAnimator r7 = this.T1.a(this.b1);
        if (r7 == null) goto L5;
        r7.addListener(r0);
    L5:
        m6a.f r1 = this.L1;
        if (r1 == null) goto L8;
        int r2 = this.b1;
        r1.k(this, r2, (int) (this.x1 * r2));
    L8:
        q6a.c r3 = this.k0;
        if (r3 != null) goto L11;
    L13:
        if (r7 != null) goto L16;
        r0.onAnimationEnd(null);
        return;
    L16:
        return;
    L11:
        if ((this.L1 instanceof m6a.f) == false) goto L13;
        r3.p();
        goto L13
    }

    public void setViceState(RefreshState r3) {
        RefreshState r0 = this.V1;
        if (r0.isDragging == false) goto L8;
        if (r0.isHeader == r3.isHeader) goto L8;
        n(RefreshState.None);
    L8:
        if (this.b2 == r3) goto L11;
        this.b2 = r3;
        return;
    }

    public boolean t(float r14) {
        if (r14 != 0.0f) goto L6;
        r14 = this.v;
    L6:
        if (Build.VERSION.SDK_INT > 27) goto L8;
    L14:
        int r3 = 0;
        if (Math.abs(r14) <= this.t) goto L107;
        int r1 = this.b;
        if ((r1 * r14) >= 0.0f) goto L80;
        RefreshState r2 = this.V1;
        RefreshState r4 = RefreshState.Refreshing;
        if (r2 != r4) goto L21;
    L29:
        h r0 = new h(this, r14);
        RefreshState r15 = this.V1;
        if (r15.isFinishing == false) goto L33;
    L74:
        r0 = null;
    L77:
        this.H2 = r0;
        return true;
    L33:
        if (this.b != 0) goto L35;
    L76:
        r0.c = AnimationUtils.currentAnimationTimeMillis();
        r0.e.S1.postDelayed(r0, 10);
        goto L77
    L35:
        if (r15.isOpening == true) goto L45;
        if (this.S == true) goto L39;
    L60:
        int r16 = this.b;
        float r5 = r0.b;
        int r6 = r16;
    L62:
        if ((r16 * r6) <= 0) goto L76;
        r3 = r3 + 1;
        r5 = (float) (((double) r5) * Math.pow(0.98f, (r3 * 10) / 10.0f));
        float r7 = ((10 * 1.0f) / 1000.0f) * r5;
        if (Math.abs(r7) < 1.0f) goto L65;
        r6 = (int) (r6 + r7);
        goto L62
    L65:
        SmartRefreshLayout r17 = r0.e;
        RefreshState r8 = r17.V1;
        if (r8.isOpening == false) goto L74;
        RefreshState r9 = RefreshState.Refreshing;
        if (r8 == r9) goto L70;
    L71:
        if (r8 == r9) goto L76;
        if (r6 >= (-r17.h1)) goto L76;
    L70:
        if (r6 > r17.b1) goto L74;
    L39:
        if (this.G == false) goto L60;
        if (this.T == false) goto L60;
        if (k(this.B) == false) goto L60;
    L45:
        if (this.V1 == RefreshState.Loading) goto L55;
        if (this.S == false) goto L57;
        if (this.G == false) goto L57;
        if (this.T == false) goto L57;
        if (k(this.B) == true) goto L55;
    L57:
        if (this.V1 != r4) goto L76;
        if (this.b <= this.b1) goto L76;
    L55:
        if (this.b < (-this.h1)) goto L60;
    L21:
        if (r2 == RefreshState.Loading) goto L29;
        if (r1 >= 0) goto L27;
        if (this.S == true) goto L29;
    L27:
        if (r2.isReleaseToOpening == false) goto L80;
        return true;
    L80:
        if (r14 >= 0.0f) goto L95;
        if (this.I == false) goto L88;
        if (this.B == false) goto L86;
    L106:
        this.F2 = false;
        this.w.fling(0, 0, 0, (int) (-r14), 0, 0, -2147483647, Integer.MAX_VALUE);
        this.w.computeScrollOffset();
        invalidate();
        goto L107
    L86:
        if (this.J == true) goto L106;
    L88:
        if (this.V1 != RefreshState.Loading) goto L91;
        if (r1 >= 0) goto L106;
    L91:
        if (this.K == false) goto L95;
        if (k(this.B) == true) goto L106;
    L95:
        if (r14 <= 0.0f) goto L107;
        if (this.I == false) goto L101;
        if (this.A == true) goto L106;
    L101:
        if (this.J == true) goto L106;
        if (this.V1 != RefreshState.Refreshing) goto L107;
        if (this.b <= 0) goto L106;
    L107:
        return false;
    L8:
        if (this.P1 == null) goto L14;
        getScaleY();
        View r10 = this.P1.a;
        if (getScaleY() != (-1.0f)) goto L14;
        if (r10.getScaleY() != (-1.0f)) goto L14;
        r14 = -r14;
        goto L14
    }

    public SmartRefreshLayout(Context r13, AttributeSet r14) {
        super(r13, r14);
        this.e = 300;
        this.f = 300;
        this.l = 0.5f;
        this.m = 'n';
        this.p = -1;
        this.q = -1;
        this.r = -1;
        this.s = -1;
        this.A = true;
        this.B = false;
        this.C = true;
        this.D = true;
        this.E = true;
        this.F = true;
        this.G = false;
        this.H = true;
        this.I = true;
        this.J = false;
        this.K = true;
        this.L = false;
        this.M = true;
        this.N = true;
        this.O = true;
        this.P = true;
        this.Q = false;
        this.R = false;
        this.S = false;
        this.T = false;
        this.U = false;
        this.L0 = new int[2];
        NestedScrollingChildHelper r6 = new NestedScrollingChildHelper(this);
        this.P0 = r6;
        this.V0 = new NestedScrollingParentHelper(this);
        n6a.a r7 = n6a.a.c;
        this.g1 = r7;
        this.k1 = r7;
        this.x1 = 2.5f;
        this.y1 = 2.5f;
        this.G1 = 1.0f;
        this.H1 = 1.0f;
        this.T1 = new i(this);
        RefreshState r9 = RefreshState.None;
        this.V1 = r9;
        this.b2 = r9;
        this.g2 = 0;
        this.h2 = 0;
        this.p2 = 0;
        this.E2 = false;
        this.F2 = false;
        this.G2 = null;
        ViewConfiguration r10 = ViewConfiguration.get(r13);
        this.S1 = new Handler(Looper.getMainLooper());
        this.w = new Scroller(r13);
        this.x = VelocityTracker.obtain();
        Resources r11 = r13.getResources();
        this.g = WindowDisplayMetricsOverride.apply(r11, r11.getDisplayMetrics()).heightPixels;
        this.y = new r6a.b(0);
        this.a = r10.getScaledTouchSlop();
        this.t = r10.getScaledMinimumFlingVelocity();
        this.u = r10.getScaledMaximumFlingVelocity();
        this.h1 = r6a.b.c(60.0f);
        this.b1 = r6a.b.c(100.0f);
        TypedArray r15 = r13.obtainStyledAttributes(r14, new int[]{R.attr.clipChildren, R.attr.clipToPadding, 2130974146, 2130974149, 2130974150, 2130974151, 2130974158, 2130974159, 2130974160, 2130974161, 2130974162, 2130974163, 2130974164, 2130974167, 2130974168, 2130974169, 2130974170, 2130974171, 2130974172, 2130974174, 2130974175, 2130974176, 2130974177, 2130974180, 2130974181, 2130974184, 2130974185, 2130974186, 2130974187, 2130974188, 2130974189, 2130974190, 2130974191, 2130974192, 2130974193, 2130974196, 2130974197});
        if (r15.hasValue(1) == true) goto L6;
        super.setClipToPadding(false);
    L6:
        if (r15.hasValue(0) == true) goto L8;
        super.setClipChildren(false);
    L8:
        this.l = r15.getFloat(5, 0.5f);
        this.x1 = r15.getFloat(32, this.x1);
        this.y1 = r15.getFloat(27, 2.5f);
        this.G1 = r15.getFloat(34, 1.0f);
        this.H1 = r15.getFloat(29, 1.0f);
        this.A = r15.getBoolean(20, this.A);
        this.f = r15.getInt(36, 300);
        this.B = r15.getBoolean(13, this.B);
        this.b1 = r15.getDimensionPixelOffset(30, this.b1);
        this.h1 = r15.getDimensionPixelOffset(25, this.h1);
        this.p1 = r15.getDimensionPixelOffset(31, this.p1);
        this.v1 = r15.getDimensionPixelOffset(26, this.v1);
        this.Q = r15.getBoolean(4, false);
        this.R = r15.getBoolean(3, false);
        this.E = r15.getBoolean(12, true);
        this.F = r15.getBoolean(11, true);
        this.H = r15.getBoolean(18, true);
        this.K = r15.getBoolean(6, this.K);
        this.I = r15.getBoolean(16, true);
        boolean r12 = r15.getBoolean(19, false);
        this.L = r12;
        this.M = r15.getBoolean(21, true);
        this.N = r15.getBoolean(22, true);
        this.O = r15.getBoolean(14, true);
        boolean r16 = r15.getBoolean(9, false);
        this.G = r16;
        this.G = r15.getBoolean(10, r16);
        this.C = r15.getBoolean(8, true);
        this.D = r15.getBoolean(7, true);
        this.J = r15.getBoolean(17, false);
        this.p = r15.getResourceId(24, -1);
        this.q = r15.getResourceId(23, -1);
        this.r = r15.getResourceId(33, -1);
        this.s = r15.getResourceId(28, -1);
        boolean r2 = r15.getBoolean(15, this.P);
        this.P = r2;
        r6.setNestedScrollingEnabled(r2);
        if (this.U == false) goto L11;
    L14:
        boolean r0 = true;
    L15:
        this.U = r0;
        r15.hasValue(12);
        r15.hasValue(11);
        if (r15.hasValue(30) == false) goto L18;
        n6a.a r17 = n6a.a.f;
    L19:
        this.g1 = r17;
        if (r15.hasValue(25) == false) goto L22;
        n6a.a r18 = n6a.a.f;
    L23:
        this.k1 = r18;
        int r19 = r15.getColor(2, 0);
        int r1 = r15.getColor(35, 0);
        if (r1 == 0) goto L28;
        if (r19 == 0) goto L27;
        this.z = new int[]{r1, r19};
    L30:
        if (r12 == true) goto L32;
    L36:
        r15.recycle();
        return;
    L32:
        if (this.U == true) goto L36;
        if (this.B == true) goto L36;
        this.B = true;
        goto L36
    L27:
        this.z = new int[]{r1};
        goto L30
    L28:
        if (r19 == 0) goto L30;
        this.z = new int[]{0, r19};
        goto L30
    L22:
        r18 = this.k1;
        goto L23
    L18:
        r17 = this.g1;
        goto L19
    L11:
        if (r15.hasValue(13) == true) goto L14;
        r0 = false;
        goto L15
    }

    public static /* synthetic */ void a(SmartRefreshLayout r0, MotionEvent r1) {
        super.dispatchTouchEvent(r1);
    }

    public static /* synthetic */ void b(SmartRefreshLayout r0, MotionEvent r1) {
        super.dispatchTouchEvent(r1);
    }

    public static /* synthetic */ void c(SmartRefreshLayout r0, MotionEvent r1) {
        super.dispatchTouchEvent(r1);
    }

    public static /* synthetic */ void d(SmartRefreshLayout r0, MotionEvent r1) {
        super.dispatchTouchEvent(r1);
    }

    public static /* synthetic */ void e(SmartRefreshLayout r0, MotionEvent r1) {
        super.dispatchTouchEvent(r1);
    }

    public static /* synthetic */ void f(SmartRefreshLayout r0, MotionEvent r1) {
        super.dispatchTouchEvent(r1);
    }

    @Override // android.view.ViewGroup
    public final void addView(View r1, int r2) {
        q(r1);
    }

    public final void h(int r5, boolean r6) {
        int r0 = r5 >> 16;
        int r7 = (r5 << 16) >> 16;
        l6a.b r1 = new l6a.b(this, r0, r6);
        if (r7 <= 0) goto L5;
        this.S1.postDelayed(r1, r7);
        return;
    L5:
        r1.run();
    }

    public final boolean l(boolean r1, m6a.g r2) {
        if (r1 == false) goto L4;
    L10:
        return true;
    L4:
        if (this.L == true) goto L10;
        if (r2 == null) goto L10;
        if (r2.getSpinnerStyle() == n6a.b.e) goto L10;
        return false;
    }

    @Override // android.view.View
    public void onMeasure(int r19, int r20) {
        if (isInEditMode() == true) goto L5;
    L7:
        boolean r3 = false;
    L8:
        int r6 = super.getChildCount();
        int r7 = 0;
        int r8 = 0;
    L9:
        if (r7 >= r6) goto L162;
        View r9 = super.getChildAt(r7);
        if (r9.getVisibility() == 8) goto L161;
        if (r9.getTag(2131914113) == r9) goto L161;
        m6a.f r10 = this.L1;
        if (r10 != null) goto L18;
    L69:
        m6a.e r4 = this.M1;
        if (r4 == null) goto L125;
        if (r4.getView() != r9) goto L125;
        View r5 = this.M1.getView();
        ViewGroup.LayoutParams r11 = r5.getLayoutParams();
        if ((r11 instanceof ViewGroup.MarginLayoutParams) == false) goto L76;
        ViewGroup.MarginLayoutParams r12 = (ViewGroup.MarginLayoutParams) r11;
    L77:
        int r13 = ViewGroup.getChildMeasureSpec(r19, r12.leftMargin + r12.rightMargin, r11.width);
        int r14 = this.h1;
        n6a.a r15 = this.k1;
        int r16 = r15.a;
        n6a.a r17 = n6a.a.c;
        if (r16 >= 6) goto L98;
        int r18 = r11.height;
        if (r18 <= 0) goto L85;
        r14 = r12.bottomMargin + (r18 + r12.topMargin);
        n6a.a r110 = n6a.a.e;
        if (r15.a(r110) == false) goto L98;
        this.h1 = (r11.height + r12.topMargin) + r12.bottomMargin;
        this.k1 = r110;
        goto L98
    L85:
        if (r18 != (-2)) goto L98;
        if (this.M1.getSpinnerStyle() == n6a.b.g) goto L89;
    L90:
        int r21 = Math.max((View.MeasureSpec.getSize(r20) - r12.bottomMargin) - r12.topMargin, 0);
        r5.measure(r13, View.MeasureSpec.makeMeasureSpec(r21, Integer.MIN_VALUE));
        int r111 = r5.getMeasuredHeight();
        if (r111 <= 0) goto L98;
        if (r111 == r21) goto L96;
        n6a.a r22 = this.k1;
        n6a.a r112 = n6a.a.d;
        if (r22.a(r112) == false) goto L96;
        this.h1 = (r111 + r12.topMargin) + r12.bottomMargin;
        this.k1 = r112;
    L96:
        r14 = -1;
        goto L98
    L89:
        if (this.k1.b == false) goto L90;
    L98:
        if (this.M1.getSpinnerStyle() != n6a.b.g) goto L102;
        int r23 = View.MeasureSpec.getSize(r20);
        int r113 = 0;
    L111:
        if (r23 == (-1)) goto L113;
        r5.measure(r13, View.MeasureSpec.makeMeasureSpec(Math.max((r23 - r12.bottomMargin) - r12.topMargin, r113), 1073741824));
    L113:
        n6a.a r24 = this.k1;
        boolean r114 = r24.b;
        if (r114 == true) goto L120;
        if (r114 == true) goto L118;
        r24 = n6a.a.h[r24.a + 1];
    L118:
        this.k1 = r24;
        m6a.e r25 = this.M1;
        i r115 = this.T1;
        int r116 = this.h1;
        r25.j(r115, r116, (int) (this.y1 * r116));
    L120:
        if (r3 == false) goto L125;
        if (k(this.B) == false) goto L125;
        r8 = r8 + r5.getMeasuredHeight();
        goto L125
    L102:
        if (this.M1.getSpinnerStyle().c == false) goto L109;
        if (r3 == true) goto L109;
        if (k(this.B) == false) goto L107;
        int r26 = -this.b;
    L108:
        r113 = 0;
        r14 = Math.max(0, r26);
    L110:
        r23 = r14;
        goto L111
    L107:
        r26 = 0;
    L109:
        r113 = 0;
        goto L110
    L76:
        r12 = J2;
    L125:
        o6a.a r27 = this.P1;
        if (r27 == null) goto L161;
        View r28 = r27.a;
        if (r28 != r9) goto L161;
        ViewGroup.LayoutParams r29 = r28.getLayoutParams();
        if ((r29 instanceof ViewGroup.MarginLayoutParams) == false) goto L132;
        ViewGroup.MarginLayoutParams r30 = (ViewGroup.MarginLayoutParams) r29;
    L134:
        if (this.L1 != null) goto L136;
    L140:
        boolean r117 = false;
    L142:
        if (this.M1 != null) goto L144;
    L148:
        boolean r118 = false;
    L149:
        int r119 = ViewGroup.getChildMeasureSpec(r19, ((getPaddingLeft() + getPaddingRight()) + r30.leftMargin) + r30.rightMargin, r29.width);
        int r120 = ((getPaddingTop() + getPaddingBottom()) + r30.topMargin) + r30.bottomMargin;
        if (r3 == false) goto L153;
        if (r117 == false) goto L153;
        int r31 = this.b1;
    L154:
        int r121 = r120 + r31;
        if (r3 == false) goto L158;
        if (r118 == false) goto L158;
        int r32 = this.h1;
    L159:
        r28.measure(r119, ViewGroup.getChildMeasureSpec(r20, r121 + r32, r29.height));
        r8 = r8 + r28.getMeasuredHeight();
    L158:
        r32 = 0;
    L153:
        r31 = 0;
        goto L154
    L144:
        if (k(this.B) == false) goto L148;
        if (l(this.F, this.M1) == false) goto L148;
        r118 = true;
        goto L149
    L136:
        if (k(this.A) == false) goto L140;
        if (l(this.E, this.L1) == false) goto L140;
        r117 = true;
        goto L142
    L132:
        r30 = J2;
        goto L134
    L18:
        if (r10.getView() != r9) goto L69;
        View r122 = this.L1.getView();
        ViewGroup.LayoutParams r33 = r122.getLayoutParams();
        if ((r33 instanceof ViewGroup.MarginLayoutParams) == false) goto L22;
        ViewGroup.MarginLayoutParams r123 = (ViewGroup.MarginLayoutParams) r33;
    L23:
        int r124 = ViewGroup.getChildMeasureSpec(r19, r123.leftMargin + r123.rightMargin, r33.width);
        int r125 = this.b1;
        n6a.a r34 = this.g1;
        int r126 = r34.a;
        n6a.a r127 = n6a.a.c;
        if (r126 >= 6) goto L43;
        int r128 = r33.height;
        if (r128 <= 0) goto L31;
        int r129 = (r128 + r123.bottomMargin) + r123.topMargin;
        n6a.a r130 = n6a.a.e;
        if (r34.a(r130) == false) goto L45;
        this.b1 = (r33.height + r123.bottomMargin) + r123.topMargin;
        this.g1 = r130;
    L45:
        if (this.L1.getSpinnerStyle() != n6a.b.g) goto L49;
        int r35 = View.MeasureSpec.getSize(r20);
        int r36 = 0;
    L58:
        if (r35 == (-1)) goto L60;
        r122.measure(r124, View.MeasureSpec.makeMeasureSpec(Math.max((r35 - r123.bottomMargin) - r123.topMargin, r36), 1073741824));
    L60:
        n6a.a r37 = this.g1;
        boolean r38 = r37.b;
        if (r38 == true) goto L65;
        if (r38 == true) goto L64;
        r37 = n6a.a.h[r37.a + 1];
    L64:
        this.g1 = r37;
        m6a.f r39 = this.L1;
        i r40 = this.T1;
        int r131 = this.b1;
        r39.j(r40, r131, (int) (this.x1 * r131));
    L65:
        if (r3 == false) goto L69;
        if (k(this.A) == false) goto L69;
        r8 = r8 + r122.getMeasuredHeight();
        goto L69
    L49:
        if (this.L1.getSpinnerStyle().c == false) goto L56;
        if (r3 == true) goto L56;
        if (k(this.A) == false) goto L54;
        int r41 = this.b;
    L55:
        r36 = 0;
        r129 = Math.max(0, r41);
    L57:
        r35 = r129;
        goto L58
    L54:
        r41 = 0;
    L56:
        r36 = 0;
        goto L57
    L31:
        if (r128 != (-2)) goto L43;
        if (this.L1.getSpinnerStyle() == n6a.b.g) goto L35;
    L36:
        int r42 = Math.max((View.MeasureSpec.getSize(r20) - r123.bottomMargin) - r123.topMargin, 0);
        r122.measure(r124, View.MeasureSpec.makeMeasureSpec(r42, Integer.MIN_VALUE));
        int r43 = r122.getMeasuredHeight();
        if (r43 <= 0) goto L43;
        if (r43 == r42) goto L42;
        n6a.a r44 = this.g1;
        n6a.a r132 = n6a.a.d;
        if (r44.a(r132) == false) goto L42;
        this.b1 = (r43 + r123.bottomMargin) + r123.topMargin;
        this.g1 = r132;
    L42:
        r129 = -1;
        goto L45
    L35:
        if (this.g1.b == false) goto L36;
    L43:
        r129 = r125;
        goto L45
    L22:
        r123 = J2;
    L161:
        r7 = r7 + 1;
        goto L9
    L162:
        super.setMeasuredDimension(View.resolveSize(super.getSuggestedMinimumWidth(), r19), View.resolveSize(r8, r20));
        this.j = getMeasuredWidth() / 2.0f;
        return;
    L5:
        if (this.H == false) goto L7;
        r3 = true;
        goto L8
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas r10, View r11, long r12) {
        o6a.a r0 = this.P1;
        if (r0 == null) goto L5;
        View r1 = r0.a;
    L6:
        m6a.f r2 = this.L1;
        if (r2 != null) goto L9;
    L36:
        m6a.e r3 = this.M1;
        if (r3 == null) goto L67;
        if (r3.getView() != r11) goto L67;
        if (k(this.B) == true) goto L43;
    L65:
        return true;
    L43:
        if (this.H == false) goto L45;
    L47:
        if (r1 == null) goto L67;
        int r4 = Math.min((r1.getBottom() - r1.getPaddingBottom()) + this.b, r11.getBottom());
        int r5 = this.p2;
        if (r5 == 0) goto L60;
        Paint r6 = this.Q1;
        if (r6 == null) goto L60;
        r6.setColor(r5);
        if (this.M1.getSpinnerStyle().c == false) goto L56;
        r4 = r11.getTop();
    L58:
        r10.drawRect(0.0f, r4, getWidth(), r11.getBottom(), this.Q1);
        goto L60
    L56:
        if (this.M1.getSpinnerStyle() != n6a.b.d) goto L58;
        r4 = r11.getTop() + this.b;
    L60:
        if (this.D == false) goto L67;
        if (this.M1.getSpinnerStyle() != n6a.b.e) goto L67;
        r10.save();
        r10.clipRect(r11.getLeft(), r4, r11.getRight(), r11.getBottom());
        boolean r13 = super.drawChild(r10, r11, r12);
        r10.restore();
        return r13;
    L45:
        if (isInEditMode() == false) goto L47;
    L67:
        return super.drawChild(r10, r11, r12);
    L9:
        if (r2.getView() != r11) goto L36;
        if (k(this.A) == true) goto L13;
    L35:
        return true;
    L13:
        if (this.H == false) goto L15;
    L17:
        if (r1 == null) goto L36;
        int r7 = Math.max((r1.getTop() + r1.getPaddingTop()) + this.b, r11.getTop());
        int r8 = this.h2;
        if (r8 == 0) goto L30;
        Paint r9 = this.Q1;
        if (r9 == null) goto L30;
        r9.setColor(r8);
        if (this.L1.getSpinnerStyle().c == false) goto L26;
        r7 = r11.getBottom();
    L28:
        r10.drawRect(0.0f, r11.getTop(), getWidth(), r7, this.Q1);
        goto L30
    L26:
        if (this.L1.getSpinnerStyle() != n6a.b.d) goto L28;
        r7 = r11.getBottom() + this.b;
    L30:
        if (this.C == false) goto L36;
        if (this.L1.getSpinnerStyle() != n6a.b.e) goto L36;
        r10.save();
        r10.clipRect(r11.getLeft(), r11.getTop(), r11.getRight(), r7);
        boolean r14 = super.drawChild(r10, r11, r12);
        r10.restore();
        return r14;
    L15:
        if (isInEditMode() == false) goto L17;
    L5:
        r1 = null;
        goto L6
    }

    public final void i(int r5, boolean r6, Boolean r7) {
        int r0 = r5 >> 16;
        int r8 = (r5 << 16) >> 16;
        l6a.a r1 = new l6a.a(this, r0, r7, r6);
        if (r8 <= 0) goto L5;
        this.S1.postDelayed(r1, r8);
        return;
    L5:
        r1.run();
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedPreFling(View r1, float r2, float r3) {
        if (this.E2 == false) goto L7;
        if (r3 <= 0.0f) goto L7;
    L12:
        return true;
    L7:
        if (t(-r3) == true) goto L12;
        if (this.P0.dispatchNestedPreFling(r2, r3) == true) goto L12;
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedScrollAccepted(View r2, View r3, int r4) {
        this.V0.onNestedScrollAccepted(r2, r3, r4);
        this.P0.startNestedScroll(r4 & 2);
        this.p0 = this.b;
        this.H0 = true;
        j(0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onStartNestedScroll(View r2, View r3, int r4) {
        if (isEnabled() == true) goto L5;
    L9:
        boolean r5 = false;
    L10:
        if (r5 == true) goto L12;
    L18:
        return false;
    L12:
        if (this.J == false) goto L14;
        return true;
    L14:
        if (this.A == false) goto L16;
        return true;
    L16:
        if (this.B == false) goto L18;
        return true;
    L5:
        if (isNestedScrollingEnabled() == false) goto L9;
        if ((r4 & 2) == 0) goto L9;
        r5 = true;
        goto L10
    }

    public final ValueAnimator g(int r4, int r5, Interpolator r6, int r7) {
        if (this.b == r4) goto L9;
        ValueAnimator r0 = this.I2;
        if (r0 == null) goto L7;
        r0.cancel();
    L7:
        this.H2 = null;
        ValueAnimator r8 = ValueAnimator.ofInt(new int[]{this.b, r4});
        this.I2 = r8;
        r8.setDuration(r7);
        this.I2.setInterpolator(r6);
        this.I2.addListener(new d(this));
        this.I2.addUpdateListener(new e(this));
        this.I2.setStartDelay(r5);
        this.I2.start();
        return this.I2;
    L9:
        return null;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedFling(View r1, float r2, float r3, boolean r4) {
        return this.P0.dispatchNestedFling(r2, r3, r4);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedPreScroll(View r3, int r4, int r5, int[] r6) {
        int r7 = this.p0;
        int r1 = 0;
        if ((r5 * r7) > 0) goto L5;
        if (r5 > 0) goto L11;
    L13:
        this.P0.dispatchNestedPreScroll(r4, r5 - r1, r6, null);
        r6[1] = r6[1] + r1;
        return;
    L11:
        if (this.E2 == false) goto L13;
        int r8 = r7 - r5;
        this.p0 = r8;
        m(r8);
        r1 = r5;
        goto L13
    L5:
        if (Math.abs(r5) <= Math.abs(this.p0)) goto L7;
        int r9 = this.p0;
        this.p0 = 0;
        r1 = r9;
    L8:
        m(this.p0);
        goto L13
    L7:
        this.p0 -= r5;
        r1 = r5;
        goto L8
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
        int r15 = getPaddingLeft();
        int r16 = getPaddingTop();
        getPaddingBottom();
        int r17 = super.getChildCount();
        int r18 = 0;
    L3:
        if (r18 >= r17) goto L110;
        View r0 = super.getChildAt(r18);
        if (r0.getVisibility() == 8) goto L109;
        if (r0.getTag(2131914113) == r0) goto L109;
        o6a.a r1 = this.P1;
        boolean r2 = true;
        if (r1 != null) goto L12;
    L33:
        m6a.f r3 = this.L1;
        if (r3 != null) goto L36;
    L55:
        m6a.e r4 = this.M1;
        if (r4 == null) goto L109;
        if (r4.getView() != r0) goto L109;
        if (isInEditMode() == true) goto L62;
    L66:
        r2 = false;
    L67:
        View r5 = this.M1.getView();
        ViewGroup.LayoutParams r6 = r5.getLayoutParams();
        if ((r6 instanceof ViewGroup.MarginLayoutParams) == false) goto L70;
        ViewGroup.MarginLayoutParams r7 = (ViewGroup.MarginLayoutParams) r6;
    L71:
        n6a.b r8 = this.M1.getSpinnerStyle();
        int r9 = r7.leftMargin;
        int r19 = (r7.topMargin + getMeasuredHeight()) - this.v1;
        if (this.S == false) goto L89;
        if (this.T == false) goto L89;
        if (this.G == false) goto L89;
        if (this.P1 == null) goto L89;
        if (this.M1.getSpinnerStyle() != n6a.b.d) goto L89;
        if (k(this.B) == false) goto L89;
        View r20 = this.P1.a;
        ViewGroup.LayoutParams r21 = r20.getLayoutParams();
        if ((r21 instanceof ViewGroup.MarginLayoutParams) == false) goto L86;
        int r22 = ((ViewGroup.MarginLayoutParams) r21).topMargin;
    L87:
        int r23 = r20.getMeasuredHeight();
        r19 = r23 + ((r16 + r16) + r22);
        goto L89
    L86:
        r22 = 0;
    L89:
        if (r8 != n6a.b.g) goto L91;
        r19 = r7.topMargin - this.v1;
    L108:
        r5.layout(r9, r19, r5.getMeasuredWidth() + r9, r5.getMeasuredHeight() + r19);
        goto L109
    L91:
        if (r2 == false) goto L93;
    L106:
        int r24 = this.h1;
    L107:
        r19 = r19 - r24;
        goto L108
    L93:
        if (r8 == n6a.b.f) goto L106;
        if (r8 == n6a.b.e) goto L106;
        if (r8.c == false) goto L108;
        if (this.b >= 0) goto L108;
        if (k(this.B) == false) goto L104;
        int r25 = -this.b;
    L105:
        r24 = Math.max(r25, 0);
        goto L107
    L104:
        r25 = 0;
        goto L105
    L70:
        r7 = J2;
        goto L71
    L62:
        if (this.H == false) goto L66;
        if (k(this.B) == false) goto L66;
    L36:
        if (r3.getView() != r0) goto L55;
        if (isInEditMode() == true) goto L40;
    L44:
        boolean r26 = false;
    L45:
        View r27 = this.L1.getView();
        ViewGroup.LayoutParams r28 = r27.getLayoutParams();
        if ((r28 instanceof ViewGroup.MarginLayoutParams) == false) goto L48;
        ViewGroup.MarginLayoutParams r29 = (ViewGroup.MarginLayoutParams) r28;
    L49:
        int r30 = r29.leftMargin;
        int r31 = r29.topMargin + this.p1;
        int r32 = r27.getMeasuredWidth() + r30;
        int r33 = r27.getMeasuredHeight() + r31;
        if (r26 == false) goto L52;
    L54:
        r27.layout(r30, r31, r32, r33);
        goto L55
    L52:
        if (this.L1.getSpinnerStyle() != n6a.b.d) goto L54;
        int r34 = this.b1;
        r31 = r31 - r34;
        r33 = r33 - r34;
        goto L54
    L48:
        r29 = J2;
        goto L49
    L40:
        if (this.H == false) goto L44;
        if (k(this.A) == false) goto L44;
        r26 = true;
        goto L45
    L12:
        if (r1.a != r0) goto L33;
        if (isInEditMode() == true) goto L16;
    L22:
        boolean r35 = false;
    L23:
        View r36 = this.P1.a;
        ViewGroup.LayoutParams r37 = r36.getLayoutParams();
        if ((r37 instanceof ViewGroup.MarginLayoutParams) == false) goto L26;
        ViewGroup.MarginLayoutParams r38 = (ViewGroup.MarginLayoutParams) r37;
    L27:
        int r39 = r38.leftMargin + r15;
        int r40 = r38.topMargin + r16;
        int r41 = r36.getMeasuredWidth() + r39;
        int r42 = r36.getMeasuredHeight() + r40;
        if (r35 == true) goto L30;
    L32:
        r36.layout(r39, r40, r41, r42);
        goto L33
    L30:
        if (l(this.E, this.L1) == false) goto L32;
        int r43 = this.b1;
        r40 = r40 + r43;
        r42 = r42 + r43;
        goto L32
    L26:
        r38 = J2;
        goto L27
    L16:
        if (this.H == false) goto L22;
        if (k(this.A) == false) goto L22;
        if (this.L1 == null) goto L22;
        r35 = true;
    L109:
        r18 = r18 + 1;
        goto L3
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedScroll(View r7, int r8, int r9, int r10, int r11) {
        boolean r12 = this.P0.dispatchNestedScroll(r8, r9, r10, r11, this.L0);
        int r13 = r11 + this.L0[1];
        if (r13 < 0) goto L5;
    L9:
        if (r13 > 0) goto L11;
    L29:
        if (this.E2 == false) goto L33;
        if (r9 >= 0) goto L34;
        this.E2 = false;
        return;
    L34:
        return;
    L33:
        return;
    L11:
        if (this.B == false) goto L13;
    L14:
        RefreshState r14 = this.b2;
        if (r14 != RefreshState.None) goto L17;
    L18:
        i r15 = this.T1;
        if (r13 <= 0) goto L21;
        RefreshState r0 = RefreshState.PullUpToLoad;
    L22:
        r15.d(r0);
        if (r12 == true) goto L27;
        ViewParent r16 = getParent();
        if ((r16 instanceof ViewGroup) == false) goto L27;
        ((ViewGroup) r16).requestDisallowInterceptTouchEvent(true);
    L27:
        int r17 = this.p0 - r13;
        this.p0 = r17;
        m(r17);
        goto L29
    L21:
        r0 = RefreshState.PullDownToRefresh;
        goto L22
    L17:
        if (r14.isOpening == false) goto L27;
    L13:
        if (this.J == false) goto L29;
    L5:
        if (this.A == true) goto L14;
        if (this.J == false) goto L9;
        goto L9
    }
}
