package com.obric.oui.bouncelayout;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.widget.EdgeEffect;
import android.widget.OverScroller;
import android.widget.ScrollView;
import java.lang.reflect.Field;
import java.util.WeakHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0016B'\b\u0007\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\n\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\b\u0010\n\u001a\u00020\u0006H\u0016J\u0012\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¨\u0006\u0017"}, d2 = {"Lcom/obric/oui/bouncelayout/OScrollView;", "Landroid/widget/ScrollView;", "", "", "getManualBounceContentVelocityY", "getScrollRangeY", "", "getCurrentFlingVelocity", "Landroid/widget/OverScroller;", "getScrollerOrNull", "getBounceTranslation", "Lcom/obric/oui/bouncelayout/e;", "listener", "", "setOnBounceTranslationListener", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
public final class OScrollView extends ScrollView {
    public final b A;
    public boolean a;
    public Field b;
    public Field c;
    public BounceEdgeEffect d;
    public BounceEdgeEffect e;
    public EdgeEffect f;
    public EdgeEffect g;
    public boolean h;
    public Field i;
    public float j;
    public int k;
    public boolean l;
    public final int m;
    public final int n;
    public final int o;
    public boolean p;
    public boolean q;
    public float r;
    public float s;
    public int t;
    public int u;
    public long v;
    public VelocityTracker w;
    public boolean x;
    public final d y;
    public final BounceTranslationDelegate z;

    public static final class a {
    }

    static {
    }

    public OScrollView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public OScrollView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    private final int getScrollRangeY() {
        View r1 = getChildAt(0);
        if (r1 != null) goto L5;
        return 0;
    L5:
        int r2 = (getHeight() - getPaddingTop()) - getPaddingBottom();
        return Math.max(0, r1.getHeight() - r2);
    }

    private final OverScroller getScrollerOrNull() {
        Field r1 = this.i;     // Catch: Throwable -> L12
        if (r1 != null) goto L6;
        Object r2 = null;
    L8:
        if ((r2 instanceof OverScroller) == false) goto L15;
        return (OverScroller) r2;
    L15:
        return null;
    L6:
        r2 = r1.get(this);     // Catch: Throwable -> L12
    L16:
        return null;
    }

    public final void g() {
        this.p = false;
        this.q = false;
        int r1 = getManualBounceContentVelocityY();
        int r2 = i();
        this.u = -1;
        this.v = -1;
        this.x = false;
        int r4 = c.a;
        if (r1 == 0) goto L36;
        if (r2 != 1) goto L10;
        if (r1 >= 0) goto L10;
        BounceEdgeEffect r3 = this.d;
        if (r3 == null) goto L47;
        r3.onAbsorb(r1);
    L47:
        this.t = 0;
        VelocityTracker r0 = this.w;
        if (r0 == null) goto L51;
        r0.recycle();
    L51:
        this.w = null;
        invalidate();
        return;
    L10:
        if (r2 != 2) goto L16;
        if (r1 <= 0) goto L16;
        BounceEdgeEffect r5 = this.e;
        if (r5 == null) goto L47;
        r5.onAbsorb(r1);
    L16:
        if (r1 > 0) goto L18;
    L20:
        if (r1 < 0) goto L22;
    L24:
        if (r2 != 0) goto L30;
        if (r1 <= 0) goto L30;
        BounceEdgeEffect r6 = this.e;
        if (r6 == null) goto L47;
        r6.onAbsorb(r1);
    L30:
        if (r2 != 0) goto L36;
        if (r1 >= 0) goto L36;
        BounceEdgeEffect r7 = this.d;
        if (r7 == null) goto L47;
        r7.onAbsorb(r1);
        goto L47
    L22:
        if (canScrollVertically(-1) == false) goto L24;
        this.k = getScrollY();
        this.j = Math.abs(r1);
        this.l = false;
        fling(r1);
        postInvalidateOnAnimation();
        goto L47
    L18:
        if (canScrollVertically(1) == false) goto L20;
        this.k = getScrollY();
        this.j = Math.abs(r1);
        this.l = false;
        fling(r1);
        postInvalidateOnAnimation();
    L36:
        if (r2 == 1) goto L43;
        if (r2 != 2) goto L47;
        BounceEdgeEffect r8 = this.e;
        if (r8 == null) goto L47;
        r8.onRelease();
        goto L47
    L43:
        BounceEdgeEffect r9 = this.d;
        if (r9 == null) goto L47;
        r9.onRelease();
        goto L47
    }

