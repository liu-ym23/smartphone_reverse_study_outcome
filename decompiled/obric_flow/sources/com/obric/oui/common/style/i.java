package com.obric.oui.common.style;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import androidx.core.view.ViewCompat;
import com.google.common.reflect.w;
import com.obric.common.oea.foundation.animation.token.Token$Bounce;
import com.obric.common.oea.foundation.animation.token.Token$Duration;
import com.obric.common.oui.R$styleable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import zm.p;

/* JADX INFO: loaded from: classes3.dex */
public final class i implements b {
    public float A;
    public Paint B;
    public int C;
    public float[] D;
    public int E;
    public int F;
    public int G;
    public int H;
    public boolean I;
    public boolean J;
    public RectF K;
    public int L;
    public int M;
    public int N;
    public WeakReference O;
    public boolean P;
    public final Path Q;
    public Path R;
    public boolean S;
    public int T;
    public float U;
    public int V;
    public int W;
    public int X;
    public int Y;
    public int Z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f12479a;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public final AttributeSet f12480a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f12481b;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public final int f12482b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f12483c;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public final int f12484c0;
    public int d;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public boolean f12485d0;
    public int e;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public m f12486e0;
    public int f;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public m f12487f0;
    public int g;
    public final m g0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f12488h;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public final m f12489h0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f12490i;
    public float i0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f12491j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f12492k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f12493l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f12494m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f12495n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f12496o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f12497p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f12498q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f12499r;
    public int s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f12500t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f12501u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f12502v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f12503w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f12504x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f12505y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public Paint f12506z;

    public i(Context r5, AttributeSet r10, int r11, int r12) {
        this.f12481b = 0;
        this.f12483c = 0;
        this.d = 0;
        this.e = 0;
        this.f = 0;
        this.g = 0;
        this.f12488h = 0;
        this.f12491j = 255;
        this.f12492k = 0;
        this.f12493l = 0;
        this.f12494m = 0;
        this.f12496o = 255;
        this.f12497p = 0;
        this.f12498q = 0;
        this.f12499r = 0;
        this.f12500t = 255;
        this.f12501u = 0;
        this.f12502v = 0;
        this.f12503w = 0;
        this.f12505y = 255;
        this.A = 1.0f;
        this.E = 0;
        this.F = 0;
        this.G = 0;
        this.H = 0;
        this.J = false;
        this.L = 0;
        this.M = 1;
        this.N = 0;
        this.P = false;
        this.Q = new Path();
        this.R = null;
        this.S = true;
        this.T = 0;
        this.V = ViewCompat.MEASURED_STATE_MASK;
        this.W = 0;
        this.X = 0;
        this.Y = 0;
        this.Z = 0;
        this.f12485d0 = false;
        m r13 = m.f12515h;
        this.f12486e0 = r13.a();
        this.f12487f0 = r13.a();
        this.g0 = r13.a();
        this.f12489h0 = r13.a();
        this.i0 = 0.0f;
        this.f12479a = r5;
        this.f12480a0 = r10;
        this.f12482b0 = r11;
        this.f12484c0 = r12;
    }

    public static ArrayList o(int r18, Context r19) {
        ArrayList r5 = new ArrayList();
        TypedArray r10 = r19.obtainStyledAttributes(r18, R$styleable.OUILayout);
        int r11 = R$styleable.OUILayout_oui_firstShadowColor;
        int r12 = R$styleable.OUILayout_oui_firstShadowBlur;
        int r13 = R$styleable.OUILayout_oui_firstOffsetX;
        int r14 = R$styleable.OUILayout_oui_firstOffsetY;
        int r15 = R$styleable.OUILayout_oui_firstShadowSpread;
        Intrinsics.checkNotNullParameter(r10, "typedArray");
        float r16 = r10.getDimension(r13, 0.0f);
        float r17 = r10.getDimension(r14, 0.0f);
        float r110 = r10.getDimension(r12, 0.0f);
        m r20 = m.b(es.c.a(new es.b(r10.getColor(r11, 0), -1, r16, r17, r110, r10.getDimension(r15, 0.0f))));
        int r21 = R$styleable.OUILayout_oui_secondShadowColor;
        int r22 = R$styleable.OUILayout_oui_secondShadowBlur;
        int r23 = R$styleable.OUILayout_oui_secondOffsetX;
        int r24 = R$styleable.OUILayout_oui_secondOffsetY;
        int r111 = R$styleable.OUILayout_oui_secondShadowSpread;
        Intrinsics.checkNotNullParameter(r10, "typedArray");
        float r112 = r10.getDimension(r23, 0.0f);
        float r113 = r10.getDimension(r24, 0.0f);
        float r114 = r10.getDimension(r22, 0.0f);
        m r25 = m.b(es.c.a(new es.b(r10.getColor(r21, 0), -1, r112, r113, r114, r10.getDimension(r111, 0.0f))));
        r10.recycle();
        r5.add(r20);
        r5.add(r25);
        return r5;
    }

