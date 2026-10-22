package com.google.android.material.chip;

import aa.f;
import aa.k;
import android.R;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import b0.b;
import com.google.android.material.internal.j;
import h9.g;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import x9.d;

/* JADX INFO: loaded from: classes.dex */
public final class a extends f implements Drawable.Callback, j.b {
    public static final int[] R0 = null;
    public static final ShapeDrawable S0 = null;
    public int A0;
    public int B0;
    public boolean C0;
    public int D0;
    public int E0;
    public ColorFilter F0;
    public PorterDuffColorFilter G0;
    public ColorStateList H0;
    public ColorStateList I;
    public PorterDuff.Mode I0;
    public ColorStateList J;
    public int[] J0;
    public float K;
    public boolean K0;
    public float L;
    public ColorStateList L0;
    public ColorStateList M;
    public WeakReference<InterfaceC0050a> M0;
    public float N;
    public TextUtils.TruncateAt N0;
    public ColorStateList O;
    public boolean O0;
    public CharSequence P;
    public int P0;
    public boolean Q;
    public boolean Q0;
    public Drawable R;
    public ColorStateList S;
    public float T;
    public boolean U;
    public boolean V;
    public Drawable W;
    public RippleDrawable X;
    public ColorStateList Y;
    public float Z;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public SpannableStringBuilder f4574a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public boolean f4575b0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public boolean f4576c0;
    public Drawable d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public ColorStateList f4577e0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public g f4578f0;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public g f4579g0;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public float f4580h0;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public float f4581i0;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public float f4582j0;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public float f4583k0;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    public float f4584l0;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public float f4585m0;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public float f4586n0;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    public float f4587o0;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public final Context f4588p0;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public final Paint f4589q0;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public final Paint.FontMetrics f4590r0;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public final RectF f4591s0;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public final PointF f4592t0;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public final Path f4593u0;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public final j f4594v0;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public int f4595w0;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public int f4596x0;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    public int f4597y0;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    public int f4598z0;

    /* JADX INFO: renamed from: com.google.android.material.chip.a$a, reason: collision with other inner class name */
    public interface InterfaceC0050a {
        void a();
    }

    static {
        R0 = new int[]{R.attr.state_enabled};
        S0 = new ShapeDrawable(new OvalShape());
    }

    public a(Context r8, AttributeSet r10) {
        super(r8, r10, com.obric.cae.R.attr.chipStyle, com.obric.cae.R.style.Widget_MaterialComponents_Chip_Action);
        this.L = -1.0f;
        this.f4589q0 = new Paint(1);
        this.f4590r0 = new Paint.FontMetrics();
        this.f4591s0 = new RectF();
        this.f4592t0 = new PointF();
        this.f4593u0 = new Path();
        this.E0 = 255;
        this.I0 = PorterDuff.Mode.SRC_IN;
        this.M0 = new WeakReference(null);
        i(r8);
        this.f4588p0 = r8;
        j r11 = new j(this);
        this.f4594v0 = r11;
        this.P = "";
        TextPaint r12 = r11.f4879a;
        r12.density = r8.getResources().getDisplayMetrics().density;
        int[] r13 = R0;
        setState(r13);
        if (Arrays.equals(this.J0, r13) == true) goto L7;
        this.J0 = r13;
        if (V() == false) goto L7;
        x(getState(), r13);
    L7:
        this.O0 = true;
        S0.setTint(-1);
    }

    public static void W(Drawable r8) {
        if (r8 == null) goto L5;
        r8.setCallback(null);
        return;
    }

    public static boolean u(ColorStateList r8) {
        if (r8 != null) goto L4;
    L6:
        return false;
    L4:
        if (r8.isStateful() == false) goto L6;
        return true;
    }

    public static boolean v(Drawable r8) {
        if (r8 != null) goto L4;
    L6:
        return false;
    L4:
        if (r8.isStateful() == false) goto L6;
        return true;
    }

    public final void A(ColorStateList r8) {
        if (this.f4577e0 == r8) goto L16;
        this.f4577e0 = r8;
        if (this.f4576c0 == true) goto L7;
    L11:
        boolean r10 = false;
    L12:
        if (r10 == false) goto L14;
        b0.a.b.h(this.d0, r8);
    L14:
        onStateChange(getState());
        return;
    L7:
        if (this.d0 == null) goto L11;
        if (this.f4575b0 == false) goto L11;
        r10 = true;
        goto L12
    }

