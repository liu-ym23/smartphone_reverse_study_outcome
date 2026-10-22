package com.ctc.wstx.a;

import com.ctc.wstx.d.m;
import com.ctc.wstx.io.e;
import com.ctc.wstx.util.k;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.SoftReference;
import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.xml.stream.d;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends a {
    static final ThreadLocal<SoftReference<e>> A = null;
    static final HashMap<String, Integer> c = null;
    e B;
    protected final boolean d;
    protected final k e;
    protected int f;
    protected int g;
    protected int h;
    protected int i;
    protected int j;
    protected int k;
    protected int l;
    protected int m;
    protected long n;
    protected long o;
    protected int p;
    protected int q;
    protected long r;
    protected int s;
    protected URL t;
    protected c.a u;
    protected boolean v;
    javax.xml.stream.c w;
    d x;
    d y;
    Object[] z;

    static {
        HashMap<String, Integer> r0 = new HashMap(64);
        c = r0;
        r0.put("javax.xml.stream.isCoalescing", 1);
        r0.put("javax.xml.stream.isNamespaceAware", 2);
        r0.put("javax.xml.stream.isReplacingEntityReferences", 3);
        r0.put("javax.xml.stream.isSupportingExternalEntities", 4);
        r0.put("javax.xml.stream.isValidating", 5);
        r0.put("javax.xml.stream.supportDTD", 6);
        r0.put("javax.xml.stream.allocator", 7);
        r0.put("javax.xml.stream.reporter", 8);
        r0.put("javax.xml.stream.resolver", 9);
        r0.put("org.codehaus.stax2.internNames", 21);
        r0.put("org.codehaus.stax2.internNsUris", 20);
        r0.put("http://java.sun.com/xml/stream/properties/report-cdata-event", 22);
        r0.put("org.codehaus.stax2.reportPrologWhitespace", 23);
        r0.put("org.codehaus.stax2.preserveLocation", 24);
        r0.put("org.codehaus.stax2.closeInputSource", 25);
        r0.put("org.codehaus.stax2.supportXmlId", 26);
        r0.put("org.codehaus.stax2.propDtdOverride", 27);
        r0.put("http://javax.xml.XMLConstants/feature/secure-processing", 30);
        r0.put("com.ctc.wstx.cacheDTDs", 42);
        r0.put("com.ctc.wstx.cacheDTDsByPublicId", 43);
        r0.put("com.ctc.wstx.lazyParsing", 44);
        r0.put("com.ctc.wstx.treatCharRefsAsEnts", 46);
        r0.put("com.ctc.wstx.allowXml11EscapedCharsInXml10", 47);
        r0.put("com.ctc.wstx.normalizeLFs", 40);
        r0.put("com.ctc.wstx.inputBufferLength", 50);
        r0.put("com.ctc.wstx.minTextSegment", 52);
        r0.put("com.ctc.wstx.maxAttributesPerElement", 60);
        r0.put("com.ctc.wstx.maxAttributeSize", 65);
        r0.put("com.ctc.wstx.maxChildrenPerElement", 61);
        r0.put("com.ctc.wstx.maxTextLength", 66);
        r0.put("com.ctc.wstx.maxElementCount", 62);
        r0.put("com.ctc.wstx.maxElementDepth", 63);
        r0.put("com.ctc.wstx.maxEntityDepth", 68);
        r0.put("com.ctc.wstx.maxEntityCount", 67);
        r0.put("com.ctc.wstx.maxDtdDepth", 69);
        r0.put("com.ctc.wstx.maxCharacters", 64);
        r0.put("com.ctc.wstx.customInternalEntities", 53);
        r0.put("com.ctc.wstx.dtdResolver", 54);
        r0.put("com.ctc.wstx.entityResolver", 55);
        r0.put("com.ctc.wstx.undeclaredEntityResolver", 56);
        r0.put("com.ctc.wstx.baseURL", 57);
        r0.put("com.ctc.wstx.fragmentMode", 58);
        A = new ThreadLocal();
    }

    private b(b r5, boolean r6, k r7, int r8, int r9, int r10, int r11) {
        super(r5);
        this.j = 1000;
        this.k = 524288;
        this.l = Integer.MAX_VALUE;
        this.m = 1000;
        this.n = Long.MAX_VALUE;
        this.o = Long.MAX_VALUE;
        this.p = Integer.MAX_VALUE;
        this.q = 500;
        this.r = 100000;
        this.s = 500;
        this.u = c.f3448a;
        this.v = false;
        this.x = null;
        this.y = null;
        this.z = null;
        this.B = null;
        this.d = r6;
        this.e = r7;
        this.f = r8;
        this.g = r9;
        this.h = r10;
        this.i = r11;
        if (r5 == null) goto L5;
        this.j = r5.j;
        this.k = r5.k;
        this.l = r5.l;
        this.n = r5.n;
        this.m = r5.m;
        this.o = r5.o;
        this.p = r5.p;
        this.q = r5.q;
        this.r = r5.r;
        this.s = r5.s;
    L5:
        SoftReference r12 = (SoftReference) ZeusTransformUtils.preCheckCast(A.get(), SoftReference.class, "com.obric.memorydata.plugin");
        if (r12 == null) goto L9;
        this.B = (e) ZeusTransformUtils.preCheckCast(r12.get(), e.class, "com.obric.memorydata.plugin");
        return;
    }

    private e K() {
        e r2 = new e();
        A.set(new SoftReference(r2));
        return r2;
    }

    private final void a(int r2, Object r3) {
        if (this.z != null) goto L5;
        this.z = new Object[4];
    L5:
        this.z[r2] = r3;
    }

    private void a(int r2, boolean r3) {
        if (r3 == false) goto L4;
        int r4 = this.f | r2;
    L5:
        this.f = r4;
        this.g = r2 | this.g;
        return;
    L4:
        r4 = this.f & (~r2);
        goto L5
    }

    public static b b() {
        return new b(null, false, null, 2973213, 0, 4000, 64);
    }

    private final Object o(int r1) {
        Object[] r0 = this.z;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0[r1];
    }

    public d A() {
        return this.x;
    }

    public d B() {
        return this.y;
    }

    public d C() {
        return (d) ZeusTransformUtils.preCheckCast(o(1), d.class, "com.obric.memorydata.plugin");
    }

    public URL D() {
        return this.t;
    }

    public boolean E() {
        if (this.u != c.c) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean F() {
        if (this.u != c.f3449b) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean G() {
        return this.v;
    }

    public m H() {
        return (m) ZeusTransformUtils.preCheckCast(o(2), m.class, "com.obric.memorydata.plugin");
    }

    public org.codehaus.stax2.validation.a I() {
        return (org.codehaus.stax2.validation.a) ZeusTransformUtils.preCheckCast(o(3), org.codehaus.stax2.validation.a.class, "com.obric.memorydata.plugin");
    }

    public boolean J() {
        if (n(2) == false) goto L5;
    L7:
        return false;
    L5:
        if ((this.g & 2) == 0) goto L7;
        return true;
    }

    public b a(k r10) {
        b r8 = new b(this, this.d, r10, this.f, this.g, this.h, this.i);
        r8.w = this.w;
        r8.x = this.x;
        r8.y = this.y;
        r8.t = this.t;
        r8.u = this.u;
        r8.j = this.j;
        r8.k = this.k;
        r8.l = this.l;
        r8.n = this.n;
        r8.o = this.o;
        r8.p = this.p;
        r8.m = this.m;
        r8.q = this.q;
        r8.r = this.r;
        r8.s = this.s;
        Object[] r9 = this.z;
        if (r9 == null) goto L5;
        int r11 = r9.length;
        Object[] r0 = new Object[r11];
        System.arraycopy(r9, 0, r0, 0, r11);
        r8.z = r0;
    L5:
        return r8;
    }

    public void a(int r2) {
        if (r2 >= 8) goto L5;
        r2 = 8;
    L5:
        this.h = r2;
    }

    public void a(long r1) {
        this.n = r1;
    }

    public void a(c.a r1) {
        this.u = r1;
    }

    public void a(URL r1) {
        this.t = r1;
    }

    public void a(Map<String, ?> r7) {
        Map r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r7, Map.class, "com.obric.memorydata.plugin");
        if (r8 != null) goto L5;
    L18:
        Map r3 = Collections.emptyMap();
    L19:
        a(0, r3);
        return;
    L5:
        if (r8.size() < 1) goto L18;
        int r1 = r8.size();
        r3 = new HashMap(r1 + (r1 >> 1), 0.75f);
        Iterator r9 = r8.entrySet().iterator();
    L9:
        if (r9.hasNext() == false) goto L19;
        Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r9.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        Object r4 = r2.getValue();
        if (r4 != null) goto L14;
        char[] r5 = com.ctc.wstx.util.c.a();
    L17:
        String r6 = (String) ZeusTransformUtils.preCheckCast(r2.getKey(), String.class, "com.obric.memorydata.plugin");
        r3.put(r6, com.ctc.wstx.e.c.a(r6, r5));
        goto L9
    L14:
        if ((r4 instanceof char[]) == false) goto L16;
        r5 = (char[]) ZeusTransformUtils.preCheckCast((char[]) ZeusTransformUtils.preCheckCast(r4, char[].class, "com.obric.memorydata.plugin"), char[].class, "com.obric.memorydata.plugin");
        goto L17
    L16:
        r5 = r4.toString().toCharArray();
        goto L17
    }

    public void a(javax.xml.stream.c r3) {
        this.w = (javax.xml.stream.c) ZeusTransformUtils.wrapperContextForParams(r3, javax.xml.stream.c.class, "com.obric.memorydata.plugin");
    }

    public void a(d r3) {
        d r4 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.memorydata.plugin");
        this.y = r4;
        this.x = r4;
    }

    public void a(org.codehaus.stax2.validation.a r3) {
        a(3, (org.codehaus.stax2.validation.a) ZeusTransformUtils.wrapperContextForParams(r3, org.codehaus.stax2.validation.a.class, "com.obric.memorydata.plugin"));
    }

    public void a(boolean r2) {
        a(2, r2);
    }

    public void a(byte[] r2) {
        if (this.B != null) goto L5;
        this.B = K();
    L5:
        this.B.a(r2);
    }

    public void a(char[] r2) {
        if (this.B != null) goto L5;
        this.B = K();
    L5:
        this.B.a(r2);
    }

    @Override // com.ctc.wstx.a.a
    public /* bridge */ /* synthetic */ boolean a() {
        return super.a();
    }

    @Override // com.ctc.wstx.a.a
    public boolean a(String r5, int r6, Object r7) {
        if (r6 != 30) goto L5;
        g(com.ctc.wstx.util.a.a(r5, r7));
    L83:
        return true;
    L5:
        if (r6 != 40) goto L7;
        s(com.ctc.wstx.util.a.a(r5, r7));
        goto L83
    L7:
        if (r6 != 50) goto L9;
        a(com.ctc.wstx.util.a.a(r5, r7, 1));
        goto L83
    L9:
        if (r6 != 46) goto L11;
        q(com.ctc.wstx.util.a.a(r5, r7));
        goto L83
    L11:
        if (r6 == 47) goto L78;
        boolean r0 = false;
        switch(r6) {
            case 1: goto L77;
            case 2: goto L76;
            case 3: goto L75;
            case 4: goto L74;
            case 5: goto L73;
            case 6: goto L72;
            case 7: goto L71;
            case 8: goto L70;
            case 9: goto L69;
            default: goto L14;
        };
    L14:
        switch(r6) {
            case 20: goto L68;
            case 21: goto L67;
            case 22: goto L66;
            case 23: goto L65;
            case 24: goto L64;
            case 25: goto L63;
            case 26: goto L52;
            case 27: goto L50;
            default: goto L15;
        };
    L15:
        switch(r6) {
            case 42: goto L49;
            case 43: goto L48;
            case 44: goto L47;
            default: goto L16;
        };
    L16:
        switch(r6) {
            case 52: goto L46;
            case 53: goto L45;
            case 54: goto L44;
            case 55: goto L43;
            case 56: goto L42;
            case 57: goto L32;
            case 58: goto L31;
            default: goto L18;
        };
    L31:
        a((c.a) ZeusTransformUtils.preCheckCast(r7, c.a.class, "com.obric.memorydata.plugin"));
        goto L83
    L32:
        if (r7 != null) goto L35;
        URL r8 = null;
    L38:
        a(r8);
        goto L83
    L35:
        if (ZeusTransformUtils.instanceOf(r7, URL.class) == false) goto L84;
        r8 = (URL) ZeusTransformUtils.preCheckCast(r7, URL.class, "com.obric.memorydata.plugin");
        goto L38
    L84:
        r8 = new URL(r7.toString());     // Catch: Exception -> L39
    L39:
        e = move-exception;
        throw new IllegalArgumentException(e.getMessage(), e);
    L42:
        d((d) ZeusTransformUtils.preCheckCast(r7, d.class, "com.obric.memorydata.plugin"));
        goto L83
    L43:
        c((d) ZeusTransformUtils.preCheckCast(r7, d.class, "com.obric.memorydata.plugin"));
        goto L83
    L44:
        b((d) ZeusTransformUtils.preCheckCast(r7, d.class, "com.obric.memorydata.plugin"));
        goto L83
    L45:
        a((Map) ZeusTransformUtils.preCheckCast(r7, Map.class, "com.obric.memorydata.plugin"));
        goto L83
    L46:
        b(com.ctc.wstx.util.a.a(r5, r7, 1));
        goto L83
    L18:
        switch(r6) {
            case 60: goto L30;
            case 61: goto L29;
            case 62: goto L28;
            case 63: goto L27;
            case 64: goto L26;
            case 65: goto L25;
            case 66: goto L24;
            case 67: goto L23;
            case 68: goto L22;
            case 69: goto L21;
            default: goto L20;
        };
    L21:
        i(com.ctc.wstx.util.a.a(r5, r7, 1));
        goto L83
    L22:
        h(com.ctc.wstx.util.a.a(r5, r7, 1));
        goto L83
    L23:
        c(com.ctc.wstx.util.a.a(r5, r7, 1));
        goto L83
    L24:
        g(com.ctc.wstx.util.a.a(r5, r7, 1));
        goto L83
    L25:
        d(com.ctc.wstx.util.a.a(r5, r7, 1));
        goto L83
    L26:
        b(com.ctc.wstx.util.a.a(r5, r7, 1));
        goto L83
    L27:
        f(com.ctc.wstx.util.a.a(r5, r7, 1));
        goto L83
    L28:
        a(com.ctc.wstx.util.a.a(r5, r7, 1));
        goto L83
    L29:
        e(com.ctc.wstx.util.a.a(r5, r7, 1));
        goto L83
    L30:
        c(com.ctc.wstx.util.a.a(r5, r7, 1));
        goto L83
    L20:
        throw new IllegalStateException("Internal error: no handler for property with internal id " + r6 + ".");
    L47:
        n(com.ctc.wstx.util.a.a(r5, r7));
        goto L83
    L48:
        m(com.ctc.wstx.util.a.a(r5, r7));
        goto L83
    L49:
        l(com.ctc.wstx.util.a.a(r5, r7));
        goto L83
    L50:
        a((org.codehaus.stax2.validation.a) ZeusTransformUtils.preCheckCast(r7, org.codehaus.stax2.validation.a.class, "com.obric.memorydata.plugin"));
        goto L83
    L63:
        p(com.ctc.wstx.util.a.a(r5, r7));
        goto L83
    L64:
        o(com.ctc.wstx.util.a.a(r5, r7));
        goto L83
    L65:
        j(com.ctc.wstx.util.a.a(r5, r7));
        goto L83
    L66:
        k(com.ctc.wstx.util.a.a(r5, r7));
        goto L83
    L67:
        h(com.ctc.wstx.util.a.a(r5, r7));
        goto L83
    L68:
        i(com.ctc.wstx.util.a.a(r5, r7));
        goto L83
    L52:
        if ("disable".equals(r7) == false) goto L55;
        boolean r9 = false;
    L60:
        a(2097152, r0);
        a(4194304, r9);
        goto L83
    L55:
        if ("xmlidTyping".equals(r7) == false) goto L58;
        r9 = false;
        r0 = true;
        goto L60
    L58:
        if ("xmlidFull".equals(r7) == false) goto L62;
        r9 = true;
        r0 = true;
        goto L60
    L62:
        throw new IllegalArgumentException("Illegal argument ('" + r7 + "') to set property org.codehaus.stax2.supportXmlId to: has to be one of 'disable', 'xmlidTyping' or 'xmlidFull'");
    L69:
        a((d) ZeusTransformUtils.preCheckCast(r7, d.class, "com.obric.memorydata.plugin"));
        goto L83
    L70:
        a((javax.xml.stream.c) ZeusTransformUtils.preCheckCast(r7, javax.xml.stream.c.class, "com.obric.memorydata.plugin"));
        goto L83
    L71:
        return false;
    L72:
        e(com.ctc.wstx.util.a.a(r5, r7));
        goto L83
    L73:
        f(com.ctc.wstx.util.a.a(r5, r7));
        goto L83
    L74:
        d(com.ctc.wstx.util.a.a(r5, r7));
        goto L83
    L75:
        c(com.ctc.wstx.util.a.a(r5, r7));
        goto L83
    L76:
        b(com.ctc.wstx.util.a.a(r5, r7));
        goto L83
    L77:
        a(com.ctc.wstx.util.a.a(r5, r7));
        goto L83
    L78:
        r(com.ctc.wstx.util.a.a(r5, r7));
        goto L83
    }

    @Override // com.ctc.wstx.a.a
    public /* bridge */ /* synthetic */ boolean a(String r1, Object r2) {
        return super.a(r1, r2);
    }

    @Override // com.ctc.wstx.a.a
    public int b(String r2) {
        Integer r1 = (Integer) ZeusTransformUtils.preCheckCast(c.get(r2), Integer.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L6;
        return -1;
    L6:
        return r1.intValue();
    }

    public void b(int r1) {
        this.i = r1;
    }

    public void b(long r1) {
        this.o = r1;
    }

    public void b(d r3) {
        this.x = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.memorydata.plugin");
    }

    public void b(boolean r2) {
        a(1, r2);
    }

    public void b(char[] r2) {
        if (this.B != null) goto L5;
        this.B = K();
    L5:
        this.B.b(r2);
    }

    public k c() {
        return this.e;
    }

    public void c(int r1) {
        this.j = r1;
    }

    public void c(long r1) {
        this.r = r1;
    }

    public void c(d r3) {
        this.y = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.memorydata.plugin");
    }

    public void c(boolean r2) {
        a(4, r2);
    }

    public void c(char[] r2) {
        if (this.B != null) goto L5;
        this.B = K();
    L5:
        this.B.c(r2);
    }

    public int d() {
        if (this.d == false) goto L5;
        return 5;
    L5:
        return 12;
    }

    public com.ctc.wstx.e.a d(String r3) {
        Map r2 = (Map) ZeusTransformUtils.preCheckCast(o(0), Map.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L7;
        return null;
    L7:
        return (com.ctc.wstx.e.a) ZeusTransformUtils.preCheckCast(r2.get(r3), com.ctc.wstx.e.a.class, "com.obric.memorydata.plugin");
    }

    public void d(int r1) {
        this.k = r1;
    }

    public void d(d r3) {
        a(1, (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.memorydata.plugin"));
    }

    public void d(boolean r2) {
        a(8, r2);
    }

    public int e() {
        return this.f;
    }

    public void e(int r1) {
        this.l = r1;
    }

    public void e(boolean r2) {
        a(16, r2);
    }

    public void f(int r1) {
        this.m = r1;
    }

    public void f(boolean r2) {
        a(32, r2);
    }

    public boolean f() {
        return n(1);
    }

    public void g(int r1) {
        this.p = r1;
    }

    public void g(boolean r2) {
        a(33554432, r2);
        if (r2 == false) goto L6;
        d(false);
        return;
    }

    public boolean g() {
        return n(8);
    }

    public void h(int r1) {
        this.q = r1;
    }

    public void h(boolean r2) {
        a(1024, r2);
    }

    public boolean h() {
        return n(2048);
    }

    public void i(int r1) {
        this.s = r1;
    }

    public void i(boolean r2) {
        a(2048, r2);
    }

    public boolean i() {
        return n(8192);
    }

    public void j(boolean r2) {
        a(256, r2);
    }

    public boolean j() {
        return n(2097152);
    }

    public char[] j(int r1) {
        e r0 = this.B;
        if (r0 == null) goto L8;
        char[] r2 = r0.a(r1);
        if (r2 == null) goto L8;
        return r2;
    L8:
        return new char[r1];
    }

    public void k(boolean r2) {
        a(512, r2);
    }

    public boolean k() {
        return n(16384);
    }

    public char[] k(int r1) {
        e r0 = this.B;
        if (r0 == null) goto L8;
        char[] r2 = r0.b(r1);
        if (r2 == null) goto L8;
        return r2;
    L8:
        return new char[r1];
    }

    public void l(boolean r2) {
        a(65536, r2);
    }

    public boolean l() {
        return n(8388608);
    }

    public char[] l(int r1) {
        e r0 = this.B;
        if (r0 == null) goto L8;
        char[] r2 = r0.c(r1);
        if (r2 == null) goto L8;
        return r2;
    L8:
        return new char[r1];
    }

    public void m(boolean r2) {
        a(131072, r2);
    }

    public boolean m() {
        return n(16777216);
    }

    public byte[] m(int r1) {
        e r0 = this.B;
        if (r0 == null) goto L8;
        byte[] r2 = r0.d(r1);
        if (r2 == null) goto L8;
        return r2;
    L8:
        return new byte[r1];
    }

    public int n() {
        return this.h;
    }

    public void n(boolean r2) {
        a(262144, r2);
    }

    public boolean n(int r1) {
        if ((this.f & r1) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public int o() {
        return this.i;
    }

    public void o(boolean r2) {
        a(4096, r2);
    }

    public int p() {
        return this.j;
    }

    public void p(boolean r2) {
        a(8192, r2);
    }

    public int q() {
        return this.k;
    }

    public void q(boolean r2) {
        a(8388608, r2);
    }

    public int r() {
        return this.l;
    }

    public void r(boolean r2) {
        a(16777216, r2);
    }

    public int s() {
        return this.m;
    }

    public void s(boolean r2) {
        a(16384, r2);
    }

    public long t() {
        return this.n;
    }

    public void t(boolean r1) {
        this.v = r1;
    }

    public int u() {
        return this.q;
    }

    public long v() {
        return this.r;
    }

    public int w() {
        return this.s;
    }

    public long x() {
        return this.o;
    }

    public long y() {
        return this.p;
    }

    public javax.xml.stream.c z() {
        return this.w;
    }
}