    public final void A(int r5) {
        this.f12500t = r5;
        v();
    }

    public final void B(int r5) {
        this.N = r5;
        v();
    }

    public final void C(boolean r5) {
        View r10 = (View) this.O.get();
        if (r10 != null) goto L5;
        return;
    L5:
        this.P = r5;
        r10.invalidateOutline();
    }

    public final void D(int r5) {
        if (this.C == r5) goto L6;
        int r10 = this.T;
        E(this.U, r5, r10);
        return;
    }

    public final void E(float r5, int r10, int r11) {
        int r12 = this.V;
        View r13 = (View) this.O.get();
        if (r13 == null) goto L31;
        this.C = r10;
        if (this.i0 != 0.0f) goto L9;
        this.i0 = r10;
    L9:
        if (this.G <= 0) goto L11;
    L18:
        boolean r14 = true;
    L19:
        this.I = r14;
        this.T = r11;
        this.U = r5;
        this.V = r12;
        if (r11 == 0) goto L24;
        if (r14 == true) goto L24;
        r13.setElevation(r11);
    L25:
        int r15 = this.V;
        View r16 = (View) this.O.get();
        if (r16 == null) goto L29;
        r16.setOutlineAmbientShadowColor(r15);
        r16.setOutlineSpotShadowColor(r15);
    L29:
        r13.setOutlineProvider(new br.c(this, 4));
        M();
        r13.invalidate();
        return;
    L24:
        r13.setElevation(0.0f);
        goto L25
    L11:
        if (this.F > 0) goto L18;
        if (this.E > 0) goto L18;
        if (this.H > 0) goto L18;
        r14 = false;
        goto L19
    }

    public final void F(int r5) {
        this.f12505y = r5;
        v();
    }

    public final void G(float r5) {
        if (this.U != r5) goto L5;
        return;
    L5:
        this.U = r5;
        View r10 = (View) this.O.get();
        if (r10 == null) goto L14;
        int r11 = this.T;
        if (r11 != 0) goto L11;
        r10.setElevation(0.0f);
    L12:
        r10.invalidateOutline();
        return;
    L11:
        r10.setElevation(r11);
        goto L12
    }

    public final void H(int r5) {
        if (this.V != r5) goto L5;
        return;
    L5:
        this.V = r5;
        View r10 = (View) this.O.get();
        if (r10 == null) goto L10;
        r10.setOutlineAmbientShadowColor(r5);
        r10.setOutlineSpotShadowColor(r5);
        return;
    }

    public final void I(int r5) {
        if (this.T != r5) goto L5;
        return;
    L5:
        this.T = r5;
        View r10 = (View) this.O.get();
        if (r10 == null) goto L14;
        int r11 = this.T;
        if (r11 != 0) goto L11;
        r10.setElevation(0.0f);
    L12:
        r10.invalidateOutline();
        return;
    L11:
        r10.setElevation(r11);
        goto L12
    }

    public final void J(int r5) {
        if (r5 != 0) goto L4;
        return;
    L4:
        a(r5, this.f12479a);
        this.g0.c(this.f12486e0);
        this.f12489h0.c(this.f12487f0);
        u();
    }

    public final void K(boolean r5) {
        this.S = r5;
        u();
    }

    public final void L(int r5) {
        this.f12491j = r5;
        v();
    }

