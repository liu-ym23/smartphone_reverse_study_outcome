package jn;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.LinearInterpolator;
import android.widget.Scroller;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import androidx.core.math.MathUtils;
import androidx.core.view.ViewCompat;
import com.lynx.animax.i;
import com.lynx.tasm.behavior.a0;
import com.lynx.tasm.behavior.ui.swiper.XSwiperUI;
import com.lynx.tasm.utils.DisplayMetricsHolder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class f extends ViewGroup {
    public boolean A;
    public boolean B;
    public boolean C;
    public boolean D;
    public int E;
    public int F;
    public final int G;
    public float H;
    public float I;
    public float J;
    public float K;
    public c L;
    public int M;
    public int N;
    public int O;
    public int P;
    public int Q;
    public int R;
    public int S;
    public int T;
    public final ArrayList U;
    public boolean V;
    public boolean W;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f18368a;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public boolean f18369a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f18370b;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public boolean f18371b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f18372c;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public boolean f18373c0;
    public boolean d;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public boolean f18374d0;
    public int e;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public int f18375e0;
    public int f;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public float f18376f0;
    public int g;
    public float g0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f18377h;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public int f18378h0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Scroller f18379i;
    public final GestureDetector i0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f18380j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f18381k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f18382l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f18383m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f18384n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f18385o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f18386p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f18387q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f18388r;
    public boolean s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f18389t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f18390u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f18391v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public e f18392w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final int f18393x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final int f18394y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final float f18395z;

    public f(Context r10) {
        super(r10, null);
        this.f18368a = false;
        this.f18370b = false;
        this.f18372c = false;
        this.d = false;
        this.e = 0;
        this.f = -1;
        this.g = -1;
        this.f18377h = -1;
        this.f18380j = false;
        this.f18381k = true;
        this.f18382l = true;
        this.f18383m = false;
        this.f18384n = false;
        this.f18385o = false;
        this.f18386p = false;
        this.f18387q = false;
        this.f18388r = false;
        this.s = false;
        this.f18389t = 300;
        this.f18390u = 0;
        this.f18391v = 0;
        this.A = false;
        this.B = false;
        this.C = false;
        this.D = false;
        this.E = -1;
        this.F = 0;
        this.G = 0;
        this.H = 0.0f;
        this.I = 0.0f;
        this.J = 0.0f;
        this.K = 0.0f;
        this.M = -1;
        this.N = 0;
        this.O = -1;
        this.P = -1;
        this.Q = -1;
        this.R = 0;
        this.S = Integer.MIN_VALUE;
        this.T = Integer.MAX_VALUE;
        this.V = false;
        this.W = false;
        this.f18369a0 = false;
        this.f18371b0 = false;
        this.f18373c0 = false;
        this.f18374d0 = true;
        this.f18375e0 = 300;
        this.f18376f0 = -1.0f;
        this.g0 = -1.0f;
        this.f18378h0 = Integer.MIN_VALUE;
        this.i0 = new GestureDetector(new com.obric.oui.swipeaction.b(this, 2), new Handler(Looper.getMainLooper()));
        float r5 = getResources().getDisplayMetrics().density;
        this.f18379i = new Scroller(r10, new LinearInterpolator());
        int r11 = (int) (600.0f * r5);
        this.f18394y = r11;
        this.f18393x = r11;
        this.f18395z = ViewConfiguration.get(r10).getScaledTouchSlop();
        this.G = (int) (r5 * 2.0f);
        this.U = new ArrayList();
    }

    public static /* synthetic */ void f(f r5) {
        r5.setScrollState(1);
    }

    public static void g(f r10, float r11, float r12) {
        if (r10.getChildCount() >= 1) goto L6;
        return;
    L6:
        if (r10.o() == false) goto L8;
        r11 = r12;
    L8:
        int r13 = r10.getPile();
        int r5 = r10.getScrollDistance();
        int r14 = ((d) r10.getCurrentView().getLayoutParams()).f18367a;
        int r15 = 0;
        Scroller r16 = r10.f18379i;
        if (r11 >= 0.0f) goto L29;
        int r17 = r10.getChildCount();
        int r18 = Integer.MAX_VALUE;
    L11:
        if (r15 >= r17) goto L21;
        View r19 = r10.getChildAt(r15);
        if (r10.o() == false) goto L15;
        int r20 = r19.getTop();
    L16:
        int r21 = r20 - r5;
        if (r21 <= r13) goto L20;
        if (r21 >= r18) goto L20;
        r18 = r21;
    L20:
        r15 = r15 + 1;
        goto L11
    L15:
        r20 = r19.getLeft();
        goto L16
    L21:
        if (r18 != Integer.MAX_VALUE) goto L25;
        r10.c(r14, true);
        return;
    L25:
        if (r10.o() == false) goto L27;
        r16.startScroll(0, r5, 0, r18 - r13, r10.f18389t);
    L28:
        r10.setScrollState(2);
    L48:
        r10.invalidate();
        return;
    L27:
        r16.startScroll(r5, 0, r18 - r13, 0, r10.f18389t);
        goto L28
    L29:
        int r110 = r10.getChildCount();
        int r22 = Integer.MIN_VALUE;
        int r23 = 0;
    L30:
        if (r23 >= r110) goto L40;
        View r24 = r10.getChildAt(r23);
        if (r10.o() == false) goto L34;
        int r25 = r24.getTop();
    L35:
        int r26 = r25 - r5;
        if (r26 >= r13) goto L39;
        if (r26 <= r22) goto L39;
        r22 = r26;
    L39:
        r23 = r23 + 1;
        goto L30
    L34:
        r25 = r24.getLeft();
        goto L35
    L40:
        if (r22 != Integer.MIN_VALUE) goto L44;
        r10.c(r14, false);
        return;
    L44:
        if (r10.o() == false) goto L46;
        r16.startScroll(0, r5, 0, r22 - r13, r10.f18389t);
    L47:
        r10.setScrollState(2);
        goto L48
    L46:
        r16.startScroll(r5, 0, r22 - r13, 0, r10.f18389t);
        goto L47
    }

    private List<View> getAllChildren() {
        int r5 = getChildCount();
        LinkedList r10 = new LinkedList();
        int r11 = 0;
    L3:
        if (r11 >= r5) goto L5;
        r10.add(getChildAt(r11));
        r11 = r11 + 1;
        goto L3
    L5:
        return r10;
    }

    private int getContentHeight() {
        return (getHeight() - getPaddingTop()) - getPaddingBottom();
    }

    private int getContentSize() {
        if (o() == false) goto L7;
        return getContentHeight();
    L7:
        return getContentWidth();
    }

    private int getContentWidth() {
        return (getWidth() - getPaddingLeft()) - getPaddingRight();
    }

    private View getCurrentView() {
        int r5 = (getChildExpectSize() / 2) + getPile();
        int r10 = getScrollDistance();
        int r11 = getChildCount();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L22;
        View r13 = getChildAt(r12);
        if (o() == false) goto L7;
        int r14 = r13.getTop();
    L8:
        int r15 = r14 - r10;
        if (o() == false) goto L11;
        int r16 = r13.getBottom();
    L12:
        int r17 = r16 - r10;
        int r18 = this.F;
        if (r18 <= 0) goto L15;
        r17 = r17 + this.R;
    L17:
        if (r15 > r5) goto L20;
        if (r17 < r5) goto L20;
        return r13;
    L20:
        r12 = r12 + 1;
        goto L3
    L15:
        if (r18 >= 0) goto L17;
        r15 = r15 - this.R;
        goto L17
    L11:
        r16 = r13.getRight();
        goto L12
    L7:
        r14 = r13.getLeft();
        goto L8
    L22:
        return getChildAt(0);
    }

    private int getPageGap() {
        if (o() == false) goto L7;
        int r5 = getHeight() - getPaddingBottom();
        int r10 = this.R;
    L6:
        return r5 - r10;
    L7:
        r5 = getWidth() - getPaddingRight();
        r10 = this.R;
        goto L6
    }

    private int getPile() {
        if (o() == false) goto L8;
        int r5 = getPaddingTop();
        int r10 = getOffset();
    L6:
        return r10 + r5;
    L8:
        if (n() == false) goto L11;
        int r11 = getPaddingLeft();
        int r12 = getOffset() + r11;
        return (getWidth() + r12) - getChildExpectSize();
    L11:
        r5 = getPaddingLeft();
        r10 = getOffset();
        goto L6
    }

    private int getScrollDistance() {
        if (o() == false) goto L7;
        return getScrollY();
    L7:
        return getScrollX();
    }

    public static boolean i(View r13, boolean r14, boolean r15, int r16, int r17, int r18) {
        if ((r13 instanceof ViewGroup) == false) goto L18;
        ViewGroup r10 = (ViewGroup) r13;
        int r11 = r13.getScrollX();
        int r12 = r13.getScrollY();
        int r19 = r10.getChildCount() - 1;
    L5:
        if (r19 < 0) goto L18;
        View r5 = r10.getChildAt(r19);
        int r20 = r17 + r11;
        if (r20 < r5.getLeft()) goto L17;
        if (r20 >= r5.getRight()) goto L17;
        int r21 = r18 + r12;
        if (r21 < r5.getTop()) goto L17;
        if (r21 >= r5.getBottom()) goto L17;
        if (i(r5, r14, true, r16, r20 - r5.getLeft(), r21 - r5.getTop()) == false) goto L17;
        return true;
    L17:
        r19 = r19 - 1;
    L18:
        if (r15 == false) goto L26;
        if (r14 == false) goto L24;
        if (r13.canScrollVertically(-r16) == false) goto L35;
    L25:
        return true;
    L35:
        return false;
    L24:
        if (r13.canScrollHorizontally(-r16) == true) goto L25;
        return false;
    L26:
        return false;
    }

    private void setScrollState(int r10) {
        if (this.f18391v != r10) goto L5;
        return;
    L5:
        Iterator r5 = this.U.iterator();
    L7:
        if (r5.hasNext() == false) goto L16;
        g r11 = (g) r5.next();
        XSwiperUI r12 = r11.f18398c;
        if (r12.f10677n == false) goto L7;
        Handler r13 = r12.C;
        a0 r14 = r12.E;
        if (r10 == 1) goto L12;
        if (r11.f18396a == false) goto L7;
        r11.f18396a = false;
        r13.removeCallbacks(r14);
        XSwiperUI r15 = r11.f18398c;
        r15.C.postDelayed(r15.E, r15.f10680q);
        goto L7
    L12:
        r11.f18396a = true;
        r13.removeCallbacks(r14);
        goto L7
    L16:
        this.f18391v = r10;
    }

    public final void a() {
        if (this.L != null) goto L5;
        return;
    L5:
        if (this.e <= 0) goto L40;
        boolean r5 = false;
        if (this.f18370b == false) goto L9;
    L14:
        boolean r10 = true;
    L16:
        if (this.f18373c0 == false) goto L19;
        if (r10 == true) goto L19;
        return;
    L19:
        int r11 = this.N;
        this.N = r11;
        if (r10 == true) goto L22;
    L25:
        int r12 = this.f18377h;
        if (r12 != (-1)) goto L28;
    L30:
        r12 = this.f;
        if (r12 != (-1)) goto L34;
        r12 = -1;
    L34:
        if (r12 >= 0) goto L36;
        return;
    L36:
        if (r12 >= this.e) goto L42;
        b(r12, 1, r5);
        return;
    L42:
        return;
    L28:
        if (r12 == this.f) goto L30;
        r5 = this.f18368a;
        goto L34
    L22:
        if (o() == false) goto L24;
        scrollTo(0, -r11);
        goto L25
    L24:
        scrollTo(-r11, 0);
        goto L25
    L9:
        if (this.f18372c == true) goto L14;
        if (this.d == true) goto L14;
        r10 = false;
        goto L16
    }

    @Override // android.view.ViewGroup
    public final void addView(View r5, int r10, ViewGroup.LayoutParams r11) {
        throw new IllegalStateException();
    }

    public final void b(int r12, int r13, boolean r14) {
        boolean r5 = true;
        if (this.e >= 1) goto L5;
        return;
    L5:
        if (getChildCount() < 1) goto L63;
        int r10 = 0;
        int r15 = MathUtils.clamp(r12, 0, this.e - 1);
        View r11 = getCurrentView();
        int r16 = ((d) r11.getLayoutParams()).f18367a;
        if (r16 == r15) goto L64;
        int r17 = getChildExpectSize();
        int r18 = getScrollDistance();
        int r19 = (r17 / 2) + getPile();
        if (o() == false) goto L13;
        int r20 = r11.getTop();
    L15:
        if (o() == false) goto L17;
        int r21 = r11.getBottom();
    L18:
        int r22 = ((r20 + r21) / 2) - r18;
        int r23 = r17 + this.R;
        int r24 = (r15 - r16) * r23;
        boolean r25 = this.f18384n;
        if (r25 == false) goto L21;
    L22:
        if (r13 != 1) goto L26;
        if (r15 > r16) goto L29;
        int r26 = this.e + r15;
    L30:
        r24 = (r26 - r16) * r23;
    L31:
        if (r25 == true) goto L40;
        this.s = true;
        if (r13 != 1) goto L35;
        if (r15 >= r16) goto L35;
    L39:
        this.f18384n = r5;
    L35:
        if (r13 != 0) goto L38;
        if (r15 > r16) goto L39;
    L38:
        r5 = false;
    L40:
        s();
        boolean r110 = n();
        Scroller r111 = this.f18379i;
        if (r110 == false) goto L47;
        int r27 = (r22 - r19) - r24;
        if (r14 == false) goto L45;
        r10 = this.f18389t;
    L45:
        r111.startScroll(r18, 0, r27, 0, r10);
    L56:
        setScrollState(2);
        if (o() == false) goto L59;
        int r112 = r111.getFinalY();
    L60:
        this.f18378h0 = r112;
        invalidate();
        return;
    L59:
        r112 = r111.getFinalX();
        goto L60
    L47:
        if (o() == false) goto L52;
        int r28 = (r22 - r19) + r24;
        if (r14 == false) goto L51;
        r10 = this.f18389t;
    L51:
        r111.startScroll(0, r18, 0, r28, r10);
        goto L56
    L52:
        int r29 = r24 + (r22 - r19);
        if (r14 == false) goto L55;
        r10 = this.f18389t;
    L55:
        r111.startScroll(r18, 0, r29, 0, r10);
    L29:
        r26 = r15;
        goto L30
    L26:
        if (r13 != 0) goto L31;
        if (r15 <= r16) goto L29;
        r26 = r15 - this.e;
        goto L30
    L21:
        if (this.f18388r == false) goto L40;
    L17:
        r21 = r11.getRight();
        goto L18
    L13:
        r20 = r11.getLeft();
        goto L15
    L64:
        return;
    }

    public final void c(int r5, boolean r10) {
        int r11 = 0;
        if (r10 == false) goto L21;
        if (n() == false) goto L13;
        if (this.f18384n == true) goto L9;
    L11:
        r11 = r5 - 1;
    L18:
        b(r11, !n() ? 1 : 0, true);
        return;
    L9:
        if ((r5 - 1) >= 0) goto L11;
        r5 = this.e;
        goto L11
    L13:
        if (this.f18384n == true) goto L15;
    L17:
        r11 = r5 + 1;
        goto L18
    L15:
        if ((r5 + 1) < this.e) goto L17;
    L21:
        if (n() == false) goto L29;
        if (this.f18384n == true) goto L25;
    L27:
        r11 = r5 + 1;
    L34:
        b(r11, n() ? 1 : 0, true);
        return;
    L25:
        if ((r5 + 1) < this.e) goto L27;
    L29:
        if (this.f18384n == true) goto L31;
    L33:
        r11 = r5 - 1;
        goto L34
    L31:
        if ((r5 - 1) >= 0) goto L33;
        r5 = this.e;
        goto L33
    }

    @Override // android.view.View
    public final boolean canScrollHorizontally(int r5) {
        if (this.f18382l == false) goto L7;
        if (h(r5) == false) goto L7;
        return true;
    L7:
        if (this.f18387q == true) goto L12;
        return false;
    L12:
        return true;
    }

    @Override // android.view.View
    public final boolean canScrollVertically(int r5) {
        if (this.f18382l == false) goto L7;
        if (k(r5) == false) goto L7;
        return true;
    L7:
        if (this.f18387q == true) goto L12;
        return false;
    L12:
        return true;
    }

    @Override // android.view.View
    public final void computeScroll() {
        Scroller r5 = this.f18379i;
        if (r5.computeScrollOffset() == false) goto L19;
        if (o() == false) goto L7;
        int r10 = r5.getFinalY();
    L8:
        this.f18378h0 = r10;
        int r11 = getScrollX();
        int r12 = getScrollY();
        int r13 = r5.getCurrX();
        int r14 = r5.getCurrY();
        if (o() == false) goto L13;
        if (r12 == r14) goto L13;
        scrollTo(r11, r14);
    L16:
        ViewCompat.postInvalidateOnAnimation(this);
        return;
    L13:
        if (o() == true) goto L16;
        if (r11 == r13) goto L16;
        scrollTo(r13, r12);
        goto L16
    L7:
        r10 = r5.getFinalX();
        goto L8
    L19:
        if (getChildCount() > 0) goto L21;
        return;
    L21:
        if (this.f18391v == 1) goto L75;
        int r15 = ((d) getCurrentView().getLayoutParams()).f18367a;
        this.f = r15;
        int r16 = this.g;
        ArrayList r17 = this.U;
        if (r16 == r15) goto L34;
        Iterator r18 = r17.iterator();
    L26:
        if (r18.hasNext() == false) goto L34;
        g r19 = (g) r18.next();
        int r20 = this.f;
        boolean r21 = this.f18381k;
        b r22 = (b) XSwiperUI.s(r19.f18398c);
        r22.f = r20;
        r22.c();
        XSwiperUI r23 = r19.f18398c;
        if (r23.f10669b == false) goto L26;
        if (r21 == true) goto L26;
        i r24 = new i(r23.getSign(), "change");
        r24.a("current", Integer.valueOf(r20));
        if (r23.getLynxContext() == null) goto L26;
        r23.getLynxContext().g.b(r24);
    L34:
        if (this.f18388r == false) goto L39;
        if (this.s == false) goto L39;
        this.f18384n = false;
        this.s = false;
        requestLayout();
    L39:
        if (this.f18381k == true) goto L52;
        if (this.f18380j == false) goto L52;
        Iterator r25 = r17.iterator();
    L44:
        if (r25.hasNext() == false) goto L50;
        g r26 = (g) r25.next();
        int r27 = this.f;
        XSwiperUI r28 = r26.f18398c;
        if (r28.d == false) goto L44;
        i r29 = new i(r28.getSign(), "scrollend");
        r29.a("current", Integer.valueOf(r27));
        XSwiperUI r30 = r26.f18398c;
        if (r30.getLynxContext() == null) goto L44;
        r30.getLynxContext().g.b(r29);
        goto L44
    L50:
        this.f18380j = false;
    L52:
        if (this.g == (-1)) goto L54;
    L56:
        this.g = this.f;
        setScrollState(0);
        return;
    L54:
        if (this.f == (-1)) goto L56;
        this.f18381k = false;
        goto L56
    }

    public final void d(View r10) {
        if (o() == false) goto L14;
        d r5 = (d) r10.getLayoutParams();
        int r11 = ((ViewGroup.LayoutParams) r5).width;
        if (r11 < 0) goto L7;
        int r12 = View.MeasureSpec.makeMeasureSpec(r11, BasicMeasure.EXACTLY);
    L13:
        int r13 = View.MeasureSpec.makeMeasureSpec(getChildExpectSize(), BasicMeasure.EXACTLY);
    L23:
        r10.measure(r12, r13);
        return;
    L7:
        int r14 = Math.max(0, (getWidth() - getPaddingLeft()) - getPaddingRight());
        int r15 = ((ViewGroup.LayoutParams) r5).width;
        if (r15 != (-1)) goto L10;
        r12 = View.MeasureSpec.makeMeasureSpec(r14, BasicMeasure.EXACTLY);
        goto L13
    L10:
        if (r15 != (-2)) goto L12;
        r12 = View.MeasureSpec.makeMeasureSpec(r14, Integer.MIN_VALUE);
        goto L13
    L12:
        r12 = View.MeasureSpec.makeMeasureSpec(0, BasicMeasure.EXACTLY);
        goto L13
    L14:
        r12 = View.MeasureSpec.makeMeasureSpec(getChildExpectSize(), BasicMeasure.EXACTLY);
        d r16 = (d) r10.getLayoutParams();
        int r17 = ((ViewGroup.LayoutParams) r16).height;
        if (r17 < 0) goto L17;
        r13 = View.MeasureSpec.makeMeasureSpec(r17, BasicMeasure.EXACTLY);
        goto L23
    L17:
        int r18 = Math.max(0, (getHeight() - getPaddingTop()) - getPaddingBottom());
        int r19 = ((ViewGroup.LayoutParams) r16).height;
        if (r19 != (-1)) goto L20;
        r13 = View.MeasureSpec.makeMeasureSpec(r18, BasicMeasure.EXACTLY);
        goto L23
    L20:
        if (r19 != (-2)) goto L22;
        r13 = View.MeasureSpec.makeMeasureSpec(r18, Integer.MIN_VALUE);
        goto L23
    L22:
        r13 = View.MeasureSpec.makeMeasureSpec(0, BasicMeasure.EXACTLY);
        goto L23
    }

    public final void e(View r5, int r10, int r11) {
        if (o() == false) goto L5;
        int r12 = getPaddingLeft();
        int r13 = r5.getMeasuredWidth() + r12;
        r10 = r12;
        int r14 = r10;
        int r15 = r11;
        r11 = r13;
    L6:
        r5.layout(r10, r14, r11, r15);
        return;
    L5:
        r14 = getPaddingTop();
        r15 = r5.getMeasuredHeight() + r14;
        goto L6
    }

    public c getAdapter() {
        return this.L;
    }

    public int getChildExpectSize() {
        int r5 = this.M;
        if (r5 <= 0) goto L6;
        return r5;
    L6:
        return getContentSize();
    }

    public int getCurrentIndex() {
        return this.f;
    }

    public int getOffset() {
        return this.N;
    }

    public int getTotalCount() {
        return this.e;
    }

    public final boolean h(int r10) {
        if (o() == false) goto L5;
    L29:
        return false;
    L5:
        if (this.L == null) goto L29;
        int r5 = this.e;
        if (r5 <= 1) goto L29;
        int r11 = this.f;
        if (r11 == (-1)) goto L29;
        if (this.f18384n == true) goto L28;
        if (r10 > 0) goto L14;
    L19:
        if (r10 < 0) goto L21;
    L27:
        return false;
    L21:
        if (this.f18385o == true) goto L23;
        if (r11 <= 0) goto L27;
    L23:
        if (r11 >= (r5 - 1)) goto L27;
    L14:
        if (this.f18385o == false) goto L18;
        if (r11 <= 0) goto L19;
    L18:
        if (r11 >= (r5 - 1)) goto L19;
    L28:
        return true;
    }

    public final boolean j() {
        if (this.V == true) goto L5;
        return false;
    L5:
        if (this.f18384n == false) goto L7;
        return false;
    L7:
        if (this.f18381k == true) goto L32;
        float r5 = this.f18376f0;
        if (r5 > 0.0f) goto L11;
        return false;
    L11:
        if (r5 < 1.0f) goto L13;
        return false;
    L13:
        if (this.L != null) goto L15;
        return false;
    L15:
        if (this.g0 >= 0.0f) goto L20;
        if (this.e >= 2) goto L22;
        return false;
    L22:
        if (this.d == false) goto L24;
        return false;
    L24:
        if (this.f18370b == false) goto L26;
        return false;
    L26:
        if (this.f18372c == true) goto L40;
        return true;
    L40:
        return false;
    L20:
        if (this.e >= 3) goto L22;
        return false;
    L32:
        return false;
    }

    public final boolean k(int r10) {
        if (o() == true) goto L5;
    L20:
        return false;
    L5:
        if (this.L == null) goto L20;
        int r5 = this.e;
        if (r5 <= 1) goto L20;
        int r11 = this.f;
        if (r11 == (-1)) goto L20;
        if (this.f18384n == true) goto L19;
        if (r10 > 0) goto L14;
    L15:
        if (r10 >= 0) goto L18;
        if (r11 > 0) goto L19;
    L18:
        return false;
    L14:
        if (r11 >= (r5 - 1)) goto L15;
    L19:
        return true;
    }

    public final View l(int r5) {
        int r10 = getChildCount() - 1;
    L4:
        if (r10 <= (-1)) goto L9;
        View r11 = getChildAt(r10);
        if (((d) r11.getLayoutParams()).f18367a == r5) goto L7;
        r10 = r10 - 1;
        goto L4
    L7:
        return r11;
    L9:
        View r12 = (View) ((h) this.L).f18399a.D.get(r5);
        d r13 = new d(-1, -1);
        r13.f18367a = r5;
        addViewInLayout(r12, 0, r13, true);
        d(r12);
        return r12;
    }

    public final boolean m() {
        if (this.V == true) goto L5;
        return false;
    L5:
        if (this.f18384n == false) goto L7;
        return false;
    L7:
        if (this.f18381k == true) goto L32;
        float r5 = this.g0;
        if (r5 > 0.0f) goto L11;
        return false;
    L11:
        if (r5 < 1.0f) goto L13;
        return false;
    L13:
        if (this.L != null) goto L15;
        return false;
    L15:
        if (this.f18376f0 >= 0.0f) goto L20;
        if (this.e >= 2) goto L22;
        return false;
    L22:
        if (this.d == false) goto L24;
        return false;
    L24:
        if (this.f18370b == false) goto L26;
        return false;
    L26:
        if (this.f18372c == true) goto L40;
        return true;
    L40:
        return false;
    L20:
        if (this.e >= 3) goto L22;
        return false;
    L32:
        return false;
    }

    public final boolean n() {
        if (this.f18385o == true) goto L5;
        return false;
    L5:
        if (this.f18390u != 0) goto L10;
        return true;
    L10:
        return false;
    }

    public final boolean o() {
        if (this.f18390u != 1) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        setScrollState(0);
        Scroller r5 = this.f18379i;
        if (r5 != null) goto L5;
    L7:
        super.onDetachedFromWindow();
        return;
    L5:
        if (r5.isFinished() == true) goto L7;
        r5.abortAnimation();
        goto L7
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r15) {
        if (this.f18382l == false) goto L5;
        int r5 = r15.getActionMasked();
        int r10 = r15.getActionIndex();
        int r11 = 0;
        if (r5 != 3) goto L9;
    L98:
        this.E = -1;
        this.B = false;
        this.C = false;
        this.A = false;
        this.D = false;
        this.F = 0;
        return false;
    L9:
        if (r5 == 1) goto L98;
        if (r5 == 0) goto L19;
        if (this.B == false) goto L16;
        return true;
    L16:
        if (this.C == false) goto L19;
        return false;
    L19:
        if (r5 == 0) goto L78;
        if (r5 != 2) goto L22;
        int r12 = this.E;
        if (r12 == (-1)) goto L97;
        int r13 = r15.findPointerIndex(r12);
        float r14 = r15.getX(r13);
        float r16 = r15.getY(r13);
        float r17 = r14 - this.H;
        float r18 = r16 - this.I;
        float r19 = r14 - this.J;
        float r20 = r16 - this.K;
        if (o() == false) goto L38;
        float r21 = r18;
    L39:
        int r110 = (int) r21;
        if (this.f18383m == false) goto L46;
        if (r110 == 0) goto L46;
        if (i(this, o(), false, r110, (int) r14, (int) r16) == false) goto L46;
        this.H = r14;
        this.I = r16;
        this.C = true;
        return false;
    L46:
        boolean r22 = o();
        float r23 = this.f18395z;
        if (r22 == false) goto L64;
        if (Math.abs(r18) <= r23) goto L61;
        if (Math.abs(r18) <= (Math.abs(r19) * 0.5f)) goto L61;
        ViewParent r111 = getParent();
        if (r111 == null) goto L55;
        r111.requestDisallowInterceptTouchEvent(true);
    L55:
        setScrollState(1);
        this.B = true;
        this.D = true;
        if (r18 <= 0.0f) goto L58;
        float r112 = this.K + r23;
    L59:
        this.I = r112;
        this.H = r14;
        goto L97
    L58:
        r112 = this.K - r23;
    L61:
        if (r19 <= r23) goto L97;
        this.C = true;
        goto L97
    L64:
        if (Math.abs(r17) <= r23) goto L76;
        if (Math.abs(r17) <= (Math.abs(r20) * 0.5f)) goto L76;
        ViewParent r24 = getParent();
        if (r24 == null) goto L70;
        r24.requestDisallowInterceptTouchEvent(true);
    L70:
        setScrollState(1);
        this.B = true;
        this.D = true;
        if (r17 <= 0.0f) goto L73;
        float r25 = this.J + r23;
    L74:
        this.H = r25;
        this.I = r16;
        goto L97
    L73:
        r25 = this.J - r23;
    L76:
        if (r20 <= r23) goto L97;
        this.C = true;
        goto L97
    L38:
        r21 = r17;
    L97:
        return this.B;
    L22:
        if (r5 != 5) goto L24;
        this.E = r15.getPointerId(r10);
        goto L97
    L24:
        if (r5 != 6) goto L97;
        int r26 = r15.getActionIndex();
        if (r15.getPointerId(r26) != this.E) goto L97;
        if (r26 != 0) goto L30;
        r11 = 1;
    L30:
        this.H = r15.getX(r11);
        this.I = r15.getY(r11);
        this.E = r15.getPointerId(r11);
        goto L97
    L78:
        float r27 = r15.getX();
        this.J = r27;
        this.H = r27;
        float r28 = r15.getY();
        this.K = r28;
        this.I = r28;
        this.E = r15.getPointerId(r10);
        this.B = false;
        this.C = false;
        this.D = false;
        this.A = false;
        this.F = 0;
        Scroller r113 = this.f18379i;
        r113.computeScrollOffset();
        if (o() == false) goto L82;
        int r29 = r113.getFinalY();
        int r30 = r113.getCurrY();
    L81:
        int r31 = r29 - r30;
        if (this.f18374d0 == false) goto L89;
        ViewParent r32 = getParent();
        if (r32 == null) goto L89;
        r32.requestDisallowInterceptTouchEvent(true);
    L89:
        if (this.f18391v != 2) goto L97;
        if (Math.abs(r31) <= this.G) goto L97;
        r113.abortAnimation();
        ViewParent r114 = getParent();
        if (r114 == null) goto L95;
        r114.requestDisallowInterceptTouchEvent(true);
    L95:
        setScrollState(1);
        this.B = true;
        goto L97
    L82:
        r29 = r113.getFinalX();
        r30 = r113.getCurrX();
        goto L81
    L5:
        return super.onInterceptTouchEvent(r15);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r5, int r10, int r11, int r12, int r13) {
        int r14 = getChildCount();
    L3:
        r14 = r14 - 1;
        if (r14 <= (-1)) goto L7;
        d(getChildAt(r14));
        goto L3
    L7:
        if (this.d == false) goto L9;
    L15:
        a();
        this.d = false;
        this.f18370b = false;
        this.f18372c = false;
        return;
    L9:
        if (this.f18370b == true) goto L15;
        if (this.f18372c == true) goto L15;
        p();
    }

    @Override // android.view.View
    public final void onMeasure(int r5, int r10) {
        setMeasuredDimension(View.getDefaultSize(0, r5), View.getDefaultSize(0, r10));
    }

    @Override // android.view.View
    public final void onSizeChanged(int r5, int r10, int r11, int r12) {
        super.onSizeChanged(r5, r10, r11, r12);
        if (this.f18370b == false) goto L5;
    L8:
        a();
        this.f18370b = false;
        this.f18372c = false;
        return;
    L5:
        if (this.f18372c == true) goto L8;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r5) {
        int r10 = r5.getActionIndex();
        int r11 = r5.getActionMasked();
        int r12 = 1;
        if (r11 != 1) goto L5;
    L18:
        this.E = -1;
        if (this.A == true) goto L22;
        q();
    L22:
        if (this.f18382l == false) goto L26;
        return this.i0.onTouchEvent(r5);
    L26:
        return super.onTouchEvent(r5);
    L5:
        if (r11 == 3) goto L18;
        if (r11 != 5) goto L9;
        this.E = r5.getPointerId(r10);
        this.H = r5.getX(r10);
        this.I = r5.getY(r10);
        goto L22
    L9:
        if (r11 != 6) goto L22;
        int r13 = r5.getActionIndex();
        if (r5.getPointerId(r13) != this.E) goto L22;
        if (r13 == 0) goto L16;
        r12 = 0;
    L16:
        this.H = r5.getX(r12);
        this.I = r5.getY(r12);
        this.E = r5.getPointerId(r12);
        goto L22
    }

    public final void p() {
        if (this.e < 1) goto L145;
        int r5 = getChildExpectSize();
        if (r5 <= 0) goto L169;
        int r10 = getScrollDistance();
        int r11 = this.R + r5;
        if (r11 <= 0) goto L170;
        int r12 = r10 / r11;
        int r13 = r10 % r11;
        if (n() == false) goto L40;
        if (this.f18384n == false) goto L30;
        if (r10 <= 0) goto L24;
        if (r13 == 0) goto L18;
        r12 = r12 + 1;
    L19:
        int r14 = (getWidth() + r10) - r13;
        if (r13 != 0) goto L22;
        int r15 = 0;
    L23:
        int r16 = r14 + r15;
    L25:
        int r17 = this.e;
        int r18 = (r17 - r12) % r17;
        if (r18 >= 0) goto L28;
        r18 = r18 + r17;
    L28:
        int r19 = r16;
    L29:
        int r20 = 0;
    L60:
        int r21 = Math.max(0, getPageGap()) + r10;
        ArrayList r22 = new ArrayList();
        if (this.f18386p == true) goto L82;
        List<View> r23 = getAllChildren();
    L63:
        View r24 = l(r18);
        r23.remove(r24);
        if (n() == false) goto L66;
        r20 = r19 - r5;
    L67:
        e(r24, r20, r19);
        r();
        if (n() == false) goto L72;
        if (r20 <= r10) goto L79;
        r19 = r20 - this.R;
    L75:
        int r25 = r18 + 1;
        int r26 = this.e;
        if (r25 < r26) goto L80;
        if (this.f18384n == false) goto L79;
    L80:
        r18 = r25 % r26;
    L79:
        List r27 = r23;
    L137:
        Iterator r28 = r27.iterator();
    L139:
        if (r28.hasNext() == false) goto L171;
        View r29 = (View) r28.next();
        boolean r30 = this.f18386p;
        e r31 = this.f18392w;
        if (r31 == null) goto L143;
        r31.a(r29);
    L143:
        if (r30 == true) goto L139;
        removeView(r29);
        int r32 = ((d) r29.getLayoutParams()).f18367a;
        this.L.getClass();
        goto L139
    L171:
        return;
    L72:
        if (r19 >= r21) goto L79;
        r20 = this.R + r19;
        goto L75
    L66:
        r19 = r20 + r5;
        goto L67
    L82:
        if (this.f18384n == true) goto L118;
        int r33 = r18 - 1;
        int r34 = r20;
        int r35 = r19;
    L84:
        if (r33 < 0) goto L101;
        View r110 = l(r33);
        if (n() == false) goto L89;
        int r36 = r35 + this.R;
        int r37 = r36 + r5;
    L88:
        int r111 = r36;
        r35 = r37;
        r34 = r111;
        if (n() == false) goto L95;
        if ((r34 - this.R) < r21) goto L95;
    L98:
        r22.add(r110);
    L99:
        e(r110, r34, r35);
        r33 = r33 - 1;
    L95:
        if (n() == true) goto L99;
        if ((this.R + r35) > r10) goto L99;
    L89:
        r37 = r34 - this.R;
        r36 = r37 - r5;
    L101:
        if (r18 >= this.e) goto L136;
        View r38 = l(r18);
        if (n() == false) goto L105;
        r20 = r19 - r5;
    L107:
        if (n() == false) goto L110;
        if (r19 > r10) goto L110;
    L112:
        r22.add(r38);
    L113:
        e(r38, r20, r19);
        if (n() == false) goto L116;
        r19 = r20 - this.R;
    L117:
        r18 = r18 + 1;
        goto L101
    L116:
        r20 = this.R + r19;
    L110:
        if (n() == true) goto L113;
        if (r20 < r21) goto L113;
    L105:
        r19 = r20 + r5;
    L136:
        r();
        r27 = r22;
        goto L137
    L118:
        int r39 = r18;
    L119:
        View r40 = l(r39);
        if (n() == false) goto L122;
        r20 = r19 - r5;
    L124:
        if (n() == false) goto L127;
        if (r19 > r10) goto L127;
    L129:
        r22.add(r40);
    L130:
        e(r40, r20, r19);
        if (n() == false) goto L133;
        r19 = r20 - this.R;
    L134:
        r39 = (r39 + 1) % this.e;
        if (r39 != r18) goto L119;
    L133:
        r20 = this.R + r19;
    L127:
        if (n() == true) goto L130;
        if (r20 < r21) goto L130;
    L122:
        r19 = r20 + r5;
        goto L124
    L22:
        r15 = this.R + r5;
        goto L23
    L18:
        r12 = r12 % this.e;
        goto L19
    L24:
        r16 = (getWidth() + r10) - r13;
        goto L25
    L30:
        int r41 = getPaddingRight() - this.N;
        int r42 = 0;
    L32:
        if (r42 >= (this.e - 1)) goto L37;
        int r43 = r42 + 1;
        if (r10 < ((getWidth() + (this.T - r41)) - (r43 * r11))) goto L38;
        r42 = r43;
    L38:
        r19 = (getWidth() + (this.T - r41)) - (r11 * r42);
        r18 = r42;
        goto L29
    L37:
        r42 = 0;
        goto L38
    L40:
        if (this.f18384n == false) goto L51;
        if (r10 >= 0) goto L50;
        if (r13 == 0) goto L44;
        r12 = r12 - 1;
    L44:
        int r44 = this.e;
        r18 = ((r12 % r44) + r44) % r44;
        if (r13 != 0) goto L47;
        int r45 = -this.R;
    L48:
        r20 = ((r10 - r45) - r13) - this.R;
    L49:
        r19 = 0;
        goto L60
    L47:
        r45 = r5;
        goto L48
    L50:
        r18 = r12 % this.e;
        r20 = r10 - r13;
        goto L49
    L51:
        int r46 = getPaddingLeft() + this.N;
        r18 = 0;
    L53:
        if (r18 >= this.e) goto L58;
        int r47 = r18 + 1;
        if (r10 < ((r47 * r11) + (this.S + r46))) goto L59;
        r18 = r47;
    L59:
        r20 = (r11 * r18) + (this.S + r46);
        goto L49
    L58:
        r18 = 0;
        goto L59
    L170:
        return;
    L169:
        return;
    }

    public final void q() {
        if (getChildCount() >= 1) goto L5;
        return;
    L5:
        View r5 = getCurrentView();
        int r10 = getScrollDistance();
        if (o() == false) goto L8;
        int r11 = r5.getTop();
    L9:
        int r12 = r11 - r10;
        if (o() == false) goto L12;
        int r13 = r5.getBottom();
    L13:
        int r14 = r13 - r10;
        boolean r15 = j();
        Scroller r16 = this.f18379i;
        if (r15 == false) goto L25;
        if (((d) r5.getLayoutParams()).f18367a != 0) goto L25;
        int r17 = getPile();
        if (o() == false) goto L21;
        r16.startScroll(0, r10, 0, (r14 + this.R) - r17, this.f18375e0);
    L39:
        setScrollState(2);
        invalidate();
        return;
    L21:
        if (this.f18385o == false) goto L23;
        int r18 = getPile();
        int r19 = getChildExpectSize() + r18;
        r16.startScroll(r10, 0, (r12 - this.R) - r19, 0, this.f18375e0);
        goto L39
    L23:
        r16.startScroll(r10, 0, (r14 + this.R) - r17, 0, this.f18375e0);
    L25:
        if (m() == true) goto L27;
    L35:
        int r20 = getPile();
        int r21 = (getChildExpectSize() / 2) + r20;
        int r22 = (r12 + r14) / 2;
        if (o() == false) goto L38;
        r16.startScroll(0, r10, 0, r22 - r21, this.f18389t);
        goto L39
    L38:
        r16.startScroll(r10, 0, r22 - r21, 0, this.f18389t);
        goto L39
    L27:
        if (((d) r5.getLayoutParams()).f18367a != (this.e - 1)) goto L35;
        int r23 = getPile();
        int r24 = getChildExpectSize() + r23;
        if (o() == false) goto L32;
        r16.startScroll(0, r10, 0, (r12 - this.R) - r24, this.f18375e0);
        goto L39
    L32:
        if (this.f18385o == false) goto L34;
        int r25 = getPile();
        r16.startScroll(r10, 0, (r14 + this.R) - r25, 0, this.f18375e0);
        goto L39
    L34:
        r16.startScroll(r10, 0, (r12 - this.R) - r24, 0, this.f18375e0);
        goto L39
    L12:
        r13 = r5.getRight();
        goto L13
    L8:
        r11 = r5.getLeft();
        goto L9
    }

    public final void r() {
        if (this.f18392w == null) goto L28;
        int r5 = getChildCount();
    L5:
        r5 = r5 - 1;
        if (r5 <= (-1)) goto L34;
        View r10 = getChildAt(r5);
        if (j() == false) goto L13;
        if (((d) r10.getLayoutParams()).f18367a == 0) goto L5;
    L13:
        if (m() == true) goto L15;
    L17:
        if (r10 == null) goto L5;
        if (n() == false) goto L22;
        int r11 = (getOffset() + (r10.getLeft() - getScrollX())) - getPaddingLeft();
    L26:
        this.f18392w.b(this, r10, o(), r11);
        goto L5
    L22:
        if (o() == false) goto L25;
        int r12 = (r10.getTop() - getScrollY()) - getOffset();
        int r13 = getPaddingTop();
    L24:
        r11 = r12 - r13;
        goto L26
    L25:
        r12 = (r10.getLeft() - getScrollX()) - getOffset();
        r13 = getPaddingLeft();
        goto L24
    L15:
        if (((d) r10.getLayoutParams()).f18367a != (this.e - 1)) goto L17;
    L34:
        return;
    }

    public final void s() {
        if (this.f18381k == false) goto L5;
        return;
    L5:
        if (this.f18380j == false) goto L7;
        return;
    L7:
        if (this.f18382l == true) goto L9;
    L11:
        boolean r5 = false;
    L12:
        Iterator r10 = this.U.iterator();
    L14:
        if (r10.hasNext() == false) goto L20;
        g r11 = (g) r10.next();
        int r12 = this.f;
        XSwiperUI r13 = r11.f18398c;
        if (r13.f10670c == false) goto L14;
        i r14 = new i(r13.getSign(), "scrollstart");
        r14.a("current", Integer.valueOf(r12));
        r14.a("isDragged", Boolean.valueOf(r5));
        XSwiperUI r15 = r11.f18398c;
        if (r15.getLynxContext() == null) goto L14;
        r15.getLynxContext().g.b(r14);
        goto L14
    L20:
        this.f18380j = true;
        return;
    L9:
        if (this.f18391v != 1) goto L11;
        r5 = true;
        goto L12
    }

    @Override // android.view.View
    public final void scrollTo(int r14, int r15) {
        int r5 = getChildExpectSize() + this.R;
        int r10 = this.e * r5;
        int r11 = getPaddingLeft() + this.N;
        boolean r12 = true;
        if (this.S != Integer.MIN_VALUE) goto L7;
        if (this.T != Integer.MAX_VALUE) goto L7;
    L14:
        boolean r13 = true;
    L15:
        this.O = r5;
        this.P = r10;
        this.Q = r11;
        if (r13 == false) goto L26;
        if (n() == false) goto L21;
        int r16 = getPaddingRight() - this.N;
        this.S = ((getChildExpectSize() + this.R) * (-(this.e - 1))) + r16;
        this.T = r16;
        goto L26
    L21:
        if (o() == false) goto L23;
        int r17 = getPaddingTop();
    L24:
        int r18 = r17 + this.N;
        this.S = -r18;
        this.T = ((getChildExpectSize() + this.R) * (this.e - 1)) - r18;
        goto L26
    L23:
        r17 = getPaddingLeft();
    L26:
        if (this.f18384n == false) goto L28;
    L79:
        super.scrollTo(r14, r15);
        int r19 = getChildExpectSize() + this.R;
        int r110 = this.e * r19;
        if (this.f18384n == false) goto L98;
        if (r110 <= 0) goto L98;
        if (r19 <= 0) goto L98;
        int r20 = getScrollDistance();
        if (n() == false) goto L91;
        int r21 = getPaddingRight() - this.N;
        int r22 = r20 - (r19 / 2);
        if (r22 < 0) goto L89;
        int r23 = r22 / r110;
        this.S = ((r23 * r110) + r19) + r21;
        this.T = ((r23 + 1) * r110) + r21;
        goto L98
    L89:
        this.S = (((-((Math.abs(r22) / r110) + 1)) * r110) + r19) + r21;
        this.T = ((-(Math.abs(r22) / r110)) * r110) + r21;
        goto L98
    L91:
        if (o() == false) goto L93;
        int r24 = getPaddingTop();
    L94:
        int r25 = r24 + this.N;
        int r26 = (r19 / 2) + r20;
        if (r26 < 0) goto L97;
        int r27 = r26 / r110;
        this.S = (r27 * r110) - r25;
        this.T = (((r27 + 1) * r110) - r19) - r25;
        goto L98
    L97:
        this.S = ((-((Math.abs(r26) / r110) + 1)) * r110) - r25;
        this.T = (((-(Math.abs(r26) / r110)) * r110) - r19) - r25;
        goto L98
    L93:
        r24 = getPaddingLeft();
    L98:
        p();
        boolean r111 = this.f18381k;
        ArrayList r112 = this.U;
        if (r111 == true) goto L122;
        if (this.f18380j == false) goto L122;
        if (this.f18382l == true) goto L105;
    L107:
        boolean r113 = false;
    L108:
        Iterator r28 = r112.iterator();
    L110:
        if (r28.hasNext() == false) goto L122;
        g r29 = (g) r28.next();
        float r30 = getScrollX();
        float r31 = getScrollY();
        r29.f18398c.recognizeGesturere();
        XSwiperUI r32 = r29.f18398c;
        if (r32.e == false) goto L110;
        long r33 = System.currentTimeMillis();
        long r34 = r33 - r32.f10682t;
        int r114 = r32.s;
        if (r114 <= 0) goto L118;
        if (r34 <= r114) goto L110;
    L118:
        r32.f10682t = r33;
        i r35 = new i(r32.getSign(), "transition");
        r35.a("current", Integer.valueOf(r29.f18397b.f18363a.getCurrentIndex()));
        r35.a("isDragged", Boolean.valueOf(r113));
        r35.a("dx", Float.valueOf(r30 / DisplayMetricsHolder.a().density));
        r35.a("dy", Float.valueOf(r31 / DisplayMetricsHolder.a().density));
        if (r32.getLynxContext() == null) goto L110;
        r32.getLynxContext().g.b(r35);
        goto L110
    L105:
        if (this.f18391v != 1) goto L107;
        r113 = true;
    L122:
        if (this.f18384n == false) goto L124;
        return;
    L124:
        if (this.W == false) goto L126;
    L127:
        q();
        if (this.f18371b0 == true) goto L142;
        boolean r115 = this.W;
        boolean r36 = this.f18369a0;
        if (this.f18381k == true) goto L142;
        if (this.f18380j == false) goto L142;
        Iterator r116 = r112.iterator();
    L135:
        if (r116.hasNext() == false) goto L142;
        g r37 = (g) r116.next();
        XSwiperUI r38 = r37.f18398c;
        if (r38.f == false) goto L135;
        i r39 = new i(r38.getSign(), "scrolltobounce");
        r39.a("isToBegin", Boolean.valueOf(r115));
        r39.a("isToEnd", Boolean.valueOf(r36));
        XSwiperUI r40 = r37.f18398c;
        if (r40.getLynxContext() == null) goto L135;
        r40.getLynxContext().g.b(r39);
    L142:
        if (this.W == false) goto L144;
    L147:
        this.f18371b0 = r12;
        this.W = false;
        this.f18369a0 = false;
        return;
    L144:
        if (this.f18369a0 == true) goto L147;
        r12 = false;
        goto L147
    L126:
        if (this.f18369a0 == false) goto L142;
    L28:
        if (o() == true) goto L30;
        int r41 = this.S;
        int r42 = this.T;
        if (j() == false) goto L55;
        if (this.f18385o == false) goto L53;
        r42 = (int) (this.T - (this.f18376f0 * (getChildExpectSize() + this.R)));
        goto L55
    L53:
        r41 = (int) ((this.f18376f0 * (getChildExpectSize() + this.R)) + this.S);
    L55:
        if (m() == false) goto L61;
        if (this.f18385o == false) goto L59;
        r41 = (int) ((this.g0 * (getChildExpectSize() + this.R)) + this.S);
        goto L61
    L59:
        r42 = (int) (this.T - (this.g0 * (getChildExpectSize() + this.R)));
    L61:
        if (j() == true) goto L63;
    L68:
        boolean r43 = false;
    L69:
        this.W = r43;
        if (m() == true) goto L72;
    L77:
        boolean r44 = false;
    L78:
        this.f18369a0 = r44;
        r14 = Math.min(Math.max(r14, r41), r42);
        goto L79
    L72:
        if (this.f18385o == false) goto L75;
        if (r14 > r41) goto L77;
    L76:
        r44 = true;
        goto L78
    L75:
        if (r14 < r42) goto L77;
    L63:
        if (this.f18385o == false) goto L66;
        if (r14 < r42) goto L68;
    L67:
        r43 = true;
        goto L69
    L66:
        if (r14 > r41) goto L68;
    L30:
        if (j() == false) goto L32;
        int r45 = (int) ((this.f18376f0 * (getChildExpectSize() + this.R)) + this.S);
    L34:
        if (m() == false) goto L36;
        int r46 = (int) (this.T - (this.g0 * (getChildExpectSize() + this.R)));
    L38:
        if (j() == false) goto L41;
        if (r15 > r45) goto L41;
        boolean r47 = true;
    L42:
        this.W = r47;
        if (m() == false) goto L46;
        if (r15 < r46) goto L46;
        boolean r48 = true;
    L47:
        this.f18369a0 = r48;
        r15 = Math.min(Math.max(r15, r45), r46);
    L46:
        r48 = false;
    L41:
        r47 = false;
        goto L42
    L36:
        r46 = this.T;
        goto L38
    L32:
        r45 = this.S;
    L7:
        if (this.O != r5) goto L14;
        if (this.P != r10) goto L14;
        if (this.Q != r11) goto L14;
        r13 = false;
        goto L15
    }

    public void setAdapter(c r5) {
        if (this.L == null) goto L11;
        int r10 = getChildCount();
    L5:
        r10 = r10 - 1;
        if (r10 <= (-1)) goto L12;
        View r11 = getChildAt(r10);
        e r12 = this.f18392w;
        if (r12 == null) goto L10;
        r12.a(r11);
    L10:
        removeView(r11);
        int r13 = ((d) r11.getLayoutParams()).f18367a;
        this.L.getClass();
    L12:
        this.L = r5;
        if (r5 != null) goto L15;
        return;
    L15:
        this.e = ((h) r5).f18399a.D.size();
        return;
    L11:
        removeAllViews();
        goto L12
    }

    public void setAnimDuration(int r5) {
        this.f18389t = r5;
    }

    public void setBounceBeginThreshold(float r5) {
        if (r5 > 0.0f) goto L5;
    L8:
        this.f18376f0 = -1.0f;
        return;
    L5:
        if (r5 >= 1.0f) goto L8;
        this.f18376f0 = 1.0f - r5;
    }

    public void setBounceDuration(int r5) {
        this.f18375e0 = r5;
    }

    public void setBounceEndThreshold(float r5) {
        if (r5 > 0.0f) goto L5;
    L8:
        this.g0 = -1.0f;
        return;
    L5:
        if (r5 >= 1.0f) goto L8;
        this.g0 = 1.0f - r5;
    }

    public void setEnableBounce(boolean r5) {
        this.V = r5;
    }

    public void setEnableNestedChild(boolean r5) {
        this.f18383m = r5;
    }

    public void setEnableViceLoop(boolean r5) {
        this.f18388r = r5;
    }

    public void setForceCanScroll(boolean r5) {
        this.f18387q = r5;
    }

    public void setHLayoutUpdated(boolean r5) {
        if (this.f18370b == false) goto L5;
        return;
    L5:
        this.f18370b = r5;
    }

    public void setHandleGesture(boolean r5) {
        this.f18374d0 = r5;
    }

    public void setIgnoreLayoutUpdate(boolean r5) {
        this.f18373c0 = r5;
    }

    public void setIsRTL(boolean r5) {
        this.f18385o = r5;
    }

    public void setKeepItemView(boolean r5) {
        this.f18386p = r5;
    }

    public void setLoop(boolean r5) {
        this.f18384n = r5;
        if (this.f18388r == true) goto L5;
        return;
    L5:
        if (this.L != null) goto L7;
        return;
    L7:
        if (this.e > 1) goto L9;
        return;
    L9:
        if (this.f == (-1)) goto L15;
        requestLayout();
        return;
    }

    public void setOrientation(int r5) {
        this.f18390u = r5;
    }

    @Override // android.view.View
    public final void setPadding(int r5, int r10, int r11, int r12) {
        int r13 = getPaddingLeft();
        super.setPadding(r5, r10, r11, r12);
        if (o() == false) goto L6;
        scrollBy(0, r13 - r5);
        return;
    L6:
        scrollBy(r13 - r5, 0);
    }

    public void setPageMargin(int r5) {
        if (r5 >= 0) goto L4;
        r5 = 0;
    L4:
        this.R = r5;
    }

    public void setPageSize(int r5) {
        this.M = r5;
    }

    public void setPropsUpdated(boolean r5) {
        if (this.d == false) goto L5;
        return;
    L5:
        this.d = r5;
    }

    public void setTouchable(boolean r5) {
        this.f18382l = r5;
    }

    public void setTransformer(e r5) {
        if (this.f18392w == null) goto L8;
        int r10 = getChildCount();
    L5:
        r10 = r10 - 1;
        if (r10 <= (-1)) goto L8;
        this.f18392w.a(getChildAt(r10));
    L8:
        this.f18392w = r5;
        r();
    }

    public void setVLayoutUpdated(boolean r5) {
        if (this.f18372c == false) goto L5;
        return;
    L5:
        this.f18372c = r5;
    }
}
