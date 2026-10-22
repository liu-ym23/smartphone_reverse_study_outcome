package com.bytedance.android.live.liveinteract.linkpanel.list;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
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
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0004\u0019\u001a\u001b\u001cB\u001d\b\u0007\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tR*\u0010\u000f\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00068\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/live/liveinteract/linkpanel/list/BaseRefreshLayout;", "Landroid/view/ViewGroup;", "", "offset", "", "setTargetOffsetTopAndBottom", "", "mIsDisable", "setmIsDisable", "Lcom/bytedance/android/live/liveinteract/linkpanel/list/BaseRefreshLayout$c;", "listener", "setOnRefreshListener", "refreshing", "e", "Z", "isRefreshing", "()Z", "setRefreshing", "(Z)V", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "a", "b", "c", "STATUS", "multilink-business-platform_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class BaseRefreshLayout extends ViewGroup {
    public static final int[] D = null;
    public final j A;
    public final h B;
    public final g C;
    public View a;
    public int b;
    public c c;
    public int d;
    public boolean e;
    public final int f;
    public float g;
    public final int h;
    public int i;
    public float j;
    public float k;
    public boolean l;
    public int m;
    public boolean n;
    public final DecelerateInterpolator o;
    public View p;
    public int q;
    public STATUS r;
    public boolean s;
    public boolean t;
    public float u;
    public float v;
    public final f w;
    public final e x;
    public final k y;
    public final i z;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/liveinteract/linkpanel/list/BaseRefreshLayout$STATUS;", "", "NORMAL", "LOOSEN", "REFRESHING", "multilink-business-platform_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum STATUS extends Enum<STATUS> {
        public static final STATUS LOOSEN = null;
        public static final STATUS NORMAL = null;
        public static final STATUS REFRESHING = null;
        public static final /* synthetic */ STATUS[] a = null;

        static {
            STATUS r1 = new STATUS("NORMAL", 0);
            NORMAL = r1;
            STATUS r2 = new STATUS("LOOSEN", 1);
            LOOSEN = r2;
            STATUS r3 = new STATUS("REFRESHING", 2);
            REFRESHING = r3;
            a = new STATUS[]{r1, r2, r3};
        }

        public static STATUS valueOf(String r1) {
            return (STATUS) r27.a.a(STATUS.class, r1);
        }

        public static STATUS[] values() {
            return (STATUS[]) a.clone();
        }

        public STATUS(String r1, int r2) {
            super(r1, r2);
        }
    }

    public class a implements Animation.AnimationListener {
        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationRepeat(Animation r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationStart(Animation r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
        }

        public a() {
        }
    }

    public static final class b {
    }

    public interface c {
        void onFinish();

        void onRefresh();

        void y0();

        void z1();
    }

    public static final class d implements View.OnTouchListener {
        public final /* synthetic */ BaseRefreshLayout a;

        public d(BaseRefreshLayout r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View r1, MotionEvent r2) {
            return this.a.s;
        }
    }

    public static final class e extends Animation {
        public final /* synthetic */ BaseRefreshLayout a;

        public e(BaseRefreshLayout r1) {
            this.a = r1;
        }

        @Override // android.view.animation.Animation
        public final void applyTransformation(float r4, Transformation r5) {
            Intrinsics.checkNotNullParameter(r5, "t");
            BaseRefreshLayout r6 = this.a;
            int r0 = r6.d;
            int r1 = r6.q;
            if (r0 == r1) goto L5;
            int r2 = r0 + ((int) ((r1 - r0) * r4));
        L6:
            View r7 = r6.a;
            Intrinsics.checkNotNull(r7);
            int r3 = r2 - r7.getTop();
            View r8 = this.a.a;
            Intrinsics.checkNotNull(r8);
            int r9 = r8.getTop();
            if ((r3 + r9) >= 0) goto L9;
            r3 = 0 - r9;
        L9:
            BaseRefreshLayout.b(this.a, r3);
            return;
        L5:
            r2 = 0;
            goto L6
        }
    }

    public static final class f extends Animation {
        public final /* synthetic */ BaseRefreshLayout a;

        public f(BaseRefreshLayout r1) {
            this.a = r1;
        }

        @Override // android.view.animation.Animation
        public final void applyTransformation(float r4, Transformation r5) {
            Intrinsics.checkNotNullParameter(r5, "t");
            BaseRefreshLayout r6 = this.a;
            int r0 = r6.d;
            int r1 = r6.b;
            if (r0 == r1) goto L5;
            int r2 = r0 + ((int) ((r1 - r0) * r4));
        L6:
            View r7 = r6.a;
            Intrinsics.checkNotNull(r7);
            int r3 = r2 - r7.getTop();
            View r8 = this.a.a;
            Intrinsics.checkNotNull(r8);
            int r9 = r8.getTop();
            if ((r3 + r9) >= 0) goto L9;
            r3 = 0 - r9;
        L9:
            BaseRefreshLayout.b(this.a, r3);
            return;
        L5:
            r2 = 0;
            goto L6
        }
    }

    public static final class g implements Runnable {
        public final /* synthetic */ BaseRefreshLayout a;

        public g(BaseRefreshLayout r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            BaseRefreshLayout r0 = this.a;     // Catch: Throwable -> L4
            r0.n = true;     // Catch: Throwable -> L4
            BaseRefreshLayout.a(r0, r0.i + r0.getPaddingTop(), this.a.y);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class h implements Runnable {
        public final /* synthetic */ BaseRefreshLayout a;

        public h(BaseRefreshLayout r1) {
            this.a = r1;
        }

        public final void a() {
            BaseRefreshLayout r0 = this.a;
            r0.n = true;
            int r1 = r0.i + r0.getPaddingTop();
            i r2 = this.a.z;
            r0.d = r1;
            r0.x.reset();
            r0.x.setDuration(r0.h);
            r0.x.setAnimationListener(r2);
            r0.x.setInterpolator(r0.o);
            View r3 = r0.a;
            Intrinsics.checkNotNull(r3);
            r3.startAnimation(r0.x);
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
    }

    public static final class i extends a {
        public final /* synthetic */ BaseRefreshLayout a;

        public i(BaseRefreshLayout r1) {
            this.a = r1;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationEnd(Animation r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            BaseRefreshLayout r3 = this.a;
            r3.i = r3.q;
            r3.r = STATUS.REFRESHING;
        }
    }

    public static final class j implements Runnable {
        public final /* synthetic */ BaseRefreshLayout a;

        public j(BaseRefreshLayout r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            BaseRefreshLayout r0 = this.a;     // Catch: Throwable -> L4
            r0.n = true;     // Catch: Throwable -> L4
            BaseRefreshLayout.a(r0, r0.i + r0.getPaddingTop(), this.a.y);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class k extends a {
        public final /* synthetic */ BaseRefreshLayout a;

        public k(BaseRefreshLayout r1) {
            this.a = r1;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationEnd(Animation r3) {
            Intrinsics.checkNotNullParameter(r3, "animation");
            BaseRefreshLayout r4 = this.a;
            r4.i = 0;
            r4.r = STATUS.NORMAL;
            r4.s = false;
            c r5 = r4.c;
            Intrinsics.checkNotNull(r5);
            r5.onFinish();
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestDisallowInterceptTouchEvent(boolean r1) {
    }

    static {
        D = new int[]{R.attr.enabled};
    }

    public final void c() {
        if (this.a != null) goto L16;
        if (getChildCount() > 2) goto L7;
    L10:
        boolean r0 = true;
    L11:
        if (r0 == false) goto L14;
        View r1 = getChildAt(1);
        this.a = r1;
        Intrinsics.checkNotNull(r1);
        r1.setOnTouchListener(new d(this));
        View r2 = this.a;
        Intrinsics.checkNotNull(r2);
        this.b = r2.getTop() + getPaddingTop();
        goto L16
    L14:
        throw new IllegalStateException("SwipeRefreshLayout can only host two children".toString());
    L7:
        if (isInEditMode() == true) goto L10;
        r0 = false;
    L16:
        if (this.g == (-1.0f)) goto L18;
        return;
    L18:
        if (getParent() == null) goto L31;
        Object r3 = getParent();
        if (r3 == null) goto L29;
        if (((View) r3).getHeight() <= 0) goto L32;
        Resources r4 = getResources();
        DisplayMetrics r5 = WindowDisplayMetricsOverride.apply(r4, r4.getDisplayMetrics());
        Object r6 = getParent();
        if (r6 == null) goto L27;
        this.g = (int) Math.min(((View) r6).getHeight() * 0.6f, 120 * r5.density);
        return;
    L27:
        throw new NullPointerException("null cannot be cast to non-null type android.view.View");
    L32:
        return;
    L29:
        throw new NullPointerException("null cannot be cast to non-null type android.view.View");
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        removeCallbacks(this.C);
        removeCallbacks(this.A);
        removeCallbacks(this.B);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.A);
        removeCallbacks(this.C);
        removeCallbacks(this.B);
    }

    public BaseRefreshLayout(Context r2) {
        this(r2, null);
    }

    private final void setTargetOffsetTopAndBottom(int r2) {
        View r0 = this.a;
        Intrinsics.checkNotNull(r0);
        r0.offsetTopAndBottom(r2);
        View r1 = this.p;
        Intrinsics.checkNotNull(r1);
        r1.offsetTopAndBottom(r2);
        View r3 = this.a;
        Intrinsics.checkNotNull(r3);
        this.i = r3.getTop();
        invalidate();
    }

    public final void d(MotionEvent r4) {
        int r0 = MotionEventCompat.getActionIndex(r4);
        if (MotionEventCompat.getPointerId(r4, r0) != this.m) goto L9;
        if (r0 != 0) goto L6;
        int r1 = 1;
    L7:
        this.k = MotionEventCompat.getY(r4, r1);
        this.m = MotionEventCompat.getPointerId(r4, r1);
        return;
    L6:
        r1 = 0;
        goto L7
    }

    public final void e(int r5) {
        View r0 = this.a;
        Intrinsics.checkNotNull(r0);
        int r1 = r0.getTop();
        float r2 = r5;
        float r3 = this.g;
        if (r2 <= r3) goto L5;
        r5 = ((int) r3) + (((int) (r2 - r3)) / 2);
    L7:
        setTargetOffsetTopAndBottom(r5 - r1);
        return;
    L5:
        if (r5 >= 0) goto L7;
        r5 = 0;
        goto L7
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r7) {
        Intrinsics.checkNotNullParameter(r7, "ev");
        boolean r1 = false;
        if (this.t == false) goto L5;
        return false;
    L5:
        c();
        int r0 = MotionEventCompat.getActionMasked(r7);
        if (this.n == false) goto L10;
        if (r0 != 0) goto L10;
        this.n = false;
    L10:
        if (isEnabled() == true) goto L12;
    L44:
        return false;
    L12:
        if (this.n == true) goto L44;
        View r2 = this.a;
        Intrinsics.checkNotNull(r2);
        if (ViewCompat.canScrollVertically(r2, -1) == true) goto L44;
        if (r0 != 0) goto L18;
        float r3 = r7.getY();
        this.j = r3;
        this.k = r3;
        r7.getX();
        this.m = MotionEventCompat.getPointerId(r7, 0);
        this.l = false;
        this.u = r7.getX();
        this.v = r7.getY();
    L42:
        this.u = r7.getX();
        this.v = r7.getY();
        return this.l;
    L18:
        if (r0 != 1) goto L20;
    L40:
        this.l = false;
        this.m = -1;
        goto L42
    L20:
        if (r0 != 2) goto L22;
        int r4 = this.m;
        if (r4 != (-1)) goto L30;
        return false;
    L30:
        int r5 = MotionEventCompat.findPointerIndex(r7, r4);
        if (r5 >= 0) goto L33;
        return false;
    L33:
        float r6 = MotionEventCompat.getY(r7, r5);
        MotionEventCompat.getX(r7, r5);
        if ((r6 - this.j) <= this.f) goto L42;
        if (Math.abs(r7.getX() - this.u) >= Math.abs(r7.getY() - this.v)) goto L38;
        r1 = true;
    L38:
        if (r1 == false) goto L42;
        this.k = r6;
        this.l = true;
        goto L42
    L22:
        if (r0 == 3) goto L40;
        if (r0 != 6) goto L42;
        d(r7);
        goto L42
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r8) {
        Intrinsics.checkNotNullParameter(r8, "ev");
        if (this.t == false) goto L5;
        return true;
    L5:
        int r0 = MotionEventCompat.getActionMasked(r8);
        if (this.n == false) goto L10;
        if (r0 != 0) goto L10;
        this.n = false;
    L10:
        if (isEnabled() == true) goto L12;
    L72:
        return false;
    L12:
        if (this.n == true) goto L72;
        View r2 = this.a;
        Intrinsics.checkNotNull(r2);
        if (ViewCompat.canScrollVertically(r2, -1) == true) goto L72;
        if (r0 != 0) goto L18;
        float r1 = r8.getY();
        this.j = r1;
        this.k = r1;
        this.m = MotionEventCompat.getPointerId(r8, 0);
        this.l = false;
    L71:
        return true;
    L18:
        if (r0 == 1) goto L63;
        if (r0 != 2) goto L22;
        int r3 = MotionEventCompat.findPointerIndex(r8, this.m);
        if (r3 >= 0) goto L35;
        return false;
    L35:
        float r9 = MotionEventCompat.getY(r8, r3);
        float r4 = r9 - this.j;
        if (this.l == true) goto L41;
        if (r4 <= this.f) goto L41;
        this.l = true;
    L41:
        if (this.l == false) goto L71;
        c r5 = this.c;
        if (r5 == null) goto L46;
        Intrinsics.checkNotNull(r5);
        r5.z1();
    L46:
        if (r4 <= this.g) goto L54;
        if (this.r != STATUS.NORMAL) goto L52;
        this.r = STATUS.LOOSEN;
        c r6 = this.c;
        if (r6 == null) goto L52;
        Intrinsics.checkNotNull(r6);
        r6.y0();
    L52:
        e((int) r4);
    L61:
        this.k = r9;
        goto L71
    L54:
        if (this.r != STATUS.LOOSEN) goto L56;
        this.r = STATUS.NORMAL;
    L56:
        e((int) r4);
        if (this.k <= r9) goto L61;
        View r7 = this.a;
        Intrinsics.checkNotNull(r7);
        if (r7.getTop() != getPaddingTop()) goto L61;
        removeCallbacks(this.C);
        goto L61
    L22:
        if (r0 != 3) goto L24;
        removeCallbacks(this.C);
        postDelayed(this.C, 300);
        this.l = false;
        this.m = -1;
        return false;
    L24:
        if (r0 != 5) goto L26;
        int r10 = MotionEventCompat.getActionIndex(r8);
        this.k = MotionEventCompat.getY(r8, r10);
        this.m = MotionEventCompat.getPointerId(r8, r10);
        goto L71
    L26:
        if (r0 != 6) goto L71;
        d(r8);
        goto L71
    L63:
        if (this.r != STATUS.LOOSEN) goto L67;
        removeCallbacks(this.C);
        this.B.run();
        setRefreshing(true);
        this.s = true;
        c r11 = this.c;
        if (r11 == null) goto L68;
        Intrinsics.checkNotNull(r11);
        r11.onRefresh();
    L68:
        this.l = false;
        this.m = -1;
        return false;
    L67:
        removeCallbacks(this.C);
        postDelayed(this.C, 300);
        goto L68
    }

    public final void setOnRefreshListener(c r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.c = r2;
    }

    public final void setRefreshing(boolean r2) {
        if (this.e == r2) goto L6;
        c();
        this.e = r2;
        return;
    }

    public final void setmIsDisable(boolean r1) {
        this.t = r1;
    }

    public BaseRefreshLayout(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, r4);
        this.g = -1.0f;
        this.m = -1;
        this.r = STATUS.NORMAL;
        this.w = new f(this);
        this.x = new e(this);
        this.y = new k(this);
        this.z = new i(this);
        this.A = new j(this);
        this.B = new h(this);
        this.C = new g(this);
        this.f = ViewConfiguration.get(r3).getScaledTouchSlop();
        this.h = getResources().getInteger(R.integer.config_mediumAnimTime);
        this.o = new DecelerateInterpolator(2.0f);
        TypedArray r5 = r3.obtainStyledAttributes(r4, D);
        setEnabled(r5.getBoolean(0, true));
        r5.recycle();
    }

    public static final /* synthetic */ void b(BaseRefreshLayout r0, int r1) {
        r0.setTargetOffsetTopAndBottom(r1);
    }

    @Override // android.view.View
    public final void onMeasure(int r5, int r6) {
        super.onMeasure(r5, r6);
        if (getChildCount() <= 1) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L23;
        if (getChildCount() > 2) goto L10;
    L13:
        boolean r1 = true;
    L14:
        if (r1 == false) goto L21;
        if (this.p != null) goto L18;
        View r2 = getChildAt(0);
        this.p = r2;
        measureChild(r2, r5, r6);
        View r7 = this.p;
        Intrinsics.checkNotNull(r7);
        int r8 = r7.getMeasuredHeight();
        this.q = r8;
        this.g = r8;
    L18:
        getChildAt(1).measure(View.MeasureSpec.makeMeasureSpec((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), 1073741824), View.MeasureSpec.makeMeasureSpec((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), 1073741824));
        return;
    L21:
        throw new IllegalStateException("SwipeRefreshLayout can only host two children".toString());
    L10:
        if (isInEditMode() == true) goto L13;
        r1 = false;
        goto L14
    L23:
        throw new IllegalStateException("SwipeRefreshLayout must have the headerview and contentview".toString());
    L5:
        r0 = false;
        goto L6
    }

    public static final void a(BaseRefreshLayout r2, int r3, k r4) {
        r2.d = r3;
        r2.w.reset();
        r2.w.setDuration(r2.h);
        r2.w.setAnimationListener(r4);
        r2.w.setInterpolator(r2.o);
        View r5 = r2.a;
        Intrinsics.checkNotNull(r5);
        r5.startAnimation(r2.w);
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
        int r10 = getPaddingLeft();
        int r11 = this.i + getPaddingTop();
        int r12 = (r7 - getPaddingLeft()) - getPaddingRight();
        int r13 = r12 + r10;
        r9.layout(r10, r11, r13, ((r8 - getPaddingTop()) - getPaddingBottom()) + r11);
        View r14 = this.p;
        Intrinsics.checkNotNull(r14);
        r14.layout(r10, r11 - this.q, r13, r11);
        return;
    }
}
