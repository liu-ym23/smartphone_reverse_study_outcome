package com.tom_roush.pdfbox.pdmodel.a.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public class g extends h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f16150a = "StructElem";

    public g(com.tom_roush.pdfbox.a.d r1) {
        super(r1);
    }

    public g(String r2, h r3) {
        super(f16150a);
        a(r2);
        a(r3);
    }

    private i r() {
    L3:
        h r3 = this.b();
        if (ZeusTransformUtils.instanceOf(r3, g.class) == false) goto L7;
        g this = (g) ZeusTransformUtils.preCheckCast(r3, g.class, "com.obric.memorydata.plugin");
        goto L3
    L7:
        if (ZeusTransformUtils.instanceOf(r3, i.class) == true) goto L9;
        return null;
    L9:
        return (i) ZeusTransformUtils.preCheckCast(r3, i.class, "com.obric.memorydata.plugin");
    }

    private Map<String, Object> s() {
        i r0 = r();
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.g();
    }

    public String a() {
        return p().g(com.tom_roush.pdfbox.a.i.he);
    }

    public void a(int r2) {
        if (r2 < 0) goto L6;
        p().a(com.tom_roush.pdfbox.a.i.gG, r2);
        return;
    L6:
        throw new IllegalArgumentException("The revision number shall be > -1");
    }

    public void a(com.tom_roush.pdfbox.a.h r1) {
        b(r1);
    }

    public void a(com.tom_roush.pdfbox.a.h r1, Object r2) {
        a(r1, r2);
    }

    public void a(a r6) {
        com.tom_roush.pdfbox.a.i r0 = com.tom_roush.pdfbox.a.i.f16057a;
        r6.a(this);
        com.tom_roush.pdfbox.a.b r1 = p().a(r0);
        if (ZeusTransformUtils.instanceOf(r1, com.tom_roush.pdfbox.a.a.class) == false) goto L5;
        com.tom_roush.pdfbox.a.a r2 = (com.tom_roush.pdfbox.a.a) ZeusTransformUtils.preCheckCast(r1, com.tom_roush.pdfbox.a.a.class, "com.obric.memorydata.plugin");
    L9:
        p().a(r0, r2);
        r2.a(r6);
        r2.a(com.tom_roush.pdfbox.a.h.a(h()));
        return;
    L5:
        com.tom_roush.pdfbox.a.a r3 = new com.tom_roush.pdfbox.a.a();
        if (r1 == null) goto L8;
        r3.a(r1);
        r3.a(com.tom_roush.pdfbox.a.h.a(0));
    L8:
        r2 = r3;
        goto L9
    }

    public void a(d r1) {
        a(r1);
    }

    public void a(d r1, Object r2) {
        a(r1, r2);
    }

    public void a(e r1) {
        a(r1);
    }

    public void a(e r1, Object r2) {
        a(r1, r2);
    }

    public final void a(h r2) {
        p().a(com.tom_roush.pdfbox.a.i.fV, r2);
    }

    public void a(l<a> r8) {
        com.tom_roush.pdfbox.a.i r0 = com.tom_roush.pdfbox.a.i.f16057a;
        int r4 = 0;
        if (r8.a() == 1) goto L5;
    L8:
        com.tom_roush.pdfbox.a.a r1 = new com.tom_roush.pdfbox.a.a();
    L10:
        if (r4 >= r8.a()) goto L16;
        a r3 = (a) ZeusTransformUtils.preCheckCast(r8.a(r4), a.class, "com.obric.memorydata.plugin");
        r3.a(this);
        int r5 = r8.b(r4);
        if (r5 < 0) goto L15;
        r1.a(r3);
        r1.a(com.tom_roush.pdfbox.a.h.a(r5));
        r4 = r4 + 1;
        goto L10
    L15:
        throw new IllegalArgumentException("The revision number shall be > -1");
    L16:
        p().a(r0, r1);
        return;
    L5:
        if (r8.b(0) != 0) goto L8;
        a r9 = (a) ZeusTransformUtils.preCheckCast(r8.a(0), a.class, "com.obric.memorydata.plugin");
        r9.a(this);
        p().a(r0, r9);
    }

    public void a(com.tom_roush.pdfbox.pdmodel.a.b.a r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        a(com.tom_roush.pdfbox.a.h.a(r3.c()));
    }

    public void a(com.tom_roush.pdfbox.pdmodel.g r2) {
        p().a(com.tom_roush.pdfbox.a.i.gp, r2);
    }

    public final void a(String r2) {
        p().a(com.tom_roush.pdfbox.a.i.he, r2);
    }

    public h b() {
        com.tom_roush.pdfbox.a.b r2 = p().a(com.tom_roush.pdfbox.a.i.fV);
        if (ZeusTransformUtils.instanceOf(r2, com.tom_roush.pdfbox.a.d.class) == true) goto L5;
        return null;
    L5:
        return h.a((com.tom_roush.pdfbox.a.d) ZeusTransformUtils.preCheckCast(r2, com.tom_roush.pdfbox.a.d.class, "com.obric.memorydata.plugin"));
    }

    public void b(a r6) {
        com.tom_roush.pdfbox.a.i r0 = com.tom_roush.pdfbox.a.i.f16057a;
        com.tom_roush.pdfbox.a.b r1 = p().a(r0);
        if (ZeusTransformUtils.instanceOf(r1, com.tom_roush.pdfbox.a.a.class) == false) goto L10;
        com.tom_roush.pdfbox.a.a r2 = (com.tom_roush.pdfbox.a.a) ZeusTransformUtils.preCheckCast(r1, com.tom_roush.pdfbox.a.a.class, "com.obric.memorydata.plugin");
        r2.b(r6.a());
        if (r2.b() == 2) goto L7;
    L15:
        r6.a(null);
        return;
    L7:
        if (r2.c(1) != 0) goto L15;
        p().a(r0, r2.a(0));
        goto L15
    L10:
        if (ZeusTransformUtils.instanceOf(r1, com.tom_roush.pdfbox.a.l.class) == false) goto L13;
        r1 = ((com.tom_roush.pdfbox.a.l) ZeusTransformUtils.preCheckCast(r1, com.tom_roush.pdfbox.a.l.class, "com.obric.memorydata.plugin")).a();
    L13:
        if (r6.a().equals(r1) == false) goto L15;
        p().a(r0, null);
        goto L15
    }

    public void b(d r1) {
        b(r1);
    }

    public void b(e r1) {
        b(r1);
    }

    public void b(l<String> r8) {
        if (r8 != null) goto L4;
        return;
    L4:
        com.tom_roush.pdfbox.a.i r0 = com.tom_roush.pdfbox.a.i.al;
        int r4 = 0;
        if (r8.a() == 1) goto L7;
    L10:
        com.tom_roush.pdfbox.a.a r1 = new com.tom_roush.pdfbox.a.a();
    L12:
        if (r4 >= r8.a()) goto L18;
        String r3 = (String) ZeusTransformUtils.preCheckCast(r8.a(r4), String.class, "com.obric.memorydata.plugin");
        int r5 = r8.b(r4);
        if (r5 < 0) goto L17;
        r1.a(com.tom_roush.pdfbox.a.i.a(r3));
        r1.a(com.tom_roush.pdfbox.a.h.a(r5));
        r4 = r4 + 1;
        goto L12
    L17:
        throw new IllegalArgumentException("The revision number shall be > -1");
    L18:
        p().a(r0, r1);
        return;
    L7:
        if (r8.b(0) != 0) goto L10;
        p().a(r0, (String) ZeusTransformUtils.preCheckCast(r8.a(0), String.class, "com.obric.memorydata.plugin"));
    }

    public void b(String r2) {
        p().b(com.tom_roush.pdfbox.a.i.dJ, r2);
    }

    public String c() {
        return p().h(com.tom_roush.pdfbox.a.i.dJ);
    }

    public void c(a r6) {
        com.tom_roush.pdfbox.a.i r0 = com.tom_roush.pdfbox.a.i.f16057a;
        com.tom_roush.pdfbox.a.b r1 = p().a(r0);
        if (ZeusTransformUtils.instanceOf(r1, com.tom_roush.pdfbox.a.a.class) == false) goto L13;
        com.tom_roush.pdfbox.a.a r2 = (com.tom_roush.pdfbox.a.a) ZeusTransformUtils.preCheckCast(r1, com.tom_roush.pdfbox.a.a.class, "com.obric.memorydata.plugin");
        int r3 = 0;
    L6:
        if (r3 >= r2.b()) goto L19;
        if (r2.a(r3).equals(r6.a()) == false) goto L12;
        int r4 = r3 + 1;
        if (ZeusTransformUtils.instanceOf(r2.b(r4), com.tom_roush.pdfbox.a.h.class) == false) goto L12;
        r2.b(r4, com.tom_roush.pdfbox.a.h.a(h()));
    L12:
        r3 = r3 + 1;
        goto L6
    L19:
        return;
    L13:
        com.tom_roush.pdfbox.a.a r7 = new com.tom_roush.pdfbox.a.a();
        r7.a(r1);
        r7.a(com.tom_roush.pdfbox.a.h.a(h()));
        p().a(r0, r7);
    }

    public void c(String r6) {
        if (r6 != null) goto L4;
        return;
    L4:
        com.tom_roush.pdfbox.a.i r0 = com.tom_roush.pdfbox.a.i.al;
        com.tom_roush.pdfbox.a.b r1 = p().a(r0);
        if (ZeusTransformUtils.instanceOf(r1, com.tom_roush.pdfbox.a.a.class) == false) goto L7;
        com.tom_roush.pdfbox.a.a r2 = (com.tom_roush.pdfbox.a.a) ZeusTransformUtils.preCheckCast(r1, com.tom_roush.pdfbox.a.a.class, "com.obric.memorydata.plugin");
    L11:
        p().a(r0, r2);
        r2.a(com.tom_roush.pdfbox.a.i.a(r6));
        r2.a(com.tom_roush.pdfbox.a.h.a(h()));
        return;
    L7:
        com.tom_roush.pdfbox.a.a r3 = new com.tom_roush.pdfbox.a.a();
        if (r1 == null) goto L10;
        r3.a(r1);
        r3.a(com.tom_roush.pdfbox.a.h.a(0));
    L10:
        r2 = r3;
        goto L11
    }

    public com.tom_roush.pdfbox.pdmodel.g d() {
        com.tom_roush.pdfbox.a.b r3 = p().a(com.tom_roush.pdfbox.a.i.gp);
        if (ZeusTransformUtils.instanceOf(r3, com.tom_roush.pdfbox.a.d.class) == true) goto L5;
        return null;
    L5:
        return new com.tom_roush.pdfbox.pdmodel.g((com.tom_roush.pdfbox.a.d) ZeusTransformUtils.preCheckCast(r3, com.tom_roush.pdfbox.a.d.class, "com.obric.memorydata.plugin"));
    }

    public void d(String r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        com.tom_roush.pdfbox.a.i r0 = com.tom_roush.pdfbox.a.i.al;
        com.tom_roush.pdfbox.a.b r1 = p().a(r0);
        com.tom_roush.pdfbox.a.i r6 = com.tom_roush.pdfbox.a.i.a(r5);
        if (ZeusTransformUtils.instanceOf(r1, com.tom_roush.pdfbox.a.a.class) == false) goto L12;
        com.tom_roush.pdfbox.a.a r2 = (com.tom_roush.pdfbox.a.a) ZeusTransformUtils.preCheckCast(r1, com.tom_roush.pdfbox.a.a.class, "com.obric.memorydata.plugin");
        r2.b(r6);
        if (r2.b() == 2) goto L9;
        return;
    L9:
        if (r2.c(1) != 0) goto L20;
        com.tom_roush.pdfbox.a.d r4 = p();
        com.tom_roush.pdfbox.a.b r7 = r2.a(0);
    L17:
        r4.a(r0, r7);
        return;
    L20:
        return;
    L12:
        if (ZeusTransformUtils.instanceOf(r1, com.tom_roush.pdfbox.a.l.class) == false) goto L15;
        r1 = ((com.tom_roush.pdfbox.a.l) ZeusTransformUtils.preCheckCast(r1, com.tom_roush.pdfbox.a.l.class, "com.obric.memorydata.plugin")).a();
    L15:
        if (r6.equals(r1) == false) goto L21;
        r4 = p();
        r7 = null;
        goto L17
    }

    public void e(String r2) {
        p().b(com.tom_roush.pdfbox.a.i.ia, r2);
    }

    public l<a> f() {
        l<a> r0 = new l();
        com.tom_roush.pdfbox.a.b r1 = p().a(com.tom_roush.pdfbox.a.i.f16057a);
        if (ZeusTransformUtils.instanceOf(r1, com.tom_roush.pdfbox.a.a.class) == false) goto L17;
        Iterator<com.tom_roush.pdfbox.a.b> r2 = ((com.tom_roush.pdfbox.a.a) ZeusTransformUtils.preCheckCast(r1, com.tom_roush.pdfbox.a.a.class, "com.obric.memorydata.plugin")).iterator();
        a r5 = null;
    L6:
        if (r2.hasNext() == false) goto L17;
        com.tom_roush.pdfbox.a.b r6 = (com.tom_roush.pdfbox.a.b) ZeusTransformUtils.preCheckCast(r2.next(), com.tom_roush.pdfbox.a.b.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r6, com.tom_roush.pdfbox.a.l.class) == false) goto L11;
        r6 = ((com.tom_roush.pdfbox.a.l) ZeusTransformUtils.preCheckCast(r6, com.tom_roush.pdfbox.a.l.class, "com.obric.memorydata.plugin")).a();
    L11:
        if (ZeusTransformUtils.instanceOf(r6, com.tom_roush.pdfbox.a.d.class) == true) goto L12;
        if (ZeusTransformUtils.instanceOf(r6, com.tom_roush.pdfbox.a.h.class) == false) goto L6;
        r0.b(r5, ((com.tom_roush.pdfbox.a.k) ZeusTransformUtils.preCheckCast(r6, com.tom_roush.pdfbox.a.k.class, "com.obric.memorydata.plugin")).c());
        goto L6
    L12:
        r5 = a.a((com.tom_roush.pdfbox.a.d) ZeusTransformUtils.preCheckCast(r6, com.tom_roush.pdfbox.a.d.class, "com.obric.memorydata.plugin"));
        r5.a(this);
        r0.a(r5, 0);
    L17:
        if (ZeusTransformUtils.instanceOf(r1, com.tom_roush.pdfbox.a.d.class) == false) goto L19;
        a r3 = a.a((com.tom_roush.pdfbox.a.d) ZeusTransformUtils.preCheckCast(r1, com.tom_roush.pdfbox.a.d.class, "com.obric.memorydata.plugin"));
        r3.a(this);
        r0.a(r3, 0);
    L19:
        return r0;
    }

    public void f(String r2) {
        p().b(com.tom_roush.pdfbox.a.i.eo, r2);
    }

    public l<String> g() {
        com.tom_roush.pdfbox.a.i r0 = com.tom_roush.pdfbox.a.i.al;
        l<String> r1 = new l();
        com.tom_roush.pdfbox.a.b r6 = p().a(r0);
        if (ZeusTransformUtils.instanceOf(r6, com.tom_roush.pdfbox.a.i.class) == false) goto L6;
        r1.a(((com.tom_roush.pdfbox.a.i) ZeusTransformUtils.preCheckCast(r6, com.tom_roush.pdfbox.a.i.class, "com.obric.memorydata.plugin")).a(), 0);
    L6:
        if (ZeusTransformUtils.instanceOf(r6, com.tom_roush.pdfbox.a.a.class) == false) goto L19;
        Iterator<com.tom_roush.pdfbox.a.b> r7 = ((com.tom_roush.pdfbox.a.a) ZeusTransformUtils.preCheckCast(r6, com.tom_roush.pdfbox.a.a.class, "com.obric.memorydata.plugin")).iterator();
        String r2 = null;
    L9:
        if (r7.hasNext() == false) goto L19;
        com.tom_roush.pdfbox.a.b r4 = (com.tom_roush.pdfbox.a.b) ZeusTransformUtils.preCheckCast(r7.next(), com.tom_roush.pdfbox.a.b.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r4, com.tom_roush.pdfbox.a.l.class) == false) goto L14;
        r4 = ((com.tom_roush.pdfbox.a.l) ZeusTransformUtils.preCheckCast(r4, com.tom_roush.pdfbox.a.l.class, "com.obric.memorydata.plugin")).a();
    L14:
        if (ZeusTransformUtils.instanceOf(r4, com.tom_roush.pdfbox.a.i.class) == true) goto L15;
        if (ZeusTransformUtils.instanceOf(r4, com.tom_roush.pdfbox.a.h.class) == false) goto L9;
        r1.b(r2, ((com.tom_roush.pdfbox.a.h) ZeusTransformUtils.preCheckCast(r4, com.tom_roush.pdfbox.a.h.class, "com.obric.memorydata.plugin")).c());
        goto L9
    L15:
        r2 = ((com.tom_roush.pdfbox.a.i) ZeusTransformUtils.preCheckCast(r4, com.tom_roush.pdfbox.a.i.class, "com.obric.memorydata.plugin")).a();
        r1.a(r2, 0);
    L19:
        return r1;
    }

    public void g(String r2) {
        p().b(com.tom_roush.pdfbox.a.i.r, r2);
    }

    public int h() {
        return p().b(com.tom_roush.pdfbox.a.i.gG, 0);
    }

    public void h(String r2) {
        p().b(com.tom_roush.pdfbox.a.i.cq, r2);
    }

    public void i() {
        a(h() + 1);
    }

    public void i(String r2) {
        p().b(com.tom_roush.pdfbox.a.i.f, r2);
    }

    public String j() {
        return p().h(com.tom_roush.pdfbox.a.i.ia);
    }

    public String k() {
        return p().h(com.tom_roush.pdfbox.a.i.eo);
    }

    public String l() {
        return p().h(com.tom_roush.pdfbox.a.i.r);
    }

    public String m() {
        return p().h(com.tom_roush.pdfbox.a.i.cq);
    }

    public String n() {
        return p().h(com.tom_roush.pdfbox.a.i.f);
    }

    public String o() {
        String r0 = a();
        if (s().containsKey(r0) == false) goto L8;
        Object r2 = s().get(r0);
        if (ZeusTransformUtils.instanceOf(r2, String.class) == true) goto L7;
        return r0;
    L7:
        return (String) ZeusTransformUtils.preCheckCast(r2, String.class, "com.obric.memorydata.plugin");
    L8:
        return r0;
    }
}