    public final void M() {
        View r5 = (View) this.O.get();
        if (r5 != null) goto L5;
        return;
    L5:
        boolean r10 = false;
        if (this.J == false) goto L8;
        r5.setClipToOutline(false);
        return;
    L8:
        int r11 = this.C;
        if (r11 != (-2)) goto L11;
    L13:
        r10 = true;
    L14:
        r5.setClipToOutline(r10);
        return;
    L11:
        if (r11 == (-1)) goto L13;
        if (r11 <= 0) goto L14;
        goto L13
    }

    public final void a(int r18, Context r19) {
        TypedArray r5 = r19.obtainStyledAttributes(r18, R$styleable.OUILayout);
        m r10 = this.f12486e0;
        int r11 = R$styleable.OUILayout_oui_firstShadowColor;
        int r12 = R$styleable.OUILayout_oui_firstShadowBlur;
        int r13 = R$styleable.OUILayout_oui_firstOffsetX;
        int r14 = R$styleable.OUILayout_oui_firstOffsetY;
        int r15 = R$styleable.OUILayout_oui_firstShadowSpread;
        Intrinsics.checkNotNullParameter(r5, "typedArray");
        float r16 = r5.getDimension(r13, 0.0f);
        float r17 = r5.getDimension(r14, 0.0f);
        float r110 = r5.getDimension(r12, 0.0f);
        r10.d(es.c.a(new es.b(r5.getColor(r11, 0), -1, r16, r17, r110, r5.getDimension(r15, 0.0f))));
        m r20 = this.f12487f0;
        int r21 = R$styleable.OUILayout_oui_secondShadowColor;
        int r22 = R$styleable.OUILayout_oui_secondShadowBlur;
        int r23 = R$styleable.OUILayout_oui_secondOffsetX;
        int r24 = R$styleable.OUILayout_oui_secondOffsetY;
        int r25 = R$styleable.OUILayout_oui_secondShadowSpread;
        Intrinsics.checkNotNullParameter(r5, "typedArray");
        float r111 = r5.getDimension(r23, 0.0f);
        float r112 = r5.getDimension(r24, 0.0f);
        float r113 = r5.getDimension(r22, 0.0f);
        r20.d(es.c.a(new es.b(r5.getColor(r21, 0), -1, r111, r112, r113, r5.getDimension(r25, 0.0f))));
        r5.recycle();
    }

    @Override // com.obric.oui.common.style.b
    public final void c(List r5) {
        if (r5.isEmpty() == true) goto L8;
        m r10 = (m) r5.get(0);
        this.g0.c(r10);
        int r11 = r5.size();
        m r12 = this.f12489h0;
        if (r11 <= 1) goto L7;
        r12.c((m) r5.get(1));
        goto L8
    L7:
        r12.f12516a = 0;
        r12.f12517b = 0.0f;
        r12.f12518c = 0.0f;
        r12.d = 0.0f;
        r12.e = 0.0f;
        r12.g = 0.0f;
        r12.f.setMaskFilter(null);
    L8:
        u();
    }

    @Override // com.obric.oui.common.style.b
    public final boolean d() {
        return this.J;
    }

    public final void e(Canvas r13) {
        View r5 = (View) this.O.get();
        if (r5 != null) goto L5;
        return;
    L5:
        int r10 = r();
        if (this.M > 0) goto L8;
    L10:
        boolean r11 = false;
    L11:
        if (r11 == true) goto L14;
        return;
    L14:
        if (this.S == true) goto L16;
    L18:
        int r12 = r13.getWidth();
        int r14 = r13.getHeight();
        r13.save();
        r13.translate(r5.getScrollX(), r5.getScrollY());
        float r15 = this.M / 2.0f;
        if (this.P == false) goto L21;
        this.K.set(r5.getPaddingLeft() + r15, r5.getPaddingTop() + r15, (r12 - r5.getPaddingRight()) - r15, (r14 - r5.getPaddingBottom()) - r15);
    L23:
        if (this.I == true) goto L25;
    L28:
        if (r11 == false) goto L35;
        this.B.setColor(this.L);
        this.B.setStrokeWidth(this.M);
        this.B.setStyle(Paint.Style.STROKE);
        if (this.I == false) goto L32;
        RectF r16 = this.K;
        float[] r17 = this.D;
        Paint r18 = this.B;
        Path r19 = this.Q;
        r19.reset();
        r19.addRoundRect(r16, r17, Path.Direction.CW);
        r13.drawPath(r19, r18);
        goto L35
    L32:
        if (r10 > 0) goto L34;
        r13.drawRect(this.K, this.B);
        goto L35
    L34:
        float r20 = r10 * 1.0f;
        r13.drawRoundRect(this.K, r20, r20, this.B);
    L35:
        r13.restore();
        return;
    L25:
        if (this.D != null) goto L27;
        this.D = new float[8];
    L27:
        float[] r21 = this.D;
        float r22 = this.E;
        r21[0] = r22;
        r21[1] = r22;
        float r23 = this.F;
        r21[2] = r23;
        r21[3] = r23;
        float r24 = this.G;
        r21[4] = r24;
        r21[5] = r24;
        float r25 = this.H;
        r21[6] = r25;
        r21[7] = r25;
        goto L28
    L21:
        this.K.set(r15, r15, r12 - r15, r14 - r15);
        goto L23
    L16:
        if (this.T == 0) goto L18;
        return;
    L8:
        if (this.L == 0) goto L10;
        r11 = true;
        goto L11
    }

