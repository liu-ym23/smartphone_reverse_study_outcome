package com.ctc.wstx.g;

import com.ctc.wstx.d.y;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import javax.xml.namespace.NamespaceContext;
import javax.xml.namespace.QName;
import javax.xml.stream.XMLStreamException;
import org.apache.logging.log4j.message.ParameterizedMessage;

/* JADX INFO: loaded from: classes2.dex */
public final class e implements NamespaceContext, org.codehaus.stax2.validation.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final boolean f3516a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final b f3517b;
    protected final com.ctc.wstx.a.b c;
    protected f d;
    protected g e;
    protected int f;
    protected long g;
    protected final com.ctc.wstx.util.j h;
    protected d i;
    protected boolean j;
    protected org.codehaus.stax2.validation.g k;
    protected int l;
    protected String m;
    protected String n;
    protected String o;
    protected QName p;
    protected com.ctc.wstx.util.b q;
    protected d r;

    public e(com.ctc.wstx.a.b r5, boolean r6) {
        this.d = null;
        this.f = 0;
        this.g = 0;
        this.h = new com.ctc.wstx.util.j(64);
        this.j = false;
        this.k = null;
        this.l = -1;
        this.m = null;
        this.n = null;
        this.o = null;
        this.p = null;
        this.q = null;
        this.r = null;
        this.c = r5;
        this.f3516a = r6;
        this.f3517b = new b(r5, r6);
    }

    private void a(int r3, int r4) {
        throw new IllegalArgumentException("Illegal namespace index " + (r3 >> 1) + "; current scope only has " + (r4 >> 1) + " namespace declarations.");
    }

    @Override // org.codehaus.stax2.validation.b
    public int a(String r1, String r2, String r3, String r4) {
        return this.f3517b.a(r1, r2, r3, r4);
    }

    public final String a(int r4) {
        int r0 = this.i.e;
        int r1 = this.h.a() - r0;
        int r5 = r4 << 1;
        if (r5 < 0) goto L5;
        if (r5 >= r1) goto L5;
    L7:
        return this.h.a(r0 + r5);
    L5:
        a(r5 >> 1, r1 >> 1);
        goto L7
    }

    public org.codehaus.stax2.validation.g a(org.codehaus.stax2.validation.g r3) {
        if (this.k != null) goto L5;
        this.k = r3;
    L6:
        return r3;
    L5:
        this.k = new org.codehaus.stax2.validation.d(this.k, r3);
        goto L6
    }

    public void a(f r3) {
        this.d = (f) ZeusTransformUtils.wrapperContextForParams(r3, f.class, "com.obric.memorydata.plugin");
    }

    public final void a(com.ctc.wstx.util.l r1, boolean r2) {
        r1.a(this.k, r2);
    }

    public final void a(String r6, String r7) {
        int r0 = this.f + 1;
        this.f = r0;
        if (r0 > this.c.s()) goto L30;
        long r1 = this.g + 1;
        this.g = r1;
        if (r1 > this.c.t()) goto L28;
        d r2 = this.i;
        if (r2 != null) goto L9;
        String r3 = "";
    L10:
        d r4 = this.i;
        if (r4 == null) goto L19;
        r4.g++;
        int r5 = this.c.r();
        if (r5 <= 0) goto L19;
        if (this.i.g <= r5) goto L19;
        throw new XMLStreamException("Maximum Number of Child Elements limit (" + r5 + ") Exceeded");
    L19:
        d r8 = this.r;
        if (r8 != null) goto L22;
        r8 = new d(this.i, this.h.a(), r6, r7);
    L23:
        this.i = r8;
        this.i.d = r3;
        this.f3517b.a();
        g r9 = this.e;
        if (r9 == null) goto L31;
        this.j = r9.a(r6, r7);
        return;
    L31:
        return;
    L22:
        this.r = r8.f;
        r8.a(this.i, this.h.a(), r6, r7);
        goto L23
    L9:
        r3 = r2.d;
        goto L10
    L28:
        throw new XMLStreamException("Maximum Element Count limit (" + this.c.t() + ") Exceeded");
    L30:
        throw new XMLStreamException("Maximum Element Depth limit (" + this.c.s() + ") Exceeded");
    }

    @Override // org.codehaus.stax2.validation.b
    public void a(org.codehaus.stax2.validation.e r1) {
        this.d.a(r1);
    }

    public void a(org.codehaus.stax2.validation.g r3, g r4) {
        this.e = (g) ZeusTransformUtils.wrapperContextForParams(r4, g.class, "com.obric.memorydata.plugin");
        a(r3);
    }

    public boolean a() {
        org.codehaus.stax2.validation.g r0 = this.k;
        if (r0 != null) goto L7;
        return false;
    L7:
        if (ZeusTransformUtils.instanceOf(r0, y.class) == true) goto L11;
        return true;
    L11:
        return ((y) ZeusTransformUtils.preCheckCast(this.k, y.class, "com.obric.memorydata.plugin")).a();
    }

    public boolean a(String r4) {
        if (r4 != null) goto L4;
    L6:
        int r0 = this.i.e;
        int r1 = this.h.a();
    L7:
        if (r0 >= r1) goto L13;
        if (this.h.a(r0) == r4) goto L10;
        r0 = r0 + 2;
        goto L7
    L10:
        return true;
    L13:
        return false;
    L4:
        if (r4.length() != 0) goto L6;
        r4 = null;
        goto L6
    }

    public final b b() {
        return this.f3517b;
    }

    public final String b(int r4) {
        int r0 = this.i.e;
        int r1 = this.h.a() - r0;
        int r5 = r4 << 1;
        if (r5 < 0) goto L5;
        if (r5 >= r1) goto L5;
    L7:
        return this.h.a((r0 + r5) + 1);
    L5:
        a(r5 >> 1, r1 >> 1);
        goto L7
    }

    public void b(String r3, String r4) {
        if (r4 != null) goto L5;
    L6:
        r4 = null;
    L7:
        if (r3 != null) goto L9;
    L10:
        this.i.d = r4;
        r3 = null;
    L11:
        this.h.a(r3, r4);
        return;
    L9:
        if (r3.length() != 0) goto L11;
    L5:
        if (r4.length() != 0) goto L7;
        goto L6
    }

    public final boolean c() {
        d r0 = this.i;
        if (r0 == null) goto L12;
        this.f--;
        d r1 = r0.f;
        this.i = r1;
        r0.a(this.r);
        this.r = r0;
        int r3 = this.h.a() - r0.e;
        if (r3 <= 0) goto L7;
        this.q = null;
        this.h.b(r3);
    L7:
        if (r1 != null) goto L13;
        return false;
    L13:
        return true;
    L12:
        throw new IllegalStateException("Popping from empty stack");
    }

    public final boolean c(String r4, String r5) {
        if (this.f == 0) goto L24;
        String r0 = this.i.f3515b;
        if (r4 != null) goto L7;
    L13:
        if (r0 != null) goto L15;
    L17:
        String r3 = this.i.f3514a;
        if (r3 != r5) goto L20;
    L21:
        return true;
    L20:
        if (r3.equals(r5) == true) goto L21;
        return false;
    L15:
        if (r0.length() <= 0) goto L17;
        return false;
    L7:
        if (r4.length() == 0) goto L13;
        if (r0 == r4) goto L17;
        if (r4.equals(r0) == true) goto L17;
        return false;
    L24:
        throw new IllegalStateException("Illegal access, empty stack.");
    }

    public int d() {
        if (this.f == 0) goto L61;
        b r0 = this.f3517b;
        int r1 = r0.b();
        int r3 = 0;
        String r4 = "http://www.w3.org/XML/1998/namespace";
        if (r1 <= 0) goto L36;
        this.q = null;
        boolean r6 = this.c.h();
        int r7 = 0;
    L7:
        if (r7 >= r1) goto L36;
        a r8 = r0.a(r7, r6);
        String r9 = r8.c;
        String r10 = r8.f3508a;
        if (r10 != "xmlns") goto L11;
        this.d.e(com.ctc.wstx.b.a.f3450J);
    L34:
        r7 = r7 + 1;
        goto L7
    L11:
        if (r10 == "xml") goto L13;
        if (r9 != null) goto L17;
    L18:
        r9 = "";
    L19:
        if (r10 != null) goto L22;
        this.i.d = r9;
    L22:
        if (r6 == false) goto L28;
        if (r9 == "http://www.w3.org/XML/1998/namespace") goto L29;
        if (r9 == "http://www.w3.org/2000/xmlns/") goto L32;
    L33:
        this.h.a(r10, r9);
    L32:
        this.d.e(com.ctc.wstx.b.a.L);
    L29:
        this.d.a(com.ctc.wstx.b.a.K, r10, null);
        goto L33
    L28:
        if (r9.equals("http://www.w3.org/XML/1998/namespace") == true) goto L29;
        if (r9.equals("http://www.w3.org/2000/xmlns/") == false) goto L33;
    L17:
        if (r9.length() != 0) goto L19;
    L13:
        if ("http://www.w3.org/XML/1998/namespace".equals(r9) == true) goto L34;
        this.d.a(com.ctc.wstx.b.a.I, r9, null);
    L36:
        if (this.j == false) goto L38;
        this.e.a(this);
    L38:
        String r2 = this.i.f3515b;
        if (r2 != null) goto L41;
        r4 = this.i.d;
    L48:
        this.i.c = r4;
        int r5 = r0.a(this.d, this.h);
        this.l = r5;
        org.codehaus.stax2.validation.g r11 = this.k;
        if (r11 != null) goto L54;
        if (r5 < 0) goto L68;
        r0.a(r5);
        return 4;
    L68:
        return 4;
    L54:
        r11.a(this.i.f3514a, this.i.c, this.i.f3515b);
        int r12 = r0.c();
        if (r12 <= 0) goto L59;
    L56:
        if (r3 >= r12) goto L59;
        r0.a(r3, this.k);
        r3 = r3 + 1;
    L59:
        return this.k.b();
    L41:
        if (r2 == "xml") goto L48;
        r4 = this.h.a(r2);
        if (r4 != null) goto L46;
    L47:
        this.d.a(com.ctc.wstx.b.a.G, r2, null);
        goto L48
    L46:
        if (r4.length() != 0) goto L48;
    L61:
        throw new IllegalStateException("Calling validate() on empty stack.");
    }

    public int e() {
        org.codehaus.stax2.validation.g r0 = this.k;
        if (r0 != null) goto L6;
        return 4;
    L6:
        int r1 = r0.b(this.i.f3514a, this.i.c, this.i.f3515b);
        if (this.f != 1) goto L9;
        this.k.b(true);
    L9:
        return r1;
    }

    public final QName f() {
        if (this.f != 0) goto L6;
        return null;
    L6:
        String r0 = this.i.f3515b;
        if (r0 != null) goto L9;
        r0 = "";
    L9:
        String r1 = this.i.c;
        String r2 = this.i.f3514a;
        if (r2 == this.m) goto L15;
        this.m = r2;
    L12:
        this.n = r0;
    L13:
        this.o = r1;
        QName r3 = com.ctc.wstx.c.a.a(r1, r2, r0);
        this.p = r3;
        return r3;
    L15:
        if (r0 != this.n) goto L12;
        if (r1 != this.o) goto L13;
        return this.p;
    }

    @Override // org.codehaus.stax2.validation.b
    public javax.xml.stream.a g() {
        return this.d.getLocation();
    }

    @Override // javax.xml.namespace.NamespaceContext, org.codehaus.stax2.validation.b
    public final String getNamespaceURI(String r2) {
        if (r2 == null) goto L22;
        if (r2.length() != 0) goto L12;
        if (this.f != 0) goto L10;
        return "";
    L10:
        return this.i.d;
    L12:
        if (r2.equals("xml") == false) goto L16;
        return "http://www.w3.org/XML/1998/namespace";
    L16:
        if (r2.equals("xmlns") == false) goto L20;
        return "http://www.w3.org/2000/xmlns/";
    L20:
        return this.h.b(r2);
    L22:
        throw new IllegalArgumentException(com.ctc.wstx.b.a.n);
    }

    @Override // javax.xml.namespace.NamespaceContext
    public final String getPrefix(String r6) {
        if (r6 == null) goto L29;
        if (r6.length() == 0) goto L29;
        if (r6.equals("http://www.w3.org/XML/1998/namespace") == false) goto L10;
        return "xml";
    L10:
        if (r6.equals("http://www.w3.org/2000/xmlns/") == false) goto L13;
        return "xmlns";
    L13:
        String[] r0 = this.h.b();
        int r5 = this.h.a();
        int r1 = r5 - 1;
    L15:
        if (r1 <= 0) goto L35;
        if (r6.equals(r0[r1]) == false) goto L26;
        String r2 = r0[r1 - 1];
        int r3 = r1 + 1;
    L19:
        if (r3 >= r5) goto L24;
        if (r0[r3] == r2) goto L26;
        r3 = r3 + 2;
        goto L19
    L24:
        if (r2 != null) goto L27;
        return "";
    L27:
        return r2;
    L26:
        r1 = r1 - 2;
        goto L15
    L35:
        return null;
    L29:
        throw new IllegalArgumentException("Illegal to pass null/empty prefix as argument.");
    }

    @Override // javax.xml.namespace.NamespaceContext
    public final Iterator<String> getPrefixes(String r7) {
        if (r7 == null) goto L33;
        if (r7.length() == 0) goto L33;
        if (r7.equals("http://www.w3.org/XML/1998/namespace") == false) goto L11;
        String r6 = "xml";
    L9:
        return com.ctc.wstx.util.c.a(r6);
    L11:
        if (r7.equals("http://www.w3.org/2000/xmlns/") == false) goto L13;
        r6 = "xmlns";
        goto L9
    L13:
        String[] r0 = this.h.b();
        int r8 = this.h.a();
        ArrayList r1 = null;
        int r2 = r8 - 1;
    L14:
        if (r2 <= 0) goto L27;
        if (r7.equals(r0[r2]) == false) goto L26;
        String r3 = r0[r2 - 1];
        int r4 = r2 + 1;
    L18:
        if (r4 >= r8) goto L23;
        if (r0[r4] == r3) goto L26;
        r4 = r4 + 2;
        goto L18
    L23:
        if (r1 != null) goto L25;
        r1 = new ArrayList();
    L25:
        r1.add(r3);
    L26:
        r2 = r2 - 2;
        goto L14
    L27:
        if (r1 != null) goto L31;
        return com.ctc.wstx.util.c.b();
    L31:
        return r1.iterator();
    L33:
        throw new IllegalArgumentException("Illegal to pass null/empty prefix as argument.");
    }

    public final boolean h() {
        if (this.f != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final String i() {
        if (this.f == 0) goto L7;
        return this.i.c;
    L7:
        throw new IllegalStateException("Illegal access, empty stack.");
    }

    public final String j() {
        if (this.f == 0) goto L7;
        return this.i.f3515b;
    L7:
        throw new IllegalStateException("Illegal access, empty stack.");
    }

    public final String k() {
        if (this.f == 0) goto L7;
        return this.i.f3514a;
    L7:
        throw new IllegalStateException("Illegal access, empty stack.");
    }

    public final String l() {
        if (this.f == 0) goto L10;
        String r0 = this.i.f3514a;
        String r2 = this.i.f3515b;
        if (r2 != null) goto L8;
        return r0;
    L8:
        return r2 + ParameterizedMessage.ERROR_MSG_SEPARATOR + r0;
    L10:
        throw new IllegalStateException("Illegal access, empty stack.");
    }

    public final int m() {
        return (this.h.a() - this.i.e) >> 1;
    }
}
