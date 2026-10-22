package com.obric.oui.bouncelayout;

import android.R;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.ListView;
import android.widget.OverScroller;
import java.lang.reflect.Field;
import java.util.WeakHashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002:\u0002\u0016\u0017B'\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0011\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0002¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, d2 = {"Lcom/obric/oui/bouncelayout/OListView;", "Landroid/widget/ListView;", "", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "", "getBounceTranslation", "()F", "Lcom/obric/oui/bouncelayout/f;", "listener", "", "setOnBounceTranslationListener", "(Lcom/obric/oui/bouncelayout/f;)V", "Landroid/widget/OverScroller;", "getOverScrollerOrNull", "()Landroid/widget/OverScroller;", "com/lynx/tasm/utils/c", "com/obric/oui/bouncelayout/e", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class OListView extends ListView {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final com.lynx.tasm.utils.c f12049v = null;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static volatile e f12050w;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f12051a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f12052b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f12053c;
    public float d;
    public int e;
    public int f;
    public final Object g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Object f12054h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Field f12055i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Field f12056j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Field f12057k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final c f12058l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final d f12059m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Field f12060n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Field f12061o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f12062p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final int f12063q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f12064r;
    public boolean s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public float f12065t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public float f12066u;

    static {
        f12049v = new com.lynx.tasm.utils.c(9);
    }

    @JvmOverloads
    public OListView(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        int r10 = 6;
        this(r5, null, r10, 0);
    }

    public static boolean a(b r5) {
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

    private final OverScroller getOverScrollerOrNull() {
        Field r5 = this.f12055i;     // Catch: Throwable -> L31
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
        Field r12 = this.f12056j;     // Catch: Throwable -> L33
        if (r12 == null) goto L19;
        Object r13 = r12.get(this);     // Catch: Throwable -> L33
    L20:
        if (r13 != null) goto L36;
        return null;
    L36:
        Field r14 = this.f12057k;     // Catch: Throwable -> L32
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

    public final void b(Runnable r5) {
        if (r5 != null) goto L12;
        r5 = null;
        Field r10 = this.f12056j;     // Catch: Throwable -> L15
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

    public final void c() {
        if (this.f12053c == true) goto L5;
        return;
    L5:
        OverScroller r5 = getOverScrollerOrNull();
        b r10 = this.f12051a;
        if (r10 != null) goto L8;
        float r11 = 0.0f;
    L9:
        boolean r12 = true;
        if (r11 != 0.0f) goto L18;
        b r13 = this.f12052b;
        if (r13 != null) goto L14;
        float r14 = 0.0f;
    L16:
        if (r14 != 0.0f) goto L18;
        boolean r15 = false;
    L19:
        if (r10 != null) goto L22;
    L24:
        b r16 = this.f12052b;
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
        Field r18 = this.f12056j;     // Catch: Throwable -> L58
        if (r18 != null) goto L42;
        Object r19 = null;
    L44:
        if ((r19 instanceof Runnable) == false) goto L47;
        r17 = (Runnable) r19;     // Catch: Throwable -> L58
        goto L47
    L42:
        r19 = r18.get(this);     // Catch: Throwable -> L58
    L47:
        b(r17);
        b r20 = this.f12051a;
        if (r20 == null) goto L51;
        r20.n();
    L51:
        b r21 = this.f12052b;
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
        if (this.f12053c == true) goto L5;
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
        b r16 = this.f12051a;
        if (r16 == null) goto L61;
        r16.onAbsorb((int) r12);
    L55:
        if (r15 <= 0) goto L61;
        if (r14 == true) goto L61;
        b r17 = this.f12052b;
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
        b r22 = this.f12051a;
        if (r22 == null) goto L33;
        if (r22.isFinished() != true) goto L33;
        b r23 = this.f12051a;
        if (r23 == null) goto L44;
        r23.onAbsorb((int) r18);
    L44:
        r11.abortAnimation();
        b(null);
        this.d = 0.0f;
        this.e = 0;
        invalidate();
        return;
    L33:
        if (this.e <= 0) goto L63;
        if (r21 == true) goto L64;
        b r24 = this.f12052b;
        if (r24 != null) goto L39;
        return;
    L39:
        if (r24.isFinished() != true) goto L65;
        b r25 = this.f12052b;
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

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r5) {
        if (r5 != null) goto L5;
        super.dispatchDraw(r5);
        return;
    L5:
        b r10 = this.f12051a;
        if (r10 != null) goto L8;
        float r11 = 0.0f;
    L9:
        b r12 = this.f12052b;
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
        this.f12062p = getBounceTranslation();
    L5:
        float r5 = this.f12062p;
        if (r5 == 0.0f) goto L8;
        r10.offsetLocation(0.0f, -r5);
        boolean r11 = super.dispatchTouchEvent(r10);
        r10.offsetLocation(0.0f, r5);
        if (r10.getActionMasked() != 1) goto L17;
    L18:
        this.f12062p = 0.0f;
    L19:
        return r11;
    L17:
        if (r10.getActionMasked() != 3) goto L19;
    L8:
        if (r10.getActionMasked() != 1) goto L10;
    L11:
        this.f12062p = 0.0f;
    L13:
        return super.dispatchTouchEvent(r10);
    L10:
        if (r10.getActionMasked() != 3) goto L13;
        goto L11
    }

    public float getBounceTranslation() {
        b r5 = this.f12051a;
        float r10 = 0.0f;
        if (r5 != null) goto L5;
        float r11 = 0.0f;
    L6:
        b r12 = this.f12052b;
        if (r12 == null) goto L11;
        r10 = r12.f;
    L11:
        return r11 + r10;
    L5:
        r11 = r5.f;
        goto L6
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        b r5 = this.f12051a;
        if (r5 == null) goto L6;
        r5.finish();
    L6:
        b r10 = this.f12052b;
        if (r10 == null) goto L11;
        r10.finish();
        return;
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r5) {
        Intrinsics.checkNotNullParameter(r5, "ev");
        if (r5.getActionMasked() != 0) goto L6;
        c();
    L6:
        return super.onInterceptTouchEvent(r5);
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.View
    public final void onSizeChanged(int r5, int r10, int r11, int r12) {
        super.onSizeChanged(r5, r10, r11, r12);
        this.f12058l.b();
        b r13 = this.f12051a;
        if (r13 == null) goto L6;
        r13.setSize(r5, r10);
    L6:
        b r14 = this.f12052b;
        if (r14 == null) goto L11;
        r14.setSize(r5, r10);
        return;
    }

    @Override // android.widget.AbsListView, android.view.View
    public final boolean onTouchEvent(MotionEvent r10) {
        Intrinsics.checkNotNullParameter(r10, "ev");
        int r5 = r10.getActionMasked();
        if (r5 == 0) goto L62;
        if (r5 == 1) goto L51;
        if (r5 == 2) goto L11;
        if (r5 == 3) goto L51;
    L72:
        return super.onTouchEvent(r10);
    L11:
        if (this.f12064r == false) goto L72;
        float r11 = r10.getY();
        float r12 = r11 - this.f12065t;
        float r13 = r11 - this.f12066u;
        if (this.s == true) goto L18;
        if (Math.abs(r12) <= this.f12063q) goto L18;
        this.s = true;
    L18:
        if (this.s == true) goto L20;
    L48:
        this.f12066u = r11;
        return true;
    L20:
        if (r13 == 0.0f) goto L48;
        if (getHeight() <= 0) goto L48;
        float r14 = r13 / getHeight();
        boolean r15 = a(this.f12051a);
        boolean r16 = a(this.f12052b);
        if (r15 == false) goto L31;
        b r17 = this.f12051a;
        if (r17 == null) goto L47;
        r17.onPull(r14, 0.5f);
    L47:
        invalidate();
        goto L48
    L31:
        if (r16 == false) goto L37;
        b r18 = this.f12052b;
        if (r18 == null) goto L47;
        r18.onPull(-r14, 0.5f);
        goto L47
    L37:
        if (r13 <= 0.0f) goto L42;
        b r19 = this.f12051a;
        if (r19 == null) goto L47;
        r19.onPull(r14, 0.5f);
        goto L47
    L42:
        if (r13 >= 0.0f) goto L47;
        b r20 = this.f12052b;
        if (r20 == null) goto L47;
        r20.onPull(-r14, 0.5f);
    L51:
        if (this.f12064r == false) goto L72;
        this.f12064r = false;
        this.s = false;
        b r21 = this.f12051a;
        if (r21 == null) goto L56;
        r21.onRelease();
    L56:
        b r22 = this.f12052b;
        if (r22 == null) goto L60;
        r22.onRelease();
    L60:
        invalidate();
        return true;
    L62:
        c();
        if (this.f12053c == false) goto L72;
        if (getHeight() <= 0) goto L72;
        if (pointToPosition((int) r10.getX(), (int) r10.getY()) != (-1)) goto L72;
        this.f12064r = true;
        this.s = false;
        this.f12065t = r10.getY();
        this.f12066u = r10.getY();
        return true;
    }

    public void setOnBounceTranslationListener(f r5) {
        this.f12059m.a();
    }

    @JvmOverloads
    public OListView(Context r5, AttributeSet r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this(r5, r10, 4, 0);
    }

    public /* synthetic */ OListView(Context r5, AttributeSet r10, int r11, int r12) {
        if ((r11 & 2) == 0) goto L5;
        r10 = null;
    L5:
        this(r5, r10, R.attr.listViewStyle);
    }

    @JvmOverloads
    public OListView(Context r10, AttributeSet r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11, r12);
        c r13 = new c(new OListView$overscrollDelegate$1(this), new OListView$overscrollDelegate$2(this));
        this.f12058l = r13;
        d r14 = new d(new OListView$translationDelegate$1(this), new OListView$translationDelegate$2(this));
        this.f12059m = r14;
        setOverScrollMode(0);
        WeakHashMap r5 = b.s;
        ym.a.f("Landroid/widget/AbsListView;");
        com.lynx.tasm.utils.c r15 = f12049v;
        e r16 = f12050w;
        if (r16 != null) goto L15;
        monitor-enter(r15);
        r16 = f12050w;     // Catch: Throwable -> L9
        if (r16 != null) goto L11;
        r16 = com.lynx.tasm.utils.c.f();     // Catch: Throwable -> L9
        f12050w = r16;     // Catch: Throwable -> L9
    L11:
        monitor-exit(r15);
    L9:
        th = move-exception;
        throw th;
    L15:
        Field r17 = r16.f12116a;
        this.f12060n = r17;
        Field r18 = r16.f12117b;
        this.f12061o = r18;
        this.f12055i = r16.f12118c;
        this.f12056j = r16.d;
        this.f12057k = r16.e;
        if (r17 == null) goto L60;
        if (r18 == null) goto L60;
    L22:
        th = move-exception;
        Log.w("OListView", "Failed to install BounceEdgeEffects, restoring original.", th);
        Field r19 = this.f12060n;
        Field r110 = this.f12061o;
        if (r19 != null) goto L66;
    L39:
        if (r110 == null) goto L53;
        Object r111 = this.f12054h;     // Catch: Throwable -> L44
        if (r111 == null) goto L53;
        r110.set(this, r111);     // Catch: Throwable -> L44
    L44:
        b r112 = this.f12051a;
        if (r112 == null) goto L48;
        r112.finish();
    L48:
        b r113 = this.f12052b;
        if (r113 == null) goto L52;
    L51:
        r113.finish();
    L52:
        this.f12051a = null;
        this.f12052b = null;
        this.f12053c = false;
    L53:
        b r114 = this.f12051a;
        if (r114 == null) goto L57;
        r114.finish();
    L57:
        r113 = this.f12052b;
        if (r113 != null) goto L51;
    L66:
        Object r20 = this.g;     // Catch: Throwable -> L44
        if (r20 == null) goto L39;
        r19.set(this, r20);     // Catch: Throwable -> L44
        goto L39
    L20:
        if (this.g != null) goto L25;
        this.g = r17.get(this);     // Catch: Throwable -> L22
    L25:
        if (this.f12054h != null) goto L27;
        this.f12054h = r18.get(this);     // Catch: Throwable -> L22
    L27:
        r13.b();     // Catch: Throwable -> L22
        b r21 = new b(getContext(), this, 0, r13.f12113c);     // Catch: Throwable -> L22
        b r22 = new b(getContext(), this, 1, r13.f12113c);     // Catch: Throwable -> L22
        if (getWidth() > 0) goto L30;
    L32:
        r17.set(this, r21);     // Catch: Throwable -> L22
        r18.set(this, r22);     // Catch: Throwable -> L22
        this.f12051a = r21;     // Catch: Throwable -> L22
        this.f12052b = r22;     // Catch: Throwable -> L22
        r13.a();     // Catch: Throwable -> L22
        r14.a();     // Catch: Throwable -> L22
        this.f12053c = true;     // Catch: Throwable -> L22
        goto L60
    L30:
        if (getHeight() <= 0) goto L32;
        r21.setSize(getWidth(), getHeight());     // Catch: Throwable -> L22
        r22.setSize(getWidth(), getHeight());     // Catch: Throwable -> L22
    L60:
        this.f12063q = ViewConfiguration.get(r10).getScaledTouchSlop();
    }
}
