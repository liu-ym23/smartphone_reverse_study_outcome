package com.google.android.material.internal;

import android.animation.TimeInterpolator;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.sdk.bwdl.Utils.BWDLInnerConstant;
import j0.h0;
import j0.w;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class c {
    public CharSequence A;
    public CharSequence B;
    public boolean C;
    public final boolean D;
    public Bitmap E;
    public float F;
    public float G;
    public float H;
    public float I;
    public float J;
    public int K;
    public int[] L;
    public boolean M;
    public final TextPaint N;
    public final TextPaint O;
    public TimeInterpolator P;
    public TimeInterpolator Q;
    public float R;
    public float S;
    public float T;
    public ColorStateList U;
    public float V;
    public float W;
    public float X;
    public StaticLayout Y;
    public float Z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f4825a;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public float f4826a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f4827b;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public float f4828b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Rect f4829c;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public CharSequence f4830c0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Rect f4831d;
    public final int d0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final RectF f4832e;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public final float f4833e0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f4834f;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public final int f4835f0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f4836g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f4837h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f4838i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ColorStateList f4839j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ColorStateList f4840k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f4841l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f4842m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f4843n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public float f4844o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f4845p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public float f4846q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Typeface f4847r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public Typeface f4848s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public Typeface f4849t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public Typeface f4850u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public Typeface f4851v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Typeface f4852w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public Typeface f4853x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public x9.a f4854y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final TextUtils.TruncateAt f4855z;

    public c(View r8) {
        this.f4834f = 16;
        this.f4836g = 16;
        this.f4837h = 15.0f;
        this.f4838i = 15.0f;
        this.f4855z = TextUtils.TruncateAt.END;
        this.D = true;
        this.d0 = 1;
        this.f4833e0 = 1.0f;
        this.f4835f0 = 1;
        this.f4825a = r8;
        TextPaint r10 = new TextPaint(129);
        this.N = r10;
        this.O = new TextPaint(r10);
        this.f4831d = new Rect();
        this.f4829c = new Rect();
        this.f4832e = new RectF();
        g(r8.getContext().getResources().getConfiguration());
    }

    public static int a(float r8, int r10, int r11) {
        float r12 = 1.0f - r8;
        return Color.argb(Math.round((Color.alpha(r11) * r8) + (Color.alpha(r10) * r12)), Math.round((Color.red(r11) * r8) + (Color.red(r10) * r12)), Math.round((Color.green(r11) * r8) + (Color.green(r10) * r12)), Math.round((Color.blue(r11) * r8) + (Color.blue(r10) * r12)));
    }

    public static float f(float r8, float r10, float r11, TimeInterpolator r12) {
        if (r12 == null) goto L4;
        r11 = r12.getInterpolation(r11);
    L4:
        LinearInterpolator r13 = h9.a.f7943a;
        return defpackage.a.a(r10, r8, r11, r8);
    }

    public final boolean b(CharSequence r8) {
        WeakHashMap<View, h0> r10 = w.f8437a;
        boolean r11 = true;
        if (w.e.d(this.f4825a) == 1) goto L7;
        r11 = false;
    L7:
        if (this.D == false) goto L13;
        if (r11 == false) goto L10;
        h0.e.d r12 = h0.e.f7887d;
    L12:
        return r12.b(r8, r8.length());
    L10:
        r12 = h0.e.f7886c;
        goto L12
    L13:
        return r11;
    }

    public final void c(float r13, boolean r14) {
        if (this.A != null) goto L5;
        return;
    L5:
        float r8 = this.f4831d.width();
        float r10 = this.f4829c.width();
        if (Math.abs(r13 - 1.0f) >= 1.0E-5f) goto L8;
        boolean r11 = true;
    L10:
        if (r11 == false) goto L12;
        float r15 = this.f4838i;
        float r16 = this.V;
        this.F = 1.0f;
        Typeface r12 = this.f4847r;
    L26:
        TextPaint r17 = this.N;
        if (r8 > 0.0f) goto L29;
        boolean r18 = false;
    L62:
        if (this.B == null) goto L64;
        if (r18 == true) goto L64;
        return;
    L64:
        r17.setTextSize(this.G);
        r17.setTypeface(this.f4853x);
        r17.setLetterSpacing(this.X);
        boolean r19 = b(this.A);
        this.C = r19;
        int r110 = this.d0;
        if (r110 <= 1) goto L69;
        if (r19 == true) goto L69;
        boolean r20 = true;
    L70:
        if (r20 == true) goto L91;
        r110 = 1;
    L91:
        if (r110 != 1) goto L75;
        Layout.Alignment r21 = Layout.Alignment.ALIGN_NORMAL;     // Catch: i.a -> L87
    L85:
        i r22 = new i(this.A, r17, (int) r8);     // Catch: i.a -> L87
        r22.f4878l = this.f4855z;     // Catch: i.a -> L87
        r22.f4877k = r19;     // Catch: i.a -> L87
        r22.f4871e = r21;     // Catch: i.a -> L87
        r22.f4876j = false;     // Catch: i.a -> L87
        r22.f4872f = r110;     // Catch: i.a -> L87
        float r111 = this.f4833e0;     // Catch: i.a -> L87
        r22.f4873g = 0.0f;     // Catch: i.a -> L87
        r22.f4874h = r111;     // Catch: i.a -> L87
        r22.f4875i = this.f4835f0;     // Catch: i.a -> L87
        StaticLayout r112 = r22.a();     // Catch: i.a -> L87
    L89:
        r112.getClass();
        this.Y = r112;
        this.B = r112.getText();
        return;
    L75:
        int r23 = Gravity.getAbsoluteGravity(this.f4834f, r19 ? 1 : 0) & 7;     // Catch: i.a -> L87
        if (r23 == 1) goto L84;
        boolean r24 = this.C;     // Catch: i.a -> L87
        if (r23 == 5) goto L81;
        if (r24 == true) goto L83;
    L82:
        r21 = Layout.Alignment.ALIGN_NORMAL;     // Catch: i.a -> L87
    L83:
        r21 = Layout.Alignment.ALIGN_OPPOSITE;     // Catch: i.a -> L87
        goto L85
    L81:
        if (r24 == false) goto L83;
    L84:
        r21 = Layout.Alignment.ALIGN_CENTER;     // Catch: i.a -> L87
    L87:
        e = move-exception;
        Log.e("CollapsingTextHelper", e.getCause().getMessage(), e);
        r112 = null;
    L69:
        r20 = false;
        goto L70
    L29:
        if (this.G == r15) goto L31;
        boolean r25 = true;
    L33:
        if (this.X == r16) goto L35;
        boolean r26 = true;
    L37:
        if (this.f4853x == r12) goto L39;
        boolean r27 = true;
    L40:
        StaticLayout r113 = this.Y;
        if (r113 != null) goto L43;
    L45:
        boolean r114 = false;
    L46:
        if (r25 == true) goto L54;
        if (r26 == true) goto L54;
        if (r114 == true) goto L54;
        if (r27 == true) goto L54;
        if (this.M == true) goto L54;
        boolean r28 = false;
    L55:
        this.G = r15;
        this.X = r16;
        this.f4853x = r12;
        this.M = false;
        if (this.F == 1.0f) goto L58;
        boolean r115 = true;
    L59:
        r17.setLinearText(r115);
        r18 = r28;
        goto L62
    L58:
        r115 = false;
    L54:
        r28 = true;
        goto L55
    L43:
        if (r8 == r113.getWidth()) goto L45;
        r114 = true;
        goto L46
    L39:
        r27 = false;
        goto L40
    L35:
        r26 = false;
        goto L37
    L31:
        r25 = false;
        goto L33
    L12:
        float r29 = this.f4837h;
        float r30 = this.W;
        Typeface r31 = this.f4850u;
        if (Math.abs(r13 - 0.0f) >= 1.0E-5f) goto L15;
        boolean r32 = true;
    L16:
        if (r32 == false) goto L18;
        this.F = 1.0f;
    L19:
        float r116 = this.f4838i / this.f4837h;
        float r33 = r10 * r116;
        if (r14 == false) goto L22;
    L24:
        r8 = r10;
    L25:
        r15 = r29;
        r16 = r30;
        r12 = r31;
        goto L26
    L22:
        if (r33 <= r8) goto L24;
        r8 = Math.min(r8 / r116, r10);
        goto L25
    L18:
        this.F = f(this.f4837h, this.f4838i, r13, this.Q) / this.f4837h;
        goto L19
    L15:
        r32 = false;
        goto L16
    L8:
        r11 = false;
        goto L10
    }

    public final float d() {
        TextPaint r8 = this.O;
        r8.setTextSize(this.f4838i);
        r8.setTypeface(this.f4847r);
        r8.setLetterSpacing(this.V);
        return -r8.ascent();
    }

    public final int e(ColorStateList r8) {
        if (r8 != null) goto L5;
        return 0;
    L5:
        int[] r10 = this.L;
        if (r10 == null) goto L10;
        return r8.getColorForState(r10, 0);
    L10:
        return r8.getDefaultColor();
    }

    public final void g(Configuration r8) {
        Typeface r10 = this.f4849t;
        if (r10 == null) goto L5;
        this.f4848s = x9.f.a(r8, r10);
    L5:
        Typeface r11 = this.f4852w;
        if (r11 == null) goto L8;
        this.f4851v = x9.f.a(r8, r11);
    L8:
        Typeface r12 = this.f4848s;
        if (r12 != null) goto L12;
        r12 = this.f4849t;
    L12:
        this.f4847r = r12;
        Typeface r13 = this.f4851v;
        if (r13 != null) goto L16;
        r13 = this.f4852w;
    L16:
        this.f4850u = r13;
        h(true);
    }

    public final void h(boolean r17) {
        View r8 = this.f4825a;
        if (r8.getHeight() > 0) goto L5;
    L6:
        if (r17 == false) goto L72;
    L7:
        c(1.0f, r17);
        CharSequence r10 = this.B;
        TextPaint r11 = this.N;
        if (r10 == null) goto L12;
        StaticLayout r12 = this.Y;
        if (r12 == null) goto L12;
        this.f4830c0 = TextUtils.ellipsize(r10, r11, r12.getWidth(), this.f4855z);
    L12:
        CharSequence r13 = this.f4830c0;
        if (r13 == null) goto L15;
        this.Z = r11.measureText(r13, 0, r13.length());
    L16:
        int r14 = Gravity.getAbsoluteGravity(this.f4836g, this.C ? 1 : 0);
        int r15 = r14 & BWDLInnerConstant.LINK_RECOVERY;
        Rect r16 = this.f4831d;
        if (r15 == 48) goto L22;
        if (r15 == 80) goto L20;
        float r18 = r16.centerY() - ((r11.descent() - r11.ascent()) / 2.0f);
    L21:
        this.f4842m = r18;
    L23:
        int r19 = r14 & 8388615;
        if (r19 == 1) goto L28;
        if (r19 == 5) goto L27;
        float r20 = r16.left;
    L30:
        this.f4844o = r20;
        c(0.0f, r17);
        StaticLayout r21 = this.Y;
        if (r21 == null) goto L33;
        float r22 = r21.getHeight();
    L34:
        StaticLayout r23 = this.Y;
        if (r23 != null) goto L37;
    L39:
        CharSequence r24 = this.B;
        if (r24 == null) goto L42;
        float r25 = r11.measureText(r24, 0, r24.length());
    L43:
        StaticLayout r26 = this.Y;
        if (r26 == null) goto L46;
        r26.getLineCount();
    L46:
        int r27 = Gravity.getAbsoluteGravity(this.f4834f, this.C ? 1 : 0);
        int r110 = r27 & BWDLInnerConstant.LINK_RECOVERY;
        Rect r28 = this.f4829c;
        if (r110 == 48) goto L51;
        if (r110 == 80) goto L50;
        this.f4841l = r28.centerY() - (r22 / 2.0f);
    L53:
        int r29 = r27 & 8388615;
        if (r29 == 1) goto L58;
        if (r29 == 5) goto L57;
        float r30 = r28.left;
    L60:
        this.f4843n = r30;
        Bitmap r31 = this.E;
        if (r31 == null) goto L63;
        r31.recycle();
        this.E = null;
    L63:
        l(this.f4827b);
        float r32 = this.f4827b;
        float r33 = f(r28.left, r16.left, r32, this.P);
        RectF r34 = this.f4832e;
        r34.left = r33;
        r34.top = f(this.f4841l, this.f4842m, r32, this.P);
        r34.right = f(r28.right, r16.right, r32, this.P);
        r34.bottom = f(r28.bottom, r16.bottom, r32, this.P);
        this.f4845p = f(this.f4843n, this.f4844o, r32, this.P);
        this.f4846q = f(this.f4841l, this.f4842m, r32, this.P);
        l(r32);
        s0.b r35 = h9.a.f7944b;
        this.f4826a0 = 1.0f - f(0.0f, 1.0f, 1.0f - r32, r35);
        WeakHashMap<View, h0> r36 = w.f8437a;
        w.d.k(r8);
        this.f4828b0 = f(1.0f, 0.0f, r32, r35);
        w.d.k(r8);
        ColorStateList r37 = this.f4840k;
        ColorStateList r38 = this.f4839j;
        if (r37 == r38) goto L66;
        int r39 = a(r32, e(r38), e(this.f4840k));
    L67:
        r11.setColor(r39);
        float r40 = this.V;
        float r41 = this.W;
        if (r40 == r41) goto L70;
        r40 = f(r41, r40, r32, r35);
    L70:
        r11.setLetterSpacing(r40);
        this.H = f(0.0f, this.R, r32, null);
        this.I = f(0.0f, this.S, r32, null);
        this.J = f(0.0f, this.T, r32, null);
        int r42 = a(r32, e(null), e(this.U));
        this.K = r42;
        r11.setShadowLayer(this.H, this.I, this.J, r42);
        w.d.k(r8);
        return;
    L66:
        r39 = e(r37);
        goto L67
    L57:
        float r43 = r28.right;
    L59:
        r30 = r43 - r25;
        goto L60
    L58:
        r43 = r28.centerX();
        r25 = r25 / 2.0f;
        goto L59
    L50:
        float r44 = r11.descent() + (r28.bottom - r22);
    L52:
        this.f4841l = r44;
        goto L53
    L51:
        r44 = r28.top;
        goto L52
    L42:
        r25 = 0.0f;
        goto L43
    L37:
        if (this.d0 <= 1) goto L39;
        r25 = r23.getWidth();
        goto L43
    L33:
        r22 = 0.0f;
        goto L34
    L27:
        float r45 = r16.right;
        float r111 = this.Z;
    L29:
        r20 = r45 - r111;
        goto L30
    L28:
        r45 = r16.centerX();
        r111 = this.Z / 2.0f;
        goto L29
    L20:
        r18 = r11.ascent() + r16.bottom;
        goto L21
    L22:
        this.f4842m = r16.top;
        goto L23
    L15:
        this.Z = 0.0f;
        goto L16
    L72:
        return;
    L5:
        if (r8.getWidth() > 0) goto L7;
        goto L6
    }

    public final void i(ColorStateList r8) {
        if (this.f4840k == r8) goto L5;
    L6:
        this.f4840k = r8;
        this.f4839j = r8;
        h(false);
        return;
    L5:
        if (this.f4839j != r8) goto L6;
    }

    public final boolean j(Typeface r8) {
        x9.a r10 = this.f4854y;
        if (r10 == null) goto L6;
        r10.f13743e = true;
    L6:
        if (this.f4849t == r8) goto L12;
        this.f4849t = r8;
        Typeface r11 = x9.f.a(this.f4825a.getContext().getResources().getConfiguration(), r8);
        this.f4848s = r11;
        if (r11 != null) goto L10;
        r11 = this.f4849t;
    L10:
        this.f4847r = r11;
        return true;
    L12:
        return false;
    }

    public final void k(float r10) {
        float r11 = t2.b.o(r10, 0.0f, 1.0f);
        if (r11 == this.f4827b) goto L13;
        this.f4827b = r11;
        Rect r8 = this.f4829c;
        float r12 = r8.left;
        Rect r13 = this.f4831d;
        float r14 = f(r12, r13.left, r11, this.P);
        RectF r15 = this.f4832e;
        r15.left = r14;
        r15.top = f(this.f4841l, this.f4842m, r11, this.P);
        r15.right = f(r8.right, r13.right, r11, this.P);
        r15.bottom = f(r8.bottom, r13.bottom, r11, this.P);
        this.f4845p = f(this.f4843n, this.f4844o, r11, this.P);
        this.f4846q = f(this.f4841l, this.f4842m, r11, this.P);
        l(r11);
        s0.b r16 = h9.a.f7944b;
        this.f4826a0 = 1.0f - f(0.0f, 1.0f, 1.0f - r11, r16);
        WeakHashMap<View, h0> r17 = w.f8437a;
        View r18 = this.f4825a;
        w.d.k(r18);
        this.f4828b0 = f(1.0f, 0.0f, r11, r16);
        w.d.k(r18);
        ColorStateList r19 = this.f4840k;
        ColorStateList r20 = this.f4839j;
        TextPaint r21 = this.N;
        if (r19 == r20) goto L7;
        int r22 = a(r11, e(r20), e(this.f4840k));
    L8:
        r21.setColor(r22);
        float r23 = this.V;
        float r24 = this.W;
        if (r23 == r24) goto L11;
        r23 = f(r24, r23, r11, r16);
    L11:
        r21.setLetterSpacing(r23);
        this.H = f(0.0f, this.R, r11, null);
        this.I = f(0.0f, this.S, r11, null);
        this.J = f(0.0f, this.T, r11, null);
        int r25 = a(r11, e(null), e(this.U));
        this.K = r25;
        r21.setShadowLayer(this.H, this.I, this.J, r25);
        w.d.k(r18);
        return;
    L7:
        r22 = e(r19);
        goto L8
    }

    public final void l(float r8) {
        c(r8, false);
        WeakHashMap<View, h0> r10 = w.f8437a;
        w.d.k(this.f4825a);
    }

    public final void m(Typeface r8) {
        boolean r10 = j(r8);
        if (this.f4852w == r8) goto L8;
        this.f4852w = r8;
        Typeface r11 = x9.f.a(this.f4825a.getContext().getResources().getConfiguration(), r8);
        this.f4851v = r11;
        if (r11 != null) goto L7;
        r11 = this.f4852w;
    L7:
        this.f4850u = r11;
        boolean r12 = true;
    L9:
        if (r10 == true) goto L11;
        if (r12 == true) goto L11;
        return;
    L11:
        h(false);
        return;
    L8:
        r12 = false;
        goto L9
    }
}