    private final float getCurrentFlingVelocity() {
        OverScroller r1 = getScrollerOrNull();     // Catch: Throwable -> L8
        if (r1 != null) goto L6;
        return 1000.0f;
    L6:
        return r1.getCurrVelocity();
    L11:
        return 1000.0f;
    }

    private final int getManualBounceContentVelocityY() {
        int r0 = this.u;
        VelocityTracker r1 = this.w;
        if (r1 != null) goto L6;
        return 0;
    L6:
        if (r0 != (-1)) goto L8;
        return 0;
    L8:
        r1.computeCurrentVelocity(1000, this.o);
        float r2 = r1.getYVelocity(r0);
        if (Math.abs(r2) >= this.n) goto L12;
        return 0;
    L12:
        return MathKt.roundToInt(-r2);
    }

    public float getBounceTranslation() {
        BounceEdgeEffect r0 = this.d;
        float r1 = 0.0f;
        if (r0 != null) goto L5;
        float r2 = 0.0f;
    L6:
        BounceEdgeEffect r3 = this.e;
        if (r3 == null) goto L11;
        r1 = r3.f;
    L11:
        return r2 + r1;
    L5:
        r2 = r0.f;
        goto L6
    }

    public final void h() {
        if (this.x == true) goto L5;
        return;
    L5:
        int r0 = i();
        if (r0 != 1) goto L8;
        BounceEdgeEffect r1 = this.d;
        if (r1 == null) goto L18;
        r1.onRelease();
    L18:
        this.x = false;
        invalidate();
        return;
    L8:
        if (r0 != 2) goto L18;
        BounceEdgeEffect r2 = this.e;
        if (r2 == null) goto L18;
        r2.onRelease();
        goto L18
    }

    public final int i() {
        int r0 = this.t;
        if (r0 == 0) goto L5;
        return r0;
    L5:
        boolean r1 = d(this.d);
        boolean r2 = d(this.e);
        if (r1 == false) goto L9;
        if (r2 == true) goto L9;
    L18:
        return 1;
    L9:
        if (r2 == false) goto L12;
        if (r1 == true) goto L12;
    L25:
        return 2;
    L12:
        BounceEdgeEffect r3 = this.d;
        if (r3 != null) goto L15;
        float r4 = 0.0f;
    L17:
        if (r4 > 0.0f) goto L18;
        BounceEdgeEffect r5 = this.e;
        if (r5 != null) goto L22;
        float r6 = 0.0f;
    L24:
        if (r6 < 0.0f) goto L25;
        return 0;
    L22:
        r6 = r5.f;
        goto L24
    L15:
        r4 = r3.f;
        goto L17
    }

    public final boolean j() {
        if (this.h == true) goto L5;
        return false;
    L5:
        BounceEdgeEffect r0 = this.d;
        if (r0 != null) goto L8;
        float r3 = 0.0f;
    L10:
        if (r3 != 0.0f) goto L12;
        boolean r4 = true;
    L13:
        if (r4 == false) goto L25;
        BounceEdgeEffect r5 = this.e;
        if (r5 != null) goto L17;
        float r6 = 0.0f;
    L19:
        if (r6 != 0.0f) goto L21;
        boolean r7 = true;
    L22:
        if (r7 == false) goto L25;
        boolean r8 = false;
    L26:
        if (r0 != null) goto L29;
    L31:
        boolean r1 = false;
    L32:
        if (r1 == true) goto L43;
        BounceEdgeEffect r2 = this.e;
        if (r2 != null) goto L37;
    L39:
        boolean r9 = false;
    L40:
        if (r9 == true) goto L43;
        boolean r10 = false;
    L44:
        if (r8 == true) goto L63;
        if (r10 == true) goto L63;
        return false;
    L63:
        OverScroller r11 = getScrollerOrNull();     // Catch: Throwable -> L62
        if (r11 == null) goto L52;
        r11.abortAnimation();     // Catch: Throwable -> L62
    L52:
        BounceEdgeEffect r12 = this.d;
        if (r12 == null) goto L56;
        r12.q();
    L56:
        BounceEdgeEffect r13 = this.e;
        if (r13 == null) goto L60;
        r13.q();
    L60:
        invalidate();
        this.j = 0.0f;
        this.k = getScrollY();
        this.l = false;
        return true;
    L37:
        if (r2.isFinished() == true) goto L39;
        r9 = true;
    L43:
        r10 = true;
        goto L44
    L29:
        if (r0.isFinished() == true) goto L31;
        r1 = true;
        goto L32
    L21:
        r7 = false;
        goto L22
    L17:
        r6 = r5.f;
    L25:
        r8 = true;
        goto L26
    L12:
        r4 = false;
        goto L13
    L8:
        r3 = r0.f;
        goto L10
    }

