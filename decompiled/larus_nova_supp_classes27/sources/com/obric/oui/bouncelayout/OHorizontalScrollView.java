package com.obric.oui.bouncelayout;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EdgeEffect;
import android.widget.HorizontalScrollView;
import android.widget.OverScroller;
import java.lang.reflect.Field;
import java.util.WeakHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0012B'\b\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0016J\u0012\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\u0013"}, d2 = {"Lcom/obric/oui/bouncelayout/OHorizontalScrollView;", "Landroid/widget/HorizontalScrollView;", "", "", "getCurrentFlingVelocity", "getBounceTranslation", "Lcom/obric/oui/bouncelayout/e;", "listener", "", "setOnBounceTranslationListener", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
public class OHorizontalScrollView extends HorizontalScrollView {
    public boolean a;
    public Field b;
    public Field c;
    public BounceEdgeEffect d;
    public BounceEdgeEffect e;
    public EdgeEffect f;
    public EdgeEffect g;
    public boolean h;
    public Field i;
    public boolean j;
    public final d k;
    public final BounceTranslationDelegate l;
    public final b m;

    public static final class a {
    }

    static {
    }

    public OHorizontalScrollView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public OHorizontalScrollView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    private final void d() {
        if (this.j == true) goto L5;
        return;
    L5:
        boolean r0 = c(this.d);
        boolean r1 = c(this.e);
        if (r0 == false) goto L9;
        if (r1 == true) goto L9;
    L18:
        byte r2 = 2;
    L27:
        if (r2 == 2) goto L34;
        if (r2 != 3) goto L38;
        BounceEdgeEffect r3 = this.e;
        if (r3 == null) goto L38;
        r3.onRelease();
    L38:
        this.j = false;
        invalidate();
        return;
    L34:
        BounceEdgeEffect r4 = this.d;
        if (r4 == null) goto L38;
        r4.onRelease();
    L9:
        if (r1 == false) goto L12;
        if (r0 == true) goto L12;
    L25:
        r2 = 3;
    L12:
        BounceEdgeEffect r5 = this.d;
        if (r5 != null) goto L15;
        float r6 = 0.0f;
    L17:
        if (r6 > 0.0f) goto L18;
        BounceEdgeEffect r7 = this.e;
        if (r7 != null) goto L22;
        float r8 = 0.0f;
    L24:
        if (r8 < 0.0f) goto L25;
        r2 = -1;
        goto L27
    L22:
        r8 = r7.f;
        goto L24
    L15:
        r6 = r5.f;
        goto L17
    }

    private final boolean e() {
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
        boolean r2 = true;
    L22:
        if (r2 == false) goto L25;
        boolean r7 = false;
    L26:
        if (r0 != null) goto L29;
    L27:
        boolean r1 = false;
    L31:
        if (r1 == true) goto L41;
        BounceEdgeEffect r8 = this.e;
        if (r8 != null) goto L36;
    L34:
        boolean r9 = false;
    L38:
        if (r9 == true) goto L41;
        boolean r10 = false;
    L42:
        if (r7 == true) goto L46;
        if (r10 == true) goto L46;
        return false;
    L46:
        Field r11 = this.i;
        OverScroller r12 = null;
        if (r11 != null) goto L49;
        Object r13 = null;
    L51:
        if ((r13 instanceof OverScroller) == false) goto L53;
        r12 = (OverScroller) r13;
    L53:
        if (r12 == null) goto L56;
        r12.abortAnimation();
    L56:
        BounceEdgeEffect r14 = this.d;
        if (r14 == null) goto L60;
        r14.q();
    L60:
        BounceEdgeEffect r15 = this.e;
        if (r15 == null) goto L64;
        r15.q();
    L64:
        invalidate();
        return true;
    L49:
        r13 = r11.get(this);
        goto L51
    L36:
        if (r8.isFinished() == true) goto L34;
        r9 = true;
    L41:
        r10 = true;
        goto L42
    L29:
        if (r0.isFinished() == true) goto L27;
        r1 = true;
        goto L31
    L21:
        r2 = false;
        goto L22
    L17:
        r6 = r5.f;
    L25:
        r7 = true;
        goto L26
    L12:
        r4 = false;
        goto L13
    L8:
        r3 = r0.f;
        goto L10
    }

