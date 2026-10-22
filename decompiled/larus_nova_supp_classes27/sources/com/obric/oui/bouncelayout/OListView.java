package com.obric.oui.bouncelayout;

import android.R;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListView;
import android.widget.OverScroller;
import java.lang.reflect.Field;
import java.util.WeakHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002:\u0002\u0013\u0014B'\b\u0007\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\u0012\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\u0015"}, d2 = {"Lcom/obric/oui/bouncelayout/OListView;", "Landroid/widget/ListView;", "", "Landroid/widget/OverScroller;", "getOverScrollerOrNull", "", "getBounceTranslation", "Lcom/obric/oui/bouncelayout/e;", "listener", "", "setOnBounceTranslationListener", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "b", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
public class OListView extends ListView {
    public static final a t = null;
    public static volatile b u;
    public BounceEdgeEffect a;
    public BounceEdgeEffect b;
    public boolean c;
    public float d;
    public int e;
    public int f;
    public boolean g;
    public Object h;
    public Object i;
    public Field j;
    public Field k;
    public Field l;
    public Field m;
    public final d n;
    public final BounceTranslationDelegate o;
    public final com.obric.oui.bouncelayout.b p;
    public final com.obric.oui.bouncelayout.a q;
    public Field r;
    public Field s;

    public static final class a {
        public static b a() {
            Field r2 = b(AbsListView.class, "mEdgeGlowTop");     // Catch: Throwable -> L19
            if (r2 != null) goto L6;
            r2 = b(AbsListView.class, "mTopGlow");     // Catch: Throwable -> L19
        L6:
            Field r4 = r2;
            Field r3 = b(AbsListView.class, "mEdgeGlowBottom");     // Catch: Throwable -> L19
            if (r3 != null) goto L9;
            r3 = b(AbsListView.class, "mBottomGlow");     // Catch: Throwable -> L19
        L9:
            Field r5 = r3;
            Field r6 = b(AbsListView.class, "mScroller");     // Catch: Throwable -> L19
            Field r7 = b(AbsListView.class, "mFlingRunnable");     // Catch: Throwable -> L19
            if (r7 == null) goto L14;
            Class<?> r8 = r7.getType();     // Catch: Throwable -> L19
            if (r8 == null) goto L14;
            a r9 = OListView.t;     // Catch: Throwable -> L19
            Field r0 = b(r8, "mScroller");     // Catch: Throwable -> L19
        L15:
            Field r10 = r0;
            return new b(r4, r5, r6, r7, r10, b(AbsListView.class, "mTouchMode"));
        L14:
            r0 = null;
        L20:
            return new b(0);
        }

        public a() {
        }

        public static Field b(Class r0, String r1) {
            Field r2 = r0.getDeclaredField(r1);     // Catch: Throwable -> L4
            r2.setAccessible(true);     // Catch: Throwable -> L4
            return r2;
        L5:
            return null;
        }
    }

    public static final class b {
        public final Field a;
        public final Field b;
        public final Field c;
        public final Field d;
        public final Field e;
        public final Field f;