    @Override // android.widget.ScrollView, android.view.View
    public final void computeScroll() {
        super.computeScroll();
        if (this.h == true) goto L5;
        return;
    L5:
        OverScroller r0 = getScrollerOrNull();
        if (r0 != null) goto L8;
        return;
    L8:
        int r1 = getScrollRangeY();
        if (r1 > 0) goto L11;
        return;
    L11:
        int r2 = getScrollY();
        boolean r5 = true;
        boolean r6 = false;
        if (r0.isFinished() == true) goto L53;
        int r3 = this.k;
        float r7 = r0.getCurrVelocity();
        this.j = r7;
        int r8 = c.a;
        if (this.l == false) goto L16;
    L49:
        if (r6 == false) goto L51;
        return;
    L51:
        this.k = r2;
        return;
    L16:
        if (r7 <= 0.0f) goto L49;
        if (r2 != 0) goto L32;
        if (r3 <= 0) goto L32;
        BounceEdgeEffect r9 = this.d;
        if (r9 != null) goto L24;
    L26:
        boolean r10 = false;
    L27:
        if (r10 == false) goto L32;
        BounceEdgeEffect r4 = this.d;
        if (r4 == null) goto L46;
        r4.onAbsorb((int) r7);
    L46:
        r6 = true;
    L47:
        if (r6 == false) goto L49;
        this.l = true;
        r0.abortAnimation();
        this.j = 0.0f;
        invalidate();
        goto L49
    L24:
        if (r9.isFinished() != true) goto L26;
        r10 = true;
    L32:
        if (r2 != r1) goto L47;
        if (r3 >= r1) goto L47;
        BounceEdgeEffect r11 = this.e;
        if (r11 != null) goto L38;
    L40:
        boolean r12 = false;
    L41:
        if (r12 == false) goto L47;
        BounceEdgeEffect r13 = this.e;
        if (r13 == null) goto L46;
        r13.onAbsorb(-((int) r7));
        goto L46
    L38:
        if (r11.isFinished() != true) goto L40;
        r12 = true;
        goto L41
    L53:
        float r14 = this.j;
        if (r14 <= 0.0f) goto L82;
        if (r2 == 0) goto L57;
    L69:
        if (r2 != r1) goto L82;
        if (this.k >= r1) goto L82;
        BounceEdgeEffect r15 = this.e;
        if (r15 != null) goto L76;
    L74:
        r5 = false;
    L77:
        if (r5 == false) goto L82;
        int r16 = c.a;
        BounceEdgeEffect r17 = this.e;
        if (r17 == null) goto L82;
        r17.onAbsorb(-((int) r14));
        goto L82
    L76:
        if (r15.isFinished() != true) goto L74;
    L57:
        if (this.k <= 0) goto L69;
        BounceEdgeEffect r18 = this.d;
        if (r18 != null) goto L62;
    L60:
        boolean r20 = false;
    L64:
        if (r20 == false) goto L69;
        int r21 = c.a;
        BounceEdgeEffect r22 = this.d;
        if (r22 == null) goto L82;
        r22.onAbsorb((int) r14);
        goto L82
    L62:
        if (r18.isFinished() != true) goto L60;
        r20 = true;
    L82:
        this.j = 0.0f;
        this.k = r2;
        this.l = false;
    }

