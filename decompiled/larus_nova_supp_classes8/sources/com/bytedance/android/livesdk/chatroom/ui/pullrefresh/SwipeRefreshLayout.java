package com.bytedance.android.livesdk.chatroom.ui.pullrefresh;

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
import androidx.core.view.NestedScrollingChild;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.NestedScrollingParent;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.core.view.ViewCompat;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.Objects;
import no1.h;
import no1.i;
import no1.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class SwipeRefreshLayout extends ViewGroup implements NestedScrollingParent, NestedScrollingChild {
    public static final int[] I = null;
    public j A;
    public j B;
    public boolean C;
    public final int D;
    public final a E;
    public final c F;
    public final d G;
    public final e H;
    public View a;
    public f b;
    public boolean c;
    public final int d;
    public final float e;
    public float f;
    public final NestedScrollingParentHelper g;
    public final NestedScrollingChildHelper h;
    public final int[] i;
    public final int[] j;
    public boolean k;
    public final int l;
    public int m;
    public float n;
    public float o;
    public boolean p;
    public int q;
    public final DecelerateInterpolator r;
    public no1.a s;
    public int t;
    public int u;
    public final int v;
    public final int w;
    public MaterialProgressDrawable x;
    public h y;
    public i z;

    public class a implements Animation.AnimationListener {
        public final /* synthetic */ SwipeRefreshLayout a;

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationRepeat(Animation r1) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationStart(Animation r1) {
        }

        public a(SwipeRefreshLayout r1) {
            this.a = r1;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationEnd(Animation r3) {
            SwipeRefreshLayout r4 = this.a;
            if (r4.c == false) goto L10;
            r4.H.b(false);
            MaterialProgressDrawable r5 = this.a.x;
            r5.b.u = 255;
            r5.start();
            SwipeRefreshLayout r6 = this.a;
            if (r6.C == false) goto L9;
            f r7 = r6.b;
            if (r7 == null) goto L9;
            r7.onRefresh();
        L9:
            SwipeRefreshLayout r8 = this.a;
            r8.m = r8.s.getTop();
            return;
        L10:
            r4.e();
        }
    }

    public class b implements Animation.AnimationListener {
        public final /* synthetic */ SwipeRefreshLayout a;

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationRepeat(Animation r1) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationStart(Animation r1) {
        }

        public b(SwipeRefreshLayout r1) {
            this.a = r1;
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [android.widget.ImageView, no1.a] */
        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationEnd(Animation r4) {
            this.a.getClass();
            SwipeRefreshLayout r5 = this.a;
            r5.getClass();
            i r0 = new i(r5);
            r5.z = r0;
            r0.setDuration(150);
            ?? r1 = r5.s;
            r1.a = null;
            r1.clearAnimation();
            r5.s.startAnimation(r5.z);
        }
    }

    public class c extends Animation {
        public final /* synthetic */ SwipeRefreshLayout a;

        public c(SwipeRefreshLayout r1) {
            this.a = r1;
        }

        @Override // android.view.animation.Animation
        public final void applyTransformation(float r3, Transformation r4) {
            this.a.getClass();
            SwipeRefreshLayout r5 = this.a;
            int r0 = r5.w - Math.abs(r5.v);
            SwipeRefreshLayout r6 = this.a;
            int r1 = r6.u;
            this.a.g((r1 + ((int) ((r0 - r1) * r3))) - r6.s.getTop());
            this.a.x.a(1.0f - r3);
        }
    }

    public class d extends Animation {
        public final /* synthetic */ SwipeRefreshLayout a;

        public d(SwipeRefreshLayout r1) {
            this.a = r1;
        }

        @Override // android.view.animation.Animation
        public final void applyTransformation(float r1, Transformation r2) {
            this.a.d(r1);
        }
    }

    public class e extends no1.g {
        @Override // no1.g
        public final void a() {
        }

        public e() {
        }
    }

    public interface f {
        void onRefresh();
    }

    public interface g {
    }

    static {
        I = new int[]{R.attr.enabled};
    }

    public final void a() {
        if (this.a != null) goto L11;
        int r0 = 0;
    L6:
        if (r0 >= getChildCount()) goto L15;
        View r1 = getChildAt(r0);
        if (r1.equals(this.s) == false) goto L9;
        r0 = r0 + 1;
        goto L6
    L9:
        this.a = r1;
        return;
    L15:
        return;
    }

    public final void e() {
        this.H.b(true);
        this.s.clearAnimation();
        this.x.stop();
        this.s.setVisibility(8);
        setColorViewAlpha(255);
        g(this.v - this.m);
        this.m = this.s.getTop();
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return this.g.getNestedScrollAxes();
    }

    @Override // android.view.View
    public final boolean hasNestedScrollingParent() {
        return this.h.hasNestedScrollingParent();
    }

    @Override // android.view.View
    public final boolean isNestedScrollingEnabled() {
        return this.h.isNestedScrollingEnabled();
    }

    @Override // android.view.View
    public final void stopNestedScroll() {
        this.h.stopNestedScroll();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        e();
    }

    public int getProgressViewEndOffset() {
        return this.w;
    }

    public int getProgressViewStartOffset() {
        return this.v;
    }

    public SwipeRefreshLayout(Context r2) {
        this(r2, null);
    }

    private void setColorViewAlpha(int r2) {
        this.s.getBackground().setAlpha(r2);
        this.x.b.u = r2;
    }

    /* JADX WARN: Type inference failed for: r0v8, types: [android.widget.ImageView, no1.a] */
    public final void b(float r5) {
        if (r5 <= this.e) goto L5;
        f(true, true);
        return;
    L5:
        this.c = false;
        MaterialProgressDrawable r0 = this.x;
        MaterialProgressDrawable.b r1 = r0.b;
        r1.e = 0.0f;
        r1.a();
        MaterialProgressDrawable.b r2 = r0.b;
        r2.f = 0.0f;
        r2.a();
        b r3 = new b(this);
        int r4 = this.m;
        e r6 = this.H;
        r6.getClass();
        no1.f r7 = new no1.f(r6, r3);
        e r8 = this.H;
        r8.getClass();
        Objects.toString(r7);
        r8.b(false);
        this.u = r4;
        this.G.reset();
        this.G.setDuration(200);
        this.G.setInterpolator(this.r);
        ?? r9 = this.s;
        r9.a = r7;
        r9.clearAnimation();
        this.s.startAnimation(this.G);
        MaterialProgressDrawable.b r10 = this.x.b;
        if (r10.o == false) goto L10;
        r10.o = false;
        r10.a();
        return;
    }

    /* JADX WARN: Type inference failed for: r14v29, types: [android.widget.ImageView, no1.a] */
    /* JADX WARN: Type inference failed for: r14v9, types: [android.widget.ImageView, no1.a] */
    public final void c(float r14) {
        MaterialProgressDrawable.b r0 = this.x.b;
        boolean r2 = true;
        if (r0.o == true) goto L5;
        r0.o = true;
        r0.a();
    L5:
        float r1 = Math.min(1.0f, Math.abs(r14 / this.e));
        float r3 = (((float) Math.max(((double) r1) - 0.4d, 0.0d)) * 5.0f) / 3.0f;
        float r4 = Math.abs(r14) - this.e;
        float r5 = this.w;
        double r8 = Math.max(0.0f, Math.min(r4, r5 * 2.0f) / r5) / 4.0f;
        float r6 = ((float) (r8 - Math.pow(r8, 2.0d))) * 2.0f;
        int r9 = this.v + ((int) ((r5 * r1) + ((r5 * r6) * 2.0f)));
        if (this.s.getVisibility() == 0) goto L8;
        this.s.setVisibility(0);
    L8:
        ViewCompat.setScaleX(this.s, 1.0f);
        ViewCompat.setScaleY(this.s, 1.0f);
        if (r14 >= this.e) goto L23;
        if (this.x.b.u <= 76) goto L34;
        j r15 = this.A;
        if (r15 != null) goto L15;
    L19:
        r2 = false;
    L20:
        if (r2 == true) goto L34;
        j r7 = new j(this, this.x.b.u, 76);
        r7.setDuration(300);
        ?? r16 = this.s;
        r16.a = null;
        r16.clearAnimation();
        this.s.startAnimation(r7);
        this.A = r7;
        goto L34
    L15:
        if (r15.hasStarted() == false) goto L19;
        if (r15.hasEnded() == true) goto L19;
    L34:
        MaterialProgressDrawable r10 = this.x;
        float r17 = Math.min(0.8f, r3 * 0.8f);
        MaterialProgressDrawable.b r11 = r10.b;
        r11.e = 0.0f;
        r11.a();
        MaterialProgressDrawable.b r12 = r10.b;
        r12.f = r17;
        r12.a();
        this.x.a(Math.min(1.0f, r3));
        MaterialProgressDrawable.b r18 = this.x.b;
        r18.g = (((r3 * 0.4f) - 0.25f) + (r6 * 2.0f)) * 0.5f;
        r18.a();
        g(r9 - this.m);
        e r19 = this.H;
        r19.getClass();
        r19.b(false);
        return;
    L23:
        if (this.x.b.u >= 255) goto L34;
        j r110 = this.B;
        if (r110 != null) goto L27;
    L31:
        r2 = false;
    L32:
        if (r2 == true) goto L34;
        j r13 = new j(this, this.x.b.u, 255);
        r13.setDuration(300);
        ?? r111 = this.s;
        r111.a = null;
        r111.clearAnimation();
        this.s.startAnimation(r13);
        this.B = r13;
        goto L34
    L27:
        if (r110.hasStarted() == false) goto L31;
        if (r110.hasEnded() == true) goto L31;
        goto L31
    }

    public final void d(float r3) {
        int r0 = this.u;
        g((r0 + ((int) ((this.v - r0) * r3))) - this.s.getTop());
    }

    public final void g(int r2) {
        this.s.bringToFront();
        ViewCompat.offsetTopAndBottom(this.s, r2);
        this.m = this.s.getTop();
    }

    public final void h(float r4) {
        float r0 = this.o;
        float r5 = r4 - r0;
        int r1 = this.d;
        if (r5 > r1) goto L5;
        return;
    L5:
        if (this.p == true) goto L9;
        this.n = r0 + r1;
        this.p = true;
        this.x.b.u = 76;
        return;
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r6) {
        a();
        int r0 = MotionEventCompat.getActionMasked(r6);
        int r2 = 0;
        if (isEnabled() == true) goto L5;
    L40:
        return false;
    L5:
        if (ViewCompat.canScrollVertically(this.a, -1) == true) goto L40;
        if (this.c == true) goto L40;
        if (this.k == true) goto L40;
        if (r0 != 0) goto L13;
        g(this.v - this.s.getTop());
        int r1 = r6.getPointerId(0);
        this.q = r1;
        this.p = false;
        int r3 = r6.findPointerIndex(r1);
        if (r3 >= 0) goto L37;
        return false;
    L37:
        this.o = r6.getY(r3);
    L39:
        return this.p;
    L13:
        if (r0 != 1) goto L15;
    L33:
        this.p = false;
        this.q = -1;
        goto L39
    L15:
        if (r0 != 2) goto L17;
        int r4 = this.q;
        if (r4 != (-1)) goto L29;
        return false;
    L29:
        int r5 = r6.findPointerIndex(r4);
        if (r5 >= 0) goto L32;
        return false;
    L32:
        h(r6.getY(r5));
        goto L39
    L17:
        if (r0 == 3) goto L33;
        if (r0 != 6) goto L39;
        int r7 = MotionEventCompat.getActionIndex(r6);
        if (r6.getPointerId(r7) != this.q) goto L39;
        if (r7 != 0) goto L25;
        r2 = 1;
    L25:
        this.q = r6.getPointerId(r2);
        goto L39
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onStopNestedScroll(View r3) {
        this.g.onStopNestedScroll(r3);
        this.k = false;
        float r4 = this.f;
        if (r4 <= 0.0f) goto L5;
        b(r4);
        this.f = 0.0f;
    L5:
        stopNestedScroll();
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r7) {
        int r0 = MotionEventCompat.getActionMasked(r7);
        int r2 = 0;
        if (isEnabled() == true) goto L5;
    L53:
        return false;
    L5:
        if (ViewCompat.canScrollVertically(this.a, -1) == true) goto L53;
        if (this.c == true) goto L53;
        if (this.k == true) goto L53;
        if (r0 != 0) goto L14;
        this.q = r7.getPointerId(0);
        this.p = false;
    L52:
        return true;
    L14:
        if (r0 != 1) goto L16;
    L43:
        int r1 = r7.findPointerIndex(this.q);
        if (r1 >= 0) goto L47;
        return false;
    L47:
        if (this.p == false) goto L49;
        float r8 = (r7.getY(r1) - this.n) * 0.5f;
        this.p = false;
        b(r8);
    L49:
        this.q = -1;
        return false;
    L16:
        if (r0 != 2) goto L18;
        int r3 = r7.findPointerIndex(this.q);
        if (r3 >= 0) goto L36;
        return false;
    L36:
        float r9 = r7.getY(r3);
        h(r9);
        if (this.p == false) goto L52;
        float r10 = (r9 - this.n) * 0.5f;
        if (r10 <= 0.0f) goto L41;
        c(r10);
        goto L52
    L41:
        c(0.0f);
        return false;
    L18:
        if (r0 == 3) goto L43;
        if (r0 != 5) goto L22;
        int r4 = MotionEventCompat.getActionIndex(r7);
        if (r4 >= 0) goto L32;
        return false;
    L32:
        this.q = r7.getPointerId(r4);
        goto L52
    L22:
        if (r0 != 6) goto L52;
        int r5 = MotionEventCompat.getActionIndex(r7);
        if (r7.getPointerId(r5) != this.q) goto L52;
        if (r5 != 0) goto L28;
        r2 = 1;
    L28:
        this.q = r7.getPointerId(r2);
        goto L52
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestDisallowInterceptTouchEvent(boolean r1) {
        super.requestDisallowInterceptTouchEvent(r1);
    }

    public void setAnimationProgress(float r2) {
        ViewCompat.setScaleX(this.s, r2);
        ViewCompat.setScaleY(this.s, r2);
    }

    @Override // android.view.View
    public void setEnabled(boolean r1) {
        super.setEnabled(r1);
        if (r1 == true) goto L6;
        e();
        return;
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean r2) {
        this.h.setNestedScrollingEnabled(r2);
    }

    public void setOnRefreshListener(f r1) {
        this.b = r1;
    }

    public void setRefreshing(boolean r4) {
        if (r4 == true) goto L5;
    L10:
        f(r4, false);
        return;
    L5:
        if (this.c == r4) goto L10;
        this.c = r4;
        g((this.w + this.v) - this.m);
        this.C = false;
        a r5 = this.E;
        this.s.setVisibility(0);
        this.x.b.u = 255;
        h r0 = new h(this);
        this.y = r0;
        r0.setDuration(this.l);
        if (r5 == null) goto L9;
        this.s.a = r5;
    L9:
        this.s.clearAnimation();
        this.s.startAnimation(this.y);
    }

    @Override // android.view.View
    public final boolean startNestedScroll(int r2) {
        return this.h.startNestedScroll(r2);
    }

    public SwipeRefreshLayout(Context r7, AttributeSet r8) {
        super(r7, r8);
        this.c = false;
        this.e = -1.0f;
        this.i = new int[2];
        this.j = new int[2];
        this.q = -1;
        this.t = -1;
        this.E = new a(this);
        this.F = new c(this);
        this.G = new d(this);
        this.H = new e();
        this.d = ViewConfiguration.get(r7).getScaledTouchSlop();
        this.l = getResources().getInteger(R.integer.config_mediumAnimTime);
        setWillNotDraw(false);
        this.r = new DecelerateInterpolator(2.0f);
        Resources r1 = getResources();
        DisplayMetrics r2 = WindowDisplayMetricsOverride.apply(r1, r1.getDisplayMetrics());
        int r3 = (int) (r2.density * 40.0f);
        this.D = r3;
        this.s = new no1.a(getContext());
        MaterialProgressDrawable r4 = new MaterialProgressDrawable(getContext(), this);
        this.x = r4;
        r4.b.w = -328966;
        this.s.setImageDrawable(r4);
        this.s.setVisibility(8);
        addView(this.s);
        ViewCompat.setChildrenDrawingOrderEnabled(this, true);
        int r5 = (int) (r2.density * 64.0f);
        this.w = r5;
        this.e = r5;
        this.g = new NestedScrollingParentHelper(this);
        this.h = new NestedScrollingChildHelper(this);
        setNestedScrollingEnabled(true);
        int r6 = -r3;
        this.m = r6;
        this.v = r6;
        d(1.0f);
        TypedArray r9 = r7.obtainStyledAttributes(r8, I);
        setEnabled(r9.getBoolean(0, true));
        r9.recycle();
    }

    @Override // android.view.View
    public final boolean dispatchNestedPreFling(float r2, float r3) {
        return this.h.dispatchNestedPreFling(r2, r3);
    }

    /* JADX WARN: Type inference failed for: r4v2, types: [android.widget.ImageView, no1.a] */
    public final void f(boolean r3, boolean r4) {
        this.H.getClass();
        if (this.c == r3) goto L12;
        this.C = r4;
        a();
        this.c = r3;
        if (r3 == false) goto L10;
        int r5 = this.m;
        a r6 = this.E;
        e r0 = this.H;
        r0.getClass();
        Objects.toString(r6);
        r0.b(false);
        this.u = r5;
        this.F.reset();
        this.F.setDuration(200);
        this.F.setInterpolator(this.r);
        if (r6 == null) goto L9;
        this.s.a = r6;
    L9:
        this.s.clearAnimation();
        this.s.startAnimation(this.F);
        return;
    L10:
        a r7 = this.E;
        i r8 = new i(this);
        this.z = r8;
        r8.setDuration(150);
        ?? r9 = this.s;
        r9.a = r7;
        r9.clearAnimation();
        this.s.startAnimation(this.z);
        return;
    }

    @Override // android.view.ViewGroup
    public final int getChildDrawingOrder(int r2, int r3) {
        int r0 = this.t;
        if (r0 >= 0) goto L6;
        return r3;
    L6:
        if (r3 != (r2 - 1)) goto L8;
        return r0;
    L8:
        if (r3 >= r0) goto L10;
        return r3;
    L10:
        return r3 + 1;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // android.view.View
    public final void onMeasure(int r4, int r5) {
        super.onMeasure(r4, r5);
        if (this.a != null) goto L5;
        a();
    L5:
        View r6 = this.a;
        if (r6 != null) goto L19;
        return;
    L19:
        r6.measure(View.MeasureSpec.makeMeasureSpec((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), 1073741824), View.MeasureSpec.makeMeasureSpec((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), 1073741824));     // Catch: IllegalStateException -> L18
    L10:
        this.s.measure(View.MeasureSpec.makeMeasureSpec(this.D, 1073741824), View.MeasureSpec.makeMeasureSpec(this.D, 1073741824));
        this.t = -1;
        int r7 = 0;
    L12:
        if (r7 >= getChildCount()) goto L23;
        if (getChildAt(r7) == this.s) goto L15;
        r7 = r7 + 1;
        goto L12
    L15:
        this.t = r7;
        return;
    }

    @Override // android.view.View
    public final boolean dispatchNestedFling(float r2, float r3, boolean r4) {
        return this.h.dispatchNestedFling(r2, r3, r4);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedPreFling(View r1, float r2, float r3) {
        return dispatchNestedPreFling(r2, r3);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedScrollAccepted(View r2, View r3, int r4) {
        this.g.onNestedScrollAccepted(r2, r3, r4);
        startNestedScroll(r4 & 2);
        this.f = 0.0f;
        this.k = true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onStartNestedScroll(View r1, View r2, int r3) {
        if (isEnabled() == true) goto L5;
    L9:
        return false;
    L5:
        if (this.c == true) goto L9;
        if ((r3 & 2) == 0) goto L9;
        return true;
    }

    @Override // android.view.View
    public final boolean dispatchNestedPreScroll(int r2, int r3, int[] r4, int[] r5) {
        return this.h.dispatchNestedPreScroll(r2, r3, r4, r5);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedFling(View r1, float r2, float r3, boolean r4) {
        return dispatchNestedFling(r2, r3, r4);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedPreScroll(View r5, int r6, int r7, int[] r8) {
        if (r7 <= 0) goto L11;
        float r0 = this.f;
        if (r0 <= 0.0f) goto L11;
        float r2 = r7;
        if (r2 <= r0) goto L9;
        r8[1] = r7 - ((int) r0);
        this.f = 0.0f;
    L10:
        c(this.f);
        goto L11
    L9:
        this.f = r0 - r2;
        r8[1] = r7;
    L11:
        int[] r1 = this.i;
        if (dispatchNestedPreScroll(r6 - r8[0], r7 - r8[1], r1, null) == false) goto L15;
        r8[0] = r8[0] + r1[0];
        r8[1] = r8[1] + r1[1];
        return;
    }

    @Override // android.view.View
    public final boolean dispatchNestedScroll(int r7, int r8, int r9, int r10, int[] r11) {
        return this.h.dispatchNestedScroll(r7, r8, r9, r10, r11);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r3, int r4, int r5, int r6, int r7) {
        int r8 = getMeasuredWidth();
        int r9 = getMeasuredHeight();
        if (getChildCount() != 0) goto L6;
        return;
    L6:
        if (this.a != null) goto L8;
        a();
    L8:
        View r10 = this.a;
        if (r10 != null) goto L11;
        return;
    L11:
        int r11 = getPaddingLeft();
        int r12 = getPaddingTop();
        int r0 = (r8 - getPaddingLeft()) - getPaddingRight();
        r10.layout(r11, r12, r0 + r11, ((r9 - getPaddingTop()) - getPaddingBottom()) + r12);     // Catch: Exception -> L15
    L13:
        int r13 = this.s.getMeasuredWidth();
        int r14 = this.s.getMeasuredHeight();
        int r15 = r8 / 2;
        int r16 = r13 / 2;
        int r1 = this.m;
        this.s.layout(r15 - r16, r1, r15 + r16, r14 + r1);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedScroll(View r7, int r8, int r9, int r10, int r11) {
        dispatchNestedScroll(r8, r9, r10, r11, this.j);
        int r12 = r11 + this.j[1];
        if (r12 < 0) goto L5;
        return;
    L5:
        if (ViewCompat.canScrollVertically(this.a, -1) == true) goto L9;
        float r13 = this.f + Math.abs(r12);
        this.f = r13;
        c(r13);
        return;
    }
}
