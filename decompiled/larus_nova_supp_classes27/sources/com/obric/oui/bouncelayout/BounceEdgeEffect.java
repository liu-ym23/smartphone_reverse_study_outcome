package com.obric.oui.bouncelayout;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.View;
import android.view.ViewParent;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;
import android.widget.EdgeEffect;
import android.widget.HorizontalScrollView;
import androidx.core.widget.NestedScrollView;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.WeakHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.annotation.AnnotationRetention;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import org.lsposed.hiddenapibypass.HiddenApiBypass;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class BounceEdgeEffect extends EdgeEffect {
    public static final WeakHashMap<View, a.C0121a> u = null;
    public final View a;
    public final int b;
    public float c;
    public int d;
    public boolean e;
    public float f;
    public Function1<? super Float, Unit> g;
    public float h;
    public float i;
    public boolean j;
    public float k;
    public boolean l;
    public com.obric.oui.orecyclerview.base.d m;
    public long n;
    public final DisplayMetrics o;
    public float p;
    public long q;
    public float r;
    public long s;
    public long t;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/obric/oui/bouncelayout/BounceEdgeEffect$Orientation;", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface Orientation {
    }

    public static final class a {

        /* JADX INFO: renamed from: com.obric.oui.bouncelayout.BounceEdgeEffect$a$a, reason: collision with other inner class name */
        public static final class C0121a {
            public int a;
            public int b;
            public long c;
            public int d;
            public long e;
            public int f;
            public long g;
            public int h;
            public long i;
            public int j;

            public C0121a() {
                this.a = -1;
                this.b = -1;
                this.c = -1;
                this.d = -1;
                this.e = -1;
                this.f = -1;
                this.g = -1;
                this.i = -1;
            }
        }

        public static void a(String r2) {
            Intrinsics.checkNotNullParameter(r2, "signature");
            HiddenApiBypass.addHiddenApiExemptions(new String[]{r2});     // Catch: Throwable -> L5
            return;
        L5:
            Intrinsics.stringPlus("Failed to bypass hidden API restrictions for ", r2);
        }
    }

    public static boolean h(int r1) {
        if (r1 == 0) goto L8;
        if (r1 == 1) goto L9;
        return false;
    L9:
        return true;
    L8:
        return true;
    }

    static {
        u = new WeakHashMap();
    }

    public final boolean g() {
        int r0 = this.b;
        if (r0 == 0) goto L12;
        if (r0 == 1) goto L12;
        if (this.a.canScrollHorizontally(-1) == false) goto L9;
        return false;
    L9:
        if (this.a.canScrollHorizontally(1) == true) goto L18;
    L15:
        return true;
    L18:
        return false;
    L12:
        if (this.a.canScrollVertically(-1) == false) goto L14;
        return false;
    L14:
        if (this.a.canScrollVertically(1) == false) goto L15;
        return false;
    }

    @Override // android.widget.EdgeEffect
    public final float getDistance() {
        if (this.d > 0) goto L6;
        return 0.0f;
    L6:
        r();
        return this.h / this.d;
    }

    @Override // android.widget.EdgeEffect
    public final boolean isFinished() {
        if (this.n == (-1)) goto L5;
        return false;
    L5:
        if (this.f != 0.0f) goto L7;
        boolean r0 = true;
    L8:
        if (r0 == false) goto L12;
        return true;
    L12:
        return false;
    L7:
        r0 = false;
        goto L8
    }

    public final void l() {
        int r0 = c.a;
        this.n = -1;
        this.h = 0.0f;
        n(0.0f, false);
        this.i = 1.0f;
        this.j = false;
        this.l = true;
        m();
        this.a.invalidate();
    }

    public final void m() {
        this.p = this.f;
        this.q = -1;
        this.r = 0.0f;
        this.s = -1;
    }

    @Override // android.widget.EdgeEffect
    public final void onRelease() {
        this.t = -1;
        long r2 = AnimationUtils.currentAnimationTimeMillis();
        a.C0121a r4 = s();
        int r5 = d(r4);
        if (r5 != (-1)) goto L5;
    L8:
        boolean r6 = false;
        if (h(this.b) == false) goto L16;
        if (r4.c == r2) goto L13;
    L20:
        boolean r7 = false;
    L21:
        if (r7 == false) goto L24;
        l();
        return;
    L24:
        float r8 = this.f;
        float r9 = 0.0f;
        if (r8 != 0.0f) goto L27;
        r6 = true;
    L27:
        if (r6 == false) goto L30;
        this.h = 0.0f;
        this.n = -1;
        this.l = true;
        m();
        a();
        return;
    L30:
        float r10 = r8 / this.o.density;
        long r11 = AnimationUtils.currentAnimationTimeMillis();
        long r12 = this.s;
        if (r12 != (-1)) goto L33;
    L35:
        float r13 = r9 / this.o.density;
        int r0 = c.a;
        if (h(this.b) == false) goto L38;
        r4.c = r2;
        r4.d = this.b;
    L39:
        i();
        this.n = r2;
        if (this.m != null) goto L42;
        this.m = new com.obric.oui.orecyclerview.base.d();
    L42:
        com.obric.oui.orecyclerview.base.d r1 = this.m;
        if (r1 == null) goto L46;
        r1.a(r13, r10);
    L46:
        m();
        this.a.invalidate();
        return;
    L38:
        r4.e = r2;
        r4.f = this.b;
        goto L39
    L33:
        if ((r11 - r12) > 120) goto L35;
        r9 = this.r;
        goto L35
    L13:
        if (r4.d == this.b) goto L20;
    L19:
        r7 = true;
        goto L21
    L16:
        if (r4.e != r2) goto L20;
        if (r4.f == this.b) goto L20;
    L5:
        if (r5 == this.b) goto L8;
        Intrinsics.stringPlus("inactiveEdge activeOrientation=", Integer.valueOf(r5));
        l();
    }

    public final void q() {
        if (this.n == (-1)) goto L5;
    L11:
        int r0 = com.obric.oui.orecyclerview.base.b.a;
        this.h = com.obric.oui.orecyclerview.base.b.a.a(Math.abs(this.f), this.c);
        this.n = -1;
        this.l = true;
        m();
        this.t = AnimationUtils.currentAnimationTimeMillis() + 120;
        this.a.invalidate();
        return;
    L5:
        if (this.f != 0.0f) goto L7;
        boolean r1 = true;
    L8:
        if (r1 == false) goto L11;
        if (this.h > 0.0f) goto L11;
        return;
    L7:
        r1 = false;
        goto L8
    }

    public final void r() {
        if (this.c <= 0.0f) goto L18;
        float r0 = this.f;
        boolean r2 = false;
        if (r0 != 0.0f) goto L7;
        boolean r4 = true;
    L8:
        if (r4 == true) goto L20;
        int r5 = com.obric.oui.orecyclerview.base.b.a;
        float r1 = com.obric.oui.orecyclerview.base.b.a.a(Math.abs(r0), this.c);
        if (this.n == (-1)) goto L13;
    L16:
        this.h = r1;
        return;
    L13:
        if (this.h != 0.0f) goto L15;
        r2 = true;
    L15:
        if (r2 == true) goto L16;
        return;
    L20:
        return;
    L7:
        r4 = false;
        goto L8
    }

    public final a.C0121a s() {
        WeakHashMap<View, a.C0121a> r0 = u;
        monitor-enter(r0);
        View r1 = this.a;     // Catch: Throwable -> L10
        a.C0121a r2 = r0.get(r1);     // Catch: Throwable -> L10
        if (r2 != null) goto L7;
        r2 = new a.C0121a();     // Catch: Throwable -> L10
        r0.put(r1, r2);     // Catch: Throwable -> L10
    L7:
        a.C0121a r3 = r2;     // Catch: Throwable -> L10
        monitor-exit(r0);
        return r3;
    L10:
        th = move-exception;
        throw th;
    }

    public final void a() {
        a.C0121a r0 = s();
        int r1 = d(r0);
        int r2 = this.b;
        if (r1 == r2) goto L5;
        return;
    L5:
        if (h(r2) == false) goto L7;
        r0.a = -1;
    L8:
        int r3 = c.a;
        return;
    L7:
        r0.b = -1;
        goto L8
    }

    public final void c() {
        super.finish();
        this.n = -1;
        this.h = 0.0f;
        n(0.0f, false);
        this.i = 1.0f;
        this.j = false;
        this.l = true;
        m();
        this.t = -1;
        a();
        this.a.invalidate();
    }

    @Override // android.widget.EdgeEffect
    public final void finish() {
        long r0 = AnimationUtils.currentAnimationTimeMillis();
        if (this.t < r0) goto L20;
        boolean r1 = false;
        if (this.f != 0.0f) goto L7;
        boolean r2 = true;
    L8:
        if (r2 == true) goto L10;
    L11:
        super.finish();
        this.n = -1;
        r();
        this.l = true;
        m();
        this.t = -1;
        if (this.f != 0.0f) goto L14;
        r1 = true;
    L14:
        if (r1 == true) goto L16;
    L17:
        i();
    L18:
        this.a.invalidate();
        int r3 = c.a;
        return;
    L16:
        if (this.h <= 0.0f) goto L18;
    L10:
        if (this.h <= 0.0f) goto L20;
    L7:
        r2 = false;
    L20:
        c();
    }

    public final void i() {
        a.C0121a r0 = s();
        int r1 = d(r0);
        int r2 = this.b;
        if (r1 != r2) goto L5;
        return;
    L5:
        if (h(r2) == false) goto L7;
        r0.a = r2;
    L8:
        int r3 = c.a;
        return;
    L7:
        r0.b = r2;
        goto L8
    }

    public final void b(float r7) {
        if (this.j == false) goto L6;
        return;
    L6:
        if (r7 != 0.0f) goto L8;
        boolean r0 = true;
    L9:
        if (r0 == false) goto L11;
        return;
    L11:
        View r1 = this.a;
        float r3 = -1.0f;
        if ((r1 instanceof NestedScrollView) == false) goto L18;
        if (this.b != 0) goto L18;
        if (r7 < 0.0f) goto L27;
    L26:
        r3 = 1.0f;
    L27:
        this.i = r3;
        this.j = true;
        return;
    L18:
        if ((r1 instanceof HorizontalScrollView) == false) goto L24;
        if (this.b != 2) goto L24;
        if (r7 >= 0.0f) goto L26;
    L24:
        if ((r1 instanceof HorizontalScrollView) == false) goto L26;
        int r8 = this.b;
        goto L26
    L8:
        r0 = false;
        goto L9
    }

    public final int d(a.C0121a r2) {
        if (h(this.b) == false) goto L6;
        return r2.a;
    L6:
        return r2.b;
    }

    @Override // android.widget.EdgeEffect
    public final boolean draw(Canvas r8) {
        Intrinsics.checkNotNullParameter(r8, "canvas");
        com.obric.oui.orecyclerview.base.d r9 = this.m;
        if (this.n == (-1)) goto L10;
        if (r9 == null) goto L10;
        com.obric.oui.orecyclerview.base.d.a r10 = r9.b(AnimationUtils.currentAnimationTimeMillis() - this.n);
        n(TypedValue.applyDimension(1, r10.a, this.o), false);
        int r0 = c.a;
        if (r10.b == true) goto L9;
        this.a.invalidate();
        return true;
    L9:
        n(0.0f, false);
        this.n = -1;
        this.h = 0.0f;
        this.i = 1.0f;
        this.j = false;
        this.l = true;
        m();
        a();
    L10:
        return false;
    }

    public final float e(float r7) {
        if ((this.a instanceof HorizontalScrollView) == false) goto L22;
        int r0 = this.b;
        if (r0 == 2) goto L7;
        if (r0 != 3) goto L22;
    L7:
        float r8 = Math.abs(r7) * this.d;
        int r1 = this.b;
        boolean r3 = false;
        if (r1 == 2) goto L15;
        if (r1 == 3) goto L12;
    L10:
        r3 = true;
    L17:
        if (r3 == false) goto L20;
        return r8;
    L20:
        return -r8;
    L12:
        if (this.k <= 0.0f) goto L17;
    L15:
        if (this.k >= 0.0f) goto L17;
    L22:
        return (r7 * this.i) * this.d;
    }

    public final boolean f(float r5) {
        if (r5 != 0.0f) goto L5;
        boolean r3 = true;
    L6:
        if (r3 == false) goto L9;
        return false;
    L9:
        if (this.h <= 0.0f) goto L11;
        return true;
    L11:
        b(r5);
        if (e(r5) > 0.0f) goto L14;
        return false;
    L14:
        int r6 = this.b;
        if (r6 == 0) goto L32;
        if (r6 == 1) goto L29;
        if (r6 == 2) goto L26;
        if (r6 == 3) goto L23;
        return false;
    L23:
        if (this.a.canScrollHorizontally(1) == true) goto L35;
    L33:
        return true;
    L35:
        return false;
    L26:
        if (this.a.canScrollHorizontally(-1) == false) goto L33;
        return false;
    L29:
        if (this.a.canScrollVertically(1) == false) goto L33;
        return false;
    L32:
        if (this.a.canScrollVertically(-1) == false) goto L33;
        return false;
    L5:
        r3 = false;
        goto L6
    }

    @Override // android.widget.EdgeEffect
    public final void onAbsorb(int r12) {
        this.t = -1;
        if (this.c > 0.0f) goto L6;
        return;
    L6:
        if (this.n == (-1)) goto L9;
        int r13 = c.a;
        return;
    L9:
        int r2 = c.a;
        m();
        i();
        int r3 = this.b;
        if (r3 != 1) goto L12;
    L15:
        int r14 = -Math.abs(r12);
    L16:
        float r15 = (r14 / 1000.0f) / this.o.density;
        long r5 = AnimationUtils.currentAnimationTimeMillis();
        this.n = r5;
        if (this.m != null) goto L19;
        this.m = new com.obric.oui.orecyclerview.base.d();
    L19:
        float r7 = this.f / this.o.density;
        com.obric.oui.orecyclerview.base.d r8 = this.m;
        if (r8 == null) goto L23;
        r8.a(r15, r7);
    L23:
        if (r8 == null) goto L48;
        Display r16 = this.a.getDisplay();
        WindowManager r9 = null;
        if (r16 != null) goto L27;
        Float r17 = null;
    L28:
        if (r17 != null) goto L38;
        Object r18 = this.a.getContext().getSystemService("window");
        if ((r18 instanceof WindowManager) == false) goto L32;
        r9 = (WindowManager) r18;
    L32:
        if (r9 == null) goto L36;
        Display r110 = r9.getDefaultDisplay();
        if (r110 == null) goto L36;
        float r111 = r110.getRefreshRate();
    L40:
        if (r111 <= 0.0f) goto L42;
        float r4 = 1000.0f / r111;
    L44:
        if (r4 <= 0.0f) goto L48;
        this.n = r5 - MathKt.roundToLong(r4);
        com.obric.oui.orecyclerview.base.d.a r112 = r8.b(r4);
        n(TypedValue.applyDimension(1, r112.a, this.o), false);
        if (r112.b == false) goto L48;
        n(0.0f, false);
        this.n = -1;
        this.h = 0.0f;
        this.i = 1.0f;
        this.j = false;
        this.l = true;
        a();
        goto L48
    L42:
        r4 = 16.67f;
    L36:
        r111 = 0.0f;
        goto L40
    L38:
        r111 = r17.floatValue();
        goto L40
    L27:
        r17 = Float.valueOf(r16.getRefreshRate());
    L48:
        this.a.invalidate();
        return;
    L12:
        if (r3 == 3) goto L15;
        r14 = Math.abs(r12);
        goto L16
    }

    @Override // android.widget.EdgeEffect
    public final void onPull(float r2) {
        onPull(r2, 0.5f);
    }

    public final float j(float r9, boolean r10) {
        if (this.d > 0) goto L5;
    L81:
        return 0.0f;
    L5:
        if (this.c <= 0.0f) goto L81;
        boolean r0 = false;
        if (r9 != 0.0f) goto L10;
        boolean r3 = true;
    L11:
        if (r3 == false) goto L13;
        return 0.0f;
    L13:
        this.t = -1;
        int r5 = c.a;
        b(r9);
        if (this.n == (-1)) goto L16;
        int r6 = com.obric.oui.orecyclerview.base.b.a;
        this.h = com.obric.oui.orecyclerview.base.b.a.a(Math.abs(this.f), this.c);
        this.n = -1;
        this.l = true;
        m();
    L16:
        ViewParent r4 = this.a.getParent();
        if (r4 == null) goto L20;
        r4.requestDisallowInterceptTouchEvent(true);
    L20:
        r();
        float r7 = e(r9);
        if (this.h != 0.0f) goto L23;
        boolean r8 = true;
    L24:
        if (r8 == true) goto L26;
    L32:
        long r11 = AnimationUtils.currentAnimationTimeMillis();
        if (p(r7, r11) == false) goto L36;
        this.a.invalidate();
        return r9;
    L36:
        float r12 = this.h + r7;
        if (o(r7, r12, r11) == false) goto L40;
        i();
        this.a.invalidate();
        return r9;
    L40:
        float r13 = Math.abs(this.f);
        if (r7 >= 0.0f) goto L49;
        if (r13 <= 0.0f) goto L49;
        float r14 = r13 + r7;
        if (r14 <= 0.0f) goto L47;
        int r15 = com.obric.oui.orecyclerview.base.b.a;
        this.h = com.obric.oui.orecyclerview.base.b.a.a(r14, this.c);
    L54:
        k(s(), r11, r7);
        int r16 = this.b;
        if (r16 == 0) goto L69;
        if (r16 != 1) goto L58;
    L68:
        float r17 = -1.0f;
    L70:
        int r18 = com.obric.oui.orecyclerview.base.b.a;
        float r110 = r17 * Math.abs(com.obric.oui.orecyclerview.base.b.a.b(this.h, this.c));
        n(r110, true);
        if (this.h <= 0.0f) goto L73;
    L78:
        i();
    L79:
        this.a.invalidate();
        return r9;
    L73:
        if (r110 != 0.0f) goto L75;
        r0 = true;
    L75:
        if (r0 == false) goto L78;
        a();
        goto L79
    L58:
        if (r16 == 2) goto L69;
        if (r16 == 3) goto L68;
        float r111 = this.f;
        if (r111 != 0.0f) goto L64;
        boolean r20 = true;
    L65:
        if (r20 == true) goto L69;
        r17 = Math.signum(r111);
        goto L70
    L64:
        r20 = false;
    L69:
        r17 = 1.0f;
        goto L70
    L47:
        r9 = ((-r13) / this.d) / this.i;
        this.h = 0.0f;
        a();
    L49:
        if (r12 <= 0.0f) goto L53;
        this.h = r12;
        if (r7 <= 0.0f) goto L54;
        this.l = true;
        goto L54
    L53:
        r9 = ((-this.h) / this.d) * this.i;
        this.h = 0.0f;
        a();
        goto L54
    L26:
        if (f(r9) == true) goto L32;
        if (r10 == true) goto L29;
    L30:
        n(0.0f, false);
        m();
        return 0.0f;
    L29:
        if (r7 > 0.0f) goto L32;
    L23:
        r8 = false;
        goto L24
    L10:
        r3 = false;
        goto L11
    }

    public final void n(float r7, boolean r8) {
        if (r8 == false) goto L10;
        long r0 = AnimationUtils.currentAnimationTimeMillis();
        long r2 = this.q;
        if (r2 != (-1)) goto L6;
    L8:
        this.p = r7;
        this.q = r0;
        int r9 = c.a;
        goto L10
    L6:
        if (r0 <= r2) goto L8;
        this.r = RangesKt.coerceIn((r7 - this.p) / (r0 - r2), -20.0f, 20.0f);
        this.s = r0;
    L10:
        if (this.f != r7) goto L12;
        boolean r10 = true;
    L13:
        if (r10 == true) goto L18;
        this.f = r7;
        Function1<? super Float, Unit> r11 = this.g;
        if (r11 == null) goto L18;
        r11.invoke(Float.valueOf(r7));
    L18:
        int r12 = c.a;
        return;
    L12:
        r10 = false;
        goto L13
    }

    @Override // android.widget.EdgeEffect
    public final void onPull(float r8, float r9) {
        if (this.d > 0) goto L5;
        return;
    L5:
        if (this.c <= 0.0f) goto L64;
        boolean r10 = false;
        if (r8 != 0.0f) goto L10;
        boolean r2 = true;
    L11:
        if (r2 == false) goto L13;
        return;
    L13:
        this.t = -1;
        int r4 = c.a;
        b(r8);
        if (this.n == (-1)) goto L16;
        int r5 = com.obric.oui.orecyclerview.base.b.a;
        this.h = com.obric.oui.orecyclerview.base.b.a.a(Math.abs(this.f), this.c);
        this.n = -1;
        this.l = true;
        m();
    L16:
        ViewParent r3 = this.a.getParent();
        if (r3 == null) goto L20;
        r3.requestDisallowInterceptTouchEvent(true);
    L20:
        r();
        if (this.h != 0.0f) goto L23;
        boolean r6 = true;
    L24:
        if (r6 == true) goto L26;
    L29:
        float r11 = e(r8);
        long r7 = AnimationUtils.currentAnimationTimeMillis();
        if (p(r11, r7) == false) goto L33;
        this.a.invalidate();
        return;
    L33:
        float r12 = this.h + r11;
        if (o(r11, r12, r7) == false) goto L37;
        i();
        this.a.invalidate();
        return;
    L37:
        float r13 = RangesKt.coerceAtLeast(r12, 0.0f);
        this.h = r13;
        if (r11 > 0.0f) goto L40;
    L42:
        k(s(), r7, r11);
        int r14 = com.obric.oui.orecyclerview.base.b.a;
        float r15 = com.obric.oui.orecyclerview.base.b.a.b(this.h, this.c);
        int r16 = this.b;
        if (r16 == 0) goto L51;
        if (r16 != 1) goto L46;
    L50:
        r15 = -Math.abs(r15);
    L52:
        n(r15, true);
        if (this.h <= 0.0f) goto L55;
    L60:
        i();
    L61:
        this.a.invalidate();
        return;
    L55:
        if (r15 != 0.0f) goto L57;
        r10 = true;
    L57:
        if (r10 == false) goto L60;
        a();
        goto L61
    L46:
        if (r16 == 2) goto L51;
        if (r16 == 3) goto L50;
    L51:
        r15 = Math.abs(r15);
        goto L52
    L40:
        if (r13 <= 0.0f) goto L42;
        this.l = true;
        goto L42
    L26:
        if (f(r8) == true) goto L29;
        n(0.0f, false);
        m();
        return;
    L23:
        r6 = false;
        goto L24
    L10:
        r2 = false;
        goto L11
    }

    @Override // android.widget.EdgeEffect
    public final float onPullDistance(float r1, float r2) {
        return j(r1, false);
    }

    public final boolean p(float r6, long r7) {
        if (r6 != 0.0f) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return false;
    L8:
        a.C0121a r1 = s();
        int r3 = d(r1);
        if (r3 == (-1)) goto L15;
        if (r3 == this.b) goto L15;
        int r8 = c.a;
        return true;
    L15:
        if (g() == false) goto L30;
        if (r6 >= 0.0f) goto L30;
        if (h(this.b) == false) goto L20;
        long r4 = r1.g;
    L22:
        if (r4 != r7) goto L30;
        if (h(this.b) == false) goto L26;
        int r9 = r1.h;
    L27:
        if (r9 <= 0) goto L30;
        int r10 = c.a;
        return true;
    L26:
        r9 = r1.j;
        goto L27
    L20:
        r4 = r1.i;
    L30:
        return false;
    L5:
        r0 = false;
        goto L6
    }

    @Override // android.widget.EdgeEffect
    public final void setSize(int r3, int r4) {
        super.setSize(r3, r4);
        int r0 = this.b;
        if (r0 == 2) goto L7;
        if (r0 == 3) goto L7;
    L8:
        r3 = r4;
    L9:
        this.d = r3;
        return;
    L7:
        if (this.e == false) goto L9;
        goto L8
    }

    public final void k(a.C0121a r2, long r3, float r5) {
        int r6 = (int) Math.signum(r5);
        if (r6 != 0) goto L6;
        return;
    L6:
        if (h(this.b) == false) goto L8;
        r2.g = r3;
        r2.h = r6;
        return;
    L8:
        r2.i = r3;
        r2.j = r6;
    }

    public final boolean o(float r5, float r6, long r7) {
        if (this.h > 0.0f) goto L5;
    L28:
        return false;
    L5:
        if (r5 >= 0.0f) goto L28;
        if (r6 > 0.0f) goto L28;
        if (this.l == false) goto L28;
        if (g() == false) goto L28;
        a.C0121a r8 = s();
        if (h(this.b) == false) goto L17;
        long r2 = r8.g;
    L19:
        if (r2 != r7) goto L28;
        if (h(this.b) == false) goto L23;
        int r9 = r8.h;
    L24:
        if (r9 <= 0) goto L28;
        this.l = false;
        int r10 = c.a;
        return true;
    L23:
        r9 = r8.j;
        goto L24
    L17:
        r2 = r8.i;
        goto L19
    }

    public BounceEdgeEffect(Context r2, View r3, int r4, float r5) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "target");
        super(r2);
        this.a = r3;
        this.b = r4;
        this.c = r5;
        this.i = 1.0f;
        this.l = true;
        this.n = -1;
        Resources r6 = r2.getResources();
        this.o = WindowDisplayMetricsOverride.apply(r6, r6.getDisplayMetrics());
        this.q = -1;
        this.s = -1;
        this.t = -1;
    }
}
