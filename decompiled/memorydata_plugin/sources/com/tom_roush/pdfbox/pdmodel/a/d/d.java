package com.tom_roush.pdfbox.pdmodel.a.d;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
public class d extends g {
    public static final String A = "Start";
    public static final String B = "Center";
    public static final String C = "End";
    public static final String D = "Justify";
    public static final String E = "Auto";
    public static final String F = "Auto";
    public static final String G = "Before";
    public static final String H = "Middle";
    public static final String I = "After";

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public static final String f16165J = "Justify";
    public static final String K = "Start";
    public static final String L = "Center";
    public static final String M = "End";
    public static final String N = "Normal";
    public static final String O = "Auto";
    public static final String P = "None";
    public static final String Q = "Underline";
    public static final String R = "Overline";
    public static final String S = "LineThrough";
    public static final String T = "Start";
    public static final String U = "Center";
    public static final String V = "End";
    public static final String W = "Justify";
    public static final String X = "Distribute";
    public static final String Y = "Before";
    public static final String Z = "After";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f16166a = "Placement";
    private static final String aA = "LineHeight";
    private static final String aB = "TextDecorationColor";
    private static final String aC = "TextDecorationThickness";
    private static final String aD = "TextDecorationType";
    private static final String aE = "RubyAlign";
    private static final String aF = "RubyPosition";
    private static final String aG = "GlyphOrientationVertical";
    private static final String aH = "ColumnCount";
    private static final String aI = "ColumnGap";
    private static final String aJ = "ColumnWidths";
    public static final String aa = "Warichu";
    public static final String ab = "Inline";
    public static final String ac = "Auto";
    public static final String ad = "-180";
    public static final String ae = "-90";
    public static final String af = "0";
    public static final String ag = "90";
    public static final String ah = "180";
    public static final String ai = "270";
    public static final String aj = "360";
    private static final String al = "Color";
    private static final String am = "SpaceBefore";
    private static final String an = "SpaceAfter";
    private static final String ao = "StartIndent";
    private static final String ap = "EndIndent";
    private static final String aq = "TextIndent";
    private static final String ar = "TextAlign";
    private static final String as = "BBox";
    private static final String at = "Width";
    private static final String au = "Height";
    private static final String av = "BlockAlign";
    private static final String aw = "InlineAlign";
    private static final String ax = "TBorderStyle";
    private static final String ay = "TPadding";
    private static final String az = "BaselineShift";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f16167b = "WritingMode";
    private static final String c = "BackgroundColor";
    private static final String d = "BorderColor";
    private static final String e = "BorderStyle";
    private static final String f = "BorderThickness";
    private static final String g = "Padding";
    public static final String h = "Layout";
    public static final String i = "Block";
    public static final String j = "Inline";
    public static final String k = "Before";
    public static final String l = "Start";
    public static final String m = "End";
    public static final String n = "LrTb";
    public static final String o = "RlTb";
    public static final String p = "TbRl";
    public static final String q = "None";
    public static final String r = "Hidden";
    public static final String s = "Dotted";
    public static final String t = "Dashed";
    public static final String u = "Solid";
    public static final String v = "Double";
    public static final String w = "Groove";
    public static final String x = "Ridge";
    public static final String y = "Inset";
    public static final String z = "Outset";

    public d() {
        a(h);
    }

    public d(com.tom_roush.pdfbox.a.d r1) {
        super(r1);
    }

    public Object A() {
        return e(at, "Auto");
    }

    public void B() {
        d(at, "Auto");
    }

    public Object C() {
        return e(au, "Auto");
    }

    public void D() {
        d(au, "Auto");
    }

    public String E() {
        return b(av, "Before");
    }

    public String F() {
        return b(aw, "Start");
    }

    public Object G() {
        return c(ax, "None");
    }

    public Object H() {
        return b(ay, 0.0f);
    }

    public float I() {
        return a(az, 0.0f);
    }

    public Object J() {
        return e(aA, N);
    }

    public void K() {
        d(aA, N);
    }

    public void L() {
        d(aA, "Auto");
    }

    public com.tom_roush.pdfbox.pdmodel.graphics.b.f M() {
        return u(aB);
    }

    public float N() {
        return t(aC);
    }

    public String O() {
        return b(aD, "None");
    }

    public String P() {
        return b(aE, X);
    }

    public String Q() {
        return b(aF, "Before");
    }

    public String R() {
        return b(aG, "Auto");
    }

    public int S() {
        return a(aH, 1);
    }

    public Object T() {
        return b(aI, -1.0f);
    }

    public Object U() {
        return b(aJ, -1.0f);
    }

    public void a(float r2) {
        c(f, r2);
    }

    public void a(c r2) {
        a(d, r2);
    }

    public void a(com.tom_roush.pdfbox.pdmodel.common.h r4) {
        com.tom_roush.pdfbox.a.b r0 = a().a(as);
        a().a(as, r4);
        if (r4 != null) goto L5;
        com.tom_roush.pdfbox.a.b r5 = null;
    L6:
        a(r0, r5);
        return;
    L5:
        r5 = r4.e();
        goto L6
    }