    @Override // com.obric.oui.common.style.b
    public final void f(m r5, m r10) {
        l(r5, r10, false);
    }

    @Override // com.obric.oui.common.style.b
    public final boolean g() {
        return false;
    }

    @Override // com.obric.oui.common.style.b
    public final List getCurrentShadows() {
        ArrayList r5 = new ArrayList(2);
        m r10 = this.g0;
        if (r10 == null) goto L5;
        r5.add(r10);
    L5:
        m r11 = this.f12489h0;
        if (r11 == null) goto L8;
        r5.add(r11);
    L8:
        return r5;
    }

    public final void h(Canvas r10) {
        View r5 = (View) this.O.get();
        if (r5 != null) goto L5;
        return;
    L5:
        boolean r11 = false;
        m r12 = this.g0;
        if (r12 != null) goto L8;
    L10:
        boolean r13 = false;
    L11:
        m r14 = this.f12489h0;
        if (r14 != null) goto L14;
    L16:
        if (r13 == true) goto L20;
        if (r11 == true) goto L20;
        this.R = null;
    L28:
        if (r5.isHardwareAccelerated() == false) goto L31;
        return;
    L31:
        if (this.I == false) goto L33;
        return;
    L33:
        Drawable r15 = r5.getBackground();
        Context r16 = this.f12479a;
        if (r15 != null) goto L36;
    L38:
        Drawable r17 = r5.getForeground();
        if (r17 != null) goto L41;
        return;
    L41:
        if ((r17 instanceof l) == true) goto L45;
        l r18 = new l(r17, r16.getResources().getDisplayMetrics());
        r18.d = this.C;
        r5.setForeground(r18);
        return;
    L45:
        return;
    L36:
        if ((r15 instanceof l) == true) goto L38;
        l r19 = new l(r15, r16.getResources().getDisplayMetrics());
        r19.d = this.C;
        r5.setBackground(r19);
    L20:
        if (this.J == false) goto L22;
    L26:
        n(r10, r12);
        n(r10, r14);
        goto L28
    L22:
        if (this.C == 0) goto L24;
    L25:
        Log.e("OUILayoutHelper", " 阴影和圆角同时存在阴影不生效");
        goto L28
    L24:
        if (this.I == false) goto L26;
    L14:
        if (r14.e() == false) goto L16;
        r11 = true;
        goto L16
    L8:
        if (r12.e() == false) goto L10;
        r13 = true;
        goto L11
    }

