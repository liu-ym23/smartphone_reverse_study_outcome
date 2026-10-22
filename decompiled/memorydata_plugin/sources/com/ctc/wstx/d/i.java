package com.ctc.wstx.d;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final com.ctc.wstx.util.h f3493a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final javax.xml.stream.a f3494b;
    al c;
    int d;
    final boolean e;
    final boolean f;
    HashMap<com.ctc.wstx.util.h, g> g;
    ArrayList<g> h;
    boolean i;
    boolean j;
    boolean k;
    g l;
    g m;
    HashMap<String, g> n;

    private i(javax.xml.stream.a r3, com.ctc.wstx.util.h r4, al r5, int r6, boolean r7, boolean r8) {
        javax.xml.stream.a r9 = (javax.xml.stream.a) ZeusTransformUtils.wrapperContextForParams(r3, javax.xml.stream.a.class, "com.obric.memorydata.plugin");
        this.g = null;
        this.h = null;
        this.i = false;
        this.j = false;
        this.k = false;
        this.n = null;
        this.f3493a = r4;
        this.f3494b = r9;
        this.c = r5;
        this.d = r6;
        this.e = r7;
        this.f = r8;
    }

    private g a(Map<com.ctc.wstx.util.h, g> r9, com.ctc.wstx.g.f r10, g r11, List<g> r12, boolean r13) {
        Map r14 = (Map) ZeusTransformUtils.wrapperContextForParams(r9, Map.class, "com.obric.memorydata.plugin");
        com.ctc.wstx.g.f r2 = (com.ctc.wstx.g.f) ZeusTransformUtils.wrapperContextForParams(r10, com.ctc.wstx.g.f.class, "com.obric.memorydata.plugin");
        List r15 = (List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.memorydata.plugin");
        com.ctc.wstx.util.h r6 = r11.a();
        g r16 = (g) ZeusTransformUtils.preCheckCast(r14.get(r6), g.class, "com.obric.memorydata.plugin");
        if (r16 == null) goto L6;
        r2.a(null, com.ctc.wstx.b.a.c, com.ctc.wstx.b.a.k, r6, this.f3493a);
        return r16;
    L6:
        int r17 = r11.h();
        if (r17 != 2) goto L9;
        if (r13 == true) goto L18;
    L20:
        this.l = r11;
    L21:
        r14.put(r6, r11);
        if (r15 == null) goto L25;
        r15.add(r11);
    L25:
        if (this.i == true) goto L28;
        this.i = r11.d();
    L28:
        if (this.k == true) goto L31;
        this.k = r11.c();
    L31:
        if (this.j == true) goto L35;
        this.j = r11.g();
        return null;
    L35:
        return null;
    L18:
        if (this.l == null) goto L20;
        r2.a("Invalid id attribute \"{0}\" for element <{1}>: already had id attribute \"" + this.l.a() + "\"", r6, this.f3493a);
        goto L20
    L9:
        if (r17 != 7) goto L21;
        if (r13 == true) goto L13;
    L15:
        this.m = r11;
        goto L21
    L13:
        if (this.m == null) goto L15;
        r2.e("Invalid notation attribute '" + r6 + "' for element <" + this.f3493a + ">: already had notation attribute '" + this.m.a() + "'");
        goto L15
    }

    public static i a(com.ctc.wstx.a.b r7, javax.xml.stream.a r8, com.ctc.wstx.util.h r9) {
        return new i((javax.xml.stream.a) ZeusTransformUtils.wrapperContextForParams(r8, javax.xml.stream.a.class, "com.obric.memorydata.plugin"), r9, null, 5, r7.f(), r7.G());
    }

    public static i a(com.ctc.wstx.a.b r7, javax.xml.stream.a r8, com.ctc.wstx.util.h r9, al r10, int r11) {
        javax.xml.stream.a r1 = (javax.xml.stream.a) ZeusTransformUtils.wrapperContextForParams(r8, javax.xml.stream.a.class, "com.obric.memorydata.plugin");
        if (r11 != 5) goto L6;
        com.ctc.wstx.util.g.a("trying to use XMLValidator.CONTENT_ALLOW_UNDEFINED via createDefined()");
    L6:
        return new i(r1, r9, r10, r11, r7.f(), r7.G());
    }

    private void p() {
        if (this.d == 5) goto L6;
        com.ctc.wstx.util.g.a("redefining defined element spec");
        return;
    }

    private List<g> q() {
        ArrayList<g> r0 = this.h;
        if (r0 != null) goto L6;
        ArrayList<g> r1 = new ArrayList();
        this.h = r1;
        return r1;
    L6:
        return r0;
    }

    public g a(com.ctc.wstx.g.f r14, com.ctc.wstx.util.h r15, int r16, aa r17, com.ctc.wstx.util.o r18, boolean r19) {
        com.ctc.wstx.g.f r1 = (com.ctc.wstx.g.f) ZeusTransformUtils.wrapperContextForParams(r14, com.ctc.wstx.g.f.class, "com.obric.memorydata.plugin");
        HashMap<com.ctc.wstx.util.h, g> r2 = this.g;
        if (r2 != null) goto L6;
        r2 = new HashMap();
        this.g = r2;
    L6:
        if (r17.j() == false) goto L8;
        List<g> r3 = q();
    L9:
        if (r3 != null) goto L11;
        int r5 = -1;
    L12:
        int r9 = r5;
        switch(r16) {
            case 0: goto L24;
            case 1: goto L23;
            case 2: goto L22;
            case 3: goto L21;
            case 4: goto L20;
            case 5: goto L19;
            case 6: goto L18;
            case 7: goto L17;
            case 8: goto L16;
            case 9: goto L15;
            default: goto L14;
        };
    L14:
        com.ctc.wstx.util.g.a();
        g r6 = null;
    L26:
        if (a(r2, r1, r6, r3, r19) == null) goto L28;
        return null;
    L28:
        return r6;
    L15:
        r6 = new s(r15, r17, r9, this.e, this.f);
        goto L26
    L16:
        r6 = new r(r15, r17, r9, this.e, this.f);
        goto L26
    L17:
        r6 = new t(r15, r17, r9, this.e, this.f, r18);
        goto L26
    L18:
        r6 = new j(r15, r17, r9, this.e, this.f);
        goto L26
    L19:
        r6 = new k(r15, r17, r9, this.e, this.f);
        goto L26
    L20:
        r6 = new q(r15, r17, r9, this.e, this.f);
        goto L26
    L21:
        r6 = new p(r15, r17, r9, this.e, this.f);
        goto L26
    L22:
        r6 = new o(r15, r17, r9, this.e, this.f);
        goto L26
    L23:
        r6 = new l(r15, r17, r9, this.e, this.f, r18);
        goto L26
    L24:
        r6 = new h(r15, r17, r9, this.e, this.f);
        goto L26
    L11:
        r5 = r3.size();
        goto L12
    L8:
        r3 = null;
        goto L9
    }

    public g a(com.ctc.wstx.g.f r15, com.ctc.wstx.util.h r16, int r17, aa r18, boolean r19) {
        com.ctc.wstx.g.f r1 = (com.ctc.wstx.g.f) ZeusTransformUtils.wrapperContextForParams(r15, com.ctc.wstx.g.f.class, "com.obric.memorydata.plugin");
        if (r17 == 0) goto L5;
        g r2 = new r(r16, r18, -1, this.e, this.f);
    L6:
        String r3 = r16.a();
        if (r3 != null) goto L9;
    L12:
        String r4 = "";
    L13:
        HashMap<String, g> r5 = this.n;
        if (r5 != null) goto L17;
        this.n = new HashMap();
    L20:
        this.n.put(r4, r2);
        return r2;
    L17:
        if (r5.containsKey(r4) == false) goto L20;
        return null;
    L9:
        if (r3.length() == 0) goto L12;
        r4 = r16.b();
        goto L13
    L5:
        r2 = new h(r16, r18, -1, this.e, this.f);
        goto L6
    }

    public i a(javax.xml.stream.a r8, al r9, int r10) {
        javax.xml.stream.a r1 = (javax.xml.stream.a) ZeusTransformUtils.wrapperContextForParams(r8, javax.xml.stream.a.class, "com.obric.memorydata.plugin");
        p();
        if (r10 != 5) goto L5;
        com.ctc.wstx.util.g.a("trying to use CONTENT_ALLOW_UNDEFINED via define()");
    L5:
        i r11 = new i(r1, this.f3493a, r9, r10, this.e, this.f);
        r11.g = this.g;
        r11.h = this.h;
        r11.i = this.i;
        r11.k = this.k;
        r11.j = this.j;
        r11.l = this.l;
        r11.m = this.m;
        r11.n = this.n;
        return r11;
    }

    public com.ctc.wstx.util.h a() {
        return this.f3493a;
    }

    public void a(com.ctc.wstx.g.f r3, i r4, boolean r5) {
        com.ctc.wstx.g.f r6 = (com.ctc.wstx.g.f) ZeusTransformUtils.wrapperContextForParams(r3, com.ctc.wstx.g.f.class, "com.obric.memorydata.plugin");
        if (r5 == false) goto L5;
        p();
    L5:
        this.c = r4.c;
        this.d = r4.d;
        b(r6, r4, r5);
    }

    public String b() {
        return this.f3493a.toString();
    }

    public void b(com.ctc.wstx.g.f r10, i r11, boolean r12) {
        com.ctc.wstx.g.f r13 = (com.ctc.wstx.g.f) ZeusTransformUtils.wrapperContextForParams(r10, com.ctc.wstx.g.f.class, "com.obric.memorydata.plugin");
        HashMap<com.ctc.wstx.util.h, g> r0 = r11.g();
        HashMap<com.ctc.wstx.util.h, g> r2 = this.g;
        if (r2 != null) goto L5;
        r2 = new HashMap();
        this.g = r2;
    L5:
        HashMap<com.ctc.wstx.util.h, g> r8 = r2;
        if (r0 != null) goto L8;
    L19:
        HashMap<String, g> r14 = r11.n;
        if (r14 != null) goto L22;
        return;
    L22:
        if (this.n != null) goto L24;
        this.n = new HashMap();
    L24:
        Iterator<Map.Entry<String, g>> r15 = r14.entrySet().iterator();
    L26:
        if (r15.hasNext() == false) goto L41;
        Map.Entry r16 = (Map.Entry) ZeusTransformUtils.preCheckCast(r15.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        String r17 = (String) ZeusTransformUtils.preCheckCast(r16.getKey(), String.class, "com.obric.memorydata.plugin");
        if (this.n.containsKey(r17) == true) goto L26;
        this.n.put(r17, (g) r16.getValue());
        goto L26
    L41:
        return;
    L8:
        if (r0.size() <= 0) goto L19;
        Iterator<Map.Entry<com.ctc.wstx.util.h, g>> r1 = r0.entrySet().iterator();
    L11:
        if (r1.hasNext() == false) goto L19;
        Map.Entry r3 = (Map.Entry) ZeusTransformUtils.preCheckCast(r1.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        if (r8.containsKey((com.ctc.wstx.util.h) ZeusTransformUtils.preCheckCast(r3.getKey(), com.ctc.wstx.util.h.class, "com.obric.memorydata.plugin")) == true) goto L11;
        g r4 = (g) ZeusTransformUtils.preCheckCast(r3.getValue(), g.class, "com.obric.memorydata.plugin");
        if (r4.f() == false) goto L17;
        List<g> r5 = q();
        r4 = r4.a(r5.size());
    L18:
        a(r8, r13, r4, r5, r12);
        goto L11
    L17:
        r5 = null;
        goto L18
    }

    public javax.xml.stream.a c() {
        return this.f3494b;
    }

    public boolean d() {
        if (this.d == 5) goto L5;
        return true;
    L5:
        return false;
    }

    public int e() {
        return this.d;
    }

    public int f() {
        if (this.d > 1) goto L5;
        return 2;
    L5:
        return 4;
    }

    public HashMap<com.ctc.wstx.util.h, g> g() {
        return this.g;
    }

    public int h() {
        ArrayList<g> r0 = this.h;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.size();
    }

    public List<g> i() {
        return this.h;
    }

    public boolean j() {
        return this.k;
    }

    public boolean k() {
        return this.i;
    }

    public boolean l() {
        return this.j;
    }

    public boolean m() {
        if (this.n == null) goto L5;
        return true;
    L5:
        return false;
    }

    public al n() {
        al r0 = this.c;
        if (r0 != null) goto L6;
        return null;
    L6:
        return r0.a();
    }

    public HashMap<String, g> o() {
        return this.n;
    }

    public String toString() {
        return this.f3493a.toString();
    }
}
