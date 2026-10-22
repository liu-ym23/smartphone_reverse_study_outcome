package com.larus.bmhome.chat.component.bottom.core.follow;

import android.animation.ValueAnimator;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.bmhome.chat.component.bottom.core.g9;
import com.zhpan.bannerview.indicator.DrawableIndicator;
import java.util.WeakHashMap;
import jd8.g;
import jd8.l;
import jd8.q;
import jd8.s;
import jd8.u;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import v19.c;
import va8.o;
import ze8.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class a implements b {
    public static final WeakHashMap<View, a> o = null;
    public final o a;
    public final ICoreInputAbility b;
    public final g c;
    public final l d;
    public final boolean e;
    public final View f;
    public final View g;
    public boolean h;
    public final g9.c i;
    public Boolean j;
    public Drawable k;
    public Drawable l;
    public boolean m;
    public final q n;

    /* JADX INFO: renamed from: com.larus.bmhome.chat.component.bottom.core.follow.a$a, reason: collision with other inner class name */
    public static final class C0045a {
    }

    static {
        o = new WeakHashMap();
    }

    @Override // ze8.b
    public final boolean b() {
        if (this.h == true) goto L19;
        l r0 = this.d;
        if (r0.n == false) goto L7;
    L6:
        boolean r1 = false;
    L16:
        if (r1 == false) goto L20;
        return true;
    L20:
        return false;
    L7:
        int r2 = r0.l + 1;
        if (r2 >= 0) goto L10;
    L12:
        boolean r4 = false;
    L13:
        if (r4 == false) goto L6;
        r0.f.setCurrentItem(r2, true);
        r1 = true;
        goto L16
    L10:
        if (r2 >= r0.a.getPageCount()) goto L12;
        r4 = true;
        goto L13
    L19:
        return false;
    }

    @Override // ze8.b
    public final boolean c() {
        if (this.h == false) goto L5;
    L10:
        return true;
    L5:
        if (this.c.e == true) goto L10;
        if (this.d.d() == true) goto L10;
        return false;
    }

    @Override // ze8.b
    public final void d() {
        if (this.h == true) goto L6;
        l r0 = this.d;
        r0.b.a(r0.a.c(r0.l));
        return;
    }

    @Override // ze8.b
    public final void dismiss() {
        if (this.h == false) goto L5;
        return;
    L5:
        this.h = true;
        this.f.removeOnAttachStateChangeListener(this.n);
        WeakHashMap<View, a> r1 = o;
        if (r1.get(this.f) != this) goto L8;
        r1.remove(this.f);
    L8:
        l r2 = this.d;
        r2.C = true;
        boolean r0 = false;
        r2.n = false;
        o r3 = this.a;
        if (r3 == null) goto L11;
        r3.F40(r2.getId());
    L11:
        View r4 = this.g;
        if (r4 == null) goto L16;
        o r5 = this.a;
        if (r5 == null) goto L16;
        r5.SA(r4.getId());
    L16:
        g r6 = this.c;
        r6.x = null;
        r6.l();
        r6.o();
        s r7 = r6.I;
        if (r7 == null) goto L19;
        r7.a();
    L19:
        Integer r8 = r6.o;
        if (r8 == null) goto L24;
        int r9 = r8.intValue();
        View r10 = r6.f;
        if (r10 == null) goto L24;
        r10.setVisibility(r9);
    L24:
        r6.o = null;
        Integer r11 = r6.m;
        if (r11 == null) goto L29;
        int r12 = r11.intValue();
        View r13 = r6.n;
        if (r13 == null) goto L29;
        r13.setVisibility(r12);
    L29:
        r6.m = null;
        r6.n = null;
        if (r6.q == false) goto L33;
        r6.q = false;
        r6.b.setBackground(r6.p);
        r6.p = null;
    L33:
        jd8.a r14 = r6.g;
        if (r14 == null) goto L41;
        ViewParent r15 = r14.getParent();
        if ((r15 instanceof ViewGroup) == false) goto L38;
        ViewGroup r16 = (ViewGroup) r15;
    L39:
        if (r16 == null) goto L41;
        r16.removeView(r14);
        goto L41
    L38:
        r16 = null;
    L41:
        jd8.a r17 = r6.h;
        if (r17 == null) goto L49;
        ViewParent r18 = r17.getParent();
        if ((r18 instanceof ViewGroup) == false) goto L46;
        ViewGroup r19 = (ViewGroup) r18;
    L47:
        if (r19 == null) goto L49;
        r19.removeView(r17);
        goto L49
    L46:
        r19 = null;
    L49:
        r6.g = null;
        r6.h = null;
        r6.m();
        ValueAnimator r20 = r6.M;
        if (r20 == null) goto L52;
        r6.M = null;
        r20.removeAllListeners();
        r20.cancel();
    L52:
        u r21 = r6.G;
        if (r21 == null) goto L61;
        ValueAnimator r22 = r21.d;
        if (r22 == null) goto L57;
        r21.d = null;
        r22.cancel();
    L57:
        r21.c = 255;
        if (r21.b == false) goto L60;
        r21.b = false;
    L60:
        r21.invalidateSelf();
    L61:
        s r23 = r6.I;
        if (r23 == null) goto L64;
        r23.e();
    L64:
        r6.I = null;
        r6.j = null;
        r6.k = null;
        r6.i = null;
        r6.s.clear();
        r6.t.clear();
        r6.u.clear();
        if (this.e == true) goto L67;
        return;
    L67:
        if (this.m == false) goto L77;
        View r24 = this.f;
        Intrinsics.checkNotNullParameter(new g9.b(r24), "finder");
        if (r24 == null) goto L71;
        View r25 = r24.findViewById(2131375335);
    L72:
        if (r25 == null) goto L74;
        r25.setBackground(this.k);
    L74:
        View r26 = this.f.findViewById(2131392769);
        if (r26 == null) goto L83;
        r26.setBackground(this.l);
    L83:
        this.k = null;
        this.l = null;
        this.m = false;
        o r27 = this.a;
        if (r27 == null) goto L89;
        Boolean r28 = this.j;
        if (r28 == null) goto L88;
        r0 = r28.booleanValue();
    L88:
        r27.e10(r0);
    L89:
        this.j = null;
        return;
    L71:
        r25 = null;
        goto L72
    L77:
        ICoreInputAbility r29 = this.b;
        if (r29 == null) goto L80;
        r29.zi();
        goto L83
    L80:
        o r30 = this.a;
        if (r30 == null) goto L83;
        r30.p9(c.b(2130970689, this.d.getContext(), 2131239150));
        goto L83
    }

    @Override // ze8.b
    public final boolean f() {
        return this.d.d();
    }

    @Override // ze8.b
    public final boolean a(int r11) {
        if (this.h == true) goto L15;
        l r0 = this.d;
        if (r0.d() == false) goto L8;
        boolean r12 = false;
    L12:
        if (r12 == false) goto L16;
        return true;
    L16:
        return false;
    L8:
        if (r0.m == r11) goto L11;
        r0.m = r11;
        ArraysKt.fill$default(r0.i, -1, 0, 0, 6, null);
        r0.b(r0.i(r0.l));
        r0.requestLayout();
        r0.invalidate();
    L11:
        r12 = true;
        goto L12
    L15:
        return false;
    }

    @Override // ze8.b
    public final void e(int r3) {
        if (this.h == true) goto L10;
        l r0 = this.d;
        if (r3 == r0.l) goto L7;
        return;
    L7:
        if (r0.n == true) goto L12;
        r0.b.a(r0.a.c(r3));
        return;
    L12:
        return;
    }

    @Override // ze8.b
    public final boolean g(int r5) {
        if (this.h == true) goto L22;
        l r0 = this.d;
        if (r0.n == true) goto L13;
        if (r5 >= 0) goto L9;
    L11:
        boolean r2 = false;
    L12:
        if (r2 == false) goto L13;
        if (r5 == r0.l) goto L18;
        r0.f.setCurrentItem(r5, false);
    L18:
        boolean r6 = true;
    L19:
        if (r6 == false) goto L23;
        return true;
    L23:
        return false;
    L9:
        if (r5 >= r0.a.getPageCount()) goto L11;
        r2 = true;
    L13:
        r6 = false;
        goto L19
    L22:
        return false;
    }

    @Override // ze8.b
    public final void h(int r4) {
        if (this.h == true) goto L18;
        l r0 = this.d;
        if (r4 >= 0) goto L7;
    L9:
        boolean r1 = false;
    L10:
        if (r1 == true) goto L12;
        r0.getClass();
        return;
    L12:
        r0.i[r4] = -1;
        r0.g.notifyItemChanged(r4);
        if (r4 == r0.l) goto L15;
        return;
    L15:
        if (r0.n == true) goto L21;
        r0.b(r0.i(r4));
        return;
    L21:
        return;
    L7:
        if (r4 >= r0.a.getPageCount()) goto L9;
        r1 = true;
        goto L10
    }

    public a(o r1, ICoreInputAbility r2, g r3, l r4, boolean r5, View r6, DrawableIndicator r7) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.i = new g9.c(new g9.b(r6));
        q r8 = new q(this);
        this.n = r8;
        r6.addOnAttachStateChangeListener(r8);
    }
}