    public final void i(Canvas r12, int r13, int r14) {
        View r5 = (View) this.O.get();
        if (r5 != null) goto L6;
        return;
    L6:
        if (this.f12506z == null) goto L8;
    L16:
        r12.save();
        r12.translate(r5.getScrollX(), r5.getScrollY());
        int r10 = this.f;
        if (r10 <= 0) goto L22;
        this.f12506z.setStrokeWidth(r10);
        this.f12506z.setColor(p.n(this.A, this.f12490i));
        int r11 = this.f12491j;
        if (r11 >= 255) goto L21;
        this.f12506z.setAlpha(r11);
    L21:
        float r15 = this.f / 2.0f;
        r12.drawLine(this.g, r15, r13 - this.f12488h, r15, this.f12506z);
    L22:
        int r16 = this.f12492k;
        if (r16 <= 0) goto L28;
        this.f12506z.setStrokeWidth(r16);
        this.f12506z.setColor(p.n(this.A, this.f12495n));
        int r17 = this.f12496o;
        if (r17 >= 255) goto L27;
        this.f12506z.setAlpha(r17);
    L27:
        float r18 = (float) Math.floor(r14 - (this.f12492k / 2.0f));
        r12.drawLine(this.f12493l, r18, r13 - this.f12494m, r18, this.f12506z);
    L28:
        int r19 = this.f12497p;
        if (r19 <= 0) goto L34;
        this.f12506z.setStrokeWidth(r19);
        this.f12506z.setColor(p.n(this.A, this.s));
        int r20 = this.f12500t;
        if (r20 >= 255) goto L33;
        this.f12506z.setAlpha(r20);
    L33:
        float r21 = this.f12497p / 2.0f;
        r12.drawLine(r21, this.f12498q, r21, r14 - this.f12499r, this.f12506z);
    L34:
        int r22 = this.f12501u;
        if (r22 <= 0) goto L40;
        this.f12506z.setStrokeWidth(r22);
        this.f12506z.setColor(p.n(this.A, this.f12504x));
        int r23 = this.f12505y;
        if (r23 >= 255) goto L39;
        this.f12506z.setAlpha(r23);
    L39:
        float r24 = (float) Math.floor(r13 - (this.f12501u / 2.0f));
        r12.drawLine(r24, this.f12502v, r24, r14 - this.f12503w, this.f12506z);
    L40:
        r12.restore();
        return;
    L8:
        if (this.f <= 0) goto L10;
    L15:
        this.f12506z = new Paint();
        goto L16
    L10:
        if (this.f12492k > 0) goto L15;
        if (this.f12497p > 0) goto L15;
        if (this.f12501u <= 0) goto L16;
        goto L15
    }

    @Override // com.obric.oui.common.style.b
    public final void j(int r5) {
    }

    @Override // com.obric.oui.common.style.b
    public final boolean k() {
        return false;
    }

    @Override // com.obric.oui.common.style.b
    public final void l(m r10, m r11, boolean r12) {
        if (r10 != null) goto L4;
    L5:
        if (r11 != null) goto L7;
        return;
    L7:
        if (r11.equals(this.f12487f0) == true) goto L23;
    L8:
        m r5 = this.f12489h0;
        m r13 = this.g0;
        if (r12 == true) goto L15;
        if (r10 != null) goto L12;
        r10 = m.f12515h.a();
    L12:
        if (r11 != null) goto L14;
        r11 = m.f12515h.a();
    L14:
        this.f12486e0 = r10;
        this.f12487f0 = r11;
        r13.c(r10);
        r5.c(r11);
    L20:
        u();
        return;
    L15:
        if (r10 != null) goto L17;
        r10 = m.f12515h.a();
    L17:
        if (r11 != null) goto L19;
        r11 = m.f12515h.a();
    L19:
        final ArrayList r14 = new ArrayList(2);
        r14.add(r10);
        r14.add(r11);
        final ArrayList r15 = new ArrayList(2);
        r15.add(r13.a());
        r15.add(r5.a());
        Intrinsics.checkNotNullParameter(this, "ouiLayout");
        Intrinsics.checkNotNullParameter(r15, "oldShadow");
        Intrinsics.checkNotNullParameter(r14, "newShadow");
        com.obric.common.oea.foundation.animation.spec.spring.b r16 = ug.a.m(Token$Bounce.OUI_ANIMATION_BOUNCE_SMOOTH, Token$Duration.OUI_ANIMATION_DURATION_MEDIUM_4);
        Intrinsics.checkNotNullParameter(r16, "spec");
        hp.a r17 = new hp.a(r16, Float.valueOf(0.0f), Float.valueOf(1.0f), null, "valueAnimationPlaceholder", Reflection.getOrCreateKotlinClass(Float.TYPE));
        Function3<String, Object, Object, Unit> r18 = new ShadowAnimator$startAnim$1(r15, r14, this);
        Intrinsics.checkNotNullParameter(r18, "callback");
        Function2<Boolean, Throwable, Unit> r19 = new ShadowAnimator$startAnim$2(this, r14);
        Intrinsics.checkNotNullParameter(r19, "callback");
        new w(r17, r18, r19).x();
        goto L20
    L23:
        return;
    L4:
        if (r10.equals(this.f12486e0) == false) goto L8;
        goto L5
    }

