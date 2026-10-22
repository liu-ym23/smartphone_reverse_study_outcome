package com.obric.oui.bouncelayout;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.widget.EdgeEffect;
import android.widget.OverScroller;
import android.widget.ScrollView;
import java.lang.reflect.Field;
import java.util.WeakHashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0015\u0010\r¨\u0006\u0016"}, d2 = {"Lcom/obric/oui/bouncelayout/OScrollView;", "Landroid/widget/ScrollView;", "", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "", "getBounceTranslation", "()F", "Lcom/obric/oui/bouncelayout/f;", "listener", "", "setOnBounceTranslationListener", "(Lcom/obric/oui/bouncelayout/f;)V", "getScrollRangeY", "()I", "getCurrentFlingVelocity", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OScrollView extends ScrollView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f12077a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Field f12078b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Field f12079c;
    public final b d;
    public final b e;
    public final EdgeEffect f;
    public final EdgeEffect g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f12080h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Field f12081i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f12082j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f12083k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f12084l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f12085m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f12086n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f12087o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f12088p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f12089q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final c f12090r;
    public final d s;

    @JvmOverloads
    public OScrollView(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        int r10 = 6;
        this(r5, null, r10, 0);
    }

    public static boolean c(b r5) {
        if (r5 != null) goto L4;
    L10:
        return false;
    L4:
        if (r5.getDistance() == 0.0f) goto L6;
    L9:
        return true;
    L6:
        if (r5.f != 0.0f) goto L9;
        if (r5.isFinished() == true) goto L10;
        goto L9
    }

    private final float getCurrentFlingVelocity() {
        Field r5 = this.f12081i;     // Catch: Throwable -> L10
        OverScroller r10 = null;
        if (r5 != null) goto L6;
        Object r11 = null;
    L8:
        if ((r11 instanceof OverScroller) == false) goto L12;
        r10 = (OverScroller) r11;     // Catch: Throwable -> L10
    L12:
        if (r10 != null) goto L14;
        return 1000.0f;
    L14:
        return r10.getCurrVelocity();
    L6:
        r11 = r5.get(this);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        Log.w("OScrollView", "Failed to get scroller velocity", th);
        return 1000.0f;
    }

    private final int getScrollRangeY() {
        View r5 = getChildAt(0);
        if (r5 != null) goto L5;
        return 0;
    L5:
        int r10 = (getHeight() - getPaddingTop()) - getPaddingBottom();
        return Math.max(0, r5.getHeight() - r10);
    }

    public static Field i(String r5) {
        Field r10 = ScrollView.class.getDeclaredField(r5);     // Catch: Throwable -> L5
        r10.setAccessible(true);     // Catch: Throwable -> L5
        return r10;
    L5:
        th = move-exception;
        Log.w("OScrollView", "Failed to reflect edge effect fields", th);
        return null;
    }

    public final void a() {
        Field r5 = this.f12081i;     // Catch: Throwable -> L13
        OverScroller r10 = null;
        if (r5 != null) goto L5;
        Object r11 = null;
    L7:
        if ((r11 instanceof OverScroller) == false) goto L9;
        r10 = (OverScroller) r11;     // Catch: Throwable -> L13
    L9:
        if (r10 == null) goto L16;
        r10.abortAnimation();     // Catch: Throwable -> L13
        return;
    L16:
        return;
    L5:
        r11 = r5.get(this);     // Catch: Throwable -> L13
    }

    public final void b(MotionEvent r5) {
        int r10 = r5.getActionIndex();
        if (r10 >= 0) goto L5;
        return;
    L5:
        if (r10 < r5.getPointerCount()) goto L8;
        return;
    L8:
        if (r5.getPointerId(r10) == this.f12088p) goto L10;
        return;
    L10:
        if (r10 != 0) goto L12;
        int r11 = 1;
    L14:
        if (r11 >= r5.getPointerCount()) goto L16;
        j(r5, r11);
        return;
    L16:
        this.f12088p = -1;
        return;
    L12:
        r11 = 0;
        goto L14
    }

    public final void d() {
        this.f12083k = false;
        this.f12084l = false;
        this.f12088p = -1;
        this.f12089q = false;
        int r5 = f();
        if (r5 != 1) goto L5;
        b r10 = this.d;
        if (r10 == null) goto L15;
        r10.onRelease();
    L15:
        this.f12087o = 0;
        invalidate();
        return;
    L5:
        if (r5 != 2) goto L15;
        b r11 = this.e;
        if (r11 == null) goto L15;
        r11.onRelease();
        goto L15
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r5) {
        if (r5 != null) goto L5;
        super.dispatchDraw(r5);
        return;
    L5:
        b r10 = this.d;
        if (r10 != null) goto L8;
        float r11 = 0.0f;
    L9:
        b r12 = this.e;
        if (r12 != null) goto L12;
        float r13 = 0.0f;
    L13:
        float r14 = r11 + r13;
        if (r14 != 0.0f) goto L16;
        super.dispatchDraw(r5);
        return;
    L16:
        int r15 = r5.save();
        r5.translate(0.0f, r14);
        super.dispatchDraw(r5);
        r5.restoreToCount(r15);
        return;
    L12:
        r13 = r12.f;
        goto L13
    L8:
        r11 = r10.f;
        goto L9
    }

    public final void e() {
        if (this.f12089q == true) goto L5;
        return;
    L5:
        int r5 = f();
        if (r5 != 1) goto L8;
        b r10 = this.d;
        if (r10 == null) goto L18;
        r10.onRelease();
    L18:
        this.f12089q = false;
        invalidate();
        return;
    L8:
        if (r5 != 2) goto L18;
        b r11 = this.e;
        if (r11 == null) goto L18;
        r11.onRelease();
        goto L18
    }

    public final int f() {
        int r5 = this.f12087o;
        if (r5 == 0) goto L5;
        return r5;
    L5:
        boolean r10 = c(this.d);
        boolean r11 = c(this.e);
        if (r10 == false) goto L10;
        if (r11 == true) goto L10;
        return 1;
    L10:
        if (r11 == false) goto L13;
        if (r10 == true) goto L13;
    L29:
        return 2;
    L13:
        b r12 = this.d;
        if (r12 != null) goto L16;
        float r13 = 0.0f;
    L18:
        if (r13 > 0.0f) goto L31;
        b r14 = this.e;
        if (r14 != null) goto L23;
        float r15 = 0.0f;
    L25:
        if (r15 < 0.0f) goto L29;
        return 0;
    L23:
        r15 = r14.f;
        goto L25
    L31:
        return 1;
    L16:
        r13 = r12.f;
        goto L18
    }

    public final void g() {
        Field r5 = this.f12078b;     // Catch: Throwable -> L11
        if (r5 == null) goto L6;
        r5.set(this, this.f);     // Catch: Throwable -> L11
    L6:
        Field r10 = this.f12079c;     // Catch: Throwable -> L11
        if (r10 == null) goto L16;
        r10.set(this, this.g);     // Catch: Throwable -> L11
        return;
    L16:
        return;
    L11:
        th = move-exception;
        Log.w("OScrollView", "Failed to restore original edge effects", th);
    }

    public float getBounceTranslation() {
        b r5 = this.d;
        float r10 = 0.0f;
        if (r5 != null) goto L5;
        float r11 = 0.0f;
    L6:
        b r12 = this.e;
        if (r12 == null) goto L11;
        r10 = r12.f;
    L11:
        return r11 + r10;
    L5:
        r11 = r5.f;
        goto L6
    }

    public final boolean h() {
        if (this.f12080h == true) goto L5;
        return false;
    L5:
        b r5 = this.d;
        if (r5 != null) goto L8;
        float r10 = 0.0f;
    L10:
        if (r10 != 0.0f) goto L18;
        b r11 = this.e;
        if (r11 != null) goto L14;
        float r12 = 0.0f;
    L16:
        if (r12 != 0.0f) goto L18;
        boolean r13 = false;
    L19:
        if (r5 != null) goto L22;
    L24:
        b r14 = this.e;
        if (r14 != null) goto L28;
    L30:
        boolean r15 = false;
    L31:
        if (r13 == true) goto L35;
        if (r15 == true) goto L35;
        return false;
    L35:
        a();
        b r16 = this.d;
        if (r16 == null) goto L39;
        r16.n();
    L39:
        b r17 = this.e;
        if (r17 == null) goto L43;
        r17.n();
    L43:
        invalidate();
        return true;
    L28:
        if (r14.isFinished() == true) goto L30;
    L29:
        r15 = true;
        goto L31
    L22:
        if (r5.isFinished() == true) goto L24;
    L14:
        r12 = r11.f;
    L18:
        r13 = true;
        goto L19
    L8:
        r10 = r5.f;
        goto L10
    }

    public final void j(MotionEvent r5, int r10) {
        if (r10 >= 0) goto L4;
        return;
    L4:
        if (r10 >= r5.getPointerCount()) goto L9;
        this.f12088p = r5.getPointerId(r10);
        this.f12086n = r5.getY(r10);
        return;
    }

    @Override // android.widget.ScrollView, android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        b r5 = this.d;
        if (r5 == null) goto L6;
        r5.finish();
    L6:
        b r10 = this.e;
        if (r10 == null) goto L10;
        r10.finish();
    L10:
        g();
    }

    @Override // android.widget.ScrollView, android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r10) {
        Intrinsics.checkNotNullParameter(r10, "ev");
        int r5 = r10.getActionMasked();
        if (r5 != 0) goto L5;
        this.f12089q = h();
        this.f12083k = false;
        this.f12084l = false;
        this.f12087o = 0;
        this.f12088p = r10.getPointerId(0);
        float r11 = r10.getY(0);
        this.f12085m = r11;
        this.f12086n = r11;
    L61:
        return super.onInterceptTouchEvent(r10);
    L5:
        if (r5 != 1) goto L7;
    L58:
        this.f12083k = false;
        this.f12084l = false;
        this.f12087o = 0;
        this.f12088p = -1;
        e();
        goto L61
    L7:
        if (r5 == 2) goto L24;
        if (r5 == 3) goto L58;
        if (r5 == 5) goto L20;
        if (r5 != 6) goto L61;
        if (this.f12083k == false) goto L61;
        b(r10);
        return true;
    L20:
        if (this.f12083k == false) goto L61;
        j(r10, r10.getActionIndex());
        return true;
    L24:
        if (this.f12080h == false) goto L61;
        if (getHeight() <= 0) goto L61;
        if (getScrollRangeY() > 0) goto L32;
    L35:
        int r12 = r10.findPointerIndex(this.f12088p);
        if (r12 >= 0) goto L38;
        return false;
    L38:
        float r13 = r10.getY(r12) - this.f12085m;
        if (Math.abs(r13) <= this.f12082j) goto L61;
        if (c(this.d) == false) goto L44;
    L53:
        this.f12083k = true;
        this.f12084l = true;
        this.f12089q = false;
        this.f12086n = this.f12085m;
        ViewParent r14 = getParent();
        if (r14 == null) goto L57;
        r14.requestDisallowInterceptTouchEvent(true);
    L57:
        return true;
    L44:
        if (c(this.e) == true) goto L53;
        if (r13 <= 0.0f) goto L52;
        if (canScrollVertically(-1) == true) goto L61;
    L52:
        if (canScrollVertically(1) == true) goto L61;
    L32:
        if (c(this.d) == true) goto L35;
        if (c(this.e) == false) goto L61;
        goto L35
    }

    @Override // android.widget.ScrollView, android.view.View
    public final void onSizeChanged(int r5, int r10, int r11, int r12) {
        super.onSizeChanged(r5, r10, r11, r12);
        this.f12090r.b();
        b r13 = this.d;
        if (r13 == null) goto L6;
        r13.setSize(r5, r10);
    L6:
        b r14 = this.e;
        if (r14 == null) goto L11;
        r14.setSize(r5, r10);
        return;
    }

    @Override // android.widget.ScrollView, android.view.View
    public final boolean onTouchEvent(MotionEvent r10) {
        Intrinsics.checkNotNullParameter(r10, "ev");
        int r5 = r10.getActionMasked();
        boolean r11 = true;
        if (r5 == 0) goto L67;
        if (r5 == 1) goto L62;
        if (r5 == 2) goto L23;
        if (r5 == 3) goto L62;
        if (r5 == 5) goto L19;
        if (r5 != 6) goto L74;
        if (this.f12083k == false) goto L74;
        b(r10);
        return true;
    L74:
        return super.onTouchEvent(r10);
    L19:
        if (this.f12083k == false) goto L74;
        j(r10, r10.getActionIndex());
        return true;
    L23:
        if (this.f12083k == false) goto L74;
        int r12 = r10.findPointerIndex(this.f12088p);
        if (r12 >= 0) goto L28;
        d();
        return true;
    L28:
        float r13 = r10.getY(r12);
        float r14 = r13 - this.f12086n;
        if (this.f12084l == true) goto L31;
    L59:
        this.f12086n = r13;
        return true;
    L31:
        if (r14 == 0.0f) goto L59;
        if (getHeight() <= 0) goto L59;
        float r15 = r14 / getHeight();
        boolean r16 = c(this.d);
        boolean r17 = c(this.e);
        if (r16 == false) goto L42;
        this.f12087o = 1;
        b r18 = this.d;
        if (r18 == null) goto L58;
        r18.onPull(r15, 0.5f);
    L58:
        invalidate();
        goto L59
    L42:
        if (r17 == false) goto L48;
        this.f12087o = 2;
        b r19 = this.e;
        if (r19 == null) goto L58;
        r19.onPull(-r15, 0.5f);
        goto L58
    L48:
        if (r14 <= 0.0f) goto L53;
        this.f12087o = 1;
        b r20 = this.d;
        if (r20 == null) goto L58;
        r20.onPull(r15, 0.5f);
        goto L58
    L53:
        if (r14 >= 0.0f) goto L58;
        this.f12087o = 2;
        b r21 = this.e;
        if (r21 == null) goto L58;
        r21.onPull(-r15, 0.5f);
    L62:
        if (this.f12083k == false) goto L65;
        d();
        return true;
    L65:
        e();
        goto L74
    L67:
        if (h() == false) goto L69;
    L72:
        this.f12089q = r11;
        this.f12083k = false;
        this.f12084l = false;
        this.f12087o = 0;
        this.f12088p = r10.getPointerId(0);
        float r22 = r10.getY(0);
        this.f12085m = r22;
        this.f12086n = r22;
        goto L74
    L69:
        if (this.f12089q == true) goto L72;
        r11 = false;
        goto L72
    }

    @Override // android.view.View
    public final boolean overScrollBy(int r5, int r10, int r11, int r12, int r13, int r14, int r15, int r16, boolean r17) {
        boolean r18 = super.overScrollBy(r5, r10, r11, r12, r13, r14, r15, r16, r17);
        if (r17 == false) goto L5;
    L44:
        return r18;
    L5:
        if (this.f12080h == false) goto L44;
        if (r14 <= 0) goto L44;
        int r19 = r12 + r10;
        if (r19 > 0) goto L26;
        if (r10 >= 0) goto L26;
        b r20 = this.d;
        if (r20 == null) goto L26;
        if (r20.isFinished() != true) goto L26;
        float r21 = getCurrentFlingVelocity();
        int r22 = Math.abs(r19);
        if (getHeight() <= 0) goto L21;
        b r110 = this.d;
        if (r110 == null) goto L21;
        r110.onPull(r22 / getHeight(), 0.5f);
    L21:
        b r23 = this.d;
        if (r23 == null) goto L25;
        r23.onAbsorb((int) r21);
    L25:
        a();
    L26:
        if (r19 < r14) goto L44;
        if (r10 <= 0) goto L44;
        b r24 = this.e;
        if (r24 == null) goto L44;
        if (r24.isFinished() != true) goto L44;
        float r25 = getCurrentFlingVelocity();
        int r26 = r19 - r14;
        if (getHeight() <= 0) goto L39;
        b r27 = this.e;
        if (r27 == null) goto L39;
        r27.onPull(r26 / getHeight(), 0.5f);
    L39:
        b r28 = this.e;
        if (r28 == null) goto L43;
        r28.onAbsorb(-((int) r25));
    L43:
        a();
        goto L44
    }

    public void setOnBounceTranslationListener(f r5) {
        this.s.a();
    }

    @JvmOverloads
    public OScrollView(Context r5, AttributeSet r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this(r5, r10, 4, 0);
    }

    public /* synthetic */ OScrollView(Context r5, AttributeSet r10, int r11, int r12) {
        if ((r11 & 2) == 0) goto L5;
        r10 = null;
    L5:
        this(r5, r10, 0);
    }

    @JvmOverloads
    public OScrollView(Context r10, AttributeSet r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11, r12);
        this.f12082j = ViewConfiguration.get(r10).getScaledTouchSlop();
        this.f12088p = -1;
        this.f12090r = new c(new OScrollView$overscrollDelegate$1(this), new OScrollView$overscrollDelegate$2(this));
        this.s = new d(new OScrollView$translationDelegate$1(this), new OScrollView$translationDelegate$2(this));
        setOverScrollMode(0);
        WeakHashMap r13 = b.s;
        ym.a.f("Landroid/widget/ScrollView;");
        if (this.f12077a == true) goto L18;
        this.f12077a = true;
        Field r14 = i("mEdgeGlowTop");     // Catch: Throwable -> L9
        if (r14 != null) goto L11;
        r14 = i("mTopGlow");     // Catch: Throwable -> L9
    L11:
        this.f12078b = r14;     // Catch: Throwable -> L9
        Field r15 = i("mEdgeGlowBottom");     // Catch: Throwable -> L9
        if (r15 != null) goto L14;
        r15 = i("mBottomGlow");     // Catch: Throwable -> L9
    L14:
        this.f12079c = r15;     // Catch: Throwable -> L9
        this.f12081i = i("mScroller");     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        Log.w("OScrollView", "Failed to reflect edge effect fields", th);
        this.f12078b = null;
        this.f12079c = null;
        this.f12081i = null;
    L18:
        if (this.d == null) goto L20;
        return;
    L20:
        if (this.e != null) goto L52;
        c r16 = this.f12090r;
        r16.b();
        Field r5 = this.f12078b;
        if (r5 == null) goto L53;
        Field r17 = this.f12079c;
        if (r17 == null) goto L54;
        Object r18 = r5.get(this);     // Catch: Throwable -> L31
        if ((r18 instanceof EdgeEffect) == false) goto L33;
        EdgeEffect r19 = (EdgeEffect) r18;     // Catch: Throwable -> L31
    L34:
        this.f = r19;     // Catch: Throwable -> L31
        Object r20 = r17.get(this);     // Catch: Throwable -> L31
        if ((r20 instanceof EdgeEffect) == false) goto L37;
        EdgeEffect r21 = (EdgeEffect) r20;     // Catch: Throwable -> L31
    L38:
        this.g = r21;     // Catch: Throwable -> L31
        b r22 = new b(getContext(), this, 0, r16.f12113c);     // Catch: Throwable -> L31
        b r23 = new b(getContext(), this, 1, r16.f12113c);     // Catch: Throwable -> L31
        if (getWidth() > 0) goto L41;
    L43:
        r5.set(this, r22);     // Catch: Throwable -> L31
        r17.set(this, r23);     // Catch: Throwable -> L31
        this.d = r22;     // Catch: Throwable -> L31
        this.e = r23;     // Catch: Throwable -> L31
        this.f12080h = true;     // Catch: Throwable -> L31
        r16.a();     // Catch: Throwable -> L31
        this.s.a();     // Catch: Throwable -> L31
        return;
    L41:
        if (getHeight() <= 0) goto L43;
        r22.setSize(getWidth(), getHeight());     // Catch: Throwable -> L31
        r23.setSize(getWidth(), getHeight());     // Catch: Throwable -> L31
        goto L43
    L37:
        r21 = null;
        goto L38
    L33:
        r19 = null;
    L31:
        th = move-exception;
        Log.w("OScrollView", "Failed to install BounceEdgeEffects, restoring original.", th);
        g();
        this.d = null;
        this.e = null;
        this.f12080h = false;
        return;
    L54:
        return;
    L53:
        return;
    }
}
