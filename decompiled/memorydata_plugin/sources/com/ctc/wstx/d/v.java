package com.ctc.wstx.d;

import com.ctc.wstx.exc.WstxParsingException;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class v extends u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final boolean f3497a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final boolean f3498b;
    final boolean c;
    final HashMap<String, com.ctc.wstx.e.a> d;
    volatile transient List<com.ctc.wstx.e.a> e;
    final Set<String> f;
    final HashMap<String, com.ctc.wstx.e.a> g;
    final Set<String> h;
    final HashMap<String, javax.xml.stream.a.b> i;
    transient List<javax.xml.stream.a.b> j;
    final HashMap<com.ctc.wstx.util.h, i> k;

    private v(boolean r3, HashMap<String, com.ctc.wstx.e.a> r4, Set<String> r5, HashMap<String, com.ctc.wstx.e.a> r6, Set<String> r7, HashMap<String, javax.xml.stream.a.b> r8, HashMap<com.ctc.wstx.util.h, i> r9, boolean r10) {
        Set<String> r11 = (Set) ZeusTransformUtils.wrapperContextForParams(r5, Set.class, "com.obric.memorydata.plugin");
        Set<String> r12 = (Set) ZeusTransformUtils.wrapperContextForParams(r7, Set.class, "com.obric.memorydata.plugin");
        this.e = null;
        this.j = null;
        this.f3497a = r3;
        this.d = r4;
        this.f = r11;
        this.g = r6;
        this.h = r12;
        this.i = r8;
        this.k = r9;
        this.f3498b = r10;
        if (r9 == null) goto L10;
        Iterator<i> r13 = r9.values().iterator();
    L6:
        if (r13.hasNext() == false) goto L10;
        if (((i) ZeusTransformUtils.preCheckCast(r13.next(), i.class, "com.obric.memorydata.plugin")).m() == false) goto L6;
        boolean r14 = true;
    L11:
        this.c = r14;
        return;
    L10:
        r14 = false;
        goto L11
    }

    public static v a(boolean r11, HashMap<String, com.ctc.wstx.e.a> r12, Set<String> r13, HashMap<String, com.ctc.wstx.e.a> r14, Set<String> r15, HashMap<String, javax.xml.stream.a.b> r16, HashMap<com.ctc.wstx.util.h, i> r17, boolean r18) {
        return new v(r11, r12, (Set) ZeusTransformUtils.wrapperContextForParams(r13, Set.class, "com.obric.memorydata.plugin"), r14, (Set) ZeusTransformUtils.wrapperContextForParams(r15, Set.class, "com.obric.memorydata.plugin"), r16, r17, r18);
    }

    public static void a(i r5, javax.xml.stream.a r6) {
        throw new WstxParsingException(MessageFormat.format(com.ctc.wstx.b.a.Q, new Object[]{r5.b(), r5.c().toString()}), (javax.xml.stream.a) ZeusTransformUtils.wrapperContextForParams(r6, javax.xml.stream.a.class, "com.obric.memorydata.plugin"));
    }

    private void a(com.ctc.wstx.g.f r9, HashMap<com.ctc.wstx.util.h, i> r10, HashMap<com.ctc.wstx.util.h, i> r11) {
        com.ctc.wstx.g.f r12 = (com.ctc.wstx.g.f) ZeusTransformUtils.wrapperContextForParams(r9, com.ctc.wstx.g.f.class, "com.obric.memorydata.plugin");
        Iterator<Map.Entry<com.ctc.wstx.util.h, i>> r13 = r11.entrySet().iterator();
    L4:
        if (r13.hasNext() == false) goto L18;
        Map.Entry r0 = (Map.Entry) ZeusTransformUtils.preCheckCast(r13.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        com.ctc.wstx.util.h r2 = (com.ctc.wstx.util.h) ZeusTransformUtils.preCheckCast(r0.getKey(), com.ctc.wstx.util.h.class, "com.obric.memorydata.plugin");
        i r1 = (i) ZeusTransformUtils.preCheckCast(r0.getValue(), i.class, "com.obric.memorydata.plugin");
        i r3 = (i) ZeusTransformUtils.preCheckCast(r10.get(r2), i.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L7;
        if (r1.d() == true) goto L11;
        if (r3.d() == false) goto L16;
        r3.b(r12, r1, this.f3498b);
        goto L4
    L16:
        r12.a(r3.c(), com.ctc.wstx.b.a.f3451a, com.ctc.wstx.b.a.h, r1.b(), null);
        goto L4
    L11:
        if (r3.d() == true) goto L12;
        r3.a(r12, r1, this.f3498b);
        goto L4
    L12:
        a(r3, r1.c());
        goto L4
    L7:
        r10.put(r2, r1);
        goto L4
    }

    private static void a(HashMap<String, javax.xml.stream.a.b> r4, HashMap<String, javax.xml.stream.a.b> r5) {
        Iterator<Map.Entry<String, javax.xml.stream.a.b>> r6 = r5.entrySet().iterator();
    L4:
        if (r6.hasNext() == false) goto L8;
        Map.Entry r0 = (Map.Entry) ZeusTransformUtils.preCheckCast(r6.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        if (r4.containsKey(r0.getKey()) == false) goto L4;
        a((javax.xml.stream.a.b) ZeusTransformUtils.preCheckCast(r4.get(r0.getKey()), javax.xml.stream.a.b.class, "com.obric.memorydata.plugin"), (javax.xml.stream.a.b) ZeusTransformUtils.preCheckCast(r0.getValue(), javax.xml.stream.a.b.class, "com.obric.memorydata.plugin"));
        goto L4
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static <K, V> void a(Map<K, V> r3, Map<K, V> r4) {
        Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        Iterator<Map.Entry<K, V>> r6 = ((Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin")).entrySet().iterator();
    L4:
        if (r6.hasNext() == false) goto L8;
        Map.Entry r0 = (Map.Entry) ZeusTransformUtils.preCheckCast(r6.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        Object r2 = r0.getKey();
        Object r1 = r5.put(r2, r0.getValue());
        if (r1 == null) goto L4;
        r5.put(r2, r1);
        goto L4
    }

    public static void a(javax.xml.stream.a.b r5, javax.xml.stream.a.b r6) {
        javax.xml.stream.a.b r7 = (javax.xml.stream.a.b) ZeusTransformUtils.wrapperContextForParams(r5, javax.xml.stream.a.b.class, "com.obric.memorydata.plugin");
        javax.xml.stream.a.b r8 = (javax.xml.stream.a.b) ZeusTransformUtils.wrapperContextForParams(r6, javax.xml.stream.a.b.class, "com.obric.memorydata.plugin");
        throw new WstxParsingException(MessageFormat.format(com.ctc.wstx.b.a.R, new Object[]{r8.b(), r7.m().toString()}), r8.m());
    }

    @Override // com.ctc.wstx.d.u
    public u a(com.ctc.wstx.g.f r12, u r13) {
        com.ctc.wstx.g.f r14 = (com.ctc.wstx.g.f) ZeusTransformUtils.wrapperContextForParams(r12, com.ctc.wstx.g.f.class, "com.obric.memorydata.plugin");
        HashMap<String, com.ctc.wstx.e.a> r0 = b();
        HashMap<String, com.ctc.wstx.e.a> r1 = r13.b();
        if (r0 != null) goto L5;
    L12:
        HashMap<String, com.ctc.wstx.e.a> r4 = r1;
    L13:
        HashMap<String, javax.xml.stream.a.b> r2 = d();
        HashMap<String, javax.xml.stream.a.b> r3 = r13.d();
        if (r2 != null) goto L16;
    L23:
        HashMap<String, javax.xml.stream.a.b> r8 = r3;
    L24:
        HashMap<com.ctc.wstx.util.h, i> r5 = e();
        HashMap<com.ctc.wstx.util.h, i> r15 = r13.e();
        if (r5 != null) goto L27;
    L34:
        HashMap<com.ctc.wstx.util.h, i> r9 = r15;
    L36:
        return a(false, r4, null, null, null, r8, r9, this.f3498b);
    L27:
        if (r5.isEmpty() == true) goto L34;
        if (r15 != null) goto L31;
    L33:
        r9 = r5;
        goto L36
    L31:
        if (r15.isEmpty() == true) goto L33;
        a(r14, r5, r15);
        goto L33
    L16:
        if (r2.isEmpty() == true) goto L23;
        if (r3 != null) goto L20;
    L22:
        r8 = r2;
        goto L24
    L20:
        if (r3.isEmpty() == true) goto L22;
        a(r2, r3);
        a(r2, r3);
        goto L22
    L5:
        if (r0.isEmpty() == true) goto L12;
        if (r1 != null) goto L9;
    L11:
        r4 = r0;
        goto L13
    L9:
        if (r1.isEmpty() == true) goto L11;
        a(r0, r1);
        goto L11
    }

    @Override // org.codehaus.stax2.validation.f
    public org.codehaus.stax2.validation.g a(org.codehaus.stax2.validation.b r7) {
        org.codehaus.stax2.validation.b r2 = (org.codehaus.stax2.validation.b) ZeusTransformUtils.wrapperContextForParams(r7, org.codehaus.stax2.validation.b.class, "com.obric.memorydata.plugin");
        if (this.f3498b == false) goto L7;
        return new x(this, r2, this.c, e(), b());
    L7:
        return new w(this, r2, this.c, e(), b());
    }

    @Override // com.ctc.wstx.d.u
    public boolean a() {
        return this.f3497a;
    }

    @Override // com.ctc.wstx.d.u
    public boolean a(u r5) {
        Set<String> r0 = this.h;
        if (r0 != null) goto L5;
    L13:
        Set<String> r4 = this.f;
        if (r4 != null) goto L16;
        return true;
    L16:
        if (r4.size() <= 0) goto L26;
        HashMap<String, com.ctc.wstx.e.a> r6 = r5.b();
        if (r6 != null) goto L20;
        return true;
    L20:
        if (r6.size() > 0) goto L22;
        return true;
    L22:
        if (com.ctc.wstx.util.c.a(r4, r6.keySet()) == false) goto L29;
        return false;
    L29:
        return true;
    L26:
        return true;
    L5:
        if (r0.size() <= 0) goto L13;
        HashMap<String, com.ctc.wstx.e.a> r2 = r5.c();
        if (r2 == null) goto L13;
        if (r2.size() <= 0) goto L13;
        if (com.ctc.wstx.util.c.a(r0, r2.keySet()) == false) goto L13;
        return false;
    }

    @Override // com.ctc.wstx.d.u
    public HashMap<String, com.ctc.wstx.e.a> b() {
        return this.d;
    }

    @Override // com.ctc.wstx.d.u
    public HashMap<String, com.ctc.wstx.e.a> c() {
        return this.g;
    }

    @Override // com.ctc.wstx.d.u
    public HashMap<String, javax.xml.stream.a.b> d() {
        return this.i;
    }

    @Override // com.ctc.wstx.d.u
    public HashMap<com.ctc.wstx.util.h, i> e() {
        return this.k;
    }

    public int f() {
        HashMap<String, com.ctc.wstx.e.a> r0 = this.d;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.size();
    }

    public String toString() {
        return "[DTDSubset: " + f() + " general entities]";
    }
}
