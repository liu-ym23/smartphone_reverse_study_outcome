package com.ctc.wstx.d;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.text.MessageFormat;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public abstract class y extends org.codehaus.stax2.validation.g implements com.ctc.wstx.g.g {
    protected static final HashMap<com.ctc.wstx.util.h, g> g = null;
    protected static final HashMap<String, com.ctc.wstx.e.a> h = null;
    final boolean i;
    final u j;
    final org.codehaus.stax2.validation.b k;
    final Map<com.ctc.wstx.util.h, i> l;
    final Map<String, com.ctc.wstx.e.a> m;
    protected boolean n;
    protected i o;
    protected i[] p;
    protected int q;
    protected HashMap<com.ctc.wstx.util.h, g> r;
    protected g[] s;
    protected int t;
    protected int u;
    protected final transient com.ctc.wstx.util.h v;
    char[] w;

    static {
        g = new HashMap();
        h = new HashMap();
    }

    public y(u r5, org.codehaus.stax2.validation.b r6, boolean r7, Map<com.ctc.wstx.util.h, i> r8, Map<String, com.ctc.wstx.e.a> r9) {
        org.codehaus.stax2.validation.b r10 = (org.codehaus.stax2.validation.b) ZeusTransformUtils.wrapperContextForParams(r6, org.codehaus.stax2.validation.b.class, "com.obric.memorydata.plugin");
        Map<com.ctc.wstx.util.h, i> r11 = (Map) ZeusTransformUtils.wrapperContextForParams(r8, Map.class, "com.obric.memorydata.plugin");
        Map<String, com.ctc.wstx.e.a> r12 = (Map) ZeusTransformUtils.wrapperContextForParams(r9, Map.class, "com.obric.memorydata.plugin");
        this.o = null;
        this.p = null;
        this.q = 0;
        this.r = null;
        this.s = new g[16];
        this.t = 0;
        this.u = -1;
        this.v = new com.ctc.wstx.util.h(null, null);
        this.w = null;
        this.j = r5;
        this.k = r10;
        this.i = r7;
        if (r11 != null) goto L5;
    L8:
        this.l = Collections.emptyMap();
    L9:
        this.m = r12;
        this.n = true;
        this.p = new i[16];
        return;
    L5:
        if (r11.size() == 0) goto L8;
        this.l = r11;
        goto L9
    }

    public void a(g r7) {
        String r0 = r7.a(this.k, this);
        if (r0 != null) goto L5;
        com.ctc.wstx.util.g.a("null default attribute value");
    L5:
        com.ctc.wstx.util.h r1 = r7.a();
        String r2 = r1.a();
        String r3 = "";
        if (r2 != null) goto L8;
    L16:
        int r4 = this.k.a(r1.b(), r3, r2, r0);
        if (r4 < 0) goto L29;
    L19:
        g[] r5 = this.s;
        if (r4 < r5.length) goto L22;
        this.s = (g[]) ZeusTransformUtils.preCheckCast((g[]) ZeusTransformUtils.preCheckCast(com.ctc.wstx.util.c.b(r5), g[].class, "com.obric.memorydata.plugin"), g[].class, "com.obric.memorydata.plugin");
    L22:
        int r6 = this.t;
        if (r6 >= r4) goto L25;
        g[] r8 = this.s;
        this.t = r6 + 1;
        r8[r6] = null;
        goto L22
    L25:
        this.s[r4] = r7;
        this.t = r4 + 1;
        return;
    L29:
        return;
    L8:
        if (r2.length() <= 0) goto L16;
        String r9 = this.k.getNamespaceURI(r2);
        if (r9 != null) goto L12;
    L15:
        a("Unbound namespace prefix \"{0}\" for default attribute \"{1}\"", r2, r7);
        goto L16
    L12:
        if (r9.length() == 0) goto L15;
        r3 = r9;
        goto L16
    }

    @Override // com.ctc.wstx.g.g
    public void a(com.ctc.wstx.g.e r6) {
        HashMap<String, g> r0 = this.o.o();
        if (r0 == null) goto L10;
        Iterator<Map.Entry<String, g>> r1 = r0.entrySet().iterator();
    L6:
        if (r1.hasNext() == false) goto L16;
        Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r1.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        String r3 = (String) ZeusTransformUtils.preCheckCast(r2.getKey(), String.class, "com.obric.memorydata.plugin");
        if (r6.a(r3) == true) goto L6;
        r6.b(r3, ((g) ZeusTransformUtils.preCheckCast(r2.getValue(), g.class, "com.obric.memorydata.plugin")).a(this.k, this));
        goto L6
    L16:
        return;
    }

    void a(String r2) {
        b(r2, null);
    }

    void a(String r3, Object r4) {
        b(MessageFormat.format(r3, new Object[]{r4}), null);
    }

    void a(String r3, Object r4, Object r5) {
        b(MessageFormat.format(r3, new Object[]{r4, r5}), null);
    }

    void a(String r3, javax.xml.stream.a r4) {
        b(r3, (javax.xml.stream.a) ZeusTransformUtils.wrapperContextForParams(r4, javax.xml.stream.a.class, "com.obric.memorydata.plugin"));
    }

    @Override // org.codehaus.stax2.validation.g
    public void a(String r1, boolean r2) {
    }

    public void a(boolean r1) {
        this.n = r1;
    }

    @Override // org.codehaus.stax2.validation.g
    public void a(char[] r1, int r2, int r3, boolean r4) {
    }

    public abstract boolean a();

    @Override // com.ctc.wstx.g.g
    public boolean a(String r2, String r3) {
        this.v.a(r2, r3);
        i r4 = (i) ZeusTransformUtils.preCheckCast(this.l.get(this.v), i.class, "com.obric.memorydata.plugin");
        this.o = r4;
        if (r4 != null) goto L5;
    L7:
        return false;
    L5:
        if (r4.m() == false) goto L7;
        return true;
    }

    char[] a(int r2) {
        char[] r0 = this.w;
        if (r0 == null) goto L7;
        if (r0.length < r2) goto L7;
    L11:
        return this.w;
    L7:
        if (r2 >= 100) goto L9;
        r2 = 100;
    L9:
        this.w = new char[r2];
        goto L11
    }

    public void b(String r3, javax.xml.stream.a r4) {
        javax.xml.stream.a r5 = (javax.xml.stream.a) ZeusTransformUtils.wrapperContextForParams(r4, javax.xml.stream.a.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L5;
        r5 = f();
    L5:
        org.codehaus.stax2.validation.e r0 = new org.codehaus.stax2.validation.e(r5, r3, 2);
        r0.a(this);
        this.k.a(r0);
    }

    public abstract com.ctc.wstx.util.f c();

    com.ctc.wstx.util.h e() {
        return this.p[this.q - 1].a();
    }

    javax.xml.stream.a f() {
        return this.k.g();
    }

    Map<String, com.ctc.wstx.e.a> g() {
        return this.m;
    }

    public boolean h() {
        return this.i;
    }
}
