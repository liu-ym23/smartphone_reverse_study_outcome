package com.google.android.material.internal;

import android.animation.TimeInterpolator;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.math.MathUtils;
import androidx.core.text.TextDirectionHeuristicCompat;
import androidx.core.text.TextDirectionHeuristicsCompat;
import androidx.core.util.Preconditions;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.resources.TextAppearance;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class b {

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    private static final boolean f3383t0 = false;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    @NonNull
    private static final Paint f3384u0 = null;
    private Typeface A;
    private Typeface B;
    private Typeface C;
    private Typeface D;
    private com.google.android.material.resources.a E;
    private com.google.android.material.resources.a F;

    @Nullable
    private CharSequence G;

    @Nullable
    private CharSequence H;
    private boolean I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private boolean f3385J;
    private boolean K;

    @Nullable
    private Bitmap L;
    private Paint M;
    private float N;
    private float O;
    private float P;
    private float Q;
    private float R;
    private int S;
    private int[] T;
    private boolean U;

    @NonNull
    private final TextPaint V;

    @NonNull
    private final TextPaint W;
    private TimeInterpolator X;
    private TimeInterpolator Y;
    private float Z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final View f3386a;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    private float f3387a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f3388b;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    private float f3389b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private float f3390c;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    private ColorStateList f3391c0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f3392d;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    private float f3393d0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private float f3394e;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    private float f3395e0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private float f3396f;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    private float f3397f0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f3398g;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    private ColorStateList f3399g0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NonNull
    private final Rect f3400h;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    private float f3401h0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NonNull
    private final Rect f3402i;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    private float f3403i0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NonNull
    private final RectF f3404j;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    private float f3405j0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f3406k;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    private StaticLayout f3407k0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f3408l;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    private float f3409l0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private float f3410m;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    private float f3411m0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private float f3412n;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    private float f3413n0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private ColorStateList f3414o;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    private CharSequence f3415o0;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private ColorStateList f3416p;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    private int f3417p0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f3418q;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    private float f3419q0;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private float f3420r;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    private float f3421r0;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private float f3422s;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    private int f3423s0;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private float f3424t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private float f3425u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private float f3426v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private float f3427w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private Typeface f3428x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private Typeface f3429y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private Typeface f3430z;

    class a implements com.google.android.material.resources.a.InterfaceC0084a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f3431a;

        a(b r10) {
            this.f3431a = r10;
        }

        @Override // com.google.android.material.resources.a.InterfaceC0084a
        public void a(Typeface r10) {
            this.f3431a.h0(r10);
        }
    }

    /* JADX INFO: renamed from: com.google.android.material.internal.b$b, reason: collision with other inner class name */
    class C0082b implements com.google.android.material.resources.a.InterfaceC0084a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f3432a;

        C0082b(b r10) {
            this.f3432a = r10;
        }

        @Override // com.google.android.material.resources.a.InterfaceC0084a
        public void a(Typeface r10) {
            this.f3432a.s0(r10);
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 18) goto L5;
        boolean r10 = true;
    L6:
        f3383t0 = r10;
        f3384u0 = null;
        return;
    L5:
        r10 = false;
        goto L6
    }

    public b(View r10) {
        this.f3406k = 16;
        this.f3408l = 16;
        this.f3410m = 15.0f;
        this.f3412n = 15.0f;
        this.f3385J = true;
        this.f3417p0 = 1;
        this.f3419q0 = 0.0f;
        this.f3421r0 = 1.0f;
        this.f3423s0 = StaticLayoutBuilderCompat.f3350n;
        this.f3386a = r10;
        TextPaint r11 = new TextPaint(129);
        this.V = r11;
        this.W = new TextPaint(r11);
        this.f3402i = new Rect();
        this.f3400h = new Rect();
        this.f3404j = new RectF();
        this.f3396f = e();
        V(r10.getContext().getResources().getConfiguration());
    }

    private boolean I0() {
        if (this.f3417p0 > 1) goto L5;
    L11:
        return false;
    L5:
        if (this.I == false) goto L9;
        if (this.f3392d == false) goto L11;
    L9:
        if (this.K == true) goto L11;
        return true;
    }

    private Layout.Alignment K() {
        int r10 = GravityCompat.getAbsoluteGravity(this.f3406k, this.I ? 1 : 0) & 7;
        if (r10 == 1) goto L15;
        boolean r11 = this.I;
        if (r10 == 5) goto L10;
        if (r11 == false) goto L9;
        return Layout.Alignment.ALIGN_OPPOSITE;
    L9:
        return Layout.Alignment.ALIGN_NORMAL;
    L10:
        if (r11 == false) goto L13;
        return Layout.Alignment.ALIGN_NORMAL;
    L13:
        return Layout.Alignment.ALIGN_OPPOSITE;
    L15:
        return Layout.Alignment.ALIGN_CENTER;
    }

    private void N(@NonNull TextPaint r10) {
        r10.setTextSize(this.f3412n);
        r10.setTypeface(this.f3428x);
        if (Build.VERSION.SDK_INT < 21) goto L6;
        r10.setLetterSpacing(this.f3401h0);
        return;
    }

    private void O(@NonNull TextPaint r10) {
        r10.setTextSize(this.f3410m);
        r10.setTypeface(this.A);
        if (Build.VERSION.SDK_INT < 21) goto L6;
        r10.setLetterSpacing(this.f3403i0);
        return;
    }

    private void P(float r10) {
        if (this.f3392d == false) goto L9;
        RectF r11 = this.f3404j;
        if (r10 >= this.f3396f) goto L7;
        Rect r12 = this.f3400h;
    L8:
        r11.set(r12);
        return;
    L7:
        r12 = this.f3402i;
        goto L8
    L9:
        this.f3404j.left = U(this.f3400h.left, this.f3402i.left, r10, this.X);
        this.f3404j.top = U(this.f3420r, this.f3422s, r10, this.X);
        this.f3404j.right = U(this.f3400h.right, this.f3402i.right, r10, this.X);
        this.f3404j.bottom = U(this.f3400h.bottom, this.f3402i.bottom, r10, this.X);
    }

    private static boolean Q(float r10, float r11) {
        if (Math.abs(r10 - r11) >= 1.0E-5f) goto L5;
        return true;
    L5:
        return false;
    }

    private boolean R() {
        if (ViewCompat.getLayoutDirection(this.f3386a) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    private boolean T(@NonNull CharSequence r10, boolean r11) {
        if (r11 == false) goto L4;
        TextDirectionHeuristicCompat r12 = TextDirectionHeuristicsCompat.FIRSTSTRONG_RTL;
    L6:
        return r12.isRtl(r10, 0, r10.length());
    L4:
        r12 = TextDirectionHeuristicsCompat.FIRSTSTRONG_LTR;
        goto L6
    }

    private static float U(float r10, float r11, float r12, @Nullable TimeInterpolator r13) {
        if (r13 == null) goto L5;
        r12 = r13.getInterpolation(r12);
    L5:
        return r5.a.a(r10, r11, r12);
    }

    private float W(TextPaint r10, CharSequence r11) {
        return r10.measureText(r11, 0, r11.length());
    }

    @ColorInt
    private static int a(@ColorInt int r10, @ColorInt int r11, @FloatRange(from = 0.0d, to = 1.0d) float r12) {
        float r13 = 1.0f - r12;
        return Color.argb(Math.round((Color.alpha(r10) * r13) + (Color.alpha(r11) * r12)), Math.round((Color.red(r10) * r13) + (Color.red(r11) * r12)), Math.round((Color.green(r10) * r13) + (Color.green(r11) * r12)), Math.round((Color.blue(r10) * r13) + (Color.blue(r11) * r12)));
    }

    private static boolean a0(@NonNull Rect r10, int r11, int r12, int r13, int r14) {
        if (r10.left == r11) goto L5;
    L11:
        return false;
    L5:
        if (r10.top != r12) goto L11;
        if (r10.right != r13) goto L11;
        if (r10.bottom != r14) goto L11;
        return true;
    }

    private void b(boolean r10) {
        i(1.0f, r10);
        CharSequence r11 = this.H;
        if (r11 == null) goto L7;
        StaticLayout r12 = this.f3407k0;
        if (r12 == null) goto L7;
        this.f3415o0 = TextUtils.ellipsize(r11, this.V, r12.getWidth(), TextUtils.TruncateAt.END);
    L7:
        CharSequence r13 = this.f3415o0;
        float r14 = 0.0f;
        if (r13 == null) goto L10;
        this.f3409l0 = W(this.V, r13);
    L11:
        int r15 = GravityCompat.getAbsoluteGravity(this.f3408l, this.I ? 1 : 0);
        int r16 = r15 & 112;
        if (r16 == 48) goto L16;
        if (r16 == 80) goto L15;
        this.f3422s = this.f3402i.centerY() - ((this.V.descent() - this.V.ascent()) / 2.0f);
    L18:
        int r17 = r15 & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        if (r17 == 1) goto L23;
        if (r17 == 5) goto L22;
        float r18 = this.f3402i.left;
    L25:
        this.f3425u = r18;
        i(0.0f, r10);
        StaticLayout r19 = this.f3407k0;
        if (r19 == null) goto L28;
        float r110 = r19.getHeight();
    L29:
        StaticLayout r20 = this.f3407k0;
        if (r20 != null) goto L32;
    L34:
        CharSequence r21 = this.H;
        if (r21 == null) goto L37;
        r14 = W(this.V, r21);
    L37:
        StaticLayout r22 = this.f3407k0;
        if (r22 == null) goto L40;
        int r23 = r22.getLineCount();
    L41:
        this.f3418q = r23;
        int r24 = GravityCompat.getAbsoluteGravity(this.f3406k, this.I ? 1 : 0);
        int r25 = r24 & 112;
        if (r25 == 48) goto L47;
        if (r25 == 80) goto L46;
        float r26 = this.f3400h.centerY() - (r110 / 2.0f);
    L45:
        this.f3420r = r26;
    L48:
        int r111 = r24 & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        if (r111 == 1) goto L53;
        if (r111 == 5) goto L52;
        float r112 = this.f3400h.left;
    L55:
        this.f3424t = r112;
        j();
        y0(this.f3390c);
        return;
    L52:
        float r113 = this.f3400h.right;
    L54:
        r112 = r113 - r14;
        goto L55
    L53:
        r113 = this.f3400h.centerX();
        r14 = r14 / 2.0f;
        goto L54
    L46:
        r26 = (this.f3400h.bottom - r110) + this.V.descent();
        goto L45
    L47:
        this.f3420r = this.f3400h.top;
        goto L48
    L40:
        r23 = 0;
        goto L41
    L32:
        if (this.f3417p0 <= 1) goto L34;
        r14 = r20.getWidth();
        goto L37
    L28:
        r110 = 0.0f;
        goto L29
    L22:
        float r27 = this.f3402i.right;
        float r28 = this.f3409l0;
    L24:
        r18 = r27 - r28;
        goto L25
    L23:
        r27 = this.f3402i.centerX();
        r28 = this.f3409l0 / 2.0f;
        goto L24
    L15:
        float r29 = this.f3402i.bottom + this.V.ascent();
    L17:
        this.f3422s = r29;
        goto L18
    L16:
        r29 = this.f3402i.top;
        goto L17
    L10:
        this.f3409l0 = 0.0f;
        goto L11
    }

    private void c() {
        g(this.f3390c);
    }

    private float d(@FloatRange(from = 0.0d, to = 1.0d) float r10) {
        float r11 = this.f3396f;
        if (r10 > r11) goto L7;
        return r5.a.b(1.0f, 0.0f, this.f3394e, r11, r10);
    L7:
        return r5.a.b(0.0f, 1.0f, r11, 1.0f, r10);
    }

    private float e() {
        float r10 = this.f3394e;
        return r10 + ((1.0f - r10) * 0.5f);
    }

    private void e0(float r10) {
        this.f3411m0 = r10;
        ViewCompat.postInvalidateOnAnimation(this.f3386a);
    }

    private boolean f(@NonNull CharSequence r10) {
        boolean r11 = R();
        if (this.f3385J == true) goto L5;
        return r11;
    L5:
        return T(r10, r11);
    }

    private void g(float r10) {
        P(r10);
        if (this.f3392d == true) goto L5;
        this.f3426v = U(this.f3424t, this.f3425u, r10, this.X);
        this.f3427w = U(this.f3420r, this.f3422s, r10, this.X);
        y0(r10);
        float r11 = r10;
    L9:
        TimeInterpolator r12 = r5.a.f12674b;
        e0(1.0f - U(0.0f, 1.0f, 1.0f - r10, r12));
        o0(U(1.0f, 0.0f, r10, r12));
        if (this.f3416p == this.f3414o) goto L12;
        this.V.setColor(a(x(), v(), r11));
    L14:
        if (Build.VERSION.SDK_INT < 21) goto L19;
        float r13 = this.f3401h0;
        float r14 = this.f3403i0;
        if (r13 == r14) goto L18;
        this.V.setLetterSpacing(U(r14, r13, r10, r12));
        goto L19
    L18:
        this.V.setLetterSpacing(r13);
    L19:
        this.P = U(this.f3393d0, this.Z, r10, null);
        this.Q = U(this.f3395e0, this.f3387a0, r10, null);
        this.R = U(this.f3397f0, this.f3389b0, r10, null);
        int r15 = a(w(this.f3399g0), w(this.f3391c0), r10);
        this.S = r15;
        this.V.setShadowLayer(this.P, this.Q, this.R, r15);
        if (this.f3392d == false) goto L22;
        this.V.setAlpha((int) (d(r10) * this.V.getAlpha()));
    L22:
        ViewCompat.postInvalidateOnAnimation(this.f3386a);
        return;
    L12:
        this.V.setColor(v());
        goto L14
    L5:
        if (r10 >= this.f3396f) goto L7;
        this.f3426v = this.f3424t;
        this.f3427w = this.f3420r;
        y0(0.0f);
        r11 = 0.0f;
        goto L9
    L7:
        this.f3426v = this.f3425u;
        this.f3427w = this.f3422s - Math.max(0, this.f3398g);
        y0(1.0f);
        r11 = 1.0f;
        goto L9
    }

    private void h(float r10) {
        i(r10, false);
    }

    private void i(float r13, boolean r14) {
        if (this.G != null) goto L5;
        return;
    L5:
        float r10 = this.f3402i.width();
        float r11 = this.f3400h.width();
        boolean r12 = false;
        int r15 = 1;
        if (Q(r13, 1.0f) == false) goto L11;
        float r16 = this.f3412n;
        float r17 = this.f3401h0;
        this.N = 1.0f;
        Typeface r18 = this.D;
        Typeface r19 = this.f3428x;
        if (r18 == r19) goto L10;
        this.D = r19;
        boolean r20 = true;
    L27:
        if (r10 <= 0.0f) goto L46;
        if (this.O == r16) goto L31;
        boolean r21 = true;
    L33:
        if (this.f3405j0 == r17) goto L35;
        boolean r22 = true;
    L36:
        if (r21 == true) goto L43;
        if (r22 == true) goto L43;
        if (this.U == true) goto L43;
        if (r20 == true) goto L43;
        r20 = false;
    L44:
        this.O = r16;
        this.f3405j0 = r17;
        this.U = false;
    L43:
        r20 = true;
        goto L44
    L35:
        r22 = false;
        goto L36
    L31:
        r21 = false;
    L46:
        if (this.H == null) goto L48;
        if (r20 == true) goto L48;
        return;
    L48:
        this.V.setTextSize(this.O);
        this.V.setTypeface(this.D);
        if (Build.VERSION.SDK_INT < 21) goto L51;
        this.V.setLetterSpacing(this.f3405j0);
    L51:
        TextPaint r110 = this.V;
        if (this.N == 1.0f) goto L54;
        r12 = true;
    L54:
        r110.setLinearText(r12);
        this.I = f(this.G);
        if (I0() == false) goto L57;
        r15 = this.f3417p0;
    L57:
        StaticLayout r111 = k(r15, r10, this.I);
        this.f3407k0 = r111;
        this.H = r111.getText();
        return;
    L10:
        r20 = false;
        goto L27
    L11:
        float r23 = this.f3410m;
        float r24 = this.f3403i0;
        Typeface r25 = this.D;
        Typeface r26 = this.A;
        if (r25 == r26) goto L14;
        this.D = r26;
        boolean r27 = true;
    L16:
        if (Q(r13, 0.0f) == false) goto L18;
        this.N = 1.0f;
    L19:
        float r112 = this.f3412n / this.f3410m;
        float r28 = r11 * r112;
        if (r14 == false) goto L24;
    L21:
        r10 = r11;
    L22:
        r16 = r23;
        r17 = r24;
        r20 = r27;
        goto L27
    L24:
        if (r28 <= r10) goto L21;
        r10 = Math.min(r10 / r112, r11);
        goto L22
    L18:
        this.N = U(this.f3410m, this.f3412n, r13, this.Y) / this.f3410m;
        goto L19
    L14:
        r27 = false;
        goto L16
    }

    private boolean i0(Typeface r10) {
        com.google.android.material.resources.a r11 = this.F;
        if (r11 == null) goto L6;
        r11.c();
    L6:
        if (this.f3430z == r10) goto L12;
        this.f3430z = r10;
        Typeface r12 = com.google.android.material.resources.f.b(this.f3386a.getContext().getResources().getConfiguration(), r10);
        this.f3429y = r12;
        if (r12 != null) goto L10;
        r12 = this.f3430z;
    L10:
        this.f3428x = r12;
        return true;
    L12:
        return false;
    }

    private void j() {
        Bitmap r10 = this.L;
        if (r10 == null) goto L6;
        r10.recycle();
        this.L = null;
        return;
    }

    private StaticLayout k(int r10, float r11, boolean r12) {
        if (r10 != 1) goto L5;
        Layout.Alignment r13 = Layout.Alignment.ALIGN_NORMAL;     // Catch: StaticLayoutBuilderCompat.StaticLayoutBuilderCompatException -> L8
    L6:
        StaticLayout r14 = StaticLayoutBuilderCompat.c(this.G, this.V, (int) r11).e(TextUtils.TruncateAt.END).h(r12).d(r13).g(false).j(r10).i(this.f3419q0, this.f3421r0).f(this.f3423s0).a();     // Catch: StaticLayoutBuilderCompat.StaticLayoutBuilderCompatException -> L8
    L11:
        return (StaticLayout) Preconditions.checkNotNull(r14);
    L5:
        r13 = K();     // Catch: StaticLayoutBuilderCompat.StaticLayoutBuilderCompatException -> L8
    L8:
        e = move-exception;
        Log.e("CollapsingTextHelper", e.getCause().getMessage(), e);
        r14 = null;
        goto L11
    }

    private void m(@NonNull Canvas r15, float r16, float r17) {
        int r10 = this.V.getAlpha();
        r15.translate(r16, r17);
        float r11 = r10;
        this.V.setAlpha((int) (this.f3413n0 * r11));
        int r12 = Build.VERSION.SDK_INT;
        if (r12 < 31) goto L5;
        TextPaint r13 = this.V;
        r13.setShadowLayer(this.P, this.Q, this.R, t5.a.a(this.S, r13.getAlpha()));
    L5:
        this.f3407k0.draw(r15);
        this.V.setAlpha((int) (this.f3411m0 * r11));
        if (r12 < 31) goto L8;
        TextPaint r14 = this.V;
        r14.setShadowLayer(this.P, this.Q, this.R, t5.a.a(this.S, r14.getAlpha()));
    L8:
        int r18 = this.f3407k0.getLineBaseline(0);
        CharSequence r19 = this.f3415o0;
        float r20 = r18;
        r15.drawText(r19, 0, r19.length(), 0.0f, r20, this.V);
        if (r12 < 31) goto L12;
        this.V.setShadowLayer(this.P, this.Q, this.R, this.S);
    L12:
        if (this.f3392d == true) goto L18;
        String r21 = this.f3415o0.toString().trim();
        if (r21.endsWith("…") == false) goto L16;
        r21 = r21.substring(0, r21.length() - 1);
    L16:
        String r22 = r21;
        this.V.setAlpha(r10);
        r15.drawText(r22, 0, Math.min(this.f3407k0.getLineEnd(0), r22.length()), 0.0f, r20, this.V);
        return;
    }

    private void n() {
        if (this.L == null) goto L5;
        return;
    L5:
        if (this.f3400h.isEmpty() == false) goto L7;
        return;
    L7:
        if (TextUtils.isEmpty(this.H) == true) goto L21;
        g(0.0f);
        int r10 = this.f3407k0.getWidth();
        int r11 = this.f3407k0.getHeight();
        if (r10 <= 0) goto L19;
        if (r11 <= 0) goto L22;
        this.L = Bitmap.createBitmap(r10, r11, Bitmap.Config.ARGB_8888);
        Canvas r12 = new Canvas(this.L);
        this.f3407k0.draw(r12);
        if (this.M != null) goto L20;
        this.M = new Paint(3);
        return;
    L20:
        return;
    L22:
        return;
    L19:
        return;
    }

    private void o0(float r10) {
        this.f3413n0 = r10;
        ViewCompat.postInvalidateOnAnimation(this.f3386a);
    }

    private float s(int r10, int r11) {
        if (r11 == 17) goto L23;
        if ((r11 & 7) == 1) goto L23;
        if ((r11 & GravityCompat.END) == 8388613) goto L18;
        if ((r11 & 5) == 5) goto L18;
        if (this.I == false) goto L16;
        return this.f3402i.right - this.f3409l0;
    L16:
        return this.f3402i.left;
    L18:
        if (this.I == false) goto L21;
        return this.f3402i.left;
    L21:
        return this.f3402i.right - this.f3409l0;
    L23:
        return (r10 / 2.0f) - (this.f3409l0 / 2.0f);
    }

    private float t(@NonNull RectF r10, int r11, int r12) {
        if (r12 == 17) goto L23;
        if ((r12 & 7) == 1) goto L23;
        if ((r12 & GravityCompat.END) == 8388613) goto L18;
        if ((r12 & 5) == 5) goto L18;
        if (this.I == false) goto L16;
        return this.f3402i.right;
    L16:
        return this.f3409l0 + r10.left;
    L18:
        if (this.I == false) goto L21;
        return r10.left + this.f3409l0;
    L21:
        return this.f3402i.right;
    L23:
        return (r11 / 2.0f) + (this.f3409l0 / 2.0f);
    }

    private boolean t0(Typeface r10) {
        com.google.android.material.resources.a r11 = this.E;
        if (r11 == null) goto L6;
        r11.c();
    L6:
        if (this.C == r10) goto L12;
        this.C = r10;
        Typeface r12 = com.google.android.material.resources.f.b(this.f3386a.getContext().getResources().getConfiguration(), r10);
        this.B = r12;
        if (r12 != null) goto L10;
        r12 = this.C;
    L10:
        this.A = r12;
        return true;
    L12:
        return false;
    }

    @ColorInt
    private int w(@Nullable ColorStateList r10) {
        if (r10 != null) goto L5;
        return 0;
    L5:
        int[] r11 = this.T;
        if (r11 == null) goto L10;
        return r10.getColorForState(r11, 0);
    L10:
        return r10.getDefaultColor();
    }

    @ColorInt
    private int x() {
        return w(this.f3414o);
    }

    private void y0(float r10) {
        h(r10);
        if (f3383t0 == true) goto L5;
    L7:
        boolean r11 = false;
    L8:
        this.K = r11;
        if (r11 == false) goto L11;
        n();
    L11:
        ViewCompat.postInvalidateOnAnimation(this.f3386a);
        return;
    L5:
        if (this.N == 1.0f) goto L7;
        r11 = true;
        goto L8
    }

    public int A() {
        return this.f3406k;
    }

    @RequiresApi(23)
    public void A0(@FloatRange(from = 0.0d) float r10) {
        this.f3421r0 = r10;
    }

    public float B() {
        O(this.W);
        return -this.W.ascent();
    }

    public void B0(int r10) {
        if (r10 == this.f3417p0) goto L6;
        this.f3417p0 = r10;
        j();
        Y();
        return;
    }

    public Typeface C() {
        Typeface r10 = this.A;
        if (r10 == null) goto L6;
        return r10;
    L6:
        return Typeface.DEFAULT;
    }

    public void C0(TimeInterpolator r10) {
        this.X = r10;
        Y();
    }

    public float D() {
        return this.f3390c;
    }

    public void D0(boolean r10) {
        this.f3385J = r10;
    }

    public float E() {
        return this.f3396f;
    }

    public final boolean E0(int[] r10) {
        this.T = r10;
        if (S() == false) goto L6;
        Y();
        return true;
    L6:
        return false;
    }

    @RequiresApi(23)
    public int F() {
        return this.f3423s0;
    }

    public void F0(@Nullable CharSequence r10) {
        if (r10 != null) goto L4;
    L5:
        this.G = r10;
        this.H = null;
        j();
        Y();
        return;
    L4:
        if (TextUtils.equals(this.G, r10) == false) goto L5;
    }

    public int G() {
        StaticLayout r10 = this.f3407k0;
        if (r10 != null) goto L7;
        return 0;
    L7:
        return r10.getLineCount();
    }

    public void G0(TimeInterpolator r10) {
        this.Y = r10;
        Y();
    }

    @RequiresApi(23)
    public float H() {
        return this.f3407k0.getSpacingAdd();
    }

    public void H0(Typeface r10) {
        boolean r11 = i0(r10);
        boolean r12 = t0(r10);
        if (r11 == true) goto L5;
        if (r12 == true) goto L5;
        return;
    L5:
        Y();
    }

    @RequiresApi(23)
    public float I() {
        return this.f3407k0.getSpacingMultiplier();
    }

    public int J() {
        return this.f3417p0;
    }

    @Nullable
    public TimeInterpolator L() {
        return this.X;
    }

    @Nullable
    public CharSequence M() {
        return this.G;
    }

    public final boolean S() {
        ColorStateList r10 = this.f3416p;
        if (r10 != null) goto L5;
    L6:
        ColorStateList r11 = this.f3414o;
        if (r11 != null) goto L9;
    L11:
        return false;
    L9:
        if (r11.isStateful() == false) goto L11;
    L10:
        return true;
    L5:
        if (r10.isStateful() == true) goto L10;
        goto L6
    }

    public void V(@NonNull Configuration r10) {
        if (Build.VERSION.SDK_INT < 31) goto L20;
        Typeface r11 = this.f3430z;
        if (r11 == null) goto L7;
        this.f3429y = com.google.android.material.resources.f.b(r10, r11);
    L7:
        Typeface r12 = this.C;
        if (r12 == null) goto L10;
        this.B = com.google.android.material.resources.f.b(r10, r12);
    L10:
        Typeface r13 = this.f3429y;
        if (r13 != null) goto L14;
        r13 = this.f3430z;
    L14:
        this.f3428x = r13;
        Typeface r14 = this.B;
        if (r14 != null) goto L18;
        r14 = this.C;
    L18:
        this.A = r14;
        Z(true);
        return;
    }

    void X() {
        if (this.f3402i.width() > 0) goto L5;
    L11:
        boolean r10 = false;
    L12:
        this.f3388b = r10;
        return;
    L5:
        if (this.f3402i.height() <= 0) goto L11;
        if (this.f3400h.width() <= 0) goto L11;
        if (this.f3400h.height() <= 0) goto L11;
        r10 = true;
        goto L12
    }

    public void Y() {
        Z(false);
    }

    public void Z(boolean r10) {
        if (this.f3386a.getHeight() > 0) goto L5;
    L6:
        if (r10 == false) goto L9;
    L7:
        b(r10);
        c();
        return;
    L9:
        return;
    L5:
        if (this.f3386a.getWidth() > 0) goto L7;
        goto L6
    }

    public void b0(int r10, int r11, int r12, int r13) {
        if (a0(this.f3402i, r10, r11, r12, r13) == true) goto L6;
        this.f3402i.set(r10, r11, r12, r13);
        this.U = true;
        X();
        return;
    }

    public void c0(@NonNull Rect r10) {
        b0(r10.left, r10.top, r10.right, r10.bottom);
    }

    public void d0(int r10) {
        TextAppearance r11 = new TextAppearance(this.f3386a.getContext(), r10);
        if (r11.i() == null) goto L6;
        this.f3416p = r11.i();
    L6:
        if (r11.j() == 0.0f) goto L8;
        this.f3412n = r11.j();
    L8:
        ColorStateList r12 = r11.f3575a;
        if (r12 == null) goto L11;
        this.f3391c0 = r12;
    L11:
        this.f3387a0 = r11.f3579e;
        this.f3389b0 = r11.f3580f;
        this.Z = r11.f3581g;
        this.f3401h0 = r11.f3583i;
        com.google.android.material.resources.a r13 = this.F;
        if (r13 == null) goto L14;
        r13.c();
    L14:
        this.F = new com.google.android.material.resources.a(new a(this), r11.e());
        r11.h(this.f3386a.getContext(), this.F);
        Y();
    }

    public void f0(ColorStateList r10) {
        if (this.f3416p == r10) goto L6;
        this.f3416p = r10;
        Y();
        return;
    }

    public void g0(int r10) {
        if (this.f3408l == r10) goto L6;
        this.f3408l = r10;
        Y();
        return;
    }

    public void h0(Typeface r10) {
        if (i0(r10) == false) goto L6;
        Y();
        return;
    }

    public void j0(int r10) {
        this.f3398g = r10;
    }

    public void k0(int r10, int r11, int r12, int r13) {
        if (a0(this.f3400h, r10, r11, r12, r13) == true) goto L6;
        this.f3400h.set(r10, r11, r12, r13);
        this.U = true;
        X();
        return;
    }

    public void l(@NonNull Canvas r10) {
        int r11 = r10.save();
        if (this.H != null) goto L5;
        return;
    L5:
        if (this.f3388b == false) goto L31;
        this.V.setTextSize(this.O);
        float r12 = this.f3426v;
        float r13 = this.f3427w;
        if (this.K == true) goto L9;
    L11:
        boolean r14 = false;
    L12:
        float r15 = this.N;
        if (r15 != 1.0f) goto L15;
    L17:
        if (r14 == false) goto L21;
        r10.drawBitmap(this.L, r12, r13, this.M);
        r10.restoreToCount(r11);
        return;
    L21:
        if (I0() == true) goto L23;
    L27:
        r10.translate(r12, r13);
        this.f3407k0.draw(r10);
    L28:
        r10.restoreToCount(r11);
        return;
    L23:
        if (this.f3392d == true) goto L25;
    L26:
        m(r10, this.f3426v - this.f3407k0.getLineStart(0), r13);
        goto L28
    L25:
        if (this.f3390c <= this.f3396f) goto L27;
    L15:
        if (this.f3392d == true) goto L17;
        r10.scale(r15, r15, r12, r13);
        goto L17
    L9:
        if (this.L == null) goto L11;
        r14 = true;
        goto L12
    }

    public void l0(@NonNull Rect r10) {
        k0(r10.left, r10.top, r10.right, r10.bottom);
    }

    public void m0(float r10) {
        if (this.f3403i0 == r10) goto L6;
        this.f3403i0 = r10;
        Y();
        return;
    }

    public void n0(int r10) {
        TextAppearance r11 = new TextAppearance(this.f3386a.getContext(), r10);
        if (r11.i() == null) goto L6;
        this.f3414o = r11.i();
    L6:
        if (r11.j() == 0.0f) goto L8;
        this.f3410m = r11.j();
    L8:
        ColorStateList r12 = r11.f3575a;
        if (r12 == null) goto L11;
        this.f3399g0 = r12;
    L11:
        this.f3395e0 = r11.f3579e;
        this.f3397f0 = r11.f3580f;
        this.f3393d0 = r11.f3581g;
        this.f3403i0 = r11.f3583i;
        com.google.android.material.resources.a r13 = this.E;
        if (r13 == null) goto L14;
        r13.c();
    L14:
        this.E = new com.google.android.material.resources.a(new C0082b(this), r11.e());
        r11.h(this.f3386a.getContext(), this.E);
        Y();
    }

    public void o(@NonNull RectF r10, int r11, int r12) {
        this.I = f(this.G);
        r10.left = s(r11, r12);
        r10.top = this.f3402i.top;
        r10.right = t(r10, r11, r12);
        r10.bottom = this.f3402i.top + r();
    }

    public ColorStateList p() {
        return this.f3416p;
    }

    public void p0(ColorStateList r10) {
        if (this.f3414o == r10) goto L6;
        this.f3414o = r10;
        Y();
        return;
    }

    public int q() {
        return this.f3408l;
    }

    public void q0(int r10) {
        if (this.f3406k == r10) goto L6;
        this.f3406k = r10;
        Y();
        return;
    }

    public float r() {
        N(this.W);
        return -this.W.ascent();
    }

    public void r0(float r10) {
        if (this.f3410m == r10) goto L6;
        this.f3410m = r10;
        Y();
        return;
    }

    public void s0(Typeface r10) {
        if (t0(r10) == false) goto L6;
        Y();
        return;
    }

    public Typeface u() {
        Typeface r10 = this.f3428x;
        if (r10 == null) goto L6;
        return r10;
    L6:
        return Typeface.DEFAULT;
    }

    public void u0(float r10) {
        float r11 = MathUtils.clamp(r10, 0.0f, 1.0f);
        if (r11 == this.f3390c) goto L6;
        this.f3390c = r11;
        c();
        return;
    }

    @ColorInt
    public int v() {
        return w(this.f3416p);
    }

    public void v0(boolean r10) {
        this.f3392d = r10;
    }

    public void w0(float r10) {
        this.f3394e = r10;
        this.f3396f = e();
    }

    @RequiresApi(23)
    public void x0(int r10) {
        this.f3423s0 = r10;
    }

    public int y() {
        return this.f3418q;
    }

    public float z() {
        O(this.W);
        return (-this.W.ascent()) + this.W.descent();
    }

    @RequiresApi(23)
    public void z0(float r10) {
        this.f3419q0 = r10;
    }
}
