package com.lynx.tasm.behavior.ui.utils;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathEffect;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.ui.UIShadowProxy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class BackgroundDrawable extends d<a7a.e> {
    public BorderRadius A;
    public UIShadowProxy.a B;
    public boolean h;
    public boolean i;
    public k j;
    public k k;
    public BorderStyle[] l;
    public PathEffect m;
    public RoundRectPath n;
    public RoundRectPath o;
    public Map<RoundRectPath.Pos, RoundRectPath> p;
    public Path q;
    public Path r;
    public PointF s;
    public PointF t;
    public PointF u;
    public PointF v;
    public boolean w;
    public final Paint x;
    public int y;
    public int z;

    public static final enum BorderRadiusLocation extends Enum<BorderRadiusLocation> {
        public static final BorderRadiusLocation BOTTOM_END = null;
        public static final BorderRadiusLocation BOTTOM_LEFT = null;
        public static final BorderRadiusLocation BOTTOM_RIGHT = null;
        public static final BorderRadiusLocation BOTTOM_START = null;
        public static final BorderRadiusLocation TOP_END = null;
        public static final BorderRadiusLocation TOP_LEFT = null;
        public static final BorderRadiusLocation TOP_RIGHT = null;
        public static final BorderRadiusLocation TOP_START = null;
        public static final /* synthetic */ BorderRadiusLocation[] a = null;

        static {
            BorderRadiusLocation r0 = new BorderRadiusLocation("TOP_LEFT", 0);
            TOP_LEFT = r0;
            BorderRadiusLocation r1 = new BorderRadiusLocation("TOP_RIGHT", 1);
            TOP_RIGHT = r1;
            BorderRadiusLocation r3 = new BorderRadiusLocation("BOTTOM_RIGHT", 2);
            BOTTOM_RIGHT = r3;
            BorderRadiusLocation r5 = new BorderRadiusLocation("BOTTOM_LEFT", 3);
            BOTTOM_LEFT = r5;
            BorderRadiusLocation r7 = new BorderRadiusLocation("TOP_START", 4);
            TOP_START = r7;
            BorderRadiusLocation r9 = new BorderRadiusLocation("TOP_END", 5);
            TOP_END = r9;
            BorderRadiusLocation r11 = new BorderRadiusLocation("BOTTOM_START", 6);
            BOTTOM_START = r11;
            BorderRadiusLocation r13 = new BorderRadiusLocation("BOTTOM_END", 7);
            BOTTOM_END = r13;
            a = new BorderRadiusLocation[]{r0, r1, r3, r5, r7, r9, r11, r13};
        }

        public static BorderRadiusLocation[] values() {
            return (BorderRadiusLocation[]) a.clone();
        }

        public static BorderRadiusLocation valueOf(String r1) {
            return (BorderRadiusLocation) r27.a.a(BorderRadiusLocation.class, r1);
        }

        public BorderRadiusLocation(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static class RoundRectPath {
        public RectF a;
        public float[] b;
        public Path c;
        public boolean d;

        public static final enum Pos extends Enum<Pos> {
            public static final Pos CENTER = null;
            public static final Pos INNER2 = null;
            public static final Pos INNER3 = null;
            public static final Pos OUTER2 = null;
            public static final Pos OUTER3 = null;
            public static final /* synthetic */ Pos[] a = null;

            static {
                Pos r0 = new Pos("CENTER", 0);
                CENTER = r0;
                Pos r1 = new Pos("INNER2", 1);
                INNER2 = r1;
                Pos r3 = new Pos("OUTER2", 2);
                OUTER2 = r3;
                Pos r5 = new Pos("INNER3", 3);
                INNER3 = r5;
                Pos r7 = new Pos("OUTER3", 4);
                OUTER3 = r7;
                a = new Pos[]{r0, r1, r3, r5, r7};
            }

            public static Pos[] values() {
                return (Pos[]) a.clone();
            }

            public float getOffset() {
                int r0 = a.a[ordinal()];
                if (r0 != 1) goto L5;
                return 0.5f;
            L5:
                if (r0 != 2) goto L7;
                return 0.75f;
            L7:
                if (r0 != 3) goto L9;
                return 0.25f;
            L9:
                if (r0 != 4) goto L11;
                return 0.8333333f;
            L11:
                if (r0 == 5) goto L14;
                return 0.0f;
            L14:
                return 0.16666667f;
            }

            public static Pos valueOf(String r1) {
                return (Pos) r27.a.a(Pos.class, r1);
            }

            public Pos(String r1, int r2) {
                super(r1, r2);
            }
        }

        public RoundRectPath() {
        }

        public static boolean a(float[] r6) {
            int r0 = 2;
        L4:
            if (r0 > 6) goto L17;
            float r1 = r6[r0] - r6[0];
            if (r1 > 1.0E-4f) goto L16;
            if (r1 < (-1.0E-4f)) goto L16;
            float r2 = r6[r0 + 1] - r6[1];
            if (r2 > 1.0E-4f) goto L16;
            if (r2 < (-1.0E-4f)) goto L16;
            r0 = r0 + 2;
        L16:
            return false;
        L17:
            return true;
        }

        public final void b(Canvas r5, Paint r6) {
            if (this.d == false) goto L5;
            RectF r0 = this.a;
            float[] r1 = this.b;
            r5.drawRoundRect(r0, r1[0], r1[1], r6);
            return;
        L5:
            r5.drawPath(this.c, r6);
        }

        public RoundRectPath(x6a.j r8, x6a.j r9, Pos r10) {
            Rect r1 = r8.a();
            float[] r2 = r8.b;
            RectF r11 = r9.a;
            float r0 = r11.left;
            RectF r12 = r8.a;
            RectF r3 = new RectF(r0 - r12.left, r11.top - r12.top, r12.right - r11.right, r12.bottom - r11.bottom);
            float r4 = r10.getOffset();
            if (r10 != Pos.CENTER) goto L5;
            boolean r5 = true;
        L6:
            d(r1, r2, r3, r4, r5);
            return;
        L5:
            r5 = false;
            goto L6
        }

        public static float[] c(float[] r5, RectF r6, float r7) {
            return new float[]{Math.max(r5[0] - (r6.left * r7), 0.0f), Math.max(r5[1] - (r6.top * r7), 0.0f), Math.max(r5[2] - (r6.right * r7), 0.0f), Math.max(r5[3] - (r6.top * r7), 0.0f), Math.max(r5[4] - (r6.right * r7), 0.0f), Math.max(r5[5] - (r6.bottom * r7), 0.0f), Math.max(r5[6] - (r6.left * r7), 0.0f), Math.max(r5[7] - (r6.bottom * r7), 0.0f)};
        }

        public final void d(Rect r4, float[] r5, RectF r6, float r7, boolean r8) {
            if (this.a != null) goto L5;
            this.a = new RectF();
        L5:
            RectF r0 = this.a;
            r0.left = r4.left + (r6.left * r7);
            r0.top = r4.top + (r6.top * r7);
            r0.right = r4.right - (r6.right * r7);
            r0.bottom = r4.bottom - (r6.bottom * r7);
            if (r8 == false) goto L8;
            float[] r9 = {Math.max(r5[0] - (r6.left * r7), 0.0f), Math.max(r5[1] - (r6.top * r7), 0.0f), Math.max(r5[2] - (r6.right * r7), 0.0f), Math.max(r5[3] - (r6.top * r7), 0.0f), Math.max(r5[4] - (r6.right * r7), 0.0f), Math.max(r5[5] - (r6.bottom * r7), 0.0f), Math.max(r5[6] - (r6.left * r7), 0.0f), Math.max(r5[7] - (r6.bottom * r7), 0.0f)};
        L9:
            this.b = r9;
            this.d = a(r9);
            Path r10 = this.c;
            if (r10 != null) goto L12;
            this.c = new Path();
        L13:
            this.c.addRoundRect(this.a, this.b, Path.Direction.CW);
            return;
        L12:
            r10.reset();
            goto L13
        L8:
            r9 = c(r5, r6, r7);
            goto L9
        }
    }

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;
        public static final /* synthetic */ int[] b = null;

        static {
            int[] r0 = new int[BorderStyle.values().length];
            b = r0;
            r0[BorderStyle.NONE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L24
        L59:
            b[BorderStyle.HIDDEN.ordinal()] = 2;     // Catch: NoSuchFieldError -> L25
        L41:
            b[BorderStyle.DASHED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L26
        L55:
            b[BorderStyle.DOTTED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L27
        L61:
            b[BorderStyle.SOLID.ordinal()] = 5;     // Catch: NoSuchFieldError -> L28
        L45:
            b[BorderStyle.INSET.ordinal()] = 6;     // Catch: NoSuchFieldError -> L29
        L47:
            b[BorderStyle.OUTSET.ordinal()] = 7;     // Catch: NoSuchFieldError -> L30
        L67:
            b[BorderStyle.DOUBLE.ordinal()] = 8;     // Catch: NoSuchFieldError -> L31
        L39:
            b[BorderStyle.GROOVE.ordinal()] = 9;     // Catch: NoSuchFieldError -> L32
        L63:
            b[BorderStyle.RIDGE.ordinal()] = 10;     // Catch: NoSuchFieldError -> L33
        L17:
            int[] r5 = new int[RoundRectPath.Pos.values().length];
            a = r5;
            r5[RoundRectPath.Pos.CENTER.ordinal()] = 1;     // Catch: NoSuchFieldError -> L34
        L53:
            a[RoundRectPath.Pos.INNER2.ordinal()] = 2;     // Catch: NoSuchFieldError -> L35
        L57:
            a[RoundRectPath.Pos.OUTER2.ordinal()] = 3;     // Catch: NoSuchFieldError -> L36
        L65:
            a[RoundRectPath.Pos.INNER3.ordinal()] = 4;     // Catch: NoSuchFieldError -> L37
        L49:
            a[RoundRectPath.Pos.OUTER3.ordinal()] = 5;     // Catch: NoSuchFieldError -> L38
            return;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter r1) {
    }

    @Override // com.lynx.tasm.behavior.ui.utils.d
    public final a7a.k a() {
        return new a7a.e(this.f, this, this.g);
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        int r0 = c.a(this.y, this.z) >>> 24;
        if (r0 != 255) goto L5;
        return -1;
    L5:
        if (r0 != 0) goto L7;
        return -2;
    L7:
        return -3;
    }

    public final Path l() {
        if (this.A != null) goto L5;
        return null;
    L5:
        if (s() == false) goto L12;
        RoundRectPath r0 = this.n;
        if (r0 != null) goto L9;
        return null;
    L9:
        return r0.c;
    L12:
        return null;
    }

    public final boolean s() {
        if (this.A != null) goto L6;
        return false;
    L6:
        if (this.w == true) goto L8;
        return true;
    L8:
        Rect r1 = getBounds();
        if (r1.width() != 0) goto L11;
    L68:
        return false;
    L11:
        if (r1.height() == 0) goto L68;
        this.w = false;
        RectF r10 = b();
        if (this.A == null) goto L16;
        Rect r4 = getBounds();
        this.A.d(r4.width(), r4.height());
    L16:
        BorderRadius r5 = this.A;
        if (r5 == null) goto L19;
        float[] r6 = r5.a();
    L20:
        float[] r11 = r6;
        if (this.n != null) goto L23;
        this.n = new RoundRectPath();
    L23:
        this.n.d(r1, r11, r10, 1.0f, false);
        if (this.o != null) goto L26;
        this.o = new RoundRectPath();
    L26:
        this.o.d(r1, r11, r10, 0.0f, false);
        BorderRadius r7 = this.A;
        if (r7 != null) goto L29;
    L50:
        Path r8 = this.q;
        if (r8 != null) goto L53;
        this.q = new Path();
    L54:
        this.q.addRoundRect(new RectF(r1), RoundRectPath.c(r11, r10, -0.5f), Path.Direction.CW);
        RoundRectPath r2 = this.n;
        RectF r9 = r2.a;
        RectF r12 = this.o.a;
        float[] r3 = r2.b;
        if (this.s != null) goto L57;
        this.s = new PointF();
    L57:
        PointF r13 = this.s;
        RectF r14 = this.n.a;
        r13.x = r14.left;
        r13.y = r14.top;
        float r15 = r9.left;
        double r16 = r15;
        float r17 = r9.top;
        double r18 = r17;
        k(r16, r18, (r3[0] * 2.0f) + r15, (r3[1] * 2.0f) + r17, r12.left, r12.top, r16, r18, r13);
        if (this.v != null) goto L60;
        this.v = new PointF();
    L60:
        PointF r19 = this.v;
        float r20 = r9.left;
        r19.x = r20;
        float r110 = r9.bottom;
        r19.y = r110;
        double r21 = r20;
        double r111 = r110;
        k(r21, r110 - (r3[6] * 2.0f), (r3[7] * 2.0f) + r20, r111, r12.left, r12.bottom, r21, r111, r19);
        if (this.t != null) goto L63;
        this.t = new PointF();
    L63:
        PointF r22 = this.t;
        float r112 = r9.right;
        r22.x = r112;
        float r113 = r9.top;
        r22.y = r113;
        double r23 = r112 - (r3[2] * 2.0f);
        double r24 = r113;
        double r114 = r112;
        k(r23, r24, r114, (r3[3] * 2.0f) + r113, r12.right, r12.top, r114, r24, r22);
        if (this.u != null) goto L66;
        this.u = new PointF();
    L66:
        PointF r25 = this.u;
        float r26 = r9.right;
        r25.x = r26;
        float r27 = r9.bottom;
        r25.y = r27;
        double r28 = r26;
        double r115 = r27;
        k(r26 - (r3[4] * 2.0f), r27 - (r3[5] * 2.0f), r28, r115, r12.right, r12.bottom, r28, r115, r25);
        return true;
    L53:
        r8.reset();
        goto L54
    L29:
        if (r7.b() == false) goto L50;
        r(RoundRectPath.Pos.CENTER, r1, r11, r10);
        if (this.l == null) goto L50;
        int r29 = 0;
        boolean r30 = false;
        boolean r31 = false;
    L34:
        if (r29 > 8) goto L46;
        BorderStyle r32 = this.l[r29];
        if (r32 == null) goto L45;
        if (r32 != BorderStyle.DOUBLE) goto L41;
        r30 = true;
        goto L45
    L41:
        if (r32 != BorderStyle.GROOVE) goto L43;
    L44:
        r31 = true;
        goto L45
    L43:
        if (r32 == BorderStyle.RIDGE) goto L44;
    L45:
        r29 = r29 + 1;
        goto L34
    L46:
        if (r30 == false) goto L48;
        r(RoundRectPath.Pos.INNER3, r1, r11, r10);
        r(RoundRectPath.Pos.OUTER3, r1, r11, r10);
    L48:
        if (r31 == false) goto L50;
        r(RoundRectPath.Pos.INNER2, r1, r11, r10);
        r(RoundRectPath.Pos.OUTER2, r1, r11, r10);
        goto L50
    L19:
        r6 = null;
        goto L20
    }

    public final boolean n() {
        RectF r0 = b();
        if (r0.left <= 0.0f) goto L5;
    L12:
        return true;
    L5:
        if (r0.top > 0.0f) goto L12;
        if (r0.right > 0.0f) goto L12;
        if (r0.bottom > 0.0f) goto L12;
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getAlpha() {
        return this.z;
    }

    public static int f(float r1) {
        if (r1 <= 0.1f) goto L8;
        if (r1 >= 1.0f) goto L8;
        return 1;
    L8:
        return Math.round(r1);
    }

    public static boolean o(BorderStyle r1) {
        if (r1 != BorderStyle.DASHED) goto L5;
    L10:
        return true;
    L5:
        if (r1 == BorderStyle.DOTTED) goto L10;
        if (r1 == BorderStyle.HIDDEN) goto L10;
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas r29) {
        if (this.h == false) goto L5;
    L8:
        boolean r0 = true;
    L9:
        if (r0 == false) goto L11;
        e();
        this.i = false;
        this.h = false;
    L11:
        int r1 = c.a(this.y, this.z);
        if (Color.alpha(r1) == 0) goto L81;
        this.x.setColor(r1);
        this.x.setStyle(Paint.Style.FILL);
        BorderRadius r2 = this.A;
        if (r2 != null) goto L16;
    L67:
        int r3 = ((a7a.e) this.e).b();
        if (r3 == 4) goto L70;
        if (r3 != 1) goto L77;
        r29.drawRect(getBounds(), this.x);
        goto L81
    L77:
        if (r3 != 0) goto L79;
        r29.drawRect(this.c, this.x);
        goto L81
    L79:
        r29.drawRect(this.d, this.x);
        goto L81
    L70:
        if (n() == true) goto L72;
        Path r4 = null;
    L73:
        if (r4 == null) goto L81;
        r29.drawPath(r4, this.x);
        goto L81
    L72:
        RectF r5 = new RectF(getBounds());
        RectF r6 = new RectF(this.c);
        r4 = new Path();
        r4.setFillType(Path.FillType.EVEN_ODD);
        r4.addRect(r5, Path.Direction.CW);
        r4.addRect(r6, Path.Direction.CCW);
        goto L73
    L16:
        if (r2.b() == false) goto L67;
        if (s() == false) goto L81;
        int r7 = ((a7a.e) this.e).b();
        if (r7 == 1) goto L23;
        if (r7 != 0) goto L53;
        RoundRectPath r8 = this.n;
        if (r8 == null) goto L53;
        r8.b(r29, this.x);
    L53:
        if (r7 == 4) goto L55;
        r29.drawRect(this.d, this.x);
        goto L81
    L55:
        if (n() == true) goto L58;
    L63:
        Path r9 = null;
    L64:
        if (r9 == null) goto L81;
        r29.drawPath(r9, this.x);
        goto L81
    L58:
        if (this.o == null) goto L63;
        if (this.n == null) goto L63;
        r9 = new Path();
        r9.setFillType(Path.FillType.EVEN_ODD);
        r9.addPath(this.o.c);
        r9.addPath(this.n.c);
        goto L64
    L23:
        if ((((Color.alpha(h(0)) & Color.alpha(h(1))) & Color.alpha(h(2))) & Color.alpha(h(3))) == 255) goto L25;
        boolean r10 = true;
    L26:
        if (r10 == false) goto L28;
    L41:
        boolean r11 = true;
    L42:
        if (r11 == false) goto L46;
        RoundRectPath r12 = this.o;
        if (r12 == null) goto L46;
        r12.b(r29, this.x);
    L46:
        RoundRectPath r13 = this.n;
        if (r13 == null) goto L81;
        r13.b(r29, this.x);
        goto L81
    L28:
        if (o(i(0)) == false) goto L30;
    L37:
        boolean r14 = true;
    L38:
        if (r14 == true) goto L41;
        r11 = false;
        goto L42
    L30:
        if (o(i(1)) == true) goto L37;
        if (o(i(2)) == true) goto L37;
        if (o(i(3)) == true) goto L37;
        r14 = false;
        goto L38
    L25:
        r10 = false;
    L81:
        if ((!((ArrayList) ((a7a.e) this.e).a).isEmpty()) == false) goto L98;
        r29.save();
        RectF r15 = new RectF(getBounds());
        RectF r16 = new RectF(this.c);
        RectF r17 = new RectF(this.d);
        if (this.A == null) goto L85;
        s();
    L85:
        RoundRectPath r18 = this.o;
        if (r18 == null) goto L88;
        Path r19 = r18.c;
    L89:
        RoundRectPath r20 = this.n;
        if (r20 == null) goto L92;
        Path r21 = r20.c;
    L93:
        a7a.e r22 = (a7a.e) this.e;
        if (this.a == null) goto L96;
        boolean r23 = true;
    L97:
        r22.a(r29, r15, r16, r17, r15, r19, r21, r23);
        r29.restore();
        goto L98
    L96:
        r23 = false;
        goto L97
    L92:
        r21 = null;
        goto L93
    L88:
        r19 = null;
    L98:
        BorderRadius r24 = this.A;
        if (r24 != null) goto L101;
    L213:
        RectF r25 = b();
        b.c(r29, this.x, getBounds(), new int[]{f(r25.left), f(r25.top), f(r25.right), f(r25.bottom)}, new int[]{h(0), h(1), h(2), h(3)}, new BorderStyle[]{j(0), j(1), j(2), j(3)});
    L214:
        UIShadowProxy.a r26 = this.B;
        if (r26 != null) goto L217;
        return;
    L217:
        if (r26.a == null) goto L248;
        int r27 = r29.save();
        r29.translate(-r26.b, -r26.c);
        UIShadowProxy.d r28 = r26.a;
        ArrayList<UIShadowProxy.c> r30 = r28.b;
        if (r30 == null) goto L223;
        if (r30.isEmpty() == true) goto L223;
    L225:
        ArrayList<UIShadowProxy.c> r31 = r28.b;
        if (r31 == null) goto L235;
        int r32 = r31.size();
    L228:
        r32 = r32 - 1;
        if (r32 < 0) goto L235;
        UIShadowProxy.c r33 = (UIShadowProxy.c) ListProtector.get(r28.b, r32);
        if (r33 == null) goto L228;
        if (r33.k.a() == false) goto L228;
        r33.d(r29);
    L235:
        UIShadowProxy.b r34 = r28.c;
        if (r34 == null) goto L238;
        r34.b(r29);
    L238:
        r29.restoreToCount(r27);
        return;
    L223:
        if (r28.c != null) goto L225;
    L248:
        return;
    L101:
        if (r24.b() == false) goto L213;
        if (s() == false) goto L214;
        r29.save();
        RectF r35 = b();
        int r36 = f(r35.left);
        int r37 = f(r35.top);
        int r38 = f(r35.right);
        int r39 = f(r35.bottom);
        if (r37 > 0) goto L111;
        if (r39 > 0) goto L111;
        if (r36 > 0) goto L111;
        if (r38 > 0) goto L111;
    L212:
        r29.restore();
    L111:
        int r40 = h(8);
        int r41 = h(0);
        if (r41 == h(2)) goto L114;
    L118:
        boolean r42 = false;
    L119:
        if (r42 == true) goto L122;
        r41 = r40;
    L122:
        if (r37 != r36) goto L126;
        if (r39 != r36) goto L126;
        if (r38 != r36) goto L126;
        boolean r110 = true;
    L127:
        if (r110 == false) goto L162;
        if (r42 == false) goto L162;
        BorderStyle[] r43 = this.l;
        if (r43 == null) goto L158;
        BorderStyle r44 = r43[8];
        BorderStyle r45 = r43[0];
        if (r45 != null) goto L136;
        r45 = r44;
    L136:
        BorderStyle r46 = r43[2];
        if (r46 != null) goto L140;
        r46 = r44;
    L140:
        if (r46 != r45) goto L157;
        BorderStyle r47 = r43[1];
        if (r47 != null) goto L146;
        r47 = r44;
    L146:
        if (r47 != r45) goto L157;
        BorderStyle r48 = r43[3];
        if (r48 == null) goto L151;
        r44 = r48;
    L151:
        if (r44 != r45) goto L157;
        if (r45 == null) goto L158;
        if (r45.isSolidDashedOrDotted() == true) goto L158;
    L157:
        boolean r49 = false;
    L159:
        if (r49 == false) goto L162;
        if (r36 <= 0) goto L162;
        float r50 = r36;
        p(r29, 1, r41, r50, r50);
    L158:
        r49 = true;
    L162:
        int r111 = h(0);
        int r112 = h(1);
        int r113 = h(2);
        int r114 = h(3);
        RectF r51 = this.o.a;
        float r115 = r51.left;
        float r52 = r51.right;
        float r53 = r51.top;
        float r54 = r51.bottom;
        if (r37 > 0) goto L165;
    L175:
        float r210 = r53;
        float r211 = r52;
        RectF r116 = r35;
    L176:
        if (r38 > 0) goto L178;
    L188:
        if (r39 > 0) goto L190;
    L200:
        if (r36 <= 0) goto L212;
        if (Color.alpha(r111) == 0) goto L212;
        PointF r55 = this.s;
        float r56 = r55.x;
        float r57 = r55.y;
        PointF r58 = this.v;
        float r59 = r58.x;
        float r60 = r58.y;
        float r61 = r116.left;
        if (r110 == true) goto L210;
        float r62 = Math.max(r61, Math.max(r116.top, r116.bottom));
        if ((r62 - Math.min(r116.top, r116.bottom)) < 2.0f) goto L208;
        boolean r117 = true;
    L209:
        boolean r118 = r117;
        float r119 = r62;
    L211:
        r29.save();
        g(r29, r115, r210, r56, r57, r59, r60, r115, r54, r118);
        p(r29, 0, r111, r116.left, r119);
        r29.restore();
        goto L212
    L208:
        r117 = false;
        goto L209
    L210:
        r119 = r61;
        r118 = false;
        goto L211
    L190:
        if (Color.alpha(r114) == 0) goto L200;
        PointF r63 = this.v;
        float r64 = r63.x;
        float r65 = r63.y;
        PointF r66 = this.u;
        float r67 = r66.x;
        float r68 = r66.y;
        float r69 = r116.bottom;
        if (r110 == true) goto L198;
        float r70 = Math.max(r69, Math.max(r116.left, r116.right));
        if ((r70 - Math.min(r116.left, r116.right)) < 2.0f) goto L196;
        boolean r71 = true;
    L197:
        float r120 = r70;
        boolean r121 = r71;
    L199:
        r29.save();
        g(r29, r115, r54, r64, r65, r67, r68, r211, r54, r121);
        p(r29, 3, r114, r116.bottom, r120);
        r29.restore();
        goto L200
    L196:
        r71 = false;
        goto L197
    L198:
        r120 = r69;
        r121 = false;
        goto L199
    L178:
        if (Color.alpha(r113) == 0) goto L188;
        PointF r72 = this.t;
        float r73 = r72.x;
        float r74 = r72.y;
        PointF r75 = this.u;
        float r76 = r75.x;
        float r77 = r75.y;
        float r78 = r116.right;
        if (r110 == true) goto L186;
        float r79 = Math.max(r78, Math.max(r116.top, r116.bottom));
        if ((r79 - Math.min(r116.top, r116.bottom)) < 2.0f) goto L184;
        boolean r80 = true;
    L185:
        float r122 = r79;
        boolean r123 = r80;
    L187:
        r29.save();
        g(r29, r211, r210, r73, r74, r76, r77, r211, r54, r123);
        p(r29, 2, r113, r116.right, r122);
        r29.restore();
        goto L188
    L184:
        r80 = false;
        goto L185
    L186:
        r122 = r78;
        r123 = false;
        goto L187
    L165:
        if (Color.alpha(r112) == 0) goto L175;
        PointF r81 = this.s;
        float r82 = r81.x;
        float r83 = r81.y;
        PointF r84 = this.t;
        float r124 = r84.x;
        float r85 = r84.y;
        float r125 = r35.top;
        if (r110 == true) goto L173;
        float r86 = Math.max(r125, Math.max(r35.left, r35.right));
        if ((r86 - Math.min(r35.left, r35.right)) < 2.0f) goto L171;
        boolean r87 = true;
    L172:
        r125 = r86;
        boolean r212 = r87;
    L174:
        r29.save();
        r210 = r53;
        r211 = r52;
        r116 = r35;
        g(r29, r115, r53, r82, r83, r124, r85, r211, r210, r212);
        p(r29, 1, r112, r116.top, r125);
        r29.restore();
        goto L176
    L171:
        r87 = false;
        goto L172
    L173:
        r212 = false;
    L126:
        r110 = false;
        goto L127
    L114:
        if (r41 != h(1)) goto L118;
        if (r41 != h(3)) goto L118;
        r42 = true;
        goto L119
    L5:
        if (this.i == true) goto L8;
        r0 = false;
        goto L9
    }

    @Override // android.graphics.drawable.Drawable
    public final void getOutline(Outline r2) {
        if (this.A != null) goto L5;
    L10:
        r2.setRect(getBounds());
        return;
    L5:
        if (s() == false) goto L10;
        Path r0 = this.q;
        if (r0 == null) goto L10;
        r2.setConvexPath(r0);
    }

    public final int h(int r3) {
        k r0 = this.j;
        if (r0 == null) goto L5;
        float r1 = r0.a(r3);
    L6:
        k r2 = this.k;
        if (r2 == null) goto L9;
        float r4 = r2.a(r3);
    L10:
        int r5 = (((int) r4) << 24) & (-16777216);
        return r5 | (((int) r1) & 16777215);
    L9:
        r4 = 255.0f;
        goto L10
    L5:
        r1 = 0.0f;
        goto L6
    }

    public final BorderStyle i(int r3) {
        if (r3 > 8) goto L13;
        if (r3 < 0) goto L15;
        BorderStyle[] r1 = this.l;
        if (r1 == null) goto L16;
        BorderStyle r4 = r1[r3];
        if (r4 == null) goto L12;
        return r4;
    L12:
        return r1[8];
    L16:
        return null;
    L15:
        return null;
    L13:
        return null;
    }

    public final BorderStyle j(int r2) {
        BorderStyle[] r0 = this.l;
        if (r0 != null) goto L5;
        BorderStyle r3 = null;
    L9:
        if (r3 == null) goto L11;
        return r3;
    L11:
        if (this.f.getCssAlignWithLegacyW3c() == false) goto L14;
        return BorderStyle.NONE;
    L14:
        return BorderStyle.SOLID;
    L5:
        r3 = r0[r2];
        if (r3 != null) goto L9;
        r3 = r0[8];
        goto L9
    }

    public final RoundRectPath m(RoundRectPath.Pos r2) {
        if (r2 == null) goto L8;
        Map<RoundRectPath.Pos, RoundRectPath> r0 = this.p;
        if (r0 != null) goto L7;
        return null;
    L7:
        return (RoundRectPath) ((HashMap) r0).get(r2);
    L8:
        return null;
    }

    @Override // com.lynx.tasm.behavior.ui.utils.d, android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect r2) {
        this.w = true;
        super.onBoundsChange(r2);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int r2) {
        if (r2 == this.z) goto L6;
        this.z = r2;
        invalidateSelf();
        return;
    }

    public void setColor(int r1) {
        this.y = r1;
        invalidateSelf();
    }

    public BackgroundDrawable(LynxContext r2, float r3) {
        super(r2, r3);
        this.h = false;
        this.i = false;
        this.w = true;
        this.x = new Paint(1);
        this.y = 0;
        this.z = 255;
    }

    @Override // com.lynx.tasm.behavior.ui.utils.d
    public final boolean c(int r1, float r2) {
        boolean r3 = super.c(r1, r2);
        if (r3 == false) goto L5;
        this.w = true;
        this.i = true;
    L5:
        return r3;
    }

    @Override // com.lynx.tasm.behavior.ui.utils.d
    public final boolean d(float r1, float r2, float r3, float r4) {
        boolean r5 = super.d(r1, r2, r3, r4);
        if (r5 == false) goto L5;
        this.w = true;
        this.h = true;
    L5:
        return r5;
    }

    public final void r(RoundRectPath.Pos r7, Rect r8, float[] r9, RectF r10) {
        if (r7 == null) goto L16;
        Map<RoundRectPath.Pos, RoundRectPath> r0 = this.p;     // Catch: Exception -> L11
        if (r0 == null) goto L6;
        RoundRectPath r1 = (RoundRectPath) ((HashMap) r0).get(r7);     // Catch: Exception -> L11
    L7:
        if (r1 != null) goto L9;
        r1 = new RoundRectPath();     // Catch: Exception -> L11
        ((HashMap) this.p).put(r7, r1);     // Catch: Exception -> L11
    L9:
        r1.d(r8, r9, r10, r7.getOffset(), true);     // Catch: Exception -> L11
        return;
    L6:
        this.p = new HashMap();     // Catch: Exception -> L11
        r1 = null;
    L11:
        e = move-exception;
        LLog.e("BackgroundDrawable", "updateCachePath exception:" + e.toString());
        return;
    }

    public final void p(Canvas r10, int r11, int r12, float r13, float r14) {
        BorderStyle[] r1 = this.l;
        if (r1 != null) goto L5;
        BorderStyle r4 = null;
    L9:
        if (r4 == null) goto L11;
    L14:
        this.m = null;
        switch(a.b[r4.ordinal()]) {
            case 1: goto L32;
            case 2: goto L32;
            case 3: goto L31;
            case 4: goto L31;
            case 5: goto L33;
            case 6: goto L28;
            case 7: goto L24;
            case 8: goto L21;
            case 9: goto L19;
            case 10: goto L17;
            default: goto L33;
        };
    L17:
        q(r10, r11, r13 / 2.0f, (r12 & (-16777216)) | ((r12 & 16711422) >> 1), r12, false);
        return;
    L19:
        q(r10, r11, r13 / 2.0f, r12, (r12 & (-16777216)) | ((r12 & 16711422) >> 1), false);
        return;
    L21:
        q(r10, r11, r13 / 3.0f, r12, r12, true);
        return;
    L28:
        if (r11 != 1) goto L29;
    L27:
        int r0 = ((r12 & 16711422) >> 1) | (r12 & (-16777216));
    L34:
        this.x.setStyle(Paint.Style.STROKE);
        this.x.setColor(c.a(r0, this.z));
        this.x.setStrokeWidth(r14);
        this.x.setPathEffect(this.m);
        this.x.setAntiAlias(true);
        RoundRectPath r2 = m(RoundRectPath.Pos.CENTER);
        if (r2 == null) goto L37;
        r2.b(r10, this.x);
    L37:
        this.x.setPathEffect(null);
        return;
    L29:
        if (r11 != 0) goto L33;
    L31:
        this.m = r4.getPathEffect(r13);
        goto L33
    L32:
        return;
    L33:
        r0 = r12;
        goto L34
    L24:
        if (r11 == 3) goto L27;
        if (r11 != 2) goto L33;
    L11:
        if (this.f.getCssAlignWithLegacyW3c() == false) goto L13;
        r4 = BorderStyle.NONE;
        goto L14
    L13:
        r4 = BorderStyle.SOLID;
        goto L14
    L5:
        r4 = r1[r11];
        if (r4 != null) goto L9;
        r4 = r1[8];
        goto L9
    }

    public final void q(Canvas r3, int r4, float r5, int r6, int r7, boolean r8) {
        this.x.setPathEffect(null);
        this.x.setStyle(Paint.Style.STROKE);
        this.x.setStrokeWidth(r5);
        boolean r9 = true;
        if (r4 == 1) goto L7;
        if (r4 == 0) goto L7;
        r9 = false;
    L7:
        Paint r10 = this.x;
        if (r9 == false) goto L10;
        int r0 = r7;
    L11:
        r10.setColor(c.a(r0, this.z));
        if (r8 == false) goto L14;
        RoundRectPath.Pos r11 = RoundRectPath.Pos.OUTER3;
    L15:
        RoundRectPath r12 = m(r11);
        if (r12 == null) goto L18;
        r12.b(r3, this.x);
    L18:
        Paint r13 = this.x;
        if (r9 == true) goto L22;
        r6 = r7;
    L22:
        r13.setColor(c.a(r6, this.z));
        if (r8 == false) goto L25;
        RoundRectPath.Pos r14 = RoundRectPath.Pos.INNER3;
    L26:
        RoundRectPath r15 = m(r14);
        if (r15 == null) goto L30;
        r15.b(r3, this.x);
        return;
    L30:
        return;
    L25:
        r14 = RoundRectPath.Pos.INNER2;
        goto L26
    L14:
        r11 = RoundRectPath.Pos.OUTER2;
        goto L15
    L10:
        r0 = r6;
        goto L11
    }

    public static void k(double r21, double r23, double r25, double r27, double r29, double r31, double r33, double r35, PointF r37) {
        double r1 = (r21 + r25) / 2.0d;
        double r5 = (r23 + r27) / 2.0d;
        double r7 = r29 - r1;
        double r9 = r31 - r5;
        double r15 = Math.abs(r25 - r21) / 2.0d;
        double r17 = Math.abs(r27 - r23) / 2.0d;
        double r13 = ((r35 - r5) - r9) / ((r33 - r1) - r7);
        double r10 = r9 - (r7 * r13);
        double r18 = r17 * r17;
        double r8 = r15 * r15;
        double r11 = r18 + ((r8 * r13) * r13);
        double r3 = (((r15 * 2.0d) * r15) * r10) * r13;
        double r12 = (-(r8 * ((r10 * r10) - r18))) / r11;
        double r14 = r11 * 2.0d;
        double r2 = (-r3) / r14;
        double r4 = r2 - Math.sqrt(r12 + Math.pow(r3 / r14, 2.0d));
        double r16 = (r13 * r4) + r10;
        double r6 = r4 + r1;
        double r19 = r16 + r5;
        if (Double.isNaN(r6) == false) goto L5;
        return;
    L5:
        if (Double.isNaN(r19) == true) goto L9;
        r37.x = (float) r6;
        r37.y = (float) r19;
        return;
    }

    public final void g(Canvas r2, float r3, float r4, float r5, float r6, float r7, float r8, float r9, float r10, boolean r11) {
        if (r11 == false) goto L10;
        RoundRectPath r12 = this.o;
        if (r12 == null) goto L6;
        r2.clipPath(r12.c, Region.Op.INTERSECT);
    L6:
        RoundRectPath r13 = this.n;
        if (r13 == null) goto L10;
        r2.clipPath(r13.c, Region.Op.DIFFERENCE);
    L10:
        if (this.r != null) goto L12;
        this.r = new Path();
    L12:
        this.r.reset();
        this.r.moveTo(r3, r4);
        this.r.lineTo(r5, r6);
        this.r.lineTo(r7, r8);
        this.r.lineTo(r9, r10);
        this.r.lineTo(r3, r4);
        r2.clipPath(this.r);
    }
}
