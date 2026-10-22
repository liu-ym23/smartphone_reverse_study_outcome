package com.obric.oui.bouncelayout;

import android.R;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.AbsListView;
import android.widget.GridView;
import android.widget.OverScroller;
import java.lang.reflect.Field;
import java.util.WeakHashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0011\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/obric/oui/bouncelayout/OGridView;", "Landroid/widget/GridView;", "", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Landroid/widget/OverScroller;", "getOverScrollerOrNull", "()Landroid/widget/OverScroller;", "", "getBounceTranslation", "()F", "Lcom/obric/oui/bouncelayout/f;", "listener", "", "setOnBounceTranslationListener", "(Lcom/obric/oui/bouncelayout/f;)V", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class OGridView extends GridView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f12028a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f12029b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f12030c;
    public float d;
    public int e;
    public int f;
    public final Object g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Object f12031h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Field f12032i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Field f12033j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Field f12034k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final c f12035l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final d f12036m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Field f12037n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Field f12038o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final boolean f12039p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public float f12040q;

    @JvmOverloads
    public OGridView(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        int r10 = 6;
        this(r5, null, r10, 0);
    }

    public static Field c(Class r5, String r10) {
        Field r11 = r5.getDeclaredField(r10);     // Catch: Throwable -> L4
        r11.setAccessible(true);     // Catch: Throwable -> L4
        return r11;
    L4:
        th = move-exception;
        Log.w("OGridView", "Failed to reflect edge effect fields", th);
        return null;
    }

    private final OverScroller getOverScrollerOrNull() {
        Field r5 = this.f12032i;     // Catch: Throwable -> L31
        if (r5 != null) goto L6;
        Object r10 = null;
    L8:
        if ((r10 instanceof OverScroller) == false) goto L11;
        OverScroller r11 = (OverScroller) r10;     // Catch: Throwable -> L31
    L12:
        if (r11 == null) goto L34;
        return r11;
    L11:
        r11 = null;
        goto L12
    L6:
        r10 = r5.get(this);     // Catch: Throwable -> L31
    L34:
        Field r12 = this.f12033j;     // Catch: Throwable -> L33
        if (r12 == null) goto L19;
        Object r13 = r12.get(this);     // Catch: Throwable -> L33
    L20:
        if (r13 != null) goto L36;
        return null;
    L36:
        Field r14 = this.f12034k;     // Catch: Throwable -> L32
        if (r14 != null) goto L25;
        Object r15 = null;
    L27:
        if ((r15 instanceof OverScroller) == false) goto L40;
        return (OverScroller) r15;
    L40:
        return null;
    L25:
        r15 = r14.get(r13);     // Catch: Throwable -> L32
    L41:
        return null;
    L19:
        r13 = null;
        goto L20
    }

    public final void a(Runnable r5) {
        if (r5 != null) goto L12;
        r5 = null;
        Field r10 = this.f12033j;     // Catch: Throwable -> L15
        if (r10 != null) goto L7;
        Object r11 = null;
    L9:
        if ((r11 instanceof Runnable) == false) goto L12;
        r5 = (Runnable) r11;     // Catch: Throwable -> L15
        goto L12
    L7:
        r11 = r10.get(this);     // Catch: Throwable -> L15
    L12:
        if (r5 == null) goto L18;
        removeCallbacks(r5);
        return;
    }

    public final void b() {
        if (this.f12030c == true) goto L5;
        return;
    L5:
        OverScroller r5 = getOverScrollerOrNull();
        b r10 = this.f12028a;
        if (r10 != null) goto L8;
        float r11 = 0.0f;
    L9:
        boolean r12 = true;
        if (r11 != 0.0f) goto L18;
        b r13 = this.f12029b;
        if (r13 != null) goto L14;
        float r14 = 0.0f;
    L16:
        if (r14 != 0.0f) goto L18;
        boolean r15 = false;
    L19:
        if (r10 != null) goto L22;
    L24:
        b r16 = this.f12029b;
        if (r16 != null) goto L28;
    L30:
        r12 = false;
    L31:
        if (r15 == true) goto L33;
        if (r12 == true) goto L33;
    L56:
        this.d = 0.0f;
        this.e = 0;
        this.f = computeVerticalScrollOffset();
        return;
    L33:
        if (r5 != null) goto L36;
    L38:
        Runnable r17 = null;
        Field r18 = this.f12033j;     // Catch: Throwable -> L58
        if (r18 != null) goto L42;
        Object r19 = null;
    L44:
        if ((r19 instanceof Runnable) == false) goto L47;
        r17 = (Runnable) r19;     // Catch: Throwable -> L58
        goto L47
    L42:
        r19 = r18.get(this);     // Catch: Throwable -> L58
    L47:
        a(r17);
        b r20 = this.f12028a;
        if (r20 == null) goto L51;
        r20.n();
    L51:
        b r21 = this.f12029b;
        if (r21 == null) goto L55;
        r21.n();
    L55:
        invalidate();
        goto L56
    L36:
        if (r5.isFinished() == true) goto L38;
        r5.abortAnimation();
        goto L38
    L28:
        if (r16.isFinished() == true) goto L30;
    L22:
        if (r10.isFinished() == true) goto L24;
    L14:
        r14 = r13.f;
    L18:
        r15 = true;
        goto L19
    L8:
        r11 = r10.f;
        goto L9
    }

    @Override // android.view.View
    public final void computeScroll() {
        super.computeScroll();
        if (this.f12030c == true) goto L5;
        return;
    L5:
        int r5 = computeVerticalScrollExtent();
        if (computeVerticalScrollRange() > r5) goto L8;
        return;
    L8:
        int r10 = computeVerticalScrollOffset();
        OverScroller r11 = getOverScrollerOrNull();
        if (r11 != null) goto L11;
    L46:
        float r12 = this.d;
        if (r12 <= 0.0f) goto L61;
        boolean r13 = canScrollList(-1);
        boolean r14 = canScrollList(1);
        int r15 = this.e;
        if (r15 >= 0) goto L55;
        if (r13 == true) goto L55;
        b r16 = this.f12028a;
        if (r16 == null) goto L61;
        r16.onAbsorb((int) r12);
    L55:
        if (r15 <= 0) goto L61;
        if (r14 == true) goto L61;
        b r17 = this.f12029b;
        if (r17 == null) goto L61;
        r17.onAbsorb(-((int) r12));
    L61:
        this.d = 0.0f;
        this.e = 0;
        this.f = r10;
        return;
    L11:
        if (r11.isFinished() == true) goto L46;
        float r18 = r11.getCurrVelocity();
        this.d = r18;
        int r19 = r10 - this.f;
        if (r19 <= 0) goto L15;
        this.e = 1;
    L17:
        this.f = r10;
        if (r18 <= 0.0f) goto L66;
        boolean r20 = canScrollList(-1);
        boolean r21 = canScrollList(1);
        if (this.e >= 0) goto L33;
        if (r20 == true) goto L33;
        b r22 = this.f12028a;
        if (r22 == null) goto L33;
        if (r22.isFinished() != true) goto L33;
        b r23 = this.f12028a;
        if (r23 == null) goto L44;
        r23.onAbsorb((int) r18);
    L44:
        r11.abortAnimation();
        a(null);
        this.d = 0.0f;
        this.e = 0;
        invalidate();
        return;
    L33:
        if (this.e <= 0) goto L63;
        if (r21 == true) goto L64;
        b r24 = this.f12029b;
        if (r24 != null) goto L39;
        return;
    L39:
        if (r24.isFinished() != true) goto L65;
        b r25 = this.f12029b;
        if (r25 == null) goto L44;
        r25.onAbsorb(-((int) r18));
        goto L44
    L65:
        return;
    L64:
        return;
    L63:
        return;
    L66:
        return;
    L15:
        if (r19 >= 0) goto L17;
        this.e = -1;
        goto L17
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r5) {
        if (r5 != null) goto L5;
        super.dispatchDraw(r5);
        return;
    L5:
        b r10 = this.f12028a;
        if (r10 != null) goto L8;
        float r11 = 0.0f;
    L9:
        b r12 = this.f12029b;
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

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r10) {
        Intrinsics.checkNotNullParameter(r10, "ev");
        if (r10.getActionMasked() != 0) goto L5;
        this.f12040q = getBounceTranslation();
    L5:
        float r5 = this.f12040q;
        if (r5 == 0.0f) goto L8;
        r10.offsetLocation(0.0f, -r5);
        boolean r11 = super.dispatchTouchEvent(r10);
        r10.offsetLocation(0.0f, r5);
        if (r10.getActionMasked() != 1) goto L17;
    L18:
        this.f12040q = 0.0f;
    L19:
        return r11;
    L17:
        if (r10.getActionMasked() != 3) goto L19;
    L8:
        if (r10.getActionMasked() != 1) goto L10;
    L11:
        this.f12040q = 0.0f;
    L13:
        return super.dispatchTouchEvent(r10);
    L10:
        if (r10.getActionMasked() != 3) goto L13;
        goto L11
    }

    public float getBounceTranslation() {
        b r5 = this.f12028a;
        float r10 = 0.0f;
        if (r5 != null) goto L5;
        float r11 = 0.0f;
    L6:
        b r12 = this.f12029b;
        if (r12 == null) goto L11;
        r10 = r12.f;
    L11:
        return r11 + r10;
    L5:
        r11 = r5.f;
        goto L6
    }

    @Override // android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        b r5 = this.f12028a;
        if (r5 == null) goto L6;
        r5.finish();
    L6:
        b r10 = this.f12029b;
        if (r10 == null) goto L11;
        r10.finish();
        return;
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r5) {
        Intrinsics.checkNotNullParameter(r5, "ev");
        if (r5.getActionMasked() != 0) goto L6;
        b();
    L6:
        return super.onInterceptTouchEvent(r5);
    }

    @Override // android.widget.AbsListView, android.view.View
    public final void onSizeChanged(int r5, int r10, int r11, int r12) {
        super.onSizeChanged(r5, r10, r11, r12);
        this.f12035l.b();
        b r13 = this.f12028a;
        if (r13 == null) goto L6;
        r13.setSize(r5, r10);
    L6:
        b r14 = this.f12029b;
        if (r14 == null) goto L11;
        r14.setSize(r5, r10);
        return;
    }

    @Override // android.widget.AbsListView, android.view.View
    public final boolean onTouchEvent(MotionEvent r5) {
        Intrinsics.checkNotNullParameter(r5, "ev");
        if (r5.getActionMasked() != 0) goto L6;
        b();
    L6:
        return super.onTouchEvent(r5);
    }

    public void setOnBounceTranslationListener(f r5) {
        this.f12036m.a();
    }

    @JvmOverloads
    public OGridView(Context r5, AttributeSet r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this(r5, r10, 4, 0);
    }

    public /* synthetic */ OGridView(Context r5, AttributeSet r10, int r11, int r12) {
        if ((r11 & 2) == 0) goto L5;
        r10 = null;
    L5:
        this(r5, r10, R.attr.gridViewStyle);
    }

    @JvmOverloads
    public OGridView(Context r10, AttributeSet r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11, r12);
        this.f12035l = new c(new OGridView$overscrollDelegate$1(this), new OGridView$overscrollDelegate$2(this));
        this.f12036m = new d(new OGridView$translationDelegate$1(this), new OGridView$translationDelegate$2(this));
        setOverScrollMode(0);
        WeakHashMap r13 = b.s;
        ym.a.f("Landroid/widget/AbsListView;");
        if (this.f12039p == true) goto L24;
        this.f12039p = true;
        Field r5 = c(AbsListView.class, "mEdgeGlowTop");     // Catch: Throwable -> L9
        if (r5 != null) goto L11;
        r5 = c(AbsListView.class, "mTopGlow");     // Catch: Throwable -> L9
    L11:
        this.f12037n = r5;     // Catch: Throwable -> L9
        Field r14 = c(AbsListView.class, "mEdgeGlowBottom");     // Catch: Throwable -> L9
        if (r14 != null) goto L14;
        r14 = c(AbsListView.class, "mBottomGlow");     // Catch: Throwable -> L9
    L14:
        this.f12038o = r14;     // Catch: Throwable -> L9
        this.f12032i = c(AbsListView.class, "mScroller");     // Catch: Throwable -> L9
        Field r15 = c(AbsListView.class, "mFlingRunnable");     // Catch: Throwable -> L9
        this.f12033j = r15;     // Catch: Throwable -> L9
        if (r15 != null) goto L17;
    L16:
        Field r16 = null;
    L21:
        this.f12034k = r16;     // Catch: Throwable -> L9
        goto L24
    L17:
        Class<?> r17 = r15.getType();     // Catch: Throwable -> L9
        if (r17 == null) goto L16;
        r16 = c(r17, "mScroller");     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        Log.w("OGridView", "Failed to reflect edge effect fields", th);
        this.f12037n = null;
        this.f12038o = null;
        this.f12032i = null;
        this.f12033j = null;
        this.f12034k = null;
    L24:
        c r18 = this.f12035l;
        Field r19 = this.f12037n;
        Field r20 = this.f12038o;
        if (r19 == null) goto L69;
        if (r20 == null) goto L77;
    L31:
        th = move-exception;
        Log.w("OGridView", "Failed to install BounceEdgeEffects, restoring original.", th);
        Field r110 = this.f12037n;
        Field r111 = this.f12038o;
        if (r110 != null) goto L72;
    L48:
        if (r111 == null) goto L62;
        Object r112 = this.f12031h;     // Catch: Throwable -> L53
        if (r112 == null) goto L62;
        r111.set(this, r112);     // Catch: Throwable -> L53
    L53:
        b r113 = this.f12028a;
        if (r113 == null) goto L57;
        r113.finish();
    L57:
        b r114 = this.f12029b;
        if (r114 == null) goto L61;
    L60:
        r114.finish();
    L61:
        this.f12028a = null;
        this.f12029b = null;
        this.f12030c = false;
        return;
    L62:
        b r115 = this.f12028a;
        if (r115 == null) goto L66;
        r115.finish();
    L66:
        r114 = this.f12029b;
        if (r114 != null) goto L60;
    L72:
        Object r21 = this.g;     // Catch: Throwable -> L53
        if (r21 == null) goto L48;
        r110.set(this, r21);     // Catch: Throwable -> L53
        goto L48
    L29:
        if (this.g != null) goto L34;
        this.g = r19.get(this);     // Catch: Throwable -> L31
    L34:
        if (this.f12031h != null) goto L36;
        this.f12031h = r20.get(this);     // Catch: Throwable -> L31
    L36:
        r18.b();     // Catch: Throwable -> L31
        b r22 = new b(getContext(), this, 0, r18.f12113c);     // Catch: Throwable -> L31
        b r23 = new b(getContext(), this, 1, r18.f12113c);     // Catch: Throwable -> L31
        if (getWidth() > 0) goto L39;
    L41:
        r19.set(this, r22);     // Catch: Throwable -> L31
        r20.set(this, r23);     // Catch: Throwable -> L31
        this.f12028a = r22;     // Catch: Throwable -> L31
        this.f12029b = r23;     // Catch: Throwable -> L31
        r18.a();     // Catch: Throwable -> L31
        this.f12036m.a();     // Catch: Throwable -> L31
        this.f12030c = true;     // Catch: Throwable -> L31
        return;
    L39:
        if (getHeight() <= 0) goto L41;
        r22.setSize(getWidth(), getHeight());     // Catch: Throwable -> L31
        r23.setSize(getWidth(), getHeight());     // Catch: Throwable -> L31
        goto L41
    L77:
        return;
    }
}
