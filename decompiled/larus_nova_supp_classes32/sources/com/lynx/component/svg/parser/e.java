package com.lynx.component.svg.parser;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.util.Base64;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.lynx.tasm.base.LLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class e {
    public final Canvas a;
    public final float b;
    public final com.lynx.component.svg.d c;
    public SVG d;
    public c e;
    public Stack<c> f;
    public Stack<SVG.c0> g;
    public Stack<Matrix> h;

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;
        public static final /* synthetic */ int[] b = null;
        public static final /* synthetic */ int[] c = null;

        static {
            int[] r0 = new int[SVG.Style.LineJoin.values().length];
            c = r0;
            r0[SVG.Style.LineJoin.Miter.ordinal()] = 1;     // Catch: NoSuchFieldError -> L22
        L54:
            c[SVG.Style.LineJoin.Round.ordinal()] = 2;     // Catch: NoSuchFieldError -> L23
        L42:
            c[SVG.Style.LineJoin.Bevel.ordinal()] = 3;     // Catch: NoSuchFieldError -> L24
        L8:
            int[] r3 = new int[SVG.Style.LineCap.values().length];
            b = r3;
            r3[SVG.Style.LineCap.Butt.ordinal()] = 1;     // Catch: NoSuchFieldError -> L25
        L62:
            b[SVG.Style.LineCap.Round.ordinal()] = 2;     // Catch: NoSuchFieldError -> L26
        L36:
            b[SVG.Style.LineCap.Square.ordinal()] = 3;     // Catch: NoSuchFieldError -> L27
        L12:
            int[] r4 = new int[PreserveAspectRatio.Alignment.values().length];
            a = r4;
            r4[PreserveAspectRatio.Alignment.xMidYMin.ordinal()] = 1;     // Catch: NoSuchFieldError -> L28
        L40:
            a[PreserveAspectRatio.Alignment.xMidYMid.ordinal()] = 2;     // Catch: NoSuchFieldError -> L29
        L46:
            a[PreserveAspectRatio.Alignment.xMidYMax.ordinal()] = 3;     // Catch: NoSuchFieldError -> L30
        L52:
            a[PreserveAspectRatio.Alignment.xMaxYMin.ordinal()] = 4;     // Catch: NoSuchFieldError -> L31
        L38:
            a[PreserveAspectRatio.Alignment.xMaxYMid.ordinal()] = 5;     // Catch: NoSuchFieldError -> L32
        L50:
            a[PreserveAspectRatio.Alignment.xMaxYMax.ordinal()] = 6;     // Catch: NoSuchFieldError -> L33
        L56:
            a[PreserveAspectRatio.Alignment.xMinYMid.ordinal()] = 7;     // Catch: NoSuchFieldError -> L34
        L44:
            a[PreserveAspectRatio.Alignment.xMinYMax.ordinal()] = 8;     // Catch: NoSuchFieldError -> L35
            return;
        }
    }

    public static class b {
        public final Path a;
        public float b;
        public float c;

        public final void b() {
            this.a.close();
        }

        public b(SVG.t r15) {
            this.a = new Path();
            if (r15 != null) goto L5;
            return;
        L5:
            int r1 = 0;
            int r2 = 0;
        L7:
            if (r1 >= r15.b) goto L34;
            byte r3 = r15.a[r1];
            if (r3 != 0) goto L11;
            float[] r4 = r15.c;
            int r5 = r2 + 1;
            int r6 = r5 + 1;
            c(r4[r2], r4[r5]);
        L32:
            r2 = r6;
        L33:
            r1 = r1 + 1;
            goto L7
        L11:
            if (r3 != 1) goto L13;
            float[] r7 = r15.c;
            int r8 = r2 + 1;
            float r9 = r7[r2];
            r6 = r8 + 1;
            float r10 = r7[r8];
            this.a.lineTo(r9, r10);
            this.b = r9;
            this.c = r10;
            goto L32
        L13:
            if (r3 != 2) goto L15;
            float[] r11 = r15.c;
            int r12 = r2 + 1;
            float r13 = r11[r2];
            int r14 = r12 + 1;
            float r16 = r11[r12];
            int r17 = r14 + 1;
            float r18 = r11[r14];
            int r19 = r17 + 1;
            float r20 = r11[r17];
            int r21 = r19 + 1;
            float r22 = r11[r19];
            float r23 = r11[r21];
            this.a.cubicTo(r13, r16, r18, r20, r22, r23);
            this.b = r22;
            this.c = r23;
            r2 = r21 + 1;
            goto L33
        L15:
            if (r3 != 3) goto L17;
            float[] r24 = r15.c;
            int r25 = r2 + 1;
            int r26 = r25 + 1;
            int r27 = r26 + 1;
            d(r24[r2], r24[r25], r24[r26], r24[r27]);
            r2 = r27 + 1;
            goto L33
        L17:
            if (r3 != 8) goto L19;
            b();
            goto L33
        L19:
            if ((r3 & 2) == 0) goto L21;
            boolean r110 = true;
        L23:
            if ((r3 & 1) == 0) goto L25;
            boolean r111 = true;
        L26:
            float[] r28 = r15.c;
            int r29 = r2 + 1;
            float r30 = r28[r2];
            int r31 = r29 + 1;
            float r32 = r28[r29];
            int r33 = r31 + 1;
            float r34 = r28[r31];
            int r35 = r33 + 1;
            float r112 = r28[r33];
            a(r30, r32, r34, r110, r111, r112, r28[r35]);
            r2 = r35 + 1;
            goto L33
        L25:
            r111 = false;
            goto L26
        L21:
            r110 = false;
            goto L23
        }

        public final void c(float r2, float r3) {
            this.a.moveTo(r2, r3);
            this.b = r2;
            this.c = r3;
        }

        public final void d(float r2, float r3, float r4, float r5) {
            this.a.quadTo(r2, r3, r4, r5);
            this.b = r4;
            this.c = r5;
        }

        public final void a(float r35, float r36, float r37, boolean r38, boolean r39, float r40, float r41) {
            float r4 = r41;
            float r5 = this.b;
            float r6 = this.c;
            if (r5 != r40) goto L8;
            if (r6 != r4) goto L8;
            b r3 = this;
            float r0 = r40;
        L56:
            r3.b = r0;
            r3.c = r4;
            return;
        L8:
            if (r35 != 0.0f) goto L10;
        L55:
            r3 = this;
            r0 = r40;
            r3.a.lineTo(r0, r4);
            r3.b = r0;
            r3.c = r4;
            goto L56
        L10:
            if (r36 == 0.0f) goto L55;
            float r7 = Math.abs(r35);
            float r8 = Math.abs(r36);
            double r9 = Math.toRadians(((double) r37) % 360.0d);
            double r11 = Math.cos(r9);
            double r10 = Math.sin(r9);
            double r13 = ((double) (r5 - r40)) / 2.0d;
            double r1 = ((double) (r6 - r4)) / 2.0d;
            double r12 = (r11 * r13) + (r10 * r1);
            double r14 = ((-r10) * r13) + (r1 * r11);
            double r2 = r7 * r7;
            double r15 = r8 * r8;
            double r19 = r12 * r12;
            double r21 = r14 * r14;
            double r23 = (r19 / r2) + (r21 / r15);
            if (r23 <= 0.99999d) goto L16;
            double r16 = Math.sqrt(r23) * 1.00001d;
            r7 = (float) (((double) r7) * r16);
            r8 = (float) (r16 * ((double) r8));
            r2 = r7 * r7;
            r15 = r8 * r8;
        L16:
            if (r38 != r39) goto L18;
            double r17 = -1.0d;
        L19:
            double r27 = r2 * r15;
            double r18 = r2 * r21;
            double r110 = r15 * r19;
            double r28 = ((r27 - r18) - r110) / (r18 + r110);
            if (r28 >= 0.0d) goto L22;
            r28 = 0.0d;
        L22:
            double r111 = r17 * Math.sqrt(r28);
            double r112 = r7;
            double r20 = r8;
            double r113 = ((r112 * r14) / r20) * r111;
            double r114 = r111 * (-((r20 * r12) / r112));
            float r29 = r7;
            float r210 = r8;
            r4 = r41;
            double r22 = (((double) (r5 + r40)) / 2.0d) + ((r11 * r113) - (r10 * r114));
            double r24 = (((double) (r6 + r4)) / 2.0d) + ((r10 * r113) + (r11 * r114));
            double r25 = (r12 - r113) / r112;
            double r115 = (r14 - r114) / r20;
            double r26 = ((-r12) - r113) / r112;
            double r30 = ((-r14) - r114) / r20;
            double r116 = (r25 * r25) + (r115 * r115);
            double r117 = Math.sqrt(r116);
            if (r115 >= 0.0d) goto L25;
            double r118 = -1.0d;
        L26:
            double r119 = r118 * Math.acos(r25 / r117);
            double r120 = Math.sqrt(r116 * ((r26 * r26) + (r30 * r30)));
            double r121 = (r25 * r26) + (r115 * r30);
            if (((r25 * r30) - (r115 * r26)) >= 0.0d) goto L29;
            double r31 = -1.0d;
        L30:
            double r122 = r121 / r120;
            if (r122 >= (-1.0d)) goto L34;
            double r32 = 3.141592653589793d;
        L37:
            double r33 = r31 * r32;
            if (r33 != 0.0d) goto L41;
            this.a.lineTo(r40, r4);
            this.b = r40;
            this.c = r4;
            r3 = this;
            r0 = r40;
            goto L56
        L41:
            if (r39 == true) goto L44;
            if (r33 <= 0.0d) goto L44;
            r33 = r33 - 6.283185307179586d;
        L48:
            double r34 = r33 % 6.283185307179586d;
            double r123 = r119 % 6.283185307179586d;
            int r42 = (int) Math.ceil((Math.abs(r34) * 2.0d) / 3.141592653589793d);
            double r43 = r34 / ((double) r42);
            double r124 = r43 / 2.0d;
            double r125 = (Math.sin(r124) * 1.3333333333333333d) / (Math.cos(r124) + 1.0d);
            int r44 = r42 * 6;
            float[] r126 = new float[r44];
            int r127 = 0;
            int r128 = 0;
        L49:
            if (r127 >= r42) goto L51;
            double r310 = r125;
            double r129 = (((double) r127) * r43) + r123;
            double r130 = Math.cos(r129);
            double r211 = Math.sin(r129);
            int r131 = r128 + 1;
            r126[r128] = (float) (r130 - (r310 * r211));
            int r45 = r131 + 1;
            int r132 = r42;
            r126[r131] = (float) (r211 + (r130 * r310));
            double r133 = r129 + r43;
            double r46 = Math.cos(r133);
            double r134 = Math.sin(r133);
            int r135 = r45 + 1;
            double r212 = r43;
            r126[r45] = (float) ((r310 * r134) + r46);
            int r47 = r135 + 1;
            r126[r135] = (float) (r134 - (r310 * r46));
            int r48 = r47 + 1;
            r126[r47] = (float) r46;
            r128 = r48 + 1;
            r126[r48] = (float) r134;
            r127 = r127 + 1;
            r44 = r44;
            r42 = r132;
            r43 = r212;
            r125 = r310;
            goto L49
        L51:
            int r311 = r44;
            Matrix r49 = new Matrix();
            r49.postScale(r29, r210);
            r49.postRotate(r37);
            r49.postTranslate((float) r22, (float) r24);
            r49.mapPoints(r126);
            r0 = r40;
            r126[r311 - 2] = r0;
            r126[r311 - 1] = r4;
            int r136 = 0;
        L52:
            if (r136 >= r311) goto L54;
            float r137 = r126[r136];
            float r138 = r126[r136 + 1];
            float r139 = r126[r136 + 2];
            float r140 = r126[r136 + 3];
            float r50 = r126[r136 + 4];
            float r51 = r126[r136 + 5];
            this.a.cubicTo(r137, r138, r139, r140, r50, r51);
            this.b = r50;
            this.c = r51;
            r136 = r136 + 6;
            goto L52
        L54:
            r3 = this;
        L44:
            if (r39 == false) goto L48;
            if (r33 >= 0.0d) goto L48;
            r33 = r33 + 6.283185307179586d;
            goto L48
        L34:
            if (r122 <= 1.0d) goto L36;
            r32 = 0.0d;
            goto L37
        L36:
            r32 = Math.acos(r122);
            goto L37
        L29:
            r31 = 1.0d;
            goto L30
        L25:
            r118 = 1.0d;
            goto L26
        L18:
            r17 = 1.0d;
            goto L19
        }
    }

    public class c {
        public final SVG.Style a;
        public boolean b;
        public boolean c;
        public final Paint d;
        public final Paint e;
        public SVG.b f;
        public SVG.b g;

        public c() {
            Paint r0 = new Paint();
            this.d = r0;
            r0.setFlags(193);
            r0.setHinting(0);
            r0.setStyle(Paint.Style.FILL);
            r0.setTypeface(Typeface.DEFAULT);
            Paint r1 = new Paint();
            this.e = r1;
            r1.setFlags(193);
            r1.setHinting(0);
            r1.setStyle(Paint.Style.STROKE);
            r1.setTypeface(Typeface.DEFAULT);
            this.a = SVG.Style.a();
        }

        public c(c r3) {
            this.b = r3.b;
            this.c = r3.c;
            this.d = new Paint(r3.d);
            this.e = new Paint(r3.e);
            SVG.b r0 = r3.f;
            if (r0 == null) goto L5;
            this.f = new SVG.b(r0);
        L5:
            SVG.b r1 = r3.g;
            if (r1 == null) goto L12;
            this.g = new SVG.b(r1);
        L12:
            this.a = (SVG.Style) r3.a.clone();     // Catch: CloneNotSupportedException -> L10
            return;
        L10:
            this.a = SVG.Style.a();
        }
    }

    public final void G() {
        this.a.restore();
        this.e = this.f.pop();
    }

    public final void H() {
        this.a.save();
        this.f.push(this.e);
        this.e = new c(this.e);
    }

    public final void L() {
        SVG.Style r0 = this.e.a;
        SVG.h0 r1 = r0.y;
        if ((r1 instanceof SVG.f) == false) goto L6;
        int r2 = ((SVG.f) r1).a;
    L8:
        Float r3 = r0.z;
        if (r3 == null) goto L11;
        r2 = f(r2, r3.floatValue());
    L11:
        this.a.drawColor(r2);
        return;
    L6:
        if ((r1 instanceof SVG.g) == false) goto L13;
        r2 = r0.n.a;
        goto L8
    }

    public final boolean M() {
        Boolean r0 = this.e.a.r;
        if (r0 != null) goto L5;
        return true;
    L5:
        return r0.booleanValue();
    }

    public final boolean i() {
        Boolean r0 = this.e.a.q;
        if (r0 != null) goto L5;
        return true;
    L5:
        return r0.booleanValue();
    }

    public final Path.FillType q() {
        SVG.Style.FillRule r0 = this.e.a.v;
        if (r0 == null) goto L9;
        if (r0 != SVG.Style.FillRule.EvenOdd) goto L9;
        return Path.FillType.EVEN_ODD;
    L9:
        return Path.FillType.WINDING;
    }

    public final boolean y() {
        int r3 = 0;
        if (this.e.a.m.floatValue() >= 1.0f) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L8;
        return false;
    L8:
        Canvas r1 = this.a;
        int r2 = (int) (this.e.a.m.floatValue() * 256.0f);
        if (r2 < 0) goto L15;
        r3 = 255;
        if (r2 > 255) goto L15;
        r3 = r2;
    L15:
        r1.saveLayerAlpha(null, r3, 31);
        this.f.push(this.e);
        this.e = new c(this.e);
        return true;
    L5:
        r0 = false;
        goto L6
    }

    public static SVG.b b(Path r4) {
        RectF r0 = new RectF();
        r4.computeBounds(r0, true);
        return new SVG.b(r0.left, r0.top, r0.width(), r0.height());
    }

    public static Path u(SVG.v r5) {
        Path r0 = new Path();
        float[] r1 = r5.i;
        r0.moveTo(r1[0], r1[1]);
        int r2 = 2;
    L3:
        float[] r3 = r5.i;
        if (r2 >= r3.length) goto L7;
        r0.lineTo(r3[r2], r3[r2 + 1]);
        r2 = r2 + 2;
        goto L3
    L7:
        if ((r5 instanceof SVG.w) == false) goto L10;
        r0.close();
    L10:
        if (r5.g != null) goto L12;
        r5.g = b(r0);
    L12:
        return r0;
    }

    public final void A(SVG.g0 r10) {
        if ((r10 instanceof SVG.q) == false) goto L5;
        return;
    L5:
        H();
        if ((r10 instanceof SVG.e0) == false) goto L12;
        Boolean r0 = ((SVG.e0) r10).d;
        if (r0 == null) goto L12;
        c r1 = this.e;
        r0.booleanValue();
        r1.getClass();
    L12:
        if ((r10 instanceof SVG.a0) == false) goto L14;
        SVG.a0 r11 = (SVG.a0) r10;
        z(r11, w(r11.k, r11.l, r11.m, r11.n), r11.j, r11.i);
    L310:
        G();
        return;
    L14:
        float r2 = 0.0f;
        Bitmap r3 = null;
        if ((r10 instanceof SVG.l0) == false) goto L50;
        SVG.l0 r12 = (SVG.l0) r10;
        g("Use render", new Object[0]);
        SVG.o r4 = r12.m;
        if (r4 != null) goto L19;
    L20:
        SVG.o r5 = r12.n;
        if (r5 != null) goto L23;
    L25:
        K(this.e, r12);
        if (i() == false) goto L310;
        SVG.g0 r6 = r12.a.f(r12.j);
        if (r6 != null) goto L31;
        l("Use reference '%s' not found", new Object[]{r12.j});
        goto L310
    L31:
        Matrix r7 = r12.i;
        if (r7 == null) goto L34;
        this.a.concat(r7);
    L34:
        SVG.o r8 = r12.k;
        if (r8 == null) goto L37;
        float r9 = r8.d(this);
    L38:
        SVG.o r13 = r12.l;
        if (r13 == null) goto L41;
        r2 = r13.e(this);
    L41:
        this.a.translate(r9, r2);
        d(r12, r12.g);
        boolean r14 = y();
        this.g.push(r12);
        this.h.push(this.a.getMatrix());
        if ((r6 instanceof SVG.a0) == false) goto L44;
        SVG.a0 r15 = (SVG.a0) r6;
        SVG.b r16 = w(null, null, r12.m, r12.n);
        H();
        z(r15, r16, r15.j, r15.i);
        G();
    L45:
        this.g.pop();
        this.h.pop();
        if (r14 == false) goto L48;
        G();
    L48:
        I(r12);
        goto L310
    L44:
        A(r6);
        goto L45
    L37:
        r9 = 0.0f;
        goto L38
    L23:
        if (r5.g() == false) goto L25;
    L19:
        if (r4.g() == true) goto L310;
    L50:
        if ((r10 instanceof SVG.l) == false) goto L62;
        SVG.l r17 = (SVG.l) r10;
        g(r17.c() + " render", new Object[0]);
        K(this.e, r17);
        if (i() == false) goto L310;
        Matrix r18 = r17.i;
        if (r18 == null) goto L57;
        this.a.concat(r18);
    L57:
        d(r17, r17.g);
        boolean r19 = y();
        B(r17);
        if (r19 == false) goto L60;
        G();
    L60:
        I(r17);
        goto L310
    L62:
        if ((r10 instanceof SVG.n) == false) goto L99;
        SVG.n r110 = (SVG.n) r10;
        g("Image render", new Object[0]);
        SVG.o r20 = r110.m;
        if (r20 == null) goto L310;
        if (r20.g() == true) goto L310;
        SVG.o r21 = r110.n;
        if (r21 == null) goto L310;
        if (r21.g() == true) goto L310;
        String r22 = r110.j;
        if (r22 == null) goto L310;
        PreserveAspectRatio r23 = r110.i;
        if (r23 != null) goto L80;
        r23 = PreserveAspectRatio.d;
    L80:
        if (r22.startsWith("data:") == true) goto L83;
    L95:
        if (r3 != null) goto L97;
        this.c.b(r110.j, new d(this, r110, r23));
        goto L310
    L97:
        D(r110, r23, r3);
        goto L310
    L83:
        if (r22.length() < 14) goto L95;
        int r24 = r22.indexOf(44);
        if (r24 < 12) goto L95;
        if (";base64".equals(r22.substring(r24 - 7, r24)) == false) goto L95;
        byte[] r25 = Base64.decode(r22.substring(r24 + 1), 0);     // Catch: Exception -> L94
        r3 = BitmapFactory.decodeByteArray(r25, 0, r25.length);     // Catch: Exception -> L94
        goto L95
    L99:
        if ((r10 instanceof SVG.s) == false) goto L135;
        SVG.s r111 = (SVG.s) r10;
        g("Path render", new Object[0]);
        if (r111.i == null) goto L310;
        K(this.e, r111);
        if (i() == false) goto L310;
        if (M() == false) goto L310;
        c r26 = this.e;
        if (r26.c == false) goto L112;
    L114:
        Matrix r27 = r111.h;
        if (r27 == null) goto L117;
        this.a.concat(r27);
    L117:
        Path r28 = new b(r111.i).a;
        if (r111.g != null) goto L120;
        r111.g = b(r28);
    L120:
        I(r111);
        e(r111);
        d(r111, r111.g);
        boolean r29 = y();
        c r30 = this.e;
        if (r30.b == false) goto L130;
        SVG.Style.FillRule r31 = r30.a.c;
        if (r31 != null) goto L125;
    L127:
        Path.FillType r32 = Path.FillType.WINDING;
    L128:
        r28.setFillType(r32);
        j(r111, r28);
        goto L130
    L125:
        if (r31 != SVG.Style.FillRule.EvenOdd) goto L127;
        r32 = Path.FillType.EVEN_ODD;
    L130:
        if (this.e.c == false) goto L132;
        k(r28);
    L132:
        if (r29 == false) goto L310;
        G();
        goto L310
    L112:
        if (r26.b == true) goto L114;
    L135:
        if ((r10 instanceof SVG.x) == false) goto L163;
        SVG.x r112 = (SVG.x) r10;
        g("Rect render", new Object[0]);
        SVG.o r33 = r112.k;
        if (r33 == null) goto L310;
        if (r112.l == null) goto L310;
        if (r33.g() == true) goto L310;
        if (r112.l.g() == true) goto L310;
        K(this.e, r112);
        if (i() == false) goto L310;
        if (M() == false) goto L310;
        Matrix r34 = r112.h;
        if (r34 == null) goto L154;
        this.a.concat(r34);
    L154:
        Path r35 = v(r112);
        I(r112);
        e(r112);
        d(r112, r112.g);
        boolean r36 = y();
        if (this.e.b == false) goto L158;
        j(r112, r35);
    L158:
        if (this.e.c == false) goto L160;
        k(r35);
    L160:
        if (r36 == false) goto L310;
        G();
        goto L310
    L163:
        if ((r10 instanceof SVG.d) == false) goto L187;
        SVG.d r113 = (SVG.d) r10;
        g("Circle render", new Object[0]);
        SVG.o r37 = r113.k;
        if (r37 == null) goto L310;
        if (r37.g() == true) goto L310;
        K(this.e, r113);
        if (i() == false) goto L310;
        if (M() == false) goto L310;
        Matrix r38 = r113.h;
        if (r38 == null) goto L178;
        this.a.concat(r38);
    L178:
        Path r39 = s(r113);
        I(r113);
        e(r113);
        d(r113, r113.g);
        boolean r40 = y();
        if (this.e.b == false) goto L182;
        j(r113, r39);
    L182:
        if (this.e.c == false) goto L184;
        k(r39);
    L184:
        if (r40 == false) goto L310;
        G();
        goto L310
    L187:
        if ((r10 instanceof SVG.i) == false) goto L215;
        SVG.i r114 = (SVG.i) r10;
        g("Ellipse render", new Object[0]);
        SVG.o r41 = r114.k;
        if (r41 == null) goto L310;
        if (r114.l == null) goto L310;
        if (r41.g() == true) goto L310;
        if (r114.l.g() == true) goto L310;
        K(this.e, r114);
        if (i() == false) goto L310;
        if (M() == false) goto L310;
        Matrix r42 = r114.h;
        if (r42 == null) goto L206;
        this.a.concat(r42);
    L206:
        Path r43 = t(r114);
        I(r114);
        e(r114);
        d(r114, r114.g);
        boolean r44 = y();
        if (this.e.b == false) goto L210;
        j(r114, r43);
    L210:
        if (this.e.c == false) goto L212;
        k(r43);
    L212:
        if (r44 == false) goto L310;
        G();
        goto L310
    L215:
        if ((r10 instanceof SVG.p) == false) goto L251;
        SVG.p r115 = (SVG.p) r10;
        g("Line render", new Object[0]);
        K(this.e, r115);
        if (i() == false) goto L310;
        if (M() == false) goto L310;
        if (this.e.c == false) goto L310;
        Matrix r45 = r115.h;
        if (r45 == null) goto L228;
        this.a.concat(r45);
    L228:
        SVG.o r46 = r115.i;
        if (r46 != null) goto L231;
        float r47 = 0.0f;
    L232:
        SVG.o r48 = r115.j;
        if (r48 != null) goto L235;
        float r49 = 0.0f;
    L236:
        SVG.o r50 = r115.k;
        if (r50 != null) goto L239;
        float r51 = 0.0f;
    L240:
        SVG.o r52 = r115.l;
        if (r52 == null) goto L245;
        r2 = r52.e(this);
    L245:
        if (r115.g != null) goto L247;
        r115.g = new SVG.b(Math.min(r47, r51), Math.min(r49, r2), Math.abs(r51 - r47), Math.abs(r2 - r49));
    L247:
        Path r53 = new Path();
        r53.moveTo(r47, r49);
        r53.lineTo(r51, r2);
        I(r115);
        e(r115);
        d(r115, r115.g);
        boolean r116 = y();
        k(r53);
        if (r116 == false) goto L310;
        G();
        goto L310
    L239:
        r51 = r50.d(this);
        goto L240
    L235:
        r49 = r48.e(this);
        goto L236
    L231:
        r47 = r46.d(this);
        goto L232
    L251:
        if ((r10 instanceof SVG.w) == false) goto L278;
        SVG.w r117 = (SVG.w) r10;
        g("Polygon render", new Object[0]);
        K(this.e, r117);
        if (i() == false) goto L310;
        if (M() == false) goto L310;
        c r54 = this.e;
        if (r54.c == false) goto L261;
    L263:
        Matrix r55 = r117.h;
        if (r55 == null) goto L267;
        this.a.concat(r55);
    L267:
        if (r117.i.length < 2) goto L310;
        Path r56 = u(r117);
        I(r117);
        e(r117);
        d(r117, r117.g);
        boolean r57 = y();
        if (this.e.b == false) goto L273;
        j(r117, r56);
    L273:
        if (this.e.c == false) goto L275;
        k(r56);
    L275:
        if (r57 == false) goto L310;
        G();
        goto L310
    L261:
        if (r54.b == true) goto L263;
    L278:
        if ((r10 instanceof SVG.v) == false) goto L310;
        SVG.v r118 = (SVG.v) r10;
        g("PolyLine render", new Object[0]);
        K(this.e, r118);
        if (i() == false) goto L310;
        if (M() == false) goto L310;
        c r58 = this.e;
        if (r58.c == false) goto L288;
    L290:
        Matrix r59 = r118.h;
        if (r59 == null) goto L294;
        this.a.concat(r59);
    L294:
        if (r118.i.length < 2) goto L310;
        Path r60 = u(r118);
        I(r118);
        SVG.Style.FillRule r61 = this.e.a.c;
        if (r61 != null) goto L299;
    L301:
        Path.FillType r62 = Path.FillType.WINDING;
    L302:
        r60.setFillType(r62);
        e(r118);
        d(r118, r118.g);
        boolean r63 = y();
        if (this.e.b == false) goto L306;
        j(r118, r60);
    L306:
        if (this.e.c == false) goto L308;
        k(r60);
    L308:
        if (r63 == false) goto L310;
        G();
        goto L310
    L299:
        if (r61 != SVG.Style.FillRule.EvenOdd) goto L301;
        r62 = Path.FillType.EVEN_ODD;
        goto L302
    L288:
        if (r58.b == true) goto L290;
        goto L290
    }

    public final void B(SVG.c0 r3) {
        this.g.push(r3);
        this.h.push(this.a.getMatrix());
        Iterator<SVG.g0> r4 = r3.getChildren().iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        A(r4.next());
        goto L4
    L6:
        this.g.pop();
        this.h.pop();
    }

    public final void I(SVG.d0 r10) {
        if (r10.b != null) goto L6;
        return;
    L6:
        if (r10.g != null) goto L8;
        return;
    L8:
        Matrix r0 = new Matrix();
        if (this.h.peek().invert(r0) == false) goto L44;
        SVG.b r11 = r10.g;
        float r2 = r11.a;
        float r4 = r11.b;
        float r6 = r11.c + r2;
        int r7 = 2;
        float r5 = r4 + r11.d;
        float[] r1 = {r2, r4, r6, r4, r6, r5, r2, r5};
        r0.preConcat(this.a.getMatrix());
        r0.mapPoints(r1);
        float r3 = r1[0];
        float r8 = r1[1];
        RectF r9 = new RectF(r3, r8, r3, r8);
    L11:
        if (r7 > 6) goto L25;
        float r12 = r1[r7];
        if (r12 >= r9.left) goto L16;
        r9.left = r12;
    L16:
        if (r12 <= r9.right) goto L18;
        r9.right = r12;
    L18:
        float r13 = r1[r7 + 1];
        if (r13 >= r9.top) goto L22;
        r9.top = r13;
    L22:
        if (r13 <= r9.bottom) goto L24;
        r9.bottom = r13;
    L24:
        r7 = r7 + 2;
        goto L11
    L25:
        SVG.d0 r14 = (SVG.d0) this.g.peek();
        SVG.b r15 = r14.g;
        if (r15 != null) goto L28;
        float r16 = r9.left;
        float r17 = r9.top;
        r14.g = new SVG.b(r16, r17, r9.right - r16, r9.bottom - r17);
        return;
    L28:
        float r18 = r9.left;
        float r19 = r9.top;
        float r20 = r9.right - r18;
        float r21 = r9.bottom - r19;
        if (r18 >= r15.a) goto L32;
        r15.a = r18;
    L32:
        if (r19 >= r15.b) goto L34;
        r15.b = r19;
    L34:
        float r110 = r18 + r20;
        float r22 = r15.a;
        if (r110 <= (r15.c + r22)) goto L37;
        r15.c = r110 - r22;
    L37:
        float r23 = r19 + r21;
        float r111 = r15.b;
        if (r23 <= (r15.d + r111)) goto L46;
        r15.d = r23 - r111;
        return;
    L46:
        return;
    }

    public final void e(SVG.d0 r4) {
        SVG.h0 r0 = this.e.a.b;
        if ((r0 instanceof SVG.r) == false) goto L5;
        h(true, r4.g, (SVG.r) r0);
    L5:
        SVG.h0 r1 = this.e.a.e;
        if ((r1 instanceof SVG.r) == false) goto L9;
        h(false, r4.g, (SVG.r) r1);
        return;
    }

    public final void k(Path r6) {
        c r0 = this.e;
        if (r0.a.A != SVG.Style.VectorEffect.NonScalingStroke) goto L10;
        Matrix r1 = this.a.getMatrix();
        Path r2 = new Path();
        r6.transform(r1, r2);
        this.a.setMatrix(new Matrix());
        Shader r7 = this.e.e.getShader();
        Matrix r3 = new Matrix();
        if (r7 == null) goto L7;
        r7.getLocalMatrix(r3);
        Matrix r4 = new Matrix(r3);
        r4.postConcat(r1);
        r7.setLocalMatrix(r4);
    L7:
        this.a.drawPath(r2, this.e.e);
        this.a.setMatrix(r1);
        if (r7 == null) goto L12;
        r7.setLocalMatrix(r3);
        return;
    L12:
        return;
    L10:
        this.a.drawPath(r6, r0.e);
    }

    public final Path s(SVG.d r20) {
        SVG.o r2 = r20.i;
        float r3 = 0.0f;
        if (r2 == null) goto L5;
        float r4 = r2.d(this);
    L6:
        SVG.o r5 = r20.j;
        if (r5 == null) goto L9;
        r3 = r5.e(this);
    L9:
        float r6 = r20.k.b(this);
        float r11 = r4 - r6;
        float r12 = r3 - r6;
        float r13 = r4 + r6;
        float r14 = r3 + r6;
        if (r20.g != null) goto L12;
        float r7 = 2.0f * r6;
        r20.g = new SVG.b(r11, r12, r7, r7);
    L12:
        float r1 = 0.5522848f * r6;
        Path r15 = new Path();
        r15.moveTo(r13, r3);
        float r16 = r3 + r1;
        float r17 = r4 + r1;
        r15.cubicTo(r13, r16, r17, r14, r4, r14);
        float r18 = r4 - r1;
        r15.cubicTo(r18, r14, r11, r16, r11, r3);
        float r8 = r3 - r1;
        r15.cubicTo(r11, r8, r18, r12, r4, r12);
        r15.cubicTo(r17, r12, r13, r8, r13, r3);
        r15.close();
        return r15;
    L5:
        r4 = 0.0f;
        goto L6
    }

    public final Path t(SVG.i r20) {
        SVG.o r2 = r20.i;
        float r3 = 0.0f;
        if (r2 == null) goto L5;
        float r4 = r2.d(this);
    L6:
        SVG.o r5 = r20.j;
        if (r5 == null) goto L9;
        r3 = r5.e(this);
    L9:
        float r6 = r20.k.d(this);
        float r7 = r20.l.e(this);
        float r11 = r4 - r6;
        float r12 = r3 - r7;
        float r13 = r4 + r6;
        float r14 = r3 + r7;
        if (r20.g != null) goto L12;
        r20.g = new SVG.b(r11, r12, r6 * 2.0f, 2.0f * r7);
    L12:
        float r15 = r6 * 0.5522848f;
        float r1 = 0.5522848f * r7;
        Path r10 = new Path();
        r10.moveTo(r4, r12);
        float r16 = r4 + r15;
        float r17 = r3 - r1;
        r10.cubicTo(r16, r12, r13, r17, r13, r3);
        float r8 = r1 + r3;
        r10.cubicTo(r13, r8, r16, r14, r4, r14);
        float r18 = r4 - r15;
        r10.cubicTo(r18, r14, r11, r8, r11, r3);
        r10.cubicTo(r11, r17, r18, r12, r4, r12);
        r10.close();
        return r10;
    L5:
        r4 = 0.0f;
        goto L6
    }

    public final Path v(SVG.x r24) {
        SVG.o r2 = r24.m;
        if (r2 == null) goto L5;
    L7:
        if (r2 != null) goto L11;
        float r3 = r24.n.e(this);
    L9:
        float r4 = r3;
    L14:
        float r5 = Math.min(r3, r24.k.d(this) / 2.0f);
        float r6 = Math.min(r4, r24.l.e(this) / 2.0f);
        SVG.o r7 = r24.i;
        if (r7 == null) goto L17;
        float r8 = r7.d(this);
    L18:
        SVG.o r9 = r24.j;
        if (r9 == null) goto L21;
        float r13 = r9.e(this);
    L22:
        float r10 = r24.k.d(this);
        float r11 = r24.l.e(this);
        if (r24.g != null) goto L25;
        r24.g = new SVG.b(r8, r13, r10, r11);
    L25:
        float r15 = r8 + r10;
        float r1 = r13 + r11;
        Path r14 = new Path();
        if (r5 != 0.0f) goto L28;
    L31:
        float r12 = r8;
        float r16 = r13;
        r14.addRect(r12, r16, r15, r1, Path.Direction.CW);
        return r14;
    L28:
        if (r6 == 0.0f) goto L31;
        float r17 = r5 * 0.5522848f;
        float r18 = 0.5522848f * r6;
        float r19 = r13 + r6;
        r14.moveTo(r8, r19);
        float r110 = r19 - r18;
        float r111 = r8 + r5;
        float r21 = r111 - r17;
        r14.cubicTo(r8, r110, r21, r13, r111, r13);
        float r20 = r15 - r5;
        r14.lineTo(r20, r13);
        float r22 = r20 + r17;
        r14.cubicTo(r22, r13, r15, r110, r15, r19);
        float r112 = r1 - r6;
        r14.lineTo(r15, r112);
        float r113 = r112 + r18;
        r14.cubicTo(r15, r113, r22, r1, r20, r1);
        r14.lineTo(r111, r1);
        r14.cubicTo(r21, r1, r8, r113, r8, r112);
        r14.lineTo(r8, r19);
        r14.close();
        return r14;
    L21:
        r13 = 0.0f;
        goto L22
    L17:
        r8 = 0.0f;
        goto L18
    L11:
        if (r24.n != null) goto L13;
        r3 = r2.d(this);
        goto L9
    L13:
        r3 = r2.d(this);
        r4 = r24.n.e(this);
        goto L14
    L5:
        if (r24.n != null) goto L7;
        r3 = 0.0f;
        r4 = 0.0f;
        goto L14
    }

    public static int f(int r2, float r3) {
        int r1 = 255;
        int r4 = Math.round(((r2 >> 24) & 255) * r3);
        if (r4 >= 0) goto L5;
        r1 = 0;
    L9:
        return (r2 & 16777215) | (r1 << 24);
    L5:
        if (r4 > 255) goto L9;
        r1 = r4;
        goto L9
    }

    public static void g(String r1, Object... r2) {
        LLog.d("SVGAndroidRenderer", String.format(r1, r2));
    }

    public static void l(String r1, Object... r2) {
        LLog.e("SVGAndroidRenderer", String.format(r1, r2));
    }

    public static void m(SVG.j r4, String r5) {
        SVG.e0 r0 = r4.a.f(r5);
        if (r0 != null) goto L7;
        LLog.w("SVGAndroidRenderer", String.format("Gradient reference '%s' not found", new Object[]{r5}));
        return;
    L7:
        if ((r0 instanceof SVG.j) == true) goto L10;
        l("Gradient href attributes must point to other gradient elements", new Object[0]);
        return;
    L10:
        if (r0 != r4) goto L13;
        l("Circular reference in gradient href attribute '%s'", new Object[]{r5});
        return;
    L13:
        SVG.j r6 = (SVG.j) r0;
        if (r4.h != null) goto L17;
        r4.h = r6.h;
    L17:
        if (r4.i != null) goto L20;
        r4.i = r6.i;
    L20:
        if (r4.j != null) goto L23;
        r4.j = r6.j;
    L23:
        if (r4.g.isEmpty() == false) goto L46;
        r4.g = r6.g;
    L46:
        if ((r4 instanceof SVG.f0) == false) goto L39;
        SVG.f0 r1 = (SVG.f0) r4;     // Catch: ClassCastException -> L41
        SVG.f0 r2 = (SVG.f0) r0;     // Catch: ClassCastException -> L41
        if (r1.l != null) goto L31;
        r1.l = r2.l;     // Catch: ClassCastException -> L41
    L31:
        if (r1.m != null) goto L34;
        r1.m = r2.m;     // Catch: ClassCastException -> L41
    L34:
        if (r1.n != null) goto L37;
        r1.n = r2.n;     // Catch: ClassCastException -> L41
    L37:
        if (r1.o != null) goto L42;
        r1.o = r2.o;     // Catch: ClassCastException -> L41
        goto L42
    L39:
        n((SVG.j0) r4, (SVG.j0) r0);     // Catch: ClassCastException -> L41
    L42:
        String r7 = r6.k;
        if (r7 == null) goto L47;
        m(r4, r7);
        return;
    }

    public static void n(SVG.j0 r1, SVG.j0 r2) {
        if (r1.l != null) goto L6;
        r1.l = r2.l;
    L6:
        if (r1.m != null) goto L9;
        r1.m = r2.m;
    L9:
        if (r1.n != null) goto L12;
        r1.n = r2.n;
    L12:
        if (r1.o != null) goto L15;
        r1.o = r2.o;
    L15:
        if (r1.p != null) goto L18;
        r1.p = r2.p;
        return;
    }

    public static void o(SVG.u r4, String r5) {
        SVG.e0 r0 = r4.a.f(r5);
        if (r0 != null) goto L7;
        LLog.w("SVGAndroidRenderer", String.format("Pattern reference '%s' not found", new Object[]{r5}));
        return;
    L7:
        if ((r0 instanceof SVG.u) == true) goto L10;
        l("Pattern href attributes must point to other pattern elements", new Object[0]);
        return;
    L10:
        if (r0 != r4) goto L13;
        l("Circular reference in pattern href attribute '%s'", new Object[]{r5});
        return;
    L13:
        SVG.u r1 = (SVG.u) r0;
        if (r4.k != null) goto L17;
        r4.k = r1.k;
    L17:
        if (r4.l != null) goto L20;
        r4.l = r1.l;
    L20:
        if (r4.m != null) goto L23;
        r4.m = r1.m;
    L23:
        if (r4.n != null) goto L26;
        r4.n = r1.n;
    L26:
        if (r4.o != null) goto L29;
        r4.o = r1.o;
    L29:
        if (r4.p != null) goto L32;
        r4.p = r1.p;
    L32:
        if (r4.q != null) goto L35;
        r4.q = r1.q;
    L35:
        if (r4.h.isEmpty() == false) goto L38;
        r4.h = r1.h;
    L38:
        if (r4.j != null) goto L41;
        r4.j = r1.j;
    L41:
        if (r4.i != null) goto L43;
        r4.i = r1.i;
    L43:
        String r6 = r1.r;
        if (r6 == null) goto L47;
        o(r4, r6);
        return;
    }

    public static boolean r(SVG.Style r2, long r3) {
        if ((r2.a & r3) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final void C(SVG r6, com.lynx.component.svg.parser.c r7) {
        this.d = r6;
        SVG.a0 r8 = r6.a;
        if (r8 != null) goto L6;
        LLog.w("SVGAndroidRenderer", String.format("Nothing to render. Document is empty.", new Object[0]));
        return;
    L6:
        SVG.b r0 = r8.j;
        PreserveAspectRatio r1 = r8.i;
        this.e = new c();
        this.f = new Stack();
        J(this.e, SVG.Style.a());
        c r2 = this.e;
        r2.f = null;
        this.f.push(new c(r2));
        this.h = new Stack();
        this.g = new Stack();
        Boolean r3 = r8.d;
        if (r3 == null) goto L9;
        c r4 = this.e;
        r3.booleanValue();
        r4.getClass();
    L9:
        H();
        z(r8, new SVG.b(r7.a), r0, r1);
        G();
    }

    public final void J(c r10, SVG.Style r11) {
        if (r(r11, 4096) == false) goto L6;
        SVG.Style r0 = r10.a;
        r0.n = r11.n;
    L6:
        if (r(r11, 2048) == false) goto L8;
        SVG.Style r1 = r10.a;
        r1.m = r11.m;
    L8:
        int r2 = 0;
        if (r(r11, 1) == false) goto L18;
        SVG.Style r3 = r10.a;
        r3.b = r11.b;
        SVG.h0 r4 = r11.b;
        if (r4 != null) goto L13;
    L15:
        boolean r5 = false;
    L16:
        r10.b = r5;
        goto L18
    L13:
        if (r4 == SVG.f.c) goto L15;
        r5 = true;
    L18:
        if (r(r11, 4) == false) goto L21;
        SVG.Style r6 = r10.a;
        r6.d = r11.d;
    L21:
        if (r(r11, 6149) == false) goto L24;
        F(r10, true, r10.a.b);
    L24:
        if (r(r11, 2) == false) goto L27;
        SVG.Style r7 = r10.a;
        r7.c = r11.c;
    L27:
        if (r(r11, 8) == false) goto L36;
        SVG.Style r8 = r10.a;
        r8.e = r11.e;
        SVG.h0 r9 = r11.e;
        if (r9 != null) goto L31;
    L33:
        boolean r12 = false;
    L34:
        r10.c = r12;
        goto L36
    L31:
        if (r9 == SVG.f.c) goto L33;
        r12 = true;
    L36:
        if (r(r11, 16) == false) goto L39;
        SVG.Style r13 = r10.a;
        r13.f = r11.f;
    L39:
        if (r(r11, 6168) == false) goto L42;
        F(r10, false, r10.a.e);
    L42:
        if (r(r11, 34359738368L) == false) goto L45;
        SVG.Style r14 = r10.a;
        r14.A = r11.A;
    L45:
        if (r(r11, 32) == false) goto L54;
        SVG.Style r15 = r10.a;
        SVG.o r16 = r11.g;
        r15.g = r16;
        r10.e.setStrokeWidth(r16.b(this));
        if (r10.c == true) goto L49;
    L51:
        boolean r17 = false;
    L52:
        r10.c = r17;
        goto L54
    L49:
        if (r11.g.g() == true) goto L51;
        r17 = true;
    L54:
        if (r(r11, 64) == false) goto L64;
        SVG.Style r18 = r10.a;
        r18.h = r11.h;
        int r19 = a.b[r11.h.ordinal()];
        if (r19 == 1) goto L62;
        if (r19 == 2) goto L61;
        if (r19 != 3) goto L64;
        r10.e.setStrokeCap(Paint.Cap.SQUARE);
        goto L64
    L61:
        r10.e.setStrokeCap(Paint.Cap.ROUND);
        goto L64
    L62:
        r10.e.setStrokeCap(Paint.Cap.BUTT);
    L64:
        if (r(r11, 128) == false) goto L74;
        SVG.Style r20 = r10.a;
        r20.i = r11.i;
        int r21 = a.c[r11.i.ordinal()];
        if (r21 == 1) goto L72;
        if (r21 == 2) goto L71;
        if (r21 != 3) goto L74;
        r10.e.setStrokeJoin(Paint.Join.BEVEL);
        goto L74
    L71:
        r10.e.setStrokeJoin(Paint.Join.ROUND);
        goto L74
    L72:
        r10.e.setStrokeJoin(Paint.Join.MITER);
    L74:
        if (r(r11, 256) == false) goto L77;
        SVG.Style r22 = r10.a;
        r22.j = r11.j;
        r10.e.setStrokeMiter(r11.j.floatValue());
    L77:
        if (r(r11, 512) == false) goto L80;
        SVG.Style r23 = r10.a;
        r23.k = r11.k;
    L80:
        if (r(r11, 1024) == false) goto L83;
        SVG.Style r24 = r10.a;
        r24.l = r11.l;
    L83:
        if (r(r11, 1536) == false) goto L102;
        SVG.o[] r25 = r10.a.k;
        if (r25 != null) goto L87;
        r10.e.setPathEffect(null);
        goto L102
    L87:
        int r26 = r25.length;
        if ((r26 % 2) != 0) goto L90;
        int r27 = r26;
    L91:
        float[] r28 = new float[r27];
        float r29 = 0.0f;
    L92:
        if (r2 >= r27) goto L95;
        float r30 = r10.a.k[r2 % r26].b(this);
        r28[r2] = r30;
        r29 = r29 + r30;
        r2 = r2 + 1;
        goto L92
    L95:
        if (r29 != 0.0f) goto L97;
        r10.e.setPathEffect(null);
        goto L102
    L97:
        float r31 = r10.a.l.b(this);
        if (r31 >= 0.0f) goto L100;
        r31 = (r31 % r29) + r29;
    L100:
        r10.e.setPathEffect(new DashPathEffect(r28, r31));
        goto L102
    L90:
        r27 = r26 * 2;
    L102:
        if (r(r11, 524288) == false) goto L105;
        SVG.Style r32 = r10.a;
        r32.o = r11.o;
    L105:
        if (r(r11, 16777216) == false) goto L108;
        SVG.Style r33 = r10.a;
        r33.q = r11.q;
    L108:
        if (r(r11, 33554432) == false) goto L111;
        SVG.Style r34 = r10.a;
        r34.r = r11.r;
    L111:
        if (r(r11, 1048576) == false) goto L114;
        SVG.Style r35 = r10.a;
        r35.p = r11.p;
    L114:
        if (r(r11, 268435456) == false) goto L117;
        SVG.Style r36 = r10.a;
        r36.u = r11.u;
    L117:
        if (r(r11, 536870912) == false) goto L120;
        SVG.Style r37 = r10.a;
        r37.v = r11.v;
    L120:
        if (r(r11, 67108864) == false) goto L123;
        SVG.Style r38 = r10.a;
        r38.s = r11.s;
    L123:
        if (r(r11, 134217728) == false) goto L126;
        SVG.Style r39 = r10.a;
        r39.t = r11.t;
    L126:
        if (r(r11, 8589934592L) == false) goto L129;
        SVG.Style r40 = r10.a;
        r40.y = r11.y;
    L129:
        if (r(r11, 17179869184L) == false) goto L132;
        SVG.Style r41 = r10.a;
        r41.z = r11.z;
    L132:
        if (r(r11, 137438953472L) == false) goto L136;
        SVG.Style r110 = r10.a;
        r110.B = r11.B;
        return;
    }

    public final void K(c r5, SVG.e0 r6) {
        if (r6.b != null) goto L5;
        boolean r0 = true;
    L6:
        SVG.Style r1 = r5.a;
        Boolean r2 = Boolean.TRUE;
        r1.q = r2;
        if (r0 == true) goto L10;
        r2 = Boolean.FALSE;
    L10:
        r1.o = r2;
        r1.p = null;
        r1.u = null;
        r1.m = Float.valueOf(1.0f);
        r1.s = SVG.f.b;
        r1.t = Float.valueOf(1.0f);
        r1.w = null;
        r1.x = Float.valueOf(1.0f);
        r1.y = null;
        r1.z = Float.valueOf(1.0f);
        r1.A = SVG.Style.VectorEffect.None;
        SVG.Style r3 = r6.e;
        if (r3 == null) goto L13;
        J(r5, r3);
    L13:
        SVG.Style r7 = r6.f;
        if (r7 == null) goto L17;
        J(r5, r7);
        return;
    L17:
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final Path a(SVG.d0 r6, SVG.b r7) {
        SVG.e0 r8 = r6.a.f(this.e.a.u);
        boolean r0 = false;
        if (r8 != null) goto L6;
        l("ClipPath reference '%s' not found", new Object[]{this.e.a.u});
        return null;
    L6:
        SVG.e r9 = (SVG.e) r8;
        this.f.push(this.e);
        c r2 = new c();
        J(r2, SVG.Style.a());
        p(r9, r2);
        this.e = r2;
        Boolean r3 = r9.j;
        if (r3 != null) goto L9;
    L10:
        r0 = true;
    L11:
        Matrix r4 = new Matrix();
        if (r0 == true) goto L14;
        r4.preTranslate(r7.a, r7.b);
        r4.preScale(r7.c, r7.d);
    L14:
        Matrix r10 = r9.i;
        if (r10 == null) goto L17;
        r4.preConcat(r10);
    L17:
        Path r11 = new Path();
        Iterator<SVG.g0> r1 = r9.h.iterator();
    L19:
        if (r1.hasNext() == false) goto L27;
        SVG.g0 r5 = r1.next();
        if ((r5 instanceof SVG.d0) == false) goto L19;
        Path r12 = x((SVG.d0) r5, true);
        if (r12 == null) goto L19;
        r11.op(r12, Path.Op.UNION);
        goto L19
    L27:
        if (this.e.a.u != null) goto L29;
    L34:
        r11.transform(r4);
        this.e = this.f.pop();
        return r11;
    L29:
        if (r9.g != null) goto L31;
        r9.g = b(r11);
    L31:
        Path r13 = a(r9, r9.g);
        if (r13 == null) goto L34;
        r11.op(r13, Path.Op.INTERSECT);
        goto L34
    L9:
        if (r3.booleanValue() == false) goto L11;
        goto L10
    }

    public final void d(SVG.d0 r2, SVG.b r3) {
        if (this.e.a.u != null) goto L5;
        return;
    L5:
        Path r4 = a(r2, r3);
        if (r4 == null) goto L9;
        this.a.clipPath(r4);
        return;
    }

    public final void j(SVG.d0 r19, Path r20) {
        SVG.h0 r3 = this.e.a.b;
        if ((r3 instanceof SVG.r) == false) goto L112;
        SVG.e0 r4 = this.d.f(((SVG.r) r3).a);
        if ((r4 instanceof SVG.u) == false) goto L112;
        SVG.u r5 = (SVG.u) r4;
        Boolean r6 = r5.k;
        if (r6 != null) goto L9;
    L11:
        boolean r7 = false;
    L12:
        String r8 = r5.r;
        if (r8 == null) goto L16;
        o(r5, r8);
    L16:
        if (r7 == false) goto L33;
        SVG.o r9 = r5.n;
        if (r9 == null) goto L20;
        float r10 = r9.d(this);
    L21:
        SVG.o r11 = r5.o;
        if (r11 == null) goto L24;
        float r12 = r11.e(this);
    L25:
        SVG.o r13 = r5.p;
        if (r13 == null) goto L28;
        float r14 = r13.d(this);
    L29:
        SVG.o r15 = r5.q;
        if (r15 == null) goto L32;
        float r16 = r15.e(this);
    L51:
        if (r14 != 0.0f) goto L53;
        return;
    L53:
        if (r16 == 0.0f) goto L121;
        PreserveAspectRatio r17 = r5.i;
        if (r17 != null) goto L59;
        r17 = PreserveAspectRatio.d;
    L59:
        H();
        this.a.clipPath(r20);
        c r2 = new c();
        J(r2, SVG.Style.a());
        r2.a.o = Boolean.FALSE;
        p(r5, r2);
        this.e = r2;
        SVG.b r18 = r19.g;
        Matrix r110 = r5.m;
        if (r110 == null) goto L79;
        this.a.concat(r110);
        Matrix r111 = new Matrix();
        if (r5.m.invert(r111) == false) goto L79;
        SVG.b r112 = r19.g;
        float r113 = r112.a;
        float r114 = r112.b;
        float r21 = r112.c + r113;
        float r115 = r114 + r112.d;
        float[] r22 = {r113, r114, r21, r114, r21, r115, r113, r115};
        r111.mapPoints(r22);
        float r116 = r22[0];
        float r117 = r22[1];
        RectF r118 = new RectF(r116, r117, r116, r117);
        int r119 = 2;
    L64:
        if (r119 > 6) goto L78;
        float r120 = r22[r119];
        if (r120 >= r118.left) goto L69;
        r118.left = r120;
    L69:
        if (r120 <= r118.right) goto L71;
        r118.right = r120;
    L71:
        float r121 = r22[r119 + 1];
        if (r121 >= r118.top) goto L75;
        r118.top = r121;
    L75:
        if (r121 <= r118.bottom) goto L77;
        r118.bottom = r121;
    L77:
        r119 = r119 + 2;
        goto L64
    L78:
        float r23 = r118.left;
        float r122 = r118.top;
        r18 = new SVG.b(r23, r122, r118.right - r23, r118.bottom - r122);
    L79:
        float r24 = r10 + (((float) Math.floor((r18.a - r10) / r14)) * r14);
        float r25 = r12 + (((float) Math.floor((r18.b - r12) / r16)) * r16);
        float r26 = r18.a + r18.c;
        float r123 = r18.b + r18.d;
        SVG.b r27 = new SVG.b(0.0f, 0.0f, r14, r16);
        boolean r124 = y();
    L81:
        if (r25 >= r123) goto L108;
        float r125 = r24;
    L84:
        if (r125 >= r26) goto L107;
        r27.a = r125;
        r27.b = r25;
        H();
        if (this.e.a.o.booleanValue() == true) goto L89;
        E(r27.a, r27.b, r27.c, r27.d);
    L89:
        SVG.b r28 = r5.j;
        if (r28 == null) goto L92;
        this.a.concat(c(r27, r28, r17));
    L102:
        Iterator<SVG.g0> r29 = r5.h.iterator();
    L104:
        if (r29.hasNext() == false) goto L106;
        A(r29.next());
        goto L104
    L106:
        G();
        r125 = r125 + r14;
        r24 = r24;
        goto L84
    L92:
        Boolean r30 = r5.l;
        if (r30 != null) goto L95;
    L98:
        boolean r31 = true;
    L99:
        this.a.translate(r125, r25);
        if (r31 == true) goto L102;
        Canvas r32 = this.a;
        SVG.b r33 = r19.g;
        r32.scale(r33.c, r33.d);
        goto L102
    L95:
        if (r30.booleanValue() == true) goto L98;
        r31 = false;
        goto L99
    L107:
        r25 = r25 + r16;
        goto L81
    L108:
        if (r124 == false) goto L110;
        G();
    L110:
        G();
        return;
    L121:
        return;
    L32:
        r16 = 0.0f;
        goto L51
    L28:
        r14 = 0.0f;
        goto L29
    L24:
        r12 = 0.0f;
        goto L25
    L20:
        r10 = 0.0f;
        goto L21
    L33:
        SVG.o r34 = r5.n;
        if (r34 == null) goto L36;
        float r35 = r34.c(this);
    L37:
        SVG.o r36 = r5.o;
        if (r36 == null) goto L40;
        float r37 = r36.c(this);
    L41:
        SVG.o r38 = r5.p;
        if (r38 == null) goto L44;
        float r39 = r38.c(this);
    L45:
        SVG.o r126 = r5.q;
        if (r126 == null) goto L48;
        float r127 = r126.c(this);
    L49:
        SVG.b r128 = r19.g;
        float r129 = r128.a;
        float r130 = r128.c;
        r10 = (r35 * r130) + r129;
        float r131 = r128.b;
        float r132 = r128.d;
        r12 = (r37 * r132) + r131;
        r14 = r39 * r130;
        r16 = r127 * r132;
        goto L51
    L48:
        r127 = 0.0f;
        goto L49
    L44:
        r39 = 0.0f;
        goto L45
    L40:
        r37 = 0.0f;
        goto L41
    L36:
        r35 = 0.0f;
        goto L37
    L9:
        if (r6.booleanValue() == false) goto L11;
        r7 = true;
    L112:
        this.a.drawPath(r20, this.e.d);
    }

    public final void p(SVG.e0 r4, c r5) {
        ArrayList r0 = new ArrayList();
        SVG.g0 r6 = r4;
    L4:
        if ((r6 instanceof SVG.e0) == false) goto L6;
        ListProtector.add(r0, 0, (SVG.e0) r6);
    L6:
        Object r7 = r6.b;
        if (r7 == null) goto L8;
        r6 = (SVG.g0) r7;
        goto L4
    L8:
        Iterator r8 = r0.iterator();
    L10:
        if (r8.hasNext() == false) goto L12;
        K(r5, (SVG.e0) r8.next());
        goto L10
    L12:
        c r9 = this.e;
        r5.g = r9.g;
        r5.f = r9.f;
    }

    public final Path x(SVG.d0 r6, boolean r7) {
        this.f.push(this.e);
        c r0 = new c(this.e);
        this.e = r0;
        K(r0, r6);
        if (i() == true) goto L5;
    L66:
        this.e = this.f.pop();
        return null;
    L5:
        if (M() == false) goto L66;
        if ((r6 instanceof SVG.l0) == false) goto L29;
        if (r7 == true) goto L11;
        l("<use> elements inside a <clipPath> cannot reference another <use>", new Object[0]);
    L11:
        SVG.l0 r8 = (SVG.l0) r6;
        SVG.e0 r1 = r6.a.f(r8.j);
        if (r1 != null) goto L16;
        l("Use reference '%s' not found", new Object[]{r8.j});
        this.e = this.f.pop();
        return null;
    L16:
        if ((r1 instanceof SVG.d0) == true) goto L19;
        this.e = this.f.pop();
        return null;
    L19:
        Path r2 = x((SVG.d0) r1, false);
        if (r2 != null) goto L23;
        return null;
    L23:
        if (r8.g != null) goto L25;
        r8.g = b(r2);
    L25:
        Matrix r9 = r8.i;
        if (r9 == null) goto L58;
        r2.transform(r9);
    L58:
        if (this.e.a.u == null) goto L62;
        Path r10 = a(r6, r6.g);
        if (r10 == null) goto L62;
        r2.op(r10, Path.Op.INTERSECT);
    L62:
        this.e = this.f.pop();
        return r2;
    L29:
        if ((r6 instanceof SVG.k) == false) goto L64;
        SVG.k r11 = (SVG.k) r6;
        if ((r6 instanceof SVG.s) == false) goto L36;
        r2 = new b(((SVG.s) r6).i).a;
        if (r6.g != null) goto L48;
        r6.g = b(r2);
    L48:
        if (r2 != null) goto L51;
        return null;
    L51:
        if (r11.g != null) goto L53;
        r11.g = b(r2);
    L53:
        Matrix r12 = r11.h;
        if (r12 == null) goto L56;
        r2.transform(r12);
    L56:
        r2.setFillType(q());
        goto L58
    L36:
        if ((r6 instanceof SVG.x) == false) goto L39;
        r2 = v((SVG.x) r6);
        goto L48
    L39:
        if ((r6 instanceof SVG.d) == false) goto L42;
        r2 = s((SVG.d) r6);
        goto L48
    L42:
        if ((r6 instanceof SVG.i) == false) goto L45;
        r2 = t((SVG.i) r6);
        goto L48
    L45:
        if ((r6 instanceof SVG.v) == false) goto L47;
        r2 = u((SVG.v) r6);
        goto L48
    L47:
        r2 = null;
        goto L48
    L64:
        l("Invalid %s element found in clipPath definition", new Object[]{r6.c()});
        return null;
    }

    public e(Canvas r1, float r2, com.lynx.component.svg.d r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public static void F(c r2, boolean r3, SVG.h0 r4) {
        SVG.Style r0 = r2.a;
        if (r3 == false) goto L5;
        Float r1 = r0.d;
    L6:
        float r5 = r1.floatValue();
        if ((r4 instanceof SVG.f) == false) goto L10;
        int r6 = ((SVG.f) r4).a;
    L12:
        int r7 = f(r6, r5);
        if (r3 == false) goto L15;
        r2.d.setColor(r7);
        return;
    L15:
        r2.e.setColor(r7);
        return;
    L10:
        if ((r4 instanceof SVG.g) == false) goto L17;
        r6 = r2.a.n.a;
        goto L12
    L17:
        return;
    L5:
        r1 = r0.f;
        goto L6
    }

    public static Matrix c(SVG.b r9, SVG.b r10, PreserveAspectRatio r11) {
        Matrix r0 = new Matrix();
        if (r11 != null) goto L5;
    L38:
        return r0;
    L5:
        if (r11.a == null) goto L38;
        float r1 = r9.c / r10.c;
        float r2 = r9.d / r10.d;
        float r3 = -r10.a;
        float r4 = -r10.b;
        if (r11.equals(PreserveAspectRatio.c) == false) goto L12;
        r0.preTranslate(r9.a, r9.b);
        r0.preScale(r1, r2);
        r0.preTranslate(r3, r4);
        return r0;
    L12:
        if (r11.b != PreserveAspectRatio.Scale.slice) goto L14;
        float r5 = Math.max(r1, r2);
    L15:
        float r6 = r9.c / r5;
        float r7 = r9.d / r5;
        int[] r8 = a.a;
        switch(r8[r11.a.ordinal()]) {
            case 1: goto L19;
            case 2: goto L19;
            case 3: goto L19;
            case 4: goto L18;
            case 5: goto L18;
            case 6: goto L18;
            default: goto L21;
        };
    L18:
        float r12 = r10.c - r6;
    L20:
        r3 = r3 - r12;
        goto L21
    L19:
        r12 = (r10.c - r6) / 2.0f;
    L21:
        int r13 = r8[r11.a.ordinal()];
        if (r13 != 2) goto L24;
    L35:
        float r14 = (r10.d - r7) / 2.0f;
    L36:
        r4 = r4 - r14;
    L37:
        r0.preTranslate(r9.a, r9.b);
        r0.preScale(r5, r5);
        r0.preTranslate(r3, r4);
        goto L38
    L24:
        if (r13 != 3) goto L26;
    L34:
        r14 = r10.d - r7;
        goto L36
    L26:
        if (r13 == 5) goto L35;
        if (r13 == 6) goto L34;
        if (r13 == 7) goto L35;
        if (r13 == 8) goto L34;
    L14:
        r5 = Math.min(r1, r2);
        goto L15
    }

    public final void D(SVG.n r10, PreserveAspectRatio r11, Bitmap r12) {
        int r0 = 0;
        if (r12 != null) goto L6;
        l("Could not locate image '%s'", new Object[]{r10.j});
        return;
    L6:
        SVG.b r1 = new SVG.b(0.0f, 0.0f, r12.getWidth(), r12.getHeight());
        K(this.e, r10);
        if (i() == true) goto L10;
        return;
    L10:
        if (M() == true) goto L12;
        return;
    L12:
        Matrix r2 = r10.o;
        if (r2 == null) goto L15;
        this.a.concat(r2);
    L15:
        SVG.o r3 = r10.k;
        if (r3 == null) goto L18;
        float r4 = r3.d(this);
    L19:
        SVG.o r5 = r10.l;
        if (r5 == null) goto L22;
        float r6 = r5.e(this);
    L23:
        float r7 = r10.m.d(this);
        float r8 = r10.n.d(this);
        c r9 = this.e;
        r9.f = new SVG.b(r4, r6, r7, r8);
        if (r9.a.o.booleanValue() == true) goto L26;
        SVG.b r13 = this.e.f;
        E(r13.a, r13.b, r13.c, r13.d);
    L26:
        r10.g = this.e.f;
        I(r10);
        d(r10, r10.g);
        boolean r14 = y();
        L();
        this.a.save();
        this.a.concat(c(this.e.f, r1, r11));
        if (this.e.a.B == SVG.Style.RenderQuality.optimizeSpeed) goto L30;
        r0 = 2;
    L30:
        this.a.drawBitmap(r12, 0.0f, 0.0f, new Paint(r0));
        this.a.restore();
        if (r14 == false) goto L34;
        G();
        return;
    L34:
        return;
    L22:
        r6 = 0.0f;
        goto L23
    L18:
        r4 = 0.0f;
        goto L19
    }

    public final void h(boolean r25, SVG.b r26, SVG.r r27) {
        SVG.e0 r4 = this.d.f(r27.a);
        boolean r5 = true;
        int r6 = 0;
        if (r4 != null) goto L15;
        Object[] r2 = new Object[2];
        if (r25 == false) goto L7;
        String r7 = "Fill";
    L8:
        r2[0] = r7;
        r2[1] = r27.a;
        l("%s reference '%s' not found", r2);
        SVG.h0 r3 = r27.b;
        if (r3 == null) goto L11;
        F(this.e, r25, r3);
        return;
    L11:
        if (r25 == false) goto L13;
        this.e.b = false;
        return;
    L13:
        this.e.c = false;
        return;
    L7:
        r7 = "Stroke";
        goto L8
    L15:
        float r10 = -1.0f;
        if ((r4 instanceof SVG.f0) == false) goto L117;
        SVG.f0 r8 = (SVG.f0) r4;
        String r9 = r8.k;
        if (r9 == null) goto L20;
        m(r8, r9);
    L20:
        Boolean r11 = r8.h;
        if (r11 != null) goto L23;
    L25:
        boolean r12 = false;
    L26:
        c r13 = this.e;
        if (r25 == false) goto L29;
        Paint r14 = r13.d;
    L30:
        if (r12 == false) goto L50;
        SVG.b r15 = r13.g;
        if (r15 != null) goto L35;
        r15 = r13.f;
    L35:
        SVG.o r16 = r8.l;
        if (r16 == null) goto L38;
        float r17 = r16.d(this);
    L39:
        SVG.o r18 = r8.m;
        if (r18 == null) goto L42;
        float r19 = r18.e(this);
    L43:
        SVG.o r110 = r8.n;
        if (r110 == null) goto L46;
        float r111 = r110.d(this);
    L47:
        SVG.o r112 = r8.o;
        if (r112 == null) goto L65;
        float r113 = r112.e(this);
    L66:
        float r114 = r17;
        float r115 = r111;
        float r116 = r19;
        float r20 = r113;
        H();
        c r117 = new c();
        J(r117, SVG.Style.a());
        p(r8, r117);
        this.e = r117;
        Matrix r118 = new Matrix();
        if (r12 == true) goto L69;
        r118.preTranslate(r26.a, r26.b);
        r118.preScale(r26.c, r26.d);
    L69:
        Matrix r21 = r8.i;
        if (r21 == null) goto L72;
        r118.preConcat(r21);
    L72:
        int r22 = r8.g.size();
        if (r22 != 0) goto L78;
        G();
        if (r25 == false) goto L77;
        this.e.b = false;
        return;
    L77:
        this.e.c = false;
        return;
    L78:
        int[] r1 = new int[r22];
        float[] r23 = new float[r22];
        Iterator<SVG.g0> r119 = r8.g.iterator();
        int r120 = 0;
    L80:
        if (r119.hasNext() == false) goto L96;
        SVG.z r121 = (SVG.z) r119.next();
        Float r24 = r121.g;
        if (r24 == null) goto L84;
        float r28 = r24.floatValue();
    L85:
        if (r120 != 0) goto L87;
    L90:
        r23[r120] = r28;
        r10 = r28;
    L91:
        H();
        K(this.e, r121);
        SVG.Style r29 = this.e.a;
        SVG.f r122 = (SVG.f) r29.s;
        if (r122 != null) goto L94;
        r122 = SVG.f.b;
    L94:
        r1[r120] = f(r122.a, r29.t.floatValue());
        r120 = r120 + 1;
        G();
        goto L80
    L87:
        if (r28 >= r10) goto L90;
        r23[r120] = r10;
        goto L91
    L84:
        r28 = 0.0f;
        goto L85
    L96:
        if (r114 == r115) goto L98;
    L99:
        if (r22 != 1) goto L101;
    L100:
        G();
        r14.setColor(r1[r22 - 1]);
        return;
    L101:
        Shader.TileMode r30 = Shader.TileMode.CLAMP;
        SVG.GradientSpread r31 = r8.j;
        if (r31 != null) goto L104;
    L109:
        G();
        LinearGradient r32 = new LinearGradient(r114, r116, r115, r20, r1, r23, r30);
        r32.setLocalMatrix(r118);
        r14.setShader(r32);
        int r33 = (int) (this.e.a.d.floatValue() * 256.0f);
        if (r33 < 0) goto L115;
        if (r33 <= 255) goto L114;
        r6 = 255;
        goto L115
    L114:
        r6 = r33;
    L115:
        r14.setAlpha(r6);
        return;
    L104:
        if (r31 != SVG.GradientSpread.reflect) goto L107;
        r30 = Shader.TileMode.MIRROR;
        goto L109
    L107:
        if (r31 != SVG.GradientSpread.repeat) goto L109;
        r30 = Shader.TileMode.REPEAT;
        goto L109
    L98:
        if (r116 == r20) goto L100;
    L65:
        r113 = 0.0f;
        goto L66
    L46:
        r111 = r15.c;
        goto L47
    L42:
        r19 = 0.0f;
        goto L43
    L38:
        r17 = 0.0f;
        goto L39
    L50:
        SVG.o r123 = r8.l;
        if (r123 == null) goto L53;
        r17 = r123.c(this);
    L54:
        SVG.o r124 = r8.m;
        if (r124 == null) goto L57;
        r19 = r124.c(this);
    L58:
        SVG.o r125 = r8.n;
        if (r125 == null) goto L61;
        r111 = r125.c(this);
    L62:
        SVG.o r126 = r8.o;
        if (r126 == null) goto L65;
        r113 = r126.c(this);
        goto L66
    L61:
        r111 = 1.0f;
        goto L62
    L57:
        r19 = 0.0f;
        goto L58
    L53:
        r17 = 0.0f;
        goto L54
    L29:
        r14 = r13.e;
        goto L30
    L23:
        if (r11.booleanValue() == false) goto L25;
        r12 = true;
        goto L26
    L117:
        if ((r4 instanceof SVG.j0) == false) goto L207;
        SVG.j0 r34 = (SVG.j0) r4;
        String r35 = r34.k;
        if (r35 == null) goto L121;
        m(r34, r35);
    L121:
        Boolean r36 = r34.h;
        if (r36 != null) goto L124;
    L126:
        boolean r37 = false;
    L127:
        c r38 = this.e;
        if (r25 == false) goto L130;
        Paint r39 = r38.d;
    L131:
        if (r37 == false) goto L145;
        SVG.o r127 = new SVG.o(50.0f, SVG.Unit.percent);
        SVG.o r128 = r34.l;
        if (r128 == null) goto L135;
        float r129 = r128.d(this);
    L136:
        SVG.o r130 = r34.m;
        if (r130 == null) goto L139;
        float r131 = r130.e(this);
    L140:
        SVG.o r132 = r34.n;
        if (r132 == null) goto L143;
        float r133 = r132.b(this);
    L144:
        float r134 = r133;
        float r135 = r129;
    L157:
        float r136 = r131;
        H();
        c r137 = new c();
        J(r137, SVG.Style.a());
        p(r34, r137);
        this.e = r137;
        Matrix r138 = new Matrix();
        if (r37 == true) goto L160;
        r138.preTranslate(r26.a, r26.b);
        r138.preScale(r26.c, r26.d);
    L160:
        Matrix r40 = r34.i;
        if (r40 == null) goto L163;
        r138.preConcat(r40);
    L163:
        int r41 = r34.g.size();
        if (r41 != 0) goto L169;
        G();
        if (r25 == false) goto L168;
        this.e.b = false;
        return;
    L168:
        this.e.c = false;
        return;
    L169:
        int[] r42 = new int[r41];
        float[] r43 = new float[r41];
        Iterator<SVG.g0> r139 = r34.g.iterator();
        int r140 = 0;
    L171:
        if (r139.hasNext() == false) goto L187;
        SVG.z r141 = (SVG.z) r139.next();
        Float r44 = r141.g;
        if (r44 == null) goto L175;
        float r45 = r44.floatValue();
    L176:
        if (r140 != 0) goto L178;
    L181:
        r43[r140] = r45;
        r10 = r45;
    L182:
        H();
        K(this.e, r141);
        SVG.Style r46 = this.e.a;
        SVG.f r142 = (SVG.f) r46.s;
        if (r142 != null) goto L185;
        r142 = SVG.f.b;
    L185:
        r42[r140] = f(r142.a, r46.t.floatValue());
        r140 = r140 + 1;
        G();
        goto L171
    L178:
        if (r45 >= r10) goto L181;
        r43[r140] = r10;
        goto L182
    L175:
        r45 = 0.0f;
        goto L176
    L187:
        if (r134 == 0.0f) goto L205;
        if (r41 == 1) goto L205;
        Shader.TileMode r47 = Shader.TileMode.CLAMP;
        SVG.GradientSpread r48 = r34.j;
        if (r48 != null) goto L193;
    L198:
        G();
        RadialGradient r49 = new RadialGradient(r135, r136, r134, r42, r43, r47);
        r49.setLocalMatrix(r138);
        r39.setShader(r49);
        int r50 = (int) (this.e.a.d.floatValue() * 256.0f);
        if (r50 >= 0) goto L201;
        int r51 = 0;
    L204:
        r39.setAlpha(r51);
        return;
    L201:
        if (r50 <= 255) goto L203;
        r51 = 255;
        goto L204
    L203:
        r51 = r50;
        goto L204
    L193:
        if (r48 != SVG.GradientSpread.reflect) goto L196;
        r47 = Shader.TileMode.MIRROR;
        goto L198
    L196:
        if (r48 != SVG.GradientSpread.repeat) goto L198;
        r47 = Shader.TileMode.REPEAT;
    L205:
        G();
        r39.setColor(r42[r41 - 1]);
        return;
    L143:
        r133 = r127.b(this);
        goto L144
    L139:
        r131 = r127.e(this);
        goto L140
    L135:
        r129 = r127.d(this);
        goto L136
    L145:
        SVG.o r143 = r34.l;
        float r144 = 0.5f;
        if (r143 == null) goto L148;
        float r145 = r143.c(this);
    L149:
        SVG.o r146 = r34.m;
        if (r146 == null) goto L152;
        r131 = r146.c(this);
    L153:
        SVG.o r147 = r34.n;
        if (r147 == null) goto L156;
        r144 = r147.c(this);
    L156:
        r135 = r145;
        r134 = r144;
        goto L157
    L152:
        r131 = 0.5f;
        goto L153
    L148:
        r145 = 0.5f;
        goto L149
    L130:
        r39 = r38.e;
        goto L131
    L124:
        if (r36.booleanValue() == false) goto L126;
        r37 = true;
        goto L127
    L207:
        if ((r4 instanceof SVG.y) == false) goto L253;
        SVG.y r52 = (SVG.y) r4;
        if (r25 == false) goto L224;
        if (r(r52.e, 2147483648L) == false) goto L218;
        c r53 = this.e;
        SVG.Style r54 = r53.a;
        SVG.h0 r148 = r52.e.w;
        r54.b = r148;
        if (r148 != null) goto L216;
        r5 = false;
    L216:
        r53.b = r5;
    L218:
        if (r(r52.e, 4294967296L) == false) goto L221;
        SVG.Style r55 = this.e.a;
        r55.d = r52.e.x;
    L221:
        if (r(r52.e, 6442450944L) == false) goto L254;
        c r56 = this.e;
        F(r56, r25, r56.a.b);
        return;
    L254:
        return;
    L224:
        if (r(r52.e, 2147483648L) == false) goto L231;
        c r57 = this.e;
        SVG.Style r58 = r57.a;
        SVG.h0 r149 = r52.e.w;
        r58.e = r149;
        if (r149 != null) goto L229;
        r5 = false;
    L229:
        r57.c = r5;
    L231:
        if (r(r52.e, 4294967296L) == false) goto L234;
        SVG.Style r59 = this.e.a;
        r59.f = r52.e.x;
    L234:
        if (r(r52.e, 6442450944L) == false) goto L256;
        c r60 = this.e;
        F(r60, r25, r60.a.e);
        return;
    L256:
        return;
    }

    public final void E(float r2, float r3, float r4, float r5) {
        float r6 = r4 + r2;
        float r7 = r5 + r3;
        SVG.c r0 = this.e.a.p;
        if (r0 == null) goto L5;
        r2 = r2 + r0.d.d(this);
        r3 = r3 + this.e.a.p.a.e(this);
        r6 = r6 - this.e.a.p.b.d(this);
        r7 = r7 - this.e.a.p.c.e(this);
    L5:
        this.a.clipRect(r2, r3, r6, r7);
    }

    public final SVG.b w(SVG.o r3, SVG.o r4, SVG.o r5, SVG.o r6) {
        float r0 = 0.0f;
        if (r3 == null) goto L5;
        float r7 = r3.d(this);
    L6:
        if (r4 == null) goto L8;
        r0 = r4.e(this);
    L8:
        c r8 = this.e;
        SVG.b r1 = r8.g;
        if (r1 != null) goto L12;
        r1 = r8.f;
    L12:
        if (r5 == null) goto L14;
        float r9 = r5.d(this);
    L15:
        if (r6 == null) goto L17;
        float r10 = r6.e(this);
    L19:
        return new SVG.b(r7, r0, r9, r10);
    L17:
        r10 = r1.d;
        goto L19
    L14:
        r9 = r1.c;
        goto L15
    L5:
        r7 = 0.0f;
        goto L6
    }

    public final void z(SVG.a0 r4, SVG.b r5, SVG.b r6, PreserveAspectRatio r7) {
        g("Svg render", new Object[0]);
        if (r5.c != 0.0f) goto L5;
        return;
    L5:
        if (r5.d == 0.0f) goto L28;
        if (r7 != null) goto L12;
        r7 = r4.i;
        if (r7 != null) goto L12;
        r7 = new PreserveAspectRatio(PreserveAspectRatio.Alignment.none, PreserveAspectRatio.Scale.meet);
    L12:
        K(this.e, r4);
        if (i() == true) goto L15;
        return;
    L15:
        c r0 = this.e;
        r0.f = r5;
        if (r0.a.o.booleanValue() == true) goto L18;
        SVG.b r8 = this.e.f;
        E(r8.a, r8.b, r8.c, r8.d);
    L18:
        d(r4, this.e.f);
        if (r6 == null) goto L21;
        this.a.concat(c(this.e.f, r6, r7));
        c r9 = this.e;
        r9.g = r4.j;
    L22:
        boolean r10 = y();
        L();
        B(r4);
        if (r10 == false) goto L25;
        G();
    L25:
        I(r4);
        return;
    L21:
        Canvas r11 = this.a;
        SVG.b r12 = this.e.f;
        r11.translate(r12.a, r12.b);
        goto L22
    }
}