    public final void B(boolean r8) {
        if (this.f4576c0 == r8) goto L14;
        boolean r10 = T();
        this.f4576c0 = r8;
        boolean r11 = T();
        if (r10 == r11) goto L7;
        boolean r12 = true;
    L8:
        if (r12 == false) goto L15;
        if (r11 == false) goto L11;
        o(this.d0);
    L12:
        invalidateSelf();
        w();
        return;
    L11:
        W(this.d0);
        goto L12
    L15:
        return;
    L7:
        r12 = false;
        goto L8
    }

    @Deprecated
    public final void C(float r8) {
        if (this.L == r8) goto L6;
        this.L = r8;
        aa.j r10 = this.f139a.f156a;
        r10.getClass();
        aa.j.a r11 = new aa.j.a(r10);
        r11.e(r8);
        r11.f(r8);
        r11.d(r8);
        r11.c(r8);
        setShapeAppearanceModel(new aa.j(r11));
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v2, types: [android.graphics.drawable.Drawable] */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8 */
    public final void D(Drawable r8) {
        Object r10 = this.R;
        Drawable r11 = null;
        if (r10 == null) goto L7;
        boolean r12 = r10 instanceof b;
        ?? r13 = r10;
        if (r12 == false) goto L8;
        r13 = ((b) r10).a();
    L8:
        if (r13 == r8) goto L19;
        float r14 = q();
        if (r8 == null) goto L12;
        r11 = r8.mutate();
    L12:
        this.R = r11;
        float r15 = q();
        W(r13);
        if (U() == false) goto L15;
        o(this.R);
    L15:
        invalidateSelf();
        if (r14 == r15) goto L20;
        w();
        return;
    L20:
        return;
    L19:
        return;
    L7:
        r13 = 0;
        goto L8
    }

    public final void E(float r8) {
        if (this.T == r8) goto L8;
        float r10 = q();
        this.T = r8;
        float r11 = q();
        invalidateSelf();
        if (r10 == r11) goto L9;
        w();
        return;
    L9:
        return;
    }

    public final void F(ColorStateList r8) {
        this.U = true;
        if (this.S == r8) goto L9;
        this.S = r8;
        if (U() == false) goto L7;
        b0.a.b.h(this.R, r8);
    L7:
        onStateChange(getState());
        return;
    }

    public final void G(boolean r8) {
        if (this.Q == r8) goto L14;
        boolean r10 = U();
        this.Q = r8;
        boolean r11 = U();
        if (r10 == r11) goto L7;
        boolean r12 = true;
    L8:
        if (r12 == false) goto L15;
        if (r11 == false) goto L11;
        o(this.R);
    L12:
        invalidateSelf();
        w();
        return;
    L11:
        W(this.R);
        goto L12
    L15:
        return;
    L7:
        r12 = false;
        goto L8
    }

    public final void H(ColorStateList r8) {
        if (this.M == r8) goto L11;
        this.M = r8;
        if (this.Q0 == false) goto L9;
        f.b r10 = this.f139a;
        if (r10.f159d == r8) goto L9;
        r10.f159d = r8;
        onStateChange(getState());
    L9:
        onStateChange(getState());
        return;
    }

    public final void I(float r8) {
        if (this.N == r8) goto L9;
        this.N = r8;
        this.f4589q0.setStrokeWidth(r8);
        if (this.Q0 == false) goto L7;
        this.f139a.f166k = r8;
        invalidateSelf();
    L7:
        invalidateSelf();
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v2, types: [android.graphics.drawable.Drawable] */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8 */
    public final void J(Drawable r8) {
        Object r10 = this.W;
        Drawable r11 = null;
        if (r10 == null) goto L7;
        boolean r12 = r10 instanceof b;
        ?? r13 = r10;
        if (r12 == false) goto L8;
        r13 = ((b) r10).a();
    L8:
        if (r13 == r8) goto L23;
        float r14 = r();
        if (r8 == null) goto L12;
        r11 = r8.mutate();
    L12:
        this.W = r11;
        ColorStateList r15 = this.O;
        if (r15 != null) goto L16;
        r15 = ColorStateList.valueOf(0);
    L16:
        this.X = new RippleDrawable(r15, this.W, S0);
        float r16 = r();
        W(r13);
        if (V() == false) goto L19;
        o(this.W);
    L19:
        invalidateSelf();
        if (r14 == r16) goto L24;
        w();
        return;
    L24:
        return;
    L23:
        return;
    L7:
        r13 = 0;
        goto L8
    }

    public final void K(float r8) {
        if (this.f4586n0 == r8) goto L8;
        this.f4586n0 = r8;
        invalidateSelf();
        if (V() == false) goto L9;
        w();
        return;
    L9:
        return;
    }

    public final void L(float r8) {
        if (this.Z == r8) goto L8;
        this.Z = r8;
        invalidateSelf();
        if (V() == false) goto L9;
        w();
        return;
    L9:
        return;
    }

    public final void M(float r8) {
        if (this.f4585m0 == r8) goto L8;
        this.f4585m0 = r8;
        invalidateSelf();
        if (V() == false) goto L9;
        w();
        return;
    L9:
        return;
    }

    public final void N(ColorStateList r8) {
        if (this.Y == r8) goto L9;
        this.Y = r8;
        if (V() == false) goto L7;
        b0.a.b.h(this.W, r8);
    L7:
        onStateChange(getState());
        return;
    }

    public final void O(boolean r8) {
        if (this.V == r8) goto L14;
        boolean r10 = V();
        this.V = r8;
        boolean r11 = V();
        if (r10 == r11) goto L7;
        boolean r12 = true;
    L8:
        if (r12 == false) goto L15;
        if (r11 == false) goto L11;
        o(this.W);
    L12:
        invalidateSelf();
        w();
        return;
    L11:
        W(this.W);
        goto L12
    L15:
        return;
    L7:
        r12 = false;
        goto L8
    }

    public final void P(float r8) {
        if (this.f4582j0 == r8) goto L8;
        float r10 = q();
        this.f4582j0 = r8;
        float r11 = q();
        invalidateSelf();
        if (r10 == r11) goto L9;
        w();
        return;
    L9:
        return;
    }

    public final void Q(float r8) {
        if (this.f4581i0 == r8) goto L8;
        float r10 = q();
        this.f4581i0 = r8;
        float r11 = q();
        invalidateSelf();
        if (r10 == r11) goto L9;
        w();
        return;
    L9:
        return;
    }

    public final void R(ColorStateList r8) {
        if (this.O == r8) goto L12;
        this.O = r8;
        if (this.K0 == false) goto L9;
        if (r8 != null) goto L10;
        r8 = ColorStateList.valueOf(0);
    L10:
        this.L0 = r8;
        onStateChange(getState());
        return;
    L9:
        r8 = null;
        goto L10
    }

    public final void S(d r8) {
        j r10 = this.f4594v0;
        if (r10.f4884f == r8) goto L14;
        r10.f4884f = r8;
        if (r8 == null) goto L10;
        TextPaint r11 = r10.f4879a;
        Context r12 = this.f4588p0;
        j.a r13 = r10.f4880b;
        r8.f(r12, r11, r13);
        j.b r14 = r10.f4883e.get();
        if (r14 == null) goto L9;
        r11.drawableState = r14.getState();
    L9:
        r8.e(r12, r11, r13);
        r10.f4882d = true;
    L10:
        j.b r15 = r10.f4883e.get();
        if (r15 == null) goto L15;
        r15.a();
        r15.onStateChange(r15.getState());
        return;
    L15:
        return;
    }

    public final boolean T() {
        if (this.f4576c0 == true) goto L5;
    L9:
        return false;
    L5:
        if (this.d0 == null) goto L9;
        if (this.C0 == false) goto L9;
        return true;
    }

    public final boolean U() {
        if (this.Q == true) goto L5;
    L7:
        return false;
    L5:
        if (this.R == null) goto L7;
        return true;
    }

    public final boolean V() {
        if (this.V == true) goto L5;
    L7:
        return false;
    L5:
        if (this.W == null) goto L7;
        return true;
    }

    @Override // com.google.android.material.internal.j.b
    public final void a() {
        w();
        invalidateSelf();
    }

    @Override // aa.f, android.graphics.drawable.Drawable
    public final void draw(Canvas r24) {
        Rect r15 = getBounds();
        if (r15.isEmpty() == true) goto L98;
        int r8 = this.E0;
        if (r8 != 0) goto L8;
        return;
    L8:
        if (r8 >= 255) goto L10;
        int r11 = r24.saveLayerAlpha(r15.left, r15.top, r15.right, r15.bottom, r8);
    L11:
        boolean r10 = this.Q0;
        Paint r12 = this.f4589q0;
        RectF r13 = this.f4591s0;
        if (r10 == true) goto L15;
        r12.setColor(this.f4595w0);
        r12.setStyle(Paint.Style.FILL);
        r13.set(r15);
        r24.drawRoundRect(r13, s(), s(), r12);
    L15:
        if (this.Q0 == true) goto L22;
        r12.setColor(this.f4596x0);
        r12.setStyle(Paint.Style.FILL);
        ColorFilter r14 = this.F0;
        if (r14 != null) goto L20;
        r14 = this.G0;
    L20:
        r12.setColorFilter(r14);
        r13.set(r15);
        r24.drawRoundRect(r13, s(), s(), r12);
    L22:
        if (this.Q0 == false) goto L25;
        super.draw(r24);
    L25:
        if (this.N > 0.0f) goto L27;
    L36:
        r12.setColor(this.A0);
        r12.setStyle(Paint.Style.FILL);
        r13.set(r15);
        if (this.Q0 == true) goto L39;
        r24.drawRoundRect(r13, s(), s(), r12);
    L41:
        if (U() == false) goto L44;
        p(r15, r13);
        float r16 = r13.left;
        float r17 = r13.top;
        r24.translate(r16, r17);
        this.R.setBounds(0, 0, (int) r13.width(), (int) r13.height());
        this.R.draw(r24);
        r24.translate(-r16, -r17);
    L44:
        if (T() == false) goto L47;
        p(r15, r13);
        float r18 = r13.left;
        float r19 = r13.top;
        r24.translate(r18, r19);
        this.d0.setBounds(0, 0, (int) r13.width(), (int) r13.height());
        this.d0.draw(r24);
        r24.translate(-r18, -r19);
    L47:
        if (this.O0 == true) goto L49;
    L82:
        RectF r110 = r13;
        int r20 = r11;
        int r21 = 0;
        int r22 = 255;
    L84:
        if (V() == false) goto L95;
        r110.setEmpty();
        if (V() == false) goto L92;
        float r23 = this.f4587o0 + this.f4586n0;
        if (b0.a.c.a(this) != 0) goto L90;
        float r25 = r15.right - r23;
        RectF r26 = r110;
        r26.right = r25;
        r26.left = r25 - this.Z;
    L91:
        float r27 = r15.exactCenterY();
        float r28 = this.Z;
        float r29 = r27 - (r28 / 2.0f);
        r26.top = r29;
        r26.bottom = r29 + r28;
    L93:
        float r30 = r26.left;
        float r31 = r26.top;
        r24.translate(r30, r31);
        this.W.setBounds(r21, r21, (int) r26.width(), (int) r26.height());
        this.X.setBounds(this.W.getBounds());
        this.X.jumpToCurrentState();
        this.X.draw(r24);
        r24.translate(-r30, -r31);
        goto L95
    L90:
        r26 = r110;
        float r32 = r15.left + r23;
        r26.left = r32;
        r26.right = r32 + this.Z;
        goto L91
    L92:
        r26 = r110;
    L95:
        if (this.E0 >= r22) goto L99;
        r24.restoreToCount(r20);
        return;
    L99:
        return;
    L49:
        if (this.P == null) goto L82;
        PointF r33 = this.f4592t0;
        r33.set(0.0f, 0.0f);
        Paint.Align r34 = Paint.Align.LEFT;
        CharSequence r35 = this.P;
        j r36 = this.f4594v0;
        if (r35 == null) goto L57;
        float r37 = (q() + this.f4580h0) + this.f4583k0;
        if (b0.a.c.a(this) != 0) goto L55;
        r33.x = r15.left + r37;
        r34 = Paint.Align.LEFT;
    L56:
        float r38 = r15.centerY();
        TextPaint r39 = r36.f4879a;
        Paint.FontMetrics r40 = this.f4590r0;
        r39.getFontMetrics(r40);
        r33.y = r38 - ((r40.descent + r40.ascent) / 2.0f);
        goto L57
    L55:
        r33.x = r15.right - r37;
        r34 = Paint.Align.RIGHT;
    L57:
        r13.setEmpty();
        if (this.P == null) goto L64;
        float r41 = (q() + this.f4580h0) + this.f4583k0;
        float r42 = (r() + this.f4587o0) + this.f4584l0;
        if (b0.a.c.a(this) != 0) goto L62;
        r13.left = r15.left + r41;
        float r43 = r15.right - r42;
    L63:
        r13.right = r43;
        r13.top = r15.top;
        r13.bottom = r15.bottom;
        goto L64
    L62:
        r13.left = r15.left + r42;
        r43 = r15.right - r41;
    L64:
        d r44 = r36.f4884f;
        TextPaint r45 = r36.f4879a;
        if (r44 == null) goto L67;
        r45.drawableState = getState();
        r36.f4884f.e(this.f4588p0, r45, r36.f4880b);
    L67:
        r45.setTextAlign(r34);
        if (Math.round(r36.a(this.P.toString())) <= Math.round(r13.width())) goto L70;
        boolean r46 = true;
    L71:
        if (r46 == false) goto L73;
        int r47 = r24.save();
        r24.clipRect(r13);
    L74:
        CharSequence r48 = this.P;
        if (r46 == true) goto L77;
    L79:
        CharSequence r49 = r48;
        int r50 = r49.length();
        float r51 = r33.x;
        float r52 = r33.y;
        r110 = r13;
        r20 = r11;
        r21 = 0;
        r22 = 255;
        r24.drawText(r49, 0, r50, r51, r52, r45);
        if (r46 == false) goto L84;
        r24.restoreToCount(r47);
        goto L84
    L77:
        if (this.N0 == null) goto L79;
        r48 = TextUtils.ellipsize(r48, r45, r13.width(), this.N0);
        goto L79
    L73:
        r47 = 0;
        goto L74
    L70:
        r46 = false;
        goto L71
    L39:
        RectF r53 = new RectF(r15);
        Path r54 = this.f4593u0;
        k r55 = this.B;
        f.b r56 = this.f139a;
        r55.a(r56.f156a, r56.f165j, r53, this.A, r54);
        f(r24, r12, r54, this.f139a.f156a, h());
        goto L41
    L27:
        if (this.Q0 == true) goto L36;
        r12.setColor(this.f4598z0);
        r12.setStyle(Paint.Style.STROKE);
        if (this.Q0 == true) goto L35;
        ColorFilter r57 = this.F0;
        if (r57 != null) goto L34;
        r57 = this.G0;
    L34:
        r12.setColorFilter(r57);
    L35:
        float r58 = r15.left;
        float r59 = this.N / 2.0f;
        r13.set(r58 + r59, r15.top + r59, r15.right - r59, r15.bottom - r59);
        float r60 = this.L - (this.N / 2.0f);
        r24.drawRoundRect(r13, r60, r60, r12);
        goto L36
    L10:
        r11 = 0;
        goto L11
    }

    @Override // aa.f, android.graphics.drawable.Drawable
    public final int getAlpha() {
        return this.E0;
    }

    @Override // android.graphics.drawable.Drawable
    public final ColorFilter getColorFilter() {
        return this.F0;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return (int) this.K;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        float r8 = this.f4580h0;
        float r10 = (q() + r8) + this.f4583k0;
        String r11 = this.P.toString();
        float r12 = (this.f4594v0.a(r11) + r10) + this.f4584l0;
        return Math.min(Math.round((r() + r12) + this.f4587o0), this.P0);
    }

    @Override // aa.f, android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    @Override // aa.f, android.graphics.drawable.Drawable
    @TargetApi(21)
    public final void getOutline(Outline r10) {
        if (this.Q0 == false) goto L6;
        super.getOutline(r10);
        return;
    L6:
        Rect r8 = getBounds();
        if (r8.isEmpty() == true) goto L9;
        r10.setRoundRect(r8, this.L);
    L10:
        r10.setAlpha(this.E0 / 255.0f);
        return;
    L9:
        r10.setRoundRect(0, 0, getIntrinsicWidth(), (int) this.K, this.L);
        goto L10
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void invalidateDrawable(Drawable r8) {
        Drawable.Callback r10 = getCallback();
        if (r10 == null) goto L6;
        r10.invalidateDrawable(this);
        return;
    }

    @Override // aa.f, android.graphics.drawable.Drawable
    public final boolean isStateful() {
        if (u(this.I) == false) goto L5;
        return true;
    L5:
        if (u(this.J) == false) goto L7;
        return true;
    L7:
        if (u(this.M) == false) goto L9;
        return true;
    L9:
        if (this.K0 == true) goto L11;
    L12:
        d r8 = this.f4594v0.f4884f;
        if (r8 == null) goto L19;
        ColorStateList r10 = r8.f13753j;
        if (r10 == null) goto L19;
        if (r10.isStateful() == false) goto L19;
        boolean r11 = true;
    L20:
        if (r11 == false) goto L22;
        return true;
    L22:
        if (this.f4576c0 == true) goto L24;
    L28:
        boolean r12 = false;
    L29:
        if (r12 == false) goto L31;
        return true;
    L31:
        if (v(this.R) == false) goto L33;
        return true;
    L33:
        if (v(this.d0) == false) goto L35;
        return true;
    L35:
        if (u(this.H0) == false) goto L38;
        return true;
    L38:
        return false;
    L24:
        if (this.d0 == null) goto L28;
        if (this.f4575b0 == false) goto L28;
        r12 = true;
    L19:
        r11 = false;
        goto L20
    L11:
        if (u(this.L0) == false) goto L12;
        return true;
    }

    public final void o(Drawable r8) {
        if (r8 != null) goto L4;
        return;
    L4:
        r8.setCallback(this);
        b0.a.c.b(r8, b0.a.c.a(this));
        r8.setLevel(getLevel());
        r8.setVisible(isVisible(), false);
        if (r8 == this.W) goto L7;
        Drawable r10 = this.R;
        if (r8 != r10) goto L17;
        if (this.U == false) goto L17;
        b0.a.b.h(r10, this.S);
    L17:
        if (r8.isStateful() == false) goto L20;
        r8.setState(getState());
        return;
    L20:
        return;
    L7:
        if (r8.isStateful() == false) goto L9;
        r8.setState(this.J0);
    L9:
        b0.a.b.h(r8, this.Y);
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onLayoutDirectionChanged(int r8) {
        boolean r10 = super.onLayoutDirectionChanged(r8);
        if (U() == false) goto L6;
        r10 = r10 | b0.a.c.b(this.R, r8);
    L6:
        if (T() == false) goto L9;
        r10 = r10 | b0.a.c.b(this.d0, r8);
    L9:
        if (V() == false) goto L11;
        r10 = r10 | b0.a.c.b(this.W, r8);
    L11:
        if (r10 == false) goto L15;
        invalidateSelf();
        return true;
    L15:
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onLevelChange(int r8) {
        boolean r10 = super.onLevelChange(r8);
        if (U() == false) goto L6;
        r10 = r10 | this.R.setLevel(r8);
    L6:
        if (T() == false) goto L9;
        r10 = r10 | this.d0.setLevel(r8);
    L9:
        if (V() == false) goto L11;
        r10 = r10 | this.W.setLevel(r8);
    L11:
        if (r10 == false) goto L13;
        invalidateSelf();
    L13:
        return r10;
    }

    @Override // aa.f, android.graphics.drawable.Drawable
    public final boolean onStateChange(int[] r8) {
        if (this.Q0 == false) goto L6;
        super.onStateChange(r8);
    L6:
        return x(r8, this.J0);
    }

    public final void p(Rect r8, RectF r10) {
        r10.setEmpty();
        if (U() == false) goto L5;
    L6:
        float r11 = this.f4580h0 + this.f4581i0;
        float r12 = t();
        if (b0.a.c.a(this) != 0) goto L9;
        float r13 = r8.left + r11;
        r10.left = r13;
        r10.right = r13 + r12;
    L11:
        if (this.C0 == false) goto L13;
        Drawable r14 = this.d0;
    L14:
        float r15 = this.T;
        if (r15 > 0.0f) goto L21;
        if (r14 == null) goto L21;
        float r16 = (float) Math.ceil(TypedValue.applyDimension(1, 24, this.f4588p0.getResources().getDisplayMetrics()));
        if (r14.getIntrinsicHeight() > r16) goto L20;
        r16 = r14.getIntrinsicHeight();
    L20:
        r15 = r16;
    L21:
        float r17 = r8.exactCenterY() - (r15 / 2.0f);
        r10.top = r17;
        r10.bottom = r17 + r15;
        return;
    L13:
        r14 = this.R;
        goto L14
    L9:
        float r18 = r8.right - r11;
        r10.right = r18;
        r10.left = r18 - r12;
        goto L11
    L5:
        if (T() == true) goto L6;
    }

    public final float q() {
        if (U() == false) goto L5;
    L9:
        float r8 = this.f4581i0;
        return (t() + r8) + this.f4582j0;
    L5:
        if (T() == true) goto L9;
        return 0.0f;
    }

    public final float r() {
        if (V() == true) goto L5;
        return 0.0f;
    L5:
        return (this.f4585m0 + this.Z) + this.f4586n0;
    }

    public final float s() {
        if (this.Q0 == false) goto L6;
        return this.f139a.f156a.f184e.a(h());
    L6:
        return this.L;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void scheduleDrawable(Drawable r8, Runnable r10, long r11) {
        Drawable.Callback r12 = getCallback();
        if (r12 == null) goto L6;
        r12.scheduleDrawable(this, r10, r11);
        return;
    }

    @Override // aa.f, android.graphics.drawable.Drawable
    public final void setAlpha(int r8) {
        if (this.E0 == r8) goto L6;
        this.E0 = r8;
        invalidateSelf();
        return;
    }

    @Override // aa.f, android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter r8) {
        if (this.F0 == r8) goto L6;
        this.F0 = r8;
        invalidateSelf();
        return;
    }

    @Override // aa.f, android.graphics.drawable.Drawable
    public final void setTintList(ColorStateList r8) {
        if (this.H0 == r8) goto L6;
        this.H0 = r8;
        onStateChange(getState());
        return;
    }

    @Override // aa.f, android.graphics.drawable.Drawable
    public final void setTintMode(PorterDuff.Mode r8) {
        if (this.I0 == r8) goto L12;
        this.I0 = r8;
        ColorStateList r10 = this.H0;
        if (r10 == null) goto L9;
        if (r8 == null) goto L9;
        PorterDuffColorFilter r11 = new PorterDuffColorFilter(r10.getColorForState(getState(), 0), r8);
    L10:
        this.G0 = r11;
        invalidateSelf();
        return;
    L9:
        r11 = null;
        goto L10
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean setVisible(boolean r8, boolean r10) {
        boolean r11 = super.setVisible(r8, r10);
        if (U() == false) goto L6;
        r11 = r11 | this.R.setVisible(r8, r10);
    L6:
        if (T() == false) goto L9;
        r11 = r11 | this.d0.setVisible(r8, r10);
    L9:
        if (V() == false) goto L11;
        r11 = r11 | this.W.setVisible(r8, r10);
    L11:
        if (r11 == false) goto L13;
        invalidateSelf();
    L13:
        return r11;
    }

    public final float t() {
        if (this.C0 == false) goto L5;
        Drawable r8 = this.d0;
    L6:
        float r10 = this.T;
        if (r10 > 0.0f) goto L11;
        if (r8 != null) goto L10;
        return r10;
    L10:
        return r8.getIntrinsicWidth();
    L11:
        return r10;
    L5:
        r8 = this.R;
        goto L6
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void unscheduleDrawable(Drawable r8, Runnable r10) {
        Drawable.Callback r11 = getCallback();
        if (r11 == null) goto L6;
        r11.unscheduleDrawable(this, r10);
        return;
    }

    public final void w() {
        InterfaceC0050a r8 = this.M0.get();
        if (r8 == null) goto L6;
        r8.a();
        return;
    }

    public final boolean x(int[] r10, int[] r11) {
        boolean r8 = super.onStateChange(r10);
        ColorStateList r12 = this.I;
        if (r12 == null) goto L5;
        int r13 = r12.getColorForState(r10, this.f4595w0);
    L6:
        int r14 = d(r13);
        boolean r15 = true;
        if (this.f4595w0 == r14) goto L9;
        this.f4595w0 = r14;
        r8 = true;
    L9:
        ColorStateList r16 = this.J;
        if (r16 == null) goto L12;
        int r17 = r16.getColorForState(r10, this.f4596x0);
    L13:
        int r18 = d(r17);
        if (this.f4596x0 == r18) goto L16;
        this.f4596x0 = r18;
        r8 = true;
    L16:
        int r19 = a0.a.c(r18, r14);
        if (this.f4597y0 == r19) goto L19;
        boolean r20 = true;
    L21:
        if (this.f139a.f158c != null) goto L23;
        boolean r21 = true;
    L25:
        if ((r20 | r21) == false) goto L27;
        this.f4597y0 = r19;
        k(ColorStateList.valueOf(r19));
        r8 = true;
    L27:
        ColorStateList r22 = this.M;
        if (r22 == null) goto L30;
        int r23 = r22.getColorForState(r10, this.f4598z0);
    L32:
        if (this.f4598z0 == r23) goto L35;
        this.f4598z0 = r23;
        r8 = true;
    L35:
        if (this.L0 != null) goto L37;
    L39:
        int r24 = 0;
    L41:
        if (this.A0 == r24) goto L45;
        this.A0 = r24;
        if (this.K0 == false) goto L45;
        r8 = true;
    L45:
        d r25 = this.f4594v0.f4884f;
        if (r25 == null) goto L50;
        ColorStateList r26 = r25.f13753j;
        if (r26 == null) goto L50;
        int r27 = r26.getColorForState(r10, this.B0);
    L52:
        if (this.B0 == r27) goto L54;
        this.B0 = r27;
        r8 = true;
    L54:
        int[] r28 = getState();
        if (r28 == null) goto L63;
        int r29 = r28.length;
        int r30 = 0;
    L58:
        if (r30 >= r29) goto L63;
        if (r28[r30] == 16842912) goto L61;
        r30 = r30 + 1;
        goto L58
    L61:
        boolean r31 = true;
    L64:
        if (r31 == true) goto L66;
    L68:
        boolean r32 = false;
    L70:
        if (this.C0 != r32) goto L72;
    L77:
        boolean r33 = false;
    L78:
        ColorStateList r34 = this.H0;
        if (r34 == null) goto L81;
        int r35 = r34.getColorForState(r10, this.D0);
    L83:
        if (this.D0 == r35) goto L91;
        this.D0 = r35;
        ColorStateList r36 = this.H0;
        PorterDuff.Mode r37 = this.I0;
        if (r36 == null) goto L89;
        if (r37 == null) goto L89;
        PorterDuffColorFilter r38 = new PorterDuffColorFilter(r36.getColorForState(getState(), 0), r37);
    L90:
        this.G0 = r38;
    L93:
        if (v(this.R) == false) goto L96;
        r15 = r15 | this.R.setState(r10);
    L96:
        if (v(this.d0) == false) goto L99;
        r15 = r15 | this.d0.setState(r10);
    L99:
        if (v(this.W) == false) goto L102;
        int[] r39 = new int[r10.length + r11.length];
        System.arraycopy(r10, 0, r39, 0, r10.length);
        System.arraycopy(r11, 0, r39, r10.length, r11.length);
        r15 = r15 | this.W.setState(r39);
    L102:
        if (v(this.X) == false) goto L104;
        r15 = r15 | this.X.setState(r11);
    L104:
        if (r15 == false) goto L106;
        invalidateSelf();
    L106:
        if (r33 == false) goto L108;
        w();
    L108:
        return r15;
    L89:
        r38 = null;
        goto L90
    L91:
        r15 = r8;
        goto L93
    L81:
        r35 = 0;
        goto L83
    L72:
        if (this.d0 == null) goto L77;
        float r40 = q();
        this.C0 = r32;
        if (r40 == q()) goto L76;
        r8 = true;
        r33 = true;
        goto L78
    L76:
        r33 = false;
        r8 = true;
        goto L78
    L66:
        if (this.f4575b0 == false) goto L68;
        r32 = true;
    L63:
        r31 = false;
    L50:
        r27 = 0;
        goto L52
    L37:
        if (y9.a.a(r10) == false) goto L39;
        r24 = this.L0.getColorForState(r10, this.A0);
        goto L41
    L30:
        r23 = 0;
        goto L32
    L23:
        r21 = false;
        goto L25
    L19:
        r20 = false;
        goto L21
    L12:
        r17 = 0;
        goto L13
    L5:
        r13 = 0;
        goto L6
    }

    public final void y(boolean r8) {
        if (this.f4575b0 == r8) goto L13;
        this.f4575b0 = r8;
        float r10 = q();
        if (r8 == false) goto L7;
    L9:
        float r11 = q();
        invalidateSelf();
        if (r10 == r11) goto L14;
        w();
        return;
    L14:
        return;
    L7:
        if (this.C0 == false) goto L9;
        this.C0 = false;
        goto L9
    }

    public final void z(Drawable r8) {
        if (this.d0 == r8) goto L8;
        float r10 = q();
        this.d0 = r8;
        float r11 = q();
        W(this.d0);
        o(this.d0);
        invalidateSelf();
        if (r10 == r11) goto L9;
        w();
        return;
    L9:
        return;
    }
}
