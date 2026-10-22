package org.jsoup.nodes;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes7.dex */
public class n extends i {
    public n(String r1) {
        this.f18264a = r1;
    }

    static boolean a(StringBuilder r2) {
        if (r2.length() != 0) goto L5;
    L7:
        return false;
    L5:
        if (r2.charAt(r2.length() - 1) != ' ') goto L7;
        return true;
    }

    @Override // org.jsoup.nodes.j
    public String a() {
        return "#text";
    }

    @Override // org.jsoup.nodes.i, org.jsoup.nodes.j
    public /* bridge */ /* synthetic */ String a(String r1) {
        return super.a(r1);
    }

    @Override // org.jsoup.nodes.i, org.jsoup.nodes.j
    public /* bridge */ /* synthetic */ j a(String r1, String r2) {
        return super.a(r1, r2);
    }

    @Override // org.jsoup.nodes.j
    void a(Appendable r17, int r18, Document.OutputSettings r19) {
        Appendable r3 = (Appendable) ZeusTransformUtils.wrapperContextForParams(r17, Appendable.class, "com.obric.memorydata.plugin");
        boolean r5 = r19.e();
        if (ZeusTransformUtils.instanceOf(this.d, Element.class) == false) goto L5;
        Element r6 = (Element) ZeusTransformUtils.preCheckCast(this.d, Element.class, "com.obric.memorydata.plugin");
    L6:
        boolean r7 = true;
        boolean r8 = false;
        if (r5 == true) goto L9;
    L11:
        boolean r9 = false;
    L12:
        if (r6 != null) goto L14;
    L18:
        boolean r10 = false;
    L19:
        if (r9 == false) goto L68;
        if (r10 == false) goto L24;
        if (this.e != 0) goto L24;
    L25:
        boolean r11 = true;
    L27:
        if (r10 == true) goto L29;
    L31:
        boolean r12 = false;
    L32:
        j r13 = ad();
        j r14 = ae();
        boolean r15 = j();
        if (ZeusTransformUtils.instanceOf(r13, Element.class) == false) goto L37;
        if (((Element) ZeusTransformUtils.preCheckCast(r13, Element.class, "com.obric.memorydata.plugin")).b(r19) == false) goto L37;
    L48:
        if (r7 == false) goto L52;
        if (r15 == false) goto L52;
        return;
    L52:
        if (this.e != 0) goto L58;
        if (r6 == null) goto L58;
        if (r6.s().d() == false) goto L58;
        if (r15 == true) goto L58;
    L66:
        c(r3, r18, r19);
    L67:
        boolean r16 = r12;
        r8 = r11;
    L69:
        Entities.a(r3, h(), r19, false, r9, r8, r16);
        return;
    L58:
        if (r19.f() == false) goto L63;
        if (ac().size() <= 0) goto L63;
        if (r15 == false) goto L66;
    L63:
        if (this.e <= 0) goto L67;
        if (a(r14, "br") == false) goto L67;
    L37:
        if (ZeusTransformUtils.instanceOf(r13, n.class) == false) goto L41;
        if (((n) ZeusTransformUtils.preCheckCast(r13, n.class, "com.obric.memorydata.plugin")).j() == true) goto L48;
    L41:
        if (ZeusTransformUtils.instanceOf(r14, Element.class) == true) goto L43;
    L47:
        r7 = false;
        goto L48
    L43:
        if (((Element) ZeusTransformUtils.preCheckCast(r14, Element.class, "com.obric.memorydata.plugin")).t() == true) goto L48;
        if (r14.A("br") == false) goto L47;
    L29:
        if (ad() != null) goto L31;
        r12 = true;
    L24:
        if (ZeusTransformUtils.instanceOf(this.d, Document.class) == true) goto L25;
        r11 = false;
        goto L27
    L68:
        r16 = false;
        goto L69
    L14:
        if (r6.s().c() == false) goto L16;
    L17:
        r10 = true;
        goto L19
    L16:
        if (r6.s().d() == false) goto L18;
    L9:
        if (Element.d(this.d) == true) goto L11;
        r9 = true;
        goto L12
    L5:
        r6 = null;
        goto L6
    }

    @Override // org.jsoup.nodes.i, org.jsoup.nodes.j
    public /* bridge */ /* synthetic */ j b(String r1) {
        return super.b(r1);
    }

    @Override // org.jsoup.nodes.j
    void b(Appendable r1, int r2, Document.OutputSettings r3) {
        Appendable r0 = (Appendable) ZeusTransformUtils.wrapperContextForParams(r1, Appendable.class, "com.obric.memorydata.plugin");
    }

    public n c() {
        return (n) ZeusTransformUtils.preCheckCast(super.d(), n.class, "com.obric.memorydata.plugin");
    }

    @Override // org.jsoup.nodes.i, org.jsoup.nodes.j
    public /* bridge */ /* synthetic */ boolean c(String r1) {
        return super.c(r1);
    }

    @Override // org.jsoup.nodes.j
    public /* synthetic */ Object clone() {
        return c();
    }

    @Override // org.jsoup.nodes.i, org.jsoup.nodes.j
    public /* bridge */ /* synthetic */ String d(String r1) {
        return super.d(r1);
    }

    @Override // org.jsoup.nodes.j
    public /* synthetic */ j d() {
        return c();
    }

    @Override // org.jsoup.nodes.i, org.jsoup.nodes.j
    public /* bridge */ /* synthetic */ j e() {
        return super.e();
    }

    @Override // org.jsoup.nodes.i, org.jsoup.nodes.j
    public /* bridge */ /* synthetic */ int f() {
        return super.f();
    }

    @Override // org.jsoup.nodes.i, org.jsoup.nodes.j
    public /* bridge */ /* synthetic */ String g() {
        return super.g();
    }

    public String i() {
        return h();
    }

    public boolean j() {
        return org.jsoup.a.b.a(h());
    }

    @Override // org.jsoup.nodes.j
    public String toString() {
        return x_();
    }
}
