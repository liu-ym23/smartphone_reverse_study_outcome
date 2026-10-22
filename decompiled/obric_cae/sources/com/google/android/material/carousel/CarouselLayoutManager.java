package com.google.android.material.carousel;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.recyclerview.widget.RecyclerView;
import com.obric.cae.R;
import j0.h0;
import j0.w;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.WeakHashMap;
import m9.d;
import m9.e;
import m9.f;
import m9.g;
import m9.h;
import m9.i;

/* JADX INFO: loaded from: classes.dex */
public class CarouselLayoutManager extends RecyclerView.o implements m9.b, RecyclerView.y.b {
    public int A;
    public int B;
    public int C;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f4501p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f4502q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f4503r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final b f4504s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public android.support.v4.media.a f4505t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public com.google.android.material.carousel.c f4506u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public com.google.android.material.carousel.b f4507v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f4508w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public HashMap f4509x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public g f4510y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final View.OnLayoutChangeListener f4511z;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f4512a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final float f4513b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final float f4514c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final c f4515d;

        public a(View r8, float r10, float r11, c r12) {
            this.f4512a = r8;
            this.f4513b = r10;
            this.f4514c = r11;
            this.f4515d = r12;
        }
    }

    public static class b extends RecyclerView.n {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Paint f4516a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public List<com.google.android.material.carousel.b.C0049b> f4517b;

        public b() {
            Paint r8 = new Paint();
            this.f4516a = r8;
            this.f4517b = Collections.unmodifiableList(new ArrayList());
            r8.setStrokeWidth(5.0f);
            r8.setColor(-65281);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.n
        public final void e(Canvas r8, RecyclerView r10) {
            Paint r11 = this.f4516a;
            r11.setStrokeWidth(r10.getResources().getDimension(R.dimen.m3_carousel_debug_keyline_width));
            Iterator<com.google.android.material.carousel.b.C0049b> r12 = this.f4517b.iterator();
        L4:
            if (r12.hasNext() == false) goto L10;
            com.google.android.material.carousel.b.C0049b r13 = r12.next();
            r11.setColor(a0.a.b(r13.f4535c, -65281, -16776961));
            boolean r14 = ((CarouselLayoutManager) r10.getLayoutManager()).M0();
            float r15 = r13.f4534b;
            if (r14 == false) goto L8;
            float r16 = ((CarouselLayoutManager) r10.getLayoutManager()).f4510y.i();
            float r17 = r15;
            float r18 = ((CarouselLayoutManager) r10.getLayoutManager()).f4510y.d();
            float r19 = r16;
            float r20 = r17;
        L9:
            r8.drawLine(r20, r19, r17, r18, r11);
            goto L4
        L8:
            r20 = ((CarouselLayoutManager) r10.getLayoutManager()).f4510y.f();
            r18 = r15;
            r17 = ((CarouselLayoutManager) r10.getLayoutManager()).f4510y.g();
            r19 = r18;
            goto L9
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.google.android.material.carousel.b.C0049b f4518a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final com.google.android.material.carousel.b.C0049b f4519b;

        public c(com.google.android.material.carousel.b.C0049b r8, com.google.android.material.carousel.b.C0049b r10) {
            if (r8.f4533a > r10.f4533a) goto L5;
            boolean r11 = true;
        L6:
            if (r11 == false) goto L10;
            this.f4518a = r8;
            this.f4519b = r10;
            return;
        L10:
            throw new IllegalArgumentException();
        L5:
            r11 = false;
            goto L6
        }
    }

    public CarouselLayoutManager() {
        i r8 = new i();
        this.f4504s = new b();
        this.f4508w = 0;
        this.f4511z = new m9.c(this);
        this.B = -1;
        this.C = 0;
        this.f4505t = r8;
        T0();
        V0(0);
    }

    public static float I0(float r8, c r10) {
        com.google.android.material.carousel.b.C0049b r11 = r10.f4518a;
        float r12 = r11.f4536d;
        com.google.android.material.carousel.b.C0049b r13 = r10.f4519b;
        return h9.a.a(r12, r13.f4536d, r11.f4534b, r13.f4534b, r8);
    }

    public static c L0(float r13, List r14, boolean r15) {
        float r8 = Float.MAX_VALUE;
        int r10 = -1;
        int r11 = -1;
        int r12 = -1;
        int r16 = -1;
        float r17 = -3.4028235E38f;
        int r18 = 0;
        float r19 = Float.MAX_VALUE;
        float r20 = Float.MAX_VALUE;
    L4:
        if (r18 >= r14.size()) goto L26;
        com.google.android.material.carousel.b.C0049b r110 = (com.google.android.material.carousel.b.C0049b) r14.get(r18);
        if (r15 == false) goto L8;
        float r111 = r110.f4534b;
    L9:
        float r112 = Math.abs(r111 - r13);
        if (r111 > r13) goto L15;
        if (r112 > r8) goto L15;
        r10 = r18;
        r8 = r112;
    L15:
        if (r111 <= r13) goto L20;
        if (r112 > r19) goto L20;
        r12 = r18;
        r19 = r112;
    L20:
        if (r111 > r20) goto L23;
        r11 = r18;
        r20 = r111;
    L23:
        if (r111 <= r17) goto L25;
        r16 = r18;
        r17 = r111;
    L25:
        r18 = r18 + 1;
        goto L4
    L8:
        r111 = r110.f4533a;
        goto L9
    L26:
        if (r10 != (-1)) goto L28;
        r10 = r11;
    L28:
        if (r12 != (-1)) goto L31;
        r12 = r16;
    L31:
        return new c((com.google.android.material.carousel.b.C0049b) r14.get(r10), (com.google.android.material.carousel.b.C0049b) r14.get(r12));
    }

    public final float A0(float r8, float r10) {
        if (N0() == false) goto L6;
        return r8 - r10;
    L6:
        return r8 + r10;
    }

    public final void B0(int r8, RecyclerView.v r10, RecyclerView.z r11) {
        float r12 = E0(r8);
    L4:
        if (r8 >= r11.b()) goto L13;
        a r13 = Q0(r10, r12, r8);
        float r14 = r13.f4514c;
        c r15 = r13.f4515d;
        if (O0(r14, r15) == true) goto L18;
        r12 = A0(r12, this.f4507v.f4520a);
        if (P0(r14, r15) == true) goto L12;
        z0(r13.f4512a, -1, r13);
    L12:
        r8 = r8 + 1;
        goto L4
    L18:
        return;
    }

    public final void C0(int r8, RecyclerView.v r10) {
        float r11 = E0(r8);
    L3:
        if (r8 < 0) goto L16;
        a r12 = Q0(r10, r11, r8);
        float r13 = r12.f4514c;
        c r14 = r12.f4515d;
        if (P0(r13, r14) == true) goto L21;
        float r15 = this.f4507v.f4520a;
        if (N0() == false) goto L10;
        r11 = r11 + r15;
    L12:
        if (O0(r13, r14) == true) goto L15;
        z0(r12.f4512a, 0, r12);
    L15:
        r8 = r8 - 1;
        goto L3
    L10:
        r11 = r11 - r15;
        goto L12
    L21:
        return;
    }

    public final float D0(View r8, float r10, c r11) {
        com.google.android.material.carousel.b.C0049b r12 = r11.f4518a;
        float r13 = r12.f4534b;
        com.google.android.material.carousel.b.C0049b r14 = r11.f4519b;
        float r15 = h9.a.a(r13, r14.f4534b, r12.f4533a, r14.f4533a, r10);
        if (r14 == this.f4507v.b()) goto L6;
        com.google.android.material.carousel.b.C0049b r16 = this.f4507v.d();
        if (r11.f4518a == r16) goto L6;
        return r15;
    L6:
        RecyclerView.p r17 = (RecyclerView.p) r8.getLayoutParams();
        float r18 = this.f4510y.b(r17) / this.f4507v.f4520a;
        float r19 = r10 - r14.f4533a;
        return r15 + (((1.0f - r14.f4535c) + r18) * r19);
    }

    public final float E0(int r8) {
        return A0(this.f4510y.h() - this.f4501p, this.f4507v.f4520a * r8);
    }

    public final void F0(RecyclerView.v r8, RecyclerView.z r10) {
    L3:
        if (w() <= 0) goto L12;
        View r11 = v(0);
        Rect r12 = new Rect();
        RecyclerView.getDecoratedBoundsWithMarginsInt(r11, r12);
        if (M0() == false) goto L7;
        int r13 = r12.centerX();
    L8:
        float r14 = r13;
        if (P0(r14, L0(r14, this.f4507v.f4521b, true)) == false) goto L12;
        h0(r11, r8);
        goto L3
    L7:
        r13 = r12.centerY();
    L12:
        if ((w() - 1) < 0) goto L21;
        View r15 = v(w() - 1);
        Rect r16 = new Rect();
        RecyclerView.getDecoratedBoundsWithMarginsInt(r15, r16);
        if (M0() == false) goto L16;
        int r17 = r16.centerX();
    L17:
        float r18 = r17;
        if (O0(r18, L0(r18, this.f4507v.f4521b, true)) == false) goto L21;
        h0(r15, r8);
        goto L12
    L16:
        r17 = r16.centerY();
    L21:
        if (w() != 0) goto L23;
        C0(this.f4508w - 1, r8);
        B0(this.f4508w, r8, r10);
        return;
    L23:
        int r19 = RecyclerView.o.G(v(0));
        int r20 = RecyclerView.o.G(v(w() - 1));
        C0(r19 - 1, r8);
        B0(r20 + 1, r8, r10);
    }

    public final int G0() {
        if (M0() == false) goto L7;
        return this.f2326n;
    L7:
        return this.f2327o;
    }

    public final com.google.android.material.carousel.b H0(int r8) {
        HashMap r10 = this.f4509x;
        if (r10 == null) goto L8;
        com.google.android.material.carousel.b r11 = (com.google.android.material.carousel.b) r10.get(Integer.valueOf(t2.b.p(r8, 0, Math.max(0, A() - 1))));
        if (r11 == null) goto L8;
        return r11;
    L8:
        return this.f4506u.f4539a;
    }

    public final int J0(int r8, com.google.android.material.carousel.b r10) {
        if (N0() == false) goto L7;
        float r11 = G0() - r10.c().f4533a;
        float r12 = r10.f4520a;
        return (int) ((r11 - (r8 * r12)) - (r12 / 2.0f));
    L7:
        return (int) ((r10.f4520a / 2.0f) + ((r8 * r10.f4520a) - r10.a().f4533a));
    }

    public final int K0(int r8, com.google.android.material.carousel.b r10) {
        Iterator<com.google.android.material.carousel.b.C0049b> r11 = r10.f4521b.subList(r10.f4522c, r10.f4523d + 1).iterator();
        int r12 = Integer.MAX_VALUE;
    L4:
        if (r11.hasNext() == false) goto L12;
        com.google.android.material.carousel.b.C0049b r13 = r11.next();
        float r14 = r10.f4520a;
        float r15 = (r14 / 2.0f) + (r8 * r14);
        if (N0() == false) goto L8;
        int r16 = (int) ((G0() - r13.f4533a) - r15);
    L9:
        int r17 = r16 - this.f4501p;
        if (Math.abs(r12) <= Math.abs(r17)) goto L4;
        r12 = r17;
        goto L4
    L8:
        r16 = (int) (r15 - r13.f4533a);
        goto L9
    L12:
        return r12;
    }

    public final boolean M0() {
        if (this.f4510y.f9312a != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean N0() {
        if (M0() == true) goto L5;
    L7:
        return false;
    L5:
        if (B() != 1) goto L7;
        return true;
    }

    public final boolean O0(float r8, c r10) {
        float r11 = I0(r8, r10) / 2.0f;
        if (N0() == false) goto L5;
        float r12 = r8 + r11;
    L7:
        if (N0() == false) goto L12;
        if (r12 < 0.0f) goto L13;
    L14:
        return false;
    L13:
        return true;
    L12:
        if (r12 <= G0()) goto L14;
    L5:
        r12 = r8 - r11;
        goto L7
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public final void P(RecyclerView r8) {
        T0();
        r8.addOnLayoutChangeListener(this.f4511z);
    }

    public final boolean P0(float r8, c r10) {
        float r11 = A0(r8, I0(r8, r10) / 2.0f);
        if (N0() == false) goto L8;
        if (r11 > G0()) goto L9;
    L10:
        return false;
    L9:
        return true;
    L8:
        if (r11 >= 0.0f) goto L10;
        goto L9
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public final void Q(RecyclerView r8) {
        r8.removeOnLayoutChangeListener(this.f4511z);
    }

    public final a Q0(RecyclerView.v r8, float r10, int r11) {
        View r12 = r8.d(r11);
        R0(r12);
        float r13 = A0(r10, this.f4507v.f4520a / 2.0f);
        c r14 = L0(r13, this.f4507v.f4521b, false);
        return new a(r12, r13, D0(r12, r13, r14), r14);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public final View R(View r8, int r10, RecyclerView.v r11, RecyclerView.z r12) {
        if (w() != 0) goto L5;
        return null;
    L5:
        int r13 = this.f4510y.f9312a;
        if (r10 != 1) goto L8;
    L32:
        byte r14 = -1;
    L33:
        if (r14 != (-2147483648)) goto L35;
        return null;
    L35:
        int r15 = RecyclerView.o.G(r8);
        int r16 = 0;
        if (r14 != (-1)) goto L50;
        if (r15 != 0) goto L39;
        return null;
    L39:
        int r17 = RecyclerView.o.G(v(0)) - 1;
        if (r17 < 0) goto L46;
        if (r17 >= A()) goto L46;
        a r18 = Q0(r11, E0(r17), r17);
        z0(r18.f4512a, 0, r18);
    L46:
        if (N0() == false) goto L64;
        r16 = w() - 1;
    L64:
        return v(r16);
    L50:
        if (r15 != (A() - 1)) goto L52;
        return null;
    L52:
        int r19 = RecyclerView.o.G(v(w() - 1)) + 1;
        if (r19 < 0) goto L59;
        if (r19 >= A()) goto L59;
        a r20 = Q0(r11, E0(r19), r19);
        z0(r20.f4512a, -1, r20);
    L59:
        if (N0() == true) goto L63;
        r16 = w() - 1;
    L63:
        return v(r16);
    L8:
        if (r10 != 2) goto L10;
    L31:
        r14 = 1;
        goto L33
    L10:
        if (r10 != 17) goto L12;
        if (r13 == 0) goto L28;
    L30:
        r14 = -2147483648;
        goto L33
    L28:
        if (N0() == false) goto L32;
    L12:
        if (r10 != 33) goto L14;
        if (r13 != 1) goto L30;
    L14:
        if (r10 != 66) goto L16;
        if (r13 != 0) goto L30;
        if (N0() == false) goto L31;
    L16:
        if (r10 == 130) goto L18;
        Log.d("CarouselLayoutManager", "Unknown focus request:" + r10);
        goto L30
    L18:
        if (r13 != 1) goto L30;
        goto L30
    }

    public final void R0(View r10) {
        if ((r10 instanceof h) == false) goto L18;
        RecyclerView.p r8 = (RecyclerView.p) r10.getLayoutParams();
        Rect r11 = new Rect();
        d(r10, r11);
        int r12 = (r11.left + r11.right) + 0;
        int r13 = (r11.top + r11.bottom) + 0;
        com.google.android.material.carousel.c r14 = this.f4506u;
        if (r14 != null) goto L7;
    L9:
        float r15 = ((ViewGroup.MarginLayoutParams) r8).width;
    L10:
        if (r14 != null) goto L12;
    L14:
        float r16 = ((ViewGroup.MarginLayoutParams) r8).height;
    L15:
        int r17 = RecyclerView.o.x(this.f2326n, this.f2324l, (((E() + D()) + ((ViewGroup.MarginLayoutParams) r8).leftMargin) + ((ViewGroup.MarginLayoutParams) r8).rightMargin) + r12, M0(), (int) r15);
        int r18 = this.f2327o;
        int r19 = this.f2325m;
        int r20 = F();
        r10.measure(r17, RecyclerView.o.x(r18, r19, (((C() + r20) + ((ViewGroup.MarginLayoutParams) r8).topMargin) + ((ViewGroup.MarginLayoutParams) r8).bottomMargin) + r13, f(), (int) r16));
        return;
    L12:
        if (this.f4510y.f9312a != 1) goto L14;
        r16 = r14.f4539a.f4520a;
        goto L15
    L7:
        if (this.f4510y.f9312a != 0) goto L9;
        r15 = r14.f4539a.f4520a;
        goto L10
    L18:
        throw new IllegalStateException("All children of a RecyclerView using CarouselLayoutManager must use MaskableFrameLayout as their root ViewGroup.");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public final void S(AccessibilityEvent r8) {
        super.S(r8);
        if (w() <= 0) goto L6;
        r8.setFromIndex(RecyclerView.o.G(v(0)));
        r8.setToIndex(RecyclerView.o.G(v(w() - 1)));
        return;
    }

    public final void S0(RecyclerView.v r28) {
        View r8 = r28.d(0);
        R0(r8);
        com.google.android.material.carousel.b r10 = this.f4505t.p(this, r8);
        if (N0() == false) goto L14;
        float r11 = G0();
        com.google.android.material.carousel.b.a r12 = new com.google.android.material.carousel.b.a(r10.f4520a, r11);
        float r13 = (r11 - r10.d().f4534b) - (r10.d().f4536d / 2.0f);
        List<com.google.android.material.carousel.b.C0049b> r14 = r10.f4521b;
        int r15 = r14.size() - 1;
    L5:
        if (r15 < 0) goto L13;
        com.google.android.material.carousel.b.C0049b r16 = r14.get(r15);
        float r17 = r16.f4536d;
        float r18 = (r17 / 2.0f) + r13;
        if (r15 >= r10.f4522c) goto L9;
    L11:
        boolean r19 = false;
    L12:
        r12.a(r18, r16.f4535c, r17, r19, r16.f4537e);
        r13 = r13 + r16.f4536d;
        r15 = r15 - 1;
        goto L5
    L9:
        if (r15 > r10.f4523d) goto L11;
        r19 = true;
        goto L12
    L13:
        r10 = r12.d();
    L14:
        ArrayList r110 = new ArrayList();
        r110.add(r10);
        int r20 = 0;
    L15:
        int r21 = r10.f4521b.size();
        int r111 = -1;
        List<com.google.android.material.carousel.b.C0049b> r112 = r10.f4521b;
        if (r20 >= r21) goto L21;
        if (r112.get(r20).f4537e == false) goto L22;
        r20 = r20 + 1;
    L22:
        float r23 = 0.0f;
        if ((r10.a().f4534b - (r10.a().f4536d / 2.0f)) < 0.0f) goto L34;
        com.google.android.material.carousel.b.C0049b r22 = r10.a();
        int r24 = 0;
    L26:
        if (r24 >= r112.size()) goto L31;
        com.google.android.material.carousel.b.C0049b r25 = r112.get(r24);
        if (r25.f4537e == false) goto L32;
        r24 = r24 + 1;
    L32:
        if (r22 != r25) goto L34;
        boolean r26 = true;
    L35:
        int r113 = r10.f4523d;
        int r114 = r10.f4522c;
        if (r26 == true) goto L63;
        if (r20 == (-1)) goto L63;
        int r27 = r114 - r20;
        if (M0() == false) goto L42;
        int r29 = this.f2326n;
    L43:
        float r115 = r29;
        float r30 = r10.b().f4534b - (r10.b().f4536d / 2.0f);
        if (r27 <= 0) goto L46;
    L48:
        int r210 = r114;
        int r31 = r113;
        float r116 = 0.0f;
        int r32 = 0;
    L49:
        if (r32 >= r27) goto L64;
        com.google.android.material.carousel.b r117 = (com.google.android.material.carousel.b) r110.get(r110.size() + r111);
        int r118 = r20 + r32;
        int r119 = r112.size() - 1;
        r116 = r116 + r112.get(r118).f4538f;
        int r120 = r118 + r111;
        if (r120 < 0) goto L61;
        float r33 = r112.get(r120).f4535c;
        int r121 = r117.f4523d;
    L53:
        List<com.google.android.material.carousel.b.C0049b> r34 = r117.f4521b;
        if (r121 >= r34.size()) goto L59;
        if (r33 == r34.get(r121).f4535c) goto L57;
        r121 = r121 + 1;
        goto L53
    L57:
        int r35 = -1;
    L60:
        int r122 = r121 + r35;
    L62:
        int r123 = r20;
        r110.add(com.google.android.material.carousel.c.c(r117, r123, r122, r30 + r116, (r210 - r32) - 1, (r31 - r32) - 1, r115));
        r32 = r32 + 1;
        r111 = -1;
        goto L49
    L59:
        r35 = -1;
        r121 = r34.size() - 1;
        goto L60
    L61:
        r122 = r119;
    L64:
        ArrayList r36 = new ArrayList();
        r36.add(r10);
        int r37 = r112.size() - 1;
    L65:
        if (r37 < 0) goto L70;
        if (r112.get(r37).f4537e == false) goto L71;
        r37 = r37 - 1;
    L71:
        int r38 = this.f2327o;
        if (M0() == false) goto L75;
        r38 = this.f2326n;
    L75:
        if (((r10.c().f4536d / 2.0f) + r10.c().f4534b) > r38) goto L85;
        com.google.android.material.carousel.b.C0049b r39 = r10.c();
        int r40 = r112.size();
    L77:
        r40 = r40 - 1;
        if (r40 < 0) goto L82;
        com.google.android.material.carousel.b.C0049b r41 = r112.get(r40);
        if (r41.f4537e == true) goto L77;
    L83:
        if (r39 != r41) goto L85;
        boolean r42 = true;
    L86:
        if (r42 == false) goto L88;
    L113:
        this.f4506u = new com.google.android.material.carousel.c(r10, r110, r36);
        return;
    L88:
        if (r37 == (-1)) goto L113;
        int r124 = r37 - r31;
        if (M0() == false) goto L93;
        int r43 = this.f2326n;
    L94:
        float r125 = r43;
        float r126 = r10.b().f4534b - (r10.b().f4536d / 2.0f);
        if (r124 <= 0) goto L97;
    L99:
        int r127 = 0;
    L100:
        if (r127 >= r124) goto L113;
        com.google.android.material.carousel.b r44 = (com.google.android.material.carousel.b) r36.get(r36.size() - 1);
        int r45 = r37 - r127;
        r23 = r23 + r112.get(r45).f4538f;
        int r46 = r45 + 1;
        if (r46 >= r112.size()) goto L111;
        float r47 = r112.get(r46).f4535c;
        int r48 = r44.f4522c - 1;
    L104:
        if (r48 < 0) goto L109;
        if (r47 == r44.f4521b.get(r48).f4535c) goto L110;
        r48 = r48 - 1;
    L110:
        int r49 = r48 + 1;
    L112:
        int r50 = r37;
        r36.add(com.google.android.material.carousel.c.c(r44, r50, r49, r126 - r23, (r210 + r127) + 1, (r31 + r127) + 1, r125));
        r127 = r127 + 1;
        goto L100
    L109:
        r48 = 0;
        goto L110
    L111:
        r49 = 0;
        goto L112
    L97:
        if (r10.c().f4538f <= 0.0f) goto L99;
        r36.add(com.google.android.material.carousel.c.c(r10, 0, 0, r126 - r10.c().f4538f, r10.f4522c, r10.f4523d, r125));
        goto L113
    L93:
        r43 = this.f2327o;
        goto L94
    L82:
        r41 = null;
    L85:
        r42 = false;
        goto L86
    L70:
        r37 = -1;
        goto L71
    L46:
        if (r10.a().f4538f <= 0.0f) goto L48;
        r210 = r114;
        r31 = r113;
        r110.add(com.google.android.material.carousel.c.c(r10, 0, 0, r30 + r10.a().f4538f, r10.f4522c, r10.f4523d, r115));
        goto L64
    L42:
        r29 = this.f2327o;
    L63:
        r210 = r114;
        r31 = r113;
        goto L64
    L31:
        r25 = null;
    L34:
        r26 = false;
        goto L35
    L21:
        r20 = -1;
        goto L22
    }

    public final void T0() {
        this.f4506u = null;
        k0();
    }

    public final int U0(int r12, RecyclerView.v r13, RecyclerView.z r14) {
        if (w() == 0) goto L29;
        if (r12 == 0) goto L29;
        if (this.f4506u != null) goto L9;
        S0(r13);
    L9:
        int r8 = this.f4501p;
        int r10 = this.f4502q;
        int r11 = this.f4503r;
        int r15 = r8 + r12;
        if (r15 >= r10) goto L12;
        r12 = r10 - r8;
    L14:
        this.f4501p = r8 + r12;
        X0(this.f4506u);
        float r16 = this.f4507v.f4520a / 2.0f;
        float r17 = E0(RecyclerView.o.G(v(0)));
        Rect r18 = new Rect();
        if (N0() == false) goto L17;
        com.google.android.material.carousel.b.C0049b r19 = this.f4507v.c();
    L18:
        float r20 = r19.f4534b;
        float r21 = Float.MAX_VALUE;
        int r22 = 0;
    L20:
        if (r22 >= w()) goto L27;
        View r23 = v(r22);
        float r24 = A0(r17, r16);
        c r25 = L0(r24, this.f4507v.f4521b, false);
        float r110 = D0(r23, r24, r25);
        RecyclerView.getDecoratedBoundsWithMarginsInt(r23, r18);
        W0(r23, r24, r25);
        this.f4510y.l(r16, r110, r18, r23);
        float r26 = Math.abs(r20 - r110);
        if (r23 == null) goto L26;
        if (r26 >= r21) goto L26;
        this.B = RecyclerView.o.G(r23);
        r21 = r26;
    L26:
        r17 = A0(r17, this.f4507v.f4520a);
        r22 = r22 + 1;
        goto L20
    L27:
        F0(r13, r14);
        return r12;
    L17:
        r19 = this.f4507v.a();
        goto L18
    L12:
        if (r15 <= r11) goto L14;
        r12 = r11 - r8;
    L29:
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public final void V(int r8, int r10) {
        int r11 = A();
        int r12 = this.A;
        if (r11 != r12) goto L5;
        return;
    L5:
        if (this.f4506u != null) goto L8;
        return;
    L8:
        if (this.f4505t.y(this, r12) == false) goto L10;
        T0();
    L10:
        this.A = r11;
    }

    public final void V0(int r8) {
        if (r8 == 0) goto L8;
        if (r8 == 1) goto L8;
        throw new IllegalArgumentException(defpackage.a.d("invalid orientation:", r8));
    L8:
        c(null);
        g r10 = this.f4510y;
        if (r10 != null) goto L11;
    L12:
        if (r8 == 0) goto L17;
        if (r8 != 1) goto L16;
        g r11 = new e(this);
    L18:
        this.f4510y = r11;
        T0();
        return;
    L16:
        throw new IllegalArgumentException("invalid orientation");
    L17:
        r11 = new f(this);
        goto L18
    L11:
        if (r8 != r10.f9312a) goto L12;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void W0(View r10, float r11, c r12) {
        if ((r10 instanceof h) == true) goto L5;
        return;
    L5:
        com.google.android.material.carousel.b.C0049b r8 = r12.f4518a;
        float r13 = r8.f4535c;
        com.google.android.material.carousel.b.C0049b r14 = r12.f4519b;
        float r15 = h9.a.a(r13, r14.f4535c, r8.f4533a, r14.f4533a, r11);
        float r16 = r10.getHeight();
        float r17 = r10.getWidth();
        float r18 = h9.a.a(0.0f, r17 / 2.0f, 0.0f, 1.0f, r15);
        RectF r19 = this.f4510y.c(r16, r17, h9.a.a(0.0f, r16 / 2.0f, 0.0f, 1.0f, r15), r18);
        float r110 = D0(r10, r11, r12);
        RectF r111 = new RectF(r110 - (r19.width() / 2.0f), r110 - (r19.height() / 2.0f), (r19.width() / 2.0f) + r110, (r19.height() / 2.0f) + r110);
        RectF r112 = new RectF(this.f4510y.f(), this.f4510y.i(), this.f4510y.g(), this.f4510y.d());
        this.f4505t.getClass();
        this.f4510y.a(r19, r111, r112);
        this.f4510y.k(r19, r111, r112);
        ((h) r10).a();
    }

    public final void X0(com.google.android.material.carousel.c r8) {
        int r10 = this.f4503r;
        int r11 = this.f4502q;
        if (r10 <= r11) goto L5;
        com.google.android.material.carousel.b r12 = r8.a(this.f4501p, r11, r10);
    L9:
        this.f4507v = r12;
        List<com.google.android.material.carousel.b.C0049b> r13 = r12.f4521b;
        b r14 = this.f4504s;
        r14.getClass();
        r14.f4517b = Collections.unmodifiableList(r13);
        return;
    L5:
        if (N0() == false) goto L7;
        List<com.google.android.material.carousel.b> r15 = r8.f4541c;
        r12 = r15.get(r15.size() - 1);
        goto L9
    L7:
        List<com.google.android.material.carousel.b> r16 = r8.f4540b;
        r12 = r16.get(r16.size() - 1);
        goto L9
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public final void Y(int r8, int r10) {
        int r11 = A();
        int r12 = this.A;
        if (r11 != r12) goto L5;
        return;
    L5:
        if (this.f4506u != null) goto L8;
        return;
    L8:
        if (this.f4505t.y(this, r12) == false) goto L10;
        T0();
    L10:
        this.A = r11;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.y.b
    public final PointF a(int r8) {
        if (this.f4506u != null) goto L6;
        return null;
    L6:
        int r10 = J0(r8, H0(r8)) - this.f4501p;
        if (M0() == false) goto L11;
        return new PointF(r10, 0.0f);
    L11:
        return new PointF(0.0f, r10);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public final void a0(RecyclerView.v r17, RecyclerView.z r18) {
        if (r18.b() > 0) goto L5;
    L99:
        f0(r17);
        this.f4508w = 0;
        return;
    L5:
        if (G0() <= 0.0f) goto L99;
        boolean r8 = N0();
        if (this.f4506u != null) goto L10;
        boolean r10 = true;
    L11:
        if (r10 == false) goto L13;
        S0(r17);
    L13:
        com.google.android.material.carousel.c r11 = this.f4506u;
        boolean r12 = N0();
        int r13 = -1;
        if (r12 == false) goto L16;
        List<com.google.android.material.carousel.b> r14 = r11.f4541c;
        com.google.android.material.carousel.b r15 = r14.get(r14.size() - 1);
    L17:
        if (r12 == false) goto L19;
        com.google.android.material.carousel.b.C0049b r16 = r15.c();
    L20:
        RecyclerView r19 = this.f2314b;
        if (r19 == null) goto L23;
        WeakHashMap<View, h0> r110 = w.f8437a;
        int r20 = w.e.f(r19);
    L24:
        if (r12 == false) goto L26;
        int r21 = 1;
    L27:
        float r22 = r20 * r21;
        float r23 = r16.f4533a;
        float r24 = r15.f4520a / 2.0f;
        if (N0() == false) goto L30;
        float r25 = r23 + r24;
    L31:
        int r26 = (int) ((r22 + this.f4510y.h()) - r25);
        com.google.android.material.carousel.c r27 = this.f4506u;
        boolean r28 = N0();
        if (r28 == false) goto L34;
        List<com.google.android.material.carousel.b> r29 = r27.f4540b;
        com.google.android.material.carousel.b r30 = r29.get(r29.size() - 1);
    L35:
        if (r28 == false) goto L37;
        com.google.android.material.carousel.b.C0049b r31 = r30.a();
    L38:
        float r111 = (r18.b() - 1) * r30.f4520a;
        RecyclerView r32 = this.f2314b;
        if (r32 == null) goto L41;
        WeakHashMap<View, h0> r112 = w.f8437a;
        int r33 = w.e.e(r32);
    L42:
        float r113 = r111 + r33;
        if (r28 == false) goto L45;
        float r34 = -1.0f;
    L46:
        int r35 = (int) (((r113 * r34) - (r31.f4533a - this.f4510y.h())) + (this.f4510y.e() - r31.f4533a));
        if (r28 == false) goto L49;
        int r36 = Math.min(0, r35);
    L50:
        if (r8 == false) goto L52;
        int r37 = r36;
    L53:
        this.f4502q = r37;
        if (r8 == false) goto L56;
        r36 = r26;
    L56:
        this.f4503r = r36;
        if (r10 == false) goto L91;
        this.f4501p = r26;
        com.google.android.material.carousel.c r38 = this.f4506u;
        int r39 = A();
        int r40 = this.f4502q;
        int r41 = this.f4503r;
        boolean r42 = N0();
        float r43 = r38.f4539a.f4520a;
        HashMap r114 = new HashMap();
        int r115 = 0;
        int r116 = 0;
    L59:
        if (r115 >= r39) goto L73;
        if (r42 == false) goto L62;
        int r117 = (r39 - r115) - 1;
    L63:
        float r118 = r117 * r43;
        if (r42 == false) goto L66;
        int r119 = r13;
    L67:
        float r120 = r118 * r119;
        float r121 = r41 - r38.f4545g;
        List<com.google.android.material.carousel.b> r122 = r38.f4541c;
        if (r120 <= r121) goto L70;
    L71:
        r114.put(Integer.valueOf(r117), r122.get(t2.b.p(r116, 0, r122.size() - 1)));
        r116 = r116 + 1;
    L72:
        r115 = r115 + 1;
        r13 = -1;
        goto L59
    L70:
        if (r115 < (r39 - r122.size())) goto L72;
    L66:
        r119 = 1;
        goto L67
    L62:
        r117 = r115;
        goto L63
    L73:
        int r44 = r39 - 1;
        int r45 = 0;
    L74:
        if (r44 < 0) goto L88;
        if (r42 == false) goto L77;
        int r123 = (r39 - r44) - 1;
    L78:
        float r124 = r123 * r43;
        if (r42 == false) goto L81;
        int r125 = -1;
    L82:
        float r126 = r124 * r125;
        float r127 = r40 + r38.f4544f;
        List<com.google.android.material.carousel.b> r128 = r38.f4540b;
        if (r126 >= r127) goto L85;
    L86:
        r114.put(Integer.valueOf(r123), r128.get(t2.b.p(r45, 0, r128.size() - 1)));
        r45 = r45 + 1;
    L87:
        r44 = r44 - 1;
        goto L74
    L85:
        if (r44 >= r128.size()) goto L87;
    L81:
        r125 = 1;
        goto L82
    L77:
        r123 = r44;
        goto L78
    L88:
        this.f4509x = r114;
        int r46 = this.B;
        if (r46 == (-1)) goto L91;
        this.f4501p = J0(r46, H0(r46));
    L91:
        int r47 = this.f4501p;
        int r48 = this.f4502q;
        int r49 = this.f4503r;
        int r50 = r47 + 0;
        if (r50 >= r48) goto L94;
        int r51 = r48 - r47;
    L97:
        this.f4501p = r51 + r47;
        this.f4508w = t2.b.p(this.f4508w, 0, r18.b());
        X0(this.f4506u);
        q(r17);
        F0(r17, r18);
        this.A = A();
        return;
    L94:
        if (r50 <= r49) goto L96;
        r51 = r49 - r47;
        goto L97
    L96:
        r51 = 0;
        goto L97
    L52:
        r37 = r26;
        goto L53
    L49:
        r36 = Math.max(0, r35);
        goto L50
    L45:
        r34 = 1.0f;
        goto L46
    L41:
        r33 = 0;
        goto L42
    L37:
        r31 = r30.c();
        goto L38
    L34:
        List<com.google.android.material.carousel.b> r52 = r27.f4541c;
        r30 = r52.get(r52.size() - 1);
        goto L35
    L30:
        r25 = r23 - r24;
        goto L31
    L26:
        r21 = -1;
        goto L27
    L23:
        r20 = 0;
        goto L24
    L19:
        r16 = r15.a();
        goto L20
    L16:
        List<com.google.android.material.carousel.b> r53 = r11.f4540b;
        r15 = r53.get(r53.size() - 1);
        goto L17
    L10:
        r10 = false;
        goto L11
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public final void b0(RecyclerView.z r8) {
        if (w() != 0) goto L5;
        this.f4508w = 0;
        return;
    L5:
        this.f4508w = RecyclerView.o.G(v(0));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public final boolean e() {
        return M0();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public final boolean f() {
        return !M0();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public final boolean j0(RecyclerView r8, View r10, Rect r11, boolean r12, boolean r13) {
        if (this.f4506u != null) goto L5;
        return false;
    L5:
        int r14 = K0(RecyclerView.o.G(r10), H0(RecyclerView.o.G(r10)));
        if (r14 != 0) goto L8;
        return false;
    L8:
        int r15 = this.f4501p;
        int r16 = this.f4502q;
        int r17 = this.f4503r;
        int r18 = r15 + r14;
        if (r18 >= r16) goto L11;
        r14 = r16 - r15;
    L13:
        int r19 = K0(RecyclerView.o.G(r10), this.f4506u.a(r15 + r14, r16, r17));
        if (M0() == false) goto L16;
        r8.scrollBy(r19, 0);
        return true;
    L16:
        r8.scrollBy(0, r19);
        return true;
    L11:
        if (r18 <= r17) goto L13;
        r14 = r17 - r15;
        goto L13
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public final int k(RecyclerView.z r8) {
        if (w() != 0) goto L5;
        return 0;
    L5:
        if (this.f4506u != null) goto L7;
        return 0;
    L7:
        if (A() > 1) goto L10;
        return 0;
    L10:
        return (int) (this.f2326n * (this.f4506u.f4539a.f4520a / (this.f4503r - this.f4502q)));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public final int l(RecyclerView.z r8) {
        return this.f4501p;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public final int l0(int r8, RecyclerView.v r10, RecyclerView.z r11) {
        if (M0() == true) goto L7;
        return 0;
    L7:
        return U0(r8, r10, r11);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public final int m(RecyclerView.z r8) {
        return this.f4503r - this.f4502q;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public final void m0(int r8) {
        this.B = r8;
        if (this.f4506u != null) goto L5;
        return;
    L5:
        this.f4501p = J0(r8, H0(r8));
        this.f4508w = t2.b.p(r8, 0, Math.max(0, A() - 1));
        X0(this.f4506u);
        k0();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public final int n(RecyclerView.z r8) {
        if (w() != 0) goto L5;
        return 0;
    L5:
        if (this.f4506u != null) goto L7;
        return 0;
    L7:
        if (A() > 1) goto L10;
        return 0;
    L10:
        return (int) (this.f2327o * (this.f4506u.f4539a.f4520a / (this.f4503r - this.f4502q)));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public final int n0(int r8, RecyclerView.v r10, RecyclerView.z r11) {
        if (f() == true) goto L7;
        return 0;
    L7:
        return U0(r8, r10, r11);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public final int o(RecyclerView.z r8) {
        return this.f4501p;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public final int p(RecyclerView.z r8) {
        return this.f4503r - this.f4502q;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public final RecyclerView.p s() {
        return new RecyclerView.p(-2, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public final void w0(RecyclerView r8, int r10) {
        d r11 = new d(this, r8.getContext());
        r11.f2349a = r10;
        x0(r11);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public final void z(View r8, Rect r10) {
        RecyclerView.getDecoratedBoundsWithMarginsInt(r8, r10);
        float r11 = r10.centerY();
        if (M0() == false) goto L5;
        r11 = r10.centerX();
    L5:
        float r12 = I0(r11, L0(r11, this.f4507v.f4521b, true));
        float r13 = 0.0f;
        if (M0() == false) goto L8;
        float r14 = (r10.width() - r12) / 2.0f;
    L10:
        if (M0() == true) goto L13;
        r13 = (r10.height() - r12) / 2.0f;
    L13:
        r10.set((int) (r10.left + r14), (int) (r10.top + r13), (int) (r10.right - r14), (int) (r10.bottom - r13));
        return;
    L8:
        r14 = 0.0f;
        goto L10
    }

    public final void z0(View r8, int r10, a r11) {
        float r12 = this.f4507v.f4520a / 2.0f;
        b(r8, r10, false);
        float r13 = r11.f4514c;
        int r14 = (int) (r13 - r12);
        int r15 = (int) (r13 + r12);
        this.f4510y.j(r8, r14, r15);
        W0(r8, r11.f4513b, r11.f4515d);
    }

    @SuppressLint({"UnknownNullness"})
    public CarouselLayoutManager(Context r8, AttributeSet r10, int r11, int r12) {
        this.f4504s = new b();
        this.f4508w = 0;
        this.f4511z = new m9.c(this);
        this.B = -1;
        this.C = 0;
        this.f4505t = new i();
        T0();
        if (r10 == null) goto L6;
        TypedArray r13 = r8.obtainStyledAttributes(r10, g9.a.f7762c);
        this.C = r13.getInt(0, 0);
        T0();
        V0(r13.getInt(0, 0));
        r13.recycle();
        return;
    }
}
