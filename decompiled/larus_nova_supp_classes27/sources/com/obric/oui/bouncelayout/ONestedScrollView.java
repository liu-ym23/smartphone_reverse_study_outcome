package com.obric.oui.bouncelayout;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.EdgeEffect;
import android.widget.OverScroller;
import androidx.core.widget.NestedScrollView;
import java.lang.reflect.Field;
import java.util.WeakHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0012B'\b\u0007\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\u0012\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\u0013"}, d2 = {"Lcom/obric/oui/bouncelayout/ONestedScrollView;", "Landroidx/core/widget/NestedScrollView;", "", "", "getScrollRangeY", "", "getBounceTranslation", "Lcom/obric/oui/bouncelayout/e;", "listener", "", "setOnBounceTranslationListener", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
public final class ONestedScrollView extends NestedScrollView {
    public static final /* synthetic */ int t = 0;
    public boolean a;
    public Field b;
    public Field c;
    public Field d;
    public BounceEdgeEffect e;
    public BounceEdgeEffect f;
    public boolean g;
    public float h;
    public int i;
    public boolean j;
    public final int k;
    public float l;
    public float m;
    public Boolean n;
    public EdgeEffect o;
    public EdgeEffect p;
    public final d q;
    public final BounceTranslationDelegate r;
    public final b s;

    public static final class a {
    }

    static {
    }

    public ONestedScrollView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ONestedScrollView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final int getScrollRangeY() {
        View r1 = getChildAt(0);
        if (r1 != null) goto L5;
        return 0;
    L5:
        int r2 = (getHeight() - getPaddingTop()) - getPaddingBottom();
        return Math.max(0, r1.getHeight() - r2);
    }

