package o9;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.annotation.ColorInt;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.StyleRes;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class k implements b {
    private int A;
    private int B;
    private int C;
    private int D;
    private Paint E;
    private float F;
    private Paint G;
    private PorterDuffXfermode H;
    private int I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private float[] f11552J;
    private int K;
    private int L;
    private int M;
    private int N;
    private boolean O;
    private RectF P;
    private int Q;
    private int R;
    private int S;
    private WeakReference<View> T;
    private boolean U;
    private Path V;
    private boolean W;
    private int X;
    private float Y;
    private int Z;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    private int f11553a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    private int f11554b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Context f11555c;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    private int f11556c0;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    private int f11557d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    private int f11558e0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    private int f11559f0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f11560g;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    private AttributeSet f11561g0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f11562h;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    private int f11563h0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f11564i;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    private int f11565i0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f11566j;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    private boolean f11567j0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f11568k;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    private p f11569k0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f11570l;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    private p f11571l0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f11572m;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    private float f11573m0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f11574n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f11575o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f11576p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f11577q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int f11578r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int f11579s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f11580t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private int f11581u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private int f11582v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private int f11583w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private int f11584x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private int f11585y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private int f11586z;

    class a extends ViewOutlineProvider {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ k f11587a;

        a(k r10) {
            this.f11587a = r10;
        }

        @Override // android.view.ViewOutlineProvider
        @TargetApi(21)
        public void getOutline(View r10, Outline r11) {
            int r12 = r10.getWidth();
            int r13 = r10.getHeight();
            if (r12 == 0) goto L30;
            if (r13 == 0) goto L33;
            float r14 = k.a(this.f11587a);
            float r15 = r14 * 2.0f;
            float r16 = Math.min(r12, r13);
            if (r15 <= r16) goto L9;
            r14 = r16 / 2.0f;
        L9:
            float r17 = r14;
            if (k.b(this.f11587a) == false) goto L13;
            Path r18 = new Path();
            r18.addRoundRect(new RectF(0.0f, 0.0f, r12, r13), new float[]{k.f(this.f11587a), k.f(this.f11587a), k.g(this.f11587a), k.g(this.f11587a), k.h(this.f11587a), k.h(this.f11587a), k.i(this.f11587a), k.i(this.f11587a)}, Path.Direction.CW);
            r11.setConvexPath(r18);
            r10.setClipToOutline(true);
            return;
        L13:
            int r19 = k.j(this.f11587a);
            int r20 = Math.max(r19 + 1, r13 - k.k(this.f11587a));
            int r21 = k.l(this.f11587a);
            int r22 = r12 - k.m(this.f11587a);
            if (k.c(this.f11587a) == false) goto L16;
            r21 = r21 + r10.getPaddingLeft();
            r19 = r19 + r10.getPaddingTop();
            int r23 = Math.max(r21 + 1, r22 - r10.getPaddingRight());
            int r24 = Math.max(r19 + 1, r20 - r10.getPaddingBottom());
            int r25 = r23;
        L17:
            int r26 = r19;
            float r110 = k.d(this.f11587a);
            if (k.e(this.f11587a) != 0) goto L20;
            r110 = 1.0f;
        L20:
            r11.setAlpha(r110);
            if (r17 > 0.0f) goto L24;
            r11.setRect(r21, r26, r25, r24);
            return;
        L24:
            if (q.f11613d == true) goto L27;
        L25:
            r11.setRoundRect(r21, r26, r25, r24, r17);
            return;
        L27:
            if (Build.VERSION.SDK_INT < 30) goto L25;
            r11.setPath(q.f11614e.c(r21, r26, r25, r24, r17));
            return;
        L16:
            r25 = r22;
            r24 = r20;
            goto L17
        L33:
            return;
        }
    }

    public k(Context r16, AttributeSet r17, int r18, int r19) {
        this.f11560g = 0;
        this.f11562h = 0;
        this.f11564i = 0;
        this.f11566j = 0;
        this.f11568k = 0;
        this.f11570l = 0;
        this.f11572m = 0;
        this.f11575o = 255;
        this.f11576p = 0;
        this.f11577q = 0;
        this.f11578r = 0;
        this.f11580t = 255;
        this.f11581u = 0;
        this.f11582v = 0;
        this.f11583w = 0;
        this.f11585y = 255;
        this.f11586z = 0;
        this.A = 0;
        this.B = 0;
        this.D = 255;
        this.F = 1.0f;
        this.K = 0;
        this.L = 0;
        this.M = 0;
        this.N = 0;
        this.Q = 0;
        this.R = 1;
        this.S = 0;
        this.U = false;
        this.V = new Path();
        this.W = true;
        this.X = 0;
        this.Z = ViewCompat.MEASURED_STATE_MASK;
        this.f11553a0 = 0;
        this.f11554b0 = 0;
        this.f11556c0 = 0;
        this.f11557d0 = 0;
        this.f11558e0 = 0;
        this.f11559f0 = 0;
        this.f11567j0 = false;
        this.f11569k0 = new p(Color.parseColor("#00000000"), 0.0f, 0.0f, 0.0f, 0.0f);
        this.f11571l0 = new p(Color.parseColor("#00000000"), 0.0f, 0.0f, 0.0f, 0.0f);
        this.f11573m0 = 0.0f;
        this.f11555c = r16;
        this.f11561g0 = r17;
        this.f11563h0 = r18;
        this.f11565i0 = r19;
    }

    private static void B(TypedArray r10, p r11, int r12, int r13, int r14, int r15, int r16) {
        if (r11 != null) goto L4;
        return;
    L4:
        r11.h(r10.getColor(r12, Color.parseColor("#00000000")));
        r11.k(r10.getDimension(r13, 0.0f));
        r11.i(r10.getDimension(r14, 0.0f));
        r11.j(r10.getDimension(r15, 0.0f));
        r11.l(r10.getDimension(r16, 0.0f));
    }

    private void D() {
        View r10 = this.T.get();
        if (r10 != null) goto L5;
        return;
    L5:
        r10.invalidate();
    }

    private void E() {
        if (K() == false) goto L13;
        View r10 = this.T.get();
        if (r10 != null) goto L7;
        return;
    L7:
        int r11 = this.X;
        if (r11 != 0) goto L10;
        float r12 = 0.0f;
    L11:
        r10.setElevation(r12);
        r10.invalidateOutline();
        return;
    L10:
        r12 = r11;
        goto L11
    }

    private void J(int r10) {
        if (Build.VERSION.SDK_INT < 28) goto L9;
        View r11 = this.T.get();
        if (r11 != null) goto L7;
        return;
    L7:
        r11.setOutlineAmbientShadowColor(r10);
        r11.setOutlineSpotShadowColor(r10);
        return;
    }

    public static boolean K() {
        if (Build.VERSION.SDK_INT < 21) goto L5;
        return true;
    L5:
        return false;
    }

    static /* synthetic */ int a(k r10) {
        return r10.y();
    }

    static /* synthetic */ boolean b(k r10) {
        return r10.O;
    }

    static /* synthetic */ boolean c(k r10) {
        return r10.U;
    }

    static /* synthetic */ float d(k r10) {
        return r10.Y;
    }

    static /* synthetic */ int e(k r10) {
        return r10.X;
    }

    static /* synthetic */ int f(k r10) {
        return r10.K;
    }

    static /* synthetic */ int g(k r10) {
        return r10.L;
    }

    static /* synthetic */ int h(k r10) {
        return r10.N;
    }

    static /* synthetic */ int i(k r10) {
        return r10.M;
    }

    static /* synthetic */ int j(k r10) {
        return r10.f11558e0;
    }

    static /* synthetic */ int k(k r10) {
        return r10.f11559f0;
    }

    static /* synthetic */ int l(k r10) {
        return r10.f11556c0;
    }

    static /* synthetic */ int m(k r10) {
        return r10.f11557d0;
    }

    private void n(Context r10, int r11) {
        TypedArray r12 = r10.obtainStyledAttributes(r11, u8.l.OUILayout);
        B(r12, this.f11569k0, u8.l.OUILayout_oui_firstShadowColor, u8.l.OUILayout_oui_firstShadowBlur, u8.l.OUILayout_oui_firstOffsetX, u8.l.OUILayout_oui_firstOffsetY, u8.l.OUILayout_oui_firstShadowSpread);
        B(r12, this.f11571l0, u8.l.OUILayout_oui_secondShadowColor, u8.l.OUILayout_oui_secondShadowBlur, u8.l.OUILayout_oui_secondOffsetX, u8.l.OUILayout_oui_secondOffsetY, u8.l.OUILayout_oui_secondShadowSpread);
        r12.recycle();
    }

    private void r(Canvas r10, RectF r11, int r12, Paint r13) {
        q r14 = q.f11614e;
        q.i(r10, r11, r12 * 1.0f, r13);
    }

    private void s(Canvas r10, RectF r11, float[] r12, Paint r13) {
        this.V.reset();
        this.V.addRoundRect(r11, r12, Path.Direction.CW);
        r10.drawPath(this.V, r13);
    }

    @RequiresApi(26)
    private void t(Canvas r10) {
        p r11 = this.f11569k0;
        boolean r12 = true;
        if (r11 != null) goto L5;
    L7:
        boolean r13 = false;
    L8:
        p r14 = this.f11571l0;
        if (r14 != null) goto L11;
    L13:
        r12 = false;
    L14:
        if (r13 == true) goto L18;
        if (r12 == true) goto L18;
        return;
    L18:
        if (this.I == 0) goto L20;
    L24:
        Log.e("OUILayoutHelper", " 阴影和圆角同时存在阴影不生效");
        return;
    L20:
        if (this.O == true) goto L24;
        u(r10, this.f11569k0);
        u(r10, this.f11571l0);
        return;
    L11:
        if (r14.m() == false) goto L13;
    L5:
        if (r11.m() == false) goto L7;
        r13 = true;
        goto L8
    }

    @RequiresApi(26)
    private void u(Canvas r10, p r11) {
        if (r11 != null) goto L5;
        return;
    L5:
        if (r11.b() <= 0.0f) goto L7;
        float r12 = r11.b();
    L8:
        View r13 = this.T.get();
        Path r14 = new Path();
        RectF r15 = new RectF(0.0f, 0.0f, r13.getWidth(), r13.getHeight());
        int r16 = this.f11553a0;
        if (r16 == 0) goto L11;
    L12:
        r15.inset(r16, this.f11554b0);
    L13:
        q.f11614e.a(r14, r15, r12);
        int r17 = r10.save();
        RectF r18 = new RectF(r15);
        r18.offset(r11.c(), r11.d());
        r18.inset(-r11.g(), -r11.g());
        r10.clipOutPath(r14);
        r11.e().setColor(r11.a());
        if (r11.f() <= 0.0f) goto L16;
        r11.e().setMaskFilter(new BlurMaskFilter(r11.f(), BlurMaskFilter.Blur.NORMAL));
    L16:
        q.i(r10, r18, r12, r11.e());
        r10.restoreToCount(r17);
        return;
    L11:
        if (this.f11554b0 == 0) goto L13;
    L7:
        r12 = this.f11573m0;
        goto L8
    }

    public static List<p> v(Context r14, int r15) {
        ArrayList r10 = new ArrayList();
        TypedArray r16 = r14.obtainStyledAttributes(r15, u8.l.OUILayout);
        p r17 = new p(Color.parseColor("#00000000"), 0.0f, 0.0f, 0.0f, 0.0f);
        p r11 = new p(Color.parseColor("#00000000"), 0.0f, 0.0f, 0.0f, 0.0f);
        B(r16, r17, u8.l.OUILayout_oui_firstShadowColor, u8.l.OUILayout_oui_firstShadowBlur, u8.l.OUILayout_oui_firstOffsetX, u8.l.OUILayout_oui_firstOffsetY, u8.l.OUILayout_oui_firstShadowSpread);
        B(r16, r11, u8.l.OUILayout_oui_secondShadowColor, u8.l.OUILayout_oui_secondShadowBlur, u8.l.OUILayout_oui_secondOffsetX, u8.l.OUILayout_oui_secondOffsetY, u8.l.OUILayout_oui_secondShadowSpread);
        r16.recycle();
        r10.add(r17);
        r10.add(r11);
        return r10;
    }

    private int y() {
        View r10 = this.T.get();
        int r11 = this.I;
        if (r10 != null) goto L6;
        return r11;
    L6:
        if (r11 != (-1)) goto L10;
        int r12 = r10.getHeight();
    L12:
        return r12 / 2;
    L10:
        if (r11 != (-2)) goto L13;
        r12 = r10.getWidth();
        goto L12
    L13:
        return r11;
    }

    public int A(int r10, int r11) {
        if (View.MeasureSpec.getMode(r10) == 1073741824) goto L8;
        int r12 = this.f11564i;
        if (r11 >= r12) goto L8;
        return View.MeasureSpec.makeMeasureSpec(r12, 1073741824);
    L8:
        return r10;
    }

    public void C(View r15) {
        this.T = new WeakReference(r15);
        Context r16 = this.f11555c;
        int r10 = u8.c.oui_line_2;
        int r17 = ContextCompat.getColor(r16, r10);
        this.f11574n = r17;
        this.f11579s = r17;
        int r18 = ContextCompat.getColor(this.f11555c, r10);
        this.C = r18;
        this.f11584x = r18;
        this.H = new PorterDuffXfermode(PorterDuff.Mode.DST_OUT);
        Paint r19 = new Paint();
        this.G = r19;
        r19.setAntiAlias(true);
        float r110 = l.b(this.f11555c, u8.b.oui_general_shadow_alpha);
        if (r110 <= 0.0f) goto L5;
        this.Y = r110;
    L5:
        this.P = new RectF();
        int r11 = 0;
        if (this.f11567j0 == false) goto L8;
    L15:
        TypedArray r111 = this.f11555c.obtainStyledAttributes(this.f11561g0, u8.l.OUILayout, this.f11563h0, this.f11565i0);
        int r12 = r111.getIndexCount();
        int r13 = 0;
        int r14 = 0;
        boolean r20 = false;
        int r112 = 0;
    L16:
        if (r13 >= r12) goto L132;
        int r21 = r111.getIndex(r13);
        if (r21 != u8.l.OUILayout_android_maxWidth) goto L21;
        this.f11560g = r111.getDimensionPixelSize(r21, this.f11560g);
    L123:
        if (r21 != u8.l.OUILayout_oui_bottomLeft_radius) goto L126;
        this.M = r111.getDimensionPixelSize(r21, 0);
    L126:
        if (r21 != u8.l.OUILayout_oui_bottomRight_radius) goto L129;
        this.N = r111.getDimensionPixelSize(r21, 0);
    L129:
        if (r21 != u8.l.OUILayout_oui_topRight_radius) goto L131;
        this.L = r111.getDimensionPixelSize(r21, 0);
    L131:
        r13 = r13 + 1;
        goto L16
    L21:
        if (r21 != u8.l.OUILayout_android_maxHeight) goto L24;
        this.f11562h = r111.getDimensionPixelSize(r21, this.f11562h);
        goto L123
    L24:
        if (r21 != u8.l.OUILayout_android_minWidth) goto L27;
        this.f11564i = r111.getDimensionPixelSize(r21, this.f11564i);
        goto L123
    L27:
        if (r21 != u8.l.OUILayout_android_minHeight) goto L30;
        this.f11566j = r111.getDimensionPixelSize(r21, this.f11566j);
        goto L123
    L30:
        if (r21 != u8.l.OUILayout_oui_topDividerColor) goto L33;
        this.f11574n = r111.getColor(r21, this.f11574n);
        goto L123
    L33:
        if (r21 != u8.l.OUILayout_oui_topDividerHeight) goto L36;
        this.f11568k = r111.getDimensionPixelSize(r21, this.f11568k);
        goto L123
    L36:
        if (r21 != u8.l.OUILayout_oui_topDividerInsetLeft) goto L39;
        this.f11570l = r111.getDimensionPixelSize(r21, this.f11570l);
        goto L123
    L39:
        if (r21 != u8.l.OUILayout_oui_topDividerInsetRight) goto L42;
        this.f11572m = r111.getDimensionPixelSize(r21, this.f11572m);
        goto L123
    L42:
        if (r21 != u8.l.OUILayout_oui_bottomDividerColor) goto L45;
        this.f11579s = r111.getColor(r21, this.f11579s);
        goto L123
    L45:
        if (r21 != u8.l.OUILayout_oui_bottomDividerHeight) goto L48;
        this.f11576p = r111.getDimensionPixelSize(r21, this.f11576p);
        goto L123
    L48:
        if (r21 != u8.l.OUILayout_oui_bottomDividerInsetLeft) goto L51;
        this.f11577q = r111.getDimensionPixelSize(r21, this.f11577q);
        goto L123
    L51:
        if (r21 != u8.l.OUILayout_oui_bottomDividerInsetRight) goto L54;
        this.f11578r = r111.getDimensionPixelSize(r21, this.f11578r);
        goto L123
    L54:
        if (r21 != u8.l.OUILayout_oui_leftDividerColor) goto L57;
        this.f11584x = r111.getColor(r21, this.f11584x);
        goto L123
    L57:
        if (r21 != u8.l.OUILayout_oui_leftDividerWidth) goto L60;
        this.f11581u = r111.getDimensionPixelSize(r21, this.f11581u);
        goto L123
    L60:
        if (r21 != u8.l.OUILayout_oui_leftDividerInsetTop) goto L63;
        this.f11582v = r111.getDimensionPixelSize(r21, this.f11582v);
        goto L123
    L63:
        if (r21 != u8.l.OUILayout_oui_leftDividerInsetBottom) goto L66;
        this.f11583w = r111.getDimensionPixelSize(r21, this.f11583w);
        goto L123
    L66:
        if (r21 != u8.l.OUILayout_oui_rightDividerColor) goto L69;
        this.C = r111.getColor(r21, this.C);
        goto L123
    L69:
        if (r21 != u8.l.OUILayout_oui_rightDividerWidth) goto L72;
        this.f11586z = r111.getDimensionPixelSize(r21, this.f11586z);
        goto L123
    L72:
        if (r21 != u8.l.OUILayout_oui_rightDividerInsetTop) goto L75;
        this.A = r111.getDimensionPixelSize(r21, this.A);
        goto L123
    L75:
        if (r21 != u8.l.OUILayout_oui_rightDividerInsetBottom) goto L78;
        this.B = r111.getDimensionPixelSize(r21, this.B);
        goto L123
    L78:
        if (r21 != u8.l.OUILayout_oui_layout_borderColor) goto L81;
        this.Q = r111.getColor(r21, this.Q);
        goto L123
    L81:
        if (r21 != u8.l.OUILayout_oui_layout_borderWidth) goto L84;
        this.R = r111.getDimensionPixelSize(r21, this.R);
        goto L123
    L84:
        if (r21 != u8.l.OUILayout_oui_radius) goto L87;
        r112 = r111.getDimensionPixelSize(r21, 0);
        goto L123
    L87:
        if (r21 != u8.l.OUILayout_oui_outerNormalColor) goto L90;
        this.S = r111.getColor(r21, this.S);
        goto L123
    L90:
        if (r21 != u8.l.OUILayout_oui_showBorderOnlyBeforeL) goto L93;
        this.W = r111.getBoolean(r21, this.W);
        goto L123
    L93:
        if (r21 != u8.l.OUILayout_oui_shadowElevation) goto L96;
        r14 = r111.getDimensionPixelSize(r21, r14);
        goto L123
    L96:
        if (r21 != u8.l.OUILayout_oui_shadowAlpha) goto L99;
        this.Y = r111.getFloat(r21, this.Y);
        goto L123
    L99:
        if (r21 != u8.l.OUILayout_oui_useThemeGeneralShadowElevation) goto L102;
        r20 = r111.getBoolean(r21, false);
        goto L123
    L102:
        if (r21 != u8.l.OUILayout_oui_outlineInsetLeft) goto L105;
        this.f11556c0 = r111.getDimensionPixelSize(r21, 0);
        goto L123
    L105:
        if (r21 != u8.l.OUILayout_oui_outlineInsetRight) goto L108;
        this.f11557d0 = r111.getDimensionPixelSize(r21, 0);
        goto L123
    L108:
        if (r21 != u8.l.OUILayout_oui_outlineInsetTop) goto L111;
        this.f11558e0 = r111.getDimensionPixelSize(r21, 0);
        goto L123
    L111:
        if (r21 != u8.l.OUILayout_oui_outlineInsetBottom) goto L114;
        this.f11559f0 = r111.getDimensionPixelSize(r21, 0);
        goto L123
    L114:
        if (r21 != u8.l.OUILayout_oui_outlineExcludePadding) goto L117;
        this.U = r111.getBoolean(r21, false);
        goto L123
    L117:
        if (r21 != u8.l.OUILayout_oui_support_image_mirroring) goto L120;
        r111.getBoolean(r21, false);
        goto L123
    L120:
        if (r21 != u8.l.OUILayout_oui_topLeft_radius) goto L123;
        this.K = r111.getDimensionPixelSize(r21, 0);
        goto L123
    L132:
        int r22 = r111.getResourceId(u8.l.OUILayout_oui_shadow_style, 0);
        if (r22 == 0) goto L135;
        n(this.f11555c, r22);
    L136:
        this.f11573m0 = r111.getDimension(u8.l.OUILayout_oui_shadowCornerRadius, 0.0f);
        r111.recycle();
        r11 = r14;
    L137:
        if (r11 != 0) goto L140;
        if (r20 == false) goto L140;
        r11 = l.a(this.f11555c, u8.b.oui_general_shadow_elevation);
    L140:
        setRadiusAndShadow(r112, r11, this.Y);
        return;
    L135:
        B(r111, this.f11569k0, u8.l.OUILayout_oui_firstShadowColor, u8.l.OUILayout_oui_firstShadowBlur, u8.l.OUILayout_oui_firstOffsetX, u8.l.OUILayout_oui_firstOffsetY, u8.l.OUILayout_oui_firstShadowSpread);
        B(r111, this.f11571l0, u8.l.OUILayout_oui_secondShadowColor, u8.l.OUILayout_oui_secondShadowBlur, u8.l.OUILayout_oui_secondOffsetX, u8.l.OUILayout_oui_secondOffsetY, u8.l.OUILayout_oui_secondShadowSpread);
        goto L136
    L8:
        if (this.f11561g0 != null) goto L15;
        if (this.f11563h0 != 0) goto L15;
        if (this.f11565i0 != 0) goto L15;
        r20 = false;
        r112 = 0;
        goto L137
    }

    public boolean F() {
        if (this.M <= 0) goto L5;
    L12:
        return true;
    L5:
        if (this.L > 0) goto L12;
        if (this.K > 0) goto L12;
        if (this.N > 0) goto L12;
        return false;
    }

    public void G() {
        View r10 = this.T.get();
        if (r10 == null) goto L6;
        r10.invalidate();
        return;
    }

    public void H(boolean r10) {
        this.f11567j0 = r10;
    }

    public boolean I(int r10) {
        this.f11566j = r10;
        return true;
    }

    @Override // o9.b
    public boolean decideIsNeedUpdatePressedForegroundBySelf() {
        return false;
    }

    @Override // o9.b
    public int getRadius() {
        return this.I;
    }

    @Override // o9.b
    public float getShadowAlpha() {
        return this.Y;
    }

    @Override // o9.b
    public int getShadowColor() {
        return this.Z;
    }

    @Override // o9.b
    public int getShadowElevation() {
        return this.X;
    }

    @Override // o9.b
    public boolean hasBorder() {
        if (this.R <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // o9.b
    public boolean hasBottomSeparator() {
        if (this.f11576p <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // o9.b
    public boolean hasLeftSeparator() {
        if (this.f11581u <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // o9.b
    public boolean hasRightSeparator() {
        if (this.f11586z <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // o9.b
    public boolean hasTopSeparator() {
        if (this.f11568k <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public void o(Canvas r16) {
        View r10 = this.T.get();
        if (r10 != null) goto L5;
        return;
    L5:
        int r11 = y();
        if (r11 > 0) goto L8;
    L12:
        boolean r12 = false;
    L14:
        if (this.R > 0) goto L16;
    L18:
        boolean r13 = false;
    L19:
        if (r12 == true) goto L23;
        if (r13 == true) goto L23;
        return;
    L23:
        if (this.W == true) goto L25;
    L29:
        int r14 = r16.getWidth();
        int r15 = r16.getHeight();
        r16.save();
        r16.translate(r10.getScrollX(), r10.getScrollY());
        float r17 = this.R / 2.0f;
        if (this.U == false) goto L32;
        this.P.set(r10.getPaddingLeft() + r17, r10.getPaddingTop() + r17, (r14 - r10.getPaddingRight()) - r17, (r15 - r10.getPaddingBottom()) - r17);
    L34:
        if (this.O == true) goto L36;
    L39:
        if (r12 == false) goto L45;
        int r18 = r16.saveLayer(0.0f, 0.0f, r14, r15, null, 31);
        r16.drawColor(this.S);
        this.G.setColor(this.S);
        this.G.setStyle(Paint.Style.FILL);
        this.G.setXfermode(this.H);
        if (this.O == true) goto L43;
        r(r16, this.P, r11, this.G);
    L44:
        this.G.setXfermode(null);
        r16.restoreToCount(r18);
        goto L45
    L43:
        s(r16, this.P, this.f11552J, this.G);
    L45:
        if (r13 == false) goto L53;
        this.G.setColor(this.Q);
        this.G.setStrokeWidth(this.R);
        this.G.setStyle(Paint.Style.STROKE);
        if (this.O == false) goto L49;
        s(r16, this.P, this.f11552J, this.G);
        goto L53
    L49:
        RectF r19 = this.P;
        if (r11 > 0) goto L52;
        r16.drawRect(r19, this.G);
        goto L53
    L52:
        r(r16, r19, r11, this.G);
    L53:
        r16.restore();
        return;
    L36:
        if (this.f11552J != null) goto L38;
        this.f11552J = new float[8];
    L38:
        float[] r20 = this.f11552J;
        int r21 = this.K;
        r20[0] = r21;
        r20[1] = r21;
        int r22 = this.L;
        r20[2] = r22;
        r20[3] = r22;
        int r23 = this.M;
        r20[4] = r23;
        r20[5] = r23;
        int r24 = this.N;
        r20[6] = r24;
        r20[7] = r24;
        goto L39
    L32:
        this.P.set(r17, r17, r14 - r17, r15 - r17);
        goto L34
    L25:
        if (K() == false) goto L29;
        if (this.X == 0) goto L29;
        return;
    L16:
        if (this.Q == 0) goto L18;
        r13 = true;
        goto L19
    L8:
        if (K() == true) goto L12;
        if (this.S == 0) goto L12;
        r12 = true;
        goto L14
    }

    @Override // o9.b
    public void onPressAlphaChange(int r10) {
    }

    @Override // o9.b
    public void onlyShowBottomDivider(int r10, int r11, int r12, int r13) {
        updateBottomDivider(r10, r11, r12, r13);
        this.f11581u = 0;
        this.f11586z = 0;
        this.f11568k = 0;
    }

    @Override // o9.b
    public void onlyShowLeftDivider(int r10, int r11, int r12, int r13) {
        updateLeftDivider(r10, r11, r12, r13);
        this.f11586z = 0;
        this.f11568k = 0;
        this.f11576p = 0;
    }

    @Override // o9.b
    public void onlyShowRightDivider(int r10, int r11, int r12, int r13) {
        updateRightDivider(r10, r11, r12, r13);
        this.f11581u = 0;
        this.f11568k = 0;
        this.f11576p = 0;
    }

    @Override // o9.b
    public void onlyShowTopDivider(int r10, int r11, int r12, int r13) {
        updateTopDivider(r10, r11, r12, r13);
        this.f11581u = 0;
        this.f11586z = 0;
        this.f11576p = 0;
    }

    @RequiresApi(api = 26)
    public void p(Canvas r10) {
        View r11 = this.T.get();
        if (r11 != null) goto L5;
        return;
    L5:
        t(r10);
        if (r11.isHardwareAccelerated() == false) goto L9;
        return;
    L9:
        if (this.O == false) goto L11;
        return;
    L11:
        Drawable r12 = r11.getBackground();
        if (r12 != null) goto L14;
    L16:
        Drawable r13 = r11.getForeground();
        if (r13 != null) goto L19;
        return;
    L19:
        if ((r13 instanceof o) == true) goto L23;
        o r14 = new o(r13, this.f11555c.getResources().getDisplayMetrics());
        r14.a(this.I);
        r11.setForeground(r14);
        return;
    L23:
        return;
    L14:
        if ((r12 instanceof o) == true) goto L16;
        o r15 = new o(r12, this.f11555c.getResources().getDisplayMetrics());
        r15.a(this.I);
        r11.setBackground(r15);
        goto L16
    }

    public void q(Canvas r12, int r13, int r14) {
        View r10 = this.T.get();
        if (r10 != null) goto L6;
        return;
    L6:
        if (this.E == null) goto L8;
    L16:
        r12.save();
        r12.translate(r10.getScrollX(), r10.getScrollY());
        int r11 = this.f11568k;
        if (r11 <= 0) goto L22;
        this.E.setStrokeWidth(r11);
        this.E.setColor(da.f.a(this.f11574n, this.F));
        int r15 = this.f11575o;
        if (r15 >= 255) goto L21;
        this.E.setAlpha(r15);
    L21:
        float r16 = this.f11568k / 2.0f;
        r12.drawLine(this.f11570l, r16, r13 - this.f11572m, r16, this.E);
    L22:
        int r17 = this.f11576p;
        if (r17 <= 0) goto L28;
        this.E.setStrokeWidth(r17);
        this.E.setColor(da.f.a(this.f11579s, this.F));
        int r18 = this.f11580t;
        if (r18 >= 255) goto L27;
        this.E.setAlpha(r18);
    L27:
        float r19 = (float) Math.floor(r14 - (this.f11576p / 2.0f));
        r12.drawLine(this.f11577q, r19, r13 - this.f11578r, r19, this.E);
    L28:
        int r20 = this.f11581u;
        if (r20 <= 0) goto L34;
        this.E.setStrokeWidth(r20);
        this.E.setColor(da.f.a(this.f11584x, this.F));
        int r21 = this.f11585y;
        if (r21 >= 255) goto L33;
        this.E.setAlpha(r21);
    L33:
        float r22 = this.f11581u / 2.0f;
        r12.drawLine(r22, this.f11582v, r22, r14 - this.f11583w, this.E);
    L34:
        int r23 = this.f11586z;
        if (r23 <= 0) goto L40;
        this.E.setStrokeWidth(r23);
        this.E.setColor(da.f.a(this.C, this.F));
        int r24 = this.D;
        if (r24 >= 255) goto L39;
        this.E.setAlpha(r24);
    L39:
        float r25 = (float) Math.floor(r13 - (this.f11586z / 2.0f));
        r12.drawLine(r25, this.A, r25, r14 - this.B, this.E);
    L40:
        r12.restore();
        return;
    L8:
        if (this.f11568k <= 0) goto L10;
    L15:
        this.E = new Paint();
        goto L16
    L10:
        if (this.f11576p > 0) goto L15;
        if (this.f11581u > 0) goto L15;
        if (this.f11586z <= 0) goto L16;
        goto L15
    }

    @Override // o9.b
    public void setBorderColor(@ColorInt int r10) {
        this.Q = r10;
        G();
    }

    @Override // o9.b
    public void setBorderWidth(int r10) {
        this.R = r10;
        G();
    }

    @Override // o9.b
    public void setBottomDividerAlpha(int r10) {
        this.f11580t = r10;
        G();
    }

    @Override // o9.b
    public boolean setHeightLimit(int r10) {
        if (this.f11562h == r10) goto L6;
        this.f11562h = r10;
        return true;
    L6:
        return false;
    }

    @Override // o9.b
    public void setLeftDividerAlpha(int r10) {
        this.f11585y = r10;
        G();
    }

    @Override // o9.b
    public void setOuterNormalColor(int r10) {
        this.S = r10;
        G();
    }

    @Override // o9.b
    public void setOutlineExcludePadding(boolean r10) {
        if (K() == false) goto L9;
        View r11 = this.T.get();
        if (r11 != null) goto L7;
        return;
    L7:
        this.U = r10;
        r11.invalidateOutline();
        return;
    }

    @Override // o9.b
    public void setOutlineInset(int r10, int r11, int r12, int r13) {
        if (K() == false) goto L9;
        View r14 = this.T.get();
        if (r14 != null) goto L7;
        return;
    L7:
        this.f11556c0 = r10;
        this.f11557d0 = r12;
        this.f11558e0 = r11;
        this.f11559f0 = r13;
        r14.invalidateOutline();
        return;
    }

    @Override // o9.b
    public void setRadius(int r10) {
        if (this.I == r10) goto L6;
        setRadiusAndShadow(r10, this.X, this.Y);
        return;
    }

    @Override // o9.b
    public void setRadius(int r10, int r11, int r12, int r13) {
        this.K = r10;
        this.L = r11;
        this.M = r12;
        this.N = r13;
        setRadiusAndShadow(this.I, this.X, this.Y);
    }

    @Override // o9.b
    public void setRadiusAndShadow(int r10, int r11, float r12) {
        setRadiusAndShadow(r10, r11, this.Z, r12);
    }

    @Override // o9.b
    public void setRadiusAndShadow(int r10, int r11, int r12, float r13) {
        View r14 = this.T.get();
        if (r14 != null) goto L5;
        return;
    L5:
        this.I = r10;
        if (this.f11573m0 != 0.0f) goto L8;
        this.f11573m0 = r10;
    L8:
        this.O = F();
        this.X = r11;
        this.Y = r13;
        this.Z = r12;
        if (K() == false) goto L26;
        int r15 = this.X;
        if (r15 != 0) goto L13;
    L16:
        r14.setElevation(0.0f);
    L17:
        J(this.Z);
        r14.setOutlineProvider(new a(this));
        int r16 = this.I;
        if (r16 != (-2)) goto L20;
    L24:
        boolean r17 = true;
    L25:
        r14.setClipToOutline(r17);
        goto L26
    L20:
        if (r16 == (-1)) goto L24;
        if (r16 > 0) goto L24;
        r17 = false;
        goto L25
    L13:
        if (this.O == true) goto L16;
        r14.setElevation(r15);
    L26:
        r14.invalidate();
    }

    @Override // o9.b
    public void setRightDividerAlpha(int r10) {
        this.D = r10;
        G();
    }

    @Override // o9.b
    public void setShadow(@Nullable p r10, @Nullable p r11) {
        this.f11569k0 = r10;
        this.f11571l0 = r11;
        D();
    }

    @Override // o9.b
    public void setShadowAlpha(float r10) {
        if (this.Y != r10) goto L5;
        return;
    L5:
        this.Y = r10;
        E();
    }

    @Override // o9.b
    public void setShadowColor(int r10) {
        if (this.Z != r10) goto L5;
        return;
    L5:
        this.Z = r10;
        J(r10);
    }

    @Override // o9.b
    public void setShadowCornerRadius(int r10) {
        this.f11573m0 = r10;
    }

    @Override // o9.b
    public void setShadowElevation(int r10) {
        if (this.X != r10) goto L5;
        return;
    L5:
        this.X = r10;
        E();
    }

    @Override // o9.b
    public void setShadowInsets(int r10, int r11) {
        this.f11553a0 = r10;
        this.f11554b0 = r11;
    }

    @Override // o9.b
    public void setShadowStyle(@StyleRes int r10) {
        if (r10 != 0) goto L4;
        return;
    L4:
        n(this.f11555c, r10);
    }

    @Override // o9.b
    public void setShowBorderOnlyBeforeL(boolean r10) {
        this.W = r10;
        D();
    }

    @Override // o9.b
    public void setTopDividerAlpha(int r10) {
        this.f11575o = r10;
        G();
    }

    @Override // o9.b
    public void setUseThemeGeneralShadowElevation() {
        int r10 = l.a(this.f11555c, u8.b.oui_general_shadow_elevation);
        this.X = r10;
        setRadiusAndShadow(this.I, r10, this.Y);
    }

    @Override // o9.b
    public boolean setWidthLimit(int r10) {
        if (this.f11560g == r10) goto L6;
        this.f11560g = r10;
        return true;
    L6:
        return false;
    }

    @Override // o9.b
    public void setWidthMin(int r10) {
        this.f11564i = r10;
    }

    @Override // o9.b
    public boolean shouldUpdateDividerColorOnPress() {
        return false;
    }

    @Override // o9.b
    public void updateBottomDivider(int r10, int r11, int r12, int r13) {
        this.f11577q = r10;
        this.f11578r = r11;
        this.f11579s = r13;
        this.f11576p = r12;
        G();
    }

    @Override // o9.b
    public void updateBottomSeparatorColor(int r10) {
        if (this.f11579s == r10) goto L6;
        this.f11579s = r10;
        D();
        return;
    }

    @Override // o9.b
    public void updateDividerColorStrength(float r10) {
        if (this.F == r10) goto L6;
        this.F = r10;
        D();
        return;
    }

    @Override // o9.b
    public void updateLeftDivider(int r10, int r11, int r12, int r13) {
        this.f11582v = r10;
        this.f11583w = r11;
        this.f11581u = r12;
        this.f11584x = r13;
        G();
    }

    @Override // o9.b
    public void updateLeftSeparatorColor(int r10) {
        if (this.f11584x == r10) goto L6;
        this.f11584x = r10;
        D();
        return;
    }

    @Override // o9.b
    public void updateRightDivider(int r10, int r11, int r12, int r13) {
        this.A = r10;
        this.B = r11;
        this.f11586z = r12;
        this.C = r13;
        G();
    }

    @Override // o9.b
    public void updateRightSeparatorColor(int r10) {
        if (this.C == r10) goto L6;
        this.C = r10;
        D();
        return;
    }

    @Override // o9.b
    public void updateTopDivider(int r10, int r11, int r12, int r13) {
        this.f11570l = r10;
        this.f11572m = r11;
        this.f11568k = r12;
        this.f11574n = r13;
        G();
    }

    @Override // o9.b
    public void updateTopSeparatorColor(int r10) {
        if (this.f11574n == r10) goto L6;
        this.f11574n = r10;
        D();
        return;
    }

    public int w(int r10) {
        if (this.f11562h > 0) goto L5;
        return r10;
    L5:
        if (View.MeasureSpec.getSize(r10) <= this.f11562h) goto L12;
        int r11 = View.MeasureSpec.getMode(r10);
        int r12 = this.f11562h;
        if (r11 != Integer.MIN_VALUE) goto L10;
        return View.MeasureSpec.makeMeasureSpec(r12, Integer.MIN_VALUE);
    L10:
        return View.MeasureSpec.makeMeasureSpec(r12, 1073741824);
    L12:
        return r10;
    }

    public int x(int r10) {
        if (this.f11560g > 0) goto L5;
        return r10;
    L5:
        if (View.MeasureSpec.getSize(r10) <= this.f11560g) goto L12;
        int r11 = View.MeasureSpec.getMode(r10);
        int r12 = this.f11560g;
        if (r11 != Integer.MIN_VALUE) goto L10;
        return View.MeasureSpec.makeMeasureSpec(r12, Integer.MIN_VALUE);
    L10:
        return View.MeasureSpec.makeMeasureSpec(r12, 1073741824);
    L12:
        return r10;
    }

    public int z(int r10, int r11) {
        if (View.MeasureSpec.getMode(r10) == 1073741824) goto L8;
        int r12 = this.f11566j;
        if (r11 >= r12) goto L8;
        return View.MeasureSpec.makeMeasureSpec(r12, 1073741824);
    L8:
        return r10;
    }
}
