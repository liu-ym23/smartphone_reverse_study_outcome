package com.bytedance.android.live.ktv.common.view;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Transformation;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.ViewCompat;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class KSongSwipeRefreshLayout extends ViewGroup {
    public static final int[] A = null;
    public View a;
    public int b;
    public int c;
    public boolean d;
    public final int e;
    public float f;
    public final int g;
    public int h;
    public float i;
    public float j;
    public boolean k;
    public int l;
    public boolean m;
    public final DecelerateInterpolator n;
    public View o;
    public int p;
    public STATUS q;
    public boolean r;
    public final boolean s;
    public final a t;
    public final b u;
    public final c v;
    public final d w;
    public final e x;
    public final f y;
    public final g z;

    public static final enum STATUS extends Enum<STATUS> {
        public static final STATUS LOOSEN = null;
        public static final STATUS NORMAL = null;
        public static final STATUS REFRESHING = null;
        public static final /* synthetic */ STATUS[] a = null;

        static {
            STATUS r0 = new STATUS("NORMAL", 0);
            NORMAL = r0;
            STATUS r1 = new STATUS("LOOSEN", 1);
            LOOSEN = r1;
            STATUS r3 = new STATUS("REFRESHING", 2);
            REFRESHING = r3;
            a = new STATUS[]{r0, r1, r3};
        }

        public static STATUS[] values() {
            return (STATUS[]) a.clone();
        }

        public static STATUS valueOf(String r1) {
            return (STATUS) r27.a.a(STATUS.class, r1);
        }

        public STATUS(String r1, int r2) {
            super(r1, r2);
        }
    }

    public class a extends Animation {
        public final /* synthetic */ KSongSwipeRefreshLayout a;

        public a(KSongSwipeRefreshLayout r1) {
            this.a = r1;
        }

        @Override // android.view.animation.Animation
        public final void applyTransformation(float r4, Transformation r5) {
            KSongSwipeRefreshLayout r6 = this.a;
            int r0 = r6.c;
            int r1 = r6.b;
            if (r0 == r1) goto L5;
            int r2 = r0 + ((int) ((r1 - r0) * r4));
        L6:
            int r3 = r2 - r6.a.getTop();
            int r7 = this.a.a.getTop();
            if ((r3 + r7) >= 0) goto L9;
            r3 = 0 - r7;
        L9:
            KSongSwipeRefreshLayout.b(this.a, r3);
            return;
        L5:
            r2 = 0;
            goto L6
        }
    }

    public class b extends Animation {
        public final /* synthetic */ KSongSwipeRefreshLayout a;

        public b(KSongSwipeRefreshLayout r1) {
            this.a = r1;
        }

        @Override // android.view.animation.Animation
        public final void applyTransformation(float r4, Transformation r5) {
            KSongSwipeRefreshLayout r6 = this.a;
            int r0 = r6.c;
            int r1 = r6.p;
            if (r0 == r1) goto L5;
            int r2 = r0 + ((int) ((r1 - r0) * r4));
        L6:
            int r3 = r2 - r6.a.getTop();
            int r7 = this.a.a.getTop();
            if ((r3 + r7) >= 0) goto L9;
            r3 = 0 - r7;
        L9:
            KSongSwipeRefreshLayout.b(this.a, r3);
            return;
        L5:
            r2 = 0;
            goto L6
        }
    }

    public class c extends i {
        public final /* synthetic */ KSongSwipeRefreshLayout a;

        public c(KSongSwipeRefreshLayout r1) {
            this.a = r1;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationEnd(Animation r3) {
            KSongSwipeRefreshLayout r4 = this.a;
            r4.h = 0;
            r4.q = STATUS.NORMAL;
            r4.r = false;
            r4.getClass();
        }
    }

    public class d extends i {
        public final /* synthetic */ KSongSwipeRefreshLayout a;

        public d(KSongSwipeRefreshLayout r1) {
            this.a = r1;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationEnd(Animation r2) {
            KSongSwipeRefreshLayout r3 = this.a;
            r3.h = r3.p;
            r3.q = STATUS.REFRESHING;
        }
    }

    public class e implements Runnable {
        public final /* synthetic */ KSongSwipeRefreshLayout a;

        @Override // java.lang.Runnable
        public final void run() {
            View r0 = this.a.o;     // Catch: Throwable -> L7
            if (r0 == null) goto L5;
            r0.setVisibility(8);     // Catch: Throwable -> L7
        L5:
            KSongSwipeRefreshLayout r1 = this.a;     // Catch: Throwable -> L7
            r1.m = true;     // Catch: Throwable -> L7
            KSongSwipeRefreshLayout.a(r1, r1.h + r1.getPaddingTop(), this.a.v);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L11;
            return;
        L11:
            throw th;
        }

        public e(KSongSwipeRefreshLayout r1) {
            this.a = r1;
        }
    }

    public class f implements Runnable {
        public final /* synthetic */ KSongSwipeRefreshLayout a;

        public final void a() {
            KSongSwipeRefreshLayout r0 = this.a;
            r0.m = true;
            int r1 = r0.h + r0.getPaddingTop();
            d r2 = this.a.w;
            r0.c = r1;
            r0.u.reset();
            r0.u.setDuration(r0.g);
            r0.u.setAnimationListener(r2);
            r0.u.setInterpolator(r0.n);
            r0.a.startAnimation(r0.u);
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

        public f(KSongSwipeRefreshLayout r1) {
            this.a = r1;
        }
    }

    public class g implements Runnable {
        public final /* synthetic */ KSongSwipeRefreshLayout a;

        @Override // java.lang.Runnable
        public final void run() {
            KSongSwipeRefreshLayout r0 = this.a;     // Catch: Throwable -> L4
            r0.m = true;     // Catch: Throwable -> L4
            KSongSwipeRefreshLayout.a(r0, r0.h + r0.getPaddingTop(), this.a.v);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public g(KSongSwipeRefreshLayout r1) {
            this.a = r1;
        }
    }

    public class h implements View.OnTouchListener {
        public final /* synthetic */ KSongSwipeRefreshLayout a;

        public h(KSongSwipeRefreshLayout r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View r1, MotionEvent r2) {
            return this.a.r;
        }
    }

    public class i implements Animation.AnimationListener {
        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationRepeat(Animation r1) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationStart(Animation r1) {
        }

        public i() {
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestDisallowInterceptTouchEvent(boolean r1) {
    }

    static {
        A = new int[]{R.attr.enabled};
    }

    public final void c() {
        if (this.a != null) goto L13;
        if (getChildCount() > 2) goto L7;
    L11:
        View r0 = getChildAt(1);
        this.a = r0;
        r0.setOnTouchListener(new h(this));
        this.b = this.a.getTop() + getPaddingTop();
        goto L13
    L7:
        if (isInEditMode() == true) goto L11;
        throw new IllegalStateException("SwipeRefreshLayout can only host two children");
    L13:
        if (this.f == (-1.0f)) goto L15;
        return;
    L15:
        if (getParent() != null) goto L17;
        return;
    L17:
        if (((View) getParent()).getHeight() <= 0) goto L22;
        Resources r1 = getResources();
        this.f = (int) Math.min(((View) getParent()).getHeight() * 0.6f, WindowDisplayMetricsOverride.apply(r1, r1.getDisplayMetrics()).density * 120.0f);
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        removeCallbacks(this.z);
        removeCallbacks(this.x);
        removeCallbacks(this.y);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.x);
        removeCallbacks(this.z);
        removeCallbacks(this.y);
    }

    public KSongSwipeRefreshLayout(Context r2) {
        this(r2, null);
    }

    private void setTargetOffsetTopAndBottom(int r2) {
        this.a.offsetTopAndBottom(r2);
        this.o.offsetTopAndBottom(r2);
        this.h = this.a.getTop();
        invalidate();
    }

    public final void d(MotionEvent r4) {
        int r0 = MotionEventCompat.getActionIndex(r4);
        if (MotionEventCompat.getPointerId(r4, r0) != this.l) goto L9;
        if (r0 != 0) goto L6;
        int r1 = 1;
    L7:
        this.j = MotionEventCompat.getY(r4, r1);
        this.l = MotionEventCompat.getPointerId(r4, r1);
        return;
    L6:
        r1 = 0;
        goto L7
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r6) {
        c();
        int r0 = MotionEventCompat.getActionMasked(r6);
        if (this.m == false) goto L7;
        if (r0 != 0) goto L7;
        this.m = false;
    L7:
        if (isEnabled() == true) goto L9;
    L39:
        return false;
    L9:
        if (this.m == true) goto L39;
        if (ViewCompat.canScrollVertically(this.a, -1) == true) goto L39;
        if (this.q == STATUS.REFRESHING) goto L39;
        if (r0 == 0) goto L36;
        if (r0 != 1) goto L19;
    L35:
        getParent().requestDisallowInterceptTouchEvent(false);
        this.k = false;
        this.l = -1;
    L38:
        return this.k;
    L19:
        if (r0 != 2) goto L21;
        int r1 = this.l;
        if (r1 != (-1)) goto L29;
        return false;
    L29:
        int r2 = MotionEventCompat.findPointerIndex(r6, r1);
        if (r2 >= 0) goto L32;
        return false;
    L32:
        float r7 = MotionEventCompat.getY(r6, r2);
        if ((r7 - this.i) <= this.e) goto L38;
        this.j = r7;
        this.k = true;
        goto L38
    L21:
        if (r0 == 3) goto L35;
        if (r0 != 6) goto L38;
        d(r6);
        goto L38
    L36:
        getParent().requestDisallowInterceptTouchEvent(true);
        float r3 = r6.getY();
        this.i = r3;
        this.j = r3;
        this.l = MotionEventCompat.getPointerId(r6, 0);
        this.k = false;
        goto L38
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r9) {
        int r1 = 0;
        if (this.s == true) goto L5;
        return false;
    L5:
        int r0 = MotionEventCompat.getActionMasked(r9);
        if (this.m == false) goto L10;
        if (r0 != 0) goto L10;
        this.m = false;
    L10:
        if (isEnabled() == true) goto L12;
    L80:
        return false;
    L12:
        if (this.m == true) goto L80;
        if (ViewCompat.canScrollVertically(this.a, -1) == true) goto L80;
        STATUS r2 = this.q;
        if (r2 == STATUS.REFRESHING) goto L80;
        if (r0 != 0) goto L21;
        float r3 = r9.getY();
        this.i = r3;
        this.j = r3;
        this.l = MotionEventCompat.getPointerId(r9, 0);
        this.k = false;
    L79:
        return true;
    L21:
        if (r0 == 1) goto L73;
        if (r0 != 2) goto L25;
        this.o.setVisibility(0);
        int r4 = MotionEventCompat.findPointerIndex(r9, this.l);
        if (r4 >= 0) goto L38;
        return false;
    L38:
        float r11 = MotionEventCompat.getY(r9, r4);
        float r5 = r11 - this.i;
        if (this.k == true) goto L44;
        if (r5 <= this.e) goto L44;
        this.k = true;
    L44:
        if (this.k == false) goto L79;
        if (r5 <= this.f) goto L58;
        if (this.q != STATUS.NORMAL) goto L50;
        this.q = STATUS.LOOSEN;
    L50:
        int r6 = (int) r5;
        int r7 = this.a.getTop();
        float r8 = r6;
        float r12 = this.f;
        if (r8 <= r12) goto L53;
        r1 = (((int) (r8 - r12)) / 2) + ((int) r12);
    L56:
        setTargetOffsetTopAndBottom(r1 - r7);
    L71:
        this.j = r11;
        goto L79
    L53:
        if (r6 < 0) goto L56;
        r1 = r6;
        goto L56
    L58:
        if (this.q != STATUS.LOOSEN) goto L60;
        this.q = STATUS.NORMAL;
    L60:
        int r13 = (int) r5;
        int r14 = this.a.getTop();
        float r15 = r13;
        float r16 = this.f;
        if (r15 <= r16) goto L63;
        r1 = (((int) (r15 - r16)) / 2) + ((int) r16);
    L66:
        setTargetOffsetTopAndBottom(r1 - r14);
        if (this.j <= r11) goto L71;
        if (this.a.getTop() != getPaddingTop()) goto L71;
        removeCallbacks(this.z);
        goto L71
    L63:
        if (r13 < 0) goto L66;
        r1 = r13;
        goto L66
    L25:
        if (r0 != 3) goto L27;
        removeCallbacks(this.z);
        postDelayed(this.z, 300);
        this.k = false;
        this.l = -1;
        return false;
    L27:
        if (r0 != 5) goto L29;
        int r17 = MotionEventCompat.getActionIndex(r9);
        this.j = MotionEventCompat.getY(r9, r17);
        this.l = MotionEventCompat.getPointerId(r9, r17);
        goto L79
    L29:
        if (r0 != 6) goto L79;
        d(r9);
        goto L79
    L73:
        if (r2 != STATUS.LOOSEN) goto L75;
        removeCallbacks(this.z);
        this.y.run();
        setRefreshing(true);
        this.r = true;
    L76:
        this.k = false;
        this.l = -1;
        return false;
    L75:
        removeCallbacks(this.z);
        postDelayed(this.z, 300);
        goto L76
    }

    public void setRefreshing(boolean r2) {
        if (this.d == r2) goto L6;
        c();
        this.d = r2;
        return;
    }

    public KSongSwipeRefreshLayout(Context r5, AttributeSet r6) {
        super(r5, r6);
        this.d = false;
        this.f = -1.0f;
        this.l = -1;
        this.q = STATUS.NORMAL;
        this.s = true;
        this.t = new a(this);
        this.u = new b(this);
        this.v = new c(this);
        this.w = new d(this);
        this.x = new e(this);
        this.y = new f(this);
        this.z = new g(this);
        this.e = ViewConfiguration.get(r5).getScaledTouchSlop() - 10;
        this.g = getResources().getInteger(R.integer.config_mediumAnimTime);
        this.n = new DecelerateInterpolator(2.0f);
        TypedArray r7 = r5.obtainStyledAttributes(r6, A);
        setEnabled(r7.getBoolean(0, true));
        r7.recycle();
    }

    public static /* synthetic */ void b(KSongSwipeRefreshLayout r0, int r1) {
        r0.setTargetOffsetTopAndBottom(r1);
    }

    @Override // android.view.View
    public final void onMeasure(int r4, int r5) {
        super.onMeasure(r4, r5);
        if (getChildCount() <= 0) goto L17;
        if (getChildCount() <= 2) goto L12;
        if (isInEditMode() == true) goto L12;
        throw new IllegalStateException("SwipeRefreshLayout can only host two children");
    L12:
        if (this.o != null) goto L14;
        View r0 = getChildAt(0);
        this.o = r0;
        measureChild(r0, r4, r5);
        int r6 = this.o.getMeasuredHeight();
        this.p = r6;
        this.f = r6;
    L14:
        getChildAt(1).measure(View.MeasureSpec.makeMeasureSpec((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), 1073741824), View.MeasureSpec.makeMeasureSpec((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), 1073741824));
        return;
    L17:
        throw new IllegalStateException("SwipeRefreshLayout must have the headerview and contentview");
    }

    public static void a(KSongSwipeRefreshLayout r2, int r3, c r4) {
        r2.c = r3;
        r2.t.reset();
        r2.t.setDuration(r2.g);
        r2.t.setAnimationListener(r4);
        r2.t.setInterpolator(r2.n);
        r2.a.startAnimation(r2.t);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r2, int r3, int r4, int r5, int r6) {
        int r7 = getMeasuredWidth();
        int r8 = getMeasuredHeight();
        if (getChildCount() != 0) goto L5;
        return;
    L5:
        if (getChildCount() == 1) goto L10;
        View r9 = getChildAt(1);
        int r11 = getPaddingLeft();
        int r12 = this.h + getPaddingTop();
        int r13 = (r7 - getPaddingLeft()) - getPaddingRight();
        int r14 = r13 + r11;
        r9.layout(r11, r12, r14, ((r8 - getPaddingTop()) - getPaddingBottom()) + r12);
        this.o.layout(r11, r12 - this.p, r14, r12);
        return;
    }
}
