package com.google.android.material.behavior;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.obric.cae.network.BlockedReason;
import j0.h0;
import j0.w;
import java.util.WeakHashMap;
import k0.f;
import o0.c;

/* JADX INFO: loaded from: classes.dex */
public class SwipeDismissBehavior<V extends View> extends CoordinatorLayout.c<V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c f4352a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f4353b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f4354c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f4355d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f4356e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f4357f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f4358g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final a f4359h;

    public class a extends c.AbstractC0128c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f4360a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f4361b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ SwipeDismissBehavior f4362c;

        public a(SwipeDismissBehavior r8) {
            this.f4362c = r8;
            this.f4361b = -1;
        }

        @Override // o0.c.AbstractC0128c
        public final int a(View r8, int r10) {
            WeakHashMap<View, h0> r11 = w.f8437a;
            if (w.e.d(r8) != 1) goto L5;
            boolean r12 = true;
        L6:
            int r13 = this.f4362c.f4355d;
            if (r13 != 0) goto L10;
            if (r12 == true) goto L13;
        L12:
            int r14 = this.f4360a;
            int r15 = r8.getWidth() + r14;
        L16:
            return Math.min(Math.max(r14, r10), r15);
        L13:
            int r16 = this.f4360a - r8.getWidth();
            r15 = this.f4360a;
            r14 = r16;
            goto L16
        L10:
            if (r13 != 1) goto L14;
            if (r12 == false) goto L13;
        L14:
            int r17 = this.f4360a - r8.getWidth();
            r15 = r8.getWidth() + this.f4360a;
            r14 = r17;
            goto L16
        L5:
            r12 = false;
            goto L6
        }

        @Override // o0.c.AbstractC0128c
        public final int b(View r8, int r10, int r11) {
            return r8.getTop();
        }

        @Override // o0.c.AbstractC0128c
        public final int c(View r8) {
            return r8.getWidth();
        }

        @Override // o0.c.AbstractC0128c
        public final void e(View r8, int r10) {
            this.f4361b = r10;
            this.f4360a = r8.getLeft();
            ViewParent r11 = r8.getParent();
            if (r11 == null) goto L6;
            SwipeDismissBehavior r12 = this.f4362c;
            r12.f4354c = true;
            r11.requestDisallowInterceptTouchEvent(true);
            r12.f4354c = false;
            return;
        }

        @Override // o0.c.AbstractC0128c
        public final void f(int r8) {
            this.f4362c.getClass();
        }

        @Override // o0.c.AbstractC0128c
        public final void g(View r8, int r10, int r11, int r12, int r13) {
            float r14 = r8.getWidth();
            SwipeDismissBehavior r15 = this.f4362c;
            float r16 = r14 * r15.f4357f;
            float r17 = r8.getWidth() * r15.f4358g;
            float r18 = Math.abs(r10 - this.f4360a);
            if (r18 > r16) goto L6;
            r8.setAlpha(1.0f);
            return;
        L6:
            if (r18 < r17) goto L8;
            r8.setAlpha(0.0f);
            return;
        L8:
            r8.setAlpha(Math.min(Math.max(0.0f, 1.0f - ((r18 - r16) / (r17 - r16))), 1.0f));
        }

        @Override // o0.c.AbstractC0128c
        public final void h(View r10, float r11, float r12) {
            this.f4361b = -1;
            int r13 = r10.getWidth();
            boolean r8 = true;
            SwipeDismissBehavior r14 = this.f4362c;
            if (r11 == 0.0f) goto L25;
            WeakHashMap<View, h0> r15 = w.f8437a;
            if (w.e.d(r10) != 1) goto L7;
            boolean r16 = true;
        L8:
            int r17 = r14.f4355d;
            if (r17 == 2) goto L27;
            if (r17 != 0) goto L18;
            if (r16 == true) goto L14;
            if (r11 > 0.0f) goto L27;
        L28:
            boolean r18 = false;
        L29:
            if (r18 == true) goto L31;
            int r19 = this.f4360a;
            r8 = false;
        L39:
            if (r14.f4352a.q(r19, r10.getTop()) == false) goto L42;
            b r20 = new b(r14, r10, r8);
            WeakHashMap<View, h0> r110 = w.f8437a;
            w.d.m(r10, r20);
            return;
        L42:
            return;
        L31:
            if (r11 < 0.0f) goto L36;
            int r111 = r10.getLeft();
            int r21 = this.f4360a;
            if (r111 < r21) goto L36;
            r19 = r21 + r13;
        L36:
            r19 = this.f4360a - r13;
            goto L39
        L14:
            if (r11 >= 0.0f) goto L28;
        L18:
            if (r17 != 1) goto L28;
            if (r16 == false) goto L23;
            if (r11 <= 0.0f) goto L28;
        L23:
            if (r11 >= 0.0f) goto L28;
        L27:
            r18 = true;
            goto L29
        L7:
            r16 = false;
            goto L8
        L25:
            int r22 = r10.getLeft() - this.f4360a;
            if (Math.abs(r22) < Math.round(r10.getWidth() * r14.f4356e)) goto L28;
            goto L27
        }

        @Override // o0.c.AbstractC0128c
        public final boolean i(View r8, int r10) {
            int r11 = this.f4361b;
            if (r11 == (-1)) goto L6;
            if (r11 == r10) goto L6;
        L8:
            return false;
        L6:
            if (this.f4362c.y(r8) == false) goto L8;
            return true;
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f4363a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ SwipeDismissBehavior f4364b;

        public b(SwipeDismissBehavior r8, View r10, boolean r11) {
            this.f4364b = r8;
            this.f4363a = r10;
        }

        @Override // java.lang.Runnable
        public final void run() {
            c r8 = this.f4364b.f4352a;
            if (r8 != null) goto L5;
            return;
        L5:
            if (r8.g() == false) goto L9;
            WeakHashMap<View, h0> r10 = w.f8437a;
            w.d.m(this.f4363a, this);
            return;
        }
    }

    public SwipeDismissBehavior() {
        this.f4355d = 2;
        this.f4356e = 0.5f;
        this.f4357f = 0.0f;
        this.f4358g = 0.5f;
        this.f4359h = new a(this);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean g(CoordinatorLayout r8, V r10, MotionEvent r11) {
        boolean r12 = this.f4353b;
        int r13 = r11.getActionMasked();
        if (r13 == 0) goto L9;
        if (r13 != 1) goto L6;
    L8:
        this.f4353b = false;
    L10:
        if (r12 == true) goto L12;
        return false;
    L12:
        if (this.f4352a != null) goto L15;
        this.f4352a = new c(r8.getContext(), r8, this.f4359h);
    L15:
        if (this.f4354c == true) goto L20;
        if (this.f4352a.r(r11) == false) goto L20;
        return true;
    L20:
        return false;
    L6:
        if (r13 == 3) goto L8;
    L9:
        r12 = r8.l(r10, (int) r11.getX(), (int) r11.getY());
        this.f4353b = r12;
        goto L10
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public final boolean h(CoordinatorLayout r8, V r10, int r11) {
        WeakHashMap<View, h0> r12 = w.f8437a;
        if (w.d.c(r10) != 0) goto L7;
        w.d.s(r10, 1);
        w.k(r10, BlockedReason.BLOCKED_REASON_BG_DISABLED_VALUE);
        w.i(r10, 0);
        if (y(r10) == false) goto L7;
        w.l(r10, f.a.f8898j, new j9.a(this));
    L7:
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public final boolean x(CoordinatorLayout r8, V r10, MotionEvent r11) {
        if (this.f4352a != null) goto L5;
        return false;
    L5:
        if (this.f4354c == true) goto L7;
    L8:
        this.f4352a.k(r11);
        return true;
    L7:
        if (r11.getActionMasked() != 3) goto L8;
        return true;
    }

    public boolean y(View r8) {
        return true;
    }
}
