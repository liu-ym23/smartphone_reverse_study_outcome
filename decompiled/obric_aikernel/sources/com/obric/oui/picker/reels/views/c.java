package com.obric.oui.picker.reels.views;

import android.content.Context;
import android.os.Build;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewParent;
import android.view.animation.LinearInterpolator;
import android.widget.OverScroller;
import androidx.core.app.NotificationCompat;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import o9.m;
import u8.i;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends OverScroller {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f7038a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private float f7039b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f7040c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private VelocityTracker f7041d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f7042e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private com.obric.oui.picker.reels.views.a f7043f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f7044g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final WheelView f7045h;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }
    }

    static {
        new a(null);
    }

    public c(Context r10, WheelView r11) {
        Intrinsics.checkNotNullParameter(r11, "mWheelView");
        super(r10, new LinearInterpolator());
        this.f7045h = r11;
        b.f7037e.d();
        this.f7044g = -1;
    }

    private final void b(int r10, String r11) {
        this.f7038a += r10;
        if (this.f7045h.i() == true) goto L10;
        int r12 = (this.f7045h.getItemSize() - 1) * this.f7045h.getItemHeightPx();
        int r13 = this.f7045h.getItemHeightPx() * 0;
        int r14 = this.f7038a;
        int r15 = -r13;
        if (r14 >= r15) goto L7;
        this.f7038a = r15;
        goto L10
    L7:
        int r16 = r12 + r13;
        if (r14 <= r16) goto L10;
        this.f7038a = r16;
    L10:
        i(r11);
    }

    private final void g(int r12) {
        int r10 = this.f7045h.getItemHeightPx();
        int r11 = this.f7038a % r10;
        if (r11 != 0) goto L8;
        com.obric.oui.picker.reels.views.a r13 = this.f7043f;
        if (r13 == null) goto L8;
        r13.a(this.f7044g);
    L8:
        if (r11 <= 0) goto L13;
        if (r11 >= (r10 / 2)) goto L13;
    L11:
        this.f7040c = true;
        int r14 = 0;
        int r15 = this.f7038a;
        int r16 = 0;
        int r17 = -r11;
    L15:
        p(r14, r15, r16, r17, r12, "justify");
        this.f7045h.invalidate();
        return;
    L13:
        if (r11 < (r10 / 2)) goto L16;
    L14:
        this.f7040c = true;
        r14 = 0;
        r15 = this.f7038a;
        r16 = 0;
        r17 = r10 - r11;
        goto L15
    L16:
        if (r11 < 0) goto L18;
    L20:
        r10 = -r10;
        if (r11 <= (r10 / 2)) goto L14;
        return;
    L18:
        if (r11 <= ((-r10) / 2)) goto L20;
        goto L20
    }

    static /* synthetic */ void h(c r10, int r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L5;
        r11 = 200;
    L5:
        r10.g(r11);
    }

    private final void i(String r10) {
        int r11 = this.f7044g;
        int r12 = c();
        if (r11 == r12) goto L8;
        this.f7044g = r12;
        l(this.f7045h.getContext(), r10);
        com.obric.oui.picker.reels.views.a r13 = this.f7043f;
        if (r13 == null) goto L9;
        r13.b(r11, r12);
        return;
    L9:
        return;
    }

    private final void l(Context r10, String r11) {
        ea.b.a("WheelScroller", "performVibrateEffect, scene: [" + r11 + ']');
        int r12 = r11.hashCode();
        if (r12 == (-1621011813)) goto L11;
        if (r12 == 530781668) goto L8;
        return;
    L8:
        if (r11.equals("computeScroll") == false) goto L16;
    L12:
        q9.a.f12489c.a(this.f7045h, 26);
        if (Build.VERSION.SDK_INT < 24) goto L18;
        m.f11593e.f(r10, i.reel_picker);
        return;
    L18:
        return;
    L16:
        return;
    L11:
        if (r11.equals("touchEvent") == true) goto L12;
    }

    private final void p(int r10, int r11, int r12, int r13, int r14, String r15) {
        ea.b.a("WheelScroller", "startScrollInternal, startX: " + r10 + ", startY: " + r11 + ", dx: " + r12 + ", dy: " + r13 + ", duration: " + r14 + ", scene: " + r15);
        startScroll(r10, r11, r12, r13, r14);
    }

    public final void a() {
        if (this.f7040c == false) goto L9;
        this.f7040c = computeScrollOffset();
        b(getCurrY() - this.f7038a, "computeScroll");
        if (this.f7040c == false) goto L7;
        this.f7045h.postInvalidate();
        return;
    L7:
        h(this, 0, 1, null);
        return;
    }

    public final int c() {
        int r10 = this.f7045h.getItemHeightPx();
        int r11 = this.f7045h.getItemSize();
        if (r11 != 0) goto L6;
        return -1;
    L6:
        int r12 = this.f7038a;
        int r13 = r10 / 2;
        if (r12 >= 0) goto L9;
        int r14 = r12 - r13;
    L10:
        int r15 = r14 / r10;
        int r16 = r15 % r11;
        if (this.f7045h.i() == true) goto L14;
        if (r15 < r11) goto L14;
        r16 = r11 - 1;
    L14:
        if (r16 < 0) goto L16;
        return r16;
    L16:
        return r16 + r11;
    L9:
        r14 = r12 + r13;
        goto L10
    }

    public final int d() {
        if (this.f7045h.getItemHeightPx() != 0) goto L6;
        return 0;
    L6:
        return this.f7038a / this.f7045h.getItemHeightPx();
    }

    public final int e() {
        if (this.f7045h.getItemHeightPx() != 0) goto L6;
        return 0;
    L6:
        return this.f7038a % this.f7045h.getItemHeightPx();
    }

    public final com.obric.oui.picker.reels.views.a f() {
        return this.f7043f;
    }

    public final boolean j(MotionEvent r13) {
        Intrinsics.checkNotNullParameter(r13, NotificationCompat.CATEGORY_EVENT);
        if (this.f7041d != null) goto L5;
        this.f7041d = VelocityTracker.obtain();
    L5:
        VelocityTracker r10 = this.f7041d;
        if (r10 == null) goto L8;
        r10.addMovement(r13);
    L8:
        int r11 = r13.getAction();
        if (r11 != 0) goto L11;
        ViewParent r12 = this.f7045h.getParent();
        if (r12 == null) goto L59;
        r12.requestDisallowInterceptTouchEvent(true);
    L59:
        this.f7039b = r13.getY();
        forceFinished(true);
        this.f7042e = false;
        this.f7040c = false;
    L60:
        return true;
    L11:
        if (r11 == 1) goto L29;
        if (r11 != 2) goto L14;
        float r14 = r13.getY();
        int r15 = (int) (r14 - this.f7039b);
        if (r15 == 0) goto L28;
        this.f7042e = true;
        b(-r15, "touchEvent");
        this.f7045h.invalidate();
    L28:
        this.f7039b = r14;
        goto L60
    L14:
        if (r11 != 3) goto L60;
        if (this.f7042e == false) goto L19;
        h(this, 0, 1, null);
    L19:
        VelocityTracker r16 = this.f7041d;
        if (r16 == null) goto L22;
        r16.recycle();
    L22:
        this.f7041d = null;
        this.f7042e = false;
        ViewParent r17 = this.f7045h.getParent();
        if (r17 == null) goto L60;
    L24:
        r17.requestDisallowInterceptTouchEvent(false);
        goto L60
    L29:
        VelocityTracker r18 = this.f7041d;
        if (r18 == null) goto L32;
        r18.computeCurrentVelocity(1000);
    L32:
        VelocityTracker r19 = this.f7041d;
        if (r19 == null) goto L35;
        float r20 = r19.getYVelocity();
    L37:
        if (Math.abs(r20) <= 0) goto L44;
        int r21 = (this.f7045h.getItemSize() - 1) * this.f7045h.getItemHeightPx();
        int r22 = this.f7045h.getItemHeightPx() * 0;
        this.f7040c = true;
        if (this.f7045h.i() == false) goto L41;
        b r23 = b.f7037e;
        int r24 = this.f7045h.getItemHeightPx();
        int r25 = this.f7038a;
        int r26 = ((int) (-r20)) / 2;
        int r27 = Integer.MIN_VALUE;
        r21 = Integer.MAX_VALUE;
        r22 = 0;
    L42:
        r23.f(this, r24, r25, r26, r27, r21, r22);
    L48:
        this.f7045h.invalidate();
    L50:
        VelocityTracker r28 = this.f7041d;
        if (r28 == null) goto L53;
        r28.recycle();
    L53:
        this.f7041d = null;
        r17 = this.f7045h.getParent();
        if (r17 == null) goto L60;
    L41:
        r23 = b.f7037e;
        r24 = this.f7045h.getItemHeightPx();
        r25 = this.f7038a;
        r26 = ((int) (-r20)) / 2;
        r27 = 0;
        goto L42
    L44:
        if (this.f7042e == true) goto L49;
        float r29 = r13.getY() - (this.f7045h.getHeight() / 2.0f);
        if (Math.abs(r29) <= 1) goto L50;
        this.f7040c = true;
        p(0, this.f7038a, 0, (int) r29, 200, "ACTION_UP");
        goto L48
    L49:
        h(this, 0, 1, null);
        goto L50
    L35:
        r20 = 0.0f;
        goto L37
    }

    public final void k(Context r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        if (Build.VERSION.SDK_INT < 24) goto L6;
        m.f11593e.e(r10, new int[]{i.reel_picker});
        return;
    }

    public final void m() {
        this.f7040c = false;
        this.f7038a = 0;
        this.f7044g = -1;
        i("reset");
        forceFinished(true);
    }

    public final void n(int r10, boolean r11) {
        int r12 = r10 * this.f7045h.getItemHeightPx();
        int r13 = this.f7038a;
        int r14 = r12 - r13;
        if (r14 != 0) goto L5;
        return;
    L5:
        if (r11 == false) goto L7;
        this.f7040c = true;
        p(0, r13, 0, r14, 200, "setCurrentIndex");
    L8:
        this.f7045h.invalidate();
        return;
    L7:
        b(r14, "setCurrentIndex");
        goto L8
    }

    public final void o(com.obric.oui.picker.reels.views.a r10) {
        this.f7043f = r10;
    }
}