    @Override // android.widget.ScrollView, android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        BounceEdgeEffect r0 = this.d;
        if (r0 == null) goto L6;
        r0.c();
    L6:
        BounceEdgeEffect r1 = this.e;
        if (r1 == null) goto L20;
        r1.c();
    L20:
        Field r2 = this.b;     // Catch: Throwable -> L19
        if (r2 == null) goto L14;
        r2.set(this, this.f);     // Catch: Throwable -> L19
    L14:
        Field r3 = this.c;     // Catch: Throwable -> L19
        if (r3 == null) goto L22;
        r3.set(this, this.g);     // Catch: Throwable -> L19
        return;
    L22:
        return;
    }

    public static boolean d(BounceEdgeEffect r4) {
        if (r4 != null) goto L5;
        return false;
    L5:
        if (r4.getDistance() != 0.0f) goto L7;
        boolean r1 = true;
    L8:
        if (r1 == true) goto L10;
    L16:
        return true;
    L10:
        if (r4.f != 0.0f) goto L12;
        boolean r2 = true;
    L13:
        if (r2 == false) goto L16;
        if (r4.isFinished() == false) goto L16;
        return false;
    L12:
        r2 = false;
        goto L13
    L7:
        r1 = false;
        goto L8
    }

    public final int b(int r3) {
        if (r3 != 0) goto L4;
        return r3;
    L4:
        if (getScrollRangeY() <= 0) goto L9;
        int r0 = getScrollY();
        scrollBy(0, r3);
        return r3 - (getScrollY() - r0);
    L9:
        return r3;
    }

    public final void c(MotionEvent r4) {
        int r0 = r4.getActionIndex();
        if (r0 >= 0) goto L5;
        return;
    L5:
        if (r0 < r4.getPointerCount()) goto L8;
        return;
    L8:
        if (r4.getPointerId(r0) == this.u) goto L10;
        return;
    L10:
        if (r0 != 0) goto L12;
        int r1 = 1;
    L14:
        if (r1 >= r4.getPointerCount()) goto L16;
        m(r1, r4);
        return;
    L16:
        this.u = -1;
        return;
    L12:
        r1 = 0;
        goto L14
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        BounceEdgeEffect r0 = this.d;
        if (r0 != null) goto L7;
        float r1 = 0.0f;
    L8:
        BounceEdgeEffect r2 = this.e;
        if (r2 != null) goto L11;
        float r3 = 0.0f;
    L12:
        float r5 = r1 + r3;
        if (r5 != 0.0f) goto L15;
        boolean r6 = true;
    L16:
        if (r6 == true) goto L18;
        int r7 = r4.save();
        r4.translate(0.0f, r5);
        super.dispatchDraw(r4);
        r4.restoreToCount(r7);
        return;
    L18:
        super.dispatchDraw(r4);
        return;
    L15:
        r6 = false;
        goto L16
    L11:
        r3 = r2.f;
        goto L12
    L7:
        r1 = r0.f;
        goto L8
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(final MotionEvent r5) {
        Intrinsics.checkNotNullParameter(r5, "ev");
        this.A.c(r5);
        b r0 = this.A;
        Boolean r1 = r0.b(r5, 0.0f, -r0.e, new OScrollView$dispatchTouchEvent$handled$1(this, r5));
        if (r1 != null) goto L5;
        boolean r2 = super.dispatchTouchEvent(r5);
    L7:
        if (r5.getActionMasked() != 1) goto L9;
    L10:
        h();
    L11:
        return r2;
    L9:
        if (r5.getActionMasked() != 3) goto L11;
    L5:
        r2 = r1.booleanValue();
        goto L7
    }

    public final void e(int r4) {
        if (r4 != 0) goto L4;
        return;
    L4:
        if (getHeight() <= 0) goto L26;
        int r5 = b(r4);
        int r0 = c.a;
        if (r5 < 0) goto L9;
    L14:
        if (r5 > 0) goto L16;
    L21:
        this.t = 0;
        return;
    L16:
        if (getHeight() <= 0) goto L21;
        this.t = 2;
        BounceEdgeEffect r1 = this.e;
        if (r1 == null) goto L28;
        r1.j(r5 / getHeight(), true);
        return;
    L28:
        return;
    L9:
        if (getHeight() <= 0) goto L14;
        this.t = 1;
        BounceEdgeEffect r2 = this.d;
        if (r2 == null) goto L27;
        r2.j((-r5) / getHeight(), true);
        return;
    L27:
        return;
    }

    public final void f(float r8) {
        if (getHeight() > 0) goto L5;
        return;
    L5:
        float r0 = r8 / getHeight();
        boolean r1 = d(this.d);
        boolean r2 = d(this.e);
        if (r1 == false) goto L27;
        this.t = 1;
        BounceEdgeEffect r9 = this.d;
        if (r9 != null) goto L10;
        float r10 = 0.0f;
    L11:
        float r3 = r0 - r10;
        if (r3 >= 0.0f) goto L25;
        int r11 = b(MathKt.roundToInt((-r3) * getHeight()));
        int r4 = c.a;
        if (r11 <= 0) goto L22;
        if (getHeight() <= 0) goto L22;
        this.t = 2;
        BounceEdgeEffect r5 = this.e;
        if (r5 == null) goto L54;
        r5.j(r11 / getHeight(), true);
    L54:
        invalidate();
        return;
    L22:
        if (d(this.d) == true) goto L54;
        this.t = 0;
        goto L54
    L25:
        if (d(this.d) == true) goto L54;
        this.t = 0;
        goto L54
    L10:
        r10 = r9.j(r0, false);
        goto L11
    L27:
        if (r2 == false) goto L49;
        this.t = 2;
        float r12 = -r0;
        BounceEdgeEffect r6 = this.e;
        if (r6 != null) goto L31;
        float r7 = 0.0f;
    L32:
        float r13 = r12 - r7;
        if (r13 >= 0.0f) goto L46;
        int r14 = b(MathKt.roundToInt(r13 * getHeight()));
        int r15 = c.a;
        if (r14 >= 0) goto L43;
        if (getHeight() <= 0) goto L43;
        this.t = 1;
        BounceEdgeEffect r16 = this.d;
        if (r16 == null) goto L54;
        r16.j((-r14) / getHeight(), true);
    L43:
        if (d(this.e) == true) goto L54;
        this.t = 0;
        goto L54
    L46:
        if (d(this.e) == true) goto L54;
        this.t = 0;
        goto L54
    L31:
        r7 = r6.j(r12, false);
        goto L32
    L49:
        if (r8 <= 0.0f) goto L52;
        e(MathKt.roundToInt(-r8));
        goto L54
    L52:
        if (r8 >= 0.0f) goto L54;
        e(MathKt.roundToInt(-r8));
        goto L54
    }

    public final boolean l(MotionEvent r7) {
        if (this.h == true) goto L5;
    L15:
        boolean r0 = false;
    L16:
        if (r0 == true) goto L18;
        return false;
    L18:
        int r1 = r7.findPointerIndex(this.u);
        if (r1 >= 0) goto L21;
        return false;
    L21:
        VelocityTracker r3 = this.w;
        if (r3 == null) goto L25;
        r3.addMovement(r7);
    L25:
        float r2 = r7.getY(r1);
        float r4 = r2 - this.r;
        if (Math.abs(r4) > this.m) goto L29;
    L41:
        boolean r5 = false;
    L43:
        if (r5 == true) goto L45;
        return false;
    L45:
        j();
        int r6 = c.a;
        this.p = true;
        this.q = true;
        this.x = false;
        float r8 = this.r;
        this.s = r8;
        f(r2 - r8);
        this.s = r2;
        this.v = r7.getEventTime();
        ViewParent r9 = getParent();
        if (r9 == null) goto L49;
        r9.requestDisallowInterceptTouchEvent(true);
    L49:
        return true;
    L29:
        if (d(this.d) == false) goto L31;
    L42:
        r5 = true;
        goto L43
    L31:
        if (d(this.e) == true) goto L42;
        if (r4 <= 0.0f) goto L39;
        if (canScrollVertically(-1) == true) goto L41;
    L39:
        if (canScrollVertically(1) == true) goto L41;
    L5:
        if (getHeight() <= 0) goto L15;
        if (getScrollRangeY() > 0) goto L11;
    L14:
        r0 = true;
        goto L16
    L11:
        if (d(this.d) == true) goto L14;
        if (d(this.e) == false) goto L15;
        goto L14
    }

    @Override // android.widget.ScrollView, android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r7) {
        Intrinsics.checkNotNullParameter(r7, "ev");
        int r0 = r7.getActionMasked();
        boolean r3 = true;
        if (r0 == 0) goto L40;
        if (r0 != 1) goto L6;
    L29:
        this.p = false;
        this.q = false;
        this.t = 0;
        this.u = -1;
        this.v = -1;
        VelocityTracker r1 = this.w;
        if (r1 == null) goto L33;
        r1.recycle();
    L33:
        this.w = null;
        h();
    L35:
        if (this.A.d(r7) == false) goto L38;
        return false;
    L38:
        return super.onInterceptTouchEvent(r7);
    L6:
        if (r0 == 2) goto L23;
        if (r0 == 3) goto L29;
        if (r0 == 5) goto L19;
        if (r0 != 6) goto L35;
        if (this.p == false) goto L35;
        c(r7);
        return true;
    L19:
        if (this.p == false) goto L35;
        m(r7.getActionIndex(), r7);
        return true;
    L23:
        if (this.A.d(r7) == false) goto L26;
        return false;
    L26:
        if (l(r7) == false) goto L35;
        this.x = false;
        return true;
    L40:
        if (j() == false) goto L42;
    L45:
        this.x = r3;
        this.p = false;
        this.q = false;
        this.t = 0;
        this.u = r7.getPointerId(0);
        float r2 = r7.getY(0);
        this.r = r2;
        this.s = r2;
        this.v = -1;
        VelocityTracker r4 = this.w;
        if (r4 != null) goto L48;
        this.w = VelocityTracker.obtain();
    L49:
        VelocityTracker r5 = this.w;
        if (r5 == null) goto L53;
        r5.addMovement(r7);
    L53:
        boolean r6 = super.onInterceptTouchEvent(r7);
        if (this.A.d(r7) == false) goto L56;
        return false;
    L56:
        return r6;
    L48:
        r4.clear();
        goto L49
    L42:
        if (this.x == true) goto L45;
        r3 = false;
        goto L45
    }

    @Override // android.widget.ScrollView, android.view.View
    public final boolean onTouchEvent(MotionEvent r8) {
        Intrinsics.checkNotNullParameter(r8, "ev");
        int r0 = r8.getActionMasked();
        boolean r1 = false;
        boolean r2 = true;
        if (r0 == 0) goto L62;
        if (r0 == 1) goto L49;
        if (r0 == 2) goto L23;
        if (r0 == 3) goto L49;
        if (r0 == 5) goto L19;
        if (r0 != 6) goto L76;
        if (this.p == false) goto L76;
        c(r8);
        return true;
    L76:
        return super.onTouchEvent(r8);
    L19:
        if (this.p == false) goto L76;
        m(r8.getActionIndex(), r8);
        return true;
    L23:
        if (this.p == false) goto L45;
        if (r8.getEventTime() != this.v) goto L27;
        return true;
    L27:
        int r3 = r8.findPointerIndex(this.u);
        if (r3 >= 0) goto L31;
        g();
        return true;
    L31:
        float r4 = r8.getY(r3);
        float r5 = r4 - this.s;
        if (this.q == true) goto L34;
    L42:
        this.s = r4;
        return true;
    L34:
        if (r5 != 0.0f) goto L36;
        r1 = true;
    L36:
        if (r1 == true) goto L42;
        VelocityTracker r6 = this.w;
        if (r6 == null) goto L41;
        r6.addMovement(r8);
    L41:
        f(r5);
        goto L42
    L45:
        if (l(r8) == false) goto L76;
        this.x = false;
        return true;
    L49:
        if (this.p == false) goto L56;
        VelocityTracker r7 = this.w;
        if (r7 == null) goto L54;
        r7.addMovement(r8);
    L54:
        g();
        return true;
    L56:
        h();
        VelocityTracker r9 = this.w;
        if (r9 == null) goto L60;
        r9.recycle();
    L60:
        this.w = null;
        goto L76
    L62:
        if (j() == false) goto L64;
    L67:
        this.x = r2;
        this.p = false;
        this.q = false;
        this.t = 0;
        this.u = r8.getPointerId(0);
        float r10 = r8.getY(0);
        this.r = r10;
        this.s = r10;
        this.v = -1;
        VelocityTracker r11 = this.w;
        if (r11 != null) goto L70;
        this.w = VelocityTracker.obtain();
    L71:
        VelocityTracker r12 = this.w;
        if (r12 == null) goto L76;
        r12.addMovement(r8);
        goto L76
    L70:
        r11.clear();
        goto L71
    L64:
        if (this.x == true) goto L67;
        r2 = false;
        goto L67
    }

    public void setOnBounceTranslationListener(e r2) {
        BounceTranslationDelegate r0 = this.z;
        r0.c = r2;
        r0.a();
    }

    public static final /* synthetic */ boolean a(OScrollView r0, MotionEvent r1) {
        return super.dispatchTouchEvent(r1);
    }

    public static Field k(Class r0, String r1) {
        Field r2 = r0.getDeclaredField(r1);     // Catch: Throwable -> L4
        r2.setAccessible(true);     // Catch: Throwable -> L4
        return r2;
    L4:
        return null;
    }

    public final void m(int r2, MotionEvent r3) {
        if (r2 >= 0) goto L4;
        return;
    L4:
        if (r2 >= r3.getPointerCount()) goto L9;
        this.u = r3.getPointerId(r2);
        this.s = r3.getY(r2);
        return;
    }

    public OScrollView(Context r7, AttributeSet r8, int r9) {
        Intrinsics.checkNotNullParameter(r7, "context");
        super(r7, r8, r9);
        this.m = ViewConfiguration.get(r7).getScaledTouchSlop();
        this.n = ViewConfiguration.get(r7).getScaledMinimumFlingVelocity();
        this.o = ViewConfiguration.get(r7).getScaledMaximumFlingVelocity();
        this.u = -1;
        this.v = -1;
        this.y = new d(new OScrollView$overscrollDelegate$1(this), new OScrollView$overscrollDelegate$2(this));
        this.z = new BounceTranslationDelegate(new OScrollView$translationDelegate$1(this), new OScrollView$translationDelegate$2(this));
        this.A = new b(this, new OScrollView$clickDuringOverScrollDelegate$1(this), new OScrollView$clickDuringOverScrollDelegate$2(this));
        setOverScrollMode(0);
        WeakHashMap<View, BounceEdgeEffect.a.C0121a> r10 = BounceEdgeEffect.u;
        BounceEdgeEffect.a.a("Landroid/widget/ScrollView;");
        if (this.a == true) goto L16;
        this.a = true;
        Field r1 = k(ScrollView.class, "mEdgeGlowTop");     // Catch: Throwable -> L14
        if (r1 != null) goto L9;
        r1 = k(ScrollView.class, "mTopGlow");     // Catch: Throwable -> L14
    L9:
        this.b = r1;     // Catch: Throwable -> L14
        Field r2 = k(ScrollView.class, "mEdgeGlowBottom");     // Catch: Throwable -> L14
        if (r2 != null) goto L12;
        r2 = k(ScrollView.class, "mBottomGlow");     // Catch: Throwable -> L14
    L12:
        this.c = r2;     // Catch: Throwable -> L14
        this.i = k(ScrollView.class, "mScroller");     // Catch: Throwable -> L14
    L14:
        this.b = null;
        this.c = null;
        this.i = null;
    L16:
        if (this.d == null) goto L18;
        return;
    L18:
        if (this.e != null) goto L58;
        this.y.b();
        Field r11 = this.b;
        if (r11 == null) goto L59;
        Field r3 = this.c;
        if (r3 == null) goto L60;
        Object r4 = r11.get(this);     // Catch: Throwable -> L41
        if ((r4 instanceof EdgeEffect) == false) goto L29;
        EdgeEffect r5 = (EdgeEffect) r4;     // Catch: Throwable -> L41
    L30:
        this.f = r5;     // Catch: Throwable -> L41
        Object r6 = r3.get(this);     // Catch: Throwable -> L41
        if ((r6 instanceof EdgeEffect) == false) goto L33;
        EdgeEffect r12 = (EdgeEffect) r6;     // Catch: Throwable -> L41
    L34:
        this.g = r12;     // Catch: Throwable -> L41
        BounceEdgeEffect r13 = new BounceEdgeEffect(getContext(), this, 0, this.y.c);     // Catch: Throwable -> L41
        BounceEdgeEffect r14 = new BounceEdgeEffect(getContext(), this, 1, this.y.c);     // Catch: Throwable -> L41
        if (getWidth() > 0) goto L37;
    L39:
        r11.set(this, r13);     // Catch: Throwable -> L41
        r3.set(this, r14);     // Catch: Throwable -> L41
        this.d = r13;     // Catch: Throwable -> L41
        this.e = r14;     // Catch: Throwable -> L41
        this.h = true;     // Catch: Throwable -> L41
        this.y.a();     // Catch: Throwable -> L41
        this.z.a();     // Catch: Throwable -> L41
        return;
    L37:
        if (getHeight() <= 0) goto L39;
        r13.setSize(getWidth(), getHeight());     // Catch: Throwable -> L41
        r14.setSize(getWidth(), getHeight());     // Catch: Throwable -> L41
        goto L39
    L33:
        r12 = null;
        goto L34
    L29:
        r5 = null;
    L41:
        Field r15 = this.b;     // Catch: Throwable -> L51
        if (r15 == null) goto L45;
        r15.set(this, this.f);     // Catch: Throwable -> L51
    L45:
        Field r16 = this.c;     // Catch: Throwable -> L51
        if (r16 == null) goto L49;
        r16.set(this, this.g);     // Catch: Throwable -> L51
    L49:
        this.d = null;
        this.e = null;
        this.h = false;
        return;
    L60:
        return;
    L59:
        return;
    }

    public /* synthetic */ OScrollView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    @Override // android.widget.ScrollView, android.view.View
    public final void onSizeChanged(int r1, int r2, int r3, int r4) {
        super.onSizeChanged(r1, r2, r3, r4);
        this.y.b();
        BounceEdgeEffect r5 = this.d;
        if (r5 == null) goto L6;
        r5.setSize(r1, r2);
    L6:
        BounceEdgeEffect r6 = this.e;
        if (r6 == null) goto L11;
        r6.setSize(r1, r2);
        return;
    }

    @Override // android.view.View
    public final boolean overScrollBy(int r3, int r4, int r5, int r6, int r7, int r8, int r9, int r10, boolean r11) {
        boolean r12 = super.overScrollBy(r3, r4, r5, r6, r7, r8, r9, r10, r11);
        if (r11 == false) goto L5;
    L57:
        return r12;
    L5:
        if (this.h == false) goto L57;
        if (r8 <= 0) goto L57;
        int r13 = r6 + r4;
        int r14 = c.a;
        boolean r15 = false;
        if (r13 > 0) goto L34;
        if (r4 >= 0) goto L34;
        BounceEdgeEffect r16 = this.d;
        if (r16 != null) goto L14;
    L16:
        boolean r17 = false;
    L17:
        if (r17 == false) goto L34;
        float r18 = getCurrentFlingVelocity();
        int r110 = Math.abs(r13);
        if (getHeight() <= 0) goto L24;
        BounceEdgeEffect r0 = this.d;
        if (r0 == null) goto L24;
        r0.onPull(r110 / getHeight(), 0.5f);
    L24:
        BounceEdgeEffect r111 = this.d;
        if (r111 == null) goto L59;
        r111.onAbsorb((int) r18);
    L59:
        OverScroller r112 = getScrollerOrNull();     // Catch: Throwable -> L33
        if (r112 == null) goto L34;
        r112.abortAnimation();     // Catch: Throwable -> L33
        goto L34
    L14:
        if (r16.isFinished() != true) goto L16;
        r17 = true;
    L34:
        if (r13 < r8) goto L57;
        if (r4 <= 0) goto L57;
        BounceEdgeEffect r20 = this.e;
        if (r20 != null) goto L40;
    L42:
        if (r15 == false) goto L57;
        float r21 = getCurrentFlingVelocity();
        int r22 = r13 - r8;
        if (getHeight() <= 0) goto L49;
        BounceEdgeEffect r23 = this.e;
        if (r23 == null) goto L49;
        r23.onPull(r22 / getHeight(), 0.5f);
    L49:
        BounceEdgeEffect r24 = this.e;
        if (r24 == null) goto L61;
        r24.onAbsorb(-((int) r21));
    L61:
        OverScroller r25 = getScrollerOrNull();     // Catch: Throwable -> L58
        if (r25 == null) goto L57;
        r25.abortAnimation();     // Catch: Throwable -> L58
        goto L57
    L40:
        if (r20.isFinished() != true) goto L42;
        r15 = true;
        goto L42
    }
}
