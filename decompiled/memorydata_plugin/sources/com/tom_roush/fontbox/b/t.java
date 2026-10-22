package com.tom_roush.fontbox.b;

import android.graphics.Path;
import android.graphics.PointF;
import android.util.Log;
import com.tom_roush.harmony.awt.geom.AffineTransform;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected List<Object> f15943a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected int f15944b;
    private com.tom_roush.fontbox.type1.a c;
    private final String d;
    private final String e;
    private Path f;
    private int g;
    private PointF h;
    private PointF i;
    private boolean j;
    private final List<PointF> k;

    public t(com.tom_roush.fontbox.type1.a r3, String r4, String r5) {
        com.tom_roush.fontbox.type1.a r6 = (com.tom_roush.fontbox.type1.a) ZeusTransformUtils.wrapperContextForParams(r3, com.tom_roush.fontbox.type1.a.class, "com.obric.memorydata.plugin");
        this.f = null;
        this.g = 0;
        this.h = null;
        this.i = null;
        this.j = false;
        this.k = new ArrayList();
        this.c = r6;
        this.d = r4;
        this.e = r5;
        this.i = new PointF(0.0f, 0.0f);
    }

    public t(com.tom_roush.fontbox.type1.a r3, String r4, String r5, List<Object> r6) {
        com.tom_roush.fontbox.type1.a r7 = (com.tom_roush.fontbox.type1.a) ZeusTransformUtils.wrapperContextForParams(r3, com.tom_roush.fontbox.type1.a.class, "com.obric.memorydata.plugin");
        List<Object> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        this(r7, r4, r5);
        this.f15943a = r8;
    }

    static /* synthetic */ List a(t r2, List r3, p r4) {
        return r2.a((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"), r4);
    }

    private List<Number> a(List<Number> r14, p r15) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r14, List.class, "com.obric.memorydata.plugin");
        this.f15944b++;
        String r3 = (String) ZeusTransformUtils.preCheckCast(p.f15937a.get(r15.a()), String.class, "com.obric.memorydata.plugin");
        Number r8 = 0;
        if ("rmoveto".equals(r3) == false) goto L12;
        if (r1.size() >= 2) goto L7;
        return null;
    L7:
        if (this.j == false) goto L10;
        List<PointF> r0 = this.k;
        PointF r4 = new PointF(((Number) ZeusTransformUtils.preCheckCast(r1.get(0), Number.class, "com.obric.memorydata.plugin")).floatValue(), ((Number) ZeusTransformUtils.preCheckCast(r1.get(1), Number.class, "com.obric.memorydata.plugin")).floatValue());
    L9:
        r0.add(r4);
        return null;
    L10:
        b((Number) ZeusTransformUtils.preCheckCast(r1.get(0), Number.class, "com.obric.memorydata.plugin"), (Number) ZeusTransformUtils.preCheckCast(r1.get(1), Number.class, "com.obric.memorydata.plugin"));
        return null;
    L12:
        if ("vmoveto".equals(r3) == false) goto L20;
        if (r1.isEmpty() == false) goto L16;
        return null;
    L16:
        if (this.j == false) goto L18;
        r0 = this.k;
        r4 = new PointF(0.0f, ((Number) ZeusTransformUtils.preCheckCast(r1.get(0), Number.class, "com.obric.memorydata.plugin")).floatValue());
        goto L9
    L18:
        b(r8, (Number) ZeusTransformUtils.preCheckCast(r1.get(0), Number.class, "com.obric.memorydata.plugin"));
        return null;
    L20:
        if ("hmoveto".equals(r3) == false) goto L28;
        if (r1.isEmpty() == false) goto L24;
        return null;
    L24:
        if (this.j == false) goto L26;
        r0 = this.k;
        r4 = new PointF(((Number) ZeusTransformUtils.preCheckCast(r1.get(0), Number.class, "com.obric.memorydata.plugin")).floatValue(), 0.0f);
        goto L9
    L26:
        b((Number) ZeusTransformUtils.preCheckCast(r1.get(0), Number.class, "com.obric.memorydata.plugin"), r8);
        return null;
    L28:
        if ("rlineto".equals(r3) == false) goto L33;
        if (r1.size() < 2) goto L128;
        c((Number) ZeusTransformUtils.preCheckCast(r1.get(0), Number.class, "com.obric.memorydata.plugin"), (Number) ZeusTransformUtils.preCheckCast(r1.get(1), Number.class, "com.obric.memorydata.plugin"));
        return null;
    L128:
        return null;
    L33:
        if ("hlineto".equals(r3) == false) goto L38;
        if (r1.isEmpty() == true) goto L130;
        c((Number) ZeusTransformUtils.preCheckCast(r1.get(0), Number.class, "com.obric.memorydata.plugin"), r8);
        return null;
    L130:
        return null;
    L38:
        if ("vlineto".equals(r3) == false) goto L43;
        if (r1.isEmpty() == true) goto L132;
        c(r8, (Number) ZeusTransformUtils.preCheckCast(r1.get(0), Number.class, "com.obric.memorydata.plugin"));
        return null;
    L132:
        return null;
    L43:
        if ("rrcurveto".equals(r3) == false) goto L50;
        if (r1.size() < 6) goto L134;
        Number r5 = (Number) ZeusTransformUtils.preCheckCast(r1.get(0), Number.class, "com.obric.memorydata.plugin");
        Number r6 = (Number) ZeusTransformUtils.preCheckCast(r1.get(1), Number.class, "com.obric.memorydata.plugin");
        Number r7 = (Number) ZeusTransformUtils.preCheckCast(r1.get(2), Number.class, "com.obric.memorydata.plugin");
        Number r9 = (Number) ZeusTransformUtils.preCheckCast(r1.get(3), Number.class, "com.obric.memorydata.plugin");
        Number r10 = (Number) ZeusTransformUtils.preCheckCast(r1.get(4), Number.class, "com.obric.memorydata.plugin");
        r8 = (Number) ZeusTransformUtils.preCheckCast(r1.get(5), Number.class, "com.obric.memorydata.plugin");
        Number r2 = r5;
        Number r11 = r6;
        Number r12 = r7;
        Number r13 = r9;
        Number r16 = r10;
    L47:
        Number r17 = r8;
    L48:
        this.a(r2, r11, r12, r13, r16, r17);
        return null;
    L134:
        return null;
    L50:
        if ("closepath".equals(r3) == false) goto L53;
        d();
        return null;
    L53:
        if ("sbw".equals(r3) == false) goto L59;
        if (r1.size() < 3) goto L137;
        this.h = new PointF(((Number) ZeusTransformUtils.preCheckCast(r1.get(0), Number.class, "com.obric.memorydata.plugin")).floatValue(), ((Number) ZeusTransformUtils.preCheckCast(r1.get(1), Number.class, "com.obric.memorydata.plugin")).floatValue());
        Object r18 = r1.get(2);
    L57:
        this.g = ((Number) ZeusTransformUtils.preCheckCast(r18, Number.class, "com.obric.memorydata.plugin")).intValue();
        this.i.set(this.h);
        return null;
    L137:
        return null;
    L59:
        if ("hsbw".equals(r3) == false) goto L64;
        if (r1.size() < 2) goto L139;
        this.h = new PointF(((Number) ZeusTransformUtils.preCheckCast(r1.get(0), Number.class, "com.obric.memorydata.plugin")).floatValue(), 0.0f);
        r18 = r1.get(1);
        goto L57
    L139:
        return null;
    L64:
        if ("vhcurveto".equals(r3) == false) goto L69;
        if (r1.size() < 4) goto L140;
        Number r19 = (Number) ZeusTransformUtils.preCheckCast(r1.get(0), Number.class, "com.obric.memorydata.plugin");
        Number r20 = (Number) ZeusTransformUtils.preCheckCast(r1.get(1), Number.class, "com.obric.memorydata.plugin");
        Number r21 = (Number) ZeusTransformUtils.preCheckCast(r1.get(2), Number.class, "com.obric.memorydata.plugin");
        Number r22 = (Number) ZeusTransformUtils.preCheckCast(r1.get(3), Number.class, "com.obric.memorydata.plugin");
        r2 = r8;
        r11 = r19;
        r12 = r20;
        r13 = r21;
        r16 = r22;
        goto L47
    L140:
        return null;
    L69:
        if ("hvcurveto".equals(r3) == false) goto L74;
        if (r1.size() < 4) goto L141;
        Number r23 = (Number) ZeusTransformUtils.preCheckCast(r1.get(0), Number.class, "com.obric.memorydata.plugin");
        Number r24 = (Number) ZeusTransformUtils.preCheckCast(r1.get(1), Number.class, "com.obric.memorydata.plugin");
        Number r25 = (Number) ZeusTransformUtils.preCheckCast(r1.get(2), Number.class, "com.obric.memorydata.plugin");
        r17 = (Number) ZeusTransformUtils.preCheckCast(r1.get(3), Number.class, "com.obric.memorydata.plugin");
        t this = this;
        r2 = r23;
        r11 = r8;
        r12 = r24;
        r13 = r25;
        r16 = r8;
        goto L48
    L141:
        return null;
    L74:
        if ("seac".equals(r3) == false) goto L79;
        if (r1.size() < 5) goto L142;
        a((Number) ZeusTransformUtils.preCheckCast(r1.get(0), Number.class, "com.obric.memorydata.plugin"), (Number) ZeusTransformUtils.preCheckCast(r1.get(1), Number.class, "com.obric.memorydata.plugin"), (Number) ZeusTransformUtils.preCheckCast(r1.get(2), Number.class, "com.obric.memorydata.plugin"), (Number) ZeusTransformUtils.preCheckCast(r1.get(3), Number.class, "com.obric.memorydata.plugin"), (Number) ZeusTransformUtils.preCheckCast(r1.get(4), Number.class, "com.obric.memorydata.plugin"));
        return null;
    L142:
        return null;
    L79:
        if ("setcurrentpoint".equals(r3) == false) goto L84;
        if (r1.size() < 2) goto L144;
        a((Number) ZeusTransformUtils.preCheckCast(r1.get(0), Number.class, "com.obric.memorydata.plugin"), (Number) ZeusTransformUtils.preCheckCast(r1.get(1), Number.class, "com.obric.memorydata.plugin"));
        return null;
    L144:
        return null;
    L84:
        if ("callothersubr".equals(r3) == false) goto L89;
        if (r1.isEmpty() == true) goto L146;
        a(((Number) ZeusTransformUtils.preCheckCast(r1.get(0), Number.class, "com.obric.memorydata.plugin")).intValue());
        return null;
    L146:
        return null;
    L89:
        if ("div".equals(r3) == false) goto L95;
        if (r1.size() < 2) goto L148;
        float r26 = ((Number) ZeusTransformUtils.preCheckCast(r1.get(r1.size() - 2), Number.class, "com.obric.memorydata.plugin")).floatValue() / ((Number) ZeusTransformUtils.preCheckCast(r1.get(r1.size() - 1), Number.class, "com.obric.memorydata.plugin")).floatValue();
        ArrayList r27 = new ArrayList(r1);
        r27.remove(r27.size() - 1);
        r27.remove(r27.size() - 1);
        r27.add(Float.valueOf(r26));
        return r27;
    L148:
        return null;
    L95:
        if ("hstem".equals(r3) == false) goto L97;
        return null;
    L97:
        if ("vstem".equals(r3) == false) goto L99;
        return null;
    L99:
        if ("hstem3".equals(r3) == false) goto L101;
        return null;
    L101:
        if ("vstem3".equals(r3) == false) goto L103;
        return null;
    L103:
        if ("dotsection".equals(r3) == false) goto L106;
        return null;
    L106:
        if ("endchar".equals(r3) == false) goto L109;
        return null;
    L109:
        if ("return".equals(r3) == false) goto L111;
    L117:
        StringBuilder r28 = new StringBuilder().append("Unexpected charstring command: ").append(r3);
    L118:
        Log.w("PdfBox-Android", r28.append(" in glyph ").append(this.e).append(" of font ").append(this.d).toString());
        return null;
    L111:
        if ("callsubr".equals(r3) == true) goto L117;
        if (r3 != null) goto L116;
        r28 = new StringBuilder().append("Unknown charstring command: ").append(r15.a());
        goto L118
    L116:
        throw new IllegalArgumentException("Unhandled command: " + r3);
    }

    private void a(int r12) {
        if (r12 != 0) goto L9;
        this.j = false;
        if (this.k.size() >= 7) goto L8;
        Log.w("PdfBox-Android", "flex without moveTo in font " + this.d + ", glyph " + this.e + ", command " + this.f15944b);
        return;
    L8:
        PointF r13 = (PointF) ZeusTransformUtils.preCheckCast(this.k.get(0), PointF.class, "com.obric.memorydata.plugin");
        r13.set(this.i.x + r13.x, this.i.y + r13.y);
        PointF r0 = (PointF) ZeusTransformUtils.preCheckCast(this.k.get(1), PointF.class, "com.obric.memorydata.plugin");
        r0.set(r13.x + r0.x, r13.y + r0.y);
        r0.set(r0.x - this.i.x, r0.y - this.i.y);
        PointF r14 = (PointF) ZeusTransformUtils.preCheckCast(this.k.get(1), PointF.class, "com.obric.memorydata.plugin");
        PointF r1 = (PointF) ZeusTransformUtils.preCheckCast(this.k.get(2), PointF.class, "com.obric.memorydata.plugin");
        PointF r2 = (PointF) ZeusTransformUtils.preCheckCast(this.k.get(3), PointF.class, "com.obric.memorydata.plugin");
        a(Float.valueOf(r14.x), Float.valueOf(r14.y), Float.valueOf(r1.x), Float.valueOf(r1.y), Float.valueOf(r2.x), Float.valueOf(r2.y));
        PointF r15 = (PointF) ZeusTransformUtils.preCheckCast(this.k.get(4), PointF.class, "com.obric.memorydata.plugin");
        PointF r3 = (PointF) ZeusTransformUtils.preCheckCast(this.k.get(5), PointF.class, "com.obric.memorydata.plugin");
        PointF r4 = (PointF) ZeusTransformUtils.preCheckCast(this.k.get(6), PointF.class, "com.obric.memorydata.plugin");
        a(Float.valueOf(r15.x), Float.valueOf(r15.y), Float.valueOf(r3.x), Float.valueOf(r3.y), Float.valueOf(r4.x), Float.valueOf(r4.y));
        this.k.clear();
        return;
    L9:
        if (r12 != 1) goto L11;
        this.j = true;
        return;
    L11:
        Log.w("PdfBox-Android", "Invalid callothersubr parameter: " + r12);
    }

    private void a(Number r1, Number r2) {
        this.i.set(r1.floatValue(), r2.floatValue());
    }

    private void a(Number r7, Number r8, Number r9, Number r10, Number r11) {
        String r12 = com.tom_roush.fontbox.d.c.c.a(r10.intValue());
        this.f.op(this.c.b_(r12).b(), Path.Op.UNION);     // Catch: IOException -> L5
    L6:
        String r13 = com.tom_roush.fontbox.d.c.c.a(r11.intValue());
        t r3 = this.c.b_(r13);     // Catch: IOException -> L13
        if (this.f != r3.b()) goto L11;
        Log.w("PdfBox-Android", "Path for " + r12 + " and for accent " + r13 + " are same, ignored");     // Catch: IOException -> L13
        return;
    L11:
        AffineTransform.getTranslateInstance((this.h.x + r8.floatValue()) - r7.floatValue(), this.h.y + r9.floatValue());     // Catch: IOException -> L13
        this.f.op(r3.b(), Path.Op.UNION);     // Catch: IOException -> L13
        return;
    L13:
        Log.w("PdfBox-Android", "invalid seac character in glyph " + this.e + " of font " + this.d);
        return;
    L5:
        Log.w("PdfBox-Android", "invalid seac character in glyph " + this.e + " of font " + this.d);
        goto L6
    }

    private void a(Number r9, Number r10, Number r11, Number r12, Number r13, Number r14) {
        float r2 = this.i.x + r9.floatValue();
        float r3 = this.i.y + r10.floatValue();
        float r4 = r2 + r11.floatValue();
        float r5 = r3 + r12.floatValue();
        float r15 = r13.floatValue() + r4;
        float r16 = r14.floatValue() + r5;
        if (this.f.isEmpty() == false) goto L5;
        Log.w("PdfBox-Android", "rrcurveTo without initial moveTo in font " + this.d + ", glyph " + this.e);
        this.f.moveTo(r15, r16);
    L6:
        this.i.set(r15, r16);
        return;
    L5:
        this.f.cubicTo(r2, r3, r4, r5, r15, r16);
        goto L6
    }

    private void b(Number r2, Number r3) {
        float r0 = this.i.x + r2.floatValue();
        float r4 = this.i.y + r3.floatValue();
        this.f.moveTo(r0, r4);
        this.i.set(r0, r4);
    }

    private void c() {
        this.f = new Path();
        this.h = new PointF(0.0f, 0.0f);
        this.g = 0;
        new AnonymousClass1(this).a(this.f15943a);
    }

    private void c(Number r3, Number r4) {
        float r0 = this.i.x + r3.floatValue();
        float r5 = this.i.y + r4.floatValue();
        if (this.f.isEmpty() == false) goto L5;
        Log.w("PdfBox-Android", "rlineTo without initial moveTo in font " + this.d + ", glyph " + this.e);
        this.f.moveTo(r0, r5);
    L6:
        this.i.set(r0, r5);
        return;
    L5:
        this.f.lineTo(r0, r5);
        goto L6
    }

    private void d() {
        if (this.f.isEmpty() == false) goto L5;
        Log.w("PdfBox-Android", "closepath without initial moveTo in font " + this.d + ", glyph " + this.e);
    L6:
        this.f.moveTo(this.i.x, this.i.y);
        return;
    L5:
        this.f.close();
        goto L6
    }

    public int a() {
        if (this.f != null) goto L6;
        c();
    L6:
        return this.g;
    }

    public Path b() {
        if (this.f != null) goto L6;
        c();
    L6:
        return this.f;
    }

    public String toString() {
        return this.f15943a.toString().replace("|", "\n").replace(",", " ");
    }
}