        public b() {
            this(0);
        }

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f, r6.f) == true) goto L26;
            return false;
        L26:
            return true;
        }

        public final int hashCode() {
            Field r0 = this.a;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            Field r4 = this.b;
            if (r4 != null) goto L9;
            int r5 = 0;
        L10:
            int r6 = (r3 + r5) * 31;
            Field r7 = this.c;
            if (r7 != null) goto L13;
            int r8 = 0;
        L14:
            int r9 = (r6 + r8) * 31;
            Field r10 = this.d;
            if (r10 != null) goto L17;
            int r11 = 0;
        L18:
            int r12 = (r9 + r11) * 31;
            Field r13 = this.e;
            if (r13 != null) goto L21;
            int r14 = 0;
        L22:
            int r15 = (r12 + r14) * 31;
            Field r16 = this.f;
            if (r16 == null) goto L27;
            r1 = r16.hashCode();
        L27:
            return r15 + r1;
        L21:
            r14 = r13.hashCode();
            goto L22
        L17:
            r11 = r10.hashCode();
            goto L18
        L13:
            r8 = r7.hashCode();
            goto L14
        L9:
            r5 = r4.hashCode();
            goto L10
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public final String toString() {
            return "ReflectionFields(edgeFieldTop=" + this.a + ", edgeFieldBottom=" + this.b + ", scrollerField=" + this.c + ", flingRunnableField=" + this.d + ", flingRunnableScrollerField=" + this.e + ", touchModeField=" + this.f + ')';
        }

        public /* synthetic */ b(int r8) {
            this(null, null, null, null, null, null);
        }

        public b(Field r1, Field r2, Field r3, Field r4, Field r5, Field r6) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
        }
    }

    static {
        t = new a();
    }

    public OListView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public OListView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    private final OverScroller getOverScrollerOrNull() {
        Field r1 = this.j;     // Catch: Throwable -> L32
        if (r1 != null) goto L6;
        Object r2 = null;
    L8:
        if ((r2 instanceof OverScroller) == false) goto L11;
        OverScroller r3 = (OverScroller) r2;     // Catch: Throwable -> L32
    L12:
        if (r3 == null) goto L34;
        return r3;
    L11:
        r3 = null;
        goto L12
    L6:
        r2 = r1.get(this);     // Catch: Throwable -> L32
    L34:
        Field r4 = this.k;     // Catch: Throwable -> L19
        if (r4 == null) goto L20;
        Object r5 = r4.get(this);     // Catch: Throwable -> L19
    L21:
        if (r5 != null) goto L36;
        return null;
    L36:
        Field r6 = this.l;     // Catch: Throwable -> L33
        if (r6 != null) goto L26;
        Object r7 = null;
    L28:
        if ((r7 instanceof OverScroller) == false) goto L40;
        return (OverScroller) r7;
    L40:
        return null;
    L26:
        r7 = r6.get(r5);     // Catch: Throwable -> L33
    L41:
        return null;
    L20:
        r5 = null;
        goto L21
    }

    public final void c() {
        if (this.g == true) goto L5;
        return;
    L5:
        boolean r0 = b(this.a);
        boolean r1 = b(this.b);
        if (r0 == false) goto L9;
        if (r1 == true) goto L9;
    L18:
        byte r2 = 0;
    L27:
        if (r2 == 0) goto L34;
        if (r2 != 1) goto L38;
        BounceEdgeEffect r3 = this.b;
        if (r3 == null) goto L38;
        r3.onRelease();
    L38:
        this.g = false;
        invalidate();
        return;
    L34:
        BounceEdgeEffect r4 = this.a;
        if (r4 == null) goto L38;
        r4.onRelease();
    L9:
        if (r1 == false) goto L12;
        if (r0 == true) goto L12;
    L25:
        r2 = 1;
    L12:
        BounceEdgeEffect r5 = this.a;
        if (r5 != null) goto L15;
        float r6 = 0.0f;
    L17:
        if (r6 > 0.0f) goto L18;
        BounceEdgeEffect r7 = this.b;
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

    public final boolean d() {
        if (this.c == true) goto L5;
        return false;
    L5:
        OverScroller r0 = getOverScrollerOrNull();
        BounceEdgeEffect r2 = this.a;
        if (r2 != null) goto L8;
        float r4 = 0.0f;
    L10:
        if (r4 != 0.0f) goto L12;
        boolean r5 = true;
    L13:
        if (r5 == false) goto L25;
        BounceEdgeEffect r6 = this.b;
        if (r6 != null) goto L17;
        float r7 = 0.0f;
    L19:
        if (r7 != 0.0f) goto L21;
        boolean r8 = true;
    L22:
        if (r8 == false) goto L25;
        boolean r9 = false;
    L26:
        if (r2 != null) goto L29;
    L31:
        boolean r3 = false;
    L32:
        if (r3 == true) goto L43;
        BounceEdgeEffect r10 = this.b;
        if (r10 != null) goto L37;
    L39:
        boolean r11 = false;
    L40:
        if (r11 == true) goto L43;
        boolean r12 = false;
    L44:
        if (r9 == true) goto L49;
        if (r12 == true) goto L49;
        this.d = 0.0f;
        this.e = 0;
        this.f = computeVerticalScrollOffset();
        return false;
    L49:
        if (r0 != null) goto L52;
    L54:
        boolean r13 = false;
    L55:
        if (r13 == false) goto L59;
        if (r0 == null) goto L59;
        r0.abortAnimation();
    L59:
        Runnable r1 = null;
        Field r14 = this.k;     // Catch: Throwable -> L92
        if (r14 != null) goto L63;
        Object r15 = null;
    L65:
        if ((r15 instanceof Runnable) == false) goto L68;
        Runnable r16 = (Runnable) r15;     // Catch: Throwable -> L92
    L69:
        if (r16 == null) goto L95;
    L79:
        r1 = r16;
    L80:
        if (r1 == null) goto L82;
        removeCallbacks(r1);
    L82:
        BounceEdgeEffect r17 = this.a;
        if (r17 == null) goto L86;
        r17.q();
    L86:
        BounceEdgeEffect r18 = this.b;
        if (r18 == null) goto L90;
        r18.q();
    L90:
        invalidate();
        this.d = 0.0f;
        this.e = 0;
        this.f = computeVerticalScrollOffset();
        return true;
    L95:
        Field r20 = this.k;     // Catch: Throwable -> L78
        if (r20 != null) goto L73;
        Object r21 = null;
    L75:
        if ((r21 instanceof Runnable) == false) goto L80;
        r16 = (Runnable) r21;     // Catch: Throwable -> L78
    L73:
        r21 = r20.get(this);     // Catch: Throwable -> L78
        goto L75
    L63:
        r15 = r14.get(this);     // Catch: Throwable -> L92
    L68:
        r16 = null;
        goto L69
    L52:
        if (r0.isFinished() == true) goto L54;
        r13 = true;
        goto L55
    L37:
        if (r10.isFinished() == true) goto L39;
        r11 = true;
    L43:
        r12 = true;
        goto L44
    L29:
        if (r2.isFinished() == true) goto L31;
        r3 = true;
        goto L32
    L21:
        r8 = false;
        goto L22
    L17:
        r7 = r6.f;
    L25:
        r9 = true;
        goto L26
    L12:
        r5 = false;
        goto L13
    L8:
        r4 = r2.f;
        goto L10
    }

    public float getBounceTranslation() {
        BounceEdgeEffect r0 = this.a;
        float r1 = 0.0f;
        if (r0 != null) goto L5;
        float r2 = 0.0f;
    L6:
        BounceEdgeEffect r3 = this.b;
        if (r3 == null) goto L11;
        r1 = r3.f;
    L11:
        return r2 + r1;
    L5:
        r2 = r0.f;
        goto L6
    }

    @Override // android.view.View
    public final void computeScroll() {
        super.computeScroll();
        if (this.c == true) goto L6;
        return;
    L6:
        if (computeVerticalScrollRange() > computeVerticalScrollExtent()) goto L8;
        return;
    L8:
        int r0 = computeVerticalScrollOffset();
        OverScroller r1 = getOverScrollerOrNull();
        boolean r2 = true;
        if (r1 != null) goto L11;
    L66:
        float r3 = this.d;
        if (r3 <= 0.0f) goto L81;
        boolean r4 = !canScrollList(-1);
        boolean r5 = true ^ canScrollList(1);
        int r6 = this.e;
        if (r6 >= 0) goto L75;
        if (r4 == false) goto L75;
        BounceEdgeEffect r7 = this.a;
        if (r7 == null) goto L81;
        r7.onAbsorb((int) r3);
    L75:
        if (r6 <= 0) goto L81;
        if (r5 == false) goto L81;
        BounceEdgeEffect r8 = this.b;
        if (r8 == null) goto L81;
        r8.onAbsorb(-((int) r3));
    L81:
        this.d = 0.0f;
        this.e = 0;
        this.f = r0;
        return;
    L11:
        if (r1.isFinished() == true) goto L66;
        float r9 = r1.getCurrVelocity();
        this.d = r9;
        int r10 = r0 - this.f;
        if (r10 <= 0) goto L15;
        this.e = 1;
    L17:
        int r11 = c.a;
        this.f = r0;
        if (r9 <= 0.0f) goto L86;
        boolean r12 = !canScrollList(-1);
        boolean r13 = !canScrollList(1);
        if (this.e >= 0) goto L36;
        if (r12 == false) goto L36;
        BounceEdgeEffect r14 = this.a;
        if (r14 != null) goto L27;
    L29:
        boolean r15 = false;
    L30:
        if (r15 == false) goto L36;
        BounceEdgeEffect r16 = this.a;
        if (r16 == null) goto L51;
        r16.onAbsorb((int) r9);
    L51:
        if (r2 == false) goto L85;
        r1.abortAnimation();
        Runnable r17 = null;
        Field r18 = this.k;     // Catch: Throwable -> L61
        if (r18 != null) goto L56;
        Object r20 = null;
    L58:
        if ((r20 instanceof Runnable) == false) goto L62;
        r17 = (Runnable) r20;     // Catch: Throwable -> L61
        goto L62
    L56:
        r20 = r18.get(this);     // Catch: Throwable -> L61
    L62:
        if (r17 == null) goto L64;
        removeCallbacks(r17);
    L64:
        this.d = 0.0f;
        this.e = 0;
        invalidate();
        return;
    L85:
        return;
    L27:
        if (r14.isFinished() != true) goto L29;
        r15 = true;
    L36:
        if (this.e <= 0) goto L50;
        if (r13 == false) goto L50;
        BounceEdgeEffect r21 = this.b;
        if (r21 != null) goto L42;
    L44:
        boolean r22 = false;
    L45:
        if (r22 == false) goto L50;
        BounceEdgeEffect r23 = this.b;
        if (r23 == null) goto L51;
        r23.onAbsorb(-((int) r9));
        goto L51
    L42:
        if (r21.isFinished() != true) goto L44;
        r22 = true;
    L50:
        r2 = false;
        goto L51
    L86:
        return;
    L15:
        if (r10 >= 0) goto L17;
        this.e = -1;
        goto L17
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        BounceEdgeEffect r0 = this.a;
        if (r0 == null) goto L6;
        r0.c();
    L6:
        BounceEdgeEffect r1 = this.b;
        if (r1 == null) goto L11;
        r1.c();
        return;
    }

    public static boolean b(BounceEdgeEffect r4) {
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

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        BounceEdgeEffect r0 = this.a;
        if (r0 != null) goto L7;
        float r1 = 0.0f;
    L8:
        BounceEdgeEffect r2 = this.b;
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
        this.p.c(r5);
        com.obric.oui.bouncelayout.b r0 = this.p;
        Boolean r1 = r0.b(r5, 0.0f, -r0.e, new OListView$dispatchTouchEvent$handled$1(this, r5));
        if (r1 != null) goto L5;
        boolean r2 = super.dispatchTouchEvent(r5);
    L7:
        if (r5.getActionMasked() != 1) goto L9;
    L10:
        c();
    L11:
        return r2;
    L9:
        if (r5.getActionMasked() != 3) goto L11;
    L5:
        r2 = r1.booleanValue();
        goto L7
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r5) {
        Intrinsics.checkNotNullParameter(r5, "ev");
        int r0 = r5.getActionMasked();
        boolean r2 = true;
        if (r0 == 0) goto L35;
        if (r0 != 1) goto L6;
    L27:
        com.obric.oui.bouncelayout.a r1 = this.q;
        r1.o = false;
        r1.p = -1;
        r1.t = -1;
        VelocityTracker r3 = r1.s;
        if (r3 == null) goto L31;
        r3.recycle();
    L31:
        r1.s = null;
        c();
    L33:
        return super.onInterceptTouchEvent(r5);
    L6:
        if (r0 == 2) goto L21;
        if (r0 == 3) goto L27;
        if (r0 == 5) goto L18;
        if (r0 != 6) goto L33;
        if (this.q.e(r5) == false) goto L33;
        return true;
    L18:
        if (this.q.d(r5) == false) goto L33;
        return true;
    L21:
        if (this.p.d(r5) == false) goto L23;
        return false;
    L23:
        com.obric.oui.bouncelayout.a r4 = this.q;
        r4.getClass();
        Intrinsics.checkNotNullParameter(r5, "event");
        if (r4.n(r5) == false) goto L33;
        this.g = false;
        return true;
    L35:
        if (d() == false) goto L37;
    L40:
        this.g = r2;
        this.q.c(r5);
        boolean r6 = super.onInterceptTouchEvent(r5);
        if (this.p.d(r5) == false) goto L43;
        return false;
    L43:
        return r6;
    L37:
        if (this.g == true) goto L40;
        r2 = false;
        goto L40
    }

    @Override // android.widget.AbsListView, android.view.View
    public final boolean onTouchEvent(MotionEvent r5) {
        Intrinsics.checkNotNullParameter(r5, "ev");
        int r0 = r5.getActionMasked();
        boolean r1 = false;
        if (r0 == 0) goto L30;
        if (r0 == 1) goto L25;
        if (r0 == 2) goto L21;
        if (r0 == 3) goto L25;
        if (r0 == 5) goto L18;
        if (r0 != 6) goto L38;
        if (this.q.e(r5) == false) goto L38;
        return true;
    L38:
        return super.onTouchEvent(r5);
    L18:
        if (this.q.d(r5) == false) goto L38;
        return true;
    L21:
        if (this.q.h(r5) == false) goto L38;
        this.g = false;
        return true;
    L25:
        if (this.q.g(r5) == false) goto L28;
        this.g = false;
        return true;
    L28:
        c();
        goto L38
    L30:
        if (d() == false) goto L32;
    L33:
        r1 = true;
    L34:
        this.g = r1;
        if (this.q.f(r5) == false) goto L38;
        return true;
    L32:
        if (this.g == false) goto L34;
        goto L33
    }

    public void setOnBounceTranslationListener(e r2) {
        BounceTranslationDelegate r0 = this.o;
        r0.c = r2;
        r0.a();
    }

    public static final /* synthetic */ boolean a(OListView r0, MotionEvent r1) {
        return super.dispatchTouchEvent(r1);
    }

    public OListView(Context r11, AttributeSet r12, int r13) {
        Intrinsics.checkNotNullParameter(r11, "context");
        super(r11, r12, r13);
        d r14 = new d(new OListView$overscrollDelegate$1(this), new OListView$overscrollDelegate$2(this));
        this.n = r14;
        BounceTranslationDelegate r15 = new BounceTranslationDelegate(new OListView$translationDelegate$1(this), new OListView$translationDelegate$2(this));
        this.o = r15;
        this.p = new com.obric.oui.bouncelayout.b(this, new OListView$clickDuringOverScrollDelegate$1(this), new OListView$clickDuringOverScrollDelegate$2(this));
        this.q = new com.obric.oui.bouncelayout.a(this, new OListView$bounceGestureDelegate$1(this), new OListView$bounceGestureDelegate$2(this), new OListView$bounceGestureDelegate$3(this), new OListView$bounceGestureDelegate$4(this), new OListView$bounceGestureDelegate$5(this), new OListView$bounceGestureDelegate$6(this));
        setOverScrollMode(0);
        WeakHashMap<View, BounceEdgeEffect.a.C0121a> r0 = BounceEdgeEffect.u;
        BounceEdgeEffect.a.a("Landroid/widget/AbsListView;");
        a r1 = t;
        b r2 = u;
        if (r2 != null) goto L13;
        monitor-enter(r1);
        r2 = u;     // Catch: Throwable -> L10
        if (r2 != null) goto L8;
        r2 = a.a();     // Catch: Throwable -> L10
        u = r2;     // Catch: Throwable -> L10
    L8:
        monitor-exit(r1);
    L10:
        th = move-exception;
        throw th;
    L13:
        Field r3 = r2.a;
        this.r = r3;
        Field r4 = r2.b;
        this.s = r4;
        this.j = r2.c;
        this.k = r2.d;
        this.l = r2.e;
        this.m = r2.f;
        if (r3 == null) goto L63;
        if (r4 == null) goto L64;
    L30:
        Field r16 = this.r;
        Field r17 = this.s;
        if (r16 != null) goto L61;
    L35:
        if (r17 == null) goto L47;
        Object r18 = this.i;     // Catch: Throwable -> L40
        if (r18 == null) goto L47;
        r17.set(this, r18);     // Catch: Throwable -> L40
    L40:
        BounceEdgeEffect r110 = this.a;
        if (r110 == null) goto L44;
        r110.c();
    L44:
        BounceEdgeEffect r111 = this.b;
        if (r111 == null) goto L55;
    L54:
        r111.c();
    L55:
        this.a = null;
        this.b = null;
        this.c = false;
        return;
    L47:
        BounceEdgeEffect r112 = this.a;
        if (r112 == null) goto L51;
        r112.c();
    L51:
        r111 = this.b;
        if (r111 != null) goto L54;
    L61:
        Object r5 = this.h;     // Catch: Throwable -> L40
        if (r5 == null) goto L35;
        r16.set(this, r5);     // Catch: Throwable -> L40
        goto L35
    L18:
        if (this.h != null) goto L21;
        this.h = r3.get(this);     // Catch: Throwable -> L30
    L21:
        if (this.i != null) goto L23;
        this.i = r4.get(this);     // Catch: Throwable -> L30
    L23:
        r14.b();     // Catch: Throwable -> L30
        BounceEdgeEffect r6 = new BounceEdgeEffect(getContext(), this, 0, r14.c);     // Catch: Throwable -> L30
        BounceEdgeEffect r7 = new BounceEdgeEffect(getContext(), this, 1, r14.c);     // Catch: Throwable -> L30
        if (getWidth() > 0) goto L26;
    L28:
        r3.set(this, r6);     // Catch: Throwable -> L30
        r4.set(this, r7);     // Catch: Throwable -> L30
        this.a = r6;     // Catch: Throwable -> L30
        this.b = r7;     // Catch: Throwable -> L30
        r14.a();     // Catch: Throwable -> L30
        r15.a();     // Catch: Throwable -> L30
        this.c = true;     // Catch: Throwable -> L30
        return;
    L26:
        if (getHeight() <= 0) goto L28;
        r6.setSize(getWidth(), getHeight());     // Catch: Throwable -> L30
        r7.setSize(getWidth(), getHeight());     // Catch: Throwable -> L30
        goto L28
    L64:
        return;
    }

    public /* synthetic */ OListView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r3 & 4) == 0) goto L8;
        int r5 = R.attr.listViewStyle;
    L9:
        this(r1, r2, r5);
        return;
    L8:
        r5 = 0;
        goto L9
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.View
    public final void onSizeChanged(int r1, int r2, int r3, int r4) {
        super.onSizeChanged(r1, r2, r3, r4);
        this.n.b();
        BounceEdgeEffect r5 = this.a;
        if (r5 == null) goto L6;
        r5.setSize(r1, r2);
    L6:
        BounceEdgeEffect r6 = this.b;
        if (r6 == null) goto L11;
        r6.setSize(r1, r2);
        return;
    }
}