    @Override // com.obric.oui.common.style.b
    public final void m(float r5) {
        if (this.A == r5) goto L6;
        this.A = r5;
        u();
        return;
    }

    public final void n(Canvas r10, m r11) {
        if (r11 != null) goto L4;
        return;
    L4:
        float r5 = r11.g;
        if (r5 > 0.0f) goto L8;
        r5 = this.i0;
    L8:
        View r12 = (View) this.O.get();
        if (this.R != null) goto L11;
        this.R = new Path();
    L11:
        RectF r13 = new RectF(0.0f, 0.0f, r12.getWidth(), r12.getHeight());
        this.R.reset();
        this.R.addRoundRect(r13, r5, r5, Path.Direction.CW);
        int r14 = r10.save();
        RectF r15 = new RectF(r13);
        r15.offset(r11.f12518c, r11.d);
        float r16 = r11.e;
        r15.inset(-r16, -r16);
        r10.clipOutPath(this.R);
        int r17 = r11.f12516a;
        Paint r18 = r11.f;
        r18.setColor(r17);
        r10.drawRoundRect(r15, r5, r5, r18);
        r10.restoreToCount(r14);
    }

    public final int p(int r5) {
        if (this.f12483c > 0) goto L5;
        return r5;
    L5:
        if (View.MeasureSpec.getSize(r5) > this.f12483c) goto L7;
        return r5;
    L7:
        if (View.MeasureSpec.getMode(r5) != Integer.MIN_VALUE) goto L10;
        return View.MeasureSpec.makeMeasureSpec(this.f12483c, Integer.MIN_VALUE);
    L10:
        return View.MeasureSpec.makeMeasureSpec(this.f12483c, BasicMeasure.EXACTLY);
    }

    public final int q(int r5) {
        if (this.f12481b > 0) goto L5;
        return r5;
    L5:
        if (View.MeasureSpec.getSize(r5) > this.f12481b) goto L7;
        return r5;
    L7:
        if (View.MeasureSpec.getMode(r5) != Integer.MIN_VALUE) goto L10;
        return View.MeasureSpec.makeMeasureSpec(this.f12481b, Integer.MIN_VALUE);
    L10:
        return View.MeasureSpec.makeMeasureSpec(this.f12481b, BasicMeasure.EXACTLY);
    }

    public final int r() {
        View r5 = (View) this.O.get();
        if (r5 == null) goto L5;
        int r10 = this.C;
        if (r10 != (-1)) goto L10;
        return r5.getHeight() / 2;
    L10:
        if (r10 == (-2)) goto L12;
        return r10;
    L12:
        return r5.getWidth() / 2;
    L5:
        return this.C;
    }

    public final int s(int r5, int r10) {
        if (View.MeasureSpec.getMode(r5) == 1073741824) goto L8;
        int r11 = this.e;
        if (r10 >= r11) goto L8;
        return View.MeasureSpec.makeMeasureSpec(r11, BasicMeasure.EXACTLY);
    L8:
        return r5;
    }

    @Override // com.obric.oui.common.style.b
    public final void setWidthMin(int r5) {
        this.d = r5;
    }

    public final int t(int r5, int r10) {
        if (View.MeasureSpec.getMode(r5) == 1073741824) goto L8;
        int r11 = this.d;
        if (r10 >= r11) goto L8;
        return View.MeasureSpec.makeMeasureSpec(r11, BasicMeasure.EXACTLY);
    L8:
        return r5;
    }

    public final void u() {
        View r5 = (View) this.O.get();
        if (r5 != null) goto L5;
        return;
    L5:
        r5.invalidate();
    }

    public final void v() {
        View r5 = (View) this.O.get();
        if (r5 == null) goto L6;
        r5.invalidate();
        return;
    }

    public final void w(int r5) {
        this.L = r5;
        v();
    }

    public final void x(int r5) {
        this.M = r5;
        v();
    }

    public final void y(int r5) {
        this.f12496o = r5;
        v();
    }

    public final void z(boolean r5) {
        this.J = r5;
        M();
        u();
    }
}
