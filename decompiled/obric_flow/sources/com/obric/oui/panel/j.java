package com.obric.oui.panel;

import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.widget.OverScroller;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import java.lang.ref.WeakReference;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public final class j {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final i f14010w = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f14011a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f14012b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f14013c;
    public float[] d;
    public float[] e;
    public float[] f;
    public float[] g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int[] f14014h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int[] f14015i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int[] f14016j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f14017k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public VelocityTracker f14018l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final float f14019m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final float f14020n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final int f14021o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final OverScroller f14022p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final b f14023q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public View f14024r;
    public boolean s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final CoordinatorLayout f14025t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f14026u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final com.lynx.tasm.ui.image.h f14027v;

    static {
        f14010w = new i(0);
    }

    public j(Context r5, CoordinatorLayout r10, b r11) {
        this.f14013c = -1;
        this.f14026u = 600;
        this.f14027v = new com.lynx.tasm.ui.image.h(this, 8);
        if (r10 == null) goto L10;
        if (r11 == null) goto L8;
        this.f14025t = r10;
        this.f14023q = r11;
        ViewConfiguration r12 = ViewConfiguration.get(r5);
        this.f14021o = (int) ((r5.getResources().getDisplayMetrics().density * 20.0f) + 0.5f);
        this.f14012b = r12.getScaledTouchSlop();
        this.f14019m = r12.getScaledMaximumFlingVelocity();
        this.f14020n = r12.getScaledMinimumFlingVelocity();
        this.f14022p = new OverScroller(r5, f14010w);
        return;
    L8:
        throw new IllegalArgumentException("Callback may not be null");
    L10:
        throw new IllegalArgumentException("Parent view may not be null");
    }

    public final void a() {
        this.f14013c = -1;
        float[] r5 = this.d;
        if (r5 == null) goto L6;
        Arrays.fill(r5, 0.0f);
        Arrays.fill(this.e, 0.0f);
        Arrays.fill(this.f, 0.0f);
        Arrays.fill(this.g, 0.0f);
        Arrays.fill(this.f14014h, 0);
        Arrays.fill(this.f14015i, 0);
        Arrays.fill(this.f14016j, 0);
        this.f14017k = 0;
    L6:
        VelocityTracker r10 = this.f14018l;
        if (r10 == null) goto L10;
        r10.recycle();
        this.f14018l = null;
        return;
    }

    public final void b(View r5, int r10) {
        ViewParent r11 = r5.getParent();
        CoordinatorLayout r12 = this.f14025t;
        if (r11 != r12) goto L7;
        this.f14024r = r5;
        this.f14013c = r10;
        this.f14023q.getClass();
        k(1);
        return;
    L7:
        throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + r12 + ")");
    }

    public final void c(int r5) {
        float[] r10 = this.d;
        if (r10 == null) goto L8;
        int r11 = this.f14017k;
        int r12 = 1 << r5;
        if ((r11 & r12) == 0) goto L9;
        r10[r5] = 0.0f;
        this.e[r5] = 0.0f;
        this.f[r5] = 0.0f;
        this.g[r5] = 0.0f;
        this.f14014h[r5] = 0;
        this.f14015i[r5] = 0;
        this.f14016j[r5] = 0;
        this.f14017k = (~r12) & r11;
        return;
    L9:
        return;
    }

    public final int d(int r5, int r10, int r11) {
        if (r5 != 0) goto L5;
        return 0;
    L5:
        int r12 = this.f14025t.getWidth();
        float r13 = r12 / 2;
        float r14 = (((float) Math.sin((Math.min(1.0f, Math.abs(r5) / r12) - 0.5f) * 0.47123894f)) * r13) + r13;
        int r15 = Math.abs(r10);
        if (r15 <= 0) goto L8;
        int r16 = Math.round(Math.abs(r14 / r15) * 1000.0f) * 4;
    L10:
        return Math.min(r16, this.f14026u);
    L8:
        r16 = (int) (((Math.abs(r5) / r11) + 1.0f) * 256.0f);
        goto L10
    }

    public final View e(int r5, int r10) {
        CoordinatorLayout r11 = this.f14025t;
        int r12 = r11.getChildCount() - 1;
    L3:
        if (r12 < 0) goto L14;
        this.f14023q.getClass();
        View r13 = r11.getChildAt(r12);
        if (r5 < r13.getLeft()) goto L13;
        if (r5 >= r13.getRight()) goto L13;
        if (r10 < r13.getTop()) goto L13;
        if (r10 >= r13.getBottom()) goto L13;
        return r13;
    L13:
        r12 = r12 - 1;
        goto L3
    L14:
        return null;
    }

    public final boolean f(int r12, int r13, int r14, int r15) {
        int r5 = this.f14024r.getLeft();
        int r10 = this.f14024r.getTop();
        int r11 = r12 - r5;
        int r16 = r13 - r10;
        OverScroller r17 = this.f14022p;
        if (r11 != 0) goto L7;
        if (r16 != 0) goto L7;
        r17.abortAnimation();
        k(0);
        return false;
    L7:
        View r18 = this.f14024r;
        int r19 = (int) this.f14020n;
        int r20 = (int) this.f14019m;
        int r21 = Math.abs(r14);
        if (r21 >= r19) goto L10;
        r14 = 0;
    L14:
        int r22 = Math.abs(r15);
        if (r22 >= r19) goto L17;
        r15 = 0;
    L21:
        int r23 = Math.abs(r11);
        int r24 = Math.abs(r16);
        int r25 = Math.abs(r14);
        int r26 = Math.abs(r15);
        int r27 = r25 + r26;
        int r110 = r23 + r24;
        if (r14 == 0) goto L25;
        float r28 = r25;
        float r29 = r27;
    L24:
        float r30 = r28 / r29;
        if (r15 == 0) goto L29;
        float r31 = r26;
        float r32 = r27;
    L28:
        float r33 = r31 / r32;
        b r34 = this.f14023q;
        r34.getClass();
        int r111 = d(r11, r14, 0);
        r17.startScroll(r5, r10, r11, r16, (int) ((d(r16, r15, r34.o(r18)) * r33) + (r111 * r30)));
        k(2);
        return true;
    L29:
        r31 = r24;
        r32 = r110;
        goto L28
    L25:
        r28 = r23;
        r29 = r110;
        goto L24
    L17:
        if (r22 <= r20) goto L21;
        if (r15 <= 0) goto L20;
        r15 = r20;
        goto L21
    L20:
        r15 = -r20;
        goto L21
    L10:
        if (r21 <= r20) goto L14;
        if (r14 <= 0) goto L13;
        r14 = r20;
        goto L14
    L13:
        r14 = -r20;
        goto L14
    }

    public final boolean g(int r5) {
        if ((this.f14017k & (1 << r5)) == 0) goto L5;
        return true;
    L5:
        Log.e("ViewDragHelper", "Ignoring pointerId=" + r5 + " because ACTION_DOWN was not received for this pointer before ACTION_MOVE. It likely happened because  ViewDragHelper did not receive all the events in the event stream.");
        return false;
    }

    public final void h() {
        VelocityTracker r5 = this.f14018l;
        float r10 = this.f14019m;
        r5.computeCurrentVelocity(1000, r10);
        float r11 = this.f14018l.getXVelocity(this.f14013c);
        float r12 = this.f14020n;
        float r13 = Math.abs(r11);
        float r14 = 0.0f;
        if (r13 >= r12) goto L6;
        r11 = 0.0f;
    L11:
        float r15 = this.f14018l.getYVelocity(this.f14013c);
        float r16 = Math.abs(r15);
        if (r16 >= r12) goto L15;
    L22:
        this.s = true;
        this.f14023q.q(this.f14024r, r11, r14);
        this.s = false;
        if (this.f14011a != 1) goto L26;
        k(0);
        return;
    L26:
        return;
    L15:
        if (r16 > r10) goto L17;
        r14 = r15;
        goto L22
    L17:
        if (r15 > 0.0f) goto L20;
        r10 = -r10;
    L20:
        r14 = r10;
        goto L22
    L6:
        if (r13 <= r10) goto L11;
        if (r11 <= 0.0f) goto L10;
        r11 = r10;
        goto L11
    L10:
        r11 = -r10;
        goto L11
    }

    public final void i(float r11, float r12, int r13) {
        float[] r5 = this.d;
        int r10 = 0;
        if (r5 != null) goto L5;
    L6:
        int r14 = r13 + 1;
        float[] r15 = new float[r14];
        float[] r16 = new float[r14];
        float[] r17 = new float[r14];
        float[] r18 = new float[r14];
        int[] r19 = new int[r14];
        int[] r20 = new int[r14];
        int[] r21 = new int[r14];
        if (r5 == null) goto L9;
        System.arraycopy(r5, 0, r15, 0, r5.length);
        float[] r22 = this.e;
        System.arraycopy(r22, 0, r16, 0, r22.length);
        float[] r23 = this.f;
        System.arraycopy(r23, 0, r17, 0, r23.length);
        float[] r24 = this.g;
        System.arraycopy(r24, 0, r18, 0, r24.length);
        int[] r25 = this.f14014h;
        System.arraycopy(r25, 0, r19, 0, r25.length);
        int[] r26 = this.f14015i;
        System.arraycopy(r26, 0, r20, 0, r26.length);
        int[] r27 = this.f14016j;
        System.arraycopy(r27, 0, r21, 0, r27.length);
    L9:
        this.d = r15;
        this.e = r16;
        this.f = r17;
        this.g = r18;
        this.f14014h = r19;
        this.f14015i = r20;
        this.f14016j = r21;
    L10:
        float[] r28 = this.d;
        this.f[r13] = r11;
        r28[r13] = r11;
        float[] r29 = this.e;
        this.g[r13] = r12;
        r29[r13] = r12;
        int[] r30 = this.f14014h;
        int r110 = (int) r11;
        int r111 = (int) r12;
        CoordinatorLayout r31 = this.f14025t;
        int r32 = r31.getLeft();
        int r33 = this.f14021o;
        if (r110 >= (r32 + r33)) goto L14;
        r10 = 1;
    L14:
        if (r111 >= (r31.getTop() + r33)) goto L17;
        r10 = r10 | 4;
    L17:
        if (r110 <= (r31.getRight() - r33)) goto L20;
        r10 = r10 | 2;
    L20:
        if (r111 <= (r31.getBottom() - r33)) goto L22;
        r10 = r10 | 8;
    L22:
        r30[r13] = r10;
        this.f14017k |= 1 << r13;
        return;
    L5:
        if (r5.length > r13) goto L10;
        goto L6
    }

    public final void j(MotionEvent r10) {
        int r5 = r10.getPointerCount();
        int r11 = 0;
    L3:
        if (r11 >= r5) goto L9;
        int r12 = r10.getPointerId(r11);
        if (g(r12) == false) goto L8;
        float r13 = r10.getX(r11);
        float r14 = r10.getY(r11);
        this.f[r12] = r13;
        this.g[r12] = r14;
    L8:
        r11 = r11 + 1;
        goto L3
    }

    public final void k(int r5) {
        com.lynx.tasm.ui.image.h r10 = this.f14027v;
        this.f14025t.removeCallbacks(r10);
        if (this.f14011a == r5) goto L14;
        this.f14011a = r5;
        b r11 = this.f14023q;
        if (r5 != 1) goto L9;
        BottomSheetBehavior r12 = r11.f;
        if (r12.f13960l == false) goto L11;
        r12.setStateInternal(1);
    L11:
        if (this.f14011a != 0) goto L15;
        this.f14024r = null;
        return;
    L15:
        return;
    L9:
        r11.getClass();
        goto L11
    }

    public final boolean l(View r10, int r11) {
        if (r10 == this.f14024r) goto L5;
    L7:
        if (r10 == null) goto L31;
        BottomSheetBehavior r5 = this.f14023q.f;
        int r12 = r5.f13962n;
        boolean r13 = false;
        if (r12 != 1) goto L12;
    L28:
        if (r13 == false) goto L33;
        this.f14013c = r11;
        b(r10, r11);
        return true;
    L33:
        return false;
    L12:
        if (r5.A == true) goto L28;
        if (r12 == 3) goto L17;
    L23:
        WeakReference r14 = r5.f13968u;
        if (r14 == null) goto L28;
        if (r14.get() != r10) goto L28;
        r13 = true;
        goto L28
    L17:
        if (r5.f13972y != r11) goto L23;
        View r15 = (View) r5.f13969v.get();
        if (r15 == null) goto L23;
        if (r15.canScrollVertically(-1) == false) goto L23;
    L31:
        return false;
    L5:
        if (this.f14013c != r11) goto L7;
        return true;
    }
}
