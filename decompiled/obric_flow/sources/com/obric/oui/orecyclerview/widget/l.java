package com.obric.oui.orecyclerview.widget;

import android.R;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import androidx.core.view.ViewCompat;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public final class l extends h0 {
    public static final int[] C = null;
    public static final int[] D = null;
    public int A;
    public final w B;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f13846a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f13847b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final StateListDrawable f13848c;
    public final Drawable d;
    public final int e;
    public final int f;
    public final StateListDrawable g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Drawable f13849h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f13850i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f13851j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f13852k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f13853l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f13854m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f13855n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f13856o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f13857p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f13858q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f13859r;
    public final RecyclerView s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f13860t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f13861u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f13862v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f13863w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final int[] f13864x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final int[] f13865y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final ValueAnimator f13866z;

    static {
        C = new int[]{R.attr.state_pressed};
        D = new int[0];
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public l(RecyclerView r10, StateListDrawable r11, Drawable r12, StateListDrawable r13, Drawable r14, int r15, int r16, int r17) {
        boolean r5 = true;
        this.f13858q = 0;
        this.f13859r = 0;
        this.f13860t = false;
        this.f13861u = false;
        this.f13862v = 0;
        this.f13863w = 0;
        this.f13864x = new int[2];
        this.f13865y = new int[2];
        ValueAnimator r18 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.f13866z = r18;
        this.A = 0;
        w r19 = new w(this, 2);
        this.B = r19;
        as.b r20 = new as.b(this, 1 == true ? 1 : 0);
        this.f13848c = r11;
        this.d = r12;
        this.g = r13;
        this.f13849h = r14;
        this.e = Math.max(r15, r11.getIntrinsicWidth());
        this.f = Math.max(r15, r12.getIntrinsicWidth());
        this.f13850i = Math.max(r15, r13.getIntrinsicWidth());
        this.f13851j = Math.max(r15, r14.getIntrinsicWidth());
        this.f13846a = r16;
        this.f13847b = r17;
        r11.setAlpha(255);
        r12.setAlpha(255);
        r18.addListener(new j(this, 0));
        r18.addUpdateListener(new k(this));
        RecyclerView r21 = this.s;
        if (r21 == r10) goto L28;
        if (r21 == null) goto L23;
        k0 r110 = r21.f13743m;
        if (r110 == null) goto L9;
        r110.b("Cannot remove item decoration during a scroll  or layout");
    L9:
        ArrayList r111 = r21.f13747o;
        r111.remove(this);
        if (r111.isEmpty() == true) goto L12;
    L16:
        r21.I();
        r21.requestLayout();
        RecyclerView r22 = this.s;
        r22.f13749p.remove(this);
        if (r22.f13751q != this) goto L19;
        r22.f13751q = null;
    L19:
        ArrayList r23 = this.s.f13732d0;
        if (r23 == null) goto L22;
        r23.remove(r20);
    L22:
        this.s.removeCallbacks(r19);
        goto L23
    L12:
        if (r21.getOverScrollMode() == 2) goto L15;
        r5 = false;
    L15:
        r21.setWillNotDraw(r5);
    L23:
        this.s = r10;
        if (r10 == null) goto L27;
        r10.h(this);
        this.s.f13749p.add(this);
        this.s.i(r20);
        return;
    L27:
        return;
    }

    public static int e(float r5, float r10, int[] r11, int r12, int r13, int r14) {
        int r15 = r11[1] - r11[0];
        if (r15 != 0) goto L5;
        return 0;
    L5:
        int r16 = r12 - r14;
        int r17 = (int) (((r10 - r5) / r15) * r16);
        int r18 = r13 + r17;
        if (r18 >= r16) goto L9;
        if (r18 < 0) goto L9;
        return r17;
    L9:
        return 0;
    }

    @Override // com.obric.oui.orecyclerview.widget.h0
    public final void b(Canvas r10) {
        if (this.f13858q == this.s.getWidth()) goto L5;
    L19:
        this.f13858q = this.s.getWidth();
        this.f13859r = this.s.getHeight();
        f(0);
        return;
    L5:
        if (this.f13859r != this.s.getHeight()) goto L19;
        if (this.A != 0) goto L10;
        return;
    L10:
        if (this.f13860t == false) goto L16;
        int r5 = this.f13858q;
        int r11 = this.e;
        int r12 = r5 - r11;
        int r13 = this.f13853l;
        int r14 = this.f13852k;
        int r15 = r13 - (r14 / 2);
        StateListDrawable r16 = this.f13848c;
        r16.setBounds(0, 0, r11, r14);
        int r17 = this.f13859r;
        int r18 = this.f;
        Drawable r19 = this.d;
        r19.setBounds(0, 0, r18, r17);
        if (ViewCompat.getLayoutDirection(this.s) != 1) goto L14;
        r19.draw(r10);
        r10.translate(r11, r15);
        r10.scale(-1.0f, 1.0f);
        r16.draw(r10);
        r10.scale(-1.0f, 1.0f);
        r10.translate(-r11, -r15);
        goto L16
    L14:
        r10.translate(r12, 0.0f);
        r19.draw(r10);
        r10.translate(0.0f, r15);
        r16.draw(r10);
        r10.translate(-r12, -r15);
    L16:
        if (this.f13861u == false) goto L22;
        int r20 = this.f13859r;
        int r21 = this.f13850i;
        int r22 = r20 - r21;
        int r23 = this.f13856o;
        int r24 = this.f13855n;
        int r25 = r23 - (r24 / 2);
        StateListDrawable r26 = this.g;
        r26.setBounds(0, 0, r24, r21);
        int r27 = this.f13858q;
        int r28 = this.f13851j;
        Drawable r29 = this.f13849h;
        r29.setBounds(0, 0, r27, r28);
        r10.translate(0.0f, r22);
        r29.draw(r10);
        r10.translate(r25, 0.0f);
        r26.draw(r10);
        r10.translate(-r25, -r22);
        return;
    }

    public final boolean c(float r5, float r10) {
        if (r10 < (this.f13859r - this.f13850i)) goto L9;
        int r11 = this.f13856o;
        int r12 = this.f13855n;
        if (r5 < (r11 - (r12 / 2))) goto L9;
        if (r5 > ((r12 / 2) + r11)) goto L9;
        return true;
    L9:
        return false;
    }

    public final boolean d(float r5, float r10) {
        if (ViewCompat.getLayoutDirection(this.s) != 1) goto L5;
        boolean r11 = true;
    L6:
        int r12 = this.e;
        if (r11 == false) goto L12;
        if (r5 > r12) goto L19;
    L13:
        int r13 = this.f13853l;
        int r14 = this.f13852k / 2;
        if (r10 >= (r13 - r14)) goto L16;
        return false;
    L16:
        if (r10 <= (r14 + r13)) goto L18;
        return false;
    L18:
        return true;
    L19:
        return false;
    L12:
        if (r5 >= (this.f13858q - r12)) goto L13;
        return false;
    L5:
        r11 = false;
        goto L6
    }

    public final void f(int r5) {
        w r10 = this.B;
        StateListDrawable r11 = this.f13848c;
        if (r5 == 2) goto L5;
    L7:
        if (r5 != 0) goto L9;
        this.s.invalidate();
    L11:
        if (this.f13862v != 2) goto L15;
        if (r5 == 2) goto L15;
        r11.setState(D);
        this.s.removeCallbacks(r10);
        this.s.postDelayed(r10, 1200);
    L17:
        this.f13862v = r5;
        return;
    L15:
        if (r5 != 1) goto L17;
        this.s.removeCallbacks(r10);
        this.s.postDelayed(r10, 1500);
        goto L17
    L9:
        g();
        goto L11
    L5:
        if (this.f13862v == 2) goto L7;
        r11.setState(C);
        this.s.removeCallbacks(r10);
        goto L7
    }

    public final void g() {
        int r5 = this.A;
        ValueAnimator r10 = this.f13866z;
        if (r5 != 0) goto L5;
    L8:
        this.A = 1;
        r10.setFloatValues(new float[]{((Float) r10.getAnimatedValue()).floatValue(), 1.0f});
        r10.setDuration(500);
        r10.setStartDelay(0);
        r10.start();
        return;
    L5:
        if (r5 != 3) goto L10;
        r10.cancel();
        goto L8
    }
}
