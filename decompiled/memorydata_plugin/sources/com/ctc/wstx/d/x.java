package com.ctc.wstx.d;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.BitSet;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class x extends y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected boolean f3501a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected com.ctc.wstx.util.f f3502b;
    protected al[] c;
    protected BitSet d;
    protected boolean e;
    protected BitSet f;

    public x(u r9, org.codehaus.stax2.validation.b r10, boolean r11, Map<com.ctc.wstx.util.h, i> r12, Map<String, com.ctc.wstx.e.a> r13) {
        super(r9, (org.codehaus.stax2.validation.b) ZeusTransformUtils.wrapperContextForParams(r10, org.codehaus.stax2.validation.b.class, "com.obric.memorydata.plugin"), r11, (Map) ZeusTransformUtils.wrapperContextForParams(r12, Map.class, "com.obric.memorydata.plugin"), (Map) ZeusTransformUtils.wrapperContextForParams(r13, Map.class, "com.obric.memorydata.plugin"));
        this.f3501a = false;
        this.f3502b = null;
        this.c = null;
        this.d = null;
        this.e = false;
        this.c = new al[16];
    }

    @Override // org.codehaus.stax2.validation.g
    public String a(String r3, String r4, String r5, String r6) {
        g r7 = (g) ZeusTransformUtils.preCheckCast(this.r.get(this.v.a(r5, r3)), g.class, "com.obric.memorydata.plugin");
        if (r7 == null) goto L5;
        int r8 = this.t;
        this.t = r8 + 1;
        if (r8 < this.s.length) goto L11;
        this.s = (g[]) ZeusTransformUtils.preCheckCast((g[]) ZeusTransformUtils.preCheckCast(com.ctc.wstx.util.c.b(this.s), g[].class, "com.obric.memorydata.plugin"), g[].class, "com.obric.memorydata.plugin");
    L11:
        this.s[r8] = r7;
        if (this.d == null) goto L16;
        int r9 = r7.b();
        if (r9 < 0) goto L16;
        this.d.set(r9);
    L16:
        String r10 = r7.a(this, r6, this.n);
        if (this.e == true) goto L19;
    L26:
        return r10;
    L19:
        if (r7.d() == false) goto L26;
        if (r10 == null) goto L23;
        r6 = r10;
    L23:
        String r11 = r7.a(this.k, this);
        if (r6.equals(r11) == true) goto L26;
        a("Value of attribute \"" + r7 + "\" (element <" + this.o + ">) not \"" + r11 + "\" as expected, but \"" + r6 + "\"");
        goto L26
    L5:
        if (this.o == null) goto L7;
        a(com.ctc.wstx.b.a.Z, this.o.toString(), this.v.toString());
    L7:
        return r6;
    }

    @Override // org.codehaus.stax2.validation.g
    public String a(String r7, String r8, String r9, char[] r10, int r11, int r12) {
        g r13 = (g) ZeusTransformUtils.preCheckCast(this.r.get(this.v.a(r9, r7)), g.class, "com.obric.memorydata.plugin");
        if (r13 == null) goto L5;
        int r14 = this.t;
        this.t = r14 + 1;
        if (r14 < this.s.length) goto L12;
        this.s = (g[]) ZeusTransformUtils.preCheckCast((g[]) ZeusTransformUtils.preCheckCast(com.ctc.wstx.util.c.b(this.s), g[].class, "com.obric.memorydata.plugin"), g[].class, "com.obric.memorydata.plugin");
    L12:
        this.s[r14] = r13;
        if (this.d == null) goto L17;
        int r15 = r13.b();
        if (r15 < 0) goto L17;
        this.d.set(r15);
    L17:
        String r16 = r13.a(this, r10, r11, r12, this.n);
        if (this.e == true) goto L20;
    L30:
        return r16;
    L20:
        if (r13.d() == false) goto L30;
        String r17 = r13.a(this.k, this);
        if (r16 != null) goto L24;
        boolean r0 = com.ctc.wstx.util.i.a(r17, r10, r11, r12 - r11);
    L25:
        if (r0 == true) goto L30;
        if (r16 != null) goto L28;
        String r1 = new String(r10, r11, r12 - r11);
    L29:
        a("Value of #FIXED attribute \"" + r13 + "\" (element <" + this.o + ">) not \"" + r17 + "\" as expected, but \"" + r1 + "\"");
        goto L30
    L28:
        r1 = r16;
        goto L29
    L24:
        r0 = r17.equals(r16);
        goto L25
    L5:
        if (this.o == null) goto L8;
        a(com.ctc.wstx.b.a.Z, this.o.toString(), this.v.toString());
    L8:
        return new String(r10, r11, r12 - r11);
    }

    @Override // org.codehaus.stax2.validation.g
    public void a(String r7, String r8, String r9) {
        this.v.a(r9, r7);
        i r10 = (i) ZeusTransformUtils.preCheckCast(this.l.get(this.v), i.class, "com.obric.memorydata.plugin");
        int r11 = this.q;
        this.q = r11 + 1;
        if (r11 < this.p.length) goto L5;
        this.p = (i[]) ZeusTransformUtils.preCheckCast((i[]) ZeusTransformUtils.preCheckCast(com.ctc.wstx.util.c.b(this.p), i[].class, "com.obric.memorydata.plugin"), i[].class, "com.obric.memorydata.plugin");
        this.c = (al[]) ZeusTransformUtils.preCheckCast((al[]) ZeusTransformUtils.preCheckCast(com.ctc.wstx.util.c.b(this.c), al[].class, "com.obric.memorydata.plugin"), al[].class, "com.obric.memorydata.plugin");
    L5:
        i[] r12 = this.p;
        this.o = r10;
        r12[r11] = r10;
        if (r10 != null) goto L8;
    L9:
        a(com.ctc.wstx.b.a.V, this.v.toString());
    L11:
        if (r11 <= 0) goto L13;
        al r0 = this.c[r11 - 1];
    L15:
        if (r0 == null) goto L23;
        if (r10 == null) goto L23;
        String r1 = r0.a(r10.a());
        if (r1 == null) goto L23;
        int r2 = r1.indexOf("$END");
        String r3 = this.p[r11 - 1].toString();
        if (r2 < 0) goto L22;
        r1 = r1.substring(0, r2) + "</" + r3 + ">" + r1.substring(r2 + 4);
    L22:
        a("Validation error, encountered element <" + r10.a() + "> as a child of <" + r3 + ">: " + r1);
    L23:
        this.t = 0;
        this.u = -2;
        if (r10 != null) goto L27;
        this.c[r11] = null;
        this.r = g;
        this.e = false;
    L26:
        this.d = null;
        return;
    L27:
        this.c[r11] = r10.n();
        this.r = r10.g();
        if (this.r != null) goto L30;
        this.r = g;
    L30:
        this.e = r10.k();
        int r13 = r10.h();
        if (r13 == 0) goto L26;
        BitSet r14 = this.f;
        if (r14 != null) goto L36;
        r14 = new BitSet(r13);
        this.f = r14;
    L37:
        this.d = r14;
        return;
    L36:
        r14.clear();
        goto L37
    L13:
        r0 = null;
        goto L15
    L8:
        if (r10.d() == true) goto L11;
        goto L9
    }

    @Override // com.ctc.wstx.d.y
    public final boolean a() {
        return true;
    }

    @Override // org.codehaus.stax2.validation.g
    public int b() {
        i r0 = this.o;
        if (r0 != null) goto L6;
        return 4;
    L6:
        BitSet r1 = this.d;
        if (r1 == null) goto L17;
        int r2 = r0.h();
        int r3 = 0;
    L9:
        int r4 = r1.nextClearBit(r3);
        if (r4 >= r2) goto L17;
        g r5 = (g) ZeusTransformUtils.preCheckCast(r0.i().get(r4), g.class, "com.obric.memorydata.plugin");
        if (r5.e() == false) goto L14;
        a("Required attribute \"{0}\" missing from element <{1}>", r5, r0);
    L15:
        r3 = r4 + 1;
        goto L9
    L14:
        a(r5);
    L17:
        return r0.e();
    }

    @Override // org.codehaus.stax2.validation.g
    public int b(String r4, String r5, String r6) {
        int r7 = this.q - 1;
        if (r7 >= 0) goto L5;
        return 1;
    L5:
        this.q = r7;
        i r8 = this.p[r7];
        this.p[r7] = null;
        al[] r0 = this.c;
        al r2 = r0[r7];
        r0[r7] = null;
        if (r2 == null) goto L10;
        String r1 = r2.b();
        if (r1 == null) goto L10;
        a("Validation error, element </" + r8 + ">: " + r1);
    L10:
        if (r7 >= 1) goto L12;
        return 1;
    L12:
        i r3 = this.p[r7 - 1];
        if (r3 != null) goto L16;
        return 4;
    L16:
        return r3.e();
    }

    @Override // org.codehaus.stax2.validation.g
    public void b(boolean r1) {
        d();
    }

    @Override // com.ctc.wstx.d.y
    public com.ctc.wstx.util.f c() {
        if (this.f3502b != null) goto L6;
        this.f3502b = new com.ctc.wstx.util.f();
    L6:
        return this.f3502b;
    }

    public void d() {
        com.ctc.wstx.util.f r0 = this.f3502b;
        if (r0 == null) goto L8;
        com.ctc.wstx.util.e r1 = r0.a();
        if (r1 == null) goto L9;
        a("Undefined id '" + r1.a() + "': referenced from element <" + r1.c() + ">, attribute '" + r1.d() + "'", r1.b());
        return;
    L9:
        return;
    }
}
