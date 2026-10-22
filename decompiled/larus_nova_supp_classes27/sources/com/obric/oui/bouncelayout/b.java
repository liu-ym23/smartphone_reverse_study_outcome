package com.obric.oui.bouncelayout;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class b {
    public final View a;
    public final Function0<Float> b;
    public final Function0<BounceEdgeEffect[]> c;
    public final boolean d;
    public float e;
    public final int f;
    public float g;
    public float h;
    public boolean i;
    public boolean j;

    public final void a(MotionEvent r3) {
        if (r3.getActionMasked() != 1) goto L5;
    L6:
        this.e = 0.0f;
        this.i = false;
        this.j = false;
        return;
    L5:
        if (r3.getActionMasked() == 3) goto L6;
    }

    public final void c(MotionEvent r8) {
        Intrinsics.checkNotNullParameter(r8, "event");
        int r0 = r8.getActionMasked();
        boolean r2 = false;
        if (r0 != 0) goto L5;
        this.g = r8.getX();
        this.h = r8.getY();
        this.j = false;
        this.e = ((Number) this.b.invoke()).floatValue();
        if (this.d == true) goto L24;
    L47:
        this.i = r2;
        int r9 = c.a;
        if (r2 == false) goto L60;
        ViewParent r10 = this.a.getParent();
        if (r10 == null) goto L62;
        r10.requestDisallowInterceptTouchEvent(true);
        return;
    L62:
        return;
    L60:
        return;
    L24:
        if (r8.getActionMasked() != 0) goto L47;
        Object[] r11 = (Object[]) this.c.invoke();
        int r1 = r11.length;
        int r3 = 0;
    L27:
        if (r3 >= r1) goto L47;
        BounceEdgeEffect r4 = (BounceEdgeEffect) r11[r3];
        if (r4 != null) goto L31;
    L43:
        boolean r5 = false;
    L44:
        if (r5 == true) goto L45;
        r3 = r3 + 1;
        goto L27
    L45:
        r2 = true;
        goto L47
    L31:
        if (r4.getDistance() != 0.0f) goto L33;
        boolean r6 = true;
    L34:
        if (r6 == true) goto L36;
    L42:
        r5 = true;
        goto L44
    L36:
        if (r4.f != 0.0f) goto L38;
        boolean r7 = true;
    L39:
        if (r7 == false) goto L42;
        if (r4.isFinished() == true) goto L43;
    L38:
        r7 = false;
        goto L39
    L33:
        r6 = false;
        goto L34
    L5:
        if (r0 == 2) goto L8;
        return;
    L8:
        if (this.i == true) goto L10;
        return;
    L10:
        if (this.j == true) goto L57;
        float r12 = r8.getX() - this.g;
        float r13 = r8.getY() - this.h;
        float r14 = (r12 * r12) + (r13 * r13);
        int r15 = this.f;
        if (r14 <= (r15 * r15)) goto L14;
        boolean r16 = true;
    L15:
        if (r16 == false) goto L58;
        this.j = true;
        ViewParent r17 = this.a.getParent();
        if (r17 == null) goto L20;
        r17.requestDisallowInterceptTouchEvent(false);
    L20:
        int r18 = c.a;
        return;
    L58:
        return;
    L14:
        r16 = false;
        goto L15
    }

    public final boolean d(MotionEvent r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        if (this.i == true) goto L5;
    L7:
        boolean r3 = false;
    L8:
        int r0 = c.a;
        return r3;
    L5:
        if (this.j == true) goto L7;
        r3 = true;
        goto L8
    }

    public b(View r2, Function0<Float> r3, Function0<BounceEdgeEffect[]> r4) {
        Intrinsics.checkNotNullParameter(r2, "target");
        Intrinsics.checkNotNullParameter(r3, "translationProvider");
        Intrinsics.checkNotNullParameter(r4, "effectsProvider");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = true;
        this.f = ViewConfiguration.get(r2.getContext()).getScaledTouchSlop();
    }

    public final Boolean b(MotionEvent r5, float r6, float r7, Function0<Boolean> r8) {
        Intrinsics.checkNotNullParameter(r5, "event");
        Intrinsics.checkNotNullParameter(r8, "dispatch");
        if (this.i == true) goto L6;
        a(r5);
        return null;
    L6:
        int r0 = c.a;
        boolean r1 = false;
        if (r6 != 0.0f) goto L9;
        boolean r3 = true;
    L10:
        if (r3 == true) goto L12;
    L18:
        r5.offsetLocation(r6, r7);
        boolean r9 = ((Boolean) r8.invoke()).booleanValue();
        r5.offsetLocation(-r6, -r7);
        a(r5);
        return Boolean.valueOf(r9);
    L12:
        if (r7 != 0.0f) goto L14;
        r1 = true;
    L14:
        if (r1 == false) goto L18;
        boolean r10 = ((Boolean) r8.invoke()).booleanValue();
        a(r5);
        return Boolean.valueOf(r10);
    L9:
        r3 = false;
        goto L10
    }
}
