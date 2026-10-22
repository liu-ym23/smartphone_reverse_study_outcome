package com.bytedance.android.livesdk.chatroom.vs.gesture;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class b implements ko1.c {
    public final c a;
    public final d b;
    public final e c;
    public final f d;
    public boolean e;
    public final float f;
    public final float g;
    public final float h;
    public final float i;
    public final View j;
    public final ViewGroup k;

    public void d(boolean r1) {
        throw null;
    }

    @Override // ko1.c
    public final void a() {
        this.a.c = true;
        this.c.q = true;
        this.j.getViewTreeObserver().addOnPreDrawListener(new a(this));
    }

    @Override // ko1.c
    public boolean b(String r4) {
        Intrinsics.checkNotNullParameter(r4, "resetType");
        if (this.j.getScaleX() == 1.0f) goto L5;
    L7:
        this.j.setScaleX(1.0f);
        this.j.setScaleY(1.0f);
        this.j.setX(this.h);
        this.j.setY(this.i);
        this.j.setPivotX(this.f);
        this.j.setPivotY(this.g);
        c r5 = this.a;
        r5.a = 1.0f;
        r5.b = 1.0f;
        r5.f = false;
        r5.g = true;
        e r6 = this.c;
        r6.a = 1.0f;
        r6.r = 1.0f;
        r6.s = 1.0f;
        r6.b = 0.0f;
        r6.c = 0.0f;
        r6.d = 0.0f;
        r6.e = 0.0f;
        r6.f = 0.0f;
        r6.g = 0.0f;
        r6.h = false;
        r6.i = 0;
        r6.j = 0;
        r6.k = 0;
        r6.l = 0;
        r6.m = 0.0f;
        r6.n = 0.0f;
        r6.o = 0.0f;
        r6.p = 0.0f;
        d(false);
        return true;
    L5:
        if (this.j.getScaleY() != 1.0f) goto L7;
        return false;
    }

    @Override // ko1.c
    public boolean c(MotionEvent r14) {
        Intrinsics.checkNotNullParameter(r14, "event");
        if (r14.getPointerCount() != 1) goto L9;
        if (this.e == false) goto L9;
        return this.d.onTouchEvent(r14);
    L9:
        if (r14.getPointerCount() == 2) goto L15;
        if (this.e == false) goto L15;
        return false;
    L15:
        if (r14.getAction() != 1) goto L17;
        boolean r0 = true;
    L18:
        this.e = r0;
        if (r0 == false) goto L30;
        c r1 = this.a;
        if (r1.c == false) goto L30;
        if (r1.b >= r1.e) goto L30;
        r1.a = 1.0f;
        Float r5 = Float.valueOf(1.0f);
        Float r6 = Float.valueOf(r1.a);
        if (r5 == null) goto L27;
        r1.h.setScaleX(r5.floatValue());
    L27:
        if (r6 == null) goto L29;
        r1.h.setScaleY(r6.floatValue());
    L29:
        r1.b = r1.a;
    L30:
        c r2 = this.a;
        float r7 = r2.a;
        float r8 = r2.d;
        if (r7 > (r8 * 1.0f)) goto L35;
        r8 = r2.e;
        if (r7 < (r8 * 1.0f)) goto L35;
    L36:
        e r3 = this.c;
        float r9 = r3.i;
        float r10 = r9 * r7;
        r3.d = r10;
        r3.e = r3.j * r7;
        if (r10 < r3.k) goto L39;
        float r11 = r10 - r9;
        float r12 = 2;
        r3.m = (r11 / r12) - (r3.u.getWidth() - r3.t.getRight());
        float r13 = ((r3.d - r3.i) / r12) - r3.t.getLeft();
        r3.o = r13;
        float r15 = r3.r;
        if (r7 >= r15) goto L61;
        float r16 = r3.b;
        if (r16 >= 0) goto L61;
        if ((-r16) <= r3.m) goto L61;
        float r17 = (r3.f - r3.d) / r12;
        r3.a(r3.t.getTranslationX() + r17);
        r3.b += r17;
    L67:
        float r18 = r3.e;
        if (r18 >= r3.l) goto L85;
        float r4 = 2;
        r3.n = r3.t.getTop() - ((r3.e - r3.j) / r4);
        r3.p = (r3.u.getHeight() - r3.t.getBottom()) - ((r3.e - r3.j) / r4);
        if (r3.q == false) goto L72;
        r3.c = 0.0f;
        r3.b(0.0f);
    L72:
        float r19 = r3.s;
        if (r7 <= r19) goto L79;
        float r20 = r3.c;
        if (r20 >= 0) goto L79;
        if ((-r20) <= r3.n) goto L79;
        float r21 = (r3.e - r3.g) / r4;
        r3.b(r3.t.getTranslationY() + r21);
        r3.c += r21;
    L98:
        r3.f = r3.d;
        r3.g = r3.e;
        r3.a = r7;
        r3.r = r7;
        r3.s = r7;
        if (r7 <= 1.0f) goto L101;
        d(true);
    L103:
        return this.b.onTouchEvent(r14);
    L101:
        d(false);
    L79:
        if (r7 <= r19) goto L98;
        float r22 = r3.c;
        if (r22 <= 0) goto L98;
        if (r22 <= r3.p) goto L98;
        float r23 = (r3.e - r3.g) / r4;
        r3.b(r3.t.getTranslationY() - r23);
        r3.c -= r23;
        goto L98
    L85:
        float r24 = 2;
        r3.n = ((r18 - r3.j) / r24) - (r3.u.getHeight() - r3.t.getBottom());
        float r25 = ((r3.e - r3.j) / r24) - r3.t.getTop();
        r3.p = r25;
        float r26 = r3.s;
        if (r7 >= r26) goto L92;
        float r27 = r3.c;
        if (r27 >= 0) goto L92;
        if ((-r27) <= r3.n) goto L92;
        float r28 = (r3.g - r3.e) / r24;
        r3.b(r3.t.getTranslationY() + r28);
        r3.c += r28;
    L92:
        if (r7 >= r26) goto L98;
        float r29 = r3.c;
        if (r29 <= 0) goto L98;
        if (r29 <= r25) goto L98;
        float r30 = (r3.g - r3.e) / r24;
        r3.b(r3.t.getTranslationY() - r30);
        r3.c -= r30;
    L61:
        if (r7 >= r15) goto L67;
        float r31 = r3.b;
        if (r31 <= 0) goto L67;
        if (r31 <= r13) goto L67;
        float r32 = (r3.f - r3.d) / r12;
        r3.a(r3.t.getTranslationX() - r32);
        r3.b -= r32;
        goto L67
    L39:
        if (r3.q == false) goto L41;
        r3.b = 0.0f;
        r3.a(0.0f);
    L41:
        float r33 = 2;
        r3.m = r3.t.getLeft() - ((r3.d - r3.i) / r33);
        float r34 = r3.u.getWidth() - r3.t.getRight();
        float r35 = r3.d;
        float r36 = r34 - ((r35 - r3.i) / r33);
        r3.o = r36;
        float r110 = r3.r;
        if (r7 <= r110) goto L48;
        float r111 = r3.b;
        if (r111 >= 0) goto L48;
        if ((-r111) <= r3.m) goto L48;
        float r37 = (r35 - r3.f) / r33;
        r3.a(r3.t.getTranslationX() + r37);
        r3.b += r37;
    L48:
        if (r7 <= r110) goto L67;
        float r112 = r3.b;
        if (r112 <= 0) goto L67;
        if (r112 <= r36) goto L67;
        float r38 = (r35 - r3.f) / r33;
        r3.a(r3.t.getTranslationX() - r38);
        r3.b -= r38;
    L35:
        r7 = r8 * 1.0f;
        goto L36
    L17:
        r0 = false;
        goto L18
    }

    public b(Context r3, View r4, ViewGroup r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "targetView");
        Intrinsics.checkNotNullParameter(r5, "viewGroup");
        this.j = r4;
        this.k = r5;
        c r0 = new c(r4, r5);
        this.a = r0;
        this.b = new d(r3, r0);
        e r1 = new e(r4, r5);
        this.c = r1;
        this.d = new f(r3, r1);
        this.e = true;
        r4.setClickable(false);
        this.h = r4.getX();
        this.i = r4.getY();
        this.f = r4.getPivotX();
        this.g = r4.getPivotY();
    }
}