    public void a(com.tom_roush.pdfbox.pdmodel.graphics.b.f r2) {
        a(c, r2);
    }

    public void b(float r2) {
        c(g, r2);
    }

    public void b(com.tom_roush.pdfbox.pdmodel.graphics.b.f r2) {
        a(d, r2);
    }

    public void b(float[] r2) {
        a(f, r2);
    }

    public void b(String[] r2) {
        b(e, r2);
    }

    public void c(float r2) {
        c(am, r2);
    }

    public void c(int r2) {
        c(f, r2);
    }

    public void c(com.tom_roush.pdfbox.pdmodel.graphics.b.f r2) {
        a(al, r2);
    }

    public void c(float[] r2) {
        a(g, r2);
    }

    public void c(String[] r2) {
        b(ax, r2);
    }

    public void d(float r2) {
        c(an, r2);
    }

    public void d(int r2) {
        c(g, r2);
    }

    public void d(com.tom_roush.pdfbox.pdmodel.graphics.b.f r2) {
        a(aB, r2);
    }

    public void d(float[] r2) {
        a(ay, r2);
    }

    public void e(float r2) {
        c(ao, r2);
    }

    public void e(int r2) {
        c(am, r2);
    }

    public void e(String r2) {
        d(f16166a, r2);
    }

    public void e(float[] r2) {
        a(aI, r2);
    }

    public void f(float r2) {
        c(ap, r2);
    }

    public void f(int r2) {
        c(an, r2);
    }

    public void f(String r2) {
        d(f16167b, r2);
    }

    public void f(float[] r2) {
        a(aJ, r2);
    }

    public void g(float r2) {
        c(aq, r2);
    }

    public void g(int r2) {
        c(ao, r2);
    }

    public void g(String r2) {
        d(e, r2);
    }

    public void h(float r2) {
        c(at, r2);
    }

    public void h(int r2) {
        c(ap, r2);
    }

    public void h(String r2) {
        d(ar, r2);
    }

    public void i(float r2) {
        c(au, r2);
    }

    public void i(int r2) {
        c(aq, r2);
    }

    public void i(String r2) {
        d(av, r2);
    }

    public void j(float r2) {
        c(ay, r2);
    }

    public void j(int r2) {
        c(at, r2);
    }

    public void j(String r2) {
        d(aw, r2);
    }

    public void k(float r2) {
        c(az, r2);
    }

    public void k(int r2) {
        c(au, r2);
    }

    public void k(String r2) {
        d(ax, r2);
    }

    public String l() {
        return b(f16166a, "Inline");
    }

    public void l(float r2) {
        c(aA, r2);
    }

    public void l(int r2) {
        c(ay, r2);
    }

    public void l(String r2) {
        d(aD, r2);
    }

    public String m() {
        return b(f16167b, n);
    }

    public void m(float r2) {
        c(aC, r2);
    }

    public void m(int r2) {
        c(az, r2);
    }

    public void m(String r2) {
        d(aE, r2);
    }

    public com.tom_roush.pdfbox.pdmodel.graphics.b.f n() {
        return u(c);
    }

    public void n(float r2) {
        c(aI, r2);
    }

    public void n(int r2) {
        c(aA, r2);
    }

    public void n(String r2) {
        d(aF, r2);
    }

    public Object o() {
        return v(d);
    }

    public void o(float r2) {
        c(aJ, r2);
    }

    public void o(int r2) {
        c(aC, r2);
    }

    public void o(String r2) {
        d(aG, r2);
    }

    public Object p() {
        return c(e, "None");
    }

    public void p(int r2) {
        b(aH, r2);
    }

    public Object q() {
        return b(f, -1.0f);
    }

    public void q(int r2) {
        c(aI, r2);
    }

    public Object r() {
        return b(g, 0.0f);
    }

    public void r(int r2) {
        c(aJ, r2);
    }

    public com.tom_roush.pdfbox.pdmodel.graphics.b.f s() {
        return u(al);
    }

    public float t() {
        return a(am, 0.0f);
    }

