package com.obric.oui.common.style;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.common.oea.foundation.animation.token.Token$Bounce;
import com.obric.common.oea.foundation.animation.token.Token$Duration;
import com.obric.oui.shadow.ShadowTokenCore;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class l implements b {
    public float A;
    public Paint B;
    public int C;
    public float[] D;
    public int E;
    public int F;
    public int G;
    public int H;
    public final AttributeSet H0;
    public boolean I;
    public boolean J;
    public RectF K;
    public int L;
    public final int L0;
    public int M;
    public int N;
    public WeakReference<View> O;
    public boolean P;
    public final int P0;
    public final Path Q;
    public Path R;
    public boolean S;
    public int T;
    public float U;
    public int V;
    public boolean V0;
    public int W;
    public int X;
    public int Y;
    public int Z;
    public final Context a;
    public int b;
    public q b1;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public q g1;
    public int h;
    public final q h1;
    public int i;
    public int j;
    public int k;
    public int k0;
    public final q k1;
    public int l;
    public int m;
    public int n;
    public int o;
    public int p;
    public int p0;
    public float p1;
    public int q;
    public int r;
    public int s;
    public int t;
    public int u;
    public int v;
    public int w;
    public int x;
    public int y;
    public Paint z;

    @Override // com.obric.oui.common.style.b
    public final void Q5(int r1) {
    }

    @Override // com.obric.oui.common.style.b
    public final boolean R4() {
        return false;
    }

    @Override // com.obric.oui.common.style.b
    public final boolean S() {
        return false;
    }

    @Override // com.obric.oui.common.style.b
    public final /* synthetic */ boolean Z2() {
        return false;
    }

    public final void I() {
        View r0 = this.O.get();
        if (r0 != null) goto L5;
        return;
    L5:
        boolean r2 = false;
        if (this.J == false) goto L8;
        r0.setClipToOutline(false);
        return;
    L8:
        int r1 = this.C;
        if (r1 != (-2)) goto L11;
    L13:
        r2 = true;
    L14:
        r0.setClipToOutline(r2);
        return;
    L11:
        if (r1 == (-1)) goto L13;
        if (r1 <= 0) goto L14;
        goto L13
    }

    @Override // com.obric.oui.common.style.b
    public final List<q> getCurrentShadows() {
        ArrayList r0 = new ArrayList(2);
        q r1 = this.h1;
        if (r1 == null) goto L5;
        r0.add(r1);
    L5:
        q r2 = this.k1;
        if (r2 == null) goto L8;
        r0.add(r2);
    L8:
        return r0;
    }

    public final int k() {
        View r0 = this.O.get();
        if (r0 == null) goto L5;
        int r1 = this.C;
        if (r1 != (-1)) goto L10;
        return r0.getHeight() / 2;
    L10:
        if (r1 == (-2)) goto L12;
        return r1;
    L12:
        return r0.getWidth() / 2;
    L5:
        return this.C;
    }

    public final void n() {
        View r0 = this.O.get();
        if (r0 != null) goto L5;
        return;
    L5:
        r0.invalidate();
    }

    public final void o() {
        View r0 = this.O.get();
        if (r0 == null) goto L6;
        r0.invalidate();
        return;
    }

    @Override // com.obric.oui.common.style.b
    public final boolean e1() {
        return this.J;
    }

    public final void B(float r2) {
        if (this.U != r2) goto L5;
        return;
    L5:
        this.U = r2;
        View r3 = this.O.get();
        if (r3 == null) goto L14;
        int r0 = this.T;
        if (r0 != 0) goto L11;
        r3.setElevation(0.0f);
    L12:
        r3.invalidateOutline();
        return;
    L11:
        r3.setElevation(r0);
        goto L12
    }

    public final void C(int r3) {
        if (this.V != r3) goto L5;
        return;
    L5:
        this.V = r3;
        if (Build.VERSION.SDK_INT < 28) goto L12;
        View r0 = this.O.get();
        if (r0 == null) goto L13;
        r0.setOutlineAmbientShadowColor(r3);
        r0.setOutlineSpotShadowColor(r3);
        return;
    L13:
        return;
    }

    @Override // com.obric.oui.common.style.b
    public final void C1(List<q> r4) {
        if (r4.isEmpty() == true) goto L8;
        this.h1.update((q) ListProtector.get(r4, 0));
        if (r4.size() <= 1) goto L7;
        this.k1.update((q) ListProtector.get(r4, 1));
        goto L8
    L7:
        q r5 = this.k1;
        r5.a = 0;
        r5.b = 0.0f;
        r5.c = 0.0f;
        r5.d = 0.0f;
        r5.e = 0.0f;
        r5.g = 0.0f;
        r5.f.setMaskFilter(null);
    L8:
        n();
    }

    public final void D(int r2) {
        if (this.T != r2) goto L5;
        return;
    L5:
        this.T = r2;
        View r3 = this.O.get();
        if (r3 == null) goto L14;
        int r0 = this.T;
        if (r0 != 0) goto L11;
        r3.setElevation(0.0f);
    L12:
        r3.invalidateOutline();
        return;
    L11:
        r3.setElevation(r0);
        goto L12
    }

    public final void E(int r2) {
        if (r2 != 0) goto L4;
        return;
    L4:
        a(this.a, r2);
        this.h1.update(this.b1);
        this.k1.update(this.g1);
        n();
    }

    public final void F(boolean r1) {
        this.S = r1;
        n();
    }

    public final void G(int r1) {
        this.j = r1;
        o();
    }

    @Override // com.obric.oui.common.style.b
    public final void T0(float r2) {
        if (this.A == r2) goto L6;
        this.A = r2;
        n();
        return;
    }

    public final void c(Canvas r13) {
        View r0 = this.O.get();
        if (r0 != null) goto L5;
        return;
    L5:
        int r1 = k();
        if (this.M > 0) goto L8;
    L10:
        boolean r2 = false;
    L11:
        if (r2 == true) goto L14;
        return;
    L14:
        if (this.S == true) goto L16;
    L18:
        int r5 = r13.getWidth();
        int r6 = r13.getHeight();
        r13.save();
        r13.translate(r0.getScrollX(), r0.getScrollY());
        float r7 = this.M / 2.0f;
        if (this.P == false) goto L21;
        this.K.set(r0.getPaddingLeft() + r7, r0.getPaddingTop() + r7, (r5 - r0.getPaddingRight()) - r7, (r6 - r0.getPaddingBottom()) - r7);
    L23:
        if (this.I == true) goto L25;
    L28:
        if (r2 == false) goto L35;
        this.B.setColor(this.L);
        this.B.setStrokeWidth(this.M);
        this.B.setStyle(Paint.Style.STROKE);
        if (this.I == false) goto L32;
        RectF r3 = this.K;
        float[] r4 = this.D;
        Paint r8 = this.B;
        this.Q.reset();
        this.Q.addRoundRect(r3, r4, Path.Direction.CW);
        r13.drawPath(this.Q, r8);
        goto L35
    L32:
        if (r1 > 0) goto L34;
        r13.drawRect(this.K, this.B);
        goto L35
    L34:
        float r9 = r1 * 1.0f;
        r13.drawRoundRect(this.K, r9, r9, this.B);
    L35:
        r13.restore();
        return;
    L25:
        if (this.D != null) goto L27;
        this.D = new float[8];
    L27:
        float[] r10 = this.D;
        float r11 = this.E;
        r10[0] = r11;
        r10[1] = r11;
        float r12 = this.F;
        r10[2] = r12;
        r10[3] = r12;
        float r14 = this.G;
        r10[4] = r14;
        r10[5] = r14;
        float r15 = this.H;
        r10[6] = r15;
        r10[7] = r15;
        goto L28
    L21:
        this.K.set(r7, r7, r5 - r7, r6 - r7);
        goto L23
    L16:
        if (this.T == 0) goto L18;
        return;
    L8:
        if (this.L == 0) goto L10;
        r2 = true;
        goto L11
    }

    public final void d(Canvas r6) {
        View r0 = this.O.get();
        if (r0 != null) goto L5;
        return;
    L5:
        q r1 = this.h1;
        boolean r2 = true;
        if (r1 != null) goto L8;
    L10:
        boolean r3 = false;
    L11:
        q r4 = this.k1;
        if (r4 != null) goto L14;
    L16:
        r2 = false;
    L17:
        if (r3 == true) goto L21;
        if (r2 == true) goto L21;
        this.R = null;
    L29:
        if (r0.isHardwareAccelerated() == false) goto L32;
        return;
    L32:
        if (this.I == false) goto L34;
        return;
    L34:
        Drawable r7 = r0.getBackground();
        if (r7 != null) goto L37;
    L39:
        Drawable r8 = r0.getForeground();
        if (r8 != null) goto L42;
        return;
    L42:
        if ((r8 instanceof p) == true) goto L46;
        Resources r5 = this.a.getResources();
        p r9 = new p(r8, WindowDisplayMetricsOverride.apply(r5, r5.getDisplayMetrics()));
        r9.d = this.C;
        r0.setForeground(r9);
        return;
    L46:
        return;
    L37:
        if ((r7 instanceof p) == true) goto L39;
        Resources r10 = this.a.getResources();
        p r11 = new p(r7, WindowDisplayMetricsOverride.apply(r10, r10.getDisplayMetrics()));
        r11.d = this.C;
        r0.setBackground(r11);
    L21:
        if (this.J == false) goto L23;
    L27:
        f(r6, this.h1);
        f(r6, this.k1);
        goto L29
    L23:
        if (this.C != 0) goto L29;
        if (this.I == false) goto L27;
    L14:
        if (r4.e() == false) goto L16;
    L8:
        if (r1.e() == false) goto L10;
        r3 = true;
        goto L11
    }

    public final int i(int r3) {
        if (this.c > 0) goto L5;
        return r3;
    L5:
        if (View.MeasureSpec.getSize(r3) > this.c) goto L7;
        return r3;
    L7:
        if (View.MeasureSpec.getMode(r3) != Integer.MIN_VALUE) goto L10;
        return View.MeasureSpec.makeMeasureSpec(this.c, Integer.MIN_VALUE);
    L10:
        return View.MeasureSpec.makeMeasureSpec(this.c, 1073741824);
    }

    public final int j(int r3) {
        if (this.b > 0) goto L5;
        return r3;
    L5:
        if (View.MeasureSpec.getSize(r3) > this.b) goto L7;
        return r3;
    L7:
        if (View.MeasureSpec.getMode(r3) != Integer.MIN_VALUE) goto L10;
        return View.MeasureSpec.makeMeasureSpec(this.b, Integer.MIN_VALUE);
    L10:
        return View.MeasureSpec.makeMeasureSpec(this.b, 1073741824);
    }

    public final void p(int r1) {
        this.L = r1;
        o();
    }

    public final void q(int r1) {
        this.M = r1;
        o();
    }

    public final void r(int r1) {
        this.o = r1;
        o();
    }

    public final void s(boolean r1) {
        this.J = r1;
        I();
        n();
    }

    @Override // com.obric.oui.common.style.b
    public final void setShadowCornerRadius(int r1) {
        this.p1 = r1;
    }

    @Override // com.obric.oui.common.style.b
    public final void setWidthMin(int r1) {
        this.d = r1;
    }

    public final void t(int r1) {
        this.t = r1;
        o();
    }

    public final void u(int r1) {
        this.N = r1;
        o();
    }

    public final void v(boolean r2) {
        View r0 = this.O.get();
        if (r0 != null) goto L5;
        return;
    L5:
        this.P = r2;
        r0.invalidateOutline();
    }

    public final void w(int r3) {
        if (this.C == r3) goto L6;
        y(r3, this.T, this.U);
        return;
    }

    public final void z(int r1) {
        this.y = r1;
        o();
    }

    public static List<q> g(Context r8, int r9) {
        ArrayList r0 = new ArrayList();
        TypedArray r10 = r8.obtainStyledAttributes(r9, new int[]{R.attr.maxWidth, R.attr.maxHeight, R.attr.minWidth, R.attr.minHeight, 2130973055, 2130973056, 2130973057, 2130973058, 2130973060, 2130973061, 2130973136, 2130973137, 2130973138, 2130973139, 2130973141, 2130973188, 2130973189, 2130973191, 2130973192, 2130973193, 2130973194, 2130973215, 2130973216, 2130973217, 2130973218, 2130973219, 2130973220, 2130973237, 2130973248, 2130973249, 2130973250, 2130973251, 2130973280, 2130973281, 2130973282, 2130973283, 2130973285, 2130973287, 2130973288, 2130973289, 2130973290, 2130973291, 2130973293, 2130973319, 2130973338, 2130973339, 2130973340, 2130973341, 2130973343, 2130973344, 2130973351});
        q r11 = q.b(com.obric.oui.shadow.a.a(r10, 13, 12, 10, 11, 14));
        q r1 = q.b(com.obric.oui.shadow.a.a(r10, 35, 34, 32, 33, 36));
        r10.recycle();
        r0.add(r11);
        r0.add(r1);
        return r0;
    }

    public static List<q> h(Context r5, String r6) {
        com.obric.oui.shadow.b[] r7 = ShadowTokenCore.parse(r6);
        if (r7 != null) goto L6;
        return null;
    L6:
        Resources r8 = r5.getResources();
        float r9 = WindowDisplayMetricsOverride.apply(r8, r8.getDisplayMetrics()).density;
        ArrayList r0 = new ArrayList();
        com.obric.oui.shadow.b r1 = r7[0];
        q r2 = q.h;
        q r3 = q.a.a(r1, r9);
        q r4 = q.h;
        if (r7.length <= 1) goto L9;
        r4 = q.a.a(r7[1], r9);
    L9:
        r0.add(r3);
        r0.add(r4);
        return r0;
    }

    public final void a(Context r8, int r9) {
        TypedArray r10 = r8.obtainStyledAttributes(r9, new int[]{R.attr.maxWidth, R.attr.maxHeight, R.attr.minWidth, R.attr.minHeight, 2130973055, 2130973056, 2130973057, 2130973058, 2130973060, 2130973061, 2130973136, 2130973137, 2130973138, 2130973139, 2130973141, 2130973188, 2130973189, 2130973191, 2130973192, 2130973193, 2130973194, 2130973215, 2130973216, 2130973217, 2130973218, 2130973219, 2130973220, 2130973237, 2130973248, 2130973249, 2130973250, 2130973251, 2130973280, 2130973281, 2130973282, 2130973283, 2130973285, 2130973287, 2130973288, 2130973289, 2130973290, 2130973291, 2130973293, 2130973319, 2130973338, 2130973339, 2130973340, 2130973341, 2130973343, 2130973344, 2130973351});
        this.b1.c(com.obric.oui.shadow.a.a(r10, 13, 12, 10, 11, 14));
        this.g1.c(com.obric.oui.shadow.a.a(r10, 35, 34, 32, 33, 36));
        r10.recycle();
    }

    public final void f(Canvas r6, q r7) {
        if (r7 != null) goto L4;
        return;
    L4:
        float r0 = r7.g;
        if (r0 > 0.0f) goto L8;
        r0 = this.p1;
    L8:
        View r2 = this.O.get();
        if (this.R != null) goto L11;
        this.R = new Path();
    L11:
        RectF r4 = new RectF(0.0f, 0.0f, r2.getWidth(), r2.getHeight());
        int r1 = this.W;
        if (r1 == 0) goto L14;
    L15:
        r4.inset(r1, this.X);
    L16:
        this.R.reset();
        this.R.addRoundRect(r4, r0, r0, Path.Direction.CW);
        int r3 = r6.save();
        RectF r5 = new RectF(r4);
        r5.offset(r7.c, r7.d);
        float r8 = r7.e;
        r5.inset(-r8, -r8);
        r6.clipOutPath(this.R);
        r7.f.setColor(r7.a);
        r6.drawRoundRect(r5, r0, r0, r7.f);
        r6.restoreToCount(r3);
        return;
    L14:
        if (this.X == 0) goto L16;
        goto L15
    }

    @Override // com.obric.oui.common.style.b
    public final void h1(q r2, q r3) {
        A(r2, r3, false);
    }

    public final int l(int r3, int r4) {
        if (View.MeasureSpec.getMode(r3) == 1073741824) goto L8;
        int r0 = this.e;
        if (r4 < r0) goto L7;
        return r3;
    L7:
        return View.MeasureSpec.makeMeasureSpec(r0, 1073741824);
    L8:
        return r3;
    }

    public final int m(int r3, int r4) {
        if (View.MeasureSpec.getMode(r3) == 1073741824) goto L8;
        int r0 = this.d;
        if (r4 < r0) goto L7;
        return r3;
    L7:
        return View.MeasureSpec.makeMeasureSpec(r0, 1073741824);
    L8:
        return r3;
    }

    public static List<q> b(Context r2, TypedArray r3, int r4) {
        List<q> r0 = h(r2, r3.getString(r4));
        if (r0 == null) goto L6;
        ArrayList r5 = new ArrayList(2);
        r5.addAll(r0);
        return r5;
    L6:
        int r6 = r3.getResourceId(r4, 0);
        if (r6 != 0) goto L10;
        return null;
    L10:
        List<q> r7 = g(r2, r6);
        ArrayList r8 = new ArrayList(2);
        r8.addAll(r7);
        return r8;
    }

    public final void A(q r5, q r6, boolean r7) {
        if (r5 != null) goto L4;
    L5:
        if (r6 != null) goto L7;
        return;
    L7:
        if (r6.equals(this.g1) == true) goto L22;
    L8:
        if (r7 == true) goto L14;
        if (r5 != null) goto L11;
        r5 = q.h.a();
    L11:
        if (r6 != null) goto L13;
        r6 = q.h.a();
    L13:
        this.b1 = r5;
        this.g1 = r6;
        this.h1.update(r5);
        this.k1.update(r6);
    L19:
        n();
        return;
    L14:
        if (r5 != null) goto L16;
        r5 = q.h.a();
    L16:
        if (r6 != null) goto L18;
        r6 = q.h.a();
    L18:
        final ArrayList r8 = new ArrayList(2);
        r8.add(r5);
        r8.add(r6);
        final ArrayList r9 = new ArrayList(2);
        r9.add(this.h1.a());
        r9.add(this.k1.a());
        int r10 = ShadowAnimator.a;
        Intrinsics.checkNotNullParameter(this, "ouiLayout");
        Intrinsics.checkNotNullParameter(r9, "oldShadow");
        Intrinsics.checkNotNullParameter(r8, "newShadow");
        com.obric.common.oea.foundation.animation.builder.d.a r11 = new com.obric.common.oea.foundation.animation.builder.d.a();
        r11.b(0.0f, 1.0f, gja.b.c(Token$Bounce.OUI_ANIMATION_BOUNCE_SMOOTH, Token$Duration.OUI_ANIMATION_DURATION_MEDIUM_4), null);
        Function3<String, Object, Object, Unit> r0 = new ShadowAnimator$startAnim$1(r9, r8, this);
        Intrinsics.checkNotNullParameter(r0, "callback");
        r11.d = r0;
        Function2<Boolean, Throwable, Unit> r1 = new ShadowAnimator$startAnim$2(this, r8);
        Intrinsics.checkNotNullParameter(r1, "callback");
        r11.e = r1;
        r11.a().a();
        goto L19
    L22:
        return;
    L4:
        if (r5.equals(this.b1) == false) goto L8;
        goto L5
    }

    public final void H(int r1, int r2, int r3) {
        this.l = r1;
        this.m = 0;
        this.n = r3;
        this.k = r2;
        o();
    }

    public final void e(Canvas r12, int r13, int r14) {
        View r0 = this.O.get();
        if (r0 != null) goto L6;
        return;
    L6:
        if (this.z == null) goto L8;
    L16:
        r12.save();
        r12.translate(r0.getScrollX(), r0.getScrollY());
        int r1 = this.f;
        if (r1 <= 0) goto L22;
        this.z.setStrokeWidth(r1);
        this.z.setColor(vma.h.a(this.i, this.A));
        int r2 = this.j;
        if (r2 >= 255) goto L21;
        this.z.setAlpha(r2);
    L21:
        float r7 = this.f / 2.0f;
        r12.drawLine(this.g, r7, r13 - this.h, r7, this.z);
    L22:
        int r3 = this.k;
        if (r3 <= 0) goto L28;
        this.z.setStrokeWidth(r3);
        this.z.setColor(vma.h.a(this.n, this.A));
        int r4 = this.o;
        if (r4 >= 255) goto L27;
        this.z.setAlpha(r4);
    L27:
        float r9 = (float) Math.floor(r14 - (this.k / 2.0f));
        r12.drawLine(this.l, r9, r13 - this.m, r9, this.z);
    L28:
        int r5 = this.p;
        if (r5 <= 0) goto L34;
        this.z.setStrokeWidth(r5);
        this.z.setColor(vma.h.a(this.s, this.A));
        int r6 = this.t;
        if (r6 >= 255) goto L33;
        this.z.setAlpha(r6);
    L33:
        float r8 = this.p / 2.0f;
        r12.drawLine(r8, this.q, r8, r14 - this.r, this.z);
    L34:
        int r10 = this.u;
        if (r10 <= 0) goto L40;
        this.z.setStrokeWidth(r10);
        this.z.setColor(vma.h.a(this.x, this.A));
        int r11 = this.y;
        if (r11 >= 255) goto L39;
        this.z.setAlpha(r11);
    L39:
        float r15 = (float) Math.floor(r13 - (this.u / 2.0f));
        r12.drawLine(r15, this.v, r15, r14 - this.w, this.z);
    L40:
        r12.restore();
        return;
    L8:
        if (this.f <= 0) goto L10;
    L15:
        this.z = new Paint();
        goto L16
    L10:
        if (this.k > 0) goto L15;
        if (this.p > 0) goto L15;
        if (this.u <= 0) goto L16;
        goto L15
    }

    public final void y(int r5, int r6, float r7) {
        int r0 = this.V;
        View r1 = this.O.get();
        if (r1 == null) goto L33;
        this.C = r5;
        if (this.p1 != 0.0f) goto L9;
        this.p1 = r5;
    L9:
        if (this.G <= 0) goto L11;
    L18:
        boolean r8 = true;
    L19:
        this.I = r8;
        this.T = r6;
        this.U = r7;
        this.V = r0;
        if (r6 == 0) goto L24;
        if (r8 == true) goto L24;
        r1.setElevation(r6);
    L25:
        int r9 = this.V;
        if (Build.VERSION.SDK_INT < 28) goto L31;
        View r10 = this.O.get();
        if (r10 == null) goto L31;
        r10.setOutlineAmbientShadowColor(r9);
        r10.setOutlineSpotShadowColor(r9);
    L31:
        r1.setOutlineProvider(new k(this));
        I();
        r1.invalidate();
        return;
    L24:
        r1.setElevation(0.0f);
        goto L25
    L11:
        if (this.F > 0) goto L18;
        if (this.E > 0) goto L18;
        if (this.H > 0) goto L18;
        r8 = false;
        goto L19
    }

    public l(Context r4, AttributeSet r5, int r6, int r7) {
        this.b = 0;
        this.c = 0;
        this.d = 0;
        this.e = 0;
        this.f = 0;
        this.g = 0;
        this.h = 0;
        this.j = 255;
        this.k = 0;
        this.l = 0;
        this.m = 0;
        this.o = 255;
        this.p = 0;
        this.q = 0;
        this.r = 0;
        this.t = 255;
        this.u = 0;
        this.v = 0;
        this.w = 0;
        this.y = 255;
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
        this.V = -16777216;
        this.W = 0;
        this.X = 0;
        this.Y = 0;
        this.Z = 0;
        this.k0 = 0;
        this.p0 = 0;
        this.V0 = false;
        q r0 = q.h;
        this.b1 = r0.a();
        this.g1 = r0.a();
        this.h1 = r0.a();
        this.k1 = r0.a();
        this.p1 = 0.0f;
        this.a = r4;
        this.H0 = r5;
        this.L0 = r6;
        this.P0 = r7;
    }

    public final void x(int r1, int r2, int r3, int r4) {
        this.E = r1;
        this.F = 0;
        this.G = r3;
        this.H = 0;
        y(this.C, this.T, this.U);
    }
}