    private final float getCurrentFlingVelocity() {
        Field r1 = this.i;     // Catch: Throwable -> L14
        OverScroller r2 = null;
        if (r1 != null) goto L6;
        Object r3 = null;
    L8:
        if ((r3 instanceof OverScroller) == false) goto L10;
        r2 = (OverScroller) r3;     // Catch: Throwable -> L14
    L10:
        if (r2 != null) goto L12;
        return 1000.0f;
    L12:
        return r2.getCurrVelocity();
    L6:
        r3 = r1.get(this);     // Catch: Throwable -> L14
    L17:
        return 1000.0f;
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

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
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

    private static boolean c(BounceEdgeEffect r4) {
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

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas r4) {
        if (r4 != null) goto L5;
        return;
    L5:
        if (this.h == true) goto L8;
        super.dispatchDraw(r4);
        return;
    L8:
        BounceEdgeEffect r0 = this.d;
        if (r0 != null) goto L11;
        float r1 = 0.0f;
    L12:
        BounceEdgeEffect r2 = this.e;
        if (r2 != null) goto L15;
        float r3 = 0.0f;
    L16:
        float r5 = r1 + r3;
        if (r5 != 0.0f) goto L19;
        boolean r6 = true;
    L20:
        if (r6 == true) goto L22;
        int r7 = r4.save();
        r4.translate(r5, 0.0f);
        super.dispatchDraw(r4);
        r4.restoreToCount(r7);
        return;
    L22:
        super.dispatchDraw(r4);
        return;
    L19:
        r6 = false;
        goto L20
    L15:
        r3 = r2.f;
        goto L16
    L11:
        r1 = r0.f;
        goto L12
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(final MotionEvent r5) {
        Intrinsics.checkNotNullParameter(r5, "ev");
        this.m.c(r5);
        b r0 = this.m;
        Boolean r1 = r0.b(r5, -r0.e, 0.0f, new OHorizontalScrollView$dispatchTouchEvent$handled$1(this, r5));
        if (r1 != null) goto L5;
        boolean r2 = super.dispatchTouchEvent(r5);
    L7:
        if (r5.getActionMasked() != 1) goto L9;
    L10:
        d();
    L11:
        return r2;
    L9:
        if (r5.getActionMasked() != 3) goto L11;
    L5:
        r2 = r1.booleanValue();
        goto L7
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet r1) {
        return generateLayoutParams(r1);
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r4) {
        Intrinsics.checkNotNullParameter(r4, "ev");
        if (r4.getActionMasked() != 0) goto L16;
        if (e() == false) goto L7;
    L10:
        boolean r0 = true;
    L11:
        this.j = r0;
        boolean r1 = super.onInterceptTouchEvent(r4);
        if (this.m.d(r4) == false) goto L14;
        return false;
    L14:
        return r1;
    L7:
        if (this.j == true) goto L10;
        r0 = false;
        goto L11
    L16:
        if (this.m.d(r4) == false) goto L19;
        return false;
    L19:
        return super.onInterceptTouchEvent(r4);
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public final boolean onTouchEvent(MotionEvent r3) {
        Intrinsics.checkNotNullParameter(r3, "ev");
        int r0 = r3.getActionMasked();
        boolean r1 = true;
        if (r0 == 0) goto L18;
        if (r0 != 1) goto L6;
    L8:
        BounceEdgeEffect r2 = this.d;
        if (r2 == null) goto L12;
        r2.k = 0.0f;
    L12:
        BounceEdgeEffect r4 = this.e;
        if (r4 == null) goto L16;
        r4.k = 0.0f;
    L16:
        d();
    L25:
        return super.onTouchEvent(r3);
    L6:
        if (r0 == 3) goto L8;
    L18:
        if (e() == false) goto L20;
    L23:
        this.j = r1;
        goto L25
    L20:
        if (this.j == true) goto L23;
        r1 = false;
        goto L23
    }

    public void setOnBounceTranslationListener(e r2) {
        BounceTranslationDelegate r0 = this.l;
        r0.c = r2;
        r0.a();
    }

    public static final /* synthetic */ boolean b(OHorizontalScrollView r0, MotionEvent r1) {
        return super.dispatchTouchEvent(r1);
    }

    private static Field f(Class r0, String r1) {
        Field r2 = r0.getDeclaredField(r1);     // Catch: Throwable -> L4
        r2.setAccessible(true);     // Catch: Throwable -> L4
        return r2;
    L4:
        return null;
    }

    public OHorizontalScrollView(Context r8, AttributeSet r9, int r10) {
        Intrinsics.checkNotNullParameter(r8, "context");
        super(r8, r9, r10);
        this.k = new d(new OHorizontalScrollView$overscrollDelegate$1(this), new OHorizontalScrollView$overscrollDelegate$2(this));
        this.l = new BounceTranslationDelegate(new OHorizontalScrollView$translationDelegate$1(this), new OHorizontalScrollView$translationDelegate$2(this));
        this.m = new b(this, new OHorizontalScrollView$clickDuringOverScrollDelegate$1(this), new OHorizontalScrollView$clickDuringOverScrollDelegate$2(this));
        setOverScrollMode(0);
        WeakHashMap<View, BounceEdgeEffect.a.C0121a> r11 = BounceEdgeEffect.u;
        BounceEdgeEffect.a.a("Landroid/widget/HorizontalScrollView;");
        if (this.a == true) goto L20;
        this.a = true;
        Field r1 = f(HorizontalScrollView.class, "mEdgeGlowLeft");     // Catch: Throwable -> L18
        if (r1 != null) goto L11;
        r1 = f(HorizontalScrollView.class, "mLeftGlow");     // Catch: Throwable -> L18
        if (r1 != null) goto L11;
        r1 = f(HorizontalScrollView.class, "mEdgeEffectLeft");     // Catch: Throwable -> L18
    L11:
        this.b = r1;     // Catch: Throwable -> L18
        Field r2 = f(HorizontalScrollView.class, "mEdgeGlowRight");     // Catch: Throwable -> L18
        if (r2 != null) goto L16;
        r2 = f(HorizontalScrollView.class, "mRightGlow");     // Catch: Throwable -> L18
        if (r2 != null) goto L16;
        r2 = f(HorizontalScrollView.class, "mEdgeEffectRight");     // Catch: Throwable -> L18
    L16:
        this.c = r2;     // Catch: Throwable -> L18
        this.i = f(HorizontalScrollView.class, "mScroller");     // Catch: Throwable -> L18
    L18:
        this.b = null;
        this.c = null;
        this.i = null;
    L20:
        if (this.d == null) goto L22;
        return;
    L22:
        if (this.e != null) goto L62;
        this.k.b();
        Field r12 = this.b;
        if (r12 == null) goto L63;
        Field r3 = this.c;
        if (r3 == null) goto L64;
        Object r4 = r12.get(this);     // Catch: Throwable -> L45
        if ((r4 instanceof EdgeEffect) == false) goto L33;
        EdgeEffect r5 = (EdgeEffect) r4;     // Catch: Throwable -> L45
    L34:
        this.f = r5;     // Catch: Throwable -> L45
        Object r6 = r3.get(this);     // Catch: Throwable -> L45
        if ((r6 instanceof EdgeEffect) == false) goto L37;
        EdgeEffect r7 = (EdgeEffect) r6;     // Catch: Throwable -> L45
    L38:
        this.g = r7;     // Catch: Throwable -> L45
        BounceEdgeEffect r13 = new BounceEdgeEffect(getContext(), this, 2, this.k.c);     // Catch: Throwable -> L45
        r13.e = true;     // Catch: Throwable -> L45
        BounceEdgeEffect r14 = new BounceEdgeEffect(getContext(), this, 3, this.k.c);     // Catch: Throwable -> L45
        r14.e = true;     // Catch: Throwable -> L45
        if (getWidth() > 0) goto L41;
    L43:
        r12.set(this, r13);     // Catch: Throwable -> L45
        r3.set(this, r14);     // Catch: Throwable -> L45
        this.d = r13;     // Catch: Throwable -> L45
        this.e = r14;     // Catch: Throwable -> L45
        this.h = true;     // Catch: Throwable -> L45
        this.k.a();     // Catch: Throwable -> L45
        this.l.a();     // Catch: Throwable -> L45
        return;
    L41:
        if (getHeight() <= 0) goto L43;
        r13.setSize(getWidth(), getHeight());     // Catch: Throwable -> L45
        r14.setSize(getWidth(), getHeight());     // Catch: Throwable -> L45
        goto L43
    L37:
        r7 = null;
        goto L38
    L33:
        r5 = null;
    L45:
        Field r15 = this.b;     // Catch: Throwable -> L55
        if (r15 == null) goto L49;
        r15.set(this, this.f);     // Catch: Throwable -> L55
    L49:
        Field r16 = this.c;     // Catch: Throwable -> L55
        if (r16 == null) goto L53;
        r16.set(this, this.g);     // Catch: Throwable -> L55
    L53:
        this.d = null;
        this.e = null;
        this.h = false;
        return;
    L64:
        return;
    L63:
        return;
    }

    public /* synthetic */ OHorizontalScrollView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public final void onSizeChanged(int r1, int r2, int r3, int r4) {
        super.onSizeChanged(r1, r2, r3, r4);
        this.k.b();
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
    public final boolean overScrollBy(int r4, int r5, int r6, int r7, int r8, int r9, int r10, int r11, boolean r12) {
        if (r12 == true) goto L4;
    L13:
        boolean r13 = super.overScrollBy(r4, r5, r6, r7, r8, r9, r10, r11, r12);
        if (r12 == false) goto L16;
    L77:
        return r13;
    L16:
        if (this.h == false) goto L77;
        if (r8 <= 0) goto L77;
        int r14 = r6 + r4;
        int r15 = c.a;
        OverScroller r16 = null;
        boolean r17 = false;
        if (r14 > 0) goto L50;
        if (r4 >= 0) goto L50;
        BounceEdgeEffect r18 = this.d;
        if (r18 != null) goto L25;
    L27:
        boolean r110 = false;
    L28:
        if (r110 == false) goto L50;
        float r111 = getCurrentFlingVelocity();
        int r0 = Math.abs(r14);
        BounceEdgeEffect r1 = this.d;
        if (r1 == null) goto L33;
        r1.onPull(r0 / getWidth(), 0.5f);
    L33:
        BounceEdgeEffect r2 = this.d;
        if (r2 == null) goto L79;
        r2.onAbsorb((int) r111);
    L79:
        Field r112 = this.i;     // Catch: Throwable -> L49
        if (r112 != null) goto L40;
        Object r113 = null;
    L42:
        if ((r113 instanceof OverScroller) == false) goto L44;
        OverScroller r114 = (OverScroller) r113;     // Catch: Throwable -> L49
    L45:
        if (r114 == null) goto L50;
        r114.abortAnimation();     // Catch: Throwable -> L49
        goto L50
    L44:
        r114 = null;
        goto L45
    L40:
        r113 = r112.get(this);     // Catch: Throwable -> L49
        goto L42
    L25:
        if (r18.isFinished() != true) goto L27;
        r110 = true;
    L50:
        if (r14 < r8) goto L77;
        if (r4 <= 0) goto L77;
        BounceEdgeEffect r20 = this.e;
        if (r20 != null) goto L56;
    L58:
        if (r17 == false) goto L77;
        float r21 = getCurrentFlingVelocity();
        int r22 = r14 - r8;
        BounceEdgeEffect r23 = this.e;
        if (r23 == null) goto L63;
        r23.onPull(r22 / getWidth(), 0.5f);
    L63:
        BounceEdgeEffect r24 = this.e;
        if (r24 == null) goto L81;
        r24.onAbsorb(-((int) r21));
    L81:
        Field r25 = this.i;     // Catch: Throwable -> L78
        if (r25 != null) goto L70;
        Object r26 = null;
    L72:
        if ((r26 instanceof OverScroller) == false) goto L74;
        r16 = (OverScroller) r26;     // Catch: Throwable -> L78
    L74:
        if (r16 == null) goto L77;
        r16.abortAnimation();     // Catch: Throwable -> L78
        goto L77
    L70:
        r26 = r25.get(this);     // Catch: Throwable -> L78
        goto L72
    L56:
        if (r20.isFinished() != true) goto L58;
        r17 = true;
        goto L58
    L4:
        if (this.h == false) goto L13;
        float r3 = r4;
        BounceEdgeEffect r27 = this.d;
        if (r27 == null) goto L9;
        r27.k = r3;
    L9:
        BounceEdgeEffect r28 = this.e;
        if (r28 == null) goto L13;
        r28.k = r3;
        goto L13
    }
}
