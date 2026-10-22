package com.ctc.wstx.d;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.BitSet;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class w extends y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected boolean f3499a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected BitSet f3500b;
    protected boolean c;
    protected BitSet d;

    public w(u r9, org.codehaus.stax2.validation.b r10, boolean r11, Map<com.ctc.wstx.util.h, i> r12, Map<String, com.ctc.wstx.e.a> r13) {
        super(r9, (org.codehaus.stax2.validation.b) ZeusTransformUtils.wrapperContextForParams(r10, org.codehaus.stax2.validation.b.class, "com.obric.memorydata.plugin"), r11, (Map) ZeusTransformUtils.wrapperContextForParams(r12, Map.class, "com.obric.memorydata.plugin"), (Map) ZeusTransformUtils.wrapperContextForParams(r13, Map.class, "com.obric.memorydata.plugin"));
        this.f3499a = false;
        this.f3500b = null;
        this.c = false;
    }

    @Override // org.codehaus.stax2.validation.g
    public String a(String r2, String r3, String r4, String r5) {
        g r6 = (g) ZeusTransformUtils.preCheckCast(this.r.get(this.v.a(r4, r2)), g.class, "com.obric.memorydata.plugin");
        int r7 = this.t;
        this.t = r7 + 1;
        if (r7 < this.s.length) goto L5;
        this.s = (g[]) ZeusTransformUtils.preCheckCast((g[]) ZeusTransformUtils.preCheckCast(com.ctc.wstx.util.c.b(this.s), g[].class, "com.obric.memorydata.plugin"), g[].class, "com.obric.memorydata.plugin");
    L5:
        this.s[r7] = r6;
        if (r6 != null) goto L8;
        return null;
    L8:
        if (this.f3499a == false) goto L15;
        int r8 = r6.b();
        if (r8 < 0) goto L16;
        this.f3500b.set(r8);
        return null;
    L16:
        return null;
    L15:
        return null;
    }

    @Override // org.codehaus.stax2.validation.g
    public String a(String r3, String r4, String r5, char[] r6, int r7, int r8) {
        g r9 = (g) ZeusTransformUtils.preCheckCast(this.r.get(this.v.a(r5, r3)), g.class, "com.obric.memorydata.plugin");
        int r10 = this.t;
        this.t = r10 + 1;
        if (r10 < this.s.length) goto L5;
        this.s = (g[]) ZeusTransformUtils.preCheckCast((g[]) ZeusTransformUtils.preCheckCast(com.ctc.wstx.util.c.b(this.s), g[].class, "com.obric.memorydata.plugin"), g[].class, "com.obric.memorydata.plugin");
    L5:
        this.s[r10] = r9;
        if (r9 != null) goto L8;
        return null;
    L8:
        if (this.f3499a == false) goto L13;
        int r11 = r9.b();
        if (r11 < 0) goto L13;
        this.f3500b.set(r11);
    L13:
        if (this.c == true) goto L15;
        return null;
    L15:
        return r9.a(this, r6, r7, r8);
    }

    @Override // org.codehaus.stax2.validation.g
    public void a(String r3, String r4, String r5) {
        this.v.a(r5, r3);
        i r6 = (i) ZeusTransformUtils.preCheckCast(this.l.get(this.v), i.class, "com.obric.memorydata.plugin");
        int r7 = this.q;
        this.q = r7 + 1;
        if (r7 < this.p.length) goto L5;
        this.p = (i[]) ZeusTransformUtils.preCheckCast((i[]) ZeusTransformUtils.preCheckCast(com.ctc.wstx.util.c.b(this.p), i[].class, "com.obric.memorydata.plugin"), i[].class, "com.obric.memorydata.plugin");
    L5:
        i[] r8 = this.p;
        this.o = r6;
        r8[r7] = r6;
        boolean r9 = false;
        this.t = 0;
        this.u = -2;
        if (r6 != null) goto L9;
    L7:
        this.r = g;
        this.f3499a = false;
        this.f3500b = null;
        this.c = false;
        return;
    L9:
        this.r = r6.g();
        if (this.r == null) goto L7;
        if (this.n == false) goto L15;
    L16:
        r9 = true;
    L17:
        this.c = r9;
        boolean r10 = r6.l();
        this.f3499a = r10;
        if (r10 == false) goto L24;
        int r11 = r6.h();
        BitSet r12 = this.d;
        if (r12 != null) goto L22;
        r12 = new BitSet(r11);
        this.d = r12;
    L23:
        this.f3500b = r12;
        return;
    L22:
        r12.clear();
        goto L23
    L24:
        this.f3500b = null;
        return;
    L15:
        if (r6.j() == false) goto L17;
        goto L16
    }

    @Override // com.ctc.wstx.d.y
    public void a(boolean r1) {
    }

    @Override // com.ctc.wstx.d.y
    public final boolean a() {
        return false;
    }

    @Override // org.codehaus.stax2.validation.g
    public int b() {
        i r0 = this.o;
        if (r0 != null) goto L7;
        return 4;
    L7:
        if (this.f3499a == false) goto L16;
        BitSet r1 = this.f3500b;
        int r2 = r0.h();
        int r3 = 0;
    L9:
        int r4 = r1.nextClearBit(r3);
        if (r4 >= r2) goto L16;
        g r5 = (g) ZeusTransformUtils.preCheckCast(r0.i().get(r4), g.class, "com.obric.memorydata.plugin");
        if (r5.g() == false) goto L14;
        a(r5);
    L14:
        r3 = r4 + 1;
    L16:
        return r0.f();
    }

    @Override // org.codehaus.stax2.validation.g
    public int b(String r2, String r3, String r4) {
        int r5 = this.q - 1;
        this.q = r5;
        this.p[r5] = null;
        if (r5 >= 1) goto L5;
        return 4;
    L5:
        int r6 = r5 - 1;
        if (this.p[r6] != null) goto L9;
        return 4;
    L9:
        return this.p[r6].f();
    }

    @Override // org.codehaus.stax2.validation.g
    public void b(boolean r1) {
    }

    @Override // com.ctc.wstx.d.y
    public com.ctc.wstx.util.f c() {
        com.ctc.wstx.util.g.a();
        return null;
    }
}
