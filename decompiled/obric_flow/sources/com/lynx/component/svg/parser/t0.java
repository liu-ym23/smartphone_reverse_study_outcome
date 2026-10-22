package com.lynx.component.svg.parser;

import android.graphics.Matrix;
import android.util.Log;
import android.util.Xml;
import com.lynx.base.log.LynxLog;
import com.lynx.serval.svg.SVGRenderEngine;
import com.lynx.tasm.utils.ColorUtils;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import okhttp3.internal.ws.RealWebSocket;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes2.dex */
public final class t0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public n0 f9870a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public e0 f9871b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f9872c;
    public int d;

    public static float a(int r5, String r10) {
        float r11 = new b().a(0, r5, r10);
        if (Float.isNaN(r11) == true) goto L6;
        return r11;
    L6:
        throw new SVGParseException(td.d.b("Invalid float value: ", r10));
    }

    public static h b(String r5) {
        return new h(ColorUtils.b(r5));
    L4:
        e = move-exception;
        throw new SVGParseException(e.toString());
    }

    public static q c(r0 r5) {
        int r10 = r5.f9864a;
        if (r10 <= (r5.f9865b - 4)) goto L5;
    L7:
        boolean r11 = false;
    L8:
        if (r11 == false) goto L10;
        r5.f9864a += 4;
    L10:
        if (r11 == false) goto L14;
        return new q();
    L14:
        return r5.k();
    L5:
        if (((String) r5.f9866c).substring(r10, r10 + 4).equals("auto") == false) goto L7;
        r11 = true;
        goto L8
    }

    public static void d(l r5, s0 r10) {
        int r11 = 0;
    L3:
        XmlPullParser r12 = r10.f9867a;
        if (r11 >= r12.getAttributeCount()) goto L33;
        String r13 = r12.getAttributeValue(r11).trim();
        int r14 = SVGParser$SVGAttr.a(r12.getAttributeName(r11)).ordinal();
        if (r14 != 17) goto L8;
        r5.f9830i = s(r13);
    L32:
        r11 = r11 + 1;
        goto L3
    L8:
        if (r14 == 18) goto L24;
        if (r14 == 20) goto L19;
        if (r14 != 39) goto L32;
        r5.f9831j = SVG$GradientSpread.valueOf(r13);     // Catch: IllegalArgumentException -> L16
    L17:
        throw new SVGParseException(com.lynx.tasm.utils.g.d("Invalid spreadMethod attribute. \"", r13, "\" is not a valid value."));
    L19:
        if ("".equals(r12.getAttributeNamespace(r11)) == false) goto L21;
    L22:
        r5.f9832k = r13;
        goto L32
    L21:
        if ("http://www.w3.org/1999/xlink".equals(r12.getAttributeNamespace(r11)) == false) goto L32;
    L24:
        if ("objectBoundingBox".equals(r13) == false) goto L27;
        r5.f9829h = Boolean.FALSE;
        goto L32
    L27:
        if ("userSpaceOnUse".equals(r13) == false) goto L30;
        r5.f9829h = Boolean.TRUE;
        goto L32
    L30:
        throw new SVGParseException("Invalid value for attribute gradientUnits");
    }

    public static void e(o r5, s0 r10) {
        int r11 = 0;
    L3:
        XmlPullParser r12 = r10.f9867a;
        if (r11 >= r12.getAttributeCount()) goto L9;
        if (SVGParser$SVGAttr.a(r12.getAttributeName(r11)) != SVGParser$SVGAttr.f9761b) goto L8;
        r5.a(s(r12.getAttributeValue(r11)));
    L8:
        r11 = r11 + 1;
        goto L3
    }

    public static void f(w r10, s0 r11, String r12) {
        int r5 = 0;
    L3:
        XmlPullParser r13 = r11.f9867a;
        if (r5 >= r13.getAttributeCount()) goto L24;
        if (SVGParser$SVGAttr.a(r13.getAttributeName(r5)) != SVGParser$SVGAttr.f9760a) goto L23;
        r0 r14 = new r0(r13.getAttributeValue(r5));
        ArrayList r15 = new ArrayList();
        r14.o();
    L9:
        if (r14.i() == true) goto L19;
        float r16 = r14.j();
        if (Float.isNaN(r16) == true) goto L18;
        r14.n();
        float r17 = r14.j();
        if (Float.isNaN(r17) == true) goto L16;
        r14.n();
        r15.add(Float.valueOf(r16));
        r15.add(Float.valueOf(r17));
        goto L9
    L16:
        throw new SVGParseException(com.lynx.tasm.utils.g.d("Invalid <", r12, "> points attribute. There should be an even number of coordinates."));
    L18:
        throw new SVGParseException(com.lynx.tasm.utils.g.d("Invalid <", r12, "> points attribute. Non-coordinate content found in list."));
    L19:
        r10.f9882i = new float[r15.size()];
        Iterator r18 = r15.iterator();
        int r19 = 0;
    L21:
        if (r18.hasNext() == false) goto L23;
        r10.f9882i[r19] = ((Float) r18.next()).floatValue();
        r19 = r19 + 1;
    L23:
        r5 = r5 + 1;
        goto L3
    }

    public static void g(b0 r12, String r13, String r14) {
        byte r5 = 2;
        if (r14.length() != 0) goto L6;
        return;
    L6:
        if (r14.equals("inherit") == true) goto L306;
        int r15 = SVGParser$SVGAttr.a(r13).ordinal();
        l9.l r10 = null;
        SVG$Style$FillRule r11 = null;
        SVG$Style$LineJoin r16 = null;
        SVG$Style$LineCap r17 = null;
        q[] r18 = null;
        r18 = null;
        r18 = null;
        r18 = null;
        r18 = null;
        r18 = null;
        SVG$Style$FillRule r19 = null;
        SVG$Style$VectorEffect r20 = null;
        Boolean r21 = null;
        SVG$Style$RenderQuality r22 = null;
        String r23 = null;
        r23 = null;
        r10 = null;
        r10 = null;
        if (r15 == 0) goto L255;
        if (r15 == 1) goto L243;
        if (r15 == 3) goto L235;
        if (r15 != 4) goto L16;
        r12.f9778n = b(r14);     // Catch: SVGParseException -> L270
        r12.f9769a |= 4096;     // Catch: SVGParseException -> L270
        return;
    L16:
        if (r15 == 21) goto L210;
        if (r15 != 23) goto L20;
        r12.f9777m = q(r14);
        r12.f9769a |= 2048;
        return;
    L20:
        if (r15 == 25) goto L182;
        if (r15 == 54) goto L171;
        i r24 = i.f9818a;
        if (r15 == 37) goto L163;
        if (r15 != 38) goto L28;
        r12.f9787x = q(r14);
        r12.f9769a |= 4294967296L;
        return;
    L28:
        switch(r15) {
            case 13: goto L154;
            case 14: goto L149;
            case 15: goto L140;
            case 16: goto L135;
            default: goto L30;
        };
    L135:
        Float r110 = q(r14);
        r12.d = r110;
        if (r110 == null) goto L296;
        r12.f9769a |= 4;
        return;
    L296:
        return;
    L149:
        i0 r111 = r(r14);
        r12.f9770b = r111;
        if (r111 == null) goto L298;
        r12.f9769a |= 1;
        return;
    L298:
        return;
    L30:
        switch(r15) {
            case 41: goto L128;
            case 42: goto L125;
            case 43: goto L121;
            case 44: goto L91;
            case 45: goto L88;
            case 46: goto L76;
            case 47: goto L63;
            case 48: goto L56;
            case 49: goto L52;
            case 50: goto L50;
            default: goto L31;
        };
    L31:
        switch(r15) {
            case 64: goto L43;
            case 65: goto L40;
            case 66: goto L34;
            default: goto L307;
        };
    L40:
        r12.f9789z = q(r14);
        r12.f9769a |= 17179869184L;
        return;
    L307:
        return;
    L34:
        if (r14.indexOf(124) < 0) goto L36;
        return;
    L36:
        if ("|visible|hidden|collapse|".contains("|" + r14 + '|') == false) goto L308;
        r12.f9782r = Boolean.valueOf(r14.equals("visible"));
        r12.f9769a |= 33554432;
        return;
    L308:
        return;
    L43:
        if (r14.equals("currentColor") == false) goto L271;
        r12.f9788y = r24;
    L46:
        r12.f9769a |= 8589934592L;
        return;
    L271:
        r12.f9788y = b(r14);     // Catch: SVGParseException -> L48
    L48:
        e = move-exception;
        Log.w("SVGParser", e.getMessage());
        return;
    L50:
        r12.g = o(r14);     // Catch: SVGParseException -> L270
        r12.f9769a |= 32;     // Catch: SVGParseException -> L270
        return;
    L52:
        Float r112 = q(r14);
        r12.f = r112;
        if (r112 == null) goto L290;
        r12.f9769a |= 16;
        return;
    L290:
        return;
    L56:
        int r113 = r14.length();     // Catch: SVGParseException -> L270
        if (r113 == 0) goto L61;
        r12.f9774j = Float.valueOf(a(r113, r14));     // Catch: SVGParseException -> L270
        r12.f9769a |= 256;     // Catch: SVGParseException -> L270
        return;
    L61:
        throw new SVGParseException("Invalid float value (empty string)");     // Catch: SVGParseException -> L270
    L88:
        r12.f9776l = o(r14);     // Catch: SVGParseException -> L270
        r12.f9769a |= RealWebSocket.DEFAULT_MINIMUM_DEFLATE_SIZE;     // Catch: SVGParseException -> L270
        return;
    L121:
        i0 r114 = r(r14);
        r12.e = r114;
        if (r114 == null) goto L294;
        r12.f9769a |= 8;
        return;
    L294:
        return;
    L125:
        r12.f9783t = q(r14);
        r12.f9769a |= 134217728;
        return;
    L63:
        if ("miter".equals(r14) == false) goto L66;
        r16 = SVG$Style$LineJoin.f9748a;
    L71:
        r12.f9773i = r16;
        if (r16 == null) goto L291;
        r12.f9769a |= 128;
        return;
    L291:
        return;
    L66:
        if ("round".equals(r14) == false) goto L69;
        r16 = SVG$Style$LineJoin.f9749b;
        goto L71
    L69:
        if ("bevel".equals(r14) == false) goto L71;
        r16 = SVG$Style$LineJoin.f9750c;
        goto L71
    L76:
        if ("butt".equals(r14) == false) goto L79;
        r17 = SVG$Style$LineCap.f9745a;
    L84:
        r12.f9772h = r17;
        if (r17 == null) goto L292;
        r12.f9769a |= 64;
        return;
    L292:
        return;
    L79:
        if ("round".equals(r14) == false) goto L82;
        r17 = SVG$Style$LineCap.f9746b;
        goto L84
    L82:
        if ("square".equals(r14) == false) goto L84;
        r17 = SVG$Style$LineCap.f9747c;
        goto L84
    L91:
        if ("none".equals(r14) == false) goto L94;
        r12.f9775k = null;
        r12.f9769a |= 512;
        return;
    L94:
        r0 r115 = new r0(r14);
        r115.o();
        if (r115.i() == true) goto L117;
        q r116 = r115.k();
        if (r116 == null) goto L117;
        if (r116.c() == true) goto L117;
        ArrayList r25 = new ArrayList();
        r25.add(r116);
        float r117 = r116.f9857a;
    L105:
        if (r115.i() == true) goto L114;
        r115.n();
        q r26 = r115.k();
        if (r26 == null) goto L117;
        if (r26.c() == true) goto L117;
        r25.add(r26);
        r117 = r117 + r26.f9857a;
        goto L105
    L114:
        if (r117 == 0.0f) goto L117;
        r18 = (q[]) r25.toArray(new q[r25.size()]);
    L117:
        r12.f9775k = r18;
        if (r18 == null) goto L293;
        r12.f9769a |= 512;
        return;
    L293:
        return;
    L128:
        if (r14.equals("currentColor") == false) goto L276;
        r12.s = r24;
    L131:
        r12.f9769a |= 67108864;
        return;
    L276:
        r12.s = b(r14);     // Catch: SVGParseException -> L133
    L133:
        e = move-exception;
        Log.w("SVGParser", e.getMessage());
        return;
    L140:
        if ("nonzero".equals(r14) == false) goto L143;
        r19 = SVG$Style$FillRule.f9742a;
    L145:
        r12.f9771c = r19;
        if (r19 == null) goto L297;
        r12.f9769a |= 2;
        return;
    L297:
        return;
    L143:
        if ("evenodd".equals(r14) == false) goto L145;
        r19 = SVG$Style$FillRule.f9743b;
        goto L145
    L154:
        if (r14.indexOf(124) < 0) goto L156;
        return;
    L156:
        if ("|inline|block|list-item|run-in|compact|marker|table|inline-table|table-row-group|table-header-group|table-footer-group|table-row|table-column-group|table-column|table-cell|table-caption|none|".contains("|" + r14 + '|') == false) goto L309;
        r12.f9781q = Boolean.valueOf(!r14.equals("none"));
        r12.f9769a |= 16777216;
        return;
    L309:
        return;
    L163:
        if (r14.equals("currentColor") == false) goto L273;
        r12.f9786w = r24;
    L166:
        r12.f9769a |= 2147483648L;
        return;
    L273:
        r12.f9786w = b(r14);     // Catch: SVGParseException -> L168
    L168:
        e = move-exception;
        Log.w("SVGParser", e.getMessage());
        return;
    L171:
        if (r14.equals("none") == false) goto L173;
        r20 = SVG$Style$VectorEffect.f9754a;
    L177:
        r12.A = r20;
        if (r20 == null) goto L301;
        r12.f9769a |= 34359738368L;
        return;
    L301:
        return;
    L173:
        if (r14.equals("non-scaling-stroke") == false) goto L177;
        r20 = SVG$Style$VectorEffect.f9755b;
        goto L177
    L182:
        switch(r14.hashCode()) {
            case -1217487446: goto L196;
            case -907680051: goto L192;
            case 3005871: goto L189;
            case 466743410: goto L185;
            default: goto L183;
        };
    L183:
        r5 = -1;
    L199:
        switch(r5) {
            case 0: goto L202;
            case 1: goto L202;
            case 2: goto L201;
            case 3: goto L201;
            default: goto L203;
        };
    L201:
        r21 = Boolean.TRUE;
        goto L203
    L202:
        r21 = Boolean.FALSE;
    L203:
        r12.f9779o = r21;
        if (r21 == null) goto L302;
        r12.f9769a |= 524288;
        return;
    L302:
        return;
    L185:
        if (r14.equals("visible") == false) goto L281;
        r5 = 3;
        goto L199
    L281:
        r5 = -1;
        goto L199
    L189:
        if (r14.equals("auto") == true) goto L199;
        r5 = -1;
        goto L199
    L192:
        if (r14.equals("scroll") == false) goto L283;
        r5 = 1;
        goto L199
    L283:
        r5 = -1;
        goto L199
    L196:
        if (r14.equals("hidden") == false) goto L284;
        r5 = 0;
        goto L199
    L284:
        r5 = -1;
        goto L199
    L210:
        switch(r14.hashCode()) {
            case -933002398: goto L220;
            case 3005871: goto L216;
            case 362741610: goto L213;
            default: goto L211;
        };
    L211:
        r5 = -1;
    L223:
        switch(r5) {
            case 0: goto L227;
            case 1: goto L226;
            case 2: goto L225;
            default: goto L228;
        };
    L225:
        r22 = SVG$Style$RenderQuality.f9753c;
        goto L228
    L226:
        r22 = SVG$Style$RenderQuality.f9751a;
        goto L228
    L227:
        r22 = SVG$Style$RenderQuality.f9752b;
    L228:
        r12.B = r22;
        if (r22 == null) goto L303;
        r12.f9769a |= 137438953472L;
        return;
    L303:
        return;
    L213:
        if (r14.equals("optimizeSpeed") == true) goto L223;
        r5 = -1;
        goto L223
    L216:
        if (r14.equals("auto") == false) goto L286;
        r5 = 1;
        goto L223
    L286:
        r5 = -1;
        goto L223
    L220:
        if (r14.equals("optimizeQuality") == false) goto L287;
        r5 = 0;
        goto L223
    L287:
        r5 = -1;
        goto L223
    L310:
        return;
    L235:
        if ("nonzero".equals(r14) == false) goto L238;
        r11 = SVG$Style$FillRule.f9742a;
    L240:
        r12.f9785v = r11;
        r12.f9769a |= 536870912;
        return;
    L238:
        if ("evenodd".equals(r14) == false) goto L240;
        r11 = SVG$Style$FillRule.f9743b;
        goto L240
    L243:
        if (r14.equals("none") == false) goto L246;
    L252:
        r12.f9784u = r23;
        r12.f9769a |= 268435456;
        return;
    L246:
        if (r14.startsWith("url(") == false) goto L252;
        if (r14.endsWith(")") == false) goto L251;
        r23 = r14.substring(4, r14.length() - 1).trim();
        goto L252
    L251:
        r23 = r14.substring(4).trim();
        goto L252
    L255:
        if ("auto".equals(r14) == false) goto L258;
    L266:
        r12.f9780p = r10;
        if (r10 == null) goto L304;
        r12.f9769a |= 1048576;
        return;
    L304:
        return;
    L258:
        if (r14.startsWith("rect(") == false) goto L266;
        r0 r118 = new r0(r14.substring(5));
        r118.o();
        q r119 = c(r118);
        r118.n();
        q r27 = c(r118);
        r118.n();
        q r28 = c(r118);
        r118.n();
        q r29 = c(r118);
        r118.o();
        if (r118.g(')') == false) goto L263;
    L265:
        r10 = new l9.l(r119, r27, r28, r29);
        goto L266
    L263:
        if (r118.i() == true) goto L265;
    }

    public static void h(g0 r5, s0 r10) {
        int r11 = 0;
    L3:
        XmlPullParser r12 = r10.f9867a;
        if (r11 >= r12.getAttributeCount()) goto L29;
        String r13 = r10.getQName(r11);
        if (r13.equals("id") == true) goto L23;
        if (r13.equals("xml:id") == true) goto L23;
        if (r13.equals("xml:space") == true) goto L12;
        r11 = r11 + 1;
        goto L3
    L12:
        String r14 = r12.getAttributeValue(r11).trim();
        if ("default".equals(r14) == false) goto L17;
        r5.d = Boolean.FALSE;
        return;
    L17:
        if ("preserve".equals(r14) == false) goto L21;
        r5.d = Boolean.TRUE;
        return;
    L21:
        throw new SVGParseException(td.d.b("Invalid value for \"xml:space\" attribute: ", r14));
    L23:
        r5.f9810c = r12.getAttributeValue(r11).trim();
        return;
    }

    public static void i(j0 r5, String r10) {
        r0 r11 = new r0(r10);
        r11.o();
        String r12 = r11.l();
        if ("defer".equals(r12) == false) goto L5;
        r11.o();
        r12 = r11.l();
    L5:
        PreserveAspectRatio$Alignment r13 = (PreserveAspectRatio$Alignment) q0.f9859a.get(r12);
        r11.o();
        if (r11.i() == true) goto L15;
        String r14 = r11.l();
        r14.getClass();
        if (r14.equals("meet") == false) goto L10;
        PreserveAspectRatio$Scale r15 = PreserveAspectRatio$Scale.f9736a;
    L16:
        r5.f9819i = new c(r13, r15);
        return;
    L10:
        if (r14.equals("slice") == false) goto L13;
        r15 = PreserveAspectRatio$Scale.f9737b;
        goto L16
    L13:
        throw new SVGParseException("Invalid preserveAspectRatio definition: ".concat(r10));
    L15:
        r15 = null;
        goto L16
    }

    public static void j(l0 r10, s0 r11) {
        int r5 = 0;
    L3:
        XmlPullParser r12 = r11.f9867a;
        if (r5 >= r12.getAttributeCount()) goto L31;
        String r13 = r12.getAttributeValue(r5).trim();
        int r14 = SVGParser$SVGAttr.a(r12.getAttributeName(r5)).ordinal();
        if (r14 != 31) goto L8;
        i(r10, r13);
    L30:
        r5 = r5 + 1;
        goto L3
    L8:
        if (r14 != 56) goto L30;
        r0 r15 = new r0(r13);
        r15.o();
        float r16 = com.lynx.tasm.utils.k.b(r15.l());
        r15.n();
        float r17 = com.lynx.tasm.utils.k.b(r15.l());
        r15.n();
        float r18 = com.lynx.tasm.utils.k.b(r15.l());
        r15.n();
        float r19 = com.lynx.tasm.utils.k.b(r15.l());
        if (Float.isNaN(r16) == true) goto L28;
        if (Float.isNaN(r17) == true) goto L28;
        if (Float.isNaN(r18) == true) goto L28;
        if (Float.isNaN(r19) == true) goto L28;
        if (r18 < 0.0f) goto L26;
        if (r19 < 0.0f) goto L24;
        r10.f9833j = new e(r16, r17, r18, r19);
        goto L30
    L24:
        throw new SVGParseException("Invalid viewBox. height cannot be negative");
    L26:
        throw new SVGParseException("Invalid viewBox. width cannot be negative");
    L28:
        throw new SVGParseException("Invalid viewBox definition - should have four numbers");
    }

    public static void n(String r5, Object... r10) {
        LynxLog.b(1, "SVGParser", String.format(r5, r10));
    }

    public static q o(String r5) {
        if (r5.length() == 0) goto L34;
        int r10 = r5.length();
        SVG$Unit r11 = SVG$Unit.f9757a;
        char r12 = r5.charAt(r10 - 1);
        if (r12 != '%') goto L8;
        r10 = r10 - 1;
        r11 = SVG$Unit.d;
    L35:
        return new q(a(r10, r5), r11);
    L30:
        e = move-exception;
        throw new SVGParseException("Invalid length value: ".concat(r5), e);
    L8:
        if (r5.endsWith("rpx") == false) goto L12;
        r11 = SVG$Unit.e;
    L10:
        r10 = r10 - 3;
        goto L35
    L12:
        if (r5.endsWith("rem") == false) goto L15;
        r11 = SVG$Unit.f;
        goto L10
    L15:
        if (r5.endsWith("em") == false) goto L18;
        r11 = SVG$Unit.f9758b;
        r10 = r10 - 2;
        goto L35
    L18:
        if (r10 <= 2) goto L35;
        if (Character.isLetter(r12) == false) goto L35;
        if (Character.isLetter(r5.charAt(r10 - 2)) == false) goto L35;
        r10 = r10 - 2;
        r11 = SVG$Unit.valueOf(r5.substring(r10).toLowerCase(Locale.US));     // Catch: IllegalArgumentException -> L26
    L27:
        throw new SVGParseException("Invalid length unit specifier: ".concat(r5));
    L34:
        throw new SVGParseException("Invalid length value (empty string)");
    }

    public static void p(g0 r12, s0 r13) {
        int r5 = 0;
    L3:
        XmlPullParser r10 = r13.f9867a;
        if (r5 >= r10.getAttributeCount()) goto L90;
        String r11 = r10.getAttributeValue(r5).trim();
        if (r11.length() == 0) goto L89;
        if (SVGParser$SVGAttr.a(r10.getAttributeName(r5)).ordinal() != 51) goto L11;
        a r14 = new a(r11.replaceAll("/\\*.*?\\*/", "").replaceAll("(?s)/\\*.*?\\*/", ""));
    L16:
        if (r14.i() == true) goto L89;
        r14.o();
        boolean r15 = r14.i();
        String r16 = (String) r14.f9866c;
        if (r15 == false) goto L20;
        int r17 = r14.f9864a;
    L45:
        int r18 = r14.f9864a;
        String r19 = null;
        if (r17 != r18) goto L48;
        String r20 = null;
    L49:
        r14.o();
        if (r14.g(';') == true) goto L16;
        if (r14.g(':') == false) goto L89;
        r14.o();
        if (r14.i() == true) goto L79;
        int r21 = r14.f9864a;
        int r22 = r16.charAt(r21);
        int r23 = r21;
    L60:
        if (r22 == (-1)) goto L76;
        if (r22 == 59) goto L76;
        if (r22 == 125) goto L76;
        if (r22 == 33) goto L76;
        if (r22 == 10) goto L76;
        if (r22 == 13) goto L76;
        if (r0.h(r22) == true) goto L74;
        r23 = r14.f9864a + 1;
    L74:
        r22 = r14.b();
    L76:
        if (r14.f9864a <= r21) goto L78;
        r19 = r16.substring(r21, r23);
        goto L79
    L78:
        r14.f9864a = r21;
    L79:
        if (r19 == null) goto L16;
        r14.o();
        if (r14.i() == true) goto L86;
        if (r14.g(';') == false) goto L16;
    L86:
        if (r12.f != null) goto L88;
        r12.f = new b0();
    L88:
        g(r12.f, r20, r19);
        r14.o();
        goto L16
    L48:
        r20 = r16.substring(r18, r17);
        r14.f9864a = r17;
        goto L49
    L20:
        int r24 = r14.f9864a;
        int r25 = r16.charAt(r24);
        if (r25 != 45) goto L24;
        r25 = r14.b();
    L24:
        if (r25 < 65) goto L26;
        if (r25 > 90) goto L26;
    L29:
        int r26 = r14.b();
    L30:
        if (r26 < 65) goto L32;
        if (r26 > 90) goto L32;
    L42:
        r26 = r14.b();
    L32:
        if (r26 < 97) goto L35;
        if (r26 <= 122) goto L42;
    L35:
        if (r26 >= 48) goto L37;
    L38:
        if (r26 == 45) goto L42;
        if (r26 == 95) goto L42;
        int r27 = r14.f9864a;
    L44:
        r14.f9864a = r24;
        r17 = r27;
        goto L45
    L37:
        if (r26 <= 57) goto L42;
    L26:
        if (r25 < 97) goto L28;
        if (r25 <= 122) goto L29;
    L28:
        if (r25 == 95) goto L29;
        r27 = r24;
        goto L44
    L11:
        if (r12.e != null) goto L13;
        r12.e = new b0();
    L13:
        g(r12.e, r10.getAttributeName(r5), r10.getAttributeValue(r5).trim());
    L89:
        r5 = r5 + 1;
        goto L3
    }

    public static Float q(String r5) {
        int r10 = r5.length();     // Catch: SVGParseException -> L14
        if (r10 == 0) goto L13;
        float r11 = a(r10, r5);     // Catch: SVGParseException -> L14
        float r12 = 0.0f;
        if (r11 >= 0.0f) goto L7;
    L6:
        r11 = r12;
    L11:
        return Float.valueOf(r11);
    L7:
        r12 = 1.0f;
        if (r11 <= 1.0f) goto L11;
    L13:
        throw new SVGParseException("Invalid float value (empty string)");     // Catch: SVGParseException -> L14
    L14:
        return null;
    }

    public static i0 r(String r10) {
        boolean r5 = r10.startsWith("url(");
        i0 r11 = h.f9812c;
        i r12 = i.f9818a;
        if (r5 == false) goto L21;
        int r13 = r10.indexOf(")");
        if (r13 == (-1)) goto L19;
        String r14 = r10.substring(4, r13).trim();
        String r15 = r10.substring(r13 + 1).trim();
        if (r15.length() > 0) goto L9;
    L14:
        r11 = null;
    L17:
        return new t(r14, r11);
    L9:
        if (r15.equals("none") == true) goto L17;
        if (r15.equals("currentColor") == false) goto L32;
        r11 = r12;
        goto L17
    L32:
        r11 = b(r15);     // Catch: SVGParseException -> L29
    L19:
        return new t(r10.substring(4).trim(), null);
    L21:
        if (r10.equals("none") == false) goto L23;
        return r11;
    L23:
        if (r10.equals("currentColor") == false) goto L30;
        return r12;
    L30:
        return b(r10);
    L26:
        return null;
    }

    public static Matrix s(String r19) {
        Matrix r10 = new Matrix();
        r0 r11 = new r0(r19);
        r11.o();
    L4:
        if (r11.i() == true) goto L118;
        String r12 = null;
        if (r11.i() == true) goto L26;
        int r13 = r11.f9864a;
        String r14 = (String) r11.f9866c;
        int r15 = r14.charAt(r13);
    L10:
        if (r15 < 97) goto L14;
        if (r15 > 122) goto L14;
    L17:
        r15 = r11.b();
    L14:
        if (r15 < 65) goto L18;
        if (r15 <= 90) goto L17;
    L18:
        int r16 = r11.f9864a;
    L20:
        if (r0.h(r15) == false) goto L23;
        r15 = r11.b();
        goto L20
    L23:
        if (r15 != 40) goto L25;
        r11.f9864a++;
        r12 = r14.substring(r13, r16);
        goto L26
    L25:
        r11.f9864a = r13;
    L26:
        if (r12 == null) goto L117;
        byte r17 = -1;
        switch(r12.hashCode()) {
            case -1081239615: goto L51;
            case -925180581: goto L47;
            case 109250890: goto L43;
            case 109493390: goto L39;
            case 109493391: goto L35;
            case 1052832078: goto L31;
            default: goto L54;
        };
    L54:
        switch(r17) {
            case 0: goto L105;
            case 1: goto L91;
            case 2: goto L81;
            case 3: goto L74;
            case 4: goto L67;
            case 5: goto L57;
            default: goto L56;
        };
    L57:
        r11.o();
        float r18 = r11.j();
        float r110 = r11.m();
        r11.o();
        if (Float.isNaN(r18) == true) goto L66;
        if (r11.g(')') == false) goto L66;
        if (Float.isNaN(r110) == false) goto L64;
        r10.preTranslate(r18, 0.0f);
    L111:
        if (r11.i() == true) goto L118;
        r11.n();
        goto L4
    L64:
        r10.preTranslate(r18, r110);
    L66:
        throw new SVGParseException("Invalid transform list: ".concat(r19));
    L67:
        r11.o();
        float r111 = r11.j();
        r11.o();
        if (Float.isNaN(r111) == true) goto L73;
        if (r11.g(')') == false) goto L73;
        r10.preSkew(0.0f, (float) Math.tan(Math.toRadians(r111)));
    L73:
        throw new SVGParseException("Invalid transform list: ".concat(r19));
    L74:
        r11.o();
        float r112 = r11.j();
        r11.o();
        if (Float.isNaN(r112) == true) goto L80;
        if (r11.g(')') == false) goto L80;
        r10.preSkew((float) Math.tan(Math.toRadians(r112)), 0.0f);
    L80:
        throw new SVGParseException("Invalid transform list: ".concat(r19));
    L81:
        r11.o();
        float r113 = r11.j();
        float r114 = r11.m();
        r11.o();
        if (Float.isNaN(r113) == true) goto L90;
        if (r11.g(')') == false) goto L90;
        if (Float.isNaN(r114) == false) goto L88;
        r10.preScale(r113, r113);
        goto L111
    L88:
        r10.preScale(r113, r114);
    L90:
        throw new SVGParseException("Invalid transform list: ".concat(r19));
    L91:
        r11.o();
        float r115 = r11.j();
        float r116 = r11.m();
        float r117 = r11.m();
        r11.o();
        if (Float.isNaN(r115) == true) goto L104;
        if (r11.g(')') == false) goto L104;
        if (Float.isNaN(r116) == false) goto L99;
        r10.preRotate(r115);
        goto L111
    L99:
        if (Float.isNaN(r117) == true) goto L102;
        r10.preRotate(r115, r116, r117);
        goto L111
    L102:
        throw new SVGParseException("Invalid transform list: ".concat(r19));
    L104:
        throw new SVGParseException("Invalid transform list: ".concat(r19));
    L105:
        r11.o();
        float r118 = r11.j();
        r11.n();
        float r119 = r11.j();
        r11.n();
        float r120 = r11.j();
        r11.n();
        float r121 = r11.j();
        r11.n();
        float r122 = r11.j();
        r11.n();
        float r123 = r11.j();
        r11.o();
        if (Float.isNaN(r123) == true) goto L115;
        if (r11.g(')') == false) goto L115;
        Matrix r124 = new Matrix();
        r124.setValues(new float[]{r118, r120, r122, r119, r121, r123, 0.0f, 0.0f, 1.0f});
        r10.preConcat(r124);
    L115:
        throw new SVGParseException("Invalid transform list: ".concat(r19));
    L56:
        throw new SVGParseException(com.lynx.tasm.utils.g.d("Invalid transform list fn: ", r12, ")"));
    L31:
        if (r12.equals(SVGRenderEngine.TRANSLATE) == false) goto L54;
        r17 = 5;
        goto L54
    L35:
        if (r12.equals("skewY") == false) goto L54;
        r17 = 4;
        goto L54
    L39:
        if (r12.equals("skewX") == false) goto L54;
        r17 = 3;
        goto L54
    L43:
        if (r12.equals("scale") == false) goto L54;
        r17 = 2;
        goto L54
    L47:
        if (r12.equals("rotate") == false) goto L54;
        r17 = 1;
        goto L54
    L51:
        if (r12.equals("matrix") == false) goto L54;
        r17 = 0;
        goto L54
    L117:
        throw new SVGParseException("Bad transform function encountered in transform list: ".concat(r19));
    L118:
        return r10;
    }

    public final void k(InputStream r10) {
        XmlPullParser r5 = Xml.newPullParser();     // Catch: Exception -> L13 XmlPullParserException -> L15
        s0 r11 = new s0(r5);     // Catch: Exception -> L13 XmlPullParserException -> L15
        r5.setFeature("http://xmlpull.org/v1/doc/features.html#process-docdecl", true);     // Catch: Exception -> L13 XmlPullParserException -> L15
        r5.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", true);     // Catch: Exception -> L13 XmlPullParserException -> L15
        r5.setInput(r10, "utf-8");     // Catch: Exception -> L13 XmlPullParserException -> L15
        int r12 = r5.getEventType();     // Catch: Exception -> L13 XmlPullParserException -> L15
    L3:
        if (r12 == 1) goto L25;
        if (r12 != 0) goto L6;
        this.f9870a = new n0();     // Catch: Exception -> L13 XmlPullParserException -> L15
    L23:
        r12 = r5.nextToken();     // Catch: Exception -> L13 XmlPullParserException -> L15
    L6:
        if (r12 != 2) goto L8;
        String r13 = r5.getName();     // Catch: Exception -> L13 XmlPullParserException -> L15
        if (r5.getPrefix() == null) goto L21;
        r13 = r5.getPrefix() + ':' + r13;     // Catch: Exception -> L13 XmlPullParserException -> L15
    L21:
        m(r5.getNamespace(), r5.getName(), r13, r11);     // Catch: Exception -> L13 XmlPullParserException -> L15
        goto L23
    L8:
        if (r12 != 3) goto L23;
        String r14 = r5.getName();     // Catch: Exception -> L13 XmlPullParserException -> L15
        if (r5.getPrefix() == null) goto L17;
        r14 = r5.getPrefix() + ':' + r14;     // Catch: Exception -> L13 XmlPullParserException -> L15
    L17:
        l(r5.getNamespace(), r5.getName(), r14);     // Catch: Exception -> L13 XmlPullParserException -> L15
        goto L23
    L25:
        return;
    L15:
        e = move-exception;
        throw new SVGParseException("XML parser problem", e);
    L13:
        e = move-exception;
        throw new SVGParseException("unexpected error", e);
    }

    public final void l(String r5, String r10, String r11) {
        if (this.f9872c == false) goto L9;
        int r12 = this.d - 1;
        this.d = r12;
        if (r12 != 0) goto L38;
        this.f9872c = false;
        return;
    L38:
        return;
    L9:
        if ("http://www.w3.org/2000/svg".equals(r5) == true) goto L14;
        if ("".equals(r5) == true) goto L14;
        return;
    L14:
        if (r10.length() > 0) goto L17;
        r10 = r11;
    L17:
        SVGParser$SVGElem r13 = (SVGParser$SVGElem) SVGParser$SVGElem.f9764b.get(r10);
        if (r13 != null) goto L21;
        r13 = SVGParser$SVGElem.f9763a;
    L21:
        int r14 = r13.ordinal();
        if (r14 != 0) goto L24;
    L39:
        Object r15 = this.f9871b;
        if (r15 == null) goto L44;
        this.f9871b = ((g0) r15).f9809b;
        return;
    L44:
        throw new SVGParseException(ai.j0.k("Unbalanced end element </", r10, "> found"));
    L24:
        if (r14 == 8) goto L39;
        if (r14 == 10) goto L39;
        if (r14 == 13) goto L39;
        if (r14 == 2) goto L39;
        if (r14 == 3) goto L39;
        if (r14 == 5) goto L39;
        if (r14 == 6) goto L39;
        switch(r14) {
            case 15: goto L39;
            case 16: goto L39;
            case 17: goto L39;
            default: goto L45;
        };
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v13, types: [byte[], java.io.Serializable] */
    public final void m(String r28, String r29, String r30, s0 r31) {
        t0 r5 = this;
        boolean r10 = true;
        if (r5.f9872c == false) goto L7;
        r5.d++;
        return;
    L7:
        if ("http://www.w3.org/2000/svg".equals(r28) == true) goto L12;
        if ("".equals(r28) == true) goto L12;
        return;
    L12:
        if (r29.length() <= 0) goto L14;
        String r11 = r29;
    L15:
        SVGParser$SVGElem r12 = (SVGParser$SVGElem) SVGParser$SVGElem.f9764b.get(r11);
        if (r12 != null) goto L19;
        r12 = SVGParser$SVGElem.f9763a;
    L19:
        int r13 = r12.ordinal();
        int r14 = 0;
        XmlPullParser r15 = r31.f9867a;
        switch(r13) {
            case 0: goto L533;
            case 1: goto L509;
            case 2: goto L488;
            case 3: goto L482;
            case 4: goto L452;
            case 5: goto L446;
            case 6: goto L412;
            case 7: goto L395;
            case 8: goto L378;
            case 9: goto L225;
            case 10: goto L180;
            case 11: goto L174;
            case 12: goto L168;
            case 13: goto L138;
            case 14: goto L100;
            case 15: goto L94;
            case 16: goto L54;
            case 17: goto L23;
            default: goto L21;
        };
    L21:
        r5.f9872c = true;
        r5.d = 1;
        return;
    L23:
        n("<use>", new Object[0]);
        if (r5.f9871b == null) goto L53;
        m0 r16 = new m0();
        r16.f9808a = r5.f9870a;
        r16.f9809b = r5.f9871b;
        h(r16, r31);
        p(r16, r31);
        e(r16, r31);
    L27:
        if (r14 >= r15.getAttributeCount()) goto L50;
        String r17 = r15.getAttributeValue(r14).trim();
        int r18 = SVGParser$SVGAttr.a(r15.getAttributeName(r14)).ordinal();
        if (r18 == 19) goto L45;
        if (r18 == 20) goto L41;
        switch(r18) {
            case 57: goto L35;
            case 58: goto L34;
            case 59: goto L33;
            default: goto L47;
        };
    L33:
        r16.f9837l = o(r17);
        goto L47
    L34:
        r16.f9836k = o(r17);
        goto L47
    L35:
        q r19 = o(r17);
        r16.f9838m = r19;
        if (r19.c() == false) goto L47;
        throw new SVGParseException("Invalid <use> element. width cannot be negative");
    L47:
        r14 = r14 + 1;
        goto L27
    L41:
        if ("".equals(r15.getAttributeNamespace(r14)) == false) goto L43;
    L44:
        r16.f9835j = r17;
        goto L47
    L43:
        if ("http://www.w3.org/1999/xlink".equals(r15.getAttributeNamespace(r14)) == false) goto L47;
    L45:
        q r20 = o(r17);
        r16.f9839n = r20;
        if (r20.c() == false) goto L47;
        throw new SVGParseException("Invalid <use> element. height cannot be negative");
    L50:
        r5.f9871b.a(r16);
        r5.f9871b = r16;
        return;
    L53:
        throw new SVGParseException("Invalid document. Root element must be <svg>");
    L54:
        n("<stop>", new Object[0]);
        e0 r21 = r5.f9871b;
        if (r21 == null) goto L93;
        if ((r21 instanceof l) == false) goto L91;
        a0 r22 = new a0();
        r22.f9808a = r5.f9870a;
        r22.f9809b = r21;
        h(r22, r31);
        p(r22, r31);
        int r23 = 0;
    L60:
        if (r23 >= r15.getAttributeCount()) goto L88;
        String r24 = r15.getAttributeValue(r23).trim();
        if (SVGParser$SVGAttr.a(r15.getAttributeName(r23)).ordinal() != 22) goto L82;
        if (r24.length() == 0) goto L87;
        int r25 = r24.length();
        if (r24.charAt(r24.length() - 1) != '%') goto L69;
        r25 = r25 - 1;
        Object[] r26 = true;
    L560:
        float r27 = a(r25, r24);     // Catch: NumberFormatException -> L83
        float r32 = 100.0f;
        if (r26 == false) goto L74;
        r27 = r27 / 100.0f;     // Catch: NumberFormatException -> L83
    L74:
        if (r27 >= 0.0f) goto L77;
        r32 = 0.0f;
    L81:
        r22.g = Float.valueOf(r32);
        goto L82
    L77:
        if (r27 > 100.0f) goto L81;
        r32 = r27;
    L83:
        e = move-exception;
        throw new SVGParseException("Invalid offset value in <stop>: ".concat(r24), e);
    L69:
        r26 = false;
        goto L560
    L87:
        throw new SVGParseException("Invalid offset value in <stop> (empty string)");
    L82:
        r23 = r23 + 1;
        goto L60
    L88:
        r5.f9871b.a(r22);
        r5.f9871b = r22;
        return;
    L91:
        throw new SVGParseException("Invalid document. <stop> elements are only valid inside <linearGradient> or <radialGradient> elements.");
    L93:
        throw new SVGParseException("Invalid document. Root element must be <svg>");
    L94:
        n("<solidColor>", new Object[0]);
        e0 r33 = r5.f9871b;
        if (r33 == null) goto L99;
        z r34 = new z();
        r34.f9808a = r5.f9870a;
        r34.f9809b = r33;
        h(r34, r31);
        p(r34, r31);
        r5.f9871b.a(r34);
        r5.f9871b = r34;
        return;
    L99:
        throw new SVGParseException("Invalid document. Root element must be <svg>");
    L100:
        n("<rect>", new Object[0]);
        e0 r35 = r5.f9871b;
        if (r35 == null) goto L137;
        y r36 = new y();
        r36.f9808a = r5.f9870a;
        r36.f9809b = r35;
        h(r36, r31);
        p(r36, r31);
        e(r36, r31);
    L104:
        if (r14 >= r15.getAttributeCount()) goto L134;
        String r37 = r15.getAttributeValue(r14).trim();
        int r38 = SVGParser$SVGAttr.a(r15.getAttributeName(r14)).ordinal();
        if (r38 == 19) goto L129;
        if (r38 != 35) goto L109;
        q r39 = o(r37);
        r36.f9887m = r39;
        if (r39.c() == false) goto L131;
        throw new SVGParseException("Invalid <rect> element. rx cannot be negative");
    L131:
        r14 = r14 + 1;
        goto L104
    L109:
        if (r38 == 36) goto L119;
        switch(r38) {
            case 57: goto L114;
            case 58: goto L113;
            case 59: goto L112;
            default: goto L131;
        };
    L112:
        r36.f9884j = o(r37);
        goto L131
    L113:
        r36.f9883i = o(r37);
        goto L131
    L114:
        q r40 = o(r37);
        r36.f9885k = r40;
        if (r40.c() == false) goto L131;
        throw new SVGParseException("Invalid <rect> element. width cannot be negative");
    L119:
        q r41 = o(r37);
        r36.f9888n = r41;
        if (r41.c() == false) goto L131;
        throw new SVGParseException("Invalid <rect> element. ry cannot be negative");
    L129:
        q r42 = o(r37);
        r36.f9886l = r42;
        if (r42.c() == false) goto L131;
        throw new SVGParseException("Invalid <rect> element. height cannot be negative");
    L134:
        r5.f9871b.a(r36);
        return;
    L137:
        throw new SVGParseException("Invalid document. Root element must be <svg>");
    L138:
        n("<radialGradient>", new Object[0]);
        if (r5.f9871b == null) goto L167;
        k0 r43 = new k0();
        r43.f9808a = r5.f9870a;
        r43.f9809b = r5.f9871b;
        h(r43, r31);
        p(r43, r31);
        d(r43, r31);
    L142:
        if (r14 >= r15.getAttributeCount()) goto L164;
        String r44 = r15.getAttributeValue(r14).trim();
        int r45 = SVGParser$SVGAttr.a(r15.getAttributeName(r14)).ordinal();
        if (r45 != 5) goto L146;
        r43.f9824l = o(r44);
    L163:
        r14 = r14 + 1;
        goto L142
    L146:
        if (r45 != 6) goto L148;
        r43.f9825m = o(r44);
        goto L163
    L148:
        if (r45 != 10) goto L150;
        r43.f9827o = o(r44);
        goto L163
    L150:
        if (r45 != 11) goto L152;
        r43.f9828p = o(r44);
        goto L163
    L152:
        if (r45 != 32) goto L163;
        q r46 = o(r44);
        r43.f9826n = r46;
        if (r46.c() == false) goto L163;
        throw new SVGParseException("Invalid <radialGradient> element. r cannot be negative");
    L164:
        r5.f9871b.a(r43);
        r5.f9871b = r43;
        return;
    L167:
        throw new SVGParseException("Invalid document. Root element must be <svg>");
    L168:
        n("<polyline>", new Object[0]);
        e0 r47 = r5.f9871b;
        if (r47 == null) goto L173;
        w r48 = new w();
        r48.f9808a = r5.f9870a;
        r48.f9809b = r47;
        h(r48, r31);
        p(r48, r31);
        e(r48, r31);
        f(r48, r31, SVGRenderEngine.POLYLINE);
        r5.f9871b.a(r48);
        return;
    L173:
        throw new SVGParseException("Invalid document. Root element must be <svg>");
    L174:
        n("<polygon>", new Object[0]);
        e0 r49 = r5.f9871b;
        if (r49 == null) goto L179;
        x r50 = new x();
        r50.f9808a = r5.f9870a;
        r50.f9809b = r49;
        h(r50, r31);
        p(r50, r31);
        e(r50, r31);
        f(r50, r31, SVGRenderEngine.POLYGON);
        r5.f9871b.a(r50);
        return;
    L179:
        throw new SVGParseException("Invalid document. Root element must be <svg>");
    L180:
        n("<pattern>", new Object[0]);
        if (r5.f9871b == null) goto L224;
        v r51 = new v();
        r51.f9808a = r5.f9870a;
        r51.f9809b = r5.f9871b;
        h(r51, r31);
        p(r51, r31);
        j(r51, r31);
    L184:
        if (r14 >= r15.getAttributeCount()) goto L221;
        String r52 = r15.getAttributeValue(r14).trim();
        int r53 = SVGParser$SVGAttr.a(r15.getAttributeName(r14)).ordinal();
        if (r53 == 19) goto L216;
        if (r53 == 20) goto L212;
        switch(r53) {
            case 27: goto L206;
            case 28: goto L204;
            case 29: goto L199;
            default: goto L189;
        };
    L189:
        switch(r53) {
            case 57: goto L193;
            case 58: goto L192;
            case 59: goto L191;
            default: goto L218;
        };
    L191:
        r51.f9878o = o(r52);
        goto L218
    L192:
        r51.f9877n = o(r52);
        goto L218
    L193:
        q r54 = o(r52);
        r51.f9879p = r54;
        if (r54.c() == false) goto L218;
        throw new SVGParseException("Invalid <pattern> element. width cannot be negative");
    L218:
        r14 = r14 + 1;
        goto L184
    L204:
        r51.f9876m = s(r52);
        goto L218
    L199:
        if ("objectBoundingBox".equals(r52) == false) goto L202;
        r51.f9874k = Boolean.FALSE;
        goto L218
    L202:
        if ("userSpaceOnUse".equals(r52) == false) goto L218;
        r51.f9874k = Boolean.TRUE;
        goto L218
    L206:
        if ("objectBoundingBox".equals(r52) == false) goto L209;
        r51.f9875l = Boolean.FALSE;
        goto L218
    L209:
        if ("userSpaceOnUse".equals(r52) == false) goto L218;
        r51.f9875l = Boolean.TRUE;
        goto L218
    L212:
        if ("".equals(r15.getAttributeNamespace(r14)) == false) goto L214;
    L215:
        r51.f9881r = r52;
        goto L218
    L214:
        if ("http://www.w3.org/1999/xlink".equals(r15.getAttributeNamespace(r14)) == false) goto L218;
    L216:
        q r55 = o(r52);
        r51.f9880q = r55;
        if (r55.c() == false) goto L218;
        throw new SVGParseException("Invalid <pattern> element. height cannot be negative");
    L221:
        r5.f9871b.a(r51);
        r5.f9871b = r51;
        return;
    L224:
        throw new SVGParseException("Invalid document. Root element must be <svg>");
    L225:
        n("<path>", new Object[0]);
        e0 r56 = r5.f9871b;
        if (r56 == null) goto L377;
        u r57 = new u();
        r57.f9808a = r5.f9870a;
        r57.f9809b = r56;
        h(r57, r31);
        p(r57, r31);
        e(r57, r31);
        int r58 = 0;
    L229:
        if (r58 >= r15.getAttributeCount()) goto L374;
        String r59 = r15.getAttributeValue(r58).trim();
        int r60 = SVGParser$SVGAttr.a(r15.getAttributeName(r58)).ordinal();
        if (r60 != 12) goto L233;
        r0 r61 = new r0(r59);
        r0 r62 = new r0();
        r62.f9864a = r14;
        r62.f9865b = r14;
        byte r110 = 8;
        r62.f9866c = new byte[8];
        r62.d = new float[16];
        if (r61.i() == false) goto L247;
    L246:
        r58 = r58;
        r57 = r57;
        boolean r210 = r10;
        r15 = r15;
    L372:
        r57.f9873i = r62;
    L373:
        r58 = r58 + 1;
        r57 = r57;
        r10 = r210;
        r15 = r15;
        r14 = 0;
        r5 = this;
        goto L229
    L247:
        int r63 = r61.f9864a;
        String r111 = (String) r61.f9866c;
        int r112 = r61.f9865b;
        if (r63 != r112) goto L250;
        Integer r64 = null;
    L251:
        int r65 = r64.intValue();
        if (r65 == 77) goto L255;
        if (r65 != 109) goto L246;
    L255:
        int r66 = r65;
        float r67 = 0.0f;
        float r68 = 0.0f;
        float r69 = 0.0f;
        float r113 = 0.0f;
        float r114 = 0.0f;
        float r211 = 0.0f;
    L256:
        r61.o();
        switch(r66) {
            case 65: goto L330;
            case 67: goto L323;
            case 72: goto L315;
            case 76: goto L308;
            case 77: goto L295;
            case 81: goto L285;
            case 83: goto L276;
            case 84: goto L269;
            case 86: goto L262;
            case 90: goto L260;
            case 97: goto L330;
            case 99: goto L323;
            case 104: goto L315;
            case 108: goto L308;
            case 109: goto L295;
            case 113: goto L285;
            case 115: goto L276;
            case 116: goto L269;
            case 118: goto L262;
            case 122: goto L260;
            default: goto L258;
        };
    L260:
        r62.d(r110);
        r68 = r114;
        r69 = r68;
        r67 = r211;
        r113 = r67;
    L261:
        r210 = true;
        r111 = r111;
    L351:
        r61.n();
        if (r61.i() == true) goto L353;
        int r70 = r61.f9864a;
        if (r70 == r112) goto L370;
        char r71 = r111.charAt(r70);
        if (r71 < 'a') goto L362;
        if (r71 > 'z') goto L362;
    L365:
        int r72 = r61.f9864a;
        if (r72 != r112) goto L368;
        Integer r73 = null;
    L369:
        r66 = r73.intValue();
        goto L370
    L368:
        r61.f9864a = r72 + 1;
        r73 = Integer.valueOf(r111.charAt(r72));
    L362:
        if (r71 < 'A') goto L370;
        if (r71 <= 'Z') goto L365;
    L370:
        r112 = r112;
        r111 = r111;
        r58 = r58;
        r57 = r57;
        r15 = r15;
        r110 = 8;
    L353:
        r57 = r57;
        goto L372
    L262:
        float r115 = r61.j();
        if (Float.isNaN(r115) == true) goto L264;
        if (r66 != 118) goto L268;
        r115 = r115 + r67;
    L268:
        r67 = r115;
        r62.d((byte) 1);
        r62.f(2);
        float[] r116 = (float[]) r62.d;
        int r117 = r62.f9865b;
        int r118 = r117 + 1;
        r62.f9865b = r118;
        r116[r117] = r68;
        r62.f9865b = r117 + 2;
        r116[r118] = r67;
        r113 = r67;
        goto L261
    L264:
        Log.e("SVGParser", "Bad path coords for " + ((char) r66) + " path segment");
        goto L258
    L269:
        float r119 = (r68 * 2.0f) - r69;
        float r212 = (2.0f * r67) - r113;
        float r74 = r61.j();
        float r120 = r61.a(r74);
        if (Float.isNaN(r120) == true) goto L271;
        if (r66 != 116) goto L275;
        r74 = r74 + r68;
        r120 = r120 + r67;
    L275:
        r62.d((byte) 3);
        r62.f(4);
        float[] r75 = (float[]) r62.d;
        int r76 = r62.f9865b;
        int r77 = r76 + 1;
        r62.f9865b = r77;
        r75[r76] = r119;
        int r121 = r76 + 2;
        r62.f9865b = r121;
        r75[r77] = r212;
        int r78 = r76 + 3;
        r62.f9865b = r78;
        r75[r121] = r74;
        r62.f9865b = r76 + 4;
        r75[r78] = r120;
        r68 = r74;
        r69 = r119;
        r15 = r15;
        r67 = r120;
        r113 = r212;
        r58 = r58;
        int r122 = r66;
    L293:
        r66 = r122;
    L294:
        r210 = true;
        goto L351
    L271:
        Log.e("SVGParser", "Bad path coords for " + ((char) r66) + " path segment");
        goto L258
    L276:
        float r79 = (r68 * 2.0f) - r69;
        float r123 = (2.0f * r67) - r113;
        int r213 = r112;
        float r124 = r61.j();
        String r214 = r111;
        float r125 = r61.a(r124);
        r15 = r15;
        float r126 = r61.a(r125);
        float r127 = r61.a(r126);
        if (Float.isNaN(r127) == true) goto L278;
        if (r66 != 115) goto L283;
        r126 = r126 + r68;
        r127 = r127 + r67;
        r124 = r124 + r68;
        r125 = r125 + r67;
    L283:
        float r80 = r124;
        float r128 = r125;
        r112 = r213;
        float r129 = r126;
        r58 = r58;
        float r215 = r126;
        r111 = r214;
        r62.e(r79, r123, r80, r128, r129, r127);
        r68 = r215;
        r69 = r80;
        r66 = r66;
        r67 = r127;
        r210 = true;
    L284:
        r113 = r128;
        goto L351
    L278:
        Log.e("SVGParser", "Bad path coords for " + ((char) r66) + " path segment");
        r58 = r58;
    L259:
        r210 = true;
        goto L372
    L285:
        r58 = r58;
        r122 = r66;
        r15 = r15;
        r69 = r61.j();
        float r81 = r61.a(r69);
        float r130 = r61.a(r81);
        float r131 = r61.a(r130);
        if (Float.isNaN(r131) == true) goto L287;
        if (r122 != 113) goto L291;
        r130 = r130 + r68;
        r131 = r131 + r67;
        r69 = r69 + r68;
        r81 = r81 + r67;
    L291:
        r62.d((byte) 3);
        r62.f(4);
        float[] r82 = (float[]) r62.d;
        int r83 = r62.f9865b;
        int r84 = r83 + 1;
        r62.f9865b = r84;
        r82[r83] = r69;
        int r132 = r83 + 2;
        r62.f9865b = r132;
        r82[r84] = r81;
        int r85 = r83 + 3;
        r62.f9865b = r85;
        r82[r132] = r130;
        r62.f9865b = r83 + 4;
        r82[r85] = r131;
        r113 = r81;
        r68 = r130;
        r67 = r131;
        goto L293
    L287:
        Log.e("SVGParser", "Bad path coords for " + ((char) r122) + " path segment");
        goto L259
    L295:
        r58 = r58;
        int r133 = r66;
        r112 = r112;
        r15 = r15;
        r111 = r111;
        float r86 = r61.j();
        float r87 = r61.a(r86);
        if (Float.isNaN(r87) == true) goto L297;
        if (r133 == 109) goto L300;
    L303:
        r68 = r86;
        r67 = r87;
        r62.d((byte) 0);
        r62.f(2);
        float[] r88 = (float[]) r62.d;
        int r89 = r62.f9865b;
        int r134 = r89 + 1;
        r62.f9865b = r134;
        r88[r89] = r68;
        r62.f9865b = r89 + 2;
        r88[r134] = r67;
        if (r133 != 109) goto L306;
        int r135 = 108;
    L307:
        r57 = r57;
        r113 = r67;
        r211 = r113;
        r69 = r68;
        r114 = r69;
        r66 = r135;
        goto L294
    L306:
        r135 = 76;
        goto L307
    L300:
        if (r62.f9864a == 0) goto L303;
        r86 = r86 + r68;
        r87 = r87 + r67;
        goto L303
    L297:
        Log.e("SVGParser", "Bad path coords for " + ((char) r133) + " path segment");
        goto L259
    L308:
        r58 = r58;
        r122 = r66;
        r112 = r112;
        r15 = r15;
        r111 = r111;
        float r90 = r61.j();
        float r91 = r61.a(r90);
        if (Float.isNaN(r91) == true) goto L310;
        if (r122 != 108) goto L314;
        r90 = r90 + r68;
        r91 = r91 + r67;
    L314:
        r68 = r90;
        r67 = r91;
        r62.d((byte) 1);
        r62.f(2);
        float[] r92 = (float[]) r62.d;
        int r93 = r62.f9865b;
        int r136 = r93 + 1;
        r62.f9865b = r136;
        r92[r93] = r68;
        r62.f9865b = r93 + 2;
        r92[r136] = r67;
        r113 = r67;
        r69 = r68;
        goto L293
    L310:
        Log.e("SVGParser", "Bad path coords for " + ((char) r122) + " path segment");
        goto L259
    L315:
        r58 = r58;
        int r137 = r66;
        r15 = r15;
        float r94 = r61.j();
        if (Float.isNaN(r94) == true) goto L317;
        if (r137 != 104) goto L321;
        r94 = r94 + r68;
    L321:
        r68 = r94;
        r62.d((byte) 1);
        r62.f(2);
        float[] r95 = (float[]) r62.d;
        int r96 = r62.f9865b;
        int r138 = r96 + 1;
        r62.f9865b = r138;
        r95[r96] = r68;
        r62.f9865b = r96 + 2;
        r95[r138] = r67;
        r57 = r57;
        r69 = r68;
        r210 = true;
    L322:
        r66 = r137;
        goto L351
    L317:
        Log.e("SVGParser", "Bad path coords for " + ((char) r137) + " path segment");
        goto L259
    L323:
        r58 = r58;
        int r139 = r66;
        r112 = r112;
        r15 = r15;
        r111 = r111;
        float r97 = r61.j();
        float r98 = r61.a(r97);
        float r140 = r61.a(r98);
        float r99 = r61.a(r140);
        float r141 = r61.a(r99);
        float r142 = r61.a(r141);
        if (Float.isNaN(r142) == true) goto L325;
        if (r139 != 99) goto L329;
        r141 = r141 + r68;
        r142 = r142 + r67;
        r97 = r97 + r68;
        r98 = r98 + r67;
        r140 = r140 + r68;
        r99 = r99 + r67;
    L329:
        r128 = r99;
        float r100 = r140;
        float r101 = r141;
        r210 = true;
        r62.e(r97, r98, r100, r128, r101, r142);
        r68 = r101;
        r69 = r100;
        r66 = r139;
        r67 = r142;
        goto L284
    L325:
        Log.e("SVGParser", "Bad path coords for " + ((char) r139) + " path segment");
        goto L259
    L330:
        r58 = r58;
        r137 = r66;
        r15 = r15;
        r210 = true;
        float r102 = r61.j();
        float r103 = r61.a(r102);
        float r104 = r61.a(r103);
        Boolean r143 = r61.c(Float.valueOf(r104));
        Boolean r144 = r61.c(r143);
        if (r144 != null) goto L334;
        float r145 = Float.NaN;
    L333:
        r57 = r57;
        float r105 = r145;
        float r146 = r61.a(r105);
        if (Float.isNaN(r146) == true) goto L371;
        if (r102 < 0.0f) goto L371;
        if (r103 < 0.0f) goto L371;
        if (r137 != 97) goto L345;
        r105 = r105 + r68;
        r146 = r146 + r67;
    L345:
        r68 = r105;
        r67 = r146;
        boolean r106 = r143.booleanValue();
        boolean r107 = r144.booleanValue();
        if (r106 == false) goto L349;
        int r108 = 2;
    L350:
        r62.d((byte) ((r108 | 4) | (r107 ? 1 : 0)));
        r62.f(5);
        float[] r109 = (float[]) r62.d;
        int r147 = r62.f9865b;
        int r148 = r147 + 1;
        r62.f9865b = r148;
        r109[r147] = r102;
        int r149 = r147 + 2;
        r62.f9865b = r149;
        r109[r148] = r103;
        int r150 = r147 + 3;
        r62.f9865b = r150;
        r109[r149] = r104;
        int r151 = r147 + 4;
        r62.f9865b = r151;
        r109[r150] = r68;
        r62.f9865b = r147 + 5;
        r109[r151] = r67;
        r113 = r67;
        r69 = r68;
        goto L322
    L349:
        r108 = 0;
    L371:
        Log.e("SVGParser", "Bad path coords for " + ((char) r137) + " path segment");
        goto L353
    L334:
        r61.n();
        r145 = r61.j();
    L258:
        r58 = r58;
        r15 = r15;
        goto L259
    L250:
        r61.f9864a = r63 + 1;
        r64 = Integer.valueOf(r111.charAt(r63));
        goto L251
    L233:
        if (r60 == 26) goto L235;
    L234:
        r58 = r58;
        r57 = r57;
        r210 = r10;
        r15 = r15;
        goto L373
    L235:
        int r152 = r59.length();
        if (r152 == 0) goto L243;
        if (a(r152, r59) >= 0.0f) goto L234;
        throw new SVGParseException("Invalid <path> element. pathLength cannot be negative");
    L243:
        throw new SVGParseException("Invalid float value (empty string)");
    L374:
        r5.f9871b.a(r57);
        return;
    L377:
        throw new SVGParseException("Invalid document. Root element must be <svg>");
    L378:
        XmlPullParser r216 = r15;
        n("<linearGradient>", new Object[0]);
        if (r5.f9871b == null) goto L394;
        h0 r153 = new h0();
        r153.f9808a = r5.f9870a;
        r153.f9809b = r5.f9871b;
        h(r153, r31);
        p(r153, r31);
        d(r153, r31);
        int r154 = 0;
    L382:
        if (r154 >= r216.getAttributeCount()) goto L391;
        XmlPullParser r155 = r216;
        String r156 = r155.getAttributeValue(r154).trim();
        switch(SVGParser$SVGAttr.a(r155.getAttributeName(r154)).ordinal()) {
            case 60: goto L389;
            case 61: goto L388;
            case 62: goto L387;
            case 63: goto L386;
            default: goto L390;
        };
    L386:
        r153.f9817o = o(r156);
        goto L390
    L387:
        r153.f9816n = o(r156);
        goto L390
    L388:
        r153.f9815m = o(r156);
        goto L390
    L389:
        r153.f9814l = o(r156);
    L390:
        r154 = r154 + 1;
        r216 = r155;
        goto L382
    L391:
        r5.f9871b.a(r153);
        r5.f9871b = r153;
        return;
    L394:
        throw new SVGParseException("Invalid document. Root element must be <svg>");
    L395:
        n("<line>", new Object[0]);
        e0 r157 = r5.f9871b;
        if (r157 == null) goto L411;
        r r158 = new r();
        r158.f9808a = r5.f9870a;
        r158.f9809b = r157;
        h(r158, r31);
        p(r158, r31);
        e(r158, r31);
        int r159 = 0;
    L399:
        if (r159 >= r15.getAttributeCount()) goto L408;
        String r160 = r15.getAttributeValue(r159).trim();
        switch(SVGParser$SVGAttr.a(r15.getAttributeName(r159)).ordinal()) {
            case 60: goto L406;
            case 61: goto L405;
            case 62: goto L404;
            case 63: goto L403;
            default: goto L407;
        };
    L403:
        r158.f9863l = o(r160);
        goto L407
    L404:
        r158.f9862k = o(r160);
        goto L407
    L405:
        r158.f9861j = o(r160);
        goto L407
    L406:
        r158.f9860i = o(r160);
    L407:
        r159 = r159 + 1;
        goto L399
    L408:
        r5.f9871b.a(r158);
        return;
    L411:
        throw new SVGParseException("Invalid document. Root element must be <svg>");
    L412:
        n("<image>", new Object[0]);
        if (r5.f9871b == null) goto L445;
        p r161 = new p();
        r161.f9808a = r5.f9870a;
        r161.f9809b = r5.f9871b;
        h(r161, r31);
        p(r161, r31);
        e(r161, r31);
        int r162 = 0;
    L416:
        if (r162 >= r15.getAttributeCount()) goto L442;
        String r163 = r15.getAttributeValue(r162).trim();
        int r164 = SVGParser$SVGAttr.a(r15.getAttributeName(r162)).ordinal();
        if (r164 == 19) goto L437;
        if (r164 == 20) goto L433;
        if (r164 == 31) goto L431;
        switch(r164) {
            case 57: goto L426;
            case 58: goto L425;
            case 59: goto L424;
            default: goto L439;
        };
    L424:
        r161.f9849l = o(r163);
        goto L439
    L425:
        r161.f9848k = o(r163);
        goto L439
    L426:
        q r165 = o(r163);
        r161.f9850m = r165;
        if (r165.c() == false) goto L439;
        throw new SVGParseException("Invalid <use> element. width cannot be negative");
    L439:
        r162 = r162 + 1;
        goto L416
    L431:
        i(r161, r163);
        goto L439
    L433:
        if ("".equals(r15.getAttributeNamespace(r162)) == false) goto L435;
    L436:
        r161.f9847j = r163;
        goto L439
    L435:
        if ("http://www.w3.org/1999/xlink".equals(r15.getAttributeNamespace(r162)) == false) goto L439;
    L437:
        q r166 = o(r163);
        r161.f9851n = r166;
        if (r166.c() == false) goto L439;
        throw new SVGParseException("Invalid <use> element. height cannot be negative");
    L442:
        r5.f9871b.a(r161);
        r5.f9871b = r161;
        return;
    L445:
        throw new SVGParseException("Invalid document. Root element must be <svg>");
    L446:
        n("<g>", new Object[0]);
        if (r5.f9871b == null) goto L451;
        n r167 = new n();
        r167.f9808a = r5.f9870a;
        r167.f9809b = r5.f9871b;
        h(r167, r31);
        p(r167, r31);
        e(r167, r31);
        r5.f9871b.a(r167);
        r5.f9871b = r167;
        return;
    L451:
        throw new SVGParseException("Invalid document. Root element must be <svg>");
    L452:
        n("<ellipse>", new Object[0]);
        e0 r168 = r5.f9871b;
        if (r168 == null) goto L481;
        k r169 = new k();
        r169.f9808a = r5.f9870a;
        r169.f9809b = r168;
        h(r169, r31);
        p(r169, r31);
        e(r169, r31);
        int r170 = 0;
    L456:
        if (r170 >= r15.getAttributeCount()) goto L478;
        String r171 = r15.getAttributeValue(r170).trim();
        int r172 = SVGParser$SVGAttr.a(r15.getAttributeName(r170)).ordinal();
        if (r172 != 5) goto L460;
        r169.f9820i = o(r171);
    L477:
        r170 = r170 + 1;
        goto L456
    L460:
        if (r172 == 6) goto L475;
        if (r172 != 35) goto L463;
        q r173 = o(r171);
        r169.f9822k = r173;
        if (r173.c() == false) goto L477;
        throw new SVGParseException("Invalid <ellipse> element. rx cannot be negative");
    L463:
        if (r172 != 36) goto L477;
        q r174 = o(r171);
        r169.f9823l = r174;
        if (r174.c() == false) goto L477;
        throw new SVGParseException("Invalid <ellipse> element. ry cannot be negative");
    L475:
        r169.f9821j = o(r171);
        goto L477
    L478:
        r5.f9871b.a(r169);
        return;
    L481:
        throw new SVGParseException("Invalid document. Root element must be <svg>");
    L482:
        n("<defs>", new Object[0]);
        if (r5.f9871b == null) goto L487;
        j r175 = new j();
        r175.f9808a = r5.f9870a;
        r175.f9809b = r5.f9871b;
        h(r175, r31);
        p(r175, r31);
        e(r175, r31);
        r5.f9871b.a(r175);
        r5.f9871b = r175;
        return;
    L487:
        throw new SVGParseException("Invalid document. Root element must be <svg>");
    L488:
        n("<clipPath>", new Object[0]);
        if (r5.f9871b == null) goto L508;
        g r176 = new g();
        r176.f9808a = r5.f9870a;
        r176.f9809b = r5.f9871b;
        h(r176, r31);
        p(r176, r31);
        e(r176, r31);
        int r177 = 0;
    L492:
        if (r177 >= r15.getAttributeCount()) goto L505;
        String r178 = r15.getAttributeValue(r177).trim();
        if (SVGParser$SVGAttr.a(r15.getAttributeName(r177)).ordinal() != 2) goto L502;
        if ("objectBoundingBox".equals(r178) == false) goto L500;
        r176.f9807j = Boolean.FALSE;
        goto L502
    L500:
        if ("userSpaceOnUse".equals(r178) == false) goto L504;
        r176.f9807j = Boolean.TRUE;
        goto L502
    L504:
        throw new SVGParseException("Invalid value for attribute clipPathUnits");
    L502:
        r177 = r177 + 1;
        goto L492
    L505:
        r5.f9871b.a(r176);
        r5.f9871b = r176;
        return;
    L508:
        throw new SVGParseException("Invalid document. Root element must be <svg>");
    L509:
        n("<circle>", new Object[0]);
        e0 r179 = r5.f9871b;
        if (r179 == null) goto L532;
        f r180 = new f();
        r180.f9808a = r5.f9870a;
        r180.f9809b = r179;
        h(r180, r31);
        p(r180, r31);
        e(r180, r31);
        int r181 = 0;
    L513:
        if (r181 >= r15.getAttributeCount()) goto L529;
        String r182 = r15.getAttributeValue(r181).trim();
        int r183 = SVGParser$SVGAttr.a(r15.getAttributeName(r181)).ordinal();
        if (r183 != 5) goto L517;
        r180.f9804i = o(r182);
    L528:
        r181 = r181 + 1;
        goto L513
    L517:
        if (r183 != 6) goto L519;
        r180.f9805j = o(r182);
        goto L528
    L519:
        if (r183 != 32) goto L528;
        q r184 = o(r182);
        r180.f9806k = r184;
        if (r184.c() == false) goto L528;
        throw new SVGParseException("Invalid <circle> element. r cannot be negative");
    L529:
        r5.f9871b.a(r180);
        return;
    L532:
        throw new SVGParseException("Invalid document. Root element must be <svg>");
    L533:
        n("<svg>", new Object[0]);
        c0 r185 = new c0();
        r185.f9808a = r5.f9870a;
        r185.f9809b = r5.f9871b;
        h(r185, r31);
        p(r185, r31);
        j(r185, r31);
        int r186 = 0;
    L535:
        if (r186 >= r31.getLength()) goto L554;
        String r187 = r31.getValue(r186).trim();
        int r188 = SVGParser$SVGAttr.a(r31.getLocalName(r186)).ordinal();
        if (r188 != 19) goto L539;
        q r189 = o(r187);
        r185.f9796n = r189;
        if (r189.c() == false) goto L551;
        throw new SVGParseException("Invalid <svg> element. height cannot be negative");
    L551:
        r186 = r186 + 1;
        goto L535
    L539:
        if (r188 == 55) goto L551;
        switch(r188) {
            case 57: goto L544;
            case 58: goto L543;
            case 59: goto L542;
            default: goto L551;
        };
    L542:
        r185.f9794l = o(r187);
        goto L551
    L543:
        r185.f9793k = o(r187);
        goto L551
    L544:
        q r190 = o(r187);
        r185.f9795m = r190;
        if (r190.c() == false) goto L551;
        throw new SVGParseException("Invalid <svg> element. width cannot be negative");
    L554:
        e0 r191 = r5.f9871b;
        if (r191 != null) goto L557;
        r5.f9870a.f9841a = r185;
    L558:
        r5.f9871b = r185;
        return;
    L557:
        r191.a(r185);
        goto L558
    L14:
        r11 = r30;
        goto L15
    }
}
