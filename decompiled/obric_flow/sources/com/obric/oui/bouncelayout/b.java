package com.obric.oui.bouncelayout;

import android.content.Context;
import android.graphics.Canvas;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;
import android.widget.EdgeEffect;
import android.widget.HorizontalScrollView;
import androidx.core.widget.NestedScrollView;
import java.util.WeakHashMap;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes3.dex */
public final class b extends EdgeEffect {
    public static final WeakHashMap s = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ViewGroup f12097a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f12098b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f12099c;
    public int d;
    public boolean e;
    public float f;
    public float g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f12100h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f12101i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f12102j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f12103k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public com.obric.oui.orecyclerview.base.e f12104l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f12105m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final DisplayMetrics f12106n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public float f12107o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public long f12108p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public float f12109q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public long f12110r;

    static {
        s = new WeakHashMap();
    }

    public b(Context r5, ViewGroup r10, int r11, float r12) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r10, "target");
        super(r5);
        this.f12097a = r10;
        this.f12098b = r11;
        this.f12099c = r12;
        this.f12100h = 1.0f;
        this.f12103k = true;
        this.f12105m = -1;
        this.f12106n = r5.getResources().getDisplayMetrics();
        this.f12108p = -1;
        this.f12110r = -1;
    }

    public static boolean g(int r5) {
        if (r5 == 0) goto L8;
        if (r5 == 1) goto L9;
        return false;
    L9:
        return true;
    L8:
        return true;
    }

    public final void a() {
        a r5 = o();
        int r10 = c(r5);
        int r11 = this.f12098b;
        if (r10 == r11) goto L5;
        return;
    L5:
        if (g(r11) == false) goto L7;
        r5.f12091a = -1;
        return;
    L7:
        r5.f12092b = -1;
    }

    public final void b(float r10) {
        if (this.f12101i == false) goto L6;
        return;
    L6:
        if (r10 != 0.0f) goto L8;
        return;
    L8:
        ViewGroup r5 = this.f12097a;
        boolean r11 = r5 instanceof NestedScrollView;
        float r12 = -1.0f;
        int r13 = this.f12098b;
        if (r11 == false) goto L14;
        if (r13 != 0) goto L14;
        if (r10 < 0.0f) goto L22;
    L13:
        r12 = 1.0f;
    L22:
        this.f12100h = r12;
        this.f12101i = true;
        return;
    L14:
        boolean r14 = r5 instanceof HorizontalScrollView;
        if (r14 == true) goto L17;
    L20:
        if (r14 == false) goto L13;
        goto L13
    L17:
        if (r13 != 2) goto L20;
        if (r10 >= 0.0f) goto L13;
        goto L13
    }

    public final int c(a r5) {
        if (g(this.f12098b) == false) goto L6;
        return r5.f12091a;
    L6:
        return r5.f12092b;
    }

    public final float d(float r5) {
        if ((this.f12097a instanceof HorizontalScrollView) == false) goto L20;
        int r10 = this.f12098b;
        if (r10 == 2) goto L7;
        if (r10 != 3) goto L20;
    L7:
        float r11 = Math.abs(r5) * this.d;
        if (r10 == 2) goto L15;
        if (r10 == 3) goto L12;
        return r11;
    L12:
        if (this.f12102j <= 0.0f) goto L18;
        return r11;
    L18:
        return -r11;
    L15:
        if (this.f12102j >= 0.0f) goto L18;
        return r11;
    L20:
        return (r5 * this.f12100h) * this.d;
    }

    @Override // android.widget.EdgeEffect
    public final boolean draw(Canvas r10) {
        Intrinsics.checkNotNullParameter(r10, "canvas");
        com.obric.oui.orecyclerview.base.e r11 = this.f12104l;
        if (this.f12105m == (-1)) goto L10;
        if (r11 == null) goto L10;
        com.obric.oui.orecyclerview.base.d r12 = r11.b(AnimationUtils.currentAnimationTimeMillis() - this.f12105m);
        k(TypedValue.applyDimension(1, r12.f13710a, this.f12106n), false);
        if (r12.f13711b == true) goto L9;
        this.f12097a.invalidate();
        return true;
    L9:
        k(0.0f, false);
        this.f12105m = -1;
        this.g = 0.0f;
        this.f12100h = 1.0f;
        this.f12101i = false;
        this.f12103k = true;
        j();
        a();
    L10:
        return false;
    }

    public final boolean e(float r5) {
        if (r5 != 0.0f) goto L6;
        return false;
    L6:
        if (this.g <= 0.0f) goto L8;
        return true;
    L8:
        b(r5);
        if (d(r5) > 0.0f) goto L11;
        return false;
    L11:
        ViewGroup r10 = this.f12097a;
        int r11 = this.f12098b;
        if (r11 == 0) goto L29;
        if (r11 == 1) goto L26;
        if (r11 == 2) goto L23;
        if (r11 == 3) goto L20;
        return false;
    L20:
        if (r10.canScrollHorizontally(1) == false) goto L32;
        return false;
    L32:
        return true;
    L23:
        if (r10.canScrollHorizontally(-1) == false) goto L32;
        return false;
    L26:
        if (r10.canScrollVertically(1) == false) goto L32;
        return false;
    L29:
        if (r10.canScrollVertically(-1) == false) goto L32;
        return false;
    }

    public final boolean f() {
        ViewGroup r5 = this.f12097a;
        int r10 = this.f12098b;
        if (r10 == 0) goto L12;
        if (r10 == 1) goto L12;
        if (r5.canScrollHorizontally(-1) == false) goto L9;
        return false;
    L9:
        if (r5.canScrollHorizontally(1) == false) goto L18;
        return false;
    L18:
        return true;
    L12:
        if (r5.canScrollVertically(-1) == false) goto L14;
        return false;
    L14:
        if (r5.canScrollVertically(1) == false) goto L18;
        return false;
    }

    @Override // android.widget.EdgeEffect
    public final void finish() {
        super.finish();
        this.f12105m = -1;
        this.g = 0.0f;
        k(0.0f, false);
        this.f12100h = 1.0f;
        this.f12101i = false;
        this.f12103k = true;
        j();
        a();
        this.f12097a.invalidate();
    }

    @Override // android.widget.EdgeEffect
    public final float getDistance() {
        int r5 = this.d;
        if (r5 > 0) goto L7;
        return 0.0f;
    L7:
        return this.g / r5;
    }

    public final void h() {
        a r5 = o();
        int r10 = c(r5);
        int r11 = this.f12098b;
        if (r10 != r11) goto L5;
        return;
    L5:
        if (g(r11) == false) goto L7;
        r5.f12091a = r11;
        return;
    L7:
        r5.f12092b = r11;
    }

    public final void i() {
        this.f12105m = -1;
        this.g = 0.0f;
        k(0.0f, false);
        this.f12100h = 1.0f;
        this.f12101i = false;
        this.f12103k = true;
        j();
        this.f12097a.invalidate();
    }

    @Override // android.widget.EdgeEffect
    public final boolean isFinished() {
        if (this.f12105m == (-1)) goto L5;
    L7:
        return false;
    L5:
        if (this.f != 0.0f) goto L7;
        return true;
    }

    public final void j() {
        this.f12107o = this.f;
        this.f12108p = -1;
        this.f12109q = 0.0f;
        this.f12110r = -1;
    }

    public final void k(float r10, boolean r11) {
        if (r11 == false) goto L10;
        long r5 = AnimationUtils.currentAnimationTimeMillis();
        long r12 = this.f12108p;
        if (r12 != (-1)) goto L6;
    L8:
        this.f12107o = r10;
        this.f12108p = r5;
        goto L10
    L6:
        if (r5 <= r12) goto L8;
        this.f12109q = RangesKt.coerceIn((r10 - this.f12107o) / (r5 - r12), -20.0f, 20.0f);
        this.f12110r = r5;
    L10:
        if (this.f == r10) goto L14;
        this.f = r10;
        return;
    }

    public final boolean l(float r5, float r10) {
        if (this.g > 0.0f) goto L5;
    L16:
        return false;
    L5:
        if (r5 >= 0.0f) goto L16;
        if (r10 > 0.0f) goto L16;
        if (this.f12103k == false) goto L16;
        if (f() == false) goto L16;
        this.f12103k = false;
        return true;
    }

    public final boolean m(long r10, float r11) {
        if (r11 != 0.0f) goto L5;
        return false;
    L5:
        a r5 = o();
        int r12 = c(r5);
        int r13 = this.f12098b;
        if (r12 == (-1)) goto L10;
        if (r12 == r13) goto L10;
        return true;
    L10:
        if (f() == false) goto L24;
        if (r11 >= 0.0f) goto L24;
        if (g(r13) == false) goto L15;
        long r14 = r5.g;
    L17:
        if (r14 != r10) goto L24;
        if (g(r13) == false) goto L21;
        int r15 = r5.f12094h;
    L22:
        if (r15 <= 0) goto L24;
        return true;
    L21:
        r15 = r5.f12096j;
        goto L22
    L15:
        r14 = r5.f12095i;
    L24:
        return false;
    }

    public final void n() {
        if (this.f12105m == (-1)) goto L12;
        float r5 = Math.abs(this.f);
        float r10 = this.f12099c;
        float r11 = 0.0f;
        if (r5 >= 0.0f) goto L7;
    L10:
        this.g = r11;
        this.f12105m = -1;
        this.f12103k = true;
        j();
        this.f12097a.invalidate();
        return;
    L7:
        if (r10 <= 0.0f) goto L10;
        float r12 = RangesKt.coerceAtMost(r5, r10 - 1.0E-5f);
        r11 = ((r10 * r12) / (r10 - r12)) / 0.55f;
        goto L10
    }

    public final a o() {
        WeakHashMap r5 = s;
        monitor-enter(r5);
        ViewGroup r10 = this.f12097a;     // Catch: Throwable -> L7
        Object r11 = r5.get(r10);     // Catch: Throwable -> L7
        Object r12 = r11;
        if (r11 != null) goto L9;
        a r13 = new a();     // Catch: Throwable -> L7
        r13.f12091a = -1;     // Catch: Throwable -> L7
        r13.f12092b = -1;     // Catch: Throwable -> L7
        r13.f12093c = -1;     // Catch: Throwable -> L7
        r13.d = -1;     // Catch: Throwable -> L7
        r13.e = -1;     // Catch: Throwable -> L7
        r13.f = -1;     // Catch: Throwable -> L7
        r13.g = -1;     // Catch: Throwable -> L7
        r13.f12095i = -1;     // Catch: Throwable -> L7
        r5.put(r10, r13);     // Catch: Throwable -> L7
        r12 = r13;
    L9:
        a r14 = (a) r12;     // Catch: Throwable -> L7
        monitor-exit(r5);
        return r14;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // android.widget.EdgeEffect
    public final void onAbsorb(int r13) {
        if (this.f12099c > 0.0f) goto L6;
        return;
    L6:
        if (this.f12105m == (-1)) goto L8;
        return;
    L8:
        j();
        h();
        int r5 = this.f12098b;
        if (r5 != 1) goto L11;
    L14:
        int r14 = -Math.abs(r13);
    L15:
        DisplayMetrics r10 = this.f12106n;
        float r15 = (r14 / 1000.0f) / r10.density;
        long r11 = AnimationUtils.currentAnimationTimeMillis();
        this.f12105m = r11;
        if (this.f12104l != null) goto L18;
        this.f12104l = new com.obric.oui.orecyclerview.base.e();
    L18:
        float r12 = this.f / r10.density;
        com.obric.oui.orecyclerview.base.e r16 = this.f12104l;
        if (r16 == null) goto L22;
        r16.a(r15, r12);
    L22:
        ViewGroup r17 = this.f12097a;
        if (r16 == null) goto L48;
        Display r18 = r17.getDisplay();
        WindowManager r19 = null;
        if (r18 != null) goto L27;
        Float r20 = null;
    L28:
        if (r20 != null) goto L38;
        Object r21 = r17.getContext().getSystemService("window");
        if ((r21 instanceof WindowManager) == false) goto L32;
        r19 = (WindowManager) r21;
    L32:
        if (r19 != null) goto L34;
    L33:
        float r22 = 0.0f;
    L40:
        if (r22 <= 0.0f) goto L42;
        float r23 = 1000.0f / r22;
    L44:
        if (r23 <= 0.0f) goto L48;
        this.f12105m = r11 - MathKt.roundToLong(r23);
        com.obric.oui.orecyclerview.base.d r24 = r16.b(r23);
        k(TypedValue.applyDimension(1, r24.f13710a, r10), false);
        if (r24.f13711b == false) goto L48;
        k(0.0f, false);
        this.f12105m = -1;
        this.g = 0.0f;
        this.f12100h = 1.0f;
        this.f12101i = false;
        this.f12103k = true;
        a();
        goto L48
    L42:
        r23 = 16.67f;
        goto L44
    L34:
        Display r25 = r19.getDefaultDisplay();
        if (r25 == null) goto L33;
        r22 = r25.getRefreshRate();
        goto L40
    L38:
        r22 = r20.floatValue();
        goto L40
    L27:
        r20 = Float.valueOf(r18.getRefreshRate());
    L48:
        r17.invalidate();
        return;
    L11:
        if (r5 == 3) goto L14;
        r14 = Math.abs(r13);
        goto L15
    }

    @Override // android.widget.EdgeEffect
    public final void onPull(float r5) {
        onPull(r5, 0.5f);
    }

    @Override // android.widget.EdgeEffect
    public final float onPullDistance(float r10, float r11) {
        if (this.d > 0) goto L5;
    L78:
        return 0.0f;
    L5:
        if (this.f12099c <= 0.0f) goto L78;
        b(r10);
        if (this.f12105m == (-1)) goto L17;
        float r12 = Math.abs(this.f);
        float r5 = this.f12099c;
        if (r12 >= 0.0f) goto L12;
    L15:
        float r13 = 0.0f;
    L16:
        this.g = r13;
        this.f12105m = -1;
        this.f12103k = true;
        j();
        goto L17
    L12:
        if (r5 <= 0.0f) goto L15;
        float r14 = RangesKt.coerceAtMost(r12, r5 - 1.0E-5f);
        r13 = ((r5 * r14) / (r5 - r14)) / 0.55f;
    L17:
        ViewGroup r15 = this.f12097a;
        ViewParent r16 = r15.getParent();
        if (r16 == null) goto L22;
        r16.requestDisallowInterceptTouchEvent(true);
    L22:
        if (this.g == 0.0f) goto L24;
    L27:
        float r17 = d(r10);
        if (r10 != 0.0f) goto L30;
        return 0.0f;
    L30:
        long r18 = AnimationUtils.currentAnimationTimeMillis();
        if (m(r18, r17) == false) goto L34;
        r15.invalidate();
        return r10;
    L34:
        float r19 = this.g + r17;
        if (l(r17, r19) == false) goto L39;
        h();
        r15.invalidate();
        return r10;
    L39:
        if (r19 <= 0.0f) goto L43;
        this.g = r19;
        if (r17 <= 0.0f) goto L44;
        this.f12103k = true;
    L44:
        a r20 = o();
        int r21 = (int) Math.signum(r17);
        int r22 = this.f12098b;
        if (r21 == 0) goto L52;
        if (g(r22) == false) goto L50;
        r20.g = r18;
        r20.f12094h = r21;
        goto L52
    L50:
        r20.f12095i = r18;
        r20.f12096j = r21;
    L52:
        if (r22 == 0) goto L60;
        if (r22 != 1) goto L55;
    L62:
        float r23 = -1.0f;
    L63:
        float r24 = this.g;
        float r25 = this.f12099c;
        if (r24 >= 0.0f) goto L66;
    L69:
        float r26 = 0.0f;
    L70:
        float r27 = Math.abs(r26) * r23;
        k(r27, true);
        if (this.g <= 0.0f) goto L73;
    L75:
        h();
    L76:
        r15.invalidate();
        return r10;
    L73:
        if (r27 != 0.0f) goto L75;
        a();
        goto L76
    L66:
        if (r25 <= 0.0f) goto L69;
        r26 = (1.0f - (1.0f / (((r24 / r25) * 0.55f) + 1.0f))) * r25;
        goto L70
    L55:
        if (r22 == 2) goto L60;
        if (r22 == 3) goto L62;
        float r28 = this.f;
        if (r28 == 0.0f) goto L60;
        r23 = Math.signum(r28);
    L60:
        r23 = 1.0f;
        goto L63
    L43:
        r10 = ((-this.g) / this.d) * this.f12100h;
        this.g = 0.0f;
        goto L44
    L24:
        if (e(r10) == true) goto L27;
        k(0.0f, false);
        j();
        return 0.0f;
    }

    @Override // android.widget.EdgeEffect
    public final void onRelease() {
        long r5 = AnimationUtils.currentAnimationTimeMillis();
        a r10 = o();
        int r11 = c(r10);
        int r12 = this.f12098b;
        if (r11 == (-1)) goto L8;
        if (r11 == r12) goto L8;
        Intrinsics.stringPlus("inactiveEdge activeOrientation=", Integer.valueOf(r11));
        i();
        return;
    L8:
        if (g(r12) == false) goto L15;
        if (r10.f12093c == r5) goto L12;
    L20:
        float r13 = this.f;
        float r14 = 0.0f;
        if (r13 != 0.0f) goto L24;
        this.g = 0.0f;
        this.f12105m = -1;
        this.f12103k = true;
        j();
        a();
        return;
    L24:
        DisplayMetrics r15 = this.f12106n;
        float r16 = r13 / r15.density;
        long r17 = AnimationUtils.currentAnimationTimeMillis();
        long r18 = this.f12110r;
        if (r18 != (-1)) goto L27;
    L29:
        float r19 = r14 / r15.density;
        if (g(r12) == false) goto L32;
        r10.f12093c = r5;
        r10.d = r12;
    L33:
        h();
        this.f12105m = r5;
        if (this.f12104l != null) goto L36;
        this.f12104l = new com.obric.oui.orecyclerview.base.e();
    L36:
        com.obric.oui.orecyclerview.base.e r20 = this.f12104l;
        if (r20 == null) goto L40;
        r20.a(r19, r16);
    L40:
        j();
        this.f12097a.invalidate();
        return;
    L32:
        r10.e = r5;
        r10.f = r12;
        goto L33
    L27:
        if ((r17 - r18) > 120) goto L29;
        r14 = this.f12109q;
        goto L29
    L12:
        if (r10.d == r12) goto L20;
    L18:
        i();
        return;
    L15:
        if (r10.e != r5) goto L20;
        if (r10.f == r12) goto L20;
        goto L18
    }

    @Override // android.widget.EdgeEffect
    public final void setSize(int r5, int r10) {
        super.setSize(r5, r10);
        int r11 = this.f12098b;
        if (r11 == 2) goto L7;
        if (r11 == 3) goto L7;
    L8:
        r5 = r10;
    L9:
        this.d = r5;
        return;
    L7:
        if (this.e == false) goto L9;
        goto L8
    }

    @Override // android.widget.EdgeEffect
    public final void onPull(float r10, float r11) {
        if (this.d > 0) goto L5;
        return;
    L5:
        if (this.f12099c <= 0.0f) goto L72;
        b(r10);
        if (this.f12105m == (-1)) goto L17;
        float r12 = Math.abs(this.f);
        float r5 = this.f12099c;
        if (r12 >= 0.0f) goto L12;
    L15:
        float r13 = 0.0f;
    L16:
        this.g = r13;
        this.f12105m = -1;
        this.f12103k = true;
        j();
        goto L17
    L12:
        if (r5 <= 0.0f) goto L15;
        float r14 = RangesKt.coerceAtMost(r12, r5 - 1.0E-5f);
        r13 = ((r5 * r14) / (r5 - r14)) / 0.55f;
    L17:
        ViewGroup r15 = this.f12097a;
        ViewParent r16 = r15.getParent();
        if (r16 == null) goto L22;
        r16.requestDisallowInterceptTouchEvent(true);
    L22:
        if (this.g == 0.0f) goto L24;
    L27:
        float r17 = d(r10);
        long r18 = AnimationUtils.currentAnimationTimeMillis();
        if (m(r18, r17) == false) goto L31;
        r15.invalidate();
        return;
    L31:
        float r19 = this.g + r17;
        if (l(r17, r19) == false) goto L35;
        h();
        r15.invalidate();
        return;
    L35:
        float r20 = RangesKt.coerceAtLeast(r19, 0.0f);
        this.g = r20;
        if (r17 > 0.0f) goto L38;
    L40:
        a r21 = o();
        int r22 = (int) Math.signum(r17);
        int r23 = this.f12098b;
        if (r22 != 0) goto L44;
    L47:
        float r24 = this.g;
        float r25 = this.f12099c;
        if (r24 >= 0.0f) goto L50;
    L53:
        float r26 = 0.0f;
    L54:
        if (r23 == 0) goto L62;
        if (r23 != 1) goto L57;
    L61:
        r26 = -Math.abs(r26);
    L63:
        k(r26, true);
        if (this.g <= 0.0f) goto L66;
    L68:
        h();
    L69:
        r15.invalidate();
        return;
    L66:
        if (r26 != 0.0f) goto L68;
        a();
        goto L69
    L57:
        if (r23 == 2) goto L62;
        if (r23 == 3) goto L61;
    L62:
        r26 = Math.abs(r26);
        goto L63
    L50:
        if (r25 <= 0.0f) goto L53;
        r26 = (1.0f - (1.0f / (((r24 / r25) * 0.55f) + 1.0f))) * r25;
        goto L54
    L44:
        if (g(r23) == false) goto L46;
        r21.g = r18;
        r21.f12094h = r22;
        goto L47
    L46:
        r21.f12095i = r18;
        r21.f12096j = r22;
        goto L47
    L38:
        if (r20 <= 0.0f) goto L40;
        this.f12103k = true;
        goto L40
    L24:
        if (e(r10) == true) goto L27;
        k(0.0f, false);
        j();
        return;
    }
}