    public float getBounceTranslation() {
        BounceEdgeEffect r0 = this.e;
        float r1 = 0.0f;
        if (r0 != null) goto L5;
        float r2 = 0.0f;
    L6:
        BounceEdgeEffect r3 = this.f;
        if (r3 == null) goto L11;
        r1 = r3.f;
    L11:
        return r2 + r1;
    L5:
        r2 = r0.f;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDetachedFromWindow() {
        BounceEdgeEffect r0 = this.e;
        if (r0 == null) goto L6;
        r0.c();
    L6:
        BounceEdgeEffect r1 = this.f;
        if (r1 == null) goto L21;
        r1.c();
    L21:
        Field r2 = this.b;     // Catch: Throwable -> L20
        if (r2 == null) goto L14;
        r2.set(this, this.o);     // Catch: Throwable -> L20
    L14:
        Field r3 = this.c;     // Catch: Throwable -> L20
        if (r3 == null) goto L18;
        r3.set(this, this.p);     // Catch: Throwable -> L20
    L18:
        super/*android.widget.FrameLayout*/.onDetachedFromWindow();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void computeScroll() {
        super.computeScroll();
        if (this.g == true) goto L5;
        return;
    L5:
        OverScroller r0 = null;
        Field r1 = this.d;     // Catch: Throwable -> L14
        if (r1 != null) goto L9;
        Object r2 = null;
    L11:
        if ((r2 instanceof OverScroller) == false) goto L15;
        r0 = (OverScroller) r2;     // Catch: Throwable -> L14
        goto L15
    L9:
        r2 = r1.get(this);     // Catch: Throwable -> L14
    L15:
        if (r0 != null) goto L17;
        return;
    L17:
        int r3 = getScrollRangeY();
        if (r3 > 0) goto L20;
        return;
    L20:
        int r4 = getScrollY();
        boolean r5 = false;
        if (r0.isFinished() == true) goto L63;
        int r6 = this.i;
        float r7 = r0.getCurrVelocity();
        this.h = r7;
        int r8 = c.a;
        if (this.j == false) goto L25;
    L59:
        if (r5 == false) goto L61;
        return;
    L61:
        this.i = r4;
        return;
    L25:
        if (r7 <= 0.0f) goto L59;
        if (r4 != 0) goto L42;
        if (r6 <= 0) goto L42;
        BounceEdgeEffect r9 = this.e;
        if (r9 != null) goto L34;
    L36:
        boolean r10 = false;
    L37:
        if (r10 == false) goto L42;
        BounceEdgeEffect r11 = this.e;
        if (r11 == null) goto L56;
        r11.onAbsorb((int) r7);
    L56:
        r5 = true;
    L57:
        if (r5 == false) goto L59;
        this.j = true;
        r0.abortAnimation();
        this.h = 0.0f;
        invalidate();
        goto L59
    L34:
        if (r9.isFinished() != true) goto L36;
        r10 = true;
    L42:
        if (r4 != r3) goto L57;
        if (r6 >= r3) goto L57;
        BounceEdgeEffect r12 = this.f;
        if (r12 != null) goto L48;
    L50:
        boolean r13 = false;
    L51:
        if (r13 == false) goto L57;
        BounceEdgeEffect r14 = this.f;
        if (r14 == null) goto L56;
        r14.onAbsorb(-((int) r7));
        goto L56
    L48:
        if (r12.isFinished() != true) goto L50;
        r13 = true;
        goto L51
    L63:
        float r15 = this.h;
        if (r15 <= 0.0f) goto L79;
        if (r4 == 0) goto L67;
    L72:
        if (r4 != r3) goto L79;
        if (this.i >= r3) goto L79;
        int r16 = c.a;
        BounceEdgeEffect r17 = this.f;
        if (r17 == null) goto L79;
        r17.onAbsorb(-((int) r15));
        goto L79
    L67:
        if (this.i <= 0) goto L72;
        int r18 = c.a;
        BounceEdgeEffect r20 = this.e;
        if (r20 == null) goto L79;
        r20.onAbsorb((int) r15);
    L79:
        this.h = 0.0f;
        this.j = false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void dispatchDraw(Canvas r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        BounceEdgeEffect r0 = this.e;
        if (r0 != null) goto L7;
        float r1 = 0.0f;
    L8:
        BounceEdgeEffect r2 = this.f;
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
        super/*android.widget.FrameLayout*/.dispatchDraw(r4);
        r4.restoreToCount(r7);
        return;
    L18:
        super/*android.widget.FrameLayout*/.dispatchDraw(r4);
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

    public final boolean dispatchTouchEvent(final MotionEvent r5) {
        Intrinsics.checkNotNullParameter(r5, "event");
        this.s.c(r5);
        b r0 = this.s;
        Boolean r1 = r0.b(r5, 0.0f, -r0.e, new ONestedScrollView$dispatchTouchEvent$handled$1(this, r5));
        if (r1 != null) goto L6;
        return e(r5);
    L6:
        return r1.booleanValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean e(MotionEvent r6) {
        int r0 = r6.getActionMasked();
        if (r0 == 0) goto L19;
        boolean r2 = true;
        if (r0 != 1) goto L7;
        this.n = null;
    L21:
        return super/*android.widget.FrameLayout*/.dispatchTouchEvent(r6);
    L7:
        if (r0 != 2) goto L21;
        if (this.n != null) goto L21;
        float r1 = Math.abs(r6.getX() - this.l);
        float r3 = Math.abs(r6.getY() - this.m);
        if (Math.max(r1, r3) <= this.k) goto L21;
        if (r1 > r3) goto L17;
        r2 = false;
    L17:
        this.n = Boolean.valueOf(r2);
        goto L21
    L19:
        this.l = r6.getX();
        this.m = r6.getY();
        this.n = null;
        goto L21
    }

    public final boolean onInterceptTouchEvent(MotionEvent r4) {
        Intrinsics.checkNotNullParameter(r4, "event");
        if (r4.getActionMasked() != 0) goto L9;
        boolean r0 = super.onInterceptTouchEvent(r4);
        if (this.s.d(r4) == false) goto L7;
        return false;
    L7:
        return r0;
    L9:
        if (Intrinsics.areEqual(this.n, Boolean.TRUE) == false) goto L12;
        return false;
    L12:
        if (this.s.d(r4) == false) goto L14;
        return false;
    L14:
        boolean r5 = super.onInterceptTouchEvent(r4);
        if (r5 == false) goto L17;
        this.n = Boolean.FALSE;
    L17:
        return r5;
    }

    public void setOnBounceTranslationListener(e r2) {
        BounceTranslationDelegate r0 = this.r;
        r0.c = r2;
        r0.a();
    }

    public static Field f(Class r0, String r1) {
        Field r2 = r0.getDeclaredField(r1);     // Catch: Throwable -> L4
        r2.setAccessible(true);     // Catch: Throwable -> L4
        return r2;
    L4:
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ONestedScrollView(Context r7, AttributeSet r8, int r9) {
        Intrinsics.checkNotNullParameter(r7, "context");
        super(r7, r8, r9);
        this.k = ViewConfiguration.get(r7).getScaledTouchSlop();
        this.q = new d(new ONestedScrollView$overscrollDelegate$1(this), new ONestedScrollView$overscrollDelegate$2(this));
        this.r = new BounceTranslationDelegate(new ONestedScrollView$translationDelegate$1(this), new ONestedScrollView$translationDelegate$2(this));
        this.s = new b(this, new ONestedScrollView$clickDuringOverScrollDelegate$1(this), new ONestedScrollView$clickDuringOverScrollDelegate$2(this));
        setOverScrollMode(0);
        WeakHashMap<View, BounceEdgeEffect.a.C0121a> r10 = BounceEdgeEffect.u;
        BounceEdgeEffect.a.a("Landroidx/core/widget/NestedScrollView;");
        if (this.a == true) goto L16;
        this.a = true;
        Field r1 = f(NestedScrollView.class, "mEdgeGlowTop");     // Catch: Throwable -> L14
        if (r1 != null) goto L9;
        r1 = f(NestedScrollView.class, "mTopGlow");     // Catch: Throwable -> L14
    L9:
        this.b = r1;     // Catch: Throwable -> L14
        Field r2 = f(NestedScrollView.class, "mEdgeGlowBottom");     // Catch: Throwable -> L14
        if (r2 != null) goto L12;
        r2 = f(NestedScrollView.class, "mBottomGlow");     // Catch: Throwable -> L14
    L12:
        this.c = r2;     // Catch: Throwable -> L14
        this.d = f(NestedScrollView.class, "mScroller");     // Catch: Throwable -> L14
    L14:
        this.b = null;
        this.c = null;
        this.d = null;
    L16:
        if (this.e == null) goto L18;
        return;
    L18:
        if (this.f != null) goto L58;
        Field r11 = this.b;
        if (r11 == null) goto L59;
        Field r3 = this.c;
        if (r3 == null) goto L60;
        Object r4 = r11.get(this);     // Catch: Throwable -> L41
        if ((r4 instanceof EdgeEffect) == false) goto L29;
        EdgeEffect r5 = (EdgeEffect) r4;     // Catch: Throwable -> L41
    L30:
        Object r6 = r3.get(this);     // Catch: Throwable -> L41
        if ((r6 instanceof EdgeEffect) == false) goto L33;
        EdgeEffect r12 = (EdgeEffect) r6;     // Catch: Throwable -> L41
    L34:
        this.o = r5;     // Catch: Throwable -> L41
        this.p = r12;     // Catch: Throwable -> L41
        BounceEdgeEffect r13 = new BounceEdgeEffect(getContext(), this, 0, this.q.c);     // Catch: Throwable -> L41
        BounceEdgeEffect r14 = new BounceEdgeEffect(getContext(), this, 1, this.q.c);     // Catch: Throwable -> L41
        if (getWidth() > 0) goto L37;
    L39:
        r11.set(this, r13);     // Catch: Throwable -> L41
        r3.set(this, r14);     // Catch: Throwable -> L41
        this.e = r13;     // Catch: Throwable -> L41
        this.f = r14;     // Catch: Throwable -> L41
        this.q.a();     // Catch: Throwable -> L41
        this.r.a();     // Catch: Throwable -> L41
        this.g = true;     // Catch: Throwable -> L41
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
        r15.set(this, this.o);     // Catch: Throwable -> L51
    L45:
        Field r16 = this.c;     // Catch: Throwable -> L51
        if (r16 == null) goto L49;
        r16.set(this, this.p);     // Catch: Throwable -> L51
    L49:
        this.e = null;
        this.f = null;
        this.g = false;
        return;
    L60:
        return;
    L59:
        return;
    }

    public /* synthetic */ ONestedScrollView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    public final void onSizeChanged(int r1, int r2, int r3, int r4) {
        super.onSizeChanged(r1, r2, r3, r4);
        this.q.b();
        BounceEdgeEffect r5 = this.e;
        if (r5 == null) goto L6;
        r5.setSize(r1, r2);
    L6:
        BounceEdgeEffect r6 = this.f;
        if (r6 == null) goto L11;
        r6.setSize(r1, r2);
        return;
    }
}
