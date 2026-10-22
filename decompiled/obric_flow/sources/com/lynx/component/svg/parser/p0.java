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
import android.util.Base64;
import android.util.Log;
import androidx.core.view.ViewCompat;
import com.lynx.base.log.LynxLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;
import okhttp3.internal.ws.RealWebSocket;

/* JADX INFO: loaded from: classes2.dex */
public final class p0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Canvas f9853a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f9854b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final i4.a f9855c;
    public n0 d;
    public o0 e;
    public Stack f;
    public Stack g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Stack f9856h;

    public p0(Canvas r5, float r10, i4.a r11) {
        this.f9853a = r5;
        this.f9854b = r10;
        this.f9855c = r11;
    }

    public static void E(String r5, Object... r10) {
        LynxLog.b(4, "SVGAndroidRenderer", String.format(r5, r10));
    }

    public static int a(float r5, int r10) {
        int r11 = 255;
        int r12 = Math.round(((r10 >> 24) & 255) * r5);
        if (r12 >= 0) goto L5;
        r11 = 0;
    L9:
        return (r11 << 24) | (r10 & ViewCompat.MEASURED_SIZE_MASK);
    L5:
        if (r12 > 255) goto L9;
        r11 = r12;
        goto L9
    }

    public static Matrix b(e r10, e r11, c r12) {
        Matrix r5 = new Matrix();
        if (r12 == null) goto L38;
        PreserveAspectRatio$Alignment r13 = r12.f9791a;
        if (r13 == null) goto L38;
        float r14 = r10.f9803c / r11.f9803c;
        float r15 = r10.d / r11.d;
        float r16 = -r11.f9801a;
        float r17 = -r11.f9802b;
        if (r12.equals(c.f9790c) == false) goto L12;
        r5.preTranslate(r10.f9801a, r10.f9802b);
        r5.preScale(r14, r15);
        r5.preTranslate(r16, r17);
        return r5;
    L12:
        if (r12.f9792b != PreserveAspectRatio$Scale.f9737b) goto L14;
        float r18 = Math.max(r14, r15);
    L15:
        float r19 = r10.f9803c / r18;
        float r20 = r10.d / r18;
        int r21 = r13.ordinal();
        if (r21 != 2) goto L18;
    L30:
        float r22 = (r11.f9803c - r19) / 2.0f;
    L29:
        r16 = r16 - r22;
    L32:
        switch(r13.ordinal()) {
            case 4: goto L36;
            case 5: goto L36;
            case 6: goto L36;
            case 7: goto L34;
            case 8: goto L34;
            case 9: goto L34;
            default: goto L37;
        };
    L34:
        float r110 = r11.d - r20;
    L35:
        r17 = r17 - r110;
        goto L37
    L36:
        r110 = (r11.d - r20) / 2.0f;
    L37:
        r5.preTranslate(r10.f9801a, r10.f9802b);
        r5.preScale(r18, r18);
        r5.preTranslate(r16, r17);
        goto L38
    L18:
        if (r21 != 3) goto L20;
    L28:
        r22 = r11.f9803c - r19;
        goto L29
    L20:
        if (r21 == 5) goto L30;
        if (r21 == 6) goto L28;
        if (r21 == 8) goto L30;
        if (r21 == 9) goto L28;
    L14:
        r18 = Math.min(r14, r15);
    L38:
        return r5;
    }

    public static Path e(w r5) {
        Path r10 = new Path();
        float[] r11 = r5.f9882i;
        r10.moveTo(r11[0], r11[1]);
        int r12 = 2;
    L3:
        float[] r13 = r5.f9882i;
        if (r12 >= r13.length) goto L7;
        r10.lineTo(r13[r12], r13[r12 + 1]);
        r12 = r12 + 2;
        goto L3
    L7:
        if ((r5 instanceof x) == false) goto L10;
        r10.close();
    L10:
        if (r5.g != null) goto L12;
        r5.g = i(r10);
    L12:
        return r10;
    }

    public static e i(Path r5) {
        RectF r10 = new RectF();
        r5.computeBounds(r10, true);
        return new e(r10.left, r10.top, r10.width(), r10.height());
    }

    public static void k(l r5, String r10) {
        g0 r11 = r5.f9808a.f(r10);
        if (r11 != null) goto L7;
        LynxLog.b(3, "SVGAndroidRenderer", "Gradient reference '" + r10 + "' not found");
        return;
    L7:
        if ((r11 instanceof l) == true) goto L10;
        E("Gradient href attributes must point to other gradient elements", new Object[0]);
        return;
    L10:
        if (r11 != r5) goto L13;
        E("Circular reference in gradient href attribute '%s'", new Object[]{r10});
        return;
    L13:
        l r12 = (l) r11;
        if (r5.f9829h != null) goto L17;
        r5.f9829h = r12.f9829h;
    L17:
        if (r5.f9830i != null) goto L20;
        r5.f9830i = r12.f9830i;
    L20:
        if (r5.f9831j != null) goto L23;
        r5.f9831j = r12.f9831j;
    L23:
        if (r5.g.isEmpty() == false) goto L45;
        r5.g = r12.g;
    L45:
        if ((r5 instanceof h0) == false) goto L39;
        h0 r13 = (h0) r5;     // Catch: ClassCastException -> L44
        h0 r14 = (h0) r11;     // Catch: ClassCastException -> L44
        if (r13.f9814l != null) goto L31;
        r13.f9814l = r14.f9814l;     // Catch: ClassCastException -> L44
    L31:
        if (r13.f9815m != null) goto L34;
        r13.f9815m = r14.f9815m;     // Catch: ClassCastException -> L44
    L34:
        if (r13.f9816n != null) goto L37;
        r13.f9816n = r14.f9816n;     // Catch: ClassCastException -> L44
    L37:
        if (r13.f9817o != null) goto L40;
        r13.f9817o = r14.f9817o;     // Catch: ClassCastException -> L44
        goto L40
    L39:
        s((k0) r5, (k0) r11);     // Catch: ClassCastException -> L44
    L40:
        String r15 = r12.f9832k;
        if (r15 == null) goto L46;
        k(r5, r15);
        return;
    }

    public static void o(v r5, String r10) {
        g0 r11 = r5.f9808a.f(r10);
        if (r11 != null) goto L7;
        LynxLog.b(3, "SVGAndroidRenderer", "Pattern reference '" + r10 + "' not found");
        return;
    L7:
        if ((r11 instanceof v) == true) goto L10;
        E("Pattern href attributes must point to other pattern elements", new Object[0]);
        return;
    L10:
        if (r11 != r5) goto L13;
        E("Circular reference in pattern href attribute '%s'", new Object[]{r10});
        return;
    L13:
        v r12 = (v) r11;
        if (r5.f9874k != null) goto L17;
        r5.f9874k = r12.f9874k;
    L17:
        if (r5.f9875l != null) goto L20;
        r5.f9875l = r12.f9875l;
    L20:
        if (r5.f9876m != null) goto L23;
        r5.f9876m = r12.f9876m;
    L23:
        if (r5.f9877n != null) goto L26;
        r5.f9877n = r12.f9877n;
    L26:
        if (r5.f9878o != null) goto L29;
        r5.f9878o = r12.f9878o;
    L29:
        if (r5.f9879p != null) goto L32;
        r5.f9879p = r12.f9879p;
    L32:
        if (r5.f9880q != null) goto L35;
        r5.f9880q = r12.f9880q;
    L35:
        if (r5.f9800h.isEmpty() == false) goto L38;
        r5.f9800h = r12.f9800h;
    L38:
        if (r5.f9833j != null) goto L41;
        r5.f9833j = r12.f9833j;
    L41:
        if (r5.f9819i != null) goto L43;
        r5.f9819i = r12.f9819i;
    L43:
        String r13 = r12.f9881r;
        if (r13 == null) goto L47;
        o(r5, r13);
        return;
    }

    public static void s(k0 r5, k0 r10) {
        if (r5.f9824l != null) goto L6;
        r5.f9824l = r10.f9824l;
    L6:
        if (r5.f9825m != null) goto L9;
        r5.f9825m = r10.f9825m;
    L9:
        if (r5.f9826n != null) goto L12;
        r5.f9826n = r10.f9826n;
    L12:
        if (r5.f9827o != null) goto L15;
        r5.f9827o = r10.f9827o;
    L15:
        if (r5.f9828p != null) goto L18;
        r5.f9828p = r10.f9828p;
        return;
    }

    public static void v(o0 r5, boolean r10, i0 r11) {
        if (r10 == false) goto L4;
        Float r12 = r5.f9844a.d;
    L5:
        float r13 = r12.floatValue();
        if ((r11 instanceof h) == false) goto L9;
        int r14 = ((h) r11).f9813a;
    L11:
        int r15 = a(r13, r14);
        if (r10 == false) goto L15;
        r5.d.setColor(r15);
        return;
    L15:
        r5.e.setColor(r15);
        return;
    L9:
        if ((r11 instanceof i) == false) goto L17;
        r14 = r5.f9844a.f9778n.f9813a;
        goto L11
    L17:
        return;
    L4:
        r12 = r5.f9844a.f;
        goto L5
    }

    public static void w(String r5, Object... r10) {
        LynxLog.b(1, "SVGAndroidRenderer", String.format(r5, r10));
    }

    public static boolean z(b0 r5, long r10) {
        if ((r5.f9769a & r10) == 0) goto L6;
        return true;
    L6:
        return false;
    }

    public final void A(g0 r10) {
        if ((r10 instanceof s) == false) goto L5;
        return;
    L5:
        H();
        if (r10 != null) goto L9;
    L11:
        float r5 = 0.0f;
        if ((r10 instanceof c0) == false) goto L30;
        c0 r11 = (c0) r10;
        q r12 = r11.f9793k;
        q r13 = r11.f9794l;
        q r14 = r11.f9795m;
        q r15 = r11.f9796n;
        if (r12 == null) goto L16;
        float r16 = r12.g(this);
    L17:
        if (r13 == null) goto L19;
        r5 = r13.h(this);
    L19:
        o0 r17 = this.e;
        e r18 = r17.g;
        if (r18 != null) goto L23;
        r18 = r17.f;
    L23:
        if (r14 == null) goto L25;
        float r19 = r14.g(this);
    L26:
        if (r15 == null) goto L28;
        float r20 = r15.h(this);
    L29:
        p(r11, new e(r16, r5, r19, r20), r11.f9833j, r11.f9819i);
    L338:
        G();
        return;
    L28:
        r20 = r18.d;
        goto L29
    L25:
        r19 = r18.f9803c;
        goto L26
    L16:
        r16 = 0.0f;
        goto L17
    L30:
        boolean r21 = r10 instanceof m0;
        Canvas r22 = this.f9853a;
        if (r21 == false) goto L77;
        m0 r110 = (m0) r10;
        w("Use render", new Object[0]);
        q r23 = r110.f9838m;
        if (r23 != null) goto L35;
    L36:
        q r24 = r110.f9839n;
        if (r24 != null) goto L39;
    L41:
        u(this.e, r110);
        if (y() == false) goto L338;
        g0 r25 = r110.f9808a.f(r110.f9835j);
        if (r25 != null) goto L47;
        E("Use reference '%s' not found", new Object[]{r110.f9835j});
        goto L338
    L47:
        Matrix r26 = r110.f9840i;
        if (r26 == null) goto L50;
        r22.concat(r26);
    L50:
        q r27 = r110.f9836k;
        if (r27 == null) goto L53;
        float r28 = r27.g(this);
    L54:
        q r29 = r110.f9837l;
        if (r29 == null) goto L57;
        float r30 = r29.h(this);
    L58:
        r22.translate(r28, r30);
        D(r110, r110.g);
        boolean r31 = F();
        this.g.push(r110);
        this.f9856h.push(r22.getMatrix());
        if ((r25 instanceof c0) == false) goto L71;
        c0 r32 = (c0) r25;
        q r33 = r110.f9838m;
        q r34 = r110.f9839n;
        o0 r35 = this.e;
        e r36 = r35.g;
        if (r36 != null) goto L64;
        r36 = r35.f;
    L64:
        if (r33 == null) goto L66;
        float r37 = r33.g(this);
    L67:
        if (r34 == null) goto L69;
        float r38 = r34.h(this);
    L70:
        e r39 = new e(0.0f, 0.0f, r37, r38);
        H();
        p(r32, r39, r32.f9833j, r32.f9819i);
        G();
    L72:
        this.g.pop();
        this.f9856h.pop();
        if (r31 == false) goto L75;
        G();
    L75:
        C(r110);
        goto L338
    L69:
        r38 = r36.d;
        goto L70
    L66:
        r37 = r36.f9803c;
        goto L67
    L71:
        A(r25);
        goto L72
    L57:
        r30 = 0.0f;
        goto L58
    L53:
        r28 = 0.0f;
        goto L54
    L39:
        if (r24.f() == false) goto L41;
    L35:
        if (r23.f() == true) goto L338;
    L77:
        if ((r10 instanceof n) == false) goto L89;
        n r111 = (n) r10;
        w(r111.b().concat(" render"), new Object[0]);
        u(this.e, r111);
        if (y() == false) goto L338;
        Matrix r40 = r111.f9840i;
        if (r40 == null) goto L84;
        r22.concat(r40);
    L84:
        D(r111, r111.g);
        boolean r41 = F();
        q(r111);
        if (r41 == false) goto L87;
        G();
    L87:
        C(r111);
        goto L338
    L89:
        if ((r10 instanceof p) == false) goto L127;
        p r112 = (p) r10;
        w("Image render", new Object[0]);
        q r42 = r112.f9850m;
        if (r42 == null) goto L338;
        if (r42.f() == true) goto L338;
        q r43 = r112.f9851n;
        if (r43 == null) goto L338;
        if (r43.f() == true) goto L338;
        String r44 = r112.f9847j;
        if (r44 == null) goto L338;
        c r45 = r112.f9819i;
        if (r45 != null) goto L106;
        r45 = c.d;
    L106:
        Bitmap r46 = null;
        if (r44.startsWith("data:") == true) goto L110;
    L123:
        if (r46 != null) goto L125;
        this.f9855c.r(r112.f9847j, new n0(this, r112, r45));
        goto L338
    L125:
        n(r112, r45, r46);
        goto L338
    L110:
        if (r44.length() < 14) goto L123;
        int r47 = r44.indexOf(44);
        if (r47 < 12) goto L123;
        if (";base64".equals(r44.substring(r47 - 7, r47)) == false) goto L123;
        byte[] r48 = Base64.decode(r44.substring(r47 + 1), 0);     // Catch: Exception -> L121
        r46 = BitmapFactory.decodeByteArray(r48, 0, r48.length);     // Catch: Exception -> L121
    L121:
        e = move-exception;
        Log.e("SVGAndroidRenderer", "Could not decode bad Data URL", e);
        goto L123
    L127:
        if ((r10 instanceof u) == false) goto L163;
        u r113 = (u) r10;
        w("Path render", new Object[0]);
        if (r113.f9873i == null) goto L338;
        u(this.e, r113);
        if (y() == false) goto L338;
        if (I() == false) goto L338;
        o0 r49 = this.e;
        if (r49.f9846c == false) goto L140;
    L142:
        Matrix r50 = r113.f9834h;
        if (r50 == null) goto L145;
        r22.concat(r50);
    L145:
        Path r51 = (Path) new d(r113.f9873i).f9799c;
        if (r113.g != null) goto L148;
        r113.g = i(r51);
    L148:
        C(r113);
        l(r113);
        D(r113, r113.g);
        boolean r52 = F();
        o0 r53 = this.e;
        if (r53.f9845b == false) goto L158;
        SVG$Style$FillRule r54 = r53.f9844a.f9771c;
        if (r54 != null) goto L153;
    L155:
        Path.FillType r55 = Path.FillType.WINDING;
    L156:
        r51.setFillType(r55);
        m(r113, r51);
        goto L158
    L153:
        if (r54 != SVG$Style$FillRule.f9743b) goto L155;
        r55 = Path.FillType.EVEN_ODD;
    L158:
        if (this.e.f9846c == false) goto L160;
        B(r51);
    L160:
        if (r52 == false) goto L338;
        G();
        goto L338
    L140:
        if (r49.f9845b == true) goto L142;
    L163:
        if ((r10 instanceof y) == false) goto L191;
        y r114 = (y) r10;
        w("Rect render", new Object[0]);
        q r56 = r114.f9885k;
        if (r56 == null) goto L338;
        if (r114.f9886l == null) goto L338;
        if (r56.f() == true) goto L338;
        if (r114.f9886l.f() == true) goto L338;
        u(this.e, r114);
        if (y() == false) goto L338;
        if (I() == false) goto L338;
        Matrix r57 = r114.f9834h;
        if (r57 == null) goto L182;
        r22.concat(r57);
    L182:
        Path r58 = f(r114);
        C(r114);
        l(r114);
        D(r114, r114.g);
        boolean r59 = F();
        if (this.e.f9845b == false) goto L186;
        m(r114, r58);
    L186:
        if (this.e.f9846c == false) goto L188;
        B(r58);
    L188:
        if (r59 == false) goto L338;
        G();
        goto L338
    L191:
        if ((r10 instanceof f) == false) goto L215;
        f r115 = (f) r10;
        w("Circle render", new Object[0]);
        q r60 = r115.f9806k;
        if (r60 == null) goto L338;
        if (r60.f() == true) goto L338;
        u(this.e, r115);
        if (y() == false) goto L338;
        if (I() == false) goto L338;
        Matrix r61 = r115.f9834h;
        if (r61 == null) goto L206;
        r22.concat(r61);
    L206:
        Path r62 = c(r115);
        C(r115);
        l(r115);
        D(r115, r115.g);
        boolean r63 = F();
        if (this.e.f9845b == false) goto L210;
        m(r115, r62);
    L210:
        if (this.e.f9846c == false) goto L212;
        B(r62);
    L212:
        if (r63 == false) goto L338;
        G();
        goto L338
    L215:
        if ((r10 instanceof k) == false) goto L243;
        k r116 = (k) r10;
        w("Ellipse render", new Object[0]);
        q r64 = r116.f9822k;
        if (r64 == null) goto L338;
        if (r116.f9823l == null) goto L338;
        if (r64.f() == true) goto L338;
        if (r116.f9823l.f() == true) goto L338;
        u(this.e, r116);
        if (y() == false) goto L338;
        if (I() == false) goto L338;
        Matrix r65 = r116.f9834h;
        if (r65 == null) goto L234;
        r22.concat(r65);
    L234:
        Path r66 = d(r116);
        C(r116);
        l(r116);
        D(r116, r116.g);
        boolean r67 = F();
        if (this.e.f9845b == false) goto L238;
        m(r116, r66);
    L238:
        if (this.e.f9846c == false) goto L240;
        B(r66);
    L240:
        if (r67 == false) goto L338;
        G();
        goto L338
    L243:
        if ((r10 instanceof r) == false) goto L279;
        r r117 = (r) r10;
        w("Line render", new Object[0]);
        u(this.e, r117);
        if (y() == false) goto L338;
        if (I() == false) goto L338;
        if (this.e.f9846c == false) goto L338;
        Matrix r68 = r117.f9834h;
        if (r68 == null) goto L256;
        r22.concat(r68);
    L256:
        q r69 = r117.f9860i;
        if (r69 != null) goto L259;
        float r70 = 0.0f;
    L260:
        q r71 = r117.f9861j;
        if (r71 != null) goto L263;
        float r72 = 0.0f;
    L264:
        q r73 = r117.f9862k;
        if (r73 != null) goto L267;
        float r74 = 0.0f;
    L268:
        q r75 = r117.f9863l;
        if (r75 == null) goto L273;
        r5 = r75.h(this);
    L273:
        if (r117.g != null) goto L275;
        r117.g = new e(Math.min(r70, r74), Math.min(r72, r5), Math.abs(r74 - r70), Math.abs(r5 - r72));
    L275:
        Path r76 = new Path();
        r76.moveTo(r70, r72);
        r76.lineTo(r74, r5);
        C(r117);
        l(r117);
        D(r117, r117.g);
        boolean r118 = F();
        B(r76);
        if (r118 == false) goto L338;
        G();
        goto L338
    L267:
        r74 = r73.g(this);
        goto L268
    L263:
        r72 = r71.h(this);
        goto L264
    L259:
        r70 = r69.g(this);
        goto L260
    L279:
        if ((r10 instanceof x) == false) goto L306;
        x r119 = (x) r10;
        w("Polygon render", new Object[0]);
        u(this.e, r119);
        if (y() == false) goto L338;
        if (I() == false) goto L338;
        o0 r77 = this.e;
        if (r77.f9846c == false) goto L289;
    L291:
        Matrix r78 = r119.f9834h;
        if (r78 == null) goto L295;
        r22.concat(r78);
    L295:
        if (r119.f9882i.length < 2) goto L338;
        Path r79 = e(r119);
        C(r119);
        l(r119);
        D(r119, r119.g);
        boolean r80 = F();
        if (this.e.f9845b == false) goto L301;
        m(r119, r79);
    L301:
        if (this.e.f9846c == false) goto L303;
        B(r79);
    L303:
        if (r80 == false) goto L338;
        G();
        goto L338
    L289:
        if (r77.f9845b == true) goto L291;
    L306:
        if ((r10 instanceof w) == false) goto L338;
        w r120 = (w) r10;
        w("PolyLine render", new Object[0]);
        u(this.e, r120);
        if (y() == false) goto L338;
        if (I() == false) goto L338;
        o0 r81 = this.e;
        if (r81.f9846c == false) goto L316;
    L318:
        Matrix r82 = r120.f9834h;
        if (r82 == null) goto L322;
        r22.concat(r82);
    L322:
        if (r120.f9882i.length < 2) goto L338;
        Path r83 = e(r120);
        C(r120);
        SVG$Style$FillRule r84 = this.e.f9844a.f9771c;
        if (r84 != null) goto L327;
    L329:
        Path.FillType r85 = Path.FillType.WINDING;
    L330:
        r83.setFillType(r85);
        l(r120);
        D(r120, r120.g);
        boolean r86 = F();
        if (this.e.f9845b == false) goto L334;
        m(r120, r83);
    L334:
        if (this.e.f9846c == false) goto L336;
        B(r83);
    L336:
        if (r86 == false) goto L338;
        G();
        goto L338
    L327:
        if (r84 != SVG$Style$FillRule.f9743b) goto L329;
        r85 = Path.FillType.EVEN_ODD;
        goto L330
    L316:
        if (r81.f9845b == true) goto L318;
    L9:
        if (r10.d == null) goto L11;
        this.e.getClass();
        goto L11
    }

    public final void B(Path r10) {
        o0 r5 = this.e;
        SVG$Style$VectorEffect r11 = r5.f9844a.A;
        SVG$Style$VectorEffect r12 = SVG$Style$VectorEffect.f9755b;
        Canvas r13 = this.f9853a;
        if (r11 != r12) goto L11;
        Matrix r14 = r13.getMatrix();
        Path r15 = new Path();
        r10.transform(r14, r15);
        r13.setMatrix(new Matrix());
        Shader r16 = this.e.e.getShader();
        Matrix r17 = new Matrix();
        if (r16 == null) goto L7;
        r16.getLocalMatrix(r17);
        Matrix r18 = new Matrix(r17);
        r18.postConcat(r14);
        r16.setLocalMatrix(r18);
    L7:
        r13.drawPath(r15, this.e.e);
        r13.setMatrix(r14);
        if (r16 == null) goto L13;
        r16.setLocalMatrix(r17);
        return;
    L13:
        return;
    L11:
        r13.drawPath(r10, r5.e);
    }

    public final void C(f0 r11) {
        if (r11.f9809b != null) goto L6;
        return;
    L6:
        if (r11.g == null) goto L48;
        Matrix r5 = new Matrix();
        if (((Matrix) this.f9856h.peek()).invert(r5) == false) goto L45;
        e r12 = r11.g;
        float r10 = r12.f9801a;
        float r13 = r12.f9802b;
        float r14 = r12.f9803c + r10;
        float r15 = r12.d + r13;
        float[] r16 = {r10, r13, r14, r13, r14, r15, r10, r15};
        r5.preConcat(this.f9853a.getMatrix());
        r5.mapPoints(r16);
        float r17 = r16[0];
        float r18 = r16[1];
        RectF r19 = new RectF(r17, r18, r17, r18);
        int r20 = 2;
    L11:
        if (r20 > 6) goto L25;
        float r21 = r16[r20];
        if (r21 >= r19.left) goto L16;
        r19.left = r21;
    L16:
        if (r21 <= r19.right) goto L18;
        r19.right = r21;
    L18:
        float r22 = r16[r20 + 1];
        if (r22 >= r19.top) goto L22;
        r19.top = r22;
    L22:
        if (r22 <= r19.bottom) goto L24;
        r19.bottom = r22;
    L24:
        r20 = r20 + 2;
        goto L11
    L25:
        f0 r110 = (f0) this.g.peek();
        e r23 = r110.g;
        if (r23 != null) goto L29;
        float r24 = r19.left;
        float r25 = r19.top;
        r110.g = new e(r24, r25, r19.right - r24, r19.bottom - r25);
        return;
    L29:
        float r111 = r19.left;
        float r26 = r19.top;
        float r27 = r19.right - r111;
        float r112 = r19.bottom - r26;
        if (r111 >= r23.f9801a) goto L33;
        r23.f9801a = r111;
    L33:
        if (r26 >= r23.f9802b) goto L35;
        r23.f9802b = r26;
    L35:
        float r113 = r111 + r27;
        float r28 = r23.f9801a;
        if (r113 <= (r23.f9803c + r28)) goto L38;
        r23.f9803c = r113 - r28;
    L38:
        float r29 = r26 + r112;
        float r114 = r23.f9802b;
        if (r29 <= (r23.d + r114)) goto L46;
        r23.d = r29 - r114;
        return;
    L46:
        return;
    L45:
        return;
    }

    public final void D(f0 r5, e r10) {
        if (this.e.f9844a.f9784u == null) goto L10;
        Path r11 = g(r5, r10);
        if (r11 == null) goto L9;
        this.f9853a.clipPath(r11);
        return;
    L9:
        return;
    }

    public final boolean F() {
        int r5 = 0;
        if (this.e.f9844a.f9777m.floatValue() >= 1.0f) goto L13;
        int r10 = (int) (this.e.f9844a.f9777m.floatValue() * 256.0f);
        if (r10 < 0) goto L11;
        r5 = 255;
        if (r10 > 255) goto L11;
        r5 = r10;
    L11:
        this.f9853a.saveLayerAlpha(null, r5, 31);
        this.f.push(this.e);
        this.e = new o0(this.e);
        return true;
    L13:
        return false;
    }

    public final void G() {
        this.f9853a.restore();
        this.e = (o0) this.f.pop();
    }

    public final void H() {
        this.f9853a.save();
        this.f.push(this.e);
        this.e = new o0(this.e);
    }

    public final boolean I() {
        Boolean r5 = this.e.f9844a.f9782r;
        if (r5 != null) goto L5;
        return true;
    L5:
        return r5.booleanValue();
    }

    public final Path c(f r19) {
        q r5 = r19.f9804i;
        float r10 = 0.0f;
        if (r5 == null) goto L5;
        float r11 = r5.g(this);
    L6:
        q r12 = r19.f9805j;
        if (r12 == null) goto L9;
        r10 = r12.h(this);
    L9:
        float r13 = r19.f9806k.b(this);
        float r14 = r11 - r13;
        float r15 = r10 - r13;
        float r16 = r11 + r13;
        float r17 = r10 + r13;
        if (r19.g != null) goto L12;
        float r18 = 2.0f * r13;
        r19.g = new e(r14, r15, r18, r18);
    L12:
        float r20 = r13 * 0.5522848f;
        Path r21 = new Path();
        r21.moveTo(r16, r10);
        float r110 = r10 + r20;
        float r111 = r11 + r20;
        r21.cubicTo(r16, r110, r111, r17, r11, r17);
        float r112 = r11 - r20;
        r21.cubicTo(r112, r17, r14, r110, r14, r10);
        float r22 = r10 - r20;
        r21.cubicTo(r14, r22, r112, r15, r11, r15);
        r21.cubicTo(r111, r15, r16, r22, r16, r10);
        r21.close();
        return r21;
    L5:
        r11 = 0.0f;
        goto L6
    }

    public final Path d(k r19) {
        q r5 = r19.f9820i;
        float r10 = 0.0f;
        if (r5 == null) goto L5;
        float r11 = r5.g(this);
    L6:
        q r12 = r19.f9821j;
        if (r12 == null) goto L9;
        r10 = r12.h(this);
    L9:
        float r13 = r19.f9822k.g(this);
        float r14 = r19.f9823l.h(this);
        float r15 = r11 - r13;
        float r16 = r10 - r14;
        float r17 = r11 + r13;
        float r18 = r10 + r14;
        if (r19.g != null) goto L12;
        r19.g = new e(r15, r16, r13 * 2.0f, 2.0f * r14);
    L12:
        float r110 = r13 * 0.5522848f;
        float r20 = r14 * 0.5522848f;
        Path r21 = new Path();
        r21.moveTo(r11, r16);
        float r111 = r11 + r110;
        float r112 = r10 - r20;
        r21.cubicTo(r111, r16, r17, r112, r17, r10);
        float r22 = r20 + r10;
        r21.cubicTo(r17, r22, r111, r18, r11, r18);
        float r113 = r11 - r110;
        r21.cubicTo(r113, r18, r15, r22, r15, r10);
        r21.cubicTo(r15, r112, r113, r16, r11, r16);
        r21.close();
        return r21;
    L5:
        r11 = 0.0f;
        goto L6
    }

    public final Path f(y r24) {
        q r5 = r24.f9887m;
        if (r5 == null) goto L5;
    L8:
        if (r5 != null) goto L11;
        float r10 = r24.f9888n.h(this);
    L7:
        float r11 = r10;
    L14:
        float r12 = Math.min(r11, r24.f9885k.g(this) / 2.0f);
        float r13 = Math.min(r10, r24.f9886l.h(this) / 2.0f);
        q r14 = r24.f9883i;
        if (r14 == null) goto L17;
        float r15 = r14.g(this);
    L18:
        q r16 = r24.f9884j;
        if (r16 == null) goto L21;
        float r17 = r16.h(this);
    L22:
        float r18 = r24.f9885k.g(this);
        float r19 = r24.f9886l.h(this);
        if (r24.g != null) goto L25;
        r24.g = new e(r15, r17, r18, r19);
    L25:
        float r110 = r15 + r18;
        float r20 = r19 + r17;
        Path r21 = new Path();
        if (r12 != 0.0f) goto L28;
    L32:
        r21.addRect(r15, r17, r110, r20, Path.Direction.CW);
        return r21;
    L28:
        if (r13 == 0.0f) goto L32;
        float r111 = r12 * 0.5522848f;
        float r22 = 0.5522848f * r13;
        float r112 = r17 + r13;
        r21.moveTo(r15, r112);
        float r113 = r112 - r22;
        float r114 = r15 + r12;
        float r23 = r114 - r111;
        r21.cubicTo(r15, r113, r23, r17, r114, r17);
        float r25 = r110 - r12;
        r21.lineTo(r25, r17);
        float r115 = r25 + r111;
        r21.cubicTo(r115, r17, r110, r113, r110, r112);
        float r116 = r20 - r13;
        r21.lineTo(r110, r116);
        float r117 = r116 + r22;
        r21.cubicTo(r110, r117, r115, r20, r25, r20);
        r21.lineTo(r114, r20);
        r21.cubicTo(r23, r20, r15, r117, r15, r116);
        r21.lineTo(r15, r112);
        r21.close();
        return r21;
    L21:
        r17 = 0.0f;
        goto L22
    L17:
        r15 = 0.0f;
        goto L18
    L11:
        if (r24.f9888n != null) goto L13;
        r10 = r5.g(this);
        goto L7
    L13:
        float r26 = r5.g(this);
        r11 = r26;
        r10 = r24.f9888n.h(this);
        goto L14
    L5:
        if (r24.f9888n != null) goto L8;
        r10 = 0.0f;
        goto L7
    }

    public final Path g(f0 r10, e r11) {
        g0 r12 = r10.f9808a.f(this.e.f9844a.f9784u);
        if (r12 != null) goto L6;
        E("ClipPath reference '%s' not found", new Object[]{this.e.f9844a.f9784u});
        return null;
    L6:
        g r13 = (g) r12;
        this.f.push(this.e);
        o0 r5 = new o0();
        t(r5, b0.a());
        r(r13, r5);
        this.e = r5;
        Boolean r14 = r13.f9807j;
        if (r14 != null) goto L9;
    L12:
        boolean r15 = true;
    L13:
        Matrix r16 = new Matrix();
        if (r15 == true) goto L16;
        r16.preTranslate(r11.f9801a, r11.f9802b);
        r16.preScale(r11.f9803c, r11.d);
    L16:
        Matrix r17 = r13.f9840i;
        if (r17 == null) goto L19;
        r16.preConcat(r17);
    L19:
        Path r18 = new Path();
        Iterator r19 = r13.f9800h.iterator();
    L21:
        if (r19.hasNext() == false) goto L29;
        g0 r20 = (g0) r19.next();
        if ((r20 instanceof f0) == false) goto L21;
        Path r21 = h((f0) r20, true);
        if (r21 == null) goto L21;
        r18.op(r21, Path.Op.UNION);
        goto L21
    L29:
        if (this.e.f9844a.f9784u != null) goto L31;
    L36:
        r18.transform(r16);
        this.e = (o0) this.f.pop();
        return r18;
    L31:
        if (r13.g != null) goto L33;
        r13.g = i(r18);
    L33:
        Path r22 = g(r13, r13.g);
        if (r22 == null) goto L36;
        r18.op(r22, Path.Op.INTERSECT);
        goto L36
    L9:
        if (r14.booleanValue() == true) goto L12;
        r15 = false;
        goto L13
    }

    public final Path h(f0 r5, boolean r10) {
        this.f.push(this.e);
        o0 r11 = new o0(this.e);
        this.e = r11;
        u(r11, r5);
        if (y() == true) goto L5;
    L73:
        this.e = (o0) this.f.pop();
        return null;
    L5:
        if (I() == false) goto L73;
        if ((r5 instanceof m0) == false) goto L30;
        if (r10 == true) goto L12;
        E("<use> elements inside a <clipPath> cannot reference another <use>", new Object[0]);
    L12:
        m0 r12 = (m0) r5;
        g0 r13 = r5.f9808a.f(r12.f9835j);
        if (r13 != null) goto L17;
        E("Use reference '%s' not found", new Object[]{r12.f9835j});
        this.e = (o0) this.f.pop();
        return null;
    L17:
        if ((r13 instanceof f0) == true) goto L20;
        this.e = (o0) this.f.pop();
        return null;
    L20:
        Path r14 = h((f0) r13, false);
        if (r14 != null) goto L24;
        return null;
    L24:
        if (r12.g != null) goto L26;
        r12.g = i(r14);
    L26:
        Matrix r15 = r12.f9840i;
        if (r15 == null) goto L65;
        r14.transform(r15);
    L65:
        if (this.e.f9844a.f9784u == null) goto L69;
        Path r16 = g(r5, r5.g);
        if (r16 == null) goto L69;
        r14.op(r16, Path.Op.INTERSECT);
    L69:
        this.e = (o0) this.f.pop();
        return r14;
    L30:
        if ((r5 instanceof m) == false) goto L71;
        m r17 = (m) r5;
        if ((r5 instanceof u) == false) goto L37;
        r14 = (Path) new d(((u) r5).f9873i).f9799c;
        if (r5.g != null) goto L49;
        r5.g = i(r14);
    L49:
        if (r14 != null) goto L52;
        return null;
    L52:
        if (r17.g != null) goto L54;
        r17.g = i(r14);
    L54:
        Matrix r18 = r17.f9834h;
        if (r18 == null) goto L57;
        r14.transform(r18);
    L57:
        SVG$Style$FillRule r19 = this.e.f9844a.f9785v;
        if (r19 != null) goto L60;
    L62:
        Path.FillType r20 = Path.FillType.WINDING;
    L63:
        r14.setFillType(r20);
        goto L65
    L60:
        if (r19 != SVG$Style$FillRule.f9743b) goto L62;
        r20 = Path.FillType.EVEN_ODD;
        goto L63
    L37:
        if ((r5 instanceof y) == false) goto L40;
        r14 = f((y) r5);
        goto L49
    L40:
        if ((r5 instanceof f) == false) goto L43;
        r14 = c((f) r5);
        goto L49
    L43:
        if ((r5 instanceof k) == false) goto L46;
        r14 = d((k) r5);
        goto L49
    L46:
        if ((r5 instanceof w) == false) goto L48;
        r14 = e((w) r5);
        goto L49
    L48:
        r14 = null;
        goto L49
    L71:
        E("Invalid %s element found in clipPath definition", new Object[]{r5.b()});
        return null;
    }

    public final void j(float r5, float r10, float r11, float r12) {
        float r13 = r11 + r5;
        float r14 = r12 + r10;
        l9.l r15 = this.e.f9844a.f9780p;
        if (r15 == null) goto L5;
        r5 = r5 + ((q) r15.e).g(this);
        r10 = r10 + ((q) this.e.f9844a.f9780p.d).h(this);
        r13 = r13 - ((q) this.e.f9844a.f9780p.f19574b).g(this);
        r14 = r14 - ((q) this.e.f9844a.f9780p.f19575c).h(this);
    L5:
        this.f9853a.clipRect(r5, r10, r13, r14);
    }

    public final void l(m r5) {
        i0 r10 = this.e.f9844a.f9770b;
        if ((r10 instanceof t) == false) goto L5;
        x(true, r5.g, (t) r10);
    L5:
        i0 r11 = this.e.f9844a.e;
        if ((r11 instanceof t) == false) goto L9;
        x(false, r5.g, (t) r11);
        return;
    }

    public final void m(m r21, Path r22) {
        i0 r10 = this.e.f9844a.f9770b;
        boolean r11 = r10 instanceof t;
        Canvas r12 = this.f9853a;
        if (r11 == false) goto L113;
        g0 r13 = this.d.f(((t) r10).f9868a);
        if ((r13 instanceof v) == false) goto L113;
        v r14 = (v) r13;
        Boolean r15 = r14.f9874k;
        if (r15 != null) goto L9;
    L11:
        boolean r16 = false;
    L12:
        String r17 = r14.f9881r;
        if (r17 == null) goto L16;
        o(r14, r17);
    L16:
        if (r16 == false) goto L33;
        q r18 = r14.f9877n;
        if (r18 == null) goto L20;
        float r19 = r18.g(this);
    L21:
        q r110 = r14.f9878o;
        if (r110 == null) goto L24;
        float r111 = r110.h(this);
    L25:
        q r112 = r14.f9879p;
        if (r112 == null) goto L28;
        float r113 = r112.g(this);
    L29:
        q r114 = r14.f9880q;
        if (r114 == null) goto L32;
        float r115 = r114.h(this);
    L51:
        if (r113 != 0.0f) goto L53;
        return;
    L53:
        if (r115 == 0.0f) goto L122;
        c r5 = r14.f9819i;
        if (r5 != null) goto L59;
        r5 = c.d;
    L59:
        H();
        r12.clipPath(r22);
        o0 r20 = new o0();
        t(r20, b0.a());
        r20.f9844a.f9779o = Boolean.FALSE;
        r(r14, r20);
        this.e = r20;
        e r23 = r21.g;
        Matrix r116 = r14.f9876m;
        if (r116 == null) goto L79;
        r12.concat(r116);
        Matrix r117 = new Matrix();
        if (r14.f9876m.invert(r117) == false) goto L79;
        e r24 = r21.g;
        float r118 = r24.f9801a;
        float r119 = r24.f9802b;
        float r25 = r24.f9803c + r118;
        float r26 = r24.d + r119;
        float[] r27 = {r118, r119, r25, r119, r25, r26, r118, r26};
        r117.mapPoints(r27);
        float r120 = r27[0];
        float r121 = r27[1];
        RectF r28 = new RectF(r120, r121, r120, r121);
        int r122 = 2;
    L64:
        if (r122 > 6) goto L78;
        float r123 = r27[r122];
        if (r123 >= r28.left) goto L69;
        r28.left = r123;
    L69:
        if (r123 <= r28.right) goto L71;
        r28.right = r123;
    L71:
        float r124 = r27[r122 + 1];
        if (r124 >= r28.top) goto L75;
        r28.top = r124;
    L75:
        if (r124 <= r28.bottom) goto L77;
        r28.bottom = r124;
    L77:
        r122 = r122 + 2;
        goto L64
    L78:
        boolean r125 = true;
        float r29 = r28.left;
        float r126 = r28.top;
        r23 = new e(r29, r126, r28.right - r29, r28.bottom - r126);
    L80:
        float r30 = (((float) Math.floor((r23.f9801a - r19) / r113)) * r113) + r19;
        float r31 = (((float) Math.floor((r23.f9802b - r111) / r115)) * r115) + r111;
        float r32 = r23.f9801a + r23.f9803c;
        float r127 = r23.f9802b + r23.d;
        e r33 = new e(0.0f, 0.0f, r113, r115);
        boolean r128 = F();
    L82:
        if (r31 >= r127) goto L109;
        float r129 = r30;
    L85:
        if (r129 >= r32) goto L108;
        r33.f9801a = r129;
        r33.f9802b = r31;
        H();
        if (this.e.f9844a.f9779o.booleanValue() == true) goto L90;
        j(r33.f9801a, r33.f9802b, r33.f9803c, r33.d);
    L90:
        e r34 = r14.f9833j;
        if (r34 == null) goto L93;
        r12.concat(b(r33, r34, r5));
    L103:
        Iterator r35 = r14.f9800h.iterator();
    L105:
        if (r35.hasNext() == false) goto L107;
        A((g0) r35.next());
        goto L105
    L107:
        G();
        r129 = r129 + r113;
        r30 = r30;
        r32 = r32;
        goto L85
    L93:
        Boolean r36 = r14.f9875l;
        if (r36 != null) goto L96;
    L99:
        boolean r37 = r125;
    L100:
        r12.translate(r129, r31);
        if (r37 == true) goto L103;
        e r38 = r21.g;
        r12.scale(r38.f9803c, r38.d);
        goto L103
    L96:
        if (r36.booleanValue() == true) goto L99;
        r37 = false;
        goto L100
    L108:
        r31 = r31 + r115;
        goto L82
    L109:
        if (r128 == false) goto L111;
        G();
    L111:
        G();
        return;
    L79:
        r125 = true;
        goto L80
    L122:
        return;
    L32:
        r115 = 0.0f;
        goto L51
    L28:
        r113 = 0.0f;
        goto L29
    L24:
        r111 = 0.0f;
        goto L25
    L20:
        r19 = 0.0f;
        goto L21
    L33:
        q r39 = r14.f9877n;
        if (r39 == null) goto L36;
        float r40 = r39.e(this);
    L37:
        q r130 = r14.f9878o;
        if (r130 == null) goto L40;
        float r131 = r130.e(this);
    L41:
        q r132 = r14.f9879p;
        if (r132 == null) goto L44;
        float r133 = r132.e(this);
    L45:
        q r134 = r14.f9880q;
        if (r134 == null) goto L48;
        float r135 = r134.e(this);
    L49:
        e r136 = r21.g;
        float r137 = r136.f9801a;
        float r41 = r136.f9803c;
        r19 = (r40 * r41) + r137;
        float r138 = r136.f9802b;
        float r139 = r136.d;
        r111 = (r131 * r139) + r138;
        r113 = r133 * r41;
        r115 = r135 * r139;
        goto L51
    L48:
        r135 = 0.0f;
        goto L49
    L44:
        r133 = 0.0f;
        goto L45
    L40:
        r131 = 0.0f;
        goto L41
    L36:
        r40 = 0.0f;
        goto L37
    L9:
        if (r15.booleanValue() == false) goto L11;
        r16 = true;
    L113:
        r12.drawPath(r22, this.e.d);
    }

    public final void n(p r10, c r11, Bitmap r12) {
        if (r12 != null) goto L5;
        E("Could not locate image '%s'", new Object[]{r10.f9847j});
        return;
    L5:
        e r5 = new e(0.0f, 0.0f, r12.getWidth(), r12.getHeight());
        u(this.e, r10);
        if (y() == true) goto L9;
        return;
    L9:
        if (I() == false) goto L45;
        Matrix r13 = r10.f9852o;
        Canvas r14 = this.f9853a;
        if (r13 == null) goto L14;
        r14.concat(r13);
    L14:
        q r15 = r10.f9848k;
        if (r15 == null) goto L17;
        float r16 = r15.g(this);
    L18:
        q r17 = r10.f9849l;
        if (r17 == null) goto L21;
        float r18 = r17.h(this);
    L22:
        float r19 = r10.f9850m.g(this);
        float r20 = r10.f9851n.g(this);
        o0 r21 = this.e;
        r21.f = new e(r16, r18, r19, r20);
        if (r21.f9844a.f9779o.booleanValue() == true) goto L25;
        e r22 = this.e.f;
        j(r22.f9801a, r22.f9802b, r22.f9803c, r22.d);
    L25:
        r10.g = this.e.f;
        C(r10);
        D(r10, r10.g);
        boolean r110 = F();
        b0 r23 = this.e.f9844a;
        i0 r24 = r23.f9788y;
        if ((r24 instanceof h) == false) goto L29;
        int r25 = ((h) r24).f9813a;
    L31:
        Float r26 = r23.f9789z;
        if (r26 == null) goto L34;
        r25 = a(r26.floatValue(), r25);
    L34:
        r14.drawColor(r25);
    L35:
        r14.save();
        r14.concat(b(this.e.f, r5, r11));
        if (this.e.f9844a.B != SVG$Style$RenderQuality.f9753c) goto L38;
        int r27 = 0;
    L39:
        r14.drawBitmap(r12, 0.0f, 0.0f, new Paint(r27));
        r14.restore();
        if (r110 == false) goto L43;
        G();
        return;
    L43:
        return;
    L38:
        r27 = 2;
        goto L39
    L29:
        if ((r24 instanceof i) == false) goto L35;
        r25 = r23.f9778n.f9813a;
        goto L31
    L21:
        r18 = 0.0f;
        goto L22
    L17:
        r16 = 0.0f;
        goto L18
    }

    public final void p(c0 r5, e r10, e r11, c r12) {
        w("Svg render", new Object[0]);
        if (r10.f9803c != 0.0f) goto L5;
        return;
    L5:
        if (r10.d == 0.0f) goto L38;
        if (r12 != null) goto L12;
        r12 = r5.f9819i;
        if (r12 != null) goto L12;
        r12 = new c(PreserveAspectRatio$Alignment.f9729a, PreserveAspectRatio$Scale.f9736a);
    L12:
        u(this.e, r5);
        if (y() == false) goto L39;
        o0 r13 = this.e;
        r13.f = r10;
        if (r13.f9844a.f9779o.booleanValue() == true) goto L18;
        e r14 = this.e.f;
        j(r14.f9801a, r14.f9802b, r14.f9803c, r14.d);
    L18:
        D(r5, this.e.f);
        Canvas r15 = this.f9853a;
        if (r11 == null) goto L21;
        r15.concat(b(this.e.f, r11, r12));
        o0 r16 = this.e;
        r16.g = r5.f9833j;
    L22:
        boolean r17 = F();
        b0 r18 = this.e.f9844a;
        i0 r19 = r18.f9788y;
        if ((r19 instanceof h) == false) goto L26;
        int r20 = ((h) r19).f9813a;
    L28:
        Float r21 = r18.f9789z;
        if (r21 == null) goto L31;
        r20 = a(r21.floatValue(), r20);
    L31:
        r15.drawColor(r20);
    L32:
        q(r5);
        if (r17 == false) goto L35;
        G();
    L35:
        C(r5);
        return;
    L26:
        if ((r19 instanceof i) == false) goto L32;
        r20 = r18.f9778n.f9813a;
        goto L28
    L21:
        e r22 = this.e.f;
        r15.translate(r22.f9801a, r22.f9802b);
        goto L22
    L39:
        return;
    }

    public final void q(d0 r5) {
        this.g.push(r5);
        this.f9856h.push(this.f9853a.getMatrix());
        Iterator r10 = r5.f9800h.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        A((g0) r10.next());
        goto L4
    L6:
        this.g.pop();
        this.f9856h.pop();
    }

    public final void r(g0 r5, o0 r10) {
        ArrayList r11 = new ArrayList();
    L3:
        r11.add(0, r5);
        Object r12 = r5.f9809b;
        if (r12 == null) goto L5;
        r5 = (g0) r12;
        goto L3
    L5:
        Iterator r13 = r11.iterator();
    L7:
        if (r13.hasNext() == false) goto L9;
        u(r10, (g0) r13.next());
        goto L7
    L9:
        o0 r14 = this.e;
        r10.g = r14.g;
        r10.f = r14.f;
    }

    public final void t(o0 r13, b0 r14) {
        if (z(r14, 4096) == false) goto L5;
        r13.f9844a.f9778n = r14.f9778n;
    L5:
        long r5 = r14.f9769a;
        if ((2048 & r5) == 0) goto L8;
        r13.f9844a.f9777m = r14.f9777m;
    L8:
        long r10 = 1 & r5;
        h r11 = h.f9812c;
        int r12 = 0;
        if (r10 == 0) goto L17;
        r13.f9844a.f9770b = r14.f9770b;
        i0 r15 = r14.f9770b;
        if (r15 == null) goto L14;
        if (r15 == r11) goto L14;
        boolean r16 = true;
    L15:
        r13.f9845b = r16;
    L14:
        r16 = false;
    L17:
        if ((4 & r5) == 0) goto L20;
        r13.f9844a.d = r14.d;
    L20:
        if ((r5 & 6149) == 0) goto L22;
        v(r13, true, r13.f9844a.f9770b);
    L22:
        long r17 = r14.f9769a;
        if ((2 & r17) == 0) goto L26;
        r13.f9844a.f9771c = r14.f9771c;
    L26:
        if ((8 & r17) == 0) goto L34;
        r13.f9844a.e = r14.e;
        i0 r18 = r14.e;
        if (r18 == null) goto L31;
        if (r18 == r11) goto L31;
        boolean r19 = true;
    L32:
        r13.f9846c = r19;
    L31:
        r19 = false;
    L34:
        if ((16 & r17) == 0) goto L37;
        r13.f9844a.f = r14.f;
    L37:
        if ((r17 & 6168) == 0) goto L39;
        v(r13, false, r13.f9844a.e);
    L39:
        long r20 = r14.f9769a;
        if ((34359738368L & r20) == 0) goto L43;
        r13.f9844a.A = r14.A;
    L43:
        if ((r20 & 32) == 0) goto L52;
        b0 r21 = r13.f9844a;
        q r22 = r14.g;
        r21.g = r22;
        r13.e.setStrokeWidth(r22.b(this));
        if (r13.f9846c == true) goto L47;
    L49:
        boolean r23 = false;
    L50:
        r13.f9846c = r23;
        goto L52
    L47:
        if (r14.g.f() == true) goto L49;
        r23 = true;
    L52:
        if ((64 & r14.f9769a) == 0) goto L62;
        r13.f9844a.f9772h = r14.f9772h;
        int r24 = r14.f9772h.ordinal();
        Paint r25 = r13.e;
        if (r24 == 0) goto L60;
        if (r24 == 1) goto L59;
        if (r24 != 2) goto L62;
        r25.setStrokeCap(Paint.Cap.SQUARE);
        goto L62
    L59:
        r25.setStrokeCap(Paint.Cap.ROUND);
        goto L62
    L60:
        r25.setStrokeCap(Paint.Cap.BUTT);
    L62:
        if ((128 & r14.f9769a) == 0) goto L72;
        r13.f9844a.f9773i = r14.f9773i;
        int r26 = r14.f9773i.ordinal();
        Paint r27 = r13.e;
        if (r26 == 0) goto L70;
        if (r26 == 1) goto L69;
        if (r26 != 2) goto L72;
        r27.setStrokeJoin(Paint.Join.BEVEL);
        goto L72
    L69:
        r27.setStrokeJoin(Paint.Join.ROUND);
        goto L72
    L70:
        r27.setStrokeJoin(Paint.Join.MITER);
    L72:
        if ((256 & r14.f9769a) == 0) goto L74;
        r13.f9844a.f9774j = r14.f9774j;
        r13.e.setStrokeMiter(r14.f9774j.floatValue());
    L74:
        long r28 = r14.f9769a;
        if ((512 & r28) == 0) goto L78;
        r13.f9844a.f9775k = r14.f9775k;
    L78:
        if ((RealWebSocket.DEFAULT_MINIMUM_DEFLATE_SIZE & r28) == 0) goto L81;
        r13.f9844a.f9776l = r14.f9776l;
    L81:
        if ((r28 & 1536) == 0) goto L100;
        q[] r29 = r13.f9844a.f9775k;
        Paint r30 = r13.e;
        if (r29 != null) goto L85;
        r30.setPathEffect(null);
        goto L100
    L85:
        int r31 = r29.length;
        if ((r31 % 2) != 0) goto L88;
        int r32 = r31;
    L89:
        float[] r33 = new float[r32];
        float r34 = 0.0f;
    L90:
        b0 r110 = r13.f9844a;
        if (r12 >= r32) goto L94;
        float r111 = r110.f9775k[r12 % r31].b(this);
        r33[r12] = r111;
        r34 = r34 + r111;
        r12 = r12 + 1;
        goto L90
    L94:
        if (r34 != 0.0f) goto L96;
        r30.setPathEffect(null);
        goto L100
    L96:
        float r112 = r110.f9776l.b(this);
        if (r112 >= 0.0f) goto L99;
        r112 = (r112 % r34) + r34;
    L99:
        r30.setPathEffect(new DashPathEffect(r33, r112));
        goto L100
    L88:
        r32 = r31 * 2;
    L100:
        long r35 = r14.f9769a;
        if ((524288 & r35) == 0) goto L104;
        r13.f9844a.f9779o = r14.f9779o;
    L104:
        if ((16777216 & r35) == 0) goto L107;
        r13.f9844a.f9781q = r14.f9781q;
    L107:
        if ((33554432 & r35) == 0) goto L110;
        r13.f9844a.f9782r = r14.f9782r;
    L110:
        if ((1048576 & r35) == 0) goto L113;
        r13.f9844a.f9780p = r14.f9780p;
    L113:
        if ((268435456 & r35) == 0) goto L116;
        r13.f9844a.f9784u = r14.f9784u;
    L116:
        if ((536870912 & r35) == 0) goto L119;
        r13.f9844a.f9785v = r14.f9785v;
    L119:
        if ((67108864 & r35) == 0) goto L122;
        r13.f9844a.s = r14.s;
    L122:
        if ((134217728 & r35) == 0) goto L125;
        r13.f9844a.f9783t = r14.f9783t;
    L125:
        if ((8589934592L & r35) == 0) goto L128;
        r13.f9844a.f9788y = r14.f9788y;
    L128:
        if ((17179869184L & r35) == 0) goto L131;
        r13.f9844a.f9789z = r14.f9789z;
    L131:
        if ((r35 & 137438953472L) == 0) goto L135;
        r13.f9844a.B = r14.B;
        return;
    }

    public final void u(o0 r5, g0 r10) {
        if (r10.f9809b != null) goto L5;
        boolean r11 = true;
    L6:
        b0 r12 = r5.f9844a;
        Boolean r13 = Boolean.TRUE;
        r12.f9781q = r13;
        if (r11 == true) goto L10;
        r13 = Boolean.FALSE;
    L10:
        r12.f9779o = r13;
        r12.f9780p = null;
        r12.f9784u = null;
        r12.f9777m = Float.valueOf(1.0f);
        r12.s = h.f9811b;
        r12.f9783t = Float.valueOf(1.0f);
        r12.f9786w = null;
        r12.f9787x = Float.valueOf(1.0f);
        r12.f9788y = null;
        r12.f9789z = Float.valueOf(1.0f);
        r12.A = SVG$Style$VectorEffect.f9754a;
        b0 r14 = r10.e;
        if (r14 == null) goto L13;
        t(r5, r14);
    L13:
        b0 r15 = r10.f;
        if (r15 == null) goto L17;
        t(r5, r15);
        return;
    L17:
        return;
    L5:
        r11 = false;
        goto L6
    }

    public final void x(boolean r25, e r26, t r27) {
        g0 r5 = this.d.f(r27.f9868a);
        if (r5 != null) goto L16;
        if (r25 == false) goto L6;
        String r10 = "Fill";
    L7:
        E("%s reference '%s' not found", new Object[]{r10, r27.f9868a});
        i0 r11 = r27.f9869b;
        if (r11 == null) goto L11;
        v(this.e, r25, r11);
        return;
    L11:
        if (r25 == false) goto L14;
        this.e.f9845b = false;
        return;
    L14:
        this.e.f9846c = false;
        return;
    L6:
        r10 = "Stroke";
        goto L7
    L16:
        boolean r12 = r5 instanceof h0;
        h r13 = h.f9811b;
        boolean r14 = true;
        if (r12 == false) goto L123;
        h0 r15 = (h0) r5;
        String r16 = r15.f9832k;
        if (r16 == null) goto L21;
        k(r15, r16);
    L21:
        Boolean r17 = r15.f9829h;
        if (r17 != null) goto L24;
    L26:
        boolean r18 = false;
    L27:
        if (r25 == false) goto L29;
        Paint r19 = this.e.d;
    L30:
        if (r18 == false) goto L51;
        o0 r110 = this.e;
        e r111 = r110.g;
        if (r111 != null) goto L35;
        r111 = r110.f;
    L35:
        q r112 = r15.f9814l;
        if (r112 == null) goto L38;
        float r113 = r112.g(this);
    L39:
        q r114 = r15.f9815m;
        if (r114 == null) goto L42;
        float r115 = r114.h(this);
    L43:
        q r20 = r15.f9816n;
        if (r20 == null) goto L46;
        float r21 = r20.g(this);
    L47:
        q r116 = r15.f9817o;
        if (r116 == null) goto L66;
        float r117 = r116.h(this);
    L50:
        float r118 = r21;
        float r119 = r113;
        float r22 = r117;
        float r120 = r115;
    L67:
        H();
        o0 r23 = new o0();
        t(r23, b0.a());
        r(r15, r23);
        this.e = r23;
        Matrix r24 = new Matrix();
        if (r18 == true) goto L70;
        r24.preTranslate(r26.f9801a, r26.f9802b);
        r24.preScale(r26.f9803c, r26.d);
    L70:
        Matrix r28 = r15.f9830i;
        if (r28 == null) goto L73;
        r24.preConcat(r28);
    L73:
        int r29 = r15.g.size();
        if (r29 != 0) goto L81;
        G();
        if (r25 == false) goto L79;
        this.e.f9845b = false;
        return;
    L79:
        this.e.f9846c = false;
        return;
    L81:
        int[] r30 = new int[r29];
        float[] r31 = new float[r29];
        Iterator r121 = r15.g.iterator();
        int r122 = 0;
        float r123 = -1.0f;
    L83:
        if (r121.hasNext() == false) goto L99;
        a0 r124 = (a0) ((g0) r121.next());
        Float r32 = r124.g;
        if (r32 == null) goto L87;
        float r33 = r32.floatValue();
    L88:
        if (r122 != 0) goto L90;
    L93:
        r31[r122] = r33;
        r123 = r33;
    L94:
        H();
        u(this.e, r124);
        b0 r34 = this.e.f9844a;
        h r125 = (h) r34.s;
        if (r125 != null) goto L97;
        r125 = r13;
    L97:
        r30[r122] = a(r34.f9783t.floatValue(), r125.f9813a);
        r122 = r122 + 1;
        G();
        goto L83
    L90:
        if (r33 >= r123) goto L93;
        r31[r122] = r123;
        goto L94
    L87:
        r33 = 0.0f;
        goto L88
    L99:
        if (r119 == r118) goto L101;
    L102:
        if (r29 != 1) goto L105;
    L103:
        G();
        r19.setColor(r30[r29 - 1]);
        return;
    L105:
        Shader.TileMode r35 = Shader.TileMode.CLAMP;
        SVG$GradientSpread r36 = r15.f9831j;
        if (r36 != null) goto L108;
    L110:
        Shader.TileMode r210 = r35;
        G();
        LinearGradient r37 = new LinearGradient(r119, r120, r118, r22, r30, r31, r210);
        r37.setLocalMatrix(r24);
        r19.setShader(r37);
        int r38 = (int) (this.e.f9844a.d.floatValue() * 256.0f);
        if (r38 >= 0) goto L117;
        int r39 = 0;
    L120:
        r19.setAlpha(r39);
        return;
    L117:
        if (r38 <= 255) goto L119;
        r39 = 255;
        goto L120
    L119:
        r39 = r38;
        goto L120
    L108:
        if (r36 != SVG$GradientSpread.f9739a) goto L112;
        r35 = Shader.TileMode.MIRROR;
        goto L110
    L112:
        if (r36 != SVG$GradientSpread.f9740b) goto L110;
        r35 = Shader.TileMode.REPEAT;
        goto L110
    L101:
        if (r120 == r22) goto L103;
    L66:
        r118 = r21;
        r119 = r113;
        r120 = r115;
        r22 = 0.0f;
        goto L67
    L46:
        r21 = r111.f9803c;
        goto L47
    L42:
        r115 = 0.0f;
        goto L43
    L38:
        r113 = 0.0f;
        goto L39
    L51:
        q r40 = r15.f9814l;
        if (r40 == null) goto L54;
        r113 = r40.e(this);
    L55:
        q r41 = r15.f9815m;
        if (r41 == null) goto L58;
        r115 = r41.e(this);
    L59:
        q r42 = r15.f9816n;
        if (r42 == null) goto L62;
        r21 = r42.e(this);
    L63:
        q r126 = r15.f9817o;
        if (r126 == null) goto L66;
        r117 = r126.e(this);
        goto L50
    L62:
        r21 = 1.0f;
        goto L63
    L58:
        r115 = 0.0f;
        goto L59
    L54:
        r113 = 0.0f;
        goto L55
    L29:
        r19 = this.e.e;
        goto L30
    L24:
        if (r17.booleanValue() == false) goto L26;
        r18 = true;
        goto L27
    L123:
        if ((r5 instanceof k0) == false) goto L218;
        k0 r43 = (k0) r5;
        String r44 = r43.f9832k;
        if (r44 == null) goto L127;
        k(r43, r44);
    L127:
        Boolean r45 = r43.f9829h;
        if (r45 != null) goto L130;
    L132:
        boolean r46 = false;
    L133:
        if (r25 == false) goto L135;
        Paint r47 = this.e.d;
    L136:
        if (r46 == false) goto L151;
        q r48 = new q(50.0f, SVG$Unit.d);
        q r127 = r43.f9824l;
        if (r127 == null) goto L140;
        float r128 = r127.g(this);
    L141:
        q r129 = r43.f9825m;
        if (r129 == null) goto L144;
        float r130 = r129.h(this);
    L145:
        q r131 = r43.f9826n;
        if (r131 == null) goto L150;
        float r49 = r131.b(this);
    L148:
        float r132 = r49;
        float r133 = r128;
    L149:
        float r134 = r130;
        H();
        o0 r50 = new o0();
        t(r50, b0.a());
        r(r43, r50);
        this.e = r50;
        Matrix r51 = new Matrix();
        if (r46 == true) goto L166;
        r51.preTranslate(r26.f9801a, r26.f9802b);
        r51.preScale(r26.f9803c, r26.d);
    L166:
        Matrix r52 = r43.f9830i;
        if (r52 == null) goto L169;
        r51.preConcat(r52);
    L169:
        int r53 = r43.g.size();
        if (r53 != 0) goto L177;
        G();
        if (r25 == false) goto L175;
        this.e.f9845b = false;
        return;
    L175:
        this.e.f9846c = false;
        return;
    L177:
        int[] r54 = new int[r53];
        float[] r135 = new float[r53];
        Iterator r136 = r43.g.iterator();
        int r137 = 0;
        float r138 = -1.0f;
    L179:
        if (r136.hasNext() == false) goto L195;
        a0 r55 = (a0) ((g0) r136.next());
        Float r139 = r55.g;
        if (r139 == null) goto L183;
        float r140 = r139.floatValue();
    L184:
        if (r137 != 0) goto L186;
    L189:
        r135[r137] = r140;
        r138 = r140;
    L190:
        H();
        u(this.e, r55);
        b0 r56 = this.e.f9844a;
        h r141 = (h) r56.s;
        if (r141 != null) goto L193;
        r141 = r13;
    L193:
        r54[r137] = a(r56.f9783t.floatValue(), r141.f9813a);
        r137 = r137 + 1;
        G();
        goto L179
    L186:
        if (r140 >= r138) goto L189;
        r135[r137] = r138;
        goto L190
    L183:
        r140 = 0.0f;
        goto L184
    L195:
        if (r132 == 0.0f) goto L215;
        if (r53 == 1) goto L215;
        Shader.TileMode r57 = Shader.TileMode.CLAMP;
        SVG$GradientSpread r58 = r43.f9831j;
        if (r58 != null) goto L201;
    L203:
        Shader.TileMode r142 = r57;
        G();
        RadialGradient r59 = new RadialGradient(r133, r134, r132, r54, r135, r142);
        r59.setLocalMatrix(r51);
        r47.setShader(r59);
        int r60 = (int) (this.e.f9844a.d.floatValue() * 256.0f);
        if (r60 >= 0) goto L211;
        r60 = 0;
    L213:
        r47.setAlpha(r60);
        return;
    L211:
        if (r60 <= 255) goto L213;
        r60 = 255;
        goto L213
    L201:
        if (r58 != SVG$GradientSpread.f9739a) goto L205;
        r57 = Shader.TileMode.MIRROR;
        goto L203
    L205:
        if (r58 != SVG$GradientSpread.f9740b) goto L203;
        r57 = Shader.TileMode.REPEAT;
    L215:
        G();
        r47.setColor(r54[r53 - 1]);
        return;
    L150:
        r49 = r48.b(this);
        goto L148
    L144:
        r130 = r48.h(this);
        goto L145
    L140:
        r128 = r48.g(this);
        goto L141
    L151:
        q r61 = r43.f9824l;
        float r143 = 0.5f;
        if (r61 == null) goto L154;
        float r62 = r61.e(this);
    L155:
        q r144 = r43.f9825m;
        if (r144 == null) goto L158;
        r130 = r144.e(this);
    L159:
        q r145 = r43.f9826n;
        if (r145 == null) goto L162;
        r143 = r145.e(this);
    L162:
        r133 = r62;
        r132 = r143;
        goto L149
    L158:
        r130 = 0.5f;
        goto L159
    L154:
        r62 = 0.5f;
        goto L155
    L135:
        r47 = this.e.e;
        goto L136
    L130:
        if (r45.booleanValue() == false) goto L132;
        r46 = true;
        goto L133
    L218:
        if ((r5 instanceof z) == false) goto L255;
        z r63 = (z) r5;
        if (r25 == false) goto L236;
        if (z(r63.e, 2147483648L) == false) goto L229;
        o0 r64 = this.e;
        b0 r65 = r64.f9844a;
        i0 r146 = r63.e.f9786w;
        r65.f9770b = r146;
        if (r146 != null) goto L227;
        r14 = false;
    L227:
        r64.f9845b = r14;
    L229:
        if (z(r63.e, 4294967296L) == false) goto L232;
        this.e.f9844a.d = r63.e.f9787x;
    L232:
        if (z(r63.e, 6442450944L) == false) goto L256;
        o0 r66 = this.e;
        v(r66, r25, r66.f9844a.f9770b);
        return;
    L256:
        return;
    L236:
        if (z(r63.e, 2147483648L) == false) goto L243;
        o0 r67 = this.e;
        b0 r68 = r67.f9844a;
        i0 r147 = r63.e.f9786w;
        r68.e = r147;
        if (r147 != null) goto L241;
        r14 = false;
    L241:
        r67.f9846c = r14;
    L243:
        if (z(r63.e, 4294967296L) == false) goto L246;
        this.e.f9844a.f = r63.e.f9787x;
    L246:
        if (z(r63.e, 6442450944L) == false) goto L257;
        o0 r69 = this.e;
        v(r69, r25, r69.f9844a.e);
        return;
    L257:
        return;
    }

    public final boolean y() {
        Boolean r5 = this.e.f9844a.f9781q;
        if (r5 != null) goto L5;
        return true;
    L5:
        return r5.booleanValue();
    }
}