    @Override // com.tom_roush.pdfbox.pdmodel.a.a.a
    public String toString() {
        StringBuilder r1 = new StringBuilder().append(super.toString());
        if (p(f16166a) == false) goto L6;
        r1.append(", Placement=").append(l());
    L6:
        if (p(f16167b) == false) goto L9;
        r1.append(", WritingMode=").append(m());
    L9:
        if (p(c) == false) goto L12;
        r1.append(", BackgroundColor=").append(n());
    L12:
        if (p(d) == false) goto L15;
        r1.append(", BorderColor=").append(o());
    L15:
        if (p(e) == false) goto L21;
        Object r2 = p();
        r1.append(", BorderStyle=");
        if ((r2 instanceof String[]) == false) goto L19;
        r1.append(a((String[]) ZeusTransformUtils.preCheckCast(r2, String[].class, "com.obric.memorydata.plugin")));
        goto L21
    L19:
        r1.append(r2);
    L21:
        if (p(f) == false) goto L27;
        Object r3 = q();
        r1.append(", BorderThickness=");
        if ((r3 instanceof float[]) == false) goto L25;
        r1.append(a((float[]) ZeusTransformUtils.preCheckCast(r3, float[].class, "com.obric.memorydata.plugin")));
        goto L27
    L25:
        r1.append(r3);
    L27:
        if (p(g) == false) goto L33;
        Object r4 = r();
        r1.append(", Padding=");
        if ((r4 instanceof float[]) == false) goto L31;
        r1.append(a((float[]) ZeusTransformUtils.preCheckCast(r4, float[].class, "com.obric.memorydata.plugin")));
        goto L33
    L31:
        r1.append(r4);
    L33:
        if (p(al) == false) goto L36;
        r1.append(", Color=").append(s());
    L36:
        if (p(am) == false) goto L39;
        r1.append(", SpaceBefore=").append(t());
    L39:
        if (p(an) == false) goto L42;
        r1.append(", SpaceAfter=").append(u());
    L42:
        if (p(ao) == false) goto L45;
        r1.append(", StartIndent=").append(v());
    L45:
        if (p(ap) == false) goto L48;
        r1.append(", EndIndent=").append(w());
    L48:
        if (p(aq) == false) goto L51;
        r1.append(", TextIndent=").append(x());
    L51:
        if (p(ar) == false) goto L54;
        r1.append(", TextAlign=").append(y());
    L54:
        if (p(as) == false) goto L57;
        r1.append(", BBox=").append(z());
    L57:
        if (p(at) == false) goto L60;
        r1.append(", Width=").append(A());
    L60:
        if (p(au) == false) goto L63;
        r1.append(", Height=").append(C());
    L63:
        if (p(av) == false) goto L66;
        r1.append(", BlockAlign=").append(E());
    L66:
        if (p(aw) == false) goto L69;
        r1.append(", InlineAlign=").append(F());
    L69:
        if (p(ax) == false) goto L75;
        Object r5 = G();
        r1.append(", TBorderStyle=");
        if ((r5 instanceof String[]) == false) goto L73;
        r1.append(a((String[]) ZeusTransformUtils.preCheckCast(r5, String[].class, "com.obric.memorydata.plugin")));
        goto L75
    L73:
        r1.append(r5);
    L75:
        if (p(ay) == false) goto L81;
        Object r6 = H();
        r1.append(", TPadding=");
        if ((r6 instanceof float[]) == false) goto L79;
        r1.append(a((float[]) ZeusTransformUtils.preCheckCast(r6, float[].class, "com.obric.memorydata.plugin")));
        goto L81
    L79:
        r1.append(r6);
    L81:
        if (p(az) == false) goto L84;
        r1.append(", BaselineShift=").append(I());
    L84:
        if (p(aA) == false) goto L87;
        r1.append(", LineHeight=").append(J());
    L87:
        if (p(aB) == false) goto L90;
        r1.append(", TextDecorationColor=").append(M());
    L90:
        if (p(aC) == false) goto L93;
        r1.append(", TextDecorationThickness=").append(N());
    L93:
        if (p(aD) == false) goto L96;
        r1.append(", TextDecorationType=").append(O());
    L96:
        if (p(aE) == false) goto L99;
        r1.append(", RubyAlign=").append(P());
    L99:
        if (p(aF) == false) goto L102;
        r1.append(", RubyPosition=").append(Q());
    L102:
        if (p(aG) == false) goto L105;
        r1.append(", GlyphOrientationVertical=").append(R());
    L105:
        if (p(aH) == false) goto L108;
        r1.append(", ColumnCount=").append(S());
    L108:
        if (p(aI) == false) goto L114;
        Object r7 = T();
        r1.append(", ColumnGap=");
        if ((r7 instanceof float[]) == false) goto L112;
        r1.append(a((float[]) ZeusTransformUtils.preCheckCast(r7, float[].class, "com.obric.memorydata.plugin")));
        goto L114
    L112:
        r1.append(r7);
    L114:
        if (p(aJ) == false) goto L120;
        Object r8 = U();
        r1.append(", ColumnWidths=");
        if ((r8 instanceof float[]) == false) goto L118;
        r1.append(a((float[]) ZeusTransformUtils.preCheckCast(r8, float[].class, "com.obric.memorydata.plugin")));
        goto L120
    L118:
        r1.append(r8);
    L120:
        return r1.toString();
    }

    public float u() {
        return a(an, 0.0f);
    }

    public float v() {
        return a(ao, 0.0f);
    }

    public float w() {
        return a(ap, 0.0f);
    }

    public float x() {
        return a(aq, 0.0f);
    }

    public String y() {
        return b(ar, "Start");
    }

    public com.tom_roush.pdfbox.pdmodel.common.h z() {
        com.tom_roush.pdfbox.a.a r2 = (com.tom_roush.pdfbox.a.a) ZeusTransformUtils.preCheckCast(a().a(as), com.tom_roush.pdfbox.a.a.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L5;
        return null;
    L5:
        return new com.tom_roush.pdfbox.pdmodel.common.h(r2);
    }
}
